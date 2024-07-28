package net.one97.paytm.h5paytmsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import kotlin.o;
import net.one97.paytm.h5paytmsdk.R;
import net.one97.paytm.h5paytmsdk.b.ad;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class PaytmH5Activity extends H5Activity {
    public static final f o = new f((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final m f17103a = new m();

    /* renamed from: b  reason: collision with root package name */
    public final d f17104b = new d();

    /* renamed from: c  reason: collision with root package name */
    public final h f17105c = new h();

    /* renamed from: d  reason: collision with root package name */
    public final g f17106d = new g();

    /* renamed from: e  reason: collision with root package name */
    public final a f17107e = new a();

    /* renamed from: f  reason: collision with root package name */
    public final j f17108f = new j();

    /* renamed from: g  reason: collision with root package name */
    public final b f17109g = new b();

    /* renamed from: h  reason: collision with root package name */
    public final l f17110h = new l();

    /* renamed from: i  reason: collision with root package name */
    public final e f17111i = new e();
    public final i j = new i();
    public ad k;
    public final k l = new k();
    public boolean m;
    public boolean n = true;
    private final Map<Integer, String> p = new LinkedHashMap();
    private String q;
    /* access modifiers changed from: private */
    public String r = "";
    /* access modifiers changed from: private */
    public String s = "";
    private String t = "";
    private String u = "";
    private String v = "";

    public static final class a extends c {
    }

    public static final class b extends c {
    }

    public static final class d extends c {
    }

    public static final class e extends c {
    }

    public static final class g extends c {
    }

    public static final class h extends c {
    }

    public static final class i extends c {
    }

    public static final class j extends c {
    }

    public static final class k extends c {
    }

    public static final class l extends c {
    }

    public static final class m extends c {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r0 = r0.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            android.content.Intent r0 = r8.getIntent()
            java.lang.String r1 = "appUniqueId"
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0016
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.getString(r1)
            if (r0 != 0) goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            r8.q = r0
            android.content.Intent r0 = r8.getIntent()
            java.lang.String r3 = "paytmShowTitleBar"
            r4 = 0
            if (r0 == 0) goto L_0x002d
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x002d
            boolean r0 = r0.containsKey(r3)
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            if (r0 == 0) goto L_0x0041
            android.content.Intent r0 = r8.getIntent()
            if (r0 == 0) goto L_0x0041
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0041
            boolean r0 = r0.getBoolean(r3)
            goto L_0x0042
        L_0x0041:
            r0 = 1
        L_0x0042:
            r8.n = r0
            android.content.Intent r0 = r8.getIntent()
            if (r0 == 0) goto L_0x0058
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0058
            java.lang.String r3 = "paytmChangeStatusBarColor"
            java.lang.String r0 = r0.getString(r3)
            if (r0 != 0) goto L_0x0059
        L_0x0058:
            r0 = r2
        L_0x0059:
            r8.r = r0
            android.content.Intent r0 = r8.getIntent()
            if (r0 == 0) goto L_0x006f
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x006f
            java.lang.String r3 = "paytmChangeBackButtonColor"
            java.lang.String r0 = r0.getString(r3)
            if (r0 != 0) goto L_0x0070
        L_0x006f:
            r0 = r2
        L_0x0070:
            r8.s = r0
            android.content.Intent r0 = r8.getIntent()
            if (r0 == 0) goto L_0x0086
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x0086
            java.lang.String r3 = "paytmChangeCrossButtonColor"
            java.lang.String r0 = r0.getString(r3)
            if (r0 != 0) goto L_0x0087
        L_0x0086:
            r0 = r2
        L_0x0087:
            r8.t = r0
            android.content.Intent r0 = r8.getIntent()
            if (r0 == 0) goto L_0x009b
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x009b
            java.lang.String r3 = "overrideDefaultLoadingCancelBehaviour"
            boolean r4 = r0.getBoolean(r3)
        L_0x009b:
            r8.m = r4
            android.content.Intent r0 = r8.getIntent()
            if (r0 == 0) goto L_0x00ac
            android.os.Bundle r0 = r0.getExtras()
            if (r0 == 0) goto L_0x00ac
            r0.remove(r1)
        L_0x00ac:
            net.one97.paytm.h5paytmsdk.PaytmH5Manager r0 = net.one97.paytm.h5paytmsdk.PaytmH5Manager.INSTANCE
            boolean r0 = r0.isDebug$h5paytmsdk_debug()
            if (r0 != 0) goto L_0x00bd
            android.view.Window r0 = r8.getWindow()
            r3 = 8192(0x2000, float:1.14794E-41)
            r0.setFlags(r3, r3)
        L_0x00bd:
            super.onCreate(r9)
            r9 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r9 = r8.findViewById(r9)     // Catch:{ Exception -> 0x00da }
            if (r9 == 0) goto L_0x00de
            android.view.ViewTreeObserver r9 = r9.getViewTreeObserver()     // Catch:{ Exception -> 0x00da }
            if (r9 == 0) goto L_0x00de
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$n r0 = new net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$n     // Catch:{ Exception -> 0x00da }
            r0.<init>(r8)     // Catch:{ Exception -> 0x00da }
            android.view.ViewTreeObserver$OnPreDrawListener r0 = (android.view.ViewTreeObserver.OnPreDrawListener) r0     // Catch:{ Exception -> 0x00da }
            r9.addOnPreDrawListener(r0)     // Catch:{ Exception -> 0x00da }
            goto L_0x00de
        L_0x00da:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00de:
            android.content.Intent r9 = r8.getIntent()
            if (r9 == 0) goto L_0x00f2
            android.os.Bundle r9 = r9.getExtras()
            if (r9 == 0) goto L_0x00f2
            java.lang.String r0 = "app_name"
            java.lang.String r9 = r9.getString(r0)
            if (r9 != 0) goto L_0x00f3
        L_0x00f2:
            r9 = r2
        L_0x00f3:
            r8.u = r9
            android.content.Intent r9 = r8.getIntent()
            if (r9 == 0) goto L_0x0109
            android.os.Bundle r9 = r9.getExtras()
            if (r9 == 0) goto L_0x0109
            java.lang.String r0 = "category"
            java.lang.String r9 = r9.getString(r0)
            if (r9 != 0) goto L_0x010a
        L_0x0109:
            r9 = r2
        L_0x010a:
            r8.v = r9
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            r6 = r9
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r9 = "event_category"
            java.lang.String r0 = "mini_app_opened"
            r6.put(r9, r0)
            java.lang.String r9 = "event_action"
            java.lang.String r0 = "deeplink"
            r6.put(r9, r0)
            java.lang.String r9 = r8.u
            java.lang.String r0 = "event_label"
            r6.put(r0, r9)
            java.lang.String r9 = r8.v
            java.lang.String r0 = "event_label2"
            r6.put(r0, r9)
            java.lang.String r9 = r8.q
            if (r9 != 0) goto L_0x0137
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0137:
            java.lang.String r0 = "event_label3"
            r6.put(r0, r9)
            com.alipay.mobile.nebula.provider.H5ProviderManager r9 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            r0 = 0
            if (r9 == 0) goto L_0x014e
            java.lang.Class<net.one97.paytm.h5paytmsdk.c.h> r2 = net.one97.paytm.h5paytmsdk.c.h.class
            java.lang.String r2 = r2.getName()
            java.lang.Object r9 = r9.getProvider(r2)
            goto L_0x014f
        L_0x014e:
            r9 = r0
        L_0x014f:
            r2 = r9
            net.one97.paytm.h5paytmsdk.c.h r2 = (net.one97.paytm.h5paytmsdk.c.h) r2
            if (r2 != 0) goto L_0x0155
            return
        L_0x0155:
            com.alipay.mobile.nebula.provider.H5ProviderManager r9 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            if (r9 == 0) goto L_0x0165
            java.lang.Class<net.one97.paytm.h5paytmsdk.c.ae> r0 = net.one97.paytm.h5paytmsdk.c.ae.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = r9.getProvider(r0)
        L_0x0165:
            net.one97.paytm.h5paytmsdk.c.ae r0 = (net.one97.paytm.h5paytmsdk.c.ae) r0
            if (r0 != 0) goto L_0x016a
            return
        L_0x016a:
            java.lang.String r9 = r8.q
            if (r9 != 0) goto L_0x0171
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0171:
            java.lang.String r9 = r0.a(r9)
            if (r9 != 0) goto L_0x017e
            java.lang.String r9 = r8.q
            if (r9 != 0) goto L_0x017e
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x017e:
            r4 = r9
            r3 = r8
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r7 = r8.q
            if (r7 != 0) goto L_0x0189
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0189:
            java.lang.String r5 = "custom_event"
            r2.a(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.onCreate(android.os.Bundle):void");
    }

    public static final class n implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmH5Activity f17112a;

        n(PaytmH5Activity paytmH5Activity) {
            this.f17112a = paytmH5Activity;
        }

        public final boolean onPreDraw() {
            ViewTreeObserver viewTreeObserver;
            if (!this.f17112a.n) {
                this.f17112a.b();
            }
            if (!TextUtils.isEmpty(this.f17112a.r)) {
                PaytmH5Activity paytmH5Activity = this.f17112a;
                paytmH5Activity.a(paytmH5Activity.r);
            }
            if (!TextUtils.isEmpty(this.f17112a.s)) {
                PaytmH5Activity paytmH5Activity2 = this.f17112a;
                paytmH5Activity2.b(paytmH5Activity2.s);
            }
            View findViewById = this.f17112a.findViewById(16908290);
            if (findViewById == null || (viewTreeObserver = findViewById.getViewTreeObserver()) == null) {
                return true;
            }
            viewTreeObserver.removeOnPreDrawListener(this);
            return true;
        }
    }

    public void onResume() {
        super.onResume();
        Context context = this;
        com.google.android.play.core.splitcompat.a.a(context);
        com.google.android.play.core.splitcompat.a.b(context);
        String str = this.q;
        if (str == null) {
            kotlin.g.b.k.a("appUniqueId");
        }
        net.one97.paytm.h5paytmsdk.a.d.a(str);
        String str2 = this.q;
        if (str2 == null) {
            kotlin.g.b.k.a("appUniqueId");
        }
        net.one97.paytm.h5paytmsdk.a.d.c(str2);
    }

    public void onPause() {
        super.onPause();
        String str = this.q;
        if (str == null) {
            kotlin.g.b.k.a("appUniqueId");
        }
        net.one97.paytm.h5paytmsdk.a.d.b(str);
        String str2 = this.q;
        if (str2 == null) {
            kotlin.g.b.k.a("appUniqueId");
        }
        net.one97.paytm.h5paytmsdk.a.d.d(str2);
    }

    public final String a() {
        String str = this.q;
        if (str == null) {
            kotlin.g.b.k.a("appUniqueId");
        }
        return str;
    }

    public final void a(String[] strArr) {
        kotlin.g.b.k.c(strArr, "permissionToRequest");
        androidx.core.app.a.a(this, strArr, 101);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0129, code lost:
        r0 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r10, int r11, android.content.Intent r12) {
        /*
            r9 = this;
            super.onActivityResult(r10, r11, r12)
            com.alipay.mobile.nebula.provider.H5ProviderManager r0 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            r1 = 0
            if (r0 == 0) goto L_0x0015
            java.lang.Class<net.one97.paytm.h5paytmsdk.c.e> r2 = net.one97.paytm.h5paytmsdk.c.e.class
            java.lang.String r2 = r2.getName()
            java.lang.Object r0 = r0.getProvider(r2)
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            net.one97.paytm.h5paytmsdk.c.e r0 = (net.one97.paytm.h5paytmsdk.c.e) r0
            if (r0 == 0) goto L_0x0022
            r2 = r9
            android.content.Context r2 = (android.content.Context) r2
            java.lang.Object r0 = r0.a(r2, r10, r11, r12)
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.util.Map<java.lang.Integer, java.lang.String> r2 = r9.p
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0039
            net.one97.paytm.h5paytmsdk.b.ad r2 = r9.k
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = r2.f16978c
            goto L_0x0039
        L_0x0038:
            r2 = r1
        L_0x0039:
            java.lang.String r3 = "paytmPayment"
            if (r2 != 0) goto L_0x003f
            goto L_0x0143
        L_0x003f:
            int r4 = r2.hashCode()
            switch(r4) {
                case -582107739: goto L_0x0138;
                case -567028024: goto L_0x012b;
                case -102536757: goto L_0x011d;
                case 600163783: goto L_0x00ff;
                case 677282122: goto L_0x00f2;
                case 700206469: goto L_0x00e3;
                case 1306974590: goto L_0x0056;
                case 1756156877: goto L_0x0048;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x0143
        L_0x0048:
            java.lang.String r12 = "paytmNavigateTo"
            boolean r12 = r2.equals(r12)
            if (r12 == 0) goto L_0x0143
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$j r12 = r9.f17108f
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$c r12 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.c) r12
            goto L_0x0147
        L_0x0056:
            java.lang.String r4 = "paytmPickFile"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0143
            java.util.ArrayList r0 = new java.util.ArrayList
            r4 = 10
            r0.<init>(r4)
            if (r12 == 0) goto L_0x006b
            android.content.ClipData r1 = r12.getClipData()
        L_0x006b:
            r4 = 0
            if (r1 != 0) goto L_0x0070
            r1 = 0
            goto L_0x0071
        L_0x0070:
            r1 = 1
        L_0x0071:
            java.lang.String r5 = ""
            if (r1 == 0) goto L_0x00c7
            if (r12 == 0) goto L_0x00de
            android.content.ClipData r12 = r12.getClipData()
            if (r12 == 0) goto L_0x00de
            int r1 = r12.getItemCount()
        L_0x0081:
            if (r4 >= r1) goto L_0x00de
            android.content.ClipData$Item r6 = r12.getItemAt(r4)
            java.lang.String r7 = "it.getItemAt(i)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.net.Uri r6 = r6.getUri()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "image"
            r7.<init>(r8)
            r7.append(r4)
            java.lang.String r8 = "="
            r7.append(r8)
            java.lang.String r8 = r6.toString()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.io.PrintStream r8 = java.lang.System.out
            r8.println(r7)
            net.one97.paytm.h5paytmsdk.d.d r7 = net.one97.paytm.h5paytmsdk.d.d.f17099a
            r7 = r9
            android.content.Context r7 = (android.content.Context) r7
            java.lang.String r8 = "uri"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            java.lang.String r6 = net.one97.paytm.h5paytmsdk.d.d.a(r7, r6)
            if (r6 != 0) goto L_0x00c1
            r6 = r5
        L_0x00c1:
            r0.add(r6)
            int r4 = r4 + 1
            goto L_0x0081
        L_0x00c7:
            if (r12 == 0) goto L_0x00de
            android.net.Uri r12 = r12.getData()
            if (r12 == 0) goto L_0x00de
            net.one97.paytm.h5paytmsdk.d.d r1 = net.one97.paytm.h5paytmsdk.d.d.f17099a
            r1 = r9
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r12 = net.one97.paytm.h5paytmsdk.d.d.a(r1, r12)
            if (r12 != 0) goto L_0x00db
            r12 = r5
        L_0x00db:
            r0.add(r12)
        L_0x00de:
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$g r12 = r9.f17106d
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$c r12 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.c) r12
            goto L_0x0147
        L_0x00e3:
            java.lang.String r12 = "paytmCaptureImageFromCamera"
            boolean r12 = r2.equals(r12)
            if (r12 == 0) goto L_0x0143
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$d r12 = r9.f17104b
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$c r12 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.c) r12
            goto L_0x0129
        L_0x00f2:
            java.lang.String r12 = "paytmGetLocation"
            boolean r12 = r2.equals(r12)
            if (r12 == 0) goto L_0x0143
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$i r12 = r9.j
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$c r12 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.c) r12
            goto L_0x0147
        L_0x00ff:
            java.lang.String r4 = "paytmOpenGallery"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0143
            if (r12 == 0) goto L_0x0118
            android.net.Uri r12 = r12.getData()
            if (r12 == 0) goto L_0x0118
            net.one97.paytm.h5paytmsdk.d.d r0 = net.one97.paytm.h5paytmsdk.d.d.f17099a
            r0 = r9
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = net.one97.paytm.h5paytmsdk.d.d.a(r0, r12)
        L_0x0118:
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$h r12 = r9.f17105c
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$c r12 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.c) r12
            goto L_0x0129
        L_0x011d:
            java.lang.String r12 = "paytmAuthenticateOnDevice"
            boolean r12 = r2.equals(r12)
            if (r12 == 0) goto L_0x0143
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$b r12 = r9.f17109g
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$c r12 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.c) r12
        L_0x0129:
            r0 = r1
            goto L_0x0147
        L_0x012b:
            java.lang.String r12 = "paytmLogin"
            boolean r12 = r2.equals(r12)
            if (r12 == 0) goto L_0x0143
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$a r12 = r9.f17107e
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$c r12 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.c) r12
            goto L_0x0147
        L_0x0138:
            boolean r12 = r2.equals(r3)
            if (r12 == 0) goto L_0x0143
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$l r12 = r9.f17110h
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$c r12 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.c) r12
            goto L_0x0147
        L_0x0143:
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$e r12 = r9.f17111i
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$c r12 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.c) r12
        L_0x0147:
            r1 = -1
            if (r11 == r1) goto L_0x015b
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x015b
            java.lang.String r3 = "paytmAddMoney"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0159
            goto L_0x015b
        L_0x0159:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L_0x015b:
            if (r11 != r1) goto L_0x0161
            r12.b(r0)
            goto L_0x0164
        L_0x0161:
            r12.a(r0)
        L_0x0164:
            java.util.Map<java.lang.Integer, java.lang.String> r11 = r9.p
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r11.remove(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        if (i2 == 101) {
            if (!(iArr.length == 0)) {
                this.f17103a.b(new o(strArr, iArr));
            } else {
                this.f17103a.a(Boolean.FALSE);
            }
        }
    }

    public final void a(Intent intent, int i2, String str) {
        kotlin.g.b.k.c(str, "actionName");
        this.p.put(Integer.valueOf(i2), str);
        super.startActivityForResult(intent, i2);
    }

    public final void b() {
        com.alipay.iap.android.common.b.c.c();
        this.n = false;
        View findViewById = findViewById(R.id.h5_title_bar_layout);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public final boolean a(String str) {
        kotlin.g.b.k.c(str, CLConstants.FIELD_FONT_COLOR);
        try {
            View findViewById = findViewById(R.id.h5_status_bar_adjust_view);
            if (findViewById != null) {
                findViewById.setBackgroundColor(Color.parseColor(str));
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean b(String str) {
        kotlin.g.b.k.c(str, CLConstants.FIELD_FONT_COLOR);
        try {
            ImageButton imageButton = (ImageButton) findViewById(R.id.h5_tv_nav_back);
            if (imageButton != null) {
                imageButton.setColorFilter(Color.parseColor(str), PorterDuff.Mode.SRC_ATOP);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void attachBaseContext(Context context) {
        kotlin.g.b.k.c(context, "newBase");
        super.attachBaseContext(context);
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }

    public void onStop() {
        super.onStop();
        this.l.b("onDestroy");
    }

    public static abstract class c extends Observable {
        public final void a(Object obj) {
            setChanged();
            notifyObservers(obj);
        }

        public final void b(Object obj) {
            setChanged();
            notifyObservers(obj);
        }
    }

    public static final class f {
        private f() {
        }

        public /* synthetic */ f(byte b2) {
            this();
        }
    }
}
