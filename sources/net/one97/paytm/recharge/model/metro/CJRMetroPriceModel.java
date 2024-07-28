package net.one97.paytm.recharge.model.metro;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMetroPriceModel implements IJRDataModel {
    private int code;
    @b(a = "expiry_time")
    private String expiryTime;
    private double fare;
    private boolean isSelected;
    private String label;
    @b(a = "no_of_trips")
    private int noOfTrips;
    private int registrationFee;
    private String reqType;
    private boolean selection;
    @b(a = "valid_for")
    private String validFor;

    public String getLabel() {
        return this.label;
    }

    public double getFare() {
        return this.fare;
    }

    public int getCode() {
        return this.code;
    }

    public boolean isSelection() {
        return this.selection;
    }

    public int getRegistrationFee() {
        return this.registrationFee;
    }

    public String getExpiryTime() {
        return this.expiryTime;
    }

    public int getNoOfTrips() {
        return this.noOfTrips;
    }

    public String getValidFor() {
        return this.validFor;
    }

    public String getReqType() {
        return this.reqType;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }
}
