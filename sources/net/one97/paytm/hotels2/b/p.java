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

public final class p extends o implements b.a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29920f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29921g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f29922h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f29923i;
    private long j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29921g = sparseIntArray;
        sparseIntArray.put(R.id.tv_header, 3);
        f29921g.put(R.id.mapImage, 4);
    }

    public p(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29920f, f29921g));
    }

    private p(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[4], objArr[1], objArr[3]);
        this.j = -1;
        this.f29915a.setTag((Object) null);
        this.f29922h = objArr[0];
        this.f29922h.setTag((Object) null);
        this.f29917c.setTag((Object) null);
        setRootTag(view);
        this.f29923i = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 4;
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
        if (a.t != i2) {
            return false;
        }
        a((DetailsViewModel) obj);
        return true;
    }

    public final void a(DetailsViewModel detailsViewModel) {
        this.f29919e = detailsViewModel;
        synchronized (this) {
            this.j |= 2;
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
            this.j |= 1;
        }
        return true;
    }

    public final void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.j;
            this.j = 0;
        }
        DetailsViewModel detailsViewModel = this.f29919e;
        String str = null;
        int i2 = ((7 & j2) > 0 ? 1 : ((7 & j2) == 0 ? 0 : -1));
        if (i2 != 0) {
            y<String> yVar = detailsViewModel != null ? detailsViewModel.get_fullAddress() : null;
            updateLiveDataRegistration(0, yVar);
            if (yVar != null) {
                str = yVar.getValue();
            }
        }
        if ((j2 & 4) != 0) {
            this.f29915a.setOnClickListener(this.f29923i);
        }
        if (i2 != 0) {
            d.a(this.f29917c, (CharSequence) str);
        }
    }

    public final void a(int i2) {
        DetailsViewModel detailsViewModel = this.f29919e;
        if (detailsViewModel != null) {
            detailsViewModel.openGoogleMap();
        }
    }
}
