package com.paytm.contactsSdk.database;

import android.content.Context;
import androidx.room.a.a;
import androidx.room.i;
import androidx.room.j;
import com.paytm.contactsSdk.database.daos.ContactsDao;
import com.paytm.contactsSdk.database.daos.ContactsPhonesDao;
import com.paytm.contactsSdk.database.daos.DynamiceMappingDao;
import com.paytm.contactsSdk.database.daos.EnrichmentDao;
import kotlin.g.b.g;
import kotlin.g.b.k;

public abstract class ContactsDatabase extends j {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static final a MIGRATION_1_2 = new ContactsDatabase$Companion$MIGRATION_1_2$1(1, 2);
    /* access modifiers changed from: private */
    public static ContactsDatabase sInstance;

    public abstract ContactsDao contactsDao();

    public abstract ContactsPhonesDao contactsPhonesDao();

    public abstract DynamiceMappingDao dynamicMappingDao();

    public abstract EnrichmentDao enrichmentDao();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final synchronized ContactsDatabase getInstance(Context context) {
            ContactsDatabase access$getSInstance$cp;
            k.c(context, "context");
            if (ContactsDatabase.sInstance == null) {
                ContactsDatabase.sInstance = i.a(context.getApplicationContext(), ContactsDatabase.class, Tables.CONTACTS).a(getMIGRATION_1_2()).c();
            }
            access$getSInstance$cp = ContactsDatabase.sInstance;
            if (access$getSInstance$cp == null) {
                k.a();
            }
            return access$getSInstance$cp;
        }

        public final a getMIGRATION_1_2() {
            return ContactsDatabase.MIGRATION_1_2;
        }
    }
}
