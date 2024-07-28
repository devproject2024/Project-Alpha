package net.one97.paytm.common.entity.wallet.universalp2p;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class FetchMerchantUserInfoResponse extends CJRWalletDataModel implements IJRDataModel {
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

    public String toString() {
        return "ClassPojo [head = " + this.head + ", body = " + this.body + "]";
    }

    public class Body implements IJRDataModel {
        private String extraParamsMap;
        private MerchantInfoResp merchantInfoResp;
        private ResultInfo resultInfo;
        private UserInfoResp userInfoResp;

        public Body() {
        }

        public MerchantInfoResp getMerchantInfoResp() {
            return this.merchantInfoResp;
        }

        public void setMerchantInfoResp(MerchantInfoResp merchantInfoResp2) {
            this.merchantInfoResp = merchantInfoResp2;
        }

        public String getExtraParamsMap() {
            return this.extraParamsMap;
        }

        public void setExtraParamsMap(String str) {
            this.extraParamsMap = str;
        }

        public UserInfoResp getUserInfoResp() {
            return this.userInfoResp;
        }

        public void setUserInfoResp(UserInfoResp userInfoResp2) {
            this.userInfoResp = userInfoResp2;
        }

        public ResultInfo getResultInfo() {
            return this.resultInfo;
        }

        public void setResultInfo(ResultInfo resultInfo2) {
            this.resultInfo = resultInfo2;
        }

        public String toString() {
            return "ClassPojo [merchantInfoResp = " + this.merchantInfoResp + ", extraParamsMap = " + this.extraParamsMap + ", userInfoResp = " + this.userInfoResp + ", resultInfo = " + this.resultInfo + "]";
        }
    }

    public class UserInfoResp implements IJRDataModel {
        private String userInfo;

        public UserInfoResp() {
        }

        public String getUserInfo() {
            return this.userInfo;
        }

        public void setUserInfo(String str) {
            this.userInfo = str;
        }

        public String toString() {
            return "ClassPojo [userInfo = " + this.userInfo + "]";
        }
    }

    public class MerchantInfoResp implements IJRDataModel {
        private String merBusName;
        private String merDispname;
        private String merLogoUrl;

        public MerchantInfoResp() {
        }

        public String getMerBusName() {
            return this.merBusName;
        }

        public void setMerBusName(String str) {
            this.merBusName = str;
        }

        public String getMerLogoUrl() {
            return this.merLogoUrl;
        }

        public void setMerLogoUrl(String str) {
            this.merLogoUrl = str;
        }

        public String getMerDispname() {
            return this.merDispname;
        }

        public void setMerDispname(String str) {
            this.merDispname = str;
        }

        public String toString() {
            return "ClassPojo [merBusName = " + this.merBusName + ", merLogoUrl = " + this.merLogoUrl + ", merDispname = " + this.merDispname + "]";
        }
    }

    public class ResultInfo implements IJRDataModel {
        private String resultCode;
        private String resultMsg;
        private String resultStatus;

        public ResultInfo() {
        }

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

        public String toString() {
            return "ClassPojo [resultStatus = " + this.resultStatus + ", resultCode = " + this.resultCode + ", resultMsg = " + this.resultMsg + "]";
        }
    }

    public class Head implements IJRDataModel {
        private String responseTimestamp;
        private String version;

        public Head() {
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

        public String toString() {
            return "ClassPojo [responseTimestamp = " + this.responseTimestamp + ", version = " + this.version + "]";
        }
    }
}
