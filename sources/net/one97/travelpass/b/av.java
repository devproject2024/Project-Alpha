package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class av extends au {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f30128e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f30129f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f30130g;

    /* renamed from: h  reason: collision with root package name */
    private long f30131h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30129f = sparseIntArray;
        sparseIntArray.put(R.id.recycler_pass_details, 1);
        f30129f.put(R.id.layout_cashback_process, 2);
        f30129f.put(R.id.warning_icon_image, 3);
        f30129f.put(R.id.warning_text, 4);
    }

    public av(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, f30128e, f30129f));
    }

    private av(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1], objArr[3], objArr[4]);
        this.f30131h = -1;
        this.f30130g = objArr[0];
        this.f30130g.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30131h = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30131h != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30131h = 0;
        }
    }
}
