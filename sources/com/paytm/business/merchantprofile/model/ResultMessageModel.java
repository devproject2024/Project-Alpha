package com.paytm.business.merchantprofile.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class ResultMessageModel {
    @c(a = "displayMessage")
    public String displayMessage;
    @c(a = "refId")
    public String refId;
    @c(a = "statusCode")
    public Integer statusCode;

    public static /* synthetic */ ResultMessageModel copy$default(ResultMessageModel resultMessageModel, String str, String str2, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = resultMessageModel.displayMessage;
        }
        if ((i2 & 2) != 0) {
            str2 = resultMessageModel.refId;
        }
        if ((i2 & 4) != 0) {
            num = resultMessageModel.statusCode;
        }
        return resultMessageModel.copy(str, str2, num);
    }

    public final String component1() {
        return this.displayMessage;
    }

    public final String component2() {
        return this.refId;
    }

    public final Integer component3() {
        return this.statusCode;
    }

    public final ResultMessageModel copy(String str, String str2, Integer num) {
        return new ResultMessageModel(str, str2, num);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultMessageModel)) {
            return false;
        }
        ResultMessageModel resultMessageModel = (ResultMessageModel) obj;
        return k.a((Object) this.displayMessage, (Object) resultMessageModel.displayMessage) && k.a((Object) this.refId, (Object) resultMessageModel.refId) && k.a((Object) this.statusCode, (Object) resultMessageModel.statusCode);
    }

    public final int hashCode() {
        String str = this.displayMessage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.refId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.statusCode;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ResultMessageModel(displayMessage=" + this.displayMessage + ", refId=" + this.refId + ", statusCode=" + this.statusCode + ")";
    }

    public ResultMessageModel(String str, String str2, Integer num) {
        this.displayMessage = str;
        this.refId = str2;
        this.statusCode = num;
    }

    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    public final void setDisplayMessage(String str) {
        this.displayMessage = str;
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
}
