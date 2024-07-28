package net.one97.paytm.wallet.newdesign.nearby.helper;

import kotlin.g.b.k;
import net.one97.paytm.wallet.newdesign.nearby.helper.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f71128a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static c f71129b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a() {
            if (c.f71129b == null) {
                c.f71129b = new c();
            }
            return c.f71129b;
        }
    }

    public static String a(String str) {
        k.c(str, "key");
        d.a aVar = d.f71130b;
        String a2 = d.a.b().a(str);
        return a2 == null ? "" : a2;
    }

    public static boolean b(String str) {
        k.c(str, "key");
        d.a aVar = d.f71130b;
        return d.a.b().b(str);
    }
}
