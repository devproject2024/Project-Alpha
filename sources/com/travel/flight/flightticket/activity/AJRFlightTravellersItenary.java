package com.travel.flight.flightticket.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.CJRIllegalCodeError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.activity.AJREmbedWebView;
import com.travel.flight.activity.FlightWebViewActivity;
import com.travel.flight.flightSRPV2.view.ui.activity.FlightSRPV2Activity;
import com.travel.flight.flightticket.a.m;
import com.travel.flight.flightticket.c.c;
import com.travel.flight.flightticket.e.a;
import com.travel.flight.flightticket.e.j;
import com.travel.flight.flightticket.f.d;
import com.travel.flight.flightticket.f.e;
import com.travel.flight.flightticket.f.h;
import com.travel.flight.flightticket.f.l;
import com.travel.flight.flightticket.fragment.g;
import com.travel.flight.pojo.flightticket.Ancillary.CJRAncillaryDetails;
import com.travel.flight.pojo.flightticket.Ancillary.CJRFlightAncillaryReprice;
import com.travel.flight.pojo.flightticket.Ancillary.request.CJRFlightAncillaryReqBody;
import com.travel.flight.pojo.flightticket.CJRFlightClientLoginPayload;
import com.travel.flight.pojo.flightticket.CJRFlightDetails;
import com.travel.flight.pojo.flightticket.CJRFlightPromoResponse;
import com.travel.flight.pojo.flightticket.CJRFlightSearchInput;
import com.travel.flight.pojo.flightticket.CJRFlightStops;
import com.travel.flight.pojo.flightticket.CJRRepriceFlightFare;
import com.travel.flight.pojo.flightticket.CJRStatus;
import com.travel.flight.pojo.flightticket.CJRTravellerDetails;
import com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesResponse;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel;
import com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicValidationAutoSuggest;
import com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo;
import com.travel.flight.pojo.model.CJRSeatSelectedItem;
import com.travel.flight.pojo.model.CJRSeatSelection;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatAvailability;
import com.travel.flight.pojo.seatancillaryentity.skeleton.CJRSeatAncillaryCombinedModel;
import com.travel.flight.seatancillary.AJRSeatAncillaryActivity;
import com.travel.flight.seatancillary.b.a;
import com.travel.flight.seatancillary.g;
import com.travel.flight.span.TopAlignProportionalSpan;
import com.travel.flight.travellerProfile.model.CJRTpDeleteResponse;
import com.travel.flight.travellerProfile.model.CJRTpUserProfileBody;
import com.travel.flight.tripsummary.AJRFlightConfirmation;
import com.travel.flight.tripsummary.c;
import com.travel.flight.utils.i;
import com.travel.flight.utils.j;
import com.travel.flight.views.FlightFareBreakupBottomSheetView;
import com.travel.utils.n;
import com.travel.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValidation;
import net.one97.paytmflight.common.entity.travel.CJRTpUserProfileContact;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRFlightTravellersItenary extends PaytmActivity implements View.OnClickListener, b, a.C0470a, d, e, h, l, a.d {
    private final int A = 6;
    private int B = -1;
    private Double C;
    private int D;
    private CJRGSTPassengerInfo E;
    private CJRFareRulesResponse F;
    private c G;
    private boolean H = false;
    private CJRTravellerSeatTransition I;
    private ImageView J;
    private Toolbar K;
    private boolean L = false;
    private FlightFareBreakupBottomSheetView M;
    private String N;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = false;

    /* renamed from: a  reason: collision with root package name */
    CJRAncillaryDetails f24799a = null;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f24800b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f24801c;

    /* renamed from: d  reason: collision with root package name */
    private CJRFlightDetails f24802d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f24803e;

    /* renamed from: f  reason: collision with root package name */
    private m f24804f;

    /* renamed from: g  reason: collision with root package name */
    private CJRFlightSearchInput f24805g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressDialog f24806h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f24807i;
    private TextView j;
    /* access modifiers changed from: private */
    public RelativeLayout k;
    private com.travel.flight.flightticket.g.e l;
    private ArrayList<CJRTravellerDetails> m = null;
    private String n;
    private CJRTpUserProfileContact o;
    private View p;
    private boolean q;
    private String r;
    private TextView s;
    private RelativeLayout t;
    /* access modifiers changed from: private */
    public RelativeLayout u;
    /* access modifiers changed from: private */
    public RelativeLayout v;
    private RelativeLayout w;
    private RelativeLayout x;
    private final int y = 4;
    private final int z = 5;

    public final void a(NetworkCustomError networkCustomError) {
    }

    public final void b(NetworkCustomError networkCustomError) {
    }

    public final void g() {
    }

    public final void h() {
    }

    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        setContentView(R.layout.pre_f_activity_flight_travellers_itenary);
        CJRFlightAncillaryReqBody.clear();
        this.l = new com.travel.flight.flightticket.g.e((com.travel.flight.flightticket.f.b) null);
        c.a aVar = com.travel.flight.tripsummary.c.n;
        c.a.a((Context) this);
        com.travel.flight.travellerProfile.a.a().f25524c.clear();
        boolean z2 = false;
        if (getIntent() != null) {
            if (getIntent().hasExtra("intent_extra_review_data")) {
                this.f24802d = (CJRFlightDetails) getIntent().getSerializableExtra("intent_extra_review_data");
            }
            if (getIntent().hasExtra("intent_extra_trip_type")) {
                this.f24803e = getIntent().getStringExtra("intent_extra_trip_type");
            }
            if (getIntent().hasExtra("intent_extra_search_input_data")) {
                this.f24805g = (CJRFlightSearchInput) getIntent().getSerializableExtra("intent_extra_search_input_data");
            }
            CJRFlightDetails cJRFlightDetails = this.f24802d;
            if (!(cJRFlightDetails == null || cJRFlightDetails.getmMetaDetails() == null)) {
                this.n = this.f24802d.getmMetaDetails().getmRequestId();
            }
            if (getIntent().hasExtra("acceptType")) {
                this.r = getIntent().getStringExtra("acceptType");
            }
            if (getIntent().hasExtra("isShare")) {
                this.L = getIntent().getBooleanExtra("isShare", false);
            }
            if (getIntent().hasExtra("intent_extra_flight_payment_intent")) {
                this.N = getIntent().getStringExtra("intent_extra_flight_payment_intent");
            }
            if (getIntent().hasExtra("intent_extra_flight_fare_rules")) {
                this.F = (CJRFareRulesResponse) getIntent().getSerializableExtra("intent_extra_flight_fare_rules");
            }
        }
        B();
        a("flights_traveler_details_page_load", b(CommonPayParams.Builder.YES));
        ImageView imageView = (ImageView) findViewById(R.id.back_arrow);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView.setRotation(180.0f);
        imageView.setColorFilter(androidx.core.content.b.c(this, R.color.white), PorterDuff.Mode.SRC_IN);
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.img_arrow);
        TextView textView = (TextView) findViewById(R.id.traveller_info);
        this.K = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.K);
        getSupportActionBar().c(false);
        TextView textView2 = (TextView) findViewById(R.id.source);
        TextView textView3 = (TextView) findViewById(R.id.destination);
        this.J = (ImageView) findViewById(R.id.background_image_view);
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
            getWindow().getDecorView().setSystemUiVisibility(1280);
            Toolbar toolbar = this.K;
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            toolbar.setPadding(0, identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0, 0, 0);
        }
        CJRFlightSearchInput cJRFlightSearchInput = this.f24805g;
        if (!(cJRFlightSearchInput == null || cJRFlightSearchInput.getDestination() == null || this.f24805g.getSource() == null)) {
            textView2.setText(this.f24805g.getSource().getCityName());
            textView3.setText(this.f24805g.getDestination().getCityName());
            if (this.f24803e.equals("round_trip")) {
                str = com.travel.flight.c.d.a.a(true, this.f24805g.getDate(), this.f24805g.getReturnDate());
                imageView2.setImageResource(R.drawable.pre_f_image_flight_rt_arrow_revamp);
            } else {
                str = com.travel.flight.c.d.a.a(false, this.f24805g.getDate(), this.f24805g.getReturnDate());
                imageView2.setImageResource(R.drawable.pre_f_image_flight_oneway_arrow_revamp);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str3 = "";
            if (this.f24805g.getmCount_adults() == 1) {
                str2 = str3 + ", " + this.f24805g.getmCount_adults() + " " + getString(R.string.adult);
            } else if (this.f24805g.getmCount_adults() > 1) {
                str2 = str3 + ", " + this.f24805g.getmCount_adults() + " " + getString(R.string.adults);
            } else {
                str2 = str3;
            }
            if (this.f24805g.getmCount_childerns() == 1) {
                str2 = str2 + ", " + this.f24805g.getmCount_childerns() + " " + getString(R.string.child);
            } else if (this.f24805g.getmCount_childerns() > 1) {
                str2 = str2 + ", " + this.f24805g.getmCount_childerns() + " " + getString(R.string.children);
            }
            if (this.f24805g.getmCount_infants() == 1) {
                str2 = str2 + ", " + this.f24805g.getmCount_infants() + " " + getString(R.string.infant);
            } else if (this.f24805g.getmCount_infants() > 1) {
                str2 = str2 + ", " + this.f24805g.getmCount_infants() + " " + getString(R.string.infants);
            }
            this.D = this.f24805g.getmCount_adults() + this.f24805g.getmCount_childerns() + this.f24805g.getmCount_infants();
            sb.append(str2);
            sb.append(", ");
            String classType = this.f24805g.getClassType();
            if ("E".equalsIgnoreCase(classType)) {
                str3 = getString(R.string.economy_flight);
            } else if ("B".equalsIgnoreCase(classType)) {
                str3 = getString(R.string.business);
            } else if (AppConstants.FEED_COMMUNITY_POST.equalsIgnoreCase(classType)) {
                str3 = getString(R.string.premium_economy);
            }
            sb.append(str3);
            textView.setText(sb.toString());
        }
        CJRFlightSearchInput cJRFlightSearchInput2 = this.f24805g;
        if (cJRFlightSearchInput2 != null && !TextUtils.isEmpty(cJRFlightSearchInput2.getDestCityCode())) {
            String replace = "http://assets.paytm.com/travel/flights/iata/v1/order_actions/small/DEFAULT.png".replace("DEFAULT", this.f24805g.getDestCityCode());
            b.a.C0750a a2 = com.paytm.utility.b.b.a(this);
            a2.f43753a = replace;
            b.a.C0750a b2 = a2.a((Object) getResources().getDrawable(R.drawable.pre_f_flight_review_iternary_default)).b(getResources().getDrawable(R.drawable.pre_f_flight_review_iternary_default));
            b2.m = true;
            b2.a(this.J);
        }
        this.f24807i = (TextView) findViewById(R.id.txt_review_booking_amnt);
        this.j = (TextView) findViewById(R.id.txt_review_see_details);
        findViewById(R.id.proceed_to_book_btn).setOnClickListener(this);
        findViewById(R.id.amount_detail).setOnClickListener(this);
        this.s = (TextView) findViewById(R.id.txt_view_convfee_msg);
        this.k = (RelativeLayout) findViewById(R.id.relative_review_payment_layout);
        this.k.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                ((RelativeLayout.LayoutParams) AJRFlightTravellersItenary.this.v.getLayoutParams()).setMargins(0, 0, 0, AJRFlightTravellersItenary.this.k.getHeight());
                AJRFlightTravellersItenary.this.k.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        this.u = (RelativeLayout) findViewById(R.id.lyt_flight_reprice_grey_bg);
        this.v = (RelativeLayout) findViewById(R.id.lyt_flight_fare_rules_grey_bg);
        this.t = (RelativeLayout) findViewById(R.id.lyt_dialog_student_animation);
        this.w = (RelativeLayout) findViewById(R.id.fare_rules_anim_layout);
        this.x = (RelativeLayout) findViewById(R.id.lyt_convfee_msg);
        findViewById(R.id.flight_share_icon).setOnClickListener(this);
        ImageView imageView3 = (ImageView) findViewById(R.id.back_arrow_mini_rule_rule);
        imageView3.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView3.setRotation(180.0f);
        imageView3.setOnClickListener(this);
        this.f24801c = (RecyclerView) findViewById(R.id.recycler_view_traveller_itinarary);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.f24801c.setLayoutManager(linearLayoutManager);
        k();
        CJRFlightDetails cJRFlightDetails2 = this.f24802d;
        String str4 = this.n;
        if (cJRFlightDetails2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("requestid", str4);
            if (cJRFlightDetails2.getmOnwardJourney() != null) {
                hashMap.put("onward_flightid", cJRFlightDetails2.getmOnwardJourney().getmFlightId());
                hashMap.put("onward_provider", cJRFlightDetails2.getmOnwardServiceProvider());
            }
            if (cJRFlightDetails2.getmReturnJourney() != null) {
                hashMap.put("return_flightid", cJRFlightDetails2.getmReturnJourney().getmFlightId());
                hashMap.put("return_provider", cJRFlightDetails2.getmReturnServiceProvider());
            }
            if (cJRFlightDetails2 != null) {
                if (cJRFlightDetails2.getmOnwardJourney() != null && cJRFlightDetails2.getmOnwardJourney().isSeatAncillaryEligible() && cJRFlightDetails2.getmReturnJourney() == null) {
                    z2 = true;
                } else if (cJRFlightDetails2.getmReturnJourney() != null) {
                    cJRFlightDetails2.getmReturnJourney().isSeatAncillaryEligible();
                }
            }
            if (z2) {
                new g(this).a((HashMap<String, String>) hashMap);
            }
        }
        this.M = (FlightFareBreakupBottomSheetView) findViewById(R.id.bottom_sheet);
        this.M.setupBehavior();
        this.M.setContext(this);
        this.M.setFlightDetails(this.f24802d);
        this.M.setSeatSelectionData(this.I);
        FlightFareBreakupBottomSheetView flightFareBreakupBottomSheetView = this.M;
        if (flightFareBreakupBottomSheetView != null) {
            CJRFareRulesResponse cJRFareRulesResponse = this.F;
            CJRFlightDetails cJRFlightDetails3 = this.f24802d;
            flightFareBreakupBottomSheetView.setData(cJRFareRulesResponse, cJRFlightDetails3, cJRFlightDetails3.getPromoResponse(), true);
        }
        a(j.MAIN);
    }

    public void attachBaseContext(Context context) {
        com.travel.flight.b.a();
        super.attachBaseContext(com.travel.flight.b.b().d(context));
        q.a(this);
    }

    public void onResume() {
        super.onResume();
        q.a(this);
    }

    private void k() {
        CJRFlightDetails cJRFlightDetails = this.f24802d;
        if (cJRFlightDetails != null) {
            this.f24804f = new m(this, cJRFlightDetails, this.f24803e, this.f24805g.getmCount_infants());
            this.f24801c.setAdapter(this.f24804f);
        }
        l();
    }

    /* access modifiers changed from: private */
    public void l() {
        int i2;
        String format = String.format(getResources().getString(R.string.flight_convenience_fee_args), new Object[]{String.valueOf(this.f24802d.getmConvenienceFee() != null ? com.travel.flight.utils.c.a(this.f24802d) : 0)});
        if (this.f24802d.isInsuranceCancelProtectApplied() && this.f24802d.isInsuranceApplied()) {
            String b2 = com.travel.flight.flightticket.g.e.b(this.f24802d);
            format = format + " " + String.format(getResources().getString(R.string.flight_traveller_screen_tool_tip_including_insurance), new Object[]{b2});
        } else if (this.f24802d.isInsuranceCancelProtectApplied()) {
            format = format + " " + String.format(getResources().getString(R.string.and_cancel_protect_tooltip), new Object[]{E()});
        } else if (this.f24802d.isInsuranceApplied()) {
            String b3 = com.travel.flight.flightticket.g.e.b(this.f24802d);
            format = format + " " + String.format(getResources().getString(R.string.flight_traveller_screen_tool_tip_including_insurance), new Object[]{b3});
        }
        this.s.setText(format);
        m();
        this.j.setVisibility(0);
        TextView textView = this.j;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.total_for_text));
        sb.append(" ");
        sb.append(this.D);
        sb.append(" ");
        if (this.D == 1) {
            i2 = R.string.traveler;
        } else {
            i2 = R.string.travelers;
        }
        sb.append(getString(i2));
        textView.setText(sb.toString());
        this.k.setVisibility(0);
    }

    private void m() {
        CJRFlightDetails cJRFlightDetails = this.f24802d;
        this.C = Double.valueOf(com.travel.flight.flightticket.g.e.a(cJRFlightDetails, cJRFlightDetails.isInsuranceApplied()) + CJRFlightAncillaryReqBody.getInstance().getmSelectedBaggageTotalAmount().doubleValue() + CJRFlightAncillaryReqBody.getInstance().getmSelectedMealsTotalAmount().doubleValue() + J());
        if (this.f24802d.getPromoResponse() == null || this.f24802d.getPromoResponse().getBody() == null || this.f24802d.getPromoResponse().getBody().getPaytmDiscount() <= 0) {
            this.f24807i.setText(com.travel.flight.utils.c.a(this.C.doubleValue()));
            return;
        }
        double doubleValue = this.C.doubleValue() - ((double) this.f24802d.getPromoResponse().getBody().getPaytmDiscount());
        String str = com.travel.flight.utils.c.a(doubleValue) + " " + getResources().getString(R.string.rupee_plain) + com.travel.flight.utils.c.a(this.C.doubleValue());
        int lastIndexOf = str.lastIndexOf(getResources().getString(R.string.rupee_plain));
        String h2 = com.travel.flight.utils.c.h(str);
        SpannableString spannableString = new SpannableString(h2);
        spannableString.setSpan(new CustomTypefaceSpan("", Typeface.create("sans-serif", 0)), 1, h2.length(), 33);
        spannableString.setSpan(new TopAlignProportionalSpan(0.5f), lastIndexOf, h2.length(), 33);
        spannableString.setSpan(new StrikethroughSpan(), lastIndexOf + 1, h2.length(), 33);
        this.f24807i.setText(spannableString);
    }

    private void n() {
        a(getResources().getString(R.string.pre_f_please_wait_progress_msg));
    }

    public final void a(String str, String str2, int i2, View view, boolean z2) {
        String str3;
        n();
        com.travel.flight.b.a();
        if (!com.travel.flight.b.b().b().isEmpty()) {
            com.travel.flight.b.a();
            str3 = com.travel.flight.b.b().b();
        } else {
            str3 = "";
        }
        if (str != null) {
            if (str2.contains(":query")) {
                str2 = str2.replace(":query", str.trim().replace(" ", "%20"));
            }
            str3 = str3 + str2 + "&type=" + this.r;
        }
        if (URLUtil.isValidUrl(str3) && com.paytm.utility.b.c((Context) this)) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = getApplicationContext();
            bVar.n = a.b.SILENT;
            bVar.o = "flight-traveller-itinerary";
            bVar.f42878b = a.c.FLIGHT;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = str3;
            bVar.f42881e = null;
            bVar.f42882f = null;
            bVar.f42883g = null;
            bVar.f42884h = null;
            bVar.f42885i = new CJRDynamicValidationAutoSuggest();
            bVar.j = new com.travel.flight.flightticket.e.a(this, i2, view, z2);
            bVar.t = A();
            com.paytm.network.a l2 = bVar.l();
            l2.a((Object) "NETWORK_TAG_TRAVELLER_ITINERARY");
            l2.a();
        }
    }

    public final void a(CJRTpUserProfileContact cJRTpUserProfileContact, View view) {
        n();
        this.p = view;
        this.o = cJRTpUserProfileContact;
        com.travel.flight.travellerProfile.a a2 = com.travel.flight.travellerProfile.a.a();
        if (a2.f25523b != null && a2.f25523b.size() > 0) {
            a2.f25523b.remove(cJRTpUserProfileContact);
        }
        com.travel.flight.b.a();
        String s2 = com.paytm.utility.b.s(this, com.travel.flight.b.b().L());
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        JSONObject a3 = com.travel.flight.utils.c.a((Context) this, cJRTpUserProfileContact);
        if (URLUtil.isValidUrl(s2)) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.FLIGHT;
            bVar.f42879c = a.C0715a.POST;
            bVar.n = a.b.SILENT;
            bVar.o = a2.getClass().getSimpleName();
            bVar.f42880d = s2;
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42884h = a3.toString();
            bVar.f42885i = new CJRTpDeleteResponse();
            bVar.j = this;
            bVar.t = com.travel.flight.travellerProfile.a.b();
            bVar.l().a();
        }
    }

    public final void a(Boolean bool, com.travel.flight.flightticket.d.c cVar) {
        switch (cVar) {
            case INSURANCE_CHECKBOX:
                if (!bool.booleanValue() || this.f24802d.getInsuranceData().getBody().getInsuranceDetail().get(0).isOptIn()) {
                    if (!bool.booleanValue()) {
                        this.f24802d.getInsuranceData().getBody().getInsuranceDetail().get(0).setOptIn(false);
                    }
                } else if (this.f24802d.getInsuranceData().getBody().getInsuranceDetail().get(0).isOne_way_international() && this.f24802d.getInsuranceData().getBody().getInsuranceDetail().get(0).getUserInputInfo() != null) {
                    a(j.DAYS);
                    return;
                }
                a(bool);
                return;
            case INSURANCE_TnC:
                if (this.f24802d.getInsuranceData() != null) {
                    String tnc = this.f24802d.getInsuranceData().getBody().getInsuranceDetail().get(0).getTnc();
                    String displayText = !TextUtils.isEmpty(this.f24802d.getInsuranceData().getBody().getInsuranceDetail().get(0).getDisplayText()) ? this.f24802d.getInsuranceData().getBody().getInsuranceDetail().get(0).getDisplayText() : "Terms and Conditions";
                    Intent intent = new Intent(this, AJREmbedWebView.class);
                    intent.putExtra("url", tnc);
                    intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, displayText);
                    startActivity(intent);
                    return;
                }
                return;
            case NAVIGATE_TO_TC:
                Intent intent2 = new Intent(this, FlightWebViewActivity.class);
                intent2.putExtra("url", "https://paytm.com/terms");
                startActivity(intent2);
                return;
            case CANCEL_PROTECT_INSURANCE_CHECKBOX:
                if (bool.booleanValue()) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("is_cancellation_protect_selected", CommonPayParams.Builder.YES);
                } else {
                    CJRFlightClientLoginPayload.getInstance().setEvent("is_cancellation_protect_selected", CommonPayParams.Builder.NO);
                }
                this.f24802d.setInsuranceCancelProtectApplied(bool.booleanValue());
                l();
                return;
            case CANCEL_PROTECT_TnC:
                if (this.f24802d.getInsuranceData() != null) {
                    String tnc2 = this.f24802d.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0).getTnc();
                    String addonType = this.f24802d.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0).getAddonType();
                    Intent intent3 = new Intent(this, AJREmbedWebView.class);
                    intent3.putExtra("url", tnc2);
                    intent3.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, addonType);
                    startActivity(intent3);
                    return;
                }
                return;
            case ANCILLARY_BUY_BAG:
                this.B = 0;
                a(false, false);
                return;
            case ANCILLARY_BUY_MEAL:
                this.B = 1;
                a(false, false);
                return;
            case ANCILLARY_SELECT_SEAT:
                a("seat_clicked", (HashMap<String, Object>) null);
                this.B = 2;
                a(false, false);
                return;
            default:
                return;
        }
    }

    private void a(Boolean bool) {
        if (bool.booleanValue()) {
            CJRFlightClientLoginPayload.getInstance().setEvent("is_travel_insurance_selected", CommonPayParams.Builder.YES);
        } else {
            CJRFlightClientLoginPayload.getInstance().setEvent("is_travel_insurance_selected", CommonPayParams.Builder.NO);
        }
        this.f24802d.setInsuranceApplied(bool.booleanValue());
        l();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            int r6 = r6.getId()
            int r0 = com.travel.flight.R.id.back_arrow
            if (r6 == r0) goto L_0x0172
            int r0 = com.travel.flight.R.id.back_arrow_mini_rule_rule
            if (r6 != r0) goto L_0x000e
            goto L_0x0172
        L_0x000e:
            int r0 = com.travel.flight.R.id.proceed_to_book_btn
            r1 = 0
            r2 = 1
            if (r6 != r0) goto L_0x0131
            java.util.HashMap r6 = r5.b((java.lang.String) r1)
            java.lang.String r0 = "travel_details_continue_clicked"
            a((java.lang.String) r0, (java.util.HashMap<java.lang.String, java.lang.Object>) r6)
            com.travel.flight.flightticket.a.m r6 = r5.f24804f
            boolean r6 = r6.b()
            r0 = 0
            if (r6 == 0) goto L_0x0111
            android.widget.RelativeLayout r6 = r5.w
            r1 = 8
            r6.setVisibility(r1)
            com.travel.flight.pojo.model.CJRTravellerSeatTransition r6 = r5.I
            if (r6 == 0) goto L_0x0060
            java.util.ArrayList r6 = r6.getOnwardSeatSelections()
            if (r6 == 0) goto L_0x0060
            r6 = 0
            r1 = 0
        L_0x003a:
            com.travel.flight.pojo.model.CJRTravellerSeatTransition r3 = r5.I
            java.util.ArrayList r3 = r3.getOnwardSeatSelections()
            int r3 = r3.size()
            if (r6 >= r3) goto L_0x0060
            com.travel.flight.pojo.model.CJRTravellerSeatTransition r3 = r5.I
            java.util.ArrayList r3 = r3.getOnwardSeatSelections()
            java.lang.Object r3 = r3.get(r6)
            com.travel.flight.pojo.model.CJRSeatSelection r3 = (com.travel.flight.pojo.model.CJRSeatSelection) r3
            if (r3 == 0) goto L_0x005d
            int r3 = r3.getmSelectedSeatsCount()
            int r1 = r1 + r3
            if (r1 <= 0) goto L_0x005d
            r6 = 1
            goto L_0x0061
        L_0x005d:
            int r6 = r6 + 1
            goto L_0x003a
        L_0x0060:
            r6 = 0
        L_0x0061:
            if (r6 == 0) goto L_0x0067
            r5.a((boolean) r2, (boolean) r2)
            return
        L_0x0067:
            boolean r6 = r5.P
            if (r6 == 0) goto L_0x010d
            boolean r6 = r5.Q
            if (r6 == 0) goto L_0x010d
            boolean r6 = r5.R
            if (r6 != 0) goto L_0x010d
            android.widget.RelativeLayout r6 = r5.v
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x007e
            r5.D()
        L_0x007e:
            boolean r6 = r5.q
            if (r6 == 0) goto L_0x008f
            boolean r6 = r5.u()
            if (r6 == 0) goto L_0x008f
            com.travel.flight.flightticket.a.m r6 = r5.f24804f
            boolean r6 = r6.a()
            goto L_0x0090
        L_0x008f:
            r6 = 1
        L_0x0090:
            com.travel.flight.flightticket.a.m r1 = r5.f24804f
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x009c
            if (r6 == 0) goto L_0x009c
            r6 = 1
            goto L_0x009d
        L_0x009c:
            r6 = 0
        L_0x009d:
            com.travel.flight.flightticket.a.m r3 = r5.f24804f
            boolean r3 = r3.c()
            r6 = r6 & r3
            if (r6 == 0) goto L_0x00ea
            com.travel.flight.flightticket.a.m r6 = r5.f24804f
            java.util.ArrayList r6 = r6.d()
            r5.m = r6
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r5.f24802d
            com.travel.flight.pojo.flightticket.CJRFlightDetails$JourneyDetails r6 = r6.getJourneyDetails()
            com.travel.flight.flightticket.a.m r1 = r5.f24804f
            com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPassenger r1 = r1.e()
            r6.setGstObject(r1)
            com.travel.flight.flightticket.a.m r6 = r5.f24804f
            com.travel.flight.pojo.flightticket.paxinfo.CJRGSTPassengerInfo r6 = r6.i()
            r5.E = r6
            r5.s()
            boolean r6 = r5.v()
            if (r6 == 0) goto L_0x00de
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r5.f24802d
            com.travel.flight.pojo.flightticket.CJRMeta r6 = r6.getMeta()
            java.util.ArrayList r6 = r6.getmStudentVisaPopup()
            if (r6 == 0) goto L_0x00de
            r5.y()
            goto L_0x0107
        L_0x00de:
            boolean r6 = r5.w()
            if (r6 == 0) goto L_0x00e6
            r0 = 1
            goto L_0x0107
        L_0x00e6:
            r5.x()
            goto L_0x0107
        L_0x00ea:
            if (r1 != 0) goto L_0x00fa
            com.travel.flight.flightticket.a.m r6 = r5.f24804f
            int r6 = r6.getItemCount()
            if (r6 <= 0) goto L_0x0107
            androidx.recyclerview.widget.RecyclerView r6 = r5.f24801c
            r6.scrollToPosition(r0)
            goto L_0x0107
        L_0x00fa:
            com.travel.flight.flightticket.a.m r6 = r5.f24804f
            int r6 = r6.getItemCount()
            if (r6 <= r2) goto L_0x0107
            androidx.recyclerview.widget.RecyclerView r6 = r5.f24801c
            r6.scrollToPosition(r2)
        L_0x0107:
            if (r0 == 0) goto L_0x0130
            r5.b((boolean) r2)
            return
        L_0x010d:
            r5.a((boolean) r2, (boolean) r2)
            return
        L_0x0111:
            com.travel.flight.flightticket.a.m r6 = r5.f24804f
            int r6 = r6.getItemCount()
            if (r6 <= 0) goto L_0x0130
            com.travel.flight.pojo.flightticket.CJRFlightDetails r6 = r5.f24802d
            java.lang.String r6 = r6.getmTravelerDetailsInfoBoxHtml()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x012b
            androidx.recyclerview.widget.RecyclerView r6 = r5.f24801c
            r6.scrollToPosition(r2)
            return
        L_0x012b:
            androidx.recyclerview.widget.RecyclerView r6 = r5.f24801c
            r6.scrollToPosition(r0)
        L_0x0130:
            return
        L_0x0131:
            int r0 = com.travel.flight.R.id.amount_detail
            if (r6 != r0) goto L_0x016f
            com.travel.flight.views.FlightFareBreakupBottomSheetView r6 = r5.M
            if (r6 == 0) goto L_0x016e
            r6.c()
            com.travel.flight.views.FlightFareBreakupBottomSheetView r6 = r5.M
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r5.f24802d
            r6.setFlightDetails(r0)
            com.travel.flight.views.FlightFareBreakupBottomSheetView r6 = r5.M
            com.travel.flight.pojo.model.CJRTravellerSeatTransition r0 = r5.I
            r6.setSeatSelectionData(r0)
            com.travel.flight.views.FlightFareBreakupBottomSheetView r6 = r5.M
            com.travel.flight.pojo.flightticket.FareRules.CJRFareRulesResponse r0 = r5.F
            com.travel.flight.pojo.flightticket.CJRFlightDetails r3 = r5.f24802d
            com.travel.flight.pojo.flightticket.CJRFlightPromoResponse r4 = r3.getPromoResponse()
            r6.setData(r0, r3, r4, r2)
            com.travel.flight.views.FlightFareBreakupBottomSheetView r6 = r5.M
            r6.b()
            com.travel.flight.views.FlightFareBreakupBottomSheetView r6 = r5.M
            boolean r6 = r6.d()
            if (r6 != 0) goto L_0x0169
            java.lang.String r6 = "fare_details_clicked"
            a((java.lang.String) r6, (java.util.HashMap<java.lang.String, java.lang.Object>) r1)
        L_0x0169:
            com.travel.flight.views.FlightFareBreakupBottomSheetView r6 = r5.M
            r6.c()
        L_0x016e:
            return
        L_0x016f:
            int r6 = com.travel.flight.R.id.flight_share_icon
            return
        L_0x0172:
            r5.o()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.activity.AJRFlightTravellersItenary.onClick(android.view.View):void");
    }

    public void onBackPressed() {
        o();
    }

    private void o() {
        FlightFareBreakupBottomSheetView flightFareBreakupBottomSheetView = this.M;
        if (flightFareBreakupBottomSheetView == null || !flightFareBreakupBottomSheetView.d()) {
            a("td_back_arrow_button_clicked", (HashMap<String, Object>) null);
            setResult(0, new Intent().putExtra("cpStatus", this.f24802d.isInsuranceCancelProtectApplied()).putExtra("intent_extra_flight_is_clear_review_bank_promo", this.O));
            finish();
            return;
        }
        this.M.c();
    }

    private void a(String str) {
        if (!isFinishing()) {
            ProgressDialog progressDialog = this.f24806h;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f24806h = new ProgressDialog(this);
                try {
                    this.f24806h.setProgressStyle(0);
                    this.f24806h.setMessage(str);
                    this.f24806h.setCancelable(true);
                    this.f24806h.setCanceledOnTouchOutside(false);
                    this.f24806h.setOnKeyListener(new DialogInterface.OnKeyListener() {
                        public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                            if (i2 != 4) {
                                return false;
                            }
                            com.paytm.network.a.a((Context) AJRFlightTravellersItenary.this, (Object) "NETWORK_TAG_TRAVELLER_ITINERARY");
                            return false;
                        }
                    });
                    this.f24806h.show();
                } catch (Exception | IllegalArgumentException unused) {
                }
            }
        }
    }

    private void p() {
        ProgressDialog progressDialog = this.f24806h;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.f24806h.dismiss();
            this.f24806h = null;
        }
    }

    public void onDestroy() {
        p();
        this.f24806h = null;
        if (this.f24802d != null) {
            this.f24802d = null;
        }
        CJRFlightAncillaryReqBody.clear();
        super.onDestroy();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        q.a(this);
        if (i3 == -1) {
            if (i2 == 3) {
                a(true, true);
            } else if (i2 == 10) {
                if (!w()) {
                    x();
                } else if (intent.getBooleanExtra("shouldClearSelectedSeat", false)) {
                    this.f24804f.a((CJRTravellerSeatTransition) null);
                    this.I = null;
                    l();
                }
            } else if (i2 == 6) {
                if (intent.hasExtra("extra_intent_travellers_list")) {
                    this.I = (CJRTravellerSeatTransition) intent.getSerializableExtra("extra_intent_travellers_list");
                }
                this.R = intent.getBooleanExtra(GAConstants.ACTION.SKIP_CLICKED, false);
                this.f24804f.a(this.I);
                m();
                if (intent.getBooleanExtra("proceed_to_pay", false)) {
                    a(true, true);
                }
            } else if (i2 == 111) {
                this.N = null;
                this.f24802d.setPromoResponse((CJRFlightPromoResponse) null);
                this.O = true;
                l();
            }
        }
        if (i3 == 0 && (i2 == 111 || i2 == 112)) {
            l();
        }
        if (i2 == 4) {
            this.f24804f.h();
            l();
        } else if (i2 == 5) {
            this.f24804f.h();
            l();
        }
    }

    private void a(boolean z2, boolean z3) {
        if (this.v.getVisibility() == 0) {
            D();
        }
        boolean a2 = (!this.q || !u()) ? true : this.f24804f.a();
        boolean b2 = this.f24804f.b();
        boolean z4 = b2 && a2;
        if (z3) {
            z4 &= this.f24804f.c();
        }
        if (z4) {
            a(this.f24802d);
            this.m = this.f24804f.d();
            this.f24802d.getJourneyDetails().setGstObject(this.f24804f.e());
            this.E = this.f24804f.i();
            s();
            if (v() && this.f24802d.getMeta().getmStudentVisaPopup() != null) {
                y();
            } else if (z2) {
                if (w()) {
                    t();
                } else {
                    x();
                }
            } else if (this.B == 2) {
                b(false);
            } else if (this.f24799a != null) {
                q();
                I();
            } else {
                G();
            }
        } else if (!b2) {
            if (this.f24804f.getItemCount() > 0) {
                this.f24801c.scrollToPosition(0);
            }
        } else if (this.f24804f.getItemCount() > 1) {
            this.f24801c.scrollToPosition(1);
        }
    }

    private void q() {
        ArrayList<String> arrayList = this.f24800b;
        if (arrayList == null || arrayList.size() <= 0) {
            this.f24800b = new ArrayList<>();
        } else {
            this.f24800b.clear();
        }
        ArrayList<CJRTravellerDetails> r2 = r();
        if (r2 != null && r2.size() > 0) {
            Iterator<CJRTravellerDetails> it2 = r2.iterator();
            while (it2.hasNext()) {
                CJRTravellerDetails next = it2.next();
                if (next != null) {
                    this.f24800b.add(next.getTravellerTitle() + " " + next.getTravellerFirstName() + " " + next.getTravellerLastName());
                }
            }
        }
    }

    private ArrayList<CJRTravellerDetails> r() {
        if (this.m == null) {
            return null;
        }
        ArrayList<CJRTravellerDetails> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            CJRTravellerDetails cJRTravellerDetails = this.m.get(i2);
            if (!cJRTravellerDetails.getTravellerType().equals("Infant")) {
                arrayList.add(cJRTravellerDetails);
            }
        }
        return arrayList;
    }

    private void s() {
        ArrayList<CJRTravellerDetails> arrayList = this.m;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<CJRTravellerDetails> it2 = this.m.iterator();
            while (it2.hasNext()) {
                CJRTravellerDetails next = it2.next();
                if (next.getTravellerTitle() != null) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("title", next.getTravellerTitle());
                }
                if (next.getTravellerFirstName() != null) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("firstname", next.getTravellerFirstName());
                }
                if (next.getTravellerLastName() != null) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("lastname", next.getTravellerLastName());
                }
                if (next.getTravellerDOB() != null) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("dob", next.getTravellerDOB());
                }
                if (next.getMflyerName() != null) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("frequent_flyer", next.getMflyerName());
                }
                if (next.getFlyerFlightName() != null) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("frequent_flyer_airline", next.getFlyerFlightName());
                }
                if (next.getMflyerNumber() != null) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("frequent_flyer_number", next.getMflyerNumber());
                }
                if (next.getPassportCountryCode() != null) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("passport_issue_country", next.getPassportCountryCode());
                }
            }
            CJRFlightClientLoginPayload.getInstance().setEvent("mobile", this.f24804f.f());
            CJRFlightClientLoginPayload.getInstance().setEvent(com.business.merchant_payments.common.utility.AppConstants.KEY_EMAIL, this.f24804f.g());
            if (this.q) {
                CJRFlightClientLoginPayload.getInstance().setEvent("is_gst_selected", CommonPayParams.Builder.YES);
                CJRGSTPassengerInfo cJRGSTPassengerInfo = this.E;
                if (!(cJRGSTPassengerInfo == null || cJRGSTPassengerInfo.getGSTNumber() == null)) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("gstno", this.E.getGSTNumber());
                }
                CJRGSTPassengerInfo cJRGSTPassengerInfo2 = this.E;
                if (!(cJRGSTPassengerInfo2 == null || cJRGSTPassengerInfo2.getCompanyName() == null)) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("gst_company_name", this.E.getCompanyName());
                }
                CJRGSTPassengerInfo cJRGSTPassengerInfo3 = this.E;
                if (!(cJRGSTPassengerInfo3 == null || cJRGSTPassengerInfo3.getCompanyAddress() == null)) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("gst_company_address", this.E.getCompanyAddress());
                }
                CJRGSTPassengerInfo cJRGSTPassengerInfo4 = this.E;
                if (cJRGSTPassengerInfo4 != null && cJRGSTPassengerInfo4.getStateOfResidence() != null) {
                    CJRFlightClientLoginPayload.getInstance().setEvent("gst_state_of_residence", this.E.getStateOfResidence());
                    return;
                }
                return;
            }
            this.E = null;
            CJRFlightClientLoginPayload.getInstance().setEvent("is_gst_selected", CommonPayParams.Builder.NO);
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        Intent intent = new Intent(this, AJRFlightConfirmation.class);
        intent.putExtra("intent_extra_review_data", a(this.f24802d));
        intent.putExtra("intent_extra_trip_type", this.f24803e);
        intent.putExtra("flight_traveller_detail", this.m);
        intent.putExtra("flight_confirmation_amount", this.C);
        intent.putExtra("flight_gst_info", this.E);
        intent.putExtra("acceptType", this.r);
        intent.putExtra("intent_extra_search_input_data", this.f24805g);
        boolean z2 = this.L;
        if (z2) {
            intent.putExtra("isShare", z2);
        }
        startActivityForResult(intent, 10);
    }

    private void a(j jVar) {
        if (this.f24802d.getInsuranceData() != null && this.f24802d.getInsuranceData().getBody() != null && this.f24802d.getInsuranceData().getBody().getInsuranceDetail() != null && this.f24802d.getInsuranceData().getBody().getInsuranceDetail().size() > 0) {
            g.a aVar = com.travel.flight.flightticket.fragment.g.f24981a;
            com.travel.flight.flightticket.fragment.g a2 = g.a.a(this);
            Bundle bundle = new Bundle();
            bundle.putInt("intent_extra_flight_travel_insurance_view_type", jVar.getInputValue());
            bundle.putSerializable("intent_extra_flight_travel_insurance", this.f24802d.getInsuranceData().getBody().getInsuranceDetail().get(0));
            a2.setArguments(bundle);
            androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
            g.a aVar2 = com.travel.flight.flightticket.fragment.g.f24981a;
            a2.show(supportFragmentManager, com.travel.flight.flightticket.fragment.g.n);
        }
    }

    private boolean u() {
        if (this.f24802d.getGst() != null) {
            return this.f24802d.getGst().isEnabled();
        }
        return false;
    }

    private boolean v() {
        if (this.m == null) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            List<CJRDynamicValidation> validations = this.m.get(i2).getValidations();
            if (validations != null) {
                int size = validations.size();
                boolean z3 = z2;
                for (int i3 = 0; i3 < size; i3++) {
                    if (validations.get(i3).getKey().equals("visa_type") && validations.get(i3).getmValue() != null && validations.get(i3).getmValue().equalsIgnoreCase(getString(R.string.student))) {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public boolean w() {
        String b2 = i.a(getApplicationContext()).b("sso_token=", "", true);
        if (b2 == "" || b2.length() <= 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void x() {
        Intent intent = new Intent();
        com.travel.flight.b.a();
        com.travel.flight.b.b().a((Context) this, intent);
    }

    private void y() {
        this.u.setVisibility(0);
        ResourceUtils.loadFlightImagesFromCDN((ImageView) findViewById(R.id.image_student_baggage_icon), "student_baggage_popup_icon.png", false, false, n.a.V1);
        this.t.setVisibility(0);
        this.t.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_flight_reprice_bottom_to_top));
        ((ImageView) findViewById(R.id.imageView_dialog_close_baggage)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRFlightTravellersItenary.this.F();
            }
        });
        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.txt_student_baggage_msg);
        TextView textView = (TextView) findViewById(R.id.proceed_to_book_btn_student_baggage);
        if (this.f24802d.getMeta().getmStudentVisaPopup() != null && this.f24802d.getMeta().getmStudentVisaPopup().size() > 0) {
            roboTextView.setText(this.f24802d.getMeta().getmStudentVisaPopup().get(0));
        }
        CJRRepriceFlightFare cJRRepriceFlightFare = this.f24802d.getmRepriceFareDetails();
        if (cJRRepriceFlightFare == null || TextUtils.isEmpty(cJRRepriceFlightFare.getmTotalFare())) {
            textView.setText(getResources().getString(R.string.proceed_to_pay));
        } else {
            CJRFlightDetails cJRFlightDetails = this.f24802d;
            double a2 = com.travel.flight.flightticket.g.e.a(cJRFlightDetails, cJRFlightDetails.isInsuranceApplied());
            textView.setText(getResources().getString(R.string.proceed_to_pay) + " " + getResources().getString(R.string.rs_symbol) + " " + com.travel.flight.utils.c.a(a2));
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (AJRFlightTravellersItenary.this.w()) {
                    AJRFlightTravellersItenary.this.t();
                } else {
                    AJRFlightTravellersItenary.this.x();
                }
            }
        });
    }

    private boolean z() {
        try {
            double d2 = 0.0d;
            double parseDouble = (this.f24802d.getmRepriceFareDetails().getmTotalFare() == null || TextUtils.isEmpty(this.f24802d.getmRepriceFareDetails().getmTotalFare())) ? 0.0d : Double.parseDouble(this.f24802d.getmRepriceFareDetails().getmTotalFare());
            if (!(this.f24802d.getmFareDetails() == null || this.f24802d.getmFareDetails().getmFlightCost() == null || TextUtils.isEmpty(this.f24802d.getmFareDetails().getmFlightCost()))) {
                d2 = Double.parseDouble(this.f24802d.getmFareDetails().getmFlightCost());
            }
            if (Math.abs(parseDouble) > Math.abs(d2)) {
                return true;
            }
            if (Math.abs(parseDouble) < Math.abs(d2)) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
        }
    }

    private Intent a(Intent intent) {
        intent.putExtra("isShare", true);
        intent.putExtra("intent_extra_search_input_data", this.f24805g);
        return intent;
    }

    public final void a(boolean z2) {
        this.q = z2;
        if (this.q) {
            a("gst_details_entered", (HashMap<String, Object>) null);
        }
    }

    public final void a() {
        m mVar = this.f24804f;
        if (mVar != null && mVar.f24702a != null) {
            mVar.f24702a.a();
        }
    }

    private static JSONObject A() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "FlightTravellerScreen");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void B() {
        CJRInsuranceModel insuranceData = this.f24802d.getInsuranceData();
        if (insuranceData != null && insuranceData.getBody() != null && insuranceData.getBody().getInsuranceDetail() != null && insuranceData.getBody().getInsuranceDetail().size() > 0) {
            Boolean C2 = C();
            if (C2 != null) {
                insuranceData.getBody().getInsuranceDetail().get(0).setOptIn(C2.booleanValue());
            }
            this.f24802d.setInsuranceApplied(!insuranceData.getBody().getInsuranceDetail().get(0).isOptIn());
        }
    }

    private static Boolean C() {
        CJRTpUserProfileBody cJRTpUserProfileBody = com.travel.flight.travellerProfile.a.a().f25522a;
        if (cJRTpUserProfileBody == null || cJRTpUserProfileBody.isTravelInsurance() == null) {
            return null;
        }
        return cJRTpUserProfileBody.isTravelInsurance();
    }

    private void D() {
        RelativeLayout relativeLayout = this.x;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_flight_bottom_to_top_above_tab_close);
        this.w.setVisibility(8);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AJRFlightTravellersItenary.this.v.setVisibility(8);
            }
        });
        this.w.setAnimation(loadAnimation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = r3.f24802d.getInsuranceData().getBody().getCancelProtectInsuranceDetail().get(0).getPriceDetails();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String E() {
        /*
            r3 = this;
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r3.f24802d
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r0 = r0.getInsuranceData()
            if (r0 == 0) goto L_0x0044
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r3.f24802d
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r0 = r0.getInsuranceData()
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r0 = r0.getBody()
            java.util.List r0 = r0.getCancelProtectInsuranceDetail()
            if (r0 == 0) goto L_0x0044
            com.travel.flight.pojo.flightticket.CJRFlightDetails r0 = r3.f24802d
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel r0 = r0.getInsuranceData()
            com.travel.flight.pojo.flightticket.insurance.CJRInsuranceBody r0 = r0.getBody()
            java.util.List r0 = r0.getCancelProtectInsuranceDetail()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem r0 = (com.travel.flight.pojo.flightticket.insurance.CJRCancelProtectInsuranceItem) r0
            java.util.ArrayList r0 = r0.getPriceDetails()
            if (r0 == 0) goto L_0x0044
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x0044
            java.lang.Object r0 = r0.get(r1)
            com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail r0 = (com.travel.flight.pojo.flightticket.insurance.CJRInsurancePriceDetail) r0
            java.lang.String r0 = r0.getPremiumPerPassenger()
            goto L_0x0046
        L_0x0044:
            java.lang.String r0 = ""
        L_0x0046:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.activity.AJRFlightTravellersItenary.E():java.lang.String");
    }

    /* access modifiers changed from: private */
    public void F() {
        RelativeLayout relativeLayout = this.t;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_flight_reprice_close);
            this.t.setVisibility(8);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AJRFlightTravellersItenary.this.u.setVisibility(8);
                }
            });
            this.t.setAnimation(loadAnimation);
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        if (!((Activity) context).isFinishing()) {
            final com.paytm.utility.h hVar = new com.paytm.utility.h(context);
            hVar.setTitle(str);
            hVar.a(str2);
            hVar.setCancelable(false);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(hVar.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            hVar.a(-3, str3, new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    if (AJRFlightTravellersItenary.this.f24803e == null || !AJRFlightTravellersItenary.this.f24803e.equalsIgnoreCase("round_trip")) {
                        AJRFlightTravellersItenary.j(AJRFlightTravellersItenary.this);
                    } else {
                        AJRFlightTravellersItenary.i(AJRFlightTravellersItenary.this);
                    }
                    AJRFlightTravellersItenary.this.finish();
                }
            });
            hVar.show();
            hVar.getWindow().setAttributes(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public void G() {
        String str;
        com.travel.flight.b.a();
        String c2 = com.travel.flight.b.b().c();
        if (URLUtil.isValidUrl(c2)) {
            String s2 = com.paytm.utility.b.s(this, c2);
            String str2 = this.f24803e;
            if (str2 == null || !str2.equalsIgnoreCase("round_trip")) {
                c.a aVar = com.travel.flight.tripsummary.c.n;
                str = c.a.b(s2, this.f24802d);
            } else {
                c.a aVar2 = com.travel.flight.tripsummary.c.n;
                str = c.a.a(s2, this.f24802d);
            }
            String uri = Uri.parse(str + "&type=" + this.r).buildUpon().build().toString();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            this.f24804f.g();
            this.f24804f.f();
            c.a aVar3 = com.travel.flight.tripsummary.c.n;
            JSONObject a2 = c.a.a(true, this.f24802d, getApplicationContext());
            if (com.paytm.utility.b.c((Context) this)) {
                a(getResources().getString(R.string.pre_f_please_wait_progress_msg));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = getApplicationContext();
                bVar.n = a.b.SILENT;
                bVar.o = "flight-traveller-itinerary";
                bVar.f42878b = a.c.FLIGHT;
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = uri;
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = a2.toString();
                bVar.f42885i = new CJRAncillaryDetails();
                bVar.j = this;
                bVar.t = A();
                com.paytm.network.a l2 = bVar.l();
                l2.a((Object) "NETWORK_TAG_TRAVELLER_ITINERARY");
                l2.a();
            } else {
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
            if (H()) {
                a(a2);
            }
        }
    }

    private boolean H() {
        if (this.f24802d.getmOnwardJourney() != null && this.f24802d.getmOnwardJourney().isAncillaryEligible()) {
            return true;
        }
        if (this.f24802d.getmReturnJourney() == null || !this.f24802d.getmReturnJourney().isAncillaryEligible()) {
            return false;
        }
        return true;
    }

    private void a(JSONObject jSONObject) {
        try {
            this.f24800b = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray("pax_info");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2.getString("type").equalsIgnoreCase("adult") || jSONObject2.getString("type").equalsIgnoreCase("child")) {
                    ArrayList<String> arrayList = this.f24800b;
                    arrayList.add(jSONObject2.getString("title") + " " + jSONObject2.getString("firstname") + " " + jSONObject2.getString("lastname"));
                }
            }
        } catch (Exception unused) {
        }
    }

    private void I() {
        Intent intent = new Intent(this, AJRFlightAncillaryHome.class);
        intent.putExtra("ancillary", this.f24799a);
        intent.putExtra("ancillaryType", this.B);
        intent.putExtra("paxinfo", this.f24800b);
        CJRFlightDetails cJRFlightDetails = this.f24802d;
        intent.putExtra(CJRQRScanResultModel.KEY_TOTAL_AMOUNT, com.travel.flight.flightticket.g.e.a(cJRFlightDetails, cJRFlightDetails.isInsuranceApplied()));
        int i2 = this.B;
        if (i2 == 0) {
            a("extra_baggage_clicked", (HashMap<String, Object>) null);
            startActivityForResult(intent, 4);
        } else if (i2 == 1) {
            a("meals_clicked", (HashMap<String, Object>) null);
            startActivityForResult(intent, 5);
        }
    }

    public final void b() {
        this.G.dismiss();
    }

    public final void c() {
        this.H = true;
        this.G.dismiss();
    }

    public final void d() {
        this.f24804f.a((CJRTravellerSeatTransition) null);
        this.G.dismiss();
        this.I = null;
        b(false);
    }

    public final void e() {
        this.f24804f.a((CJRTravellerSeatTransition) null);
        this.G.dismiss();
        this.I = null;
        this.f24804f.g();
        this.f24804f.f();
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        boolean z2;
        String str;
        try {
            p();
            F();
            if (networkCustomError != null) {
                com.travel.flight.b.a();
                String e2 = com.travel.flight.b.b().e();
                if (networkCustomError.getUrl() == null || !networkCustomError.getFullUrl().contains(e2)) {
                    com.travel.flight.b.a();
                    String Q2 = com.travel.flight.b.b().Q();
                    if (networkCustomError.getUrl() == null || !networkCustomError.getFullUrl().contains(Q2)) {
                        com.travel.flight.pojo.model.a aVar = new com.travel.flight.pojo.model.a();
                        CJRIllegalCodeError cJRIllegalCodeError = null;
                        if (networkCustomError.networkResponse != null) {
                            cJRIllegalCodeError = (CJRIllegalCodeError) new f().a(new String(networkCustomError.networkResponse.data), CJRIllegalCodeError.class);
                            NetworkResponse networkResponse = networkCustomError.networkResponse;
                            if (networkResponse.data != null) {
                                try {
                                    aVar = (com.travel.flight.pojo.model.a) new com.google.gson.f().a(new String(networkResponse.data), aVar.getClass());
                                } catch (Exception unused) {
                                }
                            }
                        }
                        String str2 = "";
                        if (cJRIllegalCodeError != null) {
                            if (!TextUtils.isEmpty(cJRIllegalCodeError.getmInternalErrorCode())) {
                                str2 = cJRIllegalCodeError.getmInternalErrorCode();
                            }
                        }
                        String alertTitle = networkCustomError.getAlertTitle();
                        String alertMessage = networkCustomError.getAlertMessage();
                        if (networkCustomError.mErrorType == null || networkCustomError.mErrorType != NetworkCustomError.ErrorType.InvalidArgumentError) {
                            boolean z3 = true;
                            if (aVar == null || aVar.getStatus() == null || aVar.getStatus().getMessage() == null || TextUtils.isEmpty(aVar.getStatus().getMessage().f25442a) || TextUtils.isEmpty(aVar.getStatus().getMessage().f25443b)) {
                                z2 = false;
                            } else {
                                alertTitle = aVar.getStatus().getMessage().f25442a;
                                alertMessage = aVar.getStatus().getMessage().f25443b;
                                z2 = true;
                            }
                            if (!"FL5_2201".equalsIgnoreCase(str2)) {
                                if (!"FL4_2204".equalsIgnoreCase(str2) && !"FL5_2203".equalsIgnoreCase(str2) && !"FL5_2210".equalsIgnoreCase(str2) && !"FL5_2211".equalsIgnoreCase(str2) && !"FL5_2221".equalsIgnoreCase(str2) && !"FL5_2222".equalsIgnoreCase(str2) && !"FL5_2223".equalsIgnoreCase(str2) && !"FL5_2220".equalsIgnoreCase(str2) && !"FL5_2310".equalsIgnoreCase(str2) && !"FL5_2213".equalsIgnoreCase(str2) && !"FL5_2206".equalsIgnoreCase(str2) && !"FL5_2204".equalsIgnoreCase(str2) && !"FL5_2332".equalsIgnoreCase(str2) && !"FL4_2422".equalsIgnoreCase(str2) && !"FL4_2421".equalsIgnoreCase(str2) && !"FL2_2225".equalsIgnoreCase(str2)) {
                                    if (!"FL2_2224".equalsIgnoreCase(str2)) {
                                        if ("FL4_2411".equalsIgnoreCase(str2)) {
                                            net.one97.paytmflight.a.b.a(this, networkCustomError);
                                            return;
                                        } else if ("FL4_2332".equalsIgnoreCase(str2)) {
                                            com.paytm.utility.b.b((Context) this, alertTitle, alertMessage);
                                            return;
                                        } else if ("FL5_9516".equalsIgnoreCase(str2)) {
                                            this.G = new com.travel.flight.flightticket.c.c(this, alertTitle, alertMessage, getResources().getString(R.string.select_another_seats), getResources().getString(R.string.proceed_to_pay_without_seat), this);
                                            this.G.show();
                                            return;
                                        } else if ("FL4_2333".equalsIgnoreCase(str2)) {
                                            this.G = new com.travel.flight.flightticket.c.c(this, alertTitle, alertMessage, getResources().getString(R.string.add_last_name), getResources().getString(R.string.proceed_to_pay), this);
                                            this.G.show();
                                            return;
                                        } else {
                                            if (i2 != 400) {
                                                if (i2 == 401 || i2 == 410) {
                                                    net.one97.paytmflight.a.b.a(this, networkCustomError);
                                                    return;
                                                } else if (i2 != 417) {
                                                    if (i2 == 500) {
                                                        if (networkCustomError.getUrl() == null || !networkCustomError.getUrl().contains("flights/v1/cartcheckout") || TextUtils.isEmpty(String.valueOf(i2)) || !String.valueOf(i2).equalsIgnoreCase(getResources().getString(R.string.internal_error_code))) {
                                                            z3 = false;
                                                        } else {
                                                            this.G = new com.travel.flight.flightticket.c.c(this, alertTitle, alertMessage, getResources().getString(R.string.add_last_name), getResources().getString(R.string.proceed_to_pay), this);
                                                            this.G.show();
                                                        }
                                                        if (!z3) {
                                                            com.paytm.utility.b.b((Context) this, alertTitle, alertMessage);
                                                            return;
                                                        }
                                                        return;
                                                    } else if (!(i2 == 517 || i2 == 522)) {
                                                        switch (i2) {
                                                            case H5ErrorCode.HTTP_BAD_GATEWAY:
                                                            case H5ErrorCode.HTTP_SERVICE_UNAVAILABLE:
                                                            case 504:
                                                                if (z2) {
                                                                    com.paytm.utility.b.b((Context) this, alertTitle, alertMessage);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                        com.paytm.utility.b.b((Context) this, alertTitle, alertMessage);
                                                        return;
                                                    }
                                                }
                                            }
                                            a((Context) this, alertTitle, alertMessage, getResources().getString(R.string.flight_view_updated_search_results));
                                            return;
                                        }
                                    }
                                }
                            }
                            if ("FL5_2221".equalsIgnoreCase(str2)) {
                                a((Context) this, alertTitle, alertMessage, getResources().getString(R.string.select_another_flight));
                            } else if ("FL2_2224".equalsIgnoreCase(str2)) {
                                com.paytm.utility.b.b((Context) this, alertTitle, alertMessage);
                            } else {
                                a((Context) this, alertTitle, alertMessage, getResources().getString(R.string.flight_view_updated_search_results));
                            }
                        } else {
                            if (getApplicationContext() == null) {
                                str = networkCustomError.getUrl() + "/1";
                            } else {
                                str = networkCustomError.getUrl() + "/2";
                            }
                            com.paytm.utility.b.b((Context) this, alertTitle, str);
                        }
                    }
                } else {
                    k();
                }
            }
        } catch (Resources.NotFoundException | Exception unused2) {
        }
    }

    private double J() {
        CJRTravellerSeatTransition cJRTravellerSeatTransition = this.I;
        double d2 = 0.0d;
        if (!(cJRTravellerSeatTransition == null || cJRTravellerSeatTransition.getOnwardSeatSelections() == null)) {
            for (int i2 = 0; i2 < this.I.getOnwardSeatSelections().size(); i2++) {
                CJRSeatSelection cJRSeatSelection = this.I.getOnwardSeatSelections().get(i2);
                if (cJRSeatSelection != null) {
                    d2 += cJRSeatSelection.getmTotalSeatPrice();
                }
            }
        }
        return d2;
    }

    public final void f() {
        m mVar = this.f24804f;
        if (mVar != null && mVar.f24702a != null) {
            mVar.f24702a.a();
        }
    }

    public final void a(CJRDynamicValidationAutoSuggest cJRDynamicValidationAutoSuggest, View view, int i2, boolean z2) {
        if (!isDestroyed() && !isFinishing()) {
            p();
            F();
            m mVar = this.f24804f;
            ArrayList<com.travel.flight.pojo.flightticket.paxinfo.a> body = cJRDynamicValidationAutoSuggest.getBody();
            if (mVar.f24702a != null) {
                mVar.f24702a.k.get(Integer.valueOf(i2)).a(body, view, z2);
            }
        }
    }

    public final void a(CJRSeatAncillaryCombinedModel cJRSeatAncillaryCombinedModel) {
        this.Q = true;
    }

    public final void a(CJRSeatAvailability cJRSeatAvailability) {
        this.P = true;
    }

    public final void i() {
        CJRFlightDetails cJRFlightDetails = this.f24802d;
        if (cJRFlightDetails != null) {
            cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0).setOptIn(true);
            a(Boolean.TRUE);
            m mVar = this.f24804f;
            mVar.notifyItemChanged(mVar.f24703b);
        }
    }

    public final void a(int i2) {
        CJRFlightDetails cJRFlightDetails = this.f24802d;
        if (cJRFlightDetails != null && cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0).isOne_way_international()) {
            this.f24802d.getInsuranceData().getBody().getInsuranceDetail().get(0).setOptIn(true);
            this.f24802d.getInsuranceData().getBody().getInsuranceDetail().get(0).getUserInputInfo().setSelectedDays(i2);
            a(Boolean.TRUE);
            m mVar = this.f24804f;
            mVar.notifyItemChanged(mVar.f24703b);
        }
    }

    public final void j() {
        CJRFlightDetails cJRFlightDetails = this.f24802d;
        if (cJRFlightDetails != null) {
            cJRFlightDetails.getInsuranceData().getBody().getInsuranceDetail().get(0).setOptIn(false);
            a(Boolean.FALSE);
            m mVar = this.f24804f;
            mVar.notifyItemChanged(mVar.f24703b);
        }
    }

    private CJRFlightDetails a(CJRFlightDetails cJRFlightDetails) {
        if (cJRFlightDetails != null) {
            cJRFlightDetails.getJourneyDetails().setRequestId(this.n);
            cJRFlightDetails.getJourneyDetails().setmTravellersList(this.f24804f.d());
            cJRFlightDetails.getJourneyDetails().setEmailId(this.f24804f.g());
            cJRFlightDetails.getJourneyDetails().setMobileNumber(this.f24804f.f());
            cJRFlightDetails.getJourneyDetails().setGstObject(this.f24804f.e());
            cJRFlightDetails.getJourneyDetails().setTravellerSeatTransitionObj(this.I);
            cJRFlightDetails.getJourneyDetails().setGstSelected(this.q);
            cJRFlightDetails.getJourneyDetails().setTotalfare(this.C.doubleValue());
            cJRFlightDetails.getJourneyDetails().setTripType(getIntent().getStringExtra("intent_extra_trip_type"));
            cJRFlightDetails.getJourneyDetails().setIslastnameValidationRequiered(this.H);
            cJRFlightDetails.getJourneyDetails().setmPaymentIntent(getIntent().getStringExtra("intent_extra_flight_payment_intent"));
            cJRFlightDetails.setSearchInput(this.f24805g);
        }
        return cJRFlightDetails;
    }

    private HashMap<String, Object> b(String str) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("event_label", str);
        }
        if (!TextUtils.isEmpty(this.f24805g.getJourneyDetailType())) {
            hashMap.put("event_label2", this.f24805g.getJourneyDetailType());
        }
        hashMap.put("event_label3", this.f24805g.getSource().getCityName());
        hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.f24805g.getDestination().getCityName());
        j.a aVar = com.travel.flight.utils.j.f25593a;
        hashMap.put("event_label6", j.a.a(this.f24805g.getClassType(), (Context) this));
        hashMap.put("event_label7", com.paytm.utility.b.h(this.f24805g.getDate(), "yyyy-MM-dd", "dd MMM yy"));
        hashMap.put("event_label8", com.paytm.utility.b.h(this.f24805g.getReturnDate(), "yyyy-MM-dd", "dd MMM yy"));
        hashMap.put("event_label9", this.f24805g.getSourceCityCode());
        hashMap.put("event_label10", this.f24805g.getDestCityCode());
        if (!TextUtils.isEmpty(this.f24805g.getJourneyType()) && this.f24802d != null) {
            hashMap.put("event_label11", this.f24805g.getJourneyType());
            if (this.f24805g.getJourneyType().equalsIgnoreCase("one_way")) {
                if (this.f24802d.getmOnwardJourney().getmFlights() != null && this.f24802d.getmOnwardJourney().getmFlights().size() > 0) {
                    hashMap.put("event_label5", this.f24802d.getmOnwardJourney().getmAirLineCode() + " " + this.f24802d.getmOnwardJourney().getmFlights().get(0).getmFlightNumber());
                }
            } else if (this.f24802d.getmOnwardJourney().getmFlights() != null && this.f24802d.getmOnwardJourney().getmFlights().size() > 0 && this.f24802d.getmReturnJourney().getmFlights() != null && this.f24802d.getmReturnJourney().getmFlights().size() > 0) {
                hashMap.put("event_label5", "Onward{" + this.f24802d.getmOnwardJourney().getmAirLineCode() + " " + this.f24802d.getmOnwardJourney().getmFlights().get(0).getmFlightNumber() + "}, Return{" + this.f24802d.getmReturnJourney().getmAirLineCode() + " " + this.f24802d.getmReturnJourney().getmFlights().get(0).getmFlightNumber() + "}");
            }
        }
        return hashMap;
    }

    private static void a(String str, HashMap<String, Object> hashMap) {
        com.travel.flight.b.a();
        com.travel.flight.b.b().a(GAUtil.CUSTOM_EVENT, "/flights/traveler-details", "flights_traveler_details", str, hashMap);
    }

    /* JADX WARNING: type inference failed for: r11v25, types: [com.travel.flight.pojo.flightticket.Ancillary.AncillarySeats.CJRComboSeat[], java.io.Serializable] */
    private void b(boolean z2) {
        CJRTravellerSeatTransition cJRTravellerSeatTransition = this.I;
        if (cJRTravellerSeatTransition == null) {
            this.I = new CJRTravellerSeatTransition();
            boolean z3 = true;
            boolean z4 = this.f24802d.getmOnwardJourney() == null;
            if (this.f24802d.getmOnwardJourney().getmFlights() != null) {
                z3 = false;
            }
            if (!z4 && !z3) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.f24802d.getmOnwardJourney().getmFlights().size(); i2++) {
                    CJRFlightStops cJRFlightStops = this.f24802d.getmOnwardJourney().getmFlights().get(i2);
                    CJRSeatSelection cJRSeatSelection = new CJRSeatSelection();
                    if (cJRFlightStops != null) {
                        cJRSeatSelection.setmFlightNumber(cJRFlightStops.getmFlightNumber());
                        cJRSeatSelection.setmOrigin(cJRFlightStops.getmOrigin());
                        cJRSeatSelection.setmDestination(cJRFlightStops.getmDestination());
                    }
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<CJRTravellerDetails> r2 = r();
                    if (r2 != null) {
                        for (int i3 = 0; i3 < r2.size(); i3++) {
                            CJRTravellerDetails cJRTravellerDetails = r2.get(i3);
                            if (!cJRTravellerDetails.getPassengerType().equals("Infant")) {
                                CJRSeatSelectedItem cJRSeatSelectedItem = new CJRSeatSelectedItem();
                                if (cJRTravellerDetails != null) {
                                    cJRSeatSelectedItem.setmPassengerId(i3 + 1);
                                    cJRSeatSelectedItem.setmTravellerTitle(cJRTravellerDetails.getTravellerTitle());
                                    cJRSeatSelectedItem.setmTravellerFirstName(cJRTravellerDetails.getTravellerFirstName());
                                    cJRSeatSelectedItem.setmTravellerLastName(cJRTravellerDetails.getTravellerLastName());
                                    cJRSeatSelectedItem.setmTravellerType(cJRTravellerDetails.getTravellerType());
                                    arrayList2.add(cJRSeatSelectedItem);
                                }
                            }
                        }
                    }
                    cJRSeatSelection.setmSeatSelectedItems(arrayList2);
                    arrayList.add(cJRSeatSelection);
                }
                this.I.setOnwardSeatSelections(arrayList);
            }
        } else if (cJRTravellerSeatTransition.getOnwardSeatSelections() != null) {
            for (int i4 = 0; i4 < this.I.getOnwardSeatSelections().size(); i4++) {
                ArrayList<CJRSeatSelectedItem> arrayList3 = this.I.getOnwardSeatSelections().get(i4).getmSeatSelectedItems();
                if (arrayList3 != null) {
                    ArrayList<CJRTravellerDetails> r3 = r();
                    for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                        CJRSeatSelectedItem cJRSeatSelectedItem2 = arrayList3.get(i5);
                        cJRSeatSelectedItem2.setmTravellerTitle(r3.get(i5).getTravellerTitle());
                        cJRSeatSelectedItem2.setmTravellerFirstName(r3.get(i5).getTravellerFirstName());
                        cJRSeatSelectedItem2.setmTravellerLastName(r3.get(i5).getTravellerLastName());
                        cJRSeatSelectedItem2.setmTravellerType(r3.get(i5).getTravellerType());
                    }
                }
            }
        }
        Intent intent = new Intent(this, AJRSeatAncillaryActivity.class);
        intent.putExtra("requestid", this.n);
        intent.putExtra("proceed_to_pay", z2);
        if (this.f24802d.getmOnwardJourney() != null) {
            intent.putExtra("onward_flightid", this.f24802d.getmOnwardJourney().getmFlightId());
            intent.putExtra("onward_provider", this.f24802d.getmOnwardServiceProvider());
        }
        if (this.f24802d.getmReturnJourney() != null) {
            intent.putExtra("return_flightid", this.f24802d.getmReturnJourney().getmFlightId());
            intent.putExtra("return_provider", this.f24802d.getmReturnServiceProvider());
        }
        CJRTravellerSeatTransition cJRTravellerSeatTransition2 = this.I;
        if (cJRTravellerSeatTransition2 != null) {
            intent.putExtra("extra_intent_travellers_list", cJRTravellerSeatTransition2);
        }
        if (!(this.f24802d.getMeta() == null || this.f24802d.getMeta().getmSeats() == null || this.f24802d.getMeta().getmSeats().getDisplay_elements() == null || this.f24802d.getMeta().getmSeats().getDisplay_elements().getCombo_seat() == null)) {
            intent.putExtra("extra_intent_seat_popup_info", this.f24802d.getMeta().getmSeats().getDisplay_elements().getCombo_seat());
        }
        startActivityForResult(intent, 6);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        String str;
        int i2;
        int i3;
        m mVar;
        p();
        F();
        if (!isDestroyed() && !isFinishing()) {
            if (iJRPaytmDataModel instanceof CJRInsuranceModel) {
                CJRInsuranceModel cJRInsuranceModel = (CJRInsuranceModel) iJRPaytmDataModel;
                if (!(cJRInsuranceModel == null || cJRInsuranceModel.getBody() == null || cJRInsuranceModel.getBody().getInsuranceDetail() == null || cJRInsuranceModel.getBody().getInsuranceDetail().size() <= 0)) {
                    this.f24802d.setInsuranceData(cJRInsuranceModel);
                    B();
                }
                k();
            } else if (iJRPaytmDataModel instanceof CJRTpDeleteResponse) {
                p();
                if (((CJRTpDeleteResponse) iJRPaytmDataModel).getMessage().equalsIgnoreCase(getString(R.string.success)) && (mVar = this.f24804f) != null) {
                    CJRTpUserProfileContact cJRTpUserProfileContact = this.o;
                    View view = this.p;
                    if (mVar.f24702a != null) {
                        mVar.f24702a.l = com.travel.flight.travellerProfile.a.a().f25523b;
                        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
                        com.travel.flight.flightticket.a.l lVar = (com.travel.flight.flightticket.a.l) autoCompleteTextView.getAdapter();
                        ArrayList<CJRTpUserProfileContact> arrayList = lVar.f24693a;
                        arrayList.remove(cJRTpUserProfileContact);
                        lVar.a(arrayList);
                        autoCompleteTextView.showDropDown();
                    }
                }
            } else if (!(iJRPaytmDataModel instanceof CJRDynamicValidationAutoSuggest)) {
                boolean z2 = iJRPaytmDataModel instanceof CJRAncillaryDetails;
                if (z2) {
                    p();
                    F();
                    if (z2) {
                        this.f24799a = (CJRAncillaryDetails) iJRPaytmDataModel;
                        I();
                    }
                } else if (iJRPaytmDataModel instanceof CJRFlightAncillaryReprice) {
                    CJRFlightAncillaryReprice cJRFlightAncillaryReprice = (CJRFlightAncillaryReprice) iJRPaytmDataModel;
                    if (isFinishing()) {
                        return;
                    }
                    if (cJRFlightAncillaryReprice == null || cJRFlightAncillaryReprice.getmStatus() == null || !cJRFlightAncillaryReprice.getmStatus().getmResult().equalsIgnoreCase("success")) {
                        CJRStatus cJRStatus = cJRFlightAncillaryReprice.getmStatus();
                        com.paytm.utility.b.b((Context) this, cJRStatus.getmFlightMesssgae().getmTitle(), cJRStatus.getmFlightMesssgae().getmMessage());
                        return;
                    }
                    if (!(this.f24803e == null || cJRFlightAncillaryReprice.getmOnwardReturnFlights() == null)) {
                        this.f24802d.setmRepriceFareDetails(cJRFlightAncillaryReprice.getmOnwardReturnFlights().getmRepriceFare());
                        this.f24802d.setmConvenienceFee(cJRFlightAncillaryReprice.getmOnwardReturnFlights().getmRepriceFare().getmConvenienceFee());
                    }
                    p();
                    this.f24802d.getmRepriceFareDetails().setTotalFee(Double.toString(com.travel.flight.flightticket.g.e.a(this.f24802d, false)));
                    if (z()) {
                        this.u.setVisibility(0);
                        AnimationUtils.loadAnimation(this, R.anim.anim_flight_reprice_bottom_to_top);
                        CJRStatus status = this.f24802d.getStatus();
                        String str2 = "";
                        if (status == null || status.getmFlightMesssgae() == null) {
                            str = str2;
                        } else {
                            str = !TextUtils.isEmpty(status.getmFlightMesssgae().getmTitle()) ? status.getmFlightMesssgae().getmTitle() : str2;
                            if (!TextUtils.isEmpty(status.getmFlightMesssgae().getmMessage())) {
                                str2 = status.getmFlightMesssgae().getmMessage();
                            }
                        }
                        ((ImageView) findViewById(R.id.imageView_dialog_close_reprice)).setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                Animation loadAnimation = AnimationUtils.loadAnimation(AJRFlightTravellersItenary.this, R.anim.anim_flight_reprice_close);
                                AJRFlightTravellersItenary.this.l();
                                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        AJRFlightTravellersItenary.this.u.setVisibility(8);
                                    }
                                });
                            }
                        });
                        ImageView imageView = (ImageView) findViewById(R.id.imageView_fare_status_icon);
                        ((TextView) findViewById(R.id.txt_fare_status)).setText(str);
                        TextView textView = (TextView) findViewById(R.id.txt_prev_fare);
                        TextView textView2 = (TextView) findViewById(R.id.txt_update_fare);
                        TextView textView3 = (TextView) findViewById(R.id.proceed_to_book_btn_reprice);
                        TextView textView4 = (TextView) findViewById(R.id.choose_another_flight);
                        ((TextView) findViewById(R.id.fare_change_message)).setText(str2);
                        Double valueOf = Double.valueOf(0.0d);
                        Double valueOf2 = Double.valueOf(0.0d);
                        if (this.f24802d.getmRepriceFareDetails().getmTotalFare() != null && !TextUtils.isEmpty(this.f24802d.getmRepriceFareDetails().getmTotalFare())) {
                            valueOf = Double.valueOf(com.travel.flight.flightticket.g.e.a(Double.parseDouble(this.f24802d.getmRepriceFareDetails().getmTotalFare()), this.f24802d));
                            textView2.setText(com.travel.flight.utils.c.a(valueOf.doubleValue()));
                        }
                        if (!(this.f24802d.getmFareDetails() == null || this.f24802d.getmFareDetails().getmFlightCost() == null || TextUtils.isEmpty(this.f24802d.getmFareDetails().getmFlightCost()))) {
                            valueOf2 = Double.valueOf(com.travel.flight.flightticket.g.e.a(Double.parseDouble(this.f24802d.getmFareDetails().getmFlightCost()), this.f24802d));
                            textView.setText(com.travel.flight.utils.c.a(valueOf2.doubleValue()));
                        }
                        StringBuilder sb = new StringBuilder();
                        if (this.f24802d.getmIsInternational().booleanValue()) {
                            i2 = R.string.international_text;
                        } else {
                            i2 = R.string.domestic_text;
                        }
                        sb.append(getString(i2));
                        sb.append(AppConstants.AND_SIGN);
                        if (this.f24803e.equalsIgnoreCase("round_trip")) {
                            i3 = R.string.flight_roundtrip_text;
                        } else {
                            i3 = R.string.flight_oneway_text;
                        }
                        sb.append(getString(i3));
                        if (Math.abs(valueOf.doubleValue()) < Math.abs(valueOf2.doubleValue())) {
                            ResourceUtils.loadFlightImagesFromCDN(imageView, "fare_drop.png", false, false, n.a.V1);
                            textView4.setVisibility(8);
                        }
                        CJRRepriceFlightFare cJRRepriceFlightFare = this.f24802d.getmRepriceFareDetails();
                        if (cJRRepriceFlightFare == null || TextUtils.isEmpty(cJRRepriceFlightFare.getmTotalFare())) {
                            textView3.setText(getResources().getString(R.string.proceed_to_pay));
                        } else {
                            CJRFlightDetails cJRFlightDetails = this.f24802d;
                            double a2 = com.travel.flight.flightticket.g.e.a(cJRFlightDetails, cJRFlightDetails.isInsuranceApplied());
                            this.C = Double.valueOf(a2);
                            textView3.setText(getResources().getString(R.string.proceed_to_pay) + " " + getResources().getString(R.string.rs_symbol) + com.travel.flight.utils.c.a(a2));
                        }
                        textView3.setOnClickListener(new View.OnClickListener() {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ boolean f24819a = true;

                            public final void onClick(View view) {
                                if (this.f24819a) {
                                    AJRFlightTravellersItenary.this.t();
                                } else if (AJRFlightTravellersItenary.this.w()) {
                                    AJRFlightTravellersItenary.this.t();
                                } else {
                                    AJRFlightTravellersItenary.this.x();
                                }
                            }
                        });
                        textView4.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                if (AJRFlightTravellersItenary.this.f24803e == null || !AJRFlightTravellersItenary.this.f24803e.equalsIgnoreCase("round_trip")) {
                                    AJRFlightTravellersItenary.j(AJRFlightTravellersItenary.this);
                                } else {
                                    AJRFlightTravellersItenary.i(AJRFlightTravellersItenary.this);
                                }
                                AJRFlightTravellersItenary.this.finish();
                            }
                        });
                        RoboTextView roboTextView = (RoboTextView) findViewById(R.id.btn_continue);
                        roboTextView.setVisibility(0);
                        roboTextView.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                AJRFlightTravellersItenary.this.G();
                            }
                        });
                    }
                }
            }
        }
    }

    static /* synthetic */ void i(AJRFlightTravellersItenary aJRFlightTravellersItenary) {
        Intent intent = new Intent(aJRFlightTravellersItenary, FlightSRPV2Activity.class);
        intent.addFlags(603979776);
        intent.putExtra(net.one97.paytmflight.common.b.b.f30018h, H5Param.MENU_REFRESH);
        if (aJRFlightTravellersItenary.L) {
            aJRFlightTravellersItenary.a(intent);
        }
        aJRFlightTravellersItenary.startActivity(intent);
    }

    static /* synthetic */ void j(AJRFlightTravellersItenary aJRFlightTravellersItenary) {
        Intent intent = new Intent(aJRFlightTravellersItenary, FlightSRPV2Activity.class);
        intent.addFlags(603979776);
        intent.putExtra(net.one97.paytmflight.common.b.b.f30018h, H5Param.MENU_REFRESH);
        if (aJRFlightTravellersItenary.L) {
            aJRFlightTravellersItenary.a(intent);
        }
        aJRFlightTravellersItenary.startActivity(intent);
    }
}
