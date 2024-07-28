package com.trello.rxlifecycle4.android;

import com.trello.rxlifecycle4.b;
import com.trello.rxlifecycle4.d;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.h;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final h<a, a> f33765a = new h<a, a>() {
        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            a aVar = (a) obj;
            switch (AnonymousClass3.f33767a[aVar.ordinal()]) {
                case 1:
                    return a.DESTROY;
                case 2:
                    return a.STOP;
                case 3:
                    return a.PAUSE;
                case 4:
                    return a.STOP;
                case 5:
                    return a.DESTROY;
                case 6:
                    throw new com.trello.rxlifecycle4.c("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + aVar + " not yet implemented");
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final h<b, b> f33766b = new h<b, b>() {
        public final /* synthetic */ Object apply(Object obj) throws Throwable {
            b bVar = (b) obj;
            switch (AnonymousClass3.f33768b[bVar.ordinal()]) {
                case 1:
                    return b.DETACH;
                case 2:
                    return b.DESTROY;
                case 3:
                    return b.DESTROY_VIEW;
                case 4:
                    return b.STOP;
                case 5:
                    return b.PAUSE;
                case 6:
                    return b.STOP;
                case 7:
                    return b.DESTROY_VIEW;
                case 8:
                    return b.DESTROY;
                case 9:
                    return b.DETACH;
                case 10:
                    throw new com.trello.rxlifecycle4.c("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + bVar + " not yet implemented");
            }
        }
    };

    public static <T> b<T> a(p<a> pVar) {
        return d.a(pVar, f33765a);
    }

    public static <T> b<T> b(p<b> pVar) {
        return d.a(pVar, f33766b);
    }

    /* renamed from: com.trello.rxlifecycle4.android.c$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33767a = new int[a.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f33768b = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b5 */
        static {
            /*
                com.trello.rxlifecycle4.android.b[] r0 = com.trello.rxlifecycle4.android.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33768b = r0
                r0 = 1
                int[] r1 = f33768b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.trello.rxlifecycle4.android.b r2 = com.trello.rxlifecycle4.android.b.ATTACH     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f33768b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.trello.rxlifecycle4.android.b r3 = com.trello.rxlifecycle4.android.b.CREATE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f33768b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.trello.rxlifecycle4.android.b r4 = com.trello.rxlifecycle4.android.b.CREATE_VIEW     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f33768b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.trello.rxlifecycle4.android.b r5 = com.trello.rxlifecycle4.android.b.START     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = f33768b     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.trello.rxlifecycle4.android.b r6 = com.trello.rxlifecycle4.android.b.RESUME     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                r5 = 6
                int[] r6 = f33768b     // Catch:{ NoSuchFieldError -> 0x004b }
                com.trello.rxlifecycle4.android.b r7 = com.trello.rxlifecycle4.android.b.PAUSE     // Catch:{ NoSuchFieldError -> 0x004b }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r6 = f33768b     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.trello.rxlifecycle4.android.b r7 = com.trello.rxlifecycle4.android.b.STOP     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r8 = 7
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r6 = f33768b     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.trello.rxlifecycle4.android.b r7 = com.trello.rxlifecycle4.android.b.DESTROY_VIEW     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r8 = 8
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r6 = f33768b     // Catch:{ NoSuchFieldError -> 0x006e }
                com.trello.rxlifecycle4.android.b r7 = com.trello.rxlifecycle4.android.b.DESTROY     // Catch:{ NoSuchFieldError -> 0x006e }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r8 = 9
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r6 = f33768b     // Catch:{ NoSuchFieldError -> 0x007a }
                com.trello.rxlifecycle4.android.b r7 = com.trello.rxlifecycle4.android.b.DETACH     // Catch:{ NoSuchFieldError -> 0x007a }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r8 = 10
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                com.trello.rxlifecycle4.android.a[] r6 = com.trello.rxlifecycle4.android.a.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f33767a = r6
                int[] r6 = f33767a     // Catch:{ NoSuchFieldError -> 0x008d }
                com.trello.rxlifecycle4.android.a r7 = com.trello.rxlifecycle4.android.a.CREATE     // Catch:{ NoSuchFieldError -> 0x008d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r0 = f33767a     // Catch:{ NoSuchFieldError -> 0x0097 }
                com.trello.rxlifecycle4.android.a r6 = com.trello.rxlifecycle4.android.a.START     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = f33767a     // Catch:{ NoSuchFieldError -> 0x00a1 }
                com.trello.rxlifecycle4.android.a r1 = com.trello.rxlifecycle4.android.a.RESUME     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = f33767a     // Catch:{ NoSuchFieldError -> 0x00ab }
                com.trello.rxlifecycle4.android.a r1 = com.trello.rxlifecycle4.android.a.PAUSE     // Catch:{ NoSuchFieldError -> 0x00ab }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ab }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00ab }
            L_0x00ab:
                int[] r0 = f33767a     // Catch:{ NoSuchFieldError -> 0x00b5 }
                com.trello.rxlifecycle4.android.a r1 = com.trello.rxlifecycle4.android.a.STOP     // Catch:{ NoSuchFieldError -> 0x00b5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b5 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00b5 }
            L_0x00b5:
                int[] r0 = f33767a     // Catch:{ NoSuchFieldError -> 0x00bf }
                com.trello.rxlifecycle4.android.a r1 = com.trello.rxlifecycle4.android.a.DESTROY     // Catch:{ NoSuchFieldError -> 0x00bf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bf }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00bf }
            L_0x00bf:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.trello.rxlifecycle4.android.c.AnonymousClass3.<clinit>():void");
        }
    }
}
