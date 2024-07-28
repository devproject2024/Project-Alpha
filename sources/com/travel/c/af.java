package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.R;

public final class af extends ae {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f22849g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f22850h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f22851i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22850h = sparseIntArray;
        sparseIntArray.put(R.id.data_container, 1);
        f22850h.put(R.id.tv_title_hint, 2);
        f22850h.put(R.id.close_button, 3);
        f22850h.put(R.id.recyclerView, 4);
        f22850h.put(R.id.fotter1, 5);
        f22850h.put(R.id.fotter2, 6);
    }

    public af(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f22849g, f22850h));
    }

    private af(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[1], objArr[5], objArr[6], objArr[4], objArr[2]);
        this.j = -1;
        this.f22851i = objArr[0];
        this.f22851i.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.j = 0;
        }
    }
}
