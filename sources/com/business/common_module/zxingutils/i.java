package com.business.common_module.zxingutils;

import com.google.zxing.t;
import com.google.zxing.u;
import java.util.List;

public final class i implements u {

    /* renamed from: a  reason: collision with root package name */
    private final ViewfinderView f7438a;

    public i(ViewfinderView viewfinderView) {
        this.f7438a = viewfinderView;
    }

    public final void a(t tVar) {
        List<t> list = this.f7438a.f7386a;
        synchronized (list) {
            list.add(tVar);
            int size = list.size();
            if (size > 20) {
                list.subList(0, size - 10).clear();
            }
        }
    }
}
