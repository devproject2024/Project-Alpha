package net.one97.paytm.common.entity.movies.moviepass;

import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMPTaxInfoModel implements IJRDataModel {
    private String totalCenterGstCharges;
    private String totalConvFee;
    private String totalPgCharges;
    private String totalStateGstCharges;

    public CJRMPTaxInfoModel(String str, String str2, String str3, String str4) {
        this.totalConvFee = str;
        this.totalPgCharges = str2;
        this.totalCenterGstCharges = str3;
        this.totalStateGstCharges = str4;
    }

    public final String getTotalConvFee() {
        return this.totalConvFee;
    }

    public final void setTotalConvFee(String str) {
        this.totalConvFee = str;
    }

    public final String getTotalPgCharges() {
        return this.totalPgCharges;
    }

    public final void setTotalPgCharges(String str) {
        this.totalPgCharges = str;
    }

    public final String getTotalCenterGstCharges() {
        return this.totalCenterGstCharges;
    }

    public final void setTotalCenterGstCharges(String str) {
        this.totalCenterGstCharges = str;
    }

    public final String getTotalStateGstCharges() {
        return this.totalStateGstCharges;
    }

    public final void setTotalStateGstCharges(String str) {
        this.totalStateGstCharges = str;
    }
}
