package net.one97.paytm.appManager.b;

import android.content.Context;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.h;
import kotlin.x;
import net.one97.paytm.appManager.storage.a.a;
import net.one97.paytm.appManager.storage.db.AppManagerDb;

public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final a f49032f = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static SoftReference<HashSet<net.one97.paytm.appManager.a.a>> f49033i = new SoftReference<>(new HashSet());

    /* renamed from: a  reason: collision with root package name */
    private final g f49034a = h.a(C0864b.INSTANCE);

    /* renamed from: b  reason: collision with root package name */
    private final g f49035b = h.a(new c(this));

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.appManager.storage.db.a f49036c;

    /* renamed from: d  reason: collision with root package name */
    public AppManagerDb f49037d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f49038e;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final com.google.firebase.remoteconfig.a f49039g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, Object> f49040h;

    public final a c() {
        return (a) this.f49035b.getValue();
    }

    public b(Context context, com.google.firebase.remoteconfig.a aVar, Map<String, ? extends Object> map) {
        k.c(context, "context");
        k.c(aVar, "mFirebaseRemoteConfig");
        k.c(map, "coreAppKeys");
        this.f49038e = context;
        this.f49039g = aVar;
        this.f49040h = map;
    }

    /* renamed from: net.one97.paytm.appManager.b.b$b  reason: collision with other inner class name */
    static final class C0864b extends l implements kotlin.g.a.a<net.one97.paytm.appManager.storage.a.a> {
        public static final C0864b INSTANCE = new C0864b();

        C0864b() {
            super(0);
        }

        public final net.one97.paytm.appManager.storage.a.a invoke() {
            a.C0865a aVar = net.one97.paytm.appManager.storage.a.a.f49048b;
            return a.C0865a.a();
        }
    }

    static final class c extends l implements kotlin.g.a.a<a> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(0);
            this.this$0 = bVar;
        }

        public final a invoke() {
            return new a(this.this$0.f49038e, b.b(this.this$0), this.this$0.f49039g, this.this$0.f49040h);
        }
    }

    public final String a(String str, String str2) {
        k.c(str, "key");
        return c().a(str, str2);
    }

    public final Integer a(String str, Integer num) {
        k.c(str, "key");
        return c().a(str, num);
    }

    public final Long a(String str, Long l) {
        k.c(str, "key");
        return c().a(str, l);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(boolean z) {
            synchronized (b.f49033i) {
                a aVar = b.f49032f;
                HashSet<net.one97.paytm.appManager.a.a> hashSet = (HashSet) b.f49033i.get();
                if (hashSet != null) {
                    if (hashSet != null) {
                        for (net.one97.paytm.appManager.a.a a2 : hashSet) {
                            a2.a(z);
                        }
                    }
                    x xVar = x.f47997a;
                }
            }
        }

        public static void a() {
            synchronized (b.f49033i) {
                a aVar = b.f49032f;
                HashSet hashSet = (HashSet) b.f49033i.get();
                if (hashSet != null) {
                    if (hashSet != null) {
                        Iterator it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                    }
                    x xVar = x.f47997a;
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.appManager.storage.a.a b(b bVar) {
        return (net.one97.paytm.appManager.storage.a.a) bVar.f49034a.getValue();
    }
}
