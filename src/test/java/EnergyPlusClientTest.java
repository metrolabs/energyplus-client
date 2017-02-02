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

import static org.junit.Assert.assertEquals;

public class EnergyPlusClientTest {

    @Test
    public void downloadAndUnzip() {
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(null);

        String url = "https://energyplus.net/weather-download/asia_wmo_region_2/IND//IND_Kota.424520_ISHRAE/IND_Kota.424520_ISHRAE.epw";
        WeatherData weatherData = EnergyPlusClient.toWeatherDataFromLink(url);

        System.out.println(new Gson().toJson(weatherData.weatherRawData.get(1700)));

        assertEquals(EnergyPlusClient.toWeatherDataFromLink(url).weatherRawData.size(), 8760);
    }
}
