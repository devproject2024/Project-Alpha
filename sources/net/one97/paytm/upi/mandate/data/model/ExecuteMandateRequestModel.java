package net.one97.paytm.upi.mandate.data.model;

import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class ExecuteMandateRequestModel implements UpiBaseDataModel {
    @c(a = "amount")
    private final String amount;
    @c(a = "deviceId")
    private final String deviceId;
    @c(a = "initiationMode")
    private final String initiationMode;
    @c(a = "note")
    private final String note;
    @c(a = "seqNo")
    private final String seqNo;
    @c(a = "umn")
    private final String umn;

    public static /* synthetic */ ExecuteMandateRequestModel copy$default(ExecuteMandateRequestModel executeMandateRequestModel, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = executeMandateRequestModel.seqNo;
        }
        if ((i2 & 2) != 0) {
            str2 = executeMandateRequestModel.deviceId;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = executeMandateRequestModel.initiationMode;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = executeMandateRequestModel.umn;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = executeMandateRequestModel.amount;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = executeMandateRequestModel.note;
        }
        return executeMandateRequestModel.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.seqNo;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.initiationMode;
    }

    public final String component4() {
        return this.umn;
    }

    public final String component5() {
        return this.amount;
    }

    public final String component6() {
        return this.note;
    }

    public final ExecuteMandateRequestModel copy(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "deviceId");
        k.c(str3, "initiationMode");
        k.c(str4, "umn");
        k.c(str5, "amount");
        return new ExecuteMandateRequestModel(str, str2, str3, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExecuteMandateRequestModel)) {
            return false;
        }
        ExecuteMandateRequestModel executeMandateRequestModel = (ExecuteMandateRequestModel) obj;
        return k.a((Object) this.seqNo, (Object) executeMandateRequestModel.seqNo) && k.a((Object) this.deviceId, (Object) executeMandateRequestModel.deviceId) && k.a((Object) this.initiationMode, (Object) executeMandateRequestModel.initiationMode) && k.a((Object) this.umn, (Object) executeMandateRequestModel.umn) && k.a((Object) this.amount, (Object) executeMandateRequestModel.amount) && k.a((Object) this.note, (Object) executeMandateRequestModel.note);
    }

    public final int hashCode() {
        String str = this.seqNo;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.initiationMode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.umn;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.amount;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.note;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "ExecuteMandateRequestModel(seqNo=" + this.seqNo + ", deviceId=" + this.deviceId + ", initiationMode=" + this.initiationMode + ", umn=" + this.umn + ", amount=" + this.amount + ", note=" + this.note + ")";
    }

    public ExecuteMandateRequestModel(String str, String str2, String str3, String str4, String str5, String str6) {
        k.c(str, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "deviceId");
        k.c(str3, "initiationMode");
        k.c(str4, "umn");
        k.c(str5, "amount");
        this.seqNo = str;
        this.deviceId = str2;
        this.initiationMode = str3;
        this.umn = str4;
        this.amount = str5;
        this.note = str6;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getInitiationMode() {
        return this.initiationMode;
    }

    public final String getUmn() {
        return this.umn;
    }

    public final String getAmount() {
        return this.amount;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExecuteMandateRequestModel(String str, String str2, String str3, String str4, String str5, String str6, int i2, g gVar) {
        this(str, str2, str3, str4, str5, (i2 & 32) != 0 ? "" : str6);
    }

    public final String getNote() {
        return this.note;
    }
}
