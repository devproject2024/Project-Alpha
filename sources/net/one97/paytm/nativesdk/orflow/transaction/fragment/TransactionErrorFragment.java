package net.one97.paytm.nativesdk.orflow.transaction.fragment;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.interfaces.OrFlowCallbackListener;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;
import net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment;
import net.one97.paytm.nativesdk.orflow.transaction.TransactionDialogListener;
import net.one97.paytm.nativesdk.orflow.transaction.activity.BankOfferTransactionActivity;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class TransactionErrorFragment extends BaseBankOfferFragment<BankOfferTransactionViewModel> implements View.OnClickListener, TransactionDialogListener {
    public static final Companion Companion = new Companion((g) null);
    private HashMap _$_findViewCache;
    private String errorMessage;

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

    public final boolean isBottomSheetCancelable() {
        return false;
    }

    public final boolean isHideable() {
        return false;
    }

    public final void updatePaySecurelyText(String str) {
        k.c(str, "amount");
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final TransactionErrorFragment getInstance(String str) {
            TransactionErrorFragment transactionErrorFragment = new TransactionErrorFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE, str);
            transactionErrorFragment.setArguments(bundle);
            return transactionErrorFragment;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r7 == null) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            if (r7 != 0) goto L_0x0009
            android.os.Bundle r7 = r6.getArguments()
        L_0x0009:
            if (r7 == 0) goto L_0x002c
            java.lang.String r0 = "errorMessage"
            java.lang.String r7 = r7.getString(r0)
            if (r7 == 0) goto L_0x002c
            java.lang.String r0 = "it"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            if (r0 != 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r7 = 0
        L_0x002a:
            if (r7 != 0) goto L_0x0032
        L_0x002c:
            int r7 = net.one97.paytm.nativesdk.R.string.default_bank_transaction_error
            java.lang.String r7 = r6.getString(r7)
        L_0x0032:
            r6.errorMessage = r7
            net.one97.paytm.nativesdk.orflow.Utility r7 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            android.content.Context r0 = r6.getContext()
            net.one97.paytm.nativesdk.orflow.Utility r1 = net.one97.paytm.nativesdk.orflow.Utility.INSTANCE
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper$Companion r2 = net.one97.paytm.nativesdk.orflow.promo.PromoHelper.Companion
            net.one97.paytm.nativesdk.orflow.promo.PromoHelper r2 = r2.getInstance()
            java.lang.String r2 = r2.getVerticalName()
            java.lang.String r3 = "bank_offer"
            java.lang.String r4 = "payment_rejected_popup_load"
            java.lang.String r5 = ""
            java.util.Map r1 = r1.getBankOfferEventParams(r3, r4, r2, r5)
            r7.sendBankOffersEvent(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.orflow.transaction.fragment.TransactionErrorFragment.onCreate(android.os.Bundle):void");
    }

    public final BankOfferTransactionViewModel getViewModel() {
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        return new BankOfferTransactionViewModel(application);
    }

    public final int getLayoutId() {
        return R.layout.fragment_transaction_error;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        PromoHelper.Companion.getInstance().setTransactionDialogListener(this);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public final void onDestroyView() {
        PromoHelper.Companion.getInstance().setTransactionDialogListener((TransactionDialogListener) null);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void initView() {
        View.OnClickListener onClickListener = this;
        ((ConstraintLayout) getMView().findViewById(R.id.otherPayModes)).setOnClickListener(onClickListener);
        ((TextView) getMView().findViewById(R.id.tvApplyOtherOffer)).setOnClickListener(onClickListener);
        ((RelativeLayout) getMView().findViewById(R.id.rlRetryPayment)).setOnClickListener(onClickListener);
        ((ImageView) getMView().findViewById(R.id.ivClose)).setOnClickListener(onClickListener);
        TextView textView = (TextView) getMView().findViewById(R.id.tvErrorMsg);
        k.a((Object) textView, "mView.tvErrorMsg");
        textView.setText(this.errorMessage);
    }

    public final void updateErrorMessage(String str) {
        CharSequence charSequence;
        TextView textView = (TextView) getMView().findViewById(R.id.tvErrorMsg);
        k.a((Object) textView, "mView.tvErrorMsg");
        if (str != null) {
            if (!(!(str.length() == 0))) {
                str = null;
            }
            if (str != null) {
                charSequence = str;
                textView.setText(charSequence);
            }
        }
        charSequence = getString(R.string.default_bank_transaction_error);
        textView.setText(charSequence);
    }

    public final void onClick(View view) {
        PromoPayOptionAdapterParam.TransactionType transactionType = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.ivClose;
        if (valueOf != null && valueOf.intValue() == i2) {
            cancelOrder();
            dismiss();
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            OrFlowCallbackListener orFlowCallbackListener = instance.getOrFlowCallbackListener();
            if (orFlowCallbackListener != null) {
                orFlowCallbackListener.finishActivity();
                return;
            }
            return;
        }
        int i3 = R.id.tvApplyOtherOffer;
        if (valueOf != null && valueOf.intValue() == i3) {
            applyAnotherOffer();
            Utility.INSTANCE.sendBankOffersEvent(getContext(), Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_BANKOFFER, Utility.ACTION_APPLY_ANOTHER_OFFER, PromoHelper.Companion.getInstance().getVerticalName(), ""));
            return;
        }
        int i4 = R.id.otherPayModes;
        if (valueOf != null && valueOf.intValue() == i4) {
            payUsingOtherPayModes();
            Utility.INSTANCE.sendBankOffersEvent(getContext(), Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_BANKOFFER, Utility.ACTION_OTHER_PAY_OPTION_CLICK, PromoHelper.Companion.getInstance().getVerticalName(), ""));
            return;
        }
        int i5 = R.id.rlRetryPayment;
        if (valueOf != null && valueOf.intValue() == i5) {
            TextView textView = (TextView) getMView().findViewById(R.id.tvPromoError);
            k.a((Object) textView, "mView.tvPromoError");
            textView.setVisibility(8);
            if (!SDKUtility.isNetworkAvailable(getContext())) {
                Toast.makeText(getContext(), getString(R.string.no_internet), 0).show();
                return;
            }
            PromoPayOptionAdapterParam selectedPaymentInstrument = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument();
            if (selectedPaymentInstrument != null) {
                transactionType = selectedPaymentInstrument.getTransactionType();
            }
            if (transactionType == PromoPayOptionAdapterParam.TransactionType.UserInput) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    ((BankOfferTransactionActivity) activity).addDebitCardTransactionFragment();
                    dismiss(true);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.orflow.transaction.activity.BankOfferTransactionActivity");
                }
            } else {
                ((BankOfferTransactionViewModel) getMViewModel()).makeProcessTransactionRequest(getContext(), view);
            }
            Utility.INSTANCE.sendBankOffersEvent(getContext(), Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_BANKOFFER, "retry_payment_clicked", PromoHelper.Companion.getInstance().getVerticalName(), ""));
        }
    }

    public final void makeUpiPushPayment(String str, String str2, String str3) {
        k.c(str, "mPin");
        k.c(str2, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str3, "deviceId");
        BankOfferTransactionViewModel bankOfferTransactionViewModel = (BankOfferTransactionViewModel) getMViewModel();
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        bankOfferTransactionViewModel.makeUpiPushPayment(context, str, str2, str3, (View) null);
    }

    public final void showOtherPayModeLoading() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading1);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading1);
        k.a((Object) lottieAnimationView2, "mView.ltv_loading1");
        lottieAnimationView2.setVisibility(0);
        ImageView imageView = (ImageView) getMView().findViewById(R.id.ivRightArrow);
        k.a((Object) imageView, "mView.ivRightArrow");
        imageView.setVisibility(8);
    }

    public final void hideOtherPayModeLoading() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading1);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading1);
        k.a((Object) lottieAnimationView2, "mView.ltv_loading1");
        lottieAnimationView2.setVisibility(8);
        ImageView imageView = (ImageView) getMView().findViewById(R.id.ivRightArrow);
        k.a((Object) imageView, "mView.ivRightArrow");
        imageView.setVisibility(0);
    }

    public final void onCancel(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        if (!getSaveActivityFromFinish()) {
            SDKUtility.onTransactionDialogDismiss(getContext());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        k.c(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        if (!getSaveActivityFromFinish()) {
            SDKUtility.onTransactionDialogDismiss(getContext());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public final void disableUiInteraction() {
        FrameLayout frameLayout = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "mView.disableClickView");
        frameLayout.setVisibility(0);
        FrameLayout frameLayout2 = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout2, "mView.disableClickView");
        frameLayout2.setClickable(true);
        ImageView imageView = (ImageView) getMView().findViewById(R.id.ivClose);
        k.a((Object) imageView, "mView.ivClose");
        imageView.setVisibility(8);
    }

    public final void enableUiInteraction() {
        FrameLayout frameLayout = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "mView.disableClickView");
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout2, "mView.disableClickView");
        frameLayout2.setClickable(false);
        ImageView imageView = (ImageView) getMView().findViewById(R.id.ivClose);
        k.a((Object) imageView, "mView.ivClose");
        imageView.setVisibility(0);
    }

    public final void onWebViewFinish() {
        enableUiInteraction();
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        k.a((Object) lottieAnimationView2, "mView.ltv_loading");
        lottieAnimationView2.setVisibility(8);
        TextView textView = (TextView) getMView().findViewById(R.id.paysecurely);
        k.a((Object) textView, "mView.paysecurely");
        textView.setVisibility(0);
        ((RelativeLayout) getMView().findViewById(R.id.rlRetryPayment)).setBackgroundResource(R.drawable.nativesdk_button_click);
    }

    private final void showAnotherOfferLoading() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading_another_offer);
        ((RelativeLayout) getMView().findViewById(R.id.rlAnotherOffer)).setBackgroundResource(R.drawable.native_button_onloading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading_another_offer);
        k.a((Object) lottieAnimationView2, "mView.ltv_loading_another_offer");
        lottieAnimationView2.setVisibility(0);
        TextView textView = (TextView) getMView().findViewById(R.id.tvApplyOtherOffer);
        k.a((Object) textView, "mView.tvApplyOtherOffer");
        textView.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public final void hideOAnotherOfferLoading() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading_another_offer);
        ((RelativeLayout) getMView().findViewById(R.id.rlAnotherOffer)).setBackgroundResource(R.drawable.bg_button_yes);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading_another_offer);
        k.a((Object) lottieAnimationView2, "mView.ltv_loading_another_offer");
        lottieAnimationView2.setVisibility(8);
        TextView textView = (TextView) getMView().findViewById(R.id.tvApplyOtherOffer);
        k.a((Object) textView, "mView.tvApplyOtherOffer");
        textView.setVisibility(0);
    }

    public final void applyAnotherOffer() {
        showAnotherOfferLoading();
        TextView textView = (TextView) getMView().findViewById(R.id.tvPromoError);
        k.a((Object) textView, "mView.tvPromoError");
        textView.setVisibility(8);
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        instance.getRequestClient().applyAnotherOffer(new TransactionErrorFragment$applyAnotherOffer$1(this));
    }

    public final View getTransactionDialogView() {
        return getMView().getRootView();
    }
}
