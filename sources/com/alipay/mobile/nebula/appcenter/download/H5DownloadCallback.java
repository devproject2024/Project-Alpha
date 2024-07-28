package com.alipay.mobile.nebula.appcenter.download;

public interface H5DownloadCallback {
    void onCancel(H5DownloadRequest h5DownloadRequest);

    void onFailed(H5DownloadRequest h5DownloadRequest, int i2, String str);

    void onFinish(H5DownloadRequest h5DownloadRequest, String str);

    void onPrepare(H5DownloadRequest h5DownloadRequest);

    void onProgress(H5DownloadRequest h5DownloadRequest, int i2);
}
