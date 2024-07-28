package net.one97.paytm.common.entity;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class ContextResponse extends IJRPaytmDataModel {
    @c(a = "merchants")
    private ArrayList<Merchants> merchants;

    public ArrayList<Merchants> getMerchants() {
        return this.merchants;
    }

    public void setMerchants(ArrayList<Merchants> arrayList) {
        this.merchants = arrayList;
    }
}
