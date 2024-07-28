package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class dd extends dc {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f34145i = null;
    private static final SparseIntArray j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.ivCreator, 1);
        j.put(R.id.overflow, 2);
        j.put(R.id.ivContent, 3);
        j.put(R.id.ivPlayBtn, 4);
        j.put(R.id.tvCreator, 5);
        j.put(R.id.title, 6);
        j.put(R.id.tvTime, 7);
    }

    public dd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f34145i, j));
    }

    private dd(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1], objArr[4], objArr[2], objArr[0], objArr[6], objArr[5], objArr[7]);
        this.k = -1;
        this.f34141e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.k != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.k = 0;
        }
    }
}
