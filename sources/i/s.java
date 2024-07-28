package i;

final class s {

    /* renamed from: a  reason: collision with root package name */
    static r f46327a;

    /* renamed from: b  reason: collision with root package name */
    static long f46328b;

    private s() {
    }

    static r a() {
        synchronized (s.class) {
            if (f46327a == null) {
                return new r();
            }
            r rVar = f46327a;
            f46327a = rVar.f46325f;
            rVar.f46325f = null;
            f46328b -= 8192;
            return rVar;
        }
    }

    static void a(r rVar) {
        if (rVar.f46325f != null || rVar.f46326g != null) {
            throw new IllegalArgumentException();
        } else if (!rVar.f46323d) {
            synchronized (s.class) {
                if (f46328b + 8192 <= 65536) {
                    f46328b += 8192;
                    rVar.f46325f = f46327a;
                    rVar.f46322c = 0;
                    rVar.f46321b = 0;
                    f46327a = rVar;
                }
            }
        }
    }
}
