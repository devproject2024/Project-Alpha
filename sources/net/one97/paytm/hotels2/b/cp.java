package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class cp extends co implements b.a {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f29396h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f29397i;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private long n;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29397i = sparseIntArray;
        sparseIntArray.put(R.id.iv_no_room, 4);
        f29397i.put(R.id.tv_no_room, 5);
        f29397i.put(R.id.tv_no_room_desc, 6);
    }

    public cp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f29396h, f29397i));
    }

    private cp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[4], objArr[2], objArr[5], objArr[6], objArr[3]);
        this.n = -1;
        this.f29389a.setTag((Object) null);
        this.j = objArr[0];
        this.j.setTag((Object) null);
        this.f29391c.setTag((Object) null);
        this.f29394f.setTag((Object) null);
        setRootTag(view);
        this.k = new b(this, 2);
        this.l = new b(this, 3);
        this.m = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.n = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.n != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((DetailsViewModel) obj);
        return true;
    }

    public final void a(DetailsViewModel detailsViewModel) {
        this.f29395g = detailsViewModel;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.n;
            this.n = 0;
        }
        if ((j2 & 2) != 0) {
            this.f29389a.setOnClickListener(this.m);
            this.f29391c.setOnClickListener(this.k);
            this.f29394f.setOnClickListener(this.l);
        }
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            DetailsViewModel detailsViewModel = this.f29395g;
            if (detailsViewModel != null) {
                z = true;
            }
            if (z) {
                detailsViewModel.closeButtonNoRoomsPressed();
            }
        } else if (i2 == 2) {
            DetailsViewModel detailsViewModel2 = this.f29395g;
            if (detailsViewModel2 != null) {
                z = true;
            }
            if (z) {
                detailsViewModel2.closeButtonNoRoomsPressed();
            }
        } else if (i2 == 3) {
            DetailsViewModel detailsViewModel3 = this.f29395g;
            if (detailsViewModel3 != null) {
                z = true;
            }
            if (z) {
                detailsViewModel3.onSearchOtherHotel();
            }
        }
    }
}
