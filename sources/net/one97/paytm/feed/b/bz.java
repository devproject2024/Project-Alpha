package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;

public final class bz extends by {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f34018d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f34019e;

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f34020f;

    /* renamed from: g  reason: collision with root package name */
    private long f34021g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34019e = sparseIntArray;
        sparseIntArray.put(R.id.feed_recommended_recyclerview, 2);
    }

    public bz(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f34018d, f34019e));
    }

    private bz(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f34021g = -1;
        this.f34015a.setTag((Object) null);
        this.f34020f = objArr[0];
        this.f34020f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f34021g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f34021g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f33779f != i2) {
            return false;
        }
        this.f34017c = (String) obj;
        synchronized (this) {
            this.f34021g |= 1;
        }
        notifyPropertyChanged(a.f33779f);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f34021g;
            this.f34021g = 0;
        }
        String str = this.f34017c;
        if ((j & 3) != 0) {
            d.a(this.f34015a, (CharSequence) str);
        }
    }
}
