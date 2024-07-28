package net.one97.paytm.upi.mandate.data.model;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class CheckMandateStatusRequestModel implements UpiBaseDataModel {
    @c(a = "channel-code")
    private final String channelCode;
    @c(a = "device-id")
    private final String deviceId;
    @c(a = "mobile")
    private final String mobile;
    @c(a = "seq-no")
    private final String seqNo;
    @c(a = "txn-id")
    private final String txnId;

    public static /* synthetic */ CheckMandateStatusRequestModel copy$default(CheckMandateStatusRequestModel checkMandateStatusRequestModel, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = checkMandateStatusRequestModel.seqNo;
        }
        if ((i2 & 2) != 0) {
            str2 = checkMandateStatusRequestModel.txnId;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = checkMandateStatusRequestModel.deviceId;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = checkMandateStatusRequestModel.channelCode;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = checkMandateStatusRequestModel.mobile;
        }
        return checkMandateStatusRequestModel.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.seqNo;
    }

    public final String component2() {
        return this.txnId;
    }

    public final String component3() {
        return this.deviceId;
    }

    public final String component4() {
        return this.channelCode;
    }

    public final String component5() {
        return this.mobile;
    }

    public final CheckMandateStatusRequestModel copy(String str, String str2, String str3, String str4, String str5) {
        k.c(str, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "txnId");
        k.c(str3, "deviceId");
        k.c(str4, "channelCode");
        k.c(str5, "mobile");
        return new CheckMandateStatusRequestModel(str, str2, str3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckMandateStatusRequestModel)) {
            return false;
        }
        CheckMandateStatusRequestModel checkMandateStatusRequestModel = (CheckMandateStatusRequestModel) obj;
        return k.a((Object) this.seqNo, (Object) checkMandateStatusRequestModel.seqNo) && k.a((Object) this.txnId, (Object) checkMandateStatusRequestModel.txnId) && k.a((Object) this.deviceId, (Object) checkMandateStatusRequestModel.deviceId) && k.a((Object) this.channelCode, (Object) checkMandateStatusRequestModel.channelCode) && k.a((Object) this.mobile, (Object) checkMandateStatusRequestModel.mobile);
    }

    public final int hashCode() {
        String str = this.seqNo;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.txnId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.deviceId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.channelCode;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mobile;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "CheckMandateStatusRequestModel(seqNo=" + this.seqNo + ", txnId=" + this.txnId + ", deviceId=" + this.deviceId + ", channelCode=" + this.channelCode + ", mobile=" + this.mobile + ")";
    }

    public CheckMandateStatusRequestModel(String str, String str2, String str3, String str4, String str5) {
        k.c(str, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str2, "txnId");
        k.c(str3, "deviceId");
        k.c(str4, "channelCode");
        k.c(str5, "mobile");
        this.seqNo = str;
        this.txnId = str2;
        this.deviceId = str3;
        this.channelCode = str4;
        this.mobile = str5;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final String getMobile() {
        return this.mobile;
    }
}
