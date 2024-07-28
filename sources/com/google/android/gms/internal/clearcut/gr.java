package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class gr {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f9406a = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f9407b = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: c  reason: collision with root package name */
    private static final Uri f9408c = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: d  reason: collision with root package name */
    private static final Uri f9409d = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f9410e = new AtomicBoolean();

    /* renamed from: f  reason: collision with root package name */
    private static HashMap<String, String> f9411f;

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, Boolean> f9412g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap<String, Integer> f9413h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static final HashMap<String, Long> f9414i = new HashMap<>();
    private static final HashMap<String, Float> j = new HashMap<>();
    private static Object k;
    private static boolean l;
    private static String[] m = new String[0];

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T a(java.util.HashMap<java.lang.String, T> r2, java.lang.String r3, T r4) {
        /*
            java.lang.Class<com.google.android.gms.internal.clearcut.gr> r0 = com.google.android.gms.internal.clearcut.gr.class
            monitor-enter(r0)
            boolean r1 = r2.containsKey(r3)     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0013
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0016 }
            if (r2 == 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r2 = r4
        L_0x0011:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r2
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            r2 = 0
            return r2
        L_0x0016:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.gr.a(java.util.HashMap, java.lang.String, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        return r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
        r14 = r14.query(f9408c, (java.lang.String[]) null, (java.lang.String) null, new java.lang.String[]{r15}, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r14 == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0078, code lost:
        if (r14.moveToFirst() != false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007b, code lost:
        r0 = r14.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007f, code lost:
        if (r0 == null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0085, code lost:
        if (r0.equals((java.lang.Object) null) == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0087, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0088, code lost:
        a(r1, r15, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
        if (r0 == null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008e, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0094, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        a(r1, r15, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0098, code lost:
        if (r14 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009a, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009d, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009f, code lost:
        if (r14 != null) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a1, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a4, code lost:
        throw r15;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.ContentResolver r14, java.lang.String r15) {
        /*
            java.lang.Class<com.google.android.gms.internal.clearcut.gr> r0 = com.google.android.gms.internal.clearcut.gr.class
            monitor-enter(r0)
            a(r14)     // Catch:{ all -> 0x00a5 }
            java.lang.Object r1 = k     // Catch:{ all -> 0x00a5 }
            java.util.HashMap<java.lang.String, java.lang.String> r2 = f9411f     // Catch:{ all -> 0x00a5 }
            boolean r2 = r2.containsKey(r15)     // Catch:{ all -> 0x00a5 }
            r3 = 0
            if (r2 == 0) goto L_0x001f
            java.util.HashMap<java.lang.String, java.lang.String> r14 = f9411f     // Catch:{ all -> 0x00a5 }
            java.lang.Object r14 = r14.get(r15)     // Catch:{ all -> 0x00a5 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x00a5 }
            if (r14 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r14 = r3
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
            return r14
        L_0x001f:
            java.lang.String[] r2 = m     // Catch:{ all -> 0x00a5 }
            int r4 = r2.length     // Catch:{ all -> 0x00a5 }
            r5 = 0
            r6 = 0
        L_0x0024:
            r7 = 1
            if (r6 >= r4) goto L_0x0063
            r8 = r2[r6]     // Catch:{ all -> 0x00a5 }
            boolean r8 = r15.startsWith(r8)     // Catch:{ all -> 0x00a5 }
            if (r8 == 0) goto L_0x0060
            boolean r1 = l     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x003b
            java.util.HashMap<java.lang.String, java.lang.String> r1 = f9411f     // Catch:{ all -> 0x00a5 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x005e
        L_0x003b:
            java.lang.String[] r1 = m     // Catch:{ all -> 0x00a5 }
            java.util.HashMap<java.lang.String, java.lang.String> r2 = f9411f     // Catch:{ all -> 0x00a5 }
            java.util.Map r14 = a((android.content.ContentResolver) r14, (java.lang.String[]) r1)     // Catch:{ all -> 0x00a5 }
            r2.putAll(r14)     // Catch:{ all -> 0x00a5 }
            l = r7     // Catch:{ all -> 0x00a5 }
            java.util.HashMap<java.lang.String, java.lang.String> r14 = f9411f     // Catch:{ all -> 0x00a5 }
            boolean r14 = r14.containsKey(r15)     // Catch:{ all -> 0x00a5 }
            if (r14 == 0) goto L_0x005e
            java.util.HashMap<java.lang.String, java.lang.String> r14 = f9411f     // Catch:{ all -> 0x00a5 }
            java.lang.Object r14 = r14.get(r15)     // Catch:{ all -> 0x00a5 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x00a5 }
            if (r14 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r14 = r3
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
            return r14
        L_0x005e:
            monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
            return r3
        L_0x0060:
            int r6 = r6 + 1
            goto L_0x0024
        L_0x0063:
            monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
            android.net.Uri r9 = f9408c
            r10 = 0
            r11 = 0
            java.lang.String[] r12 = new java.lang.String[r7]
            r12[r5] = r15
            r13 = 0
            r8 = r14
            android.database.Cursor r14 = r8.query(r9, r10, r11, r12, r13)
            if (r14 == 0) goto L_0x0095
            boolean r0 = r14.moveToFirst()     // Catch:{ all -> 0x009e }
            if (r0 != 0) goto L_0x007b
            goto L_0x0095
        L_0x007b:
            java.lang.String r0 = r14.getString(r7)     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0088
            boolean r2 = r0.equals(r3)     // Catch:{ all -> 0x009e }
            if (r2 == 0) goto L_0x0088
            r0 = r3
        L_0x0088:
            a((java.lang.Object) r1, (java.lang.String) r15, (java.lang.String) r0)     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x008e
            goto L_0x008f
        L_0x008e:
            r0 = r3
        L_0x008f:
            if (r14 == 0) goto L_0x0094
            r14.close()
        L_0x0094:
            return r0
        L_0x0095:
            a((java.lang.Object) r1, (java.lang.String) r15, (java.lang.String) r3)     // Catch:{ all -> 0x009e }
            if (r14 == 0) goto L_0x009d
            r14.close()
        L_0x009d:
            return r3
        L_0x009e:
            r15 = move-exception
            if (r14 == 0) goto L_0x00a4
            r14.close()
        L_0x00a4:
            throw r15
        L_0x00a5:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a5 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.gr.a(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    private static Map<String, String> a(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f9409d, (String[]) null, (String) null, strArr, (String) null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void a(ContentResolver contentResolver) {
        if (f9411f == null) {
            f9410e.set(false);
            f9411f = new HashMap<>();
            k = new Object();
            l = false;
            contentResolver.registerContentObserver(f9408c, true, new gs());
        } else if (f9410e.getAndSet(false)) {
            f9411f.clear();
            f9412g.clear();
            f9413h.clear();
            f9414i.clear();
            j.clear();
            k = new Object();
            l = false;
        }
    }

    private static void a(Object obj, String str, String str2) {
        synchronized (gr.class) {
            if (obj == k) {
                f9411f.put(str, str2);
            }
        }
    }

    private static <T> void a(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (gr.class) {
            if (obj == k) {
                hashMap.put(str, t);
                f9411f.remove(str);
            }
        }
    }

    public static boolean a(ContentResolver contentResolver, String str, boolean z) {
        Object b2 = b(contentResolver);
        Boolean bool = (Boolean) a(f9412g, str, Boolean.valueOf(z));
        if (bool != null) {
            return bool.booleanValue();
        }
        String a2 = a(contentResolver, str);
        if (a2 != null && !a2.equals("")) {
            if (f9406a.matcher(a2).matches()) {
                z = true;
                bool = Boolean.TRUE;
            } else if (f9407b.matcher(a2).matches()) {
                z = false;
                bool = Boolean.FALSE;
            } else {
                StringBuilder sb = new StringBuilder("attempt to read gservices key ");
                sb.append(str);
                sb.append(" (value \"");
                sb.append(a2);
                sb.append("\") as boolean");
            }
        }
        a(b2, f9412g, str, bool);
        return z;
    }

    public static long b(ContentResolver contentResolver, String str) {
        Object b2 = b(contentResolver);
        long j2 = 0;
        Long l2 = (Long) a(f9414i, str, 0L);
        if (l2 != null) {
            return l2.longValue();
        }
        String a2 = a(contentResolver, str);
        if (a2 != null) {
            try {
                long parseLong = Long.parseLong(a2);
                l2 = Long.valueOf(parseLong);
                j2 = parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        a(b2, f9414i, str, l2);
        return j2;
    }

    private static Object b(ContentResolver contentResolver) {
        Object obj;
        synchronized (gr.class) {
            a(contentResolver);
            obj = k;
        }
        return obj;
    }
}
