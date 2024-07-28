package net.one97.paytm.o2o.amusementpark.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.viewpager.widget.ViewPager;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.c;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.amPark.CJRAddressDetailModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;
import net.one97.paytm.common.entity.amPark.CJRParkRidesDetailModel;
import net.one97.paytm.common.entity.amPark.CJRParticularAmParkDescriptionModel;
import net.one97.paytm.common.entity.amPark.CJRResourceDetailModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.widgets.CirclePageIndicator;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.a.n;
import net.one97.paytm.o2o.amusementpark.d.e;
import net.one97.paytm.o2o.amusementpark.utils.d;
import net.one97.paytm.o2o.amusementpark.utils.k;
import net.one97.paytm.o2o.amusementpark.utils.m;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRAmParkDetailPage extends PaytmActivity implements View.OnClickListener, b {
    private RoboTextView A;

    /* renamed from: a  reason: collision with root package name */
    e f73312a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f73313b;

    /* renamed from: c  reason: collision with root package name */
    private String f73314c;

    /* renamed from: d  reason: collision with root package name */
    private String f73315d;

    /* renamed from: e  reason: collision with root package name */
    private String f73316e;

    /* renamed from: f  reason: collision with root package name */
    private String f73317f;

    /* renamed from: g  reason: collision with root package name */
    private String f73318g;

    /* renamed from: h  reason: collision with root package name */
    private ProgressBar f73319h;

    /* renamed from: i  reason: collision with root package name */
    private CJRParticularAmParkDescriptionModel f73320i;
    private ScrollView j;
    private LinearLayout k;
    private RoboButton l;
    private ImageView m;
    private RoboTextView n;
    private RoboTextView o;
    private RoboTextView p;
    private RoboTextView q;
    private RelativeLayout r;
    private RelativeLayout s;
    private RelativeLayout t;
    private ViewPager u;
    private CirclePageIndicator v;
    private RoboTextView w;
    private RoboTextView x;
    private RoboTextView y;
    private RoboTextView z;

    public void attachBaseContext(Context context) {
        if (a.a() == null) {
            new m();
            m.a();
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(a.a().getBaseContext(context));
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.am_park_detail_page_layout);
        this.f73313b = (LinearLayout) findViewById(R.id.no_network);
        this.f73319h = (ProgressBar) findViewById(R.id.park_detail_progress_bar);
        this.j = (ScrollView) findViewById(R.id.scrollview);
        this.k = (LinearLayout) findViewById(R.id.btn_event_detail_book_tickets_layout);
        this.l = (RoboButton) findViewById(R.id.btn_event_detail_book_tickets);
        this.m = (ImageView) findViewById(R.id.back_arrow);
        this.n = (RoboTextView) findViewById(R.id.tv_event_name);
        this.o = (RoboTextView) findViewById(R.id.tv_event_open_close_time);
        this.p = (RoboTextView) findViewById(R.id.tv_event_schedule);
        this.q = (RoboTextView) findViewById(R.id.tv_event_price);
        this.u = (ViewPager) findViewById(R.id.viewPager);
        this.v = (CirclePageIndicator) findViewById(R.id.indicator);
        this.r = (RelativeLayout) findViewById(R.id.relativeLayout1);
        this.s = (RelativeLayout) findViewById(R.id.relativeLayout2);
        this.t = (RelativeLayout) findViewById(R.id.relativeLayout3);
        this.w = (RoboTextView) findViewById(R.id.tv_term_and_condition);
        this.x = (RoboTextView) findViewById(R.id.tv_instruction);
        this.y = (RoboTextView) findViewById(R.id.tv_rides);
        this.z = (RoboTextView) findViewById(R.id.tv_venu);
        this.A = (RoboTextView) findViewById(R.id.tv_buy_ticket);
        this.p.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.f73312a = new e() {
            public final void a(CJRResourceDetailModel cJRResourceDetailModel, int i2) {
                if (H5ResourceHandlerUtil.VIDEO.equalsIgnoreCase(cJRResourceDetailModel.getType())) {
                    AJRAmParkDetailPage aJRAmParkDetailPage = AJRAmParkDetailPage.this;
                    String value1 = cJRResourceDetailModel.getValue1();
                    String str = null;
                    try {
                        Intent intent = new Intent(aJRAmParkDetailPage, a.a().getYoutubeActivityClass());
                        if (value1 != null && !TextUtils.isEmpty(value1)) {
                            "URL ------".concat(String.valueOf(value1));
                            com.paytm.utility.b.j();
                            str = com.paytm.utility.b.e(value1);
                            if (str == null) {
                                str = com.paytm.utility.b.f(value1);
                            }
                            "VIDEO ID ------".concat(String.valueOf(str));
                            com.paytm.utility.b.j();
                        }
                        if (str != null && !TextUtils.isEmpty(str)) {
                            intent.putExtra(com.paytm.utility.e.aA, str);
                            aJRAmParkDetailPage.startActivity(intent);
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    AJRAmParkDetailPage.a(AJRAmParkDetailPage.this, i2);
                }
            }
        };
        findViewById(R.id.network_retry_btn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (com.paytm.utility.b.c((Context) AJRAmParkDetailPage.this)) {
                    AJRAmParkDetailPage.this.a();
                }
            }
        });
        this.f73313b.setVisibility(com.paytm.utility.b.c((Context) this) ? 8 : 0);
        Intent intent = getIntent();
        if (intent != null && !intent.getExtras().containsKey("extra_home_data")) {
            this.f73314c = intent.getStringExtra("userselectedcity");
            this.f73315d = intent.getStringExtra("selectedcategoryname");
            this.f73316e = intent.getStringExtra("selectedeventproviderid");
            this.f73317f = intent.getStringExtra("selectedevent");
            this.f73318g = intent.getStringExtra("selectedeventid");
        } else if (intent != null && intent.getExtras().containsKey("extra_home_data")) {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) intent.getSerializableExtra("extra_home_data");
            if (cJRHomePageItem != null) {
                this.f73314c = cJRHomePageItem.getmParkCityName();
                this.f73315d = cJRHomePageItem.getmParkCategory();
                this.f73316e = cJRHomePageItem.getmParkProviderId();
                this.f73317f = cJRHomePageItem.getmParkName();
                this.f73318g = cJRHomePageItem.getmEventId();
            }
            if (cJRHomePageItem != null) {
                try {
                    if (cJRHomePageItem instanceof CJRHomePageItem) {
                        a.C1469a b2 = a.b();
                        b2.sendDeepLinkOpen("/amusement-parks/" + this.f73317f, cJRHomePageItem, this);
                    }
                } catch (Exception unused) {
                }
            }
        }
        a();
        k.a(this, 2, this.f73318g);
    }

    /* access modifiers changed from: private */
    public void a() {
        try {
            if (com.paytm.utility.b.c((Context) this)) {
                c();
                a(false);
                String str = net.one97.paytm.o2o.amusementpark.utils.e.b(this.f73314c) + "/" + net.one97.paytm.o2o.amusementpark.utils.e.b(this.f73315d) + "/" + net.one97.paytm.o2o.amusementpark.utils.e.b(this.f73317f) + "/" + net.one97.paytm.o2o.amusementpark.utils.e.b(this.f73318g);
                String b2 = c.b(a.a().getStringFromGTM("selected_ampark_detail_url") + str.replace("+", "%20"), (Context) this);
                if (com.paytm.utility.b.r((Context) this)) {
                    b2 = b2 + "&customer_id=" + com.paytm.utility.b.n((Context) this);
                }
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = this;
                bVar.f42878b = a.c.AM_PARK;
                bVar.f42879c = a.C0715a.GET;
                bVar.f42880d = b2;
                bVar.f42881e = null;
                bVar.f42882f = null;
                bVar.f42883g = null;
                bVar.f42884h = null;
                bVar.f42885i = new CJRParticularAmParkDescriptionModel();
                bVar.n = a.b.USER_FACING;
                bVar.o = "AmPark";
                bVar.j = this;
                bVar.t = b();
                com.paytm.network.a l2 = bVar.l();
                l2.f42859c = false;
                l2.a();
                return;
            }
            a(true);
        } catch (Exception unused) {
        }
    }

    public void onClick(View view) {
        this.p.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        if (view.getId() == R.id.tv_event_schedule || view.getId() == R.id.btn_event_detail_book_tickets) {
            a(view);
        } else if (view.getId() == R.id.back_arrow) {
            onBackPressed();
        } else if (view.getId() == R.id.tv_term_and_condition) {
            Intent intent = new Intent(view.getContext(), TermsConditionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("terms_and_condition_key", this.f73320i.getTerms());
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (view.getId() == R.id.tv_instruction) {
            Intent intent2 = new Intent(view.getContext(), ImportantNotesActivity.class);
            Bundle bundle2 = new Bundle();
            bundle2.putString("instructions_key", this.f73320i.getInstructions());
            intent2.putExtras(bundle2);
            startActivity(intent2);
        } else if (view.getId() == R.id.relativeLayout1) {
            a(view);
        } else if (view.getId() == R.id.relativeLayout2) {
            ArrayList<CJRParkRidesDetailModel> arrayList = this.f73320i.getmMajorAttractions();
            Intent intent3 = new Intent(view.getContext(), ParkRidesActivity.class);
            Bundle bundle3 = new Bundle();
            bundle3.putSerializable("rides_key", arrayList);
            intent3.putExtras(bundle3);
            startActivity(intent3);
        } else if (view.getId() == R.id.relativeLayout3) {
            Intent intent4 = new Intent(this, FullMapActivity.class);
            net.one97.paytm.common.c.a aVar = null;
            CJRAddressDetailModel cJRAddressDetailModel = this.f73320i.getmAddress();
            if (cJRAddressDetailModel != null) {
                aVar = new net.one97.paytm.common.c.a();
                aVar.setaddressLatitue(cJRAddressDetailModel.getLatitude().doubleValue());
                aVar.setAddressLongitude(cJRAddressDetailModel.getLongitude().doubleValue());
                aVar.setAddressHeader(cJRAddressDetailModel.getAddressName());
                aVar.setAddressText(cJRAddressDetailModel.getAddress());
            }
            intent4.putExtra(net.one97.paytm.common.c.a.MAP_DATA_INTENT_KEY, aVar);
            startActivity(intent4);
        }
    }

    private void a(View view) {
        k.b(view.getContext(), 2, this.f73318g);
        if (!net.one97.paytm.o2o.amparkeventcommonlib.b.a.INSTANCE.validateIsAlreadyClicked(this, view) && this.f73320i != null) {
            Intent intent = new Intent(this, AJRAmParkBookActivity.class);
            this.f73320i.setCitySearched(this.f73314c);
            this.f73320i.setEntityCity(this.f73314c);
            intent.putExtra("event-address-list", this.f73320i);
            startActivity(intent);
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if ((iJRPaytmDataModel instanceof CJRParticularAmParkDescriptionModel) && iJRPaytmDataModel != null) {
            this.f73320i = (CJRParticularAmParkDescriptionModel) iJRPaytmDataModel;
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            if (!TextUtils.isEmpty(this.f73320i.getRideLabel())) {
                this.y.setText(this.f73320i.getRideLabel());
            }
            if (!TextUtils.isEmpty(this.f73320i.getVenueLabel())) {
                this.z.setText(this.f73320i.getVenueLabel());
            }
            if (!TextUtils.isEmpty(this.f73320i.getBuyLabel())) {
                this.A.setText(this.f73320i.getBuyLabel());
            }
            if (!TextUtils.isEmpty(this.f73320i.getBuyLabel())) {
                this.l.setText(this.f73320i.getBuyLabel());
            }
            this.n.setText(TextUtils.isEmpty(this.f73320i.getName()) ? "" : this.f73320i.getName());
            String a2 = d.a(this.f73320i.getActiveFrom(), "yyyy-MM-dd HH:mm:ss", "h:mm a");
            String a3 = d.a(this.f73320i.getActiveTo(), "yyyy-MM-dd HH:mm:ss", "h:mm a");
            RoboTextView roboTextView = this.o;
            roboTextView.setText("Opens from " + a2 + " to " + a3);
            RoboTextView roboTextView2 = this.q;
            StringBuilder sb = new StringBuilder(FilterPriceSliderFragment.RUPEE_SYMBOL);
            sb.append(this.f73320i.getPrice());
            roboTextView2.setText(sb.toString());
            ArrayList<CJRResourceDetailModel> f2 = f();
            this.u.setAdapter(new n(f2, this.f73312a, com.paytm.utility.b.a((Activity) this), getResources().getDimensionPixelSize(R.dimen.dp_202), net.one97.paytm.o2o.amusementpark.a.a().getPicassoIsInMemory(), this));
            if (f2.size() > 1) {
                this.v.setVisibility(0);
                this.v.setViewPager(this.u);
            } else {
                this.v.setVisibility(8);
            }
            List<String> e2 = e();
            if (e2 != null && e2.size() == 0) {
                this.l.setText("Dates Not Available");
                this.l.setClickable(false);
                this.l.setBackgroundColor(getResources().getColor(R.color.flight_light_grey_disabled));
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        d();
        if (networkCustomError != null) {
            try {
                String message = networkCustomError.getMessage();
                if (message != null && message.equalsIgnoreCase("417")) {
                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getMessage());
                } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                    com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.networkResponse.statusCode));
                } else if (networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                    com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                } else {
                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                }
            } catch (Exception unused) {
            }
        }
    }

    private static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "AJRAmParkDetailPage");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void c() {
        ProgressBar progressBar = this.f73319h;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    private void d() {
        ProgressBar progressBar = this.f73319h;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private void a(boolean z2) {
        if (z2) {
            this.f73313b.setVisibility(0);
            d();
            return;
        }
        this.f73313b.setVisibility(8);
    }

    private List<String> e() {
        List<CJRAmParkDateTimeModel> list;
        CJRParticularAmParkDescriptionModel cJRParticularAmParkDescriptionModel = this.f73320i;
        if (cJRParticularAmParkDescriptionModel == null || (list = cJRParticularAmParkDescriptionModel.getmParkDateTimeList()) == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CJRAmParkDateTimeModel cJRAmParkDateTimeModel : list) {
            arrayList.addAll(cJRAmParkDateTimeModel.getmParkDateList());
        }
        return arrayList;
    }

    private ArrayList<CJRResourceDetailModel> f() {
        ArrayList<CJRResourceDetailModel> arrayList = new ArrayList<>();
        CJRParticularAmParkDescriptionModel cJRParticularAmParkDescriptionModel = this.f73320i;
        if (!(cJRParticularAmParkDescriptionModel == null || cJRParticularAmParkDescriptionModel.getResources() == null)) {
            for (CJRResourceDetailModel next : this.f73320i.getResources()) {
                if ("banner_app".equalsIgnoreCase(next.getType()) || "thumbnail_app".equalsIgnoreCase(next.getType()) || H5ResourceHandlerUtil.VIDEO.equalsIgnoreCase(next.getType())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private ArrayList<String> g() {
        CJRParticularAmParkDescriptionModel cJRParticularAmParkDescriptionModel = this.f73320i;
        if (cJRParticularAmParkDescriptionModel == null || cJRParticularAmParkDescriptionModel.getResources() == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (CJRResourceDetailModel next : this.f73320i.getResources()) {
            if ("banner_app".equalsIgnoreCase(next.getType()) || "thumbnail_app".equalsIgnoreCase(next.getType())) {
                if (next.getValue2() == null || "*".equalsIgnoreCase(next.getValue2()) || "**".equalsIgnoreCase(next.getValue2())) {
                    arrayList.add(next.getValue1());
                } else {
                    arrayList.add(next.getValue2());
                }
            }
            if (H5ResourceHandlerUtil.VIDEO.equalsIgnoreCase(next.getType())) {
                arrayList.add(next.getImage());
            }
        }
        return arrayList;
    }

    private ArrayList<CJRResourceDetailModel> h() {
        ArrayList<CJRResourceDetailModel> arrayList = new ArrayList<>();
        CJRParticularAmParkDescriptionModel cJRParticularAmParkDescriptionModel = this.f73320i;
        if (!(cJRParticularAmParkDescriptionModel == null || cJRParticularAmParkDescriptionModel.getResources() == null)) {
            for (CJRResourceDetailModel next : this.f73320i.getResources()) {
                if ("banner_app".equalsIgnoreCase(next.getType()) || "thumbnail_app".equalsIgnoreCase(next.getType())) {
                    arrayList.add(next);
                }
                if (H5ResourceHandlerUtil.VIDEO.equalsIgnoreCase(next.getType())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ void a(AJRAmParkDetailPage aJRAmParkDetailPage, int i2) {
        Intent intent = new Intent(aJRAmParkDetailPage, AJRAmParkDetailImageGalleryViewer.class);
        ArrayList<String> g2 = aJRAmParkDetailPage.g();
        if (g2 != null && g2.size() > 0) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("resource_list", aJRAmParkDetailPage.h());
            bundle.putStringArrayList("imageurls", g2);
            bundle.putInt(H5StartParamManager.index, i2);
            intent.putExtras(bundle);
            aJRAmParkDetailPage.startActivity(intent);
        }
    }
}
