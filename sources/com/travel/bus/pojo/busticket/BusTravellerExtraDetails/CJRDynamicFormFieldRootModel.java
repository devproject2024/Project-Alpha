package com.travel.bus.pojo.busticket.BusTravellerExtraDetails;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRDynamicFormFieldRootModel extends IJRPaytmDataModel {
    @c(a = "body")
    private CJRDynamicFormFieldModel body;

    public CJRDynamicFormFieldModel getbody() {
        return this.body;
    }
}
