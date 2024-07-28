package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.R;

public final class h extends g {

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.b f22887h = null;

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f22888i;
    private long j;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f22888i = sparseIntArray;
        sparseIntArray.put(R.id.share_card_view, 1);
        f22888i.put(R.id.share_calendar_container, 2);
        f22888i.put(R.id.share_title, 3);
        f22888i.put(R.id.share_descritpion, 4);
        f22888i.put(R.id.share_button, 5);
        f22888i.put(R.id.share_button_text, 6);
    }

    public h(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, f22887h, f22888i));
    }

    private h(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[0], objArr[5], objArr[6], objArr[2], objArr[1], objArr[4], objArr[3]);
        this.j = -1;
        this.f22880a.setTag((Object) null);
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
