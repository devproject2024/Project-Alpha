package net.one97.paytm.ups.manager;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.ups.db.UpsDb;

public final class DatabaseManager {
    public static final DatabaseManager INSTANCE = new DatabaseManager();
    private static UpsDb database;
    private static boolean initDone;

    private DatabaseManager() {
    }

    public final synchronized void initDatabase(Context context) {
        k.c(context, "context");
        if (!initDone) {
            initDone = true;
            database = UpsDb.Companion.getDbInstance(context);
        }
    }

    public final UpsDb getDatabase() {
        UpsDb upsDb = database;
        if (upsDb == null) {
            k.a("database");
        }
        return upsDb;
    }
}
