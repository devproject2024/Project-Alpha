package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SendOtpErrorModel implements IJRDataModel {
    @b(a = "errorCode")
    private final String errorCode;
    @b(a = "errorMsg")
    private final String errorMsg;

    public SendOtpErrorModel() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ SendOtpErrorModel copy$default(SendOtpErrorModel sendOtpErrorModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sendOtpErrorModel.errorCode;
        }
        if ((i2 & 2) != 0) {
            str2 = sendOtpErrorModel.errorMsg;
        }
        return sendOtpErrorModel.copy(str, str2);
    }

    public final String component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final SendOtpErrorModel copy(String str, String str2) {
        return new SendOtpErrorModel(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendOtpErrorModel)) {
            return false;
        }
        SendOtpErrorModel sendOtpErrorModel = (SendOtpErrorModel) obj;
        return k.a((Object) this.errorCode, (Object) sendOtpErrorModel.errorCode) && k.a((Object) this.errorMsg, (Object) sendOtpErrorModel.errorMsg);
    }

    public final int hashCode() {
        String str = this.errorCode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.errorMsg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "SendOtpErrorModel(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
    }

    public SendOtpErrorModel(String str, String str2) {
        this.errorCode = str;
        this.errorMsg = str2;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SendOtpErrorModel(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }
}
