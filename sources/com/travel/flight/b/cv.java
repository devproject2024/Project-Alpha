package com.travel.flight.b;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo;
import java.util.ArrayList;

public final class cv extends cu implements a.C0456a {
    private static final ViewDataBinding.b x = null;
    private static final SparseIntArray y;
    private final View.OnClickListener A;
    private long B;
    private final ConstraintLayout z;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.hop_divider, 20);
        y.put(R.id.tv_select, 21);
    }

    public cv(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 22, x, y));
    }

    private cv(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[16], objArr[15], objArr[14], objArr[2], objArr[7], objArr[6], objArr[8], objArr[12], objArr[1], objArr[20], objArr[4], objArr[5], objArr[9], objArr[18], objArr[21], objArr[10], objArr[11], objArr[13], objArr[17], objArr[19]);
        this.B = -1;
        this.f23858a.setTag((Object) null);
        this.f23859b.setTag((Object) null);
        this.f23860c.setTag((Object) null);
        this.f23861d.setTag((Object) null);
        this.f23862e.setTag((Object) null);
        this.f23863f.setTag((Object) null);
        this.f23864g.setTag((Object) null);
        this.f23865h.setTag((Object) null);
        this.f23866i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.z = objArr[0];
        this.z.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.q.setTag((Object) null);
        this.r.setTag((Object) null);
        this.s.setTag((Object) null);
        this.t.setTag((Object) null);
        this.u.setTag((Object) null);
        setRootTag(view);
        this.A = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.B = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.B != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.x == i2) {
            this.v = (CJRFlightDetailsItem) obj;
            synchronized (this) {
                this.B |= 1;
            }
            notifyPropertyChanged(com.travel.flight.a.x);
            super.requestRebind();
        } else if (com.travel.flight.a.p != i2) {
            return false;
        } else {
            this.w = (SRPOneWayViewModel) obj;
            synchronized (this) {
                this.B |= 2;
            }
            notifyPropertyChanged(com.travel.flight.a.p);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        float f2;
        String str;
        String str2;
        String str3;
        int i2;
        String str4;
        int i3;
        int i4;
        boolean z2;
        String str5;
        String str6;
        String str7;
        int i5;
        int i6;
        String str8;
        long j2;
        int i7;
        int i8;
        int i9;
        int i10;
        long j3;
        int i11;
        String str9;
        String str10;
        ArrayList<CJRFlightStops> arrayList;
        CJRFlightsAdditionalInfo cJRFlightsAdditionalInfo;
        String str11;
        int i12;
        String str12;
        boolean z3;
        int i13;
        Resources resources;
        String str13;
        synchronized (this) {
            j = this.B;
            this.B = 0;
        }
        CJRFlightDetailsItem cJRFlightDetailsItem = this.v;
        SRPOneWayViewModel sRPOneWayViewModel = this.w;
        int i14 = 8;
        boolean z4 = true;
        String str14 = null;
        int i15 = 0;
        if ((j & 7) == 0 || (j & 5) == 0) {
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i6 = 0;
            i5 = 0;
            z2 = false;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            f2 = 0.0f;
        } else {
            if (cJRFlightDetailsItem != null) {
                str8 = cJRFlightDetailsItem.getmDepartureTime();
                str7 = cJRFlightDetailsItem.getmDestination();
                z3 = cJRFlightDetailsItem.isStitchedAndMoreThanOneHop();
                str12 = cJRFlightDetailsItem.getmDuration();
                i12 = cJRFlightDetailsItem.getmCheapestFlightValue();
                str11 = cJRFlightDetailsItem.getmOrigin();
                i3 = cJRFlightDetailsItem.getPosState();
                cJRFlightsAdditionalInfo = cJRFlightDetailsItem.getAdditionalInfo();
                arrayList = cJRFlightDetailsItem.getmFlights();
                str10 = cJRFlightDetailsItem.getmArrivalTime();
                str9 = cJRFlightDetailsItem.getFormattedSecondHopInfo();
            } else {
                str8 = null;
                str7 = null;
                str12 = null;
                str11 = null;
                cJRFlightsAdditionalInfo = null;
                arrayList = null;
                str10 = null;
                str9 = null;
                z3 = false;
                i12 = 0;
                i3 = 0;
            }
            if (i11 != 0) {
                j |= z3 ? 16 : 8;
            }
            if (z3) {
                resources = this.t.getResources();
                i13 = R.dimen.dimen_2dp;
            } else {
                resources = this.t.getResources();
                i13 = R.dimen.dimen_0dp;
            }
            float dimension = resources.getDimension(i13);
            if (cJRFlightsAdditionalInfo != null) {
                str14 = cJRFlightsAdditionalInfo.getNextdayArrival();
                str13 = cJRFlightsAdditionalInfo.getOperatingAirline();
            } else {
                str13 = null;
            }
            if (arrayList != null) {
                i6 = arrayList.size();
            } else {
                i6 = 0;
            }
            boolean z5 = str14 != null;
            boolean z6 = str13 != null;
            z2 = i6 == 2;
            if ((j & 5) != 0) {
                j |= z5 ? 65536 : 32768;
            }
            if ((j & 5) != 0) {
                j |= z6 ? 64 : 32;
            }
            if ((j & 5) != 0) {
                j = z2 ? j | 256 | 4096 : j | 128 | 2048;
            }
            int i16 = z5 ? 0 : 8;
            i4 = z6 ? 0 : 4;
            i2 = i16;
            f2 = dimension;
            str = str13;
            str6 = str14;
            str5 = str12;
            i5 = i12;
            str4 = str11;
            str3 = str10;
            str2 = str9;
        }
        if ((j & 2176) != 0) {
            if (i6 != 3) {
                z4 = false;
            }
            j2 = 0;
            if ((j & 128) != 0) {
                j |= z4 ? 1024 : 512;
            }
            if ((j & 2048) != 0) {
                j |= z4 ? 16384 : 8192;
            }
            if ((j & 128) != 0) {
                i7 = z4 ? 4 : 8;
                j3 = 2048;
            } else {
                j3 = 2048;
                i7 = 0;
            }
            i8 = ((j3 & j) == 0 || z4) ? 0 : 8;
        } else {
            j2 = 0;
            i8 = 0;
            i7 = 0;
        }
        int i17 = ((j & 5) > j2 ? 1 : ((j & 5) == j2 ? 0 : -1));
        if (i17 != 0) {
            if (!z2) {
                i15 = i7;
            }
            if (!z2) {
                i14 = i8;
            }
            i9 = i14;
            i10 = i15;
        } else {
            i10 = 0;
            i9 = 0;
        }
        if (i17 != 0) {
            c.d(this.f23858a, cJRFlightDetailsItem);
            c.a(this.f23859b, cJRFlightDetailsItem);
            d.a(this.f23860c, (CharSequence) str7);
            c.b(this.f23861d, str3);
            c.b(this.f23862e, i5);
            d.a(this.f23863f, (CharSequence) str4);
            c.b(this.f23864g, str8);
            d.a(this.f23865h, (CharSequence) str5);
            c.b(this.f23866i, cJRFlightDetailsItem);
            d.a(this.j, (CharSequence) str2);
            c.b(this.l, cJRFlightDetailsItem);
            c.c(this.m, cJRFlightDetailsItem);
            this.n.setVisibility(i10);
            this.q.setVisibility(i9);
            this.r.setVisibility(i9);
            d.a(this.s, (CharSequence) str6);
            this.s.setVisibility(i2);
            androidx.databinding.a.e.a((View) this.t, f2);
            d.a(this.t, (CharSequence) str);
            this.t.setVisibility(i4);
            c.b(this.u, Integer.valueOf(i3));
        }
        if ((4 & j) != 0) {
            this.z.setOnClickListener(this.A);
        }
        if ((j & 7) != 0) {
            c.a(this.o, cJRFlightDetailsItem, sRPOneWayViewModel);
        }
    }

    public final void a(int i2, View view) {
        SRPOneWayViewModel sRPOneWayViewModel = this.w;
        CJRFlightDetailsItem cJRFlightDetailsItem = this.v;
        if (sRPOneWayViewModel != null) {
            sRPOneWayViewModel.onFlightItemClick(cJRFlightDetailsItem);
        }
    }
}
