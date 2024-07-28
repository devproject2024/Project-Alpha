package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIRCTCUserAvailability extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "error")
    private String mError;
    @b(a = "body")
    private a mUserAvailabilityBody;

    public class a {
        @b(a = "userId")

        /* renamed from: a  reason: collision with root package name */
        public String f27701a;
        @b(a = "email")

        /* renamed from: b  reason: collision with root package name */
        public String f27702b;
        @b(a = "mobile")

        /* renamed from: c  reason: collision with root package name */
        public String f27703c;
    }

    public String getError() {
        return this.mError;
    }

    public a getUserAvailabilityBody() {
        return this.mUserAvailabilityBody;
    }
}
