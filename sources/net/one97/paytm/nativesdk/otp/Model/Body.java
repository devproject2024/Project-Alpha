package net.one97.paytm.nativesdk.otp.Model;

import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.common.model.ResultInfo;

public class Body implements BaseDataModel {
    private boolean authenticated;
    private ResultInfo resultInfo;

    public boolean getAuthenticated() {
        return this.authenticated;
    }

    public void setAuthenticated(boolean z) {
        this.authenticated = z;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo2) {
        this.resultInfo = resultInfo2;
    }

    public String toString() {
        return "ClassPojo [authenticated = " + this.authenticated + ", resultInfo = " + this.resultInfo + "]";
    }
}
