package com.travel.flight.flightorder.j;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.paytm.utility.b.b;
import com.travel.flight.R;
import com.travel.flight.activity.AJREmbedWebView;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightticket.activity.AJRAncillaryOrderDetails;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytmflight.common.entity.flightticket.CJRAncillaryCard;

public final class a extends com.travel.flight.flightorder.f.a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    CJRFlightOrderSummaryResponse f24422a;

    /* renamed from: b  reason: collision with root package name */
    Context f24423b;

    /* renamed from: c  reason: collision with root package name */
    TextView f24424c;

    /* renamed from: d  reason: collision with root package name */
    TextView f24425d;

    /* renamed from: e  reason: collision with root package name */
    private String f24426e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f24427f;

    /* renamed from: g  reason: collision with root package name */
    private String f24428g;

    /* renamed from: h  reason: collision with root package name */
    private String f24429h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f24430i;
    private TextView j;
    private TextView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private String r = null;
    private View s;
    private View t;
    private View u;
    private View v;
    private View w;

    public a(View view, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse) {
        super(view);
        this.f24422a = cJRFlightOrderSummaryResponse;
        this.f24423b = view.getContext();
        this.w = view.findViewById(R.id.flight_ancillary_baggage);
        this.f24424c = (TextView) view.findViewById(R.id.ancillary_desc);
        this.f24425d = (TextView) view.findViewById(R.id.ancillary_title);
        this.f24430i = (ImageView) view.findViewById(R.id.flight_cancel_protect_order_status_icon);
        this.f24427f = (TextView) view.findViewById(R.id.ancillary_view);
        this.f24427f.setOnClickListener(this);
        this.s = view.findViewById(R.id.ancillary_baggage_meal_divider);
        this.v = view.findViewById(R.id.flight_ancillary_meal);
        this.j = (TextView) view.findViewById(R.id.ancillary_meal_title);
        this.k = (TextView) view.findViewById(R.id.ancillary_meal_desc);
        this.l = (ImageView) view.findViewById(R.id.flight_ancillarymeal_icon);
        this.m = (TextView) view.findViewById(R.id.ancillary_meal_view);
        this.m.setOnClickListener(this);
        this.t = view.findViewById(R.id.ancillary_meal_insurance_divider);
        this.u = view.findViewById(R.id.flight_ancillary_insurance);
        this.n = (TextView) view.findViewById(R.id.ancillary_insurance_view);
        TextView textView = this.n;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        this.p = (TextView) view.findViewById(R.id.ancillary_insurance_title);
        this.o = (TextView) view.findViewById(R.id.ancillary_insurance_desc);
        this.q = (ImageView) view.findViewById(R.id.flight_ancillaryinsurance_icon);
    }

    public final void a(b.C0467b bVar) {
        CJRAncillaryCard addon_travel_ins_card;
        a("Baggage", this.f24430i, this.w);
        this.f24424c.setText(this.f24429h);
        this.f24425d.setText(this.f24428g + " ");
        if (!TextUtils.isEmpty(this.f24426e)) {
            this.f24427f.setText(this.f24426e);
        }
        boolean z = true;
        boolean z2 = this.w.getVisibility() == 0;
        a("Meal", this.l, this.v);
        this.j.setText(this.f24428g);
        this.k.setText(this.f24429h);
        if (!TextUtils.isEmpty(this.f24426e)) {
            this.m.setText(this.f24426e);
        }
        boolean z3 = this.v.getVisibility() == 0;
        if (z2 && z3) {
            this.s.setVisibility(0);
        }
        View view = this.u;
        try {
            if (!(this.f24422a == null || (addon_travel_ins_card = this.f24422a.getBody().getAddon_travel_ins_card()) == null)) {
                this.f24428g = addon_travel_ins_card.getHeader();
                this.f24429h = addon_travel_ins_card.getMessage();
                a(addon_travel_ins_card.getImg_url(), this.q, this.f24423b);
                this.n.setText(addon_travel_ins_card.getLink_string());
                this.p.setText(this.f24428g);
                String str = this.f24429h;
                this.o.setText(Html.fromHtml(str.replace(SimpleComparison.LESS_THAN_OPERATION + addon_travel_ins_card.getLink_string() + SimpleComparison.GREATER_THAN_OPERATION, "<font color='#00baf2'>" + addon_travel_ins_card.getLink_string() + "</font>.")), TextView.BufferType.SPANNABLE);
                this.o.setOnClickListener(this);
                this.r = addon_travel_ins_card.getLink_url();
                view.setVisibility(0);
            }
        } catch (Exception unused) {
        }
        if (this.u.getVisibility() != 0) {
            z = false;
        }
        if ((z && z3) || (z && z2)) {
            this.t.setVisibility(0);
        }
    }

    public final void onClick(View view) {
        String str;
        if (view.getId() == R.id.ancillary_view || view.getId() == R.id.ancillary_meal_view) {
            Intent intent = new Intent(this.f24423b, AJRAncillaryOrderDetails.class);
            intent.putExtra("orderSummary", this.f24422a);
            this.f24423b.startActivity(intent);
        } else if (view.getId() == R.id.ancillary_insurance_desc && (str = this.r) != null) {
            Intent intent2 = new Intent(this.f24423b, AJREmbedWebView.class);
            intent2.putExtra("url", str);
            intent2.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "");
            this.f24423b.startActivity(intent2);
        }
    }

    private void a(String str, ImageView imageView, View view) {
        try {
            for (CJRAncillaryCard next : this.f24422a.getBody().getAncillary_card()) {
                if (next.getType().equalsIgnoreCase(str)) {
                    this.f24428g = next.getMessage();
                    this.f24429h = next.getFooter();
                    this.f24426e = next.getLink_string();
                    a(next.getImg_url(), imageView, this.f24423b);
                    view.setVisibility(0);
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void a(String str, ImageView imageView, Context context) {
        try {
            if (URLUtil.isValidUrl(str)) {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(context);
                a2.f43753a = str;
                b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
            }
        } catch (Exception unused) {
        }
    }
}
