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

import org.energyplus.EnergyPlusClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnergyPlusClientTest {
    @Test
    public void downloadAndUnzip() {
        String url = "https://energyplus.net/weather-download/asia_wmo_region_2/IND//IND_Kota.424520_ISHRAE/IND_Kota.424520_ISHRAE.epw";
        assertEquals(EnergyPlusClient.toWeatherDataFromLink(url).weatherRawData.size(), 8760);
    }
}
