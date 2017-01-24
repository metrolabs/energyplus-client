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

public class EnergyPlusWeatherData {
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
        int index = 0;
        return new EnergyPlusWeatherData()
                .setYear(Integer.parseInt(o[index++]))
                .setMonth(Integer.parseInt(o[index++]))
                .setDay(Integer.parseInt(o[index++]))
                .setHour(Integer.parseInt(o[index++])-1)
                .setMinute(Math.max(0,Integer.parseInt(o[index++])-1))
                .setDataSource(o[index++])
                .setDryBulbTemperature(Double.parseDouble(o[index++]))
                .setDewPointTemperature(Double.parseDouble(o[index++]))
                .setRelativeHumidity(Double.parseDouble(o[index++]))
                .setAtmosphericStationPressure(Double.parseDouble(o[index++]))
                .setExtraterrestrialHorizontalRadiation(Double.parseDouble(o[index++]))
                .setExtraterrestrialDirectNormalRadiation(Double.parseDouble(o[index++]))
                .setHorizontalInfraredRadiationIntensity(Double.parseDouble(o[index++]))
                .setGlobalHorizontalRadiation(Double.parseDouble(o[index++]))
                .setDirectNormalRadiation(Double.parseDouble(o[index++]))
                .setDiffuseHorizontalRadiation(Double.parseDouble(o[index++]))
                .setGlobalHorizontalIlluminance(Double.parseDouble(o[index++]))
                .setDiffuseHorizontalIlluminance(Double.parseDouble(o[index++]))
                .setZenithLuminance(Double.parseDouble(o[index++]))
                .setWindDirection(Double.parseDouble(o[index++]))
                .setWindSpeed(Double.parseDouble(o[index++]))
                .setTotalSkyCover(Double.parseDouble(o[index++]))
                .setOpaqueSkyCover(Double.parseDouble(o[index++]))
                .setVisibility(Double.parseDouble(o[index++]))
                .setCeilingHeight(Double.parseDouble(o[index++]))
                .setPresentWeatherObservation(o[index++])
                .setPresentWeatherCodes(o[index++])
                .setPrecipitableWater(Double.parseDouble(o[index++]))
                .setAerosolOpticalDepth(Double.parseDouble(o[index++]))
                .setSnowDepth(Double.parseDouble(o[index++]))
                .setDaysSinceLastSnowfall(Double.parseDouble(o[index++]))
                .setAlbedo(Double.parseDouble(o[index++]))
                .setLiquidPrecipitationDepth(Double.parseDouble(o[index++]))
                .setLiquidPrecipitationQuantity(Double.parseDouble(o[index++]));
    }
}
