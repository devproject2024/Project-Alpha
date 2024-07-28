package net.one97.paytm.nativesdk.emiSubvention.models;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.nativesdk.R;

public class PlanDetail extends BaseModel {
    @c(a = "effectivePrice")
    @a
    private Double effectivePrice;
    @c(a = "emi")
    @a
    private double emi;
    @c(a = "emiLabel")
    @a
    private String emiLabel;
    @c(a = "emiType")
    @a
    private String emiType;
    private String gratificationCashBack;
    @c(a = "gratifications")
    @a
    private List<Gratifications> gratifications = null;
    @c(a = "interest")
    @a
    private Double interest;
    @c(a = "interval")
    @a
    private Double interval;
    @c(a = "planId")
    @a
    private String planId;
    @c(a = "rate")
    @a
    private Double rate;

    public String getGratificationCashBack() {
        return this.gratificationCashBack;
    }

    public void setGratificationCashBack(Context context) {
        List<Gratifications> list = this.gratifications;
        if (list != null && list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.gratifications.size(); i2++) {
                if (this.gratifications.get(i2) != null) {
                    sb.append(getValue(context, this.gratifications.get(i2).getLabel(), this.gratifications.get(i2).getValue().intValue()));
                    if (i2 != this.gratifications.size() - 1 && !TextUtils.isEmpty(sb)) {
                        sb.append(" + ");
                    }
                }
            }
            this.gratificationCashBack = sb.toString();
        }
    }

    public String getPlanId() {
        return this.planId;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }

    public String getEmiType() {
        return this.emiType;
    }

    public void setEmiType(String str) {
        this.emiType = str;
    }

    public String getEmiLabel() {
        return this.emiLabel;
    }

    public void setEmiLabel(String str) {
        this.emiLabel = str;
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double d2) {
        this.rate = d2;
    }

    public Double getInterval() {
        return this.interval;
    }

    public void setInterval(Double d2) {
        this.interval = d2;
    }

    public double getEmi() {
        return this.emi;
    }

    public void setEmi(double d2) {
        this.emi = d2;
    }

    public Double getInterest() {
        return this.interest;
    }

    public void setInterest(Double d2) {
        this.interest = d2;
    }

    public Double getEffectivePrice() {
        return this.effectivePrice;
    }

    public void setEffectivePrice(Double d2) {
        this.effectivePrice = d2;
    }

    public List<Gratifications> getGratifications() {
        return this.gratifications;
    }

    public void setGratifications(List<Gratifications> list) {
        this.gratifications = list;
    }

    private String getValue(Context context, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return context.getString(R.string.rupee_symbol) + " " + i2 + " " + str;
    }
}
