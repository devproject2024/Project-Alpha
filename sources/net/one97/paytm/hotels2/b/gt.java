package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import net.one97.paytm.hotels2.R;

public final class gt extends gs {
    private static final ViewDataBinding.b T = null;
    private static final SparseIntArray U;
    private final ConstraintLayout V;
    private long W;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    public final boolean setVariable(int i2, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        U = sparseIntArray;
        sparseIntArray.put(R.id.topBackground, 1);
        U.put(R.id.topBackgroundImage, 2);
        U.put(R.id.backButton, 3);
        U.put(R.id.headerImage, 4);
        U.put(R.id.orderStatus, 5);
        U.put(R.id.bookingID, 6);
        U.put(R.id.line, 7);
        U.put(R.id.iv_hotelCard, 8);
        U.put(R.id.iv_hotel, 9);
        U.put(R.id.iv_direction, 10);
        U.put(R.id.tv_hotel_name, 11);
        U.put(R.id.tv_hotel_address, 12);
        U.put(R.id.line_bottom, 13);
        U.put(R.id.hotelIcon2, 14);
        U.put(R.id.suitName, 15);
        U.put(R.id.guestsCount, 16);
        U.put(R.id.checkInDate, 17);
        U.put(R.id.checkInTime, 18);
        U.put(R.id.constraint_2, 19);
        U.put(R.id.night_count, 20);
        U.put(R.id.checkOutDate, 21);
        U.put(R.id.checkOutTime, 22);
        U.put(R.id.v_line_divi, 23);
        U.put(R.id.tv_title, 24);
        U.put(R.id.iv_hotelRoomCard, 25);
        U.put(R.id.roomIcon, 26);
        U.put(R.id.tv_room_title, 27);
        U.put(R.id.tv_room_sub_title, 28);
        U.put(R.id.rv_room_config, 29);
        U.put(R.id.v_line, 30);
        U.put(R.id.tv_tax, 31);
        U.put(R.id.rv_room_config_tax, 32);
        U.put(R.id.v_line_one, 33);
        U.put(R.id.tv_total_text, 34);
        U.put(R.id.tv_total_value, 35);
        U.put(R.id.separator, 36);
        U.put(R.id.bottomButtons, 37);
        U.put(R.id.saveVoucher, 38);
        U.put(R.id.saveVoucherImage, 39);
        U.put(R.id.emailVoucher, 40);
        U.put(R.id.emailVoucherImage, 41);
        U.put(R.id.callHotel, 42);
        U.put(R.id.callImage, 43);
        U.put(R.id.cancelBooking, 44);
        U.put(R.id.cancelImage, 45);
    }

    public gt(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 46, T, U));
    }

    private gt(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[3], objArr[6], objArr[37], objArr[42], objArr[43], objArr[44], objArr[45], objArr[17], objArr[18], objArr[21], objArr[22], objArr[19], objArr[40], objArr[41], objArr[16], objArr[4], objArr[14], objArr[10], objArr[9], objArr[8], objArr[25], objArr[7], objArr[13], objArr[20], objArr[5], objArr[26], objArr[29], objArr[32], objArr[38], objArr[39], objArr[36], objArr[15], objArr[1], objArr[2], objArr[12], objArr[11], objArr[28], objArr[27], objArr[31], objArr[24], objArr[34], objArr[35], objArr[30], objArr[23], objArr[33]);
        this.W = -1;
        this.V = objArr[0];
        this.V.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.W = 1;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.W != 0) {
                return true;
            }
            return false;
        }
    }

    public final void executeBindings() {
        synchronized (this) {
            this.W = 0;
        }
    }
}
