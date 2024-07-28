package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.helpers.GTMLoader;
import net.one97.paytm.nativesdk.orflow.BaseBottomSheetDialogFragment;

public final class VisaInfoBottomSheet extends BaseBottomSheetDialogFragment {
    public static final Companion Companion = new Companion((g) null);
    public static final String KEY_CARD_TYPE = "card type";
    public static final String KEY_FLOW_TYPE = "flow type";
    public static final String KEY_INFO_MESSAGE = "info message";
    public static final String KEY_INFO_NOTE = "info note";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String cardType;
    /* access modifiers changed from: private */
    public String flowType;
    private String gtmTitle;
    private String infoMessage;
    private String infoNote;
    private String maxAmount = "2000";

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

    public static final /* synthetic */ String access$getCardType$p(VisaInfoBottomSheet visaInfoBottomSheet) {
        String str = visaInfoBottomSheet.cardType;
        if (str == null) {
            k.a("cardType");
        }
        return str;
    }

    public static final /* synthetic */ String access$getFlowType$p(VisaInfoBottomSheet visaInfoBottomSheet) {
        String str = visaInfoBottomSheet.flowType;
        if (str == null) {
            k.a("flowType");
        }
        return str;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final int getLayoutId() {
        return R.layout.visa_info_view;
    }

    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle == null || (str = bundle.getString("amount")) == null) {
            str = "2000";
        }
        this.maxAmount = str;
        String priceWithoutDecimal = SDKUtility.priceWithoutDecimal(this.maxAmount);
        k.a((Object) priceWithoutDecimal, "SDKUtility.priceWithoutDecimal(maxAmount)");
        this.maxAmount = priceWithoutDecimal;
        if (bundle == null || (str2 = bundle.getString(KEY_INFO_MESSAGE, "")) == null) {
            str2 = "";
        }
        this.infoMessage = str2;
        if (bundle == null || (str3 = bundle.getString(KEY_INFO_NOTE, "")) == null) {
            str3 = "";
        }
        this.infoNote = str3;
        if (bundle == null || (str4 = bundle.getString(KEY_CARD_TYPE, "")) == null) {
            str4 = "";
        }
        this.cardType = str4;
        if (bundle == null || (str5 = bundle.getString(KEY_FLOW_TYPE, "")) == null) {
            str5 = "";
        }
        this.flowType = str5;
        this.gtmTitle = GTMLoader.getString(SDKConstants.KEY_SCP_PAYMENT_TITLE);
    }

    public final void initView() {
        ExtensionsKt.isNotNullNotBlank(this.gtmTitle, new VisaInfoBottomSheet$initView$1(this));
        String str = this.infoMessage;
        if (str == null) {
            k.a("infoMessage");
        }
        ExtensionsKt.isNotNullNotBlank(str, new VisaInfoBottomSheet$initView$2(this));
        String str2 = this.infoNote;
        if (str2 == null) {
            k.a("infoNote");
        }
        ExtensionsKt.isNotNullNotBlank(str2, new VisaInfoBottomSheet$initView$3(this));
        ((LottieAnimationView) getMView().findViewById(R.id.ivOneClickIcon)).setAnimation(R.raw.one_click_animation);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ivOneClickIcon);
        k.a((Object) lottieAnimationView, "mView.ivOneClickIcon");
        lottieAnimationView.setRepeatCount(-1);
        ((LottieAnimationView) getMView().findViewById(R.id.ivOneClickIcon)).playAnimation();
        ((TextView) getMView().findViewById(R.id.tnc)).setOnClickListener(new VisaInfoBottomSheet$initView$4(this));
    }
}
