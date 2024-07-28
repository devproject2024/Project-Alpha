package com.travel.flight.flightorder.j;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.flightorder.activity.FlightOrderSummary;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.f.a;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import com.travel.utils.n;
import java.util.ArrayList;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryItems;
import net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryCashbackCard;

public final class i extends a {

    /* renamed from: a  reason: collision with root package name */
    Context f24513a;

    /* renamed from: b  reason: collision with root package name */
    private CJRFlightOrderSummaryResponse f24514b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f24515c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f24516d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f24517e;

    /* renamed from: f  reason: collision with root package name */
    private RoboTextView f24518f;

    /* renamed from: g  reason: collision with root package name */
    private RoboTextView f24519g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f24520h;

    /* renamed from: i  reason: collision with root package name */
    private FlightOrderSummary.a f24521i;

    public i(View view, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse, FlightOrderSummary.a aVar) {
        super(view);
        this.f24513a = view.getContext();
        this.f24521i = aVar;
        this.f24515c = (RoboTextView) view.findViewById(R.id.cashback_value);
        this.f24516d = (LinearLayout) view.findViewById(R.id.cashback_details_container);
        this.f24518f = (RoboTextView) view.findViewById(R.id.cashback_desc);
        this.f24519g = (RoboTextView) view.findViewById(R.id.header_value);
        this.f24514b = cJRFlightOrderSummaryResponse;
        this.f24520h = (LinearLayout) view.findViewById(R.id.promo_breakup_layout);
        this.f24517e = (RoboTextView) view.findViewById(R.id.wallet_statement);
        this.f24517e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                b.a();
                b.b().e(i.this.f24513a, intent);
            }
        });
    }

    public final void a(b.C0467b bVar) {
        CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse;
        if (this.f24513a != null && (cJRFlightOrderSummaryResponse = this.f24514b) != null && cJRFlightOrderSummaryResponse.getBody() != null && this.f24514b.getBody().getCashback_card() != null) {
            LinearLayout linearLayout = this.f24516d;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            CJROrderSummaryCashbackCard cashback_card = this.f24514b.getBody().getCashback_card();
            if (Build.VERSION.SDK_INT < 24) {
                this.f24515c.setText(Html.fromHtml(cashback_card.getHeader()));
                this.f24518f.setText(Html.fromHtml(cashback_card.getMessage()));
            } else {
                this.f24515c.setText(Html.fromHtml(cashback_card.getHeader(), 63));
                this.f24518f.setText(Html.fromHtml(cashback_card.getMessage(), 63));
            }
            int size = this.f24514b.getBody().getItems() != null ? this.f24514b.getBody().getItems().size() : 0;
            ArrayList<CJROrderSummaryItems> items = this.f24514b.getBody().getItems();
            LayoutInflater layoutInflater = (LayoutInflater) this.f24513a.getSystemService("layout_inflater");
            this.f24516d.removeAllViews();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                CJROrderSummaryItems cJROrderSummaryItems = items.get(i3);
                View inflate = layoutInflater.inflate(R.layout.pre_f_flight_cashback_breakup_item, (ViewGroup) null);
                if (cJROrderSummaryItems != null) {
                    ResourceUtils.loadFlightImagesFromCDN((ImageView) inflate.findViewById(R.id.iv_cashback_applied), "green_tick.png", false, false, n.a.V1);
                    if (!(cJROrderSummaryItems.getPax_info() == null || cJROrderSummaryItems.getPax_info().getTitle() == null || cJROrderSummaryItems.getPax_info().getName() == null)) {
                        ((RoboTextView) inflate.findViewById(R.id.fl_cb_item_name)).setText(v.a(cJROrderSummaryItems.getPax_info().getTitle(), " ", cJROrderSummaryItems.getPax_info().getName()));
                    }
                    if (cJROrderSummaryItems.getPaytm_cashback() != null) {
                        ((RoboTextView) inflate.findViewById(R.id.fl_cb_item_value)).setText(String.format(this.f24513a.getString(R.string.flight_amount_in_rupees), new Object[]{cJROrderSummaryItems.getPaytm_cashback()}));
                    }
                    if (cJROrderSummaryItems.getId() != null) {
                        ((RoboTextView) inflate.findViewById(R.id.cb_pax_sub_text)).setText(v.a(this.f24513a.getResources().getString(R.string.item_id), " ", AppConstants.COLON, " ", cJROrderSummaryItems.getId()));
                    }
                }
                if (cJROrderSummaryItems.getPaytm_cashback() != null && Double.compare(0.0d, Double.parseDouble(cJROrderSummaryItems.getPaytm_cashback())) < 0) {
                    i2++;
                    this.f24516d.addView(inflate);
                }
            }
            if (i2 <= 1) {
                this.f24520h.setVisibility(8);
                this.f24516d.setVisibility(8);
            }
            if (i2 == 0) {
                this.f24517e.setVisibility(8);
                this.f24520h.setVisibility(8);
            }
        }
    }
}
