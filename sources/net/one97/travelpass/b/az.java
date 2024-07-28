package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class az extends ay {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f30142b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f30143c;

    /* renamed from: d  reason: collision with root package name */
    private final RelativeLayout f30144d;

    /* renamed from: e  reason: collision with root package name */
    private long f30145e;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30143c = sparseIntArray;
        sparseIntArray.put(R.id.recycler_tabs, 1);
    }

    public az(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f30142b, f30143c));
    }

    private az(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f30145e = -1;
        this.f30144d = objArr[0];
        this.f30144d.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30145e = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30145e != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30145e = 0;
        }
    }
}
