package com.bumptech.glide.a;

import android.os.Build;
import android.os.StrictMode;
import com.business.merchant_payments.utility.StringUtility;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final ThreadPoolExecutor f6388a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C0086a((byte) 0));
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final File f6389b;

    /* renamed from: c  reason: collision with root package name */
    private final File f6390c;

    /* renamed from: d  reason: collision with root package name */
    private final File f6391d;

    /* renamed from: e  reason: collision with root package name */
    private final File f6392e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6393f;

    /* renamed from: g  reason: collision with root package name */
    private long f6394g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final int f6395h;

    /* renamed from: i  reason: collision with root package name */
    private long f6396i = 0;
    /* access modifiers changed from: private */
    public Writer j;
    private final LinkedHashMap<String, c> k = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    public int l;
    private long m = 0;
    private final Callable<Void> n = new Callable<Void>() {
        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r3 = this;
                com.bumptech.glide.a.a r0 = com.bumptech.glide.a.a.this
                monitor-enter(r0)
                com.bumptech.glide.a.a r1 = com.bumptech.glide.a.a.this     // Catch:{ all -> 0x0027 }
                java.io.Writer r1 = r1.j     // Catch:{ all -> 0x0027 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x000e:
                com.bumptech.glide.a.a r1 = com.bumptech.glide.a.a.this     // Catch:{ all -> 0x0027 }
                r1.f()     // Catch:{ all -> 0x0027 }
                com.bumptech.glide.a.a r1 = com.bumptech.glide.a.a.this     // Catch:{ all -> 0x0027 }
                boolean r1 = r1.d()     // Catch:{ all -> 0x0027 }
                if (r1 == 0) goto L_0x0025
                com.bumptech.glide.a.a r1 = com.bumptech.glide.a.a.this     // Catch:{ all -> 0x0027 }
                r1.c()     // Catch:{ all -> 0x0027 }
                com.bumptech.glide.a.a r1 = com.bumptech.glide.a.a.this     // Catch:{ all -> 0x0027 }
                int unused = r1.l = 0     // Catch:{ all -> 0x0027 }
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x0027:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.a.a.AnonymousClass1.call():java.lang.Void");
        }
    };

    private a(File file, long j2) {
        File file2 = file;
        this.f6389b = file2;
        this.f6393f = 1;
        this.f6390c = new File(file2, "journal");
        this.f6391d = new File(file2, "journal.tmp");
        this.f6392e = new File(file2, "journal.bkp");
        this.f6395h = 1;
        this.f6394g = j2;
    }

    public static a a(File file, long j2) throws IOException {
        if (j2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, j2);
            if (aVar.f6390c.exists()) {
                try {
                    aVar.a();
                    aVar.b();
                    return aVar;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.close();
                    c.a(aVar.f6389b);
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, j2);
            aVar2.c();
            return aVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:52|53|(1:55)|(1:57)(1:58)|59|60) */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r12.l = r2 - r12.k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x010a, code lost:
        if (r1.f6416b == -1) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x010c, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010d, code lost:
        if (r0 != false) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x010f, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0113, code lost:
        r12.j = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r12.f6390c, true), com.bumptech.glide.a.c.f6421a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x00ff */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:61:0x012c=Splitter:B:61:0x012c, B:52:0x00ff=Splitter:B:52:0x00ff} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = ", "
            com.bumptech.glide.a.b r1 = new com.bumptech.glide.a.b
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r12.f6390c
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.bumptech.glide.a.c.f6421a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.a()     // Catch:{ all -> 0x0158 }
            java.lang.String r3 = r1.a()     // Catch:{ all -> 0x0158 }
            java.lang.String r4 = r1.a()     // Catch:{ all -> 0x0158 }
            java.lang.String r5 = r1.a()     // Catch:{ all -> 0x0158 }
            java.lang.String r6 = r1.a()     // Catch:{ all -> 0x0158 }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x0158 }
            if (r7 == 0) goto L_0x012c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x0158 }
            if (r7 == 0) goto L_0x012c
            int r7 = r12.f6393f     // Catch:{ all -> 0x0158 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0158 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x0158 }
            if (r4 == 0) goto L_0x012c
            int r4 = r12.f6395h     // Catch:{ all -> 0x0158 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x0158 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0158 }
            if (r4 == 0) goto L_0x012c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0158 }
            if (r4 == 0) goto L_0x012c
            r0 = 0
            r2 = 0
        L_0x0056:
            r3 = 1
            r4 = -1
            java.lang.String r5 = r1.a()     // Catch:{ EOFException -> 0x00ff }
            r6 = 32
            int r7 = r5.indexOf(r6)     // Catch:{ EOFException -> 0x00ff }
            java.lang.String r8 = "unexpected journal line: "
            if (r7 == r4) goto L_0x00f1
            int r9 = r7 + 1
            int r6 = r5.indexOf(r6, r9)     // Catch:{ EOFException -> 0x00ff }
            if (r6 != r4) goto L_0x0084
            java.lang.String r9 = r5.substring(r9)     // Catch:{ EOFException -> 0x00ff }
            r10 = 6
            if (r7 != r10) goto L_0x0088
            java.lang.String r10 = "REMOVE"
            boolean r10 = r5.startsWith(r10)     // Catch:{ EOFException -> 0x00ff }
            if (r10 == 0) goto L_0x0088
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r5 = r12.k     // Catch:{ EOFException -> 0x00ff }
            r5.remove(r9)     // Catch:{ EOFException -> 0x00ff }
            goto L_0x00df
        L_0x0084:
            java.lang.String r9 = r5.substring(r9, r6)     // Catch:{ EOFException -> 0x00ff }
        L_0x0088:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r10 = r12.k     // Catch:{ EOFException -> 0x00ff }
            java.lang.Object r10 = r10.get(r9)     // Catch:{ EOFException -> 0x00ff }
            com.bumptech.glide.a.a$c r10 = (com.bumptech.glide.a.a.c) r10     // Catch:{ EOFException -> 0x00ff }
            if (r10 != 0) goto L_0x009c
            com.bumptech.glide.a.a$c r10 = new com.bumptech.glide.a.a$c     // Catch:{ EOFException -> 0x00ff }
            r10.<init>(r12, r9, r0)     // Catch:{ EOFException -> 0x00ff }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r11 = r12.k     // Catch:{ EOFException -> 0x00ff }
            r11.put(r9, r10)     // Catch:{ EOFException -> 0x00ff }
        L_0x009c:
            r9 = 5
            if (r6 == r4) goto L_0x00be
            if (r7 != r9) goto L_0x00be
            java.lang.String r11 = "CLEAN"
            boolean r11 = r5.startsWith(r11)     // Catch:{ EOFException -> 0x00ff }
            if (r11 == 0) goto L_0x00be
            int r6 = r6 + 1
            java.lang.String r5 = r5.substring(r6)     // Catch:{ EOFException -> 0x00ff }
            java.lang.String r6 = " "
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ EOFException -> 0x00ff }
            r10.f6406e = r3     // Catch:{ EOFException -> 0x00ff }
            r6 = 0
            r10.f6407f = r6     // Catch:{ EOFException -> 0x00ff }
            r10.a(r5)     // Catch:{ EOFException -> 0x00ff }
            goto L_0x00df
        L_0x00be:
            if (r6 != r4) goto L_0x00d2
            if (r7 != r9) goto L_0x00d2
            java.lang.String r9 = "DIRTY"
            boolean r9 = r5.startsWith(r9)     // Catch:{ EOFException -> 0x00ff }
            if (r9 == 0) goto L_0x00d2
            com.bumptech.glide.a.a$b r5 = new com.bumptech.glide.a.a$b     // Catch:{ EOFException -> 0x00ff }
            r5.<init>(r12, r10, r0)     // Catch:{ EOFException -> 0x00ff }
            r10.f6407f = r5     // Catch:{ EOFException -> 0x00ff }
            goto L_0x00df
        L_0x00d2:
            if (r6 != r4) goto L_0x00e3
            r6 = 4
            if (r7 != r6) goto L_0x00e3
            java.lang.String r6 = "READ"
            boolean r6 = r5.startsWith(r6)     // Catch:{ EOFException -> 0x00ff }
            if (r6 == 0) goto L_0x00e3
        L_0x00df:
            int r2 = r2 + 1
            goto L_0x0056
        L_0x00e3:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ EOFException -> 0x00ff }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ EOFException -> 0x00ff }
            java.lang.String r5 = r8.concat(r5)     // Catch:{ EOFException -> 0x00ff }
            r6.<init>(r5)     // Catch:{ EOFException -> 0x00ff }
            throw r6     // Catch:{ EOFException -> 0x00ff }
        L_0x00f1:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ EOFException -> 0x00ff }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ EOFException -> 0x00ff }
            java.lang.String r5 = r8.concat(r5)     // Catch:{ EOFException -> 0x00ff }
            r6.<init>(r5)     // Catch:{ EOFException -> 0x00ff }
            throw r6     // Catch:{ EOFException -> 0x00ff }
        L_0x00ff:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r5 = r12.k     // Catch:{ all -> 0x0158 }
            int r5 = r5.size()     // Catch:{ all -> 0x0158 }
            int r2 = r2 - r5
            r12.l = r2     // Catch:{ all -> 0x0158 }
            int r2 = r1.f6416b     // Catch:{ all -> 0x0158 }
            if (r2 != r4) goto L_0x010d
            r0 = 1
        L_0x010d:
            if (r0 == 0) goto L_0x0113
            r12.c()     // Catch:{ all -> 0x0158 }
            goto L_0x0128
        L_0x0113:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x0158 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0158 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0158 }
            java.io.File r5 = r12.f6390c     // Catch:{ all -> 0x0158 }
            r4.<init>(r5, r3)     // Catch:{ all -> 0x0158 }
            java.nio.charset.Charset r3 = com.bumptech.glide.a.c.f6421a     // Catch:{ all -> 0x0158 }
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0158 }
            r0.<init>(r2)     // Catch:{ all -> 0x0158 }
            r12.j = r0     // Catch:{ all -> 0x0158 }
        L_0x0128:
            com.bumptech.glide.a.c.a((java.io.Closeable) r1)
            return
        L_0x012c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0158 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0158 }
            java.lang.String r8 = "unexpected journal header: ["
            r7.<init>(r8)     // Catch:{ all -> 0x0158 }
            r7.append(r2)     // Catch:{ all -> 0x0158 }
            r7.append(r0)     // Catch:{ all -> 0x0158 }
            r7.append(r3)     // Catch:{ all -> 0x0158 }
            r7.append(r0)     // Catch:{ all -> 0x0158 }
            r7.append(r5)     // Catch:{ all -> 0x0158 }
            r7.append(r0)     // Catch:{ all -> 0x0158 }
            r7.append(r6)     // Catch:{ all -> 0x0158 }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x0158 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0158 }
            r4.<init>(r0)     // Catch:{ all -> 0x0158 }
            throw r4     // Catch:{ all -> 0x0158 }
        L_0x0158:
            r0 = move-exception
            com.bumptech.glide.a.c.a((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.a.a.a():void");
    }

    private void b() throws IOException {
        a(this.f6391d);
        Iterator<c> it2 = this.k.values().iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            int i2 = 0;
            if (next.f6407f == null) {
                while (i2 < this.f6395h) {
                    this.f6396i += next.f6403b[i2];
                    i2++;
                }
            } else {
                next.f6407f = null;
                while (i2 < this.f6395h) {
                    a(next.f6404c[i2]);
                    a(next.f6405d[i2]);
                    i2++;
                }
                it2.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void c() throws IOException {
        if (this.j != null) {
            a(this.j);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f6391d), c.f6421a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(StringUtility.NEW_LINE);
            bufferedWriter.write("1");
            bufferedWriter.write(StringUtility.NEW_LINE);
            bufferedWriter.write(Integer.toString(this.f6393f));
            bufferedWriter.write(StringUtility.NEW_LINE);
            bufferedWriter.write(Integer.toString(this.f6395h));
            bufferedWriter.write(StringUtility.NEW_LINE);
            bufferedWriter.write(StringUtility.NEW_LINE);
            for (c next : this.k.values()) {
                if (next.f6407f != null) {
                    bufferedWriter.write("DIRTY " + next.f6402a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f6402a + next.a() + 10);
                }
            }
            a((Writer) bufferedWriter);
            if (this.f6390c.exists()) {
                a(this.f6390c, this.f6392e, true);
            }
            a(this.f6391d, this.f6390c, false);
            this.f6392e.delete();
            this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f6390c, true), c.f6421a));
        } catch (Throwable th) {
            a((Writer) bufferedWriter);
            throw th;
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized d a(String str) throws IOException {
        e();
        c cVar = this.k.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f6406e) {
            return null;
        }
        for (File exists : cVar.f6404c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.l++;
        this.j.append("READ");
        this.j.append(' ');
        this.j.append(str);
        this.j.append(10);
        if (d()) {
            this.f6388a.submit(this.n);
        }
        return new d(this, str, cVar.f6408g, cVar.f6404c, cVar.f6403b, (byte) 0);
    }

    public final synchronized b b(String str) throws IOException {
        e();
        c cVar = this.k.get(str);
        if (cVar == null) {
            cVar = new c(this, str, (byte) 0);
            this.k.put(str, cVar);
        } else if (cVar.f6407f != null) {
            return null;
        }
        b bVar = new b(this, cVar, (byte) 0);
        cVar.f6407f = bVar;
        this.j.append("DIRTY");
        this.j.append(' ');
        this.j.append(str);
        this.j.append(10);
        b(this.j);
        return bVar;
    }

    /* access modifiers changed from: private */
    public boolean d() {
        int i2 = this.l;
        return i2 >= 2000 && i2 >= this.k.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean c(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.e()     // Catch:{ all -> 0x0081 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r0 = r7.k     // Catch:{ all -> 0x0081 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0081 }
            com.bumptech.glide.a.a$c r0 = (com.bumptech.glide.a.a.c) r0     // Catch:{ all -> 0x0081 }
            r1 = 0
            if (r0 == 0) goto L_0x007f
            com.bumptech.glide.a.a$b r2 = r0.f6407f     // Catch:{ all -> 0x0081 }
            if (r2 == 0) goto L_0x0014
            goto L_0x007f
        L_0x0014:
            int r2 = r7.f6395h     // Catch:{ all -> 0x0081 }
            if (r1 >= r2) goto L_0x004b
            java.io.File[] r2 = r0.f6404c     // Catch:{ all -> 0x0081 }
            r2 = r2[r1]     // Catch:{ all -> 0x0081 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0081 }
            if (r3 == 0) goto L_0x0039
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0081 }
            if (r3 == 0) goto L_0x0029
            goto L_0x0039
        L_0x0029:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = "failed to delete "
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x0081 }
            r8.<init>(r0)     // Catch:{ all -> 0x0081 }
            throw r8     // Catch:{ all -> 0x0081 }
        L_0x0039:
            long r2 = r7.f6396i     // Catch:{ all -> 0x0081 }
            long[] r4 = r0.f6403b     // Catch:{ all -> 0x0081 }
            r5 = r4[r1]     // Catch:{ all -> 0x0081 }
            long r2 = r2 - r5
            r7.f6396i = r2     // Catch:{ all -> 0x0081 }
            long[] r2 = r0.f6403b     // Catch:{ all -> 0x0081 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0081 }
            int r1 = r1 + 1
            goto L_0x0014
        L_0x004b:
            int r0 = r7.l     // Catch:{ all -> 0x0081 }
            r1 = 1
            int r0 = r0 + r1
            r7.l = r0     // Catch:{ all -> 0x0081 }
            java.io.Writer r0 = r7.j     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x0081 }
            java.io.Writer r0 = r7.j     // Catch:{ all -> 0x0081 }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x0081 }
            java.io.Writer r0 = r7.j     // Catch:{ all -> 0x0081 }
            r0.append(r8)     // Catch:{ all -> 0x0081 }
            java.io.Writer r0 = r7.j     // Catch:{ all -> 0x0081 }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x0081 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r0 = r7.k     // Catch:{ all -> 0x0081 }
            r0.remove(r8)     // Catch:{ all -> 0x0081 }
            boolean r8 = r7.d()     // Catch:{ all -> 0x0081 }
            if (r8 == 0) goto L_0x007d
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f6388a     // Catch:{ all -> 0x0081 }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.n     // Catch:{ all -> 0x0081 }
            r8.submit(r0)     // Catch:{ all -> 0x0081 }
        L_0x007d:
            monitor-exit(r7)
            return r1
        L_0x007f:
            monitor-exit(r7)
            return r1
        L_0x0081:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.a.a.c(java.lang.String):boolean");
    }

    private void e() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void close() throws IOException {
        if (this.j != null) {
            Iterator it2 = new ArrayList(this.k.values()).iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                if (cVar.f6407f != null) {
                    cVar.f6407f.b();
                }
            }
            f();
            a(this.j);
            this.j = null;
        }
    }

    /* access modifiers changed from: private */
    public void f() throws IOException {
        while (this.f6396i > this.f6394g) {
            c((String) this.k.entrySet().iterator().next().getKey());
        }
    }

    private static void a(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private static void b(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final class d {

        /* renamed from: a  reason: collision with root package name */
        public final File[] f6410a;

        /* renamed from: c  reason: collision with root package name */
        private final String f6412c;

        /* renamed from: d  reason: collision with root package name */
        private final long f6413d;

        /* renamed from: e  reason: collision with root package name */
        private final long[] f6414e;

        /* synthetic */ d(a aVar, String str, long j, File[] fileArr, long[] jArr, byte b2) {
            this(str, j, fileArr, jArr);
        }

        private d(String str, long j, File[] fileArr, long[] jArr) {
            this.f6412c = str;
            this.f6413d = j;
            this.f6410a = fileArr;
            this.f6414e = jArr;
        }
    }

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        final c f6398a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f6399b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6400c;

        /* synthetic */ b(a aVar, c cVar, byte b2) {
            this(cVar);
        }

        private b(c cVar) {
            this.f6398a = cVar;
            this.f6399b = cVar.f6406e ? null : new boolean[a.this.f6395h];
        }

        public final File a() throws IOException {
            File file;
            synchronized (a.this) {
                if (this.f6398a.f6407f == this) {
                    if (!this.f6398a.f6406e) {
                        this.f6399b[0] = true;
                    }
                    file = this.f6398a.f6405d[0];
                    if (!a.this.f6389b.exists()) {
                        a.this.f6389b.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return file;
        }

        public final void b() throws IOException {
            a.this.a(this, false);
        }

        public final void c() {
            if (!this.f6400c) {
                try {
                    b();
                } catch (IOException unused) {
                }
            }
        }
    }

    final class c {

        /* renamed from: a  reason: collision with root package name */
        final String f6402a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f6403b;

        /* renamed from: c  reason: collision with root package name */
        File[] f6404c;

        /* renamed from: d  reason: collision with root package name */
        File[] f6405d;

        /* renamed from: e  reason: collision with root package name */
        boolean f6406e;

        /* renamed from: f  reason: collision with root package name */
        b f6407f;

        /* renamed from: g  reason: collision with root package name */
        long f6408g;

        /* synthetic */ c(a aVar, String str, byte b2) {
            this(str);
        }

        private c(String str) {
            this.f6402a = str;
            this.f6403b = new long[a.this.f6395h];
            this.f6404c = new File[a.this.f6395h];
            this.f6405d = new File[a.this.f6395h];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < a.this.f6395h; i2++) {
                sb.append(i2);
                this.f6404c[i2] = new File(a.this.f6389b, sb.toString());
                sb.append(".tmp");
                this.f6405d[i2] = new File(a.this.f6389b, sb.toString());
                sb.setLength(length);
            }
        }

        public final String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f6403b) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public final void a(String[] strArr) throws IOException {
            if (strArr.length == a.this.f6395h) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.f6403b[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        throw b(strArr);
                    }
                }
                return;
            }
            throw b(strArr);
        }

        private static IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    /* renamed from: com.bumptech.glide.a.a$a  reason: collision with other inner class name */
    static final class C0086a implements ThreadFactory {
        private C0086a() {
        }

        /* synthetic */ C0086a(byte b2) {
            this();
        }

        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.bumptech.glide.a.a.b r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.bumptech.glide.a.a$c r0 = r10.f6398a     // Catch:{ all -> 0x00f0 }
            com.bumptech.glide.a.a$b r1 = r0.f6407f     // Catch:{ all -> 0x00f0 }
            if (r1 != r10) goto L_0x00ea
            r1 = 0
            if (r11 == 0) goto L_0x003e
            boolean r2 = r0.f6406e     // Catch:{ all -> 0x00f0 }
            if (r2 != 0) goto L_0x003e
            r2 = 0
        L_0x000f:
            int r3 = r9.f6395h     // Catch:{ all -> 0x00f0 }
            if (r2 >= r3) goto L_0x003e
            boolean[] r3 = r10.f6399b     // Catch:{ all -> 0x00f0 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00f0 }
            if (r3 == 0) goto L_0x002b
            java.io.File[] r3 = r0.f6405d     // Catch:{ all -> 0x00f0 }
            r3 = r3[r2]     // Catch:{ all -> 0x00f0 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x00f0 }
            if (r3 != 0) goto L_0x0028
            r10.b()     // Catch:{ all -> 0x00f0 }
            monitor-exit(r9)
            return
        L_0x0028:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002b:
            r10.b()     // Catch:{ all -> 0x00f0 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f0 }
            java.lang.String r11 = "Newly created entry didn't create value for index "
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00f0 }
            java.lang.String r11 = r11.concat(r0)     // Catch:{ all -> 0x00f0 }
            r10.<init>(r11)     // Catch:{ all -> 0x00f0 }
            throw r10     // Catch:{ all -> 0x00f0 }
        L_0x003e:
            int r10 = r9.f6395h     // Catch:{ all -> 0x00f0 }
            if (r1 >= r10) goto L_0x006e
            java.io.File[] r10 = r0.f6405d     // Catch:{ all -> 0x00f0 }
            r10 = r10[r1]     // Catch:{ all -> 0x00f0 }
            if (r11 == 0) goto L_0x0068
            boolean r2 = r10.exists()     // Catch:{ all -> 0x00f0 }
            if (r2 == 0) goto L_0x006b
            java.io.File[] r2 = r0.f6404c     // Catch:{ all -> 0x00f0 }
            r2 = r2[r1]     // Catch:{ all -> 0x00f0 }
            r10.renameTo(r2)     // Catch:{ all -> 0x00f0 }
            long[] r10 = r0.f6403b     // Catch:{ all -> 0x00f0 }
            r3 = r10[r1]     // Catch:{ all -> 0x00f0 }
            long r5 = r2.length()     // Catch:{ all -> 0x00f0 }
            long[] r10 = r0.f6403b     // Catch:{ all -> 0x00f0 }
            r10[r1] = r5     // Catch:{ all -> 0x00f0 }
            long r7 = r9.f6396i     // Catch:{ all -> 0x00f0 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f6396i = r7     // Catch:{ all -> 0x00f0 }
            goto L_0x006b
        L_0x0068:
            a((java.io.File) r10)     // Catch:{ all -> 0x00f0 }
        L_0x006b:
            int r1 = r1 + 1
            goto L_0x003e
        L_0x006e:
            int r10 = r9.l     // Catch:{ all -> 0x00f0 }
            r1 = 1
            int r10 = r10 + r1
            r9.l = r10     // Catch:{ all -> 0x00f0 }
            r10 = 0
            r0.f6407f = r10     // Catch:{ all -> 0x00f0 }
            boolean r10 = r0.f6406e     // Catch:{ all -> 0x00f0 }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00af
            r0.f6406e = r1     // Catch:{ all -> 0x00f0 }
            java.io.Writer r10 = r9.j     // Catch:{ all -> 0x00f0 }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x00f0 }
            java.io.Writer r10 = r9.j     // Catch:{ all -> 0x00f0 }
            r10.append(r3)     // Catch:{ all -> 0x00f0 }
            java.io.Writer r10 = r9.j     // Catch:{ all -> 0x00f0 }
            java.lang.String r1 = r0.f6402a     // Catch:{ all -> 0x00f0 }
            r10.append(r1)     // Catch:{ all -> 0x00f0 }
            java.io.Writer r10 = r9.j     // Catch:{ all -> 0x00f0 }
            java.lang.String r1 = r0.a()     // Catch:{ all -> 0x00f0 }
            r10.append(r1)     // Catch:{ all -> 0x00f0 }
            java.io.Writer r10 = r9.j     // Catch:{ all -> 0x00f0 }
            r10.append(r2)     // Catch:{ all -> 0x00f0 }
            if (r11 == 0) goto L_0x00ce
            long r10 = r9.m     // Catch:{ all -> 0x00f0 }
            r1 = 1
            long r1 = r1 + r10
            r9.m = r1     // Catch:{ all -> 0x00f0 }
            r0.f6408g = r10     // Catch:{ all -> 0x00f0 }
            goto L_0x00ce
        L_0x00af:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.a.a$c> r10 = r9.k     // Catch:{ all -> 0x00f0 }
            java.lang.String r11 = r0.f6402a     // Catch:{ all -> 0x00f0 }
            r10.remove(r11)     // Catch:{ all -> 0x00f0 }
            java.io.Writer r10 = r9.j     // Catch:{ all -> 0x00f0 }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x00f0 }
            java.io.Writer r10 = r9.j     // Catch:{ all -> 0x00f0 }
            r10.append(r3)     // Catch:{ all -> 0x00f0 }
            java.io.Writer r10 = r9.j     // Catch:{ all -> 0x00f0 }
            java.lang.String r11 = r0.f6402a     // Catch:{ all -> 0x00f0 }
            r10.append(r11)     // Catch:{ all -> 0x00f0 }
            java.io.Writer r10 = r9.j     // Catch:{ all -> 0x00f0 }
            r10.append(r2)     // Catch:{ all -> 0x00f0 }
        L_0x00ce:
            java.io.Writer r10 = r9.j     // Catch:{ all -> 0x00f0 }
            b((java.io.Writer) r10)     // Catch:{ all -> 0x00f0 }
            long r10 = r9.f6396i     // Catch:{ all -> 0x00f0 }
            long r0 = r9.f6394g     // Catch:{ all -> 0x00f0 }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00e1
            boolean r10 = r9.d()     // Catch:{ all -> 0x00f0 }
            if (r10 == 0) goto L_0x00e8
        L_0x00e1:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f6388a     // Catch:{ all -> 0x00f0 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.n     // Catch:{ all -> 0x00f0 }
            r10.submit(r11)     // Catch:{ all -> 0x00f0 }
        L_0x00e8:
            monitor-exit(r9)
            return
        L_0x00ea:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f0 }
            r10.<init>()     // Catch:{ all -> 0x00f0 }
            throw r10     // Catch:{ all -> 0x00f0 }
        L_0x00f0:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.a.a.a(com.bumptech.glide.a.a$b, boolean):void");
    }
}
