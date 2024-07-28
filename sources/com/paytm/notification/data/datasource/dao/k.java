package com.paytm.notification.data.datasource.dao;

import android.database.Cursor;
import androidx.room.b.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;

public final class k implements j {

    /* renamed from: a  reason: collision with root package name */
    private final j f43164a;

    /* renamed from: b  reason: collision with root package name */
    private final c<l> f43165b;

    /* renamed from: c  reason: collision with root package name */
    private final q f43166c;

    /* renamed from: d  reason: collision with root package name */
    private final q f43167d;

    public k(j jVar) {
        this.f43164a = jVar;
        this.f43165b = new c<l>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `PushData` (`id`,`pushIdentifier`,`expiry`) VALUES (nullif(?, 0),?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                l lVar = (l) obj;
                fVar.a(1, lVar.f43171a);
                if (lVar.f43172b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, lVar.f43172b);
                }
                fVar.a(3, lVar.f43173c);
            }
        };
        this.f43166c = new q(jVar) {
            public final String createQuery() {
                return "Delete FROM PushData WHERE expiry <= ?";
            }
        };
        this.f43167d = new q(jVar) {
            public final String createQuery() {
                return "Delete FROM PushData";
            }
        };
    }

    public final void a(l lVar) {
        this.f43164a.assertNotSuspendingTransaction();
        this.f43164a.beginTransaction();
        try {
            this.f43165b.insert(lVar);
            this.f43164a.setTransactionSuccessful();
        } finally {
            this.f43164a.endTransaction();
        }
    }

    public final void a(long j) {
        this.f43164a.assertNotSuspendingTransaction();
        f acquire = this.f43166c.acquire();
        acquire.a(1, j);
        this.f43164a.beginTransaction();
        try {
            acquire.a();
            this.f43164a.setTransactionSuccessful();
        } finally {
            this.f43164a.endTransaction();
            this.f43166c.release(acquire);
        }
    }

    public final List<l> a() {
        m a2 = m.a("SELECT * FROM PushData", 0);
        this.f43164a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43164a, a2, false);
        try {
            int b2 = b.b(a3, "id");
            int b3 = b.b(a3, "pushIdentifier");
            int b4 = b.b(a3, "expiry");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                l lVar = new l(a3.getString(b3), a3.getLong(b4));
                lVar.f43171a = a3.getLong(b2);
                arrayList.add(lVar);
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
