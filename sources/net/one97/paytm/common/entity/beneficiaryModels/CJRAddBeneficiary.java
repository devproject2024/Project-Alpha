package net.one97.paytm.common.entity.beneficiaryModels;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAddBeneficiary extends IJRPaytmDataModel implements IJRDataModel {
    private String askOTP;
    @b(a = "data")
    private BeneficiaryData data;
    @b(a = "error")
    private CJRAddBeneficiairyError error;
    @b(a = "message")
    private String message;
    @b(a = "referenceNumber")
    private String referenceNumber;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;

    public String getAskOTP() {
        return this.askOTP;
    }

    public void setAskOTP(String str) {
        this.askOTP = str;
    }

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public void setReferenceNumber(String str) {
        this.referenceNumber = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public CJRAddBeneficiairyError getError() {
        return this.error;
    }

    public void setError(CJRAddBeneficiairyError cJRAddBeneficiairyError) {
        this.error = cJRAddBeneficiairyError;
    }

    public BeneficiaryData getData() {
        return this.data;
    }

    public void setData(BeneficiaryData beneficiaryData) {
        this.data = beneficiaryData;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public class CJRAddBeneficiairyError {
        @b(a = "errorCode")
        private String errorCode;
        @b(a = "errorMsg")
        private String errorMsg;
        @b(a = "subError")
        private CJRAddBeneficiarySubError subError;

        public CJRAddBeneficiairyError() {
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(String str) {
            this.errorCode = str;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }

        public void setErrorMsg(String str) {
            this.errorMsg = str;
        }

        public CJRAddBeneficiarySubError getSubError() {
            return this.subError;
        }

        public void setSubError(CJRAddBeneficiarySubError cJRAddBeneficiarySubError) {
            this.subError = cJRAddBeneficiarySubError;
        }
    }

    public class BeneficiaryData extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "beneficiaryId")
        private String beneficiaryId;

        public BeneficiaryData() {
        }

        public String getBeneficiaryId() {
            return this.beneficiaryId;
        }

        public void setBeneficiaryId(String str) {
            this.beneficiaryId = str;
        }
    }

    public class CJRAddBeneficiarySubError extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "code")
        private String code;
        @b(a = "message")
        private String message;

        public CJRAddBeneficiarySubError() {
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) fVar.a(str, getClass());
        cJRAddBeneficiary.setAskOTP(getNetworkResponse().headers.get("is_otp_auth_required"));
        return cJRAddBeneficiary;
    }
}
