package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public final class c extends JsonReader {

    /* renamed from: a  reason: collision with root package name */
    private static final Reader f39552a = new Reader() {
        public final int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }

        public final void close() throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Object f39553b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Object[] f39554c = new Object[32];

    /* renamed from: d  reason: collision with root package name */
    private int f39555d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String[] f39556e = new String[32];

    /* renamed from: f  reason: collision with root package name */
    private int[] f39557f = new int[32];

    public c(l lVar) {
        super(f39552a);
        a((Object) lVar);
    }

    public final void beginArray() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        a((Object) ((i) a()).iterator());
        this.f39557f[this.f39555d - 1] = 0;
    }

    public final void endArray() throws IOException {
        a(JsonToken.END_ARRAY);
        b();
        b();
        int i2 = this.f39555d;
        if (i2 > 0) {
            int[] iArr = this.f39557f;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final void beginObject() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        a((Object) ((o) a()).f39636a.entrySet().iterator());
    }

    public final void endObject() throws IOException {
        a(JsonToken.END_OBJECT);
        b();
        b();
        int i2 = this.f39555d;
        if (i2 > 0) {
            int[] iArr = this.f39557f;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final boolean hasNext() throws IOException {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY) ? false : true;
    }

    public final JsonToken peek() throws IOException {
        while (this.f39555d != 0) {
            Object a2 = a();
            if (a2 instanceof Iterator) {
                boolean z = this.f39554c[this.f39555d - 2] instanceof o;
                Iterator it2 = (Iterator) a2;
                if (!it2.hasNext()) {
                    return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
                }
                if (z) {
                    return JsonToken.NAME;
                }
                a(it2.next());
            } else if (a2 instanceof o) {
                return JsonToken.BEGIN_OBJECT;
            } else {
                if (a2 instanceof i) {
                    return JsonToken.BEGIN_ARRAY;
                }
                if (a2 instanceof r) {
                    r rVar = (r) a2;
                    if (rVar.f39637a instanceof String) {
                        return JsonToken.STRING;
                    }
                    if (rVar.f39637a instanceof Boolean) {
                        return JsonToken.BOOLEAN;
                    }
                    if (rVar.f39637a instanceof Number) {
                        return JsonToken.NUMBER;
                    }
                    throw new AssertionError();
                } else if (a2 instanceof n) {
                    return JsonToken.NULL;
                } else {
                    if (a2 == f39553b) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
            }
        }
        return JsonToken.END_DOCUMENT;
    }

    public final Object a() {
        return this.f39554c[this.f39555d - 1];
    }

    private Object b() {
        Object[] objArr = this.f39554c;
        int i2 = this.f39555d - 1;
        this.f39555d = i2;
        Object obj = objArr[i2];
        objArr[this.f39555d] = null;
        return obj;
    }

    public final void a(JsonToken jsonToken) throws IOException {
        if (peek() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + c());
        }
    }

    public final String nextName() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) a()).next();
        String str = (String) entry.getKey();
        this.f39556e[this.f39555d - 1] = str;
        a(entry.getValue());
        return str;
    }

    public final String nextString() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.STRING || peek == JsonToken.NUMBER) {
            String c2 = ((r) b()).c();
            int i2 = this.f39555d;
            if (i2 > 0) {
                int[] iArr = this.f39557f;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return c2;
        }
        throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + peek + c());
    }

    public final boolean nextBoolean() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean g2 = ((r) b()).g();
        int i2 = this.f39555d;
        if (i2 > 0) {
            int[] iArr = this.f39557f;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return g2;
    }

    public final void nextNull() throws IOException {
        a(JsonToken.NULL);
        b();
        int i2 = this.f39555d;
        if (i2 > 0) {
            int[] iArr = this.f39557f;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final double nextDouble() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            double d2 = ((r) a()).d();
            if (isLenient() || (!Double.isNaN(d2) && !Double.isInfinite(d2))) {
                b();
                int i2 = this.f39555d;
                if (i2 > 0) {
                    int[] iArr = this.f39557f;
                    int i3 = i2 - 1;
                    iArr[i3] = iArr[i3] + 1;
                }
                return d2;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: ".concat(String.valueOf(d2)));
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek + c());
    }

    public final long nextLong() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            long e2 = ((r) a()).e();
            b();
            int i2 = this.f39555d;
            if (i2 > 0) {
                int[] iArr = this.f39557f;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return e2;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek + c());
    }

    public final int nextInt() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            int f2 = ((r) a()).f();
            b();
            int i2 = this.f39555d;
            if (i2 > 0) {
                int[] iArr = this.f39557f;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return f2;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + peek + c());
    }

    public final void close() throws IOException {
        this.f39554c = new Object[]{f39553b};
        this.f39555d = 1;
    }

    public final void skipValue() throws IOException {
        if (peek() == JsonToken.NAME) {
            nextName();
            this.f39556e[this.f39555d - 2] = "null";
        } else {
            b();
            int i2 = this.f39555d;
            if (i2 > 0) {
                this.f39556e[i2 - 1] = "null";
            }
        }
        int i3 = this.f39555d;
        if (i3 > 0) {
            int[] iArr = this.f39557f;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public final void a(Object obj) {
        int i2 = this.f39555d;
        Object[] objArr = this.f39554c;
        if (i2 == objArr.length) {
            int i3 = i2 * 2;
            this.f39554c = Arrays.copyOf(objArr, i3);
            this.f39557f = Arrays.copyOf(this.f39557f, i3);
            this.f39556e = (String[]) Arrays.copyOf(this.f39556e, i3);
        }
        Object[] objArr2 = this.f39554c;
        int i4 = this.f39555d;
        this.f39555d = i4 + 1;
        objArr2[i4] = obj;
    }

    public final String getPath() {
        StringBuilder sb = new StringBuilder("$");
        int i2 = 0;
        while (i2 < this.f39555d) {
            Object[] objArr = this.f39554c;
            if (objArr[i2] instanceof i) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.f39557f[i2]);
                    sb.append(']');
                }
            } else if (objArr[i2] instanceof o) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.f39556e;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
            }
            i2++;
        }
        return sb.toString();
    }

    private String c() {
        return " at path " + getPath();
    }
}
