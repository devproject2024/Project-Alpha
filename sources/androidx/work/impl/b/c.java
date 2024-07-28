package androidx.work.impl.b;

import android.database.Cursor;
import androidx.room.j;
import androidx.room.m;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final j f5151a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.c<a> f5152b;

    public c(j jVar) {
        this.f5151a = jVar;
        this.f5152b = new androidx.room.c<a>(jVar) {
            public final String createQuery() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                a aVar = (a) obj;
                if (aVar.f5149a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, aVar.f5149a);
                }
                if (aVar.f5150b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, aVar.f5150b);
                }
            }
        };
    }

    public final void a(a aVar) {
        this.f5151a.assertNotSuspendingTransaction();
        this.f5151a.beginTransaction();
        try {
            this.f5152b.insert(aVar);
            this.f5151a.setTransactionSuccessful();
        } finally {
            this.f5151a.endTransaction();
        }
    }

    public final boolean a(String str) {
        m a2 = m.a("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5151a.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor a3 = androidx.room.b.c.a(this.f5151a, a2, false);
        try {
            if (a3.moveToFirst() && a3.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final List<String> b(String str) {
        m a2 = m.a("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5151a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5151a, a2, false);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(a3.getString(0));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final boolean c(String str) {
        m a2 = m.a("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5151a.assertNotSuspendingTransaction();
        boolean z = false;
        Cursor a3 = androidx.room.b.c.a(this.f5151a, a2, false);
        try {
            if (a3.moveToFirst() && a3.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
