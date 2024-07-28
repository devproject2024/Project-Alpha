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

public final class df extends de {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l;
    private final ConstraintLayout m;
    private long n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.text_view_price_start_rupee, 7);
        l.put(R.id.text_view_price_end_rupee, 8);
    }

    public df(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, k, l));
    }

    private df(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[1], objArr[2], objArr[3], objArr[5], objArr[4], objArr[8], objArr[7]);
        this.n = -1;
        this.f23902a.setTag((Object) null);
        this.f23903b.setTag((Object) null);
        this.f23904c.setTag((Object) null);
        this.f23905d.setTag((Object) null);
        this.m = objArr[0];
        this.m.setTag((Object) null);
        this.f23906e.setTag((Object) null);
        this.f23907f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.n = 32;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.x == i2) {
            this.f23910i = (CJRFlightDetailsItem) obj;
            synchronized (this) {
                this.n |= 8;
            }
            notifyPropertyChanged(a.x);
            super.requestRebind();
        } else if (a.p != i2) {
            return false;
        } else {
            this.j = (SRPOneWayViewModel) obj;
            synchronized (this) {
                this.n |= 16;
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
            this.n |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.n     // Catch:{ all -> 0x0127 }
            r4 = 0
            r1.n = r4     // Catch:{ all -> 0x0127 }
            monitor-exit(r22)     // Catch:{ all -> 0x0127 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r1.f23910i
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r6 = r1.j
            r7 = 63
            long r7 = r7 & r2
            r11 = 42
            r13 = 44
            r15 = 41
            r9 = 0
            int r17 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x00c5
            long r7 = r2 & r15
            int r17 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0042
            if (r0 == 0) goto L_0x0029
            androidx.databinding.i r7 = r0.getFilterSelectedMaxValue()
            goto L_0x002a
        L_0x0029:
            r7 = 0
        L_0x002a:
            r1.updateRegistration((int) r9, (androidx.databinding.h) r7)
            if (r7 == 0) goto L_0x0034
            java.lang.Object r7 = r7.get()
            goto L_0x0035
        L_0x0034:
            r7 = 0
        L_0x0035:
            if (r7 == 0) goto L_0x003c
            java.lang.Integer r7 = (java.lang.Integer) r7
            java.lang.Integer r7 = (java.lang.Integer) r7
            goto L_0x003d
        L_0x003c:
            r7 = 0
        L_0x003d:
            int r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r7)
            goto L_0x0043
        L_0x0042:
            r7 = 0
        L_0x0043:
            long r17 = r2 & r11
            int r8 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x006b
            if (r0 == 0) goto L_0x0050
            androidx.databinding.i r8 = r0.getFilterSelectedMinValue()
            goto L_0x0051
        L_0x0050:
            r8 = 0
        L_0x0051:
            r9 = 1
            r1.updateRegistration((int) r9, (androidx.databinding.h) r8)
            if (r8 == 0) goto L_0x005c
            java.lang.Object r8 = r8.get()
            goto L_0x005d
        L_0x005c:
            r8 = 0
        L_0x005d:
            if (r8 == 0) goto L_0x0064
            java.lang.Integer r8 = (java.lang.Integer) r8
            java.lang.Integer r8 = (java.lang.Integer) r8
            goto L_0x0065
        L_0x0064:
            r8 = 0
        L_0x0065:
            int r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r8)
            r9 = r8
            goto L_0x006c
        L_0x006b:
            r9 = 0
        L_0x006c:
            long r18 = r2 & r13
            int r8 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x009e
            if (r0 == 0) goto L_0x007b
            androidx.databinding.i r18 = r0.getIsFilterRangeChanged()
            r10 = r18
            goto L_0x007c
        L_0x007b:
            r10 = 0
        L_0x007c:
            r11 = 2
            r1.updateRegistration((int) r11, (androidx.databinding.h) r10)
            if (r10 == 0) goto L_0x0089
            java.lang.Object r10 = r10.get()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto L_0x008a
        L_0x0089:
            r10 = 0
        L_0x008a:
            boolean r10 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r10)
            if (r8 == 0) goto L_0x0098
            if (r10 == 0) goto L_0x0095
            r11 = 128(0x80, double:6.32E-322)
            goto L_0x0097
        L_0x0095:
            r11 = 64
        L_0x0097:
            long r2 = r2 | r11
        L_0x0098:
            if (r10 == 0) goto L_0x009b
            goto L_0x009e
        L_0x009b:
            r8 = 8
            goto L_0x009f
        L_0x009e:
            r8 = 0
        L_0x009f:
            r10 = 40
            long r20 = r2 & r10
            int r10 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00c8
            if (r0 == 0) goto L_0x00b4
            com.travel.flight.pojo.flightticket.CJRFilterAndBannerInfoItem r10 = r0.getmListItemData()
            int r11 = r0.getPosState()
            r17 = r11
            goto L_0x00b7
        L_0x00b4:
            r10 = 0
            r17 = 0
        L_0x00b7:
            if (r10 == 0) goto L_0x00c2
            java.lang.String r11 = r10.getmHeading()
            java.lang.String r10 = r10.getmText()
            goto L_0x00cc
        L_0x00c2:
            r10 = 0
            r11 = 0
            goto L_0x00cc
        L_0x00c5:
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x00c8:
            r10 = 0
            r11 = 0
            r17 = 0
        L_0x00cc:
            r20 = 56
            long r20 = r2 & r20
            int r12 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00dd
            if (r6 == 0) goto L_0x00dd
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r18 = r6.getParentViewModel()
            r15 = r18
            goto L_0x00de
        L_0x00dd:
            r15 = 0
        L_0x00de:
            long r13 = r13 & r2
            int r16 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00e8
            android.widget.TextView r13 = r1.f23902a
            r13.setVisibility(r8)
        L_0x00e8:
            if (r12 == 0) goto L_0x00f4
            android.widget.TextView r8 = r1.f23902a
            com.travel.flight.flightSRPV2.c.c.b((android.view.View) r8, (com.travel.flight.flightSRPV2.a.z) r15, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            android.widget.FrameLayout r8 = r1.f23905d
            com.travel.flight.flightSRPV2.c.c.a((android.view.ViewGroup) r8, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0, (com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel) r6)
        L_0x00f4:
            r12 = 40
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x010e
            android.widget.TextView r0 = r1.f23903b
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r11)
            android.widget.TextView r0 = r1.f23904c
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r10)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.m
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)
            com.travel.flight.flightSRPV2.c.c.a((android.view.View) r0, (java.lang.Integer) r6)
        L_0x010e:
            r10 = 41
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x011a
            android.widget.TextView r0 = r1.f23906e
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r7)
        L_0x011a:
            r6 = 42
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0126
            android.widget.TextView r0 = r1.f23907f
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r0, (int) r9)
        L_0x0126:
            return
        L_0x0127:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x0127 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.df.executeBindings():void");
    }
}
