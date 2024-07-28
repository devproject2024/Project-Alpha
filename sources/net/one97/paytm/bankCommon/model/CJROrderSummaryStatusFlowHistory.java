package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryStatusFlowHistory implements IJRDataModel {
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
