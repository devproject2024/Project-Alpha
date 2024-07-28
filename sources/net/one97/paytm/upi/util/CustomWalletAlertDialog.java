package net.one97.paytm.upi.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.b;
import net.one97.paytm.upi.R;

public class CustomWalletAlertDialog extends Dialog {
    public static final int BUTTON_NEGATIVE = -2;
    public static final int BUTTON_NEUTRAL = -3;
    public static final int BUTTON_POSITIVE = -1;
    private Boolean Checkboxvalue = Boolean.FALSE;
    private boolean isTomatoMode;
    private TextView mBtnNegative;
    private Button mBtnPositive;
    private CheckBox mCheckBox;
    private Context mContext;
    private TextView mMessage;
    private TextView mTitle;

    public void setTomatoMode(boolean z) {
        this.isTomatoMode = z;
    }

    public CustomWalletAlertDialog(Context context) {
        super(context, 16973936);
        this.mContext = context;
        getWindow().requestFeature(1);
        setContentView(R.layout.upi_w_custom_dialog);
        initViews();
    }

    public CustomWalletAlertDialog(Context context, boolean z) {
        super(context, 16973936);
        this.mContext = context;
        this.Checkboxvalue = Boolean.valueOf(z);
        getWindow().requestFeature(1);
        setContentView(R.layout.upi_w_custom_dialog);
        initViews();
    }

    public void initViews() {
        this.mBtnPositive = (Button) findViewById(R.id.w_custom_dialog_btn_positive);
        this.mBtnNegative = (TextView) findViewById(R.id.w_custom_dialog_btn_negative);
        this.mTitle = (TextView) findViewById(R.id.w_custom_dialog_title);
        this.mMessage = (TextView) findViewById(R.id.w_custom_dialog_message);
        this.mCheckBox = (CheckBox) findViewById(R.id.w_custom_dialog_checkbox);
        if (this.Checkboxvalue.booleanValue()) {
            this.mCheckBox.setVisibility(0);
            this.mTitle.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mTitle.setText(this.mContext.getString(R.string.alert));
        } else if (charSequence.equals("utility_hide_title") || charSequence.equals("gold_hide_title")) {
            this.mTitle.setVisibility(8);
        } else {
            this.mTitle.setText(charSequence);
        }
    }

    public void hideTitle() {
        this.mTitle.setVisibility(8);
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
            if (!this.isTomatoMode) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.mBtnPositive.setBackground(b.a(this.mContext, R.drawable.button_mall_tomato_new));
            } else {
                this.mBtnPositive.setBackgroundResource(R.drawable.button_mall_tomato_new);
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
