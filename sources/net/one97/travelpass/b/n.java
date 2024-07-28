package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class n extends m {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f30260c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f30261d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f30262e;

    /* renamed from: f  reason: collision with root package name */
    private long f30263f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30261d = sparseIntArray;
        sparseIntArray.put(R.id.section_header, 1);
        f30261d.put(R.id.recycler_pass_details, 2);
    }

    public n(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f30260c, f30261d));
    }

    private n(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[1]);
        this.f30263f = -1;
        this.f30262e = objArr[0];
        this.f30262e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30263f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30263f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30263f = 0;
        }
    }
}
