package com.alibaba.a.b.a;

import com.alibaba.a.b.b;
import com.alibaba.a.b.h;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class c extends o {

    /* renamed from: c  reason: collision with root package name */
    private final Type f6186c;

    /* renamed from: d  reason: collision with root package name */
    private int f6187d;

    /* renamed from: e  reason: collision with root package name */
    private z f6188e;

    public c(Class<?> cls, com.alibaba.a.d.c cVar) {
        super(cls, cVar);
        if (d() instanceof ParameterizedType) {
            this.f6186c = ((ParameterizedType) d()).getActualTypeArguments()[0];
        } else {
            this.f6186c = Object.class;
        }
    }

    public final void a(b bVar, Object obj, Type type, Map<String, Object> map) {
        if (bVar.g().a() == 8) {
            a(obj, (Object) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        h d2 = bVar.d();
        bVar.a(d2, obj, (Object) this.f6199a.f6351a);
        a(bVar, type, arrayList);
        bVar.a(d2);
        if (obj == null) {
            map.put(this.f6199a.f6351a, arrayList);
        } else {
            a(obj, (Object) arrayList);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.alibaba.a.b.b r12, java.lang.reflect.Type r13, java.util.Collection r14) {
        /*
            r11 = this;
            java.lang.reflect.Type r0 = r11.f6186c
            com.alibaba.a.b.a.z r1 = r11.f6188e
            boolean r2 = r0 instanceof java.lang.reflect.TypeVariable
            r3 = 0
            if (r2 == 0) goto L_0x005e
            boolean r2 = r13 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x005e
            r2 = r0
            java.lang.reflect.TypeVariable r2 = (java.lang.reflect.TypeVariable) r2
            r4 = r13
            java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
            r5 = 0
            java.lang.reflect.Type r6 = r4.getRawType()
            boolean r6 = r6 instanceof java.lang.Class
            if (r6 == 0) goto L_0x0022
            java.lang.reflect.Type r5 = r4.getRawType()
            java.lang.Class r5 = (java.lang.Class) r5
        L_0x0022:
            r6 = -1
            if (r5 == 0) goto L_0x0045
            java.lang.reflect.TypeVariable[] r7 = r5.getTypeParameters()
            int r7 = r7.length
            r8 = 0
        L_0x002b:
            if (r8 >= r7) goto L_0x0045
            java.lang.reflect.TypeVariable[] r9 = r5.getTypeParameters()
            r9 = r9[r8]
            java.lang.String r9 = r9.getName()
            java.lang.String r10 = r2.getName()
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0042
            goto L_0x0046
        L_0x0042:
            int r8 = r8 + 1
            goto L_0x002b
        L_0x0045:
            r8 = -1
        L_0x0046:
            if (r8 == r6) goto L_0x005e
            java.lang.reflect.Type[] r0 = r4.getActualTypeArguments()
            r0 = r0[r8]
            java.lang.reflect.Type r2 = r11.f6186c
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x005e
            com.alibaba.a.b.i r1 = r12.c()
            com.alibaba.a.b.a.z r1 = r1.a((java.lang.reflect.Type) r0)
        L_0x005e:
            com.alibaba.a.b.d r2 = r12.g()
            int r4 = r2.a()
            r5 = 14
            if (r4 == r5) goto L_0x009c
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r14 = "exepct '[', but "
            r12.<init>(r14)
            int r14 = r2.a()
            java.lang.String r14 = com.alibaba.a.b.g.a(r14)
            r12.append(r14)
            java.lang.String r12 = r12.toString()
            if (r13 == 0) goto L_0x0096
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r12)
            java.lang.String r12 = ", type : "
            r14.append(r12)
            r14.append(r13)
            java.lang.String r12 = r14.toString()
        L_0x0096:
            com.alibaba.a.d r13 = new com.alibaba.a.d
            r13.<init>(r12)
            throw r13
        L_0x009c:
            if (r1 != 0) goto L_0x00b0
            com.alibaba.a.b.i r13 = r12.c()
            com.alibaba.a.b.a.z r1 = r13.a((java.lang.reflect.Type) r0)
            r11.f6188e = r1
            com.alibaba.a.b.a.z r13 = r11.f6188e
            int r13 = r13.a()
            r11.f6187d = r13
        L_0x00b0:
            int r13 = r11.f6187d
            r2.a((int) r13)
        L_0x00b5:
            com.alibaba.a.b.c r13 = com.alibaba.a.b.c.AllowArbitraryCommas
            boolean r13 = r2.a((com.alibaba.a.b.c) r13)
            r4 = 16
            if (r13 == 0) goto L_0x00c9
        L_0x00bf:
            int r13 = r2.a()
            if (r13 != r4) goto L_0x00c9
            r2.d()
            goto L_0x00bf
        L_0x00c9:
            int r13 = r2.a()
            r5 = 15
            if (r13 == r5) goto L_0x00ed
            java.lang.Integer r13 = java.lang.Integer.valueOf(r3)
            java.lang.Object r13 = r1.a(r12, r0, r13)
            r14.add(r13)
            r12.a((java.util.Collection) r14)
            int r13 = r2.a()
            if (r13 != r4) goto L_0x00ea
            int r13 = r11.f6187d
            r2.a((int) r13)
        L_0x00ea:
            int r3 = r3 + 1
            goto L_0x00b5
        L_0x00ed:
            r2.a((int) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.a.c.a(com.alibaba.a.b.b, java.lang.reflect.Type, java.util.Collection):void");
    }
}
