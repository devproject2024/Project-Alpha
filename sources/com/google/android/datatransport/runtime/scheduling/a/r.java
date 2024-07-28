package com.google.android.datatransport.runtime.scheduling.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.a.i;

final /* synthetic */ class r implements i.c {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f7868a;

    r(SQLiteDatabase sQLiteDatabase) {
        this.f7868a = sQLiteDatabase;
    }

    public final Object a() {
        return this.f7868a.beginTransaction();
    }
}
