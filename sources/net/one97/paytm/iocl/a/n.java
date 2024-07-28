package net.one97.paytm.iocl.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.iocl.R;

public final class n extends m {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f14142g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f14143h;

    /* renamed from: i  reason: collision with root package name */
    private final LinearLayout f14144i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14143h = sparseIntArray;
        sparseIntArray.put(R.id.tv_header, 1);
        f14143h.put(R.id.iv_close, 2);
        f14143h.put(R.id.rd_group, 3);
        f14143h.put(R.id.rd_female, 4);
        f14143h.put(R.id.rd_male, 5);
        f14143h.put(R.id.rd_other, 6);
    }

    public n(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f14142g, f14143h));
    }

    private n(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[4], objArr[3], objArr[5], objArr[6], objArr[1]);
        this.j = -1;
        this.f14144i = objArr[0];
        this.f14144i.setTag((Object) null);
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
