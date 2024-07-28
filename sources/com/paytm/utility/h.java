package com.paytm.utility;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.b;

public final class h extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public CheckBox f43821a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43822b;

    /* renamed from: c  reason: collision with root package name */
    private Button f43823c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f43824d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f43825e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f43826f;

    /* renamed from: g  reason: collision with root package name */
    private Context f43827g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f43828h = Boolean.FALSE;

    public h(Context context) {
        super(context, 16973936);
        this.f43827g = context;
        getWindow().requestFeature(1);
        setContentView(R.layout.dialog_custom_wallet_alert);
        b();
    }

    public h(Context context, byte b2) {
        super(context, 16973936);
        this.f43827g = context;
        this.f43828h = Boolean.TRUE;
        getWindow().requestFeature(1);
        setContentView(R.layout.dialog_custom_wallet_alert);
        b();
    }

    private void b() {
        this.f43823c = (Button) findViewById(R.id.w_custom_dialog_btn_positive);
        this.f43824d = (TextView) findViewById(R.id.w_custom_dialog_btn_negative);
        this.f43825e = (TextView) findViewById(R.id.w_custom_dialog_title);
        this.f43826f = (TextView) findViewById(R.id.w_custom_dialog_message);
        this.f43821a = (CheckBox) findViewById(R.id.w_custom_checkbox);
        if (this.f43828h.booleanValue()) {
            this.f43821a.setVisibility(0);
            this.f43825e.setVisibility(8);
        }
    }

    public final void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f43825e.setText(this.f43827g.getString(R.string.alert));
        } else if (charSequence.equals("utility_hide_title") || charSequence.equals("gold_hide_title")) {
            this.f43825e.setVisibility(8);
        } else {
            this.f43825e.setText(charSequence);
        }
    }

    public final void a() {
        this.f43825e.setVisibility(8);
    }

    public final void a(CharSequence charSequence) {
        this.f43826f.setText(charSequence);
    }

    public final void a(int i2, CharSequence charSequence, View.OnClickListener onClickListener) {
        if (i2 == -1) {
            this.f43823c.setText(charSequence);
            this.f43823c.setOnClickListener(onClickListener);
        } else if (i2 == -2) {
            this.f43824d.setText(charSequence);
            this.f43824d.setOnClickListener(onClickListener);
        } else if (i2 == -3) {
            this.f43824d.setVisibility(8);
            this.f43823c.setText(charSequence);
            this.f43823c.setOnClickListener(onClickListener);
            if (this.f43822b) {
                this.f43823c.setBackground(b.a(this.f43827g, R.drawable.button_mall_tomato_new));
            }
        }
    }

    public final void b(CharSequence charSequence) {
        this.f43821a.setText(charSequence);
    }
}
