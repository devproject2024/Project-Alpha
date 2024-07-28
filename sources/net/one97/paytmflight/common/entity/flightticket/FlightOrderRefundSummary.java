package net.one97.paytmflight.common.entity.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class FlightOrderRefundSummary implements IJRDataModel {
    private String refund_summary_group_id;
    private String text;
    private ArrayList<FlightOrderRefundSummaryValue> value;

    public ArrayList<FlightOrderRefundSummaryValue> getValue() {
        return this.value;
    }

    public void setValue(ArrayList<FlightOrderRefundSummaryValue> arrayList) {
        this.value = arrayList;
    }

    public String getRefund_summary_group_id() {
        return this.refund_summary_group_id;
    }

    public void setRefund_summary_group_id(String str) {
        this.refund_summary_group_id = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }
}
