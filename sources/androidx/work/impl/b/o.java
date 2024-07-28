package androidx.work.impl.b;

import androidx.room.c;
import androidx.room.j;
import androidx.room.q;
import androidx.sqlite.db.f;
import androidx.work.e;

public final class o implements n {

    /* renamed from: a  reason: collision with root package name */
    private final j f5173a;

    /* renamed from: b  reason: collision with root package name */
    private final c<m> f5174b;

    /* renamed from: c  reason: collision with root package name */
    private final q f5175c;

    /* renamed from: d  reason: collision with root package name */
    private final q f5176d;

    public o(j jVar) {
        this.f5173a = jVar;
        this.f5174b = new c<m>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                m mVar = (m) obj;
                if (mVar.f5171a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, mVar.f5171a);
                }
                byte[] a2 = e.a(mVar.f5172b);
                if (a2 == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, a2);
                }
            }
        };
        this.f5175c = new q(jVar) {
            public final String createQuery() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.f5176d = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    public final void a(m mVar) {
        this.f5173a.assertNotSuspendingTransaction();
        this.f5173a.beginTransaction();
        try {
            this.f5174b.insert(mVar);
            this.f5173a.setTransactionSuccessful();
        } finally {
            this.f5173a.endTransaction();
        }
    }

    public final void a(String str) {
        this.f5173a.assertNotSuspendingTransaction();
        f acquire = this.f5175c.acquire();
        if (str == null) {
            acquire.a(1);
        } else {
            acquire.a(1, str);
        }
        this.f5173a.beginTransaction();
        try {
            acquire.a();
            this.f5173a.setTransactionSuccessful();
        } finally {
            this.f5173a.endTransaction();
            this.f5175c.release(acquire);
        }
    }

    public final void a() {
        this.f5173a.assertNotSuspendingTransaction();
        f acquire = this.f5176d.acquire();
        this.f5173a.beginTransaction();
        try {
            acquire.a();
            this.f5173a.setTransactionSuccessful();
        } finally {
            this.f5173a.endTransaction();
            this.f5176d.release(acquire);
        }
    }
}
