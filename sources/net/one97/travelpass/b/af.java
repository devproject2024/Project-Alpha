package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;

public final class af extends ae {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f30075b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f30076c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f30077d;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    public af(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f30075b, f30076c));
    }

    private af(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0]);
        this.f30077d = -1;
        this.f30074a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30077d = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30077d != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30077d = 0;
        }
    }
}
