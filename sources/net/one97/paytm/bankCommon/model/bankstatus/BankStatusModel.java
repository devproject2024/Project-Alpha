package net.one97.paytm.bankCommon.model.bankstatus;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class BankStatusModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "accountStatus")
    private String accountStatus;
    @b(a = "accountStatusCode")
    private Integer accountStatusCode;
    @b(a = "accountStatusErrorMessage")
    private String accountStatusErrorMessage;
    @b(a = "errorCode")
    private String errorCode;
    @b(a = "errorMessage")
    private String errorMessage;
    @b(a = "passCodeExistErrorMessage")
    private String passCodeExistErrorMessage;
    @b(a = "passCodeExistStatusCode")
    private Integer passCodeExistStatusCode;
    @b(a = "passCodeStatus")
    private String passCodeStatus;

    public BankStatusModel() {
        this((String) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public static /* synthetic */ BankStatusModel copy$default(BankStatusModel bankStatusModel, String str, Integer num, String str2, String str3, Integer num2, String str4, String str5, String str6, int i2, Object obj) {
        BankStatusModel bankStatusModel2 = bankStatusModel;
        int i3 = i2;
        return bankStatusModel.copy((i3 & 1) != 0 ? bankStatusModel2.accountStatus : str, (i3 & 2) != 0 ? bankStatusModel2.accountStatusCode : num, (i3 & 4) != 0 ? bankStatusModel2.accountStatusErrorMessage : str2, (i3 & 8) != 0 ? bankStatusModel2.passCodeStatus : str3, (i3 & 16) != 0 ? bankStatusModel2.passCodeExistStatusCode : num2, (i3 & 32) != 0 ? bankStatusModel2.passCodeExistErrorMessage : str4, (i3 & 64) != 0 ? bankStatusModel2.errorMessage : str5, (i3 & 128) != 0 ? bankStatusModel2.errorCode : str6);
    }

    public final String component1() {
        return this.accountStatus;
    }

    public final Integer component2() {
        return this.accountStatusCode;
    }

    public final String component3() {
        return this.accountStatusErrorMessage;
    }

    public final String component4() {
        return this.passCodeStatus;
    }

    public final Integer component5() {
        return this.passCodeExistStatusCode;
    }

    public final String component6() {
        return this.passCodeExistErrorMessage;
    }

    public final String component7() {
        return this.errorMessage;
    }

    public final String component8() {
        return this.errorCode;
    }

    public final BankStatusModel copy(String str, Integer num, String str2, String str3, Integer num2, String str4, String str5, String str6) {
        return new BankStatusModel(str, num, str2, str3, num2, str4, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankStatusModel)) {
            return false;
        }
        BankStatusModel bankStatusModel = (BankStatusModel) obj;
        return k.a((Object) this.accountStatus, (Object) bankStatusModel.accountStatus) && k.a((Object) this.accountStatusCode, (Object) bankStatusModel.accountStatusCode) && k.a((Object) this.accountStatusErrorMessage, (Object) bankStatusModel.accountStatusErrorMessage) && k.a((Object) this.passCodeStatus, (Object) bankStatusModel.passCodeStatus) && k.a((Object) this.passCodeExistStatusCode, (Object) bankStatusModel.passCodeExistStatusCode) && k.a((Object) this.passCodeExistErrorMessage, (Object) bankStatusModel.passCodeExistErrorMessage) && k.a((Object) this.errorMessage, (Object) bankStatusModel.errorMessage) && k.a((Object) this.errorCode, (Object) bankStatusModel.errorCode);
    }

    public final int hashCode() {
        String str = this.accountStatus;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.accountStatusCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.accountStatusErrorMessage;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.passCodeStatus;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num2 = this.passCodeExistStatusCode;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str4 = this.passCodeExistErrorMessage;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.errorMessage;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.errorCode;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "BankStatusModel(accountStatus=" + this.accountStatus + ", accountStatusCode=" + this.accountStatusCode + ", accountStatusErrorMessage=" + this.accountStatusErrorMessage + ", passCodeStatus=" + this.passCodeStatus + ", passCodeExistStatusCode=" + this.passCodeExistStatusCode + ", passCodeExistErrorMessage=" + this.passCodeExistErrorMessage + ", errorMessage=" + this.errorMessage + ", errorCode=" + this.errorCode + ")";
    }

    public final String getAccountStatus() {
        return this.accountStatus;
    }

    public final void setAccountStatus(String str) {
        this.accountStatus = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BankStatusModel(java.lang.String r10, java.lang.Integer r11, java.lang.String r12, java.lang.String r13, java.lang.Integer r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.g.b.g r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r10
        L_0x000b:
            r3 = r0 & 2
            r4 = -1
            if (r3 == 0) goto L_0x0015
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            goto L_0x0016
        L_0x0015:
            r3 = r11
        L_0x0016:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001c
            r5 = r2
            goto L_0x001d
        L_0x001c:
            r5 = r12
        L_0x001d:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0023
            r6 = r2
            goto L_0x0024
        L_0x0023:
            r6 = r13
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x002e
        L_0x002d:
            r4 = r14
        L_0x002e:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0034
            r7 = r2
            goto L_0x0035
        L_0x0034:
            r7 = r15
        L_0x0035:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003b
            r8 = r2
            goto L_0x003d
        L_0x003b:
            r8 = r16
        L_0x003d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r2 = r17
        L_0x0044:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r5
            r14 = r6
            r15 = r4
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankCommon.model.bankstatus.BankStatusModel.<init>(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final Integer getAccountStatusCode() {
        return this.accountStatusCode;
    }

    public final void setAccountStatusCode(Integer num) {
        this.accountStatusCode = num;
    }

    public final String getAccountStatusErrorMessage() {
        return this.accountStatusErrorMessage;
    }

    public final void setAccountStatusErrorMessage(String str) {
        this.accountStatusErrorMessage = str;
    }

    public final String getPassCodeStatus() {
        return this.passCodeStatus;
    }

    public final void setPassCodeStatus(String str) {
        this.passCodeStatus = str;
    }

    public final Integer getPassCodeExistStatusCode() {
        return this.passCodeExistStatusCode;
    }

    public final void setPassCodeExistStatusCode(Integer num) {
        this.passCodeExistStatusCode = num;
    }

    public final String getPassCodeExistErrorMessage() {
        return this.passCodeExistErrorMessage;
    }

    public final void setPassCodeExistErrorMessage(String str) {
        this.passCodeExistErrorMessage = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public BankStatusModel(String str, Integer num, String str2, String str3, Integer num2, String str4, String str5, String str6) {
        this.accountStatus = str;
        this.accountStatusCode = num;
        this.accountStatusErrorMessage = str2;
        this.passCodeStatus = str3;
        this.passCodeExistStatusCode = num2;
        this.passCodeExistErrorMessage = str4;
        this.errorMessage = str5;
        this.errorCode = str6;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(String str) {
        this.errorCode = str;
    }
}
