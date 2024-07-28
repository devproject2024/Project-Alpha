package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.HotelSearchViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class gn extends gm implements b.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29854e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29855f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29856g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29857h;

    /* renamed from: i  reason: collision with root package name */
    private long f29858i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29855f = sparseIntArray;
        sparseIntArray.put(R.id.imageButton, 2);
        f29855f.put(R.id.title, 3);
    }

    public gn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29854e, f29855f));
    }

    private gn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1], objArr[3]);
        this.f29858i = -1;
        this.f29856g = objArr[0];
        this.f29856g.setTag((Object) null);
        this.f29851b.setTag((Object) null);
        setRootTag(view);
        this.f29857h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29858i = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29858i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((HotelSearchViewModel) obj);
        return true;
    }

    public final void a(HotelSearchViewModel hotelSearchViewModel) {
        this.f29853d = hotelSearchViewModel;
        synchronized (this) {
            this.f29858i |= 2;
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
            this.f29858i |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29858i;
            this.f29858i = 0;
        }
        HotelSearchViewModel hotelSearchViewModel = this.f29853d;
        String str = null;
        int i2 = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i2 != 0) {
            y<String> currentCityName = hotelSearchViewModel != null ? hotelSearchViewModel.getCurrentCityName() : null;
            updateLiveDataRegistration(0, currentCityName);
            if (currentCityName != null) {
                str = currentCityName.getValue();
            }
        }
        if ((j & 4) != 0) {
            this.f29856g.setOnClickListener(this.f29857h);
        }
        if (i2 != 0) {
            d.a(this.f29851b, (CharSequence) str);
        }
    }

    public final void a(int i2) {
        HotelSearchViewModel hotelSearchViewModel = this.f29853d;
        if (hotelSearchViewModel != null) {
            hotelSearchViewModel.getCurrentLocation();
        }
    }
}
