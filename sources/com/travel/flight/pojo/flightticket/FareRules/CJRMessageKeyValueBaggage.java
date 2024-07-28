package com.travel.flight.pojo.flightticket.FareRules;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMessageKeyValueBaggage implements IJRDataModel {
    private String key;
    private String value;

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
