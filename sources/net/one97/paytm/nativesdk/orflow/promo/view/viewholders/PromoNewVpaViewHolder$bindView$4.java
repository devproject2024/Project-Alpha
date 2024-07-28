package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;

public final class PromoNewVpaViewHolder$bindView$4 implements View.OnKeyListener {
    final /* synthetic */ PromoNewVpaViewHolder this$0;

    PromoNewVpaViewHolder$bindView$4(PromoNewVpaViewHolder promoNewVpaViewHolder) {
        this.this$0 = promoNewVpaViewHolder;
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (i2 != 66) {
            return false;
        }
        SDKUtility.hideKeyboard((AppCompatEditText) this.this$0.getMView().findViewById(R.id.etNewVPA), this.this$0.getMContext());
        return false;
    }
}
