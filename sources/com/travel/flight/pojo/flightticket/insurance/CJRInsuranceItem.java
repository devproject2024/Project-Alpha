package com.travel.flight.pojo.flightticket.insurance;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInsuranceItem implements IJRDataModel {
    @b(a = "benefits")
    private ArrayList<CJRInsuranceBenefits> benefits;
    @b(a = "display_text")
    private String displayText;
    @b(a = "fare_per_traveller")
    private String farePerTraveller;
    @b(a = "header")
    private String header;
    @b(a = "insurance_id")
    private String insuranceId;
    @b(a = "insurance_provider")
    private String insuranceProvider;
    @b(a = "insurance_type")
    private String insuranceType;
    @b(a = "one_way_international")
    private boolean one_way_international;
    @b(a = "opt_in")
    private boolean optIn;
    @b(a = "opt_out_text")
    private String optOutText;
    @b(a = "price_details")
    private ArrayList<CJRInsurancePriceDetail> priceDetails;
    @b(a = "sub_text")
    private String sub_text;
    @b(a = "title")
    private String title;
    @b(a = "tnc")
    private String tnc;
    @b(a = "tnc_text")
    private String tnc_text;
    @b(a = "total_premium")
    private double totalPremium;
    @b(a = "userInputInfo")
    private CJRTravelInsuranceUserInputInfo userInputInfo;

    public String getInsuranceType() {
        return this.insuranceType;
    }

    public String getInsuranceId() {
        return this.insuranceId;
    }

    public String getInsuranceProvider() {
        return this.insuranceProvider;
    }

    public String getDisplayText() {
        return this.displayText;
    }

    public String getFarePerTraveller() {
        return this.farePerTraveller;
    }

    public String getTnc() {
        return this.tnc;
    }

    public void setTnc(String str) {
        this.tnc = str;
    }

    public boolean isOptIn() {
        return this.optIn;
    }

    public void setOptIn(boolean z) {
        this.optIn = z;
    }

    public String getOptOutText() {
        return this.optOutText;
    }

    public double getTotalPremium() {
        return this.totalPremium;
    }

    public ArrayList<CJRInsurancePriceDetail> getPriceDetails() {
        return this.priceDetails;
    }

    public ArrayList<CJRInsuranceBenefits> getBenefits() {
        return this.benefits;
    }

    public boolean isOne_way_international() {
        return this.one_way_international;
    }

    public CJRTravelInsuranceUserInputInfo getUserInputInfo() {
        return this.userInputInfo;
    }

    public String getHeader() {
        return this.header;
    }

    public String getSub_text() {
        return this.sub_text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTnc_text() {
        return this.tnc_text;
    }
}
