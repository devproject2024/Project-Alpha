package net.one97.paytm.hotels2.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.paytm.utility.RoboTextView;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.a;
import net.one97.paytm.hotels2.c.a.b;

public final class ax extends aw implements b.a {
    private static final ViewDataBinding.b B = null;
    private static final SparseIntArray C;
    private final RelativeLayout D;
    private final RoboTextView E;
    private final View.OnClickListener F;
    private long G;

    public final boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        C = sparseIntArray;
        sparseIntArray.put(R.id.toolbar_offers_new, 2);
        C.put(R.id.toolbar_btn_back, 3);
        C.put(R.id.title, 4);
        C.put(R.id.doneButton, 5);
        C.put(R.id.toolbar_divider, 6);
        C.put(R.id.offers_layout, 7);
        C.put(R.id.promocode_lyt, 8);
        C.put(R.id.promocode_input_lyt, 9);
        C.put(R.id.promo_remove_image, 10);
        C.put(R.id.edit_txt_promocode, 11);
        C.put(R.id.apply_btn_lyt, 12);
        C.put(R.id.promocode_success_lyt, 13);
        C.put(R.id.success_promo_code, 14);
        C.put(R.id.apply_tick_image, 15);
        C.put(R.id.view_divider, 16);
        C.put(R.id.promo_status_message, 17);
        C.put(R.id.choose_offer_header, 18);
        C.put(R.id.second_view_divider, 19);
        C.put(R.id.offers_list_lyt, 20);
        C.put(R.id.offers_list, 21);
        C.put(R.id.no_offers_layout, 22);
        C.put(R.id.offer_txt_lyt, 23);
        C.put(R.id.cash_back_text, 24);
        C.put(R.id.cash_back_offer_divider, 25);
        C.put(R.id.wallet_loyality_cash_back_text, 26);
        C.put(R.id.update_progress_bar_offers, 27);
    }

    public ax(e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 28, B, C));
    }

    private ax(e eVar, View view, Object[] objArr) {
        super(eVar, view, objArr[12], objArr[15], objArr[25], objArr[24], objArr[18], objArr[5], objArr[11], objArr[22], objArr[23], objArr[7], objArr[21], objArr[20], objArr[10], objArr[17], objArr[9], objArr[8], objArr[13], objArr[19], objArr[14], objArr[4], objArr[3], objArr[6], objArr[2], objArr[27], objArr[16], objArr[26]);
        this.G = -1;
        this.D = objArr[0];
        this.D.setTag((Object) null);
        this.E = objArr[1];
        this.E.setTag((Object) null);
        setRootTag(view);
        this.F = new b(this, 1);
        invalidateAll();
    }

    public final void invalidateAll() {
        synchronized (this) {
            this.G = 2;
        }
        requestRebind();
    }

    public final boolean hasPendingBindings() {
        synchronized (this) {
            if (this.G != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean setVariable(int i2, Object obj) {
        if (a.j != i2) {
            return false;
        }
        a((ReviewViewModel) obj);
        return true;
    }

    public final void a(ReviewViewModel reviewViewModel) {
        this.A = reviewViewModel;
        synchronized (this) {
            this.G |= 1;
        }
        notifyPropertyChanged(a.j);
        super.requestRebind();
    }

    public final void executeBindings() {
        long j;
        synchronized (this) {
            j = this.G;
            this.G = 0;
        }
        if ((j & 2) != 0) {
            this.E.setOnClickListener(this.F);
        }
    }

    public final void a(int i2) {
        ReviewViewModel reviewViewModel = this.A;
        if (reviewViewModel != null) {
            reviewViewModel.applyPromoCodeButtonCLicked();
        }
    }
}
