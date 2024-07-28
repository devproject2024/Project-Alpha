package net.one97.paytm.wallet.newdesign.addmoney.model;

import net.one97.paytm.addmoney.common.paymethodresponse.ExtendInfo;
import net.one97.paytm.addmoney.common.paymethodresponse.ResultInfo;

public class CJRBinResponseBody {
    BinDetail binDetail;
    ExtendInfo extendInfo;
    ResultInfo resultInfo;
    String signature;

    public ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String getSignature() {
        return this.signature;
    }

    public BinDetail getBinDetail() {
        return this.binDetail;
    }
}
