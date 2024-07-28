package net.one97.travelpass.model;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class TravelPassPromoVerifyBody extends IJRPaytmDataModel implements IJRDataModel {
    private String aggregate_item_price;
    private String conv_fee;
    private String count;
    private String customer_id;
    private String final_price;
    private String final_price_excl_shipping;
    private String need_shipping;
    private String order_total;
    private String paytm_cashback;
    private String paytm_discount;
    private String paytm_promocode;
    private String place_order_url;
    private String promofailuretext;
    private String promostatus;
    private String promotext;
    private String shipping_charges;
    private String site_id;

    public String getPaytm_promocode() {
        return this.paytm_promocode;
    }

    public void setPaytm_promocode(String str) {
        this.paytm_promocode = str;
    }

    public String getPromoText() {
        return this.promotext;
    }

    public String getOrder_total() {
        return this.order_total;
    }

    public void setOrder_total(String str) {
        this.order_total = str;
    }

    public String getFinal_price_excl_shipping() {
        return this.final_price_excl_shipping;
    }

    public void setFinal_price_excl_shipping(String str) {
        this.final_price_excl_shipping = str;
    }

    public String getAggregate_item_price() {
        return this.aggregate_item_price;
    }

    public void setAggregate_item_price(String str) {
        this.aggregate_item_price = str;
    }

    public String getPromostatus() {
        return this.promostatus;
    }

    public void setPromostatus(String str) {
        this.promostatus = str;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public String getFinal_price() {
        return this.final_price;
    }

    public void setFinal_price(String str) {
        this.final_price = str;
    }

    public String getPaytm_discount() {
        return this.paytm_discount;
    }

    public void setPaytm_discount(String str) {
        this.paytm_discount = str;
    }

    public String getPaytm_cashback() {
        return this.paytm_cashback;
    }

    public void setPaytm_cashback(String str) {
        this.paytm_cashback = str;
    }

    public String getSite_id() {
        return this.site_id;
    }

    public void setSite_id(String str) {
        this.site_id = str;
    }

    public String getConv_fee() {
        return this.conv_fee;
    }

    public void setConv_fee(String str) {
        this.conv_fee = str;
    }

    public String getShipping_charges() {
        return this.shipping_charges;
    }

    public void setShipping_charges(String str) {
        this.shipping_charges = str;
    }

    public String getPromofailuretext() {
        return this.promofailuretext;
    }

    public void setPromofailuretext(String str) {
        this.promofailuretext = str;
    }

    public String getNeed_shipping() {
        return this.need_shipping;
    }

    public void setNeed_shipping(String str) {
        this.need_shipping = str;
    }

    public String getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(String str) {
        this.customer_id = str;
    }

    public String getPlace_order_url() {
        return this.place_order_url;
    }

    public void setPlace_order_url(String str) {
        this.place_order_url = str;
    }
}
