package net.one97.paytm.prime.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.prime.R;

public final class b extends a {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f59751f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f59752g;

    /* renamed from: h  reason: collision with root package name */
    private long f59753h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f59752g = sparseIntArray;
        sparseIntArray.put(R.id.blank_view, 1);
        f59752g.put(R.id.prime_container_new, 2);
        f59752g.put(R.id.prime_dot_progress_bar, 3);
        f59752g.put(R.id.prime_webview, 4);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f59751f, f59752g));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[3], objArr[4], objArr[0]);
        this.f59753h = -1;
        this.f59750e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f59753h = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f59753h != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f59753h = 0;
        }
    }
}
