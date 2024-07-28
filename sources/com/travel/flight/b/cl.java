package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.model.CalendarDatePriceInfo;

public final class cl extends ck implements a.C0456a {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f23820g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f23821h = null;

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f23822i;
    private final View.OnClickListener j;
    private long k;

    public cl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f23820g, f23821h));
    }

    private cl(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[4], objArr[1], objArr[2]);
        this.k = -1;
        this.f23814a.setTag((Object) null);
        this.f23822i = objArr[0];
        this.f23822i.setTag((Object) null);
        this.f23815b.setTag((Object) null);
        this.f23816c.setTag((Object) null);
        this.f23817d.setTag((Object) null);
        setRootTag(view);
        this.j = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.k != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.r == i2) {
            a((CalendarDatePriceInfo) obj);
        } else if (com.travel.flight.a.j != i2) {
            return false;
        } else {
            a((SRPSharedViewModel) obj);
        }
        return true;
    }

    public final void a(CalendarDatePriceInfo calendarDatePriceInfo) {
        this.f23818e = calendarDatePriceInfo;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(com.travel.flight.a.r);
        super.requestRebind();
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.f23819f = sRPSharedViewModel;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(com.travel.flight.a.j);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r23 = this;
            r1 = r23
            monitor-enter(r23)
            long r2 = r1.k     // Catch:{ all -> 0x0134 }
            r4 = 0
            r1.k = r4     // Catch:{ all -> 0x0134 }
            monitor-exit(r23)     // Catch:{ all -> 0x0134 }
            com.travel.model.CalendarDatePriceInfo r0 = r1.f23818e
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r6 = r1.f23819f
            r7 = 15
            long r9 = r2 & r7
            r12 = 16384(0x4000, double:8.0948E-320)
            r15 = 10
            r17 = 0
            r11 = 0
            int r19 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r19 == 0) goto L_0x00c1
            if (r0 == 0) goto L_0x0024
            java.lang.String r9 = r0.getDate()
            goto L_0x0026
        L_0x0024:
            r9 = r17
        L_0x0026:
            if (r6 == 0) goto L_0x002d
            androidx.lifecycle.y r6 = r6.getSelectedOnwardDate()
            goto L_0x002f
        L_0x002d:
            r6 = r17
        L_0x002f:
            r1.updateLiveDataRegistration(r11, r6)
            if (r6 == 0) goto L_0x003c
            java.lang.Object r6 = r6.getValue()
            r17 = r6
            java.lang.String r17 = (java.lang.String) r17
        L_0x003c:
            r6 = r17
            if (r9 == 0) goto L_0x0045
            boolean r6 = r9.equalsIgnoreCase(r6)
            goto L_0x0046
        L_0x0045:
            r6 = 0
        L_0x0046:
            if (r19 == 0) goto L_0x0069
            if (r6 == 0) goto L_0x0059
            r19 = 32
            long r2 = r2 | r19
            r19 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r19
            r19 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r19
            r19 = 8192(0x2000, double:4.0474E-320)
            goto L_0x0067
        L_0x0059:
            r19 = 16
            long r2 = r2 | r19
            r19 = 64
            long r2 = r2 | r19
            r19 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r19
            r19 = 4096(0x1000, double:2.0237E-320)
        L_0x0067:
            long r2 = r2 | r19
        L_0x0069:
            com.paytm.utility.RoboTextView r10 = r1.f23816c
            if (r6 == 0) goto L_0x0070
            int r11 = com.travel.flight.R.color.color_000000
            goto L_0x0072
        L_0x0070:
            int r11 = com.travel.flight.R.color.color_c1c1c1
        L_0x0072:
            int r10 = getColorFromResource(r10, r11)
            r11 = r10
            if (r6 == 0) goto L_0x007b
            r10 = 0
            goto L_0x007d
        L_0x007b:
            r10 = 8
        L_0x007d:
            if (r6 == 0) goto L_0x0088
            com.paytm.utility.RoboTextView r14 = r1.f23817d
            int r7 = com.travel.flight.R.color.color_000000
            int r7 = getColorFromResource(r14, r7)
            goto L_0x0090
        L_0x0088:
            com.paytm.utility.RoboTextView r7 = r1.f23817d
            int r8 = com.travel.flight.R.color.color_c1c1c1
            int r7 = getColorFromResource(r7, r8)
        L_0x0090:
            if (r6 == 0) goto L_0x0097
            android.widget.TextView r6 = r1.f23814a
            int r8 = com.travel.flight.R.color.color_000000
            goto L_0x009b
        L_0x0097:
            android.widget.TextView r6 = r1.f23814a
            int r8 = com.travel.flight.R.color.color_c1c1c1
        L_0x009b:
            int r6 = getColorFromResource(r6, r8)
            long r21 = r2 & r15
            int r8 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00bf
            if (r0 == 0) goto L_0x00ac
            int r0 = r0.getFare()
            goto L_0x00ad
        L_0x00ac:
            r0 = 0
        L_0x00ad:
            r14 = -1
            if (r0 != r14) goto L_0x00b2
            r14 = 1
            goto L_0x00b3
        L_0x00b2:
            r14 = 0
        L_0x00b3:
            if (r8 == 0) goto L_0x00c9
            if (r14 == 0) goto L_0x00bd
            r21 = 32768(0x8000, double:1.61895E-319)
            long r2 = r2 | r21
            goto L_0x00c9
        L_0x00bd:
            long r2 = r2 | r12
            goto L_0x00c9
        L_0x00bf:
            r0 = 0
            goto L_0x00c8
        L_0x00c1:
            r9 = r17
            r0 = 0
            r6 = 0
            r7 = 0
            r10 = 0
            r11 = 0
        L_0x00c8:
            r14 = 0
        L_0x00c9:
            long r12 = r12 & r2
            int r8 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00d2
            if (r0 != 0) goto L_0x00d2
            r8 = 1
            goto L_0x00d3
        L_0x00d2:
            r8 = 0
        L_0x00d3:
            long r12 = r2 & r15
            int r17 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x00f4
            if (r14 == 0) goto L_0x00de
            r20 = 1
            goto L_0x00e0
        L_0x00de:
            r20 = r8
        L_0x00e0:
            if (r17 == 0) goto L_0x00ea
            if (r20 == 0) goto L_0x00e7
            r12 = 2048(0x800, double:1.0118E-320)
            goto L_0x00e9
        L_0x00e7:
            r12 = 1024(0x400, double:5.06E-321)
        L_0x00e9:
            long r2 = r2 | r12
        L_0x00ea:
            if (r20 == 0) goto L_0x00ef
            r18 = 8
            goto L_0x00f1
        L_0x00ef:
            r18 = 0
        L_0x00f1:
            r8 = r18
            goto L_0x00f5
        L_0x00f4:
            r8 = 0
        L_0x00f5:
            long r12 = r2 & r15
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x010a
            android.widget.TextView r12 = r1.f23814a
            r12.setVisibility(r8)
            com.paytm.utility.RoboTextView r8 = r1.f23816c
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r8, (java.lang.String) r9)
            com.paytm.utility.RoboTextView r8 = r1.f23817d
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r8, (int) r0)
        L_0x010a:
            r8 = 15
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0125
            android.widget.TextView r0 = r1.f23814a
            r0.setTextColor(r6)
            android.view.View r0 = r1.f23815b
            r0.setVisibility(r10)
            com.paytm.utility.RoboTextView r0 = r1.f23816c
            r0.setTextColor(r11)
            com.paytm.utility.RoboTextView r0 = r1.f23817d
            r0.setTextColor(r7)
        L_0x0125:
            r6 = 8
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0133
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.f23822i
            android.view.View$OnClickListener r2 = r1.j
            r0.setOnClickListener(r2)
        L_0x0133:
            return
        L_0x0134:
            r0 = move-exception
            monitor-exit(r23)     // Catch:{ all -> 0x0134 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.cl.executeBindings():void");
    }

    public final void a(int i2, View view) {
        CalendarDatePriceInfo calendarDatePriceInfo = this.f23818e;
        SRPSharedViewModel sRPSharedViewModel = this.f23819f;
        boolean z = true;
        if (sRPSharedViewModel != null) {
            if (calendarDatePriceInfo == null) {
                z = false;
            }
            if (z) {
                sRPSharedViewModel.onOnwardDateChange(getRoot().getContext(), calendarDatePriceInfo.getDate());
            }
        }
    }
}
