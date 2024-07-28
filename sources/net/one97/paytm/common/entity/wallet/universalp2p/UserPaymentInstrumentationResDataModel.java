package net.one97.paytm.common.entity.wallet.universalp2p;

import net.one97.paytm.common.entity.IJRDataModel;

public class UserPaymentInstrumentationResDataModel implements IJRDataModel {
    private Response response;
    private String status;

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response response2) {
        this.response = response2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public class Bank {
        private String accountNumber;
        private String displayName;
        private String ifsc;
        private String name;

        public Bank() {
        }

        public String getAccountNumber() {
            return this.accountNumber;
        }

        public void setAccountNumber(String str) {
            this.accountNumber = str;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public String getIfsc() {
            return this.ifsc;
        }

        public void setIfsc(String str) {
            this.ifsc = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public static class Response {
        private Bank bank;
        private Upi upi;
        private Wallet wallet;

        public Bank getBank() {
            return this.bank;
        }

        public void setBank(Bank bank2) {
            this.bank = bank2;
        }

        public Upi getUpi() {
            return this.upi;
        }

        public void setUpi(Upi upi2) {
            this.upi = upi2;
        }

        public Wallet getWallet() {
            return this.wallet;
        }

        public void setWallet(Wallet wallet2) {
            this.wallet = wallet2;
        }
    }

    public static class Upi {
        private String displayName;
        private String name;
        private String vpa;

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getVpa() {
            return this.vpa;
        }

        public void setVpa(String str) {
            this.vpa = str;
        }
    }

    public static class Wallet {
        private String displayName;
        private String mobile;
        private String name;

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public String getMobile() {
            return this.mobile;
        }

        public void setMobile(String str) {
            this.mobile = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }
    }
}
