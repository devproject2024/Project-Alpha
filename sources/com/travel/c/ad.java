package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;

public final class ad extends ac {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f22840b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f22841c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f22842d;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    public ad(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f22840b, f22841c));
    }

    private ad(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0]);
        this.f22842d = -1;
        this.f22839a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f22842d = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f22842d != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f22842d = 0;
        }
    }
}
