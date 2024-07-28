package com.business.merchant_payments.model.kyc;

import kotlin.g.b.k;

public final class BankDetails {
    public final String bankAccountHolderName;
    public final String bankAccountNumber;
    public final String bankDetailsUuid;
    public final String bankIconUrl;
    public final String bankName;
    public final String ifsc;
    public final String upiAccountId;
    public final boolean walletSettlementAllowed;

    public static /* synthetic */ BankDetails copy$default(BankDetails bankDetails, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i2, Object obj) {
        BankDetails bankDetails2 = bankDetails;
        int i3 = i2;
        return bankDetails.copy((i3 & 1) != 0 ? bankDetails2.bankAccountHolderName : str, (i3 & 2) != 0 ? bankDetails2.bankAccountNumber : str2, (i3 & 4) != 0 ? bankDetails2.bankDetailsUuid : str3, (i3 & 8) != 0 ? bankDetails2.bankIconUrl : str4, (i3 & 16) != 0 ? bankDetails2.bankName : str5, (i3 & 32) != 0 ? bankDetails2.ifsc : str6, (i3 & 64) != 0 ? bankDetails2.upiAccountId : str7, (i3 & 128) != 0 ? bankDetails2.walletSettlementAllowed : z);
    }

    public final String component1() {
        return this.bankAccountHolderName;
    }

    public final String component2() {
        return this.bankAccountNumber;
    }

    public final String component3() {
        return this.bankDetailsUuid;
    }

    public final String component4() {
        return this.bankIconUrl;
    }

    public final String component5() {
        return this.bankName;
    }

    public final String component6() {
        return this.ifsc;
    }

    public final String component7() {
        return this.upiAccountId;
    }

    public final boolean component8() {
        return this.walletSettlementAllowed;
    }

    public final BankDetails copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        k.d(str, "bankAccountHolderName");
        k.d(str2, "bankAccountNumber");
        k.d(str3, "bankDetailsUuid");
        k.d(str4, "bankIconUrl");
        k.d(str5, "bankName");
        String str8 = str6;
        k.d(str8, "ifsc");
        String str9 = str7;
        k.d(str9, "upiAccountId");
        return new BankDetails(str, str2, str3, str4, str5, str8, str9, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankDetails)) {
            return false;
        }
        BankDetails bankDetails = (BankDetails) obj;
        return k.a((Object) this.bankAccountHolderName, (Object) bankDetails.bankAccountHolderName) && k.a((Object) this.bankAccountNumber, (Object) bankDetails.bankAccountNumber) && k.a((Object) this.bankDetailsUuid, (Object) bankDetails.bankDetailsUuid) && k.a((Object) this.bankIconUrl, (Object) bankDetails.bankIconUrl) && k.a((Object) this.bankName, (Object) bankDetails.bankName) && k.a((Object) this.ifsc, (Object) bankDetails.ifsc) && k.a((Object) this.upiAccountId, (Object) bankDetails.upiAccountId) && this.walletSettlementAllowed == bankDetails.walletSettlementAllowed;
    }

    public final int hashCode() {
        String str = this.bankAccountHolderName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bankAccountNumber;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bankDetailsUuid;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bankIconUrl;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bankName;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.ifsc;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.upiAccountId;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i3 = (hashCode6 + i2) * 31;
        boolean z = this.walletSettlementAllowed;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "BankDetails(bankAccountHolderName=" + this.bankAccountHolderName + ", bankAccountNumber=" + this.bankAccountNumber + ", bankDetailsUuid=" + this.bankDetailsUuid + ", bankIconUrl=" + this.bankIconUrl + ", bankName=" + this.bankName + ", ifsc=" + this.ifsc + ", upiAccountId=" + this.upiAccountId + ", walletSettlementAllowed=" + this.walletSettlementAllowed + ")";
    }

    public BankDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        k.d(str, "bankAccountHolderName");
        k.d(str2, "bankAccountNumber");
        k.d(str3, "bankDetailsUuid");
        k.d(str4, "bankIconUrl");
        k.d(str5, "bankName");
        k.d(str6, "ifsc");
        k.d(str7, "upiAccountId");
        this.bankAccountHolderName = str;
        this.bankAccountNumber = str2;
        this.bankDetailsUuid = str3;
        this.bankIconUrl = str4;
        this.bankName = str5;
        this.ifsc = str6;
        this.upiAccountId = str7;
        this.walletSettlementAllowed = z;
    }

    public final String getBankAccountHolderName() {
        return this.bankAccountHolderName;
    }

    public final String getBankAccountNumber() {
        return this.bankAccountNumber;
    }

    public final String getBankDetailsUuid() {
        return this.bankDetailsUuid;
    }

    public final String getBankIconUrl() {
        return this.bankIconUrl;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final String getUpiAccountId() {
        return this.upiAccountId;
    }

    public final boolean getWalletSettlementAllowed() {
        return this.walletSettlementAllowed;
    }
}
