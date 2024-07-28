package com.business.merchant_payments.homepagedialogs;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.y;
import com.business.merchant_payments.R;
import com.business.merchant_payments.databinding.MpPaymentNotificationBottomsheetBinding;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class PaymentNotificationFragment extends h {
    public HashMap _$_findViewCache;
    public PaymentNotificationFragmentListener mListener;
    public MpPaymentNotificationBottomsheetBinding paymentNotificationBottomsheetBinding;

    public interface PaymentNotificationFragmentListener {
        y<PaymentNotificationData> getData();

        void onClose();

        void onPaymentNotificationClick();
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

    public final void onAttach(Activity activity) {
        k.d(activity, "activity");
        super.onAttach(activity);
        if (activity instanceof PaymentNotificationFragmentListener) {
            this.mListener = (PaymentNotificationFragmentListener) activity;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        ViewDataBinding a2 = f.a(layoutInflater, R.layout.mp_payment_notification_bottomsheet, viewGroup, false);
        k.b(a2, "DataBindingUtil.inflate(…msheet, container, false)");
        MpPaymentNotificationBottomsheetBinding mpPaymentNotificationBottomsheetBinding = (MpPaymentNotificationBottomsheetBinding) a2;
        this.paymentNotificationBottomsheetBinding = mpPaymentNotificationBottomsheetBinding;
        if (mpPaymentNotificationBottomsheetBinding == null) {
            k.a("paymentNotificationBottomsheetBinding");
        }
        mpPaymentNotificationBottomsheetBinding.setListener(this.mListener);
        MpPaymentNotificationBottomsheetBinding mpPaymentNotificationBottomsheetBinding2 = this.paymentNotificationBottomsheetBinding;
        if (mpPaymentNotificationBottomsheetBinding2 == null) {
            k.a("paymentNotificationBottomsheetBinding");
        }
        mpPaymentNotificationBottomsheetBinding2.setLifecycleOwner(getViewLifecycleOwner());
        MpPaymentNotificationBottomsheetBinding mpPaymentNotificationBottomsheetBinding3 = this.paymentNotificationBottomsheetBinding;
        if (mpPaymentNotificationBottomsheetBinding3 == null) {
            k.a("paymentNotificationBottomsheetBinding");
        }
        return mpPaymentNotificationBottomsheetBinding3.getRoot();
    }
}
