package com.travel.c;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.R;
import com.travel.booking.datamodel.BookingInfo;
import com.travel.booking.datamodel.FlightBookingInfo;
import com.travel.booking.datamodel.FlightTravelInfo;
import com.travel.e.a.a;

public final class v extends u implements a.C0453a {
    private static final ViewDataBinding.b N = null;
    private static final SparseIntArray O;
    private final LinearLayout P;
    private final View.OnClickListener Q;
    private long R;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 34);
        O.put(R.id.resend_action, 35);
        O.put(R.id.return_action_layout, 36);
        O.put(R.id.return_resend_action, 37);
    }

    public v(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 38, N, O));
    }

    private v(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[16], objArr[5], objArr[14], objArr[13], objArr[9], objArr[34], objArr[18], objArr[7], objArr[15], objArr[12], objArr[6], objArr[23], objArr[10], objArr[8], objArr[19], objArr[22], objArr[21], objArr[20], objArr[1], objArr[4], objArr[3], objArr[2], objArr[17], objArr[11], objArr[35], objArr[36], objArr[31], objArr[30], objArr[26], objArr[24], objArr[32], objArr[29], objArr[27], objArr[25], objArr[33], objArr[28], objArr[37]);
        this.R = -1;
        this.f22941a.setTag((Object) null);
        this.f22942b.setTag((Object) null);
        this.f22943c.setTag((Object) null);
        this.f22944d.setTag((Object) null);
        this.f22945e.setTag((Object) null);
        this.f22947g.setTag((Object) null);
        this.f22948h.setTag((Object) null);
        this.f22949i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        this.n.setTag((Object) null);
        this.P = objArr[0];
        this.P.setTag((Object) null);
        this.o.setTag((Object) null);
        this.p.setTag((Object) null);
        this.q.setTag((Object) null);
        this.r.setTag((Object) null);
        this.s.setTag((Object) null);
        this.t.setTag((Object) null);
        this.u.setTag((Object) null);
        this.v.setTag((Object) null);
        this.w.setTag((Object) null);
        this.x.setTag((Object) null);
        this.A.setTag((Object) null);
        this.B.setTag((Object) null);
        this.C.setTag((Object) null);
        this.D.setTag((Object) null);
        this.E.setTag((Object) null);
        this.F.setTag((Object) null);
        this.G.setTag((Object) null);
        this.H.setTag((Object) null);
        this.I.setTag((Object) null);
        this.J.setTag((Object) null);
        setRootTag(view);
        this.Q = new a(this);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.R = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.R != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.a.f21418c == i2) {
            this.L = (BookingInfo) obj;
            synchronized (this) {
                this.R |= 1;
            }
            notifyPropertyChanged(com.travel.a.f21418c);
            super.requestRebind();
        } else if (com.travel.a.f21417b != i2) {
            return false;
        } else {
            this.M = (com.travel.booking.e.a) obj;
            synchronized (this) {
                this.R |= 2;
            }
            notifyPropertyChanged(com.travel.a.f21417b);
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
        int i2;
        String str5;
        String str6;
        int i3;
        String str7;
        String str8;
        String str9;
        String str10;
        int i4;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        int i5;
        boolean z;
        boolean z2;
        boolean z3;
        FlightBookingInfo flightBookingInfo;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        String str45;
        Boolean bool;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        FlightTravelInfo flightTravelInfo;
        FlightTravelInfo flightTravelInfo2;
        String str52;
        String str53;
        String str54;
        String str55;
        String str56;
        String str57;
        String str58;
        long j2;
        long j3;
        synchronized (this) {
            j = this.R;
            this.R = 0;
        }
        BookingInfo bookingInfo = this.L;
        int i6 = 0;
        int i7 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (bookingInfo != null) {
                str48 = bookingInfo.getReturnformattedDepartureDate();
                str47 = bookingInfo.getReturnformattedAirlinenameandCode();
                str46 = bookingInfo.getFormattedArrivalTime();
                bool = bookingInfo.getIsdatePassed();
                str45 = bookingInfo.getFormattedArrivalDate();
                str44 = bookingInfo.getOrigin();
                str43 = bookingInfo.getFormattedDepartureTime();
                str42 = bookingInfo.getVerticalLogo();
                str41 = bookingInfo.getColorCode();
                str40 = bookingInfo.getReturnformattedDepartureTime();
                str39 = bookingInfo.getDestination();
                str38 = bookingInfo.getBgImage();
                str37 = bookingInfo.getRefundStatus();
                str36 = bookingInfo.getReturnformattedArrivalDate();
                str35 = bookingInfo.getFormattedAirlinenameandCode();
                str34 = bookingInfo.getFormattedDepartureDate();
                flightBookingInfo = bookingInfo.getFlightBookingInfo();
                str49 = bookingInfo.getReturnformattedArrivalTime();
            } else {
                str49 = null;
                str48 = null;
                str47 = null;
                str46 = null;
                bool = null;
                str45 = null;
                str44 = null;
                str43 = null;
                str42 = null;
                str41 = null;
                str40 = null;
                str39 = null;
                str38 = null;
                str37 = null;
                str36 = null;
                str35 = null;
                str34 = null;
                flightBookingInfo = null;
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            boolean isEmpty = TextUtils.isEmpty(str37);
            if (i7 != 0) {
                if (safeUnbox) {
                    j3 = j | 64;
                    j2 = 262144;
                } else {
                    j3 = j | 32;
                    j2 = 131072;
                }
                j = j3 | j2;
            }
            if ((j & 5) != 0) {
                j |= isEmpty ? 65536 : 32768;
            }
            if (flightBookingInfo != null) {
                str54 = flightBookingInfo.getOnwardDepartureTerminal();
                str53 = flightBookingInfo.getOnwardArrivalTerminal();
                str52 = flightBookingInfo.getBookingClass();
                flightTravelInfo2 = flightBookingInfo.getReturnInfo();
                flightTravelInfo = flightBookingInfo.getOnwardInfo();
                str51 = flightBookingInfo.getReturnArrivalTerminal();
                str50 = flightBookingInfo.getReturnDepartureTerminal();
            } else {
                str54 = null;
                str53 = null;
                str52 = null;
                flightTravelInfo2 = null;
                flightTravelInfo = null;
                str51 = null;
                str50 = null;
            }
            int i8 = safeUnbox ? 0 : 8;
            int i9 = safeUnbox ? 8 : 0;
            int i10 = isEmpty ? 8 : 0;
            int i11 = 1;
            z3 = str54 != null;
            z2 = str53 != null;
            boolean z4 = flightTravelInfo2 != null;
            z = str51 != null;
            if (str50 == null) {
                i11 = 0;
            }
            if ((j & 5) != 0) {
                j = z3 ? j | 1024 : j | 512;
            }
            if ((j & 5) != 0) {
                j = z2 ? j | 256 : j | 128;
            }
            if ((j & 5) != 0) {
                j |= z4 ? 4096 : 2048;
            }
            if ((j & 5) != 0) {
                j = z ? j | 16384 : j | 8192;
            }
            if ((j & 5) != 0) {
                j = i11 != 0 ? j | 16 : j | 8;
            }
            if (flightTravelInfo2 != null) {
                str55 = flightTravelInfo2.getAirline_logo();
                str56 = flightTravelInfo2.getDuration();
            } else {
                str56 = null;
                str55 = null;
            }
            if (flightTravelInfo != null) {
                str57 = flightTravelInfo.getAirline_logo();
                str58 = flightTravelInfo.getDuration();
            } else {
                str58 = null;
                str57 = null;
            }
            if (!z4) {
                i6 = 8;
            }
            str = str49;
            str23 = str48;
            str20 = str47;
            i4 = i6;
            str21 = str54;
            str17 = str46;
            i2 = i9;
            str14 = str45;
            str13 = str44;
            str12 = str43;
            str11 = str42;
            str10 = str41;
            str8 = str40;
            str7 = str39;
            str6 = str38;
            str5 = str37;
            str4 = str36;
            str3 = str35;
            str2 = str34;
            i3 = i10;
            str25 = str53;
            str16 = str52;
            str15 = str56;
            str9 = str58;
            str24 = str51;
            str22 = str50;
            i5 = i8;
            i6 = i11;
            str18 = str55;
            str19 = str57;
        } else {
            str25 = null;
            str24 = null;
            str23 = null;
            str22 = null;
            str21 = null;
            flightBookingInfo = null;
            str20 = null;
            str19 = null;
            str18 = null;
            str17 = null;
            str16 = null;
            str15 = null;
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
            z3 = false;
            z2 = false;
            z = false;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        String returnOriginAirport = ((j & 24) == 0 || flightBookingInfo == null) ? null : flightBookingInfo.getReturnOriginAirport();
        int i12 = ((j & 256) > 0 ? 1 : ((j & 256) == 0 ? 0 : -1));
        if (i12 != 0) {
            str26 = str25 + " ";
        } else {
            str26 = null;
        }
        String onwardOriginAirport = ((1536 & j) == 0 || flightBookingInfo == null) ? null : flightBookingInfo.getOnwardOriginAirport();
        if ((j & 16) != 0) {
            str27 = (str22 + " ") + returnOriginAirport;
        } else {
            str27 = null;
        }
        String returnDestinationAirport = ((24576 & j) == 0 || flightBookingInfo == null) ? null : flightBookingInfo.getReturnDestinationAirport();
        if ((1024 & j) != 0) {
            str28 = (str21 + " ") + onwardOriginAirport;
        } else {
            str28 = null;
        }
        if ((384 & j) != 0) {
            str29 = flightBookingInfo != null ? flightBookingInfo.getOnwardDestinationAirport() : null;
            if (i12 != 0) {
                str30 = str26 + str29;
            } else {
                str30 = null;
            }
        } else {
            str30 = null;
            str29 = null;
        }
        if ((16384 & j) != 0) {
            str31 = (str24 + " ") + returnDestinationAirport;
        } else {
            str31 = null;
        }
        int i13 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i13 != 0) {
            String str59 = i6 != 0 ? str27 : returnOriginAirport;
            if (!z2) {
                str30 = str29;
            }
            if (!z3) {
                str28 = onwardOriginAirport;
            }
            if (!z) {
                str31 = returnDestinationAirport;
            }
            str32 = str31;
            str33 = str59;
        } else {
            str30 = null;
            str33 = null;
            str32 = null;
            str28 = null;
        }
        if (i13 != 0) {
            this.f22941a.setVisibility(i2);
            this.f22942b.setVisibility(i5);
            d.a(this.f22943c, (CharSequence) str28);
            d.a(this.f22944d, (CharSequence) str14);
            d.a(this.f22945e, (CharSequence) str12);
            this.f22947g.setVisibility(i4);
            d.a(this.f22948h, (CharSequence) str3);
            d.a(this.f22949i, (CharSequence) str30);
            d.a(this.j, (CharSequence) str2);
            com.travel.booking.c.a.a(this.k, str19);
            com.travel.booking.c.a.a(this.l, str18);
            d.a(this.m, (CharSequence) str9);
            String str60 = str16;
            d.a(this.n, (CharSequence) str60);
            String str61 = str6;
            com.travel.booking.c.a.a((View) this.o, str61);
            String str62 = str13;
            d.a(this.p, (CharSequence) str62);
            String str63 = str11;
            com.travel.booking.c.a.a(this.q, str63);
            String str64 = str7;
            d.a(this.r, (CharSequence) str64);
            com.travel.booking.c.a.a((View) this.s, str61);
            d.a(this.t, (CharSequence) str64);
            com.travel.booking.c.a.a(this.u, str63);
            d.a(this.v, (CharSequence) str62);
            String str65 = str5;
            d.a(this.w, (CharSequence) str65);
            int i14 = i3;
            this.w.setVisibility(i14);
            String str66 = str10;
            com.travel.booking.c.a.a(this.w, str66);
            d.a(this.x, (CharSequence) str17);
            d.a(this.A, (CharSequence) str33);
            d.a(this.B, (CharSequence) str4);
            d.a(this.C, (CharSequence) str8);
            d.a(this.D, (CharSequence) str20);
            d.a(this.E, (CharSequence) str32);
            d.a(this.F, (CharSequence) str23);
            d.a(this.G, (CharSequence) str15);
            d.a(this.H, (CharSequence) str60);
            d.a(this.I, (CharSequence) str65);
            this.I.setVisibility(i14);
            com.travel.booking.c.a.a(this.I, str66);
            d.a(this.J, (CharSequence) str);
        }
        if ((j & 4) != 0) {
            this.P.setOnClickListener(this.Q);
        }
    }

    public final void a() {
        com.travel.booking.e.a aVar = this.M;
        BookingInfo bookingInfo = this.L;
        if (aVar != null) {
            aVar.a(bookingInfo);
        }
    }
}
