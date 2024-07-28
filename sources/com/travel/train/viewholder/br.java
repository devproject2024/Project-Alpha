package com.travel.train.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.i.ab;
import com.travel.train.i.ah;
import com.travel.train.model.trainticket.CJRTrainOrderPaxInfo;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryAction;
import com.travel.train.widget.TrainRatingProgress;
import com.travel.train.widget.a;

public final class br {
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private TrainRatingProgress E;
    private String F = "CJRTravellerItemViewHolder";

    /* renamed from: a  reason: collision with root package name */
    ab f28051a;

    /* renamed from: b  reason: collision with root package name */
    public View f28052b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f28053c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f28054d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f28055e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f28056f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f28057g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f28058h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f28059i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private ImageView x;
    private ImageView y;
    private LinearLayout z;

    public br(View view, ab abVar) {
        this.f28051a = abVar;
        this.f28053c = (ImageView) view.findViewById(R.id.traveller_icon);
        this.f28059i = (TextView) view.findViewById(R.id.traveller_title);
        this.j = (TextView) view.findViewById(R.id.traveller_sub_title);
        this.f28052b = view.findViewById(R.id.separator_view);
        this.f28054d = (TextView) view.findViewById(R.id.ticket_status_key_text);
        this.f28055e = (TextView) view.findViewById(R.id.ticket_status_key1_text);
        this.f28056f = (TextView) view.findViewById(R.id.coach_key_text);
        this.f28057g = (TextView) view.findViewById(R.id.berth_key_text);
        this.f28058h = (TextView) view.findViewById(R.id.berth_type_key_text);
        this.u = (TextView) view.findViewById(R.id.senior_citizen_text);
        this.v = (TextView) view.findViewById(R.id.note_text);
        this.w = (TextView) view.findViewById(R.id.cancel_ticket_txt);
        this.x = (ImageView) view.findViewById(R.id.note_icon);
        this.y = (ImageView) view.findViewById(R.id.senior_dot);
        this.k = (TextView) view.findViewById(R.id.ticket_status_text);
        this.l = (TextView) view.findViewById(R.id.ticket_status1_text);
        this.m = (TextView) view.findViewById(R.id.previous_status_text);
        this.n = (TextView) view.findViewById(R.id.coach_text);
        this.o = (TextView) view.findViewById(R.id.berth_text);
        this.p = (TextView) view.findViewById(R.id.berth_type_text);
        this.s = (TextView) view.findViewById(R.id.prediction_key_text);
        this.t = (TextView) view.findViewById(R.id.prediction_key_value_text);
        this.r = (TextView) view.findViewById(R.id.prediction_value_text);
        this.q = (TextView) view.findViewById(R.id.refunded_text);
        this.z = (LinearLayout) view.findViewById(R.id.cancel_ticket_lyt);
        this.D = (LinearLayout) view.findViewById(R.id.place_holder_lyt);
        this.A = (LinearLayout) view.findViewById(R.id.prediction_lyt);
        this.B = (LinearLayout) view.findViewById(R.id.ticket_status_lyt_1);
        this.C = (LinearLayout) view.findViewById(R.id.ticket_status_lyt_2);
        this.E = (TrainRatingProgress) view.findViewById(R.id.prediction_value_bar_circular);
        this.E.setProgress(Float.valueOf(2.0f));
        this.E.setStrokeWidth(2);
    }

    public final void a(Context context, CJRTrainOrderPaxInfo cJRTrainOrderPaxInfo) {
        int i2;
        if (cJRTrainOrderPaxInfo != null) {
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getPassengerIcon())) {
                b.a.C0750a a2 = b.a(context);
                a2.f43753a = cJRTrainOrderPaxInfo.getPassengerIcon();
                b.a.C0750a.a(a2, this.f28053c, (com.paytm.utility.b.b.b) null, 2);
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getPassengerName())) {
                this.f28059i.setText(cJRTrainOrderPaxInfo.getPassengerName());
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getSeniorCitizenText())) {
                this.u.setVisibility(0);
                this.y.setVisibility(0);
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getPassengerAge()) && !TextUtils.isEmpty(cJRTrainOrderPaxInfo.getPassengerGender())) {
                TextView textView = this.j;
                textView.setText(cJRTrainOrderPaxInfo.getPassengerGender() + ", " + cJRTrainOrderPaxInfo.getPassengerAge());
            }
            if (cJRTrainOrderPaxInfo.getItemStatus() != null) {
                if (cJRTrainOrderPaxInfo.getItemStatus().getStatus() == 7) {
                    if (cJRTrainOrderPaxInfo.getIsConfirmed()) {
                        this.B.setVisibility(0);
                    } else {
                        this.C.setVisibility(0);
                        if (cJRTrainOrderPaxInfo.getPrediction() != null && cJRTrainOrderPaxInfo.getPrediction().getEnabled()) {
                            String textKey = cJRTrainOrderPaxInfo.getPrediction().getTextKey();
                            String textValue = cJRTrainOrderPaxInfo.getPrediction().getTextValue();
                            String value = cJRTrainOrderPaxInfo.getPrediction().getValue();
                            String colour = cJRTrainOrderPaxInfo.getPrediction().getColour();
                            if (value != null) {
                                this.A.setVisibility(0);
                                if (textKey != null) {
                                    this.s.setText(textKey);
                                }
                                if (textValue != null) {
                                    this.t.setText(textValue);
                                }
                                TextView textView2 = this.r;
                                textView2.setText(value + "%");
                                try {
                                    this.E.setPrimaryProgressColor(b(a(colour)));
                                    a aVar = new a(this.E, (Float.valueOf(value).floatValue() * 5.0f) / 100.0f);
                                    aVar.setDuration(1000);
                                    this.E.startAnimation(aVar);
                                } catch (NumberFormatException e2) {
                                    q.c(e2.getMessage());
                                }
                            }
                        }
                    }
                    if (cJRTrainOrderPaxInfo.getItemActions() != null && cJRTrainOrderPaxInfo.getItemActions().size() > 0) {
                        for (int i3 = 0; i3 < cJRTrainOrderPaxInfo.getItemActions().size(); i3++) {
                            final CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction = cJRTrainOrderPaxInfo.getItemActions().get(i3);
                            this.z.setVisibility(0);
                            this.w.setText(cJRTrainOrderSummaryAction.getLabel());
                            this.z.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    br.this.f28051a.a(cJRTrainOrderSummaryAction, ah.CANCEL_TICKET);
                                }
                            });
                        }
                    }
                } else if (cJRTrainOrderPaxInfo.getItemStatus().getStatus() == 18) {
                    this.q.setVisibility(0);
                    this.q.setText(cJRTrainOrderPaxInfo.getItemStatus().getStatusText());
                    if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getItemStatus().getColour())) {
                        TextView textView3 = this.q;
                        String a3 = a(cJRTrainOrderPaxInfo.getItemStatus().getColour());
                        textView3.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.pre_t_train_rounded_rect_border_green));
                        GradientDrawable gradientDrawable = (GradientDrawable) textView3.getBackground();
                        if (a3.length() > 1 && a3.charAt(0) != '#') {
                            a3 = "#".concat(String.valueOf(a3));
                        }
                        try {
                            i2 = Color.parseColor(a3);
                        } catch (Exception | IllegalArgumentException unused) {
                            i2 = 0;
                        }
                        gradientDrawable.setColor(0);
                        gradientDrawable.setStroke((int) context.getResources().getDimension(R.dimen.dimen_1dp), i2);
                        textView3.setTextColor(i2);
                    }
                }
            }
            if (cJRTrainOrderPaxInfo.getTextHolder() != null && !TextUtils.isEmpty(cJRTrainOrderPaxInfo.getTextHolder().getText())) {
                this.D.setVisibility(0);
                this.v.setText(cJRTrainOrderPaxInfo.getTextHolder().getText());
                this.v.setVisibility(0);
                if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getTextHolder().getIcon())) {
                    this.x.setVisibility(0);
                    b.a.C0750a a4 = b.a(context);
                    a4.f43753a = cJRTrainOrderPaxInfo.getTextHolder().getIcon();
                    a4.a(this.x);
                }
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getTicketStatusKey())) {
                this.f28054d.setText(cJRTrainOrderPaxInfo.getTicketStatusKey());
                this.f28055e.setText(cJRTrainOrderPaxInfo.getTicketStatusKey());
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getTicketStatusValue1())) {
                this.k.setText(cJRTrainOrderPaxInfo.getTicketStatusValue1());
                this.l.setText(cJRTrainOrderPaxInfo.getTicketStatusValue1());
                if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getTicketStatusValue2())) {
                    this.m.setText(cJRTrainOrderPaxInfo.getTicketStatusValue2());
                }
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getCoachKey())) {
                this.f28056f.setText(cJRTrainOrderPaxInfo.getCoachKey());
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getCoachValue())) {
                this.n.setText(cJRTrainOrderPaxInfo.getCoachValue());
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getBerthKey())) {
                this.f28057g.setText(cJRTrainOrderPaxInfo.getBerthKey());
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getBerthValue())) {
                this.o.setText(cJRTrainOrderPaxInfo.getBerthValue());
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getBerthTypeKey())) {
                this.f28058h.setText(cJRTrainOrderPaxInfo.getBerthTypeKey());
            }
            if (!TextUtils.isEmpty(cJRTrainOrderPaxInfo.getBerthTypeValue())) {
                this.p.setText(cJRTrainOrderPaxInfo.getBerthTypeValue());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r4) {
        /*
            java.lang.String r4 = r4.toLowerCase()
            int r0 = r4.hashCode()
            r1 = -1008851410(0xffffffffc3de262e, float:-444.29828)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002e
            r1 = 112785(0x1b891, float:1.58045E-40)
            if (r0 == r1) goto L_0x0024
            r1 = 98619139(0x5e0cf03, float:2.1140903E-35)
            if (r0 == r1) goto L_0x001a
            goto L_0x0038
        L_0x001a:
            java.lang.String r0 = "green"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0038
            r4 = 1
            goto L_0x0039
        L_0x0024:
            java.lang.String r0 = "red"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0038
            r4 = 0
            goto L_0x0039
        L_0x002e:
            java.lang.String r0 = "orange"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0038
            r4 = 2
            goto L_0x0039
        L_0x0038:
            r4 = -1
        L_0x0039:
            java.lang.String r0 = "#FFA500"
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            goto L_0x0045
        L_0x0040:
            java.lang.String r0 = "#21C17A"
            goto L_0x0045
        L_0x0043:
            java.lang.String r0 = "#FD5C5C"
        L_0x0045:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.viewholder.br.a(java.lang.String):java.lang.String");
    }

    private static int b(String str) {
        if (!(str == null || str.length() <= 1 || str.charAt(0) == '#')) {
            str = "#".concat(String.valueOf(str));
        }
        try {
            return Color.parseColor(str);
        } catch (Exception | IllegalArgumentException unused) {
            return 0;
        }
    }
}
