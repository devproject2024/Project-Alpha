package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.a;

public final class r extends q {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f24018b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f24019c = null;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f24020d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f24021e;

    /* renamed from: f  reason: collision with root package name */
    private long f24022f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public r(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f24018b, f24019c));
    }

    private r(e eVar, View view, Object[] objArr) {
        super(eVar, view);
        this.f24022f = -1;
        this.f24020d = objArr[0];
        this.f24020d.setTag((Object) null);
        this.f24021e = objArr[1];
        this.f24021e.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f24022f = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f24022f != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f23481e != i2) {
            return false;
        }
        this.f24017a = (String) obj;
        synchronized (this) {
            this.f24022f |= 1;
        }
        notifyPropertyChanged(a.f23481e);
        super.requestRebind();
        return true;
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f24022f;
            this.f24022f = 0;
        }
        String str = this.f24017a;
        if ((j & 3) != 0) {
            d.a(this.f24021e, (CharSequence) str);
        }
    }
}
