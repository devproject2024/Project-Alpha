package com.alipay.mobile.nebula.appcenter.downloadImpl;

import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest;
import java.util.List;

public class H5AppDownLoader implements Runnable {
    public static final String TAG = "H5AppLoader";
    private static final int TIMEOUT = 60000;
    private List<H5DownloadCallback> callbackList;
    private H5DownloadRequest downloadRequest;
    private String downloadUrl;

    public H5AppDownLoader(H5DownloadRequest h5DownloadRequest, List<H5DownloadCallback> list) {
        this.downloadRequest = h5DownloadRequest;
        this.callbackList = list;
        if (this.downloadRequest != null) {
            this.downloadUrl = h5DownloadRequest.getDownloadUrl();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009f A[Catch:{ all -> 0x026a }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bd A[Catch:{ all -> 0x026a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r15 = this;
            java.lang.String r0 = "download file not completed, "
            java.lang.String r1 = "H5_CONTAINER_OFFLINE_DOWNLOAD"
            java.lang.String r2 = "ContainerOfflineDownloadFail"
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r3 = r15.downloadRequest
            if (r3 != 0) goto L_0x0010
            java.lang.String r0 = "downloadRequest == null"
            r15.downLoadFail(r0)
            return
        L_0x0010:
            java.lang.String r3 = r3.getDownloadUrl()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r4 = "H5AppLoader"
            if (r3 == 0) goto L_0x0025
            java.lang.String r0 = "downloadRequest.getDownloadUrl() == null"
            r15.downLoadFail(r0)
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)
            return
        L_0x0025:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "download app "
            r3.<init>(r5)
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r6 = r15.downloadRequest
            java.lang.String r6 = r6.getDownloadUrl()
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r4, r3)
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r3 = r15.downloadRequest     // Catch:{ all -> 0x026a }
            java.lang.String r3 = r3.getFileName()     // Catch:{ all -> 0x026a }
            java.lang.String r6 = "/"
            if (r3 == 0) goto L_0x005c
            java.lang.String r7 = ""
            java.lang.String r8 = r3.trim()     // Catch:{ all -> 0x026a }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x026a }
            if (r7 == 0) goto L_0x0053
            goto L_0x005c
        L_0x0053:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x026a }
            java.lang.String r3 = r6.concat(r3)     // Catch:{ all -> 0x026a }
            goto L_0x0070
        L_0x005c:
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r3 = r15.downloadRequest     // Catch:{ all -> 0x026a }
            java.lang.String r3 = r3.getDownloadUrl()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r7 = r15.downloadRequest     // Catch:{ all -> 0x026a }
            java.lang.String r7 = r7.getDownloadUrl()     // Catch:{ all -> 0x026a }
            int r6 = r7.lastIndexOf(r6)     // Catch:{ all -> 0x026a }
            java.lang.String r3 = r3.substring(r6)     // Catch:{ all -> 0x026a }
        L_0x0070:
            android.content.Context r6 = com.alipay.mobile.nebula.util.H5Utils.getContext()     // Catch:{ all -> 0x026a }
            java.lang.String r6 = com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest.getDefaultDownloadDir(r6)     // Catch:{ all -> 0x026a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x026a }
            r7.<init>()     // Catch:{ all -> 0x026a }
            r7.append(r6)     // Catch:{ all -> 0x026a }
            r7.append(r3)     // Catch:{ all -> 0x026a }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x026a }
            java.lang.String r7 = "path:"
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x026a }
            java.lang.String r7 = r7.concat(r8)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r7)     // Catch:{ all -> 0x026a }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x026a }
            r7.<init>(r6)     // Catch:{ all -> 0x026a }
            boolean r7 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.io.File) r7)     // Catch:{ all -> 0x026a }
            if (r7 == 0) goto L_0x00bd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x026a }
            r0.<init>(r5)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r1 = r15.downloadRequest     // Catch:{ all -> 0x026a }
            java.lang.String r1 = r1.getDownloadUrl()     // Catch:{ all -> 0x026a }
            r0.append(r1)     // Catch:{ all -> 0x026a }
            java.lang.String r1 = " canceled because file has already exist"
            r0.append(r1)     // Catch:{ all -> 0x026a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.H5Log.d(r4, r0)     // Catch:{ all -> 0x026a }
            r15.downLoadSuc(r6)     // Catch:{ all -> 0x026a }
            return
        L_0x00bd:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r5 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ all -> 0x026a }
            r5.<init>()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r5 = r5.start()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r9 = r15.downloadRequest     // Catch:{ all -> 0x026a }
            java.lang.String r9 = r9.getAppId()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r5 = r5.appendSubappId(r9)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r9 = r15.downloadRequest     // Catch:{ all -> 0x026a }
            java.lang.String r9 = r9.getVersion()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r5 = r5.appendPackageVersion(r9)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r5 = r5.seedId(r1)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r5)     // Catch:{ all -> 0x026a }
            java.net.URL r5 = new java.net.URL     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r9 = r15.downloadRequest     // Catch:{ all -> 0x026a }
            java.lang.String r9 = r9.getDownloadUrl()     // Catch:{ all -> 0x026a }
            r5.<init>(r9)     // Catch:{ all -> 0x026a }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ all -> 0x026a }
            r9 = 60000(0xea60, float:8.4078E-41)
            r5.setConnectTimeout(r9)     // Catch:{ all -> 0x026a }
            r5.setReadTimeout(r9)     // Catch:{ all -> 0x026a }
            java.io.InputStream r9 = r5.getInputStream()     // Catch:{ all -> 0x026a }
            boolean r10 = com.alipay.mobile.nebula.util.H5FileUtil.create(r6)     // Catch:{ all -> 0x026a }
            if (r10 == 0) goto L_0x021d
            r3 = 0
            int r5 = r5.getContentLength()     // Catch:{ all -> 0x026a }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = com.alipay.mobile.nebula.util.H5IOUtils.getBuf(r10)     // Catch:{ all -> 0x026a }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01b6 }
            r11.<init>(r6)     // Catch:{ Exception -> 0x01b6 }
            r3 = 0
            r12 = 0
        L_0x0119:
            int r13 = r9.read(r10)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            r14 = -1
            if (r13 == r14) goto L_0x0125
            int r12 = r12 + r13
            r11.write(r10, r3, r13)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            goto L_0x0119
        L_0x0125:
            if (r12 != r5) goto L_0x0158
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            r0.<init>()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.success()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.seedId(r1)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r1 = r15.downloadRequest     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            java.lang.String r1 = r1.getAppId()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendSubappId(r1)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r1 = r15.downloadRequest     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            java.lang.String r1 = r1.getVersion()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendPackageVersion(r1)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            long r12 = r12 - r7
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendCostTime(r12)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r0)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            r15.downLoadSuc(r6)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            goto L_0x01a4
        L_0x0158:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            r1.<init>(r0)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            java.lang.String r3 = r15.downloadUrl     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            r1.append(r3)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            r1.<init>(r0)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            java.lang.String r0 = r15.downloadUrl     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            r1.append(r0)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            r15.downLoadFail(r0)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            r0.<init>()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.fail()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r1 = r15.downloadRequest     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            java.lang.String r1 = r1.getAppId()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendSubappId(r1)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r1 = r15.downloadRequest     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            java.lang.String r1 = r1.getVersion()     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendPackageVersion(r1)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.exceptionType(r2)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            java.lang.String r1 = "download file not completed"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendMessage(r1)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r0)     // Catch:{ Exception -> 0x01b0, all -> 0x01ae }
        L_0x01a4:
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r10)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r11)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r9)     // Catch:{ all -> 0x026a }
            return
        L_0x01ae:
            r0 = move-exception
            goto L_0x0213
        L_0x01b0:
            r0 = move-exception
            r3 = r11
            goto L_0x01b7
        L_0x01b3:
            r0 = move-exception
            r11 = r3
            goto L_0x0213
        L_0x01b6:
            r0 = move-exception
        L_0x01b7:
            java.lang.String r1 = "input error"
            java.lang.String r5 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x01b3 }
            java.lang.String r1 = r1.concat(r5)     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.String) r1)     // Catch:{ all -> 0x01b3 }
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x01b3 }
            r15.downLoadFail(r1)     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ all -> 0x01b3 }
            r1.<init>()     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.fail()     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r5 = r15.downloadRequest     // Catch:{ all -> 0x01b3 }
            java.lang.String r5 = r5.getAppId()     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.appendSubappId(r5)     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r5 = r15.downloadRequest     // Catch:{ all -> 0x01b3 }
            java.lang.String r5 = r5.getVersion()     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.appendPackageVersion(r5)     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.exceptionType(r2)     // Catch:{ all -> 0x01b3 }
            java.lang.String r5 = "reading input stream failed"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.appendMessage(r5)     // Catch:{ all -> 0x01b3 }
            java.lang.Class r5 = r0.getClass()     // Catch:{ all -> 0x01b3 }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.appendExceptionName(r5)     // Catch:{ all -> 0x01b3 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r1.appendExceptionMessage(r0)     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r0)     // Catch:{ all -> 0x01b3 }
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r10)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r3)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r9)     // Catch:{ all -> 0x026a }
            return
        L_0x0213:
            com.alipay.mobile.nebula.util.H5IOUtils.returnBuf(r10)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r11)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.H5IOUtils.closeQuietly(r9)     // Catch:{ all -> 0x026a }
            throw r0     // Catch:{ all -> 0x026a }
        L_0x021d:
            boolean r0 = com.alipay.mobile.nebula.util.H5FileUtil.exists((java.lang.String) r6)     // Catch:{ all -> 0x026a }
            if (r0 != 0) goto L_0x0269
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x026a }
            java.lang.String r1 = "create file "
            r0.<init>(r1)     // Catch:{ all -> 0x026a }
            r0.append(r6)     // Catch:{ all -> 0x026a }
            java.lang.String r1 = " failed"
            r0.append(r1)     // Catch:{ all -> 0x026a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x026a }
            r15.downLoadFail(r0)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ all -> 0x026a }
            r0.<init>()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.fail()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r1 = r15.downloadRequest     // Catch:{ all -> 0x026a }
            java.lang.String r1 = r1.getAppId()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendSubappId(r1)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r1 = r15.downloadRequest     // Catch:{ all -> 0x026a }
            java.lang.String r1 = r1.getVersion()     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendPackageVersion(r1)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.exceptionType(r2)     // Catch:{ all -> 0x026a }
            java.lang.String r1 = "create file failed"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendMessage(r1)     // Catch:{ all -> 0x026a }
            java.lang.String r1 = "filePath"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r0.appendExtParams(r1, r3)     // Catch:{ all -> 0x026a }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r0)     // Catch:{ all -> 0x026a }
        L_0x0269:
            return
        L_0x026a:
            r0 = move-exception
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "download app exception."
            java.lang.String r1 = r3.concat(r1)
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r4, (java.lang.String) r1)
            java.lang.String r1 = java.lang.String.valueOf(r0)
            r15.downLoadFail(r1)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel
            r1.<init>()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.fail()
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r3 = r15.downloadRequest
            java.lang.String r3 = r3.getAppId()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.appendSubappId(r3)
            com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest r3 = r15.downloadRequest
            java.lang.String r3 = r3.getVersion()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.appendPackageVersion(r3)
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.exceptionType(r2)
            java.lang.String r2 = "network failed"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.appendMessage(r2)
            java.lang.Class r2 = r0.getClass()
            java.lang.String r2 = r2.getName()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r1 = r1.appendExceptionName(r2)
            java.lang.String r0 = r0.getMessage()
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r0 = r1.appendExceptionMessage(r0)
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.appcenter.downloadImpl.H5AppDownLoader.run():void");
    }

    private void downLoadFail(String str) {
        List<H5DownloadCallback> list = this.callbackList;
        if (list != null) {
            for (H5DownloadCallback onFailed : list) {
                onFailed.onFailed((H5DownloadRequest) null, 0, String.valueOf(str));
            }
            H5DownLoadCallBackList.unRegisterCallbacks(this.downloadUrl);
        }
    }

    private void downLoadSuc(String str) {
        List<H5DownloadCallback> list = this.callbackList;
        if (list != null) {
            for (H5DownloadCallback onFinish : list) {
                onFinish.onFinish((H5DownloadRequest) null, str);
            }
            H5DownLoadCallBackList.unRegisterCallbacks(this.downloadUrl);
        }
    }
}
