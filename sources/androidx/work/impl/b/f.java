package androidx.work.impl.b;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final j f5156a;

    /* renamed from: b  reason: collision with root package name */
    private final c<d> f5157b;

    public f(j jVar) {
        this.f5156a = jVar;
        this.f5157b = new c<d>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }

            public final /* synthetic */ void bind(androidx.sqlite.db.f fVar, Object obj) {
                d dVar = (d) obj;
                if (dVar.f5154a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, dVar.f5154a);
                }
                if (dVar.f5155b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, dVar.f5155b.longValue());
                }
            }
        };
    }

    public final void a(d dVar) {
        this.f5156a.assertNotSuspendingTransaction();
        this.f5156a.beginTransaction();
        try {
            this.f5157b.insert(dVar);
            this.f5156a.setTransactionSuccessful();
        } finally {
            this.f5156a.endTransaction();
        }
    }

    public final Long a(String str) {
        m a2 = m.a("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5156a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5156a, a2, false);
        try {
            return (!a3.moveToFirst() || a3.isNull(0)) ? null : Long.valueOf(a3.getLong(0));
        } finally {
            a3.close();
            a2.a();
        }
    }
}
