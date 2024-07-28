package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ej extends ei implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29604f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29605g = null;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f29606h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f29607i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public ej(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f29604f, f29605g));
    }

    private ej(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.j = -1;
        this.f29599a.setTag((Object) null);
        this.f29606h = objArr[0];
        this.f29606h.setTag((Object) null);
        setRootTag(view);
        this.f29607i = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 16;
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
        if (a.B == i2) {
            b((String) obj);
        } else if (a.l == i2) {
            a((String) obj);
        } else if (a.f29093h == i2) {
            a((Integer) obj);
        } else if (a.N != i2) {
            return false;
        } else {
            a((PagerGalleryViewModel) obj);
        }
        return true;
    }

    public final void b(String str) {
        this.f29601c = str;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(a.B);
        super.requestRebind();
    }

    public final void a(String str) {
        this.f29600b = str;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(a.l);
        super.requestRebind();
    }

    public final void a(Integer num) {
        this.f29603e = num;
        synchronized (this) {
            this.j |= 4;
        }
        notifyPropertyChanged(a.f29093h);
        super.requestRebind();
    }

    public final void a(PagerGalleryViewModel pagerGalleryViewModel) {
        this.f29602d = pagerGalleryViewModel;
        synchronized (this) {
            this.j |= 8;
        }
        notifyPropertyChanged(a.N);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        if ((j2 & 16) != 0) {
            this.f29599a.setOnClickListener(this.f29607i);
        }
    }

    public final void a(int i2) {
        String str = this.f29601c;
        String str2 = this.f29600b;
        Integer num = this.f29603e;
        PagerGalleryViewModel pagerGalleryViewModel = this.f29602d;
        if (pagerGalleryViewModel != null) {
            pagerGalleryViewModel.openGalleryPagerFragment(str2, str, num.intValue());
        }
    }
}
