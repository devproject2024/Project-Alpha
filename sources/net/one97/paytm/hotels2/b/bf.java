package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import androidx.lifecycle.y;
import net.one97.paytm.hotel4.viewmodel.DetailsViewModel;
import net.one97.paytm.hotel4.viewmodel.GalleryViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class bf extends be implements b.a {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f29244g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f29245h;

    /* renamed from: i  reason: collision with root package name */
    private final Toolbar f29246i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private long l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29245h = sparseIntArray;
        sparseIntArray.put(R.id.textView2, 4);
    }

    public bf(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29244g, f29245h));
    }

    private bf(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[4], objArr[2]);
        this.l = -1;
        this.f29238a.setTag((Object) null);
        this.f29239b.setTag((Object) null);
        this.f29246i = objArr[0];
        this.f29246i.setTag((Object) null);
        this.f29241d.setTag((Object) null);
        setRootTag(view);
        this.j = new b(this, 2);
        this.k = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 8;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.n == i2) {
            a((DetailsViewModel) obj);
        } else if (a.t != i2) {
            return false;
        } else {
            a((GalleryViewModel) obj);
        }
        return true;
    }

    public final void a(DetailsViewModel detailsViewModel) {
        this.f29243f = detailsViewModel;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(a.n);
        super.requestRebind();
    }

    public final void a(GalleryViewModel galleryViewModel) {
        this.f29242e = galleryViewModel;
        synchronized (this) {
            this.l |= 4;
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
            this.l |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.l;
            this.l = 0;
        }
        GalleryViewModel galleryViewModel = this.f29242e;
        String str = null;
        int i2 = ((13 & j2) > 0 ? 1 : ((13 & j2) == 0 ? 0 : -1));
        if (i2 != 0) {
            y<String> yVar = galleryViewModel != null ? galleryViewModel.get_galleryTitle() : null;
            updateLiveDataRegistration(0, yVar);
            if (yVar != null) {
                str = yVar.getValue();
            }
        }
        if ((j2 & 8) != 0) {
            this.f29238a.setOnClickListener(this.k);
            this.f29239b.setOnClickListener(this.j);
        }
        if (i2 != 0) {
            d.a(this.f29241d, (CharSequence) str);
        }
    }

    public final void a(int i2) {
        boolean z = false;
        if (i2 == 1) {
            GalleryViewModel galleryViewModel = this.f29242e;
            if (galleryViewModel != null) {
                z = true;
            }
            if (z) {
                galleryViewModel.onBackPressed();
            }
        } else if (i2 == 2) {
            DetailsViewModel detailsViewModel = this.f29243f;
            if (detailsViewModel != null) {
                z = true;
            }
            if (z) {
                detailsViewModel.onSharePressed();
            }
        }
    }
}
