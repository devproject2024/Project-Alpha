package net.one97.paytm.upi.database;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;
import kotlin.g.b.k;

public abstract class UpiRoomDatabase extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66661a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static UpiRoomDatabase f66662b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final b f66663c = new b();

    public static final synchronized UpiRoomDatabase a(Context context) {
        UpiRoomDatabase a2;
        synchronized (UpiRoomDatabase.class) {
            a2 = f66661a.a(context);
        }
        return a2;
    }

    public abstract net.one97.paytm.upi.d.a a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final synchronized UpiRoomDatabase a(Context context) {
            UpiRoomDatabase b2;
            k.c(context, "context");
            b2 = UpiRoomDatabase.f66662b;
            if (b2 == null) {
                UpiRoomDatabase.f66662b = i.a(context, UpiRoomDatabase.class, "paytm_upi.db").b().a(UpiRoomDatabase.f66663c).c();
                b2 = UpiRoomDatabase.f66662b;
                if (b2 == null) {
                    k.a();
                }
            }
            return b2;
        }
    }

    public static final class b extends androidx.room.a.a {
        b() {
            super(1, 2);
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            k.c(bVar, "database");
            bVar.c("drop table if exists device_info");
            bVar.c("CREATE TABLE IF NOT EXISTS account_providers(_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT NOT NULL, regMobFormat TEXT, accountProvider TEXT, bankLogoUrl TEXT, ifsc TEXT NOT NULL UNIQUE, iin TEXT);");
        }
    }
}
