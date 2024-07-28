package com.travel.flight.seatancillary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.b.b;
import com.paytm.utility.h;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.b;
import com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRComboSeat;
import com.travel.flight.pojo.model.CJRSeatSelection;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatAvailability;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatAncillaryCombinedModel;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatJourneyType;
import com.travel.flight.seatancillary.b.a;
import com.travel.utils.n;
import com.travel.utils.q;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.util.GAConstants;

public class AJRSeatAncillaryActivity extends PaytmActivity implements View.OnClickListener, a.C0476a, a.d {

    /* renamed from: a  reason: collision with root package name */
    private a.c f25444a;

    /* renamed from: b  reason: collision with root package name */
    private LottieAnimationView f25445b;

    /* renamed from: c  reason: collision with root package name */
    private TabLayout f25446c;

    /* renamed from: d  reason: collision with root package name */
    private a f25447d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager f25448e;

    /* renamed from: f  reason: collision with root package name */
    private CJRSeatAncillaryCombinedModel f25449f = null;

    /* renamed from: g  reason: collision with root package name */
    private CJRSeatAvailability f25450g = null;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, String> f25451h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private CJRTravellerSeatTransition f25452i;
    private RelativeLayout j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private RelativeLayout r;
    private CJRComboSeat[] s;
    private boolean t;
    private boolean u = false;
    private TextView v;
    private TextView w;
    private boolean x = false;

    public void attachBaseContext(Context context) {
        b.a();
        super.attachBaseContext(b.b().d(context));
        q.a(this);
    }

    public void onResume() {
        super.onResume();
        q.a(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_f_activity_seatancillary_flight);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("requestid")) {
                this.f25451h.put("requestid", intent.getStringExtra("requestid"));
            }
            if (intent.hasExtra("onward_flightid")) {
                this.f25451h.put("onward_flightid", intent.getStringExtra("onward_flightid"));
            }
            if (intent.hasExtra("onward_provider")) {
                this.f25451h.put("onward_provider", intent.getStringExtra("onward_provider"));
            }
            if (intent.hasExtra("return_flightid")) {
                this.f25451h.put("return_flightid", intent.getStringExtra("return_flightid"));
            }
            if (intent.hasExtra("return_provider")) {
                this.f25451h.put("return_provider", intent.getStringExtra("return_provider"));
            }
            if (intent.hasExtra("extra_intent_travellers_list")) {
                this.f25452i = (CJRTravellerSeatTransition) intent.getSerializableExtra("extra_intent_travellers_list");
            }
            if (intent.hasExtra("extra_intent_seat_popup_info") && intent.getSerializableExtra("extra_intent_seat_popup_info") != null) {
                this.s = (CJRComboSeat[]) intent.getSerializableExtra("extra_intent_seat_popup_info");
            }
            if (intent.hasExtra("proceed_to_pay")) {
                this.x = intent.getBooleanExtra("proceed_to_pay", false);
            }
        }
        this.f25444a = new g(this);
        ImageView imageView = (ImageView) findViewById(R.id.back_arrow);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView.setRotation(180.0f);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRSeatAncillaryActivity.this.finish();
            }
        });
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().c(false);
        ((TextView) findViewById(R.id.text)).setText(getString(R.string.select_seat_flight));
        this.j = (RelativeLayout) findViewById(R.id.bottom_lyt);
        this.j.setVisibility(8);
        this.k = (TextView) findViewById(R.id.done_btn);
        this.k.setOnClickListener(this);
        this.l = (TextView) findViewById(R.id.txt_header);
        this.m = (TextView) findViewById(R.id.txt_seat_amnt);
        this.f25445b = (LottieAnimationView) findViewById(R.id.seatancillary_progress);
        this.f25446c = (TabLayout) findViewById(R.id.seatancillary_hop_view_pager_tab);
        this.f25448e = (ViewPager) findViewById(R.id.pager_fligt_seat_ancillary_base);
        this.f25444a.a(this.f25451h);
        this.r = (RelativeLayout) findViewById(R.id.spiceMaxCL);
        this.p = (ImageView) findViewById(R.id.closeBox);
        this.p.setOnClickListener(this);
        this.n = (TextView) findViewById(R.id.title);
        this.q = (ImageView) findViewById(R.id.spiceMaxIcon);
        this.o = (TextView) findViewById(R.id.desc);
        this.v = (TextView) findViewById(R.id.sub_heading);
        this.w = (TextView) findViewById(R.id.skip_seatselection);
        this.w.setOnClickListener(this);
        ResourceUtils.loadFlightImagesFromCDN(this.p, "close_icon.png", false, false, n.a.V1);
    }

    public final void g() {
        a(this.f25445b, true);
    }

    public final void h() {
        a(this.f25445b, false);
    }

    public final void a(CJRSeatAncillaryCombinedModel cJRSeatAncillaryCombinedModel) {
        this.f25449f = cJRSeatAncillaryCombinedModel;
    }

    public final void a(CJRSeatAvailability cJRSeatAvailability) {
        this.f25450g = cJRSeatAvailability;
        CJRSeatAncillaryCombinedModel cJRSeatAncillaryCombinedModel = this.f25449f;
        CJRSeatAvailability cJRSeatAvailability2 = this.f25450g;
        if (cJRSeatAncillaryCombinedModel != null && cJRSeatAvailability2 != null && cJRSeatAncillaryCombinedModel.getCJRSeatBody() != null && cJRSeatAncillaryCombinedModel.getCJRSeatBody().getOnward() != null && cJRSeatAvailability2.getCJRSeatBody() != null && cJRSeatAvailability2.getCJRSeatBody().getOnward() != null && cJRSeatAncillaryCombinedModel.getCJRSeatBody().getOnward().size() == cJRSeatAvailability2.getCJRSeatBody().getOnward().size()) {
            this.u = com.travel.flight.seatancillary.c.a.updateTravellerSeatTransitionList(this.f25452i);
            this.f25447d = new a(getSupportFragmentManager(), cJRSeatAncillaryCombinedModel.getCJRSeatBody().getOnward(), cJRSeatAvailability2.getCJRSeatBody().getOnward(), this.f25452i, this, cJRSeatAvailability2.getCJRSeatBody().getCJRSeatNotes());
            this.f25448e.setAdapter(this.f25447d);
            this.f25446c.setupWithViewPager(this.f25448e);
            if (cJRSeatAncillaryCombinedModel.getCJRSeatBody().getOnward().size() > 1) {
                this.f25446c.setVisibility(0);
            } else {
                this.f25446c.setVisibility(8);
            }
            for (CJRSeatJourneyType next : cJRSeatAvailability2.getCJRSeatBody().getOnward()) {
                this.t = next.isCombinationAvailable();
                if (next.isCombinationAvailable()) {
                    CJRComboSeat[] cJRComboSeatArr = this.s;
                    ImageView imageView = this.q;
                    TextView textView = this.n;
                    if (cJRComboSeatArr == null || cJRComboSeatArr.length == 0 || TextUtils.isEmpty(cJRComboSeatArr[0].getSection_heading()) || !this.t) {
                        this.r.setVisibility(8);
                        return;
                    }
                    this.r.setVisibility(0);
                    b.a.C0750a a2 = com.paytm.utility.b.b.a(imageView.getContext());
                    a2.f43753a = cJRComboSeatArr[0].getIcon();
                    b.a.C0750a.a(a2, imageView, (com.paytm.utility.b.b.b) null, 2);
                    textView.setText(cJRComboSeatArr[0].getSection_heading());
                    StringBuilder sb = new StringBuilder();
                    for (String str : cJRComboSeatArr[0].getDescription()) {
                        sb.append("● " + str + "\t\t");
                    }
                    if (!TextUtils.isEmpty(cJRComboSeatArr[0].getSub_heading())) {
                        this.v.setText(cJRComboSeatArr[0].getSub_heading());
                        this.v.setVisibility(0);
                    } else {
                        this.v.setVisibility(8);
                    }
                    this.o.setText(sb.toString());
                    return;
                }
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        b bVar = new b();
        if (networkCustomError.networkResponse != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    bVar = (b) new f().a(new String(networkResponse.data), bVar.getClass());
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        String alertTitle = networkCustomError.getAlertTitle();
        String alertMessage = networkCustomError.getAlertMessage();
        if (!(bVar == null || bVar.getStatus() == null || bVar.getStatus().getMessage() == null || TextUtils.isEmpty(bVar.getStatus().getMessage().f25473a) || TextUtils.isEmpty(bVar.getStatus().getMessage().f25474b))) {
            alertTitle = bVar.getStatus().getMessage().f25473a;
            alertMessage = bVar.getStatus().getMessage().f25474b;
        }
        a(alertTitle, alertMessage);
    }

    public final void b(NetworkCustomError networkCustomError) {
        b bVar = new b();
        if (networkCustomError.networkResponse != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    bVar = (b) new f().a(new String(networkResponse.data), bVar.getClass());
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        String alertTitle = networkCustomError.getAlertTitle();
        String alertMessage = networkCustomError.getAlertMessage();
        if (!(bVar == null || bVar.getStatus() == null || bVar.getStatus().getMessage() == null || TextUtils.isEmpty(bVar.getStatus().getMessage().f25473a) || TextUtils.isEmpty(bVar.getStatus().getMessage().f25474b))) {
            alertTitle = bVar.getStatus().getMessage().f25473a;
            alertMessage = bVar.getStatus().getMessage().f25474b;
        }
        a(alertTitle, alertMessage);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f25444a.a();
        this.f25444a = null;
    }

    public final void a(com.travel.flight.pojo.seatancillaryentity.b bVar) {
        this.r.setVisibility(8);
        if (this.f25452i.getOnwardSeatSelections() != null) {
            for (int i2 = 0; i2 < this.f25452i.getOnwardSeatSelections().size(); i2++) {
                CJRSeatSelection cJRSeatSelection = this.f25452i.getOnwardSeatSelections().get(i2);
                if (com.travel.flight.seatancillary.c.a.isHopMatched(bVar.getFlightNumber(), bVar.getOrigin(), bVar.getDestination(), cJRSeatSelection)) {
                    com.travel.flight.seatancillary.c.a.updateSeatValues(cJRSeatSelection, bVar, true);
                    a(cJRSeatSelection, true);
                }
            }
        }
    }

    public final void b(com.travel.flight.pojo.seatancillaryentity.b bVar) {
        this.r.setVisibility(8);
        if (this.f25452i.getOnwardSeatSelections() != null && bVar != null) {
            for (int i2 = 0; i2 < this.f25452i.getOnwardSeatSelections().size(); i2++) {
                CJRSeatSelection cJRSeatSelection = this.f25452i.getOnwardSeatSelections().get(i2);
                if (cJRSeatSelection != null && com.travel.flight.seatancillary.c.a.isHopMatched(bVar.getFlightNumber(), bVar.getOrigin(), bVar.getDestination(), cJRSeatSelection)) {
                    com.travel.flight.seatancillary.c.a.updateSeatValues(cJRSeatSelection, bVar, false);
                    a(cJRSeatSelection, true);
                }
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    private void a(CJRSeatSelection cJRSeatSelection, boolean z) {
        if (com.travel.flight.seatancillary.c.a.isSelectionCountCriteriaPassed(this.f25452i) || (this.u && com.travel.flight.seatancillary.c.a.getTotalSelectedSeatsCount(this.f25452i) == 0)) {
            a(true, cJRSeatSelection, z);
        } else {
            a(false, cJRSeatSelection, z);
        }
    }

    private void a(boolean z, CJRSeatSelection cJRSeatSelection, boolean z2) {
        if (z) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
        if (z2) {
            a(cJRSeatSelection.getmFlightNumber(), cJRSeatSelection.getmOrigin(), cJRSeatSelection.getmDestination(), true);
        }
    }

    private void a(String str, String str2, String str3, boolean z) {
        ViewPager viewPager;
        double d2 = 0.0d;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f25452i.getOnwardSeatSelections().size(); i4++) {
            CJRSeatSelection cJRSeatSelection = this.f25452i.getOnwardSeatSelections().get(i4);
            if (cJRSeatSelection != null && com.travel.flight.seatancillary.c.a.isHopMatched(str, str2, str3, cJRSeatSelection)) {
                if (z) {
                    a(cJRSeatSelection, false);
                }
                i2 += this.f25452i.getOnwardSeatSelections().get(i4).getmSeatSelectedItems().size();
                i3 += this.f25452i.getOnwardSeatSelections().get(i4).getmSelectedSeatsCount();
                d2 += this.f25452i.getOnwardSeatSelections().get(i4).getmTotalSeatPrice();
            }
        }
        e eVar = null;
        if (this.f25447d != null && (viewPager = this.f25448e) != null && viewPager.getCurrentItem() >= 0 && this.f25447d.f25461a.size() > this.f25448e.getCurrentItem()) {
            eVar = (e) this.f25447d.f25461a.get(this.f25448e.getCurrentItem());
        }
        if (eVar != null && !TextUtils.isEmpty(eVar.r) && eVar.r.equalsIgnoreCase(str)) {
            this.l.setText(i3 + " of " + i2 + " Seats Selected");
            TextView textView = this.m;
            StringBuilder sb = new StringBuilder();
            sb.append((int) d2);
            textView.setText(sb.toString());
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.done_btn) {
            Intent intent = new Intent();
            intent.putExtra("extra_intent_travellers_list", this.f25452i);
            intent.putExtra("proceed_to_pay", this.x);
            setResult(-1, intent);
            finish();
        } else if (view.getId() == R.id.closeBox) {
            this.r.setVisibility(8);
        } else if (view.getId() == R.id.skip_seatselection) {
            Intent intent2 = new Intent();
            intent2.putExtra(GAConstants.ACTION.SKIP_CLICKED, true);
            intent2.putExtra("proceed_to_pay", this.x);
            setResult(-1, intent2);
            finish();
        }
    }

    private void a(String str, String str2) {
        if (!isFinishing()) {
            final h hVar = new h(this);
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.setCancelable(true);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(hVar.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.dismiss();
                    AJRSeatAncillaryActivity.this.finish();
                }
            });
            hVar.show();
            hVar.getWindow().setAttributes(layoutParams);
        }
    }

    private static void a(LottieAnimationView lottieAnimationView, boolean z) {
        if (z) {
            net.one97.paytm.common.widgets.a.a(lottieAnimationView);
        } else {
            net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        }
    }
}
