package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public final class db extends da {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f23892i = null;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private long l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.txt_duration_text, 6);
    }

    public db(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f23892i, j));
    }

    private db(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[4], objArr[1], objArr[2], objArr[3], objArr[6]);
        this.l = -1;
        this.f23884a.setTag((Object) null);
        this.f23885b.setTag((Object) null);
        this.f23886c.setTag((Object) null);
        this.f23887d.setTag((Object) null);
        this.f23888e.setTag((Object) null);
        this.k = objArr[0];
        this.k.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.x == i2) {
            this.f23890g = (CJRFlightDetailsItem) obj;
            synchronized (this) {
                this.l |= 4;
            }
            notifyPropertyChanged(a.x);
            super.requestRebind();
        } else if (a.p != i2) {
            return false;
        } else {
            this.f23891h = (SRPOneWayViewModel) obj;
            synchronized (this) {
                this.l |= 8;
            }
            notifyPropertyChanged(a.p);
            super.requestRebind();
        }
        return true;
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
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            long r2 = r1.l     // Catch:{ all -> 0x00f6 }
            r4 = 0
            r1.l = r4     // Catch:{ all -> 0x00f6 }
            monitor-exit(r21)     // Catch:{ all -> 0x00f6 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r1.f23890g
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r6 = r1.f23891h
            r7 = 31
            long r7 = r7 & r2
            r9 = 20
            r11 = 22
            r13 = 21
            r15 = 0
            r16 = 0
            int r17 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x00a1
            long r7 = r2 & r13
            int r17 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0040
            if (r0 == 0) goto L_0x002b
            androidx.databinding.i r7 = r0.getFilterSelectedMaxValue()
            goto L_0x002d
        L_0x002b:
            r7 = r16
        L_0x002d:
            r1.updateRegistration((int) r15, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0037
            java.lang.Object r7 = r7.get()
            goto L_0x0039
        L_0x0037:
            r7 = r16
        L_0x0039:
            if (r7 == 0) goto L_0x0040
            java.lang.Integer r7 = (java.lang.Integer) r7
            java.lang.Integer r7 = (java.lang.Integer) r7
            goto L_0x0042
        L_0x0040:
            r7 = r16
        L_0x0042:
            long r17 = r2 & r11
            int r8 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0076
            if (r0 == 0) goto L_0x0051
            androidx.databinding.i r17 = r0.getIsFilterRangeChanged()
            r15 = r17
            goto L_0x0053
        L_0x0051:
            r15 = r16
        L_0x0053:
            r13 = 1
            r1.updateRegistration((int) r13, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x0060
            java.lang.Object r13 = r15.get()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            goto L_0x0062
        L_0x0060:
            r13 = r16
        L_0x0062:
            boolean r13 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r13)
            if (r8 == 0) goto L_0x0070
            if (r13 == 0) goto L_0x006d
            r14 = 64
            goto L_0x006f
        L_0x006d:
            r14 = 32
        L_0x006f:
            long r2 = r2 | r14
        L_0x0070:
            if (r13 == 0) goto L_0x0073
            goto L_0x0076
        L_0x0073:
            r15 = 8
            goto L_0x0077
        L_0x0076:
            r15 = 0
        L_0x0077:
            long r13 = r2 & r9
            int r8 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x009d
            if (r0 == 0) goto L_0x008a
            com.travel.flight.pojo.flightticket.CJRFilterAndBannerInfoItem r8 = r0.getmListItemData()
            int r13 = r0.getPosState()
            r17 = r13
            goto L_0x008e
        L_0x008a:
            r8 = r16
            r17 = 0
        L_0x008e:
            if (r8 == 0) goto L_0x0099
            java.lang.String r13 = r8.getmHeading()
            java.lang.String r8 = r8.getmText()
            goto L_0x00a8
        L_0x0099:
            r8 = r16
            r13 = r8
            goto L_0x00a8
        L_0x009d:
            r8 = r16
            r13 = r8
            goto L_0x00a6
        L_0x00a1:
            r7 = r16
            r8 = r7
            r13 = r8
            r15 = 0
        L_0x00a6:
            r17 = 0
        L_0x00a8:
            r19 = 28
            long r19 = r2 & r19
            int r14 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x00b6
            if (r6 == 0) goto L_0x00b6
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r16 = r6.getParentViewModel()
        L_0x00b6:
            r9 = r16
            long r10 = r2 & r11
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00c3
            android.widget.TextView r10 = r1.f23884a
            r10.setVisibility(r15)
        L_0x00c3:
            if (r14 == 0) goto L_0x00cf
            android.widget.TextView r10 = r1.f23884a
            com.travel.flight.flightSRPV2.c.c.a((android.view.View) r10, (com.travel.flight.flightSRPV2.a.z) r9, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            android.widget.FrameLayout r9 = r1.f23888e
            com.travel.flight.flightSRPV2.c.c.b((android.view.ViewGroup) r9, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0, (com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel) r6)
        L_0x00cf:
            r9 = 21
            long r9 = r9 & r2
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00db
            android.widget.TextView r0 = r1.f23885b
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (java.lang.Integer) r7)
        L_0x00db:
            r6 = 20
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00f5
            android.widget.TextView r0 = r1.f23886c
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r13)
            android.widget.TextView r0 = r1.f23887d
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.k
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            com.travel.flight.flightSRPV2.c.c.a((android.view.View) r0, (java.lang.Integer) r2)
        L_0x00f5:
            return
        L_0x00f6:
            r0 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x00f6 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.db.executeBindings():void");
    }
}
