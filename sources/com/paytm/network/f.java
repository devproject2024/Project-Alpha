package com.paytm.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.google.gsonhtcfix.c.a;
import com.paytm.network.b.e;
import com.paytm.network.b.g;
import com.paytm.network.b.h;
import com.paytm.network.b.i;
import com.paytm.network.b.j;
import com.paytm.network.model.CJRSSLPin;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.io.Reader;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.CertificatePinner;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile RequestQueue f42935a;

    /* renamed from: b  reason: collision with root package name */
    private static RequestQueue f42936b;

    /* renamed from: c  reason: collision with root package name */
    private static String f42937c = f.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private static com.google.gsonhtcfix.f f42938d;

    private f() {
    }

    @Deprecated
    public static void a(Context context) {
        f42936b = Volley.newRequestQueue(context.getApplicationContext());
        h.INSTANCE.initImageCache();
    }

    public static <T> void a(Context context, Request<T> request, Object obj, boolean z) {
        if (obj != null) {
            request.setTag(obj);
        }
        request.setShouldCache(z);
        b(context).add(request);
    }

    public static RequestQueue b(Context context) {
        HurlStack hurlStack;
        if (f42935a == null) {
            synchronized (f.class) {
                if (f42935a == null) {
                    File file = new File(context.getCacheDir().getPath() + File.separator + "paytm-volley-cache");
                    DiskBasedCache diskBasedCache = new DiskBasedCache(file, (int) e.a(file));
                    if (i.e()) {
                        hurlStack = c(context);
                    } else {
                        hurlStack = b();
                    }
                    BasicNetwork basicNetwork = new BasicNetwork((BaseHttpStack) hurlStack);
                    int i2 = 4;
                    if (i.d()) {
                        i2 = (Runtime.getRuntime().availableProcessors() * 2) + 1;
                    } else if (i.c() >= 4) {
                        i2 = i.c();
                    }
                    q.d(" getRequestQueue " + hurlStack.getClass().getSimpleName() + " num of threads " + i2 + " enableOldThreadPool " + i.d());
                    k kVar = new k(diskBasedCache, basicNetwork, i2);
                    f42935a = kVar;
                    kVar.start();
                    ((k) f42935a).f42958a = true;
                }
            }
        }
        return f42935a;
    }

    @Deprecated
    public static RequestQueue a() {
        RequestQueue requestQueue = f42936b;
        if (requestQueue != null) {
            return requestQueue;
        }
        throw new IllegalStateException("Image RequestQueue not initialized");
    }

    public static IJRPaytmDataModel a(String str, Context context, IJRPaytmDataModel iJRPaytmDataModel) {
        IJRPaytmDataModel iJRPaytmDataModel2;
        try {
            Cache.Entry entry = b(context).getCache().get(a(str));
            if (entry != null) {
                if (f42938d == null) {
                    f42938d = new com.google.gsonhtcfix.f();
                }
                String str2 = entry.responseHeaders.get("Content-Encoding");
                if (entry.data != null) {
                    if (str2 == null || !str2.equals("gzip")) {
                        return (IJRPaytmDataModel) f42938d.a(new String(entry.data, AppConstants.UTF_8), iJRPaytmDataModel.getClass());
                    }
                    Reader a2 = g.a(entry.data);
                    iJRPaytmDataModel2 = (IJRPaytmDataModel) f42938d.a(a2, iJRPaytmDataModel.getClass());
                    try {
                        a2.close();
                        return iJRPaytmDataModel2;
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            iJRPaytmDataModel2 = null;
            q.b(e.getMessage());
            return iJRPaytmDataModel2;
        }
    }

    public static String a(String str, Context context) {
        try {
            Cache.Entry entry = b(context).getCache().get(a(str));
            if (entry == null) {
                return null;
            }
            String str2 = entry.responseHeaders.get("Content-Encoding");
            if (entry.data == null) {
                return null;
            }
            if (str2 == null || !str2.equals("gzip")) {
                return new String(entry.data, AppConstants.UTF_8);
            }
            Reader a2 = g.a(entry.data);
            String a3 = g.a(a2);
            a2.close();
            return a3;
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    private static String a(String str) {
        try {
            return Uri.parse(str).buildUpon().clearQuery().build().toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private static HurlStack b() {
        HurlStack hurlStack = null;
        try {
            hurlStack = new HurlStack((HurlStack.UrlRewriter) null, new j());
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return hurlStack == null ? new HurlStack() : hurlStack;
    }

    private static HurlStack c(Context context) {
        l lVar = null;
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            lVar = new l((X509TrustManager) trustManagers[0], d(context));
            return lVar == null ? new HurlStack() : lVar;
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private static CertificatePinner d(Context context) {
        if (context == null) {
            return null;
        }
        String a2 = i.a();
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        try {
            List<CJRSSLPin> list = (List) new com.google.gsonhtcfix.f().a(a2, new a<List<CJRSSLPin>>() {
            }.getType());
            if (list == null || list.size() <= 0) {
                return null;
            }
            CertificatePinner.Builder builder = new CertificatePinner.Builder();
            for (CJRSSLPin cJRSSLPin : list) {
                try {
                    if (cJRSSLPin.isValid()) {
                        builder.add(cJRSSLPin.getDomain(), cJRSSLPin.getValue());
                        q.d("Domain name " + cJRSSLPin.getDomain() + " value " + cJRSSLPin.getValue());
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            }
            return builder.build();
        } catch (Exception e3) {
            q.b(e3.getMessage());
            return null;
        }
    }
}
