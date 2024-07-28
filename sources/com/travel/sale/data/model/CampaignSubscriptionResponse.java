package com.travel.sale.data.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CampaignSubscriptionResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private CampaignSubscriptionData body;
    @b(a = "code")
    private int code;
    @b(a = "message")
    private String message;
    @b(a = "status")
    private String status;

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }

    public CampaignSubscriptionData getBody() {
        return this.body;
    }

    public class CampaignSubscriptionData extends IJRPaytmDataModel {
        @b(a = "campaignName")
        private String campaignName;
        @b(a = "error")
        private String error;
        @b(a = "interestedCustomerCount")
        private long interestedCustomerCount;
        @b(a = "message")
        private String message;
        @b(a = "status")
        private String status;
        @b(a = "successfullySubscribedHeading")
        private String successfullySubscribedHeading;
        @b(a = "successfullySubscribedIconUrl")
        private String successfullySubscribedIconUrl;
        @b(a = "successfullySubscribedText")
        private String successfullySubscribedText;

        public CampaignSubscriptionData() {
        }

        public String getCampaignName() {
            return this.campaignName;
        }

        public String getSuccessfullySubscribedIconUrl() {
            return this.successfullySubscribedIconUrl;
        }

        public String getSuccessfullySubscribedHeading() {
            return this.successfullySubscribedHeading;
        }

        public String getSuccessfullySubscribedText() {
            return this.successfullySubscribedText;
        }

        public String getMessage() {
            return this.message;
        }

        public String getError() {
            return this.error;
        }

        public String getStatus() {
            return this.status;
        }

        public long getInterestedCustomerCount() {
            return this.interestedCustomerCount;
        }

        public void setInterestedCustomerCount(long j) {
            this.interestedCustomerCount = j;
        }
    }
}
