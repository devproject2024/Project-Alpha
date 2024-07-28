package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class fx extends fw {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f29777e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f29778f;

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f29779g;

    /* renamed from: h  reason: collision with root package name */
    private long f29780h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29778f = sparseIntArray;
        sparseIntArray.put(R.id.tv_room_tax_descri, 1);
        f29778f.put(R.id.tv_tax_price, 2);
    }

    public fx(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f29777e, f29778f));
    }

    private fx(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f29780h = -1;
        this.f29779g = objArr[0];
        this.f29779g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29780h = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29780h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.J == i2) {
            this.f29775c = (Drawable) obj;
        } else if (a.o != i2) {
            return false;
        } else {
            this.f29776d = (String) obj;
        }
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f29780h = 0;
        }
    }
}
