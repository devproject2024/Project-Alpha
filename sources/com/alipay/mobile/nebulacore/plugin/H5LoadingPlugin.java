package com.alipay.mobile.nebulacore.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Flag;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.H5LoadingView;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.ui.H5LoadingDialog;
import com.alipay.mobile.nebulacore.util.NebulaUtil;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public class H5LoadingPlugin extends H5SimplePlugin {
    private static final int LOADING_TEXT_MAX = 20;
    public static final String TAG = "H5LoadingPlugin";
    /* access modifiers changed from: private */
    public Activity activity;
    private boolean autoHide = true;
    /* access modifiers changed from: private */
    public H5LoadingDialog dialog;
    private H5Page h5Page;
    private Handler handler;
    private boolean isShowFromTiny = false;
    private Runnable loadingTask;

    public H5LoadingPlugin(H5Page h5Page2) {
        this.h5Page = h5Page2;
        this.handler = new Handler();
        Context context = this.h5Page.getContext().getContext();
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
    }

    public void onRelease() {
        H5LoadingDialog h5LoadingDialog = this.dialog;
        if (h5LoadingDialog != null && h5LoadingDialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.handler.removeCallbacks(this.loadingTask);
        this.loadingTask = null;
        this.h5Page = null;
    }

    /* access modifiers changed from: package-private */
    public boolean getDefaultAutoHide(H5Event h5Event) {
        boolean startsWith = h5Event.getId().startsWith("native_");
        if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_showLoading_defaultAutoHide"))) {
            return true;
        }
        return startsWith;
    }

    public void showLoading(H5Event h5Event) {
        e param = h5Event.getParam();
        String string = H5Utils.getString(param, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
        int i2 = H5Utils.getInt(param, "delay");
        this.isShowFromTiny = H5Utils.getBoolean(param, H5Param.isTinyApp, false);
        this.autoHide = H5Utils.getBoolean(param, "autoHide", getDefaultAutoHide(h5Event));
        boolean z = H5Utils.getBoolean(param, "cancelable", true);
        H5Log.d(TAG, "showLoading [title] " + string + " [delay] " + i2 + " autoHide:" + this.autoHide);
        if (this.dialog == null) {
            this.dialog = new H5LoadingDialog(this.activity);
        }
        hideLoading();
        if (!TextUtils.isEmpty(string) && string.length() > 20) {
            string = string.substring(0, 20);
        }
        if (TextUtils.isEmpty(string)) {
            string = H5Environment.getResources().getString(R.string.h5_loading_txt);
        }
        this.dialog.setCancelable(z);
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.setMessage(string);
        this.loadingTask = new Runnable() {
            public void run() {
                if (H5LoadingPlugin.this.activity != null && !H5LoadingPlugin.this.activity.isFinishing()) {
                    try {
                        H5Flag.hasShowLoading = true;
                        H5Log.d(H5LoadingPlugin.TAG, "showLoadingDialog ");
                        H5LoadingPlugin.this.dialog.show();
                    } catch (RuntimeException e2) {
                        H5Flag.hasShowLoading = false;
                        H5Log.e(H5LoadingPlugin.TAG, "exception detail", e2);
                    }
                }
            }
        };
        this.handler.postDelayed(this.loadingTask, (long) i2);
    }

    public void hideLoading() {
        Activity activity2;
        Runnable runnable = this.loadingTask;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.loadingTask = null;
        }
        if (this.dialog != null) {
            H5Log.d(TAG, "dialog.isShowing():" + this.dialog.isShowing() + this.dialog);
        }
        H5LoadingDialog h5LoadingDialog = this.dialog;
        if (h5LoadingDialog != null && h5LoadingDialog.isShowing() && (activity2 = this.activity) != null && !activity2.isFinishing()) {
            H5Log.d(TAG, H5Plugin.CommonEvents.HIDE_LOADING);
            try {
                H5Flag.hasShowLoading = false;
                this.dialog.dismiss();
            } catch (Throwable unused) {
                H5Log.e(TAG, "dismiss exception");
            }
        }
    }

    private void showLoadingView(H5Event h5Event) {
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getH5LoadingView() != null) {
            final H5LoadingView h5LoadingView = this.h5Page.getH5LoadingView();
            e param = h5Event.getParam();
            final String titleString = getTitleString(H5Utils.getString(param, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX));
            int i2 = H5Utils.getInt(param, "delay");
            this.autoHide = H5Utils.getBoolean(param, "autoHide", getDefaultAutoHide(h5Event));
            H5Log.d(TAG, "showLoading [title] " + titleString + " [delay] " + i2);
            hideLoadingView();
            this.loadingTask = new Runnable() {
                public void run() {
                    if (h5LoadingView != null) {
                        try {
                            H5Flag.hasShowLoading = true;
                            H5Log.d(H5LoadingPlugin.TAG, "showLoadingView ");
                            h5LoadingView.setText(titleString);
                            h5LoadingView.setVisibility(0);
                        } catch (RuntimeException e2) {
                            H5Flag.hasShowLoading = false;
                            H5Log.e(H5LoadingPlugin.TAG, (Throwable) e2);
                        }
                    }
                }
            };
            this.handler.postDelayed(this.loadingTask, (long) i2);
        }
    }

    private void hideLoadingView() {
        Activity activity2;
        Runnable runnable = this.loadingTask;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.loadingTask = null;
        }
        H5Page h5Page2 = this.h5Page;
        if (h5Page2 != null && h5Page2.getH5LoadingView() != null && (activity2 = this.activity) != null && !activity2.isFinishing()) {
            H5Log.d(TAG, H5Plugin.CommonEvents.HIDE_LOADING);
            H5Flag.hasShowLoading = false;
            this.h5Page.getH5LoadingView().setVisibility(8);
        }
    }

    private String getTitleString(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 20) {
            str = str.substring(0, 20);
        }
        return TextUtils.isEmpty(str) ? H5Environment.getResources().getString(R.string.h5_loading_txt) : str;
    }

    public void onPrepare(H5EventFilter h5EventFilter) {
        if (this.activity != null) {
            h5EventFilter.addAction("showLoading");
            h5EventFilter.addAction(H5Plugin.CommonEvents.HIDE_LOADING);
            h5EventFilter.addAction(H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK);
        }
    }

    public boolean interceptEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        H5Page h5Page2;
        if (!H5Plugin.InternalEvents.H5_PAGE_PHYSICAL_BACK.equals(h5Event.getAction()) || (h5Page2 = this.h5Page) == null || h5Page2.getH5LoadingView() == null || this.h5Page.getH5LoadingView().getVisibility() != 0 || !NebulaUtil.enableShowLoadingViewConfig()) {
            return super.interceptEvent(h5Event, h5BridgeContext);
        }
        hideLoadingView();
        return true;
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if ("showLoading".equals(action)) {
            if (enableLoadingView()) {
                showLoadingView(h5Event);
            } else {
                showLoading(h5Event);
            }
            h5BridgeContext.sendBridgeResult("success", "true");
        } else if (H5Plugin.CommonEvents.HIDE_LOADING.equals(action)) {
            if (h5Event.getId().startsWith("native_") && !this.autoHide) {
                h5BridgeContext.sendSuccess();
            } else if (this.isShowFromTiny) {
                H5Log.d(TAG, "hide autoHide:" + this.autoHide);
                if (this.autoHide) {
                    hide(h5BridgeContext);
                }
                return true;
            } else {
                hide(h5BridgeContext);
            }
        }
        return true;
    }

    private boolean enableLoadingView() {
        H5Page h5Page2 = this.h5Page;
        return (h5Page2 == null || h5Page2.getContext() == null || this.h5Page.getContext().getContext() == null || !(this.h5Page.getContext().getContext() instanceof H5Activity) || !NebulaUtil.enableShowLoadingViewConfig()) ? false : true;
    }

    private void hide(H5BridgeContext h5BridgeContext) {
        if (enableLoadingView()) {
            hideLoadingView();
        } else {
            hideLoading();
        }
        h5BridgeContext.sendBridgeResult("success", "true");
    }
}
