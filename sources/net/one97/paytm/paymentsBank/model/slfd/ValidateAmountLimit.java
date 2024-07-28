package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ValidateAmountLimit extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "limit_breach")
    private final boolean limitBreached;
    @b(a = "message")
    private final String message;
    @b(a = "response_code")
    private final int responseCode;
    @b(a = "status")
    private final String status;
    @b(a = "txn_id")
    private final String txnId;

    public ValidateAmountLimit() {
        this(false, (String) null, 0, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ ValidateAmountLimit copy$default(ValidateAmountLimit validateAmountLimit, boolean z, String str, int i2, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = validateAmountLimit.limitBreached;
        }
        if ((i3 & 2) != 0) {
            str = validateAmountLimit.message;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            i2 = validateAmountLimit.responseCode;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            str2 = validateAmountLimit.status;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            str3 = validateAmountLimit.txnId;
        }
        return validateAmountLimit.copy(z, str4, i4, str5, str3);
    }

    public final boolean component1() {
        return this.limitBreached;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.responseCode;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.txnId;
    }

    public final ValidateAmountLimit copy(boolean z, String str, int i2, String str2, String str3) {
        k.c(str, "message");
        k.c(str2, "status");
        k.c(str3, "txnId");
        return new ValidateAmountLimit(z, str, i2, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ValidateAmountLimit) {
                ValidateAmountLimit validateAmountLimit = (ValidateAmountLimit) obj;
                if ((this.limitBreached == validateAmountLimit.limitBreached) && k.a((Object) this.message, (Object) validateAmountLimit.message)) {
                    if (!(this.responseCode == validateAmountLimit.responseCode) || !k.a((Object) this.status, (Object) validateAmountLimit.status) || !k.a((Object) this.txnId, (Object) validateAmountLimit.txnId)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        boolean z = this.limitBreached;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.message;
        int i3 = 0;
        int hashCode = (((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.responseCode) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.txnId;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return hashCode2 + i3;
    }

    public final String toString() {
        return "ValidateAmountLimit(limitBreached=" + this.limitBreached + ", message=" + this.message + ", responseCode=" + this.responseCode + ", status=" + this.status + ", txnId=" + this.txnId + ")";
    }

    public final boolean getLimitBreached() {
        return this.limitBreached;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final String getStatus() {
        return this.status;
    }

    public ValidateAmountLimit(boolean z, String str, int i2, String str2, String str3) {
        k.c(str, "message");
        k.c(str2, "status");
        k.c(str3, "txnId");
        this.limitBreached = z;
        this.message = str;
        this.responseCode = i2;
        this.status = str2;
        this.txnId = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ValidateAmountLimit(boolean r5, java.lang.String r6, int r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = 0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            java.lang.String r1 = ""
            if (r5 == 0) goto L_0x0010
            r2 = r1
            goto L_0x0011
        L_0x0010:
            r2 = r6
        L_0x0011:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r0 = r7
        L_0x0017:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r1
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0024
            r10 = r1
            goto L_0x0025
        L_0x0024:
            r10 = r9
        L_0x0025:
            r5 = r4
            r6 = r11
            r7 = r2
            r8 = r0
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.model.slfd.ValidateAmountLimit.<init>(boolean, java.lang.String, int, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getTxnId() {
        return this.txnId;
    }
}
