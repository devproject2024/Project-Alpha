package com.travel.c;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.R;
import com.travel.booking.datamodel.Action;
import com.travel.booking.datamodel.BookingInfo;
import com.travel.booking.datamodel.BusBookingInfo;
import com.travel.e.a.a;
import java.util.List;

public final class r extends q implements a.C0453a {
    private static final ViewDataBinding.b t = null;
    private static final SparseIntArray u;
    private final LinearLayout v;
    private final View.OnClickListener w;
    private long x;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        u = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 16);
        u.put(R.id.resend_action, 17);
    }

    public r(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 18, t, u));
    }

    private r(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[14], objArr[9], objArr[5], objArr[10], objArr[11], objArr[13], objArr[12], objArr[16], objArr[8], objArr[6], objArr[1], objArr[4], objArr[3], objArr[2], objArr[15], objArr[7], objArr[17]);
        this.x = -1;
        this.f22923a.setTag((Object) null);
        this.f22924b.setTag((Object) null);
        this.f22925c.setTag((Object) null);
        this.f22926d.setTag((Object) null);
        this.f22927e.setTag((Object) null);
        this.f22928f.setTag((Object) null);
        this.f22929g.setTag((Object) null);
        this.f22931i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.v = objArr[0];
        this.v.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        setRootTag(view);
        this.w = new a(this);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.x = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.x != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.a.f21417b == i2) {
            this.s = (com.travel.booking.e.a) obj;
            synchronized (this) {
                this.x |= 1;
            }
            notifyPropertyChanged(com.travel.a.f21417b);
            super.requestRebind();
        } else if (com.travel.a.f21418c != i2) {
            return false;
        } else {
            this.r = (BookingInfo) obj;
            synchronized (this) {
                this.x |= 2;
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
        int i2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        BusBookingInfo busBookingInfo;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        List<Action> list;
        String str22;
        String str23;
        String str24;
        String str25;
        synchronized (this) {
            j = this.x;
            this.x = 0;
        }
        BookingInfo bookingInfo = this.r;
        int i3 = 0;
        String str26 = null;
        int i4 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (bookingInfo != null) {
                str13 = bookingInfo.getFormattedSeatInfo();
                str25 = bookingInfo.getOrigin();
                str24 = bookingInfo.getFormattedDepartureTime();
                str23 = bookingInfo.getBgImage();
                str22 = bookingInfo.getRefundStatus();
                list = bookingInfo.getActions();
                str21 = bookingInfo.getVerticalLogo();
                str20 = bookingInfo.getFormattedArrivalTime();
                str19 = bookingInfo.getFormattedDuration();
                str18 = bookingInfo.getFormattedDepartureDate();
                str17 = bookingInfo.getColorCode();
                str16 = bookingInfo.getStatus();
                str15 = bookingInfo.getDestination();
                busBookingInfo = bookingInfo.getBusBookingInfo();
                str14 = bookingInfo.getFormattedArrivalDate();
            } else {
                str14 = null;
                str13 = null;
                str25 = null;
                str24 = null;
                str23 = null;
                str22 = null;
                list = null;
                str21 = null;
                str20 = null;
                str19 = null;
                str18 = null;
                str17 = null;
                str16 = null;
                str15 = null;
                busBookingInfo = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str22);
            boolean z = list != null;
            if (i4 != 0) {
                j |= isEmpty ? 16 : 8;
            }
            if ((j & 6) != 0) {
                j |= z ? 64 : 32;
            }
            if (busBookingInfo != null) {
                str26 = busBookingInfo.getBusType();
                str11 = busBookingInfo.getOperatorName();
            } else {
                str11 = null;
            }
            int i5 = isEmpty ? 8 : 0;
            if (!z) {
                i3 = 8;
            }
            str4 = str25;
            str7 = str23;
            str3 = str22;
            str5 = str21;
            str = str20;
            str8 = str19;
            str9 = str18;
            str2 = str17;
            str12 = str16;
            str6 = str15;
            i2 = i5;
            String str27 = str24;
            str10 = str26;
            str26 = str27;
        } else {
            str14 = null;
            str13 = null;
            str12 = null;
            str11 = null;
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
            i2 = 0;
        }
        if ((6 & j) != 0) {
            this.f22923a.setVisibility(i3);
            d.a(this.f22924b, (CharSequence) str14);
            d.a(this.f22925c, (CharSequence) str26);
            d.a(this.f22926d, (CharSequence) str11);
            d.a(this.f22927e, (CharSequence) str13);
            d.a(this.f22928f, (CharSequence) str12);
            d.a(this.f22929g, (CharSequence) str10);
            d.a(this.f22931i, (CharSequence) str9);
            d.a(this.j, (CharSequence) str8);
            com.travel.booking.c.a.a((View) this.k, str7);
            d.a(this.l, (CharSequence) str6);
            com.travel.booking.c.a.a(this.m, str5);
            d.a(this.n, (CharSequence) str4);
            d.a(this.o, (CharSequence) str3);
            this.o.setVisibility(i2);
            com.travel.booking.c.a.a(this.o, str2);
            d.a(this.p, (CharSequence) str);
        }
        if ((j & 4) != 0) {
            this.v.setOnClickListener(this.w);
        }
    }

    public final void a() {
        com.travel.booking.e.a aVar = this.s;
        BookingInfo bookingInfo = this.r;
        if (aVar != null) {
            aVar.a(bookingInfo);
        }
    }
}
