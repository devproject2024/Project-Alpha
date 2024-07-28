package com.alipay.mobile.nebula.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.mobile.nebula.R;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;

public class H5ToastLikeDialog extends Dialog implements DialogInterface.OnDismissListener {
    public static final String TAG = "H5ToastLikeDialog";
    private Drawable mDrawable;
    private int mDuration;
    private ImageView mImageView;
    private TextView mMessageTextView;
    private LinearLayout mRootLayout;
    private CharSequence mText;
    private int mTextColor;
    private int mTextSize;

    public H5ToastLikeDialog(Context context) {
        this(context, R.style.h5_toastLikeDialogStyle);
    }

    public H5ToastLikeDialog(Context context, int i2) {
        super(context, i2);
        this.mDuration = H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.h5_toast_like_dialog);
        this.mMessageTextView = (TextView) findViewById(R.id.message_textview);
        this.mImageView = (ImageView) findViewById(R.id.toast_image_bg);
        this.mRootLayout = (LinearLayout) findViewById(R.id.root_layout);
        initView();
        setOnDismissListener(this);
    }

    private void initView() {
        if (!TextUtils.isEmpty(this.mText)) {
            this.mMessageTextView.setText(this.mText);
        }
        int i2 = this.mTextColor;
        if (i2 != 0) {
            this.mMessageTextView.setTextColor(i2);
        }
        if (this.mDrawable != null) {
            this.mImageView.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 16) {
                this.mImageView.setBackground(this.mDrawable);
            } else {
                this.mImageView.setBackgroundDrawable(this.mDrawable);
            }
            this.mMessageTextView.setPadding(39, 21, 39, 45);
        }
        int i3 = this.mTextSize;
        if (i3 != 0) {
            this.mMessageTextView.setTextSize((float) i3);
        }
        this.mRootLayout.setBackgroundResource(R.drawable.h5_simple_toast_bg);
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence;
    }

    public void setTextColor(int i2) {
        this.mTextColor = i2;
    }

    public void setImageView(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public void setTextSize(int i2) {
        this.mTextSize = i2;
    }

    public void setDuration(int i2) {
        this.mDuration = i2;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public void showToastLikeDialog() {
        ManagerToastLikeDialog.getInstance().add(this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        H5Log.d(TAG, "dialog onDismiss");
        ManagerToastLikeDialog.getInstance().confirmRemoveDialog(this);
    }
}
