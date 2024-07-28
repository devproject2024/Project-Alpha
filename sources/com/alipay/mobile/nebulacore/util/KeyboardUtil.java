package com.alipay.mobile.nebulacore.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.alipay.mobile.nebula.util.H5Log;

public class KeyboardUtil implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final String TAG = "KeyboardUtil";
    public static boolean mVisible;
    private int mHeight = 0;
    private KeyboardListener mListener;
    private View mRootView;

    public interface KeyboardListener {
        void onKeyboardVisible(boolean z);
    }

    public KeyboardUtil(Activity activity) {
        mVisible = false;
        if (activity != null) {
            try {
                this.mRootView = activity.getWindow().getDecorView().findViewById(16908290);
            } catch (Exception e2) {
                H5Log.e(TAG, "exception detail", e2);
            }
        }
    }

    public void setListener(KeyboardListener keyboardListener) {
        this.mListener = keyboardListener;
        if (this.mListener == null) {
            this.mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    public void onGlobalLayout() {
        if (this.mHeight == 0) {
            this.mHeight = this.mRootView.getMeasuredHeight();
        } else if (this.mListener != null) {
            int height = this.mRootView.getHeight();
            if (!mVisible && this.mHeight > height + 100) {
                mVisible = true;
                this.mListener.onKeyboardVisible(mVisible);
                this.mHeight = height;
            } else if (mVisible && this.mHeight < height - 100) {
                mVisible = false;
                this.mListener.onKeyboardVisible(mVisible);
                this.mHeight = height;
            }
        }
    }
}
