package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;

public final class cp extends co {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f34075d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f34076e;

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f34077f;

    /* renamed from: g  reason: collision with root package name */
    private long f34078g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34076e = sparseIntArray;
        sparseIntArray.put(R.id.feed_banner_recyclerview, 2);
    }

    public cp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f34075d, f34076e));
    }

    private cp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f34078g = -1;
        this.f34072a.setTag((Object) null);
        this.f34077f = objArr[0];
        this.f34077f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34078g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34078g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f33779f != i2) {
            return false;
        }
        this.f34074c = (String) obj;
        synchronized (this) {
            this.f34078g |= 1;
        }
        notifyPropertyChanged(a.f33779f);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f34078g;
            this.f34078g = 0;
        }
        String str = this.f34074c;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean z = str == null;
            if (i3 != 0) {
                j |= z ? 8 : 4;
            }
            if (z) {
                i2 = 8;
            }
        }
        if ((j & 3) != 0) {
            this.f34072a.setVisibility(i2);
            d.a(this.f34072a, (CharSequence) str);
        }
    }
}
