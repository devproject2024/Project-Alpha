package com.travel.flight.flightorder.j;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.travel.flight.R;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.f.a;
import com.travel.flight.pojo.flightticket.CJRNPSCaptureDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    com.travel.flight.flightorder.g.a f24444a;

    /* renamed from: b  reason: collision with root package name */
    RadioButton f24445b;

    /* renamed from: c  reason: collision with root package name */
    RadioButton f24446c;

    /* renamed from: d  reason: collision with root package name */
    RadioButton f24447d;

    /* renamed from: e  reason: collision with root package name */
    RadioButton f24448e;

    /* renamed from: f  reason: collision with root package name */
    RadioButton f24449f;

    /* renamed from: g  reason: collision with root package name */
    RadioButton f24450g;

    /* renamed from: h  reason: collision with root package name */
    RadioButton f24451h;

    /* renamed from: i  reason: collision with root package name */
    RadioButton f24452i;
    RadioButton j;
    RadioButton k;
    RadioButton l;
    CJRNPSCaptureDataModel m;
    RadioButton n;
    private Context o;
    private RadioGroup p;
    private Button q;

    public final void a(b.C0467b bVar) {
    }

    public c(Context context, View view, com.travel.flight.flightorder.g.a aVar, CJRNPSCaptureDataModel cJRNPSCaptureDataModel) {
        super(view);
        this.o = context;
        this.m = cJRNPSCaptureDataModel;
        this.f24444a = aVar;
        this.p = (RadioGroup) view.findViewById(R.id.nps_radiogroup);
        this.f24445b = (RadioButton) view.findViewById(R.id.rating_value_0);
        this.f24446c = (RadioButton) view.findViewById(R.id.rating_value_1);
        this.f24447d = (RadioButton) view.findViewById(R.id.rating_value_2);
        this.f24448e = (RadioButton) view.findViewById(R.id.rating_value_3);
        this.f24449f = (RadioButton) view.findViewById(R.id.rating_value_4);
        this.f24450g = (RadioButton) view.findViewById(R.id.rating_value_5);
        this.f24451h = (RadioButton) view.findViewById(R.id.rating_value_6);
        this.f24452i = (RadioButton) view.findViewById(R.id.rating_value_7);
        this.j = (RadioButton) view.findViewById(R.id.rating_value_8);
        this.k = (RadioButton) view.findViewById(R.id.rating_value_9);
        this.l = (RadioButton) view.findViewById(R.id.rating_value_10);
        this.q = (Button) view.findViewById(R.id.submit_recommendation);
        this.f24445b.setTag("0");
        this.f24446c.setTag("1");
        this.f24447d.setTag("2");
        this.f24448e.setTag("3");
        this.f24449f.setTag("4");
        this.f24450g.setTag("5");
        this.f24451h.setTag("6");
        this.f24452i.setTag("7");
        this.j.setTag("8");
        this.k.setTag("9");
        this.l.setTag("10");
        this.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (c.this.n != null) {
                    c cVar = c.this;
                    int parseInt = Integer.parseInt(cVar.n.getTag().toString());
                    if (cVar.m != null) {
                        CJRNPSCaptureDataModel.a a2 = new CJRNPSCaptureDataModel.a().a(cVar.m.getItemIds()).a(cVar.m.getOrderId());
                        int unused = a2.f25438a.response = parseInt;
                        cVar.f24444a.a(com.travel.flight.flightorder.c.a.SUMMARY_REVIEW_AND_RATINGS, (IJRDataModel) a2.f25438a);
                    }
                }
            }
        });
        this.f24445b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.f24445b;
                c.this.f24445b.setChecked(true);
                c.this.f24446c.setChecked(false);
                c.this.f24447d.setChecked(false);
                c.this.f24448e.setChecked(false);
                c.this.f24449f.setChecked(false);
                c.this.f24450g.setChecked(false);
                c.this.f24451h.setChecked(false);
                c.this.f24452i.setChecked(false);
                c.this.j.setChecked(false);
                c.this.k.setChecked(false);
                c.this.l.setChecked(false);
            }
        });
        this.f24446c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.f24446c;
                c.this.f24446c.setChecked(true);
                c.this.f24445b.setChecked(false);
                c.this.f24447d.setChecked(false);
                c.this.f24448e.setChecked(false);
                c.this.f24449f.setChecked(false);
                c.this.f24450g.setChecked(false);
                c.this.f24451h.setChecked(false);
                c.this.f24452i.setChecked(false);
                c.this.j.setChecked(false);
                c.this.k.setChecked(false);
                c.this.l.setChecked(false);
            }
        });
        this.f24447d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.f24447d;
                c.this.f24447d.setChecked(true);
                c.this.f24446c.setChecked(false);
                c.this.f24445b.setChecked(false);
                c.this.f24448e.setChecked(false);
                c.this.f24449f.setChecked(false);
                c.this.f24450g.setChecked(false);
                c.this.f24451h.setChecked(false);
                c.this.f24452i.setChecked(false);
                c.this.j.setChecked(false);
                c.this.k.setChecked(false);
                c.this.l.setChecked(false);
            }
        });
        this.f24448e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.f24448e;
                c.this.f24448e.setChecked(true);
                c.this.f24446c.setChecked(false);
                c.this.f24447d.setChecked(false);
                c.this.f24445b.setChecked(false);
                c.this.f24449f.setChecked(false);
                c.this.f24450g.setChecked(false);
                c.this.f24451h.setChecked(false);
                c.this.f24452i.setChecked(false);
                c.this.j.setChecked(false);
                c.this.k.setChecked(false);
                c.this.l.setChecked(false);
            }
        });
        this.f24449f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.f24449f;
                c.this.f24449f.setChecked(true);
                c.this.f24446c.setChecked(false);
                c.this.f24447d.setChecked(false);
                c.this.f24448e.setChecked(false);
                c.this.f24445b.setChecked(false);
                c.this.f24450g.setChecked(false);
                c.this.f24451h.setChecked(false);
                c.this.f24452i.setChecked(false);
                c.this.j.setChecked(false);
                c.this.k.setChecked(false);
                c.this.l.setChecked(false);
            }
        });
        this.f24450g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.f24450g;
                c.this.f24450g.setChecked(true);
                c.this.f24446c.setChecked(false);
                c.this.f24447d.setChecked(false);
                c.this.f24448e.setChecked(false);
                c.this.f24449f.setChecked(false);
                c.this.f24445b.setChecked(false);
                c.this.f24451h.setChecked(false);
                c.this.f24452i.setChecked(false);
                c.this.j.setChecked(false);
                c.this.k.setChecked(false);
                c.this.l.setChecked(false);
            }
        });
        this.f24451h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.f24451h;
                c.this.f24451h.setChecked(true);
                c.this.f24446c.setChecked(false);
                c.this.f24447d.setChecked(false);
                c.this.f24448e.setChecked(false);
                c.this.f24449f.setChecked(false);
                c.this.f24450g.setChecked(false);
                c.this.f24445b.setChecked(false);
                c.this.f24452i.setChecked(false);
                c.this.j.setChecked(false);
                c.this.k.setChecked(false);
                c.this.l.setChecked(false);
            }
        });
        this.f24452i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.f24452i;
                c.this.f24452i.setChecked(true);
                c.this.f24446c.setChecked(false);
                c.this.f24447d.setChecked(false);
                c.this.f24448e.setChecked(false);
                c.this.f24449f.setChecked(false);
                c.this.f24450g.setChecked(false);
                c.this.f24451h.setChecked(false);
                c.this.f24445b.setChecked(false);
                c.this.j.setChecked(false);
                c.this.k.setChecked(false);
                c.this.l.setChecked(false);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.j;
                c.this.j.setChecked(true);
                c.this.f24446c.setChecked(false);
                c.this.f24447d.setChecked(false);
                c.this.f24448e.setChecked(false);
                c.this.f24449f.setChecked(false);
                c.this.f24450g.setChecked(false);
                c.this.f24451h.setChecked(false);
                c.this.f24452i.setChecked(false);
                c.this.f24445b.setChecked(false);
                c.this.k.setChecked(false);
                c.this.l.setChecked(false);
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.k;
                c.this.k.setChecked(true);
                c.this.f24446c.setChecked(false);
                c.this.f24447d.setChecked(false);
                c.this.f24448e.setChecked(false);
                c.this.f24449f.setChecked(false);
                c.this.f24450g.setChecked(false);
                c.this.f24451h.setChecked(false);
                c.this.f24452i.setChecked(false);
                c.this.j.setChecked(false);
                c.this.f24445b.setChecked(false);
                c.this.l.setChecked(false);
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                c cVar = c.this;
                cVar.n = cVar.l;
                c.this.l.setChecked(true);
                c.this.f24446c.setChecked(false);
                c.this.f24447d.setChecked(false);
                c.this.f24448e.setChecked(false);
                c.this.f24449f.setChecked(false);
                c.this.f24450g.setChecked(false);
                c.this.f24451h.setChecked(false);
                c.this.f24452i.setChecked(false);
                c.this.j.setChecked(false);
                c.this.k.setChecked(false);
                c.this.f24445b.setChecked(false);
            }
        });
    }
}
