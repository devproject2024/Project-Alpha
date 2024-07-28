package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;

public final class fv extends fu {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f29769f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f29770g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f29771h;

    /* renamed from: i  reason: collision with root package name */
    private long f29772i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f29770g = sparseIntArray;
        sparseIntArray.put(R.id.tv_room_descri, 1);
        f29770g.put(R.id.tv_fare_descri, 2);
        f29770g.put(R.id.tv_price, 3);
    }

    public fv(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f29769f, f29770g));
    }

    private fv(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[3], objArr[1]);
        this.f29772i = -1;
        this.f29771h = objArr[0];
        this.f29771h.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f29772i = 4;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f29772i != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.J == i2) {
            this.f29767d = (Drawable) obj;
        } else if (a.o != i2) {
            return false;
        } else {
            this.f29768e = (String) obj;
        }
        return true;
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f29772i = 0;
        }
    }
}
