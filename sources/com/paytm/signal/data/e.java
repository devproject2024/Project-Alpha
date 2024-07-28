package com.paytm.signal.data;

import android.database.Cursor;
import androidx.room.b.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.sqlite.db.f;
import com.paytm.signal.models.SignalEventDb;
import java.util.ArrayList;
import java.util.List;

public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final j f43647a;

    /* renamed from: b  reason: collision with root package name */
    private final c<SignalEventDb> f43648b;

    public e(j jVar) {
        this.f43647a = jVar;
        this.f43648b = new c<SignalEventDb>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `SignalEventDb` (`id`,`priority`,`deviceDateTime`,`signalEvent`) VALUES (nullif(?, 0),?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                SignalEventDb signalEventDb = (SignalEventDb) obj;
                fVar.a(1, signalEventDb.getId());
                if (signalEventDb.getPriority() == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, (long) signalEventDb.getPriority().intValue());
                }
                if (signalEventDb.getDeviceDateTime() == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, signalEventDb.getDeviceDateTime().longValue());
                }
                if (signalEventDb.getSignalEvent() == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, signalEventDb.getSignalEvent());
                }
            }
        };
    }

    public final void a(SignalEventDb signalEventDb) {
        this.f43647a.assertNotSuspendingTransaction();
        this.f43647a.beginTransaction();
        try {
            this.f43648b.insert(signalEventDb);
            this.f43647a.setTransactionSuccessful();
        } finally {
            this.f43647a.endTransaction();
        }
    }

    public final List<SignalEventDb> a() {
        Integer num;
        Long l;
        m a2 = m.a("SELECT * FROM SignalEventDb Limit ?", 1);
        a2.a(1, 10);
        this.f43647a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43647a, a2, false);
        try {
            int b2 = b.b(a3, "id");
            int b3 = b.b(a3, "priority");
            int b4 = b.b(a3, "deviceDateTime");
            int b5 = b.b(a3, "signalEvent");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                long j = a3.getLong(b2);
                if (a3.isNull(b3)) {
                    num = null;
                } else {
                    num = Integer.valueOf(a3.getInt(b3));
                }
                if (a3.isNull(b4)) {
                    l = null;
                } else {
                    l = Long.valueOf(a3.getLong(b4));
                }
                arrayList.add(new SignalEventDb(j, num, l, a3.getString(b5)));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final List<SignalEventDb> b() {
        Integer num;
        Long l;
        m a2 = m.a("SELECT * FROM SignalEventDb WHERE priority = ? Limit ?", 2);
        a2.a(1, 100);
        a2.a(2, 10);
        this.f43647a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43647a, a2, false);
        try {
            int b2 = b.b(a3, "id");
            int b3 = b.b(a3, "priority");
            int b4 = b.b(a3, "deviceDateTime");
            int b5 = b.b(a3, "signalEvent");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                long j = a3.getLong(b2);
                if (a3.isNull(b3)) {
                    num = null;
                } else {
                    num = Integer.valueOf(a3.getInt(b3));
                }
                if (a3.isNull(b4)) {
                    l = null;
                } else {
                    l = Long.valueOf(a3.getLong(b4));
                }
                arrayList.add(new SignalEventDb(j, num, l, a3.getString(b5)));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final int c() {
        int i2 = 0;
        m a2 = m.a("SELECT COUNT (*) FROM SignalEventDb ", 0);
        this.f43647a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43647a, a2, false);
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
        m a2 = m.a("SELECT id FROM SignalEventDb ORDER BY deviceDateTime ASC Limit ?", 1);
        a2.a(1, (long) i2);
        this.f43647a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43647a, a2, false);
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
        this.f43647a.assertNotSuspendingTransaction();
        StringBuilder a2 = androidx.room.b.e.a();
        a2.append("DELETE FROM SignalEventDb where id IN (");
        androidx.room.b.e.a(a2, list.size());
        a2.append(")");
        f compileStatement = this.f43647a.compileStatement(a2.toString());
        int i2 = 1;
        for (Long next : list) {
            if (next == null) {
                compileStatement.a(i2);
            } else {
                compileStatement.a(i2, next.longValue());
            }
            i2++;
        }
        this.f43647a.beginTransaction();
        try {
            compileStatement.a();
            this.f43647a.setTransactionSuccessful();
        } finally {
            this.f43647a.endTransaction();
        }
    }
}
