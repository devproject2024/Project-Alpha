package com.business.merchant_payments.notificationsettings.model;

import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class AdditionalInfo {
    public final List<Info> info;
    public final String payMethod;

    public static /* synthetic */ AdditionalInfo copy$default(AdditionalInfo additionalInfo, String str, List<Info> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = additionalInfo.payMethod;
        }
        if ((i2 & 2) != 0) {
            list = additionalInfo.info;
        }
        return additionalInfo.copy(str, list);
    }

    public final String component1() {
        return this.payMethod;
    }

    public final List<Info> component2() {
        return this.info;
    }

    public final AdditionalInfo copy(String str, List<Info> list) {
        k.d(str, SDKConstants.PAY_METHOD);
        k.d(list, "info");
        return new AdditionalInfo(str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdditionalInfo)) {
            return false;
        }
        AdditionalInfo additionalInfo = (AdditionalInfo) obj;
        return k.a((Object) this.payMethod, (Object) additionalInfo.payMethod) && k.a((Object) this.info, (Object) additionalInfo.info);
    }

    public final int hashCode() {
        String str = this.payMethod;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Info> list = this.info;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "AdditionalInfo(payMethod=" + this.payMethod + ", info=" + this.info + ")";
    }

    public AdditionalInfo(String str, List<Info> list) {
        k.d(str, SDKConstants.PAY_METHOD);
        k.d(list, "info");
        this.payMethod = str;
        this.info = list;
    }

    public final String getPayMethod() {
        return this.payMethod;
    }

    public final List<Info> getInfo() {
        return this.info;
    }
}
