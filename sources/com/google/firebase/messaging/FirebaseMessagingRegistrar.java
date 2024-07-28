package com.google.firebase.messaging;

import com.google.android.datatransport.c;
import com.google.android.datatransport.e;
import com.google.android.datatransport.f;
import com.google.android.datatransport.g;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;

public class FirebaseMessagingRegistrar implements h {

    static class a<T> implements f<T> {
        private a() {
        }

        public final void a(c<T> cVar) {
        }

        public final void a(c<T> cVar, com.google.android.datatransport.h hVar) {
            hVar.a((Exception) null);
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static class b implements g {
        public final <T> f<T> a(String str, com.google.android.datatransport.b bVar, e<T, byte[]> eVar) {
            return new a((byte) 0);
        }
    }

    public List<com.google.firebase.components.b<?>> getComponents() {
        return Arrays.asList(new com.google.firebase.components.b[]{com.google.firebase.components.b.a(FirebaseMessaging.class).a(n.b(com.google.firebase.c.class)).a(n.b(FirebaseInstanceId.class)).a(n.b(com.google.firebase.e.h.class)).a(n.b(com.google.firebase.b.c.class)).a(n.a(g.class)).a(n.b(com.google.firebase.installations.g.class)).a(h.f39010a).a(1).a(), com.google.firebase.e.g.a("fire-fcm", "20.1.7_1p")});
    }

    static g determineFactory(g gVar) {
        if (gVar != null) {
            com.google.android.datatransport.cct.a aVar = com.google.android.datatransport.cct.a.f7642e;
            if (com.google.android.datatransport.cct.a.f7640c.contains(com.google.android.datatransport.b.a("json"))) {
                return gVar;
            }
        }
        return new b();
    }

    static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(com.google.firebase.components.e eVar) {
        return new FirebaseMessaging((com.google.firebase.c) eVar.a(com.google.firebase.c.class), (FirebaseInstanceId) eVar.a(FirebaseInstanceId.class), (com.google.firebase.e.h) eVar.a(com.google.firebase.e.h.class), (com.google.firebase.b.c) eVar.a(com.google.firebase.b.c.class), (com.google.firebase.installations.g) eVar.a(com.google.firebase.installations.g.class), determineFactory((g) eVar.a(g.class)));
    }
}
