package exfilepicker.a.a;

import exfilepicker.a;

public final class b {

    /* renamed from: exfilepicker.a.a.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f46124a = new int[a.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                exfilepicker.a$b[] r0 = exfilepicker.a.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f46124a = r0
                int[] r0 = f46124a     // Catch:{ NoSuchFieldError -> 0x0014 }
                exfilepicker.a$b r1 = exfilepicker.a.b.NAME_DESC     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f46124a     // Catch:{ NoSuchFieldError -> 0x001f }
                exfilepicker.a$b r1 = exfilepicker.a.b.SIZE_ASC     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f46124a     // Catch:{ NoSuchFieldError -> 0x002a }
                exfilepicker.a$b r1 = exfilepicker.a.b.SIZE_DESC     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f46124a     // Catch:{ NoSuchFieldError -> 0x0035 }
                exfilepicker.a$b r1 = exfilepicker.a.b.DATE_ASC     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f46124a     // Catch:{ NoSuchFieldError -> 0x0040 }
                exfilepicker.a$b r1 = exfilepicker.a.b.DATE_DESC     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: exfilepicker.a.a.b.AnonymousClass1.<clinit>():void");
        }
    }

    public static a a(a.b bVar) {
        int i2 = AnonymousClass1.f46124a[bVar.ordinal()];
        if (i2 == 1) {
            return new f();
        }
        if (i2 == 2) {
            return new g();
        }
        if (i2 == 3) {
            return new h();
        }
        if (i2 == 4) {
            return new c();
        }
        if (i2 != 5) {
            return new e();
        }
        return new d();
    }
}
