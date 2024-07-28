package com.google.gsonhtcfix.b.a;

import com.google.gsonhtcfix.c.a;
import com.google.gsonhtcfix.d.c;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.y;
import com.google.gsonhtcfix.z;
import java.io.IOException;
import java.util.ArrayList;

public final class g extends y<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final z f39667a = new z() {
        public final <T> y<T> a(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new g(fVar, (byte) 0);
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final f f39668b;

    /* synthetic */ g(f fVar, byte b2) {
        this(fVar);
    }

    private g(f fVar) {
        this.f39668b = fVar;
    }

    public final Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
        switch (aVar.f()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(a(aVar));
                }
                aVar.b();
                return arrayList;
            case BEGIN_OBJECT:
                com.google.gsonhtcfix.b.g gVar = new com.google.gsonhtcfix.b.g();
                aVar.c();
                while (aVar.e()) {
                    gVar.put(aVar.h(), a(aVar));
                }
                aVar.d();
                return gVar;
            case STRING:
                return aVar.i();
            case NUMBER:
                return Double.valueOf(aVar.l());
            case BOOLEAN:
                return Boolean.valueOf(aVar.j());
            case NULL:
                aVar.k();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public final void a(c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.e();
            return;
        }
        y<?> a2 = this.f39668b.a(obj.getClass());
        if (a2 instanceof g) {
            cVar.c();
            cVar.d();
            return;
        }
        a2.a(cVar, obj);
    }
}
