package net.one97.paytm.common.entity.verifier;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRVerifierDoVerify extends IJRPaytmDataModel {
    @b(a = "response")
    private CJRVerifierDoVerifyResponse response;
    @b(a = "signature")
    private String signature;

    public CJRVerifierDoVerifyResponse getResponse() {
        return this.response;
    }

    public void setResponse(CJRVerifierDoVerifyResponse cJRVerifierDoVerifyResponse) {
        this.response = cJRVerifierDoVerifyResponse;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public class CJRVerifierDoVerifyResponse implements IJRDataModel {
        @b(a = "body")
        private CJRVerifierDoVerifyBody body;
        @b(a = "head")
        private CJRVerifierHead head;

        public CJRVerifierDoVerifyResponse() {
        }

        public CJRVerifierHead getHead() {
            return this.head;
        }

        public void setHead(CJRVerifierHead cJRVerifierHead) {
            this.head = cJRVerifierHead;
        }

        public CJRVerifierDoVerifyBody getBody() {
            return this.body;
        }

        public void setBody(CJRVerifierDoVerifyBody cJRVerifierDoVerifyBody) {
            this.body = cJRVerifierDoVerifyBody;
        }

        public class CJRVerifierDoVerifyBody implements IJRDataModel {
            @b(a = "canRetry")
            private String canRetry;
            @b(a = "extendInfo")
            private String extendInfo;
            @b(a = "isFinish")
            private String isFinish;
            @b(a = "nextMethod")
            private String nextMethod;
            @b(a = "renderData")
            private CJRVerifierRenderData renderData;
            @b(a = "resultInfo")
            private CJRVerifierDoVerifyResultInfo resultInfo;
            @b(a = "verifyId")
            private String verifyId;

            public CJRVerifierDoVerifyBody() {
            }

            public String getCanRetry() {
                return this.canRetry;
            }

            public void setCanRetry(String str) {
                this.canRetry = str;
            }

            public String getIsFinish() {
                return this.isFinish;
            }

            public void setIsFinish(String str) {
                this.isFinish = str;
            }

            public String getNextMethod() {
                return this.nextMethod;
            }

            public void setNextMethod(String str) {
                this.nextMethod = str;
            }

            public String getExtendInfo() {
                return this.extendInfo;
            }

            public void setExtendInfo(String str) {
                this.extendInfo = str;
            }

            public CJRVerifierRenderData getRenderData() {
                return this.renderData;
            }

            public void setRenderData(CJRVerifierRenderData cJRVerifierRenderData) {
                this.renderData = cJRVerifierRenderData;
            }

            public String getVerifyId() {
                return this.verifyId;
            }

            public void setVerifyId(String str) {
                this.verifyId = str;
            }

            public CJRVerifierDoVerifyResultInfo getResultInfo() {
                return this.resultInfo;
            }

            public void setResultInfo(CJRVerifierDoVerifyResultInfo cJRVerifierDoVerifyResultInfo) {
                this.resultInfo = cJRVerifierDoVerifyResultInfo;
            }

            public class CJRVerifierDoVerifyResultInfo implements IJRDataModel {
                @b(a = "resultCode")
                private String resultCode;
                @b(a = "resultCodeId")
                private String resultCodeId;
                @b(a = "resultMsg")
                private String resultMsg;
                @b(a = "resultStatus")
                private String resultStatus;

                public CJRVerifierDoVerifyResultInfo() {
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
