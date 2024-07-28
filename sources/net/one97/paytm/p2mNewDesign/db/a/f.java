package net.one97.paytm.p2mNewDesign.db.a;

import androidx.room.c;
import androidx.room.j;
import androidx.room.q;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final j f51226a;

    /* renamed from: b  reason: collision with root package name */
    private final c f51227b;

    /* renamed from: c  reason: collision with root package name */
    private final q f51228c;

    public f(j jVar) {
        this.f51226a = jVar;
        this.f51227b = new c<net.one97.paytm.p2mNewDesign.db.b.c>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `payment_instrument_cache`(`row_id`,`map_id`,`instrument_type`,`instrument_priority`,`instrument_detail`,`last_updated`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(androidx.sqlite.db.f fVar, Object obj) {
                net.one97.paytm.p2mNewDesign.db.b.c cVar = (net.one97.paytm.p2mNewDesign.db.b.c) obj;
                fVar.a(1, cVar.f51241a);
                fVar.a(2, cVar.f51242b);
                if (cVar.f51243c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, cVar.f51243c);
                }
                fVar.a(4, (long) cVar.f51244d);
                if (cVar.f51245e == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, cVar.f51245e);
                }
                fVar.a(6, cVar.f51246f);
            }
        };
        this.f51228c = new q(jVar) {
            public final String createQuery() {
                return "Delete from payment_instrument_cache where rowId = ?";
            }
        };
    }

    public final void a(net.one97.paytm.p2mNewDesign.db.b.c cVar) {
        this.f51226a.beginTransaction();
        try {
            this.f51227b.insert(cVar);
            this.f51226a.setTransactionSuccessful();
        } finally {
            this.f51226a.endTransaction();
        }
    }

    public final void a(long j) {
        androidx.sqlite.db.f acquire = this.f51228c.acquire();
        this.f51226a.beginTransaction();
        try {
            acquire.a(1, j);
            acquire.a();
            this.f51226a.setTransactionSuccessful();
        } finally {
            this.f51226a.endTransaction();
            this.f51228c.release(acquire);
        }
    }
}
