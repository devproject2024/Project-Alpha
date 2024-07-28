package com.google.firebase.remoteconfig;

import android.content.Context;
import com.google.firebase.abt.component.a;
import com.google.firebase.c;
import com.google.firebase.components.b;
import com.google.firebase.components.e;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.installations.g;
import java.util.Arrays;
import java.util.List;

public class RemoteConfigRegistrar implements h {
    public List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(o.class).a(n.b(Context.class)).a(n.b(c.class)).a(n.b(g.class)).a(n.b(a.class)).a(n.a(com.google.firebase.analytics.connector.a.class)).a(s.a()).a(2).a(), com.google.firebase.e.g.a("fire-rc", "19.2.0")});
    }

    static /* synthetic */ o lambda$getComponents$0(e eVar) {
        return new o((Context) eVar.a(Context.class), (c) eVar.a(c.class), (g) eVar.a(g.class), ((a) eVar.a(a.class)).a("frc"), (com.google.firebase.analytics.connector.a) eVar.a(com.google.firebase.analytics.connector.a.class));
    }
}
