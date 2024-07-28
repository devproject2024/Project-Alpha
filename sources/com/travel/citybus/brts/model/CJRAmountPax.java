package com.travel.citybus.brts.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.brts.CJRBrtsRoute;

public class CJRAmountPax implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "amount")
    private double mAmount;
    @b(a = "pax")
    private String mPax;
    @b(a = "quantity")
    private int mQuantity;

    public static class CJRBCLLResponse implements IJRDataModel {
        @b(a = "city")
        private String city;
        @b(a = "displayMerchantName")
        private String mDisplayMerchantName;
        @b(a = "merchantName")
        private String mMerchantName;
        private String requestId;
        @b(a = "sourceInfoList")
        private ArrayList<CJRBrtsRoute> sourceInfoList;

        public void setRequestId(String str) {
            this.requestId = str;
        }

        public ArrayList<CJRBrtsRoute> getSourceInfoList() {
            return this.sourceInfoList;
        }

        public String getmMerchantName() {
            return this.mMerchantName;
        }

        public String getmDisplayMerchantName() {
            return this.mDisplayMerchantName;
        }

        public String getCity() {
            return this.city;
        }

        public void setCity(String str) {
            this.city = str;
        }
    }
}
