package net.one97.paytm.upgradeKyc.helper;

import kotlin.g.b.k;
import net.one97.paytm.upgradeKyc.helper.e;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66026a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static d f66027b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d a() {
            if (d.f66027b == null) {
                d.f66027b = new d();
            }
            return d.f66027b;
        }
    }

    public static String a(String str) {
        k.c(str, "key");
        e.a aVar = e.f66028b;
        String a2 = e.a.b().a(str);
        return a2 == null ? "" : a2;
    }

    public static int b(String str) {
        k.c(str, "key");
        e.a aVar = e.f66028b;
        return e.a.b().b(str);
    }

    public static boolean a(String str, boolean z) {
        k.c(str, "key");
        e.a aVar = e.f66028b;
        return e.a.b().a(str, z);
    }
}
