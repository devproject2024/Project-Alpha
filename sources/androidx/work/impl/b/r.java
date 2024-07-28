package androidx.work.impl.b;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.b.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.q;
import androidx.sqlite.db.f;
import androidx.work.a;
import androidx.work.e;
import androidx.work.impl.b.p;
import androidx.work.impl.b.v;
import androidx.work.m;
import androidx.work.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class r implements q {

    /* renamed from: a  reason: collision with root package name */
    final j f5197a;

    /* renamed from: b  reason: collision with root package name */
    private final c<p> f5198b;

    /* renamed from: c  reason: collision with root package name */
    private final q f5199c;

    /* renamed from: d  reason: collision with root package name */
    private final q f5200d;

    /* renamed from: e  reason: collision with root package name */
    private final q f5201e;

    /* renamed from: f  reason: collision with root package name */
    private final q f5202f;

    /* renamed from: g  reason: collision with root package name */
    private final q f5203g;

    /* renamed from: h  reason: collision with root package name */
    private final q f5204h;

    /* renamed from: i  reason: collision with root package name */
    private final q f5205i;
    private final q j;

    public r(j jVar) {
        this.f5197a = jVar;
        this.f5198b = new c<p>(jVar) {
            public final String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                int i2;
                f fVar2 = fVar;
                p pVar = (p) obj;
                if (pVar.f5180a == null) {
                    fVar2.a(1);
                } else {
                    fVar2.a(1, pVar.f5180a);
                }
                int i3 = 2;
                fVar2.a(2, (long) v.a(pVar.f5181b));
                if (pVar.f5182c == null) {
                    fVar2.a(3);
                } else {
                    fVar2.a(3, pVar.f5182c);
                }
                if (pVar.f5183d == null) {
                    fVar2.a(4);
                } else {
                    fVar2.a(4, pVar.f5183d);
                }
                byte[] a2 = e.a(pVar.f5184e);
                if (a2 == null) {
                    fVar2.a(5);
                } else {
                    fVar2.a(5, a2);
                }
                byte[] a3 = e.a(pVar.f5185f);
                if (a3 == null) {
                    fVar2.a(6);
                } else {
                    fVar2.a(6, a3);
                }
                fVar2.a(7, pVar.f5186g);
                fVar2.a(8, pVar.f5187h);
                fVar2.a(9, pVar.f5188i);
                fVar2.a(10, (long) pVar.k);
                a aVar = pVar.l;
                int i4 = v.AnonymousClass1.f5223b[aVar.ordinal()];
                if (i4 == 1) {
                    i2 = 0;
                } else if (i4 == 2) {
                    i2 = 1;
                } else {
                    throw new IllegalArgumentException("Could not convert " + aVar + " to int");
                }
                fVar2.a(11, (long) i2);
                fVar2.a(12, pVar.m);
                fVar2.a(13, pVar.n);
                fVar2.a(14, pVar.o);
                fVar2.a(15, pVar.p);
                fVar2.a(16, pVar.q ? 1 : 0);
                androidx.work.c cVar = pVar.j;
                if (cVar != null) {
                    m mVar = cVar.f5073b;
                    int i5 = v.AnonymousClass1.f5224c[mVar.ordinal()];
                    if (i5 == 1) {
                        i3 = 0;
                    } else if (i5 == 2) {
                        i3 = 1;
                    } else if (i5 != 3) {
                        if (i5 == 4) {
                            i3 = 3;
                        } else if (i5 == 5) {
                            i3 = 4;
                        } else {
                            throw new IllegalArgumentException("Could not convert " + mVar + " to int");
                        }
                    }
                    fVar2.a(17, (long) i3);
                    fVar2.a(18, cVar.f5074c ? 1 : 0);
                    fVar2.a(19, cVar.f5075d ? 1 : 0);
                    fVar2.a(20, cVar.f5076e ? 1 : 0);
                    fVar2.a(21, cVar.f5077f ? 1 : 0);
                    fVar2.a(22, cVar.f5078g);
                    fVar2.a(23, cVar.f5079h);
                    byte[] a4 = v.a(cVar.f5080i);
                    if (a4 == null) {
                        fVar2.a(24);
                    } else {
                        fVar2.a(24, a4);
                    }
                } else {
                    fVar2.a(17);
                    fVar2.a(18);
                    fVar2.a(19);
                    fVar2.a(20);
                    fVar2.a(21);
                    fVar2.a(22);
                    fVar2.a(23);
                    fVar2.a(24);
                }
            }
        };
        this.f5199c = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.f5200d = new q(jVar) {
            public final String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.f5201e = new q(jVar) {
            public final String createQuery() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.f5202f = new q(jVar) {
            public final String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.f5203g = new q(jVar) {
            public final String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.f5204h = new q(jVar) {
            public final String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.f5205i = new q(jVar) {
            public final String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.j = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    public final void a(p pVar) {
        this.f5197a.assertNotSuspendingTransaction();
        this.f5197a.beginTransaction();
        try {
            this.f5198b.insert(pVar);
            this.f5197a.setTransactionSuccessful();
        } finally {
            this.f5197a.endTransaction();
        }
    }

    public final void a(String str) {
        this.f5197a.assertNotSuspendingTransaction();
        f acquire = this.f5199c.acquire();
        if (str == null) {
            acquire.a(1);
        } else {
            acquire.a(1, str);
        }
        this.f5197a.beginTransaction();
        try {
            acquire.a();
            this.f5197a.setTransactionSuccessful();
        } finally {
            this.f5197a.endTransaction();
            this.f5199c.release(acquire);
        }
    }

    public final void a(String str, e eVar) {
        this.f5197a.assertNotSuspendingTransaction();
        f acquire = this.f5200d.acquire();
        byte[] a2 = e.a(eVar);
        if (a2 == null) {
            acquire.a(1);
        } else {
            acquire.a(1, a2);
        }
        if (str == null) {
            acquire.a(2);
        } else {
            acquire.a(2, str);
        }
        this.f5197a.beginTransaction();
        try {
            acquire.a();
            this.f5197a.setTransactionSuccessful();
        } finally {
            this.f5197a.endTransaction();
            this.f5200d.release(acquire);
        }
    }

    public final void a(String str, long j2) {
        this.f5197a.assertNotSuspendingTransaction();
        f acquire = this.f5201e.acquire();
        acquire.a(1, j2);
        if (str == null) {
            acquire.a(2);
        } else {
            acquire.a(2, str);
        }
        this.f5197a.beginTransaction();
        try {
            acquire.a();
            this.f5197a.setTransactionSuccessful();
        } finally {
            this.f5197a.endTransaction();
            this.f5201e.release(acquire);
        }
    }

    public final int d(String str) {
        this.f5197a.assertNotSuspendingTransaction();
        f acquire = this.f5202f.acquire();
        if (str == null) {
            acquire.a(1);
        } else {
            acquire.a(1, str);
        }
        this.f5197a.beginTransaction();
        try {
            int a2 = acquire.a();
            this.f5197a.setTransactionSuccessful();
            return a2;
        } finally {
            this.f5197a.endTransaction();
            this.f5202f.release(acquire);
        }
    }

    public final int e(String str) {
        this.f5197a.assertNotSuspendingTransaction();
        f acquire = this.f5203g.acquire();
        if (str == null) {
            acquire.a(1);
        } else {
            acquire.a(1, str);
        }
        this.f5197a.beginTransaction();
        try {
            int a2 = acquire.a();
            this.f5197a.setTransactionSuccessful();
            return a2;
        } finally {
            this.f5197a.endTransaction();
            this.f5203g.release(acquire);
        }
    }

    public final int b(String str, long j2) {
        this.f5197a.assertNotSuspendingTransaction();
        f acquire = this.f5204h.acquire();
        acquire.a(1, j2);
        if (str == null) {
            acquire.a(2);
        } else {
            acquire.a(2, str);
        }
        this.f5197a.beginTransaction();
        try {
            int a2 = acquire.a();
            this.f5197a.setTransactionSuccessful();
            return a2;
        } finally {
            this.f5197a.endTransaction();
            this.f5204h.release(acquire);
        }
    }

    public final int b() {
        this.f5197a.assertNotSuspendingTransaction();
        f acquire = this.f5205i.acquire();
        this.f5197a.beginTransaction();
        try {
            int a2 = acquire.a();
            this.f5197a.setTransactionSuccessful();
            return a2;
        } finally {
            this.f5197a.endTransaction();
            this.f5205i.release(acquire);
        }
    }

    public final p b(String str) {
        androidx.room.m mVar;
        p pVar;
        String str2 = str;
        androidx.room.m a2 = androidx.room.m.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            a2.a(1);
        } else {
            a2.a(1, str2);
        }
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
        try {
            int b2 = b.b(a3, "required_network_type");
            int b3 = b.b(a3, "requires_charging");
            int b4 = b.b(a3, "requires_device_idle");
            int b5 = b.b(a3, "requires_battery_not_low");
            int b6 = b.b(a3, "requires_storage_not_low");
            int b7 = b.b(a3, "trigger_content_update_delay");
            int b8 = b.b(a3, "trigger_max_content_delay");
            int b9 = b.b(a3, "content_uri_triggers");
            int b10 = b.b(a3, "id");
            int b11 = b.b(a3, "state");
            int b12 = b.b(a3, "worker_class_name");
            int b13 = b.b(a3, "input_merger_class_name");
            int b14 = b.b(a3, "input");
            int b15 = b.b(a3, "output");
            mVar = a2;
            try {
                int b16 = b.b(a3, "initial_delay");
                int b17 = b.b(a3, "interval_duration");
                int b18 = b.b(a3, "flex_duration");
                int b19 = b.b(a3, "run_attempt_count");
                int b20 = b.b(a3, "backoff_policy");
                int b21 = b.b(a3, "backoff_delay_duration");
                int b22 = b.b(a3, "period_start_time");
                int b23 = b.b(a3, "minimum_retention_duration");
                int b24 = b.b(a3, "schedule_requested_at");
                int b25 = b.b(a3, "run_in_foreground");
                if (a3.moveToFirst()) {
                    String string = a3.getString(b10);
                    String string2 = a3.getString(b12);
                    int i2 = b25;
                    androidx.work.c cVar = new androidx.work.c();
                    cVar.f5073b = v.c(a3.getInt(b2));
                    cVar.f5074c = a3.getInt(b3) != 0;
                    cVar.f5075d = a3.getInt(b4) != 0;
                    cVar.f5076e = a3.getInt(b5) != 0;
                    cVar.f5077f = a3.getInt(b6) != 0;
                    cVar.f5078g = a3.getLong(b7);
                    cVar.f5079h = a3.getLong(b8);
                    cVar.f5080i = v.a(a3.getBlob(b9));
                    pVar = new p(string, string2);
                    pVar.f5181b = v.a(a3.getInt(b11));
                    pVar.f5183d = a3.getString(b13);
                    pVar.f5184e = e.a(a3.getBlob(b14));
                    pVar.f5185f = e.a(a3.getBlob(b15));
                    pVar.f5186g = a3.getLong(b16);
                    pVar.f5187h = a3.getLong(b17);
                    pVar.f5188i = a3.getLong(b18);
                    pVar.k = a3.getInt(b19);
                    pVar.l = v.b(a3.getInt(b20));
                    pVar.m = a3.getLong(b21);
                    pVar.n = a3.getLong(b22);
                    pVar.o = a3.getLong(b23);
                    pVar.p = a3.getLong(b24);
                    pVar.q = a3.getInt(i2) != 0;
                    pVar.j = cVar;
                } else {
                    pVar = null;
                }
                a3.close();
                mVar.a();
                return pVar;
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

    public final List<p.a> c(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
        try {
            int b2 = b.b(a3, "id");
            int b3 = b.b(a3, "state");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                p.a aVar = new p.a();
                aVar.f5189a = a3.getString(b2);
                aVar.f5190b = v.a(a3.getInt(b3));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final u.a f(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
        try {
            return a3.moveToFirst() ? v.a(a3.getInt(0)) : null;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final LiveData<List<p.b>> a(List<String> list) {
        StringBuilder a2 = androidx.room.b.e.a();
        a2.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        androidx.room.b.e.a(a2, size);
        a2.append(")");
        final androidx.room.m a3 = androidx.room.m.a(a2.toString(), size + 0);
        int i2 = 1;
        for (String next : list) {
            if (next == null) {
                a3.a(i2);
            } else {
                a3.a(i2, next);
            }
            i2++;
        }
        return this.f5197a.getInvalidationTracker().a(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new Callable<List<p.b>>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public List<p.b> call() throws Exception {
                Cursor a2;
                r.this.f5197a.beginTransaction();
                try {
                    a2 = androidx.room.b.c.a(r.this.f5197a, a3, true);
                    int b2 = b.b(a2, "id");
                    int b3 = b.b(a2, "state");
                    int b4 = b.b(a2, "output");
                    int b5 = b.b(a2, "run_attempt_count");
                    androidx.a.a aVar = new androidx.a.a();
                    androidx.a.a aVar2 = new androidx.a.a();
                    while (a2.moveToNext()) {
                        if (!a2.isNull(b2)) {
                            String string = a2.getString(b2);
                            if (((ArrayList) aVar.get(string)) == null) {
                                aVar.put(string, new ArrayList());
                            }
                        }
                        if (!a2.isNull(b2)) {
                            String string2 = a2.getString(b2);
                            if (((ArrayList) aVar2.get(string2)) == null) {
                                aVar2.put(string2, new ArrayList());
                            }
                        }
                    }
                    a2.moveToPosition(-1);
                    r.this.a((androidx.a.a<String, ArrayList<String>>) aVar);
                    r.this.b((androidx.a.a<String, ArrayList<e>>) aVar2);
                    ArrayList arrayList = new ArrayList(a2.getCount());
                    while (a2.moveToNext()) {
                        ArrayList arrayList2 = null;
                        ArrayList arrayList3 = !a2.isNull(b2) ? (ArrayList) aVar.get(a2.getString(b2)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        if (!a2.isNull(b2)) {
                            arrayList2 = (ArrayList) aVar2.get(a2.getString(b2));
                        }
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        p.b bVar = new p.b();
                        bVar.f5191a = a2.getString(b2);
                        bVar.f5192b = v.a(a2.getInt(b3));
                        bVar.f5193c = e.a(a2.getBlob(b4));
                        bVar.f5194d = a2.getInt(b5);
                        bVar.f5195e = arrayList3;
                        bVar.f5196f = arrayList2;
                        arrayList.add(bVar);
                    }
                    r.this.f5197a.setTransactionSuccessful();
                    a2.close();
                    r.this.f5197a.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    r.this.f5197a.endTransaction();
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a3.a();
            }
        });
    }

    public final List<p.b> g(String str) {
        Cursor a2;
        androidx.room.m a3 = androidx.room.m.a("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            a3.a(1);
        } else {
            a3.a(1, str);
        }
        this.f5197a.assertNotSuspendingTransaction();
        this.f5197a.beginTransaction();
        try {
            a2 = androidx.room.b.c.a(this.f5197a, a3, true);
            int b2 = b.b(a2, "id");
            int b3 = b.b(a2, "state");
            int b4 = b.b(a2, "output");
            int b5 = b.b(a2, "run_attempt_count");
            androidx.a.a aVar = new androidx.a.a();
            androidx.a.a aVar2 = new androidx.a.a();
            while (a2.moveToNext()) {
                if (!a2.isNull(b2)) {
                    String string = a2.getString(b2);
                    if (((ArrayList) aVar.get(string)) == null) {
                        aVar.put(string, new ArrayList());
                    }
                }
                if (!a2.isNull(b2)) {
                    String string2 = a2.getString(b2);
                    if (((ArrayList) aVar2.get(string2)) == null) {
                        aVar2.put(string2, new ArrayList());
                    }
                }
            }
            a2.moveToPosition(-1);
            a((androidx.a.a<String, ArrayList<String>>) aVar);
            b((androidx.a.a<String, ArrayList<e>>) aVar2);
            ArrayList arrayList = new ArrayList(a2.getCount());
            while (a2.moveToNext()) {
                ArrayList arrayList2 = null;
                ArrayList arrayList3 = !a2.isNull(b2) ? (ArrayList) aVar.get(a2.getString(b2)) : null;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                if (!a2.isNull(b2)) {
                    arrayList2 = (ArrayList) aVar2.get(a2.getString(b2));
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                p.b bVar = new p.b();
                bVar.f5191a = a2.getString(b2);
                bVar.f5192b = v.a(a2.getInt(b3));
                bVar.f5193c = e.a(a2.getBlob(b4));
                bVar.f5194d = a2.getInt(b5);
                bVar.f5195e = arrayList3;
                bVar.f5196f = arrayList2;
                arrayList.add(bVar);
            }
            this.f5197a.setTransactionSuccessful();
            a2.close();
            a3.a();
            this.f5197a.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.f5197a.endTransaction();
            throw th;
        }
    }

    public final List<e> h(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(e.a(a3.getBlob(0)));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    public final List<String> i(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
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

    public final List<String> j(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
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

    public final List<String> a() {
        androidx.room.m a2 = androidx.room.m.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
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

    public final List<p> a(int i2) {
        androidx.room.m mVar;
        androidx.room.m a2 = androidx.room.m.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        a2.a(1, (long) i2);
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
        try {
            int b2 = b.b(a3, "required_network_type");
            int b3 = b.b(a3, "requires_charging");
            int b4 = b.b(a3, "requires_device_idle");
            int b5 = b.b(a3, "requires_battery_not_low");
            int b6 = b.b(a3, "requires_storage_not_low");
            int b7 = b.b(a3, "trigger_content_update_delay");
            int b8 = b.b(a3, "trigger_max_content_delay");
            int b9 = b.b(a3, "content_uri_triggers");
            int b10 = b.b(a3, "id");
            int b11 = b.b(a3, "state");
            int b12 = b.b(a3, "worker_class_name");
            int b13 = b.b(a3, "input_merger_class_name");
            int b14 = b.b(a3, "input");
            int b15 = b.b(a3, "output");
            mVar = a2;
            try {
                int b16 = b.b(a3, "initial_delay");
                int b17 = b.b(a3, "interval_duration");
                int b18 = b.b(a3, "flex_duration");
                int b19 = b.b(a3, "run_attempt_count");
                int b20 = b.b(a3, "backoff_policy");
                int b21 = b.b(a3, "backoff_delay_duration");
                int b22 = b.b(a3, "period_start_time");
                int b23 = b.b(a3, "minimum_retention_duration");
                int b24 = b.b(a3, "schedule_requested_at");
                int b25 = b.b(a3, "run_in_foreground");
                int i3 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    String string = a3.getString(b10);
                    int i4 = b10;
                    String string2 = a3.getString(b12);
                    int i5 = b12;
                    androidx.work.c cVar = new androidx.work.c();
                    int i6 = b2;
                    cVar.f5073b = v.c(a3.getInt(b2));
                    cVar.f5074c = a3.getInt(b3) != 0;
                    cVar.f5075d = a3.getInt(b4) != 0;
                    cVar.f5076e = a3.getInt(b5) != 0;
                    cVar.f5077f = a3.getInt(b6) != 0;
                    int i7 = b3;
                    cVar.f5078g = a3.getLong(b7);
                    cVar.f5079h = a3.getLong(b8);
                    cVar.f5080i = v.a(a3.getBlob(b9));
                    p pVar = new p(string, string2);
                    pVar.f5181b = v.a(a3.getInt(b11));
                    pVar.f5183d = a3.getString(b13);
                    pVar.f5184e = e.a(a3.getBlob(b14));
                    int i8 = i3;
                    pVar.f5185f = e.a(a3.getBlob(i8));
                    int i9 = b13;
                    i3 = i8;
                    int i10 = b16;
                    pVar.f5186g = a3.getLong(i10);
                    b16 = i10;
                    int i11 = b17;
                    pVar.f5187h = a3.getLong(i11);
                    b17 = i11;
                    int i12 = b18;
                    pVar.f5188i = a3.getLong(i12);
                    int i13 = b19;
                    pVar.k = a3.getInt(i13);
                    int i14 = b20;
                    b19 = i13;
                    pVar.l = v.b(a3.getInt(i14));
                    b18 = i12;
                    int i15 = b4;
                    int i16 = b21;
                    pVar.m = a3.getLong(i16);
                    b21 = i16;
                    int i17 = b22;
                    pVar.n = a3.getLong(i17);
                    b22 = i17;
                    int i18 = b23;
                    pVar.o = a3.getLong(i18);
                    b23 = i18;
                    int i19 = i14;
                    int i20 = b24;
                    pVar.p = a3.getLong(i20);
                    int i21 = b25;
                    pVar.q = a3.getInt(i21) != 0;
                    pVar.j = cVar;
                    arrayList.add(pVar);
                    b25 = i21;
                    b24 = i20;
                    b13 = i9;
                    b10 = i4;
                    b12 = i5;
                    b3 = i7;
                    b2 = i6;
                    int i22 = i15;
                    b20 = i19;
                    b4 = i22;
                }
                a3.close();
                mVar.a();
                return arrayList;
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

    public final List<p> c() {
        androidx.room.m mVar;
        androidx.room.m a2 = androidx.room.m.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 ORDER BY period_start_time", 0);
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
        try {
            int b2 = b.b(a3, "required_network_type");
            int b3 = b.b(a3, "requires_charging");
            int b4 = b.b(a3, "requires_device_idle");
            int b5 = b.b(a3, "requires_battery_not_low");
            int b6 = b.b(a3, "requires_storage_not_low");
            int b7 = b.b(a3, "trigger_content_update_delay");
            int b8 = b.b(a3, "trigger_max_content_delay");
            int b9 = b.b(a3, "content_uri_triggers");
            int b10 = b.b(a3, "id");
            int b11 = b.b(a3, "state");
            int b12 = b.b(a3, "worker_class_name");
            int b13 = b.b(a3, "input_merger_class_name");
            int b14 = b.b(a3, "input");
            int b15 = b.b(a3, "output");
            mVar = a2;
            try {
                int b16 = b.b(a3, "initial_delay");
                int b17 = b.b(a3, "interval_duration");
                int b18 = b.b(a3, "flex_duration");
                int b19 = b.b(a3, "run_attempt_count");
                int b20 = b.b(a3, "backoff_policy");
                int b21 = b.b(a3, "backoff_delay_duration");
                int b22 = b.b(a3, "period_start_time");
                int b23 = b.b(a3, "minimum_retention_duration");
                int b24 = b.b(a3, "schedule_requested_at");
                int b25 = b.b(a3, "run_in_foreground");
                int i2 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    String string = a3.getString(b10);
                    int i3 = b10;
                    String string2 = a3.getString(b12);
                    int i4 = b12;
                    androidx.work.c cVar = new androidx.work.c();
                    int i5 = b2;
                    cVar.f5073b = v.c(a3.getInt(b2));
                    cVar.f5074c = a3.getInt(b3) != 0;
                    cVar.f5075d = a3.getInt(b4) != 0;
                    cVar.f5076e = a3.getInt(b5) != 0;
                    cVar.f5077f = a3.getInt(b6) != 0;
                    int i6 = b3;
                    cVar.f5078g = a3.getLong(b7);
                    cVar.f5079h = a3.getLong(b8);
                    cVar.f5080i = v.a(a3.getBlob(b9));
                    p pVar = new p(string, string2);
                    pVar.f5181b = v.a(a3.getInt(b11));
                    pVar.f5183d = a3.getString(b13);
                    pVar.f5184e = e.a(a3.getBlob(b14));
                    int i7 = i2;
                    pVar.f5185f = e.a(a3.getBlob(i7));
                    int i8 = b14;
                    i2 = i7;
                    int i9 = b16;
                    pVar.f5186g = a3.getLong(i9);
                    b16 = i9;
                    int i10 = b17;
                    pVar.f5187h = a3.getLong(i10);
                    b17 = i10;
                    int i11 = b18;
                    pVar.f5188i = a3.getLong(i11);
                    int i12 = b19;
                    pVar.k = a3.getInt(i12);
                    int i13 = b20;
                    b19 = i12;
                    pVar.l = v.b(a3.getInt(i13));
                    b18 = i11;
                    int i14 = b4;
                    int i15 = b21;
                    pVar.m = a3.getLong(i15);
                    b21 = i15;
                    int i16 = b22;
                    pVar.n = a3.getLong(i16);
                    b22 = i16;
                    int i17 = b23;
                    pVar.o = a3.getLong(i17);
                    b23 = i17;
                    int i18 = i13;
                    int i19 = b24;
                    pVar.p = a3.getLong(i19);
                    int i20 = b25;
                    pVar.q = a3.getInt(i20) != 0;
                    pVar.j = cVar;
                    arrayList.add(pVar);
                    b25 = i20;
                    b24 = i19;
                    b14 = i8;
                    b10 = i3;
                    b12 = i4;
                    b2 = i5;
                    b3 = i6;
                    int i21 = i14;
                    b20 = i18;
                    b4 = i21;
                }
                a3.close();
                mVar.a();
                return arrayList;
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

    public final List<p> d() {
        androidx.room.m mVar;
        androidx.room.m a2 = androidx.room.m.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
        try {
            int b2 = b.b(a3, "required_network_type");
            int b3 = b.b(a3, "requires_charging");
            int b4 = b.b(a3, "requires_device_idle");
            int b5 = b.b(a3, "requires_battery_not_low");
            int b6 = b.b(a3, "requires_storage_not_low");
            int b7 = b.b(a3, "trigger_content_update_delay");
            int b8 = b.b(a3, "trigger_max_content_delay");
            int b9 = b.b(a3, "content_uri_triggers");
            int b10 = b.b(a3, "id");
            int b11 = b.b(a3, "state");
            int b12 = b.b(a3, "worker_class_name");
            int b13 = b.b(a3, "input_merger_class_name");
            int b14 = b.b(a3, "input");
            int b15 = b.b(a3, "output");
            mVar = a2;
            try {
                int b16 = b.b(a3, "initial_delay");
                int b17 = b.b(a3, "interval_duration");
                int b18 = b.b(a3, "flex_duration");
                int b19 = b.b(a3, "run_attempt_count");
                int b20 = b.b(a3, "backoff_policy");
                int b21 = b.b(a3, "backoff_delay_duration");
                int b22 = b.b(a3, "period_start_time");
                int b23 = b.b(a3, "minimum_retention_duration");
                int b24 = b.b(a3, "schedule_requested_at");
                int b25 = b.b(a3, "run_in_foreground");
                int i2 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    String string = a3.getString(b10);
                    int i3 = b10;
                    String string2 = a3.getString(b12);
                    int i4 = b12;
                    androidx.work.c cVar = new androidx.work.c();
                    int i5 = b2;
                    cVar.f5073b = v.c(a3.getInt(b2));
                    cVar.f5074c = a3.getInt(b3) != 0;
                    cVar.f5075d = a3.getInt(b4) != 0;
                    cVar.f5076e = a3.getInt(b5) != 0;
                    cVar.f5077f = a3.getInt(b6) != 0;
                    int i6 = b3;
                    cVar.f5078g = a3.getLong(b7);
                    cVar.f5079h = a3.getLong(b8);
                    cVar.f5080i = v.a(a3.getBlob(b9));
                    p pVar = new p(string, string2);
                    pVar.f5181b = v.a(a3.getInt(b11));
                    pVar.f5183d = a3.getString(b13);
                    pVar.f5184e = e.a(a3.getBlob(b14));
                    int i7 = i2;
                    pVar.f5185f = e.a(a3.getBlob(i7));
                    int i8 = b14;
                    i2 = i7;
                    int i9 = b16;
                    pVar.f5186g = a3.getLong(i9);
                    b16 = i9;
                    int i10 = b17;
                    pVar.f5187h = a3.getLong(i10);
                    b17 = i10;
                    int i11 = b18;
                    pVar.f5188i = a3.getLong(i11);
                    int i12 = b19;
                    pVar.k = a3.getInt(i12);
                    int i13 = b20;
                    b19 = i12;
                    pVar.l = v.b(a3.getInt(i13));
                    b18 = i11;
                    int i14 = b4;
                    int i15 = b21;
                    pVar.m = a3.getLong(i15);
                    b21 = i15;
                    int i16 = b22;
                    pVar.n = a3.getLong(i16);
                    b22 = i16;
                    int i17 = b23;
                    pVar.o = a3.getLong(i17);
                    b23 = i17;
                    int i18 = i13;
                    int i19 = b24;
                    pVar.p = a3.getLong(i19);
                    int i20 = b25;
                    pVar.q = a3.getInt(i20) != 0;
                    pVar.j = cVar;
                    arrayList.add(pVar);
                    b25 = i20;
                    b24 = i19;
                    b14 = i8;
                    b10 = i3;
                    b12 = i4;
                    b2 = i5;
                    b3 = i6;
                    int i21 = i14;
                    b20 = i18;
                    b4 = i21;
                }
                a3.close();
                mVar.a();
                return arrayList;
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

    public final List<p> e() {
        androidx.room.m mVar;
        androidx.room.m a2 = androidx.room.m.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=1", 0);
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
        try {
            int b2 = b.b(a3, "required_network_type");
            int b3 = b.b(a3, "requires_charging");
            int b4 = b.b(a3, "requires_device_idle");
            int b5 = b.b(a3, "requires_battery_not_low");
            int b6 = b.b(a3, "requires_storage_not_low");
            int b7 = b.b(a3, "trigger_content_update_delay");
            int b8 = b.b(a3, "trigger_max_content_delay");
            int b9 = b.b(a3, "content_uri_triggers");
            int b10 = b.b(a3, "id");
            int b11 = b.b(a3, "state");
            int b12 = b.b(a3, "worker_class_name");
            int b13 = b.b(a3, "input_merger_class_name");
            int b14 = b.b(a3, "input");
            int b15 = b.b(a3, "output");
            mVar = a2;
            try {
                int b16 = b.b(a3, "initial_delay");
                int b17 = b.b(a3, "interval_duration");
                int b18 = b.b(a3, "flex_duration");
                int b19 = b.b(a3, "run_attempt_count");
                int b20 = b.b(a3, "backoff_policy");
                int b21 = b.b(a3, "backoff_delay_duration");
                int b22 = b.b(a3, "period_start_time");
                int b23 = b.b(a3, "minimum_retention_duration");
                int b24 = b.b(a3, "schedule_requested_at");
                int b25 = b.b(a3, "run_in_foreground");
                int i2 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    String string = a3.getString(b10);
                    int i3 = b10;
                    String string2 = a3.getString(b12);
                    int i4 = b12;
                    androidx.work.c cVar = new androidx.work.c();
                    int i5 = b2;
                    cVar.f5073b = v.c(a3.getInt(b2));
                    cVar.f5074c = a3.getInt(b3) != 0;
                    cVar.f5075d = a3.getInt(b4) != 0;
                    cVar.f5076e = a3.getInt(b5) != 0;
                    cVar.f5077f = a3.getInt(b6) != 0;
                    int i6 = b3;
                    cVar.f5078g = a3.getLong(b7);
                    cVar.f5079h = a3.getLong(b8);
                    cVar.f5080i = v.a(a3.getBlob(b9));
                    p pVar = new p(string, string2);
                    pVar.f5181b = v.a(a3.getInt(b11));
                    pVar.f5183d = a3.getString(b13);
                    pVar.f5184e = e.a(a3.getBlob(b14));
                    int i7 = i2;
                    pVar.f5185f = e.a(a3.getBlob(i7));
                    int i8 = b14;
                    i2 = i7;
                    int i9 = b16;
                    pVar.f5186g = a3.getLong(i9);
                    b16 = i9;
                    int i10 = b17;
                    pVar.f5187h = a3.getLong(i10);
                    b17 = i10;
                    int i11 = b18;
                    pVar.f5188i = a3.getLong(i11);
                    int i12 = b19;
                    pVar.k = a3.getInt(i12);
                    int i13 = b20;
                    b19 = i12;
                    pVar.l = v.b(a3.getInt(i13));
                    b18 = i11;
                    int i14 = b4;
                    int i15 = b21;
                    pVar.m = a3.getLong(i15);
                    b21 = i15;
                    int i16 = b22;
                    pVar.n = a3.getLong(i16);
                    b22 = i16;
                    int i17 = b23;
                    pVar.o = a3.getLong(i17);
                    b23 = i17;
                    int i18 = i13;
                    int i19 = b24;
                    pVar.p = a3.getLong(i19);
                    int i20 = b25;
                    pVar.q = a3.getInt(i20) != 0;
                    pVar.j = cVar;
                    arrayList.add(pVar);
                    b25 = i20;
                    b24 = i19;
                    b14 = i8;
                    b10 = i3;
                    b12 = i4;
                    b2 = i5;
                    b3 = i6;
                    int i21 = i14;
                    b20 = i18;
                    b4 = i21;
                }
                a3.close();
                mVar.a();
                return arrayList;
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

    public final List<p> a(long j2) {
        androidx.room.m mVar;
        androidx.room.m a2 = androidx.room.m.a("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        a2.a(1, j2);
        this.f5197a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f5197a, a2, false);
        try {
            int b2 = b.b(a3, "required_network_type");
            int b3 = b.b(a3, "requires_charging");
            int b4 = b.b(a3, "requires_device_idle");
            int b5 = b.b(a3, "requires_battery_not_low");
            int b6 = b.b(a3, "requires_storage_not_low");
            int b7 = b.b(a3, "trigger_content_update_delay");
            int b8 = b.b(a3, "trigger_max_content_delay");
            int b9 = b.b(a3, "content_uri_triggers");
            int b10 = b.b(a3, "id");
            int b11 = b.b(a3, "state");
            int b12 = b.b(a3, "worker_class_name");
            int b13 = b.b(a3, "input_merger_class_name");
            int b14 = b.b(a3, "input");
            int b15 = b.b(a3, "output");
            mVar = a2;
            try {
                int b16 = b.b(a3, "initial_delay");
                int b17 = b.b(a3, "interval_duration");
                int b18 = b.b(a3, "flex_duration");
                int b19 = b.b(a3, "run_attempt_count");
                int b20 = b.b(a3, "backoff_policy");
                int b21 = b.b(a3, "backoff_delay_duration");
                int b22 = b.b(a3, "period_start_time");
                int b23 = b.b(a3, "minimum_retention_duration");
                int b24 = b.b(a3, "schedule_requested_at");
                int b25 = b.b(a3, "run_in_foreground");
                int i2 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    String string = a3.getString(b10);
                    int i3 = b10;
                    String string2 = a3.getString(b12);
                    int i4 = b12;
                    androidx.work.c cVar = new androidx.work.c();
                    int i5 = b2;
                    cVar.f5073b = v.c(a3.getInt(b2));
                    cVar.f5074c = a3.getInt(b3) != 0;
                    cVar.f5075d = a3.getInt(b4) != 0;
                    cVar.f5076e = a3.getInt(b5) != 0;
                    cVar.f5077f = a3.getInt(b6) != 0;
                    int i6 = b3;
                    cVar.f5078g = a3.getLong(b7);
                    cVar.f5079h = a3.getLong(b8);
                    cVar.f5080i = v.a(a3.getBlob(b9));
                    p pVar = new p(string, string2);
                    pVar.f5181b = v.a(a3.getInt(b11));
                    pVar.f5183d = a3.getString(b13);
                    pVar.f5184e = e.a(a3.getBlob(b14));
                    int i7 = i2;
                    pVar.f5185f = e.a(a3.getBlob(i7));
                    int i8 = b16;
                    int i9 = b13;
                    i2 = i7;
                    pVar.f5186g = a3.getLong(i8);
                    int i10 = i8;
                    int i11 = b17;
                    pVar.f5187h = a3.getLong(i11);
                    b17 = i11;
                    int i12 = b18;
                    pVar.f5188i = a3.getLong(i12);
                    int i13 = b19;
                    pVar.k = a3.getInt(i13);
                    int i14 = b20;
                    b19 = i13;
                    pVar.l = v.b(a3.getInt(i14));
                    b18 = i12;
                    int i15 = b4;
                    int i16 = b21;
                    pVar.m = a3.getLong(i16);
                    b21 = i16;
                    int i17 = b22;
                    pVar.n = a3.getLong(i17);
                    b22 = i17;
                    int i18 = b23;
                    pVar.o = a3.getLong(i18);
                    b23 = i18;
                    int i19 = i14;
                    int i20 = b24;
                    pVar.p = a3.getLong(i20);
                    int i21 = b25;
                    pVar.q = a3.getInt(i21) != 0;
                    pVar.j = cVar;
                    arrayList.add(pVar);
                    b25 = i21;
                    b24 = i20;
                    b12 = i4;
                    b3 = i6;
                    b2 = i5;
                    b13 = i9;
                    b16 = i10;
                    b10 = i3;
                    int i22 = i15;
                    b20 = i19;
                    b4 = i22;
                }
                a3.close();
                mVar.a();
                return arrayList;
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

    public final int a(u.a aVar, String... strArr) {
        this.f5197a.assertNotSuspendingTransaction();
        StringBuilder a2 = androidx.room.b.e.a();
        a2.append("UPDATE workspec SET state=");
        a2.append("?");
        a2.append(" WHERE id IN (");
        androidx.room.b.e.a(a2, 1);
        a2.append(")");
        f compileStatement = this.f5197a.compileStatement(a2.toString());
        compileStatement.a(1, (long) v.a(aVar));
        for (int i2 = 0; i2 <= 0; i2++) {
            String str = strArr[0];
            if (str == null) {
                compileStatement.a(2);
            } else {
                compileStatement.a(2, str);
            }
        }
        this.f5197a.beginTransaction();
        try {
            int a3 = compileStatement.a();
            this.f5197a.setTransactionSuccessful();
            return a3;
        } finally {
            this.f5197a.endTransaction();
        }
    }

    /* access modifiers changed from: private */
    public void a(androidx.a.a<String, ArrayList<String>> aVar) {
        ArrayList arrayList;
        int i2;
        while (true) {
            Set<String> keySet = aVar.keySet();
            if (!keySet.isEmpty()) {
                if (aVar.size() > 999) {
                    androidx.a.a<String, ArrayList<String>> aVar2 = new androidx.a.a<>(999);
                    int size = aVar.size();
                    androidx.a.a<String, ArrayList<String>> aVar3 = aVar2;
                    int i3 = 0;
                    while (true) {
                        i2 = 0;
                        while (i3 < size) {
                            aVar3.put(aVar.b(i3), aVar.c(i3));
                            i3++;
                            i2++;
                            if (i2 == 999) {
                                a(aVar3);
                                aVar3 = new androidx.a.a<>(999);
                            }
                        }
                        break;
                    }
                    if (i2 > 0) {
                        aVar = aVar3;
                    } else {
                        return;
                    }
                } else {
                    StringBuilder a2 = androidx.room.b.e.a();
                    a2.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
                    int size2 = keySet.size();
                    androidx.room.b.e.a(a2, size2);
                    a2.append(")");
                    androidx.room.m a3 = androidx.room.m.a(a2.toString(), size2 + 0);
                    int i4 = 1;
                    for (String next : keySet) {
                        if (next == null) {
                            a3.a(i4);
                        } else {
                            a3.a(i4, next);
                        }
                        i4++;
                    }
                    Cursor a4 = androidx.room.b.c.a(this.f5197a, a3, false);
                    try {
                        int a5 = b.a(a4, "work_spec_id");
                        if (a5 != -1) {
                            while (a4.moveToNext()) {
                                if (!a4.isNull(a5) && (arrayList = aVar.get(a4.getString(a5))) != null) {
                                    arrayList.add(a4.getString(0));
                                }
                            }
                            a4.close();
                            return;
                        }
                        return;
                    } finally {
                        a4.close();
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(androidx.a.a<String, ArrayList<e>> aVar) {
        ArrayList arrayList;
        int i2;
        while (true) {
            Set<String> keySet = aVar.keySet();
            if (!keySet.isEmpty()) {
                if (aVar.size() > 999) {
                    androidx.a.a<String, ArrayList<e>> aVar2 = new androidx.a.a<>(999);
                    int size = aVar.size();
                    androidx.a.a<String, ArrayList<e>> aVar3 = aVar2;
                    int i3 = 0;
                    while (true) {
                        i2 = 0;
                        while (i3 < size) {
                            aVar3.put(aVar.b(i3), aVar.c(i3));
                            i3++;
                            i2++;
                            if (i2 == 999) {
                                b(aVar3);
                                aVar3 = new androidx.a.a<>(999);
                            }
                        }
                        break;
                    }
                    if (i2 > 0) {
                        aVar = aVar3;
                    } else {
                        return;
                    }
                } else {
                    StringBuilder a2 = androidx.room.b.e.a();
                    a2.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
                    int size2 = keySet.size();
                    androidx.room.b.e.a(a2, size2);
                    a2.append(")");
                    androidx.room.m a3 = androidx.room.m.a(a2.toString(), size2 + 0);
                    int i4 = 1;
                    for (String next : keySet) {
                        if (next == null) {
                            a3.a(i4);
                        } else {
                            a3.a(i4, next);
                        }
                        i4++;
                    }
                    Cursor a4 = androidx.room.b.c.a(this.f5197a, a3, false);
                    try {
                        int a5 = b.a(a4, "work_spec_id");
                        if (a5 != -1) {
                            while (a4.moveToNext()) {
                                if (!a4.isNull(a5) && (arrayList = aVar.get(a4.getString(a5))) != null) {
                                    arrayList.add(e.a(a4.getBlob(0)));
                                }
                            }
                            a4.close();
                            return;
                        }
                        return;
                    } finally {
                        a4.close();
                    }
                }
            } else {
                return;
            }
        }
    }
}
