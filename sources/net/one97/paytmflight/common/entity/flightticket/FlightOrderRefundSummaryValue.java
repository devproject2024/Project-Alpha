package net.one97.paytmflight.common.entity.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class FlightOrderRefundSummaryValue implements IJRDataModel {
    private String component_name;
    private ArrayList<FlightOrderRefundSummaryInLineMessage> inline_messages;
    private String key;
    private String message;
    private String strike_value;
    private String text_type;
    private String value;
    private String value_type;

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getComponent_name() {
        return this.component_name;
    }

    public void setComponent_name(String str) {
        this.component_name = str;
    }

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

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public ArrayList<FlightOrderRefundSummaryInLineMessage> getInline_messages() {
        return this.inline_messages;
    }

    public void setInline_messages(ArrayList<FlightOrderRefundSummaryInLineMessage> arrayList) {
        this.inline_messages = arrayList;
    }

    public String getStrike_value() {
        return this.strike_value;
    }

    public void setStrike_value(String str) {
        this.strike_value = str;
    }
}
