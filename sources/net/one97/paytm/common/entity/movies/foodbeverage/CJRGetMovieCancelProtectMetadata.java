package net.one97.paytm.common.entity.movies.foodbeverage;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGetMovieCancelProtectMetadata implements IJRDataModel {
    @c(a = "age")
    private Integer age;
    @c(a = "client_id")
    private Integer client_id;
    @c(a = "email_id")
    private String email_id;
    @c(a = "end_date_time")
    private String end_date_time;
    @c(a = "gender")
    private String gender;
    @c(a = "insurance_id")
    private Integer insurance_id;
    @c(a = "insured_item_price")
    private Double insured_item_price;
    @c(a = "max_claim_amount")
    private Double max_claim_amount;
    @c(a = "name")
    private String name;
    @c(a = "premium")
    private String premium;
    @c(a = "start_date_time")
    private String start_date_time;
    @c(a = "type")
    private String type;

    public Integer getClient_id() {
        return this.client_id;
    }

    public void setClient_id(Integer num) {
        this.client_id = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer num) {
        this.age = num;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getEmail_id() {
        return this.email_id;
    }

    public void setEmail_id(String str) {
        this.email_id = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Integer getInsurance_id() {
        return this.insurance_id;
    }

    public void setInsurance_id(Integer num) {
        this.insurance_id = num;
    }

    public String getPremium() {
        return this.premium;
    }

    public void setPremium(String str) {
        this.premium = str;
    }

    public Double getInsured_item_price() {
        return this.insured_item_price;
    }

    public void setInsured_item_price(Double d2) {
        this.insured_item_price = d2;
    }

    public Double getMax_claim_amount() {
        return this.max_claim_amount;
    }

    public void setMax_claim_amount(Double d2) {
        this.max_claim_amount = d2;
    }

    public String getStart_date_time() {
        return this.start_date_time;
    }

    public void setStart_date_time(String str) {
        this.start_date_time = str;
    }

    public String getEnd_date_time() {
        return this.end_date_time;
    }

    public void setEnd_date_time(String str) {
        this.end_date_time = str;
    }
}
