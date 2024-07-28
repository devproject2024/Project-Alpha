package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class n extends m implements b.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29910e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29911f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29912g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29913h;

    /* renamed from: i  reason: collision with root package name */
    private long f29914i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29911f = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
    }

    public n(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29910e, f29911f));
    }

    private n(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[3]);
        this.f29914i = -1;
        this.f29912g = objArr[0];
        this.f29912g.setTag((Object) null);
        this.f29906a.setTag((Object) null);
        this.f29907b.setTag((Object) null);
        setRootTag(view);
        this.f29913h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29914i = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29914i != 0) {
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
        this.f29909d = detailsViewModel;
        synchronized (this) {
            this.f29914i |= 4;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b(i3);
        }
        if (i2 != 1) {
            return false;
        }
        return c(i3);
    }

    private boolean b(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29914i |= 1;
        }
        return true;
    }

    private boolean c(int i2) {
        if (i2 != a.f29086a) {
            return false;
        }
        synchronized (this) {
            this.f29914i |= 2;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29914i;
            this.f29914i = 0;
        }
        DetailsViewModel detailsViewModel = this.f29909d;
        int i2 = 0;
        String str = null;
        if ((15 & j) != 0) {
            int i3 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
            if (i3 != 0) {
                y<Boolean> yVar = detailsViewModel != null ? detailsViewModel.get_showReadMoreAboutHotel() : null;
                updateLiveDataRegistration(0, yVar);
                boolean safeUnbox = ViewDataBinding.safeUnbox(yVar != null ? yVar.getValue() : null);
                if (i3 != 0) {
                    j |= safeUnbox ? 32 : 16;
                }
                if (!safeUnbox) {
                    i2 = 8;
                }
            }
            if ((j & 14) != 0) {
                y<String> yVar2 = detailsViewModel != null ? detailsViewModel.get_aboutShortened() : null;
                updateLiveDataRegistration(1, yVar2);
                if (yVar2 != null) {
                    str = yVar2.getValue();
                }
            }
        }
        if ((j & 14) != 0) {
            d.a(this.f29906a, (CharSequence) str);
        }
        if ((8 & j) != 0) {
            this.f29907b.setOnClickListener(this.f29913h);
        }
        if ((j & 13) != 0) {
            this.f29907b.setVisibility(i2);
        }
    }

    public final void a(int i2) {
        DetailsViewModel detailsViewModel = this.f29909d;
        if (detailsViewModel != null) {
            detailsViewModel.onAboutHotelPressed();
        }
    }
}
