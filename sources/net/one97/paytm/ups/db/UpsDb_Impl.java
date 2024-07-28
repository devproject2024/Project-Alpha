package net.one97.paytm.ups.db;

import androidx.room.a;
import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import java.util.HashMap;
import java.util.HashSet;

public final class UpsDb_Impl extends UpsDb {
    private volatile UpsDao _upsDao;

    public final c createOpenHelper(a aVar) {
        l lVar = new l(aVar, new l.a(1) {
            public void onPostMigrate(b bVar) {
            }

            public void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `ConsentTable` (`consentKey` TEXT NOT NULL, `consentValue` TEXT, `syncedWithServer` INTEGER NOT NULL, `verticalId` TEXT NOT NULL, `syncTimestamp` INTEGER NOT NULL, PRIMARY KEY(`consentKey`))");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f8a57c1f962f02baff0112b8bd3cd9f9')");
            }

            public void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `ConsentTable`");
                if (UpsDb_Impl.this.mCallbacks != null) {
                    int size = UpsDb_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        UpsDb_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public void onCreate(b bVar) {
                if (UpsDb_Impl.this.mCallbacks != null) {
                    int size = UpsDb_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        UpsDb_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public void onOpen(b bVar) {
                b unused = UpsDb_Impl.this.mDatabase = bVar;
                UpsDb_Impl.this.internalInitInvalidationTracker(bVar);
                if (UpsDb_Impl.this.mCallbacks != null) {
                    int size = UpsDb_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) UpsDb_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public void onPreMigrate(b bVar) {
                androidx.room.b.c.a(bVar);
            }

            public l.b onValidateSchema(b bVar) {
                HashMap hashMap = new HashMap(5);
                hashMap.put("consentKey", new f.a("consentKey", "TEXT", true, 1, (String) null, 1));
                hashMap.put("consentValue", new f.a("consentValue", "TEXT", false, 0, (String) null, 1));
                hashMap.put("syncedWithServer", new f.a("syncedWithServer", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("verticalId", new f.a("verticalId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("syncTimestamp", new f.a("syncTimestamp", "INTEGER", true, 0, (String) null, 1));
                f fVar = new f("ConsentTable", hashMap, new HashSet(0), new HashSet(0));
                f a2 = f.a(bVar, "ConsentTable");
                if (fVar.equals(a2)) {
                    return new l.b(true, (String) null);
                }
                return new l.b(false, "ConsentTable(net.one97.paytm.ups.db.ConsentItem).\n Expected:\n" + fVar + "\n Found:\n" + a2);
            }
        }, "f8a57c1f962f02baff0112b8bd3cd9f9", "73aedf83df5945fa7a595981a1845f36");
        c.b.a a2 = c.b.a(aVar.f4374b);
        a2.f4547b = aVar.f4375c;
        a2.f4548c = lVar;
        return aVar.f4373a.a(a2.a());
    }

    public final g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), "ConsentTable");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `ConsentTable`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.b("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.d()) {
                b2.c("VACUUM");
            }
        }
    }

    public final UpsDao getUpsDao() {
        UpsDao upsDao;
        if (this._upsDao != null) {
            return this._upsDao;
        }
        synchronized (this) {
            if (this._upsDao == null) {
                this._upsDao = new UpsDao_Impl(this);
            }
            upsDao = this._upsDao;
        }
        return upsDao;
    }
}
