package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.e.a.a;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public final class aj extends ai implements a.C0456a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f23587f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f23588g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f23589h;

    /* renamed from: i  reason: collision with root package name */
    private long f23590i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23588g = sparseIntArray;
        sparseIntArray.put(R.id.no_network_message, 2);
        f23588g.put(R.id.no_network_title, 3);
    }

    public aj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f23587f, f23588g));
    }

    private aj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[0], objArr[2], objArr[3]);
        this.f23590i = -1;
        this.f23582a.setTag((Object) null);
        this.f23583b.setTag((Object) null);
        setRootTag(view);
        this.f23589h = new a(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23590i = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23590i != 0) {
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
        this.f23586e = sRPSharedViewModel;
        synchronized (this) {
            this.f23590i |= 1;
        }
        notifyPropertyChanged(com.travel.flight.a.f23479c);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f23590i;
            this.f23590i = 0;
        }
        if ((j & 2) != 0) {
            this.f23582a.setOnClickListener(this.f23589h);
        }
    }

    public final void a(int i2, View view) {
        SRPSharedViewModel sRPSharedViewModel = this.f23586e;
        if (sRPSharedViewModel != null) {
            sRPSharedViewModel.refresh(getRoot().getContext());
        }
    }
}
