package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.flight.a;
import com.travel.flight.pojo.PaymentDetail;
import com.travel.flight.utils.m;
import java.util.List;

public final class bl extends bk {

    /* renamed from: c  reason: collision with root package name */
    private static final ViewDataBinding.b f23708c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f23709d = null;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f23710e;

    /* renamed from: f  reason: collision with root package name */
    private long f23711f;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public bl(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, f23708c, f23709d));
    }

    private bl(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[1]);
        this.f23711f = -1;
        this.f23710e = objArr[0];
        this.f23710e.setTag((Object) null);
        this.f23706a.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23711f = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23711f != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.u != i2) {
            return false;
        }
        a((List) obj);
        return true;
    }

    public final void a(List<PaymentDetail> list) {
        this.f23707b = list;
        synchronized (this) {
            this.f23711f |= 1;
        }
        notifyPropertyChanged(a.u);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f23711f;
            this.f23711f = 0;
        }
        List list = this.f23707b;
        if ((j & 3) != 0) {
            m.b(this.f23706a, list);
        }
    }
}
