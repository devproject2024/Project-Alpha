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

public final class l extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    e f28149a;

    /* renamed from: b  reason: collision with root package name */
    boolean f28150b = true;

    /* renamed from: c  reason: collision with root package name */
    public double f28151c = 0.0d;

    /* renamed from: d  reason: collision with root package name */
    TextView f28152d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f28153e;

    /* renamed from: f  reason: collision with root package name */
    private Context f28154f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f28155g;

    /* renamed from: h  reason: collision with root package name */
    private SwitchCompat f28156h;

    public l(View view, e eVar) {
        super(view);
        this.f28154f = view.getContext();
        this.f28149a = eVar;
        this.f28156h = (SwitchCompat) view.findViewById(R.id.serviceChargeSwitch);
        this.f28152d = (TextView) view.findViewById(R.id.serviceChargeTxt);
        this.f28155g = (RelativeLayout) view.findViewById(R.id.serviceChargeLyt);
        if (g.f27551a != null) {
            this.f28150b = g.f27551a.isOldFareBreakupEnabled();
        }
    }

    public final void a(final ArrayList<CJRTrainFareDetail> arrayList) {
        CJRTrainConfirmation cJRTrainConfirmation = this.f28149a.d().getmConfirmation();
        if (cJRTrainConfirmation.getOptOutServiceCharges() != null) {
            this.f28155g.setVisibility(0);
            if (cJRTrainConfirmation.getOptOutServiceCharges() == null || !Boolean.TRUE.equals(cJRTrainConfirmation.getOptOutServiceCharges().isWaiveOffConfigered())) {
                if (cJRTrainConfirmation.getOptOutServiceCharges() == null || !cJRTrainConfirmation.getOptOutServiceCharges().isDefaultSwitch()) {
                    a(false, cJRTrainConfirmation.getOptOutServiceCharges().getCheckBoxOffText() + " " + o.a(cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey(), cJRTrainConfirmation));
                } else {
                    a(true, cJRTrainConfirmation.getOptOutServiceCharges().getCheckBoxOnText() + " " + o.a(cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey(), cJRTrainConfirmation));
                }
            } else if (cJRTrainConfirmation.getOptOutServiceCharges().isDefaultWaiveOffSwitch()) {
                a(true, cJRTrainConfirmation.getOptOutServiceCharges().getCheckBoxOnWaiveOffText() + " " + o.a(cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey(), cJRTrainConfirmation));
            } else {
                a(false, cJRTrainConfirmation.getOptOutServiceCharges().getCheckBoxOffWaiveOffText() + " " + o.a(cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey(), cJRTrainConfirmation));
            }
            if (this.f28150b) {
                this.f28149a.a(cJRTrainConfirmation);
            } else {
                Iterator<CJRTrainFareDetail> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJRTrainFareDetail next = it2.next();
                    if (next.getKey() == cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey().intValue()) {
                        a(next, (CJRTrainFareDetail) null);
                    } else if (next.getChildList() != null && next.getChildList().size() > 0) {
                        for (int i2 = 0; i2 < next.getChildList().size(); i2++) {
                            CJRTrainFareDetail cJRTrainFareDetail = next.getChildList().get(i2);
                            if (cJRTrainFareDetail.getKey() == cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey().intValue()) {
                                a(cJRTrainFareDetail, next);
                            }
                        }
                    }
                }
                e eVar = this.f28149a;
                eVar.a(eVar.k());
            }
        } else {
            this.f28155g.setVisibility(8);
        }
        this.f28156h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                String str;
                CJRTrainConfirmation cJRTrainConfirmation = l.this.f28149a.d().getmConfirmation();
                if (z) {
                    cJRTrainConfirmation.setServiceChargeEnabled(true);
                    l.this.f28153e = Boolean.TRUE;
                } else {
                    cJRTrainConfirmation.setServiceChargeEnabled(false);
                    l.this.f28153e = Boolean.FALSE;
                }
                if (Boolean.TRUE.equals(cJRTrainConfirmation.getOptOutServiceCharges().isWaiveOffConfigered())) {
                    if (z) {
                        str = cJRTrainConfirmation.getOptOutServiceCharges().getCheckBoxOnWaiveOffText() + " " + o.a(cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey(), cJRTrainConfirmation);
                    } else {
                        str = cJRTrainConfirmation.getOptOutServiceCharges().getCheckBoxOffWaiveOffText() + " " + o.a(cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey(), cJRTrainConfirmation);
                    }
                } else if (z) {
                    str = cJRTrainConfirmation.getOptOutServiceCharges().getCheckBoxOnText() + " " + o.a(cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey(), cJRTrainConfirmation);
                } else {
                    str = cJRTrainConfirmation.getOptOutServiceCharges().getCheckBoxOffText() + " " + o.a(cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey(), cJRTrainConfirmation);
                }
                l.this.f28152d.setText(str);
                if (l.this.f28150b) {
                    l.this.f28149a.a(cJRTrainConfirmation);
                    return;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJRTrainFareDetail cJRTrainFareDetail = (CJRTrainFareDetail) it2.next();
                    if (cJRTrainFareDetail.getKey() == cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey().intValue()) {
                        l.this.a(cJRTrainFareDetail, (CJRTrainFareDetail) null);
                    } else if (cJRTrainFareDetail.getChildList() != null && cJRTrainFareDetail.getChildList().size() > 0) {
                        for (int i2 = 0; i2 < cJRTrainFareDetail.getChildList().size(); i2++) {
                            CJRTrainFareDetail cJRTrainFareDetail2 = cJRTrainFareDetail.getChildList().get(i2);
                            if (cJRTrainFareDetail2.getKey() == cJRTrainConfirmation.getOptOutServiceCharges().getToggleKey().intValue()) {
                                l.this.a(cJRTrainFareDetail2, cJRTrainFareDetail);
                            }
                        }
                    }
                }
                l.this.f28149a.a(l.this.f28149a.k());
            }
        });
        Boolean bool = this.f28153e;
        if (bool != null) {
            this.f28156h.setChecked(bool.booleanValue());
        }
    }

    private void a(boolean z, String str) {
        if (this.f28153e == null) {
            this.f28156h.setChecked(z);
            this.f28149a.d().getmConfirmation().setServiceChargeEnabled(z);
        } else {
            this.f28149a.d().getmConfirmation().setServiceChargeEnabled(this.f28153e.booleanValue());
        }
        this.f28152d.setText(str);
    }

    /* access modifiers changed from: private */
    public void a(CJRTrainFareDetail cJRTrainFareDetail, CJRTrainFareDetail cJRTrainFareDetail2) {
        for (CJRTrainValue next : cJRTrainFareDetail.getValue()) {
            if (next.isAmount()) {
                this.f28151c = Double.valueOf(next.getText()).doubleValue();
                e eVar = this.f28149a;
                eVar.b(Double.valueOf(eVar.a(eVar.k().doubleValue(), this.f28149a.l().doubleValue())));
                if (cJRTrainFareDetail2 != null) {
                    double a2 = this.f28149a.a(0.0d, Double.valueOf(o.b(cJRTrainFareDetail2.getValue())).doubleValue());
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
