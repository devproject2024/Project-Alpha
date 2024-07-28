package com.google.a.a.a;

import com.google.a.a.b.a.a.a.a.c;
import com.google.a.a.c.a.a;
import com.google.a.a.c.e;
import com.google.a.a.c.g;
import com.google.a.a.c.j;
import com.google.a.a.c.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

public final class t extends a {

    /* renamed from: b  reason: collision with root package name */
    private Object f7533b;

    public t(Object obj) {
        super(u.f7534a);
        this.f7533b = c.a(obj);
    }

    public final void a(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, (this.f7460a == null || this.f7460a.b() == null) ? e.f7564a : this.f7460a.b()));
        boolean z = true;
        for (Map.Entry next : g.b(this.f7533b).entrySet()) {
            Object value = next.getValue();
            if (value != null) {
                String a2 = a.a((String) next.getKey());
                Class<?> cls = value.getClass();
                if ((value instanceof Iterable) || cls.isArray()) {
                    for (Object a3 : v.a(value)) {
                        z = a(z, bufferedWriter, a2, a3);
                    }
                } else {
                    z = a(z, bufferedWriter, a2, value);
                }
            }
        }
        bufferedWriter.flush();
    }

    private static boolean a(boolean z, Writer writer, String str, Object obj) throws IOException {
        String str2;
        if (obj != null && !g.a(obj)) {
            if (z) {
                z = false;
            } else {
                writer.write(AppConstants.AND_SIGN);
            }
            writer.write(str);
            if (obj instanceof Enum) {
                str2 = j.a((Enum<?>) (Enum) obj).f7598c;
            } else {
                str2 = obj.toString();
            }
            String a2 = a.a(str2);
            if (a2.length() != 0) {
                writer.write("=");
                writer.write(a2);
            }
        }
        return z;
    }
}
