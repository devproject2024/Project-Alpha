package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.R;
import com.travel.flight.a;
import com.travel.flight.flightSRPV2.c.c;
import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;

public final class dn extends dm {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f23945h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f23946i;
    private final ConstraintLayout j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f23946i = sparseIntArray;
        sparseIntArray.put(R.id.filter_icon, 1);
        f23946i.put(R.id.filter_text, 2);
        f23946i.put(R.id.list_filter_by_left, 3);
        f23946i.put(R.id.tip_lyt, 4);
        f23946i.put(R.id.header_cheapest_text, 5);
        f23946i.put(R.id.per_person_text, 6);
    }

    public dn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f23945h, f23946i));
    }

    private dn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[5], objArr[3], objArr[6], objArr[4]);
        this.k = -1;
        this.j = objArr[0];
        this.j.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.k != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.x != i2) {
            return false;
        }
        this.f23944g = (CJRFlightDetailsItem) obj;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(a.x);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.k;
            this.k = 0;
        }
        CJRFlightDetailsItem cJRFlightDetailsItem = this.f23944g;
        int i2 = 0;
        int i3 = ((j2 & 3) > 0 ? 1 : ((j2 & 3) == 0 ? 0 : -1));
        if (!(i3 == 0 || cJRFlightDetailsItem == null)) {
            i2 = cJRFlightDetailsItem.getPosState();
        }
        if (i3 != 0) {
            c.a((View) this.j, Integer.valueOf(i2));
        }
    }
}
