package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;

public final class bj extends bi {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f29257b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f29258c;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f29259d;

    /* renamed from: e  reason: collision with root package name */
    private long f29260e;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29258c = sparseIntArray;
        sparseIntArray.put(R.id.recycleImage, 1);
    }

    public bj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f29257b, f29258c));
    }

    private bj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f29260e = -1;
        this.f29259d = objArr[0];
        this.f29259d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29260e = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29260e != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f29260e = 0;
        }
    }
}
