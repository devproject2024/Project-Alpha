package net.one97.paytm.common.entity.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFareDetails implements IJRDataModel {
    @b(a = "irctc_service_fee")
    private String irctcServiceFee;
    @b(a = "travelInsuranceCharge")
    private String mtravelInsuranceCharge;
    @b(a = "travelInsuranceServiceTax")
    private String mtravelInsuranceServiceTax;
    @b(a = "paytm_service_fee")
    private String paytmServiceFee;
    @b(a = "pg_charge")
    private String pgCharge;
    @b(a = "total_collectible")
    private String totalCollectible;
    @b(a = "total_fare")
    private String totalFare;
    @b(a = "grand_total")
    private String tranGrandTotal;

    public String getMtravelInsuranceCharge() {
        return this.mtravelInsuranceCharge;
    }

    public void setMtravelInsuranceCharge(String str) {
        this.mtravelInsuranceCharge = str;
    }

    public String getMtravelInsuranceServiceTax() {
        return this.mtravelInsuranceServiceTax;
    }

    public void setMtravelInsuranceServiceTax(String str) {
        this.mtravelInsuranceServiceTax = str;
    }

    public String getTranGrandTotal() {
        return this.tranGrandTotal;
    }

    public String getTotalCollectible() {
        return this.totalCollectible;
    }

    public String getTotalFare() {
        return this.totalFare;
    }

    public String getIrctcServiceFee() {
        return this.irctcServiceFee;
    }

    public String getPaytmServiceFee() {
        return this.paytmServiceFee;
    }

    public String getPgCharge() {
        return this.pgCharge;
    }
}
