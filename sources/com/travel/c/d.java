package com.travel.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.travel.R;

public final class d extends c {
    private static final ViewDataBinding.b v = null;
    private static final SparseIntArray w;
    private final ConstraintLayout x;
    private long y;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        w = sparseIntArray;
        sparseIntArray.put(R.id.top_layout, 1);
        w.put(R.id.startDateIcon, 2);
        w.put(R.id.tv_title, 3);
        w.put(R.id.cityName, 4);
        w.put(R.id.selected_date, 5);
        w.put(R.id.sep_view, 6);
        w.put(R.id.iv_calendar_close_view, 7);
        w.put(R.id.tab_layout_container, 8);
        w.put(R.id.common_calendar_tab_layout, 9);
        w.put(R.id.ll_custom_tab_strip, 10);
        w.put(R.id.departure_tab, 11);
        w.put(R.id.return_tab, 12);
        w.put(R.id.iv_tab_arrow, 13);
        w.put(R.id.common_calendar_view_page, 14);
        w.put(R.id.calendar_bottom_layout, 15);
        w.put(R.id.checkinDateTv, 16);
        w.put(R.id.checkoutDateTv, 17);
        w.put(R.id.daysCountLayout, 18);
        w.put(R.id.night_count, 19);
        w.put(R.id.nightText, 20);
        w.put(R.id.selectDateButton, 21);
    }

    public d(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 22, v, w));
    }

    private d(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[15], objArr[16], objArr[17], objArr[4], objArr[9], objArr[14], objArr[18], objArr[11], objArr[7], objArr[13], objArr[10], objArr[19], objArr[20], objArr[12], objArr[21], objArr[5], objArr[6], objArr[2], objArr[8], objArr[1], objArr[3]);
        this.y = -1;
        this.x = objArr[0];
        this.x.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.y = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.y != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.y = 0;
        }
    }
}
