package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.R;
import com.travel.booking.datamodel.BookingInfo;
import com.travel.booking.datamodel.CityBusBookingInfo;
import com.travel.booking.datamodel.CityBusRouteInfo;
import com.travel.e.a.a;

public final class t extends s implements a.C0453a {
    private static final ViewDataBinding.b q = null;
    private static final SparseIntArray r;
    private final LinearLayout s;
    private final View.OnClickListener t;
    private long u;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 10);
        r.put(R.id.mybooking_citybus_ticket_type, 11);
        r.put(R.id.mybooking_citybus_source_label, 12);
        r.put(R.id.mybooking_citybus_destination_label, 13);
        r.put(R.id.mybooking_guide_horizontal_middle, 14);
    }

    public t(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 15, q, r));
    }

    private t(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[10], objArr[5], objArr[13], objArr[6], objArr[7], objArr[2], objArr[8], objArr[4], objArr[12], objArr[11], objArr[9], objArr[14], objArr[1], objArr[3]);
        this.u = -1;
        this.s = objArr[0];
        this.s.setTag((Object) null);
        this.f22933b.setTag((Object) null);
        this.f22935d.setTag((Object) null);
        this.f22936e.setTag((Object) null);
        this.f22937f.setTag((Object) null);
        this.f22938g.setTag((Object) null);
        this.f22939h.setTag((Object) null);
        this.k.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        setRootTag(view);
        this.t = new a(this);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.u = 4;
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
        if (com.travel.a.f21417b == i2) {
            this.p = (com.travel.booking.e.a) obj;
            synchronized (this) {
                this.u |= 1;
            }
            notifyPropertyChanged(com.travel.a.f21417b);
            super.requestRebind();
        } else if (com.travel.a.f21418c != i2) {
            return false;
        } else {
            this.o = (BookingInfo) obj;
            synchronized (this) {
                this.u |= 2;
            }
            notifyPropertyChanged(com.travel.a.f21418c);
            super.requestRebind();
        }
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
        CityBusBookingInfo cityBusBookingInfo;
        CityBusRouteInfo cityBusRouteInfo;
        synchronized (this) {
            j = this.u;
            this.u = 0;
        }
        BookingInfo bookingInfo = this.o;
        String str9 = null;
        int i2 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (bookingInfo != null) {
                str7 = bookingInfo.getOrigin();
                str6 = bookingInfo.getFormattedDepartureTime();
                str5 = bookingInfo.getBgImage();
                str4 = bookingInfo.getVerticalLogo();
                str3 = bookingInfo.getFormattedDepartureDate();
                str2 = bookingInfo.getDestination();
                cityBusBookingInfo = bookingInfo.getCityBusBookingInfo();
            } else {
                cityBusBookingInfo = null;
                str7 = null;
                str6 = null;
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
            }
            if (cityBusBookingInfo != null) {
                cityBusRouteInfo = cityBusBookingInfo.getBusInfo();
                str = cityBusBookingInfo.getFormattedPassengerCount();
                str8 = cityBusBookingInfo.getFormattedTotalAmount();
            } else {
                str8 = null;
                cityBusRouteInfo = null;
                str = null;
            }
            if (cityBusRouteInfo != null) {
                str9 = cityBusRouteInfo.getOperatorName();
            }
        } else {
            str8 = null;
            str7 = null;
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        if ((j & 4) != 0) {
            this.s.setOnClickListener(this.t);
        }
        if (i2 != 0) {
            d.a(this.f22933b, (CharSequence) str2);
            d.a(this.f22935d, (CharSequence) str3);
            d.a(this.f22936e, (CharSequence) str6);
            d.a(this.f22937f, (CharSequence) str9);
            d.a(this.f22938g, (CharSequence) str);
            d.a(this.f22939h, (CharSequence) str7);
            d.a(this.k, (CharSequence) str8);
            com.travel.booking.c.a.a((View) this.m, str5);
            com.travel.booking.c.a.a(this.n, str4);
        }
    }

    public final void a() {
        com.travel.booking.e.a aVar = this.p;
        BookingInfo bookingInfo = this.o;
        if (aVar != null) {
            aVar.a(bookingInfo);
        }
    }
}
