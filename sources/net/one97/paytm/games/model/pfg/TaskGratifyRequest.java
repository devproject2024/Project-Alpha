package net.one97.paytm.games.model.pfg;

import kotlin.g.b.k;

public final class TaskGratifyRequest {
    private String appCode;
    private String claimId;
    private String customerId;
    private String eventId;
    private String msisdn;
    private String ruleId;

    public static /* synthetic */ TaskGratifyRequest copy$default(TaskGratifyRequest taskGratifyRequest, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = taskGratifyRequest.ruleId;
        }
        if ((i2 & 2) != 0) {
            str2 = taskGratifyRequest.eventId;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = taskGratifyRequest.claimId;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = taskGratifyRequest.appCode;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = taskGratifyRequest.customerId;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = taskGratifyRequest.msisdn;
        }
        return taskGratifyRequest.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.ruleId;
    }

    public final String component2() {
        return this.eventId;
    }

    public final String component3() {
        return this.claimId;
    }

    public final String component4() {
        return this.appCode;
    }

    public final String component5() {
        return this.customerId;
    }

    public final String component6() {
        return this.msisdn;
    }

    public final TaskGratifyRequest copy(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "ruleId");
        k.c(str2, "eventId");
        k.c(str3, "claimId");
        k.c(str4, "appCode");
        k.c(str5, "customerId");
        k.c(str6, "msisdn");
        return new TaskGratifyRequest(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskGratifyRequest)) {
            return false;
        }
        TaskGratifyRequest taskGratifyRequest = (TaskGratifyRequest) obj;
        return k.a((Object) this.ruleId, (Object) taskGratifyRequest.ruleId) && k.a((Object) this.eventId, (Object) taskGratifyRequest.eventId) && k.a((Object) this.claimId, (Object) taskGratifyRequest.claimId) && k.a((Object) this.appCode, (Object) taskGratifyRequest.appCode) && k.a((Object) this.customerId, (Object) taskGratifyRequest.customerId) && k.a((Object) this.msisdn, (Object) taskGratifyRequest.msisdn);
    }

    public final int hashCode() {
        String str = this.ruleId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.eventId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.claimId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.appCode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.customerId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.msisdn;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "TaskGratifyRequest(ruleId=" + this.ruleId + ", eventId=" + this.eventId + ", claimId=" + this.claimId + ", appCode=" + this.appCode + ", customerId=" + this.customerId + ", msisdn=" + this.msisdn + ")";
    }

    public TaskGratifyRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, "ruleId");
        k.c(str2, "eventId");
        k.c(str3, "claimId");
        k.c(str4, "appCode");
        k.c(str5, "customerId");
        k.c(str6, "msisdn");
        this.ruleId = str;
        this.eventId = str2;
        this.claimId = str3;
        this.appCode = str4;
        this.customerId = str5;
        this.msisdn = str6;
    }

    public final String getRuleId() {
        return this.ruleId;
    }

    public final void setRuleId(String str) {
        k.c(str, "<set-?>");
        this.ruleId = str;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final void setEventId(String str) {
        k.c(str, "<set-?>");
        this.eventId = str;
    }

    public final String getClaimId() {
        return this.claimId;
    }

    public final void setClaimId(String str) {
        k.c(str, "<set-?>");
        this.claimId = str;
    }

    public final String getAppCode() {
        return this.appCode;
    }

    public final void setAppCode(String str) {
        k.c(str, "<set-?>");
        this.appCode = str;
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
}
