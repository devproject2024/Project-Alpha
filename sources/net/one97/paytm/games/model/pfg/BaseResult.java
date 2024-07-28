package net.one97.paytm.games.model.pfg;

import kotlin.g.b.g;

public class BaseResult {
    public static final String CODE = "code";
    public static final Companion Companion = new Companion((g) null);
    public static final String DATA = "data";
    public static final String MSG = "message";
    public static final int RESP_FAILED_CUSTOM = -998;
    public static final int RESP_FAILED_FORMAT = -999;
    public static final int RESP_INIT = -1;
    public static final int RESP_SUCCESS = 200;
    public static final int RESP_SYS_EXCEPTION = 10001;
    public static final int RESP_SYS_REQUEST_ILLEGALITY = 10003;
    public static final int RESP_SYS_UPGRADING = 10002;
    private int code = 200;
    private String message;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i2) {
        this.code = i2;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final boolean isOK() {
        return 200 == this.code;
    }
}
