package com.paytm.network;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.paytm.networkmodule.R;

public final class h extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f42948a;

    /* renamed from: b  reason: collision with root package name */
    private Button f42949b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f42950c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f42951d;

    /* renamed from: e  reason: collision with root package name */
    private Context f42952e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f42953f = Boolean.FALSE;

    public h(Context context) {
        super(context, 16973936);
        this.f42952e = context;
        getWindow().requestFeature(1);
        setContentView(R.layout.w_custom_dialog);
        this.f42949b = (Button) findViewById(R.id.w_custom_dialog_btn_positive);
        this.f42950c = (TextView) findViewById(R.id.w_custom_dialog_btn_negative);
        this.f42951d = (TextView) findViewById(R.id.w_custom_dialog_title);
        this.f42948a = (TextView) findViewById(R.id.w_custom_dialog_message);
    }

    public final void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f42951d.setText(this.f42952e.getString(R.string.alert));
        } else if (charSequence.equals("utility_hide_title") || charSequence.equals("gold_hide_title")) {
            this.f42951d.setVisibility(8);
        } else {
            this.f42951d.setText(charSequence);
        }
    }
}
