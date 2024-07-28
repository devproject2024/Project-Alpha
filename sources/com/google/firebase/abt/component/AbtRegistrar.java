package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.components.b;
import com.google.firebase.components.e;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.e.g;
import java.util.Arrays;
import java.util.List;

public class AbtRegistrar implements h {
    public List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(a.class).a(n.b(Context.class)).a(n.a(a.class)).a(b.a()).a(), g.a("fire-abt", "19.1.0")});
    }

    static /* synthetic */ a lambda$getComponents$0(e eVar) {
        return new a((Context) eVar.a(Context.class), (a) eVar.a(a.class));
    }
}
