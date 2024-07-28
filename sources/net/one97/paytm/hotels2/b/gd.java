package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class gd extends gc implements b.a {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f29808d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f29809e;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f29810f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f29811g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29812h;

    /* renamed from: i  reason: collision with root package name */
    private long f29813i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29809e = sparseIntArray;
        sparseIntArray.put(R.id.tv_selected_city_name, 2);
    }

    public gd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29808d, f29809e));
    }

    private gd(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2]);
        this.f29813i = -1;
        this.f29810f = objArr[0];
        this.f29810f.setTag((Object) null);
        this.f29811g = objArr[1];
        this.f29811g.setTag((Object) null);
        setRootTag(view);
        this.f29812h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29813i = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29813i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.X == i2) {
            a((SRPViewModel) obj);
        } else if (a.H != i2) {
            return false;
        } else {
            a((String) obj);
        }
        return true;
    }

    public final void a(SRPViewModel sRPViewModel) {
        this.f29807c = sRPViewModel;
        synchronized (this) {
            this.f29813i |= 1;
        }
        notifyPropertyChanged(a.X);
        super.requestRebind();
    }

    public final void a(String str) {
        this.f29806b = str;
        synchronized (this) {
            this.f29813i |= 2;
        }
        notifyPropertyChanged(a.H);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29813i;
            this.f29813i = 0;
        }
        if ((j & 4) != 0) {
            this.f29811g.setOnClickListener(this.f29812h);
        }
    }

    public final void a(int i2) {
        SRPViewModel sRPViewModel = this.f29807c;
        String str = this.f29806b;
        if (sRPViewModel != null) {
            sRPViewModel.selectedLocationSelected(str);
        }
    }
}
