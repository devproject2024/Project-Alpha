package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.Type;

public final class t implements at {

    /* renamed from: a  reason: collision with root package name */
    public static final t f6334a = new t();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj == null) {
            ahVar.f6266a.write("null");
        } else if (ahVar.b(bb.WriteEnumUsingToString)) {
            ahVar.a(((Enum) obj).toString());
        } else {
            baVar.a(((Enum) obj).ordinal());
        }
    }
}
