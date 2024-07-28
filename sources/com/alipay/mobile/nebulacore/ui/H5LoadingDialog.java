package com.alipay.mobile.nebulacore.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alipay.mobile.nebulacore.R;

public class H5LoadingDialog extends Dialog {
    private Activity activity;
    private String messageText;
    private ProgressBar pbLoading;
    private TextView tvMessage;

    public H5LoadingDialog(Activity activity2) {
        this(activity2, R.style.h5_loading_style);
        this.activity = activity2;
    }

    public H5LoadingDialog(Context context, int i2) {
        super(context, i2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        View inflate = LayoutInflater.from(this.activity).inflate(R.layout.h5_loading, (ViewGroup) null);
        this.pbLoading = (ProgressBar) inflate.findViewById(R.id.h5_loading_progress);
        this.tvMessage = (TextView) inflate.findViewById(R.id.h5_loading_message);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.99f;
        getWindow().setAttributes(attributes);
        setContentView(inflate);
        this.pbLoading.setVisibility(0);
        setCancelable(true);
        setOnCancelListener((DialogInterface.OnCancelListener) null);
        this.pbLoading.setIndeterminate(false);
        setCanceledOnTouchOutside(false);
        realSetMessage();
        super.onCreate(bundle);
    }

    public void setMessage(String str) {
        this.messageText = str;
        if (this.tvMessage != null) {
            realSetMessage();
        }
    }

    private void realSetMessage() {
        this.tvMessage.setText(this.messageText);
        if (TextUtils.isEmpty(this.messageText)) {
            this.tvMessage.setVisibility(8);
        } else {
            this.tvMessage.setVisibility(0);
        }
    }
}
