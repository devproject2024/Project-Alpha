package com.paytmmall.clpartifact.modal.cart;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;

public class CJRCart implements Serializable {
    @c(a = "billing_address")
    private CJRBillingAddress billingAddress;
    @c(a = "cashback_text")
    private String cashbackText;
    @c(a = "return_policy_display")
    private boolean displayReturnPolicy;
    @c(a = "effective_price")
    private double effectivePrice;
    @c(a = "gstin")
    private String gstinNumber;
    @c(a = "gstinfo")
    private GSTINData gstinfo;
    @c(a = "has_gstin")
    private boolean hasGstin;
    @c(a = "address")
    private CJRAddress mAddress;
    @c(a = "aggregate_item_price")
    private double mAggregateItemPrice;
    @c(a = "cart_id")
    private String mCartId;
    @c(a = "cart_items")
    private ArrayList<CJRCartItem> mCartItems;
    @c(a = "conv_fee")
    private int mConvFee;
    @c(a = "count")
    private int mCount;
    @c(a = "customer_id")
    private long mCustomerId;
    private CJRAddress mDefaultAddress;
    @c(a = "error")
    private String mError;
    @c(a = "error_code")
    private String mErrorCode;
    @c(a = "error_info")
    private String mErrorInfo;
    @c(a = "error_title")
    private String mErrorTitle;
    @c(a = "final_price")
    private double mFinalPrice;
    @c(a = "final_price_excl_shipping")
    private double mFinalPriceExclShipping;
    @c(a = "need_shipping")
    private boolean mNeedShipping;
    @c(a = "order_total")
    private double mOrderTotal;
    @c(a = "product_promise_logo_url")
    private String mPPLogoUrl;
    @c(a = "paytm_cashback")
    private double mPaytmCashBack;
    @c(a = "paytm_discount")
    private double mPaytmDiscount;
    @c(a = "paytm_promocode")
    private String mPaytmPromocode;
    @c(a = "place_order_url")
    private String mPlaceOrderUrl;
    @c(a = "promocode")
    private String mPromoCode;
    @c(a = "promofailuretext")
    private String mPromoFailureText;
    @c(a = "promostatus")
    private String mPromoStatus;
    @c(a = "promotext")
    private String mPromoText;
    @c(a = "service_options")
    private boolean mServiceOption;
    @c(a = "shipping_charges")
    private double mShippingCharges;
    @c(a = "mrp")
    private double mrp;
    @c(a = "payment_method")
    private String paymentMethod;
    @c(a = "paytm_goldback")
    private double paytmGoldbback;
    @c(a = "paytm_voucher_benefits")
    private double paytmVoucherBenefits;
    @c(a = "site_id")
    private long siteId;
    @c(a = "total_exchange_amount")
    private double totalExchangeAmount;
    @c(a = "total_shipping_charges")
    private Double totalShippingCharges;

    public double getEffectivePrice() {
        return this.effectivePrice;
    }

    public void setEffectivePrice(double d2) {
        this.effectivePrice = d2;
    }

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

    public double getmAggregateItemPrice() {
        return this.mAggregateItemPrice;
    }

    public void setmAggregateItemPrice(double d2) {
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

    public double getPaytmCashBack() {
        return this.mPaytmCashBack;
    }

    public String getPaytmPromocode() {
        return this.mPaytmPromocode;
    }

    public String getPlaceOrderUrl() {
        return this.mPlaceOrderUrl;
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

    public double getFinalPriceExclShipping() {
        return this.mFinalPriceExclShipping;
    }

    public void setFinalPriceExclShipping(double d2) {
        this.mFinalPriceExclShipping = d2;
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

    public long getCustomerId() {
        return this.mCustomerId;
    }

    public int getConvFee() {
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

    public double getPaytmGoldback() {
        return this.paytmGoldbback;
    }

    public boolean displayReturnPolicy() {
        return this.displayReturnPolicy;
    }

    public GSTINData getGstinfo() {
        return this.gstinfo;
    }

    public void setGstinfo(GSTINData gSTINData) {
        this.gstinfo = gSTINData;
    }

    public void setmAddress(CJRAddress cJRAddress) {
        this.mAddress = cJRAddress;
    }

    public int getCount() {
        return this.mCount;
    }

    public void setCount(int i2) {
        this.mCount = i2;
    }

    public double getOrderTotal() {
        return this.mOrderTotal;
    }

    public void setOrderTotal(double d2) {
        this.mOrderTotal = d2;
    }

    public double getFinalPrice() {
        return this.mFinalPrice;
    }

    public void setFinalPrice(double d2) {
        this.mFinalPrice = d2;
    }

    public double getMrp() {
        return this.mrp;
    }

    public void setMrp(double d2) {
        this.mrp = d2;
    }

    public double getPaytmDiscount() {
        return this.mPaytmDiscount;
    }

    public void setPaytmDiscount(double d2) {
        this.mPaytmDiscount = d2;
    }

    public double getPaytmCashback() {
        return this.mPaytmCashBack;
    }

    public void setPaytmCashback(double d2) {
        this.mPaytmCashBack = d2;
    }

    public double getPaytmGoldCashback() {
        return this.paytmGoldbback;
    }

    public void setPaytmGoldCashback(double d2) {
        this.paytmGoldbback = d2;
    }

    public double getPaytmVoucherBenefits() {
        return this.paytmVoucherBenefits;
    }

    public void setPaytmVoucherBenefits(double d2) {
        this.paytmVoucherBenefits = d2;
    }

    public double getAggregateItemPrice() {
        return this.mAggregateItemPrice;
    }

    public void setAggregateItemPrice(double d2) {
        this.mAggregateItemPrice = d2;
    }

    public double getTotalExchangeAmount() {
        return this.totalExchangeAmount;
    }

    public void setTotalExchangeAmount(double d2) {
        this.totalExchangeAmount = d2;
    }

    public String getPlaceOrderURL() {
        return this.mPlaceOrderUrl;
    }

    public void setPlaceOrderURL(String str) {
        this.mPlaceOrderUrl = str;
    }

    public boolean isReturnPolicyDisplay() {
        return this.displayReturnPolicy;
    }

    public void setReturnPolicyDisplay(boolean z) {
        this.displayReturnPolicy = z;
    }

    public Double getTotalShippingCharges() {
        return this.totalShippingCharges;
    }

    public void setTotalShippingCharges(Double d2) {
        this.totalShippingCharges = d2;
    }

    public double getShippingCharges() {
        return this.mShippingCharges;
    }

    public void setShippingCharges(double d2) {
        this.mShippingCharges = d2;
    }

    public String getCartId() {
        return this.mCartId;
    }

    public void setCartId(String str) {
        this.mCartId = str;
    }

    public long getSiteId() {
        return this.siteId;
    }

    public void setSiteId(long j) {
        this.siteId = j;
    }

    public ArrayList<CJRCartItem> getCartItems() {
        return this.mCartItems;
    }

    public void setCartItems(ArrayList<CJRCartItem> arrayList) {
        this.mCartItems = arrayList;
    }
}
