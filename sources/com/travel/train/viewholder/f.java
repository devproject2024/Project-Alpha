package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.e;
import com.travel.train.j.g;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainConfirmation;
import com.travel.train.model.trainticket.CJRTrainFareDetail;
import com.travel.train.model.trainticket.CJRTrainValue;
import java.util.ArrayList;
import java.util.Iterator;

public final class f extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    e f28086a;

    /* renamed from: b  reason: collision with root package name */
    public double f28087b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    boolean f28088c = true;

    /* renamed from: d  reason: collision with root package name */
    TextView f28089d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f28090e;

    /* renamed from: f  reason: collision with root package name */
    private Context f28091f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f28092g;

    /* renamed from: h  reason: collision with root package name */
    private SwitchCompat f28093h;

    public f(View view, e eVar) {
        super(view);
        this.f28091f = view.getContext();
        this.f28086a = eVar;
        this.f28093h = (SwitchCompat) view.findViewById(R.id.gatewayChargeSwitch);
        this.f28089d = (TextView) view.findViewById(R.id.gatewayChargeTxt);
        this.f28092g = (RelativeLayout) view.findViewById(R.id.gatewayChargeLyt);
        if (g.f27551a != null) {
            this.f28088c = g.f27551a.isOldFareBreakupEnabled();
        }
    }

    public final void a(final ArrayList<CJRTrainFareDetail> arrayList) {
        CJRTrainConfirmation cJRTrainConfirmation = this.f28086a.d().getmConfirmation();
        if (cJRTrainConfirmation.getOptOutPGCharges() != null) {
            this.f28092g.setVisibility(0);
            if (Boolean.TRUE.equals(cJRTrainConfirmation.getOptOutPGCharges().isWaiveOffConfigered())) {
                if (cJRTrainConfirmation.getOptOutPGCharges().isDefaultWaiveOffSwitch()) {
                    a(true, cJRTrainConfirmation.getOptOutPGCharges().getCheckBoxOnWaiveOffText() + " " + o.a(cJRTrainConfirmation.getOptOutPGCharges().getToggleKey(), cJRTrainConfirmation));
                } else {
                    a(false, cJRTrainConfirmation.getOptOutPGCharges().getCheckBoxOffWaiveOffText() + " " + o.a(cJRTrainConfirmation.getOptOutPGCharges().getToggleKey(), cJRTrainConfirmation));
                }
            } else if (cJRTrainConfirmation.getOptOutPGCharges().isDefaultSwitch()) {
                a(true, cJRTrainConfirmation.getOptOutPGCharges().getCheckBoxOnText() + " " + o.a(cJRTrainConfirmation.getOptOutPGCharges().getToggleKey(), cJRTrainConfirmation));
            } else {
                a(false, cJRTrainConfirmation.getOptOutPGCharges().getCheckBoxOffText() + " " + o.a(cJRTrainConfirmation.getOptOutPGCharges().getToggleKey(), cJRTrainConfirmation));
            }
            if (this.f28088c) {
                this.f28086a.a(cJRTrainConfirmation);
            } else {
                Iterator<CJRTrainFareDetail> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJRTrainFareDetail next = it2.next();
                    if (cJRTrainConfirmation.getOptOutPGCharges() != null && next.getKey() == cJRTrainConfirmation.getOptOutPGCharges().getToggleKey().intValue()) {
                        a(next, (CJRTrainFareDetail) null);
                    } else if (next.getChildList() != null && next.getChildList().size() > 0) {
                        for (int i2 = 0; i2 < next.getChildList().size(); i2++) {
                            CJRTrainFareDetail cJRTrainFareDetail = next.getChildList().get(i2);
                            if (cJRTrainConfirmation.getOptOutPGCharges() != null && cJRTrainFareDetail.getKey() == cJRTrainConfirmation.getOptOutPGCharges().getToggleKey().intValue()) {
                                a(cJRTrainFareDetail, next);
                            }
                        }
                    }
                }
                e eVar = this.f28086a;
                eVar.a(eVar.k());
            }
        } else {
            this.f28092g.setVisibility(8);
        }
        this.f28093h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                String str;
                CJRTrainConfirmation cJRTrainConfirmation = f.this.f28086a.d().getmConfirmation();
                if (z) {
                    cJRTrainConfirmation.setGatewayChargeEnabled(true);
                    f.this.f28090e = Boolean.TRUE;
                } else {
                    cJRTrainConfirmation.setGatewayChargeEnabled(false);
                    f.this.f28090e = Boolean.FALSE;
                }
                if (cJRTrainConfirmation.getOptOutPGCharges() == null || !Boolean.TRUE.equals(cJRTrainConfirmation.getOptOutPGCharges().isWaiveOffConfigered())) {
                    if (z) {
                        str = cJRTrainConfirmation.getOptOutPGCharges().getCheckBoxOnText() + " " + o.a(cJRTrainConfirmation.getOptOutPGCharges().getToggleKey(), cJRTrainConfirmation);
                    } else {
                        str = cJRTrainConfirmation.getOptOutPGCharges().getCheckBoxOffText() + " " + o.a(cJRTrainConfirmation.getOptOutPGCharges().getToggleKey(), cJRTrainConfirmation);
                    }
                } else if (z) {
                    str = cJRTrainConfirmation.getOptOutPGCharges().getCheckBoxOnWaiveOffText() + " " + o.a(cJRTrainConfirmation.getOptOutPGCharges().getToggleKey(), cJRTrainConfirmation);
                } else {
                    str = cJRTrainConfirmation.getOptOutPGCharges().getCheckBoxOffWaiveOffText() + " " + o.a(cJRTrainConfirmation.getOptOutPGCharges().getToggleKey(), cJRTrainConfirmation);
                }
                f.this.f28089d.setText(str);
                if (f.this.f28088c) {
                    f.this.f28086a.a(cJRTrainConfirmation);
                    return;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJRTrainFareDetail cJRTrainFareDetail = (CJRTrainFareDetail) it2.next();
                    if (cJRTrainConfirmation.getOptOutPGCharges() != null && cJRTrainFareDetail.getKey() == cJRTrainConfirmation.getOptOutPGCharges().getToggleKey().intValue()) {
                        f.this.a(cJRTrainFareDetail, (CJRTrainFareDetail) null);
                    } else if (cJRTrainFareDetail.getChildList() != null && cJRTrainFareDetail.getChildList().size() > 0) {
                        for (int i2 = 0; i2 < cJRTrainFareDetail.getChildList().size(); i2++) {
                            CJRTrainFareDetail cJRTrainFareDetail2 = cJRTrainFareDetail.getChildList().get(i2);
                            if (cJRTrainConfirmation.getOptOutPGCharges() != null && cJRTrainFareDetail2.getKey() == cJRTrainConfirmation.getOptOutPGCharges().getToggleKey().intValue()) {
                                f.this.a(cJRTrainFareDetail2, cJRTrainFareDetail);
                            }
                        }
                    }
                }
                f.this.f28086a.a(f.this.f28086a.k());
            }
        });
        Boolean bool = this.f28090e;
        if (bool != null) {
            this.f28093h.setChecked(bool.booleanValue());
        }
    }

    private void a(boolean z, String str) {
        if (this.f28090e == null) {
            this.f28093h.setChecked(z);
            this.f28086a.d().getmConfirmation().setGatewayChargeEnabled(z);
        } else {
            this.f28086a.d().getmConfirmation().setGatewayChargeEnabled(this.f28090e.booleanValue());
        }
        this.f28089d.setText(str);
    }

    /* access modifiers changed from: private */
    public void a(CJRTrainFareDetail cJRTrainFareDetail, CJRTrainFareDetail cJRTrainFareDetail2) {
        for (CJRTrainValue next : cJRTrainFareDetail.getValue()) {
            if (next.isAmount()) {
                this.f28087b = (double) Float.parseFloat(next.getText());
                e eVar = this.f28086a;
                eVar.b(Double.valueOf(eVar.a(eVar.k().doubleValue(), this.f28086a.l().doubleValue())));
                if (cJRTrainFareDetail2 != null) {
                    double a2 = this.f28086a.a(0.0d, Double.valueOf(o.b(cJRTrainFareDetail2.getValue())).doubleValue());
                    for (CJRTrainValue next2 : cJRTrainFareDetail2.getValue()) {
                        if (next2.isAmount()) {
                            next2.setText(String.valueOf(a2));
                        }
                    }
                }
            }
        }
    }
}
