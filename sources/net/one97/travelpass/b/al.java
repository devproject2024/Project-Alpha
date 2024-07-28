package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class al extends ak {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f30090c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f30091d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f30092e;

    /* renamed from: f  reason: collision with root package name */
    private long f30093f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30091d = sparseIntArray;
        sparseIntArray.put(R.id.header_text, 1);
        f30091d.put(R.id.recycler_faq_details, 2);
    }

    public al(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f30090c, f30091d));
    }

    private al(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f30093f = -1;
        this.f30092e = objArr[0];
        this.f30092e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30093f = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30093f != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30093f = 0;
        }
    }
}
