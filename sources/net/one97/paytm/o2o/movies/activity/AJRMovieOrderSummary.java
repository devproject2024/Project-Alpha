package net.one97.paytm.o2o.movies.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.provider.Telephony;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.webapp.sdk.api.Constants;
import com.android.volley.VolleyError;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2;
import net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Items;
import net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.common.widgets.a.a;
import net.one97.paytm.common.widgets.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.ag;
import net.one97.paytm.o2o.movies.adapter.aj;
import net.one97.paytm.o2o.movies.adapter.y;
import net.one97.paytm.o2o.movies.b.f;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeatItems;
import net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem;
import net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem;
import net.one97.paytm.o2o.movies.d.i;
import net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig;
import net.one97.paytm.o2o.movies.fragment.p;
import net.one97.paytm.o2o.movies.moviepass.b.d;
import net.one97.paytm.o2o.movies.utils.ad;
import net.one97.paytm.o2o.movies.utils.g;
import net.one97.paytm.o2o.movies.utils.j;
import net.one97.paytm.o2o.movies.utils.m;
import net.one97.paytm.o2o.movies.utils.n;
import net.one97.paytm.o2o.movies.utils.w;
import net.one97.paytm.o2o.movies.utils.x;
import net.one97.paytm.o2o.movies.widget.bottom_sheet_views.CPSlabAndTncBS;
import net.one97.paytm.orders.datamodel.CJRNPSCaptureDataModel;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class AJRMovieOrderSummary extends AppBaseActivity implements b, a, aj.a, y.i, i, d.a {

    /* renamed from: h  reason: collision with root package name */
    private static final String f74028h = AJRMovieOrderSummary.class.getSimpleName();
    private CJRParcelTrackingInfo A;
    private String B;
    private String C;
    private int D = 1;
    private int E = 0;
    private ImageView F;
    private ImageView G;
    private CJRItem H;
    private String I;
    private int J = 2;
    private int K = 3;
    private c L;
    private View M;
    private CPSlabAndTncBS N;
    private ConstraintLayout O;
    private boolean P = true;
    private Handler Q = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (!AJRMovieOrderSummary.this.isFinishing() && !AJRMovieOrderSummary.this.isDestroyed() && message.what == 1) {
                AJRMovieOrderSummary.this.b(true);
                AJRMovieOrderSummary.this.getApplicationContext();
                String a2 = j.a(AJRMovieOrderSummary.this.l);
                AJRMovieOrderSummary aJRMovieOrderSummary = AJRMovieOrderSummary.this;
                String unused = aJRMovieOrderSummary.k;
                j.a((Context) aJRMovieOrderSummary, a2, AJRMovieOrderSummary.this.j, (b) AJRMovieOrderSummary.this);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    boolean f74029a;

    /* renamed from: b  reason: collision with root package name */
    String f74030b;

    /* renamed from: c  reason: collision with root package name */
    String f74031c;

    /* renamed from: d  reason: collision with root package name */
    String f74032d;

    /* renamed from: e  reason: collision with root package name */
    String f74033e;

    /* renamed from: f  reason: collision with root package name */
    String f74034f;

    /* renamed from: g  reason: collision with root package name */
    String f74035g;

    /* renamed from: i  reason: collision with root package name */
    private final int f74036i = 3;
    /* access modifiers changed from: private */
    public String j;
    /* access modifiers changed from: private */
    public String k;
    /* access modifiers changed from: private */
    public String l;
    private net.one97.paytm.y m;
    private RecyclerView n;
    private ProgressBar o;
    private LinearLayout p;
    private CJROrderSummary q;
    private ArrayList<CJRSummaryItem> r = new ArrayList<>();
    private ag s;
    private int t;
    private f u;
    private net.one97.paytm.o2o.movies.b.c v;
    private boolean w;
    private boolean x;
    private net.one97.paytm.o2o.movies.common.b.a y;
    private boolean z;

    public final void a(String str, b bVar) {
    }

    public final void c(boolean z2) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.movie_order_summary);
        if (com.paytm.utility.b.r((Context) this)) {
            c();
            return;
        }
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.signOut(this, false, (VolleyError) null);
        startActivityForResult(new Intent(this, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("authActivity")), 6);
    }

    private void c() {
        d();
        f();
        b();
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.dropBreadCrumb(f74028h, "");
        n.b("/summary", (Context) this);
    }

    private void d() {
        if (getIntent() != null) {
            Intent intent = getIntent();
            this.f74029a = intent.getBooleanExtra("is_from_contact_us", false);
            String stringExtra = getIntent().getStringExtra("pg_screen");
            if (stringExtra != null) {
                this.j += "&pg_screen=" + stringExtra;
            }
            this.k = intent.getStringExtra(UpiConstants.FROM);
            this.l = intent.getStringExtra("order_id");
            boolean booleanExtra = intent.getBooleanExtra(AppConstants.IS_CANCEL, false);
            if (getIntent().hasExtra("intent_extra_wallet_paytm_assist_gtmevents")) {
                this.m = (net.one97.paytm.y) getIntent().getSerializableExtra("intent_extra_wallet_paytm_assist_gtmevents");
            }
            if (booleanExtra && !TextUtils.isEmpty(this.l)) {
                e();
            }
            try {
                this.B = getIntent().getStringExtra("referralSource");
                this.A = (CJRParcelTrackingInfo) getIntent().getParcelableExtra("tracking_info");
            } catch (Exception unused) {
                q.c("");
            }
            if (getIntent().hasExtra("extra_home_data")) {
                this.H = (CJRItem) getIntent().getExtras().getSerializable("extra_home_data");
                this.I = this.H.getURL();
                this.k = "Deep Linking";
                if (TextUtils.isEmpty(this.I)) {
                    return;
                }
                if (this.I.trim().startsWith("http") || this.I.trim().startsWith("https")) {
                    j.a((Context) this, this.I, this.j, (b) this);
                }
            } else if (getIntent() != null && getIntent().getData() != null && !TextUtils.isEmpty(getIntent().getData().getQueryParameter("url"))) {
                this.I = getIntent().getData().getQueryParameter("url");
                this.k = "Deep Linking";
                j.a((Context) this, this.I, this.j, (b) this);
            }
        }
    }

    private void e() {
        net.one97.paytm.o2o.movies.common.b.c.a();
        String a2 = net.one97.paytm.o2o.movies.common.b.c.a("movies_seat_release", (String) null);
        if (URLUtil.isValidUrl(a2)) {
            String s2 = com.paytm.utility.b.s(this, a2 + "?order_id=" + this.l);
            HashMap hashMap = new HashMap();
            hashMap.put("ClientId", "paytm");
            net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
            cVar.f42877a = this;
            cVar.f42878b = a.c.MOVIES;
            cVar.f42879c = a.C0715a.GET;
            cVar.f42880d = s2;
            cVar.f42881e = null;
            cVar.f42882f = hashMap;
            cVar.f42883g = null;
            cVar.f42884h = null;
            cVar.f42885i = null;
            cVar.j = this;
            cVar.n = a.b.USER_FACING;
            cVar.o = "movies";
            cVar.t = n.h("AJRMovieOrderSummary");
            com.paytm.network.a l2 = cVar.l();
            l2.f42859c = false;
            l2.a();
        }
    }

    private void f() {
        this.n = (RecyclerView) findViewById(R.id.order_summary_list);
        this.n.setHasFixedSize(true);
        this.n.setLayoutManager(new LinearLayoutManager(this));
        this.o = (ProgressBar) findViewById(R.id.id_movie_summary_progress_bar);
        this.O = (ConstraintLayout) findViewById(R.id.toolbar_layout);
        this.G = (ImageView) findViewById(R.id.ivBackButton);
        this.F = (ImageView) findViewById(R.id.id_movie_summary_share);
        this.G.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRMovieOrderSummary.this.b(view);
            }
        });
        g();
        if (!com.paytm.utility.b.c((Context) this)) {
            f(true);
        } else {
            b(true);
            g(false);
        }
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private void g() {
        try {
            this.p = (LinearLayout) findViewById(R.id.no_network);
            findViewById(R.id.network_retry_btn).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (com.paytm.utility.b.c((Context) AJRMovieOrderSummary.this)) {
                        AJRMovieOrderSummary.this.b();
                    }
                }
            });
        } catch (Exception unused) {
            q.c("");
        }
    }

    private void h() {
        this.v = new net.one97.paytm.o2o.movies.b.c();
        this.u = new f(this, this.o);
        this.y = new net.one97.paytm.o2o.movies.common.b.a(this);
    }

    public final void a(ad adVar, IJRDataModel iJRDataModel) {
        String str = null;
        switch (adVar) {
            case SUMMARY_CONTACT_US_CLICK:
                this.u.a(((CJRSummaryContactUsItemV2) iJRDataModel).getOrderSummary());
                String o2 = o();
                if (o2 != null && o2.equalsIgnoreCase("FAILED")) {
                    e("Contact Customer Care clicked");
                    this.y.a("Contact Customer Care", this.q);
                    return;
                } else if (o2 != null && o2.equalsIgnoreCase("SUCCESS")) {
                    b("Contact Us Clicked");
                    return;
                } else {
                    return;
                }
            case TRY_AGAIN_BUTTON_CLICK:
                e("Try Again Clicked");
                CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                CJROrderSummaryMetadataResponseV2 l2 = l();
                if (l2 != null) {
                    String sessionId = l2.getSessionId();
                    if (sessionId.contains(AppUtility.CENTER_DOT)) {
                        sessionId = String.valueOf((int) Double.parseDouble(sessionId));
                    }
                    cJRHomePageItem.setMovieSessionId(sessionId);
                    cJRHomePageItem.setPushType("movie");
                    cJRHomePageItem.setPushCity(l2.getPaytmCityName());
                    cJRHomePageItem.setPushCityValue(l2.getPaytmCityName());
                    cJRHomePageItem.setPushCode(l2.getMovieCode());
                    String showTime = l2.getShowTime();
                    if (showTime != null && showTime.contains("T")) {
                        str = showTime.split("T")[0];
                    }
                    cJRHomePageItem.setPushDate(str);
                    cJRHomePageItem.setUrlType("movies-seat-layout");
                    cJRHomePageItem.setCinemaMovieCode(l2.getCinemaId());
                    cJRHomePageItem.setMovieCode(l2.getMovieCode());
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.loadPage(this, "movies-seat-layout", cJRHomePageItem, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, (String) null);
                    String o3 = o();
                    if (o3 != null && o3.equalsIgnoreCase("FAILED")) {
                        this.y.a("Try Again", this.q);
                        return;
                    }
                    return;
                }
                return;
            case NPS_ITEM_CLICK:
                CJRNPSCaptureDataModel cJRNPSCaptureDataModel = (CJRNPSCaptureDataModel) iJRDataModel;
                if (this.q != null && cJRNPSCaptureDataModel.getItemIds() != null && com.paytm.utility.b.c((Context) this)) {
                    b(true);
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.makeNPSTrackingApiCall(this, cJRNPSCaptureDataModel.getResponse(), this.q.getId(), "npsFeedback-movies", cJRNPSCaptureDataModel.getItemIds(), this);
                    return;
                }
                return;
            case SEND_TICKET_BUTTON_CLICK:
                String o4 = o();
                if (o4 != null && o4.equalsIgnoreCase("SUCCESS")) {
                    b("Social Sharing");
                }
                String k2 = k();
                ArrayList arrayList = new ArrayList();
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                List<ResolveInfo> queryIntentActivities = getPackageManager().queryIntentActivities(intent, 0);
                if (!queryIntentActivities.isEmpty()) {
                    for (ResolveInfo next : queryIntentActivities) {
                        String str2 = next.activityInfo.packageName;
                        if (str2.contains(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.WHATS_APP) || str2.contains("com.google.android.gm")) {
                            Intent intent2 = new Intent();
                            intent2.setComponent(new ComponentName(str2, next.activityInfo.name));
                            intent2.setAction("android.intent.action.SEND");
                            intent2.setType("text/plain");
                            intent2.putExtra("android.intent.extra.SUBJECT", "Movie Ticket");
                            intent2.putExtra("android.intent.extra.TEXT", k2);
                            intent2.setPackage(str2);
                            arrayList.add(intent2);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(getApplicationContext());
                        Intent intent3 = new Intent("android.intent.action.SEND");
                        intent3.setType("text/plain");
                        intent3.putExtra("android.intent.extra.TEXT", k2);
                        if (defaultSmsPackage != null) {
                            intent3.setPackage(defaultSmsPackage);
                            arrayList.add(intent3);
                        }
                    } else {
                        Intent intent4 = new Intent("android.intent.action.VIEW");
                        intent4.setType("vnd.android-dir/mms-sms");
                        intent4.putExtra("sms_body", k2);
                        arrayList.add(intent4);
                    }
                    if (!arrayList.isEmpty()) {
                        Intent createChooser = Intent.createChooser((Intent) arrayList.remove(0), "Share Using");
                        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
                        startActivity(createChooser);
                        return;
                    }
                    Intent intent5 = new Intent("android.intent.action.SEND");
                    intent5.setType("text/plain");
                    intent5.putExtra("android.intent.extra.SUBJECT", "Movie Ticket");
                    intent5.putExtra("android.intent.extra.TEXT", k2);
                    startActivity(Intent.createChooser(intent5, "Share Using"));
                    return;
                }
                return;
            case CANCEL_MOVIE_TICKET_CLICK:
                c((CJRSummaryMovieDescItemV2) iJRDataModel);
                return;
            case CANCEL_MOVIE_TICKET_TNC_CLICK:
                CJRSummaryMovieDescItemV2 cJRSummaryMovieDescItemV2 = (CJRSummaryMovieDescItemV2) iJRDataModel;
                CJRInsuranceConfig insuranceConfig = cJRSummaryMovieDescItemV2.getInsuranceConfig();
                if (insuranceConfig != null && insuranceConfig.getTerms_cond() != null) {
                    CPSlabAndTncBS cPSlabAndTncBS = this.N;
                    if (cPSlabAndTncBS != null) {
                        cPSlabAndTncBS.f76195a.dismiss();
                        this.N = null;
                    }
                    this.N = new CPSlabAndTncBS(this, insuranceConfig.getTerms_cond(), new CPSlabAndTncBS.a(cJRSummaryMovieDescItemV2) {
                        private final /* synthetic */ CJRSummaryMovieDescItemV2 f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onCancelClick() {
                            AJRMovieOrderSummary.this.c(this.f$1);
                        }
                    });
                    this.N.f76195a.show();
                    return;
                }
                return;
            case SUMMARY_PAYMENT_DETAIL_CLICK:
                net.one97.paytm.o2o.movies.fragment.q qVar = new net.one97.paytm.o2o.movies.fragment.q();
                CJRSummaryMoviePaymentItem e2 = net.one97.paytm.o2o.movies.b.c.e(this.q);
                Bundle bundle = new Bundle();
                bundle.putSerializable("payment_data", e2);
                qVar.setArguments(bundle);
                findViewById(R.id.main_frame).setVisibility(0);
                getSupportFragmentManager().a().a(R.anim.movie_slide_in_right, R.anim.movie_slide_out_right, R.anim.movie_slide_in_right, R.anim.movie_slide_out_right).b(R.id.main_frame, qVar, (String) null).a("").c();
                return;
            case SUMMARY_FOOD_DETAIL_CLICK:
                p pVar = new p();
                CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2 = new CJROrderSummaryMetadataResponseV2();
                if (this.q.getOrderedCartList() != null) {
                    if (this.q.getOrderedCartList().size() == 1) {
                        cJROrderSummaryMetadataResponseV2 = m.a(this.q.getOrderedCartList().get(0));
                    } else {
                        cJROrderSummaryMetadataResponseV2 = m.a(this.q.getOrderedCartList().get(1));
                    }
                }
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("food_data", cJROrderSummaryMetadataResponseV2.getFoodAndBeverages().getData());
                pVar.setArguments(bundle2);
                findViewById(R.id.main_frame).setVisibility(0);
                getSupportFragmentManager().a().a(R.id.main_frame, pVar, (String) null).a("").b();
                return;
            default:
                return;
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        boolean z2 = true;
        if (i2 != 0 && i2 != 1) {
            return;
        }
        if (s.a(iArr)) {
            if (i2 != 0) {
                z2 = false;
            }
            d(z2);
            return;
        }
        b(false);
        if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
            w.a((Activity) this);
        }
    }

    private static Bitmap a(View view, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(Color.parseColor("#f3f7f8"));
        }
        view.draw(canvas);
        return createBitmap;
    }

    private void d(boolean z2) {
        if (this.M != null) {
            b(true);
            View view = this.M;
            Uri a2 = w.a(this, a(view, view.getHeight(), this.M.getWidth()), this.l);
            if (a2 != null) {
                if (z2) {
                    a(a2);
                    return;
                }
                b(false);
                Toast.makeText(this, "Ticket downloaded successfully to image gallery", 1).show();
            } else if (!z2) {
                i();
            } else {
                j();
            }
        }
    }

    private void a(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.putExtra("android.intent.extra.TEXT", getResources().getString(R.string.movie_order_summary_share_ticket));
        intent.setType("image/jpeg");
        startActivity(intent);
        b(false);
    }

    private void i() {
        b(false);
        Toast.makeText(this, R.string.movie_order_summary_download_ticket_error, 1).show();
    }

    private void j() {
        b(false);
        Toast.makeText(this, R.string.movie_order_summary_share_ticket_error, 1).show();
    }

    public final void a(View view, boolean z2) {
        this.M = view;
        if (androidx.core.app.a.a((Context) this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            androidx.core.app.a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, z2 ^ true ? 1 : 0);
        } else {
            d(z2);
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
    }

    private void b(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.D);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, str);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) this)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception e2) {
            q.c(a(e2));
        }
    }

    private void a(String str, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.K);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, net.one97.paytm.o2o.movies.common.b.b.N);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, str + ", " + str2 + ", " + str3);
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception e2) {
            q.c(a(e2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void c(CJRSummaryMovieDescItemV2 cJRSummaryMovieDescItemV2) {
        String str = "";
        String value = net.one97.paytm.o2o.movies.common.d.a((Context) this, "movies") != null ? net.one97.paytm.o2o.movies.common.d.a((Context) this, "movies").getValue() : str;
        String movieName = cJRSummaryMovieDescItemV2.getMovieName();
        if (!(cJRSummaryMovieDescItemV2.getMetaDataresponse() == null || cJRSummaryMovieDescItemV2.getMetaDataresponse().getCinema() == null)) {
            str = cJRSummaryMovieDescItemV2.getMetaDataresponse().getCinema();
        }
        String str2 = str;
        a(value, movieName, str2);
        b(cJRSummaryMovieDescItemV2);
        AJRCPCancelDialog.a(this, cJRSummaryMovieDescItemV2.getOrderId(), cJRSummaryMovieDescItemV2.getEncryptedOrderId(), value, movieName, str2);
    }

    private void b(CJRSummaryMovieDescItemV2 cJRSummaryMovieDescItemV2) {
        try {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            ArrayList arrayList = new ArrayList();
            HashMap hashMap3 = new HashMap();
            hashMap3.put("id", Long.valueOf(cJRSummaryMovieDescItemV2.getMovieItem().getId()));
            hashMap3.put("quantity", Integer.valueOf(cJRSummaryMovieDescItemV2.getMovieItem().getQuantity()));
            arrayList.add(hashMap3);
            hashMap2.put("products", arrayList);
            hashMap.put("refund", hashMap2);
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap("ecommerce", hashMap, this);
        } catch (Exception unused) {
        }
    }

    private String k() {
        float f2;
        CJROrderSummaryMetadataResponseV2 l2 = l();
        StringBuilder sb = new StringBuilder();
        try {
            f2 = Float.valueOf(l2.getTotalCommision()).floatValue();
        } catch (Exception unused) {
            q.d("can't convert ");
            f2 = 0.0f;
        }
        if (l2 != null) {
            l2.getSeatIdsReturned().split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
            String C2 = com.paytm.utility.b.C(l2.getShowTime());
            String.format("%.02f", new Object[]{Double.valueOf(l2.getTotalTicketPrice() + ((double) f2))});
            String longitude = l2.getLongitude();
            String latitude = l2.getLatitude();
            if (!(longitude == null || latitude == null)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(latitude);
                sb2.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                sb2.append(longitude);
            }
            a("You are invited to the movie", sb);
            sb.append("----------------------\n");
            a("", l2.getMovie(), sb);
            a("", C2, sb);
            a("", l2.getCinema(), sb);
            a("", l2.getStringAddress(), sb);
            sb.append("----------------------\n");
            a("Note:-This is not a ticket,original ticket with booking id is needed to get the entry at the cinema hall", sb);
        }
        return sb.toString();
    }

    private static void a(String str, StringBuilder sb) {
        a("", str, "", sb);
    }

    private static void a(String str, String str2, StringBuilder sb) {
        a(str, str2, "", sb);
    }

    private static void a(String str, String str2, String str3, StringBuilder sb) {
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str + str2 + str3 + StringUtility.NEW_LINE);
        }
    }

    private void a(CJRNpsTrackingResponse cJRNpsTrackingResponse) {
        if (cJRNpsTrackingResponse != null && cJRNpsTrackingResponse.getMessage() != null) {
            View inflate = getLayoutInflater().inflate(R.layout.movie_sellar_rating_custom_toast, (ViewGroup) findViewById(R.id.sellar_rating_custom_toast_lyt));
            ((TextView) inflate.findViewById(R.id.toast_msg)).setText(cJRNpsTrackingResponse.getMessage());
            Toast toast = new Toast(this);
            toast.setDuration(0);
            toast.setGravity(17, 0, 0);
            toast.setView(inflate);
            toast.show();
        }
    }

    private static String a(Exception exc) {
        return TextUtils.isEmpty(exc.getMessage()) ? "" : exc.getMessage();
    }

    private CJROrderSummaryMetadataResponseV2 l() {
        CJROrderSummary cJROrderSummary = this.q;
        if (cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || this.q.getOrderedCartList().size() == 0 || this.q.getOrderedCartList().get(0) == null) {
            return null;
        }
        return n.b(this.q.getOrderedCartList().get(0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        ag agVar = this.s;
        if (agVar != null && agVar.f74318g != null) {
            this.s.f74318g.a(true);
        }
    }

    private void m() {
        int orderStatus = this.q.getOrderStatus();
        if (orderStatus == 1 || orderStatus == 3) {
            this.q.setStatus("PROCESSING");
        } else if (orderStatus == 4) {
            this.q.setStatus("FAILED");
        } else {
            ArrayList<CJROrderedCart> orderedCartList = this.q.getOrderedCartList();
            if (orderedCartList != null) {
                Iterator<CJROrderedCart> it2 = orderedCartList.iterator();
                boolean z2 = false;
                int i2 = 0;
                while (it2.hasNext()) {
                    CJROrderedCart next = it2.next();
                    if (next.getMerchantId() == 582326) {
                        z2 = true;
                    } else if (next != null) {
                        String itemStatus = next.getItemStatus();
                        if (itemStatus.equals("6")) {
                            this.q.setStatus("FAILED");
                            return;
                        } else if (itemStatus.equals("1") || itemStatus.equals("5")) {
                            this.q.setStatus("PROCESSING");
                            return;
                        } else if (itemStatus.equals("18")) {
                            this.q.setStatus("RETURNED");
                            return;
                        } else if (itemStatus.equals("7") || itemStatus.equals("236") || itemStatus.equals("8")) {
                            i2++;
                        }
                    } else {
                        continue;
                    }
                }
                int size = orderedCartList.size();
                if ((!z2 || size - 1 != i2) && size != i2) {
                    this.q.setStatus("PROCESSING");
                } else {
                    this.q.setStatus("SUCCESS");
                }
            }
        }
    }

    private boolean e(boolean z2) {
        try {
            if (this.q.getOrderedCartList().size() != 1 || !n.a(this.q.getOrderedCartList().get(0)).getMoviePassPresent().booleanValue()) {
                return false;
            }
            if (z2) {
                net.one97.paytm.o2o.movies.moviepass.c.b bVar = new net.one97.paytm.o2o.movies.moviepass.c.b(this);
                Bundle bundle = new Bundle();
                bundle.putSerializable("movie_order_summary", this.q);
                bVar.setArguments(bundle);
                findViewById(R.id.main_frame).setVisibility(0);
                getSupportFragmentManager().a().b(R.id.main_frame, bVar, (String) null).b();
            }
            return true;
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(a(e2));
            }
        }
    }

    private void n() {
        if (this.Q != null && this.t < 3) {
            Message obtain = Message.obtain();
            String o2 = o();
            if (!o2.equalsIgnoreCase("SUCCESS") && !o2.equalsIgnoreCase("FAILED")) {
                obtain.what = 1;
                this.Q.sendMessageDelayed(obtain, 5000);
                this.t++;
            }
        }
    }

    private String o() {
        CJROrderSummary cJROrderSummary = this.q;
        if (cJROrderSummary == null) {
            return null;
        }
        return cJROrderSummary.getStatus();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public final void b() {
        try {
            if (com.paytm.utility.b.c((Context) this)) {
                b(true);
                g(false);
                f(false);
                String a2 = j.a(this.l);
                if (!TextUtils.isEmpty(a2)) {
                    j.a((Context) this, a2, this.j, (b) this);
                    return;
                }
                return;
            }
            f(true);
        } catch (Exception unused) {
            q.c("");
        }
    }

    private void f(boolean z2) {
        LinearLayout linearLayout = this.p;
        if (linearLayout != null) {
            if (z2) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
        }
    }

    public final void b(boolean z2) {
        ProgressBar progressBar = this.o;
        if (progressBar != null) {
            if (z2) {
                progressBar.setVisibility(0);
            } else {
                progressBar.setVisibility(8);
            }
        }
    }

    private void g(boolean z2) {
        if (z2) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    public void onBackPressed() {
        Intent intent;
        net.one97.paytm.o2o.movies.common.b.a aVar;
        if (getSupportFragmentManager() == null || getSupportFragmentManager().f() <= 0) {
            if (!TextUtils.isEmpty(this.k) && this.k.equalsIgnoreCase("Payment") && this.q != null && !this.w) {
                this.w = true;
                String o2 = o();
                if (!(o2 == null || !o2.equalsIgnoreCase("FAILED") || (aVar = this.y) == null)) {
                    aVar.a("Paytm Home", this.q);
                    e("Paytm Home Clicked");
                }
                if (e(false)) {
                    intent = new Intent(this, MoviesHomeActivity.class);
                    intent.addFlags(67108864);
                    intent.putExtra("origin", CLPConstants.GA_CHANNEL_NAME);
                    intent.putExtra("extra_url_type", "movietickets");
                } else {
                    new CJRHomePageItem().setUrl(x.a(getApplicationContext()).b("home_url", "", true));
                    Intent intent2 = new Intent(this, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("mainActivity"));
                    intent2.addFlags(67108864);
                    intent2.addFlags(268435456);
                    intent2.setFlags(536870912);
                    intent2.putExtra("CLEAR_MOBILE_DATA", true);
                    intent2.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
                    if (!TextUtils.isEmpty(this.k) && this.k.equalsIgnoreCase("Payment")) {
                        intent2.putExtra("Reset_fast_farward", true);
                    }
                    intent = intent2;
                }
                startActivity(intent);
                finish();
            }
            super.onBackPressed();
            return;
        }
        getSupportFragmentManager().d();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:65|66|67|(1:69)|70|71|72|73|74|75|76|77) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:78|79|80) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|(3:5|6|(12:10|11|12|(1:16)|17|(3:19|(3:21|(2:23|87)(1:88)|24)|86)(1:25)|26|(1:34)|35|(1:37)|(1:39)|(6:47|(1:49)|50|(1:52)|53|(1:55))))|56|57|(1:93)(12:65|66|67|(1:69)|70|71|72|73|74|75|76|77)) */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        com.paytm.utility.q.c("");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01e7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        com.paytm.utility.q.c("");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ec, code lost:
        com.paytm.utility.q.c("");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ef, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0153 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x01d7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x01e4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x01e8 */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0170 A[Catch:{ Exception -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r10 = ""
            java.lang.String r0 = r13.k     // Catch:{ Exception -> 0x01ec }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01ec }
            java.lang.String r1 = "Payment"
            java.lang.String r2 = "SUCCESS"
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x0153
            java.lang.String r0 = r13.k     // Catch:{ Exception -> 0x01ec }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x01ec }
            if (r0 == 0) goto L_0x0153
            boolean r0 = r13.x     // Catch:{ Exception -> 0x01ec }
            if (r0 != 0) goto L_0x0153
            r13.x = r3     // Catch:{ Exception -> 0x01ec }
            net.one97.paytm.o2o.movies.common.b.a r0 = r13.y     // Catch:{ Exception -> 0x01ec }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r13.q     // Catch:{ Exception -> 0x01ec }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x0153 }
            r6.<init>()     // Catch:{ Exception -> 0x0153 }
            java.lang.String r7 = "screenName"
            java.lang.String r8 = "/summary"
            r6.put(r7, r8)     // Catch:{ Exception -> 0x0153 }
            if (r5 == 0) goto L_0x0043
            java.lang.String r7 = r5.getPaymentStatus()     // Catch:{ Exception -> 0x0153 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0153 }
            if (r7 != 0) goto L_0x0043
            java.lang.String r7 = "movie_payment_status"
            java.lang.String r8 = r5.getPaymentStatus()     // Catch:{ Exception -> 0x0153 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x0153 }
        L_0x0043:
            java.util.ArrayList r7 = r5.getPaymentInfo()     // Catch:{ Exception -> 0x0153 }
            if (r7 == 0) goto L_0x0082
            int r8 = r7.size()     // Catch:{ Exception -> 0x0153 }
            r11 = r10
            r9 = 0
        L_0x004f:
            if (r9 >= r8) goto L_0x0083
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0153 }
            r12.<init>()     // Catch:{ Exception -> 0x0153 }
            r12.append(r11)     // Catch:{ Exception -> 0x0153 }
            java.lang.Object r11 = r7.get(r4)     // Catch:{ Exception -> 0x0153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r11 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r11     // Catch:{ Exception -> 0x0153 }
            java.lang.String r11 = r11.getPaymentMethod()     // Catch:{ Exception -> 0x0153 }
            r12.append(r11)     // Catch:{ Exception -> 0x0153 }
            java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x0153 }
            int r12 = r8 + -1
            if (r9 >= r12) goto L_0x007f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0153 }
            r12.<init>()     // Catch:{ Exception -> 0x0153 }
            r12.append(r11)     // Catch:{ Exception -> 0x0153 }
            java.lang.String r11 = " + "
            r12.append(r11)     // Catch:{ Exception -> 0x0153 }
            java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x0153 }
        L_0x007f:
            int r9 = r9 + 1
            goto L_0x004f
        L_0x0082:
            r11 = r10
        L_0x0083:
            java.lang.String r7 = "movie_payment_type"
            java.lang.String r8 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x0153 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x0153 }
            if (r5 == 0) goto L_0x00b1
            java.lang.String r7 = r5.getPaymentStatus()     // Catch:{ Exception -> 0x0153 }
            if (r7 == 0) goto L_0x00b1
            java.lang.String r7 = r5.getPaymentStatus()     // Catch:{ Exception -> 0x0153 }
            boolean r7 = r7.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0153 }
            if (r7 != 0) goto L_0x00b1
            java.lang.String r7 = r5.getPaymentSummary()     // Catch:{ Exception -> 0x0153 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0153 }
            if (r7 != 0) goto L_0x00b1
            java.lang.String r7 = "movie_payment_error_message"
            java.lang.String r8 = r5.getPaymentSummary()     // Catch:{ Exception -> 0x0153 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x0153 }
        L_0x00b1:
            android.content.Context r0 = r0.f75003a     // Catch:{ Exception -> 0x0153 }
            java.lang.String r0 = com.paytm.utility.b.n((android.content.Context) r0)     // Catch:{ Exception -> 0x0153 }
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0153 }
            if (r7 != 0) goto L_0x00c2
            java.lang.String r7 = "movie_user_id"
            r6.put(r7, r0)     // Catch:{ Exception -> 0x0153 }
        L_0x00c2:
            if (r5 == 0) goto L_0x00d1
            java.lang.String r0 = "movie_amount"
            double r7 = r5.getGrandTotal()     // Catch:{ Exception -> 0x0153 }
            java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ Exception -> 0x0153 }
            r6.put(r0, r7)     // Catch:{ Exception -> 0x0153 }
        L_0x00d1:
            if (r5 == 0) goto L_0x0153
            java.util.ArrayList r0 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x0153 }
            if (r0 == 0) goto L_0x0153
            java.util.ArrayList r0 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x0153 }
            int r0 = r0.size()     // Catch:{ Exception -> 0x0153 }
            if (r0 <= 0) goto L_0x0153
            java.util.ArrayList r0 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x0153 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x0153 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ Exception -> 0x0153 }
            java.lang.Object r0 = r0.getMetaDataResponse()     // Catch:{ Exception -> 0x0153 }
            if (r0 == 0) goto L_0x0153
            java.util.ArrayList r0 = r5.getOrderedCartList()     // Catch:{ Exception -> 0x0153 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x0153 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ Exception -> 0x0153 }
            java.lang.Object r0 = r0.getMetaDataResponse()     // Catch:{ Exception -> 0x0153 }
            com.google.gsonhtcfix.f r5 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0153 }
            r5.<init>()     // Catch:{ Exception -> 0x0153 }
            java.lang.String r0 = r5.a((java.lang.Object) r0)     // Catch:{ Exception -> 0x0153 }
            java.lang.Class<net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2> r7 = net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2.class
            java.lang.Object r0 = r5.a((java.lang.String) r0, r7)     // Catch:{ Exception -> 0x0153 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r0 = (net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2) r0     // Catch:{ Exception -> 0x0153 }
            java.lang.String r5 = r0.getCitySearched()     // Catch:{ Exception -> 0x0153 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0153 }
            if (r5 != 0) goto L_0x0125
            java.lang.String r5 = "movie_city_name"
            java.lang.String r7 = r0.getCitySearched()     // Catch:{ Exception -> 0x0153 }
            r6.put(r5, r7)     // Catch:{ Exception -> 0x0153 }
        L_0x0125:
            java.lang.String r5 = r0.getSource()     // Catch:{ Exception -> 0x0153 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0153 }
            if (r5 != 0) goto L_0x0138
            java.lang.String r5 = "movie_cinema_listing_type"
            java.lang.String r7 = r0.getSource()     // Catch:{ Exception -> 0x0153 }
            r6.put(r5, r7)     // Catch:{ Exception -> 0x0153 }
        L_0x0138:
            java.lang.String r5 = r0.getShowTime()     // Catch:{ Exception -> 0x0153 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0153 }
            if (r5 != 0) goto L_0x0153
            java.lang.String r0 = r0.getShowTime()     // Catch:{ Exception -> 0x0153 }
            java.lang.String r0 = com.paytm.utility.b.B((java.lang.String) r0)     // Catch:{ Exception -> 0x0153 }
            java.lang.String r0 = com.paytm.utility.b.D((java.lang.String) r0)     // Catch:{ Exception -> 0x0153 }
            java.lang.String r5 = "movie_show_timing_bucket"
            r6.put(r5, r0)     // Catch:{ Exception -> 0x0153 }
        L_0x0153:
            r13.d((java.lang.String) r14)     // Catch:{ Exception -> 0x01ec }
            boolean r0 = r14.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x01ec }
            if (r0 == 0) goto L_0x01eb
            java.lang.String r0 = r13.k     // Catch:{ Exception -> 0x01ec }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01ec }
            if (r0 != 0) goto L_0x01eb
            java.lang.String r0 = r13.k     // Catch:{ Exception -> 0x01ec }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x01ec }
            if (r0 == 0) goto L_0x01eb
            boolean r0 = r13.z     // Catch:{ Exception -> 0x01ec }
            if (r0 != 0) goto L_0x01eb
            r13.z = r3     // Catch:{ Exception -> 0x01ec }
            net.one97.paytm.o2o.movies.common.b.c.a()     // Catch:{ Exception -> 0x01e8 }
            java.lang.String r0 = "categorymap"
            r1 = 0
            java.lang.String r11 = net.one97.paytm.o2o.movies.common.b.c.a(r0, r1)     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r13.q     // Catch:{ Exception -> 0x01e8 }
            java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ Exception -> 0x01e8 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()     // Catch:{ Exception -> 0x01e8 }
            long r8 = r0.getCategoryId()     // Catch:{ Exception -> 0x01e8 }
            java.lang.Long.toString(r8)     // Catch:{ Exception -> 0x01e8 }
            java.lang.String r12 = r0.getVertical()     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r13.q     // Catch:{ Exception -> 0x01e8 }
            r0.sendOrderSummaryPGEvent(r13, r1)     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r13.q     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r3 = r13.A     // Catch:{ Exception -> 0x01e8 }
            java.lang.String r4 = r13.B     // Catch:{ Exception -> 0x01e8 }
            r5 = 0
            r1 = r13
            r6 = r12
            r7 = r11
            r0.sendGTMOrderSummaryTag(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r13.q     // Catch:{ Exception -> 0x01e8 }
            java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ Exception -> 0x01e8 }
            if (r0 == 0) goto L_0x01c4
            net.one97.paytm.o2o.movies.common.b.a r0 = r13.y     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r13.q     // Catch:{ Exception -> 0x01e8 }
            java.util.ArrayList r1 = r1.getOrderedCartList()     // Catch:{ Exception -> 0x01e8 }
            r0.a((java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart>) r1)     // Catch:{ Exception -> 0x01e8 }
        L_0x01c4:
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x01e8 }
            r2 = 0
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r13.q     // Catch:{ Exception -> 0x01e8 }
            r1 = r13
            r4 = r12
            r5 = r11
            r0.sendGTMThankYouScreen(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x01e8 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r13.q     // Catch:{ Exception -> 0x01d7 }
            net.one97.paytm.o2o.movies.common.b.a.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r0)     // Catch:{ Exception -> 0x01d7 }
            goto L_0x01da
        L_0x01d7:
            com.paytm.utility.q.c(r10)     // Catch:{ Exception -> 0x01e8 }
        L_0x01da:
            net.one97.paytm.o2o.movies.common.b.a r0 = r13.y     // Catch:{ Exception -> 0x01e4 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r13.q     // Catch:{ Exception -> 0x01e4 }
            java.lang.String r0 = r0.f75004b     // Catch:{ Exception -> 0x01e4 }
            net.one97.paytm.o2o.movies.common.b.a.b(r0, r1)     // Catch:{ Exception -> 0x01e4 }
            return
        L_0x01e4:
            com.paytm.utility.q.c(r10)     // Catch:{ Exception -> 0x01e8 }
            return
        L_0x01e8:
            com.paytm.utility.q.c(r10)     // Catch:{ Exception -> 0x01ec }
        L_0x01eb:
            return
        L_0x01ec:
            com.paytm.utility.q.c(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary.c(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c1 A[Catch:{ Exception -> 0x01b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d1 A[ADDED_TO_REGION, Catch:{ Exception -> 0x01b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x017d A[Catch:{ Exception -> 0x01b2 }, LOOP:1: B:47:0x0177->B:49:0x017d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x019f A[Catch:{ Exception -> 0x01b2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "ticketCount"
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x01b2 }
            r1.<init>()     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = "screenName"
            java.lang.String r3 = "/summary"
            r1.put(r2, r3)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.E     // Catch:{ Exception -> 0x01b2 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r2 = r2.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r3 = ""
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0040
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r2 = r2.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x01b2 }
            if (r2 != r5) goto L_0x0040
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r2 = r2.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r2 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r2     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = r2.getPaymentMethod()     // Catch:{ Exception -> 0x01b2 }
            goto L_0x00b7
        L_0x0040:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r2 = r2.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            if (r2 == 0) goto L_0x00b6
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r2 = r2.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x01b2 }
            if (r2 <= r5) goto L_0x00b6
            r6 = r3
            r2 = 0
        L_0x0056:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r7 = r7.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            int r7 = r7.size()     // Catch:{ Exception -> 0x01b2 }
            if (r2 >= r7) goto L_0x00b4
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r7 = r7.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r7 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r7     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r7 = r7.getPaymentMethod()     // Catch:{ Exception -> 0x01b2 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01b2 }
            if (r8 != 0) goto L_0x00b1
            boolean r8 = r6.contains(r7)     // Catch:{ Exception -> 0x01b2 }
            if (r8 != 0) goto L_0x00b1
            int r8 = r6.length()     // Catch:{ Exception -> 0x01b2 }
            if (r8 <= r5) goto L_0x00a2
            net.one97.paytm.common.entity.shopping.CJROrderSummary r8 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r8 = r8.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            int r8 = r8.size()     // Catch:{ Exception -> 0x01b2 }
            int r8 = r8 - r5
            if (r2 >= r8) goto L_0x00a2
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r8.<init>()     // Catch:{ Exception -> 0x01b2 }
            r8.append(r6)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r6 = ","
            r8.append(r6)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x01b2 }
        L_0x00a2:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            r8.<init>()     // Catch:{ Exception -> 0x01b2 }
            r8.append(r6)     // Catch:{ Exception -> 0x01b2 }
            r8.append(r7)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r6 = r8.toString()     // Catch:{ Exception -> 0x01b2 }
        L_0x00b1:
            int r2 = r2 + 1
            goto L_0x0056
        L_0x00b4:
            r2 = r6
            goto L_0x00b7
        L_0x00b6:
            r2 = r3
        L_0x00b7:
            if (r10 == 0) goto L_0x00d1
            java.lang.String r5 = "SUCCESS"
            boolean r5 = r10.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x01b2 }
            if (r5 == 0) goto L_0x00d1
            java.lang.String r10 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r5 = "Payment Success-"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = r5.concat(r2)     // Catch:{ Exception -> 0x01b2 }
            r1.put(r10, r2)     // Catch:{ Exception -> 0x01b2 }
            goto L_0x00f1
        L_0x00d1:
            if (r10 == 0) goto L_0x00f1
            java.lang.String r2 = "FAILED"
            boolean r2 = r10.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x01b2 }
            if (r2 == 0) goto L_0x00f1
            java.lang.String r2 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r5 = "Payment Failure-"
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r10 = r5.concat(r10)     // Catch:{ Exception -> 0x01b2 }
            r1.put(r2, r10)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r10 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = "error occurred in payment"
            r1.put(r10, r2)     // Catch:{ Exception -> 0x01b2 }
        L_0x00f1:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r10 = r10.getOrderedCartList()     // Catch:{ Exception -> 0x01b2 }
            java.lang.Object r10 = r10.get(r4)     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r10 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r10     // Catch:{ Exception -> 0x01b2 }
            java.util.Map r10 = r10.getRechargeConfiguration()     // Catch:{ Exception -> 0x01b2 }
            if (r10 == 0) goto L_0x0110
            boolean r2 = r10.containsKey(r0)     // Catch:{ Exception -> 0x01b2 }
            if (r2 == 0) goto L_0x0110
            java.lang.Object r10 = r10.get(r0)     // Catch:{ Exception -> 0x01b2 }
            r3 = r10
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x01b2 }
        L_0x0110:
            java.lang.String r10 = net.one97.paytm.o2o.movies.common.b.b.f75010e     // Catch:{ Exception -> 0x01b2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = "order_id="
            r0.<init>(r2)     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x01b2 }
            r0.append(r2)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = "&product_id="
            r0.append(r2)     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r2 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x01b2 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2     // Catch:{ Exception -> 0x01b2 }
            long r4 = r2.getId()     // Catch:{ Exception -> 0x01b2 }
            r0.append(r4)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = "&price="
            r0.append(r2)     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r9.q     // Catch:{ Exception -> 0x01b2 }
            double r4 = r2.getGrandTotal()     // Catch:{ Exception -> 0x01b2 }
            r0.append(r4)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r2 = "&qty="
            r0.append(r2)     // Catch:{ Exception -> 0x01b2 }
            r0.append(r3)     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01b2 }
            r1.put(r10, r0)     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r10 = r10.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            if (r10 == 0) goto L_0x0192
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r10 = r10.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            boolean r10 = r10.isEmpty()     // Catch:{ Exception -> 0x01b2 }
            if (r10 != 0) goto L_0x0192
            r2 = 0
            net.one97.paytm.common.entity.shopping.CJROrderSummary r10 = r9.q     // Catch:{ Exception -> 0x01b2 }
            java.util.ArrayList r10 = r10.getPaymentInfo()     // Catch:{ Exception -> 0x01b2 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x01b2 }
        L_0x0177:
            boolean r0 = r10.hasNext()     // Catch:{ Exception -> 0x01b2 }
            if (r0 == 0) goto L_0x0189
            java.lang.Object r0 = r10.next()     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r0     // Catch:{ Exception -> 0x01b2 }
            double r4 = r0.getPgAmount()     // Catch:{ Exception -> 0x01b2 }
            double r2 = r2 + r4
            goto L_0x0177
        L_0x0189:
            java.lang.String r10 = net.one97.paytm.o2o.movies.common.b.b.o     // Catch:{ Exception -> 0x01b2 }
            java.lang.Double r0 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x01b2 }
            r1.put(r10, r0)     // Catch:{ Exception -> 0x01b2 }
        L_0x0192:
            java.lang.String r10 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x01b2 }
            r1.put(r10, r0)     // Catch:{ Exception -> 0x01b2 }
            boolean r10 = com.paytm.utility.b.r((android.content.Context) r9)     // Catch:{ Exception -> 0x01b2 }
            if (r10 == 0) goto L_0x01a8
            java.lang.String r10 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r0 = com.paytm.utility.b.n((android.content.Context) r9)     // Catch:{ Exception -> 0x01b2 }
            r1.put(r10, r0)     // Catch:{ Exception -> 0x01b2 }
        L_0x01a8:
            net.one97.paytm.o2o.movies.common.c.b r10 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x01b2 }
            net.one97.paytm.o2o.movies.common.c.c r10 = r10.f75033b     // Catch:{ Exception -> 0x01b2 }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x01b2 }
            r10.sendCustomEventWithMap(r0, r1, r9)     // Catch:{ Exception -> 0x01b2 }
            return
        L_0x01b2:
            r10 = move-exception
            java.lang.String r10 = a((java.lang.Exception) r10)
            com.paytm.utility.q.c(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary.d(java.lang.String):void");
    }

    private void e(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary");
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, net.one97.paytm.o2o.movies.common.b.b.F);
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, str);
            Map<String, String> rechargeConfiguration = this.q.getOrderedCartList().get(0).getRechargeConfiguration();
            String str2 = "";
            if (rechargeConfiguration != null && rechargeConfiguration.containsKey("movie")) {
                String str3 = rechargeConfiguration.get("movie");
                if (!TextUtils.isEmpty(str3)) {
                    str2 = str2 + str3;
                }
            }
            if (rechargeConfiguration != null && rechargeConfiguration.containsKey("cinema")) {
                String str4 = rechargeConfiguration.get("cinema");
                if (!TextUtils.isEmpty(str4)) {
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = str2 + "/";
                    }
                    str2 = str2 + str4;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, str2);
            }
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, net.one97.paytm.o2o.movies.common.b.b.r);
            if (com.paytm.utility.b.r((Context) this)) {
                hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n((Context) this));
            }
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, this);
        } catch (Exception e2) {
            q.c(a(e2));
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final void a(String str) {
        Intent a2 = AJRUpcomingMoviesActivity.a((Context) this, str, "show_list");
        if (a2 != null) {
            startActivity(a2);
            overridePendingTransition(net.one97.paytm.common.assets.R.anim.slide_in_right, 17432577);
            return;
        }
        Toast.makeText(this, R.string.error_something_went_wrong, 0).show();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r15v1, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map, java.lang.String] */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: type inference failed for: r15v28 */
    /* JADX WARNING: type inference failed for: r15v30 */
    /* JADX WARNING: type inference failed for: r15v31 */
    /* JADX WARNING: type inference failed for: r15v32 */
    /* JADX WARNING: type inference failed for: r15v33 */
    /* JADX WARNING: type inference failed for: r15v34 */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:8|9|(4:13|14|15|(1:17)(7:18|(1:25)(1:24)|26|(2:28|(1:30))|31|(2:33|(1:35))|36))|37|38|(1:42)|43|44|(4:46|47|(1:51)|52)(9:53|(4:55|(1:57)|58|(1:60))|61|(16:63|64|(1:66)(1:67)|68|(20:70|71|72|73|74|75|(8:77|(1:79)(1:80)|(1:87)(1:86)|(3:89|90|(4:92|(3:96|97|(3:105|106|108))|107|108))(1:93)|94|(0)|107|108)(1:109)|110|111|112|113|114|115|116|117|(1:119)(1:(1:(3:133|(2:137|(1:139)(1:140))|141)(1:132))(1:122))|142|(1:149)(1:148)|150|(1:152))(1:159)|(4:168|(1:170)|(2:(1:180)(2:177|(1:179))|181)|182)|(3:(1:193)(1:192)|194|(1:196))|197|198|199|(1:230)(7:202|203|204|(3:206|207|208)|210|211|(4:215|(5:217|218|219|220|(3:222|223|224))(1:228)|229|235))|231|232|233|234|235)(1:244)|245|(3:247|248|(2:265|270)(4:254|(5:256|257|258|259|(1:261))(1:262)|263|270))(1:271)|272|(1:276)|277)|278|279|280|(2:283|(1:285)(2:286|(1:288)(2:289|(2:295|(17:297|298|(2:303|(1:307))(1:302)|308|(1:313)(1:312)|314|(3:316|317|(9:319|321|(1:325)|326|(1:328)|329|(1:331)|332|(1:334)))|320|321|323|325|326|(0)|329|(0)|332|(0))))))|282) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:335|338|339|342|343|360|(0)(0)|391|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x054b, code lost:
        if ("BOOKED".equals(r7) != false) goto L_0x054d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:?, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:342:0x08c6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x01c2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0743 A[Catch:{ Exception -> 0x08c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0866 A[Catch:{ Exception -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0881 A[Catch:{ Exception -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x089f A[Catch:{ Exception -> 0x08b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0903 A[SYNTHETIC, Splitter:B:366:0x0903] */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x0aa1  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0aaa  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01e7 A[SYNTHETIC, Splitter:B:46:0x01e7] */
    /* JADX WARNING: Removed duplicated region for block: B:512:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0203 A[Catch:{ Exception -> 0x08cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02a1 A[SYNTHETIC, Splitter:B:96:0x02a1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r26) {
        /*
            r25 = this;
            r8 = r25
            r0 = r26
            java.lang.String r1 = "0"
            java.lang.String r9 = "theatre_name"
            java.lang.String r10 = "city_name"
            boolean r2 = r25.isFinishing()
            if (r2 == 0) goto L_0x0012
            return
        L_0x0012:
            r11 = 0
            r8.b((boolean) r11)
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            if (r2 == 0) goto L_0x0bf3
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r0
            r8.q = r0
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r8.q
            net.one97.paytm.y r3 = r8.m
            r0.sendPaytmAssistGAEvents(r2, r3, r8)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q
            java.lang.String r13 = "ticketCount"
            java.lang.String r14 = "SUCCESS"
            java.lang.String r15 = "Payment"
            java.lang.String r6 = ""
            if (r0 == 0) goto L_0x08dd
            if (r0 == 0) goto L_0x08dd
            java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x08cf }
            r8.l = r0     // Catch:{ Exception -> 0x08cf }
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x08cf }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x08cf }
            if (r0 != 0) goto L_0x01c2
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x08cf }
            boolean r0 = r0.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x08cf }
            if (r0 == 0) goto L_0x01c2
            net.one97.paytm.o2o.movies.common.b.a r0 = r8.y     // Catch:{ Exception -> 0x08cf }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r8.q     // Catch:{ Exception -> 0x08cf }
            java.lang.String r3 = r0.f75005c     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r4 = r2.getId()     // Catch:{ Exception -> 0x01c2 }
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x01c2 }
            if (r3 == 0) goto L_0x0060
            goto L_0x01c2
        L_0x0060:
            java.lang.String r3 = r2.getId()     // Catch:{ Exception -> 0x01c2 }
            r0.f75005c = r3     // Catch:{ Exception -> 0x01c2 }
            if (r2 == 0) goto L_0x0083
            java.util.ArrayList r3 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x01c2 }
            if (r3 == 0) goto L_0x0083
            java.util.ArrayList r3 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x01c2 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x01c2 }
            if (r3 <= 0) goto L_0x0083
            java.util.ArrayList r3 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Object r3 = r3.get(r11)     // Catch:{ Exception -> 0x01c2 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3     // Catch:{ Exception -> 0x01c2 }
            goto L_0x0084
        L_0x0083:
            r3 = 0
        L_0x0084:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x01c2 }
            r4.<init>()     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "pay_transaction_payment_status"
            java.lang.String r7 = r2.getPaymentStatus()     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "pay_payment_statusID"
            java.util.ArrayList r7 = r2.getPaymentInfo()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Object r7 = r7.get(r11)     // Catch:{ Exception -> 0x01c2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r7 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r7     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r7 = r7.getId()     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "pay_transaction_id"
            java.lang.String r7 = r2.getId()     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "pay_payment_type"
            java.lang.String r7 = r2.getPaymentMethodForGA()     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            if (r3 == 0) goto L_0x0122
            java.lang.String r5 = "movies_order_id"
            long r16 = r3.getId()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Long r7 = java.lang.Long.valueOf(r16)     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "movies_product_id"
            long r16 = r3.getProductId()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Long r7 = java.lang.Long.valueOf(r16)     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "movies_qty"
            int r7 = r3.getQuantity()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r3.getProductDetail()     // Catch:{ Exception -> 0x01c2 }
            if (r5 == 0) goto L_0x0122
            java.lang.String r5 = "movies_price"
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r7 = r3.getProductDetail()     // Catch:{ Exception -> 0x01c2 }
            double r16 = r7.getPrice()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Double r7 = java.lang.Double.valueOf(r16)     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "pay_product_name"
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r7 = r3.getProductDetail()     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r7 = r7.getName()     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "pay_brand_name"
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r7 = r3.getProductDetail()     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r7 = r7.getBrandName()     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "pay_product_category_id"
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r7 = r3.getProductDetail()     // Catch:{ Exception -> 0x01c2 }
            long r16 = r7.getCategoryId()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Long r7 = java.lang.Long.valueOf(r16)     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
        L_0x0122:
            net.one97.paytm.o2o.movies.common.c.b r5 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x01c2 }
            net.one97.paytm.o2o.movies.common.c.c r5 = r5.f75033b     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r7 = "pay_order_summary_txn_status"
            android.content.Context r12 = r0.f75003a     // Catch:{ Exception -> 0x01c2 }
            android.content.Context r12 = r12.getApplicationContext()     // Catch:{ Exception -> 0x01c2 }
            r5.sendCustomEventWithMap(r7, r4, r12)     // Catch:{ Exception -> 0x01c2 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x01c2 }
            r4.<init>()     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "pay_transaction_order_status"
            java.lang.String r7 = r2.getStatus()     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r7)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = "pay_transaction_id"
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x01c2 }
            r4.put(r5, r2)     // Catch:{ Exception -> 0x01c2 }
            if (r3 == 0) goto L_0x01b3
            java.lang.String r2 = "movies_order_id"
            long r17 = r3.getId()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r17)     // Catch:{ Exception -> 0x01c2 }
            r4.put(r2, r5)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r2 = "movies_product_id"
            long r17 = r3.getProductId()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r17)     // Catch:{ Exception -> 0x01c2 }
            r4.put(r2, r5)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r2 = "movies_qty"
            int r5 = r3.getQuantity()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x01c2 }
            r4.put(r2, r5)     // Catch:{ Exception -> 0x01c2 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r3.getProductDetail()     // Catch:{ Exception -> 0x01c2 }
            if (r2 == 0) goto L_0x01b3
            java.lang.String r2 = "movies_price"
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r3.getProductDetail()     // Catch:{ Exception -> 0x01c2 }
            double r17 = r5.getPrice()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Double r5 = java.lang.Double.valueOf(r17)     // Catch:{ Exception -> 0x01c2 }
            r4.put(r2, r5)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r2 = "pay_product_name"
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r3.getProductDetail()     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x01c2 }
            r4.put(r2, r5)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r2 = "pay_brand_name"
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r5 = r3.getProductDetail()     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r5 = r5.getBrandName()     // Catch:{ Exception -> 0x01c2 }
            r4.put(r2, r5)     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r2 = "pay_product_category_id"
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r3.getProductDetail()     // Catch:{ Exception -> 0x01c2 }
            long r17 = r3.getCategoryId()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Long r3 = java.lang.Long.valueOf(r17)     // Catch:{ Exception -> 0x01c2 }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x01c2 }
        L_0x01b3:
            net.one97.paytm.o2o.movies.common.c.b r2 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x01c2 }
            net.one97.paytm.o2o.movies.common.c.c r2 = r2.f75033b     // Catch:{ Exception -> 0x01c2 }
            java.lang.String r3 = "pay_order_summary_order_status"
            android.content.Context r0 = r0.f75003a     // Catch:{ Exception -> 0x01c2 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x01c2 }
            r2.sendCustomEventWithMap(r3, r4, r0)     // Catch:{ Exception -> 0x01c2 }
        L_0x01c2:
            r8.b((boolean) r11)     // Catch:{ Exception -> 0x08cf }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x08cf }
            java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x08cf }
            r8.l = r0     // Catch:{ Exception -> 0x08cf }
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r     // Catch:{ Exception -> 0x08cf }
            if (r0 == 0) goto L_0x01de
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r     // Catch:{ Exception -> 0x08cf }
            int r0 = r0.size()     // Catch:{ Exception -> 0x08cf }
            if (r0 <= 0) goto L_0x01de
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r     // Catch:{ Exception -> 0x08cf }
            r0.clear()     // Catch:{ Exception -> 0x08cf }
        L_0x01de:
            r2 = 1
            boolean r0 = r8.e((boolean) r2)     // Catch:{ Exception -> 0x08cf }
            java.lang.String r12 = "FAILED"
            if (r0 == 0) goto L_0x0203
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x08cf }
            if (r0 == 0) goto L_0x01f6
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x08cf }
            boolean r0 = r0.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x08cf }
            if (r0 == 0) goto L_0x01f6
            r25.n()     // Catch:{ Exception -> 0x08cf }
        L_0x01f6:
            r18 = r6
            r19 = r9
            r22 = r10
            r20 = r13
            r9 = r14
            r10 = r15
            r15 = 0
            goto L_0x06b9
        L_0x0203:
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r0 = r25.l()     // Catch:{ Exception -> 0x08cf }
            if (r0 == 0) goto L_0x0222
            int r2 = r0.getPostFBOrder()     // Catch:{ Exception -> 0x08cf }
            int r3 = r8.D     // Catch:{ Exception -> 0x08cf }
            if (r2 != r3) goto L_0x0215
            int r2 = r8.D     // Catch:{ Exception -> 0x08cf }
            r8.E = r2     // Catch:{ Exception -> 0x08cf }
        L_0x0215:
            java.lang.String r2 = r0.getParent_order_id()     // Catch:{ Exception -> 0x08cf }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x08cf }
            if (r2 != 0) goto L_0x0222
            r0.getParent_order_id()     // Catch:{ Exception -> 0x08cf }
        L_0x0222:
            r25.m()     // Catch:{ Exception -> 0x08cf }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x08cf }
            java.lang.String r7 = r0.getStatus()     // Catch:{ Exception -> 0x08cf }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x08cf }
            java.lang.String r0 = r0.getPaymentStatus()     // Catch:{ Exception -> 0x08cf }
            r8.c((java.lang.String) r0)     // Catch:{ Exception -> 0x08cf }
            if (r7 == 0) goto L_0x05f2
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r     // Catch:{ Exception -> 0x05e7 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r8.q     // Catch:{ Exception -> 0x05e7 }
            java.lang.String r3 = r8.l     // Catch:{ Exception -> 0x05e7 }
            java.lang.String r4 = r8.C     // Catch:{ Exception -> 0x05e7 }
            int r5 = r8.E     // Catch:{ Exception -> 0x05e7 }
            int r11 = r8.D     // Catch:{ Exception -> 0x05e7 }
            if (r5 != r11) goto L_0x0246
            r5 = 1
            goto L_0x0247
        L_0x0246:
            r5 = 0
        L_0x0247:
            java.lang.String r11 = r2.getPaymentStatus()     // Catch:{ Exception -> 0x05e7 }
            if (r0 == 0) goto L_0x0417
            r18 = r6
            java.util.ArrayList r6 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x08d1 }
            r19 = r9
            r9 = 0
            java.lang.Object r6 = r6.get(r9)     // Catch:{ Exception -> 0x08d3 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6     // Catch:{ Exception -> 0x08d3 }
            if (r6 == 0) goto L_0x02e4
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r6 = net.one97.paytm.o2o.movies.b.c.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r6)     // Catch:{ Exception -> 0x08d3 }
            if (r6 == 0) goto L_0x0269
            int r9 = r6.getIsInsurancePresentV2()     // Catch:{ Exception -> 0x08d3 }
            goto L_0x026a
        L_0x0269:
            r9 = 0
        L_0x026a:
            if (r6 == 0) goto L_0x0289
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r20 = r6.getInsuranceConfig()     // Catch:{ Exception -> 0x08d3 }
            if (r20 == 0) goto L_0x0289
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r20 = r6.getInsuranceConfig()     // Catch:{ Exception -> 0x08d3 }
            java.lang.Boolean r20 = r20.getShare_booking_id()     // Catch:{ Exception -> 0x08d3 }
            if (r20 == 0) goto L_0x0289
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r20 = r6.getInsuranceConfig()     // Catch:{ Exception -> 0x08d3 }
            java.lang.Boolean r20 = r20.getShare_booking_id()     // Catch:{ Exception -> 0x08d3 }
            boolean r20 = r20.booleanValue()     // Catch:{ Exception -> 0x08d3 }
            goto L_0x028b
        L_0x0289:
            r20 = 0
        L_0x028b:
            if (r6 == 0) goto L_0x029a
            r21 = r9
            int r9 = r6.getIsCancellationAllowed()     // Catch:{ Exception -> 0x08d3 }
            r22 = r10
            r10 = 1
            if (r9 != r10) goto L_0x029e
            r9 = 1
            goto L_0x029f
        L_0x029a:
            r21 = r9
            r22 = r10
        L_0x029e:
            r9 = 0
        L_0x029f:
            if (r6 == 0) goto L_0x02d9
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r10 = r6.getInsuranceConfig()     // Catch:{ Exception -> 0x08d5 }
            if (r10 == 0) goto L_0x02d9
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r10 = r6.getInsuranceConfig()     // Catch:{ Exception -> 0x08d5 }
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r10 = r10.getTerms_cond()     // Catch:{ Exception -> 0x08d5 }
            if (r10 == 0) goto L_0x02d9
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r10 = r6.getInsuranceConfig()     // Catch:{ Exception -> 0x08d5 }
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r10 = r10.getTerms_cond()     // Catch:{ Exception -> 0x08d5 }
            net.one97.paytm.o2o.movies.entity.CJRCPSlab r10 = r10.getSlabs()     // Catch:{ Exception -> 0x08d5 }
            if (r10 != 0) goto L_0x02cd
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r10 = r6.getInsuranceConfig()     // Catch:{ Exception -> 0x08d5 }
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r10 = r10.getTerms_cond()     // Catch:{ Exception -> 0x08d5 }
            net.one97.paytm.o2o.movies.entity.CJRCPTerm r10 = r10.getTerms()     // Catch:{ Exception -> 0x08d5 }
            if (r10 == 0) goto L_0x02d9
        L_0x02cd:
            net.one97.paytm.o2o.movies.entity.CJRInsuranceConfig r6 = r6.getInsuranceConfig()     // Catch:{ Exception -> 0x08d5 }
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond r6 = r6.getTerms_cond()     // Catch:{ Exception -> 0x08d5 }
            r10 = r9
            r9 = r20
            goto L_0x02dd
        L_0x02d9:
            r10 = r9
            r9 = r20
            r6 = 0
        L_0x02dd:
            r20 = r13
            r13 = r21
            r21 = r1
            goto L_0x02ee
        L_0x02e4:
            r22 = r10
            r21 = r1
            r20 = r13
            r6 = 0
            r9 = 0
            r10 = 0
            r13 = 0
        L_0x02ee:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2$a r1 = new net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2$a     // Catch:{ Exception -> 0x0413 }
            r1.<init>()     // Catch:{ Exception -> 0x0413 }
            net.one97.paytm.orders.a.a r23 = net.one97.paytm.orders.a.a.LAYOUT_HEADER_CARD     // Catch:{ Exception -> 0x0413 }
            r24 = r15
            java.lang.String r15 = r23.getName()     // Catch:{ Exception -> 0x040e }
            r23 = r14
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r14 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            r14.setLayout(r15)     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r14 = net.one97.paytm.o2o.movies.b.c.d((net.one97.paytm.common.entity.shopping.CJROrderSummary) r2)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r15 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            java.lang.String unused = r15.summaryType = r14     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r14 = r2.getPaymentStatus()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r15 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            java.lang.String unused = r15.paymentStatus = r14     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r14 = r2.getPaymentText()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r15 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            java.lang.String unused = r15.paymentDescription = r14     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r14 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            java.lang.String unused = r14.orderStatus = r7     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r14 = net.one97.paytm.o2o.movies.b.c.c((net.one97.paytm.common.entity.shopping.CJROrderSummary) r2)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r15 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            java.lang.String unused = r15.merchantName = r14     // Catch:{ Exception -> 0x04c6 }
            if (r2 != 0) goto L_0x032f
            r14 = 0
            goto L_0x0388
        L_0x032f:
            if (r2 != 0) goto L_0x0335
            if (r7 == 0) goto L_0x0335
            r14 = r7
            goto L_0x0388
        L_0x0335:
            if (r7 == 0) goto L_0x0360
            boolean r14 = r7.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x04c6 }
            if (r14 != 0) goto L_0x0355
            java.lang.String r14 = "PAYMENT_FAILED"
            boolean r14 = r7.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04c6 }
            if (r14 != 0) goto L_0x0355
            java.lang.String r14 = "BILL_CANCELLED"
            boolean r14 = r7.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04c6 }
            if (r14 != 0) goto L_0x0355
            java.lang.String r14 = "PAYMENT_CANCELLED"
            boolean r14 = r7.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04c6 }
            if (r14 == 0) goto L_0x0360
        L_0x0355:
            android.content.res.Resources r14 = r25.getResources()     // Catch:{ Exception -> 0x04c6 }
            int r15 = net.one97.paytm.o2o.movies.R.string.train_payment_failed     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ Exception -> 0x04c6 }
            goto L_0x0388
        L_0x0360:
            java.lang.String r14 = "PROCESSING"
            boolean r14 = r7.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04c6 }
            if (r14 != 0) goto L_0x037e
            java.lang.String r14 = "PAYMENT_PENDING"
            boolean r14 = r7.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04c6 }
            if (r14 != 0) goto L_0x037e
            java.lang.String r14 = "PENDING"
            boolean r14 = r7.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04c6 }
            if (r14 == 0) goto L_0x0379
            goto L_0x037e
        L_0x0379:
            java.lang.String r14 = net.one97.paytm.o2o.movies.b.c.a(r8, r2)     // Catch:{ Exception -> 0x04c6 }
            goto L_0x0388
        L_0x037e:
            android.content.res.Resources r14 = r25.getResources()     // Catch:{ Exception -> 0x04c6 }
            int r15 = net.one97.paytm.o2o.movies.R.string.train_payment_pending     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ Exception -> 0x04c6 }
        L_0x0388:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r15 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            java.lang.String unused = r15.badgeText = r14     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r14 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            java.lang.String unused = r14.orderId = r3     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r14 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x04c6 }
            java.lang.Boolean unused = r14.isFromPostOrder = r15     // Catch:{ Exception -> 0x04c6 }
            int r14 = net.one97.paytm.o2o.movies.b.c.b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r2)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r15 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            int unused = r15.movieTicketStatus = r14     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r14 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.entity.CJRCPTermsAndCond unused = r14.insuranceTerms = r6     // Catch:{ Exception -> 0x04c6 }
            java.util.ArrayList r6 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            if (r6 == 0) goto L_0x03c8
            int r14 = r6.size()     // Catch:{ Exception -> 0x04c6 }
            if (r14 <= 0) goto L_0x03c8
            r14 = 0
            java.lang.Object r6 = r6.get(r14)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r6 = net.one97.paytm.o2o.movies.b.c.d((net.one97.paytm.common.entity.shopping.CJROrderedCart) r6)     // Catch:{ Exception -> 0x04c6 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x04c6 }
            if (r6 != 0) goto L_0x03c8
            r6 = 1
            goto L_0x03c9
        L_0x03c8:
            r6 = 0
        L_0x03c9:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r14 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            boolean unused = r14.QRcodePresent = r6     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r6 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            int unused = r6.isInsurancePresent = r13     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r6 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            boolean unused = r6.shareBookingId = r9     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r6 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            boolean unused = r6.isCancellationAllowed = r10     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 r1 = r1.f75153a     // Catch:{ Exception -> 0x04c6 }
            java.util.ArrayList r6 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            r9 = 0
            java.lang.Object r6 = r6.get(r9)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r6 = net.one97.paytm.o2o.movies.b.c.a(r6, r2, r4, r3)     // Catch:{ Exception -> 0x04c6 }
            if (r1 == 0) goto L_0x0425
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r9 = new net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a     // Catch:{ Exception -> 0x04c6 }
            r9.<init>()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.orders.a.a r10 = net.one97.paytm.orders.a.a.LAYOUT_HEADER_CARD     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r10 = r10.getName()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r9 = r9.a((java.lang.String) r10)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r10 = r9.f75156a     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryHeaderItemV2 unused = r10.mSummaryHeader = r1     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r1 = r9.a((net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2) r6)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r1 = r1.f75156a     // Catch:{ Exception -> 0x04c6 }
            r0.add(r1)     // Catch:{ Exception -> 0x04c6 }
            goto L_0x0425
        L_0x040e:
            r9 = r14
        L_0x040f:
            r3 = r20
            goto L_0x04ca
        L_0x0413:
            r9 = r14
            r10 = r15
            goto L_0x05e3
        L_0x0417:
            r21 = r1
            r18 = r6
            r19 = r9
            r22 = r10
            r20 = r13
            r23 = r14
            r24 = r15
        L_0x0425:
            if (r0 == 0) goto L_0x04ce
            if (r2 == 0) goto L_0x04ce
            java.util.ArrayList r1 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            if (r1 == 0) goto L_0x04ce
            java.util.ArrayList r1 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x04c6 }
            if (r1 == 0) goto L_0x04ce
            java.util.ArrayList r1 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            r6 = 0
            java.lang.Object r1 = r1.get(r6)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r1 = net.one97.paytm.o2o.movies.b.c.a(r1, r2, r4, r3)     // Catch:{ Exception -> 0x04c6 }
            if (r1 == 0) goto L_0x04ce
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r3 = new net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a     // Catch:{ Exception -> 0x04c6 }
            r3.<init>()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.orders.a.a r4 = net.one97.paytm.orders.a.a.LAYOUT_SUCCESS_MOVIE_DESC_CARD     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r3 = r3.a((java.lang.String) r4)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r1 = r3.a((net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2) r1)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem r3 = net.one97.paytm.o2o.movies.b.c.e((net.one97.paytm.common.entity.shopping.CJROrderSummary) r2)     // Catch:{ Exception -> 0x04c6 }
            if (r3 == 0) goto L_0x0468
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r4 = r1.f75156a     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMoviePaymentItem unused = r4.mMoviePaymentItem = r3     // Catch:{ Exception -> 0x04c6 }
        L_0x0468:
            if (r5 == 0) goto L_0x04b6
            if (r2 == 0) goto L_0x04a3
            java.util.ArrayList r3 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            if (r3 == 0) goto L_0x04a3
            java.util.ArrayList r3 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x04c6 }
            if (r3 <= 0) goto L_0x04a3
            java.util.ArrayList r3 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r3 = net.one97.paytm.o2o.movies.b.c.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)     // Catch:{ Exception -> 0x04c6 }
            java.util.ArrayList r5 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r5 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r5     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r4 = net.one97.paytm.o2o.movies.b.c.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r5)     // Catch:{ Exception -> 0x04c6 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x04c6 }
            if (r5 != 0) goto L_0x04a4
            r3.setUniqueBookingId(r4)     // Catch:{ Exception -> 0x04c6 }
            goto L_0x04a4
        L_0x04a3:
            r3 = 0
        L_0x04a4:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2$a r4 = new net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2$a     // Catch:{ Exception -> 0x04c6 }
            r4.<init>()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2$a r4 = r4.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r2)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2$a r3 = r4.a((net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2) r3)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2 r3 = r3.f75152a     // Catch:{ Exception -> 0x04c6 }
            r1.a((net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2) r3)     // Catch:{ Exception -> 0x04c6 }
        L_0x04b6:
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r3 = r1.f75156a     // Catch:{ Exception -> 0x04c6 }
            java.lang.String unused = r3.paymentStatus = r11     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r3 = r1.f75156a     // Catch:{ Exception -> 0x04c6 }
            java.lang.String unused = r3.orderStatus = r7     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r1 = r1.f75156a     // Catch:{ Exception -> 0x04c6 }
            r0.add(r1)     // Catch:{ Exception -> 0x04c6 }
            goto L_0x04ce
        L_0x04c6:
            r3 = r20
            r9 = r23
        L_0x04ca:
            r10 = r24
            goto L_0x08d8
        L_0x04ce:
            if (r0 == 0) goto L_0x0534
            if (r2 == 0) goto L_0x04f2
            java.util.ArrayList r1 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            if (r1 == 0) goto L_0x04f2
            java.util.ArrayList r1 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x04c6 }
            if (r1 <= 0) goto L_0x04f2
            java.util.ArrayList r1 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x04c6 }
            r3 = 0
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r1 = net.one97.paytm.o2o.movies.b.c.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)     // Catch:{ Exception -> 0x04c6 }
            goto L_0x04f3
        L_0x04f2:
            r1 = 0
        L_0x04f3:
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2$a r3 = new net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2$a     // Catch:{ Exception -> 0x04c6 }
            r3.<init>()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.orders.a.a r4 = net.one97.paytm.orders.a.a.LAYOUT_FOOTER_CARD     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2 r5 = r3.f75152a     // Catch:{ Exception -> 0x04c6 }
            r5.setLayout(r4)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.common.entity.shopping.CJROrdersummaryFooter r4 = r2.getFooter()     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r4 = r4.getDescription()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2 r5 = r3.f75152a     // Catch:{ Exception -> 0x04c6 }
            java.lang.String unused = r5.name = r4     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2$a r2 = r3.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r2)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2$a r1 = r2.a((net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2) r1)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2 r1 = r1.f75152a     // Catch:{ Exception -> 0x04c6 }
            if (r1 == 0) goto L_0x0534
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r2 = new net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a     // Catch:{ Exception -> 0x04c6 }
            r2.<init>()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.orders.a.a r3 = net.one97.paytm.orders.a.a.LAYOUT_FOOTER_CARD     // Catch:{ Exception -> 0x04c6 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r2 = r2.a((java.lang.String) r3)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r1 = r2.a((net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryContactUsItemV2) r1)     // Catch:{ Exception -> 0x04c6 }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r1 = r1.f75156a     // Catch:{ Exception -> 0x04c6 }
            r0.add(r1)     // Catch:{ Exception -> 0x04c6 }
        L_0x0534:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x05df }
            net.one97.paytm.o2o.movies.b.c r1 = r8.v     // Catch:{ Exception -> 0x05df }
            r2 = -1
            if (r1 == 0) goto L_0x05ae
            if (r0 == 0) goto L_0x05ae
            r9 = r23
            boolean r1 = r9.equals(r7)     // Catch:{ Exception -> 0x05e1 }
            if (r1 != 0) goto L_0x054d
            java.lang.String r1 = "BOOKED"
            boolean r1 = r1.equals(r7)     // Catch:{ Exception -> 0x040f }
            if (r1 == 0) goto L_0x05b0
        L_0x054d:
            int r0 = net.one97.paytm.o2o.movies.b.c.b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r0)     // Catch:{ Exception -> 0x05e1 }
            r1 = 15
            if (r0 == r1) goto L_0x0558
            r1 = 7
            if (r0 != r1) goto L_0x05b0
        L_0x0558:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r8.O     // Catch:{ Exception -> 0x05e1 }
            android.content.res.Resources r1 = r25.getResources()     // Catch:{ Exception -> 0x05e1 }
            int r3 = net.one97.paytm.o2o.movies.R.color.greenblue     // Catch:{ Exception -> 0x05e1 }
            int r1 = r1.getColor(r3)     // Catch:{ Exception -> 0x05e1 }
            r0.setBackgroundColor(r1)     // Catch:{ Exception -> 0x05e1 }
            android.widget.ImageView r0 = r8.G     // Catch:{ Exception -> 0x05e1 }
            r0.setColorFilter(r2)     // Catch:{ Exception -> 0x05e1 }
            android.widget.ImageView r0 = r8.F     // Catch:{ Exception -> 0x05e1 }
            r0.setColorFilter(r2)     // Catch:{ Exception -> 0x05e1 }
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x05e1 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x05e1 }
            if (r0 != 0) goto L_0x05aa
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x05e1 }
            r10 = r24
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x05e3 }
            if (r0 == 0) goto L_0x05ac
            java.lang.String r0 = "https://storefront.paytm.com/v2/h/post-txn-page-new"
            net.one97.paytm.o2o.movies.common.c.b r1 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x05a1 }
            net.one97.paytm.o2o.movies.common.c.c r1 = r1.f75033b     // Catch:{ Exception -> 0x05a1 }
            java.lang.String r2 = "movie_order_sf_v2"
            java.lang.String r1 = r1.getStringFromGTM(r2, r0)     // Catch:{ Exception -> 0x05a1 }
            android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x05a1 }
            java.lang.String r0 = com.paytm.utility.c.b((java.lang.String) r0, (android.content.Context) r8)     // Catch:{ Exception -> 0x05a1 }
            net.one97.paytm.o2o.movies.utils.a r1 = net.one97.paytm.o2o.movies.utils.a.f75896a     // Catch:{ Exception -> 0x05a1 }
            net.one97.paytm.o2o.movies.activity.-$$Lambda$AJRMovieOrderSummary$mcFmcBRR3e-9DbLFziZw_jl5hl8 r1 = new net.one97.paytm.o2o.movies.activity.-$$Lambda$AJRMovieOrderSummary$mcFmcBRR3e-9DbLFziZw_jl5hl8     // Catch:{ Exception -> 0x05a1 }
            r1.<init>()     // Catch:{ Exception -> 0x05a1 }
            net.one97.paytm.o2o.movies.utils.a.a(r0, r1)     // Catch:{ Exception -> 0x05a1 }
            goto L_0x05ac
        L_0x05a1:
            r0 = move-exception
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ Exception -> 0x05e3 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x05e3 }
            goto L_0x05ac
        L_0x05aa:
            r10 = r24
        L_0x05ac:
            r6 = 0
            goto L_0x05c2
        L_0x05ae:
            r9 = r23
        L_0x05b0:
            r10 = r24
            androidx.constraintlayout.widget.ConstraintLayout r0 = r8.O     // Catch:{ Exception -> 0x05e3 }
            r0.setBackgroundColor(r2)     // Catch:{ Exception -> 0x05e3 }
            android.widget.ImageView r0 = r8.G     // Catch:{ Exception -> 0x05e3 }
            r6 = 0
            r0.setColorFilter(r6)     // Catch:{ Exception -> 0x08cd }
            android.widget.ImageView r0 = r8.F     // Catch:{ Exception -> 0x08cd }
            r0.setColorFilter(r6)     // Catch:{ Exception -> 0x08cd }
        L_0x05c2:
            net.one97.paytm.o2o.movies.adapter.ag r0 = new net.one97.paytm.o2o.movies.adapter.ag     // Catch:{ Exception -> 0x08cd }
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r1 = r8.r     // Catch:{ Exception -> 0x08cd }
            r0.<init>(r8, r8, r1)     // Catch:{ Exception -> 0x08cd }
            r8.s = r0     // Catch:{ Exception -> 0x08cd }
            net.one97.paytm.o2o.movies.adapter.ag r0 = r8.s     // Catch:{ Exception -> 0x08cd }
            r0.f74316e = r8     // Catch:{ Exception -> 0x08cd }
            net.one97.paytm.o2o.movies.adapter.ag r0 = r8.s     // Catch:{ Exception -> 0x08cd }
            r0.f74317f = r8     // Catch:{ Exception -> 0x08cd }
            androidx.recyclerview.widget.RecyclerView r0 = r8.n     // Catch:{ Exception -> 0x08cd }
            net.one97.paytm.o2o.movies.adapter.ag r1 = r8.s     // Catch:{ Exception -> 0x08cd }
            r0.setAdapter(r1)     // Catch:{ Exception -> 0x08cd }
            r1 = 1
            r8.g(r1)     // Catch:{ Exception -> 0x08cd }
            goto L_0x05ff
        L_0x05df:
            r9 = r23
        L_0x05e1:
            r10 = r24
        L_0x05e3:
            r3 = r20
            goto L_0x08d8
        L_0x05e7:
            r18 = r6
            r19 = r9
            r22 = r10
            r9 = r14
            r10 = r15
            r3 = r13
            goto L_0x08d8
        L_0x05f2:
            r21 = r1
            r18 = r6
            r19 = r9
            r22 = r10
            r20 = r13
            r9 = r14
            r10 = r15
            r6 = 0
        L_0x05ff:
            boolean r0 = r7.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x08cd }
            if (r0 == 0) goto L_0x069f
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x0690 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0690 }
            if (r0 != 0) goto L_0x068e
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x0690 }
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x0690 }
            if (r0 != 0) goto L_0x061f
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x0690 }
            java.lang.String r1 = "paytm_automatic"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0690 }
            if (r0 == 0) goto L_0x068e
        L_0x061f:
            net.one97.paytm.common.widgets.c r0 = r8.L     // Catch:{ Exception -> 0x0690 }
            if (r0 != 0) goto L_0x066d
            net.one97.paytm.o2o.movies.common.b.c.a()     // Catch:{ Exception -> 0x0690 }
            java.lang.String r0 = "app_rating_5_star_time_gap"
            r1 = r21
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.c.a(r0, r1)     // Catch:{ Exception -> 0x0690 }
            long r2 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0690 }
            net.one97.paytm.o2o.movies.common.b.c.a()     // Catch:{ Exception -> 0x0690 }
            java.lang.String r0 = "app_rating_less_than_5_star_time_gap"
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.c.a(r0, r1)     // Catch:{ Exception -> 0x0690 }
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0690 }
            net.one97.paytm.o2o.movies.common.b.c.a()     // Catch:{ Exception -> 0x0690 }
            java.lang.String r0 = "app_rating_not_now_time_gap"
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.c.a(r0, r1)     // Catch:{ Exception -> 0x0690 }
            long r13 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x0690 }
            r1 = r25
            r15 = r6
            r11 = r7
            r6 = r13
            boolean r0 = com.paytm.utility.b.a((android.content.Context) r1, (long) r2, (long) r4, (long) r6)     // Catch:{ Exception -> 0x068c }
            if (r0 == 0) goto L_0x066f
            net.one97.paytm.common.widgets.c r0 = new net.one97.paytm.common.widgets.c     // Catch:{ Exception -> 0x068c }
            r0.<init>()     // Catch:{ Exception -> 0x068c }
            r8.L = r0     // Catch:{ Exception -> 0x068c }
            net.one97.paytm.common.widgets.c r0 = r8.L     // Catch:{ Exception -> 0x068c }
            r0.a((net.one97.paytm.common.widgets.a.a) r8)     // Catch:{ Exception -> 0x068c }
            net.one97.paytm.common.widgets.c r0 = r8.L     // Catch:{ Exception -> 0x068c }
            androidx.fragment.app.j r1 = r25.getSupportFragmentManager()     // Catch:{ Exception -> 0x068c }
            r0.show((androidx.fragment.app.j) r1, (java.lang.String) r15)     // Catch:{ Exception -> 0x068c }
            goto L_0x066f
        L_0x066d:
            r15 = r6
            r11 = r7
        L_0x066f:
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x068c }
            net.one97.paytm.o2o.movies.common.c.c r1 = r0.f75033b     // Catch:{ Exception -> 0x068c }
            java.lang.String r3 = "movies"
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x068c }
            double r4 = r0.getSubTotal()     // Catch:{ Exception -> 0x068c }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x068c }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x068c }
            java.lang.String r5 = r0.getId()     // Catch:{ Exception -> 0x068c }
            r2 = r25
            r6 = r11
            r1.sendTransactionBetaOutForWallet(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x068c }
            goto L_0x0699
        L_0x068c:
            r0 = move-exception
            goto L_0x0692
        L_0x068e:
            r15 = r6
            goto L_0x0699
        L_0x0690:
            r0 = move-exception
            r15 = r6
        L_0x0692:
            java.lang.String r0 = a((java.lang.Exception) r0)     // Catch:{ Exception -> 0x08ca }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x08ca }
        L_0x0699:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.b.c.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r0)     // Catch:{ Exception -> 0x08ca }
            goto L_0x06a0
        L_0x069f:
            r15 = r6
        L_0x06a0:
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x08ca }
            if (r0 == 0) goto L_0x06af
            java.lang.String r0 = r8.k     // Catch:{ Exception -> 0x08ca }
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x08ca }
            if (r0 == 0) goto L_0x06af
            r25.n()     // Catch:{ Exception -> 0x08ca }
        L_0x06af:
            android.widget.ImageView r0 = r8.F     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.activity.-$$Lambda$AJRMovieOrderSummary$RnBv_CT5x6CMQkcw95Gxzo70Jcg r1 = new net.one97.paytm.o2o.movies.activity.-$$Lambda$AJRMovieOrderSummary$RnBv_CT5x6CMQkcw95Gxzo70Jcg     // Catch:{ Exception -> 0x08ca }
            r1.<init>()     // Catch:{ Exception -> 0x08ca }
            r0.setOnClickListener(r1)     // Catch:{ Exception -> 0x08ca }
        L_0x06b9:
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r     // Catch:{ Exception -> 0x08ca }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r0 = (net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem) r0     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r0 = r0.getMovieDescItem()     // Catch:{ Exception -> 0x08ca }
            java.lang.String r0 = r0.getMovieName()     // Catch:{ Exception -> 0x08ca }
            r8.f74030b = r0     // Catch:{ Exception -> 0x08ca }
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r     // Catch:{ Exception -> 0x08ca }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r0 = (net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem) r0     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r0 = r0.getMovieDescItem()     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r0 = r0.getMetaDataresponse()     // Catch:{ Exception -> 0x08ca }
            java.lang.String r0 = r0.getMovieCode()     // Catch:{ Exception -> 0x08ca }
            r8.f74031c = r0     // Catch:{ Exception -> 0x08ca }
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r     // Catch:{ Exception -> 0x08ca }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r0 = (net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem) r0     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r0 = r0.getMovieDescItem()     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r0 = r0.getMetaDataresponse()     // Catch:{ Exception -> 0x08ca }
            java.lang.String r0 = r0.getCinemaId()     // Catch:{ Exception -> 0x08ca }
            r8.f74034f = r0     // Catch:{ Exception -> 0x08ca }
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r     // Catch:{ Exception -> 0x08ca }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r0 = (net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem) r0     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r0 = r0.getMovieDescItem()     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r0 = r0.getMetaDataresponse()     // Catch:{ Exception -> 0x08ca }
            java.lang.String r0 = r0.getCinema()     // Catch:{ Exception -> 0x08ca }
            r8.f74033e = r0     // Catch:{ Exception -> 0x08ca }
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r     // Catch:{ Exception -> 0x08ca }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r0 = (net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem) r0     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r0 = r0.getMovieDescItem()     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r0 = r0.getMetaDataresponse()     // Catch:{ Exception -> 0x08ca }
            java.lang.String r0 = r0.getpKey()     // Catch:{ Exception -> 0x08ca }
            r8.f74035g = r0     // Catch:{ Exception -> 0x08ca }
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r     // Catch:{ Exception -> 0x08ca }
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r0 = (net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem) r0     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.o2o.movies.common.movies.orders.CJRSummaryMovieDescItemV2 r0 = r0.getMovieDescItem()     // Catch:{ Exception -> 0x08ca }
            java.lang.String r0 = r0.getMovieLanguage()     // Catch:{ Exception -> 0x08ca }
            r8.f74032d = r0     // Catch:{ Exception -> 0x08ca }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x08c4 }
            if (r0 != 0) goto L_0x0743
        L_0x073f:
            r3 = r20
            goto L_0x08e7
        L_0x0743:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x08c4 }
            java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ Exception -> 0x08c4 }
            if (r0 != 0) goto L_0x074c
            goto L_0x073f
        L_0x074c:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x08c4 }
            java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ Exception -> 0x08c4 }
            int r0 = r0.size()     // Catch:{ Exception -> 0x08c4 }
            if (r0 != 0) goto L_0x0759
            goto L_0x073f
        L_0x0759:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x08c4 }
            java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ Exception -> 0x08c4 }
            if (r0 == 0) goto L_0x073f
            int r1 = r0.size()     // Catch:{ Exception -> 0x08c4 }
            if (r1 <= 0) goto L_0x073f
            r1 = 0
            java.lang.Object r2 = r0.get(r1)     // Catch:{ Exception -> 0x08c4 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2     // Catch:{ Exception -> 0x08c4 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r2.getProductDetail()     // Catch:{ Exception -> 0x08c4 }
            if (r2 == 0) goto L_0x073f
            java.lang.Object r2 = r0.get(r1)     // Catch:{ Exception -> 0x08c4 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2     // Catch:{ Exception -> 0x08c4 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r2.getProductDetail()     // Catch:{ Exception -> 0x08c4 }
            r1.getCategoryId()     // Catch:{ Exception -> 0x08c4 }
            if (r1 == 0) goto L_0x073f
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x08b9 }
            r2.<init>()     // Catch:{ Exception -> 0x08b9 }
            java.lang.String r3 = "screenName"
            java.lang.String r4 = "/summary"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x08b9 }
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x08b9 }
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.D     // Catch:{ Exception -> 0x08b9 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x08b9 }
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x08b9 }
            java.lang.String r4 = "Order Summary Screen Loaded"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x08b9 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r8.q     // Catch:{ Exception -> 0x08b9 }
            if (r3 == 0) goto L_0x07b5
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r8.q     // Catch:{ Exception -> 0x08b9 }
            java.lang.String r3 = r3.getStatus()     // Catch:{ Exception -> 0x08b9 }
            boolean r3 = r3.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x08b9 }
            if (r3 == 0) goto L_0x07b5
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x08b9 }
            java.lang.String r4 = "Order Success"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x08b9 }
            goto L_0x07cc
        L_0x07b5:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r8.q     // Catch:{ Exception -> 0x08b9 }
            if (r3 == 0) goto L_0x07cc
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r8.q     // Catch:{ Exception -> 0x08b9 }
            java.lang.String r3 = r3.getStatus()     // Catch:{ Exception -> 0x08b9 }
            boolean r3 = r3.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x08b9 }
            if (r3 == 0) goto L_0x07cc
            java.lang.String r3 = net.one97.paytm.o2o.movies.common.b.b.f75009d     // Catch:{ Exception -> 0x08b9 }
            java.lang.String r4 = "Order Failure"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x08b9 }
        L_0x07cc:
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x08b9 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ Exception -> 0x08b9 }
            java.util.Map r0 = r0.getRechargeConfiguration()     // Catch:{ Exception -> 0x08b9 }
            if (r0 == 0) goto L_0x07eb
            java.lang.String r3 = "price"
            boolean r3 = r0.containsKey(r3)     // Catch:{ Exception -> 0x08b9 }
            if (r3 == 0) goto L_0x07eb
            java.lang.String r3 = "price"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ Exception -> 0x08b9 }
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x08b9 }
            goto L_0x07ed
        L_0x07eb:
            r6 = r18
        L_0x07ed:
            r3 = r20
            if (r0 == 0) goto L_0x07fe
            boolean r4 = r0.containsKey(r3)     // Catch:{ Exception -> 0x08b7 }
            if (r4 == 0) goto L_0x07fe
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x08b7 }
            goto L_0x0800
        L_0x07fe:
            r0 = r18
        L_0x0800:
            java.lang.String r4 = net.one97.paytm.o2o.movies.common.b.b.f75010e     // Catch:{ Exception -> 0x08b7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r7 = "order_id="
            r5.<init>(r7)     // Catch:{ Exception -> 0x08b7 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r8.q     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r7 = r7.getId()     // Catch:{ Exception -> 0x08b7 }
            r5.append(r7)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r7 = "&product_id="
            r5.append(r7)     // Catch:{ Exception -> 0x08b7 }
            long r13 = r1.getId()     // Catch:{ Exception -> 0x08b7 }
            r5.append(r13)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = "&price="
            r5.append(r1)     // Catch:{ Exception -> 0x08b7 }
            r5.append(r6)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = "&qty="
            r5.append(r1)     // Catch:{ Exception -> 0x08b7 }
            r5.append(r0)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x08b7 }
            r2.put(r4, r0)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.d.b((android.content.Context) r25)     // Catch:{ Exception -> 0x08b7 }
            if (r0 == 0) goto L_0x0846
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x08b7 }
            if (r1 != 0) goto L_0x0846
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75013h     // Catch:{ Exception -> 0x08b7 }
            r2.put(r1, r0)     // Catch:{ Exception -> 0x08b7 }
        L_0x0846:
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75014i     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = r8.f74030b     // Catch:{ Exception -> 0x08b7 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.j     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = r8.f74031c     // Catch:{ Exception -> 0x08b7 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.k     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = r8.f74033e     // Catch:{ Exception -> 0x08b7 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.l     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = r8.f74034f     // Catch:{ Exception -> 0x08b7 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r0 = r8.f74035g     // Catch:{ Exception -> 0x08b7 }
            if (r0 == 0) goto L_0x086d
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.m     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = r8.f74035g     // Catch:{ Exception -> 0x08b7 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x08b7 }
        L_0x086d:
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.n     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = r8.f74032d     // Catch:{ Exception -> 0x08b7 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.p     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.r     // Catch:{ Exception -> 0x08b7 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x08b7 }
            boolean r0 = com.paytm.utility.b.r((android.content.Context) r25)     // Catch:{ Exception -> 0x08b7 }
            if (r0 == 0) goto L_0x088a
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.q     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = com.paytm.utility.b.n((android.content.Context) r25)     // Catch:{ Exception -> 0x08b7 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x08b7 }
        L_0x088a:
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x08b7 }
            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x08b7 }
            r0.sendCustomEventWithMap(r1, r2, r8)     // Catch:{ Exception -> 0x08b7 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r0 = r0.getStatus()     // Catch:{ Exception -> 0x08b7 }
            boolean r0 = r0.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x08b7 }
            if (r0 == 0) goto L_0x08e7
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75007b     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.F     // Catch:{ Exception -> 0x08b7 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.b.b.f75008c     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = "Screen Loaded"
            r2.put(r0, r1)     // Catch:{ Exception -> 0x08b7 }
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x08b7 }
            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x08b7 }
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.b.f75006a     // Catch:{ Exception -> 0x08b7 }
            r0.sendCustomEventWithMap(r1, r2, r8)     // Catch:{ Exception -> 0x08b7 }
            goto L_0x08e7
        L_0x08b7:
            r0 = move-exception
            goto L_0x08bc
        L_0x08b9:
            r0 = move-exception
            r3 = r20
        L_0x08bc:
            java.lang.String r0 = a((java.lang.Exception) r0)     // Catch:{ Exception -> 0x08c6 }
            com.paytm.utility.q.c(r0)     // Catch:{ Exception -> 0x08c6 }
            goto L_0x08e7
        L_0x08c4:
            r3 = r20
        L_0x08c6:
            com.paytm.utility.q.c(r18)     // Catch:{ Exception -> 0x08d9 }
            goto L_0x08e7
        L_0x08ca:
            r3 = r20
            goto L_0x08d9
        L_0x08cd:
            r15 = r6
            goto L_0x08ca
        L_0x08cf:
            r18 = r6
        L_0x08d1:
            r19 = r9
        L_0x08d3:
            r22 = r10
        L_0x08d5:
            r3 = r13
            r9 = r14
            r10 = r15
        L_0x08d8:
            r15 = 0
        L_0x08d9:
            com.paytm.utility.q.c(r18)
            goto L_0x08e7
        L_0x08dd:
            r18 = r6
            r19 = r9
            r22 = r10
            r3 = r13
            r9 = r14
            r10 = r15
            r15 = 0
        L_0x08e7:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q
            java.lang.String r0 = r0.getStatus()
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 == 0) goto L_0x0aa1
            java.lang.String r0 = r8.k
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0aa1
            java.lang.String r0 = r8.k
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x0aa1
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0978 }
            r0.<init>()     // Catch:{ Exception -> 0x0978 }
            java.lang.String r1 = "movie_name"
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r2 = r25.l()     // Catch:{ Exception -> 0x0978 }
            java.lang.String r2 = r2.getMovie()     // Catch:{ Exception -> 0x0978 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0978 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0978 }
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0978 }
            java.lang.String r5 = "yyyy-MM-dd"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0978 }
            java.util.Date r5 = new java.util.Date     // Catch:{ Exception -> 0x0978 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0978 }
            java.lang.String r1 = r4.format(r5)     // Catch:{ Exception -> 0x0978 }
            java.lang.String r2 = "date"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0978 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r8.q     // Catch:{ Exception -> 0x0978 }
            java.util.ArrayList r1 = r1.getOrderedCartList()     // Catch:{ Exception -> 0x0978 }
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x0978 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x0978 }
            java.util.Map r1 = r1.getRechargeConfiguration()     // Catch:{ Exception -> 0x0978 }
            if (r1 == 0) goto L_0x0950
            boolean r2 = r1.containsKey(r3)     // Catch:{ Exception -> 0x0978 }
            if (r2 == 0) goto L_0x0950
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x0978 }
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0978 }
            goto L_0x0952
        L_0x0950:
            r6 = r18
        L_0x0952:
            java.lang.String r1 = "number_of_tickets"
            r0.put(r1, r6)     // Catch:{ Exception -> 0x0978 }
            java.lang.String r1 = "transaction_id"
            java.lang.String r2 = r8.l     // Catch:{ Exception -> 0x0978 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0978 }
            java.lang.String r1 = "cost"
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r8.q     // Catch:{ Exception -> 0x0978 }
            double r2 = r2.getGrandTotal()     // Catch:{ Exception -> 0x0978 }
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x0978 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0978 }
            net.one97.paytm.o2o.movies.common.c.b r1 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x0978 }
            net.one97.paytm.o2o.movies.common.c.c r1 = r1.f75033b     // Catch:{ Exception -> 0x0978 }
            java.lang.String r2 = "paytm_ticket_booked"
            r1.sendCustomEventWithMap(r2, r0, r8)     // Catch:{ Exception -> 0x0978 }
            goto L_0x0979
        L_0x0978:
        L_0x0979:
            net.one97.paytm.o2o.movies.b.a r0 = net.one97.paytm.o2o.movies.b.a.INSTANCE
            java.util.Map r0 = r0.getCheckoutDataForPurchaseMap()
            net.one97.paytm.o2o.movies.b.a r1 = net.one97.paytm.o2o.movies.b.a.INSTANCE
            r1.setCheckoutDataForPurchaseMap(r15)
            if (r0 == 0) goto L_0x0a8f
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0a8f }
            r1.<init>()     // Catch:{ Exception -> 0x0a8f }
            r2 = r22
            java.lang.Object r3 = r0.get(r2)     // Catch:{ Exception -> 0x0a8f }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r3 = "day_date"
            java.lang.String r4 = "day_date"
            java.lang.Object r4 = r0.get(r4)     // Catch:{ Exception -> 0x0a8f }
            r1.put(r3, r4)     // Catch:{ Exception -> 0x0a8f }
            r3 = r19
            java.lang.Object r4 = r0.get(r3)     // Catch:{ Exception -> 0x0a8f }
            r1.put(r3, r4)     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r4 = "show_time"
            java.lang.String r5 = "show_time"
            java.lang.Object r5 = r0.get(r5)     // Catch:{ Exception -> 0x0a8f }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x0a8f }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x0a8f }
            r4.<init>()     // Catch:{ Exception -> 0x0a8f }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x0a8f }
            r5.<init>()     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r6 = "ecommerce"
            java.lang.Object r6 = r0.get(r6)     // Catch:{ Exception -> 0x0a8f }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r7 = "checkout"
            java.lang.Object r6 = r6.get(r7)     // Catch:{ Exception -> 0x0a8f }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r7 = "products"
            java.lang.Object r6 = r6.get(r7)     // Catch:{ Exception -> 0x0a8f }
            java.util.List r6 = (java.util.List) r6     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r7 = "products"
            r5.put(r7, r6)     // Catch:{ Exception -> 0x0a8f }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x0a8f }
            r6.<init>()     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r7 = "payment_method"
            net.one97.paytm.common.entity.shopping.CJROrderSummary r9 = r8.q     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r9 = r9.getPaymentMethodForGA()     // Catch:{ Exception -> 0x0a8f }
            r6.put(r7, r9)     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r7 = "shipping_city"
            java.lang.Object r9 = r0.get(r2)     // Catch:{ Exception -> 0x0a8f }
            r6.put(r7, r9)     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r7 = "billing_city"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ Exception -> 0x0a8f }
            r6.put(r7, r2)     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r2 = "order_type"
            java.lang.String r7 = "New"
            r6.put(r2, r7)     // Catch:{ Exception -> 0x0a8f }
            java.lang.String r2 = "user_type"
            r7 = r18
            r6.put(r2, r7)     // Catch:{ Exception -> 0x0a91 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0a91 }
            r2.<init>()     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r6 = "id"
            java.lang.String r9 = r8.l     // Catch:{ Exception -> 0x0a91 }
            r2.put(r6, r9)     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r6 = "option"
            java.lang.String r9 = "Proceed to pay"
            r2.put(r6, r9)     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r6 = "affiliation"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x0a91 }
            r2.put(r6, r0)     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r0 = "revenue"
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r8.q     // Catch:{ Exception -> 0x0a91 }
            double r9 = r3.getGrandTotal()     // Catch:{ Exception -> 0x0a91 }
            java.lang.Double r3 = java.lang.Double.valueOf(r9)     // Catch:{ Exception -> 0x0a91 }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r0 = "tax"
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r8.q     // Catch:{ Exception -> 0x0a91 }
            double r9 = r3.getmConFee()     // Catch:{ Exception -> 0x0a91 }
            java.lang.Double r3 = java.lang.Double.valueOf(r9)     // Catch:{ Exception -> 0x0a91 }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x0a91 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r8.q     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r0 = r0.getPromoCode()     // Catch:{ Exception -> 0x0a91 }
            if (r0 == 0) goto L_0x0a5d
            java.lang.String r0 = "coupon"
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r8.q     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r3 = r3.getPromoCode()     // Catch:{ Exception -> 0x0a91 }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x0a91 }
            goto L_0x0a62
        L_0x0a5d:
            java.lang.String r0 = "coupon"
            r2.put(r0, r7)     // Catch:{ Exception -> 0x0a91 }
        L_0x0a62:
            java.lang.String r0 = "actionField"
            r5.put(r0, r2)     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r0 = "currencyCode"
            java.lang.String r2 = "INR"
            r4.put(r0, r2)     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r0 = "purchase"
            r4.put(r0, r5)     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r0 = "ecommerce"
            r1.put(r0, r4)     // Catch:{ Exception -> 0x0a91 }
            net.one97.paytm.o2o.movies.b.a r0 = net.one97.paytm.o2o.movies.b.a.INSTANCE     // Catch:{ Exception -> 0x0a91 }
            r0.setCheckoutDataForPurchaseMap(r1)     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r0 = "vertical_name"
            java.lang.String r2 = "Entertainment - Movies"
            r1.put(r0, r2)     // Catch:{ Exception -> 0x0a91 }
            net.one97.paytm.o2o.movies.common.c.b r0 = net.one97.paytm.o2o.movies.common.c.b.f75032a     // Catch:{ Exception -> 0x0a91 }
            net.one97.paytm.o2o.movies.common.c.c r0 = r0.f75033b     // Catch:{ Exception -> 0x0a91 }
            java.lang.String r2 = "checkout-complete"
            r0.sendEnhancedEcommerceEvent(r2, r1, r8)     // Catch:{ Exception -> 0x0a91 }
            goto L_0x0a91
        L_0x0a8f:
            r7 = r18
        L_0x0a91:
            android.content.Context r0 = r25.getApplicationContext()
            com.paytm.b.a.a r0 = net.one97.paytm.o2o.movies.utils.x.a(r0)
            java.lang.String r1 = "movie_transaction_success"
            r2 = 1
            r3 = 0
            r0.a((java.lang.String) r1, (boolean) r2, (boolean) r3)
            goto L_0x0aa4
        L_0x0aa1:
            r7 = r18
            r3 = 0
        L_0x0aa4:
            boolean r0 = r8.e((boolean) r3)
            if (r0 != 0) goto L_0x0de0
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = new net.one97.paytm.common.entity.CJRSelectCityModel
            r0.<init>()
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r8.q
            if (r1 == 0) goto L_0x0b0a
            java.util.ArrayList r1 = r1.getOrderedCartList()
            if (r1 == 0) goto L_0x0b0a
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r8.q
            java.util.ArrayList r1 = r1.getOrderedCartList()
            int r1 = r1.size()
            if (r1 == 0) goto L_0x0b0a
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r8.q
            java.util.ArrayList r1 = r1.getOrderedCartList()
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            if (r1 == 0) goto L_0x0b0a
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r8.q
            java.util.ArrayList r1 = r1.getOrderedCartList()
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            java.lang.Object r1 = r1.getMetaDataResponse()
            if (r1 == 0) goto L_0x0b0a
            net.one97.paytm.o2o.movies.common.movies.orders.CJROrderSummaryMetadataResponseV2 r1 = r25.l()
            java.lang.String r2 = r1.getLatitude()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0af9
            java.lang.String r2 = r1.getLatitude()
            r0.setLatitude(r2)
        L_0x0af9:
            java.lang.String r2 = r1.getLongitude()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0b0a
            java.lang.String r1 = r1.getLongitude()
            r0.setLongitude(r1)
        L_0x0b0a:
            net.one97.paytm.o2o.movies.common.b.c.a()
            java.lang.String r1 = "freeMovieOrderSummaryBanner"
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.c.a(r1, r15)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0b1b
            java.lang.String r1 = "https://storefront.paytm.com/v2/h/movies-order-summary"
        L_0x0b1b:
            android.content.Context r2 = r25.getApplicationContext()
            java.lang.String r1 = com.paytm.utility.b.s(r2, r1)
            net.one97.paytm.o2o.movies.common.c.b r2 = net.one97.paytm.o2o.movies.common.c.b.f75032a
            net.one97.paytm.o2o.movies.common.c.c r2 = r2.f75033b
            android.app.Application r3 = r25.getApplication()
            java.lang.String r0 = r2.createRequestBodyForV2(r3, r7, r7, r0)
            boolean r2 = com.paytm.utility.b.c((android.content.Context) r25)
            java.lang.String r3 = "paytm"
            java.lang.String r4 = "ClientId"
            if (r2 == 0) goto L_0x0b7e
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r2.put(r4, r3)
            net.one97.paytm.o2o.movies.utils.c r5 = new net.one97.paytm.o2o.movies.utils.c
            r5.<init>()
            r5.f42877a = r8
            com.paytm.network.a$c r6 = com.paytm.network.a.c.MOVIES
            r5.f42878b = r6
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.POST
            r5.f42879c = r6
            r5.f42880d = r1
            r5.f42881e = r15
            r5.f42882f = r2
            r5.f42883g = r15
            r5.f42884h = r0
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2 r0 = new net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2
            r0.<init>()
            r5.f42885i = r0
            r5.j = r8
            com.paytm.network.a$b r0 = com.paytm.network.a.b.USER_FACING
            r5.n = r0
            java.lang.String r0 = "movies"
            r5.o = r0
            java.lang.String r0 = "AJRMovieOrderSummary"
            org.json.JSONObject r0 = net.one97.paytm.o2o.movies.utils.n.h(r0)
            r5.t = r0
            com.paytm.network.a r0 = r5.l()
            r1 = 0
            r0.f42859c = r1
            r0.a()
            goto L_0x0b88
        L_0x0b7e:
            r1 = 0
            int r0 = net.one97.paytm.common.assets.R.string.no_internet
            android.widget.Toast r0 = android.widget.Toast.makeText(r8, r0, r1)
            r0.show()
        L_0x0b88:
            java.lang.String r0 = net.one97.paytm.o2o.movies.common.d.b((android.content.Context) r25)
            net.one97.paytm.o2o.movies.common.b.c.a()
            java.lang.String r1 = net.one97.paytm.o2o.movies.common.b.c.d()
            java.lang.String r2 = "city"
            java.lang.String r0 = net.one97.paytm.o2o.movies.utils.n.a((java.lang.String) r2, (java.lang.String) r0, (java.lang.String) r1)
            java.lang.String r0 = com.paytm.utility.b.s(r8, r0)
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r25)
            if (r1 == 0) goto L_0x0be8
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.put(r4, r3)
            net.one97.paytm.o2o.movies.utils.c r2 = new net.one97.paytm.o2o.movies.utils.c
            r2.<init>()
            r2.f42877a = r8
            com.paytm.network.a$c r3 = com.paytm.network.a.c.MOVIES
            r2.f42878b = r3
            com.paytm.network.a$a r3 = com.paytm.network.a.C0715a.GET
            r2.f42879c = r3
            r2.f42880d = r0
            r2.f42881e = r15
            r2.f42882f = r1
            r2.f42883g = r15
            r2.f42884h = r15
            net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies r0 = new net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies
            r0.<init>()
            r2.f42885i = r0
            r2.j = r8
            com.paytm.network.a$b r0 = com.paytm.network.a.b.USER_FACING
            r2.n = r0
            java.lang.String r0 = "movies"
            r2.o = r0
            java.lang.String r0 = "AJRMovieOrderSummary"
            org.json.JSONObject r0 = net.one97.paytm.o2o.movies.utils.n.h(r0)
            r2.t = r0
            com.paytm.network.a r0 = r2.l()
            r1 = 0
            r0.f42859c = r1
            r0.a()
            return
        L_0x0be8:
            r1 = 0
            int r0 = net.one97.paytm.common.assets.R.string.no_internet
            android.widget.Toast r0 = android.widget.Toast.makeText(r8, r0, r1)
            r0.show()
            return
        L_0x0bf3:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse
            r2 = 2
            if (r1 == 0) goto L_0x0c17
            net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse r0 = (net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse) r0
            r8.a((net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse) r0)
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r
            if (r0 == 0) goto L_0x0c16
            int r0 = r0.size()
            if (r0 <= r2) goto L_0x0c16
            net.one97.paytm.o2o.movies.adapter.ag r0 = r8.s
            if (r0 == 0) goto L_0x0c16
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r
            r1 = 1
            r0.remove(r1)
            net.one97.paytm.o2o.movies.adapter.ag r0 = r8.s
            r0.notifyDataSetChanged()
        L_0x0c16:
            return
        L_0x0c17:
            boolean r3 = r0 instanceof net.one97.paytm.orders.datamodel.CJRMovieCancelProtectOrderItem
            if (r3 == 0) goto L_0x0c6d
            net.one97.paytm.orders.datamodel.CJRMovieCancelProtectOrderItem r0 = (net.one97.paytm.orders.datamodel.CJRMovieCancelProtectOrderItem) r0
            if (r0 == 0) goto L_0x0c6c
            java.lang.String r0 = r0.getMessage()
            boolean r1 = r25.isFinishing()
            if (r1 != 0) goto L_0x0c6c
            r8.C = r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.res.Resources r2 = r25.getResources()
            int r3 = net.one97.paytm.o2o.movies.R.string.cancel_ticket
            java.lang.String r2 = r2.getString(r3)
            r1.append(r2)
            java.lang.String r2 = "(s)"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            r2.<init>(r8)
            android.app.AlertDialog$Builder r1 = r2.setTitle(r1)
            android.app.AlertDialog$Builder r0 = r1.setMessage(r0)
            r1 = 0
            r0.setCancelable(r1)
            android.content.res.Resources r0 = r25.getResources()
            int r1 = net.one97.paytm.o2o.movies.R.string.ok
            java.lang.String r0 = r0.getString(r1)
            net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary$3 r1 = new net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary$3
            r1.<init>()
            r2.setPositiveButton(r0, r1)
            r2.show()
        L_0x0c6c:
            return
        L_0x0c6d:
            boolean r3 = r0 instanceof net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies
            if (r3 == 0) goto L_0x0cd0
            net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies r0 = (net.one97.paytm.common.entity.movies.search.CJRUpcomingMovies) r0
            net.one97.paytm.orders.datamodel.CJRMoviesUpcomingItem r1 = new net.one97.paytm.orders.datamodel.CJRMoviesUpcomingItem
            r1.<init>()
            r1.setUpcomingMovies(r0)
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r0 = new net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a
            r0.<init>()
            net.one97.paytm.orders.a.a r3 = net.one97.paytm.orders.a.a.LAYOUT_MOVIE_UPCOMING_MOVIE
            java.lang.String r3 = r3.getName()
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r0 = r0.a((java.lang.String) r3)
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r3 = r0.f75156a
            r3.setUpcomingMoviesItem(r1)
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r0 = r0.f75156a
            r0.setUpcomingMoviesItem(r1)
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r1 = r8.r
            if (r1 == 0) goto L_0x0ccf
            int r1 = r1.size()
            if (r1 < r2) goto L_0x0ccf
            net.one97.paytm.o2o.movies.adapter.ag r1 = r8.s
            if (r1 == 0) goto L_0x0ccf
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r1 = r8.r
            int r2 = r8.J
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r1 = (net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem) r1
            net.one97.paytm.orders.datamodel.CJRMovieSummaryCatalogV2Item r1 = r1.getmSummaryCatalogItem()
            if (r1 != 0) goto L_0x0cc1
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r1 = r8.r
            int r2 = r8.J
            r1.add(r2, r0)
            net.one97.paytm.o2o.movies.adapter.ag r0 = r8.s
            int r1 = r8.J
            r0.notifyItemInserted(r1)
            return
        L_0x0cc1:
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r1 = r8.r
            int r2 = r8.K
            r1.add(r2, r0)
            net.one97.paytm.o2o.movies.adapter.ag r0 = r8.s
            int r1 = r8.K
            r0.notifyItemInserted(r1)
        L_0x0ccf:
            return
        L_0x0cd0:
            boolean r3 = r0 instanceof net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2
            if (r3 == 0) goto L_0x0d80
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2 r0 = (net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2) r0
            if (r0 == 0) goto L_0x0d7f
            java.util.List r1 = r0.getPage()
            if (r1 == 0) goto L_0x0d7f
            java.util.List r1 = r0.getPage()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0d7f
            java.util.List r1 = r0.getPage()
            r3 = 0
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Page r1 = (net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Page) r1
            java.util.List r1 = r1.getViews()
            if (r1 == 0) goto L_0x0d7f
            java.util.List r1 = r0.getPage()
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Page r1 = (net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Page) r1
            java.util.List r1 = r1.getViews()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0d7f
            java.util.List r1 = r0.getPage()
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Page r1 = (net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Page) r1
            java.util.List r1 = r1.getViews()
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2View r1 = (net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2View) r1
            java.util.List r1 = r1.getItems()
            if (r1 == 0) goto L_0x0d7f
            java.util.List r1 = r0.getPage()
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Page r1 = (net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2Page) r1
            java.util.List r1 = r1.getViews()
            java.lang.Object r1 = r1.get(r3)
            net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2View r1 = (net.one97.paytm.common.entity.movies.search.CJRMovieSummaryCatalogV2View) r1
            java.util.List r1 = r1.getItems()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0d7f
            net.one97.paytm.orders.datamodel.CJRMovieSummaryCatalogV2Item r1 = new net.one97.paytm.orders.datamodel.CJRMovieSummaryCatalogV2Item
            r1.<init>()
            r1.setMovieSummaryCatalog(r0)
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r0 = new net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a
            r0.<init>()
            net.one97.paytm.orders.a.a r3 = net.one97.paytm.orders.a.a.LAYOUT_MOVIE_SUMMARY_CATALOG
            java.lang.String r3 = r3.getName()
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem$a r0 = r0.a((java.lang.String) r3)
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r3 = r0.f75156a
            r3.setmSummaryCatalogV2Item(r1)
            net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem r0 = r0.f75156a
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r1 = r8.r
            if (r1 == 0) goto L_0x0d7f
            int r1 = r1.size()
            if (r1 < r2) goto L_0x0d7f
            net.one97.paytm.o2o.movies.adapter.ag r1 = r8.s
            if (r1 == 0) goto L_0x0d7f
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r1 = r8.r
            int r2 = r8.J
            r1.add(r2, r0)
            net.one97.paytm.o2o.movies.adapter.ag r0 = r8.s
            int r1 = r8.J
            r0.notifyItemInserted(r1)
        L_0x0d7f:
            return
        L_0x0d80:
            if (r1 == 0) goto L_0x0da1
            net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse r0 = (net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse) r0
            r8.a((net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse) r0)
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r
            if (r0 == 0) goto L_0x0da0
            int r0 = r0.size()
            if (r0 <= r2) goto L_0x0da0
            net.one97.paytm.o2o.movies.adapter.ag r0 = r8.s
            if (r0 == 0) goto L_0x0da0
            java.util.ArrayList<net.one97.paytm.o2o.movies.common.movies.orders.datamodel.CJRSummaryItem> r0 = r8.r
            r1 = 1
            r0.remove(r1)
            net.one97.paytm.o2o.movies.adapter.ag r0 = r8.s
            r0.notifyDataSetChanged()
        L_0x0da0:
            return
        L_0x0da1:
            boolean r1 = r0 instanceof net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeatItems
            if (r1 == 0) goto L_0x0de0
            r1 = 0
            r8.b((boolean) r1)
            net.one97.paytm.o2o.movies.utils.g r1 = net.one97.paytm.o2o.movies.utils.g.a()
            r1.d()
            net.one97.paytm.o2o.movies.utils.g r1 = net.one97.paytm.o2o.movies.utils.g.a()
            net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeatItems r0 = (net.one97.paytm.o2o.movies.common.movies.booking.CJRSetSeatItems) r0
            java.util.ArrayList r0 = r0.getFnbAndVouchers()
            r1.f75924a = r0
            net.one97.paytm.o2o.movies.utils.g r0 = net.one97.paytm.o2o.movies.utils.g.a()
            r0.b()
            r1 = 1
            r8.P = r1
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<net.one97.paytm.o2o.movies.activity.AJRFnBDialog> r1 = net.one97.paytm.o2o.movies.activity.AJRFnBDialog.class
            r0.<init>(r8, r1)
            java.lang.String r1 = "showSkip"
            r2 = 0
            r0.putExtra(r1, r2)
            java.lang.String r1 = "from"
            java.lang.String r2 = "order_summary"
            r0.putExtra(r1, r2)
            r1 = 2343(0x927, float:3.283E-42)
            r8.startActivityForResult(r0, r1)
        L_0x0de0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, final NetworkCustomError networkCustomError) {
        if (isFinishing() || (iJRPaytmDataModel instanceof CJRMovieSummaryCatalogV2) || (iJRPaytmDataModel instanceof CJRNpsTrackingResponse)) {
            return;
        }
        if (iJRPaytmDataModel instanceof CJROrderSummary) {
            CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
            cJRHomePageItem.setUrlType(CLPConstants.CONFIG_KEY_MY_ORDERS);
            cJRHomePageItem.setUrl("paytmmp://my_orders?tab=4");
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.loadPage(this, CLPConstants.CONFIG_KEY_MY_ORDERS, cJRHomePageItem, "", 0, (ArrayList<? extends CJRItem>) null, false, "");
            finish();
            return;
        }
        b(false);
        runOnUiThread(new Runnable(networkCustomError) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ NetworkCustomError f74040a;

            {
                this.f74040a = r2;
            }

            public final void run() {
                if (this.f74040a == null) {
                    return;
                }
                if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.handleError(AJRMovieOrderSummary.this, networkCustomError, net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.getPaytmActivityMap().get("mainActivity").getName(), (Bundle) null, false);
                } else if (this.f74040a.getMessage() != null && !net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.reportError(AJRMovieOrderSummary.this, this.f74040a, "error.movies@paytm.com")) {
                    if (this.f74040a.getMessage() != null && this.f74040a.getMessage().equalsIgnoreCase("parsing_error")) {
                        com.paytm.utility.b.d((Context) AJRMovieOrderSummary.this, this.f74040a.getUrl(), String.valueOf(this.f74040a.getStatusCode()));
                    }
                    if (this.f74040a.getMessage() == null || this.f74040a.getUrl() == null || !this.f74040a.getUrl().contains("cancel-ticket")) {
                        AJRMovieOrderSummary aJRMovieOrderSummary = AJRMovieOrderSummary.this;
                        com.paytm.utility.b.b((Context) aJRMovieOrderSummary, aJRMovieOrderSummary.getResources().getString(R.string.network_error_heading), AJRMovieOrderSummary.this.getResources().getString(R.string.network_error_message) + " " + this.f74040a.getUrl());
                        return;
                    }
                    AJRMovieOrderSummary aJRMovieOrderSummary2 = AJRMovieOrderSummary.this;
                    com.paytm.utility.b.b((Context) aJRMovieOrderSummary2, aJRMovieOrderSummary2.getResources().getString(R.string.error_dialog_title), "Unable to process your cancellation request currently.Please try after some time.");
                }
            }
        });
    }

    public final void a(float f2) {
        try {
            com.paytm.utility.b.x(this, "is_app_rated");
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendNewCustomGTMEvents(this, "app_rating", String.valueOf(Math.round(f2)), "movies", (String) null, (String) null, (String) null, "app_rating");
            if (f2 < 5.0f) {
                com.paytm.utility.b.a((Context) this, "app_rating_less_than_5_star_timestamp", System.currentTimeMillis());
                com.paytm.utility.b.a((Context) this, "app_rating_5_star_timestamp", 0);
                View view = this.L.getView();
                if (view != null) {
                    ((TextView) view.findViewById(net.one97.paytm.common.widgets.R.id.tv_msg)).setText(getString(net.one97.paytm.common.widgets.R.string.feedback_thanks_msg));
                    view.findViewById(net.one97.paytm.common.widgets.R.id.tv_sub_msg).setVisibility(8);
                    view.findViewById(net.one97.paytm.common.widgets.R.id.iv_close_icon).setVisibility(8);
                    ((AppCompatRatingBar) view.findViewById(net.one97.paytm.common.widgets.R.id.ratingBar)).setRating(f2);
                    Handler handler = new Handler();
                    $$Lambda$AJRMovieOrderSummary$4JFlVU0mVJVJujjGp8E25TErYE r0 = new Runnable() {
                        public final void run() {
                            AJRMovieOrderSummary.this.p();
                        }
                    };
                    net.one97.paytm.o2o.movies.common.b.c.a();
                    handler.postDelayed(r0, Long.parseLong(net.one97.paytm.o2o.movies.common.b.c.a("app_rating_thank_you_expire_time", Constants.RESULT_STATUS_SUCCESS)));
                }
            } else {
                com.paytm.utility.b.a((Context) this, "app_rating_5_star_timestamp", System.currentTimeMillis());
                com.paytm.utility.b.a((Context) this, "app_rating_less_than_5_star_timestamp", 0);
                this.L.dismiss();
                com.paytm.utility.b.ai(this);
            }
            com.paytm.utility.b.a((Context) this, "app_rating_not_now_timestamp", 0);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p() {
        try {
            this.L.dismiss();
        } catch (Exception unused) {
        }
    }

    public final void a() {
        try {
            com.paytm.utility.b.a((Context) this, "app_rating_not_now_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a((Context) this, "app_rating_5_star_timestamp", 0);
            com.paytm.utility.b.a((Context) this, "app_rating_less_than_5_star_timestamp", 0);
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendNewCustomGTMEvents(this, "app_rating", "cross_button_clicked", "movies", (String) null, (String) null, (String) null, "app_rating");
            if (this.L.isAdded() && this.L.isVisible()) {
                this.L.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 6) {
            if (i3 == -1) {
                c();
            } else {
                finish();
            }
        } else if (i2 == 5757 && i3 == -1) {
            b();
        } else if (i2 != 2343) {
        } else {
            if (i3 == -1) {
                g.a().c();
                CJROrderSummaryMetadataResponseV2 a2 = net.one97.paytm.o2o.movies.b.c.a(this.q.getOrderedCartList().get(0));
                if (a2 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("postOrderFood", a2);
                    bundle.putString("parentOrderId", this.q.getId());
                    Intent intent2 = new Intent(this, AJRPostOrderFoodAndBeverages.class);
                    intent2.putExtras(bundle);
                    this.Q.postDelayed(new Runnable(intent2) {
                        private final /* synthetic */ Intent f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            AJRMovieOrderSummary.this.a(this.f$1);
                        }
                    }, 300);
                    return;
                }
                g.a().d();
                return;
            }
            g.a().d();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Intent intent) {
        startActivity(intent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.P) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public final void a(CJROrderSummaryMetadataResponseV2 cJROrderSummaryMetadataResponseV2) {
        if (com.paytm.utility.b.c((Context) this)) {
            this.P = false;
            b(true);
            StringBuilder sb = new StringBuilder();
            net.one97.paytm.o2o.movies.common.b.c.a();
            sb.append(net.one97.paytm.o2o.movies.common.b.c.a("postOrderFoodAndBevaragesUrl", (String) null));
            sb.append(cJROrderSummaryMetadataResponseV2.getCinemaId());
            sb.append("&provider_id=");
            sb.append(cJROrderSummaryMetadataResponseV2.getProviderId());
            sb.append("&stype=");
            sb.append(cJROrderSummaryMetadataResponseV2.getStype());
            sb.append("&post_fb=1");
            String sb2 = sb.toString();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ClientId", "paytm");
            String showTime = cJROrderSummaryMetadataResponseV2.getShowTime();
            if (!TextUtils.isEmpty(showTime)) {
                sb2 = sb2 + "&show_datetime=" + showTime;
            }
            if (URLUtil.isValidUrl(sb2)) {
                String s2 = com.paytm.utility.b.s(this, sb2);
                net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
                cVar.f42877a = this;
                cVar.f42878b = a.c.MOVIES;
                cVar.f42879c = a.C0715a.GET;
                cVar.f42880d = s2;
                cVar.f42882f = hashMap;
                cVar.f42885i = new CJRSetSeatItems();
                cVar.j = this;
                cVar.n = a.b.USER_FACING;
                cVar.o = "movies";
                cVar.t = n.h("FJRPostOrderFoodAndBeverages");
                com.paytm.network.a l2 = cVar.l();
                l2.f42859c = false;
                l2.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SanitizedResponseModel sanitizedResponseModel) {
        if (sanitizedResponseModel != null) {
            try {
                SFWidget widget = sanitizedResponseModel.getSfWidgets().get(104).getWidget(this, (IGAHandlerListener) null);
                if (widget instanceof IStaticWidget) {
                    FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
                    frameLayout.setVisibility(0);
                    frameLayout.addView(((IStaticWidget) widget).getView());
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.onTransactionComplete(widget, this, this.l, net.one97.paytm.utils.b.a.MOVIE_TICKETS);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z2, String str3) {
        IJRDataModel iJRDataModel2 = iJRDataModel;
        if (iJRDataModel2 instanceof CJRMovieSummaryCatalogV2Items) {
            CJRMovieSummaryCatalogV2Items cJRMovieSummaryCatalogV2Items = (CJRMovieSummaryCatalogV2Items) iJRDataModel2;
            if (!(cJRMovieSummaryCatalogV2Items == null || cJRMovieSummaryCatalogV2Items.getURL() == null || TextUtils.isEmpty(cJRMovieSummaryCatalogV2Items.getURL()))) {
                String url = cJRMovieSummaryCatalogV2Items.getURL();
                if (!TextUtils.isEmpty(url) && !url.equalsIgnoreCase("nolink")) {
                    net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.loadPage(this, str, cJRMovieSummaryCatalogV2Items, str2, i2, arrayList, z2, str3);
                } else {
                    return;
                }
            }
            try {
                CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
                cJRHomePageItem.setName("/movies-order-summary");
                net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendMoviePromotionImpressionClick(cJRHomePageItem, this, i2, net.one97.paytm.o2o.movies.common.b.b.U, ((CJRMovieSummaryCatalogV2Items) iJRDataModel2).getName());
            } catch (Exception unused) {
            }
        }
    }
}
