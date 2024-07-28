package com.travel.bus.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class PincodeResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "body")
    PincodeBody mPincodeBody;

    public PincodeBody getPincodeBody() {
        return this.mPincodeBody;
    }

    public class PincodeBody extends IJRPaytmDataModel {
        @b(a = "cities")
        ArrayList<Cities> mCityList;
        @b(a = "state")
        private String mState;

        public PincodeBody() {
        }

        public String getState() {
            return this.mState;
        }

        public ArrayList<Cities> getCityList() {
            return this.mCityList;
        }
    }

    public class Cities extends IJRPaytmDataModel {
        @b(a = "name")
        private String mCityName;
        @b(a = "po_list")
        private ArrayList<String> mPostOfficeList;

        public Cities() {
        }

        public String getCityName() {
            return this.mCityName;
        }

        public ArrayList<String> getPostOfficeList() {
            return this.mPostOfficeList;
        }
    }
}
