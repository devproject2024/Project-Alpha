package net.one97.paytm.common.entity.flightticket;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryTaxBreakUpFareDetails implements IJRDataModel {
    @c(a = "Central GST")
    private String CentralGST;
    private String Others;
    @c(a = "Passenger Service Fee")
    private String PassengerServiceFee;
    private String SGST;
    @c(a = "User Development Fee")
    private String UserDevelopmentFee;

    public String getOthers() {
        return this.Others;
    }

    public void setOthers(String str) {
        this.Others = str;
    }

    public String getUserDevelopmentFee() {
        return this.UserDevelopmentFee;
    }

    public void setUserDevelopmentFee(String str) {
        this.UserDevelopmentFee = str;
    }

    public String getCentralGST() {
        return this.CentralGST;
    }

    public void setCentralGST(String str) {
        this.CentralGST = str;
    }

    public String getSGST() {
        return this.SGST;
    }

    public void setSGST(String str) {
        this.SGST = str;
    }

    public String getPassengerServiceFee() {
        return this.PassengerServiceFee;
    }

    public void setPassengerServiceFee(String str) {
        this.PassengerServiceFee = str;
    }
}
