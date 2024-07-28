package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightSRPBody implements IJRDataModel {
    @b(a = "is_registered")
    private boolean isRegistered;
    @b(a = "maximum fare")
    private int maximumFare;
    @b(a = "minimum fare")
    private int minimumFare;
    @b(a = "registerable")
    private boolean registerable;

    public boolean getIsRegistered() {
        return this.isRegistered;
    }

    public void setIsRegistered(boolean z) {
        this.isRegistered = z;
    }

    public boolean getRegisterable() {
        return this.registerable;
    }

    public void setRegisterable(boolean z) {
        this.registerable = z;
    }

    public int getMinimumFare() {
        return this.minimumFare;
    }

    public void setMinimumFare(int i2) {
        this.minimumFare = i2;
    }

    public int getMaximumFare() {
        return this.maximumFare;
    }

    public void setMaximumFare(int i2) {
        this.maximumFare = i2;
    }
}
