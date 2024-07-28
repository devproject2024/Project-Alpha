package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.travel.flight.a;
import com.travel.flight.flightSRPV2.a.t;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightSRPV2.a.z;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import java.util.List;

public final class cj extends ci {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f23811c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f23812d = null;

    /* renamed from: e  reason: collision with root package name */
    private long f23813e;

    public cj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f23811c, f23812d));
    }

    private cj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0]);
        this.f23813e = -1;
        this.f23809a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23813e = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23813e != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.p != i2) {
            return false;
        }
        this.f23810b = (SRPOneWayViewModel) obj;
        synchronized (this) {
            this.f23813e |= 2;
        }
        notifyPropertyChanged(a.p);
        super.requestRebind();
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
            this.f23813e |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        SRPSharedViewModel sRPSharedViewModel;
        synchronized (this) {
            j = this.f23813e;
            this.f23813e = 0;
        }
        SRPOneWayViewModel sRPOneWayViewModel = this.f23810b;
        List<x> list = null;
        int i2 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i2 != 0) {
            sRPSharedViewModel = sRPOneWayViewModel != null ? sRPOneWayViewModel.getParentViewModel() : null;
            y<List<x>> onwardFilterList = sRPSharedViewModel != null ? sRPSharedViewModel.getOnwardFilterList() : null;
            updateLiveDataRegistration(0, onwardFilterList);
            if (onwardFilterList != null) {
                list = onwardFilterList.getValue();
            }
            list = t.a((List<? extends x>) list);
        } else {
            sRPSharedViewModel = null;
        }
        if (i2 != 0) {
            c.a(this.f23809a, (List<? extends x>) list, (z) sRPSharedViewModel);
        }
    }
}
