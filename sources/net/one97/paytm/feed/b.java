package net.one97.paytm.feed;

import kotlin.g.b.k;
import kotlin.m;
import net.one97.paytm.feed.ui.feed.FeedFragment;

public final class b {
    private static int A = 1;
    private static int B = -200;
    private static int C = -1;
    private static int D = -200;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f33789a;

    /* renamed from: b  reason: collision with root package name */
    public static int f33790b;

    /* renamed from: c  reason: collision with root package name */
    public static int f33791c;

    /* renamed from: d  reason: collision with root package name */
    public static final b f33792d = new b();

    /* renamed from: e  reason: collision with root package name */
    private static int f33793e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static int f33794f = -200;

    /* renamed from: g  reason: collision with root package name */
    private static String f33795g = "";

    /* renamed from: h  reason: collision with root package name */
    private static int f33796h = -200;

    /* renamed from: i  reason: collision with root package name */
    private static int f33797i = -200;
    private static boolean j;
    private static int k;
    private static int l;
    private static int m = -1;
    private static int n = 1;
    private static String o = "";
    private static int p;
    private static long q;
    private static long r;
    private static String s = "LASTSAVED";
    private static int t = -1;
    private static int u = -200;
    private static int v = -200;
    private static String w = "";
    private static int x;
    private static int y = -1;
    private static int z;

    static {
        f33790b = -1;
        f33791c = -200;
        net.one97.paytm.feed.repository.b bVar = net.one97.paytm.feed.repository.b.f34608a;
        f33790b = net.one97.paytm.feed.repository.b.e();
        net.one97.paytm.feed.repository.b bVar2 = net.one97.paytm.feed.repository.b.f34608a;
        f33791c = net.one97.paytm.feed.repository.b.d();
        StringBuilder sb = new StringBuilder("current from pref topRank : ");
        sb.append(f33791c);
        sb.append(" bottomRank : ");
        sb.append(f33790b);
        net.one97.paytm.feed.e.b bVar3 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
    }

    private b() {
    }

    public static void a(boolean z2) {
        f33789a = z2;
    }

    public static String a() {
        return f33795g;
    }

    public static void a(String str) {
        k.c(str, "<set-?>");
        f33795g = str;
    }

    public static boolean b() {
        return j;
    }

    public static void c() {
        j = true;
    }

    public static int d() {
        return k;
    }

    public static void e() {
        k = 0;
    }

    public static void a(int i2) {
        l = i2;
    }

    public static int f() {
        return l;
    }

    public static int g() {
        return m;
    }

    public static int h() {
        return n;
    }

    public static String i() {
        return o;
    }

    public static void b(int i2) {
        p = i2;
    }

    public static int j() {
        return p;
    }

    public static void a(long j2) {
        q = j2;
    }

    public static void b(long j2) {
        r = j2;
    }

    public static String k() {
        return s;
    }

    public static String l() {
        return w;
    }

    public static int m() {
        return x;
    }

    public static void n() {
        x = 0;
    }

    public static int o() {
        return y;
    }

    public static void c(int i2) {
        z = i2;
    }

    public static int p() {
        return z;
    }

    public static void b(String str) {
        k.c(str, "requestCode");
        o = str;
        "current requestCode : ".concat(String.valueOf(str));
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
    }

    public static void d(int i2) {
        m = k;
        k = i2;
        new StringBuilder("current NextPageNumber : ").append(m);
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
    }

    public static void e(int i2) {
        n = i2;
        "current FeedTotalPageCount : ".concat(String.valueOf(i2));
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
    }

    public static int q() {
        boolean z2 = f33789a;
        if (z2) {
            int i2 = f33791c;
            f33791c = i2 + 1;
            return i2;
        } else if (!z2) {
            int i3 = f33790b;
            f33790b = i3 + 1;
            return i3;
        } else {
            throw new m();
        }
    }

    public static void f(int i2) {
        int i3 = f33797i - i2;
        f33791c = i3;
        f33797i = i3;
    }

    public static void g(int i2) {
        int i3 = D - i2;
        B = i3;
        D = i3;
    }

    public static int r() {
        boolean z2 = f33789a;
        if (z2) {
            int i2 = f33794f;
            f33794f = i2 + 1;
            return i2;
        } else if (!z2) {
            int i3 = f33793e;
            f33793e = i3 + 1;
            return i3;
        } else {
            throw new m();
        }
    }

    public static int s() {
        boolean z2 = f33789a;
        if (z2) {
            int i2 = u;
            u = i2 + 1;
            return i2;
        } else if (!z2) {
            int i3 = t;
            t = i3 + 1;
            return i3;
        } else {
            throw new m();
        }
    }

    public static int t() {
        boolean z2 = f33789a;
        if (z2) {
            int i2 = B;
            B = i2 + 1;
            return i2;
        } else if (!z2) {
            int i3 = C;
            C = i3 + 1;
            return i3;
        } else {
            throw new m();
        }
    }

    public static void h(int i2) {
        int i3 = v - i2;
        u = i3;
        v = i3;
    }

    public static String u() {
        long j2 = q;
        if (j2 == 0) {
            return "";
        }
        return String.valueOf(j2);
    }

    public static String v() {
        long j2 = r;
        if (j2 == 0) {
            return "";
        }
        return String.valueOf(j2);
    }

    public static void w() {
        n = 1;
        o = "";
        p = 0;
        FeedFragment.a aVar = FeedFragment.f34877i;
        f33795g = FeedFragment.z;
        q = 0;
        r = 0;
    }

    public static void c(String str) {
        k.c(str, "requestCode");
        w = str;
        "current requestCode : ".concat(String.valueOf(str));
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
    }

    public static void i(int i2) {
        y = x;
        x = i2;
    }

    public static void j(int i2) {
        A = i2;
    }
}
