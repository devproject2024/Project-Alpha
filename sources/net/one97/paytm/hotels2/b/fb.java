package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SRPSortViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class fb extends fa implements b.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29684e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29685f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29686g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnClickListener f29687h;

    /* renamed from: i  reason: collision with root package name */
    private long f29688i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29685f = sparseIntArray;
        sparseIntArray.put(R.id.txt_title, 2);
        f29685f.put(R.id.recyclerview_sort, 3);
    }

    public fb(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29684e, f29685f));
    }

    private fb(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[2]);
        this.f29688i = -1;
        this.f29680a.setTag((Object) null);
        this.f29686g = objArr[0];
        this.f29686g.setTag((Object) null);
        setRootTag(view);
        this.f29687h = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29688i = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29688i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.t != i2) {
            return false;
        }
        a((SRPSortViewModel) obj);
        return true;
    }

    public final void a(SRPSortViewModel sRPSortViewModel) {
        this.f29683d = sRPSortViewModel;
        synchronized (this) {
            this.f29688i |= 1;
        }
        notifyPropertyChanged(a.t);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f29688i;
            this.f29688i = 0;
        }
        if ((j & 2) != 0) {
            this.f29680a.setOnClickListener(this.f29687h);
        }
    }

    public final void a(int i2) {
        SRPSortViewModel sRPSortViewModel = this.f29683d;
        if (sRPSortViewModel != null) {
            sRPSortViewModel.closeButtonClickHandler();
        }
    }
}
