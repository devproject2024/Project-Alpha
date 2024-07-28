package androidx.work.impl;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import androidx.sqlite.db.c;
import androidx.work.impl.b.b;
import androidx.work.impl.b.e;
import androidx.work.impl.b.h;
import androidx.work.impl.b.k;
import androidx.work.impl.b.n;
import androidx.work.impl.b.q;
import androidx.work.impl.b.t;
import androidx.work.impl.h;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class WorkDatabase extends j {

    /* renamed from: a  reason: collision with root package name */
    private static final long f5099a = TimeUnit.DAYS.toMillis(7);

    public abstract q b();

    public abstract b c();

    public abstract t d();

    public abstract h e();

    public abstract k f();

    public abstract n g();

    public abstract e h();

    public static WorkDatabase a(final Context context, Executor executor, boolean z) {
        j.a<WorkDatabase> aVar;
        Class<WorkDatabase> cls = WorkDatabase.class;
        if (z) {
            aVar = i.a(context, cls).a();
        } else {
            aVar = i.a(context, cls, i.a());
            aVar.a((c.C0072c) new c.C0072c() {
                public final c a(c.b bVar) {
                    c.b.a a2 = c.b.a(context);
                    a2.a(bVar.f4543b).a(bVar.f4544c).b();
                    return new androidx.sqlite.db.framework.c().a(a2.a());
                }
            });
        }
        return aVar.a(executor).a((j.b) new j.b() {
            public final void a(androidx.sqlite.db.b bVar) {
                super.a(bVar);
                bVar.a();
                try {
                    bVar.c(WorkDatabase.a());
                    bVar.c();
                } finally {
                    bVar.b();
                }
            }
        }).a(h.f5349a).a(new h.a(context, 2, 3)).a(h.f5350b).a(h.f5351c).a(new h.a(context, 5, 6)).a(h.f5352d).a(h.f5353e).a(h.f5354f).a(new h.b(context)).a(new h.a(context, 10, 11)).b().c();
    }

    static String a() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + (System.currentTimeMillis() - f5099a) + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }
}
