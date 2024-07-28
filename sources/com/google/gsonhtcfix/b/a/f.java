package com.google.gsonhtcfix.b.a;

import com.google.gsonhtcfix.b.b;
import com.google.gsonhtcfix.b.c;
import com.google.gsonhtcfix.b.e;
import com.google.gsonhtcfix.b.h;
import com.google.gsonhtcfix.b.j;
import com.google.gsonhtcfix.i;
import com.google.gsonhtcfix.l;
import com.google.gsonhtcfix.n;
import com.google.gsonhtcfix.o;
import com.google.gsonhtcfix.s;
import com.google.gsonhtcfix.v;
import com.google.gsonhtcfix.y;
import com.google.gsonhtcfix.z;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class f implements z {

    /* renamed from: a  reason: collision with root package name */
    final boolean f39661a;

    /* renamed from: b  reason: collision with root package name */
    private final c f39662b;

    public f(c cVar, boolean z) {
        this.f39662b = cVar;
        this.f39661a = z;
    }

    public final <T> y<T> a(com.google.gsonhtcfix.f fVar, com.google.gsonhtcfix.c.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] b2 = b.b(type, b.b(type));
        Type type2 = b2[0];
        return new a(fVar, b2[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? l.f39696f : fVar.a(com.google.gsonhtcfix.c.a.get(type2)), b2[1], fVar.a(com.google.gsonhtcfix.c.a.get(b2[1])), this.f39662b.a(aVar));
    }

    final class a<K, V> extends y<Map<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        private final y<K> f39664b;

        /* renamed from: c  reason: collision with root package name */
        private final y<V> f39665c;

        /* renamed from: d  reason: collision with root package name */
        private final h<? extends Map<K, V>> f39666d;

        public final /* synthetic */ void a(com.google.gsonhtcfix.d.c cVar, Object obj) throws IOException {
            String str;
            Map map = (Map) obj;
            if (map == null) {
                cVar.e();
            } else if (!f.this.f39661a) {
                cVar.c();
                for (Map.Entry entry : map.entrySet()) {
                    cVar.a(String.valueOf(entry.getKey()));
                    this.f39665c.a(cVar, entry.getValue());
                }
                cVar.d();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                boolean z = false;
                for (Map.Entry entry2 : map.entrySet()) {
                    l a2 = this.f39664b.a(entry2.getKey());
                    arrayList.add(a2);
                    arrayList2.add(entry2.getValue());
                    z |= (a2 instanceof i) || (a2 instanceof o);
                }
                if (z) {
                    cVar.a();
                    while (i2 < arrayList.size()) {
                        cVar.a();
                        j.a((l) arrayList.get(i2), cVar);
                        this.f39665c.a(cVar, arrayList2.get(i2));
                        cVar.b();
                        i2++;
                    }
                    cVar.b();
                    return;
                }
                cVar.c();
                while (i2 < arrayList.size()) {
                    l lVar = (l) arrayList.get(i2);
                    if (lVar instanceof s) {
                        s h2 = lVar.h();
                        if (h2.f39825a instanceof Number) {
                            str = String.valueOf(h2.a());
                        } else if (h2.f39825a instanceof Boolean) {
                            str = Boolean.toString(h2.f());
                        } else if (h2.f39825a instanceof String) {
                            str = h2.b();
                        } else {
                            throw new AssertionError();
                        }
                    } else if (lVar instanceof n) {
                        str = "null";
                    } else {
                        throw new AssertionError();
                    }
                    cVar.a(str);
                    this.f39665c.a(cVar, arrayList2.get(i2));
                    i2++;
                }
                cVar.d();
            }
        }

        public a(com.google.gsonhtcfix.f fVar, Type type, y<K> yVar, Type type2, y<V> yVar2, h<? extends Map<K, V>> hVar) {
            this.f39664b = new k(fVar, yVar, type);
            this.f39665c = new k(fVar, yVar2, type2);
            this.f39666d = hVar;
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            com.google.gsonhtcfix.d.b f2 = aVar.f();
            if (f2 == com.google.gsonhtcfix.d.b.NULL) {
                aVar.k();
                return null;
            }
            Map map = (Map) this.f39666d.a();
            if (f2 == com.google.gsonhtcfix.d.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K a2 = this.f39664b.a(aVar);
                    if (map.put(a2, this.f39665c.a(aVar)) == null) {
                        aVar.b();
                    } else {
                        throw new v("duplicate key: ".concat(String.valueOf(a2)));
                    }
                }
                aVar.b();
            } else {
                aVar.c();
                while (aVar.e()) {
                    e.f39751a.a(aVar);
                    K a3 = this.f39664b.a(aVar);
                    if (map.put(a3, this.f39665c.a(aVar)) != null) {
                        throw new v("duplicate key: ".concat(String.valueOf(a3)));
                    }
                }
                aVar.d();
            }
            return map;
        }
    }
}
