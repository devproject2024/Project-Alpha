package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.ExtensionsKt;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.LogUtility;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.paymethods.factory.TranscationViewModelFactory;
import net.one97.paytm.nativesdk.paymethods.viewmodel.TranscationStatus;
import net.one97.paytm.nativesdk.paymethods.viewmodel.TranscationViewModel;
import net.one97.paytm.nativesdk.paymethods.widgets.CustomInstrumentsToolbar;
import org.json.JSONObject;

public final class OrderSummaryFragment extends f {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "OrderSummaryFragment";
    private HashMap _$_findViewCache;
    private Bundle transcationResponseBundle;
    private String transcationStatus;
    private TranscationViewModel transcationViewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TranscationStatus.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TranscationStatus.TXN_SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0[TranscationStatus.PENDING.ordinal()] = 2;
            $EnumSwitchMapping$0[TranscationStatus.TXN_FAILURE.ordinal()] = 3;
        }
    }

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

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        try {
            q a2 = jVar.a();
            k.a((Object) a2, "manager.beginTransaction()");
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException e2) {
            LogUtility.printStackTrace(e2);
        }
    }

    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(SDKConstants.STATUS)) == null) {
            str = "";
        }
        this.transcationStatus = str;
        Bundle arguments2 = getArguments();
        this.transcationResponseBundle = arguments2 != null ? arguments2.getBundle("data") : null;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.order_summary, viewGroup, false);
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        String str = this.transcationStatus;
        if (str == null) {
            k.a("transcationStatus");
        }
        ai a2 = new al((ao) this, (al.b) new TranscationViewModelFactory(context, str)).a(TranscationViewModel.class);
        k.a((Object) a2, "ViewModelProvider(this, …elFactory)[T::class.java]");
        this.transcationViewModel = (TranscationViewModel) a2;
        return inflate;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((CustomInstrumentsToolbar) _$_findCachedViewById(R.id.toolbar)).setBackOnClickListener(new OrderSummaryFragment$onViewCreated$1(this));
        ((CustomInstrumentsToolbar) _$_findCachedViewById(R.id.toolbar)).setToolbarValues();
        Bundle bundle2 = this.transcationResponseBundle;
        String str = null;
        String optString = new JSONObject(bundle2 != null ? bundle2.getString(SDKConstants.RESPONSE, "") : null).optString(SDKConstants.AI_TXN_AMOUNT);
        if (!TextUtils.isEmpty(optString)) {
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.nativesdk_amount_pay, new Object[]{String.valueOf(SDKUtility.parseDouble(optString))});
            }
        } else {
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            str = merchantInstance.getAmount();
        }
        ((CustomInstrumentsToolbar) _$_findCachedViewById(R.id.toolbar)).setAppInvokeStatusAmount(str);
        ((CustomInstrumentsToolbar) _$_findCachedViewById(R.id.toolbar)).setBackButtonVisibility(false);
        TranscationViewModel transcationViewModel2 = this.transcationViewModel;
        if (transcationViewModel2 == null) {
            k.a("transcationViewModel");
        }
        transcationViewModel2.getOrderStatusLiveData().observe(getViewLifecycleOwner(), new OrderSummaryFragment$onViewCreated$2(this));
    }

    /* access modifiers changed from: private */
    public final void inflateSuccessView() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.payment_status);
        textView.setText(textView.getResources().getString(R.string.payment_success));
        textView.setTextColor(b.c(textView.getContext(), R.color.success_color));
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.payment_description);
        k.a((Object) textView2, "payment_description");
        textView2.setText(getResources().getString(R.string.payment_success_desc));
        LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(R.id.payment_image);
        k.a((Object) lottieAnimationView, "payment_image");
        ExtensionsKt.startLoaderAnimation(lottieAnimationView, R.raw.payment_success_tick, 0.5f);
    }

    /* access modifiers changed from: private */
    public final void inflateFailureView() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.payment_status);
        textView.setText(textView.getResources().getString(R.string.payment_failure));
        textView.setTextColor(b.c(textView.getContext(), R.color.failed_color));
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.payment_description);
        k.a((Object) textView2, "payment_description");
        textView2.setText(getResources().getString(R.string.payment_failure_desc));
        LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(R.id.payment_image);
        k.a((Object) lottieAnimationView, "payment_image");
        ExtensionsKt.startLoaderAnimation(lottieAnimationView, R.raw.cancel_animation, 0.5f);
    }

    /* access modifiers changed from: private */
    public final void inflatePendingView() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.payment_status);
        textView.setText(textView.getResources().getString(R.string.payment_pending));
        textView.setTextColor(b.c(textView.getContext(), R.color.pending_color));
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.payment_description);
        k.a((Object) textView2, "payment_description");
        textView2.setText(getResources().getString(R.string.payment_pending_desc));
        LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(R.id.payment_image);
        k.a((Object) lottieAnimationView, "payment_image");
        ExtensionsKt.startLoaderAnimation(lottieAnimationView, R.raw.pending_animation, 0.5f);
    }
}
