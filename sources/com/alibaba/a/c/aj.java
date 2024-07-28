package com.alibaba.a.c;

import com.alibaba.a.d.c;
import com.alibaba.a.d.g;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class aj implements at {

    /* renamed from: a  reason: collision with root package name */
    private final w[] f6276a;

    /* renamed from: b  reason: collision with root package name */
    private final w[] f6277b;

    /* renamed from: c  reason: collision with root package name */
    private int f6278c;

    public aj(Class<?> cls) {
        this(cls, (byte) 0);
    }

    private aj(Class<?> cls, byte b2) {
        this.f6278c = 0;
        this.f6278c = g.b(cls);
        ArrayList arrayList = new ArrayList();
        for (c a2 : g.a(cls, false)) {
            arrayList.add(a(a2));
        }
        this.f6276a = (w[]) arrayList.toArray(new w[arrayList.size()]);
        ArrayList arrayList2 = new ArrayList();
        for (c a3 : g.a(cls, true)) {
            arrayList2.add(a(a3));
        }
        this.f6277b = (w[]) arrayList2.toArray(new w[arrayList2.size()]);
    }

    /* access modifiers changed from: protected */
    public boolean a(ah ahVar, Type type) {
        if (!ahVar.f6266a.b(bb.WriteClassName)) {
            return false;
        }
        if (type == null && ahVar.b(bb.NotWriteRootClassName)) {
            if (ahVar.j.f6295a == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (com.alibaba.a.c.bb.isEnabled(r5.f6297c, com.alibaba.a.c.bb.DisableCircularReferenceDetect) != false) goto L_0x0028;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.alibaba.a.c.ah r22, java.lang.Object r23, java.lang.Object r24, java.lang.reflect.Type r25) throws java.io.IOException {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r0 = r23
            r3 = r25
            com.alibaba.a.c.ba r4 = r2.f6266a
            if (r0 != 0) goto L_0x0012
            java.lang.String r0 = "null"
            r4.write((java.lang.String) r0)
            return
        L_0x0012:
            com.alibaba.a.c.ax r5 = r2.j
            r7 = 0
            if (r5 == 0) goto L_0x0022
            com.alibaba.a.c.bb r8 = com.alibaba.a.c.bb.DisableCircularReferenceDetect
            int r5 = r5.f6297c
            boolean r5 = com.alibaba.a.c.bb.isEnabled(r5, r8)
            if (r5 == 0) goto L_0x0022
            goto L_0x0028
        L_0x0022:
            boolean r5 = r22.a((java.lang.Object) r23)
            if (r5 != 0) goto L_0x002a
        L_0x0028:
            r5 = 0
            goto L_0x002e
        L_0x002a:
            r22.b((java.lang.Object) r23)
            r5 = 1
        L_0x002e:
            if (r5 == 0) goto L_0x0031
            return
        L_0x0031:
            com.alibaba.a.c.bb r5 = com.alibaba.a.c.bb.SortField
            boolean r5 = r4.b((com.alibaba.a.c.bb) r5)
            if (r5 == 0) goto L_0x003c
            com.alibaba.a.c.w[] r5 = r1.f6277b
            goto L_0x003e
        L_0x003c:
            com.alibaba.a.c.w[] r5 = r1.f6276a
        L_0x003e:
            com.alibaba.a.c.ax r8 = r2.j
            int r9 = r1.f6278c
            r10 = r24
            r2.a(r8, r0, r10, r9)
            int r9 = r1.f6278c
            com.alibaba.a.c.bb r10 = com.alibaba.a.c.bb.BeanToArray
            boolean r9 = com.alibaba.a.c.bb.isEnabled(r9, r10)
            if (r9 == 0) goto L_0x0053
            r9 = 1
            goto L_0x0059
        L_0x0053:
            com.alibaba.a.c.bb r9 = com.alibaba.a.c.bb.BeanToArray
            boolean r9 = r2.b((com.alibaba.a.c.bb) r9)
        L_0x0059:
            if (r9 == 0) goto L_0x005e
            r10 = 91
            goto L_0x0060
        L_0x005e:
            r10 = 123(0x7b, float:1.72E-43)
        L_0x0060:
            if (r9 == 0) goto L_0x0065
            r11 = 93
            goto L_0x0067
        L_0x0065:
            r11 = 125(0x7d, float:1.75E-43)
        L_0x0067:
            r4.b((char) r10)     // Catch:{ Exception -> 0x024c }
            int r10 = r5.length     // Catch:{ Exception -> 0x024c }
            if (r10 <= 0) goto L_0x007b
            com.alibaba.a.c.bb r10 = com.alibaba.a.c.bb.PrettyFormat     // Catch:{ Exception -> 0x024c }
            boolean r10 = r4.b((com.alibaba.a.c.bb) r10)     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x007b
            r22.b()     // Catch:{ Exception -> 0x024c }
            r22.d()     // Catch:{ Exception -> 0x024c }
        L_0x007b:
            boolean r10 = r1.a(r2, r3)     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x0095
            java.lang.Class r10 = r23.getClass()     // Catch:{ Exception -> 0x024c }
            if (r10 == r3) goto L_0x0095
            java.lang.String r3 = com.alibaba.a.a.DEFAULT_TYPE_KEY     // Catch:{ Exception -> 0x024c }
            r4.a((java.lang.String) r3, (boolean) r7)     // Catch:{ Exception -> 0x024c }
            java.lang.Class r3 = r23.getClass()     // Catch:{ Exception -> 0x024c }
            r2.c(r3)     // Catch:{ Exception -> 0x024c }
            r3 = 1
            goto L_0x0096
        L_0x0095:
            r3 = 0
        L_0x0096:
            r10 = 44
            if (r3 == 0) goto L_0x009d
            r3 = 44
            goto L_0x009e
        L_0x009d:
            r3 = 0
        L_0x009e:
            java.util.List<com.alibaba.a.c.c> r12 = r2.f6267b     // Catch:{ Exception -> 0x024c }
            r13 = 0
            if (r12 == 0) goto L_0x00d0
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x024c }
        L_0x00a7:
            boolean r14 = r12.hasNext()     // Catch:{ Exception -> 0x024c }
            if (r14 == 0) goto L_0x00d0
            r12.next()     // Catch:{ Exception -> 0x024c }
            java.lang.ThreadLocal<com.alibaba.a.c.ah> r14 = com.alibaba.a.c.c.f6314a     // Catch:{ Exception -> 0x024c }
            r14.set(r2)     // Catch:{ Exception -> 0x024c }
            java.lang.ThreadLocal<java.lang.Character> r14 = com.alibaba.a.c.c.f6315b     // Catch:{ Exception -> 0x024c }
            java.lang.Character r3 = java.lang.Character.valueOf(r3)     // Catch:{ Exception -> 0x024c }
            r14.set(r3)     // Catch:{ Exception -> 0x024c }
            java.lang.ThreadLocal<com.alibaba.a.c.ah> r3 = com.alibaba.a.c.c.f6314a     // Catch:{ Exception -> 0x024c }
            r3.set(r13)     // Catch:{ Exception -> 0x024c }
            java.lang.ThreadLocal<java.lang.Character> r3 = com.alibaba.a.c.c.f6315b     // Catch:{ Exception -> 0x024c }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x024c }
            java.lang.Character r3 = (java.lang.Character) r3     // Catch:{ Exception -> 0x024c }
            char r3 = r3.charValue()     // Catch:{ Exception -> 0x024c }
            goto L_0x00a7
        L_0x00d0:
            if (r3 != r10) goto L_0x00d4
            r3 = 1
            goto L_0x00d5
        L_0x00d4:
            r3 = 0
        L_0x00d5:
            r12 = r3
            r3 = 0
        L_0x00d7:
            int r14 = r5.length     // Catch:{ Exception -> 0x024c }
            if (r3 >= r14) goto L_0x01fa
            r14 = r5[r3]     // Catch:{ Exception -> 0x024c }
            com.alibaba.a.c.bb r15 = com.alibaba.a.c.bb.SkipTransientField     // Catch:{ Exception -> 0x024c }
            boolean r15 = r2.b((com.alibaba.a.c.bb) r15)     // Catch:{ Exception -> 0x024c }
            if (r15 == 0) goto L_0x00f4
            java.lang.reflect.Field r15 = r14.a()     // Catch:{ Exception -> 0x024c }
            if (r15 == 0) goto L_0x00f4
            int r15 = r15.getModifiers()     // Catch:{ Exception -> 0x024c }
            boolean r15 = java.lang.reflect.Modifier.isTransient(r15)     // Catch:{ Exception -> 0x024c }
            if (r15 != 0) goto L_0x01ef
        L_0x00f4:
            boolean r15 = com.alibaba.a.c.x.a((com.alibaba.a.c.ah) r22)     // Catch:{ Exception -> 0x024c }
            if (r15 == 0) goto L_0x01ef
            java.lang.Object r15 = r14.a((java.lang.Object) r0)     // Catch:{ Exception -> 0x024c }
            boolean r16 = com.alibaba.a.c.x.b((com.alibaba.a.c.ah) r22)     // Catch:{ Exception -> 0x024c }
            if (r16 == 0) goto L_0x01ef
            java.lang.String r6 = r14.b()     // Catch:{ Exception -> 0x024c }
            java.lang.String r6 = com.alibaba.a.c.x.a((com.alibaba.a.c.ah) r2, (java.lang.String) r6)     // Catch:{ Exception -> 0x024c }
            java.lang.Object r13 = com.alibaba.a.c.x.a((com.alibaba.a.c.ah) r2, (java.lang.Object) r15)     // Catch:{ Exception -> 0x024c }
            if (r13 != 0) goto L_0x0120
            if (r9 != 0) goto L_0x0120
            boolean r7 = r14.f6337b     // Catch:{ Exception -> 0x024c }
            if (r7 != 0) goto L_0x0120
            com.alibaba.a.c.bb r7 = com.alibaba.a.c.bb.WriteMapNullValue     // Catch:{ Exception -> 0x024c }
            boolean r7 = r2.b((com.alibaba.a.c.bb) r7)     // Catch:{ Exception -> 0x024c }
            if (r7 == 0) goto L_0x01ef
        L_0x0120:
            if (r13 == 0) goto L_0x01b1
            com.alibaba.a.c.bb r7 = com.alibaba.a.c.bb.NotWriteDefaultValue     // Catch:{ Exception -> 0x024c }
            boolean r7 = r2.b((com.alibaba.a.c.bb) r7)     // Catch:{ Exception -> 0x024c }
            if (r7 == 0) goto L_0x01b1
            com.alibaba.a.d.c r7 = r14.f6336a     // Catch:{ Exception -> 0x024c }
            java.lang.Class<?> r7 = r7.f6354d     // Catch:{ Exception -> 0x024c }
            java.lang.Class r10 = java.lang.Byte.TYPE     // Catch:{ Exception -> 0x024c }
            if (r7 != r10) goto L_0x013f
            boolean r10 = r13 instanceof java.lang.Byte     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x013f
            r10 = r13
            java.lang.Byte r10 = (java.lang.Byte) r10     // Catch:{ Exception -> 0x024c }
            byte r10 = r10.byteValue()     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x01ef
        L_0x013f:
            java.lang.Class r10 = java.lang.Short.TYPE     // Catch:{ Exception -> 0x024c }
            if (r7 != r10) goto L_0x0150
            boolean r10 = r13 instanceof java.lang.Short     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x0150
            r10 = r13
            java.lang.Short r10 = (java.lang.Short) r10     // Catch:{ Exception -> 0x024c }
            short r10 = r10.shortValue()     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x01ef
        L_0x0150:
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x024c }
            if (r7 != r10) goto L_0x0161
            boolean r10 = r13 instanceof java.lang.Integer     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x0161
            r10 = r13
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ Exception -> 0x024c }
            int r10 = r10.intValue()     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x01ef
        L_0x0161:
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x024c }
            if (r7 != r10) goto L_0x0176
            boolean r10 = r13 instanceof java.lang.Long     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x0176
            r10 = r13
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ Exception -> 0x024c }
            long r17 = r10.longValue()     // Catch:{ Exception -> 0x024c }
            r19 = 0
            int r10 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r10 == 0) goto L_0x01ef
        L_0x0176:
            java.lang.Class r10 = java.lang.Float.TYPE     // Catch:{ Exception -> 0x024c }
            if (r7 != r10) goto L_0x018b
            boolean r10 = r13 instanceof java.lang.Float     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x018b
            r10 = r13
            java.lang.Float r10 = (java.lang.Float) r10     // Catch:{ Exception -> 0x024c }
            float r10 = r10.floatValue()     // Catch:{ Exception -> 0x024c }
            r17 = 0
            int r10 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r10 == 0) goto L_0x01ef
        L_0x018b:
            java.lang.Class r10 = java.lang.Double.TYPE     // Catch:{ Exception -> 0x024c }
            if (r7 != r10) goto L_0x01a0
            boolean r10 = r13 instanceof java.lang.Double     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x01a0
            r10 = r13
            java.lang.Double r10 = (java.lang.Double) r10     // Catch:{ Exception -> 0x024c }
            double r17 = r10.doubleValue()     // Catch:{ Exception -> 0x024c }
            r19 = 0
            int r10 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r10 == 0) goto L_0x01ef
        L_0x01a0:
            java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x024c }
            if (r7 != r10) goto L_0x01b1
            boolean r7 = r13 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x024c }
            if (r7 == 0) goto L_0x01b1
            r7 = r13
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ Exception -> 0x024c }
            boolean r7 = r7.booleanValue()     // Catch:{ Exception -> 0x024c }
            if (r7 == 0) goto L_0x01ef
        L_0x01b1:
            if (r12 == 0) goto L_0x01c4
            r7 = 44
            r4.b((char) r7)     // Catch:{ Exception -> 0x024c }
            com.alibaba.a.c.bb r10 = com.alibaba.a.c.bb.PrettyFormat     // Catch:{ Exception -> 0x024c }
            boolean r10 = r4.b((com.alibaba.a.c.bb) r10)     // Catch:{ Exception -> 0x024c }
            if (r10 == 0) goto L_0x01c6
            r22.d()     // Catch:{ Exception -> 0x024c }
            goto L_0x01c6
        L_0x01c4:
            r7 = 44
        L_0x01c6:
            java.lang.String r10 = r14.b()     // Catch:{ Exception -> 0x024c }
            if (r6 == r10) goto L_0x01d8
            if (r9 != 0) goto L_0x01d3
            r10 = 0
            r4.a((java.lang.String) r6, (boolean) r10)     // Catch:{ Exception -> 0x024c }
            goto L_0x01d4
        L_0x01d3:
            r10 = 0
        L_0x01d4:
            r2.c(r13)     // Catch:{ Exception -> 0x024c }
            goto L_0x01ed
        L_0x01d8:
            r10 = 0
            if (r15 == r13) goto L_0x01e4
            if (r9 != 0) goto L_0x01e0
            r14.a((com.alibaba.a.c.ah) r2)     // Catch:{ Exception -> 0x024c }
        L_0x01e0:
            r2.c(r13)     // Catch:{ Exception -> 0x024c }
            goto L_0x01ed
        L_0x01e4:
            if (r9 != 0) goto L_0x01ea
            r14.a(r2, r13)     // Catch:{ Exception -> 0x024c }
            goto L_0x01ed
        L_0x01ea:
            r14.b(r2, r13)     // Catch:{ Exception -> 0x024c }
        L_0x01ed:
            r12 = 1
            goto L_0x01f2
        L_0x01ef:
            r7 = 44
            r10 = 0
        L_0x01f2:
            int r3 = r3 + 1
            r7 = 0
            r10 = 44
            r13 = 0
            goto L_0x00d7
        L_0x01fa:
            r7 = 44
            r10 = 0
            if (r12 == 0) goto L_0x0200
            goto L_0x0201
        L_0x0200:
            r7 = 0
        L_0x0201:
            java.util.List<com.alibaba.a.c.a> r0 = r2.f6268c     // Catch:{ Exception -> 0x024c }
            if (r0 == 0) goto L_0x0233
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x024c }
        L_0x0209:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x024c }
            if (r3 == 0) goto L_0x0233
            r0.next()     // Catch:{ Exception -> 0x024c }
            java.lang.ThreadLocal<com.alibaba.a.c.ah> r3 = com.alibaba.a.c.a.f6257a     // Catch:{ Exception -> 0x024c }
            r3.set(r2)     // Catch:{ Exception -> 0x024c }
            java.lang.ThreadLocal<java.lang.Character> r3 = com.alibaba.a.c.a.f6258b     // Catch:{ Exception -> 0x024c }
            java.lang.Character r6 = java.lang.Character.valueOf(r7)     // Catch:{ Exception -> 0x024c }
            r3.set(r6)     // Catch:{ Exception -> 0x024c }
            java.lang.ThreadLocal<com.alibaba.a.c.ah> r3 = com.alibaba.a.c.a.f6257a     // Catch:{ Exception -> 0x024c }
            r6 = 0
            r3.set(r6)     // Catch:{ Exception -> 0x024c }
            java.lang.ThreadLocal<java.lang.Character> r3 = com.alibaba.a.c.a.f6258b     // Catch:{ Exception -> 0x024c }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x024c }
            java.lang.Character r3 = (java.lang.Character) r3     // Catch:{ Exception -> 0x024c }
            char r7 = r3.charValue()     // Catch:{ Exception -> 0x024c }
            goto L_0x0209
        L_0x0233:
            int r0 = r5.length     // Catch:{ Exception -> 0x024c }
            if (r0 <= 0) goto L_0x0244
            com.alibaba.a.c.bb r0 = com.alibaba.a.c.bb.PrettyFormat     // Catch:{ Exception -> 0x024c }
            boolean r0 = r4.b((com.alibaba.a.c.bb) r0)     // Catch:{ Exception -> 0x024c }
            if (r0 == 0) goto L_0x0244
            r22.c()     // Catch:{ Exception -> 0x024c }
            r22.d()     // Catch:{ Exception -> 0x024c }
        L_0x0244:
            r4.b((char) r11)     // Catch:{ Exception -> 0x024c }
            r2.j = r8
            return
        L_0x024a:
            r0 = move-exception
            goto L_0x0256
        L_0x024c:
            r0 = move-exception
            com.alibaba.a.d r3 = new com.alibaba.a.d     // Catch:{ all -> 0x024a }
            java.lang.String r4 = "write javaBean error"
            r3.<init>(r4, r0)     // Catch:{ all -> 0x024a }
            throw r3     // Catch:{ all -> 0x024a }
        L_0x0256:
            r2.j = r8
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.c.aj.a(com.alibaba.a.c.ah, java.lang.Object, java.lang.Object, java.lang.reflect.Type):void");
    }

    private static w a(c cVar) {
        if (cVar.f6354d == Number.class) {
            return new aq(cVar);
        }
        return new as(cVar);
    }
}
