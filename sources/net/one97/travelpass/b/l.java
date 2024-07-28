package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;

public final class l extends k {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f30255b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f30256c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f30257d;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    public l(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f30255b, f30256c));
    }

    private l(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0]);
        this.f30257d = -1;
        this.f30254a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30257d = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30257d != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30257d = 0;
        }
    }
}
