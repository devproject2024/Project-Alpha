package com.paytm.notification.data.datasource.dao;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import com.paytm.notification.b.e;
import kotlin.g.b.k;

public abstract class AppDatabase extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43093a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static AppDatabase f43094b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final androidx.room.a.a f43095c = new b();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final androidx.room.a.a f43096d = new c();

    public abstract g a();

    public abstract j b();

    public abstract d c();

    public abstract a d();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final AppDatabase a(Context context) {
            AppDatabase e2;
            k.c(context, "context");
            AppDatabase e3 = AppDatabase.f43094b;
            if (e3 != null) {
                return e3;
            }
            synchronized (this) {
                e2 = AppDatabase.f43094b;
                if (e2 == null) {
                    AppDatabase c2 = i.a(context.getApplicationContext(), AppDatabase.class, "PaytmMessageDatabase").a(AppDatabase.f43095c).a(AppDatabase.f43096d).b().c();
                    AppDatabase.f43094b = c2;
                    k.a((Object) c2, "Room.databaseBuilder(con…  .also { instance = it }");
                    e2 = c2;
                }
            }
            return e2;
        }
    }

    public static final class b extends androidx.room.a.a {
        b() {
            super(3, 4);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            k.c(bVar, "database");
            try {
                bVar.c("ALTER TABLE 'FlashData' ADD COLUMN 'position' TEXT");
            } catch (Exception e2) {
                e.f43014a.b(e2);
            }
        }
    }

    public static final class c extends androidx.room.a.a {
        c() {
            super(4, 5);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            k.c(bVar, "database");
            try {
                bVar.c("ALTER TABLE 'NotificationData' ADD COLUMN 'messageId' TEXT");
                bVar.c("ALTER TABLE 'NotificationData' ADD COLUMN 'senderId' TEXT");
                bVar.c("ALTER TABLE 'NotificationData' ADD COLUMN 'sendTime' TEXT");
            } catch (Exception e2) {
                e.f43014a.b(e2);
            }
        }
    }
}
