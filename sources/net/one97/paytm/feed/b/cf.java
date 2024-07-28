package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class cf extends ce {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f34039b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f34040c;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f34041d;

    /* renamed from: e  reason: collision with root package name */
    private long f34042e;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34040c = sparseIntArray;
        sparseIntArray.put(R.id.feed_stories_recyclerview, 1);
    }

    public cf(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f34039b, f34040c));
    }

    private cf(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f34042e = -1;
        this.f34041d = objArr[0];
        this.f34041d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34042e = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34042e != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f34042e = 0;
        }
    }
}
