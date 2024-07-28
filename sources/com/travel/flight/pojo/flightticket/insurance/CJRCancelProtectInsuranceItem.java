package com.travel.flight.pojo.flightticket.insurance;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCancelProtectInsuranceItem implements IJRDataModel {
    @b(a = "addon_type")
    private String addonType;
    @b(a = "icon")
    private String icon;
    @b(a = "insurance_id")
    private String insuranceId;
    @b(a = "insurance_type")
    private String insuranceType;
    @b(a = "opt_in")
    private boolean optIn;
    @b(a = "price_details")
    private ArrayList<CJRInsurancePriceDetail> priceDetails;
    @b(a = "review_display_text")
    private String reviewDisplayText;
    @b(a = "selection_options")
    private CJRFlightInsuranceSelectOptionFlight selectOption;
    @b(a = "tnc")
    private String tnc;
    @b(a = "tool_tip")
    private String toolTip;
    @b(a = "total_premium")
    private double totalPremium;

    public CJRFlightInsuranceSelectOptionFlight getSelectOption() {
        return this.selectOption;
    }

    public String getInsuranceType() {
        return this.insuranceType;
    }

    public String getInsuranceId() {
        return this.insuranceId;
    }

    public String getAddonType() {
        return this.addonType;
    }

    public String getIcon() {
        return this.icon;
    }

    public boolean isOptIn() {
        return this.optIn;
    }

    public void setOptIn(boolean z) {
        this.optIn = z;
    }

    public double getTotalPremium() {
        return this.totalPremium;
    }

    public String getToolTip() {
        return this.toolTip;
    }

    public String getTnc() {
        return this.tnc;
    }

    public String getReviewDisplayText() {
        return this.reviewDisplayText;
    }

    public ArrayList<CJRInsurancePriceDetail> getPriceDetails() {
        return this.priceDetails;
    }
}
