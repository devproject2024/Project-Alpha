package net.one97.paytm.upi.mandate.update;

import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class UpdateMandateRequestBody implements UpiBaseDataModel {
    @c(a = "amount")
    private String amount;
    @c(a = "app")
    private String app;
    @c(a = "deviceId")
    private String deviceId;
    @c(a = "mpin")
    private String mpin;
    @c(a = "operation")
    private String operation;
    @c(a = "pauseEndDate")
    private String pauseEndDate;
    @c(a = "pauseStartDate")
    private String pauseStartDate;
    @c(a = "seqNo")
    private String seqNo;
    @c(a = "umn")
    private String umn;
    @c(a = "validityEndDate")
    private String validityEndDate;

    public UpdateMandateRequestBody(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        k.c(str, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "deviceId");
        k.c(str3, "umn");
        k.c(str4, "operation");
        k.c(str8, "amount");
        k.c(str9, PayUtility.MPIN);
        k.c(str10, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.seqNo = str;
        this.deviceId = str2;
        this.umn = str3;
        this.operation = str4;
        this.pauseStartDate = str5;
        this.pauseEndDate = str6;
        this.validityEndDate = str7;
        this.amount = str8;
        this.mpin = str9;
        this.app = str10;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final void setSeqNo(String str) {
        k.c(str, "<set-?>");
        this.seqNo = str;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        k.c(str, "<set-?>");
        this.deviceId = str;
    }

    public final String getUmn() {
        return this.umn;
    }

    public final void setUmn(String str) {
        k.c(str, "<set-?>");
        this.umn = str;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final void setOperation(String str) {
        k.c(str, "<set-?>");
        this.operation = str;
    }

    public final String getPauseStartDate() {
        return this.pauseStartDate;
    }

    public final void setPauseStartDate(String str) {
        this.pauseStartDate = str;
    }

    public final String getPauseEndDate() {
        return this.pauseEndDate;
    }

    public final void setPauseEndDate(String str) {
        this.pauseEndDate = str;
    }

    public final String getValidityEndDate() {
        return this.validityEndDate;
    }

    public final void setValidityEndDate(String str) {
        this.validityEndDate = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        k.c(str, "<set-?>");
        this.amount = str;
    }

    public final String getMpin() {
        return this.mpin;
    }

    public final void setMpin(String str) {
        k.c(str, "<set-?>");
        this.mpin = str;
    }

    public final String getApp() {
        return this.app;
    }

    public final void setApp(String str) {
        k.c(str, "<set-?>");
        this.app = str;
    }
}
