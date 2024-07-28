package com.alipay.iap.android.webapp.sdk.provider;

import com.alipay.iap.android.webapp.sdk.download.OKHttpAppDownloader;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest;
import com.alipay.mobile.nebula.appcenter.download.H5ExternalDownloadManager;
import com.alipay.mobile.nebula.appcenter.downloadImpl.H5DownLoadCallBackList;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.List;

public class OKHttpDownloadManager implements H5ExternalDownloadManager {
    private static final String TAG = "OKHttpDownloadManager";

    public void cancel(String str) {
    }

    public void addDownload(H5DownloadRequest h5DownloadRequest, H5DownloadCallback h5DownloadCallback) {
        H5Log.d(TAG, "addDownload");
        if (h5DownloadRequest == null) {
            return;
        }
        if (h5DownloadRequest.getDownloadUrl() == null || "".equalsIgnoreCase(h5DownloadRequest.getDownloadUrl().trim())) {
            H5Log.d(TAG, "download url is empty");
            if (h5DownloadCallback != null) {
                h5DownloadCallback.onFailed(h5DownloadRequest, 9999, "download failed,the url is empty");
                return;
            }
            return;
        }
        H5DownLoadCallBackList.registerCallback(h5DownloadRequest.getDownloadUrl(), h5DownloadCallback);
        List list = null;
        if (!(h5DownloadRequest.getDownloadUrl() == null || H5DownLoadCallBackList.callbackData == null)) {
            list = H5DownLoadCallBackList.callbackData.get(h5DownloadRequest.getDownloadUrl());
        }
        if (list == null) {
            H5Log.d(TAG, "callbackList==null");
        } else {
            H5Utils.getExecutor(H5ThreadType.RPC).execute(new OKHttpAppDownloader(h5DownloadRequest, list));
        }
    }

    public boolean isDownloading(String str) {
        return H5DownLoadCallBackList.isDownloadTaskExists(str);
    }
}
