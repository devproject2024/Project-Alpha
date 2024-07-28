package net.one97.paytm.phoenix.util;

import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f59658a = {y.a((v) new w(y.b(q.class), "hashMap", "getHashMap()Ljava/util/HashMap;"))};

    /* renamed from: b  reason: collision with root package name */
    public static final q f59659b = new q();

    /* renamed from: c  reason: collision with root package name */
    private static final g f59660c = h.a(a.INSTANCE);

    public static HashMap<String, String> a() {
        return (HashMap) f59660c.getValue();
    }

    private q() {
    }

    static final class a extends l implements kotlin.g.a.a<HashMap<String, String>> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final HashMap<String, String> invoke() {
            return new HashMap<>();
        }
    }
}
