package androidx.constraintlayout.a.a.a;

import androidx.constraintlayout.a.a.d;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Iterator;

public final class c extends p {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<p> f2016a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private int f2017b;

    public c(e eVar, int i2) {
        super(eVar);
        this.f2070h = i2;
        g();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f2070h == 0 ? "horizontal : " : "vertical : ");
        String sb2 = sb.toString();
        Iterator<p> it2 = this.f2016a.iterator();
        while (it2.hasNext()) {
            sb2 = ((sb2 + SimpleComparison.LESS_THAN_OPERATION) + it2.next()) + "> ";
        }
        return sb2;
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        int size = this.f2016a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f2016a.get(i2).a()) {
                return false;
            }
        }
        return true;
    }

    public final long b() {
        int size = this.f2016a.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            p pVar = this.f2016a.get(i2);
            j = j + ((long) pVar.j.f2032f) + pVar.b() + ((long) pVar.k.f2032f);
        }
        return j;
    }

    private void g() {
        e eVar;
        int i2;
        e eVar2 = this.f2066d;
        e m = eVar2.m(this.f2070h);
        while (true) {
            e eVar3 = m;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            }
            m = eVar2.m(this.f2070h);
        }
        this.f2066d = eVar;
        this.f2016a.add(eVar.a(this.f2070h));
        e n = eVar.n(this.f2070h);
        while (n != null) {
            this.f2016a.add(n.a(this.f2070h));
            n = n.n(this.f2070h);
        }
        Iterator<p> it2 = this.f2016a.iterator();
        while (it2.hasNext()) {
            p next = it2.next();
            if (this.f2070h == 0) {
                next.f2066d.f2098g = this;
            } else if (this.f2070h == 1) {
                next.f2066d.f2099h = this;
            }
        }
        if ((this.f2070h == 0 && ((f) this.f2066d.V).f2106d) && this.f2016a.size() > 1) {
            ArrayList<p> arrayList = this.f2016a;
            this.f2066d = arrayList.get(arrayList.size() - 1).f2066d;
        }
        if (this.f2070h == 0) {
            i2 = this.f2066d.aA;
        } else {
            i2 = this.f2066d.aB;
        }
        this.f2017b = i2;
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f2067e = null;
        Iterator<p> it2 = this.f2016a.iterator();
        while (it2.hasNext()) {
            it2.next().c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0191, code lost:
        if (r7 != r11) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01bd, code lost:
        if (r7 != r11) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c5, code lost:
        if (r2.f2069g.j != false) goto L_0x00c7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r22 = this;
            r0 = r22
            androidx.constraintlayout.a.a.a.f r1 = r0.j
            boolean r1 = r1.j
            if (r1 == 0) goto L_0x041b
            androidx.constraintlayout.a.a.a.f r1 = r0.k
            boolean r1 = r1.j
            if (r1 != 0) goto L_0x0010
            goto L_0x041b
        L_0x0010:
            androidx.constraintlayout.a.a.e r1 = r0.f2066d
            androidx.constraintlayout.a.a.e r1 = r1.V
            if (r1 == 0) goto L_0x001f
            boolean r3 = r1 instanceof androidx.constraintlayout.a.a.f
            if (r3 == 0) goto L_0x001f
            androidx.constraintlayout.a.a.f r1 = (androidx.constraintlayout.a.a.f) r1
            boolean r1 = r1.f2106d
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            androidx.constraintlayout.a.a.a.f r3 = r0.k
            int r3 = r3.f2033g
            androidx.constraintlayout.a.a.a.f r4 = r0.j
            int r4 = r4.f2033g
            int r3 = r3 - r4
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r4 = r0.f2016a
            int r4 = r4.size()
            r5 = 0
        L_0x0030:
            r6 = -1
            r7 = 8
            if (r5 >= r4) goto L_0x0047
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r8 = r0.f2016a
            java.lang.Object r8 = r8.get(r5)
            androidx.constraintlayout.a.a.a.p r8 = (androidx.constraintlayout.a.a.a.p) r8
            androidx.constraintlayout.a.a.e r8 = r8.f2066d
            int r8 = r8.an
            if (r8 == r7) goto L_0x0044
            goto L_0x0048
        L_0x0044:
            int r5 = r5 + 1
            goto L_0x0030
        L_0x0047:
            r5 = -1
        L_0x0048:
            int r8 = r4 + -1
            r9 = r8
        L_0x004b:
            if (r9 < 0) goto L_0x0060
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r10 = r0.f2016a
            java.lang.Object r10 = r10.get(r9)
            androidx.constraintlayout.a.a.a.p r10 = (androidx.constraintlayout.a.a.a.p) r10
            androidx.constraintlayout.a.a.e r10 = r10.f2066d
            int r10 = r10.an
            if (r10 == r7) goto L_0x005d
            r6 = r9
            goto L_0x0060
        L_0x005d:
            int r9 = r9 + -1
            goto L_0x004b
        L_0x0060:
            r9 = 0
        L_0x0061:
            r11 = 2
            r12 = 1
            if (r9 >= r11) goto L_0x00fb
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x006c:
            if (r13 >= r4) goto L_0x00ee
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r2 = r0.f2016a
            java.lang.Object r2 = r2.get(r13)
            androidx.constraintlayout.a.a.a.p r2 = (androidx.constraintlayout.a.a.a.p) r2
            androidx.constraintlayout.a.a.e r11 = r2.f2066d
            int r11 = r11.an
            if (r11 == r7) goto L_0x00e7
            int r16 = r16 + 1
            if (r13 <= 0) goto L_0x0087
            if (r13 < r5) goto L_0x0087
            androidx.constraintlayout.a.a.a.f r11 = r2.j
            int r11 = r11.f2032f
            int r14 = r14 + r11
        L_0x0087:
            androidx.constraintlayout.a.a.a.g r11 = r2.f2069g
            int r11 = r11.f2033g
            androidx.constraintlayout.a.a.e$a r7 = r2.f2068f
            androidx.constraintlayout.a.a.e$a r10 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r7 == r10) goto L_0x0093
            r7 = 1
            goto L_0x0094
        L_0x0093:
            r7 = 0
        L_0x0094:
            if (r7 == 0) goto L_0x00b4
            int r10 = r0.f2070h
            if (r10 != 0) goto L_0x00a5
            androidx.constraintlayout.a.a.e r10 = r2.f2066d
            androidx.constraintlayout.a.a.a.l r10 = r10.f2100i
            androidx.constraintlayout.a.a.a.g r10 = r10.f2069g
            boolean r10 = r10.j
            if (r10 != 0) goto L_0x00a5
            return
        L_0x00a5:
            int r10 = r0.f2070h
            if (r10 != r12) goto L_0x00c8
            androidx.constraintlayout.a.a.e r10 = r2.f2066d
            androidx.constraintlayout.a.a.a.n r10 = r10.j
            androidx.constraintlayout.a.a.a.g r10 = r10.f2069g
            boolean r10 = r10.j
            if (r10 != 0) goto L_0x00c8
            return
        L_0x00b4:
            int r10 = r2.f2065c
            if (r10 != r12) goto L_0x00c1
            if (r9 != 0) goto L_0x00c1
            androidx.constraintlayout.a.a.a.g r7 = r2.f2069g
            int r11 = r7.m
            int r15 = r15 + 1
            goto L_0x00c7
        L_0x00c1:
            androidx.constraintlayout.a.a.a.g r10 = r2.f2069g
            boolean r10 = r10.j
            if (r10 == 0) goto L_0x00c8
        L_0x00c7:
            r7 = 1
        L_0x00c8:
            if (r7 != 0) goto L_0x00dc
            int r15 = r15 + 1
            androidx.constraintlayout.a.a.e r7 = r2.f2066d
            float[] r7 = r7.aE
            int r10 = r0.f2070h
            r7 = r7[r10]
            r10 = 0
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 < 0) goto L_0x00dd
            float r17 = r17 + r7
            goto L_0x00dd
        L_0x00dc:
            int r14 = r14 + r11
        L_0x00dd:
            if (r13 >= r8) goto L_0x00e7
            if (r13 >= r6) goto L_0x00e7
            androidx.constraintlayout.a.a.a.f r2 = r2.k
            int r2 = r2.f2032f
            int r2 = -r2
            int r14 = r14 + r2
        L_0x00e7:
            int r13 = r13 + 1
            r7 = 8
            r11 = 2
            goto L_0x006c
        L_0x00ee:
            if (r14 < r3) goto L_0x00f8
            if (r15 == 0) goto L_0x00f8
            int r9 = r9 + 1
            r7 = 8
            goto L_0x0061
        L_0x00f8:
            r2 = r16
            goto L_0x0100
        L_0x00fb:
            r2 = 0
            r14 = 0
            r15 = 0
            r17 = 0
        L_0x0100:
            androidx.constraintlayout.a.a.a.f r7 = r0.j
            int r7 = r7.f2033g
            if (r1 == 0) goto L_0x010a
            androidx.constraintlayout.a.a.a.f r7 = r0.k
            int r7 = r7.f2033g
        L_0x010a:
            r9 = 1056964608(0x3f000000, float:0.5)
            if (r14 <= r3) goto L_0x0121
            r10 = 1073741824(0x40000000, float:2.0)
            if (r1 == 0) goto L_0x011a
            int r11 = r14 - r3
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            int r7 = r7 + r10
            goto L_0x0121
        L_0x011a:
            int r11 = r14 - r3
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            int r7 = r7 - r10
        L_0x0121:
            if (r15 <= 0) goto L_0x0225
            int r10 = r3 - r14
            float r10 = (float) r10
            float r11 = (float) r15
            float r11 = r10 / r11
            float r11 = r11 + r9
            int r11 = (int) r11
            r13 = 0
            r16 = 0
        L_0x012e:
            if (r13 >= r4) goto L_0x01dd
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r12 = r0.f2016a
            java.lang.Object r12 = r12.get(r13)
            androidx.constraintlayout.a.a.a.p r12 = (androidx.constraintlayout.a.a.a.p) r12
            androidx.constraintlayout.a.a.e r9 = r12.f2066d
            int r9 = r9.an
            r18 = r11
            r11 = 8
            if (r9 == r11) goto L_0x01c8
            androidx.constraintlayout.a.a.e$a r9 = r12.f2068f
            androidx.constraintlayout.a.a.e$a r11 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r9 != r11) goto L_0x01c8
            androidx.constraintlayout.a.a.a.g r9 = r12.f2069g
            boolean r9 = r9.j
            if (r9 != 0) goto L_0x01c8
            r9 = 0
            int r11 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0164
            androidx.constraintlayout.a.a.e r11 = r12.f2066d
            float[] r11 = r11.aE
            int r9 = r0.f2070h
            r9 = r11[r9]
            float r9 = r9 * r10
            float r9 = r9 / r17
            r11 = 1056964608(0x3f000000, float:0.5)
            float r9 = r9 + r11
            int r11 = (int) r9
            goto L_0x0166
        L_0x0164:
            r11 = r18
        L_0x0166:
            int r9 = r0.f2070h
            if (r9 != 0) goto L_0x0194
            androidx.constraintlayout.a.a.e r9 = r12.f2066d
            int r9 = r9.t
            r19 = r10
            androidx.constraintlayout.a.a.e r10 = r12.f2066d
            int r10 = r10.s
            r20 = r14
            int r14 = r12.f2065c
            r21 = r7
            r7 = 1
            if (r14 != r7) goto L_0x0186
            androidx.constraintlayout.a.a.a.g r7 = r12.f2069g
            int r7 = r7.m
            int r7 = java.lang.Math.min(r11, r7)
            goto L_0x0187
        L_0x0186:
            r7 = r11
        L_0x0187:
            int r7 = java.lang.Math.max(r10, r7)
            if (r9 <= 0) goto L_0x0191
            int r7 = java.lang.Math.min(r9, r7)
        L_0x0191:
            if (r7 == r11) goto L_0x01c2
            goto L_0x01bf
        L_0x0194:
            r21 = r7
            r19 = r10
            r20 = r14
            androidx.constraintlayout.a.a.e r7 = r12.f2066d
            int r7 = r7.w
            androidx.constraintlayout.a.a.e r9 = r12.f2066d
            int r9 = r9.v
            int r10 = r12.f2065c
            r14 = 1
            if (r10 != r14) goto L_0x01b0
            androidx.constraintlayout.a.a.a.g r10 = r12.f2069g
            int r10 = r10.m
            int r10 = java.lang.Math.min(r11, r10)
            goto L_0x01b1
        L_0x01b0:
            r10 = r11
        L_0x01b1:
            int r9 = java.lang.Math.max(r9, r10)
            if (r7 <= 0) goto L_0x01bc
            int r7 = java.lang.Math.min(r7, r9)
            goto L_0x01bd
        L_0x01bc:
            r7 = r9
        L_0x01bd:
            if (r7 == r11) goto L_0x01c2
        L_0x01bf:
            int r16 = r16 + 1
            r11 = r7
        L_0x01c2:
            androidx.constraintlayout.a.a.a.g r7 = r12.f2069g
            r7.a(r11)
            goto L_0x01ce
        L_0x01c8:
            r21 = r7
            r19 = r10
            r20 = r14
        L_0x01ce:
            int r13 = r13 + 1
            r11 = r18
            r10 = r19
            r14 = r20
            r7 = r21
            r9 = 1056964608(0x3f000000, float:0.5)
            r12 = 1
            goto L_0x012e
        L_0x01dd:
            r21 = r7
            r20 = r14
            if (r16 <= 0) goto L_0x0216
            int r15 = r15 - r16
            r7 = 0
            r9 = 0
        L_0x01e7:
            if (r7 >= r4) goto L_0x0214
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r10 = r0.f2016a
            java.lang.Object r10 = r10.get(r7)
            androidx.constraintlayout.a.a.a.p r10 = (androidx.constraintlayout.a.a.a.p) r10
            androidx.constraintlayout.a.a.e r11 = r10.f2066d
            int r11 = r11.an
            r12 = 8
            if (r11 == r12) goto L_0x0211
            if (r7 <= 0) goto L_0x0202
            if (r7 < r5) goto L_0x0202
            androidx.constraintlayout.a.a.a.f r11 = r10.j
            int r11 = r11.f2032f
            int r9 = r9 + r11
        L_0x0202:
            androidx.constraintlayout.a.a.a.g r11 = r10.f2069g
            int r11 = r11.f2033g
            int r9 = r9 + r11
            if (r7 >= r8) goto L_0x0211
            if (r7 >= r6) goto L_0x0211
            androidx.constraintlayout.a.a.a.f r10 = r10.k
            int r10 = r10.f2032f
            int r10 = -r10
            int r9 = r9 + r10
        L_0x0211:
            int r7 = r7 + 1
            goto L_0x01e7
        L_0x0214:
            r14 = r9
            goto L_0x0218
        L_0x0216:
            r14 = r20
        L_0x0218:
            int r7 = r0.f2017b
            r9 = 2
            if (r7 != r9) goto L_0x0223
            if (r16 != 0) goto L_0x0223
            r7 = 0
            r0.f2017b = r7
            goto L_0x022b
        L_0x0223:
            r7 = 0
            goto L_0x022b
        L_0x0225:
            r21 = r7
            r20 = r14
            r7 = 0
            r9 = 2
        L_0x022b:
            if (r14 <= r3) goto L_0x022f
            r0.f2017b = r9
        L_0x022f:
            if (r2 <= 0) goto L_0x0237
            if (r15 != 0) goto L_0x0237
            if (r5 != r6) goto L_0x0237
            r0.f2017b = r9
        L_0x0237:
            int r9 = r0.f2017b
            r10 = 1
            if (r9 != r10) goto L_0x02da
            if (r2 <= r10) goto L_0x0243
            int r3 = r3 - r14
            int r2 = r2 - r10
            int r2 = r3 / r2
            goto L_0x024b
        L_0x0243:
            if (r2 != r10) goto L_0x024a
            int r3 = r3 - r14
            r2 = 2
            int r2 = r3 / 2
            goto L_0x024b
        L_0x024a:
            r2 = 0
        L_0x024b:
            if (r15 <= 0) goto L_0x024e
            r2 = 0
        L_0x024e:
            r3 = r21
        L_0x0250:
            if (r7 >= r4) goto L_0x02d9
            if (r1 == 0) goto L_0x0259
            int r9 = r7 + 1
            int r9 = r4 - r9
            goto L_0x025a
        L_0x0259:
            r9 = r7
        L_0x025a:
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r10 = r0.f2016a
            java.lang.Object r9 = r10.get(r9)
            androidx.constraintlayout.a.a.a.p r9 = (androidx.constraintlayout.a.a.a.p) r9
            androidx.constraintlayout.a.a.e r10 = r9.f2066d
            int r10 = r10.an
            r11 = 8
            if (r10 != r11) goto L_0x0275
            androidx.constraintlayout.a.a.a.f r10 = r9.j
            r10.a((int) r3)
            androidx.constraintlayout.a.a.a.f r9 = r9.k
            r9.a((int) r3)
            goto L_0x02d5
        L_0x0275:
            if (r7 <= 0) goto L_0x027c
            if (r1 == 0) goto L_0x027b
            int r3 = r3 - r2
            goto L_0x027c
        L_0x027b:
            int r3 = r3 + r2
        L_0x027c:
            if (r7 <= 0) goto L_0x028d
            if (r7 < r5) goto L_0x028d
            if (r1 == 0) goto L_0x0288
            androidx.constraintlayout.a.a.a.f r10 = r9.j
            int r10 = r10.f2032f
            int r3 = r3 - r10
            goto L_0x028d
        L_0x0288:
            androidx.constraintlayout.a.a.a.f r10 = r9.j
            int r10 = r10.f2032f
            int r3 = r3 + r10
        L_0x028d:
            if (r1 == 0) goto L_0x0295
            androidx.constraintlayout.a.a.a.f r10 = r9.k
            r10.a((int) r3)
            goto L_0x029a
        L_0x0295:
            androidx.constraintlayout.a.a.a.f r10 = r9.j
            r10.a((int) r3)
        L_0x029a:
            androidx.constraintlayout.a.a.a.g r10 = r9.f2069g
            int r10 = r10.f2033g
            androidx.constraintlayout.a.a.e$a r11 = r9.f2068f
            androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x02ad
            int r11 = r9.f2065c
            r12 = 1
            if (r11 != r12) goto L_0x02ad
            androidx.constraintlayout.a.a.a.g r10 = r9.f2069g
            int r10 = r10.m
        L_0x02ad:
            if (r1 == 0) goto L_0x02b1
            int r3 = r3 - r10
            goto L_0x02b2
        L_0x02b1:
            int r3 = r3 + r10
        L_0x02b2:
            if (r1 == 0) goto L_0x02ba
            androidx.constraintlayout.a.a.a.f r10 = r9.j
            r10.a((int) r3)
            goto L_0x02bf
        L_0x02ba:
            androidx.constraintlayout.a.a.a.f r10 = r9.k
            r10.a((int) r3)
        L_0x02bf:
            r10 = 1
            r9.f2071i = r10
            if (r7 >= r8) goto L_0x02d5
            if (r7 >= r6) goto L_0x02d5
            if (r1 == 0) goto L_0x02cf
            androidx.constraintlayout.a.a.a.f r9 = r9.k
            int r9 = r9.f2032f
            int r9 = -r9
            int r3 = r3 - r9
            goto L_0x02d5
        L_0x02cf:
            androidx.constraintlayout.a.a.a.f r9 = r9.k
            int r9 = r9.f2032f
            int r9 = -r9
            int r3 = r3 + r9
        L_0x02d5:
            int r7 = r7 + 1
            goto L_0x0250
        L_0x02d9:
            return
        L_0x02da:
            if (r9 != 0) goto L_0x036f
            int r3 = r3 - r14
            r9 = 1
            int r2 = r2 + r9
            int r2 = r3 / r2
            if (r15 <= 0) goto L_0x02e4
            r2 = 0
        L_0x02e4:
            r3 = r21
        L_0x02e6:
            if (r7 >= r4) goto L_0x036e
            if (r1 == 0) goto L_0x02ef
            int r9 = r7 + 1
            int r9 = r4 - r9
            goto L_0x02f0
        L_0x02ef:
            r9 = r7
        L_0x02f0:
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r10 = r0.f2016a
            java.lang.Object r9 = r10.get(r9)
            androidx.constraintlayout.a.a.a.p r9 = (androidx.constraintlayout.a.a.a.p) r9
            androidx.constraintlayout.a.a.e r10 = r9.f2066d
            int r10 = r10.an
            r11 = 8
            if (r10 != r11) goto L_0x030b
            androidx.constraintlayout.a.a.a.f r10 = r9.j
            r10.a((int) r3)
            androidx.constraintlayout.a.a.a.f r9 = r9.k
            r9.a((int) r3)
            goto L_0x036a
        L_0x030b:
            if (r1 == 0) goto L_0x030f
            int r3 = r3 - r2
            goto L_0x0310
        L_0x030f:
            int r3 = r3 + r2
        L_0x0310:
            if (r7 <= 0) goto L_0x0321
            if (r7 < r5) goto L_0x0321
            if (r1 == 0) goto L_0x031c
            androidx.constraintlayout.a.a.a.f r10 = r9.j
            int r10 = r10.f2032f
            int r3 = r3 - r10
            goto L_0x0321
        L_0x031c:
            androidx.constraintlayout.a.a.a.f r10 = r9.j
            int r10 = r10.f2032f
            int r3 = r3 + r10
        L_0x0321:
            if (r1 == 0) goto L_0x0329
            androidx.constraintlayout.a.a.a.f r10 = r9.k
            r10.a((int) r3)
            goto L_0x032e
        L_0x0329:
            androidx.constraintlayout.a.a.a.f r10 = r9.j
            r10.a((int) r3)
        L_0x032e:
            androidx.constraintlayout.a.a.a.g r10 = r9.f2069g
            int r10 = r10.f2033g
            androidx.constraintlayout.a.a.e$a r11 = r9.f2068f
            androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x0345
            int r11 = r9.f2065c
            r12 = 1
            if (r11 != r12) goto L_0x0345
            androidx.constraintlayout.a.a.a.g r11 = r9.f2069g
            int r11 = r11.m
            int r10 = java.lang.Math.min(r10, r11)
        L_0x0345:
            if (r1 == 0) goto L_0x0349
            int r3 = r3 - r10
            goto L_0x034a
        L_0x0349:
            int r3 = r3 + r10
        L_0x034a:
            if (r1 == 0) goto L_0x0352
            androidx.constraintlayout.a.a.a.f r10 = r9.j
            r10.a((int) r3)
            goto L_0x0357
        L_0x0352:
            androidx.constraintlayout.a.a.a.f r10 = r9.k
            r10.a((int) r3)
        L_0x0357:
            if (r7 >= r8) goto L_0x036a
            if (r7 >= r6) goto L_0x036a
            if (r1 == 0) goto L_0x0364
            androidx.constraintlayout.a.a.a.f r9 = r9.k
            int r9 = r9.f2032f
            int r9 = -r9
            int r3 = r3 - r9
            goto L_0x036a
        L_0x0364:
            androidx.constraintlayout.a.a.a.f r9 = r9.k
            int r9 = r9.f2032f
            int r9 = -r9
            int r3 = r3 + r9
        L_0x036a:
            int r7 = r7 + 1
            goto L_0x02e6
        L_0x036e:
            return
        L_0x036f:
            r2 = 2
            if (r9 != r2) goto L_0x041b
            int r2 = r0.f2070h
            if (r2 != 0) goto L_0x037b
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            float r2 = r2.ak
            goto L_0x037f
        L_0x037b:
            androidx.constraintlayout.a.a.e r2 = r0.f2066d
            float r2 = r2.al
        L_0x037f:
            if (r1 == 0) goto L_0x0385
            r9 = 1065353216(0x3f800000, float:1.0)
            float r2 = r9 - r2
        L_0x0385:
            int r3 = r3 - r14
            float r3 = (float) r3
            float r3 = r3 * r2
            r2 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r2
            int r2 = (int) r3
            if (r2 < 0) goto L_0x0391
            if (r15 <= 0) goto L_0x0392
        L_0x0391:
            r2 = 0
        L_0x0392:
            if (r1 == 0) goto L_0x0397
            int r2 = r21 - r2
            goto L_0x0399
        L_0x0397:
            int r2 = r21 + r2
        L_0x0399:
            if (r7 >= r4) goto L_0x041b
            if (r1 == 0) goto L_0x03a2
            int r3 = r7 + 1
            int r3 = r4 - r3
            goto L_0x03a3
        L_0x03a2:
            r3 = r7
        L_0x03a3:
            java.util.ArrayList<androidx.constraintlayout.a.a.a.p> r9 = r0.f2016a
            java.lang.Object r3 = r9.get(r3)
            androidx.constraintlayout.a.a.a.p r3 = (androidx.constraintlayout.a.a.a.p) r3
            androidx.constraintlayout.a.a.e r9 = r3.f2066d
            int r9 = r9.an
            r10 = 8
            if (r9 != r10) goto L_0x03bf
            androidx.constraintlayout.a.a.a.f r9 = r3.j
            r9.a((int) r2)
            androidx.constraintlayout.a.a.a.f r3 = r3.k
            r3.a((int) r2)
            r12 = 1
            goto L_0x0417
        L_0x03bf:
            if (r7 <= 0) goto L_0x03d0
            if (r7 < r5) goto L_0x03d0
            if (r1 == 0) goto L_0x03cb
            androidx.constraintlayout.a.a.a.f r9 = r3.j
            int r9 = r9.f2032f
            int r2 = r2 - r9
            goto L_0x03d0
        L_0x03cb:
            androidx.constraintlayout.a.a.a.f r9 = r3.j
            int r9 = r9.f2032f
            int r2 = r2 + r9
        L_0x03d0:
            if (r1 == 0) goto L_0x03d8
            androidx.constraintlayout.a.a.a.f r9 = r3.k
            r9.a((int) r2)
            goto L_0x03dd
        L_0x03d8:
            androidx.constraintlayout.a.a.a.f r9 = r3.j
            r9.a((int) r2)
        L_0x03dd:
            androidx.constraintlayout.a.a.a.g r9 = r3.f2069g
            int r9 = r9.f2033g
            androidx.constraintlayout.a.a.e$a r11 = r3.f2068f
            androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x03f1
            int r11 = r3.f2065c
            r12 = 1
            if (r11 != r12) goto L_0x03f2
            androidx.constraintlayout.a.a.a.g r9 = r3.f2069g
            int r9 = r9.m
            goto L_0x03f2
        L_0x03f1:
            r12 = 1
        L_0x03f2:
            if (r1 == 0) goto L_0x03f6
            int r2 = r2 - r9
            goto L_0x03f7
        L_0x03f6:
            int r2 = r2 + r9
        L_0x03f7:
            if (r1 == 0) goto L_0x03ff
            androidx.constraintlayout.a.a.a.f r9 = r3.j
            r9.a((int) r2)
            goto L_0x0404
        L_0x03ff:
            androidx.constraintlayout.a.a.a.f r9 = r3.k
            r9.a((int) r2)
        L_0x0404:
            if (r7 >= r8) goto L_0x0417
            if (r7 >= r6) goto L_0x0417
            if (r1 == 0) goto L_0x0411
            androidx.constraintlayout.a.a.a.f r3 = r3.k
            int r3 = r3.f2032f
            int r3 = -r3
            int r2 = r2 - r3
            goto L_0x0417
        L_0x0411:
            androidx.constraintlayout.a.a.a.f r3 = r3.k
            int r3 = r3.f2032f
            int r3 = -r3
            int r2 = r2 + r3
        L_0x0417:
            int r7 = r7 + 1
            goto L_0x0399
        L_0x041b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.a.a.a.c.d():void");
    }

    public final void e() {
        for (int i2 = 0; i2 < this.f2016a.size(); i2++) {
            this.f2016a.get(i2).e();
        }
    }

    private e h() {
        for (int i2 = 0; i2 < this.f2016a.size(); i2++) {
            p pVar = this.f2016a.get(i2);
            if (pVar.f2066d.an != 8) {
                return pVar.f2066d;
            }
        }
        return null;
    }

    private e i() {
        for (int size = this.f2016a.size() - 1; size >= 0; size--) {
            p pVar = this.f2016a.get(size);
            if (pVar.f2066d.an != 8) {
                return pVar.f2066d;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        Iterator<p> it2 = this.f2016a.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        int size = this.f2016a.size();
        if (size > 0) {
            e eVar = this.f2016a.get(0).f2066d;
            e eVar2 = this.f2016a.get(size - 1).f2066d;
            if (this.f2070h == 0) {
                d dVar = eVar.J;
                d dVar2 = eVar2.L;
                f a2 = a(dVar, 0);
                int e2 = dVar.e();
                e h2 = h();
                if (h2 != null) {
                    e2 = h2.J.e();
                }
                if (a2 != null) {
                    a(this.j, a2, e2);
                }
                f a3 = a(dVar2, 0);
                int e3 = dVar2.e();
                e i2 = i();
                if (i2 != null) {
                    e3 = i2.L.e();
                }
                if (a3 != null) {
                    a(this.k, a3, -e3);
                }
            } else {
                d dVar3 = eVar.K;
                d dVar4 = eVar2.M;
                f a4 = a(dVar3, 1);
                int e4 = dVar3.e();
                e h3 = h();
                if (h3 != null) {
                    e4 = h3.K.e();
                }
                if (a4 != null) {
                    a(this.j, a4, e4);
                }
                f a5 = a(dVar4, 1);
                int e5 = dVar4.e();
                e i3 = i();
                if (i3 != null) {
                    e5 = i3.M.e();
                }
                if (a5 != null) {
                    a(this.k, a5, -e5);
                }
            }
            this.j.f2027a = this;
            this.k.f2027a = this;
        }
    }
}
