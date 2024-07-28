package com.alibaba.a.c;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

public final class s implements at {

    /* renamed from: a  reason: collision with root package name */
    public static final s f6332a = new s();

    /* renamed from: b  reason: collision with root package name */
    private DecimalFormat f6333b = null;

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        String str;
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            double doubleValue = ((Double) obj).doubleValue();
            if (Double.isNaN(doubleValue)) {
                baVar.write("null");
            } else if (Double.isInfinite(doubleValue)) {
                baVar.write("null");
            } else {
                DecimalFormat decimalFormat = this.f6333b;
                if (decimalFormat == null) {
                    str = Double.toString(doubleValue);
                    if (str.endsWith(".0")) {
                        str = str.substring(0, str.length() - 2);
                    }
                } else {
                    str = decimalFormat.format(doubleValue);
                }
                baVar.append((CharSequence) str);
                if (ahVar.b(bb.WriteClassName)) {
                    baVar.a('D');
                }
            }
        } else if (ahVar.b(bb.WriteNullNumberAsZero)) {
            baVar.a('0');
        } else {
            baVar.write("null");
        }
    }
}
