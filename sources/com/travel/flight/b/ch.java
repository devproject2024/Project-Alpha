package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;

public final class ch extends cg {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewDataBinding.b f23805a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final SparseIntArray f23806b = null;

    /* renamed from: c  reason: collision with root package name */
    private final View f23807c;

    /* renamed from: d  reason: collision with root package name */
    private long f23808d;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    public ch(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 1, f23805a, f23806b));
    }

    private ch(e eVar, View view, Object[] objArr) {
        super(eVar, view);
        this.f23808d = -1;
        this.f23807c = objArr[0];
        this.f23807c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23808d = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23808d != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f23808d = 0;
        }
    }
}
