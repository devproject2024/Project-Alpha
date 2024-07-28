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
import com.travel.booking.datamodel.TrainBookingInfo;
import com.travel.e.a.a;
import java.util.List;

public final class z extends y implements a.C0453a {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p;
    private final LinearLayout q;
    private final View.OnClickListener r;
    private long s;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.card_view, 11);
        p.put(R.id.resend_action, 12);
    }

    public z(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 13, o, p));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private z(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[9], objArr[11], objArr[8], objArr[7], objArr[1], objArr[4], objArr[3], objArr[2], objArr[5], objArr[10], objArr[6], objArr[12]);
        this.s = -1;
        this.f22959a.setTag((Object) null);
        this.f22961c.setTag((Object) null);
        this.f22962d.setTag((Object) null);
        this.q = objArr[0];
        this.q.setTag((Object) null);
        this.f22963e.setTag((Object) null);
        this.f22964f.setTag((Object) null);
        this.f22965g.setTag((Object) null);
        this.f22966h.setTag((Object) null);
        this.f22967i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        setRootTag(view);
        this.r = new a(this);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.s = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.s != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.a.f21417b == i2) {
            this.n = (com.travel.booking.e.a) obj;
            synchronized (this) {
                this.s |= 1;
            }
            notifyPropertyChanged(com.travel.a.f21417b);
            super.requestRebind();
        } else if (com.travel.a.f21418c != i2) {
            return false;
        } else {
            this.m = (BookingInfo) obj;
            synchronized (this) {
                this.s |= 2;
            }
            notifyPropertyChanged(com.travel.a.f21418c);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        int i2;
        String str2;
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
        List<Action> list;
        String str14;
        String str15;
        String str16;
        TrainBookingInfo trainBookingInfo;
        String str17;
        synchronized (this) {
            j = this.s;
            this.s = 0;
        }
        BookingInfo bookingInfo = this.m;
        int i3 = 0;
        String str18 = null;
        int i4 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (bookingInfo != null) {
                str16 = bookingInfo.getOrigin();
                str15 = bookingInfo.getFormattedPNR();
                str5 = bookingInfo.getBgImage();
                str14 = bookingInfo.getRefundStatus();
                list = bookingInfo.getActions();
                str13 = bookingInfo.getVerticalLogo();
                str12 = bookingInfo.getFormattedDepartureDate();
                str11 = bookingInfo.getColorCode();
                str10 = bookingInfo.getDestination();
                trainBookingInfo = bookingInfo.getTrainBookingInfo();
            } else {
                trainBookingInfo = null;
                str16 = null;
                str15 = null;
                str5 = null;
                str14 = null;
                list = null;
                str13 = null;
                str12 = null;
                str11 = null;
                str10 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str14);
            boolean z = list != null;
            if (i4 != 0) {
                j |= isEmpty ? 16 : 8;
            }
            if ((j & 6) != 0) {
                j |= z ? 64 : 32;
            }
            if (trainBookingInfo != null) {
                str18 = trainBookingInfo.getJourneyClass();
                str17 = trainBookingInfo.getTrainName();
            } else {
                str17 = null;
            }
            int i5 = isEmpty ? 8 : 0;
            if (!z) {
                i3 = 8;
            }
            str6 = str16;
            str = str15;
            str3 = str14;
            str7 = str13;
            str2 = str11;
            str8 = str10;
            i2 = i5;
            str4 = str17;
            str9 = str18;
            str18 = str12;
        } else {
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
            this.f22959a.setVisibility(i3);
            d.a(this.f22961c, (CharSequence) str18);
            d.a(this.f22962d, (CharSequence) str9);
            com.travel.booking.c.a.a((View) this.f22963e, str5);
            d.a(this.f22964f, (CharSequence) str8);
            com.travel.booking.c.a.a(this.f22965g, str7);
            d.a(this.f22966h, (CharSequence) str6);
            d.a(this.f22967i, (CharSequence) str4);
            d.a(this.j, (CharSequence) str3);
            com.travel.booking.c.a.a(this.j, str2);
            this.j.setVisibility(i2);
            d.a(this.k, (CharSequence) str);
        }
        if ((j & 4) != 0) {
            this.q.setOnClickListener(this.r);
        }
    }

    public final void a() {
        com.travel.booking.e.a aVar = this.n;
        BookingInfo bookingInfo = this.m;
        if (aVar != null) {
            aVar.a(bookingInfo);
        }
    }
}
