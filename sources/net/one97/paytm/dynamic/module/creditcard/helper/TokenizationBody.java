package net.one97.paytm.dynamic.module.creditcard.helper;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class TokenizationBody extends IJRPaytmDataModel {
    @a
    @b(a = "cardToken")
    private String cardToken;
    @a
    @b(a = "extendedInfo")
    private String extendedInfo;
    @a
    @b(a = "maskedCardNumber")
    private String maskedCardNumber;
    @a
    @b(a = "message")
    private String message;
    @a
    @b(a = "responseCode")
    private String responseCode;
    @a
    @b(a = "responseMessage")
    private String responseMessage;
    @a
    @b(a = "responseStatus")
    private String responseStatus;

    public String getExtendedInfo() {
        return this.extendedInfo;
    }

    public String getCardToken() {
        return this.cardToken;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResponseStatus() {
        return this.responseStatus;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String getMaskedCardNumber() {
        return this.maskedCardNumber;
    }

    public String getResponseCode() {
        return this.responseCode;
    }
}
