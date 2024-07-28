package net.one97.paytm.feed.utility;

import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

public final class p {
    private static final HashMap<String, p> q = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public String[] f35411a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f35412b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f35413c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f35414d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f35415e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f35416f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f35417g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f35418h;

    /* renamed from: i  reason: collision with root package name */
    public String[] f35419i;
    public String[] j;
    public String[] k;
    public String[] l;
    public String[] m;
    public String n;
    public String o;
    public String p;

    static {
        a(Locale.ROOT);
        a(Locale.US);
        a(Locale.getDefault());
    }

    private p() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r0 = new net.one97.paytm.feed.utility.p();
        r1 = r0.n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r1 == null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r0.n = r1.replace('v', 'z');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1 = r0.o;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r1 == null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r0.p = r1.replaceAll("\\.[#,]*", "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r1 = q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r2 = q.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r2 == null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        q.put(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.one97.paytm.feed.utility.p a(java.util.Locale r4) {
        /*
            if (r4 != 0) goto L_0x0006
            java.util.Locale r4 = java.util.Locale.getDefault()
        L_0x0006:
            java.lang.String r4 = r4.toString()
            java.util.HashMap<java.lang.String, net.one97.paytm.feed.utility.p> r0 = q
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, net.one97.paytm.feed.utility.p> r1 = q     // Catch:{ all -> 0x0054 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0054 }
            net.one97.paytm.feed.utility.p r1 = (net.one97.paytm.feed.utility.p) r1     // Catch:{ all -> 0x0054 }
            if (r1 == 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            return r1
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            net.one97.paytm.feed.utility.p r0 = new net.one97.paytm.feed.utility.p
            r0.<init>()
            java.lang.String r1 = r0.n
            if (r1 == 0) goto L_0x002d
            r2 = 118(0x76, float:1.65E-43)
            r3 = 122(0x7a, float:1.71E-43)
            java.lang.String r1 = r1.replace(r2, r3)
            r0.n = r1
        L_0x002d:
            java.lang.String r1 = r0.o
            if (r1 == 0) goto L_0x003b
            java.lang.String r2 = "\\.[#,]*"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replaceAll(r2, r3)
            r0.p = r1
        L_0x003b:
            java.util.HashMap<java.lang.String, net.one97.paytm.feed.utility.p> r1 = q
            monitor-enter(r1)
            java.util.HashMap<java.lang.String, net.one97.paytm.feed.utility.p> r2 = q     // Catch:{ all -> 0x0051 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x0051 }
            net.one97.paytm.feed.utility.p r2 = (net.one97.paytm.feed.utility.p) r2     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x004a
            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
            return r2
        L_0x004a:
            java.util.HashMap<java.lang.String, net.one97.paytm.feed.utility.p> r2 = q     // Catch:{ all -> 0x0051 }
            r2.put(r4, r0)     // Catch:{ all -> 0x0051 }
            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
            return r0
        L_0x0051:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
            throw r4
        L_0x0054:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.utility.p.a(java.util.Locale):net.one97.paytm.feed.utility.p");
    }

    public final String toString() {
        return Objects.toString(this);
    }
}
