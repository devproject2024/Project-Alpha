package net.one97.paytm.app;

import android.net.Uri;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;

public class b extends VolleyError {
    private String mAlertMessage;
    private String mAlertTitle;
    private String mErrorCode;
    private String mIternalCode;
    private String mUrl;
    public NetworkResponse networkResponse;
    private int umpErrorCode;
    private String uniqueReference;

    public String getmIternalCode() {
        return this.mIternalCode;
    }

    public void setmIternalCode(String str) {
        this.mIternalCode = str;
    }

    public String getmErrorCode() {
        return this.mErrorCode;
    }

    public void setmErrorCode(String str) {
        this.mErrorCode = str;
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

    public b() {
        this.networkResponse = null;
    }

    public b(NetworkResponse networkResponse2) {
        super(networkResponse2);
        this.networkResponse = networkResponse2;
    }

    public b(String str) {
        super(str);
        this.networkResponse = null;
    }

    public b(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public b(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    public b(Throwable th, String str) {
        super(th);
        this.networkResponse = null;
    }

    public b(NetworkResponse networkResponse2, String str) {
        super(str);
        this.networkResponse = networkResponse2;
    }

    public String getUniqueReference() {
        return this.uniqueReference;
    }

    public void setUniqueReference(String str) {
        this.uniqueReference = str;
    }

    public void setUmpErrorCode(int i2) {
        this.umpErrorCode = i2;
    }

    public int getUmpErrorCode() {
        return this.umpErrorCode;
    }
}
