package net.one97.paytm.prime.f;

import android.net.Uri;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;

public final class a extends VolleyError {
    private String mAlertMessage;
    private String mAlertTitle;
    private String mErrorCode;
    private String mIternalCode;
    private String mUrl;
    public NetworkResponse networkResponse;
    private int umpErrorCode;
    private String uniqueReference;

    public final String getmIternalCode() {
        return this.mIternalCode;
    }

    public final void setmIternalCode(String str) {
        this.mIternalCode = str;
    }

    public final String getmErrorCode() {
        return this.mErrorCode;
    }

    public final void setmErrorCode(String str) {
        this.mErrorCode = str;
    }

    public final String getAlertMessage() {
        return this.mAlertMessage;
    }

    public final void setAlertMessage(String str) {
        this.mAlertMessage = str;
    }

    public final String getAlertTitle() {
        return this.mAlertTitle;
    }

    public final void setmAlertTitle(String str) {
        this.mAlertTitle = str;
    }

    public final String getUrl() {
        try {
            Uri parse = Uri.parse(this.mUrl);
            return parse.getHost() + parse.getPath();
        } catch (Exception unused) {
            return this.mUrl;
        }
    }

    public final String getFullUrl() {
        return this.mUrl;
    }

    public final void setUrl(String str) {
        this.mUrl = str;
    }

    public a() {
        this.networkResponse = null;
    }

    public a(NetworkResponse networkResponse2) {
        super(networkResponse2);
        this.networkResponse = networkResponse2;
    }

    public a(String str) {
        super(str);
        this.networkResponse = null;
    }

    public a(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public a(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    public a(Throwable th, String str) {
        super(th);
        this.networkResponse = null;
    }

    public a(NetworkResponse networkResponse2, String str) {
        super(str);
        this.networkResponse = networkResponse2;
    }

    public final String getUniqueReference() {
        return this.uniqueReference;
    }

    public final void setUniqueReference(String str) {
        this.uniqueReference = str;
    }

    public final void setUmpErrorCode(int i2) {
        this.umpErrorCode = i2;
    }

    public final int getUmpErrorCode() {
        return this.umpErrorCode;
    }
}
