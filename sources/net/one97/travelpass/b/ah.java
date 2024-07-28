package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class ah extends ag {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f30080c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f30081d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f30082e;

    /* renamed from: f  reason: collision with root package name */
    private long f30083f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30081d = sparseIntArray;
        sparseIntArray.put(R.id.hint_start_date, 1);
        f30081d.put(R.id.checkout_btn, 2);
    }

    public ah(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f30080c, f30081d));
    }

    private ah(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1]);
        this.f30083f = -1;
        this.f30082e = objArr[0];
        this.f30082e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30083f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30083f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30083f = 0;
        }
    }
}
