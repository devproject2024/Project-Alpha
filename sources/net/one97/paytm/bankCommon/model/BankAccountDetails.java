package net.one97.paytm.bankCommon.model;

import android.text.TextUtils;
import com.google.gson.f;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class BankAccountDetails extends IJRPaytmDataModel {
    private static final String FEATURE_ENABLED_CONSTANT = "Y";
    @b(a = "accounts")
    private List<BankAccount> accounts = null;

    public List<BankAccount> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<BankAccount> list) {
        this.accounts = list;
    }

    public static class BankAccountCredentials extends IJRPaytmDataModel {
        @b(a = "CredsAllowedDLength")
        private String credsAllowedDLength;
        @b(a = "CredsAllowedDType")
        private String credsAllowedDType;
        /* access modifiers changed from: private */
        @b(a = "CredsAllowedSubType")
        public String credsAllowedSubType;
        @b(a = "CredsAllowedType")
        private String credsAllowedType;
        @b(a = "dLength")
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

    public static class CredsAllowed extends IJRPaytmDataModel {
        @b(a = "Child")
        private List<BankAccountCredentials> child = null;

        public List<BankAccountCredentials> getChild() {
            return this.child;
        }

        public void setChild(List<BankAccountCredentials> list) {
            this.child = list;
        }
    }

    public static class BankAccount extends IJRPaytmDataModel {
        @b(a = "CredsAllowed")
        private CredsAllowed CredsAllowed;
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
        @b(a = "credsAllowed")
        private List<BankAccountCredentials> bankCredsAllowed;
        @b(a = "logo-url")
        private String bankLogoUrl;
        @b(a = "bankName")
        private String bankName;
        @b(a = "name")
        private String customerName;
        @b(a = "default-credit")
        private boolean defaultCredit;
        @b(a = "default-debit")
        private boolean defaultDebit;
        @b(a = "ifsc")
        private String ifsc;
        @b(a = "mbeba")
        private Object mbeba;
        @b(a = "mmid")
        private String mmid;

        public List<BankAccountCredentials> getBankCredsAllowed() {
            return this.bankCredsAllowed;
        }

        public void setBankCredsAllowed(List<BankAccountCredentials> list) {
            this.bankCredsAllowed = list;
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
            return this.account;
        }

        public void setAccount(String str) {
            this.account = str;
        }

        public CredsAllowed getCredsAllowed() {
            if (this.bankCredsAllowed == null) {
                return this.CredsAllowed;
            }
            CredsAllowed credsAllowed = new CredsAllowed();
            credsAllowed.setChild(this.bankCredsAllowed);
            return credsAllowed;
        }

        public void setCredsAllowed(CredsAllowed credsAllowed) {
            this.CredsAllowed = credsAllowed;
        }

        public String getAccRefNumber() {
            return this.accRefNumber;
        }

        public void setAccRefNumber(String str) {
            this.accRefNumber = str;
        }

        public String getIfsc() {
            return this.ifsc;
        }

        public void setIfsc(String str) {
            this.ifsc = str;
        }

        public boolean isMpinSet() {
            Object obj = this.mbeba;
            if (obj == null) {
                return false;
            }
            return obj instanceof String ? BankAccountDetails.FEATURE_ENABLED_CONSTANT.equalsIgnoreCase((String) getMbeba()) : ((Boolean) obj).booleanValue();
        }

        public String getBankName() {
            return !TextUtils.isEmpty(this.bank) ? this.bank : this.bankName;
        }

        public void setBankName(String str) {
            this.bankName = str;
        }

        public String getCredsAsJson() {
            f fVar = new f();
            List<BankAccountCredentials> list = this.bankCredsAllowed;
            return list != null ? fVar.b(list) : fVar.b(this.CredsAllowed.getChild());
        }

        public boolean isFormat2Bank() {
            List<BankAccountCredentials> list = this.bankCredsAllowed;
            if (list == null) {
                list = this.CredsAllowed.getChild();
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
    }
}
