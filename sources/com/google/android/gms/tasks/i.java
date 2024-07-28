package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class i implements a<Void, Task<List<Task<?>>>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Collection f12491a;

    i(Collection collection) {
        this.f12491a = collection;
    }

    public final /* synthetic */ Object a(Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f12491a);
        return h.a(arrayList);
    }
}
