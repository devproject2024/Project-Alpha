package com.alipay.iap.android.webapp.sdk.download;

import android.text.TextUtils;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest;
import com.alipay.mobile.nebula.appcenter.downloadImpl.H5DownLoadCallBackList;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5IOUtils;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SecurityUtil;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpAppDownloader implements Runnable {
    public static final String TAG = "OKHttpAppDownloader";
    private static final int TIMEOUT = 60000;
    private List<H5DownloadCallback> callbackList;
    private String downloadPath;
    private H5DownloadRequest downloadRequest;
    private String downloadUrl;
    private String tempDownloadPath;

    public OKHttpAppDownloader(H5DownloadRequest h5DownloadRequest, List<H5DownloadCallback> list) {
        this.downloadRequest = h5DownloadRequest;
        this.callbackList = list;
        if (this.downloadRequest != null) {
            this.downloadUrl = h5DownloadRequest.getDownloadUrl();
            String fileName = this.downloadRequest.getFileName();
            if (fileName != null && !"".equals(fileName.trim())) {
                fileName = "/".concat(String.valueOf(fileName));
            } else if (!TextUtils.isEmpty(this.downloadRequest.getDownloadUrl())) {
                fileName = this.downloadRequest.getDownloadUrl().substring(this.downloadRequest.getDownloadUrl().lastIndexOf("/"));
            }
            String defaultDownloadDir = H5DownloadRequest.getDefaultDownloadDir(H5Utils.getContext());
            this.downloadPath = defaultDownloadDir + fileName;
            this.tempDownloadPath = defaultDownloadDir + (fileName + UUID.randomUUID().toString().replace("-", ""));
        }
    }

    public void run() {
        FileOutputStream fileOutputStream;
        byte[] buf;
        FileOutputStream fileOutputStream2;
        InputStream inputStream;
        H5DownloadRequest h5DownloadRequest = this.downloadRequest;
        if (h5DownloadRequest == null) {
            downLoadFail("downloadRequest == null");
        } else if (TextUtils.isEmpty(h5DownloadRequest.getDownloadUrl())) {
            downLoadFail("downloadRequest.getDownloadUrl() == null");
            H5Log.d(TAG, "downloadRequest.getDownloadUrl() == null");
        } else {
            H5Log.d(TAG, "download app " + this.downloadRequest.getDownloadUrl() + " by okhttp");
            try {
                if (H5FileUtil.exists(new File(this.downloadPath))) {
                    H5Log.d(TAG, "download app " + this.downloadRequest.getDownloadUrl() + " canceled because file has already exist");
                    downLoadSuc(false);
                    return;
                }
                String str = this.tempDownloadPath;
                H5Log.d(TAG, "path:".concat(String.valueOf(str)));
                long currentTimeMillis = System.currentTimeMillis();
                H5Monitor.behavior(new H5MonitorModel().start().appendSubappId(this.downloadRequest.getAppId()).appendPackageVersion(this.downloadRequest.getVersion()).seedId(H5MonitorModel.SEED_ID_OFFLINE_DOWNLOAD));
                if (H5Utils.getContext() == null || !TextUtils.equals(H5Utils.getNetworkType(H5Utils.getContext()), H5Utils.NETWORK_TYPE_NOTREACHABLE)) {
                    Response execute = new OkHttpClient.Builder().writeTimeout(60000, TimeUnit.MILLISECONDS).readTimeout(60000, TimeUnit.MILLISECONDS).connectTimeout(60000, TimeUnit.MILLISECONDS).build().newCall(new Request.Builder().url(this.downloadRequest.getDownloadUrl()).addHeader("Accept-Encoding", "identity").build()).execute();
                    if (execute == null || !execute.isSuccessful() || execute.body() == null) {
                        H5Log.e(TAG, "Okhttp download app result is failed.");
                        downLoadFail("Okhttp download app result is failed.");
                        H5Monitor.exception(new H5MonitorModel().fail().appendSubappId(this.downloadRequest.getAppId()).appendPackageVersion(this.downloadRequest.getVersion()).exceptionType(H5MonitorModel.EXCEPTION_OFFLINE_DOWNLOAD).appendMessage("okhttp download result failed"));
                    } else if (H5FileUtil.create(str)) {
                        long contentLength = execute.body().contentLength();
                        InputStream byteStream = execute.body().byteStream();
                        fileOutputStream = null;
                        buf = H5IOUtils.getBuf(TarConstants.EOF_BLOCK);
                        try {
                            fileOutputStream2 = new FileOutputStream(str);
                            int i2 = 0;
                            while (true) {
                                try {
                                    int read = byteStream.read(buf);
                                    if (read == -1) {
                                        break;
                                    }
                                    i2 += read;
                                    fileOutputStream2.write(buf, 0, read);
                                } catch (Exception e2) {
                                    e = e2;
                                    inputStream = byteStream;
                                    fileOutputStream = fileOutputStream2;
                                    H5Log.e(TAG, "input error".concat(String.valueOf(e)));
                                    downLoadFail(String.valueOf(e));
                                    H5Monitor.exception(new H5MonitorModel().fail().appendSubappId(this.downloadRequest.getAppId()).appendPackageVersion(this.downloadRequest.getVersion()).exceptionType(H5MonitorModel.EXCEPTION_OFFLINE_DOWNLOAD).appendMessage("reading input stream failed").appendExceptionName(e.getClass().getName()).appendExceptionMessage(e.getMessage()));
                                    H5IOUtils.returnBuf(buf);
                                    H5IOUtils.closeQuietly(fileOutputStream);
                                    H5IOUtils.closeQuietly(inputStream);
                                } catch (Throwable th) {
                                    th = th;
                                    inputStream = byteStream;
                                    H5IOUtils.returnBuf(buf);
                                    H5IOUtils.closeQuietly(fileOutputStream2);
                                    H5IOUtils.closeQuietly(inputStream);
                                    throw th;
                                }
                            }
                            H5Log.d(TAG, "read size: ".concat(String.valueOf(i2)));
                            H5Log.d(TAG, "total size: ".concat(String.valueOf(contentLength)));
                            inputStream = byteStream;
                            if (((long) i2) == contentLength || contentLength < 0) {
                                H5Monitor.behavior(new H5MonitorModel().success().seedId(H5MonitorModel.SEED_ID_OFFLINE_DOWNLOAD).appendSubappId(this.downloadRequest.getAppId()).appendPackageVersion(this.downloadRequest.getVersion()).appendMd5(H5SecurityUtil.getFileMd5(str)).appendCostTime(System.currentTimeMillis() - currentTimeMillis));
                                downLoadSuc(true);
                            } else {
                                try {
                                    H5Log.e(TAG, "download file not completed, " + this.downloadUrl);
                                    downLoadFail("download file not completed, " + this.downloadUrl);
                                    H5Monitor.exception(new H5MonitorModel().fail().appendSubappId(this.downloadRequest.getAppId()).appendPackageVersion(this.downloadRequest.getVersion()).exceptionType(H5MonitorModel.EXCEPTION_OFFLINE_DOWNLOAD).appendMessage("download file not completed"));
                                } catch (Exception e3) {
                                    e = e3;
                                    fileOutputStream = fileOutputStream2;
                                    H5Log.e(TAG, "input error".concat(String.valueOf(e)));
                                    downLoadFail(String.valueOf(e));
                                    H5Monitor.exception(new H5MonitorModel().fail().appendSubappId(this.downloadRequest.getAppId()).appendPackageVersion(this.downloadRequest.getVersion()).exceptionType(H5MonitorModel.EXCEPTION_OFFLINE_DOWNLOAD).appendMessage("reading input stream failed").appendExceptionName(e.getClass().getName()).appendExceptionMessage(e.getMessage()));
                                    H5IOUtils.returnBuf(buf);
                                    H5IOUtils.closeQuietly(fileOutputStream);
                                    H5IOUtils.closeQuietly(inputStream);
                                } catch (Throwable th2) {
                                    th = th2;
                                    H5IOUtils.returnBuf(buf);
                                    H5IOUtils.closeQuietly(fileOutputStream2);
                                    H5IOUtils.closeQuietly(inputStream);
                                    throw th;
                                }
                            }
                            H5IOUtils.returnBuf(buf);
                            H5IOUtils.closeQuietly(fileOutputStream2);
                            H5IOUtils.closeQuietly(inputStream);
                        } catch (Exception e4) {
                            e = e4;
                            inputStream = byteStream;
                            H5Log.e(TAG, "input error".concat(String.valueOf(e)));
                            downLoadFail(String.valueOf(e));
                            H5Monitor.exception(new H5MonitorModel().fail().appendSubappId(this.downloadRequest.getAppId()).appendPackageVersion(this.downloadRequest.getVersion()).exceptionType(H5MonitorModel.EXCEPTION_OFFLINE_DOWNLOAD).appendMessage("reading input stream failed").appendExceptionName(e.getClass().getName()).appendExceptionMessage(e.getMessage()));
                            H5IOUtils.returnBuf(buf);
                            H5IOUtils.closeQuietly(fileOutputStream);
                            H5IOUtils.closeQuietly(inputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = byteStream;
                            fileOutputStream2 = fileOutputStream;
                            H5IOUtils.returnBuf(buf);
                            H5IOUtils.closeQuietly(fileOutputStream2);
                            H5IOUtils.closeQuietly(inputStream);
                            throw th;
                        }
                    } else if (!H5FileUtil.exists(str)) {
                        downLoadFail("create file " + str + " failed");
                        H5Monitor.exception(new H5MonitorModel().fail().appendSubappId(this.downloadRequest.getAppId()).appendPackageVersion(this.downloadRequest.getVersion()).exceptionType(H5MonitorModel.EXCEPTION_OFFLINE_DOWNLOAD).appendMessage("create file failed").appendExtParams(ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH, str));
                    }
                } else {
                    H5Log.e(TAG, "download app failed because of no network");
                    downLoadFail("download app failed because of no network");
                    H5Monitor.exception(new H5MonitorModel().fail().appendSubappId(this.downloadRequest.getAppId()).appendPackageVersion(this.downloadRequest.getVersion()).exceptionType(H5MonitorModel.EXCEPTION_OFFLINE_DOWNLOAD).appendMessage("no network connected"));
                }
            } catch (Throwable th4) {
                H5Log.e(TAG, "download app exception.".concat(String.valueOf(th4)));
                downLoadFail(String.valueOf(th4));
                H5Monitor.exception(new H5MonitorModel().fail().appendSubappId(this.downloadRequest.getAppId()).appendPackageVersion(this.downloadRequest.getVersion()).exceptionType(H5MonitorModel.EXCEPTION_OFFLINE_DOWNLOAD).appendMessage("network failed").appendExceptionName(th4.getClass().getName()).appendExceptionMessage(th4.getMessage()));
            }
        }
    }

    private void downLoadFail(String str) {
        try {
            File file = new File(this.tempDownloadPath);
            if (file.exists()) {
                file.delete();
                H5Log.d(TAG, "download fail, fail file deleted");
            }
        } catch (Exception e2) {
            H5Log.e(TAG, "download fail and delete fail file failed", e2);
        }
        List<H5DownloadCallback> list = this.callbackList;
        if (list != null) {
            for (H5DownloadCallback onFailed : list) {
                onFailed.onFailed((H5DownloadRequest) null, 0, String.valueOf(str));
            }
            H5DownLoadCallBackList.unRegisterCallbacks(this.downloadUrl);
        }
    }

    private void downLoadSuc(boolean z) {
        if (!z) {
            callbackSuccess(this.downloadPath);
            return;
        }
        synchronized (OKHttpAppDownloader.class) {
            File file = new File(this.tempDownloadPath);
            try {
                if (file.renameTo(new File(this.downloadPath))) {
                    H5Log.d(TAG, "download success and rename file success");
                    callbackSuccess(this.downloadPath);
                } else {
                    file.delete();
                    H5Log.d(TAG, "download success and rename file failed");
                }
            } catch (Exception e2) {
                if (file.exists()) {
                    file.delete();
                }
                H5Log.e(TAG, "rename file exception", e2);
            }
        }
    }

    private void callbackSuccess(String str) {
        List<H5DownloadCallback> list = this.callbackList;
        if (list != null) {
            for (H5DownloadCallback onFinish : list) {
                onFinish.onFinish((H5DownloadRequest) null, str);
            }
            H5DownLoadCallBackList.unRegisterCallbacks(this.downloadUrl);
        }
    }
}
