package net.one97.paytm.common.entity.verifier;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRVerifierDoView extends IJRPaytmDataModel {
    @b(a = "response")
    private CJRVerifierDoViewResponse response;
    @b(a = "signature")
    private String signature;

    public CJRVerifierDoViewResponse getResponse() {
        return this.response;
    }

    public void setResponse(CJRVerifierDoViewResponse cJRVerifierDoViewResponse) {
        this.response = cJRVerifierDoViewResponse;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public class CJRVerifierDoViewResponse implements IJRDataModel {
        @b(a = "body")
        private CJRVerifierDoViewBody body;
        @b(a = "head")
        private CJRVerifierHead head;

        public CJRVerifierDoViewResponse() {
        }

        public CJRVerifierHead getHead() {
            return this.head;
        }

        public void setHead(CJRVerifierHead cJRVerifierHead) {
            this.head = cJRVerifierHead;
        }

        public CJRVerifierDoViewBody getBody() {
            return this.body;
        }

        public void setBody(CJRVerifierDoViewBody cJRVerifierDoViewBody) {
            this.body = cJRVerifierDoViewBody;
        }

        public class CJRVerifierDoViewBody implements IJRDataModel {
            @b(a = "canRetry")
            private String canRetry;
            @b(a = "isFinish")
            private String isFinish;
            @b(a = "method")
            private String method;
            @b(a = "nextMethod")
            private String nextMethod;
            @b(a = "renderData")
            private CJRVerifierRenderData renderData;
            @b(a = "resultInfo")
            private CJRVerifierDoViewResultInfo resultInfo;
            @b(a = "verifyId")
            private String verifyId;

            public CJRVerifierDoViewBody() {
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
                this.method = str;
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

            public CJRVerifierDoViewResultInfo getResultInfo() {
                return this.resultInfo;
            }

            public void setResultInfo(CJRVerifierDoViewResultInfo cJRVerifierDoViewResultInfo) {
                this.resultInfo = cJRVerifierDoViewResultInfo;
            }

            public String getVerifyId() {
                return this.verifyId;
            }

            public void setVerifyId(String str) {
                this.verifyId = str;
            }

            public class CJRVerifierDoViewResultInfo implements IJRDataModel {
                @b(a = "resultCode")
                private String resultCode;
                @b(a = "resultCodeId")
                private String resultCodeId;
                @b(a = "resultMsg")
                private String resultMsg;
                @b(a = "resultStatus")
                private String resultStatus;

                public CJRVerifierDoViewResultInfo() {
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
