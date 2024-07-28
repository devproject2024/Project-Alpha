package net.one97.paytm.feed.e;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.fragment.app.j;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.e;
import net.one97.paytm.feed.events.b.a;
import net.one97.paytm.feed.repository.a.b;
import net.one97.paytm.feed.repository.models.FeedCommentReportTags;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.repository.models.FeedOfFeed;
import net.one97.paytm.feed.repository.models.FeedPostReportTags;
import net.one97.paytm.feed.repository.models.language.FeedLanguage;
import net.one97.paytm.feed.repository.models.language.FeedLanguageData;
import net.one97.paytm.feed.repository.models.polls.Options;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.repository.models.stories.StoryData;
import net.one97.paytm.feed.ui.feed.FeedFragment;
import net.one97.paytm.feed.ui.feed.actions.comment.FeedCommentActivity;
import net.one97.paytm.feed.ui.feed.f;
import net.one97.paytm.feed.ui.feed.sheroes.SheroesActivity;
import net.one97.paytm.feed.ui.profile.ProfileActivity;
import net.one97.paytm.feed.ui.profile.ProfileDiscoverActivity;
import net.one97.paytm.feed.utility.u;
import org.json.JSONArray;

public final class b {
    private static boolean A = false;
    private static String B = "[EN,HI]";
    private static boolean C = false;
    private static String D = null;
    private static boolean E = true;
    private static ArrayList<FeedItem> F = new ArrayList<>();
    private static int G = -1;
    private static int H = -1;
    private static HashMap<Integer, Integer> I = new HashMap<>();
    private static HashMap<String, FeedOfFeed> J = new HashMap<>();
    private static boolean K = true;
    private static boolean L = true;

    /* renamed from: a  reason: collision with root package name */
    public static Application f34266a = null;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, List<Options>> f34267b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final b f34268c = new b();

    /* renamed from: d  reason: collision with root package name */
    private static int f34269d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f34270e = false;

    /* renamed from: f  reason: collision with root package name */
    private static StoryData f34271f = null;

    /* renamed from: g  reason: collision with root package name */
    private static TreeSet<Integer> f34272g = null;

    /* renamed from: h  reason: collision with root package name */
    private static List<FeedLanguageData> f34273h = null;

    /* renamed from: i  reason: collision with root package name */
    private static FeedPostReportTags f34274i = null;
    private static FeedCommentReportTags j = null;
    private static net.one97.paytm.feed.ui.feed.sheroes.b k = null;
    private static f l = null;
    private static String m = "https://digitalapiproxy.paytm.com";
    private static final String n = n;
    private static long o = System.currentTimeMillis();
    private static e p;
    private static e q;
    private static boolean r;
    private static boolean s;
    private static boolean t = true;
    private static boolean u;
    private static String v = "https://cif.paytm.com";
    private static a w;
    private static boolean x;
    private static boolean y;
    private static boolean z;

    static final class a extends l implements kotlin.g.a.b<FeedLanguage, x> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedLanguage) obj);
            return x.f47997a;
        }

        public final void invoke(FeedLanguage feedLanguage) {
            if (feedLanguage == null || !(!feedLanguage.getLanguages().isEmpty())) {
                net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
                b bVar2 = b.f34268c;
                net.one97.paytm.feed.repository.b.a(b.o());
            } else if (feedLanguage.isBoard()) {
                ArrayList arrayList = new ArrayList();
                for (FeedLanguageData next : feedLanguage.getLanguages()) {
                    if (next.isSelected()) {
                        arrayList.add(next.getLanguageCode());
                    }
                }
                if (arrayList.size() != 0) {
                    net.one97.paytm.feed.repository.b bVar3 = net.one97.paytm.feed.repository.b.f34608a;
                    String arrayList2 = arrayList.toString();
                    k.a((Object) arrayList2, "selectedLanguage.toString()");
                    net.one97.paytm.feed.repository.b.a(arrayList2);
                } else {
                    net.one97.paytm.feed.repository.b bVar4 = net.one97.paytm.feed.repository.b.f34608a;
                    b bVar5 = b.f34268c;
                    net.one97.paytm.feed.repository.b.a(b.o());
                }
                c cVar = c.f34275a;
                c.k();
            } else {
                c cVar2 = c.f34275a;
                if (!TextUtils.isEmpty(c.h())) {
                    b bVar6 = b.f34268c;
                    b.E();
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.feed.e.b$b  reason: collision with other inner class name */
    static final class C0557b extends l implements kotlin.g.a.b<List<? extends FeedItem>, x> {
        public static final C0557b INSTANCE = new C0557b();

        C0557b() {
            super(1);
        }

        public final void invoke(List<? extends FeedItem> list) {
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends FeedItem>) (List) obj);
            return x.f47997a;
        }
    }

    static final class c extends l implements kotlin.g.a.b<String, x> {
        public static final c INSTANCE = new c();

        c() {
            super(1);
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str == null) {
                net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
                net.one97.paytm.feed.repository.b.a(false);
                return;
            }
            net.one97.paytm.feed.repository.b bVar2 = net.one97.paytm.feed.repository.b.f34608a;
            net.one97.paytm.feed.repository.b.a(true);
        }
    }

    static final class d extends l implements kotlin.g.a.b<String, x> {
        public static final d INSTANCE = new d();

        d() {
            super(1);
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                b bVar = b.f34268c;
                b.i();
                b bVar2 = b.f34268c;
                b.k();
            }
        }
    }

    private b() {
    }

    public static int a() {
        return f34269d;
    }

    public static boolean b() {
        return f34270e;
    }

    public static void a(TreeSet<Integer> treeSet) {
        f34272g = treeSet;
    }

    public static TreeSet<Integer> c() {
        return f34272g;
    }

    public static void a(List<FeedLanguageData> list) {
        f34273h = list;
    }

    public static List<FeedLanguageData> d() {
        return f34273h;
    }

    public static FeedPostReportTags e() {
        return f34274i;
    }

    public static FeedCommentReportTags f() {
        return j;
    }

    public static Application g() {
        Application application = f34266a;
        if (application == null) {
            k.a("application");
        }
        return application;
    }

    public static void a(String str) {
        k.c(str, "<set-?>");
        m = str;
    }

    public static String h() {
        return m;
    }

    public static String i() {
        return n;
    }

    public static void a(long j2) {
        o = j2;
    }

    public static long j() {
        return o;
    }

    public static boolean k() {
        return r;
    }

    public static boolean l() {
        return s;
    }

    public static String m() {
        return v;
    }

    public static boolean n() {
        return y;
    }

    public static void a(boolean z2) {
        A = z2;
    }

    public static String o() {
        return B;
    }

    public static void b(boolean z2) {
        C = z2;
    }

    public static boolean p() {
        return C;
    }

    public static String q() {
        return D;
    }

    public static void c(boolean z2) {
        E = z2;
    }

    public static void a(int i2) {
        G = i2;
    }

    public static void b(int i2) {
        H = i2;
    }

    public static int r() {
        return H;
    }

    public static HashMap<Integer, Integer> s() {
        return I;
    }

    public static HashMap<String, FeedOfFeed> t() {
        return J;
    }

    public static boolean u() {
        return K;
    }

    public static boolean v() {
        return L;
    }

    public final synchronized void a(Application application) {
        k.c(application, "application");
        f34266a = application;
        net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
        net.one97.paytm.feed.repository.b.a((Context) application);
        net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
        net.one97.paytm.feed.events.a.b();
        r = false;
        net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
        net.one97.paytm.feed.events.f.f();
        for (int i2 = 0; i2 < 20; i2++) {
            I.put(Integer.valueOf(i2), -1);
        }
    }

    public final synchronized void a(Context context, Map<String, String> map) {
        FeedCommentReportTags feedCommentReportTags;
        FeedPostReportTags feedPostReportTags;
        k.c(context, "context");
        k.c(map, "data");
        c cVar = c.f34275a;
        c.a(map);
        String str = map.get("post_flags");
        if (str != null) {
            com.google.gson.f fVar = new com.google.gson.f();
            if (!TextUtils.isEmpty(str)) {
                feedPostReportTags = (FeedPostReportTags) fVar.a(str, FeedPostReportTags.class);
            } else {
                feedPostReportTags = (FeedPostReportTags) fVar.a("{\"tags\":[\"Violence\",\"Spam\",\"Hate Speech\",\"Political Sensitive\",\"Terrorism\",\"Nudity\",\"Vulgar\",\"False News\",\"Harassment\",\"Racism\",\"Religious Sensitive\",\"Hatred\",\"Suicide\",\"Unauthorised sales\",\"Sexual Exploitation\",\"Child Exploitation\",\"Drug Abuse\"]}", FeedPostReportTags.class);
            }
            f34274i = feedPostReportTags;
        }
        String str2 = map.get("comment_flags");
        if (str2 != null) {
            com.google.gson.f fVar2 = new com.google.gson.f();
            if (!TextUtils.isEmpty(str2)) {
                feedCommentReportTags = (FeedCommentReportTags) fVar2.a(str2, FeedCommentReportTags.class);
            } else {
                feedCommentReportTags = (FeedCommentReportTags) fVar2.a("{\"tags\":[\"Violence\",\"Spam\",\"Hate Speech\",\"Political Sensitive\",\"Terrorism\",\"Nudity\",\"Vulgar\",\"False News\",\"Harassment\",\"Racism\",\"Religious Sensitive\",\"Hatred\",\"Suicide\",\"Unauthorised sales\",\"Sexual Exploitation\",\"Child Exploitation\",\"Drug Abuse\"]}", FeedCommentReportTags.class);
            }
            j = feedCommentReportTags;
        }
        String str3 = map.get("paytm_app_lang");
        D = str3;
        if (TextUtils.isEmpty(str3)) {
            D = "EN";
        }
        if (!TextUtils.isEmpty(map.get("base_url"))) {
            String str4 = map.get("base_url");
            if (str4 == null) {
                k.a();
            }
            m = str4;
        }
        if (!TextUtils.isEmpty(map.get("merchant_action_url"))) {
            String str5 = map.get("merchant_action_url");
            if (str5 == null) {
                k.a();
            }
            v = str5;
        }
        String str6 = map.get("feed_sheroes_login");
        if (str6 != null) {
            y = Boolean.parseBoolean(str6);
        }
    }

    public final synchronized void a(net.one97.paytm.feed.ui.feed.sheroes.b bVar, f fVar, a aVar) {
        k = bVar;
        l = fVar;
        w = aVar;
    }

    public static void a(Map<String, String> map) {
        k.c(map, "userInfo");
        if (b(map)) {
            c cVar = c.f34275a;
            c.a(map);
            net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
            net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
            Application application = f34266a;
            if (application == null) {
                k.a("application");
            }
            Context applicationContext = application.getApplicationContext();
            k.a((Object) applicationContext, "FeedManager.application.applicationContext");
            kotlin.g.a.b bVar = c.INSTANCE;
            k.c(applicationContext, "context");
            k.c(bVar, "completionHandler");
            net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
            String str = m;
            if (str == null) {
                k.a();
            }
            String b2 = net.one97.paytm.feed.utility.l.b(applicationContext, str, "/content-users/v1/profileUpdate", (Map<String, ? extends Object>) null);
            String str2 = net.one97.paytm.feed.repository.a.b.f34365a;
            b.cn cnVar = new b.cn(a2, b2, bVar, applicationContext, b2, new b.co(bVar), new b.cp(bVar, applicationContext));
            cnVar.setRetryPolicy(net.one97.paytm.feed.repository.a.b.a(applicationContext));
            net.one97.paytm.feed.repository.a.a a3 = net.one97.paytm.feed.repository.a.a.f34362b.a(applicationContext);
            if (a3 != null) {
                a3.a(cnVar);
                return;
            }
            return;
        }
        c cVar2 = c.f34275a;
        c.a(map);
    }

    private static boolean b(Map<String, String> map) {
        try {
            c cVar = c.f34275a;
            if (TextUtils.isEmpty(c.d())) {
                return false;
            }
            String str = map.get("avatar");
            c cVar2 = c.f34275a;
            if (p.a(c.a(), map.get("name"), false)) {
                c cVar3 = c.f34275a;
                if (!p.a(c.b(), str, true)) {
                    return true;
                }
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void w() {
        if (!t || !z) {
            z = false;
        } else {
            net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
            a.C0560a aVar2 = net.one97.paytm.feed.events.b.a.f34338a;
            net.one97.paytm.feed.events.a.a(net.one97.paytm.feed.events.b.a.f34339c, System.currentTimeMillis(), 0, 0, 0);
        }
        net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
        net.one97.paytm.feed.events.f.f();
        c cVar = c.f34275a;
        c.a(0.0f, 0.0f);
        c.a((Map<String, String>) new HashMap());
        net.one97.paytm.feed.repository.db.a aVar3 = net.one97.paytm.feed.repository.db.a.f34614a;
        Application application = f34266a;
        if (application == null) {
            k.a("application");
        }
        Context applicationContext = application.getApplicationContext();
        k.a((Object) applicationContext, "application.applicationContext");
        net.one97.paytm.feed.repository.db.a.b(applicationContext);
        net.one97.paytm.feed.events.a.a aVar4 = net.one97.paytm.feed.events.a.a.f34296a;
        net.one97.paytm.feed.events.a.a.a();
        z = false;
    }

    public static void c(int i2) {
        if (i2 == 0) {
            t = true;
            net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
            net.one97.paytm.feed.events.f.a(System.currentTimeMillis());
            StringBuilder sb = new StringBuilder("New Begin Time :: ");
            net.one97.paytm.feed.events.f fVar2 = net.one97.paytm.feed.events.f.f34346d;
            sb.append(net.one97.paytm.feed.events.f.a());
            x = false;
        } else if (i2 == 1) {
            t = false;
            if (!x) {
                net.one97.paytm.feed.events.f fVar3 = net.one97.paytm.feed.events.f.f34346d;
                net.one97.paytm.feed.events.f.b(System.currentTimeMillis());
                net.one97.paytm.feed.events.f fVar4 = net.one97.paytm.feed.events.f.f34346d;
                long c2 = net.one97.paytm.feed.events.f.c();
                net.one97.paytm.feed.events.f fVar5 = net.one97.paytm.feed.events.f.f34346d;
                long b2 = net.one97.paytm.feed.events.f.b();
                net.one97.paytm.feed.events.f fVar6 = net.one97.paytm.feed.events.f.f34346d;
                net.one97.paytm.feed.events.f.c(c2 + (b2 - net.one97.paytm.feed.events.f.a()));
                net.one97.paytm.feed.events.f fVar7 = net.one97.paytm.feed.events.f.f34346d;
                net.one97.paytm.feed.events.f.a(0);
                net.one97.paytm.feed.events.f fVar8 = net.one97.paytm.feed.events.f.f34346d;
                net.one97.paytm.feed.events.f.b(0);
                StringBuilder sb2 = new StringBuilder("Delta Time :: ");
                net.one97.paytm.feed.events.f fVar9 = net.one97.paytm.feed.events.f.f34346d;
                sb2.append(net.one97.paytm.feed.events.f.c());
                x = true;
            }
        } else if (i2 == 2) {
            t = true;
            e eVar = p;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public static void a(Map<String, String> map, Context context) {
        k.c(map, "data");
        k.c(context, "context");
        try {
            if (f34266a != null) {
                c cVar = c.f34275a;
                c.a(map);
                net.one97.paytm.feed.events.a.a aVar = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.events.a.a.a();
                net.one97.paytm.feed.c.a aVar2 = net.one97.paytm.feed.c.a.f34255a;
                net.one97.paytm.feed.c.a.a().b(context, "/content-users/v1/getUserlanguage/", m, (kotlin.g.a.b<? super FeedLanguage, x>) a.INSTANCE);
                String str = m;
                net.one97.paytm.feed.c.a aVar3 = net.one97.paytm.feed.c.a.f34255a;
                net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
                net.one97.paytm.feed.utility.l lVar = net.one97.paytm.feed.utility.l.f35406a;
                FeedFragment.a aVar4 = FeedFragment.f34877i;
                String a3 = net.one97.paytm.feed.utility.l.a(context, str, FeedFragment.z, "PREFETCH", "");
                FeedFragment.a aVar5 = FeedFragment.f34877i;
                a2.a(context, a3, FeedFragment.z, (kotlin.g.a.b<? super List<? extends FeedItem>, x>) C0557b.INSTANCE);
            }
        } catch (Error | Exception unused) {
        }
    }

    public static void a(Context context, boolean z2, j jVar) {
        k.c(context, "context");
        k.c(jVar, "childFragmentManager");
        s = z2;
        new StringBuilder("--->>>>>onTabSwitched ").append(s);
        if (!z) {
            net.one97.paytm.feed.events.a aVar = net.one97.paytm.feed.events.a.f34284a;
            a.C0560a aVar2 = net.one97.paytm.feed.events.b.a.f34338a;
            net.one97.paytm.feed.events.a.a(net.one97.paytm.feed.events.b.a.f34339c, System.currentTimeMillis(), 0, 0, 0);
            z = true;
        }
        if (!s || !t) {
            if (!x) {
                net.one97.paytm.feed.events.f fVar = net.one97.paytm.feed.events.f.f34346d;
                net.one97.paytm.feed.events.f.b(System.currentTimeMillis());
                x = true;
            }
            StringBuilder sb = new StringBuilder("Delta Time :: ");
            net.one97.paytm.feed.events.f fVar2 = net.one97.paytm.feed.events.f.f34346d;
            sb.append(net.one97.paytm.feed.events.f.c());
        } else {
            net.one97.paytm.feed.events.f fVar3 = net.one97.paytm.feed.events.f.f34346d;
            net.one97.paytm.feed.events.f.a(System.currentTimeMillis());
            StringBuilder sb2 = new StringBuilder("Begin time :: ");
            net.one97.paytm.feed.events.f fVar4 = net.one97.paytm.feed.events.f.f34346d;
            sb2.append(net.one97.paytm.feed.events.f.a());
            x = false;
        }
        net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
        if (!net.one97.paytm.feed.repository.b.m()) {
            c cVar = c.f34275a;
            c.j();
        }
    }

    public static x a(Context context, SheroesActivity.c cVar) {
        k.c(context, "context");
        k.c(cVar, "listener");
        net.one97.paytm.feed.ui.feed.sheroes.b bVar = k;
        if (bVar == null) {
            return null;
        }
        bVar.getFragment(context, cVar);
        return x.f47997a;
    }

    public static void a(Context context) {
        k.c(context, "context");
        f fVar = l;
        if (fVar == null) {
            try {
                Class<?> cls = Class.forName("net.one97.paytm.auth.activity.AJRAuthActivity");
                k.a((Object) cls, "Class.forName(activityToStart)");
                Application application = f34266a;
                if (application == null) {
                    k.a("application");
                }
                if (application.getApplicationContext() != null) {
                    Application application2 = f34266a;
                    if (application2 == null) {
                        k.a("application");
                    }
                    Intent intent = new Intent(application2.getApplicationContext(), cls);
                    intent.addFlags(268435456);
                    Application application3 = f34266a;
                    if (application3 == null) {
                        k.a("application");
                    }
                    application3.getApplicationContext().startActivity(intent);
                }
            } catch (Exception unused) {
            }
        } else if (fVar != null) {
            fVar.onLoginLinkify(context);
        }
    }

    public static x a(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deepLink");
        f fVar = l;
        if (fVar == null) {
            return null;
        }
        fVar.onDispatchDeeplink(context, str);
        return x.f47997a;
    }

    public static Application x() {
        Application application = f34266a;
        if (application == null) {
            k.a("application");
        }
        return application;
    }

    public static void a(e eVar) {
        k.c(eVar, "feedTabChangeListener");
        p = eVar;
    }

    public static void y() {
        p = null;
    }

    public static void b(e eVar) {
        k.c(eVar, "feedTabChangeListener");
        q = eVar;
    }

    public static void z() {
        q = null;
    }

    public static boolean b(String str) {
        k.c(str, "deepLink");
        return k.a((Object) str, (Object) "feed") && m != null;
    }

    public static void b(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deepLink");
        FeedCommentActivity.a aVar = FeedCommentActivity.f34935e;
        k.c(context, "context");
        k.c(str, "deepLink");
        Intent intent = new Intent(context, FeedCommentActivity.class);
        intent.putExtra("deepLink", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void A() {
        f fVar = l;
        if (fVar != null) {
            fVar.collapseAppBar();
        }
    }

    public static void B() {
        f fVar = l;
        if (fVar != null) {
            fVar.expandAppBar();
        }
    }

    public static boolean C() {
        if (!s || !t) {
            return s && u;
        }
        return true;
    }

    public static void b(Context context, Map<String, ? extends Object> map) {
        k.c(context, "context");
        k.c(map, "eventMap");
        a aVar = w;
        if (aVar != null) {
            aVar.sendEvent(context, map);
        }
    }

    public static void b(Context context) {
        k.c(context, "context");
        f fVar = l;
        if (fVar != null) {
            fVar.getUserData(context);
        }
    }

    public static void c(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deepLink");
        f fVar = l;
        if (fVar != null) {
            fVar.onDispatchDeeplink(context, str);
        }
    }

    public static void a(ArrayList<FeedItem> arrayList) {
        k.c(arrayList, "promoList");
        F = arrayList;
    }

    public static void c(Context context) {
        k.c(context, "context");
        u uVar = u.f35438a;
        if (!u.a()) {
            net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
            if (net.one97.paytm.feed.utility.j.e(context)) {
                f fVar = l;
                if (fVar == null) {
                    try {
                        Class<?> cls = Class.forName("net.one97.paytm.AJRProfileActivity");
                        k.a((Object) cls, "Class.forName(activityToStart)");
                        Application application = f34266a;
                        if (application == null) {
                            k.a("application");
                        }
                        if (application.getApplicationContext() != null) {
                            Application application2 = f34266a;
                            if (application2 == null) {
                                k.a("application");
                            }
                            Intent intent = new Intent(application2.getApplicationContext(), cls);
                            intent.addFlags(268435456);
                            Application application3 = f34266a;
                            if (application3 == null) {
                                k.a("application");
                            }
                            application3.getApplicationContext().startActivity(intent);
                        }
                    } catch (Exception unused) {
                    }
                } else if (fVar != null) {
                    fVar.onEditProfileClicked(context);
                }
            }
        }
    }

    public static void d(Context context) {
        k.c(context, "context");
        c cVar = c.f34275a;
        if (c.a(context)) {
            u uVar = u.f35438a;
            if (!u.a()) {
                net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
                if (net.one97.paytm.feed.utility.j.e(context)) {
                    ProfileActivity.a aVar = ProfileActivity.f35247b;
                    k.c(context, "context");
                    net.one97.paytm.feed.utility.j jVar2 = net.one97.paytm.feed.utility.j.f35397a;
                    if (net.one97.paytm.feed.utility.j.e(context)) {
                        Intent intent = new Intent(context, ProfileActivity.class);
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                        return;
                    }
                    Toast.makeText(context, R.string.feed_no_internet, 0).show();
                }
            }
        }
    }

    public static void e(Context context) {
        k.c(context, "context");
        c cVar = c.f34275a;
        if (c.a(context)) {
            u uVar = u.f35438a;
            if (!u.a()) {
                net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
                if (net.one97.paytm.feed.utility.j.e(context)) {
                    Intent intent = new Intent(context, ProfileDiscoverActivity.class);
                    net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
                    net.one97.paytm.feed.b.a(0);
                    intent.putExtra("discover_type", net.one97.paytm.feed.utility.c.a());
                    context.startActivity(intent);
                }
            }
        }
    }

    public static void f(Context context) {
        k.c(context, "context");
        c cVar = c.f34275a;
        if (c.a(context)) {
            u uVar = u.f35438a;
            if (!u.a()) {
                net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
                if (net.one97.paytm.feed.utility.j.e(context)) {
                    Intent intent = new Intent(context, ProfileDiscoverActivity.class);
                    net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
                    net.one97.paytm.feed.b.b(0);
                    intent.putExtra("discover_type", net.one97.paytm.feed.utility.c.b());
                    context.startActivity(intent);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        f fVar;
        k.c(str, "deepLinkUrl");
        k.c(str2, "matchId");
        k.c(str3, "postId");
        if (context != null && (fVar = l) != null) {
            fVar.loadH5Container(context, str, str2, str3);
        }
    }

    public static void d(Context context, String str) {
        f fVar;
        k.c(str, "deepLinkUrl");
        if (context != null && (fVar = l) != null) {
            c cVar = c.f34275a;
            fVar.loadH5Container(context, str, c.g());
        }
    }

    public static boolean D() {
        return f34266a != null;
    }

    public static void a(String str, List<Options> list) {
        k.c(str, "pollsId");
        k.c(list, "options");
        HashMap<String, List<Options>> hashMap = f34267b;
        if (hashMap != null) {
            if (hashMap == null) {
                k.a("pollsMap");
            }
            hashMap.put(str, list);
            return;
        }
        HashMap<String, List<Options>> hashMap2 = new HashMap<>();
        f34267b = hashMap2;
        hashMap2.put(str, list);
    }

    public static List<Options> c(String str) {
        k.c(str, "pollsId");
        HashMap<String, List<Options>> hashMap = f34267b;
        if (hashMap == null) {
            return null;
        }
        if (hashMap == null) {
            k.a("pollsMap");
        }
        return hashMap.get(str);
    }

    public static void d(boolean z2) {
        K = z2;
    }

    public static void e(boolean z2) {
        L = z2;
    }

    public static StoryData a(StoryData storyData) {
        k.c(storyData, "storyData");
        if (f34271f == null) {
            f34271f = storyData;
        } else {
            int size = storyData.getStoryList().size();
            StoryData storyData2 = f34271f;
            if (storyData2 == null) {
                k.a();
            }
            int size2 = storyData2.getStoryList().size();
            if (size > size2) {
                StoryData storyData3 = f34271f;
                if (storyData3 == null) {
                    k.a();
                }
                kotlin.a.k.c(storyData3.getStoryList()).addAll(storyData.getStoryList().subList(size2, size));
            }
        }
        StoryData storyData4 = f34271f;
        if (storyData4 == null) {
            k.a();
        }
        return storyData4;
    }

    public static void d(int i2) {
        "updating stories data with story card position".concat(String.valueOf(i2));
        TreeSet<Integer> treeSet = f34272g;
        if (treeSet != null && f34271f != null) {
            if (treeSet == null) {
                k.a();
            }
            StoryData storyData = f34271f;
            if (storyData == null) {
                k.a();
            }
            ArrayList arrayList = new ArrayList(storyData.getStoryList());
            for (int size = treeSet.size() - 1; size >= 0; size--) {
                TreeSet<Integer> treeSet2 = f34272g;
                if (treeSet2 == null) {
                    k.a();
                }
                arrayList.add((Stories) arrayList.remove(((Number) kotlin.a.k.a(treeSet2, size)).intValue()));
            }
            StoryData storyData2 = new StoryData(arrayList);
            storyData2.setFeedItemType(net.one97.paytm.feed.utility.k.STORIES.getType());
            StoryData storyData3 = f34271f;
            if (storyData3 == null) {
                k.a();
            }
            storyData2.setFeedItemRank(storyData3.getFeedItemRank());
            StoryData storyData4 = f34271f;
            if (storyData4 == null) {
                k.a();
            }
            storyData2.setPid(storyData4.getPid());
            StoryData storyData5 = f34271f;
            if (storyData5 == null) {
                k.a();
            }
            storyData2.setMlVersion(storyData5.getMlVersion());
            StoryData storyData6 = f34271f;
            if (storyData6 == null) {
                k.a();
            }
            storyData2.setScore(storyData6.getScore());
            StoryData storyData7 = f34271f;
            if (storyData7 == null) {
                k.a();
            }
            storyData2.setContentFormat(storyData7.getContentFormat());
            StoryData storyData8 = f34271f;
            if (storyData8 == null) {
                k.a();
            }
            storyData2.setMlCategory(storyData8.getMlCategory());
            f34271f = storyData2;
            f34269d = i2;
            f34270e = true;
        }
    }

    public static final /* synthetic */ void E() {
        c cVar = c.f34275a;
        JSONArray jSONArray = new JSONArray(p.a((CharSequence) c.h(), new String[]{AppConstants.COMMA}).toString());
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        String jSONArray2 = jSONArray.toString();
        k.a((Object) jSONArray2, "jsArray.toString()");
        net.one97.paytm.feed.c.a.a().a((Context) x(), jSONArray2, (kotlin.g.a.b<? super String, x>) d.INSTANCE);
    }
}
