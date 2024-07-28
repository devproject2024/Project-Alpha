package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderSummaryStatus extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "status")
    private int status;
    @b(a = "status_actions")
    private ArrayList<CJRTrainPromoInfoStatusAction> statusActions = null;
    @b(a = "status_description")
    private String statusDescription;
    @b(a = "status_icon")
    private String statusIcon;
    @b(a = "status_text")
    private String statusText;

    public int getStatus() {
        return this.status;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public String getStatusIcon() {
        return this.statusIcon;
    }

    public String getStatusDescription() {
        return this.statusDescription;
    }

    public ArrayList<CJRTrainPromoInfoStatusAction> getStatusActions() {
        return this.statusActions;
    }
}
