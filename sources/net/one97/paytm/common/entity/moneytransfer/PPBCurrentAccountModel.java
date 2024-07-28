package net.one97.paytm.common.entity.moneytransfer;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class PPBCurrentAccountModel extends IJRPaytmDataModel {
    private final Boolean chequeBook;
    private final Ica ica;
    private final Pdc pdc;
    private final Vdc vdc;

    public final class Ica {
        private final String accountNumber;
        private final String accountStatus;
        private final String branchId;
        private final String caId;
        private final String cifNumber;
        private final String closeReason;
        private final String createdAt;
        private final String createdBy;
        private final String custId;
        private final String firstName;
        private final String ifscCode;
        private final String lastName;
        private final String limit;
        private final List<Nominees> nominees;
        private final String orgId;
        private final String pdcissued;
        private final String pdcpinSet;
        private final String productType;
        private final String productTypeDescription;
        private final String purpose;
        private final String remark;
        private final String status;
        private final String updatedAt;
        private final String updatedBy;

        public Ica() {
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getAccountNumber() {
            return this.accountNumber;
        }

        public final String getProductType() {
            return this.productType;
        }

        public final String getProductTypeDescription() {
            return this.productTypeDescription;
        }

        public final String getIfscCode() {
            return this.ifscCode;
        }

        public final String getUpdatedBy() {
            return this.updatedBy;
        }

        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        public final String getCloseReason() {
            return this.closeReason;
        }

        public final String getRemark() {
            return this.remark;
        }

        public final String getAccountStatus() {
            return this.accountStatus;
        }

        public final String getCustId() {
            return this.custId;
        }

        public final String getCaId() {
            return this.caId;
        }

        public final String getCifNumber() {
            return this.cifNumber;
        }

        public final String getOrgId() {
            return this.orgId;
        }

        public final String getBranchId() {
            return this.branchId;
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public final String getLimit() {
            return this.limit;
        }

        public final String getPurpose() {
            return this.purpose;
        }

        public final String getCreatedBy() {
            return this.createdBy;
        }

        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final String getPdcpinSet() {
            return this.pdcpinSet;
        }

        public final String getPdcissued() {
            return this.pdcissued;
        }

        public final List<Nominees> getNominees() {
            return this.nominees;
        }
    }

    public final class Nominees extends IJRPaytmDataModel {
        private final String areaName;
        private final String city;
        private final String dob;
        private final String email;
        private final String houseNo;
        private final String latitude;
        private final String name;
        private final String nomineeId;
        private final String percentage;
        private final String pinCode;
        private final String relationship;
        private final String state;
        private final String streetName;

        public Nominees() {
        }

        public final String getName() {
            return this.name;
        }

        public final String getDob() {
            return this.dob;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getNomineeId() {
            return this.nomineeId;
        }

        public final String getHouseNo() {
            return this.houseNo;
        }

        public final String getStreetName() {
            return this.streetName;
        }

        public final String getAreaName() {
            return this.areaName;
        }

        public final String getPinCode() {
            return this.pinCode;
        }

        public final String getCity() {
            return this.city;
        }

        public final String getState() {
            return this.state;
        }

        public final String getLatitude() {
            return this.latitude;
        }

        public final String getPercentage() {
            return this.percentage;
        }

        public final String getRelationship() {
            return this.relationship;
        }
    }

    public final class Vdc {
        private final String cardAlias;
        private final String cardDcmsCode;
        private final String cardStatus;
        private final String cardType;
        private final String custId;
        private final String maskedCardNumber;
        private final String processId;
        private final String status;

        public Vdc() {
        }

        public final String getMaskedCardNumber() {
            return this.maskedCardNumber;
        }

        public final String getCardAlias() {
            return this.cardAlias;
        }

        public final String getCardStatus() {
            return this.cardStatus;
        }

        public final String getCardType() {
            return this.cardType;
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getCustId() {
            return this.custId;
        }

        public final String getProcessId() {
            return this.processId;
        }

        public final String getCardDcmsCode() {
            return this.cardDcmsCode;
        }
    }

    public final class Pdc {
        private final String cardAlias;
        private final String cardStatus;
        private final String custId;
        private final String imageId;
        private final String maskedCardNumber;
        private final String orderId;
        private final String status;
        private final String walletQRCode;

        public Pdc() {
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getMaskedCardNumber() {
            return this.maskedCardNumber;
        }

        public final String getCardAlias() {
            return this.cardAlias;
        }

        public final String getCardStatus() {
            return this.cardStatus;
        }

        public final String getImageId() {
            return this.imageId;
        }

        public final String getWalletQRCode() {
            return this.walletQRCode;
        }

        public final String getOrderId() {
            return this.orderId;
        }

        public final String getCustId() {
            return this.custId;
        }
    }

    public final Ica getIca() {
        return this.ica;
    }

    public final Vdc getVdc() {
        return this.vdc;
    }

    public final Pdc getPdc() {
        return this.pdc;
    }
}
