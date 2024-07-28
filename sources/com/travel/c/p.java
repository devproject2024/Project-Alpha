package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.R;

public final class p extends o {
    private static final ViewDataBinding.b s = null;
    private static final SparseIntArray t;
    private final ConstraintLayout u;
    private long v;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.live_image, 1);
        t.put(R.id.day_count, 2);
        t.put(R.id.day_text, 3);
        t.put(R.id.day_value, 4);
        t.put(R.id.hour_count, 5);
        t.put(R.id.hour_text, 6);
        t.put(R.id.hour_value, 7);
        t.put(R.id.minute_count, 8);
        t.put(R.id.minute_text, 9);
        t.put(R.id.minute_value, 10);
        t.put(R.id.second_count, 11);
        t.put(R.id.second_text, 12);
        t.put(R.id.second_value, 13);
        t.put(R.id.book_now_btn, 14);
        t.put(R.id.book_now_text, 15);
        t.put(R.id.live_title, 16);
        t.put(R.id.counter_title, 17);
        t.put(R.id.share_button, 18);
    }

    public p(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 19, s, t));
    }

    private p(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[14], objArr[15], objArr[17], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[1], objArr[16], objArr[8], objArr[9], objArr[10], objArr[11], objArr[12], objArr[13], objArr[18]);
        this.v = -1;
        this.u = objArr[0];
        this.u.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.v = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.v != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.v = 0;
        }
    }
}
