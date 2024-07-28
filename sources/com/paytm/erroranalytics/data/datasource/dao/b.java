package com.paytm.erroranalytics.data.datasource.dao;

import android.database.Cursor;
import androidx.room.b.e;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.sqlite.db.f;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.erroranalytics.c.b.a;
import java.util.ArrayList;
import java.util.List;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f42798a;

    /* renamed from: b  reason: collision with root package name */
    private final c<a> f42799b;

    public b(j jVar) {
        this.f42798a = jVar;
        this.f42799b = new c<a>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `Event` (`id`,`event_type`,`device_id`,`customer_id`,`event_data`,`filter_dimensions`,`longitude`,`latitude`,`default_location`,`priority`,`date_time`,`event_log_time`,`network_type`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                a aVar = (a) obj;
                fVar.a(1, aVar.f42762a);
                if (aVar.f42763b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, aVar.f42763b);
                }
                if (aVar.f42764c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, aVar.f42764c);
                }
                if (aVar.f42765d == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, aVar.f42765d);
                }
                if (aVar.f42766e == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, aVar.f42766e);
                }
                fVar.a(6, aVar.f42767f ? 1 : 0);
                if (aVar.f42768g == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, aVar.f42768g);
                }
                if (aVar.f42769h == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, aVar.f42769h);
                }
                fVar.a(9, aVar.f42770i ? 1 : 0);
                fVar.a(10, (long) aVar.j);
                fVar.a(11, aVar.k);
                fVar.a(12, aVar.l);
                if (aVar.m == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, aVar.m);
                }
            }
        };
    }

    public final void a(a aVar) {
        this.f42798a.assertNotSuspendingTransaction();
        this.f42798a.beginTransaction();
        try {
            this.f42799b.insert(aVar);
            this.f42798a.setTransactionSuccessful();
        } finally {
            this.f42798a.endTransaction();
        }
    }

    public final List<a> a() {
        m mVar;
        m a2 = m.a("SELECT * FROM Event Limit ?", 1);
        a2.a(1, 10);
        this.f42798a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f42798a, a2, false);
        try {
            int b2 = androidx.room.b.b.b(a3, "id");
            int b3 = androidx.room.b.b.b(a3, ChatAnalyticsHelperKt.KEY_EVENT_TYPE);
            int b4 = androidx.room.b.b.b(a3, "device_id");
            int b5 = androidx.room.b.b.b(a3, "customer_id");
            int b6 = androidx.room.b.b.b(a3, "event_data");
            int b7 = androidx.room.b.b.b(a3, "filter_dimensions");
            int b8 = androidx.room.b.b.b(a3, "longitude");
            int b9 = androidx.room.b.b.b(a3, "latitude");
            int b10 = androidx.room.b.b.b(a3, "default_location");
            int b11 = androidx.room.b.b.b(a3, "priority");
            int b12 = androidx.room.b.b.b(a3, "date_time");
            int b13 = androidx.room.b.b.b(a3, "event_log_time");
            int b14 = androidx.room.b.b.b(a3, "network_type");
            mVar = a2;
            try {
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    a aVar = new a();
                    int i2 = b13;
                    ArrayList arrayList2 = arrayList;
                    aVar.f42762a = a3.getLong(b2);
                    aVar.f42763b = a3.getString(b3);
                    aVar.f42764c = a3.getString(b4);
                    aVar.f42765d = a3.getString(b5);
                    aVar.f42766e = a3.getString(b6);
                    aVar.f42767f = a3.getInt(b7) != 0;
                    aVar.f42768g = a3.getString(b8);
                    aVar.f42769h = a3.getString(b9);
                    aVar.f42770i = a3.getInt(b10) != 0;
                    aVar.j = a3.getInt(b11);
                    aVar.k = a3.getLong(b12);
                    int i3 = b2;
                    b13 = i2;
                    int i4 = b3;
                    aVar.l = a3.getLong(b13);
                    aVar.m = a3.getString(b14);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(aVar);
                    b3 = i4;
                    ArrayList arrayList4 = arrayList3;
                    b2 = i3;
                    arrayList = arrayList4;
                }
                ArrayList arrayList5 = arrayList;
                a3.close();
                mVar.a();
                return arrayList5;
            } catch (Throwable th) {
                th = th;
                a3.close();
                mVar.a();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mVar = a2;
            a3.close();
            mVar.a();
            throw th;
        }
    }

    public final int b() {
        int i2 = 0;
        m a2 = m.a("SELECT COUNT (*) FROM Event ", 0);
        this.f42798a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f42798a, a2, false);
        try {
            if (a3.moveToFirst()) {
                i2 = a3.getInt(0);
            }
            return i2;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final List<Long> a(int i2) {
        Long l;
        m a2 = m.a("SELECT id FROM Event ORDER BY event_log_time ASC Limit ?", 1);
        a2.a(1, (long) i2);
        this.f42798a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f42798a, a2, false);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                if (a3.isNull(0)) {
                    l = null;
                } else {
                    l = Long.valueOf(a3.getLong(0));
                }
                arrayList.add(l);
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final void a(List<Long> list) {
        this.f42798a.assertNotSuspendingTransaction();
        StringBuilder a2 = e.a();
        a2.append("DELETE FROM Event where id IN (");
        e.a(a2, list.size());
        a2.append(")");
        f compileStatement = this.f42798a.compileStatement(a2.toString());
        int i2 = 1;
        for (Long next : list) {
            if (next == null) {
                compileStatement.a(i2);
            } else {
                compileStatement.a(i2, next.longValue());
            }
            i2++;
        }
        this.f42798a.beginTransaction();
        try {
            compileStatement.a();
            this.f42798a.setTransactionSuccessful();
        } finally {
            this.f42798a.endTransaction();
        }
    }
}
