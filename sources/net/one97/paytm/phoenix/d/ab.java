package net.one97.paytm.phoenix.d;

import android.app.Activity;
import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.u;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.provider.PhoenixHttpProvider;
import okhttp3.OkHttpClient;

public final class ab extends a {

    /* renamed from: a  reason: collision with root package name */
    a f59440a;

    /* renamed from: b  reason: collision with root package name */
    private Context f59441b;

    /* renamed from: c  reason: collision with root package name */
    private OkHttpClient f59442c = new OkHttpClient();

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0204, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0205, code lost:
        kotlin.f.a.a(r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0208, code lost:
        throw r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.phoenix.c.a.a r12, boolean r13, net.one97.paytm.phoenix.b.a r14) {
        /*
            r11 = this;
            java.lang.String r0 = "onHttpCallResponse"
            kotlin.g.b.k.c(r14, r0)
            if (r12 == 0) goto L_0x0209
            net.one97.paytm.phoenix.core.c r0 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r0 = r0.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixHttpProvider> r1 = net.one97.paytm.phoenix.provider.PhoenixHttpProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "PhoenixHttpProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.Object r0 = r0.a(r1)
            r1 = r0
            net.one97.paytm.phoenix.provider.PhoenixHttpProvider r1 = (net.one97.paytm.phoenix.provider.PhoenixHttpProvider) r1
            java.lang.String r0 = "key"
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
            java.lang.String r3 = "http request exception: {"
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r5 = "PhoenixDefaultHttpRequestPlugin"
            r6 = 0
            if (r1 == 0) goto L_0x00a6
            org.json.JSONObject r7 = r12.f59388c
            java.util.Iterator r7 = r7.keys()
        L_0x0032:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0073
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            org.json.JSONObject r9 = r12.f59388c     // Catch:{ JSONException -> 0x0059 }
            java.lang.Object r9 = r9.opt(r8)     // Catch:{ JSONException -> 0x0059 }
            if (r9 == 0) goto L_0x0053
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ JSONException -> 0x0059 }
            java.util.Map<java.lang.String, java.lang.String> r10 = r12.f59389d     // Catch:{ JSONException -> 0x0059 }
            if (r10 == 0) goto L_0x0032
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r0)     // Catch:{ JSONException -> 0x0059 }
            r10.put(r8, r9)     // Catch:{ JSONException -> 0x0059 }
            goto L_0x0032
        L_0x0053:
            kotlin.u r8 = new kotlin.u     // Catch:{ JSONException -> 0x0059 }
            r8.<init>(r2)     // Catch:{ JSONException -> 0x0059 }
            throw r8     // Catch:{ JSONException -> 0x0059 }
        L_0x0059:
            r8 = move-exception
            r8.printStackTrace()
            net.one97.paytm.phoenix.util.j r9 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r3)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            net.one97.paytm.phoenix.util.j.b(r5, r8)
            goto L_0x0032
        L_0x0073:
            java.lang.String r2 = r12.f59386a
            java.lang.String r3 = r12.f59391f
            java.util.Map<java.lang.String, java.lang.String> r0 = r12.f59389d
            java.lang.String r5 = r12.f59390e
            if (r5 == 0) goto L_0x0090
            if (r5 == 0) goto L_0x008a
            java.lang.String r4 = r5.toLowerCase()
            java.lang.String r5 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r5 = r4
            goto L_0x0091
        L_0x008a:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r4)
            throw r12
        L_0x0090:
            r5 = r6
        L_0x0091:
            java.lang.Integer r6 = r12.f59387b
            android.content.Context r7 = r11.f59441b
            net.one97.paytm.phoenix.d.ab$b r4 = new net.one97.paytm.phoenix.d.ab$b
            r4.<init>(r11, r12, r14, r13)
            r8 = r4
            net.one97.paytm.phoenix.provider.PhoenixHttpProvider$PhoenixHttpResponseListener r8 = (net.one97.paytm.phoenix.provider.PhoenixHttpProvider.PhoenixHttpResponseListener) r8
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r13)
            r4 = r0
            r1.performRequest(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        L_0x00a6:
            r13 = 1000(0x3e8, float:1.401E-42)
            android.net.TrafficStats.setThreadStatsTag(r13)
            okhttp3.Request$Builder r13 = new okhttp3.Request$Builder
            r13.<init>()
            java.lang.String r1 = r12.f59386a
            java.lang.String r7 = ""
            if (r1 != 0) goto L_0x00b7
            r1 = r7
        L_0x00b7:
            okhttp3.Request$Builder r13 = r13.url((java.lang.String) r1)
            java.lang.String r1 = r12.f59390e
            if (r1 == 0) goto L_0x00da
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r9 = "Locale.getDefault()"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            if (r1 == 0) goto L_0x00d4
            java.lang.String r1 = r1.toLowerCase(r8)
            java.lang.String r4 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            goto L_0x00db
        L_0x00d4:
            kotlin.u r12 = new kotlin.u
            r12.<init>(r4)
            throw r12
        L_0x00da:
            r1 = r6
        L_0x00db:
            if (r1 != 0) goto L_0x00df
            goto L_0x0153
        L_0x00df:
            int r4 = r1.hashCode()
            switch(r4) {
                case -1335458389: goto L_0x013f;
                case 102230: goto L_0x0133;
                case 111375: goto L_0x011e;
                case 3198432: goto L_0x0112;
                case 3446944: goto L_0x00fd;
                case 106438728: goto L_0x00e8;
                default: goto L_0x00e6;
            }
        L_0x00e6:
            goto L_0x0153
        L_0x00e8:
            java.lang.String r4 = "patch"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0153
            java.lang.String r1 = r12.f59391f
            if (r1 != 0) goto L_0x00f5
            r1 = r7
        L_0x00f5:
            okhttp3.RequestBody r1 = okhttp3.RequestBody.create((okhttp3.MediaType) r6, (java.lang.String) r1)
            r13.patch(r1)
            goto L_0x0153
        L_0x00fd:
            java.lang.String r4 = "post"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0153
            java.lang.String r1 = r12.f59391f
            if (r1 != 0) goto L_0x010a
            r1 = r7
        L_0x010a:
            okhttp3.RequestBody r1 = okhttp3.RequestBody.create((okhttp3.MediaType) r6, (java.lang.String) r1)
            r13.post(r1)
            goto L_0x0153
        L_0x0112:
            java.lang.String r4 = "head"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0153
            r13.head()
            goto L_0x0153
        L_0x011e:
            java.lang.String r4 = "put"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0153
            java.lang.String r1 = r12.f59391f
            if (r1 != 0) goto L_0x012b
            r1 = r7
        L_0x012b:
            okhttp3.RequestBody r1 = okhttp3.RequestBody.create((okhttp3.MediaType) r6, (java.lang.String) r1)
            r13.put(r1)
            goto L_0x0153
        L_0x0133:
            java.lang.String r4 = "get"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0153
            r13.get()
            goto L_0x0153
        L_0x013f:
            java.lang.String r4 = "delete"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0153
            java.lang.String r1 = r12.f59391f
            if (r1 != 0) goto L_0x014c
            r1 = r7
        L_0x014c:
            okhttp3.RequestBody r1 = okhttp3.RequestBody.create((okhttp3.MediaType) r6, (java.lang.String) r1)
            r13.delete(r1)
        L_0x0153:
            java.util.Map<java.lang.String, java.lang.String> r1 = r12.f59389d
            if (r1 == 0) goto L_0x015c
            java.util.Map r1 = kotlin.a.ae.b(r1)
            goto L_0x0163
        L_0x015c:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
        L_0x0163:
            org.json.JSONObject r4 = r12.f59388c
            java.util.Iterator r4 = r4.keys()
        L_0x0169:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x01a6
            java.lang.Object r7 = r4.next()
            java.lang.String r7 = (java.lang.String) r7
            org.json.JSONObject r8 = r12.f59388c     // Catch:{ JSONException -> 0x018c }
            java.lang.Object r8 = r8.opt(r7)     // Catch:{ JSONException -> 0x018c }
            if (r8 == 0) goto L_0x0186
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ JSONException -> 0x018c }
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)     // Catch:{ JSONException -> 0x018c }
            r1.put(r7, r8)     // Catch:{ JSONException -> 0x018c }
            goto L_0x0169
        L_0x0186:
            kotlin.u r7 = new kotlin.u     // Catch:{ JSONException -> 0x018c }
            r7.<init>(r2)     // Catch:{ JSONException -> 0x018c }
            throw r7     // Catch:{ JSONException -> 0x018c }
        L_0x018c:
            r7 = move-exception
            r7.printStackTrace()
            net.one97.paytm.phoenix.util.j r8 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            net.one97.paytm.phoenix.util.j.b(r5, r7)
            goto L_0x0169
        L_0x01a6:
            okhttp3.Headers r12 = okhttp3.Headers.of((java.util.Map<java.lang.String, java.lang.String>) r1)
            r13.headers(r12)
            okhttp3.Request r12 = r13.build()
            net.one97.paytm.phoenix.util.j r13 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.String r13 = java.lang.String.valueOf(r12)
            java.lang.String r0 = "http request "
            java.lang.String r13 = r0.concat(r13)
            net.one97.paytm.phoenix.util.j.a(r5, r13)
            okhttp3.OkHttpClient r13 = r11.f59442c
            okhttp3.Call r12 = r13.newCall(r12)
            okhttp3.Response r12 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r12)
            java.io.Closeable r12 = (java.io.Closeable) r12
            r13 = r12
            okhttp3.Response r13 = (okhttp3.Response) r13     // Catch:{ all -> 0x0202 }
            net.one97.paytm.phoenix.c.a.b r0 = new net.one97.paytm.phoenix.c.a.b     // Catch:{ all -> 0x0202 }
            int r1 = r13.code()     // Catch:{ all -> 0x0202 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0202 }
            java.lang.String r2 = r13.message()     // Catch:{ all -> 0x0202 }
            okhttp3.ResponseBody r3 = r13.body()     // Catch:{ all -> 0x0202 }
            if (r3 == 0) goto L_0x01e8
            byte[] r3 = r3.bytes()     // Catch:{ all -> 0x0202 }
            goto L_0x01e9
        L_0x01e8:
            r3 = r6
        L_0x01e9:
            if (r3 != 0) goto L_0x01ee
            kotlin.g.b.k.a()     // Catch:{ all -> 0x0202 }
        L_0x01ee:
            okhttp3.Headers r13 = r13.headers()     // Catch:{ all -> 0x0202 }
            java.util.Map r13 = r13.toMultimap()     // Catch:{ all -> 0x0202 }
            r0.<init>(r1, r2, r3, r13)     // Catch:{ all -> 0x0202 }
            r14.a(r0)     // Catch:{ all -> 0x0202 }
            kotlin.x r13 = kotlin.x.f47997a     // Catch:{ all -> 0x0202 }
            kotlin.f.a.a(r12, r6)
            return
        L_0x0202:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x0204 }
        L_0x0204:
            r14 = move-exception
            kotlin.f.a.a(r12, r13)
            throw r14
        L_0x0209:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ab.a(net.one97.paytm.phoenix.c.a.a, boolean, net.one97.paytm.phoenix.b.a):void");
    }

    public static final class b implements PhoenixHttpProvider.PhoenixHttpResponseListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ab f59447a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.c.a.a f59448b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.phoenix.b.a f59449c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f59450d;

        b(ab abVar, net.one97.paytm.phoenix.c.a.a aVar, net.one97.paytm.phoenix.b.a aVar2, boolean z) {
            this.f59447a = abVar;
            this.f59448b = aVar;
            this.f59449c = aVar2;
            this.f59450d = z;
        }

        public final void onResponse(int i2, String str, String str2, HashMap<String, List<String>> hashMap) {
            String str3;
            byte[] bArr;
            String str4;
            k.c(str, "statusMessage");
            this.f59447a.f59440a = new a(i2, str, str2, hashMap);
            net.one97.paytm.phoenix.b.a aVar = this.f59449c;
            a aVar2 = this.f59447a.f59440a;
            HashMap<String, List<String>> hashMap2 = null;
            Integer valueOf = aVar2 != null ? Integer.valueOf(aVar2.f59443a) : null;
            a aVar3 = this.f59447a.f59440a;
            if (aVar3 != null) {
                str3 = aVar3.f59444b;
            } else {
                str3 = null;
            }
            a aVar4 = this.f59447a.f59440a;
            if (aVar4 == null || (str4 = aVar4.f59445c) == null) {
                bArr = null;
            } else {
                Charset charset = d.f47971a;
                if (str4 != null) {
                    bArr = str4.getBytes(charset);
                    k.a((Object) bArr, "(this as java.lang.String).getBytes(charset)");
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            a aVar5 = this.f59447a.f59440a;
            if (aVar5 != null) {
                hashMap2 = aVar5.f59446d;
            }
            aVar.a(new net.one97.paytm.phoenix.c.a.b(valueOf, str3, bArr, hashMap2));
        }
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        Activity activity = h5Event.getActivity();
        if (activity != null) {
            this.f59441b = activity.getApplicationContext();
        }
        return super.a(h5Event, bVar);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int f59443a;

        /* renamed from: b  reason: collision with root package name */
        final String f59444b;

        /* renamed from: c  reason: collision with root package name */
        String f59445c;

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, List<String>> f59446d;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.f59443a == aVar.f59443a) || !k.a((Object) this.f59444b, (Object) aVar.f59444b) || !k.a((Object) this.f59445c, (Object) aVar.f59445c) || !k.a((Object) this.f59446d, (Object) aVar.f59446d)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int hashCode = Integer.valueOf(this.f59443a).hashCode() * 31;
            String str = this.f59444b;
            int i2 = 0;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f59445c;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            HashMap<String, List<String>> hashMap = this.f59446d;
            if (hashMap != null) {
                i2 = hashMap.hashCode();
            }
            return hashCode3 + i2;
        }

        public final String toString() {
            return "PhoenixHTTPResponse(statusCode=" + this.f59443a + ", statusMessage=" + this.f59444b + ", data=" + this.f59445c + ", map=" + this.f59446d + ")";
        }

        public a(int i2, String str, String str2, HashMap<String, List<String>> hashMap) {
            this.f59443a = i2;
            this.f59444b = str;
            this.f59445c = str2;
            this.f59446d = hashMap;
        }
    }
}
