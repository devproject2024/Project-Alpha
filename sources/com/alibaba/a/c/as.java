package com.alibaba.a.c;

import com.alibaba.a.a.b;
import com.alibaba.a.d.c;
import java.lang.reflect.Type;
import java.util.Collection;

public final class as extends w {

    /* renamed from: c  reason: collision with root package name */
    boolean f6285c = false;

    /* renamed from: d  reason: collision with root package name */
    boolean f6286d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f6287e = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f6288f = false;

    /* renamed from: g  reason: collision with root package name */
    boolean f6289g = false;

    /* renamed from: h  reason: collision with root package name */
    private String f6290h;

    /* renamed from: i  reason: collision with root package name */
    private a f6291i;

    public as(c cVar) {
        super(cVar);
        b bVar = (b) cVar.a(b.class);
        if (bVar != null) {
            this.f6290h = bVar.c();
            if (this.f6290h.trim().length() == 0) {
                this.f6290h = null;
            }
            for (bb bbVar : bVar.f()) {
                if (bbVar == bb.WriteNullNumberAsZero) {
                    this.f6285c = true;
                } else if (bbVar == bb.WriteNullStringAsEmpty) {
                    this.f6286d = true;
                } else if (bbVar == bb.WriteNullBooleanAsFalse) {
                    this.f6287e = true;
                } else if (bbVar == bb.WriteNullListAsEmpty) {
                    this.f6288f = true;
                } else if (bbVar == bb.WriteEnumUsingToString) {
                    this.f6289g = true;
                }
            }
        }
    }

    public final void a(ah ahVar, Object obj) throws Exception {
        a(ahVar);
        b(ahVar, obj);
    }

    public final void b(ah ahVar, Object obj) throws Exception {
        Class<?> cls;
        String str = this.f6290h;
        if (str != null) {
            ahVar.a(obj, str);
            return;
        }
        if (this.f6291i == null) {
            if (obj == null) {
                cls = this.f6336a.f6354d;
            } else {
                cls = obj.getClass();
            }
            this.f6291i = new a(ahVar.a(cls), cls);
        }
        a aVar = this.f6291i;
        if (obj == null) {
            if (this.f6285c && Number.class.isAssignableFrom(aVar.f6293b)) {
                ahVar.f6266a.a('0');
            } else if (this.f6286d && String.class == aVar.f6293b) {
                ahVar.f6266a.write("\"\"");
            } else if (this.f6287e && Boolean.class == aVar.f6293b) {
                ahVar.f6266a.write("false");
            } else if (!this.f6288f || !Collection.class.isAssignableFrom(aVar.f6293b)) {
                aVar.f6292a.a(ahVar, (Object) null, this.f6336a.f6351a, (Type) null);
            } else {
                ahVar.f6266a.write("[]");
            }
        } else if (!this.f6289g || !aVar.f6293b.isEnum()) {
            Class<?> cls2 = obj.getClass();
            if (cls2 == aVar.f6293b) {
                aVar.f6292a.a(ahVar, obj, this.f6336a.f6351a, this.f6336a.f6355e);
            } else {
                ahVar.a(cls2).a(ahVar, obj, this.f6336a.f6351a, this.f6336a.f6355e);
            }
        } else {
            ahVar.f6266a.b(((Enum) obj).name());
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        at f6292a;

        /* renamed from: b  reason: collision with root package name */
        Class<?> f6293b;

        public a(at atVar, Class<?> cls) {
            this.f6292a = atVar;
            this.f6293b = cls;
        }
    }
}
