package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.a.d;
import com.google.firebase.analytics.connector.a;
import com.google.firebase.c;
import com.google.firebase.components.b;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import com.google.firebase.e.g;
import java.util.Arrays;
import java.util.List;

public class AnalyticsConnectorRegistrar implements h {
    public List<b<?>> getComponents() {
        return Arrays.asList(new b[]{b.a(a.class).a(n.b(c.class)).a(n.b(Context.class)).a(n.b(d.class)).a(a.f37976a).a(2).a(), g.a("fire-analytics", "17.2.1")});
    }
}
