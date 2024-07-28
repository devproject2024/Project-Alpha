package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class p extends o {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f30268e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f30269f;

    /* renamed from: g  reason: collision with root package name */
    private final RelativeLayout f30270g;

    /* renamed from: h  reason: collision with root package name */
    private long f30271h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30269f = sparseIntArray;
        sparseIntArray.put(R.id.img_icon, 1);
        f30269f.put(R.id.tv_title, 2);
        f30269f.put(R.id.tv_price, 3);
        f30269f.put(R.id.all_promo_container, 4);
    }

    public p(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f30268e, f30269f));
    }

    private p(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[1], objArr[3], objArr[2]);
        this.f30271h = -1;
        this.f30270g = objArr[0];
        this.f30270g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30271h = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30271h != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30271h = 0;
        }
    }
}
