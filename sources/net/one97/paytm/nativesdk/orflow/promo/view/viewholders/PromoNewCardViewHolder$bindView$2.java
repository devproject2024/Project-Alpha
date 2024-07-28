package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;

public final class PromoNewCardViewHolder$bindView$2 implements View.OnKeyListener {
    final /* synthetic */ PromoNewCardViewHolder this$0;

    PromoNewCardViewHolder$bindView$2(PromoNewCardViewHolder promoNewCardViewHolder) {
        this.this$0 = promoNewCardViewHolder;
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (i2 != 66) {
            return false;
        }
        SDKUtility.hideKeyboard((AppCompatEditText) this.this$0.getMView().findViewById(R.id.etCardNumber), this.this$0.getMContext());
        return false;
    }
}
