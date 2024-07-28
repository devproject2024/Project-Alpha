package com.alibaba.a.c;

import com.alibaba.a.a;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

public final class p implements at {

    /* renamed from: a  reason: collision with root package name */
    public static final p f6329a = new p();

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        ba baVar = ahVar.f6266a;
        if (obj == null) {
            baVar.write("null");
            return;
        }
        String pattern = ((SimpleDateFormat) obj).toPattern();
        if (!baVar.b(bb.WriteClassName) || obj.getClass() == type) {
            baVar.b(pattern);
            return;
        }
        baVar.a('{');
        baVar.a(a.DEFAULT_TYPE_KEY, false);
        ahVar.a(obj.getClass().getName());
        if (!baVar.b(bb.QuoteFieldNames)) {
            baVar.a(',');
            baVar.a("val", false);
            if (pattern == null) {
                baVar.write("null");
            } else {
                baVar.b(pattern);
            }
        } else if (baVar.b(bb.UseSingleQuotes)) {
            baVar.a(',');
            baVar.a("val", false);
            if (pattern == null) {
                baVar.write("null");
            } else {
                baVar.b(pattern);
            }
        } else if (baVar.b(bb.BrowserCompatible)) {
            baVar.a(',');
            baVar.a("val", ':');
            baVar.a(pattern, 0);
        } else {
            baVar.a("val", pattern);
        }
        baVar.a('}');
    }
}
