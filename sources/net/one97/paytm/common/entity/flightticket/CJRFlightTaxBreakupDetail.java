package net.one97.paytm.common.entity.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightTaxBreakupDetail implements IJRDataModel {
    @b(a = "Fuel Surcharge")
    private double mFuelCharge;
    @b(a = "Krishi Kalyan Cess")
    private double mKrishiKalyanCess;
    @b(a = "Passenger Service Fare")
    private double mPassengerServiceFare;
    @b(a = "SVCT")
    private double mSvct;
    @b(a = "Swachh Bharat Cess")
    private double mSwachBharatCess;
    @b(a = "User Development Fee")
    private double mUserDevFee;

    public double getmSwachBharatCess() {
        return this.mSwachBharatCess;
    }

    public void setmSwachBharatCess(double d2) {
        this.mSwachBharatCess = d2;
    }

    public double getmUserDevFee() {
        return this.mUserDevFee;
    }

    public void setmUserDevFee(double d2) {
        this.mUserDevFee = d2;
    }

    public double getmPassengerServiceFare() {
        return this.mPassengerServiceFare;
    }

    public void setmPassengerServiceFare(double d2) {
        this.mPassengerServiceFare = d2;
    }

    public double getmFuelCharge() {
        return this.mFuelCharge;
    }

    public void setmFuelCharge(double d2) {
        this.mFuelCharge = d2;
    }

    public double getmKrishiKalyanCess() {
        return this.mKrishiKalyanCess;
    }

    public void setmKrishiKalyanCess(double d2) {
        this.mKrishiKalyanCess = d2;
    }

    public double getmSvct() {
        return this.mSvct;
    }

    public void setmSvct(double d2) {
        this.mSvct = d2;
    }
}
