package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainFare extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "cp_breakup")
    private CJRCpBreakUp cpCharges;
    @b(a = "fare_breakup")
    private HashMap<String, String> mFareBreakUp;
    @b(a = "grand_total")
    private String mGrandTotal;
    @b(a = "irctc_service_fee")
    private String mIRCTC_Service_Fee;
    @b(a = "paytm_service_fee")
    private String mPaytm_Service_Fee;
    @b(a = "pg_charge")
    private String mPgCharge;
    @b(a = "total_collectible")
    private String mTotalCollectable;
    @b(a = "total_fare")
    private String mTotalFare;
    @b(a = "travelInsuranceCharge")
    private String mtravelInsuranceCharge;
    @b(a = "travelInsuranceServiceTax")
    private String mtravelInsuranceServiceTax;

    public String getGrandTotal() {
        return this.mGrandTotal;
    }

    public String getPgCharge() {
        return this.mPgCharge;
    }

    public String getMtravelInsuranceCharge() {
        return this.mtravelInsuranceCharge;
    }

    public String getMtravelInsuranceServiceTax() {
        return this.mtravelInsuranceServiceTax;
    }

    public String getTotalCollectable() {
        return this.mTotalCollectable;
    }

    public String getTotalFare() {
        return this.mTotalFare;
    }

    public HashMap<String, String> getFareBreakUp() {
        return this.mFareBreakUp;
    }

    public String getmIRCTC_Service_Fee() {
        return this.mIRCTC_Service_Fee;
    }

    public String getmPaytm_Service_Fee() {
        return this.mPaytm_Service_Fee;
    }

    public CJRCpBreakUp getCpCharges() {
        return this.cpCharges;
    }
}
