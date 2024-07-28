package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.HotelSearchResponse;
import net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class gl extends gk {
    private static final ViewDataBinding.b l;
    private static final SparseIntArray m;
    private final RelativeLayout n;
    private final LinearLayout o;
    private final eo p;
    private final LinearLayout q;
    private final LinearLayout r;
    private long s;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(13);
        l = bVar;
        bVar.a(0, new String[]{"h4_srp_bottom_sort_filter_view"}, new int[]{9}, new int[]{R.layout.h4_srp_bottom_sort_filter_view});
        l.a(1, new String[]{"hotel4_srp_header", "h4_hotel_sold_out_lyt", "h4_srp_error_lyout"}, new int[]{5, 6, 7}, new int[]{R.layout.hotel4_srp_header, R.layout.h4_hotel_sold_out_lyt, R.layout.h4_srp_error_lyout});
        l.a(3, new String[]{"h4_srp_no_result_lyout"}, new int[]{8}, new int[]{R.layout.h4_srp_no_result_lyout});
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.recyclerview_selected_location, 10);
        m.put(R.id.recyclerview_srp, 11);
        m.put(R.id.shimmerFrameLayout, 12);
    }

    public gl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 13, l, m));
    }

    private gl(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[9], objArr[5], objArr[8], objArr[10], objArr[11], objArr[12], objArr[6], objArr[2]);
        this.s = -1;
        this.n = objArr[0];
        this.n.setTag((Object) null);
        this.o = objArr[1];
        this.o.setTag((Object) null);
        this.p = objArr[7];
        setContainedBinding(this.p);
        this.q = objArr[3];
        this.q.setTag((Object) null);
        this.r = objArr[4];
        this.r.setTag((Object) null);
        this.f29848h.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.s = 2048;
        }
        this.f29842b.invalidateAll();
        this.f29847g.invalidateAll();
        this.p.invalidateAll();
        this.f29843c.invalidateAll();
        this.f29841a.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.f29847g.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r6.p.hasPendingBindings() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r6.f29843c.hasPendingBindings() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r6.f29841a.hasPendingBindings() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f29842b.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.s     // Catch:{ all -> 0x003c }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x003c }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x003c }
            net.one97.paytm.hotels2.b.ge r0 = r6.f29842b
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            net.one97.paytm.hotels2.b.bq r0 = r6.f29847g
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            net.one97.paytm.hotels2.b.eo r0 = r6.p
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0028
            return r4
        L_0x0028:
            net.one97.paytm.hotels2.b.ey r0 = r6.f29843c
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0031
            return r4
        L_0x0031:
            net.one97.paytm.hotels2.b.em r0 = r6.f29841a
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x003a
            return r4
        L_0x003a:
            r0 = 0
            return r0
        L_0x003c:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.gl.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.q == i2) {
            a((SRPHeaderViewModel) obj);
        } else if (a.f29089d == i2) {
            this.k = (HotelSearchResponse) obj;
        } else if (a.X != i2) {
            return false;
        } else {
            a((SRPViewModel) obj);
        }
        return true;
    }

    public final void a(SRPHeaderViewModel sRPHeaderViewModel) {
        this.j = sRPHeaderViewModel;
        synchronized (this) {
            this.s |= 256;
        }
        notifyPropertyChanged(a.q);
        super.requestRebind();
    }

    public final void a(SRPViewModel sRPViewModel) {
        this.f29849i = sRPViewModel;
        synchronized (this) {
            this.s |= 1024;
        }
        notifyPropertyChanged(a.X);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f29842b.setLifecycleOwner(qVar);
        this.f29847g.setLifecycleOwner(qVar);
        this.p.setLifecycleOwner(qVar);
        this.f29843c.setLifecycleOwner(qVar);
        this.f29841a.setLifecycleOwner(qVar);
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
            default:
                return false;
        }
    }

    private boolean a(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 8;
        }
        return true;
    }

    private boolean e(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 16;
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 32;
        }
        return true;
    }

    private boolean g(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 64;
        }
        return true;
    }

    private boolean h(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.s |= 128;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r38 = this;
            r1 = r38
            monitor-enter(r38)
            long r2 = r1.s     // Catch:{ all -> 0x01ff }
            r4 = 0
            r1.s = r4     // Catch:{ all -> 0x01ff }
            monitor-exit(r38)     // Catch:{ all -> 0x01ff }
            net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel r0 = r1.j
            net.one97.paytm.hotel4.viewmodel.SRPViewModel r6 = r1.f29849i
            r7 = 3101(0xc1d, double:1.532E-320)
            long r7 = r7 & r2
            r9 = 8192(0x2000, double:4.0474E-320)
            r13 = 3
            r16 = 3076(0xc04, double:1.5197E-320)
            r18 = 262144(0x40000, double:1.295163E-318)
            r20 = 3073(0xc01, double:1.5183E-320)
            r22 = 3080(0xc08, double:1.5217E-320)
            r24 = 3081(0xc09, double:1.522E-320)
            r26 = 8
            r27 = 0
            r14 = 0
            int r15 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x011f
            long r7 = r2 & r24
            int r15 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0072
            if (r6 == 0) goto L_0x0035
            com.travel.utils.l r7 = r6.getSrpNoResultVisibility()
            goto L_0x0037
        L_0x0035:
            r7 = r27
        L_0x0037:
            r1.updateLiveDataRegistration(r14, r7)
            if (r7 == 0) goto L_0x0043
            java.lang.Object r7 = r7.getValue()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            goto L_0x0045
        L_0x0043:
            r7 = r27
        L_0x0045:
            boolean r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r7)
            if (r15 == 0) goto L_0x0055
            if (r7 == 0) goto L_0x0053
            r30 = 524288(0x80000, double:2.590327E-318)
            long r2 = r2 | r30
            goto L_0x0055
        L_0x0053:
            long r2 = r2 | r18
        L_0x0055:
            long r30 = r2 & r20
            int r8 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0066
            if (r7 == 0) goto L_0x0061
            r30 = 8388608(0x800000, double:4.144523E-317)
            goto L_0x0064
        L_0x0061:
            r30 = 4194304(0x400000, double:2.0722615E-317)
        L_0x0064:
            long r2 = r2 | r30
        L_0x0066:
            long r30 = r2 & r20
            int r8 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0073
            if (r7 == 0) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            r8 = 8
            goto L_0x0074
        L_0x0072:
            r7 = 0
        L_0x0073:
            r8 = 0
        L_0x0074:
            long r30 = r2 & r16
            int r15 = (r30 > r4 ? 1 : (r30 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00aa
            if (r6 == 0) goto L_0x0083
            androidx.lifecycle.y r30 = r6.isHotelSoldOut()
            r14 = r30
            goto L_0x0085
        L_0x0083:
            r14 = r27
        L_0x0085:
            r11 = 2
            r1.updateLiveDataRegistration(r11, r14)
            if (r14 == 0) goto L_0x0092
            java.lang.Object r11 = r14.getValue()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            goto L_0x0094
        L_0x0092:
            r11 = r27
        L_0x0094:
            boolean r11 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r11)
            if (r15 == 0) goto L_0x00a4
            if (r11 == 0) goto L_0x00a0
            r14 = 2097152(0x200000, double:1.0361308E-317)
            goto L_0x00a3
        L_0x00a0:
            r14 = 1048576(0x100000, double:5.180654E-318)
        L_0x00a3:
            long r2 = r2 | r14
        L_0x00a4:
            if (r11 == 0) goto L_0x00a7
            goto L_0x00aa
        L_0x00a7:
            r14 = 8
            goto L_0x00ab
        L_0x00aa:
            r14 = 0
        L_0x00ab:
            long r11 = r2 & r22
            int r15 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00df
            if (r6 == 0) goto L_0x00b8
            com.travel.utils.l r11 = r6.getSrpErrorVisibility()
            goto L_0x00ba
        L_0x00b8:
            r11 = r27
        L_0x00ba:
            r1.updateLiveDataRegistration(r13, r11)
            if (r11 == 0) goto L_0x00c6
            java.lang.Object r12 = r11.getValue()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            goto L_0x00c8
        L_0x00c6:
            r12 = r27
        L_0x00c8:
            boolean r33 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r12)
            if (r15 == 0) goto L_0x00d6
            if (r33 == 0) goto L_0x00d2
            long r2 = r2 | r9
            goto L_0x00d6
        L_0x00d2:
            r31 = 4096(0x1000, double:2.0237E-320)
            long r2 = r2 | r31
        L_0x00d6:
            if (r33 == 0) goto L_0x00da
            r15 = 0
            goto L_0x00dc
        L_0x00da:
            r15 = 8
        L_0x00dc:
            r28 = 3088(0xc10, double:1.5257E-320)
            goto L_0x00e7
        L_0x00df:
            r11 = r27
            r12 = r11
            r15 = 0
            r28 = 3088(0xc10, double:1.5257E-320)
            r33 = 0
        L_0x00e7:
            long r34 = r2 & r28
            int r36 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r36 == 0) goto L_0x011d
            if (r6 == 0) goto L_0x00f6
            androidx.lifecycle.y r34 = r6.isBottonSortFilterVisible()
            r9 = r34
            goto L_0x00f8
        L_0x00f6:
            r9 = r27
        L_0x00f8:
            r10 = 4
            r1.updateLiveDataRegistration(r10, r9)
            if (r9 == 0) goto L_0x0106
            java.lang.Object r9 = r9.getValue()
            r27 = r9
            java.lang.Boolean r27 = (java.lang.Boolean) r27
        L_0x0106:
            boolean r9 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r27)
            if (r36 == 0) goto L_0x0117
            if (r9 == 0) goto L_0x0112
            r36 = 131072(0x20000, double:6.47582E-319)
            goto L_0x0115
        L_0x0112:
            r36 = 65536(0x10000, double:3.2379E-319)
        L_0x0115:
            long r2 = r2 | r36
        L_0x0117:
            if (r9 == 0) goto L_0x011a
            goto L_0x011d
        L_0x011a:
            r9 = 8
            goto L_0x0129
        L_0x011d:
            r9 = 0
            goto L_0x0129
        L_0x011f:
            r11 = r27
            r12 = r11
            r7 = 0
            r8 = 0
            r9 = 0
            r14 = 0
            r15 = 0
            r33 = 0
        L_0x0129:
            long r18 = r2 & r18
            int r10 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0153
            if (r6 == 0) goto L_0x0135
            com.travel.utils.l r11 = r6.getSrpErrorVisibility()
        L_0x0135:
            r1.updateLiveDataRegistration(r13, r11)
            if (r11 == 0) goto L_0x0141
            java.lang.Object r10 = r11.getValue()
            r12 = r10
            java.lang.Boolean r12 = (java.lang.Boolean) r12
        L_0x0141:
            boolean r33 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r12)
            long r10 = r2 & r22
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0153
            if (r33 == 0) goto L_0x0150
            r10 = 8192(0x2000, double:4.0474E-320)
            goto L_0x0152
        L_0x0150:
            r10 = 4096(0x1000, double:2.0237E-320)
        L_0x0152:
            long r2 = r2 | r10
        L_0x0153:
            long r10 = r2 & r24
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0170
            if (r7 == 0) goto L_0x015d
            r33 = 1
        L_0x015d:
            if (r12 == 0) goto L_0x0168
            if (r33 == 0) goto L_0x0165
            r10 = 32768(0x8000, double:1.61895E-319)
            goto L_0x0167
        L_0x0165:
            r10 = 16384(0x4000, double:8.0948E-320)
        L_0x0167:
            long r2 = r2 | r10
        L_0x0168:
            if (r33 == 0) goto L_0x016b
            goto L_0x016d
        L_0x016b:
            r26 = 0
        L_0x016d:
            r7 = r26
            goto L_0x0171
        L_0x0170:
            r7 = 0
        L_0x0171:
            r10 = 3088(0xc10, double:1.5257E-320)
            long r10 = r10 & r2
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0181
            net.one97.paytm.hotels2.b.em r10 = r1.f29841a
            android.view.View r10 = r10.getRoot()
            r10.setVisibility(r9)
        L_0x0181:
            r9 = 3072(0xc00, double:1.518E-320)
            long r9 = r9 & r2
            int r11 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0197
            net.one97.paytm.hotels2.b.em r9 = r1.f29841a
            r9.a(r6)
            net.one97.paytm.hotels2.b.ey r9 = r1.f29843c
            r9.a((net.one97.paytm.hotel4.viewmodel.SRPViewModel) r6)
            net.one97.paytm.hotels2.b.bq r9 = r1.f29847g
            r9.a(r6)
        L_0x0197:
            r9 = 2304(0x900, double:1.1383E-320)
            long r9 = r9 & r2
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x01ad
            net.one97.paytm.hotels2.b.ge r6 = r1.f29842b
            r6.a(r0)
            net.one97.paytm.hotels2.b.eo r6 = r1.p
            r6.a(r0)
            net.one97.paytm.hotels2.b.ey r6 = r1.f29843c
            r6.a((net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel) r0)
        L_0x01ad:
            long r9 = r2 & r22
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01bc
            net.one97.paytm.hotels2.b.eo r0 = r1.p
            android.view.View r0 = r0.getRoot()
            r0.setVisibility(r15)
        L_0x01bc:
            long r9 = r2 & r20
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01cb
            net.one97.paytm.hotels2.b.ey r0 = r1.f29843c
            android.view.View r0 = r0.getRoot()
            r0.setVisibility(r8)
        L_0x01cb:
            long r8 = r2 & r16
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01da
            net.one97.paytm.hotels2.b.bq r0 = r1.f29847g
            android.view.View r0 = r0.getRoot()
            r0.setVisibility(r14)
        L_0x01da:
            long r2 = r2 & r24
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01e5
            android.widget.TextView r0 = r1.f29848h
            r0.setVisibility(r7)
        L_0x01e5:
            net.one97.paytm.hotels2.b.ge r0 = r1.f29842b
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.bq r0 = r1.f29847g
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.eo r0 = r1.p
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.ey r0 = r1.f29843c
            executeBindingsOn(r0)
            net.one97.paytm.hotels2.b.em r0 = r1.f29841a
            executeBindingsOn(r0)
            return
        L_0x01ff:
            r0 = move-exception
            monitor-exit(r38)     // Catch:{ all -> 0x01ff }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.b.gl.executeBindings():void");
    }
}
