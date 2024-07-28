package a.a.a.a.a.b;

import a.a.a.a.a.c.d;
import a.a.a.a.a.e.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final i f677a;

    private a(i iVar) {
        this.f677a = iVar;
    }

    public static a a(b bVar) {
        i iVar = (i) bVar;
        c.a((Object) bVar, "AdSession is null");
        if (iVar.f703c.f740b == null) {
            c.a(iVar);
            a aVar = new a(iVar);
            iVar.f703c.f740b = aVar;
            return aVar;
        }
        throw new IllegalStateException("AdEvents already exists for AdSession");
    }

    public final void a() {
        c.a(this.f677a);
        if (f.NATIVE == this.f677a.f701a.f678a) {
            if (!this.f677a.e()) {
                try {
                    this.f677a.a();
                } catch (Exception unused) {
                }
            }
            if (this.f677a.e()) {
                i iVar = this.f677a;
                if (!iVar.f706f) {
                    a.a.a.a.a.g.a aVar = iVar.f703c;
                    d.a();
                    d.a(aVar.c(), "publishImpressionEvent", new Object[0]);
                    iVar.f706f = true;
                    return;
                }
                throw new IllegalStateException("Impression event can only be sent once");
            }
            return;
        }
        throw new IllegalStateException("Impression event is not expected from the Native AdSession");
    }
}
