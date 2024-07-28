package com.google.android.datatransport.runtime.scheduling.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.a.ac;

final /* synthetic */ class af implements ac.a {

    /* renamed from: a  reason: collision with root package name */
    private static final af f7837a = new af();

    private af() {
    }

    public static ac.a a() {
        return f7837a;
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
