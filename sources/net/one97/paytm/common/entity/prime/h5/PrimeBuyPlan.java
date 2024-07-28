package net.one97.paytm.common.entity.prime.h5;

import net.one97.paytm.common.entity.IJRDataModel;

public final class PrimeBuyPlan implements IJRDataModel {
    private String amount;
    private String amount_payable;
    private String plan_customer_text_button;
    private String plan_description;
    private String plan_id;
    private String plan_text;
    private String priority;
    private String storefront_url;

    public PrimeBuyPlan(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.plan_id = str;
        this.priority = str2;
        this.plan_text = str3;
        this.plan_description = str4;
        this.amount_payable = str5;
        this.amount = str6;
        this.plan_customer_text_button = str7;
        this.storefront_url = str8;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getAmount_payable() {
        return this.amount_payable;
    }

    public final String getPlan_customer_text_button() {
        return this.plan_customer_text_button;
    }

    public final String getPlan_description() {
        return this.plan_description;
    }

    public final String getPlan_id() {
        return this.plan_id;
    }

    public final String getPlan_text() {
        return this.plan_text;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final String getStorefront_url() {
        return this.storefront_url;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final void setAmount_payable(String str) {
        this.amount_payable = str;
    }

    public final void setPlan_customer_text_button(String str) {
        this.plan_customer_text_button = str;
    }

    public final void setPlan_description(String str) {
        this.plan_description = str;
    }

    public final void setPlan_id(String str) {
        this.plan_id = str;
    }

    public final void setPlan_text(String str) {
        this.plan_text = str;
    }

    public final void setPriority(String str) {
        this.priority = str;
    }

    public final void setStorefront_url(String str) {
        this.storefront_url = str;
    }
}
