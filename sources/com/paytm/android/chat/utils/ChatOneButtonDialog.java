package com.paytm.android.chat.utils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.paytm.android.chat.R;

public class ChatOneButtonDialog extends Dialog {
    public static final int BUTTON_NEGATIVE = -2;
    public static final int BUTTON_NEUTRAL = -3;
    public static final int BUTTON_POSITIVE = -1;
    private Boolean Checkboxvalue = Boolean.FALSE;
    private boolean isTomatoMode;
    private TextView mBtnNegative;
    private Button mBtnPositive;
    private CheckBox mCheckBox;
    private Context mContext;
    private ImageView mDeleteImg;
    private TextView mMessage;
    private TextView mTitle;

    public void setTomatoMode(boolean z) {
        this.isTomatoMode = z;
    }

    public ChatOneButtonDialog(Context context) {
        super(context);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
        setContentView(R.layout.chat_one_button_dialog);
        initViews();
    }

    public ChatOneButtonDialog(Context context, boolean z) {
        super(context);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
        this.Checkboxvalue = Boolean.valueOf(z);
        setContentView(R.layout.chat_one_button_dialog);
        initViews();
    }

    public void initViews() {
        this.mBtnPositive = (Button) findViewById(R.id.chat_custom_dialog_btn_positive);
        this.mBtnNegative = (TextView) findViewById(R.id.chat_custom_dialog_btn_negative);
        this.mTitle = (TextView) findViewById(R.id.chat_custom_dialog_title);
        this.mMessage = (TextView) findViewById(R.id.chat_custom_dialog_message);
        this.mCheckBox = (CheckBox) findViewById(R.id.chat_custom_checkbox);
        this.mDeleteImg = (ImageView) findViewById(R.id.chat_custom_dialog_img);
        if (this.Checkboxvalue.booleanValue()) {
            this.mCheckBox.setVisibility(0);
            this.mTitle.setVisibility(8);
        }
        this.mDeleteImg.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChatOneButtonDialog.this.dismiss();
            }
        });
    }

    public void showDelete() {
        this.mDeleteImg.setVisibility(0);
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mTitle.setText(this.mContext.getString(R.string.chat_alert));
        } else if (charSequence.equals("utility_hide_title") || charSequence.equals("gold_hide_title")) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setText(charSequence);
        }
    }

    public void hideTitle() {
        this.mTitle.setVisibility(8);
    }

    public void hideMessage() {
        this.mMessage.setVisibility(8);
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage.setText(charSequence);
    }

    public void setButton(int i2, CharSequence charSequence, View.OnClickListener onClickListener) {
        if (i2 == -1) {
            this.mBtnPositive.setText(charSequence);
            this.mBtnPositive.setOnClickListener(onClickListener);
        } else if (i2 == -2) {
            this.mBtnNegative.setText(charSequence);
            this.mBtnNegative.setOnClickListener(onClickListener);
        } else if (i2 == -3) {
            this.mBtnNegative.setVisibility(8);
            this.mBtnPositive.setText(charSequence);
            this.mBtnPositive.setOnClickListener(onClickListener);
            if (this.isTomatoMode) {
                this.mBtnPositive.setBackground(b.a(this.mContext, R.drawable.chat_button_mall_tomato_new));
            }
        }
    }

    public void setCheckBoxText(CharSequence charSequence) {
        this.mCheckBox.setText(charSequence);
    }

    public void hideCheckbox() {
        this.mCheckBox.setVisibility(8);
    }

    public boolean getchecked() {
        return this.mCheckBox.isChecked();
    }

    public void setMessageFontStyle(int i2) {
        TextView textView = this.mMessage;
        textView.setTypeface(textView.getTypeface(), i2);
    }

    public void setMessageFontSize(int i2) {
        this.mMessage.setTextSize((float) i2);
    }

    public void setTitleFontSize(int i2) {
        this.mTitle.setTextSize((float) i2);
    }
}
