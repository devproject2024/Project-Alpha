package net.one97.paytm.n;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Activity f55743a;

    /* renamed from: b  reason: collision with root package name */
    public Fragment f55744b;

    /* renamed from: c  reason: collision with root package name */
    public b f55745c;

    /* renamed from: d  reason: collision with root package name */
    public a f55746d;

    public c(b bVar, Activity activity) {
        k.c(bVar, "listener");
        k.c(activity, "activity");
        this.f55745c = bVar;
        this.f55743a = activity;
    }

    public c(b bVar, Fragment fragment) {
        k.c(bVar, "listener");
        k.c(fragment, "fragment");
        this.f55745c = bVar;
        this.f55744b = fragment;
    }

    public static final class a extends a {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c f55747f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f55748g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f55749h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar, String str, String str2, Activity activity, b bVar, String str3) {
            super(activity, bVar, str3);
            this.f55747f = cVar;
            this.f55748g = str;
            this.f55749h = str2;
        }

        public final boolean b() {
            String str = this.f55748g;
            return str != null ? a.a(str) : super.b();
        }
    }

    public final void a(String str, String str2) {
        c cVar = this;
        if (cVar.f55743a != null) {
            Activity activity = this.f55743a;
            if (activity == null) {
                k.a("activity");
            }
            this.f55746d = new a(this, str2, str, activity, this.f55745c, str);
        } else if (cVar.f55744b != null) {
            Fragment fragment = this.f55744b;
            if (fragment == null) {
                k.a("fragment");
            }
            this.f55746d = new b(this, str2, str, fragment, this.f55745c, str);
        }
        if (cVar.f55746d != null) {
            a aVar = this.f55746d;
            if (aVar == null) {
                k.a("controller");
            }
            aVar.a();
        }
    }

    public static final class b extends a {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c f55750f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f55751g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f55752h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, String str, String str2, Fragment fragment, b bVar, String str3) {
            super(fragment, bVar, str3);
            this.f55750f = cVar;
            this.f55751g = str;
            this.f55752h = str2;
        }

        public final boolean b() {
            String str = this.f55751g;
            return str != null ? a.a(str) : super.b();
        }
    }

    /* renamed from: net.one97.paytm.n.c$c  reason: collision with other inner class name */
    public static final class C1041c extends a {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c f55753f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f55754g = null;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f55755h = null;

        /* JADX WARNING: type inference failed for: r1v0, types: [net.one97.paytm.n.c, java.lang.String] */
        /* JADX WARNING: type inference failed for: r2v0, types: [net.one97.paytm.n.b, android.app.Activity] */
        /* JADX WARNING: type inference failed for: r3v0, types: [net.one97.paytm.n.b, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C1041c(java.lang.String r1, net.one97.paytm.n.b r2, java.lang.String r3) {
            /*
                r0 = this;
                r0.f55753f = r1
                r1 = 0
                r0.f55754g = r1
                r0.f55755h = r1
                r0.<init>((android.app.Activity) r2, (net.one97.paytm.n.b) r3, (java.lang.String) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.n.c.C1041c.<init>(net.one97.paytm.n.c, android.app.Activity, net.one97.paytm.n.b):void");
        }

        public final boolean b() {
            String str = this.f55754g;
            return str != null ? a.a(str) : super.b();
        }
    }

    public static final class d extends a {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ c f55756f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f55757g = null;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f55758h = null;

        /* JADX WARNING: type inference failed for: r1v0, types: [net.one97.paytm.n.c, java.lang.String] */
        /* JADX WARNING: type inference failed for: r2v0, types: [androidx.fragment.app.Fragment, net.one97.paytm.n.b] */
        /* JADX WARNING: type inference failed for: r3v0, types: [net.one97.paytm.n.b, java.lang.String] */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public d(java.lang.String r1, net.one97.paytm.n.b r2, java.lang.String r3) {
            /*
                r0 = this;
                r0.f55756f = r1
                r1 = 0
                r0.f55757g = r1
                r0.f55758h = r1
                r0.<init>((androidx.fragment.app.Fragment) r2, (net.one97.paytm.n.b) r3, (java.lang.String) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.n.c.d.<init>(net.one97.paytm.n.c, androidx.fragment.app.Fragment, net.one97.paytm.n.b):void");
        }

        public final boolean b() {
            String str = this.f55757g;
            return str != null ? a.a(str) : super.b();
        }
    }

    public final void a(int i2, int i3) {
        if (this.f55746d != null) {
            a aVar = this.f55746d;
            if (aVar == null) {
                k.a("controller");
            }
            f fVar = aVar.f55738e;
            if (fVar != null) {
                fVar.a(i2, i3);
            }
        }
    }
}
