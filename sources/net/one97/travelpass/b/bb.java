package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class bb extends ba {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f30153d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f30154e;

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f30155f;

    /* renamed from: g  reason: collision with root package name */
    private long f30156g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30154e = sparseIntArray;
        sparseIntArray.put(R.id.header_title, 1);
        f30154e.put(R.id.recycler_benefits, 2);
        f30154e.put(R.id.selected_pass_text, 3);
    }

    public bb(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f30153d, f30154e));
    }

    private bb(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2], objArr[3]);
        this.f30156g = -1;
        this.f30155f = objArr[0];
        this.f30155f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30156g = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30156g != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30156g = 0;
        }
    }
}
