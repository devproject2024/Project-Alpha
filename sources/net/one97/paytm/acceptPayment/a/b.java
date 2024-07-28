package net.one97.paytm.acceptPayment.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.acceptPayment.R;

public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f51967b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f51968c;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f51969d;

    /* renamed from: e  reason: collision with root package name */
    private long f51970e;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f51968c = sparseIntArray;
        sparseIntArray.put(R.id.loader, 1);
    }

    public b(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 2, f51967b, f51968c));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f51970e = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.f51969d = constraintLayout;
        constraintLayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f51970e = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f51970e != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f51970e = 0;
        }
    }
}
