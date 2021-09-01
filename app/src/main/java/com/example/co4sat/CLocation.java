package com.example.co4sat;

import android.location.Location;

public class CLocation extends Location {

    private boolean bUseMetricUnits = false;

    public CLocation(Location location) {
        this(location, true);
    }
    public CLocation(Location location, boolean bUseMetricUnits) {
        super(location);
        this.bUseMetricUnits = bUseMetricUnits;
    }

    public boolean getUsesMetricUnits() {
        return this.bUseMetricUnits;
    }

    public void setUseMetricUnits(boolean bUseMetricUnits) {
        this.bUseMetricUnits = bUseMetricUnits;
    }

    @Override
    public float distanceTo(Location dest) {
        float nDistance = super.distanceTo(dest);

        if (!this.getUsesMetricUnits()) {
            //Convert m to ft
            nDistance = nDistance * 3.280838995013f;
        }
        return nDistance;
    }

    @Override
    public double getAltitude() {
        double nAltitude = super.getAltitude();

        if (!this.getUsesMetricUnits()) {
            //Convert m to ft
            nAltitude = nAltitude * 3.280838995013d;
        }
        return nAltitude;
    }

    @Override
    public float getSpeed() {
        float nSpeed = super.getSpeed() * 3.6f;

        if (!this.getUsesMetricUnits()) {
            //Convert m/sec to miles/hr
            nSpeed = super.getSpeed() * 2.23693629f;
        }
        return nSpeed;
    }

    @Override
    public float getAccuracy() {
        float nAccuravy = super.getAccuracy();

        if (!this.getUsesMetricUnits()) {
            //Convert m to ft
            nAccuravy = nAccuravy * 3.280838995013f;
        }
        return nAccuravy;
    }
}
