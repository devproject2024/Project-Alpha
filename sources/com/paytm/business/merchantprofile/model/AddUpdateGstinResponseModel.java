package com.paytm.business.merchantprofile.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class AddUpdateGstinResponseModel {
    @c(a = "isGstValid")
    public Boolean isGstValid;
    @c(a = "resultCode")
    public String resultCode;
    @c(a = "resultMsg")
    public ResultMessageModel resultMsg;
    @c(a = "status")
    public String status;
    @c(a = "statusCode")
    public String statusCode;
    @c(a = "statusMessage")
    public String statusMessage;

    public static /* synthetic */ AddUpdateGstinResponseModel copy$default(AddUpdateGstinResponseModel addUpdateGstinResponseModel, String str, String str2, String str3, String str4, Boolean bool, ResultMessageModel resultMessageModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = addUpdateGstinResponseModel.status;
        }
        if ((i2 & 2) != 0) {
            str2 = addUpdateGstinResponseModel.statusMessage;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = addUpdateGstinResponseModel.statusCode;
        }
        String str6 = str3;
        if ((i2 & 8) != 0) {
            str4 = addUpdateGstinResponseModel.resultCode;
        }
        String str7 = str4;
        if ((i2 & 16) != 0) {
            bool = addUpdateGstinResponseModel.isGstValid;
        }
        Boolean bool2 = bool;
        if ((i2 & 32) != 0) {
            resultMessageModel = addUpdateGstinResponseModel.resultMsg;
        }
        return addUpdateGstinResponseModel.copy(str, str5, str6, str7, bool2, resultMessageModel);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.statusMessage;
    }

    public final String component3() {
        return this.statusCode;
    }

    public final String component4() {
        return this.resultCode;
    }

    public final Boolean component5() {
        return this.isGstValid;
    }

    public final ResultMessageModel component6() {
        return this.resultMsg;
    }

    public final AddUpdateGstinResponseModel copy(String str, String str2, String str3, String str4, Boolean bool, ResultMessageModel resultMessageModel) {
        return new AddUpdateGstinResponseModel(str, str2, str3, str4, bool, resultMessageModel);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddUpdateGstinResponseModel)) {
            return false;
        }
        AddUpdateGstinResponseModel addUpdateGstinResponseModel = (AddUpdateGstinResponseModel) obj;
        return k.a((Object) this.status, (Object) addUpdateGstinResponseModel.status) && k.a((Object) this.statusMessage, (Object) addUpdateGstinResponseModel.statusMessage) && k.a((Object) this.statusCode, (Object) addUpdateGstinResponseModel.statusCode) && k.a((Object) this.resultCode, (Object) addUpdateGstinResponseModel.resultCode) && k.a((Object) this.isGstValid, (Object) addUpdateGstinResponseModel.isGstValid) && k.a((Object) this.resultMsg, (Object) addUpdateGstinResponseModel.resultMsg);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.statusMessage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.statusCode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.resultCode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.isGstValid;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        ResultMessageModel resultMessageModel = this.resultMsg;
        if (resultMessageModel != null) {
            i2 = resultMessageModel.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "AddUpdateGstinResponseModel(status=" + this.status + ", statusMessage=" + this.statusMessage + ", statusCode=" + this.statusCode + ", resultCode=" + this.resultCode + ", isGstValid=" + this.isGstValid + ", resultMsg=" + this.resultMsg + ")";
    }

    public AddUpdateGstinResponseModel(String str, String str2, String str3, String str4, Boolean bool, ResultMessageModel resultMessageModel) {
        this.status = str;
        this.statusMessage = str2;
        this.statusCode = str3;
        this.resultCode = str4;
        this.isGstValid = bool;
        this.resultMsg = resultMessageModel;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getStatusMessage() {
        return this.statusMessage;
    }

    public final void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(String str) {
        this.statusCode = str;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void setResultCode(String str) {
        this.resultCode = str;
    }

    public final Boolean isGstValid() {
        return this.isGstValid;
    }

    public final void setGstValid(Boolean bool) {
        this.isGstValid = bool;
    }

    public final ResultMessageModel getResultMsg() {
        return this.resultMsg;
    }

    public final void setResultMsg(ResultMessageModel resultMessageModel) {
        this.resultMsg = resultMessageModel;
    }
}
