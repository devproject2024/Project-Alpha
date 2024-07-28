package com.ta.utdid2.b.a;

import com.ta.utdid2.b.a.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public final class d {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Object f16137c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Object f16138a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private File f16139b;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<File, a> f16140d = new HashMap<>();

    public d(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.f16139b = new File(str);
    }

    private File b() {
        File file;
        synchronized (this.f16138a) {
            file = this.f16139b;
        }
        return file;
    }

    /* access modifiers changed from: private */
    public static File b(File file) {
        return new File(String.valueOf(file.getPath()) + ".bak");
    }

    static final class a implements b {

        /* renamed from: f  reason: collision with root package name */
        private static final Object f16141f = new Object();
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public Map f16142a;

        /* renamed from: b  reason: collision with root package name */
        boolean f16143b = false;

        /* renamed from: c  reason: collision with root package name */
        private final File f16144c;

        /* renamed from: d  reason: collision with root package name */
        private final File f16145d;

        /* renamed from: e  reason: collision with root package name */
        private final int f16146e;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public WeakHashMap<Object, Object> f16147g;

        a(File file, Map map) {
            this.f16144c = file;
            this.f16145d = d.b(file);
            this.f16146e = 0;
            this.f16142a = map == null ? new HashMap() : map;
            this.f16147g = new WeakHashMap<>();
        }

        public final boolean a() {
            File file = this.f16144c;
            return file != null && new File(file.getAbsolutePath()).exists();
        }

        public final boolean d() {
            boolean z;
            synchronized (this) {
                z = this.f16143b;
            }
            return z;
        }

        public final Map<String, ?> b() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f16142a);
            }
            return hashMap;
        }

        public final String a(String str, String str2) {
            String str3;
            synchronized (this) {
                str3 = (String) this.f16142a.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            }
            return str3;
        }

        public final long a(String str) {
            long longValue;
            synchronized (this) {
                Long l = (Long) this.f16142a.get(str);
                longValue = l != null ? l.longValue() : 0;
            }
            return longValue;
        }

        /* renamed from: com.ta.utdid2.b.a.d$a$a  reason: collision with other inner class name */
        public final class C0219a implements b.a {

            /* renamed from: b  reason: collision with root package name */
            private final Map<String, Object> f16149b = new HashMap();

            /* renamed from: c  reason: collision with root package name */
            private boolean f16150c = false;

            public C0219a() {
            }

            public final b.a a(String str, String str2) {
                synchronized (this) {
                    this.f16149b.put(str, str2);
                }
                return this;
            }

            public final b.a a(String str, int i2) {
                synchronized (this) {
                    this.f16149b.put(str, Integer.valueOf(i2));
                }
                return this;
            }

            public final b.a a(String str, long j) {
                synchronized (this) {
                    this.f16149b.put(str, Long.valueOf(j));
                }
                return this;
            }

            public final b.a a(String str, float f2) {
                synchronized (this) {
                    this.f16149b.put(str, Float.valueOf(f2));
                }
                return this;
            }

            public final b.a a(String str, boolean z) {
                synchronized (this) {
                    this.f16149b.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            public final b.a a(String str) {
                synchronized (this) {
                    this.f16149b.put(str, this);
                }
                return this;
            }

            public final b.a a() {
                synchronized (this) {
                    this.f16150c = true;
                }
                return this;
            }

            public final boolean b() {
                boolean z;
                ArrayList arrayList;
                HashSet hashSet;
                boolean c2;
                synchronized (d.f16137c) {
                    z = a.this.f16147g.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f16147g.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.f16150c) {
                            a.this.f16142a.clear();
                            this.f16150c = false;
                        }
                        for (Map.Entry next : this.f16149b.entrySet()) {
                            String str = (String) next.getKey();
                            Object value = next.getValue();
                            if (value == this) {
                                a.this.f16142a.remove(str);
                            } else {
                                a.this.f16142a.put(str, value);
                            }
                            if (z) {
                                arrayList.add(str);
                            }
                        }
                        this.f16149b.clear();
                    }
                    c2 = a.this.e();
                    if (c2) {
                        a aVar = a.this;
                        synchronized (aVar) {
                            aVar.f16143b = true;
                        }
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        arrayList.get(size);
                        Iterator it2 = hashSet.iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                    }
                }
                return c2;
            }
        }

        public final b.a c() {
            return new C0219a();
        }

        private static FileOutputStream a(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
        }

        /* access modifiers changed from: private */
        public boolean e() {
            if (this.f16144c.exists()) {
                if (this.f16145d.exists()) {
                    this.f16144c.delete();
                } else if (!this.f16144c.renameTo(this.f16145d)) {
                    return false;
                }
            }
            try {
                FileOutputStream a2 = a(this.f16144c);
                if (a2 == null) {
                    return false;
                }
                Map map = this.f16142a;
                a aVar = new a();
                aVar.setOutput(a2, "utf-8");
                aVar.startDocument((String) null, Boolean.TRUE);
                aVar.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                e.a(map, (String) null, (XmlSerializer) aVar);
                aVar.endDocument();
                a2.close();
                this.f16145d.delete();
                return true;
            } catch (IOException | XmlPullParserException unused) {
                if (this.f16144c.exists()) {
                    this.f16144c.delete();
                }
                return false;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v40 */
    /* JADX WARNING: type inference failed for: r0v41 */
    /* JADX WARNING: type inference failed for: r0v43 */
    /* JADX WARNING: type inference failed for: r0v45 */
    /* JADX WARNING: type inference failed for: r0v46 */
    /* JADX WARNING: type inference failed for: r0v48 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0109 A[SYNTHETIC, Splitter:B:95:0x0109] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:58:0x00b7=Splitter:B:58:0x00b7, B:51:0x00aa=Splitter:B:51:0x00aa, B:97:0x010c=Splitter:B:97:0x010c} */
    public final com.ta.utdid2.b.a.b a(java.lang.String r10) {
        /*
            r9 = this;
            java.io.File r0 = r9.b()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r1.<init>(r10)
            java.lang.String r10 = ".xml"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            char r1 = java.io.File.separatorChar
            int r1 = r10.indexOf(r1)
            if (r1 >= 0) goto L_0x013f
            java.io.File r1 = new java.io.File
            r1.<init>(r0, r10)
            java.lang.Object r0 = f16137c
            monitor-enter(r0)
            java.util.HashMap<java.io.File, com.ta.utdid2.b.a.d$a> r10 = r9.f16140d     // Catch:{ all -> 0x013c }
            java.lang.Object r10 = r10.get(r1)     // Catch:{ all -> 0x013c }
            com.ta.utdid2.b.a.d$a r10 = (com.ta.utdid2.b.a.d.a) r10     // Catch:{ all -> 0x013c }
            if (r10 == 0) goto L_0x0038
            boolean r2 = r10.d()     // Catch:{ all -> 0x013c }
            if (r2 != 0) goto L_0x0038
            monitor-exit(r0)     // Catch:{ all -> 0x013c }
            return r10
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x013c }
            java.io.File r0 = b(r1)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x0049
            r1.delete()
            r0.renameTo(r1)
        L_0x0049:
            boolean r0 = r1.exists()
            if (r0 == 0) goto L_0x0052
            r1.canRead()
        L_0x0052:
            boolean r0 = r1.exists()
            r2 = 0
            if (r0 == 0) goto L_0x0113
            boolean r0 = r1.canRead()
            if (r0 == 0) goto L_0x0113
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ XmlPullParserException -> 0x00c6, FileNotFoundException -> 0x00bd, IOException -> 0x00b4, Exception -> 0x00a7 }
            r0.<init>(r1)     // Catch:{ XmlPullParserException -> 0x00c6, FileNotFoundException -> 0x00bd, IOException -> 0x00b4, Exception -> 0x00a7 }
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch:{ XmlPullParserException -> 0x00c7, FileNotFoundException -> 0x009e, IOException -> 0x0099, Exception -> 0x0094, all -> 0x0091 }
            r3.setInput(r0, r2)     // Catch:{ XmlPullParserException -> 0x00c7, FileNotFoundException -> 0x009e, IOException -> 0x0099, Exception -> 0x0094, all -> 0x0091 }
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ XmlPullParserException -> 0x00c7, FileNotFoundException -> 0x009e, IOException -> 0x0099, Exception -> 0x0094, all -> 0x0091 }
            java.lang.Object r3 = com.ta.utdid2.b.a.e.a((org.xmlpull.v1.XmlPullParser) r3, (java.lang.String[]) r4)     // Catch:{ XmlPullParserException -> 0x00c7, FileNotFoundException -> 0x009e, IOException -> 0x0099, Exception -> 0x0094, all -> 0x0091 }
            java.util.HashMap r3 = (java.util.HashMap) r3     // Catch:{ XmlPullParserException -> 0x00c7, FileNotFoundException -> 0x009e, IOException -> 0x0099, Exception -> 0x0094, all -> 0x0091 }
            r0.close()     // Catch:{ XmlPullParserException -> 0x008f, FileNotFoundException -> 0x0089, IOException -> 0x0083, Exception -> 0x007d, all -> 0x0091 }
            r0.close()     // Catch:{ all -> 0x007a }
        L_0x007a:
            r0 = r3
            goto L_0x0114
        L_0x007d:
            r2 = move-exception
            r8 = r2
            r2 = r0
            r0 = r3
            r3 = r8
            goto L_0x00aa
        L_0x0083:
            r2 = move-exception
            r8 = r2
            r2 = r0
            r0 = r3
            r3 = r8
            goto L_0x00b7
        L_0x0089:
            r2 = move-exception
            r8 = r2
            r2 = r0
            r0 = r3
            r3 = r8
            goto L_0x00c0
        L_0x008f:
            r2 = r3
            goto L_0x00c7
        L_0x0091:
            r10 = move-exception
            goto L_0x010d
        L_0x0094:
            r3 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
            goto L_0x00aa
        L_0x0099:
            r3 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
            goto L_0x00b7
        L_0x009e:
            r3 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
            goto L_0x00c0
        L_0x00a3:
            r10 = move-exception
            r0 = r2
            goto L_0x010d
        L_0x00a7:
            r0 = move-exception
            r3 = r0
            r0 = r2
        L_0x00aa:
            r3.printStackTrace()     // Catch:{ all -> 0x00a3 }
            if (r2 == 0) goto L_0x0114
        L_0x00af:
            r2.close()     // Catch:{ all -> 0x0114 }
            goto L_0x0114
        L_0x00b4:
            r0 = move-exception
            r3 = r0
            r0 = r2
        L_0x00b7:
            r3.printStackTrace()     // Catch:{ all -> 0x00a3 }
            if (r2 == 0) goto L_0x0114
            goto L_0x00af
        L_0x00bd:
            r0 = move-exception
            r3 = r0
            r0 = r2
        L_0x00c0:
            r3.printStackTrace()     // Catch:{ all -> 0x00a3 }
            if (r2 == 0) goto L_0x0114
            goto L_0x00af
        L_0x00c6:
            r0 = r2
        L_0x00c7:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00f5, IOException -> 0x00eb, all -> 0x00e8 }
            r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x00f5, IOException -> 0x00eb, all -> 0x00e8 }
            int r0 = r3.available()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e4 }
            byte[] r0 = new byte[r0]     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e4 }
            r3.read(r0)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e4 }
            java.lang.String r4 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e4 }
            r5 = 0
            int r6 = r0.length     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e4 }
            java.lang.String r7 = "UTF-8"
            r4.<init>(r0, r5, r6, r7)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e4 }
        L_0x00de:
            r3.close()     // Catch:{ all -> 0x00e2 }
            goto L_0x00ff
        L_0x00e2:
            goto L_0x00ff
        L_0x00e4:
            r0 = move-exception
            goto L_0x00ef
        L_0x00e6:
            r0 = move-exception
            goto L_0x00f9
        L_0x00e8:
            r10 = move-exception
            r2 = r0
            goto L_0x0107
        L_0x00eb:
            r3 = move-exception
            r8 = r3
            r3 = r0
            r0 = r8
        L_0x00ef:
            r0.printStackTrace()     // Catch:{ all -> 0x0105 }
            if (r3 == 0) goto L_0x00ff
            goto L_0x00de
        L_0x00f5:
            r3 = move-exception
            r8 = r3
            r3 = r0
            r0 = r8
        L_0x00f9:
            r0.printStackTrace()     // Catch:{ all -> 0x0105 }
            if (r3 == 0) goto L_0x00ff
            goto L_0x00de
        L_0x00ff:
            if (r3 == 0) goto L_0x0113
            r3.close()     // Catch:{ all -> 0x0113 }
            goto L_0x0113
        L_0x0105:
            r10 = move-exception
            r2 = r3
        L_0x0107:
            if (r2 == 0) goto L_0x010c
            r2.close()     // Catch:{ all -> 0x010c }
        L_0x010c:
            throw r10     // Catch:{ all -> 0x00a3 }
        L_0x010d:
            if (r0 == 0) goto L_0x0112
            r0.close()     // Catch:{ all -> 0x0112 }
        L_0x0112:
            throw r10
        L_0x0113:
            r0 = r2
        L_0x0114:
            java.lang.Object r2 = f16137c
            monitor-enter(r2)
            if (r10 == 0) goto L_0x0123
            if (r0 == 0) goto L_0x0137
            monitor-enter(r10)     // Catch:{ all -> 0x0139 }
            r10.f16142a = r0     // Catch:{ all -> 0x0120 }
            monitor-exit(r10)     // Catch:{ all -> 0x0120 }
            goto L_0x0137
        L_0x0120:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0120 }
            throw r0     // Catch:{ all -> 0x0139 }
        L_0x0123:
            java.util.HashMap<java.io.File, com.ta.utdid2.b.a.d$a> r10 = r9.f16140d     // Catch:{ all -> 0x0139 }
            java.lang.Object r10 = r10.get(r1)     // Catch:{ all -> 0x0139 }
            com.ta.utdid2.b.a.d$a r10 = (com.ta.utdid2.b.a.d.a) r10     // Catch:{ all -> 0x0139 }
            if (r10 != 0) goto L_0x0137
            com.ta.utdid2.b.a.d$a r10 = new com.ta.utdid2.b.a.d$a     // Catch:{ all -> 0x0139 }
            r10.<init>(r1, r0)     // Catch:{ all -> 0x0139 }
            java.util.HashMap<java.io.File, com.ta.utdid2.b.a.d$a> r0 = r9.f16140d     // Catch:{ all -> 0x0139 }
            r0.put(r1, r10)     // Catch:{ all -> 0x0139 }
        L_0x0137:
            monitor-exit(r2)     // Catch:{ all -> 0x0139 }
            return r10
        L_0x0139:
            r10 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0139 }
            throw r10
        L_0x013c:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x013c }
            throw r10
        L_0x013f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "File "
            r1.<init>(r2)
            r1.append(r10)
            java.lang.String r10 = " contains a path separator"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.d.a(java.lang.String):com.ta.utdid2.b.a.b");
    }
}
