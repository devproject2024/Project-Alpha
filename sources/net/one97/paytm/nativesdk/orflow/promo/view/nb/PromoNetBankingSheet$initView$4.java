package net.one97.paytm.nativesdk.orflow.promo.view.nb;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Filter;
import android.widget.ImageView;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;

public final class PromoNetBankingSheet$initView$4 implements TextWatcher {
    final /* synthetic */ PromoNetBankingSheet this$0;

    public final void afterTextChanged(Editable editable) {
        k.c(editable, "s");
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        k.c(charSequence, "s");
    }

    PromoNetBankingSheet$initView$4(PromoNetBankingSheet promoNetBankingSheet) {
        this.this$0 = promoNetBankingSheet;
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        PromoAllNetBankingAdapter access$getMAllNetBankingAdapter$p;
        Filter filter;
        k.c(charSequence, "newText");
        if (TextUtils.isEmpty(charSequence)) {
            ((ImageView) this.this$0.getMView().findViewById(R.id.img_edt_cross)).setVisibility(8);
        } else {
            ((ImageView) this.this$0.getMView().findViewById(R.id.img_edt_cross)).setVisibility(0);
        }
        if (this.this$0.mAllNetBankingAdapter != null && (access$getMAllNetBankingAdapter$p = this.this$0.mAllNetBankingAdapter) != null && (filter = access$getMAllNetBankingAdapter$p.getFilter()) != null) {
            filter.filter(charSequence);
        }
    }
}
