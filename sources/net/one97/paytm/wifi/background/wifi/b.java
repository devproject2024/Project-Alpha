package net.one97.paytm.wifi.background.wifi;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.k.i;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.wifi.background.wifi.b.a;
import net.one97.paytm.wifi.background.wifi.connector.WifiConnectProcessReceiver;
import net.one97.paytm.wifi.models.ConnectionStatus;
import net.one97.paytm.wifi.models.InternetStatus;
import net.one97.paytm.wifi.models.WifiAccessPoint;
import net.one97.paytm.wifi.models.WifiConnection;
import net.one97.paytm.wifi.models.WifiConnectionStatus;

public final class b implements d, e, net.one97.paytm.wifi.background.wifi.filters.a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f21091a = {y.a((v) new w(y.b(b.class), "wifiNotificationProcessor", "getWifiNotificationProcessor()Lnet/one97/paytm/wifi/background/wifi/wifiNotifications/WifiNotificationProcessor;"))};

    /* renamed from: e  reason: collision with root package name */
    public static final a f21092e = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public f f21093b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21094c;

    /* renamed from: d  reason: collision with root package name */
    final Application f21095d;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public WifiManager f21096f;

    /* renamed from: g  reason: collision with root package name */
    private ConnectivityManager f21097g;

    /* renamed from: h  reason: collision with root package name */
    private final androidx.lifecycle.y<List<WifiAccessPoint>> f21098h;

    /* renamed from: i  reason: collision with root package name */
    private final androidx.lifecycle.y<WifiConnection> f21099i;
    private net.one97.paytm.wifi.background.wifi.filters.d j;
    private final androidx.lifecycle.y<String> k;
    private final kotlin.g l;
    private List<WifiAccessPoint> m;
    private WifiConnection n;
    private final /* synthetic */ net.one97.paytm.wifi.background.wifi.filters.d o;

    public final String a(String str) {
        k.c(str, "ssid");
        return this.o.a(str);
    }

    public final String b(String str) {
        k.c(str, "ssid");
        return this.o.b(str);
    }

    public final String c(String str) {
        k.c(str, "ssid");
        return this.o.c(str);
    }

    public final boolean d(String str) {
        k.c(str, "ssid");
        return this.o.d(str);
    }

    static final class e extends l implements kotlin.g.a.b<z<SupplicantState>, x> {
        final /* synthetic */ WifiConnectProcessReceiver $wifiConnectProcessRec;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar, WifiConnectProcessReceiver wifiConnectProcessReceiver) {
            super(1);
            this.this$0 = bVar;
            this.$wifiConnectProcessRec = wifiConnectProcessReceiver;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((z<SupplicantState>) (z) obj);
            return x.f47997a;
        }

        public final void invoke(z<SupplicantState> zVar) {
            k.c(zVar, "observer");
            this.$wifiConnectProcessRec.f21121a.removeObserver(zVar);
            Context context = this.this$0.f21095d;
            BroadcastReceiver broadcastReceiver = this.$wifiConnectProcessRec;
            k.c(context, "context");
            if (broadcastReceiver != null) {
                try {
                    context.unregisterReceiver(broadcastReceiver);
                } catch (Exception e2) {
                    q.b(e2.toString());
                }
            }
        }
    }

    public b(Application application, net.one97.paytm.wifi.background.wifi.filters.d dVar) {
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(dVar, "scanResultsFilter");
        this.o = dVar;
        this.f21095d = application;
        Object systemService = this.f21095d.getSystemService("wifi");
        if (systemService != null) {
            this.f21096f = (WifiManager) systemService;
            Object systemService2 = this.f21095d.getSystemService("connectivity");
            if (systemService2 != null) {
                this.f21097g = (ConnectivityManager) systemService2;
                this.f21098h = new androidx.lifecycle.y<>();
                this.f21099i = new androidx.lifecycle.y<>();
                this.k = new androidx.lifecycle.y<>();
                this.l = kotlin.h.a(new h(this, dVar));
                this.m = new ArrayList();
                this.f21098h.setValue(this.m);
                this.f21099i.setValue(this.n);
                this.j = dVar;
                f();
                return;
            }
            throw new u("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        throw new u("null cannot be cast to non-null type android.net.wifi.WifiManager");
    }

    static final class h extends l implements kotlin.g.a.a<a> {
        final /* synthetic */ net.one97.paytm.wifi.background.wifi.filters.d $scanResultsFilter;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar, net.one97.paytm.wifi.background.wifi.filters.d dVar) {
            super(0);
            this.this$0 = bVar;
            this.$scanResultsFilter = dVar;
        }

        public final a invoke() {
            return new a(this.this$0.f21095d, this.$scanResultsFilter, this.this$0.f21096f);
        }
    }

    public final WifiManager a() {
        return this.f21096f;
    }

    public final boolean b() {
        return this.f21096f.isWifiEnabled();
    }

    public final boolean c() {
        if (!this.f21096f.isWifiEnabled()) {
            return this.f21096f.setWifiEnabled(true);
        }
        return true;
    }

    public final LiveData<List<WifiAccessPoint>> d() {
        return this.f21098h;
    }

    public final LiveData<WifiConnection> e() {
        return this.f21099i;
    }

    public final LiveData<WifiConnectionStatus> a(WifiAccessPoint wifiAccessPoint) {
        k.c(wifiAccessPoint, "accessPoint");
        androidx.lifecycle.y yVar = new androidx.lifecycle.y();
        f fVar = this.f21093b;
        if (fVar == null) {
            k.a("wifiHandler");
        }
        fVar.post(new c(this, wifiAccessPoint, yVar));
        return yVar;
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f21107a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WifiAccessPoint f21108b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ androidx.lifecycle.y f21109c;

        c(b bVar, WifiAccessPoint wifiAccessPoint, androidx.lifecycle.y yVar) {
            this.f21107a = bVar;
            this.f21108b = wifiAccessPoint;
            this.f21109c = yVar;
        }

        public final void run() {
            b.a(this.f21107a, this.f21108b, this.f21109c);
        }
    }

    public final void f() {
        q.d("Checking new scan results...");
        List<ScanResult> scanResults = this.f21096f.getScanResults();
        q.d(scanResults.size() + " new wifi access points in scan.");
        WifiInfo connectionInfo = this.f21096f.getConnectionInfo();
        net.one97.paytm.wifi.background.wifi.filters.d dVar = this.j;
        k.a((Object) scanResults, "scanResults");
        this.f21096f.getConfiguredNetworks();
        List<WifiAccessPoint> a2 = dVar.a(scanResults, connectionInfo);
        this.m.clear();
        this.m.addAll(a2);
        this.f21098h.postValue(this.m);
        WifiConnection a3 = this.j.a(connectionInfo);
        q.d("active connection : ".concat(String.valueOf(a3)));
        this.n = a3;
        this.f21099i.postValue(this.n);
        if (!this.f21094c) {
            this.l.getValue();
            a.a(scanResults, a2);
        }
    }

    public final void a(int i2, int i3) {
        q.d("State Changed. Old State " + i2 + " new state " + i3);
    }

    public final void g() {
        f fVar = this.f21093b;
        if (fVar == null) {
            k.a("wifiHandler");
        }
        fVar.a(1, Boolean.TRUE).sendToTarget();
    }

    public final void b(WifiAccessPoint wifiAccessPoint) {
        k.c(wifiAccessPoint, "accessPoint");
        if (!this.f21096f.isWifiEnabled() && !this.f21096f.setWifiEnabled(true)) {
            this.k.postValue("Wifi can not be turned ON right now.");
        }
    }

    public static final class f implements z<SupplicantState> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f21111a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.lifecycle.y f21112b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f21113c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ WifiAccessPoint f21114d;

        f(b bVar, androidx.lifecycle.y yVar, e eVar, WifiAccessPoint wifiAccessPoint) {
            this.f21111a = bVar;
            this.f21112b = yVar;
            this.f21113c = eVar;
            this.f21114d = wifiAccessPoint;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            SupplicantState supplicantState = (SupplicantState) obj;
            if (supplicantState != null) {
                switch (c.f21118a[supplicantState.ordinal()]) {
                    case 1:
                    case 2:
                        this.f21112b.postValue(new WifiConnectionStatus(ConnectionStatus.DISCONNECTED, "Disconnected"));
                        this.f21113c.invoke((z<SupplicantState>) this);
                        this.f21111a.g();
                        return;
                    case 3:
                        this.f21112b.postValue(new WifiConnectionStatus(ConnectionStatus.INACTIVE, "Inactive..."));
                        this.f21113c.invoke((z<SupplicantState>) this);
                        return;
                    case 4:
                        this.f21112b.postValue(new WifiConnectionStatus(ConnectionStatus.INVALID, "Inactive..."));
                        this.f21113c.invoke((z<SupplicantState>) this);
                        return;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        this.f21112b.postValue(new WifiConnectionStatus(ConnectionStatus.AUTHENTICATING, "Authenticating..."));
                        return;
                    case 10:
                        this.f21112b.postValue(new WifiConnectionStatus(ConnectionStatus.INTERNET_CONNECTION, "Checking Internet access ..."));
                        this.f21113c.invoke((z<SupplicantState>) this);
                        this.f21111a.a(this.f21114d, (androidx.lifecycle.y<WifiConnectionStatus>) this.f21112b, 2000);
                        return;
                    default:
                        this.f21112b.postValue(new WifiConnectionStatus(ConnectionStatus.CONNECTING, "Connecting.."));
                        return;
                }
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f21110a;

        d(b bVar) {
            this.f21110a = bVar;
        }

        public final void run() {
            this.f21110a.f21096f.disconnect();
            WifiManager a2 = this.f21110a.f21096f;
            WifiInfo connectionInfo = this.f21110a.f21096f.getConnectionInfo();
            k.a((Object) connectionInfo, "wifiManager.connectionInfo");
            a2.removeNetwork(connectionInfo.getNetworkId());
        }
    }

    public final void h() {
        f fVar = this.f21093b;
        if (fVar == null) {
            k.a("wifiHandler");
        }
        fVar.post(new d(this));
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f21115a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WifiAccessPoint f21116b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ androidx.lifecycle.y f21117c;

        g(b bVar, WifiAccessPoint wifiAccessPoint, androidx.lifecycle.y yVar) {
            this.f21115a = bVar;
            this.f21116b = wifiAccessPoint;
            this.f21117c = yVar;
        }

        public final void run() {
            b.c(this.f21115a, this.f21116b, this.f21117c);
        }
    }

    /* access modifiers changed from: private */
    public final void a(WifiAccessPoint wifiAccessPoint, androidx.lifecycle.y<WifiConnectionStatus> yVar, long j2) {
        f fVar = this.f21093b;
        if (fVar == null) {
            k.a("wifiHandler");
        }
        fVar.postDelayed(new g(this, wifiAccessPoint, yVar), j2);
    }

    /* renamed from: net.one97.paytm.wifi.background.wifi.b$b  reason: collision with other inner class name */
    public static final class C0413b implements z<InternetStatus> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f21104a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.lifecycle.y f21105b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LiveData f21106c;

        C0413b(b bVar, androidx.lifecycle.y yVar, LiveData liveData) {
            this.f21104a = bVar;
            this.f21105b = yVar;
            this.f21106c = liveData;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            InternetStatus internetStatus = (InternetStatus) obj;
            if (internetStatus != null) {
                int i2 = c.f21119b[internetStatus.ordinal()];
                if (i2 == 1) {
                    androidx.lifecycle.y yVar = this.f21105b;
                    WifiConnectionStatus wifiConnectionStatus = new WifiConnectionStatus(ConnectionStatus.CONNECTED, "Connected successfully");
                    wifiConnectionStatus.setInternetStatus(internetStatus);
                    yVar.postValue(wifiConnectionStatus);
                    this.f21106c.removeObserver(this);
                    this.f21104a.g();
                } else if (i2 != 2) {
                    Object value = this.f21105b.getValue();
                    if (value == null) {
                        k.a();
                    }
                    k.a(value, "status.value!!");
                    WifiConnectionStatus wifiConnectionStatus2 = (WifiConnectionStatus) value;
                    wifiConnectionStatus2.setInternetStatus(internetStatus);
                    this.f21105b.postValue(wifiConnectionStatus2);
                    q.d(internetStatus.toString());
                } else {
                    androidx.lifecycle.y yVar2 = this.f21105b;
                    WifiConnectionStatus wifiConnectionStatus3 = new WifiConnectionStatus(ConnectionStatus.CONNECTED, "Connected successfully but no internet");
                    wifiConnectionStatus3.setInternetStatus(internetStatus);
                    yVar2.postValue(wifiConnectionStatus3);
                    this.f21106c.removeObserver(this);
                    this.f21104a.g();
                }
            }
        }
    }

    public final void a(int i2) {
        WifiConnection wifiConnection = this.n;
        if (wifiConnection != null) {
            q.d("new Rssi of " + wifiConnection.getSSID() + " is " + i2);
            wifiConnection.setRssi(i2);
            wifiConnection.setSignalStrength(WifiManager.calculateSignalLevel(i2, 5));
            this.f21099i.postValue(this.n);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0277, code lost:
        if (r0.reassociate() != false) goto L_0x02d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x02a0, code lost:
        if (r8 != null) goto L_0x02a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02d0, code lost:
        if (r0.reassociate() != false) goto L_0x02d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x031f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.wifi.background.wifi.b r13, net.one97.paytm.wifi.models.WifiAccessPoint r14, androidx.lifecycle.y r15) {
        /*
            android.net.wifi.WifiManager r0 = r13.f21096f
            boolean r0 = r0.isWifiEnabled()
            r1 = 1
            if (r0 != 0) goto L_0x001e
            android.net.wifi.WifiManager r0 = r13.f21096f
            boolean r0 = r0.setWifiEnabled(r1)
            if (r0 != 0) goto L_0x001e
            net.one97.paytm.wifi.models.WifiConnectionStatus r13 = new net.one97.paytm.wifi.models.WifiConnectionStatus
            net.one97.paytm.wifi.models.ConnectionStatus r14 = net.one97.paytm.wifi.models.ConnectionStatus.DISCONNECTED
            java.lang.String r0 = "Wifi can't be turned ON right now."
            r13.<init>(r14, r0)
            r15.postValue(r13)
            return
        L_0x001e:
            android.net.wifi.WifiManager r0 = r13.f21096f
            java.util.List r2 = r14.getBssids()
            boolean r0 = net.one97.paytm.wifi.background.wifi.connector.b.a((android.net.wifi.WifiManager) r0, (java.util.List<net.one97.paytm.wifi.models.BSSIDData>) r2)
            if (r0 == 0) goto L_0x003c
            net.one97.paytm.wifi.models.WifiConnectionStatus r0 = new net.one97.paytm.wifi.models.WifiConnectionStatus
            net.one97.paytm.wifi.models.ConnectionStatus r1 = net.one97.paytm.wifi.models.ConnectionStatus.CONNECTED
            java.lang.String r2 = "Already connected."
            r0.<init>(r1, r2)
            r15.postValue(r0)
            r0 = 0
            r13.a((net.one97.paytm.wifi.models.WifiAccessPoint) r14, (androidx.lifecycle.y<net.one97.paytm.wifi.models.WifiConnectionStatus>) r15, (long) r0)
            return
        L_0x003c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Connecting with "
            r0.<init>(r2)
            java.lang.String r2 = r14.getSSID()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.paytm.utility.q.d(r0)
            android.net.wifi.WifiManager r0 = r13.f21096f
            android.app.Application r2 = r13.f21095d
            java.lang.String r3 = ""
            java.lang.String r4 = "receiver$0"
            kotlin.g.b.k.c(r0, r4)
            java.lang.String r5 = "context"
            kotlin.g.b.k.c(r2, r5)
            java.lang.String r5 = "accessPoint"
            kotlin.g.b.k.c(r14, r5)
            java.lang.String r6 = "password"
            kotlin.g.b.k.c(r3, r6)
            java.util.List r7 = r0.getConfiguredNetworks()
            if (r7 == 0) goto L_0x0341
            java.util.List r7 = kotlin.g.b.ab.c(r7)
            android.net.wifi.WifiConfiguration r8 = net.one97.paytm.wifi.background.wifi.connector.c.a((java.util.List<? extends android.net.wifi.WifiConfiguration>) r7, (net.one97.paytm.wifi.models.WifiAccessPoint) r14)
            r9 = -1
            r10 = 0
            if (r8 == 0) goto L_0x0092
            r11 = r3
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            int r11 = r11.length()
            if (r11 != 0) goto L_0x0088
            r11 = 1
            goto L_0x0089
        L_0x0088:
            r11 = 0
        L_0x0089:
            if (r11 == 0) goto L_0x0092
            java.lang.String r2 = "Password was empty but network is configured. Trying to connect to existing network configuration..."
            com.paytm.utility.q.d(r2)
            goto L_0x0263
        L_0x0092:
            java.lang.String r11 = "Attempting to remove previous network config..."
            com.paytm.utility.q.d(r11)
            if (r8 != 0) goto L_0x009b
        L_0x0099:
            r11 = 1
            goto L_0x00a5
        L_0x009b:
            int r11 = r8.networkId
            boolean r11 = r0.removeNetwork(r11)
            if (r11 == 0) goto L_0x00a4
            goto L_0x0099
        L_0x00a4:
            r11 = 0
        L_0x00a5:
            if (r11 != 0) goto L_0x00ae
            java.lang.String r2 = "Not able to remove previous config. Trying with the old..."
            com.paytm.utility.q.b(r2)
            goto L_0x0263
        L_0x00ae:
            java.lang.String r8 = net.one97.paytm.wifi.background.wifi.connector.c.a((net.one97.paytm.wifi.models.WifiAccessPoint) r14)
            java.lang.String r11 = "OPEN"
            boolean r12 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r8)
            if (r12 == 0) goto L_0x00c6
            android.content.ContentResolver r2 = r2.getContentResolver()
            java.lang.String r12 = "context.contentResolver"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r12)
            net.one97.paytm.wifi.background.wifi.connector.b.a((android.content.ContentResolver) r2, (android.net.wifi.WifiManager) r0, (java.util.List<android.net.wifi.WifiConfiguration>) r7)
        L_0x00c6:
            android.net.wifi.WifiConfiguration r2 = new android.net.wifi.WifiConfiguration
            r2.<init>()
            java.lang.String r7 = r14.getSSID()
            java.lang.String r7 = net.one97.paytm.wifi.background.wifi.g.b(r7)
            r2.SSID = r7
            kotlin.g.b.k.c(r2, r4)
            java.lang.String r4 = "security"
            kotlin.g.b.k.c(r8, r4)
            kotlin.g.b.k.c(r3, r6)
            java.util.BitSet r4 = r2.allowedAuthAlgorithms
            r4.clear()
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.clear()
            java.util.BitSet r4 = r2.allowedKeyManagement
            r4.clear()
            java.util.BitSet r4 = r2.allowedPairwiseCiphers
            r4.clear()
            java.util.BitSet r4 = r2.allowedProtocols
            r4.clear()
            java.lang.String r4 = java.lang.String.valueOf(r8)
            java.lang.String r6 = "Setting up security "
            java.lang.String r4 = r6.concat(r4)
            com.paytm.utility.q.d(r4)
            int r4 = r8.hashCode()
            r6 = 3
            r7 = 2
            switch(r4) {
                case 68404: goto L_0x01d4;
                case 79528: goto L_0x0185;
                case 85826: goto L_0x0146;
                case 2432586: goto L_0x0111;
                default: goto L_0x010f;
            }
        L_0x010f:
            goto L_0x0215
        L_0x0111:
            boolean r3 = r8.equals(r11)
            if (r3 == 0) goto L_0x0215
            java.util.BitSet r3 = r2.allowedKeyManagement
            r3.set(r10)
            java.util.BitSet r3 = r2.allowedProtocols
            r3.set(r1)
            java.util.BitSet r3 = r2.allowedProtocols
            r3.set(r10)
            java.util.BitSet r3 = r2.allowedPairwiseCiphers
            r3.set(r7)
            java.util.BitSet r3 = r2.allowedPairwiseCiphers
            r3.set(r1)
            java.util.BitSet r3 = r2.allowedGroupCiphers
            r3.set(r10)
            java.util.BitSet r3 = r2.allowedGroupCiphers
            r3.set(r1)
            java.util.BitSet r3 = r2.allowedGroupCiphers
            r3.set(r6)
            java.util.BitSet r3 = r2.allowedGroupCiphers
            r3.set(r7)
            goto L_0x0222
        L_0x0146:
            java.lang.String r4 = "WEP"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0215
            java.util.BitSet r4 = r2.allowedKeyManagement
            r4.set(r10)
            java.util.BitSet r4 = r2.allowedProtocols
            r4.set(r1)
            java.util.BitSet r4 = r2.allowedProtocols
            r4.set(r10)
            java.util.BitSet r4 = r2.allowedAuthAlgorithms
            r4.set(r10)
            java.util.BitSet r4 = r2.allowedAuthAlgorithms
            r4.set(r1)
            java.util.BitSet r4 = r2.allowedPairwiseCiphers
            r4.set(r7)
            java.util.BitSet r4 = r2.allowedPairwiseCiphers
            r4.set(r1)
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.set(r10)
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.set(r1)
            java.lang.String[] r4 = r2.wepKeys
            java.lang.String r3 = net.one97.paytm.wifi.background.wifi.g.b(r3)
            r4[r10] = r3
            goto L_0x0222
        L_0x0185:
            java.lang.String r4 = "PSK"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0215
            java.util.BitSet r4 = r2.allowedProtocols
            r4.set(r1)
            java.util.BitSet r4 = r2.allowedProtocols
            r4.set(r10)
            java.util.BitSet r4 = r2.allowedKeyManagement
            r4.set(r1)
            java.util.BitSet r4 = r2.allowedPairwiseCiphers
            r4.set(r7)
            java.util.BitSet r4 = r2.allowedPairwiseCiphers
            r4.set(r1)
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.set(r10)
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.set(r1)
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.set(r6)
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.set(r7)
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            kotlin.m.l r6 = new kotlin.m.l
            java.lang.String r7 = "[0-9A-Fa-f]{64}"
            r6.<init>((java.lang.String) r7)
            boolean r4 = r6.matches(r4)
            if (r4 == 0) goto L_0x01cd
            r2.preSharedKey = r3
            goto L_0x0222
        L_0x01cd:
            java.lang.String r3 = net.one97.paytm.wifi.background.wifi.g.b(r3)
            r2.preSharedKey = r3
            goto L_0x0222
        L_0x01d4:
            java.lang.String r4 = "EAP"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0215
            java.util.BitSet r4 = r2.allowedProtocols
            r4.set(r1)
            java.util.BitSet r4 = r2.allowedProtocols
            r4.set(r10)
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.set(r10)
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.set(r1)
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.set(r7)
            java.util.BitSet r4 = r2.allowedGroupCiphers
            r4.set(r6)
            java.util.BitSet r4 = r2.allowedPairwiseCiphers
            r4.set(r1)
            java.util.BitSet r4 = r2.allowedPairwiseCiphers
            r4.set(r7)
            java.util.BitSet r4 = r2.allowedKeyManagement
            r4.set(r7)
            java.util.BitSet r4 = r2.allowedKeyManagement
            r4.set(r6)
            java.lang.String r3 = net.one97.paytm.wifi.background.wifi.g.b(r3)
            r2.preSharedKey = r3
            goto L_0x0222
        L_0x0215:
            java.lang.String r3 = java.lang.String.valueOf(r8)
            java.lang.String r4 = "Invalid security type: "
            java.lang.String r3 = r4.concat(r3)
            com.paytm.utility.q.d(r3)
        L_0x0222:
            int r3 = r0.addNetwork(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Added configuration Network ID: "
            r4.<init>(r6)
            r4.append(r3)
            r6 = 46
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            com.paytm.utility.q.d(r4)
            if (r3 != r9) goto L_0x0245
            java.lang.String r0 = "Unable to add new configurations"
            com.paytm.utility.q.b(r0)
            goto L_0x02d3
        L_0x0245:
            boolean r3 = r0.saveConfiguration()
            if (r3 != 0) goto L_0x0252
            java.lang.String r0 = "Couldn't save wifi config"
            com.paytm.utility.q.b(r0)
            goto L_0x02d3
        L_0x0252:
            java.util.List r3 = r0.getConfiguredNetworks()
            android.net.wifi.WifiConfiguration r8 = net.one97.paytm.wifi.background.wifi.connector.c.a((java.util.List<? extends android.net.wifi.WifiConfiguration>) r3, (android.net.wifi.WifiConfiguration) r2)
            if (r8 != 0) goto L_0x0263
            java.lang.String r0 = "Error getting wifi config after save."
            com.paytm.utility.q.b(r0)
            goto L_0x02d3
        L_0x0263:
            if (r8 != 0) goto L_0x0267
            goto L_0x02d3
        L_0x0267:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x027a
            boolean r2 = net.one97.paytm.wifi.background.wifi.connector.b.a((android.net.wifi.WifiManager) r0, (android.net.wifi.WifiConfiguration) r8)
            if (r2 == 0) goto L_0x02d3
            boolean r0 = r0.reassociate()
            if (r0 == 0) goto L_0x02d3
            goto L_0x02d4
        L_0x027a:
            if (r8 != 0) goto L_0x027f
            kotlin.g.b.k.a()
        L_0x027f:
            int r2 = r8.priority
            int r3 = net.one97.paytm.wifi.background.wifi.connector.b.a(r0)
            int r3 = r3 + r1
            r4 = 99999(0x1869f, float:1.40128E-40)
            if (r3 <= r4) goto L_0x02a2
            java.util.List r3 = r0.getConfiguredNetworks()
            java.lang.String r4 = "wifiManager.configuredNetworks"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            int r3 = net.one97.paytm.wifi.background.wifi.connector.b.b(r0, r3)
            java.util.List r4 = r0.getConfiguredNetworks()
            android.net.wifi.WifiConfiguration r8 = net.one97.paytm.wifi.background.wifi.connector.c.a((java.util.List<? extends android.net.wifi.WifiConfiguration>) r4, (android.net.wifi.WifiConfiguration) r8)
            if (r8 == 0) goto L_0x02d3
        L_0x02a2:
            r8.priority = r3
            int r3 = r0.updateNetwork(r8)
            if (r3 == r9) goto L_0x02d3
            boolean r3 = r0.enableNetwork(r3, r10)
            if (r3 != 0) goto L_0x02b3
            r8.priority = r2
            goto L_0x02d3
        L_0x02b3:
            boolean r3 = r0.saveConfiguration()
            if (r3 != 0) goto L_0x02bc
            r8.priority = r2
            goto L_0x02d3
        L_0x02bc:
            java.util.List r2 = r0.getConfiguredNetworks()
            android.net.wifi.WifiConfiguration r2 = net.one97.paytm.wifi.background.wifi.connector.c.a((java.util.List<? extends android.net.wifi.WifiConfiguration>) r2, (android.net.wifi.WifiConfiguration) r8)
            if (r2 == 0) goto L_0x02d3
            boolean r2 = net.one97.paytm.wifi.background.wifi.connector.b.a((android.net.wifi.WifiManager) r0, (android.net.wifi.WifiConfiguration) r2)
            if (r2 == 0) goto L_0x02d3
            boolean r0 = r0.reassociate()
            if (r0 == 0) goto L_0x02d3
            goto L_0x02d4
        L_0x02d3:
            r1 = 0
        L_0x02d4:
            if (r1 == 0) goto L_0x031f
            net.one97.paytm.wifi.background.wifi.connector.WifiConnectProcessReceiver r0 = new net.one97.paytm.wifi.background.wifi.connector.WifiConnectProcessReceiver
            android.net.wifi.WifiManager r1 = r13.f21096f
            r0.<init>(r1, r14)
            net.one97.paytm.wifi.background.wifi.b$e r1 = new net.one97.paytm.wifi.background.wifi.b$e
            r1.<init>(r13, r0)
            net.one97.paytm.wifi.background.wifi.b$f r2 = new net.one97.paytm.wifi.background.wifi.b$f
            r2.<init>(r13, r15, r1, r14)
            androidx.lifecycle.y<android.net.wifi.SupplicantState> r15 = r0.f21121a     // Catch:{ Exception -> 0x02f0 }
            androidx.lifecycle.LiveData r15 = (androidx.lifecycle.LiveData) r15     // Catch:{ Exception -> 0x02f0 }
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2     // Catch:{ Exception -> 0x02f0 }
            r15.observeForever(r2)     // Catch:{ Exception -> 0x02f0 }
        L_0x02f0:
            android.app.Application r15 = r13.f21095d
            android.content.Context r15 = (android.content.Context) r15
            kotlin.g.b.k.c(r14, r5)
            r0.f21125e = r14
            android.os.Handler r14 = r0.f21122b
            net.one97.paytm.wifi.background.wifi.connector.WifiConnectProcessReceiver$b r1 = r0.f21123c
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            long r2 = r0.f21124d
            r14.postDelayed(r1, r2)
            android.content.BroadcastReceiver r0 = (android.content.BroadcastReceiver) r0
            android.content.IntentFilter r14 = new android.content.IntentFilter
            java.lang.String r1 = "android.net.wifi.supplicant.STATE_CHANGE"
            r14.<init>(r1)
            net.one97.paytm.wifi.background.wifi.connector.b.a((android.content.Context) r15, (android.content.BroadcastReceiver) r0, (android.content.IntentFilter) r14)
            android.app.Application r13 = r13.f21095d
            android.content.Context r13 = (android.content.Context) r13
            android.content.IntentFilter r14 = new android.content.IntentFilter
            java.lang.String r15 = "android.net.wifi.STATE_CHANGE"
            r14.<init>(r15)
            net.one97.paytm.wifi.background.wifi.connector.b.a((android.content.Context) r13, (android.content.BroadcastReceiver) r0, (android.content.IntentFilter) r14)
            return
        L_0x031f:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "Some error in connecting with "
            r13.<init>(r0)
            java.lang.String r14 = r14.getSSID()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            com.paytm.utility.q.b(r13)
            net.one97.paytm.wifi.models.WifiConnectionStatus r13 = new net.one97.paytm.wifi.models.WifiConnectionStatus
            net.one97.paytm.wifi.models.ConnectionStatus r14 = net.one97.paytm.wifi.models.ConnectionStatus.DISCONNECTED
            java.lang.String r0 = "Error while connecting"
            r13.<init>(r14, r0)
            r15.postValue(r13)
            return
        L_0x0341:
            kotlin.u r13 = new kotlin.u
            java.lang.String r14 = "null cannot be cast to non-null type kotlin.collections.MutableList<android.net.wifi.WifiConfiguration!>"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wifi.background.wifi.b.a(net.one97.paytm.wifi.background.wifi.b, net.one97.paytm.wifi.models.WifiAccessPoint, androidx.lifecycle.y):void");
    }

    public static final /* synthetic */ void c(b bVar, WifiAccessPoint wifiAccessPoint, androidx.lifecycle.y yVar) {
        q.d("Checking for internet connection with " + wifiAccessPoint.getSSID());
        net.one97.paytm.wifi.background.wifi.a.c cVar = net.one97.paytm.wifi.background.wifi.a.c.f21090a;
        LiveData<InternetStatus> a2 = net.one97.paytm.wifi.background.wifi.a.c.a(bVar.f21095d, wifiAccessPoint).a();
        a2.observeForever(new C0413b(bVar, yVar, a2));
    }
}
