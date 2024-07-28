package com.travel.flight.pojo.flightticket.FareRules;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFareRulesResponse extends IJRPaytmDataModel {
    private Body body;

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body2) {
        this.body = body2;
    }

    public class Body implements IJRDataModel {
        @b(a = "minirules")
        private CJRMIniRules minirules;

        public Body() {
        }

        public CJRMIniRules getMinirules() {
            return this.minirules;
        }

        public void setMinirules(CJRMIniRules cJRMIniRules) {
            this.minirules = cJRMIniRules;
        }
    }

    public class Additional_info implements IJRDataModel {
        private HandBaggage handbaggage;
        private MessageObj paytm_cancellation_charge;
        private MessageObj paytm_cancellation_window;
        private MessageObj paytm_modification_charge;
        private MessageObj paytm_modification_window;

        public Additional_info() {
        }

        public MessageObj getPaytm_cancellation_charge() {
            return this.paytm_cancellation_charge;
        }

        public MessageObj getPaytm_cancellation_window() {
            return this.paytm_cancellation_window;
        }

        public MessageObj getPaytm_modification_window() {
            return this.paytm_modification_window;
        }

        public MessageObj getPaytm_modification_charge() {
            return this.paytm_modification_charge;
        }

        public HandBaggage getHandbaggage() {
            return this.handbaggage;
        }
    }

    public class MessageObj implements IJRDataModel {
        private String message;

        public MessageObj() {
        }

        public String getMessage() {
            return this.message;
        }
    }

    public class HandBaggage implements IJRDataModel {
        private String message;

        public HandBaggage() {
        }

        public String getMessage() {
            return this.message;
        }
    }
}
