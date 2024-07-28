package net.one97.paytm.acceptPayment.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.acceptPayment.R;

public final class j extends i {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f52000e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f52001f;

    /* renamed from: g  reason: collision with root package name */
    private long f52002g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f52001f = sparseIntArray;
        sparseIntArray.put(R.id.homeRvSwipeRefreshLayout, 1);
        f52001f.put(R.id.home_rv, 2);
        f52001f.put(R.id.snackBarContainer, 3);
    }

    public j(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 4, f52000e, f52001f));
    }

    private j(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[2], objArr[1], objArr[3]);
        this.f52002g = -1;
        this.f51996a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f52002g = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f52002g != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f52002g = 0;
        }
    }
}
