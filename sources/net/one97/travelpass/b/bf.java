package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;

public final class bf extends be {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f30167g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f30168h;

    /* renamed from: i  reason: collision with root package name */
    private long f30169i;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30168h = sparseIntArray;
        sparseIntArray.put(R.id.header_container, 1);
        f30168h.put(R.id.plus_icon, 2);
        f30168h.put(R.id.tv_question, 3);
        f30168h.put(R.id.tv_ans, 4);
        f30168h.put(R.id.seperator, 5);
    }

    public bf(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 6, f30167g, f30168h));
    }

    private bf(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[1], objArr[2], objArr[5], objArr[4], objArr[3]);
        this.f30169i = -1;
        this.f30161a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30169i = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30169i != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.f30169i = 0;
        }
    }
}
