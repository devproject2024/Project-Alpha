package net.one97.paytm.P2B;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBeneficiaryListV2 extends IJRPaytmDataModel {
    @b(a = "response")
    private BeneficiaryListV2Response response;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public BeneficiaryListV2Response getResponse() {
        return this.response;
    }

    public void setResponse(BeneficiaryListV2Response beneficiaryListV2Response) {
        this.response = beneficiaryListV2Response;
    }
}
