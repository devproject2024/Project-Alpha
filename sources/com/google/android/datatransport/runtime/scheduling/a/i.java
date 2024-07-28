package com.google.android.datatransport.runtime.scheduling.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.runtime.c.b;
import com.google.android.datatransport.runtime.g;
import com.google.android.datatransport.runtime.h;
import com.google.android.datatransport.runtime.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;

public final class i implements com.google.android.datatransport.runtime.c.b, c {

    /* renamed from: a  reason: collision with root package name */
    private static final com.google.android.datatransport.b f7849a = com.google.android.datatransport.b.a("proto");

    /* renamed from: b  reason: collision with root package name */
    private final ac f7850b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.d.a f7851c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.d.a f7852d;

    /* renamed from: e  reason: collision with root package name */
    private final d f7853e;

    interface a<T, U> {
        U a(T t);
    }

    interface c<T> {
        T a();
    }

    i(com.google.android.datatransport.runtime.d.a aVar, com.google.android.datatransport.runtime.d.a aVar2, d dVar, ac acVar) {
        this.f7850b = acVar;
        this.f7851c = aVar;
        this.f7852d = aVar2;
        this.f7853e = dVar;
    }

    private SQLiteDatabase c() {
        ac acVar = this.f7850b;
        acVar.getClass();
        return (SQLiteDatabase) a(new j(acVar), v.a());
    }

    static /* synthetic */ SQLiteDatabase b(Throwable th) {
        throw new com.google.android.datatransport.runtime.c.a("Timed out while trying to open db.", th);
    }

    public final h a(l lVar, h hVar) {
        com.google.android.datatransport.runtime.a.a.a("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", lVar.c(), hVar.a(), lVar.a());
        long longValue = ((Long) a(new w(this, lVar, hVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return h.a(longValue, lVar, hVar);
    }

    private static Long a(SQLiteDatabase sQLiteDatabase, l lVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{lVar.a(), String.valueOf(com.google.android.datatransport.runtime.e.a.a(lVar.c()))}));
        if (lVar.b() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(lVar.b(), 0));
        }
        return (Long) a(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), x.a());
    }

    static /* synthetic */ Long d(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    public final void a(Iterable<h> iterable) {
        if (iterable.iterator().hasNext()) {
            a(new y("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + c(iterable)));
        }
    }

    static /* synthetic */ Object a(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 10").execute();
        return null;
    }

    public final void b(Iterable<h> iterable) {
        if (iterable.iterator().hasNext()) {
            c().compileStatement("DELETE FROM events WHERE _id in " + c(iterable)).execute();
        }
    }

    private static String c(Iterable<h> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<h> it2 = iterable.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().a());
            if (it2.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public final long a(l lVar) {
        return ((Long) a(c().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{lVar.a(), String.valueOf(com.google.android.datatransport.runtime.e.a.a(lVar.c()))}), z.a())).longValue();
    }

    static /* synthetic */ Long c(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    static /* synthetic */ Boolean b(i iVar, l lVar, SQLiteDatabase sQLiteDatabase) {
        Long a2 = a(sQLiteDatabase, lVar);
        if (a2 == null) {
            return Boolean.FALSE;
        }
        return (Boolean) a(iVar.c().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{a2.toString()}), u.a());
    }

    static /* synthetic */ Object a(long j, l lVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{lVar.a(), String.valueOf(com.google.android.datatransport.runtime.e.a.a(lVar.c()))}) <= 0) {
            contentValues.put("backend_name", lVar.a());
            contentValues.put("priority", Integer.valueOf(com.google.android.datatransport.runtime.e.a.a(lVar.c())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    public final Iterable<l> a() {
        return (Iterable) a(m.a());
    }

    static /* synthetic */ List b(SQLiteDatabase sQLiteDatabase) {
        return (List) a(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), t.a());
    }

    static /* synthetic */ List b(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            l.a a2 = l.d().a(cursor.getString(1)).a(com.google.android.datatransport.runtime.e.a.a(cursor.getInt(2)));
            String string = cursor.getString(3);
            arrayList.add(a2.a(string == null ? null : Base64.decode(string, 0)).a());
        }
        return arrayList;
    }

    public final int b() {
        return ((Integer) a(new n(this.f7851c.a() - this.f7853e.d()))).intValue();
    }

    public final void close() {
        this.f7850b.close();
    }

    static /* synthetic */ Object a(i iVar, List list, l lVar, Cursor cursor) {
        Cursor cursor2 = cursor;
        while (cursor.moveToNext()) {
            long j = cursor2.getLong(0);
            boolean z = cursor2.getInt(7) != 0;
            h.a b2 = h.i().a(cursor2.getString(1)).a(cursor2.getLong(2)).b(cursor2.getLong(3));
            if (z) {
                b2.a(new g(a(cursor2.getString(4)), cursor2.getBlob(5)));
            } else {
                b2.a(new g(a(cursor2.getString(4)), (byte[]) a(iVar.c().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, (String) null, (String) null, "sequence_num"), p.a())));
            }
            if (!cursor2.isNull(6)) {
                b2.a(Integer.valueOf(cursor2.getInt(6)));
            }
            list.add(h.a(j, lVar, b2.b()));
        }
        return null;
    }

    static /* synthetic */ byte[] a(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i2 += blob.length;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            byte[] bArr2 = (byte[]) arrayList.get(i4);
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            i3 += bArr2.length;
        }
        return bArr;
    }

    private static com.google.android.datatransport.b a(String str) {
        if (str == null) {
            return f7849a;
        }
        return com.google.android.datatransport.b.a(str);
    }

    private static Map<Long, Set<b>> a(SQLiteDatabase sQLiteDatabase, List<h> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2).a());
            if (i2 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        a(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null), new q(hashMap));
        return hashMap;
    }

    static /* synthetic */ Object a(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new b(cursor.getString(1), cursor.getString(2), (byte) 0));
        }
        return null;
    }

    private static List<h> a(List<h> list, Map<Long, Set<b>> map) {
        ListIterator<h> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            h next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.a()))) {
                h.a h2 = next.c().h();
                for (b bVar : map.get(Long.valueOf(next.a()))) {
                    h2.a(bVar.f7854a, bVar.f7855b);
                }
                listIterator.set(h.a(next.a(), next.b(), h2.b()));
            }
        }
        return list;
    }

    private <T> T a(c<T> cVar, a<Throwable, T> aVar) {
        long a2 = this.f7852d.a();
        while (true) {
            try {
                return cVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.f7852d.a() >= ((long) this.f7853e.c()) + a2) {
                    return aVar.a(e2);
                }
                SystemClock.sleep(50);
            }
        }
    }

    static /* synthetic */ Object a(Throwable th) {
        throw new com.google.android.datatransport.runtime.c.a("Timed out while trying to acquire the lock.", th);
    }

    public final <T> T a(b.a<T> aVar) {
        SQLiteDatabase c2 = c();
        a(new r(c2), s.a());
        try {
            T a2 = aVar.a();
            c2.setTransactionSuccessful();
            return a2;
        } finally {
            c2.endTransaction();
        }
    }

    private <T> T a(a<SQLiteDatabase, T> aVar) {
        SQLiteDatabase c2 = c();
        c2.beginTransaction();
        try {
            T a2 = aVar.a(c2);
            c2.setTransactionSuccessful();
            return a2;
        } finally {
            c2.endTransaction();
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final String f7854a;

        /* renamed from: b  reason: collision with root package name */
        final String f7855b;

        /* synthetic */ b(String str, String str2, byte b2) {
            this(str, str2);
        }

        private b(String str, String str2) {
            this.f7854a = str;
            this.f7855b = str2;
        }
    }

    private static <T> T a(Cursor cursor, a<Cursor, T> aVar) {
        try {
            return aVar.a(cursor);
        } finally {
            cursor.close();
        }
    }

    public final boolean b(l lVar) {
        return ((Boolean) a(new aa(this, lVar))).booleanValue();
    }

    public final void a(l lVar, long j) {
        a(new k(j, lVar));
    }

    public final Iterable<h> c(l lVar) {
        return (Iterable) a(new l(this, lVar));
    }

    static /* synthetic */ List a(i iVar, l lVar, SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Long a2 = a(sQLiteDatabase, lVar);
        if (a2 != null) {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            a(sQLiteDatabase2.query(EventsModuleManager.MODULE_NAME, new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{a2.toString()}, (String) null, (String) null, (String) null, String.valueOf(iVar.f7853e.b())), new o(iVar, arrayList, lVar));
        }
        return a((List<h>) arrayList, a(sQLiteDatabase, (List<h>) arrayList));
    }

    static /* synthetic */ Long a(i iVar, l lVar, h hVar, SQLiteDatabase sQLiteDatabase) {
        long j;
        if (iVar.c().compileStatement("PRAGMA page_count").simpleQueryForLong() * iVar.c().compileStatement("PRAGMA page_size").simpleQueryForLong() >= iVar.f7853e.a()) {
            return -1L;
        }
        Long a2 = a(sQLiteDatabase, lVar);
        if (a2 != null) {
            j = a2.longValue();
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("backend_name", lVar.a());
            contentValues.put("priority", Integer.valueOf(com.google.android.datatransport.runtime.e.a.a(lVar.c())));
            contentValues.put("next_request_ms", 0);
            if (lVar.b() != null) {
                contentValues.put("extras", Base64.encodeToString(lVar.b(), 0));
            }
            j = sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        int e2 = iVar.f7853e.e();
        byte[] bArr = hVar.c().f7787b;
        boolean z = bArr.length <= e2;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("context_id", Long.valueOf(j));
        contentValues2.put("transport_name", hVar.a());
        contentValues2.put("timestamp_ms", Long.valueOf(hVar.d()));
        contentValues2.put("uptime_ms", Long.valueOf(hVar.e()));
        contentValues2.put("payload_encoding", hVar.c().f7786a.f7637a);
        contentValues2.put("code", hVar.b());
        contentValues2.put("num_attempts", 0);
        contentValues2.put("inline", Boolean.valueOf(z));
        contentValues2.put("payload", z ? bArr : new byte[0]);
        long insert = sQLiteDatabase.insert(EventsModuleManager.MODULE_NAME, (String) null, contentValues2);
        if (!z) {
            int ceil = (int) Math.ceil(((double) bArr.length) / ((double) e2));
            for (int i2 = 1; i2 <= ceil; i2++) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, (i2 - 1) * e2, Math.min(i2 * e2, bArr.length));
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("event_id", Long.valueOf(insert));
                contentValues3.put("sequence_num", Integer.valueOf(i2));
                contentValues3.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", (String) null, contentValues3);
            }
        }
        for (Map.Entry next : hVar.g().entrySet()) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("event_id", Long.valueOf(insert));
            contentValues4.put("name", (String) next.getKey());
            contentValues4.put("value", (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues4);
        }
        return Long.valueOf(insert);
    }
}
