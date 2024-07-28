package com.google.android.datatransport.runtime.scheduling.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.scheduling.a.i;

final /* synthetic */ class k implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final long f7857a;

    /* renamed from: b  reason: collision with root package name */
    private final l f7858b;

    k(long j, l lVar) {
        this.f7857a = j;
        this.f7858b = lVar;
    }

    public final Object a(Object obj) {
        return i.a(this.f7857a, this.f7858b, (SQLiteDatabase) obj);
    }
}
