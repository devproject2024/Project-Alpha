package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SendOtpMinorKycModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "error")
    private final SendOtpErrorModel error;
    @b(a = "referenceNumber")
    private final String refNumber;
    @b(a = "statusCode")
    private final String statusCode;
    @b(a = "statusMessage")
    private final String statusMsg;

    public SendOtpMinorKycModel() {
        this((String) null, (String) null, (SendOtpErrorModel) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ SendOtpMinorKycModel copy$default(SendOtpMinorKycModel sendOtpMinorKycModel, String str, String str2, SendOtpErrorModel sendOtpErrorModel, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sendOtpMinorKycModel.statusMsg;
        }
        if ((i2 & 2) != 0) {
            str2 = sendOtpMinorKycModel.refNumber;
        }
        if ((i2 & 4) != 0) {
            sendOtpErrorModel = sendOtpMinorKycModel.error;
        }
        if ((i2 & 8) != 0) {
            str3 = sendOtpMinorKycModel.statusCode;
        }
        return sendOtpMinorKycModel.copy(str, str2, sendOtpErrorModel, str3);
    }

    public final String component1() {
        return this.statusMsg;
    }

    public final String component2() {
        return this.refNumber;
    }

    public final SendOtpErrorModel component3() {
        return this.error;
    }

    public final String component4() {
        return this.statusCode;
    }

    public final SendOtpMinorKycModel copy(String str, String str2, SendOtpErrorModel sendOtpErrorModel, String str3) {
        return new SendOtpMinorKycModel(str, str2, sendOtpErrorModel, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendOtpMinorKycModel)) {
            return false;
        }
        SendOtpMinorKycModel sendOtpMinorKycModel = (SendOtpMinorKycModel) obj;
        return k.a((Object) this.statusMsg, (Object) sendOtpMinorKycModel.statusMsg) && k.a((Object) this.refNumber, (Object) sendOtpMinorKycModel.refNumber) && k.a((Object) this.error, (Object) sendOtpMinorKycModel.error) && k.a((Object) this.statusCode, (Object) sendOtpMinorKycModel.statusCode);
    }

    public final int hashCode() {
        String str = this.statusMsg;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.refNumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        SendOtpErrorModel sendOtpErrorModel = this.error;
        int hashCode3 = (hashCode2 + (sendOtpErrorModel != null ? sendOtpErrorModel.hashCode() : 0)) * 31;
        String str3 = this.statusCode;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "SendOtpMinorKycModel(statusMsg=" + this.statusMsg + ", refNumber=" + this.refNumber + ", error=" + this.error + ", statusCode=" + this.statusCode + ")";
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final String getRefNumber() {
        return this.refNumber;
    }

    public final SendOtpErrorModel getError() {
        return this.error;
    }

    public SendOtpMinorKycModel(String str, String str2, SendOtpErrorModel sendOtpErrorModel, String str3) {
        this.statusMsg = str;
        this.refNumber = str2;
        this.error = sendOtpErrorModel;
        this.statusCode = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SendOtpMinorKycModel(String str, String str2, SendOtpErrorModel sendOtpErrorModel, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : sendOtpErrorModel, (i2 & 8) != 0 ? null : str3);
    }

    public final String getStatusCode() {
        return this.statusCode;
    }
}
