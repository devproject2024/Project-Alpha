package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class ad extends ac {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f30070e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f30071f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f30072g;

    /* renamed from: h  reason: collision with root package name */
    private long f30073h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30071f = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        f30071f.put(R.id.back_arrow, 2);
        f30071f.put(R.id.header_tv, 3);
        f30071f.put(R.id.fragment_container, 4);
    }

    public ad(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f30070e, f30071f));
    }

    private ad(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[4], objArr[3], objArr[1]);
        this.f30073h = -1;
        this.f30072g = objArr[0];
        this.f30072g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30073h = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30073h != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30073h = 0;
        }
    }
}
