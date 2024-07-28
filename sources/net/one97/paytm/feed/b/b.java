package net.one97.paytm.feed.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.feed.R;

public final class b extends a {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f33913g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f33914h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f33915i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33914h = sparseIntArray;
        sparseIntArray.put(R.id.backButton, 1);
        f33914h.put(R.id.tvTitle, 2);
        f33914h.put(R.id.rv_discovery_list, 3);
        f33914h.put(R.id.progress, 4);
        f33914h.put(R.id.empty_view, 5);
        f33914h.put(R.id.empty_title, 6);
    }

    public b(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f33913g, f33914h));
    }

    private b(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[6], objArr[5], objArr[4], objArr[3], objArr[2]);
        this.j = -1;
        this.f33915i = objArr[0];
        this.f33915i.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.j = 0;
        }
    }
}
