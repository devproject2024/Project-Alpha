package net.one97.paytm.nativesdk.orflow.promo.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.MerchantBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;
import net.one97.paytm.nativesdk.orflow.BaseBottomSheetDialogFragment;
import net.one97.paytm.nativesdk.paymethods.datasource.NativeSDKRepository;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public abstract class BaseBankOfferFragment<T extends ai> extends BaseBottomSheetDialogFragment {
    private HashMap _$_findViewCache;
    public T mViewModel;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
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

    public abstract T getViewModel();

    public void hideOtherPayModeLoading() {
    }

    public void makeUpiPushPayment(String str, String str2, String str3) {
        k.c(str, "mPin");
        k.c(str2, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        k.c(str3, "deviceId");
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onWebViewFinish() {
    }

    public void showOtherPayModeLoading() {
    }

    public final T getMViewModel() {
        T t = this.mViewModel;
        if (t == null) {
            k.a("mViewModel");
        }
        return t;
    }

    public final void setMViewModel(T t) {
        k.c(t, "<set-?>");
        this.mViewModel = t;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mViewModel = getViewModel();
    }

    public void show(j jVar, String str) {
        k.c(jVar, "manager");
        q a2 = jVar.a();
        k.a((Object) a2, "manager?.beginTransaction()");
        a2.a((Fragment) this, str);
        a2.c();
    }

    /* access modifiers changed from: protected */
    public final void payUsingOtherPayModes() {
        boolean z = false;
        if (!SDKUtility.isNetworkAvailable(getContext())) {
            Toast.makeText(getContext(), getString(R.string.no_internet), 0).show();
            return;
        }
        showOtherPayModeLoading();
        disableUiInteraction();
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.getRequestClient() != null) {
            DirectPaymentBL instance2 = DirectPaymentBL.getInstance();
            k.a((Object) instance2, "DirectPaymentBL.getInstance()");
            PaytmSDKRequestClient requestClient = instance2.getRequestClient();
            MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
            k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
            if (merchantInstance.getOrderId() != null) {
                z = true;
            }
            requestClient.onOtherPayModeSelected(z, new BaseBankOfferFragment$payUsingOtherPayModes$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void startInstrumentActivity() {
        Intent intent = new Intent(getActivity(), InstrumentActivity.class);
        intent.putExtra(SDKConstants.KEY_INSTRUMENT_PRIMARY_INFO, "Paytm Wallet");
        intent.putExtra(SDKConstants.KEY_INSTRUMENT_SECONDARY_INFO, "Balance Rs 1200");
        intent.putExtra(SDKConstants.MERCHANT_LOGO, 0);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    public final void cancelOrder() {
        MerchantBL merchantInstance = MerchantBL.getMerchantInstance();
        k.a((Object) merchantInstance, "MerchantBL.getMerchantInstance()");
        if (merchantInstance.getOrderId() != null) {
            NativeSDKRepository.getInstance().notifyServerAboutCloseOrder();
        }
    }
}
