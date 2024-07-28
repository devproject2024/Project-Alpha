package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRP2BStatusTxnWiseResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "fixedCommission")
    private String mFixedCommission;
    @b(a = "floatCommission")
    private String mFloatCommission;
    @b(a = "maxTxnAmount")
    private String mMaxTxnAmount;
    @b(a = "minTxnAmount")
    private String mMinTxnAmount;
    @b(a = "responseCode")
    private String responseCode;

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getMinTxnAmount() {
        return this.mMinTxnAmount;
    }

    public String getFloatCommission() {
        return this.mFloatCommission;
    }

    public String getFixedCommission() {
        return this.mFixedCommission;
    }

    public String getMaxTxnAmount() {
        return this.mMaxTxnAmount;
    }
}
