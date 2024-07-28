package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class p extends o {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f34202c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f34203d;

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f34204e;

    /* renamed from: f  reason: collision with root package name */
    private long f34205f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34203d = sparseIntArray;
        sparseIntArray.put(R.id.feed_coverage_recyclerview, 1);
        f34203d.put(R.id.progressLayout, 2);
    }

    public p(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f34202c, f34203d));
    }

    private p(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f34205f = -1;
        this.f34204e = objArr[0];
        this.f34204e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34205f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34205f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f34205f = 0;
        }
    }
}
