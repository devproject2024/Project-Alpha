package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class an extends am {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f30099f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f30100g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f30101h;

    /* renamed from: i  reason: collision with root package name */
    private long f30102i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30100g = sparseIntArray;
        sparseIntArray.put(R.id.rel_expand_view, 1);
        f30100g.put(R.id.tv_heading, 2);
        f30100g.put(R.id.btn_expand, 3);
        f30100g.put(R.id.recyclerView, 4);
        f30100g.put(R.id.recycler_separator, 5);
    }

    public an(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f30099f, f30100g));
    }

    private an(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[5], objArr[4], objArr[1], objArr[2]);
        this.f30102i = -1;
        this.f30101h = objArr[0];
        this.f30101h.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30102i = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30102i != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30102i = 0;
        }
    }
}
