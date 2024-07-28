package com.travel.citybus.brts.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CitybusQrCode extends IJRPaytmDataModel {
    @b(a = "qrstrings")
    private List<String> qrstrings = null;

    public List<String> getQrstrings() {
        return this.qrstrings;
    }
}
