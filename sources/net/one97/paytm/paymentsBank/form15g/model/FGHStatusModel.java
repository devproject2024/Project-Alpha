package net.one97.paytm.paymentsBank.form15g.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import net.one97.paytm.common.entity.IJRDataModel;

public class FGHStatusModel extends IJRPaytmDataModel implements Serializable, IJRDataModel {
    @b(a = "response")
    public FGHResponseModel response;
    @b(a = "status")
    public String status;
    @b(a = "success")
    public boolean success;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public FGHResponseModel getResponse() {
        return this.response;
    }

    public void setResponse(FGHResponseModel fGHResponseModel) {
        this.response = fGHResponseModel;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
