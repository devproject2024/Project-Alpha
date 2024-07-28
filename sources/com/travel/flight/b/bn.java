package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public final class bn extends bm implements a.C0456a {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p;
    private final View q;
    private final View r;
    private final View.OnClickListener s;
    private long t;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.view_top_shadow, 7);
        p.put(R.id.txt_sort_header, 8);
        p.put(R.id.separator1, 9);
        p.put(R.id.container_filter_options, 10);
        p.put(R.id.txt_filter_header, 11);
        p.put(R.id.separator2, 12);
        p.put(R.id.container_filter_non_stop_flights, 13);
        p.put(R.id.txt_filter_non_stop_flights, 14);
    }

    public bn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 15, o, p));
    }

    private bn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[13], objArr[10], objArr[1], objArr[9], objArr[12], objArr[6], objArr[11], objArr[14], objArr[4], objArr[8], objArr[2], objArr[7]);
        this.t = -1;
        this.f23712a.setTag((Object) null);
        this.f23715d.setTag((Object) null);
        this.q = objArr[3];
        this.q.setTag((Object) null);
        this.r = objArr[5];
        this.r.setTag((Object) null);
        this.f23718g.setTag((Object) null);
        this.j.setTag((Object) null);
        this.l.setTag((Object) null);
        setRootTag(view);
        this.s = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.t = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.t != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.f23479c != i2) {
            return false;
        }
        a((SRPOneWayViewModel) obj);
        return true;
    }

    public final void a(SRPOneWayViewModel sRPOneWayViewModel) {
        this.n = sRPOneWayViewModel;
        synchronized (this) {
            this.t |= 4;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return b(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.t |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.t |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r19 = this;
            r1 = r19
            monitor-enter(r19)
            long r2 = r1.t     // Catch:{ all -> 0x00d2 }
            r4 = 0
            r1.t = r4     // Catch:{ all -> 0x00d2 }
            monitor-exit(r19)     // Catch:{ all -> 0x00d2 }
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r0 = r1.n
            r6 = 15
            long r6 = r6 & r2
            r8 = 14
            r10 = 13
            r12 = 0
            r13 = 0
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0098
            if (r0 == 0) goto L_0x0020
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r0.getParentViewModel()
            goto L_0x0021
        L_0x0020:
            r0 = r12
        L_0x0021:
            long r6 = r2 & r10
            r14 = 8
            r15 = 1
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x005d
            if (r0 == 0) goto L_0x0031
            androidx.lifecycle.y r6 = r0.getOneWaySortOption()
            goto L_0x0032
        L_0x0031:
            r6 = r12
        L_0x0032:
            r1.updateLiveDataRegistration(r13, r6)
            if (r6 == 0) goto L_0x003e
            java.lang.Object r6 = r6.getValue()
            com.travel.flight.flightSRPV2.a.ae r6 = (com.travel.flight.flightSRPV2.a.ae) r6
            goto L_0x003f
        L_0x003e:
            r6 = r12
        L_0x003f:
            if (r6 == 0) goto L_0x0043
            r7 = 1
            goto L_0x0044
        L_0x0043:
            r7 = 0
        L_0x0044:
            if (r16 == 0) goto L_0x004f
            if (r7 == 0) goto L_0x004b
            r16 = 128(0x80, double:6.32E-322)
            goto L_0x004d
        L_0x004b:
            r16 = 64
        L_0x004d:
            long r2 = r2 | r16
        L_0x004f:
            if (r6 == 0) goto L_0x0056
            java.lang.String r6 = r6.b()
            goto L_0x0057
        L_0x0056:
            r6 = r12
        L_0x0057:
            if (r7 == 0) goto L_0x005a
            goto L_0x005e
        L_0x005a:
            r7 = 8
            goto L_0x005f
        L_0x005d:
            r6 = r12
        L_0x005e:
            r7 = 0
        L_0x005f:
            long r16 = r2 & r8
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0096
            if (r0 == 0) goto L_0x006c
            androidx.lifecycle.y r0 = r0.getOnwardFilterList()
            goto L_0x006d
        L_0x006c:
            r0 = r12
        L_0x006d:
            r1.updateLiveDataRegistration(r15, r0)
            if (r0 == 0) goto L_0x0079
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            r12 = r0
        L_0x0079:
            java.util.List r0 = com.travel.flight.flightSRPV2.a.t.a((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r12)
            int r16 = r0.size()
            if (r16 <= 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r15 = 0
        L_0x0085:
            if (r18 == 0) goto L_0x0090
            if (r15 == 0) goto L_0x008c
            r16 = 32
            goto L_0x008e
        L_0x008c:
            r16 = 16
        L_0x008e:
            long r2 = r2 | r16
        L_0x0090:
            if (r15 == 0) goto L_0x0093
            goto L_0x009b
        L_0x0093:
            r13 = 8
            goto L_0x009b
        L_0x0096:
            r0 = r12
            goto L_0x009b
        L_0x0098:
            r0 = r12
            r6 = r0
            r7 = 0
        L_0x009b:
            r14 = 8
            long r14 = r14 & r2
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00a9
            androidx.constraintlayout.widget.ConstraintLayout r14 = r1.f23715d
            android.view.View$OnClickListener r15 = r1.s
            r14.setOnClickListener(r15)
        L_0x00a9:
            long r10 = r10 & r2
            int r14 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00bd
            android.view.View r10 = r1.q
            r10.setVisibility(r7)
            android.widget.TextView r10 = r1.l
            androidx.databinding.a.d.a((android.widget.TextView) r10, (java.lang.CharSequence) r6)
            android.widget.TextView r6 = r1.l
            r6.setVisibility(r7)
        L_0x00bd:
            long r2 = r2 & r8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00d1
            android.view.View r2 = r1.r
            r2.setVisibility(r13)
            android.widget.Switch r2 = r1.f23718g
            com.travel.flight.flightSRPV2.c.c.a((android.widget.CompoundButton) r2, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r12)
            android.widget.TextView r2 = r1.j
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r2, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r0)
        L_0x00d1:
            return
        L_0x00d2:
            r0 = move-exception
            monitor-exit(r19)     // Catch:{ all -> 0x00d2 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.bn.executeBindings():void");
    }

    public final void a(int i2, View view) {
        SRPOneWayViewModel sRPOneWayViewModel = this.n;
        boolean z = false;
        if (sRPOneWayViewModel != null) {
            SRPSharedViewModel parentViewModel = sRPOneWayViewModel.getParentViewModel();
            if (parentViewModel != null) {
                z = true;
            }
            if (z) {
                parentViewModel.onSortOptionsRequested(true);
            }
        }
    }
}
