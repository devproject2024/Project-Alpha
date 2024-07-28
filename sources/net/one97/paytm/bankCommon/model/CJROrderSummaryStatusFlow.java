package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryStatusFlow implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "color")
    private String mColor;
    @b(a = "disabled")
    private Boolean mDisabled;
    @b(a = "history")
    private ArrayList<CJROrderSummaryStatusFlowHistory> mHistory;
    @b(a = "id")
    private String mId;
    @b(a = "label")
    private String mLabel;
    @b(a = "strikeOut")
    private Boolean mStrikeOut;
    @b(a = "date")
    private String mdate;

    public ArrayList<CJROrderSummaryStatusFlowHistory> getHistory() {
        return this.mHistory;
    }

    public String getId() {
        return this.mId;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public Boolean getDisabled() {
        return this.mDisabled;
    }

    public Boolean getStrikeOut() {
        return this.mStrikeOut;
    }

    public String getColor() {
        return this.mColor;
    }

    public String getdate() {
        return this.mdate;
    }
}
