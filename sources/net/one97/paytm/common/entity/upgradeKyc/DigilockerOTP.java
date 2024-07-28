package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.IJRDataModel;

public class DigilockerOTP extends IJRPaytmDataModel implements IJRDataModel {
    private Error error;
    private String errorCode;
    private String errorMsg;
    private String iv;
    private String key;
    private String referenceNumber;
    private String statusCode;
    private String statusMessage;

    public class Error {
        private String errorCode;
        private String errorMsg;

        public Error() {
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            return this.errorMsg;
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

    public String getReferenceNumber() {
        return this.referenceNumber;
    }

    public String getStatusMessage() {
        return this.statusMessage;
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

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        DigilockerOTP digilockerOTP;
        try {
            String b2 = net.one97.paytm.common.utility.f.b(getIv(), getKey(), str);
            q.d(b2);
            digilockerOTP = (DigilockerOTP) fVar.a(b2, getClass());
            try {
                q.d(b2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            digilockerOTP = null;
            e.printStackTrace();
            return digilockerOTP;
        }
        return digilockerOTP;
    }
}
