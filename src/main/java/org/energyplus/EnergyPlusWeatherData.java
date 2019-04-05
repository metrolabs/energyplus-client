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

import java.io.Serializable;

public class EnergyPlusWeatherData implements Serializable {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    /**
     * Data Source and Uncertainty Flags
     * Initial day of weather file is checked by EnergyPlus for validity (as shown below)
     * Each field is checked for "missing" as shown below. Reasonable values, calculated
     * values or the last "good" value is substituted.
     */
    private String dataSource;
    /**
     * Dry Bulb Temperature
     * Units: C
     * minimum: -70
     * maximum: 70
     * value when missing: >= 99
     */
    private Double dryBulbTemperature;
    /**
     * Dry Bulb Temperature
     * Units: C
     * minimum: -70
     * maximum: 70
     * value when missing: >= 99
     */
    private Double dewPointTemperature;
    /**
     * Relative Humidity
     * Units: None
     * minimum: 0
     * maximum: 110
     * value when missing: >= 999
     */
    private Double relativeHumidity;
    /**
     * Atmospheric Station Pressure
     * Units: Pa
     * minimum: 31000
     * maximum: 120000
     * value when missing: >= 999999
     */
    private Double atmosphericStationPressure;
    /**
     * Extraterrestrial Horizontal Radiation
     * Units: Wh/m2
     * minimum: 0
     * maximum: unbound
     * value when missing: >= 9999
     */
    private Double extraterrestrialHorizontalRadiation;
    /**
     * Extraterrestrial Direct Normal Radiation
     * Units: Wh/m2
     * minimum: 0
     * maximum: unbound
     * value when missing: >= 9999
     */
    private Double extraterrestrialDirectNormalRadiation;
    /**
     * Horizontal Infrared Radiation Intensity
     * Units: Wh/m2
     * minimum: 0
     * maximum: unbound
     * value when missing: >= 9999
     */
    private Double horizontalInfraredRadiationIntensity;
    /**
     * Global Horizontal Radiation
     * Units: Wh/m2
     * minimum: 0
     * maximum: unbound
     * value when missing: >= 9999
     */
    private Double globalHorizontalRadiation;
    /**
     * Direct Normal Radiation
     * Units: Wh/m2
     * minimum: 0
     * maximum: unbound
     * value when missing: >= 9999
     */
    private Double directNormalRadiation;
    /**
     * Diffuse Horizontal Radiation
     * Units: Wh/m2
     * minimum: 0
     * maximum: unbound
     * value when missing: >= 9999
     */
    private Double diffuseHorizontalRadiation;
    /**
     * Global Horizontal Illuminance
     * Units: lux
     * minimum: 0
     * maximum: unbound
     * value when missing: >= 999900
     */
    private Double globalHorizontalIlluminance;
    /**
     * Diffuse Horizontal Illuminance
     * Units: Wh/m2
     * minimum: 0
     * maximum: unbound
     * value when missing: >= 999900
     */
    private Double diffuseHorizontalIlluminance;
    /**
     * Zenith Luminance
     * Units: Cd/m2
     * minimum: 0
     * maximum: unbound
     * value when missing: >= 9999
     */
    private Double zenithLuminance;
    /**
     * Wind Direction
     * Units: degrees
     * minimum: 0
     * maximum: 360
     * value when missing: >= 999
     */
    private Double windDirection;
    /**
     * Wind Speed
     * Units: m/s
     * minimum: 0
     * maximum: 40
     * value when missing: >= 999
     */
    private Double windSpeed;
    /**
     * Total Sky Cover
     * Units: None
     * minimum: 0
     * maximum: 10
     * value when missing: >= 99
     */
    private Double totalSkyCover;
    /**
     * Opaque Sky Cover (used if Horizontal IR Intensity missing)
     * Units: None
     * minimum: 0
     * maximum: 10
     * value when missing: >= 99
     */
    private Double opaqueSkyCover;
    /**
     * Visibility
     * Units: km
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: >= 9999
     */
    private Double visibility;
    /**
     * Ceiling Height
     * Units: m
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: >= 99999
     */
    private Double ceilingHeight;
    /**
     * Present Weather Observation
     * Units: None
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: None
     */
    private String presentWeatherObservation;
    /**
     * Present Weather Codes
     * Units: None
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: None
     */
    private String presentWeatherCodes;
    /**
     * Precipitable Water
     * Units: mm
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: >= 999
     */
    private Double precipitableWater;
    /**
     * Aerosol Optical Depth
     * Units: thousandths
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: .999
     */
    private Double aerosolOpticalDepth;
    /**
     * Snow Depth
     * Units: cm
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: >= 999
     */
    private Double snowDepth;
    /**
     * Days Since Last Snowfall
     * Units: None
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: 99
     */
    private Double daysSinceLastSnowfall;
    /**
     * Albedo
     * Units: None
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: 999
     */
    private Double albedo;
    /**
     * Liquid Precipitation Depth
     * Units: mm
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: 999
     */
    private Double liquidPrecipitationDepth;
    /**
     * Liquid Precipitation Quantity
     * Units: hr
     * minimum: Unbound
     * maximum: Unbound
     * value when missing: 99
     */
    private Double liquidPrecipitationQuantity;

    public int getYear() {
        return year;
    }

    public EnergyPlusWeatherData setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public EnergyPlusWeatherData setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public EnergyPlusWeatherData setDay(int day) {
        this.day = day;
        return this;
    }

    public int getHour() {
        return hour;
    }

    public EnergyPlusWeatherData setHour(int hour) {
        this.hour = hour;
        return this;
    }

    public int getMinute() {
        return minute;
    }

    public EnergyPlusWeatherData setMinute(int minute) {
        this.minute = minute;
        return this;
    }

    public String getDataSource() {
        return dataSource;
    }

    public EnergyPlusWeatherData setDataSource(String dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    public Double getDryBulbTemperature() {
        return dryBulbTemperature;
    }

    public EnergyPlusWeatherData setDryBulbTemperature(Double dryBulbTemperature) {
        this.dryBulbTemperature = dryBulbTemperature;
        return this;
    }

    public Double getDewPointTemperature() {
        return dewPointTemperature;
    }

    public EnergyPlusWeatherData setDewPointTemperature(Double dewPointTemperature) {
        this.dewPointTemperature = dewPointTemperature;
        return this;
    }

    public Double getRelativeHumidity() {
        return relativeHumidity;
    }

    public EnergyPlusWeatherData setRelativeHumidity(Double relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
        return this;
    }

    public Double getAtmosphericStationPressure() {
        return atmosphericStationPressure;
    }

    public EnergyPlusWeatherData setAtmosphericStationPressure(Double atmosphericStationPressure) {
        this.atmosphericStationPressure = atmosphericStationPressure;
        return this;
    }

    public Double getExtraterrestrialHorizontalRadiation() {
        return extraterrestrialHorizontalRadiation;
    }

    public EnergyPlusWeatherData setExtraterrestrialHorizontalRadiation(Double extraterrestrialHorizontalRadiation) {
        this.extraterrestrialHorizontalRadiation = extraterrestrialHorizontalRadiation;
        return this;
    }

    public Double getExtraterrestrialDirectNormalRadiation() {
        return extraterrestrialDirectNormalRadiation;
    }

    public EnergyPlusWeatherData setExtraterrestrialDirectNormalRadiation(Double extraterrestrialDirectNormalRadiation) {
        this.extraterrestrialDirectNormalRadiation = extraterrestrialDirectNormalRadiation;
        return this;
    }

    public Double getHorizontalInfraredRadiationIntensity() {
        return horizontalInfraredRadiationIntensity;
    }

    public EnergyPlusWeatherData setHorizontalInfraredRadiationIntensity(Double horizontalInfraredRadiationIntensity) {
        this.horizontalInfraredRadiationIntensity = horizontalInfraredRadiationIntensity;
        return this;
    }

    public Double getGlobalHorizontalRadiation() {
        return globalHorizontalRadiation;
    }

    public EnergyPlusWeatherData setGlobalHorizontalRadiation(Double globalHorizontalRadiation) {
        this.globalHorizontalRadiation = globalHorizontalRadiation;
        return this;
    }

    public Double getDirectNormalRadiation() {
        return directNormalRadiation;
    }

    public EnergyPlusWeatherData setDirectNormalRadiation(Double directNormalRadiation) {
        this.directNormalRadiation = directNormalRadiation;
        return this;
    }

    public Double getDiffuseHorizontalRadiation() {
        return diffuseHorizontalRadiation;
    }

    public EnergyPlusWeatherData setDiffuseHorizontalRadiation(Double diffuseHorizontalRadiation) {
        this.diffuseHorizontalRadiation = diffuseHorizontalRadiation;
        return this;
    }

    public Double getGlobalHorizontalIlluminance() {
        return globalHorizontalIlluminance;
    }

    public EnergyPlusWeatherData setGlobalHorizontalIlluminance(Double globalHorizontalIlluminance) {
        this.globalHorizontalIlluminance = globalHorizontalIlluminance;
        return this;
    }

    public Double getDiffuseHorizontalIlluminance() {
        return diffuseHorizontalIlluminance;
    }

    public EnergyPlusWeatherData setDiffuseHorizontalIlluminance(Double diffuseHorizontalIlluminance) {
        this.diffuseHorizontalIlluminance = diffuseHorizontalIlluminance;
        return this;
    }

    public Double getZenithLuminance() {
        return zenithLuminance;
    }

    public EnergyPlusWeatherData setZenithLuminance(Double zenithLuminance) {
        this.zenithLuminance = zenithLuminance;
        return this;
    }

    public Double getWindDirection() {
        return windDirection;
    }

    public EnergyPlusWeatherData setWindDirection(Double windDirection) {
        this.windDirection = windDirection;
        return this;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public EnergyPlusWeatherData setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public Double getTotalSkyCover() {
        return totalSkyCover;
    }

    public EnergyPlusWeatherData setTotalSkyCover(Double totalSkyCover) {
        this.totalSkyCover = totalSkyCover;
        return this;
    }

    public Double getOpaqueSkyCover() {
        return opaqueSkyCover;
    }

    public EnergyPlusWeatherData setOpaqueSkyCover(Double opaqueSkyCover) {
        this.opaqueSkyCover = opaqueSkyCover;
        return this;
    }

    public Double getVisibility() {
        return visibility;
    }

    public EnergyPlusWeatherData setVisibility(Double visibility) {
        this.visibility = visibility;
        return this;
    }

    public Double getCeilingHeight() {
        return ceilingHeight;
    }

    public EnergyPlusWeatherData setCeilingHeight(Double ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
        return this;
    }

    public String getPresentWeatherObservation() {
        return presentWeatherObservation;
    }

    public EnergyPlusWeatherData setPresentWeatherObservation(String presentWeatherObservation) {
        this.presentWeatherObservation = presentWeatherObservation;
        return this;
    }

    public String getPresentWeatherCodes() {
        return presentWeatherCodes;
    }

    public EnergyPlusWeatherData setPresentWeatherCodes(String presentWeatherCodes) {
        this.presentWeatherCodes = presentWeatherCodes;
        return this;
    }

    public Double getPrecipitableWater() {
        return precipitableWater;
    }

    public EnergyPlusWeatherData setPrecipitableWater(Double precipitableWater) {
        this.precipitableWater = precipitableWater;
        return this;
    }

    public Double getAerosolOpticalDepth() {
        return aerosolOpticalDepth;
    }

    public EnergyPlusWeatherData setAerosolOpticalDepth(Double aerosolOpticalDepth) {
        this.aerosolOpticalDepth = aerosolOpticalDepth;
        return this;
    }

    public Double getSnowDepth() {
        return snowDepth;
    }

    public EnergyPlusWeatherData setSnowDepth(Double snowDepth) {
        this.snowDepth = snowDepth;
        return this;
    }

    public Double getDaysSinceLastSnowfall() {
        return daysSinceLastSnowfall;
    }

    public EnergyPlusWeatherData setDaysSinceLastSnowfall(Double daysSinceLastSnowfall) {
        this.daysSinceLastSnowfall = daysSinceLastSnowfall;
        return this;
    }

    public Double getAlbedo() {
        return albedo;
    }

    public EnergyPlusWeatherData setAlbedo(Double albedo) {
        this.albedo = albedo;
        return this;
    }

    public Double getLiquidPrecipitationDepth() {
        return liquidPrecipitationDepth;
    }

    public EnergyPlusWeatherData setLiquidPrecipitationDepth(Double liquidPrecipitationDepth) {
        this.liquidPrecipitationDepth = liquidPrecipitationDepth;
        return this;
    }

    public Double getLiquidPrecipitationQuantity() {
        return liquidPrecipitationQuantity;
    }

    public EnergyPlusWeatherData setLiquidPrecipitationQuantity(Double liquidPrecipitationQuantity) {
        this.liquidPrecipitationQuantity = liquidPrecipitationQuantity;
        return this;
    }

    public static EnergyPlusWeatherData parse(String[] o) {
        return new EnergyPlusWeatherData()
                .setYear(Integer.parseInt(o[YEAR]))
                .setMonth(Integer.parseInt(o[MONTH]))
                .setDay(Integer.parseInt(o[DAY]))
                .setHour(Integer.parseInt(o[HOUR]))
                .setMinute(Integer.parseInt(o[MINUTE]))
                .setDataSource(o[DATA_SOURCE_AND_UNCERTAINTY_FLAGS])
                .setDryBulbTemperature(Double.parseDouble(o[DRY_BULB_TEMPERATURE]))
                .setDewPointTemperature(Double.parseDouble(o[DEW_POINT_TEMPERATURE]))
                .setRelativeHumidity(Double.parseDouble(o[RELATIVE_HUMIDITY]))
                .setAtmosphericStationPressure(Double.parseDouble(o[ATMOSPHERIC_STATION_PRESSURE]))
                .setExtraterrestrialHorizontalRadiation(Double.parseDouble(o[EXTRATERRESTRIAL_HORIZONTAL_RADIATION]))
                .setExtraterrestrialDirectNormalRadiation(Double.parseDouble(o[EXTRATERRESTRIAL_DIRECT_NORMAL_RADIATION]))
                .setHorizontalInfraredRadiationIntensity(Double.parseDouble(o[HORIZONTAL_INFRARED_RADIATION_INTENSITY]))
                .setGlobalHorizontalRadiation(Double.parseDouble(o[GLOBAL_HORIZONTAL_RADIATION]))
                .setDirectNormalRadiation(Double.parseDouble(o[DIRECT_NORMAL_RADIATION]))
                .setDiffuseHorizontalRadiation(Double.parseDouble(o[DIFFUSE_HORIZONTAL_RADIATION]))
                .setGlobalHorizontalIlluminance(Double.parseDouble(o[GLOBAL_HORIZONTAL_ILLUMINANCE]))
                .setDiffuseHorizontalIlluminance(Double.parseDouble(o[DIFFUSE_HORIZONTAL_ILLUMINANCE]))
                .setZenithLuminance(Double.parseDouble(o[ZENITH_LUMINANCE]))
                .setWindDirection(Double.parseDouble(o[WIND_DIRECTION]))
                .setWindSpeed(Double.parseDouble(o[WIND_SPEED]))
                .setTotalSkyCover(Double.parseDouble(o[TOTAL_SKY_COVER]))
                .setOpaqueSkyCover(Double.parseDouble(o[OPAQUE_SKY_COVER]))
                .setVisibility(Double.parseDouble(o[VISIBILITY]))
                .setCeilingHeight(Double.parseDouble(o[CEILING_HEIGH]))
                .setPresentWeatherObservation(o[PRESENT_WEATHER_OBSERVATION])
                .setPresentWeatherCodes(o[PRESENT_WEATHER_CODES])
                .setPrecipitableWater(Double.parseDouble(o[PRECIPITABLE_WATER]))
                .setAerosolOpticalDepth(Double.parseDouble(o[AEROSOL_OPTICAL_DEPTH]))
                .setSnowDepth(Double.parseDouble(o[SNOW_DEPTH]))
                .setDaysSinceLastSnowfall(Double.parseDouble(o[DAYS_SINCE_LAST_SNOWFALL]))
                .setAlbedo(Double.parseDouble(o[ALBEDO]))
                .setLiquidPrecipitationDepth(Double.parseDouble(o[LIQUID_PRECIPITATION_DEPTH]))
                .setLiquidPrecipitationQuantity(Double.parseDouble(o[LIQUID_PRECIPITATION_QUANTITY]));
    }

    public final static int YEAR = 0;
    public final static int MONTH = 1;
    public final static int DAY = 2;
    public final static int HOUR = 3;
    public final static int MINUTE = 4;
    public final static int DATA_SOURCE_AND_UNCERTAINTY_FLAGS = 5;
    public final static int DRY_BULB_TEMPERATURE = 6;
    public final static int DEW_POINT_TEMPERATURE = 7;
    public final static int RELATIVE_HUMIDITY = 8;
    public final static int ATMOSPHERIC_STATION_PRESSURE = 9;
    public final static int EXTRATERRESTRIAL_HORIZONTAL_RADIATION = 10;
    public final static int EXTRATERRESTRIAL_DIRECT_NORMAL_RADIATION = 11;
    public final static int HORIZONTAL_INFRARED_RADIATION_INTENSITY = 12;
    public final static int GLOBAL_HORIZONTAL_RADIATION = 13;
    public final static int DIRECT_NORMAL_RADIATION = 14;
    public final static int DIFFUSE_HORIZONTAL_RADIATION = 15;
    public final static int GLOBAL_HORIZONTAL_ILLUMINANCE = 16;
    public final static int DIRECT_NORMAL_ILLUMINANCE = 17;
    public final static int DIFFUSE_HORIZONTAL_ILLUMINANCE = 18;
    public final static int ZENITH_LUMINANCE = 19;
    public final static int WIND_DIRECTION = 20;
    public final static int WIND_SPEED = 21;
    public final static int TOTAL_SKY_COVER = 22;
    public final static int OPAQUE_SKY_COVER = 23;
    public final static int VISIBILITY = 24;
    public final static int CEILING_HEIGH = 25;
    public final static int PRESENT_WEATHER_OBSERVATION = 26;
    public final static int PRESENT_WEATHER_CODES = 27;
    public final static int PRECIPITABLE_WATER = 28;
    public final static int AEROSOL_OPTICAL_DEPTH = 29;
    public final static int SNOW_DEPTH = 30;
    public final static int DAYS_SINCE_LAST_SNOWFALL = 31;
    public final static int ALBEDO = 32;
    public final static int LIQUID_PRECIPITATION_DEPTH = 33;
    public final static int LIQUID_PRECIPITATION_QUANTITY = 34;
}
