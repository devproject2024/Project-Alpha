package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class cb extends ca {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f34028d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f34029e;

    /* renamed from: f  reason: collision with root package name */
    private long f34030f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34029e = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        f34029e.put(R.id.container, 2);
    }

    public cb(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f34028d, f34029e));
    }

    private cb(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[0], objArr[1]);
        this.f34030f = -1;
        this.f34026b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34030f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34030f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f34030f = 0;
        }
    }
}
