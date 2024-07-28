package com.google.gsonhtcfix.b.a;

import com.google.gsonhtcfix.d.a;
import com.google.gsonhtcfix.d.b;
import com.google.gsonhtcfix.i;
import com.google.gsonhtcfix.n;
import com.google.gsonhtcfix.o;
import com.google.gsonhtcfix.s;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d extends a {

    /* renamed from: c  reason: collision with root package name */
    private static final Reader f39653c = new Reader() {
        public final int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }

        public final void close() throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final Object f39654d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final List<Object> f39655a;

    public final void a() throws IOException {
        a(b.BEGIN_ARRAY);
        this.f39655a.add(((i) g()).iterator());
    }

    public final void b() throws IOException {
        a(b.END_ARRAY);
        p();
        p();
    }

    public final void c() throws IOException {
        a(b.BEGIN_OBJECT);
        this.f39655a.add(((o) g()).f39823a.entrySet().iterator());
    }

    public final void d() throws IOException {
        a(b.END_OBJECT);
        p();
        p();
    }

    public final boolean e() throws IOException {
        b f2 = f();
        return (f2 == b.END_OBJECT || f2 == b.END_ARRAY) ? false : true;
    }

    public final b f() throws IOException {
        while (!this.f39655a.isEmpty()) {
            Object g2 = g();
            if (g2 instanceof Iterator) {
                List<Object> list = this.f39655a;
                boolean z = list.get(list.size() - 2) instanceof o;
                Iterator it2 = (Iterator) g2;
                if (!it2.hasNext()) {
                    return z ? b.END_OBJECT : b.END_ARRAY;
                }
                if (z) {
                    return b.NAME;
                }
                this.f39655a.add(it2.next());
            } else if (g2 instanceof o) {
                return b.BEGIN_OBJECT;
            } else {
                if (g2 instanceof i) {
                    return b.BEGIN_ARRAY;
                }
                if (g2 instanceof s) {
                    s sVar = (s) g2;
                    if (sVar.f39825a instanceof String) {
                        return b.STRING;
                    }
                    if (sVar.f39825a instanceof Boolean) {
                        return b.BOOLEAN;
                    }
                    if (sVar.f39825a instanceof Number) {
                        return b.NUMBER;
                    }
                    throw new AssertionError();
                } else if (g2 instanceof n) {
                    return b.NULL;
                } else {
                    if (g2 == f39654d) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
            }
        }
        return b.END_DOCUMENT;
    }

    public final Object g() {
        List<Object> list = this.f39655a;
        return list.get(list.size() - 1);
    }

    private Object p() {
        List<Object> list = this.f39655a;
        return list.remove(list.size() - 1);
    }

    public final void a(b bVar) throws IOException {
        if (f() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + f());
        }
    }

    public final String h() throws IOException {
        a(b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) g()).next();
        this.f39655a.add(entry.getValue());
        return (String) entry.getKey();
    }

    public final String i() throws IOException {
        b f2 = f();
        if (f2 == b.STRING || f2 == b.NUMBER) {
            return ((s) p()).b();
        }
        throw new IllegalStateException("Expected " + b.STRING + " but was " + f2);
    }

    public final boolean j() throws IOException {
        a(b.BOOLEAN);
        return ((s) p()).f();
    }

    public final void k() throws IOException {
        a(b.NULL);
        p();
    }

    public final double l() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            double c2 = ((s) g()).c();
            if (this.f39780b || (!Double.isNaN(c2) && !Double.isInfinite(c2))) {
                p();
                return c2;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: ".concat(String.valueOf(c2)));
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2);
    }

    public final long m() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            long d2 = ((s) g()).d();
            p();
            return d2;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2);
    }

    public final int n() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            int e2 = ((s) g()).e();
            p();
            return e2;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2);
    }

    public final void close() throws IOException {
        this.f39655a.clear();
        this.f39655a.add(f39654d);
    }

    public final void o() throws IOException {
        if (f() == b.NAME) {
            h();
        } else {
            p();
        }
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
