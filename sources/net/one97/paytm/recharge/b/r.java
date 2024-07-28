package net.one97.paytm.recharge.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;

public final class r extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewDataBinding.b f60369a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final SparseIntArray f60370b = null;

    /* renamed from: c  reason: collision with root package name */
    private final CardView f60371c;

    /* renamed from: d  reason: collision with root package name */
    private long f60372d;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    public r(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f60369a, f60370b));
    }

    private r(e eVar, View view, Object[] objArr) {
        super(eVar, view);
        this.f60372d = -1;
        this.f60371c = objArr[0];
        this.f60371c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f60372d = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f60372d != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f60372d = 0;
        }
    }
}
