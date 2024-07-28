package com.travel.flight.flightorder.j;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.paytm.utility.b.b;
import com.travel.flight.R;
import com.travel.flight.activity.FlightWebViewActivity;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.f.a;
import com.travel.flight.pojo.flightticket.CJRFlightOrderSummaryResponse;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryCancallationProtect;

public final class b extends a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private CJRFlightOrderSummaryResponse f24431a;

    /* renamed from: b  reason: collision with root package name */
    private com.travel.flight.flightorder.g.a f24432b;

    /* renamed from: c  reason: collision with root package name */
    private Context f24433c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f24434d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f24435e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f24436f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f24437g;

    /* renamed from: h  reason: collision with root package name */
    private String f24438h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f24439i = "";
    private String j = "";
    private LinearLayout k;
    private View l;
    private View m;

    public final void onClick(View view) {
    }

    public b(View view, CJRFlightOrderSummaryResponse cJRFlightOrderSummaryResponse, com.travel.flight.flightorder.g.a aVar) {
        super(view);
        this.f24431a = cJRFlightOrderSummaryResponse;
        this.f24432b = aVar;
        this.f24433c = view.getContext();
        this.f24434d = (TextView) view.findViewById(R.id.flight_cancel_protect_order_status_title);
        this.l = view.findViewById(R.id.divider_flight_cancel_protect_header_footer);
        this.m = view.findViewById(R.id.lyt_container_insurance_card_footer);
        this.f24436f = (TextView) view.findViewById(R.id.flight_cancel_protect_order_status_msg);
        this.f24435e = (TextView) view.findViewById(R.id.flight_cancel_protect_order_status_msg_footer);
        this.f24437g = (ImageView) view.findViewById(R.id.flight_cancel_protect_order_status_icon);
        this.k = (LinearLayout) view.findViewById(R.id.lyt_container_insurance_card);
        a();
    }

    public final void a(b.C0467b bVar) {
        a();
    }

    private void a() {
        this.k.setVisibility(0);
        try {
            final CJROrderSummaryCancallationProtect cp_card = this.f24431a.getBody().getCp_card();
            String footer = cp_card.getFooter();
            if (!TextUtils.isEmpty(footer)) {
                this.f24435e.setText(footer);
                this.m.setVisibility(0);
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
                this.m.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cp_card.getHeader())) {
                String replace = cp_card.getHeader().replace(SimpleComparison.LESS_THAN_OPERATION, "").replace(SimpleComparison.GREATER_THAN_OPERATION, "");
                this.f24434d.setVisibility(0);
                if (cp_card.getLink() == null || !cp_card.getLink().equalsIgnoreCase(H5Logger.HEADER)) {
                    this.f24434d.setText(replace);
                } else {
                    this.f24434d.setText(a(replace, cp_card.getLink_string()), TextView.BufferType.SPANNABLE);
                    this.f24434d.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (!TextUtils.isEmpty(cp_card.getLink_url()) && URLUtil.isValidUrl(cp_card.getLink_url())) {
                                b.a(b.this, cp_card.getLink_url());
                            }
                        }
                    });
                }
            }
            if (!TextUtils.isEmpty(cp_card.getMessage())) {
                String replace2 = cp_card.getMessage().replace(SimpleComparison.LESS_THAN_OPERATION, "").replace(SimpleComparison.GREATER_THAN_OPERATION, "");
                if (cp_card.getLink() == null || TextUtils.isEmpty(cp_card.getLink()) || !cp_card.getLink().equalsIgnoreCase("message")) {
                    this.f24436f.setText(replace2);
                } else {
                    this.f24436f.setText(a(replace2, cp_card.getLink_string()), TextView.BufferType.SPANNABLE);
                    this.f24436f.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (!TextUtils.isEmpty(cp_card.getLink_url()) && URLUtil.isValidUrl(cp_card.getLink_url())) {
                                b.a(b.this, cp_card.getLink_url());
                            }
                        }
                    });
                }
            }
            if (TextUtils.isEmpty(cp_card.getImg_url()) || !URLUtil.isValidUrl(cp_card.getImg_url())) {
                this.f24437g.setVisibility(8);
                return;
            }
            b.a.C0750a a2 = com.paytm.utility.b.b.a(this.f24433c);
            a2.f43753a = cp_card.getImg_url();
            b.a.C0750a.a(a2.a((Object) 17170445), this.f24437g, (com.paytm.utility.b.b.b) null, 2);
        } catch (Exception unused) {
        }
    }

    private static SpannableString a(String str, String str2) {
        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str.indexOf(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00baf2")), indexOf, str2.length() + indexOf, 33);
        }
        return spannableString;
    }

    static /* synthetic */ void a(b bVar, String str) {
        Intent intent = new Intent(bVar.f24433c, FlightWebViewActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "");
        bVar.f24433c.startActivity(intent);
    }
}
