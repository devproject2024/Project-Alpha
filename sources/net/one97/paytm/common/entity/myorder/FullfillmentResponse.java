package net.one97.paytm.common.entity.myorder;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public final class FullfillmentResponse implements IJRDataModel {
    @b(a = "all_items_info")
    private String all_items_info;
    @b(a = "cancel_items_info")
    private String cancel_items_info;
    @b(a = "fulfillment_price")
    private double fulfillment_price;
    @b(a = "merchant_address")
    private String merchant_address;
    @b(a = "merchant_displayname")
    private String merchant_displayname;
    @b(a = "merchant_logo")
    private String merchant_logo;
    @b(a = "view_type")
    private String view_type;

    public final String getAll_items_info() {
        return this.all_items_info;
    }

    public final void setAll_items_info(String str) {
        this.all_items_info = str;
    }

    public final String getCancel_items_info() {
        return this.cancel_items_info;
    }

    public final void setCancel_items_info(String str) {
        this.cancel_items_info = str;
    }

    public final String getMerchant_logo() {
        return this.merchant_logo;
    }

    public final void setMerchant_logo(String str) {
        this.merchant_logo = str;
    }

    public final String getMerchant_displayname() {
        return this.merchant_displayname;
    }

    public final void setMerchant_displayname(String str) {
        this.merchant_displayname = str;
    }

    public final String getMerchant_address() {
        return this.merchant_address;
    }

    public final void setMerchant_address(String str) {
        this.merchant_address = str;
    }

    public final String getView_type() {
        return this.view_type;
    }

    public final void setView_type(String str) {
        this.view_type = str;
    }

    public final double getFulfillment_price() {
        return this.fulfillment_price;
    }

    public final void setFulfillment_price(double d2) {
        this.fulfillment_price = d2;
    }
}
