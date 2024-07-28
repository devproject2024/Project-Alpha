package com.travel.train.viewholder;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.i.d;
import com.travel.train.j.g;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.utils.n;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.widgets.CJRFloatingLabel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class s extends RecyclerView.v implements View.OnClickListener {
    private LinearLayout A;
    /* access modifiers changed from: private */
    public LinearLayout B;
    /* access modifiers changed from: private */
    public View C;
    private TextView D;
    private View E;
    private View F;
    private TextView G;
    private TextView H;
    private RelativeLayout I;
    private RelativeLayout J;
    private RelativeLayout K;
    private TextView L;
    private RelativeLayout M;
    private TextView N;
    /* access modifiers changed from: private */
    public Context O;
    /* access modifiers changed from: private */
    public HashMap<String, Integer> P;
    private d Q;
    /* access modifiers changed from: private */
    public int R = 2;
    /* access modifiers changed from: private */
    public String S = "";
    private boolean T;
    private String U = "CJRPassengerAdditionalPreferenceViewHolder";
    private View.OnClickListener V = new View.OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == R.id.coach_clear && s.this.f28219b != null) {
                s.this.f28219b.setText((CharSequence) "");
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public View f28218a;

    /* renamed from: b  reason: collision with root package name */
    CJRFloatingLabel f28219b;

    /* renamed from: c  reason: collision with root package name */
    public CJRTrainDetailsBody f28220c;

    /* renamed from: d  reason: collision with root package name */
    public String f28221d;

    /* renamed from: e  reason: collision with root package name */
    public int f28222e = -1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28223f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f28224g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f28225h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f28226i;
    private TextView j;
    private ImageView k;
    /* access modifiers changed from: private */
    public RadioGroup l;
    /* access modifiers changed from: private */
    public TextView m;
    private TextView n;
    private ImageView o;
    private CheckBox p;
    private RelativeLayout q;
    /* access modifiers changed from: private */
    public TextView r;
    private RelativeLayout s;
    /* access modifiers changed from: private */
    public TextView t;
    private CheckBox u;
    /* access modifiers changed from: private */
    public RelativeLayout v;
    /* access modifiers changed from: private */
    public ImageView w;
    private TextView x;
    private ImageView y;
    private RelativeLayout z;

    static /* synthetic */ int p(s sVar) {
        int i2 = sVar.R;
        sVar.R = i2 + 1;
        return i2;
    }

    public s(View view, d dVar, CJRTrainDetailsBody cJRTrainDetailsBody, boolean z2, boolean z3) {
        super(view);
        this.O = view.getContext();
        this.f28218a = view.findViewById(R.id.preference_lyt);
        this.f28223f = z2;
        this.Q = dVar;
        this.f28220c = cJRTrainDetailsBody;
        this.T = z3;
        this.f28224g = (LinearLayout) this.f28218a.findViewById(R.id.top_container);
        this.f28225h = (LinearLayout) this.f28218a.findViewById(R.id.boarder_container);
        this.G = (TextView) this.f28218a.findViewById(R.id.filled_additional_title);
        this.H = (TextView) this.f28218a.findViewById(R.id.tv_filled_edit);
        this.I = (RelativeLayout) this.f28218a.findViewById(R.id.filled_additional_lyt);
        this.J = (RelativeLayout) this.f28218a.findViewById(R.id.filled_auto_upgrate);
        this.K = (RelativeLayout) this.f28218a.findViewById(R.id.filled_coach_lyt);
        this.L = (TextView) this.f28218a.findViewById(R.id.filled_coach_num);
        this.M = (RelativeLayout) this.f28218a.findViewById(R.id.filled_reservation_choice_lyt);
        this.N = (TextView) this.f28218a.findViewById(R.id.reservation_txt);
        this.H.setOnClickListener(this);
        if (d()) {
            this.G.setText(this.O.getString(R.string.guaranteed_berth_preference));
        } else {
            this.G.setText(this.O.getString(R.string.train_additional_preference));
        }
        if (d()) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.O).inflate(R.layout.train_bearth_preference_choice, this.f28224g, false);
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.O).inflate(R.layout.train_additional_pref_coach_id_layout, this.f28225h, false);
            this.f28224g.addView(linearLayout);
            this.f28225h.addView(linearLayout2);
            this.f28224g.setVisibility(0);
            this.f28225h.setVisibility(0);
            this.f28226i = (RelativeLayout) linearLayout.findViewById(R.id.preference_heading);
            this.j = (TextView) linearLayout.findViewById(R.id.preference_text);
            this.k = (ImageView) linearLayout.findViewById(R.id.iv_berth_info_icon);
            this.l = (RadioGroup) linearLayout.findViewById(R.id.reservation_choices);
            this.m = (TextView) linearLayout.findViewById(R.id.tv_berth_preference_msg);
            this.n = (TextView) linearLayout.findViewById(R.id.tv_hide_berth);
            ResourceUtils.loadTrainImagesFromCDN(this.k, "info_icon.png", false, true, n.a.V1);
            this.f28226i.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.n.setOnClickListener(this);
            if (this.T) {
                this.k.setVisibility(8);
            } else {
                this.k.setVisibility(0);
            }
            this.l.removeAllViews();
            CJRTrainDetailsBody cJRTrainDetailsBody2 = this.f28220c;
            if (!(cJRTrainDetailsBody2 == null || cJRTrainDetailsBody2.getTrainPreferences() == null || this.f28220c.getTrainPreferences().getPreferenceList() == null || this.f28220c.getTrainPreferences().getPreferenceList().size() <= 0)) {
                this.P = this.f28220c.getTrainPreferences().getPreferenceChoice();
                for (int i2 = 0; i2 < this.f28220c.getTrainPreferences().getPreferenceList().size(); i2++) {
                    RadioButton radioButton = (RadioButton) LayoutInflater.from(this.O).inflate(R.layout.pre_t_radio_button, (ViewGroup) null);
                    radioButton.setId(i2);
                    radioButton.setText(this.f28220c.getTrainPreferences().getPreferenceList().get(i2));
                    RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(this.O, (AttributeSet) null);
                    if (i2 != 0) {
                        layoutParams.setMargins(0, (int) this.O.getResources().getDimension(R.dimen.dimen_19dp), 0, 0);
                    }
                    radioButton.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(this.f28220c.getmReservationChoice())) {
                        if (this.f28220c.getTrainPreferences().getPreferenceList().get(i2) != null && this.f28220c.getTrainPreferences().getPreferenceList().get(i2).equalsIgnoreCase(this.f28220c.getmReservationChoice())) {
                            radioButton.setChecked(true);
                            this.f28221d = radioButton.getText().toString();
                            this.f28222e = this.P.get(this.f28220c.getTrainPreferences().getPreferenceList().get(i2)).intValue();
                        }
                    } else if (this.f28220c.getTrainPreferences().getPreferenceList().get(i2) != null && this.f28220c.getTrainPreferences().getPreferenceList().get(i2).equalsIgnoreCase(this.O.getString(R.string.none))) {
                        radioButton.setChecked(true);
                        this.f28222e = this.P.get(this.f28220c.getTrainPreferences().getPreferenceList().get(i2)).intValue();
                        this.f28221d = this.f28220c.getTrainPreferences().getPreferenceList().get(i2);
                        this.m.setVisibility(8);
                    }
                    this.l.addView(radioButton);
                }
                this.l.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                        s sVar = s.this;
                        int unused = sVar.f28222e = ((Integer) sVar.P.get(s.this.f28220c.getTrainPreferences().getPreferenceList().get(i2))).intValue();
                        s sVar2 = s.this;
                        String unused2 = sVar2.f28221d = sVar2.f28220c.getTrainPreferences().getPreferenceList().get(i2);
                        s sVar3 = s.this;
                        String unused3 = sVar3.S = ((RadioButton) sVar3.f28218a.findViewById(s.this.l.getCheckedRadioButtonId())).getText().toString();
                        if (!s.this.S.equalsIgnoreCase(s.this.O.getString(R.string.none))) {
                            s.this.m.setVisibility(0);
                        } else {
                            s.this.m.setVisibility(8);
                        }
                        s sVar4 = s.this;
                        sVar4.a("train_traveller_details_reservation_choice_selected", sVar4.h());
                    }
                });
            }
            if (g.f27551a != null) {
                if (this.j != null && !TextUtils.isEmpty(g.f27551a.getBerthTitle())) {
                    this.j.setText(g.f27551a.getBerthTitle());
                }
                if (this.m != null && !TextUtils.isEmpty(g.f27551a.getBerthDisclaimer())) {
                    this.m.setText(g.f27551a.getBerthDisclaimer());
                }
            }
            a((View) linearLayout2);
        } else {
            LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(this.O).inflate(R.layout.train_additional_pref_coach_id_layout, this.f28225h, false);
            this.f28224g.addView(linearLayout3);
            this.f28224g.setVisibility(0);
            this.f28225h.setVisibility(8);
            a((View) linearLayout3);
            a(true);
        }
        a(true, false);
        if (this.T) {
            a(cJRTrainDetailsBody.getAutoUpgrade(), cJRTrainDetailsBody.getCoachNumber(), cJRTrainDetailsBody.getmReservationChoice());
        }
    }

    private boolean d() {
        CJRTrainDetailsBody cJRTrainDetailsBody = this.f28220c;
        if (cJRTrainDetailsBody == null || cJRTrainDetailsBody.getTrainPreferences() == null || this.f28220c.getTrainPreferences().getPreferenceList() == null || this.f28220c.getTrainPreferences().getPreferenceList().size() <= 0) {
            return false;
        }
        CJRTrainAvailability cJRTrainAvailability = this.f28220c.getmTrainAvailability().get(this.f28220c.getMiSelectedPosition());
        String str = (String) cJRTrainAvailability.getTypeMap().entrySet().iterator().next().getValue();
        if ("3".equalsIgnoreCase(str) || "2".equalsIgnoreCase(str)) {
            return false;
        }
        if ("1".equalsIgnoreCase(str)) {
            cJRTrainAvailability.getmSttaus().contains("CURR_AVBL");
        }
        return true;
    }

    private void a(View view) {
        this.z = (RelativeLayout) view.findViewById(R.id.lv_additional_pref_title_container);
        this.A = (LinearLayout) view.findViewById(R.id.lv_additional_container);
        this.o = (ImageView) view.findViewById(R.id.iv_collapse_view);
        this.p = (CheckBox) view.findViewById(R.id.radio_auto_upgrade);
        this.q = (RelativeLayout) view.findViewById(R.id.rv_auto_upgrade_container);
        this.r = (TextView) view.findViewById(R.id.autoUpgrade_text);
        this.s = (RelativeLayout) view.findViewById(R.id.rv_coach_id_checkbox_container);
        this.t = (TextView) view.findViewById(R.id.lv_coach_id_txt);
        this.u = (CheckBox) view.findViewById(R.id.radio_coach_id);
        this.v = (RelativeLayout) view.findViewById(R.id.rv_coach_number_container);
        this.f28219b = (CJRFloatingLabel) view.findViewById(R.id.coach_number_text);
        this.w = (ImageView) view.findViewById(R.id.coach_clear);
        this.C = view.findViewById(R.id.coach_view_divider);
        this.B = (LinearLayout) view.findViewById(R.id.coach_number_info_msg);
        this.x = (TextView) view.findViewById(R.id.coach_number_message);
        this.y = (ImageView) view.findViewById(R.id.coach_number_info_icon);
        this.D = (TextView) view.findViewById(R.id.tv_hide_coach);
        this.E = view.findViewById(R.id.additional_pref_divider);
        this.F = view.findViewById(R.id.tv_additional_optional_txt);
        this.D.setOnClickListener(this);
        this.w.setOnClickListener(this.V);
        if (d()) {
            this.o.setVisibility(0);
            this.E.setVisibility(0);
            this.F.setVisibility(8);
            this.z.setOnClickListener(this);
        } else {
            this.o.setVisibility(8);
            this.E.setVisibility(8);
            this.F.setVisibility(0);
        }
        e();
        f();
        g();
    }

    private void a(boolean z2, boolean z3) {
        if (z3) {
            this.Q.a(z2);
        }
        if (!this.T || !z2) {
            this.I.setVisibility(8);
            this.f28224g.setVisibility(0);
            if (d()) {
                this.f28225h.setVisibility(0);
            } else {
                this.f28225h.setVisibility(8);
            }
            if (this.T) {
                TextView textView = this.n;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                }
                TextView textView2 = this.D;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        a(c(), b(), this.f28221d);
        this.I.setVisibility(0);
        this.f28224g.setVisibility(8);
        this.f28225h.setVisibility(8);
    }

    private void e() {
        if (g.f27551a != null && this.x != null && !TextUtils.isEmpty(g.f27551a.getCoachNumberMessage())) {
            ResourceUtils.loadTrainImagesFromCDN(this.y, "speaker_icon.png", false, false, n.a.V1);
            this.x.setText(g.f27551a.getCoachNumberMessage());
        }
    }

    private void f() {
        this.p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    s.this.r.setTextColor(s.this.O.getResources().getColor(R.color.color_222222));
                } else {
                    s.this.r.setTextColor(s.this.O.getResources().getColor(R.color.color_666666));
                }
                s sVar = s.this;
                sVar.a("train_traveller_details_auto_upgradation_clicked", sVar.h());
            }
        });
        this.u.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    s.this.v.setVisibility(0);
                    s.this.C.setVisibility(0);
                    s.this.t.setTextColor(s.this.O.getResources().getColor(R.color.color_222222));
                } else {
                    s.this.v.setVisibility(8);
                    s.this.C.setVisibility(8);
                    s.this.B.setVisibility(8);
                    s.this.t.setTextColor(s.this.O.getResources().getColor(R.color.color_666666));
                }
                s sVar = s.this;
                sVar.a("train_traveller_details_additional_preference_clicked", sVar.h());
            }
        });
        this.f28219b.f49690a = new CJRFloatingLabel.c() {
            public final void a(CharSequence charSequence) {
                if (charSequence.toString().length() > 0) {
                    s.this.w.setVisibility(0);
                    if (charSequence.toString().length() >= 2 && s.this.R == 2) {
                        s.p(s.this);
                        s.c(s.this, net.one97.paytm.common.utility.d.dn);
                    }
                    s.a(s.this, Boolean.TRUE);
                    return;
                }
                s.this.w.setVisibility(8);
                s.a(s.this, Boolean.FALSE);
            }
        };
        this.f28219b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (!z) {
                    o.a((Activity) s.this.O);
                }
            }
        });
    }

    private void g() {
        CJRTrainAvailability cJRTrainAvailability = this.f28220c.getmTrainAvailability().get(this.f28220c.getMiSelectedPosition());
        String str = (String) cJRTrainAvailability.getTypeMap().entrySet().iterator().next().getValue();
        if ("3".equalsIgnoreCase(str) || "2".equalsIgnoreCase(str)) {
            this.q.setVisibility(0);
            this.s.setVisibility(8);
        } else if (!"1".equalsIgnoreCase(str) || !cJRTrainAvailability.getmSttaus().contains("CURR_AVBL")) {
            this.q.setVisibility(0);
            this.s.setVisibility(0);
        } else {
            this.q.setVisibility(8);
            this.s.setVisibility(0);
        }
    }

    public final void a(boolean z2, String str, String str2) {
        CheckBox checkBox = this.p;
        if (checkBox != null) {
            if (z2) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }
        }
        if (this.f28219b != null) {
            if (TextUtils.isEmpty(str)) {
                this.u.setChecked(false);
                this.f28219b.setText((CharSequence) "");
            } else {
                this.u.setChecked(true);
                this.f28219b.setText((CharSequence) str);
            }
        }
        if (!TextUtils.isEmpty(str2) && this.l != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.l.getChildCount()) {
                    break;
                }
                RadioButton radioButton = (RadioButton) this.l.getChildAt(i2);
                if (!TextUtils.isEmpty(radioButton.getText()) && radioButton.getText().toString().equalsIgnoreCase(str2)) {
                    radioButton.setChecked(true);
                    break;
                }
                i2++;
            }
        }
        if (this.T) {
            if (z2) {
                this.J.setVisibility(0);
            } else {
                this.J.setVisibility(8);
            }
            if (TextUtils.isEmpty(str)) {
                this.K.setVisibility(8);
                this.L.setText("");
            } else {
                this.K.setVisibility(0);
                this.L.setText(str);
            }
            if (TextUtils.isEmpty(str2)) {
                this.M.setVisibility(8);
                this.N.setText("");
                return;
            }
            this.M.setVisibility(0);
            this.N.setText(str2);
        }
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.lv_additional_pref_title_container) {
            if (this.A.getVisibility() == 0) {
                a(false);
            } else {
                a(true);
            }
            a("train_traveller_details_additional_preference_clicked", h());
        } else if (id == R.id.iv_berth_info_icon) {
            com.travel.train.fragment.n a2 = com.travel.train.fragment.n.a(new Bundle());
            a2.setCancelable(true);
            a2.show(((AppCompatActivity) this.O).getSupportFragmentManager(), "dialog");
        } else if (id == R.id.tv_filled_edit || id == R.id.tv_hide_coach || id == R.id.tv_hide_berth) {
            a();
        }
    }

    private void a(boolean z2) {
        if (z2) {
            this.A.setVisibility(0);
            this.o.setImageDrawable(this.O.getResources().getDrawable(R.drawable.pre_t_drop_up));
            return;
        }
        this.A.setVisibility(8);
        this.o.setImageDrawable(this.O.getResources().getDrawable(R.drawable.pre_t_drop));
    }

    public final void a() {
        if (this.I.getVisibility() == 0) {
            a(false, true);
        } else {
            a(true, true);
        }
    }

    public final String b() {
        CheckBox checkBox = this.u;
        if (checkBox != null) {
            if (checkBox.isChecked() && this.f28219b.getText().length() > 0) {
                return this.f28219b.getText().toString();
            }
            this.u.setChecked(false);
        }
        return "";
    }

    public final boolean c() {
        CheckBox checkBox = this.p;
        if (checkBox != null) {
            return checkBox.isChecked();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public String h() {
        return b.n(this.O) != null ? b.n(this.O) : "";
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("train_user_id", str2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.common.utility.d.u);
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, this.O);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public final void a(CJRTrainDetailsBody cJRTrainDetailsBody) {
        if (this.f28218a.getVisibility() == 0) {
            cJRTrainDetailsBody.setAutoUpgrade(c());
            cJRTrainDetailsBody.setCoachNumber(b());
            cJRTrainDetailsBody.setmReservationChoice(this.f28221d);
            cJRTrainDetailsBody.setReservationCode(this.f28222e);
        }
    }

    static /* synthetic */ void c(s sVar, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", b.n(sVar.O) != null ? b.n(sVar.O) : "");
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/traveller-details");
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, sVar.O);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    static /* synthetic */ void a(s sVar, Boolean bool) {
        if (sVar.B == null) {
            return;
        }
        if (bool.booleanValue()) {
            sVar.B.setVisibility(0);
        } else {
            sVar.B.setVisibility(8);
        }
    }
}
