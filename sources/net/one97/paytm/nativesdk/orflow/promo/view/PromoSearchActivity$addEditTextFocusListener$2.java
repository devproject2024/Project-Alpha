package net.one97.paytm.nativesdk.orflow.promo.view;

import android.content.Context;
import android.view.View;
import androidx.core.content.b;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;

final class PromoSearchActivity$addEditTextFocusListener$2 implements View.OnFocusChangeListener {
    final /* synthetic */ PromoSearchActivity this$0;

    PromoSearchActivity$addEditTextFocusListener$2(PromoSearchActivity promoSearchActivity) {
        this.this$0 = promoSearchActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            Utility.INSTANCE.sendBankOffersEvent(this.this$0, Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_PROMOCODE, Utility.ACTION_PROMOCODE_CLICKED, PromoHelper.Companion.getInstance().getVerticalName(), ""));
            TextInputEditText textInputEditText = (TextInputEditText) this.this$0._$_findCachedViewById(R.id.tietEnterPromo);
            k.a((Object) textInputEditText, "tietEnterPromo");
            textInputEditText.setBackground(b.a((Context) this.this$0, R.drawable.edit_text_blue_line));
            return;
        }
        TextInputEditText textInputEditText2 = (TextInputEditText) this.this$0._$_findCachedViewById(R.id.tietEnterPromo);
        k.a((Object) textInputEditText2, "tietEnterPromo");
        textInputEditText2.setBackground(b.a((Context) this.this$0, R.drawable.edit_text_grey_line));
    }
}
