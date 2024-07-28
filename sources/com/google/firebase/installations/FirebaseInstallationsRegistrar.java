package com.google.firebase.installations;

import com.google.firebase.c;
import com.google.firebase.components.b;
import com.google.firebase.components.e;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.e.g;
import java.util.Arrays;
import java.util.List;

public class FirebaseInstallationsRegistrar implements h {
    public List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(g.class).a(n.b(c.class)).a(n.b(com.google.firebase.b.c.class)).a(n.b(com.google.firebase.e.h.class)).a(i.a()).a(), g.a("fire-installations", "16.3.3")});
    }

    static /* synthetic */ g lambda$getComponents$0(e eVar) {
        return new c((c) eVar.a(c.class), (com.google.firebase.e.h) eVar.a(com.google.firebase.e.h.class), (com.google.firebase.b.c) eVar.a(com.google.firebase.b.c.class));
    }
}
