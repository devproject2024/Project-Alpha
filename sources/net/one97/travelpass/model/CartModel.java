package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CartModel extends IJRPaytmDataModel {
    @b(a = "body")
    public CartBody body;
    @b(a = "code")
    private int code;
    @b(a = "extra")
    public CartExtra extra;
    @b(a = "message")
    public String message;

    public static final class CartExtra extends IJRPaytmDataModel {
    }

    public final String getMessage() {
        String str = this.message;
        if (str == null) {
            k.a("message");
        }
        return str;
    }

    public final void setMessage(String str) {
        k.c(str, "<set-?>");
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i2) {
        this.code = i2;
    }

    public final CartBody getBody() {
        CartBody cartBody = this.body;
        if (cartBody == null) {
            k.a("body");
        }
        return cartBody;
    }

    public final void setBody(CartBody cartBody) {
        k.c(cartBody, "<set-?>");
        this.body = cartBody;
    }

    public final CartExtra getExtra() {
        CartExtra cartExtra = this.extra;
        if (cartExtra == null) {
            k.a("extra");
        }
        return cartExtra;
    }

    public final void setExtra(CartExtra cartExtra) {
        k.c(cartExtra, "<set-?>");
        this.extra = cartExtra;
    }

    public static final class CartBody extends IJRPaytmDataModel {
        @b(a = "Status")
        public String Status;
        @b(a = "message")
        public String message;
        @b(a = "resp")
        public Cart resp;

        public final String getStatus() {
            String str = this.Status;
            if (str == null) {
                k.a("Status");
            }
            return str;
        }

        public final void setStatus(String str) {
            k.c(str, "<set-?>");
            this.Status = str;
        }

        public final String getMessage() {
            String str = this.message;
            if (str == null) {
                k.a("message");
            }
            return str;
        }

        public final void setMessage(String str) {
            k.c(str, "<set-?>");
            this.message = str;
        }

        public final Cart getResp() {
            Cart cart = this.resp;
            if (cart == null) {
                k.a("resp");
            }
            return cart;
        }

        public final void setResp(Cart cart) {
            k.c(cart, "<set-?>");
            this.resp = cart;
        }
    }
}
