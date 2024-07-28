package com.travel.flight.flightticket.c;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import com.paytm.utility.q;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.flightticket.d.c;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.flightticket.CJRConvenienceFee;
import com.travel.flight.pojo.flightticket.CJRConvenienceFeeDetail;
import com.travel.utils.n;
import java.util.Iterator;

public final class b extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f24851a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f24852b = ((TextView) findViewById(R.id.txt_flight_conv_fee_adult_text));

    /* renamed from: c  reason: collision with root package name */
    private TextView f24853c = ((TextView) findViewById(R.id.txt_flight_conv_fee_adult_price));

    /* renamed from: d  reason: collision with root package name */
    private TextView f24854d = ((TextView) findViewById(R.id.txt_flight_conv_fee_child_text));

    /* renamed from: e  reason: collision with root package name */
    private TextView f24855e = ((TextView) findViewById(R.id.txt_flight_conv_fee_child_price));

    /* renamed from: f  reason: collision with root package name */
    private TextView f24856f = ((TextView) findViewById(R.id.txt_flight_conv_fee_infant_text));

    /* renamed from: g  reason: collision with root package name */
    private TextView f24857g = ((TextView) findViewById(R.id.txt_flight_conv_fee_infant_price));

    /* renamed from: h  reason: collision with root package name */
    private TextView f24858h = ((TextView) findViewById(R.id.txt_flight_conv_fee_note));

    /* renamed from: i  reason: collision with root package name */
    private ImageView f24859i = ((ImageView) findViewById(R.id.image_view_conv_fee_details_close_button));
    /* access modifiers changed from: private */
    public k j;
    private CJRConvenienceFee k;
    private TableRow l;
    private TableRow m;
    private TableRow n;
    private TableRow o;

    public b(Context context, k kVar, CJRConvenienceFee cJRConvenienceFee) {
        super(context, 16973936);
        this.f24851a = context;
        getWindow().requestFeature(1);
        setContentView(R.layout.pre_f_flight_conv_fee_details);
        this.j = kVar;
        this.k = cJRConvenienceFee;
        ResourceUtils.loadFlightImagesFromCDN(this.f24859i, "close_icon.png", false, false, n.a.V1);
        this.f24859i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.j.reviewIternaryActionClick((String) null, (Intent) null, (Boolean) null, c.CONVENIENCE_FEE_DETAILS_CLOSE);
            }
        });
        if (this.k.getAdultDetail() != null) {
            CJRConvenienceFeeDetail adultDetail = this.k.getAdultDetail();
            this.f24852b.setText(a(adultDetail, "Adult"));
            TextView textView = this.f24853c;
            textView.setText(this.f24851a.getResources().getString(R.string.rs_symbol) + adultDetail.getmTotalConvFee());
        }
        if (this.k.getChildDetail() != null) {
            CJRConvenienceFeeDetail childDetail = this.k.getChildDetail();
            this.f24854d.setText(a(childDetail, "Child"));
            TextView textView2 = this.f24855e;
            textView2.setText(this.f24851a.getResources().getString(R.string.rs_symbol) + childDetail.getmTotalConvFee());
        } else {
            this.l = (TableRow) findViewById(R.id.table_row_child);
            this.l.setVisibility(8);
            this.m = (TableRow) findViewById(R.id.table_row_child_divider);
            this.m.setVisibility(8);
        }
        try {
            if (this.k.getInfantDetail() == null || TextUtils.isEmpty(this.k.getInfantDetail().getmTotalConvFee()) || Double.valueOf(this.k.getInfantDetail().getmTotalConvFee()).doubleValue() == 0.0d) {
                this.n = (TableRow) findViewById(R.id.table_row_infant);
                this.n.setVisibility(8);
                this.o = (TableRow) findViewById(R.id.table_row_infant_divider);
                this.o.setVisibility(8);
            } else {
                CJRConvenienceFeeDetail infantDetail = this.k.getInfantDetail();
                this.f24856f.setText(a(infantDetail, "Infant"));
                TextView textView3 = this.f24857g;
                textView3.setText(this.f24851a.getResources().getString(R.string.rs_symbol) + infantDetail.getmTotalConvFee());
            }
        } catch (Exception e2) {
            q.b("initViews" + e2.toString());
        }
        this.f24858h.setText(a());
    }

    private String a(CJRConvenienceFeeDetail cJRConvenienceFeeDetail, String str) {
        return this.f24851a.getResources().getString(R.string.rs_symbol) + cJRConvenienceFeeDetail.getmConvFee() + "/" + str + " X " + cJRConvenienceFeeDetail.getmPaxNumber();
    }

    private String a() {
        StringBuilder sb = new StringBuilder();
        if (this.k.getAdultDetail() != null) {
            Iterator<String> it2 = this.k.getAdultDetail().getMtext().iterator();
            while (it2.hasNext()) {
                sb.append("\n*");
                sb.append(it2.next());
            }
        }
        if (this.k.getChildDetail() != null) {
            Iterator<String> it3 = this.k.getChildDetail().getMtext().iterator();
            while (it3.hasNext()) {
                sb.append("\n*");
                sb.append(it3.next());
            }
        }
        if (this.k.getInfantDetail() != null) {
            Iterator<String> it4 = this.k.getInfantDetail().getMtext().iterator();
            while (it4.hasNext()) {
                sb.append("\n*");
                sb.append(it4.next());
            }
        }
        Iterator<String> it5 = this.k.getmNotes().iterator();
        while (it5.hasNext()) {
            sb.append("\n*");
            sb.append(it5.next());
        }
        return sb.toString();
    }
}
