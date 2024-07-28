package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotel4.viewmodel.SharedViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class bn extends bm {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f29268c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f29269d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f29270e;

    /* renamed from: f  reason: collision with root package name */
    private long f29271f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29269d = sparseIntArray;
        sparseIntArray.put(R.id.fragment_continer, 1);
    }

    public bn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f29268c, f29269d));
    }

    private bn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f29271f = -1;
        this.f29270e = objArr[0];
        this.f29270e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29271f = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29271f != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f29091f != i2) {
            return false;
        }
        this.f29267b = (SharedViewModel) obj;
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f29271f = 0;
        }
    }
}
