package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.pojo.ModifiedParentOrder;

public final class bh extends bg {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f23693d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f23694e;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f23695f;

    /* renamed from: g  reason: collision with root package name */
    private long f23696g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23694e = sparseIntArray;
        sparseIntArray.put(R.id.viewNewBooking, 2);
    }

    public bh(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f23693d, f23694e));
    }

    private bh(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f23696g = -1;
        this.f23690a.setTag((Object) null);
        this.f23695f = objArr[0];
        this.f23695f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23696g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23696g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.z != i2) {
            return false;
        }
        this.f23692c = (ModifiedParentOrder) obj;
        return true;
    }

    public final void a(ModifiedParentOrder modifiedParentOrder) {
        this.f23692c = modifiedParentOrder;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f23696g;
            this.f23696g = 0;
        }
        if ((j & 2) != 0) {
            com.travel.flight.flightticket.b.a.a(this.f23690a, getRoot().getContext());
        }
    }
}
