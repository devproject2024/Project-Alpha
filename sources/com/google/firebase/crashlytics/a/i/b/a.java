package com.google.firebase.crashlytics.a.i.b;

import com.google.firebase.crashlytics.a.i.a.c;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final c f38633a;

    /* renamed from: b  reason: collision with root package name */
    private final d f38634b;

    public a(c cVar, d dVar) {
        this.f38633a = cVar;
        this.f38634b = dVar;
    }

    /* renamed from: com.google.firebase.crashlytics.a.i.b.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f38635a = new int[c.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.google.firebase.crashlytics.a.i.a.c$a[] r0 = com.google.firebase.crashlytics.a.i.a.c.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f38635a = r0
                int[] r0 = f38635a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.firebase.crashlytics.a.i.a.c$a r1 = com.google.firebase.crashlytics.a.i.a.c.a.JAVA     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f38635a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.firebase.crashlytics.a.i.a.c$a r1 = com.google.firebase.crashlytics.a.i.a.c.a.NATIVE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.i.b.a.AnonymousClass1.<clinit>():void");
        }
    }

    public final boolean a(com.google.firebase.crashlytics.a.i.a.a aVar, boolean z) {
        int i2 = AnonymousClass1.f38635a[aVar.f38620c.g().ordinal()];
        if (i2 == 1) {
            this.f38633a.a(aVar, z);
            return true;
        } else if (i2 != 2) {
            return false;
        } else {
            this.f38634b.a(aVar, z);
            return true;
        }
    }
}
