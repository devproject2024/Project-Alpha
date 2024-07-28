package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.a;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public final class dh extends dg {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = null;
    private final ConstraintLayout l;
    private long m;

    public dh(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, j, k));
    }

    private dh(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[1], objArr[2], objArr[3], objArr[5], objArr[4]);
        this.m = -1;
        this.f23911a.setTag((Object) null);
        this.f23912b.setTag((Object) null);
        this.f23913c.setTag((Object) null);
        this.f23914d.setTag((Object) null);
        this.l = objArr[0];
        this.l.setTag((Object) null);
        this.f23915e.setTag((Object) null);
        this.f23916f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.m = 64;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.m != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.l == i2) {
            this.f23918h = (Boolean) obj;
            synchronized (this) {
                this.m |= 8;
            }
            notifyPropertyChanged(a.l);
            super.requestRebind();
        } else if (a.x == i2) {
            this.f23917g = (CJRFlightDetailsItem) obj;
            synchronized (this) {
                this.m |= 16;
            }
            notifyPropertyChanged(a.x);
            super.requestRebind();
        } else if (a.p != i2) {
            return false;
        } else {
            this.f23919i = (SRPOneWayViewModel) obj;
            synchronized (this) {
                this.m |= 32;
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
        if (i2 == 1) {
            return b(i3);
        }
        if (i2 != 2) {
            return false;
        }
        return c(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r27 = this;
            r1 = r27
            monitor-enter(r27)
            long r2 = r1.m     // Catch:{ all -> 0x0134 }
            r4 = 0
            r1.m = r4     // Catch:{ all -> 0x0134 }
            monitor-exit(r27)     // Catch:{ all -> 0x0134 }
            java.lang.Boolean r0 = r1.f23918h
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r6 = r1.f23917g
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r7 = r1.f23919i
            r8 = 120(0x78, double:5.93E-322)
            long r10 = r2 & r8
            int r13 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x001f
            if (r7 == 0) goto L_0x001f
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r10 = r7.getParentViewModel()
            goto L_0x0020
        L_0x001f:
            r10 = 0
        L_0x0020:
            r13 = 127(0x7f, double:6.27E-322)
            long r13 = r13 & r2
            r15 = 82
            r17 = 80
            r19 = 81
            r21 = 84
            r11 = 0
            int r23 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x00df
            long r13 = r2 & r19
            int r23 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0050
            if (r6 == 0) goto L_0x003d
            androidx.databinding.i r13 = r6.getFilterSelectedMaxValue()
            goto L_0x003e
        L_0x003d:
            r13 = 0
        L_0x003e:
            r1.updateRegistration((int) r11, (androidx.databinding.h) r13)
            if (r13 == 0) goto L_0x0048
            java.lang.Object r13 = r13.get()
            goto L_0x0049
        L_0x0048:
            r13 = 0
        L_0x0049:
            if (r13 == 0) goto L_0x0050
            java.lang.Long r13 = (java.lang.Long) r13
            java.lang.Long r13 = (java.lang.Long) r13
            goto L_0x0051
        L_0x0050:
            r13 = 0
        L_0x0051:
            r23 = 83
            long r23 = r2 & r23
            int r14 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0060
            if (r6 == 0) goto L_0x0060
            java.lang.String r14 = r6.getTimezone()
            goto L_0x0061
        L_0x0060:
            r14 = 0
        L_0x0061:
            long r23 = r2 & r15
            int r25 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r25 == 0) goto L_0x0084
            if (r6 == 0) goto L_0x0070
            androidx.databinding.i r23 = r6.getFilterSelectedMinValue()
            r11 = r23
            goto L_0x0071
        L_0x0070:
            r11 = 0
        L_0x0071:
            r12 = 1
            r1.updateRegistration((int) r12, (androidx.databinding.h) r11)
            if (r11 == 0) goto L_0x007c
            java.lang.Object r12 = r11.get()
            goto L_0x007d
        L_0x007c:
            r12 = 0
        L_0x007d:
            if (r12 == 0) goto L_0x0084
            java.lang.Long r12 = (java.lang.Long) r12
            java.lang.Long r12 = (java.lang.Long) r12
            goto L_0x0085
        L_0x0084:
            r12 = 0
        L_0x0085:
            long r25 = r2 & r21
            int r11 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00b7
            if (r6 == 0) goto L_0x0094
            androidx.databinding.i r25 = r6.getIsFilterRangeChanged()
            r15 = r25
            goto L_0x0095
        L_0x0094:
            r15 = 0
        L_0x0095:
            r8 = 2
            r1.updateRegistration((int) r8, (androidx.databinding.h) r15)
            if (r15 == 0) goto L_0x00a2
            java.lang.Object r8 = r15.get()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            goto L_0x00a3
        L_0x00a2:
            r8 = 0
        L_0x00a3:
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            if (r11 == 0) goto L_0x00b1
            if (r8 == 0) goto L_0x00ae
            r15 = 256(0x100, double:1.265E-321)
            goto L_0x00b0
        L_0x00ae:
            r15 = 128(0x80, double:6.32E-322)
        L_0x00b0:
            long r2 = r2 | r15
        L_0x00b1:
            if (r8 == 0) goto L_0x00b4
            goto L_0x00b7
        L_0x00b4:
            r11 = 8
            goto L_0x00b8
        L_0x00b7:
            r11 = 0
        L_0x00b8:
            long r8 = r2 & r17
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00dc
            if (r6 == 0) goto L_0x00cb
            com.travel.flight.pojo.flightticket.CJRFilterAndBannerInfoItem r8 = r6.getmListItemData()
            int r9 = r6.getPosState()
            r23 = r9
            goto L_0x00ce
        L_0x00cb:
            r8 = 0
            r23 = 0
        L_0x00ce:
            if (r8 == 0) goto L_0x00d9
            java.lang.String r9 = r8.getmHeading()
            java.lang.String r8 = r8.getmText()
            goto L_0x00e7
        L_0x00d9:
            r8 = 0
            r9 = 0
            goto L_0x00e7
        L_0x00dc:
            r8 = 0
            r9 = 0
            goto L_0x00e5
        L_0x00df:
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x00e5:
            r23 = 0
        L_0x00e7:
            long r15 = r2 & r21
            int r21 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x00f2
            android.widget.TextView r15 = r1.f23911a
            r15.setVisibility(r11)
        L_0x00f2:
            r15 = 120(0x78, double:5.93E-322)
            long r15 = r15 & r2
            int r11 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0103
            android.widget.TextView r11 = r1.f23911a
            com.travel.flight.flightSRPV2.c.c.a((android.view.View) r11, (com.travel.flight.flightSRPV2.a.z) r10, (java.lang.Boolean) r0, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r6)
            android.widget.FrameLayout r10 = r1.f23914d
            com.travel.flight.flightSRPV2.c.c.a((android.view.ViewGroup) r10, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r6, (com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel) r7, (java.lang.Boolean) r0)
        L_0x0103:
            long r6 = r2 & r17
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x011c
            android.widget.TextView r0 = r1.f23912b
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r9)
            android.widget.TextView r0 = r1.f23913c
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r8)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.l
            java.lang.Integer r6 = java.lang.Integer.valueOf(r23)
            com.travel.flight.flightSRPV2.c.c.a((android.view.View) r0, (java.lang.Integer) r6)
        L_0x011c:
            long r6 = r2 & r19
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0127
            android.widget.TextView r0 = r1.f23915e
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (java.lang.Long) r13, (java.lang.String) r14)
        L_0x0127:
            r6 = 82
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0133
            android.widget.TextView r0 = r1.f23916f
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (java.lang.Long) r12, (java.lang.String) r14)
        L_0x0133:
            return
        L_0x0134:
            r0 = move-exception
            monitor-exit(r27)     // Catch:{ all -> 0x0134 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.dh.executeBindings():void");
    }
}
