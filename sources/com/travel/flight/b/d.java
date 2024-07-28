package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.q;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public final class d extends c implements a.C0456a {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f23883i;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private final LinearLayout l;
    private final View.OnClickListener m;
    private long n;

    static {
        ViewDataBinding.b bVar = new ViewDataBinding.b(9);
        f23883i = bVar;
        bVar.a(0, new String[]{"pre_f_flight_srp_v2_action_bar"}, new int[]{5}, new int[]{R.layout.pre_f_flight_srp_v2_action_bar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.container_child, 6);
        j.put(R.id.container_child_shimmer, 7);
        j.put(R.id.container_full_overlay, 8);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, f23883i, j));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[6], objArr[7], objArr[8], objArr[1], objArr[4], objArr[3]);
        this.n = -1;
        this.f23776e.setTag((Object) null);
        this.k = objArr[0];
        this.k.setTag((Object) null);
        this.l = objArr[2];
        this.l.setTag((Object) null);
        this.f23777f.setTag((Object) null);
        this.f23778g.setTag((Object) null);
        setRootTag(view);
        this.m = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.n = 32;
        }
        this.f23772a.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.f23772a.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.n     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            com.travel.flight.b.cq r0 = r6.f23772a
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.d.hasPendingBindings():boolean");
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.f23479c != i2) {
            return false;
        }
        a((SRPSharedViewModel) obj);
        return true;
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.f23779h = sRPSharedViewModel;
        synchronized (this) {
            this.n |= 16;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final void setLifecycleOwner(q qVar) {
        super.setLifecycleOwner(qVar);
        this.f23772a.setLifecycleOwner(qVar);
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 == 1) {
            return b(i3);
        }
        if (i2 == 2) {
            return c(i3);
        }
        if (i2 != 3) {
            return false;
        }
        return d(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.n |= 8;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.n     // Catch:{ all -> 0x00f9 }
            r4 = 0
            r1.n = r4     // Catch:{ all -> 0x00f9 }
            monitor-exit(r22)     // Catch:{ all -> 0x00f9 }
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r1.f23779h
            r6 = 61
            long r6 = r6 & r2
            r8 = 56
            r10 = 52
            r12 = 49
            r14 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00af
            long r6 = r2 & r12
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0034
            if (r0 == 0) goto L_0x0027
            com.travel.flight.flightSRPV2.c.b r6 = r0.getToolTipMessagesEvent()
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            r1.updateLiveDataRegistration(r14, r6)
            if (r6 == 0) goto L_0x0034
            java.lang.Object r6 = r6.getValue()
            java.util.List r6 = (java.util.List) r6
            goto L_0x0035
        L_0x0034:
            r6 = 0
        L_0x0035:
            long r16 = r2 & r10
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0067
            if (r0 == 0) goto L_0x0044
            androidx.lifecycle.y r16 = r0.isToolTipHidden()
            r7 = r16
            goto L_0x0045
        L_0x0044:
            r7 = 0
        L_0x0045:
            r14 = 2
            r1.updateLiveDataRegistration(r14, r7)
            if (r7 == 0) goto L_0x0052
            java.lang.Object r7 = r7.getValue()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            goto L_0x0053
        L_0x0052:
            r7 = 0
        L_0x0053:
            boolean r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r7)
            if (r18 == 0) goto L_0x0062
            if (r7 == 0) goto L_0x005e
            r18 = 512(0x200, double:2.53E-321)
            goto L_0x0060
        L_0x005e:
            r18 = 256(0x100, double:1.265E-321)
        L_0x0060:
            long r2 = r2 | r18
        L_0x0062:
            if (r7 == 0) goto L_0x0067
            r14 = 8
            goto L_0x0068
        L_0x0067:
            r14 = 0
        L_0x0068:
            long r18 = r2 & r8
            int r7 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00ac
            if (r0 == 0) goto L_0x0077
            androidx.lifecycle.y r18 = r0.getSecondarySrpResult()
            r15 = r18
            goto L_0x0078
        L_0x0077:
            r15 = 0
        L_0x0078:
            r8 = 3
            r1.updateLiveDataRegistration(r8, r15)
            if (r15 == 0) goto L_0x0086
            java.lang.Object r8 = r15.getValue()
            r15 = r8
            com.travel.flight.flightSRPV2.a.ad r15 = (com.travel.flight.flightSRPV2.a.ad) r15
            goto L_0x0087
        L_0x0086:
            r15 = 0
        L_0x0087:
            if (r15 == 0) goto L_0x008e
            java.lang.String r8 = r15.f24080a
            r18 = r8
            goto L_0x0090
        L_0x008e:
            r18 = 0
        L_0x0090:
            if (r15 == 0) goto L_0x0094
            r8 = 1
            goto L_0x0095
        L_0x0094:
            r8 = 0
        L_0x0095:
            if (r7 == 0) goto L_0x00a0
            if (r8 == 0) goto L_0x009c
            r20 = 128(0x80, double:6.32E-322)
            goto L_0x009e
        L_0x009c:
            r20 = 64
        L_0x009e:
            long r2 = r2 | r20
        L_0x00a0:
            if (r8 == 0) goto L_0x00a5
            r16 = 0
            goto L_0x00a7
        L_0x00a5:
            r16 = 8
        L_0x00a7:
            r7 = r16
            r8 = r18
            goto L_0x00b3
        L_0x00ac:
            r7 = 0
            r8 = 0
            goto L_0x00b3
        L_0x00af:
            r6 = 0
            r7 = 0
            r8 = 0
            r14 = 0
        L_0x00b3:
            r15 = 48
            long r15 = r15 & r2
            int r9 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x00bf
            com.travel.flight.b.cq r9 = r1.f23772a
            r9.a(r0)
        L_0x00bf:
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c9
            android.widget.LinearLayout r0 = r1.f23776e
            com.travel.flight.flightSRPV2.c.c.a((android.view.ViewGroup) r0, (java.util.List<com.travel.flight.flightSRPV2.a.ag>) r6)
        L_0x00c9:
            long r9 = r2 & r10
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d4
            android.widget.LinearLayout r0 = r1.f23776e
            r0.setVisibility(r14)
        L_0x00d4:
            r9 = 56
            long r9 = r9 & r2
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e5
            android.widget.LinearLayout r0 = r1.l
            r0.setVisibility(r7)
            com.paytm.utility.RoboTextView r0 = r1.f23778g
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
        L_0x00e5:
            r6 = 32
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f3
            com.paytm.utility.RoboTextView r0 = r1.f23777f
            android.view.View$OnClickListener r2 = r1.m
            r0.setOnClickListener(r2)
        L_0x00f3:
            com.travel.flight.b.cq r0 = r1.f23772a
            executeBindingsOn(r0)
            return
        L_0x00f9:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00f9 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.d.executeBindings():void");
    }

    public final void a(int i2, View view) {
        SRPSharedViewModel sRPSharedViewModel = this.f23779h;
        if (sRPSharedViewModel != null) {
            sRPSharedViewModel.updateWithSecondarySrpResult();
        }
    }
}
