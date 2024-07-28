package kotlin.c;

import kotlin.g.b.k;

public final class a {
    public static /* synthetic */ Thread a(boolean z, kotlin.g.a.a aVar, int i2) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        k.d(aVar, "block");
        C0832a aVar2 = new C0832a(aVar);
        if (z) {
            aVar2.start();
        }
        return aVar2;
    }

    /* renamed from: kotlin.c.a$a  reason: collision with other inner class name */
    public static final class C0832a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.a f47896a;

        C0832a(kotlin.g.a.a aVar) {
            this.f47896a = aVar;
        }

        public final void run() {
            this.f47896a.invoke();
        }
    }
}
