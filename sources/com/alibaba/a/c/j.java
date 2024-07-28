package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.Type;

public final class j implements at {

    /* renamed from: a  reason: collision with root package name */
    public static j f6323a = new j();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            baVar.b(new String((char[]) obj));
        } else if (baVar.b(bb.WriteNullListAsEmpty)) {
            baVar.write("[]");
        } else {
            baVar.write("null");
        }
    }
}
