package net.one97.paytm.p2mNewDesign.models;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gson.f;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class BankAccountsV2 extends CJRWalletDataModel {
    @b(a = "CredsAllowed")
    private CredsAllowedV2 CredsAllowed;
    @b(a = "accRefId")
    private String accRefId;
    @b(a = "accRefNumber")
    private String accRefNumber;
    @b(a = "account")
    private String account;
    @b(a = "accountType")
    private String accountType;
    @b(a = "aeba")
    private String aeba;
    @b(a = "bank")
    private String bank;
    @b(a = "logo-url")
    private String bankLogoUrl;
    @b(a = "bankMetaData")
    private BankMetaDataV2 bankMetaData;
    @b(a = "bankName")
    private String bankName;
    @b(a = "branchAddress")
    private String branchAddress;
    @b(a = "credsAllowed")
    private ArrayList<CredsAllowedV2> credsAllowed;
    @b(a = "ifsc")
    private String ifsc;
    @b(a = "maskedAccountNumber")
    private String maskedAccountNumber;
    @b(a = "mbeba")
    private Object mbeba;
    @b(a = "mmid")
    private String mmid;
    @b(a = "mpinSet")
    private String mpinSet;
    @b(a = "name")
    private String name;
    @b(a = "pgBankCode")
    private String pgBankCode;
    @b(a = "txnAllowed")
    private String txnAllowed;

    public BankAccountsV2() {
        this((String) null, (BankMetaDataV2) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (ArrayList) null, (String) null, (String) null, (Object) null, (String) null, (String) null, (String) null, (String) null, (CredsAllowedV2) null, 1048575, (g) null);
    }

    private final CredsAllowedV2 component20() {
        return this.CredsAllowed;
    }

    public static /* synthetic */ BankAccountsV2 copy$default(BankAccountsV2 bankAccountsV2, String str, BankMetaDataV2 bankMetaDataV2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, ArrayList arrayList, String str11, String str12, Object obj, String str13, String str14, String str15, String str16, CredsAllowedV2 credsAllowedV2, int i2, Object obj2) {
        BankAccountsV2 bankAccountsV22 = bankAccountsV2;
        int i3 = i2;
        return bankAccountsV2.copy((i3 & 1) != 0 ? bankAccountsV22.accRefId : str, (i3 & 2) != 0 ? bankAccountsV22.bankMetaData : bankMetaDataV2, (i3 & 4) != 0 ? bankAccountsV22.bank : str2, (i3 & 8) != 0 ? bankAccountsV22.accountType : str3, (i3 & 16) != 0 ? bankAccountsV22.name : str4, (i3 & 32) != 0 ? bankAccountsV22.branchAddress : str5, (i3 & 64) != 0 ? bankAccountsV22.mpinSet : str6, (i3 & 128) != 0 ? bankAccountsV22.ifsc : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? bankAccountsV22.txnAllowed : str8, (i3 & 512) != 0 ? bankAccountsV22.pgBankCode : str9, (i3 & TarConstants.EOF_BLOCK) != 0 ? bankAccountsV22.maskedAccountNumber : str10, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? bankAccountsV22.credsAllowed : arrayList, (i3 & 4096) != 0 ? bankAccountsV22.bankName : str11, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? bankAccountsV22.bankLogoUrl : str12, (i3 & 16384) != 0 ? bankAccountsV22.mbeba : obj, (i3 & 32768) != 0 ? bankAccountsV22.mmid : str13, (i3 & 65536) != 0 ? bankAccountsV22.aeba : str14, (i3 & 131072) != 0 ? bankAccountsV22.account : str15, (i3 & 262144) != 0 ? bankAccountsV22.accRefNumber : str16, (i3 & 524288) != 0 ? bankAccountsV22.CredsAllowed : credsAllowedV2);
    }

    public final String component1() {
        return this.accRefId;
    }

    public final String component10() {
        return this.pgBankCode;
    }

    public final String component11() {
        return this.maskedAccountNumber;
    }

    public final ArrayList<CredsAllowedV2> component12() {
        return this.credsAllowed;
    }

    public final String component13() {
        return this.bankName;
    }

    public final String component14() {
        return this.bankLogoUrl;
    }

    public final Object component15() {
        return this.mbeba;
    }

    public final String component16() {
        return this.mmid;
    }

    public final String component17() {
        return this.aeba;
    }

    public final String component18() {
        return this.account;
    }

    public final String component19() {
        return this.accRefNumber;
    }

    public final BankMetaDataV2 component2() {
        return this.bankMetaData;
    }

    public final String component3() {
        return this.bank;
    }

    public final String component4() {
        return this.accountType;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.branchAddress;
    }

    public final String component7() {
        return this.mpinSet;
    }

    public final String component8() {
        return this.ifsc;
    }

    public final String component9() {
        return this.txnAllowed;
    }

    public final BankAccountsV2 copy(String str, BankMetaDataV2 bankMetaDataV2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, ArrayList<CredsAllowedV2> arrayList, String str11, String str12, Object obj, String str13, String str14, String str15, String str16, CredsAllowedV2 credsAllowedV2) {
        return new BankAccountsV2(str, bankMetaDataV2, str2, str3, str4, str5, str6, str7, str8, str9, str10, arrayList, str11, str12, obj, str13, str14, str15, str16, credsAllowedV2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankAccountsV2)) {
            return false;
        }
        BankAccountsV2 bankAccountsV2 = (BankAccountsV2) obj;
        return k.a((Object) this.accRefId, (Object) bankAccountsV2.accRefId) && k.a((Object) this.bankMetaData, (Object) bankAccountsV2.bankMetaData) && k.a((Object) this.bank, (Object) bankAccountsV2.bank) && k.a((Object) this.accountType, (Object) bankAccountsV2.accountType) && k.a((Object) this.name, (Object) bankAccountsV2.name) && k.a((Object) this.branchAddress, (Object) bankAccountsV2.branchAddress) && k.a((Object) this.mpinSet, (Object) bankAccountsV2.mpinSet) && k.a((Object) this.ifsc, (Object) bankAccountsV2.ifsc) && k.a((Object) this.txnAllowed, (Object) bankAccountsV2.txnAllowed) && k.a((Object) this.pgBankCode, (Object) bankAccountsV2.pgBankCode) && k.a((Object) this.maskedAccountNumber, (Object) bankAccountsV2.maskedAccountNumber) && k.a((Object) this.credsAllowed, (Object) bankAccountsV2.credsAllowed) && k.a((Object) this.bankName, (Object) bankAccountsV2.bankName) && k.a((Object) this.bankLogoUrl, (Object) bankAccountsV2.bankLogoUrl) && k.a(this.mbeba, bankAccountsV2.mbeba) && k.a((Object) this.mmid, (Object) bankAccountsV2.mmid) && k.a((Object) this.aeba, (Object) bankAccountsV2.aeba) && k.a((Object) this.account, (Object) bankAccountsV2.account) && k.a((Object) this.accRefNumber, (Object) bankAccountsV2.accRefNumber) && k.a((Object) this.CredsAllowed, (Object) bankAccountsV2.CredsAllowed);
    }

    public final int hashCode() {
        String str = this.accRefId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        BankMetaDataV2 bankMetaDataV2 = this.bankMetaData;
        int hashCode2 = (hashCode + (bankMetaDataV2 != null ? bankMetaDataV2.hashCode() : 0)) * 31;
        String str2 = this.bank;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accountType;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.branchAddress;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mpinSet;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.ifsc;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.txnAllowed;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.pgBankCode;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.maskedAccountNumber;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        ArrayList<CredsAllowedV2> arrayList = this.credsAllowed;
        int hashCode12 = (hashCode11 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str11 = this.bankName;
        int hashCode13 = (hashCode12 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.bankLogoUrl;
        int hashCode14 = (hashCode13 + (str12 != null ? str12.hashCode() : 0)) * 31;
        Object obj = this.mbeba;
        int hashCode15 = (hashCode14 + (obj != null ? obj.hashCode() : 0)) * 31;
        String str13 = this.mmid;
        int hashCode16 = (hashCode15 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.aeba;
        int hashCode17 = (hashCode16 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.account;
        int hashCode18 = (hashCode17 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.accRefNumber;
        int hashCode19 = (hashCode18 + (str16 != null ? str16.hashCode() : 0)) * 31;
        CredsAllowedV2 credsAllowedV2 = this.CredsAllowed;
        if (credsAllowedV2 != null) {
            i2 = credsAllowedV2.hashCode();
        }
        return hashCode19 + i2;
    }

    public final String toString() {
        return "BankAccountsV2(accRefId=" + this.accRefId + ", bankMetaData=" + this.bankMetaData + ", bank=" + this.bank + ", accountType=" + this.accountType + ", name=" + this.name + ", branchAddress=" + this.branchAddress + ", mpinSet=" + this.mpinSet + ", ifsc=" + this.ifsc + ", txnAllowed=" + this.txnAllowed + ", pgBankCode=" + this.pgBankCode + ", maskedAccountNumber=" + this.maskedAccountNumber + ", credsAllowed=" + this.credsAllowed + ", bankName=" + this.bankName + ", bankLogoUrl=" + this.bankLogoUrl + ", mbeba=" + this.mbeba + ", mmid=" + this.mmid + ", aeba=" + this.aeba + ", account=" + this.account + ", accRefNumber=" + this.accRefNumber + ", CredsAllowed=" + this.CredsAllowed + ")";
    }

    public final String getAccRefId() {
        return this.accRefId;
    }

    public final void setAccRefId(String str) {
        this.accRefId = str;
    }

    public final BankMetaDataV2 getBankMetaData() {
        return this.bankMetaData;
    }

    public final void setBankMetaData(BankMetaDataV2 bankMetaDataV2) {
        this.bankMetaData = bankMetaDataV2;
    }

    public final String getBank() {
        return this.bank;
    }

    public final void setBank(String str) {
        this.bank = str;
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

    public final String getBranchAddress() {
        return this.branchAddress;
    }

    public final void setBranchAddress(String str) {
        this.branchAddress = str;
    }

    public final String getMpinSet() {
        return this.mpinSet;
    }

    public final void setMpinSet(String str) {
        this.mpinSet = str;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final void setIfsc(String str) {
        this.ifsc = str;
    }

    public final String getTxnAllowed() {
        return this.txnAllowed;
    }

    public final void setTxnAllowed(String str) {
        this.txnAllowed = str;
    }

    public final String getPgBankCode() {
        return this.pgBankCode;
    }

    public final void setPgBankCode(String str) {
        this.pgBankCode = str;
    }

    public final String getMaskedAccountNumber() {
        return this.maskedAccountNumber;
    }

    public final void setMaskedAccountNumber(String str) {
        this.maskedAccountNumber = str;
    }

    public final ArrayList<CredsAllowedV2> getCredsAllowed() {
        return this.credsAllowed;
    }

    public final void setCredsAllowed(ArrayList<CredsAllowedV2> arrayList) {
        this.credsAllowed = arrayList;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final void setBankName(String str) {
        this.bankName = str;
    }

    public final String getBankLogoUrl() {
        return this.bankLogoUrl;
    }

    public final void setBankLogoUrl(String str) {
        this.bankLogoUrl = str;
    }

    public final Object getMbeba() {
        return this.mbeba;
    }

    public final void setMbeba(Object obj) {
        this.mbeba = obj;
    }

    public final String getMmid() {
        return this.mmid;
    }

    public final void setMmid(String str) {
        this.mmid = str;
    }

    public final String getAeba() {
        return this.aeba;
    }

    public final void setAeba(String str) {
        this.aeba = str;
    }

    public final String getAccount() {
        return this.account;
    }

    public final void setAccount(String str) {
        this.account = str;
    }

    public final String getAccRefNumber() {
        return this.accRefNumber;
    }

    public final void setAccRefNumber(String str) {
        this.accRefNumber = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BankAccountsV2(java.lang.String r22, net.one97.paytm.p2mNewDesign.models.BankMetaDataV2 r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.util.ArrayList r33, java.lang.String r34, java.lang.String r35, java.lang.Object r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, net.one97.paytm.p2mNewDesign.models.CredsAllowedV2 r41, int r42, kotlin.g.b.g r43) {
        /*
            r21 = this;
            r0 = r42
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r22
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r23
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r24
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r25
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r26
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r27
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r28
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r29
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r30
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r31
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r32
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r33
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r34
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r35
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r36
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r37
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r38
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r39
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r40
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r20
            if (r0 == 0) goto L_0x00af
            r0 = 0
            goto L_0x00b1
        L_0x00af:
            r0 = r41
        L_0x00b1:
            r22 = r21
            r23 = r1
            r24 = r3
            r25 = r4
            r26 = r5
            r27 = r6
            r28 = r7
            r29 = r8
            r30 = r9
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r35 = r14
            r36 = r15
            r37 = r2
            r38 = r16
            r39 = r17
            r40 = r18
            r41 = r19
            r42 = r0
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.models.BankAccountsV2.<init>(java.lang.String, net.one97.paytm.p2mNewDesign.models.BankMetaDataV2, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, java.lang.String, java.lang.String, java.lang.Object, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.models.CredsAllowedV2, int, kotlin.g.b.g):void");
    }

    public BankAccountsV2(String str, BankMetaDataV2 bankMetaDataV2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, ArrayList<CredsAllowedV2> arrayList, String str11, String str12, Object obj, String str13, String str14, String str15, String str16, CredsAllowedV2 credsAllowedV2) {
        this.accRefId = str;
        this.bankMetaData = bankMetaDataV2;
        this.bank = str2;
        this.accountType = str3;
        this.name = str4;
        this.branchAddress = str5;
        this.mpinSet = str6;
        this.ifsc = str7;
        this.txnAllowed = str8;
        this.pgBankCode = str9;
        this.maskedAccountNumber = str10;
        this.credsAllowed = arrayList;
        this.bankName = str11;
        this.bankLogoUrl = str12;
        this.mbeba = obj;
        this.mmid = str13;
        this.aeba = str14;
        this.account = str15;
        this.accRefNumber = str16;
        this.CredsAllowed = credsAllowedV2;
    }

    public final String getCredsAsJson() {
        f fVar = new f();
        ArrayList<CredsAllowedV2> arrayList = this.credsAllowed;
        if (arrayList == null) {
            return "";
        }
        String b2 = fVar.b(arrayList);
        k.a((Object) b2, "gson.toJson(this.credsAllowed)");
        return b2;
    }
}
