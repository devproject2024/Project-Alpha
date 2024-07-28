package com.business.merchant_payments.common.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.business.common_module.utilities.LogUtility;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.utility.ScreenUtility;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import net.one97.paytm.i.f;

public abstract class BaseBottomSheetDialogFragment extends f {
    public final String TAG = getClass().getSimpleName();
    public Context mContext;

    public abstract void initUI();

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mContext = getActivity();
        initUI();
    }

    public void onAttach(Context context) {
        super.onAttach(PaymentsConfig.getInstance().getCommonUtils().a(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogTheme);
    }

    public void handleBottomSheetBehavior(View view) {
        View view2 = (View) view.getParent();
        view2.setBackgroundColor(getResources().getColor(17170445));
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.d) view2.getLayoutParams()).f2603a;
        if (behavior != null && (behavior instanceof BottomSheetBehavior)) {
            BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) behavior;
            bottomSheetBehavior.setPeekHeight(ScreenUtility.getScreenHeight(this.mContext));
            bottomSheetBehavior.setState(3);
            bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.a() {
                public void onSlide(View view, float f2) {
                }

                public void onStateChanged(View view, int i2) {
                    if (i2 == 5) {
                        BaseBottomSheetDialogFragment.this.dismiss();
                    }
                }
            });
        }
    }

    public void dismiss() {
        super.dismissAllowingStateLoss();
    }

    public void hideKeyboard(View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e2) {
            LogUtility.printStackTrace(e2);
        }
    }
}
