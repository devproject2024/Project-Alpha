package net.one97.paytm.p2mNewDesign.db.a;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.p2mNewDesign.db.b.a;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f51208a;

    /* renamed from: b  reason: collision with root package name */
    private final c f51209b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.b f51210c;

    /* renamed from: d  reason: collision with root package name */
    private final q f51211d;

    public b(j jVar) {
        this.f51208a = jVar;
        this.f51209b = new c<a>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `last_used_instrument_table`(`row_id`,`instrument_type`,`instrument_detail`,`last_used_time`) VALUES (nullif(?, 0),?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                a aVar = (a) obj;
                fVar.a(1, aVar.f51231a);
                if (aVar.f51232b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, aVar.f51232b);
                }
                if (aVar.f51233c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, aVar.f51233c);
                }
                fVar.a(4, aVar.f51234d);
            }
        };
        this.f51210c = new androidx.room.b<a>(jVar) {
            public final String createQuery() {
                return "UPDATE OR REPLACE `last_used_instrument_table` SET `row_id` = ?,`instrument_type` = ?,`instrument_detail` = ?,`last_used_time` = ? WHERE `row_id` = ?";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                a aVar = (a) obj;
                fVar.a(1, aVar.f51231a);
                if (aVar.f51232b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, aVar.f51232b);
                }
                if (aVar.f51233c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, aVar.f51233c);
                }
                fVar.a(4, aVar.f51234d);
                fVar.a(5, aVar.f51231a);
            }
        };
        this.f51211d = new q(jVar) {
            public final String createQuery() {
                return "Delete from last_used_instrument_table where row_id = ?";
            }
        };
    }

    public final void a(a aVar) {
        this.f51208a.beginTransaction();
        try {
            this.f51209b.insert(aVar);
            this.f51208a.setTransactionSuccessful();
        } finally {
            this.f51208a.endTransaction();
        }
    }

    public final List<a> a(int i2) {
        m a2 = m.a("Select * from last_used_instrument_table order by last_used_time desc limit ?", 1);
        a2.a(1, (long) i2);
        Cursor query = this.f51208a.query(a2);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("row_id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("instrument_type");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("instrument_detail");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("last_used_time");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new a(query.getLong(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getLong(columnIndexOrThrow4)));
            }
            return arrayList;
        } finally {
            query.close();
            a2.a();
        }
    }
}
