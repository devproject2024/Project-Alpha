package net.one97.paytm.nativesdk.instruments.upipush.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class VpaBankAccountDetail implements BaseVpaDetail {
    private String accRefId;
    private String accountType;
    private String bank;
    private BankMetaData bankMetaData;
    private String branchAddress;
    private List<CredsAllowed> credsAllowed;
    private String ifsc;
    private String maskedAccountNumber;
    private String mpinSet;
    private String name;
    private String pgBankCode;
    private String txnAllowed;
    private VpaAccountDetail vpaDetail;

    public VpaBankAccountDetail() {
        this((String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (BankMetaData) null, (String) null, (VpaAccountDetail) null, 8191, (g) null);
    }

    public static /* synthetic */ VpaBankAccountDetail copy$default(VpaBankAccountDetail vpaBankAccountDetail, String str, String str2, String str3, String str4, List list, String str5, String str6, String str7, String str8, String str9, BankMetaData bankMetaData2, String str10, VpaAccountDetail vpaAccountDetail, int i2, Object obj) {
        VpaBankAccountDetail vpaBankAccountDetail2 = vpaBankAccountDetail;
        int i3 = i2;
        return vpaBankAccountDetail.copy((i3 & 1) != 0 ? vpaBankAccountDetail2.bank : str, (i3 & 2) != 0 ? vpaBankAccountDetail2.ifsc : str2, (i3 & 4) != 0 ? vpaBankAccountDetail2.accRefId : str3, (i3 & 8) != 0 ? vpaBankAccountDetail2.maskedAccountNumber : str4, (i3 & 16) != 0 ? vpaBankAccountDetail2.credsAllowed : list, (i3 & 32) != 0 ? vpaBankAccountDetail2.accountType : str5, (i3 & 64) != 0 ? vpaBankAccountDetail2.name : str6, (i3 & 128) != 0 ? vpaBankAccountDetail2.mpinSet : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? vpaBankAccountDetail2.txnAllowed : str8, (i3 & 512) != 0 ? vpaBankAccountDetail2.branchAddress : str9, (i3 & TarConstants.EOF_BLOCK) != 0 ? vpaBankAccountDetail2.bankMetaData : bankMetaData2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? vpaBankAccountDetail2.pgBankCode : str10, (i3 & 4096) != 0 ? vpaBankAccountDetail2.vpaDetail : vpaAccountDetail);
    }

    public final String component1() {
        return this.bank;
    }

    public final String component10() {
        return this.branchAddress;
    }

    public final BankMetaData component11() {
        return this.bankMetaData;
    }

    public final String component12() {
        return this.pgBankCode;
    }

    public final VpaAccountDetail component13() {
        return this.vpaDetail;
    }

    public final String component2() {
        return this.ifsc;
    }

    public final String component3() {
        return this.accRefId;
    }

    public final String component4() {
        return this.maskedAccountNumber;
    }

    public final List<CredsAllowed> component5() {
        return this.credsAllowed;
    }

    public final String component6() {
        return this.accountType;
    }

    public final String component7() {
        return this.name;
    }

    public final String component8() {
        return this.mpinSet;
    }

    public final String component9() {
        return this.txnAllowed;
    }

    public final VpaBankAccountDetail copy(String str, String str2, String str3, String str4, List<CredsAllowed> list, String str5, String str6, String str7, String str8, String str9, BankMetaData bankMetaData2, String str10, VpaAccountDetail vpaAccountDetail) {
        return new VpaBankAccountDetail(str, str2, str3, str4, list, str5, str6, str7, str8, str9, bankMetaData2, str10, vpaAccountDetail);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VpaBankAccountDetail)) {
            return false;
        }
        VpaBankAccountDetail vpaBankAccountDetail = (VpaBankAccountDetail) obj;
        return k.a((Object) this.bank, (Object) vpaBankAccountDetail.bank) && k.a((Object) this.ifsc, (Object) vpaBankAccountDetail.ifsc) && k.a((Object) this.accRefId, (Object) vpaBankAccountDetail.accRefId) && k.a((Object) this.maskedAccountNumber, (Object) vpaBankAccountDetail.maskedAccountNumber) && k.a((Object) this.credsAllowed, (Object) vpaBankAccountDetail.credsAllowed) && k.a((Object) this.accountType, (Object) vpaBankAccountDetail.accountType) && k.a((Object) this.name, (Object) vpaBankAccountDetail.name) && k.a((Object) this.mpinSet, (Object) vpaBankAccountDetail.mpinSet) && k.a((Object) this.txnAllowed, (Object) vpaBankAccountDetail.txnAllowed) && k.a((Object) this.branchAddress, (Object) vpaBankAccountDetail.branchAddress) && k.a((Object) this.bankMetaData, (Object) vpaBankAccountDetail.bankMetaData) && k.a((Object) this.pgBankCode, (Object) vpaBankAccountDetail.pgBankCode) && k.a((Object) this.vpaDetail, (Object) vpaBankAccountDetail.vpaDetail);
    }

    public final int hashCode() {
        String str = this.bank;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ifsc;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accRefId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.maskedAccountNumber;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<CredsAllowed> list = this.credsAllowed;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        String str5 = this.accountType;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.name;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.mpinSet;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.txnAllowed;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.branchAddress;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        BankMetaData bankMetaData2 = this.bankMetaData;
        int hashCode11 = (hashCode10 + (bankMetaData2 != null ? bankMetaData2.hashCode() : 0)) * 31;
        String str10 = this.pgBankCode;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        VpaAccountDetail vpaAccountDetail = this.vpaDetail;
        if (vpaAccountDetail != null) {
            i2 = vpaAccountDetail.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "VpaBankAccountDetail(bank=" + this.bank + ", ifsc=" + this.ifsc + ", accRefId=" + this.accRefId + ", maskedAccountNumber=" + this.maskedAccountNumber + ", credsAllowed=" + this.credsAllowed + ", accountType=" + this.accountType + ", name=" + this.name + ", mpinSet=" + this.mpinSet + ", txnAllowed=" + this.txnAllowed + ", branchAddress=" + this.branchAddress + ", bankMetaData=" + this.bankMetaData + ", pgBankCode=" + this.pgBankCode + ", vpaDetail=" + this.vpaDetail + ")";
    }

    public VpaBankAccountDetail(String str, String str2, String str3, String str4, List<CredsAllowed> list, String str5, String str6, String str7, String str8, String str9, BankMetaData bankMetaData2, String str10, VpaAccountDetail vpaAccountDetail) {
        this.bank = str;
        this.ifsc = str2;
        this.accRefId = str3;
        this.maskedAccountNumber = str4;
        this.credsAllowed = list;
        this.accountType = str5;
        this.name = str6;
        this.mpinSet = str7;
        this.txnAllowed = str8;
        this.branchAddress = str9;
        this.bankMetaData = bankMetaData2;
        this.pgBankCode = str10;
        this.vpaDetail = vpaAccountDetail;
    }

    public final String getBank() {
        return this.bank;
    }

    public final void setBank(String str) {
        this.bank = str;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final void setIfsc(String str) {
        this.ifsc = str;
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public final void setAccRefId(String str) {
        this.accRefId = str;
    }

    public final String getMaskedAccountNumber() {
        return this.maskedAccountNumber;
    }

    public final void setMaskedAccountNumber(String str) {
        this.maskedAccountNumber = str;
    }

    public final List<CredsAllowed> getCredsAllowed() {
        return this.credsAllowed;
    }

    public final void setCredsAllowed(List<CredsAllowed> list) {
        this.credsAllowed = list;
    }

    public final String getAccountType() {
        return this.accountType;
    }

    public final void setAccountType(String str) {
        this.accountType = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getMpinSet() {
        return this.mpinSet;
    }

    public final void setMpinSet(String str) {
        this.mpinSet = str;
    }

    public final String getTxnAllowed() {
        return this.txnAllowed;
    }

    public final void setTxnAllowed(String str) {
        this.txnAllowed = str;
    }

    public final String getBranchAddress() {
        return this.branchAddress;
    }

    public final void setBranchAddress(String str) {
        this.branchAddress = str;
    }

    public final BankMetaData getBankMetaData() {
        return this.bankMetaData;
    }

    public final void setBankMetaData(BankMetaData bankMetaData2) {
        this.bankMetaData = bankMetaData2;
    }

    public final String getPgBankCode() {
        return this.pgBankCode;
    }

    public final void setPgBankCode(String str) {
        this.pgBankCode = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VpaBankAccountDetail(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.util.List r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, net.one97.paytm.nativesdk.instruments.upipush.model.BankMetaData r25, java.lang.String r26, net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail r27, int r28, kotlin.g.b.g r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r20
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r22
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r23
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = r2
            goto L_0x0062
        L_0x0060:
            r13 = r26
        L_0x0062:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r2 = r27
        L_0x0069:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.nativesdk.instruments.upipush.model.BankMetaData, java.lang.String, net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail, int, kotlin.g.b.g):void");
    }

    public final VpaAccountDetail getVpaDetail() {
        return this.vpaDetail;
    }

    public final void setVpaDetail(VpaAccountDetail vpaAccountDetail) {
        this.vpaDetail = vpaAccountDetail;
    }
}
