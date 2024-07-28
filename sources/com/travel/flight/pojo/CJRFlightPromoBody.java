package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.travel.flight.pojo.flightticket.CJRFlightPaymentInfo;
import com.travel.flight.pojo.flightticket.CJRPromoMetaData;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;

public class CJRFlightPromoBody implements IJRDataModel {
    @a
    @b(a = "conv_fee")
    private Integer convFee;
    @a
    @b(a = "count")
    private Integer count;
    @a
    @b(a = "customer_id")
    private Integer customerId;
    @a
    @b(a = "final_price")
    private Integer finalPrice;
    @a
    @b(a = "final_price_excl_shipping")
    private Integer finalPriceExclShipping;
    @a
    @b(a = "need_shipping")
    private Boolean needShipping;
    @a
    @b(a = "order_total")
    private Integer orderTotal;
    @b(a = "paymentInfo")
    private CJRFlightPaymentInfo paymentInfo;
    @b(a = "payment_instruments")
    private CJPayMethodResponse payment_instruments;
    @a
    @b(a = "paytm_cashback")
    private double paytmCashback;
    @a
    @b(a = "paytm_discount")
    private double paytmDiscount;
    @a
    @b(a = "paytm_goldback")
    private double paytmGoldback;
    @a
    @b(a = "paytm_pgcashback")
    private double paytmPgcashback;
    @a
    @b(a = "paytm_promocode")
    private String paytmPromocode;
    @b(a = "promoMetaData")
    private CJRPromoMetaData promoMetaData;
    @a
    @b(a = "promofailuretext")
    private String promofailuretext;
    @a
    @b(a = "promostatus")
    private String promostatus;
    @a
    @b(a = "promotext")
    private String promotext;
    @a
    @b(a = "shipping_charges")
    private Integer shippingCharges;

    public int getPaytmGoldback() {
        return (int) this.paytmGoldback;
    }

    public String getPromofailuretext() {
        return this.promofailuretext;
    }

    public void setPromofailuretext(String str) {
        this.promofailuretext = str;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer num) {
        this.customerId = num;
    }

    public Boolean getNeedShipping() {
        return this.needShipping;
    }

    public void setNeedShipping(Boolean bool) {
        this.needShipping = bool;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public Integer getOrderTotal() {
        return this.orderTotal;
    }

    public void setOrderTotal(Integer num) {
        this.orderTotal = num;
    }

    public Integer getFinalPrice() {
        return this.finalPrice;
    }

    public void setFinalPrice(Integer num) {
        this.finalPrice = num;
    }

    public Integer getConvFee() {
        return this.convFee;
    }

    public void setConvFee(Integer num) {
        this.convFee = num;
    }

    public int getPaytmDiscount() {
        return (int) this.paytmDiscount;
    }

    public int getPaytmCashback() {
        return (int) this.paytmCashback;
    }

    public Integer getShippingCharges() {
        return this.shippingCharges;
    }

    public void setShippingCharges(Integer num) {
        this.shippingCharges = num;
    }

    public String getPaytmPromocode() {
        return this.paytmPromocode;
    }

    public void setPaytmPromocode(String str) {
        this.paytmPromocode = str;
    }

    public String getPromotext() {
        return this.promotext;
    }

    public void setPromotext(String str) {
        this.promotext = str;
    }

    public Integer getFinalPriceExclShipping() {
        return this.finalPriceExclShipping;
    }

    public void setFinalPriceExclShipping(Integer num) {
        this.finalPriceExclShipping = num;
    }

    public String getPromostatus() {
        return this.promostatus;
    }

    public void setPromostatus(String str) {
        this.promostatus = str;
    }

    public CJRPromoMetaData getPromoMetaData() {
        return this.promoMetaData;
    }

    public void setPromoMetaData(CJRPromoMetaData cJRPromoMetaData) {
        this.promoMetaData = cJRPromoMetaData;
    }

    public CJPayMethodResponse getPayment_instruments() {
        return this.payment_instruments;
    }

    public void setPayment_instruments(CJPayMethodResponse cJPayMethodResponse) {
        this.payment_instruments = cJPayMethodResponse;
    }

    public CJRFlightPaymentInfo getPaymentInfo() {
        return this.paymentInfo;
    }

    public void setPaymentInfo(CJRFlightPaymentInfo cJRFlightPaymentInfo) {
        this.paymentInfo = cJRFlightPaymentInfo;
    }

    public int getPaytmPgcashback() {
        return (int) this.paytmPgcashback;
    }
}
