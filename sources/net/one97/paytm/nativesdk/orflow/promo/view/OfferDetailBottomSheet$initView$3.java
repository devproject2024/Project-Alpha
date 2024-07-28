package net.one97.paytm.nativesdk.orflow.promo.view;

import android.text.Html;
import android.widget.TextView;
import com.android.volley.VolleyError;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.datasource.PromoDataSource;
import net.one97.paytm.nativesdk.orflow.promo.model.OfferDetailModel;

public final class OfferDetailBottomSheet$initView$3 implements PromoDataSource.Callback<OfferDetailModel> {
    final /* synthetic */ OfferDetailBottomSheet this$0;

    OfferDetailBottomSheet$initView$3(OfferDetailBottomSheet offerDetailBottomSheet) {
        this.this$0 = offerDetailBottomSheet;
    }

    public final void onResponse(OfferDetailModel offerDetailModel) {
        String terms;
        this.this$0.hideLoading();
        if (offerDetailModel != null && (terms = offerDetailModel.getTerms()) != null) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(R.id.tvOfferDetail);
            k.a((Object) textView, "tvOfferDetail");
            textView.setText(Html.fromHtml(terms));
        }
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.this$0.hideLoading();
    }
}
