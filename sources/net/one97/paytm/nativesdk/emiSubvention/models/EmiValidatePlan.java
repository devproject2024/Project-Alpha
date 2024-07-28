package net.one97.paytm.nativesdk.emiSubvention.models;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class EmiValidatePlan extends BaseModel {
    @c(a = "bankCode")
    @a
    private String bankCode;
    @c(a = "bankLogoUrl")
    @a
    private String bankLogoUrl;
    @c(a = "bankName")
    @a
    private String bankName;
    @c(a = "cardType")
    @a
    private String cardType;
    @c(a = "emi")
    @a
    private Double emi;
    @c(a = "emiLabel")
    @a
    private String emiLabel;
    @c(a = "emiType")
    @a
    private String emiType;
    @c(a = "gratifications")
    @a
    private List<Gratifications> gratifications = null;
    @c(a = "interest")
    @a
    private Double interest;
    @c(a = "interval")
    @a
    private Integer interval;
    @c(a = "message")
    @a
    private String message;
    @c(a = "pgPlanId")
    @a
    private String pgPlanId;
    @c(a = "planId")
    @a
    private String planId;
    @c(a = "rate")
    @a
    private Double rate;
    @c(a = "status")
    @a
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String str) {
        this.bankCode = str;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public String getBankLogoUrl() {
        return this.bankLogoUrl;
    }

    public void setBankLogoUrl(String str) {
        this.bankLogoUrl = str;
    }

    public String getPlanId() {
        return this.planId;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }

    public double getRate() {
        return this.rate.doubleValue();
    }

    public void setRate(double d2) {
        this.rate = Double.valueOf(d2);
    }

    public Integer getInterval() {
        return this.interval;
    }

    public void setInterval(Integer num) {
        this.interval = num;
    }

    public double getEmi() {
        return this.emi.doubleValue();
    }

    public void setEmi(double d2) {
        this.emi = Double.valueOf(d2);
    }

    public double getInterest() {
        return this.interest.doubleValue();
    }

    public void setInterest(double d2) {
        this.interest = Double.valueOf(d2);
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

    public List<Gratifications> getGratifications() {
        return this.gratifications;
    }

    public void setGratifications(List<Gratifications> list) {
        this.gratifications = list;
    }

    public String getPgPlanId() {
        return this.pgPlanId;
    }

    public void setPgPlanId(String str) {
        this.pgPlanId = str;
    }
}
