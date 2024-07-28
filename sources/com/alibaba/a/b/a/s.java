package com.alibaba.a.b.a;

import com.alibaba.a.b.i;
import com.alibaba.a.c.x;
import com.alibaba.a.d;
import com.alibaba.a.d.b;
import com.alibaba.a.d.c;
import com.alibaba.a.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class s implements z {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, o> f6203a;

    /* renamed from: b  reason: collision with root package name */
    private final List<o> f6204b;

    /* renamed from: c  reason: collision with root package name */
    private final List<o> f6205c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f6206d;

    /* renamed from: e  reason: collision with root package name */
    private b f6207e;

    public int a() {
        return 12;
    }

    public s(i iVar, Class<?> cls) {
        this(iVar, cls, cls);
    }

    public s(i iVar, Class<?> cls, Type type) {
        this.f6203a = new IdentityHashMap();
        this.f6204b = new ArrayList();
        this.f6205c = new ArrayList();
        this.f6206d = cls;
        this.f6207e = b.a(cls, type);
        for (c next : this.f6207e.f6348d) {
            String intern = next.f6351a.intern();
            o a2 = i.a(iVar, cls, next);
            this.f6203a.put(intern, a2);
            this.f6204b.add(a2);
        }
        for (c cVar : this.f6207e.f6349e) {
            this.f6205c.add(this.f6203a.get(cVar.f6351a.intern()));
        }
    }

    public final Object a(com.alibaba.a.b.b bVar, Type type) {
        Object obj;
        if ((type instanceof Class) && this.f6206d.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new e());
        } else if (this.f6207e.f6345a == null) {
            return null;
        } else {
            try {
                Constructor<?> constructor = this.f6207e.f6345a;
                if (constructor.getParameterTypes().length == 0) {
                    obj = constructor.newInstance(new Object[0]);
                } else {
                    obj = constructor.newInstance(new Object[]{bVar.d().f6239a});
                }
                if (bVar.a(com.alibaba.a.b.c.InitStringFieldAsEmpty)) {
                    for (c next : this.f6207e.f6348d) {
                        if (next.f6354d == String.class) {
                            try {
                                if (next.f6352b != null) {
                                    next.f6352b.invoke(obj, new Object[]{""});
                                } else {
                                    next.f6353c.set(obj, "");
                                }
                            } catch (Exception e2) {
                                throw new d("create instance error, class " + this.f6206d.getName(), e2);
                            }
                        }
                    }
                }
                return obj;
            } catch (Exception e3) {
                throw new d("create instance error, class " + this.f6206d.getName(), e3);
            }
        }
    }

    public <T> T a(com.alibaba.a.b.b bVar, Type type, Object obj) {
        return a(bVar, type, obj, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x018e, code lost:
        r0 = r11.l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0198, code lost:
        if ("@".equals(r0) == false) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x019a, code lost:
        r0 = r13.f6239a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x019c, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01a4, code lost:
        if ("..".equals(r0) == false) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01a6, code lost:
        r3 = r13.f6240b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01aa, code lost:
        if (r3.f6239a == null) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01ac, code lost:
        r0 = r3.f6239a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01af, code lost:
        r8.a(new com.alibaba.a.b.b.a(r3, r0));
        r8.f6223f = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01c0, code lost:
        if ("$".equals(r0) == false) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01c2, code lost:
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01c5, code lost:
        if (r3.f6240b == null) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01c7, code lost:
        r3 = r3.f6240b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01cc, code lost:
        if (r3.f6239a == null) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01ce, code lost:
        r0 = r3.f6239a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01d1, code lost:
        r8.a(new com.alibaba.a.b.b.a(r3, r0));
        r8.f6223f = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01dc, code lost:
        r8.a(new com.alibaba.a.b.b.a(r13, r0));
        r8.f6223f = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01e6, code lost:
        r11.a(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01ed, code lost:
        if (r11.a() != 13) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01ef, code lost:
        r11.a(16);
        r8.a(r13, r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01f5, code lost:
        if (r2 == null) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01f7, code lost:
        r2.f6239a = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01f9, code lost:
        r8.a(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01fc, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0204, code lost:
        throw new com.alibaba.a.d("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0220, code lost:
        throw new com.alibaba.a.d("illegal ref, " + com.alibaba.a.b.g.a(r11.a()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0266, code lost:
        if (r2 == null) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0268, code lost:
        r2.f6239a = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x026a, code lost:
        r8.a(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x026d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02bd, code lost:
        r1 = r10;
        r10 = r17;
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0383, code lost:
        throw new com.alibaba.a.d("syntax error, unexpect token " + com.alibaba.a.b.g.a(r11.a()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0185, code lost:
        r11.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x018c, code lost:
        if (r11.a() != 4) goto L_0x0205;
     */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0069 A[SYNTHETIC, Splitter:B:32:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T a(com.alibaba.a.b.b r20, java.lang.reflect.Type r21, java.lang.Object r22, java.lang.Object r23) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r0 = r21
            r9 = r22
            java.lang.Class<com.alibaba.a.a> r1 = com.alibaba.a.a.class
            r10 = 0
            if (r0 == r1) goto L_0x03a0
            java.lang.Class<com.alibaba.a.e> r1 = com.alibaba.a.e.class
            if (r0 != r1) goto L_0x0013
            goto L_0x03a0
        L_0x0013:
            com.alibaba.a.b.d r11 = r20.g()
            int r1 = r11.a()
            r2 = 8
            r12 = 16
            if (r1 != r2) goto L_0x0025
            r11.a((int) r12)
            return r10
        L_0x0025:
            com.alibaba.a.b.h r13 = r20.d()
            int r1 = r11.a()     // Catch:{ all -> 0x0394 }
            r14 = 13
            if (r1 != r14) goto L_0x0042
            r11.a((int) r12)     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r19.a(r20, r21)     // Catch:{ all -> 0x003c }
            r8.a((com.alibaba.a.b.h) r13)
            return r0
        L_0x003c:
            r0 = move-exception
            r1 = r23
            r2 = r10
            goto L_0x0398
        L_0x0042:
            int r1 = r11.a()     // Catch:{ all -> 0x0394 }
            java.lang.String r15 = "syntax error"
            r2 = 14
            r6 = 0
            r5 = 1
            if (r1 != r2) goto L_0x0113
            com.alibaba.a.d.b r1 = r7.f6207e     // Catch:{ all -> 0x0394 }
            int r1 = r1.f6350f     // Catch:{ all -> 0x0394 }
            com.alibaba.a.b.c r3 = com.alibaba.a.b.c.SupportArrayToBean     // Catch:{ all -> 0x0394 }
            boolean r1 = com.alibaba.a.b.c.isEnabled(r1, r3)     // Catch:{ all -> 0x0394 }
            if (r1 != 0) goto L_0x0066
            com.alibaba.a.b.c r1 = com.alibaba.a.b.c.SupportArrayToBean     // Catch:{ all -> 0x003c }
            boolean r1 = r11.a((com.alibaba.a.b.c) r1)     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r1 = 0
            goto L_0x0067
        L_0x0066:
            r1 = 1
        L_0x0067:
            if (r1 == 0) goto L_0x0113
            com.alibaba.a.b.d r1 = r20.g()     // Catch:{ all -> 0x0394 }
            int r3 = r1.a()     // Catch:{ all -> 0x0394 }
            if (r3 != r2) goto L_0x010b
            java.lang.Object r0 = r19.a(r20, r21)     // Catch:{ all -> 0x0394 }
            java.util.List<com.alibaba.a.b.a.o> r3 = r7.f6205c     // Catch:{ all -> 0x0394 }
            int r3 = r3.size()     // Catch:{ all -> 0x0394 }
        L_0x007d:
            if (r6 >= r3) goto L_0x0104
            int r4 = r3 + -1
            r5 = 93
            r9 = 44
            if (r6 != r4) goto L_0x008a
            r4 = 93
            goto L_0x008c
        L_0x008a:
            r4 = 44
        L_0x008c:
            java.util.List<com.alibaba.a.b.a.o> r11 = r7.f6205c     // Catch:{ all -> 0x0394 }
            java.lang.Object r11 = r11.get(r6)     // Catch:{ all -> 0x0394 }
            com.alibaba.a.b.a.o r11 = (com.alibaba.a.b.a.o) r11     // Catch:{ all -> 0x0394 }
            java.lang.Class r14 = r11.c()     // Catch:{ all -> 0x0394 }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0394 }
            if (r14 != r10) goto L_0x00a4
            int r4 = r1.b((char) r4)     // Catch:{ all -> 0x0394 }
            r11.a((java.lang.Object) r0, (int) r4)     // Catch:{ all -> 0x0394 }
            goto L_0x00ff
        L_0x00a4:
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            if (r14 != r10) goto L_0x00b0
            java.lang.String r4 = r1.c(r4)     // Catch:{ all -> 0x0394 }
            r11.a((java.lang.Object) r0, (java.lang.Object) r4)     // Catch:{ all -> 0x0394 }
            goto L_0x00ff
        L_0x00b0:
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ all -> 0x0394 }
            if (r14 != r10) goto L_0x00bc
            long r4 = r1.a((char) r4)     // Catch:{ all -> 0x0394 }
            r11.a((java.lang.Object) r0, (long) r4)     // Catch:{ all -> 0x0394 }
            goto L_0x00ff
        L_0x00bc:
            boolean r10 = r14.isEnum()     // Catch:{ all -> 0x0394 }
            if (r10 == 0) goto L_0x00ce
            com.alibaba.a.b.j r5 = r20.b()     // Catch:{ all -> 0x0394 }
            java.lang.Enum r4 = r1.a(r14, r5, r4)     // Catch:{ all -> 0x0394 }
            r11.a((java.lang.Object) r0, (java.lang.Object) r4)     // Catch:{ all -> 0x0394 }
            goto L_0x00ff
        L_0x00ce:
            r1.a((int) r2)     // Catch:{ all -> 0x0394 }
            java.lang.reflect.Type r10 = r11.d()     // Catch:{ all -> 0x0394 }
            java.lang.Object r10 = r8.a((java.lang.reflect.Type) r10)     // Catch:{ all -> 0x0394 }
            r11.a((java.lang.Object) r0, (java.lang.Object) r10)     // Catch:{ all -> 0x0394 }
            if (r4 != r5) goto L_0x00f0
            int r4 = r1.a()     // Catch:{ all -> 0x0394 }
            r5 = 15
            if (r4 != r5) goto L_0x00ea
            r1.a((int) r12)     // Catch:{ all -> 0x0394 }
            goto L_0x00ff
        L_0x00ea:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0394 }
            r0.<init>(r15)     // Catch:{ all -> 0x0394 }
            throw r0     // Catch:{ all -> 0x0394 }
        L_0x00f0:
            if (r4 != r9) goto L_0x00ff
            int r4 = r1.a()     // Catch:{ all -> 0x0394 }
            if (r4 != r12) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0394 }
            r0.<init>(r15)     // Catch:{ all -> 0x0394 }
            throw r0     // Catch:{ all -> 0x0394 }
        L_0x00ff:
            int r6 = r6 + 1
            r10 = 0
            goto L_0x007d
        L_0x0104:
            r1.a((int) r12)     // Catch:{ all -> 0x0394 }
            r8.a((com.alibaba.a.b.h) r13)
            return r0
        L_0x010b:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0394 }
            java.lang.String r1 = "error"
            r0.<init>(r1)     // Catch:{ all -> 0x0394 }
            throw r0     // Catch:{ all -> 0x0394 }
        L_0x0113:
            int r1 = r11.a()     // Catch:{ all -> 0x0394 }
            r2 = 12
            if (r1 == r2) goto L_0x0152
            int r1 = r11.a()     // Catch:{ all -> 0x0394 }
            if (r1 == r12) goto L_0x0152
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x0394 }
            java.lang.String r1 = "syntax error, expect {, actual "
            r0.<init>(r1)     // Catch:{ all -> 0x0394 }
            java.lang.String r1 = r11.b()     // Catch:{ all -> 0x0394 }
            r0.append(r1)     // Catch:{ all -> 0x0394 }
            java.lang.String r1 = ", pos "
            r0.append(r1)     // Catch:{ all -> 0x0394 }
            int r1 = r11.i()     // Catch:{ all -> 0x0394 }
            r0.append(r1)     // Catch:{ all -> 0x0394 }
            boolean r1 = r9 instanceof java.lang.String     // Catch:{ all -> 0x0394 }
            if (r1 == 0) goto L_0x0148
            java.lang.String r1 = ", fieldName "
            r0.append(r1)     // Catch:{ all -> 0x0394 }
            r0.append(r9)     // Catch:{ all -> 0x0394 }
        L_0x0148:
            com.alibaba.a.d r1 = new com.alibaba.a.d     // Catch:{ all -> 0x0394 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0394 }
            r1.<init>(r0)     // Catch:{ all -> 0x0394 }
            throw r1     // Catch:{ all -> 0x0394 }
        L_0x0152:
            int r1 = r8.f6223f     // Catch:{ all -> 0x0394 }
            r2 = 2
            if (r1 != r2) goto L_0x0159
            r8.f6223f = r6     // Catch:{ all -> 0x0394 }
        L_0x0159:
            r1 = r23
            r2 = 0
            r10 = 0
        L_0x015d:
            com.alibaba.a.b.j r3 = r20.b()     // Catch:{ all -> 0x0392 }
            java.lang.String r3 = r11.a((com.alibaba.a.b.j) r3)     // Catch:{ all -> 0x0392 }
            if (r3 != 0) goto L_0x0180
            int r4 = r11.a()     // Catch:{ all -> 0x0392 }
            if (r4 != r14) goto L_0x0172
            r11.a((int) r12)     // Catch:{ all -> 0x0392 }
            goto L_0x024f
        L_0x0172:
            int r4 = r11.a()     // Catch:{ all -> 0x0392 }
            if (r4 != r12) goto L_0x0180
            com.alibaba.a.b.c r4 = com.alibaba.a.b.c.AllowArbitraryCommas     // Catch:{ all -> 0x0392 }
            boolean r4 = r8.a((com.alibaba.a.b.c) r4)     // Catch:{ all -> 0x0392 }
            if (r4 != 0) goto L_0x0253
        L_0x0180:
            java.lang.String r4 = "$ref"
            r6 = 4
            if (r4 != r3) goto L_0x0221
            r11.p()     // Catch:{ all -> 0x0392 }
            int r0 = r11.a()     // Catch:{ all -> 0x0392 }
            if (r0 != r6) goto L_0x0205
            java.lang.String r0 = r11.l()     // Catch:{ all -> 0x0392 }
            java.lang.String r3 = "@"
            boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x0392 }
            if (r3 == 0) goto L_0x019e
            java.lang.Object r0 = r13.f6239a     // Catch:{ all -> 0x0392 }
        L_0x019c:
            r1 = r0
            goto L_0x01e6
        L_0x019e:
            java.lang.String r3 = ".."
            boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x0392 }
            if (r3 == 0) goto L_0x01ba
            com.alibaba.a.b.h r3 = r13.f6240b     // Catch:{ all -> 0x0392 }
            java.lang.Object r4 = r3.f6239a     // Catch:{ all -> 0x0392 }
            if (r4 == 0) goto L_0x01af
            java.lang.Object r0 = r3.f6239a     // Catch:{ all -> 0x0392 }
            goto L_0x019c
        L_0x01af:
            com.alibaba.a.b.b$a r4 = new com.alibaba.a.b.b$a     // Catch:{ all -> 0x0392 }
            r4.<init>(r3, r0)     // Catch:{ all -> 0x0392 }
            r8.a((com.alibaba.a.b.b.a) r4)     // Catch:{ all -> 0x0392 }
            r8.f6223f = r5     // Catch:{ all -> 0x0392 }
            goto L_0x01e6
        L_0x01ba:
            java.lang.String r3 = "$"
            boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x0392 }
            if (r3 == 0) goto L_0x01dc
            r3 = r13
        L_0x01c3:
            com.alibaba.a.b.h r4 = r3.f6240b     // Catch:{ all -> 0x0392 }
            if (r4 == 0) goto L_0x01ca
            com.alibaba.a.b.h r3 = r3.f6240b     // Catch:{ all -> 0x0392 }
            goto L_0x01c3
        L_0x01ca:
            java.lang.Object r4 = r3.f6239a     // Catch:{ all -> 0x0392 }
            if (r4 == 0) goto L_0x01d1
            java.lang.Object r0 = r3.f6239a     // Catch:{ all -> 0x0392 }
            goto L_0x019c
        L_0x01d1:
            com.alibaba.a.b.b$a r4 = new com.alibaba.a.b.b$a     // Catch:{ all -> 0x0392 }
            r4.<init>(r3, r0)     // Catch:{ all -> 0x0392 }
            r8.a((com.alibaba.a.b.b.a) r4)     // Catch:{ all -> 0x0392 }
            r8.f6223f = r5     // Catch:{ all -> 0x0392 }
            goto L_0x01e6
        L_0x01dc:
            com.alibaba.a.b.b$a r3 = new com.alibaba.a.b.b$a     // Catch:{ all -> 0x0392 }
            r3.<init>(r13, r0)     // Catch:{ all -> 0x0392 }
            r8.a((com.alibaba.a.b.b.a) r3)     // Catch:{ all -> 0x0392 }
            r8.f6223f = r5     // Catch:{ all -> 0x0392 }
        L_0x01e6:
            r11.a((int) r14)     // Catch:{ all -> 0x0392 }
            int r0 = r11.a()     // Catch:{ all -> 0x0392 }
            if (r0 != r14) goto L_0x01fd
            r11.a((int) r12)     // Catch:{ all -> 0x0392 }
            r8.a((com.alibaba.a.b.h) r13, (java.lang.Object) r1, (java.lang.Object) r9)     // Catch:{ all -> 0x0392 }
            if (r2 == 0) goto L_0x01f9
            r2.f6239a = r1
        L_0x01f9:
            r8.a((com.alibaba.a.b.h) r13)
            return r1
        L_0x01fd:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0392 }
            java.lang.String r3 = "illegal ref"
            r0.<init>(r3)     // Catch:{ all -> 0x0392 }
            throw r0     // Catch:{ all -> 0x0392 }
        L_0x0205:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0392 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0392 }
            java.lang.String r4 = "illegal ref, "
            r3.<init>(r4)     // Catch:{ all -> 0x0392 }
            int r4 = r11.a()     // Catch:{ all -> 0x0392 }
            java.lang.String r4 = com.alibaba.a.b.g.a(r4)     // Catch:{ all -> 0x0392 }
            r3.append(r4)     // Catch:{ all -> 0x0392 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0392 }
            r0.<init>(r3)     // Catch:{ all -> 0x0392 }
            throw r0     // Catch:{ all -> 0x0392 }
        L_0x0221:
            java.lang.String r4 = com.alibaba.a.a.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0392 }
            if (r4 != r3) goto L_0x0274
            r11.p()     // Catch:{ all -> 0x0392 }
            int r3 = r11.a()     // Catch:{ all -> 0x0392 }
            if (r3 != r6) goto L_0x026e
            java.lang.String r3 = r11.l()     // Catch:{ all -> 0x0392 }
            r11.a((int) r12)     // Catch:{ all -> 0x0392 }
            boolean r4 = r0 instanceof java.lang.Class     // Catch:{ all -> 0x0392 }
            if (r4 == 0) goto L_0x0256
            r4 = r0
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ all -> 0x0392 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0392 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0392 }
            if (r4 == 0) goto L_0x0256
            int r3 = r11.a()     // Catch:{ all -> 0x0392 }
            if (r3 != r14) goto L_0x0253
            r11.d()     // Catch:{ all -> 0x0392 }
        L_0x024f:
            r16 = 0
            goto L_0x02c2
        L_0x0253:
            r6 = 0
            goto L_0x015d
        L_0x0256:
            java.lang.Class r0 = com.alibaba.a.d.g.a((java.lang.String) r3)     // Catch:{ all -> 0x0392 }
            com.alibaba.a.b.i r3 = r20.c()     // Catch:{ all -> 0x0392 }
            com.alibaba.a.b.a.z r3 = r3.a((java.lang.reflect.Type) r0)     // Catch:{ all -> 0x0392 }
            java.lang.Object r0 = r3.a(r8, r0, r9)     // Catch:{ all -> 0x0392 }
            if (r2 == 0) goto L_0x026a
            r2.f6239a = r1
        L_0x026a:
            r8.a((com.alibaba.a.b.h) r13)
            return r0
        L_0x026e:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0392 }
            r0.<init>(r15)     // Catch:{ all -> 0x0392 }
            throw r0     // Catch:{ all -> 0x0392 }
        L_0x0274:
            if (r1 != 0) goto L_0x028d
            if (r10 != 0) goto L_0x028d
            java.lang.Object r1 = r19.a(r20, r21)     // Catch:{ all -> 0x0392 }
            if (r1 != 0) goto L_0x0289
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ all -> 0x0392 }
            java.util.List<com.alibaba.a.b.a.o> r4 = r7.f6204b     // Catch:{ all -> 0x0392 }
            int r4 = r4.size()     // Catch:{ all -> 0x0392 }
            r10.<init>(r4)     // Catch:{ all -> 0x0392 }
        L_0x0289:
            com.alibaba.a.b.h r2 = r8.a((com.alibaba.a.b.h) r13, (java.lang.Object) r1, (java.lang.Object) r9)     // Catch:{ all -> 0x0392 }
        L_0x028d:
            r18 = r2
            r17 = r10
            r10 = r1
            r1 = r19
            r2 = r20
            r4 = r10
            r6 = 1
            r5 = r21
            r16 = 0
            r6 = r17
            boolean r1 = r1.a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x038d }
            if (r1 != 0) goto L_0x02ae
            int r1 = r11.a()     // Catch:{ all -> 0x038d }
            if (r1 != r14) goto L_0x0384
            r11.d()     // Catch:{ all -> 0x038d }
            goto L_0x02bd
        L_0x02ae:
            int r1 = r11.a()     // Catch:{ all -> 0x038d }
            if (r1 == r12) goto L_0x0384
            int r1 = r11.a()     // Catch:{ all -> 0x038d }
            if (r1 != r14) goto L_0x0357
            r11.a((int) r12)     // Catch:{ all -> 0x038d }
        L_0x02bd:
            r1 = r10
            r10 = r17
            r2 = r18
        L_0x02c2:
            if (r1 != 0) goto L_0x034f
            if (r10 != 0) goto L_0x02d8
            java.lang.Object r1 = r19.a(r20, r21)     // Catch:{ all -> 0x0392 }
            if (r2 != 0) goto L_0x02d0
            com.alibaba.a.b.h r2 = r8.a((com.alibaba.a.b.h) r13, (java.lang.Object) r1, (java.lang.Object) r9)     // Catch:{ all -> 0x0392 }
        L_0x02d0:
            if (r2 == 0) goto L_0x02d4
            r2.f6239a = r1
        L_0x02d4:
            r8.a((com.alibaba.a.b.h) r13)
            return r1
        L_0x02d8:
            com.alibaba.a.d.b r0 = r7.f6207e     // Catch:{ all -> 0x0392 }
            java.util.List<com.alibaba.a.d.c> r0 = r0.f6348d     // Catch:{ all -> 0x0392 }
            int r3 = r0.size()     // Catch:{ all -> 0x0392 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0392 }
            r5 = 0
        L_0x02e3:
            if (r5 >= r3) goto L_0x02f6
            java.lang.Object r6 = r0.get(r5)     // Catch:{ all -> 0x0392 }
            com.alibaba.a.d.c r6 = (com.alibaba.a.d.c) r6     // Catch:{ all -> 0x0392 }
            java.lang.String r6 = r6.f6351a     // Catch:{ all -> 0x0392 }
            java.lang.Object r6 = r10.get(r6)     // Catch:{ all -> 0x0392 }
            r4[r5] = r6     // Catch:{ all -> 0x0392 }
            int r5 = r5 + 1
            goto L_0x02e3
        L_0x02f6:
            com.alibaba.a.d.b r0 = r7.f6207e     // Catch:{ all -> 0x0392 }
            java.lang.reflect.Constructor<?> r0 = r0.f6346b     // Catch:{ all -> 0x0392 }
            if (r0 == 0) goto L_0x0322
            com.alibaba.a.d.b r0 = r7.f6207e     // Catch:{ Exception -> 0x0305 }
            java.lang.reflect.Constructor<?> r0 = r0.f6346b     // Catch:{ Exception -> 0x0305 }
            java.lang.Object r1 = r0.newInstance(r4)     // Catch:{ Exception -> 0x0305 }
            goto L_0x034f
        L_0x0305:
            r0 = move-exception
            com.alibaba.a.d r3 = new com.alibaba.a.d     // Catch:{ all -> 0x0392 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0392 }
            java.lang.String r5 = "create instance error, "
            r4.<init>(r5)     // Catch:{ all -> 0x0392 }
            com.alibaba.a.d.b r5 = r7.f6207e     // Catch:{ all -> 0x0392 }
            java.lang.reflect.Constructor<?> r5 = r5.f6346b     // Catch:{ all -> 0x0392 }
            java.lang.String r5 = r5.toGenericString()     // Catch:{ all -> 0x0392 }
            r4.append(r5)     // Catch:{ all -> 0x0392 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0392 }
            r3.<init>(r4, r0)     // Catch:{ all -> 0x0392 }
            throw r3     // Catch:{ all -> 0x0392 }
        L_0x0322:
            com.alibaba.a.d.b r0 = r7.f6207e     // Catch:{ all -> 0x0392 }
            java.lang.reflect.Method r0 = r0.f6347c     // Catch:{ all -> 0x0392 }
            if (r0 == 0) goto L_0x034f
            com.alibaba.a.d.b r0 = r7.f6207e     // Catch:{ Exception -> 0x0332 }
            java.lang.reflect.Method r0 = r0.f6347c     // Catch:{ Exception -> 0x0332 }
            r3 = 0
            java.lang.Object r1 = r0.invoke(r3, r4)     // Catch:{ Exception -> 0x0332 }
            goto L_0x034f
        L_0x0332:
            r0 = move-exception
            com.alibaba.a.d r3 = new com.alibaba.a.d     // Catch:{ all -> 0x0392 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0392 }
            java.lang.String r5 = "create factory method error, "
            r4.<init>(r5)     // Catch:{ all -> 0x0392 }
            com.alibaba.a.d.b r5 = r7.f6207e     // Catch:{ all -> 0x0392 }
            java.lang.reflect.Method r5 = r5.f6347c     // Catch:{ all -> 0x0392 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0392 }
            r4.append(r5)     // Catch:{ all -> 0x0392 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0392 }
            r3.<init>(r4, r0)     // Catch:{ all -> 0x0392 }
            throw r3     // Catch:{ all -> 0x0392 }
        L_0x034f:
            if (r2 == 0) goto L_0x0353
            r2.f6239a = r1
        L_0x0353:
            r8.a((com.alibaba.a.b.h) r13)
            return r1
        L_0x0357:
            int r1 = r11.a()     // Catch:{ all -> 0x038d }
            r2 = 18
            if (r1 == r2) goto L_0x0367
            int r1 = r11.a()     // Catch:{ all -> 0x038d }
            r2 = 1
            if (r1 == r2) goto L_0x0367
            goto L_0x0385
        L_0x0367:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x038d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x038d }
            java.lang.String r2 = "syntax error, unexpect token "
            r1.<init>(r2)     // Catch:{ all -> 0x038d }
            int r2 = r11.a()     // Catch:{ all -> 0x038d }
            java.lang.String r2 = com.alibaba.a.b.g.a(r2)     // Catch:{ all -> 0x038d }
            r1.append(r2)     // Catch:{ all -> 0x038d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x038d }
            r0.<init>(r1)     // Catch:{ all -> 0x038d }
            throw r0     // Catch:{ all -> 0x038d }
        L_0x0384:
            r2 = 1
        L_0x0385:
            r1 = r10
            r10 = r17
            r2 = r18
            r5 = 1
            goto L_0x0253
        L_0x038d:
            r0 = move-exception
            r1 = r10
            r2 = r18
            goto L_0x0398
        L_0x0392:
            r0 = move-exception
            goto L_0x0398
        L_0x0394:
            r0 = move-exception
            r1 = r23
            r2 = 0
        L_0x0398:
            if (r2 == 0) goto L_0x039c
            r2.f6239a = r1
        L_0x039c:
            r8.a((com.alibaba.a.b.h) r13)
            throw r0
        L_0x03a0:
            r1 = r10
            java.lang.Object r0 = r8.a((java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.a.s.a(com.alibaba.a.b.b, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    private boolean a(com.alibaba.a.b.b bVar, String str, Object obj, Type type, Map<String, Object> map) {
        com.alibaba.a.b.d g2 = bVar.g();
        o oVar = this.f6203a.get(str);
        if (oVar == null) {
            Iterator<Map.Entry<String, o>> it2 = this.f6203a.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((String) next.getKey()).equalsIgnoreCase(str)) {
                    oVar = (o) next.getValue();
                    break;
                }
            }
        }
        if (oVar == null) {
            com.alibaba.a.b.d g3 = bVar.g();
            if (g3.a(com.alibaba.a.b.c.IgnoreNotMatch)) {
                g3.o();
                Type a2 = x.a(bVar);
                if (a2 == null) {
                    bVar.a((Object) null);
                } else {
                    bVar.a(a2);
                }
                x.b(bVar);
                return false;
            }
            throw new d("setter not found, class " + this.f6206d.getName() + ", property " + str);
        }
        g2.p();
        oVar.a(bVar, obj, type, map);
        return true;
    }
}
