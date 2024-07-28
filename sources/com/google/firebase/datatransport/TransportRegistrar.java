package com.google.firebase.datatransport;

import android.content.Context;
import com.google.android.datatransport.g;
import com.google.firebase.components.b;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import java.util.Collections;
import java.util.List;

public class TransportRegistrar implements h {
    public List<b<?>> getComponents() {
        return Collections.singletonList(b.a(g.class).a(n.b(Context.class)).a(a.a()).a());
    }
}
