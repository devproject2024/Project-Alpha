package com.google.zxing.client.android;

import com.google.zxing.t;
import com.google.zxing.u;
import java.util.List;

public final class p implements u {

    /* renamed from: a  reason: collision with root package name */
    private final ViewfinderView f40271a;

    public p(ViewfinderView viewfinderView) {
        this.f40271a = viewfinderView;
    }

    public final void a(t tVar) {
        List<t> list = this.f40271a.f40099b;
        synchronized (list) {
            list.add(tVar);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }
}
