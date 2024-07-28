package com.paytm.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.view.WindowManager;
import com.paytm.ads.a.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f40895a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static e f40896c;

    /* renamed from: b  reason: collision with root package name */
    final HashMap<String, WeakReference<PaytmAdView>> f40897b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Handler f40898d;

    /* renamed from: e  reason: collision with root package name */
    private final float f40899e;

    /* renamed from: f  reason: collision with root package name */
    private final float f40900f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f40901g;

    /* renamed from: h  reason: collision with root package name */
    private float f40902h;

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<String, Boolean> f40903i;
    private final Runnable j;
    private final Context k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static e a(Context context) {
            k.c(context, "context");
            if (e.f40896c == null) {
                e.f40896c = new e(context, (byte) 0);
            }
            return e.f40896c;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final float f40904a;

        /* renamed from: b  reason: collision with root package name */
        final float f40905b;

        public b(float f2, float f3) {
            this.f40904a = f2;
            this.f40905b = f3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Float.compare(this.f40904a, bVar.f40904a) == 0 && Float.compare(this.f40905b, bVar.f40905b) == 0;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.f40904a) * 31) + Float.floatToIntBits(this.f40905b);
        }

        public final String toString() {
            return "Size(width=" + this.f40904a + ", height=" + this.f40905b + ")";
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f40906a;

        c(e eVar) {
            this.f40906a = eVar;
        }

        public final void run() {
            if (this.f40906a.f40898d != null) {
                e.b(this.f40906a);
            }
        }
    }

    public /* synthetic */ e(Context context, byte b2) {
        this(context);
    }

    private final float a(int i2) {
        if (i2 == 0) {
            return 0.0f;
        }
        return ((float) i2) / this.f40902h;
    }

    private final b b() {
        float f2 = 360.0f;
        float f3 = 640.0f;
        try {
            Object systemService = this.k.getSystemService("window");
            if (systemService != null) {
                WindowManager windowManager = (WindowManager) systemService;
                if (Build.VERSION.SDK_INT >= 17) {
                    Point point = new Point(0, 0);
                    windowManager.getDefaultDisplay().getRealSize(point);
                    f2 = a(point.x);
                    f3 = a(point.y);
                }
                return new b(f2, f3);
            }
            throw new u("null cannot be cast to non-null type android.view.WindowManager");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (kotlin.g.b.k.a((java.lang.Object) r0.get(r1), (java.lang.Object) java.lang.Boolean.TRUE) == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.paytm.ads.PaytmAdView r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r4, r0)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = r4.getAdId$paytm_ad_sdk_release()     // Catch:{ Exception -> 0x007b }
            if (r0 == 0) goto L_0x0079
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r3.f40903i     // Catch:{ Exception -> 0x007b }
            java.lang.String r1 = r4.getAdId$paytm_ad_sdk_release()     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x0018
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x007b }
        L_0x0018:
            boolean r0 = r0.containsKey(r1)     // Catch:{ Exception -> 0x007b }
            if (r0 == 0) goto L_0x0037
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r3.f40903i     // Catch:{ Exception -> 0x007b }
            java.lang.String r1 = r4.getAdId$paytm_ad_sdk_release()     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x0029
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x007b }
        L_0x0029:
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x007b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x007b }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x007b }
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x007b }
            if (r0 != 0) goto L_0x0079
        L_0x0037:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x007b }
            r4.setTime$paytm_ad_sdk_release(r0)     // Catch:{ Exception -> 0x007b }
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = r3.f40903i     // Catch:{ Exception -> 0x007b }
            java.lang.String r1 = r4.getAdId$paytm_ad_sdk_release()     // Catch:{ Exception -> 0x007b }
            if (r1 != 0) goto L_0x0049
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x007b }
        L_0x0049:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x007b }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x007b }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x007b }
            r0.<init>(r4)     // Catch:{ Exception -> 0x007b }
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<com.paytm.ads.PaytmAdView>> r1 = r3.f40897b     // Catch:{ Exception -> 0x007b }
            java.lang.String r4 = r4.getAdId$paytm_ad_sdk_release()     // Catch:{ Exception -> 0x007b }
            if (r4 != 0) goto L_0x005e
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x007b }
        L_0x005e:
            r1.put(r4, r0)     // Catch:{ Exception -> 0x007b }
            android.os.Handler r4 = r3.f40898d     // Catch:{ Exception -> 0x007b }
            if (r4 != 0) goto L_0x007f
            android.os.Handler r4 = new android.os.Handler     // Catch:{ Exception -> 0x007b }
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x007b }
            r4.<init>(r0)     // Catch:{ Exception -> 0x007b }
            r3.f40898d = r4     // Catch:{ Exception -> 0x007b }
            java.lang.Runnable r0 = r3.j     // Catch:{ Exception -> 0x007b }
            r1 = 523(0x20b, double:2.584E-321)
            r4.postDelayed(r0, r1)     // Catch:{ Exception -> 0x007b }
            monitor-exit(r3)
            return
        L_0x0079:
            monitor-exit(r3)
            return
        L_0x007b:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0081 }
        L_0x007f:
            monitor-exit(r3)
            return
        L_0x0081:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.ads.e.a(com.paytm.ads.PaytmAdView):void");
    }

    private e(Context context) {
        this.k = context;
        this.f40901g = new int[2];
        Resources system = Resources.getSystem();
        k.a((Object) system, "Resources.getSystem()");
        this.f40902h = system.getDisplayMetrics().density;
        this.f40897b = new HashMap<>();
        this.f40903i = new HashMap<>();
        this.j = new c(this);
        b b2 = b();
        this.f40899e = b2.f40904a;
        this.f40900f = b2.f40905b;
    }

    public static final /* synthetic */ void b(e eVar) {
        String str;
        String str2;
        String str3;
        String str4;
        a.a.a.a.a.b.b bVar;
        try {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : eVar.f40897b.entrySet()) {
                String str5 = (String) next.getKey();
                WeakReference weakReference = (WeakReference) next.getValue();
                PaytmAdView paytmAdView = (PaytmAdView) weakReference.get();
                if (paytmAdView == null) {
                    arrayList.add(str5);
                }
                if (paytmAdView != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    PaytmAdView paytmAdView2 = (PaytmAdView) weakReference.get();
                    if (currentTimeMillis - (paytmAdView2 != null ? paytmAdView2.getTime$paytm_ad_sdk_release() : 0) < 500) {
                    }
                }
                if (paytmAdView != null) {
                    paytmAdView.getLocationOnScreen(eVar.f40901g);
                }
                float a2 = eVar.a(eVar.f40901g[0]);
                float a3 = eVar.a(eVar.f40901g[1]);
                if (!(a2 == 0.0f && a3 == 0.0f) && a2 >= 0.0f && a2 < eVar.f40899e && a3 >= 0.0f && a3 < eVar.f40900f) {
                    String str6 = null;
                    if (paytmAdView != null) {
                        try {
                            if (!paytmAdView.getAdVerificationResources().isEmpty()) {
                                b.C0681b bVar2 = com.paytm.ads.a.b.f40870a;
                                com.paytm.ads.a.b a4 = com.paytm.ads.a.b.f40871b;
                                com.paytm.ads.d.a a5 = a4 != null ? a4.a(b.a.NATIVE, paytmAdView.getAdVerificationResources(), paytmAdView.f40853b) : null;
                                paytmAdView.f40852a = a5;
                                if (a5 != null) {
                                    k.c(paytmAdView, "adView");
                                    a.a.a.a.a.b.b bVar3 = a5.f40892c;
                                    if (bVar3 != null) {
                                        bVar3.a(paytmAdView);
                                        x xVar = x.f47997a;
                                    }
                                }
                                StringBuilder sb = new StringBuilder("[AdEvent][omid] createSession() -> omid.start() adSessionId: ");
                                com.paytm.ads.d.a aVar = paytmAdView.f40852a;
                                if (aVar != null) {
                                    str = aVar.f40891b;
                                } else {
                                    str = null;
                                }
                                sb.append(str);
                                timber.log.a.a(sb.toString(), new Object[0]);
                                com.paytm.ads.d.a aVar2 = paytmAdView.f40852a;
                                if (!(aVar2 == null || (bVar = aVar2.f40892c) == null)) {
                                    bVar.a();
                                    x xVar2 = x.f47997a;
                                }
                                paytmAdView.f40855d = true;
                                StringBuilder sb2 = new StringBuilder("Session started for adSession id    ");
                                com.paytm.ads.d.a aVar3 = paytmAdView.f40852a;
                                if (aVar3 != null) {
                                    str2 = aVar3.f40891b;
                                } else {
                                    str2 = null;
                                }
                                sb2.append(str2);
                                try {
                                    com.paytm.ads.d.a aVar4 = paytmAdView.f40852a;
                                    if (!(aVar4 == null || aVar4.f40890a || paytmAdView.f40852a == null)) {
                                        StringBuilder sb3 = new StringBuilder("impression fired for    ");
                                        com.paytm.ads.d.a aVar5 = paytmAdView.f40852a;
                                        if (aVar5 != null) {
                                            str3 = aVar5.f40891b;
                                        } else {
                                            str3 = null;
                                        }
                                        sb3.append(str3);
                                        com.paytm.ads.d.a aVar6 = paytmAdView.f40852a;
                                        if (aVar6 != null) {
                                            if (aVar6.f40892c == null || aVar6.f40890a) {
                                                new com.paytm.ads.b.a("Duplicate impression").printStackTrace();
                                            } else {
                                                aVar6.f40890a = true;
                                                timber.log.a.a("[AdEvent][omid] impressionOccurred() adSessionId: " + aVar6.f40891b, new Object[0]);
                                                a.a.a.a.a.b.a.a(aVar6.f40892c).a();
                                            }
                                        }
                                        if (!(paytmAdView.f40854c == null || (str4 = paytmAdView.f40854c) == null || p.a(str4))) {
                                            d dVar = d.f40887a;
                                            String str7 = paytmAdView.f40854c;
                                            if (str7 == null) {
                                                k.a();
                                            }
                                            d.b(str7);
                                        }
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if ((!paytmAdView.getPixelUrls().isEmpty()) && (true ^ paytmAdView.getPixelUrls().isEmpty())) {
                                Context context = paytmAdView.getContext();
                                k.a((Object) context, "context");
                                Context applicationContext = context.getApplicationContext();
                                k.a((Object) applicationContext, "context.applicationContext");
                                c cVar = new c(applicationContext);
                                paytmAdView.f40857f = cVar;
                                ArrayList<String> pixelUrls = paytmAdView.getPixelUrls();
                                k.c(pixelUrls, "urlList");
                                try {
                                    cVar.f40879a.addAll(pixelUrls);
                                    cVar.a();
                                } catch (Exception e3) {
                                    new StringBuilder(" couldn't load the url:  ").append(e3.getMessage());
                                }
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    HashMap<String, Boolean> hashMap = eVar.f40903i;
                    if (paytmAdView != null) {
                        str6 = paytmAdView.getAdId$paytm_ad_sdk_release();
                    }
                    if (str6 == null) {
                        k.a();
                    }
                    hashMap.put(str6, Boolean.TRUE);
                    arrayList.add(str5);
                }
            }
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    eVar.f40897b.remove((String) it2.next());
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        Handler handler = eVar.f40898d;
        if (handler != null) {
            handler.postDelayed(eVar.j, 473);
        }
    }
}
