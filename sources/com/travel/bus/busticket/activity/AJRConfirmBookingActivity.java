package com.travel.bus.busticket.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.RoboTextView;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.a.ai;
import com.travel.bus.busticket.a.m;
import com.travel.bus.busticket.f.c;
import com.travel.bus.busticket.fragment.e;
import com.travel.bus.busticket.g.f;
import com.travel.bus.busticket.g.g;
import com.travel.bus.busticket.i.h;
import com.travel.bus.busticket.i.o;
import com.travel.bus.busticket.i.p;
import com.travel.bus.pojo.busticket.CJRBlockOneResponse;
import com.travel.bus.pojo.busticket.CJRBusInsuranceItem;
import com.travel.bus.pojo.busticket.CJRBusInsurancePlans;
import com.travel.bus.pojo.busticket.CJRBusOffers;
import com.travel.bus.pojo.busticket.CJRBusPGTokenList;
import com.travel.bus.pojo.busticket.CJRBusPayment;
import com.travel.bus.pojo.busticket.CJRBusPaytmCash;
import com.travel.bus.pojo.busticket.CJRBusRechargeCart;
import com.travel.bus.pojo.busticket.CJRBusReviewCancellationPolicy;
import com.travel.bus.pojo.busticket.CJRBusSearchInput;
import com.travel.bus.pojo.busticket.CJRBusSearchItem;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import com.travel.bus.pojo.busticket.CJRLocation;
import com.travel.bus.pojo.busticket.CJRNewErrorFormat;
import com.travel.bus.pojo.busticket.CJRPassengerDetails;
import com.travel.bus.pojo.busticket.TripBusDetail;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import com.travel.bus.pojo.deferredcheckout.CJRBusVerifyDeferred;
import com.travel.utils.q;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJROfferCode;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.common.widgets.CustomEditText;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchOptionsRequest;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class AJRConfirmBookingActivity extends PaytmActivity implements View.OnClickListener, Response.Listener<IJRDataModel>, b, m.a, c, f.a {

    /* renamed from: i  reason: collision with root package name */
    static final /* synthetic */ boolean f21925i = (!AJRConfirmBookingActivity.class.desiredAssertionStatus());
    private boolean A = false;
    private boolean B = false;
    /* access modifiers changed from: private */
    public boolean C = false;
    private CJRBusInsuranceItem D;
    private long E;
    /* access modifiers changed from: private */
    public View F;
    /* access modifiers changed from: private */
    public CJRBusOffers G;
    private CJRCart H;
    /* access modifiers changed from: private */
    public String I;
    private RoboTextView J;
    /* access modifiers changed from: private */
    public ArrayList<CJROfferCode> K;
    private View L;
    private boolean M;
    /* access modifiers changed from: private */
    public CJRBlockOneResponse N;
    /* access modifiers changed from: private */
    public CountDownTimer O;
    /* access modifiers changed from: private */
    public String P;
    /* access modifiers changed from: private */
    public long Q;
    /* access modifiers changed from: private */
    public long R;
    private String S;
    private TextView T;
    private TextView U;
    private TextView V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a  reason: collision with root package name */
    protected ProgressDialog f21926a;
    /* access modifiers changed from: private */
    public boolean aA = false;
    /* access modifiers changed from: private */
    public boolean aB = false;
    private CJRBusRechargeCart aC;
    private LinearLayout aD;
    private RoboTextView aE;
    private RoboTextView aF;
    private RoboTextView aG;
    private RecyclerView aH;
    private ConstraintLayout aI;
    private Toolbar aJ;
    private ConstraintLayout aK;
    private ImageView aL;
    private double aM = 0.0d;
    private double aN = 0.0d;
    private RoboTextView aO;
    private LinearLayout aP;
    private LinearLayout aQ;
    /* access modifiers changed from: private */
    public String aR = "";
    /* access modifiers changed from: private */
    public String aS = "";
    private TextView aa;
    private TextView ab;
    private TextView ac;
    private TextView ad;
    private TextView ae;
    private TextView af;
    private ConstraintLayout ag;
    /* access modifiers changed from: private */
    public CheckBox ah;
    private RoboTextView ai;
    private RoboTextView aj;
    private RoboTextView ak;
    /* access modifiers changed from: private */
    public f al;
    private TripBusDetail am;
    /* access modifiers changed from: private */
    public CJRBusInsuranceItem an;
    /* access modifiers changed from: private */
    public String ao;
    /* access modifiers changed from: private */
    public String ap;
    private RoboTextView aq;
    /* access modifiers changed from: private */
    public View ar;
    private ConstraintLayout as;
    private CheckBox at;
    private CJRBusPaytmCash au;
    private boolean av = false;
    private boolean aw;
    /* access modifiers changed from: private */
    public CJRBusReviewCancellationPolicy ax;
    /* access modifiers changed from: private */
    public CJRBusInsurancePlans ay;
    private boolean az = false;

    /* renamed from: b  reason: collision with root package name */
    protected AppCompatImageView f21927b;

    /* renamed from: c  reason: collision with root package name */
    RecyclerView.LayoutManager f21928c;

    /* renamed from: d  reason: collision with root package name */
    ai f21929d;

    /* renamed from: e  reason: collision with root package name */
    LinearLayoutManager f21930e;

    /* renamed from: f  reason: collision with root package name */
    RelativeLayout f21931f;

    /* renamed from: g  reason: collision with root package name */
    RoboTextView f21932g;

    /* renamed from: h  reason: collision with root package name */
    e f21933h;
    private final String j = "vertical_name";
    private RoboTextView k;
    private RoboTextView l;
    private RoboTextView m;
    private RoboTextView n;
    private CJRBusSearchInput o;
    private ArrayList<TripBusDetailsItem> p;
    private CJRLocation q;
    private CJRLocation r;
    private CJRBusSearchItem s;
    /* access modifiers changed from: private */
    public ArrayList<CJRPassengerDetails> t;
    private CustomEditText u;
    private LinearLayout v;
    private HashMap<String, CJRBusSearchOperatorTagInfo> w = null;
    private Button x;
    /* access modifiers changed from: private */
    public String y;
    private AlertDialog z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(DialogInterface dialogInterface, int i2) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(DialogInterface dialogInterface, int i2) {
    }

    public /* bridge */ /* synthetic */ void onResponse(Object obj) {
    }

    public void attachBaseContext(Context context) {
        q.a(context);
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        q.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.util.Set} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x07fe  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0805  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x080c  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0812  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0839  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0844  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0859  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x08d6  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x08dd  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x08e4  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x08ea  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0911  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x091c  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0921  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0976  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0a9a  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0b4f  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0b6b  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0b90  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0bf4 A[Catch:{ Exception -> 0x0cd7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0c1b A[Catch:{ Exception -> 0x0cd7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x0c94 A[Catch:{ Exception -> 0x0cd7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r28) {
        /*
            r27 = this;
            r1 = r27
            java.lang.String r2 = "BusTicket"
            super.onCreate(r28)
            int r0 = com.travel.bus.R.layout.bus_review_iternety_activity
            r1.setContentView((int) r0)
            int r0 = com.travel.bus.R.id.toolbar
            android.view.View r0 = r1.findViewById(r0)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r1.aJ = r0
            androidx.appcompat.widget.Toolbar r0 = r1.aJ
            r1.setSupportActionBar(r0)
            androidx.appcompat.app.ActionBar r0 = r27.getSupportActionBar()
            r3 = 0
            r0.c((boolean) r3)
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            r5 = 19
            if (r0 < r5) goto L_0x0063
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x0063
            android.view.Window r0 = r27.getWindow()
            r0.setStatusBarColor(r3)
            android.view.Window r0 = r27.getWindow()
            android.view.View r0 = r0.getDecorView()
            r5 = 1280(0x500, float:1.794E-42)
            r0.setSystemUiVisibility(r5)
            androidx.appcompat.widget.Toolbar r0 = r1.aJ
            android.content.res.Resources r5 = r27.getResources()
            java.lang.String r6 = "status_bar_height"
            java.lang.String r7 = "dimen"
            java.lang.String r8 = "android"
            int r5 = r5.getIdentifier(r6, r7, r8)
            if (r5 <= 0) goto L_0x005f
            android.content.res.Resources r6 = r27.getResources()
            int r5 = r6.getDimensionPixelSize(r5)
            goto L_0x0060
        L_0x005f:
            r5 = 0
        L_0x0060:
            r0.setPadding(r3, r5, r3, r3)
        L_0x0063:
            int r0 = com.travel.bus.R.id.back_arrow
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$t28k1BRZRq9eMEcgAnVKqoDAEi0 r5 = new com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$t28k1BRZRq9eMEcgAnVKqoDAEi0
            r5.<init>()
            r0.setOnClickListener(r5)
            com.travel.bus.busticket.g.f r0 = new com.travel.bus.busticket.g.f
            r0.<init>(r1, r1)
            r1.al = r0
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x0087 }
            com.travel.g.a r0 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x0087 }
            java.lang.String r5 = "/bus-tickets/confirm-booking"
            r0.a((java.lang.String) r5, (java.lang.String) r2, (android.content.Context) r1)     // Catch:{ Exception -> 0x0087 }
            goto L_0x0093
        L_0x0087:
            r0 = move-exception
            boolean r5 = com.paytm.utility.b.v
            if (r5 == 0) goto L_0x0093
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x0093:
            android.content.Intent r0 = r27.getIntent()
            r5 = 0
            if (r0 == 0) goto L_0x015a
            java.lang.String r7 = "intent_extra_bus_search_input"
            java.io.Serializable r7 = r0.getSerializableExtra(r7)
            com.travel.bus.pojo.busticket.CJRBusSearchInput r7 = (com.travel.bus.pojo.busticket.CJRBusSearchInput) r7
            r1.o = r7
            java.lang.String r7 = "intent_extra_bus_search_result_item"
            java.io.Serializable r7 = r0.getSerializableExtra(r7)
            com.travel.bus.pojo.busticket.CJRBusSearchItem r7 = (com.travel.bus.pojo.busticket.CJRBusSearchItem) r7
            r1.s = r7
            java.lang.String r7 = "intent_extra_selected_seats"
            java.io.Serializable r7 = r0.getSerializableExtra(r7)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.p = r7
            java.lang.String r7 = "intent_extra_selected_boarding_point"
            java.io.Serializable r7 = r0.getSerializableExtra(r7)
            com.travel.bus.pojo.busticket.CJRLocation r7 = (com.travel.bus.pojo.busticket.CJRLocation) r7
            r1.q = r7
            java.lang.String r7 = "intent_extra_selected_dropping_point"
            java.io.Serializable r7 = r0.getSerializableExtra(r7)
            com.travel.bus.pojo.busticket.CJRLocation r7 = (com.travel.bus.pojo.busticket.CJRLocation) r7
            r1.r = r7
            java.lang.String r7 = "intent_extra_passenger_details"
            java.io.Serializable r7 = r0.getSerializableExtra(r7)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.t = r7
            java.lang.String r7 = "intent_block_ticket_response_data"
            java.io.Serializable r7 = r0.getSerializableExtra(r7)
            com.travel.bus.pojo.busticket.CJRBlockOneResponse r7 = (com.travel.bus.pojo.busticket.CJRBlockOneResponse) r7
            r1.N = r7
            java.lang.String r7 = "intent_extra_server_time"
            long r7 = r0.getLongExtra(r7, r5)
            r1.E = r7
            java.lang.String r7 = "intent_extra_bus_trip_detail"
            java.io.Serializable r7 = r0.getSerializableExtra(r7)
            com.travel.bus.pojo.busticket.TripBusDetail r7 = (com.travel.bus.pojo.busticket.TripBusDetail) r7
            r1.am = r7
            com.travel.bus.pojo.busticket.CJRBlockOneResponse r7 = r1.N
            if (r7 == 0) goto L_0x010f
            com.travel.bus.pojo.busticket.CJRBlockOneModel r7 = r7.getBlockResponse()
            if (r7 == 0) goto L_0x010f
            com.travel.bus.pojo.busticket.CJRBlockOneResponse r7 = r1.N
            com.travel.bus.pojo.busticket.CJRBlockOneModel r7 = r7.getBlockResponse()
            com.travel.bus.pojo.busticket.CJRBusOnwardLeg r7 = r7.getOnwardLeg()
            int r7 = r7.getBlockExpiryTime()
            r1.a((int) r7)
            goto L_0x0114
        L_0x010f:
            r7 = 600(0x258, float:8.41E-43)
            r1.a((int) r7)
        L_0x0114:
            boolean r7 = r1.C
            if (r7 == 0) goto L_0x0122
            java.lang.String r7 = "intent_extra_bus_insurance_plan"
            java.io.Serializable r7 = r0.getSerializableExtra(r7)
            com.travel.bus.pojo.busticket.CJRBusInsuranceItem r7 = (com.travel.bus.pojo.busticket.CJRBusInsuranceItem) r7
            r1.D = r7
        L_0x0122:
            java.lang.String r7 = "requestid"
            java.lang.String r7 = r0.getStringExtra(r7)
            r1.I = r7
            java.lang.String r7 = "intent_extra_bus_search_load_data"
            boolean r8 = r0.hasExtra(r7)
            if (r8 == 0) goto L_0x013a
            java.io.Serializable r7 = r0.getSerializableExtra(r7)
            java.util.HashMap r7 = (java.util.HashMap) r7
            r1.w = r7
        L_0x013a:
            java.lang.String r7 = "EMAIL"
            java.lang.String r7 = r0.getStringExtra(r7)
            r1.ao = r7
            java.lang.String r7 = "MOBILE_NO"
            java.lang.String r0 = r0.getStringExtra(r7)
            r1.ap = r0
            com.travel.bus.pojo.busticket.CJRBlockOneResponse r0 = r1.N
            com.travel.bus.pojo.busticket.CJRBlockOneModel r0 = r0.getBlockResponse()
            double r7 = r0.getGrandTotal()
            r1.aN = r7
            double r7 = r1.aN
            r1.aM = r7
        L_0x015a:
            int r0 = com.travel.bus.R.id.lyt_offers
            android.view.View r0 = r1.findViewById(r0)
            r1.F = r0
            int r0 = com.travel.bus.R.id.lyt_offer
            android.view.View r0 = r1.findViewById(r0)
            r1.ar = r0
            int r0 = com.travel.bus.R.id.lyt_promo_applied
            android.view.View r0 = r1.findViewById(r0)
            r1.L = r0
            android.view.View r0 = r1.L
            r7 = 8
            r0.setVisibility(r7)
            android.view.View r0 = r1.L
            com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$OIw4nilik3oJi1UscfC1chnnVVY r8 = new com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$OIw4nilik3oJi1UscfC1chnnVVY
            r8.<init>()
            r0.setOnClickListener(r8)
            int r0 = com.travel.bus.R.string.train_countdown_timer_count
            java.lang.String r0 = r1.getString(r0)
            r1.P = r0
            int r0 = com.paytm.utility.b.f((android.content.Context) r27)
            r8 = 2
            int r0 = r0 / r8
            int r9 = com.travel.bus.R.id.ri_travels_name
            android.view.View r9 = r1.findViewById(r9)
            com.paytm.utility.RoboTextView r9 = (com.paytm.utility.RoboTextView) r9
            r1.k = r9
            int r9 = com.travel.bus.R.id.ri_travels_type
            android.view.View r9 = r1.findViewById(r9)
            com.paytm.utility.RoboTextView r9 = (com.paytm.utility.RoboTextView) r9
            r1.l = r9
            int r9 = com.travel.bus.R.id.background_image_view
            android.view.View r9 = r1.findViewById(r9)
            androidx.appcompat.widget.AppCompatImageView r9 = (androidx.appcompat.widget.AppCompatImageView) r9
            r1.f21927b = r9
            androidx.appcompat.widget.AppCompatImageView r9 = r1.f21927b
            com.travel.utils.n$a r10 = com.travel.utils.n.a.V1
            java.lang.String r11 = "order_summary_header_image.png"
            com.travel.cdn.ResourceUtils.loadBusImagesFromCDN(r9, r11, r3, r3, r10)
            int r9 = com.travel.bus.R.id.ri_source_loc_name_view
            android.view.View r9 = r1.findViewById(r9)
            com.paytm.utility.RoboTextView r9 = (com.paytm.utility.RoboTextView) r9
            r1.m = r9
            int r9 = com.travel.bus.R.id.ri_dest_loc_name_view
            android.view.View r9 = r1.findViewById(r9)
            com.paytm.utility.RoboTextView r9 = (com.paytm.utility.RoboTextView) r9
            r1.n = r9
            int r9 = com.travel.bus.R.id.lyt_fast_forward
            android.view.View r9 = r1.findViewById(r9)
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            r1.as = r9
            int r9 = com.travel.bus.R.id.radio_fast_forward
            android.view.View r9 = r1.findViewById(r9)
            android.widget.CheckBox r9 = (android.widget.CheckBox) r9
            r1.at = r9
            int r9 = com.travel.bus.R.id.source
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.V = r9
            int r9 = com.travel.bus.R.id.destination
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.Z = r9
            int r9 = com.travel.bus.R.id.rvOperatorTag
            android.view.View r9 = r1.findViewById(r9)
            androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
            r1.aH = r9
            androidx.recyclerview.widget.LinearLayoutManager r9 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r10 = r27.getApplicationContext()
            r9.<init>(r10)
            r1.f21928c = r9
            androidx.recyclerview.widget.RecyclerView r9 = r1.aH
            androidx.recyclerview.widget.RecyclerView$LayoutManager r10 = r1.f21928c
            r9.setLayoutManager(r10)
            int r9 = com.travel.bus.R.id.boarding_point
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.W = r9
            int r9 = com.travel.bus.R.id.boarding_point_landmark
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.X = r9
            int r9 = com.travel.bus.R.id.dropping_pont_landmark
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.Y = r9
            int r9 = com.travel.bus.R.id.drop_point
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.aa = r9
            int r9 = com.travel.bus.R.id.travel_start_time
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.ab = r9
            int r9 = com.travel.bus.R.id.travel_start_date
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.ac = r9
            int r9 = com.travel.bus.R.id.travel_end_time
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.ad = r9
            int r9 = com.travel.bus.R.id.travel_end_date
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.ae = r9
            int r9 = com.travel.bus.R.id.travel_duration
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1.af = r9
            int r9 = com.travel.bus.R.id.tvBusRatings
            android.view.View r9 = r1.findViewById(r9)
            com.paytm.utility.RoboTextView r9 = (com.paytm.utility.RoboTextView) r9
            r1.ak = r9
            android.view.View r9 = r1.F
            r9.setPadding(r0, r0, r0, r3)
            android.view.View r9 = r1.L
            r9.setPadding(r0, r0, r0, r0)
            int r0 = com.travel.bus.R.id.btn_pay_now
            android.view.View r0 = r1.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r1.x = r0
            android.widget.Button r0 = r1.x
            r0.setOnClickListener(r1)
            int r0 = com.travel.bus.R.id.apply_btn
            android.view.View r0 = r1.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            r0.setOnClickListener(r1)
            int r0 = com.travel.bus.R.id.rl_remove
            android.view.View r0 = r1.findViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r0.setOnClickListener(r1)
            int r0 = com.travel.bus.R.id.edit_promo_code
            android.view.View r0 = r1.findViewById(r0)
            net.one97.paytm.common.widgets.CustomEditText r0 = (net.one97.paytm.common.widgets.CustomEditText) r0
            r1.u = r0
            int r0 = com.travel.bus.R.id.promo_code_apply_layout
            android.view.View r0 = r1.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1.v = r0
            android.widget.LinearLayout r0 = r1.v
            r0.setVisibility(r7)
            int r0 = com.travel.bus.R.id.have_promo
            android.view.View r0 = r1.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r1.J = r0
            com.paytm.utility.RoboTextView r0 = r1.J
            com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$S7Brkyv40Z5kRrtnJANiOyytb5A r9 = new com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$S7Brkyv40Z5kRrtnJANiOyytb5A
            r9.<init>()
            r0.setOnClickListener(r9)
            int r0 = com.travel.bus.R.id.no_of_traveller
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.T = r0
            int r0 = com.travel.bus.R.id.seat_no
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1.U = r0
            int r0 = com.travel.bus.R.id.custom_toast_container
            android.view.View r0 = r1.findViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r1.f21931f = r0
            int r0 = com.travel.bus.R.id.ivEffectiveText
            android.view.View r0 = r1.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r1.f21932g = r0
            int r0 = com.travel.bus.R.id.ivEffectiveClose
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$PT54BGpgsa2oH0pRzMzp-8wFvfk r9 = new com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$PT54BGpgsa2oH0pRzMzp-8wFvfk
            r9.<init>()
            r0.setOnClickListener(r9)
            android.widget.CheckBox r0 = r1.at
            com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$3mKmyyf6jlIWJNJ-q1mn0ZSkHgo r9 = new com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$3mKmyyf6jlIWJNJ-q1mn0ZSkHgo
            r9.<init>()
            r0.setOnCheckedChangeListener(r9)
            int r0 = com.travel.bus.R.id.lyt_traveller_list_review
            android.view.View r0 = r1.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1.aD = r0
            int r0 = com.travel.bus.R.id.tvPassengersReview
            android.view.View r0 = r1.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r1.aE = r0
            int r0 = com.travel.bus.R.id.tvSeatsReview
            android.view.View r0 = r1.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r1.aF = r0
            int r0 = com.travel.bus.R.id.tvReviewImpInfo
            android.view.View r0 = r1.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r1.aG = r0
            int r0 = com.travel.bus.R.id.clWarningPopup
            android.view.View r0 = r1.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r1.aI = r0
            int r0 = com.travel.bus.R.id.clPaymentTip
            android.view.View r0 = r1.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r1.aK = r0
            int r0 = com.travel.bus.R.id.remove_paymentTip
            android.view.View r0 = r1.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1.aL = r0
            android.widget.ImageView r0 = r1.aL
            int r9 = com.travel.bus.R.drawable.bus_close_normal
            r0.setImageResource(r9)
            android.widget.ImageView r0 = r1.aL
            com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$rgwww7UwSPRbCHm3clFSzyEEkxY r9 = new com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$rgwww7UwSPRbCHm3clFSzyEEkxY
            r9.<init>()
            r0.setOnClickListener(r9)
            android.content.Context r0 = r27.getApplicationContext()
            com.paytm.b.a.a r0 = com.travel.bus.b.a.a(r0)
            java.lang.String r9 = "payment_tip_key"
            boolean r0 = r0.b((java.lang.String) r9, (boolean) r3, (boolean) r3)
            if (r0 != 0) goto L_0x037e
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.aK
            r0.setVisibility(r3)
        L_0x037e:
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            boolean r0 = r0.k()
            if (r0 == 0) goto L_0x0390
            com.travel.bus.busticket.g.f r0 = r1.al
            r0.a()
        L_0x0390:
            int r0 = com.travel.bus.R.id.insurance_option_view
            android.view.View r0 = r1.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r1.ag = r0
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.ag
            r0.setVisibility(r7)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.ag
            int r9 = com.travel.bus.R.id.insurance_option
            android.view.View r0 = r0.findViewById(r9)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            r1.ah = r0
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.ag
            int r9 = com.travel.bus.R.id.tv_cancellation_protect_amount
            android.view.View r0 = r0.findViewById(r9)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r1.aq = r0
            int r0 = com.travel.bus.R.id.ll_fare_breakup
            android.view.View r0 = r1.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1.aP = r0
            int r0 = com.travel.bus.R.id.clTravellerFareBreakup
            android.view.View r0 = r1.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r1.aQ = r0
            int r0 = com.travel.bus.R.id.tvTravellerTotalFare
            android.view.View r0 = r1.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r1.aO = r0
            com.paytm.utility.RoboTextView r0 = r1.aO
            double r9 = r1.aM
            java.lang.String r11 = "###,###,###.##"
            java.lang.String r9 = com.paytm.utility.b.a((double) r9, (java.lang.String) r11)
            r0.setText(r9)
            android.widget.LinearLayout r0 = r1.aP
            com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$mGTaEhp4DLWGNB5w5LDx78PjrXQ r9 = new com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$mGTaEhp4DLWGNB5w5LDx78PjrXQ
            r9.<init>()
            r0.setOnClickListener(r9)
            android.widget.LinearLayout r0 = r1.aQ
            com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$7Var4rsqqscBow9zzk43myPPXXo r9 = new com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$7Var4rsqqscBow9zzk43myPPXXo
            r9.<init>()
            r0.setOnClickListener(r9)
            android.widget.CheckBox r0 = r1.ah
            com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$yJ05CluDaxGYzmSalZFSZY6lnMY r9 = new com.travel.bus.busticket.activity.-$$Lambda$AJRConfirmBookingActivity$yJ05CluDaxGYzmSalZFSZY6lnMY
            r9.<init>()
            r0.setOnCheckedChangeListener(r9)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.ag
            int r9 = com.travel.bus.R.id.insurance_text_view
            android.view.View r0 = r0.findViewById(r9)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r1.ai = r0
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.ag
            int r9 = com.travel.bus.R.id.insurance_text_view_title
            android.view.View r0 = r0.findViewById(r9)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            r1.aj = r0
            com.travel.bus.pojo.busticket.CJRBusInsurancePlans r0 = r1.ay
            java.lang.String r9 = "HHmm"
            java.lang.String r10 = "yyyy-MM-dd HH:mm:ss"
            if (r0 != 0) goto L_0x051b
            r27.getApplicationContext()
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r1.s
            java.lang.String r0 = r0.getDepartureDatetime()
            java.lang.String r17 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r10, (java.lang.String) r9)
            com.travel.bus.busticket.g.f r0 = r1.al
            com.travel.bus.pojo.busticket.CJRBusSearchInput r13 = r1.o
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r14 = r1.p
            com.travel.bus.pojo.busticket.TripBusDetail r15 = r1.am
            com.travel.bus.pojo.busticket.CJRBusSearchItem r12 = r1.s
            java.lang.String r16 = r12.getTripId()
            com.travel.bus.pojo.busticket.CJRBlockOneResponse r12 = r1.N
            com.travel.bus.a.a()
            com.travel.g.a r18 = com.travel.bus.a.b()
            boolean r18 = r18.m()
            java.lang.String r11 = "Insurance Url not found"
            if (r18 == 0) goto L_0x0515
            android.content.Context r5 = r0.f22373a
            boolean r5 = com.paytm.utility.b.c((android.content.Context) r5)
            if (r5 == 0) goto L_0x0515
            com.travel.bus.a.a()
            com.travel.g.a r5 = com.travel.bus.a.b()
            java.lang.String r5 = r5.t()
            if (r5 == 0) goto L_0x046e
            com.travel.bus.a.a()
            com.travel.g.a r5 = com.travel.bus.a.b()
            java.lang.String r5 = r5.t()
            goto L_0x046f
        L_0x046e:
            r5 = 0
        L_0x046f:
            com.travel.bus.pojo.busticket.CJRBlockOneModel r6 = r12.getBlockResponse()
            com.travel.bus.pojo.busticket.CJRBusOnwardLeg r6 = r6.getOnwardLeg()
            java.util.List r6 = r6.getTaxDetails()
            if (r6 == 0) goto L_0x04a9
            boolean r18 = r6.isEmpty()
            if (r18 != 0) goto L_0x04a9
            java.util.Iterator r6 = r6.iterator()
        L_0x0487:
            boolean r18 = r6.hasNext()
            if (r18 == 0) goto L_0x04a9
            java.lang.Object r18 = r6.next()
            com.travel.bus.pojo.busticket.CJRTaxItem r18 = (com.travel.bus.pojo.busticket.CJRTaxItem) r18
            if (r18 == 0) goto L_0x0487
            java.lang.String r20 = r18.getName()
            if (r20 == 0) goto L_0x0487
            double r20 = r18.getValue()
            r22 = 0
            int r24 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r24 <= 0) goto L_0x0487
            r18.getValue()
            goto L_0x0487
        L_0x04a9:
            r6 = r12
            r12 = r0
            r18 = r6
            java.lang.String r23 = r12.a((com.travel.bus.pojo.busticket.CJRBusSearchInput) r13, (java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem>) r14, (com.travel.bus.pojo.busticket.TripBusDetail) r15, (java.lang.String) r16, (java.lang.String) r17, (com.travel.bus.pojo.busticket.CJRBlockOneResponse) r18)
            if (r5 == 0) goto L_0x050f
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x050f
            if (r23 == 0) goto L_0x050f
            if (r5 == 0) goto L_0x0509
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0509
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r11 = "Content-Type"
            java.lang.String r12 = "application/json"
            r6.put(r11, r12)
            android.content.Context r11 = r0.f22373a
            boolean r11 = com.travel.bus.busticket.i.o.b((android.content.Context) r11)
            if (r11 == 0) goto L_0x04ef
            android.net.Uri r5 = android.net.Uri.parse(r5)
            android.net.Uri$Builder r5 = r5.buildUpon()
            java.lang.String r11 = "is_reseller"
            java.lang.String r12 = "1"
            android.net.Uri$Builder r5 = r5.appendQueryParameter(r11, r12)
            android.net.Uri r5 = r5.build()
            java.lang.String r5 = r5.toString()
        L_0x04ef:
            r21 = r5
            android.content.Context r5 = r0.f22373a
            com.paytm.network.a$a r24 = com.paytm.network.a.C0715a.POST
            com.travel.bus.pojo.busticket.CJRBusInsurancePlans r25 = new com.travel.bus.pojo.busticket.CJRBusInsurancePlans
            r25.<init>()
            com.travel.bus.busticket.g.f$1 r11 = new com.travel.bus.busticket.g.f$1
            r11.<init>()
            r20 = r5
            r22 = r6
            r26 = r11
            com.travel.bus.busticket.g.f.a(r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0524
        L_0x0509:
            java.lang.String r0 = "Insurance Api"
            com.travel.bus.busticket.g.f.a(r0, r11)
            goto L_0x0524
        L_0x050f:
            java.lang.String r0 = "Insurance"
            com.travel.bus.busticket.g.f.a(r0, r11)
            goto L_0x0524
        L_0x0515:
            java.lang.String r0 = "Insurance"
            com.travel.bus.busticket.g.f.a(r0, r11)
            goto L_0x0524
        L_0x051b:
            boolean r5 = r1.C
            com.travel.bus.pojo.busticket.CJRBusInsuranceItem r0 = r0.getInsuranceAtIndex(r3)
            r1.a((boolean) r5, (com.travel.bus.pojo.busticket.CJRBusInsuranceItem) r0)
        L_0x0524:
            int r0 = com.travel.bus.R.id.bus_seat_title_text_start
            android.view.View r0 = r1.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            int r5 = com.travel.bus.R.id.bus_seat_title_text_end
            android.view.View r5 = r1.findViewById(r5)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            int r6 = com.travel.bus.R.id.bus_seat_date
            android.view.View r6 = r1.findViewById(r6)
            com.paytm.utility.RoboTextView r6 = (com.paytm.utility.RoboTextView) r6
            com.travel.bus.pojo.busticket.CJRBusSearchInput r11 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r11 = r11.getSource()
            java.lang.String r11 = r11.getDisplayCityName()
            r0.setText(r11)
            com.travel.bus.pojo.busticket.CJRBusSearchInput r0 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r0 = r0.getDestination()
            java.lang.String r0 = r0.getDisplayCityName()
            r5.setText(r0)
            com.travel.bus.pojo.busticket.CJRBusSearchInput r0 = r1.o
            java.lang.String r0 = r0.getDate()
            java.lang.String r0 = c((java.lang.String) r0)
            r6.setText(r0)
            r27.j()
            r27.i()
            r5 = 1
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r1.s     // Catch:{ Exception -> 0x05e5 }
            com.travel.bus.pojo.busticket.BusRatingModel r0 = r0.getBusRating()     // Catch:{ Exception -> 0x05e5 }
            if (r0 == 0) goto L_0x05df
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r1.s     // Catch:{ Exception -> 0x05e5 }
            com.travel.bus.pojo.busticket.BusRatingModel r0 = r0.getBusRating()     // Catch:{ Exception -> 0x05e5 }
            int r0 = r0.getCount()     // Catch:{ Exception -> 0x05e5 }
            com.travel.bus.pojo.busticket.CJRBusSearchItem r6 = r1.s     // Catch:{ Exception -> 0x05e5 }
            com.travel.bus.pojo.busticket.BusRatingModel r6 = r6.getBusRating()     // Catch:{ Exception -> 0x05e5 }
            double r11 = r6.getAvgRating()     // Catch:{ Exception -> 0x05e5 }
            com.travel.bus.pojo.busticket.CJRBusSearchItem r6 = r1.s     // Catch:{ Exception -> 0x05e5 }
            com.travel.bus.pojo.busticket.BusRatingModel r6 = r6.getBusRating()     // Catch:{ Exception -> 0x05e5 }
            java.lang.String r6 = r6.getColor_code()     // Catch:{ Exception -> 0x05e5 }
            r13 = 0
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x05d9
            if (r0 <= 0) goto L_0x05d9
            com.paytm.utility.RoboTextView r0 = r1.ak     // Catch:{ Exception -> 0x05e5 }
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x05e5 }
            com.paytm.utility.RoboTextView r0 = r1.ak     // Catch:{ Exception -> 0x05e5 }
            java.lang.String r13 = "%.1f"
            java.lang.Object[] r14 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x05e5 }
            java.lang.Double r11 = java.lang.Double.valueOf(r11)     // Catch:{ Exception -> 0x05e5 }
            r14[r3] = r11     // Catch:{ Exception -> 0x05e5 }
            java.lang.String r11 = java.lang.String.format(r13, r14)     // Catch:{ Exception -> 0x05e5 }
            r0.setText(r11)     // Catch:{ Exception -> 0x05e5 }
            int r0 = com.travel.bus.R.drawable.travel_res_bus_rating_background     // Catch:{ Exception -> 0x05e5 }
            android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r1, (int) r0)     // Catch:{ Exception -> 0x05e5 }
            android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.a.f(r0)     // Catch:{ Exception -> 0x05e5 }
            com.paytm.utility.RoboTextView r11 = r1.ak     // Catch:{ Exception -> 0x05e5 }
            r11.setBackground(r0)     // Catch:{ Exception -> 0x05e5 }
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x05e5 }
            if (r11 < r4) goto L_0x05cb
            int r6 = android.graphics.Color.parseColor(r6)     // Catch:{ Exception -> 0x05e5 }
            androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r0, (int) r6)     // Catch:{ Exception -> 0x05e5 }
            goto L_0x05ed
        L_0x05cb:
            android.graphics.drawable.Drawable r0 = r0.mutate()     // Catch:{ Exception -> 0x05e5 }
            int r6 = android.graphics.Color.parseColor(r6)     // Catch:{ Exception -> 0x05e5 }
            android.graphics.PorterDuff$Mode r11 = android.graphics.PorterDuff.Mode.SRC_IN     // Catch:{ Exception -> 0x05e5 }
            r0.setColorFilter(r6, r11)     // Catch:{ Exception -> 0x05e5 }
            goto L_0x05ed
        L_0x05d9:
            com.paytm.utility.RoboTextView r0 = r1.ak     // Catch:{ Exception -> 0x05e5 }
            r0.setVisibility(r7)     // Catch:{ Exception -> 0x05e5 }
            goto L_0x05ed
        L_0x05df:
            com.paytm.utility.RoboTextView r0 = r1.ak     // Catch:{ Exception -> 0x05e5 }
            r0.setVisibility(r7)     // Catch:{ Exception -> 0x05e5 }
            goto L_0x05ed
        L_0x05e5:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x05ed:
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r0 = r1.p
            r1.a((java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem>) r0)
            int r0 = com.travel.bus.R.id.tvMobileNumReview
            android.view.View r0 = r1.findViewById(r0)
            com.paytm.utility.RoboTextView r0 = (com.paytm.utility.RoboTextView) r0
            int r6 = com.travel.bus.R.id.tvEmailAddressReview
            android.view.View r6 = r1.findViewById(r6)
            com.paytm.utility.RoboTextView r6 = (com.paytm.utility.RoboTextView) r6
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "+91   "
            r11.<init>(r12)
            java.lang.String r12 = r1.ap
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r0.setText(r11)
            java.lang.String r0 = r1.ao
            r6.setText(r0)
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            boolean r0 = r0.O()
            if (r0 == 0) goto L_0x06a7
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            java.lang.String r0 = r0.h()
            com.travel.bus.pojo.busticket.CJRBusSearchItem r6 = r1.s
            if (r6 == 0) goto L_0x06a1
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 != 0) goto L_0x06a1
            com.travel.bus.pojo.busticket.CJRBusSearchItem r6 = r1.s
            java.lang.String r6 = r6.getTravelsName()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x06a1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            com.travel.bus.pojo.busticket.CJRBusSearchItem r11 = r1.s
            java.lang.String r11 = r11.getTravelsName()
            r6[r3] = r11
            java.lang.String r0 = java.lang.String.format(r0, r6)
            int r6 = com.travel.bus.R.string.bus_price_text
            java.lang.String r6 = r1.getString(r6)
            java.lang.Object[] r11 = new java.lang.Object[r5]
            double r12 = r1.aM
            java.lang.Double r12 = java.lang.Double.valueOf(r12)
            r11[r3] = r12
            java.lang.String.format(r6, r11)
            java.lang.String r6 = "provided by"
            int r6 = r0.indexOf(r6)
            int r6 = r6 + 11
            com.travel.bus.pojo.busticket.CJRBusSearchItem r11 = r1.s
            java.lang.String r11 = r11.getTravelsName()
            int r11 = r11.length()
            int r11 = r11 + r6
            r12 = -1
            if (r6 == r12) goto L_0x0696
            r12 = -1
            if (r11 == r12) goto L_0x0696
            android.text.SpannableString r12 = new android.text.SpannableString
            r12.<init>(r0)
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r0.<init>(r5)
            int r11 = r11 + r5
            r12.setSpan(r0, r6, r11, r3)
            com.paytm.utility.RoboTextView r0 = r1.aG
            r0.setText(r12)
            goto L_0x069b
        L_0x0696:
            com.paytm.utility.RoboTextView r6 = r1.aG
            r6.setText(r0)
        L_0x069b:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.aI
            r0.setVisibility(r3)
            goto L_0x06ac
        L_0x06a1:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.aI
            r0.setVisibility(r7)
            goto L_0x06ac
        L_0x06a7:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.aI
            r0.setVisibility(r7)
        L_0x06ac:
            int r0 = com.travel.bus.R.id.tvPaymentTipInfo
            android.view.View r0 = r1.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            android.content.res.Resources r6 = r27.getResources()
            int r11 = com.travel.bus.R.string.instant_refund_payment_tip_text
            java.lang.String r6 = r6.getString(r11)
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)
            r0.setText(r6)
            com.travel.bus.pojo.busticket.CJRBusSearchInput r0 = r1.o
            if (r0 == 0) goto L_0x07f0
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r0 = r0.getSource()
            if (r0 == 0) goto L_0x06ea
            com.travel.bus.pojo.busticket.CJRBusSearchInput r0 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r0 = r0.getSource()
            java.lang.String r0 = r0.getName()
            if (r0 == 0) goto L_0x06ea
            com.paytm.utility.RoboTextView r0 = r1.m
            com.travel.bus.pojo.busticket.CJRBusSearchInput r6 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r6 = r6.getSource()
            java.lang.String r6 = r6.getName()
            r0.setText(r6)
        L_0x06ea:
            com.travel.bus.pojo.busticket.CJRBusSearchInput r0 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r0 = r0.getDestination()
            if (r0 == 0) goto L_0x070d
            com.travel.bus.pojo.busticket.CJRBusSearchInput r0 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r0 = r0.getDestination()
            java.lang.String r0 = r0.getName()
            if (r0 == 0) goto L_0x070d
            com.paytm.utility.RoboTextView r0 = r1.n
            com.travel.bus.pojo.busticket.CJRBusSearchInput r6 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r6 = r6.getDestination()
            java.lang.String r6 = r6.getName()
            r0.setText(r6)
        L_0x070d:
            com.travel.bus.pojo.busticket.CJRLocation r0 = r1.q
            if (r0 == 0) goto L_0x07f0
            com.travel.bus.pojo.busticket.CJRLocation r0 = r1.r
            if (r0 == 0) goto L_0x07f0
            r27.getApplicationContext()
            com.travel.bus.pojo.busticket.CJRLocation r0 = r1.q
            java.lang.String r0 = r0.getTime()
            java.lang.String r0 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r10, (java.lang.String) r9)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.CharSequence r11 = r0.subSequence(r3, r8)
            r6.append(r11)
            java.lang.String r11 = ":"
            r6.append(r11)
            r11 = 4
            java.lang.CharSequence r0 = r0.subSequence(r8, r11)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            r27.getApplicationContext()
            com.travel.bus.pojo.busticket.CJRLocation r6 = r1.r
            java.lang.String r6 = r6.getTime()
            java.lang.String r6 = com.paytm.utility.b.d((java.lang.String) r6, (java.lang.String) r10, (java.lang.String) r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.CharSequence r11 = r6.subSequence(r3, r8)
            r9.append(r11)
            java.lang.String r11 = ":"
            r9.append(r11)
            r11 = 4
            java.lang.CharSequence r6 = r6.subSequence(r8, r11)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            java.lang.String r9 = "24:00"
            java.lang.String r11 = "00:00"
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x07ba }
            java.lang.String r13 = "HH:mm"
            r12.<init>(r13)     // Catch:{ Exception -> 0x07ba }
            java.util.Date r0 = r12.parse(r0)     // Catch:{ Exception -> 0x07ba }
            java.util.Date r6 = r12.parse(r6)     // Catch:{ Exception -> 0x07ba }
            java.util.Date r11 = r12.parse(r11)     // Catch:{ Exception -> 0x07ba }
            java.util.Date r9 = r12.parse(r9)     // Catch:{ Exception -> 0x07ba }
            long r12 = r6.getTime()     // Catch:{ Exception -> 0x07ba }
            long r14 = r0.getTime()     // Catch:{ Exception -> 0x07ba }
            long r12 = r12 - r14
            r14 = 0
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x07a9
            long r12 = r9.getTime()     // Catch:{ Exception -> 0x07bc }
            long r16 = r0.getTime()     // Catch:{ Exception -> 0x07bc }
            long r12 = r12 - r16
            long r16 = r6.getTime()     // Catch:{ Exception -> 0x07bc }
            long r18 = r11.getTime()     // Catch:{ Exception -> 0x07bc }
            long r16 = r16 - r18
            long r12 = r12 + r16
        L_0x07a9:
            r16 = 3600000(0x36ee80, double:1.7786363E-317)
            long r16 = r12 / r16
            r18 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r12 % r18
            r18 = 60000(0xea60, double:2.9644E-319)
            long r11 = r12 / r18
            r14 = r11
            goto L_0x07be
        L_0x07ba:
            r14 = 0
        L_0x07bc:
            r16 = r14
        L_0x07be:
            r11 = r16
            android.widget.TextView r0 = r1.af
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r11)
            java.lang.String r9 = " "
            r6.append(r9)
            int r9 = com.travel.bus.R.string.bus_review_hours
            java.lang.String r9 = r1.getString(r9)
            r6.append(r9)
            java.lang.String r9 = " "
            r6.append(r9)
            r6.append(r14)
            int r9 = com.travel.bus.R.string.bus_review_min
            java.lang.String r9 = r1.getString(r9)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r0.setText(r6)
        L_0x07f0:
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r1.s
            if (r0 == 0) goto L_0x0805
            java.lang.String r0 = r0.getSource()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0805
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r1.s
            java.lang.String r11 = r0.getSource()
            goto L_0x0806
        L_0x0805:
            r11 = 0
        L_0x0806:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x0812
            android.widget.TextView r0 = r1.V
            r0.setText(r11)
            goto L_0x082b
        L_0x0812:
            com.travel.bus.pojo.busticket.CJRBusSearchInput r0 = r1.o
            if (r0 == 0) goto L_0x082b
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r0 = r0.getSource()
            if (r0 == 0) goto L_0x082b
            android.widget.TextView r0 = r1.V
            com.travel.bus.pojo.busticket.CJRBusSearchInput r6 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r6 = r6.getSource()
            java.lang.String r6 = r6.getName()
            r0.setText(r6)
        L_0x082b:
            com.travel.bus.pojo.busticket.CJRLocation r0 = r1.q
            java.lang.String r6 = "EEE, d MMM"
            java.lang.String r9 = ""
            if (r0 == 0) goto L_0x0844
            java.lang.String r0 = r0.getTime()
            if (r0 == 0) goto L_0x0844
            com.travel.bus.pojo.busticket.CJRLocation r0 = r1.q
            java.lang.String r0 = r0.getTime()
            java.lang.String r0 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r10, (java.lang.String) r6)
            goto L_0x0855
        L_0x0844:
            com.travel.bus.pojo.busticket.CJRBusSearchInput r0 = r1.o
            if (r0 == 0) goto L_0x0854
            java.lang.String r0 = r0.getDate()
            java.lang.String r11 = "yyyy-MM-dd"
            java.lang.String r0 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r11, (java.lang.String) r6)
            goto L_0x0855
        L_0x0854:
            r0 = r9
        L_0x0855:
            com.travel.bus.pojo.busticket.CJRLocation r11 = r1.q
            if (r11 == 0) goto L_0x08c8
            java.lang.String r11 = r11.getTime()
            if (r11 == 0) goto L_0x0870
            com.travel.bus.pojo.busticket.CJRLocation r11 = r1.q
            java.lang.String r11 = r11.getTime()
            java.lang.String r12 = "h:mm a"
            java.lang.String r11 = com.paytm.utility.b.a((java.lang.String) r11, (java.lang.String) r10, (java.lang.String) r12)
            android.widget.TextView r12 = r1.ab
            r12.setText(r11)
        L_0x0870:
            android.widget.TextView r11 = r1.ac
            r11.setText(r0)
            com.travel.bus.pojo.busticket.CJRLocation r0 = r1.q
            java.lang.String r0 = r0.getLocationName()
            if (r0 == 0) goto L_0x088c
            android.widget.TextView r0 = r1.W
            com.travel.bus.pojo.busticket.CJRLocation r11 = r1.q
            java.lang.String r11 = r11.getLocationName()
            java.lang.String r11 = r11.trim()
            r0.setText(r11)
        L_0x088c:
            com.travel.bus.pojo.busticket.CJRLocation r0 = r1.q
            java.lang.String r0 = r0.getLocationAddress()
            if (r0 == 0) goto L_0x08a8
            android.widget.TextView r0 = r1.X
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.X
            com.travel.bus.pojo.busticket.CJRLocation r11 = r1.q
            java.lang.String r11 = r11.getLocationAddress()
            java.lang.String r11 = r11.trim()
            r0.setText(r11)
        L_0x08a8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r11 = "mSelectedBoardingPoint.getLocationName() : "
            r0.<init>(r11)
            com.travel.bus.pojo.busticket.CJRLocation r11 = r1.q
            java.lang.String r11 = r11.getLocationName()
            r0.append(r11)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r11 = "mSelectedBoardingPoint.getLandmark() : "
            r0.<init>(r11)
            com.travel.bus.pojo.busticket.CJRLocation r11 = r1.q
            java.lang.String r11 = r11.getLandmark()
            r0.append(r11)
        L_0x08c8:
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r1.s
            if (r0 == 0) goto L_0x08dd
            java.lang.String r0 = r0.getDestination()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x08dd
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r1.s
            java.lang.String r11 = r0.getDestination()
            goto L_0x08de
        L_0x08dd:
            r11 = 0
        L_0x08de:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x08ea
            android.widget.TextView r0 = r1.Z
            r0.setText(r11)
            goto L_0x0903
        L_0x08ea:
            com.travel.bus.pojo.busticket.CJRBusSearchInput r0 = r1.o
            if (r0 == 0) goto L_0x0903
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r0 = r0.getDestination()
            if (r0 == 0) goto L_0x0903
            android.widget.TextView r0 = r1.Z
            com.travel.bus.pojo.busticket.CJRBusSearchInput r11 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r11 = r11.getDestination()
            java.lang.String r11 = r11.getName()
            r0.setText(r11)
        L_0x0903:
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r1.s
            if (r0 == 0) goto L_0x091c
            java.lang.String r0 = r0.getArrivalDatetime()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x091c
            com.travel.bus.pojo.busticket.CJRBusSearchItem r0 = r1.s
            java.lang.String r0 = r0.getArrivalDatetime()
            java.lang.String r0 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r10, (java.lang.String) r6)
            goto L_0x091d
        L_0x091c:
            r0 = r9
        L_0x091d:
            com.travel.bus.pojo.busticket.CJRLocation r6 = r1.r
            if (r6 == 0) goto L_0x0970
            java.lang.String r6 = r6.getTime()
            if (r6 == 0) goto L_0x0938
            com.travel.bus.pojo.busticket.CJRLocation r6 = r1.r
            java.lang.String r6 = r6.getTime()
            java.lang.String r11 = "h:mm a"
            java.lang.String r6 = com.paytm.utility.b.a((java.lang.String) r6, (java.lang.String) r10, (java.lang.String) r11)
            android.widget.TextView r10 = r1.ad
            r10.setText(r6)
        L_0x0938:
            android.widget.TextView r6 = r1.ae
            r6.setText(r0)
            com.travel.bus.pojo.busticket.CJRLocation r0 = r1.r
            java.lang.String r0 = r0.getLocationName()
            if (r0 == 0) goto L_0x0954
            android.widget.TextView r0 = r1.aa
            com.travel.bus.pojo.busticket.CJRLocation r6 = r1.r
            java.lang.String r6 = r6.getLocationName()
            java.lang.String r6 = r6.trim()
            r0.setText(r6)
        L_0x0954:
            com.travel.bus.pojo.busticket.CJRLocation r0 = r1.r
            java.lang.String r0 = r0.getLocationAddress()
            if (r0 == 0) goto L_0x0970
            android.widget.TextView r0 = r1.Y
            r0.setVisibility(r3)
            android.widget.TextView r0 = r1.Y
            com.travel.bus.pojo.busticket.CJRLocation r6 = r1.r
            java.lang.String r6 = r6.getLocationAddress()
            java.lang.String r6 = r6.trim()
            r0.setText(r6)
        L_0x0970:
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r27)
            if (r0 == 0) goto L_0x0a94
            int r0 = com.paytm.utility.b.f((android.content.Context) r27)
            int r6 = r0 / 2
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            java.lang.String r10 = "busPromoUrl"
            java.lang.String r0 = r0.f(r10)
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r10 = r1.p
            if (r10 == 0) goto L_0x09a0
            int r10 = r10.size()
            if (r10 <= 0) goto L_0x09a0
            java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r10 = r1.p
            java.lang.Object r10 = r10.get(r3)
            com.travel.bus.pojo.busticket.TripBusDetailsItem r10 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r10
            java.lang.String r11 = r10.getProductId()
            goto L_0x09a1
        L_0x09a0:
            r11 = 0
        L_0x09a1:
            boolean r10 = android.text.TextUtils.isEmpty(r11)
            if (r10 != 0) goto L_0x09fa
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x09e5 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x09e5 }
            r10.<init>()     // Catch:{ Exception -> 0x09e5 }
            java.lang.String r12 = r0.getScheme()     // Catch:{ Exception -> 0x09e5 }
            r10.append(r12)     // Catch:{ Exception -> 0x09e5 }
            java.lang.String r12 = "://"
            r10.append(r12)     // Catch:{ Exception -> 0x09e5 }
            java.lang.String r0 = r0.getAuthority()     // Catch:{ Exception -> 0x09e5 }
            r10.append(r0)     // Catch:{ Exception -> 0x09e5 }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x09e5 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x09e5 }
            android.net.Uri$Builder r0 = r0.buildUpon()     // Catch:{ Exception -> 0x09e5 }
            java.lang.String r10 = "papi/v1/promosearch/product/%s/offers"
            java.lang.Object[] r12 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x09e5 }
            r12[r3] = r11     // Catch:{ Exception -> 0x09e5 }
            java.lang.String r10 = java.lang.String.format(r10, r12)     // Catch:{ Exception -> 0x09e5 }
            r0.appendEncodedPath(r10)     // Catch:{ Exception -> 0x09e5 }
            android.net.Uri r0 = r0.build()     // Catch:{ Exception -> 0x09e5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x09e5 }
            goto L_0x09fa
        L_0x09e5:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            java.lang.String r10 = "busPromoUrl"
            java.lang.String r0 = r0.f(r10)
        L_0x09fa:
            boolean r10 = android.webkit.URLUtil.isValidUrl(r0)
            if (r10 == 0) goto L_0x0a7c
            android.content.Context r7 = r27.getApplicationContext()
            boolean r7 = com.travel.bus.busticket.i.o.b((android.content.Context) r7)
            if (r7 == 0) goto L_0x0a23
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri$Builder r0 = r0.buildUpon()
            java.lang.String r7 = "isReseller"
            java.lang.String r10 = "true"
            android.net.Uri$Builder r0 = r0.appendQueryParameter(r7, r10)
            android.net.Uri r0 = r0.build()
            java.lang.String r0 = r0.toString()
        L_0x0a23:
            com.travel.bus.busticket.activity.AJRConfirmBookingActivity$1 r7 = new com.travel.bus.busticket.activity.AJRConfirmBookingActivity$1
            r7.<init>(r6)
            boolean r6 = android.webkit.URLUtil.isValidUrl(r0)
            if (r6 == 0) goto L_0x0a94
            java.lang.String r0 = com.paytm.utility.b.s(r1, r0)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r10 = com.paytm.utility.a.q(r27)
            java.lang.String r11 = "sso_token"
            r6.put(r11, r10)
            com.paytm.network.b r10 = new com.paytm.network.b
            r10.<init>()
            r10.f42877a = r1
            com.paytm.network.a$c r11 = com.paytm.network.a.c.BUS
            r10.f42878b = r11
            com.paytm.network.a$a r11 = com.paytm.network.a.C0715a.GET
            r10.f42879c = r11
            r10.f42880d = r0
            r11 = 0
            r10.f42881e = r11
            r10.f42882f = r6
            r10.f42884h = r11
            r10.f42883g = r11
            r10.f42884h = r11
            com.travel.bus.pojo.busticket.CJRBusOffers r0 = new com.travel.bus.pojo.busticket.CJRBusOffers
            r0.<init>()
            r10.f42885i = r0
            r10.j = r7
            org.json.JSONObject r0 = com.travel.bus.busticket.d.c.a()
            r10.t = r0
            com.paytm.network.a$b r0 = com.paytm.network.a.b.SILENT
            r10.n = r0
            java.lang.String r0 = "bus-banner-page"
            r10.o = r0
            com.paytm.network.a r0 = r10.l()
            r0.a()
            goto L_0x0a94
        L_0x0a7c:
            android.view.View r0 = r1.ar
            r0.setVisibility(r7)
            r27.e()
            android.view.View r0 = r1.F
            r0.setPadding(r6, r6, r6, r6)
            android.view.View r0 = r1.F
            int r6 = com.travel.bus.R.id.progress_bar_offers
            android.view.View r0 = r0.findViewById(r6)
            r0.setVisibility(r7)
        L_0x0a94:
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r27)
            if (r0 == 0) goto L_0x0b3e
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            java.lang.String r6 = r0.l()
            com.travel.bus.pojo.busticket.CJRBlockOneResponse r0 = r1.N
            if (r0 == 0) goto L_0x0ac6
            com.travel.bus.pojo.busticket.CJRBlockOneModel r0 = r0.getBlockResponse()
            if (r0 == 0) goto L_0x0ac6
            com.travel.bus.pojo.busticket.CJRBlockOneResponse r0 = r1.N
            com.travel.bus.pojo.busticket.CJRBlockOneModel r0 = r0.getBlockResponse()
            java.lang.String r0 = r0.getTicketId()
            if (r0 == 0) goto L_0x0ac6
            com.travel.bus.pojo.busticket.CJRBlockOneResponse r0 = r1.N
            com.travel.bus.pojo.busticket.CJRBlockOneModel r0 = r0.getBlockResponse()
            java.lang.String r11 = r0.getTicketId()
            goto L_0x0ac7
        L_0x0ac6:
            r11 = 0
        L_0x0ac7:
            boolean r0 = android.webkit.URLUtil.isValidUrl(r6)
            if (r0 == 0) goto L_0x0b3e
            com.travel.bus.busticket.activity.AJRConfirmBookingActivity$2 r7 = new com.travel.bus.busticket.activity.AJRConfirmBookingActivity$2
            r7.<init>()
            boolean r0 = android.webkit.URLUtil.isValidUrl(r6)
            if (r0 == 0) goto L_0x0b3e
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.lang.String r0 = com.paytm.utility.a.q(r27)
            java.lang.String r12 = "sso_token"
            r10.put(r12, r0)
            java.lang.String r0 = "Content-Type"
            java.lang.String r12 = "application/json"
            r10.put(r0, r12)
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r0 = "ticket_order_id"
            r12.put(r0, r11)     // Catch:{ JSONException -> 0x0afa }
            goto L_0x0b02
        L_0x0afa:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x0b02:
            com.paytm.network.b r0 = new com.paytm.network.b
            r0.<init>()
            r0.f42877a = r1
            com.paytm.network.a$c r11 = com.paytm.network.a.c.BUS
            r0.f42878b = r11
            com.paytm.network.a$a r11 = com.paytm.network.a.C0715a.POST
            r0.f42879c = r11
            r0.f42880d = r6
            r6 = 0
            r0.f42881e = r6
            r0.f42882f = r10
            java.lang.String r10 = r12.toString()
            r0.f42884h = r10
            r0.f42883g = r6
            com.travel.bus.pojo.busticket.CJRBusReviewCancellationPolicy r6 = new com.travel.bus.pojo.busticket.CJRBusReviewCancellationPolicy
            r6.<init>()
            r0.f42885i = r6
            r0.j = r7
            org.json.JSONObject r6 = com.travel.bus.busticket.d.c.a()
            r0.t = r6
            com.paytm.network.a$b r6 = com.paytm.network.a.b.SILENT
            r0.n = r6
            java.lang.String r6 = "bus-banner-page"
            r0.o = r6
            com.paytm.network.a r0 = r0.l()
            r0.a()
        L_0x0b3e:
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            java.lang.String r0 = r0.e()
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 == 0) goto L_0x0b59
            android.content.res.Resources r0 = r27.getResources()
            int r6 = com.travel.bus.R.string.travel_push_notification_title
            java.lang.String r0 = r0.getString(r6)
        L_0x0b59:
            r14 = r0
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            java.lang.String r0 = r0.f()
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 == 0) goto L_0x0b90
            android.content.res.Resources r0 = r27.getResources()
            int r6 = com.travel.bus.R.string.travel_bus_push_content
            java.lang.Object[] r7 = new java.lang.Object[r8]
            com.travel.bus.pojo.busticket.CJRBusSearchInput r10 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r10 = r10.getSource()
            java.lang.String r10 = r10.getName()
            r7[r3] = r10
            com.travel.bus.pojo.busticket.CJRBusSearchInput r10 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r10 = r10.getDestination()
            java.lang.String r10 = r10.getName()
            r7[r5] = r10
            java.lang.String r0 = r0.getString(r6, r7)
            goto L_0x0bc8
        L_0x0b90:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            android.content.res.Resources r7 = r27.getResources()
            int r10 = com.travel.bus.R.string.travel_push_content_hardcoded
            r11 = 3
            java.lang.Object[] r11 = new java.lang.Object[r11]
            com.travel.bus.pojo.busticket.CJRBusSearchInput r12 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r12 = r12.getSource()
            java.lang.String r12 = r12.getName()
            r11[r3] = r12
            com.travel.bus.pojo.busticket.CJRBusSearchInput r12 = r1.o
            com.travel.bus.pojo.busticket.CJRBusOriginCityItem r12 = r12.getDestination()
            java.lang.String r12 = r12.getName()
            r11[r5] = r12
            java.lang.String r12 = "Bus"
            r11[r8] = r12
            java.lang.String r7 = r7.getString(r10, r11)
            r6.append(r7)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
        L_0x0bc8:
            r13 = r0
            android.content.Context r0 = r27.getApplicationContext()
            java.lang.String r11 = "busticket"
            java.lang.String r12 = "FD_Bus"
            java.lang.String r15 = "searchdrop"
            java.lang.String r6 = "funneldrop"
            java.util.HashSet r7 = new java.util.HashSet
            r7.<init>()
            android.content.Context r10 = r0.getApplicationContext()     // Catch:{ Exception -> 0x0cd7 }
            com.paytm.b.a.a r10 = com.travel.bus.b.a.a(r10)     // Catch:{ Exception -> 0x0cd7 }
            com.google.gsonhtcfix.f r8 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0cd7 }
            r8.<init>()     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r3 = "userDropVerticalList"
            java.lang.String r3 = r10.b((java.lang.String) r3, (java.lang.String) r9, (boolean) r5)     // Catch:{ Exception -> 0x0cd7 }
            boolean r9 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0cd7 }
            if (r9 != 0) goto L_0x0c04
            com.travel.bus.busticket.InAppPushNotification.a$1 r7 = new com.travel.bus.busticket.InAppPushNotification.a$1     // Catch:{ Exception -> 0x0cd7 }
            r7.<init>()     // Catch:{ Exception -> 0x0cd7 }
            java.lang.reflect.Type r7 = r7.getType()     // Catch:{ Exception -> 0x0cd7 }
            java.lang.Object r3 = r8.a((java.lang.String) r3, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x0cd7 }
            r7 = r3
            java.util.Set r7 = (java.util.Set) r7     // Catch:{ Exception -> 0x0cd7 }
        L_0x0c04:
            r3 = 10
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0cd7 }
            r7.add(r9)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r7 = r8.a((java.lang.Object) r7)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r8 = "userDropVerticalList"
            r10.a((java.lang.String) r8, (java.lang.String) r7, (boolean) r5)     // Catch:{ Exception -> 0x0cd7 }
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0cd7 }
            if (r7 < r4) goto L_0x0c94
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r7 = "net.one97.paytm"
            java.lang.Class<com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisherService> r8 = com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisherService.class
            java.lang.String r8 = r8.getName()     // Catch:{ Exception -> 0x0cd7 }
            r4.<init>(r7, r8)     // Catch:{ Exception -> 0x0cd7 }
            android.app.job.JobInfo$Builder r7 = new android.app.job.JobInfo$Builder     // Catch:{ Exception -> 0x0cd7 }
            r8 = 2019(0x7e3, float:2.829E-42)
            r7.<init>(r8, r4)     // Catch:{ Exception -> 0x0cd7 }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x0cd7 }
            com.travel.g.a r4 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x0cd7 }
            int r4 = r4.E()     // Catch:{ Exception -> 0x0cd7 }
            if (r4 != 0) goto L_0x0c3f
            r4 = 1800000(0x1b7740, float:2.522337E-39)
        L_0x0c3f:
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0cd7 }
            long r3 = (long) r4     // Catch:{ Exception -> 0x0cd7 }
            long r8 = r8 + r3
            r7.setMinimumLatency(r8)     // Catch:{ Exception -> 0x0cd7 }
            r7.setPersisted(r5)     // Catch:{ Exception -> 0x0cd7 }
            android.os.PersistableBundle r3 = new android.os.PersistableBundle     // Catch:{ Exception -> 0x0cd7 }
            r3.<init>()     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r4 = "ur_type"
            r3.putString(r4, r11)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r4 = "ur_type"
            r3.putString(r4, r12)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r4 = "push_message"
            r3.putString(r4, r13)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r4 = "push_title"
            r3.putString(r4, r14)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r4 = "utm_source"
            r3.putString(r4, r15)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r4 = "utm_temd"
            r3.putString(r4, r6)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r4 = "push_request_code"
            r6 = 10
            r3.putInt(r4, r6)     // Catch:{ Exception -> 0x0cd7 }
            r7.setExtras(r3)     // Catch:{ Exception -> 0x0cd7 }
            r7.setRequiredNetworkType(r5)     // Catch:{ Exception -> 0x0cd7 }
            r3 = 0
            r7.setRequiresCharging(r3)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r3 = "jobscheduler"
            java.lang.Object r0 = r0.getSystemService(r3)     // Catch:{ Exception -> 0x0cd7 }
            android.app.job.JobScheduler r0 = (android.app.job.JobScheduler) r0     // Catch:{ Exception -> 0x0cd7 }
            android.app.job.JobInfo r3 = r7.build()     // Catch:{ Exception -> 0x0cd7 }
            int r0 = r0.schedule(r3)     // Catch:{ Exception -> 0x0cd7 }
            goto L_0x0cdf
        L_0x0c94:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x0cd7 }
            java.lang.Class<com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisher> r4 = com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisher.class
            r3.<init>(r0, r4)     // Catch:{ Exception -> 0x0cd7 }
            r10 = r0
            r16 = r6
            android.app.Notification r4 = com.travel.bus.busticket.InAppPushNotification.a.a(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r5 = com.travel.bus.busticket.InAppPushNotification.CJRNotificationPublisher.f21522a     // Catch:{ Exception -> 0x0cd7 }
            r3.putExtra(r5, r4)     // Catch:{ Exception -> 0x0cd7 }
            java.lang.String r4 = "push_request_code"
            r5 = 10
            r3.putExtra(r4, r5)     // Catch:{ Exception -> 0x0cd7 }
            r4 = 134217728(0x8000000, float:3.85186E-34)
            android.app.PendingIntent r3 = android.app.PendingIntent.getBroadcast(r0, r5, r3, r4)     // Catch:{ Exception -> 0x0cd7 }
            com.travel.bus.a.a()     // Catch:{ Exception -> 0x0cd7 }
            com.travel.g.a r4 = com.travel.bus.a.b()     // Catch:{ Exception -> 0x0cd7 }
            int r4 = r4.E()     // Catch:{ Exception -> 0x0cd7 }
            if (r4 != 0) goto L_0x0cc4
            r4 = 1800000(0x1b7740, float:2.522337E-39)
        L_0x0cc4:
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0cd7 }
            long r7 = (long) r4     // Catch:{ Exception -> 0x0cd7 }
            long r5 = r5 + r7
            java.lang.String r4 = "alarm"
            java.lang.Object r0 = r0.getSystemService(r4)     // Catch:{ Exception -> 0x0cd7 }
            android.app.AlarmManager r0 = (android.app.AlarmManager) r0     // Catch:{ Exception -> 0x0cd7 }
            r4 = 2
            r0.set(r4, r5, r3)     // Catch:{ Exception -> 0x0cd7 }
            goto L_0x0cdf
        L_0x0cd7:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x0cdf:
            com.travel.bus.a.a()
            com.travel.g.a r0 = com.travel.bus.a.b()
            java.lang.String r3 = "/bus-tickets-review"
            r0.a((java.lang.String) r3, (java.lang.String) r2, (android.content.Context) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRConfirmBookingActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        g();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        this.f21931f.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            this.aw = true;
        } else {
            this.aw = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        com.travel.bus.b.a.a(getApplicationContext()).a("payment_tip_key", true, false);
        this.aK.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        ArrayList<TripBusDetailsItem> arrayList;
        this.C = z2;
        CJRBusInsurancePlans cJRBusInsurancePlans = this.ay;
        this.an = cJRBusInsurancePlans != null ? cJRBusInsurancePlans.getInsuranceAtIndex(0) : null;
        if (!(!this.ah.isChecked() || (arrayList = this.p) == null || arrayList.size() <= 0 || this.an == null || this.D == null)) {
            RoboTextView roboTextView = this.aq;
            roboTextView.setText(getResources().getString(R.string.rs) + (this.D.getPrice() * ((double) this.p.size())));
        }
        this.aM = a(this.aN);
        d();
    }

    private void d() {
        this.aO.setText(com.paytm.utility.b.a(this.aM, "###,###,###.##"));
        com.travel.bus.a.a();
        if (!com.travel.bus.a.b().O()) {
            this.x.setText(getString(R.string.busticket_proceed_to_pay, new Object[]{Double.valueOf(this.aM)}));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        g();
    }

    /* access modifiers changed from: private */
    public void e() {
        int i2;
        Resources resources;
        ArrayList<CJROfferCode> arrayList = this.K;
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                resources = getResources();
                i2 = R.string.bus_more_offer;
            } else {
                resources = getResources();
                i2 = R.string.bus_more_offers;
            }
            String string = resources.getString(i2);
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(R.string.view_text));
            sb.append(" ");
            sb.append(this.K.size() - 2);
            sb.append(string);
            sb.append(getResources().getString(R.string.bus_have_a_promocode_text));
            this.J.setText(sb.toString());
            return;
        }
        this.J.setText(R.string.have_promocode_text_str);
    }

    /* access modifiers changed from: private */
    public void f() {
        int i2;
        Resources resources;
        this.F.setVisibility(0);
        this.F.findViewById(R.id.progress_bar_offers).setVisibility(8);
        CJRBusOffers cJRBusOffers = this.G;
        if (cJRBusOffers == null || cJRBusOffers.getOfferCodes() == null || this.G.getOfferCodes().size() <= 0) {
            this.J.setText(R.string.have_promocode_text_str);
        } else {
            this.F.findViewById(R.id.txt_offers_title).setVisibility(0);
            this.F.findViewById(R.id.bus_offers_layout).setVisibility(0);
            if (this.K.size() == 1) {
                resources = getResources();
                i2 = R.string.bus_more_offer;
            } else {
                resources = getResources();
                i2 = R.string.bus_more_offers;
            }
            String string = resources.getString(i2);
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(R.string.view_text));
            sb.append(" ");
            sb.append(this.K.size() - 2);
            sb.append(" ");
            sb.append(string);
            sb.append(" ");
            sb.append(getResources().getString(R.string.bus_have_a_promocode_text));
            this.J.setText(sb.toString());
        }
        b((String) null);
    }

    private void b(String str) {
        LinearLayout linearLayout = (LinearLayout) this.F.findViewById(R.id.lyt_offers_list_container);
        linearLayout.removeAllViews();
        CJRBusOffers cJRBusOffers = this.G;
        if (!(cJRBusOffers == null || cJRBusOffers.getOfferCodes() == null)) {
            int i2 = 0;
            if (this.G.getOfferCodes().size() >= 2) {
                m mVar = new m(this, this.G.getOfferCodes(), this, str, 2);
                while (i2 < mVar.getCount()) {
                    linearLayout.addView(mVar.getView(i2, (View) null, (ViewGroup) null));
                    i2++;
                }
            } else {
                m mVar2 = new m(this, this.G.getOfferCodes(), this, (String) null, this.G.getOfferCodes().size());
                while (i2 < mVar2.getCount()) {
                    linearLayout.addView(mVar2.getView(i2, (View) null, (ViewGroup) null));
                    i2++;
                }
            }
        }
        this.J.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRConfirmBookingActivity.this.c(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        String str = d.cJ;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(str, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        g();
    }

    private void g() {
        Intent intent = new Intent(this, AJRBusOfferListActivity.class);
        intent.putExtra("intent_extra_offers_list", this.K);
        intent.putExtra("intent_extra_selected_seats", this.p);
        intent.putExtra("intent_extra_bus_search_result_item", this.s);
        intent.putExtra("intent_extra_bus_search_input", this.o);
        intent.putExtra("intent_extra_bus_search_input", this.o);
        intent.putExtra("total_fare", this.aM);
        intent.putExtra("cart_applied_promo", this.y);
        intent.putExtra("intent_block_ticket_response_data", this.N);
        startActivityForResult(intent, h.f22433a);
    }

    private void h() {
        this.f21933h = new e();
        Bundle bundle = new Bundle();
        bundle.putSerializable("bus_search_input_intent", this.o);
        bundle.putSerializable("bus_search_item_intent", this.s);
        bundle.putSerializable("bus_select_insurance_intent", this.an);
        bundle.putSerializable("bus_select_seat_intent", this.p);
        bundle.putSerializable("bus_insurance_plan_intent", this.ay);
        bundle.putBoolean("bus_insurance_check_box_intent", this.ah.isChecked());
        bundle.putSerializable("bus_block_data_intent", this.N);
        bundle.putSerializable("bus_cancellation_policy_intent", this.ax);
        bundle.putDouble("bus_grand_total_intent", this.aM);
        bundle.putSerializable("bus_confirm_trip_intent", this.am);
        this.f21933h.setArguments(bundle);
        this.f21933h.show(getSupportFragmentManager(), "busFareBreakUpListBottomDialogFragment");
    }

    private double a(double d2) {
        if (((!this.C || !this.ah.isChecked()) && this.an != null) || this.an == null) {
            return d2;
        }
        ArrayList<TripBusDetailsItem> arrayList = this.p;
        return d2 + (this.an.getPrice() * ((double) (arrayList != null ? arrayList.size() : 0)));
    }

    private void i() {
        CJRBusSearchItem cJRBusSearchItem = this.s;
        if (!(cJRBusSearchItem == null || cJRBusSearchItem.getTravelsName() == null)) {
            this.k.setText(this.s.getTravelsName());
        }
        if (f21925i || this.s != null) {
            StringBuilder sb = new StringBuilder();
            CJRBusSearchItem cJRBusSearchItem2 = this.s;
            if (cJRBusSearchItem2 == null) {
                return;
            }
            if (cJRBusSearchItem2.getBusTypeTags() != null) {
                int size = this.s.getBusTypeTags().size();
                String str = "";
                for (int i2 = 0; i2 < size; i2++) {
                    String str2 = this.s.getBusTypeTags().get(i2);
                    if (i2 == size - 1) {
                        sb.append(str2);
                        str = sb.toString().toUpperCase();
                    } else {
                        sb.append(str2);
                        sb.append(", ");
                        str = sb.toString().toUpperCase();
                    }
                }
                this.l.setText(str);
                return;
            }
            CJRBusSearchItem cJRBusSearchItem3 = this.s;
            if (cJRBusSearchItem3 != null && cJRBusSearchItem3.getBusTypeName() != null) {
                this.l.setText(this.s.getBusTypeName());
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    private void j() {
        ArrayList arrayList = null;
        try {
            if (this.w != null && this.w.size() > 0) {
                Iterator<Map.Entry<String, CJRBusSearchOperatorTagInfo>> it2 = this.w.entrySet().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Map.Entry next = it2.next();
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        if (this.s.getOperatorTags() != null && this.s.getOperatorTags().size() > 0) {
                            for (int i2 = 0; i2 < this.s.getOperatorTags().size(); i2++) {
                                if (((String) next.getKey()).equals(Integer.valueOf(this.s.getOperatorTags().get(i2).intValue())) && ((CJRBusSearchOperatorTagInfo) next.getValue()).getTagType() != "OFFER") {
                                    arrayList.add(((CJRBusSearchOperatorTagInfo) next.getValue()).getLabel());
                                }
                            }
                        }
                    } else {
                        this.f21929d = new ai(arrayList);
                        this.f21930e = new LinearLayoutManager(this, 0, false);
                        this.aH.setLayoutManager(this.f21930e);
                        this.aH.setAdapter(this.f21929d);
                        return;
                    }
                }
            }
        } catch (NullPointerException e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
    }

    private static String c(String str) {
        try {
            return new SimpleDateFormat("dd MMM").format(new SimpleDateFormat("yyyy-MM-dd").parse(str));
        } catch (ParseException e2) {
            com.paytm.utility.q.c(e2.getMessage());
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0 A[Catch:{ Exception -> 0x0116 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.ArrayList<com.travel.bus.pojo.busticket.TripBusDetailsItem> r23) {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            java.lang.String r2 = ""
            r3 = 0
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r4 = r1.t     // Catch:{ Exception -> 0x0119 }
            if (r4 == 0) goto L_0x0121
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r4 = r1.t     // Catch:{ Exception -> 0x0119 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0119 }
            r5 = r2
            r6 = 0
        L_0x0013:
            boolean r7 = r4.hasNext()     // Catch:{ Exception -> 0x0116 }
            if (r7 == 0) goto L_0x0114
            java.lang.Object r7 = r4.next()     // Catch:{ Exception -> 0x0116 }
            com.travel.bus.pojo.busticket.CJRPassengerDetails r7 = (com.travel.bus.pojo.busticket.CJRPassengerDetails) r7     // Catch:{ Exception -> 0x0116 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            r8.<init>()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r9 = r7.getmTitle()     // Catch:{ Exception -> 0x0116 }
            r8.append(r9)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r9 = " "
            r8.append(r9)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r9 = r7.getPassengerName()     // Catch:{ Exception -> 0x0116 }
            r8.append(r9)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r9 = r7.getGender()     // Catch:{ Exception -> 0x0116 }
            java.lang.String r10 = r7.getSeatNumber()     // Catch:{ Exception -> 0x0116 }
            if (r10 == 0) goto L_0x004a
            java.lang.String r7 = r7.getSeatNumber()     // Catch:{ Exception -> 0x0116 }
            goto L_0x004b
        L_0x004a:
            r7 = r2
        L_0x004b:
            android.widget.LinearLayout r10 = r1.aD     // Catch:{ Exception -> 0x0116 }
            android.content.Context r10 = r10.getContext()     // Catch:{ Exception -> 0x0116 }
            android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r10)     // Catch:{ Exception -> 0x0116 }
            int r11 = com.travel.bus.R.layout.pre_b_bus_review_passenger_list_item     // Catch:{ Exception -> 0x0116 }
            r12 = 0
            android.view.View r10 = r10.inflate(r11, r12, r3)     // Catch:{ Exception -> 0x0116 }
            int r11 = com.travel.bus.R.id.passenger_name     // Catch:{ Exception -> 0x0116 }
            android.view.View r11 = r10.findViewById(r11)     // Catch:{ Exception -> 0x0116 }
            android.widget.TextView r11 = (android.widget.TextView) r11     // Catch:{ Exception -> 0x0116 }
            int r12 = com.travel.bus.R.id.passenger_icon     // Catch:{ Exception -> 0x0116 }
            android.view.View r12 = r10.findViewById(r12)     // Catch:{ Exception -> 0x0116 }
            android.widget.ImageView r12 = (android.widget.ImageView) r12     // Catch:{ Exception -> 0x0116 }
            int r13 = com.travel.bus.R.id.passenger_seat_text     // Catch:{ Exception -> 0x0116 }
            android.view.View r13 = r10.findViewById(r13)     // Catch:{ Exception -> 0x0116 }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x0116 }
            int r14 = com.travel.bus.R.id.passenger_seat_icon     // Catch:{ Exception -> 0x0116 }
            android.view.View r14 = r10.findViewById(r14)     // Catch:{ Exception -> 0x0116 }
            android.widget.ImageView r14 = (android.widget.ImageView) r14     // Catch:{ Exception -> 0x0116 }
            int r15 = com.travel.bus.R.drawable.travel_res_bus_order_summary_male_pax_icon     // Catch:{ Exception -> 0x0116 }
            java.lang.Object r16 = r0.get(r6)     // Catch:{ Exception -> 0x0116 }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r16 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r16     // Catch:{ Exception -> 0x0116 }
            long r16 = r16.getWidth()     // Catch:{ Exception -> 0x0116 }
            r18 = 1
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 > 0) goto L_0x00a0
            java.lang.Object r16 = r0.get(r6)     // Catch:{ Exception -> 0x0116 }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r16 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r16     // Catch:{ Exception -> 0x0116 }
            long r16 = r16.getLength()     // Catch:{ Exception -> 0x0116 }
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 <= 0) goto L_0x009d
            goto L_0x00a0
        L_0x009d:
            int r16 = com.travel.bus.R.drawable.bus_passenger_seat_green     // Catch:{ Exception -> 0x0116 }
            goto L_0x00a2
        L_0x00a0:
            int r16 = com.travel.bus.R.drawable.bus_seat_layout_selected_sleeper_seat_land     // Catch:{ Exception -> 0x0116 }
        L_0x00a2:
            boolean r17 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0116 }
            if (r17 != 0) goto L_0x00d4
            java.lang.String r3 = "female"
            boolean r3 = r9.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0116 }
            if (r3 == 0) goto L_0x00d4
            int r15 = com.travel.bus.R.drawable.travel_res_bus_order_summary_female_pax_icon     // Catch:{ Exception -> 0x0116 }
            java.lang.Object r3 = r0.get(r6)     // Catch:{ Exception -> 0x0116 }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r3 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r3     // Catch:{ Exception -> 0x0116 }
            long r20 = r3.getLength()     // Catch:{ Exception -> 0x0116 }
            int r3 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r3 > 0) goto L_0x00d2
            java.lang.Object r3 = r0.get(r6)     // Catch:{ Exception -> 0x0116 }
            com.travel.bus.pojo.busticket.TripBusDetailsItem r3 = (com.travel.bus.pojo.busticket.TripBusDetailsItem) r3     // Catch:{ Exception -> 0x0116 }
            long r20 = r3.getWidth()     // Catch:{ Exception -> 0x0116 }
            int r3 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r3 <= 0) goto L_0x00cf
            goto L_0x00d2
        L_0x00cf:
            int r16 = com.travel.bus.R.drawable.bus_passenger_seat_ladies     // Catch:{ Exception -> 0x0116 }
            goto L_0x00d4
        L_0x00d2:
            int r16 = com.travel.bus.R.drawable.bus_seat_layout_ladies_booked_sleeper_seat_land     // Catch:{ Exception -> 0x0116 }
        L_0x00d4:
            r3 = r16
            r11.setText(r8)     // Catch:{ Exception -> 0x0116 }
            r13.setText(r7)     // Catch:{ Exception -> 0x0116 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0116 }
            r8.<init>()     // Catch:{ Exception -> 0x0116 }
            r8.append(r5)     // Catch:{ Exception -> 0x0116 }
            r8.append(r7)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r7 = ", "
            r8.append(r7)     // Catch:{ Exception -> 0x0116 }
            java.lang.String r5 = r8.toString()     // Catch:{ Exception -> 0x0116 }
            android.widget.LinearLayout r7 = r1.aD     // Catch:{ Exception -> 0x0116 }
            android.content.Context r7 = r7.getContext()     // Catch:{ Exception -> 0x0116 }
            android.graphics.drawable.Drawable r7 = androidx.core.content.b.a((android.content.Context) r7, (int) r15)     // Catch:{ Exception -> 0x0116 }
            r12.setImageDrawable(r7)     // Catch:{ Exception -> 0x0116 }
            android.widget.LinearLayout r7 = r1.aD     // Catch:{ Exception -> 0x0116 }
            android.content.Context r7 = r7.getContext()     // Catch:{ Exception -> 0x0116 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r7, (int) r3)     // Catch:{ Exception -> 0x0116 }
            r14.setImageDrawable(r3)     // Catch:{ Exception -> 0x0116 }
            android.widget.LinearLayout r3 = r1.aD     // Catch:{ Exception -> 0x0116 }
            r3.addView(r10)     // Catch:{ Exception -> 0x0116 }
            int r6 = r6 + 1
            r3 = 0
            goto L_0x0013
        L_0x0114:
            r2 = r5
            goto L_0x0121
        L_0x0116:
            r0 = move-exception
            r2 = r5
            goto L_0x011a
        L_0x0119:
            r0 = move-exception
        L_0x011a:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.c(r0)
        L_0x0121:
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r0 = r1.t
            int r0 = r0.size()
            r3 = 1
            if (r0 <= r3) goto L_0x0165
            android.widget.TextView r0 = r1.T
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r4 = r1.t
            int r4 = r4.size()
            r3.append(r4)
            java.lang.String r4 = " Travellers"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
            com.paytm.utility.RoboTextView r0 = r1.aE
            android.content.res.Resources r3 = r22.getResources()
            int r4 = com.travel.bus.R.string.bus_passengers
            java.lang.String r3 = r3.getString(r4)
            r0.setText(r3)
            com.paytm.utility.RoboTextView r0 = r1.aF
            android.content.res.Resources r3 = r22.getResources()
            int r4 = com.travel.bus.R.string.bus_seats
            java.lang.String r3 = r3.getString(r4)
            r0.setText(r3)
            goto L_0x019f
        L_0x0165:
            com.paytm.utility.RoboTextView r0 = r1.aE
            android.content.res.Resources r3 = r22.getResources()
            int r4 = com.travel.bus.R.string.bus_passenger
            java.lang.String r3 = r3.getString(r4)
            r0.setText(r3)
            com.paytm.utility.RoboTextView r0 = r1.aF
            android.content.res.Resources r3 = r22.getResources()
            int r4 = com.travel.bus.R.string.bus_seat
            java.lang.String r3 = r3.getString(r4)
            r0.setText(r3)
            android.widget.TextView r0 = r1.T
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.util.ArrayList<com.travel.bus.pojo.busticket.CJRPassengerDetails> r4 = r1.t
            int r4 = r4.size()
            r3.append(r4)
            java.lang.String r4 = " Traveller"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.setText(r3)
        L_0x019f:
            android.widget.TextView r0 = r1.U
            int r3 = r2.length()
            int r3 = r3 + -2
            r4 = 0
            java.lang.String r2 = r2.substring(r4, r3)
            r0.setText(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.activity.AJRConfirmBookingActivity.a(java.util.ArrayList):void");
    }

    private void a(int i2) {
        CountDownTimer countDownTimer = this.O;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final TextView textView = (TextView) findViewById(R.id.count_down_text);
        ((RelativeLayout) findViewById(R.id.timer_lyt)).setVisibility(0);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.timer_bg_view);
        final int i3 = i2;
        this.O = new CountDownTimer((long) (i2 * 1000)) {

            /* renamed from: a  reason: collision with root package name */
            final int f21939a = (i3 * 1000);

            public final void onTick(long j) {
                try {
                    long unused = AJRConfirmBookingActivity.this.Q = TimeUnit.MILLISECONDS.toMinutes(j);
                    long unused2 = AJRConfirmBookingActivity.this.R = TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j));
                    textView.setText(String.format(AJRConfirmBookingActivity.this.P, new Object[]{Long.valueOf(AJRConfirmBookingActivity.this.Q), Long.valueOf(AJRConfirmBookingActivity.this.R)}));
                    int i2 = (int) (((double) (((float) j) / ((float) this.f21939a))) * 1000.0d);
                    progressBar.setProgress(i2);
                    if (i2 < 300) {
                        progressBar.setProgressDrawable(AJRConfirmBookingActivity.this.getResources().getDrawable(R.drawable.rounded_corners_progress_bar_red));
                        textView.setTextColor(AJRConfirmBookingActivity.this.getResources().getColor(R.color.color_fd5c5c));
                    }
                } catch (Exception e2) {
                    com.paytm.utility.q.c(e2.getMessage());
                }
            }

            public final void onFinish() {
                AJRConfirmBookingActivity.this.startActivity(new Intent(AJRConfirmBookingActivity.this, AJRBusSearchSRPActivity.class));
                AJRConfirmBookingActivity.this.finish();
                if (AJRConfirmBookingActivity.this.O != null) {
                    AJRConfirmBookingActivity.this.O.cancel();
                }
            }
        };
        this.O.start();
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 11) {
            new a("").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new a("").execute(new Void[0]);
        }
    }

    private void d(String str) {
        com.travel.bus.a.a();
        String f2 = com.travel.bus.a.b().f("busPromoVerifyUrl");
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
        String e2 = e(str);
        if (o.b(getApplicationContext())) {
            f2 = Uri.parse(f2).buildUpon().appendQueryParameter("is_reseller", "1").build().toString();
        }
        if (com.paytm.utility.b.c((Context) this)) {
            a(true);
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this;
            bVar.f42878b = a.c.BUS;
            bVar.f42879c = a.C0715a.POST;
            bVar.f42880d = f2;
            bVar.f42884h = e2;
            bVar.f42881e = null;
            bVar.f42882f = hashMap;
            bVar.f42883g = null;
            bVar.f42885i = new CJRBusRechargeCart();
            bVar.j = this;
            bVar.t = q();
            bVar.n = a.b.SILENT;
            bVar.o = "bus-review-itinerary-page";
            bVar.l().a();
            return;
        }
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = this;
        bVar2.f42878b = a.c.BUS;
        bVar2.f42879c = a.C0715a.POST;
        bVar2.f42880d = f2;
        bVar2.f42884h = e2;
        bVar2.f42881e = null;
        bVar2.f42882f = hashMap;
        bVar2.f42883g = null;
        bVar2.f42885i = new CJRBusRechargeCart();
        bVar2.j = this;
        bVar2.t = q();
        bVar2.n = a.b.SILENT;
        bVar2.o = "bus-review-itinerary-page";
        bVar2.l().a();
    }

    private String e(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", this.N.getBlockResponse().getRequestId());
            jSONObject.put("order_id", this.N.getBlockResponse().getTicketId());
            jSONObject.put(PayUtility.PROMO_CODE, str);
            jSONObject.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
        } catch (JSONException e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        return jSONObject.toString();
    }

    private void a(boolean z2) {
        if (z2) {
            findViewById(R.id.lyt_progress_bar).setVisibility(0);
        } else {
            findViewById(R.id.lyt_progress_bar).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void a(CJRRechargePayment cJRRechargePayment) {
        Intent intent = new Intent();
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        intent.putExtra("is_bus_ticket", true);
        intent.putExtra("vertical_name", a.c.BUS);
        intent.putExtra(UpiConstants.FROM, "Tickets");
        String a2 = g.a(cJRRechargePayment);
        if (!TextUtils.isEmpty(a2)) {
            intent.putExtra("price", a2);
            if ("1".equalsIgnoreCase(cJRRechargePayment.isNativeEnabled())) {
                intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
                intent.putExtra("mid", cJRRechargePayment.getMID());
                intent.putExtra("orderid", cJRRechargePayment.getOrderId());
                intent.putExtra("nativeSdkEnabled", true);
            } else {
                intent.putExtra("nativeSdkEnabled", false);
            }
        }
        com.travel.bus.a.a();
        com.travel.bus.a.b().c(this, intent);
    }

    /* access modifiers changed from: private */
    public void a(Intent intent, String str) {
        PaytmSDK.parseAndSetInstruments(str);
        com.travel.bus.a.a();
        com.travel.bus.a.b().c(this, intent);
    }

    private static CJRRechargePayment a(CJRBusPayment cJRBusPayment) {
        CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
        cJRRechargePayment.setmCode(cJRBusPayment.getCode());
        cJRRechargePayment.setmError(cJRBusPayment.getError());
        cJRRechargePayment.setmMID(cJRBusPayment.getMID());
        cJRRechargePayment.setmOrderId(cJRBusPayment.getOrderId());
        cJRRechargePayment.setmPGParams(cJRBusPayment.getPGParams());
        cJRRechargePayment.setmPGUrlToHit(cJRBusPayment.getPGUrlToHit());
        cJRRechargePayment.setmResult(cJRBusPayment.getmResult());
        cJRRechargePayment.setmStatus(cJRBusPayment.getmStatus());
        cJRRechargePayment.setmNativeEnabled(cJRBusPayment.isNativeEnabled());
        cJRRechargePayment.setmTxnToken(cJRBusPayment.getmTxnToken());
        return cJRRechargePayment;
    }

    private void a(CJRBusRechargeCart cJRBusRechargeCart) {
        if (cJRBusRechargeCart.getCartStatus().getResult().equalsIgnoreCase("SUCCESS")) {
            d(cJRBusRechargeCart);
            this.H = cJRBusRechargeCart.getCart();
            CJRCart cJRCart = this.H;
            if (!(cJRCart == null || cJRCart.getPromoText() == null || this.H.getPromoText().trim().length() <= 0)) {
                String promoText = this.H.getPromoText();
                RoboTextView roboTextView = (RoboTextView) findViewById(R.id.txt_promo_success_message);
                roboTextView.setMovementMethod(LinkMovementMethod.getInstance());
                String str = " " + getResources().getString(R.string.view_t_and_c);
                SpannableString spannableString = new SpannableString(promoText + str + " ");
                spannableString.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        try {
                            textPaint.setUnderlineText(false);
                            textPaint.setColor(androidx.core.content.b.c(AJRConfirmBookingActivity.this, R.color.color_323232));
                        } catch (Exception unused) {
                        }
                    }
                }, 0, promoText.length(), 33);
                spannableString.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        if (AJRConfirmBookingActivity.this.aR != null && !AJRConfirmBookingActivity.this.aR.isEmpty() && AJRConfirmBookingActivity.this.aS != null && !AJRConfirmBookingActivity.this.aS.isEmpty()) {
                            AJRConfirmBookingActivity aJRConfirmBookingActivity = AJRConfirmBookingActivity.this;
                            com.paytm.utility.b.b((Context) aJRConfirmBookingActivity, aJRConfirmBookingActivity.aS, Html.fromHtml(AJRConfirmBookingActivity.this.aR).toString());
                        }
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        try {
                            q.a(AJRConfirmBookingActivity.this);
                            textPaint.setUnderlineText(false);
                            textPaint.setColor(androidx.core.content.b.c(AJRConfirmBookingActivity.this, R.color.bus_paytm_blue));
                        } catch (Exception unused) {
                        }
                    }
                }, promoText.length() + 1, promoText.length() + str.length(), 33);
                roboTextView.setText(spannableString);
                if (!this.H.getPaytmCashBack().equalsIgnoreCase("0")) {
                    ((TextView) findViewById(R.id.txt_cash_back_info)).setVisibility(0);
                    ((TextView) findViewById(R.id.txt_cash_back_info)).setText(getString(R.string.bus_cashback, new Object[]{this.H.getPaytmCashBack()}));
                } else {
                    ((TextView) findViewById(R.id.txt_cash_back_info)).setVisibility(8);
                }
                this.J.setVisibility(8);
                this.F.setVisibility(8);
            }
        }
        if (this.B) {
            b(cJRBusRechargeCart);
        }
    }

    private void b(CJRBusRechargeCart cJRBusRechargeCart) {
        CJRCart cart = cJRBusRechargeCart.getCart();
        if (cart == null || cart.getPromoStatus() == null || !cart.getPromoStatus().equalsIgnoreCase("SUCCESS")) {
            this.L.setVisibility(8);
            if (!this.M) {
                m();
                c(cJRBusRechargeCart);
                f();
                return;
            }
            return;
        }
        this.y = cart.getPaytmPromocode();
        if (this.y == null) {
            this.y = this.u.getText();
        }
        if (this.y != null) {
            ((TextView) findViewById(R.id.offer_promo_text)).setText(this.y + " Applied");
            int i2 = 0;
            while (true) {
                if (i2 >= this.G.getOfferCodes().size()) {
                    break;
                } else if (this.y.equals(this.G.getOfferCodes().get(i2).getCode())) {
                    this.aR = this.G.getOfferCodes().get(i2).getTerms();
                    this.aS = this.G.getOfferCodes().get(i2).getTermsTitle();
                    break;
                } else {
                    i2++;
                }
            }
            this.L.setVisibility(0);
            HashMap hashMap = new HashMap();
            hashMap.put("event_label", this.y);
            hashMap.put("event_label2", this.o.getSource().getDisplayCityName() + "/" + this.o.getDestination().getDisplayCityName());
            try {
                hashMap.put("event_label3", this.am.getMeta().getProvider().getName());
            } catch (Exception e2) {
                com.paytm.utility.q.c(e2.getMessage());
            }
            hashMap.put("userid", com.paytm.utility.b.n((Context) this));
            com.travel.bus.a.a();
            com.travel.bus.a.a("customEvent", "/bus-tickets-review", "bus_review", "promocode_applied", hashMap);
            this.J.setVisibility(8);
            if (this.A) {
                k();
                return;
            }
            return;
        }
        this.L.setVisibility(8);
        if (!this.M) {
            m();
            c(cJRBusRechargeCart);
            f();
        }
    }

    private void c(CJRBusRechargeCart cJRBusRechargeCart) {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton(getResources().getString(R.string.ok), $$Lambda$AJRConfirmBookingActivity$raLpU_gjewQ5PakmUjYSgKNfjbk.INSTANCE);
            String promoFailureText = cJRBusRechargeCart.getCart().getPromoFailureText();
            builder.setTitle(getResources().getString(R.string.bus_msg_invalid_recharge_promo_code_title));
            if (promoFailureText == null || promoFailureText.trim().length() <= 0) {
                builder.setMessage(getResources().getString(R.string.bus_msg_invalid_recharge_promo_code));
            } else {
                builder.setMessage(promoFailureText);
            }
            builder.create().show();
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Review Itinerary Screen");
            hashMap.put("bus_promocode_error", cJRBusRechargeCart.getCart().getPromoFailureText());
            com.travel.bus.a.a();
            com.travel.bus.a.b().a("bus_review_promocode_error", (Map<String, Object>) hashMap, (Context) this);
        }
        this.u.a();
    }

    private void m() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_review");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-review");
        hashMap.put("event_label", " ");
        hashMap.put("event_action", "promocode_error");
        hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    private void d(CJRBusRechargeCart cJRBusRechargeCart) {
        CJRCart cart = cJRBusRechargeCart.getCart();
        if (cart != null) {
            String finalPriceExclShipping = cart.getFinalPriceExclShipping();
            this.aM = a(Double.parseDouble(finalPriceExclShipping));
            this.aO.setText(com.paytm.utility.b.b(finalPriceExclShipping, "###,###,###.##"));
            if (!TextUtils.isEmpty(finalPriceExclShipping) && com.paytm.utility.b.a(this.aM, "###,###,###.##") != null) {
                this.x = (Button) findViewById(R.id.btn_pay_now);
                d();
            }
        }
    }

    private void n() {
        this.x = (Button) findViewById(R.id.btn_pay_now);
        if (com.paytm.utility.b.a(this.aM, "###,###,###.##") != null) {
            d();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        setResult(3);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        startActivity(intent);
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) this, intent);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_pay_now) {
            o();
        } else if (id != R.id.apply_btn && id == R.id.rl_remove) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getResources().getString(R.string.remove_code_title)).setMessage(getResources().getString(R.string.remove_code_msg)).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AJRConfirmBookingActivity.this.d(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(getResources().getString(R.string.no), $$Lambda$AJRConfirmBookingActivity$H3CquNG_1wb98nh0tcHvqJXsR5E.INSTANCE);
            builder.show();
        }
    }

    private void o() {
        if (!com.travel.bus.busticket.i.c.b(this)) {
            com.travel.bus.busticket.i.c.a(this);
            return;
        }
        p();
        HashMap hashMap = new HashMap();
        hashMap.put("event_label", String.format("%.2f", new Object[]{Double.valueOf(this.aM)}));
        hashMap.put("event_label2", this.o.getSource().getDisplayCityName() + "/" + this.o.getDestination().getDisplayCityName());
        try {
            hashMap.put("event_label3", this.am.getMeta().getProvider().getName());
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        hashMap.put("userid", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets-review", "bus_review", Events.Action.PROCEED_CLICKED, hashMap);
        this.x.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                AJRConfirmBookingActivity.this.r();
            }
        }, 5000);
        l();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r() {
        if (!isFinishing()) {
            this.x.setEnabled(true);
        }
    }

    public final void a(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.f21926a;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f21926a = new ProgressDialog(context);
                try {
                    this.f21926a.setProgressStyle(0);
                    this.f21926a.setMessage(str);
                    this.f21926a.setCancelable(false);
                    this.f21926a.setCanceledOnTouchOutside(false);
                    this.f21926a.show();
                } catch (IllegalArgumentException e2) {
                    com.paytm.utility.q.c(e2.getMessage());
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void a() {
        ProgressDialog progressDialog = this.f21926a;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.f21926a.dismiss();
            this.f21926a = null;
        }
    }

    private void p() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("bus_fare_total", Double.valueOf(this.aM));
            hashMap.put("event_label2", this.am.getMeta().getProvider().getName());
            com.travel.bus.a.a();
            com.travel.bus.a.b().a("bus_review_proceed_clicked", (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.c(e2.getMessage());
            }
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        q.a(this);
        if (i3 != -1 && i3 != 0) {
            return;
        }
        if (i2 == h.f22433a) {
            if (intent == null) {
                return;
            }
            if (intent.hasExtra("cart_object")) {
                this.M = true;
                CJRBusRechargeCart cJRBusRechargeCart = (CJRBusRechargeCart) intent.getSerializableExtra("cart_object");
                if (cJRBusRechargeCart == null || cJRBusRechargeCart.getCart() == null) {
                    this.y = null;
                    this.L.setVisibility(8);
                    this.u.a();
                    this.J.setVisibility(0);
                    f();
                    return;
                }
                b(cJRBusRechargeCart.getCart().getPaytmPromocode());
                if (cJRBusRechargeCart.getCart().getPromoStatus().equalsIgnoreCase("success")) {
                    this.J.setVisibility(8);
                    this.L.setVisibility(0);
                } else {
                    this.L.setVisibility(8);
                    this.u.a();
                    this.J.setVisibility(0);
                    f();
                }
                this.y = cJRBusRechargeCart.getCart().getPaytmPromocode();
                this.B = true;
                a(cJRBusRechargeCart);
                n();
                d(cJRBusRechargeCart);
                return;
            }
            this.y = null;
            this.L.setVisibility(8);
            this.u.a();
            this.J.setVisibility(0);
            f();
        } else if (i2 == 223) {
            finish();
            Intent intent2 = new Intent(this, AJRBusSearchSRPActivity.class);
            intent2.addFlags(67108864);
            intent2.addFlags(268435456);
            startActivity(intent2);
        } else if (i2 != 1) {
        } else {
            if (i3 == -1) {
                l();
            } else {
                this.x.setEnabled(true);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.O;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public final void a(int i2, IJRPaytmDataModel iJRPaytmDataModel) {
        boolean z2;
        String str = null;
        if (i2 == 0) {
            CJRBusInsurancePlans cJRBusInsurancePlans = (CJRBusInsurancePlans) iJRPaytmDataModel;
            this.ay = cJRBusInsurancePlans;
            int code = cJRBusInsurancePlans != null ? cJRBusInsurancePlans.getCode() : -1;
            int plansCount = cJRBusInsurancePlans != null ? cJRBusInsurancePlans.getPlansCount() : 0;
            if (code != 200 || cJRBusInsurancePlans == null || plansCount <= 0) {
                a(false, (CJRBusInsuranceItem) null);
            } else {
                a(this.C, cJRBusInsurancePlans.getInsuranceAtIndex(0));
            }
        } else if (i2 == 2) {
            ArrayList<CJRPGToken> pGTokenList = ((CJRPGTokenList) iJRPaytmDataModel).getPGTokenList();
            if (pGTokenList != null) {
                int size = pGTokenList.size();
                long j2 = 0;
                String str2 = null;
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    CJRPGToken cJRPGToken = pGTokenList.get(i3);
                    String[] split = cJRPGToken.getScopes().split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                    int length = split.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            if (!TextUtils.isEmpty(split[i4]) && split[i4].equalsIgnoreCase("wallet")) {
                                z2 = true;
                                break;
                            }
                            i4++;
                        } else {
                            z2 = false;
                            break;
                        }
                    }
                    if (z2) {
                        str = cJRPGToken.getToken();
                        j2 = cJRPGToken.getExpires();
                        break;
                    }
                    if (str2 == null) {
                        str2 = cJRPGToken.getResourceOwnerId();
                    }
                    i3++;
                }
                p.a(j2);
                p.a(str);
                p.b(str2);
            }
            if (TextUtils.isEmpty(str)) {
                a();
            } else if (Build.VERSION.SDK_INT >= 11) {
                new a(str).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new a(str).execute(new Void[0]);
            }
        } else if (i2 == 4) {
            this.au = (CJRBusPaytmCash) iJRPaytmDataModel;
            CJRBusPaytmCash cJRBusPaytmCash = this.au;
            if (cJRBusPaytmCash != null && cJRBusPaytmCash.getResponse() != null && ((double) ((int) this.au.getResponse().getAmount())) >= this.aM) {
                this.av = true;
                this.as.setVisibility(0);
            }
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        boolean z2 = false;
        a(false);
        a();
        if (iJRPaytmDataModel instanceof CJRBusRechargeCart) {
            this.M = false;
            this.aC = (CJRBusRechargeCart) iJRPaytmDataModel;
            a(this.aC);
        } else if (iJRPaytmDataModel instanceof CJRBusVerifyDeferred) {
            a();
            final CJRBusVerifyDeferred cJRBusVerifyDeferred = (CJRBusVerifyDeferred) iJRPaytmDataModel;
            final Intent intent = new Intent();
            CJRRechargePayment paymentInfo = cJRBusVerifyDeferred.getPaymentInfo();
            intent.putExtra(SDKConstants.PAYMENT_INFO, paymentInfo);
            intent.putExtra("is_bus_ticket", true);
            intent.putExtra("vertical_name", a.c.BUS);
            intent.putExtra(UpiConstants.FROM, "Tickets");
            String a2 = g.a(paymentInfo);
            if (!TextUtils.isEmpty(a2)) {
                intent.putExtra("price", a2);
                intent.putExtra("txnToken", paymentInfo.getmTxnToken());
                intent.putExtra("mid", paymentInfo.getMID());
                intent.putExtra("orderid", paymentInfo.getOrderId());
                intent.putExtra("nativeSdkEnabled", true);
            }
            intent.putExtra("is_deferred_checkout_bus", true);
            intent.putExtra("isDeferredCheckoutEnable", true);
            com.travel.bus.a.a();
            intent.putExtra("bus_checkout_url", com.travel.bus.a.b().S());
            intent.putExtra("is_reseller", o.b(getApplicationContext()));
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("coupon_code", !TextUtils.isEmpty(this.y) ? this.y : "");
                jSONObject.put("request_id", this.I);
                if (!(this.N == null || this.N.getBlockResponse() == null)) {
                    jSONObject.put("ticket_id", this.N.getBlockResponse().getTicketId());
                }
                jSONObject.put("user_id", com.paytm.utility.b.n((Context) this));
                jSONObject.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
                String a3 = com.travel.bus.busticket.i.g.a();
                if (!TextUtils.isEmpty(a3)) {
                    if (!TextUtils.isEmpty(com.travel.bus.busticket.i.g.a())) {
                        com.travel.bus.a.a();
                        if (System.currentTimeMillis() < com.travel.bus.b.a.a(com.travel.bus.a.b().D()).b("wallet_token_expire=", 0, true)) {
                            z2 = true;
                        }
                    }
                    if (z2) {
                        jSONObject.put("wallet_token", a3);
                        intent.putExtra("bus_checkout_params", jSONObject.toString());
                        a(intent, cJRBusVerifyDeferred.getPaymentInstruments());
                        System.out.println("Deferred checkout : verify response received!");
                    }
                }
                a((Context) this, getResources().getString(R.string.please_wait_progress_msg));
                com.travel.bus.a.a();
                com.travel.bus.a.b().a(a.c.BUS, (Activity) this, (b) new b() {
                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    }

                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        AJRConfirmBookingActivity.this.a();
                        if (iJRPaytmDataModel instanceof CJRPGTokenList) {
                            com.travel.bus.a.a();
                            try {
                                jSONObject.put("wallet_token", com.travel.bus.a.b().a((CJRPGTokenList) iJRPaytmDataModel));
                                intent.putExtra("bus_checkout_params", jSONObject.toString());
                                AJRConfirmBookingActivity.this.a(intent, cJRBusVerifyDeferred.getPaymentInstruments());
                            } catch (JSONException e2) {
                                com.paytm.utility.q.c(e2.getMessage());
                            }
                        }
                    }
                });
            } catch (JSONException e2) {
                com.paytm.utility.q.c(e2.getMessage());
            }
            System.out.println("Deferred checkout : verify response received!");
        } else if (iJRPaytmDataModel instanceof CJRBusPayment) {
            this.az = true;
            CJRBusPayment cJRBusPayment = (CJRBusPayment) iJRPaytmDataModel;
            a();
            if ("open_seat_layout".equalsIgnoreCase(cJRBusPayment.getAction())) {
                Intent intent2 = new Intent();
                intent2.putExtra("bus_confirmation_intent", cJRBusPayment.getAction());
                setResult(11, intent2);
                finish();
            } else if (cJRBusPayment.getStatus() != null && cJRBusPayment.getStatus().equalsIgnoreCase("SUCCESS") && "1".equalsIgnoreCase(cJRBusPayment.isNativeEnabled())) {
                final CJRRechargePayment a4 = a(cJRBusPayment);
                AnonymousClass10 r5 = new FetchPayOptionsListener() {
                    public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
                    }

                    public final void onVpaReceived(VpaFetch vpaFetch) {
                    }

                    public final void onRequestStart() {
                        AJRConfirmBookingActivity aJRConfirmBookingActivity = AJRConfirmBookingActivity.this;
                        aJRConfirmBookingActivity.a((Context) aJRConfirmBookingActivity, aJRConfirmBookingActivity.getResources().getString(R.string.please_wait_progress_msg));
                    }

                    public final void onPaymentOptionsError() {
                        AJRConfirmBookingActivity.this.a();
                        AJRConfirmBookingActivity.this.a(a4);
                    }

                    public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
                        PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
                        AJRConfirmBookingActivity.this.a();
                        AJRConfirmBookingActivity.this.a(a4);
                    }
                };
                PaytmSDK.setServer(Server.PRODUCTION);
                new FetchOptionsRequest((Context) this, a4.getMID(), a4.getOrderId(), a4.getmTxnToken(), (FetchPayOptionsListener) r5).executeRequest();
            } else if (cJRBusPayment.getStatus() != null && cJRBusPayment.getStatus().equalsIgnoreCase("SUCCESS")) {
                a(a(cJRBusPayment));
            }
        } else if (iJRPaytmDataModel instanceof CJRBusPGTokenList) {
            String a5 = p.a((CJRBusPGTokenList) iJRPaytmDataModel);
            if (TextUtils.isEmpty(a5)) {
                a();
            } else if (Build.VERSION.SDK_INT >= 11) {
                new a(a5).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new a(a5).execute(new Void[0]);
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a();
        CJRNewErrorFormat cJRNewErrorFormat = new CJRNewErrorFormat();
        if (networkCustomError.networkResponse != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    cJRNewErrorFormat = (CJRNewErrorFormat) new com.google.gsonhtcfix.f().a(new String(networkResponse.data), cJRNewErrorFormat.getClass());
                } catch (Exception e2) {
                    e2.getMessage();
                }
            }
        }
        try {
            a(false);
            a();
            this.A = false;
            if (networkCustomError != null) {
                if (!(networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 401)) {
                    if (networkCustomError.getStatusCode() != 403) {
                        if (networkCustomError.getStatusCode() == 503) {
                            if (!isFinishing()) {
                                String string = getResources().getString(R.string.bus_maintenance_error_title);
                                String string2 = getResources().getString(R.string.bus_maintenance_error_description);
                                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                                builder.setTitle(string).setMessage(string2).setCancelable(false);
                                builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AJRConfirmBookingActivity.this.a(dialogInterface, i2);
                                    }
                                });
                                builder.show();
                                return;
                            }
                            return;
                        } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                            if (networkCustomError != null) {
                                if (networkCustomError.getAlertMessage() != null) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("event_category", "bus_home");
                                    hashMap.put("event_action", "error_popup");
                                    hashMap.put("event_label", networkCustomError.getAlertMessage());
                                    hashMap.put("event_label2", "client_error");
                                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets");
                                    hashMap.put("vertical_name", "bus");
                                    hashMap.put("user_id", com.paytm.utility.b.n((Context) this));
                                    com.travel.bus.a.a();
                                    com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
                                }
                            }
                            com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
                            return;
                        } else if (networkCustomError.getStatusCode() == 480 && !isFinishing()) {
                            String string3 = getResources().getString(R.string.bus_seat_error_title);
                            String string4 = getResources().getString(R.string.bus_seat_error_description);
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                            builder2.setTitle(string3).setMessage(string4).setCancelable(false);
                            builder2.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AJRConfirmBookingActivity.this.b(dialogInterface, i2);
                                }
                            });
                            builder2.show();
                            return;
                        } else {
                            return;
                        }
                    }
                }
                com.travel.bus.a.a();
                com.travel.bus.a.b().a((Activity) this);
            } else if (cJRNewErrorFormat == null || cJRNewErrorFormat.getStatus() == null || cJRNewErrorFormat.getStatus().getMessage() == null) {
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
            } else if (cJRNewErrorFormat.getStatus().getMessage().f22819b != null || cJRNewErrorFormat.getStatus().getMessage().f22820c != null) {
                Intent intent = null;
                if (cJRNewErrorFormat.getStatus().getMessage().f22818a != null && cJRNewErrorFormat.getStatus().getMessage().f22818a.equalsIgnoreCase("redirect_SRP")) {
                    intent = new Intent(this, AJRBusSearchSRPActivity.class);
                    intent.addFlags(67108864);
                    intent.addFlags(268435456);
                }
                o.a(this, cJRNewErrorFormat.getStatus().getMessage().f22819b, cJRNewErrorFormat.getStatus().getMessage().f22820c, cJRNewErrorFormat.getStatus().getMessage().a(), intent, getLayoutInflater());
            }
        } catch (Exception e3) {
            com.paytm.utility.q.c(e3.getMessage());
        }
    }

    public final void b() {
        e eVar = this.f21933h;
        if (eVar != null && eVar.isAdded()) {
            this.f21933h.dismissAllowingStateLoss();
        }
        o();
    }

    public final void c() {
        e eVar = this.f21933h;
        if (eVar != null && eVar.isAdded()) {
            this.f21933h.dismissAllowingStateLoss();
        }
    }

    class a extends AsyncTask<Void, Void, JSONObject> {

        /* renamed from: b  reason: collision with root package name */
        private String f21954b;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AJRConfirmBookingActivity.a(AJRConfirmBookingActivity.this, (JSONObject) obj);
        }

        public a(String str) {
            this.f21954b = str;
        }

        private JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                com.travel.bus.a.a();
                if (com.travel.bus.a.b().Q()) {
                    jSONObject.put(PayUtility.PROMO_CODE, !TextUtils.isEmpty(AJRConfirmBookingActivity.this.y) ? AJRConfirmBookingActivity.this.y : "");
                    jSONObject.put("request_id", AJRConfirmBookingActivity.this.I);
                    if (!(AJRConfirmBookingActivity.this.N == null || AJRConfirmBookingActivity.this.N.getBlockResponse() == null)) {
                        jSONObject.put("order_id", AJRConfirmBookingActivity.this.N.getBlockResponse().getTicketId());
                    }
                    jSONObject.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(AJRConfirmBookingActivity.this));
                } else {
                    if (!TextUtils.isEmpty(AJRConfirmBookingActivity.this.y)) {
                        jSONObject.put("applyCoupon", true);
                        jSONObject.put("couponCode", AJRConfirmBookingActivity.this.y);
                    } else {
                        jSONObject.put("applyCoupon", false);
                    }
                    jSONObject.put("requestid", AJRConfirmBookingActivity.this.I);
                    if (!(AJRConfirmBookingActivity.this.N == null || AJRConfirmBookingActivity.this.N.getBlockResponse() == null)) {
                        jSONObject.put("ticket_id", AJRConfirmBookingActivity.this.N.getBlockResponse().getTicketId());
                        jSONObject.put("date_of_journey", AJRConfirmBookingActivity.this.N.getBlockResponse().getOnwardLeg().getTravelDate());
                        jSONObject.put("block_key", AJRConfirmBookingActivity.this.N.getBlockResponse().getOnwardLeg().getBlockKey());
                    }
                }
                f unused = AJRConfirmBookingActivity.this.al;
                ArrayList p = AJRConfirmBookingActivity.this.t;
                String q = AJRConfirmBookingActivity.this.ao;
                String r = AJRConfirmBookingActivity.this.ap;
                boolean s = AJRConfirmBookingActivity.this.C;
                CJRBusInsuranceItem t = AJRConfirmBookingActivity.this.an;
                CJRBusInsurancePlans unused2 = AJRConfirmBookingActivity.this.ay;
                f.a((List<CJRPassengerDetails>) p, q, r, jSONObject, s, t);
            } catch (JSONException e2) {
                com.paytm.utility.q.c(e2.getMessage());
            }
            return jSONObject;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Dialog dialog, View view) {
        dialog.dismiss();
        o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Dialog dialog, View view) {
        dialog.dismiss();
        setResult(4);
        finish();
    }

    private void a(boolean z2, CJRBusInsuranceItem cJRBusInsuranceItem) {
        ArrayList<TripBusDetailsItem> arrayList;
        if (cJRBusInsuranceItem != null) {
            this.ag.setVisibility(cJRBusInsuranceItem.isVisible() ? 0 : 8);
            this.C = z2;
            this.ah.setChecked(cJRBusInsuranceItem.isSelected());
            this.an = cJRBusInsuranceItem;
            this.D = cJRBusInsuranceItem;
            if (!TextUtils.isEmpty(cJRBusInsuranceItem.getTitle())) {
                this.aj.setText(cJRBusInsuranceItem.getTitle());
                this.aj.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AJRConfirmBookingActivity.this.b(view);
                    }
                });
            }
            if (!TextUtils.isEmpty(cJRBusInsuranceItem.getDescription())) {
                this.ai.setText(cJRBusInsuranceItem.getDescription());
                AnonymousClass7 r6 = new ClickableSpan() {
                    public final void onClick(View view) {
                        if (AJRConfirmBookingActivity.this.ah != null) {
                            AJRConfirmBookingActivity.this.ah.setChecked(!AJRConfirmBookingActivity.this.ah.isChecked());
                        }
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                        textPaint.setColor(Color.parseColor("#ff666666"));
                    }
                };
                AnonymousClass8 r0 = new ClickableSpan() {
                    public final void onClick(View view) {
                        if (AJRConfirmBookingActivity.this.an != null && AJRConfirmBookingActivity.this.an.getTc() != null && !"".equalsIgnoreCase(AJRConfirmBookingActivity.this.an.getTc().trim())) {
                            AJRConfirmBookingActivity aJRConfirmBookingActivity = AJRConfirmBookingActivity.this;
                            AJRConfirmBookingActivity.a(aJRConfirmBookingActivity, aJRConfirmBookingActivity.an.getTc());
                            HashMap hashMap = new HashMap();
                            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Passenger Details Screen");
                            com.travel.bus.a.a();
                            com.travel.bus.a.b().a("bus_passenger_premium_tnc_checked", (Map<String, Object>) hashMap, (Context) AJRConfirmBookingActivity.this);
                        }
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(false);
                        textPaint.setColor(Color.parseColor("#ff33b5e5"));
                    }
                };
                if (!TextUtils.isEmpty(cJRBusInsuranceItem.getTc())) {
                    String str = cJRBusInsuranceItem.getDescription() + "\t*T&C";
                    int indexOf = str.indexOf("\t*T&C");
                    if (indexOf != -1) {
                        SpannableString spannableString = new SpannableString(str);
                        spannableString.setSpan(r6, 0, cJRBusInsuranceItem.getDescription().length(), 0);
                        spannableString.setSpan(r0, indexOf + 1, indexOf + 5, 0);
                        this.ai.setText(spannableString);
                        this.ai.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                }
            }
            if (this.C && this.ah.isChecked() && (arrayList = this.p) != null && arrayList.size() > 0 && this.D != null) {
                this.aq.setText(getResources().getString(R.string.rs) + (this.D.getPrice() * ((double) this.p.size())));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        CheckBox checkBox = this.ah;
        if (checkBox != null) {
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.z.dismiss();
    }

    private static JSONObject q() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "BusReviewItinerayScreen");
        } catch (JSONException e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        return jSONObject;
    }

    public final void a(String str) {
        if (str.trim().length() > 0) {
            this.B = true;
            d(str);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Review Itinerary Screen");
                hashMap.put("bus_promocode", str);
                com.travel.bus.a.a();
                com.travel.bus.a.b().a("bus_review_promocode_applied", (Map<String, Object>) hashMap, (Context) this);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    com.paytm.utility.q.c(e2.getMessage());
                }
            }
            CJRCart cJRCart = this.H;
            if (!(cJRCart == null || cJRCart.getCartItems() == null)) {
                cJRCart.getCartItems().size();
            }
            try {
                TextUtils.isEmpty(str);
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    com.paytm.utility.q.c(e3.getMessage());
                }
            }
        } else {
            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.msg_promo_code_missing_heading), getResources().getString(R.string.msg_promo_code_missing_message));
        }
        b(str);
        this.L.setVisibility(8);
        this.y = null;
        n();
        this.u.setText(str);
    }

    private void l() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-review");
            hashMap.put("event_category", "bus_review");
            hashMap.put("event_action", "disclaimer_proceed_to_pay");
            hashMap.put("event_label", Double.valueOf(this.aM));
            hashMap.put("event_label2", this.am.getMeta().getProvider().getName());
            hashMap.put("vertical_name", "bus");
            com.travel.bus.a.a();
            com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.c(e2.getMessage());
            }
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }
        CJRCart cJRCart = this.H;
        com.travel.bus.a.a();
        com.travel.bus.a.b().a((Context) this, cJRCart);
        String str = this.u.getText().toString();
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.u.getWindowToken(), 0);
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(this.y)) {
            k();
            return;
        }
        this.A = true;
        this.B = true;
        d(str);
    }

    public void onBackPressed() {
        if (!isFinishing()) {
            Dialog dialog = new Dialog(this);
            dialog.getWindow().setContentView(R.layout.pre_b_dialog_confirm_back);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            this.S = getString(R.string.bus_ri_back_button_count);
            if (this.R > 0) {
                this.Q++;
            }
            ((TextView) dialog.findViewById(R.id.tv_dialog_desc)).setText(String.format(getResources().getString(R.string.bus_ri_back_button_message), new Object[]{String.format(this.S, new Object[]{Long.valueOf(this.Q)})}));
            ((TextView) dialog.findViewById(R.id.btn_proceed_dialog)).setOnClickListener(new View.OnClickListener(dialog) {
                private final /* synthetic */ Dialog f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    AJRConfirmBookingActivity.this.b(this.f$1, view);
                }
            });
            ((TextView) dialog.findViewById(R.id.btn_cancel_dialog)).setOnClickListener(new View.OnClickListener(dialog) {
                private final /* synthetic */ Dialog f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    AJRConfirmBookingActivity.this.a(this.f$1, view);
                }
            });
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_label2", this.o.getSource().getDisplayCityName() + "/" + this.o.getDestination().getDisplayCityName());
        try {
            hashMap.put("event_label3", this.am.getMeta().getProvider().getName());
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        hashMap.put("userid", com.paytm.utility.b.n((Context) this));
        com.travel.bus.a.a();
        com.travel.bus.a.a("customEvent", "/bus-tickets-review", "bus_review", "back_clicked", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Bus Review Itinerary Screen");
        com.travel.bus.a.a();
        com.travel.bus.a.b().a("bus_review_back_clicked", (Map<String, Object>) hashMap2, (Context) this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(DialogInterface dialogInterface, int i2) {
        this.y = null;
        n();
        this.u.a();
        this.J.setVisibility(0);
        CJRBusRechargeCart cJRBusRechargeCart = this.aC;
        if (cJRBusRechargeCart != null) {
            d(cJRBusRechargeCart);
        }
        this.F.setVisibility(0);
        this.L.setVisibility(8);
        b(this.y);
    }

    static /* synthetic */ void a(AJRConfirmBookingActivity aJRConfirmBookingActivity, JSONObject jSONObject) {
        IJRPaytmDataModel iJRPaytmDataModel;
        String str;
        new StringBuilder("Pre process Input json : ").append(jSONObject.toString());
        com.paytm.utility.b.j();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(aJRConfirmBookingActivity));
        HashMap hashMap2 = new HashMap();
        com.travel.bus.a.a();
        if (com.travel.bus.a.b().Q()) {
            com.travel.bus.a.a();
            str = com.travel.bus.a.b().R();
            iJRPaytmDataModel = new CJRBusVerifyDeferred();
            hashMap2.put("payment_info", "1");
        } else {
            com.travel.bus.a.a();
            str = com.travel.bus.a.b().g();
            iJRPaytmDataModel = new CJRBusPayment();
            if (aJRConfirmBookingActivity.av && aJRConfirmBookingActivity.aw) {
                hashMap2.put("fast_forward", "1");
            }
        }
        if (str != null && !TextUtils.isEmpty(str)) {
            String k2 = com.paytm.utility.b.k();
            if (Uri.parse(str).getQuery() != null) {
                hashMap2.put("client_id", k2);
            } else {
                hashMap2.put("client_id", k2);
            }
            "Pre process url : ".concat(String.valueOf(str));
            com.paytm.utility.b.j();
            if (o.b(aJRConfirmBookingActivity.getApplicationContext())) {
                str = Uri.parse(str).buildUpon().appendQueryParameter("is_reseller", "1").build().toString();
            }
            new StringBuilder("request body : ").append(jSONObject.toString());
            com.paytm.utility.b.j();
            hashMap2.put("native_withdraw", "1");
            if (com.paytm.utility.b.c((Context) aJRConfirmBookingActivity)) {
                aJRConfirmBookingActivity.a((Context) aJRConfirmBookingActivity, aJRConfirmBookingActivity.getResources().getString(R.string.please_wait_progress_msg));
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = aJRConfirmBookingActivity;
                bVar.f42878b = a.c.BUS;
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = str;
                bVar.f42884h = jSONObject.toString();
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = hashMap2;
                bVar.f42885i = iJRPaytmDataModel;
                bVar.j = aJRConfirmBookingActivity;
                bVar.t = q();
                bVar.n = a.b.SILENT;
                bVar.o = "bus-review-itinerary-page";
                bVar.l().a();
            }
        }
    }

    static /* synthetic */ void a(AJRConfirmBookingActivity aJRConfirmBookingActivity, String str) {
        AlertDialog alertDialog = aJRConfirmBookingActivity.z;
        if (alertDialog != null && alertDialog.isShowing()) {
            aJRConfirmBookingActivity.z.dismiss();
        }
        if (!TextUtils.isEmpty(str)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(aJRConfirmBookingActivity);
            WebView webView = new WebView(aJRConfirmBookingActivity);
            webView.setLayoutParams(new LinearLayout.LayoutParams(-21, 300));
            webView.setVerticalScrollBarEnabled(true);
            webView.loadUrl(str);
            webView.setWebViewClient(new WebViewClient() {
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    webView.loadUrl(str);
                    return true;
                }
            });
            builder.setView(webView);
            aJRConfirmBookingActivity.z = builder.create();
            com.google.android.play.core.splitcompat.a.b((Context) aJRConfirmBookingActivity);
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(aJRConfirmBookingActivity).inflate(R.layout.bus_paytm_terms_condition_tc, (ViewGroup) null);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.tnc_title);
            textView.setBackgroundColor(androidx.core.content.b.c(aJRConfirmBookingActivity, 17170445));
            textView.setTextColor(-16777216);
            textView.setTextSize(17.0f);
            textView.setGravity(17);
            com.paytm.utility.b.d(textView);
            textView.setText(aJRConfirmBookingActivity.getResources().getString(R.string.view_terms_and_condtions_str));
            relativeLayout.findViewById(R.id.tnc_close).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRConfirmBookingActivity.this.a(view);
                }
            });
            aJRConfirmBookingActivity.z.setCustomTitle(relativeLayout);
            aJRConfirmBookingActivity.z.show();
        }
    }
}
