package net.one97.paytm.nativesdk.orflow.promo.view;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.BaseBottomSheetDialogFragment;

public final class PromoOfferDetailSheet extends BaseBottomSheetDialogFragment {
    public static final Companion Companion = new Companion((g) null);
    private HashMap _$_findViewCache;
    private String offerText = "";
    private String promoText = "";

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final String getPromoText() {
        return this.promoText;
    }

    public final void setPromoText(String str) {
        this.promoText = str;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final void setOfferText(String str) {
        this.offerText = str;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final PromoOfferDetailSheet getInstance(String str, String str2) {
            k.c(str, "promoText");
            k.c(str2, "offerText");
            PromoOfferDetailSheet promoOfferDetailSheet = new PromoOfferDetailSheet();
            Bundle bundle = new Bundle();
            bundle.putString("promoText", str);
            bundle.putString("offerText", str2);
            promoOfferDetailSheet.setArguments(bundle);
            return promoOfferDetailSheet;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        String str = null;
        this.promoText = bundle != null ? bundle.getString("promoText") : null;
        if (bundle != null) {
            str = bundle.getString("offerText");
        }
        this.offerText = str;
    }

    public final int getLayoutId() {
        return R.layout.promo_offer_detail_sheet;
    }

    public final void initView() {
        String str = this.promoText;
        if (str != null) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvPromoText);
            k.a((Object) textView, "tvPromoText");
            textView.setText(Html.fromHtml(str));
        }
        String str2 = this.offerText;
        if (str2 != null) {
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvOfferDetailText);
            k.a((Object) textView2, "tvOfferDetailText");
            textView2.setText(Html.fromHtml(str2));
        }
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setOnClickListener(new PromoOfferDetailSheet$initView$3(this));
    }
}
