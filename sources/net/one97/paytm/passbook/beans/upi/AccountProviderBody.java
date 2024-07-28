package net.one97.paytm.passbook.beans.upi;

import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class AccountProviderBody extends IJRDataModel {
    @c(a = "details")
    private AccountProviderDetails details;

    public AccountProviderDetails getDetails() {
        return this.details;
    }

    public void setDetails(AccountProviderDetails accountProviderDetails) {
        this.details = accountProviderDetails;
    }

    public static class AccountProviderDetails extends IJRDataModel {
        @c(a = "providers")
        private List<AccountProvider> providers;

        public List<AccountProvider> getProviders() {
            return this.providers;
        }

        public void setProviders(List<AccountProvider> list) {
            this.providers = list;
        }
    }

    public static class AccountProvider extends IJRDataModel {
        @c(a = "account-provider")
        private String accountProvider;
        @c(a = "logo-url")
        private String bankLogoUrl;
        private String displayName;
        @c(a = "id")
        private int id;
        @c(a = "ifsc")
        private String ifsc;
        @c(a = "iin")
        private String iin;
        @c(a = "reg-mob-format")
        private String regMobFormat;

        public String getIfsc() {
            return this.ifsc;
        }

        public void setIfsc(String str) {
            this.ifsc = str;
        }

        public String getId() {
            return String.valueOf(this.id);
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public String getRegMobFormat() {
            return this.regMobFormat;
        }

        public void setRegMobFormat(String str) {
            this.regMobFormat = str;
        }

        public String getIin() {
            return this.iin;
        }

        public void setIin(String str) {
            this.iin = str;
        }

        public String getAccountProvider() {
            return this.accountProvider;
        }

        public void setAccountProvider(String str) {
            this.accountProvider = str;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public String getBankLogoUrl() {
            return this.bankLogoUrl;
        }

        public void setBankLogoUrl(String str) {
            this.bankLogoUrl = str;
        }
    }

    public static class AccountProviderSectionIndex extends IJRDataModel {
        private final String sectionLabel;

        public AccountProviderSectionIndex(String str) {
            this.sectionLabel = str;
        }

        public String getSectionLabel() {
            return this.sectionLabel;
        }
    }
}
