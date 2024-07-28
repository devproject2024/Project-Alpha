package com.business.a;

import android.os.Build;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.business.a.a;
import java.io.File;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static HttpLoggingInterceptor f7271a = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static OkHttpClient a(File file, a.c cVar) {
        boolean z;
        HashMap<String, String> hashMap;
        String str;
        c cVar2 = new c();
        if (cVar != null) {
            str = cVar.isDebuggable() ? H5AppProvider.DEBUG : "RELEASE";
            hashMap = cVar.getDomainPins();
            z = cVar.isCache();
            cVar2.f7272a = cVar.getHawkEyeNetworkInterface();
            cVar2.f7273b = cVar.getCommonHeaderInterface();
            cVar2.f7274c = cVar;
        } else {
            str = "";
            hashMap = null;
            z = false;
        }
        OkHttpClient.Builder retryOnConnectionFailure = new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).writeTimeout(120, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS).followRedirects(true).followSslRedirects(true).retryOnConnectionFailure(true);
        if (z && file != null) {
            retryOnConnectionFailure.cache(new Cache(file, 2097152));
        }
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 21) {
            retryOnConnectionFailure = a(retryOnConnectionFailure);
        }
        if (hashMap != null && hashMap.size() > 0 && !str.equalsIgnoreCase(H5AppProvider.DEBUG)) {
            CertificatePinner.Builder builder = new CertificatePinner.Builder();
            for (String next : hashMap.keySet()) {
                builder.add(next, hashMap.get(next));
            }
            retryOnConnectionFailure.certificatePinner(builder.build());
        }
        if (str.equalsIgnoreCase(H5AppProvider.DEBUG)) {
            retryOnConnectionFailure.addInterceptor(f7271a);
        }
        retryOnConnectionFailure.addInterceptor(cVar2);
        return retryOnConnectionFailure.build();
    }

    private static OkHttpClient.Builder a(OkHttpClient.Builder builder) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            builder.sslSocketFactory(new d(), (X509TrustManager) trustManagers[0]);
            ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1).build();
            ArrayList arrayList = new ArrayList();
            arrayList.add(build);
            arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
            arrayList.add(ConnectionSpec.CLEARTEXT);
            builder.connectionSpecs(arrayList);
            return builder;
        } catch (Exception unused) {
        }
    }
}
