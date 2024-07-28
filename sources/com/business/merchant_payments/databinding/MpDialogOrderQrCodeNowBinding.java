package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;
import com.business.merchant_payments.homepagedialogs.HomeDialogsManager;
import com.paytm.utility.RoboTextView;

public abstract class MpDialogOrderQrCodeNowBinding extends ViewDataBinding {
    public final RoboTextView btnDoItLater;
    public final RoboTextView btnOrderNow;
    public final CheckBox checkDontAskAgain;
    public final ImageView imgStandee;
    public HomeDialogsManager mParentViewModel;
    public final RoboTextView point1;
    public final RoboTextView point2;
    public final RoboTextView point3;
    public final ConstraintLayout rootView;
    public final ImageView tick1;
    public final ImageView tick2;
    public final ImageView tick3;
    public final RoboTextView tvTitle;
    public final View viewDontAskAgain;

    public abstract void setParentViewModel(HomeDialogsManager homeDialogsManager);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpDialogOrderQrCodeNowBinding(Object obj, View view, int i2, RoboTextView roboTextView, RoboTextView roboTextView2, CheckBox checkBox, ImageView imageView, RoboTextView roboTextView3, RoboTextView roboTextView4, RoboTextView roboTextView5, ConstraintLayout constraintLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, RoboTextView roboTextView6, View view2) {
        super(obj, view, i2);
        this.btnDoItLater = roboTextView;
        this.btnOrderNow = roboTextView2;
        this.checkDontAskAgain = checkBox;
        this.imgStandee = imageView;
        this.point1 = roboTextView3;
        this.point2 = roboTextView4;
        this.point3 = roboTextView5;
        this.rootView = constraintLayout;
        this.tick1 = imageView2;
        this.tick2 = imageView3;
        this.tick3 = imageView4;
        this.tvTitle = roboTextView6;
        this.viewDontAskAgain = view2;
    }

    public HomeDialogsManager getParentViewModel() {
        return this.mParentViewModel;
    }

    public static MpDialogOrderQrCodeNowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpDialogOrderQrCodeNowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpDialogOrderQrCodeNowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_dialog_order_qr_code_now, viewGroup, z, obj);
    }

    public static MpDialogOrderQrCodeNowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpDialogOrderQrCodeNowBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpDialogOrderQrCodeNowBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_dialog_order_qr_code_now, (ViewGroup) null, false, obj);
    }

    public static MpDialogOrderQrCodeNowBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpDialogOrderQrCodeNowBinding bind(View view, Object obj) {
        return (MpDialogOrderQrCodeNowBinding) ViewDataBinding.bind(obj, view, R.layout.mp_dialog_order_qr_code_now);
    }
}
