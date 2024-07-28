package com.alipay.mobile.nebulacore.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5EventFilter;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.alipay.mobile.h5container.api.H5SimplePlugin;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.view.H5ToastLikeDialog;
import com.alipay.mobile.nebulacore.R;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.alipay.mobile.nebulacore.util.H5ToastUtil;
import com.business.merchant_payments.common.utility.AppConstants;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class H5ToastPlugin extends H5SimplePlugin {
    private static final String HIDE_TOAST = "hideToast";
    public static final String TAG = "H5ToastPlugin";
    private static final int TOAST_EXCEPTION = R.drawable.h5_toast_exception;
    private static final int TOAST_FAIL = R.drawable.h5_toast_false;
    private static final int TOAST_OK = R.drawable.h5_toast_ok;
    private H5ToastLikeDialog dialog = null;
    private Toast toast = null;

    public void onPrepare(H5EventFilter h5EventFilter) {
        super.onPrepare(h5EventFilter);
        h5EventFilter.addAction(H5Plugin.CommonEvents.TOAST);
        h5EventFilter.addAction(HIDE_TOAST);
    }

    public boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        String action = h5Event.getAction();
        if (H5Plugin.CommonEvents.TOAST.equals(action)) {
            toast(h5Event, h5BridgeContext);
            return true;
        } else if (!HIDE_TOAST.equals(action)) {
            return true;
        } else {
            hideToast();
            return true;
        }
    }

    private int getImageId(String str) {
        if (TextUtils.equals(str, "success")) {
            return TOAST_OK;
        }
        if (TextUtils.equals(str, SDKConstants.CUI_VALUE_PAYMENT_STATUS_FAIL)) {
            return TOAST_FAIL;
        }
        if (TextUtils.equals(str, "exception")) {
            return TOAST_EXCEPTION;
        }
        return 0;
    }

    public void onRelease() {
        super.onRelease();
        this.toast = null;
    }

    private void toast(H5Event h5Event, final H5BridgeContext h5BridgeContext) {
        e param = h5Event.getParam();
        if (param != null && !param.isEmpty()) {
            String string = H5Utils.getString(param, "content");
            String string2 = H5Utils.getString(param, "type");
            int i2 = H5Utils.getInt(param, AppConstants.DURATION);
            if (i2 == 0) {
                i2 = H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY;
            }
            showToast(h5Event.getActivity(), getImageId(string2), string, 17, 0, 0, i2);
            H5Utils.runOnMain(new Runnable() {
                public void run() {
                    H5Log.d(H5ToastPlugin.TAG, "toast show call back");
                    e eVar = new e();
                    eVar.put("toastCallBack", (Object) "true");
                    h5BridgeContext.sendBridgeResult(eVar);
                    H5ToastPlugin.this.hideToast();
                }
            }, (long) i2);
            H5Log.d(TAG, "toast show");
        }
    }

    private void showToast(Context context, int i2, String str, int i3, int i4, int i5, int i6) {
        if (!(context instanceof H5Activity)) {
            Toast toast2 = this.toast;
            if (toast2 == null) {
                this.toast = Toast.makeText(context, str, i6);
            } else {
                toast2.setText(str);
                this.toast.setDuration(1);
            }
        } else if (H5ToastUtil.checkOp(context, 11) != 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.h5_toast, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.h5_mini_toast_icon);
            if (i2 != 0) {
                imageView.setImageResource(i2);
            } else {
                imageView.setVisibility(8);
            }
            TextView textView = (TextView) inflate.findViewById(R.id.h5_mini_toast_text);
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
            } else {
                textView.setText(str);
            }
            inflate.getBackground().setAlpha(192);
            if (this.toast == null) {
                this.toast = new Toast(context);
                this.toast.setGravity(i3, i4, i5);
            }
            this.toast.setDuration(1);
            this.toast.setView(inflate);
        } else if (showToastLikeDialog()) {
            this.dialog = new H5ToastLikeDialog(context);
            this.dialog.setText(str);
            this.dialog.setDuration(i6);
            this.dialog.setTextColor(-1);
            if (i2 != 0) {
                this.dialog.setImageView(context.getResources().getDrawable(i2));
            }
            this.dialog.showToastLikeDialog();
            return;
        } else {
            return;
        }
        this.toast.show();
    }

    /* access modifiers changed from: private */
    public void hideToast() {
        Toast toast2 = this.toast;
        if (toast2 != null) {
            toast2.cancel();
        }
        H5ToastLikeDialog h5ToastLikeDialog = this.dialog;
        if (h5ToastLikeDialog != null) {
            h5ToastLikeDialog.dismiss();
        }
    }

    private boolean showToastLikeDialog() {
        return !"no".equalsIgnoreCase(H5Environment.getConfig("h5_showToastLikeDialog"));
    }
}
