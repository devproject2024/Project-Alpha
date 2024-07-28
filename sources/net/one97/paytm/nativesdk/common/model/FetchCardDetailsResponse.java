package net.one97.paytm.nativesdk.common.model;

import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.BinDetail;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.IJRDataModel;

public class FetchCardDetailsResponse implements IJRDataModel {
    private Body body;
    private Head head;

    public Head getHead() {
        return this.head;
    }

    public void setHead(Head head2) {
        this.head = head2;
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body2) {
        this.body = body2;
    }

    public static class Head implements BaseDataModel {
        private String requestId;
        private String responseTimestamp;
        private String version;

        public String getRequestId() {
            return this.requestId;
        }

        public void setRequestId(String str) {
            this.requestId = str;
        }

        public String getResponseTimestamp() {
            return this.responseTimestamp;
        }

        public void setResponseTimestamp(String str) {
            this.responseTimestamp = str;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public static class Body implements BaseDataModel {
        private CardDetails cardDetails;
        private String cardHash;
        private ResultInfo resultInfo;

        public ResultInfo getResultInfo() {
            return this.resultInfo;
        }

        public void setResultInfo(ResultInfo resultInfo2) {
            this.resultInfo = resultInfo2;
        }

        public String getCardHash() {
            return this.cardHash;
        }

        public void setCardHash(String str) {
            this.cardHash = str;
        }

        public CardDetails getCardDetails() {
            return this.cardDetails;
        }

        public void setCardDetails(CardDetails cardDetails2) {
            this.cardDetails = cardDetails2;
        }
    }

    public static class CardDetails implements IJRDataModel {
        private String[] authModes;
        private BinDetail binDetail;
        private EmiDetails emiDetails;
        private HasLowSuccess hasLowSuccessRate;

        public BinDetail getBinDetail() {
            return this.binDetail;
        }

        public void setBinDetail(BinDetail binDetail2) {
            this.binDetail = binDetail2;
        }

        public String[] getAuthModes() {
            return this.authModes;
        }

        public void setAuthModes(String[] strArr) {
            this.authModes = strArr;
        }

        public HasLowSuccess getHasLowSuccessRate() {
            return this.hasLowSuccessRate;
        }

        public void setHasLowSuccessRate(HasLowSuccess hasLowSuccess) {
            this.hasLowSuccessRate = hasLowSuccess;
        }

        public EmiDetails getEmiDetails() {
            return this.emiDetails;
        }

        public void setEmiDetails(EmiDetails emiDetails2) {
            this.emiDetails = emiDetails2;
        }
    }
}
