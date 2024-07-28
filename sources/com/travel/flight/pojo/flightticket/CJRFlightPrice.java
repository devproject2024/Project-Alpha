package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightPrice implements Cloneable, IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "baggage")
    private String mBaggage;
    @b(a = "discounts")
    private CJRFlightPriceDiscounts mDiscounts;
    @b(a = "display_price")
    private String mDisplayPrice;
    @b(a = "price")
    private String mFlightCost;
    @b(a = "priceid")
    private String mFlightPriceId;
    @b(a = "hand_baggage_fare")
    private boolean mHandBaggageFare;
    @b(a = "onward_priceid")
    private String mOnwardPriceId;
    @b(a = "refundable")
    private boolean mRefundable;
    @b(a = "refundable_text")
    private String mRefundableText;
    @b(a = "return_priceid")
    private String mReturnPriceId;
    @b(a = "provider")
    private String mServiceProvider;

    public String getmDisplayPrice() {
        return this.mDisplayPrice;
    }

    public void setmDisplayPrice(String str) {
        this.mDisplayPrice = str;
    }

    public String getmFlightCost() {
        return this.mFlightCost;
    }

    public void setmFlightCost(String str) {
        this.mFlightCost = str;
    }

    public String getmServiceProvider() {
        return this.mServiceProvider;
    }

    public void setmServiceProvider(String str) {
        this.mServiceProvider = str;
    }

    public CJRFlightPrice clone() throws CloneNotSupportedException {
        return (CJRFlightPrice) super.clone();
    }

    public String getmBaggage() {
        return this.mBaggage;
    }

    public void setmBaggage(String str) {
        this.mBaggage = str;
    }

    public String getmFlightPriceId() {
        return this.mFlightPriceId;
    }

    public void setmFlightPriceId(String str) {
        this.mFlightPriceId = str;
    }

    public String getmOnwardPriceId() {
        return this.mOnwardPriceId;
    }

    public void setmOnwardPriceId(String str) {
        this.mOnwardPriceId = str;
    }

    public String getmReturnPriceId() {
        return this.mReturnPriceId;
    }

    public void setmReturnPriceId(String str) {
        this.mReturnPriceId = str;
    }

    public boolean ismHandBaggageFare() {
        return this.mHandBaggageFare;
    }

    public void setmHandBaggageFare(boolean z) {
        this.mHandBaggageFare = z;
    }

    public boolean ismRefundable() {
        return this.mRefundable;
    }

    public void setmRefundable(boolean z) {
        this.mRefundable = z;
    }

    public CJRFlightPriceDiscounts getmDiscounts() {
        return this.mDiscounts;
    }

    public String getmRefundableText() {
        return this.mRefundableText;
    }
}
