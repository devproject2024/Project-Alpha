package com.travel.train.viewholder;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.travel.train.R;
import com.travel.train.b;
import com.travel.train.helper.i;
import com.travel.train.i.g;
import com.travel.train.j.o;
import com.travel.train.j.q;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.upi.common.upi.CommonPayParams;

public final class x extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    final RoboTextView f28279a;

    /* renamed from: b  reason: collision with root package name */
    Context f28280b;

    /* renamed from: c  reason: collision with root package name */
    CJRTrainSearchInput f28281c;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f28282d;

    /* renamed from: e  reason: collision with root package name */
    private final CheckBox f28283e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f28284f;

    /* renamed from: g  reason: collision with root package name */
    private g f28285g;

    /* renamed from: h  reason: collision with root package name */
    private i f28286h;

    /* renamed from: i  reason: collision with root package name */
    private CJRTrainDetailsBody f28287i;
    private String j;
    private String k;
    private boolean l;
    private boolean m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(View view, g gVar, i iVar, CJRTrainDetailsBody cJRTrainDetailsBody, boolean z, boolean z2, CJRTrainSearchInput cJRTrainSearchInput) {
        super(view);
        View view2 = view;
        this.f28280b = view.getContext();
        this.f28285g = gVar;
        this.f28286h = iVar;
        this.l = z;
        this.m = z2;
        this.f28287i = cJRTrainDetailsBody;
        this.f28281c = cJRTrainSearchInput;
        this.f28282d = (LinearLayout) view2.findViewById(R.id.relative_insurance_policy);
        this.f28283e = (CheckBox) view2.findViewById(R.id.check_insurancePolicy);
        this.f28279a = (RoboTextView) view2.findViewById(R.id.text_train_insurance_policy);
        this.f28284f = (RoboTextView) view2.findViewById(R.id.insurance_tc_txt);
        CJRTrainDetailsBody cJRTrainDetailsBody2 = this.f28287i;
        if (!(cJRTrainDetailsBody2 == null || cJRTrainDetailsBody2.getTrainConfig() == null)) {
            this.j = this.f28287i.getTrainConfig().getMtravelInsuranceFareMsg();
        }
        this.f28283e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    x.this.f28279a.setTextColor(x.this.f28280b.getResources().getColor(R.color.color_222222));
                } else {
                    x.this.f28279a.setTextColor(x.this.f28280b.getResources().getColor(R.color.color_666666));
                }
                o.a("train_traveller_details", x.this.f28281c.getmSourceCityName(), x.this.f28281c.getmDestCityName(), x.this.f28281c.getmDate(), (String) null, (String) null, (String) null, "insurance_check_box_clicked", "/trains/traveller-details", x.this.f28280b, (Map<String, Object>) null);
                HashMap hashMap = new HashMap();
                if (z) {
                    hashMap.put(d.dh, CommonPayParams.Builder.YES);
                } else {
                    hashMap.put(d.dh, CommonPayParams.Builder.NO);
                }
                o.a("train_traveller_details", x.this.f28281c.getmSourceCityName(), x.this.f28281c.getmDestCityName(), x.this.f28281c.getmDate(), (String) null, (String) null, (String) null, "free_travel_insurance_checked", "/trains/traveller-details", x.this.f28280b, hashMap);
            }
        });
        if (this.m) {
            this.f28282d.setVisibility(0);
            if (!TextUtils.isEmpty(this.j)) {
                this.f28279a.setText(this.j);
            }
            this.f28284f.setText(this.f28280b.getString(R.string.detail_t_c));
            new q((Activity) this.f28280b, this.f28284f, this.f28281c);
            if (this.l) {
                HashMap hashMap = new HashMap();
                hashMap.put(d.dh, CommonPayParams.Builder.YES);
                o.a("train_traveller_details", this.f28281c.getmSourceCityName(), this.f28281c.getmDestCityName(), this.f28281c.getmDate(), (String) null, (String) null, (String) null, "free_travel_insurance_checked", "/trains/traveller-details", this.f28280b, hashMap);
                this.f28283e.setChecked(true);
                this.f28283e.setEnabled(false);
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(d.dh, CommonPayParams.Builder.NO);
            o.a("train_traveller_details", this.f28281c.getmSourceCityName(), this.f28281c.getmDestCityName(), this.f28281c.getmDate(), (String) null, (String) null, (String) null, "free_travel_insurance_checked", "/trains/traveller-details", this.f28280b, hashMap2);
            b.a();
            if (b.b().w()) {
                this.f28283e.setChecked(true);
                this.f28283e.setEnabled(true);
                return;
            }
            this.f28283e.setChecked(false);
            this.f28283e.setEnabled(true);
            return;
        }
        this.f28282d.setVisibility(8);
    }

    public final String a() {
        if (!this.m) {
            this.k = "false";
        } else if (this.f28283e.isChecked()) {
            this.k = "true";
        } else {
            this.k = "false";
        }
        return this.k;
    }
}
