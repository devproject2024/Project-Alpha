package net.one97.paytm.wallet.newdesign.addmoney.model;

import android.text.TextUtils;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class ConsolidatePaymentInstrumentationRes extends IJRPaytmDataModel implements IJRDataModel {
    private GlobalError globalError;
    private boolean isReceiverKyced;
    private String kycState;
    private String merchantId;
    private MerchantInfo merchantInfo;
    private List<PaymentOptionList> paymentOptionList = null;

    public GlobalError getGlobalError() {
        return this.globalError;
    }

    public void setGlobalError(GlobalError globalError2) {
        this.globalError = globalError2;
    }

    public List<PaymentOptionList> getPaymentOptionList() {
        return this.paymentOptionList;
    }

    public void setPaymentOptionList(List<PaymentOptionList> list) {
        this.paymentOptionList = list;
    }

    public MerchantInfo getMerchantInfo() {
        return this.merchantInfo;
    }

    public void setMerchantInfo(MerchantInfo merchantInfo2) {
        this.merchantInfo = merchantInfo2;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public boolean isReceiverKyced() {
        if (!TextUtils.isEmpty(this.kycState)) {
            return "PAYTM_PRIME_WALLET".equalsIgnoreCase(this.kycState) || "PAYTM_ADHAAR_OTP_KYC".equalsIgnoreCase(this.kycState) || "PAYTM_MIN_KYC".equalsIgnoreCase(this.kycState);
        }
        return false;
    }

    public void setReceiverKyced(boolean z) {
        this.isReceiverKyced = z;
    }

    public static class GlobalError {
        private List<Error> errorList = new ArrayList();

        public List<Error> getErrorList() {
            return this.errorList;
        }

        public void setErrorList(List<Error> list) {
            this.errorList = list;
        }
    }

    public static class DestinationPayment {
        private String bankAccountNumber;
        private String bankName;
        private String displayName;
        private Error error;
        private String ifscCode;
        private String paymentType;
        private String phoneNumber;
        private String userPicture;
        private String vpaId;

        public Error getError() {
            return this.error;
        }

        public void setError(Error error2) {
            this.error = error2;
        }

        public String getVpaId() {
            return this.vpaId;
        }

        public void setVpaId(String str) {
            this.vpaId = str;
        }

        public String getBankName() {
            return this.bankName;
        }

        public void setBankName(String str) {
            this.bankName = str;
        }

        public String getPaymentType() {
            return this.paymentType;
        }

        public void setPaymentType(String str) {
            this.paymentType = str;
        }

        public String getIfscCode() {
            return this.ifscCode;
        }

        public void setIfscCode(String str) {
            this.ifscCode = str;
        }

        public String getBankAccountNumber() {
            return this.bankAccountNumber;
        }

        public void setBankAccountNumber(String str) {
            this.bankAccountNumber = str;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public String getUserPicture() {
            return this.userPicture;
        }

        public void setUserPicture(String str) {
            this.userPicture = str;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        public void setPhoneNumber(String str) {
            this.phoneNumber = str;
        }
    }

    public static class PaymentOptionList {
        private DestinationPayment destinationPayment;
        private SourcePayment sourcePayment;

        public SourcePayment getSourcePayment() {
            return this.sourcePayment;
        }

        public void setSourcePayment(SourcePayment sourcePayment2) {
            this.sourcePayment = sourcePayment2;
        }

        public DestinationPayment getDestinationPayment() {
            return this.destinationPayment;
        }

        public void setDestinationPayment(DestinationPayment destinationPayment2) {
            this.destinationPayment = destinationPayment2;
        }
    }

    public static class Error {
        private String code;
        private String message;

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            if (getCode() == null ? error.getCode() != null : !getCode().equals(error.getCode())) {
                return false;
            }
            if (getMessage() != null) {
                return getMessage().equals(error.getMessage());
            }
            return error.getMessage() == null;
        }

        public int hashCode() {
            int i2 = 0;
            int hashCode = (getCode() != null ? getCode().hashCode() : 0) * 31;
            if (getMessage() != null) {
                i2 = getMessage().hashCode();
            }
            return hashCode + i2;
        }
    }

    public static class BankAccountCredentials implements IJRDataModel {
        @c(a = "CredsAllowedDLength")
        private String CredsAllowedDLength;
        @c(a = "CredsAllowedDType")
        private String CredsAllowedDType;
        @c(a = "CredsAllowedSubType")
        private String CredsAllowedSubType;
        @c(a = "CredsAllowedType")
        private String CredsAllowedType;
        @c(a = "dLength")
        private String dLength;

        public String getCredsAllowedSubType() {
            return this.CredsAllowedSubType;
        }

        public void setCredsAllowedSubType1(String str) {
            this.CredsAllowedSubType = str;
        }

        public String getDLength() {
            return this.dLength;
        }

        public void setDLength1(String str) {
            this.dLength = str;
        }

        public String getCredsAllowedDLength() {
            return this.CredsAllowedDLength;
        }

        public void setCredsAllowedDLength(String str) {
            this.CredsAllowedDLength = str;
        }

        public String getCredsAllowedType() {
            return this.CredsAllowedType;
        }

        public void setCredsAllowedType(String str) {
            this.CredsAllowedType = str;
        }

        public String getCredsAllowedDType() {
            return "Numeric".equalsIgnoreCase(this.CredsAllowedDType) ? "NUM" : "NUM | ALPH";
        }

        public void setCredsAllowedDType(String str) {
            this.CredsAllowedDType = str;
        }
    }

    public static class SourcePayment {
        private String accountType;
        private String balance;
        private String bankAccountNumber;
        private String bankName;
        private ArrayList<BankAccountCredentials> credsAllowed;
        private String displayName;
        private Error error;
        private String ifscCode;
        private String mpinSet;
        private String paymentType;
        private String phoneNumber;
        private String userPicture;
        private String vpaId;

        public ArrayList<BankAccountCredentials> getCredsAllowed() {
            return this.credsAllowed;
        }

        public String getMpinSet() {
            return this.mpinSet;
        }

        public String getAccountType() {
            return this.accountType;
        }

        public Error getError() {
            return this.error;
        }

        public void setError(Error error2) {
            this.error = error2;
        }

        public String getVpaId() {
            return this.vpaId;
        }

        public void setVpaId(String str) {
            this.vpaId = str;
        }

        public String getBankAccountNumber() {
            return this.bankAccountNumber;
        }

        public void setBankAccountNumber(String str) {
            this.bankAccountNumber = str;
        }

        public String getIfscCode() {
            return this.ifscCode;
        }

        public void setIfscCode(String str) {
            this.ifscCode = str;
        }

        public String getBankName() {
            return this.bankName;
        }

        public void setBankName(String str) {
            this.bankName = str;
        }

        public String getPaymentType() {
            return this.paymentType;
        }

        public void setPaymentType(String str) {
            this.paymentType = str;
        }

        public String getBalance() {
            return this.balance;
        }

        public void setBalance(String str) {
            this.balance = str;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public String getUserPicture() {
            return this.userPicture;
        }

        public void setUserPicture(String str) {
            this.userPicture = str;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        public void setPhoneNumber(String str) {
            this.phoneNumber = str;
        }
    }

    public class MerchantInfo implements IJRDataModel {
        private String merBusName;
        private String merDispname;
        private String merLogoUrl;
        private String senderTotalBalance;

        public MerchantInfo() {
        }

        public String getSenderTotalBalance() {
            return this.senderTotalBalance;
        }

        public void setSenderTotalBalance(String str) {
            this.senderTotalBalance = str;
        }

        public String getMerDispname() {
            return this.merDispname;
        }

        public void setMerDispname(String str) {
            this.merDispname = str;
        }

        public String getMerBusName() {
            return this.merBusName;
        }

        public void setMerBusName(String str) {
            this.merBusName = str;
        }

        public String getMerLogoUrl() {
            return this.merLogoUrl;
        }

        public void setMerLogoUrl(String str) {
            this.merLogoUrl = str;
        }
    }
}
