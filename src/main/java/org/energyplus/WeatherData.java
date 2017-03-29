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

import java.util.ArrayList;
import java.util.List;

public class WeatherData {
	
	private String station;
    private double latitude;
    private double longitude;
	private double timeZone;
    private double sigma;

    private List<WeatherRawData> weatherRawData;
    private List<WeatherRawData> weatherRawDataM;

    public WeatherData() {
        weatherRawData = new ArrayList<>(8760);
        weatherRawDataM = new ArrayList<>(12);
    }

	public WeatherData(String station, double latitude, double longitude, double timeZone, double sigma) {
        weatherRawData = new ArrayList<>(8760);
        weatherRawDataM = new ArrayList<>(12);

		this.station = station;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timeZone = timeZone;
		this.sigma = sigma;
	}

    public void setupMonthlyWeatherData() {
        for (int month = 1; month <= EnergyPlusClient.Constants.MONTH; month++) {
            weatherRawDataM.add(calcMonthlyWeatherData(month));
        }
    }

    public WeatherRawData calcYearlyWeatherData() {
        WeatherRawData weatherRawDataY = new WeatherRawData();

        double dryBulb = 0d;
        double gloHorzRad = 0d;
        double dirNormRad = 0d;
        double difHorzRad = 0d;
        double windSpd = 0d;
        double solarAltitude = 0d;
        double solarRadS = 0d;
        double solarRadSE = 0d;
        double solarRadE = 0d;
        double solarRadNE = 0d;
        double solarRadN = 0d;
        double solarRadNW = 0d;
        double solarRadW = 0d;
        double solarRadSW = 0d;

        for (WeatherRawData wrd : weatherRawDataM) {
            dryBulb += wrd.dryBulb;
            gloHorzRad += wrd.gloHorzRad;
            dirNormRad += wrd.dirNormRad;
            difHorzRad += wrd.difHorzRad;
            windSpd += wrd.windSpd;
            solarAltitude += wrd.solarAltitude;
            solarRadS += wrd.solarRad[0];
            solarRadSE += wrd.solarRad[1];
            solarRadE += wrd.solarRad[2];
            solarRadNE += wrd.solarRad[3];
            solarRadN += wrd.solarRad[4];
            solarRadNW += wrd.solarRad[5];
            solarRadW += wrd.solarRad[6];
            solarRadSW += wrd.solarRad[7];
        }

        weatherRawDataY.setDryBulb(dryBulb / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setGloHorzRad(gloHorzRad / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setDirNormRad(dirNormRad / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setDifHorzRad(difHorzRad / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setWindSpd(windSpd / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setSolarAltitude(solarAltitude / EnergyPlusClient.Constants.MONTH);

        weatherRawDataY.setSolarRadS(solarRadS / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setSolarRadSE(solarRadSE / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setSolarRadE(solarRadE / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setSolarRadNE(solarRadNE / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setSolarRadN(solarRadN / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setSolarRadNW(solarRadNW / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setSolarRadW(solarRadW / EnergyPlusClient.Constants.MONTH);
        weatherRawDataY.setSolarRadSW(solarRadSW / EnergyPlusClient.Constants.MONTH);

        return weatherRawDataY;
    }

    public WeatherRawData calcMonthlyWeatherData(int month) {
        WeatherRawData wrdM = null;

        if (month > 0 && month < 13) {
            wrdM = new WeatherRawData();

            int thisMonthHourNum = EnergyPlusClient.Constants.HOURS_OF_MONTH[month - 1];
            int startHour;
            int endHour;
            if (month == 1) {
                startHour = 0;
                endHour = EnergyPlusClient.Constants.HOURS_OF_MONTH_ACC[0];
            } else {
                startHour = EnergyPlusClient.Constants.HOURS_OF_MONTH_ACC[month - 2] + 1;
                endHour = EnergyPlusClient.Constants.HOURS_OF_MONTH_ACC[month - 1];
            }

            double dryBulb = 0d;
            double gloHorzRad = 0d;
            double dirNormRad = 0d;
            double difHorzRad = 0d;
            double windSpd = 0d;
            double solarAltitude = 0d;
            double solarRadS = 0d;
            double solarRadSE = 0d;
            double solarRadE = 0d;
            double solarRadNE = 0d;
            double solarRadN = 0d;
            double solarRadNW = 0d;
            double solarRadW = 0d;
            double solarRadSW = 0d;

            List<WeatherRawData> wrdList = weatherRawData.subList(startHour, endHour);

            for (WeatherRawData wrd : wrdList) {
                dryBulb += wrd.dryBulb;
                gloHorzRad += wrd.gloHorzRad;
                dirNormRad += wrd.dirNormRad;
                difHorzRad += wrd.difHorzRad;
                windSpd += wrd.windSpd;
                solarAltitude += wrd.solarAltitude;
                solarRadS += wrd.solarRad[0];
                solarRadSE += wrd.solarRad[1];
                solarRadE += wrd.solarRad[2];
                solarRadNE += wrd.solarRad[3];
                solarRadN += wrd.solarRad[4];
                solarRadNW += wrd.solarRad[5];
                solarRadW += wrd.solarRad[6];
                solarRadSW += wrd.solarRad[7];
            }

            wrdM.setMonth(month);
            wrdM.setDryBulb(dryBulb / thisMonthHourNum);
            wrdM.setGloHorzRad(gloHorzRad / thisMonthHourNum);
            wrdM.setDirNormRad(dirNormRad / thisMonthHourNum);
            wrdM.setDifHorzRad(difHorzRad / thisMonthHourNum);
            wrdM.setWindSpd(windSpd / thisMonthHourNum);
            wrdM.setSolarAltitude(solarAltitude / thisMonthHourNum);

            wrdM.setSolarRadS(solarRadS / thisMonthHourNum);
            wrdM.setSolarRadSE(solarRadSE / thisMonthHourNum);
            wrdM.setSolarRadE(solarRadE / thisMonthHourNum);
            wrdM.setSolarRadNE(solarRadNE / thisMonthHourNum);
            wrdM.setSolarRadN(solarRadN / thisMonthHourNum);
            wrdM.setSolarRadNW(solarRadNW / thisMonthHourNum);
            wrdM.setSolarRadW(solarRadW / thisMonthHourNum);
            wrdM.setSolarRadSW(solarRadSW / thisMonthHourNum);

        }
        return wrdM;
    }

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getTimeZone() {
		return timeZone;
	}

	public double getSigma() {
		return sigma;
	}

    public String getStation() {
       return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTimeZone(double timeZone) {
        this.timeZone = timeZone;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    public List<WeatherRawData> getWeatherRawData() {
        return weatherRawData;
    }

    public WeatherData addWeatherRawData(WeatherRawData w) {
        weatherRawData.add(w);
        return this;
    }

    public List<WeatherRawData> getWeatherRawDataM() {
        return weatherRawDataM;
    }

    public WeatherData addWeatherRawDataM(WeatherRawData w) {
        weatherRawDataM.add(w);
        return this;
    }
}
