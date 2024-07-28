package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;

public final class d extends c {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f34124d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f34125e;

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f34126f;

    /* renamed from: g  reason: collision with root package name */
    private long f34127g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34125e = sparseIntArray;
        sparseIntArray.put(R.id.feed_banner_recyclerview, 2);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f34124d, f34125e));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f34127g = -1;
        this.f34022a.setTag((Object) null);
        this.f34126f = objArr[0];
        this.f34126f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34127g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34127g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f33779f != i2) {
            return false;
        }
        this.f34024c = (String) obj;
        synchronized (this) {
            this.f34127g |= 1;
        }
        notifyPropertyChanged(a.f33779f);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f34127g;
            this.f34127g = 0;
        }
        String str = this.f34024c;
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
            this.f34022a.setVisibility(i2);
            androidx.databinding.a.d.a(this.f34022a, (CharSequence) str);
        }
    }
}
