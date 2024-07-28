package com.travel.flight.pojo.flightticket.FareRules;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMessageKeyValue implements IJRDataModel {
    private ArrayList<CJRValueKeyValue> value;

    public ArrayList<CJRValueKeyValue> getValue() {
        return this.value;
    }
}
