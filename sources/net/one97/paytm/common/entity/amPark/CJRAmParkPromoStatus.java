package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class CJRAmParkPromoStatus implements Serializable {
    private static final long serialVersionUID = 1;
    @b(a = "code")
    private int code;
    @b(a = "message")
    private PromoMessage message;
    @b(a = "result")
    private String result;

    class PromoMessage implements Serializable {
        private static final long serialVersionUID = 1;
        @b(a = "message")
        private String message;
        @b(a = "title")
        private String title;

        private PromoMessage() {
        }
    }

    public String getResult() {
        return this.result;
    }

    public PromoMessage getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }
}
