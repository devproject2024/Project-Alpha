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

public final class z extends y implements b.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29964e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29965f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29966g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29967h;

    /* renamed from: i  reason: collision with root package name */
    private long f29968i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29965f = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 2);
        f29965f.put(R.id.rv_bullet_policies_list, 3);
    }

    public z(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29964e, f29965f));
    }

    private z(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[2], objArr[1]);
        this.f29968i = -1;
        this.f29966g = objArr[0];
        this.f29966g.setTag((Object) null);
        this.f29962c.setTag((Object) null);
        setRootTag(view);
        this.f29967h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29968i = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29968i != 0) {
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
        this.f29963d = detailsViewModel;
        synchronized (this) {
            this.f29968i |= 2;
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
            this.f29968i |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29968i;
            this.f29968i = 0;
        }
        DetailsViewModel detailsViewModel = this.f29963d;
        int i2 = 0;
        int i3 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i3 != 0) {
            Boolean bool = null;
            y<Boolean> yVar = detailsViewModel != null ? detailsViewModel.get_showHotelPolicyViewAll() : null;
            updateLiveDataRegistration(0, yVar);
            if (yVar != null) {
                bool = yVar.getValue();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 16 : 8;
            }
            if (!safeUnbox) {
                i2 = 8;
            }
        }
        if ((4 & j) != 0) {
            this.f29962c.setOnClickListener(this.f29967h);
        }
        if ((j & 7) != 0) {
            this.f29962c.setVisibility(i2);
        }
    }

    public final void a(int i2) {
        DetailsViewModel detailsViewModel = this.f29963d;
        if (detailsViewModel != null) {
            detailsViewModel.onHotelPolicyViewAllPressed();
        }
    }
}
