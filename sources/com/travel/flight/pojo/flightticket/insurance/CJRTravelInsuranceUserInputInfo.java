package com.travel.flight.pojo.flightticket.insurance;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class CJRTravelInsuranceUserInputInfo extends IJRPaytmDataModel {
    @b(a = "default_insured_days")
    private String default_insured_days;
    @b(a = "header")
    private String header;
    @b(a = "max_days")
    private int max_days;
    @b(a = "min_days")
    private int min_days;
    @b(a = "premium_per_day")
    private double premium_per_day;
    private int selectedDays;
    @b(a = "title")
    private String title;

    public final String getHeader() {
        return this.header;
    }

    public final void setHeader(String str) {
        this.header = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final double getPremium_per_day() {
        return this.premium_per_day;
    }

    public final void setPremium_per_day(double d2) {
        this.premium_per_day = d2;
    }

    public final int getMax_days() {
        return this.max_days;
    }

    public final void setMax_days(int i2) {
        this.max_days = i2;
    }

    public final int getMin_days() {
        return this.min_days;
    }

    public final void setMin_days(int i2) {
        this.min_days = i2;
    }

    public final String getDefault_insured_days() {
        return this.default_insured_days;
    }

    public final void setDefault_insured_days(String str) {
        this.default_insured_days = str;
    }

    public CJRTravelInsuranceUserInputInfo(String str, String str2, double d2, int i2, int i3, String str3, int i4) {
        this.header = str;
        this.title = str2;
        this.premium_per_day = d2;
        this.max_days = i2;
        this.min_days = i3;
        this.default_insured_days = str3;
        this.selectedDays = i4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRTravelInsuranceUserInputInfo(String str, String str2, double d2, int i2, int i3, String str3, int i4, int i5, g gVar) {
        this(str, str2, d2, i2, i3, str3, (i5 & 64) != 0 ? 0 : i4);
    }

    public final int getSelectedDays() {
        return this.selectedDays;
    }

    public final void setSelectedDays(int i2) {
        this.selectedDays = i2;
    }
}
