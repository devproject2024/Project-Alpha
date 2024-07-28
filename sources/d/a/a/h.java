package d.a.a;

import java.util.ArrayList;
import java.util.List;

final class h {

    /* renamed from: d  reason: collision with root package name */
    private static final List<h> f45974d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object f45975a;

    /* renamed from: b  reason: collision with root package name */
    m f45976b;

    /* renamed from: c  reason: collision with root package name */
    h f45977c;

    private h(Object obj, m mVar) {
        this.f45975a = obj;
        this.f45976b = mVar;
    }

    static h a(m mVar, Object obj) {
        synchronized (f45974d) {
            int size = f45974d.size();
            if (size <= 0) {
                return new h(obj, mVar);
            }
            h remove = f45974d.remove(size - 1);
            remove.f45975a = obj;
            remove.f45976b = mVar;
            remove.f45977c = null;
            return remove;
        }
    }

    static void a(h hVar) {
        hVar.f45975a = null;
        hVar.f45976b = null;
        hVar.f45977c = null;
        synchronized (f45974d) {
            if (f45974d.size() < 10000) {
                f45974d.add(hVar);
            }
        }
    }
}
