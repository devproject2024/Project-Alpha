package androidx.work.impl;

import android.os.Build;
import androidx.room.a;
import androidx.room.b.f;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.sqlite.db.c;
import androidx.work.impl.b.b;
import androidx.work.impl.b.e;
import androidx.work.impl.b.h;
import androidx.work.impl.b.i;
import androidx.work.impl.b.k;
import androidx.work.impl.b.n;
import androidx.work.impl.b.o;
import androidx.work.impl.b.q;
import androidx.work.impl.b.r;
import androidx.work.impl.b.t;
import androidx.work.impl.b.u;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: a  reason: collision with root package name */
    private volatile q f5101a;

    /* renamed from: b  reason: collision with root package name */
    private volatile b f5102b;

    /* renamed from: c  reason: collision with root package name */
    private volatile t f5103c;

    /* renamed from: d  reason: collision with root package name */
    private volatile h f5104d;

    /* renamed from: e  reason: collision with root package name */
    private volatile k f5105e;

    /* renamed from: f  reason: collision with root package name */
    private volatile n f5106f;

    /* renamed from: g  reason: collision with root package name */
    private volatile e f5107g;

    public final c createOpenHelper(a aVar) {
        return aVar.f4373a.a(c.b.a(aVar.f4374b).a(aVar.f4375c).a((c.a) new l(aVar, new l.a() {
            public final void onPostMigrate(androidx.sqlite.db.b bVar) {
            }

            public final void createAllTables(androidx.sqlite.db.b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                bVar.c("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                bVar.c("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cf029002fffdcadf079e8d0a1c9a70ac')");
            }

            public final void dropAllTables(androidx.sqlite.db.b bVar) {
                bVar.c("DROP TABLE IF EXISTS `Dependency`");
                bVar.c("DROP TABLE IF EXISTS `WorkSpec`");
                bVar.c("DROP TABLE IF EXISTS `WorkTag`");
                bVar.c("DROP TABLE IF EXISTS `SystemIdInfo`");
                bVar.c("DROP TABLE IF EXISTS `WorkName`");
                bVar.c("DROP TABLE IF EXISTS `WorkProgress`");
                bVar.c("DROP TABLE IF EXISTS `Preference`");
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        WorkDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onCreate(androidx.sqlite.db.b bVar) {
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        WorkDatabase_Impl.this.mCallbacks.get(i2);
                    }
                }
            }

            public final void onOpen(androidx.sqlite.db.b bVar) {
                androidx.sqlite.db.b unused = WorkDatabase_Impl.this.mDatabase = bVar;
                bVar.c("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) WorkDatabase_Impl.this.mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            public final void onPreMigrate(androidx.sqlite.db.b bVar) {
                androidx.room.b.c.a(bVar);
            }

            public final l.b onValidateSchema(androidx.sqlite.db.b bVar) {
                androidx.sqlite.db.b bVar2 = bVar;
                HashMap hashMap = new HashMap(2);
                hashMap.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
                hashMap.put("prerequisite_id", new f.a("prerequisite_id", "TEXT", true, 2, (String) null, 1));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                hashSet.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new f.d("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                hashSet2.add(new f.d("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"})));
                f fVar = new f("Dependency", hashMap, hashSet, hashSet2);
                f a2 = f.a(bVar2, "Dependency");
                if (!fVar.equals(a2)) {
                    return new l.b(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + fVar + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(24);
                hashMap2.put("id", new f.a("id", "TEXT", true, 1, (String) null, 1));
                hashMap2.put("state", new f.a("state", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("worker_class_name", new f.a("worker_class_name", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("input_merger_class_name", new f.a("input_merger_class_name", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("input", new f.a("input", "BLOB", true, 0, (String) null, 1));
                hashMap2.put("output", new f.a("output", "BLOB", true, 0, (String) null, 1));
                hashMap2.put("initial_delay", new f.a("initial_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("interval_duration", new f.a("interval_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("flex_duration", new f.a("flex_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("run_attempt_count", new f.a("run_attempt_count", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("backoff_policy", new f.a("backoff_policy", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("backoff_delay_duration", new f.a("backoff_delay_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("period_start_time", new f.a("period_start_time", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("minimum_retention_duration", new f.a("minimum_retention_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("schedule_requested_at", new f.a("schedule_requested_at", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("run_in_foreground", new f.a("run_in_foreground", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("required_network_type", new f.a("required_network_type", "INTEGER", false, 0, (String) null, 1));
                hashMap2.put("requires_charging", new f.a("requires_charging", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_device_idle", new f.a("requires_device_idle", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_battery_not_low", new f.a("requires_battery_not_low", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_storage_not_low", new f.a("requires_storage_not_low", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("trigger_content_update_delay", new f.a("trigger_content_update_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("trigger_max_content_delay", new f.a("trigger_max_content_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("content_uri_triggers", new f.a("content_uri_triggers", "BLOB", false, 0, (String) null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(2);
                hashSet4.add(new f.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"})));
                hashSet4.add(new f.d("index_WorkSpec_period_start_time", false, Arrays.asList(new String[]{"period_start_time"})));
                f fVar2 = new f("WorkSpec", hashMap2, hashSet3, hashSet4);
                f a3 = f.a(bVar2, "WorkSpec");
                if (!fVar2.equals(a3)) {
                    return new l.b(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + fVar2 + "\n Found:\n" + a3);
                }
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("tag", new f.a("tag", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 2, (String) null, 1));
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new f.d("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                f fVar3 = new f("WorkTag", hashMap3, hashSet5, hashSet6);
                f a4 = f.a(bVar2, "WorkTag");
                if (!fVar3.equals(a4)) {
                    return new l.b(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + fVar3 + "\n Found:\n" + a4);
                }
                HashMap hashMap4 = new HashMap(2);
                hashMap4.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
                hashMap4.put("system_id", new f.a("system_id", "INTEGER", true, 0, (String) null, 1));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                f fVar4 = new f("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
                f a5 = f.a(bVar2, "SystemIdInfo");
                if (!fVar4.equals(a5)) {
                    return new l.b(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + fVar4 + "\n Found:\n" + a5);
                }
                HashMap hashMap5 = new HashMap(2);
                hashMap5.put("name", new f.a("name", "TEXT", true, 1, (String) null, 1));
                hashMap5.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 2, (String) null, 1));
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new f.d("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                f fVar5 = new f("WorkName", hashMap5, hashSet8, hashSet9);
                f a6 = f.a(bVar2, "WorkName");
                if (!fVar5.equals(a6)) {
                    return new l.b(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + fVar5 + "\n Found:\n" + a6);
                }
                HashMap hashMap6 = new HashMap(2);
                hashMap6.put("work_spec_id", new f.a("work_spec_id", "TEXT", true, 1, (String) null, 1));
                hashMap6.put(H5Param.PROGRESS, new f.a(H5Param.PROGRESS, "BLOB", true, 0, (String) null, 1));
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new f.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                f fVar6 = new f("WorkProgress", hashMap6, hashSet10, new HashSet(0));
                f a7 = f.a(bVar2, "WorkProgress");
                if (!fVar6.equals(a7)) {
                    return new l.b(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + fVar6 + "\n Found:\n" + a7);
                }
                HashMap hashMap7 = new HashMap(2);
                hashMap7.put("key", new f.a("key", "TEXT", true, 1, (String) null, 1));
                hashMap7.put("long_value", new f.a("long_value", "INTEGER", false, 0, (String) null, 1));
                f fVar7 = new f("Preference", hashMap7, new HashSet(0), new HashSet(0));
                f a8 = f.a(bVar2, "Preference");
                if (fVar7.equals(a8)) {
                    return new l.b(true, (String) null);
                }
                return new l.b(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + fVar7 + "\n Found:\n" + a8);
            }
        }, "cf029002fffdcadf079e8d0a1c9a70ac", "8aff2efc47fafe870c738f727dfcfc6e")).a());
    }

    public final g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        androidx.sqlite.db.b b2 = super.getOpenHelper().b();
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (!z) {
            try {
                b2.c("PRAGMA foreign_keys = FALSE");
            } catch (Throwable th) {
                super.endTransaction();
                if (!z) {
                    b2.c("PRAGMA foreign_keys = TRUE");
                }
                b2.b("PRAGMA wal_checkpoint(FULL)").close();
                if (!b2.d()) {
                    b2.c("VACUUM");
                }
                throw th;
            }
        }
        super.beginTransaction();
        if (z) {
            b2.c("PRAGMA defer_foreign_keys = TRUE");
        }
        b2.c("DELETE FROM `Dependency`");
        b2.c("DELETE FROM `WorkSpec`");
        b2.c("DELETE FROM `WorkTag`");
        b2.c("DELETE FROM `SystemIdInfo`");
        b2.c("DELETE FROM `WorkName`");
        b2.c("DELETE FROM `WorkProgress`");
        b2.c("DELETE FROM `Preference`");
        super.setTransactionSuccessful();
        super.endTransaction();
        if (!z) {
            b2.c("PRAGMA foreign_keys = TRUE");
        }
        b2.b("PRAGMA wal_checkpoint(FULL)").close();
        if (!b2.d()) {
            b2.c("VACUUM");
        }
    }

    public final q b() {
        q qVar;
        if (this.f5101a != null) {
            return this.f5101a;
        }
        synchronized (this) {
            if (this.f5101a == null) {
                this.f5101a = new r(this);
            }
            qVar = this.f5101a;
        }
        return qVar;
    }

    public final b c() {
        b bVar;
        if (this.f5102b != null) {
            return this.f5102b;
        }
        synchronized (this) {
            if (this.f5102b == null) {
                this.f5102b = new androidx.work.impl.b.c(this);
            }
            bVar = this.f5102b;
        }
        return bVar;
    }

    public final t d() {
        t tVar;
        if (this.f5103c != null) {
            return this.f5103c;
        }
        synchronized (this) {
            if (this.f5103c == null) {
                this.f5103c = new u(this);
            }
            tVar = this.f5103c;
        }
        return tVar;
    }

    public final h e() {
        h hVar;
        if (this.f5104d != null) {
            return this.f5104d;
        }
        synchronized (this) {
            if (this.f5104d == null) {
                this.f5104d = new i(this);
            }
            hVar = this.f5104d;
        }
        return hVar;
    }

    public final k f() {
        k kVar;
        if (this.f5105e != null) {
            return this.f5105e;
        }
        synchronized (this) {
            if (this.f5105e == null) {
                this.f5105e = new androidx.work.impl.b.l(this);
            }
            kVar = this.f5105e;
        }
        return kVar;
    }

    public final n g() {
        n nVar;
        if (this.f5106f != null) {
            return this.f5106f;
        }
        synchronized (this) {
            if (this.f5106f == null) {
                this.f5106f = new o(this);
            }
            nVar = this.f5106f;
        }
        return nVar;
    }

    public final e h() {
        e eVar;
        if (this.f5107g != null) {
            return this.f5107g;
        }
        synchronized (this) {
            if (this.f5107g == null) {
                this.f5107g = new androidx.work.impl.b.f(this);
            }
            eVar = this.f5107g;
        }
        return eVar;
    }
}
