package net.one97.paytm.passbook.beans.creditcard;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CreditCardInfoResponse extends IJRDataModel {
    @b(a = "code")
    public String code;
    @b(a = "message")
    public String message;
    @b(a = "response")
    public Response response;
    @b(a = "status")
    public String status;

    public static class Response extends IJRDataModel {
        @b(a = "cardName")
        public String cardName;
        @b(a = "cardNo")
        public String cardNo;
        @b(a = "icon")
        public String icon;
        @b(a = "productId")
        public String productId;
    }
}
