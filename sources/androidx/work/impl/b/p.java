package androidx.work.impl.b;

import androidx.work.c;
import androidx.work.e;
import androidx.work.l;
import androidx.work.u;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class p {
    public static final androidx.arch.core.c.a<List<b>, List<u>> r = new androidx.arch.core.c.a<List<b>, List<u>>() {
        public final /* synthetic */ Object apply(Object obj) {
            List<b> list = (List) obj;
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (b a2 : list) {
                arrayList.add(a2.a());
            }
            return arrayList;
        }
    };
    private static final String s = l.a("WorkSpec");

    /* renamed from: a  reason: collision with root package name */
    public String f5180a;

    /* renamed from: b  reason: collision with root package name */
    public u.a f5181b = u.a.ENQUEUED;

    /* renamed from: c  reason: collision with root package name */
    public String f5182c;

    /* renamed from: d  reason: collision with root package name */
    public String f5183d;

    /* renamed from: e  reason: collision with root package name */
    public e f5184e = e.f5092a;

    /* renamed from: f  reason: collision with root package name */
    public e f5185f = e.f5092a;

    /* renamed from: g  reason: collision with root package name */
    public long f5186g;

    /* renamed from: h  reason: collision with root package name */
    public long f5187h;

    /* renamed from: i  reason: collision with root package name */
    public long f5188i;
    public c j = c.f5072a;
    public int k;
    public androidx.work.a l = androidx.work.a.EXPONENTIAL;
    public long m = 30000;
    public long n;
    public long o;
    public long p = -1;
    public boolean q;

    public p(String str, String str2) {
        this.f5180a = str;
        this.f5182c = str2;
    }

    public p(p pVar) {
        this.f5180a = pVar.f5180a;
        this.f5182c = pVar.f5182c;
        this.f5181b = pVar.f5181b;
        this.f5183d = pVar.f5183d;
        this.f5184e = new e(pVar.f5184e);
        this.f5185f = new e(pVar.f5185f);
        this.f5186g = pVar.f5186g;
        this.f5187h = pVar.f5187h;
        this.f5188i = pVar.f5188i;
        this.j = new c(pVar.j);
        this.k = pVar.k;
        this.l = pVar.l;
        this.m = pVar.m;
        this.n = pVar.n;
        this.o = pVar.o;
        this.p = pVar.p;
        this.q = pVar.q;
    }

    public final boolean a() {
        return this.f5187h != 0;
    }

    public final boolean b() {
        return this.f5181b == u.a.ENQUEUED && this.k > 0;
    }

    public final void a(long j2, long j3) {
        if (j2 < 900000) {
            l.a();
            String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{900000L});
            j2 = 900000;
        }
        if (j3 < 300000) {
            l.a();
            String.format("Flex duration lesser than minimum allowed value; Changed to %s", new Object[]{300000L});
            j3 = 300000;
        }
        if (j3 > j2) {
            l.a();
            String.format("Flex duration greater than interval duration; Changed to %s", new Object[]{Long.valueOf(j2)});
            j3 = j2;
        }
        this.f5187h = j2;
        this.f5188i = j3;
    }

    public final long c() {
        long j2;
        boolean z = false;
        if (b()) {
            if (this.l == androidx.work.a.LINEAR) {
                z = true;
            }
            if (z) {
                j2 = this.m * ((long) this.k);
            } else {
                j2 = (long) Math.scalb((float) this.m, this.k - 1);
            }
            return this.n + Math.min(18000000, j2);
        }
        long j3 = 0;
        if (a()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j4 = this.n;
            if (j4 == 0) {
                j4 = this.f5186g + currentTimeMillis;
            }
            if (this.f5188i != this.f5187h) {
                z = true;
            }
            if (z) {
                if (this.n == 0) {
                    j3 = this.f5188i * -1;
                }
                return j4 + this.f5187h + j3;
            }
            if (this.n != 0) {
                j3 = this.f5187h;
            }
            return j4 + j3;
        }
        long j5 = this.n;
        if (j5 == 0) {
            j5 = System.currentTimeMillis();
        }
        return j5 + this.f5186g;
    }

    public final boolean d() {
        return !c.f5072a.equals(this.j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f5186g != pVar.f5186g || this.f5187h != pVar.f5187h || this.f5188i != pVar.f5188i || this.k != pVar.k || this.m != pVar.m || this.n != pVar.n || this.o != pVar.o || this.p != pVar.p || this.q != pVar.q || !this.f5180a.equals(pVar.f5180a) || this.f5181b != pVar.f5181b || !this.f5182c.equals(pVar.f5182c)) {
            return false;
        }
        String str = this.f5183d;
        if (str == null ? pVar.f5183d == null : str.equals(pVar.f5183d)) {
            return this.f5184e.equals(pVar.f5184e) && this.f5185f.equals(pVar.f5185f) && this.j.equals(pVar.j) && this.l == pVar.l;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((((this.f5180a.hashCode() * 31) + this.f5181b.hashCode()) * 31) + this.f5182c.hashCode()) * 31;
        String str = this.f5183d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j2 = this.f5186g;
        long j3 = this.f5187h;
        long j4 = this.f5188i;
        long j5 = this.m;
        long j6 = this.n;
        long j7 = this.o;
        long j8 = this.p;
        return ((((((((((((((((((((((((((hashCode + hashCode2) * 31) + this.f5184e.hashCode()) * 31) + this.f5185f.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.j.hashCode()) * 31) + this.k) * 31) + this.l.hashCode()) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.q ? 1 : 0);
    }

    public final String toString() {
        return "{WorkSpec: " + this.f5180a + "}";
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f5189a;

        /* renamed from: b  reason: collision with root package name */
        public u.a f5190b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5190b != aVar.f5190b) {
                return false;
            }
            return this.f5189a.equals(aVar.f5189a);
        }

        public final int hashCode() {
            return (this.f5189a.hashCode() * 31) + this.f5190b.hashCode();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f5191a;

        /* renamed from: b  reason: collision with root package name */
        public u.a f5192b;

        /* renamed from: c  reason: collision with root package name */
        public e f5193c;

        /* renamed from: d  reason: collision with root package name */
        public int f5194d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f5195e;

        /* renamed from: f  reason: collision with root package name */
        public List<e> f5196f;

        public final u a() {
            e eVar;
            List<e> list = this.f5196f;
            if (list == null || list.isEmpty()) {
                eVar = e.f5092a;
            } else {
                eVar = this.f5196f.get(0);
            }
            return new u(UUID.fromString(this.f5191a), this.f5192b, this.f5193c, this.f5195e, eVar, this.f5194d);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f5194d != bVar.f5194d) {
                return false;
            }
            String str = this.f5191a;
            if (str == null ? bVar.f5191a != null : !str.equals(bVar.f5191a)) {
                return false;
            }
            if (this.f5192b != bVar.f5192b) {
                return false;
            }
            e eVar = this.f5193c;
            if (eVar == null ? bVar.f5193c != null : !eVar.equals(bVar.f5193c)) {
                return false;
            }
            List<String> list = this.f5195e;
            if (list == null ? bVar.f5195e != null : !list.equals(bVar.f5195e)) {
                return false;
            }
            List<e> list2 = this.f5196f;
            List<e> list3 = bVar.f5196f;
            if (list2 != null) {
                return list2.equals(list3);
            }
            return list3 == null;
        }

        public final int hashCode() {
            String str = this.f5191a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            u.a aVar = this.f5192b;
            int hashCode2 = (hashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
            e eVar = this.f5193c;
            int hashCode3 = (((hashCode2 + (eVar != null ? eVar.hashCode() : 0)) * 31) + this.f5194d) * 31;
            List<String> list = this.f5195e;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            List<e> list2 = this.f5196f;
            if (list2 != null) {
                i2 = list2.hashCode();
            }
            return hashCode4 + i2;
        }
    }
}
