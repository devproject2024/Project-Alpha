package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.R;

public final class ab extends aa {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f22836g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f22837h;

    /* renamed from: i  reason: collision with root package name */
    private long f22838i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22837h = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        f22837h.put(R.id.back_arrow, 2);
        f22837h.put(R.id.header_tv, 3);
        f22837h.put(R.id.shadow_separator, 4);
        f22837h.put(R.id.generic_fragment_container, 5);
    }

    public ab(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f22836g, f22837h));
    }

    private ab(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[5], objArr[3], objArr[0], objArr[4], objArr[1]);
        this.f22838i = -1;
        this.f22833d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f22838i = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f22838i != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f22838i = 0;
        }
    }
}
