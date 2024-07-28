package net.one97.paytm.games.model.pfg;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class LoyaltyTaskPushRequest {
    private String appCode;
    private String customerId;
    private String eventCode;
    private String gameLevel;
    private String gameName;
    private String msisdn;

    public static /* synthetic */ LoyaltyTaskPushRequest copy$default(LoyaltyTaskPushRequest loyaltyTaskPushRequest, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = loyaltyTaskPushRequest.customerId;
        }
        if ((i2 & 2) != 0) {
            str2 = loyaltyTaskPushRequest.msisdn;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = loyaltyTaskPushRequest.eventCode;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = loyaltyTaskPushRequest.appCode;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = loyaltyTaskPushRequest.gameName;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = loyaltyTaskPushRequest.gameLevel;
        }
        return loyaltyTaskPushRequest.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.customerId;
    }

    public final String component2() {
        return this.msisdn;
    }

    public final String component3() {
        return this.eventCode;
    }

    public final String component4() {
        return this.appCode;
    }

    public final String component5() {
        return this.gameName;
    }

    public final String component6() {
        return this.gameLevel;
    }

    public final LoyaltyTaskPushRequest copy(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "customerId");
        k.c(str2, "msisdn");
        k.c(str3, "eventCode");
        k.c(str4, "appCode");
        k.c(str5, "gameName");
        k.c(str6, "gameLevel");
        return new LoyaltyTaskPushRequest(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoyaltyTaskPushRequest)) {
            return false;
        }
        LoyaltyTaskPushRequest loyaltyTaskPushRequest = (LoyaltyTaskPushRequest) obj;
        return k.a((Object) this.customerId, (Object) loyaltyTaskPushRequest.customerId) && k.a((Object) this.msisdn, (Object) loyaltyTaskPushRequest.msisdn) && k.a((Object) this.eventCode, (Object) loyaltyTaskPushRequest.eventCode) && k.a((Object) this.appCode, (Object) loyaltyTaskPushRequest.appCode) && k.a((Object) this.gameName, (Object) loyaltyTaskPushRequest.gameName) && k.a((Object) this.gameLevel, (Object) loyaltyTaskPushRequest.gameLevel);
    }

    public final int hashCode() {
        String str = this.customerId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.msisdn;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.eventCode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.appCode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.gameName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.gameLevel;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "LoyaltyTaskPushRequest(customerId=" + this.customerId + ", msisdn=" + this.msisdn + ", eventCode=" + this.eventCode + ", appCode=" + this.appCode + ", gameName=" + this.gameName + ", gameLevel=" + this.gameLevel + ")";
    }

    public LoyaltyTaskPushRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "customerId");
        k.c(str2, "msisdn");
        k.c(str3, "eventCode");
        k.c(str4, "appCode");
        k.c(str5, "gameName");
        k.c(str6, "gameLevel");
        this.customerId = str;
        this.msisdn = str2;
        this.eventCode = str3;
        this.appCode = str4;
        this.gameName = str5;
        this.gameLevel = str6;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final void setCustomerId(String str) {
        k.c(str, "<set-?>");
        this.customerId = str;
    }

    public final String getMsisdn() {
        return this.msisdn;
    }

    public final void setMsisdn(String str) {
        k.c(str, "<set-?>");
        this.msisdn = str;
    }

    public final String getEventCode() {
        return this.eventCode;
    }

    public final void setEventCode(String str) {
        k.c(str, "<set-?>");
        this.eventCode = str;
    }

    public final String getAppCode() {
        return this.appCode;
    }

    public final void setAppCode(String str) {
        k.c(str, "<set-?>");
        this.appCode = str;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final void setGameName(String str) {
        k.c(str, "<set-?>");
        this.gameName = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoyaltyTaskPushRequest(String str, String str2, String str3, String str4, String str5, String str6, int i2, g gVar) {
        this(str, str2, str3, str4, str5, (i2 & 32) != 0 ? "easy" : str6);
    }

    public final String getGameLevel() {
        return this.gameLevel;
    }

    public final void setGameLevel(String str) {
        k.c(str, "<set-?>");
        this.gameLevel = str;
    }
}
