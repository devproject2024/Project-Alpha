package net.one97.paytm.nativesdk.orflow.promo.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;

public final class PromoSearchActivity$addEditTextFocusListener$1 implements TextWatcher {
    final /* synthetic */ PromoSearchActivity this$0;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    PromoSearchActivity$addEditTextFocusListener$1(PromoSearchActivity promoSearchActivity) {
        this.this$0 = promoSearchActivity;
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.this$0.hidePromoError();
        if (charSequence == null || charSequence.length() != 0) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.tvApplyOfferButton);
            k.a((Object) textView, "tvApplyOfferButton");
            textView.setVisibility(0);
            ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(R.id.ivEditCross);
            k.a((Object) imageView, "ivEditCross");
            imageView.setVisibility(0);
            return;
        }
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(R.id.tvApplyOfferButton);
        k.a((Object) textView2, "tvApplyOfferButton");
        textView2.setVisibility(8);
        ImageView imageView2 = (ImageView) this.this$0._$_findCachedViewById(R.id.ivEditCross);
        k.a((Object) imageView2, "ivEditCross");
        imageView2.setVisibility(8);
    }
}
