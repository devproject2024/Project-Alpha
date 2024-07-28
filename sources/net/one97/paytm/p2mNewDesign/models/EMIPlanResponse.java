package net.one97.paytm.p2mNewDesign.models;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.network.CJRWalletDataModel;

public class EMIPlanResponse extends CJRWalletDataModel {
    @c(a = "body")
    @a
    private Body body;
    @c(a = "head")
    @a
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

    public static class Body extends CJRWalletDataModel {
        @c(a = "emiDetail")
        @a
        private EmiDetail emiDetail;
        @c(a = "resultInfo")
        @a
        private ResultInfo resultInfo;

        public ResultInfo getResultInfo() {
            return this.resultInfo;
        }

        public void setResultInfo(ResultInfo resultInfo2) {
            this.resultInfo = resultInfo2;
        }

        public EmiDetail getEmiDetail() {
            return this.emiDetail;
        }

        public void setEmiDetail(EmiDetail emiDetail2) {
            this.emiDetail = emiDetail2;
        }
    }

    public static class Head extends CJRWalletDataModel {
        @c(a = "requestId")
        @a
        private String requestId;
        @c(a = "responseTimestamp")
        @a
        private String responseTimestamp;
        @c(a = "version")
        @a
        private String version;

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

        public String getRequestId() {
            return this.requestId;
        }

        public void setRequestId(String str) {
            this.requestId = str;
        }
    }

    public static class MaxAmount extends CJRWalletDataModel {
        @c(a = "currency")
        @a
        private String currency;
        @c(a = "value")
        @a
        private String value;

        public String getCurrency() {
            return this.currency;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public static class MinAmount extends CJRWalletDataModel {
        @c(a = "currency")
        @a
        private String currency;
        @c(a = "value")
        @a
        private String value;

        public String getCurrency() {
            return this.currency;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public static class ResultInfo extends CJRWalletDataModel {
        @c(a = "resultCode")
        @a
        private String resultCode;
        @c(a = "resultMsg")
        @a
        private String resultMsg;
        @c(a = "resultStatus")
        @a
        private String resultStatus;

        public String getResultStatus() {
            return this.resultStatus;
        }

        public void setResultStatus(String str) {
            this.resultStatus = str;
        }

        public String getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(String str) {
            this.resultCode = str;
        }

        public String getResultMsg() {
            return this.resultMsg;
        }

        public void setResultMsg(String str) {
            this.resultMsg = str;
        }
    }

    public static class EmiDetail extends CJRWalletDataModel {
        @c(a = "emiChannelInfos")
        @a
        private List<EmiChannelInfo> emiChannelInfos = null;
        @c(a = "isHybridDisabled")
        @a
        private Boolean isHybridDisabled;

        public List<EmiChannelInfo> getEmiChannelInfos() {
            return this.emiChannelInfos;
        }

        public void setEmiChannelInfos(List<EmiChannelInfo> list) {
            this.emiChannelInfos = list;
        }

        public Boolean getIsHybridDisabled() {
            return this.isHybridDisabled;
        }

        public void setIsHybridDisabled(Boolean bool) {
            this.isHybridDisabled = bool;
        }
    }

    public static class EmiChannelInfo extends CJRWalletDataModel {
        @c(a = "interestRate")
        @a
        private String interestRate;
        @c(a = "maxAmount")
        @a
        private MaxAmount maxAmount;
        @c(a = "minAmount")
        @a
        private MinAmount minAmount;
        @c(a = "ofMonths")
        @a
        private String ofMonths;
        @c(a = "planId")
        @a
        private String planId;

        public String getPlanId() {
            return this.planId;
        }

        public void setPlanId(String str) {
            this.planId = str;
        }

        public String getInterestRate() {
            return this.interestRate;
        }

        public void setInterestRate(String str) {
            this.interestRate = str;
        }

        public String getOfMonths() {
            return this.ofMonths;
        }

        public void setOfMonths(String str) {
            this.ofMonths = str;
        }

        public MinAmount getMinAmount() {
            return this.minAmount;
        }

        public void setMinAmount(MinAmount minAmount2) {
            this.minAmount = minAmount2;
        }

        public MaxAmount getMaxAmount() {
            return this.maxAmount;
        }

        public void setMaxAmount(MaxAmount maxAmount2) {
            this.maxAmount = maxAmount2;
        }
    }
}
