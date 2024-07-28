package net.one97.paytm.common.entity.prime.userofferdetail;

import net.one97.paytm.common.entity.IJRDataModel;

public class Offers implements IJRDataModel {
    private String coupon_code;
    private String expiry_date;
    private String issue_date;
    private String max_usage_count;

    public String getCoupon_code() {
        return this.coupon_code;
    }

    public String getIssue_date() {
        return this.issue_date;
    }

    public String getExpiry_date() {
        return this.expiry_date;
    }

    public String getMax_usage_count() {
        return this.max_usage_count;
    }
}
