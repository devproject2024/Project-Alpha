package com.travel.flight.flightorder.j;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.c;
import com.travel.flight.R;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightticket.activity.AJRAncillaryOrderDetails;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryPayments;
import net.one97.paytmflight.common.entity.flightticket.CJROrderSummarySummary;
import net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryValue;

public final class n extends com.travel.flight.flightorder.f.a {

    /* renamed from: a  reason: collision with root package name */
    CJRFlightOrderSummaryResponse f24553a;

    /* renamed from: b  reason: collision with root package name */
    Context f24554b;

    /* renamed from: c  reason: collision with root package name */
    private com.travel.flight.flightorder.g.a f24555c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f24556d = ((RelativeLayout) this.itemView.findViewById(R.id.promocode_layout));

    /* renamed from: e  reason: collision with root package name */
    private TextView f24557e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f24558f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f24559g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f24560h;

    /* renamed from: i  reason: collision with root package name */
    private Resources f24561i;
    private LayoutInflater j;
    private String k;
    private LinearLayout l;
    private TextView m;

    public n(Context context, View view, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse, com.travel.flight.flightorder.g.a aVar) {
        super(view);
        this.f24554b = context;
        this.f24561i = view.getResources();
        this.f24556d.setVisibility(8);
        this.j = LayoutInflater.from(this.f24554b);
        this.f24558f = (LinearLayout) this.itemView.findViewById(R.id.lyt_fare_details);
        this.f24558f.setVisibility(8);
        this.f24559g = (TextView) this.itemView.findViewById(R.id.order_summary_show_more);
        this.f24560h = (LinearLayout) this.itemView.findViewById(R.id.total_booking_layout_amount);
        this.f24560h.setVisibility(8);
        this.f24557e = (TextView) view.findViewById(R.id.text_total_fare_text);
        this.f24558f.setVisibility(0);
        this.f24559g.setVisibility(8);
        this.l = (LinearLayout) view.findViewById(R.id.lyt_payment_from_bank);
        this.m = (TextView) view.findViewById(R.id.wallet_statement);
        this.f24553a = cJRFlightOrderSummaryResponse;
        this.f24555c = aVar;
    }

    public final void a(b.C0467b bVar) {
        CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse = this.f24553a;
        if (cJRFlightOrderSummaryResponse != null) {
            try {
                ArrayList<CJROrderSummarySummary> summary = cJRFlightOrderSummaryResponse.getBody().getPymnt_summary().getSummary();
                this.f24558f.removeAllViews();
                LinearLayout linearLayout = this.f24558f;
                Iterator<CJROrderSummarySummary> it2 = summary.iterator();
                while (it2.hasNext()) {
                    CJROrderSummarySummary next = it2.next();
                    if ("B".equalsIgnoreCase(next.getText_type())) {
                        View inflate = this.j.inflate(R.layout.pre_f_flight_order_summary_mainheading, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R.id.flight_order_summary_mainheading_key_1);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.flight_order_summary_mainheading_value_1);
                        if (!TextUtils.isEmpty(next.getKey())) {
                            textView.setText(next.getKey());
                        }
                        if (!TextUtils.isEmpty(next.getValue() + " ")) {
                            String string = this.f24554b.getString(R.string.flight_amount_in_rupees);
                            textView2.setText(String.format(string, new Object[]{next.getValue() + " "}));
                        }
                        linearLayout.addView(inflate);
                    } else if (UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT.equalsIgnoreCase(next.getText_type())) {
                        View inflate2 = this.j.inflate(R.layout.pre_f_refund_summary_payment_info_layout, (ViewGroup) null);
                        TextView textView3 = (TextView) inflate2.findViewById(R.id.refund_summary_pay_info_key);
                        TextView textView4 = (TextView) inflate2.findViewById(R.id.refund_summary_pay_info_value);
                        ImageView imageView = (ImageView) inflate2.findViewById(R.id.refund_summary_payment_detail_info_icon);
                        if (!TextUtils.isEmpty(next.getKey())) {
                            textView3.setText(next.getKey());
                        }
                        if (!TextUtils.isEmpty(next.getValue())) {
                            String string2 = this.f24554b.getString(R.string.flight_amount_in_rupees);
                            textView4.setText(String.format(string2, new Object[]{next.getValue() + " "}));
                        }
                        if ("Taxes and Fees".equalsIgnoreCase(next.getKey())) {
                            if (this.f24553a.getBody().getPymnt_summary().getTax_break_up() != null && this.f24553a.getBody().getPymnt_summary().getTax_break_up().getValue().size() > 0) {
                                imageView.setVisibility(0);
                                imageView.setOnClickListener(new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        n nVar = n.this;
                                        Context context = nVar.f24554b;
                                        ArrayList<CJROrderSummaryValue> value = n.this.f24553a.getBody().getPymnt_summary().getTax_break_up().getValue();
                                        c.a aVar = new c.a(context);
                                        aVar.a((CharSequence) nVar.f24554b.getString(R.string.taxes_breakup));
                                        aVar.a((ListAdapter) new a(value), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                            }
                                        });
                                        aVar.b();
                                    }
                                });
                            }
                        } else if ("Meals".equalsIgnoreCase(next.getKey()) || "Extra Baggage".equalsIgnoreCase(next.getKey())) {
                            imageView.setVisibility(0);
                            imageView.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    Intent intent = new Intent(n.this.f24554b, AJRAncillaryOrderDetails.class);
                                    intent.putExtra("orderSummary", n.this.f24553a);
                                    n.this.f24554b.startActivity(intent);
                                }
                            });
                        }
                        linearLayout.addView(inflate2);
                    }
                    if ("Total amount paid".equalsIgnoreCase(next.getKey())) {
                        this.k = next.getValue();
                        if (!TextUtils.isEmpty(this.k)) {
                            this.f24557e.setText(String.format(this.f24554b.getString(R.string.flight_amount_in_rupees), new Object[]{this.k}));
                        }
                    }
                }
                b();
                a();
            } catch (Exception unused) {
            }
        }
    }

    private void a() {
        Iterator<CJROrderSummaryPayments> it2 = this.f24553a.getBody().getPayments().iterator();
        while (it2.hasNext()) {
            CJROrderSummaryPayments next = it2.next();
            if (!TextUtils.isEmpty(next.getPayment_method()) && !"NB".equalsIgnoreCase(next.getPayment_method()) && !Constants.EASYPAY_PAYTYPE_CREDIT_CARD.equalsIgnoreCase(next.getPayment_method()) && !Constants.EASYPAY_PAYTYPE_DEBIT_CARD.equalsIgnoreCase(next.getPayment_method()) && !next.getPayment_method().equalsIgnoreCase("Paytm Cash")) {
                next.getPayment_method().equalsIgnoreCase("paytm");
            }
        }
    }

    class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<CJROrderSummaryValue> f24566b;

        public final long getItemId(int i2) {
            return 0;
        }

        public a(ArrayList<CJROrderSummaryValue> arrayList) {
            this.f24566b = arrayList;
        }

        public final int getCount() {
            ArrayList<CJROrderSummaryValue> arrayList = this.f24566b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public final Object getItem(int i2) {
            return this.f24566b.get(i2);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pre_f_flight_tax_breakup_spinner_item_layout, (ViewGroup) null);
            }
            if (this.f24566b.size() > i2) {
                CJROrderSummaryValue cJROrderSummaryValue = this.f24566b.get(i2);
                ((TextView) view.findViewById(R.id.taxbreakup_spinner_item_label)).setText(cJROrderSummaryValue.getKey());
                ((TextView) view.findViewById(R.id.taxbreakup_spinner_item_label_value)).setText(String.format(view.getResources().getString(R.string.recharge_rs), new Object[]{cJROrderSummaryValue.getValue()}));
            }
            return view;
        }
    }

    private void b() {
        ArrayList<CJROrderSummaryPayments> payments = this.f24553a.getBody().getPayments();
        this.l.removeAllViews();
        if (payments == null || payments.size() <= 0) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        Iterator<CJROrderSummaryPayments> it2 = payments.iterator();
        while (it2.hasNext()) {
            CJROrderSummaryPayments next = it2.next();
            if ("inward".equalsIgnoreCase(next.getKind_text())) {
                View inflate = this.j.inflate(R.layout.pre_f_refundsummary_card_payment_source, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.lbl_refund_amount)).setText(next.getPayment_method());
                TextView textView = (TextView) inflate.findViewById(R.id.refund_amount);
                textView.setText(String.format(this.f24554b.getResources().getString(R.string.recharge_rs), new Object[]{next.getPg_amount()}));
                ((TextView) inflate.findViewById(R.id.refund_date_id)).setText(String.format(textView.getResources().getString(R.string.flight_refunddateID_msg), new Object[]{next.getId()}));
                if (TextUtils.isEmpty(next.getPayment_method())) {
                    this.l.setVisibility(8);
                    return;
                }
                this.l.addView(inflate);
            } else {
                "outward".equalsIgnoreCase(next.getKind_text());
            }
        }
    }
}
