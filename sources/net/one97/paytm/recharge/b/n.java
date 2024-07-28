package net.one97.paytm.recharge.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.recharge.R;

public final class n extends m {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f60363h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f60364i;
    private final ConstraintLayout j;
    private long k;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f60364i = sparseIntArray;
        sparseIntArray.put(R.id.heading, 1);
        f60364i.put(R.id.close_button, 2);
        f60364i.put(R.id.price, 3);
        f60364i.put(R.id.talktime, 4);
        f60364i.put(R.id.description, 5);
        f60364i.put(R.id.validity, 6);
        f60364i.put(R.id.btn_proceed, 7);
    }

    public n(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, f60363h, f60364i));
    }

    private n(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[7], objArr[2], objArr[5], objArr[1], objArr[3], objArr[4], objArr[6]);
        this.k = -1;
        this.j = objArr[0];
        this.j.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.k = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.k != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.k = 0;
        }
    }
}
