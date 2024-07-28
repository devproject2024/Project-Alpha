package net.one97.paytm.wifi.background.wifi.filters;

import android.app.Application;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlin.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.wifi.models.BSSIDData;
import net.one97.paytm.wifi.models.WiFiWidth;
import net.one97.paytm.wifi.models.WifiAccessPoint;
import net.one97.paytm.wifi.models.WifiConnection;
import net.one97.paytm.wifi.models.WifiConstantsKt;
import net.one97.paytm.wifi.models.WifiSignal;

public final class c implements d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f21138a = {y.a((v) new w(y.b(c.class), "paytmSSIDFilter", "getPaytmSSIDFilter()Lnet/one97/paytm/wifi/background/wifi/filters/PaytmSSIDFilter;"))};

    /* renamed from: b  reason: collision with root package name */
    public static final b f21139b = new b((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private final C0415c f21140c = new C0415c();

    /* renamed from: d  reason: collision with root package name */
    private final d f21141d = new d();

    /* renamed from: e  reason: collision with root package name */
    private final e f21142e = new e();

    /* renamed from: f  reason: collision with root package name */
    private final g f21143f = h.a(l.SYNCHRONIZED, new f(this));
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Application f21144g;

    /* access modifiers changed from: private */
    public final a a() {
        return (a) this.f21143f.getValue();
    }

    public c(Application application) {
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        this.f21144g = application;
    }

    static final class f extends kotlin.g.b.l implements kotlin.g.a.a<b> {
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(c cVar) {
            super(0);
            this.this$0 = cVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0 A[Catch:{ all -> 0x0078, Exception -> 0x00f0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00b5 A[Catch:{ all -> 0x0078, Exception -> 0x00f0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00b8 A[Catch:{ all -> 0x0078, Exception -> 0x00f0 }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf A[Catch:{ all -> 0x0078, Exception -> 0x00f0 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final net.one97.paytm.wifi.background.wifi.filters.b invoke() {
            /*
                r9 = this;
                net.one97.paytm.wifi.background.wifi.filters.b r0 = new net.one97.paytm.wifi.background.wifi.filters.b
                net.one97.paytm.wifi.background.wifi.filters.c r1 = r9.this$0
                android.app.Application r1 = r1.f21144g
                r0.<init>(r1)
                long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f0 }
                net.one97.paytm.wifi.a r3 = net.one97.paytm.wifi.a.a()     // Catch:{ Exception -> 0x00f0 }
                java.lang.String r4 = "WifiController.getInstance()"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x00f0 }
                net.one97.paytm.wifi.b r3 = net.one97.paytm.wifi.a.c()     // Catch:{ Exception -> 0x00f0 }
                java.lang.String r4 = "WifiController.getInstance().wifiEventListener"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x00f0 }
                java.lang.String r3 = r3.getWifiSSIDMap()     // Catch:{ Exception -> 0x00f0 }
                java.lang.String r4 = "ssidJsonStr"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x00f0 }
                r4 = r3
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x00f0 }
                int r4 = r4.length()     // Catch:{ Exception -> 0x00f0 }
                r5 = 1
                if (r4 != 0) goto L_0x0036
                r4 = 1
                goto L_0x0037
            L_0x0036:
                r4 = 0
            L_0x0037:
                if (r4 == 0) goto L_0x009e
                java.lang.String r3 = "All ssid json string should be in res"
                com.paytm.utility.q.b(r3)     // Catch:{ Exception -> 0x00f0 }
                android.app.Application r3 = r0.f21133c     // Catch:{ Exception -> 0x00f0 }
                android.content.res.Resources r3 = r3.getResources()     // Catch:{ Exception -> 0x00f0 }
                int r4 = net.one97.paytm.wifi.R.raw.prod_all_ssid     // Catch:{ Exception -> 0x00f0 }
                java.io.InputStream r3 = r3.openRawResource(r4)     // Catch:{ Exception -> 0x00f0 }
                java.io.StringWriter r4 = new java.io.StringWriter     // Catch:{ Exception -> 0x00f0 }
                r4.<init>()     // Catch:{ Exception -> 0x00f0 }
                java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x007a }
                java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x007a }
                java.lang.String r8 = "UTF-8"
                r7.<init>(r3, r8)     // Catch:{ Exception -> 0x007a }
                java.io.Reader r7 = (java.io.Reader) r7     // Catch:{ Exception -> 0x007a }
                r6.<init>(r7)     // Catch:{ Exception -> 0x007a }
                java.lang.String r7 = r6.readLine()     // Catch:{ Exception -> 0x007a }
            L_0x0061:
                if (r7 == 0) goto L_0x006b
                r4.write(r7)     // Catch:{ Exception -> 0x007a }
                java.lang.String r7 = r6.readLine()     // Catch:{ Exception -> 0x007a }
                goto L_0x0061
            L_0x006b:
                r3.close()     // Catch:{ Exception -> 0x006f }
                goto L_0x008c
            L_0x006f:
                r3 = move-exception
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00f0 }
            L_0x0074:
                com.paytm.utility.q.b(r3)     // Catch:{ Exception -> 0x00f0 }
                goto L_0x008c
            L_0x0078:
                r1 = move-exception
                goto L_0x0091
            L_0x007a:
                r6 = move-exception
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0078 }
                com.paytm.utility.q.b(r6)     // Catch:{ all -> 0x0078 }
                r3.close()     // Catch:{ Exception -> 0x0086 }
                goto L_0x008c
            L_0x0086:
                r3 = move-exception
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00f0 }
                goto L_0x0074
            L_0x008c:
                java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x00f0 }
                goto L_0x00a1
            L_0x0091:
                r3.close()     // Catch:{ Exception -> 0x0095 }
                goto L_0x009d
            L_0x0095:
                r2 = move-exception
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00f0 }
                com.paytm.utility.q.b(r2)     // Catch:{ Exception -> 0x00f0 }
            L_0x009d:
                throw r1     // Catch:{ Exception -> 0x00f0 }
            L_0x009e:
                com.paytm.utility.q.b(r3)     // Catch:{ Exception -> 0x00f0 }
            L_0x00a1:
                com.google.gson.f r4 = new com.google.gson.f     // Catch:{ Exception -> 0x00f0 }
                r4.<init>()     // Catch:{ Exception -> 0x00f0 }
                java.lang.Class<net.one97.paytm.wifi.background.wifi.filters.AllSSIDJsonModel> r6 = net.one97.paytm.wifi.background.wifi.filters.AllSSIDJsonModel.class
                java.lang.Object r4 = r4.a((java.lang.String) r3, r6)     // Catch:{ Exception -> 0x00f0 }
                net.one97.paytm.wifi.background.wifi.filters.AllSSIDJsonModel r4 = (net.one97.paytm.wifi.background.wifi.filters.AllSSIDJsonModel) r4     // Catch:{ Exception -> 0x00f0 }
                if (r4 == 0) goto L_0x00b5
                java.util.List r6 = r4.getWifiProviders()     // Catch:{ Exception -> 0x00f0 }
                goto L_0x00b6
            L_0x00b5:
                r6 = 0
            L_0x00b6:
                if (r6 != 0) goto L_0x00cf
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f0 }
                java.lang.String r2 = "Error in converting ' "
                r1.<init>(r2)     // Catch:{ Exception -> 0x00f0 }
                r1.append(r3)     // Catch:{ Exception -> 0x00f0 }
                java.lang.String r2 = " ' to model"
                r1.append(r2)     // Catch:{ Exception -> 0x00f0 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00f0 }
                com.paytm.utility.q.b(r1)     // Catch:{ Exception -> 0x00f0 }
                goto L_0x00f8
            L_0x00cf:
                r0.a((net.one97.paytm.wifi.background.wifi.filters.AllSSIDJsonModel) r4)     // Catch:{ Exception -> 0x00f0 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f0 }
                java.lang.String r4 = "Finished hashing all ssids in "
                r3.<init>(r4)     // Catch:{ Exception -> 0x00f0 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f0 }
                long r6 = r6 - r1
                r3.append(r6)     // Catch:{ Exception -> 0x00f0 }
                java.lang.String r1 = " ms"
                r3.append(r1)     // Catch:{ Exception -> 0x00f0 }
                java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x00f0 }
                com.paytm.utility.q.d(r1)     // Catch:{ Exception -> 0x00f0 }
                r0.f21132b = r5     // Catch:{ Exception -> 0x00f0 }
                goto L_0x00f8
            L_0x00f0:
                r1 = move-exception
                java.lang.String r1 = r1.toString()
                com.paytm.utility.q.b(r1)
            L_0x00f8:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wifi.background.wifi.filters.c.f.invoke():net.one97.paytm.wifi.background.wifi.filters.b");
        }
    }

    public final boolean d(String str) {
        k.c(str, "ssid");
        return a().d(str);
    }

    public final String a(String str) {
        k.c(str, "ssid");
        String a2 = a().a(str);
        CharSequence charSequence = a2;
        if (charSequence == null || charSequence.length() == 0) {
            return a2;
        }
        if (a2 == null) {
            k.a();
        }
        return p.a(charSequence, new String[]{"::"}).get(0);
    }

    public final String b(String str) {
        k.c(str, "ssid");
        return a().b(str);
    }

    public final String c(String str) {
        k.c(str, "ssid");
        return a().c(str);
    }

    public final List<WifiAccessPoint> a(List<? extends ScanResult> list, WifiInfo wifiInfo) {
        k.c(list, "scanResults");
        this.f21140c.f21146a = (wifiInfo == null || !b(wifiInfo)) ? null : wifiInfo.getSSID();
        kotlin.l.d k = kotlin.a.k.k(list);
        kotlin.g.a.b bVar = this.f21140c;
        k.d(k, "$this$filter");
        k.d(bVar, "predicate");
        Map linkedHashMap = new LinkedHashMap();
        Iterator a2 = new kotlin.l.b(k, bVar).a();
        while (a2.hasNext()) {
            Object next = a2.next();
            String str = ((ScanResult) next).SSID;
            Object obj = linkedHashMap.get(str);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(str, obj);
            }
            ((List) obj).add(next);
        }
        List<WifiAccessPoint> arrayList = new ArrayList<>();
        for (String str2 : linkedHashMap.keySet()) {
            List list2 = (List) linkedHashMap.get(str2);
            if (list2 != null) {
                Iterable iterable = list2;
                kotlin.a.k.a(iterable, new a(this.f21142e));
                int i2 = 0;
                WifiAccessPoint a3 = this.f21141d.invoke((ScanResult) list2.get(0));
                for (Object next2 : iterable) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.k.a();
                    }
                    ScanResult scanResult = (ScanResult) next2;
                    if (i2 > 0) {
                        List<BSSIDData> bssids = a3.getBssids();
                        if (bssids != null) {
                            ab.c(bssids).add(c(scanResult));
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<net.one97.paytm.wifi.models.BSSIDData>");
                        }
                    }
                    i2 = i3;
                }
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static BSSIDData c(ScanResult scanResult) {
        String str = scanResult.BSSID;
        k.a((Object) str, "scanResult.BSSID");
        return new BSSIDData(str, WifiManager.calculateSignalLevel(scanResult.level, 5), scanResult.level);
    }

    /* renamed from: net.one97.paytm.wifi.background.wifi.filters.c$c  reason: collision with other inner class name */
    public final class C0415c implements kotlin.g.a.b<ScanResult, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        String f21146a;

        public C0415c() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
            if (r1 == null) goto L_0x0027;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object invoke(java.lang.Object r4) {
            /*
                r3 = this;
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                java.lang.String r0 = "scanResult"
                kotlin.g.b.k.c(r4, r0)
                net.one97.paytm.wifi.background.wifi.filters.c r0 = net.one97.paytm.wifi.background.wifi.filters.c.this
                net.one97.paytm.wifi.background.wifi.filters.a r0 = r0.a()
                java.lang.String r1 = r4.SSID
                if (r1 == 0) goto L_0x0027
                if (r1 == 0) goto L_0x001f
                java.lang.String r1 = r1.toLowerCase()
                java.lang.String r2 = "(this as java.lang.String).toLowerCase()"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                if (r1 != 0) goto L_0x0029
                goto L_0x0027
            L_0x001f:
                kotlin.u r4 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
                r4.<init>(r0)
                throw r4
            L_0x0027:
                java.lang.String r1 = "***"
            L_0x0029:
                boolean r0 = r0.d(r1)
                r1 = 1
                if (r0 == 0) goto L_0x0040
                java.lang.String r4 = r4.SSID
                java.lang.String r0 = r3.f21146a
                java.lang.String r0 = net.one97.paytm.wifi.background.wifi.g.c(r0)
                boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r0)
                r4 = r4 ^ r1
                if (r4 == 0) goto L_0x0040
                goto L_0x0041
            L_0x0040:
                r1 = 0
            L_0x0041:
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wifi.background.wifi.filters.c.C0415c.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public final class d implements kotlin.g.a.b<ScanResult, WifiAccessPoint> {
        public d() {
        }

        /* renamed from: a */
        public final WifiAccessPoint invoke(ScanResult scanResult) {
            k.c(scanResult, "scanResult");
            String str = scanResult.SSID;
            if (str == null) {
                str = WifiConstantsKt.SSID_EMPTY;
            }
            String a2 = net.one97.paytm.wifi.background.wifi.g.a(str);
            String str2 = scanResult.capabilities;
            k.a((Object) str2, "scanResult.capabilities");
            WifiAccessPoint wifiAccessPoint = new WifiAccessPoint(a2, str2);
            wifiAccessPoint.setWifiAdditional(c.a(c.this, scanResult));
            wifiAccessPoint.setWifiSignal(c.a(scanResult));
            wifiAccessPoint.setBssids(kotlin.a.k.c(c.c(scanResult)));
            return wifiAccessPoint;
        }
    }

    public static final class a<T> implements Comparator<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f21145a;

        public a(kotlin.g.a.b bVar) {
            this.f21145a = bVar;
        }

        public final int compare(T t, T t2) {
            return kotlin.b.a.a((Comparable) this.f21145a.invoke(t), (Comparable) this.f21145a.invoke(t2));
        }
    }

    public final WifiConnection a(WifiInfo wifiInfo) {
        if (wifiInfo == null || !b(wifiInfo)) {
            return null;
        }
        String ssid = wifiInfo.getSSID();
        k.a((Object) ssid, "wifiInfo.ssid");
        String a2 = net.one97.paytm.wifi.background.wifi.g.a(ssid);
        String bssid = wifiInfo.getBSSID();
        if (bssid == null) {
            bssid = "02:00:00:00:00:00";
        }
        WifiConnection wifiConnection = new WifiConnection(a2, bssid, net.one97.paytm.wifi.background.wifi.g.a(wifiInfo.getIpAddress()), wifiInfo.getLinkSpeed());
        wifiConnection.setRssi(wifiInfo.getRssi());
        wifiConnection.setSignalStrength(WifiManager.calculateSignalLevel(wifiConnection.getRssi(), 5));
        return wifiConnection;
    }

    public static WifiSignal a(ScanResult scanResult) {
        k.c(scanResult, "scanResult");
        return new WifiSignal(scanResult.frequency, Build.VERSION.SDK_INT >= 23 ? scanResult.centerFreq0 : 0, scanResult.level, WiFiWidth.MHZ_20);
    }

    public final class e implements kotlin.g.a.b<ScanResult, Integer> {
        public e() {
        }

        public final /* synthetic */ Object invoke(Object obj) {
            k.c((ScanResult) obj, "scanResult");
            return 0;
        }
    }

    private static boolean b(WifiInfo wifiInfo) {
        return !p.a("<unknown ssid>", wifiInfo.getSSID(), true) && wifiInfo.getNetworkId() != -1;
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        if (r4 == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ net.one97.paytm.wifi.models.WifiAdditional a(net.one97.paytm.wifi.background.wifi.filters.c r3, android.net.wifi.ScanResult r4) {
        /*
            java.lang.String r4 = r4.SSID
            if (r4 == 0) goto L_0x001a
            if (r4 == 0) goto L_0x0012
            java.lang.String r4 = r4.toLowerCase()
            java.lang.String r0 = "(this as java.lang.String).toLowerCase()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            if (r4 != 0) goto L_0x001c
            goto L_0x001a
        L_0x0012:
            kotlin.u r3 = new kotlin.u
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r3.<init>(r4)
            throw r3
        L_0x001a:
            java.lang.String r4 = "***"
        L_0x001c:
            java.lang.String r4 = net.one97.paytm.wifi.background.wifi.g.a((java.lang.String) r4)
            net.one97.paytm.wifi.background.wifi.filters.a r3 = r3.a()
            java.lang.String r3 = r3.a(r4)
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L_0x0038
            int r2 = r4.length()
            if (r2 != 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r2 = 0
            goto L_0x0039
        L_0x0038:
            r2 = 1
        L_0x0039:
            if (r2 == 0) goto L_0x003d
            r3 = 0
            return r3
        L_0x003d:
            net.one97.paytm.wifi.models.WifiAdditional r2 = new net.one97.paytm.wifi.models.WifiAdditional
            r2.<init>()
            if (r3 != 0) goto L_0x0047
            kotlin.g.b.k.a()
        L_0x0047:
            java.lang.String r3 = "::"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            java.util.List r3 = kotlin.m.p.a((java.lang.CharSequence) r4, (java.lang.String[]) r3)
            java.lang.Object r4 = r3.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            r2.setVendorName(r4)
            int r4 = r3.size()
            if (r4 <= r1) goto L_0x0069
            java.lang.Object r3 = r3.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            r2.setPId(r3)
        L_0x0069:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wifi.background.wifi.filters.c.a(net.one97.paytm.wifi.background.wifi.filters.c, android.net.wifi.ScanResult):net.one97.paytm.wifi.models.WifiAdditional");
    }
}
