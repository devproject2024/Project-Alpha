package com.alipay.mobile.nebulacore.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.mobile.nebulacore.R;

public class H5PromptDialog extends Dialog {
    private LinearLayout bottomLayout;
    private RelativeLayout dialogBg;
    private LayoutInflater inflater;
    /* access modifiers changed from: private */
    public EditText inputContent;
    private Button mCancelBtn;
    private Context mContext;
    private Button mEnsureBtn;
    private boolean mIsAutoCancel;
    private TextView mMsg;
    /* access modifiers changed from: private */
    public OnClickNegativeListener mNegativeListener;
    private String mNegativeString;
    /* access modifiers changed from: private */
    public OnClickPositiveListener mPositiveListener;
    private String mPositiveString;
    private TextView mTitle;
    private View rootView;
    private String sMsg;
    private String sTitle;

    public interface OnClickNegativeListener {
        void onClick();
    }

    public interface OnClickPositiveListener {
        void onClick(String str);
    }

    public H5PromptDialog(Context context, String str, String str2, String str3, String str4) {
        this(context, str, str2, str3, str4, false);
    }

    public H5PromptDialog(Context context, String str, String str2, String str3, String str4, boolean z) {
        super(context, R.style.h5_prompt_noTitleTransBgDialogStyle);
        this.mIsAutoCancel = false;
        this.mContext = context;
        this.sTitle = str;
        this.sMsg = str2;
        this.mPositiveString = str3;
        this.mNegativeString = str4;
        this.mIsAutoCancel = z;
        this.inflater = LayoutInflater.from(context);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = this.inflater.inflate(R.layout.h5_prompt_input_dialog, (ViewGroup) null);
        this.rootView = inflate;
        this.mEnsureBtn = (Button) inflate.findViewById(R.id.ensure);
        this.mCancelBtn = (Button) inflate.findViewById(R.id.cancel);
        this.mTitle = (TextView) inflate.findViewById(R.id.title);
        this.mMsg = (TextView) inflate.findViewById(R.id.message);
        this.inputContent = (EditText) inflate.findViewById(R.id.inputContent);
        this.bottomLayout = (LinearLayout) inflate.findViewById(R.id.bottom_ll);
        this.dialogBg = (RelativeLayout) inflate.findViewById(R.id.dialog_bg);
        if (TextUtils.isEmpty(this.sMsg)) {
            this.mMsg.setVisibility(8);
        } else {
            this.mMsg.setText(this.sMsg);
            this.mMsg.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.sTitle)) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setVisibility(0);
            this.mTitle.setText(this.sTitle);
        }
        setCanceledOnTouchOutside(this.mIsAutoCancel);
        initBtn();
    }

    public EditText getInputContent() {
        return this.inputContent;
    }

    private void initBtn() {
        if (!TextUtils.isEmpty(this.mNegativeString) || !TextUtils.isEmpty(this.mPositiveString)) {
            this.bottomLayout.setVisibility(0);
            this.mCancelBtn.setText(this.mNegativeString);
            this.mCancelBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    H5PromptDialog.this.cancel();
                    if (H5PromptDialog.this.mNegativeListener != null) {
                        H5PromptDialog.this.mNegativeListener.onClick();
                    }
                }
            });
            this.mEnsureBtn.setText(this.mPositiveString);
            this.mEnsureBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    H5PromptDialog.this.dismiss();
                    if (H5PromptDialog.this.mPositiveListener == null) {
                        return;
                    }
                    if (H5PromptDialog.this.inputContent.getText() != null) {
                        H5PromptDialog.this.mPositiveListener.onClick(H5PromptDialog.this.inputContent.getText().toString());
                    } else {
                        H5PromptDialog.this.mPositiveListener.onClick((String) null);
                    }
                }
            });
            return;
        }
        this.bottomLayout.setVisibility(8);
    }

    public void show() {
        super.show();
        setContentView(this.rootView);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = getScreenWidth(this.mContext) - (this.mContext.getResources().getDimensionPixelSize(R.dimen.h5_prompt_height) * 2);
        getWindow().setAttributes(attributes);
    }

    private static int getScreenWidth(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public Button getCancelBtn() {
        return this.mCancelBtn;
    }

    public Button getEnsureBtn() {
        return this.mEnsureBtn;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public TextView getMsg() {
        return this.mMsg;
    }

    public LinearLayout getBottomLayout() {
        return this.bottomLayout;
    }

    public RelativeLayout getDialogBg() {
        return this.dialogBg;
    }

    public void setPositiveListener(OnClickPositiveListener onClickPositiveListener) {
        this.mPositiveListener = onClickPositiveListener;
    }

    public void setNegativeListener(OnClickNegativeListener onClickNegativeListener) {
        this.mNegativeListener = onClickNegativeListener;
    }
}
