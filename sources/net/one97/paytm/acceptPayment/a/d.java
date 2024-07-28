package net.one97.paytm.acceptPayment.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.acceptPayment.R;

public final class d extends c {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f51976f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f51977g;

    /* renamed from: h  reason: collision with root package name */
    private final FrameLayout f51978h;

    /* renamed from: i  reason: collision with root package name */
    private long f51979i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f51977g = sparseIntArray;
        sparseIntArray.put(R.id.iv_back_button, 1);
        f51977g.put(R.id.nav_title, 2);
        f51977g.put(R.id.sf_banners, 3);
        f51977g.put(R.id.loading_view, 4);
        f51977g.put(R.id.loader, 5);
    }

    public d(e eVar, View view) {
        this(eVar, view, ViewDataBinding.mapBindings(eVar, view, 6, f51976f, f51977g));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[5], objArr[4], objArr[2], objArr[3]);
        this.f51979i = -1;
        FrameLayout frameLayout = objArr[0];
        this.f51978h = frameLayout;
        frameLayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f51979i = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f51979i != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f51979i = 0;
        }
    }
}
