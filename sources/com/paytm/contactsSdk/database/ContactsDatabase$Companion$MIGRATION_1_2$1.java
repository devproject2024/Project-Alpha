package com.paytm.contactsSdk.database;

import androidx.room.a.a;
import androidx.sqlite.db.b;
import kotlin.g.b.k;

public final class ContactsDatabase$Companion$MIGRATION_1_2$1 extends a {
    ContactsDatabase$Companion$MIGRATION_1_2$1(int i2, int i3) {
        super(i2, i3);
    }

    public final void migrate(b bVar) {
        k.c(bVar, "database");
        bVar.c("CREATE TABLE `dynamic_mapping` (`feature` TEXT NOT NULL, `columnNumber` INTEGER NOT NULL, `bitCode` INTEGER NOT NULL, PRIMARY KEY(`feature`))");
        bVar.c("CREATE TABLE `enrichment_data` (`phoneNumber` TEXT NOT NULL, `enrichmentBitCodeCol_0` INTEGER NOT NULL, `enrichmentBitCodeCol_1` INTEGER NOT NULL, `enrichmentBitCodeCol_2` INTEGER NOT NULL, `enrichmentBitCodeCol_3` INTEGER NOT NULL, `featureJson` TEXT,  PRIMARY KEY(`phoneNumber`))");
    }
}
