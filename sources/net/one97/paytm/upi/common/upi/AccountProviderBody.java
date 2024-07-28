package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class AccountProviderBody implements UpiBaseDataModel {
    @c(a = "details")
    private AccountProviderDetails details;

    public AccountProviderDetails getDetails() {
        return this.details;
    }

    public void setDetails(AccountProviderDetails accountProviderDetails) {
        this.details = accountProviderDetails;
    }

    public class AccountProviderDetails implements UpiBaseDataModel {
        @c(a = "providers")
        private List<AccountProvider> providers;
        @c(a = "topProviders")
        private List<AccountProvider> topProviders;

        public AccountProviderDetails() {
        }

        public List<AccountProvider> getProviders() {
            return this.providers;
        }

        public void setProviders(List<AccountProvider> list) {
            this.providers = list;
        }

        public List<AccountProvider> getTopProviders() {
            return this.topProviders;
        }
    }

    public static class AccountProvider implements UpiBaseDataModel {
        @c(a = "_id")
        private Integer _id;
        @c(a = "account-provider")
        private String accountProvider;
        @c(a = "logo-url")
        private String bankLogoUrl;
        @c(a = "id")
        private String id;
        @c(a = "ifsc")
        private String ifsc;
        @c(a = "iin")
        private String iin = "";
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

        public void setId(String str) {
            this.id = str;
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

        public String getBankLogoUrl() {
            return this.bankLogoUrl;
        }

        public void setBankLogoUrl(String str) {
            this.bankLogoUrl = str;
        }

        public Integer get_id() {
            return this._id;
        }

        public void set_id(Integer num) {
            this._id = num;
        }
    }
}
