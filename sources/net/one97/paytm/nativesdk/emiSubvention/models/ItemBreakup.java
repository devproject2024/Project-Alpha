package net.one97.paytm.nativesdk.emiSubvention.models;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class ItemBreakup extends BaseModel {
    @c(a = "emi")
    @a
    private Double emi;
    @c(a = "gratifications")
    @a
    private List<Gratifications> gratifications = null;
    @c(a = "interest")
    @a
    private Integer interest;
    @c(a = "offerId")
    @a
    private String offerId;
    @c(a = "subventionType")
    @a
    private String subventionType;

    public Integer getInterest() {
        return this.interest;
    }

    public void setInterest(Integer num) {
        this.interest = num;
    }

    public String getOfferId() {
        return this.offerId;
    }

    public void setOfferId(String str) {
        this.offerId = str;
    }

    public Double getEmi() {
        return this.emi;
    }

    public void setEmi(Double d2) {
        this.emi = d2;
    }

    public String getSubventionType() {
        return this.subventionType;
    }

    public void setSubventionType(String str) {
        this.subventionType = str;
    }

    public List<Gratifications> getGratifications() {
        return this.gratifications;
    }

    public void setGratifications(List<Gratifications> list) {
        this.gratifications = list;
    }
}
