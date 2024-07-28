package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROrderSummaryStatusFlowHistory extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "date")
    private String mDate;
    @b(a = "message")
    private String mMessage;

    public String getStatusHistoryMessage() {
        return this.mMessage;
    }

    public String getStatusHistoryDate() {
        return this.mDate;
    }
}
