package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class bp extends bo {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f30203f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f30204g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f30205h;

    /* renamed from: i  reason: collision with root package name */
    private final RelativeLayout f30206i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30204g = sparseIntArray;
        sparseIntArray.put(R.id.img_icon, 2);
        f30204g.put(R.id.tv_title, 3);
        f30204g.put(R.id.tv_price, 4);
        f30204g.put(R.id.view_btn, 5);
        f30204g.put(R.id.button_title, 6);
    }

    public bp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f30203f, f30204g));
    }

    private bp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[6], objArr[2], objArr[4], objArr[3], objArr[5]);
        this.j = -1;
        this.f30205h = objArr[0];
        this.f30205h.setTag((Object) null);
        this.f30206i = objArr[1];
        this.f30206i.setTag((Object) null);
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
