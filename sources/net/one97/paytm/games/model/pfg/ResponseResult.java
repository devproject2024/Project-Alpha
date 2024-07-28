package net.one97.paytm.games.model.pfg;

import kotlin.g.b.g;

public class ResponseResult<T> {
    public static final String CODE = "code";
    public static final Companion Companion = new Companion((g) null);
    public static final String DATA = "data";
    public static final int INVALID_PARAM = 104;
    public static final String MSG = "message";
    public static final int RESP_CUSTOM_FAILED = -998;
    public static final int RESP_FORMAT_FAILED = 100;
    public static final int RESP_FORMAT_LOGIN = 101;
    public static final int RESP_INIT = -1;
    public static final int RESP_SUCCESS = 200;
    public static final int RESP_SUCCESS_CAS = 2001;
    public static final int RESP_SYS_EXCEPTION = 999;
    public static final int RESP_SYS_REPEAT_ERROR = 102;
    public static final int RESP_SYS_REQUEST_ILLEGALITY = 103;
    private int code = -1;
    private T data;
    private String describe;
    private String described;
    private String message;
    private boolean success;
    private int thirdPartCode;
    private String thirdParty = "";
    private String thirdPartyMessage = "";
    private T user;

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

    public final String getThirdParty() {
        return this.thirdParty;
    }

    public final void setThirdParty(String str) {
        this.thirdParty = str;
    }

    public final int getThirdPartCode() {
        return this.thirdPartCode;
    }

    public final void setThirdPartCode(int i2) {
        this.thirdPartCode = i2;
    }

    public final String getThirdPartyMessage() {
        return this.thirdPartyMessage;
    }

    public final void setThirdPartyMessage(String str) {
        this.thirdPartyMessage = str;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final String getDescribe() {
        return this.describe;
    }

    public final void setDescribe(String str) {
        this.describe = str;
    }

    public final String getDescribed() {
        return this.described;
    }

    public final void setDescribed(String str) {
        this.described = str;
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T t) {
        this.data = t;
    }

    public final T getUser() {
        return this.user;
    }

    public final void setUser(T t) {
        this.user = t;
    }

    public final boolean isOK() {
        int i2 = this.code;
        return 200 == i2 || 2001 == i2;
    }
}
