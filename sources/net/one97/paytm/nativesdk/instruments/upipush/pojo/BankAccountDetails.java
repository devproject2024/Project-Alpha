package net.one97.paytm.nativesdk.instruments.upipush.pojo;

import android.text.TextUtils;
import com.google.gson.a.c;
import com.google.gson.f;
import java.util.List;

public class BankAccountDetails implements IJRDataModel {
    private static final String FEATURE_ENABLED_CONSTANT = "Y";
    @c(a = "accounts")
    private List<BankAccount> accounts = null;

    public List<BankAccount> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(List<BankAccount> list) {
        this.accounts = list;
    }

    public static class BankAccount implements IJRDataModel {
        @c(a = "CredsAllowed")
        private CredsAllowed CredsAllowed;
        @c(a = "accRefId")
        private String accRefId;
        @c(a = "accRefNumber")
        private String accRefNumber;
        @c(a = "account")
        private String account;
        @c(a = "accountType")
        private String accountType;
        @c(a = "aeba")
        private String aeba;
        @c(a = "bank")
        private String bank;
        @c(a = "credsAllowed")
        private List<BankAccountCredentials> bankCredsAllowed;
        @c(a = "bankName")
        private String bankName;
        @c(a = "name")
        private String customerName;
        @c(a = "default-credit")
        private boolean defaultCredit;
        @c(a = "default-debit")
        private boolean defaultDebit;
        @c(a = "ifsc")
        private String ifsc;
        @c(a = "mbeba")
        private Object mbeba;
        @c(a = "mmid")
        private String mmid;

        public String getAccRefId() {
            return this.accRefId;
        }

        public void setAccRefId(String str) {
            this.accRefId = str;
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
            if (obj instanceof String) {
                return BankAccountDetails.FEATURE_ENABLED_CONSTANT.equalsIgnoreCase((String) getMbeba());
            }
            return ((Boolean) obj).booleanValue();
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
    }

    public static class CredsAllowed implements IJRDataModel {
        @c(a = "Child")
        private List<BankAccountCredentials> child = null;

        public List<BankAccountCredentials> getChild() {
            return this.child;
        }

        public void setChild(List<BankAccountCredentials> list) {
            this.child = list;
        }
    }

    public static class BankAccountCredentials implements IJRDataModel {
        @c(a = "CredsAllowedDLength")
        private String credsAllowedDLength;
        @c(a = "CredsAllowedDType")
        private String credsAllowedDType;
        @c(a = "CredsAllowedSubType")
        private String credsAllowedSubType;
        @c(a = "CredsAllowedType")
        private String credsAllowedType;
        @c(a = "dLength")
        private String dLength;

        public BankAccountCredentials(String str, String str2, String str3, String str4, String str5) {
            this.credsAllowedSubType = str;
            this.dLength = str2;
            this.credsAllowedDLength = str3;
            this.credsAllowedType = str4;
            this.credsAllowedDType = str5;
        }

        public BankAccountCredentials() {
        }

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
