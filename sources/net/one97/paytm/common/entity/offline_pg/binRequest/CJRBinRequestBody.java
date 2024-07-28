package net.one97.paytm.common.entity.offline_pg.binRequest;

import net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo;

public class CJRBinRequestBody {
    String bin;
    String channelId;
    String deviceId;
    String indutryTypeId;
    String orderId;
    String requestType;
    ResultInfo resultInfo;
    String signature;

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public String getBin() {
        return this.bin;
    }

    public void setBin(String str) {
        this.bin = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String getIndutryTypeId() {
        return this.indutryTypeId;
    }

    public void setIndutryTypeId(String str) {
        this.indutryTypeId = str;
    }

    public void setRequestType(String str) {
        this.requestType = str;
    }
}
