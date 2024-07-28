package com.google.android.datatransport.runtime.scheduling.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.a.i;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;

final /* synthetic */ class n implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final long f7862a;

    n(long j) {
        this.f7862a = j;
    }

    public final Object a(Object obj) {
        return Integer.valueOf(((SQLiteDatabase) obj).delete(EventsModuleManager.MODULE_NAME, "timestamp_ms < ?", new String[]{String.valueOf(this.f7862a)}));
    }
}
