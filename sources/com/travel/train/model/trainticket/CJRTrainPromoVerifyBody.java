package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainPromoVerifyBody extends IJRPaytmDataModel implements IJRDataModel {
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

    public String getPromoText() {
        return this.promotext;
    }

    public String getOrder_total() {
        return this.order_total;
    }

    public String getFinal_price_excl_shipping() {
        return this.final_price_excl_shipping;
    }

    public String getAggregate_item_price() {
        return this.aggregate_item_price;
    }

    public String getPromostatus() {
        return this.promostatus;
    }

    public String getCount() {
        return this.count;
    }

    public String getFinal_price() {
        return this.final_price;
    }

    public String getPaytm_discount() {
        return this.paytm_discount;
    }

    public String getPaytm_cashback() {
        return this.paytm_cashback;
    }

    public String getSite_id() {
        return this.site_id;
    }

    public String getConv_fee() {
        return this.conv_fee;
    }

    public String getShipping_charges() {
        return this.shipping_charges;
    }

    public String getPromofailuretext() {
        return this.promofailuretext;
    }

    public String getNeed_shipping() {
        return this.need_shipping;
    }

    public String getCustomer_id() {
        return this.customer_id;
    }

    public String getPlace_order_url() {
        return this.place_order_url;
    }
}
