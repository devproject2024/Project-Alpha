package net.one97.paytm.contacts.db;

import androidx.room.b.f;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import com.paytm.contactsSdk.database.ContactColumn;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import net.one97.paytm.contacts.b.a;
import net.one97.paytm.contacts.b.c;
import net.one97.paytm.contacts.b.d;
import net.one97.paytm.contacts.b.e;
import net.one97.paytm.contacts.b.g;
import net.one97.paytm.contacts.b.h;
import net.one97.paytm.contacts.b.i;
import net.one97.paytm.contacts.b.k;
import net.one97.paytm.contacts.b.m;
import net.one97.paytm.contacts.b.n;

public final class ContactDatabase_Impl extends ContactDatabase {

    /* renamed from: b  reason: collision with root package name */
    private volatile k f50148b;

    /* renamed from: c  reason: collision with root package name */
    private volatile m f50149c;

    /* renamed from: d  reason: collision with root package name */
    private volatile a f50150d;

    /* renamed from: e  reason: collision with root package name */
    private volatile g f50151e;

    /* renamed from: f  reason: collision with root package name */
    private volatile e f50152f;

    /* renamed from: g  reason: collision with root package name */
    private volatile i f50153g;

    /* renamed from: h  reason: collision with root package name */
    private volatile c f50154h;

    public final androidx.sqlite.db.c createOpenHelper(androidx.room.a aVar) {
        l lVar = new l(aVar, new l.a() {
            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `payee_info` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `payeeInfoId` TEXT NOT NULL, `name` TEXT, `nickName` TEXT, `isDirty` INTEGER, `isDeleted` INTEGER, `type` INTEGER, `version` TEXT, `imageUrl` TEXT)");
                bVar.c("CREATE UNIQUE INDEX `index_payee_info_payeeInfoId` ON `payee_info` (`payeeInfoId`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `payee_meta_info` (`row_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `payeeInfoId` TEXT NOT NULL, `payeeMetaId` TEXT, `phoneNumber` TEXT, `name` TEXT, `nickName` TEXT, `imageUrl` TEXT, `type` INTEGER NOT NULL, `status` TEXT, `isPrimary` INTEGER NOT NULL, `isDeleted` INTEGER, `newContactVisibility` TEXT, `newVisibilityExpiryTime` TEXT)");
                bVar.c("CREATE UNIQUE INDEX `index_payee_meta_info_row_id` ON `payee_meta_info` (`row_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `payment_instrument_details` (`row_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `paymentInstrumentId` TEXT, `type` TEXT, `status` TEXT, `score` TEXT, `payeeInfoId` TEXT, `payeeMetaId` TEXT NOT NULL, `mobileNo` TEXT, `custId` TEXT, `bankName` TEXT, `instrument_meta_status` TEXT, `accountNo` TEXT, `ifsc` TEXT, `vpa` TEXT, `expiryTime` TEXT)");
                bVar.c("CREATE TABLE IF NOT EXISTS `non_existed_contacts` (`row_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `contactId` TEXT NOT NULL, `type` INTEGER)");
                bVar.c("CREATE UNIQUE INDEX `index_non_existed_contacts_contactId` ON `non_existed_contacts` (`contactId`)");
                bVar.c("CREATE UNIQUE INDEX `index_non_existed_contacts_type` ON `non_existed_contacts` (`type`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `configuration_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `type` INTEGER, `fallbackEnabled` INTEGER)");
                bVar.c("CREATE UNIQUE INDEX `index_configuration_table_type` ON `configuration_table` (`type`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `payee_info_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `payeeInfoId` TEXT NOT NULL, `isDirty` INTEGER, `isDeleted` INTEGER, `type` INTEGER, `newContactVisibility` TEXT, `version` TEXT)");
                bVar.c("CREATE UNIQUE INDEX `index_payee_info_table_payeeInfoId` ON `payee_info_table` (`payeeInfoId`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `beneficiary_meta_details` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `payeeInfoId` TEXT NOT NULL, `name` TEXT, `nickname` TEXT, `contact_status` TEXT, `contact_type` INTEGER, `paymentInstrumentId` TEXT, `instrumentType` TEXT, `score` TEXT, `instrumentStatus` TEXT, `contact_image_url` TEXT, `mobileNo` TEXT, `custId` TEXT, `bankName` TEXT, `instrument_meta_status` TEXT, `accountNo` TEXT, `ifsc` TEXT, `vpa` TEXT)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"71e6883cc9b3a4a955e57653e7653938\")");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `payee_info`");
                bVar.c("DROP TABLE IF EXISTS `payee_meta_info`");
                bVar.c("DROP TABLE IF EXISTS `payment_instrument_details`");
                bVar.c("DROP TABLE IF EXISTS `non_existed_contacts`");
                bVar.c("DROP TABLE IF EXISTS `configuration_table`");
                bVar.c("DROP TABLE IF EXISTS `payee_info_table`");
                bVar.c("DROP TABLE IF EXISTS `beneficiary_meta_details`");
            }

            public final void onCreate(b bVar) {
                if (ContactDatabase_Impl.this.mCallbacks != null) {
                    int size = ContactDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ContactDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(b bVar) {
                b unused = ContactDatabase_Impl.this.mDatabase = bVar;
                ContactDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (ContactDatabase_Impl.this.mCallbacks != null) {
                    int size = ContactDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ContactDatabase_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void validateMigration(b bVar) {
                b bVar2 = bVar;
                HashMap hashMap = new HashMap(9);
                hashMap.put("id", new f.a("id", "INTEGER", true, 1));
                hashMap.put("payeeInfoId", new f.a("payeeInfoId", "TEXT", true, 0));
                hashMap.put("name", new f.a("name", "TEXT", false, 0));
                hashMap.put("nickName", new f.a("nickName", "TEXT", false, 0));
                hashMap.put("isDirty", new f.a("isDirty", "INTEGER", false, 0));
                hashMap.put("isDeleted", new f.a("isDeleted", "INTEGER", false, 0));
                hashMap.put("type", new f.a("type", "INTEGER", false, 0));
                hashMap.put("version", new f.a("version", "TEXT", false, 0));
                hashMap.put("imageUrl", new f.a("imageUrl", "TEXT", false, 0));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                String str = "version";
                String str2 = "isDirty";
                String str3 = "id";
                hashSet2.add(new f.d("index_payee_info_payeeInfoId", true, Arrays.asList(new String[]{"payeeInfoId"})));
                f fVar = new f("payee_info", hashMap, hashSet, hashSet2);
                f a2 = f.a(bVar2, "payee_info");
                if (fVar.equals(a2)) {
                    HashMap hashMap2 = new HashMap(13);
                    hashMap2.put("row_id", new f.a("row_id", "INTEGER", true, 1));
                    hashMap2.put("payeeInfoId", new f.a("payeeInfoId", "TEXT", true, 0));
                    hashMap2.put("payeeMetaId", new f.a("payeeMetaId", "TEXT", false, 0));
                    hashMap2.put("phoneNumber", new f.a("phoneNumber", "TEXT", false, 0));
                    hashMap2.put("name", new f.a("name", "TEXT", false, 0));
                    hashMap2.put("nickName", new f.a("nickName", "TEXT", false, 0));
                    hashMap2.put("imageUrl", new f.a("imageUrl", "TEXT", false, 0));
                    hashMap2.put("type", new f.a("type", "INTEGER", true, 0));
                    hashMap2.put("status", new f.a("status", "TEXT", false, 0));
                    hashMap2.put(ContactColumn.IS_PRIMARY, new f.a(ContactColumn.IS_PRIMARY, "INTEGER", true, 0));
                    hashMap2.put("isDeleted", new f.a("isDeleted", "INTEGER", false, 0));
                    hashMap2.put("newContactVisibility", new f.a("newContactVisibility", "TEXT", false, 0));
                    hashMap2.put("newVisibilityExpiryTime", new f.a("newVisibilityExpiryTime", "TEXT", false, 0));
                    HashSet hashSet3 = new HashSet(0);
                    HashSet hashSet4 = new HashSet(1);
                    hashSet4.add(new f.d("index_payee_meta_info_row_id", true, Arrays.asList(new String[]{"row_id"})));
                    f fVar2 = new f("payee_meta_info", hashMap2, hashSet3, hashSet4);
                    f a3 = f.a(bVar2, "payee_meta_info");
                    if (fVar2.equals(a3)) {
                        HashMap hashMap3 = new HashMap(15);
                        hashMap3.put("row_id", new f.a("row_id", "INTEGER", true, 1));
                        hashMap3.put("paymentInstrumentId", new f.a("paymentInstrumentId", "TEXT", false, 0));
                        hashMap3.put("type", new f.a("type", "TEXT", false, 0));
                        hashMap3.put("status", new f.a("status", "TEXT", false, 0));
                        hashMap3.put("score", new f.a("score", "TEXT", false, 0));
                        hashMap3.put("payeeInfoId", new f.a("payeeInfoId", "TEXT", false, 0));
                        hashMap3.put("payeeMetaId", new f.a("payeeMetaId", "TEXT", true, 0));
                        hashMap3.put("mobileNo", new f.a("mobileNo", "TEXT", false, 0));
                        hashMap3.put("custId", new f.a("custId", "TEXT", false, 0));
                        hashMap3.put("bankName", new f.a("bankName", "TEXT", false, 0));
                        hashMap3.put("instrument_meta_status", new f.a("instrument_meta_status", "TEXT", false, 0));
                        hashMap3.put("accountNo", new f.a("accountNo", "TEXT", false, 0));
                        hashMap3.put("ifsc", new f.a("ifsc", "TEXT", false, 0));
                        hashMap3.put("vpa", new f.a("vpa", "TEXT", false, 0));
                        hashMap3.put("expiryTime", new f.a("expiryTime", "TEXT", false, 0));
                        f fVar3 = new f("payment_instrument_details", hashMap3, new HashSet(0), new HashSet(0));
                        f a4 = f.a(bVar2, "payment_instrument_details");
                        if (fVar3.equals(a4)) {
                            HashMap hashMap4 = new HashMap(3);
                            hashMap4.put("row_id", new f.a("row_id", "INTEGER", true, 1));
                            hashMap4.put("contactId", new f.a("contactId", "TEXT", true, 0));
                            hashMap4.put("type", new f.a("type", "INTEGER", false, 0));
                            HashSet hashSet5 = new HashSet(0);
                            HashSet hashSet6 = new HashSet(2);
                            hashSet6.add(new f.d("index_non_existed_contacts_contactId", true, Arrays.asList(new String[]{"contactId"})));
                            hashSet6.add(new f.d("index_non_existed_contacts_type", true, Arrays.asList(new String[]{"type"})));
                            f fVar4 = new f("non_existed_contacts", hashMap4, hashSet5, hashSet6);
                            f a5 = f.a(bVar2, "non_existed_contacts");
                            if (fVar4.equals(a5)) {
                                HashMap hashMap5 = new HashMap(4);
                                String str4 = str3;
                                hashMap5.put(str4, new f.a(str4, "INTEGER", true, 1));
                                hashMap5.put("timestamp", new f.a("timestamp", "INTEGER", true, 0));
                                hashMap5.put("type", new f.a("type", "INTEGER", false, 0));
                                hashMap5.put("fallbackEnabled", new f.a("fallbackEnabled", "INTEGER", false, 0));
                                HashSet hashSet7 = new HashSet(0);
                                HashSet hashSet8 = new HashSet(1);
                                hashSet8.add(new f.d("index_configuration_table_type", true, Arrays.asList(new String[]{"type"})));
                                f fVar5 = new f("configuration_table", hashMap5, hashSet7, hashSet8);
                                f a6 = f.a(bVar2, "configuration_table");
                                if (fVar5.equals(a6)) {
                                    HashMap hashMap6 = new HashMap(7);
                                    hashMap6.put(str4, new f.a(str4, "INTEGER", true, 1));
                                    hashMap6.put("payeeInfoId", new f.a("payeeInfoId", "TEXT", true, 0));
                                    String str5 = str2;
                                    hashMap6.put(str5, new f.a(str5, "INTEGER", false, 0));
                                    hashMap6.put("isDeleted", new f.a("isDeleted", "INTEGER", false, 0));
                                    hashMap6.put("type", new f.a("type", "INTEGER", false, 0));
                                    hashMap6.put("newContactVisibility", new f.a("newContactVisibility", "TEXT", false, 0));
                                    String str6 = str;
                                    hashMap6.put(str6, new f.a(str6, "TEXT", false, 0));
                                    HashSet hashSet9 = new HashSet(0);
                                    HashSet hashSet10 = new HashSet(1);
                                    hashSet10.add(new f.d("index_payee_info_table_payeeInfoId", true, Arrays.asList(new String[]{"payeeInfoId"})));
                                    f fVar6 = new f("payee_info_table", hashMap6, hashSet9, hashSet10);
                                    f a7 = f.a(bVar2, "payee_info_table");
                                    if (fVar6.equals(a7)) {
                                        HashMap hashMap7 = new HashMap(18);
                                        hashMap7.put(str4, new f.a(str4, "INTEGER", true, 1));
                                        hashMap7.put("payeeInfoId", new f.a("payeeInfoId", "TEXT", true, 0));
                                        hashMap7.put("name", new f.a("name", "TEXT", false, 0));
                                        hashMap7.put("nickname", new f.a("nickname", "TEXT", false, 0));
                                        hashMap7.put("contact_status", new f.a("contact_status", "TEXT", false, 0));
                                        hashMap7.put("contact_type", new f.a("contact_type", "INTEGER", false, 0));
                                        hashMap7.put("paymentInstrumentId", new f.a("paymentInstrumentId", "TEXT", false, 0));
                                        hashMap7.put("instrumentType", new f.a("instrumentType", "TEXT", false, 0));
                                        hashMap7.put("score", new f.a("score", "TEXT", false, 0));
                                        hashMap7.put("instrumentStatus", new f.a("instrumentStatus", "TEXT", false, 0));
                                        hashMap7.put("contact_image_url", new f.a("contact_image_url", "TEXT", false, 0));
                                        hashMap7.put("mobileNo", new f.a("mobileNo", "TEXT", false, 0));
                                        hashMap7.put("custId", new f.a("custId", "TEXT", false, 0));
                                        hashMap7.put("bankName", new f.a("bankName", "TEXT", false, 0));
                                        hashMap7.put("instrument_meta_status", new f.a("instrument_meta_status", "TEXT", false, 0));
                                        hashMap7.put("accountNo", new f.a("accountNo", "TEXT", false, 0));
                                        hashMap7.put("ifsc", new f.a("ifsc", "TEXT", false, 0));
                                        hashMap7.put("vpa", new f.a("vpa", "TEXT", false, 0));
                                        f fVar7 = new f("beneficiary_meta_details", hashMap7, new HashSet(0), new HashSet(0));
                                        f a8 = f.a(bVar2, "beneficiary_meta_details");
                                        if (!fVar7.equals(a8)) {
                                            throw new IllegalStateException("Migration didn't properly handle beneficiary_meta_details(net.one97.paytm.contacts.entities.db_entities.BeneficiaryMetaDetails).\n Expected:\n" + fVar7 + "\n Found:\n" + a8);
                                        }
                                        return;
                                    }
                                    throw new IllegalStateException("Migration didn't properly handle payee_info_table(net.one97.paytm.contacts.entities.db_entities.PayeeInfoDetails).\n Expected:\n" + fVar6 + "\n Found:\n" + a7);
                                }
                                throw new IllegalStateException("Migration didn't properly handle configuration_table(net.one97.paytm.contacts.entities.db_entities.Configuration).\n Expected:\n" + fVar5 + "\n Found:\n" + a6);
                            }
                            throw new IllegalStateException("Migration didn't properly handle non_existed_contacts(net.one97.paytm.contacts.entities.db_entities.NonExistedContacts).\n Expected:\n" + fVar4 + "\n Found:\n" + a5);
                        }
                        throw new IllegalStateException("Migration didn't properly handle payment_instrument_details(net.one97.paytm.contacts.entities.db_entities.PaymentInstrumentDetails).\n Expected:\n" + fVar3 + "\n Found:\n" + a4);
                    }
                    throw new IllegalStateException("Migration didn't properly handle payee_meta_info(net.one97.paytm.contacts.entities.db_entities.PayeeMetaInfo).\n Expected:\n" + fVar2 + "\n Found:\n" + a3);
                }
                throw new IllegalStateException("Migration didn't properly handle payee_info(net.one97.paytm.contacts.entities.db_entities.PayeeInfo).\n Expected:\n" + fVar + "\n Found:\n" + a2);
            }
        }, "71e6883cc9b3a4a955e57653e7653938", "2b779b28ea393ee1daa0c1aead288660");
        c.b.a a2 = c.b.a(aVar.f4374b);
        a2.f4547b = aVar.f4375c;
        a2.f4548c = lVar;
        return aVar.f4373a.a(a2.a());
    }

    public final androidx.room.g createInvalidationTracker() {
        return new androidx.room.g(this, "payee_info", "payee_meta_info", "payment_instrument_details", "non_existed_contacts", "configuration_table", "payee_info_table", "beneficiary_meta_details");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `payee_info`");
            b2.c("DELETE FROM `payee_meta_info`");
            b2.c("DELETE FROM `payment_instrument_details`");
            b2.c("DELETE FROM `non_existed_contacts`");
            b2.c("DELETE FROM `configuration_table`");
            b2.c("DELETE FROM `payee_info_table`");
            b2.c("DELETE FROM `beneficiary_meta_details`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.b("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.d()) {
                b2.c("VACUUM");
            }
        }
    }

    public final k a() {
        k kVar;
        if (this.f50148b != null) {
            return this.f50148b;
        }
        synchronized (this) {
            if (this.f50148b == null) {
                this.f50148b = new net.one97.paytm.contacts.b.l(this);
            }
            kVar = this.f50148b;
        }
        return kVar;
    }

    public final m b() {
        m mVar;
        if (this.f50149c != null) {
            return this.f50149c;
        }
        synchronized (this) {
            if (this.f50149c == null) {
                this.f50149c = new n(this);
            }
            mVar = this.f50149c;
        }
        return mVar;
    }

    public final a c() {
        a aVar;
        if (this.f50150d != null) {
            return this.f50150d;
        }
        synchronized (this) {
            if (this.f50150d == null) {
                this.f50150d = new net.one97.paytm.contacts.b.b(this);
            }
            aVar = this.f50150d;
        }
        return aVar;
    }

    public final g d() {
        g gVar;
        if (this.f50151e != null) {
            return this.f50151e;
        }
        synchronized (this) {
            if (this.f50151e == null) {
                this.f50151e = new h(this);
            }
            gVar = this.f50151e;
        }
        return gVar;
    }

    public final e e() {
        e eVar;
        if (this.f50152f != null) {
            return this.f50152f;
        }
        synchronized (this) {
            if (this.f50152f == null) {
                this.f50152f = new net.one97.paytm.contacts.b.f(this);
            }
            eVar = this.f50152f;
        }
        return eVar;
    }

    public final i f() {
        i iVar;
        if (this.f50153g != null) {
            return this.f50153g;
        }
        synchronized (this) {
            if (this.f50153g == null) {
                this.f50153g = new net.one97.paytm.contacts.b.j(this);
            }
            iVar = this.f50153g;
        }
        return iVar;
    }

    public final net.one97.paytm.contacts.b.c g() {
        net.one97.paytm.contacts.b.c cVar;
        if (this.f50154h != null) {
            return this.f50154h;
        }
        synchronized (this) {
            if (this.f50154h == null) {
                this.f50154h = new d(this);
            }
            cVar = this.f50154h;
        }
        return cVar;
    }
}
