package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.a;
import com.travel.flight.pojo.Info;

public final class bx extends bw {

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.b f23759d = null;

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f23760e = null;

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f23761f;

    /* renamed from: g  reason: collision with root package name */
    private long f23762g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public bx(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f23759d, f23760e));
    }

    private bx(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1], objArr[2]);
        this.f23762g = -1;
        this.f23756a.setTag((Object) null);
        this.f23761f = objArr[0];
        this.f23761f.setTag((Object) null);
        this.f23757b.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23762g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23762g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.v != i2) {
            return false;
        }
        a((Info) obj);
        return true;
    }

    public final void a(Info info) {
        this.f23758c = info;
        synchronized (this) {
            this.f23762g |= 1;
        }
        notifyPropertyChanged(a.v);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f23762g;
            this.f23762g = 0;
        }
        Info info = this.f23758c;
        String str2 = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 == 0 || info == null) {
            str = null;
        } else {
            str2 = info.getDesc();
            str = info.getTitle();
        }
        if (i2 != 0) {
            d.a(this.f23756a, (CharSequence) str);
            d.a(this.f23757b, (CharSequence) str2);
        }
    }
}
