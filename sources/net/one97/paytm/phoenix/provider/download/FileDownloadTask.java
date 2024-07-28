package net.one97.paytm.phoenix.provider.download;

import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.g.b.k;

public final class FileDownloadTask extends AsyncTask<Void, Void, Boolean> {
    private final String outputFilePath;
    private final OnFileDownloadResultHandler resultHandler;
    private final int timeout;
    private final String urlString;

    public interface OnFileDownloadResultHandler {
        void onDownloadResult(FileDownloadResult fileDownloadResult);
    }

    public FileDownloadTask(String str, String str2, int i2, OnFileDownloadResultHandler onFileDownloadResultHandler) {
        k.c(str2, "outputFilePath");
        k.c(onFileDownloadResultHandler, "resultHandler");
        this.urlString = str;
        this.outputFilePath = str2;
        this.timeout = i2;
        this.resultHandler = onFileDownloadResultHandler;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        if (r3 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r8.resultHandler.onDownloadResult(createFileDownloadResultForCancellation());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        r5 = null;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0068, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a3, code lost:
        if (r2 != null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a5, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00dc, code lost:
        if (r2 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00e3, code lost:
        return java.lang.Boolean.valueOf(r1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d1 A[SYNTHETIC, Splitter:B:70:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d9 A[Catch:{ IOException -> 0x00d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e7 A[SYNTHETIC, Splitter:B:81:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00ef A[Catch:{ IOException -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean doInBackground(java.lang.Void... r9) {
        /*
            r8 = this;
            java.lang.String r0 = "params"
            kotlin.g.b.k.c(r9, r0)
            r9 = 1
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            java.lang.String r3 = r8.urlString     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            if (r2 == 0) goto L_0x00b7
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            int r3 = r8.timeout     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            r2.connect()     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 == r4) goto L_0x003a
            net.one97.paytm.phoenix.provider.download.FileDownloadResult r9 = r8.createDownloadResultForNonOKHTTPResponseCode(r2)     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            net.one97.paytm.phoenix.provider.download.FileDownloadTask$OnFileDownloadResultHandler r3 = r8.resultHandler     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            r3.onDownloadResult(r9)     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            r4 = r0
            r5 = r4
            goto L_0x0096
        L_0x003a:
            java.io.InputStream r3 = r2.getInputStream()     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00af }
            java.lang.String r5 = r8.outputFilePath     // Catch:{ Exception -> 0x00af }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00af }
            java.io.OutputStream r4 = (java.io.OutputStream) r4     // Catch:{ Exception -> 0x00af }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
        L_0x004b:
            boolean r6 = r8.isCancelled()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            if (r6 == 0) goto L_0x006b
            if (r3 != 0) goto L_0x0056
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
        L_0x0056:
            r3.close()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            net.one97.paytm.phoenix.provider.download.FileDownloadResult r3 = r8.createFileDownloadResultForCancellation()     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            net.one97.paytm.phoenix.provider.download.FileDownloadTask$OnFileDownloadResultHandler r5 = r8.resultHandler     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            r5.onDownloadResult(r3)     // Catch:{ Exception -> 0x0068, all -> 0x0065 }
            r5 = r0
            r3 = 1
            goto L_0x007d
        L_0x0065:
            r9 = move-exception
            r3 = r0
            goto L_0x00aa
        L_0x0068:
            r9 = move-exception
            r3 = r0
            goto L_0x00ad
        L_0x006b:
            if (r3 != 0) goto L_0x0070
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
        L_0x0070:
            int r6 = r3.read(r5)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r7 = -1
            if (r6 == r7) goto L_0x007b
            r4.write(r5, r1, r6)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            goto L_0x004b
        L_0x007b:
            r5 = r3
            r3 = 0
        L_0x007d:
            if (r3 != 0) goto L_0x0096
            net.one97.paytm.phoenix.provider.download.FileDownloadResult r1 = new net.one97.paytm.phoenix.provider.download.FileDownloadResult     // Catch:{ Exception -> 0x0090, all -> 0x008b }
            r1.<init>(r9, r0)     // Catch:{ Exception -> 0x0090, all -> 0x008b }
            net.one97.paytm.phoenix.provider.download.FileDownloadTask$OnFileDownloadResultHandler r0 = r8.resultHandler     // Catch:{ Exception -> 0x0090, all -> 0x008b }
            r0.onDownloadResult(r1)     // Catch:{ Exception -> 0x0090, all -> 0x008b }
            r1 = 1
            goto L_0x0096
        L_0x008b:
            r9 = move-exception
            r0 = r4
            r3 = r5
            goto L_0x00e5
        L_0x0090:
            r0 = move-exception
            r9 = r0
            r0 = r4
            r3 = r5
            r1 = 1
            goto L_0x00c6
        L_0x0096:
            if (r4 == 0) goto L_0x009e
            r4.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x009e
        L_0x009c:
            goto L_0x00a3
        L_0x009e:
            if (r5 == 0) goto L_0x00a3
            r5.close()     // Catch:{ IOException -> 0x009c }
        L_0x00a3:
            if (r2 == 0) goto L_0x00df
        L_0x00a5:
            r2.disconnect()
            goto L_0x00df
        L_0x00a9:
            r9 = move-exception
        L_0x00aa:
            r0 = r4
            goto L_0x00e5
        L_0x00ac:
            r9 = move-exception
        L_0x00ad:
            r0 = r4
            goto L_0x00c6
        L_0x00af:
            r9 = move-exception
            goto L_0x00c6
        L_0x00b1:
            r9 = move-exception
            r3 = r0
            goto L_0x00e5
        L_0x00b4:
            r9 = move-exception
            r3 = r0
            goto L_0x00c6
        L_0x00b7:
            kotlin.u r9 = new kotlin.u     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            java.lang.String r2 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r9.<init>(r2)     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
            throw r9     // Catch:{ Exception -> 0x00c3, all -> 0x00bf }
        L_0x00bf:
            r9 = move-exception
            r2 = r0
            r3 = r2
            goto L_0x00e5
        L_0x00c3:
            r9 = move-exception
            r2 = r0
            r3 = r2
        L_0x00c6:
            net.one97.paytm.phoenix.provider.download.FileDownloadResult r9 = r8.createDownloadResultForException(r9)     // Catch:{ all -> 0x00e4 }
            net.one97.paytm.phoenix.provider.download.FileDownloadTask$OnFileDownloadResultHandler r4 = r8.resultHandler     // Catch:{ all -> 0x00e4 }
            r4.onDownloadResult(r9)     // Catch:{ all -> 0x00e4 }
            if (r0 == 0) goto L_0x00d7
            r0.close()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x00d7
        L_0x00d5:
            goto L_0x00dc
        L_0x00d7:
            if (r3 == 0) goto L_0x00dc
            r3.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00dc:
            if (r2 == 0) goto L_0x00df
            goto L_0x00a5
        L_0x00df:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r1)
            return r9
        L_0x00e4:
            r9 = move-exception
        L_0x00e5:
            if (r0 == 0) goto L_0x00ed
            r0.close()     // Catch:{ IOException -> 0x00eb }
            goto L_0x00ed
        L_0x00eb:
            goto L_0x00f2
        L_0x00ed:
            if (r3 == 0) goto L_0x00f2
            r3.close()     // Catch:{ IOException -> 0x00eb }
        L_0x00f2:
            if (r2 == 0) goto L_0x00f7
            r2.disconnect()
        L_0x00f7:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.provider.download.FileDownloadTask.doInBackground(java.lang.Void[]):java.lang.Boolean");
    }

    private final FileDownloadResult createDownloadResultForNonOKHTTPResponseCode(HttpURLConnection httpURLConnection) {
        return new FileDownloadResult(false, new FileDownloadError(1, FileDownloadErrorCodesKt.NOT_OK_HTTP_STATUS_ERR_MSG_PREFIX + httpURLConnection.getResponseCode()));
    }

    private final FileDownloadResult createDownloadResultForException(Exception exc) {
        int i2;
        String exc2 = exc.toString();
        if (exc instanceof UnknownHostException) {
            i2 = 8;
        } else {
            i2 = exc instanceof SocketTimeoutException ? 9 : 2;
        }
        return new FileDownloadResult(false, new FileDownloadError(i2, exc2));
    }

    private final FileDownloadResult createFileDownloadResultForCancellation() {
        return new FileDownloadResult(false, new FileDownloadError(3, FileDownloadErrorCodesKt.CANCELLATION_ERR_MSG));
    }
}
