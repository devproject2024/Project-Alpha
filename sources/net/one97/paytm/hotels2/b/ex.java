package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.hotel4.viewmodel.EditSearchViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;
import net.one97.paytm.hotels2.c.a.d;

public final class ex extends ew implements b.a, d.a {
    private static final ViewDataBinding.b E;
    private static final SparseIntArray F;
    private final LinearLayout G;
    private final ConstraintLayout H;
    private final TextView I;
    private final Runnable J;
    private final View.OnClickListener K;
    private final View.OnClickListener L;
    private final View.OnClickListener M;
    private final Runnable N;
    private final View.OnClickListener O;
    private final Runnable P;
    private long Q;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(32);
        E = bVar;
        bVar.a(1, new String[]{"h4_edit_search_query_view", "h4_edit_search_query_view", "h4_edit_search_query_view"}, new int[]{21, 22, 23}, new int[]{R.layout.h4_edit_search_query_view, R.layout.h4_edit_search_query_view, R.layout.h4_edit_search_query_view});
        SparseIntArray sparseIntArray = new SparseIntArray();
        F = sparseIntArray;
        sparseIntArray.put(R.id.divider1, 24);
        F.put(R.id.date_details, 25);
        F.put(R.id.lottieAnim, 26);
        F.put(R.id.check_in, 27);
        F.put(R.id.constraint_2, 28);
        F.put(R.id.checkout_title, 29);
        F.put(R.id.divider5, 30);
        F.put(R.id.divider6, 31);
    }

    public ex(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 32, E, F));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ex(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[22], objArr[19], objArr[20], objArr[27], objArr[10], objArr[12], objArr[11], objArr[16], objArr[18], objArr[17], objArr[29], objArr[23], objArr[7], objArr[9], objArr[28], objArr[15], objArr[25], objArr[24], objArr[8], objArr[30], objArr[31], objArr[4], objArr[5], objArr[3], objArr[26], objArr[13], objArr[21], objArr[2], objArr[6]);
        this.Q = -1;
        this.f29662b.setTag((Object) null);
        this.f29663c.setTag((Object) null);
        this.f29665e.setTag((Object) null);
        this.f29666f.setTag((Object) null);
        this.f29667g.setTag((Object) null);
        this.f29668h.setTag((Object) null);
        this.f29669i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.p.setTag((Object) null);
        this.s.setTag((Object) null);
        this.v.setTag((Object) null);
        this.w.setTag((Object) null);
        this.x.setTag((Object) null);
        this.G = objArr[0];
        this.G.setTag((Object) null);
        this.H = objArr[1];
        this.H.setTag((Object) null);
        this.I = objArr[14];
        this.I.setTag((Object) null);
        this.z.setTag((Object) null);
        this.B.setTag((Object) null);
        this.C.setTag((Object) null);
        setRootTag(view);
        this.J = new d(this, 5);
        this.K = new b(this, 1);
        this.L = new b(this, 6);
        this.M = new b(this, 7);
        this.N = new d(this, 3);
        this.O = new b(this, 2);
        this.P = new d(this, 4);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.Q = 65536;
        }
        this.A.invalidateAll();
        this.f29661a.invalidateAll();
        this.l.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.f29661a.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.l.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.A.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.Q     // Catch:{ all -> 0x002a }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x002a }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x002a }
            net.one97.paytm.hotels2.b.ac r0 = r6.A
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            net.one97.paytm.hotels2.b.ac r0 = r6.f29661a
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            net.one97.paytm.hotels2.b.ac r0 = r6.l
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r4
        L_0x0028:
            r0 = 0
            return r0
        L_0x002a:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x002a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.ex.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((EditSearchViewModel) obj);
        return true;
    }

    public final void a(EditSearchViewModel editSearchViewModel) {
        this.D = editSearchViewModel;
        synchronized (this) {
            this.Q |= 32768;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.A.setLifecycleOwner(qVar);
        this.f29661a.setLifecycleOwner(qVar);
        this.l.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return c(i3);
            case 1:
                return d(i3);
            case 2:
                return e(i3);
            case 3:
                return f(i3);
            case 4:
                return g(i3);
            case 5:
                return h(i3);
            case 6:
                return i(i3);
            case 7:
                return j(i3);
            case 8:
                return k(i3);
            case 9:
                return l(i3);
            case 10:
                return m(i3);
            case 11:
                return n(i3);
            case 12:
                return o(i3);
            case 13:
                return p(i3);
            case 14:
                return q(i3);
            default:
                return false;
        }
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 1;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 2;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 4;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 8;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 16;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 32;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 64;
        }
        return true;
    }

    private boolean j(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 128;
        }
        return true;
    }

    private boolean k(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 256;
        }
        return true;
    }

    private boolean l(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 512;
        }
        return true;
    }

    private boolean m(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 1024;
        }
        return true;
    }

    private boolean n(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 2048;
        }
        return true;
    }

    private boolean o(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 4096;
        }
        return true;
    }

    private boolean p(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 8192;
        }
        return true;
    }

    private boolean q(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 16384;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r51 = this;
            r1 = r51
            monitor-enter(r51)
            long r2 = r1.Q     // Catch:{ all -> 0x03f3 }
            r4 = 0
            r1.Q = r4     // Catch:{ all -> 0x03f3 }
            monitor-exit(r51)     // Catch:{ all -> 0x03f3 }
            net.one97.paytm.hotel4.viewmodel.EditSearchViewModel r0 = r1.D
            r6 = 114677(0x1bff5, double:5.6658E-319)
            long r6 = r6 & r2
            r8 = 98432(0x18080, double:4.8632E-319)
            r12 = 98336(0x18020, double:4.85844E-319)
            r16 = 98320(0x18010, double:4.85765E-319)
            r18 = 98560(0x18100, double:4.8695E-319)
            r20 = 98308(0x18004, double:4.85706E-319)
            r22 = 98368(0x18040, double:4.86002E-319)
            r24 = 98305(0x18001, double:4.8569E-319)
            r26 = 98304(0x18000, double:4.85686E-319)
            r14 = 0
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0299
            long r6 = r2 & r24
            int r30 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x0047
            if (r0 == 0) goto L_0x003a
            com.travel.utils.l r6 = r0.getHotelName()
            goto L_0x003b
        L_0x003a:
            r6 = 0
        L_0x003b:
            r1.updateLiveDataRegistration(r14, r6)
            if (r6 == 0) goto L_0x0047
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0048
        L_0x0047:
            r6 = 0
        L_0x0048:
            long r30 = r2 & r26
            int r7 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x005d
            if (r0 == 0) goto L_0x005d
            net.one97.paytm.hotel4.service.model.GuestAndRoomCountDetails r7 = r0.getAdultCount()
            net.one97.paytm.hotel4.service.model.GuestAndRoomCountDetails r30 = r0.getChildCount()
            net.one97.paytm.hotel4.service.model.GuestAndRoomCountDetails r31 = r0.getRoomCount()
            goto L_0x0062
        L_0x005d:
            r7 = 0
            r30 = 0
            r31 = 0
        L_0x0062:
            long r32 = r2 & r20
            int r34 = (r32 > r4 ? 1 : (r32 == r4 ? 0 : -1))
            if (r34 == 0) goto L_0x008b
            if (r0 == 0) goto L_0x0071
            com.travel.utils.l r32 = r0.getNightCount()
            r14 = r32
            goto L_0x0072
        L_0x0071:
            r14 = 0
        L_0x0072:
            r15 = 2
            r1.updateLiveDataRegistration(r15, r14)
            if (r14 == 0) goto L_0x0080
            java.lang.Object r14 = r14.getValue()
            r15 = r14
            java.lang.Integer r15 = (java.lang.Integer) r15
            goto L_0x0081
        L_0x0080:
            r15 = 0
        L_0x0081:
            int r14 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r15)
            java.lang.String r14 = java.lang.String.valueOf(r14)
            r15 = r14
            goto L_0x008c
        L_0x008b:
            r15 = 0
        L_0x008c:
            long r34 = r2 & r16
            r14 = 4
            int r36 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r36 == 0) goto L_0x00a9
            if (r0 == 0) goto L_0x009c
            com.travel.utils.l r34 = r0.getCheckoutDay()
            r10 = r34
            goto L_0x009d
        L_0x009c:
            r10 = 0
        L_0x009d:
            r1.updateLiveDataRegistration(r14, r10)
            if (r10 == 0) goto L_0x00a9
            java.lang.Object r10 = r10.getValue()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x00aa
        L_0x00a9:
            r10 = 0
        L_0x00aa:
            long r36 = r2 & r12
            int r38 = (r36 > r4 ? 1 : (r36 == r4 ? 0 : -1))
            if (r38 == 0) goto L_0x010d
            if (r0 == 0) goto L_0x00b9
            androidx.lifecycle.y r36 = r0.isOpenFromRoomSelection()
            r14 = r36
            goto L_0x00ba
        L_0x00b9:
            r14 = 0
        L_0x00ba:
            r12 = 5
            r1.updateLiveDataRegistration(r12, r14)
            if (r14 == 0) goto L_0x00c7
            java.lang.Object r12 = r14.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            goto L_0x00c8
        L_0x00c7:
            r12 = 0
        L_0x00c8:
            boolean r12 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r12)
            if (r38 == 0) goto L_0x00f0
            if (r12 == 0) goto L_0x00e0
            r13 = 262144(0x40000, double:1.295163E-318)
            long r2 = r2 | r13
            r13 = 16777216(0x1000000, double:8.289046E-317)
            long r2 = r2 | r13
            r13 = 67108864(0x4000000, double:3.31561842E-316)
            long r2 = r2 | r13
            r13 = 268435456(0x10000000, double:1.32624737E-315)
            goto L_0x00ef
        L_0x00e0:
            r13 = 131072(0x20000, double:6.47582E-319)
            long r2 = r2 | r13
            r13 = 8388608(0x800000, double:4.144523E-317)
            long r2 = r2 | r13
            r13 = 33554432(0x2000000, double:1.6578092E-316)
            long r2 = r2 | r13
            r13 = 134217728(0x8000000, double:6.63123685E-316)
        L_0x00ef:
            long r2 = r2 | r13
        L_0x00f0:
            if (r12 == 0) goto L_0x00f5
            r13 = 8
            goto L_0x00f6
        L_0x00f5:
            r13 = 0
        L_0x00f6:
            if (r12 == 0) goto L_0x00fa
            r14 = 0
            goto L_0x00fb
        L_0x00fa:
            r14 = 4
        L_0x00fb:
            if (r12 == 0) goto L_0x0100
            r37 = 0
            goto L_0x0102
        L_0x0100:
            r37 = 8
        L_0x0102:
            if (r12 == 0) goto L_0x0107
            r36 = 4
            goto L_0x0109
        L_0x0107:
            r36 = 0
        L_0x0109:
            r12 = r14
            r14 = r36
            goto L_0x0112
        L_0x010d:
            r12 = 0
            r13 = 0
            r14 = 0
            r37 = 0
        L_0x0112:
            long r39 = r2 & r8
            int r36 = (r39 > r4 ? 1 : (r39 == r4 ? 0 : -1))
            if (r36 == 0) goto L_0x012f
            if (r0 == 0) goto L_0x0121
            com.travel.utils.l r36 = r0.getNightCountText()
            r8 = r36
            goto L_0x0122
        L_0x0121:
            r8 = 0
        L_0x0122:
            r9 = 7
            r1.updateLiveDataRegistration(r9, r8)
            if (r8 == 0) goto L_0x012f
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x0130
        L_0x012f:
            r8 = 0
        L_0x0130:
            long r41 = r2 & r22
            int r9 = (r41 > r4 ? 1 : (r41 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0184
            if (r0 == 0) goto L_0x013d
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r36 = r0.getParent()
            goto L_0x013f
        L_0x013d:
            r36 = 0
        L_0x013f:
            if (r36 == 0) goto L_0x0148
            androidx.lifecycle.y r36 = r36.isFromRoomSelection()
            r11 = r36
            goto L_0x0149
        L_0x0148:
            r11 = 0
        L_0x0149:
            r4 = 6
            r1.updateLiveDataRegistration(r4, r11)
            if (r11 == 0) goto L_0x0156
            java.lang.Object r4 = r11.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            goto L_0x0157
        L_0x0156:
            r4 = 0
        L_0x0157:
            boolean r4 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r4)
            if (r9 == 0) goto L_0x0172
            if (r4 == 0) goto L_0x0168
            r43 = 1048576(0x100000, double:5.180654E-318)
            long r2 = r2 | r43
            r43 = 4194304(0x400000, double:2.0722615E-317)
            goto L_0x0170
        L_0x0168:
            r43 = 524288(0x80000, double:2.590327E-318)
            long r2 = r2 | r43
            r43 = 2097152(0x200000, double:1.0361308E-317)
        L_0x0170:
            long r2 = r2 | r43
        L_0x0172:
            if (r4 == 0) goto L_0x0176
            r5 = 0
            goto L_0x0178
        L_0x0176:
            r5 = 8
        L_0x0178:
            if (r4 == 0) goto L_0x017d
            r32 = 8
            goto L_0x017f
        L_0x017d:
            r32 = 0
        L_0x017f:
            r4 = r32
            r32 = r5
            goto L_0x0187
        L_0x0184:
            r4 = 0
            r32 = 0
        L_0x0187:
            long r43 = r2 & r18
            r41 = 0
            int r5 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r5 == 0) goto L_0x01a5
            if (r0 == 0) goto L_0x0196
            com.travel.utils.l r5 = r0.getCheckInDate()
            goto L_0x0197
        L_0x0196:
            r5 = 0
        L_0x0197:
            r9 = 8
            r1.updateLiveDataRegistration(r9, r5)
            if (r5 == 0) goto L_0x01a5
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x01a6
        L_0x01a5:
            r5 = 0
        L_0x01a6:
            r43 = 98816(0x18200, double:4.88216E-319)
            long r43 = r2 & r43
            r41 = 0
            int r9 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r9 == 0) goto L_0x01c7
            if (r0 == 0) goto L_0x01b8
            com.travel.utils.l r9 = r0.getCityName()
            goto L_0x01b9
        L_0x01b8:
            r9 = 0
        L_0x01b9:
            r11 = 9
            r1.updateLiveDataRegistration(r11, r9)
            if (r9 == 0) goto L_0x01c7
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x01c8
        L_0x01c7:
            r9 = 0
        L_0x01c8:
            r34 = 99328(0x18400, double:4.90746E-319)
            long r43 = r2 & r34
            r41 = 0
            int r11 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r11 == 0) goto L_0x01ed
            if (r0 == 0) goto L_0x01dc
            com.travel.utils.l r11 = r0.getCheckInMonth()
            r36 = r4
            goto L_0x01df
        L_0x01dc:
            r36 = r4
            r11 = 0
        L_0x01df:
            r4 = 10
            r1.updateLiveDataRegistration(r4, r11)
            if (r11 == 0) goto L_0x01ef
            java.lang.Object r4 = r11.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x01f0
        L_0x01ed:
            r36 = r4
        L_0x01ef:
            r4 = 0
        L_0x01f0:
            r43 = 100352(0x18800, double:4.95805E-319)
            long r43 = r2 & r43
            r41 = 0
            int r11 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r11 == 0) goto L_0x0215
            if (r0 == 0) goto L_0x0204
            com.travel.utils.l r11 = r0.getCheckoutMonth()
            r38 = r4
            goto L_0x0207
        L_0x0204:
            r38 = r4
            r11 = 0
        L_0x0207:
            r4 = 11
            r1.updateLiveDataRegistration(r4, r11)
            if (r11 == 0) goto L_0x0217
            java.lang.Object r4 = r11.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0218
        L_0x0215:
            r38 = r4
        L_0x0217:
            r4 = 0
        L_0x0218:
            r28 = 102400(0x19000, double:5.05923E-319)
            long r43 = r2 & r28
            r41 = 0
            int r11 = (r43 > r41 ? 1 : (r43 == r41 ? 0 : -1))
            if (r11 == 0) goto L_0x023d
            if (r0 == 0) goto L_0x022c
            com.travel.utils.l r11 = r0.getCheckInDay()
            r43 = r4
            goto L_0x022f
        L_0x022c:
            r43 = r4
            r11 = 0
        L_0x022f:
            r4 = 12
            r1.updateLiveDataRegistration(r4, r11)
            if (r11 == 0) goto L_0x023f
            java.lang.Object r4 = r11.getValue()
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0240
        L_0x023d:
            r43 = r4
        L_0x023f:
            r4 = 0
        L_0x0240:
            r44 = 106496(0x1a000, double:5.2616E-319)
            long r44 = r2 & r44
            r41 = 0
            int r11 = (r44 > r41 ? 1 : (r44 == r41 ? 0 : -1))
            if (r11 == 0) goto L_0x0279
            if (r0 == 0) goto L_0x0254
            com.travel.utils.l r11 = r0.getCheckoutDate()
            r44 = r2
            goto L_0x0257
        L_0x0254:
            r44 = r2
            r11 = 0
        L_0x0257:
            r2 = 13
            r1.updateLiveDataRegistration(r2, r11)
            if (r11 == 0) goto L_0x027b
            java.lang.Object r2 = r11.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r48 = r6
            r49 = r8
            r11 = r10
            r47 = r14
            r50 = r15
            r3 = r31
            r46 = r37
            r10 = r2
            r8 = r4
            r6 = r5
            r15 = r12
            r14 = r13
            r2 = r30
            goto L_0x028f
        L_0x0279:
            r44 = r2
        L_0x027b:
            r48 = r6
            r49 = r8
            r11 = r10
            r47 = r14
            r50 = r15
            r2 = r30
            r3 = r31
            r46 = r37
            r10 = 0
            r8 = r4
            r6 = r5
            r15 = r12
            r14 = r13
        L_0x028f:
            r5 = r32
            r4 = r36
            r12 = r43
            r13 = r9
            r9 = r38
            goto L_0x02b3
        L_0x0299:
            r44 = r2
            r2 = 0
            r3 = 0
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
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
        L_0x02b3:
            long r26 = r44 & r26
            r30 = 0
            int r32 = (r26 > r30 ? 1 : (r26 == r30 ? 0 : -1))
            r26 = r15
            if (r32 == 0) goto L_0x02db
            net.one97.paytm.hotels2.b.ac r15 = r1.f29661a
            r15.a((net.one97.paytm.hotel4.service.model.GuestAndRoomCountDetails) r7)
            net.one97.paytm.hotels2.b.ac r7 = r1.f29661a
            r7.a((net.one97.paytm.hotel4.viewmodel.EditSearchViewModel) r0)
            net.one97.paytm.hotels2.b.ac r7 = r1.l
            r7.a((net.one97.paytm.hotel4.service.model.GuestAndRoomCountDetails) r2)
            net.one97.paytm.hotels2.b.ac r2 = r1.l
            r2.a((net.one97.paytm.hotel4.viewmodel.EditSearchViewModel) r0)
            net.one97.paytm.hotels2.b.ac r2 = r1.A
            r2.a((net.one97.paytm.hotel4.service.model.GuestAndRoomCountDetails) r3)
            net.one97.paytm.hotels2.b.ac r2 = r1.A
            r2.a((net.one97.paytm.hotel4.viewmodel.EditSearchViewModel) r0)
        L_0x02db:
            r2 = 65536(0x10000, double:3.2379E-319)
            long r2 = r44 & r2
            r30 = 0
            int r0 = (r2 > r30 ? 1 : (r2 == r30 ? 0 : -1))
            if (r0 == 0) goto L_0x0317
            android.widget.TextView r0 = r1.f29662b
            android.view.View$OnClickListener r2 = r1.L
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r1.f29663c
            android.view.View$OnClickListener r2 = r1.M
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r1.m
            java.lang.Runnable r2 = r1.N
            net.one97.paytm.hotel4.utils.g.a(r0, r2)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.n
            java.lang.Runnable r2 = r1.P
            net.one97.paytm.hotel4.utils.g.a(r0, r2)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.p
            java.lang.Runnable r2 = r1.J
            net.one97.paytm.hotel4.utils.g.a(r0, r2)
            android.widget.ImageView r0 = r1.x
            android.view.View$OnClickListener r2 = r1.K
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r1.C
            android.view.View$OnClickListener r2 = r1.O
            r0.setOnClickListener(r2)
        L_0x0317:
            long r2 = r44 & r22
            r22 = 0
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x0329
            android.widget.TextView r0 = r1.f29662b
            r0.setVisibility(r4)
            android.widget.TextView r0 = r1.f29663c
            r0.setVisibility(r5)
        L_0x0329:
            long r2 = r44 & r18
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x0334
            android.widget.TextView r0 = r1.f29665e
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x0334:
            r2 = 102400(0x19000, double:5.05923E-319)
            long r2 = r44 & r2
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x0342
            android.widget.TextView r0 = r1.f29666f
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x0342:
            r2 = 99328(0x18400, double:4.90746E-319)
            long r2 = r44 & r2
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x0350
            android.widget.TextView r0 = r1.f29667g
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
        L_0x0350:
            r2 = 106496(0x1a000, double:5.2616E-319)
            long r2 = r44 & r2
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x035e
            android.widget.TextView r0 = r1.f29668h
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
        L_0x035e:
            long r2 = r44 & r16
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x0369
            android.widget.TextView r0 = r1.f29669i
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
        L_0x0369:
            r2 = 100352(0x18800, double:4.95805E-319)
            long r2 = r44 & r2
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x0377
            android.widget.TextView r0 = r1.j
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r12)
        L_0x0377:
            r2 = 98816(0x18200, double:4.88216E-319)
            long r2 = r44 & r2
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x038a
            android.widget.TextView r0 = r1.m
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            android.widget.TextView r0 = r1.v
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
        L_0x038a:
            r2 = 98336(0x18020, double:4.85844E-319)
            long r2 = r44 & r2
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x03b7
            android.widget.TextView r0 = r1.m
            r0.setVisibility(r14)
            android.view.View r0 = r1.s
            r0.setVisibility(r14)
            android.widget.TextView r0 = r1.v
            r12 = r26
            r0.setVisibility(r12)
            android.widget.TextView r0 = r1.w
            r2 = r46
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.B
            r2 = r47
            r0.setVisibility(r2)
            android.widget.TextView r0 = r1.C
            r0.setVisibility(r14)
        L_0x03b7:
            long r2 = r44 & r24
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x03c6
            android.widget.TextView r0 = r1.w
            r6 = r48
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r6)
        L_0x03c6:
            r2 = 98432(0x18080, double:4.8632E-319)
            long r2 = r44 & r2
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x03d6
            android.widget.TextView r0 = r1.I
            r8 = r49
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x03d6:
            long r2 = r44 & r20
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x03e3
            android.widget.TextView r0 = r1.z
            r15 = r50
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r15)
        L_0x03e3:
            net.one97.paytm.hotels2.b.ac r0 = r1.A
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.ac r0 = r1.f29661a
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.ac r0 = r1.l
            executeBindingsOn(r0)
            return
        L_0x03f3:
            r0 = move-exception
            monitor-exit(r51)     // Catch:{ all -> 0x03f3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.ex.executeBindings():void");
    }

    public final void b(int i2) {
        boolean z = true;
        if (i2 == 3) {
            EditSearchViewModel editSearchViewModel = this.D;
            if (editSearchViewModel == null) {
                z = false;
            }
            if (z) {
                editSearchViewModel.onCityLocalityClick();
            }
        } else if (i2 == 4) {
            EditSearchViewModel editSearchViewModel2 = this.D;
            if (editSearchViewModel2 == null) {
                z = false;
            }
            if (z) {
                editSearchViewModel2.dateClick();
            }
        } else if (i2 == 5) {
            EditSearchViewModel editSearchViewModel3 = this.D;
            if (editSearchViewModel3 == null) {
                z = false;
            }
            if (z) {
                editSearchViewModel3.dateClick();
            }
        }
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            EditSearchViewModel editSearchViewModel = this.D;
            if (editSearchViewModel != null) {
                z = true;
            }
            if (z) {
                editSearchViewModel.closeButtonClickHandler();
            }
        } else if (i2 == 2) {
            EditSearchViewModel editSearchViewModel2 = this.D;
            if (editSearchViewModel2 != null) {
                z = true;
            }
            if (z) {
                editSearchViewModel2.onCityLocalityClick();
            }
        } else if (i2 == 6) {
            EditSearchViewModel editSearchViewModel3 = this.D;
            if (editSearchViewModel3 != null) {
                z = true;
            }
            if (z) {
                editSearchViewModel3.searchButtonClick();
            }
        } else if (i2 == 7) {
            EditSearchViewModel editSearchViewModel4 = this.D;
            if (editSearchViewModel4 != null) {
                z = true;
            }
            if (z) {
                editSearchViewModel4.updateSearchButtonClick();
            }
        }
    }
}
