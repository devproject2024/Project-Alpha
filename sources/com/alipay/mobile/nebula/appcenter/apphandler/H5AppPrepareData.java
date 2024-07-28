package com.alipay.mobile.nebula.appcenter.apphandler;

import android.text.TextUtils;
import com.alipay.mobile.nebula.appcenter.appsync.H5NbOfflineType;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.util.H5Log;

public class H5AppPrepareData implements Cloneable {
    public static final String OFF_ASYNC = "0";
    public static final String OFF_SYNCFORCE = "1";
    public static final String OFF_SYNCTRY = "2";
    public static final int PAGE_OPEN = 1;
    public static final int PAGE_UNOPEN = 0;
    public static final String PREPARE_FAIL = "0";
    public static final String PREPARE_SUCCESS = "1";
    public static final String REQ_ASYNC = "0";
    public static final String REQ_SYNCFORCE = "2";
    public static final String REQ_SYNCTRY = "1";
    public static final String TAG = "H5AppPrepareData";
    private String appId;
    private long beginTime;
    private long downloadTime;
    private long endTime;
    private String errorCode;
    private String errorDetail;
    private long getDBVersionTime;
    private long installTime;
    private String nbUrl;
    private String offlineMode;
    private int pageStatus;
    private long requestBeginTime;
    private long requestEndTime;
    private String requestMode;
    private String version;

    public H5AppPrepareData() {
        clear();
    }

    /* access modifiers changed from: protected */
    public H5AppPrepareData clone() throws CloneNotSupportedException {
        return (H5AppPrepareData) super.clone();
    }

    public void clear() {
        H5Log.d(TAG, "clear");
        this.downloadTime = 0;
        this.requestEndTime = 0;
        this.requestBeginTime = 0;
        this.beginTime = 0;
        this.pageStatus = 0;
        this.endTime = 0;
        this.installTime = 0;
        this.nbUrl = "";
        this.errorDetail = "";
        this.version = "";
        this.appId = "";
        this.errorCode = "";
        this.offlineMode = "";
        this.requestMode = "";
        this.getDBVersionTime = 0;
    }

    public long getGetDBVersionTime() {
        return this.getDBVersionTime;
    }

    public void setGetDBVersionTime(long j) {
        this.getDBVersionTime = j;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public long getRequestBeginTime() {
        return this.requestBeginTime;
    }

    public void setRequestBeginTime(long j) {
        this.requestBeginTime = j;
    }

    public long getRequestEndTime() {
        return this.requestEndTime;
    }

    public void setRequestEndTime(long j) {
        this.requestEndTime = j;
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public void setDownloadTime(long j) {
        this.downloadTime = j;
    }

    public long getInstallTime() {
        return this.installTime;
    }

    public void setInstallTime(long j) {
        this.installTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public String getRequestMode() {
        return this.requestMode;
    }

    public void setRequestMode(String str) {
        if (TextUtils.equals(str, "synctry")) {
            this.requestMode = "1";
        } else if (TextUtils.equals(str, "syncforce")) {
            this.requestMode = "2";
        } else {
            this.requestMode = "0";
        }
    }

    public String getOfflineMode() {
        return this.offlineMode;
    }

    public void setOfflineMode(String str, String str2) {
        if (!TextUtils.equals(str, H5NbOfflineType.sync)) {
            this.offlineMode = "0";
        } else if (TextUtils.equals(str2, "try")) {
            this.offlineMode = "2";
        } else {
            this.offlineMode = "1";
        }
    }

    public int getPageStatus() {
        return this.pageStatus;
    }

    public void setPageStatus(int i2) {
        this.pageStatus = i2;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public String getErrorDetail() {
        return this.errorDetail;
    }

    public void setErrorDetail(String str) {
        this.errorDetail = str;
    }

    public String getNbUrl() {
        return this.nbUrl;
    }

    public void setNbUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            this.nbUrl = "";
        } else {
            this.nbUrl = str;
        }
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "H5AppPrepareData{beginTime=" + this.beginTime + ", requestBeginTime=" + this.requestBeginTime + ", requestEndTime=" + this.requestEndTime + ", downloadTime=" + this.downloadTime + ", installTime=" + this.installTime + ", endTime=" + this.endTime + ", requestMode=" + this.requestMode + ", offlineMode=" + this.offlineMode + ", pageStatus=" + this.pageStatus + ", errorCode=" + this.errorCode + ", errorDetail=" + this.errorDetail + ", nbUrl='" + this.nbUrl + '\'' + '}';
    }

    public void uploadPrepareLog() {
        H5LogProvider h5LogProvider = H5AppUtil.getH5LogProvider();
        if (h5LogProvider != null) {
            try {
                H5AppPrepareData clone = clone();
                h5LogProvider.log("H5_APP_PREPARE", "monitor", "getDBVersionTime=" + this.getDBVersionTime, "step=finish^appId=" + clone.getAppId() + "^version=" + clone.getVersion() + "^t=" + getTimeStr(clone) + "^req=" + clone.getRequestMode() + "^off=" + clone.getOfflineMode() + "^page=" + clone.getPageStatus() + "^err=" + clone.getErrorDetail() + "^errc=" + clone.getErrorCode() + "^nbu=" + clone.getNbUrl(), (String) null);
            } catch (Throwable th) {
                H5Log.e(TAG, th);
            }
        }
    }

    private String getTimeStr(H5AppPrepareData h5AppPrepareData) {
        StringBuilder sb = new StringBuilder();
        String str = "_";
        sb.append(h5AppPrepareData.getBeginTime() > 0 ? Long.valueOf(h5AppPrepareData.getBeginTime()) : str);
        sb.append(str);
        sb.append(h5AppPrepareData.getRequestBeginTime() > 0 ? Long.valueOf(h5AppPrepareData.getRequestBeginTime()) : str);
        sb.append(str);
        sb.append(h5AppPrepareData.getRequestEndTime() > 0 ? Long.valueOf(h5AppPrepareData.getRequestEndTime()) : str);
        sb.append(str);
        sb.append(h5AppPrepareData.getDownloadTime() > 0 ? Long.valueOf(h5AppPrepareData.getDownloadTime()) : str);
        sb.append(str);
        sb.append(h5AppPrepareData.getInstallTime() > 0 ? Long.valueOf(h5AppPrepareData.getInstallTime()) : str);
        sb.append(str);
        Object obj = str;
        if (h5AppPrepareData.getEndTime() > 0) {
            obj = Long.valueOf(h5AppPrepareData.getEndTime());
        }
        sb.append(obj);
        return sb.toString();
    }
}
