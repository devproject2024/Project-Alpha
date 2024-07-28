package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class bj extends bi {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f30181c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f30182d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f30183e;

    /* renamed from: f  reason: collision with root package name */
    private long f30184f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30182d = sparseIntArray;
        sparseIntArray.put(R.id.viewpager_image, 1);
        f30182d.put(R.id.viewpager_dots, 2);
    }

    public bj(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f30181c, f30182d));
    }

    private bj(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1]);
        this.f30184f = -1;
        this.f30183e = objArr[0];
        this.f30183e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30184f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30184f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30184f = 0;
        }
    }
}
