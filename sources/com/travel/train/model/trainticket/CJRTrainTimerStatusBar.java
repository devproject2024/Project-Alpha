package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTimerStatusBar extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "description")
    private String description;
    @b(a = "remaining_time")
    private String remainingTime;
    @b(a = "total_time")
    private String totalTime;

    public String getTotalTime() {
        return this.totalTime;
    }

    public String getRemainingTime() {
        return this.remainingTime;
    }

    public String getDescription() {
        return this.description;
    }
}
