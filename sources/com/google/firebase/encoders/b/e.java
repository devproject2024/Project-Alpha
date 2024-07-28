package com.google.firebase.encoders.b;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.c;
import com.google.firebase.encoders.d;
import com.google.firebase.encoders.f;
import com.google.firebase.encoders.g;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

final class e implements com.google.firebase.encoders.e, g {

    /* renamed from: a  reason: collision with root package name */
    final JsonWriter f38747a;

    /* renamed from: b  reason: collision with root package name */
    private e f38748b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f38749c = true;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, d<?>> f38750d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Class<?>, f<?>> f38751e;

    /* renamed from: f  reason: collision with root package name */
    private final d<Object> f38752f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f38753g;

    e(Writer writer, Map<Class<?>, d<?>> map, Map<Class<?>, f<?>> map2, d<Object> dVar, boolean z) {
        this.f38747a = new JsonWriter(writer);
        this.f38750d = map;
        this.f38751e = map2;
        this.f38752f = dVar;
        this.f38753g = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public e a(String str, Object obj) throws IOException {
        if (!this.f38753g) {
            a();
            this.f38747a.name(str);
            if (obj != null) {
                return a(obj);
            }
            this.f38747a.nullValue();
            return this;
        } else if (obj == null) {
            return this;
        } else {
            a();
            this.f38747a.name(str);
            return a(obj);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public e a(String str) throws IOException {
        a();
        this.f38747a.value(str);
        return this;
    }

    private e a(long j) throws IOException {
        a();
        this.f38747a.value(j);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public e a(boolean z) throws IOException {
        a();
        this.f38747a.value(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final e a(Object obj) throws IOException {
        if (obj == null) {
            this.f38747a.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f38747a.value((Number) obj);
            return this;
        } else {
            int i2 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    a();
                    if (bArr == null) {
                        this.f38747a.nullValue();
                    } else {
                        this.f38747a.value(Base64.encodeToString(bArr, 2));
                    }
                    return this;
                }
                this.f38747a.beginArray();
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    int length = iArr.length;
                    while (i2 < length) {
                        this.f38747a.value((long) iArr[i2]);
                        i2++;
                    }
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    int length2 = jArr.length;
                    while (i2 < length2) {
                        a(jArr[i2]);
                        i2++;
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    int length3 = dArr.length;
                    while (i2 < length3) {
                        this.f38747a.value(dArr[i2]);
                        i2++;
                    }
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    int length4 = zArr.length;
                    while (i2 < length4) {
                        this.f38747a.value(zArr[i2]);
                        i2++;
                    }
                } else if (obj instanceof Number[]) {
                    Number[] numberArr = (Number[]) obj;
                    int length5 = numberArr.length;
                    while (i2 < length5) {
                        a((Object) numberArr[i2]);
                        i2++;
                    }
                } else {
                    Object[] objArr = (Object[]) obj;
                    int length6 = objArr.length;
                    while (i2 < length6) {
                        a(objArr[i2]);
                        i2++;
                    }
                }
                this.f38747a.endArray();
                return this;
            } else if (obj instanceof Collection) {
                this.f38747a.beginArray();
                for (Object a2 : (Collection) obj) {
                    a(a2);
                }
                this.f38747a.endArray();
                return this;
            } else if (obj instanceof Map) {
                this.f38747a.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        a((String) key, entry.getValue());
                    } catch (ClassCastException e2) {
                        throw new c(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e2);
                    }
                }
                this.f38747a.endObject();
                return this;
            } else {
                d dVar = this.f38750d.get(obj.getClass());
                if (dVar != null) {
                    return a((d<Object>) dVar, obj);
                }
                f fVar = this.f38751e.get(obj.getClass());
                if (fVar != null) {
                    fVar.a(obj, this);
                    return this;
                } else if (!(obj instanceof Enum)) {
                    return a(this.f38752f, obj);
                } else {
                    a(((Enum) obj).name());
                    return this;
                }
            }
        }
    }

    private e a(d<Object> dVar, Object obj) throws IOException {
        this.f38747a.beginObject();
        dVar.a(obj, this);
        this.f38747a.endObject();
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void a() throws IOException {
        if (this.f38749c) {
            e eVar = this.f38748b;
            if (eVar != null) {
                eVar.a();
                this.f38748b.f38749c = false;
                this.f38748b = null;
                this.f38747a.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    public final /* synthetic */ com.google.firebase.encoders.e a(String str, boolean z) throws IOException {
        a();
        this.f38747a.name(str);
        return a(z);
    }

    public final /* synthetic */ com.google.firebase.encoders.e a(String str, long j) throws IOException {
        a();
        this.f38747a.name(str);
        return a(j);
    }

    public final /* synthetic */ com.google.firebase.encoders.e a(String str, int i2) throws IOException {
        a();
        this.f38747a.name(str);
        a();
        this.f38747a.value((long) i2);
        return this;
    }
}
