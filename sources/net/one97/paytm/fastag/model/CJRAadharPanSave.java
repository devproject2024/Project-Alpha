package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.util.List;

public class CJRAadharPanSave extends IJRPaytmDataModel {
    private List<CJRAadharPanDocList> documents;
    private Error error;
    private String errorCode;
    private String errorMsg;
    private String iv;
    private String key;
    private boolean minKyc;
    private String statusCode;
    private String statusMessage;

    public boolean isMinKyc() {
        return this.minKyc;
    }

    public void setMinKyc(boolean z) {
        this.minKyc = z;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public List<CJRAadharPanDocList> getDocuments() {
        return this.documents;
    }

    public void setDocuments(List<CJRAadharPanDocList> list) {
        this.documents = list;
    }

    public Error getError() {
        return this.error;
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

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRAadharPanSave cJRAadharPanSave;
        try {
            String b2 = net.one97.paytm.common.utility.f.b(getIv(), getKey(), str);
            q.d(b2);
            cJRAadharPanSave = (CJRAadharPanSave) fVar.a(b2, getClass());
            try {
                q.d(b2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            cJRAadharPanSave = null;
            e.printStackTrace();
            return cJRAadharPanSave;
        }
        return cJRAadharPanSave;
    }

    public class Error {
        private String errorCode;
        private String errorMsg;
        private SubError subError;

        public Error() {
        }

        public SubError getSubError() {
            return this.subError;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            return this.errorMsg;
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
    }
}
