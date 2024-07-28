package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;

public final class fh extends fg {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f29708c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f29709d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f29710e;

    /* renamed from: f  reason: collision with root package name */
    private long f29711f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29709d = sparseIntArray;
        sparseIntArray.put(R.id.iv_bullet, 1);
        f29709d.put(R.id.tv_text, 2);
    }

    public fh(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29708c, f29709d));
    }

    private fh(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f29711f = -1;
        this.f29710e = objArr[0];
        this.f29710e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29711f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29711f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f29711f = 0;
        }
    }
}
