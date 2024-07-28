package net.one97.paytm.acceptPayment.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CommonResultInfo extends IJRPaytmDataModel {
    @a
    @b(a = "resultInfo")
    private ResultInfo resultInfo;

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }
}
