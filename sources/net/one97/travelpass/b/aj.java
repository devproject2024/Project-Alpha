package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;

public final class aj extends ai {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f30085b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f30086c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f30087d;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    public aj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f30085b, f30086c));
    }

    private aj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0]);
        this.f30087d = -1;
        this.f30084a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30087d = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30087d != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30087d = 0;
        }
    }
}
