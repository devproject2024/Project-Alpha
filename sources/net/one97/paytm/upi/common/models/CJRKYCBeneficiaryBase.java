package net.one97.paytm.upi.common.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class CJRKYCBeneficiaryBase extends IJRPaytmDataModel implements UpiBaseDataModel {
    private static final long serialVersionUID = 2;
    @c(a = "data")
    private ArrayList<BeneficiaryEntity> data;
    @c(a = "error")
    private CJRKYCBeneficiaryError error;
    @c(a = "totalCount")
    private int totalCount;

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int i2) {
        this.totalCount = i2;
    }

    public ArrayList<BeneficiaryEntity> getBeneficiariesList() {
        return this.data;
    }

    public void setBeneficiariesList(ArrayList<BeneficiaryEntity> arrayList) {
        this.data = arrayList;
    }

    public CJRKYCBeneficiaryError getError() {
        return this.error;
    }

    public void setError(CJRKYCBeneficiaryError cJRKYCBeneficiaryError) {
        this.error = cJRKYCBeneficiaryError;
    }

    public class CJRKYCBeneficiaryError {
        @c(a = "errorCode")
        private String errorCode;
        @c(a = "errorMsg")
        private String errorMsg;

        public CJRKYCBeneficiaryError() {
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
}
