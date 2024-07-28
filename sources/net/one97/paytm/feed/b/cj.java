package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class cj extends ci {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f34053b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f34054c;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f34055d;

    /* renamed from: e  reason: collision with root package name */
    private long f34056e;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34054c = sparseIntArray;
        sparseIntArray.put(R.id.feed_story_viewpager, 1);
    }

    public cj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f34053b, f34054c));
    }

    private cj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f34056e = -1;
        this.f34055d = objArr[0];
        this.f34055d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34056e = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34056e != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f34056e = 0;
        }
    }
}
