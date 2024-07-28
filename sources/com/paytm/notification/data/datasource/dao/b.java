package com.paytm.notification.data.datasource.dao;

import android.database.Cursor;
import androidx.room.b.e;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.q;
import androidx.sqlite.db.f;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.upi.util.UpiConstants;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f43102a;

    /* renamed from: b  reason: collision with root package name */
    private final c<c> f43103b;

    /* renamed from: c  reason: collision with root package name */
    private final q f43104c;

    /* renamed from: d  reason: collision with root package name */
    private final q f43105d;

    /* renamed from: e  reason: collision with root package name */
    private final q f43106e;

    public b(j jVar) {
        this.f43102a = jVar;
        this.f43103b = new c<c>(jVar) {
            public final String createQuery() {
                return "INSERT OR IGNORE INTO `FlashData` (`date`,`priority`,`status`,`display_time`,`campaignId`,`pushId`,`type`,`title`,`message`,`deep_link`,`extras`,`receiveTime`,`expiry`,`notificationId`,`changed`,`scheduledTime`,`isFlash`,`display_period_in_secs`,`customerId`,`button_extras`,`image_url`,`position`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                Integer num;
                c cVar = (c) obj;
                fVar.a(1, cVar.f43111a);
                if (cVar.f43112b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, (long) cVar.f43112b.intValue());
                }
                fVar.a(3, (long) cVar.f43113c);
                fVar.a(4, cVar.f43114d);
                if (cVar.f43115e == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, cVar.f43115e);
                }
                if (cVar.f43116f == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, cVar.f43116f);
                }
                if (cVar.f43117g == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, cVar.f43117g);
                }
                if (cVar.f43118h == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, cVar.f43118h);
                }
                if (cVar.f43119i == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, cVar.f43119i);
                }
                if (cVar.j == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, cVar.j);
                }
                if (cVar.k == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, cVar.k);
                }
                if (cVar.l == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, cVar.l.longValue());
                }
                fVar.a(13, cVar.m);
                fVar.a(14, (long) cVar.n);
                Integer num2 = null;
                if (cVar.o == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(cVar.o.booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    fVar.a(15);
                } else {
                    fVar.a(15, (long) num.intValue());
                }
                if (cVar.p == null) {
                    fVar.a(16);
                } else {
                    fVar.a(16, cVar.p.longValue());
                }
                if (cVar.q != null) {
                    num2 = Integer.valueOf(cVar.q.booleanValue() ? 1 : 0);
                }
                if (num2 == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, (long) num2.intValue());
                }
                fVar.a(18, (long) cVar.r);
                if (cVar.s == null) {
                    fVar.a(19);
                } else {
                    fVar.a(19, cVar.s);
                }
                if (cVar.t == null) {
                    fVar.a(20);
                } else {
                    fVar.a(20, cVar.t);
                }
                if (cVar.u == null) {
                    fVar.a(21);
                } else {
                    fVar.a(21, cVar.u);
                }
                if (cVar.v == null) {
                    fVar.a(22);
                } else {
                    fVar.a(22, cVar.v);
                }
            }
        };
        this.f43104c = new q(jVar) {
            public final String createQuery() {
                return "Update FlashData SET status = ?, changed = ? WHERE pushId = ? AND customerId = ?";
            }
        };
        this.f43105d = new q(jVar) {
            public final String createQuery() {
                return "Delete FROM FlashData WHERE expiry <= ?";
            }
        };
        this.f43106e = new q(jVar) {
            public final String createQuery() {
                return "Delete FROM FlashData";
            }
        };
    }

    public final void a(c cVar) {
        this.f43102a.assertNotSuspendingTransaction();
        this.f43102a.beginTransaction();
        try {
            this.f43103b.insert(cVar);
            this.f43102a.setTransactionSuccessful();
        } finally {
            this.f43102a.endTransaction();
        }
    }

    public final void a(String str, String str2) {
        this.f43102a.assertNotSuspendingTransaction();
        f acquire = this.f43104c.acquire();
        acquire.a(1, 2);
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
        this.f43102a.beginTransaction();
        try {
            acquire.a();
            this.f43102a.setTransactionSuccessful();
        } finally {
            this.f43102a.endTransaction();
            this.f43104c.release(acquire);
        }
    }

    public final void a(long j) {
        this.f43102a.assertNotSuspendingTransaction();
        f acquire = this.f43105d.acquire();
        acquire.a(1, j);
        this.f43102a.beginTransaction();
        try {
            acquire.a();
            this.f43102a.setTransactionSuccessful();
        } finally {
            this.f43102a.endTransaction();
            this.f43105d.release(acquire);
        }
    }

    public final List<c> a() {
        m mVar;
        Integer num;
        Long l;
        Integer num2;
        int i2;
        Boolean bool;
        Long l2;
        Integer num3;
        Boolean bool2;
        m a2 = m.a("SELECT * FROM FlashData", 0);
        this.f43102a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43102a, a2, false);
        try {
            int b2 = androidx.room.b.b.b(a3, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            int b3 = androidx.room.b.b.b(a3, "priority");
            int b4 = androidx.room.b.b.b(a3, "status");
            int b5 = androidx.room.b.b.b(a3, "display_time");
            int b6 = androidx.room.b.b.b(a3, "campaignId");
            int b7 = androidx.room.b.b.b(a3, "pushId");
            int b8 = androidx.room.b.b.b(a3, "type");
            int b9 = androidx.room.b.b.b(a3, "title");
            int b10 = androidx.room.b.b.b(a3, "message");
            int b11 = androidx.room.b.b.b(a3, UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE);
            int b12 = androidx.room.b.b.b(a3, "extras");
            int b13 = androidx.room.b.b.b(a3, "receiveTime");
            int b14 = androidx.room.b.b.b(a3, "expiry");
            int b15 = androidx.room.b.b.b(a3, "notificationId");
            mVar = a2;
            try {
                int b16 = androidx.room.b.b.b(a3, "changed");
                int b17 = androidx.room.b.b.b(a3, "scheduledTime");
                int b18 = androidx.room.b.b.b(a3, "isFlash");
                int b19 = androidx.room.b.b.b(a3, "display_period_in_secs");
                int b20 = androidx.room.b.b.b(a3, "customerId");
                int b21 = androidx.room.b.b.b(a3, "button_extras");
                int b22 = androidx.room.b.b.b(a3, "image_url");
                int b23 = androidx.room.b.b.b(a3, CLPConstants.ARGUMENT_KEY_POSITION);
                int i3 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    c cVar = new c();
                    int i4 = b12;
                    int i5 = b13;
                    cVar.f43111a = a3.getLong(b2);
                    if (a3.isNull(b3)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(a3.getInt(b3));
                    }
                    cVar.f43112b = num;
                    cVar.f43113c = a3.getInt(b4);
                    int i6 = b2;
                    int i7 = b3;
                    cVar.f43114d = a3.getLong(b5);
                    cVar.f43115e = a3.getString(b6);
                    cVar.a(a3.getString(b7));
                    cVar.b(a3.getString(b8));
                    cVar.f43118h = a3.getString(b9);
                    cVar.f43119i = a3.getString(b10);
                    cVar.j = a3.getString(b11);
                    int i8 = i4;
                    cVar.k = a3.getString(i8);
                    int i9 = i5;
                    if (a3.isNull(i9)) {
                        l = null;
                    } else {
                        l = Long.valueOf(a3.getLong(i9));
                    }
                    cVar.l = l;
                    int i10 = i8;
                    b13 = i9;
                    cVar.m = a3.getLong(b14);
                    int i11 = i3;
                    cVar.n = a3.getInt(i11);
                    int i12 = b16;
                    if (a3.isNull(i12)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(a3.getInt(i12));
                    }
                    boolean z = true;
                    if (num2 == null) {
                        i2 = b14;
                        bool = null;
                    } else {
                        i2 = b14;
                        bool = Boolean.valueOf(num2.intValue() != 0);
                    }
                    cVar.o = bool;
                    int i13 = b17;
                    if (a3.isNull(i13)) {
                        b17 = i13;
                        l2 = null;
                    } else {
                        b17 = i13;
                        l2 = Long.valueOf(a3.getLong(i13));
                    }
                    cVar.p = l2;
                    int i14 = b18;
                    if (a3.isNull(i14)) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(a3.getInt(i14));
                    }
                    if (num3 == null) {
                        b18 = i14;
                        bool2 = null;
                    } else {
                        if (num3.intValue() == 0) {
                            z = false;
                        }
                        b18 = i14;
                        bool2 = Boolean.valueOf(z);
                    }
                    cVar.q = bool2;
                    i3 = i11;
                    int i15 = b19;
                    cVar.r = a3.getInt(i15);
                    b19 = i15;
                    int i16 = b20;
                    cVar.c(a3.getString(i16));
                    b20 = i16;
                    int i17 = b21;
                    cVar.t = a3.getString(i17);
                    b21 = i17;
                    int i18 = b22;
                    cVar.u = a3.getString(i18);
                    b22 = i18;
                    int i19 = b23;
                    cVar.v = a3.getString(i19);
                    arrayList.add(cVar);
                    b23 = i19;
                    b16 = i12;
                    b2 = i6;
                    b12 = i10;
                    b3 = i7;
                    b14 = i2;
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

    public final List<c> a(String str, long j) {
        m mVar;
        Integer num;
        Long l;
        Integer num2;
        int i2;
        Boolean bool;
        Long l2;
        Integer num3;
        int i3;
        Boolean bool2;
        String str2 = str;
        m a2 = m.a("SELECT * FROM FlashData  WHERE customerId = ?  AND expiry > ? AND status = ? order by receiveTime DESC", 3);
        if (str2 == null) {
            a2.a(1);
        } else {
            a2.a(1, str2);
        }
        a2.a(2, j);
        a2.a(3, 1);
        this.f43102a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43102a, a2, false);
        try {
            int b2 = androidx.room.b.b.b(a3, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            int b3 = androidx.room.b.b.b(a3, "priority");
            int b4 = androidx.room.b.b.b(a3, "status");
            int b5 = androidx.room.b.b.b(a3, "display_time");
            int b6 = androidx.room.b.b.b(a3, "campaignId");
            int b7 = androidx.room.b.b.b(a3, "pushId");
            int b8 = androidx.room.b.b.b(a3, "type");
            int b9 = androidx.room.b.b.b(a3, "title");
            int b10 = androidx.room.b.b.b(a3, "message");
            int b11 = androidx.room.b.b.b(a3, UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE);
            int b12 = androidx.room.b.b.b(a3, "extras");
            int b13 = androidx.room.b.b.b(a3, "receiveTime");
            int b14 = androidx.room.b.b.b(a3, "expiry");
            int b15 = androidx.room.b.b.b(a3, "notificationId");
            mVar = a2;
            try {
                int b16 = androidx.room.b.b.b(a3, "changed");
                int b17 = androidx.room.b.b.b(a3, "scheduledTime");
                int b18 = androidx.room.b.b.b(a3, "isFlash");
                int b19 = androidx.room.b.b.b(a3, "display_period_in_secs");
                int b20 = androidx.room.b.b.b(a3, "customerId");
                int b21 = androidx.room.b.b.b(a3, "button_extras");
                int b22 = androidx.room.b.b.b(a3, "image_url");
                int b23 = androidx.room.b.b.b(a3, CLPConstants.ARGUMENT_KEY_POSITION);
                int i4 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    c cVar = new c();
                    ArrayList arrayList2 = arrayList;
                    int i5 = b14;
                    cVar.f43111a = a3.getLong(b2);
                    if (a3.isNull(b3)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(a3.getInt(b3));
                    }
                    cVar.f43112b = num;
                    cVar.f43113c = a3.getInt(b4);
                    cVar.f43114d = a3.getLong(b5);
                    cVar.f43115e = a3.getString(b6);
                    cVar.a(a3.getString(b7));
                    cVar.b(a3.getString(b8));
                    cVar.f43118h = a3.getString(b9);
                    cVar.f43119i = a3.getString(b10);
                    cVar.j = a3.getString(b11);
                    cVar.k = a3.getString(b12);
                    if (a3.isNull(b13)) {
                        l = null;
                    } else {
                        l = Long.valueOf(a3.getLong(b13));
                    }
                    cVar.l = l;
                    int i6 = b3;
                    int i7 = i5;
                    int i8 = b4;
                    cVar.m = a3.getLong(i7);
                    int i9 = i4;
                    cVar.n = a3.getInt(i9);
                    int i10 = b16;
                    if (a3.isNull(i10)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(a3.getInt(i10));
                    }
                    if (num2 == null) {
                        i2 = b2;
                        bool = null;
                    } else {
                        i2 = b2;
                        bool = Boolean.valueOf(num2.intValue() != 0);
                    }
                    cVar.o = bool;
                    int i11 = b17;
                    if (a3.isNull(i11)) {
                        b17 = i11;
                        l2 = null;
                    } else {
                        b17 = i11;
                        l2 = Long.valueOf(a3.getLong(i11));
                    }
                    cVar.p = l2;
                    int i12 = b18;
                    if (a3.isNull(i12)) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(a3.getInt(i12));
                    }
                    if (num3 == null) {
                        i3 = i12;
                        bool2 = null;
                    } else {
                        i3 = i12;
                        bool2 = Boolean.valueOf(num3.intValue() != 0);
                    }
                    cVar.q = bool2;
                    int i13 = b13;
                    int i14 = b19;
                    cVar.r = a3.getInt(i14);
                    b19 = i14;
                    int i15 = b20;
                    cVar.c(a3.getString(i15));
                    b20 = i15;
                    int i16 = b21;
                    cVar.t = a3.getString(i16);
                    b21 = i16;
                    int i17 = b22;
                    cVar.u = a3.getString(i17);
                    b22 = i17;
                    int i18 = b23;
                    cVar.v = a3.getString(i18);
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(cVar);
                    b23 = i18;
                    b2 = i2;
                    b16 = i10;
                    b4 = i8;
                    int i19 = i7;
                    arrayList = arrayList3;
                    b13 = i13;
                    b18 = i3;
                    i4 = i9;
                    b3 = i6;
                    b14 = i19;
                }
                ArrayList arrayList4 = arrayList;
                a3.close();
                mVar.a();
                return arrayList4;
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

    public final c a(String str, long j, String str2) {
        m mVar;
        c cVar;
        Integer num;
        Long l;
        Integer num2;
        Boolean bool;
        Long l2;
        Integer num3;
        String str3 = str;
        String str4 = str2;
        m a2 = m.a("SELECT * FROM FlashData  WHERE customerId = ?  AND expiry > ? AND pushId = ?", 3);
        if (str3 == null) {
            a2.a(1);
        } else {
            a2.a(1, str3);
        }
        a2.a(2, j);
        if (str4 == null) {
            a2.a(3);
        } else {
            a2.a(3, str4);
        }
        this.f43102a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43102a, a2, false);
        try {
            int b2 = androidx.room.b.b.b(a3, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            int b3 = androidx.room.b.b.b(a3, "priority");
            int b4 = androidx.room.b.b.b(a3, "status");
            int b5 = androidx.room.b.b.b(a3, "display_time");
            int b6 = androidx.room.b.b.b(a3, "campaignId");
            int b7 = androidx.room.b.b.b(a3, "pushId");
            int b8 = androidx.room.b.b.b(a3, "type");
            int b9 = androidx.room.b.b.b(a3, "title");
            int b10 = androidx.room.b.b.b(a3, "message");
            int b11 = androidx.room.b.b.b(a3, UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE);
            int b12 = androidx.room.b.b.b(a3, "extras");
            int b13 = androidx.room.b.b.b(a3, "receiveTime");
            int b14 = androidx.room.b.b.b(a3, "expiry");
            int b15 = androidx.room.b.b.b(a3, "notificationId");
            mVar = a2;
            try {
                int b16 = androidx.room.b.b.b(a3, "changed");
                int b17 = androidx.room.b.b.b(a3, "scheduledTime");
                int b18 = androidx.room.b.b.b(a3, "isFlash");
                int b19 = androidx.room.b.b.b(a3, "display_period_in_secs");
                int b20 = androidx.room.b.b.b(a3, "customerId");
                int b21 = androidx.room.b.b.b(a3, "button_extras");
                int b22 = androidx.room.b.b.b(a3, "image_url");
                int b23 = androidx.room.b.b.b(a3, CLPConstants.ARGUMENT_KEY_POSITION);
                Boolean bool2 = null;
                if (a3.moveToFirst()) {
                    int i2 = b23;
                    cVar = new c();
                    int i3 = b15;
                    cVar.f43111a = a3.getLong(b2);
                    if (a3.isNull(b3)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(a3.getInt(b3));
                    }
                    cVar.f43112b = num;
                    cVar.f43113c = a3.getInt(b4);
                    cVar.f43114d = a3.getLong(b5);
                    cVar.f43115e = a3.getString(b6);
                    cVar.a(a3.getString(b7));
                    cVar.b(a3.getString(b8));
                    cVar.f43118h = a3.getString(b9);
                    cVar.f43119i = a3.getString(b10);
                    cVar.j = a3.getString(b11);
                    cVar.k = a3.getString(b12);
                    if (a3.isNull(b13)) {
                        l = null;
                    } else {
                        l = Long.valueOf(a3.getLong(b13));
                    }
                    cVar.l = l;
                    cVar.m = a3.getLong(b14);
                    cVar.n = a3.getInt(i3);
                    int i4 = b16;
                    if (a3.isNull(i4)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(a3.getInt(i4));
                    }
                    if (num2 == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(num2.intValue() != 0);
                    }
                    cVar.o = bool;
                    int i5 = b17;
                    if (a3.isNull(i5)) {
                        l2 = null;
                    } else {
                        l2 = Long.valueOf(a3.getLong(i5));
                    }
                    cVar.p = l2;
                    int i6 = b18;
                    if (a3.isNull(i6)) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(a3.getInt(i6));
                    }
                    if (num3 != null) {
                        bool2 = Boolean.valueOf(num3.intValue() != 0);
                    }
                    cVar.q = bool2;
                    cVar.r = a3.getInt(b19);
                    cVar.c(a3.getString(b20));
                    cVar.t = a3.getString(b21);
                    cVar.u = a3.getString(b22);
                    cVar.v = a3.getString(i2);
                } else {
                    cVar = null;
                }
                a3.close();
                mVar.a();
                return cVar;
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
        m a2 = m.a("SELECT DISTINCT customerId FROM FlashData", 0);
        this.f43102a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43102a, a2, false);
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

    public final List<String> b(String str, long j) {
        m a2 = m.a("SELECT pushId FROM FlashData WHERE customerId = ? AND (changed = ? AND status = ?) OR (expiry <= ? AND status != ?)", 5);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        a2.a(2, 1);
        a2.a(3, 2);
        a2.a(4, j);
        a2.a(5, 3);
        this.f43102a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43102a, a2, false);
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

    public final List<c> b(long j) {
        m mVar;
        Integer num;
        Long l;
        Integer num2;
        int i2;
        Boolean bool;
        int i3;
        Long l2;
        Integer num3;
        Boolean bool2;
        m a2 = m.a("SELECT * FROM FlashData WHERE expiry <= ? AND status = ?", 2);
        a2.a(1, j);
        a2.a(2, 1);
        this.f43102a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43102a, a2, false);
        try {
            int b2 = androidx.room.b.b.b(a3, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            int b3 = androidx.room.b.b.b(a3, "priority");
            int b4 = androidx.room.b.b.b(a3, "status");
            int b5 = androidx.room.b.b.b(a3, "display_time");
            int b6 = androidx.room.b.b.b(a3, "campaignId");
            int b7 = androidx.room.b.b.b(a3, "pushId");
            int b8 = androidx.room.b.b.b(a3, "type");
            int b9 = androidx.room.b.b.b(a3, "title");
            int b10 = androidx.room.b.b.b(a3, "message");
            int b11 = androidx.room.b.b.b(a3, UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE);
            int b12 = androidx.room.b.b.b(a3, "extras");
            int b13 = androidx.room.b.b.b(a3, "receiveTime");
            int b14 = androidx.room.b.b.b(a3, "expiry");
            int b15 = androidx.room.b.b.b(a3, "notificationId");
            mVar = a2;
            try {
                int b16 = androidx.room.b.b.b(a3, "changed");
                int b17 = androidx.room.b.b.b(a3, "scheduledTime");
                int b18 = androidx.room.b.b.b(a3, "isFlash");
                int b19 = androidx.room.b.b.b(a3, "display_period_in_secs");
                int b20 = androidx.room.b.b.b(a3, "customerId");
                int b21 = androidx.room.b.b.b(a3, "button_extras");
                int b22 = androidx.room.b.b.b(a3, "image_url");
                int b23 = androidx.room.b.b.b(a3, CLPConstants.ARGUMENT_KEY_POSITION);
                int i4 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    c cVar = new c();
                    ArrayList arrayList2 = arrayList;
                    int i5 = b13;
                    cVar.f43111a = a3.getLong(b2);
                    if (a3.isNull(b3)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(a3.getInt(b3));
                    }
                    cVar.f43112b = num;
                    cVar.f43113c = a3.getInt(b4);
                    int i6 = b14;
                    cVar.f43114d = a3.getLong(b5);
                    cVar.f43115e = a3.getString(b6);
                    cVar.a(a3.getString(b7));
                    cVar.b(a3.getString(b8));
                    cVar.f43118h = a3.getString(b9);
                    cVar.f43119i = a3.getString(b10);
                    cVar.j = a3.getString(b11);
                    cVar.k = a3.getString(b12);
                    int i7 = i5;
                    if (a3.isNull(i7)) {
                        l = null;
                    } else {
                        l = Long.valueOf(a3.getLong(i7));
                    }
                    cVar.l = l;
                    int i8 = i7;
                    cVar.m = a3.getLong(i6);
                    int i9 = i4;
                    cVar.n = a3.getInt(i9);
                    int i10 = b16;
                    if (a3.isNull(i10)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(a3.getInt(i10));
                    }
                    if (num2 == null) {
                        i2 = b2;
                        bool = null;
                    } else {
                        i2 = b2;
                        bool = Boolean.valueOf(num2.intValue() != 0);
                    }
                    cVar.o = bool;
                    int i11 = b17;
                    if (a3.isNull(i11)) {
                        i3 = i11;
                        l2 = null;
                    } else {
                        i3 = i11;
                        l2 = Long.valueOf(a3.getLong(i11));
                    }
                    cVar.p = l2;
                    int i12 = b18;
                    if (a3.isNull(i12)) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(a3.getInt(i12));
                    }
                    if (num3 == null) {
                        b18 = i12;
                        bool2 = null;
                    } else {
                        b18 = i12;
                        bool2 = Boolean.valueOf(num3.intValue() != 0);
                    }
                    cVar.q = bool2;
                    int i13 = i6;
                    int i14 = b19;
                    cVar.r = a3.getInt(i14);
                    b19 = i14;
                    int i15 = b20;
                    cVar.c(a3.getString(i15));
                    b20 = i15;
                    int i16 = b21;
                    cVar.t = a3.getString(i16);
                    b21 = i16;
                    int i17 = b22;
                    cVar.u = a3.getString(i17);
                    b22 = i17;
                    int i18 = b23;
                    cVar.v = a3.getString(i18);
                    arrayList = arrayList2;
                    arrayList.add(cVar);
                    b23 = i18;
                    b2 = i2;
                    b16 = i10;
                    b14 = i13;
                    b17 = i3;
                    i4 = i9;
                    b13 = i8;
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

    public final void a(List<String> list, String str) {
        this.f43102a.assertNotSuspendingTransaction();
        StringBuilder a2 = e.a();
        a2.append("Update FlashData SET status = ");
        a2.append("?");
        a2.append(", changed = ");
        a2.append("?");
        a2.append(" WHERE customerId = ");
        a2.append("?");
        a2.append(" AND pushId IN (");
        e.a(a2, list.size());
        a2.append(")");
        f compileStatement = this.f43102a.compileStatement(a2.toString());
        compileStatement.a(1, 3);
        compileStatement.a(2, 0);
        if (str == null) {
            compileStatement.a(3);
        } else {
            compileStatement.a(3, str);
        }
        int i2 = 4;
        for (String next : list) {
            if (next == null) {
                compileStatement.a(i2);
            } else {
                compileStatement.a(i2, next);
            }
            i2++;
        }
        this.f43102a.beginTransaction();
        try {
            compileStatement.a();
            this.f43102a.setTransactionSuccessful();
        } finally {
            this.f43102a.endTransaction();
        }
    }
}
