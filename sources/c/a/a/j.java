package c.a.a;

import c.a.a.k;
import com.paytm.android.chat.c;
import com.paytm.android.chat.network.interceptors.CacheInterceptor;
import com.paytm.android.chat.network.interceptors.ErrorInterceptor;
import com.paytm.android.chat.network.interceptors.TokenInterceptor;
import java.io.File;
import java.util.ArrayList;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

public final class j {

    /* renamed from: c  reason: collision with root package name */
    private static j f5566c;

    /* renamed from: a  reason: collision with root package name */
    OkHttpClient f5567a;

    /* renamed from: b  reason: collision with root package name */
    k f5568b;

    private j() {
        if (this.f5568b == null) {
            a();
        }
    }

    public final synchronized void a() {
        k.a aVar = new k.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TokenInterceptor());
        arrayList.add(new ErrorInterceptor());
        arrayList.add(new CacheInterceptor());
        aVar.a(arrayList);
        aVar.f5585h = new Cache(new File(c.a().getCacheDir(), "apiResponses"), 5242880);
        a(aVar.a());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(26:1|2|(1:4)|5|(3:9|10|11)|12|13|(1:15)|16|(1:18)|19|(1:21)|22|(1:24)|25|(1:27)|28|(1:30)|31|(1:33)|34|(1:36)|37|(1:39)|40|41) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0067 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(c.a.a.k r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.f5568b = r9     // Catch:{ all -> 0x00de }
            long r0 = r9.f5573e     // Catch:{ all -> 0x00de }
            okhttp3.OkHttpClient$Builder r2 = new okhttp3.OkHttpClient$Builder     // Catch:{ all -> 0x00de }
            r2.<init>()     // Catch:{ all -> 0x00de }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00de }
            okhttp3.OkHttpClient$Builder r2 = r2.connectTimeout(r0, r3)     // Catch:{ all -> 0x00de }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00de }
            okhttp3.OkHttpClient$Builder r2 = r2.writeTimeout(r0, r3)     // Catch:{ all -> 0x00de }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00de }
            okhttp3.OkHttpClient$Builder r0 = r2.readTimeout(r0, r3)     // Catch:{ all -> 0x00de }
            javax.net.ssl.HostnameVerifier r1 = r9.f5572d     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x0025
            javax.net.ssl.HostnameVerifier r1 = r9.f5572d     // Catch:{ all -> 0x00de }
            r0.hostnameVerifier(r1)     // Catch:{ all -> 0x00de }
        L_0x0025:
            java.util.List<java.io.InputStream> r1 = r9.f5571c     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x0067
            int r2 = r1.size()     // Catch:{ all -> 0x00de }
            if (r2 <= 0) goto L_0x0067
            c.a.a.a.a r2 = new c.a.a.a.a     // Catch:{ all -> 0x00de }
            r2.<init>(r0)     // Catch:{ all -> 0x00de }
            r3 = 0
            java.io.InputStream[] r4 = new java.io.InputStream[r3]     // Catch:{ all -> 0x00de }
            java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ all -> 0x00de }
            java.io.InputStream[] r1 = (java.io.InputStream[]) r1     // Catch:{ all -> 0x00de }
            javax.net.ssl.TrustManager[] r1 = c.a.a.a.a.a((java.io.InputStream[]) r1)     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            java.lang.String r4 = "TLS"
            javax.net.ssl.SSLContext r4 = javax.net.ssl.SSLContext.getInstance(r4)     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            r5 = 0
            r6 = 1
            javax.net.ssl.TrustManager[] r6 = new javax.net.ssl.TrustManager[r6]     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            c.a.a.a.a$a r7 = new c.a.a.a.a$a     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            javax.net.ssl.X509TrustManager r1 = c.a.a.a.a.a((javax.net.ssl.TrustManager[]) r1)     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            r7.<init>(r1)     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            r6[r3] = r7     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            java.security.SecureRandom r1 = new java.security.SecureRandom     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            r1.<init>()     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            r4.init(r5, r6, r1)     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            okhttp3.OkHttpClient$Builder r1 = r2.f5548a     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            javax.net.ssl.SSLSocketFactory r2 = r4.getSocketFactory()     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
            r1.sslSocketFactory(r2)     // Catch:{ KeyManagementException | KeyStoreException | NoSuchAlgorithmException -> 0x0067 }
        L_0x0067:
            okhttp3.CookieJar r1 = r9.f5575g     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x006e
            r0.cookieJar(r1)     // Catch:{ all -> 0x00de }
        L_0x006e:
            okhttp3.Cache r1 = r9.f5576h     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x0077
            okhttp3.Cache r1 = r9.f5576h     // Catch:{ all -> 0x00de }
            r0.cache(r1)     // Catch:{ all -> 0x00de }
        L_0x0077:
            okhttp3.Authenticator r1 = r9.f5577i     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x0080
            okhttp3.Authenticator r1 = r9.f5577i     // Catch:{ all -> 0x00de }
            r0.authenticator(r1)     // Catch:{ all -> 0x00de }
        L_0x0080:
            okhttp3.CertificatePinner r1 = r9.j     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x0089
            okhttp3.CertificatePinner r1 = r9.j     // Catch:{ all -> 0x00de }
            r0.certificatePinner(r1)     // Catch:{ all -> 0x00de }
        L_0x0089:
            boolean r1 = r9.l     // Catch:{ all -> 0x00de }
            r0.followRedirects(r1)     // Catch:{ all -> 0x00de }
            boolean r1 = r9.k     // Catch:{ all -> 0x00de }
            r0.followSslRedirects(r1)     // Catch:{ all -> 0x00de }
            javax.net.ssl.SSLSocketFactory r1 = r9.q     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x009c
            javax.net.ssl.SSLSocketFactory r1 = r9.q     // Catch:{ all -> 0x00de }
            r0.sslSocketFactory(r1)     // Catch:{ all -> 0x00de }
        L_0x009c:
            okhttp3.Dispatcher r1 = r9.r     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x00a5
            okhttp3.Dispatcher r1 = r9.r     // Catch:{ all -> 0x00de }
            r0.dispatcher(r1)     // Catch:{ all -> 0x00de }
        L_0x00a5:
            boolean r1 = r9.m     // Catch:{ all -> 0x00de }
            r0.retryOnConnectionFailure(r1)     // Catch:{ all -> 0x00de }
            java.util.List<okhttp3.Interceptor> r1 = r9.o     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x00b7
            java.util.List r1 = r0.networkInterceptors()     // Catch:{ all -> 0x00de }
            java.util.List<okhttp3.Interceptor> r2 = r9.o     // Catch:{ all -> 0x00de }
            r1.addAll(r2)     // Catch:{ all -> 0x00de }
        L_0x00b7:
            java.util.List<okhttp3.Interceptor> r1 = r9.p     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x00c4
            java.util.List r1 = r0.interceptors()     // Catch:{ all -> 0x00de }
            java.util.List<okhttp3.Interceptor> r2 = r9.p     // Catch:{ all -> 0x00de }
            r1.addAll(r2)     // Catch:{ all -> 0x00de }
        L_0x00c4:
            java.net.Proxy r1 = r9.n     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x00cd
            java.net.Proxy r1 = r9.n     // Catch:{ all -> 0x00de }
            r0.proxy(r1)     // Catch:{ all -> 0x00de }
        L_0x00cd:
            java.lang.String r1 = "OkHttpFinal init..."
            com.paytm.utility.q.d(r1)     // Catch:{ all -> 0x00de }
            boolean r9 = r9.f5574f     // Catch:{ all -> 0x00de }
            c.a.a.b.f5552a = r9     // Catch:{ all -> 0x00de }
            okhttp3.OkHttpClient r9 = r0.build()     // Catch:{ all -> 0x00de }
            r8.f5567a = r9     // Catch:{ all -> 0x00de }
            monitor-exit(r8)
            return
        L_0x00de:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.j.a(c.a.a.k):void");
    }

    public static j b() {
        if (f5566c == null) {
            f5566c = new j();
        }
        return f5566c;
    }

    @Deprecated
    public final OkHttpClient c() {
        return this.f5567a;
    }
}
