package androidx.work.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.work.impl.utils.c;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static androidx.room.a.a f5349a = new androidx.room.a.a() {
        public final void migrate(androidx.sqlite.db.b bVar) {
            bVar.c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.c("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            bVar.c("DROP TABLE IF EXISTS alarmInfo");
            bVar.c("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static androidx.room.a.a f5350b = new androidx.room.a.a() {
        public final void migrate(androidx.sqlite.db.b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.c("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static androidx.room.a.a f5351c = new androidx.room.a.a() {
        public final void migrate(androidx.sqlite.db.b bVar) {
            bVar.c("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            bVar.c("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static androidx.room.a.a f5352d = new androidx.room.a.a() {
        public final void migrate(androidx.sqlite.db.b bVar) {
            bVar.c("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static androidx.room.a.a f5353e = new androidx.room.a.a() {
        public final void migrate(androidx.sqlite.db.b bVar) {
            bVar.c("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static androidx.room.a.a f5354f = new androidx.room.a.a() {
        public final void migrate(androidx.sqlite.db.b bVar) {
            bVar.c("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    };

    public static class a extends androidx.room.a.a {

        /* renamed from: a  reason: collision with root package name */
        final Context f5355a;

        public a(Context context, int i2, int i3) {
            super(i2, i3);
            this.f5355a = context;
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            if (this.endVersion >= 10) {
                bVar.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.f5355a.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    public static class b extends androidx.room.a.a {

        /* renamed from: a  reason: collision with root package name */
        final Context f5356a;

        public b(Context context) {
            super(9, 10);
            this.f5356a = context;
        }

        public final void migrate(androidx.sqlite.db.b bVar) {
            bVar.c("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            SharedPreferences sharedPreferences = this.f5356a.getSharedPreferences("androidx.work.util.preferences", 0);
            if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                long j = 0;
                long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
                if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                    j = 1;
                }
                bVar.a();
                try {
                    bVar.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                    bVar.a("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j)});
                    sharedPreferences.edit().clear().apply();
                    bVar.c();
                } finally {
                    bVar.b();
                }
            }
            c.a(this.f5356a, bVar);
        }
    }
}
