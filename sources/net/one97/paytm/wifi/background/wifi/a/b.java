package net.one97.paytm.wifi.background.wifi.a;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.g.b.k;
import net.one97.paytm.wifi.models.InternetStatus;
import net.one97.paytm.wifi.models.WifiAccessPoint;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21084a = new a((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private static final ExecutorService f21085d = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private final WifiAccessPoint f21086b;

    /* renamed from: c  reason: collision with root package name */
    private final Application f21087c;

    public b(WifiAccessPoint wifiAccessPoint, Application application) {
        k.c(wifiAccessPoint, "accessPoint");
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f21086b = wifiAccessPoint;
        this.f21087c = application;
    }

    public final LiveData<InternetStatus> a() {
        y yVar = new y();
        yVar.postValue(InternetStatus.CHECKING);
        f21085d.submit(new C0411b(this, yVar));
        return yVar;
    }

    /* renamed from: net.one97.paytm.wifi.background.wifi.a.b$b  reason: collision with other inner class name */
    static final class C0411b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f21088a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y f21089b;

        C0411b(b bVar, y yVar) {
            this.f21088a = bVar;
            this.f21089b = yVar;
        }

        public final void run() {
            b.a(this.f21089b);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ec A[SYNTHETIC, Splitter:B:35:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(androidx.lifecycle.y r13) {
        /*
            java.lang.String r0 = "GET"
            java.lang.String r1 = "close"
            java.lang.String r2 = "Connection"
            java.lang.String r3 = "Android"
            java.lang.String r4 = "User-Agent"
            java.lang.String r5 = "Connectivity check error "
            r6 = 0
            java.net.URL r7 = new java.net.URL     // Catch:{ IOException -> 0x0116 }
            java.lang.String r8 = "http://connectivitycheck.gstatic.com/generate_204"
            r7.<init>(r8)     // Catch:{ IOException -> 0x0116 }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ IOException -> 0x0116 }
            java.lang.String r8 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            if (r7 == 0) goto L_0x0110
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x0116 }
            r9 = 30000(0x7530, float:4.2039E-41)
            r7.setConnectTimeout(r9)     // Catch:{ IOException -> 0x0116 }
            r7.setReadTimeout(r9)     // Catch:{ IOException -> 0x0116 }
            r7.setRequestProperty(r4, r3)     // Catch:{ IOException -> 0x0116 }
            r7.setRequestProperty(r2, r1)     // Catch:{ IOException -> 0x0116 }
            r7.setRequestMethod(r0)     // Catch:{ IOException -> 0x0116 }
            r10 = 0
            r7.setInstanceFollowRedirects(r10)     // Catch:{ IOException -> 0x0116 }
            r7.connect()     // Catch:{ IOException -> 0x010e }
            int r10 = r7.getResponseCode()     // Catch:{ IOException -> 0x010e }
            r11 = 204(0xcc, float:2.86E-43)
            if (r10 != r11) goto L_0x004d
            int r10 = r7.getContentLength()     // Catch:{ IOException -> 0x010e }
            if (r10 != 0) goto L_0x004d
            net.one97.paytm.wifi.models.InternetStatus r0 = net.one97.paytm.wifi.models.InternetStatus.INTERNET_ACCESS     // Catch:{ IOException -> 0x010e }
            r13.postValue(r0)     // Catch:{ IOException -> 0x010e }
            r7.disconnect()     // Catch:{ IOException -> 0x010e }
            return
        L_0x004d:
            java.lang.String r10 = "Location"
            java.lang.String r10 = r7.getHeaderField(r10)     // Catch:{ IOException -> 0x010e }
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ IOException -> 0x010e }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ IOException -> 0x010e }
            if (r11 != 0) goto L_0x0100
            java.lang.String r11 = "New redirected URL is-"
            java.lang.String r12 = java.lang.String.valueOf(r10)     // Catch:{ IOException -> 0x010e }
            java.lang.String r11 = r11.concat(r12)     // Catch:{ IOException -> 0x010e }
            com.paytm.utility.q.d(r11)     // Catch:{ IOException -> 0x010e }
            java.lang.String r11 = "redirectedUrl"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)     // Catch:{ IOException -> 0x010e }
            net.one97.paytm.wifi.models.InternetStatus r11 = net.one97.paytm.wifi.models.InternetStatus.CONFIGURING     // Catch:{ IOException -> 0x010e }
            r13.postValue(r11)     // Catch:{ IOException -> 0x010e }
            java.net.URL r11 = new java.net.URL     // Catch:{ IOException -> 0x00e8 }
            r11.<init>(r10)     // Catch:{ IOException -> 0x00e8 }
            java.net.URLConnection r11 = r11.openConnection()     // Catch:{ IOException -> 0x00e8 }
            if (r11 == 0) goto L_0x00e2
            r8 = r11
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ IOException -> 0x00e8 }
            r8.setConnectTimeout(r9)     // Catch:{ IOException -> 0x00e8 }
            r8.setReadTimeout(r9)     // Catch:{ IOException -> 0x00e8 }
            r8.setRequestProperty(r4, r3)     // Catch:{ IOException -> 0x00e8 }
            r8.setRequestProperty(r2, r1)     // Catch:{ IOException -> 0x00e8 }
            r8.setRequestMethod(r0)     // Catch:{ IOException -> 0x00e8 }
            r0 = 1
            r8.setInstanceFollowRedirects(r0)     // Catch:{ IOException -> 0x00e8 }
            r8.connect()     // Catch:{ IOException -> 0x00e0 }
            net.one97.paytm.wifi.models.InternetStatus r0 = net.one97.paytm.wifi.models.InternetStatus.CONFIGURED_COMPLETE     // Catch:{ IOException -> 0x00e0 }
            r13.postValue(r0)     // Catch:{ IOException -> 0x00e0 }
            int r0 = r8.getResponseCode()     // Catch:{ IOException -> 0x00e0 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 < r1) goto L_0x00d2
            int r0 = r8.getResponseCode()     // Catch:{ IOException -> 0x00e0 }
            r1 = 300(0x12c, float:4.2E-43)
            if (r0 >= r1) goto L_0x00d2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e0 }
            java.lang.String r1 = "Redirected url "
            r0.<init>(r1)     // Catch:{ IOException -> 0x00e0 }
            r0.append(r10)     // Catch:{ IOException -> 0x00e0 }
            java.lang.String r1 = " is succeeded with response code "
            r0.append(r1)     // Catch:{ IOException -> 0x00e0 }
            int r1 = r8.getResponseCode()     // Catch:{ IOException -> 0x00e0 }
            r0.append(r1)     // Catch:{ IOException -> 0x00e0 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00e0 }
            com.paytm.utility.q.d(r0)     // Catch:{ IOException -> 0x00e0 }
            r8.disconnect()     // Catch:{ IOException -> 0x00e0 }
            net.one97.paytm.wifi.models.InternetStatus r0 = net.one97.paytm.wifi.models.InternetStatus.INTERNET_ACCESS     // Catch:{ IOException -> 0x00e0 }
            r13.postValue(r0)     // Catch:{ IOException -> 0x00e0 }
            goto L_0x010a
        L_0x00d2:
            java.lang.String r0 = "Connectivity check does not return status 200 OK, "
            com.paytm.utility.q.b(r0)     // Catch:{ IOException -> 0x00e0 }
            net.one97.paytm.wifi.models.InternetStatus r0 = net.one97.paytm.wifi.models.InternetStatus.CONFIGURED_NO_INTERNET     // Catch:{ IOException -> 0x00e0 }
            r13.postValue(r0)     // Catch:{ IOException -> 0x00e0 }
            r8.disconnect()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x010a
        L_0x00e0:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e2:
            kotlin.u r0 = new kotlin.u     // Catch:{ IOException -> 0x00e8 }
            r0.<init>(r8)     // Catch:{ IOException -> 0x00e8 }
            throw r0     // Catch:{ IOException -> 0x00e8 }
        L_0x00e8:
            r0 = move-exception
            r8 = r6
        L_0x00ea:
            if (r8 == 0) goto L_0x00ef
            r8.disconnect()     // Catch:{ IOException -> 0x010e }
        L_0x00ef:
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x010e }
            java.lang.String r0 = r5.concat(r0)     // Catch:{ IOException -> 0x010e }
            com.paytm.utility.q.b(r0)     // Catch:{ IOException -> 0x010e }
            net.one97.paytm.wifi.models.InternetStatus r0 = net.one97.paytm.wifi.models.InternetStatus.CONFIGURED_NO_INTERNET     // Catch:{ IOException -> 0x010e }
            r13.postValue(r0)     // Catch:{ IOException -> 0x010e }
            goto L_0x010a
        L_0x0100:
            java.lang.String r0 = "Connectivity check does not return status 204, and does not have redirected url "
            com.paytm.utility.q.b(r0)     // Catch:{ IOException -> 0x010e }
            net.one97.paytm.wifi.models.InternetStatus r0 = net.one97.paytm.wifi.models.InternetStatus.CONFIGURED_NO_INTERNET     // Catch:{ IOException -> 0x010e }
            r13.postValue(r0)     // Catch:{ IOException -> 0x010e }
        L_0x010a:
            r7.disconnect()     // Catch:{ IOException -> 0x010e }
            return
        L_0x010e:
            r0 = move-exception
            goto L_0x0118
        L_0x0110:
            kotlin.u r0 = new kotlin.u     // Catch:{ IOException -> 0x0116 }
            r0.<init>(r8)     // Catch:{ IOException -> 0x0116 }
            throw r0     // Catch:{ IOException -> 0x0116 }
        L_0x0116:
            r0 = move-exception
            r7 = r6
        L_0x0118:
            if (r7 == 0) goto L_0x011d
            r7.disconnect()
        L_0x011d:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r5.concat(r0)
            com.paytm.utility.q.b(r0)
            net.one97.paytm.wifi.models.InternetStatus r0 = net.one97.paytm.wifi.models.InternetStatus.CONFIGURED_NO_INTERNET
            r13.postValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wifi.background.wifi.a.b.a(androidx.lifecycle.y):void");
    }
}
