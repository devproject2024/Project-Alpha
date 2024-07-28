package net.one97.paytm.recharge.model.imps;

import com.google.gsonhtcfix.a.b;

public final class CJRImpsRefundBodyModel {
    private String assetId;
    private String channelId;
    @b(a = "resultInfo")
    private CJRImpsRefundResultInfo mResultInfo;
    private String upiAccountId;

    public final String getUpiAccountId() {
        return this.upiAccountId;
    }

    public final void setUpiAccountId(String str) {
        this.upiAccountId = str;
    }

    public final String getAssetId() {
        return this.assetId;
    }

    public final void setAssetId(String str) {
        this.assetId = str;
    }

    public final CJRImpsRefundResultInfo getMResultInfo() {
        return this.mResultInfo;
    }

    public final void setMResultInfo(CJRImpsRefundResultInfo cJRImpsRefundResultInfo) {
        this.mResultInfo = cJRImpsRefundResultInfo;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }
}
