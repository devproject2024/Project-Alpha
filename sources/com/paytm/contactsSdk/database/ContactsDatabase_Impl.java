package com.paytm.contactsSdk.database;

import androidx.room.a;
import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import com.paytm.contactsSdk.database.daos.ContactsDao;
import com.paytm.contactsSdk.database.daos.ContactsDao_Impl;
import com.paytm.contactsSdk.database.daos.ContactsPhonesDao;
import com.paytm.contactsSdk.database.daos.ContactsPhonesDao_Impl;
import com.paytm.contactsSdk.database.daos.DynamiceMappingDao;
import com.paytm.contactsSdk.database.daos.DynamiceMappingDao_Impl;
import com.paytm.contactsSdk.database.daos.EnrichmentDao;
import com.paytm.contactsSdk.database.daos.EnrichmentDao_Impl;
import java.util.HashMap;
import java.util.HashSet;

public final class ContactsDatabase_Impl extends ContactsDatabase {
    private volatile ContactsDao _contactsDao;
    private volatile ContactsPhonesDao _contactsPhonesDao;
    private volatile DynamiceMappingDao _dynamiceMappingDao;
    private volatile EnrichmentDao _enrichmentDao;

    public final c createOpenHelper(a aVar) {
        return aVar.f4373a.a(c.b.a(aVar.f4374b).a(aVar.f4375c).a((c.a) new l(aVar, new l.a(2) {
            public void onPostMigrate(b bVar) {
            }

            public void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `contacts` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `syncType` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `contacts_phones` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `contact_id` INTEGER NOT NULL, `phone` TEXT NOT NULL, `isPrimary` INTEGER NOT NULL)");
                bVar.c("CREATE TABLE IF NOT EXISTS `dynamic_mapping` (`feature` TEXT NOT NULL, `columnNumber` INTEGER NOT NULL, `bitCode` INTEGER NOT NULL, PRIMARY KEY(`feature`))");
                bVar.c("CREATE TABLE IF NOT EXISTS `enrichment_data` (`phoneNumber` TEXT NOT NULL, `enrichmentBitCodeCol_0` INTEGER NOT NULL, `enrichmentBitCodeCol_1` INTEGER NOT NULL, `enrichmentBitCodeCol_2` INTEGER NOT NULL, `enrichmentBitCodeCol_3` INTEGER NOT NULL, `featureJson` TEXT, PRIMARY KEY(`phoneNumber`))");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '687d74776ababa892af064234cf94b12')");
            }

            public void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `contacts`");
                bVar.c("DROP TABLE IF EXISTS `contacts_phones`");
                bVar.c("DROP TABLE IF EXISTS `dynamic_mapping`");
                bVar.c("DROP TABLE IF EXISTS `enrichment_data`");
                if (ContactsDatabase_Impl.this.mCallbacks != null) {
                    int size = ContactsDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ContactsDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public void onCreate(b bVar) {
                if (ContactsDatabase_Impl.this.mCallbacks != null) {
                    int size = ContactsDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ContactsDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public void onOpen(b bVar) {
                b unused = ContactsDatabase_Impl.this.mDatabase = bVar;
                ContactsDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (ContactsDatabase_Impl.this.mCallbacks != null) {
                    int size = ContactsDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ContactsDatabase_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public void onPreMigrate(b bVar) {
                androidx.room.b.c.a(bVar);
            }

            public l.b onValidateSchema(b bVar) {
                b bVar2 = bVar;
                HashMap hashMap = new HashMap(3);
                hashMap.put("id", new f.a("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("name", new f.a("name", "TEXT", true, 0, (String) null, 1));
                hashMap.put("syncType", new f.a("syncType", "INTEGER", true, 0, (String) null, 1));
                f fVar = new f(Tables.CONTACTS, hashMap, new HashSet(0), new HashSet(0));
                f a2 = f.a(bVar2, Tables.CONTACTS);
                if (!fVar.equals(a2)) {
                    return new l.b(false, "contacts(com.paytm.contactsSdk.models.Contact).\n Expected:\n" + fVar + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(4);
                hashMap2.put("id", new f.a("id", "INTEGER", true, 1, (String) null, 1));
                hashMap2.put(ContactColumn.CONTACT_ID, new f.a(ContactColumn.CONTACT_ID, "INTEGER", true, 0, (String) null, 1));
                hashMap2.put(ContactColumn.PHONE_NUMBER, new f.a(ContactColumn.PHONE_NUMBER, "TEXT", true, 0, (String) null, 1));
                hashMap2.put(ContactColumn.IS_PRIMARY, new f.a(ContactColumn.IS_PRIMARY, "INTEGER", true, 0, (String) null, 1));
                f fVar2 = new f(Tables.CONTACTS_PHONES, hashMap2, new HashSet(0), new HashSet(0));
                f a3 = f.a(bVar2, Tables.CONTACTS_PHONES);
                if (!fVar2.equals(a3)) {
                    return new l.b(false, "contacts_phones(com.paytm.contactsSdk.models.ContactPhone).\n Expected:\n" + fVar2 + "\n Found:\n" + a3);
                }
                HashMap hashMap3 = new HashMap(3);
                hashMap3.put("feature", new f.a("feature", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("columnNumber", new f.a("columnNumber", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("bitCode", new f.a("bitCode", "INTEGER", true, 0, (String) null, 1));
                f fVar3 = new f(Tables.DYNAMIC_MAPPING, hashMap3, new HashSet(0), new HashSet(0));
                f a4 = f.a(bVar2, Tables.DYNAMIC_MAPPING);
                if (!fVar3.equals(a4)) {
                    return new l.b(false, "dynamic_mapping(com.paytm.contactsSdk.models.DynamicMapping).\n Expected:\n" + fVar3 + "\n Found:\n" + a4);
                }
                HashMap hashMap4 = new HashMap(6);
                hashMap4.put("phoneNumber", new f.a("phoneNumber", "TEXT", true, 1, (String) null, 1));
                hashMap4.put("enrichmentBitCodeCol_0", new f.a("enrichmentBitCodeCol_0", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("enrichmentBitCodeCol_1", new f.a("enrichmentBitCodeCol_1", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("enrichmentBitCodeCol_2", new f.a("enrichmentBitCodeCol_2", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("enrichmentBitCodeCol_3", new f.a("enrichmentBitCodeCol_3", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("featureJson", new f.a("featureJson", "TEXT", false, 0, (String) null, 1));
                f fVar4 = new f(Tables.ENRICHMENT_DATA, hashMap4, new HashSet(0), new HashSet(0));
                f a5 = f.a(bVar2, Tables.ENRICHMENT_DATA);
                if (fVar4.equals(a5)) {
                    return new l.b(true, (String) null);
                }
                return new l.b(false, "enrichment_data(com.paytm.contactsSdk.models.EnrichmentData).\n Expected:\n" + fVar4 + "\n Found:\n" + a5);
            }
        }, "687d74776ababa892af064234cf94b12", "c6c06ccfaf206016074c24da5bafdef8")).a());
    }

    public final g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), Tables.CONTACTS, Tables.CONTACTS_PHONES, Tables.DYNAMIC_MAPPING, Tables.ENRICHMENT_DATA);
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `contacts`");
            b2.c("DELETE FROM `contacts_phones`");
            b2.c("DELETE FROM `dynamic_mapping`");
            b2.c("DELETE FROM `enrichment_data`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.b("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.d()) {
                b2.c("VACUUM");
            }
        }
    }

    public final ContactsDao contactsDao() {
        ContactsDao contactsDao;
        if (this._contactsDao != null) {
            return this._contactsDao;
        }
        synchronized (this) {
            if (this._contactsDao == null) {
                this._contactsDao = new ContactsDao_Impl(this);
            }
            contactsDao = this._contactsDao;
        }
        return contactsDao;
    }

    public final ContactsPhonesDao contactsPhonesDao() {
        ContactsPhonesDao contactsPhonesDao;
        if (this._contactsPhonesDao != null) {
            return this._contactsPhonesDao;
        }
        synchronized (this) {
            if (this._contactsPhonesDao == null) {
                this._contactsPhonesDao = new ContactsPhonesDao_Impl(this);
            }
            contactsPhonesDao = this._contactsPhonesDao;
        }
        return contactsPhonesDao;
    }

    public final DynamiceMappingDao dynamicMappingDao() {
        DynamiceMappingDao dynamiceMappingDao;
        if (this._dynamiceMappingDao != null) {
            return this._dynamiceMappingDao;
        }
        synchronized (this) {
            if (this._dynamiceMappingDao == null) {
                this._dynamiceMappingDao = new DynamiceMappingDao_Impl(this);
            }
            dynamiceMappingDao = this._dynamiceMappingDao;
        }
        return dynamiceMappingDao;
    }

    public final EnrichmentDao enrichmentDao() {
        EnrichmentDao enrichmentDao;
        if (this._enrichmentDao != null) {
            return this._enrichmentDao;
        }
        synchronized (this) {
            if (this._enrichmentDao == null) {
                this._enrichmentDao = new EnrichmentDao_Impl(this);
            }
            enrichmentDao = this._enrichmentDao;
        }
        return enrichmentDao;
    }
}
