package net.one97.paytm.nativesdk.orflow.transaction.fragment;

import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.view.BaseBankOfferFragment;
import net.one97.paytm.nativesdk.orflow.transaction.TransactionDialogListener;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class BankOfferTransactionFragment extends BaseBankOfferFragment<BankOfferTransactionViewModel> implements TransactionDialogListener {
    private HashMap _$_findViewCache;

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

    public final int getLayoutId() {
        return R.layout.fragment_transaction_loader;
    }

    public final void initView() {
        showTransactionLoader();
        ((BankOfferTransactionViewModel) getMViewModel()).makeProcessTransactionRequest(getContext(), (View) null);
    }

    public final BankOfferTransactionViewModel getViewModel() {
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        return new BankOfferTransactionViewModel(application);
    }

    public final void makeUpiPushPayment(String str, String str2, String str3) {
        k.c(str, "mPin");
        k.c(str2, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str3, "deviceId");
        ((BankOfferTransactionViewModel) getMViewModel()).makeUpiPushPayment(getContext(), str, str2, str3, (View) null);
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

    private final void showTransactionLoader() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) getMView().findViewById(R.id.ltv_loading);
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
        }
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

    public final View getTransactionDialogView() {
        return getMView().getRootView();
    }
}
