package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Iterator;

public class CJRCart extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "billing_address")
    private CJRBillingAddress billingAddress;
    @b(a = "cashback_text")
    private String cashbackText;
    @b(a = "return_policy_display")
    private boolean displayReturnPolicy;
    @b(a = "gstin")
    private String gstinNumber;
    @b(a = "gstinfo")
    private GSTINData gstinfo;
    @b(a = "has_gstin")
    private boolean hasGstin;
    @b(a = "address")
    private CJRAddress mAddress;
    @b(a = "aggregate_item_price")
    private Double mAggregateItemPrice;
    @b(a = "cart_id")
    private String mCartId;
    @b(a = "cart_items")
    private ArrayList<CJRCartProduct> mCartItems;
    @b(a = "conv_fee")
    private String mConvFee;
    @b(a = "count")
    private int mCount;
    @b(a = "customer_id")
    private String mCustomerId;
    private CJRAddress mDefaultAddress;
    @b(a = "effective_price")
    private double mEffectivePrice;
    @b(a = "error")
    private String mError;
    @b(a = "error_code")
    private String mErrorCode;
    @b(a = "error_info")
    private String mErrorInfo;
    @b(a = "error_title")
    private String mErrorTitle;
    @b(a = "final_price")
    private String mFinalPrice;
    @b(a = "final_price_excl_shipping")
    private String mFinalPriceExclShipping;
    @b(a = "need_shipping")
    private boolean mNeedShipping;
    @b(a = "order_total")
    private String mOrderTotal;
    @b(a = "product_promise_logo_url")
    private String mPPLogoUrl;
    @b(a = "paytm_cashback")
    private String mPaytmCashBack = "0";
    @b(a = "paytm_discount")
    private String mPaytmDiscount;
    @b(a = "paytm_promocode")
    private String mPaytmPromocode;
    @b(a = "place_order_url")
    private String mPlaceOrderUrl;
    @b(a = "promocode")
    private String mPromoCode;
    @b(a = "promofailuretext")
    private String mPromoFailureText;
    @b(a = "promostatus")
    private String mPromoStatus;
    @b(a = "promotext")
    private String mPromoText;
    @b(a = "service_options")
    private boolean mServiceOption;
    @b(a = "shipping_charges")
    private String mShippingCharges;
    @b(a = "total_shipping_charges")
    private String mTotalShippingCharges;
    @b(a = "payment_method")
    private String paymentMethod;
    @b(a = "paytm_goldback")
    private String paytmGoldbback = "0";

    public CJRBillingAddress getBillingAddress() {
        return this.billingAddress;
    }

    public void setBillingAddress(CJRBillingAddress cJRBillingAddress) {
        this.billingAddress = cJRBillingAddress;
    }

    public boolean isHasGstin() {
        return this.hasGstin;
    }

    public void setHasGstin(boolean z) {
        this.hasGstin = z;
    }

    public String getGstinNumber() {
        return this.gstinNumber;
    }

    public void setGstinNumber(String str) {
        this.gstinNumber = str;
    }

    public String getmPPLogoUrl() {
        return this.mPPLogoUrl;
    }

    public Double getmAggregateItemPrice() {
        return this.mAggregateItemPrice;
    }

    public void setmAggregateItemPrice(Double d2) {
        this.mAggregateItemPrice = d2;
    }

    public String getPromoCode() {
        return this.mPromoCode;
    }

    public void setPromoCode(String str) {
        this.mPromoCode = str;
    }

    public String getPromoFailureText() {
        return this.mPromoFailureText;
    }

    public void setPromoFailureText(String str) {
        this.mPromoFailureText = str;
    }

    public boolean getNeedShipping() {
        return this.mNeedShipping;
    }

    public void setNeedShipping(boolean z) {
        this.mNeedShipping = z;
    }

    public int getCount() {
        return this.mCount;
    }

    public ArrayList<CJRCartProduct> getCartItems() {
        return this.mCartItems;
    }

    public CJRCartProduct getCartProduct(String str) {
        Iterator<CJRCartProduct> it2 = this.mCartItems.iterator();
        while (it2.hasNext()) {
            CJRCartProduct next = it2.next();
            if (next.getProductId() != null && next.getProductId().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public String getOrderTotal() {
        return this.mOrderTotal;
    }

    public void setOrderTotal(String str) {
        this.mOrderTotal = str;
    }

    public String getShippingCharges() {
        return this.mShippingCharges;
    }

    public String getPaytmCashBack() {
        return this.mPaytmCashBack;
    }

    public String getPaytmPromocode() {
        return this.mPaytmPromocode;
    }

    public String getPlaceOrderUrl() {
        return this.mPlaceOrderUrl;
    }

    public String getFinalPrice() {
        return this.mFinalPrice;
    }

    public void setFinalPrice(String str) {
        this.mFinalPrice = str;
    }

    public CJRAddress getAddress() {
        return this.mAddress;
    }

    public String getmCartId() {
        return this.mCartId;
    }

    public String getPromoText() {
        return this.mPromoText;
    }

    public String getPromoStatus() {
        return this.mPromoStatus;
    }

    public String getPaytmDiscount() {
        return this.mPaytmDiscount;
    }

    public String getFinalPriceExclShipping() {
        return this.mFinalPriceExclShipping;
    }

    public void setFinalPriceExclShipping(String str) {
        this.mFinalPriceExclShipping = str;
    }

    public String getError() {
        return this.mError;
    }

    public String getErrorTitle() {
        return this.mErrorTitle;
    }

    public String getErrorInfo() {
        return this.mErrorInfo;
    }

    public CJRAddress getmDefaultAddress() {
        return this.mDefaultAddress;
    }

    public void setmDefaultAddress(CJRAddress cJRAddress) {
        this.mDefaultAddress = cJRAddress;
    }

    public String getCustomerId() {
        return this.mCustomerId;
    }

    public String getConvFee() {
        return this.mConvFee;
    }

    public boolean isServiceOption() {
        return this.mServiceOption;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(String str) {
        this.mErrorCode = str;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String str) {
        this.paymentMethod = str;
    }

    public String getCashbackText() {
        return this.cashbackText;
    }

    public String getPaytmGoldback() {
        return this.paytmGoldbback;
    }

    public boolean displayReturnPolicy() {
        return this.displayReturnPolicy;
    }

    public void setCartItems(ArrayList<CJRCartProduct> arrayList) {
        this.mCartItems = arrayList;
    }

    public GSTINData getGstinfo() {
        return this.gstinfo;
    }

    public void setGstinfo(GSTINData gSTINData) {
        this.gstinfo = gSTINData;
    }

    public String getTotalShippingCharges() {
        return this.mTotalShippingCharges;
    }

    public void setmEffectivePrice(double d2) {
        this.mEffectivePrice = d2;
    }

    public double getmEffectivePrice() {
        return this.mEffectivePrice;
    }

    public void setmAddress(CJRAddress cJRAddress) {
        this.mAddress = cJRAddress;
    }
}
