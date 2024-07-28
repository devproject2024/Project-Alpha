package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.models.BeneficiaryEntity;

public class CJRKYCBeneficiaryBase extends IJRPaytmDataModel implements UpiBaseDataModel {
    private static final long serialVersionUID = 2;
    @b(a = "data")
    private ArrayList<BeneficiaryEntity> data;
    @b(a = "error")
    private CJRKYCBeneficiaryError error;
    @b(a = "totalCount")
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
        @b(a = "errorCode")
        private String errorCode;
        @b(a = "errorMsg")
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
