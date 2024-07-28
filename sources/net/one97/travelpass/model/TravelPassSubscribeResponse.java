package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class TravelPassSubscribeResponse extends IJRPaytmDataModel {
    @b(a = "body")
    private final NotifyMeResponse body;
    @b(a = "code")
    private final int code;
    @b(a = "message")
    private final String message;

    public final String getMessage() {
        return this.message;
    }

    public final int getCode() {
        return this.code;
    }

    public final NotifyMeResponse getBody() {
        return this.body;
    }

    public static final class NotifyMeResponse extends IJRPaytmDataModel {
        @b(a = "error")
        private final String error;
        @b(a = "message")
        private final String message;
        @b(a = "status")
        private final String status;
        @b(a = "subscriptionButtonLabel")
        private final String subscriptionButtonLabel;
        @b(a = "subscriptionText")
        private final String subscriptionText;

        public final String getStatus() {
            return this.status;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getError() {
            return this.error;
        }

        public final String getSubscriptionText() {
            return this.subscriptionText;
        }

        public final String getSubscriptionButtonLabel() {
            return this.subscriptionButtonLabel;
        }
    }
}
