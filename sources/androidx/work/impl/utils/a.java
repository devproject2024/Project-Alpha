package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.b;
import androidx.work.impl.b.d;
import androidx.work.impl.b.q;
import androidx.work.impl.c;
import androidx.work.impl.e;
import androidx.work.impl.f;
import androidx.work.impl.j;
import androidx.work.o;
import androidx.work.u;
import java.util.LinkedList;
import java.util.UUID;

public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final c f5397a = new c();

    /* access modifiers changed from: package-private */
    public abstract void a();

    public void run() {
        try {
            a();
            this.f5397a.a(o.f5507a);
        } catch (Throwable th) {
            this.f5397a.a(new o.a.C0079a(th));
        }
    }

    public static a a(final UUID uuid, final j jVar) {
        return new a() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: package-private */
            public final void a() {
                WorkDatabase workDatabase = j.this.f5361c;
                workDatabase.beginTransaction();
                try {
                    a(j.this, uuid.toString());
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    a(j.this);
                } catch (Throwable th) {
                    workDatabase.endTransaction();
                    throw th;
                }
            }
        };
    }

    public static a a(final String str, final j jVar) {
        return new a() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: package-private */
            public final void a() {
                WorkDatabase workDatabase = j.this.f5361c;
                workDatabase.beginTransaction();
                try {
                    for (String a2 : workDatabase.b().i(str)) {
                        a(j.this, a2);
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    a(j.this);
                } catch (Throwable th) {
                    workDatabase.endTransaction();
                    throw th;
                }
            }
        };
    }

    public static a a(final String str, final j jVar, final boolean z) {
        return new a() {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: package-private */
            public final void a() {
                WorkDatabase workDatabase = j.this.f5361c;
                workDatabase.beginTransaction();
                try {
                    for (String a2 : workDatabase.b().j(str)) {
                        a(j.this, a2);
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    if (z) {
                        a(j.this);
                    }
                } catch (Throwable th) {
                    workDatabase.endTransaction();
                    throw th;
                }
            }
        };
    }

    public static a b(final j jVar) {
        return new a() {
            /* access modifiers changed from: package-private */
            public final void a() {
                WorkDatabase workDatabase = j.this.f5361c;
                workDatabase.beginTransaction();
                try {
                    for (String a2 : workDatabase.b().a()) {
                        a(j.this, a2);
                    }
                    f fVar = new f(j.this.f5361c);
                    fVar.f5449a.h().a(new d("last_cancel_all_time_ms", System.currentTimeMillis()));
                    workDatabase.setTransactionSuccessful();
                } finally {
                    workDatabase.endTransaction();
                }
            }
        };
    }

    static void a(j jVar, String str) {
        WorkDatabase workDatabase = jVar.f5361c;
        q b2 = workDatabase.b();
        b c2 = workDatabase.c();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            u.a f2 = b2.f(str2);
            if (!(f2 == u.a.SUCCEEDED || f2 == u.a.FAILED)) {
                b2.a(u.a.CANCELLED, str2);
            }
            linkedList.addAll(c2.b(str2));
        }
        jVar.f5364f.c(str);
        for (e a2 : jVar.f5363e) {
            a2.a(str);
        }
    }

    static void a(j jVar) {
        f.a(jVar.f5360b, jVar.f5361c, jVar.f5363e);
    }
}
