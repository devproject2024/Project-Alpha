package com.google.android.datatransport.runtime.scheduling.a;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.a.i;

final /* synthetic */ class u implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private static final u f7871a = new u();

    private u() {
    }

    public static i.a a() {
        return f7871a;
    }

    public final Object a(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
