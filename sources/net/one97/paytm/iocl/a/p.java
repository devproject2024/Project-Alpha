package net.one97.paytm.iocl.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.h;
import androidx.databinding.i;
import net.one97.paytm.iocl.R;
import net.one97.paytm.iocl.b.a.a;

public final class p extends o implements a.C0194a {
    private static final ViewDataBinding.b s = null;
    private static final SparseIntArray t;
    private long A;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private g w;
    private g x;
    private g y;
    private g z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.rl_user_detail_form, 13);
        t.put(R.id.iv_tip, 14);
        t.put(R.id.tv_tip, 15);
        t.put(R.id.pb_user_detail_form, 16);
    }

    public p(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 17, s, t));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private p(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[11], objArr[8], objArr[3], objArr[10], objArr[5], objArr[14], objArr[0], objArr[16], objArr[13], objArr[12], objArr[7], objArr[1], objArr[2], objArr[6], objArr[9], objArr[15], objArr[4]);
        this.w = new g() {
            public final void onChange() {
                String a2 = d.a((TextView) p.this.f14146b);
                net.one97.paytm.transport.iocl.c.d dVar = p.this.r;
                boolean z = true;
                if (dVar != null) {
                    i<String> iVar = dVar.q;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.x = new g() {
            public final void onChange() {
                String a2 = d.a((TextView) p.this.f14147c);
                net.one97.paytm.transport.iocl.c.d dVar = p.this.r;
                boolean z = true;
                if (dVar != null) {
                    i<String> iVar = dVar.k;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.y = new g() {
            public final void onChange() {
                String a2 = d.a((TextView) p.this.f14148d);
                net.one97.paytm.transport.iocl.c.d dVar = p.this.r;
                boolean z = true;
                if (dVar != null) {
                    i<String> iVar = dVar.o;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.z = new g() {
            public final void onChange() {
                String a2 = d.a((TextView) p.this.f14149e);
                net.one97.paytm.transport.iocl.c.d dVar = p.this.r;
                boolean z = true;
                if (dVar != null) {
                    i<String> iVar = dVar.l;
                    if (iVar == null) {
                        z = false;
                    }
                    if (z) {
                        iVar.set(a2);
                    }
                }
            }
        };
        this.A = -1;
        this.f14145a.setTag((Object) null);
        this.f14146b.setTag((Object) null);
        this.f14147c.setTag((Object) null);
        this.f14148d.setTag((Object) null);
        this.f14149e.setTag((Object) null);
        this.f14151g.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.q.setTag((Object) null);
        setRootTag(view);
        this.u = new a(this, 1);
        this.v = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.A = 8192;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.A != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (net.one97.paytm.iocl.a.f14078b != i2) {
            return false;
        }
        a((net.one97.paytm.transport.iocl.c.d) obj);
        return true;
    }

    public final void a(net.one97.paytm.transport.iocl.c.d dVar) {
        updateRegistration(0, (h) dVar);
        this.r = dVar;
        synchronized (this) {
            this.A |= 1;
        }
        notifyPropertyChanged(net.one97.paytm.iocl.a.f14078b);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return a(i3);
            case 1:
                return b(i3);
            case 2:
                return c(i3);
            case 3:
                return d(i3);
            case 4:
                return e(i3);
            case 5:
                return f(i3);
            case 6:
                return g(i3);
            case 7:
                return h(i3);
            case 8:
                return i(i3);
            case 9:
                return j(i3);
            case 10:
                return k(i3);
            case 11:
                return l(i3);
            case 12:
                return m(i3);
            default:
                return false;
        }
    }

    private boolean a(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 32;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 64;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 128;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 256;
        }
        return true;
    }

    private boolean j(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 512;
        }
        return true;
    }

    private boolean k(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 1024;
        }
        return true;
    }

    private boolean l(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 2048;
        }
        return true;
    }

    private boolean m(int i2) {
        if (i2 != net.one97.paytm.iocl.a.f14077a) {
            return false;
        }
        synchronized (this) {
            this.A |= 4096;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0111  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r46 = this;
            r1 = r46
            monitor-enter(r46)
            long r2 = r1.A     // Catch:{ all -> 0x0322 }
            r4 = 0
            r1.A = r4     // Catch:{ all -> 0x0322 }
            monitor-exit(r46)     // Catch:{ all -> 0x0322 }
            net.one97.paytm.transport.iocl.c.d r0 = r1.r
            r6 = 16383(0x3fff, double:8.0943E-320)
            long r6 = r6 & r2
            r8 = 8321(0x2081, double:4.111E-320)
            r12 = 8225(0x2021, double:4.0637E-320)
            r14 = 8209(0x2011, double:4.056E-320)
            r10 = 1
            r17 = 8201(0x2009, double:4.052E-320)
            r19 = 8961(0x2301, double:4.4273E-320)
            r21 = 8197(0x2005, double:4.05E-320)
            r23 = 4194304(0x400000, double:2.0722615E-317)
            r25 = 8195(0x2003, double:4.049E-320)
            r27 = 8257(0x2041, double:4.0795E-320)
            r29 = 0
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x01e7
            long r6 = r2 & r25
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0041
            if (r0 == 0) goto L_0x0034
            androidx.databinding.i<java.lang.String> r6 = r0.o
            goto L_0x0035
        L_0x0034:
            r6 = 0
        L_0x0035:
            r1.updateRegistration((int) r10, (androidx.databinding.h) r6)
            if (r6 == 0) goto L_0x0041
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0042
        L_0x0041:
            r6 = 0
        L_0x0042:
            long r30 = r2 & r21
            int r7 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005b
            if (r0 == 0) goto L_0x004d
            androidx.databinding.i<java.lang.String> r7 = r0.l
            goto L_0x004e
        L_0x004d:
            r7 = 0
        L_0x004e:
            r10 = 2
            r1.updateRegistration((int) r10, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x005b
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x005c
        L_0x005b:
            r7 = 0
        L_0x005c:
            long r31 = r2 & r17
            int r10 = (r31 > r4 ? 1 : (r31 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0076
            if (r0 == 0) goto L_0x0067
            androidx.databinding.i<java.lang.String> r10 = r0.r
            goto L_0x0068
        L_0x0067:
            r10 = 0
        L_0x0068:
            r11 = 3
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0076
            java.lang.Object r10 = r10.get()
            r11 = r10
            java.lang.String r11 = (java.lang.String) r11
            goto L_0x0077
        L_0x0076:
            r11 = 0
        L_0x0077:
            long r32 = r2 & r14
            int r10 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0090
            if (r0 == 0) goto L_0x0082
            androidx.databinding.i<java.lang.String> r10 = r0.q
            goto L_0x0083
        L_0x0082:
            r10 = 0
        L_0x0083:
            r14 = 4
            r1.updateRegistration((int) r14, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0090
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0091
        L_0x0090:
            r10 = 0
        L_0x0091:
            long r14 = r2 & r12
            int r34 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x00aa
            if (r0 == 0) goto L_0x009c
            androidx.databinding.i<java.lang.String> r14 = r0.m
            goto L_0x009d
        L_0x009c:
            r14 = 0
        L_0x009d:
            r15 = 5
            r1.updateRegistration((int) r15, (androidx.databinding.h) r14)
            if (r14 == 0) goto L_0x00aa
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x00ab
        L_0x00aa:
            r14 = 0
        L_0x00ab:
            long r34 = r2 & r27
            int r15 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00d7
            if (r0 == 0) goto L_0x00b6
            androidx.databinding.i<java.lang.String> r12 = r0.f14310i
            goto L_0x00b7
        L_0x00b6:
            r12 = 0
        L_0x00b7:
            r13 = 6
            r1.updateRegistration((int) r13, (androidx.databinding.h) r12)
            if (r12 == 0) goto L_0x00c4
            java.lang.Object r12 = r12.get()
            java.lang.String r12 = (java.lang.String) r12
            goto L_0x00c5
        L_0x00c4:
            r12 = 0
        L_0x00c5:
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r15 == 0) goto L_0x00d9
            if (r13 == 0) goto L_0x00d1
            r36 = 131072(0x20000, double:6.47582E-319)
            goto L_0x00d4
        L_0x00d1:
            r36 = 65536(0x10000, double:3.2379E-319)
        L_0x00d4:
            long r2 = r2 | r36
            goto L_0x00d9
        L_0x00d7:
            r12 = 0
            r13 = 0
        L_0x00d9:
            long r36 = r2 & r8
            int r15 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0109
            if (r0 == 0) goto L_0x00e4
            androidx.databinding.i<java.lang.String> r8 = r0.n
            goto L_0x00e5
        L_0x00e4:
            r8 = 0
        L_0x00e5:
            r9 = 7
            r1.updateRegistration((int) r9, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x00f2
            java.lang.Object r8 = r8.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00f3
        L_0x00f2:
            r8 = 0
        L_0x00f3:
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r15 == 0) goto L_0x0104
            if (r9 == 0) goto L_0x00ff
            r38 = 2097152(0x200000, double:1.0361308E-317)
            goto L_0x0102
        L_0x00ff:
            r38 = 1048576(0x100000, double:5.180654E-318)
        L_0x0102:
            long r2 = r2 | r38
        L_0x0104:
            if (r9 == 0) goto L_0x010a
            r9 = 8
            goto L_0x010b
        L_0x0109:
            r8 = 0
        L_0x010a:
            r9 = 0
        L_0x010b:
            long r38 = r2 & r19
            int r15 = (r38 > r4 ? 1 : (r38 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0137
            if (r0 == 0) goto L_0x0116
            androidx.databinding.i<java.lang.Boolean> r4 = r0.f14308g
            goto L_0x0117
        L_0x0116:
            r4 = 0
        L_0x0117:
            r5 = 9
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x0125
            java.lang.Object r4 = r4.get()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x0126
        L_0x0125:
            r4 = 0
        L_0x0126:
            boolean r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r4)
            if (r15 == 0) goto L_0x0138
            if (r4 == 0) goto L_0x0134
            r40 = 8388608(0x800000, double:4.144523E-317)
            long r2 = r2 | r40
            goto L_0x0138
        L_0x0134:
            long r2 = r2 | r23
            goto L_0x0138
        L_0x0137:
            r4 = 0
        L_0x0138:
            r40 = 9217(0x2401, double:4.554E-320)
            long r40 = r2 & r40
            r38 = 0
            int r5 = (r40 > r38 ? 1 : (r40 == r38 ? 0 : -1))
            if (r5 == 0) goto L_0x0156
            if (r0 == 0) goto L_0x0147
            androidx.databinding.i<java.lang.String> r5 = r0.p
            goto L_0x0148
        L_0x0147:
            r5 = 0
        L_0x0148:
            r15 = 10
            r1.updateRegistration((int) r15, (androidx.databinding.h) r5)
            if (r5 == 0) goto L_0x0156
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0157
        L_0x0156:
            r5 = 0
        L_0x0157:
            r15 = 10241(0x2801, double:5.0597E-320)
            long r40 = r2 & r15
            r38 = 0
            int r15 = (r40 > r38 ? 1 : (r40 == r38 ? 0 : -1))
            r40 = r4
            if (r15 == 0) goto L_0x0191
            if (r0 == 0) goto L_0x016a
            androidx.databinding.i<java.lang.String> r4 = r0.k
            r41 = r5
            goto L_0x016d
        L_0x016a:
            r41 = r5
            r4 = 0
        L_0x016d:
            r5 = 11
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x017b
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x017c
        L_0x017b:
            r4 = 0
        L_0x017c:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r15 == 0) goto L_0x018c
            if (r5 == 0) goto L_0x0188
            r42 = 32768(0x8000, double:1.61895E-319)
            goto L_0x018a
        L_0x0188:
            r42 = 16384(0x4000, double:8.0948E-320)
        L_0x018a:
            long r2 = r2 | r42
        L_0x018c:
            if (r5 == 0) goto L_0x0194
            r5 = 8
            goto L_0x0195
        L_0x0191:
            r41 = r5
            r4 = 0
        L_0x0194:
            r5 = 0
        L_0x0195:
            r42 = 12289(0x3001, double:6.0716E-320)
            long r42 = r2 & r42
            r38 = 0
            int r15 = (r42 > r38 ? 1 : (r42 == r38 ? 0 : -1))
            r42 = r4
            if (r15 == 0) goto L_0x01dd
            if (r0 == 0) goto L_0x01a8
            androidx.databinding.i<java.lang.String> r4 = r0.j
            r43 = r5
            goto L_0x01ab
        L_0x01a8:
            r43 = r5
            r4 = 0
        L_0x01ab:
            r5 = 12
            r1.updateRegistration((int) r5, (androidx.databinding.h) r4)
            if (r4 == 0) goto L_0x01b9
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01ba
        L_0x01b9:
            r4 = 0
        L_0x01ba:
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r15 == 0) goto L_0x01cb
            if (r4 == 0) goto L_0x01c6
            r44 = 524288(0x80000, double:2.590327E-318)
            goto L_0x01c9
        L_0x01c6:
            r44 = 262144(0x40000, double:1.295163E-318)
        L_0x01c9:
            long r2 = r2 | r44
        L_0x01cb:
            if (r4 == 0) goto L_0x01d0
            r4 = 8
            goto L_0x01d1
        L_0x01d0:
            r4 = 0
        L_0x01d1:
            r15 = r41
            r5 = r43
            r41 = r12
            r12 = r14
            r14 = r8
            r8 = r4
            r4 = r42
            goto L_0x01f7
        L_0x01dd:
            r43 = r5
            r15 = r41
            r41 = r12
            r12 = r14
            r14 = r8
            r8 = 0
            goto L_0x01f7
        L_0x01e7:
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r40 = 0
            r41 = 0
        L_0x01f7:
            long r27 = r2 & r27
            r38 = 0
            int r42 = (r27 > r38 ? 1 : (r27 == r38 ? 0 : -1))
            if (r42 == 0) goto L_0x0208
            if (r13 == 0) goto L_0x0205
            java.lang.String r13 = "Just one step away!"
            r41 = r13
        L_0x0205:
            r13 = r41
            goto L_0x0209
        L_0x0208:
            r13 = 0
        L_0x0209:
            long r23 = r2 & r23
            int r27 = (r23 > r38 ? 1 : (r23 == r38 ? 0 : -1))
            if (r27 == 0) goto L_0x022d
            if (r0 == 0) goto L_0x0216
            androidx.databinding.i<java.lang.Boolean> r0 = r0.f14309h
            r23 = r12
            goto L_0x0219
        L_0x0216:
            r23 = r12
            r0 = 0
        L_0x0219:
            r12 = 8
            r1.updateRegistration((int) r12, (androidx.databinding.h) r0)
            if (r0 == 0) goto L_0x0227
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto L_0x0228
        L_0x0227:
            r0 = 0
        L_0x0228:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            goto L_0x0230
        L_0x022d:
            r23 = r12
            r0 = 0
        L_0x0230:
            long r19 = r2 & r19
            r27 = 0
            int r12 = (r19 > r27 ? 1 : (r19 == r27 ? 0 : -1))
            if (r12 == 0) goto L_0x0242
            if (r40 == 0) goto L_0x023d
            r29 = 1
            goto L_0x023f
        L_0x023d:
            r29 = r0
        L_0x023f:
            r0 = r29
            goto L_0x0243
        L_0x0242:
            r0 = 0
        L_0x0243:
            r19 = 8192(0x2000, double:4.0474E-320)
            long r19 = r2 & r19
            int r24 = (r19 > r27 ? 1 : (r19 == r27 ? 0 : -1))
            if (r24 == 0) goto L_0x027d
            r19 = r15
            android.widget.Button r15 = r1.f14145a
            r20 = r14
            android.view.View$OnClickListener r14 = r1.v
            r15.setOnClickListener(r14)
            androidx.appcompat.widget.AppCompatEditText r14 = r1.f14146b
            android.view.View$OnClickListener r15 = r1.u
            r14.setOnClickListener(r15)
            androidx.appcompat.widget.AppCompatEditText r14 = r1.f14146b
            androidx.databinding.g r15 = r1.w
            r24 = r9
            r9 = 0
            androidx.databinding.a.d.a(r14, r9, r9, r15)
            androidx.appcompat.widget.AppCompatEditText r14 = r1.f14147c
            androidx.databinding.g r15 = r1.x
            androidx.databinding.a.d.a(r14, r9, r9, r15)
            androidx.appcompat.widget.AppCompatEditText r14 = r1.f14148d
            androidx.databinding.g r15 = r1.y
            androidx.databinding.a.d.a(r14, r9, r9, r15)
            androidx.appcompat.widget.AppCompatEditText r14 = r1.f14149e
            androidx.databinding.g r15 = r1.z
            androidx.databinding.a.d.a(r14, r9, r9, r15)
            goto L_0x0283
        L_0x027d:
            r24 = r9
            r20 = r14
            r19 = r15
        L_0x0283:
            r14 = 8209(0x2011, double:4.056E-320)
            long r14 = r14 & r2
            r27 = 0
            int r9 = (r14 > r27 ? 1 : (r14 == r27 ? 0 : -1))
            if (r9 == 0) goto L_0x0291
            androidx.appcompat.widget.AppCompatEditText r9 = r1.f14146b
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r10)
        L_0x0291:
            r9 = 10241(0x2801, double:5.0597E-320)
            long r9 = r9 & r2
            int r14 = (r9 > r27 ? 1 : (r9 == r27 ? 0 : -1))
            if (r14 == 0) goto L_0x02a2
            androidx.appcompat.widget.AppCompatEditText r9 = r1.f14147c
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r4)
            com.google.android.material.textfield.TextInputLayout r4 = r1.m
            r4.setVisibility(r5)
        L_0x02a2:
            long r4 = r2 & r25
            int r9 = (r4 > r27 ? 1 : (r4 == r27 ? 0 : -1))
            if (r9 == 0) goto L_0x02ad
            androidx.appcompat.widget.AppCompatEditText r4 = r1.f14148d
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r6)
        L_0x02ad:
            if (r12 == 0) goto L_0x02c3
            androidx.appcompat.widget.AppCompatEditText r4 = r1.f14149e
            r4.setFocusable(r0)
            androidx.appcompat.widget.AppCompatEditText r4 = r1.f14149e
            r4.setClickable(r0)
            androidx.appcompat.widget.AppCompatEditText r4 = r1.f14149e
            r4.setCursorVisible(r0)
            androidx.appcompat.widget.AppCompatEditText r4 = r1.f14149e
            r4.setEnabled(r0)
        L_0x02c3:
            long r4 = r2 & r21
            r9 = 0
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x02d0
            androidx.appcompat.widget.AppCompatEditText r0 = r1.f14149e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
        L_0x02d0:
            r4 = 12289(0x3001, double:6.0716E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x02dc
            android.widget.TextView r0 = r1.j
            r0.setVisibility(r8)
        L_0x02dc:
            long r4 = r2 & r17
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x02e7
            com.google.android.material.textfield.TextInputLayout r0 = r1.k
            net.one97.paytm.transport.iocl_v1.c.d.a(r0, r11)
        L_0x02e7:
            if (r42 == 0) goto L_0x02ee
            android.widget.TextView r0 = r1.l
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x02ee:
            r4 = 8321(0x2081, double:4.111E-320)
            long r4 = r4 & r2
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0305
            android.widget.TextView r0 = r1.n
            r9 = r24
            r0.setVisibility(r9)
            android.widget.TextView r0 = r1.n
            r8 = r20
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0305:
            r4 = 9217(0x2401, double:4.554E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0313
            com.google.android.material.textfield.TextInputLayout r0 = r1.o
            r4 = r19
            net.one97.paytm.transport.iocl_v1.c.d.a(r0, r4)
        L_0x0313:
            r4 = 8225(0x2021, double:4.0637E-320)
            long r2 = r2 & r4
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0321
            com.google.android.material.textfield.TextInputLayout r0 = r1.q
            r14 = r23
            net.one97.paytm.transport.iocl_v1.c.d.a(r0, r14)
        L_0x0321:
            return
        L_0x0322:
            r0 = move-exception
            monitor-exit(r46)     // Catch:{ all -> 0x0322 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.iocl.a.p.executeBindings():void");
    }

    public final void a(int i2, View view) {
        boolean z2 = false;
        if (i2 == 1) {
            net.one97.paytm.transport.iocl.c.d dVar = this.r;
            if (dVar != null) {
                z2 = true;
            }
            if (z2) {
                dVar.t.onClickOnDatePicker();
            }
        } else if (i2 == 2) {
            net.one97.paytm.transport.iocl.c.d dVar2 = this.r;
            if (dVar2 != null) {
                z2 = true;
            }
            if (z2) {
                dVar2.d();
            }
        }
    }
}
