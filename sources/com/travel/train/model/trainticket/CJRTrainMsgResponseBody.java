package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainMsgResponseBody extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "config")
    private CJRTrainMessagingConfig messagingConfig;
    @b(a = "notification_status_homepage")
    private String notificationStatusHomepage;
    @b(a = "notification_status_search")
    private String notificationStatusSearch;

    public String getNotificationStatusHomepage() {
        return this.notificationStatusHomepage;
    }

    public String getNotificationStatusSearch() {
        return this.notificationStatusSearch;
    }

    public CJRTrainMessagingConfig getConfig() {
        return this.messagingConfig;
    }
}
