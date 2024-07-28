package net.one97.paytm.appManager.storage.db;

import androidx.room.a;
import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class AppManagerDb_Impl extends AppManagerDb {

    /* renamed from: a  reason: collision with root package name */
    private volatile a f49056a;

    public final c createOpenHelper(a aVar) {
        return aVar.f4373a.a(c.b.a(aVar.f4374b).a(aVar.f4375c).a((c.a) new l(aVar, new l.a() {
            public final void onPostMigrate(b bVar) {
            }

            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `ItemTable` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `keyValue` TEXT NOT NULL, `value` TEXT NOT NULL)");
                bVar.c("CREATE UNIQUE INDEX IF NOT EXISTS `index_ItemTable_keyValue` ON `ItemTable` (`keyValue`)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a79c0e6f4c425839ac3907924b057169')");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `ItemTable`");
                if (AppManagerDb_Impl.this.mCallbacks != null) {
                    int size = AppManagerDb_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AppManagerDb_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onCreate(b bVar) {
                if (AppManagerDb_Impl.this.mCallbacks != null) {
                    int size = AppManagerDb_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AppManagerDb_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(b bVar) {
                b unused = AppManagerDb_Impl.this.mDatabase = bVar;
                AppManagerDb_Impl.this.internalInitInvalidationTracker(bVar);
                if (AppManagerDb_Impl.this.mCallbacks != null) {
                    int size = AppManagerDb_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) AppManagerDb_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void onPreMigrate(b bVar) {
                androidx.room.b.c.a(bVar);
            }

            public final l.b onValidateSchema(b bVar) {
                HashMap hashMap = new HashMap(3);
                hashMap.put("id", new f.a("id", "INTEGER", false, 1, (String) null, 1));
                hashMap.put("keyValue", new f.a("keyValue", "TEXT", true, 0, (String) null, 1));
                hashMap.put("value", new f.a("value", "TEXT", true, 0, (String) null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new f.d("index_ItemTable_keyValue", true, Arrays.asList(new String[]{"keyValue"})));
                f fVar = new f("ItemTable", hashMap, hashSet, hashSet2);
                f a2 = f.a(bVar, "ItemTable");
                if (fVar.equals(a2)) {
                    return new l.b(true, (String) null);
                }
                return new l.b(false, "ItemTable(net.one97.paytm.appManager.storage.db.ItemTable).\n Expected:\n" + fVar + "\n Found:\n" + a2);
            }
        }, "a79c0e6f4c425839ac3907924b057169", "c0faba9c81838024000dc6486e955bb9")).a());
    }

    public final g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), "ItemTable");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `ItemTable`");
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
        if (this.f49056a != null) {
            return this.f49056a;
        }
        synchronized (this) {
            if (this.f49056a == null) {
                this.f49056a = new b(this);
            }
            aVar = this.f49056a;
        }
        return aVar;
    }
}
