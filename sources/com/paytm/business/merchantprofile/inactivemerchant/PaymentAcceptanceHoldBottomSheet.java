package com.paytm.business.merchantprofile.inactivemerchant;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.paytm.business.merchantprofile.databinding.PrPaymentAcceptanceHoldBsBinding;
import com.paytm.business.merchantprofile.view.CustomBottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PaymentAcceptanceHoldBottomSheet extends CustomBottomSheetDialogFragment {
    public static final Companion Companion = new Companion((g) null);
    public static final String TAG = "PaymentAcceptanceHoldBottomSheet";
    public HashMap _$_findViewCache;
    public PrPaymentAcceptanceHoldBsBinding mBinding;
    public InactiveMerchantListener mListener;

    public interface PaymentAcceptanceHoldBottomSheetListener {
        InactiveMerchantListener getInactiveMerchantListener();
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
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final PrPaymentAcceptanceHoldBsBinding getMBinding() {
        PrPaymentAcceptanceHoldBsBinding prPaymentAcceptanceHoldBsBinding = this.mBinding;
        if (prPaymentAcceptanceHoldBsBinding == null) {
            k.a("mBinding");
        }
        return prPaymentAcceptanceHoldBsBinding;
    }

    public final void setMBinding(PrPaymentAcceptanceHoldBsBinding prPaymentAcceptanceHoldBsBinding) {
        k.d(prPaymentAcceptanceHoldBsBinding, "<set-?>");
        this.mBinding = prPaymentAcceptanceHoldBsBinding;
    }

    public final InactiveMerchantListener getMListener() {
        InactiveMerchantListener inactiveMerchantListener = this.mListener;
        if (inactiveMerchantListener == null) {
            k.a("mListener");
        }
        return inactiveMerchantListener;
    }

    public final void setMListener(InactiveMerchantListener inactiveMerchantListener) {
        k.d(inactiveMerchantListener, "<set-?>");
        this.mListener = inactiveMerchantListener;
    }

    public final void onAttach(Activity activity) {
        k.d(activity, "activity");
        super.onAttach(activity);
        if (activity instanceof PaymentAcceptanceHoldBottomSheetListener) {
            this.mListener = ((PaymentAcceptanceHoldBottomSheetListener) activity).getInactiveMerchantListener();
            return;
        }
        throw new Exception("PaymentAcceptanceHoldBottomSheet: Activoty must implement InactiveMerchantListener");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        PrPaymentAcceptanceHoldBsBinding inflate = PrPaymentAcceptanceHoldBsBinding.inflate(layoutInflater, viewGroup, false);
        k.b(inflate, "PrPaymentAcceptanceHoldB…flater, container, false)");
        this.mBinding = inflate;
        if (inflate == null) {
            k.a("mBinding");
        }
        InactiveMerchantListener inactiveMerchantListener = this.mListener;
        if (inactiveMerchantListener == null) {
            k.a("mListener");
        }
        inflate.setListener(inactiveMerchantListener);
        PrPaymentAcceptanceHoldBsBinding prPaymentAcceptanceHoldBsBinding = this.mBinding;
        if (prPaymentAcceptanceHoldBsBinding == null) {
            k.a("mBinding");
        }
        InactiveMerchantListener inactiveMerchantListener2 = this.mListener;
        if (inactiveMerchantListener2 == null) {
            k.a("mListener");
        }
        prPaymentAcceptanceHoldBsBinding.setData(inactiveMerchantListener2.getInactivateMerchantData());
        PrPaymentAcceptanceHoldBsBinding prPaymentAcceptanceHoldBsBinding2 = this.mBinding;
        if (prPaymentAcceptanceHoldBsBinding2 == null) {
            k.a("mBinding");
        }
        prPaymentAcceptanceHoldBsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        PrPaymentAcceptanceHoldBsBinding prPaymentAcceptanceHoldBsBinding3 = this.mBinding;
        if (prPaymentAcceptanceHoldBsBinding3 == null) {
            k.a("mBinding");
        }
        prPaymentAcceptanceHoldBsBinding3.apUi.closeIcon.setOnClickListener(new PaymentAcceptanceHoldBottomSheet$onCreateView$1(this));
        PrPaymentAcceptanceHoldBsBinding prPaymentAcceptanceHoldBsBinding4 = this.mBinding;
        if (prPaymentAcceptanceHoldBsBinding4 == null) {
            k.a("mBinding");
        }
        return prPaymentAcceptanceHoldBsBinding4.getRoot();
    }
}
