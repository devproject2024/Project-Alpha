package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.filter.SRPFilterViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class al extends ak implements b.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29153e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29154f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29155g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29156h;

    /* renamed from: i  reason: collision with root package name */
    private long f29157i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29154f = sparseIntArray;
        sparseIntArray.put(R.id.right_arrow, 3);
    }

    public al(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29153e, f29154f));
    }

    private al(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[3], objArr[1]);
        this.f29157i = -1;
        this.f29149a.setTag((Object) null);
        this.f29155g = objArr[0];
        this.f29155g.setTag((Object) null);
        this.f29151c.setTag((Object) null);
        setRootTag(view);
        this.f29156h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29157i = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29157i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f29088c != i2) {
            return false;
        }
        a((SRPFilterViewModel) obj);
        return true;
    }

    public final void a(SRPFilterViewModel sRPFilterViewModel) {
        this.f29152d = sRPFilterViewModel;
        synchronized (this) {
            this.f29157i |= 2;
        }
        notifyPropertyChanged(a.f29088c);
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
            this.f29157i |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f29157i;
            this.f29157i = 0;
        }
        SRPFilterViewModel sRPFilterViewModel = this.f29152d;
        int i2 = 0;
        String str2 = null;
        int i3 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i3 != 0) {
            y<Integer> filterCountHotelTheme = sRPFilterViewModel != null ? sRPFilterViewModel.getFilterCountHotelTheme() : null;
            updateLiveDataRegistration(0, filterCountHotelTheme);
            int safeUnbox = ViewDataBinding.safeUnbox(filterCountHotelTheme != null ? filterCountHotelTheme.getValue() : null);
            str = String.valueOf(safeUnbox);
            boolean z = safeUnbox > 0;
            if (i3 != 0) {
                j |= z ? 16 : 8;
            }
            if (!z) {
                i2 = 8;
            }
            if (!((j & 6) == 0 || sRPFilterViewModel == null)) {
                str2 = sRPFilterViewModel.getFilterHotelThemeTitle();
            }
        } else {
            str = null;
        }
        if ((j & 7) != 0) {
            d.a(this.f29149a, (CharSequence) str);
            this.f29149a.setVisibility(i2);
        }
        if ((4 & j) != 0) {
            this.f29155g.setOnClickListener(this.f29156h);
        }
        if ((j & 6) != 0) {
            d.a(this.f29151c, (CharSequence) str2);
        }
    }

    public final void a(int i2) {
        SRPFilterViewModel sRPFilterViewModel = this.f29152d;
        if (sRPFilterViewModel != null) {
            sRPFilterViewModel.onScreenClick(sRPFilterViewModel.getFilterHotelThemeTitle());
        }
    }
}
