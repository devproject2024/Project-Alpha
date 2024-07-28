package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.R;

public final class ah extends ag {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f22854c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f22855d;

    /* renamed from: e  reason: collision with root package name */
    private final RelativeLayout f22856e;

    /* renamed from: f  reason: collision with root package name */
    private long f22857f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22855d = sparseIntArray;
        sparseIntArray.put(R.id.view_circle, 1);
        f22855d.put(R.id.tv_title, 2);
    }

    public ah(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f22854c, f22855d));
    }

    private ah(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1]);
        this.f22857f = -1;
        this.f22856e = objArr[0];
        this.f22856e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f22857f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f22857f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f22857f = 0;
        }
    }
}
