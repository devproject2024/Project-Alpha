package com.alibaba.a.b;

import com.alibaba.a.b.a.h;
import com.alibaba.a.b.a.m;
import com.alibaba.a.b.a.n;
import com.alibaba.a.b.a.o;
import com.alibaba.a.b.a.u;
import com.alibaba.a.b.a.x;
import com.alibaba.a.b.a.z;
import com.alibaba.a.c.ad;
import com.alibaba.a.c.bd;
import com.alibaba.a.d;
import com.alibaba.a.d.g;
import com.alibaba.a.e;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class b extends a implements Closeable {

    /* renamed from: i  reason: collision with root package name */
    private static final Set<Class<?>> f6217i;

    /* renamed from: a  reason: collision with root package name */
    protected final Object f6218a;

    /* renamed from: b  reason: collision with root package name */
    protected final j f6219b;

    /* renamed from: c  reason: collision with root package name */
    protected i f6220c;

    /* renamed from: d  reason: collision with root package name */
    protected final d f6221d;

    /* renamed from: e  reason: collision with root package name */
    protected h f6222e;

    /* renamed from: f  reason: collision with root package name */
    public int f6223f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f6224g;

    /* renamed from: h  reason: collision with root package name */
    public List<m> f6225h;
    private String j;
    private DateFormat k;
    private h[] l;
    private int m;
    private List<a> n;

    static {
        HashSet hashSet = new HashSet();
        f6217i = hashSet;
        hashSet.add(Boolean.TYPE);
        f6217i.add(Byte.TYPE);
        f6217i.add(Short.TYPE);
        f6217i.add(Integer.TYPE);
        f6217i.add(Long.TYPE);
        f6217i.add(Float.TYPE);
        f6217i.add(Double.TYPE);
        f6217i.add(Boolean.class);
        f6217i.add(Byte.class);
        f6217i.add(Short.class);
        f6217i.add(Integer.class);
        f6217i.add(Long.class);
        f6217i.add(Float.class);
        f6217i.add(Double.class);
        f6217i.add(BigInteger.class);
        f6217i.add(BigDecimal.class);
        f6217i.add(String.class);
    }

    public final DateFormat a() {
        if (this.k == null) {
            this.k = new SimpleDateFormat(this.j);
        }
        return this.k;
    }

    public b(String str, i iVar) {
        this((Object) str, (d) new f(str, com.alibaba.a.a.DEFAULT_PARSER_FEATURE), iVar);
    }

    public b(String str, i iVar, int i2) {
        this((Object) str, (d) new f(str, i2), iVar);
    }

    public b(char[] cArr, int i2, i iVar, int i3) {
        this((Object) cArr, (d) new f(cArr, i2, i3), iVar);
    }

    private b(Object obj, d dVar, i iVar) {
        this.j = com.alibaba.a.a.DEFFAULT_DATE_FORMAT;
        this.l = new h[8];
        this.m = 0;
        this.f6223f = 0;
        this.f6224g = null;
        this.f6225h = null;
        this.f6221d = dVar;
        this.f6218a = obj;
        this.f6220c = iVar;
        this.f6219b = iVar.b();
        dVar.a(12);
    }

    public final j b() {
        return this.f6219b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01f3, code lost:
        if (r1.f6222e == null) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01f7, code lost:
        if ((r2 instanceof java.lang.Integer) != false) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01f9, code lost:
        f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01fc, code lost:
        r0 = r1.f6220c.a((java.lang.reflect.Type) r6).a(r1, r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0206, code lost:
        a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0209, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        r3.a(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0217, code lost:
        if (r3.a() != 4) goto L_0x02a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0219, code lost:
        r0 = r3.l();
        r3.a(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0226, code lost:
        if ("@".equals(r0) == false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x022a, code lost:
        if (r1.f6222e == null) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x022c, code lost:
        r0 = r1.f6222e;
        r2 = r0.f6239a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0232, code lost:
        if ((r2 instanceof java.lang.Object[]) != false) goto L_0x0242;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0236, code lost:
        if ((r2 instanceof java.util.Collection) == false) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x023b, code lost:
        if (r0.f6240b == null) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x023d, code lost:
        r0 = r0.f6240b.f6239a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0242, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x024a, code lost:
        if ("..".equals(r0) == false) goto L_0x0260;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x024c, code lost:
        r2 = r4.f6240b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0250, code lost:
        if (r2.f6239a == null) goto L_0x0255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0252, code lost:
        r0 = r2.f6239a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0255, code lost:
        a(new com.alibaba.a.b.b.a(r2, r0));
        r1.f6223f = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0266, code lost:
        if ("$".equals(r0) == false) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0268, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x026b, code lost:
        if (r2.f6240b == null) goto L_0x0270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x026d, code lost:
        r2 = r2.f6240b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0272, code lost:
        if (r2.f6239a == null) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0274, code lost:
        r0 = r2.f6239a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0277, code lost:
        a(new com.alibaba.a.b.b.a(r2, r0));
        r1.f6223f = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0282, code lost:
        a(new com.alibaba.a.b.b.a(r4, r0));
        r1.f6223f = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x028c, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0291, code lost:
        if (r3.a() != 13) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0293, code lost:
        r3.a(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0298, code lost:
        a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x029b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02a1, code lost:
        throw new com.alibaba.a.d("syntax error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02bd, code lost:
        throw new com.alibaba.a.d("illegal ref, " + com.alibaba.a.b.g.a(r3.a()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0337, code lost:
        if (r5 != '}') goto L_0x0349;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0339, code lost:
        r3.f();
        r3.g();
        r3.d();
        a((java.lang.Object) r19, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0345, code lost:
        a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0348, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0367, code lost:
        throw new com.alibaba.a.d("syntax error, position at " + r3.i() + ", name " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ae, code lost:
        r3.a(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b7, code lost:
        if (r3.a() != 13) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b9, code lost:
        r3.a(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        r0 = r1.f6220c.a((java.lang.reflect.Type) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c4, code lost:
        if ((r0 instanceof com.alibaba.a.b.a.s) == false) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c6, code lost:
        r16 = ((com.alibaba.a.b.a.s) r0).a(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01cf, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01d1, code lost:
        if (r16 != null) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01d5, code lost:
        if (r6 != java.lang.Cloneable.class) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d7, code lost:
        r16 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01dd, code lost:
        r16 = r6.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01e1, code lost:
        a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01e4, code lost:
        return r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01ee, code lost:
        r1.f6223f = 2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0183 A[Catch:{ Exception -> 0x01e5, all -> 0x0470 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0196 A[Catch:{ Exception -> 0x01e5, all -> 0x0470 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.Map r19, java.lang.Object r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            com.alibaba.a.b.d r3 = r1.f6221d
            int r4 = r3.a()
            r5 = 0
            r6 = 8
            if (r4 != r6) goto L_0x0015
            r3.f()
            return r5
        L_0x0015:
            int r4 = r3.a()
            r6 = 12
            r7 = 16
            if (r4 == r6) goto L_0x003f
            int r4 = r3.a()
            if (r4 != r7) goto L_0x0026
            goto L_0x003f
        L_0x0026:
            com.alibaba.a.d r0 = new com.alibaba.a.d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "syntax error, expect {, actual "
            r2.<init>(r4)
            java.lang.String r3 = r3.b()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x003f:
            com.alibaba.a.b.h r4 = r1.f6222e
            r8 = 0
        L_0x0042:
            r3.c()     // Catch:{ all -> 0x0470 }
            char r9 = r3.e()     // Catch:{ all -> 0x0470 }
            com.alibaba.a.b.c r10 = com.alibaba.a.b.c.AllowArbitraryCommas     // Catch:{ all -> 0x0470 }
            boolean r10 = r1.a((com.alibaba.a.b.c) r10)     // Catch:{ all -> 0x0470 }
            r11 = 44
            if (r10 == 0) goto L_0x0060
        L_0x0053:
            if (r9 != r11) goto L_0x0060
            r3.f()     // Catch:{ all -> 0x0470 }
            r3.c()     // Catch:{ all -> 0x0470 }
            char r9 = r3.e()     // Catch:{ all -> 0x0470 }
            goto L_0x0053
        L_0x0060:
            r10 = 48
            r12 = 125(0x7d, float:1.75E-43)
            java.lang.String r14 = ", name "
            java.lang.String r15 = "expect ':' at "
            r6 = 58
            r7 = 34
            java.lang.String r5 = "syntax error"
            r13 = 1
            if (r9 != r7) goto L_0x00a0
            com.alibaba.a.b.j r9 = r1.f6219b     // Catch:{ all -> 0x0470 }
            java.lang.String r9 = r3.a(r9, r7)     // Catch:{ all -> 0x0470 }
            r3.c()     // Catch:{ all -> 0x0470 }
            char r7 = r3.e()     // Catch:{ all -> 0x0470 }
            if (r7 != r6) goto L_0x0084
        L_0x0081:
            r6 = 0
            goto L_0x0181
        L_0x0084:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0470 }
            r2.<init>(r15)     // Catch:{ all -> 0x0470 }
            int r3 = r3.i()     // Catch:{ all -> 0x0470 }
            r2.append(r3)     // Catch:{ all -> 0x0470 }
            r2.append(r14)     // Catch:{ all -> 0x0470 }
            r2.append(r9)     // Catch:{ all -> 0x0470 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0470 }
            r0.<init>(r2)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x00a0:
            if (r9 != r12) goto L_0x00af
            r3.f()     // Catch:{ all -> 0x0470 }
            r3.g()     // Catch:{ all -> 0x0470 }
            r3.d()     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.h) r4)
            return r0
        L_0x00af:
            r7 = 39
            if (r9 != r7) goto L_0x00e7
            com.alibaba.a.b.c r9 = com.alibaba.a.b.c.AllowSingleQuotes     // Catch:{ all -> 0x0470 }
            boolean r9 = r1.a((com.alibaba.a.b.c) r9)     // Catch:{ all -> 0x0470 }
            if (r9 == 0) goto L_0x00e1
            com.alibaba.a.b.j r9 = r1.f6219b     // Catch:{ all -> 0x0470 }
            java.lang.String r9 = r3.a(r9, r7)     // Catch:{ all -> 0x0470 }
            r3.c()     // Catch:{ all -> 0x0470 }
            char r7 = r3.e()     // Catch:{ all -> 0x0470 }
            if (r7 != r6) goto L_0x00cb
            goto L_0x0081
        L_0x00cb:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0470 }
            r2.<init>(r15)     // Catch:{ all -> 0x0470 }
            int r3 = r3.i()     // Catch:{ all -> 0x0470 }
            r2.append(r3)     // Catch:{ all -> 0x0470 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0470 }
            r0.<init>(r2)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x00e1:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            r0.<init>(r5)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x00e7:
            r7 = 26
            if (r9 == r7) goto L_0x046a
            if (r9 == r11) goto L_0x0464
            if (r9 < r10) goto L_0x00f3
            r7 = 57
            if (r9 <= r7) goto L_0x00f7
        L_0x00f3:
            r7 = 45
            if (r9 != r7) goto L_0x0132
        L_0x00f7:
            r3.g()     // Catch:{ all -> 0x0470 }
            r3.h()     // Catch:{ all -> 0x0470 }
            int r7 = r3.a()     // Catch:{ all -> 0x0470 }
            r9 = 2
            if (r7 != r9) goto L_0x0109
            java.lang.Number r7 = r3.j()     // Catch:{ all -> 0x0470 }
            goto L_0x010d
        L_0x0109:
            java.lang.Number r7 = r3.a((boolean) r13)     // Catch:{ all -> 0x0470 }
        L_0x010d:
            r9 = r7
            char r7 = r3.e()     // Catch:{ all -> 0x0470 }
            if (r7 != r6) goto L_0x0116
            goto L_0x0081
        L_0x0116:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0470 }
            r2.<init>(r15)     // Catch:{ all -> 0x0470 }
            int r3 = r3.i()     // Catch:{ all -> 0x0470 }
            r2.append(r3)     // Catch:{ all -> 0x0470 }
            r2.append(r14)     // Catch:{ all -> 0x0470 }
            r2.append(r9)     // Catch:{ all -> 0x0470 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0470 }
            r0.<init>(r2)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x0132:
            r7 = 123(0x7b, float:1.72E-43)
            if (r9 == r7) goto L_0x0178
            r7 = 91
            if (r9 != r7) goto L_0x013b
            goto L_0x0178
        L_0x013b:
            com.alibaba.a.b.c r7 = com.alibaba.a.b.c.AllowUnQuotedFieldNames     // Catch:{ all -> 0x0470 }
            boolean r7 = r1.a((com.alibaba.a.b.c) r7)     // Catch:{ all -> 0x0470 }
            if (r7 == 0) goto L_0x0172
            com.alibaba.a.b.j r7 = r1.f6219b     // Catch:{ all -> 0x0470 }
            java.lang.String r9 = r3.b((com.alibaba.a.b.j) r7)     // Catch:{ all -> 0x0470 }
            r3.c()     // Catch:{ all -> 0x0470 }
            char r7 = r3.e()     // Catch:{ all -> 0x0470 }
            if (r7 != r6) goto L_0x0154
            goto L_0x0081
        L_0x0154:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0470 }
            r2.<init>(r15)     // Catch:{ all -> 0x0470 }
            int r3 = r3.i()     // Catch:{ all -> 0x0470 }
            r2.append(r3)     // Catch:{ all -> 0x0470 }
            java.lang.String r3 = ", actual "
            r2.append(r3)     // Catch:{ all -> 0x0470 }
            r2.append(r7)     // Catch:{ all -> 0x0470 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0470 }
            r0.<init>(r2)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x0172:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            r0.<init>(r5)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x0178:
            r3.d()     // Catch:{ all -> 0x0470 }
            r6 = 0
            java.lang.Object r9 = r1.a((java.lang.Object) r6)     // Catch:{ all -> 0x0470 }
            r6 = 1
        L_0x0181:
            if (r6 != 0) goto L_0x0189
            r3.f()     // Catch:{ all -> 0x0470 }
            r3.c()     // Catch:{ all -> 0x0470 }
        L_0x0189:
            char r6 = r3.e()     // Catch:{ all -> 0x0470 }
            r3.g()     // Catch:{ all -> 0x0470 }
            java.lang.String r7 = com.alibaba.a.a.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0470 }
            r15 = 13
            if (r9 != r7) goto L_0x020a
            com.alibaba.a.b.j r5 = r1.f6219b     // Catch:{ all -> 0x0470 }
            r6 = 34
            java.lang.String r5 = r3.a(r5, r6)     // Catch:{ all -> 0x0470 }
            java.lang.Class r6 = com.alibaba.a.d.g.a((java.lang.String) r5)     // Catch:{ all -> 0x0470 }
            if (r6 != 0) goto L_0x01ae
            java.lang.String r6 = com.alibaba.a.a.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0470 }
            r0.put(r6, r5)     // Catch:{ all -> 0x0470 }
        L_0x01a9:
            r5 = 0
            r7 = 16
            goto L_0x0042
        L_0x01ae:
            r0 = 16
            r3.a((int) r0)     // Catch:{ all -> 0x0470 }
            int r5 = r3.a()     // Catch:{ all -> 0x0470 }
            if (r5 != r15) goto L_0x01ee
            r3.a((int) r0)     // Catch:{ all -> 0x0470 }
            com.alibaba.a.b.i r0 = r1.f6220c     // Catch:{ Exception -> 0x01e5 }
            com.alibaba.a.b.a.z r0 = r0.a((java.lang.reflect.Type) r6)     // Catch:{ Exception -> 0x01e5 }
            boolean r2 = r0 instanceof com.alibaba.a.b.a.s     // Catch:{ Exception -> 0x01e5 }
            if (r2 == 0) goto L_0x01cf
            com.alibaba.a.b.a.s r0 = (com.alibaba.a.b.a.s) r0     // Catch:{ Exception -> 0x01e5 }
            java.lang.Object r5 = r0.a(r1, r6)     // Catch:{ Exception -> 0x01e5 }
            r16 = r5
            goto L_0x01d1
        L_0x01cf:
            r16 = 0
        L_0x01d1:
            if (r16 != 0) goto L_0x01e1
            java.lang.Class<java.lang.Cloneable> r0 = java.lang.Cloneable.class
            if (r6 != r0) goto L_0x01dd
            java.util.HashMap r16 = new java.util.HashMap     // Catch:{ Exception -> 0x01e5 }
            r16.<init>()     // Catch:{ Exception -> 0x01e5 }
            goto L_0x01e1
        L_0x01dd:
            java.lang.Object r16 = r6.newInstance()     // Catch:{ Exception -> 0x01e5 }
        L_0x01e1:
            r1.a((com.alibaba.a.b.h) r4)
            return r16
        L_0x01e5:
            r0 = move-exception
            com.alibaba.a.d r2 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            java.lang.String r3 = "create instance error"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0470 }
            throw r2     // Catch:{ all -> 0x0470 }
        L_0x01ee:
            r0 = 2
            r1.f6223f = r0     // Catch:{ all -> 0x0470 }
            com.alibaba.a.b.h r0 = r1.f6222e     // Catch:{ all -> 0x0470 }
            if (r0 == 0) goto L_0x01fc
            boolean r0 = r2 instanceof java.lang.Integer     // Catch:{ all -> 0x0470 }
            if (r0 != 0) goto L_0x01fc
            r18.f()     // Catch:{ all -> 0x0470 }
        L_0x01fc:
            com.alibaba.a.b.i r0 = r1.f6220c     // Catch:{ all -> 0x0470 }
            com.alibaba.a.b.a.z r0 = r0.a((java.lang.reflect.Type) r6)     // Catch:{ all -> 0x0470 }
            java.lang.Object r0 = r0.a(r1, r6, r2)     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.h) r4)
            return r0
        L_0x020a:
            java.lang.String r7 = "$ref"
            if (r9 != r7) goto L_0x02be
            r0 = 4
            r3.a((int) r0)     // Catch:{ all -> 0x0470 }
            int r0 = r3.a()     // Catch:{ all -> 0x0470 }
            r2 = 4
            if (r0 != r2) goto L_0x02a2
            java.lang.String r0 = r3.l()     // Catch:{ all -> 0x0470 }
            r3.a((int) r15)     // Catch:{ all -> 0x0470 }
            java.lang.String r2 = "@"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0470 }
            if (r2 == 0) goto L_0x0244
            com.alibaba.a.b.h r0 = r1.f6222e     // Catch:{ all -> 0x0470 }
            if (r0 == 0) goto L_0x028c
            com.alibaba.a.b.h r0 = r1.f6222e     // Catch:{ all -> 0x0470 }
            java.lang.Object r2 = r0.f6239a     // Catch:{ all -> 0x0470 }
            boolean r6 = r2 instanceof java.lang.Object[]     // Catch:{ all -> 0x0470 }
            if (r6 != 0) goto L_0x0242
            boolean r6 = r2 instanceof java.util.Collection     // Catch:{ all -> 0x0470 }
            if (r6 == 0) goto L_0x0239
            goto L_0x0242
        L_0x0239:
            com.alibaba.a.b.h r2 = r0.f6240b     // Catch:{ all -> 0x0470 }
            if (r2 == 0) goto L_0x028c
            com.alibaba.a.b.h r0 = r0.f6240b     // Catch:{ all -> 0x0470 }
            java.lang.Object r0 = r0.f6239a     // Catch:{ all -> 0x0470 }
            goto L_0x028d
        L_0x0242:
            r0 = r2
            goto L_0x028d
        L_0x0244:
            java.lang.String r2 = ".."
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0470 }
            if (r2 == 0) goto L_0x0260
            com.alibaba.a.b.h r2 = r4.f6240b     // Catch:{ all -> 0x0470 }
            java.lang.Object r6 = r2.f6239a     // Catch:{ all -> 0x0470 }
            if (r6 == 0) goto L_0x0255
            java.lang.Object r0 = r2.f6239a     // Catch:{ all -> 0x0470 }
            goto L_0x028d
        L_0x0255:
            com.alibaba.a.b.b$a r6 = new com.alibaba.a.b.b$a     // Catch:{ all -> 0x0470 }
            r6.<init>(r2, r0)     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.b.a) r6)     // Catch:{ all -> 0x0470 }
            r1.f6223f = r13     // Catch:{ all -> 0x0470 }
            goto L_0x028c
        L_0x0260:
            java.lang.String r2 = "$"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0470 }
            if (r2 == 0) goto L_0x0282
            r2 = r4
        L_0x0269:
            com.alibaba.a.b.h r6 = r2.f6240b     // Catch:{ all -> 0x0470 }
            if (r6 == 0) goto L_0x0270
            com.alibaba.a.b.h r2 = r2.f6240b     // Catch:{ all -> 0x0470 }
            goto L_0x0269
        L_0x0270:
            java.lang.Object r6 = r2.f6239a     // Catch:{ all -> 0x0470 }
            if (r6 == 0) goto L_0x0277
            java.lang.Object r0 = r2.f6239a     // Catch:{ all -> 0x0470 }
            goto L_0x028d
        L_0x0277:
            com.alibaba.a.b.b$a r6 = new com.alibaba.a.b.b$a     // Catch:{ all -> 0x0470 }
            r6.<init>(r2, r0)     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.b.a) r6)     // Catch:{ all -> 0x0470 }
            r1.f6223f = r13     // Catch:{ all -> 0x0470 }
            goto L_0x028c
        L_0x0282:
            com.alibaba.a.b.b$a r2 = new com.alibaba.a.b.b$a     // Catch:{ all -> 0x0470 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.b.a) r2)     // Catch:{ all -> 0x0470 }
            r1.f6223f = r13     // Catch:{ all -> 0x0470 }
        L_0x028c:
            r0 = 0
        L_0x028d:
            int r2 = r3.a()     // Catch:{ all -> 0x0470 }
            if (r2 != r15) goto L_0x029c
            r2 = 16
            r3.a((int) r2)     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.h) r4)
            return r0
        L_0x029c:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            r0.<init>(r5)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x02a2:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0470 }
            java.lang.String r5 = "illegal ref, "
            r2.<init>(r5)     // Catch:{ all -> 0x0470 }
            int r3 = r3.a()     // Catch:{ all -> 0x0470 }
            java.lang.String r3 = com.alibaba.a.b.g.a(r3)     // Catch:{ all -> 0x0470 }
            r2.append(r3)     // Catch:{ all -> 0x0470 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0470 }
            r0.<init>(r2)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x02be:
            if (r8 != 0) goto L_0x02c4
            r18.a((java.lang.Object) r19, (java.lang.Object) r20)     // Catch:{ all -> 0x0470 }
            r8 = 1
        L_0x02c4:
            java.lang.Class r7 = r19.getClass()     // Catch:{ all -> 0x0470 }
            java.lang.Class<com.alibaba.a.e> r13 = com.alibaba.a.e.class
            if (r7 != r13) goto L_0x02d6
            if (r9 != 0) goto L_0x02d1
            java.lang.String r7 = "null"
            goto L_0x02d5
        L_0x02d1:
            java.lang.String r7 = r9.toString()     // Catch:{ all -> 0x0470 }
        L_0x02d5:
            r9 = r7
        L_0x02d6:
            r7 = 34
            if (r6 != r7) goto L_0x0303
            r3.m()     // Catch:{ all -> 0x0470 }
            java.lang.String r5 = r3.l()     // Catch:{ all -> 0x0470 }
            com.alibaba.a.b.c r6 = com.alibaba.a.b.c.AllowISO8601DateFormat     // Catch:{ all -> 0x0470 }
            boolean r6 = r3.a((com.alibaba.a.b.c) r6)     // Catch:{ all -> 0x0470 }
            if (r6 == 0) goto L_0x02ff
            com.alibaba.a.b.f r6 = new com.alibaba.a.b.f     // Catch:{ all -> 0x0470 }
            r6.<init>(r5)     // Catch:{ all -> 0x0470 }
            boolean r7 = r6.z()     // Catch:{ all -> 0x0470 }
            if (r7 == 0) goto L_0x02fc
            java.util.Calendar r5 = r6.y()     // Catch:{ all -> 0x0470 }
            java.util.Date r5 = r5.getTime()     // Catch:{ all -> 0x0470 }
        L_0x02fc:
            r6.close()     // Catch:{ all -> 0x0470 }
        L_0x02ff:
            r0.put(r9, r5)     // Catch:{ all -> 0x0470 }
            goto L_0x0329
        L_0x0303:
            if (r6 < r10) goto L_0x0309
            r7 = 57
            if (r6 <= r7) goto L_0x030d
        L_0x0309:
            r7 = 45
            if (r6 != r7) goto L_0x0368
        L_0x030d:
            r3.h()     // Catch:{ all -> 0x0470 }
            int r5 = r3.a()     // Catch:{ all -> 0x0470 }
            r6 = 2
            if (r5 != r6) goto L_0x031c
            java.lang.Number r5 = r3.j()     // Catch:{ all -> 0x0470 }
            goto L_0x0326
        L_0x031c:
            com.alibaba.a.b.c r5 = com.alibaba.a.b.c.UseBigDecimal     // Catch:{ all -> 0x0470 }
            boolean r5 = r1.a((com.alibaba.a.b.c) r5)     // Catch:{ all -> 0x0470 }
            java.lang.Number r5 = r3.a((boolean) r5)     // Catch:{ all -> 0x0470 }
        L_0x0326:
            r0.put(r9, r5)     // Catch:{ all -> 0x0470 }
        L_0x0329:
            r3.c()     // Catch:{ all -> 0x0470 }
            char r5 = r3.e()     // Catch:{ all -> 0x0470 }
            if (r5 != r11) goto L_0x0337
            r3.f()     // Catch:{ all -> 0x0470 }
            goto L_0x01a9
        L_0x0337:
            if (r5 != r12) goto L_0x0349
            r3.f()     // Catch:{ all -> 0x0470 }
            r3.g()     // Catch:{ all -> 0x0470 }
            r3.d()     // Catch:{ all -> 0x0470 }
            r18.a((java.lang.Object) r19, (java.lang.Object) r20)     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.h) r4)
            return r0
        L_0x0349:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0470 }
            java.lang.String r5 = "syntax error, position at "
            r2.<init>(r5)     // Catch:{ all -> 0x0470 }
            int r3 = r3.i()     // Catch:{ all -> 0x0470 }
            r2.append(r3)     // Catch:{ all -> 0x0470 }
            r2.append(r14)     // Catch:{ all -> 0x0470 }
            r2.append(r9)     // Catch:{ all -> 0x0470 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0470 }
            r0.<init>(r2)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x0368:
            r7 = 91
            if (r6 != r7) goto L_0x0398
            r3.d()     // Catch:{ all -> 0x0470 }
            com.alibaba.a.b r6 = new com.alibaba.a.b     // Catch:{ all -> 0x0470 }
            r6.<init>()     // Catch:{ all -> 0x0470 }
            r1.a((java.util.Collection) r6, (java.lang.Object) r9)     // Catch:{ all -> 0x0470 }
            r0.put(r9, r6)     // Catch:{ all -> 0x0470 }
            int r6 = r3.a()     // Catch:{ all -> 0x0470 }
            if (r6 != r15) goto L_0x0387
            r3.d()     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.h) r4)
            return r0
        L_0x0387:
            int r6 = r3.a()     // Catch:{ all -> 0x0470 }
            r7 = 16
            if (r6 != r7) goto L_0x0392
            r5 = 0
            goto L_0x0042
        L_0x0392:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            r0.<init>(r5)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x0398:
            r5 = 123(0x7b, float:1.72E-43)
            if (r6 != r5) goto L_0x0417
            r3.d()     // Catch:{ all -> 0x0470 }
            if (r2 == 0) goto L_0x03ac
            java.lang.Class r5 = r20.getClass()     // Catch:{ all -> 0x0470 }
            java.lang.Class<java.lang.Integer> r6 = java.lang.Integer.class
            if (r5 != r6) goto L_0x03ac
            r17 = 1
            goto L_0x03ae
        L_0x03ac:
            r17 = 0
        L_0x03ae:
            com.alibaba.a.e r5 = new com.alibaba.a.e     // Catch:{ all -> 0x0470 }
            r5.<init>()     // Catch:{ all -> 0x0470 }
            if (r17 != 0) goto L_0x03ba
            com.alibaba.a.b.h r6 = r1.a((com.alibaba.a.b.h) r4, (java.lang.Object) r5, (java.lang.Object) r9)     // Catch:{ all -> 0x0470 }
            goto L_0x03bb
        L_0x03ba:
            r6 = 0
        L_0x03bb:
            java.lang.Object r7 = r1.a((java.util.Map) r5, (java.lang.Object) r9)     // Catch:{ all -> 0x0470 }
            if (r6 == 0) goto L_0x03c5
            if (r5 == r7) goto L_0x03c5
            r6.f6239a = r0     // Catch:{ all -> 0x0470 }
        L_0x03c5:
            java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x0470 }
            r1.a((java.util.Map) r0, (java.lang.String) r5)     // Catch:{ all -> 0x0470 }
            java.lang.Class r5 = r19.getClass()     // Catch:{ all -> 0x0470 }
            java.lang.Class<com.alibaba.a.e> r6 = com.alibaba.a.e.class
            if (r5 != r6) goto L_0x03dc
            java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x0470 }
            r0.put(r5, r7)     // Catch:{ all -> 0x0470 }
            goto L_0x03df
        L_0x03dc:
            r0.put(r9, r7)     // Catch:{ all -> 0x0470 }
        L_0x03df:
            if (r17 == 0) goto L_0x03e4
            r1.a((com.alibaba.a.b.h) r4, (java.lang.Object) r7, (java.lang.Object) r9)     // Catch:{ all -> 0x0470 }
        L_0x03e4:
            int r5 = r3.a()     // Catch:{ all -> 0x0470 }
            if (r5 != r15) goto L_0x03f4
            r3.d()     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.h) r4)     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.h) r4)
            return r0
        L_0x03f4:
            int r5 = r3.a()     // Catch:{ all -> 0x0470 }
            r6 = 16
            if (r5 != r6) goto L_0x03fe
            goto L_0x01a9
        L_0x03fe:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0470 }
            java.lang.String r5 = "syntax error, "
            r2.<init>(r5)     // Catch:{ all -> 0x0470 }
            java.lang.String r3 = r3.b()     // Catch:{ all -> 0x0470 }
            r2.append(r3)     // Catch:{ all -> 0x0470 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0470 }
            r0.<init>(r2)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x0417:
            r3.d()     // Catch:{ all -> 0x0470 }
            r5 = 0
            java.lang.Object r6 = r1.a((java.lang.Object) r5)     // Catch:{ all -> 0x0470 }
            java.lang.Class r7 = r19.getClass()     // Catch:{ all -> 0x0470 }
            java.lang.Class<com.alibaba.a.e> r10 = com.alibaba.a.e.class
            if (r7 != r10) goto L_0x042b
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0470 }
        L_0x042b:
            r0.put(r9, r6)     // Catch:{ all -> 0x0470 }
            int r6 = r3.a()     // Catch:{ all -> 0x0470 }
            if (r6 != r15) goto L_0x043b
            r3.d()     // Catch:{ all -> 0x0470 }
            r1.a((com.alibaba.a.b.h) r4)
            return r0
        L_0x043b:
            int r6 = r3.a()     // Catch:{ all -> 0x0470 }
            r7 = 16
            if (r6 != r7) goto L_0x0445
            goto L_0x0042
        L_0x0445:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0470 }
            java.lang.String r5 = "syntax error, position at "
            r2.<init>(r5)     // Catch:{ all -> 0x0470 }
            int r3 = r3.i()     // Catch:{ all -> 0x0470 }
            r2.append(r3)     // Catch:{ all -> 0x0470 }
            r2.append(r14)     // Catch:{ all -> 0x0470 }
            r2.append(r9)     // Catch:{ all -> 0x0470 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0470 }
            r0.<init>(r2)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x0464:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            r0.<init>(r5)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x046a:
            com.alibaba.a.d r0 = new com.alibaba.a.d     // Catch:{ all -> 0x0470 }
            r0.<init>(r5)     // Catch:{ all -> 0x0470 }
            throw r0     // Catch:{ all -> 0x0470 }
        L_0x0470:
            r0 = move-exception
            r1.a((com.alibaba.a.b.h) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.b.a(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public final i c() {
        return this.f6220c;
    }

    public final <T> T a(Type type) {
        if (this.f6221d.a() == 8) {
            this.f6221d.d();
            return null;
        }
        if (this.f6221d.a() == 4) {
            type = g.c(type);
            if (type == byte[].class) {
                Object v = this.f6221d.v();
                this.f6221d.d();
                return v;
            } else if (type == char[].class) {
                String l2 = this.f6221d.l();
                this.f6221d.d();
                return l2.toCharArray();
            }
        }
        try {
            return this.f6220c.a(type).a(this, type, (Object) null);
        } catch (d e2) {
            throw e2;
        } catch (Throwable th) {
            throw new d(th.getMessage(), th);
        }
    }

    public final void a(Type type, Collection collection) {
        a(type, collection, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    public final void a(Type type, Collection collection, Object obj) {
        z zVar;
        if (this.f6221d.a() == 21 || this.f6221d.a() == 22) {
            this.f6221d.d();
        }
        if (this.f6221d.a() == 14) {
            if (Integer.TYPE == type) {
                zVar = ad.f6263a;
                this.f6221d.a(2);
            } else if (String.class == type) {
                zVar = bd.f6309a;
                this.f6221d.a(4);
            } else {
                zVar = this.f6220c.a(type);
                this.f6221d.a(zVar.a());
            }
            h hVar = this.f6222e;
            a((Object) collection, obj);
            int i2 = 0;
            while (true) {
                try {
                    if (a(c.AllowArbitraryCommas)) {
                        while (this.f6221d.a() == 16) {
                            this.f6221d.d();
                        }
                    }
                    if (this.f6221d.a() != 15) {
                        Object obj2 = null;
                        if (Integer.TYPE == type) {
                            collection.add(ad.f6263a.a(this, (Type) null, (Object) null));
                        } else if (String.class == type) {
                            if (this.f6221d.a() == 4) {
                                obj2 = this.f6221d.l();
                                this.f6221d.a(16);
                            } else {
                                Object a2 = a((Object) null);
                                if (a2 != null) {
                                    obj2 = a2.toString();
                                }
                            }
                            collection.add(obj2);
                        } else {
                            if (this.f6221d.a() == 8) {
                                this.f6221d.d();
                            } else {
                                obj2 = zVar.a(this, type, Integer.valueOf(i2));
                            }
                            collection.add(obj2);
                            a(collection);
                        }
                        if (this.f6221d.a() == 16) {
                            this.f6221d.a(zVar.a());
                        }
                        i2++;
                    } else {
                        a(hVar);
                        this.f6221d.a(16);
                        return;
                    }
                } catch (Throwable th) {
                    a(hVar);
                    throw th;
                }
            }
        } else {
            throw new d("exepct '[', but " + g.a(this.f6221d.a()));
        }
    }

    public final Object[] a(Type[] typeArr) {
        Object obj;
        boolean z;
        Class<?> cls;
        Object obj2;
        Type[] typeArr2 = typeArr;
        int i2 = 8;
        if (this.f6221d.a() == 8) {
            this.f6221d.a(16);
            return null;
        }
        int i3 = 14;
        if (this.f6221d.a() == 14) {
            Object[] objArr = new Object[typeArr2.length];
            if (typeArr2.length == 0) {
                this.f6221d.a(15);
                if (this.f6221d.a() == 15) {
                    this.f6221d.a(16);
                    return new Object[0];
                }
                throw new d("syntax error");
            }
            this.f6221d.a(2);
            int i4 = 0;
            while (i4 < typeArr2.length) {
                if (this.f6221d.a() == i2) {
                    this.f6221d.a(16);
                    obj = null;
                } else {
                    Type type = typeArr2[i4];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (this.f6221d.a() == 2) {
                            obj = Integer.valueOf(this.f6221d.n());
                            this.f6221d.a(16);
                        } else {
                            obj = g.a(a((Object) null), type, this.f6220c);
                        }
                    } else if (type == String.class) {
                        if (this.f6221d.a() == 4) {
                            obj2 = this.f6221d.l();
                            this.f6221d.a(16);
                        } else {
                            obj2 = g.a(a((Object) null), type, this.f6220c);
                        }
                        obj = obj2;
                    } else {
                        if (i4 != typeArr2.length - 1 || !(type instanceof Class)) {
                            cls = null;
                            z = false;
                        } else {
                            Class cls2 = (Class) type;
                            z = cls2.isArray();
                            cls = cls2.getComponentType();
                        }
                        if (!z || this.f6221d.a() == i3) {
                            obj = this.f6220c.a(type).a(this, type, (Object) null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            z a2 = this.f6220c.a((Type) cls);
                            int a3 = a2.a();
                            if (this.f6221d.a() != 15) {
                                while (true) {
                                    arrayList.add(a2.a(this, type, (Object) null));
                                    if (this.f6221d.a() != 16) {
                                        break;
                                    }
                                    this.f6221d.a(a3);
                                }
                                if (this.f6221d.a() != 15) {
                                    throw new d("syntax error :" + g.a(this.f6221d.a()));
                                }
                            }
                            obj = g.a((Object) arrayList, type, this.f6220c);
                        }
                    }
                }
                objArr[i4] = obj;
                if (this.f6221d.a() == 15) {
                    break;
                } else if (this.f6221d.a() == 16) {
                    if (i4 == typeArr2.length - 1) {
                        this.f6221d.a(15);
                    } else {
                        this.f6221d.a(2);
                    }
                    i4++;
                    i2 = 8;
                    i3 = 14;
                } else {
                    throw new d("syntax error :" + g.a(this.f6221d.a()));
                }
            }
            if (this.f6221d.a() == 15) {
                this.f6221d.a(16);
                return objArr;
            }
            throw new d("syntax error");
        }
        throw new d("syntax error : " + this.f6221d.b());
    }

    private Object a(String str) {
        for (int i2 = 0; i2 < this.m; i2++) {
            if (str.equals(this.l[i2].a())) {
                return this.l[i2].f6239a;
            }
        }
        return null;
    }

    public final void a(Collection collection) {
        if (this.f6223f != 1) {
            return;
        }
        if (collection instanceof List) {
            a e2 = e();
            e2.f6228c = new u(this, (List) collection, collection.size() - 1);
            e2.f6229d = this.f6222e;
            this.f6223f = 0;
            return;
        }
        a e3 = e();
        e3.f6228c = new h(collection);
        e3.f6229d = this.f6222e;
        this.f6223f = 0;
    }

    public final void a(Map map, String str) {
        if (this.f6223f == 1) {
            x xVar = new x(map, str);
            a e2 = e();
            e2.f6228c = xVar;
            e2.f6229d = this.f6222e;
            this.f6223f = 0;
        }
    }

    public final void b(Collection collection) {
        a(collection, (Object) null);
    }

    public final h d() {
        return this.f6222e;
    }

    public final void a(a aVar) {
        if (this.n == null) {
            this.n = new ArrayList(2);
        }
        this.n.add(aVar);
    }

    public final a e() {
        List<a> list = this.n;
        return list.get(list.size() - 1);
    }

    public final void a(h hVar) {
        if (!a(c.DisableCircularReferenceDetect)) {
            this.f6222e = hVar;
        }
    }

    public final void f() {
        if (!a(c.DisableCircularReferenceDetect)) {
            this.f6222e = this.f6222e.f6240b;
            h[] hVarArr = this.l;
            int i2 = this.m;
            hVarArr[i2 - 1] = null;
            this.m = i2 - 1;
        }
    }

    private h a(Object obj, Object obj2) {
        if (a(c.DisableCircularReferenceDetect)) {
            return null;
        }
        return a(this.f6222e, obj, obj2);
    }

    public final h a(h hVar, Object obj, Object obj2) {
        if (a(c.DisableCircularReferenceDetect)) {
            return null;
        }
        this.f6222e = new h(hVar, obj, obj2);
        b(this.f6222e);
        return this.f6222e;
    }

    private void b(h hVar) {
        int i2 = this.m;
        this.m = i2 + 1;
        h[] hVarArr = this.l;
        if (i2 >= hVarArr.length) {
            h[] hVarArr2 = new h[((hVarArr.length * 3) / 2)];
            System.arraycopy(hVarArr, 0, hVarArr2, 0, hVarArr.length);
            this.l = hVarArr2;
        }
        this.l[i2] = hVar;
    }

    public final d g() {
        return this.f6221d;
    }

    public final void h() {
        Object obj;
        List<a> list = this.n;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.n.get(i2);
                o oVar = aVar.f6228c;
                if (oVar != null) {
                    Object obj2 = null;
                    if (aVar.f6229d != null) {
                        obj2 = aVar.f6229d.f6239a;
                    }
                    String str = aVar.f6227b;
                    if (str.startsWith("$")) {
                        obj = a(str);
                    } else {
                        obj = aVar.f6226a.f6239a;
                    }
                    oVar.a(obj2, obj);
                }
            }
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final h f6226a;

        /* renamed from: b  reason: collision with root package name */
        final String f6227b;

        /* renamed from: c  reason: collision with root package name */
        public o f6228c;

        /* renamed from: d  reason: collision with root package name */
        public h f6229d;

        public a(h hVar, String str) {
            this.f6226a = hVar;
            this.f6227b = str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: com.alibaba.a.b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.Collection r10, java.lang.Object r11) {
        /*
            r9 = this;
            com.alibaba.a.b.d r0 = r9.f6221d
            int r1 = r0.a()
            r2 = 21
            if (r1 == r2) goto L_0x0012
            int r1 = r0.a()
            r2 = 22
            if (r1 != r2) goto L_0x0015
        L_0x0012:
            r0.d()
        L_0x0015:
            int r1 = r0.a()
            r2 = 14
            if (r1 != r2) goto L_0x0109
            r1 = 4
            r0.a((int) r1)
            com.alibaba.a.b.h r3 = r9.f6222e
            r9.a((java.lang.Object) r10, (java.lang.Object) r11)
            r11 = 0
            r4 = 0
        L_0x0028:
            com.alibaba.a.b.c r5 = com.alibaba.a.b.c.AllowArbitraryCommas     // Catch:{ all -> 0x0104 }
            boolean r5 = r9.a((com.alibaba.a.b.c) r5)     // Catch:{ all -> 0x0104 }
            r6 = 16
            if (r5 == 0) goto L_0x003c
        L_0x0032:
            int r5 = r0.a()     // Catch:{ all -> 0x0104 }
            if (r5 != r6) goto L_0x003c
            r0.d()     // Catch:{ all -> 0x0104 }
            goto L_0x0032
        L_0x003c:
            int r5 = r0.a()     // Catch:{ all -> 0x0104 }
            r7 = 2
            r8 = 0
            if (r5 == r7) goto L_0x00ea
            r7 = 3
            if (r5 == r7) goto L_0x00d3
            if (r5 == r1) goto L_0x00ac
            r7 = 6
            if (r5 == r7) goto L_0x00a6
            r7 = 7
            if (r5 == r7) goto L_0x00a0
            r7 = 8
            if (r5 == r7) goto L_0x009c
            r7 = 12
            if (r5 == r7) goto L_0x008e
            r7 = 20
            if (r5 == r7) goto L_0x0085
            r7 = 23
            if (r5 == r7) goto L_0x0080
            if (r5 == r2) goto L_0x0072
            r7 = 15
            if (r5 == r7) goto L_0x006b
            java.lang.Object r8 = r9.a((java.lang.Object) r8)     // Catch:{ all -> 0x0104 }
            goto L_0x00f1
        L_0x006b:
            r0.a((int) r6)     // Catch:{ all -> 0x0104 }
            r9.a((com.alibaba.a.b.h) r3)
            return
        L_0x0072:
            com.alibaba.a.b r8 = new com.alibaba.a.b     // Catch:{ all -> 0x0104 }
            r8.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0104 }
            r9.a((java.util.Collection) r8, (java.lang.Object) r5)     // Catch:{ all -> 0x0104 }
            goto L_0x00f1
        L_0x0080:
            r0.a((int) r1)     // Catch:{ all -> 0x0104 }
            goto L_0x00f1
        L_0x0085:
            com.alibaba.a.d r10 = new com.alibaba.a.d     // Catch:{ all -> 0x0104 }
            java.lang.String r11 = "unclosed jsonArray"
            r10.<init>(r11)     // Catch:{ all -> 0x0104 }
            throw r10     // Catch:{ all -> 0x0104 }
        L_0x008e:
            com.alibaba.a.e r5 = new com.alibaba.a.e     // Catch:{ all -> 0x0104 }
            r5.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0104 }
            java.lang.Object r8 = r9.a((java.util.Map) r5, (java.lang.Object) r7)     // Catch:{ all -> 0x0104 }
            goto L_0x00f1
        L_0x009c:
            r0.a((int) r1)     // Catch:{ all -> 0x0104 }
            goto L_0x00f1
        L_0x00a0:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0104 }
            r0.a((int) r6)     // Catch:{ all -> 0x0104 }
            goto L_0x00f1
        L_0x00a6:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0104 }
            r0.a((int) r6)     // Catch:{ all -> 0x0104 }
            goto L_0x00f1
        L_0x00ac:
            java.lang.String r8 = r0.l()     // Catch:{ all -> 0x0104 }
            r0.a((int) r6)     // Catch:{ all -> 0x0104 }
            com.alibaba.a.b.c r5 = com.alibaba.a.b.c.AllowISO8601DateFormat     // Catch:{ all -> 0x0104 }
            boolean r5 = r0.a((com.alibaba.a.b.c) r5)     // Catch:{ all -> 0x0104 }
            if (r5 == 0) goto L_0x00f1
            com.alibaba.a.b.f r5 = new com.alibaba.a.b.f     // Catch:{ all -> 0x0104 }
            r5.<init>(r8)     // Catch:{ all -> 0x0104 }
            boolean r7 = r5.z()     // Catch:{ all -> 0x0104 }
            if (r7 == 0) goto L_0x00cf
            java.util.Calendar r7 = r5.y()     // Catch:{ all -> 0x0104 }
            java.util.Date r7 = r7.getTime()     // Catch:{ all -> 0x0104 }
            r8 = r7
        L_0x00cf:
            r5.close()     // Catch:{ all -> 0x0104 }
            goto L_0x00f1
        L_0x00d3:
            com.alibaba.a.b.c r5 = com.alibaba.a.b.c.UseBigDecimal     // Catch:{ all -> 0x0104 }
            boolean r5 = r0.a((com.alibaba.a.b.c) r5)     // Catch:{ all -> 0x0104 }
            if (r5 == 0) goto L_0x00e1
            r5 = 1
            java.lang.Number r5 = r0.a((boolean) r5)     // Catch:{ all -> 0x0104 }
            goto L_0x00e5
        L_0x00e1:
            java.lang.Number r5 = r0.a((boolean) r11)     // Catch:{ all -> 0x0104 }
        L_0x00e5:
            r8 = r5
            r0.a((int) r6)     // Catch:{ all -> 0x0104 }
            goto L_0x00f1
        L_0x00ea:
            java.lang.Number r8 = r0.j()     // Catch:{ all -> 0x0104 }
            r0.a((int) r6)     // Catch:{ all -> 0x0104 }
        L_0x00f1:
            r10.add(r8)     // Catch:{ all -> 0x0104 }
            r9.a((java.util.Collection) r10)     // Catch:{ all -> 0x0104 }
            int r5 = r0.a()     // Catch:{ all -> 0x0104 }
            if (r5 != r6) goto L_0x0100
            r0.a((int) r1)     // Catch:{ all -> 0x0104 }
        L_0x0100:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x0104:
            r10 = move-exception
            r9.a((com.alibaba.a.b.h) r3)
            throw r10
        L_0x0109:
            com.alibaba.a.d r10 = new com.alibaba.a.d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "syntax error, expect [, actual "
            r11.<init>(r1)
            int r1 = r0.a()
            java.lang.String r1 = com.alibaba.a.b.g.a(r1)
            r11.append(r1)
            java.lang.String r1 = ", pos "
            r11.append(r1)
            int r0 = r0.i()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.a.b.b.a(java.util.Collection, java.lang.Object):void");
    }

    public final Object a(Object obj) {
        d dVar = this.f6221d;
        int a2 = dVar.a();
        if (a2 == 2) {
            Number j2 = dVar.j();
            dVar.d();
            return j2;
        } else if (a2 == 3) {
            Number a3 = dVar.a(a(c.UseBigDecimal));
            dVar.d();
            return a3;
        } else if (a2 == 4) {
            String l2 = dVar.l();
            dVar.a(16);
            if (dVar.a(c.AllowISO8601DateFormat)) {
                f fVar = new f(l2);
                try {
                    if (fVar.z()) {
                        return fVar.y().getTime();
                    }
                    fVar.close();
                } finally {
                    fVar.close();
                }
            }
            return l2;
        } else if (a2 == 12) {
            return a((Map) new e(), obj);
        } else {
            if (a2 != 14) {
                switch (a2) {
                    case 6:
                        dVar.d();
                        return Boolean.TRUE;
                    case 7:
                        dVar.d();
                        return Boolean.FALSE;
                    case 8:
                        dVar.d();
                        return null;
                    case 9:
                        dVar.a(18);
                        if (dVar.a() == 18) {
                            dVar.a(10);
                            a(10);
                            long longValue = dVar.j().longValue();
                            a(2);
                            a(11);
                            return new Date(longValue);
                        }
                        throw new d("syntax error");
                    default:
                        switch (a2) {
                            case 20:
                                if (dVar.q()) {
                                    return null;
                                }
                                throw new d("unterminated json string, pos " + dVar.r());
                            case 21:
                                dVar.d();
                                HashSet hashSet = new HashSet();
                                a((Collection) hashSet, obj);
                                return hashSet;
                            case 22:
                                dVar.d();
                                TreeSet treeSet = new TreeSet();
                                a((Collection) treeSet, obj);
                                return treeSet;
                            case 23:
                                dVar.d();
                                return null;
                            default:
                                throw new d("syntax error, pos " + dVar.r());
                        }
                }
            } else {
                com.alibaba.a.b bVar = new com.alibaba.a.b();
                a((Collection) bVar, obj);
                return bVar;
            }
        }
    }

    public final boolean a(c cVar) {
        return this.f6221d.a(cVar);
    }

    public final void a(int i2) {
        d dVar = this.f6221d;
        if (dVar.a() == i2) {
            dVar.d();
            return;
        }
        throw new d("syntax error, expect " + g.a(i2) + ", actual " + g.a(dVar.a()));
    }

    public final void close() {
        d dVar = this.f6221d;
        try {
            if (a(c.AutoCloseSource)) {
                if (dVar.a() != 20) {
                    throw new d("not close json text, token : " + g.a(dVar.a()));
                }
            }
        } finally {
            dVar.close();
        }
    }
}
