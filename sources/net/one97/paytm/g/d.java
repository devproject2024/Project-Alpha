package net.one97.paytm.g;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.paytm_finance.R;

public final class d extends c {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f50490h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f50491i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f50491i = sparseIntArray;
        sparseIntArray.put(R.id.tv_heading, 1);
        f50491i.put(R.id.rv_module_loader, 2);
        f50491i.put(R.id.tv_header, 3);
        f50491i.put(R.id.tv_info, 4);
        f50491i.put(R.id.close, 5);
        f50491i.put(R.id.action_label, 6);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f50490h, f50491i));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[5], objArr[0], objArr[2], objArr[3], objArr[1], objArr[4]);
        this.j = -1;
        this.f50485c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.j = 0;
        }
    }
}
