package com.travel.train.helper;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.j.g;
import com.travel.train.model.trainticket.CJRTrainConfig;

public final class o implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    String f27429a;

    /* renamed from: b  reason: collision with root package name */
    RelativeLayout f27430b = ((RelativeLayout) this.f27434f.findViewById(R.id.bert_preference_layout));

    /* renamed from: c  reason: collision with root package name */
    RelativeLayout f27431c = ((RelativeLayout) this.f27434f.findViewById(R.id.food_preference_layout));

    /* renamed from: d  reason: collision with root package name */
    RelativeLayout f27432d = ((RelativeLayout) this.f27434f.findViewById(R.id.user_id_layout));

    /* renamed from: e  reason: collision with root package name */
    String f27433e;

    /* renamed from: f  reason: collision with root package name */
    private View f27434f;

    /* renamed from: g  reason: collision with root package name */
    private CheckBox f27435g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f27436h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f27437i;
    private TextView j = ((TextView) this.f27434f.findViewById(R.id.infant_fare_description));
    private RelativeLayout k;
    private LinearLayout l;
    private CheckBox m;
    private CheckBox n;
    private boolean o;
    private TextView p = ((TextView) this.f27434f.findViewById(R.id.senior_citizen_text));
    private TextView q;
    private LinearLayout r;
    private RoboTextView s;
    private ImageView t = ((ImageView) this.f27434f.findViewById(R.id.age_clear));
    private TextView u = ((TextView) this.f27434f.findViewById(R.id.age_error));
    private View v = this.f27434f.findViewById(R.id.age_view);
    private EditText w;
    private Activity x;
    private CJRTrainConfig y;

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public o(Activity activity, boolean z, String str, View view, String str2, CJRTrainConfig cJRTrainConfig) {
        View view2 = view;
        this.f27429a = str;
        this.f27434f = view2;
        this.f27435g = (CheckBox) view2.findViewById(R.id.radio_senior_citizen);
        this.k = (RelativeLayout) view2.findViewById(R.id.bed_roll_lyt);
        this.f27436h = (RelativeLayout) view2.findViewById(R.id.child_berth_choice_lyt);
        this.l = (LinearLayout) view2.findViewById(R.id.country_choice_layout);
        this.n = (CheckBox) view2.findViewById(R.id.bed_roll_radio);
        this.m = (CheckBox) view2.findViewById(R.id.radio_berth_choice);
        this.o = z;
        this.r = (LinearLayout) view2.findViewById(R.id.senior_no_discount_lyt);
        this.q = (TextView) view2.findViewById(R.id.no_discount_txt);
        this.p = (TextView) view2.findViewById(R.id.senior_citizen_text);
        this.f27437i = (RelativeLayout) view2.findViewById(R.id.senior_citizen_lyt);
        this.w = (EditText) view2.findViewById(R.id.age);
        this.s = (RoboTextView) view2.findViewById(R.id.save_button);
        this.f27433e = str2;
        this.x = activity;
        this.y = cJRTrainConfig;
    }

    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        boolean z;
        if (this.u.getVisibility() == 0) {
            this.u.setVisibility(8);
        }
        if (charSequence.length() > 0) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
        this.v.setBackgroundColor(this.x.getResources().getColor(R.color.payment_success_line_grey));
        if (charSequence.length() >= 2 && this.x.getCurrentFocus() != null) {
            ((InputMethodManager) this.x.getSystemService("input_method")).hideSoftInputFromWindow(this.x.getCurrentFocus().getWindowToken(), 0);
        }
        this.v.setBackgroundColor(this.x.getResources().getColor(R.color.payment_success_line_grey));
        if (!this.o) {
            if (charSequence == null || charSequence.length() <= 0) {
                this.j.setVisibility(8);
                b(false);
                return;
            }
            if (Integer.parseInt(charSequence.toString()) < this.y.getMinPassengerAge()) {
                this.l.setVisibility(8);
                c(false);
            } else {
                this.l.setVisibility(0);
                c(true);
            }
            String charSequence2 = charSequence.toString();
            RadioButton radioButton = (RadioButton) this.f27434f.findViewById(R.id.male_radio);
            RadioButton radioButton2 = (RadioButton) this.f27434f.findViewById(R.id.female_radio);
            RadioButton radioButton3 = (RadioButton) this.f27434f.findViewById(R.id.transgender_radio);
            if (!TextUtils.isEmpty(charSequence2) && !TextUtils.isEmpty(this.f27433e)) {
                int parseInt = Integer.parseInt(charSequence2);
                String str = this.f27429a;
                if ((!str.equalsIgnoreCase(g.V) || parseInt < 60) && ((!str.equalsIgnoreCase(g.W) || parseInt < 58) && (!str.equalsIgnoreCase(g.X) || parseInt < 60))) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && this.f27433e.equalsIgnoreCase("india")) {
                    a(true);
                    b(false);
                    if (this.y.isSeniorCitizenApplicable()) {
                        this.f27435g.setTag("Senior Citizen");
                        this.f27435g.setChecked(true);
                        this.r.setVisibility(8);
                        this.f27437i.setVisibility(0);
                        if (this.f27429a.equalsIgnoreCase(g.V)) {
                            this.p.setText(this.x.getString(R.string.train_male_senior_text));
                        } else if (this.f27429a.equalsIgnoreCase(g.W)) {
                            this.p.setText(this.x.getString(R.string.train_female_senior_text));
                        } else {
                            this.p.setText(this.x.getString(R.string.train_transgender_senior_text));
                        }
                        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_senior_citizen_male, 0, 0);
                        radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_senior_citizen_female, 0, 0);
                        radioButton3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_transgender, 0, 0);
                        return;
                    }
                    this.q.setText(this.x.getString(R.string.train_senior_no_discount_text));
                    this.f27437i.setVisibility(8);
                    this.r.setVisibility(0);
                    a(charSequence2, radioButton, radioButton2);
                    return;
                }
            }
            this.f27437i.setVisibility(8);
            this.r.setVisibility(8);
            a(charSequence2, radioButton, radioButton2);
        } else if (charSequence != null && charSequence.length() > 0) {
            Integer.parseInt(charSequence.toString());
            this.y.getMinPassengerAge();
            this.j.setVisibility(8);
        }
    }

    private void a(boolean z) {
        if (z) {
            if (this.y.ismIdRequired()) {
                this.f27432d.setVisibility(0);
            }
            if (this.y.ismFoodChoiceEnables()) {
                this.f27431c.setVisibility(0);
            }
            this.f27430b.setVisibility(0);
            return;
        }
        this.f27432d.setVisibility(8);
        this.f27431c.setVisibility(8);
        this.f27430b.setVisibility(8);
    }

    private void b(boolean z) {
        if (!z) {
            this.f27436h.setVisibility(8);
        } else if (!this.y.isChildBerthMandatory()) {
            this.m.setChecked(true);
            this.f27436h.setVisibility(0);
        } else {
            this.f27436h.setVisibility(8);
        }
    }

    private void c(boolean z) {
        if (z) {
            if (this.y.ismBedRollFlagEnabled()) {
                this.n.setChecked(true);
                this.k.setVisibility(0);
            }
            this.m.setChecked(true);
            this.f27436h.setVisibility(0);
            return;
        }
        this.k.setVisibility(8);
        this.f27436h.setVisibility(8);
    }

    private void a(String str, RadioButton radioButton, RadioButton radioButton2) {
        int parseInt = Integer.parseInt(str);
        if (parseInt < this.y.getMinPassengerAge() || parseInt > this.y.getMaxChildAge()) {
            b(false);
        } else {
            b(true);
        }
        if (parseInt < this.y.getMinPassengerAge()) {
            a(false);
        } else {
            a(true);
        }
        if (parseInt < this.y.getMinPassengerAge() || parseInt > this.y.getMaxChildAge()) {
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_male, 0, 0);
            radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_female, 0, 0);
            return;
        }
        radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_child_male_adult, 0, 0);
        radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_child_female_adult, 0, 0);
    }
}
