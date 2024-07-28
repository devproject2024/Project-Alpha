package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class bl extends bk {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f30187c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f30188d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f30189e;

    /* renamed from: f  reason: collision with root package name */
    private long f30190f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30188d = sparseIntArray;
        sparseIntArray.put(R.id.header_title, 1);
        f30188d.put(R.id.recycler_benefits_internal, 2);
    }

    public bl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f30187c, f30188d));
    }

    private bl(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f30190f = -1;
        this.f30189e = objArr[0];
        this.f30189e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30190f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30190f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30190f = 0;
        }
    }
}
