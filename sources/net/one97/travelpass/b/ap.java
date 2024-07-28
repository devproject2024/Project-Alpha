package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class ap extends ao {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f30105c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f30106d;

    /* renamed from: e  reason: collision with root package name */
    private final RelativeLayout f30107e;

    /* renamed from: f  reason: collision with root package name */
    private long f30108f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30106d = sparseIntArray;
        sparseIntArray.put(R.id.img_icon, 1);
        f30106d.put(R.id.tv_item_text, 2);
    }

    public ap(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f30105c, f30106d));
    }

    private ap(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f30108f = -1;
        this.f30107e = objArr[0];
        this.f30107e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30108f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30108f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30108f = 0;
        }
    }
}
