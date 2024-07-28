package com.paytm.notification.data.datasource.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.b.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    final j f43120a;

    /* renamed from: b  reason: collision with root package name */
    private final c<f> f43121b;

    /* renamed from: c  reason: collision with root package name */
    private final q f43122c;

    /* renamed from: d  reason: collision with root package name */
    private final q f43123d;

    /* renamed from: e  reason: collision with root package name */
    private final q f43124e;

    /* renamed from: f  reason: collision with root package name */
    private final q f43125f;

    public e(j jVar) {
        this.f43120a = jVar;
        this.f43121b = new c<f>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `InboxData` (`status`,`date`,`priority`,`customerId`,`pushId`,`content`,`extras`,`expiry_date`,`state_changed`,`expired`,`title`,`body`,`imageUrl`,`deeplink`,`received_date`,`campaignId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                f fVar2 = (f) obj;
                if (fVar2.f43133a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, (long) fVar2.f43133a.intValue());
                }
                if (fVar2.f43134b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, fVar2.f43134b);
                }
                if (fVar2.f43135c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, (long) fVar2.f43135c.intValue());
                }
                if (fVar2.f43136d == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, fVar2.f43136d);
                }
                if (fVar2.f43137e == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, fVar2.f43137e);
                }
                if (fVar2.f43138f == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, fVar2.f43138f);
                }
                if (fVar2.f43139g == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, fVar2.f43139g);
                }
                fVar.a(8, fVar2.f43140h);
                fVar.a(9, fVar2.f43141i ? 1 : 0);
                fVar.a(10, fVar2.j ? 1 : 0);
                if (fVar2.k == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, fVar2.k);
                }
                if (fVar2.l == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, fVar2.l);
                }
                if (fVar2.m == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, fVar2.m);
                }
                if (fVar2.n == null) {
                    fVar.a(14);
                } else {
                    fVar.a(14, fVar2.n);
                }
                fVar.a(15, fVar2.o);
                if (fVar2.p == null) {
                    fVar.a(16);
                } else {
                    fVar.a(16, fVar2.p);
                }
            }
        };
        this.f43122c = new q(jVar) {
            public final String createQuery() {
                return "Update InboxData SET status = ? , state_changed = ? WHERE customerId = ? AND pushId = ?";
            }
        };
        this.f43123d = new q(jVar) {
            public final String createQuery() {
                return "Update InboxData SET status = ? , state_changed = ? WHERE  customerId = ? AND status != ?";
            }
        };
        this.f43124e = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM InboxData WHERE customerId = ? AND state_changed = ? AND (expired = ? OR  status = ?)";
            }
        };
        this.f43125f = new q(jVar) {
            public final String createQuery() {
                return "DELETE FROM InboxData";
            }
        };
    }

    public final void a(List<f> list) {
        this.f43120a.assertNotSuspendingTransaction();
        this.f43120a.beginTransaction();
        try {
            this.f43121b.insert(list);
            this.f43120a.setTransactionSuccessful();
        } finally {
            this.f43120a.endTransaction();
        }
    }

    public final void a(String str, String str2) {
        this.f43120a.assertNotSuspendingTransaction();
        f acquire = this.f43122c.acquire();
        acquire.a(1, 1);
        acquire.a(2, 1);
        if (str2 == null) {
            acquire.a(3);
        } else {
            acquire.a(3, str2);
        }
        if (str == null) {
            acquire.a(4);
        } else {
            acquire.a(4, str);
        }
        this.f43120a.beginTransaction();
        try {
            acquire.a();
            this.f43120a.setTransactionSuccessful();
        } finally {
            this.f43120a.endTransaction();
            this.f43122c.release(acquire);
        }
    }

    public final void c(String str) {
        this.f43120a.assertNotSuspendingTransaction();
        f acquire = this.f43124e.acquire();
        if (str == null) {
            acquire.a(1);
        } else {
            acquire.a(1, str);
        }
        acquire.a(2, 0);
        acquire.a(3, 1);
        acquire.a(4, 3);
        this.f43120a.beginTransaction();
        try {
            acquire.a();
            this.f43120a.setTransactionSuccessful();
        } finally {
            this.f43120a.endTransaction();
            this.f43124e.release(acquire);
        }
    }

    public final void c() {
        this.f43120a.assertNotSuspendingTransaction();
        f acquire = this.f43125f.acquire();
        this.f43120a.beginTransaction();
        try {
            acquire.a();
            this.f43120a.setTransactionSuccessful();
        } finally {
            this.f43120a.endTransaction();
            this.f43125f.release(acquire);
        }
    }

    public final List<f> a(String str) {
        m mVar;
        int i2;
        Integer num;
        String str2 = str;
        m a2 = m.a("SELECT * FROM InboxData WHERE customerId = ? AND status > -1  AND expired = ?", 2);
        if (str2 == null) {
            a2.a(1);
        } else {
            a2.a(1, str2);
        }
        a2.a(2, 0);
        this.f43120a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43120a, a2, false);
        try {
            int b2 = b.b(a3, "status");
            int b3 = b.b(a3, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            int b4 = b.b(a3, "priority");
            int b5 = b.b(a3, "customerId");
            int b6 = b.b(a3, "pushId");
            int b7 = b.b(a3, "content");
            int b8 = b.b(a3, "extras");
            int b9 = b.b(a3, "expiry_date");
            int b10 = b.b(a3, "state_changed");
            int b11 = b.b(a3, "expired");
            int b12 = b.b(a3, "title");
            int b13 = b.b(a3, "body");
            int b14 = b.b(a3, "imageUrl");
            int b15 = b.b(a3, "deeplink");
            mVar = a2;
            try {
                int b16 = b.b(a3, "received_date");
                int b17 = b.b(a3, "campaignId");
                int i3 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    f fVar = new f();
                    Integer num2 = null;
                    if (a3.isNull(b2)) {
                        i2 = b2;
                        num = null;
                    } else {
                        i2 = b2;
                        num = Integer.valueOf(a3.getInt(b2));
                    }
                    fVar.f43133a = num;
                    fVar.f43134b = a3.getString(b3);
                    if (!a3.isNull(b4)) {
                        num2 = Integer.valueOf(a3.getInt(b4));
                    }
                    fVar.f43135c = num2;
                    fVar.a(a3.getString(b5));
                    fVar.b(a3.getString(b6));
                    fVar.f43138f = a3.getString(b7);
                    fVar.f43139g = a3.getString(b8);
                    int i4 = b3;
                    int i5 = b4;
                    fVar.f43140h = a3.getLong(b9);
                    fVar.f43141i = a3.getInt(b10) != 0;
                    fVar.j = a3.getInt(b11) != 0;
                    fVar.c(a3.getString(b12));
                    fVar.d(a3.getString(b13));
                    fVar.m = a3.getString(b14);
                    int i6 = i3;
                    fVar.e(a3.getString(i6));
                    int i7 = b6;
                    int i8 = b16;
                    int i9 = b5;
                    fVar.o = a3.getLong(i8);
                    int i10 = b17;
                    fVar.p = a3.getString(i10);
                    arrayList.add(fVar);
                    b17 = i10;
                    b5 = i9;
                    b6 = i7;
                    i3 = i6;
                    b16 = i8;
                    b4 = i5;
                    b3 = i4;
                    b2 = i2;
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

    public final List<f> b(String str) {
        m mVar;
        int i2;
        Integer num;
        String str2 = str;
        m a2 = m.a("SELECT * FROM InboxData WHERE customerId = ? AND status != ? AND expired = ?", 3);
        if (str2 == null) {
            a2.a(1);
        } else {
            a2.a(1, str2);
        }
        a2.a(2, 3);
        a2.a(3, 0);
        this.f43120a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43120a, a2, false);
        try {
            int b2 = b.b(a3, "status");
            int b3 = b.b(a3, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            int b4 = b.b(a3, "priority");
            int b5 = b.b(a3, "customerId");
            int b6 = b.b(a3, "pushId");
            int b7 = b.b(a3, "content");
            int b8 = b.b(a3, "extras");
            int b9 = b.b(a3, "expiry_date");
            int b10 = b.b(a3, "state_changed");
            int b11 = b.b(a3, "expired");
            int b12 = b.b(a3, "title");
            int b13 = b.b(a3, "body");
            int b14 = b.b(a3, "imageUrl");
            int b15 = b.b(a3, "deeplink");
            mVar = a2;
            try {
                int b16 = b.b(a3, "received_date");
                int b17 = b.b(a3, "campaignId");
                int i3 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    f fVar = new f();
                    Integer num2 = null;
                    if (a3.isNull(b2)) {
                        i2 = b2;
                        num = null;
                    } else {
                        i2 = b2;
                        num = Integer.valueOf(a3.getInt(b2));
                    }
                    fVar.f43133a = num;
                    fVar.f43134b = a3.getString(b3);
                    if (!a3.isNull(b4)) {
                        num2 = Integer.valueOf(a3.getInt(b4));
                    }
                    fVar.f43135c = num2;
                    fVar.a(a3.getString(b5));
                    fVar.b(a3.getString(b6));
                    fVar.f43138f = a3.getString(b7);
                    fVar.f43139g = a3.getString(b8);
                    int i4 = b3;
                    int i5 = b4;
                    fVar.f43140h = a3.getLong(b9);
                    fVar.f43141i = a3.getInt(b10) != 0;
                    fVar.j = a3.getInt(b11) != 0;
                    fVar.c(a3.getString(b12));
                    fVar.d(a3.getString(b13));
                    fVar.m = a3.getString(b14);
                    int i6 = i3;
                    fVar.e(a3.getString(i6));
                    int i7 = b6;
                    int i8 = b16;
                    int i9 = b5;
                    fVar.o = a3.getLong(i8);
                    int i10 = b17;
                    fVar.p = a3.getString(i10);
                    arrayList.add(fVar);
                    b17 = i10;
                    b5 = i9;
                    b6 = i7;
                    i3 = i6;
                    b16 = i8;
                    b4 = i5;
                    b3 = i4;
                    b2 = i2;
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

    public final LiveData<List<f>> a() {
        final m a2 = m.a("SELECT * FROM InboxData WHERE status != ? AND expired = ?", 2);
        a2.a(1, 3);
        a2.a(2, 0);
        return this.f43120a.getInvalidationTracker().a(new String[]{"InboxData"}, false, new Callable<List<f>>() {
            /* access modifiers changed from: private */
            /* renamed from: a */
            public List<f> call() throws Exception {
                int i2;
                Integer num;
                Cursor a2 = androidx.room.b.c.a(e.this.f43120a, a2, false);
                try {
                    int b2 = b.b(a2, "status");
                    int b3 = b.b(a2, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
                    int b4 = b.b(a2, "priority");
                    int b5 = b.b(a2, "customerId");
                    int b6 = b.b(a2, "pushId");
                    int b7 = b.b(a2, "content");
                    int b8 = b.b(a2, "extras");
                    int b9 = b.b(a2, "expiry_date");
                    int b10 = b.b(a2, "state_changed");
                    int b11 = b.b(a2, "expired");
                    int b12 = b.b(a2, "title");
                    int b13 = b.b(a2, "body");
                    int b14 = b.b(a2, "imageUrl");
                    int b15 = b.b(a2, "deeplink");
                    int b16 = b.b(a2, "received_date");
                    int b17 = b.b(a2, "campaignId");
                    int i3 = b15;
                    ArrayList arrayList = new ArrayList(a2.getCount());
                    while (a2.moveToNext()) {
                        f fVar = new f();
                        Integer num2 = null;
                        if (a2.isNull(b2)) {
                            i2 = b2;
                            num = null;
                        } else {
                            i2 = b2;
                            num = Integer.valueOf(a2.getInt(b2));
                        }
                        fVar.f43133a = num;
                        fVar.f43134b = a2.getString(b3);
                        if (!a2.isNull(b4)) {
                            num2 = Integer.valueOf(a2.getInt(b4));
                        }
                        fVar.f43135c = num2;
                        fVar.a(a2.getString(b5));
                        fVar.b(a2.getString(b6));
                        fVar.f43138f = a2.getString(b7);
                        fVar.f43139g = a2.getString(b8);
                        int i4 = b3;
                        int i5 = b4;
                        fVar.f43140h = a2.getLong(b9);
                        boolean z = true;
                        fVar.f43141i = a2.getInt(b10) != 0;
                        if (a2.getInt(b11) == 0) {
                            z = false;
                        }
                        fVar.j = z;
                        fVar.c(a2.getString(b12));
                        fVar.d(a2.getString(b13));
                        fVar.m = a2.getString(b14);
                        int i6 = i3;
                        fVar.e(a2.getString(i6));
                        int i7 = b6;
                        int i8 = b16;
                        int i9 = b5;
                        fVar.o = a2.getLong(i8);
                        int i10 = b17;
                        fVar.p = a2.getString(i10);
                        arrayList.add(fVar);
                        b17 = i10;
                        b5 = i9;
                        b6 = i7;
                        i3 = i6;
                        b16 = i8;
                        b4 = i5;
                        b3 = i4;
                        b2 = i2;
                    }
                    return arrayList;
                } finally {
                    a2.close();
                }
            }

            /* access modifiers changed from: protected */
            public final void finalize() {
                a2.a();
            }
        });
    }

    public final List<f> a(String str, int i2) {
        m mVar;
        int i3;
        Integer num;
        String str2 = str;
        m a2 = m.a("SELECT * FROM InboxData WHERE customerId = ? AND state_changed = ? AND status = ?", 3);
        if (str2 == null) {
            a2.a(1);
        } else {
            a2.a(1, str2);
        }
        a2.a(2, 1);
        a2.a(3, (long) i2);
        this.f43120a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43120a, a2, false);
        try {
            int b2 = b.b(a3, "status");
            int b3 = b.b(a3, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            int b4 = b.b(a3, "priority");
            int b5 = b.b(a3, "customerId");
            int b6 = b.b(a3, "pushId");
            int b7 = b.b(a3, "content");
            int b8 = b.b(a3, "extras");
            int b9 = b.b(a3, "expiry_date");
            int b10 = b.b(a3, "state_changed");
            int b11 = b.b(a3, "expired");
            int b12 = b.b(a3, "title");
            int b13 = b.b(a3, "body");
            int b14 = b.b(a3, "imageUrl");
            int b15 = b.b(a3, "deeplink");
            mVar = a2;
            try {
                int b16 = b.b(a3, "received_date");
                int b17 = b.b(a3, "campaignId");
                int i4 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    f fVar = new f();
                    Integer num2 = null;
                    if (a3.isNull(b2)) {
                        i3 = b2;
                        num = null;
                    } else {
                        i3 = b2;
                        num = Integer.valueOf(a3.getInt(b2));
                    }
                    fVar.f43133a = num;
                    fVar.f43134b = a3.getString(b3);
                    if (!a3.isNull(b4)) {
                        num2 = Integer.valueOf(a3.getInt(b4));
                    }
                    fVar.f43135c = num2;
                    fVar.a(a3.getString(b5));
                    fVar.b(a3.getString(b6));
                    fVar.f43138f = a3.getString(b7);
                    fVar.f43139g = a3.getString(b8);
                    int i5 = b3;
                    int i6 = b4;
                    fVar.f43140h = a3.getLong(b9);
                    fVar.f43141i = a3.getInt(b10) != 0;
                    fVar.j = a3.getInt(b11) != 0;
                    fVar.c(a3.getString(b12));
                    fVar.d(a3.getString(b13));
                    fVar.m = a3.getString(b14);
                    int i7 = i4;
                    fVar.e(a3.getString(i7));
                    int i8 = b16;
                    int i9 = b5;
                    int i10 = b6;
                    fVar.o = a3.getLong(i8);
                    int i11 = b17;
                    fVar.p = a3.getString(i11);
                    arrayList.add(fVar);
                    b17 = i11;
                    b6 = i10;
                    b5 = i9;
                    i4 = i7;
                    b16 = i8;
                    b4 = i6;
                    b3 = i5;
                    b2 = i3;
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

    public final List<String> b() {
        m a2 = m.a("SELECT DISTINCT customerId FROM InboxData", 0);
        this.f43120a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43120a, a2, false);
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

    public final void a(List<String> list, String str) {
        this.f43120a.assertNotSuspendingTransaction();
        StringBuilder a2 = androidx.room.b.e.a();
        a2.append("Update InboxData SET state_changed = ");
        a2.append("?");
        a2.append(" WHERE customerId = ");
        a2.append("?");
        a2.append(" AND pushId IN (");
        androidx.room.b.e.a(a2, list.size());
        a2.append(")");
        f compileStatement = this.f43120a.compileStatement(a2.toString());
        compileStatement.a(1, 0);
        if (str == null) {
            compileStatement.a(2);
        } else {
            compileStatement.a(2, str);
        }
        int i2 = 3;
        for (String next : list) {
            if (next == null) {
                compileStatement.a(i2);
            } else {
                compileStatement.a(i2, next);
            }
            i2++;
        }
        this.f43120a.beginTransaction();
        try {
            compileStatement.a();
            this.f43120a.setTransactionSuccessful();
        } finally {
            this.f43120a.endTransaction();
        }
    }

    public final void b(List<String> list, String str) {
        this.f43120a.assertNotSuspendingTransaction();
        StringBuilder a2 = androidx.room.b.e.a();
        a2.append("Update InboxData SET expired = ");
        a2.append("?");
        a2.append(" WHERE customerId = ");
        a2.append("?");
        a2.append(" AND pushId IN (");
        androidx.room.b.e.a(a2, list.size());
        a2.append(")");
        f compileStatement = this.f43120a.compileStatement(a2.toString());
        compileStatement.a(1, 1);
        if (str == null) {
            compileStatement.a(2);
        } else {
            compileStatement.a(2, str);
        }
        int i2 = 3;
        for (String next : list) {
            if (next == null) {
                compileStatement.a(i2);
            } else {
                compileStatement.a(i2, next);
            }
            i2++;
        }
        this.f43120a.beginTransaction();
        try {
            compileStatement.a();
            this.f43120a.setTransactionSuccessful();
        } finally {
            this.f43120a.endTransaction();
        }
    }
}
