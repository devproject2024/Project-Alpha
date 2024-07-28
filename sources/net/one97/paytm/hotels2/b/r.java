package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class r extends q implements b.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29928e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29929f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29930g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29931h;

    /* renamed from: i  reason: collision with root package name */
    private long f29932i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29929f = sparseIntArray;
        sparseIntArray.put(R.id.tv_header, 2);
        f29929f.put(R.id.rv_amnts, 3);
    }

    public r(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29928e, f29929f));
    }

    private r(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[2], objArr[1]);
        this.f29932i = -1;
        this.f29930g = objArr[0];
        this.f29930g.setTag((Object) null);
        this.f29926c.setTag((Object) null);
        setRootTag(view);
        this.f29931h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29932i = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29932i != 0) {
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
        this.f29927d = detailsViewModel;
        synchronized (this) {
            this.f29932i |= 2;
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
            this.f29932i |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29932i;
            this.f29932i = 0;
        }
        DetailsViewModel detailsViewModel = this.f29927d;
        int i2 = 0;
        int i3 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i3 != 0) {
            Boolean bool = null;
            y<Boolean> yVar = detailsViewModel != null ? detailsViewModel.get_showAmenitiesViewAll() : null;
            updateLiveDataRegistration(0, yVar);
            if (yVar != null) {
                bool = yVar.getValue();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 16 : 8;
            }
            if (!safeUnbox) {
                i2 = 4;
            }
        }
        if ((4 & j) != 0) {
            this.f29926c.setOnClickListener(this.f29931h);
        }
        if ((j & 7) != 0) {
            this.f29926c.setVisibility(i2);
        }
    }

    public final void a(int i2) {
        DetailsViewModel detailsViewModel = this.f29927d;
        if (detailsViewModel != null) {
            detailsViewModel.onAmenitiesViewAllPressed();
        }
    }
}
