package net.one97.paytm.upi.common.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class CJRAddBeneficiary extends IJRPaytmDataModel implements UpiBaseDataModel {
    private String askOTP;
    @c(a = "data")
    private BeneficiaryData data;
    @c(a = "error")
    private CJRAddBeneficiairyError error;
    @c(a = "referenceNumber")
    private String referenceNumber;
    @c(a = "statusCode")
    private String statusCode;
    @c(a = "statusMessage")
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

    public class CJRAddBeneficiairyError {
        @c(a = "errorCode")
        private String errorCode;
        @c(a = "errorMsg")
        private String errorMsg;

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
    }

    public class BeneficiaryData {
        @c(a = "beneficiaryId")
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
}
