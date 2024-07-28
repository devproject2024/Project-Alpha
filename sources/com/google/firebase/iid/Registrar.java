package com.google.firebase.iid;

import com.google.firebase.a.d;
import com.google.firebase.c;
import com.google.firebase.components.b;
import com.google.firebase.components.e;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.installations.g;
import java.util.Arrays;
import java.util.List;

public final class Registrar implements h {
    public final List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(FirebaseInstanceId.class).a(n.b(c.class)).a(n.b(d.class)).a(n.b(com.google.firebase.e.h.class)).a(n.b(com.google.firebase.b.c.class)).a(n.b(g.class)).a(ag.f38799a).a(1).a(), b.a(com.google.firebase.iid.internal.a.class).a(n.b(FirebaseInstanceId.class)).a(ah.f38800a).a(), com.google.firebase.e.g.a("fire-iid", "20.2.3")});
    }

    static class a implements com.google.firebase.iid.internal.a {

        /* renamed from: a  reason: collision with root package name */
        final FirebaseInstanceId f38786a;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.f38786a = firebaseInstanceId;
        }

        public final String a() {
            return this.f38786a.d();
        }
    }

    static final /* synthetic */ com.google.firebase.iid.internal.a lambda$getComponents$1$Registrar(e eVar) {
        return new a((FirebaseInstanceId) eVar.a(FirebaseInstanceId.class));
    }

    static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(e eVar) {
        return new FirebaseInstanceId((c) eVar.a(c.class), (d) eVar.a(d.class), (com.google.firebase.e.h) eVar.a(com.google.firebase.e.h.class), (com.google.firebase.b.c) eVar.a(com.google.firebase.b.c.class), (g) eVar.a(g.class));
    }
}
