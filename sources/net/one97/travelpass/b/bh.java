package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class bh extends bg {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f30177h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f30178i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30178i = sparseIntArray;
        sparseIntArray.put(R.id.tv_heading, 1);
        f30178i.put(R.id.img_icon, 2);
        f30178i.put(R.id.view_vertical_line, 3);
        f30178i.put(R.id.rel_item, 4);
        f30178i.put(R.id.tv_title, 5);
        f30178i.put(R.id.tv_description, 6);
    }

    public bh(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f30177h, f30178i));
    }

    private bh(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[2], objArr[4], objArr[6], objArr[1], objArr[5], objArr[3]);
        this.j = -1;
        this.f30170a.setTag((Object) null);
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
