package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIRCTCUserStatus extends IJRPaytmDataModel implements IJRDataModel {
    @com.google.gsonhtcfix.a.b(a = "status")
    private c mStatus;
    @com.google.gsonhtcfix.a.b(a = "body")
    private a mUserBody;

    public class a {
        @com.google.gsonhtcfix.a.b(a = "verified")

        /* renamed from: a  reason: collision with root package name */
        public String f27705a;
        @com.google.gsonhtcfix.a.b(a = "mobile")

        /* renamed from: b  reason: collision with root package name */
        public String f27706b;
        @com.google.gsonhtcfix.a.b(a = "email")

        /* renamed from: c  reason: collision with root package name */
        public String f27707c;
        @com.google.gsonhtcfix.a.b(a = "new_user")

        /* renamed from: d  reason: collision with root package name */
        public String f27708d;
    }

    public class b {
        @com.google.gsonhtcfix.a.b(a = "title")

        /* renamed from: a  reason: collision with root package name */
        public String f27709a;
        @com.google.gsonhtcfix.a.b(a = "message")

        /* renamed from: b  reason: collision with root package name */
        public String f27710b;
    }

    public class c {
        @com.google.gsonhtcfix.a.b(a = "result")

        /* renamed from: a  reason: collision with root package name */
        public String f27711a;
        @com.google.gsonhtcfix.a.b(a = "message")

        /* renamed from: b  reason: collision with root package name */
        public b f27712b;
    }

    public c getStatus() {
        return this.mStatus;
    }

    public a getUserBody() {
        return this.mUserBody;
    }
}
