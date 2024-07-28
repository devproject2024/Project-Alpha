package com.travel.bus.pojo.busticket.BusTravellerExtraDetails;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRDynamicFormFieldModel implements IJRDataModel {
    @c(a = "fields")
    private ArrayList<CJRBusTravellerExtraDetailsFieldModel> fields;

    public ArrayList<CJRBusTravellerExtraDetailsFieldModel> getFields() {
        return this.fields;
    }
}
