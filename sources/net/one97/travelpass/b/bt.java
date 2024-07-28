package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;

public final class bt extends bs {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f30216b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f30217c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f30218d;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    public bt(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f30216b, f30217c));
    }

    private bt(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0]);
        this.f30218d = -1;
        this.f30215a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30218d = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30218d != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30218d = 0;
        }
    }
}
