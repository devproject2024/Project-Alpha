package com.google.android.datatransport.runtime.scheduling.a;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.a.i;
import java.util.Map;

final /* synthetic */ class q implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final Map f7867a;

    q(Map map) {
        this.f7867a = map;
    }

    public final Object a(Object obj) {
        return i.a(this.f7867a, (Cursor) obj);
    }
}
