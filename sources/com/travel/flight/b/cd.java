package com.travel.flight.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.d;
import androidx.databinding.e;
import com.travel.flight.a;
import com.travel.flight.pojo.Item;
import com.travel.flight.utils.m;

public final class cd extends cc {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewDataBinding.b f23790b = null;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f23791c = null;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f23792d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f23793e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f23794f;

    /* renamed from: g  reason: collision with root package name */
    private long f23795g;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public cd(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, f23790b, f23791c));
    }

    private cd(e eVar, View view, Object[] objArr) {
        super(eVar, view);
        this.f23795g = -1;
        this.f23792d = objArr[0];
        this.f23792d.setTag((Object) null);
        this.f23793e = objArr[1];
        this.f23793e.setTag((Object) null);
        this.f23794f = objArr[2];
        this.f23794f.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.f23795g = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f23795g != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.f23478b != i2) {
            return false;
        }
        a((Item) obj);
        return true;
    }

    public final void a(Item item) {
        this.f23789a = item;
        synchronized (this) {
            this.f23795g |= 1;
        }
        notifyPropertyChanged(a.f23478b);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f23795g;
            this.f23795g = 0;
        }
        Item item = this.f23789a;
        boolean z = false;
        Integer num = null;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 == 0 || item == null) {
            str = null;
        } else {
            z = item.isBold();
            num = item.getPrice();
            str = item.getText();
        }
        if (i2 != 0) {
            m.a(this.f23793e, Boolean.valueOf(z));
            d.a(this.f23793e, (CharSequence) str);
            m.a(this.f23794f, Boolean.valueOf(z));
            m.a(this.f23794f, num);
        }
    }
}
