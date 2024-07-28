package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.IRTViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public final class br extends bq implements a.C0456a {
    private static final ViewDataBinding.b m = null;
    private static final SparseIntArray n;
    private final View o;
    private final View p;
    private final View.OnClickListener q;
    private long r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.view_top_shadow, 5);
        n.put(R.id.txt_sort_header, 6);
        n.put(R.id.separator1, 7);
        n.put(R.id.container_filter_options, 8);
        n.put(R.id.txt_filter_header, 9);
        n.put(R.id.separator2, 10);
        n.put(R.id.container_filter_non_stop_flights, 11);
        n.put(R.id.txt_filter_non_stop_flights, 12);
    }

    public br(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 13, m, n));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private br(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[11], objArr[8], objArr[1], objArr[0], objArr[7], objArr[10], objArr[4], objArr[9], objArr[12], objArr[6], objArr[5]);
        this.r = -1;
        this.f23732c.setTag((Object) null);
        this.f23733d.setTag((Object) null);
        this.o = objArr[2];
        this.o.setTag((Object) null);
        this.p = objArr[3];
        this.p.setTag((Object) null);
        this.f23736g.setTag((Object) null);
        setRootTag(view);
        this.q = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.r = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.r != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.f23479c != i2) {
            return false;
        }
        a((IRTViewModel) obj);
        return true;
    }

    public final void a(IRTViewModel iRTViewModel) {
        this.l = iRTViewModel;
        synchronized (this) {
            this.r |= 8;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 == 1) {
            return b(i3);
        }
        if (i2 != 2) {
            return false;
        }
        return c(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.r |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.r |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.r |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.r     // Catch:{ all -> 0x00be }
            r4 = 0
            r1.r = r4     // Catch:{ all -> 0x00be }
            monitor-exit(r18)     // Catch:{ all -> 0x00be }
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel r0 = r1.l
            r6 = 31
            long r6 = r6 & r2
            r8 = 30
            r10 = 25
            r12 = 0
            r13 = 0
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x008c
            if (r0 == 0) goto L_0x0020
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r0.getParentViewModel()
            goto L_0x0021
        L_0x0020:
            r0 = r13
        L_0x0021:
            long r6 = r2 & r10
            r14 = 1
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0051
            if (r0 == 0) goto L_0x002f
            androidx.lifecycle.y r6 = r0.getIrtSortOption()
            goto L_0x0030
        L_0x002f:
            r6 = r13
        L_0x0030:
            r1.updateLiveDataRegistration(r12, r6)
            if (r6 == 0) goto L_0x003c
            java.lang.Object r6 = r6.getValue()
            com.travel.flight.flightSRPV2.a.ae r6 = (com.travel.flight.flightSRPV2.a.ae) r6
            goto L_0x003d
        L_0x003c:
            r6 = r13
        L_0x003d:
            if (r6 == 0) goto L_0x0041
            r6 = 1
            goto L_0x0042
        L_0x0041:
            r6 = 0
        L_0x0042:
            if (r15 == 0) goto L_0x004c
            if (r6 == 0) goto L_0x0049
            r15 = 64
            goto L_0x004b
        L_0x0049:
            r15 = 32
        L_0x004b:
            long r2 = r2 | r15
        L_0x004c:
            if (r6 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r12 = 8
        L_0x0051:
            long r6 = r2 & r8
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x008c
            if (r0 == 0) goto L_0x0062
            androidx.lifecycle.y r6 = r0.getReturnFilterList()
            androidx.lifecycle.y r0 = r0.getOnwardFilterList()
            goto L_0x0064
        L_0x0062:
            r0 = r13
            r6 = r0
        L_0x0064:
            r1.updateLiveDataRegistration(r14, r6)
            r7 = 2
            r1.updateLiveDataRegistration(r7, r0)
            if (r6 == 0) goto L_0x0074
            java.lang.Object r6 = r6.getValue()
            java.util.List r6 = (java.util.List) r6
            goto L_0x0075
        L_0x0074:
            r6 = r13
        L_0x0075:
            if (r0 == 0) goto L_0x007e
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            r13 = r0
        L_0x007e:
            java.util.List r0 = com.travel.flight.flightSRPV2.a.t.a((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r6)
            java.util.List r6 = com.travel.flight.flightSRPV2.a.t.a((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r13)
            r17 = r13
            r13 = r6
            r6 = r17
            goto L_0x008e
        L_0x008c:
            r0 = r13
            r6 = r0
        L_0x008e:
            r14 = 16
            long r14 = r14 & r2
            int r7 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x009c
            androidx.constraintlayout.widget.ConstraintLayout r7 = r1.f23732c
            android.view.View$OnClickListener r14 = r1.q
            r7.setOnClickListener(r14)
        L_0x009c:
            long r10 = r10 & r2
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00a6
            android.view.View r7 = r1.o
            r7.setVisibility(r12)
        L_0x00a6:
            long r7 = r2 & r8
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00b1
            android.view.View r7 = r1.p
            com.travel.flight.flightSRPV2.c.c.a((android.view.View) r7, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r13, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r0)
        L_0x00b1:
            r7 = 28
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00bd
            android.widget.Switch r0 = r1.f23736g
            com.travel.flight.flightSRPV2.c.c.a((android.widget.CompoundButton) r0, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r6)
        L_0x00bd:
            return
        L_0x00be:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x00be }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.br.executeBindings():void");
    }

    public final void a(int i2, View view) {
        IRTViewModel iRTViewModel = this.l;
        boolean z = true;
        if (iRTViewModel != null) {
            SRPSharedViewModel parentViewModel = iRTViewModel.getParentViewModel();
            if (parentViewModel == null) {
                z = false;
            }
            if (z) {
                parentViewModel.onSortOptionsRequested(false);
            }
        }
    }
}
