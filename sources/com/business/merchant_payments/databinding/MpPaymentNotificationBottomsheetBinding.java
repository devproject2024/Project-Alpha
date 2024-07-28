package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.homepagedialogs.PaymentNotificationFragment;
import com.paytm.utility.RoboTextView;

public abstract class MpPaymentNotificationBottomsheetBinding extends ViewDataBinding {
    public final CardView cardView;
    public final View clickable;
    public final ImageView close;
    public PaymentNotificationFragment.PaymentNotificationFragmentListener mListener;
    public final View paddingBottom;
    public final View paddingTop;
    public final RoboTextView title;
    public final MpPaymentsTransactionItemBinding transactionLayout;

    public abstract void setListener(PaymentNotificationFragment.PaymentNotificationFragmentListener paymentNotificationFragmentListener);

    public MpPaymentNotificationBottomsheetBinding(Object obj, View view, int i2, CardView cardView2, View view2, ImageView imageView, View view3, View view4, RoboTextView roboTextView, MpPaymentsTransactionItemBinding mpPaymentsTransactionItemBinding) {
        super(obj, view, i2);
        this.cardView = cardView2;
        this.clickable = view2;
        this.close = imageView;
        this.paddingBottom = view3;
        this.paddingTop = view4;
        this.title = roboTextView;
        this.transactionLayout = mpPaymentsTransactionItemBinding;
        setContainedBinding(mpPaymentsTransactionItemBinding);
    }

    public PaymentNotificationFragment.PaymentNotificationFragmentListener getListener() {
        return this.mListener;
    }

    public static MpPaymentNotificationBottomsheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpPaymentNotificationBottomsheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpPaymentNotificationBottomsheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payment_notification_bottomsheet, viewGroup, z, obj);
    }

    public static MpPaymentNotificationBottomsheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpPaymentNotificationBottomsheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpPaymentNotificationBottomsheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_payment_notification_bottomsheet, (ViewGroup) null, false, obj);
    }

    public static MpPaymentNotificationBottomsheetBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpPaymentNotificationBottomsheetBinding bind(View view, Object obj) {
        return (MpPaymentNotificationBottomsheetBinding) ViewDataBinding.bind(obj, view, R.layout.mp_payment_notification_bottomsheet);
    }
}
