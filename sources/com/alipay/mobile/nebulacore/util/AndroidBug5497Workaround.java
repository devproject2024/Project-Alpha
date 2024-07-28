package com.alipay.mobile.nebulacore.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5StatusBarUtils;

public class AndroidBug5497Workaround {
    private static final String TAG = "H5AndroidBug5497Workaround";
    private FrameLayout.LayoutParams frameLayoutParams;
    private View mChildOfContent;
    private NavigationBarUtil navigtionBarUtil;
    private Rect r = new Rect();
    private int statusBarHeight;
    private int usableHeightPrevious;

    public static void assistActivity(Activity activity, boolean z) {
        try {
            new AndroidBug5497Workaround(activity, z);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
    }

    private AndroidBug5497Workaround(Activity activity, final boolean z) {
        this.navigtionBarUtil = new NavigationBarUtil(activity);
        this.mChildOfContent = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        try {
            this.statusBarHeight = activity.getResources().getDimensionPixelSize(activity.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Throwable th) {
            H5Log.e(TAG, th);
        }
        this.mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                try {
                    AndroidBug5497Workaround.this.possiblyResizeChildOfContent(z);
                } catch (Throwable th) {
                    H5Log.e(AndroidBug5497Workaround.TAG, th);
                }
            }
        });
        this.frameLayoutParams = (FrameLayout.LayoutParams) this.mChildOfContent.getLayoutParams();
    }

    /* access modifiers changed from: private */
    public void possiblyResizeChildOfContent(boolean z) {
        int computeUsableHeight = computeUsableHeight();
        if (computeUsableHeight != this.usableHeightPrevious) {
            int height = this.mChildOfContent.getRootView().getHeight();
            int i2 = height - computeUsableHeight;
            H5Log.d(TAG, "heightDifference " + i2 + " usableHeightSansKeyboard " + height + " statusBarHeight:" + this.statusBarHeight + " hasNavigationBar " + this.navigtionBarUtil.hasNavigationBar() + " NavigationBarHeight " + this.navigtionBarUtil.getNavigationBarHeight());
            if (i2 > height / 4) {
                if (!H5StatusBarUtils.isSupport() || !H5StatusBarUtils.isConfigSupport() || z) {
                    this.frameLayoutParams.height = height - i2;
                } else {
                    this.frameLayoutParams.height = (height - i2) + this.statusBarHeight;
                }
            } else if (!H5StatusBarUtils.isSupport() || !H5StatusBarUtils.isConfigSupport() || z) {
                this.frameLayoutParams.height = height - this.statusBarHeight;
            } else {
                this.frameLayoutParams.height = height;
                if (this.navigtionBarUtil.hasNavigationBar()) {
                    this.frameLayoutParams.height -= this.navigtionBarUtil.getNavigationBarHeight();
                }
            }
            this.mChildOfContent.requestLayout();
            this.usableHeightPrevious = computeUsableHeight;
        }
    }

    private int computeUsableHeight() {
        this.mChildOfContent.getWindowVisibleDisplayFrame(this.r);
        return this.r.bottom - this.r.top;
    }
}
