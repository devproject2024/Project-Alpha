package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import io.branch.referral.m;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f46572a = {m.d.RegisterInstall.getPath(), m.d.RegisterOpen.getPath(), m.d.CompletedAction.getPath(), m.d.ContentEvent.getPath(), m.d.TrackStandardEvent.getPath(), m.d.TrackCustomEvent.getPath()};

    /* renamed from: b  reason: collision with root package name */
    JSONObject f46573b;

    /* renamed from: c  reason: collision with root package name */
    String f46574c;

    /* renamed from: d  reason: collision with root package name */
    protected final q f46575d;

    /* renamed from: e  reason: collision with root package name */
    long f46576e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46577f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f46578g = false;

    /* renamed from: h  reason: collision with root package name */
    private final Context f46579h;

    /* renamed from: i  reason: collision with root package name */
    private final Set<b> f46580i;

    public enum a {
        V1,
        V1_CPID,
        V1_LATD,
        V2
    }

    enum b {
        SDK_INIT_WAIT_LOCK,
        FB_APP_LINK_WAIT_LOCK,
        GAID_FETCH_WAIT_LOCK,
        INTENT_PENDING_WAIT_LOCK,
        STRONG_MATCH_PENDING_WAIT_LOCK,
        INSTALL_REFERRER_FETCH_WAIT_LOCK
    }

    public abstract void a(int i2, String str);

    public abstract void a(ag agVar, c cVar);

    public abstract boolean a();

    public abstract void b();

    public boolean c() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return false;
    }

    public void j() {
    }

    /* access modifiers changed from: protected */
    public boolean m() {
        return false;
    }

    public s(Context context, String str) {
        this.f46579h = context;
        this.f46574c = str;
        this.f46575d = q.a(context);
        this.f46573b = new JSONObject();
        this.f46580i = new HashSet();
    }

    protected s(String str, JSONObject jSONObject, Context context) {
        this.f46579h = context;
        this.f46574c = str;
        this.f46573b = jSONObject;
        this.f46575d = q.a(context);
        this.f46580i = new HashSet();
    }

    public String f() {
        return q.a() + this.f46574c;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.json.JSONObject r8) throws org.json.JSONException {
        /*
            r7 = this;
            java.lang.String r0 = "bnc_device_fingerprint_id"
            r7.f46573b = r8
            io.branch.referral.s$a r8 = r7.k()
            io.branch.referral.s$a r1 = io.branch.referral.s.a.V1
            r2 = 1
            if (r8 != r1) goto L_0x0165
            io.branch.referral.n r8 = io.branch.referral.n.a()
            org.json.JSONObject r0 = r7.f46573b
            io.branch.referral.ah$b r1 = r8.b()     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r3 = r1.f46437a     // Catch:{ JSONException -> 0x0164 }
            boolean r3 = io.branch.referral.n.a((java.lang.String) r3)     // Catch:{ JSONException -> 0x0164 }
            if (r3 != 0) goto L_0x0035
            io.branch.referral.m$a r3 = io.branch.referral.m.a.HardwareID     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r3 = r3.getKey()     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r4 = r1.f46437a     // Catch:{ JSONException -> 0x0164 }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x0164 }
            io.branch.referral.m$a r3 = io.branch.referral.m.a.IsHardwareIDReal     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r3 = r3.getKey()     // Catch:{ JSONException -> 0x0164 }
            boolean r1 = r1.f46438b     // Catch:{ JSONException -> 0x0164 }
            r0.put(r3, r1)     // Catch:{ JSONException -> 0x0164 }
        L_0x0035:
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ JSONException -> 0x0164 }
            boolean r3 = io.branch.referral.n.a((java.lang.String) r1)     // Catch:{ JSONException -> 0x0164 }
            if (r3 != 0) goto L_0x0046
            io.branch.referral.m$a r3 = io.branch.referral.m.a.Brand     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r3 = r3.getKey()     // Catch:{ JSONException -> 0x0164 }
            r0.put(r3, r1)     // Catch:{ JSONException -> 0x0164 }
        L_0x0046:
            java.lang.String r1 = android.os.Build.MODEL     // Catch:{ JSONException -> 0x0164 }
            boolean r3 = io.branch.referral.n.a((java.lang.String) r1)     // Catch:{ JSONException -> 0x0164 }
            if (r3 != 0) goto L_0x0057
            io.branch.referral.m$a r3 = io.branch.referral.m.a.Model     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r3 = r3.getKey()     // Catch:{ JSONException -> 0x0164 }
            r0.put(r3, r1)     // Catch:{ JSONException -> 0x0164 }
        L_0x0057:
            android.content.Context r1 = r8.f46549b     // Catch:{ JSONException -> 0x0164 }
            android.util.DisplayMetrics r1 = io.branch.referral.ah.f(r1)     // Catch:{ JSONException -> 0x0164 }
            io.branch.referral.m$a r3 = io.branch.referral.m.a.ScreenDpi     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r3 = r3.getKey()     // Catch:{ JSONException -> 0x0164 }
            int r4 = r1.densityDpi     // Catch:{ JSONException -> 0x0164 }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x0164 }
            io.branch.referral.m$a r3 = io.branch.referral.m.a.ScreenHeight     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r3 = r3.getKey()     // Catch:{ JSONException -> 0x0164 }
            int r4 = r1.heightPixels     // Catch:{ JSONException -> 0x0164 }
            r0.put(r3, r4)     // Catch:{ JSONException -> 0x0164 }
            io.branch.referral.m$a r3 = io.branch.referral.m.a.ScreenWidth     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r3 = r3.getKey()     // Catch:{ JSONException -> 0x0164 }
            int r1 = r1.widthPixels     // Catch:{ JSONException -> 0x0164 }
            r0.put(r3, r1)     // Catch:{ JSONException -> 0x0164 }
            io.branch.referral.m$a r1 = io.branch.referral.m.a.WiFi     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r1 = r1.getKey()     // Catch:{ JSONException -> 0x0164 }
            android.content.Context r3 = r8.f46549b     // Catch:{ JSONException -> 0x0164 }
            r4 = 0
            if (r3 == 0) goto L_0x00a9
            java.lang.String r5 = "android.permission.ACCESS_NETWORK_STATE"
            int r5 = r3.checkCallingOrSelfPermission(r5)     // Catch:{ JSONException -> 0x0164 }
            if (r5 != 0) goto L_0x00a9
            java.lang.String r5 = "connectivity"
            java.lang.Object r3 = r3.getSystemService(r5)     // Catch:{ JSONException -> 0x0164 }
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3     // Catch:{ JSONException -> 0x0164 }
            r5 = 0
            if (r3 == 0) goto L_0x00a0
            android.net.NetworkInfo r5 = r3.getNetworkInfo(r2)     // Catch:{ JSONException -> 0x0164 }
        L_0x00a0:
            if (r5 == 0) goto L_0x00a9
            boolean r3 = r5.isConnected()     // Catch:{ JSONException -> 0x0164 }
            if (r3 == 0) goto L_0x00a9
            r4 = 1
        L_0x00a9:
            r0.put(r1, r4)     // Catch:{ JSONException -> 0x0164 }
            io.branch.referral.m$a r1 = io.branch.referral.m.a.UIMode     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r1 = r1.getKey()     // Catch:{ JSONException -> 0x0164 }
            android.content.Context r2 = r8.f46549b     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r2 = io.branch.referral.ah.g(r2)     // Catch:{ JSONException -> 0x0164 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0164 }
            android.content.Context r1 = r8.f46549b     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r1 = io.branch.referral.ah.e(r1)     // Catch:{ JSONException -> 0x0164 }
            boolean r2 = io.branch.referral.n.a((java.lang.String) r1)     // Catch:{ JSONException -> 0x0164 }
            if (r2 != 0) goto L_0x00d0
            io.branch.referral.m$a r2 = io.branch.referral.m.a.OS     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r2 = r2.getKey()     // Catch:{ JSONException -> 0x0164 }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0164 }
        L_0x00d0:
            io.branch.referral.m$a r1 = io.branch.referral.m.a.APILevel     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r1 = r1.getKey()     // Catch:{ JSONException -> 0x0164 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ JSONException -> 0x0164 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0164 }
            r8.a(r7, r0)     // Catch:{ JSONException -> 0x0164 }
            io.branch.referral.j$a r1 = io.branch.referral.j.d()     // Catch:{ JSONException -> 0x0164 }
            if (r1 == 0) goto L_0x0102
            io.branch.referral.m$a r1 = io.branch.referral.m.a.PluginType     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r1 = r1.getKey()     // Catch:{ JSONException -> 0x0164 }
            io.branch.referral.j$a r2 = io.branch.referral.j.d()     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0164 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0164 }
            io.branch.referral.m$a r1 = io.branch.referral.m.a.PluginVersion     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r1 = r1.getKey()     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r2 = io.branch.referral.j.c()     // Catch:{ JSONException -> 0x0164 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0164 }
        L_0x0102:
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r1 = r1.getCountry()     // Catch:{ JSONException -> 0x0164 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0164 }
            if (r2 != 0) goto L_0x0119
            io.branch.referral.m$a r2 = io.branch.referral.m.a.Country     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r2 = r2.getKey()     // Catch:{ JSONException -> 0x0164 }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0164 }
        L_0x0119:
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r1 = r1.getLanguage()     // Catch:{ JSONException -> 0x0164 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0164 }
            if (r2 != 0) goto L_0x0130
            io.branch.referral.m$a r2 = io.branch.referral.m.a.Language     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r2 = r2.getKey()     // Catch:{ JSONException -> 0x0164 }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0164 }
        L_0x0130:
            java.lang.String r1 = io.branch.referral.ah.a()     // Catch:{ JSONException -> 0x0164 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0164 }
            if (r2 != 0) goto L_0x0143
            io.branch.referral.m$a r2 = io.branch.referral.m.a.LocalIP     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r2 = r2.getKey()     // Catch:{ JSONException -> 0x0164 }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0164 }
        L_0x0143:
            android.content.Context r1 = r8.f46549b     // Catch:{ JSONException -> 0x0164 }
            io.branch.referral.q r1 = io.branch.referral.q.a((android.content.Context) r1)     // Catch:{ JSONException -> 0x0164 }
            boolean r1 = r1.j()     // Catch:{ JSONException -> 0x0164 }
            if (r1 == 0) goto L_0x0164
            android.content.Context r8 = r8.f46549b     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r8 = io.branch.referral.ah.h(r8)     // Catch:{ JSONException -> 0x0164 }
            boolean r1 = io.branch.referral.n.a((java.lang.String) r8)     // Catch:{ JSONException -> 0x0164 }
            if (r1 != 0) goto L_0x0164
            io.branch.referral.m$c r1 = io.branch.referral.m.c.imei     // Catch:{ JSONException -> 0x0164 }
            java.lang.String r1 = r1.getKey()     // Catch:{ JSONException -> 0x0164 }
            r0.put(r1, r8)     // Catch:{ JSONException -> 0x0164 }
        L_0x0164:
            return
        L_0x0165:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0302 }
            r8.<init>()     // Catch:{ JSONException -> 0x0302 }
            org.json.JSONObject r1 = r7.f46573b     // Catch:{ JSONException -> 0x0302 }
            io.branch.referral.m$a r3 = io.branch.referral.m.a.UserData     // Catch:{ JSONException -> 0x0302 }
            java.lang.String r3 = r3.getKey()     // Catch:{ JSONException -> 0x0302 }
            r1.put(r3, r8)     // Catch:{ JSONException -> 0x0302 }
            io.branch.referral.n r1 = io.branch.referral.n.a()     // Catch:{ JSONException -> 0x0302 }
            android.content.Context r3 = r7.f46579h     // Catch:{ JSONException -> 0x0302 }
            io.branch.referral.q r4 = r7.f46575d     // Catch:{ JSONException -> 0x0302 }
            io.branch.referral.ah$b r5 = r1.b()     // Catch:{  }
            java.lang.String r6 = r5.f46437a     // Catch:{  }
            boolean r6 = io.branch.referral.n.a((java.lang.String) r6)     // Catch:{  }
            if (r6 != 0) goto L_0x0199
            boolean r6 = r5.f46438b     // Catch:{  }
            if (r6 == 0) goto L_0x0199
            io.branch.referral.m$a r2 = io.branch.referral.m.a.AndroidID     // Catch:{  }
            java.lang.String r2 = r2.getKey()     // Catch:{  }
            java.lang.String r5 = r5.f46437a     // Catch:{  }
            r8.put(r2, r5)     // Catch:{  }
            goto L_0x01a2
        L_0x0199:
            io.branch.referral.m$a r5 = io.branch.referral.m.a.UnidentifiedDevice     // Catch:{  }
            java.lang.String r5 = r5.getKey()     // Catch:{  }
            r8.put(r5, r2)     // Catch:{  }
        L_0x01a2:
            java.lang.String r2 = android.os.Build.MANUFACTURER     // Catch:{  }
            boolean r5 = io.branch.referral.n.a((java.lang.String) r2)     // Catch:{  }
            if (r5 != 0) goto L_0x01b3
            io.branch.referral.m$a r5 = io.branch.referral.m.a.Brand     // Catch:{  }
            java.lang.String r5 = r5.getKey()     // Catch:{  }
            r8.put(r5, r2)     // Catch:{  }
        L_0x01b3:
            java.lang.String r2 = android.os.Build.MODEL     // Catch:{  }
            boolean r5 = io.branch.referral.n.a((java.lang.String) r2)     // Catch:{  }
            if (r5 != 0) goto L_0x01c4
            io.branch.referral.m$a r5 = io.branch.referral.m.a.Model     // Catch:{  }
            java.lang.String r5 = r5.getKey()     // Catch:{  }
            r8.put(r5, r2)     // Catch:{  }
        L_0x01c4:
            android.content.Context r2 = r1.f46549b     // Catch:{  }
            android.util.DisplayMetrics r2 = io.branch.referral.ah.f(r2)     // Catch:{  }
            io.branch.referral.m$a r5 = io.branch.referral.m.a.ScreenDpi     // Catch:{  }
            java.lang.String r5 = r5.getKey()     // Catch:{  }
            int r6 = r2.densityDpi     // Catch:{  }
            r8.put(r5, r6)     // Catch:{  }
            io.branch.referral.m$a r5 = io.branch.referral.m.a.ScreenHeight     // Catch:{  }
            java.lang.String r5 = r5.getKey()     // Catch:{  }
            int r6 = r2.heightPixels     // Catch:{  }
            r8.put(r5, r6)     // Catch:{  }
            io.branch.referral.m$a r5 = io.branch.referral.m.a.ScreenWidth     // Catch:{  }
            java.lang.String r5 = r5.getKey()     // Catch:{  }
            int r2 = r2.widthPixels     // Catch:{  }
            r8.put(r5, r2)     // Catch:{  }
            android.content.Context r2 = r1.f46549b     // Catch:{  }
            java.lang.String r2 = io.branch.referral.ah.e(r2)     // Catch:{  }
            boolean r5 = io.branch.referral.n.a((java.lang.String) r2)     // Catch:{  }
            if (r5 != 0) goto L_0x0200
            io.branch.referral.m$a r5 = io.branch.referral.m.a.OS     // Catch:{  }
            java.lang.String r5 = r5.getKey()     // Catch:{  }
            r8.put(r5, r2)     // Catch:{  }
        L_0x0200:
            io.branch.referral.m$a r2 = io.branch.referral.m.a.APILevel     // Catch:{  }
            java.lang.String r2 = r2.getKey()     // Catch:{  }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{  }
            r8.put(r2, r5)     // Catch:{  }
            r1.a(r7, r8)     // Catch:{  }
            io.branch.referral.j$a r2 = io.branch.referral.j.d()     // Catch:{  }
            if (r2 == 0) goto L_0x0232
            io.branch.referral.m$a r2 = io.branch.referral.m.a.PluginType     // Catch:{  }
            java.lang.String r2 = r2.getKey()     // Catch:{  }
            io.branch.referral.j$a r5 = io.branch.referral.j.d()     // Catch:{  }
            java.lang.String r5 = r5.toString()     // Catch:{  }
            r8.put(r2, r5)     // Catch:{  }
            io.branch.referral.m$a r2 = io.branch.referral.m.a.PluginVersion     // Catch:{  }
            java.lang.String r2 = r2.getKey()     // Catch:{  }
            java.lang.String r5 = io.branch.referral.j.c()     // Catch:{  }
            r8.put(r2, r5)     // Catch:{  }
        L_0x0232:
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{  }
            java.lang.String r2 = r2.getCountry()     // Catch:{  }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{  }
            if (r5 != 0) goto L_0x0249
            io.branch.referral.m$a r5 = io.branch.referral.m.a.Country     // Catch:{  }
            java.lang.String r5 = r5.getKey()     // Catch:{  }
            r8.put(r5, r2)     // Catch:{  }
        L_0x0249:
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{  }
            java.lang.String r2 = r2.getLanguage()     // Catch:{  }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{  }
            if (r5 != 0) goto L_0x0260
            io.branch.referral.m$a r5 = io.branch.referral.m.a.Language     // Catch:{  }
            java.lang.String r5 = r5.getKey()     // Catch:{  }
            r8.put(r5, r2)     // Catch:{  }
        L_0x0260:
            java.lang.String r2 = io.branch.referral.ah.a()     // Catch:{  }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{  }
            if (r5 != 0) goto L_0x0273
            io.branch.referral.m$a r5 = io.branch.referral.m.a.LocalIP     // Catch:{  }
            java.lang.String r5 = r5.getKey()     // Catch:{  }
            r8.put(r5, r2)     // Catch:{  }
        L_0x0273:
            if (r4 == 0) goto L_0x02a1
            java.lang.String r2 = io.branch.referral.q.d(r0)     // Catch:{  }
            boolean r2 = io.branch.referral.n.a((java.lang.String) r2)     // Catch:{  }
            if (r2 != 0) goto L_0x028c
            io.branch.referral.m$a r2 = io.branch.referral.m.a.DeviceFingerprintID     // Catch:{  }
            java.lang.String r2 = r2.getKey()     // Catch:{  }
            java.lang.String r0 = io.branch.referral.q.d(r0)     // Catch:{  }
            r8.put(r2, r0)     // Catch:{  }
        L_0x028c:
            java.lang.String r0 = "bnc_identity"
            java.lang.String r0 = io.branch.referral.q.d(r0)     // Catch:{  }
            boolean r2 = io.branch.referral.n.a((java.lang.String) r0)     // Catch:{  }
            if (r2 != 0) goto L_0x02a1
            io.branch.referral.m$a r2 = io.branch.referral.m.a.DeveloperIdentity     // Catch:{  }
            java.lang.String r2 = r2.getKey()     // Catch:{  }
            r8.put(r2, r0)     // Catch:{  }
        L_0x02a1:
            if (r4 == 0) goto L_0x02be
            boolean r0 = r4.j()     // Catch:{  }
            if (r0 == 0) goto L_0x02be
            android.content.Context r0 = r1.f46549b     // Catch:{  }
            java.lang.String r0 = io.branch.referral.ah.h(r0)     // Catch:{  }
            boolean r2 = io.branch.referral.n.a((java.lang.String) r0)     // Catch:{  }
            if (r2 != 0) goto L_0x02be
            io.branch.referral.m$c r2 = io.branch.referral.m.c.imei     // Catch:{  }
            java.lang.String r2 = r2.getKey()     // Catch:{  }
            r8.put(r2, r0)     // Catch:{  }
        L_0x02be:
            io.branch.referral.m$a r0 = io.branch.referral.m.a.AppVersion     // Catch:{  }
            java.lang.String r0 = r0.getKey()     // Catch:{  }
            android.content.Context r1 = r1.f46549b     // Catch:{  }
            java.lang.String r1 = io.branch.referral.ah.a(r1)     // Catch:{  }
            r8.put(r0, r1)     // Catch:{  }
            io.branch.referral.m$a r0 = io.branch.referral.m.a.SDK     // Catch:{  }
            java.lang.String r0 = r0.getKey()     // Catch:{  }
            java.lang.String r1 = "android"
            r8.put(r0, r1)     // Catch:{  }
            io.branch.referral.m$a r0 = io.branch.referral.m.a.SdkVersion     // Catch:{  }
            java.lang.String r0 = r0.getKey()     // Catch:{  }
            java.lang.String r1 = "4.3.2"
            r8.put(r0, r1)     // Catch:{  }
            io.branch.referral.m$a r0 = io.branch.referral.m.a.UserAgent     // Catch:{  }
            java.lang.String r0 = r0.getKey()     // Catch:{  }
            java.lang.String r1 = io.branch.referral.n.b(r3)     // Catch:{  }
            r8.put(r0, r1)     // Catch:{  }
            boolean r0 = r7 instanceof io.branch.referral.v     // Catch:{  }
            if (r0 == 0) goto L_0x0302
            io.branch.referral.m$a r0 = io.branch.referral.m.a.LATDAttributionWindow     // Catch:{  }
            java.lang.String r0 = r0.getKey()     // Catch:{  }
            r1 = r7
            io.branch.referral.v r1 = (io.branch.referral.v) r1     // Catch:{  }
            int r1 = r1.f46601h     // Catch:{  }
            r8.put(r0, r1)     // Catch:{  }
        L_0x0302:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.s.a(org.json.JSONObject):void");
    }

    public final JSONObject a(ConcurrentHashMap<String, String> concurrentHashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f46573b != null) {
                JSONObject jSONObject2 = new JSONObject(this.f46573b.toString());
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
            if (concurrentHashMap.size() <= 0) {
                return jSONObject;
            }
            JSONObject jSONObject3 = new JSONObject();
            for (String next2 : concurrentHashMap.keySet()) {
                jSONObject3.put(next2, concurrentHashMap.get(next2));
                concurrentHashMap.remove(next2);
            }
            jSONObject.put(m.a.Branch_Instrumentation.getKey(), jSONObject3);
            return jSONObject;
        } catch (JSONException unused) {
            return jSONObject;
        } catch (ConcurrentModificationException unused2) {
            return this.f46573b;
        }
    }

    public final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("REQ_POST", this.f46573b);
            jSONObject.put("REQ_POST_PATH", this.f46574c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[Catch:{ JSONException -> 0x001f }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.branch.referral.s a(org.json.JSONObject r5, android.content.Context r6) {
        /*
            java.lang.String r0 = "REQ_POST_PATH"
            java.lang.String r1 = "REQ_POST"
            java.lang.String r2 = ""
            r3 = 0
            boolean r4 = r5.has(r1)     // Catch:{ JSONException -> 0x0012 }
            if (r4 == 0) goto L_0x0012
            org.json.JSONObject r1 = r5.getJSONObject(r1)     // Catch:{ JSONException -> 0x0012 }
            goto L_0x0013
        L_0x0012:
            r1 = r3
        L_0x0013:
            boolean r4 = r5.has(r0)     // Catch:{ JSONException -> 0x001f }
            if (r4 == 0) goto L_0x0020
            java.lang.String r5 = r5.getString(r0)     // Catch:{ JSONException -> 0x001f }
            r2 = r5
            goto L_0x0020
        L_0x001f:
        L_0x0020:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto L_0x00dc
            io.branch.referral.m$d r5 = io.branch.referral.m.d.CompletedAction
            java.lang.String r5 = r5.getPath()
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0039
            io.branch.referral.t r3 = new io.branch.referral.t
            r3.<init>(r2, r1, r6)
            goto L_0x00dc
        L_0x0039:
            io.branch.referral.m$d r5 = io.branch.referral.m.d.GetURL
            java.lang.String r5 = r5.getPath()
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x004c
            io.branch.referral.u r3 = new io.branch.referral.u
            r3.<init>(r2, r1, r6)
            goto L_0x00dc
        L_0x004c:
            io.branch.referral.m$d r5 = io.branch.referral.m.d.GetCreditHistory
            java.lang.String r5 = r5.getPath()
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x005f
            io.branch.referral.w r3 = new io.branch.referral.w
            r3.<init>(r2, r1, r6)
            goto L_0x00dc
        L_0x005f:
            io.branch.referral.m$d r5 = io.branch.referral.m.d.GetCredits
            java.lang.String r5 = r5.getPath()
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0071
            io.branch.referral.x r3 = new io.branch.referral.x
            r3.<init>(r2, r1, r6)
            goto L_0x00dc
        L_0x0071:
            io.branch.referral.m$d r5 = io.branch.referral.m.d.IdentifyUser
            java.lang.String r5 = r5.getPath()
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0083
            io.branch.referral.y r3 = new io.branch.referral.y
            r3.<init>(r2, r1, r6)
            goto L_0x00dc
        L_0x0083:
            io.branch.referral.m$d r5 = io.branch.referral.m.d.Logout
            java.lang.String r5 = r5.getPath()
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0095
            io.branch.referral.aa r3 = new io.branch.referral.aa
            r3.<init>(r2, r1, r6)
            goto L_0x00dc
        L_0x0095:
            io.branch.referral.m$d r5 = io.branch.referral.m.d.RedeemRewards
            java.lang.String r5 = r5.getPath()
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x00a7
            io.branch.referral.ac r3 = new io.branch.referral.ac
            r3.<init>(r2, r1, r6)
            goto L_0x00dc
        L_0x00a7:
            io.branch.referral.m$d r5 = io.branch.referral.m.d.RegisterClose
            java.lang.String r5 = r5.getPath()
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x00b9
            io.branch.referral.ad r3 = new io.branch.referral.ad
            r3.<init>(r2, r1, r6)
            goto L_0x00dc
        L_0x00b9:
            io.branch.referral.m$d r5 = io.branch.referral.m.d.RegisterInstall
            java.lang.String r5 = r5.getPath()
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x00cb
            io.branch.referral.ae r3 = new io.branch.referral.ae
            r3.<init>(r2, r1, r6)
            goto L_0x00dc
        L_0x00cb:
            io.branch.referral.m$d r5 = io.branch.referral.m.d.RegisterOpen
            java.lang.String r5 = r5.getPath()
            boolean r5 = r2.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x00dc
            io.branch.referral.af r3 = new io.branch.referral.af
            r3.<init>(r2, r1, r6)
        L_0x00dc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.s.a(org.json.JSONObject, android.content.Context):io.branch.referral.s");
    }

    static boolean b(JSONObject jSONObject) {
        return jSONObject.has(m.a.AndroidID.getKey()) || jSONObject.has(m.a.DeviceFingerprintID.getKey()) || jSONObject.has(m.c.imei.getKey());
    }

    static String c(JSONObject jSONObject) {
        String optString = jSONObject.optString(m.a.OS.getKey());
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (optString.toLowerCase().contains("amazon")) {
            return m.a.FireAdId.getKey();
        }
        return m.a.AAID.getKey();
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.f46580i.add(bVar);
        }
    }

    public final void b(b bVar) {
        this.f46580i.remove(bVar);
    }

    public final boolean i() {
        return this.f46580i.size() > 0;
    }

    public a k() {
        return a.V1;
    }

    public final void l() {
        q.h("Requested operation cannot be completed since tracking is disabled [" + this.f46574c + "]");
        a(-117, "");
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        boolean e2;
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator<String> keys = this.f46575d.f46567a.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, this.f46575d.f46567a.get(next));
            }
            JSONObject optJSONObject = this.f46573b.optJSONObject(m.a.Metadata.getKey());
            if (optJSONObject != null) {
                Iterator<String> keys2 = optJSONObject.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    jSONObject.put(next2, optJSONObject.get(next2));
                }
            }
            if ((this instanceof ae) && this.f46575d.f46568b.length() > 0) {
                Iterator<String> keys3 = this.f46575d.f46568b.keys();
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    this.f46573b.putOpt(next3, this.f46575d.f46568b.get(next3));
                }
            }
            this.f46573b.put(m.a.Metadata.getKey(), jSONObject);
        } catch (JSONException unused) {
            q.h("Could not merge metadata, ignoring user metadata.");
        }
        if (e()) {
            JSONObject optJSONObject2 = k() == a.V1 ? this.f46573b : this.f46573b.optJSONObject(m.a.UserData.getKey());
            if (optJSONObject2 != null && (e2 = q.e("bnc_limit_facebook_tracking"))) {
                try {
                    optJSONObject2.putOpt(m.a.limitFacebookTracking.getKey(), Boolean.valueOf(e2));
                } catch (JSONException unused2) {
                }
            }
        }
    }
}
