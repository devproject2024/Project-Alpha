package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;

public final class bz extends by {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29320e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29321f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29322g;

    /* renamed from: h  reason: collision with root package name */
    private long f29323h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29321f = sparseIntArray;
        sparseIntArray.put(R.id.sep1, 1);
        f29321f.put(R.id.tnc, 2);
        f29321f.put(R.id.sep2, 3);
        f29321f.put(R.id.policies, 4);
    }

    public bz(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29320e, f29321f));
    }

    private bz(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[1], objArr[3], objArr[2]);
        this.f29323h = -1;
        this.f29322g = objArr[0];
        this.f29322g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29323h = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29323h != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f29323h = 0;
        }
    }
}
