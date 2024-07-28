package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class j extends i {

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.b f30253i = null;
    private static final SparseIntArray j;
    private final CoordinatorLayout k;
    private long l;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j = sparseIntArray;
        sparseIntArray.put(R.id.appbar, 1);
        j.put(R.id.collapsing_toolbar, 2);
        j.put(R.id.status_image, 3);
        j.put(R.id.toolbar, 4);
        j.put(R.id.back_arrow, 5);
        j.put(R.id.header_tv, 6);
        j.put(R.id.recyclerView, 7);
        j.put(R.id.progressbar, 8);
    }

    public j(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, f30253i, j));
    }

    private j(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[5], objArr[2], objArr[6], objArr[8], objArr[7], objArr[3], objArr[4]);
        this.l = -1;
        this.k = objArr[0];
        this.k.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.l = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.l != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.l = 0;
        }
    }
}
