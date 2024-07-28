package net.one97.paytm.upi.database;

import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import java.util.HashMap;
import java.util.HashSet;
import net.one97.paytm.upi.d.a;
import net.one97.paytm.upi.util.UpiContract;

public final class UpiRoomDatabase_Impl extends UpiRoomDatabase {

    /* renamed from: b  reason: collision with root package name */
    private volatile a f66664b;

    public final c createOpenHelper(androidx.room.a aVar) {
        l lVar = new l(aVar, new l.a() {
            public final void onPostMigrate(b bVar) {
            }

            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `account_providers` (`id` TEXT NOT NULL, `_id` INTEGER PRIMARY KEY AUTOINCREMENT, `regMobFormat` TEXT, `iin` TEXT, `accountProvider` TEXT, `ifsc` TEXT NOT NULL, `bankLogoUrl` TEXT)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fec399d626f0c09e1bbd195e7ce5f038')");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `account_providers`");
                if (UpiRoomDatabase_Impl.this.mCallbacks != null) {
                    int size = UpiRoomDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        UpiRoomDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onCreate(b bVar) {
                if (UpiRoomDatabase_Impl.this.mCallbacks != null) {
                    int size = UpiRoomDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        UpiRoomDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(b bVar) {
                b unused = UpiRoomDatabase_Impl.this.mDatabase = bVar;
                UpiRoomDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (UpiRoomDatabase_Impl.this.mCallbacks != null) {
                    int size = UpiRoomDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) UpiRoomDatabase_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void onPreMigrate(b bVar) {
                androidx.room.b.c.a(bVar);
            }

            public final l.b onValidateSchema(b bVar) {
                HashMap hashMap = new HashMap(7);
                hashMap.put("id", new f.a("id", "TEXT", true, 0, (String) null, 1));
                hashMap.put("_id", new f.a("_id", "INTEGER", false, 1, (String) null, 1));
                hashMap.put(UpiContract.UPI_ACCOUNT_PROVIDER.REG_MOB_FORMAT, new f.a(UpiContract.UPI_ACCOUNT_PROVIDER.REG_MOB_FORMAT, "TEXT", false, 0, (String) null, 1));
                hashMap.put(UpiContract.UPI_ACCOUNT_PROVIDER.IIN, new f.a(UpiContract.UPI_ACCOUNT_PROVIDER.IIN, "TEXT", false, 0, (String) null, 1));
                hashMap.put(UpiContract.UPI_ACCOUNT_PROVIDER.ACCOUNT_PROVIDER, new f.a(UpiContract.UPI_ACCOUNT_PROVIDER.ACCOUNT_PROVIDER, "TEXT", false, 0, (String) null, 1));
                hashMap.put("ifsc", new f.a("ifsc", "TEXT", true, 0, (String) null, 1));
                hashMap.put(UpiContract.UPI_ACCOUNT_PROVIDER.BANK_LOGO_URL, new f.a(UpiContract.UPI_ACCOUNT_PROVIDER.BANK_LOGO_URL, "TEXT", false, 0, (String) null, 1));
                f fVar = new f(UpiContract.UPI_ACCOUNT_PROVIDER.TABLE_NAME, hashMap, new HashSet(0), new HashSet(0));
                f a2 = f.a(bVar, UpiContract.UPI_ACCOUNT_PROVIDER.TABLE_NAME);
                if (fVar.equals(a2)) {
                    return new l.b(true, (String) null);
                }
                return new l.b(false, "account_providers(net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider).\n Expected:\n" + fVar + "\n Found:\n" + a2);
            }
        }, "fec399d626f0c09e1bbd195e7ce5f038", "b4ec3f5c4461fc6f0ba6441c98b4de80");
        c.b.a a2 = c.b.a(aVar.f4374b);
        a2.f4547b = aVar.f4375c;
        a2.f4548c = lVar;
        return aVar.f4373a.a(a2.a());
    }

    public final g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), UpiContract.UPI_ACCOUNT_PROVIDER.TABLE_NAME);
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `account_providers`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.b("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.d()) {
                b2.c("VACUUM");
            }
        }
    }

    public final a a() {
        a aVar;
        if (this.f66664b != null) {
            return this.f66664b;
        }
        synchronized (this) {
            if (this.f66664b == null) {
                this.f66664b = new net.one97.paytm.upi.d.b(this);
            }
            aVar = this.f66664b;
        }
        return aVar;
    }
}
