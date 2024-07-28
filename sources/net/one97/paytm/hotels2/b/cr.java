package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;

public final class cr extends cq {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f29399b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f29400c;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f29401d;

    /* renamed from: e  reason: collision with root package name */
    private long f29402e;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29400c = sparseIntArray;
        sparseIntArray.put(R.id.fragment_continer, 1);
    }

    public cr(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f29399b, f29400c));
    }

    private cr(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f29402e = -1;
        this.f29401d = objArr[0];
        this.f29401d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29402e = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29402e != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f29402e = 0;
        }
    }
}
