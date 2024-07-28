package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class dv extends du implements b.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29532e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29533f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29534g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29535h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f29536i;
    private long j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29533f = sparseIntArray;
        sparseIntArray.put(R.id.tv_total_tax, 3);
    }

    public dv(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29532e, f29533f));
    }

    private dv(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1], objArr[3]);
        this.j = -1;
        this.f29534g = objArr[0];
        this.f29534g.setTag((Object) null);
        this.f29528a.setTag((Object) null);
        this.f29529b.setTag((Object) null);
        setRootTag(view);
        this.f29535h = new b(this, 1);
        this.f29536i = new b(this, 2);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((RoomSelectionViewModel) obj);
        return true;
    }

    public final void a(RoomSelectionViewModel roomSelectionViewModel) {
        this.f29531d = roomSelectionViewModel;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return b(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        double d2 = 0.0d;
        RoomSelectionViewModel roomSelectionViewModel = this.f29531d;
        int i2 = ((7 & j2) > 0 ? 1 : ((7 & j2) == 0 ? 0 : -1));
        if (i2 != 0) {
            Double d3 = null;
            y<Double> yVar = roomSelectionViewModel != null ? roomSelectionViewModel.get_selectedRoomFinalPriceWithTax() : null;
            updateLiveDataRegistration(0, yVar);
            if (yVar != null) {
                d3 = yVar.getValue();
            }
            d2 = ViewDataBinding.safeUnbox(d3);
        }
        if ((j2 & 4) != 0) {
            this.f29528a.setOnClickListener(this.f29536i);
            this.f29529b.setOnClickListener(this.f29535h);
        }
        if (i2 != 0) {
            net.one97.paytm.hotel4.utils.a.a(this.f29529b, d2);
        }
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            RoomSelectionViewModel roomSelectionViewModel = this.f29531d;
            if (roomSelectionViewModel != null) {
                z = true;
            }
            if (z) {
                roomSelectionViewModel.onFareBreakupPressed();
            }
        } else if (i2 == 2) {
            RoomSelectionViewModel roomSelectionViewModel2 = this.f29531d;
            if (roomSelectionViewModel2 != null) {
                z = true;
            }
            if (z) {
                roomSelectionViewModel2.onContinuePressed();
            }
        }
    }
}
