package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public final class dd extends dc implements a.C0456a {
    private static final ViewDataBinding.b E = null;
    private static final SparseIntArray F;
    private final ConstraintLayout G;
    private final View.OnClickListener H;
    private long I;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        F = sparseIntArray;
        sparseIntArray.put(R.id.discount_txt, 26);
        F.put(R.id.hop_divider, 27);
        F.put(R.id.flight_fare_rupees_text, 28);
    }

    public dd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 29, E, F));
    }

    private dd(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[5], objArr[26], objArr[1], objArr[6], objArr[2], objArr[19], objArr[18], objArr[17], objArr[4], objArr[10], objArr[9], objArr[11], objArr[28], objArr[20], objArr[15], objArr[3], objArr[27], objArr[24], objArr[7], objArr[8], objArr[12], objArr[21], objArr[25], objArr[13], objArr[14], objArr[16], objArr[22], objArr[23]);
        this.I = -1;
        this.f23893a.setTag((Object) null);
        this.f23895c.setTag((Object) null);
        this.f23896d.setTag((Object) null);
        this.f23897e.setTag((Object) null);
        this.f23898f.setTag((Object) null);
        this.f23899g.setTag((Object) null);
        this.f23900h.setTag((Object) null);
        this.f23901i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        this.r.setTag((Object) null);
        this.s.setTag((Object) null);
        this.t.setTag((Object) null);
        this.G = objArr[0];
        this.G.setTag((Object) null);
        this.u.setTag((Object) null);
        this.v.setTag((Object) null);
        this.w.setTag((Object) null);
        this.x.setTag((Object) null);
        this.y.setTag((Object) null);
        this.z.setTag((Object) null);
        this.A.setTag((Object) null);
        this.B.setTag((Object) null);
        setRootTag(view);
        this.H = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.I = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.I != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.x == i2) {
            this.C = (CJRFlightDetailsItem) obj;
            synchronized (this) {
                this.I |= 1;
            }
            notifyPropertyChanged(com.travel.flight.a.x);
            super.requestRebind();
        } else if (com.travel.flight.a.p != i2) {
            return false;
        } else {
            this.D = (SRPOneWayViewModel) obj;
            synchronized (this) {
                this.I |= 2;
            }
            notifyPropertyChanged(com.travel.flight.a.p);
            super.requestRebind();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r46 = this;
            r1 = r46
            monitor-enter(r46)
            long r2 = r1.I     // Catch:{ all -> 0x02fb }
            r4 = 0
            r1.I = r4     // Catch:{ all -> 0x02fb }
            monitor-exit(r46)     // Catch:{ all -> 0x02fb }
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r0 = r1.C
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r6 = r1.D
            r7 = 7
            long r9 = r2 & r7
            r12 = 16777216(0x1000000, double:8.289046E-317)
            r16 = 2048(0x800, double:1.0118E-320)
            r18 = 0
            r19 = 8
            r20 = 1
            r21 = 5
            r23 = 0
            int r25 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r25 == 0) goto L_0x0172
            long r9 = r2 & r21
            int r25 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r25 == 0) goto L_0x0172
            if (r0 == 0) goto L_0x0062
            java.lang.String r9 = r0.getmDepartureTime()
            java.lang.String r10 = r0.getmDestination()
            boolean r18 = r0.isStitchedAndMoreThanOneHop()
            java.lang.String r26 = r0.getmDuration()
            java.lang.String r27 = r0.getFormattedFirstHopInfo()
            int r28 = r0.getmCheapestFlightValue()
            java.lang.String r29 = r0.getmOrigin()
            int r30 = r0.getPosState()
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r31 = r0.getAdditionalInfo()
            java.util.List r32 = r0.getChildItems()
            java.util.ArrayList r33 = r0.getmFlights()
            java.lang.String r34 = r0.getmArrivalTime()
            java.lang.String r35 = r0.getFormattedSecondHopInfo()
            goto L_0x007b
        L_0x0062:
            r9 = r23
            r10 = r9
            r26 = r10
            r27 = r26
            r29 = r27
            r31 = r29
            r32 = r31
            r33 = r32
            r34 = r33
            r35 = r34
            r18 = 0
            r28 = 0
            r30 = 0
        L_0x007b:
            if (r25 == 0) goto L_0x0098
            if (r18 == 0) goto L_0x008b
            r36 = 16
            long r2 = r2 | r36
            r36 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r36
            r36 = 262144(0x40000, double:1.295163E-318)
            goto L_0x0096
        L_0x008b:
            r36 = 8
            long r2 = r2 | r36
            r36 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r36
            r36 = 131072(0x20000, double:6.47582E-319)
        L_0x0096:
            long r2 = r2 | r36
        L_0x0098:
            android.widget.TextView r7 = r1.A
            android.content.res.Resources r7 = r7.getResources()
            if (r18 == 0) goto L_0x00a3
            int r8 = com.travel.flight.R.dimen.dimen_2dp
            goto L_0x00a5
        L_0x00a3:
            int r8 = com.travel.flight.R.dimen.dimen_0dp
        L_0x00a5:
            float r7 = r7.getDimension(r8)
            android.widget.LinearLayout r8 = r1.f23895c
            android.content.res.Resources r8 = r8.getResources()
            if (r18 == 0) goto L_0x00b4
            int r11 = com.travel.flight.R.dimen.dimen_15_4dp
            goto L_0x00b6
        L_0x00b4:
            int r11 = com.travel.flight.R.dimen.dimen_11dp
        L_0x00b6:
            float r8 = r8.getDimension(r11)
            android.widget.TextView r11 = r1.f23897e
            android.content.res.Resources r11 = r11.getResources()
            if (r18 == 0) goto L_0x00c5
            int r14 = com.travel.flight.R.dimen.dimen_11sp
            goto L_0x00c7
        L_0x00c5:
            int r14 = com.travel.flight.R.dimen.dimen_14sp
        L_0x00c7:
            float r11 = r11.getDimension(r14)
            r18 = r11
            if (r32 == 0) goto L_0x00d1
            r11 = 1
            goto L_0x00d2
        L_0x00d1:
            r11 = 0
        L_0x00d2:
            long r14 = r2 & r21
            int r40 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r40 == 0) goto L_0x00e0
            if (r11 == 0) goto L_0x00dc
            long r2 = r2 | r12
            goto L_0x00e0
        L_0x00dc:
            r14 = 8388608(0x800000, double:4.144523E-317)
            long r2 = r2 | r14
        L_0x00e0:
            if (r31 == 0) goto L_0x00eb
            java.lang.String r23 = r31.getNextdayArrival()
            java.lang.String r14 = r31.getOperatingAirline()
            goto L_0x00ed
        L_0x00eb:
            r14 = r23
        L_0x00ed:
            if (r33 == 0) goto L_0x00f4
            int r15 = r33.size()
            goto L_0x00f5
        L_0x00f4:
            r15 = 0
        L_0x00f5:
            if (r23 == 0) goto L_0x00fa
            r31 = 1
            goto L_0x00fc
        L_0x00fa:
            r31 = 0
        L_0x00fc:
            if (r14 == 0) goto L_0x0101
            r33 = 1
            goto L_0x0103
        L_0x0101:
            r33 = 0
        L_0x0103:
            r12 = 2
            if (r15 != r12) goto L_0x0108
            r12 = 1
            goto L_0x0109
        L_0x0108:
            r12 = 0
        L_0x0109:
            long r42 = r2 & r21
            int r13 = (r42 > r4 ? 1 : (r42 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x011a
            if (r31 == 0) goto L_0x0115
            r42 = 4194304(0x400000, double:2.0722615E-317)
            goto L_0x0118
        L_0x0115:
            r42 = 2097152(0x200000, double:1.0361308E-317)
        L_0x0118:
            long r2 = r2 | r42
        L_0x011a:
            long r42 = r2 & r21
            int r13 = (r42 > r4 ? 1 : (r42 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0129
            if (r33 == 0) goto L_0x0125
            r42 = 64
            goto L_0x0127
        L_0x0125:
            r42 = 32
        L_0x0127:
            long r2 = r2 | r42
        L_0x0129:
            long r42 = r2 & r21
            int r13 = (r42 > r4 ? 1 : (r42 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0142
            if (r12 == 0) goto L_0x013b
            r42 = 4096(0x1000, double:2.0237E-320)
            long r2 = r2 | r42
            r42 = 65536(0x10000, double:3.2379E-319)
            long r2 = r2 | r42
            goto L_0x0142
        L_0x013b:
            long r2 = r2 | r16
            r38 = 32768(0x8000, double:1.61895E-319)
            long r2 = r2 | r38
        L_0x0142:
            if (r31 == 0) goto L_0x0146
            r13 = 0
            goto L_0x0148
        L_0x0146:
            r13 = 8
        L_0x0148:
            if (r33 == 0) goto L_0x014d
            r31 = 0
            goto L_0x014f
        L_0x014d:
            r31 = 4
        L_0x014f:
            r33 = r9
            r44 = r31
            r9 = r34
            r31 = r26
            r26 = r7
            r7 = r8
            r8 = r27
            r27 = r13
            r13 = r29
            r29 = r35
            r34 = 16777216(0x1000000, double:8.289046E-317)
            r45 = r18
            r18 = r6
            r6 = r28
            r28 = r23
            r23 = r14
            r14 = r45
            goto L_0x0194
        L_0x0172:
            r18 = r6
            r8 = r23
            r9 = r8
            r10 = r9
            r13 = r10
            r28 = r13
            r29 = r28
            r31 = r29
            r32 = r31
            r33 = r32
            r6 = 0
            r7 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r26 = 0
            r27 = 0
            r30 = 0
            r34 = 16777216(0x1000000, double:8.289046E-317)
            r44 = 0
        L_0x0194:
            long r34 = r2 & r34
            int r40 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r40 == 0) goto L_0x01a8
            if (r32 == 0) goto L_0x01a1
            int r32 = r32.size()
            goto L_0x01a3
        L_0x01a1:
            r32 = 0
        L_0x01a3:
            if (r32 <= 0) goto L_0x01a8
            r32 = 1
            goto L_0x01aa
        L_0x01a8:
            r32 = 0
        L_0x01aa:
            r34 = 34816(0x8800, double:1.72014E-319)
            long r34 = r2 & r34
            int r40 = (r34 > r4 ? 1 : (r34 == r4 ? 0 : -1))
            if (r40 == 0) goto L_0x01ff
            r4 = 3
            if (r15 != r4) goto L_0x01b7
            goto L_0x01b9
        L_0x01b7:
            r20 = 0
        L_0x01b9:
            long r4 = r2 & r16
            r34 = 0
            int r15 = (r4 > r34 ? 1 : (r4 == r34 ? 0 : -1))
            if (r15 == 0) goto L_0x01c9
            if (r20 == 0) goto L_0x01c6
            r4 = 16384(0x4000, double:8.0948E-320)
            goto L_0x01c8
        L_0x01c6:
            r4 = 8192(0x2000, double:4.0474E-320)
        L_0x01c8:
            long r2 = r2 | r4
        L_0x01c9:
            r4 = 32768(0x8000, double:1.61895E-319)
            long r40 = r2 & r4
            int r4 = (r40 > r34 ? 1 : (r40 == r34 ? 0 : -1))
            if (r4 == 0) goto L_0x01dc
            if (r20 == 0) goto L_0x01d8
            r4 = 1048576(0x100000, double:5.180654E-318)
            goto L_0x01db
        L_0x01d8:
            r4 = 524288(0x80000, double:2.590327E-318)
        L_0x01db:
            long r2 = r2 | r4
        L_0x01dc:
            long r4 = r2 & r16
            int r15 = (r4 > r34 ? 1 : (r4 == r34 ? 0 : -1))
            if (r15 == 0) goto L_0x01ed
            if (r20 == 0) goto L_0x01e7
            r24 = 4
            goto L_0x01e9
        L_0x01e7:
            r24 = 8
        L_0x01e9:
            r4 = 32768(0x8000, double:1.61895E-319)
            goto L_0x01f2
        L_0x01ed:
            r4 = 32768(0x8000, double:1.61895E-319)
            r24 = 0
        L_0x01f2:
            long r4 = r4 & r2
            int r15 = (r4 > r34 ? 1 : (r4 == r34 ? 0 : -1))
            if (r15 == 0) goto L_0x01fd
            if (r20 == 0) goto L_0x01fa
            goto L_0x01fd
        L_0x01fa:
            r4 = 8
            goto L_0x0204
        L_0x01fd:
            r4 = 0
            goto L_0x0204
        L_0x01ff:
            r34 = r4
            r4 = 0
            r24 = 0
        L_0x0204:
            long r15 = r2 & r21
            int r5 = (r15 > r34 ? 1 : (r15 == r34 ? 0 : -1))
            if (r5 == 0) goto L_0x022b
            if (r12 == 0) goto L_0x020e
            r24 = 0
        L_0x020e:
            if (r12 == 0) goto L_0x0212
            r4 = 8
        L_0x0212:
            if (r11 == 0) goto L_0x0215
            goto L_0x0217
        L_0x0215:
            r32 = 0
        L_0x0217:
            if (r5 == 0) goto L_0x0221
            if (r32 == 0) goto L_0x021e
            r11 = 256(0x100, double:1.265E-321)
            goto L_0x0220
        L_0x021e:
            r11 = 128(0x80, double:6.32E-322)
        L_0x0220:
            long r2 = r2 | r11
        L_0x0221:
            if (r32 == 0) goto L_0x0225
            r11 = 0
            goto L_0x0227
        L_0x0225:
            r11 = 8
        L_0x0227:
            r5 = r4
            r4 = r24
            goto L_0x022e
        L_0x022b:
            r4 = 0
            r5 = 0
            r11 = 0
        L_0x022e:
            long r15 = r2 & r21
            r19 = 0
            int r12 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r12 == 0) goto L_0x02dc
            android.widget.LinearLayout r12 = r1.f23893a
            com.travel.flight.flightSRPV2.c.c.a((android.widget.LinearLayout) r12, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            android.widget.LinearLayout r12 = r1.f23895c
            androidx.databinding.a.e.a((android.view.View) r12, (float) r7)
            android.widget.ImageView r7 = r1.f23896d
            com.travel.flight.flightSRPV2.c.c.d((android.widget.ImageView) r7, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            android.widget.TextView r7 = r1.f23897e
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r8)
            android.widget.TextView r7 = r1.f23897e
            r8 = 0
            r7.setTextSize(r8, r14)
            android.widget.ImageView r7 = r1.f23898f
            com.travel.flight.flightSRPV2.c.c.a((android.widget.ImageView) r7, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            android.widget.TextView r7 = r1.f23899g
            androidx.databinding.a.d.a((android.widget.TextView) r7, (java.lang.CharSequence) r10)
            android.widget.TextView r7 = r1.f23900h
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r7, (java.lang.String) r9)
            android.widget.TextView r7 = r1.f23901i
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r7, (int) r6)
            android.widget.TextView r6 = r1.j
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r13)
            android.widget.TextView r6 = r1.k
            r9 = r33
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r6, (java.lang.String) r9)
            android.widget.TextView r6 = r1.l
            r7 = r31
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r7)
            android.widget.TextView r6 = r1.n
            com.travel.flight.flightSRPV2.c.c.d((android.widget.TextView) r6, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            android.widget.TextView r6 = r1.o
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r6, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            android.widget.TextView r6 = r1.p
            r7 = r29
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r7)
            android.widget.ImageView r6 = r1.r
            r6.setVisibility(r11)
            android.widget.ImageView r6 = r1.s
            com.travel.flight.flightSRPV2.c.c.b((android.widget.ImageView) r6, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            android.widget.ImageView r6 = r1.t
            com.travel.flight.flightSRPV2.c.c.c((android.widget.ImageView) r6, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            androidx.constraintlayout.widget.ConstraintLayout r6 = r1.G
            java.lang.Integer r7 = java.lang.Integer.valueOf(r30)
            com.travel.flight.flightSRPV2.c.c.a((android.view.View) r6, (java.lang.Integer) r7)
            android.view.View r6 = r1.u
            r6.setVisibility(r4)
            android.widget.TextView r4 = r1.v
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r4, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0)
            android.view.View r4 = r1.x
            r4.setVisibility(r5)
            android.view.View r4 = r1.y
            r4.setVisibility(r5)
            android.widget.TextView r4 = r1.z
            r5 = r28
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r5)
            android.widget.TextView r4 = r1.z
            r13 = r27
            r4.setVisibility(r13)
            android.widget.TextView r4 = r1.A
            r7 = r26
            androidx.databinding.a.e.a((android.view.View) r4, (float) r7)
            android.widget.TextView r4 = r1.A
            r14 = r23
            androidx.databinding.a.d.a((android.widget.TextView) r4, (java.lang.CharSequence) r14)
            android.widget.TextView r4 = r1.A
            r5 = r44
            r4.setVisibility(r5)
            android.widget.TextView r4 = r1.B
            r4.setVisibility(r11)
        L_0x02dc:
            r4 = 4
            long r4 = r4 & r2
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x02ec
            androidx.constraintlayout.widget.ConstraintLayout r4 = r1.G
            android.view.View$OnClickListener r5 = r1.H
            r4.setOnClickListener(r5)
        L_0x02ec:
            r4 = 7
            long r2 = r2 & r4
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x02fa
            android.widget.TextView r2 = r1.w
            r3 = r18
            com.travel.flight.flightSRPV2.c.c.a((android.widget.TextView) r2, (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r0, (com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel) r3)
        L_0x02fa:
            return
        L_0x02fb:
            r0 = move-exception
            monitor-exit(r46)     // Catch:{ all -> 0x02fb }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.dd.executeBindings():void");
    }

    public final void a(int i2, View view) {
        SRPOneWayViewModel sRPOneWayViewModel = this.D;
        CJRFlightDetailsItem cJRFlightDetailsItem = this.C;
        if (sRPOneWayViewModel != null) {
            sRPOneWayViewModel.onFlightItemClick(cJRFlightDetailsItem);
        }
    }
}
