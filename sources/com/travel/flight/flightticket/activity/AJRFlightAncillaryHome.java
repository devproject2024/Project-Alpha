package com.travel.flight.flightticket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.a;
import com.travel.flight.flightticket.fragment.b;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDetails;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody;
import com.travel.flight.utils.c;
import com.travel.utils.q;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;

public class AJRFlightAncillaryHome extends PaytmActivity implements View.OnClickListener, a {

    /* renamed from: a  reason: collision with root package name */
    CJRAncillaryDetails f24765a;

    /* renamed from: b  reason: collision with root package name */
    int f24766b = -1;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f24767c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f24768d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f24769e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f24770f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f24771g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f24772h;

    /* renamed from: i  reason: collision with root package name */
    private Double f24773i;
    private int j = 0;
    private int k = 1;

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.pre_f_ancillary_activity);
        this.f24766b = getIntent().getIntExtra("ancillaryType", -1);
        this.f24765a = (CJRAncillaryDetails) getIntent().getSerializableExtra("ancillary");
        this.f24767c = (ArrayList) getIntent().getSerializableExtra("paxinfo");
        this.f24773i = Double.valueOf(getIntent().getDoubleExtra(CJRQRScanResultModel.KEY_TOTAL_AMOUNT, 0.0d));
        ImageView imageView = (ImageView) findViewById(R.id.back_arrow);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView.setRotation(180.0f);
        imageView.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.txt_title);
        if (this.f24766b == 0) {
            textView.setText(getResources().getString(R.string.flight_add_baggage));
        } else {
            textView.setText(getResources().getString(R.string.flight_select_meal));
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().c(false);
        this.f24770f = (TextView) findViewById(R.id.proceed_to_book_btn);
        this.f24770f.setText(getResources().getString(R.string.done));
        findViewById(R.id.txt_review_see_details).setVisibility(8);
        this.f24770f.setOnClickListener(this);
        this.f24771g = (LinearLayout) findViewById(R.id.amount_detail);
        this.f24771g.setOnClickListener(this);
        this.f24772h = (TextView) findViewById(R.id.txt_review_booking_amnt);
        this.f24769e = (TextView) findViewById(R.id.txt_view_convfee_msg);
        this.f24768d = (RelativeLayout) findViewById(R.id.lyt_convfee_msg);
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("ancillary", this.f24765a);
        bundle2.putSerializable("paxinfo", this.f24767c);
        bundle2.putInt("ancillaryType", this.f24766b);
        b bVar = new b(this);
        bVar.setArguments(bundle2);
        getSupportFragmentManager().a().a(R.id.flight_fragment_container, bVar, "ancillaryBag").b();
        Double valueOf = Double.valueOf(0.0d);
        int i2 = this.f24766b;
        if (i2 == this.j) {
            if (CJRFlightAncillaryReqBody.getInstance().getmSelectedBaggageTotalAmount().doubleValue() > 0.0d) {
                valueOf = CJRFlightAncillaryReqBody.getInstance().getmSelectedBaggageTotalAmount();
                str = getResources().getString(R.string.flight_additional_baggage_added_for);
                b(String.format(str, new Object[]{c.a(valueOf.doubleValue())}), Double.valueOf(CJRFlightAncillaryReqBody.getInstance().getmSelectedBaggageTotalAmount().doubleValue() + CJRFlightAncillaryReqBody.getInstance().getmSelectedMealsTotalAmount().doubleValue()));
            }
        } else if (i2 == this.k && CJRFlightAncillaryReqBody.getInstance().getmSelectedMealsTotalAmount().doubleValue() > 0.0d) {
            str = getResources().getString(R.string.flight_meals_added_for);
            valueOf = CJRFlightAncillaryReqBody.getInstance().getmSelectedMealsTotalAmount();
            b(String.format(str, new Object[]{c.a(valueOf.doubleValue())}), Double.valueOf(CJRFlightAncillaryReqBody.getInstance().getmSelectedBaggageTotalAmount().doubleValue() + CJRFlightAncillaryReqBody.getInstance().getmSelectedMealsTotalAmount().doubleValue()));
        }
        str = "";
        b(String.format(str, new Object[]{c.a(valueOf.doubleValue())}), Double.valueOf(CJRFlightAncillaryReqBody.getInstance().getmSelectedBaggageTotalAmount().doubleValue() + CJRFlightAncillaryReqBody.getInstance().getmSelectedMealsTotalAmount().doubleValue()));
    }

    public void attachBaseContext(Context context) {
        q.a(context);
        q.c(context);
        com.travel.flight.b.a();
        super.attachBaseContext(com.travel.flight.b.b().d(context));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back_arrow) {
            setResult(0, new Intent());
            finish();
        } else if (id == R.id.proceed_to_book_btn) {
            setResult(-1, new Intent());
            finish();
        }
    }

    private void b(String str, Double d2) {
        if (TextUtils.isEmpty(str)) {
            this.f24768d.setVisibility(8);
        } else {
            this.f24768d.setVisibility(0);
            this.f24769e.setText(str);
        }
        Double valueOf = Double.valueOf(this.f24773i.doubleValue() + d2.doubleValue());
        TextView textView = this.f24772h;
        textView.setText(getResources().getString(R.string.rs_symbol) + c.a(valueOf.doubleValue()));
    }

    public final void a(String str, Double d2) {
        b(str, d2);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
