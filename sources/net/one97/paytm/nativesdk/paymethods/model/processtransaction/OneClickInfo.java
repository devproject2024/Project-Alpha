package net.one97.paytm.nativesdk.paymethods.model.processtransaction;

import java.io.Serializable;
import kotlin.g.b.k;

public final class OneClickInfo implements Serializable {
    private String cardAlias;
    private String oneClickToken;

    public static /* synthetic */ OneClickInfo copy$default(OneClickInfo oneClickInfo, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = oneClickInfo.oneClickToken;
        }
        if ((i2 & 2) != 0) {
            str2 = oneClickInfo.cardAlias;
        }
        return oneClickInfo.copy(str, str2);
    }

    public final String component1() {
        return this.oneClickToken;
    }

    public final String component2() {
        return this.cardAlias;
    }

    public final OneClickInfo copy(String str, String str2) {
        return new OneClickInfo(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OneClickInfo)) {
            return false;
        }
        OneClickInfo oneClickInfo = (OneClickInfo) obj;
        return k.a((Object) this.oneClickToken, (Object) oneClickInfo.oneClickToken) && k.a((Object) this.cardAlias, (Object) oneClickInfo.cardAlias);
    }

    public final int hashCode() {
        String str = this.oneClickToken;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cardAlias;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "OneClickInfo(oneClickToken=" + this.oneClickToken + ", cardAlias=" + this.cardAlias + ")";
    }

    public OneClickInfo(String str, String str2) {
        this.oneClickToken = str;
        this.cardAlias = str2;
    }

    public final String getOneClickToken() {
        return this.oneClickToken;
    }

    public final void setOneClickToken(String str) {
        this.oneClickToken = str;
    }

    public final String getCardAlias() {
        return this.cardAlias;
    }

    public final void setCardAlias(String str) {
        this.cardAlias = str;
    }
}
