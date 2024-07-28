package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBChargeFlightItem;

public final class n extends m {
    private static final ViewDataBinding.b r = null;
    private static final SparseIntArray s;
    private final ConstraintLayout t;
    private long u;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        s = sparseIntArray;
        sparseIntArray.put(R.id.left_guideline, 14);
        s.put(R.id.right_guideline, 15);
        s.put(R.id.divider_traveler, 16);
    }

    public n(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 17, r, s));
    }

    private n(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[16], objArr[12], objArr[13], objArr[3], objArr[10], objArr[11], objArr[7], objArr[4], objArr[2], objArr[5], objArr[6], objArr[8], objArr[14], objArr[1], objArr[15], objArr[9]);
        this.u = -1;
        this.f24000b.setTag((Object) null);
        this.f24001c.setTag((Object) null);
        this.f24002d.setTag((Object) null);
        this.f24003e.setTag((Object) null);
        this.f24004f.setTag((Object) null);
        this.f24005g.setTag((Object) null);
        this.f24006h.setTag((Object) null);
        this.f24007i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.t = objArr[0];
        this.t.setTag((Object) null);
        this.n.setTag((Object) null);
        this.p.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.u = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.u != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f23482f != i2) {
            return false;
        }
        this.q = (CJRFlightMBChargeFlightItem) obj;
        synchronized (this) {
            this.u |= 1;
        }
        notifyPropertyChanged(a.f23482f);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        synchronized (this) {
            j = this.u;
            this.u = 0;
        }
        CJRFlightMBChargeFlightItem cJRFlightMBChargeFlightItem = this.q;
        String str11 = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 == 0 || cJRFlightMBChargeFlightItem == null) {
            str10 = null;
            str9 = null;
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        } else {
            String airline = cJRFlightMBChargeFlightItem.getAirline();
            str10 = cJRFlightMBChargeFlightItem.getAircraftTypeDisplayName();
            String destination = cJRFlightMBChargeFlightItem.getDestination();
            String airline_logo = cJRFlightMBChargeFlightItem.getAirline_logo();
            str7 = cJRFlightMBChargeFlightItem.getDeparture_date_local();
            str5 = cJRFlightMBChargeFlightItem.getArrival_date_local();
            str4 = cJRFlightMBChargeFlightItem.getFlight_no();
            String origin_airport = cJRFlightMBChargeFlightItem.getOrigin_airport();
            str2 = cJRFlightMBChargeFlightItem.getDuration();
            str = cJRFlightMBChargeFlightItem.getDestination_airport();
            str6 = cJRFlightMBChargeFlightItem.getOrigin();
            String str12 = airline_logo;
            str8 = destination;
            str9 = airline;
            str11 = origin_airport;
            str3 = str12;
        }
        if (i2 != 0) {
            d.a(this.f24000b, (CharSequence) str11);
            d.a(this.f24001c, (CharSequence) str);
            d.a(this.f24002d, (CharSequence) str4);
            com.travel.flight.flightticket.b.a.b(this.f24003e, str7);
            com.travel.flight.flightticket.b.a.b(this.f24004f, str5);
            com.travel.flight.flightticket.b.a.a(this.f24005g, str7);
            d.a(this.f24006h, (CharSequence) str10);
            d.a(this.f24007i, (CharSequence) str9);
            d.a(this.j, (CharSequence) str6);
            d.a(this.k, (CharSequence) str8);
            com.travel.flight.flightticket.b.a.a(this.l, str5);
            com.travel.flight.flightticket.b.a.a(this.n, str3);
            d.a(this.p, (CharSequence) str2);
        }
    }
}
