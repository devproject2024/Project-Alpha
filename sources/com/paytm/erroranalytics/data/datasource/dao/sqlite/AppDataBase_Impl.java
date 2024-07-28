package com.paytm.erroranalytics.data.datasource.dao.sqlite;

import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.erroranalytics.data.datasource.dao.a;
import java.util.HashMap;
import java.util.HashSet;

public final class AppDataBase_Impl extends AppDataBase {

    /* renamed from: a  reason: collision with root package name */
    private volatile a f42802a;

    public final c createOpenHelper(androidx.room.a aVar) {
        return aVar.f4373a.a(c.b.a(aVar.f4374b).a(aVar.f4375c).a((c.a) new l(aVar, new l.a() {
            public final void onPostMigrate(b bVar) {
            }

            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `Event` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `event_type` TEXT, `device_id` TEXT, `customer_id` TEXT, `event_data` TEXT, `filter_dimensions` INTEGER NOT NULL, `longitude` TEXT, `latitude` TEXT, `default_location` INTEGER NOT NULL, `priority` INTEGER NOT NULL, `date_time` INTEGER NOT NULL, `event_log_time` INTEGER NOT NULL, `network_type` TEXT)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '692760e70ef3b6f8d59328a22c84114b')");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `Event`");
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
                HashMap hashMap = new HashMap(13);
                hashMap.put("id", new f.a("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put(ChatAnalyticsHelperKt.KEY_EVENT_TYPE, new f.a(ChatAnalyticsHelperKt.KEY_EVENT_TYPE, "TEXT", false, 0, (String) null, 1));
                hashMap.put("device_id", new f.a("device_id", "TEXT", false, 0, (String) null, 1));
                hashMap.put("customer_id", new f.a("customer_id", "TEXT", false, 0, (String) null, 1));
                hashMap.put("event_data", new f.a("event_data", "TEXT", false, 0, (String) null, 1));
                hashMap.put("filter_dimensions", new f.a("filter_dimensions", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("longitude", new f.a("longitude", "TEXT", false, 0, (String) null, 1));
                hashMap.put("latitude", new f.a("latitude", "TEXT", false, 0, (String) null, 1));
                hashMap.put("default_location", new f.a("default_location", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("priority", new f.a("priority", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("date_time", new f.a("date_time", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("event_log_time", new f.a("event_log_time", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("network_type", new f.a("network_type", "TEXT", false, 0, (String) null, 1));
                f fVar = new f("Event", hashMap, new HashSet(0), new HashSet(0));
                f a2 = f.a(bVar, "Event");
                if (fVar.equals(a2)) {
                    return new l.b(true, (String) null);
                }
                return new l.b(false, "Event(com.paytm.erroranalytics.models.storemodels.Event).\n Expected:\n" + fVar + "\n Found:\n" + a2);
            }
        }, "692760e70ef3b6f8d59328a22c84114b", "af6ffb8ec9d5f7df5149c5f45f9c73a6")).a());
    }

    public final g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), "Event");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `Event`");
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
        if (this.f42802a != null) {
            return this.f42802a;
        }
        synchronized (this) {
            if (this.f42802a == null) {
                this.f42802a = new com.paytm.erroranalytics.data.datasource.dao.b(this);
            }
            aVar = this.f42802a;
        }
        return aVar;
    }
}
