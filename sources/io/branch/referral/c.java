package io.branch.referral;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.branch.referral.ah;
import io.branch.referral.i;
import io.branch.referral.k;
import io.branch.referral.m;
import io.branch.referral.p;
import io.branch.referral.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements ah.a, k.b, p.a {
    private static boolean A = false;
    private static boolean B = false;
    private static String D = "app.link";
    private static int E = 2500;
    private static final String[] F = {"extra_launch_uri", "branch_intent"};
    private static boolean K = true;

    /* renamed from: b  reason: collision with root package name */
    static boolean f46464b = false;

    /* renamed from: c  reason: collision with root package name */
    static boolean f46465c = true;

    /* renamed from: d  reason: collision with root package name */
    static long f46466d = 1500;
    private static boolean s = false;
    private static boolean t = false;
    private static boolean u = false;
    /* access modifiers changed from: private */
    public static c v;
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, String> C;
    /* access modifiers changed from: private */
    public CountDownLatch G = null;
    /* access modifiers changed from: private */
    public CountDownLatch H = null;
    private boolean I = false;
    private d J;

    /* renamed from: a  reason: collision with root package name */
    boolean f46467a = false;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public q f46468e;

    /* renamed from: f  reason: collision with root package name */
    final n f46469f;

    /* renamed from: g  reason: collision with root package name */
    Context f46470g;

    /* renamed from: h  reason: collision with root package name */
    final Object f46471h;
    /* access modifiers changed from: package-private */

    /* renamed from: i  reason: collision with root package name */
    public final ab f46472i;
    /* access modifiers changed from: package-private */
    public int j;
    g k = g.PENDING;
    /* access modifiers changed from: package-private */
    public i l = i.UNINITIALISED;
    ShareLinkManager m;
    WeakReference<Activity> n;
    boolean o = false;
    boolean p = false;
    final ai q;
    private JSONObject r;
    /* access modifiers changed from: private */
    public io.branch.referral.a.a w;
    private Semaphore x;
    /* access modifiers changed from: private */
    public boolean y;
    /* access modifiers changed from: private */
    public Map<g, String> z;

    public interface a {
    }

    public interface b {
    }

    public interface d {
    }

    public interface e {
    }

    public interface f {
        boolean a();
    }

    enum g {
        PENDING,
        READY
    }

    public interface h {
    }

    enum i {
        INITIALISED,
        INITIALISING,
        UNINITIALISED
    }

    private c(Context context) {
        this.f46468e = q.a(context);
        this.q = new ai(context);
        this.w = new io.branch.referral.a.b(context);
        this.f46469f = n.a(context);
        this.f46472i = ab.a(context);
        this.x = new Semaphore(1);
        this.f46471h = new Object();
        this.j = 0;
        this.y = true;
        this.z = new HashMap();
        this.C = new ConcurrentHashMap<>();
        if (!this.q.f46439a) {
            this.o = this.f46469f.f46548a.a(context, (ah.a) this);
        }
    }

    public static c a() {
        if (v == null) {
            q.h("Branch instance is not created yet. Make sure you have initialised Branch. [Consider Calling getInstance(Context ctx) if you still have issue.]");
        } else if (A && !B) {
            q.h("Branch instance is not properly initialised. Make sure your Application class is extending BranchApp class. If you are not extending BranchApp class make sure you are initialising Branch in your Applications onCreate()");
        }
        return v;
    }

    private static c a(Context context, boolean z2, String str) {
        boolean z3;
        if (v == null) {
            v = new c(context.getApplicationContext());
            boolean a2 = j.a(context);
            if (z2) {
                a2 = false;
            }
            j.a(a2);
            if (TextUtils.isEmpty((CharSequence) null)) {
                str = j.b(context);
            }
            if (TextUtils.isEmpty(str)) {
                q.h("Warning: Please enter your branch_key in your project's Manifest file!");
                z3 = v.f46468e.a("bnc_no_value");
            } else {
                z3 = v.f46468e.a(str);
            }
            if (z3) {
                v.z.clear();
                v.f46472i.e();
            }
            v.f46470g = context.getApplicationContext();
            if (context instanceof Application) {
                A = true;
                c cVar = v;
                Application application = (Application) context;
                try {
                    cVar.J = new d();
                    application.unregisterActivityLifecycleCallbacks(cVar.J);
                    application.registerActivityLifecycleCallbacks(cVar.J);
                    B = true;
                } catch (NoClassDefFoundError | NoSuchMethodError unused) {
                    B = false;
                    A = false;
                    q.h(new f("", -108).f46479a);
                }
            }
        }
        return v;
    }

    public static c a(Context context) {
        return a(context, true, (String) null);
    }

    public static c b(Context context) {
        return a(context, false, (String) null);
    }

    public static boolean b() {
        return s;
    }

    private boolean a(Uri uri, Activity activity) {
        String str;
        String str2;
        if (!K && !((this.k != g.READY && !n()) || activity == null || activity.getIntent() == null || this.l == i.INITIALISED || a(activity.getIntent()))) {
            Intent intent = activity.getIntent();
            if (intent.getData() == null || (!n() && a(activity))) {
                if (!q.d("bnc_install_params").equals("bnc_no_value")) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(m.a.Clicked_Branch_Link.getKey(), false);
                        jSONObject.put(m.a.IsFirstSession.getKey(), false);
                        q.a("bnc_session_params", jSONObject.toString());
                        this.p = true;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (!TextUtils.isEmpty(intent.getStringExtra(m.a.BranchData.getKey()))) {
                try {
                    JSONObject jSONObject2 = new JSONObject(intent.getStringExtra(m.a.BranchData.getKey()));
                    jSONObject2.put(m.a.Clicked_Branch_Link.getKey(), true);
                    q.a("bnc_session_params", jSONObject2.toString());
                    this.p = true;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                intent.removeExtra(m.a.BranchData.getKey());
                activity.setIntent(intent);
            } else if (uri.getQueryParameterNames() != null && Boolean.valueOf(uri.getQueryParameter(m.a.Instant.getKey())).booleanValue()) {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    for (String next : uri.getQueryParameterNames()) {
                        jSONObject3.put(next, uri.getQueryParameter(next));
                    }
                    jSONObject3.put(m.a.Clicked_Branch_Link.getKey(), true);
                    q.a("bnc_session_params", jSONObject3.toString());
                    this.p = true;
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
        if (u) {
            this.k = g.READY;
        }
        if (this.k == g.READY) {
            if (uri != null) {
                try {
                    if (!a(activity)) {
                        String a2 = aj.a(this.f46470g).a(uri.toString());
                        q.a("bnc_external_intent_uri", a2);
                        if (!(a2 == null || !a2.equals(uri.toString()) || activity == null || activity.getIntent() == null || activity.getIntent().getExtras() == null)) {
                            Bundle extras = activity.getIntent().getExtras();
                            Set keySet = extras.keySet();
                            if (keySet.size() > 0) {
                                JSONObject jSONObject4 = new JSONObject();
                                for (String str3 : F) {
                                    if (keySet.contains(str3)) {
                                        jSONObject4.put(str3, extras.get(str3));
                                    }
                                }
                                if (jSONObject4.length() > 0) {
                                    q.a("bnc_external_intent_extra", jSONObject4.toString());
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            String str4 = null;
            if (activity != null) {
                try {
                    if (!(activity.getIntent() == null || activity.getIntent().getExtras() == null || a(activity))) {
                        Object obj = activity.getIntent().getExtras().get(m.a.AndroidPushNotificationKey.getKey());
                        if (obj instanceof String) {
                            str2 = (String) obj;
                        } else {
                            str2 = obj instanceof Uri ? ((Uri) obj).toString() : null;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            q.a("bnc_push_identifier", str2);
                            Intent intent2 = activity.getIntent();
                            intent2.putExtra(m.a.BranchLinkUsed.getKey(), true);
                            activity.setIntent(intent2);
                            return false;
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (!(uri == null || !uri.isHierarchical() || activity == null)) {
                if (!((activity == null || activity.getIntent() == null || (activity.getIntent().getFlags() & 1048576) == 0) ? false : true)) {
                    try {
                        if (uri.getQueryParameter(m.a.LinkClickID.getKey()) != null) {
                            q.a("bnc_link_click_identifier", uri.getQueryParameter(m.a.LinkClickID.getKey()));
                            String str5 = "link_click_id=" + uri.getQueryParameter(m.a.LinkClickID.getKey());
                            if (activity.getIntent() != null) {
                                str4 = activity.getIntent().getDataString();
                            }
                            if (uri.getQuery().length() == str5.length()) {
                                str = "\\?".concat(String.valueOf(str5));
                            } else {
                                if (str4 != null) {
                                    if (str4.length() - str5.length() == str4.indexOf(str5)) {
                                        str = AppConstants.AND_SIGN.concat(String.valueOf(str5));
                                    }
                                }
                                str = str5 + AppConstants.AND_SIGN;
                            }
                            if (str4 != null) {
                                activity.getIntent().setData(Uri.parse(str4.replaceFirst(str, "")));
                                activity.getIntent().putExtra(m.a.BranchLinkUsed.getKey(), true);
                            } else {
                                q.h("Warning: URI for the launcher activity is null. Please make sure that intent data is not set to null before calling Branch#InitSession ");
                            }
                            return true;
                        }
                        String scheme = uri.getScheme();
                        Intent intent3 = activity.getIntent();
                        if (!(scheme == null || intent3 == null || ((!scheme.equalsIgnoreCase("http") && !scheme.equalsIgnoreCase("https")) || uri.getHost() == null || uri.getHost().length() <= 0 || a(activity)))) {
                            if (uri.toString().equalsIgnoreCase(aj.a(this.f46470g).a(uri.toString()))) {
                                q.a("bnc_app_link", uri.toString());
                            }
                            intent3.putExtra(m.a.BranchLinkUsed.getKey(), true);
                            activity.setIntent(intent3);
                        }
                    } catch (Exception unused3) {
                    }
                }
            }
        }
        return false;
    }

    private boolean n() {
        d dVar = this.J;
        if (dVar == null) {
            return false;
        }
        return dVar.f46477a;
    }

    private static boolean a(Activity activity) {
        if (activity == null || activity.getIntent() == null || !activity.getIntent().getBooleanExtra(m.a.BranchLinkUsed.getKey(), false)) {
            return false;
        }
        return true;
    }

    public final void e() {
        this.o = false;
        this.f46472i.a(s.b.GAID_FETCH_WAIT_LOCK);
        if (this.I) {
            r();
            this.I = false;
            return;
        }
        h();
    }

    public final void f() {
        this.f46472i.a(s.b.INSTALL_REFERRER_FETCH_WAIT_LOCK);
        h();
    }

    /* access modifiers changed from: package-private */
    public final JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (this.r != null) {
                    if (this.r.length() > 0) {
                        q.h("You're currently in deep link debug mode. Please comment out 'setDeepLinkDebugMode' to receive the deep link parameters from a real Branch link");
                    }
                    Iterator<String> keys = this.r.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, this.r.get(next));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    static JSONObject a(String str) {
        if (str.equals("bnc_no_value")) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            try {
                return new JSONObject(new String(b.a(str.getBytes())));
            } catch (JSONException e2) {
                e2.printStackTrace();
                return new JSONObject();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        try {
            this.x.acquire();
            if (this.j != 0 || this.f46472i.b() <= 0) {
                this.x.release();
                return;
            }
            this.j = 1;
            s d2 = this.f46472i.d();
            this.x.release();
            if (d2 == null) {
                this.f46472i.a((s) null);
            } else if (d2.i()) {
                this.j = 0;
            } else if (!(d2 instanceof ae) && !i()) {
                q.h("Branch Error: User session has not been initialized!");
                this.j = 0;
                a(this.f46472i.b() - 1, -101);
            } else if (!a(d2) || o()) {
                new C0782c(d2).a(new Void[0]);
            } else {
                this.j = 0;
                a(this.f46472i.b() - 1, -101);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(s sVar) {
        if (!(sVar instanceof z) && !(sVar instanceof u)) {
            return true;
        }
        return false;
    }

    private static boolean o() {
        return p() && q();
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) {
        s sVar;
        if (i2 >= this.f46472i.b()) {
            ab abVar = this.f46472i;
            sVar = abVar.a(abVar.b() - 1);
        } else {
            sVar = this.f46472i.a(i2);
        }
        a(sVar, i3);
    }

    private static void a(s sVar, int i2) {
        if (sVar != null) {
            sVar.a(i2, "");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Activity activity, boolean z2) {
        this.f46472i.a(s.b.INTENT_PENDING_WAIT_LOCK);
        if (z2) {
            a(activity.getIntent().getData(), activity);
            if (this.q.f46439a || D == null || q.e() == null || q.e().equalsIgnoreCase("bnc_no_value")) {
                h();
            } else if (this.o) {
                this.I = true;
            } else {
                r();
            }
        } else {
            h();
        }
    }

    private void r() {
        if (!this.q.f46439a) {
            WeakReference<Activity> weakReference = this.n;
            Context context = null;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity != null) {
                context = activity.getApplicationContext();
            }
            Context context2 = context;
            if (context2 != null) {
                this.f46472i.h();
                i.a().a(context2, D, this.f46469f, this.f46468e, new i.b() {
                    public final void a() {
                        c.this.f46472i.a(s.b.STRONG_MATCH_PENDING_WAIT_LOCK);
                        c.this.h();
                    }
                });
            }
        }
    }

    static boolean a(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent.getBooleanExtra(m.a.ForceNewBranchSession.getKey(), false) || (intent.getStringExtra(m.a.AndroidPushNotificationKey.getKey()) != null && !intent.getBooleanExtra(m.a.BranchLinkUsed.getKey(), false))) {
            return true;
        }
        return false;
    }

    /* renamed from: io.branch.referral.c$c  reason: collision with other inner class name */
    class C0782c extends e<Void, Void, ag> {

        /* renamed from: a  reason: collision with root package name */
        s f46475a;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            ag agVar = (ag) obj;
            super.onPostExecute(agVar);
            if (agVar != null) {
                try {
                    int i2 = agVar.f46431a;
                    boolean unused = c.this.y = true;
                    if (agVar.f46431a == -117) {
                        this.f46475a.l();
                        c.this.f46472i.a(this.f46475a);
                    } else {
                        int i3 = 0;
                        if (i2 != 200) {
                            if (this.f46475a instanceof z) {
                                c.this.l = i.UNINITIALISED;
                            }
                            if (i2 != 400) {
                                if (i2 != 409) {
                                    boolean unused2 = c.this.y = false;
                                    ArrayList arrayList = new ArrayList();
                                    while (i3 < c.this.f46472i.b()) {
                                        arrayList.add(c.this.f46472i.a(i3));
                                        i3++;
                                    }
                                    Iterator it2 = arrayList.iterator();
                                    while (it2.hasNext()) {
                                        s sVar = (s) it2.next();
                                        if (sVar == null || !sVar.c()) {
                                            c.this.f46472i.a(sVar);
                                        }
                                    }
                                    int unused3 = c.this.j = 0;
                                    Iterator it3 = arrayList.iterator();
                                    while (it3.hasNext()) {
                                        s sVar2 = (s) it3.next();
                                        if (sVar2 != null) {
                                            sVar2.a(i2, agVar.b());
                                            if (sVar2.c()) {
                                                sVar2.b();
                                            }
                                        }
                                    }
                                }
                            }
                            c.this.f46472i.a(this.f46475a);
                            if (!(this.f46475a instanceof u)) {
                                q.j("Branch API Error: Conflicting resource error code from API");
                                c.this.a(0, i2);
                            } else if (((u) this.f46475a).f46583i != null) {
                                new f("Trouble creating a URL.", -105);
                            }
                        } else {
                            boolean unused4 = c.this.y = true;
                            if (this.f46475a instanceof u) {
                                if (agVar.a() != null) {
                                    c.this.z.put(((u) this.f46475a).f46582h, agVar.a().getString("url"));
                                }
                            } else if (this.f46475a instanceof aa) {
                                c.this.z.clear();
                                c.this.f46472i.e();
                            }
                            c.this.f46472i.c();
                            if (!(this.f46475a instanceof z)) {
                                if (!(this.f46475a instanceof y)) {
                                    this.f46475a.a(agVar, c.v);
                                }
                            }
                            JSONObject a2 = agVar.a();
                            if (a2 != null) {
                                if (!c.this.q.f46439a) {
                                    if (a2.has(m.a.SessionID.getKey())) {
                                        q unused5 = c.this.f46468e;
                                        q.a("bnc_session_id", a2.getString(m.a.SessionID.getKey()));
                                        i3 = 1;
                                    }
                                    if (a2.has(m.a.IdentityID.getKey())) {
                                        String string = a2.getString(m.a.IdentityID.getKey());
                                        q unused6 = c.this.f46468e;
                                        if (!q.d("bnc_identity_id").equals(string)) {
                                            c.this.z.clear();
                                            q unused7 = c.this.f46468e;
                                            q.a("bnc_identity_id", a2.getString(m.a.IdentityID.getKey()));
                                            i3 = 1;
                                        }
                                    }
                                    if (a2.has(m.a.DeviceFingerprintID.getKey())) {
                                        q unused8 = c.this.f46468e;
                                        q.a("bnc_device_fingerprint_id", a2.getString(m.a.DeviceFingerprintID.getKey()));
                                        i3 = 1;
                                    }
                                }
                                if (i3 != 0) {
                                    c.h(c.this);
                                }
                                if (this.f46475a instanceof z) {
                                    c.this.l = i.INITIALISED;
                                    this.f46475a.a(agVar, c.v);
                                    if (!((z) this.f46475a).a(agVar)) {
                                        c.this.j();
                                    }
                                    if (c.this.H != null) {
                                        c.this.H.countDown();
                                    }
                                    if (c.this.G != null) {
                                        c.this.G.countDown();
                                    }
                                } else {
                                    this.f46475a.a(agVar, c.v);
                                }
                            }
                        }
                    }
                    int unused9 = c.this.j = 0;
                    if (c.this.y && c.this.l != i.UNINITIALISED) {
                        c.this.h();
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public C0782c(s sVar) {
            this.f46475a = sVar;
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            super.onPreExecute();
            this.f46475a.j();
            this.f46475a.h();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            JSONObject optJSONObject;
            c cVar = c.this;
            String str = this.f46475a.f46574c + "-" + m.a.Queue_Wait_Time.getKey();
            s sVar = this.f46475a;
            long j = 0;
            if (sVar.f46576e > 0) {
                j = System.currentTimeMillis() - sVar.f46576e;
            }
            cVar.a(str, String.valueOf(j));
            s sVar2 = this.f46475a;
            if (sVar2 instanceof z) {
                z zVar = (z) sVar2;
                String d2 = q.d("bnc_link_click_identifier");
                if (!d2.equals("bnc_no_value")) {
                    try {
                        zVar.f46573b.put(m.a.LinkIdentifier.getKey(), d2);
                        zVar.f46573b.put(m.a.FaceBookAppLinkChecked.getKey(), q.e("bnc_triggered_by_fb_app_link"));
                    } catch (JSONException unused) {
                    }
                }
                String d3 = q.d("bnc_google_search_install_identifier");
                if (!d3.equals("bnc_no_value")) {
                    try {
                        zVar.f46573b.put(m.a.GoogleSearchInstallReferrer.getKey(), d3);
                    } catch (JSONException unused2) {
                    }
                }
                String d4 = q.d("bnc_google_play_install_referrer_extras");
                if (!d4.equals("bnc_no_value")) {
                    try {
                        zVar.f46573b.put(m.a.GooglePlayInstallReferrer.getKey(), d4);
                    } catch (JSONException unused3) {
                    }
                }
                if (q.e("bnc_is_full_app_conversion")) {
                    try {
                        zVar.f46573b.put(m.a.AndroidAppLinkURL.getKey(), q.d("bnc_app_link"));
                        zVar.f46573b.put(m.a.IsFullAppConv.getKey(), true);
                    } catch (JSONException unused4) {
                    }
                }
            }
            if (sVar2.k() == s.a.V2 && (optJSONObject = sVar2.f46573b.optJSONObject(m.a.UserData.getKey())) != null) {
                try {
                    optJSONObject.put(m.a.DeveloperIdentity.getKey(), q.d("bnc_identity"));
                    optJSONObject.put(m.a.DeviceFingerprintID.getKey(), q.d("bnc_device_fingerprint_id"));
                } catch (JSONException unused5) {
                }
            }
            if (!j.a()) {
                s.a k = sVar2.k();
                int i2 = n.a().f46548a.f46435c;
                String str2 = n.a().f46548a.f46434b;
                String str3 = null;
                try {
                    if (k == s.a.V1) {
                        sVar2.f46573b.put(m.a.LATVal.getKey(), i2);
                        if (!TextUtils.isEmpty(str2)) {
                            sVar2.f46573b.put(m.a.GoogleAdvertisingID.getKey(), str2);
                            sVar2.f46573b.remove(m.a.UnidentifiedDevice.getKey());
                            str3 = s.c(sVar2.f46573b);
                        } else if (!s.b(sVar2.f46573b) && !sVar2.f46573b.optBoolean(m.a.UnidentifiedDevice.getKey())) {
                            sVar2.f46573b.put(m.a.UnidentifiedDevice.getKey(), true);
                        }
                    } else {
                        JSONObject optJSONObject2 = sVar2.f46573b.optJSONObject(m.a.UserData.getKey());
                        if (optJSONObject2 != null) {
                            optJSONObject2.put(m.a.LimitedAdTracking.getKey(), i2);
                            if (!TextUtils.isEmpty(str2)) {
                                optJSONObject2.put(m.a.AAID.getKey(), str2);
                                optJSONObject2.remove(m.a.UnidentifiedDevice.getKey());
                                str3 = s.c(optJSONObject2);
                            } else if (!s.b(optJSONObject2) && !optJSONObject2.optBoolean(m.a.UnidentifiedDevice.getKey())) {
                                optJSONObject2.put(m.a.UnidentifiedDevice.getKey(), true);
                            }
                        }
                    }
                    if (str3 != null) {
                        sVar2.f46573b.put(m.a.AdvertisingIDs.getKey(), new JSONObject().put(str3, str2));
                    }
                } catch (JSONException unused6) {
                }
            }
            if (c.this.q.f46439a && !this.f46475a.m()) {
                return new ag(this.f46475a.f46574c, -117);
            }
            if (this.f46475a.a()) {
                io.branch.referral.a.a d5 = c.this.w;
                String f2 = this.f46475a.f();
                JSONObject jSONObject = this.f46475a.f46573b;
                String str4 = this.f46475a.f46574c;
                q unused7 = c.this.f46468e;
                return d5.a(f2, jSONObject, str4, q.e());
            }
            io.branch.referral.a.a d6 = c.this.w;
            JSONObject a2 = this.f46475a.a((ConcurrentHashMap<String, String>) c.this.C);
            String f3 = this.f46475a.f();
            String str5 = this.f46475a.f46574c;
            q unused8 = c.this.f46468e;
            return d6.a(a2, f3, str5, q.e());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ab A[Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }, EDGE_INSN: B:60:0x00ab->B:38:0x00ab ?: BREAK  
    EDGE_INSN: B:61:0x00ab->B:38:0x00ab ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() {
        /*
            r12 = this;
            java.lang.String r0 = "io.branch.sdk.auto_link_keys"
            org.json.JSONObject r1 = r12.g()
            r2 = 0
            io.branch.referral.m$a r3 = io.branch.referral.m.a.Clicked_Branch_Link     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r3 = r3.getKey()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            boolean r3 = r1.has(r3)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r3 == 0) goto L_0x0109
            io.branch.referral.m$a r3 = io.branch.referral.m.a.Clicked_Branch_Link     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r3 = r3.getKey()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            boolean r3 = r1.getBoolean(r3)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r3 != 0) goto L_0x0021
            goto L_0x0109
        L_0x0021:
            int r3 = r1.length()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r3 <= 0) goto L_0x0109
            android.content.Context r3 = r12.f46470g     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            android.content.Context r4 = r12.f46470g     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            r5 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            android.os.Bundle r4 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            r5 = 0
            if (r4 == 0) goto L_0x0049
            android.os.Bundle r3 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r4 = "io.branch.sdk.auto_link_disable"
            boolean r3 = r3.getBoolean(r4, r5)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r3 == 0) goto L_0x0049
            return
        L_0x0049:
            android.content.Context r3 = r12.f46470g     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            android.content.Context r4 = r12.f46470g     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            r6 = 129(0x81, float:1.81E-43)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r6)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            android.content.pm.ActivityInfo[] r3 = r3.activities     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r3 == 0) goto L_0x00bb
            int r4 = r3.length     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            r6 = 0
        L_0x0061:
            if (r6 >= r4) goto L_0x00bb
            r7 = r3[r6]     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r7 == 0) goto L_0x00b8
            android.os.Bundle r8 = r7.metaData     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r8 == 0) goto L_0x00b8
            android.os.Bundle r8 = r7.metaData     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r8 = r8.getString(r0)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r8 != 0) goto L_0x007d
            android.os.Bundle r8 = r7.metaData     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r9 = "io.branch.sdk.auto_link_path"
            java.lang.String r8 = r8.getString(r9)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r8 == 0) goto L_0x00b8
        L_0x007d:
            android.os.Bundle r8 = r7.metaData     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r8 = r8.getString(r0)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r8 == 0) goto L_0x00a2
            android.os.Bundle r8 = r7.metaData     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r8 = r8.getString(r0)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r9 = ","
            java.lang.String[] r8 = r8.split(r9)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            int r9 = r8.length     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            r10 = 0
        L_0x0093:
            if (r10 >= r9) goto L_0x00a2
            r11 = r8[r10]     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            boolean r11 = r1.has(r11)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r11 == 0) goto L_0x009f
            r8 = 1
            goto L_0x00a3
        L_0x009f:
            int r10 = r10 + 1
            goto L_0x0093
        L_0x00a2:
            r8 = 0
        L_0x00a3:
            if (r8 != 0) goto L_0x00ab
            boolean r8 = a((org.json.JSONObject) r1, (android.content.pm.ActivityInfo) r7)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r8 == 0) goto L_0x00b8
        L_0x00ab:
            java.lang.String r2 = r7.name     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            android.os.Bundle r0 = r7.metaData     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r3 = "io.branch.sdk.auto_link_request_code"
            r4 = 1501(0x5dd, float:2.103E-42)
            int r5 = r0.getInt(r3, r4)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            goto L_0x00bb
        L_0x00b8:
            int r6 = r6 + 1
            goto L_0x0061
        L_0x00bb:
            if (r2 == 0) goto L_0x0109
            java.lang.ref.WeakReference<android.app.Activity> r0 = r12.n     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r0 == 0) goto L_0x0109
            java.lang.ref.WeakReference<android.app.Activity> r0 = r12.n     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.Object r0 = r0.get()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r0 == 0) goto L_0x0104
            android.content.Intent r3 = new android.content.Intent     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.Class r4 = java.lang.Class.forName(r2)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            r3.<init>(r0, r4)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r4 = "io.branch.sdk.auto_linked"
            java.lang.String r6 = "true"
            r3.putExtra(r4, r6)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            io.branch.referral.m$a r4 = io.branch.referral.m.a.ReferringData     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r4 = r4.getKey()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r6 = r1.toString()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            r3.putExtra(r4, r6)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.util.Iterator r4 = r1.keys()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
        L_0x00ec:
            boolean r6 = r4.hasNext()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            if (r6 == 0) goto L_0x0100
            java.lang.Object r6 = r4.next()     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            java.lang.String r7 = r1.getString(r6)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            r3.putExtra(r6, r7)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            goto L_0x00ec
        L_0x0100:
            r0.startActivityForResult(r3, r5)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
            return
        L_0x0104:
            java.lang.String r0 = "No activity reference to launch deep linked activity"
            io.branch.referral.q.h(r0)     // Catch:{ NameNotFoundException -> 0x0118, ClassNotFoundException -> 0x010a, Exception -> 0x0109 }
        L_0x0109:
            return
        L_0x010a:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Warning: Please make sure Activity names set for auto deep link are correct! Error while looking for activity "
            java.lang.String r0 = r1.concat(r0)
            io.branch.referral.q.h(r0)
            return
        L_0x0118:
            java.lang.String r0 = "Warning: Please make sure Activity names set for auto deep link are correct!"
            io.branch.referral.q.h(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.c.j():void");
    }

    private static boolean a(JSONObject jSONObject, ActivityInfo activityInfo) {
        boolean z2;
        String str = null;
        try {
            if (jSONObject.has(m.a.AndroidDeepLinkPath.getKey())) {
                str = jSONObject.getString(m.a.AndroidDeepLinkPath.getKey());
            } else if (jSONObject.has(m.a.DeepLinkPath.getKey())) {
                str = jSONObject.getString(m.a.DeepLinkPath.getKey());
            }
        } catch (JSONException unused) {
        }
        if (!(activityInfo.metaData.getString("io.branch.sdk.auto_link_path") == null || str == null)) {
            for (String trim : activityInfo.metaData.getString("io.branch.sdk.auto_link_path").split(AppConstants.COMMA)) {
                String[] split = trim.trim().split("\\?")[0].split("/");
                String[] split2 = str.split("\\?")[0].split("/");
                if (split.length == split2.length) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < split.length && i2 < split2.length) {
                            String str2 = split[i2];
                            if (!str2.equals(split2[i2]) && !str2.contains("*")) {
                                break;
                            }
                            i2++;
                        } else {
                            z2 = true;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean k() {
        return t;
    }

    public static boolean l() {
        return u;
    }

    public final void a(String str, String str2) {
        this.C.put(str, str2);
    }

    public final void b(String str) {
        if (z.a(str)) {
            j();
        }
    }

    public final void c(String str) {
        if (z.a(str)) {
            j();
        }
    }

    public final void d(String str) {
        if (z.a(str)) {
            j();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (this.l != i.UNINITIALISED) {
            if (!this.y) {
                s d2 = this.f46472i.d();
                if ((d2 != null && (d2 instanceof ae)) || (d2 instanceof af)) {
                    this.f46472i.c();
                }
            } else if (!this.f46472i.f()) {
                ad adVar = new ad(this.f46470g);
                if (this.q.f46439a && !adVar.m()) {
                    adVar.l();
                } else if (this.l != i.INITIALISED) {
                    q.h("Branch is not initialized, cannot close session");
                } else {
                    ab abVar = this.f46472i;
                    synchronized (ab.f46421b) {
                        abVar.f46423a.add(adVar);
                        if (abVar.b() >= 25) {
                            abVar.f46423a.remove(1);
                        }
                        abVar.a();
                    }
                    adVar.f46576e = System.currentTimeMillis();
                    h();
                }
            }
            this.l = i.UNINITIALISED;
        }
        q.a("bnc_external_intent_uri", (String) null);
        this.q.a(this.f46470g);
    }

    static String d() {
        String d2 = q.d("bnc_external_intent_uri");
        if (d2.equals("bnc_no_value")) {
            return null;
        }
        return d2;
    }

    public final JSONObject g() {
        return a(a(q.d("bnc_session_params")));
    }

    private static boolean p() {
        return !q.d("bnc_session_id").equals("bnc_no_value");
    }

    private static boolean q() {
        return !q.d("bnc_device_fingerprint_id").equals("bnc_no_value");
    }

    static boolean i() {
        return !q.d("bnc_identity_id").equals("bnc_no_value");
    }

    static /* synthetic */ void h(c cVar) {
        JSONObject jSONObject;
        int i2 = 0;
        while (i2 < cVar.f46472i.b()) {
            try {
                s a2 = cVar.f46472i.a(i2);
                if (!(a2 == null || (jSONObject = a2.f46573b) == null)) {
                    if (jSONObject.has(m.a.SessionID.getKey())) {
                        a2.f46573b.put(m.a.SessionID.getKey(), q.d("bnc_session_id"));
                    }
                    if (jSONObject.has(m.a.IdentityID.getKey())) {
                        a2.f46573b.put(m.a.IdentityID.getKey(), q.d("bnc_identity_id"));
                    }
                    if (jSONObject.has(m.a.DeviceFingerprintID.getKey())) {
                        a2.f46573b.put(m.a.DeviceFingerprintID.getKey(), q.d("bnc_device_fingerprint_id"));
                    }
                }
                i2++;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
    }
}
