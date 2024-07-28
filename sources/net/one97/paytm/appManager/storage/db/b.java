package net.one97.paytm.appManager.storage.db;

import android.database.Cursor;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.k;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f49058a;

    /* renamed from: b  reason: collision with root package name */
    private final c<c> f49059b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.b<c> f49060c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.room.b<c> f49061d;

    /* renamed from: e  reason: collision with root package name */
    private final q f49062e;

    public b(j jVar) {
        this.f49058a = jVar;
        this.f49059b = new c<c>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `ItemTable` (`id`,`keyValue`,`value`) VALUES (?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                c cVar = (c) obj;
                if (cVar.f49067a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, (long) cVar.f49067a.intValue());
                }
                if (cVar.f49068b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, cVar.f49068b);
                }
                if (cVar.f49069c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, cVar.f49069c);
                }
            }
        };
        this.f49060c = new androidx.room.b<c>(jVar) {
            public final String createQuery() {
                return "DELETE FROM `ItemTable` WHERE `id` = ?";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                c cVar = (c) obj;
                if (cVar.f49067a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, (long) cVar.f49067a.intValue());
                }
            }
        };
        this.f49061d = new androidx.room.b<c>(jVar) {
            public final String createQuery() {
                return "UPDATE OR ABORT `ItemTable` SET `id` = ?,`keyValue` = ?,`value` = ? WHERE `id` = ?";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                c cVar = (c) obj;
                if (cVar.f49067a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, (long) cVar.f49067a.intValue());
                }
                if (cVar.f49068b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, cVar.f49068b);
                }
                if (cVar.f49069c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, cVar.f49069c);
                }
                if (cVar.f49067a == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, (long) cVar.f49067a.intValue());
                }
            }
        };
        this.f49062e = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM ItemTable";
            }
        };
    }

    public final void a(c cVar) {
        this.f49058a.assertNotSuspendingTransaction();
        this.f49058a.beginTransaction();
        try {
            this.f49059b.insert(cVar);
            this.f49058a.setTransactionSuccessful();
        } finally {
            this.f49058a.endTransaction();
        }
    }

    public final void a(c... cVarArr) {
        this.f49058a.assertNotSuspendingTransaction();
        this.f49058a.beginTransaction();
        try {
            this.f49059b.insert((T[]) cVarArr);
            this.f49058a.setTransactionSuccessful();
        } finally {
            this.f49058a.endTransaction();
        }
    }

    public final void b(c... cVarArr) {
        this.f49058a.assertNotSuspendingTransaction();
        this.f49058a.beginTransaction();
        try {
            this.f49060c.handleMultiple((T[]) cVarArr);
            this.f49058a.setTransactionSuccessful();
        } finally {
            this.f49058a.endTransaction();
        }
    }

    public final void b(c cVar) {
        this.f49058a.assertNotSuspendingTransaction();
        this.f49058a.beginTransaction();
        try {
            this.f49061d.handle(cVar);
            this.f49058a.setTransactionSuccessful();
        } finally {
            this.f49058a.endTransaction();
        }
    }

    public final void c(c... cVarArr) {
        this.f49058a.beginTransaction();
        try {
            k.c(cVarArr, "list");
            if (a() == 0) {
                a((c[]) Arrays.copyOf(cVarArr, cVarArr.length));
            } else {
                for (c cVar : cVarArr) {
                    List<c> a2 = a(cVar.f49068b);
                    if (a2.isEmpty()) {
                        a(cVar);
                    } else {
                        cVar.f49067a = a2.get(0).f49067a;
                        b(cVar);
                    }
                }
            }
            this.f49058a.setTransactionSuccessful();
        } finally {
            this.f49058a.endTransaction();
        }
    }

    public final void d(c... cVarArr) {
        this.f49058a.beginTransaction();
        try {
            k.c(cVarArr, "list");
            b();
            a((c[]) Arrays.copyOf(cVarArr, cVarArr.length));
            this.f49058a.setTransactionSuccessful();
        } finally {
            this.f49058a.endTransaction();
        }
    }

    public final void e(c... cVarArr) {
        this.f49058a.beginTransaction();
        try {
            k.c(cVarArr, "list");
            if (a() != 0) {
                if (!(cVarArr.length == 0)) {
                    for (c cVar : cVarArr) {
                        List<c> a2 = a(cVar.f49068b);
                        if (!a2.isEmpty()) {
                            cVar.f49067a = a2.get(0).f49067a;
                        }
                    }
                    b((c[]) Arrays.copyOf(cVarArr, cVarArr.length));
                }
            }
            this.f49058a.setTransactionSuccessful();
        } finally {
            this.f49058a.endTransaction();
        }
    }

    public final void b() {
        this.f49058a.assertNotSuspendingTransaction();
        f acquire = this.f49062e.acquire();
        this.f49058a.beginTransaction();
        try {
            acquire.a();
            this.f49058a.setTransactionSuccessful();
        } finally {
            this.f49058a.endTransaction();
            this.f49062e.release(acquire);
        }
    }

    public final List<c> a(String str) {
        Integer num;
        m a2 = m.a("SELECT * FROM ItemTable WHERE keyValue == ?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f49058a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f49058a, a2, false);
        try {
            int b2 = androidx.room.b.b.b(a3, "id");
            int b3 = androidx.room.b.b.b(a3, "keyValue");
            int b4 = androidx.room.b.b.b(a3, "value");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                if (a3.isNull(b2)) {
                    num = null;
                } else {
                    num = Integer.valueOf(a3.getInt(b2));
                }
                arrayList.add(new c(num, a3.getString(b3), a3.getString(b4)));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final int a() {
        int i2 = 0;
        m a2 = m.a("SELECT count(*) FROM ItemTable", 0);
        this.f49058a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f49058a, a2, false);
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
}
