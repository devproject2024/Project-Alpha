package net.one97.paytm.g;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.paytm_finance.R;

public final class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f50480d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f50481e;

    /* renamed from: f  reason: collision with root package name */
    private long f50482f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f50481e = sparseIntArray;
        sparseIntArray.put(R.id.tv_heading, 1);
        f50481e.put(R.id.rv_module_loader, 2);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f50480d, f50481e));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[2], objArr[1]);
        this.f50482f = -1;
        this.f50477a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f50482f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f50482f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f50482f = 0;
        }
    }
}
