package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRChooseSellerDelMode extends IJRPaytmDataModel {
    @b(a = "warehouse_list")
    private ArrayList<CJRPincodeCheck> mPincodeCheckAvail;

    public ArrayList<CJRPincodeCheck> getmPincodeCheckAvail() {
        return this.mPincodeCheckAvail;
    }
}
