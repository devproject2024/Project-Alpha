package net.one97.paytm.bankCommon.model;

import net.one97.paytm.common.entity.IJRDataModel;

public class KycUserDetails implements IJRDataModel {
    private String aadharName;
    private String aadharNumber;
    private String addressType;
    private String altEmail;
    private String altPhoneNumber;
    private String custId;
    private String dob;
    private String fatherOrSpouseFirstName;
    private String fatherOrSpouseLastName;
    private String gender;
    private String isCorrespondanceAddressSameAsAadhar;
    private Boolean isFatherInformation;
    private KycAddress kycAddress;
    private String maritalStatus;
    private String motherFirstName;
    private String motherLastName;
    private String name;
    private String panNumber;
    private String profession;

    public String getFatherOrSpouseFirstName() {
        return this.fatherOrSpouseFirstName;
    }

    public void setFatherOrSpouseFirstName(String str) {
        this.fatherOrSpouseFirstName = str;
    }

    public String getFatherOrSpouseLastName() {
        return this.fatherOrSpouseLastName;
    }

    public void setFatherOrSpouseLastName(String str) {
        this.fatherOrSpouseLastName = str;
    }

    public String getMotherFirstName() {
        return this.motherFirstName;
    }

    public void setMotherFirstName(String str) {
        this.motherFirstName = str;
    }

    public String getMotherLastName() {
        return this.motherLastName;
    }

    public void setMotherLastName(String str) {
        this.motherLastName = str;
    }

    public String getCustId() {
        return this.custId;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public String getDob() {
        return this.dob;
    }

    public String getPanNumber() {
        return this.panNumber;
    }

    public String getAadharNumber() {
        return this.aadharNumber;
    }

    public String getAadharName() {
        return this.aadharName;
    }

    public String getAltEmail() {
        return this.altEmail;
    }

    public String getAltPhoneNumber() {
        return this.altPhoneNumber;
    }

    public String getMaritalStatus() {
        return this.maritalStatus;
    }

    public String getProfession() {
        return this.profession;
    }

    public String getIsCorrespondanceAddressSameAsAadhar() {
        return this.isCorrespondanceAddressSameAsAadhar;
    }

    public String getAddressType() {
        return this.addressType;
    }

    public KycAddress getKycAddress() {
        return this.kycAddress;
    }

    public void setCustId(String str) {
        this.custId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setDob(String str) {
        this.dob = str;
    }

    public void setPanNumber(String str) {
        this.panNumber = str;
    }

    public void setAadharNumber(String str) {
        this.aadharNumber = str;
    }

    public void setAadharName(String str) {
        this.aadharName = str;
    }

    public void setAltEmail(String str) {
        this.altEmail = str;
    }

    public void setAltPhoneNumber(String str) {
        this.altPhoneNumber = str;
    }

    public void setMaritalStatus(String str) {
        this.maritalStatus = str;
    }

    public void setProfession(String str) {
        this.profession = str;
    }

    public void setIsCorrespondanceAddressSameAsAadhar(String str) {
        this.isCorrespondanceAddressSameAsAadhar = str;
    }

    public void setAddressType(String str) {
        this.addressType = str;
    }

    public void setKycAddress(KycAddress kycAddress2) {
        this.kycAddress = kycAddress2;
    }

    public class KycAddress {
        private String addressLine1;
        private String addressLine2;
        private String addressLine3;
        private String city;
        private String pincode;
        private String state;

        public KycAddress() {
        }

        public String getAddressLine1() {
            return this.addressLine1;
        }

        public String getAddressLine2() {
            return this.addressLine2;
        }

        public String getAddressLine3() {
            return this.addressLine3;
        }

        public String getPincode() {
            return this.pincode;
        }

        public String getCity() {
            return this.city;
        }

        public String getState() {
            return this.state;
        }

        public void setAddressLine1(String str) {
            this.addressLine1 = str;
        }

        public void setAddressLine2(String str) {
            this.addressLine2 = str;
        }

        public void setAddressLine3(String str) {
            this.addressLine3 = str;
        }

        public void setPincode(String str) {
            this.pincode = str;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public void setState(String str) {
            this.state = str;
        }
    }

    public Boolean getIsFatherInformation() {
        return this.isFatherInformation;
    }

    public void setIsFatherInformation(Boolean bool) {
        this.isFatherInformation = bool;
    }
}
