package net.one97.paytm.o2o.movies.common.movies.moviepass;

import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMPPrevalidateConfigModel implements IJRDataModel {
    private String conv_fee;
    private String customer_id;
    private String price;
    private String ty;

    public CJRMPPrevalidateConfigModel(String str, String str2, String str3, String str4) {
        this.price = str;
        this.ty = str2;
        this.conv_fee = str3;
        this.customer_id = str4;
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setPrice(String str) {
        this.price = str;
    }

    public final String getTy() {
        return this.ty;
    }

    public final void setTy(String str) {
        this.ty = str;
    }

    public final String getConv_fee() {
        return this.conv_fee;
    }

    public final void setConv_fee(String str) {
        this.conv_fee = str;
    }

    public final String getCustomer_id() {
        return this.customer_id;
    }

    public final void setCustomer_id(String str) {
        this.customer_id = str;
    }
}
