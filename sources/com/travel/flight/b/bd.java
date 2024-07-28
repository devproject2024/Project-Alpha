package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.IRTSplitViewModel;
import com.travel.flight.flightSRPV2.viewModel.IRTViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRFlightsAdditionalInfo;

public final class bd extends bc implements a.C0456a {
    private static final ViewDataBinding.b r = null;
    private static final SparseIntArray s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private long v;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        s = sparseIntArray;
        sparseIntArray.put(R.id.logo_name_container, 11);
        s.put(R.id.ll_lyt_flight_timings, 12);
    }

    public bd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 13, r, s));
    }

    private bd(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[5], objArr[10], objArr[12], objArr[2], objArr[11], objArr[0], objArr[3], objArr[8], objArr[4], objArr[9], objArr[7], objArr[6]);
        this.v = -1;
        this.f23672a.setTag((Object) null);
        this.f23673b.setTag((Object) null);
        this.f23674c.setTag((Object) null);
        this.f23676e.setTag((Object) null);
        this.f23678g.setTag((Object) null);
        this.f23679h.setTag((Object) null);
        this.f23680i.setTag((Object) null);
        this.j.setTag((Object) null);
        this.k.setTag((Object) null);
        this.l.setTag((Object) null);
        this.m.setTag((Object) null);
        setRootTag(view);
        this.t = new a(this, 1);
        this.u = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.v = 16;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.v != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.U == i2) {
            this.n = (CJRFlightDetailsItem) obj;
            synchronized (this) {
                this.v |= 1;
            }
            notifyPropertyChanged(com.travel.flight.a.U);
            super.requestRebind();
        } else if (com.travel.flight.a.f23480d == i2) {
            this.q = (Integer) obj;
            synchronized (this) {
                this.v |= 2;
            }
            notifyPropertyChanged(com.travel.flight.a.f23480d);
            super.requestRebind();
        } else if (com.travel.flight.a.G == i2) {
            this.o = (IRTSplitViewModel) obj;
            synchronized (this) {
                this.v |= 4;
            }
            notifyPropertyChanged(com.travel.flight.a.G);
            super.requestRebind();
        } else if (com.travel.flight.a.f23485i != i2) {
            return false;
        } else {
            this.p = (Boolean) obj;
            synchronized (this) {
                this.v |= 8;
            }
            notifyPropertyChanged(com.travel.flight.a.f23485i);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        boolean z;
        String str2;
        boolean z2;
        CJRFlightsAdditionalInfo cJRFlightsAdditionalInfo;
        synchronized (this) {
            j = this.v;
            this.v = 0;
        }
        CJRFlightDetailsItem cJRFlightDetailsItem = this.n;
        int i2 = 0;
        String str3 = null;
        int i3 = ((j & 17) > 0 ? 1 : ((j & 17) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (cJRFlightDetailsItem != null) {
                str2 = cJRFlightDetailsItem.getmAirLine();
                cJRFlightsAdditionalInfo = cJRFlightDetailsItem.getAdditionalInfo();
                z = cJRFlightDetailsItem.isSelected();
                z2 = cJRFlightDetailsItem.isUnSelectable();
                str = cJRFlightDetailsItem.getmDuration();
            } else {
                str2 = null;
                cJRFlightsAdditionalInfo = null;
                str = null;
                z = false;
                z2 = false;
            }
            if (i3 != 0) {
                j |= z2 ? 64 : 32;
            }
            if (cJRFlightsAdditionalInfo != null) {
                str3 = cJRFlightsAdditionalInfo.getNextdayArrival();
            }
            if (!z2) {
                i2 = 8;
            }
        } else {
            str2 = null;
            str = null;
            z = false;
        }
        if ((j & 16) != 0) {
            this.f23672a.setOnClickListener(this.t);
            this.f23674c.setOnClickListener(this.u);
        }
        if ((j & 17) != 0) {
            d.a((TextView) this.f23673b, (CharSequence) str3);
            this.f23674c.setVisibility(i2);
            c.d(this.f23676e, cJRFlightDetailsItem);
            c.a(this.f23678g, Boolean.valueOf(z));
            d.a((TextView) this.f23679h, (CharSequence) str2);
            d.a((TextView) this.f23680i, (CharSequence) str);
            IRTViewModel.setAirlineCode(this.j, cJRFlightDetailsItem);
            IRTViewModel.setHopText(this.k, cJRFlightDetailsItem);
            IRTSplitViewModel.setOriginAndDestination(this.l, cJRFlightDetailsItem);
            IRTSplitViewModel.setFlightTime(this.m, cJRFlightDetailsItem);
        }
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            CJRFlightDetailsItem cJRFlightDetailsItem = this.n;
            Integer num = this.q;
            Boolean bool = this.p;
            IRTSplitViewModel iRTSplitViewModel = this.o;
            if (iRTSplitViewModel != null) {
                z = true;
            }
            if (z) {
                iRTSplitViewModel.onParentItemClick(cJRFlightDetailsItem, num.intValue(), bool.booleanValue(), true);
            }
        } else if (i2 == 2) {
            IRTSplitViewModel iRTSplitViewModel2 = this.o;
            if (iRTSplitViewModel2 != null) {
                z = true;
            }
            if (z && view != null) {
                view.getContext();
                iRTSplitViewModel2.onUnSelectableOverlayClick(view.getContext());
            }
        }
    }
}
