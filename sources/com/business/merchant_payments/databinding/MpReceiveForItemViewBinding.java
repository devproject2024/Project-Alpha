package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.paytm.utility.RoboTextView;

public abstract class MpReceiveForItemViewBinding extends ViewDataBinding {
    public final View divider1;
    public CompoundButton.OnCheckedChangeListener mCheckChangeListener;
    public Boolean mIsChecked;
    public String mMsg;
    public final SwitchCompat switchTransactionNotification;
    public final RoboTextView tvTransactionNotification;

    public abstract void setCheckChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void setIsChecked(Boolean bool);

    public abstract void setMsg(String str);

    public MpReceiveForItemViewBinding(Object obj, View view, int i2, View view2, SwitchCompat switchCompat, RoboTextView roboTextView) {
        super(obj, view, i2);
        this.divider1 = view2;
        this.switchTransactionNotification = switchCompat;
        this.tvTransactionNotification = roboTextView;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public Boolean getIsChecked() {
        return this.mIsChecked;
    }

    public CompoundButton.OnCheckedChangeListener getCheckChangeListener() {
        return this.mCheckChangeListener;
    }

    public static MpReceiveForItemViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpReceiveForItemViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpReceiveForItemViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_receive_for_item_view, viewGroup, z, obj);
    }

    public static MpReceiveForItemViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpReceiveForItemViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpReceiveForItemViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_receive_for_item_view, (ViewGroup) null, false, obj);
    }

    public static MpReceiveForItemViewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpReceiveForItemViewBinding bind(View view, Object obj) {
        return (MpReceiveForItemViewBinding) ViewDataBinding.bind(obj, view, R.layout.mp_receive_for_item_view);
    }
}
