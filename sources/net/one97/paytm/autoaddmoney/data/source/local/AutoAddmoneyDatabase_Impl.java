package net.one97.paytm.autoaddmoney.data.source.local;

import androidx.room.a;
import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.b;
import androidx.sqlite.db.c;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.HashMap;
import java.util.HashSet;

public final class AutoAddmoneyDatabase_Impl extends AutoAddmoneyDatabase {

    /* renamed from: b  reason: collision with root package name */
    private volatile a f49246b;

    public final c createOpenHelper(a aVar) {
        l lVar = new l(aVar, new l.a() {
            public final void createAllTables(b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `tasks` (`completed` INTEGER NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `entryid` TEXT NOT NULL, PRIMARY KEY(`entryid`))");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"5b871a406ac8cf61e96cb6a9da5be535\")");
            }

            public final void dropAllTables(b bVar) {
                bVar.c("DROP TABLE IF EXISTS `tasks`");
            }

            public final void onCreate(b bVar) {
                if (AutoAddmoneyDatabase_Impl.this.mCallbacks != null) {
                    int size = AutoAddmoneyDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        AutoAddmoneyDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(b bVar) {
                b unused = AutoAddmoneyDatabase_Impl.this.mDatabase = bVar;
                AutoAddmoneyDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (AutoAddmoneyDatabase_Impl.this.mCallbacks != null) {
                    int size = AutoAddmoneyDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) AutoAddmoneyDatabase_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void validateMigration(b bVar) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("completed", new f.a("completed", "INTEGER", true, 0));
                hashMap.put("title", new f.a("title", "TEXT", true, 0));
                hashMap.put(RequestConfirmationDialogFragment.KEY_DESCRIPTION, new f.a(RequestConfirmationDialogFragment.KEY_DESCRIPTION, "TEXT", true, 0));
                hashMap.put("entryid", new f.a("entryid", "TEXT", true, 1));
                f fVar = new f("tasks", hashMap, new HashSet(0), new HashSet(0));
                f a2 = f.a(bVar, "tasks");
                if (!fVar.equals(a2)) {
                    throw new IllegalStateException("Migration didn't properly handle tasks(net.one97.paytm.autoaddmoney.data.source.local.savedCards).\n Expected:\n" + fVar + "\n Found:\n" + a2);
                }
            }
        }, "5b871a406ac8cf61e96cb6a9da5be535", "9b3ba59b8596d0f3c8657fc881473970");
        c.b.a a2 = c.b.a(aVar.f4374b);
        a2.f4547b = aVar.f4375c;
        a2.f4548c = lVar;
        return aVar.f4373a.a(a2.a());
    }

    public final g createInvalidationTracker() {
        return new g(this, "tasks");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.c("DELETE FROM `tasks`");
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
        if (this.f49246b != null) {
            return this.f49246b;
        }
        synchronized (this) {
            if (this.f49246b == null) {
                this.f49246b = new b(this);
            }
            aVar = this.f49246b;
        }
        return aVar;
    }
}
