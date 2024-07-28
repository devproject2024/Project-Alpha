package com.alipay.mobile.nebulacore.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.H5Log;

public class H5Alert implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
    public static final int INDEX_CANCEL = 3;
    public static final int INDEX_LEFT = 0;
    public static final int INDEX_MIDDLE = 1;
    public static final int INDEX_RIGHT = 2;
    public static final String TAG = "H5Alert";
    private Activity activity;
    private String button1Label;
    private String button2Label;
    private String button3Label;
    private boolean cancelable = true;
    private AlertDialog dialog;
    private H5AlertListener listener;
    private String message;
    private String title;

    public interface H5AlertListener {
        void onCancel(H5Alert h5Alert);

        void onClick(H5Alert h5Alert, int i2);
    }

    public H5Alert(Activity activity2) {
        this.activity = activity2;
    }

    public H5Alert title(String str) {
        this.title = str;
        return this;
    }

    public H5Alert message(String str) {
        this.message = str;
        return this;
    }

    public H5Alert cancelable(boolean z) {
        this.cancelable = z;
        return this;
    }

    public H5Alert buttons(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            H5Log.w(TAG, "no buttons set.");
            return this;
        }
        int length = strArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length == 3) {
                    this.button3Label = strArr[2];
                }
                return this;
            }
            this.button2Label = strArr[1];
        }
        this.button1Label = strArr[0];
        return this;
    }

    public H5Alert listener(H5AlertListener h5AlertListener) {
        this.listener = h5AlertListener;
        return this;
    }

    public H5Alert show() {
        Activity activity2 = this.activity;
        if (activity2 == null || activity2.isFinishing()) {
            H5Log.d(TAG, "activity is finishing");
            this.dialog = null;
            return this;
        } else if (!TextUtils.isEmpty(this.title) || !TextUtils.isEmpty(this.message)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
            if (!TextUtils.isEmpty(this.title)) {
                builder.setTitle(this.title);
            }
            if (!TextUtils.isEmpty(this.message)) {
                builder.setMessage(this.message);
            }
            if (!TextUtils.isEmpty(this.button1Label)) {
                if (Build.VERSION.SDK_INT <= 14) {
                    builder.setPositiveButton(this.button1Label, this);
                } else {
                    builder.setNegativeButton(this.button1Label, this);
                }
            }
            if (!TextUtils.isEmpty(this.button2Label)) {
                builder.setNeutralButton(this.button2Label, this);
            }
            if (!TextUtils.isEmpty(this.button3Label)) {
                if (Build.VERSION.SDK_INT <= 14) {
                    builder.setNegativeButton(this.button3Label, this);
                } else {
                    builder.setPositiveButton(this.button3Label, this);
                }
            }
            builder.setCancelable(this.cancelable);
            builder.setOnCancelListener(this);
            this.dialog = builder.show();
            return this;
        } else {
            H5Log.w(TAG, "empty title and message");
            return this;
        }
    }

    public void dismiss() {
        Activity activity2;
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null && alertDialog.isShowing() && (activity2 = this.activity) != null && !activity2.isFinishing()) {
            try {
                this.dialog.dismiss();
            } catch (Throwable unused) {
                H5Log.e(TAG, "dismiss exception");
            }
            this.dialog = null;
        }
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        int i3 = i2 == -3 ? 1 : ((i2 != -1 || Build.VERSION.SDK_INT > 14) && (i2 != -2 || Build.VERSION.SDK_INT <= 14)) ? 2 : 0;
        dismiss();
        H5AlertListener h5AlertListener = this.listener;
        if (h5AlertListener != null) {
            h5AlertListener.onClick(this, i3);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        H5AlertListener h5AlertListener = this.listener;
        if (h5AlertListener != null) {
            h5AlertListener.onCancel(this);
        }
    }
}
