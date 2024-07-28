package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.IRTViewModel;
import com.travel.flight.pojo.flightticket.CJRIntlFlightList;

public final class bb extends ba implements a.C0456a {
    private static final ViewDataBinding.b P = null;
    private static final SparseIntArray Q;
    private final View.OnClickListener R;
    private long S;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Q = sparseIntArray;
        sparseIntArray.put(R.id.flight_fare_rupees_text, 31);
        Q.put(R.id.devider_view, 32);
        Q.put(R.id.onward_journey_lyt, 33);
        Q.put(R.id.hop_divider_onward, 34);
        Q.put(R.id.stop_view_container, 35);
        Q.put(R.id.return_journey_lyt, 36);
        Q.put(R.id.hop_devider, 37);
        Q.put(R.id.return_stop_view_container, 38);
    }

    public bb(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 39, P, Q));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bb(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[29], objArr[32], objArr[18], objArr[9], objArr[31], objArr[3], objArr[13], objArr[30], objArr[4], objArr[37], objArr[34], objArr[11], objArr[5], objArr[16], objArr[14], objArr[8], objArr[7], objArr[6], objArr[15], objArr[33], objArr[1], objArr[17], objArr[28], objArr[26], objArr[20], objArr[19], objArr[21], objArr[25], objArr[27], objArr[36], objArr[23], objArr[38], objArr[22], objArr[24], objArr[0], objArr[35], objArr[10], objArr[12]);
        this.S = -1;
        this.f23663a.setTag((Object) null);
        this.f23664b.setTag((Object) null);
        this.f23666d.setTag((Object) null);
        this.f23667e.setTag((Object) null);
        this.f23669g.setTag((Object) null);
        this.f23670h.setTag((Object) null);
        this.f23671i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        this.q.setTag((Object) null);
        this.r.setTag((Object) null);
        this.s.setTag((Object) null);
        this.t.setTag((Object) null);
        this.v.setTag((Object) null);
        this.w.setTag((Object) null);
        this.x.setTag((Object) null);
        this.y.setTag((Object) null);
        this.z.setTag((Object) null);
        this.A.setTag((Object) null);
        this.B.setTag((Object) null);
        this.C.setTag((Object) null);
        this.D.setTag((Object) null);
        this.F.setTag((Object) null);
        this.H.setTag((Object) null);
        this.I.setTag((Object) null);
        this.J.setTag((Object) null);
        this.L.setTag((Object) null);
        this.M.setTag((Object) null);
        setRootTag(view);
        this.R = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.S = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.S != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.x == i2) {
            this.N = (CJRIntlFlightList) obj;
            synchronized (this) {
                this.S |= 2;
            }
            notifyPropertyChanged(com.travel.flight.a.x);
            super.requestRebind();
        } else if (com.travel.flight.a.K != i2) {
            return false;
        } else {
            this.O = (IRTViewModel) obj;
            synchronized (this) {
                this.S |= 4;
            }
            notifyPropertyChanged(com.travel.flight.a.K);
            super.requestRebind();
        }
        return true;
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
            this.S |= 1;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.S     // Catch:{ all -> 0x0178 }
            r4 = 0
            r1.S = r4     // Catch:{ all -> 0x0178 }
            monitor-exit(r25)     // Catch:{ all -> 0x0178 }
            com.travel.flight.pojo.flightticket.CJRIntlFlightList r0 = r1.N
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel r6 = r1.O
            r7 = 15
            long r7 = r7 & r2
            r9 = 10
            int r12 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x00bb
            long r7 = r2 & r9
            int r13 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x006c
            if (r0 == 0) goto L_0x0028
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r7 = r0.getmReturnFlights()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r8 = r0.getmOnwardFlights()
            goto L_0x002a
        L_0x0028:
            r7 = 0
            r8 = 0
        L_0x002a:
            if (r7 == 0) goto L_0x003d
            java.lang.String r13 = r7.getmArrivalTime()
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r14 = r7.getAdditionalInfo()
            java.lang.String r15 = r7.getmDuration()
            java.lang.String r16 = r7.getmDepartureTime()
            goto L_0x0042
        L_0x003d:
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x0042:
            if (r8 == 0) goto L_0x0055
            java.lang.String r17 = r8.getmArrivalTime()
            java.lang.String r18 = r8.getmDuration()
            java.lang.String r19 = r8.getmDepartureTime()
            com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo r20 = r8.getAdditionalInfo()
            goto L_0x005d
        L_0x0055:
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x005d:
            if (r14 == 0) goto L_0x0064
            java.lang.String r14 = r14.getNextdayArrival()
            goto L_0x0065
        L_0x0064:
            r14 = 0
        L_0x0065:
            if (r20 == 0) goto L_0x0079
            java.lang.String r20 = r20.getNextdayArrival()
            goto L_0x007b
        L_0x006c:
            r7 = 0
            r8 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x0079:
            r20 = 0
        L_0x007b:
            if (r6 == 0) goto L_0x0082
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r6 = r6.getParentViewModel()
            goto L_0x0083
        L_0x0082:
            r6 = 0
        L_0x0083:
            if (r6 == 0) goto L_0x008a
            androidx.lifecycle.y r6 = r6.getCopiedSrpResult()
            goto L_0x008b
        L_0x008a:
            r6 = 0
        L_0x008b:
            r11 = 0
            r1.updateLiveDataRegistration(r11, r6)
            if (r6 == 0) goto L_0x00a5
            java.lang.Object r6 = r6.getValue()
            r11 = r6
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r11 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r11
            r23 = r11
            r22 = r14
            r21 = r15
            r11 = r17
            r6 = r18
            r14 = r20
            goto L_0x00b1
        L_0x00a5:
            r22 = r14
            r21 = r15
            r11 = r17
            r6 = r18
            r14 = r20
            r23 = 0
        L_0x00b1:
            r15 = r13
            r13 = r19
            r24 = r16
            r16 = r12
            r12 = r24
            goto L_0x00cb
        L_0x00bb:
            r16 = r12
            r6 = 0
            r7 = 0
            r8 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r21 = 0
            r22 = 0
            r23 = 0
        L_0x00cb:
            long r9 = r9 & r2
            int r17 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x015b
            com.paytm.utility.RoboTextView r9 = r1.f23663a
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setFlightName(r9, r0)
            android.widget.ImageView r9 = r1.f23666d
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setAirlineLogo(r9, r7)
            com.paytm.utility.RoboTextView r9 = r1.f23667e
            androidx.databinding.a.d.a((android.widget.TextView) r9, (java.lang.CharSequence) r6)
            com.paytm.utility.RoboTextView r6 = r1.f23669g
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setFlightFare(r6, r0)
            com.paytm.utility.RoboTextView r6 = r1.f23670h
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setHopText(r6, r8)
            com.paytm.utility.RoboTextView r6 = r1.j
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setRefundableText(r6, r0)
            android.view.View r6 = r1.m
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setOneStopView(r6, r8)
            com.paytm.utility.RoboTextView r6 = r1.n
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setAirlineCode(r6, r8)
            com.paytm.utility.RoboTextView r6 = r1.o
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setArrivalCityName(r6, r8)
            com.paytm.utility.RoboTextView r6 = r1.p
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r6, (java.lang.String) r11)
            com.paytm.utility.RoboTextView r6 = r1.q
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setDepartureCityName(r6, r8)
            com.paytm.utility.RoboTextView r6 = r1.r
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r6, (java.lang.String) r13)
            android.widget.ImageView r6 = r1.s
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setAirlineLogo(r6, r8)
            com.paytm.utility.RoboTextView r6 = r1.t
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r14)
            com.paytm.utility.RoboTextView r6 = r1.w
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setAirlineCode(r6, r7)
            com.paytm.utility.RoboTextView r6 = r1.x
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setArrivalCityName(r6, r7)
            com.paytm.utility.RoboTextView r6 = r1.y
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r6, (java.lang.String) r15)
            com.paytm.utility.RoboTextView r6 = r1.z
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setDepartureCityName(r6, r7)
            com.paytm.utility.RoboTextView r6 = r1.A
            com.travel.flight.flightSRPV2.c.c.b((android.widget.TextView) r6, (java.lang.String) r12)
            com.paytm.utility.RoboTextView r6 = r1.B
            r15 = r21
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r15)
            com.paytm.utility.RoboTextView r6 = r1.C
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setHopText(r6, r7)
            com.paytm.utility.RoboTextView r6 = r1.D
            r14 = r22
            androidx.databinding.a.d.a((android.widget.TextView) r6, (java.lang.CharSequence) r14)
            android.view.View r6 = r1.F
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setOneStopView(r6, r7)
            android.view.View r6 = r1.H
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setTwoStopView(r6, r7)
            android.view.View r6 = r1.I
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setTwoStopView(r6, r7)
            android.view.View r6 = r1.L
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setTwoStopView(r6, r8)
            android.view.View r6 = r1.M
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setTwoStopView(r6, r8)
        L_0x015b:
            if (r16 == 0) goto L_0x0169
            androidx.cardview.widget.CardView r6 = r1.f23664b
            r11 = r23
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setMoreOptionView(r6, r0, r11)
            com.paytm.utility.RoboTextView r6 = r1.f23671i
            com.travel.flight.flightSRPV2.viewModel.IRTViewModel.setMoreOptionViewText(r6, r0, r11)
        L_0x0169:
            r6 = 8
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0177
            androidx.cardview.widget.CardView r0 = r1.v
            android.view.View$OnClickListener r2 = r1.R
            r0.setOnClickListener(r2)
        L_0x0177:
            return
        L_0x0178:
            r0 = move-exception
            monitor-exit(r25)     // Catch:{ all -> 0x0178 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.b.bb.executeBindings():void");
    }

    public final void a(int i2, View view) {
        CJRIntlFlightList cJRIntlFlightList = this.N;
        IRTViewModel iRTViewModel = this.O;
        if (iRTViewModel != null) {
            iRTViewModel.onFlightItemClick(cJRIntlFlightList);
        }
    }
}
