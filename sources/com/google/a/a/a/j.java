package com.google.a.a.a;

import com.google.a.a.b.a.a.a.a.c;
import com.google.a.a.c.s;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    g f7502a = new g();

    /* renamed from: b  reason: collision with root package name */
    int f7503b = 16384;

    /* renamed from: c  reason: collision with root package name */
    boolean f7504c = true;

    /* renamed from: d  reason: collision with root package name */
    d f7505d;

    /* renamed from: e  reason: collision with root package name */
    private g f7506e = new g();

    /* renamed from: f  reason: collision with root package name */
    private int f7507f = 10;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7508g = true;

    /* renamed from: h  reason: collision with root package name */
    private final p f7509h;

    /* renamed from: i  reason: collision with root package name */
    private String f7510i;
    private c j;
    private int k = FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT;
    private int l = FileDownloadDefaultParamsKt.DOWNLOAD_DEFAULT_TIMEOUT;
    private q m;
    private h n;
    private e o;
    @Deprecated
    private b p;
    private boolean q = true;
    private boolean r = true;
    @Deprecated
    private boolean s = false;
    private boolean t;
    private s u = s.f7616a;

    j(p pVar) {
        this.f7509h = pVar;
        a((String) null);
    }

    public final j a(String str) {
        c.a(str == null || i.a(str));
        this.f7510i = str;
        return this;
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [com.google.a.a.a.f, com.google.a.a.c.t] */
    /* JADX WARNING: type inference failed for: r15v5, types: [com.google.a.a.c.q] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x024a A[ADDED_TO_REGION, Catch:{ all -> 0x0272 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02a0 A[LOOP:0: B:5:0x001a->B:151:0x02a0, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0284 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c0 A[SYNTHETIC, Splitter:B:86:0x01c0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.a.a.m a() throws java.io.IOException {
        /*
            r19 = this;
            r1 = r19
            int r0 = r1.f7507f
            if (r0 < 0) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            com.google.a.a.b.a.a.a.a.c.a((boolean) r0)
            int r0 = r1.f7507f
            java.lang.String r4 = r1.f7510i
            com.google.a.a.b.a.a.a.a.c.a(r4)
            com.google.a.a.a.c r4 = r1.j
            com.google.a.a.b.a.a.a.a.c.a(r4)
            r5 = r0
            r0 = 0
        L_0x001a:
            if (r0 == 0) goto L_0x001f
            r0.a()
        L_0x001f:
            com.google.a.a.a.c r0 = r1.j
            java.lang.String r0 = r0.a()
            com.google.a.a.a.p r6 = r1.f7509h
            java.lang.String r7 = r1.f7510i
            com.google.a.a.a.r r6 = r6.a(r7, r0)
            java.util.logging.Logger r7 = com.google.a.a.a.p.f7527a
            boolean r8 = r1.f7504c
            if (r8 == 0) goto L_0x003d
            java.util.logging.Level r8 = java.util.logging.Level.CONFIG
            boolean r8 = r7.isLoggable(r8)
            if (r8 == 0) goto L_0x003d
            r8 = 1
            goto L_0x003e
        L_0x003d:
            r8 = 0
        L_0x003e:
            java.lang.String r9 = "GET"
            if (r8 == 0) goto L_0x0081
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "-------------- REQUEST  --------------"
            r10.append(r11)
            java.lang.String r11 = com.google.a.a.c.u.f7617a
            r10.append(r11)
            java.lang.String r11 = r1.f7510i
            r10.append(r11)
            r11 = 32
            r10.append(r11)
            r10.append(r0)
            java.lang.String r11 = com.google.a.a.c.u.f7617a
            r10.append(r11)
            boolean r11 = r1.f7508g
            if (r11 == 0) goto L_0x0082
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "curl -v --compressed"
            r11.<init>(r12)
            java.lang.String r12 = r1.f7510i
            boolean r12 = r12.equals(r9)
            if (r12 != 0) goto L_0x0083
            java.lang.String r12 = " -X "
            r11.append(r12)
            java.lang.String r12 = r1.f7510i
            r11.append(r12)
            goto L_0x0083
        L_0x0081:
            r10 = 0
        L_0x0082:
            r11 = 0
        L_0x0083:
            com.google.a.a.a.g r12 = r1.f7506e
            java.util.List<java.lang.String> r12 = r12.f7489i
            java.lang.Object r12 = com.google.a.a.a.g.a(r12)
            java.lang.String r12 = (java.lang.String) r12
            boolean r13 = r1.t
            if (r13 != 0) goto L_0x00b1
            if (r12 != 0) goto L_0x009b
            com.google.a.a.a.g r13 = r1.f7506e
            java.lang.String r14 = "Google-HTTP-Java-Client/1.18.0-rc (gzip)"
            r13.a((java.lang.String) r14)
            goto L_0x00b1
        L_0x009b:
            com.google.a.a.a.g r13 = r1.f7506e
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r12)
            java.lang.String r15 = " Google-HTTP-Java-Client/1.18.0-rc (gzip)"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.a((java.lang.String) r14)
        L_0x00b1:
            com.google.a.a.a.g r13 = r1.f7506e
            com.google.a.a.a.g.a(r13, r10, r11, r7, r6)
            boolean r13 = r1.t
            if (r13 != 0) goto L_0x00bf
            com.google.a.a.a.g r13 = r1.f7506e
            r13.a((java.lang.String) r12)
        L_0x00bf:
            com.google.a.a.a.d r12 = r1.f7505d
            java.lang.String r13 = "'"
            if (r12 == 0) goto L_0x0153
            java.lang.String r14 = r12.b()
            if (r8 == 0) goto L_0x00d7
            com.google.a.a.c.q r15 = new com.google.a.a.c.q
            java.util.logging.Logger r2 = com.google.a.a.a.p.f7527a
            java.util.logging.Level r3 = java.util.logging.Level.CONFIG
            int r4 = r1.f7503b
            r15.<init>(r12, r2, r3, r4)
            goto L_0x00d8
        L_0x00d7:
            r15 = r12
        L_0x00d8:
            com.google.a.a.a.e r2 = r1.o
            if (r2 != 0) goto L_0x00e5
            com.google.a.a.a.d r2 = r1.f7505d
            long r2 = r2.a()
            r12 = r15
            r4 = 0
            goto L_0x00f7
        L_0x00e5:
            java.lang.String r4 = r2.a()
            com.google.a.a.a.f r2 = new com.google.a.a.a.f
            com.google.a.a.a.e r3 = r1.o
            r2.<init>(r15, r3)
            long r16 = com.google.a.a.c.l.a(r2)
            r12 = r2
            r2 = r16
        L_0x00f7:
            if (r8 == 0) goto L_0x0141
            if (r14 == 0) goto L_0x0126
            java.lang.String r15 = java.lang.String.valueOf(r14)
            r16 = r9
            java.lang.String r9 = "Content-Type: "
            java.lang.String r9 = r9.concat(r15)
            r10.append(r9)
            java.lang.String r15 = com.google.a.a.c.u.f7617a
            r10.append(r15)
            if (r11 == 0) goto L_0x0128
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r1 = " -H '"
            r15.<init>(r1)
            r15.append(r9)
            r15.append(r13)
            java.lang.String r1 = r15.toString()
            r11.append(r1)
            goto L_0x0128
        L_0x0126:
            r16 = r9
        L_0x0128:
            r17 = 0
            int r1 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r1 < 0) goto L_0x0143
            java.lang.String r1 = java.lang.String.valueOf(r2)
            java.lang.String r9 = "Content-Length: "
            java.lang.String r1 = r9.concat(r1)
            r10.append(r1)
            java.lang.String r1 = com.google.a.a.c.u.f7617a
            r10.append(r1)
            goto L_0x0143
        L_0x0141:
            r16 = r9
        L_0x0143:
            if (r11 == 0) goto L_0x014a
            java.lang.String r1 = " -d '@-'"
            r11.append(r1)
        L_0x014a:
            r6.f7531c = r14
            r6.f7530b = r4
            r6.f7529a = r2
            r6.f7532d = r12
            goto L_0x0155
        L_0x0153:
            r16 = r9
        L_0x0155:
            if (r8 == 0) goto L_0x017f
            java.lang.String r1 = r10.toString()
            r7.config(r1)
            if (r11 == 0) goto L_0x017f
            java.lang.String r1 = " -- '"
            r11.append(r1)
            java.lang.String r1 = "'\"'\"'"
            java.lang.String r0 = r0.replaceAll(r13, r1)
            r11.append(r0)
            r11.append(r13)
            if (r12 == 0) goto L_0x0178
            java.lang.String r0 = " << $$$"
            r11.append(r0)
        L_0x0178:
            java.lang.String r0 = r11.toString()
            r7.config(r0)
        L_0x017f:
            if (r5 <= 0) goto L_0x0183
            r2 = 1
            goto L_0x0184
        L_0x0183:
            r2 = 0
        L_0x0184:
            r1 = r19
            int r0 = r1.k
            int r3 = r1.l
            r6.a((int) r0, (int) r3)
            com.google.a.a.a.s r3 = r6.a()     // Catch:{ IOException -> 0x01a4 }
            com.google.a.a.a.m r0 = new com.google.a.a.a.m     // Catch:{ all -> 0x0199 }
            r0.<init>(r1, r3)     // Catch:{ all -> 0x0199 }
            r3 = r0
            r4 = 0
            goto L_0x01be
        L_0x0199:
            r0 = move-exception
            java.io.InputStream r3 = r3.a()     // Catch:{ IOException -> 0x01a4 }
            if (r3 == 0) goto L_0x01a3
            r3.close()     // Catch:{ IOException -> 0x01a4 }
        L_0x01a3:
            throw r0     // Catch:{ IOException -> 0x01a4 }
        L_0x01a4:
            r0 = move-exception
            r4 = r0
            boolean r0 = r1.s
            if (r0 != 0) goto L_0x01b6
            com.google.a.a.a.h r0 = r1.n
            if (r0 == 0) goto L_0x01b5
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x01b5
            goto L_0x01b6
        L_0x01b5:
            throw r4
        L_0x01b6:
            java.util.logging.Level r0 = java.util.logging.Level.WARNING
            java.lang.String r3 = "exception thrown while executing request"
            r7.log(r0, r3, r4)
            r3 = 0
        L_0x01be:
            if (r3 == 0) goto L_0x0279
            int r0 = r3.f7514b     // Catch:{ all -> 0x0272 }
            boolean r0 = com.google.a.a.a.o.a(r0)     // Catch:{ all -> 0x0272 }
            if (r0 != 0) goto L_0x0279
            com.google.a.a.a.q r0 = r1.m     // Catch:{ all -> 0x0272 }
            if (r0 == 0) goto L_0x01d3
            com.google.a.a.a.q r0 = r1.m     // Catch:{ all -> 0x0272 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x0272 }
            goto L_0x01d4
        L_0x01d3:
            r0 = 0
        L_0x01d4:
            if (r0 != 0) goto L_0x026a
            int r6 = r3.f7514b     // Catch:{ all -> 0x0272 }
            com.google.a.a.a.j r7 = r3.f7516d     // Catch:{ all -> 0x0272 }
            com.google.a.a.a.g r7 = r7.f7502a     // Catch:{ all -> 0x0272 }
            java.util.List<java.lang.String> r7 = r7.f7488h     // Catch:{ all -> 0x0272 }
            java.lang.Object r7 = com.google.a.a.a.g.a(r7)     // Catch:{ all -> 0x0272 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0272 }
            boolean r8 = r1.q     // Catch:{ all -> 0x0272 }
            if (r8 == 0) goto L_0x0244
            r8 = 307(0x133, float:4.3E-43)
            if (r6 == r8) goto L_0x01f1
            switch(r6) {
                case 301: goto L_0x01f1;
                case 302: goto L_0x01f1;
                case 303: goto L_0x01f1;
                default: goto L_0x01ef;
            }     // Catch:{ all -> 0x0272 }
        L_0x01ef:
            r8 = 0
            goto L_0x01f2
        L_0x01f1:
            r8 = 1
        L_0x01f2:
            if (r8 == 0) goto L_0x0244
            if (r7 == 0) goto L_0x0244
            com.google.a.a.a.c r8 = new com.google.a.a.a.c     // Catch:{ all -> 0x0272 }
            com.google.a.a.a.c r9 = r1.j     // Catch:{ all -> 0x0272 }
            java.net.URL r7 = r9.a((java.lang.String) r7)     // Catch:{ all -> 0x0272 }
            r8.<init>((java.net.URL) r7)     // Catch:{ all -> 0x0272 }
            r1.a((com.google.a.a.a.c) r8)     // Catch:{ all -> 0x0272 }
            r7 = 303(0x12f, float:4.25E-43)
            if (r6 != r7) goto L_0x0211
            r6 = r16
            r1.a((java.lang.String) r6)     // Catch:{ all -> 0x0272 }
            r6 = 0
            r1.f7505d = r6     // Catch:{ all -> 0x0272 }
            goto L_0x0212
        L_0x0211:
            r6 = 0
        L_0x0212:
            com.google.a.a.a.g r7 = r1.f7506e     // Catch:{ all -> 0x0272 }
            java.util.List r8 = com.google.a.a.a.g.a(r6)     // Catch:{ all -> 0x0272 }
            r7.f7481a = r8     // Catch:{ all -> 0x0272 }
            com.google.a.a.a.g r7 = r1.f7506e     // Catch:{ all -> 0x0272 }
            java.util.List r8 = com.google.a.a.a.g.a(r6)     // Catch:{ all -> 0x0272 }
            r7.f7484d = r8     // Catch:{ all -> 0x0272 }
            com.google.a.a.a.g r7 = r1.f7506e     // Catch:{ all -> 0x0272 }
            java.util.List r8 = com.google.a.a.a.g.a(r6)     // Catch:{ all -> 0x0272 }
            r7.f7485e = r8     // Catch:{ all -> 0x0272 }
            com.google.a.a.a.g r7 = r1.f7506e     // Catch:{ all -> 0x0272 }
            java.util.List r8 = com.google.a.a.a.g.a(r6)     // Catch:{ all -> 0x0272 }
            r7.f7483c = r8     // Catch:{ all -> 0x0272 }
            com.google.a.a.a.g r7 = r1.f7506e     // Catch:{ all -> 0x0272 }
            java.util.List r8 = com.google.a.a.a.g.a(r6)     // Catch:{ all -> 0x0272 }
            r7.f7486f = r8     // Catch:{ all -> 0x0272 }
            com.google.a.a.a.g r7 = r1.f7506e     // Catch:{ all -> 0x0272 }
            java.util.List r8 = com.google.a.a.a.g.a(r6)     // Catch:{ all -> 0x0272 }
            r7.f7487g = r8     // Catch:{ all -> 0x0272 }
            r7 = 1
            goto L_0x0246
        L_0x0244:
            r6 = 0
            r7 = 0
        L_0x0246:
            if (r7 == 0) goto L_0x024a
        L_0x0248:
            r0 = 1
            goto L_0x026b
        L_0x024a:
            if (r2 == 0) goto L_0x026b
            com.google.a.a.a.b r7 = r1.p     // Catch:{ all -> 0x0272 }
            if (r7 == 0) goto L_0x026b
            com.google.a.a.a.b r7 = r1.p     // Catch:{ all -> 0x0272 }
            boolean r7 = r7.a()     // Catch:{ all -> 0x0272 }
            if (r7 == 0) goto L_0x026b
            com.google.a.a.a.b r7 = r1.p     // Catch:{ all -> 0x0272 }
            long r7 = r7.b()     // Catch:{ all -> 0x0272 }
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x026b
            com.google.a.a.c.s r0 = r1.u     // Catch:{ InterruptedException -> 0x0248 }
            r0.a(r7)     // Catch:{ InterruptedException -> 0x0248 }
            goto L_0x0248
        L_0x026a:
            r6 = 0
        L_0x026b:
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0280
            r3.a()     // Catch:{ all -> 0x0272 }
            goto L_0x0280
        L_0x0272:
            r0 = move-exception
            if (r3 == 0) goto L_0x0278
            r3.b()
        L_0x0278:
            throw r0
        L_0x0279:
            r6 = 0
            if (r3 != 0) goto L_0x027e
            r0 = 1
            goto L_0x027f
        L_0x027e:
            r0 = 0
        L_0x027f:
            r0 = r0 & r2
        L_0x0280:
            int r5 = r5 + -1
            if (r0 != 0) goto L_0x02a0
            if (r3 == 0) goto L_0x029f
            boolean r0 = r1.r
            if (r0 == 0) goto L_0x029e
            int r0 = r3.f7514b
            boolean r0 = com.google.a.a.a.o.a(r0)
            if (r0 == 0) goto L_0x0293
            goto L_0x029e
        L_0x0293:
            com.google.a.a.a.n r0 = new com.google.a.a.a.n     // Catch:{ all -> 0x0299 }
            r0.<init>((com.google.a.a.a.m) r3)     // Catch:{ all -> 0x0299 }
            throw r0     // Catch:{ all -> 0x0299 }
        L_0x0299:
            r0 = move-exception
            r3.b()
            throw r0
        L_0x029e:
            return r3
        L_0x029f:
            throw r4
        L_0x02a0:
            r0 = r3
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.a.j.a():com.google.a.a.a.m");
    }

    public final j a(c cVar) {
        this.j = (c) c.a(cVar);
        return this;
    }
}
