package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class z extends y {

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.b f30309e = null;

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f30310f;

    /* renamed from: g  reason: collision with root package name */
    private long f30311g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30310f = sparseIntArray;
        sparseIntArray.put(R.id.empty_screen_title, 1);
        f30310f.put(R.id.empty_screen_message, 2);
        f30310f.put(R.id.empty_action_button, 3);
    }

    public z(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f30309e, f30310f));
    }

    private z(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[0], objArr[2], objArr[1]);
        this.f30311g = -1;
        this.f30306b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30311g = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30311g != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30311g = 0;
        }
    }
}
