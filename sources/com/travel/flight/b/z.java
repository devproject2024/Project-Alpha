package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;

public final class z extends y implements a.C0456a {
    private static final ViewDataBinding.b u;
    private static final SparseIntArray v;
    private final View.OnClickListener A;
    private long B;
    private final ConstraintLayout w;
    private final View.OnClickListener x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(19);
        u = bVar;
        bVar.a(0, new String[]{"layout_srp_bottom_strip_v2_drt", "layout_price_info_bar"}, new int[]{12, 13}, new int[]{R.layout.layout_srp_bottom_strip_v2_drt, R.layout.layout_price_info_bar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        v = sparseIntArray;
        sparseIntArray.put(R.id.separator1, 14);
        v.put(R.id.onward_journey_lyt, 15);
        v.put(R.id.return_journey_lyt, 16);
        v.put(R.id.separator2, 17);
        v.put(R.id.pullToRefresh, 18);
    }

    public z(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 19, u, v));
    }

    private z(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[12], objArr[13], objArr[4], objArr[15], objArr[3], objArr[5], objArr[2], objArr[18], objArr[8], objArr[16], objArr[7], objArr[9], objArr[6], objArr[10], objArr[11], objArr[14], objArr[17]);
        this.B = -1;
        this.f24046a.setTag((Object) null);
        this.w = objArr[0];
        this.w.setTag((Object) null);
        this.f24049d.setTag((Object) null);
        this.f24051f.setTag((Object) null);
        this.f24052g.setTag((Object) null);
        this.f24053h.setTag((Object) null);
        this.j.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        setRootTag(view);
        this.x = new a(this, 1);
        this.y = new a(this, 2);
        this.z = new a(this, 3);
        this.A = new a(this, 4);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.B = 4096;
        }
        this.f24047b.invalidateAll();
        this.f24048c.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.f24048c.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f24047b.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.B     // Catch:{ all -> 0x0021 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            com.travel.flight.b.bo r0 = r6.f24047b
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            com.travel.flight.b.bi r0 = r6.f24048c
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.z.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.s == i2) {
            a((SRPSharedViewModel) obj);
        } else if (com.travel.flight.a.f23479c != i2) {
            return false;
        } else {
            a((DRTListViewModel) obj);
        }
        return true;
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.s = sRPSharedViewModel;
        synchronized (this) {
            this.B |= 1024;
        }
        notifyPropertyChanged(com.travel.flight.a.s);
        super.requestRebind();
    }

    public final void a(DRTListViewModel dRTListViewModel) {
        this.t = dRTListViewModel;
        synchronized (this) {
            this.B |= 2048;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f24047b.setLifecycleOwner(qVar);
        this.f24048c.setLifecycleOwner(qVar);
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
            default:
                return false;
        }
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.B |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.B |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.B |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.B |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.B |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.B |= 32;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.B |= 64;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.B |= 128;
        }
        return true;
    }

    private boolean i(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.B |= 256;
        }
        return true;
    }

    private boolean j(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.B |= 512;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r39 = this;
            r1 = r39
            monitor-enter(r39)
            long r2 = r1.B     // Catch:{ all -> 0x02cb }
            r4 = 0
            r1.B = r4     // Catch:{ all -> 0x02cb }
            monitor-exit(r39)     // Catch:{ all -> 0x02cb }
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r1.s
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r6 = r1.t
            r7 = 5124(0x1404, double:2.5316E-320)
            long r9 = r2 & r7
            int r12 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0037
            if (r0 == 0) goto L_0x001d
            androidx.lifecycle.y r9 = r0.getSearchInput()
            goto L_0x001e
        L_0x001d:
            r9 = 0
        L_0x001e:
            r10 = 2
            r1.updateLiveDataRegistration(r10, r9)
            if (r9 == 0) goto L_0x002b
            java.lang.Object r9 = r9.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchInput r9 = (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r9
            goto L_0x002c
        L_0x002b:
            r9 = 0
        L_0x002c:
            if (r9 == 0) goto L_0x0038
            java.lang.String r10 = r9.getDate()
            java.lang.String r12 = r9.getReturnDate()
            goto L_0x003a
        L_0x0037:
            r9 = 0
        L_0x0038:
            r10 = 0
            r12 = 0
        L_0x003a:
            r13 = 8121(0x1fb9, double:4.0123E-320)
            long r13 = r13 & r2
            r15 = 6160(0x1810, double:3.0434E-320)
            r17 = 6272(0x1880, double:3.099E-320)
            r19 = 6416(0x1910, double:3.17E-320)
            r21 = 6152(0x1808, double:3.0395E-320)
            r23 = 16777216(0x1000000, double:8.289046E-317)
            r25 = 7713(0x1e21, double:3.8107E-320)
            r11 = 8
            int r28 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x016d
            long r13 = r2 & r21
            int r28 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x008c
            if (r6 == 0) goto L_0x005d
            androidx.lifecycle.y r13 = r6.getReturnFlightList()
            goto L_0x005e
        L_0x005d:
            r13 = 0
        L_0x005e:
            r14 = 3
            r1.updateLiveDataRegistration(r14, r13)
            if (r13 == 0) goto L_0x006b
            java.lang.Object r13 = r13.getValue()
            java.util.List r13 = (java.util.List) r13
            goto L_0x006c
        L_0x006b:
            r13 = 0
        L_0x006c:
            if (r13 == 0) goto L_0x0073
            int r14 = r13.size()
            goto L_0x0074
        L_0x0073:
            r14 = 0
        L_0x0074:
            if (r14 <= 0) goto L_0x0078
            r14 = 1
            goto L_0x0079
        L_0x0078:
            r14 = 0
        L_0x0079:
            if (r28 == 0) goto L_0x0086
            if (r14 == 0) goto L_0x0081
            r28 = 65536(0x10000, double:3.2379E-319)
            goto L_0x0084
        L_0x0081:
            r28 = 32768(0x8000, double:1.61895E-319)
        L_0x0084:
            long r2 = r2 | r28
        L_0x0086:
            if (r14 == 0) goto L_0x0089
            goto L_0x008d
        L_0x0089:
            r14 = 8
            goto L_0x008e
        L_0x008c:
            r13 = 0
        L_0x008d:
            r14 = 0
        L_0x008e:
            long r28 = r2 & r19
            int r30 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r30 == 0) goto L_0x00ea
            if (r6 == 0) goto L_0x00a3
            androidx.lifecycle.y r28 = r6.getDiscountStripList()
            androidx.lifecycle.y r29 = r6.getMSelectedAirline()
            r7 = r28
            r8 = r29
            goto L_0x00a5
        L_0x00a3:
            r7 = 0
            r8 = 0
        L_0x00a5:
            r4 = 4
            r1.updateLiveDataRegistration(r4, r7)
            r1.updateLiveDataRegistration(r11, r8)
            if (r7 == 0) goto L_0x00b5
            java.lang.Object r4 = r7.getValue()
            java.util.List r4 = (java.util.List) r4
            goto L_0x00b6
        L_0x00b5:
            r4 = 0
        L_0x00b6:
            if (r8 == 0) goto L_0x00bf
            java.lang.Object r5 = r8.getValue()
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            goto L_0x00c0
        L_0x00bf:
            r5 = 0
        L_0x00c0:
            long r7 = r2 & r15
            r30 = 0
            int r32 = (r7 > r30 ? 1 : (r7 == r30 ? 0 : -1))
            if (r32 == 0) goto L_0x00ec
            if (r4 == 0) goto L_0x00cf
            int r8 = r4.size()
            goto L_0x00d0
        L_0x00cf:
            r8 = 0
        L_0x00d0:
            if (r8 <= 0) goto L_0x00d4
            r7 = 1
            goto L_0x00d5
        L_0x00d4:
            r7 = 0
        L_0x00d5:
            if (r32 == 0) goto L_0x00e2
            if (r7 == 0) goto L_0x00dd
            r32 = 4194304(0x400000, double:2.0722615E-317)
            goto L_0x00e0
        L_0x00dd:
            r32 = 2097152(0x200000, double:1.0361308E-317)
        L_0x00e0:
            long r2 = r2 | r32
        L_0x00e2:
            if (r7 == 0) goto L_0x00e6
            r7 = 0
            goto L_0x00e8
        L_0x00e6:
            r7 = 8
        L_0x00e8:
            r8 = r7
            goto L_0x00ed
        L_0x00ea:
            r4 = 0
            r5 = 0
        L_0x00ec:
            r8 = 0
        L_0x00ed:
            long r32 = r2 & r25
            r30 = 0
            int r7 = (r32 > r30 ? 1 : (r32 == r30 ? 0 : -1))
            if (r7 == 0) goto L_0x011e
            if (r6 == 0) goto L_0x00fe
            androidx.lifecycle.y r32 = r6.getSelectedOnwardFlight()
            r11 = r32
            goto L_0x00ff
        L_0x00fe:
            r11 = 0
        L_0x00ff:
            r15 = 5
            r1.updateLiveDataRegistration(r15, r11)
            if (r11 == 0) goto L_0x010c
            java.lang.Object r11 = r11.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r11 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r11
            goto L_0x010d
        L_0x010c:
            r11 = 0
        L_0x010d:
            if (r11 == 0) goto L_0x0111
            r11 = 1
            goto L_0x0112
        L_0x0111:
            r11 = 0
        L_0x0112:
            if (r7 == 0) goto L_0x011f
            if (r11 == 0) goto L_0x0119
            long r2 = r2 | r23
            goto L_0x011f
        L_0x0119:
            r15 = 8388608(0x800000, double:4.144523E-317)
            long r2 = r2 | r15
            goto L_0x011f
        L_0x011e:
            r11 = 0
        L_0x011f:
            long r15 = r2 & r17
            r30 = 0
            int r7 = (r15 > r30 ? 1 : (r15 == r30 ? 0 : -1))
            if (r7 == 0) goto L_0x0165
            if (r6 == 0) goto L_0x0130
            androidx.lifecycle.y r15 = r6.getOnwardFlightList()
            r16 = r4
            goto L_0x0133
        L_0x0130:
            r16 = r4
            r15 = 0
        L_0x0133:
            r4 = 7
            r1.updateLiveDataRegistration(r4, r15)
            if (r15 == 0) goto L_0x0140
            java.lang.Object r4 = r15.getValue()
            java.util.List r4 = (java.util.List) r4
            goto L_0x0141
        L_0x0140:
            r4 = 0
        L_0x0141:
            if (r4 == 0) goto L_0x0148
            int r15 = r4.size()
            goto L_0x0149
        L_0x0148:
            r15 = 0
        L_0x0149:
            if (r15 <= 0) goto L_0x014d
            r15 = 1
            goto L_0x014e
        L_0x014d:
            r15 = 0
        L_0x014e:
            if (r7 == 0) goto L_0x015b
            if (r15 == 0) goto L_0x0156
            r34 = 1048576(0x100000, double:5.180654E-318)
            goto L_0x0159
        L_0x0156:
            r34 = 524288(0x80000, double:2.590327E-318)
        L_0x0159:
            long r2 = r2 | r34
        L_0x015b:
            if (r15 == 0) goto L_0x015f
            r7 = 0
            goto L_0x0161
        L_0x015f:
            r7 = 8
        L_0x0161:
            r15 = r13
            r13 = r16
            goto L_0x0175
        L_0x0165:
            r16 = r4
            r15 = r13
            r13 = r16
            r4 = 0
            r7 = 0
            goto L_0x0175
        L_0x016d:
            r4 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0175:
            long r23 = r2 & r23
            r30 = 0
            int r16 = (r23 > r30 ? 1 : (r23 == r30 ? 0 : -1))
            if (r16 == 0) goto L_0x01a4
            if (r6 == 0) goto L_0x018d
            androidx.lifecycle.y r16 = r6.getSelectedReturnFlight()
            r23 = r14
            r14 = 0
            r38 = r16
            r16 = r15
            r15 = r38
            goto L_0x0193
        L_0x018d:
            r23 = r14
            r16 = r15
            r14 = 0
            r15 = 0
        L_0x0193:
            r1.updateLiveDataRegistration(r14, r15)
            if (r15 == 0) goto L_0x019f
            java.lang.Object r14 = r15.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r14 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r14
            goto L_0x01a0
        L_0x019f:
            r14 = 0
        L_0x01a0:
            if (r14 == 0) goto L_0x01a8
            r14 = 1
            goto L_0x01a9
        L_0x01a4:
            r23 = r14
            r16 = r15
        L_0x01a8:
            r14 = 0
        L_0x01a9:
            long r34 = r2 & r25
            r36 = 262144(0x40000, double:1.295163E-318)
            r30 = 0
            int r15 = (r34 > r30 ? 1 : (r34 == r30 ? 0 : -1))
            if (r15 == 0) goto L_0x01c5
            if (r11 == 0) goto L_0x01b7
            goto L_0x01b8
        L_0x01b7:
            r14 = 0
        L_0x01b8:
            if (r15 == 0) goto L_0x01c6
            if (r14 == 0) goto L_0x01bf
            long r2 = r2 | r36
            goto L_0x01c6
        L_0x01bf:
            r34 = 131072(0x20000, double:6.47582E-319)
            long r2 = r2 | r34
            goto L_0x01c6
        L_0x01c5:
            r14 = 0
        L_0x01c6:
            long r34 = r2 & r36
            r30 = 0
            int r11 = (r34 > r30 ? 1 : (r34 == r30 ? 0 : -1))
            if (r11 == 0) goto L_0x01f0
            if (r0 == 0) goto L_0x01d5
            androidx.lifecycle.y r11 = r0.isSortFragmentAttached()
            goto L_0x01d6
        L_0x01d5:
            r11 = 0
        L_0x01d6:
            r0 = 9
            r1.updateLiveDataRegistration(r0, r11)
            if (r11 == 0) goto L_0x01e7
            java.lang.Object r0 = r11.getValue()
            r11 = r0
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            r27 = r11
            goto L_0x01e9
        L_0x01e7:
            r27 = 0
        L_0x01e9:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r27)
            r11 = 1
            r0 = r0 ^ r11
            goto L_0x01f1
        L_0x01f0:
            r0 = 0
        L_0x01f1:
            long r34 = r2 & r25
            r30 = 0
            int r11 = (r34 > r30 ? 1 : (r34 == r30 ? 0 : -1))
            if (r11 == 0) goto L_0x0211
            if (r14 == 0) goto L_0x01fc
            goto L_0x01fd
        L_0x01fc:
            r0 = 0
        L_0x01fd:
            if (r11 == 0) goto L_0x0207
            if (r0 == 0) goto L_0x0204
            r14 = 16384(0x4000, double:8.0948E-320)
            goto L_0x0206
        L_0x0204:
            r14 = 8192(0x2000, double:4.0474E-320)
        L_0x0206:
            long r2 = r2 | r14
        L_0x0207:
            if (r0 == 0) goto L_0x020c
            r32 = 0
            goto L_0x020e
        L_0x020c:
            r32 = 8
        L_0x020e:
            r0 = r32
            goto L_0x0212
        L_0x0211:
            r0 = 0
        L_0x0212:
            r14 = 6160(0x1810, double:3.0434E-320)
            long r14 = r14 & r2
            r30 = 0
            int r11 = (r14 > r30 ? 1 : (r14 == r30 ? 0 : -1))
            if (r11 == 0) goto L_0x0220
            androidx.recyclerview.widget.RecyclerView r11 = r1.f24046a
            r11.setVisibility(r8)
        L_0x0220:
            long r14 = r2 & r19
            int r8 = (r14 > r30 ? 1 : (r14 == r30 ? 0 : -1))
            if (r8 == 0) goto L_0x022b
            androidx.recyclerview.widget.RecyclerView r8 = r1.f24046a
            com.travel.flight.flightSRPV2.c.c.a((androidx.recyclerview.widget.RecyclerView) r8, (com.travel.flight.flightSRPV2.viewModel.DRTListViewModel) r6, (java.util.List<? extends com.travel.flight.pojo.flightticket.CJRDiscountedStrip>) r13, (java.util.ArrayList<java.lang.String>) r5)
        L_0x022b:
            long r13 = r2 & r17
            int r5 = (r13 > r30 ? 1 : (r13 == r30 ? 0 : -1))
            if (r5 == 0) goto L_0x0245
            com.travel.flight.b.bo r5 = r1.f24047b
            android.view.View r5 = r5.getRoot()
            r5.setVisibility(r7)
            androidx.recyclerview.widget.RecyclerView r5 = r1.o
            r5.setVisibility(r7)
            androidx.recyclerview.widget.RecyclerView r5 = r1.o
            r7 = 1
            com.travel.flight.flightSRPV2.c.c.a((androidx.recyclerview.widget.RecyclerView) r5, (com.travel.flight.flightSRPV2.viewModel.DRTListViewModel) r6, (java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightDetailsItem>) r4, (boolean) r7)
        L_0x0245:
            r4 = 6144(0x1800, double:3.0355E-320)
            long r4 = r4 & r2
            r7 = 0
            int r11 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x0258
            com.travel.flight.b.bo r4 = r1.f24047b
            r4.a(r6)
            com.travel.flight.b.bi r4 = r1.f24048c
            r4.a(r6)
        L_0x0258:
            long r4 = r2 & r25
            int r11 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x0267
            com.travel.flight.b.bi r4 = r1.f24048c
            android.view.View r4 = r4.getRoot()
            r4.setVisibility(r0)
        L_0x0267:
            r4 = 5124(0x1404, double:2.5316E-320)
            long r4 = r4 & r2
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0284
            com.paytm.utility.RoboTextView r0 = r1.f24049d
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel.setJourneyDate(r0, r10)
            com.paytm.utility.RoboTextView r0 = r1.f24053h
            r4 = 1
            r5 = 0
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r9, (boolean) r4, (boolean) r5)
            com.paytm.utility.RoboTextView r0 = r1.j
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel.setJourneyDate(r0, r12)
            com.paytm.utility.RoboTextView r0 = r1.n
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (com.travel.flight.pojo.flightticket.CJRFlightSearchInput) r9, (boolean) r5, (boolean) r5)
        L_0x0284:
            r4 = 4096(0x1000, double:2.0237E-320)
            long r4 = r4 & r2
            r7 = 0
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x02a9
            android.widget.ImageView r0 = r1.f24051f
            android.view.View$OnClickListener r4 = r1.x
            r0.setOnClickListener(r4)
            android.widget.ImageView r0 = r1.f24052g
            android.view.View$OnClickListener r4 = r1.y
            r0.setOnClickListener(r4)
            android.widget.ImageView r0 = r1.l
            android.view.View$OnClickListener r4 = r1.z
            r0.setOnClickListener(r4)
            android.widget.ImageView r0 = r1.m
            android.view.View$OnClickListener r4 = r1.A
            r0.setOnClickListener(r4)
        L_0x02a9:
            long r2 = r2 & r21
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x02c0
            androidx.recyclerview.widget.RecyclerView r0 = r1.p
            r14 = r23
            r0.setVisibility(r14)
            androidx.recyclerview.widget.RecyclerView r0 = r1.p
            r13 = r16
            r2 = 0
            com.travel.flight.flightSRPV2.c.c.a((androidx.recyclerview.widget.RecyclerView) r0, (com.travel.flight.flightSRPV2.viewModel.DRTListViewModel) r6, (java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightDetailsItem>) r13, (boolean) r2)
        L_0x02c0:
            com.travel.flight.b.bo r0 = r1.f24047b
            executeBindingsOn(r0)
            com.travel.flight.b.bi r0 = r1.f24048c
            executeBindingsOn(r0)
            return
        L_0x02cb:
            r0 = move-exception
            monitor-exit(r39)     // Catch:{ all -> 0x02cb }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.z.executeBindings():void");
    }

    public final void a(int i2, View view) {
        boolean z2 = false;
        boolean z3 = true;
        if (i2 == 1) {
            DRTListViewModel dRTListViewModel = this.t;
            SRPSharedViewModel sRPSharedViewModel = this.s;
            if (dRTListViewModel != null) {
                if (sRPSharedViewModel != null) {
                    y<CJRFlightSearchInput> searchInput = sRPSharedViewModel.getSearchInput();
                    if (searchInput != null) {
                        z2 = true;
                    }
                    if (z2) {
                        dRTListViewModel.onArrowClick(getRoot().getContext(), searchInput.getValue(), true, true);
                    }
                }
            }
        } else if (i2 == 2) {
            DRTListViewModel dRTListViewModel2 = this.t;
            SRPSharedViewModel sRPSharedViewModel2 = this.s;
            if (dRTListViewModel2 != null) {
                if (sRPSharedViewModel2 != null) {
                    y<CJRFlightSearchInput> searchInput2 = sRPSharedViewModel2.getSearchInput();
                    if (searchInput2 != null) {
                        dRTListViewModel2.onArrowClick(getRoot().getContext(), searchInput2.getValue(), true, false);
                    }
                }
            }
        } else if (i2 == 3) {
            DRTListViewModel dRTListViewModel3 = this.t;
            SRPSharedViewModel sRPSharedViewModel3 = this.s;
            if (dRTListViewModel3 != null) {
                if (sRPSharedViewModel3 != null) {
                    y<CJRFlightSearchInput> searchInput3 = sRPSharedViewModel3.getSearchInput();
                    if (searchInput3 != null) {
                        dRTListViewModel3.onArrowClick(getRoot().getContext(), searchInput3.getValue(), false, true);
                    }
                }
            }
        } else if (i2 == 4) {
            DRTListViewModel dRTListViewModel4 = this.t;
            SRPSharedViewModel sRPSharedViewModel4 = this.s;
            if (dRTListViewModel4 != null) {
                if (sRPSharedViewModel4 != null) {
                    y<CJRFlightSearchInput> searchInput4 = sRPSharedViewModel4.getSearchInput();
                    if (searchInput4 == null) {
                        z3 = false;
                    }
                    if (z3) {
                        dRTListViewModel4.onArrowClick(getRoot().getContext(), searchInput4.getValue(), false, false);
                    }
                }
            }
        }
    }
}
