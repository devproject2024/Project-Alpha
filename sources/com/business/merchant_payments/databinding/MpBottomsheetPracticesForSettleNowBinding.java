package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;

public abstract class MpBottomsheetPracticesForSettleNowBinding extends ViewDataBinding {
    public final TextView btnGotIt;
    public final TextView heading;
    public final ImageView mpIc1;
    public final TextView practice1;
    public final TextView practice2;
    public final TextView practice3;
    public final TextView practice4;
    public final ImageView tick1;
    public final ImageView tick2;
    public final ImageView tick3;

    public MpBottomsheetPracticesForSettleNowBinding(Object obj, View view, int i2, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        super(obj, view, i2);
        this.btnGotIt = textView;
        this.heading = textView2;
        this.mpIc1 = imageView;
        this.practice1 = textView3;
        this.practice2 = textView4;
        this.practice3 = textView5;
        this.practice4 = textView6;
        this.tick1 = imageView2;
        this.tick2 = imageView3;
        this.tick3 = imageView4;
    }

    public static MpBottomsheetPracticesForSettleNowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpBottomsheetPracticesForSettleNowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpBottomsheetPracticesForSettleNowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bottomsheet_practices_for_settle_now, viewGroup, z, obj);
    }

    public static MpBottomsheetPracticesForSettleNowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpBottomsheetPracticesForSettleNowBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpBottomsheetPracticesForSettleNowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_bottomsheet_practices_for_settle_now, (ViewGroup) null, false, obj);
    }

    public static MpBottomsheetPracticesForSettleNowBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpBottomsheetPracticesForSettleNowBinding bind(View view, Object obj) {
        return (MpBottomsheetPracticesForSettleNowBinding) ViewDataBinding.bind(obj, view, R.layout.mp_bottomsheet_practices_for_settle_now);
    }
}
