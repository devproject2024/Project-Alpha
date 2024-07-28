package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;

public final class gp extends go {
    private static final ViewDataBinding.b w = null;
    private static final SparseIntArray x;
    private final ConstraintLayout y;
    private long z;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x = sparseIntArray;
        sparseIntArray.put(R.id.view_image_selector_top, 1);
        x.put(R.id.view_image_selector_bottom_start, 2);
        x.put(R.id.view_image_selector_bottom_mid, 3);
        x.put(R.id.view_image_selector_bottom_end, 4);
        x.put(R.id.view_header, 5);
        x.put(R.id.tv_title, 6);
        x.put(R.id.sub_title, 7);
        x.put(R.id.imageButton2, 8);
        x.put(R.id.tv_no_night, 9);
        x.put(R.id.tv_cashback, 10);
        x.put(R.id.view_cin_cout, 11);
        x.put(R.id.tv_checkin, 12);
        x.put(R.id.tv_checkout, 13);
        x.put(R.id.tv_night_moon_root, 14);
        x.put(R.id.tv_night_moon, 15);
        x.put(R.id.iv_bullet_first, 16);
        x.put(R.id.tv_checkin_first, 17);
        x.put(R.id.iv_bullet_second, 18);
        x.put(R.id.tv_checkin_second, 19);
        x.put(R.id.iv_bullet_third, 20);
        x.put(R.id.tv_checkin_third, 21);
        x.put(R.id.btn_select_room_shimmer, 22);
    }

    public gp(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 23, w, x));
    }

    private gp(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[22], objArr[8], objArr[16], objArr[18], objArr[20], objArr[7], objArr[10], objArr[12], objArr[17], objArr[19], objArr[21], objArr[13], objArr[15], objArr[14], objArr[9], objArr[6], objArr[11], objArr[5], objArr[4], objArr[3], objArr[2], objArr[1]);
        this.z = -1;
        this.y = objArr[0];
        this.y.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.z = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.z != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.z = 0;
        }
    }
}
