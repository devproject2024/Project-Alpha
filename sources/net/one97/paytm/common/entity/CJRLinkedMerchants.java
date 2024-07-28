package net.one97.paytm.common.entity;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRLinkedMerchants extends IJRPaytmDataModel {
    @b(a = "clients")
    private List<CJRMerchantEntity> mClients;
    @b(a = "error")
    private String mError;
    @b(a = "error_description")
    private String mErrorDescription;

    public List<CJRMerchantEntity> getClients() {
        return this.mClients;
    }

    public void setClients(List<CJRMerchantEntity> list) {
        this.mClients = list;
    }

    public String getError() {
        return this.mError;
    }

    public void setError(String str) {
        this.mError = str;
    }

    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public void setErrorDescription(String str) {
        this.mErrorDescription = str;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        return super.parseResponse(str, fVar);
    }
}
