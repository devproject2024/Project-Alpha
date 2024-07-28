package net.one97.paytm.h5paytmsdk.b;

import android.content.Context;
import com.alipay.iap.android.webapp.sdk.network.toolbox.HttpRequest;
import com.alipay.iap.android.webapp.sdk.plugin.BaseHttpRequestPlugin;
import kotlin.g.b.x;
import okhttp3.OkHttpClient;

public final class q extends BaseHttpRequestPlugin {

    /* renamed from: a  reason: collision with root package name */
    private a f17034a;

    /* renamed from: b  reason: collision with root package name */
    private Context f17035b;

    /* renamed from: c  reason: collision with root package name */
    private OkHttpClient f17036c = new OkHttpClient();

    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0229, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x022a, code lost:
        kotlin.f.a.a(r12, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x022d, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.alipay.iap.android.webapp.sdk.network.toolbox.HttpResponse performRequest(com.alipay.iap.android.webapp.sdk.network.toolbox.HttpRequest r12) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L_0x0234
            com.alipay.mobile.nebula.provider.H5ProviderManager r1 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            if (r1 == 0) goto L_0x0014
            java.lang.Class<net.one97.paytm.h5paytmsdk.c.u> r2 = net.one97.paytm.h5paytmsdk.c.u.class
            java.lang.String r2 = r2.getName()
            java.lang.Object r1 = r1.getProvider(r2)
            goto L_0x0015
        L_0x0014:
            r1 = r0
        L_0x0015:
            net.one97.paytm.h5paytmsdk.c.u r1 = (net.one97.paytm.h5paytmsdk.c.u) r1
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
            java.lang.String r3 = "(this as java.lang.String).toLowerCase()"
            java.lang.String r4 = "httpRequest.method"
            java.lang.String r5 = "httpRequest.headerJsonOb.entries"
            java.lang.String r6 = "httpRequest.headersMap"
            java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
            if (r1 == 0) goto L_0x00ef
            kotlin.g.b.x$e r1 = new kotlin.g.b.x$e
            r1.<init>()
            java.util.concurrent.CountDownLatch r8 = new java.util.concurrent.CountDownLatch
            r9 = 1
            r8.<init>(r9)
            r1.element = r8
            com.alibaba.a.e r8 = r12.headerJsonOb
            java.util.Set r8 = r8.entrySet()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r5 = r8.iterator()
        L_0x0041:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0077
            java.lang.Object r8 = r5.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r9 = r8.getKey()
            boolean r9 = r9 instanceof java.lang.String
            java.lang.Object r10 = r8.getValue()
            boolean r10 = r10 instanceof java.lang.String
            r9 = r9 & r10
            if (r9 == 0) goto L_0x0041
            java.util.Map<java.lang.String, java.lang.String> r9 = r12.headersMap
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r6)
            java.lang.Object r10 = r8.getKey()
            java.lang.Object r8 = r8.getValue()
            if (r8 == 0) goto L_0x0071
            java.lang.String r8 = (java.lang.String) r8
            r9.put(r10, r8)
            goto L_0x0041
        L_0x0071:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r2)
            throw r12
        L_0x0077:
            java.lang.String r2 = r12.url
            java.lang.String r5 = "p0.url"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            java.lang.String r2 = r12.data
            java.lang.String r5 = "p0.data"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            java.util.Map<java.lang.String, java.lang.String> r2 = r12.headersMap
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.String r2 = r12.method
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            if (r2 == 0) goto L_0x00e9
            java.lang.String r2 = r2.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.h5paytmsdk.b.q$a r2 = new net.one97.paytm.h5paytmsdk.b.q$a
            r2.<init>(r1, r11, r12)
            T r12 = r1.element     // Catch:{ InterruptedException -> 0x00de }
            java.util.concurrent.CountDownLatch r12 = (java.util.concurrent.CountDownLatch) r12     // Catch:{ InterruptedException -> 0x00de }
            r12.await()     // Catch:{ InterruptedException -> 0x00de }
            net.one97.paytm.h5paytmsdk.b.a r12 = r11.f17034a
            if (r12 == 0) goto L_0x00dd
            int r12 = r12.f16966a
            net.one97.paytm.h5paytmsdk.b.a r1 = r11.f17034a
            if (r1 == 0) goto L_0x00b1
            java.lang.String r1 = r1.f16967b
            goto L_0x00b2
        L_0x00b1:
            r1 = r0
        L_0x00b2:
            net.one97.paytm.h5paytmsdk.b.a r2 = r11.f17034a
            if (r2 == 0) goto L_0x00ce
            java.lang.String r2 = r2.f16968c
            if (r2 == 0) goto L_0x00ce
            java.nio.charset.Charset r3 = kotlin.m.d.f47971a
            if (r2 == 0) goto L_0x00c8
            byte[] r2 = r2.getBytes(r3)
            java.lang.String r3 = "(this as java.lang.String).getBytes(charset)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            goto L_0x00cf
        L_0x00c8:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r7)
            throw r12
        L_0x00ce:
            r2 = r0
        L_0x00cf:
            net.one97.paytm.h5paytmsdk.b.a r3 = r11.f17034a
            if (r3 == 0) goto L_0x00d5
            java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> r0 = r3.f16969d
        L_0x00d5:
            java.util.Map r0 = (java.util.Map) r0
            com.alipay.iap.android.webapp.sdk.network.toolbox.HttpResponse r3 = new com.alipay.iap.android.webapp.sdk.network.toolbox.HttpResponse
            r3.<init>(r12, r1, r2, r0)
            return r3
        L_0x00dd:
            return r0
        L_0x00de:
            r12 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            r0.<init>(r12)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x00e9:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r7)
            throw r12
        L_0x00ef:
            int r1 = r12.timeoutMs
            if (r1 <= 0) goto L_0x0115
            okhttp3.OkHttpClient$Builder r1 = new okhttp3.OkHttpClient$Builder
            r1.<init>()
            int r8 = r12.timeoutMs
            long r8 = (long) r8
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS
            okhttp3.OkHttpClient$Builder r1 = r1.readTimeout(r8, r10)
            int r8 = r12.timeoutMs
            long r8 = (long) r8
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS
            okhttp3.OkHttpClient$Builder r1 = r1.connectTimeout(r8, r10)
            okhttp3.OkHttpClient r1 = r1.build()
            java.lang.String r8 = "OkHttpClient.Builder()\n …                 .build()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            r11.f17036c = r1
        L_0x0115:
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder
            r1.<init>()
            java.lang.String r8 = r12.url
            okhttp3.Request$Builder r1 = r1.url((java.lang.String) r8)
            java.lang.String r8 = r12.method
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r4)
            if (r8 == 0) goto L_0x022e
            java.lang.String r4 = r8.toLowerCase()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            int r3 = r4.hashCode()
            switch(r3) {
                case -1335458389: goto L_0x0184;
                case 102230: goto L_0x0178;
                case 111375: goto L_0x0166;
                case 3198432: goto L_0x015a;
                case 3446944: goto L_0x0148;
                case 106438728: goto L_0x0136;
                default: goto L_0x0135;
            }
        L_0x0135:
            goto L_0x0195
        L_0x0136:
            java.lang.String r3 = "patch"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0195
            java.lang.String r3 = r12.data
            okhttp3.RequestBody r3 = okhttp3.RequestBody.create((okhttp3.MediaType) r0, (java.lang.String) r3)
            r1.patch(r3)
            goto L_0x0195
        L_0x0148:
            java.lang.String r3 = "post"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0195
            java.lang.String r3 = r12.data
            okhttp3.RequestBody r3 = okhttp3.RequestBody.create((okhttp3.MediaType) r0, (java.lang.String) r3)
            r1.post(r3)
            goto L_0x0195
        L_0x015a:
            java.lang.String r3 = "head"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0195
            r1.head()
            goto L_0x0195
        L_0x0166:
            java.lang.String r3 = "put"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0195
            java.lang.String r3 = r12.data
            okhttp3.RequestBody r3 = okhttp3.RequestBody.create((okhttp3.MediaType) r0, (java.lang.String) r3)
            r1.put(r3)
            goto L_0x0195
        L_0x0178:
            java.lang.String r3 = "get"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0195
            r1.get()
            goto L_0x0195
        L_0x0184:
            java.lang.String r3 = "delete"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0195
            java.lang.String r3 = r12.data
            okhttp3.RequestBody r3 = okhttp3.RequestBody.create((okhttp3.MediaType) r0, (java.lang.String) r3)
            r1.delete(r3)
        L_0x0195:
            com.alibaba.a.e r3 = r12.headerJsonOb
            java.util.Set r3 = r3.entrySet()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x01a4:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x01da
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r5 = r5 instanceof java.lang.String
            java.lang.Object r7 = r4.getValue()
            boolean r7 = r7 instanceof java.lang.String
            r5 = r5 & r7
            if (r5 == 0) goto L_0x01a4
            java.util.Map<java.lang.String, java.lang.String> r5 = r12.headersMap
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.Object r7 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            if (r4 == 0) goto L_0x01d4
            java.lang.String r4 = (java.lang.String) r4
            r5.put(r7, r4)
            goto L_0x01a4
        L_0x01d4:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r2)
            throw r12
        L_0x01da:
            java.util.Map<java.lang.String, java.lang.String> r12 = r12.headersMap
            okhttp3.Headers r12 = okhttp3.Headers.of((java.util.Map<java.lang.String, java.lang.String>) r12)
            r1.headers(r12)
            okhttp3.Request r12 = r1.build()
            java.lang.String r1 = java.lang.String.valueOf(r12)
            java.lang.String r2 = "http request "
            r2.concat(r1)
            com.alipay.iap.android.common.b.c.c()
            okhttp3.OkHttpClient r1 = r11.f17036c
            okhttp3.Call r12 = r1.newCall(r12)
            okhttp3.Response r12 = r12.execute()
            java.io.Closeable r12 = (java.io.Closeable) r12
            r1 = r12
            okhttp3.Response r1 = (okhttp3.Response) r1     // Catch:{ all -> 0x0227 }
            com.alipay.iap.android.webapp.sdk.network.toolbox.HttpResponse r2 = new com.alipay.iap.android.webapp.sdk.network.toolbox.HttpResponse     // Catch:{ all -> 0x0227 }
            int r3 = r1.code()     // Catch:{ all -> 0x0227 }
            java.lang.String r4 = r1.message()     // Catch:{ all -> 0x0227 }
            okhttp3.ResponseBody r5 = r1.body()     // Catch:{ all -> 0x0227 }
            if (r5 == 0) goto L_0x0217
            byte[] r5 = r5.bytes()     // Catch:{ all -> 0x0227 }
            goto L_0x0218
        L_0x0217:
            r5 = r0
        L_0x0218:
            okhttp3.Headers r1 = r1.headers()     // Catch:{ all -> 0x0227 }
            java.util.Map r1 = r1.toMultimap()     // Catch:{ all -> 0x0227 }
            r2.<init>(r3, r4, r5, r1)     // Catch:{ all -> 0x0227 }
            kotlin.f.a.a(r12, r0)
            return r2
        L_0x0227:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0229 }
        L_0x0229:
            r1 = move-exception
            kotlin.f.a.a(r12, r0)
            throw r1
        L_0x022e:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r7)
            throw r12
        L_0x0234:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.b.q.performRequest(com.alipay.iap.android.webapp.sdk.network.toolbox.HttpRequest):com.alipay.iap.android.webapp.sdk.network.toolbox.HttpResponse");
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f17037a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f17038b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ HttpRequest f17039c;

        a(x.e eVar, q qVar, HttpRequest httpRequest) {
            this.f17037a = eVar;
            this.f17038b = qVar;
            this.f17039c = httpRequest;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.getActivity();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean interceptEvent(com.alipay.mobile.h5container.api.H5Event r2, com.alipay.mobile.h5container.api.H5BridgeContext r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x000d
            android.app.Activity r0 = r2.getActivity()
            if (r0 == 0) goto L_0x000d
            android.content.Context r0 = r0.getApplicationContext()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            r1.f17035b = r0
            boolean r2 = super.interceptEvent(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.b.q.interceptEvent(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):boolean");
    }
}
