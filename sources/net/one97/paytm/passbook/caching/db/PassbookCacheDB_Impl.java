package net.one97.paytm.passbook.caching.db;

import androidx.room.a;
import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.appsflyer.internal.referrer.Payload;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class PassbookCacheDB_Impl extends PassbookCacheDB {

    /* renamed from: b  reason: collision with root package name */
    private volatile b f57109b;

    public final c createOpenHelper(a aVar) {
        l lVar = new l(aVar, new l.a() {
            public final void onPostMigrate(b bVar) {
            }

            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `PassbookCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `request_type` TEXT NOT NULL, `request_url` TEXT NOT NULL, `query_params` TEXT, `header` TEXT, `body_data` TEXT, `response` TEXT NOT NULL, `last_request_time` INTEGER NOT NULL, `max_age` INTEGER NOT NULL, `hit_count` INTEGER NOT NULL)");
                bVar.c("CREATE UNIQUE INDEX IF NOT EXISTS `index_PassbookCache_request_type_request_url_body_data` ON `PassbookCache` (`request_type`, `request_url`, `body_data`)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a761daf9a5bb9f9fc3f2db173e7b42ec')");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `PassbookCache`");
                if (PassbookCacheDB_Impl.this.mCallbacks != null) {
                    int size = PassbookCacheDB_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        PassbookCacheDB_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onCreate(b bVar) {
                if (PassbookCacheDB_Impl.this.mCallbacks != null) {
                    int size = PassbookCacheDB_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        PassbookCacheDB_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(b bVar) {
                b unused = PassbookCacheDB_Impl.this.mDatabase = bVar;
                PassbookCacheDB_Impl.this.internalInitInvalidationTracker(bVar);
                if (PassbookCacheDB_Impl.this.mCallbacks != null) {
                    int size = PassbookCacheDB_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) PassbookCacheDB_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void onPreMigrate(b bVar) {
                androidx.room.b.c.a(bVar);
            }

            public final l.b onValidateSchema(b bVar) {
                HashMap hashMap = new HashMap(10);
                hashMap.put("id", new f.a("id", "INTEGER", false, 1, (String) null, 1));
                hashMap.put("request_type", new f.a("request_type", "TEXT", true, 0, (String) null, 1));
                hashMap.put("request_url", new f.a("request_url", "TEXT", true, 0, (String) null, 1));
                hashMap.put("query_params", new f.a("query_params", "TEXT", false, 0, (String) null, 1));
                hashMap.put(H5Logger.HEADER, new f.a(H5Logger.HEADER, "TEXT", false, 0, (String) null, 1));
                hashMap.put("body_data", new f.a("body_data", "TEXT", false, 0, (String) null, 1));
                hashMap.put(Payload.RESPONSE, new f.a(Payload.RESPONSE, "TEXT", true, 0, (String) null, 1));
                hashMap.put("last_request_time", new f.a("last_request_time", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("max_age", new f.a("max_age", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("hit_count", new f.a("hit_count", "INTEGER", true, 0, (String) null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new f.d("index_PassbookCache_request_type_request_url_body_data", true, Arrays.asList(new String[]{"request_type", "request_url", "body_data"})));
                f fVar = new f("PassbookCache", hashMap, hashSet, hashSet2);
                f a2 = f.a(bVar, "PassbookCache");
                if (fVar.equals(a2)) {
                    return new l.b(true, (String) null);
                }
                return new l.b(false, "PassbookCache(net.one97.paytm.passbook.caching.db.PassbookCache).\n Expected:\n" + fVar + "\n Found:\n" + a2);
            }
        }, "a761daf9a5bb9f9fc3f2db173e7b42ec", "3868fbbe36e5903ba729da7de9fb0587");
        c.b.a a2 = c.b.a(aVar.f4374b);
        a2.f4547b = aVar.f4375c;
        a2.f4548c = lVar;
        return aVar.f4373a.a(a2.a());
    }

    public final g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), "PassbookCache");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `PassbookCache`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.b("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.d()) {
                b2.c("VACUUM");
            }
        }
    }

    public final b a() {
        b bVar;
        if (this.f57109b != null) {
            return this.f57109b;
        }
        synchronized (this) {
            if (this.f57109b == null) {
                this.f57109b = new c(this);
            }
            bVar = this.f57109b;
        }
        return bVar;
    }
}
