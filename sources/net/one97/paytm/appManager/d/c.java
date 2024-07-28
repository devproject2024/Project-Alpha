package net.one97.paytm.appManager.d;

import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f49045a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f49046b;

    /* renamed from: c  reason: collision with root package name */
    private static String f49047c = "release";

    private c() {
    }

    public static void a(boolean z) {
        f49046b = z;
    }

    public static boolean a() {
        return f49046b;
    }

    public static void a(String str) {
        k.c(str, "<set-?>");
        f49047c = str;
    }

    public static long b() {
        return TimeUnit.MINUTES.toMillis(1);
    }
}
