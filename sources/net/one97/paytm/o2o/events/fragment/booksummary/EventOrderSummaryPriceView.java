package net.one97.paytm.o2o.events.fragment.booksummary;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.events.CJREventCancellationProtectDetail;
import net.one97.paytm.common.entity.events.CJREventsConvenienceFee;
import net.one97.paytm.common.entity.events.CJREventsItemDetail;
import net.one97.paytm.common.entity.events.CJREventsPricesModel;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;
import net.one97.paytm.o2o.events.R;
import net.one97.paytm.o2o.events.activity.EventOrderSummary;
import net.one97.paytm.o2o.events.d.a.b.c;
import net.one97.paytm.o2o.events.e.a;

public class EventOrderSummaryPriceView extends LinearLayout implements View.OnClickListener {
    private TextView A;
    private LinearLayout B;
    private LinearLayout C;
    private LinearLayout D;
    private RelativeLayout E;
    private TextView F;
    private TextView G;
    private boolean H;
    private double I;
    private RoboTextView J;
    private RoboTextView K;
    private boolean L = false;

    /* renamed from: a  reason: collision with root package name */
    public final Activity f73771a;

    /* renamed from: b  reason: collision with root package name */
    public final String f73772b;

    /* renamed from: c  reason: collision with root package name */
    public CJREventsConvenienceFee f73773c;

    /* renamed from: d  reason: collision with root package name */
    public RoboTextView f73774d;

    /* renamed from: e  reason: collision with root package name */
    private final c.a f73775e;

    /* renamed from: f  reason: collision with root package name */
    private Button f73776f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f73777g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f73778h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f73779i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private boolean m;
    private CJREventCancellationProtectDetail n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private LinearLayout r;
    private LinearLayout s;
    private RelativeLayout t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    private EventOrderSummaryPriceView(Activity activity, c.a aVar, String str) {
        super(activity);
        this.f73771a = activity;
        this.f73775e = aVar;
        this.f73772b = str;
        setHideButtons();
        inflate(this.f73771a, R.layout.layout_events_booking_review_and_pay_view, this);
        this.f73776f = (Button) findViewById(R.id.events_review_and_pay_button);
        this.f73776f.setOnClickListener(this);
        this.o = (LinearLayout) findViewById(R.id.root_ticket_breakup);
        this.p = (LinearLayout) findViewById(R.id.root_food_breakup);
        this.q = (LinearLayout) findViewById(R.id.root_merchandise_breakup);
        this.r = (LinearLayout) findViewById(R.id.root_delivery_breakup);
        this.s = (LinearLayout) findViewById(R.id.root_other_charges);
        this.f73774d = (RoboTextView) findViewById(R.id.paytm_booking_id);
        this.u = (TextView) findViewById(R.id.label_ticket);
        this.v = (TextView) findViewById(R.id.label_food);
        this.w = (TextView) findViewById(R.id.label_merchandise);
        this.x = (TextView) findViewById(R.id.label_delivery);
        this.y = (TextView) findViewById(R.id.label_convenience_fee);
        this.A = (TextView) findViewById(R.id.delivery_fee_charges);
        this.B = (LinearLayout) findViewById(R.id.root_ticket_item_breakup);
        this.C = (LinearLayout) findViewById(R.id.root_food_item_breakup);
        this.D = (LinearLayout) findViewById(R.id.root_merchandise_item_breakup);
        this.E = (RelativeLayout) findViewById(R.id.root_convenience_fee_item);
        this.K = (RoboTextView) findViewById(R.id.food_edit);
        this.K.setOnClickListener(this);
        this.J = (RoboTextView) findViewById(R.id.merchandise_edit);
        this.J.setOnClickListener(this);
        if (this.f73771a instanceof EventOrderSummary) {
            this.K.setVisibility(8);
            this.J.setVisibility(8);
        }
        this.z = (TextView) findViewById(R.id.convenience_fee_charges);
        this.t = (RelativeLayout) findViewById(R.id.events_cancellation_fee_lyt);
        this.k = (TextView) findViewById(R.id.event_cancellation_fee_price);
        this.F = (TextView) findViewById(R.id.total_fare);
        this.G = (TextView) findViewById(R.id.label_total);
        this.f73778h = (RelativeLayout) findViewById(R.id.lyt_events_promo_applied);
        this.f73779i = (TextView) findViewById(R.id.txt_events_applied_promo_info);
        this.j = (TextView) findViewById(R.id.txt_events_cash_back_info);
        this.l = (ImageView) findViewById(R.id.img_events_remove_promo);
        this.l.setOnClickListener(this);
        if (this.m) {
            this.f73776f.setVisibility(8);
        }
        try {
            Window window = this.f73771a.getWindow();
            this.f73776f.getLocationOnScreen(new int[2]);
            Rect rect = new Rect();
            View decorView = window.getDecorView();
            decorView.getWindowVisibleDisplayFrame(rect);
            if ((decorView.getRootView().getHeight() - rect.bottom >= 200) && this.f73771a != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f73771a.getSystemService("input_method");
                if (inputMethodManager.isActive()) {
                    inputMethodManager.toggleSoftInput(1, 0);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static EventOrderSummaryPriceView a(Activity activity, c.a aVar, String str) {
        return new EventOrderSummaryPriceView(activity, aVar, str);
    }

    public void onClick(View view) {
        if (this.f73775e != null) {
            if (view.getId() == R.id.events_review_and_pay_button) {
                if (this.f73777g) {
                    this.f73777g = false;
                    if (a.a(getContext())) {
                    }
                }
            } else if (view.getId() == R.id.img_events_remove_promo) {
                Activity activity = this.f73771a;
                if (activity != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle(getResources().getString(R.string.remove_code_title));
                    builder.setMessage(getResources().getString(R.string.remove_code_msg));
                    builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            EventOrderSummaryPriceView.this.f73778h.setVisibility(8);
                        }
                    });
                    builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    builder.show();
                }
            } else if (view.getId() == R.id.image_quest_mrk) {
                a();
            } else if (view.getId() == R.id.convenience_fee_info) {
                try {
                    a((CJRTaxInfo) null, this.f73773c.getPrices().getGrandConvFee().getConvFeeBreakUp());
                } catch (Exception unused) {
                }
            } else if (view.getId() == R.id.ticket_info) {
                try {
                    a(this.f73773c.getPrices().getTicket().getBasePrice(), this.f73773c.getPrices().getTicket().getTaxBreakup());
                } catch (Exception unused2) {
                }
            } else if (view.getId() == R.id.food_info) {
                try {
                    a(this.f73773c.getPrices().getFnb().getBasePrice(), this.f73773c.getPrices().getFnb().getTaxBreakup());
                } catch (Exception unused3) {
                }
            } else if (view.getId() == R.id.merchandise_info) {
                try {
                    a(this.f73773c.getPrices().getMerchandise().getBasePrice(), this.f73773c.getPrices().getMerchandise().getTaxBreakup());
                } catch (Exception unused4) {
                }
            } else if (view.getId() != R.id.food_edit) {
                view.getId();
                int i2 = R.id.merchandise_edit;
            }
        }
    }

    public final void a(CJREventsConvenienceFee cJREventsConvenienceFee) {
        boolean z2 = true;
        this.f73777g = true;
        CJREventsPricesModel prices = cJREventsConvenienceFee.getPrices();
        if (prices != null) {
            try {
                if (prices.getTicket() != null) {
                    if (prices.getTicket().getItems() == null) {
                        return;
                    }
                    if (!prices.getTicket().getItems().isEmpty()) {
                        this.u.setText(prices.getTicket().getHeading());
                        Iterator<CJREventsItemDetail> it2 = prices.getTicket().getItems().iterator();
                        while (it2.hasNext()) {
                            CJREventsItemDetail next = it2.next();
                            View inflate = LayoutInflater.from(this.f73771a).inflate(R.layout.row_item_price_breakup_view, (ViewGroup) null);
                            TextView textView = (TextView) inflate.findViewById(R.id.row_item_label);
                            ((TextView) inflate.findViewById(R.id.row_item_price)).setText(this.f73771a.getString(R.string.rupees) + " " + (((double) next.getCount()) * next.getValuePerItem()));
                            String str = "Ticket";
                            if (next.getCount() > 1) {
                                str = "Tickets";
                            }
                            textView.setText(next.getCount() + str + " @ " + getContext().getString(R.string.rupees) + " " + next.getValuePerItem() + " per ticket");
                            this.B.addView(inflate);
                        }
                        this.o.setVisibility(0);
                        if (prices.getTicket().getTotalTax() != null && !TextUtils.isEmpty(prices.getTicket().getTotalTax().getValue()) && Double.parseDouble(prices.getTicket().getTotalTax().getValue()) > 0.0d) {
                            findViewById(R.id.ticket_info).setVisibility(0);
                            findViewById(R.id.ticket_info).setOnClickListener(this);
                        }
                    } else {
                        return;
                    }
                }
                if (prices.getFnb() != null) {
                    if (prices.getFnb().getItems() == null) {
                        return;
                    }
                    if (!prices.getFnb().getItems().isEmpty()) {
                        this.v.setText(prices.getFnb().getHeading());
                        Iterator<CJREventsItemDetail> it3 = prices.getFnb().getItems().iterator();
                        while (it3.hasNext()) {
                            CJREventsItemDetail next2 = it3.next();
                            View inflate2 = LayoutInflater.from(this.f73771a).inflate(R.layout.row_item_price_breakup_view, (ViewGroup) null);
                            ((TextView) inflate2.findViewById(R.id.row_item_label)).setText(next2.getLabel());
                            ((TextView) inflate2.findViewById(R.id.row_item_price)).setText(getContext().getString(R.string.rupees) + " " + b.x(String.valueOf(next2.getValue())));
                            this.C.addView(inflate2);
                        }
                        if (prices.getFnb().getTotalTax() != null && !TextUtils.isEmpty(prices.getFnb().getTotalTax().getValue()) && Double.parseDouble(prices.getFnb().getTotalTax().getValue()) > 0.0d) {
                            findViewById(R.id.food_info).setVisibility(0);
                            findViewById(R.id.food_info).setOnClickListener(this);
                        }
                        this.p.setVisibility(0);
                    } else {
                        return;
                    }
                }
                if (prices.getMerchandise() != null) {
                    if (prices.getMerchandise().getItems() == null) {
                        return;
                    }
                    if (!prices.getMerchandise().getItems().isEmpty()) {
                        this.w.setText(prices.getMerchandise().getHeading());
                        Iterator<CJREventsItemDetail> it4 = prices.getMerchandise().getItems().iterator();
                        while (it4.hasNext()) {
                            CJREventsItemDetail next3 = it4.next();
                            View inflate3 = LayoutInflater.from(this.f73771a).inflate(R.layout.row_item_price_breakup_view, (ViewGroup) null);
                            ((TextView) inflate3.findViewById(R.id.row_item_label)).setText(next3.getLabel());
                            ((TextView) inflate3.findViewById(R.id.row_item_price)).setText(getContext().getString(R.string.rupees) + " " + b.x(String.valueOf(next3.getValue())));
                            this.D.addView(inflate3);
                        }
                        if (prices.getMerchandise().getTotalTax() != null && !TextUtils.isEmpty(prices.getMerchandise().getTotalTax().getValue()) && Double.parseDouble(prices.getMerchandise().getTotalTax().getValue()) > 0.0d) {
                            findViewById(R.id.merchandise_info).setVisibility(0);
                            findViewById(R.id.merchandise_info).setOnClickListener(this);
                        }
                        this.q.setVisibility(0);
                    } else {
                        return;
                    }
                }
                if (prices.getDeliveryCharges() != null && !TextUtils.isEmpty(prices.getDeliveryCharges().getValue()) && Double.parseDouble(prices.getDeliveryCharges().getValue()) > 0.0d) {
                    this.x.setText(prices.getDeliveryCharges().getLabel());
                    this.A.setText(getContext().getString(R.string.rupees) + " " + b.x(prices.getDeliveryCharges().getValue()));
                    this.r.setVisibility(0);
                }
                if (!(prices.getGrandConvFee() == null || prices.getGrandConvFee().getConvFee() == null)) {
                    String value = prices.getGrandConvFee().getConvFee().getValue();
                    if (!TextUtils.isEmpty(value) && Double.parseDouble(value) > 0.0d) {
                        this.y.setText(prices.getGrandConvFee().getConvFee().getLabel());
                        this.z.setText(getContext().getString(R.string.rupees) + " " + b.x(prices.getGrandConvFee().getConvFee().getValue()));
                        if (prices.getGrandConvFee().getConvFeeBreakUp() != null && !prices.getGrandConvFee().getConvFeeBreakUp().isEmpty()) {
                            Iterator<CJRTaxInfo> it5 = prices.getGrandConvFee().getConvFeeBreakUp().iterator();
                            while (true) {
                                if (!it5.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                CJRTaxInfo next4 = it5.next();
                                if (!TextUtils.isEmpty(next4.getValue()) && Double.parseDouble(next4.getValue()) > 0.0d) {
                                    break;
                                }
                            }
                            if (z2) {
                                findViewById(R.id.convenience_fee_info).setVisibility(0);
                                findViewById(R.id.convenience_fee_info).setOnClickListener(this);
                            }
                        }
                        this.E.setVisibility(0);
                        this.s.setVisibility(0);
                    }
                }
                if (!this.H && this.E.getVisibility() != 0) {
                    this.s.setVisibility(8);
                }
                if (prices.getGrantTotal() != null) {
                    this.G.setText(prices.getGrantTotal().getLabel());
                    if (!TextUtils.isEmpty(prices.getGrantTotal().getValue())) {
                        this.I = Double.parseDouble(prices.getGrantTotal().getValue());
                        if (this.H && this.n != null && !TextUtils.isEmpty(this.n.getTotalPremium())) {
                            this.I += Double.parseDouble(this.n.getTotalPremium());
                        }
                        this.F.setText(getContext().getString(R.string.rupees) + " " + b.x(String.valueOf(this.I)));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void setHideButtons() {
        this.m = true;
    }

    public double getTotalFare() {
        return this.I;
    }

    public final void a(CJREventCancellationProtectDetail cJREventCancellationProtectDetail) {
        boolean z2;
        if (this.n == null) {
            this.n = cJREventCancellationProtectDetail;
        }
        this.H = true;
        CJREventCancellationProtectDetail cJREventCancellationProtectDetail2 = this.n;
        if (cJREventCancellationProtectDetail2 != null) {
            if (!TextUtils.isEmpty(cJREventCancellationProtectDetail2.getTotalPremium()) && Double.parseDouble(this.n.getTotalPremium()) > 0.0d) {
                this.k.setText(getContext().getString(R.string.rupees) + " " + b.x(String.valueOf(this.n.getTotalPremium())));
                if (this.n.getInsuranceTax() != null && !this.n.getInsuranceTax().isEmpty()) {
                    Iterator<CJRTaxInfo> it2 = this.n.getInsuranceTax().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = false;
                            break;
                        }
                        String value = it2.next().getValue();
                        if (!TextUtils.isEmpty(value) && Double.parseDouble(value) > 0.0d) {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        findViewById(R.id.image_quest_mrk).setVisibility(0);
                        findViewById(R.id.image_quest_mrk).setOnClickListener(this);
                    }
                }
                this.t.setVisibility(0);
            }
            this.I = getFinalPrice();
            String totalPremium = this.n.getTotalPremium();
            if (this.I > 0.0d && !TextUtils.isEmpty(totalPremium) && !this.L) {
                this.I += Double.parseDouble(totalPremium);
            }
            if (this.I > 0.0d) {
                this.F.setText(getContext().getString(R.string.rupees) + " " + b.x(String.valueOf(this.I)));
            }
            this.L = true;
        }
        b.x(String.valueOf(this.I));
    }

    private void a(CJRTaxInfo cJRTaxInfo, ArrayList<CJRTaxInfo> arrayList) {
        double d2;
        View inflate;
        View inflate2;
        if (this.f73773c != null) {
            AlertDialog create = new AlertDialog.Builder(this.f73771a).create();
            boolean z2 = false;
            ViewGroup viewGroup = null;
            View inflate3 = this.f73771a.getLayoutInflater().inflate(R.layout.dialog_price_break_up, (ViewGroup) null, false);
            LinearLayout linearLayout = (LinearLayout) inflate3.findViewById(R.id.root_items);
            if (cJRTaxInfo == null || (inflate2 = LayoutInflater.from(this.f73771a).inflate(R.layout.dialog_price_item_view, (ViewGroup) null, false)) == null || cJRTaxInfo == null) {
                d2 = 0.0d;
            } else {
                TextView textView = (TextView) inflate2.findViewById(R.id.row_item_label);
                if (!TextUtils.isEmpty(cJRTaxInfo.getLabel())) {
                    textView.setText(cJRTaxInfo.getLabel());
                }
                ((TextView) inflate2.findViewById(R.id.row_item_price)).setText(getContext().getString(R.string.rupees) + " " + b.x(cJRTaxInfo.getValue()));
                d2 = Double.parseDouble(cJRTaxInfo.getValue());
                linearLayout.addView(inflate2);
            }
            if (arrayList != null) {
                Iterator<CJRTaxInfo> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    CJRTaxInfo next = it2.next();
                    if (Double.parseDouble(next.getValue()) > 0.0d && (inflate = LayoutInflater.from(this.f73771a).inflate(R.layout.dialog_price_item_view, viewGroup, z2)) != null) {
                        TextView textView2 = (TextView) inflate.findViewById(R.id.row_item_label);
                        if (!TextUtils.isEmpty(next.getLabel())) {
                            textView2.setText(next.getLabel());
                        }
                        ((TextView) inflate.findViewById(R.id.row_item_price)).setText(getContext().getString(R.string.rupees) + " " + b.x(next.getValue()));
                        d2 += Double.parseDouble(next.getValue());
                        linearLayout.addView(inflate);
                    }
                    z2 = false;
                    viewGroup = null;
                }
            }
            ((TextView) inflate3.findViewById(R.id.label_total_price)).setText(getContext().getString(R.string.rupees) + " " + b.x(String.valueOf(d2)));
            create.setView(inflate3);
            create.setCancelable(true);
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
    }

    private void a() {
        View inflate;
        if (this.n != null) {
            AlertDialog create = new AlertDialog.Builder(this.f73771a).create();
            View inflate2 = this.f73771a.getLayoutInflater().inflate(R.layout.dialog_price_break_up, (ViewGroup) null, false);
            LinearLayout linearLayout = (LinearLayout) inflate2.findViewById(R.id.root_items);
            if (this.n.getInsuranceTax() != null && !this.n.getInsuranceTax().isEmpty()) {
                Iterator<CJRTaxInfo> it2 = this.n.getInsuranceTax().iterator();
                while (it2.hasNext()) {
                    CJRTaxInfo next = it2.next();
                    if (Double.parseDouble(next.getValue()) > 0.0d && (inflate = LayoutInflater.from(this.f73771a).inflate(R.layout.dialog_price_item_view, (ViewGroup) null, false)) != null) {
                        TextView textView = (TextView) inflate.findViewById(R.id.row_item_label);
                        if (!TextUtils.isEmpty(next.getLabel())) {
                            textView.setText(next.getLabel());
                        }
                        ((TextView) inflate.findViewById(R.id.row_item_price)).setText(getContext().getString(R.string.rupees) + " " + b.x(next.getValue()));
                        linearLayout.addView(inflate);
                    }
                }
            }
            if (!TextUtils.isEmpty(this.n.getTotalPremium()) && Double.parseDouble(this.n.getTotalPremium()) > 0.0d) {
                ((TextView) inflate2.findViewById(R.id.label_total_price)).setText(getContext().getString(R.string.rupees) + " " + b.x(this.n.getTotalPremium()));
            }
            create.setView(inflate2);
            create.setCancelable(true);
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
    }

    private double getFinalPrice() {
        CJREventsConvenienceFee cJREventsConvenienceFee = this.f73773c;
        if (cJREventsConvenienceFee == null || cJREventsConvenienceFee.getPrices() == null || this.f73773c.getPrices().getGrantTotal() == null || TextUtils.isEmpty(this.f73773c.getPrices().getGrantTotal().getValue())) {
            return 0.0d;
        }
        return Double.parseDouble(this.f73773c.getPrices().getGrantTotal().getValue());
    }
}
