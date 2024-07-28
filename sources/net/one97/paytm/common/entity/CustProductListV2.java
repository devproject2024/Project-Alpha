package net.one97.paytm.common.entity;

import com.paytm.network.model.IJRPaytmDataModel;

public class CustProductListV2 extends IJRPaytmDataModel {
    private Isa response;
    private String responseCode;
    private String status;
    private boolean success;

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Isa getResponse() {
        return this.response;
    }

    public class Isa {
        private String accountNumber;
        private String accountStatus;
        private String accountType;
        private String cifNumber;
        private String firstName;
        private String ifscCode;
        private String isaStatus;
        private String lastName;

        public Isa() {
        }

        public String getAccountNumber() {
            return this.accountNumber;
        }

        public String getAccountStatus() {
            return this.accountStatus;
        }

        public String getCifNumber() {
            return this.cifNumber;
        }

        public String getIfscCode() {
            return this.ifscCode;
        }

        public String getAccountType() {
            return this.accountType;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getIsaStatus() {
            return this.isaStatus;
        }
    }
}
