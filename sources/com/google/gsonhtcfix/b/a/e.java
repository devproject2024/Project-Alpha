package com.google.gsonhtcfix.b.a;

import com.google.gsonhtcfix.d.c;
import com.google.gsonhtcfix.i;
import com.google.gsonhtcfix.l;
import com.google.gsonhtcfix.n;
import com.google.gsonhtcfix.o;
import com.google.gsonhtcfix.s;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class e extends c {

    /* renamed from: f  reason: collision with root package name */
    private static final Writer f39656f = new Writer() {
        public final void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }

        public final void flush() throws IOException {
            throw new AssertionError();
        }

        public final void close() throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static final s f39657g = new s("closed");

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f39658a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public l f39659b = n.f39822a;

    /* renamed from: h  reason: collision with root package name */
    private String f39660h;

    public final void flush() throws IOException {
    }

    public e() {
        super(f39656f);
    }

    private l f() {
        List<l> list = this.f39658a;
        return list.get(list.size() - 1);
    }

    private void a(l lVar) {
        if (this.f39660h != null) {
            if (!(lVar instanceof n) || this.f39792e) {
                ((o) f()).a(this.f39660h, lVar);
            }
            this.f39660h = null;
        } else if (this.f39658a.isEmpty()) {
            this.f39659b = lVar;
        } else {
            l f2 = f();
            if (f2 instanceof i) {
                ((i) f2).a(lVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final c a() throws IOException {
        i iVar = new i();
        a((l) iVar);
        this.f39658a.add(iVar);
        return this;
    }

    public final c b() throws IOException {
        if (this.f39658a.isEmpty() || this.f39660h != null) {
            throw new IllegalStateException();
        } else if (f() instanceof i) {
            List<l> list = this.f39658a;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final c c() throws IOException {
        o oVar = new o();
        a((l) oVar);
        this.f39658a.add(oVar);
        return this;
    }

    public final c d() throws IOException {
        if (this.f39658a.isEmpty() || this.f39660h != null) {
            throw new IllegalStateException();
        } else if (f() instanceof o) {
            List<l> list = this.f39658a;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final c a(String str) throws IOException {
        if (this.f39658a.isEmpty() || this.f39660h != null) {
            throw new IllegalStateException();
        } else if (f() instanceof o) {
            this.f39660h = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final c b(String str) throws IOException {
        if (str == null) {
            return e();
        }
        a((l) new s(str));
        return this;
    }

    public final c e() throws IOException {
        a((l) n.f39822a);
        return this;
    }

    public final c a(boolean z) throws IOException {
        a((l) new s(Boolean.valueOf(z)));
        return this;
    }

    public final c a(long j) throws IOException {
        a((l) new s((Number) Long.valueOf(j)));
        return this;
    }

    public final c a(Number number) throws IOException {
        if (number == null) {
            return e();
        }
        if (!this.f39790c) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(String.valueOf(number)));
            }
        }
        a((l) new s(number));
        return this;
    }

    public final void close() throws IOException {
        if (this.f39658a.isEmpty()) {
            this.f39658a.add(f39657g);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
