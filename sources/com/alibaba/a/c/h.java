package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.Type;

public final class h implements at {

    /* renamed from: a  reason: collision with root package name */
    public static h f6321a = new h();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            baVar.a((byte[]) obj);
        } else if (baVar.b(bb.WriteNullListAsEmpty)) {
            baVar.write("[]");
        } else {
            baVar.write("null");
        }
    }
}
