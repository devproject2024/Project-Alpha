package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;

public final class bl extends bk {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f29262b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f29263c;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f29264d;

    /* renamed from: e  reason: collision with root package name */
    private long f29265e;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29263c = sparseIntArray;
        sparseIntArray.put(R.id.image_list_gallery, 1);
    }

    public bl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f29262b, f29263c));
    }

    private bl(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f29265e = -1;
        this.f29264d = objArr[0];
        this.f29264d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29265e = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29265e != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f29265e = 0;
        }
    }
}
