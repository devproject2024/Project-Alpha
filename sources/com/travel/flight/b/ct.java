package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.SRPModifyViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.b;

public final class ct extends cs implements a.C0456a {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f23856h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f23857i = null;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private long l;

    public ct(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f23856h, f23857i));
    }

    private ct(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[1], objArr[6], objArr[3], objArr[5], objArr[2]);
        this.l = -1;
        this.f23849a.setTag((Object) null);
        this.f23850b.setTag((Object) null);
        this.f23851c.setTag((Object) null);
        this.j = objArr[0];
        this.j.setTag((Object) null);
        this.f23852d.setTag((Object) null);
        this.f23853e.setTag((Object) null);
        this.f23854f.setTag((Object) null);
        setRootTag(view);
        this.k = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.f23479c != i2) {
            return false;
        }
        a((SRPSharedViewModel) obj);
        return true;
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.f23855g = sRPSharedViewModel;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return a(i3);
    }

    private boolean a(int i2) {
        if (i2 != com.travel.flight.a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        String str;
        CJRFlightSearchInput cJRFlightSearchInput;
        b bVar;
        b bVar2;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        SRPSharedViewModel sRPSharedViewModel = this.f23855g;
        String str2 = null;
        int i2 = ((7 & j2) > 0 ? 1 : ((7 & j2) == 0 ? 0 : -1));
        if (i2 != 0) {
            y<CJRFlightSearchInput> searchInput = sRPSharedViewModel != null ? sRPSharedViewModel.getSearchInput() : null;
            updateLiveDataRegistration(0, searchInput);
            cJRFlightSearchInput = searchInput != null ? searchInput.getValue() : null;
            if (cJRFlightSearchInput != null) {
                bVar2 = cJRFlightSearchInput.getSource();
                bVar = cJRFlightSearchInput.getDestination();
            } else {
                bVar2 = null;
                bVar = null;
            }
            str = bVar2 != null ? bVar2.getCityName() : null;
            if (bVar != null) {
                str2 = bVar.getCityName();
            }
        } else {
            cJRFlightSearchInput = null;
            str = null;
        }
        if (i2 != 0) {
            SRPModifyViewModel.setRouteHeader(this.f23849a, cJRFlightSearchInput);
            c.a((TextView) this.f23852d, cJRFlightSearchInput);
            d.a((TextView) this.f23853e, (CharSequence) str2);
            d.a((TextView) this.f23854f, (CharSequence) str);
        }
        if ((4 & j2) != 0) {
            this.f23850b.setOnClickListener(this.k);
        }
        if ((j2 & 6) != 0) {
            c.c(this.f23851c, sRPSharedViewModel);
        }
    }

    public final void a(int i2, View view) {
        SRPSharedViewModel sRPSharedViewModel = this.f23855g;
        if (sRPSharedViewModel != null) {
            sRPSharedViewModel.onBackPressedLoaderFragment();
        }
    }
}
