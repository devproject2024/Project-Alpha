package defpackage;

import android.content.Context;
import common.landing.c.a.a;
import common.landing.c.a.a.a;
import common.landing.c.a.a.b;
import common.landing.c.a.b;
import common.landing.c.a.b.a;
import common.landing.c.a.b.b;
import kotlin.g.b.k;

/* renamed from: a  reason: default package */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f13404a = new a();

    private a() {
    }

    public static common.landing.c.a.a a(Context context) {
        k.c(context, "context");
        a.C0182a aVar = common.landing.c.a.a.f13480b;
        a.C0183a aVar2 = common.landing.c.a.a.a.f13484a;
        k.c(context, "context");
        common.landing.c.a.a.a a2 = common.landing.c.a.a.a.f13485c;
        if (a2 == null) {
            a2 = new common.landing.c.a.a.a(context);
            common.landing.c.a.a.a.f13485c = a2;
        }
        a.C0184a aVar3 = common.landing.c.a.b.a.f13494b;
        k.c(context, "context");
        common.landing.c.a.b.a a3 = common.landing.c.a.b.a.f13495c;
        if (a3 == null) {
            a3 = new common.landing.c.a.b.a(context);
            common.landing.c.a.b.a.f13495c = a3;
        }
        k.c(a2, "categoryLocalDataSource");
        k.c(a3, "categoryRemoteDataSource");
        common.landing.c.a.a a4 = common.landing.c.a.a.f13481d;
        if (a4 != null) {
            return a4;
        }
        common.landing.c.a.a aVar4 = new common.landing.c.a.a(a2, a3);
        common.landing.c.a.a.f13481d = aVar4;
        return aVar4;
    }

    public static b b(Context context) {
        k.c(context, "context");
        b.a aVar = b.f13490b;
        b.a aVar2 = common.landing.c.a.a.b.f13487a;
        k.c(context, "context");
        common.landing.c.a.a.b a2 = common.landing.c.a.a.b.f13488c;
        if (a2 == null) {
            a2 = new common.landing.c.a.a.b(context);
            common.landing.c.a.a.b.f13488c = a2;
        }
        b.a aVar3 = common.landing.c.a.b.b.f13497b;
        k.c(context, "context");
        common.landing.c.a.b.b a3 = common.landing.c.a.b.b.f13498c;
        if (a3 == null) {
            a3 = new common.landing.c.a.b.b(context);
            common.landing.c.a.b.b.f13498c = a3;
        }
        k.c(a2, "insuranceBuyPayOptionLocalDataSource");
        k.c(a3, "insuranceBuyPayOptionRemoteDataSource");
        common.landing.c.a.b a4 = common.landing.c.a.b.f13491d;
        if (a4 != null) {
            return a4;
        }
        common.landing.c.a.b bVar = new common.landing.c.a.b(a2, a3);
        common.landing.c.a.b.f13491d = bVar;
        return bVar;
    }
}
