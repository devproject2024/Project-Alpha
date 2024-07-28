package com.google.android.datatransport.runtime.scheduling.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.scheduling.a.i;

final /* synthetic */ class aa implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f7821a;

    /* renamed from: b  reason: collision with root package name */
    private final l f7822b;

    aa(i iVar, l lVar) {
        this.f7821a = iVar;
        this.f7822b = lVar;
    }

    public final Object a(Object obj) {
        return i.b(this.f7821a, this.f7822b, (SQLiteDatabase) obj);
    }
}
