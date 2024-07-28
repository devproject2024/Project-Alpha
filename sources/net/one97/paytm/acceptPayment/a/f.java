package net.one97.paytm.acceptPayment.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.acceptPayment.R;

public final class f extends e {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f51984e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f51985f;

    /* renamed from: g  reason: collision with root package name */
    private long f51986g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f51985f = sparseIntArray;
        sparseIntArray.put(R.id.app_bar, 1);
        f51985f.put(R.id.toolbar, 2);
        f51985f.put(R.id.fragment_container, 3);
    }

    public f(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 4, f51984e, f51985f));
    }

    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[3], objArr[0], objArr[2]);
        this.f51986g = -1;
        this.f51982c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f51986g = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f51986g != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f51986g = 0;
        }
    }
}
