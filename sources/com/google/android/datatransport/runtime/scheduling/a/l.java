package com.google.android.datatransport.runtime.scheduling.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.a.i;

final /* synthetic */ class l implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f7859a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.l f7860b;

    l(i iVar, com.google.android.datatransport.runtime.l lVar) {
        this.f7859a = iVar;
        this.f7860b = lVar;
    }

    public final Object a(Object obj) {
        return i.a(this.f7859a, this.f7860b, (SQLiteDatabase) obj);
    }
}
