package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.r;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class d extends JsonWriter {

    /* renamed from: a  reason: collision with root package name */
    private static final Writer f39558a = new Writer() {
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

    /* renamed from: b  reason: collision with root package name */
    private static final r f39559b = new r("closed");

    /* renamed from: c  reason: collision with root package name */
    private final List<l> f39560c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private String f39561d;

    /* renamed from: e  reason: collision with root package name */
    private l f39562e = n.f39635a;

    public final void flush() throws IOException {
    }

    public d() {
        super(f39558a);
    }

    public final l a() {
        if (this.f39560c.isEmpty()) {
            return this.f39562e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f39560c);
    }

    private l b() {
        List<l> list = this.f39560c;
        return list.get(list.size() - 1);
    }

    private void a(l lVar) {
        if (this.f39561d != null) {
            if (!(lVar instanceof n) || getSerializeNulls()) {
                ((o) b()).a(this.f39561d, lVar);
            }
            this.f39561d = null;
        } else if (this.f39560c.isEmpty()) {
            this.f39562e = lVar;
        } else {
            l b2 = b();
            if (b2 instanceof i) {
                ((i) b2).a(lVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final JsonWriter beginArray() throws IOException {
        i iVar = new i();
        a(iVar);
        this.f39560c.add(iVar);
        return this;
    }

    public final JsonWriter endArray() throws IOException {
        if (this.f39560c.isEmpty() || this.f39561d != null) {
            throw new IllegalStateException();
        } else if (b() instanceof i) {
            List<l> list = this.f39560c;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final JsonWriter beginObject() throws IOException {
        o oVar = new o();
        a(oVar);
        this.f39560c.add(oVar);
        return this;
    }

    public final JsonWriter endObject() throws IOException {
        if (this.f39560c.isEmpty() || this.f39561d != null) {
            throw new IllegalStateException();
        } else if (b() instanceof o) {
            List<l> list = this.f39560c;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final JsonWriter name(String str) throws IOException {
        if (this.f39560c.isEmpty() || this.f39561d != null) {
            throw new IllegalStateException();
        } else if (b() instanceof o) {
            this.f39561d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        a(new r(str));
        return this;
    }

    public final JsonWriter nullValue() throws IOException {
        a(n.f39635a);
        return this;
    }

    public final JsonWriter value(boolean z) throws IOException {
        a(new r(Boolean.valueOf(z)));
        return this;
    }

    public final JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        a(new r(bool));
        return this;
    }

    public final JsonWriter value(double d2) throws IOException {
        if (isLenient() || (!Double.isNaN(d2) && !Double.isInfinite(d2))) {
            a(new r((Number) Double.valueOf(d2)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(String.valueOf(d2)));
    }

    public final JsonWriter value(long j) throws IOException {
        a(new r((Number) Long.valueOf(j)));
        return this;
    }

    public final JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(String.valueOf(number)));
            }
        }
        a(new r(number));
        return this;
    }

    public final void close() throws IOException {
        if (this.f39560c.isEmpty()) {
            this.f39560c.add(f39559b);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
