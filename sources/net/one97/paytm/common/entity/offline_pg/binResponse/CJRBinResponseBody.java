package net.one97.paytm.common.entity.offline_pg.binResponse;

import net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo;

public class CJRBinResponseBody {
    BinDetail binDetail;
    ResultInfo resultInfo;
    String signature;

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
