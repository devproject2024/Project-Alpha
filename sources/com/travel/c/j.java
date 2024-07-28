package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.R;

public final class j extends i {

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.b f22895g = null;

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f22896h;

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f22897i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22896h = sparseIntArray;
        sparseIntArray.put(R.id.week_layout, 1);
        f22896h.put(R.id.calendarLinearLayout, 2);
        f22896h.put(R.id.calendar_view, 3);
        f22896h.put(R.id.fare_disclaimer_container, 4);
        f22896h.put(R.id.disclaimer_view, 5);
        f22896h.put(R.id.fare_disclaimer_text, 6);
    }

    public j(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f22895g, f22896h));
    }

    private j(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[2], objArr[3], objArr[5], objArr[4], objArr[6], objArr[1]);
        this.j = -1;
        this.f22897i = objArr[0];
        this.f22897i.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.j = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.j != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.j = 0;
        }
    }
}
