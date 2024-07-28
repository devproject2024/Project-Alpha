package com.google.android.datatransport.runtime.scheduling.a;

import android.database.Cursor;
import com.google.android.datatransport.runtime.l;
import com.google.android.datatransport.runtime.scheduling.a.i;
import java.util.List;

final /* synthetic */ class o implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f7863a;

    /* renamed from: b  reason: collision with root package name */
    private final List f7864b;

    /* renamed from: c  reason: collision with root package name */
    private final l f7865c;

    o(i iVar, List list, l lVar) {
        this.f7863a = iVar;
        this.f7864b = list;
        this.f7865c = lVar;
    }

    public final Object a(Object obj) {
        return i.a(this.f7863a, this.f7864b, this.f7865c, (Cursor) obj);
    }
}
