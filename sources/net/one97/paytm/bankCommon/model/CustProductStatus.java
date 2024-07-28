package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CustProductStatus extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "errorMessage")
    private String errorMessage;
    @b(a = "kycDetailsResponse")
    private KycDetailsRequest kycDetailsResponse;
    @b(a = "prerequisitesMap")
    private PrerequisitesMap prerequisitesMap;
    @b(a = "product")
    private String product;

    public String getProduct() {
        return this.product;
    }

    public KycDetailsRequest getKycDetailsResponse() {
        return this.kycDetailsResponse;
    }

    public void setKycDetailsResponse(KycDetailsRequest kycDetailsRequest) {
        this.kycDetailsResponse = kycDetailsRequest;
    }

    public String getKYC() {
        PrerequisitesMap prerequisitesMap2 = this.prerequisitesMap;
        if (prerequisitesMap2 != null) {
            return prerequisitesMap2.KYC;
        }
        return null;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getTNC() {
        PrerequisitesMap prerequisitesMap2 = this.prerequisitesMap;
        if (prerequisitesMap2 != null) {
            return prerequisitesMap2.TNC;
        }
        return null;
    }

    public String getPasscode() {
        PrerequisitesMap prerequisitesMap2 = this.prerequisitesMap;
        if (prerequisitesMap2 != null) {
            return prerequisitesMap2.PASSCODE;
        }
        return null;
    }

    public String getNominee() {
        PrerequisitesMap prerequisitesMap2 = this.prerequisitesMap;
        if (prerequisitesMap2 != null) {
            return prerequisitesMap2.NOMINEE;
        }
        return null;
    }

    public String getAadhaarRec() {
        KycDetailsRequest kycDetailsRequest = this.kycDetailsResponse;
        if (kycDetailsRequest != null) {
            return kycDetailsRequest.aadhaarRec;
        }
        return null;
    }

    public String getPanRec() {
        KycDetailsRequest kycDetailsRequest = this.kycDetailsResponse;
        if (kycDetailsRequest != null) {
            return kycDetailsRequest.panRec;
        }
        return null;
    }

    public String getForm60Rec() {
        KycDetailsRequest kycDetailsRequest = this.kycDetailsResponse;
        if (kycDetailsRequest != null) {
            return kycDetailsRequest.form60Rec;
        }
        return null;
    }

    public String getVDC() {
        PrerequisitesMap prerequisitesMap2 = this.prerequisitesMap;
        if (prerequisitesMap2 != null) {
            return prerequisitesMap2.VDC;
        }
        return null;
    }

    public String getISA() {
        PrerequisitesMap prerequisitesMap2 = this.prerequisitesMap;
        if (prerequisitesMap2 != null) {
            return prerequisitesMap2.ISA;
        }
        return null;
    }

    class PrerequisitesMap {
        String ISA;
        String KYC;
        String NOMINEE;
        String PASSCODE;
        String TNC;
        String VDC;

        private PrerequisitesMap() {
        }
    }

    public class KycDetailsRequest {
        @b(a = "aadhaarRec")
        String aadhaarRec;
        @b(a = "form60Rec")
        String form60Rec;
        @b(a = "kycDoc")
        KycDoc kycDoc;
        @b(a = "panRec")
        String panRec;
        @b(a = "seniorCitizen")
        String seniorCitizen;

        public KycDetailsRequest() {
        }

        public String getSeniorCitizen() {
            return this.seniorCitizen;
        }

        public void setSeniorCitizen(String str) {
            this.seniorCitizen = str;
        }

        public KycDoc getKycDoc() {
            return this.kycDoc;
        }

        public void setKycDoc(KycDoc kycDoc2) {
            this.kycDoc = kycDoc2;
        }

        public String getAadhaarRec() {
            return this.aadhaarRec;
        }

        public void setAadhaarRec(String str) {
            this.aadhaarRec = str;
        }

        public String getPanRec() {
            return this.panRec;
        }

        public void setPanRec(String str) {
            this.panRec = str;
        }

        public String getForm60Rec() {
            return this.form60Rec;
        }

        public void setForm60Rec(String str) {
            this.form60Rec = str;
        }
    }

    public class KycDoc {
        @b(a = "docCode")
        String docCode;
        @b(a = "docRec")
        String docRec;

        public KycDoc() {
        }

        public String getDocCode() {
            return this.docCode;
        }

        public void setDocCode(String str) {
            this.docCode = str;
        }

        public String getDocRec() {
            return this.docRec;
        }

        public void setDocRec(String str) {
            this.docRec = str;
        }
    }
}
