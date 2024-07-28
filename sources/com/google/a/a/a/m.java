package com.google.a.a.a;

import com.google.a.a.c.e;
import com.google.a.a.c.l;
import com.google.a.a.c.o;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    s f7513a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7514b;

    /* renamed from: c  reason: collision with root package name */
    final String f7515c;

    /* renamed from: d  reason: collision with root package name */
    final j f7516d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f7517e;

    /* renamed from: f  reason: collision with root package name */
    private final String f7518f;

    /* renamed from: g  reason: collision with root package name */
    private final String f7519g;

    /* renamed from: h  reason: collision with root package name */
    private final i f7520h;

    /* renamed from: i  reason: collision with root package name */
    private int f7521i;
    private boolean j;
    private boolean k;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    m(com.google.a.a.a.j r7, com.google.a.a.a.s r8) throws java.io.IOException {
        /*
            r6 = this;
            r6.<init>()
            r6.f7516d = r7
            int r0 = r7.f7503b
            r6.f7521i = r0
            boolean r0 = r7.f7504c
            r6.j = r0
            r6.f7513a = r8
            java.lang.String r0 = r8.b()
            r6.f7518f = r0
            int r0 = r8.e()
            r1 = 0
            if (r0 >= 0) goto L_0x001d
            r0 = 0
        L_0x001d:
            r6.f7514b = r0
            java.lang.String r0 = r8.f()
            r6.f7515c = r0
            java.util.logging.Logger r2 = com.google.a.a.a.p.f7527a
            boolean r3 = r6.j
            if (r3 == 0) goto L_0x0034
            java.util.logging.Level r3 = java.util.logging.Level.CONFIG
            boolean r3 = r2.isLoggable(r3)
            if (r3 == 0) goto L_0x0034
            r1 = 1
        L_0x0034:
            r3 = 0
            if (r1 == 0) goto L_0x0065
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "-------------- RESPONSE --------------"
            r4.append(r5)
            java.lang.String r5 = com.google.a.a.c.u.f7617a
            r4.append(r5)
            java.lang.String r5 = r8.d()
            if (r5 == 0) goto L_0x0050
            r4.append(r5)
            goto L_0x005f
        L_0x0050:
            int r5 = r6.f7514b
            r4.append(r5)
            if (r0 == 0) goto L_0x005f
            r5 = 32
            r4.append(r5)
            r4.append(r0)
        L_0x005f:
            java.lang.String r0 = com.google.a.a.c.u.f7617a
            r4.append(r0)
            goto L_0x0066
        L_0x0065:
            r4 = r3
        L_0x0066:
            com.google.a.a.a.g r0 = r7.f7502a
            if (r1 == 0) goto L_0x006c
            r5 = r4
            goto L_0x006d
        L_0x006c:
            r5 = r3
        L_0x006d:
            r0.a((com.google.a.a.a.s) r8, (java.lang.StringBuilder) r5)
            java.lang.String r8 = r8.c()
            if (r8 != 0) goto L_0x0081
            com.google.a.a.a.g r7 = r7.f7502a
            java.util.List<java.lang.String> r7 = r7.f7482b
            java.lang.Object r7 = com.google.a.a.a.g.a(r7)
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
        L_0x0081:
            r6.f7519g = r8
            if (r8 != 0) goto L_0x0086
            goto L_0x008b
        L_0x0086:
            com.google.a.a.a.i r3 = new com.google.a.a.a.i
            r3.<init>(r8)
        L_0x008b:
            r6.f7520h = r3
            if (r1 == 0) goto L_0x0096
            java.lang.String r7 = r4.toString()
            r2.config(r7)
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.a.m.<init>(com.google.a.a.a.j, com.google.a.a.a.s):void");
    }

    private InputStream d() throws IOException {
        if (!this.k) {
            o a2 = this.f7513a.a();
            if (a2 != null) {
                try {
                    String str = this.f7518f;
                    if (str != null && str.contains("gzip")) {
                        a2 = new GZIPInputStream(a2);
                    }
                    Logger logger = p.f7527a;
                    if (this.j && logger.isLoggable(Level.CONFIG)) {
                        a2 = new o(a2, logger, Level.CONFIG, this.f7521i);
                    }
                    this.f7517e = a2;
                } catch (EOFException unused) {
                    a2.close();
                } catch (Throwable th) {
                    a2.close();
                    throw th;
                }
            }
            this.k = true;
        }
        return this.f7517e;
    }

    public final void a() throws IOException {
        InputStream d2 = d();
        if (d2 != null) {
            d2.close();
        }
    }

    public final void b() throws IOException {
        a();
        this.f7513a.h();
    }

    public final String c() throws IOException {
        InputStream d2 = d();
        if (d2 == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l.a(d2, byteArrayOutputStream);
        i iVar = this.f7520h;
        return byteArrayOutputStream.toString(((iVar == null || iVar.b() == null) ? e.f7565b : this.f7520h.b()).name());
    }
}
