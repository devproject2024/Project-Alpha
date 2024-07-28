package net.one97.paytm.recharge.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.recharge.R;

public final class f extends e {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f60326d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f60327e;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f60328f;

    /* renamed from: g  reason: collision with root package name */
    private long f60329g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f60327e = sparseIntArray;
        sparseIntArray.put(R.id.icon, 1);
        f60327e.put(R.id.category, 2);
        f60327e.put(R.id.textView4, 3);
    }

    public f(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f60326d, f60327e));
    }

    private f(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1], objArr[3]);
        this.f60329g = -1;
        this.f60328f = objArr[0];
        this.f60328f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f60329g = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f60329g != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f60329g = 0;
        }
    }
}
