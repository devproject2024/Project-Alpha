package net.one97.paytm.feed.events;

import android.content.Context;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import net.one97.paytm.feed.b;
import net.one97.paytm.feed.c.a;
import net.one97.paytm.feed.e.c;
import net.one97.paytm.feed.events.b.a;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static long f34343a;

    /* renamed from: b  reason: collision with root package name */
    public static long f34344b;

    /* renamed from: c  reason: collision with root package name */
    public static long f34345c;

    /* renamed from: d  reason: collision with root package name */
    public static final f f34346d = new f();

    /* renamed from: e  reason: collision with root package name */
    private static long f34347e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f34348f;

    private f() {
    }

    public static long a() {
        return f34343a;
    }

    public static void a(long j) {
        f34343a = j;
    }

    public static long b() {
        return f34344b;
    }

    public static void b(long j) {
        f34344b = j;
    }

    public static long c() {
        return f34345c;
    }

    public static void c(long j) {
        f34345c = j;
    }

    public static boolean d() {
        return f34348f;
    }

    public static void e() {
        f34348f = false;
    }

    public static void f() {
        f34348f = true;
        l();
        UUID randomUUID = UUID.randomUUID();
        c cVar = c.f34275a;
        String uuid = randomUUID.toString();
        k.a((Object) uuid, "uniqueID.toString()");
        c.a(uuid);
        b bVar = b.f33792d;
        b.w();
    }

    public static void g() {
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.a(System.currentTimeMillis());
        net.one97.paytm.feed.repository.b bVar2 = net.one97.paytm.feed.repository.b.f34608a;
        net.one97.paytm.feed.repository.b.i();
    }

    public static void a(Context context) {
        StringBuilder sb = new StringBuilder("TIME :: EXIT :L ");
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        sb.append(net.one97.paytm.feed.e.b.j());
        sb.append("Current time is :: ");
        sb.append(System.currentTimeMillis());
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        StringBuilder sb2 = new StringBuilder("TIME Delta is ");
        TimeUnit timeUnit = TimeUnit.MINUTES;
        long currentTimeMillis = System.currentTimeMillis();
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        sb2.append(timeUnit.convert(currentTimeMillis - net.one97.paytm.feed.e.b.j(), TimeUnit.MILLISECONDS));
        net.one97.paytm.feed.e.b bVar4 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        TimeUnit timeUnit2 = TimeUnit.MINUTES;
        long currentTimeMillis2 = System.currentTimeMillis();
        net.one97.paytm.feed.e.b bVar5 = net.one97.paytm.feed.e.b.f34268c;
        if (timeUnit2.convert(currentTimeMillis2 - net.one97.paytm.feed.e.b.j(), TimeUnit.MILLISECONDS) >= 30) {
            f34348f = true;
            net.one97.paytm.feed.e.b bVar6 = net.one97.paytm.feed.e.b.f34268c;
            net.one97.paytm.feed.e.b.k();
            f();
            try {
                a aVar = a.f34255a;
                a.a();
                net.one97.paytm.feed.repository.a.b.b(context);
            } catch (Exception unused) {
            }
            l();
        }
        net.one97.paytm.feed.repository.b bVar7 = net.one97.paytm.feed.repository.b.f34608a;
        b bVar8 = b.f33792d;
        net.one97.paytm.feed.repository.b.d(b.j());
    }

    private static void k() {
        net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
        "time in Minutes :: ".concat(String.valueOf((int) TimeUnit.MINUTES.convert(f34345c, TimeUnit.MILLISECONDS)));
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        int convert = (int) TimeUnit.SECONDS.convert(f34345c, TimeUnit.MILLISECONDS);
        "time in seconds :: ".concat(String.valueOf(convert));
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        net.one97.paytm.feed.repository.b.c(convert);
    }

    private static void l() {
        f34343a = 0;
        f34344b = 0;
        f34345c = 0;
        f34347e = 0;
        StringBuilder sb = new StringBuilder("RESET ::  ");
        net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
        sb.append(net.one97.paytm.feed.repository.b.h());
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        net.one97.paytm.feed.repository.b bVar3 = net.one97.paytm.feed.repository.b.f34608a;
        if (net.one97.paytm.feed.repository.b.h() != 0) {
            net.one97.paytm.feed.repository.b bVar4 = net.one97.paytm.feed.repository.b.f34608a;
            if (net.one97.paytm.feed.repository.b.h() < 86400) {
                net.one97.paytm.feed.events.a.a aVar = net.one97.paytm.feed.events.a.a.f34296a;
                net.one97.paytm.feed.repository.b bVar5 = net.one97.paytm.feed.repository.b.f34608a;
                net.one97.paytm.feed.events.a.a.a("v2_feed_session_time", String.valueOf(net.one97.paytm.feed.repository.b.h()));
                a aVar2 = a.f34284a;
                a.C0560a aVar3 = net.one97.paytm.feed.events.b.a.f34338a;
                String c2 = net.one97.paytm.feed.events.b.a.f34341e;
                net.one97.paytm.feed.repository.b bVar6 = net.one97.paytm.feed.repository.b.f34608a;
                long h2 = (long) net.one97.paytm.feed.repository.b.h();
                b bVar7 = b.f33792d;
                a.a(c2, 0, h2, 0, b.j());
            }
        }
        net.one97.paytm.feed.repository.b bVar8 = net.one97.paytm.feed.repository.b.f34608a;
        net.one97.paytm.feed.repository.b.c(0);
    }

    public static void h() {
        f34343a = System.currentTimeMillis();
    }

    public static void i() {
        f34345c += System.currentTimeMillis() - f34343a;
        j();
    }

    public static void j() {
        f34343a = 0;
        f34344b = 0;
        k();
    }
}
