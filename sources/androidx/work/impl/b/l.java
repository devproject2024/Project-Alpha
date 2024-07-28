package androidx.work.impl.b;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;

public final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    private final j f5168a;

    /* renamed from: b  reason: collision with root package name */
    private final c<j> f5169b;

    public l(j jVar) {
        this.f5168a = jVar;
        this.f5169b = new c<j>(jVar) {
            public final String createQuery() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                j jVar = (j) obj;
                if (jVar.f5166a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, jVar.f5166a);
                }
                if (jVar.f5167b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, jVar.f5167b);
                }
            }
        };
    }

    public final void a(j jVar) {
        this.f5168a.assertNotSuspendingTransaction();
        this.f5168a.beginTransaction();
        try {
            this.f5169b.insert(jVar);
            this.f5168a.setTransactionSuccessful();
        } finally {
            this.f5168a.endTransaction();
        }
    }

    public final List<String> a(String str) {
        m a2 = m.a("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5168a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5168a, a2, false);
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
}
