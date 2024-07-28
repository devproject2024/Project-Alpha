package net.one97.paytm.nativesdk.orflow.promo.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.BaseBottomSheetDialogFragment;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.datasource.PromoSearchRepository;

public final class OfferDetailBottomSheet extends BaseBottomSheetDialogFragment {
    private HashMap _$_findViewCache;
    private String offerText = "";
    private String promoCode = "";
    private String tncUrl;

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

    public final String getPromoCode() {
        return this.promoCode;
    }

    public final void setPromoCode(String str) {
        this.promoCode = str;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final void setOfferText(String str) {
        this.offerText = str;
    }

    public final String getTncUrl() {
        return this.tncUrl;
    }

    public final void setTncUrl(String str) {
        this.tncUrl = str;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        String str = null;
        this.promoCode = bundle != null ? bundle.getString("promoCode") : null;
        this.offerText = bundle != null ? bundle.getString("offerText") : null;
        if (bundle != null) {
            str = bundle.getString("tncUrl");
        }
        this.tncUrl = str;
        Utility.INSTANCE.sendBankOffersEvent(getContext(), Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_PROMOCODE, Utility.ACTION_OFFERDETAIL_LOADED, PromoHelper.Companion.getInstance().getVerticalName(), ""));
    }

    public final int getLayoutId() {
        return R.layout.offer_detail_sheet;
    }

    public final void initView() {
        String str = this.promoCode;
        if (str != null) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvPromoCode);
            k.a((Object) textView, "tvPromoCode");
            textView.setText(str);
        }
        ((ImageView) _$_findCachedViewById(R.id.ivClose)).setOnClickListener(new OfferDetailBottomSheet$initView$2(this));
        if (!TextUtils.isEmpty(this.offerText)) {
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvOfferDetail);
            k.a((Object) textView2, "tvOfferDetail");
            textView2.setText(Html.fromHtml(this.offerText));
        } else if (!TextUtils.isEmpty(this.tncUrl)) {
            showLoading();
            PromoSearchRepository.Companion companion = PromoSearchRepository.Companion;
            Context context = getContext();
            Context applicationContext = context != null ? context.getApplicationContext() : null;
            if (applicationContext == null) {
                k.a();
            }
            PromoSearchRepository instance = companion.getInstance(applicationContext);
            String str2 = this.tncUrl;
            if (str2 == null) {
                k.a();
            }
            instance.getOfferDetail(str2, new OfferDetailBottomSheet$initView$3(this));
        }
    }

    private final void showLoading() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading);
        k.a((Object) lottieAnimationView2, "ltv_loading");
        lottieAnimationView2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void hideLoading() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) _$_findCachedViewById(R.id.ltv_loading);
        k.a((Object) lottieAnimationView2, "ltv_loading");
        lottieAnimationView2.setVisibility(8);
    }
}
