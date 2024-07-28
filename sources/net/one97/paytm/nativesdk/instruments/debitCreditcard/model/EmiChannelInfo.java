package net.one97.paytm.nativesdk.instruments.debitCreditcard.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.EmiAmount;
import net.one97.paytm.nativesdk.common.model.MaxAmount;
import net.one97.paytm.nativesdk.common.model.MinAmount;

public class EmiChannelInfo {
    private double doubleEmiPerMonth;
    @c(a = "emiAmount")
    @a
    private EmiAmount emiAmount;
    private String emiPerMonth;
    @c(a = "interestRate")
    @a
    private String interestRate;
    @c(a = "maxAmount")
    @a
    private MaxAmount maxAmount;
    @c(a = "minAmount")
    @a
    private MinAmount minAmount;
    @c(a = "ofMonths")
    @a
    private String ofMonths;
    @c(a = "planId")
    @a
    private String planId;

    public static EmiChannelInfo buildEmiChannelFromEmiValidation() {
        return null;
    }

    public String getPlanId() {
        return this.planId;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }

    public String getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(String str) {
        this.interestRate = str;
    }

    public String getOfMonths() {
        return this.ofMonths;
    }

    public void setOfMonths(String str) {
        this.ofMonths = str;
    }

    public MinAmount getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(MinAmount minAmount2) {
        this.minAmount = minAmount2;
    }

    public MaxAmount getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(MaxAmount maxAmount2) {
        this.maxAmount = maxAmount2;
    }

    public String getEmiPerMonth() {
        return this.emiPerMonth;
    }

    public EmiAmount getEmiAmount() {
        return this.emiAmount;
    }

    public void setEmiAmount(EmiAmount emiAmount2) {
        this.emiAmount = emiAmount2;
    }

    public void setEmiPerMonth(String str) {
        this.emiPerMonth = str;
    }

    public void calculateEmiPerMonth(String str, String str2) {
        DecimalFormat decimalFormat = new DecimalFormat(".00", new DecimalFormatSymbols(Locale.US));
        double effectAfterOfferAmount = SDKUtility.getEffectAfterOfferAmount(str) + SDKUtility.parseDouble(str2);
        double doubleValue = Double.valueOf(this.interestRate).doubleValue() / 1200.0d;
        double doubleValue2 = Double.valueOf(this.ofMonths).doubleValue();
        double d2 = effectAfterOfferAmount * doubleValue;
        double d3 = doubleValue + 1.0d;
        this.doubleEmiPerMonth = (d2 * Math.pow(d3, doubleValue2)) / (Math.pow(d3, doubleValue2) - 1.0d);
        if (!Double.isNaN(this.doubleEmiPerMonth)) {
            this.emiPerMonth = decimalFormat.format(this.doubleEmiPerMonth);
            return;
        }
        this.doubleEmiPerMonth = effectAfterOfferAmount / doubleValue2;
        this.emiPerMonth = decimalFormat.format(this.doubleEmiPerMonth);
    }

    public double getDoubleEmiPerMonth() {
        return this.doubleEmiPerMonth;
    }
}
