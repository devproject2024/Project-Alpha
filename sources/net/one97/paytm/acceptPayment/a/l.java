package net.one97.paytm.acceptPayment.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.acceptPayment.R;
import net.one97.paytm.acceptPayment.b;

public final class l extends k {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f52005c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f52006d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f52007e;

    /* renamed from: f  reason: collision with root package name */
    private long f52008f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f52006d = sparseIntArray;
        sparseIntArray.put(R.id.rv_widgets, 1);
    }

    public l(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 2, f52005c, f52006d));
    }

    private l(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f52008f = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.f52007e = constraintLayout;
        constraintLayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f52008f = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f52008f != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (b.f52044c != i2) {
            return false;
        }
        this.f52004b = (net.one97.paytm.acceptPayment.storefront.e) obj;
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f52008f = 0;
        }
    }
}
