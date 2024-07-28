package net.one97.paytm.nativesdk.orflow.promo.view.nb;

import android.view.View;
import android.widget.EditText;
import net.one97.paytm.nativesdk.R;

final class PromoNetBankingSheet$initView$5 implements View.OnClickListener {
    final /* synthetic */ PromoNetBankingSheet this$0;

    PromoNetBankingSheet$initView$5(PromoNetBankingSheet promoNetBankingSheet) {
        this.this$0 = promoNetBankingSheet;
    }

    public final void onClick(View view) {
        ((EditText) this.this$0.getMView().findViewById(R.id.searchView)).setText("");
    }
}
