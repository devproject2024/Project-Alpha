package com.google.android.datatransport.runtime.scheduling.a;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.h;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.scheduling.a.i;

final /* synthetic */ class w implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f7873a;

    /* renamed from: b  reason: collision with root package name */
    private final l f7874b;

    /* renamed from: c  reason: collision with root package name */
    private final h f7875c;

    w(i iVar, l lVar, h hVar) {
        this.f7873a = iVar;
        this.f7874b = lVar;
        this.f7875c = hVar;
    }

    public final Object a(Object obj) {
        return i.a(this.f7873a, this.f7874b, this.f7875c, (SQLiteDatabase) obj);
    }
}
