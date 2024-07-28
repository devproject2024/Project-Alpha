package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;

final class PromoNewCardViewHolder$initView$2 implements View.OnClickListener {
    final /* synthetic */ PromoNewCardViewHolder this$0;

    PromoNewCardViewHolder$initView$2(PromoNewCardViewHolder promoNewCardViewHolder) {
        this.this$0 = promoNewCardViewHolder;
    }

    public final void onClick(View view) {
        AppCompatEditText appCompatEditText = (AppCompatEditText) this.this$0.getMView().findViewById(R.id.etCardNumber);
        k.a((Object) appCompatEditText, "mView.etCardNumber");
        Editable text = appCompatEditText.getText();
        if (text != null) {
            text.clear();
        }
        ImageView imageView = (ImageView) this.this$0.getMView().findViewById(R.id.iv_cross);
        k.a((Object) imageView, "mView.iv_cross");
        imageView.setVisibility(8);
        ImageView imageView2 = (ImageView) this.this$0.getMView().findViewById(R.id.iv_card_logo);
        k.a((Object) imageView2, "mView.iv_card_logo");
        imageView2.setVisibility(8);
    }
}
