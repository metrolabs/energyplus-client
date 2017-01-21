/*
 * ________________________________________________________________________
 * METRO.IO CONFIDENTIAL
 * ________________________________________________________________________
 *
 * Copyright (c) 2017.
 * Metro Labs Incorporated
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains
 * the property of Metro Labs Incorporated and its suppliers,
 * if any. The intellectual and technical concepts contained
 * herein are proprietary to Metro Labs Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Metro Labs Incorporated.
 */

package org.energyplus;

import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EnergyPlusClient {
    private static Logger LOG = LoggerFactory.getLogger(EnergyPlusClient.class);

    public static WeatherData toWeatherDataFromDelimitedString(String payload) {
        WeatherData weatherData  = new WeatherData();
        WeatherRawData weatherHourly;
        weatherData.weatherRawData = new ArrayList<>();
        EnergyPlusWeatherData energyPlusWeatherData;

        try {
            CSVReader reader = new CSVReader(new StringReader(payload));
            String[] record;
            int row = 0, hourOfYear = 0;
            while((record = reader.readNext()) != null){
                if(row == 0){
                    System.out.println("Location: " + record[1]);
                    System.out.println("State: " + record[2]);
                    System.out.println("Type: " + record[4]);
                    System.out.println("setStation: " + record[5]);
                    System.out.println("setLatitude: " + record[6]);
                    System.out.println("setLongitude: " + record[7]);
                    System.out.println("setTimeZone: " + record[8]);

                    weatherData.setStation(record[5]);
                    weatherData.setLatitude(Double.parseDouble(record[6]));
                    weatherData.setLongitude(Double.parseDouble(record[7]));
                    weatherData.setTimeZone(Double.parseDouble(record[8]));
                    weatherData.setSigma(90);
                    row++;
                    continue;
                }

                if(row < 8){
                    row++;
                    continue;
                }

                energyPlusWeatherData = EnergyPlusWeatherData.parse(record);
                weatherHourly = new WeatherRawData();
                weatherHourly.setMonth(energyPlusWeatherData.getMonth());
                weatherHourly.setHour(energyPlusWeatherData.getHour());
                weatherHourly.setHourOfYear(Constants.getHourOfYear(hourOfYear));
                weatherHourly.setDryBulb(energyPlusWeatherData.getDryBulbTemperature());
                weatherHourly.setGloHorzRad(energyPlusWeatherData.getGlobalHorizontalRadiation());
                weatherHourly.setDirNormRad(energyPlusWeatherData.getDirectNormalRadiation());
                weatherHourly.setDifHorzRad(energyPlusWeatherData.getDiffuseHorizontalRadiation());
                weatherHourly.setWindSpd(energyPlusWeatherData.getWindSpeed());
                weatherHourly.setAtmosphericPressure(energyPlusWeatherData.getAtmosphericStationPressure());

                weatherHourly.setSolarRadS(Constants.calcSolarRad(weatherData, weatherHourly, 0, row - 1));
                weatherHourly.setSolarRadSE(Constants.calcSolarRad(weatherData, weatherHourly, -45, row - 1));
                weatherHourly.setSolarRadE(Constants.calcSolarRad(weatherData, weatherHourly, -90, row - 1));
                weatherHourly.setSolarRadNE(Constants.calcSolarRad(weatherData, weatherHourly, -135, row - 1));
                weatherHourly.setSolarRadN(Constants.calcSolarRad(weatherData, weatherHourly, 180, row - 1));
                weatherHourly.setSolarRadNW(Constants.calcSolarRad(weatherData, weatherHourly, 135, row - 1));
                weatherHourly.setSolarRadW(Constants.calcSolarRad(weatherData, weatherHourly, 90, row - 1));
                weatherHourly.setSolarRadSW(Constants.calcSolarRad(weatherData, weatherHourly, 45, row - 1));
                weatherHourly.setSolarAltitude(Constants.calcSolarAltitude(weatherData, row - 1));

                weatherData.weatherRawData.add(weatherHourly);
                hourOfYear++;
                row++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return weatherData;
    }

    public static WeatherData toWeatherDataFromLink(String link) {
        return toWeatherDataFromDelimitedString(getEnergyPlusWeatherData(link));
    }

    public static String getEnergyPlusWeatherData(String link) {

        try {
            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            conn.addRequestProperty("User-Agent", "Mozilla/4.0");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                return br.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
            LOG.error("Exception requesting data from Energy Plus Weather Data: [{}]", link);
        }

        return null;
    }

    public static class Constants {

        public static final int MONTH = 12;
        public static final double GROUND_REFLECTIVITY = 0.14;

        /*
         * number of hours of each month from 1 to 12 (total 12)
         */
        public static final Integer[] HOURS_OF_MONTH = {744, 672, 744, 720, 744, 720, 744, 744, 720, 744, 720, 744};

        /*
         * Accumulated number of hours of each month from 1 to 12 (total 12)
         */
        public static final Integer[] HOURS_OF_MONTH_ACC = {744, 1416, 2160, 2880, 3624, 4344, 5088, 5832, 6552, 7296, 8016, 8760};

        private static final LocalDateTime date = LocalDateTime.now(Clock.systemUTC()).withMonth(1).withDayOfMonth(1)
                .withHour(0).withMinute(0).withSecond(0);


        public static double calcSolarRad(WeatherData wd, WeatherRawData wrd, int ori, int hour) {
            return calcSolarRadSub(wd, wrd, ori, hour, wd.getSigma());
        }

        public static double calcSolarRadSub(WeatherData wd, WeatherRawData wrd, int ori, int hour, double sigma) {
            double solarRad;

            double lsm = wd.getTimeZone() * 15.0;
            double tao = 2.0 * Math.PI * (getDayOfYear(hour) - 1.0) / 365.0; // in minutes
            double et = 2.2918 * (0.0075 + 0.1868 * Math.cos(tao) - 3.2077
                    * Math.sin(tao) - 1.4615 * Math.cos(2.0 * tao) - 4.089 * Math.sin(2.0 * tao)); //equation of time
            double ast = getHourOfYear(hour) + et / 60.0 + (wd.getLongitude() - lsm) / 15.0; //apparent solar time
            double decli = 23.45 * Math.sin((getDayOfYear(hour) + 284.0) / 365.0 * 2.0 * Math.PI); // solar declination, deg
            double theta_h = 15.0 * (ast - 12.0); //hour_angle: angular displacement of the sun east or
            //west of the local meridian due to the rotation of the earth,deg
            double beta_s = Math.asin(Math.cos(wd.getLatitude() * Math.PI / 180.0)
                    * Math.cos(decli * Math.PI / 180.0) *
                    Math.cos(theta_h * Math.PI / 180.0) + Math.sin(wd.getLatitude()
                    * Math.PI / 180.0) * Math.sin(decli * Math.PI / 180.0)); //solar altitude, radians
            double beta_d = Math.toDegrees(beta_s); //solar altitude, degrees
            double sin_alpha_s = Math.sin(theta_h * Math.PI / 180.0)
                    * Math.cos(decli * Math.PI / 180.0) / Math.cos(beta_s); //sin(azimuth angle)
            double cos_alpha_s = (Math.cos(theta_h * Math.PI / 180.0)
                    * Math.cos(decli * Math.PI / 180.0) * Math.sin(wd.getLatitude() * Math.PI / 180.0)
                    - Math.sin(decli * Math.PI / 180.0) * Math.cos(wd.getLatitude() * Math.PI / 180.0))
                    / Math.cos(beta_s); // cos(azimuth angle)
            double alpha_s1 = Math.asin(sin_alpha_s) * 180.0 / Math.PI; // alpha_s1
            double alpha_s2 = Math.acos(cos_alpha_s) * 180.0 / Math.PI; // alpha_s2

            // alpha_s: solar azimuth in degree
            double alpha_s;
            if (sin_alpha_s > 0.0) {
                alpha_s = alpha_s2;
            } else if (cos_alpha_s > 0.0) {
                alpha_s = alpha_s1;
            } else {
                alpha_s = -180.0 - alpha_s1;
            }

            double gamma = Math.abs(alpha_s - ori); //surface-solar azimuth, >90: in shade
            double cos_theta = Math.cos(beta_s) * Math.cos(gamma * Math.PI / 180.0)
                    * Math.sin(sigma * Math.PI / 180.0)
                    + Math.sin(beta_s) * Math.cos(sigma * Math.PI / 180.0); //angle of incidence, angle between the incident beam and the surface's normal vector


            double beam_rad;
            if (gamma > 90 && gamma < 270) {
                beam_rad = 0.0;
            } else if (cos_theta < 0.0) {
                beam_rad = 0.0;
            } else {
                beam_rad = wrd.getDirNormRad() * cos_theta;
            }

            double dif_comp = Math.max(0.45,(0.55 + 0.437 * cos_theta + 0.313 * (cos_theta * cos_theta)));

            //diffuse radiation
            double dif_rad;
            if (sigma <= 90) {
                dif_rad = wrd.getDifHorzRad() * (dif_comp * Math.sin(sigma * Math.PI / 180.0)
                        + Math.cos(sigma * Math.PI / 180.0));
            } else {
                dif_rad = wrd.getDifHorzRad() * (dif_comp * Math.sin(sigma * Math.PI / 180.0));
            }

            //ground reflected radiation
            double ground_refl_rad = (wrd.getDirNormRad() * Math.sin(beta_s) + wrd.getDifHorzRad())
                    * GROUND_REFLECTIVITY * (1 - Math.cos(sigma * Math.PI / 180.0)) / 2.0;

            //total solar radiation by orientation
            solarRad = beam_rad+ dif_rad + ground_refl_rad;


            return solarRad;
        }

        public static double calcSolarAltitude(WeatherData wd, int hour){
            double lsm = wd.getTimeZone() * 15.0;
            double tao = 2.0 * Math.PI * (getDayOfYear(hour) - 1.0) / 365.0; // in minutes
            double et = 2.2918 * (0.0075 + 0.1868 * Math.cos(tao) - 3.2077
                    * Math.sin(tao) - 1.4615 * Math.cos(2.0 * tao) - 4.089 * Math.sin(2.0 * tao)); //equation of time
            double ast = getHourOfYear(hour) + et / 60.0 + (wd.getLongitude() - lsm) / 15.0; //apparent solar time
            double decli = 23.45 * Math.sin((getDayOfYear(hour) + 284.0) / 365.0 * 2.0 * Math.PI); // solar declination, deg
            double theta_h = 15.0 * (ast - 12.0); //hour_angle: angular displacement of the sun east or
            //west of the local meridian due to the rotation of the earth,deg
            double beta_s = Math.asin(Math.cos(wd.getLatitude() * Math.PI / 180.0)
                    * Math.cos(decli * Math.PI / 180.0) *
                    Math.cos(theta_h * Math.PI / 180.0) + Math.sin(wd.getLatitude()
                    * Math.PI / 180.0) * Math.sin(decli * Math.PI / 180.0)); //solar altitude, radians

            return Math.toDegrees(beta_s); //solar altitude, degrees
        }

        public static int getDayOfYear(int hour) {
            return date.plusHours(hour).getDayOfYear();
        }

        public static int getHourOfYear(int hour) {
            return date.plusHours(hour).getDayOfYear()*24;
        }
    }
}
