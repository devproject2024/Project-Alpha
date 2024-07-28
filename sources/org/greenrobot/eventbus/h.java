package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

final class h {

    /* renamed from: d  reason: collision with root package name */
    private static final List<h> f72880d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object f72881a;

    /* renamed from: b  reason: collision with root package name */
    n f72882b;

    /* renamed from: c  reason: collision with root package name */
    h f72883c;

    private h(Object obj, n nVar) {
        this.f72881a = obj;
        this.f72882b = nVar;
    }

    static h a(n nVar, Object obj) {
        synchronized (f72880d) {
            int size = f72880d.size();
            if (size <= 0) {
                return new h(obj, nVar);
            }
            h remove = f72880d.remove(size - 1);
            remove.f72881a = obj;
            remove.f72882b = nVar;
            remove.f72883c = null;
            return remove;
        }
    }

    static void a(h hVar) {
        hVar.f72881a = null;
        hVar.f72882b = null;
        hVar.f72883c = null;
        synchronized (f72880d) {
            if (f72880d.size() < 10000) {
                f72880d.add(hVar);
            }
        }
    }
}
