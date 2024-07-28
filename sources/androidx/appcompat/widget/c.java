package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class c extends DataSetObservable {

    /* renamed from: a  reason: collision with root package name */
    static final String f1708a = c.class.getSimpleName();

    /* renamed from: g  reason: collision with root package name */
    private static final Object f1709g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private static final Map<String, c> f1710h = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Object f1711b;

    /* renamed from: c  reason: collision with root package name */
    final List<a> f1712c;

    /* renamed from: d  reason: collision with root package name */
    final Context f1713d;

    /* renamed from: e  reason: collision with root package name */
    final String f1714e;

    /* renamed from: f  reason: collision with root package name */
    boolean f1715f;

    /* renamed from: i  reason: collision with root package name */
    private final List<C0025c> f1716i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private d p;

    public interface b {
    }

    public interface d {
        boolean a();
    }

    public final int a() {
        int size;
        synchronized (this.f1711b) {
            d();
            size = this.f1712c.size();
        }
        return size;
    }

    public final ResolveInfo a(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.f1711b) {
            d();
            resolveInfo = this.f1712c.get(i2).f1717a;
        }
        return resolveInfo;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.f1711b) {
            d();
            List<a> list = this.f1712c;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2).f1717a == resolveInfo) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public final Intent b(int i2) {
        synchronized (this.f1711b) {
            if (this.j == null) {
                return null;
            }
            d();
            a aVar = this.f1712c.get(i2);
            ComponentName componentName = new ComponentName(aVar.f1717a.activityInfo.packageName, aVar.f1717a.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                new Intent(intent);
                if (this.p.a()) {
                    return null;
                }
            }
            a(new C0025c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo b() {
        synchronized (this.f1711b) {
            d();
            if (this.f1712c.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.f1712c.get(0).f1717a;
            return resolveInfo;
        }
    }

    private void e() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.n) {
            this.n = false;
            if (!TextUtils.isEmpty(this.f1714e)) {
                new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f1716i), this.f1714e});
            }
        }
    }

    public final int c() {
        int size;
        synchronized (this.f1711b) {
            d();
            size = this.f1716i.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        boolean g2 = g() | h();
        i();
        if (g2) {
            f();
            notifyChanged();
        }
    }

    private boolean f() {
        if (this.k == null || this.j == null || this.f1712c.isEmpty() || this.f1716i.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.f1716i);
        return true;
    }

    private boolean g() {
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.f1712c.clear();
        List<ResolveInfo> queryIntentActivities = this.f1713d.getPackageManager().queryIntentActivities(this.j, 0);
        int size = queryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1712c.add(new a(queryIntentActivities.get(i2)));
        }
        return true;
    }

    private boolean h() {
        if (!this.f1715f || !this.n || TextUtils.isEmpty(this.f1714e)) {
            return false;
        }
        this.f1715f = false;
        this.m = true;
        j();
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(C0025c cVar) {
        boolean add = this.f1716i.add(cVar);
        if (add) {
            this.n = true;
            i();
            e();
            f();
            notifyChanged();
        }
        return add;
    }

    private void i() {
        int size = this.f1716i.size() - this.l;
        if (size > 0) {
            this.n = true;
            for (int i2 = 0; i2 < size; i2++) {
                this.f1716i.remove(0);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    public static final class C0025c {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f1719a;

        /* renamed from: b  reason: collision with root package name */
        public final long f1720b;

        /* renamed from: c  reason: collision with root package name */
        public final float f1721c;

        public C0025c(String str, long j, float f2) {
            this(ComponentName.unflattenFromString(str), j, f2);
        }

        public C0025c(ComponentName componentName, long j, float f2) {
            this.f1719a = componentName;
            this.f1720b = j;
            this.f1721c = f2;
        }

        public final int hashCode() {
            ComponentName componentName = this.f1719a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.f1720b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.f1721c);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0025c cVar = (C0025c) obj;
            ComponentName componentName = this.f1719a;
            if (componentName == null) {
                if (cVar.f1719a != null) {
                    return false;
                }
            } else if (!componentName.equals(cVar.f1719a)) {
                return false;
            }
            return this.f1720b == cVar.f1720b && Float.floatToIntBits(this.f1721c) == Float.floatToIntBits(cVar.f1721c);
        }

        public final String toString() {
            return "[" + "; activity:" + this.f1719a + "; time:" + this.f1720b + "; weight:" + new BigDecimal((double) this.f1721c) + "]";
        }
    }

    public static final class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        public final ResolveInfo f1717a;

        /* renamed from: b  reason: collision with root package name */
        public float f1718b;

        public final /* synthetic */ int compareTo(Object obj) {
            return Float.floatToIntBits(((a) obj).f1718b) - Float.floatToIntBits(this.f1718b);
        }

        public a(ResolveInfo resolveInfo) {
            this.f1717a = resolveInfo;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f1718b) + 31;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f1718b) == Float.floatToIntBits(((a) obj).f1718b);
        }

        public final String toString() {
            return "[" + "resolveInfo:" + this.f1717a.toString() + "; weight:" + new BigDecimal((double) this.f1718b) + "]";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        new java.lang.StringBuilder("Error reading historical recrod file: ").append(r10.f1714e);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        new java.lang.StringBuilder("Error reading historical recrod file: ").append(r10.f1714e);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a0, code lost:
        if (r1 != null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a6, code lost:
        if (r1 != null) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ab, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:32:0x0086, B:38:0x0096] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0096 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x0086=Splitter:B:32:0x0086, B:38:0x0096=Splitter:B:38:0x0096} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j() {
        /*
            r10 = this;
            java.lang.String r0 = "Error reading historical recrod file: "
            android.content.Context r1 = r10.f1713d     // Catch:{ FileNotFoundException -> 0x00ac }
            java.lang.String r2 = r10.f1714e     // Catch:{ FileNotFoundException -> 0x00ac }
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ FileNotFoundException -> 0x00ac }
            org.xmlpull.v1.XmlPullParser r2 = android.util.Xml.newPullParser()     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            java.lang.String r3 = "UTF-8"
            r2.setInput(r1, r3)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            r3 = 0
        L_0x0014:
            r4 = 1
            if (r3 == r4) goto L_0x001f
            r5 = 2
            if (r3 == r5) goto L_0x001f
            int r3 = r2.next()     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            goto L_0x0014
        L_0x001f:
            java.lang.String r3 = "historical-records"
            java.lang.String r5 = r2.getName()     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            if (r3 == 0) goto L_0x007c
            java.util.List<androidx.appcompat.widget.c$c> r3 = r10.f1716i     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            r3.clear()     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
        L_0x0030:
            int r5 = r2.next()     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            if (r5 == r4) goto L_0x0076
            r6 = 3
            if (r5 == r6) goto L_0x0030
            r6 = 4
            if (r5 == r6) goto L_0x0030
            java.lang.String r5 = r2.getName()     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            java.lang.String r6 = "historical-record"
            boolean r5 = r6.equals(r5)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            if (r5 == 0) goto L_0x006e
            java.lang.String r5 = "activity"
            r6 = 0
            java.lang.String r5 = r2.getAttributeValue(r6, r5)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            java.lang.String r7 = "time"
            java.lang.String r7 = r2.getAttributeValue(r6, r7)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            long r7 = java.lang.Long.parseLong(r7)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            java.lang.String r9 = "weight"
            java.lang.String r6 = r2.getAttributeValue(r6, r9)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            androidx.appcompat.widget.c$c r9 = new androidx.appcompat.widget.c$c     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            r9.<init>((java.lang.String) r5, (long) r7, (float) r6)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            r3.add(r9)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            goto L_0x0030
        L_0x006e:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            java.lang.String r3 = "Share records file not well-formed."
            r2.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            throw r2     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
        L_0x0076:
            if (r1 == 0) goto L_0x00a5
            r1.close()     // Catch:{ IOException -> 0x007b }
        L_0x007b:
            return
        L_0x007c:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            java.lang.String r3 = "Share records file does not start with historical-records tag."
            r2.<init>(r3)     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
            throw r2     // Catch:{ XmlPullParserException -> 0x0096, IOException -> 0x0086 }
        L_0x0084:
            r0 = move-exception
            goto L_0x00a6
        L_0x0086:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r2.<init>(r0)     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = r10.f1714e     // Catch:{ all -> 0x0084 }
            r2.append(r0)     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x00a5
            r1.close()     // Catch:{ IOException -> 0x0095 }
        L_0x0095:
            return
        L_0x0096:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r2.<init>(r0)     // Catch:{ all -> 0x0084 }
            java.lang.String r0 = r10.f1714e     // Catch:{ all -> 0x0084 }
            r2.append(r0)     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x00a5
            r1.close()     // Catch:{ IOException -> 0x00a5 }
        L_0x00a5:
            return
        L_0x00a6:
            if (r1 == 0) goto L_0x00ab
            r1.close()     // Catch:{ IOException -> 0x00ab }
        L_0x00ab:
            throw r0
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c.j():void");
    }

    final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006d, code lost:
            if (r15 != null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0073, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            r0 = androidx.appcompat.widget.c.f1708a;
            new java.lang.StringBuilder("Error writing historical record file: ").append(r14.f1722a.f1714e);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0083, code lost:
            r14.f1722a.f1715f = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0087, code lost:
            if (r15 == null) goto L_0x00b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r0 = androidx.appcompat.widget.c.f1708a;
            new java.lang.StringBuilder("Error writing historical record file: ").append(r14.f1722a.f1714e);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0098, code lost:
            r14.f1722a.f1715f = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x009c, code lost:
            if (r15 == null) goto L_0x00b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            r0 = androidx.appcompat.widget.c.f1708a;
            new java.lang.StringBuilder("Error writing historical record file: ").append(r14.f1722a.f1714e);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ad, code lost:
            r14.f1722a.f1715f = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b1, code lost:
            if (r15 == null) goto L_0x00b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b5, code lost:
            r14.f1722a.f1715f = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b9, code lost:
            if (r15 != null) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00be, code lost:
            throw r0;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:14:0x0075, B:18:0x008a, B:22:0x009f] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x008a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x009f */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.c r7 = androidx.appcompat.widget.c.this     // Catch:{ FileNotFoundException -> 0x00bf }
                android.content.Context r7 = r7.f1713d     // Catch:{ FileNotFoundException -> 0x00bf }
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch:{ FileNotFoundException -> 0x00bf }
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                r7.startDocument(r8, r9)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                r7.startTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                int r8 = r4.size()     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                r9 = 0
            L_0x002f:
                if (r9 >= r8) goto L_0x0063
                java.lang.Object r10 = r4.remove(r3)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                androidx.appcompat.widget.c$c r10 = (androidx.appcompat.widget.c.C0025c) r10     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                r7.startTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.f1719a     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                java.lang.String r12 = r12.flattenToString()     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                java.lang.String r11 = "time"
                long r12 = r10.f1720b     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                java.lang.String r11 = "weight"
                float r10 = r10.f1721c     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                r7.attribute(r6, r11, r10)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                r7.endTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                int r9 = r9 + 1
                goto L_0x002f
            L_0x0063:
                r7.endTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                r7.endDocument()     // Catch:{ IllegalArgumentException -> 0x009f, IllegalStateException -> 0x008a, IOException -> 0x0075 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.f1715f = r5
                if (r15 == 0) goto L_0x00b4
            L_0x006f:
                r15.close()     // Catch:{ IOException -> 0x00b4 }
                goto L_0x00b4
            L_0x0073:
                r0 = move-exception
                goto L_0x00b5
            L_0x0075:
                java.lang.String r0 = androidx.appcompat.widget.c.f1708a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r0.<init>(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r1 = androidx.appcompat.widget.c.this     // Catch:{ all -> 0x0073 }
                java.lang.String r1 = r1.f1714e     // Catch:{ all -> 0x0073 }
                r0.append(r1)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.f1715f = r5
                if (r15 == 0) goto L_0x00b4
                goto L_0x006f
            L_0x008a:
                java.lang.String r0 = androidx.appcompat.widget.c.f1708a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r0.<init>(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r1 = androidx.appcompat.widget.c.this     // Catch:{ all -> 0x0073 }
                java.lang.String r1 = r1.f1714e     // Catch:{ all -> 0x0073 }
                r0.append(r1)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.f1715f = r5
                if (r15 == 0) goto L_0x00b4
                goto L_0x006f
            L_0x009f:
                java.lang.String r0 = androidx.appcompat.widget.c.f1708a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r0.<init>(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r1 = androidx.appcompat.widget.c.this     // Catch:{ all -> 0x0073 }
                java.lang.String r1 = r1.f1714e     // Catch:{ all -> 0x0073 }
                r0.append(r1)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.f1715f = r5
                if (r15 == 0) goto L_0x00b4
                goto L_0x006f
            L_0x00b4:
                return r6
            L_0x00b5:
                androidx.appcompat.widget.c r1 = androidx.appcompat.widget.c.this
                r1.f1715f = r5
                if (r15 == 0) goto L_0x00be
                r15.close()     // Catch:{ IOException -> 0x00be }
            L_0x00be:
                throw r0
            L_0x00bf:
                java.lang.String r15 = androidx.appcompat.widget.c.f1708a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c.e.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }
}
