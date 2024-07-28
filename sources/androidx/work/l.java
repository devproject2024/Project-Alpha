package androidx.work;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private static l f5504a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final int f5505b = 20;

    public static synchronized void a(l lVar) {
        synchronized (l.class) {
            f5504a = lVar;
        }
    }

    public static String a(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i2 = f5505b;
        if (length >= i2) {
            sb.append(str.substring(0, i2));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (f5504a == null) {
                f5504a = new a(3);
            }
            lVar = f5504a;
        }
        return lVar;
    }

    public static class a extends l {

        /* renamed from: a  reason: collision with root package name */
        private int f5506a;

        public a(int i2) {
            this.f5506a = i2;
        }
    }
}
