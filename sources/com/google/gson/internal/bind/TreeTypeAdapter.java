package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.p;
import com.google.gson.s;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.w;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T> extends w<T> {

    /* renamed from: a  reason: collision with root package name */
    final f f39517a;

    /* renamed from: b  reason: collision with root package name */
    private final t<T> f39518b;

    /* renamed from: c  reason: collision with root package name */
    private final k<T> f39519c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.gson.b.a<T> f39520d;

    /* renamed from: e  reason: collision with root package name */
    private final x f39521e;

    /* renamed from: f  reason: collision with root package name */
    private final TreeTypeAdapter<T>.defpackage.a f39522f = new a(this, (byte) 0);

    /* renamed from: g  reason: collision with root package name */
    private w<T> f39523g;

    public TreeTypeAdapter(t<T> tVar, k<T> kVar, f fVar, com.google.gson.b.a<T> aVar, x xVar) {
        this.f39518b = tVar;
        this.f39519c = kVar;
        this.f39517a = fVar;
        this.f39520d = aVar;
        this.f39521e = xVar;
    }

    public final T read(JsonReader jsonReader) throws IOException {
        if (this.f39519c == null) {
            return a().read(jsonReader);
        }
        l a2 = com.google.gson.internal.k.a(jsonReader);
        if (a2 instanceof n) {
            return null;
        }
        return this.f39519c.deserialize(a2, this.f39520d.getType(), this.f39522f);
    }

    public final void write(JsonWriter jsonWriter, T t) throws IOException {
        t<T> tVar = this.f39518b;
        if (tVar == null) {
            a().write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            com.google.gson.internal.k.a(tVar.serialize(t, this.f39520d.getType(), this.f39522f), jsonWriter);
        }
    }

    private w<T> a() {
        w<T> wVar = this.f39523g;
        if (wVar != null) {
            return wVar;
        }
        w<T> a2 = this.f39517a.a(this.f39521e, this.f39520d);
        this.f39523g = a2;
        return a2;
    }

    public static final class SingleTypeFactory implements x {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.gson.b.a<?> f39524a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f39525b;

        /* renamed from: c  reason: collision with root package name */
        private final Class<?> f39526c;

        /* renamed from: d  reason: collision with root package name */
        private final t<?> f39527d;

        /* renamed from: e  reason: collision with root package name */
        private final k<?> f39528e;

        public SingleTypeFactory(Object obj, com.google.gson.b.a<?> aVar, boolean z) {
            this.f39527d = obj instanceof t ? (t) obj : null;
            this.f39528e = obj instanceof k ? (k) obj : null;
            com.google.gson.internal.a.a((this.f39527d == null && this.f39528e == null) ? false : true);
            this.f39524a = aVar;
            this.f39525b = z;
            this.f39526c = null;
        }

        public final <T> w<T> create(f fVar, com.google.gson.b.a<T> aVar) {
            boolean z;
            com.google.gson.b.a<?> aVar2 = this.f39524a;
            if (aVar2 != null) {
                z = aVar2.equals(aVar) || (this.f39525b && this.f39524a.getType() == aVar.getRawType());
            } else {
                z = this.f39526c.isAssignableFrom(aVar.getRawType());
            }
            if (z) {
                return new TreeTypeAdapter(this.f39527d, this.f39528e, fVar, aVar, this);
            }
            return null;
        }
    }

    final class a implements j, s {
        private a() {
        }

        /* synthetic */ a(TreeTypeAdapter treeTypeAdapter, byte b2) {
            this();
        }

        public final <R> R a(l lVar, Type type) throws p {
            return TreeTypeAdapter.this.f39517a.a(lVar, type);
        }
    }
}
