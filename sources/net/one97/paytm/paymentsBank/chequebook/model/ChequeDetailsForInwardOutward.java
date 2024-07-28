package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ChequeDetailsForInwardOutward implements IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "chequeNumber")
    private String chqNumber;
    @b(a = "draweeBankName")
    private String draweeBnkName;
    @b(a = "latestStatusTimestamp")
    private String latestTimeStamp;
    @b(a = "payeeName")
    private String payeeName;
    @b(a = "payerName")
    private String payerName;
    @b(a = "presentingBankName")
    private String presentingBankName;
    @b(a = "status")
    private String status;

    public ChequeDetailsForInwardOutward() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public static /* synthetic */ ChequeDetailsForInwardOutward copy$default(ChequeDetailsForInwardOutward chequeDetailsForInwardOutward, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, Object obj) {
        ChequeDetailsForInwardOutward chequeDetailsForInwardOutward2 = chequeDetailsForInwardOutward;
        int i3 = i2;
        return chequeDetailsForInwardOutward.copy((i3 & 1) != 0 ? chequeDetailsForInwardOutward2.chqNumber : str, (i3 & 2) != 0 ? chequeDetailsForInwardOutward2.status : str2, (i3 & 4) != 0 ? chequeDetailsForInwardOutward2.amount : str3, (i3 & 8) != 0 ? chequeDetailsForInwardOutward2.draweeBnkName : str4, (i3 & 16) != 0 ? chequeDetailsForInwardOutward2.payerName : str5, (i3 & 32) != 0 ? chequeDetailsForInwardOutward2.latestTimeStamp : str6, (i3 & 64) != 0 ? chequeDetailsForInwardOutward2.presentingBankName : str7, (i3 & 128) != 0 ? chequeDetailsForInwardOutward2.payeeName : str8);
    }

    public final String component1() {
        return this.chqNumber;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.amount;
    }

    public final String component4() {
        return this.draweeBnkName;
    }

    public final String component5() {
        return this.payerName;
    }

    public final String component6() {
        return this.latestTimeStamp;
    }

    public final String component7() {
        return this.presentingBankName;
    }

    public final String component8() {
        return this.payeeName;
    }

    public final ChequeDetailsForInwardOutward copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new ChequeDetailsForInwardOutward(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChequeDetailsForInwardOutward)) {
            return false;
        }
        ChequeDetailsForInwardOutward chequeDetailsForInwardOutward = (ChequeDetailsForInwardOutward) obj;
        return k.a((Object) this.chqNumber, (Object) chequeDetailsForInwardOutward.chqNumber) && k.a((Object) this.status, (Object) chequeDetailsForInwardOutward.status) && k.a((Object) this.amount, (Object) chequeDetailsForInwardOutward.amount) && k.a((Object) this.draweeBnkName, (Object) chequeDetailsForInwardOutward.draweeBnkName) && k.a((Object) this.payerName, (Object) chequeDetailsForInwardOutward.payerName) && k.a((Object) this.latestTimeStamp, (Object) chequeDetailsForInwardOutward.latestTimeStamp) && k.a((Object) this.presentingBankName, (Object) chequeDetailsForInwardOutward.presentingBankName) && k.a((Object) this.payeeName, (Object) chequeDetailsForInwardOutward.payeeName);
    }

    public final int hashCode() {
        String str = this.chqNumber;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.status;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.amount;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.draweeBnkName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.payerName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.latestTimeStamp;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.presentingBankName;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.payeeName;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "ChequeDetailsForInwardOutward(chqNumber=" + this.chqNumber + ", status=" + this.status + ", amount=" + this.amount + ", draweeBnkName=" + this.draweeBnkName + ", payerName=" + this.payerName + ", latestTimeStamp=" + this.latestTimeStamp + ", presentingBankName=" + this.presentingBankName + ", payeeName=" + this.payeeName + ")";
    }

    public ChequeDetailsForInwardOutward(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.chqNumber = str;
        this.status = str2;
        this.amount = str3;
        this.draweeBnkName = str4;
        this.payerName = str5;
        this.latestTimeStamp = str6;
        this.presentingBankName = str7;
        this.payeeName = str8;
    }

    public final String getChqNumber() {
        return this.chqNumber;
    }

    public final void setChqNumber(String str) {
        this.chqNumber = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getDraweeBnkName() {
        return this.draweeBnkName;
    }

    public final void setDraweeBnkName(String str) {
        this.draweeBnkName = str;
    }

    public final String getPayerName() {
        return this.payerName;
    }

    public final void setPayerName(String str) {
        this.payerName = str;
    }

    public final String getLatestTimeStamp() {
        return this.latestTimeStamp;
    }

    public final void setLatestTimeStamp(String str) {
        this.latestTimeStamp = str;
    }

    public final String getPresentingBankName() {
        return this.presentingBankName;
    }

    public final void setPresentingBankName(String str) {
        this.presentingBankName = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChequeDetailsForInwardOutward(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.g.b.g r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.model.ChequeDetailsForInwardOutward.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getPayeeName() {
        return this.payeeName;
    }

    public final void setPayeeName(String str) {
        this.payeeName = str;
    }
}
