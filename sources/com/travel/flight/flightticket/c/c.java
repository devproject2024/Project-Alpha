package com.travel.flight.flightticket.c;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.d;

public final class c extends Dialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f24861a;

    /* renamed from: b  reason: collision with root package name */
    private String f24862b;

    /* renamed from: c  reason: collision with root package name */
    private String f24863c;

    /* renamed from: d  reason: collision with root package name */
    private String f24864d;

    /* renamed from: e  reason: collision with root package name */
    private d f24865e;

    public c(Context context, String str, String str2, String str3, String str4, d dVar) {
        super(context);
        setContentView(R.layout.pre_f_flight_custom_dialog_lyt);
        this.f24865e = dVar;
        this.f24861a = str;
        this.f24862b = str2;
        this.f24863c = str3;
        this.f24864d = str4;
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.custom_dialog_title);
        RoboTextView roboTextView2 = (RoboTextView) findViewById(R.id.custom_dialog_message);
        Button button = (Button) findViewById(R.id.custom_dialog_btn_positive);
        Button button2 = (Button) findViewById(R.id.custom_dialog_btn_negative);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        if (!TextUtils.isEmpty(this.f24861a)) {
            roboTextView.setText(this.f24861a);
        }
        if (!TextUtils.isEmpty(this.f24862b)) {
            roboTextView2.setText(this.f24862b);
        }
        if (!TextUtils.isEmpty(this.f24863c)) {
            button.setText(this.f24863c);
        }
        if (!TextUtils.isEmpty(this.f24864d)) {
            button2.setText(this.f24864d);
        }
        if (!TextUtils.isEmpty(this.f24861a)) {
            roboTextView.setText(this.f24861a);
        }
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.custom_dialog_btn_positive) {
            if (((Button) view).getText().toString().equalsIgnoreCase(view.getContext().getResources().getString(R.string.select_another_seats))) {
                this.f24865e.d();
            } else {
                this.f24865e.b();
            }
        } else if (id != R.id.custom_dialog_btn_negative) {
        } else {
            if (((Button) view).getText().toString().equalsIgnoreCase(view.getContext().getResources().getString(R.string.proceed_to_pay_without_seat))) {
                this.f24865e.e();
            } else {
                this.f24865e.c();
            }
        }
    }
}
