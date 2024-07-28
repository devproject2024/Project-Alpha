package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;

public final class cb extends ca {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f29336d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f29337e;

    /* renamed from: f  reason: collision with root package name */
    private long f29338f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29337e = sparseIntArray;
        sparseIntArray.put(R.id.title, 1);
        f29337e.put(R.id.similarHotelsList, 2);
    }

    public cb(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29336d, f29337e));
    }

    private cb(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[2], objArr[1]);
        this.f29338f = -1;
        this.f29333a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29338f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29338f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f29338f = 0;
        }
    }
}
