package com.alibaba.a.b.a;

public final class b implements z {

    /* renamed from: a  reason: collision with root package name */
    public static final b f6185a = new b();

    public final int a() {
        return 14;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Class} */
    /* JADX WARNING: type inference failed for: r8v4, types: [java.lang.reflect.Type] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(com.alibaba.a.b.b r7, java.lang.reflect.Type r8, java.lang.Object r9) {
        /*
            r6 = this;
            com.alibaba.a.b.d r0 = r7.g()
            int r1 = r0.a()
            r2 = 0
            r3 = 16
            r4 = 8
            if (r1 != r4) goto L_0x0013
            r0.a((int) r3)
            return r2
        L_0x0013:
            int r1 = r0.a()
            r4 = 4
            if (r1 != r4) goto L_0x0022
            byte[] r7 = r0.v()
            r0.a((int) r3)
            return r7
        L_0x0022:
            boolean r0 = r8 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x007a
            java.lang.reflect.GenericArrayType r8 = (java.lang.reflect.GenericArrayType) r8
            java.lang.reflect.Type r8 = r8.getGenericComponentType()
            boolean r0 = r8 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x0076
            java.lang.reflect.TypeVariable r8 = (java.lang.reflect.TypeVariable) r8
            com.alibaba.a.b.h r0 = r7.d()
            java.lang.reflect.Type r0 = r0.f6241c
            boolean r1 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r1 == 0) goto L_0x0073
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type r1 = r0.getRawType()
            boolean r3 = r1 instanceof java.lang.Class
            if (r3 == 0) goto L_0x0069
            java.lang.Class r1 = (java.lang.Class) r1
            java.lang.reflect.TypeVariable[] r1 = r1.getTypeParameters()
            r3 = 0
        L_0x004d:
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0069
            r4 = r1[r3]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = r8.getName()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0066
            java.lang.reflect.Type[] r2 = r0.getActualTypeArguments()
            r2 = r2[r3]
        L_0x0066:
            int r3 = r3 + 1
            goto L_0x004d
        L_0x0069:
            boolean r8 = r2 instanceof java.lang.Class
            if (r8 == 0) goto L_0x0070
            java.lang.Class r2 = (java.lang.Class) r2
            goto L_0x0080
        L_0x0070:
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            goto L_0x0080
        L_0x0073:
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            goto L_0x0080
        L_0x0076:
            r2 = r8
            java.lang.Class r2 = (java.lang.Class) r2
            goto L_0x0080
        L_0x007a:
            java.lang.Class r8 = (java.lang.Class) r8
            java.lang.Class r2 = r8.getComponentType()
        L_0x0080:
            com.alibaba.a.b r8 = new com.alibaba.a.b
            r8.<init>()
            r7.a((java.lang.reflect.Type) r2, (java.util.Collection) r8, (java.lang.Object) r9)
            java.lang.Object r7 = r6.a((com.alibaba.a.b.b) r7, (java.lang.Class<?>) r2, (com.alibaba.a.b) r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.a.b.a(com.alibaba.a.b.b, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r13v0, types: [java.lang.reflect.Type, java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T a(com.alibaba.a.b.b r12, java.lang.Class<?> r13, com.alibaba.a.b r14) {
        /*
            r11 = this;
            r0 = 0
            if (r14 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r14.size()
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r13, r1)
            r3 = 0
            r4 = 0
        L_0x000e:
            if (r4 >= r1) goto L_0x0065
            java.lang.Object r5 = r14.get(r4)
            if (r5 != r14) goto L_0x001a
            java.lang.reflect.Array.set(r2, r4, r2)
            goto L_0x0062
        L_0x001a:
            boolean r6 = r13.isArray()
            if (r6 == 0) goto L_0x0031
            boolean r6 = r13.isInstance(r5)
            if (r6 == 0) goto L_0x0027
            goto L_0x002d
        L_0x0027:
            com.alibaba.a.b r5 = (com.alibaba.a.b) r5
            java.lang.Object r5 = r11.a((com.alibaba.a.b.b) r12, (java.lang.Class<?>) r13, (com.alibaba.a.b) r5)
        L_0x002d:
            java.lang.reflect.Array.set(r2, r4, r5)
            goto L_0x0062
        L_0x0031:
            boolean r6 = r5 instanceof com.alibaba.a.b
            if (r6 == 0) goto L_0x0054
            r6 = r5
            com.alibaba.a.b r6 = (com.alibaba.a.b) r6
            int r7 = r6.size()
            r8 = 0
            r9 = 0
        L_0x003e:
            if (r8 >= r7) goto L_0x004d
            java.lang.Object r10 = r6.get(r8)
            if (r10 != r14) goto L_0x004a
            r6.set(r4, r2)
            r9 = 1
        L_0x004a:
            int r8 = r8 + 1
            goto L_0x003e
        L_0x004d:
            if (r9 == 0) goto L_0x0054
            java.lang.Object[] r6 = r6.toArray()
            goto L_0x0055
        L_0x0054:
            r6 = r0
        L_0x0055:
            if (r6 != 0) goto L_0x005f
            com.alibaba.a.b.i r6 = r12.c()
            java.lang.Object r6 = com.alibaba.a.d.g.a((java.lang.Object) r5, r13, (com.alibaba.a.b.i) r6)
        L_0x005f:
            java.lang.reflect.Array.set(r2, r4, r6)
        L_0x0062:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x0065:
            r14.setRelatedArray(r2)
            r14.setComponentType(r13)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.a.b.a(com.alibaba.a.b.b, java.lang.Class, com.alibaba.a.b):java.lang.Object");
    }
}
