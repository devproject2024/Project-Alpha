package com.business.merchant_payments.model.kyc;

import kotlin.g.b.k;

public final class Response {
    public final boolean active;
    public final Object amount;
    public final String businessType;
    public final int timeInterval;
    public final Object triggerAmount;
    public final int triggerFreq;
    public final String triggerMode;

    public static /* synthetic */ Response copy$default(Response response, boolean z, Object obj, String str, int i2, Object obj2, int i3, String str2, int i4, Object obj3) {
        if ((i4 & 1) != 0) {
            z = response.active;
        }
        if ((i4 & 2) != 0) {
            obj = response.amount;
        }
        Object obj4 = obj;
        if ((i4 & 4) != 0) {
            str = response.businessType;
        }
        String str3 = str;
        if ((i4 & 8) != 0) {
            i2 = response.timeInterval;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            obj2 = response.triggerAmount;
        }
        Object obj5 = obj2;
        if ((i4 & 32) != 0) {
            i3 = response.triggerFreq;
        }
        int i6 = i3;
        if ((i4 & 64) != 0) {
            str2 = response.triggerMode;
        }
        return response.copy(z, obj4, str3, i5, obj5, i6, str2);
    }

    public final boolean component1() {
        return this.active;
    }

    public final Object component2() {
        return this.amount;
    }

    public final String component3() {
        return this.businessType;
    }

    public final int component4() {
        return this.timeInterval;
    }

    public final Object component5() {
        return this.triggerAmount;
    }

    public final int component6() {
        return this.triggerFreq;
    }

    public final String component7() {
        return this.triggerMode;
    }

    public final Response copy(boolean z, Object obj, String str, int i2, Object obj2, int i3, String str2) {
        k.d(obj, "amount");
        k.d(str, "businessType");
        k.d(obj2, "triggerAmount");
        String str3 = str2;
        k.d(str3, "triggerMode");
        return new Response(z, obj, str, i2, obj2, i3, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Response)) {
            return false;
        }
        Response response = (Response) obj;
        return this.active == response.active && k.a(this.amount, response.amount) && k.a((Object) this.businessType, (Object) response.businessType) && this.timeInterval == response.timeInterval && k.a(this.triggerAmount, response.triggerAmount) && this.triggerFreq == response.triggerFreq && k.a((Object) this.triggerMode, (Object) response.triggerMode);
    }

    public final int hashCode() {
        boolean z = this.active;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        Object obj = this.amount;
        int i3 = 0;
        int hashCode = (i2 + (obj != null ? obj.hashCode() : 0)) * 31;
        String str = this.businessType;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.timeInterval) * 31;
        Object obj2 = this.triggerAmount;
        int hashCode3 = (((hashCode2 + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.triggerFreq) * 31;
        String str2 = this.triggerMode;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return hashCode3 + i3;
    }

    public final String toString() {
        return "Response(active=" + this.active + ", amount=" + this.amount + ", businessType=" + this.businessType + ", timeInterval=" + this.timeInterval + ", triggerAmount=" + this.triggerAmount + ", triggerFreq=" + this.triggerFreq + ", triggerMode=" + this.triggerMode + ")";
    }

    public Response(boolean z, Object obj, String str, int i2, Object obj2, int i3, String str2) {
        k.d(obj, "amount");
        k.d(str, "businessType");
        k.d(obj2, "triggerAmount");
        k.d(str2, "triggerMode");
        this.active = z;
        this.amount = obj;
        this.businessType = str;
        this.timeInterval = i2;
        this.triggerAmount = obj2;
        this.triggerFreq = i3;
        this.triggerMode = str2;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final Object getAmount() {
        return this.amount;
    }

    public final String getBusinessType() {
        return this.businessType;
    }

    public final int getTimeInterval() {
        return this.timeInterval;
    }

    public final Object getTriggerAmount() {
        return this.triggerAmount;
    }

    public final int getTriggerFreq() {
        return this.triggerFreq;
    }

    public final String getTriggerMode() {
        return this.triggerMode;
    }
}
