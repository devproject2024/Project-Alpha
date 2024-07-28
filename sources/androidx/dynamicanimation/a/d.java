package androidx.dynamicanimation.a;

import androidx.dynamicanimation.a.b;

public final class d extends b<d> {
    private e x = null;
    private float y = Float.MAX_VALUE;
    private boolean z = false;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
    }

    public final d a(e eVar) {
        this.x = eVar;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(long j) {
        if (this.z) {
            float f2 = this.y;
            if (f2 != Float.MAX_VALUE) {
                this.x.f14575e = (double) f2;
                this.y = Float.MAX_VALUE;
            }
            this.p = (float) this.x.f14575e;
            this.o = 0.0f;
            this.z = false;
            return true;
        }
        if (this.y != Float.MAX_VALUE) {
            long j2 = j / 2;
            b.a a2 = this.x.a((double) this.p, (double) this.o, j2);
            e eVar = this.x;
            eVar.f14575e = (double) this.y;
            this.y = Float.MAX_VALUE;
            b.a a3 = eVar.a((double) a2.f14568a, (double) a2.f14569b, j2);
            this.p = a3.f14568a;
            this.o = a3.f14569b;
        } else {
            b.a a4 = this.x.a((double) this.p, (double) this.o, j);
            this.p = a4.f14568a;
            this.o = a4.f14569b;
        }
        this.p = Math.max(this.p, this.v);
        this.p = Math.min(this.p, this.u);
        float f3 = this.p;
        float f4 = this.o;
        e eVar2 = this.x;
        if (!(((double) Math.abs(f4)) < eVar2.f14574d && ((double) Math.abs(f3 - ((float) eVar2.f14575e))) < eVar2.f14573c)) {
            return false;
        }
        this.p = (float) this.x.f14575e;
        this.o = 0.0f;
        return true;
    }

    public final void b() {
        e eVar = this.x;
        if (eVar != null) {
            double d2 = (double) ((float) eVar.f14575e);
            if (d2 > ((double) this.u)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (d2 >= ((double) this.v)) {
                e eVar2 = this.x;
                eVar2.f14573c = Math.abs((double) (this.w * 0.75f));
                eVar2.f14574d = eVar2.f14573c * 62.5d;
                super.b();
            } else {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }
}
