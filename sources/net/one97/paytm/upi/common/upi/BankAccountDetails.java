package net.one97.paytm.upi.common.upi;

import android.text.TextUtils;
import com.google.gson.a.c;
import com.google.gson.f;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class BankAccountDetails implements UpiBaseDataModel {
    private static final String FEATURE_ENABLED_CONSTANT = "Y";
    @c(a = "accounts")
    private List<BankAccount> accounts = null;

    public List<BankAccount> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<BankAccount> list) {
        this.accounts = list;
    }

    public static class BankAccount implements UpiBaseDataModel {
        @c(a = "CredsAllowed")
        private CredsAllowed CredsAllowed;
        @c(a = "accRefId")
        private String accRefId;
        @c(a = "account")
        private String account;
        @c(a = "accountNumber")
        private String accountNumber;
        @c(a = "accountType")
        private String accountType;
        @c(a = "aeba")
        private String aeba;
        public String availableBalance;
        public String balanceAccountType;
        @c(a = "bank")
        private String bank;
        @c(a = "credsAllowed")
        private List<BankAccountCredentials> bankCredsAllowed;
        @c(a = "bankAccountFeatureList")
        private List<String> bankFilterList;
        @c(a = "logo-url")
        private String bankLogoUrl;
        @c(a = "bankMetaData")
        private UpiBankMetaData bankMetaData;
        @c(a = "bankName")
        private String bankName;
        @c(a = "branchAddress")
        private String branchAddress;
        @c(a = "name")
        private String customerName;
        @c(a = "default-credit")
        private boolean defaultCredit;
        @c(a = "default-debit")
        private boolean defaultDebit;
        public String formattedTimeStamp;
        @c(a = "ifsc")
        private String ifsc;
        @c(a = "isAsbaEnabled")
        private boolean isAsbaEnabled;
        private boolean isSelected;
        @c(a = "maskedAccountNumber")
        private String maskedAccountNumber;
        @c(a = "mbeba")
        private Object mbeba;
        @c(a = "mmid")
        private String mmid;
        @c(a = "mpinSet")
        private String mpinSet;
        private Boolean primaryAccount;
        public boolean progress;
        @c(a = "tempAccRefId")
        private String tempAccRefId;
        public String totalBalance;
        @c(a = "txnAllowed")
        private String txnAllowed;
        @c(a = "warningMessage")
        private String warningMessage;

        public boolean isAsbaEnabled() {
            return this.isAsbaEnabled;
        }

        public void setAsbaEnabled(boolean z) {
            this.isAsbaEnabled = z;
        }

        public List<String> getBankFilterList() {
            return this.bankFilterList;
        }

        public boolean isProgress() {
            return this.progress;
        }

        public void setProgress(boolean z) {
            this.progress = z;
        }

        public void setPrimaryAccount(Boolean bool) {
            this.primaryAccount = bool;
        }

        public Boolean getPrimaryAccount() {
            return this.primaryAccount;
        }

        public void setBankCredsAllowed(List<BankAccountCredentials> list) {
            this.bankCredsAllowed = list;
        }

        public List<BankAccountCredentials> getBankCredsAllowed() {
            return this.bankCredsAllowed;
        }

        public boolean isDefaultDebit() {
            return this.defaultDebit;
        }

        public void setDefaultDebit(boolean z) {
            this.defaultDebit = z;
        }

        public boolean isDefaultCredit() {
            return this.defaultCredit;
        }

        public void setDefaultCredit(boolean z) {
            this.defaultCredit = z;
        }

        public String getAccountType() {
            return this.accountType;
        }

        public void setAccountType(String str) {
            this.accountType = str;
        }

        public String getTxnAllowed() {
            return this.txnAllowed;
        }

        public void setTxnAllowed(String str) {
            this.txnAllowed = str;
        }

        public String getBranchAddress() {
            return this.branchAddress;
        }

        public void setBranchAddress(String str) {
            this.branchAddress = str;
        }

        public String getWarningMessage() {
            return this.warningMessage;
        }

        public void setWarningMessage(String str) {
            this.warningMessage = str;
        }

        public Object getMbeba() {
            return this.mbeba;
        }

        public void setMbeba(Object obj) {
            this.mbeba = obj;
        }

        public String getMmid() {
            return this.mmid;
        }

        public void setMmid(String str) {
            this.mmid = str;
        }

        public String getCustomerName() {
            return this.customerName;
        }

        public void setCustomerName(String str) {
            this.customerName = str;
        }

        public String getAeba() {
            return this.aeba;
        }

        public void setAeba(String str) {
            this.aeba = str;
        }

        public String getAccount() {
            if (!TextUtils.isEmpty(this.accountNumber)) {
                return this.accountNumber;
            }
            return this.account;
        }

        public void setAccount(String str) {
            this.account = str;
            this.accountNumber = str;
        }

        public String getAccRefNumber() {
            if (!TextUtils.isEmpty(this.accountNumber)) {
                return this.accountNumber;
            }
            return this.account;
        }

        public void setAccRefNumber(String str) {
            this.account = str;
            this.accountNumber = str;
        }

        public String getMaskedAccountNumber() {
            return this.maskedAccountNumber;
        }

        public void setCredsAllowed(CredsAllowed credsAllowed) {
            this.CredsAllowed = credsAllowed;
        }

        public CredsAllowed getCredsAllowed() {
            if (this.bankCredsAllowed == null) {
                return this.CredsAllowed;
            }
            CredsAllowed credsAllowed = new CredsAllowed();
            credsAllowed.setChild(this.bankCredsAllowed);
            return credsAllowed;
        }

        public void setAccRefId(String str) {
            this.accRefId = str;
        }

        public String getAccRefId() {
            return this.accRefId;
        }

        public String getTempAccRefId() {
            return this.tempAccRefId;
        }

        public String getIfsc() {
            return this.ifsc;
        }

        public void setIfsc(String str) {
            this.ifsc = str;
        }

        public UpiBankMetaData getBankMetaData() {
            return this.bankMetaData;
        }

        public boolean isMpinSet() {
            Object obj = this.mbeba;
            if (obj != null && (obj instanceof String)) {
                return BankAccountDetails.FEATURE_ENABLED_CONSTANT.equalsIgnoreCase((String) getMbeba());
            }
            if (!TextUtils.isEmpty(this.mpinSet)) {
                return BankAccountDetails.FEATURE_ENABLED_CONSTANT.equalsIgnoreCase(this.mpinSet);
            }
            return false;
        }

        public void setBankName(String str) {
            this.bankName = str;
        }

        public String getBankName() {
            if (!TextUtils.isEmpty(this.bank)) {
                return this.bank;
            }
            return this.bankName;
        }

        public String getCredsAsJson() {
            f fVar = new f();
            List<BankAccountCredentials> list = this.bankCredsAllowed;
            if (list != null) {
                return fVar.b(list);
            }
            return fVar.b(this.CredsAllowed.getChild());
        }

        public boolean isFormat2Bank() {
            CredsAllowed credsAllowed;
            List<BankAccountCredentials> list = this.bankCredsAllowed;
            if (list == null && (credsAllowed = this.CredsAllowed) != null) {
                list = credsAllowed.getChild();
            }
            if (list == null) {
                return false;
            }
            for (BankAccountCredentials access$000 : list) {
                if ("ATMPIN".equalsIgnoreCase(access$000.credsAllowedSubType)) {
                    return true;
                }
            }
            return false;
        }

        public String getBankLogoUrl() {
            return this.bankLogoUrl;
        }

        public void setBankLogoUrl(String str) {
            this.bankLogoUrl = str;
        }

        public String getTotalBalance() {
            return this.totalBalance;
        }

        public void setTotalBalance(String str) {
            this.totalBalance = str;
        }

        public String getAvailableBalance() {
            return this.availableBalance;
        }

        public void setAvailableBalance(String str) {
            this.availableBalance = str;
        }

        public String getBalanceAccountType() {
            return this.balanceAccountType;
        }

        public void setBalanceAccountType(String str) {
            this.balanceAccountType = str;
        }

        public String getFormattedTimeStamp() {
            return this.formattedTimeStamp;
        }

        public void setFormattedTimeStamp(String str) {
            this.formattedTimeStamp = str;
        }

        public boolean isSelected() {
            return this.isSelected;
        }

        public void setSelected(boolean z) {
            this.isSelected = z;
        }
    }

    public static class CredsAllowed implements UpiBaseDataModel {
        @c(a = "Child")
        private List<BankAccountCredentials> child = null;

        public List<BankAccountCredentials> getChild() {
            return this.child;
        }

        public void setChild(List<BankAccountCredentials> list) {
            this.child = list;
        }
    }

    public static class BankAccountCredentials implements UpiBaseDataModel {
        @c(a = "CredsAllowedDLength")
        private String credsAllowedDLength;
        @c(a = "CredsAllowedDType")
        private String credsAllowedDType;
        /* access modifiers changed from: private */
        @c(a = "CredsAllowedSubType")
        public String credsAllowedSubType;
        @c(a = "CredsAllowedType")
        private String credsAllowedType;
        @c(a = "dLength")
        private String dLength;

        public String getCredsAllowedSubType() {
            return this.credsAllowedSubType;
        }

        public void setCredsAllowedSubType1(String str) {
            this.credsAllowedSubType = str;
        }

        public String getDLength() {
            return this.dLength;
        }

        public void setDLength1(String str) {
            this.dLength = str;
        }

        public String getCredsAllowedDLength() {
            return this.credsAllowedDLength;
        }

        public void setCredsAllowedDLength(String str) {
            this.credsAllowedDLength = str;
        }

        public String getCredsAllowedType() {
            return this.credsAllowedType;
        }

        public void setCredsAllowedType(String str) {
            this.credsAllowedType = str;
        }

        public String getCredsAllowedDType() {
            return "Numeric".equalsIgnoreCase(this.credsAllowedDType) ? "NUM" : "NUM | ALPH";
        }

        public void setCredsAllowedDType(String str) {
            this.credsAllowedDType = str;
        }
    }
}
