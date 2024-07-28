package com.paytm.business.merchantprofile.model;

import android.text.TextUtils;
import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;
import kotlin.g.b.k;

public final class ChangeBankDetailsModelResponse {
    @c(a = "bankDetailsList")
    public List<BankDetails> bankDetailsList;
    @c(a = "displayMessage")
    public String displayMessage;
    @c(a = "refId")
    public String refId;
    @c(a = "statusCode")
    public String statusCode;

    public static /* synthetic */ ChangeBankDetailsModelResponse copy$default(ChangeBankDetailsModelResponse changeBankDetailsModelResponse, List<BankDetails> list, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = changeBankDetailsModelResponse.bankDetailsList;
        }
        if ((i2 & 2) != 0) {
            str = changeBankDetailsModelResponse.displayMessage;
        }
        if ((i2 & 4) != 0) {
            str2 = changeBankDetailsModelResponse.refId;
        }
        if ((i2 & 8) != 0) {
            str3 = changeBankDetailsModelResponse.statusCode;
        }
        return changeBankDetailsModelResponse.copy(list, str, str2, str3);
    }

    public final List<BankDetails> component1() {
        return this.bankDetailsList;
    }

    public final String component2() {
        return this.displayMessage;
    }

    public final String component3() {
        return this.refId;
    }

    public final String component4() {
        return this.statusCode;
    }

    public final ChangeBankDetailsModelResponse copy(List<BankDetails> list, String str, String str2, String str3) {
        return new ChangeBankDetailsModelResponse(list, str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeBankDetailsModelResponse)) {
            return false;
        }
        ChangeBankDetailsModelResponse changeBankDetailsModelResponse = (ChangeBankDetailsModelResponse) obj;
        return k.a((Object) this.bankDetailsList, (Object) changeBankDetailsModelResponse.bankDetailsList) && k.a((Object) this.displayMessage, (Object) changeBankDetailsModelResponse.displayMessage) && k.a((Object) this.refId, (Object) changeBankDetailsModelResponse.refId) && k.a((Object) this.statusCode, (Object) changeBankDetailsModelResponse.statusCode);
    }

    public final int hashCode() {
        List<BankDetails> list = this.bankDetailsList;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.displayMessage;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.refId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.statusCode;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "ChangeBankDetailsModelResponse(bankDetailsList=" + this.bankDetailsList + ", displayMessage=" + this.displayMessage + ", refId=" + this.refId + ", statusCode=" + this.statusCode + ")";
    }

    public ChangeBankDetailsModelResponse(List<BankDetails> list, String str, String str2, String str3) {
        this.bankDetailsList = list;
        this.displayMessage = str;
        this.refId = str2;
        this.statusCode = str3;
    }

    public final List<BankDetails> getBankDetailsList() {
        return this.bankDetailsList;
    }

    public final void setBankDetailsList(List<BankDetails> list) {
        this.bankDetailsList = list;
    }

    public final String getDisplayMessage() {
        return this.displayMessage;
    }

    public final void setDisplayMessage(String str) {
        this.displayMessage = str;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final void setRefId(String str) {
        this.refId = str;
    }

    public final String getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(String str) {
        this.statusCode = str;
    }

    public static final class BankDetails implements Serializable {
        @c(a = "bankAccountHolderName")
        public String bankAccountHolderName;
        @c(a = "bankAccountNumber")
        public String bankAccountNumber;
        @c(a = "bankDetailsUuid")
        public String bankDetailsUuid;
        @c(a = "bankName")
        public String bankName;
        @c(a = "beneficiaryName")
        public String beneficiaryName;
        @c(a = "ifsc")
        public String ifsc;
        public boolean isCancelChequeFlow;
        public boolean isChangingToPPBL;
        public boolean isExistingBank;
        public boolean isSelected;
        @c(a = "upiAccountId")
        public String upiAccountId;

        public final String getBankAccountHolderName() {
            return this.bankAccountHolderName;
        }

        public final void setBankAccountHolderName(String str) {
            this.bankAccountHolderName = str;
        }

        public final String getBankAccountNumber() {
            return this.bankAccountNumber;
        }

        public final void setBankAccountNumber(String str) {
            this.bankAccountNumber = str;
        }

        public final String getBankDetailsUuid() {
            return this.bankDetailsUuid;
        }

        public final void setBankDetailsUuid(String str) {
            this.bankDetailsUuid = str;
        }

        public final String getBankName() {
            return this.bankName;
        }

        public final void setBankName(String str) {
            this.bankName = str;
        }

        public final String getBeneficiaryName() {
            return this.beneficiaryName;
        }

        public final void setBeneficiaryName(String str) {
            this.beneficiaryName = str;
        }

        public final String getIfsc() {
            return this.ifsc;
        }

        public final void setIfsc(String str) {
            this.ifsc = str;
        }

        public final String getUpiAccountId() {
            return this.upiAccountId;
        }

        public final void setUpiAccountId(String str) {
            this.upiAccountId = str;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final void setSelected(boolean z) {
            this.isSelected = z;
        }

        public final boolean isCancelChequeFlow() {
            return this.isCancelChequeFlow;
        }

        public final void setCancelChequeFlow(boolean z) {
            this.isCancelChequeFlow = z;
        }

        public final boolean isExistingBank() {
            return this.isExistingBank;
        }

        public final void setExistingBank(boolean z) {
            this.isExistingBank = z;
        }

        public final boolean isChangingToPPBL() {
            return this.isChangingToPPBL;
        }

        public final void setChangingToPPBL(boolean z) {
            this.isChangingToPPBL = z;
        }

        public final boolean isEmpty() {
            return this.bankAccountHolderName == null && this.bankAccountNumber == null && this.beneficiaryName == null && this.ifsc == null;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof BankDetails) {
                return getCode().equals(((BankDetails) obj).getCode());
            }
            return super.equals(obj);
        }

        public final int hashCode() {
            String str = this.ifsc;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public final String getCode() {
            String str;
            String str2 = this.ifsc;
            if (!TextUtils.isEmpty(this.bankAccountNumber)) {
                String str3 = this.bankAccountNumber;
                k.a((Object) str3);
                if (str3.length() > 3) {
                    String str4 = this.bankAccountNumber;
                    k.a((Object) str4);
                    String str5 = this.bankAccountNumber;
                    k.a((Object) str5);
                    int length = str5.length() - 4;
                    String str6 = this.bankAccountNumber;
                    k.a((Object) str6);
                    int length2 = str6.length();
                    if (str4 != null) {
                        str = str4.substring(length, length2);
                        k.b(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        return k.a(str2, (Object) str);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            str = "";
            return k.a(str2, (Object) str);
        }
    }
}
