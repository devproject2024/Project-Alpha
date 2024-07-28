package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderStatus extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @com.google.gsonhtcfix.a.b(a = "status")
    private b mOrderStatus;
    @com.google.gsonhtcfix.a.b(a = "body")
    private c mOrderStatusBody;

    public class a {
        @com.google.gsonhtcfix.a.b(a = "status")

        /* renamed from: a  reason: collision with root package name */
        public String f27717a;
    }

    public class b {
    }

    public class c {
        @com.google.gsonhtcfix.a.b(a = "payment_status")

        /* renamed from: a  reason: collision with root package name */
        public a f27718a;
        @com.google.gsonhtcfix.a.b(a = "irctc_redirect")

        /* renamed from: b  reason: collision with root package name */
        public CJRIRCTCRedirect f27719b;
    }

    public b getOrderStatus() {
        return this.mOrderStatus;
    }

    public c getOrderStatusBody() {
        return this.mOrderStatusBody;
    }
}
