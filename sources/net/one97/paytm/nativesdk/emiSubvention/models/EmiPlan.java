package net.one97.paytm.nativesdk.emiSubvention.models;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class EmiPlan extends BaseModel {
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
    @c(a = "details")
    @a
    private List<PlanDetail> details = null;

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

    public List<PlanDetail> getDetails() {
        return this.details;
    }

    public void setDetails(List<PlanDetail> list) {
        this.details = list;
    }
}
