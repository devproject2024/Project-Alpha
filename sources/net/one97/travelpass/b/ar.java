package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class ar extends aq {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f30112d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f30113e;

    /* renamed from: f  reason: collision with root package name */
    private long f30114f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30113e = sparseIntArray;
        sparseIntArray.put(R.id.view_circle, 1);
        f30113e.put(R.id.tv_title, 2);
    }

    public ar(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f30112d, f30113e));
    }

    private ar(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[2], objArr[1]);
        this.f30114f = -1;
        this.f30109a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30114f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30114f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30114f = 0;
        }
    }
}
