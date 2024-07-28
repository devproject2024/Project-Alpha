package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.pojo.flightticket.CJRFilterAndBannerInfoItem;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public final class cz extends cy implements a.C0456a {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f23879d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f23880e = null;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnClickListener f23881f;

    /* renamed from: g  reason: collision with root package name */
    private long f23882g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public cz(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f23879d, f23880e));
    }

    private cz(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0]);
        this.f23882g = -1;
        this.f23876a.setTag((Object) null);
        setRootTag(view);
        this.f23881f = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23882g = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23882g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.p == i2) {
            this.f23878c = (SRPOneWayViewModel) obj;
            synchronized (this) {
                this.f23882g |= 1;
            }
            notifyPropertyChanged(com.travel.flight.a.p);
            super.requestRebind();
        } else if (com.travel.flight.a.x != i2) {
            return false;
        } else {
            this.f23877b = (CJRFlightDetailsItem) obj;
            synchronized (this) {
                this.f23882g |= 2;
            }
            notifyPropertyChanged(com.travel.flight.a.x);
            super.requestRebind();
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        int i2;
        CJRFilterAndBannerInfoItem cJRFilterAndBannerInfoItem;
        synchronized (this) {
            j = this.f23882g;
            this.f23882g = 0;
        }
        CJRFlightDetailsItem cJRFlightDetailsItem = this.f23877b;
        String str = null;
        int i3 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (cJRFlightDetailsItem != null) {
                cJRFilterAndBannerInfoItem = cJRFlightDetailsItem.getmListItemData();
                i2 = cJRFlightDetailsItem.getPosState();
            } else {
                cJRFilterAndBannerInfoItem = null;
                i2 = 0;
            }
            if (cJRFilterAndBannerInfoItem != null) {
                str = cJRFilterAndBannerInfoItem.getmBannerUrl();
            }
        } else {
            i2 = 0;
        }
        if ((j & 4) != 0) {
            this.f23876a.setOnClickListener(this.f23881f);
        }
        if (i3 != 0) {
            c.a((View) this.f23876a, Integer.valueOf(i2));
            c.b(this.f23876a, str, getDrawableFromResource(this.f23876a, R.drawable.pre_f_image_placeholder_flight_banner), getDrawableFromResource(this.f23876a, R.drawable.pre_f_image_placeholder_flight_banner));
        }
    }

    public final void a(int i2, View view) {
        SRPOneWayViewModel sRPOneWayViewModel = this.f23878c;
        CJRFlightDetailsItem cJRFlightDetailsItem = this.f23877b;
        boolean z = true;
        if (sRPOneWayViewModel != null) {
            if (cJRFlightDetailsItem != null) {
                CJRFilterAndBannerInfoItem cJRFilterAndBannerInfoItem = cJRFlightDetailsItem.getmListItemData();
                if (cJRFilterAndBannerInfoItem == null) {
                    z = false;
                }
                if (z) {
                    sRPOneWayViewModel.metaBannerClicked(cJRFilterAndBannerInfoItem.getmBannerUrlInfo());
                }
            }
        }
    }
}
