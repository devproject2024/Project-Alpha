package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPriceList implements IJRDataModel {
    @b(a = "combined_prices")
    private ArrayList<CJRFlightPrice> mCombinedPrices;
    @b(a = "onward_prices")
    private ArrayList<CJRFlightPrice> mOnwardPrices;
    @b(a = "return_prices")
    private ArrayList<CJRFlightPrice> mReturnPrices;

    public ArrayList<CJRFlightPrice> getmOnwardPrices() {
        return this.mOnwardPrices;
    }

    public void setmOnwardPrices(ArrayList<CJRFlightPrice> arrayList) {
        this.mOnwardPrices = arrayList;
    }

    public ArrayList<CJRFlightPrice> getmReturnPrices() {
        return this.mReturnPrices;
    }

    public void setmReturnPrices(ArrayList<CJRFlightPrice> arrayList) {
        this.mReturnPrices = arrayList;
    }

    public ArrayList<CJRFlightPrice> getmCombinedPrices() {
        return this.mCombinedPrices;
    }

    public void setmCombinedPrices(ArrayList<CJRFlightPrice> arrayList) {
        this.mCombinedPrices = arrayList;
    }
}
