package com.paytm.network.model;

import android.net.Uri;

public class NetworkCustomError extends Exception {
    private String mAlertMessage;
    private String mAlertTitle;
    public ErrorType mErrorType;
    private String mUrl;
    public NetworkResponse networkResponse;
    private int statusCode;
    private String uniqueReference;

    public enum ErrorType {
        AuthFailureError,
        ServerError,
        TimeOutError,
        NoConnectionError,
        NetworkError,
        ParsingError,
        ApiCallLimitExceededError,
        InvalidArgumentError
    }

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

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i2) {
        this.statusCode = i2;
    }

    public ErrorType getErrorType() {
        return this.mErrorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.mErrorType = errorType;
    }

    public void setNetworkResponse(NetworkResponse networkResponse2) {
        this.networkResponse = networkResponse2;
        if (networkResponse2 != null) {
            this.statusCode = networkResponse2.statusCode;
        }
    }

    public NetworkResponse getNetworkResponse() {
        return this.networkResponse;
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

    public NetworkCustomError() {
        this.mErrorType = ErrorType.NetworkError;
        this.statusCode = -1;
        this.networkResponse = null;
    }

    public NetworkCustomError(NetworkResponse networkResponse2) {
        this.mErrorType = ErrorType.NetworkError;
        this.statusCode = -1;
        this.networkResponse = networkResponse2;
        NetworkResponse networkResponse3 = this.networkResponse;
        if (networkResponse3 != null) {
            this.statusCode = networkResponse3.statusCode;
        }
    }

    public NetworkCustomError(String str, NetworkResponse networkResponse2) {
        super(str);
        this.mErrorType = ErrorType.NetworkError;
        this.statusCode = -1;
        this.networkResponse = networkResponse2;
        NetworkResponse networkResponse3 = this.networkResponse;
        if (networkResponse3 != null) {
            this.statusCode = networkResponse3.statusCode;
        }
    }

    public NetworkCustomError(String str) {
        super(str);
        this.mErrorType = ErrorType.NetworkError;
        this.statusCode = -1;
        this.networkResponse = null;
    }

    public NetworkCustomError(String str, Throwable th) {
        super(str, th);
        this.mErrorType = ErrorType.NetworkError;
        this.statusCode = -1;
        this.networkResponse = null;
    }

    public NetworkCustomError(Throwable th) {
        super(th);
        this.mErrorType = ErrorType.NetworkError;
        this.statusCode = -1;
        this.networkResponse = null;
    }

    public NetworkCustomError(Throwable th, String str) {
        super(th);
        this.mErrorType = ErrorType.NetworkError;
        this.statusCode = -1;
        this.networkResponse = null;
    }

    public NetworkCustomError(NetworkResponse networkResponse2, String str) {
        super(str);
        this.mErrorType = ErrorType.NetworkError;
        this.statusCode = -1;
        this.networkResponse = networkResponse2;
        NetworkResponse networkResponse3 = this.networkResponse;
        if (networkResponse3 != null) {
            this.statusCode = networkResponse3.statusCode;
        }
    }

    public String getUniqueReference() {
        return this.uniqueReference;
    }

    public void setUniqueReference(String str) {
        this.uniqueReference = str;
    }
}
