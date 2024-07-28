package com.google.zxing.client.android;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40248a = j.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Collection<String> f40249b = new HashSet(Arrays.asList(new String[]{"amzn.to", "bit.ly", "bitly.com", "fb.me", "goo.gl", "is.gd", "j.mp", "lnkd.in", "ow.ly", "R.BEETAGG.COM", "r.beetagg.com", "SCN.BY", "su.pr", "t.co", "tinyurl.com", "tr.im"}));

    public enum a {
        HTML,
        JSON,
        XML,
        TEXT
    }

    private j() {
    }

    /* renamed from: com.google.zxing.client.android.j$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f40250a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.google.zxing.client.android.j$a[] r0 = com.google.zxing.client.android.j.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40250a = r0
                int[] r0 = f40250a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.zxing.client.android.j$a r1 = com.google.zxing.client.android.j.a.HTML     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f40250a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.zxing.client.android.j$a r1 = com.google.zxing.client.android.j.a.JSON     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f40250a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.zxing.client.android.j$a r1 = com.google.zxing.client.android.j.a.XML     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f40250a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.zxing.client.android.j$a r1 = com.google.zxing.client.android.j.a.TEXT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.j.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX INFO: finally extract failed */
    private static CharSequence a(String str, String str2) throws IOException {
        int i2 = 0;
        while (i2 < 5) {
            HttpURLConnection a2 = a(new URL(str));
            a2.setInstanceFollowRedirects(true);
            a2.setRequestProperty("Accept", str2);
            a2.setRequestProperty("Accept-Charset", "utf-8,*");
            a2.setRequestProperty("User-Agent", "ZXing (Android)");
            try {
                int a3 = a(a2);
                if (a3 == 200) {
                    CharSequence a4 = a((URLConnection) a2);
                    a2.disconnect();
                    return a4;
                } else if (a3 == 302) {
                    String headerField = a2.getHeaderField("Location");
                    if (headerField != null) {
                        i2++;
                        a2.disconnect();
                        str = headerField;
                    } else {
                        throw new IOException("No Location");
                    }
                } else {
                    throw new IOException("Bad HTTP response: ".concat(String.valueOf(a3)));
                }
            } catch (Throwable th) {
                a2.disconnect();
                throw th;
            }
        }
        throw new IOException("Too many redirects");
    }

    private static HttpURLConnection a(URL url) throws IOException {
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection());
            if (uRLConnection instanceof HttpURLConnection) {
                return (HttpURLConnection) uRLConnection;
            }
            throw new IOException();
        } catch (NullPointerException e2) {
            new StringBuilder("Bad URI? ").append(url);
            throw new IOException(e2);
        }
    }

    private static int a(HttpURLConnection httpURLConnection) throws IOException {
        try {
            httpURLConnection.connect();
            try {
                return httpURLConnection.getResponseCode();
            } catch (IllegalArgumentException | NullPointerException | StringIndexOutOfBoundsException e2) {
                throw new IOException(e2);
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NullPointerException | SecurityException e3) {
            throw new IOException(e3);
        }
    }

    public static CharSequence a(String str, a aVar) throws IOException {
        int i2 = AnonymousClass1.f40250a[aVar.ordinal()];
        return a(str, i2 != 1 ? i2 != 2 ? i2 != 3 ? "text/*,*/*" : "application/xml,text/*,*/*" : "application/json,text/*,*/*" : "application/xhtml+xml,text/html,text/*,*/*");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004a A[SYNTHETIC, Splitter:B:25:0x004a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.CharSequence a(java.net.URLConnection r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "Content-Type"
            java.lang.String r0 = r4.getHeaderField(r0)
            if (r0 == 0) goto L_0x0017
            java.lang.String r1 = "charset="
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x0017
            int r1 = r1 + 8
            java.lang.String r0 = r0.substring(r1)
            goto L_0x0019
        L_0x0017:
            java.lang.String r0 = "UTF-8"
        L_0x0019:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0046 }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x0046 }
            r3.<init>(r4, r0)     // Catch:{ all -> 0x0046 }
            r4 = 1024(0x400, float:1.435E-42)
            char[] r4 = new char[r4]     // Catch:{ all -> 0x0044 }
        L_0x002c:
            int r0 = r1.length()     // Catch:{ all -> 0x0044 }
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r0 >= r2) goto L_0x0040
            int r0 = r3.read(r4)     // Catch:{ all -> 0x0044 }
            if (r0 <= 0) goto L_0x0040
            r2 = 0
            r1.append(r4, r2, r0)     // Catch:{ all -> 0x0044 }
            goto L_0x002c
        L_0x0040:
            r3.close()     // Catch:{ IOException | NullPointerException -> 0x0043 }
        L_0x0043:
            return r1
        L_0x0044:
            r4 = move-exception
            goto L_0x0048
        L_0x0046:
            r4 = move-exception
            r3 = r2
        L_0x0048:
            if (r3 == 0) goto L_0x004d
            r3.close()     // Catch:{ IOException | NullPointerException -> 0x004d }
        L_0x004d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.j.a(java.net.URLConnection):java.lang.CharSequence");
    }
}
