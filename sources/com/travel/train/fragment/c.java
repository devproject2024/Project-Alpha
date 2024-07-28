package com.travel.train.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.travel.train.R;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRTrainBooking;
import com.travel.train.model.trainticket.CJRTrainDisplayName;
import com.travel.train.model.trainticket.CJRTrainFareDetail;
import com.travel.train.model.trainticket.CJRTrainValue;
import java.util.ArrayList;
import java.util.List;

public class c extends am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f26921a = "Plain";

    /* renamed from: b  reason: collision with root package name */
    private String f26922b = "Heading";

    /* renamed from: c  reason: collision with root package name */
    private String f26923c = "Padded";

    /* renamed from: d  reason: collision with root package name */
    private String f26924d = "Left";

    /* renamed from: e  reason: collision with root package name */
    private View f26925e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f26926f;

    /* renamed from: g  reason: collision with root package name */
    private CJRTrainBooking f26927g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26928h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26929i;
    private boolean j;
    private ArrayList<CJRTrainFareDetail> k;
    private int l;
    private Double m;
    private TextView n;
    private ImageView o;
    private a p;
    private double q = 0.0d;
    private double r = 0.0d;
    private String s = "FJRFareDetailsFragment";

    public interface a {
        void a();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x05f3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x03ca  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x04a3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0509  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r23, android.view.ViewGroup r24, android.os.Bundle r25) {
        /*
            r22 = this;
            r1 = r22
            int r0 = com.travel.train.R.layout.pre_t_fragment_train_fare_detail
            r2 = 0
            r3 = r23
            r4 = r24
            android.view.View r0 = r3.inflate(r0, r4, r2)
            r1.f26925e = r0
            android.view.View r0 = r1.f26925e
            int r3 = com.travel.train.R.id.fare_details_container
            android.view.View r3 = r0.findViewById(r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r1.f26926f = r3
            int r3 = com.travel.train.R.id.fare_heading
            android.view.View r3 = r0.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r1.n = r3
            int r3 = com.travel.train.R.id.detail_close
            android.view.View r0 = r0.findViewById(r3)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.o = r0
            android.widget.ImageView r0 = r1.o
            r0.setOnClickListener(r1)
            android.os.Bundle r0 = r22.getArguments()
            if (r0 == 0) goto L_0x00c1
            java.lang.String r3 = "train_booking_details"
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x004b
            java.io.Serializable r3 = r0.getSerializable(r3)
            com.travel.train.model.trainticket.CJRTrainBooking r3 = (com.travel.train.model.trainticket.CJRTrainBooking) r3
            r1.f26927g = r3
        L_0x004b:
            java.lang.String r3 = "is_cancel_checked"
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x005f
            java.io.Serializable r3 = r0.getSerializable(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r1.f26929i = r3
        L_0x005f:
            java.lang.String r3 = "is_insurance_checked"
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0073
            java.io.Serializable r3 = r0.getSerializable(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r1.j = r3
        L_0x0073:
            java.lang.String r3 = "train_fare_details"
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0084
            java.io.Serializable r3 = r0.getSerializable(r3)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            r1.k = r3
        L_0x0084:
            java.lang.String r3 = "grand_total_key"
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x0092
            int r3 = r0.getInt(r3)
            r1.l = r3
        L_0x0092:
            java.lang.String r3 = "final_amount"
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x00a4
            double r3 = r0.getDouble(r3)
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            r1.m = r3
        L_0x00a4:
            java.lang.String r3 = "gate_way_charge"
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x00b2
            double r3 = r0.getDouble(r3)
            r1.q = r3
        L_0x00b2:
            java.lang.String r3 = "service_way_charge"
            boolean r4 = r0.containsKey(r3)
            if (r4 == 0) goto L_0x00c1
            double r3 = r0.getDouble(r3)
            r1.r = r3
        L_0x00c1:
            com.travel.train.model.trainticket.CJRTrainMessagingConfig r0 = com.travel.train.j.g.f27551a
            if (r0 == 0) goto L_0x00cd
            com.travel.train.model.trainticket.CJRTrainMessagingConfig r0 = com.travel.train.j.g.f27551a
            boolean r0 = r0.isOldFareBreakupEnabled()
            r1.f26928h = r0
        L_0x00cd:
            boolean r0 = r1.f26928h
            if (r0 == 0) goto L_0x0658
            com.travel.train.model.trainticket.CJRTrainBooking r0 = r1.f26927g
            if (r0 == 0) goto L_0x067c
            com.travel.train.model.trainticket.CJRTrainConfirmation r0 = r0.getmConfirmation()
            if (r0 == 0) goto L_0x067c
            com.travel.train.model.trainticket.CJRTrainBooking r0 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r0 = r0.getmConfirmation()
            com.travel.train.model.trainticket.CJRTrainDetailsBody r0 = r0.getmTrainDetails()
            if (r0 == 0) goto L_0x067c
            com.travel.train.model.trainticket.CJRTrainBooking r0 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r0 = r0.getmConfirmation()
            com.travel.train.model.trainticket.CJRTrainDetailsBody r3 = r0.getmTrainDetails()
            androidx.fragment.app.FragmentActivity r0 = r22.getActivity()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r4 = com.travel.train.R.layout.pre_t_old_fare_details_lyt
            r5 = 0
            android.view.View r4 = r0.inflate(r4, r5)
            int r0 = com.travel.train.R.id.review_iteneray_train_ticket_fare
            android.view.View r0 = r4.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r5 = com.travel.train.R.id.irctc_service_fee_container
            android.view.View r5 = r4.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            int r6 = com.travel.train.R.id.review_iteneray_train_irctc_service_fee
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r7 = com.travel.train.R.id.review_iteneray_train_irctc_service_fee_txt
            android.view.View r7 = r4.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r8 = com.travel.train.R.string.ri_irctc_service_fee
            java.lang.String r8 = r1.getString(r8)
            android.text.Spanned r8 = android.text.Html.fromHtml(r8)
            r7.setText(r8)
            int r7 = com.travel.train.R.id.rv_paytm_fee_container
            android.view.View r7 = r4.findViewById(r7)
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            int r8 = com.travel.train.R.id.review_iteneray_train_paytm_fee_txt
            android.view.View r8 = r4.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r9 = com.travel.train.R.string.ri_paytm_service_charges
            java.lang.String r9 = r1.getString(r9)
            android.text.Spanned r9 = android.text.Html.fromHtml(r9)
            r8.setText(r9)
            int r8 = com.travel.train.R.id.review_iteneray_train_paytm_fee
            android.view.View r8 = r4.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            int r9 = com.travel.train.R.id.cancel_protection_fare_container
            android.view.View r9 = r4.findViewById(r9)
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            int r10 = com.travel.train.R.id.cancellation_protection_fee
            android.view.View r10 = r4.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r11 = com.travel.train.R.id.rv_pg_gateway_container
            android.view.View r11 = r4.findViewById(r11)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            int r12 = com.travel.train.R.id.pg_charges_txt
            android.view.View r12 = r4.findViewById(r12)
            com.paytm.utility.RoboTextView r12 = (com.paytm.utility.RoboTextView) r12
            int r13 = com.travel.train.R.id.grand_total_txt
            android.view.View r13 = r4.findViewById(r13)
            com.paytm.utility.RoboTextView r13 = (com.paytm.utility.RoboTextView) r13
            int r14 = com.travel.train.R.id.review_iteneray_train_insurance_fee_txt
            android.view.View r14 = r4.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r15 = com.travel.train.R.string.ri_irctc_insurance_charges
            java.lang.String r15 = r1.getString(r15)
            android.text.Spanned r15 = android.text.Html.fromHtml(r15)
            r14.setText(r15)
            int r14 = com.travel.train.R.id.review_iteneray_train_insurance_fee
            android.view.View r14 = r4.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            int r15 = com.travel.train.R.id.insurance_fee_lyt
            android.view.View r15 = r4.findViewById(r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            com.travel.train.model.trainticket.CJRTrainFare r16 = r3.getTrainFare()
            r16.getGrandTotal()
            com.travel.train.model.trainticket.CJRTrainFare r16 = r3.getTrainFare()
            java.lang.String r16 = r16.getPgCharge()
            com.travel.train.model.trainticket.CJRTrainFare r17 = r3.getTrainFare()
            java.lang.String r17 = r17.getmPaytm_Service_Fee()
            if (r3 == 0) goto L_0x067c
            com.travel.train.model.trainticket.CJRTrainFare r18 = r3.getTrainFare()
            if (r18 == 0) goto L_0x067c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r18 = r22.getActivity()
            r23 = r4
            android.content.res.Resources r4 = r18.getResources()
            r24 = r7
            int r7 = com.travel.train.R.string.rs_symbols
            java.lang.String r4 = r4.getString(r7)
            r2.append(r4)
            java.lang.String r4 = " "
            r2.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r7 = r3.getTrainFare()
            java.lang.String r7 = r7.getTotalFare()
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r0.setText(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            androidx.fragment.app.FragmentActivity r2 = r22.getActivity()
            android.content.res.Resources r2 = r2.getResources()
            int r7 = com.travel.train.R.string.rs_symbols
            java.lang.String r2 = r2.getString(r7)
            r0.append(r2)
            r0.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r2 = r3.getTrainFare()
            java.lang.String r2 = r2.getmPaytm_Service_Fee()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r8.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            androidx.fragment.app.FragmentActivity r2 = r22.getActivity()
            android.content.res.Resources r2 = r2.getResources()
            int r7 = com.travel.train.R.string.rs_symbols
            java.lang.String r2 = r2.getString(r7)
            r0.append(r2)
            java.lang.String r2 = " 0.0"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r13.setText(r0)
            com.travel.train.model.trainticket.CJRTrainFare r0 = r3.getTrainFare()
            java.lang.String r0 = r0.getmIRCTC_Service_Fee()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "0"
            if (r0 != 0) goto L_0x028a
            com.travel.train.model.trainticket.CJRTrainFare r0 = r3.getTrainFare()
            java.lang.String r0 = r0.getmIRCTC_Service_Fee()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 != 0) goto L_0x028a
            r7 = 0
            r5.setVisibility(r7)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            androidx.fragment.app.FragmentActivity r5 = r22.getActivity()
            android.content.res.Resources r5 = r5.getResources()
            int r7 = com.travel.train.R.string.rs_symbols
            java.lang.String r5 = r5.getString(r7)
            r0.append(r5)
            r0.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r5 = r3.getTrainFare()
            java.lang.String r5 = r5.getmIRCTC_Service_Fee()
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r6.setText(r0)
            goto L_0x028f
        L_0x028a:
            r6 = 8
            r5.setVisibility(r6)
        L_0x028f:
            boolean r0 = r1.j
            java.lang.String r5 = " 0"
            if (r0 == 0) goto L_0x0311
            com.travel.train.model.trainticket.CJRTrainFare r0 = r3.getTrainFare()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r0.getMtravelInsuranceCharge()     // Catch:{ Exception -> 0x0306 }
            double r6 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0306 }
            com.travel.train.model.trainticket.CJRTrainFare r0 = r3.getTrainFare()     // Catch:{ Exception -> 0x0306 }
            java.lang.String r0 = r0.getMtravelInsuranceServiceTax()     // Catch:{ Exception -> 0x0306 }
            double r19 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0306 }
            double r6 = r6 + r19
            r19 = r2
            r2 = 0
            r15.setVisibility(r2)     // Catch:{ Exception -> 0x0304 }
            java.lang.Double r0 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0304 }
            java.lang.String r0 = com.travel.train.j.o.a((java.lang.Double) r0)     // Catch:{ Exception -> 0x0304 }
            double r6 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0304 }
            r20 = 0
            int r0 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r0 != 0) goto L_0x02e4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0304 }
            r0.<init>()     // Catch:{ Exception -> 0x0304 }
            android.content.res.Resources r2 = r22.getResources()     // Catch:{ Exception -> 0x0304 }
            int r6 = com.travel.train.R.string.rs_symbols     // Catch:{ Exception -> 0x0304 }
            java.lang.String r2 = r2.getString(r6)     // Catch:{ Exception -> 0x0304 }
            r0.append(r2)     // Catch:{ Exception -> 0x0304 }
            r0.append(r5)     // Catch:{ Exception -> 0x0304 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0304 }
            r14.setText(r0)     // Catch:{ Exception -> 0x0304 }
            goto L_0x0313
        L_0x02e4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0304 }
            r0.<init>()     // Catch:{ Exception -> 0x0304 }
            android.content.res.Resources r2 = r22.getResources()     // Catch:{ Exception -> 0x0304 }
            int r15 = com.travel.train.R.string.rs_symbols     // Catch:{ Exception -> 0x0304 }
            java.lang.String r2 = r2.getString(r15)     // Catch:{ Exception -> 0x0304 }
            r0.append(r2)     // Catch:{ Exception -> 0x0304 }
            r0.append(r4)     // Catch:{ Exception -> 0x0304 }
            r0.append(r6)     // Catch:{ Exception -> 0x0304 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0304 }
            r14.setText(r0)     // Catch:{ Exception -> 0x0304 }
            goto L_0x0313
        L_0x0304:
            r0 = move-exception
            goto L_0x0309
        L_0x0306:
            r0 = move-exception
            r19 = r2
        L_0x0309:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
            goto L_0x0313
        L_0x0311:
            r19 = r2
        L_0x0313:
            boolean r0 = r1.f26929i
            if (r0 == 0) goto L_0x0386
            r2 = 0
            r9.setVisibility(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            androidx.fragment.app.FragmentActivity r2 = r22.getActivity()
            android.content.res.Resources r2 = r2.getResources()
            int r6 = com.travel.train.R.string.rs_symbols
            java.lang.String r2 = r2.getString(r6)
            r0.append(r2)
            r0.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r2 = r3.getTrainFare()
            com.travel.train.model.trainticket.CJRCpBreakUp r2 = r2.getCpCharges()
            java.lang.String r2 = r2.getCpCharges()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r10.setText(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            androidx.fragment.app.FragmentActivity r2 = r22.getActivity()
            android.content.res.Resources r2 = r2.getResources()
            int r6 = com.travel.train.R.string.rs_symbols
            java.lang.String r2 = r2.getString(r6)
            r0.append(r2)
            r0.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r2 = r3.getTrainFare()
            com.travel.train.model.trainticket.CJRCpBreakUp r2 = r2.getCpCharges()
            java.lang.String r2 = r2.getGrandTotalCp()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r13.setText(r0)
            com.travel.train.model.trainticket.CJRTrainFare r0 = r3.getTrainFare()
            com.travel.train.model.trainticket.CJRCpBreakUp r0 = r0.getCpCharges()
            java.lang.String r0 = r0.getGrandTotalCp()
            goto L_0x03be
        L_0x0386:
            r2 = 8
            r9.setVisibility(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            androidx.fragment.app.FragmentActivity r2 = r22.getActivity()
            android.content.res.Resources r2 = r2.getResources()
            int r6 = com.travel.train.R.string.rs_symbols
            java.lang.String r2 = r2.getString(r6)
            r0.append(r2)
            r0.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r2 = r3.getTrainFare()
            java.lang.String r2 = r2.getGrandTotal()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r13.setText(r0)
            com.travel.train.model.trainticket.CJRTrainFare r0 = r3.getTrainFare()
            java.lang.String r0 = r0.getGrandTotal()
        L_0x03be:
            com.travel.train.model.trainticket.CJRTrainBooking r2 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r2 = r2.getmConfirmation()
            com.travel.train.model.trainticket.CJRTrainOptOutPGCharges r2 = r2.getOptOutPGCharges()
            if (r2 == 0) goto L_0x04a3
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            com.travel.train.model.trainticket.CJRTrainBooking r6 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r6 = r6.getmConfirmation()
            com.travel.train.model.trainticket.CJRTrainOptOutPGCharges r6 = r6.getOptOutPGCharges()
            java.lang.Boolean r6 = r6.isWaiveOffConfigered()
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0441
            com.travel.train.model.trainticket.CJRTrainBooking r2 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r2 = r2.getmConfirmation()
            boolean r2 = r2.isGatewayChargeEnabled()
            if (r2 != 0) goto L_0x0413
            r2 = 0
            r11.setVisibility(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r6 = r22.getActivity()
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.train.R.string.rs_symbols
            java.lang.String r6 = r6.getString(r7)
            r2.append(r6)
            r2.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r6 = r3.getTrainFare()
            java.lang.String r6 = r6.getPgCharge()
            goto L_0x04ef
        L_0x0413:
            r2 = 8
            r11.setVisibility(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r6 = r22.getActivity()
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.train.R.string.rs_symbols
            java.lang.String r6 = r6.getString(r7)
            r2.append(r6)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r12.setText(r2)
            float r0 = java.lang.Float.parseFloat(r0)
            float r2 = java.lang.Float.parseFloat(r16)
            goto L_0x04a1
        L_0x0441:
            com.travel.train.model.trainticket.CJRTrainBooking r2 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r2 = r2.getmConfirmation()
            boolean r2 = r2.isGatewayChargeEnabled()
            if (r2 == 0) goto L_0x0474
            r2 = 0
            r11.setVisibility(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r6 = r22.getActivity()
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.train.R.string.rs_symbols
            java.lang.String r6 = r6.getString(r7)
            r2.append(r6)
            r2.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r6 = r3.getTrainFare()
            java.lang.String r6 = r6.getPgCharge()
            goto L_0x04ef
        L_0x0474:
            r2 = 8
            r11.setVisibility(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r6 = r22.getActivity()
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.train.R.string.rs_symbols
            java.lang.String r6 = r6.getString(r7)
            r2.append(r6)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r12.setText(r2)
            float r0 = java.lang.Float.parseFloat(r0)
            float r2 = java.lang.Float.parseFloat(r16)
        L_0x04a1:
            float r0 = r0 - r2
            goto L_0x04fd
        L_0x04a3:
            com.travel.train.model.trainticket.CJRTrainBooking r2 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r2 = r2.getmConfirmation()
            java.lang.Boolean r2 = r2.isDeferredCheckout()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x04b9
            r2 = 8
            r11.setVisibility(r2)
            goto L_0x04bd
        L_0x04b9:
            r2 = 0
            r11.setVisibility(r2)
        L_0x04bd:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r6 = r22.getActivity()
            android.content.res.Resources r6 = r6.getResources()
            int r7 = com.travel.train.R.string.rs_symbols
            java.lang.String r6 = r6.getString(r7)
            r2.append(r6)
            r2.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r6 = r3.getTrainFare()
            java.lang.String r6 = r6.getPgCharge()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x04ed
            com.travel.train.model.trainticket.CJRTrainFare r6 = r3.getTrainFare()
            java.lang.String r6 = r6.getPgCharge()
            goto L_0x04ef
        L_0x04ed:
            r6 = r19
        L_0x04ef:
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r12.setText(r2)
            float r0 = java.lang.Float.parseFloat(r0)
        L_0x04fd:
            com.travel.train.model.trainticket.CJRTrainBooking r2 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r2 = r2.getmConfirmation()
            com.travel.train.model.trainticket.CJRTrainOptOutPGCharges r2 = r2.getOptOutServiceCharges()
            if (r2 == 0) goto L_0x05f3
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            com.travel.train.model.trainticket.CJRTrainBooking r6 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r6 = r6.getmConfirmation()
            com.travel.train.model.trainticket.CJRTrainOptOutPGCharges r6 = r6.getOptOutServiceCharges()
            java.lang.Boolean r6 = r6.isWaiveOffConfigered()
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x058a
            com.travel.train.model.trainticket.CJRTrainBooking r2 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r2 = r2.getmConfirmation()
            boolean r2 = r2.isServiceChargeEnabled()
            if (r2 != 0) goto L_0x055e
            r7 = r24
            r2 = 0
            r7.setVisibility(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r5 = r22.getActivity()
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.travel.train.R.string.rs_symbols
            java.lang.String r5 = r5.getString(r6)
            r2.append(r5)
            r2.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r3 = r3.getTrainFare()
            java.lang.String r3 = r3.getmPaytm_Service_Fee()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r8.setText(r2)
            goto L_0x0624
        L_0x055e:
            r7 = r24
            r2 = 8
            r7.setVisibility(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r3 = r22.getActivity()
            android.content.res.Resources r3 = r3.getResources()
            int r6 = com.travel.train.R.string.rs_symbols
            java.lang.String r3 = r3.getString(r6)
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r8.setText(r2)
            float r2 = java.lang.Float.parseFloat(r17)
            goto L_0x05f1
        L_0x058a:
            r7 = r24
            com.travel.train.model.trainticket.CJRTrainBooking r2 = r1.f26927g
            com.travel.train.model.trainticket.CJRTrainConfirmation r2 = r2.getmConfirmation()
            boolean r2 = r2.isServiceChargeEnabled()
            if (r2 == 0) goto L_0x05c8
            r2 = 0
            r7.setVisibility(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r5 = r22.getActivity()
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.travel.train.R.string.rs_symbols
            java.lang.String r5 = r5.getString(r6)
            r2.append(r5)
            r2.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r3 = r3.getTrainFare()
            java.lang.String r3 = r3.getmPaytm_Service_Fee()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r8.setText(r2)
            goto L_0x0624
        L_0x05c8:
            r2 = 8
            r7.setVisibility(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r3 = r22.getActivity()
            android.content.res.Resources r3 = r3.getResources()
            int r6 = com.travel.train.R.string.rs_symbols
            java.lang.String r3 = r3.getString(r6)
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r8.setText(r2)
            float r2 = java.lang.Float.parseFloat(r17)
        L_0x05f1:
            float r0 = r0 - r2
            goto L_0x0624
        L_0x05f3:
            r7 = r24
            r2 = 0
            r7.setVisibility(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r5 = r22.getActivity()
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.travel.train.R.string.rs_symbols
            java.lang.String r5 = r5.getString(r6)
            r2.append(r5)
            r2.append(r4)
            com.travel.train.model.trainticket.CJRTrainFare r3 = r3.getTrainFare()
            java.lang.String r3 = r3.getmPaytm_Service_Fee()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r8.setText(r2)
        L_0x0624:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            androidx.fragment.app.FragmentActivity r3 = r22.getActivity()
            android.content.res.Resources r3 = r3.getResources()
            int r5 = com.travel.train.R.string.rs_symbols
            java.lang.String r3 = r3.getString(r5)
            r2.append(r3)
            r2.append(r4)
            double r3 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r3)
            java.lang.String r0 = com.travel.train.j.o.a((java.lang.Double) r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r13.setText(r0)
            android.widget.LinearLayout r0 = r1.f26926f
            r2 = r23
            r0.addView(r2)
            goto L_0x067c
        L_0x0658:
            java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainFareDetail> r0 = r1.k
            if (r0 == 0) goto L_0x067c
        L_0x065c:
            java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainFareDetail> r0 = r1.k
            int r0 = r0.size()
            if (r2 >= r0) goto L_0x067c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainFareDetail> r0 = r1.k
            java.lang.Object r0 = r0.get(r2)
            com.travel.train.model.trainticket.CJRTrainFareDetail r0 = (com.travel.train.model.trainticket.CJRTrainFareDetail) r0
            if (r0 == 0) goto L_0x0679
            boolean r3 = r0.getVisibility()
            if (r3 == 0) goto L_0x0679
            android.widget.LinearLayout r3 = r1.f26926f
            r1.a((com.travel.train.model.trainticket.CJRTrainFareDetail) r0, (android.view.ViewGroup) r3)
        L_0x0679:
            int r2 = r2 + 1
            goto L_0x065c
        L_0x067c:
            android.view.View r0 = r1.f26925e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.c.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            this.p = (a) getActivity();
        }
    }

    private void a(CJRTrainFareDetail cJRTrainFareDetail, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pre_t_lyt_train_fare_detail_item, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.fare_details_layout);
        TextView textView = (TextView) inflate.findViewById(R.id.fare_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fare_value);
        TextView textView3 = (TextView) inflate.findViewById(R.id.sub_title);
        View findViewById = inflate.findViewById(R.id.v_left_empty_view);
        View findViewById2 = inflate.findViewById(R.id.bottom_separator_line);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.plus_symbol);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.lv_child_container);
        if (cJRTrainFareDetail.getType().equalsIgnoreCase(this.f26921a) || cJRTrainFareDetail.getType().equalsIgnoreCase(this.f26922b) || cJRTrainFareDetail.getType().equalsIgnoreCase(this.f26923c)) {
            findViewById2.setVisibility(8);
            relativeLayout.setVisibility(0);
            a(cJRTrainFareDetail, textView, textView3, findViewById);
            a(cJRTrainFareDetail, textView2);
            a(cJRTrainFareDetail, imageView, linearLayout);
        } else {
            findViewById2.setVisibility(0);
            relativeLayout.setVisibility(8);
        }
        viewGroup.addView(inflate);
    }

    private void a(CJRTrainFareDetail cJRTrainFareDetail, TextView textView, TextView textView2, View view) {
        if (cJRTrainFareDetail != null) {
            if (cJRTrainFareDetail.getType().equalsIgnoreCase(this.f26923c)) {
                view.setVisibility(0);
                textView.setTextSize(2, 12.0f);
            } else {
                view.setVisibility(8);
                textView.setTextSize(2, 13.0f);
            }
            List<CJRTrainDisplayName> displayName = cJRTrainFareDetail.getDisplayName();
            if (displayName != null) {
                textView.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
                for (int i2 = 0; i2 < displayName.size(); i2++) {
                    CJRTrainDisplayName cJRTrainDisplayName = displayName.get(i2);
                    if (!TextUtils.isEmpty(cJRTrainDisplayName.getText())) {
                        if (!cJRTrainDisplayName.getAlignment().equalsIgnoreCase(this.f26924d)) {
                            textView2.setVisibility(0);
                            if (spannableStringBuilder2.length() == 0) {
                                spannableStringBuilder2 = a(spannableStringBuilder2, cJRTrainDisplayName.getText(), cJRTrainDisplayName.getTextType(), 0);
                            } else {
                                spannableStringBuilder2 = a(spannableStringBuilder2, cJRTrainDisplayName.getText(), cJRTrainDisplayName.getTextType(), spannableStringBuilder3.length());
                            }
                        } else if (spannableStringBuilder3.length() == 0) {
                            spannableStringBuilder3 = a(spannableStringBuilder3, cJRTrainDisplayName.getText(), cJRTrainDisplayName.getTextType(), 0);
                        } else {
                            spannableStringBuilder3 = a(spannableStringBuilder3, cJRTrainDisplayName.getText(), cJRTrainDisplayName.getTextType(), spannableStringBuilder3.length());
                        }
                    }
                }
                textView.setText(spannableStringBuilder3);
                textView2.setText(spannableStringBuilder2);
            }
        }
    }

    private void a(CJRTrainFareDetail cJRTrainFareDetail, TextView textView) {
        List<CJRTrainValue> value;
        if (cJRTrainFareDetail != null && (value = cJRTrainFareDetail.getValue()) != null) {
            textView.setVisibility(0);
            int size = value.size();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                CJRTrainValue cJRTrainValue = value.get(i2);
                if (cJRTrainValue != null && !TextUtils.isEmpty(cJRTrainValue.getText())) {
                    if (!cJRTrainValue.isAmount()) {
                        if (i2 == 0) {
                            spannableStringBuilder = a(spannableStringBuilder, cJRTrainValue.getText(), cJRTrainValue.getTextType(), 0);
                        } else {
                            spannableStringBuilder = a(spannableStringBuilder, cJRTrainValue.getText(), cJRTrainValue.getTextType(), spannableStringBuilder.length());
                        }
                    } else if (cJRTrainFareDetail.getKey() == this.l) {
                        cJRTrainValue.setText(o.a(this.m));
                        if (this.f26927g.getmConfirmation().getOptOutPGCharges() == null || this.f26927g.getmConfirmation().getOptOutServiceCharges() == null || this.f26927g.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered() == null || this.f26927g.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered() == null) {
                            if (!this.f26927g.getmConfirmation().isGatewayChargeEnabled() && !this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                                cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf((((double) Float.parseFloat(cJRTrainValue.getText())) - this.q) - this.r))));
                            } else if (this.f26927g.getmConfirmation().isGatewayChargeEnabled() && !this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                                cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - this.r))));
                            } else if (!this.f26927g.getmConfirmation().isGatewayChargeEnabled() && this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                                cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - this.q))));
                            }
                        } else if (!this.f26927g.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered().booleanValue() || !this.f26927g.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered().booleanValue()) {
                            if (!this.f26927g.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered().booleanValue() || this.f26927g.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered().booleanValue()) {
                                if (!this.f26927g.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered().booleanValue() && this.f26927g.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered().booleanValue()) {
                                    if (!this.f26927g.getmConfirmation().isGatewayChargeEnabled() && this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                                        cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf((((double) Float.parseFloat(cJRTrainValue.getText())) - this.q) - this.r))));
                                    } else if (this.f26927g.getmConfirmation().isGatewayChargeEnabled() && this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                                        cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - this.r))));
                                    } else if (!this.f26927g.getmConfirmation().isGatewayChargeEnabled() && this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                                        cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - this.q))));
                                    }
                                }
                            } else if (this.f26927g.getmConfirmation().isGatewayChargeEnabled() && !this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                                cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf((((double) Float.parseFloat(cJRTrainValue.getText())) - this.q) - this.r))));
                            } else if (!this.f26927g.getmConfirmation().isGatewayChargeEnabled() && !this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                                cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - this.r))));
                            } else if (this.f26927g.getmConfirmation().isGatewayChargeEnabled() && this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                                cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - this.q))));
                            }
                        } else if (this.f26927g.getmConfirmation().isGatewayChargeEnabled() && this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                            cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf((((double) Float.parseFloat(cJRTrainValue.getText())) - this.q) - this.r))));
                        } else if (!this.f26927g.getmConfirmation().isGatewayChargeEnabled() && this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                            cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - this.r))));
                        } else if (this.f26927g.getmConfirmation().isGatewayChargeEnabled() && !this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                            cJRTrainValue.setText(o.a(Double.valueOf(String.valueOf(((double) Float.parseFloat(cJRTrainValue.getText())) - this.q))));
                        }
                        spannableStringBuilder = a(spannableStringBuilder, cJRTrainValue.getText(), cJRTrainValue.getTextType(), spannableStringBuilder.length());
                    } else if (this.f26927g.getmConfirmation().getOptOutPGCharges() == null || cJRTrainFareDetail.getKey() != this.f26927g.getmConfirmation().getOptOutPGCharges().getToggleKey().intValue()) {
                        if (this.f26927g.getmConfirmation().getOptOutServiceCharges() == null || cJRTrainFareDetail.getKey() != this.f26927g.getmConfirmation().getOptOutServiceCharges().getToggleKey().intValue()) {
                            spannableStringBuilder = a(spannableStringBuilder, cJRTrainValue.getText(), cJRTrainValue.getTextType(), spannableStringBuilder.length());
                        } else if (Boolean.TRUE.equals(this.f26927g.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered())) {
                            if (this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                                spannableStringBuilder = a(spannableStringBuilder, "0", cJRTrainValue.getTextType(), spannableStringBuilder.length());
                            } else {
                                spannableStringBuilder = a(spannableStringBuilder, cJRTrainValue.getText(), cJRTrainValue.getTextType(), spannableStringBuilder.length());
                            }
                        } else if (!this.f26927g.getmConfirmation().isServiceChargeEnabled()) {
                            spannableStringBuilder = a(spannableStringBuilder, "0", cJRTrainValue.getTextType(), spannableStringBuilder.length());
                        } else {
                            spannableStringBuilder = a(spannableStringBuilder, cJRTrainValue.getText(), cJRTrainValue.getTextType(), spannableStringBuilder.length());
                        }
                    } else if (Boolean.TRUE.equals(this.f26927g.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered())) {
                        if (this.f26927g.getmConfirmation().isGatewayChargeEnabled()) {
                            spannableStringBuilder = a(spannableStringBuilder, "0", cJRTrainValue.getTextType(), spannableStringBuilder.length());
                        } else {
                            spannableStringBuilder = a(spannableStringBuilder, cJRTrainValue.getText(), cJRTrainValue.getTextType(), spannableStringBuilder.length());
                        }
                    } else if (!this.f26927g.getmConfirmation().isGatewayChargeEnabled()) {
                        spannableStringBuilder = a(spannableStringBuilder, "0", cJRTrainValue.getTextType(), spannableStringBuilder.length());
                    } else {
                        spannableStringBuilder = a(spannableStringBuilder, cJRTrainValue.getText(), cJRTrainValue.getTextType(), spannableStringBuilder.length());
                    }
                }
            }
            textView.setText(spannableStringBuilder);
        }
    }

    private void a(CJRTrainFareDetail cJRTrainFareDetail, final ImageView imageView, final LinearLayout linearLayout) {
        if (cJRTrainFareDetail != null) {
            if (cJRTrainFareDetail.getChildList() == null || cJRTrainFareDetail.getChildList().size() <= 0) {
                imageView.setVisibility(8);
                linearLayout.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                linearLayout.setVisibility(0);
                for (int i2 = 0; i2 < cJRTrainFareDetail.getChildList().size(); i2++) {
                    CJRTrainFareDetail cJRTrainFareDetail2 = cJRTrainFareDetail.getChildList().get(i2);
                    if (cJRTrainFareDetail2 != null) {
                        a(cJRTrainFareDetail2, (ViewGroup) linearLayout);
                    }
                }
                linearLayout.setVisibility(8);
            }
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (linearLayout.getVisibility() == 0) {
                        linearLayout.setVisibility(8);
                        imageView.setImageDrawable(c.this.getActivity().getResources().getDrawable(R.drawable.sqaure_plus_thin));
                        return;
                    }
                    linearLayout.setVisibility(0);
                    imageView.setImageDrawable(c.this.getActivity().getResources().getDrawable(R.drawable.sqaure_minus_thin));
                }
            });
        }
    }

    private SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i2) {
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append(str);
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 2076325) {
                if (hashCode != 77195690) {
                    if (hashCode == 2141079518 && str2.equals("Greyed")) {
                        c2 = 2;
                    }
                } else if (str2.equals("Plain")) {
                    c2 = 1;
                }
            } else if (str2.equals("Bold")) {
                c2 = 0;
            }
            if (c2 == 0) {
                spannableStringBuilder.setSpan(new StyleSpan(1), i2, spannableStringBuilder.length(), 0);
            } else if (c2 == 1) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i2, spannableStringBuilder.length(), 0);
            } else if (c2 == 2) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.payment_success_text_grey)), i2, spannableStringBuilder.length(), 0);
                spannableStringBuilder.setSpan(new RelativeSizeSpan(1.0f), i2, spannableStringBuilder.length(), 0);
            }
        }
        return spannableStringBuilder;
    }

    public void onClick(View view) {
        a aVar;
        if (view.getId() == R.id.detail_close && (aVar = this.p) != null) {
            aVar.a();
        }
    }

    public boolean onBackPressed() {
        a aVar = this.p;
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return true;
    }
}
