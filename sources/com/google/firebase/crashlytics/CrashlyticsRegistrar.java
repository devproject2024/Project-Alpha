package com.google.firebase.crashlytics;

import com.google.firebase.c;
import com.google.firebase.components.b;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.e.g;
import com.google.firebase.iid.internal.a;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsRegistrar implements h {
    public List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(c.class).a(n.b(c.class)).a(n.d(a.class)).a(n.a(com.google.firebase.analytics.connector.a.class)).a(n.a(com.google.firebase.crashlytics.a.a.class)).a(new b(this)).a(2).a(), g.a("fire-cls", "17.1.0")});
    }
}
