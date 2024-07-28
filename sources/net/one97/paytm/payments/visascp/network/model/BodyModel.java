package net.one97.paytm.payments.visascp.network.model;

import com.google.gson.a.c;
import java.util.ArrayList;

public class BodyModel extends BaseModel {
    @c(a = "accountStatusDataList")
    private ArrayList<AccountStatusDataModel> mAccountStatusDataList;
    @c(a = "resultInfo")
    private ResultInfoModel mResultInfo;

    public ResultInfoModel getResultInfo() {
        return this.mResultInfo;
    }

    public ArrayList<AccountStatusDataModel> getAccountStatusDataList() {
        return this.mAccountStatusDataList;
    }
}
