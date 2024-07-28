package net.one97.paytm.nativesdk.common.model;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;

public class CustomVolleyError extends VolleyError {
    private String errorMsg;
    private String url;

    public CustomVolleyError() {
    }

    public CustomVolleyError(String str) {
        super(str);
    }

    public CustomVolleyError(NetworkResponse networkResponse, String str, String str2) {
        super(networkResponse);
        this.url = str;
        this.errorMsg = str2;
    }

    public CustomVolleyError(NetworkResponse networkResponse, String str) {
        super(networkResponse);
        this.url = str;
        this.errorMsg = this.errorMsg;
    }

    public String getUrl() {
        return this.url;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
