package net.one97.paytm.addmoney.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.addmoney.R;

public final class t extends s {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f48100b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f48101c;

    /* renamed from: d  reason: collision with root package name */
    private final RelativeLayout f48102d;

    /* renamed from: e  reason: collision with root package name */
    private long f48103e;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f48101c = sparseIntArray;
        sparseIntArray.put(R.id.vp_cvv_help, 1);
    }

    public t(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f48100b, f48101c));
    }

    private t(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f48103e = -1;
        this.f48102d = objArr[0];
        this.f48102d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f48103e = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f48103e != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f48103e = 0;
        }
    }
}
