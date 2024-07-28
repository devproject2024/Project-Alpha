package com.business.merchant_payments.model.kyc;

import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;

public final class BwFrequency {
    public final PaytmResultInfo paytmResultInfo;
    public final Response response;

    public static /* synthetic */ BwFrequency copy$default(BwFrequency bwFrequency, PaytmResultInfo paytmResultInfo2, Response response2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            paytmResultInfo2 = bwFrequency.paytmResultInfo;
        }
        if ((i2 & 2) != 0) {
            response2 = bwFrequency.response;
        }
        return bwFrequency.copy(paytmResultInfo2, response2);
    }

    public final PaytmResultInfo component1() {
        return this.paytmResultInfo;
    }

    public final Response component2() {
        return this.response;
    }

    public final BwFrequency copy(PaytmResultInfo paytmResultInfo2, Response response2) {
        k.d(paytmResultInfo2, "paytmResultInfo");
        k.d(response2, Payload.RESPONSE);
        return new BwFrequency(paytmResultInfo2, response2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BwFrequency)) {
            return false;
        }
        BwFrequency bwFrequency = (BwFrequency) obj;
        return k.a((Object) this.paytmResultInfo, (Object) bwFrequency.paytmResultInfo) && k.a((Object) this.response, (Object) bwFrequency.response);
    }

    public final int hashCode() {
        PaytmResultInfo paytmResultInfo2 = this.paytmResultInfo;
        int i2 = 0;
        int hashCode = (paytmResultInfo2 != null ? paytmResultInfo2.hashCode() : 0) * 31;
        Response response2 = this.response;
        if (response2 != null) {
            i2 = response2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "BwFrequency(paytmResultInfo=" + this.paytmResultInfo + ", response=" + this.response + ")";
    }

    public BwFrequency(PaytmResultInfo paytmResultInfo2, Response response2) {
        k.d(paytmResultInfo2, "paytmResultInfo");
        k.d(response2, Payload.RESPONSE);
        this.paytmResultInfo = paytmResultInfo2;
        this.response = response2;
    }

    public final PaytmResultInfo getPaytmResultInfo() {
        return this.paytmResultInfo;
    }

    public final Response getResponse() {
        return this.response;
    }
}
