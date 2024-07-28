package com.travel.citybus.best.model;

public class BestEPurseRechargeParams {
    private Integer is_fast_forward;
    private String merchant_id;
    private String operation_type;
    private String pass_number;
    private String product_id;
    private Float total_amount;

    public String getMerchant_id() {
        return this.merchant_id;
    }

    public void setMerchant_id(String str) {
        this.merchant_id = str;
    }

    public String getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(String str) {
        this.product_id = str;
    }

    public Integer getIs_fast_forward() {
        return this.is_fast_forward;
    }

    public void setIs_fast_forward(Integer num) {
        this.is_fast_forward = num;
    }

    public Float getTotal_amount() {
        return this.total_amount;
    }

    public void setTotal_amount(Float f2) {
        this.total_amount = f2;
    }

    public String getOperation_type() {
        return this.operation_type;
    }

    public void setOperation_type(String str) {
        this.operation_type = str;
    }

    public String getPass_number() {
        return this.pass_number;
    }

    public void setPass_number(String str) {
        this.pass_number = str;
    }
}
