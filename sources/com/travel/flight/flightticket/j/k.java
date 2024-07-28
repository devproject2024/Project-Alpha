package com.travel.flight.flightticket.j;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.e;
import com.travel.flight.flightticket.f.m;
import com.travel.flight.flightticket.widget.a;
import com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPassenger;
import com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo;
import com.travel.flight.travellerProfile.model.CJRTpGst;
import com.travel.flight.utils.c;
import java.util.ArrayList;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValidation;

public final class k extends RecyclerView.v implements m {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f25166a;

    /* renamed from: b  reason: collision with root package name */
    public CJRDynamicPassenger f25167b;

    /* renamed from: c  reason: collision with root package name */
    CheckBox f25168c;

    /* renamed from: d  reason: collision with root package name */
    e f25169d;

    /* renamed from: e  reason: collision with root package name */
    public CJRGSTPassengerInfo f25170e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f25171f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f25172g;

    /* renamed from: h  reason: collision with root package name */
    private Activity f25173h;

    /* renamed from: i  reason: collision with root package name */
    private a f25174i = new a(this, this.f25173h);

    public final void a(TextView textView, LinearLayout linearLayout) {
    }

    public final void a(String str) {
    }

    public final void a(String str, String str2) {
    }

    public final void a(String str, String str2, int i2, View view, boolean z) {
    }

    public final void a(String str, String str2, View view) {
    }

    public final void a(ArrayList<com.travel.flight.pojo.flightticket.paxinfo.a> arrayList, View view, boolean z) {
    }

    public k(Activity activity, View view, CJRDynamicPassenger cJRDynamicPassenger) {
        super(view);
        this.f25169d = (e) activity;
        this.f25173h = activity;
        this.f25167b = cJRDynamicPassenger;
        this.f25168c = (CheckBox) view.findViewById(R.id.checkbox_gst);
        this.f25168c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                k kVar = k.this;
                if (z) {
                    kVar.f25166a.setVisibility(0);
                } else {
                    kVar.f25166a.setVisibility(8);
                }
                k.this.f25169d.a(z);
                k.this.f25169d.a();
            }
        });
        this.f25172g = (LinearLayout) view.findViewById(R.id.gst_header_layout);
        this.f25172g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                k.this.f25168c.setChecked(!k.this.f25168c.isChecked());
            }
        });
        this.f25171f = (RoboTextView) view.findViewById(R.id.gst_view_sub_text);
        this.f25171f.setText(this.f25173h.getString(R.string.optional));
        this.f25166a = (LinearLayout) view.findViewById(R.id.gst_container_lyt);
        this.f25170e = new CJRGSTPassengerInfo();
        CJRDynamicPassenger cJRDynamicPassenger2 = this.f25167b;
        if (cJRDynamicPassenger2 != null && cJRDynamicPassenger2.getValidations() != null) {
            CJRTpGst gst = com.travel.flight.travellerProfile.a.a().f25522a != null ? com.travel.flight.travellerProfile.a.a().f25522a.getGst() : null;
            if (gst != null && gst.getBusinessProfile()) {
                this.f25168c.setChecked(true);
                for (int i2 = 0; i2 < this.f25167b.getValidations().size(); i2++) {
                    CJRDynamicValidation cJRDynamicValidation = this.f25167b.getValidations().get(i2);
                    if (cJRDynamicValidation.getKey().equals("gst_number")) {
                        cJRDynamicValidation.setmValue(String.valueOf(gst.getGstNumber()));
                    } else if (cJRDynamicValidation.getKey().equals("company_name")) {
                        cJRDynamicValidation.setmValue(gst.getCompanyName());
                    } else if (cJRDynamicValidation.getKey().equals("company_address")) {
                        cJRDynamicValidation.setmValue(gst.getCompanyAddress());
                    } else if (cJRDynamicValidation.getKey().equals("state_of_residence")) {
                        cJRDynamicValidation.setmValue(gst.getStateOfResidence());
                    } else if (cJRDynamicValidation.getKey().equals("company_contact")) {
                        cJRDynamicValidation.setmValue(gst.getCompanyContactNumber());
                    } else if (cJRDynamicValidation.getKey().equals("company_gst_email")) {
                        cJRDynamicValidation.setmValue(gst.getCompanyGstEmail());
                    }
                }
            }
            for (int i3 = 0; i3 < this.f25167b.getValidations().size(); i3++) {
                CJRDynamicValidation cJRDynamicValidation2 = this.f25167b.getValidations().get(i3);
                if (cJRDynamicValidation2.getType().equals("textInput")) {
                    View b2 = this.f25174i.b(cJRDynamicValidation2, b(cJRDynamicValidation2.getKey()));
                    b2.setFocusable(true);
                    b2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        public final void onFocusChange(View view, boolean z) {
                        }
                    });
                    this.f25166a.addView(b2);
                } else if (cJRDynamicValidation2.getType().equals("dropdown")) {
                    this.f25166a.addView(this.f25174i.a(cJRDynamicValidation2, b(cJRDynamicValidation2.getKey())));
                }
            }
        }
    }

    private String b(String str) {
        for (CJRDynamicValidation next : this.f25167b.getValidations()) {
            if (next.getKey().equalsIgnoreCase(str)) {
                return next.getmValue();
            }
        }
        return null;
    }

    public final Boolean a() {
        int childCount = this.f25166a.getChildCount();
        boolean z = true;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (this.f25166a.getChildAt(i2) instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) this.f25166a.getChildAt(i2);
                RoboTextView roboTextView = (RoboTextView) linearLayout.findViewById(R.id.error_text);
                View findViewById = ((TextInputLayout) linearLayout.findViewById(R.id.text_input_layout)).findViewById(R.id.child_view);
                CJRDynamicValidation cJRDynamicValidation = (CJRDynamicValidation) findViewById.getTag();
                if (findViewById instanceof AutoCompleteTextView) {
                    cJRDynamicValidation.setmValue(((AutoCompleteTextView) findViewById).getText().toString());
                } else if (findViewById instanceof EditText) {
                    cJRDynamicValidation.setmValue(((EditText) findViewById).getText().toString());
                }
                a(cJRDynamicValidation);
                String a2 = c.a(cJRDynamicValidation, (Context) this.f25173h);
                if (a2.equalsIgnoreCase("success")) {
                    roboTextView.setVisibility(8);
                    roboTextView.setText((CharSequence) null);
                } else if (this.f25168c.isChecked()) {
                    roboTextView.setVisibility(0);
                    roboTextView.setText(a2);
                    z = false;
                }
            }
        }
        return Boolean.valueOf(z);
    }

    private void a(CJRDynamicValidation cJRDynamicValidation) {
        if (cJRDynamicValidation.getKey().equals("gst_number")) {
            this.f25170e.setGSTNumber(cJRDynamicValidation.getmValue());
        } else if (cJRDynamicValidation.getKey().equals("company_name")) {
            this.f25170e.setCompanyName(cJRDynamicValidation.getmValue());
        } else if (cJRDynamicValidation.getKey().equals("company_address")) {
            this.f25170e.setCompanyAddress(cJRDynamicValidation.getmValue());
        } else if (cJRDynamicValidation.getKey().equals("state_of_residence")) {
            this.f25170e.setStateOfResidence(cJRDynamicValidation.getmValue());
        } else if (cJRDynamicValidation.getKey().equals("company_contact")) {
            this.f25170e.setCompanyContactNumber(cJRDynamicValidation.getmValue());
        } else if (cJRDynamicValidation.getKey().equals("company_gst_email")) {
            this.f25170e.setCompanyGstEmail(cJRDynamicValidation.getmValue());
        }
    }
}
