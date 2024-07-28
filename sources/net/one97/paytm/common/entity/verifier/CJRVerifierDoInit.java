package net.one97.paytm.common.entity.verifier;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRVerifierDoInit implements IJRDataModel {
    @b(a = "response")
    private CJRVerifierDoInitResponse response;
    @b(a = "signature")
    private String signature;

    public CJRVerifierDoInitResponse getResponse() {
        return this.response;
    }

    public void setResponse(CJRVerifierDoInitResponse cJRVerifierDoInitResponse) {
        this.response = cJRVerifierDoInitResponse;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public class CJRVerifierDoInitResponse implements IJRDataModel {
        @b(a = "body")
        private CJRVerifierDoInitBody body;
        @b(a = "head")
        private CJRVerifierHead head;

        public CJRVerifierDoInitResponse() {
        }

        public CJRVerifierHead getHead() {
            return this.head;
        }

        public void setHead(CJRVerifierHead cJRVerifierHead) {
            this.head = cJRVerifierHead;
        }

        public CJRVerifierDoInitBody getBody() {
            return this.body;
        }

        public void setBody(CJRVerifierDoInitBody cJRVerifierDoInitBody) {
            this.body = cJRVerifierDoInitBody;
        }

        public class CJRVerifierDoInitBody implements IJRDataModel {
            @b(a = "method")
            private String method;
            @b(a = "renderData")
            private CJRVerifierRenderData renderData;
            @b(a = "resultInfo")
            private CJRVerifierDoInitResultInfo resultInfo;
            @b(a = "verificationMethods")
            private String verificationMethods;
            @b(a = "verificationState")
            private String verificationState;
            @b(a = "verifyId")
            private String verifyId;

            public CJRVerifierDoInitBody() {
            }

            public String getMethod() {
                return this.method;
            }

            public void setMethod(String str) {
                this.method = str;
            }

            public CJRVerifierRenderData getRenderData() {
                return this.renderData;
            }

            public void setRenderData(CJRVerifierRenderData cJRVerifierRenderData) {
                this.renderData = cJRVerifierRenderData;
            }

            public CJRVerifierDoInitResultInfo getResultInfo() {
                return this.resultInfo;
            }

            public void setResultInfo(CJRVerifierDoInitResultInfo cJRVerifierDoInitResultInfo) {
                this.resultInfo = cJRVerifierDoInitResultInfo;
            }

            public String getVerificationMethods() {
                return this.verificationMethods;
            }

            public void setVerificationMethods(String str) {
                this.verificationMethods = str;
            }

            public String getVerificationState() {
                return this.verificationState;
            }

            public void setVerificationState(String str) {
                this.verificationState = str;
            }

            public String getVerifyId() {
                return this.verifyId;
            }

            public void setVerifyId(String str) {
                this.verifyId = str;
            }

            public class CJRVerifierDoInitResultInfo implements IJRDataModel {
                @b(a = "resultCode")
                private String resultCode;
                @b(a = "resultCodeId")
                private String resultCodeId;
                @b(a = "resultMsg")
                private String resultMsg;
                @b(a = "resultStatus")
                private String resultStatus;

                public CJRVerifierDoInitResultInfo() {
                }

                public String getResultCode() {
                    return this.resultCode;
                }

                public void setResultCode(String str) {
                    this.resultCode = str;
                }

                public String getResultCodeId() {
                    return this.resultCodeId;
                }

                public void setResultCodeId(String str) {
                    this.resultCodeId = str;
                }

                public String getResultMsg() {
                    return this.resultMsg;
                }

                public void setResultMsg(String str) {
                    this.resultMsg = str;
                }

                public String getResultStatus() {
                    return this.resultStatus;
                }

                public void setResultStatus(String str) {
                    this.resultStatus = str;
                }
            }
        }
    }
}
