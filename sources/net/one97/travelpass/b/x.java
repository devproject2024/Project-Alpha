package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class x extends w {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f30301e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f30302f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f30303g;

    /* renamed from: h  reason: collision with root package name */
    private long f30304h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30302f = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        f30302f.put(R.id.back_arrow, 2);
        f30302f.put(R.id.header_tv, 3);
        f30302f.put(R.id.fragment_container, 4);
    }

    public x(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f30301e, f30302f));
    }

    private x(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[4], objArr[3], objArr[1]);
        this.f30304h = -1;
        this.f30303g = objArr[0];
        this.f30303g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30304h = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30304h != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30304h = 0;
        }
    }
}
