package com.paytm.business.merchantprofile.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class FetchGstinStatusResponse {
    @c(a = "gstin")
    public String gstin;
    @c(a = "leadId")
    public String leadId;
    @c(a = "leadStatus")
    public String leadStatus;
    @c(a = "refId")
    public String refId;
    @c(a = "statusCode")
    public Integer statusCode;

    public static /* synthetic */ FetchGstinStatusResponse copy$default(FetchGstinStatusResponse fetchGstinStatusResponse, String str, Integer num, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fetchGstinStatusResponse.refId;
        }
        if ((i2 & 2) != 0) {
            num = fetchGstinStatusResponse.statusCode;
        }
        Integer num2 = num;
        if ((i2 & 4) != 0) {
            str2 = fetchGstinStatusResponse.leadStatus;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = fetchGstinStatusResponse.leadId;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = fetchGstinStatusResponse.gstin;
        }
        return fetchGstinStatusResponse.copy(str, num2, str5, str6, str4);
    }

    public final String component1() {
        return this.refId;
    }

    public final Integer component2() {
        return this.statusCode;
    }

    public final String component3() {
        return this.leadStatus;
    }

    public final String component4() {
        return this.leadId;
    }

    public final String component5() {
        return this.gstin;
    }

    public final FetchGstinStatusResponse copy(String str, Integer num, String str2, String str3, String str4) {
        return new FetchGstinStatusResponse(str, num, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FetchGstinStatusResponse)) {
            return false;
        }
        FetchGstinStatusResponse fetchGstinStatusResponse = (FetchGstinStatusResponse) obj;
        return k.a((Object) this.refId, (Object) fetchGstinStatusResponse.refId) && k.a((Object) this.statusCode, (Object) fetchGstinStatusResponse.statusCode) && k.a((Object) this.leadStatus, (Object) fetchGstinStatusResponse.leadStatus) && k.a((Object) this.leadId, (Object) fetchGstinStatusResponse.leadId) && k.a((Object) this.gstin, (Object) fetchGstinStatusResponse.gstin);
    }

    public final int hashCode() {
        String str = this.refId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.statusCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.leadStatus;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.leadId;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.gstin;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "FetchGstinStatusResponse(refId=" + this.refId + ", statusCode=" + this.statusCode + ", leadStatus=" + this.leadStatus + ", leadId=" + this.leadId + ", gstin=" + this.gstin + ")";
    }

    public FetchGstinStatusResponse(String str, Integer num, String str2, String str3, String str4) {
        this.refId = str;
        this.statusCode = num;
        this.leadStatus = str2;
        this.leadId = str3;
        this.gstin = str4;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final void setRefId(String str) {
        this.refId = str;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(Integer num) {
        this.statusCode = num;
    }

    public final String getLeadStatus() {
        return this.leadStatus;
    }

    public final void setLeadStatus(String str) {
        this.leadStatus = str;
    }

    public final String getLeadId() {
        return this.leadId;
    }

    public final void setLeadId(String str) {
        this.leadId = str;
    }

    public final String getGstin() {
        return this.gstin;
    }

    public final void setGstin(String str) {
        this.gstin = str;
    }
}
