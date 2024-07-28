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
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.upi.util.UpiConstants;

public final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    private final j f43142a;

    /* renamed from: b  reason: collision with root package name */
    private final c<i> f43143b;

    /* renamed from: c  reason: collision with root package name */
    private final q f43144c;

    /* renamed from: d  reason: collision with root package name */
    private final q f43145d;

    /* renamed from: e  reason: collision with root package name */
    private final q f43146e;

    /* renamed from: f  reason: collision with root package name */
    private final q f43147f;

    /* renamed from: g  reason: collision with root package name */
    private final q f43148g;

    public h(j jVar) {
        this.f43142a = jVar;
        this.f43143b = new c<i>(jVar) {
            public final String createQuery() {
                return "INSERT OR REPLACE INTO `NotificationData` (`date`,`priority`,`status_push`,`status_flash`,`display_time`,`campaignId`,`pushId`,`type`,`title`,`message`,`deep_link`,`extras`,`channelId`,`receiveTime`,`expiry`,`notificationId`,`subtext`,`largeIconUrl`,`deep_link_type`,`rich_push`,`server_receive_time`,`messageId`,`senderId`,`sendTime`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public final /* synthetic */ void bind(f fVar, Object obj) {
                i iVar = (i) obj;
                fVar.a(1, iVar.f43155a);
                if (iVar.f43156b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, (long) iVar.f43156b.intValue());
                }
                fVar.a(3, (long) iVar.f43157c);
                fVar.a(4, (long) iVar.f43158d);
                fVar.a(5, iVar.f43159e);
                if (iVar.f43160f == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, iVar.f43160f);
                }
                if (iVar.f43161g == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, iVar.f43161g);
                }
                if (iVar.f43162h == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, iVar.f43162h);
                }
                if (iVar.f43163i == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, iVar.f43163i);
                }
                if (iVar.j == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, iVar.j);
                }
                if (iVar.k == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, iVar.k);
                }
                if (iVar.l == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, iVar.l);
                }
                if (iVar.m == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, iVar.m);
                }
                if (iVar.n == null) {
                    fVar.a(14);
                } else {
                    fVar.a(14, iVar.n.longValue());
                }
                fVar.a(15, iVar.o);
                fVar.a(16, (long) iVar.p);
                if (iVar.q == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, iVar.q);
                }
                if (iVar.r == null) {
                    fVar.a(18);
                } else {
                    fVar.a(18, iVar.r);
                }
                if (iVar.s == null) {
                    fVar.a(19);
                } else {
                    fVar.a(19, iVar.s);
                }
                fVar.a(20, iVar.t ? 1 : 0);
                fVar.a(21, iVar.u);
                if (iVar.v == null) {
                    fVar.a(22);
                } else {
                    fVar.a(22, iVar.v);
                }
                if (iVar.w == null) {
                    fVar.a(23);
                } else {
                    fVar.a(23, iVar.w);
                }
                if (iVar.x == null) {
                    fVar.a(24);
                } else {
                    fVar.a(24, iVar.x.longValue());
                }
            }
        };
        this.f43144c = new q(jVar) {
            public final String createQuery() {
                return "Delete FROM NotificationData WHERE notificationId = ?";
            }
        };
        this.f43145d = new q(jVar) {
            public final String createQuery() {
                return "Update NotificationData SET status_push = ? WHERE notificationId = ?";
            }
        };
        this.f43146e = new q(jVar) {
            public final String createQuery() {
                return "Update NotificationData SET status_flash = ? WHERE notificationId = ?";
            }
        };
        this.f43147f = new q(jVar) {
            public final String createQuery() {
                return "Delete FROM NotificationData WHERE receiveTime <= ? ";
            }
        };
        this.f43148g = new q(jVar) {
            public final String createQuery() {
                return "Delete FROM NotificationData";
            }
        };
    }

    public final void a(i iVar) {
        this.f43142a.assertNotSuspendingTransaction();
        this.f43142a.beginTransaction();
        try {
            this.f43143b.insert(iVar);
            this.f43142a.setTransactionSuccessful();
        } finally {
            this.f43142a.endTransaction();
        }
    }

    public final void b(int i2) {
        this.f43142a.assertNotSuspendingTransaction();
        f acquire = this.f43144c.acquire();
        acquire.a(1, (long) i2);
        this.f43142a.beginTransaction();
        try {
            acquire.a();
            this.f43142a.setTransactionSuccessful();
        } finally {
            this.f43142a.endTransaction();
            this.f43144c.release(acquire);
        }
    }

    public final void a(int i2, int i3) {
        this.f43142a.assertNotSuspendingTransaction();
        f acquire = this.f43145d.acquire();
        acquire.a(1, (long) i3);
        acquire.a(2, (long) i2);
        this.f43142a.beginTransaction();
        try {
            acquire.a();
            this.f43142a.setTransactionSuccessful();
        } finally {
            this.f43142a.endTransaction();
            this.f43145d.release(acquire);
        }
    }

    public final void a(long j) {
        this.f43142a.assertNotSuspendingTransaction();
        f acquire = this.f43147f.acquire();
        acquire.a(1, j);
        this.f43142a.beginTransaction();
        try {
            acquire.a();
            this.f43142a.setTransactionSuccessful();
        } finally {
            this.f43142a.endTransaction();
            this.f43147f.release(acquire);
        }
    }

    public final List<i> a() {
        m mVar;
        Integer num;
        int i2;
        Long l;
        boolean z;
        Long l2;
        m a2 = m.a("SELECT * FROM NotificationData", 0);
        this.f43142a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43142a, a2, false);
        try {
            int b2 = b.b(a3, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            int b3 = b.b(a3, "priority");
            int b4 = b.b(a3, "status_push");
            int b5 = b.b(a3, "status_flash");
            int b6 = b.b(a3, "display_time");
            int b7 = b.b(a3, "campaignId");
            int b8 = b.b(a3, "pushId");
            int b9 = b.b(a3, "type");
            int b10 = b.b(a3, "title");
            int b11 = b.b(a3, "message");
            int b12 = b.b(a3, UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE);
            int b13 = b.b(a3, "extras");
            int b14 = b.b(a3, "channelId");
            int b15 = b.b(a3, "receiveTime");
            mVar = a2;
            try {
                int b16 = b.b(a3, "expiry");
                int b17 = b.b(a3, "notificationId");
                int b18 = b.b(a3, "subtext");
                int b19 = b.b(a3, "largeIconUrl");
                int b20 = b.b(a3, "deep_link_type");
                int b21 = b.b(a3, "rich_push");
                int b22 = b.b(a3, "server_receive_time");
                int b23 = b.b(a3, "messageId");
                int b24 = b.b(a3, "senderId");
                int b25 = b.b(a3, "sendTime");
                int i3 = b15;
                ArrayList arrayList = new ArrayList(a3.getCount());
                while (a3.moveToNext()) {
                    i iVar = new i();
                    int i4 = b12;
                    int i5 = b13;
                    iVar.f43155a = a3.getLong(b2);
                    if (a3.isNull(b3)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(a3.getInt(b3));
                    }
                    iVar.f43156b = num;
                    iVar.f43157c = a3.getInt(b4);
                    iVar.f43158d = a3.getInt(b5);
                    int i6 = b2;
                    int i7 = b3;
                    iVar.f43159e = a3.getLong(b6);
                    iVar.f43160f = a3.getString(b7);
                    iVar.f43161g = a3.getString(b8);
                    iVar.a(a3.getString(b9));
                    iVar.f43163i = a3.getString(b10);
                    iVar.j = a3.getString(b11);
                    int i8 = i4;
                    iVar.k = a3.getString(i8);
                    int i9 = i5;
                    iVar.l = a3.getString(i9);
                    iVar.m = a3.getString(b14);
                    int i10 = i3;
                    if (a3.isNull(i10)) {
                        i2 = b14;
                        l = null;
                    } else {
                        i2 = b14;
                        l = Long.valueOf(a3.getLong(i10));
                    }
                    iVar.n = l;
                    int i11 = i9;
                    int i12 = b16;
                    int i13 = i8;
                    iVar.o = a3.getLong(i12);
                    int i14 = b17;
                    iVar.p = a3.getInt(i14);
                    int i15 = i12;
                    int i16 = b18;
                    iVar.q = a3.getString(i16);
                    int i17 = i14;
                    int i18 = b19;
                    iVar.r = a3.getString(i18);
                    b19 = i18;
                    int i19 = b20;
                    iVar.s = a3.getString(i19);
                    int i20 = b21;
                    if (a3.getInt(i20) != 0) {
                        b21 = i20;
                        z = true;
                    } else {
                        b21 = i20;
                        z = false;
                    }
                    iVar.t = z;
                    int i21 = i16;
                    int i22 = b22;
                    int i23 = i19;
                    iVar.u = a3.getLong(i22);
                    int i24 = b23;
                    iVar.v = a3.getString(i24);
                    int i25 = i22;
                    int i26 = b24;
                    iVar.w = a3.getString(i26);
                    int i27 = b25;
                    if (a3.isNull(i27)) {
                        b25 = i27;
                        l2 = null;
                    } else {
                        b25 = i27;
                        l2 = Long.valueOf(a3.getLong(i27));
                    }
                    iVar.x = l2;
                    arrayList.add(iVar);
                    b24 = i26;
                    b14 = i2;
                    b3 = i7;
                    int i28 = i25;
                    b23 = i24;
                    b2 = i6;
                    b12 = i13;
                    b16 = i15;
                    b17 = i17;
                    b18 = i21;
                    b20 = i23;
                    b22 = i28;
                    int i29 = i11;
                    i3 = i10;
                    b13 = i29;
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

    public final i a(int i2) {
        m mVar;
        i iVar;
        Integer num;
        Long l;
        m a2 = m.a("SELECT * FROM NotificationData WHERE notificationId = ?", 1);
        a2.a(1, (long) i2);
        this.f43142a.assertNotSuspendingTransaction();
        Cursor a3 = androidx.room.b.c.a(this.f43142a, a2, false);
        try {
            int b2 = b.b(a3, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            int b3 = b.b(a3, "priority");
            int b4 = b.b(a3, "status_push");
            int b5 = b.b(a3, "status_flash");
            int b6 = b.b(a3, "display_time");
            int b7 = b.b(a3, "campaignId");
            int b8 = b.b(a3, "pushId");
            int b9 = b.b(a3, "type");
            int b10 = b.b(a3, "title");
            int b11 = b.b(a3, "message");
            int b12 = b.b(a3, UpiConstants.UPI_SOURCE_MAPPING.DEEPLINK_SOURCE);
            int b13 = b.b(a3, "extras");
            int b14 = b.b(a3, "channelId");
            int b15 = b.b(a3, "receiveTime");
            mVar = a2;
            try {
                int b16 = b.b(a3, "expiry");
                int b17 = b.b(a3, "notificationId");
                int b18 = b.b(a3, "subtext");
                int b19 = b.b(a3, "largeIconUrl");
                int b20 = b.b(a3, "deep_link_type");
                int b21 = b.b(a3, "rich_push");
                int b22 = b.b(a3, "server_receive_time");
                int b23 = b.b(a3, "messageId");
                int b24 = b.b(a3, "senderId");
                int b25 = b.b(a3, "sendTime");
                Long l2 = null;
                if (a3.moveToFirst()) {
                    int i3 = b25;
                    iVar = new i();
                    int i4 = b14;
                    iVar.f43155a = a3.getLong(b2);
                    if (a3.isNull(b3)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(a3.getInt(b3));
                    }
                    iVar.f43156b = num;
                    iVar.f43157c = a3.getInt(b4);
                    iVar.f43158d = a3.getInt(b5);
                    iVar.f43159e = a3.getLong(b6);
                    iVar.f43160f = a3.getString(b7);
                    iVar.f43161g = a3.getString(b8);
                    iVar.a(a3.getString(b9));
                    iVar.f43163i = a3.getString(b10);
                    iVar.j = a3.getString(b11);
                    iVar.k = a3.getString(b12);
                    iVar.l = a3.getString(b13);
                    iVar.m = a3.getString(i4);
                    if (a3.isNull(b15)) {
                        l = null;
                    } else {
                        l = Long.valueOf(a3.getLong(b15));
                    }
                    iVar.n = l;
                    iVar.o = a3.getLong(b16);
                    iVar.p = a3.getInt(b17);
                    iVar.q = a3.getString(b18);
                    iVar.r = a3.getString(b19);
                    iVar.s = a3.getString(b20);
                    iVar.t = a3.getInt(b21) != 0;
                    iVar.u = a3.getLong(b22);
                    iVar.v = a3.getString(b23);
                    iVar.w = a3.getString(b24);
                    int i5 = i3;
                    if (!a3.isNull(i5)) {
                        l2 = Long.valueOf(a3.getLong(i5));
                    }
                    iVar.x = l2;
                } else {
                    iVar = null;
                }
                a3.close();
                mVar.a();
                return iVar;
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
}
