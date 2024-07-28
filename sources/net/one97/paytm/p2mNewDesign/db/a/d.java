package net.one97.paytm.p2mNewDesign.db.a;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;

public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final j f51215a;

    /* renamed from: b  reason: collision with root package name */
    private final c f51216b;

    /* renamed from: c  reason: collision with root package name */
    private final b f51217c;

    /* renamed from: d  reason: collision with root package name */
    private final b f51218d;

    /* renamed from: e  reason: collision with root package name */
    private final q f51219e;

    /* renamed from: f  reason: collision with root package name */
    private final q f51220f;

    public d(j jVar) {
        this.f51215a = jVar;
        this.f51216b = new c<net.one97.paytm.p2mNewDesign.db.b.b>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `mapping_table`(`row_id`,`user_id`,`m_id`,`json`,`payment_status`,`last_updated`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                net.one97.paytm.p2mNewDesign.db.b.b bVar = (net.one97.paytm.p2mNewDesign.db.b.b) obj;
                fVar.a(1, bVar.f51235a);
                if (bVar.f51236b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, bVar.f51236b);
                }
                if (bVar.f51237c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, bVar.f51237c);
                }
                if (bVar.f51238d == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, bVar.f51238d);
                }
                fVar.a(5, bVar.f51239e ? 1 : 0);
                fVar.a(6, bVar.f51240f);
            }
        };
        this.f51217c = new b<net.one97.paytm.p2mNewDesign.db.b.b>(jVar) {
            public final String createQuery() {
                return "DELETE FROM `mapping_table` WHERE `row_id` = ?";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                fVar.a(1, ((net.one97.paytm.p2mNewDesign.db.b.b) obj).f51235a);
            }
        };
        this.f51218d = new b<net.one97.paytm.p2mNewDesign.db.b.b>(jVar) {
            public final String createQuery() {
                return "UPDATE OR REPLACE `mapping_table` SET `row_id` = ?,`user_id` = ?,`m_id` = ?,`json` = ?,`payment_status` = ?,`last_updated` = ? WHERE `row_id` = ?";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                net.one97.paytm.p2mNewDesign.db.b.b bVar = (net.one97.paytm.p2mNewDesign.db.b.b) obj;
                fVar.a(1, bVar.f51235a);
                if (bVar.f51236b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, bVar.f51236b);
                }
                if (bVar.f51237c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, bVar.f51237c);
                }
                if (bVar.f51238d == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, bVar.f51238d);
                }
                fVar.a(5, bVar.f51239e ? 1 : 0);
                fVar.a(6, bVar.f51240f);
                fVar.a(7, bVar.f51235a);
            }
        };
        this.f51219e = new q(jVar) {
            public final String createQuery() {
                return "Update mapping_table set payment_status = 1 where user_id =? and m_id =?";
            }
        };
        this.f51220f = new q(jVar) {
            public final String createQuery() {
                return "Delete from mapping_table where m_id = ?";
            }
        };
    }

    public final void a(net.one97.paytm.p2mNewDesign.db.b.b bVar) {
        this.f51215a.beginTransaction();
        try {
            this.f51216b.insert(bVar);
            this.f51215a.setTransactionSuccessful();
        } finally {
            this.f51215a.endTransaction();
        }
    }

    public final void c(net.one97.paytm.p2mNewDesign.db.b.b bVar) {
        this.f51215a.beginTransaction();
        try {
            this.f51217c.handle(bVar);
            this.f51215a.setTransactionSuccessful();
        } finally {
            this.f51215a.endTransaction();
        }
    }

    public final void b(net.one97.paytm.p2mNewDesign.db.b.b bVar) {
        this.f51215a.beginTransaction();
        try {
            this.f51218d.handle(bVar);
            this.f51215a.setTransactionSuccessful();
        } finally {
            this.f51215a.endTransaction();
        }
    }

    public final void b(String str, String str2) {
        f acquire = this.f51219e.acquire();
        this.f51215a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f51215a.endTransaction();
                this.f51219e.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        if (str2 == null) {
            acquire.a(2);
        } else {
            acquire.a(2, str2);
        }
        acquire.a();
        this.f51215a.setTransactionSuccessful();
        this.f51215a.endTransaction();
        this.f51219e.release(acquire);
    }

    public final void a(String str) {
        f acquire = this.f51220f.acquire();
        this.f51215a.beginTransaction();
        if (str == null) {
            try {
                acquire.a(1);
            } catch (Throwable th) {
                this.f51215a.endTransaction();
                this.f51220f.release(acquire);
                throw th;
            }
        } else {
            acquire.a(1, str);
        }
        acquire.a();
        this.f51215a.setTransactionSuccessful();
        this.f51215a.endTransaction();
        this.f51220f.release(acquire);
    }

    public final long a(String str, String str2) {
        m a2 = m.a("Select rowId from mapping_table where user_id =? and m_id =?", 2);
        if (str == null) {
            a2.f4477f[1] = 1;
        } else {
            a2.a(1, str);
        }
        if (str2 == null) {
            a2.f4477f[2] = 1;
        } else {
            a2.a(2, str2);
        }
        Cursor query = this.f51215a.query(a2);
        try {
            return query.moveToFirst() ? query.getLong(0) : 0;
        } finally {
            query.close();
            a2.a();
        }
    }

    public final List<net.one97.paytm.p2mNewDesign.db.b.b> a() {
        m a2 = m.a("Select * from mapping_table", 0);
        Cursor query = this.f51215a.query(a2);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("row_id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("user_id");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("m_id");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("json");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("payment_status");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("last_updated");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new net.one97.paytm.p2mNewDesign.db.b.b(query.getLong(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5) != 0, query.getLong(columnIndexOrThrow6)));
            }
            return arrayList;
        } finally {
            query.close();
            a2.a();
        }
    }

    public final net.one97.paytm.p2mNewDesign.db.b.b a(long j) {
        net.one97.paytm.p2mNewDesign.db.b.b bVar;
        m a2 = m.a("Select * from mapping_table where row_id =?", 1);
        a2.a(1, j);
        Cursor query = this.f51215a.query(a2);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("row_id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("user_id");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("m_id");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("json");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow("payment_status");
            int columnIndexOrThrow6 = query.getColumnIndexOrThrow("last_updated");
            if (query.moveToFirst()) {
                bVar = new net.one97.paytm.p2mNewDesign.db.b.b(query.getLong(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow3), query.getString(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5) != 0, query.getLong(columnIndexOrThrow6));
            } else {
                bVar = null;
            }
            return bVar;
        } finally {
            query.close();
            a2.a();
        }
    }
}
