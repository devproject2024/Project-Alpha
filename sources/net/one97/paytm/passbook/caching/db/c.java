package net.one97.paytm.passbook.caching.db;

import androidx.room.j;
import androidx.room.q;
import androidx.sqlite.db.f;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final j f57120a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.c<a> f57121b;

    /* renamed from: c  reason: collision with root package name */
    private final q f57122c;

    /* renamed from: d  reason: collision with root package name */
    private final q f57123d;

    public c(j jVar) {
        this.f57120a = jVar;
        this.f57121b = new androidx.room.c<a>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `PassbookCache` (`id`,`request_type`,`request_url`,`query_params`,`header`,`body_data`,`response`,`last_request_time`,`max_age`,`hit_count`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                a aVar = (a) obj;
                if (aVar.f57111a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, (long) aVar.f57111a.intValue());
                }
                if (aVar.f57112b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, aVar.f57112b);
                }
                if (aVar.f57113c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, aVar.f57113c);
                }
                if (aVar.f57114d == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, aVar.f57114d);
                }
                if (aVar.f57115e == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, aVar.f57115e);
                }
                if (aVar.f57116f == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, aVar.f57116f);
                }
                if (aVar.f57117g == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, aVar.f57117g);
                }
                fVar.a(8, aVar.f57118h);
                fVar.a(9, aVar.f57119i);
                fVar.a(10, (long) aVar.j);
            }
        };
        this.f57122c = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM PassbookCache";
            }
        };
        this.f57123d = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM PassbookCache WHERE request_type=? AND request_url=? AND body_data=?";
            }
        };
    }

    public final void a(a aVar) {
        this.f57120a.assertNotSuspendingTransaction();
        this.f57120a.beginTransaction();
        try {
            this.f57121b.insert(aVar);
            this.f57120a.setTransactionSuccessful();
        } finally {
            this.f57120a.endTransaction();
        }
    }

    public final void a(String str, String str2, String str3) {
        this.f57120a.assertNotSuspendingTransaction();
        f acquire = this.f57123d.acquire();
        if (str == null) {
            acquire.a(1);
        } else {
            acquire.a(1, str);
        }
        if (str2 == null) {
            acquire.a(2);
        } else {
            acquire.a(2, str2);
        }
        if (str3 == null) {
            acquire.a(3);
        } else {
            acquire.a(3, str3);
        }
        this.f57120a.beginTransaction();
        try {
            acquire.a();
            this.f57120a.setTransactionSuccessful();
        } finally {
            this.f57120a.endTransaction();
            this.f57123d.release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: net.one97.paytm.passbook.caching.db.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: net.one97.paytm.passbook.caching.db.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: net.one97.paytm.passbook.caching.db.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: net.one97.paytm.passbook.caching.db.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: net.one97.paytm.passbook.caching.db.a} */
    /* JADX WARNING: type inference failed for: r14v2, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final net.one97.paytm.passbook.caching.db.a b(java.lang.String r29, java.lang.String r30, java.lang.String r31) {
        /*
            r28 = this;
            r1 = r28
            r0 = r29
            r2 = r30
            r3 = r31
            r4 = 3
            java.lang.String r5 = "SELECT * FROM PassbookCache WHERE request_type=? AND request_url=? AND body_data=? LIMIT 1"
            androidx.room.m r5 = androidx.room.m.a((java.lang.String) r5, (int) r4)
            r6 = 1
            if (r0 != 0) goto L_0x0017
            int[] r0 = r5.f4477f
            r0[r6] = r6
            goto L_0x001a
        L_0x0017:
            r5.a((int) r6, (java.lang.String) r0)
        L_0x001a:
            r0 = 2
            if (r2 != 0) goto L_0x0022
            int[] r2 = r5.f4477f
            r2[r0] = r6
            goto L_0x0025
        L_0x0022:
            r5.a((int) r0, (java.lang.String) r2)
        L_0x0025:
            if (r3 != 0) goto L_0x002c
            int[] r0 = r5.f4477f
            r0[r4] = r6
            goto L_0x002f
        L_0x002c:
            r5.a((int) r4, (java.lang.String) r3)
        L_0x002f:
            androidx.room.j r0 = r1.f57120a
            r0.assertNotSuspendingTransaction()
            androidx.room.j r0 = r1.f57120a
            r2 = 0
            android.database.Cursor r2 = androidx.room.b.c.a(r0, r5, r2)
            java.lang.String r0 = "id"
            int r0 = androidx.room.b.b.b(r2, r0)     // Catch:{ all -> 0x00c2 }
            java.lang.String r3 = "request_type"
            int r3 = androidx.room.b.b.b(r2, r3)     // Catch:{ all -> 0x00c2 }
            java.lang.String r4 = "request_url"
            int r4 = androidx.room.b.b.b(r2, r4)     // Catch:{ all -> 0x00c2 }
            java.lang.String r6 = "query_params"
            int r6 = androidx.room.b.b.b(r2, r6)     // Catch:{ all -> 0x00c2 }
            java.lang.String r7 = "header"
            int r7 = androidx.room.b.b.b(r2, r7)     // Catch:{ all -> 0x00c2 }
            java.lang.String r8 = "body_data"
            int r8 = androidx.room.b.b.b(r2, r8)     // Catch:{ all -> 0x00c2 }
            java.lang.String r9 = "response"
            int r9 = androidx.room.b.b.b(r2, r9)     // Catch:{ all -> 0x00c2 }
            java.lang.String r10 = "last_request_time"
            int r10 = androidx.room.b.b.b(r2, r10)     // Catch:{ all -> 0x00c2 }
            java.lang.String r11 = "max_age"
            int r11 = androidx.room.b.b.b(r2, r11)     // Catch:{ all -> 0x00c2 }
            java.lang.String r12 = "hit_count"
            int r12 = androidx.room.b.b.b(r2, r12)     // Catch:{ all -> 0x00c2 }
            boolean r13 = r2.moveToFirst()     // Catch:{ all -> 0x00c2 }
            r14 = 0
            if (r13 == 0) goto L_0x00bb
            boolean r13 = r2.isNull(r0)     // Catch:{ all -> 0x00c2 }
            if (r13 == 0) goto L_0x0087
        L_0x0084:
            r16 = r14
            goto L_0x0090
        L_0x0087:
            int r0 = r2.getInt(r0)     // Catch:{ all -> 0x00c2 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00c2 }
            goto L_0x0084
        L_0x0090:
            java.lang.String r17 = r2.getString(r3)     // Catch:{ all -> 0x00c2 }
            java.lang.String r18 = r2.getString(r4)     // Catch:{ all -> 0x00c2 }
            java.lang.String r19 = r2.getString(r6)     // Catch:{ all -> 0x00c2 }
            java.lang.String r20 = r2.getString(r7)     // Catch:{ all -> 0x00c2 }
            java.lang.String r21 = r2.getString(r8)     // Catch:{ all -> 0x00c2 }
            java.lang.String r22 = r2.getString(r9)     // Catch:{ all -> 0x00c2 }
            long r23 = r2.getLong(r10)     // Catch:{ all -> 0x00c2 }
            long r25 = r2.getLong(r11)     // Catch:{ all -> 0x00c2 }
            int r27 = r2.getInt(r12)     // Catch:{ all -> 0x00c2 }
            net.one97.paytm.passbook.caching.db.a r0 = new net.one97.paytm.passbook.caching.db.a     // Catch:{ all -> 0x00c2 }
            r15 = r0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r25, r27)     // Catch:{ all -> 0x00c2 }
            r14 = r0
        L_0x00bb:
            r2.close()
            r5.a()
            return r14
        L_0x00c2:
            r0 = move-exception
            r2.close()
            r5.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.caching.db.c.b(java.lang.String, java.lang.String, java.lang.String):net.one97.paytm.passbook.caching.db.a");
    }
}
