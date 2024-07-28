package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.PagerGalleryViewModel;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class fl extends fk implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29726f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29727g = null;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f29728h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f29729i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public fl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f29726f, f29727g));
    }

    private fl(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.j = -1;
        this.f29721a.setTag((Object) null);
        this.f29728h = objArr[0];
        this.f29728h.setTag((Object) null);
        setRootTag(view);
        this.f29729i = new b(this, 1);
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
        } else if (a.J == i2) {
            this.f29723c = (Drawable) obj;
        } else if (a.t != i2) {
            return false;
        } else {
            a((PagerGalleryViewModel) obj);
        }
        return true;
    }

    public final void b(String str) {
        this.f29724d = str;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(a.B);
        super.requestRebind();
    }

    public final void a(String str) {
        this.f29722b = str;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(a.l);
        super.requestRebind();
    }

    public final void a(PagerGalleryViewModel pagerGalleryViewModel) {
        this.f29725e = pagerGalleryViewModel;
        synchronized (this) {
            this.j |= 8;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        if ((j2 & 16) != 0) {
            this.f29721a.setOnClickListener(this.f29729i);
        }
    }

    public final void a(int i2) {
        String str = this.f29724d;
        String str2 = this.f29722b;
        PagerGalleryViewModel pagerGalleryViewModel = this.f29725e;
        if (pagerGalleryViewModel != null) {
            pagerGalleryViewModel.openGalleryPagerFragment(str2, str, -1);
        }
    }
}
