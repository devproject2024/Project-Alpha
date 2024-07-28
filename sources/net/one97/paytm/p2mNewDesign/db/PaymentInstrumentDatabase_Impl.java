package net.one97.paytm.p2mNewDesign.db;

import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import net.one97.paytm.p2mNewDesign.db.a.a;
import net.one97.paytm.p2mNewDesign.db.a.c;
import net.one97.paytm.p2mNewDesign.db.a.d;
import net.one97.paytm.p2mNewDesign.db.a.e;

public final class PaymentInstrumentDatabase_Impl extends PaymentInstrumentDatabase {

    /* renamed from: b  reason: collision with root package name */
    private volatile a f51204b;

    /* renamed from: c  reason: collision with root package name */
    private volatile e f51205c;

    /* renamed from: d  reason: collision with root package name */
    private volatile c f51206d;

    public final androidx.sqlite.db.c createOpenHelper(androidx.room.a aVar) {
        l lVar = new l(aVar, new l.a() {
            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `last_used_instrument_table` (`row_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `instrument_type` TEXT NOT NULL, `instrument_detail` TEXT NOT NULL, `last_used_time` INTEGER NOT NULL)");
                bVar.c("CREATE UNIQUE INDEX `index_last_used_instrument_table_instrument_type` ON `last_used_instrument_table` (`instrument_type`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `payment_instrument_cache` (`row_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `map_id` INTEGER NOT NULL, `instrument_type` TEXT NOT NULL, `instrument_priority` INTEGER NOT NULL, `instrument_detail` TEXT NOT NULL, `last_updated` INTEGER NOT NULL)");
                bVar.c("CREATE UNIQUE INDEX `index_payment_instrument_cache_map_id_instrument_type` ON `payment_instrument_cache` (`map_id`, `instrument_type`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `mapping_table` (`row_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT NOT NULL, `m_id` TEXT NOT NULL, `json` TEXT NOT NULL, `payment_status` INTEGER NOT NULL, `last_updated` INTEGER NOT NULL)");
                bVar.c("CREATE UNIQUE INDEX `index_mapping_table_user_id_m_id` ON `mapping_table` (`user_id`, `m_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"02727fd3ae11dfd1538a8c2458bab53e\")");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `last_used_instrument_table`");
                bVar.c("DROP TABLE IF EXISTS `payment_instrument_cache`");
                bVar.c("DROP TABLE IF EXISTS `mapping_table`");
            }

            public final void onCreate(b bVar) {
                if (PaymentInstrumentDatabase_Impl.this.mCallbacks != null) {
                    int size = PaymentInstrumentDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        PaymentInstrumentDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(b bVar) {
                b unused = PaymentInstrumentDatabase_Impl.this.mDatabase = bVar;
                PaymentInstrumentDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (PaymentInstrumentDatabase_Impl.this.mCallbacks != null) {
                    int size = PaymentInstrumentDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) PaymentInstrumentDatabase_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void validateMigration(b bVar) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("row_id", new f.a("row_id", "INTEGER", true, 1));
                hashMap.put("instrument_type", new f.a("instrument_type", "TEXT", true, 0));
                hashMap.put("instrument_detail", new f.a("instrument_detail", "TEXT", true, 0));
                hashMap.put("last_used_time", new f.a("last_used_time", "INTEGER", true, 0));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new f.d("index_last_used_instrument_table_instrument_type", true, Arrays.asList(new String[]{"instrument_type"})));
                f fVar = new f("last_used_instrument_table", hashMap, hashSet, hashSet2);
                f a2 = f.a(bVar, "last_used_instrument_table");
                if (fVar.equals(a2)) {
                    HashMap hashMap2 = new HashMap(6);
                    hashMap2.put("row_id", new f.a("row_id", "INTEGER", true, 1));
                    hashMap2.put("map_id", new f.a("map_id", "INTEGER", true, 0));
                    hashMap2.put("instrument_type", new f.a("instrument_type", "TEXT", true, 0));
                    hashMap2.put("instrument_priority", new f.a("instrument_priority", "INTEGER", true, 0));
                    hashMap2.put("instrument_detail", new f.a("instrument_detail", "TEXT", true, 0));
                    hashMap2.put("last_updated", new f.a("last_updated", "INTEGER", true, 0));
                    HashSet hashSet3 = new HashSet(0);
                    HashSet hashSet4 = new HashSet(1);
                    hashSet4.add(new f.d("index_payment_instrument_cache_map_id_instrument_type", true, Arrays.asList(new String[]{"map_id", "instrument_type"})));
                    f fVar2 = new f("payment_instrument_cache", hashMap2, hashSet3, hashSet4);
                    f a3 = f.a(bVar, "payment_instrument_cache");
                    if (fVar2.equals(a3)) {
                        HashMap hashMap3 = new HashMap(6);
                        hashMap3.put("row_id", new f.a("row_id", "INTEGER", true, 1));
                        hashMap3.put("user_id", new f.a("user_id", "TEXT", true, 0));
                        hashMap3.put("m_id", new f.a("m_id", "TEXT", true, 0));
                        hashMap3.put("json", new f.a("json", "TEXT", true, 0));
                        hashMap3.put("payment_status", new f.a("payment_status", "INTEGER", true, 0));
                        hashMap3.put("last_updated", new f.a("last_updated", "INTEGER", true, 0));
                        HashSet hashSet5 = new HashSet(0);
                        HashSet hashSet6 = new HashSet(1);
                        hashSet6.add(new f.d("index_mapping_table_user_id_m_id", true, Arrays.asList(new String[]{"user_id", "m_id"})));
                        f fVar3 = new f("mapping_table", hashMap3, hashSet5, hashSet6);
                        f a4 = f.a(bVar, "mapping_table");
                        if (!fVar3.equals(a4)) {
                            throw new IllegalStateException("Migration didn't properly handle mapping_table(net.one97.paytm.p2mNewDesign.db.entities.MappingTable).\n Expected:\n" + fVar3 + "\n Found:\n" + a4);
                        }
                        return;
                    }
                    throw new IllegalStateException("Migration didn't properly handle payment_instrument_cache(net.one97.paytm.p2mNewDesign.db.entities.PaymentInstrumentCache).\n Expected:\n" + fVar2 + "\n Found:\n" + a3);
                }
                throw new IllegalStateException("Migration didn't properly handle last_used_instrument_table(net.one97.paytm.p2mNewDesign.db.entities.LastUsedInstrument).\n Expected:\n" + fVar + "\n Found:\n" + a2);
            }
        }, "02727fd3ae11dfd1538a8c2458bab53e", "74ca4c1ccbbef186095e5277e04da937");
        c.b.a a2 = c.b.a(aVar.f4374b);
        a2.f4547b = aVar.f4375c;
        a2.f4548c = lVar;
        return aVar.f4373a.a(a2.a());
    }

    public final g createInvalidationTracker() {
        return new g(this, "last_used_instrument_table", "payment_instrument_cache", "mapping_table");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `last_used_instrument_table`");
            b2.c("DELETE FROM `payment_instrument_cache`");
            b2.c("DELETE FROM `mapping_table`");
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
        if (this.f51204b != null) {
            return this.f51204b;
        }
        synchronized (this) {
            if (this.f51204b == null) {
                this.f51204b = new net.one97.paytm.p2mNewDesign.db.a.b(this);
            }
            aVar = this.f51204b;
        }
        return aVar;
    }

    public final e b() {
        e eVar;
        if (this.f51205c != null) {
            return this.f51205c;
        }
        synchronized (this) {
            if (this.f51205c == null) {
                this.f51205c = new net.one97.paytm.p2mNewDesign.db.a.f(this);
            }
            eVar = this.f51205c;
        }
        return eVar;
    }

    public final net.one97.paytm.p2mNewDesign.db.a.c c() {
        net.one97.paytm.p2mNewDesign.db.a.c cVar;
        if (this.f51206d != null) {
            return this.f51206d;
        }
        synchronized (this) {
            if (this.f51206d == null) {
                this.f51206d = new d(this);
            }
            cVar = this.f51206d;
        }
        return cVar;
    }
}
