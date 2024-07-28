package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public final class az extends ay implements a.C0456a {
    private static final ViewDataBinding.b y = null;
    private static final SparseIntArray z;
    private final ConstraintLayout A;
    private final View.OnClickListener B;
    private long C;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R.id.hop_devider, 18);
        z.put(R.id.meals_or_baggage_img, 19);
        z.put(R.id.flight_fare_rupees_text, 20);
    }

    public az(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 21, y, z));
    }

    private az(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[13], objArr[20], objArr[18], objArr[2], objArr[19], objArr[9], objArr[16], objArr[17], objArr[6], objArr[8], objArr[10], objArr[4], objArr[3], objArr[7], objArr[12], objArr[14], objArr[11], objArr[15], objArr[5]);
        this.C = -1;
        this.f23654a.setTag((Object) null);
        this.f23655b.setTag((Object) null);
        this.f23658e.setTag((Object) null);
        this.A = objArr[0];
        this.A.setTag((Object) null);
        this.f23660g.setTag((Object) null);
        this.f23661h.setTag((Object) null);
        this.f23662i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        this.q.setTag((Object) null);
        this.r.setTag((Object) null);
        this.s.setTag((Object) null);
        this.t.setTag((Object) null);
        setRootTag(view);
        this.B = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.C = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.C != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.x == i2) {
            this.u = (CJRFlightDetailsItem) obj;
            synchronized (this) {
                this.C |= 1;
            }
            notifyPropertyChanged(com.travel.flight.a.x);
            super.requestRebind();
        } else if (com.travel.flight.a.f23485i == i2) {
            this.w = (Boolean) obj;
            synchronized (this) {
                this.C |= 2;
            }
            notifyPropertyChanged(com.travel.flight.a.f23485i);
            super.requestRebind();
        } else if (com.travel.flight.a.f23480d == i2) {
            this.x = (Integer) obj;
            synchronized (this) {
                this.C |= 4;
            }
            notifyPropertyChanged(com.travel.flight.a.f23480d);
            super.requestRebind();
        } else if (com.travel.flight.a.f23479c != i2) {
            return false;
        } else {
            this.v = (DRTListViewModel) obj;
            synchronized (this) {
                this.C |= 8;
            }
            notifyPropertyChanged(com.travel.flight.a.f23479c);
            super.requestRebind();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r35 = this;
            r1 = r35
            monitor-enter(r35)
            long r2 = r1.C     // Catch:{ all -> 0x01d8 }
            r4 = 0
            r1.C = r4     // Catch:{ all -> 0x01d8 }
            monitor-exit(r35)     // Catch:{ all -> 0x01d8 }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r1.u
            java.lang.Boolean r6 = r1.w
            r7 = 17
            long r9 = r2 & r7
            r12 = 2048(0x800, double:1.0118E-320)
            r14 = 512(0x200, double:2.53E-321)
            r16 = 0
            r17 = 0
            int r18 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0093
            if (r0 == 0) goto L_0x0054
            java.lang.String r16 = r0.getmDepartureTime()
            java.lang.String r9 = r0.getmDestination()
            java.lang.String r10 = r0.getmDuration()
            boolean r19 = r0.isSelected()
            int r20 = r0.getmCheapestFlightValue()
            java.lang.String r21 = r0.getmOrigin()
            java.lang.String r22 = r0.getRefundbaleName()
            java.lang.String r23 = r0.getmAirLine()
            java.util.ArrayList r24 = r0.getmFlights()
            java.lang.String r25 = r0.getmArrivalTime()
            r34 = r10
            r10 = r9
            r9 = r16
            r16 = r24
            r24 = r19
            r19 = r34
            goto L_0x0065
        L_0x0054:
            r9 = r16
            r10 = r9
            r19 = r10
            r21 = r19
            r22 = r21
            r23 = r22
            r25 = r23
            r20 = 0
            r24 = 0
        L_0x0065:
            if (r16 == 0) goto L_0x006e
            int r16 = r16.size()
            r11 = r16
            goto L_0x006f
        L_0x006e:
            r11 = 0
        L_0x006f:
            r7 = 2
            if (r11 != r7) goto L_0x0074
            r7 = 1
            goto L_0x0075
        L_0x0074:
            r7 = 0
        L_0x0075:
            if (r18 == 0) goto L_0x0084
            if (r7 == 0) goto L_0x0082
            r27 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r27
            r27 = 4096(0x1000, double:2.0237E-320)
            long r2 = r2 | r27
            goto L_0x0084
        L_0x0082:
            long r2 = r2 | r14
            long r2 = r2 | r12
        L_0x0084:
            r16 = r7
            r8 = r19
            r7 = r20
            r29 = r21
            r30 = r22
            r31 = r23
            r32 = r25
            goto L_0x00a5
        L_0x0093:
            r8 = r16
            r9 = r8
            r10 = r9
            r29 = r10
            r30 = r29
            r31 = r30
            r32 = r31
            r7 = 0
            r11 = 0
            r16 = 0
            r24 = 0
        L_0x00a5:
            r18 = 18
            long r20 = r2 & r18
            r22 = 8
            int r23 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x00d6
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r23 == 0) goto L_0x00c6
            if (r6 == 0) goto L_0x00be
            r20 = 64
            long r2 = r2 | r20
            r20 = 256(0x100, double:1.265E-321)
            goto L_0x00c4
        L_0x00be:
            r20 = 32
            long r2 = r2 | r20
            r20 = 128(0x80, double:6.32E-322)
        L_0x00c4:
            long r2 = r2 | r20
        L_0x00c6:
            if (r6 == 0) goto L_0x00cb
            r20 = 8
            goto L_0x00cd
        L_0x00cb:
            r20 = 0
        L_0x00cd:
            if (r6 == 0) goto L_0x00d1
            r6 = 0
            goto L_0x00d3
        L_0x00d1:
            r6 = 8
        L_0x00d3:
            r33 = r20
            goto L_0x00d9
        L_0x00d6:
            r6 = 0
            r33 = 0
        L_0x00d9:
            r20 = 2560(0xa00, double:1.265E-320)
            long r20 = r2 & r20
            int r23 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x0124
            r12 = 3
            if (r11 != r12) goto L_0x00e7
            r26 = 1
            goto L_0x00e9
        L_0x00e7:
            r26 = 0
        L_0x00e9:
            long r11 = r2 & r14
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00f7
            if (r26 == 0) goto L_0x00f4
            r11 = 16384(0x4000, double:8.0948E-320)
            goto L_0x00f6
        L_0x00f4:
            r11 = 8192(0x2000, double:4.0474E-320)
        L_0x00f6:
            long r2 = r2 | r11
        L_0x00f7:
            r11 = 2048(0x800, double:1.0118E-320)
            long r27 = r2 & r11
            int r11 = (r27 > r4 ? 1 : (r27 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0109
            if (r26 == 0) goto L_0x0105
            r11 = 65536(0x10000, double:3.2379E-319)
            goto L_0x0108
        L_0x0105:
            r11 = 32768(0x8000, double:1.61895E-319)
        L_0x0108:
            long r2 = r2 | r11
        L_0x0109:
            long r11 = r2 & r14
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0116
            if (r26 == 0) goto L_0x0113
            r11 = 4
            goto L_0x0117
        L_0x0113:
            r11 = 8
            goto L_0x0117
        L_0x0116:
            r11 = 0
        L_0x0117:
            r12 = 2048(0x800, double:1.0118E-320)
            long r12 = r12 & r2
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0125
            if (r26 == 0) goto L_0x0121
            goto L_0x0125
        L_0x0121:
            r12 = 8
            goto L_0x0126
        L_0x0124:
            r11 = 0
        L_0x0125:
            r12 = 0
        L_0x0126:
            r13 = 17
            long r13 = r13 & r2
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x013c
            if (r16 == 0) goto L_0x0130
            goto L_0x0132
        L_0x0130:
            r17 = r11
        L_0x0132:
            if (r16 == 0) goto L_0x0135
            goto L_0x0137
        L_0x0135:
            r22 = r12
        L_0x0137:
            r11 = r17
            r12 = r22
            goto L_0x013e
        L_0x013c:
            r11 = 0
            r12 = 0
        L_0x013e:
            if (r15 == 0) goto L_0x01b7
            com.paytm.utility.RoboTextView r13 = r1.f23654a
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r13, (int) r7)
            com.paytm.utility.RoboTextView r7 = r1.f23655b
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r10)
            android.widget.ImageView r7 = r1.f23658e
            com.travel.flight.flightSRPV2.c.c.d((android.widget.ImageView) r7, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            androidx.constraintlayout.widget.ConstraintLayout r7 = r1.A
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r24)
            com.travel.flight.flightSRPV2.c.c.a((androidx.constraintlayout.widget.ConstraintLayout) r7, (java.lang.Boolean) r10)
            android.view.View r7 = r1.f23660g
            r7.setVisibility(r11)
            android.view.View r7 = r1.f23660g
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r24)
            com.travel.flight.flightSRPV2.c.c.a((android.view.View) r7, (java.lang.Boolean) r10)
            com.paytm.utility.RoboTextView r7 = r1.j
            r10 = r29
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r10)
            android.view.View r7 = r1.k
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r24)
            com.travel.flight.flightSRPV2.c.c.a((android.view.View) r7, (java.lang.Boolean) r10)
            android.view.View r7 = r1.k
            r7.setVisibility(r12)
            android.view.View r7 = r1.l
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r24)
            com.travel.flight.flightSRPV2.c.c.a((android.view.View) r7, (java.lang.Boolean) r10)
            android.view.View r7 = r1.l
            r7.setVisibility(r12)
            com.paytm.utility.RoboTextView r7 = r1.m
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setAirlineCode(r7, r0)
            com.paytm.utility.RoboTextView r7 = r1.n
            r10 = r31
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r10)
            com.paytm.utility.RoboTextView r7 = r1.o
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r8)
            com.paytm.utility.RoboTextView r7 = r1.p
            r8 = r32
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r7, (java.lang.String) r8)
            com.paytm.utility.RoboTextView r7 = r1.q
            com.travel.flight.flightSRPV2.c.c.c((android.widget.TextView) r7, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            com.paytm.utility.RoboTextView r7 = r1.r
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r7, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            com.paytm.utility.RoboTextView r0 = r1.s
            r7 = r30
            androidx.databinding.a.d.a((android.widget.TextView) r0, (java.lang.CharSequence) r7)
            com.paytm.utility.RoboTextView r0 = r1.t
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r0, (java.lang.String) r9)
        L_0x01b7:
            r7 = 16
            long r7 = r7 & r2
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01c5
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.A
            android.view.View$OnClickListener r7 = r1.B
            r0.setOnClickListener(r7)
        L_0x01c5:
            long r2 = r2 & r18
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01d7
            android.view.View r0 = r1.f23661h
            r0.setVisibility(r6)
            android.view.View r0 = r1.f23662i
            r2 = r33
            r0.setVisibility(r2)
        L_0x01d7:
            return
        L_0x01d8:
            r0 = move-exception
            monitor-exit(r35)     // Catch:{ all -> 0x01d8 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.az.executeBindings():void");
    }

    public final void a(int i2, View view) {
        CJRFlightDetailsItem cJRFlightDetailsItem = this.u;
        Integer num = this.x;
        Boolean bool = this.w;
        DRTListViewModel dRTListViewModel = this.v;
        if (dRTListViewModel != null) {
            dRTListViewModel.onParentItemClick(cJRFlightDetailsItem, num.intValue(), bool.booleanValue(), true, true);
        }
    }
}
