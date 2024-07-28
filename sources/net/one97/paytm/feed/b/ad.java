package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.utility.b;

public final class ad extends ac {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f33817e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f33818f;

    /* renamed from: g  reason: collision with root package name */
    private long f33819g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33818f = sparseIntArray;
        sparseIntArray.put(R.id.feed_hide_post_view, 1);
        f33818f.put(R.id.textView, 2);
    }

    public ad(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f33817e, f33818f));
    }

    private ad(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[0], objArr[2]);
        this.f33819g = -1;
        this.f33814b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f33819g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f33819g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.A != i2) {
            return false;
        }
        a((Boolean) obj);
        return true;
    }

    public final void a(Boolean bool) {
        this.f33816d = bool;
        synchronized (this) {
            this.f33819g |= 1;
        }
        notifyPropertyChanged(a.A);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f33819g;
            this.f33819g = 0;
        }
        int i2 = 0;
        Boolean bool = this.f33816d;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            i2 = b.a(ViewDataBinding.safeUnbox(bool));
        }
        if (i3 != 0) {
            this.f33814b.setVisibility(i2);
        }
    }
}
