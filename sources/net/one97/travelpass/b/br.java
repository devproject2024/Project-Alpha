package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class br extends bq {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f30211e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f30212f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f30213g;

    /* renamed from: h  reason: collision with root package name */
    private long f30214h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30212f = sparseIntArray;
        sparseIntArray.put(R.id.tv_heading, 1);
        f30212f.put(R.id.img_icon, 2);
        f30212f.put(R.id.tv_title, 3);
        f30212f.put(R.id.tv_price, 4);
    }

    public br(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f30211e, f30212f));
    }

    private br(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1], objArr[4], objArr[3]);
        this.f30214h = -1;
        this.f30213g = objArr[0];
        this.f30213g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30214h = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30214h != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30214h = 0;
        }
    }
}
