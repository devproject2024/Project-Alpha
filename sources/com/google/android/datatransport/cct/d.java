package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.datatransport.cct.a.j;
import com.google.android.datatransport.cct.a.k;
import com.google.android.datatransport.cct.a.l;
import com.google.android.datatransport.cct.a.m;
import com.google.android.datatransport.cct.a.o;
import com.google.android.datatransport.cct.a.p;
import com.google.android.datatransport.runtime.backends.f;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.backends.m;
import com.google.android.datatransport.runtime.h;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

final class d implements m {

    /* renamed from: a  reason: collision with root package name */
    final URL f7709a = a(a.f7638a);

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.encoders.a f7710b;

    /* renamed from: c  reason: collision with root package name */
    private final ConnectivityManager f7711c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.d.a f7712d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.d.a f7713e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7714f;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final URL f7715a;

        /* renamed from: b  reason: collision with root package name */
        final j f7716b;

        /* renamed from: c  reason: collision with root package name */
        final String f7717c;

        a(URL url, j jVar, String str) {
            this.f7715a = url;
            this.f7716b = jVar;
            this.f7717c = str;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f7718a;

        /* renamed from: b  reason: collision with root package name */
        final URL f7719b;

        /* renamed from: c  reason: collision with root package name */
        final long f7720c;

        b(int i2, URL url, long j) {
            this.f7718a = i2;
            this.f7719b = url;
            this.f7720c = j;
        }
    }

    d(Context context, com.google.android.datatransport.runtime.d.a aVar, com.google.android.datatransport.runtime.d.a aVar2) {
        com.google.firebase.encoders.b.a a2 = new com.google.firebase.encoders.b.a().a(com.google.android.datatransport.cct.a.b.f7646a);
        a2.f38738a = true;
        this.f7710b = a2.a();
        this.f7711c = (ConnectivityManager) context.getSystemService("connectivity");
        this.f7712d = aVar2;
        this.f7713e = aVar;
        this.f7714f = 40000;
    }

    private static URL a(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Invalid url: ".concat(String.valueOf(str)), e2);
        }
    }

    public final g a(f fVar) {
        l.a aVar;
        HashMap hashMap = new HashMap();
        for (h next : fVar.a()) {
            String a2 = next.a();
            if (!hashMap.containsKey(a2)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(a2, arrayList);
            } else {
                ((List) hashMap.get(a2)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            h hVar = (h) ((List) entry.getValue()).get(0);
            m.a a3 = com.google.android.datatransport.cct.a.m.h().a(p.DEFAULT).a(this.f7713e.a()).b(this.f7712d.a()).a(k.c().a(k.b.ANDROID_FIREBASE).a(com.google.android.datatransport.cct.a.a.a().a(Integer.valueOf(hVar.a("sdk-version"))).a(hVar.c("model")).b(hVar.c("hardware")).c(hVar.c(AppConstants.TAG_DEVICE)).d(hVar.c("product")).e(hVar.c("os-uild")).f(hVar.c("manufacturer")).g(hVar.c("fingerprint")).a()).a());
            try {
                a3.a(Integer.valueOf(Integer.parseInt((String) entry.getKey())));
            } catch (NumberFormatException unused) {
                a3.a((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (h hVar2 : (List) entry.getValue()) {
                com.google.android.datatransport.runtime.g c2 = hVar2.c();
                com.google.android.datatransport.b bVar = c2.f7786a;
                if (bVar.equals(com.google.android.datatransport.b.a("proto"))) {
                    aVar = l.a(c2.f7787b);
                } else if (bVar.equals(com.google.android.datatransport.b.a("json"))) {
                    aVar = l.a(new String(c2.f7787b, Charset.forName(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.UTF_8)));
                } else {
                    com.google.android.datatransport.runtime.a.a.a("CctTransportBackend");
                    String.format("Received event of unsupported encoding %s. Skipping...", new Object[]{bVar});
                }
                aVar.a(hVar2.d()).b(hVar2.e()).c(hVar2.b("tz-offset")).a(o.c().a(o.c.zza(hVar2.a("net-type"))).a(o.b.zza(hVar2.a("mobile-subtype"))).a());
                if (hVar2.b() != null) {
                    aVar.a(hVar2.b());
                }
                arrayList3.add(aVar.a());
            }
            a3.a((List<l>) arrayList3);
            arrayList2.add(a3.a());
        }
        j a4 = j.a(arrayList2);
        String str = null;
        URL url = this.f7709a;
        if (fVar.b() != null) {
            try {
                a a5 = a.a(fVar.b());
                if (a5.f7645g != null) {
                    str = a5.f7645g;
                }
                if (a5.f7644f != null) {
                    url = a(a5.f7644f);
                }
            } catch (IllegalArgumentException unused2) {
                return g.d();
            }
        }
        try {
            b bVar2 = (b) com.google.android.datatransport.runtime.b.b.a(5, new a(url, a4, str), new b(this), c.a());
            if (bVar2.f7718a == 200) {
                return new com.google.android.datatransport.runtime.backends.b(g.a.OK, bVar2.f7720c);
            }
            int i2 = bVar2.f7718a;
            if (i2 >= 500 || i2 == 404) {
                return g.c();
            }
            return g.d();
        } catch (IOException unused3) {
            com.google.android.datatransport.runtime.a.a.a("CctTransportBackend");
            return g.c();
        }
    }

    public final h a(h hVar) {
        int i2;
        int i3;
        NetworkInfo activeNetworkInfo = this.f7711c.getActiveNetworkInfo();
        h.a a2 = hVar.h().a("sdk-version", Build.VERSION.SDK_INT).a("model", Build.MODEL).a("hardware", Build.HARDWARE).a(AppConstants.TAG_DEVICE, Build.DEVICE).a("product", Build.PRODUCT).a("os-uild", Build.ID).a("manufacturer", Build.MANUFACTURER).a("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        h.a a3 = a2.a("tz-offset", (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        if (activeNetworkInfo == null) {
            i2 = o.c.NONE.zza();
        } else {
            i2 = activeNetworkInfo.getType();
        }
        h.a a4 = a3.a("net-type", i2);
        if (activeNetworkInfo == null) {
            i3 = o.b.UNKNOWN_MOBILE_SUBTYPE.zza();
        } else {
            i3 = activeNetworkInfo.getSubtype();
            if (i3 == -1) {
                i3 = o.b.COMBINED.zza();
            } else if (o.b.zza(i3) == null) {
                i3 = 0;
            }
        }
        return a4.a("mobile-subtype", i3).b();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0105 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0122 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0129 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.datatransport.cct.d.b a(com.google.android.datatransport.cct.d.a r14) throws java.io.IOException {
        /*
            r13 = this;
            java.net.URL r0 = r14.f7715a
            java.lang.String r1 = "CctTransportBackend"
            java.lang.String r2 = "Making request to: %s"
            com.google.android.datatransport.runtime.a.a.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object) r0)
            java.net.URL r0 = r14.f7715a
            java.net.URLConnection r0 = r0.openConnection()
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)
            java.net.URLConnection r0 = (java.net.URLConnection) r0
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            r2 = 30000(0x7530, float:4.2039E-41)
            r0.setConnectTimeout(r2)
            int r2 = r13.f7714f
            r0.setReadTimeout(r2)
            r2 = 1
            r0.setDoOutput(r2)
            r3 = 0
            r0.setInstanceFollowRedirects(r3)
            java.lang.String r4 = "POST"
            r0.setRequestMethod(r4)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = "2.2.3"
            r2[r3] = r4
            java.lang.String r3 = "datatransport/%s android/"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            java.lang.String r3 = "User-Agent"
            r0.setRequestProperty(r3, r2)
            java.lang.String r2 = "gzip"
            java.lang.String r3 = "Content-Encoding"
            r0.setRequestProperty(r3, r2)
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/json"
            r0.setRequestProperty(r4, r5)
            java.lang.String r5 = "Accept-Encoding"
            r0.setRequestProperty(r5, r2)
            java.lang.String r5 = r14.f7717c
            if (r5 == 0) goto L_0x005b
            java.lang.String r6 = "X-Goog-Api-Key"
            r0.setRequestProperty(r6, r5)
        L_0x005b:
            r5 = 0
            r7 = 0
            java.io.OutputStream r8 = r0.getOutputStream()     // Catch:{ c | IOException -> 0x012a }
            java.util.zip.GZIPOutputStream r9 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0123 }
            r9.<init>(r8)     // Catch:{ all -> 0x0123 }
            com.google.firebase.encoders.a r10 = r13.f7710b     // Catch:{ all -> 0x011e }
            com.google.android.datatransport.cct.a.j r14 = r14.f7716b     // Catch:{ all -> 0x011e }
            java.io.BufferedWriter r11 = new java.io.BufferedWriter     // Catch:{ all -> 0x011e }
            java.io.OutputStreamWriter r12 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x011e }
            r12.<init>(r9)     // Catch:{ all -> 0x011e }
            r11.<init>(r12)     // Catch:{ all -> 0x011e }
            r10.a(r14, r11)     // Catch:{ all -> 0x011e }
            r9.close()     // Catch:{ all -> 0x0123 }
            if (r8 == 0) goto L_0x0080
            r8.close()     // Catch:{ c | IOException -> 0x012a }
        L_0x0080:
            int r14 = r0.getResponseCode()
            java.lang.String r8 = java.lang.String.valueOf(r14)
            java.lang.String r9 = "Status Code: "
            r9.concat(r8)
            com.google.android.datatransport.runtime.a.a.a(r1)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Content-Type: "
            r8.<init>(r9)
            java.lang.String r4 = r0.getHeaderField(r4)
            r8.append(r4)
            com.google.android.datatransport.runtime.a.a.a(r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r8 = "Content-Encoding: "
            r4.<init>(r8)
            java.lang.String r8 = r0.getHeaderField(r3)
            r4.append(r8)
            com.google.android.datatransport.runtime.a.a.a(r1)
            r1 = 302(0x12e, float:4.23E-43)
            if (r14 == r1) goto L_0x010d
            r1 = 301(0x12d, float:4.22E-43)
            if (r14 == r1) goto L_0x010d
            r1 = 307(0x133, float:4.3E-43)
            if (r14 == r1) goto L_0x010d
            r1 = 200(0xc8, float:2.8E-43)
            if (r14 == r1) goto L_0x00c8
            com.google.android.datatransport.cct.d$b r0 = new com.google.android.datatransport.cct.d$b
            r0.<init>(r14, r7, r5)
            return r0
        L_0x00c8:
            java.io.InputStream r1 = r0.getInputStream()
            java.lang.String r0 = r0.getHeaderField(r3)     // Catch:{ all -> 0x0106 }
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x0106 }
            if (r0 == 0) goto L_0x00dc
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0106 }
            r0.<init>(r1)     // Catch:{ all -> 0x0106 }
            goto L_0x00dd
        L_0x00dc:
            r0 = r1
        L_0x00dd:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x00ff }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x00ff }
            r3.<init>(r0)     // Catch:{ all -> 0x00ff }
            r2.<init>(r3)     // Catch:{ all -> 0x00ff }
            com.google.android.datatransport.cct.a.n r2 = com.google.android.datatransport.cct.a.n.a(r2)     // Catch:{ all -> 0x00ff }
            long r2 = r2.a()     // Catch:{ all -> 0x00ff }
            com.google.android.datatransport.cct.d$b r4 = new com.google.android.datatransport.cct.d$b     // Catch:{ all -> 0x00ff }
            r4.<init>(r14, r7, r2)     // Catch:{ all -> 0x00ff }
            if (r0 == 0) goto L_0x00f9
            r0.close()     // Catch:{ all -> 0x0106 }
        L_0x00f9:
            if (r1 == 0) goto L_0x00fe
            r1.close()
        L_0x00fe:
            return r4
        L_0x00ff:
            r14 = move-exception
            if (r0 == 0) goto L_0x0105
            r0.close()     // Catch:{ all -> 0x0105 }
        L_0x0105:
            throw r14     // Catch:{ all -> 0x0106 }
        L_0x0106:
            r14 = move-exception
            if (r1 == 0) goto L_0x010c
            r1.close()     // Catch:{ all -> 0x010c }
        L_0x010c:
            throw r14
        L_0x010d:
            java.lang.String r1 = "Location"
            java.lang.String r0 = r0.getHeaderField(r1)
            com.google.android.datatransport.cct.d$b r1 = new com.google.android.datatransport.cct.d$b
            java.net.URL r2 = new java.net.URL
            r2.<init>(r0)
            r1.<init>(r14, r2, r5)
            return r1
        L_0x011e:
            r14 = move-exception
            r9.close()     // Catch:{ all -> 0x0122 }
        L_0x0122:
            throw r14     // Catch:{ all -> 0x0123 }
        L_0x0123:
            r14 = move-exception
            if (r8 == 0) goto L_0x0129
            r8.close()     // Catch:{ all -> 0x0129 }
        L_0x0129:
            throw r14     // Catch:{ c | IOException -> 0x012a }
        L_0x012a:
            com.google.android.datatransport.runtime.a.a.a(r1)
            com.google.android.datatransport.cct.d$b r14 = new com.google.android.datatransport.cct.d$b
            r0 = 400(0x190, float:5.6E-43)
            r14.<init>(r0, r7, r5)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.d.a(com.google.android.datatransport.cct.d$a):com.google.android.datatransport.cct.d$b");
    }
}
