package net.one97.paytm.nativesdk.orflow.transaction.fragment;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.ConvenienceFeeOrController;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.common.model.PaymentModes;
import net.one97.paytm.nativesdk.common.model.SavedInstruments;
import net.one97.paytm.nativesdk.instruments.Instruments;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.nativesdk.orflow.interfaces.OrFlowCallbackListener;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.GetCardDetailsResponse;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;
import net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment;
import net.one97.paytm.nativesdk.orflow.transaction.BankOfferCardView;
import net.one97.paytm.nativesdk.orflow.transaction.TransactionDialogListener;
import net.one97.paytm.nativesdk.orflow.transaction.newcard.BankOffersNewCardView;
import net.one97.paytm.nativesdk.orflow.transaction.ppb.BankOfferPaytmBankView;
import net.one97.paytm.nativesdk.orflow.transaction.savedcard.BankOffersSavedCardView;

public final class DebitCardTransactionDialog extends BaseBankOfferFragment<EmptyViewModel> implements View.OnClickListener, TransactionDialogListener {
    public static final Companion Companion = new Companion((g) null);
    private HashMap _$_findViewCache;
    private BankOfferCardView bankOfferCardView;
    private Integer cardType;
    private boolean isHideable = true;

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

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final DebitCardTransactionDialog getInstance(int i2) {
            DebitCardTransactionDialog debitCardTransactionDialog = new DebitCardTransactionDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("cardType", i2);
            debitCardTransactionDialog.setArguments(bundle);
            return debitCardTransactionDialog;
        }
    }

    public final EmptyViewModel getViewModel() {
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        return new EmptyViewModel(application);
    }

    public final int getLayoutId() {
        return R.layout.dialog_debitcard_transaction;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        if (bundle != null) {
            this.cardType = Integer.valueOf(bundle.getInt("cardType"));
        }
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
        View view;
        View view2;
        View view3;
        View view4;
        if (ConvenienceFeeOrController.Companion.getInstance().isConvenienceFeeEnabled()) {
            updatePaySecurelyText(ConvenienceFeeOrController.Companion.getInstance().getTotalAmount());
        } else {
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            String amount = merchantInstance.getAmount();
            k.a((Object) amount, "MerchantBL.getMerchantInstance().amount");
            updatePaySecurelyText(amount);
        }
        if (p.a(Utility.VERTICAL_NAME_MALL, PromoHelper.Companion.getInstance().getVerticalName(), true)) {
            TextView textView = (TextView) getMView().findViewById(R.id.tvPromoCode);
            k.a((Object) textView, "mView.tvPromoCode");
            textView.setVisibility(8);
        } else {
            TextView textView2 = (TextView) getMView().findViewById(R.id.tvPromoCode);
            k.a((Object) textView2, "mView.tvPromoCode");
            textView2.setVisibility(0);
        }
        TextView textView3 = (TextView) getMView().findViewById(R.id.tvPromoCode);
        k.a((Object) textView3, "mView.tvPromoCode");
        textView3.setText(k.a(PromoHelper.Companion.getInstance().getSelectedPromoCode(), (Object) "   Applied"));
        View.OnClickListener onClickListener = this;
        ((ImageView) getMView().findViewById(R.id.ivClose)).setOnClickListener(onClickListener);
        ((RelativeLayout) getMView().findViewById(R.id.llPaySecurely)).setOnClickListener(onClickListener);
        ((ConstraintLayout) getMView().findViewById(R.id.otherPayModes)).setOnClickListener(onClickListener);
        ((LinearLayout) getMView().findViewById(R.id.savedCardContainer)).removeAllViews();
        if (ConvenienceFeeOrController.Companion.getInstance().isConvenienceFeeEnabled()) {
            showConvFee();
        }
        Integer num = this.cardType;
        BaseDataModel baseDataModel = null;
        if (num != null && num.intValue() == 2) {
            this.bankOfferCardView = new BankOffersNewCardView(getContext(), false, false, (Instruments) null, (LinearLayout) null);
            BankOfferCardView bankOfferCardView2 = this.bankOfferCardView;
            if (bankOfferCardView2 != null) {
                BankOffersNewCardView bankOffersNewCardView = (BankOffersNewCardView) bankOfferCardView2;
                PromoPayOptionAdapterParam selectedPaymentInstrument = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument();
                if (selectedPaymentInstrument != null) {
                    baseDataModel = selectedPaymentInstrument.getData();
                }
                if (baseDataModel != null) {
                    PaytmBaseView debitCreditCardsView = bankOffersNewCardView.getDebitCreditCardsView((GetCardDetailsResponse) baseDataModel);
                    if (!(debitCreditCardsView == null || (view4 = debitCreditCardsView.getView()) == null)) {
                        ((LinearLayout) getMView().findViewById(R.id.savedCardContainer)).addView(view4);
                    }
                    BankOfferCardView bankOfferCardView3 = this.bankOfferCardView;
                    if (bankOfferCardView3 != null) {
                        bankOfferCardView3.setTransactionDialogListener(this);
                    }
                    TextView textView4 = (TextView) getMView().findViewById(R.id.tvPayUsingText);
                    k.a((Object) textView4, "mView.tvPayUsingText");
                    textView4.setVisibility(8);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.orflow.promo.model.GetCardDetailsResponse");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.orflow.transaction.newcard.BankOffersNewCardView");
        }
        Integer num2 = this.cardType;
        if (num2 != null && num2.intValue() == 5) {
            this.bankOfferCardView = new BankOfferPaytmBankView(getContext(), (Instruments) null, true);
            BankOfferCardView bankOfferCardView4 = this.bankOfferCardView;
            if (bankOfferCardView4 != null) {
                BankOfferPaytmBankView bankOfferPaytmBankView = (BankOfferPaytmBankView) bankOfferCardView4;
                PromoPayOptionAdapterParam selectedPaymentInstrument2 = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument();
                if (selectedPaymentInstrument2 != null) {
                    baseDataModel = selectedPaymentInstrument2.getData();
                }
                if (baseDataModel != null) {
                    PaytmBaseView bankView = bankOfferPaytmBankView.getBankView((PaymentModes) baseDataModel, false);
                    if (!(bankView == null || (view3 = bankView.getView()) == null)) {
                        ((LinearLayout) getMView().findViewById(R.id.savedCardContainer)).addView(view3);
                    }
                    TextView textView5 = (TextView) getMView().findViewById(R.id.tvPayUsingText);
                    k.a((Object) textView5, "mView.tvPayUsingText");
                    textView5.setVisibility(0);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.PaymentModes");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.orflow.transaction.ppb.BankOfferPaytmBankView");
        }
        Integer num3 = this.cardType;
        if (num3 != null && num3.intValue() == 6) {
            this.bankOfferCardView = new BankOfferPaytmBankView(getContext(), (Instruments) null, true);
            BankOfferCardView bankOfferCardView5 = this.bankOfferCardView;
            if (bankOfferCardView5 != null) {
                BankOfferPaytmBankView bankOfferPaytmBankView2 = (BankOfferPaytmBankView) bankOfferCardView5;
                PromoPayOptionAdapterParam selectedPaymentInstrument3 = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument();
                if (selectedPaymentInstrument3 != null) {
                    baseDataModel = selectedPaymentInstrument3.getData();
                }
                if (baseDataModel != null) {
                    PaytmBaseView bankView2 = bankOfferPaytmBankView2.getBankView((PaymentModes) baseDataModel, true);
                    if (!(bankView2 == null || (view2 = bankView2.getView()) == null)) {
                        ((LinearLayout) getMView().findViewById(R.id.savedCardContainer)).addView(view2);
                    }
                    TextView textView6 = (TextView) getMView().findViewById(R.id.tvPayUsingText);
                    k.a((Object) textView6, "mView.tvPayUsingText");
                    textView6.setVisibility(0);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.PaymentModes");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.orflow.transaction.ppb.BankOfferPaytmBankView");
        }
        Context context = getContext();
        PromoPayOptionAdapterParam selectedPaymentInstrument4 = PromoHelper.Companion.getInstance().getSelectedPaymentInstrument();
        BaseDataModel data = selectedPaymentInstrument4 != null ? selectedPaymentInstrument4.getData() : null;
        if (data != null) {
            this.bankOfferCardView = new BankOffersSavedCardView(context, (SavedInstruments) data, (Instruments) null);
            BankOfferCardView bankOfferCardView6 = this.bankOfferCardView;
            if (bankOfferCardView6 != null) {
                PaytmBaseView savedCardView = ((BankOffersSavedCardView) bankOfferCardView6).getSavedCardView();
                if (!(savedCardView == null || (view = savedCardView.getView()) == null)) {
                    ((LinearLayout) getMView().findViewById(R.id.savedCardContainer)).addView(view);
                }
                BankOfferCardView bankOfferCardView7 = this.bankOfferCardView;
                if (bankOfferCardView7 != null) {
                    bankOfferCardView7.setTransactionDialogListener(this);
                }
                TextView textView7 = (TextView) getMView().findViewById(R.id.tvPayUsingText);
                k.a((Object) textView7, "mView.tvPayUsingText");
                textView7.setVisibility(0);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.orflow.transaction.savedcard.BankOffersSavedCardView");
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.common.model.SavedInstruments");
    }

    private final void showConvFee() {
        double totalConvenienceFeePayable = ConvenienceFeeOrController.Companion.getInstance().getTotalConvenienceFeePayable();
        String convenienceFeeLabel = ConvenienceFeeOrController.Companion.getInstance().getConvenienceFeeLabel();
        if (totalConvenienceFeePayable != 0.0d) {
            ((TextView) getMView().findViewById(R.id.tv_convFee)).setVisibility(0);
            if (!TextUtils.isEmpty(convenienceFeeLabel)) {
                TextView textView = (TextView) getMView().findViewById(R.id.tv_convFee);
                k.a((Object) textView, "mView.tv_convFee");
                Context context = getContext();
                if (context == null) {
                    k.a();
                }
                int i2 = R.string.conv_fee_custom_msg;
                textView.setText(context.getString(i2, new Object[]{convenienceFeeLabel, String.valueOf(totalConvenienceFeePayable)}));
                return;
            }
            TextView textView2 = (TextView) getMView().findViewById(R.id.tv_convFee);
            k.a((Object) textView2, "mView.tv_convFee");
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            int i3 = R.string.conv_fee_new_default_msg;
            textView2.setText(context2.getString(i3, new Object[]{String.valueOf(totalConvenienceFeePayable)}));
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.ivClose;
        if (valueOf != null && valueOf.intValue() == i2) {
            dismiss();
            cancelOrder();
            DirectPaymentBL instance = DirectPaymentBL.getInstance();
            k.a((Object) instance, "DirectPaymentBL.getInstance()");
            OrFlowCallbackListener orFlowCallbackListener = instance.getOrFlowCallbackListener();
            if (orFlowCallbackListener != null) {
                orFlowCallbackListener.finishActivity();
                return;
            }
            return;
        }
        int i3 = R.id.llPaySecurely;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i4 = R.id.otherPayModes;
            if (valueOf != null && valueOf.intValue() == i4) {
                payUsingOtherPayModes();
                Utility.INSTANCE.sendBankOffersEvent(getContext(), Utility.INSTANCE.getBankOfferEventParams(Utility.EVENT_CATEGORY_BANKOFFER, Utility.ACTION_OTHER_PAY_OPTION_CLICK, PromoHelper.Companion.getInstance().getVerticalName(), ""));
            }
        } else if (!SDKUtility.isNetworkAvailable(getContext())) {
            Toast.makeText(getContext(), getString(R.string.no_internet), 0).show();
        } else {
            BankOfferCardView bankOfferCardView2 = this.bankOfferCardView;
            if (bankOfferCardView2 != null) {
                bankOfferCardView2.onProceedClick(view);
            }
        }
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
            lottieAnimationView.setVisibility(8);
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
        setCancelable(false);
        this.isHideable = false;
    }

    public final void enableUiInteraction() {
        FrameLayout frameLayout = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout, "mView.disableClickView");
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = (FrameLayout) getMView().findViewById(R.id.disableClickView);
        k.a((Object) frameLayout2, "mView.disableClickView");
        boolean z = false;
        frameLayout2.setClickable(false);
        ((RelativeLayout) getMView().findViewById(R.id.llPaySecurely)).setOnClickListener(this);
        ImageView imageView = (ImageView) getMView().findViewById(R.id.ivClose);
        k.a((Object) imageView, "mView.ivClose");
        imageView.setVisibility(0);
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        setCancelable(merchantInstance.getOrderId() == null);
        MerchantBL merchantInstance2 = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance2, "MerchantBL.getMerchantInstance()");
        if (merchantInstance2.getOrderId() == null) {
            z = true;
        }
        this.isHideable = z;
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
        TextView textView2 = (TextView) getMView().findViewById(R.id.paysecurely2);
        k.a((Object) textView2, "mView.paysecurely2");
        CharSequence text = textView2.getText();
        if (text != null) {
            text.length();
            TextView textView3 = (TextView) getMView().findViewById(R.id.paysecurely2);
            k.a((Object) textView3, "mView.paysecurely2");
            textView3.setVisibility(0);
        }
        ((RelativeLayout) getMView().findViewById(R.id.llPaySecurely)).setBackgroundResource(R.drawable.nativesdk_button_click);
    }

    public final boolean isHideable() {
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        if (merchantInstance.getOrderId() == null) {
            return this.isHideable;
        }
        return false;
    }

    public final boolean isBottomSheetCancelable() {
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        return merchantInstance.getOrderId() == null;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        BankOfferCardView bankOfferCardView2 = this.bankOfferCardView;
        if (bankOfferCardView2 != null) {
            bankOfferCardView2.onActivityResult(i2, i3, intent);
        }
    }

    public final void updatePaySecurelyText(String str) {
        double d2;
        k.c(str, "amount");
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            if (!activity.isFinishing() && isAdded()) {
                TextView textView = (TextView) getMView().findViewById(R.id.paysecurely);
                k.a((Object) textView, "mView.paysecurely");
                textView.setText(getString(R.string.bank_offer_pay_text) + SDKUtility.priceWithoutDecimal(str));
                if (Utility.VERTICAL_NAME_MALL.equals(PromoHelper.Companion.getInstance().getVerticalName())) {
                    MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
                    k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
                    Double totalCashBackAmount = merchantInstance.getTotalCashBackAmount();
                    k.a((Object) totalCashBackAmount, "MerchantBL.getMerchantIn…nce().totalCashBackAmount");
                    d2 = totalCashBackAmount.doubleValue();
                } else {
                    d2 = PromoHelper.Companion.getInstance().getPaytmCashBack();
                }
                if (d2 > 0.0d) {
                    try {
                        TextView textView2 = (TextView) getMView().findViewById(R.id.paysecurely2);
                        k.a((Object) textView2, "mView.paysecurely2");
                        textView2.setText("With cashback of ₹" + d2 + ", your effective price is ₹" + SDKUtility.priceWithoutDecimal(Double.parseDouble(str) - d2));
                        TextView textView3 = (TextView) getMView().findViewById(R.id.paysecurely2);
                        k.a((Object) textView3, "mView.paysecurely2");
                        textView3.setVisibility(0);
                    } catch (Exception unused) {
                    }
                    TextView textView4 = (TextView) getMView().findViewById(R.id.tvTitle);
                    k.a((Object) textView4, "mView.tvTitle");
                    textView4.setText(getString(R.string.bank_offer_transaction_title) + SDKUtility.priceWithoutDecimal(str));
                }
                TextView textView5 = (TextView) getMView().findViewById(R.id.paysecurely2);
                k.a((Object) textView5, "mView.paysecurely2");
                textView5.setVisibility(8);
                TextView textView42 = (TextView) getMView().findViewById(R.id.tvTitle);
                k.a((Object) textView42, "mView.tvTitle");
                textView42.setText(getString(R.string.bank_offer_transaction_title) + SDKUtility.priceWithoutDecimal(str));
            }
        }
    }

    public final View getTransactionDialogView() {
        return getMView().getRootView();
    }
}
