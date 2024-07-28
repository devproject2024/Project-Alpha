package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class bt extends bs {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f33996d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f33997e;

    /* renamed from: f  reason: collision with root package name */
    private long f33998f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33997e = sparseIntArray;
        sparseIntArray.put(R.id.feed_recommended_recyclerview, 1);
        f33997e.put(R.id.tabDots, 2);
    }

    public bt(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f33996d, f33997e));
    }

    private bt(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[1], objArr[2]);
        this.f33998f = -1;
        this.f33993a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f33998f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f33998f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f33998f = 0;
        }
    }
}
