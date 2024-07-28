package net.one97.paytm.paymentsBank.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.paymentsBank.R;

public final class d extends c {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f17481d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f17482e;

    /* renamed from: f  reason: collision with root package name */
    private final RelativeLayout f17483f;

    /* renamed from: g  reason: collision with root package name */
    private long f17484g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f17482e = sparseIntArray;
        sparseIntArray.put(R.id.transDateTv, 1);
        f17482e.put(R.id.transRupeeTv, 2);
        f17482e.put(R.id.transStatusTv, 3);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f17481d, f17482e));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[3]);
        this.f17484g = -1;
        this.f17483f = objArr[0];
        this.f17483f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f17484g = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f17484g != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f17484g = 0;
        }
    }
}
