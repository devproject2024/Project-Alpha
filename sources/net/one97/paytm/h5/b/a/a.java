package net.one97.paytm.h5.b.a;

import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.c.b;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16919a = new a();

    private a() {
    }

    public static final b a(String str) {
        k.c(str, "environment");
        switch (str.hashCode()) {
            case 99349:
                if (str.equals("dev")) {
                    return new b();
                }
                break;
            case 111267:
                if (str.equals("pre")) {
                    return new c();
                }
                break;
            case 113886:
                if (str.equals("sit")) {
                    return new e();
                }
                break;
            case 3449687:
                if (str.equals("prod")) {
                    return new d();
                }
                break;
        }
        return new d();
    }
}
