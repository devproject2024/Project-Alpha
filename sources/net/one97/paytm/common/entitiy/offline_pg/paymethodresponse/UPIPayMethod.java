package net.one97.paytm.common.entitiy.offline_pg.paymethodresponse;

import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.wallet.entity.Response;

public class UPIPayMethod implements IJRDataModel {
    private Response response;
    private String status;

    public Response getResponse() {
        return this.response;
    }

    public void setResponse(Response response2) {
        this.response = response2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        return "ClassPojo [response = " + this.response + ", status = " + this.status + "]";
    }
}
