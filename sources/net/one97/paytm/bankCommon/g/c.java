package net.one97.paytm.bankCommon.g;

import com.paytm.utility.b;
import net.one97.paytm.bankOpen.f;

public final class c {
    public static c a() {
        return new c();
    }

    public static void a(f fVar) {
        if (fVar instanceof a) {
            ((a) fVar).a();
        } else if (fVar instanceof b) {
            ((b) fVar).a();
        }
    }

    public static void b(f fVar) {
        a aVar = (a) fVar;
        if (b.c(f.a().getApplicationContext()) && aVar.f16263a != null) {
            aVar.f16263a.b();
        }
    }
}
