package com.travel.flight.flightorder.j;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.utility.q;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightorder.activity.FlightOrderSummary;
import com.travel.flight.flightorder.activity.RefundBreakUpActivity;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.f.a;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryPayments;
import net.one97.paytmflight.common.entity.flightticket.FlightOrderRefundSummary;
import net.one97.paytmflight.common.entity.flightticket.FlightOrderRefundSummaryInLineMessage;
import net.one97.paytmflight.common.entity.flightticket.FlightOrderRefundSummaryValue;
import net.one97.paytmflight.common.entity.flightticket.FlightOrderSummaryRefundNotes;
import net.one97.paytmflight.common.entity.flightticket.OrderSummaryRefundFail;
import net.one97.paytmflight.common.entity.shopping.CJROrderSummaryCancellation;

public final class o extends a {

    /* renamed from: a  reason: collision with root package name */
    public CJROrderSummaryCancellation f24567a;

    /* renamed from: b  reason: collision with root package name */
    Context f24568b;

    /* renamed from: c  reason: collision with root package name */
    String f24569c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f24570d;

    /* renamed from: e  reason: collision with root package name */
    private CJRFlightOrderSummaryResponse f24571e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f24572f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f24573g;

    /* renamed from: h  reason: collision with root package name */
    private View f24574h;

    /* renamed from: i  reason: collision with root package name */
    private FlightOrderSummary.a f24575i;
    private OrderSummaryRefundFail j;
    private View k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private View o;
    private LayoutInflater p;
    private Set<String> q = new HashSet();
    private int r;
    private TextView s;
    private View t;
    private View u;

    public o(View view, final CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse, CJROrderSummaryCancellation cJROrderSummaryCancellation, String str, FlightOrderSummary.a aVar) {
        super(view);
        this.f24575i = aVar;
        this.f24569c = str;
        this.f24571e = cJRFlightOrderSummaryResponse;
        this.f24567a = cJROrderSummaryCancellation;
        this.f24568b = view.getContext();
        this.p = LayoutInflater.from(this.f24568b);
        this.f24574h = view.findViewById(R.id.flight_refund_summary_refund_notes);
        this.f24572f = (TextView) view.findViewById(R.id.order_summary_link);
        this.t = view.findViewById(R.id.separator1);
        this.u = view.findViewById(R.id.separator2);
        this.o = view.findViewById(R.id.refundSummary_parent);
        this.f24572f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (o.this.f24567a != null) {
                    Intent intent = new Intent(o.this.f24568b, RefundBreakUpActivity.class);
                    intent.putExtra("Order_summary", cJRFlightOrderSummaryResponse);
                    intent.putExtra("order-summary-cancellation", o.this.f24567a);
                    intent.putExtra("order_id", o.this.f24569c);
                    o.this.f24568b.startActivity(intent);
                }
            }
        });
        this.f24573g = (TextView) view.findViewById(R.id.order_summary_link_desc);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f24573g.setText(Html.fromHtml(this.f24568b.getString(R.string.refund_summary_ticket_wise), 0));
        } else {
            this.f24573g.setText(Html.fromHtml(this.f24568b.getString(R.string.refund_summary_ticket_wise)));
        }
        this.s = (TextView) view.findViewById(R.id.wallet_statement);
        this.f24570d = (TextView) view.findViewById(R.id.refund_messege);
        this.k = view.findViewById(R.id.fails_refundcard);
        this.j = this.f24571e.getBody().getRefund_summary().getBooking_fail();
        this.l = (LinearLayout) view.findViewById(R.id.refundsummary_payment_info_parent);
        this.m = (LinearLayout) view.findViewById(R.id.refund_notes_layout);
        this.n = (LinearLayout) view.findViewById(R.id.flight_refund_summary_card_revamp_parent);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) view.findViewById(R.id.refund_notes_place_holder), "note_icon.png", false, false, n.a.V1);
    }

    public final void a(b.C0467b bVar) {
        Spanned spanned;
        CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse = this.f24571e;
        if (cJRFlightOrderSummaryResponse != null) {
            if (cJRFlightOrderSummaryResponse.getBody() != null && this.f24571e.getBody().getCashback_card() == null) {
                this.s.setVisibility(8);
                this.s.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        com.travel.flight.b.a();
                        com.travel.flight.b.b().e(o.this.f24568b, intent);
                        o.this.f24568b.startActivity(intent);
                    }
                });
            }
            if (this.f24571e.getBody().getRefund_summary().getSummary() != null) {
                try {
                    ArrayList<FlightOrderRefundSummary> summary = this.f24571e.getBody().getRefund_summary().getSummary();
                    Iterator<CJROrderSummaryItems> it2 = this.f24571e.getBody().getItems().iterator();
                    int i2 = 0;
                    while (it2.hasNext()) {
                        if ("flights".equalsIgnoreCase(it2.next().getType())) {
                            i2++;
                        }
                    }
                    this.r = i2;
                    if (this.r > 1) {
                        this.f24572f.setVisibility(0);
                        this.f24573g.setVisibility(0);
                    }
                    LinearLayout linearLayout = this.n;
                    this.n.removeAllViews();
                    if (summary.size() > 0) {
                        this.o.setVisibility(0);
                    } else {
                        this.o.setVisibility(8);
                    }
                    Iterator<FlightOrderRefundSummary> it3 = summary.iterator();
                    while (it3.hasNext()) {
                        FlightOrderRefundSummary next = it3.next();
                        View inflate = this.p.inflate(R.layout.pre_f_flight_order_summary_refund_heading, (ViewGroup) null);
                        TextView textView = (TextView) inflate.findViewById(R.id.flight_order_summary_refund_heading_label);
                        if (!TextUtils.isEmpty(next.getText())) {
                            textView.setText(next.getText());
                        }
                        linearLayout.addView(inflate);
                        Iterator<FlightOrderRefundSummaryValue> it4 = next.getValue().iterator();
                        while (it4.hasNext()) {
                            FlightOrderRefundSummaryValue next2 = it4.next();
                            if (UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT.equalsIgnoreCase(next2.getText_type())) {
                                View inflate2 = this.p.inflate(R.layout.pre_f_flight_order_summary_refund_key_value, (ViewGroup) null);
                                TextView textView2 = (TextView) inflate2.findViewById(R.id.flight_order_summary_refund_key);
                                TextView textView3 = (TextView) inflate2.findViewById(R.id.flight_order_summary_refund_value);
                                if (!TextUtils.isEmpty(next2.getKey())) {
                                    textView2.setText(next2.getKey());
                                }
                                if (!TextUtils.isEmpty(next2.getValue())) {
                                    textView3.setText(String.format(this.f24568b.getString(R.string.flight_amount_in_rupees), new Object[]{next2.getValue() + " "}));
                                }
                                if (!TextUtils.isEmpty(next2.getStrike_value())) {
                                    String str = next2.getValue() + " ";
                                    String str2 = String.format(this.f24568b.getString(R.string.coupons_discount_rs), new Object[]{str}) + "<strike>" + String.format(this.f24568b.getString(R.string.coupons_discount_rs), new Object[]{next2.getStrike_value()}) + "</strike>";
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        spanned = Html.fromHtml(str2, 0);
                                    } else {
                                        spanned = Html.fromHtml(str2);
                                    }
                                    textView3.setText(spanned);
                                }
                                linearLayout.addView(inflate2);
                            } else if ("B".equalsIgnoreCase(next2.getText_type())) {
                                View inflate3 = this.p.inflate(R.layout.pre_f_flight_order_summary_mainheading, (ViewGroup) null);
                                TextView textView4 = (TextView) inflate3.findViewById(R.id.flight_order_summary_mainheading_key_1);
                                TextView textView5 = (TextView) inflate3.findViewById(R.id.flight_order_summary_mainheading_value_1);
                                if (!TextUtils.isEmpty(next2.getKey())) {
                                    textView4.setText(next2.getKey());
                                }
                                if (!TextUtils.isEmpty(next2.getValue())) {
                                    textView5.setText(String.format(this.f24568b.getString(R.string.flight_amount_in_rupees), new Object[]{next2.getValue() + " "}));
                                }
                                linearLayout.addView(inflate3);
                            }
                            if (next2.getInline_messages() != null && next2.getInline_messages().size() > 0) {
                                a(next2.getInline_messages(), linearLayout);
                            }
                        }
                    }
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
            } else {
                this.s.setVisibility(0);
                this.s.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        com.travel.flight.b.a();
                        com.travel.flight.b.b().e(o.this.f24568b, intent);
                        o.this.f24568b.startActivity(intent);
                    }
                });
                this.t.setVisibility(8);
                this.u.setVisibility(8);
            }
            a(this.f24571e.getBody().getItems());
            a();
            a(this.m, this.f24571e.getBody().getRefund_notes());
        }
    }

    private void a() {
        ArrayList<CJROrderSummaryPayments> payments = this.f24571e.getBody().getPayments();
        this.l.removeAllViews();
        Iterator<CJROrderSummaryPayments> it2 = payments.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            CJROrderSummaryPayments next = it2.next();
            if (!"inward".equalsIgnoreCase(next.getKind_text()) && "outward".equalsIgnoreCase(next.getKind_text())) {
                View inflate = this.p.inflate(R.layout.pre_f_refundsummary_card_payment_source, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.lbl_refund_amount);
                if (TextUtils.isEmpty(next.getPayment_method())) {
                    this.l.setVisibility(8);
                    break;
                }
                textView.setText(String.format(this.f24570d.getResources().getString(R.string.refunded_to_format), new Object[]{next.getPayment_method()}));
                TextView textView2 = (TextView) inflate.findViewById(R.id.refund_amount);
                textView2.setText(String.format(this.f24570d.getResources().getString(R.string.recharge_rs), new Object[]{next.getPg_amount()}));
                ((TextView) inflate.findViewById(R.id.refund_date_id)).setText(String.format(textView2.getResources().getString(R.string.flight_ordr_smry_refunddateID_msg), new Object[]{net.one97.paytmflight.a.a.a(next.getCreated_at(), "yyyy-MM-dd'T'HH:mm:ss", "dd, MMM hh:mm a "), next.getId()}));
                this.l.addView(inflate);
                this.k.setVisibility(0);
            }
        }
        OrderSummaryRefundFail orderSummaryRefundFail = this.j;
        if (orderSummaryRefundFail != null) {
            String message = orderSummaryRefundFail.getMessage();
            if (!TextUtils.isEmpty(message)) {
                this.f24570d.setText(message);
                this.f24570d.setVisibility(0);
                return;
            }
            this.f24570d.setVisibility(8);
        }
    }

    private void a(LinearLayout linearLayout, ArrayList<FlightOrderSummaryRefundNotes> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            linearLayout.setVisibility(0);
            this.f24574h.setVisibility(0);
            linearLayout.removeAllViews();
            Iterator<FlightOrderSummaryRefundNotes> it2 = arrayList.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                FlightOrderSummaryRefundNotes next = it2.next();
                i2++;
                View inflate = this.p.inflate(R.layout.pre_f_refundsummary_card_refund_notes, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.refund_summary_refundnotes_cell_label);
                if (Build.VERSION.SDK_INT >= 24) {
                    Spanned fromHtml = Html.fromHtml("<b>" + i2 + ": </b>", 0);
                    textView.setText(fromHtml + next.getMessage());
                } else {
                    Spanned fromHtml2 = Html.fromHtml("<b>" + i2 + ": </b>");
                    textView.setText(fromHtml2 + next.getMessage());
                }
                linearLayout.addView(inflate);
            }
        }
    }

    private View a(ArrayList<FlightOrderRefundSummaryInLineMessage> arrayList, LinearLayout linearLayout) {
        Iterator<FlightOrderRefundSummaryInLineMessage> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            FlightOrderRefundSummaryInLineMessage next = it2.next();
            View inflate = this.p.inflate(R.layout.pre_f_refundsummary_card_pramotion_notes, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.refundordersummary_card_pramotion_message);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.refundordersummary_card_pramotion_image);
            if (!TextUtils.isEmpty(next.getMessage())) {
                textView.setText(next.getMessage());
            }
            if (!TextUtils.isEmpty(next.getImg_url())) {
                a.a(next.getImg_url(), imageView, this.f24568b);
            }
            linearLayout.addView(inflate);
        }
        return linearLayout;
    }

    private void a(ArrayList<CJROrderSummaryItems> arrayList) {
        Iterator<CJROrderSummaryItems> it2 = arrayList.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            CJROrderSummaryItems next = it2.next();
            if ("flights".equalsIgnoreCase(next.getType()) && "Cancelled".equalsIgnoreCase(next.getStatus_text())) {
                i2++;
            }
        }
        if (i2 > 1) {
            this.f24572f.setVisibility(0);
            this.f24573g.setVisibility(0);
            return;
        }
        this.f24572f.setVisibility(8);
        this.f24573g.setVisibility(8);
    }
}
