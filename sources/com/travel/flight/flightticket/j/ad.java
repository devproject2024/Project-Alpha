package com.travel.flight.flightticket.j;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.flightticket.f.h;
import com.travel.flight.utils.c;

public final class ad extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    EditText f25076a;

    /* renamed from: b  reason: collision with root package name */
    EditText f25077b;

    /* renamed from: c  reason: collision with root package name */
    TextView f25078c;

    /* renamed from: d  reason: collision with root package name */
    TextView f25079d;

    /* renamed from: e  reason: collision with root package name */
    h f25080e;

    /* renamed from: f  reason: collision with root package name */
    public String f25081f;

    /* renamed from: g  reason: collision with root package name */
    public String f25082g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f25083h;

    /* renamed from: i  reason: collision with root package name */
    private View f25084i;
    private String j;

    public ad(View view, h hVar, Context context) {
        super(view);
        String str;
        this.f25084i = view;
        this.f25080e = hVar;
        b.a();
        this.j = b.b().e(context);
        this.f25083h = (TextView) view.findViewById(R.id.label_travellers);
        if (this.j.equalsIgnoreCase("reseller")) {
            TextView textView = this.f25083h;
            textView.setText(textView.getResources().getString(R.string.passenger_contact_information));
        }
        this.f25076a = (EditText) view.findViewById(R.id.traveller_mobile_number);
        this.f25078c = (RoboTextView) view.findViewById(R.id.error_text_mobile);
        this.f25076a.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (ad.this.f25080e != null) {
                    ad.this.f25080e.f();
                }
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                ad.this.f25078c.setVisibility(8);
                ad.this.f25078c.setText((CharSequence) null);
                if (charSequence == null || charSequence.toString().length() != 0) {
                    ad.this.f25076a.setTypeface(Typeface.create("sans-serif-medium", 0));
                    ad.this.f25076a.setTextSize(2, 17.0f);
                    return;
                }
                ad.this.f25076a.setTypeface(Typeface.create("sans-serif-light", 0));
                ad.this.f25076a.setTextSize(2, 15.0f);
            }
        });
        this.f25077b = (EditText) view.findViewById(R.id.traveller_email_id);
        this.f25079d = (RoboTextView) view.findViewById(R.id.error_text_email);
        this.f25077b.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                ad.this.f25079d.setVisibility(8);
                ad.this.f25079d.setText((CharSequence) null);
                if (charSequence == null || charSequence.toString().length() != 0) {
                    ad.this.f25077b.setTypeface(Typeface.create("sans-serif-medium", 0));
                    ad.this.f25077b.setTextSize(2, 17.0f);
                    return;
                }
                ad.this.f25077b.setTypeface(Typeface.create("sans-serif-light", 0));
                ad.this.f25077b.setTextSize(2, 15.0f);
            }
        });
        this.f25077b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z && ad.this.f25080e != null) {
                    ad.this.f25080e.f();
                }
            }
        });
        this.f25076a.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z && ad.this.f25080e != null) {
                    ad.this.f25080e.f();
                }
            }
        });
        if (com.paytm.utility.b.m(this.f25077b.getContext().getApplicationContext()) != null) {
            this.f25077b.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.f25077b.setTextSize(2, 17.0f);
            if (!this.j.equalsIgnoreCase("reseller")) {
                EditText editText = this.f25077b;
                editText.setText(com.paytm.utility.b.m(editText.getContext().getApplicationContext()));
            }
        }
        if (com.paytm.utility.b.l(this.f25076a.getContext().getApplicationContext()) != null) {
            this.f25076a.setTypeface(Typeface.create("sans-serif-medium", 0));
            this.f25076a.setTextSize(2, 17.0f);
            if (!this.j.equalsIgnoreCase("reseller")) {
                str = com.paytm.utility.b.l(this.f25076a.getContext().getApplicationContext());
            } else {
                str = "";
            }
            this.f25076a.setText(str.replaceAll("\\+91", "").replaceAll("\\s", ""));
        }
    }

    public final boolean a() {
        Boolean bool = Boolean.TRUE;
        String obj = this.f25076a.getText().toString();
        String obj2 = this.f25077b.getText().toString();
        String a2 = c.a(obj.replace("+91 ", ""), this.f25076a.getContext().getApplicationContext());
        if (!a2.equalsIgnoreCase("success")) {
            this.f25078c.setVisibility(0);
            this.f25078c.setText(a2);
            bool = Boolean.FALSE;
        } else {
            this.f25082g = obj;
            this.f25078c.setVisibility(8);
            this.f25078c.setText((CharSequence) null);
        }
        Boolean bool2 = Boolean.TRUE;
        String b2 = c.b(obj2, this.f25084i.getContext());
        if (!b2.equalsIgnoreCase("success")) {
            this.f25079d.setVisibility(0);
            this.f25079d.setText(b2);
            bool2 = Boolean.FALSE;
        } else {
            this.f25081f = obj2;
            this.f25079d.setVisibility(8);
            this.f25079d.setText((CharSequence) null);
        }
        if (!bool2.booleanValue() || !bool.booleanValue()) {
            return false;
        }
        return true;
    }
}
