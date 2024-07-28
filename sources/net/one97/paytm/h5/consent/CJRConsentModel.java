package net.one97.paytm.h5.consent;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRConsentModel extends IJRPaytmDataModel {
    @c(a = "code")
    public String code;
    @c(a = "message")
    public String message;
    @c(a = "response")
    public CJRConsentResponse response;
    @c(a = "status")
    public String status;

    public static class CJRConsentResponse extends IJRPaytmDataModel {
        @c(a = "consentData")
        public String consentData;
        @c(a = "consentGiven")
        public boolean consentGiven;
        @c(a = "consentRequired")
        public boolean consentRequired;
    }
}
