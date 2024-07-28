package androidx.room.b;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f4388a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a> f4389b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<b> f4390c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<d> f4391d;

    public f(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        Set<d> set3;
        this.f4388a = str;
        this.f4389b = Collections.unmodifiableMap(map);
        this.f4390c = Collections.unmodifiableSet(set);
        if (set2 == null) {
            set3 = null;
        } else {
            set3 = Collections.unmodifiableSet(set2);
        }
        this.f4391d = set3;
    }

    public final boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f4388a;
        if (str == null ? fVar.f4388a != null : !str.equals(fVar.f4388a)) {
            return false;
        }
        Map<String, a> map = this.f4389b;
        if (map == null ? fVar.f4389b != null : !map.equals(fVar.f4389b)) {
            return false;
        }
        Set<b> set2 = this.f4390c;
        if (set2 == null ? fVar.f4390c != null : !set2.equals(fVar.f4390c)) {
            return false;
        }
        Set<d> set3 = this.f4391d;
        if (set3 == null || (set = fVar.f4391d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public final int hashCode() {
        String str = this.f4388a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f4389b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f4390c;
        if (set != null) {
            i2 = set.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "TableInfo{name='" + this.f4388a + '\'' + ", columns=" + this.f4389b + ", foreignKeys=" + this.f4390c + ", indices=" + this.f4391d + '}';
    }

    public static f a(androidx.sqlite.db.b bVar, String str) {
        return new f(str, c(bVar, str), b(bVar, str), d(bVar, str));
    }

    private static Set<b> b(androidx.sqlite.db.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor b2 = bVar.b("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("id");
            int columnIndex2 = b2.getColumnIndex("seq");
            int columnIndex3 = b2.getColumnIndex("table");
            int columnIndex4 = b2.getColumnIndex("on_delete");
            int columnIndex5 = b2.getColumnIndex("on_update");
            List<c> a2 = a(b2);
            int count = b2.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                b2.moveToPosition(i2);
                if (b2.getInt(columnIndex2) == 0) {
                    int i3 = b2.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c next : a2) {
                        if (next.f4404a == i3) {
                            arrayList.add(next.f4406c);
                            arrayList2.add(next.f4407d);
                        }
                    }
                    hashSet.add(new b(b2.getString(columnIndex3), b2.getString(columnIndex4), b2.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            b2.close();
        }
    }

    private static List<c> a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < count; i2++) {
            cursor.moveToPosition(i2);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Map<String, a> c(androidx.sqlite.db.b bVar, String str) {
        Cursor b2 = bVar.b("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (b2.getColumnCount() > 0) {
                int columnIndex = b2.getColumnIndex("name");
                int columnIndex2 = b2.getColumnIndex("type");
                int columnIndex3 = b2.getColumnIndex("notnull");
                int columnIndex4 = b2.getColumnIndex("pk");
                int columnIndex5 = b2.getColumnIndex("dflt_value");
                while (b2.moveToNext()) {
                    String string = b2.getString(columnIndex);
                    hashMap.put(string, new a(string, b2.getString(columnIndex2), b2.getInt(columnIndex3) != 0, b2.getInt(columnIndex4), b2.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            b2.close();
        }
    }

    private static Set<d> d(androidx.sqlite.db.b bVar, String str) {
        Cursor b2 = bVar.b("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("name");
            int columnIndex2 = b2.getColumnIndex("origin");
            int columnIndex3 = b2.getColumnIndex("unique");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    HashSet hashSet = new HashSet();
                    while (b2.moveToNext()) {
                        if ("c".equals(b2.getString(columnIndex2))) {
                            String string = b2.getString(columnIndex);
                            boolean z = true;
                            if (b2.getInt(columnIndex3) != 1) {
                                z = false;
                            }
                            d a2 = a(bVar, string, z);
                            if (a2 == null) {
                                b2.close();
                                return null;
                            }
                            hashSet.add(a2);
                        }
                    }
                    b2.close();
                    return hashSet;
                }
            }
            return null;
        } finally {
            b2.close();
        }
    }

    /* JADX INFO: finally extract failed */
    private static d a(androidx.sqlite.db.b bVar, String str, boolean z) {
        Cursor b2 = bVar.b("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("seqno");
            int columnIndex2 = b2.getColumnIndex("cid");
            int columnIndex3 = b2.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (b2.moveToNext()) {
                        if (b2.getInt(columnIndex2) >= 0) {
                            int i2 = b2.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i2), b2.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    d dVar = new d(str, z, arrayList);
                    b2.close();
                    return dVar;
                }
            }
            b2.close();
            return null;
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f4392a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4393b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4394c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f4395d;

        /* renamed from: e  reason: collision with root package name */
        public final int f4396e;

        /* renamed from: f  reason: collision with root package name */
        public final String f4397f;

        /* renamed from: g  reason: collision with root package name */
        private final int f4398g;

        @Deprecated
        public a(String str, String str2, boolean z, int i2) {
            this(str, str2, z, i2, (String) null, 0);
        }

        public a(String str, String str2, boolean z, int i2, String str3, int i3) {
            this.f4392a = str;
            this.f4393b = str2;
            this.f4395d = z;
            this.f4396e = i2;
            int i4 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    i4 = 3;
                } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    i4 = 2;
                } else if (!upperCase.contains("BLOB")) {
                    i4 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                }
            }
            this.f4394c = i4;
            this.f4397f = str3;
            this.f4398g = i3;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0069, code lost:
            r1 = r5.f4397f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r0 = 1
                if (r5 != r6) goto L_0x0004
                return r0
            L_0x0004:
                boolean r1 = r6 instanceof androidx.room.b.f.a
                r2 = 0
                if (r1 != 0) goto L_0x000a
                return r2
            L_0x000a:
                androidx.room.b.f$a r6 = (androidx.room.b.f.a) r6
                int r1 = android.os.Build.VERSION.SDK_INT
                r3 = 20
                if (r1 < r3) goto L_0x0019
                int r1 = r5.f4396e
                int r3 = r6.f4396e
                if (r1 == r3) goto L_0x0024
                return r2
            L_0x0019:
                boolean r1 = r5.a()
                boolean r3 = r6.a()
                if (r1 == r3) goto L_0x0024
                return r2
            L_0x0024:
                java.lang.String r1 = r5.f4392a
                java.lang.String r3 = r6.f4392a
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L_0x002f
                return r2
            L_0x002f:
                boolean r1 = r5.f4395d
                boolean r3 = r6.f4395d
                if (r1 == r3) goto L_0x0036
                return r2
            L_0x0036:
                int r1 = r5.f4398g
                r3 = 2
                if (r1 != r0) goto L_0x004c
                int r1 = r6.f4398g
                if (r1 != r3) goto L_0x004c
                java.lang.String r1 = r5.f4397f
                if (r1 == 0) goto L_0x004c
                java.lang.String r4 = r6.f4397f
                boolean r1 = r1.equals(r4)
                if (r1 != 0) goto L_0x004c
                return r2
            L_0x004c:
                int r1 = r5.f4398g
                if (r1 != r3) goto L_0x0061
                int r1 = r6.f4398g
                if (r1 != r0) goto L_0x0061
                java.lang.String r1 = r6.f4397f
                if (r1 == 0) goto L_0x0061
                java.lang.String r3 = r5.f4397f
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L_0x0061
                return r2
            L_0x0061:
                int r1 = r5.f4398g
                if (r1 == 0) goto L_0x007b
                int r3 = r6.f4398g
                if (r1 != r3) goto L_0x007b
                java.lang.String r1 = r5.f4397f
                if (r1 == 0) goto L_0x0076
                java.lang.String r3 = r6.f4397f
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L_0x007b
                goto L_0x007a
            L_0x0076:
                java.lang.String r1 = r6.f4397f
                if (r1 == 0) goto L_0x007b
            L_0x007a:
                return r2
            L_0x007b:
                int r1 = r5.f4394c
                int r6 = r6.f4394c
                if (r1 != r6) goto L_0x0082
                return r0
            L_0x0082:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.b.f.a.equals(java.lang.Object):boolean");
        }

        private boolean a() {
            return this.f4396e > 0;
        }

        public final int hashCode() {
            return (((((this.f4392a.hashCode() * 31) + this.f4394c) * 31) + (this.f4395d ? 1231 : 1237)) * 31) + this.f4396e;
        }

        public final String toString() {
            return "Column{name='" + this.f4392a + '\'' + ", type='" + this.f4393b + '\'' + ", affinity='" + this.f4394c + '\'' + ", notNull=" + this.f4395d + ", primaryKeyPosition=" + this.f4396e + ", defaultValue='" + this.f4397f + '\'' + '}';
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f4399a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4400b;

        /* renamed from: c  reason: collision with root package name */
        public final String f4401c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f4402d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f4403e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f4399a = str;
            this.f4400b = str2;
            this.f4401c = str3;
            this.f4402d = Collections.unmodifiableList(list);
            this.f4403e = Collections.unmodifiableList(list2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f4399a.equals(bVar.f4399a) && this.f4400b.equals(bVar.f4400b) && this.f4401c.equals(bVar.f4401c) && this.f4402d.equals(bVar.f4402d)) {
                return this.f4403e.equals(bVar.f4403e);
            }
            return false;
        }

        public final int hashCode() {
            return (((((((this.f4399a.hashCode() * 31) + this.f4400b.hashCode()) * 31) + this.f4401c.hashCode()) * 31) + this.f4402d.hashCode()) * 31) + this.f4403e.hashCode();
        }

        public final String toString() {
            return "ForeignKey{referenceTable='" + this.f4399a + '\'' + ", onDelete='" + this.f4400b + '\'' + ", onUpdate='" + this.f4401c + '\'' + ", columnNames=" + this.f4402d + ", referenceColumnNames=" + this.f4403e + '}';
        }
    }

    static class c implements Comparable<c> {

        /* renamed from: a  reason: collision with root package name */
        final int f4404a;

        /* renamed from: b  reason: collision with root package name */
        final int f4405b;

        /* renamed from: c  reason: collision with root package name */
        final String f4406c;

        /* renamed from: d  reason: collision with root package name */
        final String f4407d;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            c cVar = (c) obj;
            int i2 = this.f4404a - cVar.f4404a;
            return i2 == 0 ? this.f4405b - cVar.f4405b : i2;
        }

        c(int i2, int i3, String str, String str2) {
            this.f4404a = i2;
            this.f4405b = i3;
            this.f4406c = str;
            this.f4407d = str2;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f4408a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f4409b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f4410c;

        public d(String str, boolean z, List<String> list) {
            this.f4408a = str;
            this.f4409b = z;
            this.f4410c = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f4409b != dVar.f4409b || !this.f4410c.equals(dVar.f4410c)) {
                return false;
            }
            if (this.f4408a.startsWith("index_")) {
                return dVar.f4408a.startsWith("index_");
            }
            return this.f4408a.equals(dVar.f4408a);
        }

        public final int hashCode() {
            int i2;
            if (this.f4408a.startsWith("index_")) {
                i2 = "index_".hashCode();
            } else {
                i2 = this.f4408a.hashCode();
            }
            return (((i2 * 31) + (this.f4409b ? 1 : 0)) * 31) + this.f4410c.hashCode();
        }

        public final String toString() {
            return "Index{name='" + this.f4408a + '\'' + ", unique=" + this.f4409b + ", columns=" + this.f4410c + '}';
        }
    }
}
