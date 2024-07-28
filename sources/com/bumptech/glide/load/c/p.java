package com.bumptech.glide.load.c;

import androidx.core.g.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f7056a;

    /* renamed from: b  reason: collision with root package name */
    private final a f7057b;

    public p(e.a<List<Throwable>> aVar) {
        this(new r(aVar));
    }

    private p(r rVar) {
        this.f7057b = new a();
        this.f7056a = rVar;
    }

    public final synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, o<? extends Model, ? extends Data> oVar) {
        this.f7056a.a(cls, cls2, oVar);
        this.f7057b.f7058a.clear();
    }

    public final synchronized List<Class<?>> a(Class<?> cls) {
        return this.f7056a.b(cls);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Class<A>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized <A> java.util.List<com.bumptech.glide.load.c.n<A, ?>> b(java.lang.Class<A> r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.bumptech.glide.load.c.p$a r0 = r3.f7057b     // Catch:{ all -> 0x0041 }
            java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.c.p$a$a<?>> r0 = r0.f7058a     // Catch:{ all -> 0x0041 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0041 }
            com.bumptech.glide.load.c.p$a$a r0 = (com.bumptech.glide.load.c.p.a.C0099a) r0     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x000f
            r0 = 0
            goto L_0x0011
        L_0x000f:
            java.util.List<com.bumptech.glide.load.c.n<Model, ?>> r0 = r0.f7059a     // Catch:{ all -> 0x0041 }
        L_0x0011:
            if (r0 != 0) goto L_0x003f
            com.bumptech.glide.load.c.r r0 = r3.f7056a     // Catch:{ all -> 0x0041 }
            java.util.List r0 = r0.a(r4)     // Catch:{ all -> 0x0041 }
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)     // Catch:{ all -> 0x0041 }
            com.bumptech.glide.load.c.p$a r1 = r3.f7057b     // Catch:{ all -> 0x0041 }
            java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.c.p$a$a<?>> r1 = r1.f7058a     // Catch:{ all -> 0x0041 }
            com.bumptech.glide.load.c.p$a$a r2 = new com.bumptech.glide.load.c.p$a$a     // Catch:{ all -> 0x0041 }
            r2.<init>(r0)     // Catch:{ all -> 0x0041 }
            java.lang.Object r1 = r1.put(r4, r2)     // Catch:{ all -> 0x0041 }
            com.bumptech.glide.load.c.p$a$a r1 = (com.bumptech.glide.load.c.p.a.C0099a) r1     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x002f
            goto L_0x003f
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0041 }
            java.lang.String r1 = "Already cached loaders for model: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = r1.concat(r4)     // Catch:{ all -> 0x0041 }
            r0.<init>(r4)     // Catch:{ all -> 0x0041 }
            throw r0     // Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r3)
            return r0
        L_0x0041:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.c.p.b(java.lang.Class):java.util.List");
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<Class<?>, C0099a<?>> f7058a = new HashMap();

        a() {
        }

        /* renamed from: com.bumptech.glide.load.c.p$a$a  reason: collision with other inner class name */
        static class C0099a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f7059a;

            public C0099a(List<n<Model, ?>> list) {
                this.f7059a = list;
            }
        }
    }
}
