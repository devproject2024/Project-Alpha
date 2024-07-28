package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.d.c;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public final class u extends o {

    /* renamed from: c  reason: collision with root package name */
    private final int f6209c;

    /* renamed from: d  reason: collision with root package name */
    private final List f6210d;

    /* renamed from: e  reason: collision with root package name */
    private final b f6211e;

    public final void a(b bVar, Object obj, Type type, Map<String, Object> map) {
    }

    public u(b bVar, List list, int i2) {
        super((Class<?>) null, (c) null);
        this.f6211e = bVar;
        this.f6209c = i2;
        this.f6210d = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r4 = (com.alibaba.a.b) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.util.List r4 = r3.f6210d
            int r0 = r3.f6209c
            r4.set(r0, r5)
            java.util.List r4 = r3.f6210d
            boolean r0 = r4 instanceof com.alibaba.a.b
            if (r0 == 0) goto L_0x0036
            com.alibaba.a.b r4 = (com.alibaba.a.b) r4
            java.lang.Object r0 = r4.getRelatedArray()
            if (r0 == 0) goto L_0x0036
            int r1 = java.lang.reflect.Array.getLength(r0)
            int r2 = r3.f6209c
            if (r1 <= r2) goto L_0x0036
            java.lang.reflect.Type r1 = r4.getComponentType()
            if (r1 == 0) goto L_0x0031
            java.lang.reflect.Type r4 = r4.getComponentType()
            com.alibaba.a.b.b r1 = r3.f6211e
            com.alibaba.a.b.i r1 = r1.c()
            java.lang.Object r5 = com.alibaba.a.d.g.a((java.lang.Object) r5, (java.lang.reflect.Type) r4, (com.alibaba.a.b.i) r1)
        L_0x0031:
            int r4 = r3.f6209c
            java.lang.reflect.Array.set(r0, r4, r5)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.a.u.a(java.lang.Object, java.lang.Object):void");
    }
}
