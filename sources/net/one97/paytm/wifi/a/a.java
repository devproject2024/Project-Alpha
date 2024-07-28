package net.one97.paytm.wifi.a;

import android.app.Application;
import android.os.HandlerThread;
import android.os.Looper;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import kotlin.g.b.k;
import net.one97.paytm.wifi.background.wifi.b;
import net.one97.paytm.wifi.background.wifi.d;
import net.one97.paytm.wifi.background.wifi.e;
import net.one97.paytm.wifi.background.wifi.f;
import net.one97.paytm.wifi.background.wifi.filters.c;
import net.one97.paytm.wifi.background.wifiScan.WifiScanReceiver;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final C0409a f21069c = new C0409a((byte) 0);
    /* access modifiers changed from: private */
    public static a n;

    /* renamed from: a  reason: collision with root package name */
    public e f21070a;

    /* renamed from: b  reason: collision with root package name */
    public f f21071b;

    /* renamed from: d  reason: collision with root package name */
    private b f21072d;

    /* renamed from: e  reason: collision with root package name */
    private HandlerThread f21073e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21074f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21075g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21076h;

    /* renamed from: i  reason: collision with root package name */
    private WifiScanReceiver f21077i;
    private d j;
    private boolean k;
    private net.one97.paytm.wifi.background.wifi.a l;
    private final Application m;

    private a(Application application, b bVar) {
        this.m = application;
        Application application2 = this.m;
        this.f21072d = new b(application2, new c(application2));
        this.f21074f = bVar.f21078a;
        this.f21075g = bVar.f21079b;
        this.f21076h = bVar.f21080c;
        b bVar2 = this.f21072d;
        this.f21070a = bVar2;
        this.j = bVar2;
        this.f21073e = new HandlerThread("WiFiProcessingThread");
        this.f21073e.start();
        d dVar = this.j;
        e eVar = this.f21070a;
        Looper looper = this.f21073e.getLooper();
        k.a((Object) looper, "processingThread.looper");
        this.f21071b = new f(dVar, eVar, looper);
        b bVar3 = this.f21072d;
        f fVar = this.f21071b;
        k.c(fVar, "<set-?>");
        bVar3.f21093b = fVar;
        this.f21077i = new WifiScanReceiver(this.f21071b);
        this.l = new net.one97.paytm.wifi.background.wifi.a();
    }

    public /* synthetic */ a(Application application, b bVar, byte b2) {
        this(application, bVar);
    }

    public final void a(boolean z) {
        this.k = z;
        this.f21072d.f21094c = z;
    }

    /* renamed from: net.one97.paytm.wifi.a.a$a  reason: collision with other inner class name */
    public static final class C0409a {
        private C0409a() {
        }

        public /* synthetic */ C0409a(byte b2) {
            this();
        }

        public static a a() {
            if (a.n != null) {
                a a2 = a.n;
                if (a2 == null) {
                    k.a();
                }
                return a2;
            }
            throw new IllegalStateException("Call PaytmWiFi.init(app) first.");
        }

        /* access modifiers changed from: private */
        public static void a(Application application, b bVar) {
            k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            k.c(bVar, CLConstants.INPUT_KEY_CONFIGURATION);
            if (a.n == null) {
                a.n = new a(application, bVar, (byte) 0);
            }
        }
    }
}
