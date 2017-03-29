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


import com.google.gson.Gson;
import org.energyplus.EnergyPlusClient;
import org.energyplus.WeatherData;
import org.junit.Test;

import java.util.TimeZone;

import static org.energyplus.EnergyPlusClient.Constants.HOURS_OF_MONTH_ACC;
import static org.junit.Assert.assertEquals;

public class EnergyPlusClientTest {

    @Test
    public void noop(){}

    @Test
    public void downloadAndUnzip() {
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(null);

        String url = "https://energyplus.net/weather-download/north_and_central_america_wmo_region_4/USA/NM/USA_NM_Albuquerque.Intl.AP.723650_TMY3/USA_NM_Albuquerque.Intl.AP.723650_TMY3.epw";
        WeatherData weatherData = EnergyPlusClient.toWeatherDataFromLink(url);

        System.out.println(new Gson().toJson(weatherData.getWeatherRawData().get(0)));
        System.out.println(new Gson().toJson(weatherData.getWeatherRawData().get(HOURS_OF_MONTH_ACC[8]+12)));
        System.out.println(new Gson().toJson(weatherData.getWeatherRawData().get(8759)));

        assertEquals(EnergyPlusClient.toWeatherDataFromLink(url).getWeatherRawData().size(), 8760);
    }
}
