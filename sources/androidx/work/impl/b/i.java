package androidx.work.impl.b;

import android.database.Cursor;
import androidx.room.b.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;

public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private final j f5161a;

    /* renamed from: b  reason: collision with root package name */
    private final c<g> f5162b;

    /* renamed from: c  reason: collision with root package name */
    private final q f5163c;

    public i(j jVar) {
        this.f5161a = jVar;
        this.f5162b = new c<g>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                g gVar = (g) obj;
                if (gVar.f5159a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, gVar.f5159a);
                }
                fVar.a(2, (long) gVar.f5160b);
            }
        };
        this.f5163c = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    public final void a(g gVar) {
        this.f5161a.assertNotSuspendingTransaction();
        this.f5161a.beginTransaction();
        try {
            this.f5162b.insert(gVar);
            this.f5161a.setTransactionSuccessful();
        } finally {
            this.f5161a.endTransaction();
        }
    }

    public final void b(String str) {
        this.f5161a.assertNotSuspendingTransaction();
        f acquire = this.f5163c.acquire();
        if (str == null) {
            acquire.a(1);
        } else {
            acquire.a(1, str);
        }
        this.f5161a.beginTransaction();
        try {
            acquire.a();
            this.f5161a.setTransactionSuccessful();
        } finally {
            this.f5161a.endTransaction();
            this.f5163c.release(acquire);
        }
    }

    public final g a(String str) {
        m a2 = m.a("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5161a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5161a, a2, false);
        try {
            return a3.moveToFirst() ? new g(a3.getString(b.b(a3, "work_spec_id")), a3.getInt(b.b(a3, "system_id"))) : null;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
