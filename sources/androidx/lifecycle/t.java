package androidx.lifecycle;

import androidx.arch.core.b.b;
import androidx.lifecycle.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public final class t extends k {

    /* renamed from: b  reason: collision with root package name */
    private androidx.arch.core.b.a<p, a> f3675b = new androidx.arch.core.b.a<>();

    /* renamed from: c  reason: collision with root package name */
    private k.b f3676c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<q> f3677d;

    /* renamed from: e  reason: collision with root package name */
    private int f3678e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3679f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3680g = false;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<k.b> f3681h = new ArrayList<>();

    public t(q qVar) {
        this.f3677d = new WeakReference<>(qVar);
        this.f3676c = k.b.INITIALIZED;
    }

    public final void a(k.a aVar) {
        b(b(aVar));
    }

    public final void b(k.b bVar) {
        if (this.f3676c != bVar) {
            this.f3676c = bVar;
            if (this.f3679f || this.f3678e != 0) {
                this.f3680g = true;
                return;
            }
            this.f3679f = true;
            d();
            this.f3679f = false;
        }
    }

    private boolean b() {
        if (this.f3675b.f1855e == 0) {
            return true;
        }
        k.b bVar = ((a) this.f3675b.f1852b.getValue()).f3684a;
        k.b bVar2 = ((a) this.f3675b.f1853c.getValue()).f3684a;
        if (bVar == bVar2 && this.f3676c == bVar2) {
            return true;
        }
        return false;
    }

    private k.b c(p pVar) {
        androidx.arch.core.b.a<p, a> aVar = this.f3675b;
        k.b bVar = null;
        b.c<K, V> cVar = aVar.c(pVar) ? aVar.f1851a.get(pVar).f1859d : null;
        k.b bVar2 = cVar != null ? ((a) cVar.getValue()).f3684a : null;
        if (!this.f3681h.isEmpty()) {
            ArrayList<k.b> arrayList = this.f3681h;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.f3676c, bVar2), bVar);
    }

    public final void a(p pVar) {
        q qVar;
        a aVar = new a(pVar, this.f3676c == k.b.DESTROYED ? k.b.DESTROYED : k.b.INITIALIZED);
        if (this.f3675b.a(pVar, aVar) == null && (qVar = (q) this.f3677d.get()) != null) {
            boolean z = this.f3678e != 0 || this.f3679f;
            k.b c2 = c(pVar);
            this.f3678e++;
            while (aVar.f3684a.compareTo(c2) < 0 && this.f3675b.c(pVar)) {
                c(aVar.f3684a);
                aVar.a(qVar, d(aVar.f3684a));
                c();
                c2 = c(pVar);
            }
            if (!z) {
                d();
            }
            this.f3678e--;
        }
    }

    private void c() {
        ArrayList<k.b> arrayList = this.f3681h;
        arrayList.remove(arrayList.size() - 1);
    }

    private void c(k.b bVar) {
        this.f3681h.add(bVar);
    }

    public final void b(p pVar) {
        this.f3675b.b(pVar);
    }

    public final k.b a() {
        return this.f3676c;
    }

    static k.b b(k.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return k.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return k.b.STARTED;
            case ON_RESUME:
                return k.b.RESUMED;
            case ON_DESTROY:
                return k.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value ".concat(String.valueOf(aVar)));
        }
    }

    /* renamed from: androidx.lifecycle.t$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3683b = new int[k.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0086 */
        static {
            /*
                androidx.lifecycle.k$b[] r0 = androidx.lifecycle.k.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3683b = r0
                r0 = 1
                int[] r1 = f3683b     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.lifecycle.k$b r2 = androidx.lifecycle.k.b.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f3683b     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.lifecycle.k$b r3 = androidx.lifecycle.k.b.CREATED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f3683b     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.lifecycle.k$b r4 = androidx.lifecycle.k.b.STARTED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f3683b     // Catch:{ NoSuchFieldError -> 0x0035 }
                androidx.lifecycle.k$b r5 = androidx.lifecycle.k.b.RESUMED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = f3683b     // Catch:{ NoSuchFieldError -> 0x0040 }
                androidx.lifecycle.k$b r6 = androidx.lifecycle.k.b.DESTROYED     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                androidx.lifecycle.k$a[] r5 = androidx.lifecycle.k.a.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f3682a = r5
                int[] r5 = f3682a     // Catch:{ NoSuchFieldError -> 0x0053 }
                androidx.lifecycle.k$a r6 = androidx.lifecycle.k.a.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = f3682a     // Catch:{ NoSuchFieldError -> 0x005d }
                androidx.lifecycle.k$a r5 = androidx.lifecycle.k.a.ON_STOP     // Catch:{ NoSuchFieldError -> 0x005d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = f3682a     // Catch:{ NoSuchFieldError -> 0x0067 }
                androidx.lifecycle.k$a r1 = androidx.lifecycle.k.a.ON_START     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = f3682a     // Catch:{ NoSuchFieldError -> 0x0071 }
                androidx.lifecycle.k$a r1 = androidx.lifecycle.k.a.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f3682a     // Catch:{ NoSuchFieldError -> 0x007b }
                androidx.lifecycle.k$a r1 = androidx.lifecycle.k.a.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f3682a     // Catch:{ NoSuchFieldError -> 0x0086 }
                androidx.lifecycle.k$a r1 = androidx.lifecycle.k.a.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = f3682a     // Catch:{ NoSuchFieldError -> 0x0091 }
                androidx.lifecycle.k$a r1 = androidx.lifecycle.k.a.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.t.AnonymousClass1.<clinit>():void");
        }
    }

    private static k.a d(k.b bVar) {
        int i2 = AnonymousClass1.f3683b[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return k.a.ON_START;
            }
            if (i2 == 3) {
                return k.a.ON_RESUME;
            }
            if (i2 == 4) {
                throw new IllegalArgumentException();
            } else if (i2 != 5) {
                throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(bVar)));
            }
        }
        return k.a.ON_CREATE;
    }

    private void a(q qVar) {
        b<K, V>.d a2 = this.f3675b.a();
        while (a2.hasNext() && !this.f3680g) {
            Map.Entry entry = (Map.Entry) a2.next();
            a aVar = (a) entry.getValue();
            while (aVar.f3684a.compareTo(this.f3676c) < 0 && !this.f3680g && this.f3675b.c(entry.getKey())) {
                c(aVar.f3684a);
                aVar.a(qVar, d(aVar.f3684a));
                c();
            }
        }
    }

    private void b(q qVar) {
        k.a aVar;
        androidx.arch.core.b.a<p, a> aVar2 = this.f3675b;
        b.C0026b bVar = new b.C0026b(aVar2.f1853c, aVar2.f1852b);
        aVar2.f1854d.put(bVar, Boolean.FALSE);
        while (bVar.hasNext() && !this.f3680g) {
            Map.Entry entry = (Map.Entry) bVar.next();
            a aVar3 = (a) entry.getValue();
            while (aVar3.f3684a.compareTo(this.f3676c) > 0 && !this.f3680g && this.f3675b.c(entry.getKey())) {
                k.b bVar2 = aVar3.f3684a;
                int i2 = AnonymousClass1.f3683b[bVar2.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        aVar = k.a.ON_DESTROY;
                    } else if (i2 == 3) {
                        aVar = k.a.ON_STOP;
                    } else if (i2 == 4) {
                        aVar = k.a.ON_PAUSE;
                    } else if (i2 != 5) {
                        throw new IllegalArgumentException("Unexpected state value ".concat(String.valueOf(bVar2)));
                    } else {
                        throw new IllegalArgumentException();
                    }
                    c(b(aVar));
                    aVar3.a(qVar, aVar);
                    c();
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private void d() {
        q qVar = (q) this.f3677d.get();
        if (qVar != null) {
            while (!b()) {
                this.f3680g = false;
                if (this.f3676c.compareTo(((a) this.f3675b.f1852b.getValue()).f3684a) < 0) {
                    b(qVar);
                }
                b.c<K, V> cVar = this.f3675b.f1853c;
                if (!this.f3680g && cVar != null && this.f3676c.compareTo(((a) cVar.getValue()).f3684a) > 0) {
                    a(qVar);
                }
            }
            this.f3680g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    static k.b a(k.b bVar, k.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        k.b f3684a;

        /* renamed from: b  reason: collision with root package name */
        o f3685b;

        a(p pVar, k.b bVar) {
            this.f3685b = v.a((Object) pVar);
            this.f3684a = bVar;
        }

        /* access modifiers changed from: package-private */
        public final void a(q qVar, k.a aVar) {
            k.b b2 = t.b(aVar);
            this.f3684a = t.a(this.f3684a, b2);
            this.f3685b.a(qVar, aVar);
            this.f3684a = b2;
        }
    }

    @Deprecated
    public final void a(k.b bVar) {
        b(bVar);
    }
}
