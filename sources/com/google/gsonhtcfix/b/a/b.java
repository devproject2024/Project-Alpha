package com.google.gsonhtcfix.b.a;

import com.google.gsonhtcfix.b.c;
import com.google.gsonhtcfix.b.h;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.y;
import com.google.gsonhtcfix.z;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class b implements z {

    /* renamed from: a  reason: collision with root package name */
    private final c f39646a;

    public b(c cVar) {
        this.f39646a = cVar;
    }

    public final <T> y<T> a(f fVar, com.google.gsonhtcfix.c.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type a2 = com.google.gsonhtcfix.b.b.a(type, (Class<?>) rawType);
        return new a(fVar, a2, fVar.a(com.google.gsonhtcfix.c.a.get(a2)), this.f39646a.a(aVar));
    }

    static final class a<E> extends y<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final y<E> f39647a;

        /* renamed from: b  reason: collision with root package name */
        private final h<? extends Collection<E>> f39648b;

        public final /* synthetic */ void a(com.google.gsonhtcfix.d.c cVar, Object obj) throws IOException {
            Collection<Object> collection = (Collection) obj;
            if (collection == null) {
                cVar.e();
                return;
            }
            cVar.a();
            for (Object a2 : collection) {
                this.f39647a.a(cVar, a2);
            }
            cVar.b();
        }

        public a(f fVar, Type type, y<E> yVar, h<? extends Collection<E>> hVar) {
            this.f39647a = new k(fVar, yVar, type);
            this.f39648b = hVar;
        }

        public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
            if (aVar.f() == com.google.gsonhtcfix.d.b.NULL) {
                aVar.k();
                return null;
            }
            Collection collection = (Collection) this.f39648b.a();
            aVar.a();
            while (aVar.e()) {
                collection.add(this.f39647a.a(aVar));
            }
            aVar.b();
            return collection;
        }
    }
}
