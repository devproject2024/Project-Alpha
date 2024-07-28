package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.flightSRPV2.a.l;
import com.travel.flight.flightSRPV2.c.b;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;

public final class cn extends cm {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f23828f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f23829g;

    /* renamed from: h  reason: collision with root package name */
    private long f23830h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23829g = sparseIntArray;
        sparseIntArray.put(R.id.fare_alert_view, 3);
    }

    public cn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f23828f, f23829g));
    }

    private cn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[3], objArr[1], objArr[0]);
        this.f23830h = -1;
        this.f23823a.setTag((Object) null);
        this.f23825c.setTag((Object) null);
        this.f23826d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23830h = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23830h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f23479c != i2) {
            return false;
        }
        a((SRPSharedViewModel) obj);
        return true;
    }

    public final void a(SRPSharedViewModel sRPSharedViewModel) {
        this.f23827e = sRPSharedViewModel;
        synchronized (this) {
            this.f23830h |= 4;
        }
        notifyPropertyChanged(a.f23479c);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return b(i3);
    }

    private boolean a(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.f23830h |= 1;
        }
        return true;
    }

    private boolean b(int i2) {
        if (i2 != a.f23477a) {
            return false;
        }
        synchronized (this) {
            this.f23830h |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        l lVar;
        y<CJRFlightSearchInput> yVar;
        b<l> bVar;
        com.travel.flight.pojo.flightticket.b bVar2;
        com.travel.flight.pojo.flightticket.b bVar3;
        synchronized (this) {
            j = this.f23830h;
            this.f23830h = 0;
        }
        SRPSharedViewModel sRPSharedViewModel = this.f23827e;
        String str2 = null;
        int i2 = ((15 & j) > 0 ? 1 : ((15 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (sRPSharedViewModel != null) {
                yVar = sRPSharedViewModel.getSearchInput();
                bVar = sRPSharedViewModel.getFareAlertEvent();
            } else {
                bVar = null;
                yVar = null;
            }
            updateLiveDataRegistration(0, yVar);
            updateLiveDataRegistration(1, bVar);
            CJRFlightSearchInput value = yVar != null ? yVar.getValue() : null;
            lVar = bVar != null ? bVar.getValue() : null;
            if (value != null) {
                bVar2 = value.getSource();
                bVar3 = value.getDestination();
            } else {
                bVar3 = null;
                bVar2 = null;
            }
            str = bVar2 != null ? bVar2.getCityName() : null;
            if (bVar3 != null) {
                str2 = bVar3.getCityName();
            }
        } else {
            lVar = null;
            str = null;
        }
        if (i2 != 0) {
            c.a((TextView) this.f23823a, lVar, str, str2);
        }
        if ((j & 14) != 0) {
            c.a(this.f23825c, lVar);
        }
    }
}
