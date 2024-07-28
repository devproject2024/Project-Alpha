package net.one97.paytm.nativesdk.bank_mandate.dataModel;

import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class BankMandateIFSCBank implements BaseDataModel {
    @c(a = "response")
    private BankMandateIFSCBankResponse mResponse;
    @c(a = "statusCode")
    private String mStatusCode;
    @c(a = "statusMessage")
    private String mStatusMessage;

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public BankMandateIFSCBankResponse getResponse() {
        return this.mResponse;
    }
}
