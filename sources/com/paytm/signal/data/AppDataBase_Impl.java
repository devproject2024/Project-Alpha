package com.paytm.signal.data;

import androidx.room.a;
import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import java.util.HashMap;
import java.util.HashSet;

public final class AppDataBase_Impl extends AppDataBase {

    /* renamed from: b  reason: collision with root package name */
    private volatile d f43636b;

    public final c createOpenHelper(a aVar) {
        return aVar.f4373a.a(c.b.a(aVar.f4374b).a(aVar.f4375c).a((c.a) new l(aVar, new l.a() {
            public final void onPostMigrate(b bVar) {
            }

            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `SignalEventDb` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `priority` INTEGER, `deviceDateTime` INTEGER, `signalEvent` TEXT)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b29664aa02512d0f75103f819f5e0917')");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `SignalEventDb`");
                if (AppDataBase_Impl.this.mCallbacks != null) {
                    int size = AppDataBase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AppDataBase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onCreate(b bVar) {
                if (AppDataBase_Impl.this.mCallbacks != null) {
                    int size = AppDataBase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AppDataBase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(b bVar) {
                b unused = AppDataBase_Impl.this.mDatabase = bVar;
                AppDataBase_Impl.this.internalInitInvalidationTracker(bVar);
                if (AppDataBase_Impl.this.mCallbacks != null) {
                    int size = AppDataBase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) AppDataBase_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void onPreMigrate(b bVar) {
                androidx.room.b.c.a(bVar);
            }

            public final l.b onValidateSchema(b bVar) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("id", new f.a("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("priority", new f.a("priority", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("deviceDateTime", new f.a("deviceDateTime", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("signalEvent", new f.a("signalEvent", "TEXT", false, 0, (String) null, 1));
                f fVar = new f("SignalEventDb", hashMap, new HashSet(0), new HashSet(0));
                f a2 = f.a(bVar, "SignalEventDb");
                if (fVar.equals(a2)) {
                    return new l.b(true, (String) null);
                }
                return new l.b(false, "SignalEventDb(com.paytm.signal.models.SignalEventDb).\n Expected:\n" + fVar + "\n Found:\n" + a2);
            }
        }, "b29664aa02512d0f75103f819f5e0917", "9514a25b06037df9d02c1dc6983f119a")).a());
    }

    public final g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), "SignalEventDb");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `SignalEventDb`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.b("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.d()) {
                b2.c("VACUUM");
            }
        }
    }

    public final d a() {
        d dVar;
        if (this.f43636b != null) {
            return this.f43636b;
        }
        synchronized (this) {
            if (this.f43636b == null) {
                this.f43636b = new e(this);
            }
            dVar = this.f43636b;
        }
        return dVar;
    }
}
