package net.one97.paytm.common.entity.moneytransfer;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PPBPrevalidateResponseModel extends IJRPaytmDataModel {
    private String accountStatus;
    private boolean displayMessageFlag;
    private String message;
    private boolean proceedFlag;
    @b(a = "response_code")
    private final Integer responseCode;
    private String tooltipMessage;

    public static /* synthetic */ PPBPrevalidateResponseModel copy$default(PPBPrevalidateResponseModel pPBPrevalidateResponseModel, String str, String str2, boolean z, boolean z2, String str3, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pPBPrevalidateResponseModel.message;
        }
        if ((i2 & 2) != 0) {
            str2 = pPBPrevalidateResponseModel.tooltipMessage;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            z = pPBPrevalidateResponseModel.displayMessageFlag;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            z2 = pPBPrevalidateResponseModel.proceedFlag;
        }
        boolean z4 = z2;
        if ((i2 & 16) != 0) {
            str3 = pPBPrevalidateResponseModel.accountStatus;
        }
        String str5 = str3;
        if ((i2 & 32) != 0) {
            num = pPBPrevalidateResponseModel.responseCode;
        }
        return pPBPrevalidateResponseModel.copy(str, str4, z3, z4, str5, num);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.tooltipMessage;
    }

    public final boolean component3() {
        return this.displayMessageFlag;
    }

    public final boolean component4() {
        return this.proceedFlag;
    }

    public final String component5() {
        return this.accountStatus;
    }

    public final Integer component6() {
        return this.responseCode;
    }

    public final PPBPrevalidateResponseModel copy(String str, String str2, boolean z, boolean z2, String str3, Integer num) {
        return new PPBPrevalidateResponseModel(str, str2, z, z2, str3, num);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof PPBPrevalidateResponseModel) {
                PPBPrevalidateResponseModel pPBPrevalidateResponseModel = (PPBPrevalidateResponseModel) obj;
                if (k.a((Object) this.message, (Object) pPBPrevalidateResponseModel.message) && k.a((Object) this.tooltipMessage, (Object) pPBPrevalidateResponseModel.tooltipMessage)) {
                    if (this.displayMessageFlag == pPBPrevalidateResponseModel.displayMessageFlag) {
                        if (!(this.proceedFlag == pPBPrevalidateResponseModel.proceedFlag) || !k.a((Object) this.accountStatus, (Object) pPBPrevalidateResponseModel.accountStatus) || !k.a((Object) this.responseCode, (Object) pPBPrevalidateResponseModel.responseCode)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.message;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tooltipMessage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.displayMessageFlag;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        boolean z2 = this.proceedFlag;
        if (z2) {
            z2 = true;
        }
        int i4 = (i3 + (z2 ? 1 : 0)) * 31;
        String str3 = this.accountStatus;
        int hashCode3 = (i4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.responseCode;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "PPBPrevalidateResponseModel(message=" + this.message + ", tooltipMessage=" + this.tooltipMessage + ", displayMessageFlag=" + this.displayMessageFlag + ", proceedFlag=" + this.proceedFlag + ", accountStatus=" + this.accountStatus + ", responseCode=" + this.responseCode + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTooltipMessage() {
        return this.tooltipMessage;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setTooltipMessage(String str) {
        this.tooltipMessage = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PPBPrevalidateResponseModel(String str, String str2, boolean z, boolean z2, String str3, Integer num, int i2, g gVar) {
        this(str, str2, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, str3, num);
    }

    public final boolean getDisplayMessageFlag() {
        return this.displayMessageFlag;
    }

    public final boolean getProceedFlag() {
        return this.proceedFlag;
    }

    public final void setDisplayMessageFlag(boolean z) {
        this.displayMessageFlag = z;
    }

    public final void setProceedFlag(boolean z) {
        this.proceedFlag = z;
    }

    public PPBPrevalidateResponseModel(String str, String str2, boolean z, boolean z2, String str3, Integer num) {
        this.message = str;
        this.tooltipMessage = str2;
        this.displayMessageFlag = z;
        this.proceedFlag = z2;
        this.accountStatus = str3;
        this.responseCode = num;
    }

    public final String getAccountStatus() {
        return this.accountStatus;
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public final void setAccountStatus(String str) {
        this.accountStatus = str;
    }
}
