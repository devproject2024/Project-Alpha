package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.h;
import androidx.databinding.i;
import com.travel.flight.a;
import com.travel.flight.flightSRPV2.a.d;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.pojo.flightticket.CJRFilterAndBannerInfoItem;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import java.util.List;

public final class cx extends cw {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f23872f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f23873g = null;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f23874h;

    /* renamed from: i  reason: collision with root package name */
    private long f23875i;

    public cx(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f23872f, f23873g));
    }

    private cx(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[2]);
        this.f23875i = -1;
        this.f23867a.setTag((Object) null);
        this.f23868b.setTag((Object) null);
        this.f23869c.setTag((Object) null);
        this.f23874h = objArr[0];
        this.f23874h.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23875i = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23875i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.x == i2) {
            this.f23870d = (CJRFlightDetailsItem) obj;
            synchronized (this) {
                this.f23875i |= 2;
            }
            notifyPropertyChanged(a.x);
            super.requestRebind();
        } else if (a.p != i2) {
            return false;
        } else {
            this.f23871e = (SRPOneWayViewModel) obj;
            synchronized (this) {
                this.f23875i |= 4;
            }
            notifyPropertyChanged(a.p);
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
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.f23875i |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        int i2;
        String str;
        List<d> list;
        CJRFilterAndBannerInfoItem cJRFilterAndBannerInfoItem;
        synchronized (this) {
            j = this.f23875i;
            this.f23875i = 0;
        }
        CJRFlightDetailsItem cJRFlightDetailsItem = this.f23870d;
        SRPOneWayViewModel sRPOneWayViewModel = this.f23871e;
        int i3 = 0;
        if ((15 & j) != 0) {
            if ((j & 10) != 0) {
                if (cJRFlightDetailsItem != null) {
                    list = cJRFlightDetailsItem.getFilterAirlinePriceList();
                    cJRFilterAndBannerInfoItem = cJRFlightDetailsItem.getmListItemData();
                    i2 = cJRFlightDetailsItem.getPosState();
                } else {
                    list = null;
                    cJRFilterAndBannerInfoItem = null;
                    i2 = 0;
                }
                str = cJRFilterAndBannerInfoItem != null ? cJRFilterAndBannerInfoItem.getmHeading() : null;
            } else {
                list = null;
                str = null;
                i2 = 0;
            }
            int i4 = ((j & 11) > 0 ? 1 : ((j & 11) == 0 ? 0 : -1));
            if (i4 != 0) {
                i<Boolean> isFilterRangeChanged = cJRFlightDetailsItem != null ? cJRFlightDetailsItem.getIsFilterRangeChanged() : null;
                updateRegistration(0, (h) isFilterRangeChanged);
                boolean safeUnbox = ViewDataBinding.safeUnbox(isFilterRangeChanged != null ? isFilterRangeChanged.get() : null);
                if (i4 != 0) {
                    j |= safeUnbox ? 32 : 16;
                }
                if (!safeUnbox) {
                    i3 = 8;
                }
            }
        } else {
            list = null;
            str = null;
            i2 = 0;
        }
        int i5 = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
        SRPSharedViewModel parentViewModel = (i5 == 0 || sRPOneWayViewModel == null) ? null : sRPOneWayViewModel.getParentViewModel();
        if ((10 & j) != 0) {
            androidx.databinding.a.d.a(this.f23867a, (CharSequence) str);
            c.a(this.f23869c, list);
            c.a((View) this.f23874h, Integer.valueOf(i2));
        }
        if ((j & 11) != 0) {
            this.f23868b.setVisibility(i3);
        }
        if (i5 != 0) {
            c.c(this.f23868b, parentViewModel, cJRFlightDetailsItem);
        }
    }
}
