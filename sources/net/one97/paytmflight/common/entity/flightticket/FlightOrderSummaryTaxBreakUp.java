package net.one97.paytmflight.common.entity.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class FlightOrderSummaryTaxBreakUp implements IJRDataModel {
    private String key;
    private String text_type;
    private ArrayList<FlightOrderSummaryTaxBreakUpValue> value;
    private String value_type;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue_type() {
        return this.value_type;
    }

    public void setValue_type(String str) {
        this.value_type = str;
    }

    public String getText_type() {
        return this.text_type;
    }

    public void setText_type(String str) {
        this.text_type = str;
    }

    public ArrayList<FlightOrderSummaryTaxBreakUpValue> getValue() {
        return this.value;
    }

    public void setValue(ArrayList<FlightOrderSummaryTaxBreakUpValue> arrayList) {
        this.value = arrayList;
    }
}
