package net.one97.paytm.o2o.movies.common.movies.booking;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.o;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.GSTINData;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRAddress;
import net.one97.paytm.common.entity.shopping.CJRBillingAddress;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.common.entity.shopping.CJROtherTaxes;
import net.one97.paytm.common.entity.shopping.CJRTaxData;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;

public class CJRMCart extends IJRPaytmDataModel implements IJRDataModel {
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
    private String mAggregateItemPrice;
    @b(a = "cart_id")
    private String mCartId;
    @b(a = "cart_items")
    private ArrayList<CJRCartProduct> mCartItems;
    @b(a = "conv_fee")
    private String mConvFee;
    @b(a = "count")
    private String mCount;
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
    @b(a = "tax_data")
    public CJRTaxData mTaxData;
    @b(a = "total_shipping_charges")
    private String mTotalShippingCharges;
    @b(a = "paymentInfo")
    public CJRPaymentInfo paymentInfo;
    @b(a = "payment_method")
    private String paymentMethod;
    @b(a = "payment_instruments")
    public o payment_instruments;
    @b(a = "paytm_goldback")
    private String paytmGoldbback = "0";
    @b(a = "paytm_pgcashback")
    private String paytmPGCashBack = "0";
    @b(a = "promoMetaData")
    public CJRPromoMetaData promoMetaData;
    @b(a = "total_other_taxes")
    ArrayList<CJROtherTaxes> totalOtherTaxes;

    public void setmPaytmPromocode(String str) {
        this.mPaytmPromocode = str;
    }

    public String getmPromoStatus() {
        return this.mPromoStatus;
    }

    public void setmPromoStatus(String str) {
        this.mPromoStatus = str;
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

    public void setPaytmDiscount(String str) {
        this.mPaytmDiscount = str;
    }

    public String getmPPLogoUrl() {
        return this.mPPLogoUrl;
    }

    public String getmAggregateItemPrice() {
        return this.mAggregateItemPrice;
    }

    public void setmAggregateItemPrice(String str) {
        this.mAggregateItemPrice = str;
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
        return Integer.parseInt(this.mCount);
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

    public String getPaytmPGCashBack() {
        return this.paytmPGCashBack;
    }

    public void setPaytmCashBack(String str) {
        this.mPaytmCashBack = str;
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

    public void setmPromoText(String str) {
        this.mPromoText = str;
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

    public ArrayList<CJRCartProduct> getCartItemsWithTrackingInfo() {
        if (this.mCartItems == null) {
            return null;
        }
        ArrayList<CJRCartProduct> arrayList = new ArrayList<>();
        Iterator<CJRCartProduct> it2 = this.mCartItems.iterator();
        while (it2.hasNext()) {
            CJRCartProduct next = it2.next();
            CJRCartProduct cJRCartProduct = new CJRCartProduct();
            if (next.getProductId() != null) {
                cJRCartProduct.setProductId(next.getProductId());
            }
            if (next.getTrackingInfo() != null) {
                cJRCartProduct.setTrackingInfo(next.getTrackingInfo());
            }
            arrayList.add(cJRCartProduct);
        }
        return arrayList;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(String str) {
        this.mErrorCode = str;
    }

    public CJRTaxData getTaxData() {
        return this.mTaxData;
    }

    public ArrayList<CJROtherTaxes> getTotalOtherTaxes() {
        return this.totalOtherTaxes;
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

    public CJPayMethodResponse getInstruments() {
        o oVar = this.payment_instruments;
        if (oVar == null) {
            return new CJPayMethodResponse();
        }
        return PaytmSDK.parsePaymentInstrument(oVar.toString());
    }
}
