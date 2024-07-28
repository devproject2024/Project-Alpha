package net.one97.paytm.feed.events;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.feed.events.models.BaseEventDTO;
import net.one97.paytm.feed.events.models.FeedEventModel;
import net.one97.paytm.feed.events.models.FeedEventNames;
import net.one97.paytm.feed.events.models.FeedScrolledItem;
import net.one97.paytm.feed.events.models.FeedUserAction;
import net.one97.paytm.feed.events.models.FeedUserActionMetaInfo;
import net.one97.paytm.feed.events.models.FeedUserScrolled;
import net.one97.paytm.feed.events.models.FeedUserScrolledMetaInfo;
import net.one97.paytm.feed.events.models.FeedUserSessionMetaInfo;
import net.one97.paytm.feed.events.models.FeedUserViewed;
import net.one97.paytm.feed.events.models.FeedUserViewedMetaInfo;
import net.one97.paytm.feed.events.models.FollowMetaInfo;
import net.one97.paytm.feed.events.models.MetaInfo;
import net.one97.paytm.feed.repository.models.FeedItem;
import net.one97.paytm.feed.utility.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f34284a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<BaseEventDTO> f34285b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<Integer, Long> f34286c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<Integer, Integer> f34287d = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static String f34288e = "";

    /* renamed from: f  reason: collision with root package name */
    private static FeedUserViewed f34289f;

    /* renamed from: g  reason: collision with root package name */
    private static long f34290g;

    /* renamed from: h  reason: collision with root package name */
    private static long f34291h;

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
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
                a aVar = a.f34284a;
                a.a((ArrayList<BaseEventDTO>) new ArrayList());
            }
        }
    }

    static final class h extends l implements kotlin.g.a.b<String, x> {
        public static final h INSTANCE = new h();

        h() {
            super(1);
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
            }
        }
    }

    private a() {
    }

    public static ArrayList<BaseEventDTO> a() {
        return f34285b;
    }

    public static void a(ArrayList<BaseEventDTO> arrayList) {
        k.c(arrayList, "<set-?>");
        f34285b = arrayList;
    }

    public static void a(FeedUserViewed feedUserViewed) {
        f34289f = feedUserViewed;
    }

    public static void b() {
        j jVar = j.f35397a;
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        Context applicationContext = net.one97.paytm.feed.e.b.g().getApplicationContext();
        k.a((Object) applicationContext, "FeedManager.application.applicationContext");
        f34288e = j.d(applicationContext);
    }

    public static void a(long j) {
        f34290g = j;
    }

    public static long c() {
        return f34290g;
    }

    public static void b(long j) {
        f34291h = j;
    }

    public static long d() {
        return f34291h;
    }

    public static int e() {
        return (int) (f34291h - f34290g);
    }

    public static void a(int i2, long j) {
        f34286c.put(Integer.valueOf(i2), Long.valueOf(j));
    }

    public static void a(int i2, int i3) {
        f34287d.put(Integer.valueOf(i2), Integer.valueOf(i3));
        StringBuilder sb = new StringBuilder("state = ");
        sb.append(i2);
        sb.append(" : index = ");
        sb.append(i3);
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
    }

    public static String c(long j) {
        if (j == 0) {
            return "";
        }
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return net.one97.paytm.feed.utility.d.a((CharSequence) "yyyy-MM-dd'T'HH:mm:ss.ssz", (Calendar) gregorianCalendar).toString();
    }

    public static void a(Context context) {
        k.c(context, "context");
        j jVar = j.f35397a;
        if (j.e(context)) {
            try {
                if (!f34285b.isEmpty()) {
                    String b2 = new com.google.gson.f().b(new FeedEventModel(f34285b));
                    StringBuilder sb = new StringBuilder();
                    net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                    String h2 = net.one97.paytm.feed.e.b.h();
                    if (h2 == null) {
                        k.a();
                    }
                    sb.append(h2);
                    sb.append("/content-events/v1/events");
                    sb.append(b2);
                    net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                    net.one97.paytm.feed.e.b.k();
                    net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
                    net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
                    net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                    Context applicationContext = net.one97.paytm.feed.e.b.x().getApplicationContext();
                    k.a((Object) applicationContext, "FeedManager.getAppApplication().applicationContext");
                    net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                    String h3 = net.one97.paytm.feed.e.b.h();
                    if (h3 == null) {
                        k.a();
                    }
                    k.a((Object) b2, "jsonString");
                    a2.a(applicationContext, "/content-events/v1/events", h3, b2, (kotlin.g.a.b<? super String, x>) d.INSTANCE);
                }
            } catch (Exception unused) {
                net.one97.paytm.feed.e.b bVar5 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
            }
        }
    }

    public static void a(String str, FeedItem feedItem, String str2, String str3) {
        Context applicationContext;
        k.c(str, "eventName");
        k.c(feedItem, "feedItem");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.D()) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            Application g2 = net.one97.paytm.feed.e.b.g();
            if (g2 != null && (applicationContext = g2.getApplicationContext()) != null) {
                j jVar = j.f35397a;
                if (j.e(applicationContext)) {
                    new Thread(new c(applicationContext, feedItem, str2, str3, str)).start();
                }
            }
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34321a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedItem f34322b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34323c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f34324d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f34325e;

        c(Context context, FeedItem feedItem, String str, String str2, String str3) {
            this.f34321a = context;
            this.f34322b = feedItem;
            this.f34323c = str;
            this.f34324d = str2;
            this.f34325e = str3;
        }

        public final void run() {
            try {
                Double valueOf = Double.valueOf(this.f34322b.getScore());
                String buckets = this.f34322b.getBuckets();
                String contentFormat = this.f34322b.getContentFormat();
                String mlCategory = this.f34322b.getMlCategory();
                String feedItemType = this.f34322b.getFeedItemType();
                net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                String g2 = net.one97.paytm.feed.e.c.g();
                net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
                String valueOf2 = String.valueOf(net.one97.paytm.feed.e.c.e());
                net.one97.paytm.feed.e.c cVar3 = net.one97.paytm.feed.e.c.f34275a;
                String valueOf3 = String.valueOf(net.one97.paytm.feed.e.c.f());
                j jVar = j.f35397a;
                String a2 = j.a();
                a aVar = a.f34284a;
                String f2 = a.f34288e;
                j jVar2 = j.f35397a;
                String a3 = j.a(this.f34321a);
                j jVar3 = j.f35397a;
                Integer valueOf4 = Integer.valueOf(j.b());
                j jVar4 = j.f35397a;
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                Context applicationContext = net.one97.paytm.feed.e.b.g().getApplicationContext();
                k.a((Object) applicationContext, "FeedManager.application.applicationContext");
                String b2 = j.b(applicationContext);
                j jVar5 = j.f35397a;
                String str = buckets;
                FeedUserActionMetaInfo feedUserActionMetaInfo = new FeedUserActionMetaInfo(a2, g2, f2, a3, valueOf2, valueOf3, valueOf4, b2, "", "", j.c(), valueOf, mlCategory, str, contentFormat, feedItemType, this.f34322b.getMlVersion(), this.f34323c, this.f34324d);
                ArrayList arrayList = new ArrayList();
                String pid = this.f34322b.getPid();
                String str2 = this.f34325e;
                net.one97.paytm.feed.e.c cVar4 = net.one97.paytm.feed.e.c.f34275a;
                String i2 = net.one97.paytm.feed.e.c.i();
                a aVar2 = a.f34284a;
                String c2 = a.c(System.currentTimeMillis());
                net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
                arrayList.add(new FeedUserAction(pid, i2, str2, (String) null, net.one97.paytm.feed.b.a(), feedUserActionMetaInfo, c2));
                String b3 = new com.google.gson.f().b(new FeedEventModel(arrayList));
                net.one97.paytm.feed.c.a aVar3 = net.one97.paytm.feed.c.a.f34255a;
                net.one97.paytm.feed.repository.a.b a4 = net.one97.paytm.feed.c.a.a();
                net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                Context applicationContext2 = net.one97.paytm.feed.e.b.x().getApplicationContext();
                k.a((Object) applicationContext2, "FeedManager.getAppApplication().applicationContext");
                net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                String h2 = net.one97.paytm.feed.e.b.h();
                if (h2 == null) {
                    k.a();
                }
                k.a((Object) b3, "jsonString");
                a4.a(applicationContext2, "/content-events/v1/events", h2, b3, (kotlin.g.a.b<? super String, x>) c.INSTANCE);
            } catch (Exception unused) {
                net.one97.paytm.feed.e.b bVar5 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
            }
        }
    }

    public static void a(String str, int i2, String str2, long j) {
        Context applicationContext;
        k.c(str, "eventName");
        k.c(str2, "providerName");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.D()) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            Application g2 = net.one97.paytm.feed.e.b.g();
            if (g2 != null && (applicationContext = g2.getApplicationContext()) != null) {
                j jVar = j.f35397a;
                if (j.e(applicationContext)) {
                    new Thread(new b(applicationContext, i2, str2, j, str)).start();
                }
            }
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34298a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f34299b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f34300c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f34301d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f34302e;

        b(Context context, int i2, String str, long j, String str2) {
            this.f34298a = context;
            this.f34299b = i2;
            this.f34300c = str;
            this.f34301d = j;
            this.f34302e = str2;
        }

        public final void run() {
            try {
                net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                String g2 = net.one97.paytm.feed.e.c.g();
                net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
                String valueOf = String.valueOf(net.one97.paytm.feed.e.c.e());
                net.one97.paytm.feed.e.c cVar3 = net.one97.paytm.feed.e.c.f34275a;
                String valueOf2 = String.valueOf(net.one97.paytm.feed.e.c.f());
                j jVar = j.f35397a;
                String a2 = j.a();
                a aVar = a.f34284a;
                String f2 = a.f34288e;
                j jVar2 = j.f35397a;
                String a3 = j.a(this.f34298a);
                j jVar3 = j.f35397a;
                Integer valueOf3 = Integer.valueOf(j.b());
                j jVar4 = j.f35397a;
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                Context applicationContext = net.one97.paytm.feed.e.b.g().getApplicationContext();
                k.a((Object) applicationContext, "FeedManager.application.applicationContext");
                String b2 = j.b(applicationContext);
                j jVar5 = j.f35397a;
                FollowMetaInfo followMetaInfo = new FollowMetaInfo(a2, g2, f2, a3, valueOf, valueOf2, valueOf3, b2, "", "", j.c(), this.f34299b, this.f34300c, Long.valueOf(this.f34301d));
                ArrayList arrayList = new ArrayList();
                String str = this.f34302e;
                net.one97.paytm.feed.e.c cVar4 = net.one97.paytm.feed.e.c.f34275a;
                String i2 = net.one97.paytm.feed.e.c.i();
                a aVar2 = a.f34284a;
                String c2 = a.c(System.currentTimeMillis());
                net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
                arrayList.add(new FeedUserAction((String) null, i2, str, (String) null, net.one97.paytm.feed.b.a(), followMetaInfo, c2));
                String b3 = new com.google.gson.f().b(new FeedEventModel(arrayList));
                net.one97.paytm.feed.c.a aVar3 = net.one97.paytm.feed.c.a.f34255a;
                net.one97.paytm.feed.repository.a.b a4 = net.one97.paytm.feed.c.a.a();
                net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                Context applicationContext2 = net.one97.paytm.feed.e.b.x().getApplicationContext();
                k.a((Object) applicationContext2, "FeedManager.getAppApplication().applicationContext");
                net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                String h2 = net.one97.paytm.feed.e.b.h();
                if (h2 == null) {
                    k.a();
                }
                k.a((Object) b3, "jsonString");
                a4.a(applicationContext2, "/content-events/v1/events", h2, b3, (kotlin.g.a.b<? super String, x>) b.INSTANCE);
            } catch (Exception unused) {
                net.one97.paytm.feed.e.b bVar5 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
            }
        }
    }

    public static void a(String str, long j, long j2, long j3, int i2) {
        Context applicationContext;
        String str2 = str;
        k.c(str, "eventName");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.D()) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            Application g2 = net.one97.paytm.feed.e.b.g();
            if (g2 != null && (applicationContext = g2.getApplicationContext()) != null) {
                j jVar = j.f35397a;
                if (j.e(applicationContext)) {
                    new Thread(new g(applicationContext, j, j2, i2, j3, str)).start();
                }
            }
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34332a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f34333b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f34334c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f34335d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f34336e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f34337f;

        g(Context context, long j, long j2, int i2, long j3, String str) {
            this.f34332a = context;
            this.f34333b = j;
            this.f34334c = j2;
            this.f34335d = i2;
            this.f34336e = j3;
            this.f34337f = str;
        }

        public final void run() {
            try {
                net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                String g2 = net.one97.paytm.feed.e.c.g();
                net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
                String valueOf = String.valueOf(net.one97.paytm.feed.e.c.e());
                net.one97.paytm.feed.e.c cVar3 = net.one97.paytm.feed.e.c.f34275a;
                String valueOf2 = String.valueOf(net.one97.paytm.feed.e.c.f());
                j jVar = j.f35397a;
                String a2 = j.a();
                a aVar = a.f34284a;
                String f2 = a.f34288e;
                j jVar2 = j.f35397a;
                String a3 = j.a(this.f34332a);
                j jVar3 = j.f35397a;
                Integer valueOf3 = Integer.valueOf(j.b());
                j jVar4 = j.f35397a;
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                Context applicationContext = net.one97.paytm.feed.e.b.g().getApplicationContext();
                k.a((Object) applicationContext, "FeedManager.application.applicationContext");
                String b2 = j.b(applicationContext);
                j jVar5 = j.f35397a;
                boolean c2 = j.c();
                a aVar2 = a.f34284a;
                String c3 = a.c(this.f34333b);
                String valueOf4 = String.valueOf(this.f34334c);
                int i2 = this.f34335d;
                a aVar3 = a.f34284a;
                FeedUserSessionMetaInfo feedUserSessionMetaInfo = new FeedUserSessionMetaInfo(a2, g2, f2, a3, valueOf, valueOf2, valueOf3, b2, "", "", c2, c3, valueOf4, i2, a.c(this.f34336e));
                ArrayList arrayList = new ArrayList();
                String str = this.f34337f;
                net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
                String a4 = net.one97.paytm.feed.b.a();
                net.one97.paytm.feed.e.c cVar4 = net.one97.paytm.feed.e.c.f34275a;
                String i3 = net.one97.paytm.feed.e.c.i();
                a aVar4 = a.f34284a;
                arrayList.add(new net.one97.paytm.feed.events.b.a(i3, str, a4, feedUserSessionMetaInfo, a.c(System.currentTimeMillis())));
                String b3 = new com.google.gson.f().b(new FeedEventModel(arrayList));
                net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                if (TextUtils.isEmpty(net.one97.paytm.feed.e.b.h())) {
                    net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                    net.one97.paytm.feed.repository.b bVar5 = net.one97.paytm.feed.repository.b.f34608a;
                    net.one97.paytm.feed.e.b.a(net.one97.paytm.feed.repository.b.g());
                }
                net.one97.paytm.feed.c.a aVar5 = net.one97.paytm.feed.c.a.f34255a;
                net.one97.paytm.feed.repository.a.b a5 = net.one97.paytm.feed.c.a.a();
                net.one97.paytm.feed.e.b bVar6 = net.one97.paytm.feed.e.b.f34268c;
                Context applicationContext2 = net.one97.paytm.feed.e.b.x().getApplicationContext();
                k.a((Object) applicationContext2, "FeedManager.getAppApplication().applicationContext");
                net.one97.paytm.feed.e.b bVar7 = net.one97.paytm.feed.e.b.f34268c;
                String h2 = net.one97.paytm.feed.e.b.h();
                if (h2 == null) {
                    k.a();
                }
                k.a((Object) b3, "jsonString");
                a5.a(applicationContext2, "/content-events/v1/events", h2, b3, (kotlin.g.a.b<? super String, x>) e.INSTANCE);
            } catch (Exception unused) {
                net.one97.paytm.feed.e.b bVar8 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
            }
        }
    }

    public static void a(int i2) {
        FeedUserViewed feedUserViewed = f34289f;
        if (feedUserViewed != null) {
            if (feedUserViewed == null) {
                k.a();
            }
            if (feedUserViewed.getMetaInfo() instanceof FeedUserViewedMetaInfo) {
                FeedUserViewed feedUserViewed2 = f34289f;
                if (feedUserViewed2 == null) {
                    k.a();
                }
                MetaInfo metaInfo = feedUserViewed2.getMetaInfo();
                if (metaInfo != null) {
                    ((FeedUserViewedMetaInfo) metaInfo).setDuration_msec(i2);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.feed.events.models.FeedUserViewedMetaInfo");
                }
            }
            ArrayList arrayList = new ArrayList();
            FeedUserViewed feedUserViewed3 = f34289f;
            if (feedUserViewed3 == null) {
                k.a();
            }
            arrayList.add(feedUserViewed3);
            String b2 = new com.google.gson.f().b(new FeedEventModel(arrayList));
            net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
            net.one97.paytm.feed.repository.a.b a2 = net.one97.paytm.feed.c.a.a();
            net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
            Context applicationContext = net.one97.paytm.feed.e.b.x().getApplicationContext();
            k.a((Object) applicationContext, "FeedManager.getAppApplication().applicationContext");
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            String h2 = net.one97.paytm.feed.e.b.h();
            if (h2 == null) {
                k.a();
            }
            k.a((Object) b2, "jsonString");
            a2.a(applicationContext, "/content-events/v1/events", h2, b2, (kotlin.g.a.b<? super String, x>) h.INSTANCE);
            f34289f = null;
        }
    }

    public static void a(FeedItem feedItem) {
        Context applicationContext;
        k.c(feedItem, "feedItem");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.D()) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            Application g2 = net.one97.paytm.feed.e.b.g();
            if (g2 != null && (applicationContext = g2.getApplicationContext()) != null) {
                j jVar = j.f35397a;
                if (j.e(applicationContext)) {
                    new Thread(new C0558a(applicationContext, feedItem)).start();
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.feed.events.a$a  reason: collision with other inner class name */
    static final class C0558a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34292a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedItem f34293b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f34294c = 0;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f34295d = 0;

        C0558a(Context context, FeedItem feedItem) {
            this.f34292a = context;
            this.f34293b = feedItem;
        }

        public final void run() {
            try {
                Double valueOf = Double.valueOf(this.f34293b.getScore());
                String buckets = this.f34293b.getBuckets();
                String contentFormat = this.f34293b.getContentFormat();
                String mlCategory = this.f34293b.getMlCategory();
                String feedItemType = this.f34293b.getFeedItemType();
                net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                String g2 = net.one97.paytm.feed.e.c.g();
                net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
                String valueOf2 = String.valueOf(net.one97.paytm.feed.e.c.e());
                net.one97.paytm.feed.e.c cVar3 = net.one97.paytm.feed.e.c.f34275a;
                String valueOf3 = String.valueOf(net.one97.paytm.feed.e.c.f());
                j jVar = j.f35397a;
                String a2 = j.a();
                a aVar = a.f34284a;
                String f2 = a.f34288e;
                j jVar2 = j.f35397a;
                String a3 = j.a(this.f34292a);
                j jVar3 = j.f35397a;
                Integer valueOf4 = Integer.valueOf(j.b());
                j jVar4 = j.f35397a;
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                Context applicationContext = net.one97.paytm.feed.e.b.g().getApplicationContext();
                k.a((Object) applicationContext, "FeedManager.application.applicationContext");
                String b2 = j.b(applicationContext);
                j jVar5 = j.f35397a;
                FeedUserViewedMetaInfo feedUserViewedMetaInfo = new FeedUserViewedMetaInfo(a2, g2, f2, a3, valueOf2, valueOf3, valueOf4, b2, "", "", j.c(), valueOf, mlCategory, buckets, contentFormat, feedItemType, this.f34293b.getMlVersion(), this.f34294c, Integer.valueOf(this.f34295d));
                String pid = this.f34293b.getPid();
                String feed_item_viewed = FeedEventNames.INSTANCE.getFEED_ITEM_VIEWED();
                net.one97.paytm.feed.e.c cVar4 = net.one97.paytm.feed.e.c.f34275a;
                String i2 = net.one97.paytm.feed.e.c.i();
                a aVar2 = a.f34284a;
                String c2 = a.c(System.currentTimeMillis());
                net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
                FeedUserViewed feedUserViewed = new FeedUserViewed(pid, i2, feed_item_viewed, (String) null, net.one97.paytm.feed.b.a(), feedUserViewedMetaInfo, c2);
                a aVar3 = a.f34284a;
                a.a(feedUserViewed);
            } catch (Exception unused) {
                net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
            }
        }
    }

    public static void a(FeedItem feedItem, int i2) {
        Context applicationContext;
        k.c(feedItem, "feedItem");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.D()) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            Application g2 = net.one97.paytm.feed.e.b.g();
            if (g2 != null && (applicationContext = g2.getApplicationContext()) != null) {
                j jVar = j.f35397a;
                if (j.e(applicationContext)) {
                    new Thread(new e(applicationContext, feedItem, i2)).start();
                }
            }
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34326a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FeedItem f34327b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f34328c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f34329d = 0;

        e(Context context, FeedItem feedItem, int i2) {
            this.f34326a = context;
            this.f34327b = feedItem;
            this.f34328c = i2;
        }

        public final void run() {
            try {
                Double valueOf = Double.valueOf(this.f34327b.getScore());
                String buckets = this.f34327b.getBuckets();
                String contentFormat = this.f34327b.getContentFormat();
                String mlCategory = this.f34327b.getMlCategory();
                String feedItemType = this.f34327b.getFeedItemType();
                net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                String g2 = net.one97.paytm.feed.e.c.g();
                net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
                String valueOf2 = String.valueOf(net.one97.paytm.feed.e.c.e());
                net.one97.paytm.feed.e.c cVar3 = net.one97.paytm.feed.e.c.f34275a;
                String valueOf3 = String.valueOf(net.one97.paytm.feed.e.c.f());
                j jVar = j.f35397a;
                String a2 = j.a();
                a aVar = a.f34284a;
                String f2 = a.f34288e;
                j jVar2 = j.f35397a;
                String a3 = j.a(this.f34326a);
                j jVar3 = j.f35397a;
                Integer valueOf4 = Integer.valueOf(j.b());
                j jVar4 = j.f35397a;
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                Context applicationContext = net.one97.paytm.feed.e.b.g().getApplicationContext();
                k.a((Object) applicationContext, "FeedManager.application.applicationContext");
                String b2 = j.b(applicationContext);
                j jVar5 = j.f35397a;
                FeedUserViewedMetaInfo feedUserViewedMetaInfo = new FeedUserViewedMetaInfo(a2, g2, f2, a3, valueOf2, valueOf3, valueOf4, b2, "", "", j.c(), valueOf, mlCategory, buckets, contentFormat, feedItemType, this.f34327b.getMlVersion(), this.f34328c, Integer.valueOf(this.f34329d));
                String pid = this.f34327b.getPid();
                String feed_item_viewed = FeedEventNames.INSTANCE.getFEED_ITEM_VIEWED();
                net.one97.paytm.feed.e.c cVar4 = net.one97.paytm.feed.e.c.f34275a;
                String i2 = net.one97.paytm.feed.e.c.i();
                a aVar2 = a.f34284a;
                String c2 = a.c(System.currentTimeMillis());
                net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
                FeedUserViewed feedUserViewed = new FeedUserViewed(pid, i2, feed_item_viewed, (String) null, net.one97.paytm.feed.b.a(), feedUserViewedMetaInfo, c2);
                ArrayList arrayList = new ArrayList();
                arrayList.add(feedUserViewed);
                String b3 = new com.google.gson.f().b(new FeedEventModel(arrayList));
                net.one97.paytm.feed.c.a aVar3 = net.one97.paytm.feed.c.a.f34255a;
                net.one97.paytm.feed.repository.a.b a4 = net.one97.paytm.feed.c.a.a();
                net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
                Context applicationContext2 = net.one97.paytm.feed.e.b.x().getApplicationContext();
                k.a((Object) applicationContext2, "FeedManager.getAppApplication().applicationContext");
                net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                String h2 = net.one97.paytm.feed.e.b.h();
                if (h2 == null) {
                    k.a();
                }
                k.a((Object) b3, "jsonString");
                a4.a(applicationContext2, "/content-events/v1/events", h2, b3, (kotlin.g.a.b<? super String, x>) d.INSTANCE);
            } catch (Exception unused) {
                net.one97.paytm.feed.e.b bVar5 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
            }
        }
    }

    public static void b(ArrayList<FeedItem> arrayList) {
        Context applicationContext;
        k.c(arrayList, "feedItems");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        if (net.one97.paytm.feed.e.b.D()) {
            net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
            Application g2 = net.one97.paytm.feed.e.b.g();
            if (g2 != null && (applicationContext = g2.getApplicationContext()) != null) {
                j jVar = j.f35397a;
                if (j.e(applicationContext)) {
                    new Thread(new f(applicationContext, arrayList)).start();
                }
            }
        }
    }

    static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f34330a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f34331b;

        f(Context context, ArrayList arrayList) {
            this.f34330a = context;
            this.f34331b = arrayList;
        }

        public final void run() {
            try {
                ArrayList arrayList = new ArrayList();
                a aVar = a.f34284a;
                Integer num = (Integer) a.f34287d.get(0);
                Integer num2 = null;
                Integer valueOf = num != null ? Integer.valueOf(num.intValue()) : null;
                a aVar2 = a.f34284a;
                Integer num3 = (Integer) a.f34287d.get(2);
                if (num3 != null) {
                    num2 = Integer.valueOf(num3.intValue());
                }
                if (valueOf != null && num2 != null) {
                    StringBuilder sb = new StringBuilder("from = ");
                    sb.append(valueOf);
                    sb.append(" : to = ");
                    sb.append(num2);
                    net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                    net.one97.paytm.feed.e.b.k();
                    if (k.a(valueOf.intValue(), num2.intValue()) < 0) {
                        int intValue = valueOf.intValue();
                        int intValue2 = num2.intValue();
                        if (intValue <= intValue2) {
                            while (true) {
                                arrayList.add(new FeedScrolledItem(Double.valueOf(((FeedItem) this.f34331b.get(intValue)).getScore()), ((FeedItem) this.f34331b.get(intValue)).getPid(), ((FeedItem) this.f34331b.get(intValue)).getBuckets(), ((FeedItem) this.f34331b.get(intValue)).getContentFormat(), ((FeedItem) this.f34331b.get(intValue)).getFeedItemType(), ((FeedItem) this.f34331b.get(intValue)).getMlVersion(), ((FeedItem) this.f34331b.get(intValue)).getMlCategory()));
                                if (intValue == intValue2) {
                                    break;
                                }
                                intValue++;
                            }
                        }
                    } else {
                        kotlin.j.d dVar = new kotlin.j.d(num2.intValue(), valueOf.intValue());
                        int i2 = dVar.f47939a;
                        int i3 = dVar.f47940b;
                        if (i2 <= i3) {
                            while (true) {
                                arrayList.add(new FeedScrolledItem(Double.valueOf(((FeedItem) this.f34331b.get(i2)).getScore()), ((FeedItem) this.f34331b.get(i2)).getPid(), ((FeedItem) this.f34331b.get(i2)).getBuckets(), ((FeedItem) this.f34331b.get(i2)).getContentFormat(), ((FeedItem) this.f34331b.get(i2)).getFeedItemType(), ((FeedItem) this.f34331b.get(i2)).getMlVersion(), ((FeedItem) this.f34331b.get(i2)).getMlCategory()));
                                if (i2 == i3) {
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                    net.one97.paytm.feed.e.c cVar = net.one97.paytm.feed.e.c.f34275a;
                    String g2 = net.one97.paytm.feed.e.c.g();
                    net.one97.paytm.feed.e.c cVar2 = net.one97.paytm.feed.e.c.f34275a;
                    String valueOf2 = String.valueOf(net.one97.paytm.feed.e.c.e());
                    net.one97.paytm.feed.e.c cVar3 = net.one97.paytm.feed.e.c.f34275a;
                    String valueOf3 = String.valueOf(net.one97.paytm.feed.e.c.f());
                    j jVar = j.f35397a;
                    String a2 = j.a();
                    a aVar3 = a.f34284a;
                    String f2 = a.f34288e;
                    j jVar2 = j.f35397a;
                    String a3 = j.a(this.f34330a);
                    j jVar3 = j.f35397a;
                    Integer valueOf4 = Integer.valueOf(j.b());
                    j jVar4 = j.f35397a;
                    net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
                    Context applicationContext = net.one97.paytm.feed.e.b.g().getApplicationContext();
                    k.a((Object) applicationContext, "FeedManager.application.applicationContext");
                    String b2 = j.b(applicationContext);
                    j jVar5 = j.f35397a;
                    FeedUserScrolledMetaInfo feedUserScrolledMetaInfo = new FeedUserScrolledMetaInfo(a2, g2, f2, a3, valueOf2, valueOf3, valueOf4, b2, "", "", j.c(), arrayList);
                    String feed_scroll = FeedEventNames.INSTANCE.getFEED_SCROLL();
                    net.one97.paytm.feed.e.c cVar4 = net.one97.paytm.feed.e.c.f34275a;
                    String i4 = net.one97.paytm.feed.e.c.i();
                    a aVar4 = a.f34284a;
                    String c2 = a.c(System.currentTimeMillis());
                    net.one97.paytm.feed.b bVar3 = net.one97.paytm.feed.b.f33792d;
                    FeedUserScrolled feedUserScrolled = new FeedUserScrolled(i4, feed_scroll, (String) null, net.one97.paytm.feed.b.a(), feedUserScrolledMetaInfo, c2);
                    a aVar5 = a.f34284a;
                    a.a().add(feedUserScrolled);
                }
            } catch (Exception unused) {
                net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.k();
            }
        }
    }
}
