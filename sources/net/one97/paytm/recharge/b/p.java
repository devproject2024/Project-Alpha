package net.one97.paytm.recharge.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;

public final class p extends o {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f60366b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f60367c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f60368d;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    public p(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f60366b, f60367c));
    }

    private p(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0]);
        this.f60368d = -1;
        this.f60365a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f60368d = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f60368d != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f60368d = 0;
        }
    }
}
