package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class df extends de {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f34151f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f34152g;

    /* renamed from: h  reason: collision with root package name */
    private long f34153h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34152g = sparseIntArray;
        sparseIntArray.put(R.id.ivFollow, 1);
        f34152g.put(R.id.title, 2);
        f34152g.put(R.id.tvFollow, 3);
        f34152g.put(R.id.hDivider, 4);
    }

    public df(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f34151f, f34152g));
    }

    private df(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[4], objArr[1], objArr[0], objArr[2], objArr[3]);
        this.f34153h = -1;
        this.f34148c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34153h = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34153h != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f34153h = 0;
        }
    }
}
