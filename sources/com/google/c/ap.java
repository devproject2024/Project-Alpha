package com.google.c;

import com.google.c.am;
import java.util.Map;

final class ap implements ao {
    ap() {
    }

    public final Map<?, ?> a(Object obj) {
        return (an) obj;
    }

    public final am.a<?, ?> e(Object obj) {
        return ((am) obj).f37722a;
    }

    public final Map<?, ?> b(Object obj) {
        return (an) obj;
    }

    public final boolean c(Object obj) {
        return !((an) obj).isMutable();
    }

    public final Object d(Object obj) {
        ((an) obj).makeImmutable();
        return obj;
    }

    public final Object a() {
        return an.emptyMapField().mutableCopy();
    }

    public final Object a(Object obj, Object obj2) {
        an anVar = (an) obj;
        an anVar2 = (an) obj2;
        if (!anVar2.isEmpty()) {
            if (!anVar.isMutable()) {
                anVar = anVar.mutableCopy();
            }
            anVar.mergeFrom(anVar2);
        }
        return anVar;
    }

    public final int a(int i2, Object obj, Object obj2) {
        an anVar = (an) obj;
        am amVar = (am) obj2;
        int i3 = 0;
        if (anVar.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : anVar.entrySet()) {
            i3 += m.l(i2) + m.q(am.a(amVar.f37722a, entry.getKey(), entry.getValue()));
        }
        return i3;
    }
}
