package com.alipay.mobile.nebulacore.android;

import android.webkit.DownloadListener;
import com.alipay.mobile.nebula.webview.APDownloadListener;

class AndroidDownloadListener implements DownloadListener {
    private APDownloadListener mListener;

    AndroidDownloadListener(APDownloadListener aPDownloadListener) {
        this.mListener = aPDownloadListener;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        APDownloadListener aPDownloadListener = this.mListener;
        if (aPDownloadListener != null) {
            aPDownloadListener.onDownloadStart(str, str2, str3, str4, j);
        }
    }
}
