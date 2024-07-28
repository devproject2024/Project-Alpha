package net.one97.travelpass.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.travelpass.R;
import net.one97.travelpass.a;
import net.one97.travelpass.ui.a.b;

public final class t extends s {

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.b f30286f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f30287g;

    /* renamed from: h  reason: collision with root package name */
    private long f30288h;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f30287g = sparseIntArray;
        sparseIntArray.put(R.id.tv_title_hint, 2);
        f30287g.put(R.id.close_button, 3);
    }

    public t(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 4, f30286f, f30287g));
    }

    private t(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[0], objArr[1], objArr[2]);
        this.f30288h = -1;
        this.f30282b.setTag((Object) null);
        this.f30283c.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f30288h = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f30288h != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f30031d != i2) {
            return false;
        }
        a((b) obj);
        return true;
    }

    public final void a(b bVar) {
        this.f30285e = bVar;
        synchronized (this) {
            this.f30288h |= 1;
        }
        notifyPropertyChanged(a.f30031d);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f30288h;
            this.f30288h = 0;
        }
        b bVar = this.f30285e;
        if ((j & 3) != 0) {
            this.f30283c.setAdapter(bVar);
        }
    }
}
