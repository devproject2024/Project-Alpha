package net.one97.paytm.nativesdk.orflow.promo.view.viewholders;

import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;

final class PromoNewVpaViewHolder$bindView$2 implements View.OnClickListener {
    final /* synthetic */ PromoNewVpaViewHolder this$0;

    PromoNewVpaViewHolder$bindView$2(PromoNewVpaViewHolder promoNewVpaViewHolder) {
        this.this$0 = promoNewVpaViewHolder;
    }

    public final void onClick(View view) {
        AppCompatEditText appCompatEditText = (AppCompatEditText) this.this$0.getMView().findViewById(R.id.etNewVPA);
        k.a((Object) appCompatEditText, "mView.etNewVPA");
        Editable text = appCompatEditText.getText();
        if (text != null) {
            text.clear();
        }
        ImageView imageView = (ImageView) this.this$0.getMView().findViewById(R.id.iv_cross);
        k.a((Object) imageView, "mView.iv_cross");
        imageView.setVisibility(8);
    }
}
