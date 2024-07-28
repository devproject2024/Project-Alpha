package com.google.firebase.crashlytics.a.i;

import com.google.firebase.crashlytics.a.c.s;
import java.io.File;
import java.util.List;

public final class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final short[] f38625a = {10, 20, 30, 60, 120, 300};

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.crashlytics.a.i.b.b f38626b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38627c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38628d;

    /* renamed from: e  reason: collision with root package name */
    private final s f38629e;

    /* renamed from: f  reason: collision with root package name */
    private final a f38630f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final a f38631g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Thread f38632h;

    public interface a {
        boolean a();
    }

    /* renamed from: com.google.firebase.crashlytics.a.i.b$b  reason: collision with other inner class name */
    public interface C0646b {
        b a(com.google.firebase.crashlytics.a.k.a.b bVar);
    }

    public interface c {
        File[] a();

        File[] b();
    }

    public b(String str, String str2, s sVar, a aVar, com.google.firebase.crashlytics.a.i.b.b bVar, a aVar2) {
        if (bVar != null) {
            this.f38626b = bVar;
            this.f38627c = str;
            this.f38628d = str2;
            this.f38629e = sVar;
            this.f38630f = aVar;
            this.f38631g = aVar2;
            return;
        }
        throw new IllegalArgumentException("createReportCall must not be null.");
    }

    public final synchronized void a(List<com.google.firebase.crashlytics.a.i.a.c> list, boolean z, float f2) {
        if (this.f38632h != null) {
            com.google.firebase.crashlytics.a.b.a().a(3);
            return;
        }
        this.f38632h = new Thread(new d(list, z, f2), "Crashlytics Report Uploader");
        this.f38632h.start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059 A[Catch:{ Exception -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.google.firebase.crashlytics.a.i.a.c r7, boolean r8) {
        /*
            r6 = this;
            r0 = 0
            com.google.firebase.crashlytics.a.i.a.a r1 = new com.google.firebase.crashlytics.a.i.a.a     // Catch:{ Exception -> 0x005e }
            java.lang.String r2 = r6.f38627c     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = r6.f38628d     // Catch:{ Exception -> 0x005e }
            r1.<init>(r2, r3, r7)     // Catch:{ Exception -> 0x005e }
            com.google.firebase.crashlytics.a.c.s r2 = r6.f38629e     // Catch:{ Exception -> 0x005e }
            com.google.firebase.crashlytics.a.c.s r3 = com.google.firebase.crashlytics.a.c.s.ALL     // Catch:{ Exception -> 0x005e }
            r4 = 3
            r5 = 1
            if (r2 != r3) goto L_0x001a
            com.google.firebase.crashlytics.a.b r8 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x005e }
            r8.a(r4)     // Catch:{ Exception -> 0x005e }
            goto L_0x002f
        L_0x001a:
            com.google.firebase.crashlytics.a.c.s r2 = r6.f38629e     // Catch:{ Exception -> 0x005e }
            com.google.firebase.crashlytics.a.c.s r3 = com.google.firebase.crashlytics.a.c.s.JAVA_ONLY     // Catch:{ Exception -> 0x005e }
            if (r2 != r3) goto L_0x0031
            com.google.firebase.crashlytics.a.i.a.c$a r2 = r7.g()     // Catch:{ Exception -> 0x005e }
            com.google.firebase.crashlytics.a.i.a.c$a r3 = com.google.firebase.crashlytics.a.i.a.c.a.JAVA     // Catch:{ Exception -> 0x005e }
            if (r2 != r3) goto L_0x0031
            com.google.firebase.crashlytics.a.b r8 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x005e }
            r8.a(r4)     // Catch:{ Exception -> 0x005e }
        L_0x002f:
            r8 = 1
            goto L_0x0057
        L_0x0031:
            com.google.firebase.crashlytics.a.i.b.b r2 = r6.f38626b     // Catch:{ Exception -> 0x005e }
            boolean r8 = r2.a(r1, r8)     // Catch:{ Exception -> 0x005e }
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x005e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = "Crashlytics Reports Endpoint upload "
            r2.<init>(r3)     // Catch:{ Exception -> 0x005e }
            if (r8 == 0) goto L_0x0047
            java.lang.String r3 = "complete: "
            goto L_0x0049
        L_0x0047:
            java.lang.String r3 = "FAILED: "
        L_0x0049:
            r2.append(r3)     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = r7.c()     // Catch:{ Exception -> 0x005e }
            r2.append(r3)     // Catch:{ Exception -> 0x005e }
            r2 = 4
            r1.a(r2)     // Catch:{ Exception -> 0x005e }
        L_0x0057:
            if (r8 == 0) goto L_0x006f
            r7.a()     // Catch:{ Exception -> 0x005e }
            r0 = 1
            goto L_0x006f
        L_0x005e:
            com.google.firebase.crashlytics.a.b r8 = com.google.firebase.crashlytics.a.b.a()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r1 = "Error occurred sending report "
            r1.concat(r7)
            r7 = 6
            r8.a(r7)
        L_0x006f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.i.b.a(com.google.firebase.crashlytics.a.i.a.c, boolean):boolean");
    }

    class d extends com.google.firebase.crashlytics.a.c.d {

        /* renamed from: b  reason: collision with root package name */
        private final List<com.google.firebase.crashlytics.a.i.a.c> f38638b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f38639c;

        /* renamed from: d  reason: collision with root package name */
        private final float f38640d;

        d(List<com.google.firebase.crashlytics.a.i.a.c> list, boolean z, float f2) {
            this.f38638b = list;
            this.f38639c = z;
            this.f38640d = f2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00cd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x002f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r10 = this;
                java.util.List<com.google.firebase.crashlytics.a.i.a.c> r0 = r10.f38638b     // Catch:{ Exception -> 0x00d8 }
                boolean r1 = r10.f38639c     // Catch:{ Exception -> 0x00d8 }
                com.google.firebase.crashlytics.a.b r2 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x00d8 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r4 = "Starting report processing in "
                r3.<init>(r4)     // Catch:{ Exception -> 0x00d8 }
                float r4 = r10.f38640d     // Catch:{ Exception -> 0x00d8 }
                r3.append(r4)     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r4 = " second(s)..."
                r3.append(r4)     // Catch:{ Exception -> 0x00d8 }
                r3 = 3
                r2.a(r3)     // Catch:{ Exception -> 0x00d8 }
                float r2 = r10.f38640d     // Catch:{ Exception -> 0x00d8 }
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 <= 0) goto L_0x0038
                float r2 = r10.f38640d     // Catch:{ InterruptedException -> 0x002f }
                r4 = 1148846080(0x447a0000, float:1000.0)
                float r2 = r2 * r4
                long r4 = (long) r2     // Catch:{ InterruptedException -> 0x002f }
                java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x002f }
                goto L_0x0038
            L_0x002f:
                java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x00d8 }
                r0.interrupt()     // Catch:{ Exception -> 0x00d8 }
                goto L_0x00e0
            L_0x0038:
                com.google.firebase.crashlytics.a.i.b r2 = com.google.firebase.crashlytics.a.i.b.this     // Catch:{ Exception -> 0x00d8 }
                com.google.firebase.crashlytics.a.i.b$a r2 = r2.f38631g     // Catch:{ Exception -> 0x00d8 }
                boolean r2 = r2.a()     // Catch:{ Exception -> 0x00d8 }
                if (r2 != 0) goto L_0x00e0
                r2 = 0
            L_0x0045:
                int r4 = r0.size()     // Catch:{ Exception -> 0x00d8 }
                if (r4 <= 0) goto L_0x00e0
                com.google.firebase.crashlytics.a.i.b r4 = com.google.firebase.crashlytics.a.i.b.this     // Catch:{ Exception -> 0x00d8 }
                com.google.firebase.crashlytics.a.i.b$a r4 = r4.f38631g     // Catch:{ Exception -> 0x00d8 }
                boolean r4 = r4.a()     // Catch:{ Exception -> 0x00d8 }
                if (r4 != 0) goto L_0x00e0
                com.google.firebase.crashlytics.a.b r4 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x00d8 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r6 = "Attempting to send "
                r5.<init>(r6)     // Catch:{ Exception -> 0x00d8 }
                int r6 = r0.size()     // Catch:{ Exception -> 0x00d8 }
                r5.append(r6)     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r6 = " report(s)"
                r5.append(r6)     // Catch:{ Exception -> 0x00d8 }
                r4.a(r3)     // Catch:{ Exception -> 0x00d8 }
                java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x00d8 }
                r4.<init>()     // Catch:{ Exception -> 0x00d8 }
                java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x00d8 }
            L_0x007a:
                boolean r5 = r0.hasNext()     // Catch:{ Exception -> 0x00d8 }
                if (r5 == 0) goto L_0x0092
                java.lang.Object r5 = r0.next()     // Catch:{ Exception -> 0x00d8 }
                com.google.firebase.crashlytics.a.i.a.c r5 = (com.google.firebase.crashlytics.a.i.a.c) r5     // Catch:{ Exception -> 0x00d8 }
                com.google.firebase.crashlytics.a.i.b r6 = com.google.firebase.crashlytics.a.i.b.this     // Catch:{ Exception -> 0x00d8 }
                boolean r6 = r6.a(r5, r1)     // Catch:{ Exception -> 0x00d8 }
                if (r6 != 0) goto L_0x007a
                r4.add(r5)     // Catch:{ Exception -> 0x00d8 }
                goto L_0x007a
            L_0x0092:
                int r0 = r4.size()     // Catch:{ Exception -> 0x00d8 }
                if (r0 <= 0) goto L_0x00d5
                short[] r0 = com.google.firebase.crashlytics.a.i.b.f38625a     // Catch:{ Exception -> 0x00d8 }
                int r5 = r2 + 1
                short[] r6 = com.google.firebase.crashlytics.a.i.b.f38625a     // Catch:{ Exception -> 0x00d8 }
                int r6 = r6.length     // Catch:{ Exception -> 0x00d8 }
                int r6 = r6 + -1
                int r2 = java.lang.Math.min(r2, r6)     // Catch:{ Exception -> 0x00d8 }
                short r0 = r0[r2]     // Catch:{ Exception -> 0x00d8 }
                long r6 = (long) r0     // Catch:{ Exception -> 0x00d8 }
                com.google.firebase.crashlytics.a.b r0 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ Exception -> 0x00d8 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r8 = "Report submission: scheduling delayed retry in "
                r2.<init>(r8)     // Catch:{ Exception -> 0x00d8 }
                r2.append(r6)     // Catch:{ Exception -> 0x00d8 }
                java.lang.String r8 = " seconds"
                r2.append(r8)     // Catch:{ Exception -> 0x00d8 }
                r0.a(r3)     // Catch:{ Exception -> 0x00d8 }
                r8 = 1000(0x3e8, double:4.94E-321)
                long r6 = r6 * r8
                java.lang.Thread.sleep(r6)     // Catch:{ InterruptedException -> 0x00cd }
                r0 = r4
                r2 = r5
                goto L_0x0045
            L_0x00cd:
                java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x00d8 }
                r0.interrupt()     // Catch:{ Exception -> 0x00d8 }
                goto L_0x00e0
            L_0x00d5:
                r0 = r4
                goto L_0x0045
            L_0x00d8:
                com.google.firebase.crashlytics.a.b r0 = com.google.firebase.crashlytics.a.b.a()
                r1 = 6
                r0.a(r1)
            L_0x00e0:
                com.google.firebase.crashlytics.a.i.b r0 = com.google.firebase.crashlytics.a.i.b.this
                java.lang.Thread unused = r0.f38632h = null
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.i.b.d.a():void");
        }
    }
}
