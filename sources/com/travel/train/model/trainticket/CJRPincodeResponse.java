package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPincodeResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    CJRPincodeBody mPincodeBody;

    public CJRPincodeBody getPincodeBody() {
        return this.mPincodeBody;
    }

    public class CJRPincodeBody extends IJRPaytmDataModel {
        @b(a = "cities")
        ArrayList<CJRCities> mCityList;
        @b(a = "state")
        private String mState;

        public CJRPincodeBody() {
        }

        public String getState() {
            return this.mState;
        }

        public ArrayList<CJRCities> getCityList() {
            return this.mCityList;
        }
    }

    public class CJRCities extends IJRPaytmDataModel {
        @b(a = "name")
        private String mCityName;
        @b(a = "po_list")
        private ArrayList<String> mPostOfficeList;

        public CJRCities() {
        }

        public String getCityName() {
            return this.mCityName;
        }

        public ArrayList<String> getPostOfficeList() {
            return this.mPostOfficeList;
        }
    }
}
