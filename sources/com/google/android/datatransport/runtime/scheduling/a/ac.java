package com.google.android.datatransport.runtime.scheduling.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.util.Arrays;
import java.util.List;

final class ac extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    static int f7827a = 4;

    /* renamed from: d  reason: collision with root package name */
    private static final a f7828d = ad.a();

    /* renamed from: e  reason: collision with root package name */
    private static final a f7829e = ae.a();

    /* renamed from: f  reason: collision with root package name */
    private static final a f7830f = af.a();

    /* renamed from: g  reason: collision with root package name */
    private static final a f7831g = ag.a();

    /* renamed from: h  reason: collision with root package name */
    private static final List<a> f7832h = Arrays.asList(new a[]{f7828d, f7829e, f7830f, f7831g});

    /* renamed from: b  reason: collision with root package name */
    private final int f7833b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7834c = false;

    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static /* synthetic */ void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    static /* synthetic */ void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    static /* synthetic */ void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    ac(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.f7833b = i2;
    }

    public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f7834c = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        if (Build.VERSION.SDK_INT >= 16) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!this.f7834c) {
            onConfigure(sQLiteDatabase);
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, this.f7833b);
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i2) {
        e(sQLiteDatabase);
        a(sQLiteDatabase, 0, i2);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        e(sQLiteDatabase);
        a(sQLiteDatabase, i2, i3);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        a(sQLiteDatabase, i3);
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        e(sQLiteDatabase);
    }

    private static void a(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i3 <= f7832h.size()) {
            while (i2 < i3) {
                f7832h.get(i2).a(sQLiteDatabase);
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i2 + " to " + i3 + " was requested, but cannot be performed. Only " + f7832h.size() + " migrations are provided");
    }
}
