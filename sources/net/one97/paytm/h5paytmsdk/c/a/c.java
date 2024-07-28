package net.one97.paytm.h5paytmsdk.c.a;

import android.os.AsyncTask;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class c extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final String f17076a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17077b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17078c = FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT;

    /* renamed from: d  reason: collision with root package name */
    private final a f17079d;

    public interface a {
        void a(b bVar);
    }

    public c(String str, String str2, a aVar) {
        k.c(str, "urlString");
        k.c(str2, "outputFilePath");
        k.c(aVar, "resultHandler");
        this.f17076a = str;
        this.f17077b = str2;
        this.f17079d = aVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0063, code lost:
        if (r3 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        kotlin.g.b.k.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0068, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r8.f17079d.a(new net.one97.paytm.h5paytmsdk.c.a.b(false, new net.one97.paytm.h5paytmsdk.c.a.a(3, net.one97.paytm.phoenix.provider.download.FileDownloadErrorCodesKt.CANCELLATION_ERR_MSG)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        r5 = null;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
        r9 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0084, code lost:
        r3 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ec A[Catch:{ all -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ef A[Catch:{ all -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0108 A[SYNTHETIC, Splitter:B:78:0x0108] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0110 A[Catch:{ IOException -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0121 A[SYNTHETIC, Splitter:B:91:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0129 A[Catch:{ IOException -> 0x0125 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean doInBackground(java.lang.Void... r9) {
        /*
            r8 = this;
            java.lang.String r0 = "params"
            kotlin.g.b.k.c(r9, r0)
            r9 = 1
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r3 = r8.f17076a     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            if (r2 == 0) goto L_0x00d4
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            int r3 = r8.f17078c     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r2.connect()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 == r4) goto L_0x004c
            net.one97.paytm.h5paytmsdk.c.a.b r3 = new net.one97.paytm.h5paytmsdk.c.a.b     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            net.one97.paytm.h5paytmsdk.c.a.a r4 = new net.one97.paytm.h5paytmsdk.c.a.a     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            java.lang.String r6 = "The server returned a not OK HTTP Response Code: "
            r5.<init>(r6)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            int r6 = r2.getResponseCode()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r5.append(r6)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r4.<init>(r9, r5)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            net.one97.paytm.h5paytmsdk.c.a.c$a r9 = r8.f17079d     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r9.a(r3)     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            r4 = r0
            r5 = r4
            goto L_0x00b1
        L_0x004c:
            java.io.InputStream r3 = r2.getInputStream()     // Catch:{ Exception -> 0x00d1, all -> 0x00ce }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00cc }
            java.lang.String r5 = r8.f17077b     // Catch:{ Exception -> 0x00cc }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00cc }
            java.io.OutputStream r4 = (java.io.OutputStream) r4     // Catch:{ Exception -> 0x00cc }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x00c9, all -> 0x00c5 }
        L_0x005d:
            boolean r6 = r8.isCancelled()     // Catch:{ Exception -> 0x00c9, all -> 0x00c5 }
            if (r6 == 0) goto L_0x0086
            if (r3 != 0) goto L_0x0068
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00c9, all -> 0x00c5 }
        L_0x0068:
            r3.close()     // Catch:{ Exception -> 0x00c9, all -> 0x00c5 }
            net.one97.paytm.h5paytmsdk.c.a.b r3 = new net.one97.paytm.h5paytmsdk.c.a.b     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            net.one97.paytm.h5paytmsdk.c.a.a r5 = new net.one97.paytm.h5paytmsdk.c.a.a     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r6 = 3
            java.lang.String r7 = "The download operation was cancelled."
            r5.<init>(r6, r7)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r3.<init>(r1, r5)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            net.one97.paytm.h5paytmsdk.c.a.c$a r5 = r8.f17079d     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r5.a(r3)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r5 = r0
            r3 = 1
            goto L_0x0098
        L_0x0080:
            r9 = move-exception
            r3 = r0
            goto L_0x00c6
        L_0x0083:
            r9 = move-exception
            r3 = r0
            goto L_0x00ca
        L_0x0086:
            if (r3 != 0) goto L_0x008b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00c9, all -> 0x00c5 }
        L_0x008b:
            int r6 = r3.read(r5)     // Catch:{ Exception -> 0x00c9, all -> 0x00c5 }
            r7 = -1
            if (r6 == r7) goto L_0x0096
            r4.write(r5, r1, r6)     // Catch:{ Exception -> 0x00c9, all -> 0x00c5 }
            goto L_0x005d
        L_0x0096:
            r5 = r3
            r3 = 0
        L_0x0098:
            if (r3 != 0) goto L_0x00b1
            net.one97.paytm.h5paytmsdk.c.a.b r3 = new net.one97.paytm.h5paytmsdk.c.a.b     // Catch:{ Exception -> 0x00ab, all -> 0x00a6 }
            r3.<init>(r9, r0)     // Catch:{ Exception -> 0x00ab, all -> 0x00a6 }
            net.one97.paytm.h5paytmsdk.c.a.c$a r0 = r8.f17079d     // Catch:{ Exception -> 0x00ab, all -> 0x00a6 }
            r0.a(r3)     // Catch:{ Exception -> 0x00ab, all -> 0x00a6 }
            r1 = 1
            goto L_0x00b1
        L_0x00a6:
            r9 = move-exception
            r0 = r4
            r3 = r5
            goto L_0x011f
        L_0x00ab:
            r0 = move-exception
            r9 = r0
            r0 = r4
            r3 = r5
            r4 = 1
            goto L_0x00e4
        L_0x00b1:
            if (r4 == 0) goto L_0x00b9
            r4.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00b9
        L_0x00b7:
            goto L_0x00be
        L_0x00b9:
            if (r5 == 0) goto L_0x00be
            r5.close()     // Catch:{ IOException -> 0x00b7 }
        L_0x00be:
            if (r2 == 0) goto L_0x0119
            r2.disconnect()
            goto L_0x0119
        L_0x00c5:
            r9 = move-exception
        L_0x00c6:
            r0 = r4
            goto L_0x011f
        L_0x00c9:
            r9 = move-exception
        L_0x00ca:
            r0 = r4
            goto L_0x00e3
        L_0x00cc:
            r9 = move-exception
            goto L_0x00e3
        L_0x00ce:
            r9 = move-exception
            r3 = r0
            goto L_0x011f
        L_0x00d1:
            r9 = move-exception
            r3 = r0
            goto L_0x00e3
        L_0x00d4:
            kotlin.u r9 = new kotlin.u     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r2 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r9.<init>(r2)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            throw r9     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
        L_0x00dc:
            r9 = move-exception
            r2 = r0
            r3 = r2
            goto L_0x011f
        L_0x00e0:
            r9 = move-exception
            r2 = r0
            r3 = r2
        L_0x00e3:
            r4 = 0
        L_0x00e4:
            java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x011e }
            boolean r6 = r9 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x011e }
            if (r6 == 0) goto L_0x00ef
            r9 = 8
            goto L_0x00f7
        L_0x00ef:
            boolean r9 = r9 instanceof java.net.SocketTimeoutException     // Catch:{ all -> 0x011e }
            if (r9 == 0) goto L_0x00f6
            r9 = 9
            goto L_0x00f7
        L_0x00f6:
            r9 = 2
        L_0x00f7:
            net.one97.paytm.h5paytmsdk.c.a.b r6 = new net.one97.paytm.h5paytmsdk.c.a.b     // Catch:{ all -> 0x011e }
            net.one97.paytm.h5paytmsdk.c.a.a r7 = new net.one97.paytm.h5paytmsdk.c.a.a     // Catch:{ all -> 0x011e }
            r7.<init>(r9, r5)     // Catch:{ all -> 0x011e }
            r6.<init>(r1, r7)     // Catch:{ all -> 0x011e }
            net.one97.paytm.h5paytmsdk.c.a.c$a r9 = r8.f17079d     // Catch:{ all -> 0x011e }
            r9.a(r6)     // Catch:{ all -> 0x011e }
            if (r0 == 0) goto L_0x010e
            r0.close()     // Catch:{ IOException -> 0x010c }
            goto L_0x010e
        L_0x010c:
            goto L_0x0113
        L_0x010e:
            if (r3 == 0) goto L_0x0113
            r3.close()     // Catch:{ IOException -> 0x010c }
        L_0x0113:
            if (r2 == 0) goto L_0x0118
            r2.disconnect()
        L_0x0118:
            r1 = r4
        L_0x0119:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r1)
            return r9
        L_0x011e:
            r9 = move-exception
        L_0x011f:
            if (r0 == 0) goto L_0x0127
            r0.close()     // Catch:{ IOException -> 0x0125 }
            goto L_0x0127
        L_0x0125:
            goto L_0x012c
        L_0x0127:
            if (r3 == 0) goto L_0x012c
            r3.close()     // Catch:{ IOException -> 0x0125 }
        L_0x012c:
            if (r2 == 0) goto L_0x0131
            r2.disconnect()
        L_0x0131:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.c.a.c.doInBackground(java.lang.Void[]):java.lang.Boolean");
    }
}
