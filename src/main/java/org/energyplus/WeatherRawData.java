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

public class WeatherRawData {

	public int hour;
    public int hourOfYear;
	public int month;
	
	public double dryBulb;
	public double gloHorzRad;
	public double dirNormRad;
	public double difHorzRad;
	public double windSpd;
	public double solarAltitude;
    public double atmosphericPressure;
	public Double[] solarRad = new Double[8];
		
	
	public WeatherRawData(int hour, double dryBulb, double gloHorzRad,
                          double dirNormRad, double difHorzRad, double windSpd,
                          double solarRadS, double solarRadSE, double solarRadE,
                          double solarRadNE, double solarRadN, double solarRadNW,
                          double solarRadW, double solarRadSW, double solarAltitude, double atmosphericPressure)
    {
		this.hour = hour;
		this.dryBulb = dryBulb;
		this.gloHorzRad = gloHorzRad;
		this.dirNormRad = dirNormRad;
		this.difHorzRad = difHorzRad;
		this.windSpd = windSpd;
		this.solarRad[0] = solarRadS;
		this.solarRad[1] = solarRadSE;
		this.solarRad[2] = solarRadE;
		this.solarRad[3] = solarRadNE;
		this.solarRad[4] = solarRadN;
		this.solarRad[5] = solarRadNW;
		this.solarRad[6] = solarRadW;
		this.solarRad[7] = solarRadSW;
		this.solarAltitude =solarAltitude;
        this.atmosphericPressure = atmosphericPressure;
	}

	public WeatherRawData() {		
	}

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHourOfYear() {
        return hourOfYear;
    }

    public WeatherRawData setHourOfYear(int hourOfYear) {
        this.hourOfYear = hourOfYear;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }


    public double getDryBulb() {
        return dryBulb;
    }

    public void setDryBulb(double dryBulb) {
        this.dryBulb = dryBulb;
    }

    public double getGloHorzRad() {
        return gloHorzRad;
    }

    public void setGloHorzRad(double gloHorzRad) {
        this.gloHorzRad = gloHorzRad;
    }

    public double getDirNormRad() {
        return dirNormRad;
    }

    public void setDirNormRad(double dirNormRad) {
        this.dirNormRad = dirNormRad;
    }

    public double getDifHorzRad() {
        return difHorzRad;
    }

    public void setDifHorzRad(double difHorzRad) {
        this.difHorzRad = difHorzRad;
    }

    public double getWindSpd() {
        return windSpd;
    }

    public void setWindSpd(double windSpd) {
        this.windSpd = windSpd;
    }

    public double getSolarAltitude() {
        return solarAltitude;
    }

    public void setSolarAltitude(double solarAltitude) {
        this.solarAltitude = solarAltitude;
    }




    public double getSolarRadS() {
        return solarRad[0];
    }

    public void setSolarRadS(double solarRadS) {
        this.solarRad[0] = solarRadS;
    }

    public double getSolarRadSE() {
        return solarRad[1];
    }

    public void setSolarRadSE(double solarRadSE) {
        this.solarRad[1] = solarRadSE;
    }

    public double getSolarRadE() {
        return solarRad[2];
    }

    public void setSolarRadE(double solarRadE) {
        this.solarRad[2] = solarRadE;
    }

    public double getSolarRadNE() {
        return solarRad[3];
    }

    public void setSolarRadNE(double solarRadNE) {
        this.solarRad[3] = solarRadNE;
    }

    public double getSolarRadN() {
        return solarRad[4];
    }

    public void setSolarRadN(double solarRadN) {
        this.solarRad[4] = solarRadN;
    }

    public double getSolarRadNW() {
        return solarRad[5];
    }

    public void setSolarRadNW(double solarRadNW) {
        this.solarRad[5] = solarRadNW;
    }

    public double getSolarRadW() {
        return solarRad[6];
    }

    public void setSolarRadW(double solarRadW) {
        this.solarRad[6] = solarRadW;
    }

    public double getSolarRadSW() {
        return solarRad[7];
    }

    public void setSolarRadSW(double solarRadSW) {
        this.solarRad[7] = solarRadSW;
    }

    public double getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(double atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }
}
