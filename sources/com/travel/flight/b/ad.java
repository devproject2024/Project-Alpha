package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.FlightFilterHomeViewModel;

public final class ad extends ac implements a.C0456a {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f23562i = null;
    private static final SparseIntArray j;
    private final ConstraintLayout k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.text_view_filter_header, 4);
        j.put(R.id.tab_lyt_flight_filters, 5);
        j.put(R.id.view_separator, 6);
        j.put(R.id.viewpager_flight_filter, 7);
    }

    public ad(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f23562i, j));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ad(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[5], objArr[4], objArr[3], objArr[6], objArr[7]);
        this.o = -1;
        this.f23554a.setTag((Object) null);
        this.f23555b.setTag((Object) null);
        this.k = objArr[0];
        this.k.setTag((Object) null);
        this.f23558e.setTag((Object) null);
        setRootTag(view);
        this.l = new a(this, 3);
        this.m = new a(this, 1);
        this.n = new a(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.o = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.o != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (com.travel.flight.a.f23479c != i2) {
            return false;
        }
        a((FlightFilterHomeViewModel) obj);
        return true;
    }

    public final void a(FlightFilterHomeViewModel flightFilterHomeViewModel) {
        this.f23561h = flightFilterHomeViewModel;
        synchronized (this) {
            this.o |= 2;
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
            this.o |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.o;
            this.o = 0;
        }
        FlightFilterHomeViewModel flightFilterHomeViewModel = this.f23561h;
        int i2 = 0;
        int i3 = ((j2 & 7) > 0 ? 1 : ((j2 & 7) == 0 ? 0 : -1));
        if (i3 != 0) {
            Boolean bool = null;
            LiveData<Boolean> areFiltersChanged = flightFilterHomeViewModel != null ? flightFilterHomeViewModel.areFiltersChanged() : null;
            updateLiveDataRegistration(0, areFiltersChanged);
            if (areFiltersChanged != null) {
                bool = areFiltersChanged.getValue();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j2 |= safeUnbox ? 16 : 8;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        }
        if ((4 & j2) != 0) {
            this.f23554a.setOnClickListener(this.m);
            this.f23555b.setOnClickListener(this.n);
            this.f23558e.setOnClickListener(this.l);
        }
        if ((j2 & 7) != 0) {
            this.f23554a.setVisibility(i2);
        }
    }

    public final void a(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            FlightFilterHomeViewModel flightFilterHomeViewModel = this.f23561h;
            if (flightFilterHomeViewModel != null) {
                z = true;
            }
            if (z) {
                flightFilterHomeViewModel.onApplyFilterClick();
            }
        } else if (i2 == 2) {
            FlightFilterHomeViewModel flightFilterHomeViewModel2 = this.f23561h;
            if (flightFilterHomeViewModel2 != null) {
                z = true;
            }
            if (z) {
                flightFilterHomeViewModel2.onCloseClick();
            }
        } else if (i2 == 3) {
            FlightFilterHomeViewModel flightFilterHomeViewModel3 = this.f23561h;
            if (flightFilterHomeViewModel3 != null) {
                z = true;
            }
            if (z) {
                flightFilterHomeViewModel3.onResetClick();
            }
        }
    }
}
