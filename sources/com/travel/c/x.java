package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.R;
import com.travel.booking.datamodel.BookingInfo;
import com.travel.booking.datamodel.HotelBookingInfo;
import com.travel.e.a.a;
import java.util.List;

public final class x extends w implements a.C0453a {
    private static final ViewDataBinding.b p = null;
    private static final SparseIntArray q;
    private final LinearLayout r;
    private final View.OnClickListener s;
    private long t;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 12);
        q.put(R.id.resend_action, 13);
    }

    public x(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 14, p, q));
    }

    private x(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[12], objArr[7], objArr[1], objArr[4], objArr[3], objArr[2], objArr[13], objArr[6], objArr[9], objArr[8], objArr[10], objArr[11], objArr[5]);
        this.t = -1;
        this.f22951b.setTag((Object) null);
        this.r = objArr[0];
        this.r.setTag((Object) null);
        this.f22952c.setTag((Object) null);
        this.f22953d.setTag((Object) null);
        this.f22954e.setTag((Object) null);
        this.f22955f.setTag((Object) null);
        this.f22957h.setTag((Object) null);
        this.f22958i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        setRootTag(view);
        this.s = new a(this);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.t = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.t != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.a.f21417b == i2) {
            this.o = (com.travel.booking.e.a) obj;
            synchronized (this) {
                this.t |= 1;
            }
            notifyPropertyChanged(com.travel.a.f21417b);
            super.requestRebind();
        } else if (com.travel.a.f21418c != i2) {
            return false;
        } else {
            this.n = (BookingInfo) obj;
            synchronized (this) {
                this.t |= 2;
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
        String str9;
        String str10;
        HotelBookingInfo hotelBookingInfo;
        String str11;
        String str12;
        String str13;
        List<String> list;
        synchronized (this) {
            j = this.t;
            this.t = 0;
        }
        BookingInfo bookingInfo = this.n;
        String str14 = null;
        int i2 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (bookingInfo != null) {
                str8 = bookingInfo.getOrigin();
                str11 = bookingInfo.getFormattedDepartureTime();
                str6 = bookingInfo.getBgImage();
                str5 = bookingInfo.getVerticalLogo();
                str4 = bookingInfo.getFormattedArrivalTime();
                str3 = bookingInfo.getFormattedDepartureDate();
                hotelBookingInfo = bookingInfo.getHotelBookingInfo();
                str = bookingInfo.getDestination();
                str10 = bookingInfo.getFormattedArrivalDate();
            } else {
                str10 = null;
                str8 = null;
                str11 = null;
                str6 = null;
                str5 = null;
                str4 = null;
                str3 = null;
                hotelBookingInfo = null;
                str = null;
            }
            if (hotelBookingInfo != null) {
                str13 = hotelBookingInfo.getHotelName();
                str12 = hotelBookingInfo.getNumberOfNights();
                list = hotelBookingInfo.getRoomTypes();
            } else {
                list = null;
                str13 = null;
                str12 = null;
            }
            if (list != null) {
                str14 = list.get(0);
            }
            str9 = str11;
            str2 = str14;
            str7 = str13;
            str14 = str12;
        } else {
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
        }
        if (i2 != 0) {
            d.a(this.f22951b, (CharSequence) str14);
            com.travel.booking.c.a.a((View) this.f22952c, str6);
            d.a(this.f22953d, (CharSequence) str);
            com.travel.booking.c.a.a(this.f22954e, str5);
            d.a(this.f22955f, (CharSequence) str8);
            d.a(this.f22957h, (CharSequence) str3);
            d.a(this.f22958i, (CharSequence) str10);
            d.a(this.j, (CharSequence) str4);
            d.a(this.k, (CharSequence) str7);
            d.a(this.l, (CharSequence) str2);
            d.a(this.m, (CharSequence) str9);
        }
        if ((j & 4) != 0) {
            this.r.setOnClickListener(this.s);
        }
    }

    public final void a() {
        com.travel.booking.e.a aVar = this.o;
        BookingInfo bookingInfo = this.n;
        if (aVar != null) {
            aVar.a(bookingInfo);
        }
    }
}
