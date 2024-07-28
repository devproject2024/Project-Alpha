package androidx.work.impl.b;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;

public final class u implements t {

    /* renamed from: a  reason: collision with root package name */
    private final j f5219a;

    /* renamed from: b  reason: collision with root package name */
    private final c<s> f5220b;

    public u(j jVar) {
        this.f5219a = jVar;
        this.f5220b = new c<s>(jVar) {
            public final String createQuery() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                s sVar = (s) obj;
                if (sVar.f5217a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, sVar.f5217a);
                }
                if (sVar.f5218b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, sVar.f5218b);
                }
            }
        };
    }

    public final void a(s sVar) {
        this.f5219a.assertNotSuspendingTransaction();
        this.f5219a.beginTransaction();
        try {
            this.f5220b.insert(sVar);
            this.f5219a.setTransactionSuccessful();
        } finally {
            this.f5219a.endTransaction();
        }
    }

    public final List<String> a(String str) {
        m a2 = m.a("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5219a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5219a, a2, false);
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
