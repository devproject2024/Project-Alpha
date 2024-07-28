package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.io.Serializable;
import net.one97.paytm.common.entity.IJRDataModel;

public class KycAadharEkycDetails extends IJRPaytmDataModel implements IJRDataModel {
    public Data data;
    private Error error;
    private String errorCode;
    private String errorMsg;
    private String isMinor;
    private String iv;
    private String key;
    private KycResponse kycResponse;
    private String referenceNumber;
    private String statusCode;
    private String statusMessage;

    public class Error {
        private String errorCode;
        private String errorMsg;
        private SubError subError;

        public Error() {
        }

        public SubError getSubError() {
            return this.subError;
        }

        public class SubError {
            private String code;
            private String message;

            public SubError() {
            }

            public String getCode() {
                return this.code;
            }

            public String getMessage() {
                return this.message;
            }
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }
    }

    public String getErrorErrorCode() {
        Error error2 = this.error;
        if (error2 != null) {
            return error2.getErrorCode();
        }
        return null;
    }

    public String getErrorErrorMessage() {
        Error error2 = this.error;
        if (error2 != null) {
            return error2.getErrorMsg();
        }
        return null;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getSubErrorCode() {
        Error error2 = this.error;
        if (error2 == null || error2.getSubError() == null) {
            return null;
        }
        return this.error.getSubError().getCode();
    }

    public String getSubErrorMessage() {
        Error error2 = this.error;
        if (error2 == null || error2.getSubError() == null) {
            return null;
        }
        return this.error.getSubError().getMessage();
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data2) {
        this.data = data2;
    }

    public class KycResponse implements Serializable {
        private String co;
        private String district;
        private String dob;
        private String emailAddress;
        private String gender;
        private String house;
        private String landMark;
        private String location;
        private String name;
        private String phone;
        private String photo;
        private String postOffice;
        private String postalCode;
        private String state;
        private String street;
        private String subdist;
        private String uid;
        private String vtc;

        public KycResponse() {
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public void setDob(String str) {
            this.dob = str;
        }

        public void setCo(String str) {
            this.co = str;
        }

        public void setGender(String str) {
            this.gender = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPhone(String str) {
            this.phone = str;
        }

        public void setDistrict(String str) {
            this.district = str;
        }

        public void setHouse(String str) {
            this.house = str;
        }

        public void setLandMark(String str) {
            this.landMark = str;
        }

        public void setLocation(String str) {
            this.location = str;
        }

        public void setPostalCode(String str) {
            this.postalCode = str;
        }

        public void setPostOffice(String str) {
            this.postOffice = str;
        }

        public void setState(String str) {
            this.state = str;
        }

        public void setStreet(String str) {
            this.street = str;
        }

        public void setSubdist(String str) {
            this.subdist = str;
        }

        public void setVtc(String str) {
            this.vtc = str;
        }

        public void setPhoto(String str) {
            this.photo = str;
        }

        public void setEmailAddress(String str) {
            this.emailAddress = str;
        }

        public String getUid() {
            return this.uid;
        }

        public String getCo() {
            return this.co;
        }

        public String getDob() {
            return this.dob;
        }

        public String getGender() {
            return this.gender;
        }

        public String getName() {
            return this.name;
        }

        public String getPhone() {
            return this.phone;
        }

        public String getDistrict() {
            return this.district;
        }

        public String getHouse() {
            return this.house;
        }

        public String getLandMark() {
            return this.landMark;
        }

        public String getPostOffice() {
            return this.postOffice;
        }

        public String getLocation() {
            return this.location;
        }

        public String getPostalCode() {
            return this.postalCode;
        }

        public String getState() {
            return this.state;
        }

        public String getStreet() {
            return this.street;
        }

        public String getSubdist() {
            return this.subdist;
        }

        public String getVtc() {
            return this.vtc;
        }

        public String getPhoto() {
            return this.photo;
        }

        public String getEmailAddress() {
            return this.emailAddress;
        }
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getIv() {
        return this.iv;
    }

    public void setIv(String str) {
        this.iv = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public Error getError() {
        return this.error;
    }

    public KycResponse getKycResponse() {
        return this.kycResponse;
    }

    public String getIsMinor() {
        return this.isMinor;
    }

    public void setIsMinor(String str) {
        this.isMinor = str;
    }

    public class Data implements Serializable {
        public String isMinor;
        public KycResponse kycResponse;

        public Data() {
        }

        public KycResponse getKycResponse() {
            return this.kycResponse;
        }

        public void setKycResponse(KycResponse kycResponse2) {
            this.kycResponse = kycResponse2;
        }

        public String getIsMinor() {
            return this.isMinor;
        }

        public void setIsMinor(String str) {
            this.isMinor = str;
        }
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        try {
            String b2 = net.one97.paytm.common.utility.f.b(getIv(), getKey(), str);
            KycAadharEkycDetails kycAadharEkycDetails = (KycAadharEkycDetails) fVar.a(b2, getClass());
            try {
                q.d(b2);
                return kycAadharEkycDetails;
            } catch (Exception unused) {
                return kycAadharEkycDetails;
            }
        } catch (Exception unused2) {
            return null;
        }
    }
}
