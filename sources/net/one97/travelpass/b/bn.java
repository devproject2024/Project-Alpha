package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class bn extends bm {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f30194d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f30195e;

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f30196f;

    /* renamed from: g  reason: collision with root package name */
    private long f30197g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30195e = sparseIntArray;
        sparseIntArray.put(R.id.viewpager_image, 1);
        f30195e.put(R.id.viewpager_dots1, 2);
        f30195e.put(R.id.tv_heading, 3);
    }

    public bn(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f30194d, f30195e));
    }

    private bn(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[2], objArr[1]);
        this.f30197g = -1;
        this.f30196f = objArr[0];
        this.f30196f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30197g = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30197g != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30197g = 0;
        }
    }
}
