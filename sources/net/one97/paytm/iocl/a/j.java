package net.one97.paytm.iocl.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.iocl.R;

public final class j extends i {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f14123e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f14124f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f14125g;

    /* renamed from: h  reason: collision with root package name */
    private long f14126h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14124f = sparseIntArray;
        sparseIntArray.put(R.id.tv_dialog_create_account, 1);
        f14124f.put(R.id.iv_dialog_close, 2);
        f14124f.put(R.id.tv_dialog_warning, 3);
        f14124f.put(R.id.btn_dialog_continue, 4);
    }

    public j(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f14123e, f14124f));
    }

    private j(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[2], objArr[1], objArr[3]);
        this.f14126h = -1;
        this.f14125g = objArr[0];
        this.f14125g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f14126h = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f14126h != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f14126h = 0;
        }
    }
}
