package com.google.android.datatransport.runtime.scheduling.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.a.i;

final /* synthetic */ class y implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f7877a;

    y(String str) {
        this.f7877a = str;
    }

    public final Object a(Object obj) {
        return i.a(this.f7877a, (SQLiteDatabase) obj);
    }
}
