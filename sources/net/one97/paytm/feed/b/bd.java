package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class bd extends bc {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f33926b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f33927c;

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f33928d;

    /* renamed from: e  reason: collision with root package name */
    private long f33929e;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33927c = sparseIntArray;
        sparseIntArray.put(R.id.feed_loading_progress, 1);
    }

    public bd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f33926b, f33927c));
    }

    private bd(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f33929e = -1;
        this.f33928d = objArr[0];
        this.f33928d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f33929e = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f33929e != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f33929e = 0;
        }
    }
}
