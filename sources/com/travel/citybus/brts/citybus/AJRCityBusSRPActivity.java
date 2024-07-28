package com.travel.citybus.brts.citybus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.travel.citybus.R;
import com.travel.citybus.best.b.a;
import com.travel.citybus.best.b.c;
import com.travel.citybus.best.e.d;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestToken;
import com.travel.citybus.best.ui.a.a;
import com.travel.citybus.best.ui.a.c;
import com.travel.citybus.best.ui.a.g;
import com.travel.citybus.best.ui.activities.CityBusTokenValidationActivity;
import com.travel.citybus.brts.SwitchButton;
import com.travel.citybus.brts.citybus.w;
import com.travel.citybus.brts.model.CJRBCLLWithdraw;
import com.travel.citybus.brts.model.CJRBrtsFareInfo;
import com.travel.citybus.brts.model.CJRBrtsFareResponse;
import com.travel.citybus.brts.model.CJRBrtsPaxInfo;
import com.travel.citybus.brts.model.pojo.CJRBusStopFareModel;
import com.travel.citybus.brts.model.pojo.CJRCity;
import com.travel.citybus.brts.model.pojo.CJRCityAutoSuggest;
import com.travel.citybus.brts.model.pojo.CJRRouteApiResponseModel;
import com.travel.citybus.brts.model.pojo.CJRRouteInfoModel;
import com.travel.citybus.brts.model.pojo.CJRRouteModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class AJRCityBusSRPActivity extends PaytmActivity implements com.paytm.network.listener.b, a.C0443a, c.a, a.C0447a, c.a, g.a, aa, ab, w.a {
    private o<String, String> A;
    private CJRRouteInfoModel B;
    private HashMap C;

    /* renamed from: a  reason: collision with root package name */
    private com.travel.citybus.brts.c f23257a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public CJRRouteModel f23258b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<CJRRouteInfoModel> f23259c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private g f23260d;

    /* renamed from: e  reason: collision with root package name */
    private com.travel.citybus.best.c.a f23261e;

    /* renamed from: f  reason: collision with root package name */
    private com.travel.citybus.best.c.c f23262f;

    /* renamed from: g  reason: collision with root package name */
    private CJRCityAutoSuggest f23263g;

    /* renamed from: h  reason: collision with root package name */
    private CJRCityAutoSuggest f23264h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<CJRBrtsPaxInfo> f23265i = new ArrayList<>();
    /* access modifiers changed from: private */
    public CJRCity j;
    /* access modifiers changed from: private */
    public BestEPurse k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public double m;
    private ArrayList<CJRBrtsPaxInfo> n;
    private TextView o;
    private TextView p;
    private Button q;
    private FrameLayout r;
    private LinearLayout s;
    private AppCompatImageView t;
    private TextView u;
    private LinearLayout v;
    private LinearLayout w;
    private com.travel.citybus.best.ui.a.a x;
    private boolean y;
    private float z;

    public final void S_() {
    }

    public final View a(int i2) {
        if (this.C == null) {
            this.C = new HashMap();
        }
        View view = (View) this.C.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.C.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b() {
    }

    public static final /* synthetic */ com.travel.citybus.brts.c e(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
        com.travel.citybus.brts.c cVar = aJRCityBusSRPActivity.f23257a;
        if (cVar == null) {
            k.a("cjrCityBusSRPAdapter");
        }
        return cVar;
    }

    public static final /* synthetic */ g i(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
        g gVar = aJRCityBusSRPActivity.f23260d;
        if (gVar == null) {
            k.a("cjrSrpPresenter");
        }
        return gVar;
    }

    public static final /* synthetic */ FrameLayout l(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
        FrameLayout frameLayout = aJRCityBusSRPActivity.r;
        if (frameLayout == null) {
            k.a("frameDropdownRouteEdit");
        }
        return frameLayout;
    }

    public static final /* synthetic */ LinearLayout m(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
        LinearLayout linearLayout = aJRCityBusSRPActivity.s;
        if (linearLayout == null) {
            k.a("lnrDropdownRouteEdit");
        }
        return linearLayout;
    }

    public final void onCreate(Bundle bundle) {
        CJRCityAutoSuggest cJRCityAutoSuggest;
        CJRCityAutoSuggest cJRCityAutoSuggest2;
        super.onCreate(bundle);
        setContentView(R.layout.activity_city_bus_srp);
        this.f23260d = new g(this);
        Intent intent = getIntent();
        Serializable serializable = null;
        if (intent != null) {
            h hVar = h.f23284a;
            cJRCityAutoSuggest = (CJRCityAutoSuggest) intent.getParcelableExtra(h.e());
        } else {
            cJRCityAutoSuggest = null;
        }
        this.f23263g = cJRCityAutoSuggest;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            h hVar2 = h.f23284a;
            cJRCityAutoSuggest2 = (CJRCityAutoSuggest) intent2.getParcelableExtra(h.f());
        } else {
            cJRCityAutoSuggest2 = null;
        }
        this.f23264h = cJRCityAutoSuggest2;
        Intent intent3 = getIntent();
        this.j = (CJRCity) (intent3 != null ? intent3.getSerializableExtra("extra_city") : null);
        Intent intent4 = getIntent();
        if (intent4 != null) {
            serializable = intent4.getSerializableExtra("extra_e_purse");
        }
        this.k = (BestEPurse) serializable;
        this.f23261e = new com.travel.citybus.best.c.a(this, this.j, this.k);
        this.f23262f = new com.travel.citybus.best.c.c(this);
        View findViewById = findViewById(R.id.tvDropdownsourceName);
        k.a((Object) findViewById, "findViewById(R.id.tvDropdownsourceName)");
        this.o = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.tvDropdownDestinationName);
        k.a((Object) findViewById2, "findViewById(R.id.tvDropdownDestinationName)");
        this.p = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.btnDropdownFindmybus);
        k.a((Object) findViewById3, "findViewById(R.id.btnDropdownFindmybus)");
        this.q = (Button) findViewById3;
        View findViewById4 = findViewById(R.id.frameDropdownRouteEdit);
        k.a((Object) findViewById4, "findViewById(R.id.frameDropdownRouteEdit)");
        this.r = (FrameLayout) findViewById4;
        View findViewById5 = findViewById(R.id.lnrDropdownRouteEdit);
        k.a((Object) findViewById5, "findViewById(R.id.lnrDropdownRouteEdit)");
        this.s = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.aivInfoRefund);
        k.a((Object) findViewById6, "findViewById(R.id.aivInfoRefund)");
        this.t = (AppCompatImageView) findViewById6;
        View findViewById7 = findViewById(R.id.tvInfoRefund);
        k.a((Object) findViewById7, "findViewById(R.id.tvInfoRefund)");
        this.u = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.info_view);
        k.a((Object) findViewById8, "findViewById(R.id.info_view)");
        this.w = (LinearLayout) findViewById8;
        View findViewById9 = findViewById(R.id.lin_bottom_alart);
        k.a((Object) findViewById9, "findViewById(R.id.lin_bottom_alart)");
        this.v = (LinearLayout) findViewById9;
        if (!(this.f23263g == null || this.f23264h == null || this.j == null)) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.source_station_citybus_route_search_activity);
            k.a((Object) roboTextView, "source_station_citybus_route_search_activity");
            CJRCityAutoSuggest cJRCityAutoSuggest3 = this.f23263g;
            if (cJRCityAutoSuggest3 == null) {
                k.a();
            }
            roboTextView.setText(cJRCityAutoSuggest3.getName());
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.destination_station_citybus_route_search_activity);
            k.a((Object) roboTextView2, "destination_station_citybus_route_search_activity");
            CJRCityAutoSuggest cJRCityAutoSuggest4 = this.f23264h;
            if (cJRCityAutoSuggest4 == null) {
                k.a();
            }
            roboTextView2.setText(cJRCityAutoSuggest4.getName());
            g gVar = this.f23260d;
            if (gVar == null) {
                k.a("cjrSrpPresenter");
            }
            Context context = this;
            CJRCityAutoSuggest cJRCityAutoSuggest5 = this.f23263g;
            if (cJRCityAutoSuggest5 == null) {
                k.a();
            }
            String stationId = cJRCityAutoSuggest5.getStationId();
            CJRCityAutoSuggest cJRCityAutoSuggest6 = this.f23264h;
            if (cJRCityAutoSuggest6 == null) {
                k.a();
            }
            String stationId2 = cJRCityAutoSuggest6.getStationId();
            CJRCity cJRCity = this.j;
            if (cJRCity == null) {
                k.a();
            }
            String merchantId = cJRCity.getMerchantId();
            CJRCity cJRCity2 = this.j;
            if (cJRCity2 == null) {
                k.a();
            }
            String name = cJRCity2.getName();
            CJRCity cJRCity3 = this.j;
            if (cJRCity3 == null) {
                k.a();
            }
            String productId = cJRCity3.getProductId();
            k.c(context, "context");
            k.c(stationId, "merchantSourceId");
            k.c(stationId2, "merchantDestinationId");
            k.c(merchantId, SDKConstants.KEY_MERCHANT_ID);
            k.c(name, "city");
            k.c(productId, "productId");
            gVar.f23283a.a(true);
            Map hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            k.a((Object) com.travel.citybus.brts.f.d(), "TransportBrtsController.getInstance()");
            String a2 = com.travel.citybus.brts.f.e().a("cityBusRouteURL");
            if (TextUtils.isEmpty(a2)) {
                a2 = com.travel.citybus.brts.a.j;
            }
            Uri.Builder buildUpon = Uri.parse(a2).buildUpon();
            buildUpon.appendQueryParameter("merchantSourceId", stationId);
            buildUpon.appendQueryParameter("merchantDestinationId", stationId2);
            buildUpon.appendQueryParameter(SDKConstants.KEY_MERCHANT_ID, merchantId);
            buildUpon.appendQueryParameter("city", name);
            buildUpon.appendQueryParameter("productId", productId);
            com.paytm.network.a l2 = new com.paytm.network.b().a(context).a(a.c.TRANSPORT_BRTS).a(a.b.SILENT).c(q.class.getSimpleName()).a(a.C0715a.GET).a(buildUpon.build().toString()).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new CJRRouteApiResponseModel()).a((com.paytm.network.listener.b) gVar).l();
            l2.b(false);
            l2.a();
        }
        if (com.travel.citybus.best.a.a(this.j)) {
            AppCompatImageView appCompatImageView = this.t;
            if (appCompatImageView == null) {
                k.a("aivInfoRefund");
            }
            appCompatImageView.setVisibility(8);
            TextView textView = this.u;
            if (textView == null) {
                k.a("tvInfoRefund");
            }
            textView.setVisibility(8);
            LinearLayout linearLayout = this.v;
            if (linearLayout == null) {
                k.a("expiryAlertLayout");
            }
            linearLayout.setVisibility(8);
        } else {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.show_ac_bus_rl);
            k.a((Object) relativeLayout, "show_ac_bus_rl");
            relativeLayout.setVisibility(8);
        }
        ((SwitchButton) a(R.id.switch_show_ac_buses_toggle)).setOnCheckedChangeListener(new a(this));
        ((Button) a(R.id.reset_filter_button)).setOnClickListener(new b(this));
        ((Button) a(R.id.button_proceed)).setOnClickListener(new c(this));
        ((FrameLayout) a(R.id.back_button_layout_citybus_search_screen)).setOnClickListener(new d(this));
        RoboTextView roboTextView3 = (RoboTextView) a(R.id.date_textview);
        k.a((Object) roboTextView3, "date_textview");
        roboTextView3.setText(com.travel.citybus.brts.utils.a.a());
        ((TextView) a(R.id.total_passenger_no_text)).setOnClickListener(new e(this));
        ((TextView) a(R.id.text_complete_price)).setOnClickListener(new f(this));
        FrameLayout frameLayout = this.r;
        if (frameLayout == null) {
            k.a("frameDropdownRouteEdit");
        }
        frameLayout.setOnClickListener(new g(this));
    }

    static final class a implements SwitchButton.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCityBusSRPActivity f23266a;

        a(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
            this.f23266a = aJRCityBusSRPActivity;
        }

        public final void a(boolean z) {
            boolean z2 = true;
            if (z) {
                Collection a2 = this.f23266a.f23259c;
                if (a2 != null && !a2.isEmpty()) {
                    z2 = false;
                }
                if (!z2) {
                    this.f23266a.l = 0;
                    this.f23266a.m = 0.0d;
                    RelativeLayout relativeLayout = (RelativeLayout) this.f23266a.a(R.id.bottom_view_layout);
                    k.a((Object) relativeLayout, "bottom_view_layout");
                    if (relativeLayout.getVisibility() == 0) {
                        RelativeLayout relativeLayout2 = (RelativeLayout) this.f23266a.a(R.id.bottom_view_layout);
                        k.a((Object) relativeLayout2, "bottom_view_layout");
                        relativeLayout2.setVisibility(8);
                    }
                    com.travel.citybus.brts.c e2 = AJRCityBusSRPActivity.e(this.f23266a);
                    List a3 = this.f23266a.f23259c;
                    if (a3 == null) {
                        k.a();
                    }
                    e2.a((List<CJRRouteInfoModel>) a3);
                } else if (this.f23266a.f23259c.isEmpty()) {
                    View a4 = this.f23266a.a(R.id.not_found_layout);
                    k.a((Object) a4, "not_found_layout");
                    a4.setVisibility(0);
                    AJRCityBusSRPActivity.e(this.f23266a).a((List<CJRRouteInfoModel>) new ArrayList());
                }
            } else {
                View a5 = this.f23266a.a(R.id.not_found_layout);
                k.a((Object) a5, "not_found_layout");
                if (a5.getVisibility() == 0) {
                    View a6 = this.f23266a.a(R.id.not_found_layout);
                    k.a((Object) a6, "not_found_layout");
                    a6.setVisibility(8);
                }
                if (this.f23266a.f23258b != null) {
                    CJRRouteModel f2 = this.f23266a.f23258b;
                    if (f2 == null) {
                        k.a();
                    }
                    Collection routeInfoList = f2.getRouteInfoList();
                    if (routeInfoList != null && !routeInfoList.isEmpty()) {
                        z2 = false;
                    }
                    if (!z2) {
                        this.f23266a.l = 0;
                        this.f23266a.m = 0.0d;
                        RelativeLayout relativeLayout3 = (RelativeLayout) this.f23266a.a(R.id.bottom_view_layout);
                        k.a((Object) relativeLayout3, "bottom_view_layout");
                        if (relativeLayout3.getVisibility() == 0) {
                            RelativeLayout relativeLayout4 = (RelativeLayout) this.f23266a.a(R.id.bottom_view_layout);
                            k.a((Object) relativeLayout4, "bottom_view_layout");
                            relativeLayout4.setVisibility(8);
                        }
                        com.travel.citybus.brts.c e3 = AJRCityBusSRPActivity.e(this.f23266a);
                        CJRRouteModel f3 = this.f23266a.f23258b;
                        if (f3 == null) {
                            k.a();
                        }
                        e3.a(f3.getRouteInfoList());
                    }
                }
            }
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCityBusSRPActivity f23267a;

        b(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
            this.f23267a = aJRCityBusSRPActivity;
        }

        public final void onClick(View view) {
            View a2 = this.f23267a.a(R.id.not_found_layout);
            k.a((Object) a2, "not_found_layout");
            if (a2.getVisibility() == 0) {
                View a3 = this.f23267a.a(R.id.not_found_layout);
                k.a((Object) a3, "not_found_layout");
                a3.setVisibility(8);
            }
            SwitchButton switchButton = (SwitchButton) this.f23267a.a(R.id.switch_show_ac_buses_toggle);
            k.a((Object) switchButton, "switch_show_ac_buses_toggle");
            if (switchButton.isChecked()) {
                ((SwitchButton) this.f23267a.a(R.id.switch_show_ac_buses_toggle)).a();
            }
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCityBusSRPActivity f23268a;

        c(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
            this.f23268a = aJRCityBusSRPActivity;
        }

        /* JADX WARNING: type inference failed for: r3v3, types: [com.travel.citybus.best.model.BestToken] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                android.content.Context r9 = r9.getApplicationContext()
                boolean r9 = com.paytm.utility.b.c((android.content.Context) r9)
                if (r9 == 0) goto L_0x0177
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                android.content.Context r9 = r9.getApplicationContext()
                boolean r9 = com.paytm.utility.b.r((android.content.Context) r9)
                r0 = 0
                if (r9 == 0) goto L_0x0151
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                com.travel.citybus.brts.model.pojo.CJRCity r9 = r9.j
                boolean r9 = com.travel.citybus.best.a.a((com.travel.citybus.brts.model.pojo.CJRCity) r9)
                r1 = 1
                if (r9 == 0) goto L_0x0108
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                int r9 = r9.l
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r2 = r8.f23268a
                com.travel.citybus.best.model.BestEPurse r2 = r2.k
                r3 = 0
                if (r2 == 0) goto L_0x003e
                int r2 = r2.getMaxPassengerCount()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                goto L_0x003f
            L_0x003e:
                r2 = r3
            L_0x003f:
                if (r2 != 0) goto L_0x0044
                kotlin.g.b.k.a()
            L_0x0044:
                int r2 = r2.intValue()
                if (r9 <= r2) goto L_0x00af
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                r2 = r9
                android.content.Context r2 = (android.content.Context) r2
                int r4 = com.travel.citybus.R.string.passenger_limit_exceed
                java.lang.String r9 = r9.getString(r4)
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r4 = r8.f23268a
                int r5 = com.travel.citybus.R.string.maximum_passengers
                r6 = 2
                java.lang.Object[] r6 = new java.lang.Object[r6]
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r7 = r8.f23268a
                com.travel.citybus.best.model.BestEPurse r7 = r7.k
                if (r7 == 0) goto L_0x006d
                int r7 = r7.getMaxPassengerCount()
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                goto L_0x006e
            L_0x006d:
                r7 = r3
            L_0x006e:
                if (r7 != 0) goto L_0x0073
                kotlin.g.b.k.a()
            L_0x0073:
                int r7 = r7.intValue()
                java.lang.String r7 = java.lang.String.valueOf(r7)
                r6[r0] = r7
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r0 = r8.f23268a
                com.travel.citybus.best.model.BestEPurse r0 = r0.k
                if (r0 == 0) goto L_0x008d
                int r0 = r0.getMaxPassengerCount()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            L_0x008d:
                if (r3 != 0) goto L_0x0092
                kotlin.g.b.k.a()
            L_0x0092:
                int r0 = r3.intValue()
                if (r0 <= r1) goto L_0x009d
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r0 = r8.f23268a
                int r3 = com.travel.citybus.R.string.passengers
                goto L_0x00a1
            L_0x009d:
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r0 = r8.f23268a
                int r3 = com.travel.citybus.R.string.passenger
            L_0x00a1:
                java.lang.String r0 = r0.getString(r3)
                r6[r1] = r0
                java.lang.String r0 = r4.getString(r5, r6)
                com.paytm.utility.b.b((android.content.Context) r2, (java.lang.String) r9, (java.lang.String) r0)
                return
            L_0x00af:
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                com.travel.citybus.best.model.BestEPurse r9 = r9.k
                if (r9 == 0) goto L_0x00bb
                com.travel.citybus.best.model.BestToken r3 = r9.getToken()
            L_0x00bb:
                if (r3 == 0) goto L_0x00ec
                com.travel.citybus.best.ui.a.c r9 = new com.travel.citybus.best.ui.a.c
                r9.<init>()
                android.os.Bundle r1 = new android.os.Bundle
                r1.<init>()
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r2 = r8.f23268a
                com.travel.citybus.best.model.BestEPurse r2 = r2.k
                java.io.Serializable r2 = (java.io.Serializable) r2
                java.lang.String r3 = "extra_e_purse"
                r1.putSerializable(r3, r2)
                java.lang.String r2 = "from_validation_screen"
                r1.putBoolean(r2, r0)
                r9.setArguments(r1)
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r0 = r8.f23268a
                androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
                java.lang.Class<com.travel.citybus.best.ui.a.c> r1 = com.travel.citybus.best.ui.a.c.class
                java.lang.String r1 = r1.getSimpleName()
                r9.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
                return
            L_0x00ec:
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                r9.a((boolean) r1)
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                com.travel.citybus.brts.citybus.g r9 = com.travel.citybus.brts.citybus.AJRCityBusSRPActivity.i(r9)
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r0 = r8.f23268a
                android.content.Context r0 = (android.content.Context) r0
                java.lang.String r1 = "context"
                kotlin.g.b.k.c(r0, r1)
                com.travel.citybus.best.d.a r1 = com.travel.citybus.best.d.a.f23050a
                com.paytm.network.listener.b r9 = (com.paytm.network.listener.b) r9
                com.travel.citybus.best.d.a.a(r0, r9)
                return
            L_0x0108:
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                com.travel.citybus.brts.model.pojo.CJRCity r9 = r9.j
                if (r9 == 0) goto L_0x0139
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                com.travel.citybus.brts.model.pojo.CJRCity r9 = r9.j
                if (r9 != 0) goto L_0x011b
                kotlin.g.b.k.a()
            L_0x011b:
                java.lang.String r9 = r9.getMerchantName()
                boolean r9 = com.travel.citybus.best.a.a((java.lang.String) r9)
                if (r9 == 0) goto L_0x0139
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                int r9 = r9.l
                if (r9 <= r1) goto L_0x0139
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                android.content.Context r9 = (android.content.Context) r9
                java.lang.String r0 = "Sorry for the inconvenience!"
                java.lang.String r1 = "Cannot book more than one ticket or a child ticket"
                com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r0, (java.lang.String) r1)
                return
            L_0x0139:
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                r9.g()
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                int r1 = com.travel.citybus.R.id.button_proceed
                android.view.View r9 = r9.a((int) r1)
                android.widget.Button r9 = (android.widget.Button) r9
                java.lang.String r1 = "button_proceed"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
                r9.setEnabled(r0)
                return
            L_0x0151:
                android.content.Intent r9 = new android.content.Intent
                r9.<init>()
                java.lang.String r1 = "authError"
                r9.putExtra(r1, r0)
                java.lang.String r0 = "VERTICAL_NAME"
                java.lang.String r1 = "marketplace"
                r9.putExtra(r0, r1)
                com.travel.citybus.brts.f r0 = com.travel.citybus.brts.f.d()
                java.lang.String r1 = "TransportBrtsController.getInstance()"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                com.travel.citybus.a r0 = com.travel.citybus.brts.f.e()
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r1 = r8.f23268a
                android.content.Context r1 = (android.content.Context) r1
                r0.b(r1, r9)
                return
            L_0x0177:
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r9 = r8.f23268a
                r0 = r9
                android.content.Context r0 = (android.content.Context) r0
                int r1 = com.travel.citybus.R.string.no_internet_title
                java.lang.String r9 = r9.getString(r1)
                com.travel.citybus.brts.citybus.AJRCityBusSRPActivity r1 = r8.f23268a
                int r2 = com.travel.citybus.R.string.no_internet_message
                java.lang.String r1 = r1.getString(r2)
                com.paytm.utility.b.b((android.content.Context) r0, (java.lang.String) r9, (java.lang.String) r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.brts.citybus.AJRCityBusSRPActivity.c.onClick(android.view.View):void");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCityBusSRPActivity f23269a;

        d(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
            this.f23269a = aJRCityBusSRPActivity;
        }

        public final void onClick(View view) {
            this.f23269a.onBackPressed();
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCityBusSRPActivity f23270a;

        e(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
            this.f23270a = aJRCityBusSRPActivity;
        }

        public final void onClick(View view) {
            AJRCityBusSRPActivity.k(this.f23270a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCityBusSRPActivity f23271a;

        f(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
            this.f23271a = aJRCityBusSRPActivity;
        }

        public final void onClick(View view) {
            AJRCityBusSRPActivity.k(this.f23271a);
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCityBusSRPActivity f23272a;

        g(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
            this.f23272a = aJRCityBusSRPActivity;
        }

        public final void onClick(View view) {
            if (AJRCityBusSRPActivity.l(this.f23272a).getVisibility() == 0) {
                AJRCityBusSRPActivity.l(this.f23272a).setVisibility(8);
                com.travel.citybus.brts.utils.b.a(AJRCityBusSRPActivity.l(this.f23272a), AJRCityBusSRPActivity.m(this.f23272a)).start();
            }
        }
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        com.travel.citybus.a.a.a(context);
        k.a((Object) com.travel.citybus.brts.f.d(), "TransportBrtsController.getInstance()");
        super.attachBaseContext(com.travel.citybus.brts.f.e().a(context));
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 1287) {
            Boolean bool = null;
            String stringExtra = intent != null ? intent.getStringExtra("order_id") : null;
            if (intent != null) {
                bool = Boolean.valueOf(intent.getBooleanExtra(AppConstants.IS_CANCEL, true));
            }
            if (bool == null) {
                k.a();
            }
            if (bool.booleanValue() || stringExtra == null) {
                com.travel.citybus.best.ui.a.a aVar = this.x;
                if (aVar != null) {
                    aVar.a(false);
                }
                a(false);
            } else {
                com.travel.citybus.best.c.a aVar2 = this.f23261e;
                if (aVar2 == null) {
                    k.a("busEPursePresenter");
                }
                aVar2.a(this, stringExtra);
            }
        } else {
            com.travel.citybus.best.ui.a.a aVar3 = this.x;
            if (aVar3 != null) {
                aVar3.a(false);
            }
        }
        a(false);
    }

    public static final class h implements com.travel.citybus.brts.a.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCityBusSRPActivity f23273a;

        h(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
            this.f23273a = aJRCityBusSRPActivity;
        }

        public final void a() {
            ((Button) this.f23273a.a(R.id.button_proceed)).performClick();
        }
    }

    /* access modifiers changed from: private */
    public final void g() {
        a(true);
        if (com.paytm.utility.b.c(getApplicationContext())) {
            String a2 = com.paytm.utility.d.a(getApplicationContext());
            if (!TextUtils.isEmpty(a2)) {
                com.travel.citybus.brts.utils.c.a(a2, (Activity) this, (com.paytm.network.listener.b) this);
                return;
            }
            return;
        }
        a(false);
        com.travel.citybus.brts.utils.c.a((Activity) this);
        com.travel.citybus.best.ui.a.a aVar = this.x;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.travel.citybus.best.ui.a.a aVar = this.x;
        if (aVar != null) {
            aVar.a(false);
        }
        a(false);
        d.a aVar2 = com.travel.citybus.best.e.d.f23053a;
        String string = getString(R.string.brts_error);
        k.a((Object) string, "getString(R.string.brts_error)");
        String string2 = getString(R.string.brts_some_went_wrong);
        k.a((Object) string2, "getString(R.string.brts_some_went_wrong)");
        d.a.a(this, string, string2);
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        a(false);
        com.travel.citybus.best.ui.a.a aVar = this.x;
        if (aVar != null) {
            aVar.a(false);
        }
        if (iJRPaytmDataModel instanceof CJRPGTokenList) {
            AJRCityBusSRPActivity aJRCityBusSRPActivity = this;
            k.a((Object) com.travel.citybus.brts.f.d(), "TransportBrtsController.getInstance()");
            String a2 = com.travel.citybus.brts.f.e().a((CJRPGTokenList) iJRPaytmDataModel);
            if (!TextUtils.isEmpty(a2)) {
                aJRCityBusSRPActivity.a(true);
                com.travel.citybus.best.ui.a.a aVar2 = aJRCityBusSRPActivity.x;
                if (aVar2 != null) {
                    aVar2.a(true);
                }
                if (com.travel.citybus.best.a.a(aJRCityBusSRPActivity.j)) {
                    com.travel.citybus.best.c.a aVar3 = aJRCityBusSRPActivity.f23261e;
                    if (aVar3 == null) {
                        k.a("busEPursePresenter");
                    }
                    k.a((Object) a2, "walletSSOToken");
                    aVar3.a(aJRCityBusSRPActivity, a2, aJRCityBusSRPActivity.y, aJRCityBusSRPActivity.z);
                    return;
                }
                TextView textView = (TextView) aJRCityBusSRPActivity.a(R.id.text_complete_price);
                k.a((Object) textView, "text_complete_price");
                String obj = textView.getText().toString();
                CJRBrtsFareInfo cJRBrtsFareInfo = new CJRBrtsFareInfo();
                cJRBrtsFareInfo.setmResponse(new CJRBrtsFareResponse());
                CJRBrtsFareResponse response = cJRBrtsFareInfo.getResponse();
                CJRRouteModel cJRRouteModel = aJRCityBusSRPActivity.f23258b;
                String str = null;
                response.setmMerchantGuid(cJRRouteModel != null ? cJRRouteModel.getMerchantId() : null);
                cJRBrtsFareInfo.getResponse().setmIndustryType("");
                CJRBrtsFareResponse response2 = cJRBrtsFareInfo.getResponse();
                CJRRouteModel cJRRouteModel2 = aJRCityBusSRPActivity.f23258b;
                response2.setmSourceId(String.valueOf(cJRRouteModel2 != null ? Integer.valueOf(cJRRouteModel2.getSourceId()) : null));
                CJRBrtsFareResponse response3 = cJRBrtsFareInfo.getResponse();
                CJRRouteModel cJRRouteModel3 = aJRCityBusSRPActivity.f23258b;
                response3.setmSourceName(cJRRouteModel3 != null ? cJRRouteModel3.getMerchantSourceName() : null);
                CJRBrtsFareResponse response4 = cJRBrtsFareInfo.getResponse();
                CJRRouteModel cJRRouteModel4 = aJRCityBusSRPActivity.f23258b;
                response4.setmDestinationId(String.valueOf(cJRRouteModel4 != null ? Integer.valueOf(cJRRouteModel4.getDestinationId()) : null));
                CJRBrtsFareResponse response5 = cJRBrtsFareInfo.getResponse();
                CJRRouteModel cJRRouteModel5 = aJRCityBusSRPActivity.f23258b;
                response5.setmDestinationName(cJRRouteModel5 != null ? cJRRouteModel5.getMerchantDestinationName() : null);
                CJRBrtsFareResponse response6 = cJRBrtsFareInfo.getResponse();
                CJRRouteInfoModel cJRRouteInfoModel = aJRCityBusSRPActivity.B;
                response6.setmBusType(cJRRouteInfoModel != null ? cJRRouteInfoModel.getBusType() : null);
                CJRBrtsFareResponse response7 = cJRBrtsFareInfo.getResponse();
                CJRRouteInfoModel cJRRouteInfoModel2 = aJRCityBusSRPActivity.B;
                response7.setmRouteId(String.valueOf(cJRRouteInfoModel2 != null ? Integer.valueOf(cJRRouteInfoModel2.getRouteId()) : null));
                CJRBrtsFareResponse response8 = cJRBrtsFareInfo.getResponse();
                CJRRouteModel cJRRouteModel6 = aJRCityBusSRPActivity.f23258b;
                response8.setProductId(cJRRouteModel6 != null ? cJRRouteModel6.getProductId() : null);
                CJRBrtsFareResponse response9 = cJRBrtsFareInfo.getResponse();
                CJRRouteInfoModel cJRRouteInfoModel3 = aJRCityBusSRPActivity.B;
                response9.setmRouteName(cJRRouteInfoModel3 != null ? cJRRouteInfoModel3.getRouteName() : null);
                CJRBrtsFareResponse response10 = cJRBrtsFareInfo.getResponse();
                CJRRouteModel cJRRouteModel7 = aJRCityBusSRPActivity.f23258b;
                response10.setBrandId(String.valueOf(cJRRouteModel7 != null ? cJRRouteModel7.getBrandId() : null));
                CJRBrtsFareResponse response11 = cJRBrtsFareInfo.getResponse();
                CJRRouteModel cJRRouteModel8 = aJRCityBusSRPActivity.f23258b;
                response11.setVehicleNumber(String.valueOf(cJRRouteModel8 != null ? cJRRouteModel8.getVehicleNo() : null));
                CJRBrtsFareResponse response12 = cJRBrtsFareInfo.getResponse();
                CJRRouteModel cJRRouteModel9 = aJRCityBusSRPActivity.f23258b;
                if (cJRRouteModel9 != null) {
                    str = cJRRouteModel9.getCity();
                }
                response12.setCity(str);
                cJRBrtsFareInfo.getResponse().setPaxInfo(aJRCityBusSRPActivity.f23265i);
                com.travel.citybus.brts.utils.a.a(aJRCityBusSRPActivity.getApplicationContext(), a2, cJRBrtsFareInfo, obj, "", aJRCityBusSRPActivity);
                return;
            }
            Button button = (Button) aJRCityBusSRPActivity.a(R.id.button_proceed);
            k.a((Object) button, "button_proceed");
            button.setEnabled(true);
        } else if (iJRPaytmDataModel instanceof CJRBCLLWithdraw) {
            AJRCityBusSRPActivity aJRCityBusSRPActivity2 = this;
            CJRBCLLWithdraw cJRBCLLWithdraw = (CJRBCLLWithdraw) iJRPaytmDataModel;
            CJRRechargePayment response13 = cJRBCLLWithdraw.getResponse();
            Button button2 = (Button) aJRCityBusSRPActivity2.a(R.id.button_proceed);
            k.a((Object) button2, "button_proceed");
            button2.setEnabled(true);
            k.a((Object) response13, "rechargePayment");
            if (response13.getStatus() == null || !p.a(response13.getStatus(), "SUCCESS", true)) {
                d.a aVar4 = com.travel.citybus.best.e.d.f23053a;
                String string = aJRCityBusSRPActivity2.getString(R.string.brts_error);
                k.a((Object) string, "getString(R.string.brts_error)");
                String statusMessage = cJRBCLLWithdraw.getStatusMessage();
                k.a((Object) statusMessage, "response.statusMessage");
                d.a.a(aJRCityBusSRPActivity2, string, statusMessage);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(SDKConstants.PAYMENT_INFO, response13);
            intent.putExtra(UpiConstants.FROM, "Unreserved Bus Ticketing");
            k.a((Object) com.travel.citybus.brts.f.d(), "TransportBrtsController.getInstance()");
            com.travel.citybus.brts.f.e().c(aJRCityBusSRPActivity2, intent);
        }
    }

    public final void a(CJRRouteModel cJRRouteModel) {
        k.c(cJRRouteModel, "cjrRouteModel");
        this.f23258b = cJRRouteModel;
        CJRRouteModel cJRRouteModel2 = this.f23258b;
        if (cJRRouteModel2 == null) {
            k.a();
        }
        Iterator<CJRRouteInfoModel> it2 = cJRRouteModel2.getRouteInfoList().iterator();
        while (it2.hasNext()) {
            CJRRouteInfoModel next = it2.next();
            if (com.travel.citybus.best.a.b(this.j) && (p.a(next.getBusType(), "AC", true) || p.a(next.getBusType(), "AC Bus", true))) {
                this.f23259c.add(next);
            }
            if (com.travel.citybus.best.a.a(this.j)) {
                Boolean bool = null;
                if ((next != null ? next.isAC() : null) != null) {
                    if (next != null) {
                        bool = next.isAC();
                    }
                    if (bool == null) {
                        k.a();
                    }
                    if (bool.booleanValue()) {
                        this.f23259c.add(next);
                    }
                }
            }
        }
        Context context = this;
        this.f23257a = new com.travel.citybus.brts.c(context, this, this, this.j, this.k, cJRRouteModel, this.f23265i);
        RecyclerView recyclerView = (RecyclerView) a(R.id.citybus_recyclerview_in_metro_route_search_layout);
        k.a((Object) recyclerView, "citybus_recyclerview_in_metro_route_search_layout");
        com.travel.citybus.brts.c cVar = this.f23257a;
        if (cVar == null) {
            k.a("cjrCityBusSRPAdapter");
        }
        recyclerView.setAdapter(cVar);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.citybus_recyclerview_in_metro_route_search_layout);
        k.a((Object) recyclerView2, "citybus_recyclerview_in_metro_route_search_layout");
        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        ((RecyclerView) a(R.id.citybus_recyclerview_in_metro_route_search_layout)).setHasFixedSize(true);
    }

    public final void a(boolean z2) {
        if (z2) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.lottie_progress_bar);
            k.a((Object) lottieAnimationView, "lottie_progress_bar");
            lottieAnimationView.setVisibility(0);
            Button button = (Button) a(R.id.button_proceed);
            k.a((Object) button, "button_proceed");
            button.setEnabled(false);
            return;
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) a(R.id.lottie_progress_bar);
        k.a((Object) lottieAnimationView2, "lottie_progress_bar");
        lottieAnimationView2.setVisibility(8);
        Button button2 = (Button) a(R.id.button_proceed);
        k.a((Object) button2, "button_proceed");
        button2.setEnabled(true);
    }

    public final void a(String str, String str2) {
        View a2 = a(R.id.no_route_layout);
        k.a((Object) a2, "no_route_layout");
        a2.setVisibility(0);
        if (str != null) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.header_textview_route_not_found);
            k.a((Object) roboTextView, "header_textview_route_not_found");
            roboTextView.setText(str);
        }
        if (str2 != null) {
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.extra_textview_route_not_found);
            k.a((Object) roboTextView2, "extra_textview_route_not_found");
            roboTextView2.setText(str2);
        }
    }

    public final void a(CJRRouteInfoModel cJRRouteInfoModel, String str) {
        k.c(cJRRouteInfoModel, "route");
        k.c(str, "imageUrl");
        t tVar = new t();
        Bundle bundle = new Bundle();
        Collection arrayList = new ArrayList();
        Iterator it2 = cJRRouteInfoModel.getFareDetailsList().iterator();
        while (true) {
            boolean z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            int paxId = ((CJRBusStopFareModel) next).getPaxId();
            h hVar = h.f23284a;
            if (paxId == h.n()) {
                z2 = true;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (!list.isEmpty()) {
            h hVar2 = h.f23284a;
            bundle.putDouble(h.h(), ((CJRBusStopFareModel) list.get(0)).getAmount());
        }
        h hVar3 = h.f23284a;
        bundle.putString(h.i(), cJRRouteInfoModel.getRouteName());
        h hVar4 = h.f23284a;
        bundle.putString(h.j(), cJRRouteInfoModel.getBusType());
        h hVar5 = h.f23284a;
        String k2 = h.k();
        Integer noOfStops = cJRRouteInfoModel.getNoOfStops();
        if (noOfStops == null) {
            k.a();
        }
        bundle.putInt(k2, noOfStops.intValue());
        h hVar6 = h.f23284a;
        bundle.putString(h.l(), str);
        h hVar7 = h.f23284a;
        bundle.putParcelableArrayList(h.g(), cJRRouteInfoModel.getIntermediateBusStops());
        tVar.setArguments(bundle);
        tVar.show(getSupportFragmentManager(), t.class.getSimpleName());
    }

    public final void e() {
        this.l = 0;
        this.m = 0.0d;
        RelativeLayout relativeLayout = (RelativeLayout) a(R.id.bottom_view_layout);
        k.a((Object) relativeLayout, "bottom_view_layout");
        relativeLayout.setVisibility(8);
        TextView textView = (TextView) a(R.id.total_passenger_no_text);
        k.a((Object) textView, "total_passenger_no_text");
        textView.setText("");
        TextView textView2 = (TextView) a(R.id.text_complete_price);
        k.a((Object) textView2, "text_complete_price");
        textView2.setText("");
    }

    public final void a(boolean z2, double d2, CJRRouteInfoModel cJRRouteInfoModel, ArrayList<CJRBrtsPaxInfo> arrayList, o<String, String> oVar) {
        k.c(cJRRouteInfoModel, "route");
        k.c(arrayList, "paxList");
        this.n = arrayList;
        this.B = cJRRouteInfoModel;
        this.A = oVar;
        if (z2) {
            this.l++;
            this.m += d2;
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.bottom_view_layout);
            k.a((Object) relativeLayout, "bottom_view_layout");
            if (relativeLayout.getVisibility() == 8) {
                RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.bottom_view_layout);
                k.a((Object) relativeLayout2, "bottom_view_layout");
                relativeLayout2.setVisibility(0);
            }
        } else {
            this.l--;
            this.m -= d2;
            RelativeLayout relativeLayout3 = (RelativeLayout) a(R.id.bottom_view_layout);
            k.a((Object) relativeLayout3, "bottom_view_layout");
            if (relativeLayout3.getVisibility() == 0 && this.l == 0) {
                RelativeLayout relativeLayout4 = (RelativeLayout) a(R.id.bottom_view_layout);
                k.a((Object) relativeLayout4, "bottom_view_layout");
                relativeLayout4.setVisibility(8);
            }
        }
        TextView textView = (TextView) a(R.id.text_complete_price);
        k.a((Object) textView, "text_complete_price");
        textView.setText(com.travel.citybus.brts.utils.a.a(Double.valueOf(this.m)));
        if (com.travel.citybus.best.a.b(this.j) || com.travel.citybus.best.a.c(this.j)) {
            TextView textView2 = (TextView) a(R.id.expiry_note_text);
            k.a((Object) textView2, "expiry_note_text");
            textView2.setText("Please note, your ticket will be valid for 1 hour post booking");
        }
        if (this.l == 1) {
            TextView textView3 = (TextView) a(R.id.total_passenger_no_text);
            k.a((Object) textView3, "total_passenger_no_text");
            textView3.setText(getResources().getString(R.string.total_for) + ' ' + this.l + ' ' + getResources().getString(R.string.passenger));
            return;
        }
        TextView textView4 = (TextView) a(R.id.total_passenger_no_text);
        k.a((Object) textView4, "total_passenger_no_text");
        textView4.setText(getResources().getString(R.string.total_for) + ' ' + this.l + ' ' + getResources().getString(R.string.passengers));
    }

    public final void b(BestEPurse bestEPurse) {
        k.c(bestEPurse, "data");
        this.k = bestEPurse;
        BestEPurse bestEPurse2 = this.k;
        if (bestEPurse2 != null) {
            double d2 = this.m;
            Float valueOf = bestEPurse2 != null ? Float.valueOf(bestEPurse2.getAmountBalance()) : null;
            if (valueOf == null) {
                k.a();
            }
            if (d2 <= ((double) valueOf.floatValue())) {
                a(true);
                h();
                return;
            }
        }
        com.travel.citybus.best.ui.a.g gVar = new com.travel.citybus.best.ui.a.g();
        Bundle bundle = new Bundle();
        BestEPurse bestEPurse3 = this.k;
        bundle.putFloat("extra_current_price", bestEPurse3 != null ? bestEPurse3.getAmountBalance() : 0.0f);
        gVar.setArguments(bundle);
        gVar.show(getSupportFragmentManager(), com.travel.citybus.best.ui.a.g.class.getSimpleName());
    }

    public final void f() {
        a(false);
        d.a aVar = com.travel.citybus.best.e.d.f23053a;
        String string = getString(R.string.brts_error);
        k.a((Object) string, "getString(R.string.brts_error)");
        String string2 = getString(R.string.city_bus_failed_fetch_purse_details);
        k.a((Object) string2, "getString(R.string.city_…iled_fetch_purse_details)");
        d.a.a(this, string, string2);
    }

    public final void d() {
        Bundle bundle = new Bundle();
        BestEPurse bestEPurse = this.k;
        float f2 = 0.0f;
        bundle.putFloat("extra_min_balance_e_purse", bestEPurse != null ? bestEPurse.getMinBalance() : 0.0f);
        TextView textView = (TextView) a(R.id.text_complete_price);
        k.a((Object) textView, "text_complete_price");
        bundle.putFloat("extra_total_price", Float.parseFloat(textView.getText().toString()));
        BestEPurse bestEPurse2 = this.k;
        if (bestEPurse2 != null) {
            f2 = bestEPurse2.getAmountBalance();
        }
        bundle.putFloat("extra_current_price", f2);
        bundle.putSerializable("extra_e_purse", this.k);
        this.x = new com.travel.citybus.best.ui.a.a();
        com.travel.citybus.best.ui.a.a aVar = this.x;
        if (aVar == null) {
            k.a();
        }
        aVar.setArguments(bundle);
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            q a2 = supportFragmentManager.a();
            com.travel.citybus.best.ui.a.a aVar2 = this.x;
            if (aVar2 == null) {
                k.a();
            }
            a2.a((Fragment) aVar2, com.travel.citybus.best.ui.a.a.class.getSimpleName()).b();
        }
    }

    public final void a(boolean z2, float f2) {
        this.y = z2;
        this.z = f2;
        g();
    }

    public final void a(CJRRechargePayment cJRRechargePayment) {
        k.c(cJRRechargePayment, "rechargePayment");
        Intent intent = new Intent();
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra("city_bus_add_money", true);
        k.a((Object) com.travel.citybus.brts.f.d(), "TransportBrtsController.getInstance()");
        com.travel.citybus.brts.f.e().d(this, intent);
    }

    public final void a(String str) {
        a(false);
        com.travel.citybus.best.ui.a.a aVar = this.x;
        if (aVar != null) {
            aVar.a(false);
        }
        d.a aVar2 = com.travel.citybus.best.e.d.f23053a;
        Context context = this;
        String string = getString(R.string.brts_error);
        k.a((Object) string, "getString(R.string.brts_error)");
        if (str == null) {
            str = getString(R.string.brts_some_went_wrong);
            k.a((Object) str, "getString(R.string.brts_some_went_wrong)");
        }
        d.a.a(context, string, str);
    }

    public final void R_() {
        a(false);
        com.travel.citybus.best.ui.a.a aVar = this.x;
        if (aVar != null) {
            aVar.a(false);
        }
        com.travel.citybus.best.ui.a.a aVar2 = this.x;
        if (aVar2 != null) {
            aVar2.dismiss();
        }
    }

    public final void a(com.travel.citybus.best.a.a aVar) {
        k.c(aVar, "status");
        com.travel.citybus.best.ui.a.a aVar2 = this.x;
        if (aVar2 != null) {
            aVar2.a(false);
        }
        a(false);
        int i2 = a.f23274a[aVar.ordinal()];
        if (i2 == 1) {
            h();
            com.travel.citybus.best.ui.a.a aVar3 = this.x;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
        } else if (i2 == 2) {
            d.a aVar4 = com.travel.citybus.best.e.d.f23053a;
            String string = getString(R.string.city_bus_best_payment_pending);
            k.a((Object) string, "getString(R.string.city_bus_best_payment_pending)");
            String string2 = getString(R.string.city_bus_best_pending_payment_epurse_recharge);
            k.a((Object) string2, "getString(R.string.city_…_payment_epurse_recharge)");
            d.a.a(this, string, string2);
            com.travel.citybus.best.ui.a.a aVar5 = this.x;
            if (aVar5 != null) {
                aVar5.dismiss();
            }
        } else if (i2 == 3) {
            d.a aVar6 = com.travel.citybus.best.e.d.f23053a;
            String string3 = getString(R.string.city_bus_best_payment_failed);
            k.a((Object) string3, "getString(R.string.city_bus_best_payment_failed)");
            String string4 = getString(R.string.city_bus_best_failed_payment_epurse_recharge);
            k.a((Object) string4, "getString(R.string.city_…_payment_epurse_recharge)");
            d.a.a(this, string3, string4);
        }
    }

    public final void a(BestEPurse bestEPurse) {
        com.travel.citybus.best.ui.a.a aVar = this.x;
        if (aVar != null) {
            aVar.dismiss();
        }
        a(false);
        Intent intent = new Intent(this, CityBusTokenValidationActivity.class);
        CJRCity cJRCity = this.j;
        intent.putExtra("best_image_logo", cJRCity != null ? cJRCity.getImageURL() : null);
        intent.putExtra("best_e_purse_data", bestEPurse);
        intent.putExtra("is_from_payment", true);
        startActivity(intent);
        finish();
    }

    public final void a() {
        BestEPurse bestEPurse = this.k;
        if (bestEPurse != null) {
            bestEPurse.setToken((BestToken) null);
        }
    }

    public final void c() {
        com.travel.citybus.best.ui.a.a aVar = this.x;
        if (aVar != null) {
            aVar.dismiss();
        }
        a(false);
        d.a aVar2 = com.travel.citybus.best.e.d.f23053a;
        String string = getString(R.string.brts_error);
        k.a((Object) string, "getString(R.string.brts_error)");
        String string2 = getString(R.string.brts_some_went_wrong);
        k.a((Object) string2, "getString(R.string.brts_some_went_wrong)");
        d.a.a(this, string, string2);
    }

    public final void b(String str) {
        com.travel.citybus.best.ui.a.a aVar = this.x;
        if (aVar != null) {
            aVar.dismiss();
        }
        a(false);
        d.a aVar2 = com.travel.citybus.best.e.d.f23053a;
        Context context = this;
        String string = getString(R.string.brts_error);
        k.a((Object) string, "getString(R.string.brts_error)");
        if (str == null) {
            str = getString(R.string.some_went_wrong);
            k.a((Object) str, "getString(R.string.some_went_wrong)");
        }
        d.a.a(context, string, str);
    }

    private final void h() {
        o<String, String> oVar = this.A;
        if (oVar != null) {
            com.travel.citybus.best.c.c cVar = this.f23262f;
            if (cVar == null) {
                k.a("cityBusTokenPresenter");
            }
            cVar.a(this, this.B, oVar, this.f23265i);
        }
    }

    public static final /* synthetic */ void k(AJRCityBusSRPActivity aJRCityBusSRPActivity) {
        v vVar = new v(new h(aJRCityBusSRPActivity));
        Bundle bundle = new Bundle();
        ArrayList<CJRBrtsPaxInfo> arrayList = aJRCityBusSRPActivity.n;
        if (arrayList == null) {
            k.a("mPaxList");
        }
        if (arrayList != null) {
            bundle.putParcelableArrayList("pax_list_key", arrayList);
            vVar.setArguments(bundle);
            vVar.show(aJRCityBusSRPActivity.getSupportFragmentManager(), v.class.getSimpleName());
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.ArrayList<out android.os.Parcelable> /* = java.util.ArrayList<out android.os.Parcelable> */");
    }
}
