package com.business.merchant_payments.model.kyc;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;

public final class BankEditStatus {
    public final String accountNumber;
    public final String bankAccountName;
    public final String ifsc;
    public final String leadId;
    public final String leadStatus;
    public final String refId;
    public final int statusCode;

    public static /* synthetic */ BankEditStatus copy$default(BankEditStatus bankEditStatus, String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bankEditStatus.accountNumber;
        }
        if ((i3 & 2) != 0) {
            str2 = bankEditStatus.bankAccountName;
        }
        String str7 = str2;
        if ((i3 & 4) != 0) {
            str3 = bankEditStatus.ifsc;
        }
        String str8 = str3;
        if ((i3 & 8) != 0) {
            str4 = bankEditStatus.leadId;
        }
        String str9 = str4;
        if ((i3 & 16) != 0) {
            str5 = bankEditStatus.leadStatus;
        }
        String str10 = str5;
        if ((i3 & 32) != 0) {
            str6 = bankEditStatus.refId;
        }
        String str11 = str6;
        if ((i3 & 64) != 0) {
            i2 = bankEditStatus.statusCode;
        }
        return bankEditStatus.copy(str, str7, str8, str9, str10, str11, i2);
    }

    public final String component1() {
        return this.accountNumber;
    }

    public final String component2() {
        return this.bankAccountName;
    }

    public final String component3() {
        return this.ifsc;
    }

    public final String component4() {
        return this.leadId;
    }

    public final String component5() {
        return this.leadStatus;
    }

    public final String component6() {
        return this.refId;
    }

    public final int component7() {
        return this.statusCode;
    }

    public final BankEditStatus copy(String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        k.d(str, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
        k.d(str2, "bankAccountName");
        k.d(str3, "ifsc");
        k.d(str4, "leadId");
        k.d(str5, "leadStatus");
        k.d(str6, "refId");
        return new BankEditStatus(str, str2, str3, str4, str5, str6, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankEditStatus)) {
            return false;
        }
        BankEditStatus bankEditStatus = (BankEditStatus) obj;
        return k.a((Object) this.accountNumber, (Object) bankEditStatus.accountNumber) && k.a((Object) this.bankAccountName, (Object) bankEditStatus.bankAccountName) && k.a((Object) this.ifsc, (Object) bankEditStatus.ifsc) && k.a((Object) this.leadId, (Object) bankEditStatus.leadId) && k.a((Object) this.leadStatus, (Object) bankEditStatus.leadStatus) && k.a((Object) this.refId, (Object) bankEditStatus.refId) && this.statusCode == bankEditStatus.statusCode;
    }

    public final int hashCode() {
        String str = this.accountNumber;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bankAccountName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ifsc;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.leadId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.leadStatus;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.refId;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return ((hashCode5 + i2) * 31) + this.statusCode;
    }

    public final String toString() {
        return "BankEditStatus(accountNumber=" + this.accountNumber + ", bankAccountName=" + this.bankAccountName + ", ifsc=" + this.ifsc + ", leadId=" + this.leadId + ", leadStatus=" + this.leadStatus + ", refId=" + this.refId + ", statusCode=" + this.statusCode + ")";
    }

    public BankEditStatus(String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        k.d(str, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
        k.d(str2, "bankAccountName");
        k.d(str3, "ifsc");
        k.d(str4, "leadId");
        k.d(str5, "leadStatus");
        k.d(str6, "refId");
        this.accountNumber = str;
        this.bankAccountName = str2;
        this.ifsc = str3;
        this.leadId = str4;
        this.leadStatus = str5;
        this.refId = str6;
        this.statusCode = i2;
    }

    public final String getAccountNumber() {
        return this.accountNumber;
    }

    public final String getBankAccountName() {
        return this.bankAccountName;
    }

    public final String getIfsc() {
        return this.ifsc;
    }

    public final String getLeadId() {
        return this.leadId;
    }

    public final String getLeadStatus() {
        return this.leadStatus;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }
}
