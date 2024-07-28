package com.paytm.network.model;

import android.net.Uri;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.paytm.network.model.NetworkCustomError;

public class NetworkCustomVolleyError extends VolleyError {
    private String mAlertMessage;
    private String mAlertTitle;
    private NetworkCustomError.ErrorType mParsingError;
    private String mUrl;
    public final NetworkResponse networkResponse;
    private String uniqueReference;

    public String getAlertMessage() {
        return this.mAlertMessage;
    }

    public void setAlertMessage(String str) {
        this.mAlertMessage = str;
    }

    public String getAlertTitle() {
        return this.mAlertTitle;
    }

    public void setmAlertTitle(String str) {
        this.mAlertTitle = str;
    }

    public String getUrl() {
        try {
            Uri parse = Uri.parse(this.mUrl.toString());
            return parse.getHost() + parse.getPath();
        } catch (Exception unused) {
            return this.mUrl;
        }
    }

    public String getFullUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public NetworkCustomVolleyError() {
        this.mParsingError = NetworkCustomError.ErrorType.NetworkError;
        this.networkResponse = null;
    }

    public NetworkCustomVolleyError(NetworkResponse networkResponse2) {
        this.mParsingError = NetworkCustomError.ErrorType.NetworkError;
        this.networkResponse = networkResponse2;
    }

    public NetworkCustomVolleyError(String str) {
        super(str);
        this.mParsingError = NetworkCustomError.ErrorType.NetworkError;
        this.networkResponse = null;
    }

    public NetworkCustomVolleyError(String str, NetworkResponse networkResponse2) {
        super(str);
        this.mParsingError = NetworkCustomError.ErrorType.NetworkError;
        this.networkResponse = networkResponse2;
    }

    public NetworkCustomVolleyError(String str, Throwable th) {
        super(str, th);
        this.mParsingError = NetworkCustomError.ErrorType.NetworkError;
        this.networkResponse = null;
    }

    public NetworkCustomVolleyError(Throwable th) {
        super(th);
        this.mParsingError = NetworkCustomError.ErrorType.NetworkError;
        this.networkResponse = null;
    }

    public NetworkCustomVolleyError(Throwable th, String str) {
        super(th);
        this.mParsingError = NetworkCustomError.ErrorType.NetworkError;
        this.networkResponse = null;
    }

    public NetworkCustomVolleyError(NetworkResponse networkResponse2, String str) {
        super(str);
        this.mParsingError = NetworkCustomError.ErrorType.NetworkError;
        this.networkResponse = networkResponse2;
    }

    public String getUniqueReference() {
        return this.uniqueReference;
    }

    public void setUniqueReference(String str) {
        this.uniqueReference = str;
    }

    public void setErrorType(NetworkCustomError.ErrorType errorType) {
        this.mParsingError = errorType;
    }

    public NetworkCustomError.ErrorType getErrorType() {
        return this.mParsingError;
    }
}
