package net.one97.paytm.nativesdk.pincvv.views.bottomsheet;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.databinding.CvvPinLayoutBinding;
import net.one97.paytm.nativesdk.pincvv.listeners.PinCvvListener;
import net.one97.paytm.nativesdk.pincvv.listeners.SetOnPinCvvResultListener;
import net.one97.paytm.nativesdk.pincvv.viewmodel.PinCvvModel;

public class PinCvvBottomSheet extends f implements PinCvvListener {
    public CvvPinLayoutBinding cvvPinLayoutBinding;
    private SetOnPinCvvResultListener listener;
    private LottieAnimationView mFetchPayMethodsProgress;
    public PinCvvModel pinCvvModel;

    public static PinCvvBottomSheet getInstance(SetOnPinCvvResultListener setOnPinCvvResultListener, String str, String str2, String str3, String str4, int i2) {
        PinCvvBottomSheet pinCvvBottomSheet = new PinCvvBottomSheet();
        pinCvvBottomSheet.listener = setOnPinCvvResultListener;
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("subtitle", str2);
        bundle.putString(SDKConstants.CVV_PIN_TEXT, str3);
        bundle.putString(SDKConstants.FORGET_CVV_PIN_TEXT, str4);
        bundle.putInt(SDKConstants.PIN_CVV_SIZE, i2);
        pinCvvBottomSheet.setArguments(bundle);
        return pinCvvBottomSheet;
    }

    public void showKeyboard() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                PinCvvBottomSheet.this.cvvPinLayoutBinding.etPincvv.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0));
                PinCvvBottomSheet.this.cvvPinLayoutBinding.etPincvv.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0));
                PinCvvBottomSheet.this.cvvPinLayoutBinding.etPincvv.setSelection(PinCvvBottomSheet.this.cvvPinLayoutBinding.etPincvv.getText().length());
            }
        }, 200);
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager;
        if (getActivity() != null && (inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method")) != null) {
            inputMethodManager.toggleSoftInput(0, 1);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.pinCvvModel = new PinCvvModel(this, getArguments().getString("title"), getArguments().getString("subtitle"), getArguments().getString(SDKConstants.CVV_PIN_TEXT), getArguments().getString(SDKConstants.FORGET_CVV_PIN_TEXT), getArguments().getInt(SDKConstants.PIN_CVV_SIZE));
        this.cvvPinLayoutBinding = (CvvPinLayoutBinding) androidx.databinding.f.a(layoutInflater, R.layout.cvv_pin_layout, (ViewGroup) null, false);
        this.cvvPinLayoutBinding.setPincvvmodel(this.pinCvvModel);
        this.cvvPinLayoutBinding.etPincvv.refresh(this.pinCvvModel.pinSize.get());
        this.mFetchPayMethodsProgress = this.cvvPinLayoutBinding.dotProgressBar;
        setAnimation(this.mFetchPayMethodsProgress);
        showKeyboard();
        return this.cvvPinLayoutBinding.getRoot();
    }

    public void finishPinCvvLayout(String str) {
        if (str == null) {
            dismiss();
            return;
        }
        if (getActivity() != null) {
            SDKUtility.hideKeyboard(this.cvvPinLayoutBinding.etPincvv, getActivity());
        }
        this.listener.onResult(str);
    }

    private void setAnimation(LottieAnimationView lottieAnimationView) {
        this.mFetchPayMethodsProgress.setVisibility(0);
        this.mFetchPayMethodsProgress.setAnimation("Payments-Loader.json");
        this.mFetchPayMethodsProgress.loop(true);
        this.mFetchPayMethodsProgress.playAnimation();
    }
}
