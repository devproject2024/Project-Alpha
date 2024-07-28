package net.one97.paytm.wallet.newdesign.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import net.one97.paytm.wallet.R;

public class WebLoginAlertDialog extends Dialog {
    public static final int BUTTON_NEGATIVE = -2;
    public static final int BUTTON_NEUTRAL = -3;
    public static final int BUTTON_POSITIVE = -1;
    private TextView mBtnNegative;
    private Button mBtnPositive;
    private Context mContext;

    public WebLoginAlertDialog(Context context) {
        super(context, 16973936);
        this.mContext = context;
        getWindow().requestFeature(1);
        setContentView(R.layout.w_web_login_dialog);
        initViews();
    }

    private void initViews() {
        this.mBtnPositive = (Button) findViewById(R.id.w_custom_dialog_btn_positive);
        this.mBtnNegative = (TextView) findViewById(R.id.w_custom_dialog_btn_negative);
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
        }
    }
}
