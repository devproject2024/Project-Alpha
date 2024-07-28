package com.paytm.contactsSdk.manager;

import android.content.Context;
import com.paytm.contactsSdk.database.ContactsDatabase;
import kotlin.g.b.k;

public final class DatabaseManager {
    public static final DatabaseManager INSTANCE = new DatabaseManager();
    private static ContactsDatabase database;
    private static boolean initDone;

    private DatabaseManager() {
    }

    public final synchronized void initDatabase(Context context) {
        k.c(context, "context");
        if (!initDone) {
            initDone = true;
            database = ContactsDatabase.Companion.getInstance(context);
        }
    }

    public final ContactsDatabase getDatabase() {
        ContactsDatabase contactsDatabase = database;
        if (contactsDatabase == null) {
            k.a("database");
        }
        return contactsDatabase;
    }
}
