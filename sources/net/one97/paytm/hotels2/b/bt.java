package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;

public final class bt extends bs {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29294e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29295f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f29296g;

    /* renamed from: h  reason: collision with root package name */
    private long f29297h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29295f = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 1);
        f29295f.put(R.id.iv_close, 2);
        f29295f.put(R.id.divider, 3);
        f29295f.put(R.id.rv_amenities, 4);
    }

    public bt(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f29294e, f29295f));
    }

    private bt(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[2], objArr[4], objArr[1]);
        this.f29297h = -1;
        this.f29296g = objArr[0];
        this.f29296g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29297h = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29297h != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f29297h = 0;
        }
    }
}
