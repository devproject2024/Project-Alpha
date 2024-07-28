package net.one97.paytm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.business.merchant_payments.utility.StringUtility;
import com.google.firebase.appindexing.g;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.AJROrderSummaryActivityBase;
import net.one97.paytm.adapter.d;
import net.one97.paytm.addmoney.toppb.view.AddMoneyToPPBActivity;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.CJRActionUrlRequest;
import net.one97.paytm.common.entity.CJRButton;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRModalActionUrlRequest;
import net.one97.paytm.common.entity.CJRModalButton;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.CJRStatus;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel;
import net.one97.paytm.common.entity.SellerRating.CJROrderSummarySellarRating;
import net.one97.paytm.common.entity.busticket.CJRBusOrderSummaryMetaDataResponse;
import net.one97.paytm.common.entity.cst.CSTAttributes;
import net.one97.paytm.common.entity.flightticket.CJRFlightOffer;
import net.one97.paytm.common.entity.flightticket.CJROffers;
import net.one97.paytm.common.entity.flightticket.CJROffersDetails;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.hotels.CJRCarouselData;
import net.one97.paytm.common.entity.hotels.CJRHotelCarouselModel;
import net.one97.paytm.common.entity.recharge.CJRAttributes;
import net.one97.paytm.common.entity.replacement.CJRReplacementReason;
import net.one97.paytm.common.entity.replacement.CJRReplacementResponse;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJRAddress;
import net.one97.paytm.common.entity.shopping.CJRCatalogItem;
import net.one97.paytm.common.entity.shopping.CJRCategoryMap;
import net.one97.paytm.common.entity.shopping.CJRHomePageDetailV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayout;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.shopping.CJROrderList;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryActionList;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlowHistory;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryTransaction;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJROtherTaxes;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.common.entity.shopping.CJRSellerRatingList;
import net.one97.paytm.common.entity.shopping.CJRSellerRatingProp;
import net.one97.paytm.common.entity.shopping.CJRSellerRatings;
import net.one97.paytm.common.entity.shopping.CJRShoppingCart;
import net.one97.paytm.common.entity.shopping.CJRTrackingInfo;
import net.one97.paytm.common.entity.trainticket.CJROfferItems;
import net.one97.paytm.common.entity.trainticket.CJRStoreFrontBanners;
import net.one97.paytm.common.entity.trainticket.CJRStoreFrontItem;
import net.one97.paytm.common.entity.trainticket.CJRTrainBannerDetails;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRLedger;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.widgets.CJRHorizontalListView;
import net.one97.paytm.common.widgets.CustomAutoCompleteTextView;
import net.one97.paytm.common.widgets.ExpandableHeightListView;
import net.one97.paytm.common.widgets.RoboButton;
import net.one97.paytm.deeplink.ak;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.deeplink.k;
import net.one97.paytm.h;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.orders.b.a;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.recharge.common.e.z;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.common.utils.j;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel;
import net.one97.paytm.recharge.ordersummary.c.h;
import net.one97.paytm.recharge.ordersummary.widget.b;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticPaymentFAQs;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionListActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.ai;
import net.one97.paytm.utils.ar;
import net.one97.paytm.utils.ba;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.utils.v;
import net.one97.paytm.widget.OrderSummaryWebView;
import net.one97.paytm.widget.a;
import org.json.JSONException;
import org.json.JSONObject;

public class AJROrderSummaryActivityBase extends CJROrderBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, h.a, m, a.C1056a, z, a.C1466a {
    private static int E = 1;
    private final long F = 3000;
    /* access modifiers changed from: private */
    public String G;
    private y H;
    private String I;
    /* access modifiers changed from: private */
    public CJROrderSummary J;
    private Boolean K = Boolean.FALSE;
    private String L;
    private net.one97.paytm.recharge.ordersummary.widget.b M;
    /* access modifiers changed from: private */
    public String N;
    private boolean O;
    /* access modifiers changed from: private */
    public boolean P;
    private boolean Q = false;
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private LayoutInflater U;
    /* access modifiers changed from: private */
    public boolean V;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = false;
    private boolean Z = false;

    /* renamed from: a  reason: collision with root package name */
    Handler f51394a;
    /* access modifiers changed from: private */
    public RecyclerView aA;
    private boolean aB = false;
    /* access modifiers changed from: private */
    public boolean aC;
    private boolean aD;
    private boolean aE;
    private String aF;
    private String aG;
    private String aH;
    private HashMap<String, Object> aI = new HashMap<>();
    private CJRItem aJ;
    private RelativeLayout aK;
    private RelativeLayout aL;
    private LinearLayout aM;
    private boolean aN = false;
    private HashMap<String, String> aO = new HashMap<>();
    private FrameLayout aP;
    private Button aQ;
    private ImageView aR;
    private String aS = "";
    private String aT;
    private Timer aU = null;
    private int aV = 0;
    private int aW = 4;
    private boolean aX = false;
    private CJROrderedCart aY = null;
    /* access modifiers changed from: private */
    public DownloadManager aZ;
    private RelativeLayout aa;
    private LinearLayout ab;
    /* access modifiers changed from: private */
    public CJRHomePageV2 ac = new CJRHomePageV2();
    /* access modifiers changed from: private */
    public boolean ad = false;
    private boolean ae;
    /* access modifiers changed from: private */
    public ArrayList<String> af;
    private ArrayList<String> ag;
    private ArrayList<String> ah;
    /* access modifiers changed from: private */
    public Dialog ai;
    /* access modifiers changed from: private */
    public Dialog aj;
    private Dialog ak;
    /* access modifiers changed from: private */
    public Dialog al;
    /* access modifiers changed from: private */
    public int am;
    private int an;
    private String ao;
    private LinearLayout ap;
    private ProgressBar aq;
    private boolean ar = false;
    private boolean as = false;
    private String at;
    private boolean au;
    private CJRStatus av;
    private RelativeLayout aw;
    private h ax;
    private CJRParcelTrackingInfo ay;
    private CJRRechargeCart az;

    /* renamed from: b  reason: collision with root package name */
    TimerTask f51395b = new TimerTask() {
        public final void run() {
            AJROrderSummaryActivityBase.this.f51394a.post(new Runnable() {
                public final void run() {
                    AJROrderSummaryActivityBase.this.b(AJROrderSummaryActivityBase.this.G);
                }
            });
        }
    };
    private FrameLayout bA = null;
    /* access modifiers changed from: private */
    public boolean bB = false;
    private boolean bC = false;
    private boolean bD = false;
    private boolean bE = false;
    private BroadcastReceiver bF = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(new long[]{extras.getLong("extra_download_id")});
            Cursor query2 = AJROrderSummaryActivityBase.this.aZ.query(query);
            if (query2.moveToFirst()) {
                int i2 = query2.getInt(query2.getColumnIndex("status"));
                if (i2 == 8) {
                    if (longExtra == ((long) query2.getInt(0)) && longExtra == AJROrderSummaryActivityBase.this.bb) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            new Handler().postDelayed(new Runnable(query2.getString(query2.getColumnIndex("local_uri"))) {
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    AJROrderSummaryActivityBase.AnonymousClass33.this.a(this.f$1);
                                }
                            }, 10000);
                        } else {
                            AJROrderSummaryActivityBase.this.a(query2.getString(query2.getColumnIndex("local_uri")));
                            AJROrderSummaryActivityBase.this.m();
                            AJROrderSummaryActivityBase.this.v();
                        }
                    }
                } else if (i2 == 16 && longExtra == ((long) query2.getInt(0)) && longExtra == AJROrderSummaryActivityBase.this.bb) {
                    AJROrderSummaryActivityBase.this.m();
                    AJROrderSummaryActivityBase.this.v();
                }
            }
            AJROrderSummaryActivityBase.a(query2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(String str) {
            AJROrderSummaryActivityBase.this.a(str);
            AJROrderSummaryActivityBase.this.m();
            AJROrderSummaryActivityBase.this.v();
        }
    };
    private int bG;
    private int bH;
    private boolean bI = false;
    private f bJ;
    private ViewGroup bK;
    private boolean bL;
    private long bM = 0;
    private boolean bN = false;
    private androidx.lifecycle.z<Boolean> bO = null;
    private boolean bP = false;
    private boolean bQ = false;
    private net.one97.paytm.orders.b.a ba;
    /* access modifiers changed from: private */
    public long bb;
    private boolean bc = false;
    private String bd = null;
    private Map<String, Object> be;
    private String bf = null;
    private String bg = null;
    /* access modifiers changed from: private */
    public String bh;
    /* access modifiers changed from: private */
    public String bi = null;
    /* access modifiers changed from: private */
    public CJROrderedCart bj;
    private CJRAutomaticSubscriptionCheckModel bk;
    private String bl;
    private JSONObject bm;
    private CJRStoreFrontBanners bn;
    /* access modifiers changed from: private */
    public String bo;
    private boolean bp;
    private boolean bq = false;
    private String br;
    private boolean bs = false;
    private ArrayList<CSTAttributes> bt = null;
    private RelativeLayout bu;
    private RecyclerView bv;
    private Button bw;
    private boolean bx = false;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.common.h.f by = null;
    private j bz = null;

    /* renamed from: c  reason: collision with root package name */
    TimerTask f51396c = new TimerTask() {
        public final void run() {
            AJROrderSummaryActivityBase.this.f51394a.post(new Runnable() {
                public final void run() {
                    AJROrderSummaryActivityBase.this.b(AJROrderSummaryActivityBase.this.G);
                }
            });
        }
    };

    /* renamed from: d  reason: collision with root package name */
    TimerTask f51397d = new TimerTask() {
        public final void run() {
            AJROrderSummaryActivityBase.this.f51394a.post(new Runnable() {
                public final void run() {
                    AJROrderSummaryActivityBase.this.b(AJROrderSummaryActivityBase.this.G);
                    boolean unused = AJROrderSummaryActivityBase.this.P = false;
                }
            });
        }
    };
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public Context f51398e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51399f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51400g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51401h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51402i;
    public boolean j;
    public boolean k;
    /* access modifiers changed from: package-private */
    public String l;

    public static class g {
        Button A;
        Button B;
        RadioGroup C;
        RadioGroup D;
        TextView E;
        TextView F;
        TextView G;
        TextView H;
        TextView I;
        LinearLayout J;
        LinearLayout K;
        ProgressBar L;
        ProgressBar M;
        ProgressBar N;
        ProgressBar O;
        ProgressBar P;
        ProgressBar Q;
        ProgressBar R;
        TextView S;
        TextView T;
        TextView U;
        TextView V;
        TextView W;
        TextView X;
        TextView Y;
        TextView Z;

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f51618a;
        TextView aA;
        ImageView aB;
        ImageView aC;
        ImageView aD;
        TextView aE;
        TextView aF;
        TextView aG;
        TextView aH;
        TextView aI;
        TextView aJ;
        RelativeLayout aK;
        RelativeLayout aL;
        RelativeLayout aM;
        LinearLayout aN;
        LinearLayout aO;
        TextView aP;
        TextView aQ;
        TextView aR;
        RelativeLayout aS;
        RelativeLayout aT;
        RelativeLayout aU;
        RelativeLayout aV;
        TextView aW;
        TextView aX;
        ImageView aY;
        RelativeLayout aZ;
        ImageView aa;
        ImageView ab;
        RelativeLayout ac;
        RelativeLayout ad;
        RelativeLayout ae;
        RelativeLayout af;
        LinearLayout ag;
        RelativeLayout ah;
        ImageView ai;
        ImageView aj;
        TextView ak;
        TextView al;
        LinearLayout am;
        LinearLayout an;
        LinearLayout ao;
        ImageView ap;
        ImageView aq;
        ImageView ar;
        ImageView as;
        TextView at;
        TextView au;
        TextView av;
        TextView aw;
        TextView ax;
        TextView ay;
        TextView az;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f51619b;
        LinearLayout bA;
        LinearLayout bB;
        LinearLayout bC;
        LinearLayout bD;
        LinearLayout bE;
        LinearLayout bF;
        LinearLayout bG;
        LinearLayout bH;
        LinearLayout bI;
        LinearLayout bJ;
        LinearLayout bK;
        LinearLayout bL;
        LinearLayout bM;
        Button bN;
        TextView bO;
        TextView bP;
        TextView bQ;
        TextView bR;
        TextView bS;
        TextView bT;
        TextView bU;
        TextView bV;
        TextView bW;
        TextView bX;
        TextView bY;
        TextView bZ;
        RelativeLayout ba;
        RelativeLayout bb;
        ImageView bc;
        ImageView bd;
        ImageView be;
        Button bf;
        Button bg;
        TextView bh;
        TextView bi;
        TextView bj;
        TextView bk;
        TextView bl;
        TextView bm;
        LinearLayout bn;
        LinearLayout bo;
        LinearLayout bp;
        LinearLayout bq;
        TextView br;
        TextView bs;
        TextView bt;
        RelativeLayout bu;
        RatingBar bv;
        ImageView bw;
        ImageView bx;
        ImageView by;
        ImageView bz;

        /* renamed from: c  reason: collision with root package name */
        public TextView f51620c;
        RelativeLayout cA;
        RelativeLayout cB;
        RelativeLayout cC;
        RelativeLayout cD;
        RelativeLayout cE;
        RelativeLayout cF;
        RelativeLayout cG;
        RelativeLayout cH;
        TextView cI;
        TextView cJ;
        TextView cK;
        TextView ca;
        TextView cb;
        TextView cc;
        TextView cd;
        TextView ce;
        TextView cf;
        TextView cg;
        TextView ch;
        TextView ci;
        TextView cj;
        TextView ck;
        TextView cl;
        TextView cm;
        TextView cn;
        TextView co;
        TextView cp;
        TextView cq;
        TextView cr;
        TextView cs;
        TextView ct;
        TextView cu;
        TextView cv;
        TextView cw;
        TextView cx;
        RelativeLayout cy;
        RelativeLayout cz;

        /* renamed from: d  reason: collision with root package name */
        public View f51621d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f51622e;

        /* renamed from: f  reason: collision with root package name */
        TextView f51623f;

        /* renamed from: g  reason: collision with root package name */
        TextView f51624g;

        /* renamed from: h  reason: collision with root package name */
        TextView f51625h;

        /* renamed from: i  reason: collision with root package name */
        TextView f51626i;
        TextView j;
        TextView k;
        TextView l;
        TextView m;
        TextView n;
        LinearLayout o;
        LinearLayout p;
        LinearLayout q;
        RelativeLayout r;
        RelativeLayout s;
        RelativeLayout t;
        RelativeLayout u;
        RelativeLayout v;
        RelativeLayout w;
        RelativeLayout x;
        RelativeLayout y;
        RelativeLayout z;
    }

    static /* synthetic */ boolean a(long j2) {
        return 224826563 == j2;
    }

    static /* synthetic */ void f() {
    }

    /* access modifiers changed from: protected */
    public void a(CJROrderSummary cJROrderSummary, String str, String str2, String str3) {
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    public static int a(ListView listView) {
        if (Build.VERSION.SDK_INT >= 11) {
            return listView.getCheckedItemCount();
        }
        int i2 = 0;
        for (int count = listView.getCount() - 1; count >= 0; count--) {
            if (listView.isItemChecked(count)) {
                i2++;
            }
        }
        return i2;
    }

    public void onStart() {
        super.onStart();
        net.one97.paytm.widget.f.a(getApplicationContext());
        net.one97.paytm.common.b.a b2 = net.one97.paytm.common.b.d.b();
        getApplicationContext();
        boolean a2 = b2.a("disableAppIndexing", false);
        net.one97.paytm.common.b.a b3 = net.one97.paytm.common.b.d.b();
        getApplicationContext();
        boolean a3 = b3.a("disableAppActions", false);
        q.d("index : OrderSummary::onStart  : " + a2 + " " + a3);
        if (a2) {
            com.google.firebase.appindexing.g a4 = ((g.a) ((g.a) ((g.a) new g.a().a("AJROrderSummary Page")).c(getString(R.string.app_name))).b("android-app://net.one97.paytm/paytmgn/paytm.com/homepage")).a();
            com.google.firebase.appindexing.b.a().a(a4);
        }
        if (a3) {
            com.google.firebase.appindexing.f.a().a(com.google.firebase.appindexing.a.a.a("AJROrderSummary Page", "android-app://net.one97.paytm/paytmgn/paytm.com/homepage"));
        }
    }

    public void onStop() {
        net.one97.paytm.common.b.a b2 = net.one97.paytm.common.b.d.b();
        getApplicationContext();
        boolean a2 = b2.a("disableAppActions", false);
        q.d("index : OrderSummary::onStop  :  ".concat(String.valueOf(a2)));
        if (a2) {
            com.google.firebase.appindexing.f.a().b(com.google.firebase.appindexing.a.a.a("AJROrderSummary Page", "android-app://net.one97.paytm/paytmgn/paytm.com/homepage"));
        }
        super.onStop();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        String str = null;
        this.s.addView(getLayoutInflater().inflate(R.layout.order_summary_base_lyt, (ViewGroup) null));
        p();
        o();
        this.aA = (RecyclerView) findViewById(R.id.order_summary_listview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.aA.setLayoutManager(linearLayoutManager);
        this.aK = (RelativeLayout) findViewById(R.id.order_summary_header_view);
        this.aL = (RelativeLayout) findViewById(R.id.order_summary_footer_lyt);
        this.aM = (LinearLayout) findViewById(R.id.ordered_item_list);
        this.bu = (RelativeLayout) findViewById(R.id.need_help_header_layout);
        this.bu.setOnClickListener(this);
        this.bv = (RecyclerView) findViewById(R.id.cst_issues_recycler_view);
        this.ba = new net.one97.paytm.orders.b.a(this, findViewById(R.id.nps_capture_lyt));
        this.bw = (Button) findViewById(R.id.txt_sip_click_button);
        findViewById(R.id.wifi_dashboard_layout).setVisibility(8);
        findViewById(R.id.btn_go_to_wifi_dashboard).setVisibility(8);
        this.aa = (RelativeLayout) findViewById(R.id.scroll_view);
        this.ab = (LinearLayout) findViewById(R.id.home_lyt_container);
        this.ap = (LinearLayout) findViewById(R.id.rtb_btn_lyt);
        this.bK = (ViewGroup) findViewById(R.id.lyt_container_active_tickets);
        this.U = getLayoutInflater();
        this.L = getIntent().getStringExtra(UpiConstants.FROM);
        if (getIntent().hasExtra("intent-type-is-buy-flow")) {
            this.bL = getIntent().getBooleanExtra("intent-type-is-buy-flow", false);
        }
        this.G = getIntent().getStringExtra("order_id");
        this.O = getIntent().getBooleanExtra("Recharge", false);
        this.ay = (CJRParcelTrackingInfo) getIntent().getParcelableExtra("tracking_info");
        if (getIntent().hasExtra("recharge cart")) {
            this.az = (CJRRechargeCart) getIntent().getSerializableExtra("recharge cart");
        }
        this.f51402i = getIntent().getBooleanExtra("is_from_bus_ticket", false);
        this.k = getIntent().getBooleanExtra("isEducationVertical", false);
        this.j = getIntent().getBooleanExtra("is_from_contact_us", false);
        if (getIntent().hasExtra("intent_extra_wallet_paytm_assist_gtmevents")) {
            this.H = (y) getIntent().getSerializableExtra("intent_extra_wallet_paytm_assist_gtmevents");
        }
        try {
            this.ao = getIntent().getStringExtra("referralSource");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
        if (getIntent() != null && getIntent().hasExtra("Tab")) {
            this.bd = getIntent().getStringExtra("Tab");
        }
        if (getIntent() != null && getIntent().hasExtra("origin")) {
            this.bf = getIntent().getStringExtra("origin");
        }
        if (getIntent() != null && getIntent().hasExtra(CLPConstants.PRODUCT_ID)) {
            this.bg = getIntent().getStringExtra(CLPConstants.PRODUCT_ID);
        }
        r();
        Boolean.valueOf(getIntent().getBooleanExtra("Add_to_paytm_cash", false));
        if (TextUtils.isEmpty(this.L) || (!this.L.equalsIgnoreCase("Payment") && !this.L.equalsIgnoreCase("paytm_automatic"))) {
            setTitle(getResources().getString(R.string.order_history_title_txt));
        } else {
            setTitle(getResources().getString(R.string.order_summary_title_txt));
        }
        int u = com.paytm.utility.a.u(this);
        int i2 = (int) (((double) u) * 1.5d);
        findViewById(R.id.payment_status_heading).setPadding(u, i2, u, 0);
        findViewById(R.id.text_no_of_cart_items).setPadding(u, i2, u, 0);
        findViewById(R.id.lyt_address_details).setPadding(u, i2, u, i2);
        findViewById(R.id.you_money_safe_with_us).setPadding(u, 0, u, u);
        int i3 = u / 2;
        findViewById(R.id.you_money_safe_with_us_header).setPadding(u, i2, u, i3);
        findViewById(R.id.lyt_sub_payment_amount).setPadding(u, 0, u, 0);
        findViewById(R.id.transaction_details).setPadding(u, i2, u, u);
        findViewById(R.id.lyt_continue_shopping_btn).setPadding(u, u, u, u);
        findViewById(R.id.continue_shopping_btn).getLayoutParams().height = u * 4;
        findViewById(R.id.lyt_bank_payment).setPadding(u, 0, u, i2);
        findViewById(R.id.lyt_paytm_payment).setPadding(u, 0, u, i2);
        findViewById(R.id.lyt_bank_payment_transaction).setPadding(u, 0, u, i2);
        findViewById(R.id.lyt_paytm_payment_transaction).setPadding(u, 0, u, i2);
        findViewById(R.id.payment_status_reason_msg).setPadding(u, i3, u, 0);
        findViewById(R.id.new_order_details_lyt).setPadding(u, i2, u, u);
        findViewById(R.id.queries_clarifications).setPadding(u, i2, u, 0);
        findViewById(R.id.sep_above_total).setPadding(u, 0, u, 0);
        findViewById(R.id.lyt_address_confirmation).setPadding(u, i2, u, i2);
        findViewById(R.id.sep_above_paytm_promise).setPadding(u, 0, u, 0);
        findViewById(R.id.sep_1).setPadding(u, 0, u, 0);
        findViewById(R.id.sep_2).setPadding(u, 0, u, 0);
        findViewById(R.id.sep_3).setPadding(u, 0, u, 0);
        findViewById(R.id.sep_delivery).setPadding(u, 0, u, 0);
        findViewById(R.id.sep_5).setPadding(u, 0, u, 0);
        findViewById(R.id.sep_home_lyt_container).setPadding(u, 0, u, 0);
        findViewById(R.id.home_lyt_container).setPadding(0, 0, 0, 0);
        findViewById(R.id.refund_header).setPadding(0, u, 0, 0);
        findViewById(R.id.lyt_refund_to_bank).setPadding(u, 0, u, 0);
        findViewById(R.id.refund_text).setPadding(0, u, 0, u);
        findViewById(R.id.sep_transaction).setPadding(u, 0, u, 0);
        findViewById(R.id.rtb_buttons).setPadding(0, 0, 0, u);
        findViewById(R.id.rtb_btn_lyt).setPadding(u, 0, 0, 0);
        findViewById(R.id.txt_order_total_summary).setPadding(0, 0, 0, u);
        findViewById(R.id.sep_6).setPadding(u, 0, u, 0);
        findViewById(R.id.automatic_succes_lyt).setPadding(u, u, u, u);
        findViewById(R.id.auto_recharge_landing_card_desc).setPadding(u, u, u, 0);
        ((RelativeLayout.LayoutParams) findViewById(R.id.automatic_grey_lyt).getLayoutParams()).setMargins(0, u, 0, 0);
        findViewById(R.id.bus_hotel_banner_lyt).setPadding(0, u, 0, u);
        findViewById(R.id.carousal_list).setPadding(u, u, u, 0);
        findViewById(R.id.sep_carousel).setPadding(u, 0, u, 0);
        findViewById(R.id.sep_above_order_details_txt).setPadding(u, 0, u, 0);
        findViewById(R.id.sep_above_contact_us_txt).setPadding(u, 0, u, 0);
        findViewById(R.id.carousel_horizontal_list).setPadding(u, 0, u, 0);
        this.P = false;
        this.bG = com.paytm.utility.a.t(this);
        this.bH = this.bG / 2;
        this.aq = (ProgressBar) findViewById(R.id.rtb_buttons_loader);
        this.aw = (RelativeLayout) findViewById(R.id.next_page_loading_progress);
        this.aP = (FrameLayout) findViewById(R.id.book_return_ticket_lyt);
        this.aP.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJROrderSummaryActivityBase.f();
            }
        });
        this.aQ = (Button) findViewById(R.id.book_return_ticket_btn);
        this.aQ.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJROrderSummaryActivityBase.f();
            }
        });
        this.aR = (ImageView) findViewById(R.id.book_return_ticket_close_btn);
        this.aR.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJROrderSummaryActivityBase.f(AJROrderSummaryActivityBase.this);
            }
        });
        com.google.android.gms.common.g.a(this);
        if (!(getApplicationContext() == null || net.one97.paytm.j.c.a() == null)) {
            net.one97.paytm.j.c.a();
            str = net.one97.paytm.j.c.a("travelBannerType", (String) null);
        }
        this.bo = str;
        this.ax = new h(getApplicationContext());
        this.ax.f52404c = this;
        this.be = (Map) getIntent().getSerializableExtra("recharge_ga_data_for_summary");
    }

    public void onResume() {
        super.onResume();
        if (this.ad) {
            this.ad = false;
            u();
        }
        v();
    }

    private void u() {
        v();
        this.aV = 0;
        if (!TextUtils.isEmpty(this.G)) {
            a((Context) this, getResources().getString(R.string.please_wait_progress_msg));
            b(this.G);
        }
        n();
    }

    public final void b() {
        RelativeLayout relativeLayout = this.aw;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void v() {
        RelativeLayout relativeLayout = this.aw;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 3 && i3 == -1) {
            if (!(getIntent() == null || getIntent().getData() == null)) {
                this.I = getIntent().getData().getQueryParameter("url");
            }
            this.L = "Deep Linking";
            e(this.I);
        } else if (i2 == 2) {
            if (i3 == -1) {
                if (intent != null) {
                    String stringExtra = intent.hasExtra("order_id") ? intent.getStringExtra("order_id") : "";
                    if (!TextUtils.isEmpty(stringExtra)) {
                        this.G = stringExtra;
                    }
                }
            } else if (i3 == 0) {
                finish();
            }
            u();
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        String str2 = "";
        try {
            if (getIntent().hasExtra("recharge.os.history.item")) {
                str2 = ((CJROrderList) getIntent().getSerializableExtra("recharge.os.history.item")).getOrderItems().get(0).getProduct().getVerticalLabel();
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("Recharge".equalsIgnoreCase(str2) || l.b(str2)) {
                    StringBuilder sb = new StringBuilder();
                    net.one97.paytm.j.c.a();
                    sb.append(net.one97.paytm.j.c.a("orderdetail", (String) null));
                    sb.append(str);
                    this.I = sb.toString();
                    String stringExtra = getIntent().getStringExtra("INSURANCE_LABEL");
                    if (!TextUtils.isEmpty(stringExtra) && "insurance-retail".equalsIgnoreCase(stringExtra)) {
                        StringBuilder sb2 = new StringBuilder();
                        net.one97.paytm.j.c.a();
                        sb2.append(net.one97.paytm.j.c.h());
                        sb2.append(str);
                        this.I = sb2.toString();
                    }
                    e(this.I);
                }
            }
            StringBuilder sb3 = new StringBuilder();
            net.one97.paytm.j.c.a();
            sb3.append(net.one97.paytm.j.c.a("orderdetail", (String) null));
            sb3.append(str);
            this.I = sb3.toString();
            String stringExtra2 = getIntent().getStringExtra("INSURANCE_LABEL");
            StringBuilder sb22 = new StringBuilder();
            net.one97.paytm.j.c.a();
            sb22.append(net.one97.paytm.j.c.h());
            sb22.append(str);
            this.I = sb22.toString();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
        e(this.I);
    }

    private void e(String str) {
        String str2;
        String stringExtra;
        if (str == null || TextUtils.isEmpty(str)) {
            w();
        } else if (!TextUtils.isEmpty(ag.a(getApplicationContext()).b("sso_token=", "", true))) {
            String b2 = com.paytm.utility.c.b(str, (Context) this);
            if (TextUtils.isEmpty(this.L) || ((!this.L.equalsIgnoreCase("Payment") && !this.L.equalsIgnoreCase("paytm_automatic")) || this.f51402i || this.k)) {
                str2 = b2 + "&actions=1";
            } else {
                str2 = b2 + "&actions=0";
            }
            if (!(getIntent() == null || (stringExtra = getIntent().getStringExtra("pg_screen")) == null)) {
                str2 = str2 + "&pg_screen=" + stringExtra;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this));
            this.K = Boolean.FALSE;
            net.one97.paytm.common.b.d.a(this, str2, this, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJROrderSummary(), a.c.HOME, a.b.SILENT).a();
        } else {
            f(str);
        }
    }

    private void w() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.error));
        builder.setMessage(getResources().getString(R.string.msg_invalid_url)).setCancelable(false).setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJROrderSummaryActivityBase.this.finish();
            }
        });
        builder.create().show();
    }

    private void f(String str) {
        Intent intent = new Intent(this, AJRAuthActivity.class);
        intent.putExtra("resultant activity", AJROrderSummaryActivityBase.class.getName());
        Bundle bundle = new Bundle();
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        cJRHomePageItem.setUrlType("order_summary");
        cJRHomePageItem.setUrl(str);
        bundle.putSerializable("extra_home_data", cJRHomePageItem);
        bundle.putString("origin", "deeplinking");
        intent.putExtra("resultant activity_bundle", bundle);
        startActivity(intent);
        finish();
    }

    public void onMailAtPaytmClicked(View view) {
        x();
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/order history page");
        hashMap.put("contact_us_current_screen_type", "order_hostory");
        net.one97.paytm.j.a.b("contact_us_clicked", (Map<String, Object>) hashMap, (Context) this);
    }

    private void x() {
        if (this.J != null) {
            this.af = new ArrayList<>();
            this.ag = new ArrayList<>();
            for (int i2 = 0; i2 < this.J.getOrderedCartList().size(); i2++) {
                this.af.add(this.J.getOrderedCartList().get(i2).getName());
                this.ag.add(this.J.getOrderedCartList().get(i2).getName());
            }
            if (this.J.getOrderedCartList() == null || this.J.getOrderedCartList().size() != 1) {
                a(this.J);
            } else {
                c(0);
            }
        }
    }

    private void a(final CJROrderSummary cJROrderSummary) {
        if (cJROrderSummary.getOrderedCartList().size() >= 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            TextView textView = new TextView(this);
            textView.setText(getResources().getString(R.string.contact_us_title_query_regarding));
            textView.setPadding(10, 10, 10, 10);
            textView.setGravity(17);
            textView.setTextSize(20.0f);
            textView.setTextColor(getResources().getColor(R.color.color_33b5e5));
            final ListView listView = new ListView(this);
            listView.setChoiceMode(1);
            listView.setAdapter(new c(this));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    if (AJROrderSummaryActivityBase.this.ai.isShowing()) {
                        int unused = AJROrderSummaryActivityBase.this.am = i2;
                    }
                }
            });
            builder.setCustomTitle(textView);
            builder.setCancelable(true);
            builder.setInverseBackgroundForced(true);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    Resources resources = AJROrderSummaryActivityBase.this.getResources();
                    if (AJROrderSummaryActivityBase.a(listView) == 0) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(AJROrderSummaryActivityBase.this);
                        TextView textView = new TextView(AJROrderSummaryActivityBase.this);
                        textView.setText(AJROrderSummaryActivityBase.this.getResources().getString(R.string.error));
                        textView.setPadding(10, 10, 10, 10);
                        textView.setGravity(17);
                        textView.setTextSize(20.0f);
                        textView.setTextColor(AJROrderSummaryActivityBase.this.getResources().getColor(R.color.color_33b5e5));
                        builder.setCustomTitle(textView);
                        builder.setMessage(AJROrderSummaryActivityBase.this.getResources().getString(R.string.contact_us_select_item_message));
                        builder.setPositiveButton(resources.getString(R.string.ok), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                        Dialog unused = AJROrderSummaryActivityBase.this.aj = builder.create();
                        AJROrderSummaryActivityBase.this.aj.setCanceledOnTouchOutside(true);
                        AJROrderSummaryActivityBase.this.aj.show();
                        return;
                    }
                    AJROrderSummaryActivityBase.this.ai.dismiss();
                    AJROrderSummaryActivityBase aJROrderSummaryActivityBase = AJROrderSummaryActivityBase.this;
                    AJROrderSummaryActivityBase.b(aJROrderSummaryActivityBase, aJROrderSummaryActivityBase.am);
                }
            });
            builder.setView(listView);
            this.ai = builder.create();
            this.ai.setCanceledOnTouchOutside(true);
            this.am = 0;
            this.ai.show();
            return;
        }
        try {
            c(0);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, View view) {
        ak akVar = ak.f50322a;
        Intent a2 = ak.a((Context) this);
        if (!TextUtils.isEmpty(this.L) && (this.L.equalsIgnoreCase("Payment") || this.L.equalsIgnoreCase("paytm_automatic"))) {
            a2.putExtra("IS_DASHBOARD_NAVIGATION", true);
        }
        a2.putExtra("ssid", str);
        startActivity(a2);
        finish();
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x037b A[Catch:{ Exception -> 0x0423 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0418 A[Catch:{ Exception -> 0x0423 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0462 A[Catch:{ Exception -> 0x0485 }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0504  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0581  */
    /* JADX WARNING: Removed duplicated region for block: B:467:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x027f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r22) {
        /*
            r21 = this;
            r11 = r21
            r0 = r22
            java.lang.String r1 = "Payment"
            boolean r2 = r21.isFinishing()
            if (r2 == 0) goto L_0x000d
            return
        L_0x000d:
            super.onApiSuccess(r22)
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.shopping.CJROrderSummary
            r3 = 2131367832(0x7f0a1798, float:1.8355597E38)
            r4 = 2
            java.lang.String r5 = "From"
            r6 = 0
            r7 = 1
            r8 = 8
            r9 = 0
            if (r2 == 0) goto L_0x066c
            r11.aV = r9
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummary) r0
            r11.J = r0
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            int r0 = r0.getOrderStatus()
            if (r0 != r4) goto L_0x005c
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            java.util.ArrayList r0 = r0.getOrderedCartList()
            if (r0 == 0) goto L_0x005c
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            java.util.ArrayList r0 = r0.getOrderedCartList()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x005c
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            java.util.ArrayList r0 = r0.getOrderedCartList()
            java.lang.Object r0 = r0.get(r9)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.lang.String r0 = r0.getItemStatus()
            java.lang.String r2 = "7"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x005c
            r21.g()
        L_0x005c:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            java.util.ArrayList r0 = r0.getOrderedCartList()
            if (r0 == 0) goto L_0x00b4
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            java.util.ArrayList r0 = r0.getOrderedCartList()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b4
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            java.util.ArrayList r0 = r0.getOrderedCartList()
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x007b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00b5
            java.lang.Object r4 = r0.next()
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4
            boolean r10 = net.one97.paytm.orders.c.a.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r4)
            if (r10 == 0) goto L_0x007b
            java.lang.Object r4 = r4.getMetaDataResponse()
            com.google.gsonhtcfix.f r10 = new com.google.gsonhtcfix.f
            r10.<init>()
            java.lang.String r4 = r10.a((java.lang.Object) r4)
            java.lang.Class<net.one97.paytm.common.entity.busticket.CJRBusOrderSummaryMetaDataResponse> r12 = net.one97.paytm.common.entity.busticket.CJRBusOrderSummaryMetaDataResponse.class
            java.lang.Object r4 = r10.a((java.lang.String) r4, r12)
            net.one97.paytm.common.entity.busticket.CJRBusOrderSummaryMetaDataResponse r4 = (net.one97.paytm.common.entity.busticket.CJRBusOrderSummaryMetaDataResponse) r4
            if (r4 == 0) goto L_0x007b
            java.lang.String r4 = r4.getIsRoundTrip()
            if (r4 == 0) goto L_0x007b
            java.lang.String r10 = "1.0"
            boolean r4 = r4.equals(r10)
            if (r4 == 0) goto L_0x007b
            r2 = 1
            goto L_0x007b
        L_0x00b4:
            r2 = 0
        L_0x00b5:
            if (r2 == 0) goto L_0x00c2
            boolean r0 = r11.bx
            if (r0 != 0) goto L_0x00c2
            r11.bx = r7
            android.widget.FrameLayout r0 = r11.aP
            r0.setVisibility(r8)
        L_0x00c2:
            net.one97.paytm.recharge.common.utils.j r0 = r11.bz     // Catch:{ Exception -> 0x0168 }
            if (r0 != 0) goto L_0x0172
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J     // Catch:{ Exception -> 0x0168 }
            if (r0 == 0) goto L_0x0172
            boolean r0 = r21.N()     // Catch:{ Exception -> 0x0168 }
            if (r0 == 0) goto L_0x0172
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J     // Catch:{ Exception -> 0x0168 }
            java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ Exception -> 0x0168 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ Exception -> 0x0168 }
            if (r0 == 0) goto L_0x0172
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r11.J     // Catch:{ Exception -> 0x0168 }
            boolean r2 = b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r2)     // Catch:{ Exception -> 0x0168 }
            if (r2 == 0) goto L_0x0172
            boolean r2 = g((net.one97.paytm.common.entity.shopping.CJROrderedCart) r0)     // Catch:{ Exception -> 0x0168 }
            if (r2 == 0) goto L_0x0172
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r0.getProductDetail()     // Catch:{ Exception -> 0x0168 }
            long r12 = r2.getId()     // Catch:{ Exception -> 0x0168 }
            java.lang.Long r15 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r0.getProductDetail()     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()     // Catch:{ Exception -> 0x0168 }
            java.lang.String r16 = r2.getOperatorName()     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r0.getProductDetail()     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()     // Catch:{ Exception -> 0x0168 }
            java.lang.String r18 = r2.getService()     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r0.getProductDetail()     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()     // Catch:{ Exception -> 0x0168 }
            java.lang.String r19 = r2.getCircle()     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r0.getProductDetail()     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()     // Catch:{ Exception -> 0x0168 }
            java.lang.String r20 = r2.getPaytype()     // Catch:{ Exception -> 0x0168 }
            java.util.Map r0 = r0.getRechargeConfiguration()     // Catch:{ Exception -> 0x0168 }
            java.lang.String r2 = "recharge_number"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x0168 }
            r17 = r0
            java.lang.String r17 = (java.lang.String) r17     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.recharge.common.utils.j r0 = new net.one97.paytm.recharge.common.utils.j     // Catch:{ Exception -> 0x0168 }
            r0.<init>(r11)     // Catch:{ Exception -> 0x0168 }
            r11.bz = r0     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.recharge.common.utils.j r14 = r11.bz     // Catch:{ Exception -> 0x0168 }
            r14.a(r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.recharge.common.utils.j r0 = r11.bz     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.recharge.common.h.f r0 = r0.f61646a     // Catch:{ Exception -> 0x0168 }
            r11.by = r0     // Catch:{ Exception -> 0x0168 }
            java.lang.String r0 = r11.L     // Catch:{ Exception -> 0x0168 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0168 }
            if (r0 != 0) goto L_0x0172
            java.lang.String r0 = r11.L     // Catch:{ Exception -> 0x0168 }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0168 }
            if (r0 != 0) goto L_0x0162
            java.lang.String r0 = r11.L     // Catch:{ Exception -> 0x0168 }
            java.lang.String r2 = "paytm_automatic"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0168 }
            if (r0 == 0) goto L_0x0172
        L_0x0162:
            net.one97.paytm.recharge.common.utils.CJRRecentsLazyLoader$a r0 = net.one97.paytm.recharge.common.utils.CJRRecentsLazyLoader.f61453a     // Catch:{ Exception -> 0x0168 }
            net.one97.paytm.recharge.common.utils.CJRRecentsLazyLoader.a.a()     // Catch:{ Exception -> 0x0168 }
            goto L_0x0172
        L_0x0168:
            r0 = move-exception
            r11.bz = r6
            com.google.firebase.crashlytics.c r2 = com.google.firebase.crashlytics.c.a()
            r2.a((java.lang.Throwable) r0)
        L_0x0172:
            net.one97.paytm.recharge.common.utils.j r0 = r11.bz
            if (r0 == 0) goto L_0x0190
            net.one97.paytm.recharge.common.h.f r0 = r11.by
            if (r0 == 0) goto L_0x0190
            androidx.lifecycle.z<java.lang.Boolean> r0 = r11.bO
            if (r0 != 0) goto L_0x0185
            net.one97.paytm.-$$Lambda$AJROrderSummaryActivityBase$zg2dY1XvX8BKFzQjS5PFeepW9Cg r0 = new net.one97.paytm.-$$Lambda$AJROrderSummaryActivityBase$zg2dY1XvX8BKFzQjS5PFeepW9Cg
            r0.<init>()
            r11.bO = r0
        L_0x0185:
            net.one97.paytm.recharge.common.h.f r0 = r11.by
            androidx.lifecycle.y<java.lang.Boolean> r0 = r0.f61442e
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            androidx.lifecycle.z<java.lang.Boolean> r2 = r11.bO
            r0.observe(r11, r2)
        L_0x0190:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J     // Catch:{ Exception -> 0x01bd }
            java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ Exception -> 0x01bd }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ Exception -> 0x01bd }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ Exception -> 0x01bd }
            java.lang.Object r0 = r0.getMetaDataResponse()     // Catch:{ Exception -> 0x01bd }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x01bd }
            java.lang.String r2 = "storefront_view"
            java.lang.String r4 = "post_order_view_type"
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x01bd }
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x01bd }
            if (r0 == 0) goto L_0x01c5
            java.lang.String r0 = r11.L     // Catch:{ Exception -> 0x01bd }
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x01bd }
            if (r0 == 0) goto L_0x01c5
            r0 = 1
            goto L_0x01c6
        L_0x01bd:
            r0 = move-exception
            com.google.firebase.crashlytics.c r2 = com.google.firebase.crashlytics.c.a()
            r2.a((java.lang.Throwable) r0)
        L_0x01c5:
            r0 = 0
        L_0x01c6:
            if (r0 == 0) goto L_0x024b
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            net.one97.paytm.j.c.a()
            java.lang.String r2 = "newBillPaymentStorefront"
            java.lang.String r2 = net.one97.paytm.j.c.a((java.lang.String) r2, (java.lang.String) r6)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L_0x024b
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r10 = r11.L
            r4.putString(r5, r10)
            java.lang.String r10 = "ordered_item"
            r4.putSerializable(r10, r0)
            java.lang.String r10 = "store_url"
            r4.putString(r10, r2)
            androidx.fragment.app.j r2 = r21.getSupportFragmentManager()
            java.lang.Class<net.one97.paytm.recharge.legacy.ordersummary.a.c> r10 = net.one97.paytm.recharge.legacy.ordersummary.a.c.class
            java.lang.String r10 = r10.getName()
            androidx.fragment.app.Fragment r2 = r2.c((java.lang.String) r10)
            if (r2 != 0) goto L_0x022a
            java.lang.Class<net.one97.paytm.recharge.legacy.ordersummary.a.c> r0 = net.one97.paytm.recharge.legacy.ordersummary.a.c.class
            java.lang.String r0 = r0.getName()
            androidx.fragment.app.Fragment r0 = androidx.fragment.app.Fragment.instantiate(r11, r0, r4)
            androidx.fragment.app.j r2 = r21.getSupportFragmentManager()
            androidx.fragment.app.q r2 = r2.a()
            android.widget.FrameLayout r4 = r11.s
            int r4 = r4.getId()
            java.lang.Class<net.one97.paytm.recharge.legacy.ordersummary.a.c> r10 = net.one97.paytm.recharge.legacy.ordersummary.a.c.class
            java.lang.String r10 = r10.getName()
            androidx.fragment.app.q r0 = r2.a(r4, r0, r10)
            java.lang.String r2 = "FJRSuccessRechargeStorefrontFragment"
            androidx.fragment.app.q r0 = r0.a((java.lang.String) r2)
            r0.c()
            goto L_0x024b
        L_0x022a:
            boolean r4 = r2 instanceof net.one97.paytm.recharge.legacy.ordersummary.a.c
            if (r4 == 0) goto L_0x024b
            if (r0 == 0) goto L_0x024b
            java.util.ArrayList r4 = r0.getOrderedCartList()
            if (r4 == 0) goto L_0x024b
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x024b
            net.one97.paytm.recharge.legacy.ordersummary.a.c r2 = (net.one97.paytm.recharge.legacy.ordersummary.a.c) r2
            java.util.ArrayList r0 = r0.getOrderedCartList()
            java.lang.Object r0 = r0.get(r9)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            r2.e(r0)
        L_0x024b:
            r0 = 2131364929(0x7f0a0c41, float:1.8349709E38)
            android.view.View r0 = r11.findViewById(r0)
            boolean r2 = r11.bL
            r4 = 2131370019(0x7f0a2023, float:1.8360033E38)
            if (r2 != 0) goto L_0x025d
            r0.setVisibility(r8)
            goto L_0x027b
        L_0x025d:
            r2 = 2131370018(0x7f0a2022, float:1.836003E38)
            android.view.View r2 = r11.findViewById(r2)
            r2.setVisibility(r8)
            android.view.View r2 = r11.findViewById(r4)
            r2.setVisibility(r8)
            r0.setVisibility(r9)
            android.widget.Button r0 = r11.bw
            net.one97.paytm.AJROrderSummaryActivityBase$4 r2 = new net.one97.paytm.AJROrderSummaryActivityBase$4
            r2.<init>()
            r0.setOnClickListener(r2)
        L_0x027b:
            boolean r0 = r11.f51402i
            if (r0 != 0) goto L_0x02b7
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            r2 = 2131363532(0x7f0a06cc, float:1.8346875E38)
            if (r0 == 0) goto L_0x02a0
            java.util.ArrayList r0 = r0.getOrderedCartList()
            if (r0 == 0) goto L_0x02a0
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            java.util.ArrayList r0 = r0.getOrderedCartList()
            int r0 = r0.size()
            if (r0 != r7) goto L_0x02a0
            android.view.View r0 = r11.findViewById(r2)
            r0.setVisibility(r9)
            goto L_0x02ce
        L_0x02a0:
            android.view.View r0 = r11.findViewById(r2)
            r0.setVisibility(r9)
            r0 = 2131367664(0x7f0a16f0, float:1.8355256E38)
            android.view.View r0 = r11.findViewById(r0)
            net.one97.paytm.AJROrderSummaryActivityBase$5 r2 = new net.one97.paytm.AJROrderSummaryActivityBase$5
            r2.<init>()
            r0.setOnClickListener(r2)
            goto L_0x02ce
        L_0x02b7:
            r21.y()
            r0 = 2131368955(0x7f0a1bfb, float:1.8357875E38)
            android.view.View r0 = r11.findViewById(r0)
            r0.setVisibility(r9)
            r0 = 2131365505(0x7f0a0e81, float:1.8350877E38)
            android.view.View r0 = r11.findViewById(r0)
            r0.setVisibility(r9)
        L_0x02ce:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            net.one97.paytm.y r2 = r11.H
            net.one97.paytm.j.a.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r0, (net.one97.paytm.y) r2, (android.content.Context) r11)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r11.aO
            r2.clear()
            java.util.ArrayList r2 = r0.getOrderedCartList()
            if (r2 == 0) goto L_0x0374
            java.util.ArrayList r2 = r0.getOrderedCartList()
            java.lang.Object r2 = r2.get(r9)
            if (r2 == 0) goto L_0x0374
            java.util.ArrayList r0 = r0.getOrderedCartList()
            java.lang.Object r0 = r0.get(r9)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            java.util.HashMap<java.lang.String, java.lang.String> r2 = r11.aO
            java.util.Map r10 = r0.getRechargeConfiguration()
            r2.putAll(r10)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r0.getProductDetail()
            if (r2 == 0) goto L_0x036e
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r0.getProductDetail()
            long r12 = r2.getCategoryId()
            long r12 = net.one97.paytm.recharge.common.utils.ba.a((long) r12)
            java.lang.String r2 = java.lang.String.valueOf(r12)
            java.util.HashMap r10 = net.one97.paytm.landingpage.activity.HomeActionBarBaseActivity.q
            java.lang.Object r10 = r10.get(r2)
            java.lang.String r10 = (java.lang.String) r10
            r11.aF = r10
            java.util.HashMap r10 = net.one97.paytm.landingpage.activity.HomeActionBarBaseActivity.r
            java.lang.Object r10 = r10.get(r2)
            java.lang.String r10 = (java.lang.String) r10
            r11.aG = r10
            java.lang.String r10 = r11.aF
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x033f
            net.one97.paytm.recharge.common.utils.y r10 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.HashMap r10 = net.one97.paytm.recharge.common.utils.y.a()
            java.lang.Object r10 = r10.get(r2)
            java.lang.String r10 = (java.lang.String) r10
            r11.aF = r10
        L_0x033f:
            java.lang.String r10 = r11.aG
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0355
            net.one97.paytm.recharge.common.utils.y r10 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.HashMap r10 = net.one97.paytm.recharge.common.utils.y.b()
            java.lang.Object r2 = r10.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r11.aG = r2
        L_0x0355:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r0.getProductDetail()
            net.one97.paytm.common.entity.recharge.CJRAttributes r2 = r2.getAttributes()
            if (r2 == 0) goto L_0x0374
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r0.getAttributes()
            java.lang.String r0 = r0.getService()
            r11.aH = r0
            goto L_0x0374
        L_0x036e:
            r11.aF = r6
            r11.aG = r6
            r11.aH = r6
        L_0x0374:
            r21.m()
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x0418
            boolean r0 = r11.as     // Catch:{ Exception -> 0x0423 }
            if (r0 != 0) goto L_0x0381
            r11.as = r7     // Catch:{ Exception -> 0x0423 }
        L_0x0381:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J     // Catch:{ Exception -> 0x0423 }
            java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x0423 }
            r11.G = r0     // Catch:{ Exception -> 0x0423 }
            java.lang.String r0 = r11.L     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x03b7
            java.lang.String r0 = r11.L     // Catch:{ Exception -> 0x0423 }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0423 }
            if (r0 != 0) goto L_0x03b7
            boolean r0 = r21.U()     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x03b3
            java.lang.String r0 = "net.one97.paytm.o2o.movies.activity.AJRMovieOrderSummary"
            android.content.Intent r0 = net.one97.paytm.deeplink.z.a(r11, r0, r6)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "order_id"
            java.lang.String r10 = r11.G     // Catch:{ Exception -> 0x0423 }
            r0.putExtra(r2, r10)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "Order_history"
            r0.putExtra(r5, r2)     // Catch:{ Exception -> 0x0423 }
            r11.startActivity(r0)     // Catch:{ Exception -> 0x0423 }
            r21.finish()     // Catch:{ Exception -> 0x0423 }
        L_0x03b3:
            r21.B()     // Catch:{ Exception -> 0x0423 }
            goto L_0x0406
        L_0x03b7:
            boolean r0 = r21.Q()     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x03e4
            r0 = 2131368027(0x7f0a185b, float:1.8355992E38)
            android.view.View r0 = r11.findViewById(r0)     // Catch:{ Exception -> 0x0423 }
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0     // Catch:{ Exception -> 0x0423 }
            int r2 = com.paytm.utility.a.t(r21)     // Catch:{ Exception -> 0x0423 }
            double r12 = (double) r2     // Catch:{ Exception -> 0x0423 }
            r14 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            double r12 = r12 * r14
            int r2 = (int) r12     // Catch:{ Exception -> 0x0423 }
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()     // Catch:{ Exception -> 0x0423 }
            int r5 = com.paytm.utility.a.b((android.app.Activity) r21)     // Catch:{ Exception -> 0x0423 }
            int r2 = r2 * 1
            int r5 = r5 - r2
            r0.height = r5     // Catch:{ Exception -> 0x0423 }
            r21.B()     // Catch:{ Exception -> 0x0423 }
            goto L_0x0406
        L_0x03e4:
            boolean r0 = r21.R()     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x03ee
            r21.B()     // Catch:{ Exception -> 0x0423 }
            goto L_0x0406
        L_0x03ee:
            boolean r0 = r11.aC     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x03ff
            boolean r0 = r21.ac()     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x03ff
            r21.B()     // Catch:{ Exception -> 0x0423 }
            r21.ae()     // Catch:{ Exception -> 0x0423 }
            goto L_0x0406
        L_0x03ff:
            boolean r0 = r11.aE     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x0406
            r21.B()     // Catch:{ Exception -> 0x0423 }
        L_0x0406:
            boolean r0 = r21.d()     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x042f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r11.bg     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r11.bd     // Catch:{ Exception -> 0x0423 }
            java.lang.String r10 = r11.bf     // Catch:{ Exception -> 0x0423 }
            r11.a((net.one97.paytm.common.entity.shopping.CJROrderSummary) r0, (java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r10)     // Catch:{ Exception -> 0x0423 }
            goto L_0x042f
        L_0x0418:
            r0 = 2131370450(0x7f0a21d2, float:1.8360907E38)
            android.view.View r0 = r11.findViewById(r0)     // Catch:{ Exception -> 0x0423 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0423 }
            goto L_0x042f
        L_0x0423:
            r0 = move-exception
            boolean r2 = com.paytm.utility.b.v
            if (r2 == 0) goto L_0x042f
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x042f:
            boolean r0 = r21.P()
            java.lang.String r2 = "event_category"
            if (r0 == 0) goto L_0x04de
            boolean r0 = r21.A()
            if (r0 == 0) goto L_0x04de
            android.content.Context r0 = r21.getApplicationContext()
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x0485 }
            com.paytm.b.a.a r0 = net.one97.paytm.utils.ag.a(r0)     // Catch:{ Exception -> 0x0485 }
            com.google.gson.f r10 = new com.google.gson.f     // Catch:{ Exception -> 0x0485 }
            r10.<init>()     // Catch:{ Exception -> 0x0485 }
            java.lang.String r12 = "userDropVerticalList"
            java.lang.String r13 = ""
            java.lang.String r12 = r0.b((java.lang.String) r12, (java.lang.String) r13, (boolean) r7)     // Catch:{ Exception -> 0x0485 }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0485 }
            if (r13 != 0) goto L_0x0471
            net.one97.paytm.InAppPushNotification.a$1 r5 = new net.one97.paytm.InAppPushNotification.a$1     // Catch:{ Exception -> 0x0485 }
            r5.<init>()     // Catch:{ Exception -> 0x0485 }
            java.lang.reflect.Type r5 = r5.getType()     // Catch:{ Exception -> 0x0485 }
            java.lang.Object r5 = r10.a((java.lang.String) r12, (java.lang.reflect.Type) r5)     // Catch:{ Exception -> 0x0485 }
            java.util.Set r5 = (java.util.Set) r5     // Catch:{ Exception -> 0x0485 }
        L_0x0471:
            r12 = 10
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x0485 }
            r5.remove(r12)     // Catch:{ Exception -> 0x0485 }
            java.lang.String r5 = r10.b(r5)     // Catch:{ Exception -> 0x0485 }
            java.lang.String r10 = "userDropVerticalList"
            r0.a((java.lang.String) r10, (java.lang.String) r5, (boolean) r7)     // Catch:{ Exception -> 0x0485 }
            goto L_0x048d
        L_0x0485:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x048d:
            java.lang.String r0 = r11.L
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x04de
            java.lang.String r0 = r11.L
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x04de
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            int r0 = r0.getOrderStatus()
            java.lang.String r5 = r11.G
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.lang.String r12 = "bus_summary"
            r10.put(r2, r12)
            java.lang.String r12 = "event_action"
            java.lang.String r13 = "order_status"
            r10.put(r12, r13)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r0)
            java.lang.String r0 = " & "
            r12.append(r0)
            r12.append(r5)
            java.lang.String r0 = r12.toString()
            java.lang.String r5 = "event_label"
            r10.put(r5, r0)
            java.lang.String r0 = com.paytm.utility.a.a((android.content.Context) r21)
            java.lang.String r5 = "user_id"
            r10.put(r5, r0)
            java.lang.String r0 = "custom_event"
            net.one97.paytm.j.a.b((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.Object>) r10, (android.content.Context) r11)
        L_0x04de:
            boolean r0 = r21.P()
            if (r0 == 0) goto L_0x053f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            boolean r0 = b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r0)
            if (r0 == 0) goto L_0x053f
            java.lang.String r0 = r11.L
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x053f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            java.util.ArrayList r0 = r0.getPaymentInfo()
            java.util.Iterator r0 = r0.iterator()
        L_0x04fe:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x053f
            java.lang.Object r5 = r0.next()
            net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment r5 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryPayment) r5
            java.lang.String r10 = r5.getPaymentMethod()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0519
            java.lang.String r5 = r5.getPaymentMethod()
            r6 = r5
        L_0x0519:
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r10 = "bus_summary"
            r5.put(r2, r10)
            java.lang.String r10 = "event_action"
            java.lang.String r12 = "payment_successful"
            r5.put(r10, r12)
            java.lang.String r10 = "event_label"
            r5.put(r10, r6)
            java.lang.String r10 = com.paytm.utility.a.a((android.content.Context) r21)
            java.lang.String r12 = "user_id"
            r5.put(r12, r10)
            java.lang.String r10 = "custom_event"
            net.one97.paytm.j.a.b((java.lang.String) r10, (java.util.Map<java.lang.String, java.lang.Object>) r5, (android.content.Context) r11)
            goto L_0x04fe
        L_0x053f:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            r2 = 2131373652(0x7f0a2e54, float:1.8367401E38)
            android.view.View r5 = r11.findViewById(r2)
            r5.setVisibility(r8)
            r5 = 2131362849(0x7f0a0421, float:1.834549E38)
            android.view.View r6 = r11.findViewById(r5)
            r6.setVisibility(r8)
            if (r0 == 0) goto L_0x066b
            java.util.ArrayList r6 = r0.getOrderedCartList()
            if (r6 == 0) goto L_0x066b
            java.util.ArrayList r6 = r0.getOrderedCartList()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x066b
            java.util.ArrayList r6 = r0.getOrderedCartList()
            java.lang.Object r6 = r6.get(r9)
            if (r6 == 0) goto L_0x066b
            java.util.ArrayList r6 = r0.getOrderedCartList()
            java.lang.Object r6 = r6.get(r9)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6
            java.util.Map r6 = r6.getRechargeConfiguration()
            if (r6 == 0) goto L_0x066b
            java.util.ArrayList r6 = r0.getOrderedCartList()
            java.lang.Object r6 = r6.get(r9)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6
            java.util.Map r6 = r6.getRechargeConfiguration()
            java.lang.String r10 = "recharge_number_3"
            java.lang.Object r12 = r6.get(r10)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x066b
            java.util.ArrayList r0 = r0.getOrderedCartList()
            java.lang.Object r0 = r0.get(r9)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            long r12 = r0.getVerticalId()
            java.lang.Integer r0 = net.one97.paytm.common.utility.b.aY
            int r0 = r0.intValue()
            long r14 = (long) r0
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x066b
            java.lang.Object r0 = r6.get(r10)
            java.lang.String r0 = (java.lang.String) r0
            r11.bN = r7
            android.view.View r6 = r11.findViewById(r5)
            net.one97.paytm.common.widgets.RoboButton r6 = (net.one97.paytm.common.widgets.RoboButton) r6
            android.view.View r2 = r11.findViewById(r2)
            r2.setVisibility(r9)
            r6.setVisibility(r9)
            java.lang.String r2 = r11.L
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x05f3
            java.lang.String r2 = r11.L
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x05ec
            java.lang.String r1 = r11.L
            java.lang.String r2 = "paytm_automatic"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x05f3
        L_0x05ec:
            r1 = 2131966412(0x7f1339cc, float:1.9569661E38)
            r6.setText(r1)
            goto L_0x05f9
        L_0x05f3:
            r1 = 2131966413(0x7f1339cd, float:1.9569663E38)
            r6.setText(r1)
        L_0x05f9:
            r1 = 2131368843(0x7f0a1b8b, float:1.8357647E38)
            android.view.View r1 = r11.findViewById(r1)
            if (r1 == 0) goto L_0x060c
            r1 = 2131368843(0x7f0a1b8b, float:1.8357647E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r8)
        L_0x060c:
            r1 = 2131369275(0x7f0a1d3b, float:1.8358524E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r8)
            r1 = 2131366995(0x7f0a1453, float:1.83539E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r8)
            r1 = 2131367030(0x7f0a1476, float:1.835397E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r8)
            android.view.View r1 = r11.findViewById(r4)
            r1.setVisibility(r8)
            android.view.View r1 = r11.findViewById(r3)
            r1.setVisibility(r8)
            r1 = 2131367064(0x7f0a1498, float:1.835404E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r8)
            r1 = 2131367227(0x7f0a153b, float:1.835437E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r8)
            r1 = 2131368681(0x7f0a1ae9, float:1.8357319E38)
            android.view.View r1 = r11.findViewById(r1)
            if (r1 == 0) goto L_0x065f
            r1 = 2131368681(0x7f0a1ae9, float:1.8357319E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r8)
        L_0x065f:
            android.view.View r1 = r11.findViewById(r5)
            net.one97.paytm.-$$Lambda$AJROrderSummaryActivityBase$L5-sJ18qTurhJzBMz4O2ULnE7tk r2 = new net.one97.paytm.-$$Lambda$AJROrderSummaryActivityBase$L5-sJ18qTurhJzBMz4O2ULnE7tk
            r2.<init>(r0)
            r1.setOnClickListener(r2)
        L_0x066b:
            return
        L_0x066c:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.shopping.CJROrderedCart
            if (r1 == 0) goto L_0x0770
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0
            if (r0 == 0) goto L_0x076c
            int r1 = r0.getVersion()
            int r2 = r11.aW
            if (r1 >= r2) goto L_0x076c
            if (r0 == 0) goto L_0x076c
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x076c }
            r11.K = r1     // Catch:{ Exception -> 0x076c }
            r1 = 2131368033(0x7f0a1861, float:1.8356005E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x076c }
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ Exception -> 0x076c }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r11.J     // Catch:{ Exception -> 0x076c }
            java.util.ArrayList r2 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x076c }
            boolean r3 = r2.contains(r0)     // Catch:{ Exception -> 0x076c }
            if (r3 == 0) goto L_0x076c
            boolean r3 = r11.bN     // Catch:{ Exception -> 0x076c }
            if (r3 != 0) goto L_0x076c
            int r3 = a((java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart>) r2, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0)     // Catch:{ Exception -> 0x076c }
            r2.remove(r3)     // Catch:{ Exception -> 0x076c }
            r2.add(r3, r0)     // Catch:{ Exception -> 0x076c }
            android.view.View r4 = r11.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r0, (int) r3)     // Catch:{ Exception -> 0x076c }
            r5 = 2131366609(0x7f0a12d1, float:1.8353116E38)
            android.view.View r5 = r4.findViewById(r5)     // Catch:{ Exception -> 0x076c }
            android.widget.ImageView r5 = (android.widget.ImageView) r5     // Catch:{ Exception -> 0x076c }
            if (r0 == 0) goto L_0x06c5
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r6 = r0.getProductDetail()     // Catch:{ Exception -> 0x076c }
            if (r6 == 0) goto L_0x06c5
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()     // Catch:{ Exception -> 0x076c }
            java.lang.String r0 = r0.getProductType()     // Catch:{ Exception -> 0x076c }
            if (r0 == 0) goto L_0x06c5
            goto L_0x06c6
        L_0x06c5:
            r7 = 0
        L_0x06c6:
            int r0 = r3 + 1
            int r6 = r2.size()     // Catch:{ Exception -> 0x076c }
            if (r0 == r6) goto L_0x06d4
            if (r7 == 0) goto L_0x06d7
            r5.setVisibility(r9)     // Catch:{ Exception -> 0x076c }
            goto L_0x06d7
        L_0x06d4:
            r5.setVisibility(r8)     // Catch:{ Exception -> 0x076c }
        L_0x06d7:
            java.lang.Object r0 = r2.get(r9)     // Catch:{ Exception -> 0x076c }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ Exception -> 0x076c }
            java.lang.String r0 = r0.getStatus()     // Catch:{ Exception -> 0x076c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x076c }
            if (r0 != 0) goto L_0x073a
            java.lang.Object r0 = r2.get(r9)     // Catch:{ Exception -> 0x076c }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ Exception -> 0x076c }
            boolean r0 = g((net.one97.paytm.common.entity.shopping.CJROrderedCart) r0)     // Catch:{ Exception -> 0x076c }
            if (r0 != 0) goto L_0x0705
            java.lang.Object r0 = r2.get(r9)     // Catch:{ Exception -> 0x076c }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ Exception -> 0x076c }
            java.lang.String r0 = r0.getStatus()     // Catch:{ Exception -> 0x076c }
            java.lang.String r2 = "BOOKED"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x076c }
            if (r0 == 0) goto L_0x073a
        L_0x0705:
            boolean r0 = r11.f51402i     // Catch:{ Exception -> 0x076c }
            if (r0 == 0) goto L_0x071c
            r0 = 2131363169(0x7f0a0561, float:1.834614E38)
            android.view.View r0 = r4.findViewById(r0)     // Catch:{ Exception -> 0x076c }
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x076c }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r11.J     // Catch:{ Exception -> 0x076c }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x076c }
            r11.a((java.lang.String) r2, (android.view.ViewGroup) r0)     // Catch:{ Exception -> 0x076c }
            goto L_0x073a
        L_0x071c:
            r0 = 2131366562(0x7f0a12a2, float:1.8353021E38)
            android.view.View r0 = r4.findViewById(r0)     // Catch:{ Exception -> 0x076c }
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x076c }
            r2 = 2131362382(0x7f0a024e, float:1.8344543E38)
            android.view.View r2 = r4.findViewById(r2)     // Catch:{ Exception -> 0x076c }
            android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2     // Catch:{ Exception -> 0x076c }
            r0.indexOfChild(r2)     // Catch:{ Exception -> 0x076c }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J     // Catch:{ Exception -> 0x076c }
            java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x076c }
            r11.g((java.lang.String) r0)     // Catch:{ Exception -> 0x076c }
        L_0x073a:
            if (r1 == 0) goto L_0x0742
            r1.removeViewAt(r3)     // Catch:{ Exception -> 0x076c }
            r1.addView(r4, r3)     // Catch:{ Exception -> 0x076c }
        L_0x0742:
            net.one97.paytm.recharge.common.utils.j r0 = r11.bz     // Catch:{ Exception -> 0x076c }
            if (r0 == 0) goto L_0x074a
            boolean r0 = r11.bD     // Catch:{ Exception -> 0x076c }
            if (r0 == 0) goto L_0x0753
        L_0x074a:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel r0 = r11.bk     // Catch:{ Exception -> 0x076c }
            if (r0 == 0) goto L_0x0753
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel r0 = r11.bk     // Catch:{ Exception -> 0x076c }
            r11.a((net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel) r0)     // Catch:{ Exception -> 0x076c }
        L_0x0753:
            boolean r0 = r11.bC     // Catch:{ Exception -> 0x076c }
            if (r0 != 0) goto L_0x0761
            android.widget.FrameLayout r0 = r11.bA     // Catch:{ Exception -> 0x076c }
            if (r0 == 0) goto L_0x0761
            android.widget.FrameLayout r0 = r11.bA     // Catch:{ Exception -> 0x076c }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x076c }
            goto L_0x076c
        L_0x0761:
            boolean r0 = r11.bC     // Catch:{ Exception -> 0x076c }
            if (r0 == 0) goto L_0x076c
            boolean r0 = r11.bB     // Catch:{ Exception -> 0x076c }
            if (r0 != 0) goto L_0x076c
            r21.af()     // Catch:{ Exception -> 0x076c }
        L_0x076c:
            r21.m()
            return
        L_0x0770:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.shopping.CJRActionResponse
            if (r1 == 0) goto L_0x077a
            net.one97.paytm.common.entity.shopping.CJRActionResponse r0 = (net.one97.paytm.common.entity.shopping.CJRActionResponse) r0
            r11.a((net.one97.paytm.common.entity.shopping.CJRActionResponse) r0, (boolean) r9)
            return
        L_0x077a:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.CJRContingency
            if (r1 == 0) goto L_0x07be
            net.one97.paytm.common.entity.CJRContingency r0 = (net.one97.paytm.common.entity.CJRContingency) r0
            if (r0 == 0) goto L_0x07bd
            boolean r1 = r0.getStatus()
            if (r1 == 0) goto L_0x07bd
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJRWebViewActivity> r2 = net.one97.paytm.AJRWebViewActivity.class
            r1.<init>(r11, r2)
            java.lang.String r2 = r0.getUrl()
            java.lang.String r3 = "url"
            r1.putExtra(r3, r2)
            java.lang.String r2 = r0.getMessage()
            java.lang.String r3 = "title"
            r1.putExtra(r3, r2)
            java.lang.String r2 = "Contingency"
            r1.putExtra(r5, r2)
            boolean r2 = r0.getClose()
            java.lang.String r3 = "Close"
            r1.putExtra(r3, r2)
            r11.startActivity(r1)
            boolean r0 = r0.getClose()
            if (r0 != 0) goto L_0x07bd
            r21.finish()
        L_0x07bd:
            return
        L_0x07be:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            java.lang.String r2 = "SUCCESS"
            if (r1 == 0) goto L_0x0961
            r21.m()
            r1 = r0
            net.one97.paytm.common.entity.CJRRechargeCart r1 = (net.one97.paytm.common.entity.CJRRechargeCart) r1
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r1.getCart()     // Catch:{ Exception -> 0x07ef }
            java.util.ArrayList r0 = r0.getCartItems()     // Catch:{ Exception -> 0x07ef }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ Exception -> 0x07ef }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0     // Catch:{ Exception -> 0x07ef }
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r1.getCart()     // Catch:{ Exception -> 0x07ef }
            java.util.ArrayList r3 = r3.getCartItems()     // Catch:{ Exception -> 0x07ef }
            java.lang.Object r3 = r3.get(r9)     // Catch:{ Exception -> 0x07ef }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r3 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r3     // Catch:{ Exception -> 0x07ef }
            r3.getCategoryPathForGTM()     // Catch:{ Exception -> 0x07ef }
            java.lang.String r3 = "/cart"
            net.one97.paytm.j.a.a((net.one97.paytm.common.entity.shopping.CJRCartProduct) r0, (android.content.Context) r11, (java.lang.String) r3)     // Catch:{ Exception -> 0x07ef }
            goto L_0x07fb
        L_0x07ef:
            r0 = move-exception
            boolean r3 = com.paytm.utility.b.v
            if (r3 == 0) goto L_0x07fb
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x07fb:
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r1.getCartStatus()
            if (r0 == 0) goto L_0x08c4
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r1.getCartStatus()
            java.lang.String r0 = r0.getResult()
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x08c4
            boolean r0 = net.one97.paytm.utils.l.a((net.one97.paytm.common.entity.CJRRechargeCart) r1, (android.content.Context) r11)
            if (r0 != 0) goto L_0x08c4
            java.lang.String r0 = r11.aF
            if (r0 == 0) goto L_0x0836
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0820
            goto L_0x0836
        L_0x0820:
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r1.getCart()
            java.util.ArrayList r0 = r0.getCartItems()
            java.lang.Object r0 = r0.get(r9)
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0
            java.lang.String r0 = r0.getProductId()
            r11.b((java.lang.String) r0, (boolean) r7)
            return
        L_0x0836:
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8> r0 = net.one97.paytm.recharge.coupons.activity.AJRCouponsActivityV8.class
            r2.<init>(r11, r0)
            java.lang.String r0 = "recharge cart"
            r2.putExtra(r0, r1)
            net.one97.paytm.common.entity.shopping.CJRCart r0 = r1.getCart()     // Catch:{ NullPointerException -> 0x08ae }
            java.util.ArrayList r0 = r0.getCartItems()     // Catch:{ NullPointerException -> 0x08ae }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ NullPointerException -> 0x08ae }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r0 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r0     // Catch:{ NullPointerException -> 0x08ae }
            java.lang.String r0 = r0.getProductId()     // Catch:{ NullPointerException -> 0x08ae }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ NullPointerException -> 0x08ae }
            net.one97.paytm.j.c.a()     // Catch:{ NullPointerException -> 0x08ae }
            java.lang.String r3 = "PaytmCashProductId"
            java.lang.String r3 = net.one97.paytm.j.c.a((java.lang.String) r3, (java.lang.String) r6)     // Catch:{ NullPointerException -> 0x08ae }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ NullPointerException -> 0x08ae }
            if (r4 != 0) goto L_0x0878
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ NullPointerException -> 0x08ae }
            if (r4 != 0) goto L_0x0878
            boolean r0 = r3.equalsIgnoreCase(r0)     // Catch:{ NullPointerException -> 0x08ae }
            if (r0 == 0) goto L_0x0878
            java.lang.String r0 = "Add_to_paytm_cash"
            r2.putExtra(r0, r7)     // Catch:{ NullPointerException -> 0x08ae }
        L_0x0878:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J     // Catch:{ NullPointerException -> 0x08ae }
            java.util.ArrayList r0 = r0.getOrderedCartList()     // Catch:{ NullPointerException -> 0x08ae }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ NullPointerException -> 0x08ae }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r0     // Catch:{ NullPointerException -> 0x08ae }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()     // Catch:{ NullPointerException -> 0x08ae }
            long r3 = r0.getCategoryId()     // Catch:{ NullPointerException -> 0x08ae }
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch:{ NullPointerException -> 0x08ae }
            java.lang.String r3 = "vertical_id"
            r2.putExtra(r3, r0)     // Catch:{ NullPointerException -> 0x08ae }
            java.lang.String r0 = "gtm_category"
            net.one97.paytm.common.entity.shopping.CJRCart r1 = r1.getCart()     // Catch:{ NullPointerException -> 0x08ae }
            java.util.ArrayList r1 = r1.getCartItems()     // Catch:{ NullPointerException -> 0x08ae }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ NullPointerException -> 0x08ae }
            net.one97.paytm.common.entity.shopping.CJRCartProduct r1 = (net.one97.paytm.common.entity.shopping.CJRCartProduct) r1     // Catch:{ NullPointerException -> 0x08ae }
            java.lang.String r1 = r1.getCategoryPathForGTM()     // Catch:{ NullPointerException -> 0x08ae }
            r2.putExtra(r0, r1)     // Catch:{ NullPointerException -> 0x08ae }
            goto L_0x08bd
        L_0x08ae:
            r0 = move-exception
            r21.v()
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x08bd
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x08bd:
            r21.m()
            r11.startActivity(r2)
            return
        L_0x08c4:
            r21.v()
            android.content.res.Resources r0 = r21.getResources()
            r2 = 2131959563(0x7f131f0b, float:1.955577E38)
            java.lang.String r0 = r0.getString(r2)
            net.one97.paytm.common.entity.shopping.CJRCartStatus r2 = r1.getCartStatus()
            if (r2 == 0) goto L_0x0912
            net.one97.paytm.common.entity.shopping.CJRCartStatus r2 = r1.getCartStatus()
            com.paytm.network.model.CJRError r2 = r2.getMessage()
            if (r2 == 0) goto L_0x0912
            net.one97.paytm.common.entity.shopping.CJRCartStatus r2 = r1.getCartStatus()
            com.paytm.network.model.CJRError r2 = r2.getMessage()
            java.lang.String r2 = r2.getMessage()
            if (r2 == 0) goto L_0x0912
            net.one97.paytm.common.entity.shopping.CJRCartStatus r2 = r1.getCartStatus()
            com.paytm.network.model.CJRError r2 = r2.getMessage()
            java.lang.String r2 = r2.getMessage()
            java.lang.String r2 = r2.trim()
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0912
            net.one97.paytm.common.entity.shopping.CJRCartStatus r0 = r1.getCartStatus()
            com.paytm.network.model.CJRError r0 = r0.getMessage()
            java.lang.String r0 = r0.getMessage()
        L_0x0912:
            android.content.res.Resources r2 = r21.getResources()
            r3 = 2131959561(0x7f131f09, float:1.9555766E38)
            java.lang.String r2 = r2.getString(r3)
            net.one97.paytm.common.entity.shopping.CJRCartStatus r3 = r1.getCartStatus()
            if (r3 == 0) goto L_0x095d
            net.one97.paytm.common.entity.shopping.CJRCartStatus r3 = r1.getCartStatus()
            com.paytm.network.model.CJRError r3 = r3.getMessage()
            if (r3 == 0) goto L_0x095d
            net.one97.paytm.common.entity.shopping.CJRCartStatus r3 = r1.getCartStatus()
            com.paytm.network.model.CJRError r3 = r3.getMessage()
            java.lang.String r3 = r3.getTitle()
            if (r3 == 0) goto L_0x095d
            net.one97.paytm.common.entity.shopping.CJRCartStatus r3 = r1.getCartStatus()
            com.paytm.network.model.CJRError r3 = r3.getMessage()
            java.lang.String r3 = r3.getTitle()
            java.lang.String r3 = r3.trim()
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x095d
            net.one97.paytm.common.entity.shopping.CJRCartStatus r1 = r1.getCartStatus()
            com.paytm.network.model.CJRError r1 = r1.getMessage()
            java.lang.String r2 = r1.getTitle()
        L_0x095d:
            com.paytm.utility.b.b((android.content.Context) r11, (java.lang.String) r2, (java.lang.String) r0)
            return
        L_0x0961:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.CJRStatus
            if (r1 == 0) goto L_0x096f
            net.one97.paytm.common.entity.CJRStatus r0 = (net.one97.paytm.common.entity.CJRStatus) r0
            r11.av = r0
            r21.m()
            r11.ar = r7
            return
        L_0x096f:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.wallet.CJRLedger
            if (r1 == 0) goto L_0x097b
            net.one97.paytm.common.entity.wallet.CJRLedger r0 = (net.one97.paytm.common.entity.wallet.CJRLedger) r0
            if (r0 == 0) goto L_0x097a
            r11.a((net.one97.paytm.common.entity.wallet.CJRLedger) r0)
        L_0x097a:
            return
        L_0x097b:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.CJRPGTokenList
            if (r1 == 0) goto L_0x09db
            net.one97.paytm.common.entity.CJRPGTokenList r0 = (net.one97.paytm.common.entity.CJRPGTokenList) r0
            java.lang.String r0 = net.one97.paytm.utils.t.a((net.one97.paytm.common.entity.CJRPGTokenList) r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x09d7
            boolean r1 = r11.bp
            if (r1 == 0) goto L_0x09da
            r11.bp = r9
            java.lang.String r1 = r11.bl
            org.json.JSONObject r2 = r11.bm
            java.lang.String r3 = com.paytm.utility.b.b((android.content.Context) r11, (java.lang.String) r1)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r1 = "Content-Type"
            java.lang.String r5 = "application/json"
            r4.put(r1, r5)
            java.lang.String r1 = "ssotoken"
            r4.put(r1, r0)
            if (r2 == 0) goto L_0x09b3
            java.lang.String r0 = r2.toString()
            r7 = r0
            goto L_0x09b4
        L_0x09b3:
            r7 = r6
        L_0x09b4:
            r5 = 0
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.POST
            net.one97.paytm.common.entity.wallet.CJRLedgerResponse r8 = new net.one97.paytm.common.entity.wallet.CJRLedgerResponse
            r8.<init>()
            com.paytm.network.a$c r9 = com.paytm.network.a.c.HOME
            com.paytm.network.a$b r10 = com.paytm.network.a.b.SILENT
            r1 = r21
            r2 = r3
            r3 = r21
            com.paytm.network.a r0 = net.one97.paytm.common.b.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r1 = com.paytm.utility.a.m(r21)
            if (r1 == 0) goto L_0x09d3
            r0.a()
            return
        L_0x09d3:
            net.one97.paytm.utils.r.a((com.paytm.network.a) r0, (android.content.Context) r11, (android.content.DialogInterface.OnCancelListener) r11)
            return
        L_0x09d7:
            r11.a((com.paytm.network.model.NetworkCustomError) r6)
        L_0x09da:
            return
        L_0x09db:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.wallet.CJRLedgerResponse
            if (r1 == 0) goto L_0x09f9
            r21.m()
            net.one97.paytm.common.entity.wallet.CJRLedgerResponse r0 = (net.one97.paytm.common.entity.wallet.CJRLedgerResponse) r0
            if (r0 == 0) goto L_0x09ed
            java.lang.String r0 = r0.getDisplayMessage()
            com.paytm.utility.b.b((android.content.Context) r11, (java.lang.String) r6, (java.lang.String) r0)
        L_0x09ed:
            boolean r0 = r11.bI
            if (r0 == 0) goto L_0x09f8
            java.lang.String r0 = r11.G
            r11.b((java.lang.String) r0)
            r11.bI = r9
        L_0x09f8:
            return
        L_0x09f9:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.recharge.CJRRechargePayment
            if (r1 == 0) goto L_0x0a5e
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = (net.one97.paytm.common.entity.recharge.CJRRechargePayment) r0
            r21.m()
            java.lang.String r1 = r0.getStatus()
            if (r1 == 0) goto L_0x0a31
            java.lang.String r1 = r0.getStatus()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x0a31
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<net.one97.paytm.AJRRechargePaymentActivity> r2 = net.one97.paytm.AJRRechargePaymentActivity.class
            r1.<init>(r11, r2)
            java.lang.String r2 = "Recharge_Payment_info"
            r1.putExtra(r2, r0)
            java.lang.String r0 = "Recharge"
            r1.putExtra(r5, r0)
            java.lang.String r0 = r11.ao
            java.lang.String r2 = "referralSource"
            r1.putExtra(r2, r0)
            r21.m()
            r11.startActivity(r1)
            return
        L_0x0a31:
            r21.m()
            if (r0 == 0) goto L_0x0a42
            int r1 = r0.getCode()
            r2 = 401(0x191, float:5.62E-43)
            if (r1 != r2) goto L_0x0a42
            r11.a((com.paytm.network.model.NetworkCustomError) r6)
            return
        L_0x0a42:
            if (r0 == 0) goto L_0x0a5d
            com.paytm.network.model.CJRError r1 = r0.getError()
            if (r1 == 0) goto L_0x0a5d
            com.paytm.network.model.CJRError r1 = r0.getError()
            java.lang.String r1 = r1.getTitle()
            com.paytm.network.model.CJRError r0 = r0.getError()
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.b.b((android.content.Context) r11, (java.lang.String) r1, (java.lang.String) r0)
        L_0x0a5d:
            return
        L_0x0a5e:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.SellerRating.CJROrderSummarySellarRating
            if (r1 == 0) goto L_0x0a70
            net.one97.paytm.common.entity.SellerRating.CJROrderSummarySellarRating r0 = (net.one97.paytm.common.entity.SellerRating.CJROrderSummarySellarRating) r0
            if (r0 == 0) goto L_0x0a6f
            java.util.ArrayList r0 = r0.getSellarRatingModel()
            java.lang.String r1 = "apiResponse"
            r11.a((java.util.ArrayList<net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel>) r0, (java.lang.String) r1)
        L_0x0a6f:
            return
        L_0x0a70:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.hotels.CJRHotelCarouselModel
            if (r1 == 0) goto L_0x0a7c
            r11.f51400g = r7
            net.one97.paytm.common.entity.hotels.CJRHotelCarouselModel r0 = (net.one97.paytm.common.entity.hotels.CJRHotelCarouselModel) r0
            r11.a((net.one97.paytm.common.entity.hotels.CJRHotelCarouselModel) r0)
            return
        L_0x0a7c:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.trainticket.CJRStoreFrontBanners
            if (r1 == 0) goto L_0x0a8c
            net.one97.paytm.common.entity.trainticket.CJRStoreFrontBanners r0 = (net.one97.paytm.common.entity.trainticket.CJRStoreFrontBanners) r0
            r11.bn = r0
            net.one97.paytm.common.entity.flightticket.CJRFlightOffer r0 = r21.z()
            r11.a((net.one97.paytm.common.entity.flightticket.CJRFlightOffer) r0)
            return
        L_0x0a8c:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.shopping.CJRSellerRatingList
            if (r1 == 0) goto L_0x0ab2
            net.one97.paytm.common.entity.shopping.CJRSellerRatingList r0 = (net.one97.paytm.common.entity.shopping.CJRSellerRatingList) r0
            if (r0 == 0) goto L_0x0ab1
            java.util.ArrayList r1 = r0.getRatingList()
            if (r1 == 0) goto L_0x0ab1
            java.util.ArrayList r1 = r0.getRatingList()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0ab1
            java.util.ArrayList r0 = r0.getRatingList()
            java.lang.Object r0 = r0.get(r9)
            net.one97.paytm.common.entity.shopping.CJRSellerRatings r0 = (net.one97.paytm.common.entity.shopping.CJRSellerRatings) r0
            r11.a((net.one97.paytm.common.entity.shopping.CJRSellerRatings) r0)
        L_0x0ab1:
            return
        L_0x0ab2:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.replacement.CJRReplacementResponse
            if (r1 == 0) goto L_0x0b48
            net.one97.paytm.common.entity.replacement.CJRReplacementResponse r0 = (net.one97.paytm.common.entity.replacement.CJRReplacementResponse) r0
            r21.m()
            r21.v()
            boolean r1 = a((net.one97.paytm.common.entity.replacement.CJRReplacementResponse) r0)
            if (r1 == 0) goto L_0x0b2c
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            java.lang.String r2 = "extra_home_data"
            r1.putExtra(r2, r0)
            java.lang.String r0 = "fragment_name"
            java.lang.String r2 = "select_reason_fragment"
            r1.putExtra(r0, r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            net.one97.paytm.common.entity.shopping.CJRAddress r0 = r0.getShippingAddress()
            java.lang.String r2 = "shipping_address"
            r1.putExtra(r2, r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r11.aY
            if (r0 == 0) goto L_0x0b1b
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r0.getProductDetail()
            if (r0 == 0) goto L_0x0b1b
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r11.aY
            java.lang.String r2 = "cart_product"
            r1.putExtra(r2, r0)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r0 = r11.aY
            boolean r0 = r0.isReplacement()
            java.lang.String r2 = "is_child_order"
            r1.putExtra(r2, r0)
            java.lang.String r0 = r11.N
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0b0c
            java.lang.String r0 = r11.N
            java.lang.String r2 = "extra_replace_title"
            r1.putExtra(r2, r0)
        L_0x0b0c:
            java.lang.String r0 = r11.G
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0b1b
            java.lang.String r0 = r11.G
            java.lang.String r2 = "replacement_parent_id"
            r1.putExtra(r2, r0)
        L_0x0b1b:
            java.lang.String r0 = "target_activity_tag"
            java.lang.String r2 = "RNRActivityTag"
            r1.putExtra(r0, r2)
            java.lang.String r0 = "result_code_required"
            r1.putExtra(r0, r4)
            net.one97.paytm.marketplace.a.a((android.app.Activity) r11, (android.content.Intent) r1)
            goto L_0x0b45
        L_0x0b2c:
            android.content.res.Resources r0 = r21.getResources()
            r1 = 2131962500(0x7f132a84, float:1.9561727E38)
            java.lang.String r0 = r0.getString(r1)
            android.content.res.Resources r1 = r21.getResources()
            r2 = 2131962499(0x7f132a83, float:1.9561725E38)
            java.lang.String r1 = r1.getString(r2)
            com.paytm.utility.b.b((android.content.Context) r11, (java.lang.String) r1, (java.lang.String) r0)
        L_0x0b45:
            r11.aY = r6
            return
        L_0x0b48:
            boolean r1 = r0 instanceof net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse
            if (r1 == 0) goto L_0x0b98
            net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse r0 = (net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse) r0
            r21.m()
            if (r0 == 0) goto L_0x0b90
            java.lang.String r1 = r0.getMessage()
            if (r1 == 0) goto L_0x0b90
            android.view.LayoutInflater r1 = r21.getLayoutInflater()
            r2 = 2131560637(0x7f0d08bd, float:1.8746652E38)
            r4 = 2131369992(0x7f0a2008, float:1.8359978E38)
            android.view.View r4 = r11.findViewById(r4)
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            android.view.View r1 = r1.inflate(r2, r4)
            r2 = 2131370895(0x7f0a238f, float:1.836181E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r0 = r0.getMessage()
            r2.setText(r0)
            android.widget.Toast r0 = new android.widget.Toast
            r0.<init>(r11)
            r0.setDuration(r9)
            r2 = 17
            r0.setGravity(r2, r9, r9)
            r0.setView(r1)
            r0.show()
        L_0x0b90:
            android.view.View r0 = r11.findViewById(r3)
            r0.setVisibility(r8)
            return
        L_0x0b98:
            boolean r1 = r0 instanceof net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel
            if (r1 == 0) goto L_0x0bb6
            r21.m()
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel r0 = (net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel) r0
            r11.bk = r0
            boolean r0 = r21.N()
            if (r0 == 0) goto L_0x0bb1
            net.one97.paytm.recharge.common.utils.j r0 = r11.bz
            if (r0 == 0) goto L_0x0bb1
            boolean r0 = r11.bD
            if (r0 == 0) goto L_0x0bb6
        L_0x0bb1:
            net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel r0 = r11.bk
            r11.a((net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionCheckModel) r0)
        L_0x0bb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x001d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0047 A[Catch:{ Exception -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0142 A[Catch:{ Exception -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0165 A[Catch:{ Exception -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x017b A[SYNTHETIC, Splitter:B:74:0x017b] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b1 A[Catch:{ Exception -> 0x0234 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void y() {
        /*
            r28 = this;
            java.lang.String r0 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            r1 = r28
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r1.J
            if (r2 != 0) goto L_0x000a
            return
        L_0x000a:
            r3 = 0
            java.util.ArrayList r2 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x0234 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0234 }
            java.lang.String r4 = ""
            r7 = r3
            r3 = r4
            r5 = r3
            r6 = r5
            r8 = r6
            r9 = r8
            r10 = r9
            r11 = r10
        L_0x001d:
            boolean r12 = r2.hasNext()     // Catch:{ Exception -> 0x0234 }
            r14 = 0
            if (r12 == 0) goto L_0x009e
            java.lang.Object r12 = r2.next()     // Catch:{ Exception -> 0x0234 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r12 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r12     // Catch:{ Exception -> 0x0234 }
            boolean r15 = net.one97.paytm.orders.c.a.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r12)     // Catch:{ Exception -> 0x0234 }
            if (r15 == 0) goto L_0x001d
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r12 = r12.getFullFillmentOject()     // Catch:{ Exception -> 0x0234 }
            org.json.JSONObject r12 = r12.getFullFillment()     // Catch:{ Exception -> 0x0234 }
            java.lang.String r15 = "order_data"
            if (r12 == 0) goto L_0x0044
            boolean r16 = r12.has(r15)     // Catch:{ Exception -> 0x0234 }
            if (r16 == 0) goto L_0x0044
            r13 = 1
            goto L_0x0045
        L_0x0044:
            r13 = 0
        L_0x0045:
            if (r13 == 0) goto L_0x001d
            org.json.JSONObject r3 = r12.getJSONObject(r15)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r4 = "items"
            org.json.JSONArray r3 = r3.getJSONArray(r4)     // Catch:{ Exception -> 0x0234 }
            org.json.JSONObject r3 = r3.getJSONObject(r14)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r4 = "journey_detail"
            org.json.JSONObject r3 = r3.getJSONObject(r4)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r4 = "boarding_date_time"
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r5 = "from"
            java.lang.String r5 = r12.getString(r5)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r6 = "to"
            java.lang.String r6 = r12.getString(r6)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r7 = "arrival_date_time"
            java.lang.String r7 = r3.getString(r7)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r8 = "hh:mm a"
            java.lang.String r8 = net.one97.paytm.orders.c.a.a(r0, r4, r8)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r9 = "hh:mm a"
            java.lang.String r9 = net.one97.paytm.orders.c.a.a(r0, r7, r9)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r10 = "bus_type"
            java.lang.String r10 = r3.getString(r10)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r11 = "operator_name"
            java.lang.String r11 = r3.getString(r11)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r12 = "boarding_point_name"
            java.lang.String r3 = r3.getString(r12)     // Catch:{ Exception -> 0x0234 }
            r27 = r11
            r11 = r3
            r3 = r4
            r4 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            r5 = r9
            r9 = r27
            goto L_0x001d
        L_0x009e:
            java.util.Calendar r2 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0234 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0234 }
            r15 = 3
            r13 = 2
            r12 = 5
            if (r0 != 0) goto L_0x00d2
            int r0 = r4.length()     // Catch:{ Exception -> 0x0234 }
            if (r0 <= r12) goto L_0x00d2
            java.lang.String r0 = r4.substring(r14, r13)     // Catch:{ Exception -> 0x0234 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r4 = r4.substring(r15, r12)     // Catch:{ Exception -> 0x0234 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0234 }
            r15 = 12
            if (r0 >= r15) goto L_0x00c6
            goto L_0x00ce
        L_0x00c6:
            r15 = 24
            if (r0 >= r15) goto L_0x00cd
            int r0 = r0 + -12
            goto L_0x00ce
        L_0x00cd:
            r0 = 0
        L_0x00ce:
            r20 = r4
            r4 = r0
            goto L_0x00d5
        L_0x00d2:
            r4 = 0
            r20 = 0
        L_0x00d5:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0234 }
            r13 = 7
            r15 = 4
            r12 = 9
            if (r0 != 0) goto L_0x011a
            int r0 = r3.length()     // Catch:{ Exception -> 0x0234 }
            if (r0 <= r12) goto L_0x011a
            java.lang.String r0 = r3.substring(r14, r15)     // Catch:{ Exception -> 0x010a }
            int r18 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x010a }
            r15 = 5
            java.lang.String r0 = r3.substring(r15, r13)     // Catch:{ Exception -> 0x0105 }
            int r15 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0105 }
            r12 = 8
            r13 = 10
            java.lang.String r0 = r3.substring(r12, r13)     // Catch:{ Exception -> 0x0103 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0103 }
            goto L_0x0118
        L_0x0103:
            r0 = move-exception
            goto L_0x0110
        L_0x0105:
            r0 = move-exception
            r13 = 10
            r15 = 0
            goto L_0x0110
        L_0x010a:
            r0 = move-exception
            r13 = 10
            r15 = 0
            r18 = 0
        L_0x0110:
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0234 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x0234 }
            r0 = 0
        L_0x0118:
            r3 = 1
            goto L_0x0121
        L_0x011a:
            r13 = 10
            r0 = 0
            r3 = 1
            r15 = 0
            r18 = 0
        L_0x0121:
            int r17 = r15 + -1
            r3 = 10
            r12 = 3
            r13 = 4
            r15 = r2
            r16 = r18
            r18 = r0
            r19 = r4
            r15.set(r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x0234 }
            long r15 = r2.getTimeInMillis()     // Catch:{ Exception -> 0x0234 }
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0234 }
            if (r0 != 0) goto L_0x0165
            int r0 = r5.length()     // Catch:{ Exception -> 0x0234 }
            r2 = 5
            if (r0 <= r2) goto L_0x0165
            r3 = 2
            java.lang.String r0 = r5.substring(r14, r3)     // Catch:{ Exception -> 0x0234 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r3 = r5.substring(r12, r2)     // Catch:{ Exception -> 0x0234 }
            int r2 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x0234 }
            r3 = 12
            if (r4 >= r3) goto L_0x0158
            goto L_0x0160
        L_0x0158:
            r3 = 24
            if (r0 >= r3) goto L_0x015f
            int r0 = r0 + -12
            goto L_0x0160
        L_0x015f:
            r0 = 0
        L_0x0160:
            r25 = r0
            r26 = r2
            goto L_0x0169
        L_0x0165:
            r25 = 0
            r26 = 0
        L_0x0169:
            java.util.Calendar r2 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x0234 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0234 }
            if (r0 != 0) goto L_0x01b1
            int r0 = r6.length()     // Catch:{ Exception -> 0x0234 }
            r3 = 9
            if (r0 <= r3) goto L_0x01b1
            java.lang.String r0 = r6.substring(r14, r13)     // Catch:{ Exception -> 0x01a3 }
            int r3 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x01a3 }
            r4 = 7
            r5 = 5
            java.lang.String r0 = r6.substring(r5, r4)     // Catch:{ Exception -> 0x01a1 }
            int r4 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x01a1 }
            r5 = 10
            r12 = 8
            java.lang.String r0 = r6.substring(r12, r5)     // Catch:{ Exception -> 0x019f }
            int r14 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x019f }
            r22 = r3
            r24 = r14
            r3 = 1
            goto L_0x01b7
        L_0x019f:
            r0 = move-exception
            goto L_0x01a6
        L_0x01a1:
            r0 = move-exception
            goto L_0x01a5
        L_0x01a3:
            r0 = move-exception
            r3 = 0
        L_0x01a5:
            r4 = 0
        L_0x01a6:
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0234 }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x0234 }
            r22 = r3
            r3 = 1
            goto L_0x01b5
        L_0x01b1:
            r3 = 1
            r4 = 0
            r22 = 0
        L_0x01b5:
            r24 = 0
        L_0x01b7:
            int r23 = r4 + -1
            r21 = r2
            r21.set(r22, r23, r24, r25, r26)     // Catch:{ Exception -> 0x0234 }
            long r2 = r2.getTimeInMillis()     // Catch:{ Exception -> 0x0234 }
            android.content.ContentResolver r0 = r28.getContentResolver()     // Catch:{ Exception -> 0x0234 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x0234 }
            r4.<init>()     // Catch:{ Exception -> 0x0234 }
            java.lang.String r5 = "dtstart"
            java.lang.Long r6 = java.lang.Long.valueOf(r15)     // Catch:{ Exception -> 0x0234 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r5 = "dtend"
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0234 }
            r4.put(r5, r2)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r2 = "title"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0234 }
            java.lang.String r5 = "Bus from "
            r3.<init>(r5)     // Catch:{ Exception -> 0x0234 }
            r3.append(r7)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r5 = " to "
            r3.append(r5)     // Catch:{ Exception -> 0x0234 }
            r3.append(r8)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0234 }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r2 = "description"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0234 }
            java.lang.String r5 = "Operator Name: "
            r3.<init>(r5)     // Catch:{ Exception -> 0x0234 }
            r3.append(r9)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r5 = " \nBus Type: "
            r3.append(r5)     // Catch:{ Exception -> 0x0234 }
            r3.append(r10)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r5 = "\nBoarding Point: "
            r3.append(r5)     // Catch:{ Exception -> 0x0234 }
            r3.append(r11)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0234 }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r2 = "calendar_id"
            r5 = 3
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0234 }
            r4.put(r2, r3)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r2 = "eventTimezone"
            java.lang.String r3 = "America/Los_Angeles"
            r4.put(r2, r3)     // Catch:{ Exception -> 0x0234 }
            android.net.Uri r2 = android.provider.CalendarContract.Events.CONTENT_URI     // Catch:{ Exception -> 0x0234 }
            r0.insert(r2, r4)     // Catch:{ Exception -> 0x0234 }
            return
        L_0x0234:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.y():void");
    }

    private void b(String str, boolean z) {
        this.aO.put(CLPConstants.PRODUCT_ID, str);
        Intent intent = new Intent("android.intent.action.VIEW");
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        StringBuilder sb = new StringBuilder("paytmmp://" + this.aG + "?url=" + this.aF);
        if (!TextUtils.isEmpty(this.aH)) {
            sb.append("$title=" + this.aH);
        }
        if (z) {
            for (Map.Entry next : this.aO.entrySet()) {
                sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN + ((String) next.getKey()) + "=" + ((String) next.getValue()));
            }
        }
        cJRHomePageItem.setUrlType(this.aG);
        cJRHomePageItem.setUrl(new String(sb));
        intent.setData(Uri.parse(new String(sb)));
        m();
        net.one97.paytm.utils.j.a((Context) this, this.aG, (IJRDataModel) cJRHomePageItem, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, (String) null, (c) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021 A[Catch:{ Exception -> 0x003a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(net.one97.paytm.common.entity.replacement.CJRReplacementResponse r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0043
            java.util.ArrayList r1 = r3.getL1ReasonList()     // Catch:{ Exception -> 0x003a }
            if (r1 == 0) goto L_0x0043
            java.util.ArrayList r1 = r3.getL1ReasonList()     // Catch:{ Exception -> 0x003a }
            int r1 = r1.size()     // Catch:{ Exception -> 0x003a }
            if (r1 <= 0) goto L_0x0043
            java.util.ArrayList r3 = r3.getL1ReasonList()     // Catch:{ Exception -> 0x003a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x003a }
        L_0x001b:
            boolean r1 = r3.hasNext()     // Catch:{ Exception -> 0x003a }
            if (r1 == 0) goto L_0x0042
            java.lang.Object r1 = r3.next()     // Catch:{ Exception -> 0x003a }
            net.one97.paytm.common.entity.replacement.CJRReplacementReason r1 = (net.one97.paytm.common.entity.replacement.CJRReplacementReason) r1     // Catch:{ Exception -> 0x003a }
            if (r1 == 0) goto L_0x0043
            java.util.ArrayList r2 = r1.getChildList()     // Catch:{ Exception -> 0x003a }
            if (r2 == 0) goto L_0x0043
            java.util.ArrayList r1 = r1.getChildList()     // Catch:{ Exception -> 0x003a }
            int r1 = r1.size()     // Catch:{ Exception -> 0x003a }
            if (r1 != 0) goto L_0x001b
            goto L_0x0043
        L_0x003a:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.b(r3)
        L_0x0042:
            r0 = 1
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.a(net.one97.paytm.common.entity.replacement.CJRReplacementResponse):boolean");
    }

    private void a(final CJRSellerRatings cJRSellerRatings) {
        try {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ordered_item_list);
            if (linearLayout != null && linearLayout.getChildCount() > 0) {
                for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                    linearLayout.getChildCount();
                    View childAt = linearLayout.getChildAt(i2);
                    if (childAt != null) {
                        try {
                            if (childAt.getTag() == null) {
                            }
                        } catch (Exception e2) {
                            if (com.paytm.utility.b.v) {
                                q.b(e2.getMessage());
                            }
                        }
                    }
                    g gVar = new g();
                    gVar.bl = (TextView) childAt.findViewById(R.id.seller_info_txt);
                    final CJROrderedCart cJROrderedCart = (CJROrderedCart) childAt.getTag();
                    gVar.bl.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AJROrderSummaryActivityBase.this.a((CJROrderSummaryRatingModel) null, cJROrderedCart, cJRSellerRatings);
                        }
                    });
                }
            }
        } catch (Exception e3) {
            if (com.paytm.utility.b.v) {
                q.b(e3.getMessage());
            }
        }
    }

    private void a(CJRFlightOffer cJRFlightOffer) {
        if (cJRFlightOffer != null && cJRFlightOffer.getmOffers() != null && cJRFlightOffer.getmOffers().getmOfferDetails() != null) {
            try {
                b bVar = new b();
                final CJROffersDetails cJROffersDetails = null;
                for (int i2 = 0; i2 < cJRFlightOffer.getmOffers().getmOfferDetails().size(); i2++) {
                    if (!(cJRFlightOffer.getmOffers().getmOfferDetails().get(i2) == null || cJRFlightOffer.getmOffers().getmOfferDetails().get(i2).getmOfferItems().size() <= 0 || cJRFlightOffer.getmOffers().getmOfferDetails() == null || cJRFlightOffer.getmOffers().getmOfferDetails().size() <= 0 || cJRFlightOffer.getmOffers().getmOfferDetails().get(i2).getmOfferItems() == null || cJRFlightOffer.getmOffers().getmOfferDetails().get(i2).getmOfferItems() == null || cJRFlightOffer.getmOffers().getmOfferDetails().get(i2).getmOfferItems().size() <= 0)) {
                        cJROffersDetails = cJRFlightOffer.getmOffers().getmOfferDetails().get(i2);
                    }
                }
                if (cJROffersDetails != null) {
                    CJRHorizontalListView cJRHorizontalListView = (CJRHorizontalListView) findViewById(R.id.carousel_horizontal_list);
                    findViewById(R.id.sep_carousel).setVisibility(8);
                    findViewById(R.id.carousal_list).setVisibility(8);
                    ((LinearLayout) findViewById(R.id.bus_hotel_banner_lyt)).setVisibility(0);
                    cJRHorizontalListView.setVisibility(0);
                    cJRHorizontalListView.setAdapter((ListAdapter) new net.one97.paytm.adapter.a(this, cJROffersDetails));
                    cJRHorizontalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                            CJROfferItems cJROfferItems;
                            String uRLType = cJROffersDetails.getmOfferItems().get(i2).getURLType();
                            if ((!TextUtils.isEmpty(AJROrderSummaryActivityBase.this.bo) && uRLType.equalsIgnoreCase(AJROrderSummaryActivityBase.this.bo)) || uRLType.equalsIgnoreCase("native") || uRLType.equalsIgnoreCase("flightticket")) {
                                return;
                            }
                            if (uRLType.equalsIgnoreCase("referral")) {
                                AJROrderSummaryActivityBase.k(AJROrderSummaryActivityBase.this);
                                return;
                            }
                            AJROrderSummaryActivityBase aJROrderSummaryActivityBase = AJROrderSummaryActivityBase.this;
                            IJRDataModel iJRDataModel = cJROffersDetails.getmOfferItems().get(i2);
                            if ((iJRDataModel instanceof CJROfferItems) && (cJROfferItems = (CJROfferItems) iJRDataModel) != null) {
                                String url = cJROfferItems.getURL();
                                if (TextUtils.isEmpty(url) || !url.startsWith("paytmmp://")) {
                                    String uRLType2 = cJROfferItems.getURLType();
                                    if (uRLType2 != null && !TextUtils.isEmpty(uRLType2) && uRLType2.equalsIgnoreCase(CLPConstants.URL_TYPE_EMBED) && url != null && !TextUtils.isEmpty(url)) {
                                        aJROrderSummaryActivityBase.a(cJROfferItems.getURLType(), iJRDataModel, 0, (ArrayList<? extends CJRItem>) null, CLPConstants.GA_CHANNEL_NAME);
                                        return;
                                    }
                                    return;
                                }
                                aJROrderSummaryActivityBase.a(cJROfferItems.getURLType(), iJRDataModel, 0, (ArrayList<? extends CJRItem>) null, "");
                            }
                        }
                    });
                    return;
                }
                bVar.f51607a.setVisibility(8);
            } catch (Exception unused) {
            }
        }
    }

    private CJRFlightOffer z() {
        try {
            if (this.bn == null || this.bn.getPage() == null || this.bn.getPage().size() <= 0) {
                return null;
            }
            CJRFlightOffer cJRFlightOffer = new CJRFlightOffer();
            try {
                cJRFlightOffer.setmOffers(new CJROffers());
                List<CJROffersDetails> list = cJRFlightOffer.getmOffers().getmOfferDetails();
                if (list == null) {
                    cJRFlightOffer.getmOffers().setmOfferDetails(new ArrayList());
                    list = cJRFlightOffer.getmOffers().getmOfferDetails();
                }
                for (CJRStoreFrontItem cJRStoreFrontItem : this.bn.getPage()) {
                    Iterator<CJRTrainBannerDetails> it2 = cJRStoreFrontItem.getmBannerDetails().iterator();
                    while (it2.hasNext()) {
                        CJROffersDetails cJROffersDetails = new CJROffersDetails();
                        cJROffersDetails.setmOfferItems(it2.next().getmBannerItems());
                        list.add(cJROffersDetails);
                    }
                }
                this.bn.getPage().get(0).getmBannerDetails();
            } catch (Exception unused) {
            }
            return cJRFlightOffer;
        } catch (Exception unused2) {
            return null;
        }
    }

    private void a(CJRHotelCarouselModel cJRHotelCarouselModel) {
        if (cJRHotelCarouselModel != null) {
            try {
                CJRCarouselData carouselData = cJRHotelCarouselModel.getCarouselData();
                if (carouselData != null) {
                    ArrayList<CJRHomePageLayout> carouselOffers = carouselData.getCarouselOffers();
                    ArrayList arrayList = new ArrayList();
                    if (carouselOffers != null && carouselOffers.size() > 0) {
                        for (int i2 = 0; i2 < carouselOffers.size(); i2++) {
                            String layout = carouselOffers.get(i2).getLayout();
                            if (layout != null && !TextUtils.isEmpty(layout) && layout.equalsIgnoreCase("carousel")) {
                                arrayList.add(carouselOffers.get(i2));
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        CJRHomePageLayout cJRHomePageLayout = (CJRHomePageLayout) arrayList.get(0);
                        try {
                            final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.bus_hotel_banner_lyt);
                            final ImageView imageView = (ImageView) findViewById(R.id.carousal_list);
                            if (cJRHomePageLayout != null) {
                                if (cJRHomePageLayout.getHomePageItemList() != null && cJRHomePageLayout.getHomePageItemList().size() > 0) {
                                    CJRHomePageItem cJRHomePageItem = cJRHomePageLayout.getHomePageItemList().get(0);
                                    imageView.setTag(cJRHomePageItem);
                                    if (!(cJRHomePageItem == null || cJRHomePageItem.getImageUrl() == null)) {
                                        ai.INSTANCE.getImageLoader().get(cJRHomePageItem.getImageUrl().replace(" ", "%20"), new ImageLoader.ImageListener() {
                                            public final void onErrorResponse(VolleyError volleyError) {
                                            }

                                            public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                                                Bitmap bitmap;
                                                if (imageContainer != null && (bitmap = imageContainer.getBitmap()) != null) {
                                                    imageView.setImageBitmap(bitmap);
                                                    linearLayout.setVisibility(0);
                                                }
                                            }
                                        });
                                    }
                                }
                                imageView.setOnClickListener(new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        try {
                                            if (view.getTag() != null) {
                                                CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) view.getTag();
                                                String url = cJRHomePageItem.getURL();
                                                if (!TextUtils.isEmpty(url) && url.startsWith("paytmmp://")) {
                                                    AJROrderSummaryActivityBase.this.a(cJRHomePageItem.getURLType(), cJRHomePageItem, 0, (ArrayList<? extends CJRItem>) null, "");
                                                    return;
                                                }
                                            }
                                        } catch (Exception e2) {
                                            q.b(e2.getMessage());
                                        }
                                        net.one97.paytm.hotels2.utils.a.a(AJROrderSummaryActivityBase.this);
                                    }
                                });
                                return;
                            }
                            linearLayout.setVisibility(8);
                        } catch (IndexOutOfBoundsException e2) {
                            if (com.paytm.utility.b.v) {
                                q.b(e2.getMessage());
                            }
                        } catch (Exception e3) {
                            if (com.paytm.utility.b.v) {
                                q.b(e3.getMessage());
                            }
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e4) {
                if (com.paytm.utility.b.v) {
                    q.b(e4.getMessage());
                }
            } catch (Exception e5) {
                if (com.paytm.utility.b.v) {
                    q.b(e5.getMessage());
                }
            }
        }
    }

    private boolean A() {
        try {
            ArrayList<CJROrderedCart> orderedCartList = this.J.getOrderedCartList();
            if (orderedCartList == null || orderedCartList.size() <= 0 || Integer.parseInt(orderedCartList.get(0).getItemStatus()) != 7) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return false;
    }

    private void g(String str) {
        if (this.aX && !TextUtils.isEmpty(this.L) && (this.L.equalsIgnoreCase("Payment") || this.L.equalsIgnoreCase("paytm_automatic"))) {
            int categoryId = (int) this.J.getOrderedCartList().get(0).getProductDetail().getCategoryId();
            this.J.getOrderedCartList().get(0).getProductDetail().getVerticalId();
            if (categoryId == 21 || categoryId == 5 || categoryId == 9) {
                categoryId = 17;
            } else if (categoryId == 23 || categoryId == 7 || categoryId == 11) {
                categoryId = 19;
            } else if (categoryId == 6) {
                categoryId = 18;
            } else if (categoryId == 13) {
                categoryId = 78640;
            }
            net.one97.paytm.cashback.posttxn.e a2 = net.one97.paytm.deeplink.e.a() ? net.one97.paytm.cashback.posttxn.c.a() : null;
            if (!TextUtils.isEmpty(this.L) && ((this.L.equalsIgnoreCase("Payment") || this.L.equalsIgnoreCase("paytm_automatic")) && a2 != null && a2.a(0, categoryId))) {
                a2.a(this);
                f.a aVar = new f.a();
                aVar.f49546b = str;
                a2.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) null);
            }
        }
        if (!TextUtils.isEmpty(this.L) && this.L.equalsIgnoreCase("Payment") && !this.bE && "7".equalsIgnoreCase(this.bj.getItemStatus()) && !TextUtils.isEmpty(this.J.getId())) {
            try {
                SFInterface.INSTANCE.notifySuccessTransaction(this.J.getId());
                this.bE = true;
                q.d("OrderId -> " + this.J.getId());
            } catch (Exception unused) {
            }
        }
    }

    private void a(String str, ViewGroup viewGroup) {
        if (!TextUtils.isEmpty(this.L) && this.L.equalsIgnoreCase("Payment")) {
            net.one97.paytm.cashback.posttxn.e a2 = net.one97.paytm.deeplink.e.a() ? net.one97.paytm.cashback.posttxn.c.a() : null;
            if (a2 != null && a2.a(net.one97.paytm.utils.b.a.BUS_TICKETS.getId(), 0)) {
                viewGroup.setVisibility(0);
                viewGroup.removeAllViews();
                a2.a(this);
                a2.a(this);
                f.a aVar = new f.a();
                aVar.f49546b = str;
                a2.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) null);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r12v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r12v17 */
    /* JADX WARNING: type inference failed for: r12v21 */
    /* JADX WARNING: type inference failed for: r12v22 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0407, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0408, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x040b, code lost:
        if (com.paytm.utility.b.v != false) goto L_0x040d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x040d, code lost:
        com.paytm.utility.q.b(r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0423, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0424, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0427, code lost:
        if (com.paytm.utility.b.v != false) goto L_0x0429;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0429, code lost:
        com.paytm.utility.q.b(r1.getMessage());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:193:0x04be */
    /* JADX WARNING: Missing exception handler attribute for start block: B:499:0x1153 */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0423 A[Catch:{ Exception -> 0x1434 }, ExcHandler: IndexOutOfBoundsException (r0v5 'e' java.lang.IndexOutOfBoundsException A[CUSTOM_DECLARE, Catch:{ Exception -> 0x1434 }]), Splitter:B:112:0x02b8] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x04d0 A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x04df A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0501 A[SYNTHETIC, Splitter:B:204:0x0501] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x086c A[SYNTHETIC, Splitter:B:270:0x086c] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0915 A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0b5d A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0b9d  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x0c0e A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x0c30 A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0c56 A[Catch:{ Exception -> 0x0cfa }] */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0d0e A[SYNTHETIC, Splitter:B:402:0x0d0e] */
    /* JADX WARNING: Removed duplicated region for block: B:494:0x10d0 A[Catch:{ Exception -> 0x1153 }] */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x10e6 A[Catch:{ Exception -> 0x1153 }] */
    /* JADX WARNING: Removed duplicated region for block: B:497:0x10e9 A[Catch:{ Exception -> 0x1153 }] */
    /* JADX WARNING: Removed duplicated region for block: B:498:0x1128 A[Catch:{ Exception -> 0x1153 }] */
    /* JADX WARNING: Removed duplicated region for block: B:504:0x1163 A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:514:0x11d9 A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:523:0x1256 A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:543:0x1362 A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:546:0x1395 A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:554:0x13cc A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:557:0x13d8 A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:575:0x1416 A[Catch:{ Exception -> 0x1434 }] */
    /* JADX WARNING: Removed duplicated region for block: B:576:0x141a A[Catch:{ Exception -> 0x1434 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B() {
        /*
            r27 = this;
            r11 = r27
            boolean r1 = r27.U()
            r12 = 8
            r13 = 0
            if (r1 != 0) goto L_0x001f
            r1 = 2131369854(0x7f0a1f7e, float:1.8359698E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r13)
            r1 = 2131370450(0x7f0a21d2, float:1.8360907E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r12)
        L_0x001f:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J
            if (r1 == 0) goto L_0x0053
            boolean r1 = r27.P()
            if (r1 == 0) goto L_0x0053
            boolean r1 = r27.A()
            if (r1 == 0) goto L_0x0053
            boolean r1 = r11.bx
            if (r1 != 0) goto L_0x0053
            r1 = 2130772026(0x7f01003a, float:1.7147159E38)
            android.view.animation.Animation r1 = android.view.animation.AnimationUtils.loadAnimation(r11, r1)
            android.widget.FrameLayout r2 = r11.aP
            r2.startAnimation(r1)
            android.widget.FrameLayout r1 = r11.aP
            r1.setVisibility(r13)
            android.os.Handler r1 = new android.os.Handler
            r1.<init>()
            net.one97.paytm.AJROrderSummaryActivityBase$10 r2 = new net.one97.paytm.AJROrderSummaryActivityBase$10
            r2.<init>()
            r3 = 5000(0x1388, double:2.4703E-320)
            r1.postDelayed(r2, r3)
        L_0x0053:
            r27.R()
            java.lang.String r1 = r11.L
            java.lang.String r14 = "Payment"
            if (r1 == 0) goto L_0x008b
            boolean r1 = r1.equalsIgnoreCase(r14)
            if (r1 == 0) goto L_0x008b
            java.lang.String r1 = r27.W()
            if (r1 == 0) goto L_0x008b
            java.lang.String r1 = r27.W()
            java.lang.String r2 = "7"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 != 0) goto L_0x0080
            java.lang.String r1 = r27.W()
            java.lang.String r2 = "6"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x008b
        L_0x0080:
            r1 = 2131367832(0x7f0a1798, float:1.8355597E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r12)
            goto L_0x0095
        L_0x008b:
            r1 = 2131367832(0x7f0a1798, float:1.8355597E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r12)
        L_0x0095:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J     // Catch:{ Exception -> 0x1434 }
            com.paytm.network.model.CJRStatusError r1 = r1.getError()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x00e0
            java.lang.String r2 = r1.getmResult()     // Catch:{ Exception -> 0x1434 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x1434 }
            if (r2 != 0) goto L_0x00cc
            java.lang.String r2 = r1.getmResult()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = "failure"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x1434 }
            if (r2 == 0) goto L_0x00cc
            com.paytm.network.model.CJRError r2 = r1.getmMessage()     // Catch:{ Exception -> 0x1434 }
            if (r2 == 0) goto L_0x00cc
            com.paytm.network.model.CJRError r2 = r1.getmMessage()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r2 = r2.getTitle()     // Catch:{ Exception -> 0x1434 }
            com.paytm.network.model.CJRError r1 = r1.getmMessage()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x1434 }
            com.paytm.utility.b.b((android.content.Context) r11, (java.lang.String) r2, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
        L_0x00cc:
            r1 = 2131369854(0x7f0a1f7e, float:1.8359698E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r12)     // Catch:{ Exception -> 0x1434 }
            r1 = 2131370450(0x7f0a21d2, float:1.8360907E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r12)     // Catch:{ Exception -> 0x1434 }
        L_0x00e0:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.util.ArrayList r15 = r1.getOrderedCartList()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r27.V()     // Catch:{ Exception -> 0x1434 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            r10 = 1
            if (r2 != 0) goto L_0x0184
            java.lang.String r2 = "SUCCESS"
            boolean r2 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x1434 }
            if (r2 != 0) goto L_0x0182
            java.lang.String r2 = "FAILED"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x0182
            java.lang.String r1 = r11.L     // Catch:{ Exception -> 0x1434 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x0184
            java.lang.String r1 = r11.L     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r1.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0184
            boolean r1 = r11.R     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x013a
            android.os.Handler r1 = new android.os.Handler     // Catch:{ Exception -> 0x1434 }
            r1.<init>()     // Catch:{ Exception -> 0x1434 }
            r11.f51394a = r1     // Catch:{ Exception -> 0x1434 }
            r11.R = r10     // Catch:{ Exception -> 0x1434 }
            r11.P = r10     // Catch:{ Exception -> 0x1434 }
            java.util.Timer r1 = new java.util.Timer     // Catch:{ Exception -> 0x1434 }
            r1.<init>()     // Catch:{ Exception -> 0x1434 }
            r11.aU = r1     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r27.T()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0130
            r1 = 20000(0x4e20, double:9.8813E-320)
            goto L_0x0132
        L_0x0130:
            r1 = 10000(0x2710, double:4.9407E-320)
        L_0x0132:
            java.util.Timer r3 = r11.aU     // Catch:{ Exception -> 0x1434 }
            java.util.TimerTask r4 = r11.f51395b     // Catch:{ Exception -> 0x1434 }
            r3.schedule(r4, r1)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0184
        L_0x013a:
            boolean r1 = r11.S     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x015c
            r11.S = r10     // Catch:{ Exception -> 0x1434 }
            r11.P = r10     // Catch:{ Exception -> 0x1434 }
            java.util.Timer r1 = new java.util.Timer     // Catch:{ Exception -> 0x1434 }
            r1.<init>()     // Catch:{ Exception -> 0x1434 }
            r11.aU = r1     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r27.T()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0152
            r1 = 30000(0x7530, double:1.4822E-319)
            goto L_0x0154
        L_0x0152:
            r1 = 5000(0x1388, double:2.4703E-320)
        L_0x0154:
            java.util.Timer r3 = r11.aU     // Catch:{ Exception -> 0x1434 }
            java.util.TimerTask r4 = r11.f51396c     // Catch:{ Exception -> 0x1434 }
            r3.schedule(r4, r1)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0184
        L_0x015c:
            boolean r1 = r11.T     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x017f
            r11.T = r10     // Catch:{ Exception -> 0x1434 }
            r11.P = r10     // Catch:{ Exception -> 0x1434 }
            java.util.Timer r1 = new java.util.Timer     // Catch:{ Exception -> 0x1434 }
            r1.<init>()     // Catch:{ Exception -> 0x1434 }
            r11.aU = r1     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r27.T()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0175
            r1 = 45000(0xafc8, double:2.2233E-319)
            goto L_0x0177
        L_0x0175:
            r1 = 10000(0x2710, double:4.9407E-320)
        L_0x0177:
            java.util.Timer r3 = r11.aU     // Catch:{ Exception -> 0x1434 }
            java.util.TimerTask r4 = r11.f51397d     // Catch:{ Exception -> 0x1434 }
            r3.schedule(r4, r1)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0184
        L_0x017f:
            r11.P = r13     // Catch:{ Exception -> 0x1434 }
            goto L_0x0184
        L_0x0182:
            r11.P = r13     // Catch:{ Exception -> 0x1434 }
        L_0x0184:
            if (r15 == 0) goto L_0x02ab
            int r1 = r15.size()     // Catch:{ Exception -> 0x1434 }
            if (r1 <= 0) goto L_0x02ab
            r11.c((java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart>) r15)     // Catch:{ Exception -> 0x1434 }
            java.lang.Object r1 = r15.get(r13)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getStatus()     // Catch:{ Exception -> 0x1434 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x0205
            java.lang.Object r1 = r15.get(r13)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1434 }
            boolean r1 = g((net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x01bd
            java.lang.Object r1 = r15.get(r13)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getStatus()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r2 = "BOOKED"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0205
        L_0x01bd:
            boolean r1 = r11.f51402i     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x01d4
            r1 = 2131363169(0x7f0a0561, float:1.834614E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r2 = r2.getId()     // Catch:{ Exception -> 0x1434 }
            r11.a((java.lang.String) r2, (android.view.ViewGroup) r1)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0205
        L_0x01d4:
            r1 = 2131366562(0x7f0a12a2, float:1.8353021E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ Exception -> 0x1434 }
            r2 = 2131362382(0x7f0a024e, float:1.8344543E38)
            android.view.View r2 = r11.findViewById(r2)     // Catch:{ Exception -> 0x1434 }
            android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2     // Catch:{ Exception -> 0x1434 }
            r1.indexOfChild(r2)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getId()     // Catch:{ Exception -> 0x1434 }
            r11.g((java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.recharge.common.utils.j r1 = r11.bz     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0205
            net.one97.paytm.recharge.common.h.f r1 = r11.by     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0205
            boolean r1 = r11.bQ     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0205
            net.one97.paytm.recharge.common.h.f r1 = r11.by     // Catch:{ Exception -> 0x1434 }
            boolean r2 = r11.bP     // Catch:{ Exception -> 0x1434 }
            r1.a((boolean) r2)     // Catch:{ Exception -> 0x1434 }
        L_0x0205:
            java.lang.Object r1 = r15.get(r13)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription r1 = r1.getSubscription()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x022e
            java.lang.Object r1 = r15.get(r13)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription r1 = r1.getSubscription()     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r1.getIsApplicable()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x022e
            java.lang.Object r1 = r15.get(r13)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getRechargeNumber()     // Catch:{ Exception -> 0x1434 }
            r11.q((java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
        L_0x022e:
            r1 = 2131370682(0x7f0a22ba, float:1.8361377E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x1434 }
            boolean r2 = r27.O()     // Catch:{ Exception -> 0x1434 }
            if (r2 == 0) goto L_0x028d
            boolean r2 = r27.Q()     // Catch:{ Exception -> 0x1434 }
            if (r2 != 0) goto L_0x028d
            boolean r2 = r27.R()     // Catch:{ Exception -> 0x1434 }
            if (r2 != 0) goto L_0x027b
            int r2 = r15.size()     // Catch:{ Exception -> 0x1434 }
            if (r2 != r10) goto L_0x025f
            r3 = 2131960094(0x7f13211e, float:1.9556847E38)
            java.lang.Object[] r4 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x1434 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x1434 }
            r4[r13] = r2     // Catch:{ Exception -> 0x1434 }
            java.lang.String r2 = r11.getString(r3, r4)     // Catch:{ Exception -> 0x1434 }
            goto L_0x026e
        L_0x025f:
            r3 = 2131960073(0x7f132109, float:1.9556804E38)
            java.lang.Object[] r4 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x1434 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x1434 }
            r4[r13] = r2     // Catch:{ Exception -> 0x1434 }
            java.lang.String r2 = r11.getString(r3, r4)     // Catch:{ Exception -> 0x1434 }
        L_0x026e:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x1434 }
            if (r3 != 0) goto L_0x02b5
            r1.setText(r2)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r13)     // Catch:{ Exception -> 0x1434 }
            goto L_0x02b5
        L_0x027b:
            android.content.res.Resources r2 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            r3 = 2131964406(0x7f1331f6, float:1.9565593E38)
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x1434 }
            r1.setText(r2)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r13)     // Catch:{ Exception -> 0x1434 }
            goto L_0x02b5
        L_0x028d:
            r1.setVisibility(r12)     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r27.Q()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x02b5
            r1 = 2131370018(0x7f0a2022, float:1.836003E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r12)     // Catch:{ Exception -> 0x1434 }
            r1 = 2131370019(0x7f0a2023, float:1.8360033E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r12)     // Catch:{ Exception -> 0x1434 }
            goto L_0x02b5
        L_0x02ab:
            r1 = 2131370682(0x7f0a22ba, float:1.8361377E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r12)     // Catch:{ Exception -> 0x1434 }
        L_0x02b5:
            r9 = 2
            if (r15 == 0) goto L_0x0430
            int r1 = r15.size()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r1 <= 0) goto L_0x0430
            java.lang.String r1 = ""
            r2 = r1
            r1 = 0
        L_0x02c2:
            int r3 = r15.size()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r1 >= r3) goto L_0x0389
            java.lang.Object r3 = r15.get(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r3 == 0) goto L_0x0385
            java.lang.Object r3 = r15.get(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r3.getProductDetail()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r3 == 0) goto L_0x0385
            java.lang.Object r3 = r15.get(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r3.getProductDetail()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.String r3 = r3.getProductType()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r3 == 0) goto L_0x0385
            java.lang.Object r3 = r15.get(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r3 = r3.getProductDetail()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.String r3 = r3.getProductType()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.String r4 = "Recharge"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r3 != 0) goto L_0x0385
            java.lang.Object r3 = r15.get(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.util.ArrayList r3 = r3.getStatusFlow()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r3 == 0) goto L_0x0385
            int r4 = r3.size()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r4 <= 0) goto L_0x0385
            int r4 = r3.size()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            r5 = 3
            if (r4 != r5) goto L_0x0385
            java.lang.Object r4 = r3.get(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r4 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r4     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.Boolean r4 = r4.getDisabled()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            boolean r4 = r4.booleanValue()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r4 != 0) goto L_0x0385
            java.lang.Object r4 = r3.get(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r4 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r4     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.String r4 = r4.getLabel()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r4 == 0) goto L_0x0385
            java.lang.Object r3 = r3.get(r9)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r3 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r3     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.String r3 = r3.getLabel()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.String r4 = "Delivered"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r3 == 0) goto L_0x0385
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r3 == 0) goto L_0x0367
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            r3.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.Object r2 = r15.get(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            long r4 = r2.getId()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.String r2 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            goto L_0x0385
        L_0x0367:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            r3.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.String r2 = ","
            r3.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.Object r2 = r15.get(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            long r4 = r2.getId()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            java.lang.String r2 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
        L_0x0385:
            int r1 = r1 + 1
            goto L_0x02c2
        L_0x0389:
            if (r2 == 0) goto L_0x0430
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r1 != 0) goto L_0x0430
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            java.lang.String r1 = "sellerratingFetchFromOrder"
            java.lang.String r1 = net.one97.paytm.j.c.a(r1)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            android.content.Context r3 = r27.getApplicationContext()     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            com.paytm.b.a.a r3 = net.one97.paytm.utils.ag.a(r3)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            java.lang.String r4 = "sso_token="
            java.lang.String r5 = ""
            java.lang.String r3 = r3.b((java.lang.String) r4, (java.lang.String) r5, (boolean) r10)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            if (r1 == 0) goto L_0x0430
            java.lang.String r4 = ""
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            if (r4 != 0) goto L_0x0430
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r4.<init>()     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r4.append(r1)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            java.lang.String r1 = "?sso_token="
            r4.append(r1)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r4.append(r3)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r3.<init>()     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r3.append(r1)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            java.lang.String r1 = "&item_id="
            r3.append(r1)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r3.append(r2)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r1.<init>()     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r4 = "application/json"
            r1.put(r3, r4)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r4 = 0
            r5 = 0
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.GET     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r7 = 0
            net.one97.paytm.common.entity.SellerRating.CJROrderSummarySellarRating r8 = new net.one97.paytm.common.entity.SellerRating.CJROrderSummarySellarRating     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r8.<init>()     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            com.paytm.network.a$c r16 = com.paytm.network.a.c.HOME     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            com.paytm.network.a$b r17 = com.paytm.network.a.b.SILENT     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r1 = r27
            r3 = r27
            r9 = r16
            r10 = r17
            com.paytm.network.a r1 = net.one97.paytm.common.b.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            r1.a()     // Catch:{ Exception -> 0x0407, IndexOutOfBoundsException -> 0x0423 }
            goto L_0x0430
        L_0x0407:
            r0 = move-exception
            r1 = r0
            boolean r2 = com.paytm.utility.b.v     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            if (r2 == 0) goto L_0x0430
            java.lang.String r1 = r1.getMessage()     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            com.paytm.utility.q.b(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0423, Exception -> 0x0415 }
            goto L_0x0430
        L_0x0415:
            r0 = move-exception
            r1 = r0
            boolean r2 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x1434 }
            if (r2 == 0) goto L_0x0430
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x1434 }
            com.paytm.utility.q.b(r1)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0430
        L_0x0423:
            r0 = move-exception
            r1 = r0
            boolean r2 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x1434 }
            if (r2 == 0) goto L_0x0430
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x1434 }
            com.paytm.utility.q.b(r1)     // Catch:{ Exception -> 0x1434 }
        L_0x0430:
            boolean r1 = r27.Q()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0441
            r1 = 2131363623(0x7f0a0727, float:1.834706E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r12)     // Catch:{ Exception -> 0x1434 }
            goto L_0x044b
        L_0x0441:
            r1 = 2131363623(0x7f0a0727, float:1.834706E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r13)     // Catch:{ Exception -> 0x1434 }
        L_0x044b:
            if (r15 == 0) goto L_0x04ee
            int r1 = r15.size()     // Catch:{ Exception -> 0x1434 }
            if (r1 <= 0) goto L_0x04ee
            java.lang.Object r1 = r15.get(r13)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x04ee
            java.lang.Object r1 = r15.get(r13)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r9 = r1.getProductDetail()     // Catch:{ Exception -> 0x1434 }
            long r1 = r9.getCategoryId()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r2 = java.lang.Long.toString(r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r3 = r1.getGrandTotal()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x1434 }
            r1 = 2131363623(0x7f0a0727, float:1.834706E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x1434 }
            if (r9 == 0) goto L_0x04ee
            java.lang.String r1 = r9.getVertical()     // Catch:{ Exception -> 0x1434 }
            r11.br = r1     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r11.L     // Catch:{ Exception -> 0x04bd }
            boolean r3 = r3.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x04bd }
            if (r3 == 0) goto L_0x04bd
            boolean r3 = r11.bq     // Catch:{ Exception -> 0x04bd }
            if (r3 != 0) goto L_0x04bd
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x04bd }
            java.lang.String r8 = net.one97.paytm.j.c.v()     // Catch:{ Exception -> 0x04bd }
            r7 = 1
            r11.bq = r7     // Catch:{ Exception -> 0x04bd }
            java.lang.String r3 = r11.br     // Catch:{ Exception -> 0x04bd }
            boolean r3 = net.one97.paytm.utils.l.b((java.lang.String) r3)     // Catch:{ Exception -> 0x04bd }
            android.content.Context r5 = r27.getApplicationContext()     // Catch:{ Exception -> 0x04bd }
            java.lang.String r5 = com.paytm.utility.b.R((android.content.Context) r5)     // Catch:{ Exception -> 0x04bd }
            if (r5 != 0) goto L_0x04b5
            java.lang.String r5 = ""
        L_0x04b5:
            r6 = r27
            r12 = 1
            r7 = r15
            net.one97.paytm.j.a.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3, (java.lang.String) r4, (java.lang.String) r5, (android.content.Context) r6, (java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart>) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x04be }
            goto L_0x04be
        L_0x04bd:
            r12 = 1
        L_0x04be:
            java.lang.String r1 = r9.getProductType()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x04df
            java.lang.String r1 = r9.getProductType()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r2 = "Recharge"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x04df
            android.content.res.Resources r1 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            r2 = 2131962229(0x7f132975, float:1.9561177E38)
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x1434 }
            r10.setText(r1)     // Catch:{ Exception -> 0x1434 }
            goto L_0x04ef
        L_0x04df:
            android.content.res.Resources r1 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            r2 = 2131953844(0x7f1308b4, float:1.954417E38)
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x1434 }
            r10.setText(r1)     // Catch:{ Exception -> 0x1434 }
            goto L_0x04ef
        L_0x04ee:
            r12 = 1
        L_0x04ef:
            java.lang.Object r1 = r15.get(r13)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()     // Catch:{ Exception -> 0x1434 }
            java.util.ArrayList r1 = r1.getCategoryMap()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r2 = "/summary"
            if (r1 == 0) goto L_0x0b47
            boolean r1 = r11.aN     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x0b47
            r11.aN = r12     // Catch:{ Exception -> 0x1434 }
            java.lang.Object r1 = r15.get(r13)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()     // Catch:{ Exception -> 0x1434 }
            java.util.ArrayList r1 = r1.getCategoryMap()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = "screenName"
            java.lang.String r4 = "_payment_status"
            java.lang.String r5 = "utilities_"
            if (r1 == 0) goto L_0x0834
            int r6 = r1.size()     // Catch:{ Exception -> 0x1434 }
            if (r6 <= r12) goto L_0x0834
            java.lang.Object r6 = r1.get(r12)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r6 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r6     // Catch:{ Exception -> 0x1434 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x1434 }
            r7.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = "Recharge"
            boolean r8 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r9 = "_summary_page_loaded"
            if (r8 == 0) goto L_0x05eb
            int r8 = r1.size()     // Catch:{ Exception -> 0x1434 }
            r10 = 2
            if (r8 <= r10) goto L_0x0835
            java.lang.Object r1 = r1.get(r10)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r1 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r1     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = "DTH"
            boolean r8 = r1.contains(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 != 0) goto L_0x05b7
            java.lang.String r8 = "dth"
            boolean r8 = r1.contains(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 == 0) goto L_0x0567
            goto L_0x05b7
        L_0x0567:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r8.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r13 = a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r8.append(r13)     // Catch:{ Exception -> 0x1434 }
            r8.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r13 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r13 = r13.getPaymentStatus()     // Catch:{ Exception -> 0x1434 }
            r7.put(r8, r13)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = "recharge_business_sub_vertical"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r13.<init>()     // Catch:{ Exception -> 0x1434 }
            r13.append(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r12 = "_prepaid"
            r13.append(r12)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r12 = r13.toString()     // Catch:{ Exception -> 0x1434 }
            r7.put(r8, r12)     // Catch:{ Exception -> 0x1434 }
            r7.put(r3, r2)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r8.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r8.append(r1)     // Catch:{ Exception -> 0x1434 }
            r8.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r8.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.b((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r7, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.C()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0835
        L_0x05b7:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r7.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r7.append(r8)     // Catch:{ Exception -> 0x1434 }
            r7.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r8.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r8.append(r1)     // Catch:{ Exception -> 0x1434 }
            r8.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r8.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r6 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.getPaymentStatus()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.a((java.lang.String) r7, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r6, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.C()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0835
        L_0x05eb:
            r10 = 2
            java.lang.String r8 = "Bill Payment"
            boolean r8 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 == 0) goto L_0x0693
            int r6 = r1.size()     // Catch:{ Exception -> 0x1434 }
            if (r6 <= r10) goto L_0x0835
            java.lang.Object r1 = r1.get(r10)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r1 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r1     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = "landline"
            boolean r6 = r1.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x1434 }
            if (r6 == 0) goto L_0x0641
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r5.concat(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r6.<init>()     // Catch:{ Exception -> 0x1434 }
            r6.append(r1)     // Catch:{ Exception -> 0x1434 }
            r6.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r7.<init>()     // Catch:{ Exception -> 0x1434 }
            r7.append(r1)     // Catch:{ Exception -> 0x1434 }
            r7.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.getPaymentStatus()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.a((java.lang.String) r6, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r7, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0835
        L_0x0641:
            java.lang.String r6 = "recharge"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r8.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r12 = a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r8.append(r12)     // Catch:{ Exception -> 0x1434 }
            r8.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r12 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r12 = r12.getPaymentStatus()     // Catch:{ Exception -> 0x1434 }
            r7.put(r8, r12)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = "recharge_business_sub_vertical"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r12.<init>()     // Catch:{ Exception -> 0x1434 }
            r12.append(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r13 = "_postpaid"
            r12.append(r13)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x1434 }
            r7.put(r8, r12)     // Catch:{ Exception -> 0x1434 }
            r7.put(r3, r2)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r8.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r8.append(r1)     // Catch:{ Exception -> 0x1434 }
            r8.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r8.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.b((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r7, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.C()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0835
        L_0x0693:
            java.lang.String r8 = "gas"
            boolean r8 = r8.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x1434 }
            if (r8 == 0) goto L_0x06cf
            java.lang.String r1 = "/gas-pipeline/summary"
            net.one97.paytm.j.a.b((android.content.Context) r11, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.recharge.ordersummary.h.d r1 = new net.one97.paytm.recharge.ordersummary.h.d     // Catch:{ Exception -> 0x1434 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r19 = "gas_pipeline"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r6.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = net.one97.paytm.common.utility.d.eF     // Catch:{ Exception -> 0x1434 }
            r6.append(r7)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.getPaymentStatus()     // Catch:{ Exception -> 0x1434 }
            r6.append(r7)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r20 = r6.toString()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r21 = ""
            java.lang.String r22 = ""
            java.lang.String r23 = "cylinder_booking"
            java.lang.String r24 = ""
            java.lang.String r25 = ""
            r18 = r1
            r18.a(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0835
        L_0x06cf:
            java.lang.String r8 = "cylinder booking"
            boolean r8 = r8.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x1434 }
            if (r8 == 0) goto L_0x070b
            java.lang.String r1 = "/book-cylinder/summary"
            net.one97.paytm.j.a.b((android.content.Context) r11, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.recharge.ordersummary.h.d r1 = new net.one97.paytm.recharge.ordersummary.h.d     // Catch:{ Exception -> 0x1434 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r19 = "book_cylinder"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r6.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = net.one97.paytm.common.utility.d.eF     // Catch:{ Exception -> 0x1434 }
            r6.append(r7)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.getPaymentStatus()     // Catch:{ Exception -> 0x1434 }
            r6.append(r7)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r20 = r6.toString()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r21 = ""
            java.lang.String r22 = ""
            java.lang.String r23 = "cylinder_booking"
            java.lang.String r24 = ""
            java.lang.String r25 = ""
            r18 = r1
            r18.a(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0835
        L_0x070b:
            java.lang.String r8 = "Metro"
            boolean r8 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 != 0) goto L_0x0801
            java.lang.String r8 = "Landline"
            boolean r8 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 != 0) goto L_0x0801
            java.lang.String r8 = "Electricity"
            boolean r8 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 != 0) goto L_0x0801
            java.lang.String r8 = "Insurance"
            boolean r8 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 != 0) goto L_0x0801
            java.lang.String r8 = "Water"
            boolean r8 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 == 0) goto L_0x0735
            goto L_0x0801
        L_0x0735:
            java.lang.String r8 = "Education"
            boolean r8 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 == 0) goto L_0x0786
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r5.concat(r6)     // Catch:{ Exception -> 0x1434 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x1434 }
            r8 = 1
            if (r1 <= r8) goto L_0x0835
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r1.<init>()     // Catch:{ Exception -> 0x1434 }
            r1.append(r6)     // Catch:{ Exception -> 0x1434 }
            r1.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r8 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = r8.getPaymentStatus()     // Catch:{ Exception -> 0x1434 }
            r7.put(r1, r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = "utilities_education_business_sub_vertical"
            java.lang.String r8 = "fee_payment"
            r7.put(r1, r8)     // Catch:{ Exception -> 0x1434 }
            r7.put(r3, r2)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r1.<init>()     // Catch:{ Exception -> 0x1434 }
            r1.append(r6)     // Catch:{ Exception -> 0x1434 }
            r1.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.b((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r7, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.C()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0835
        L_0x0786:
            r6 = 0
            java.lang.Object r8 = r1.get(r6)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r8 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r8     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r8.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = "Education"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            if (r6 == 0) goto L_0x0835
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x1434 }
            r8 = 0
            java.lang.Object r12 = r1.get(r8)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r12 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r12     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = r12.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ Exception -> 0x1434 }
            r6.append(r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x1434 }
            int r8 = r1.size()     // Catch:{ Exception -> 0x1434 }
            r12 = 1
            if (r8 <= r12) goto L_0x0835
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r8.<init>()     // Catch:{ Exception -> 0x1434 }
            r8.append(r6)     // Catch:{ Exception -> 0x1434 }
            r8.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r12 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r12 = r12.getPaymentStatus()     // Catch:{ Exception -> 0x1434 }
            r7.put(r8, r12)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = "utilities_education_business_sub_vertical"
            r12 = 1
            java.lang.Object r1 = r1.get(r12)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r1 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r1     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = p((java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r7.put(r8, r1)     // Catch:{ Exception -> 0x1434 }
            r7.put(r3, r2)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r1.<init>()     // Catch:{ Exception -> 0x1434 }
            r1.append(r6)     // Catch:{ Exception -> 0x1434 }
            r1.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.b((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r7, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.C()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0835
        L_0x0801:
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r5.concat(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r6.<init>()     // Catch:{ Exception -> 0x1434 }
            r6.append(r1)     // Catch:{ Exception -> 0x1434 }
            r6.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r7.<init>()     // Catch:{ Exception -> 0x1434 }
            r7.append(r1)     // Catch:{ Exception -> 0x1434 }
            r7.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.getPaymentStatus()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.a((java.lang.String) r6, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r7, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.C()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0835
        L_0x0834:
            r10 = 2
        L_0x0835:
            r1 = 0
            java.lang.Object r6 = r15.get(r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r6 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r6     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r6.getProductDetail()     // Catch:{ Exception -> 0x1434 }
            java.util.ArrayList r1 = r1.getCategoryMap()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0b48
            int r6 = r1.size()     // Catch:{ Exception -> 0x1434 }
            r7 = 1
            if (r6 <= r7) goto L_0x0b48
            java.lang.Object r6 = r1.get(r7)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r6 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r6     // Catch:{ Exception -> 0x1434 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x1434 }
            r7.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = "Recharge"
            boolean r8 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r9 = "_order_status"
            java.lang.String r12 = "_order_successful_displayed"
            if (r8 == 0) goto L_0x0915
            int r5 = r1.size()     // Catch:{ Exception -> 0x1434 }
            if (r5 <= r10) goto L_0x0b48
            java.lang.Object r1 = r1.get(r10)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r1 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r1     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = "DTH"
            boolean r5 = r1.contains(r5)     // Catch:{ Exception -> 0x1434 }
            if (r5 != 0) goto L_0x08e1
            java.lang.String r5 = "dth"
            boolean r5 = r1.contains(r5)     // Catch:{ Exception -> 0x1434 }
            if (r5 == 0) goto L_0x0891
            goto L_0x08e1
        L_0x0891:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r4.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r4.append(r5)     // Catch:{ Exception -> 0x1434 }
            r4.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = r5.getStatus()     // Catch:{ Exception -> 0x1434 }
            r7.put(r4, r5)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = "recharge_business_sub_vertical"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r5.<init>()     // Catch:{ Exception -> 0x1434 }
            r5.append(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = "_prepaid"
            r5.append(r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x1434 }
            r7.put(r4, r5)     // Catch:{ Exception -> 0x1434 }
            r7.put(r3, r2)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r3.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r3.append(r1)     // Catch:{ Exception -> 0x1434 }
            r3.append(r12)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.b((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r7, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.D()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0b48
        L_0x08e1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r3.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r3.append(r5)     // Catch:{ Exception -> 0x1434 }
            r3.append(r12)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r5.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = a((java.lang.String) r6, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r5.append(r1)     // Catch:{ Exception -> 0x1434 }
            r5.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r4.getStatus()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.a((java.lang.String) r3, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r4, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.D()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0b48
        L_0x0915:
            java.lang.String r4 = "Bill Payment"
            boolean r4 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 == 0) goto L_0x09bc
            int r4 = r1.size()     // Catch:{ Exception -> 0x1434 }
            if (r4 <= r10) goto L_0x0b48
            java.lang.Object r1 = r1.get(r10)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r1 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r1     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = "landline"
            boolean r4 = r1.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 == 0) goto L_0x096a
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r5.concat(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r3.<init>()     // Catch:{ Exception -> 0x1434 }
            r3.append(r1)     // Catch:{ Exception -> 0x1434 }
            r3.append(r12)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r4.<init>()     // Catch:{ Exception -> 0x1434 }
            r4.append(r1)     // Catch:{ Exception -> 0x1434 }
            r4.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r4.getStatus()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.a((java.lang.String) r3, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r4, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0b48
        L_0x096a:
            java.lang.String r4 = "recharge"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r5.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = a((java.lang.String) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r5.append(r6)     // Catch:{ Exception -> 0x1434 }
            r5.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r6 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.getStatus()     // Catch:{ Exception -> 0x1434 }
            r7.put(r5, r6)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = "recharge_business_sub_vertical"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r6.<init>()     // Catch:{ Exception -> 0x1434 }
            r6.append(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = "_postpaid"
            r6.append(r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x1434 }
            r7.put(r5, r6)     // Catch:{ Exception -> 0x1434 }
            r7.put(r3, r2)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r3.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = a((java.lang.String) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r3.append(r1)     // Catch:{ Exception -> 0x1434 }
            r3.append(r12)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.b((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r7, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.D()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0b48
        L_0x09bc:
            java.lang.String r4 = "gas"
            boolean r4 = r4.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x1434 }
            if (r4 == 0) goto L_0x09ed
            net.one97.paytm.recharge.ordersummary.h.d r1 = new net.one97.paytm.recharge.ordersummary.h.d     // Catch:{ Exception -> 0x1434 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r19 = "gas_pipeline"
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.util.ArrayList r3 = r3.getOrderedCartList()     // Catch:{ Exception -> 0x1434 }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3     // Catch:{ Exception -> 0x1434 }
            java.lang.Object r20 = r11.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r21 = ""
            java.lang.String r22 = ""
            java.lang.String r23 = "cylinder_booking"
            java.lang.String r24 = ""
            java.lang.String r25 = ""
            r18 = r1
            r18.a(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0b48
        L_0x09ed:
            java.lang.String r4 = "cylinder booking"
            boolean r4 = r4.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x1434 }
            if (r4 == 0) goto L_0x0a1e
            net.one97.paytm.recharge.ordersummary.h.d r1 = new net.one97.paytm.recharge.ordersummary.h.d     // Catch:{ Exception -> 0x1434 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r19 = "book_cylinder"
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.util.ArrayList r3 = r3.getOrderedCartList()     // Catch:{ Exception -> 0x1434 }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r3 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3     // Catch:{ Exception -> 0x1434 }
            java.lang.Object r20 = r11.b((net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r21 = ""
            java.lang.String r22 = ""
            java.lang.String r23 = "cylinder_booking"
            java.lang.String r24 = ""
            java.lang.String r25 = ""
            r18 = r1
            r18.a(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0b48
        L_0x0a1e:
            java.lang.String r4 = "Metro"
            boolean r4 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 != 0) goto L_0x0b14
            java.lang.String r4 = "Landline"
            boolean r4 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 != 0) goto L_0x0b14
            java.lang.String r4 = "Electricity"
            boolean r4 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 != 0) goto L_0x0b14
            java.lang.String r4 = "Insurance"
            boolean r4 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 != 0) goto L_0x0b14
            java.lang.String r4 = "Water"
            boolean r4 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 == 0) goto L_0x0a48
            goto L_0x0b14
        L_0x0a48:
            r4 = 0
            java.lang.Object r8 = r1.get(r4)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r8 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r8     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r8.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = "Education"
            boolean r4 = r4.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x1434 }
            if (r4 == 0) goto L_0x0ac4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x1434 }
            r5 = 0
            java.lang.Object r6 = r1.get(r5)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r6 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r6     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = r6.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ Exception -> 0x1434 }
            r4.append(r5)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x1434 }
            int r5 = r1.size()     // Catch:{ Exception -> 0x1434 }
            r6 = 1
            if (r5 <= r6) goto L_0x0b48
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r5.<init>()     // Catch:{ Exception -> 0x1434 }
            r5.append(r4)     // Catch:{ Exception -> 0x1434 }
            r5.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r6 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.getStatus()     // Catch:{ Exception -> 0x1434 }
            r7.put(r5, r6)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = "utilities_education_business_sub_vertical"
            r6 = 1
            java.lang.Object r1 = r1.get(r6)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRCategoryMap r1 = (net.one97.paytm.common.entity.shopping.CJRCategoryMap) r1     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = p((java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            r7.put(r5, r1)     // Catch:{ Exception -> 0x1434 }
            r7.put(r3, r2)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r1.<init>()     // Catch:{ Exception -> 0x1434 }
            r1.append(r4)     // Catch:{ Exception -> 0x1434 }
            r1.append(r12)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.b((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r7, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.D()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0b48
        L_0x0ac4:
            java.lang.String r4 = "Education"
            boolean r4 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 == 0) goto L_0x0b48
            java.lang.String r4 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r5.concat(r4)     // Catch:{ Exception -> 0x1434 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x1434 }
            r5 = 1
            if (r1 <= r5) goto L_0x0b48
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r1.<init>()     // Catch:{ Exception -> 0x1434 }
            r1.append(r4)     // Catch:{ Exception -> 0x1434 }
            r1.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = r5.getStatus()     // Catch:{ Exception -> 0x1434 }
            r7.put(r1, r5)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = "utilities_education_business_sub_vertical"
            java.lang.String r5 = "fee_payment"
            r7.put(r1, r5)     // Catch:{ Exception -> 0x1434 }
            r7.put(r3, r2)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r1.<init>()     // Catch:{ Exception -> 0x1434 }
            r1.append(r4)     // Catch:{ Exception -> 0x1434 }
            r1.append(r12)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.b((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r7, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.D()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0b48
        L_0x0b14:
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r5.concat(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r3.<init>()     // Catch:{ Exception -> 0x1434 }
            r3.append(r1)     // Catch:{ Exception -> 0x1434 }
            r3.append(r12)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r4.<init>()     // Catch:{ Exception -> 0x1434 }
            r4.append(r1)     // Catch:{ Exception -> 0x1434 }
            r4.append(r9)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r4.getStatus()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.a.a((java.lang.String) r3, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r4, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            r27.D()     // Catch:{ Exception -> 0x1434 }
            goto L_0x0b48
        L_0x0b47:
            r10 = 2
        L_0x0b48:
            r1 = 2131368428(0x7f0a19ec, float:1.8356806E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.getPaymentText()     // Catch:{ Exception -> 0x1434 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x1434 }
            if (r4 != 0) goto L_0x0b9d
            r1.setText(r3)     // Catch:{ Exception -> 0x1434 }
            r4 = 0
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = "care@paytm.com"
            int r3 = r3.indexOf(r4)     // Catch:{ Exception -> 0x1434 }
            if (r3 < 0) goto L_0x0ba2
            android.text.method.MovementMethod r5 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ Exception -> 0x0ba2 }
            r1.setMovementMethod(r5)     // Catch:{ Exception -> 0x0ba2 }
            java.lang.CharSequence r1 = r1.getText()     // Catch:{ Exception -> 0x0ba2 }
            android.text.Spannable r1 = (android.text.Spannable) r1     // Catch:{ Exception -> 0x0ba2 }
            net.one97.paytm.AJROrderSummaryActivityBase$ExpandedURLSpanNoUnderline r5 = new net.one97.paytm.AJROrderSummaryActivityBase$ExpandedURLSpanNoUnderline     // Catch:{ Exception -> 0x0ba2 }
            r6 = 0
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x0ba2 }
            r4 = 14
            int r4 = r4 + r3
            r6 = 33
            r1.setSpan(r5, r3, r4, r6)     // Catch:{ Exception -> 0x0ba2 }
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x0ba2 }
            android.content.res.Resources r6 = r27.getResources()     // Catch:{ Exception -> 0x0ba2 }
            r7 = 2131100893(0x7f0604dd, float:1.781418E38)
            int r6 = r6.getColor(r7)     // Catch:{ Exception -> 0x0ba2 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0ba2 }
            r6 = 33
            r1.setSpan(r5, r3, r4, r6)     // Catch:{ Exception -> 0x0ba2 }
            goto L_0x0ba2
        L_0x0b9d:
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x1434 }
        L_0x0ba2:
            r1 = 2131368427(0x7f0a19eb, float:1.8356804E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.getPaymentStatus()     // Catch:{ Exception -> 0x1434 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x1434 }
            if (r3 != 0) goto L_0x0d07
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.getPaymentSummary()     // Catch:{ Exception -> 0x1434 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x1434 }
            if (r3 != 0) goto L_0x0d07
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.getPaymentSummary()     // Catch:{ Exception -> 0x1434 }
            r1.setText(r3)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r11.L     // Catch:{ Exception -> 0x1434 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x0bec
            java.lang.String r1 = r11.L     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r1.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0bec
            boolean r1 = r27.Q()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0bec
            boolean r1 = r11.X     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x0bec
            r1 = 1
            r11.X = r1     // Catch:{ Exception -> 0x1434 }
            r27.G()     // Catch:{ Exception -> 0x1434 }
        L_0x0bec:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J     // Catch:{ Exception -> 0x1434 }
            boolean r1 = b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0d07
            java.lang.String r1 = r11.L     // Catch:{ Exception -> 0x1434 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x0d07
            java.lang.String r1 = r11.L     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r1.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0d07
            boolean r1 = r11.W     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x0d07
            boolean r1 = r27.P()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0c2a
            java.lang.String r1 = "bus_payment_success"
            net.one97.paytm.j.a.a((java.lang.String) r1, (java.lang.String) r2, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r27.V()     // Catch:{ Exception -> 0x1434 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            if (r3 != 0) goto L_0x0c2a
            java.lang.String r3 = "SUCCESS"
            boolean r1 = r1.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0c2a
            java.lang.String r1 = "bus_booking_success"
            net.one97.paytm.j.a.a((java.lang.String) r1, (java.lang.String) r2, (android.content.Context) r11)     // Catch:{ Exception -> 0x1434 }
        L_0x0c2a:
            boolean r1 = r27.Q()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x0c33
            r27.H()     // Catch:{ Exception -> 0x1434 }
        L_0x0c33:
            r1 = 1
            r11.W = r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x0cfa }
            java.lang.String r1 = net.one97.paytm.j.c.v()     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r11.J     // Catch:{ Exception -> 0x0cfa }
            java.util.ArrayList r2 = r2.getOrderedCartList()     // Catch:{ Exception -> 0x0cfa }
            r3 = 0
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r2 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r2     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r2 = r2.getProductDetail()     // Catch:{ Exception -> 0x0cfa }
            long r25 = r2.getCategoryId()     // Catch:{ Exception -> 0x0cfa }
            boolean r2 = r11.bs     // Catch:{ Exception -> 0x0cfa }
            if (r2 != 0) goto L_0x0cd9
            java.lang.String r2 = r11.br     // Catch:{ Exception -> 0x0cfa }
            boolean r2 = net.one97.paytm.utils.l.b((java.lang.String) r2)     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.j.a.a((android.content.Context) r11, (net.one97.paytm.common.entity.shopping.CJROrderSummary) r3)     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r3 = r11.ay     // Catch:{ Exception -> 0x0cfa }
            if (r3 != 0) goto L_0x0c93
            net.one97.paytm.common.entity.CJRRechargeCart r3 = r11.az     // Catch:{ Exception -> 0x0cfa }
            if (r3 == 0) goto L_0x0c93
            net.one97.paytm.common.entity.CJRRechargeCart r3 = r11.az     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r3.getCart()     // Catch:{ Exception -> 0x0cfa }
            if (r3 == 0) goto L_0x0c93
            net.one97.paytm.common.entity.CJRRechargeCart r3 = r11.az     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJRCart r3 = r3.getCart()     // Catch:{ Exception -> 0x0cfa }
            java.util.ArrayList r3 = r3.getCartItems()     // Catch:{ Exception -> 0x0cfa }
            if (r3 == 0) goto L_0x0c93
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r3 = new net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo     // Catch:{ Exception -> 0x0cfa }
            r3.<init>()     // Catch:{ Exception -> 0x0cfa }
            r11.ay = r3     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r3 = r11.ay     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.CJRRechargeCart r4 = r11.az     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJRCart r4 = r4.getCart()     // Catch:{ Exception -> 0x0cfa }
            java.util.ArrayList r4 = r4.getCartItems()     // Catch:{ Exception -> 0x0cfa }
            r3.setCartItemsForTrackingInfo(r4)     // Catch:{ Exception -> 0x0cfa }
        L_0x0c93:
            android.content.Context r18 = r27.getApplicationContext()     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo r4 = r11.ay     // Catch:{ Exception -> 0x0cfa }
            java.lang.String r5 = r11.ao     // Catch:{ Exception -> 0x0cfa }
            java.lang.String r6 = r11.br     // Catch:{ Exception -> 0x0cfa }
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r2
            r23 = r6
            r24 = r1
            net.one97.paytm.j.a.a((android.content.Context) r18, (net.one97.paytm.common.entity.shopping.CJROrderSummary) r19, (net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo) r20, (java.lang.String) r21, (boolean) r22, (java.lang.String) r23, (java.lang.String) r24, (long) r25)     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x0cfa }
            java.util.ArrayList r3 = r3.getOrderedCartList()     // Catch:{ Exception -> 0x0cfa }
            if (r3 == 0) goto L_0x0cbf
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x0cfa }
            java.util.ArrayList r3 = r3.getOrderedCartList()     // Catch:{ Exception -> 0x0cfa }
            r11.a((java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJROrderedCart>) r3)     // Catch:{ Exception -> 0x0cfa }
        L_0x0cbf:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x0cfa }
            java.lang.String r4 = r11.br     // Catch:{ Exception -> 0x0cfa }
            net.one97.paytm.j.a.a((android.content.Context) r11, (boolean) r2, (net.one97.paytm.common.entity.shopping.CJROrderSummary) r3, (java.lang.String) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x0cfa }
            java.lang.String r1 = r11.br     // Catch:{ Exception -> 0x0cfa }
            if (r1 == 0) goto L_0x0cd9
            java.lang.String r1 = r11.br     // Catch:{ Exception -> 0x0cfa }
            java.lang.String r2 = "Paytm Hotel"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0cfa }
            if (r1 == 0) goto L_0x0cd9
            java.lang.String r1 = "order_summary_success"
            r11.k((java.lang.String) r1)     // Catch:{ Exception -> 0x0cfa }
        L_0x0cd9:
            r27.J()     // Catch:{ Exception -> 0x0cdd }
            goto L_0x0ce6
        L_0x0cdd:
            r0 = move-exception
            r1 = r0
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x0cfa }
            com.paytm.utility.q.b(r1)     // Catch:{ Exception -> 0x0cfa }
        L_0x0ce6:
            java.lang.String r1 = "af_purchase"
            r11.j((java.lang.String) r1)     // Catch:{ Exception -> 0x0cec }
            goto L_0x0d07
        L_0x0cec:
            r0 = move-exception
            r1 = r0
            boolean r2 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x0cfa }
            if (r2 == 0) goto L_0x0d07
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x0cfa }
            com.paytm.utility.q.b(r1)     // Catch:{ Exception -> 0x0cfa }
            goto L_0x0d07
        L_0x0cfa:
            r0 = move-exception
            r1 = r0
            boolean r2 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x1434 }
            if (r2 == 0) goto L_0x0d07
            java.lang.String r1 = r1.getMessage()     // Catch:{ Exception -> 0x1434 }
            com.paytm.utility.q.b(r1)     // Catch:{ Exception -> 0x1434 }
        L_0x0d07:
            java.lang.String r1 = " "
            r2 = 2131962658(0x7f132b22, float:1.9562047E38)
            if (r15 == 0) goto L_0x1036
            boolean r3 = r27.R()     // Catch:{ Exception -> 0x1434 }
            if (r3 != 0) goto L_0x1036
            int r3 = r15.size()     // Catch:{ Exception -> 0x1434 }
            r4 = 0
            r6 = 1
            if (r3 > r6) goto L_0x0d2f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            boolean r3 = r3.getNeedShipping()     // Catch:{ Exception -> 0x1434 }
            if (r3 != 0) goto L_0x0d2f
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r6 = r3.getDiscountAmount()     // Catch:{ Exception -> 0x1434 }
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x1036
        L_0x0d2f:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.getAggregateItemPrice()     // Catch:{ Exception -> 0x1434 }
            if (r3 == 0) goto L_0x0d7a
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.getAggregateItemPrice()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = "0"
            boolean r3 = r3.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x1434 }
            if (r3 != 0) goto L_0x0d7a
            r3 = 2131372904(0x7f0a2b68, float:1.8365884E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r6.<init>()     // Catch:{ Exception -> 0x1434 }
            android.content.res.Resources r7 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ Exception -> 0x1434 }
            r6.append(r7)     // Catch:{ Exception -> 0x1434 }
            r6.append(r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.getAggregateItemPrice()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = com.paytm.utility.b.x((java.lang.String) r7)     // Catch:{ Exception -> 0x1434 }
            r6.append(r7)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x1434 }
            r3.setText(r6)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0d86
        L_0x0d7a:
            r3 = 2131367137(0x7f0a14e1, float:1.8354187E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r6 = 8
            r3.setVisibility(r6)     // Catch:{ Exception -> 0x1434 }
        L_0x0d86:
            r3 = 2131372972(0x7f0a2bac, float:1.8366022E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x1434 }
            r6 = 2131372773(0x7f0a2ae5, float:1.8365618E38)
            android.view.View r6 = r11.findViewById(r6)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            boolean r7 = r7.getNeedShipping()     // Catch:{ Exception -> 0x1434 }
            if (r7 == 0) goto L_0x0eb7
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.util.ArrayList r7 = r7.getOrderedCartList()     // Catch:{ Exception -> 0x1434 }
            if (r7 == 0) goto L_0x0e72
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.util.ArrayList r7 = r7.getOrderedCartList()     // Catch:{ Exception -> 0x1434 }
            int r7 = r7.size()     // Catch:{ Exception -> 0x1434 }
            r8 = 1
            if (r7 != r8) goto L_0x0e72
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            if (r7 == 0) goto L_0x0e00
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.util.ArrayList r7 = r7.getOrderedCartList()     // Catch:{ Exception -> 0x1434 }
            if (r7 == 0) goto L_0x0e00
            int r8 = r7.size()     // Catch:{ Exception -> 0x1434 }
            if (r8 <= 0) goto L_0x0e00
            r8 = 0
            java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r7 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r7     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r7 = r7.getProductDetail()     // Catch:{ Exception -> 0x1434 }
            if (r7 == 0) goto L_0x0e00
            java.lang.String r8 = r7.getProductType()     // Catch:{ Exception -> 0x1434 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 != 0) goto L_0x0e00
            java.lang.String r8 = r7.getVertical()     // Catch:{ Exception -> 0x1434 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x1434 }
            if (r8 != 0) goto L_0x0e00
            java.lang.String r8 = r7.getProductType()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r9 = "Marketplace"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x1434 }
            if (r8 == 0) goto L_0x0e00
            long r7 = r7.getVerticalId()     // Catch:{ Exception -> 0x1434 }
            r12 = 49
            int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r9 != 0) goto L_0x0e00
            r7 = 1
            goto L_0x0e01
        L_0x0e00:
            r7 = 0
        L_0x0e01:
            if (r7 == 0) goto L_0x0e72
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r7 = r7.getShippingAmount()     // Catch:{ Exception -> 0x1434 }
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x0e31
            r7 = 2131372973(0x7f0a2bad, float:1.8366024E38)
            android.view.View r7 = r11.findViewById(r7)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ Exception -> 0x1434 }
            android.content.res.Resources r8 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            r9 = 2131953859(0x7f1308c3, float:1.95442E38)
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x1434 }
            r7.setText(r8)     // Catch:{ Exception -> 0x1434 }
            r7 = 2131367038(0x7f0a147e, float:1.8353986E38)
            android.view.View r7 = r11.findViewById(r7)     // Catch:{ Exception -> 0x1434 }
            r8 = 8
            r7.setVisibility(r8)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0e72
        L_0x0e31:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r7 = r7.getConvFee()     // Catch:{ Exception -> 0x1434 }
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x0e72
            r7 = 2131367218(0x7f0a1532, float:1.8354352E38)
            android.view.View r7 = r11.findViewById(r7)     // Catch:{ Exception -> 0x1434 }
            r8 = 8
            r7.setVisibility(r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r7.<init>()     // Catch:{ Exception -> 0x1434 }
            android.content.res.Resources r8 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = r8.getString(r2)     // Catch:{ Exception -> 0x1434 }
            r7.append(r8)     // Catch:{ Exception -> 0x1434 }
            r7.append(r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r8 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r8 = r8.getConvFee()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = com.paytm.utility.b.x((java.lang.String) r8)     // Catch:{ Exception -> 0x1434 }
            r7.append(r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x1434 }
            r6.setText(r7)     // Catch:{ Exception -> 0x1434 }
        L_0x0e72:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r7 = r7.getShippingAmount()     // Catch:{ Exception -> 0x1434 }
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x0ea8
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r7.<init>()     // Catch:{ Exception -> 0x1434 }
            android.content.res.Resources r8 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = r8.getString(r2)     // Catch:{ Exception -> 0x1434 }
            r7.append(r8)     // Catch:{ Exception -> 0x1434 }
            r7.append(r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r8 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r8 = r8.getShippingAmount()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r8 = com.paytm.utility.b.x((java.lang.String) r8)     // Catch:{ Exception -> 0x1434 }
            r7.append(r8)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x1434 }
            r3.setText(r7)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0ec3
        L_0x0ea8:
            android.content.res.Resources r7 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            r8 = 2131960068(0x7f132104, float:1.9556794E38)
            java.lang.String r7 = r7.getString(r8)     // Catch:{ Exception -> 0x1434 }
            r3.setText(r7)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0ec3
        L_0x0eb7:
            r3 = 2131367218(0x7f0a1532, float:1.8354352E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r7 = 8
            r3.setVisibility(r7)     // Catch:{ Exception -> 0x1434 }
        L_0x0ec3:
            boolean r3 = r27.P()     // Catch:{ Exception -> 0x1434 }
            if (r3 == 0) goto L_0x0f0c
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r7 = r3.getmConFee()     // Catch:{ Exception -> 0x1434 }
            int r3 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0eff
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r3.<init>()     // Catch:{ Exception -> 0x1434 }
            android.content.res.Resources r7 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ Exception -> 0x1434 }
            r3.append(r7)     // Catch:{ Exception -> 0x1434 }
            r3.append(r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r7 = r7.getmConFee()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = com.paytm.utility.b.x((java.lang.String) r7)     // Catch:{ Exception -> 0x1434 }
            r3.append(r7)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x1434 }
            r6.setText(r3)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0f4e
        L_0x0eff:
            r3 = 2131367038(0x7f0a147e, float:1.8353986E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r6 = 8
            r3.setVisibility(r6)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0f4e
        L_0x0f0c:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r7 = r3.getConvFee()     // Catch:{ Exception -> 0x1434 }
            int r3 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0f42
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r3.<init>()     // Catch:{ Exception -> 0x1434 }
            android.content.res.Resources r7 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = r7.getString(r2)     // Catch:{ Exception -> 0x1434 }
            r3.append(r7)     // Catch:{ Exception -> 0x1434 }
            r3.append(r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r7 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r7 = r7.getConvFee()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r7 = com.paytm.utility.b.x((java.lang.String) r7)     // Catch:{ Exception -> 0x1434 }
            r3.append(r7)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x1434 }
            r6.setText(r3)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0f4e
        L_0x0f42:
            r3 = 2131367038(0x7f0a147e, float:1.8353986E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r6 = 8
            r3.setVisibility(r6)     // Catch:{ Exception -> 0x1434 }
        L_0x0f4e:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r6 = r3.getDiscountAmount()     // Catch:{ Exception -> 0x1434 }
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0f8f
            r3 = 2131372792(0x7f0a2af8, float:1.8365657E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = "- "
            r4.<init>(r5)     // Catch:{ Exception -> 0x1434 }
            android.content.res.Resources r5 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = r5.getString(r2)     // Catch:{ Exception -> 0x1434 }
            r4.append(r5)     // Catch:{ Exception -> 0x1434 }
            r4.append(r1)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r11.J     // Catch:{ Exception -> 0x1434 }
            double r5 = r5.getDiscountAmount()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = com.paytm.utility.b.x((java.lang.String) r5)     // Catch:{ Exception -> 0x1434 }
            r4.append(r5)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x1434 }
            r3.setText(r4)     // Catch:{ Exception -> 0x1434 }
            goto L_0x0f9b
        L_0x0f8f:
            r3 = 2131367049(0x7f0a1489, float:1.8354009E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r4 = 8
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
        L_0x0f9b:
            r27.M()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.getPromoDescription()     // Catch:{ Exception -> 0x1434 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x1434 }
            if (r3 != 0) goto L_0x0fe1
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.getPromoDescription()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x1434 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x1434 }
            if (r3 != 0) goto L_0x0fe1
            r3 = 2131372812(0x7f0a2b0c, float:1.8365698E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x1434 }
            int r4 = com.paytm.utility.a.u(r27)     // Catch:{ Exception -> 0x1434 }
            r5 = 0
            r3.setPadding(r4, r5, r4, r4)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.J     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r4.getPromoDescription()     // Catch:{ Exception -> 0x1434 }
            r3.setText(r4)     // Catch:{ Exception -> 0x1434 }
            r3 = 2131367064(0x7f0a1498, float:1.835404E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x1434 }
            r4 = 8
            goto L_0x0fed
        L_0x0fe1:
            r3 = 2131367064(0x7f0a1498, float:1.835404E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r4 = 8
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
        L_0x0fed:
            r3 = 2131367137(0x7f0a14e1, float:1.8354187E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            int r3 = r3.getVisibility()     // Catch:{ Exception -> 0x1434 }
            if (r3 != r4) goto L_0x101e
            r3 = 2131367218(0x7f0a1532, float:1.8354352E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            int r3 = r3.getVisibility()     // Catch:{ Exception -> 0x1434 }
            if (r3 != r4) goto L_0x101e
            r3 = 2131367049(0x7f0a1489, float:1.8354009E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            int r3 = r3.getVisibility()     // Catch:{ Exception -> 0x1434 }
            if (r3 != r4) goto L_0x101e
            r3 = 2131370028(0x7f0a202c, float:1.836005E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
        L_0x101e:
            r3 = 2131370020(0x7f0a2024, float:1.8360035E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r4 = 8
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
            r3 = 2131372905(0x7f0a2b69, float:1.8365886E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r4 = 0
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
            goto L_0x1057
        L_0x1036:
            r3 = 2131367227(0x7f0a153b, float:1.835437E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r4 = 8
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
            r3 = 2131370020(0x7f0a2024, float:1.8360035E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r5 = 0
            r3.setVisibility(r5)     // Catch:{ Exception -> 0x1434 }
            r3 = 2131372905(0x7f0a2b69, float:1.8365886E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
        L_0x1057:
            if (r15 == 0) goto L_0x1062
            int r3 = r15.size()     // Catch:{ Exception -> 0x1434 }
            if (r3 >= r10) goto L_0x1062
            r3 = 1
            r11.au = r3     // Catch:{ Exception -> 0x1434 }
        L_0x1062:
            r3 = 2131373010(0x7f0a2bd2, float:1.83661E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1153 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x1153 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1153 }
            r4.<init>()     // Catch:{ Exception -> 0x1153 }
            android.content.res.Resources r5 = r27.getResources()     // Catch:{ Exception -> 0x1153 }
            java.lang.String r5 = r5.getString(r2)     // Catch:{ Exception -> 0x1153 }
            r4.append(r5)     // Catch:{ Exception -> 0x1153 }
            r4.append(r1)     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r5 = r11.J     // Catch:{ Exception -> 0x1153 }
            double r5 = r5.getGrandTotal()     // Catch:{ Exception -> 0x1153 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x1153 }
            java.lang.String r5 = com.paytm.utility.b.x((java.lang.String) r5)     // Catch:{ Exception -> 0x1153 }
            r4.append(r5)     // Catch:{ Exception -> 0x1153 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x1153 }
            r3.setText(r4)     // Catch:{ Exception -> 0x1153 }
            r3 = 2131373009(0x7f0a2bd1, float:1.8366097E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1153 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.J     // Catch:{ Exception -> 0x1153 }
            java.util.ArrayList r4 = r4.getOrderedCartList()     // Catch:{ Exception -> 0x1153 }
            if (r4 == 0) goto L_0x10e6
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.J     // Catch:{ Exception -> 0x1153 }
            java.util.ArrayList r4 = r4.getOrderedCartList()     // Catch:{ Exception -> 0x1153 }
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription r4 = r4.getSubscription()     // Catch:{ Exception -> 0x1153 }
            if (r4 == 0) goto L_0x10e6
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.J     // Catch:{ Exception -> 0x1153 }
            java.util.ArrayList r4 = r4.getOrderedCartList()     // Catch:{ Exception -> 0x1153 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription r4 = r4.getSubscription()     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummarySubscriptionInfo r4 = r4.getSubscriptionInfo()     // Catch:{ Exception -> 0x1153 }
            if (r4 == 0) goto L_0x10e6
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r11.J     // Catch:{ Exception -> 0x1153 }
            java.util.ArrayList r4 = r4.getOrderedCartList()     // Catch:{ Exception -> 0x1153 }
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r4 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r4     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription r4 = r4.getSubscription()     // Catch:{ Exception -> 0x1153 }
            boolean r13 = r4.getIsSubscribed()     // Catch:{ Exception -> 0x1153 }
            goto L_0x10e7
        L_0x10e6:
            r13 = 0
        L_0x10e7:
            if (r13 == 0) goto L_0x1128
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1153 }
            r4.<init>()     // Catch:{ Exception -> 0x1153 }
            android.content.res.Resources r5 = r27.getResources()     // Catch:{ Exception -> 0x1153 }
            java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x1153 }
            r4.append(r2)     // Catch:{ Exception -> 0x1153 }
            r4.append(r1)     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J     // Catch:{ Exception -> 0x1153 }
            java.util.ArrayList r1 = r1.getOrderedCartList()     // Catch:{ Exception -> 0x1153 }
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription r1 = r1.getSubscription()     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummarySubscriptionInfo r1 = r1.getSubscriptionInfo()     // Catch:{ Exception -> 0x1153 }
            long r1 = r1.getSubscriptionAmount()     // Catch:{ Exception -> 0x1153 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x1153 }
            java.lang.String r1 = com.paytm.utility.b.x((java.lang.String) r1)     // Catch:{ Exception -> 0x1153 }
            r4.append(r1)     // Catch:{ Exception -> 0x1153 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x1153 }
            r3.setText(r1)     // Catch:{ Exception -> 0x1153 }
            goto L_0x1153
        L_0x1128:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1153 }
            r4.<init>()     // Catch:{ Exception -> 0x1153 }
            android.content.res.Resources r5 = r27.getResources()     // Catch:{ Exception -> 0x1153 }
            java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x1153 }
            r4.append(r2)     // Catch:{ Exception -> 0x1153 }
            r4.append(r1)     // Catch:{ Exception -> 0x1153 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J     // Catch:{ Exception -> 0x1153 }
            double r1 = r1.getGrandTotal()     // Catch:{ Exception -> 0x1153 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x1153 }
            java.lang.String r1 = com.paytm.utility.b.x((java.lang.String) r1)     // Catch:{ Exception -> 0x1153 }
            r4.append(r1)     // Catch:{ Exception -> 0x1153 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x1153 }
            r3.setText(r1)     // Catch:{ Exception -> 0x1153 }
        L_0x1153:
            java.lang.String r1 = r11.L     // Catch:{ Exception -> 0x1434 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x11d9
            java.lang.String r1 = r11.L     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r1.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x11d9
            boolean r1 = r27.ac()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x1177
            r1 = 2131366995(0x7f0a1453, float:1.83539E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            goto L_0x124e
        L_0x1177:
            r2 = 8
            r1 = 2131366996(0x7f0a1454, float:1.8353901E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRAddress r1 = r1.getShippingAddress()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r11.J     // Catch:{ Exception -> 0x1434 }
            boolean r2 = r2.getNeedShipping()     // Catch:{ Exception -> 0x1434 }
            if (r2 == 0) goto L_0x11cc
            if (r1 == 0) goto L_0x11cc
            r2 = 2131372719(0x7f0a2aaf, float:1.8365509E38)
            android.view.View r2 = r11.findViewById(r2)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x1434 }
            r3 = 2131366995(0x7f0a1453, float:1.83539E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r4 = 0
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
            r3 = 2131370019(0x7f0a2023, float:1.8360033E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
            r11.a((android.widget.TextView) r2, (net.one97.paytm.common.entity.shopping.CJRAddress) r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.CharSequence r1 = r2.getText()     // Catch:{ Exception -> 0x1434 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x124e
            r1 = 2131366995(0x7f0a1453, float:1.83539E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            goto L_0x124e
        L_0x11cc:
            r1 = 2131366995(0x7f0a1453, float:1.83539E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            goto L_0x124e
        L_0x11d9:
            r1 = 2131366995(0x7f0a1453, float:1.83539E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJRAddress r1 = r1.getShippingAddress()     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r2 = r11.J     // Catch:{ Exception -> 0x1434 }
            boolean r2 = r2.getNeedShipping()     // Catch:{ Exception -> 0x1434 }
            if (r2 == 0) goto L_0x1238
            if (r1 == 0) goto L_0x1238
            r2 = 2131372720(0x7f0a2ab0, float:1.836551E38)
            android.view.View r2 = r11.findViewById(r2)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x1434 }
            r3 = 2131366996(0x7f0a1454, float:1.8353901E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r4 = 0
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
            r3 = 2131370032(0x7f0a2030, float:1.836006E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
            r11.a((android.widget.TextView) r2, (net.one97.paytm.common.entity.shopping.CJRAddress) r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.CharSequence r1 = r2.getText()     // Catch:{ Exception -> 0x1434 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x124e
            r1 = 2131366996(0x7f0a1454, float:1.8353901E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            r1 = 2131370019(0x7f0a2023, float:1.8360033E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r2 = 0
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            goto L_0x124e
        L_0x1238:
            r1 = 2131366996(0x7f0a1454, float:1.8353901E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            r1 = 2131370019(0x7f0a2023, float:1.8360033E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
        L_0x124e:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r11.J     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryRefundToBank r1 = r1.getRefund()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x1362
            r2 = 2131367188(0x7f0a1514, float:1.835429E38)
            android.view.View r2 = r11.findViewById(r2)     // Catch:{ Exception -> 0x1434 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x1434 }
            r2 = 2131370035(0x7f0a2033, float:1.8360065E38)
            android.view.View r2 = r11.findViewById(r2)     // Catch:{ Exception -> 0x1434 }
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x1434 }
            r2 = 2131369205(0x7f0a1cf5, float:1.8358382E38)
            android.view.View r2 = r11.findViewById(r2)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x1434 }
            r3 = 2131369208(0x7f0a1cf8, float:1.8358388E38)
            android.view.View r3 = r11.findViewById(r3)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r1.getTitle()     // Catch:{ Exception -> 0x1434 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 != 0) goto L_0x1329
            java.lang.String r4 = r1.getMessage()     // Catch:{ Exception -> 0x1434 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 != 0) goto L_0x1329
            java.lang.String r4 = r1.getTitle()     // Catch:{ Exception -> 0x1434 }
            r2.setText(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r2.<init>()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r1.getMessage()     // Catch:{ Exception -> 0x1434 }
            r2.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = ". "
            r2.append(r4)     // Catch:{ Exception -> 0x1434 }
            android.content.res.Resources r4 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            r5 = 2131960097(0x7f132121, float:1.9556853E38)
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x1434 }
            r2.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = "?"
            r2.append(r4)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x1434 }
            r3.setText(r2)     // Catch:{ Exception -> 0x1434 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x1434 }
            r4.<init>()     // Catch:{ Exception -> 0x1434 }
            android.content.res.Resources r5 = r27.getResources()     // Catch:{ Exception -> 0x1434 }
            r6 = 2131960097(0x7f132121, float:1.9556853E38)
            java.lang.String r5 = r5.getString(r6)     // Catch:{ Exception -> 0x1434 }
            r4.append(r5)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r5 = "?"
            r4.append(r5)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x1434 }
            int r2 = r2.indexOf(r4)     // Catch:{ Exception -> 0x1434 }
            android.text.method.MovementMethod r5 = android.text.method.LinkMovementMethod.getInstance()     // Catch:{ Exception -> 0x131b }
            r3.setMovementMethod(r5)     // Catch:{ Exception -> 0x131b }
            java.lang.CharSequence r3 = r3.getText()     // Catch:{ Exception -> 0x131b }
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch:{ Exception -> 0x131b }
            net.one97.paytm.AJROrderSummaryActivityBase$ExpandedURLSpanNoUnderline r5 = new net.one97.paytm.AJROrderSummaryActivityBase$ExpandedURLSpanNoUnderline     // Catch:{ Exception -> 0x131b }
            r6 = 0
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x131b }
            int r6 = r4.length()     // Catch:{ Exception -> 0x131b }
            int r6 = r6 + r2
            r7 = 33
            r3.setSpan(r5, r2, r6, r7)     // Catch:{ Exception -> 0x131b }
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x131b }
            android.content.res.Resources r6 = r27.getResources()     // Catch:{ Exception -> 0x131b }
            r7 = 2131100893(0x7f0604dd, float:1.781418E38)
            int r6 = r6.getColor(r7)     // Catch:{ Exception -> 0x131b }
            r5.<init>(r6)     // Catch:{ Exception -> 0x131b }
            int r4 = r4.length()     // Catch:{ Exception -> 0x131b }
            int r4 = r4 + r2
            r6 = 33
            r3.setSpan(r5, r2, r4, r6)     // Catch:{ Exception -> 0x131b }
            goto L_0x1331
        L_0x131b:
            r0 = move-exception
            r2 = r0
            boolean r3 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x1434 }
            if (r3 == 0) goto L_0x1331
            java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x1434 }
            com.paytm.utility.q.b(r2)     // Catch:{ Exception -> 0x1434 }
            goto L_0x1331
        L_0x1329:
            r4 = 8
            r2.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
            r3.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
        L_0x1331:
            r2 = 2131373617(0x7f0a2e31, float:1.836733E38)
            android.view.View r2 = r11.findViewById(r2)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.-$$Lambda$AJROrderSummaryActivityBase$IBoc03WWkxqMBju2xYAVY3x1mlU r3 = new net.one97.paytm.-$$Lambda$AJROrderSummaryActivityBase$IBoc03WWkxqMBju2xYAVY3x1mlU     // Catch:{ Exception -> 0x1434 }
            r3.<init>()     // Catch:{ Exception -> 0x1434 }
            r2.setOnClickListener(r3)     // Catch:{ Exception -> 0x1434 }
            boolean r2 = r1.getBankRefundButtons()     // Catch:{ Exception -> 0x1434 }
            if (r2 == 0) goto L_0x135a
            java.lang.String r2 = r1.getWalletGuid()     // Catch:{ Exception -> 0x1434 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x1434 }
            if (r2 != 0) goto L_0x1378
            java.lang.String r1 = r1.getWalletGuid()     // Catch:{ Exception -> 0x1434 }
            r11.i((java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            goto L_0x1378
        L_0x135a:
            android.widget.ProgressBar r1 = r11.aq     // Catch:{ Exception -> 0x1434 }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            goto L_0x1378
        L_0x1362:
            r1 = 2131367188(0x7f0a1514, float:1.835429E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            r1 = 2131370035(0x7f0a2033, float:1.8360065E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
        L_0x1378:
            r27.L()     // Catch:{ Exception -> 0x1434 }
            r1 = 2131373682(0x7f0a2e72, float:1.8367462E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x1434 }
            r2 = 2131373681(0x7f0a2e71, float:1.836746E38)
            android.view.View r2 = r11.findViewById(r2)     // Catch:{ Exception -> 0x1434 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r3 = r11.J     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.common.entity.shopping.CJROrdersummaryFooter r3 = r3.getFooter()     // Catch:{ Exception -> 0x1434 }
            if (r3 == 0) goto L_0x13cc
            java.lang.String r4 = r3.getHeader()     // Catch:{ Exception -> 0x1434 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x1434 }
            if (r4 != 0) goto L_0x13a7
            java.lang.String r4 = r3.getHeader()     // Catch:{ Exception -> 0x1434 }
            r1.setText(r4)     // Catch:{ Exception -> 0x1434 }
            goto L_0x13ac
        L_0x13a7:
            r4 = 8
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x1434 }
        L_0x13ac:
            java.lang.String r1 = r3.getDescription()     // Catch:{ Exception -> 0x1434 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x13c6
            java.lang.String r1 = r3.getDescription()     // Catch:{ Exception -> 0x1434 }
            r2.setText(r1)     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = r3.getDescription()     // Catch:{ Exception -> 0x1434 }
            r3 = 0
            r11.a((java.lang.String) r1, (android.widget.TextView) r2, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r3)     // Catch:{ Exception -> 0x1434 }
            goto L_0x13d4
        L_0x13c6:
            r1 = 8
            r2.setVisibility(r1)     // Catch:{ Exception -> 0x1434 }
            goto L_0x13d4
        L_0x13cc:
            r3 = 8
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x1434 }
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x1434 }
        L_0x13d4:
            boolean r1 = r11.T     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x13db
            r1 = 1
            r11.Y = r1     // Catch:{ Exception -> 0x1434 }
        L_0x13db:
            r27.X()     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r11.f51400g     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x13eb
            boolean r1 = r27.P()     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x13eb
            r27.F()     // Catch:{ Exception -> 0x1434 }
        L_0x13eb:
            java.lang.String r1 = r11.L     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x1430
            java.lang.String r1 = r11.L     // Catch:{ Exception -> 0x1434 }
            boolean r1 = r1.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x1430
            boolean r1 = r11.f51401h     // Catch:{ Exception -> 0x1434 }
            if (r1 != 0) goto L_0x1430
            r1 = 1
            r11.f51401h = r1     // Catch:{ Exception -> 0x1434 }
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x1434 }
            java.lang.String r1 = "summary_page_adwork_url"
            java.lang.String r1 = net.one97.paytm.j.c.a(r1)     // Catch:{ Exception -> 0x1434 }
            if (r1 == 0) goto L_0x141a
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x1434 }
            if (r2 != 0) goto L_0x141a
            boolean r2 = android.webkit.URLUtil.isValidUrl(r1)     // Catch:{ Exception -> 0x1434 }
            if (r2 == 0) goto L_0x141a
            r11.h((java.lang.String) r1)     // Catch:{ Exception -> 0x1434 }
            goto L_0x1430
        L_0x141a:
            r1 = 2131362165(0x7f0a0175, float:1.8344103E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
            r1 = 2131370029(0x7f0a202d, float:1.8360053E38)
            android.view.View r1 = r11.findViewById(r1)     // Catch:{ Exception -> 0x1434 }
            r1.setVisibility(r2)     // Catch:{ Exception -> 0x1434 }
        L_0x1430:
            r27.E()     // Catch:{ Exception -> 0x1434 }
            return
        L_0x1434:
            r0 = move-exception
            r1 = r0
            boolean r2 = com.paytm.utility.b.v
            if (r2 == 0) goto L_0x1441
            java.lang.String r1 = r1.getMessage()
            com.paytm.utility.q.b(r1)
        L_0x1441:
            r1 = 2131369854(0x7f0a1f7e, float:1.8359698E38)
            android.view.View r1 = r11.findViewById(r1)
            r2 = 8
            r1.setVisibility(r2)
            r1 = 2131370450(0x7f0a21d2, float:1.8360907E38)
            android.view.View r1 = r11.findViewById(r1)
            r1.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.B():void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        FrameLayout frameLayout;
        this.bQ = true;
        if (bool.booleanValue()) {
            this.bP = bool.booleanValue();
            this.bC = true;
            af();
            return;
        }
        this.bP = bool.booleanValue();
        boolean z = this.bB;
        if (!z) {
            this.bD = true;
            CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel = this.bk;
            if (cJRAutomaticSubscriptionCheckModel != null) {
                a(cJRAutomaticSubscriptionCheckModel);
            }
        } else if (z && (frameLayout = this.bA) != null) {
            frameLayout.setVisibility(8);
            this.bC = false;
        }
    }

    private Object b(CJROrderedCart cJROrderedCart) {
        if (!b(this.J) || !g(cJROrderedCart)) {
            return (c(this.J) || h(cJROrderedCart)) ? "order_unsuccessful" : "order_In Process";
        }
        return "order_Successful";
    }

    private void C() {
        if (this.be == null) {
            this.be = new HashMap();
        }
        this.be.put("recharge_utilities_payment_status", this.J.getPaymentStatus());
        this.be.put("recharge_utilities_order_id", this.G);
        net.one97.paytm.j.a.b("recharge_utilities_summary_page_loaded", this.be, getApplicationContext());
    }

    private void D() {
        if (this.be == null) {
            this.be = new HashMap();
        }
        this.be.put("recharge_utilities_item_status_code", this.J.getStatus());
        this.be.put("recharge_utilities_order_id", this.G);
        net.one97.paytm.j.a.b("recharge_utilities_order_successful_displayed", this.be, getApplicationContext());
    }

    private static String a(String str, String str2) {
        return str + "_" + str2;
    }

    private void a(ArrayList<CJROrderedCart> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (!(arrayList.get(i2).getProductDetail() == null || arrayList.get(i2).getProductDetail().getGAkey() == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put("fnl_ga_key", arrayList.get(i2).getProductDetail().getGAkey());
                hashMap.put("fnl_vertical", arrayList.get(i2).getProductDetail().getVertical());
                net.one97.paytm.j.a.b("fnl_success_summary_screen_loaded", (Map<String, Object>) hashMap, (Context) this);
            }
        }
    }

    private void E() {
        int u = com.paytm.utility.a.u(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.show_order_details_lyt);
        relativeLayout.setPadding(u, u, 0, u);
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || this.J.getOrderedCartList().size() <= 1) {
            relativeLayout.setVisibility(8);
        } else {
            relativeLayout.setVisibility(0);
        }
        TextView textView = (TextView) findViewById(R.id.contact_us_txt);
        textView.setPadding(u, u, 0, u);
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("contactUsEnabled", (String) null);
        if (a2 != null && a2.equalsIgnoreCase("false")) {
            textView.setVisibility(8);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJROrderSummaryActivityBase.this.d(view);
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJROrderSummaryActivityBase.this.c(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        x();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null && this.ac != null && (orderedCartList = cJROrderSummary.getOrderedCartList()) != null && orderedCartList.size() > 0) {
            if (!this.ac.isOrderDetailsExpanded()) {
                this.ac.setIsOrderDetailsExpanded(true);
                this.aB = false;
                a(this.ac.isOrderDetailsExpanded());
            } else {
                this.ac.setIsOrderDetailsExpanded(false);
                this.aB = true;
                a(this.ac.isOrderDetailsExpanded());
                new Handler().post(new Runnable() {
                    public final void run() {
                        AJROrderSummaryActivityBase.this.aA.smoothScrollToPosition(0);
                    }
                });
            }
            c(orderedCartList);
            if (orderedCartList.get(0).getSubscription() != null && orderedCartList.get(0).getSubscription().getIsApplicable()) {
                q(orderedCartList.get(0).getRechargeNumber());
            }
        }
    }

    private void a(boolean z) {
        ImageView imageView = (ImageView) findViewById(R.id.order_details_arrow);
        CJROrderSummary cJROrderSummary = this.J;
        if (!(cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null)) {
            this.J.getOrderedCartList().size();
        }
        if (!z) {
            if (Build.VERSION.SDK_INT >= 16) {
                imageView.setBackground(getResources().getDrawable(R.drawable.toggle_blue_arrow_down));
            } else {
                imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.toggle_blue_arrow_down));
            }
        } else if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(getResources().getDrawable(R.drawable.toggle_blue_arrow_up));
        } else {
            imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.toggle_blue_arrow_up));
        }
    }

    private void h(String str) {
        try {
            findViewById(R.id.adworks_lyt).setVisibility(8);
            OrderSummaryWebView orderSummaryWebView = (OrderSummaryWebView) findViewById(R.id.adworks_webview);
            orderSummaryWebView.getLayoutParams().height = (int) (((double) com.paytm.utility.a.a((Activity) this)) / 3.5d);
            orderSummaryWebView.setWebViewClient(new a());
            orderSummaryWebView.getSettings().setJavaScriptEnabled(true);
            orderSummaryWebView.getSettings().setDomStorageEnabled(true);
            orderSummaryWebView.loadUrl(str);
        } catch (Exception unused) {
        }
    }

    private void F() {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("hotelsHome", (String) null);
        if (P()) {
            net.one97.paytm.j.c.a();
            a2 = net.one97.paytm.j.c.a("busStoreFrontUrl", (String) null);
        }
        if (URLUtil.isValidUrl(a2)) {
            String b2 = com.paytm.utility.b.b((Context) this, a2);
            if (!com.paytm.utility.a.m(this)) {
                return;
            }
            if (P()) {
                net.one97.paytm.common.b.d.a(this, b2, this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.POST, (String) null, new CJRStoreFrontBanners(), a.c.HOME, a.b.SILENT).a();
                return;
            }
            net.one97.paytm.common.b.d.a(this, b2, this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRHotelCarouselModel(), a.c.HOME, a.b.SILENT).a();
        }
    }

    private void a(final CJRLedger cJRLedger) {
        this.aq.setVisibility(8);
        if (cJRLedger.getTransactionList() != null && cJRLedger.getTransactionList().size() > 0) {
            ArrayList<CJRButton> buttonList = cJRLedger.getTransactionList().get(0).getButtonList();
            if (buttonList == null || buttonList.size() <= 0) {
                this.ap.setVisibility(8);
                return;
            }
            this.ap.setVisibility(0);
            this.ap.removeAllViews();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < buttonList.size(); i2++) {
                if (!a(buttonList.get(i2))) {
                    int size = arrayList.size();
                    arrayList.add(buttonList.get(i2).getButtonName());
                    buttonList.get(i2).setButtonTag(size);
                }
            }
            for (final int i3 = 0; i3 < arrayList.size(); i3++) {
                String str = (String) arrayList.get(i3);
                Button button = new Button(this);
                button.setText(str);
                button.setTag(str);
                button.setTextColor(getResources().getColor(R.color.paytm_blue));
                button.setTextSize(2, 13.0f);
                button.setPadding(8, 0, 8, 0);
                com.paytm.utility.b.c((TextView) button);
                LinearLayout linearLayout = new LinearLayout(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                linearLayout.setPadding(0, 0, (int) (((double) this.bG) * 0.5d), 0);
                linearLayout.addView(button, layoutParams);
                button.setBackgroundResource(R.drawable.bg_btn_transaction);
                button.getLayoutParams().height = (int) ((getResources().getDisplayMetrics().density * 35.0f) + 0.5f);
                button.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AJROrderSummaryActivityBase.a(AJROrderSummaryActivityBase.this, cJRLedger, i3);
                    }
                });
                this.ap.addView(linearLayout);
            }
        }
    }

    private static JSONObject a(CJRActionUrlRequest cJRActionUrlRequest) {
        if (cJRActionUrlRequest == null) {
            return null;
        }
        HashMap<Object, Object> request = cJRActionUrlRequest.getRequest();
        JSONObject jSONObject = new JSONObject();
        if (request != null) {
            try {
                jSONObject.put("request", new JSONObject(request));
            } catch (JSONException e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, cJRActionUrlRequest.getIpAddress());
        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, cJRActionUrlRequest.getPlatformName());
        jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, cJRActionUrlRequest.getOperationType());
        jSONObject.put("metadata", cJRActionUrlRequest.getMetadata());
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject) {
        this.bl = str;
        this.bm = jSONObject;
        this.bp = true;
        if (!TextUtils.isEmpty(ag.a(getApplicationContext()).b("sso_token=", "", true))) {
            t.a((Activity) this, (com.paytm.network.listener.b) this, a.c.RECHARGES);
            return;
        }
        m();
        a((NetworkCustomError) null);
    }

    /* access modifiers changed from: private */
    public static JSONObject b(CJRModalActionUrlRequest cJRModalActionUrlRequest) {
        if (cJRModalActionUrlRequest == null) {
            return null;
        }
        HashMap<Object, Object> request = cJRModalActionUrlRequest.getRequest();
        JSONObject jSONObject = new JSONObject();
        if (request != null) {
            try {
                jSONObject.put("request", new JSONObject(request));
            } catch (JSONException e2) {
                if (com.paytm.utility.b.v && com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, cJRModalActionUrlRequest.getIpAddress());
        jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, cJRModalActionUrlRequest.getPlatformName());
        jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, cJRModalActionUrlRequest.getOperationType());
        jSONObject.put("metadata", cJRModalActionUrlRequest.getMetadata());
        return jSONObject;
    }

    private static boolean a(CJRButton cJRButton) {
        if (cJRButton.getActionUrlRequest() != null && cJRButton.getActionUrlRequest().getOperationType() != null && cJRButton.getActionUrlRequest().getOperationType().equalsIgnoreCase("P2P_TRANSFER")) {
            return true;
        }
        if (cJRButton.getModalButtonList() == null) {
            return false;
        }
        Iterator<CJRModalButton> it2 = cJRButton.getModalButtonList().iterator();
        while (it2.hasNext()) {
            if (it2.next().getModalActionUrlRequest().getOperationType().equalsIgnoreCase("P2P_TRANSFER")) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        net.one97.paytm.payments.d.a.a((Activity) this, "paytmmp://cash_wallet?featuretype=cash_ledger");
    }

    private void i(String str) {
        this.aq.setVisibility(0);
        net.one97.paytm.j.c.a();
        String a2 = com.paytm.utility.c.a(net.one97.paytm.j.c.a("FilteredTransactionHistory", (String) null), getBaseContext());
        this.J.getNeedShipping();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        String b2 = ag.a(getApplicationContext()).b("sso_token=", "", true);
        if (!b2.equals("")) {
            hashMap.put("ssotoken", b2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.J != null && !TextUtils.isEmpty(this.J.getId())) {
                jSONObject.put(CJRQRScanResultModel.KEY_MERCHANT_ORDER_ID, this.J.getId());
            }
            jSONObject.put(SDKConstants.TXN_TYPE, "MERCHANT_TO_PAYER_COMPLEX_REFUND");
            jSONObject.put(CJRQRScanResultModel.KEY_MERCHANT_GUID, str);
        } catch (Exception unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("request", jSONObject);
            if (this.J != null && !TextUtils.isEmpty(this.J.getRemoteIP())) {
                jSONObject2.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, this.J.getRemoteIP());
            }
            jSONObject2.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
            jSONObject2.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "FILTERED_USER_TXN_HISTORY");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
        com.paytm.network.a a3 = net.one97.paytm.common.b.d.a(this, a2, this, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject2.toString(), new CJRLedger(), a.c.HOME, a.b.SILENT);
        if (com.paytm.utility.a.m(this)) {
            a3.a();
        } else {
            r.a(a3, (Context) this, (DialogInterface.OnCancelListener) this);
        }
    }

    private void G() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary");
            if (this.J != null && !TextUtils.isEmpty(this.J.getPaymentStatus())) {
                hashMap.put("movie_payment_status", this.J.getPaymentStatus());
            }
            ArrayList<CJROrderSummaryPayment> paymentInfo = this.J.getPaymentInfo();
            String str = "";
            if (paymentInfo != null) {
                int size = paymentInfo.size();
                String str2 = str;
                for (int i2 = 0; i2 < size; i2++) {
                    str2 = str2 + paymentInfo.get(0).getPaymentMethod();
                    if (i2 < size - 1) {
                        str2 = str2 + " + ";
                    }
                }
                str = str2;
            }
            hashMap.put("movie_payment_type", String.valueOf(str));
            if (this.J != null && this.J.getPaymentStatus() != null && !b(this.J) && !TextUtils.isEmpty(this.J.getPaymentSummary())) {
                hashMap.put("movie_payment_error_message", this.J.getPaymentSummary());
            }
            String a2 = com.paytm.utility.a.a((Context) this);
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("movie_user_id", a2);
            }
            if (this.J != null) {
                hashMap.put("movie_amount", Double.valueOf(this.J.getGrandTotal()));
            }
            if (!(this.J == null || this.J.getOrderedCartList() == null || this.J.getOrderedCartList().size() <= 0 || this.J.getOrderedCartList().get(0).getMetaDataResponse() == null)) {
                Object metaDataResponse = this.J.getOrderedCartList().get(0).getMetaDataResponse();
                com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
                CJROrderSummaryMetadataResponse cJROrderSummaryMetadataResponse = (CJROrderSummaryMetadataResponse) fVar.a(fVar.a(metaDataResponse), CJROrderSummaryMetadataResponse.class);
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getCitySearched())) {
                    hashMap.put("movie_city_name", cJROrderSummaryMetadataResponse.getCitySearched());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getSource())) {
                    hashMap.put("movie_cinema_listing_type", cJROrderSummaryMetadataResponse.getSource());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getShowTime())) {
                    hashMap.put("movie_show_timing_bucket", com.paytm.utility.b.D(com.paytm.utility.b.B(cJROrderSummaryMetadataResponse.getShowTime())));
                }
            }
            net.one97.paytm.j.a.b("movie_payment_status_displayed", (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private void H() {
        try {
            net.one97.paytm.j.a.a("mov_payment_successful", (Context) this);
            String V2 = V();
            if (!TextUtils.isEmpty(V2) && V2.equalsIgnoreCase("SUCCESS")) {
                I();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void I() {
        try {
            net.one97.paytm.j.a.a("mov_booking_successful", (Context) this);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void J() {
        ArrayList<CJROrderedCart> orderedCartList = this.J.getOrderedCartList();
        HashMap hashMap = new HashMap();
        Iterator<CJROrderedCart> it2 = orderedCartList.iterator();
        while (it2.hasNext()) {
            CJROrderedCart next = it2.next();
            if (next.getProductDetail() != null) {
                CJROrderSummaryProductDetail productDetail = next.getProductDetail();
                String valueOf = String.valueOf(productDetail.getId());
                productDetail.setDiscountedPrice(next.getTotalPrice());
                ArrayList arrayList = (ArrayList) hashMap.get(valueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(valueOf, arrayList);
                }
                arrayList.add(productDetail);
            }
        }
        for (String str : hashMap.keySet()) {
            Iterator it3 = ((ArrayList) hashMap.get(str)).iterator();
            if (it3.hasNext()) {
                CJROrderSummaryProductDetail cJROrderSummaryProductDetail = (CJROrderSummaryProductDetail) it3.next();
                StringBuilder sb = new StringBuilder();
                sb.append(i.f52406a);
                sb.append(cJROrderSummaryProductDetail.getCategoryMapPath());
                String.valueOf(cJROrderSummaryProductDetail.getDiscountedPrice());
                i.a();
            }
        }
    }

    private void j(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        CJROrderSummaryProductDetail cJROrderSummaryProductDetail;
        ArrayList<CJROrderedCart> orderedCartList = this.J.getOrderedCartList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator<CJROrderedCart> it2 = orderedCartList.iterator();
        while (it2.hasNext()) {
            CJROrderedCart next = it2.next();
            if (next.getProductDetail() != null) {
                CJROrderSummaryProductDetail productDetail = next.getProductDetail();
                String valueOf = String.valueOf(productDetail.getId());
                productDetail.setDiscountedPrice(next.getDiscountedPrice());
                ArrayList arrayList = (ArrayList) hashMap.get(valueOf);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(valueOf, arrayList);
                }
                arrayList.add(productDetail);
                StringBuilder sb = new StringBuilder();
                sb.append(next.getMerchantId());
                hashMap2.put(valueOf, sb.toString());
            }
        }
        String id = this.J.getId();
        ArrayList arrayList2 = new ArrayList();
        String str6 = "";
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        for (String str10 : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str10);
            if (arrayList3 == null || arrayList3.size() <= 0 || (cJROrderSummaryProductDetail = (CJROrderSummaryProductDetail) arrayList3.get(0)) == null) {
                str5 = str6;
                str3 = str7;
                str4 = str8;
                str2 = str9;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(arrayList3.size());
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(cJROrderSummaryProductDetail.getId());
                String sb5 = sb4.toString();
                String name = cJROrderSummaryProductDetail.getName();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(cJROrderSummaryProductDetail.getDiscountedPrice());
                String sb7 = sb6.toString();
                arrayList2.clear();
                Iterator<CJRCategoryMap> it3 = cJROrderSummaryProductDetail.getCategoryMap().iterator();
                while (it3.hasNext()) {
                    arrayList2.add(it3.next().getCategoryId());
                }
                str3 = sb3;
                str4 = sb5;
                str2 = name;
                str5 = sb7;
            }
            Iterator it4 = arrayList3.iterator();
            if (it4.hasNext()) {
                it4.next();
                v.f69802a.a(getApplicationContext(), str, this.J.getAggregateItemPrice(), str5, str4, id, arrayList2, str3, str2, (String) hashMap2.get(str10));
            }
            str6 = str5;
            str8 = str4;
            str7 = str3;
            str9 = str2;
        }
    }

    private void b(ArrayList<CJROrderSummaryTransaction> arrayList) {
        if (arrayList.size() > 0) {
            findViewById(R.id.lyt_bank_payment).setVisibility(0);
            TextView textView = (TextView) findViewById(R.id.bank_payment);
            a((TextView) findViewById(R.id.bank_payment_label), textView, arrayList.get(0));
        }
        if (arrayList.size() > 1) {
            findViewById(R.id.lyt_bank_payment_transaction).setVisibility(0);
            TextView textView2 = (TextView) findViewById(R.id.bank_transaction_no);
            a((TextView) findViewById(R.id.bank_transaction_no_label), textView2, arrayList.get(1));
        }
        if (arrayList.size() > 2) {
            findViewById(R.id.lyt_paytm_payment).setVisibility(0);
            TextView textView3 = (TextView) findViewById(R.id.paytm_payment);
            a((TextView) findViewById(R.id.paytm_payment_label), textView3, arrayList.get(2));
        }
        if (arrayList.size() > 3) {
            findViewById(R.id.lyt_paytm_payment_transaction).setVisibility(0);
            TextView textView4 = (TextView) findViewById(R.id.paytm_transaction_no);
            a((TextView) findViewById(R.id.paytm_transaction_no_label), textView4, arrayList.get(3));
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 56) {
            return;
        }
        if (s.a(iArr)) {
            if (this.l != null) {
                c();
            }
        } else if (s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", this) != 1) {
            b(true);
        }
    }

    private void b(final boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            if (z) {
                builder.setMessage(getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
            } else {
                builder.setMessage(getResources().getString(R.string.enable_download_manager_permission_alert_msg));
            }
            builder.setPositiveButton(getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (z) {
                        s.b((Context) AJROrderSummaryActivityBase.this);
                        AJROrderSummaryActivityBase.this.finish();
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:com.android.providers.downloads"));
                        AJROrderSummaryActivityBase.this.startActivity(intent);
                    } catch (ActivityNotFoundException e2) {
                        q.b(e2.getMessage());
                        AJROrderSummaryActivityBase.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }
            });
            builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            builder.show();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        registerReceiver(this.bF, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        this.bb = a(Uri.parse(this.l));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        android.widget.Toast.makeText(r2, getResources().getString(net.one97.paytm.paytm_finance.R.string.no_pdf_view_msg), 0).show();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0033
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0033 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0033 }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r1 = "application/pdf"
            r0.setDataAndType(r3, r1)     // Catch:{ Exception -> 0x0033 }
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r0.setFlags(r3)     // Catch:{ Exception -> 0x0033 }
            r3 = 1
            r0.setFlags(r3)     // Catch:{ Exception -> 0x0033 }
            r2.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x001f }
            return
        L_0x001f:
            android.content.res.Resources r3 = r2.getResources()     // Catch:{ Exception -> 0x0033 }
            r0 = 2131959730(0x7f131fb2, float:1.9556109E38)
            java.lang.String r3 = r3.getString(r0)     // Catch:{ Exception -> 0x0033 }
            r0 = 0
            android.widget.Toast r3 = android.widget.Toast.makeText(r2, r3, r0)     // Catch:{ Exception -> 0x0033 }
            r3.show()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.a(java.lang.String):void");
    }

    private void a(TextView textView, TextView textView2, CJROrderSummaryTransaction cJROrderSummaryTransaction) {
        textView.setText(cJROrderSummaryTransaction.getTitle());
        if (TextUtils.isEmpty(cJROrderSummaryTransaction.getType()) || !cJROrderSummaryTransaction.getType().equalsIgnoreCase("amount")) {
            textView2.setText(cJROrderSummaryTransaction.getValue());
            return;
        }
        textView2.setText(getResources().getString(R.string.rs) + " " + com.paytm.utility.b.x(cJROrderSummaryTransaction.getValue()));
    }

    private long K() {
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary == null) {
            return 0;
        }
        Iterator<CJROrderedCart> it2 = cJROrderSummary.getOrderedCartList().iterator();
        while (it2.hasNext()) {
            CJROrderedCart next = it2.next();
            if (next != null && next.isReplacement() && next.getParentOrderId() > 0) {
                return next.getParentOrderId();
            }
        }
        return 0;
    }

    private void L() {
        ((TextView) findViewById(R.id.order_no)).setText(Html.fromHtml(this.J.getId()));
        ((TextView) findViewById(R.id.timestamp)).setText(c(this.J.getCreatedAt(), "paymentDetails"));
        findViewById(R.id.lyt_bank_payment).setVisibility(8);
        findViewById(R.id.lyt_bank_payment_transaction).setVisibility(8);
        findViewById(R.id.lyt_paytm_payment).setVisibility(8);
        findViewById(R.id.lyt_paytm_payment_transaction).setVisibility(8);
        if (this.J.getTransactionDetails() == null || this.J.getTransactionDetails().size() <= 0) {
            findViewById(R.id.transaction_all_details).setVisibility(8);
            findViewById(R.id.transaction_details).setVisibility(8);
            findViewById(R.id.sep_3).setVisibility(8);
        } else {
            b(this.J.getTransactionDetails());
        }
        final long K2 = K();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.replacement_parent_layout);
        if (K2 > 0) {
            linearLayout.setVisibility(0);
            ((TextView) findViewById(R.id.replacement_order_no)).setText(Html.fromHtml(String.valueOf(K2)));
            ((TextView) findViewById(R.id.view_old_order)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJROrderSummaryActivityBase.this.c(K2);
                }
            });
            return;
        }
        linearLayout.setVisibility(8);
    }

    private void a(TextView textView, CJRAddress cJRAddress) {
        textView.setText("");
        if (cJRAddress.getName() != null) {
            textView.append(Html.fromHtml(cJRAddress.getName() + "<br/>"));
        }
        if (cJRAddress.getAddress1() != null) {
            textView.append(Html.fromHtml(cJRAddress.getAddress1() + ",<br/>"));
        }
        if (cJRAddress.getAddress2() != null) {
            textView.append(Html.fromHtml(cJRAddress.getAddress2() + ",<br/>"));
        }
        if (cJRAddress.getCity() != null) {
            textView.append(Html.fromHtml(cJRAddress.getCity() + "- "));
        }
        if (cJRAddress.getPin() != null) {
            textView.append(Html.fromHtml(cJRAddress.getPin() + ", <br/>"));
        }
        if (cJRAddress.getState() != null) {
            textView.append(Html.fromHtml(cJRAddress.getState() + ",<br/>"));
        }
        if (cJRAddress.getMobile() != null) {
            textView.append(Html.fromHtml(getResources().getString(R.string.label_mobile) + ": +91" + cJRAddress.getMobile()));
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, final NetworkCustomError networkCustomError) {
        super.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        this.aq.setVisibility(8);
        v();
        m();
        runOnUiThread(new Runnable() {
            public final void run() {
                AJROrderSummaryActivityBase.this.findViewById(R.id.summary_progress_bar).setVisibility(8);
                if (AJROrderSummaryActivityBase.this.J == null) {
                    AJROrderSummaryActivityBase.this.findViewById(R.id.scroll_view).setVisibility(8);
                }
                NetworkCustomError networkCustomError = networkCustomError;
                if (networkCustomError != null) {
                    if (!TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
                        l.a((Activity) AJROrderSummaryActivityBase.this, networkCustomError, AJRMainActivity.class.getName());
                    } else if (networkCustomError.getMessage() == null || AJROrderSummaryActivityBase.this.f51399f || r.a((Context) AJROrderSummaryActivityBase.this, (Exception) networkCustomError)) {
                        if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("412")) {
                            AJROrderSummaryActivityBase.a(AJROrderSummaryActivityBase.this, networkCustomError);
                        }
                    } else if (networkCustomError.getMessage() != null && networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                        com.paytm.utility.b.d((Context) AJROrderSummaryActivityBase.this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
                    } else if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("412")) {
                        String string = AJROrderSummaryActivityBase.this.getResources().getString(R.string.network_error_message);
                        AJROrderSummaryActivityBase aJROrderSummaryActivityBase = AJROrderSummaryActivityBase.this;
                        com.paytm.utility.b.b((Context) aJROrderSummaryActivityBase, aJROrderSummaryActivityBase.getResources().getString(R.string.network_error_heading), string);
                    } else {
                        AJROrderSummaryActivityBase.a(AJROrderSummaryActivityBase.this, networkCustomError);
                    }
                    if (AJROrderSummaryActivityBase.this.f51399f) {
                        AJROrderSummaryActivityBase.this.f51399f = false;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Bundle bundle, boolean z) {
        new CJRHomePageItem().setUrl(ag.a(getApplicationContext()).b("home_url", "", true));
        Intent intent = new Intent(this, AJRMainActivity.class);
        if (bundle != null) {
            intent.putExtra("bundle_to_load_banner_from_order_summary", bundle);
        }
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        if (!TextUtils.isEmpty(this.L) && this.L.equalsIgnoreCase("Payment")) {
            intent.putExtra("Reset_fast_farward", true);
        }
        intent.putExtra(CJRConstants.EXTRA_INTENT_IS_FROM_MESSAGE_TO_HOME, true);
        startActivity(intent);
        if (z) {
            finish();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBackPressed() {
        /*
            r5 = this;
            java.lang.String r0 = r5.L
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x009d
            java.lang.String r0 = r5.L
            java.lang.String r1 = "Payment"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x001c
            java.lang.String r0 = r5.L
            java.lang.String r1 = "paytm_automatic"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x009d
        L_0x001c:
            androidx.fragment.app.j r0 = r5.getSupportFragmentManager()
            java.lang.Class<net.one97.paytm.recharge.legacy.ordersummary.a.c> r1 = net.one97.paytm.recharge.legacy.ordersummary.a.c.class
            java.lang.String r1 = r1.getName()
            androidx.fragment.app.Fragment r0 = r0.c((java.lang.String) r1)
            if (r0 == 0) goto L_0x0038
            boolean r0 = r0 instanceof net.one97.paytm.recharge.legacy.ordersummary.a.c
            if (r0 == 0) goto L_0x0038
            androidx.fragment.app.j r0 = r5.getSupportFragmentManager()
            r0.d()
            return
        L_0x0038:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r5.J
            if (r0 == 0) goto L_0x009d
            boolean r0 = r5.Q
            if (r0 != 0) goto L_0x009d
            r0 = 1
            r5.Q = r0
            r1 = 0
            r2 = 0
            r5.a((android.os.Bundle) r1, (boolean) r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r5.J
            java.util.ArrayList r1 = r1.getOrderedCartList()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0096
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r5.J
            java.util.ArrayList r1 = r1.getOrderedCartList()
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r1.getProductDetail()
            java.lang.String r3 = r1.getVertical()
            java.lang.String r4 = "Recharge"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x007a
            java.lang.String r3 = r1.getVertical()
            boolean r3 = net.one97.paytm.utils.l.b((java.lang.String) r3)
            if (r3 == 0) goto L_0x0096
        L_0x007a:
            java.lang.String r3 = r5.aG
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0096
            java.lang.String r3 = r5.aF
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0096
            long r3 = r1.getId()
            java.lang.String r1 = java.lang.String.valueOf(r3)
            r5.b((java.lang.String) r1, (boolean) r2)
            goto L_0x0097
        L_0x0096:
            r0 = 0
        L_0x0097:
            if (r0 == 0) goto L_0x009c
            r5.finish()
        L_0x009c:
            return
        L_0x009d:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            boolean r1 = r5.bc
            java.lang.String r2 = "extra_action_updated"
            r0.putExtra(r2, r1)
            r1 = -1
            r5.setResult(r1, r0)
            r5.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.onBackPressed():void");
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        k();
        String str = this.L;
        if (str != null && str.equalsIgnoreCase("Deep Linking")) {
            j();
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public void handleContinueShopping(View view) {
        CJROrderedCart cJROrderedCart;
        CJROrderSummaryProductDetail productDetail;
        boolean z = false;
        try {
            if (!(this.J == null || this.J.getOrderedCartList() == null || this.J.getOrderedCartList().size() <= 0 || (cJROrderedCart = this.J.getOrderedCartList().get(0)) == null || cJROrderedCart.getProductDetail() == null || (productDetail = cJROrderedCart.getProductDetail()) == null || productDetail.getVertical() == null || TextUtils.isEmpty(productDetail.getVertical()) || !productDetail.getVertical().equalsIgnoreCase("Paytm Hotel"))) {
                k("clicked_continue_order_summary");
            }
        } catch (IndexOutOfBoundsException e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        } catch (Exception e3) {
            if (com.paytm.utility.b.v) {
                q.b(e3.getMessage());
            }
        }
        a((Bundle) null, false);
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList().size() > 0) {
            CJROrderSummaryProductDetail productDetail2 = this.J.getOrderedCartList().get(0).getProductDetail();
            if (("Recharge".equalsIgnoreCase(productDetail2.getVertical()) || l.b(productDetail2.getVertical())) && !TextUtils.isEmpty(this.aG) && !TextUtils.isEmpty(this.aF)) {
                b(String.valueOf(productDetail2.getId()), true);
                z = true;
            }
        }
        if (z) {
            finish();
        }
    }

    private void k(String str) {
        try {
            net.one97.paytm.j.a.a(str, "Order summary", (Context) this);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private static int a(ArrayList<CJROrderedCart> arrayList, CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart == null || arrayList == null || arrayList.size() == 0) {
            return 0;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (cJROrderedCart.getId() == arrayList.get(i2).getId()) {
                return i2;
            }
        }
        return 0;
    }

    private void c(ArrayList<CJROrderedCart> arrayList) {
        int i2;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ordered_item_list);
        linearLayout.removeAllViews();
        boolean isOrderDetailsExpanded = this.ac.isOrderDetailsExpanded();
        if (!ac() || isOrderDetailsExpanded || R()) {
            i2 = arrayList.size();
        } else {
            i2 = 1;
        }
        CJRHomePageV2 cJRHomePageV2 = this.ac;
        if (cJRHomePageV2 == null || cJRHomePageV2.isOrderDetailsExpanded()) {
            findViewById(R.id.sep_above_order_details_txt).setVisibility(0);
        } else {
            findViewById(R.id.sep_above_order_details_txt).setVisibility(8);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!(arrayList == null || arrayList.get(i3) == null)) {
                View a2 = a(arrayList.get(i3), i3);
                ImageView imageView = (ImageView) a2.findViewById(R.id.list_sep);
                boolean z = (arrayList.get(i3).getProductDetail() == null || arrayList.get(i3).getProductDetail().getProductType() == null) ? false : true;
                if (i3 + 1 == arrayList.size()) {
                    imageView.setVisibility(8);
                } else if (z) {
                    imageView.setVisibility(0);
                }
                linearLayout.addView(a2);
            }
        }
    }

    private String l(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if (parse == null) {
            str2 = str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
        } else if (parse.getQuery() != null) {
            str2 = str + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.AND_SIGN;
        } else {
            str2 = str + "?";
        }
        return str2 + "sso_token=" + ag.a(getApplicationContext()).b("sso_token=", "", true);
    }

    private void c(CJROrderedCart cJROrderedCart) {
        a((Context) this, getResources().getString(R.string.please_wait_progress_msg));
        this.f51399f = true;
        net.one97.paytm.common.b.d.a(this, l(cJROrderedCart.getTapAction().getUrlParams().getUrl()).replace(" ", "%20"), this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.GET, (String) null, cJROrderedCart, a.c.HOME, a.b.SILENT).a();
    }

    private void d(CJROrderedCart cJROrderedCart) {
        a((Context) this, getResources().getString(R.string.please_wait_progress_msg));
        String replace = l(cJROrderedCart.getTapAction().getUrlParams().getUrl()).replace(" ", "%20");
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        net.one97.paytm.common.b.d.a(this, replace, this, hashMap, (Map<String, String>) null, a.C0715a.POST, cJROrderedCart.getTapAction().getUrlParams().getBody() != null ? cJROrderedCart.getTapAction().getUrlParams().getBody().toString() : null, cJROrderedCart, a.c.HOME, a.b.SILENT).a();
    }

    public final void a(String str, boolean z) {
        a((Context) this, getResources().getString(R.string.please_wait_progress_msg));
        String replace = l(str).replace(" ", "%20");
        if (z) {
            net.one97.paytm.common.b.d.a(this, replace, this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRReplacementResponse(), a.c.HOME, a.b.SILENT).a();
            return;
        }
        net.one97.paytm.common.b.d.a(this, replace, this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRActionResponse(), a.c.HOME, a.b.SILENT).a();
    }

    public final void a(String str, String str2, boolean z) {
        a((Context) this, getResources().getString(R.string.please_wait_progress_msg));
        String replace = l(str).replace(" ", "%20");
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (z) {
            net.one97.paytm.common.b.d.a(this, replace, this, hashMap, (Map<String, String>) null, a.C0715a.POST, str2, new CJRReplacementResponse(), a.c.HOME, a.b.SILENT).a();
            return;
        }
        net.one97.paytm.common.b.d.a(this, replace, this, hashMap, (Map<String, String>) null, a.C0715a.POST, str2, new CJRActionResponse(), a.c.HOME, a.b.SILENT).a();
    }

    private void a(g gVar, View view) {
        try {
            int u = com.paytm.utility.a.u(this);
            view.findViewById(R.id.main_view_1).setPadding(u, 0, 0, 0);
            view.findViewById(R.id.lyt_detailed_view).setPadding(u, 0, 0, 0);
            gVar.S = (TextView) view.findViewById(R.id.repeat_retry);
            gVar.T = (TextView) view.findViewById(R.id.recharge_repeat_retry);
            gVar.f51623f = (TextView) view.findViewById(R.id.quantity);
            gVar.f51623f.setPadding(0, u, 0, u);
            gVar.q = (LinearLayout) view.findViewById(R.id.size_layout);
            gVar.n = (TextView) view.findViewById(R.id.size_value);
            gVar.n.setPadding(0, u, 0, u);
            gVar.I = (TextView) view.findViewById(R.id.marketPlace_price);
            gVar.f51626i = (TextView) view.findViewById(R.id.promo_text);
            gVar.f51626i.setPadding(u, 0, 0, 0);
            gVar.j = (TextView) view.findViewById(R.id.promo_code_badge_text);
            gVar.k = (TextView) view.findViewById(R.id.offer_text);
            gVar.f51624g = (TextView) view.findViewById(R.id.price);
            gVar.f51625h = (TextView) view.findViewById(R.id.brand_name);
            gVar.K = (LinearLayout) view.findViewById(R.id.lyt_price_quantity);
            gVar.K.setPadding(0, u, u, 0);
            gVar.r = (RelativeLayout) view.findViewById(R.id.offer_lyt);
            gVar.r.setPadding(0, u, u, u);
            gVar.s = (RelativeLayout) view.findViewById(R.id.promo_lyt);
            gVar.s.setPadding(0, u, u, u);
            gVar.l = (TextView) view.findViewById(R.id.detailed_description);
            gVar.l.setPadding(0, u, 0, 0);
            gVar.m = (TextView) view.findViewById(R.id.details);
            gVar.o = (LinearLayout) view.findViewById(R.id.action_btn_lyt);
            gVar.t = (RelativeLayout) view.findViewById(R.id.action_radio_lyt);
            gVar.t.setPadding(0, u, 0, u);
            gVar.A = (Button) view.findViewById(R.id.action_proceed_btn);
            int i2 = u * 4;
            gVar.A.getLayoutParams().height = i2;
            gVar.C = (RadioGroup) view.findViewById(R.id.action_grp_radio);
            gVar.E = (TextView) view.findViewById(R.id.action_description);
            gVar.E.setPadding(0, 0, u, 0);
            gVar.p = (LinearLayout) view.findViewById(R.id.tap_action_btn_lyt);
            gVar.w = (RelativeLayout) view.findViewById(R.id.tap_action_radio_lyt);
            gVar.w.setPadding(0, u, u, u);
            gVar.B = (Button) view.findViewById(R.id.tap_action_proceed_btn);
            gVar.B.getLayoutParams().height = i2;
            gVar.D = (RadioGroup) view.findViewById(R.id.tap_action_grp_radio);
            gVar.F = (TextView) view.findViewById(R.id.tap_action_radio_description);
            gVar.F.setPadding(0, 0, 0, 0);
            gVar.u = (RelativeLayout) view.findViewById(R.id.action);
            gVar.u.setPadding(0, 0, 0, 0);
            gVar.v = (RelativeLayout) view.findViewById(R.id.lyt_tap_action);
            gVar.z = (RelativeLayout) view.findViewById(R.id.actions_lyt);
            gVar.x = (RelativeLayout) view.findViewById(R.id.lyt_detailed_view);
            gVar.G = (TextView) view.findViewById(R.id.merchant_name);
            gVar.G.setPadding(0, 0, u, 0);
            gVar.J = (LinearLayout) view.findViewById(R.id.lyt_price_quantity);
            gVar.ad = (RelativeLayout) view.findViewById(R.id.lyt_status_details_recharge);
            gVar.Z = (TextView) view.findViewById(R.id.details_recharge);
            gVar.H = (TextView) view.findViewById(R.id.order_status_recharge);
            gVar.H.setPadding(0, u, u, 0);
            gVar.I.setPadding(0, u, 0, u);
            gVar.L = (ProgressBar) view.findViewById(R.id.recharge_refress_loader);
            gVar.aa = (ImageView) view.findViewById(R.id.content_thumbnail_recharge);
            gVar.ab = (ImageView) view.findViewById(R.id.content_thumbnail_marketplace);
            gVar.f51622e = (LinearLayout) view.findViewById(R.id.gvSentDetailLl);
            gVar.N = (ProgressBar) view.findViewById(R.id.new_marketplace_loading);
            gVar.O = (ProgressBar) view.findViewById(R.id.loading_recharge);
            com.paytm.utility.b.d(gVar.S);
            com.paytm.utility.b.a(gVar.T);
            gVar.W = (TextView) view.findViewById(R.id.desc_marketplace);
            gVar.Y = (TextView) view.findViewById(R.id.desc_recharge);
            gVar.U = (TextView) view.findViewById(R.id.total_price);
            gVar.U.setPadding(u, u, 0, 0);
            gVar.V = (TextView) view.findViewById(R.id.order_status_marketplace);
            gVar.ah = (RelativeLayout) view.findViewById(R.id.lyt_status_details_marketplace);
            gVar.M = (ProgressBar) view.findViewById(R.id.marketplace_refress_loader);
            gVar.X = (TextView) view.findViewById(R.id.order_accepted_date_marketplace);
            gVar.ac = (RelativeLayout) view.findViewById(R.id.order_summary_recharge_lyt);
            gVar.ae = (RelativeLayout) view.findViewById(R.id.lyt_above_fav);
            gVar.af = (RelativeLayout) view.findViewById(R.id.recharge_description);
            gVar.ag = (LinearLayout) view.findViewById(R.id.order_summary_shopping_lyt);
            gVar.ac.setPadding(0, u, u, 0);
            gVar.am = (LinearLayout) view.findViewById(R.id.flow_date_lyt);
            gVar.am.setPadding(0, u, u, 0);
            gVar.an = (LinearLayout) view.findViewById(R.id.flow_icon_lyt);
            gVar.an.setPadding(0, 0, u, 0);
            gVar.ao = (LinearLayout) view.findViewById(R.id.shipping_procedure_lyt);
            gVar.ao.setPadding(0, 0, u, 0);
            gVar.at = (TextView) view.findViewById(R.id.order_accepted_label);
            gVar.au = (TextView) view.findViewById(R.id.order_shipped_label);
            gVar.av = (TextView) view.findViewById(R.id.order_delivered_label);
            gVar.aw = (TextView) view.findViewById(R.id.order_refunded_label);
            gVar.ax = (TextView) view.findViewById(R.id.order_accepted_date);
            gVar.ay = (TextView) view.findViewById(R.id.order_shipped_date);
            gVar.az = (TextView) view.findViewById(R.id.order_delivered_date);
            gVar.aA = (TextView) view.findViewById(R.id.order_refunded_date);
            gVar.ap = (ImageView) view.findViewById(R.id.order_accepted_icon);
            gVar.aq = (ImageView) view.findViewById(R.id.order_shipped_icon);
            gVar.ar = (ImageView) view.findViewById(R.id.order_delivered_icon);
            gVar.as = (ImageView) view.findViewById(R.id.order_refunded_icon);
            gVar.aj = (ImageView) view.findViewById(R.id.order_delivered_seperator);
            gVar.W.setPadding(0, u, u, u);
            gVar.ai = (ImageView) view.findViewById(R.id.list_sep);
            gVar.ai.setPadding(u, 0, u, 0);
            gVar.ak = (TextView) view.findViewById(R.id.order_status_recharge_badge);
            gVar.al = (TextView) view.findViewById(R.id.order_status_marketplace_badge);
            gVar.aU = (RelativeLayout) view.findViewById(R.id.marketplace_detail);
            gVar.aU.setPadding(0, 0, u, 0);
            gVar.aK = (RelativeLayout) view.findViewById(R.id.flow_date_without_cancel_lyt);
            gVar.aK.setPadding(0, 0, u, 0);
            gVar.aL = (RelativeLayout) view.findViewById(R.id.flow_icon_without_cancel_lyt);
            gVar.aL.setPadding(0, 0, u, 0);
            gVar.aM = (RelativeLayout) view.findViewById(R.id.shipping_procedure_without_cancel_lyt);
            gVar.aM.setPadding(0, 0, u, 0);
            gVar.aE = (TextView) view.findViewById(R.id.order_accepted_without_cancel_label);
            gVar.aF = (TextView) view.findViewById(R.id.order_shipped_without_cancel_label);
            gVar.aG = (TextView) view.findViewById(R.id.order_delivered_without_cancel_label);
            gVar.aH = (TextView) view.findViewById(R.id.order_accepted_without_cancel_date);
            gVar.aI = (TextView) view.findViewById(R.id.order_shipped_without_cancel_date);
            gVar.aJ = (TextView) view.findViewById(R.id.order_delivered_without_cancel_date);
            gVar.aB = (ImageView) view.findViewById(R.id.order_accepted_without_cancel_icon);
            gVar.aC = (ImageView) view.findViewById(R.id.order_shipped_without_cancel_icon);
            gVar.aD = (ImageView) view.findViewById(R.id.order_delivered_without_cancel_icon);
            gVar.aO = (LinearLayout) view.findViewById(R.id.status_flow_without_cancel);
            gVar.aN = (LinearLayout) view.findViewById(R.id.status_flow_with_cancel);
            gVar.aN.setPadding(0, u, 0, 0);
            gVar.aO.setPadding(0, u, 0, 0);
            gVar.aP = (TextView) view.findViewById(R.id.expand_marketplace_status);
            gVar.aQ = (TextView) view.findViewById(R.id.collapse_marketplace_status);
            gVar.aR = (TextView) view.findViewById(R.id.order_status_marketplace_more);
            gVar.aS = (RelativeLayout) view.findViewById(R.id.content_thumbnail_layout_recharge);
            gVar.aT = (RelativeLayout) view.findViewById(R.id.content_thumbnail_layout_marketplace);
            gVar.aV = (RelativeLayout) view.findViewById(R.id.favourite_lyt);
            gVar.aW = (TextView) view.findViewById(R.id.set_favourite_name);
            gVar.aY = (ImageView) view.findViewById(R.id.favourite_icon);
            gVar.aX = (TextView) view.findViewById(R.id.fav_whats_this);
            gVar.y = (RelativeLayout) view.findViewById(R.id.retry_and_actions);
            gVar.y.setPadding(u, u, u, 0);
            gVar.aZ = (RelativeLayout) view.findViewById(R.id.paytm_automatic);
            gVar.aZ.setPadding(u, u, u, 0);
            gVar.bc = (ImageView) view.findViewById(R.id.sep_above_paytm_automatic);
            gVar.bc.setPadding(u, 0, u, 0);
            gVar.ba = (RelativeLayout) view.findViewById(R.id.automatic_duration_lyt);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.aZ.getLayoutParams();
            layoutParams.setMargins(0, u, 0, u);
            gVar.aZ.setLayoutParams(layoutParams);
            gVar.bg = (Button) view.findViewById(R.id.confirm_btn);
            gVar.bf = (Button) view.findViewById(R.id.how_does_it_work);
            gVar.bh = (TextView) view.findViewById(R.id.select_auto_duration);
            gVar.bb = (RelativeLayout) view.findViewById(R.id.fav_name_icon_lyt);
            gVar.bi = (TextView) view.findViewById(R.id.auto_recharge_label);
            gVar.bj = (TextView) view.findViewById(R.id.auto_recharge_content);
            gVar.bk = (TextView) view.findViewById(R.id.auto_duration_label);
            gVar.bn = (LinearLayout) view.findViewById(R.id.sellar_rate_lyt);
            gVar.bn.setPadding(u, 0, u, u);
            gVar.bo = (LinearLayout) view.findViewById(R.id.pre_sellar_rate_lyt);
            gVar.bu = (RelativeLayout) view.findViewById(R.id.post_sellar_rate_lyt);
            int i3 = (int) (((double) u) * 1.5d);
            gVar.br = (TextView) view.findViewById(R.id.pre_rate_sellar_txt);
            gVar.br.setPadding(0, i3, 0, 0);
            gVar.bs = (TextView) view.findViewById(R.id.post_rate_sellar_txt);
            gVar.bs.setPadding(0, i3, 0, 0);
            gVar.bd = (ImageView) view.findViewById(R.id.promo_offer_sep);
            gVar.bd.setPadding(u, 0, u, 0);
            gVar.bv = (RatingBar) view.findViewById(R.id.merchant_rating_bar);
            gVar.bv.setPadding(0, i3, 0, 0);
            LayerDrawable layerDrawable = (LayerDrawable) gVar.bv.getProgressDrawable();
            layerDrawable.getDrawable(2).setColorFilter(getResources().getColor(R.color.orange_promo_msg), PorterDuff.Mode.SRC_ATOP);
            layerDrawable.getDrawable(1).setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
            layerDrawable.getDrawable(0).setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
            gVar.bw = (ImageView) view.findViewById(R.id.sep_below_rate);
            gVar.bp = (LinearLayout) view.findViewById(R.id.sellar_rate_padding_lyt);
            gVar.bp.setPadding(0, 0, 0, u);
            gVar.bl = (TextView) view.findViewById(R.id.seller_info_txt);
            gVar.bl.setPadding(0, i3, 0, 0);
            gVar.bq = (LinearLayout) view.findViewById(R.id.hotel_seller_info_lyt);
            gVar.bq.setPadding(i3, i3, i3, 0);
            gVar.bm = (TextView) view.findViewById(R.id.hotel_seller_info_txt);
            gVar.bm.setPadding(0, i3, 0, 0);
            gVar.be = (ImageView) view.findViewById(R.id.sep_above_hotel_seller_info);
            gVar.bt = (TextView) view.findViewById(R.id.est_delivery_date);
            gVar.bt.setPadding(0, i3 + (i3 / 2), 0, 0);
            gVar.f51618a = (RelativeLayout) view.findViewById(R.id.pfa_layout);
            gVar.f51619b = (ImageView) view.findViewById(R.id.iv_pfa_image);
            gVar.f51620c = (TextView) view.findViewById(R.id.pfa_delivery_date_layout);
            gVar.f51621d = view.findViewById(R.id.pfa_seperator);
            int u2 = com.paytm.utility.a.u(this);
            gVar.cy = (RelativeLayout) view.findViewById(R.id.movie_item_lyt);
            gVar.bJ = (LinearLayout) view.findViewById(R.id.movie_contact_us_card);
            gVar.bJ.setPadding(u2, u2, u2, u2);
            gVar.bx = (ImageView) view.findViewById(R.id.content_thumbnail_movie);
            gVar.cA = (RelativeLayout) view.findViewById(R.id.content_thumbnail_layout_movie);
            gVar.P = (ProgressBar) view.findViewById(R.id.loading_movie);
            gVar.bA = (LinearLayout) view.findViewById(R.id.movie_success_lyt);
            int i4 = u2 * 2;
            gVar.bA.setPadding(u2, u2, u2, i4);
            gVar.bB = (LinearLayout) view.findViewById(R.id.movie_payment_layout);
            gVar.bB.setPadding(i4, i4, i4, i4);
            gVar.bC = (LinearLayout) view.findViewById(R.id.movie_pending_or_failed_lyt);
            gVar.bC.setPadding(i4, i4, i4, i4);
            gVar.bN = (Button) view.findViewById(R.id.try_again_btn);
            gVar.bN.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJROrderSummaryActivityBase.this.startActivity(ar.a((Context) AJROrderSummaryActivityBase.this));
                }
            });
            gVar.bO = (TextView) view.findViewById(R.id.movie_name);
            gVar.bO.setPadding(0, u2, 0, 0);
            gVar.bT = (TextView) view.findViewById(R.id.failed_movie_name);
            int i5 = u2 + u2;
            gVar.bT.setPadding(0, i5, 0, 0);
            gVar.cn = (TextView) view.findViewById(R.id.failed_movie_date);
            gVar.co = (TextView) view.findViewById(R.id.failed_movie_date_suffix);
            gVar.cp = (TextView) view.findViewById(R.id.failed_movie_month);
            gVar.bL = (LinearLayout) view.findViewById(R.id.failed_movie_date_lyt);
            gVar.bL.setPadding(0, (u2 / 2) + u2, 0, i5);
            gVar.cq = (TextView) view.findViewById(R.id.failed_movie_time);
            gVar.cf = (TextView) view.findViewById(R.id.movie_duration);
            gVar.cr = (TextView) view.findViewById(R.id.movie_need_help);
            gVar.bP = (TextView) view.findViewById(R.id.movie_date);
            gVar.bK = (LinearLayout) view.findViewById(R.id.movie_date_lyt);
            gVar.bK.setPadding(0, (u2 / 2) + u2, 0, 0);
            gVar.bY = (TextView) view.findViewById(R.id.movie_date_suffix);
            gVar.bZ = (TextView) view.findViewById(R.id.movie_month);
            gVar.bQ = (TextView) view.findViewById(R.id.movie_time);
            gVar.bQ.setPadding(i5, 0, 0, 0);
            gVar.bR = (TextView) view.findViewById(R.id.movie_status_badge);
            gVar.bS = (TextView) view.findViewById(R.id.movie_payment_txt);
            gVar.bS.setPadding(0, u2, 0, 0);
            gVar.cm = (TextView) view.findViewById(R.id.direct_to_map);
            gVar.cm.setPadding(u2, u2, 0, 0);
            gVar.bU = (TextView) view.findViewById(R.id.cinema_name);
            gVar.bU.setPadding(u2, u2, 0, 0);
            gVar.bW = (TextView) view.findViewById(R.id.movie_audi);
            gVar.bW.setPadding(u2, i4, 0, i4);
            gVar.cd = (TextView) view.findViewById(R.id.movie_status_badge);
            gVar.bV = (TextView) view.findViewById(R.id.movie_seats);
            gVar.bV.setPadding(i4, i4, u2, i4);
            gVar.bX = (TextView) view.findViewById(R.id.ticket_breakdown);
            gVar.bX.setPadding(0, u2, 0, 0);
            gVar.bE = (LinearLayout) view.findViewById(R.id.payment_lyt_1);
            gVar.bE.setPadding(0, u2, 0, 0);
            gVar.bF = (LinearLayout) view.findViewById(R.id.payment_lyt_2);
            gVar.bF.setPadding(0, u2, 0, 0);
            gVar.bG = (LinearLayout) view.findViewById(R.id.payment_lyt_3);
            gVar.bG.setPadding(0, u2, 0, 0);
            gVar.bH = (LinearLayout) view.findViewById(R.id.payment_lyt_4);
            gVar.bH.setPadding(0, u2, 0, u2);
            gVar.bD = (LinearLayout) view.findViewById(R.id.movie_contact_us_lyt);
            gVar.bD.setPadding(u2, 0, u2, 0);
            gVar.ca = (TextView) view.findViewById(R.id.contact_customer_care_txt);
            gVar.cb = (TextView) view.findViewById(R.id.sub_total_value);
            gVar.cc = (TextView) view.findViewById(R.id.total_value);
            gVar.cz = (RelativeLayout) view.findViewById(R.id.lyt_movie_total);
            gVar.cz.setPadding(0, u2, 0, 0);
            gVar.cg = (TextView) view.findViewById(R.id.payment_value_1);
            gVar.ch = (TextView) view.findViewById(R.id.payment_value_2);
            gVar.ci = (TextView) view.findViewById(R.id.payment_value_3);
            gVar.cj = (TextView) view.findViewById(R.id.payment_value_4);
            gVar.ck = (TextView) view.findViewById(R.id.cinema_address);
            gVar.ck.setPadding(u2, 0, 0, 0);
            gVar.cl = (TextView) view.findViewById(R.id.booking_id_value);
            gVar.ce = (TextView) view.findViewById(R.id.paytm_booking_id);
            gVar.ce.setPadding(0, u2, 0, 0);
            gVar.bI = (LinearLayout) view.findViewById(R.id.lyt_sub_total);
            gVar.bI.setPadding(0, u2, 0, u2);
            gVar.cB = (RelativeLayout) view.findViewById(R.id.movie_success_desc_lyt);
            gVar.cB.setPadding(u2, 0, 0, 0);
            gVar.cC = (RelativeLayout) view.findViewById(R.id.movie_qr_code_lyt);
            gVar.cC.setPadding(u2, u2 * 3, 0, 0);
            gVar.cE = (RelativeLayout) view.findViewById(R.id.movie_qr_lyt);
            gVar.cE.setPadding(i4, 0, 0, 0);
            gVar.cs = (TextView) view.findViewById(R.id.download_ticket);
            gVar.ct = (TextView) view.findViewById(R.id.movie_promo_text);
            gVar.cu = (TextView) view.findViewById(R.id.movie_promo_code_badge_text);
            gVar.cv = (TextView) view.findViewById(R.id.failed_movie_promo_text);
            gVar.cw = (TextView) view.findViewById(R.id.failed_movie_promo_code_badge_text);
            gVar.cF = (RelativeLayout) view.findViewById(R.id.success_movie_promo_lyt);
            gVar.cF.setVisibility(8);
            gVar.cG = (RelativeLayout) view.findViewById(R.id.failed_movie_promo_lyt);
            gVar.cG.setVisibility(8);
            gVar.bz = (ImageView) view.findViewById(R.id.movie_ticket_bottom_lyt);
            gVar.by = (ImageView) view.findViewById(R.id.content_thumbnail_qr);
            gVar.cD = (RelativeLayout) view.findViewById(R.id.content_thumbnail_layout_qr);
            gVar.Q = (ProgressBar) view.findViewById(R.id.loading_qr);
            gVar.R = (ProgressBar) view.findViewById(R.id.movie_refress_loader);
            gVar.cx = (TextView) view.findViewById(R.id.qr_desc_txt);
            gVar.bM = (LinearLayout) view.findViewById(R.id.lyt_tax_info);
            gVar.bM.setPadding(0, 0, 0, u2);
            gVar.cH = (RelativeLayout) view.findViewById(R.id.train_item_lyt);
            gVar.cH.setPadding(u, u, u, 0);
            gVar.cI = (TextView) view.findViewById(R.id.train_traveller_name);
            gVar.cK = (TextView) view.findViewById(R.id.order_status_train_badge);
            gVar.cJ = (TextView) view.findViewById(R.id.train_traveller_status);
            gVar.cJ.setPadding(0, u / 2, 0, 0);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0d41: MOVE  (r3v46 android.widget.TextView) = (r29v0 android.widget.TextView)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04f9  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0592  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x05cb  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x05d3  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x05df  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x05e1  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x05e8 A[SYNTHETIC, Splitter:B:223:0x05e8] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0669  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x067b  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0685  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0844  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0894  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x08a2  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x08c3  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0a7c  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x0abd  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0ad6  */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x0b18  */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0b5c  */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x0b7d  */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0b83  */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0b8e  */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x0c05  */
    /* JADX WARNING: Removed duplicated region for block: B:462:0x0cee  */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0cfb  */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x0d34 A[Catch:{ Exception -> 0x0d4b }] */
    /* JADX WARNING: Removed duplicated region for block: B:476:0x0d39 A[Catch:{ Exception -> 0x0d4b }] */
    /* JADX WARNING: Removed duplicated region for block: B:477:0x0d3e A[Catch:{ Exception -> 0x0d4b }] */
    /* JADX WARNING: Removed duplicated region for block: B:488:0x0d59  */
    /* JADX WARNING: Removed duplicated region for block: B:540:0x0ee0  */
    /* JADX WARNING: Removed duplicated region for block: B:566:0x0faa  */
    /* JADX WARNING: Removed duplicated region for block: B:569:0x0fb3  */
    /* JADX WARNING: Removed duplicated region for block: B:595:0x108a  */
    /* JADX WARNING: Removed duplicated region for block: B:642:0x1224  */
    /* JADX WARNING: Removed duplicated region for block: B:658:0x1288  */
    /* JADX WARNING: Removed duplicated region for block: B:662:0x12bc  */
    /* JADX WARNING: Removed duplicated region for block: B:667:0x12ce  */
    /* JADX WARNING: Removed duplicated region for block: B:668:0x12ee  */
    /* JADX WARNING: Removed duplicated region for block: B:669:0x12f1  */
    /* JADX WARNING: Removed duplicated region for block: B:672:0x12fc  */
    /* JADX WARNING: Removed duplicated region for block: B:702:0x1400  */
    /* JADX WARNING: Removed duplicated region for block: B:705:0x142d  */
    /* JADX WARNING: Removed duplicated region for block: B:716:0x1467  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x024a  */
    private android.view.View a(net.one97.paytm.common.entity.shopping.CJROrderedCart r35, int r36) {
        /*
            r34 = this;
            r11 = r34
            r12 = r35
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionList r14 = new net.one97.paytm.common.entity.shopping.CJROrderSummaryActionList
            r14.<init>()
            java.lang.String r0 = "layout_inflater"
            java.lang.Object r0 = r11.getSystemService(r0)
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            r1 = 0
            r2 = 2131560187(0x7f0d06fb, float:1.874574E38)
            android.view.View r15 = r0.inflate(r2, r1)
            net.one97.paytm.AJROrderSummaryActivityBase$g r0 = new net.one97.paytm.AJROrderSummaryActivityBase$g
            r0.<init>()
            r11.a((net.one97.paytm.AJROrderSummaryActivityBase.g) r0, (android.view.View) r15)
            r15.setTag(r0)
            int r0 = com.paytm.utility.a.t(r34)
            int r2 = r0 / 2
            r10 = 2
            int r0 = r0 * 2
            int r3 = com.paytm.utility.a.a((android.app.Activity) r34)
            int r4 = r2 * 2
            int r4 = r4 + r0
            int r4 = r4 + r2
            int r16 = r3 - r4
            java.lang.Object r0 = r15.getTag()
            r9 = r0
            net.one97.paytm.AJROrderSummaryActivityBase$g r9 = (net.one97.paytm.AJROrderSummaryActivityBase.g) r9
            if (r12 == 0) goto L_0x1482
            boolean r0 = r34.N()
            r8 = 8
            if (r0 == 0) goto L_0x0057
            r0 = 2131368461(0x7f0a1a0d, float:1.8356873E38)
            android.view.View r0 = r11.findViewById(r0)
            r0.setVisibility(r8)
        L_0x0057:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r7 = r35.getProductDetail()
            java.lang.String r6 = "Payment"
            java.lang.String r2 = " "
            java.lang.String r5 = "Marketplace"
            java.lang.String r3 = "Recharge"
            r4 = 3
            r1 = 0
            if (r7 == 0) goto L_0x0397
            java.lang.String r0 = r7.getProductType()
            if (r0 == 0) goto L_0x013e
            java.lang.String r0 = r7.getProductType()
            if (r0 == 0) goto L_0x013e
            java.lang.String r0 = r7.getProductType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x013e
            java.lang.String r0 = r7.getProductType()
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x00a2
            android.widget.LinearLayout r0 = r9.ag
            r0.setVisibility(r8)
            long r18 = r35.getMerchantId()
            r20 = 28
            int r0 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x009b
            android.widget.RelativeLayout r0 = r9.ac
            r0.setVisibility(r1)
        L_0x009b:
            android.widget.RelativeLayout r0 = r9.cy
            r0.setVisibility(r8)
            goto L_0x013e
        L_0x00a2:
            java.lang.String r0 = r7.getProductType()
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x00c3
            boolean r0 = d((net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail) r7)
            if (r0 == 0) goto L_0x00c3
            android.widget.RelativeLayout r0 = r9.ac
            r0.setVisibility(r8)
            android.widget.LinearLayout r0 = r9.ag
            r0.setVisibility(r8)
            android.widget.RelativeLayout r0 = r9.cy
            r0.setVisibility(r1)
            goto L_0x013e
        L_0x00c3:
            java.lang.String r0 = r7.getProductType()
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x00e8
            boolean r0 = e((net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail) r7)
            if (r0 == 0) goto L_0x00e8
            android.widget.RelativeLayout r0 = r9.ac
            r0.setVisibility(r8)
            android.widget.LinearLayout r0 = r9.ag
            r0.setVisibility(r8)
            android.widget.RelativeLayout r0 = r9.cy
            r0.setVisibility(r8)
            android.widget.RelativeLayout r0 = r9.cH
            r0.setVisibility(r1)
            goto L_0x013e
        L_0x00e8:
            android.widget.RelativeLayout r0 = r9.ac
            r0.setVisibility(r8)
            android.widget.LinearLayout r0 = r9.ag
            r0.setVisibility(r1)
            android.widget.RelativeLayout r0 = r9.cy
            r0.setVisibility(r8)
            java.util.ArrayList r0 = r35.getStatusFlow()
            if (r0 == 0) goto L_0x013e
            int r18 = r0.size()
            if (r18 <= 0) goto L_0x013e
            int r1 = r0.size()
            if (r1 != r4) goto L_0x013e
            java.lang.Object r1 = r0.get(r10)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r1 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r1
            java.lang.Boolean r1 = r1.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x013e
            java.lang.Object r1 = r0.get(r10)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r1 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r1
            java.lang.String r1 = r1.getLabel()
            if (r1 == 0) goto L_0x013e
            java.lang.Object r0 = r0.get(r10)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r0
            java.lang.String r0 = r0.getLabel()
            java.lang.String r1 = "Delivered"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x013e
            long r0 = r35.getMerchantId()
            r11.b((long) r0)
        L_0x013e:
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r7.getAttributes()
            if (r0 == 0) goto L_0x0155
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r7.getAttributes()
            java.lang.String r0 = r0.getBbpsLogoUrl()
            if (r0 == 0) goto L_0x0155
            net.one97.paytm.common.entity.recharge.CJRAttributes r0 = r7.getAttributes()
            r0.getBbpsLogoUrl()
        L_0x0155:
            boolean r0 = r34.Q()
            if (r0 == 0) goto L_0x015e
            r11.h(r9, r12)
        L_0x015e:
            boolean r0 = r34.R()
            if (r0 == 0) goto L_0x0167
            r11.a((net.one97.paytm.AJROrderSummaryActivityBase.g) r9, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r12)
        L_0x0167:
            java.lang.String r0 = r11.L
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01a3
            java.lang.String r0 = r11.L
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 == 0) goto L_0x01a3
            net.one97.paytm.j.c.a()
            boolean r0 = net.one97.paytm.j.c.k()
            r11.ae = r0
            boolean r0 = r11.ae
            if (r0 == 0) goto L_0x0194
            android.widget.LinearLayout r0 = r11.ab
            r0.setVisibility(r8)
            r0 = 2131370034(0x7f0a2032, float:1.8360063E38)
            android.view.View r0 = r11.findViewById(r0)
            r0.setVisibility(r8)
            goto L_0x01a3
        L_0x0194:
            r0 = 2131370034(0x7f0a2032, float:1.8360063E38)
            android.view.View r0 = r11.findViewById(r0)
            r0.setVisibility(r8)
            android.widget.LinearLayout r0 = r11.ab
            r0.setVisibility(r8)
        L_0x01a3:
            java.lang.String r0 = r7.getProductType()
            if (r0 == 0) goto L_0x0269
            java.lang.String r0 = r7.getProductType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0269
            java.lang.String r0 = r7.getProductType()
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 != 0) goto L_0x0269
            java.lang.String r0 = r7.getBrandName()
            if (r0 == 0) goto L_0x0261
            java.lang.String r0 = r7.getBrandName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0261
            android.widget.TextView r0 = r9.G
            java.lang.String r1 = r7.getBrandName()
            java.lang.String r1 = r1.toUpperCase()
            r0.setText(r1)
            android.widget.TextView r0 = r9.G
            r1 = 0
            r0.setVisibility(r1)
            boolean r0 = g((net.one97.paytm.common.entity.shopping.CJROrderedCart) r35)     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            if (r0 == 0) goto L_0x0240
            java.util.ArrayList r0 = r35.getStatusFlow()     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            if (r0 == 0) goto L_0x0234
            int r1 = r0.size()     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            if (r1 <= 0) goto L_0x0234
            int r1 = r0.size()     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            if (r1 != r4) goto L_0x0234
            java.lang.Object r1 = r0.get(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r1 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r1     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            java.lang.Boolean r1 = r1.getDisabled()     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            boolean r1 = r1.booleanValue()     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            if (r1 != 0) goto L_0x0240
            java.lang.Object r1 = r0.get(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r1 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r1     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            java.lang.String r1 = r1.getLabel()     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            if (r1 == 0) goto L_0x0240
            java.lang.Object r0 = r0.get(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r0     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            java.lang.String r0 = r0.getLabel()     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            java.lang.String r1 = "Delivered"
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            if (r0 == 0) goto L_0x0240
            long r0 = r35.getId()     // Catch:{ IndexOutOfBoundsException -> 0x0252, Exception -> 0x0243 }
            r19 = r5
            long r4 = r35.getMerchantId()     // Catch:{ IndexOutOfBoundsException -> 0x023e, Exception -> 0x023c }
            r11.a((long) r0, (long) r4)     // Catch:{ IndexOutOfBoundsException -> 0x023e, Exception -> 0x023c }
            goto L_0x0270
        L_0x0234:
            r19 = r5
            android.widget.LinearLayout r0 = r9.bn     // Catch:{ IndexOutOfBoundsException -> 0x023e, Exception -> 0x023c }
            r0.setVisibility(r8)     // Catch:{ IndexOutOfBoundsException -> 0x023e, Exception -> 0x023c }
            goto L_0x0270
        L_0x023c:
            r0 = move-exception
            goto L_0x0246
        L_0x023e:
            r0 = move-exception
            goto L_0x0255
        L_0x0240:
            r19 = r5
            goto L_0x0270
        L_0x0243:
            r0 = move-exception
            r19 = r5
        L_0x0246:
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x0270
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            goto L_0x0270
        L_0x0252:
            r0 = move-exception
            r19 = r5
        L_0x0255:
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x0270
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            goto L_0x0270
        L_0x0261:
            r19 = r5
            android.widget.TextView r0 = r9.G
            r0.setVisibility(r8)
            goto L_0x0270
        L_0x0269:
            r19 = r5
            android.widget.TextView r0 = r9.f51625h
            r0.setVisibility(r8)
        L_0x0270:
            r34.T()
            android.graphics.drawable.ShapeDrawable r0 = new android.graphics.drawable.ShapeDrawable
            r0.<init>()
            android.graphics.Paint r1 = r0.getPaint()
            android.content.res.Resources r4 = r34.getResources()
            r5 = 2131100481(0x7f060341, float:1.7813345E38)
            int r4 = r4.getColor(r5)
            r1.setColor(r4)
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.STROKE
            r1.setStyle(r4)
            r4 = 1065353216(0x3f800000, float:1.0)
            r1.setStrokeWidth(r4)
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 16
            if (r1 < r4) goto L_0x02aa
            android.widget.RelativeLayout r1 = r9.aS
            r1.setBackground(r0)
            android.widget.RelativeLayout r1 = r9.aT
            r1.setBackground(r0)
            android.widget.RelativeLayout r1 = r9.cD
            r1.setBackground(r0)
            goto L_0x02b9
        L_0x02aa:
            android.widget.RelativeLayout r1 = r9.aS
            r1.setBackgroundDrawable(r0)
            android.widget.RelativeLayout r1 = r9.aT
            r1.setBackgroundDrawable(r0)
            android.widget.RelativeLayout r1 = r9.cD
            r1.setBackgroundDrawable(r0)
        L_0x02b9:
            if (r7 == 0) goto L_0x03a3
            java.lang.String r0 = r7.getThumbnail()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03a3
            java.lang.String r0 = r7.getProductType()
            if (r0 == 0) goto L_0x03a3
            java.lang.String r0 = r7.getProductType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03a3
            android.widget.LinearLayout r0 = r9.f51622e
            if (r0 == 0) goto L_0x036c
            android.widget.LinearLayout r0 = r9.f51622e
            r0.setVisibility(r8)
            boolean r0 = e((net.one97.paytm.common.entity.shopping.CJROrderedCart) r35)
            if (r0 == 0) goto L_0x036c
            java.util.Map r0 = r35.getRechargeConfiguration()
            if (r0 == 0) goto L_0x036c
            java.util.Map r0 = r35.getRechargeConfiguration()
            java.lang.String r1 = "targetMobile"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x036c
            android.widget.LinearLayout r0 = r9.f51622e
            r1 = 0
            r0.setVisibility(r1)
            java.util.Map r0 = r35.getRechargeConfiguration()
            java.lang.String r1 = "name"
            boolean r0 = r0.containsKey(r1)
            r4 = 2131365070(0x7f0a0cce, float:1.8349995E38)
            if (r0 == 0) goto L_0x033c
            java.util.Map r0 = r35.getRechargeConfiguration()
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = com.paytm.utility.v.a((java.lang.String) r0)
            if (r0 != 0) goto L_0x033c
            android.widget.LinearLayout r0 = r9.f51622e
            android.view.View r0 = r0.findViewById(r4)
            r5 = 0
            r0.setVisibility(r5)
            android.widget.LinearLayout r0 = r9.f51622e
            android.view.View r0 = r0.findViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.util.Map r4 = r35.getRechargeConfiguration()
            java.lang.Object r1 = r4.get(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x0345
        L_0x033c:
            android.widget.LinearLayout r0 = r9.f51622e
            android.view.View r0 = r0.findViewById(r4)
            r0.setVisibility(r8)
        L_0x0345:
            android.widget.LinearLayout r0 = r9.f51622e
            r1 = 2131365069(0x7f0a0ccd, float:1.8349993E38)
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.Map r4 = r35.getRechargeConfiguration()
            java.lang.String r5 = "targetMobile"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
        L_0x036c:
            if (r36 != 0) goto L_0x037a
            java.lang.String r0 = r7.getThumbnail()
            java.lang.String r1 = "%20"
            java.lang.String r0 = r0.replace(r2, r1)
            r11.bh = r0
        L_0x037a:
            net.one97.paytm.utils.ai r0 = net.one97.paytm.utils.ai.INSTANCE
            com.android.volley.toolbox.ImageLoader r0 = r0.getImageLoader()
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r1 = r35.getProductDetail()
            java.lang.String r1 = r1.getThumbnail()
            java.lang.String r4 = "%20"
            java.lang.String r1 = r1.replace(r2, r4)
            net.one97.paytm.AJROrderSummaryActivityBase$20 r4 = new net.one97.paytm.AJROrderSummaryActivityBase$20
            r4.<init>(r7, r9)
            r0.get(r1, r4)
            goto L_0x03a3
        L_0x0397:
            r19 = r5
            android.widget.RelativeLayout r0 = r9.ac
            r0.setVisibility(r8)
            android.widget.LinearLayout r0 = r9.ag
            r0.setVisibility(r8)
        L_0x03a3:
            r5 = 1
            r11.aX = r5
            android.widget.RelativeLayout r0 = r9.v
            r0.setVisibility(r8)
            java.util.ArrayList r0 = r35.getTapActions()
            java.lang.String r1 = "button"
            if (r0 == 0) goto L_0x04f9
            android.widget.RelativeLayout r4 = r9.v
            r10 = 0
            r4.setVisibility(r10)
            android.widget.LinearLayout r4 = r9.p
            r4.setVisibility(r8)
            android.widget.RelativeLayout r4 = r9.w
            r4.setVisibility(r8)
            java.lang.String r4 = r35.getTapActionMessage()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x03dd
            android.widget.TextView r4 = r9.F
            java.lang.String r10 = r35.getTapActionMessage()
            r4.setText(r10)
            android.widget.TextView r4 = r9.F
            r10 = 0
            r4.setVisibility(r10)
            goto L_0x03e3
        L_0x03dd:
            r10 = 0
            android.widget.TextView r4 = r9.F
            r4.setVisibility(r8)
        L_0x03e3:
            int r4 = r0.size()
            if (r4 <= 0) goto L_0x04f3
            java.lang.Object r18 = r0.get(r10)
            if (r18 == 0) goto L_0x04b2
            java.lang.Object r18 = r0.get(r10)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r18 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r18
            java.lang.String r18 = r18.getUiControl()
            if (r18 == 0) goto L_0x04b2
            java.lang.Object r18 = r0.get(r10)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r18 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r18
            java.lang.String r5 = r18.getUiControl()
            java.lang.String r8 = "radio"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x04b2
            android.widget.RelativeLayout r5 = r9.w
            r5.setVisibility(r10)
            android.widget.RadioButton[] r5 = new android.widget.RadioButton[r4]
            android.widget.Button r8 = r9.B
            r8.setVisibility(r10)
            android.widget.Button r8 = r9.B
            r8.setEnabled(r10)
            android.widget.RadioGroup r8 = r9.D
            r8.setVisibility(r10)
            r8 = 0
        L_0x0424:
            if (r8 >= r4) goto L_0x0498
            java.lang.Object r10 = r0.get(r8)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r10 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r10
            r23 = r4
            android.widget.RadioButton r4 = new android.widget.RadioButton
            r4.<init>(r11)
            r5[r8] = r4
            java.lang.String r4 = r10.getMessage()
            if (r4 == 0) goto L_0x044b
            r4 = r5[r8]
            java.lang.String r24 = r10.getMessage()
            r25 = r15
            android.text.Spanned r15 = android.text.Html.fromHtml(r24)
            r4.setText(r15)
            goto L_0x044d
        L_0x044b:
            r25 = r15
        L_0x044d:
            java.lang.String r4 = r10.getLabel()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x047a
            r4 = r5[r8]
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r24 = r2
            java.lang.String r2 = "<br/><font color='#999999' size='2'>"
            r15.<init>(r2)
            java.lang.String r2 = r10.getLabel()
            r15.append(r2)
            java.lang.String r2 = "</font>"
            r15.append(r2)
            java.lang.String r2 = r15.toString()
            android.text.Spanned r2 = android.text.Html.fromHtml(r2)
            r4.append(r2)
            goto L_0x047c
        L_0x047a:
            r24 = r2
        L_0x047c:
            r2 = r5[r8]
            r4 = 1096810496(0x41600000, float:14.0)
            r2.setTextSize(r4)
            r2 = r5[r8]
            com.paytm.utility.b.a((android.widget.TextView) r2)
            android.widget.RadioGroup r2 = r9.D
            r4 = r5[r8]
            r2.addView(r4)
            int r8 = r8 + 1
            r4 = r23
            r2 = r24
            r15 = r25
            goto L_0x0424
        L_0x0498:
            r24 = r2
            r25 = r15
            android.widget.RadioGroup r2 = r9.D
            net.one97.paytm.AJROrderSummaryActivityBase$21 r4 = new net.one97.paytm.AJROrderSummaryActivityBase$21
            r4.<init>(r9)
            r2.setOnCheckedChangeListener(r4)
            android.widget.Button r2 = r9.B
            net.one97.paytm.AJROrderSummaryActivityBase$23 r4 = new net.one97.paytm.AJROrderSummaryActivityBase$23
            r4.<init>(r0, r5)
            r2.setOnClickListener(r4)
            goto L_0x05bd
        L_0x04b2:
            r24 = r2
            r25 = r15
            r2 = 0
            java.lang.Object r4 = r0.get(r2)
            if (r4 == 0) goto L_0x05bd
            java.lang.Object r4 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r4 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r4
            java.lang.String r4 = r4.getUiControl()
            if (r4 == 0) goto L_0x05bd
            java.lang.Object r4 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r4 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r4
            java.lang.String r2 = r4.getUiControl()
            boolean r2 = r2.equalsIgnoreCase(r1)
            if (r2 == 0) goto L_0x05bd
            int r2 = r0.size()
            r4 = 0
        L_0x04de:
            if (r4 >= r2) goto L_0x05bd
            java.lang.Object r5 = r0.get(r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r5 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r5
            java.lang.String r5 = r5.getLabel()
            r13.add(r5)
            r14.setAction(r0)
            int r4 = r4 + 1
            goto L_0x04de
        L_0x04f3:
            r24 = r2
            r25 = r15
            goto L_0x05bd
        L_0x04f9:
            r24 = r2
            r25 = r15
            if (r12 == 0) goto L_0x0535
            java.lang.String r0 = r35.getTapActionMessage()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0535
            android.widget.RelativeLayout r0 = r9.v
            r2 = 0
            r0.setVisibility(r2)
            android.widget.LinearLayout r0 = r9.p
            r4 = 8
            r0.setVisibility(r4)
            android.widget.RelativeLayout r0 = r9.w
            r0.setVisibility(r2)
            android.widget.TextView r0 = r9.F
            java.lang.String r5 = r35.getTapActionMessage()
            r0.setText(r5)
            android.widget.TextView r0 = r9.F
            r0.setVisibility(r2)
            android.widget.Button r0 = r9.B
            r0.setVisibility(r4)
            android.widget.RadioGroup r0 = r9.D
            r0.setVisibility(r4)
            goto L_0x05bd
        L_0x0535:
            r4 = 8
            android.widget.RelativeLayout r0 = r9.v
            r0.setVisibility(r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r0 = r35.getTapAction()
            if (r0 == 0) goto L_0x05bd
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r2 = r0.getUrlParams()
            if (r2 == 0) goto L_0x05bd
            java.lang.String r2 = r11.L
            if (r2 == 0) goto L_0x058e
            java.lang.String r4 = "Order_history"
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 != 0) goto L_0x056a
            java.lang.String r2 = r11.L
            java.lang.String r4 = "Deep Linking"
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 != 0) goto L_0x056a
            java.lang.String r2 = r11.L
            boolean r2 = r2.equalsIgnoreCase(r6)
            if (r2 == 0) goto L_0x058e
            boolean r2 = r11.P
            if (r2 != 0) goto L_0x058e
        L_0x056a:
            boolean r2 = f((net.one97.paytm.common.entity.shopping.CJROrderedCart) r35)
            if (r2 == 0) goto L_0x058e
            java.lang.String r2 = r0.getLabel()
            if (r2 == 0) goto L_0x058e
            int r2 = r11.aV
            if (r2 <= 0) goto L_0x057d
            r2 = 0
            r5 = 1
            goto L_0x0590
        L_0x057d:
            r5 = 1
            int r2 = r2 + r5
            r11.aV = r2
            int r2 = r11.aV
            r12.setVersion(r2)
            java.lang.String r2 = r0.getLabel()
            r12.setTapActionLabel(r2)
            goto L_0x058f
        L_0x058e:
            r5 = 1
        L_0x058f:
            r2 = 1
        L_0x0590:
            if (r2 == 0) goto L_0x05be
            r2 = 0
            r11.aX = r2
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r2 = r0.getUrlParams()
            if (r2 == 0) goto L_0x05b9
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r2 = r0.getUrlParams()
            java.lang.String r2 = r2.getMethod()
            if (r2 == 0) goto L_0x05b9
            net.one97.paytm.common.entity.shopping.CJROrderSummaryActionURLParams r0 = r0.getUrlParams()
            java.lang.String r0 = r0.getMethod()
            java.lang.String r2 = "POST"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x05b9
            r34.d((net.one97.paytm.common.entity.shopping.CJROrderedCart) r35)
            goto L_0x05be
        L_0x05b9:
            r34.c((net.one97.paytm.common.entity.shopping.CJROrderedCart) r35)
            goto L_0x05be
        L_0x05bd:
            r5 = 1
        L_0x05be:
            boolean r0 = r35.getIsRepeat()
            if (r0 != 0) goto L_0x05d3
            boolean r0 = r35.getIsRetry()
            if (r0 == 0) goto L_0x05cb
            goto L_0x05d3
        L_0x05cb:
            android.widget.RelativeLayout r0 = r9.u
            r2 = 8
            r0.setVisibility(r2)
            goto L_0x05d9
        L_0x05d3:
            android.widget.RelativeLayout r0 = r9.u
            r2 = 0
            r0.setVisibility(r2)
        L_0x05d9:
            boolean r0 = r34.R()
            if (r0 == 0) goto L_0x05e1
            r2 = 0
            goto L_0x05e6
        L_0x05e1:
            java.util.ArrayList r0 = r35.getAction()
            r2 = r0
        L_0x05e6:
            if (r2 == 0) goto L_0x065f
            int r0 = r2.size()     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            if (r0 <= 0) goto L_0x065f
            r4 = 0
        L_0x05ef:
            if (r4 >= r0) goto L_0x065f
            java.lang.Object r8 = r2.get(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            if (r8 == 0) goto L_0x0650
            java.lang.Object r8 = r2.get(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r8 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r8     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            java.lang.String r8 = r8.getUiControl()     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            if (r8 != 0) goto L_0x0650
            java.lang.Object r8 = r2.get(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r8 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r8     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            java.lang.String r8 = r8.getActionName()     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            if (r8 != 0) goto L_0x0650
            java.lang.Object r8 = r2.get(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r8 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r8     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            java.lang.String r8 = r8.getUiControl()     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            boolean r8 = r8.equalsIgnoreCase(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            if (r8 == 0) goto L_0x0650
            java.lang.Object r8 = r2.get(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r8 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r8     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            java.lang.String r8 = r8.getActionName()     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            java.lang.String r10 = "Invoice"
            boolean r8 = r8.equalsIgnoreCase(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            if (r8 != 0) goto L_0x064b
            java.lang.Object r8 = r2.get(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r8 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r8     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            java.lang.String r8 = r8.getActionName()     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            java.lang.String r10 = "Tickets"
            boolean r8 = r8.equalsIgnoreCase(r10)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
            if (r8 == 0) goto L_0x0650
        L_0x064b:
            int r8 = r0 + -1
            java.util.Collections.swap(r2, r4, r8)     // Catch:{ IndexOutOfBoundsException -> 0x0653 }
        L_0x0650:
            int r4 = r4 + 1
            goto L_0x05ef
        L_0x0653:
            r0 = move-exception
            boolean r4 = com.paytm.utility.b.v
            if (r4 == 0) goto L_0x065f
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x065f:
            java.lang.String r0 = r35.getMessage()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x067b
            android.widget.TextView r0 = r9.E
            r4 = 0
            r0.setVisibility(r4)
            android.widget.TextView r0 = r9.E
            java.lang.String r8 = r35.getMessage()
            r0.setText(r8)
            r8 = 8
            goto L_0x0683
        L_0x067b:
            r4 = 0
            android.widget.TextView r0 = r9.E
            r8 = 8
            r0.setVisibility(r8)
        L_0x0683:
            if (r2 == 0) goto L_0x0844
            android.widget.RelativeLayout r0 = r9.u
            r0.setVisibility(r4)
            boolean r0 = r35.getIsRepeat()
            if (r0 != 0) goto L_0x069d
            boolean r0 = r35.getIsRetry()
            if (r0 == 0) goto L_0x0697
            goto L_0x069d
        L_0x0697:
            android.widget.LinearLayout r0 = r9.o
            r0.setVisibility(r8)
            goto L_0x06a2
        L_0x069d:
            android.widget.LinearLayout r0 = r9.o
            r0.setVisibility(r4)
        L_0x06a2:
            android.widget.RelativeLayout r0 = r9.t
            r0.setVisibility(r8)
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x0870
            java.lang.Object r8 = r2.get(r4)
            if (r8 == 0) goto L_0x0760
            java.lang.Object r8 = r2.get(r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r8 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r8
            java.lang.String r8 = r8.getUiControl()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0760
            java.lang.Object r8 = r2.get(r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r8 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r8
            java.lang.String r8 = r8.getUiControl()
            java.lang.String r10 = "radio"
            boolean r8 = r8.equalsIgnoreCase(r10)
            if (r8 == 0) goto L_0x0760
            android.widget.RelativeLayout r1 = r9.t
            r1.setVisibility(r4)
            android.widget.RadioButton[] r1 = new android.widget.RadioButton[r0]
            android.widget.Button r8 = r9.A
            r8.setVisibility(r4)
            android.widget.Button r8 = r9.A
            r8.setEnabled(r4)
            r4 = 0
        L_0x06e7:
            if (r4 >= r0) goto L_0x074a
            java.lang.Object r8 = r2.get(r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r8 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r8
            android.widget.RadioButton r10 = new android.widget.RadioButton
            r10.<init>(r11)
            r1[r4] = r10
            java.lang.String r10 = r8.getMessage()
            if (r10 == 0) goto L_0x0709
            r10 = r1[r4]
            java.lang.String r15 = r8.getMessage()
            android.text.Spanned r15 = android.text.Html.fromHtml(r15)
            r10.setText(r15)
        L_0x0709:
            java.lang.String r10 = r8.getLabel()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0733
            r10 = r1[r4]
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r5 = "<br/><font color='#999999' size='2'>"
            r15.<init>(r5)
            java.lang.String r5 = r8.getLabel()
            r15.append(r5)
            java.lang.String r5 = "</font>"
            r15.append(r5)
            java.lang.String r5 = r15.toString()
            android.text.Spanned r5 = android.text.Html.fromHtml(r5)
            r10.append(r5)
        L_0x0733:
            r5 = r1[r4]
            r8 = 1096810496(0x41600000, float:14.0)
            r5.setTextSize(r8)
            r5 = r1[r4]
            com.paytm.utility.b.a((android.widget.TextView) r5)
            android.widget.RadioGroup r5 = r9.C
            r8 = r1[r4]
            r5.addView(r8)
            int r4 = r4 + 1
            r5 = 1
            goto L_0x06e7
        L_0x074a:
            android.widget.RadioGroup r0 = r9.C
            net.one97.paytm.AJROrderSummaryActivityBase$24 r4 = new net.one97.paytm.AJROrderSummaryActivityBase$24
            r4.<init>(r9)
            r0.setOnCheckedChangeListener(r4)
            android.widget.Button r0 = r9.A
            net.one97.paytm.AJROrderSummaryActivityBase$25 r4 = new net.one97.paytm.AJROrderSummaryActivityBase$25
            r4.<init>(r2, r1)
            r0.setOnClickListener(r4)
            goto L_0x0870
        L_0x0760:
            java.lang.Object r0 = r2.get(r4)
            if (r0 == 0) goto L_0x0870
            java.lang.Object r0 = r2.get(r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r0
            java.lang.String r0 = r0.getUiControl()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0870
            java.lang.Object r0 = r2.get(r4)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r0 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r0
            java.lang.String r0 = r0.getUiControl()
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x0870
            int r4 = r2.size()
            if (r4 <= 0) goto L_0x07cb
            r0 = 0
        L_0x078d:
            if (r0 >= r4) goto L_0x07cb
            java.lang.Object r5 = r2.get(r0)     // Catch:{ IndexOutOfBoundsException -> 0x07bf }
            if (r5 == 0) goto L_0x07bc
            java.lang.Object r5 = r2.get(r0)     // Catch:{ IndexOutOfBoundsException -> 0x07bf }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r5 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r5     // Catch:{ IndexOutOfBoundsException -> 0x07bf }
            java.lang.String r5 = r5.getUiControl()     // Catch:{ IndexOutOfBoundsException -> 0x07bf }
            boolean r5 = r5.equalsIgnoreCase(r1)     // Catch:{ IndexOutOfBoundsException -> 0x07bf }
            if (r5 == 0) goto L_0x07bc
            java.lang.Object r5 = r2.get(r0)     // Catch:{ IndexOutOfBoundsException -> 0x07bf }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r5 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r5     // Catch:{ IndexOutOfBoundsException -> 0x07bf }
            java.lang.String r5 = r5.getActionName()     // Catch:{ IndexOutOfBoundsException -> 0x07bf }
            java.lang.String r8 = "Invoice"
            boolean r5 = r5.equalsIgnoreCase(r8)     // Catch:{ IndexOutOfBoundsException -> 0x07bf }
            if (r5 == 0) goto L_0x07bc
            int r5 = r4 + -1
            java.util.Collections.swap(r2, r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x07bf }
        L_0x07bc:
            int r0 = r0 + 1
            goto L_0x078d
        L_0x07bf:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x07cb
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x07cb:
            int r0 = r13.size()
            r1 = 0
        L_0x07d0:
            if (r1 >= r4) goto L_0x0870
            java.lang.Object r5 = r2.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r5 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r5
            java.lang.String r5 = r5.getLabel()
            boolean r8 = r34.P()
            if (r8 == 0) goto L_0x07f6
            boolean r8 = android.text.TextUtils.isEmpty(r5)
            if (r8 != 0) goto L_0x07f6
            java.lang.String r8 = "Invoice"
            boolean r5 = r5.equalsIgnoreCase(r8)
            if (r5 == 0) goto L_0x07f6
            java.lang.String r5 = "Download Ticket"
            r13.add(r5)
            goto L_0x0836
        L_0x07f6:
            boolean r5 = r34.P()
            if (r5 == 0) goto L_0x0829
            java.lang.Object r5 = r2.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r5 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r5
            java.lang.String r5 = r5.getLabel()
            java.lang.String r8 = "Download Tickets"
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x0829
            r5 = 0
        L_0x080f:
            int r8 = r13.size()
            if (r5 >= r8) goto L_0x0829
            java.lang.Object r8 = r13.get(r5)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r10 = "Download Ticket"
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L_0x0826
            r13.remove(r5)
        L_0x0826:
            int r5 = r5 + 1
            goto L_0x080f
        L_0x0829:
            java.lang.Object r5 = r2.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r5 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r5
            java.lang.String r5 = r5.getLabel()
            r13.add(r5)
        L_0x0836:
            java.lang.Object r5 = r2.get(r1)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r5 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r5
            int r8 = r0 + r1
            r14.setAction(r5, r8)
            int r1 = r1 + 1
            goto L_0x07d0
        L_0x0844:
            boolean r0 = r35.getIsRepeat()
            if (r0 != 0) goto L_0x085e
            boolean r0 = r35.getIsRetry()
            if (r0 == 0) goto L_0x0851
            goto L_0x085e
        L_0x0851:
            android.widget.LinearLayout r0 = r9.o
            r1 = 8
            r0.setVisibility(r1)
            android.widget.RelativeLayout r0 = r9.u
            r0.setVisibility(r1)
            goto L_0x086b
        L_0x085e:
            r1 = 8
            android.widget.LinearLayout r0 = r9.o
            r2 = 0
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r9.u
            r0.setVisibility(r2)
        L_0x086b:
            android.widget.RelativeLayout r0 = r9.t
            r0.setVisibility(r1)
        L_0x0870:
            java.lang.String r0 = r35.getName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x08a2
            java.lang.String r0 = r7.getProductType()
            if (r0 == 0) goto L_0x08a2
            java.lang.String r0 = r7.getProductType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x08a2
            java.lang.String r0 = r7.getProductType()
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x08a2
            android.widget.TextView r0 = r9.Y
            java.lang.String r1 = r35.getName()
            java.lang.String r1 = r1.trim()
            r0.setText(r1)
            goto L_0x08ab
        L_0x08a2:
            android.widget.TextView r0 = r9.W
            java.lang.String r1 = r35.getName()
            r0.setText(r1)
        L_0x08ab:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r15 = r35.getProductDetail()
            java.lang.String r10 = ""
            if (r7 == 0) goto L_0x0a7c
            java.lang.String r0 = r7.getProductType()
            if (r0 == 0) goto L_0x0a7c
            java.lang.String r0 = r7.getProductType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0a7c
            java.lang.String r0 = r7.getProductType()
            r5 = r19
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x0a7e
            int r0 = r35.getQuantity()
            if (r0 <= 0) goto L_0x0bf0
            r11.f(r9, r12)
            r11.g(r9, r12)
            r11.d((net.one97.paytm.AJROrderSummaryActivityBase.g) r9, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r12)
            android.widget.LinearLayout r0 = r9.J
            r1 = 0
            r0.setVisibility(r1)
            java.lang.String r0 = r35.getAggregateItemPrice()
            if (r0 == 0) goto L_0x091e
            android.widget.TextView r0 = r9.I
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.res.Resources r2 = r34.getResources()
            r3 = 2131962658(0x7f132b22, float:1.9562047E38)
            java.lang.String r2 = r2.getString(r3)
            r1.append(r2)
            r2 = r24
            r1.append(r2)
            java.lang.String r2 = r35.getAggregateItemPrice()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r2 = com.paytm.utility.b.x((java.lang.String) r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            r0.setText(r1)
        L_0x091e:
            android.widget.TextView r0 = r9.f51623f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r35.getQuantity()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            r0.setText(r1)
            if (r12 == 0) goto L_0x0961
            net.one97.paytm.common.entity.shopping.CJRAttribute r0 = r35.getAttributes()
            if (r0 == 0) goto L_0x0961
            net.one97.paytm.common.entity.shopping.CJRAttribute r0 = r35.getAttributes()
            java.lang.String r0 = r0.getSize()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0961
            android.widget.LinearLayout r0 = r9.q
            r1 = 0
            r0.setVisibility(r1)
            android.widget.TextView r0 = r9.n
            net.one97.paytm.common.entity.shopping.CJRAttribute r1 = r35.getAttributes()
            java.lang.String r1 = r1.getSize()
            r0.setText(r1)
            goto L_0x0968
        L_0x0961:
            android.widget.LinearLayout r0 = r9.q
            r1 = 8
            r0.setVisibility(r1)
        L_0x0968:
            r11.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r12, (net.one97.paytm.AJROrderSummaryActivityBase.g) r9)
            android.widget.TextView r0 = r9.U
            net.one97.paytm.AJROrderSummaryActivityBase$26 r1 = new net.one97.paytm.AJROrderSummaryActivityBase$26
            r1.<init>(r12)
            r0.setOnClickListener(r1)
            java.lang.String r0 = r35.getStatusText()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x09c7
            java.util.ArrayList r0 = r35.getStatusFlow()
            java.lang.String r1 = r35.getStatusText()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x09bf
            if (r0 == 0) goto L_0x09bf
            boolean r0 = e((net.one97.paytm.common.entity.shopping.CJROrderedCart) r35)
            if (r0 != 0) goto L_0x09bf
            java.lang.String r0 = r34.i((net.one97.paytm.common.entity.shopping.CJROrderedCart) r35)
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
            r1.<init>()
            r1.append(r0)
            android.text.style.RelativeSizeSpan r2 = new android.text.style.RelativeSizeSpan
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.<init>(r3)
            int r3 = r1.length()
            int r0 = r0.length()
            int r3 = r3 - r0
            int r0 = r1.length()
            r4 = 0
            r1.setSpan(r2, r3, r0, r4)
            android.widget.TextView r0 = r9.V
            r0.setText(r1)
            goto L_0x09ce
        L_0x09bf:
            android.widget.RelativeLayout r0 = r9.ah
            r1 = 8
            r0.setVisibility(r1)
            goto L_0x09ce
        L_0x09c7:
            r1 = 8
            android.widget.TextView r0 = r9.V
            r0.setVisibility(r1)
        L_0x09ce:
            android.widget.TextView r1 = r9.m
            android.widget.TextView r0 = r9.S
            android.widget.TextView r2 = r9.al
            if (r12 == 0) goto L_0x09eb
            boolean r3 = r35.hasReplacement()
            if (r3 == 0) goto L_0x09eb
            java.lang.String r3 = r35.getStatusText()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x09eb
            java.lang.String r3 = r35.getStatusText()
            goto L_0x09ec
        L_0x09eb:
            r3 = r10
        L_0x09ec:
            android.widget.RelativeLayout r4 = r9.ad
            r8 = 8
            r4.setVisibility(r8)
            boolean r4 = e((net.one97.paytm.common.entity.shopping.CJROrderedCart) r35)
            if (r4 != 0) goto L_0x0a00
            android.widget.RelativeLayout r4 = r9.ah
            r8 = 0
            r4.setVisibility(r8)
            goto L_0x0a01
        L_0x0a00:
            r8 = 0
        L_0x0a01:
            boolean r4 = r11.P
            if (r4 == 0) goto L_0x0a10
            android.widget.ProgressBar r4 = r9.M
            r4.setVisibility(r8)
            android.widget.ProgressBar r4 = r9.R
            r4.setVisibility(r8)
            goto L_0x0a1c
        L_0x0a10:
            android.widget.ProgressBar r4 = r9.M
            r8 = 8
            r4.setVisibility(r8)
            android.widget.ProgressBar r4 = r9.R
            r4.setVisibility(r8)
        L_0x0a1c:
            boolean r4 = r35.hasReplacement()
            if (r4 == 0) goto L_0x0a6f
            long r23 = r35.getChildOrderId()
            r26 = 0
            int r4 = (r23 > r26 ? 1 : (r23 == r26 ? 0 : -1))
            if (r4 <= 0) goto L_0x0a6f
            int r4 = r13.size()
            if (r4 <= 0) goto L_0x0a39
            java.lang.String r4 = "View replacement order"
            r8 = 0
            r13.set(r8, r4)
            goto L_0x0a3e
        L_0x0a39:
            java.lang.String r4 = "View replacement order"
            r13.add(r4)
        L_0x0a3e:
            net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r4 = new net.one97.paytm.common.entity.shopping.CJROrderSummaryAction
            r4.<init>()
            java.lang.String r8 = "replacement_order_button"
            r4.setActionName(r8)
            java.lang.String r8 = "replacement_order_button"
            r4.setLabel(r8)
            java.util.ArrayList r8 = r14.getAction()
            if (r8 == 0) goto L_0x0a68
            java.util.ArrayList r8 = r14.getAction()
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x0a68
            java.util.ArrayList r8 = r14.getAction()
            r17 = r1
            r1 = 0
            r8.set(r1, r4)
            goto L_0x0a71
        L_0x0a68:
            r17 = r1
            r1 = 0
            r14.setAction(r4, r1)
            goto L_0x0a71
        L_0x0a6f:
            r17 = r1
        L_0x0a71:
            r8 = r3
            r19 = r5
            r23 = r6
            r6 = r17
            r5 = r0
            r0 = r2
            goto L_0x0bf9
        L_0x0a7c:
            r5 = r19
        L_0x0a7e:
            r2 = r24
            if (r7 == 0) goto L_0x0bf0
            java.lang.String r0 = r7.getProductType()
            if (r0 == 0) goto L_0x0bf0
            java.lang.String r0 = r7.getProductType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0bf0
            java.lang.String r0 = r7.getProductType()
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x0bf0
            android.widget.LinearLayout r0 = r9.J
            r1 = 8
            r0.setVisibility(r1)
            double r0 = r35.getTotalPrice()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            double r0 = java.lang.Double.parseDouble(r0)
            java.lang.String r3 = r35.getConvFee()
            double r3 = java.lang.Double.parseDouble(r3)
            r23 = 0
            int r8 = (r3 > r23 ? 1 : (r3 == r23 ? 0 : -1))
            if (r8 <= 0) goto L_0x0ad6
            android.widget.TextView r8 = r9.f51624g
            r19 = r5
            r5 = 2131234305(0x7f080e01, float:1.8084772E38)
            r23 = r6
            r6 = 0
            r8.setCompoundDrawablesWithIntrinsicBounds(r6, r6, r5, r6)
            double r0 = r0 + r3
            android.widget.TextView r3 = r9.f51624g
            net.one97.paytm.AJROrderSummaryActivityBase$27 r4 = new net.one97.paytm.AJROrderSummaryActivityBase$27
            r4.<init>(r12)
            r3.setOnClickListener(r4)
            goto L_0x0ae0
        L_0x0ad6:
            r19 = r5
            r23 = r6
            r6 = 0
            android.widget.TextView r3 = r9.f51624g
            r3.setCompoundDrawablesWithIntrinsicBounds(r6, r6, r6, r6)
        L_0x0ae0:
            android.widget.TextView r3 = r9.f51624g
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.res.Resources r5 = r34.getResources()
            r6 = 2131962658(0x7f132b22, float:1.9562047E38)
            java.lang.String r5 = r5.getString(r6)
            r4.append(r5)
            r4.append(r2)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = com.paytm.utility.b.x((java.lang.String) r0)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r3.setText(r0)
            java.lang.String r0 = r35.getStatusText()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0b5c
            net.one97.paytm.recharge.ordersummary.widget.b$a r0 = net.one97.paytm.recharge.ordersummary.widget.b.f64553e
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            boolean r0 = net.one97.paytm.recharge.ordersummary.widget.b.a.a(r0)
            if (r0 == 0) goto L_0x0b47
            net.one97.paytm.recharge.ordersummary.widget.b$a r0 = net.one97.paytm.recharge.ordersummary.widget.b.f64553e
            net.one97.paytm.common.entity.shopping.CJROrderSummary r0 = r11.J
            boolean r0 = net.one97.paytm.recharge.ordersummary.widget.b.a.b(r0)
            if (r0 == 0) goto L_0x0b3d
            android.widget.TextView r0 = r9.H
            android.content.res.Resources r1 = r34.getResources()
            r2 = 2131956283(0x7f13123b, float:1.9549117E38)
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            goto L_0x0b50
        L_0x0b3d:
            android.widget.TextView r0 = r9.H
            java.lang.String r1 = r35.getStatusText()
            r0.setText(r1)
            goto L_0x0b50
        L_0x0b47:
            android.widget.TextView r0 = r9.H
            java.lang.String r1 = r35.getStatusText()
            r0.setText(r1)
        L_0x0b50:
            java.lang.String r0 = r35.getStatusText()
            android.widget.TextView r1 = r9.H
            r11.a((java.lang.String) r0, (android.widget.TextView) r1, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r12)
            r1 = 8
            goto L_0x0b63
        L_0x0b5c:
            android.widget.TextView r0 = r9.H
            r1 = 8
            r0.setVisibility(r1)
        L_0x0b63:
            android.widget.TextView r0 = r9.ak
            android.widget.TextView r2 = r9.Z
            android.widget.TextView r3 = r9.T
            android.widget.TextView r4 = r9.Z
            r4.setVisibility(r1)
            android.widget.RelativeLayout r4 = r9.ad
            r5 = 0
            r4.setVisibility(r5)
            android.widget.RelativeLayout r4 = r9.ah
            r4.setVisibility(r1)
            boolean r4 = r11.P
            if (r4 == 0) goto L_0x0b83
            android.widget.ProgressBar r4 = r9.L
            r4.setVisibility(r5)
            goto L_0x0b88
        L_0x0b83:
            android.widget.ProgressBar r4 = r9.L
            r4.setVisibility(r1)
        L_0x0b88:
            java.util.Map r1 = r35.getRechargeConfiguration()
            if (r1 == 0) goto L_0x0be2
            java.util.Set r4 = r1.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0b96:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0be2
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "recharge_number"
            boolean r6 = r5.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0bc6
            java.lang.String r6 = "recharge_number"
            java.lang.Object r6 = r1.get(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0bc6
            r11.bj = r12
            java.lang.String r6 = "recharge_number"
            java.lang.Object r6 = r1.get(r6)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r11.bi = r6
        L_0x0bc6:
            java.lang.String r6 = "price"
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L_0x0b96
            java.lang.String r5 = "price"
            java.lang.Object r5 = r1.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0b96
            java.lang.String r5 = "price"
            r1.get(r5)
            goto L_0x0b96
        L_0x0be2:
            r1 = 0
            r12.setFavouriteLabelId(r1)
            android.widget.RelativeLayout r1 = r9.aV
            r4 = 8
            r1.setVisibility(r4)
            r6 = r2
            r5 = r3
            goto L_0x0bf8
        L_0x0bf0:
            r19 = r5
            r23 = r6
            r1 = 0
            r0 = r1
            r5 = r0
            r6 = r5
        L_0x0bf8:
            r8 = r10
        L_0x0bf9:
            net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription r1 = r35.getSubscription()
            if (r1 == 0) goto L_0x0cee
            boolean r1 = r1.getIsAvailable()
            if (r1 == 0) goto L_0x0cee
            java.lang.String r1 = r7.getVertical()
            if (r1 == 0) goto L_0x0cd6
            java.lang.String r1 = r7.getVertical()
            android.content.res.Resources r2 = r34.getResources()
            r3 = 2131955512(0x7f130f38, float:1.9547554E38)
            java.lang.String r2 = r2.getString(r3)
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x0c61
            android.widget.RelativeLayout r1 = r9.aZ
            r2 = 0
            r1.setVisibility(r2)
            android.widget.ImageView r1 = r9.bc
            r2 = 8
            r1.setVisibility(r2)
            android.widget.TextView r1 = r9.bi
            android.content.res.Resources r2 = r34.getResources()
            r3 = 2131952435(0x7f130333, float:1.9541313E38)
            java.lang.String r2 = r2.getString(r3)
            r1.setText(r2)
            android.widget.TextView r1 = r9.bj
            android.content.res.Resources r2 = r34.getResources()
            r3 = 2131952424(0x7f130328, float:1.954129E38)
            java.lang.String r2 = r2.getString(r3)
            r1.setText(r2)
            android.widget.TextView r1 = r9.bk
            android.content.res.Resources r2 = r34.getResources()
            r3 = 2131952432(0x7f130330, float:1.9541307E38)
            java.lang.String r2 = r2.getString(r3)
            r1.setText(r2)
            r2 = 0
            r17 = 1
            goto L_0x0cb7
        L_0x0c61:
            java.lang.String r1 = r7.getVertical()
            android.content.res.Resources r2 = r34.getResources()
            r3 = 2131955514(0x7f130f3a, float:1.9547558E38)
            java.lang.String r2 = r2.getString(r3)
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x0cb4
            android.widget.RelativeLayout r1 = r9.aZ
            r2 = 0
            r1.setVisibility(r2)
            android.widget.ImageView r1 = r9.bc
            r3 = 8
            r1.setVisibility(r3)
            android.widget.TextView r1 = r9.bi
            android.content.res.Resources r3 = r34.getResources()
            r4 = 2131952436(0x7f130334, float:1.9541315E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r9.bj
            android.content.res.Resources r3 = r34.getResources()
            r4 = 2131952425(0x7f130329, float:1.9541292E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r9.bk
            android.content.res.Resources r3 = r34.getResources()
            r4 = 2131952433(0x7f130331, float:1.9541309E38)
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            goto L_0x0cb5
        L_0x0cb4:
            r2 = 0
        L_0x0cb5:
            r17 = 0
        L_0x0cb7:
            android.widget.Button r3 = r9.bg
            android.widget.Button r4 = r9.bf
            android.widget.TextView r1 = r9.bh
            r18 = r1
            r1 = r34
            r24 = r14
            r14 = 0
            r2 = r35
            r29 = r5
            r30 = r19
            r5 = r18
            r31 = r6
            r32 = r23
            r6 = r17
            r1.a((net.one97.paytm.common.entity.shopping.CJROrderedCart) r2, (android.widget.Button) r3, (android.widget.Button) r4, (android.widget.TextView) r5, (boolean) r6)
            goto L_0x0cf9
        L_0x0cd6:
            r29 = r5
            r31 = r6
            r24 = r14
            r30 = r19
            r32 = r23
            r14 = 0
            android.widget.RelativeLayout r1 = r9.aZ
            r2 = 8
            r1.setVisibility(r2)
            android.widget.ImageView r1 = r9.bc
            r1.setVisibility(r2)
            goto L_0x0cf9
        L_0x0cee:
            r29 = r5
            r31 = r6
            r24 = r14
            r30 = r19
            r32 = r23
            r14 = 0
        L_0x0cf9:
            if (r0 == 0) goto L_0x0d19
            if (r12 == 0) goto L_0x0d14
            java.lang.String r1 = r35.getStatus()     // Catch:{ Exception -> 0x0d4b }
            if (r1 == 0) goto L_0x0d14
            java.lang.String r1 = r35.getStatus()     // Catch:{ Exception -> 0x0d4b }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0d4b }
            if (r1 != 0) goto L_0x0d14
            r0.setVisibility(r14)     // Catch:{ Exception -> 0x0d4b }
            r11.a((android.widget.TextView) r0, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r12, (java.lang.String) r8)     // Catch:{ Exception -> 0x0d4b }
            goto L_0x0d19
        L_0x0d14:
            r1 = 8
            r0.setVisibility(r1)     // Catch:{ Exception -> 0x0d4b }
        L_0x0d19:
            java.lang.CharSequence r0 = r0.getText()     // Catch:{ Exception -> 0x0d4b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0d4b }
            android.widget.TextView r1 = r9.f51624g     // Catch:{ Exception -> 0x0d4b }
            java.lang.CharSequence r1 = r1.getText()     // Catch:{ Exception -> 0x0d4b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0d4b }
            android.widget.TextView r2 = r9.Y     // Catch:{ Exception -> 0x0d4b }
            a((java.lang.String) r0, (java.lang.String) r1, (android.widget.TextView) r2)     // Catch:{ Exception -> 0x0d4b }
            r1 = r31
            if (r1 == 0) goto L_0x0d37
            r11.a((net.one97.paytm.AJROrderSummaryActivityBase.g) r9, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r12, (android.widget.TextView) r1)     // Catch:{ Exception -> 0x0d4b }
        L_0x0d37:
            if (r7 == 0) goto L_0x0d3e
            java.lang.String r0 = r7.getProductType()     // Catch:{ Exception -> 0x0d4b }
            goto L_0x0d3f
        L_0x0d3e:
            r0 = r10
        L_0x0d3f:
            if (r0 == 0) goto L_0x0d57
            r3 = r29
            if (r3 == 0) goto L_0x0d57
            if (r1 == 0) goto L_0x0d57
            r11.a((android.widget.TextView) r1, (android.widget.TextView) r3, (java.lang.String) r0, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r12)     // Catch:{ Exception -> 0x0d4b }
            goto L_0x0d57
        L_0x0d4b:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x0d57
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0d57:
            if (r7 == 0) goto L_0x1400
            java.lang.String r0 = r7.getProductType()
            if (r0 == 0) goto L_0x13e3
            java.lang.String r0 = r7.getProductType()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x13e3
            java.lang.String r0 = r7.getProductType()
            r1 = r30
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x13e3
            java.lang.String r0 = r11.L
            r1 = r32
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L_0x13e3
            java.util.ArrayList r0 = r35.getStatusFlow()
            if (r0 == 0) goto L_0x13cf
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x13cf
            r1 = -1
            r2 = 1
        L_0x0d8d:
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x0db8
            java.lang.Object r3 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r3 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r3
            java.lang.Boolean r3 = r3.getDisabled()
            if (r3 == 0) goto L_0x0db4
            java.lang.Object r3 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r3 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r3
            java.lang.Boolean r3 = r3.getDisabled()
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0db4
            r8 = 1
            int r1 = r2 + -1
            r6 = r1
            goto L_0x0dba
        L_0x0db4:
            r8 = 1
            int r2 = r2 + 1
            goto L_0x0d8d
        L_0x0db8:
            r8 = 1
            r6 = -1
        L_0x0dba:
            android.widget.TextView r5 = r9.aP
            android.widget.TextView r4 = r9.aQ
            int r1 = r0.size()
            java.lang.String r3 = "red"
            r2 = 3
            if (r1 <= r2) goto L_0x1138
            android.widget.LinearLayout r1 = r9.aN
            r1.setVisibility(r14)
            android.widget.LinearLayout r1 = r9.aO
            r8 = 8
            r1.setVisibility(r8)
            android.widget.TextView r1 = r9.V
            android.widget.TextView r14 = r9.aR
            int r17 = r0.size()
            if (r17 <= 0) goto L_0x0ec5
            r2 = 0
            java.lang.Object r17 = r0.get(r2)
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r17 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r17
            java.util.ArrayList r19 = r17.getHistory()
            android.widget.TextView r2 = r9.at
            java.lang.String r20 = r17.getdate()
            boolean r20 = android.text.TextUtils.isEmpty(r20)
            if (r20 != 0) goto L_0x0e0a
            java.lang.Boolean r20 = r17.getDisabled()
            boolean r20 = r20.booleanValue()
            if (r20 == 0) goto L_0x0e0a
            android.widget.TextView r8 = r9.ax
            r20 = r1
            java.lang.String r1 = r17.getdate()
            r11.a((android.widget.TextView) r8, (java.lang.String) r1)
            goto L_0x0e0c
        L_0x0e0a:
            r20 = r1
        L_0x0e0c:
            java.lang.String r1 = r17.getLabel()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0e1f
            android.widget.TextView r1 = r9.at
            java.lang.String r8 = r17.getLabel()
            r11.a((android.widget.TextView) r1, (java.lang.String) r8, (java.lang.String) r10)
        L_0x0e1f:
            java.lang.Boolean r1 = r17.getDisabled()
            if (r1 == 0) goto L_0x0e79
            android.widget.ImageView r1 = r9.ap
            if (r6 != 0) goto L_0x0e5c
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            r22 = r2
            java.lang.String r2 = r17.getColor()
            r23 = r3
            java.lang.Boolean r3 = r17.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r2, (java.lang.Boolean) r3, (java.lang.Boolean) r8)
            r1 = r34
            r8 = 3
            r2 = r19
            r12 = r23
            r3 = r20
            r23 = r4
            r4 = r5
            r26 = r5
            r5 = r23
            r27 = r13
            r13 = r6
            r6 = r22
            r28 = r15
            r15 = r7
            r7 = r14
            r29 = r15
            r15 = 1
            r8 = r35
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0e88
        L_0x0e5c:
            r22 = r2
            r12 = r3
            r23 = r4
            r26 = r5
            r29 = r7
            r27 = r13
            r28 = r15
            r15 = 1
            r13 = r6
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            java.lang.String r3 = r17.getColor()
            java.lang.Boolean r4 = r17.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r3, (java.lang.Boolean) r4, (java.lang.Boolean) r2)
            goto L_0x0e88
        L_0x0e79:
            r22 = r2
            r12 = r3
            r23 = r4
            r26 = r5
            r29 = r7
            r27 = r13
            r28 = r15
            r15 = 1
            r13 = r6
        L_0x0e88:
            java.lang.Boolean r1 = r17.getDisabled()
            if (r1 == 0) goto L_0x0ebe
            java.lang.Boolean r1 = r17.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0ebe
            android.widget.ImageView r8 = r9.ap
            net.one97.paytm.AJROrderSummaryActivityBase$28 r7 = new net.one97.paytm.AJROrderSummaryActivityBase$28
            r1 = r7
            r2 = r34
            r3 = r19
            r4 = r20
            r5 = r26
            r6 = r23
            r15 = r7
            r7 = r22
            r17 = r13
            r13 = r8
            r8 = r14
            r19 = r9
            r9 = r35
            r22 = r14
            r14 = r10
            r10 = r19
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r13.setOnClickListener(r15)
            goto L_0x0ed9
        L_0x0ebe:
            r19 = r9
            r17 = r13
            r22 = r14
            goto L_0x0ed8
        L_0x0ec5:
            r20 = r1
            r12 = r3
            r23 = r4
            r26 = r5
            r17 = r6
            r29 = r7
            r19 = r9
            r27 = r13
            r22 = r14
            r28 = r15
        L_0x0ed8:
            r14 = r10
        L_0x0ed9:
            int r1 = r0.size()
            r2 = 1
            if (r1 <= r2) goto L_0x0faa
            java.lang.Object r1 = r0.get(r2)
            r9 = r1
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r9 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r9
            java.util.ArrayList r10 = r9.getHistory()
            r13 = r19
            android.widget.TextView r15 = r13.au
            java.lang.String r1 = r9.getdate()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0f0c
            java.lang.Boolean r1 = r9.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0f0c
            android.widget.TextView r1 = r13.ay
            java.lang.String r2 = r9.getdate()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2)
        L_0x0f0c:
            java.lang.String r1 = r9.getLabel()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0f3b
            android.widget.TextView r1 = r13.au
            java.lang.String r2 = r9.getColor()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0f34
            java.lang.String r2 = r9.getColor()
            boolean r2 = r2.equalsIgnoreCase(r12)
            if (r2 == 0) goto L_0x0f34
            java.lang.String r2 = r9.getLabel()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2, (java.lang.String) r12)
            goto L_0x0f3b
        L_0x0f34:
            java.lang.String r2 = r9.getLabel()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2, (java.lang.String) r14)
        L_0x0f3b:
            java.lang.Boolean r1 = r9.getDisabled()
            if (r1 == 0) goto L_0x0f75
            android.widget.ImageView r1 = r13.aq
            r12 = r17
            r2 = 1
            if (r12 != r2) goto L_0x0f67
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r3 = r9.getColor()
            java.lang.Boolean r4 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r3, (java.lang.Boolean) r4, (java.lang.Boolean) r2)
            r1 = r34
            r2 = r10
            r3 = r20
            r4 = r26
            r5 = r23
            r6 = r15
            r7 = r22
            r8 = r35
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0f77
        L_0x0f67:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            java.lang.String r3 = r9.getColor()
            java.lang.Boolean r4 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r3, (java.lang.Boolean) r4, (java.lang.Boolean) r2)
            goto L_0x0f77
        L_0x0f75:
            r12 = r17
        L_0x0f77:
            java.lang.Boolean r1 = r9.getDisabled()
            if (r1 == 0) goto L_0x0fa7
            java.lang.Boolean r1 = r9.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0fa7
            android.widget.ImageView r9 = r13.aq
            net.one97.paytm.AJROrderSummaryActivityBase$29 r8 = new net.one97.paytm.AJROrderSummaryActivityBase$29
            r1 = r8
            r2 = r34
            r3 = r10
            r4 = r20
            r5 = r26
            r6 = r23
            r7 = r15
            r15 = r8
            r8 = r22
            r10 = r9
            r9 = r35
            r17 = r12
            r12 = r10
            r10 = r13
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r12.setOnClickListener(r15)
            goto L_0x0fac
        L_0x0fa7:
            r17 = r12
            goto L_0x0fac
        L_0x0faa:
            r13 = r19
        L_0x0fac:
            int r1 = r0.size()
            r15 = 2
            if (r1 <= r15) goto L_0x1083
            java.lang.Object r1 = r0.get(r15)
            r9 = r1
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r9 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r9
            java.util.ArrayList r10 = r9.getHistory()
            android.widget.TextView r12 = r13.av
            java.lang.String r1 = r9.getdate()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0fdd
            java.lang.Boolean r1 = r9.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0fdd
            android.widget.TextView r1 = r13.az
            java.lang.String r2 = r9.getdate()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2)
        L_0x0fdd:
            java.lang.String r1 = r9.getLabel()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0ff0
            android.widget.TextView r1 = r13.av
            java.lang.String r2 = r9.getLabel()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2, (java.lang.String) r14)
        L_0x0ff0:
            java.lang.Boolean r1 = r9.getDisabled()
            if (r1 == 0) goto L_0x1058
            android.widget.ImageView r1 = r13.ar
            int r2 = r0.size()
            r3 = 3
            if (r2 != r3) goto L_0x1028
            java.lang.Boolean r2 = r9.getDisabled()
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x1028
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r3 = r9.getColor()
            java.lang.Boolean r4 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r3, (java.lang.Boolean) r4, (java.lang.Boolean) r2)
            r1 = r34
            r2 = r10
            r3 = r20
            r4 = r26
            r5 = r23
            r6 = r12
            r7 = r22
            r8 = r35
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x1058
        L_0x1028:
            r2 = r17
            if (r2 != r15) goto L_0x104b
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r3 = r9.getColor()
            java.lang.Boolean r4 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r3, (java.lang.Boolean) r4, (java.lang.Boolean) r2)
            r1 = r34
            r2 = r10
            r3 = r20
            r4 = r26
            r5 = r23
            r6 = r12
            r7 = r22
            r8 = r35
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x1058
        L_0x104b:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            java.lang.String r3 = r9.getColor()
            java.lang.Boolean r4 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r3, (java.lang.Boolean) r4, (java.lang.Boolean) r2)
        L_0x1058:
            java.lang.Boolean r1 = r9.getDisabled()
            if (r1 == 0) goto L_0x1083
            java.lang.Boolean r1 = r9.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x1083
            android.widget.ImageView r15 = r13.ar
            net.one97.paytm.AJROrderSummaryActivityBase$30 r9 = new net.one97.paytm.AJROrderSummaryActivityBase$30
            r1 = r9
            r2 = r34
            r3 = r10
            r4 = r20
            r5 = r26
            r6 = r23
            r7 = r12
            r8 = r22
            r12 = r9
            r9 = r35
            r10 = r13
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r15.setOnClickListener(r12)
        L_0x1083:
            int r1 = r0.size()
            r2 = 3
            if (r1 <= r2) goto L_0x13cc
            java.lang.Object r1 = r0.get(r2)
            r9 = r1
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r9 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r9
            java.util.ArrayList r10 = r9.getHistory()
            android.widget.TextView r12 = r13.aw
            java.lang.String r1 = r9.getdate()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x10b4
            java.lang.Boolean r1 = r9.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x10b4
            android.widget.TextView r1 = r13.aA
            java.lang.String r2 = r9.getdate()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2)
        L_0x10b4:
            java.lang.String r1 = r9.getLabel()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x10c7
            android.widget.TextView r1 = r13.aw
            java.lang.String r2 = r9.getLabel()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2, (java.lang.String) r14)
        L_0x10c7:
            java.lang.Boolean r1 = r9.getDisabled()
            if (r1 == 0) goto L_0x110c
            android.widget.ImageView r1 = r13.as
            int r0 = r0.size()
            r2 = 4
            if (r0 != r2) goto L_0x10ff
            java.lang.Boolean r0 = r9.getDisabled()
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x10ff
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.String r2 = r9.getColor()
            java.lang.Boolean r3 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r2, (java.lang.Boolean) r3, (java.lang.Boolean) r0)
            r1 = r34
            r2 = r10
            r3 = r20
            r4 = r26
            r5 = r23
            r6 = r12
            r7 = r22
            r8 = r35
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x110c
        L_0x10ff:
            java.lang.String r0 = r9.getColor()
            java.lang.Boolean r2 = r9.getDisabled()
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            a((android.widget.ImageView) r1, (java.lang.String) r0, (java.lang.Boolean) r2, (java.lang.Boolean) r3)
        L_0x110c:
            java.lang.Boolean r0 = r9.getDisabled()
            if (r0 == 0) goto L_0x13cc
            java.lang.Boolean r0 = r9.getDisabled()
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x13cc
            android.widget.ImageView r0 = r13.as
            net.one97.paytm.AJROrderSummaryActivityBase$31 r14 = new net.one97.paytm.AJROrderSummaryActivityBase$31
            r1 = r14
            r2 = r34
            r3 = r10
            r4 = r20
            r5 = r26
            r6 = r23
            r7 = r12
            r8 = r22
            r9 = r35
            r10 = r13
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r0.setOnClickListener(r14)
            goto L_0x13cc
        L_0x1138:
            r12 = r3
            r23 = r4
            r26 = r5
            r29 = r7
            r14 = r10
            r27 = r13
            r28 = r15
            r15 = 2
            r10 = r6
            r13 = r9
            android.widget.LinearLayout r1 = r13.aN
            r9 = 8
            r1.setVisibility(r9)
            android.widget.LinearLayout r1 = r13.aO
            r2 = 0
            r1.setVisibility(r2)
            android.widget.TextView r8 = r13.V
            android.widget.TextView r7 = r13.aR
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x1215
            java.lang.Object r1 = r0.get(r2)
            r17 = r1
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r17 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r17
            java.util.ArrayList r19 = r17.getHistory()
            android.widget.TextView r6 = r13.aE
            java.lang.String r1 = r17.getdate()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x1189
            java.lang.Boolean r1 = r17.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x1189
            android.widget.TextView r1 = r13.aH
            java.lang.String r2 = r17.getdate()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2)
        L_0x1189:
            java.lang.String r1 = r17.getLabel()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x119c
            android.widget.TextView r1 = r13.aE
            java.lang.String r2 = r17.getLabel()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2, (java.lang.String) r14)
        L_0x119c:
            java.lang.Boolean r1 = r17.getDisabled()
            if (r1 == 0) goto L_0x11dc
            android.widget.ImageView r1 = r13.aB
            if (r10 != 0) goto L_0x11c8
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r3 = r17.getColor()
            java.lang.Boolean r4 = r17.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r3, (java.lang.Boolean) r4, (java.lang.Boolean) r2)
            r1 = r34
            r2 = r19
            r3 = r8
            r4 = r26
            r5 = r23
            r20 = r6
            r21 = r7
            r22 = r8
            r8 = r35
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x11e2
        L_0x11c8:
            r20 = r6
            r21 = r7
            r22 = r8
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            java.lang.String r3 = r17.getColor()
            java.lang.Boolean r4 = r17.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r3, (java.lang.Boolean) r4, (java.lang.Boolean) r2)
            goto L_0x11e2
        L_0x11dc:
            r20 = r6
            r21 = r7
            r22 = r8
        L_0x11e2:
            java.lang.Boolean r1 = r17.getDisabled()
            if (r1 == 0) goto L_0x1219
            java.lang.Boolean r1 = r17.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x1219
            android.widget.ImageView r8 = r13.aB
            net.one97.paytm.AJROrderSummaryActivityBase$32 r7 = new net.one97.paytm.AJROrderSummaryActivityBase$32
            r1 = r7
            r2 = r34
            r3 = r19
            r4 = r22
            r5 = r26
            r6 = r23
            r15 = r7
            r7 = r20
            r17 = r14
            r14 = r8
            r8 = r21
            r9 = r35
            r33 = r10
            r10 = r13
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r14.setOnClickListener(r15)
            goto L_0x121d
        L_0x1215:
            r21 = r7
            r22 = r8
        L_0x1219:
            r33 = r10
            r17 = r14
        L_0x121d:
            int r1 = r0.size()
            r2 = 1
            if (r1 <= r2) goto L_0x12f1
            java.lang.Object r1 = r0.get(r2)
            r9 = r1
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r9 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r9
            java.util.ArrayList r10 = r9.getHistory()
            android.widget.TextView r14 = r13.aF
            java.lang.String r1 = r9.getdate()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x124e
            java.lang.Boolean r1 = r9.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x124e
            android.widget.TextView r1 = r13.aI
            java.lang.String r2 = r9.getdate()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2)
        L_0x124e:
            java.lang.String r1 = r9.getLabel()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x1280
            android.widget.TextView r1 = r13.aF
            java.lang.String r2 = r9.getColor()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x1276
            java.lang.String r2 = r9.getColor()
            boolean r2 = r2.equalsIgnoreCase(r12)
            if (r2 == 0) goto L_0x1276
            java.lang.String r2 = r9.getLabel()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2, (java.lang.String) r12)
            goto L_0x1280
        L_0x1276:
            java.lang.String r2 = r9.getLabel()
            r12 = r17
            r11.a((android.widget.TextView) r1, (java.lang.String) r2, (java.lang.String) r12)
            goto L_0x1282
        L_0x1280:
            r12 = r17
        L_0x1282:
            java.lang.Boolean r1 = r9.getDisabled()
            if (r1 == 0) goto L_0x12bc
            android.widget.ImageView r1 = r13.aC
            r15 = r33
            r2 = 1
            if (r15 != r2) goto L_0x12ae
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            java.lang.String r3 = r9.getColor()
            java.lang.Boolean r4 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r3, (java.lang.Boolean) r4, (java.lang.Boolean) r2)
            r1 = r34
            r2 = r10
            r3 = r22
            r4 = r26
            r5 = r23
            r6 = r14
            r7 = r21
            r8 = r35
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x12be
        L_0x12ae:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            java.lang.String r3 = r9.getColor()
            java.lang.Boolean r4 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r3, (java.lang.Boolean) r4, (java.lang.Boolean) r2)
            goto L_0x12be
        L_0x12bc:
            r15 = r33
        L_0x12be:
            java.lang.Boolean r1 = r9.getDisabled()
            if (r1 == 0) goto L_0x12ee
            java.lang.Boolean r1 = r9.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x12ee
            android.widget.ImageView r9 = r13.aC
            net.one97.paytm.AJROrderSummaryActivityBase$34 r8 = new net.one97.paytm.AJROrderSummaryActivityBase$34
            r1 = r8
            r2 = r34
            r3 = r10
            r4 = r22
            r5 = r26
            r6 = r23
            r7 = r14
            r14 = r8
            r8 = r21
            r10 = r9
            r9 = r35
            r17 = r15
            r15 = r10
            r10 = r13
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r15.setOnClickListener(r14)
            goto L_0x12f5
        L_0x12ee:
            r17 = r15
            goto L_0x12f5
        L_0x12f1:
            r12 = r17
            r17 = r33
        L_0x12f5:
            int r1 = r0.size()
            r2 = 2
            if (r1 <= r2) goto L_0x13cc
            java.lang.Object r1 = r0.get(r2)
            r9 = r1
            net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow r9 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow) r9
            java.util.ArrayList r10 = r9.getHistory()
            android.widget.TextView r14 = r13.aG
            java.lang.String r1 = r9.getdate()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x1326
            java.lang.Boolean r1 = r9.getDisabled()
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x1326
            android.widget.TextView r1 = r13.aJ
            java.lang.String r2 = r9.getdate()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2)
        L_0x1326:
            java.lang.String r1 = r9.getLabel()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x1339
            android.widget.TextView r1 = r13.aG
            java.lang.String r2 = r9.getLabel()
            r11.a((android.widget.TextView) r1, (java.lang.String) r2, (java.lang.String) r12)
        L_0x1339:
            java.lang.Boolean r1 = r9.getDisabled()
            if (r1 == 0) goto L_0x13a2
            android.widget.ImageView r1 = r13.aD
            int r0 = r0.size()
            r2 = 3
            if (r0 != r2) goto L_0x1371
            java.lang.Boolean r0 = r9.getDisabled()
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x1371
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.String r2 = r9.getColor()
            java.lang.Boolean r3 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r2, (java.lang.Boolean) r3, (java.lang.Boolean) r0)
            r1 = r34
            r2 = r10
            r3 = r22
            r4 = r26
            r5 = r23
            r6 = r14
            r7 = r21
            r8 = r35
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x13a2
        L_0x1371:
            r0 = r17
            r2 = 2
            if (r0 != r2) goto L_0x1395
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.String r2 = r9.getColor()
            java.lang.Boolean r3 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r2, (java.lang.Boolean) r3, (java.lang.Boolean) r0)
            r1 = r34
            r2 = r10
            r3 = r22
            r4 = r26
            r5 = r23
            r6 = r14
            r7 = r21
            r8 = r35
            r1.a(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x13a2
        L_0x1395:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            java.lang.String r2 = r9.getColor()
            java.lang.Boolean r3 = r9.getDisabled()
            a((android.widget.ImageView) r1, (java.lang.String) r2, (java.lang.Boolean) r3, (java.lang.Boolean) r0)
        L_0x13a2:
            java.lang.Boolean r0 = r9.getDisabled()
            if (r0 == 0) goto L_0x13cc
            java.lang.Boolean r0 = r9.getDisabled()
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x13cc
            android.widget.ImageView r0 = r13.aD
            net.one97.paytm.AJROrderSummaryActivityBase$35 r12 = new net.one97.paytm.AJROrderSummaryActivityBase$35
            r1 = r12
            r2 = r34
            r3 = r10
            r4 = r22
            r5 = r26
            r6 = r23
            r7 = r14
            r8 = r21
            r9 = r35
            r10 = r13
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r0.setOnClickListener(r12)
        L_0x13cc:
            r1 = 8
            goto L_0x13f6
        L_0x13cf:
            r29 = r7
            r27 = r13
            r28 = r15
            r13 = r9
            android.widget.LinearLayout r0 = r13.aN
            r1 = 8
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r13.aO
            r0.setVisibility(r1)
            goto L_0x13f6
        L_0x13e3:
            r29 = r7
            r27 = r13
            r28 = r15
            r1 = 8
            r13 = r9
            android.widget.LinearLayout r0 = r13.aN
            r0.setVisibility(r1)
            android.widget.LinearLayout r0 = r13.aO
            r0.setVisibility(r1)
        L_0x13f6:
            boolean r0 = r11.au
            if (r0 == 0) goto L_0x1409
            android.widget.ImageView r0 = r13.ai
            r0.setVisibility(r1)
            goto L_0x1409
        L_0x1400:
            r29 = r7
            r27 = r13
            r28 = r15
            r1 = 8
            r13 = r9
        L_0x1409:
            android.widget.ImageView r0 = r13.ab
            net.one97.paytm.AJROrderSummaryActivityBase$36 r2 = new net.one97.paytm.AJROrderSummaryActivityBase$36
            r4 = r28
            r3 = r29
            r2.<init>(r3, r4)
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r13.W
            net.one97.paytm.AJROrderSummaryActivityBase$37 r2 = new net.one97.paytm.AJROrderSummaryActivityBase$37
            r2.<init>(r4, r3)
            r0.setOnClickListener(r2)
            android.widget.RelativeLayout r0 = r13.x
            r2 = 0
            r0.setVisibility(r2)
            int r0 = r27.size()
            if (r0 <= 0) goto L_0x1467
            android.widget.LinearLayout r0 = r13.o
            r0.setVisibility(r2)
            android.widget.RelativeLayout r0 = r13.u
            r0.setVisibility(r2)
            net.one97.paytm.widget.a r1 = new net.one97.paytm.widget.a     // Catch:{ IndexOutOfBoundsException -> 0x145a, Exception -> 0x144d }
            android.widget.LinearLayout r5 = r13.o     // Catch:{ IndexOutOfBoundsException -> 0x145a, Exception -> 0x144d }
            java.lang.String r9 = "Invoice"
            r2 = r34
            r3 = r34
            r4 = r27
            r6 = r16
            r7 = r36
            r8 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ IndexOutOfBoundsException -> 0x145a, Exception -> 0x144d }
            goto L_0x147d
        L_0x144d:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x147d
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            goto L_0x147d
        L_0x145a:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x147d
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            goto L_0x147d
        L_0x1467:
            boolean r0 = r35.getIsRepeat()
            if (r0 != 0) goto L_0x147d
            boolean r0 = r35.getIsRetry()
            if (r0 != 0) goto L_0x147d
            android.widget.LinearLayout r0 = r13.o
            r0.setVisibility(r1)
            android.widget.RelativeLayout r0 = r13.u
            r0.setVisibility(r1)
        L_0x147d:
            r1 = r35
            r2 = r25
            goto L_0x1485
        L_0x1482:
            r1 = r35
            r2 = r15
        L_0x1485:
            r2.setTag(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.a(net.one97.paytm.common.entity.shopping.CJROrderedCart, int):android.view.View");
    }

    private static boolean e(CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart.getProductDetail().getId() == 154435058) {
            return cJROrderedCart.getRechargeConfiguration().containsKey("targetMobile");
        }
        return false;
    }

    private void a(g gVar, CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart != null) {
            c(gVar, cJROrderedCart);
            b(gVar, cJROrderedCart);
            if (cJROrderedCart.getStatusText() == null || TextUtils.isEmpty(cJROrderedCart.getStatusText())) {
                gVar.cJ.setVisibility(8);
                return;
            }
            gVar.cJ.setVisibility(0);
            gVar.cJ.setText(cJROrderedCart.getStatusText());
        }
    }

    private void b(g gVar, CJROrderedCart cJROrderedCart) {
        if (!(cJROrderedCart == null || cJROrderedCart.getStatus() == null)) {
            gVar.cK.setVisibility(0);
            gVar.cK.setText(com.paytm.utility.b.A(cJROrderedCart.getStatus()));
            if (cJROrderedCart.getStatus() == null || TextUtils.isEmpty(cJROrderedCart.getStatus())) {
                gVar.cK.setVisibility(8);
            } else {
                gVar.cK.setVisibility(0);
                a(gVar.cK, cJROrderedCart, (String) null);
            }
        }
        a(gVar.cK.getText().toString(), gVar.f51624g.getText().toString(), gVar.Y);
    }

    private static void c(g gVar, CJROrderedCart cJROrderedCart) {
        Map<String, String> rechargeConfiguration = cJROrderedCart.getRechargeConfiguration();
        if (rechargeConfiguration != null) {
            try {
                if (rechargeConfiguration.containsKey("passenger_name")) {
                    gVar.cI.setText(rechargeConfiguration.get("passenger_name"));
                } else {
                    gVar.cI.setVisibility(8);
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    private void a(CJROrderedCart cJROrderedCart, g gVar) {
        cJROrderedCart.getQuantity();
        double subTotal = cJROrderedCart.getSubTotal() > 0.0d ? cJROrderedCart.getSubTotal() : 0.0d;
        double doubleValue = (cJROrderedCart.getShippingCharge() == null || TextUtils.isEmpty(cJROrderedCart.getShippingCharge())) ? 0.0d : Double.valueOf(cJROrderedCart.getShippingCharge()).doubleValue();
        if (cJROrderedCart.getConvFee() != null && !TextUtils.isEmpty(cJROrderedCart.getConvFee())) {
            Double.valueOf(cJROrderedCart.getConvFee()).doubleValue();
        }
        if (cJROrderedCart.getOtherTaxes() != null && cJROrderedCart.getOtherTaxes().size() > 0) {
            Iterator<CJROtherTaxes> it2 = cJROrderedCart.getOtherTaxes().iterator();
            while (it2.hasNext()) {
                Double.valueOf(it2.next().getValue()).doubleValue();
            }
        }
        if (cJROrderedCart.getDiscountAmount() > 0.0d) {
            cJROrderedCart.getDiscountAmount();
        }
        Double valueOf = Double.valueOf(doubleValue + subTotal);
        if (valueOf.doubleValue() > subTotal || ((cJROrderedCart.getAggregateItemPrice() != null && Double.parseDouble(cJROrderedCart.getAggregateItemPrice()) < subTotal) || cJROrderedCart.getDiscountAmount() > 0.0d)) {
            gVar.U.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tax_info, 0);
        } else {
            gVar.U.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        TextView textView = gVar.U;
        textView.setText(Html.fromHtml(getResources().getString(R.string.rs) + " " + com.paytm.utility.b.a(valueOf.doubleValue())));
    }

    private View b(String str, String str2) {
        RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.cart_price_break_up_field, (ViewGroup) null);
        ((TextView) relativeLayout.findViewById(R.id.break_up_field_label)).setText(str2);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.break_up_field);
        if (str2.equalsIgnoreCase(getResources().getString(R.string.discount))) {
            textView.setText("- " + getResources().getString(R.string.rs) + " " + com.paytm.utility.b.x(str));
        } else {
            textView.setText(getResources().getString(R.string.rs) + " " + com.paytm.utility.b.x(str));
        }
        return relativeLayout;
    }

    private void d(g gVar, CJROrderedCart cJROrderedCart) {
        if (S()) {
            gVar.bq.setVisibility(0);
            e(gVar, cJROrderedCart);
            return;
        }
        gVar.bq.setVisibility(8);
    }

    private void e(g gVar, final CJROrderedCart cJROrderedCart) {
        gVar.bm.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJROrderSummaryActivityBase.this.a((CJROrderSummaryRatingModel) null, cJROrderedCart, (CJRSellerRatings) null);
            }
        });
    }

    private void f(g gVar, CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart == null || cJROrderedCart.getmEstimatedDelivery() == null || TextUtils.isEmpty(cJROrderedCart.getmEstimatedDelivery())) {
            gVar.bt.setVisibility(8);
            return;
        }
        gVar.bt.setText(String.format(getResources().getString(R.string.cart_est_delivery), new Object[]{cJROrderedCart.getmEstimatedDelivery()}));
        gVar.bt.setVisibility(0);
    }

    private void g(final g gVar, CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart.getIsPFA() != 0) {
            gVar.f51618a.setVisibility(0);
            if (!TextUtils.isEmpty(this.J.getPpLogoUrl())) {
                a(gVar.f51619b, this.J.getPpLogoUrl());
            }
            gVar.f51620c.setVisibility(8);
            gVar.f51621d.setVisibility(8);
            gVar.f51618a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJROrderSummaryActivityBase.a(AJROrderSummaryActivityBase.this, (View) gVar.f51618a);
                }
            });
            return;
        }
        gVar.f51618a.setVisibility(8);
    }

    private void a(final ImageView imageView, String str) {
        ai.INSTANCE.getImageLoader().get(str, new ImageLoader.ImageListener() {
            public final void onErrorResponse(VolleyError volleyError) {
            }

            public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                Bitmap bitmap;
                if (imageContainer != null && (bitmap = imageContainer.getBitmap()) != null && imageContainer.getRequestUrl() != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        });
    }

    private void M() {
        TextView textView = (TextView) findViewById(R.id.txt_tax_data_total);
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary == null || cJROrderSummary.getOtherTaxes() == null || this.J.getOtherTaxes().size() <= 0) {
            findViewById(R.id.lyt_tax_data).setVisibility(8);
            return;
        }
        Iterator<CJROtherTaxes> it2 = this.J.getOtherTaxes().iterator();
        double d2 = 0.0d;
        while (it2.hasNext()) {
            d2 += Double.valueOf(it2.next().getValue()).doubleValue();
        }
        textView.setText(getString(R.string.rupee_symbol) + " " + com.paytm.utility.b.a(d2));
        findViewById(R.id.lyt_tax_data).setVisibility(0);
        ((ImageView) findViewById(R.id.txt_tax_info)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJROrderSummaryActivityBase aJROrderSummaryActivityBase = AJROrderSummaryActivityBase.this;
                AJROrderSummaryActivityBase.a(aJROrderSummaryActivityBase, (CJROrderedCart) null, (ArrayList) aJROrderSummaryActivityBase.J.getOtherTaxes());
            }
        });
    }

    private void b(long j2) {
        try {
            StringBuilder sb = new StringBuilder();
            net.one97.paytm.j.c.a();
            sb.append(net.one97.paytm.j.c.a("sellerRating", (String) null));
            sb.append(j2);
            String sb2 = sb.toString();
            String b2 = ag.a(getApplicationContext()).b("sso_token=", "", true);
            if (b2.equals("")) {
                b2 = null;
            }
            if (sb2 != null && b2 != null) {
                new HashMap().put("Content-Type", "application/json");
                net.one97.paytm.common.b.d.a(this, sb2 + com.paytm.utility.c.a((Context) this, true), this, (Map<String, String>) null, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRSellerRatingList(), a.c.HOME, a.b.SILENT).a();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void h(g gVar, final CJROrderedCart cJROrderedCart) {
        try {
            j();
            int applyDimension = (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
            ((LinearLayout.LayoutParams) gVar.y.getLayoutParams()).setMargins(applyDimension, 0, applyDimension, 0);
            gVar.y.setVisibility(8);
            if (cJROrderedCart != null) {
                this.aK.setVisibility(8);
                this.aL.setVisibility(8);
                gVar.bd.setVisibility(8);
                gVar.j.setTextSize(2, 12.0f);
                gVar.f51626i.setTextSize(2, 12.0f);
                gVar.f51626i.setTextColor(getResources().getColor(R.color.color_de000000));
                if (cJROrderedCart.getMetaDataResponse() != null) {
                    Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
                    com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
                    fVar.a(fVar.a(metaDataResponse), CJROrderSummaryMetadataResponse.class);
                }
                String status = cJROrderedCart.getStatus();
                gVar.ca.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AJROrderSummaryActivityBase.b(AJROrderSummaryActivityBase.this, cJROrderedCart);
                        AJROrderSummaryActivityBase.b(AJROrderSummaryActivityBase.this, "Contact Customer Care");
                    }
                });
                if (this.J == null || this.J.getFooter() == null || TextUtils.isEmpty(this.J.getFooter().getDescription())) {
                    gVar.cr.setVisibility(0);
                } else {
                    gVar.cr.setVisibility(0);
                    gVar.cr.setText(this.J.getFooter().getDescription());
                }
                if (status != null && status.equalsIgnoreCase("SUCCESS")) {
                    if (this.L != null && this.L.equalsIgnoreCase("Payment")) {
                        a(cJROrderedCart.getRechargeConfiguration());
                    }
                    gVar.bA.setVisibility(0);
                    gVar.bC.setVisibility(8);
                    gVar.bJ.setVisibility(0);
                    gVar.bB.setVisibility(0);
                    gVar.bz.setVisibility(0);
                    i(gVar, cJROrderedCart);
                } else if (status == null || !status.equalsIgnoreCase("FAILED")) {
                    gVar.bA.setVisibility(8);
                    gVar.bC.setVisibility(0);
                    gVar.bB.setVisibility(0);
                    gVar.bJ.setVisibility(0);
                    gVar.bN.setVisibility(8);
                    a(gVar, cJROrderedCart, status);
                } else {
                    gVar.bC.setVisibility(0);
                    gVar.bB.setVisibility(8);
                    gVar.bA.setVisibility(8);
                    gVar.bJ.setVisibility(0);
                    a(gVar, cJROrderedCart, status);
                    gVar.bN.setVisibility(0);
                    b(cJROrderedCart, gVar);
                }
            } else {
                this.aK.setVisibility(0);
                this.aL.setVisibility(0);
                gVar.cy.setVisibility(8);
                gVar.bd.setVisibility(8);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private static void b(CJROrderedCart cJROrderedCart, g gVar) {
        if (TextUtils.isEmpty(cJROrderedCart.getPromoText()) || TextUtils.isEmpty(cJROrderedCart.getPromoText().trim()) || cJROrderedCart.getPromoCode() == null || TextUtils.isEmpty(cJROrderedCart.getPromoCode())) {
            gVar.cG.setVisibility(8);
            return;
        }
        gVar.cw.setText(cJROrderedCart.getPromoCode());
        gVar.cv.setText(cJROrderedCart.getPromoText());
        gVar.cG.setVisibility(0);
    }

    private void a(g gVar, CJROrderedCart cJROrderedCart, String str) {
        if (cJROrderedCart.getMetaDataResponse() != null) {
            Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
            com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
            CJROrderSummaryMetadataResponse cJROrderSummaryMetadataResponse = (CJROrderSummaryMetadataResponse) fVar.a(fVar.a(metaDataResponse), CJROrderSummaryMetadataResponse.class);
            if (cJROrderSummaryMetadataResponse != null) {
                if (str != null && !str.equalsIgnoreCase("FAILED")) {
                    a(cJROrderSummaryMetadataResponse, gVar, cJROrderedCart);
                }
                a(gVar, cJROrderSummaryMetadataResponse);
                b(gVar, cJROrderSummaryMetadataResponse);
            }
        }
        if (!(cJROrderedCart == null || cJROrderedCart.getStatus() == null)) {
            gVar.bR.setVisibility(0);
            gVar.bR.setText(com.paytm.utility.b.A(cJROrderedCart.getStatus()));
            if (cJROrderedCart.getStatus().equalsIgnoreCase("FAILED")) {
                if (Build.VERSION.SDK_INT >= 16) {
                    gVar.cd.setBackground(getResources().getDrawable(R.drawable.movie_order_failed));
                } else {
                    gVar.cd.setBackgroundDrawable(getResources().getDrawable(R.drawable.movie_order_failed));
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                gVar.cd.setBackground(getResources().getDrawable(R.drawable.movie_order_pending));
            } else {
                gVar.cd.setBackgroundDrawable(getResources().getDrawable(R.drawable.movie_order_pending));
            }
        }
        if (TextUtils.isEmpty(cJROrderedCart.getPromoText()) || TextUtils.isEmpty(cJROrderedCart.getPromoText().trim()) || cJROrderedCart.getPromoCode() == null || TextUtils.isEmpty(cJROrderedCart.getPromoCode())) {
            gVar.cF.setVisibility(8);
            return;
        }
        gVar.cu.setText(cJROrderedCart.getPromoCode());
        gVar.ct.setText(cJROrderedCart.getPromoText());
        gVar.cF.setVisibility(0);
    }

    private static void a(g gVar, CJROrderSummaryMetadataResponse cJROrderSummaryMetadataResponse) {
        if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getShowTime())) {
            String a2 = net.one97.paytm.utils.q.a(cJROrderSummaryMetadataResponse.getShowTime(), "yyyy-MM-dd'T'HH:mm:ss");
            if (!TextUtils.isEmpty(a2)) {
                String d2 = com.paytm.utility.b.d(a2, "yyyy-MM-dd", "dd");
                String b2 = !TextUtils.isEmpty(d2) ? com.paytm.utility.b.b(Integer.parseInt(d2)) : "";
                String d3 = com.paytm.utility.b.d(a2, "yyyy-MM-dd", "MMMM");
                if (TextUtils.isEmpty(d2) || TextUtils.isEmpty(d3)) {
                    gVar.cn.setVisibility(8);
                    gVar.cp.setVisibility(8);
                } else {
                    gVar.cn.setVisibility(0);
                    gVar.cn.setText(d2);
                    gVar.co.setText(b2);
                    gVar.cp.setText(" ".concat(String.valueOf(d3)));
                }
                String d4 = com.paytm.utility.b.d(a2, "yyyy-MM-dd'T'HH:mm:ss", "h:mm a");
                if (!TextUtils.isEmpty(d4)) {
                    gVar.cq.setVisibility(0);
                    gVar.cq.setText(d4);
                } else {
                    gVar.cq.setVisibility(8);
                }
            }
        }
        if (cJROrderSummaryMetadataResponse.getDuration() > 0) {
            gVar.cf.setVisibility(0);
            gVar.cf.setText(net.one97.paytm.utils.q.a(cJROrderSummaryMetadataResponse.getDuration()));
            return;
        }
        gVar.cf.setVisibility(8);
    }

    private void b(g gVar, CJROrderSummaryMetadataResponse cJROrderSummaryMetadataResponse) {
        try {
            if (this.J == null || TextUtils.isEmpty(this.J.getPaymentSummary())) {
                gVar.bS.setVisibility(8);
            } else {
                gVar.bS.setVisibility(0);
                gVar.bS.setText(this.J.getPaymentSummary());
            }
            if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getMovie())) {
                gVar.bT.setVisibility(0);
                String movie = cJROrderSummaryMetadataResponse.getMovie();
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getLanguage())) {
                    movie = movie + " | " + cJROrderSummaryMetadataResponse.getLanguage();
                }
                gVar.bT.setText(movie);
                return;
            }
            gVar.bT.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    private void a(CJROrderSummaryMetadataResponse cJROrderSummaryMetadataResponse, g gVar, CJROrderedCart cJROrderedCart) {
        if (!(cJROrderSummaryMetadataResponse == null || gVar == null)) {
            if (this.J != null) {
                gVar.cz.setVisibility(0);
                TextView textView = gVar.cc;
                textView.setText(getResources().getString(R.string.rs_symbol) + " " + this.J.getGrandTotal());
            } else {
                gVar.cz.setVisibility(8);
            }
            try {
                if (!(cJROrderSummaryMetadataResponse.getTotalTicketPrice() == 0.0d || cJROrderSummaryMetadataResponse.getTicketCount() == 0)) {
                    int ticketCount = cJROrderSummaryMetadataResponse.getTicketCount();
                    if (ticketCount > 0) {
                        gVar.bI.setVisibility(0);
                        TextView textView2 = gVar.bX;
                        textView2.setText(ticketCount + "X" + getResources().getString(R.string.tickets));
                        TextView textView3 = gVar.cb;
                        textView3.setText(getResources().getString(R.string.rs_symbol) + " " + cJROrderSummaryMetadataResponse.getTotalTicketPrice());
                    } else {
                        gVar.bI.setVisibility(8);
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
            if (this.J.getId() == null || TextUtils.isEmpty(this.J.getId())) {
                gVar.ce.setVisibility(8);
            } else {
                gVar.ce.setVisibility(0);
                TextView textView4 = gVar.ce;
                textView4.setText(getResources().getString(R.string.app_name) + " " + getResources().getString(R.string.bookin_id) + " : " + this.J.getId());
            }
        }
        if (TextUtils.isEmpty(cJROrderedCart.getPromoText()) || TextUtils.isEmpty(cJROrderedCart.getPromoText().trim()) || cJROrderedCart.getPromoCode() == null || TextUtils.isEmpty(cJROrderedCart.getPromoCode())) {
            gVar.cF.setVisibility(8);
            return;
        }
        gVar.cu.setText(cJROrderedCart.getPromoCode());
        gVar.ct.setText(cJROrderedCart.getPromoText());
        gVar.cF.setVisibility(0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:6|(2:10|(1:12))|13|14|(3:16|17|(7:21|23|24|(1:29)(1:28)|30|31|(5:33|34|(1:39)(1:38)|40|(1:81)(2:44|(2:50|51)(2:48|49)))(5:52|53|(1:63)(3:57|(1:61)|62)|64|(2:66|67)(2:68|69))))|22|23|24|(0)(0)|30|31|(0)(0)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x008e */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e A[Catch:{ Exception -> 0x0216 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ad A[Catch:{ Exception -> 0x0216 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00be A[SYNTHETIC, Splitter:B:33:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0186 A[SYNTHETIC, Splitter:B:52:0x0186] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(net.one97.paytm.AJROrderSummaryActivityBase.g r10, net.one97.paytm.common.entity.shopping.CJROrderedCart r11) {
        /*
            r9 = this;
            java.lang.String r0 = "uniqueBookingId"
            r9.j(r10, r11)     // Catch:{ Exception -> 0x0216 }
            java.lang.Object r1 = r11.getMetaDataResponse()     // Catch:{ Exception -> 0x0216 }
            if (r1 == 0) goto L_0x0215
            java.lang.Object r1 = r11.getMetaDataResponse()     // Catch:{ Exception -> 0x0216 }
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0216 }
            r2.<init>()     // Catch:{ Exception -> 0x0216 }
            java.lang.String r1 = r2.a((java.lang.Object) r1)     // Catch:{ Exception -> 0x0216 }
            java.lang.Class<net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse> r3 = net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse.class
            java.lang.Object r1 = r2.a((java.lang.String) r1, r3)     // Catch:{ Exception -> 0x0216 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse r1 = (net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse) r1     // Catch:{ Exception -> 0x0216 }
            if (r1 == 0) goto L_0x0215
            r9.c((net.one97.paytm.AJROrderSummaryActivityBase.g) r10, (net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse) r1)     // Catch:{ Exception -> 0x0216 }
            r2 = 0
            if (r11 == 0) goto L_0x0040
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r3 = r11.getFullFillmentOject()     // Catch:{ Exception -> 0x0216 }
            if (r3 == 0) goto L_0x0040
            net.one97.paytm.common.entity.shopping.CJRFullFillmentObject r3 = r11.getFullFillmentOject()     // Catch:{ Exception -> 0x0216 }
            org.json.JSONObject r4 = r3.getFullFillment()     // Catch:{ Exception -> 0x0216 }
            if (r4 == 0) goto L_0x0040
            org.json.JSONObject r2 = r3.getFullFillment()     // Catch:{ Exception -> 0x0216 }
            r9.a((net.one97.paytm.AJROrderSummaryActivityBase.g) r10, (org.json.JSONObject) r2)     // Catch:{ Exception -> 0x0216 }
        L_0x0040:
            r9.a((net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse) r1, (net.one97.paytm.AJROrderSummaryActivityBase.g) r10, (net.one97.paytm.common.entity.shopping.CJROrderedCart) r11)     // Catch:{ Exception -> 0x0216 }
            r9.d((net.one97.paytm.AJROrderSummaryActivityBase.g) r10, (net.one97.paytm.common.entity.shopping.CJROrderSummaryMetadataResponse) r1)     // Catch:{ Exception -> 0x0216 }
            r11 = 8
            r3 = 0
            if (r2 == 0) goto L_0x0089
            boolean r4 = r2.has(r0)     // Catch:{ Exception -> 0x008e }
            if (r4 == 0) goto L_0x0089
            java.lang.String r4 = r2.getString(r0)     // Catch:{ Exception -> 0x008e }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x008e }
            if (r4 != 0) goto L_0x0089
            android.widget.TextView r4 = r10.cl     // Catch:{ Exception -> 0x008e }
            r4.setVisibility(r3)     // Catch:{ Exception -> 0x008e }
            android.widget.TextView r4 = r10.cl     // Catch:{ Exception -> 0x008e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008e }
            r5.<init>()     // Catch:{ Exception -> 0x008e }
            android.content.res.Resources r6 = r9.getResources()     // Catch:{ Exception -> 0x008e }
            r7 = 2131952743(0x7f130467, float:1.9541937E38)
            java.lang.String r6 = r6.getString(r7)     // Catch:{ Exception -> 0x008e }
            r5.append(r6)     // Catch:{ Exception -> 0x008e }
            java.lang.String r6 = " : "
            r5.append(r6)     // Catch:{ Exception -> 0x008e }
            java.lang.String r0 = r2.getString(r0)     // Catch:{ Exception -> 0x008e }
            r5.append(r0)     // Catch:{ Exception -> 0x008e }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x008e }
            r4.setText(r0)     // Catch:{ Exception -> 0x008e }
            goto L_0x008e
        L_0x0089:
            android.widget.TextView r0 = r10.cl     // Catch:{ Exception -> 0x008e }
            r0.setVisibility(r11)     // Catch:{ Exception -> 0x008e }
        L_0x008e:
            java.lang.String r0 = r1.getStringAddress()     // Catch:{ Exception -> 0x0216 }
            if (r0 == 0) goto L_0x00ad
            java.lang.String r0 = r1.getStringAddress()     // Catch:{ Exception -> 0x0216 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0216 }
            if (r0 != 0) goto L_0x00ad
            android.widget.TextView r0 = r10.ck     // Catch:{ Exception -> 0x0216 }
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x0216 }
            android.widget.TextView r0 = r10.ck     // Catch:{ Exception -> 0x0216 }
            java.lang.String r2 = r1.getStringAddress()     // Catch:{ Exception -> 0x0216 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0216 }
            goto L_0x00b2
        L_0x00ad:
            android.widget.TextView r0 = r10.ck     // Catch:{ Exception -> 0x0216 }
            r0.setVisibility(r11)     // Catch:{ Exception -> 0x0216 }
        L_0x00b2:
            boolean r0 = r1.isFreeSeating()     // Catch:{ Exception -> 0x0216 }
            java.lang.String r2 = "</b></font>"
            java.lang.String r4 = "</font>  <font color= '#494949' size='3'><b>"
            java.lang.String r5 = "<font color= '#494949' size='0.1'>"
            if (r0 != 0) goto L_0x0186
            java.lang.String r0 = r1.getAudi()     // Catch:{ Exception -> 0x0216 }
            if (r0 == 0) goto L_0x0102
            java.lang.String r0 = r1.getAudi()     // Catch:{ Exception -> 0x0216 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0216 }
            if (r0 != 0) goto L_0x0102
            java.lang.String r11 = r1.getAudi()     // Catch:{ Exception -> 0x0216 }
            java.lang.String r0 = " "
            r6 = 2
            java.lang.String[] r11 = r11.split(r0, r6)     // Catch:{ Exception -> 0x0216 }
            r0 = r11[r3]     // Catch:{ Exception -> 0x0216 }
            r6 = 1
            r11 = r11[r6]     // Catch:{ Exception -> 0x0216 }
            android.widget.TextView r6 = r10.bW     // Catch:{ Exception -> 0x0216 }
            r6.setVisibility(r3)     // Catch:{ Exception -> 0x0216 }
            android.widget.TextView r6 = r10.bW     // Catch:{ Exception -> 0x0216 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0216 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x0216 }
            r7.append(r0)     // Catch:{ Exception -> 0x0216 }
            r7.append(r4)     // Catch:{ Exception -> 0x0216 }
            r7.append(r11)     // Catch:{ Exception -> 0x0216 }
            r7.append(r2)     // Catch:{ Exception -> 0x0216 }
            java.lang.String r11 = r7.toString()     // Catch:{ Exception -> 0x0216 }
            android.text.Spanned r11 = android.text.Html.fromHtml(r11)     // Catch:{ Exception -> 0x0216 }
            r6.setText(r11)     // Catch:{ Exception -> 0x0216 }
            goto L_0x0107
        L_0x0102:
            android.widget.TextView r0 = r10.bW     // Catch:{ Exception -> 0x0216 }
            r0.setVisibility(r11)     // Catch:{ Exception -> 0x0216 }
        L_0x0107:
            java.lang.String r11 = r1.getSeatIdsReturned()     // Catch:{ Exception -> 0x0216 }
            if (r11 == 0) goto L_0x0215
            java.lang.String r11 = r1.getSeatIdsReturned()     // Catch:{ Exception -> 0x0216 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0216 }
            if (r11 != 0) goto L_0x0215
            java.lang.String r11 = r1.getSeatIdsReturned()     // Catch:{ Exception -> 0x0216 }
            java.lang.String r11 = net.one97.paytm.utils.p.a((java.lang.String) r11)     // Catch:{ Exception -> 0x0216 }
            r0 = 2131962848(0x7f132be0, float:1.9562433E38)
            if (r11 == 0) goto L_0x0156
            int r6 = r11.length()     // Catch:{ Exception -> 0x0216 }
            if (r6 <= 0) goto L_0x0156
            android.widget.TextView r1 = r10.bV     // Catch:{ Exception -> 0x0216 }
            r1.setVisibility(r3)     // Catch:{ Exception -> 0x0216 }
            android.widget.TextView r10 = r10.bV     // Catch:{ Exception -> 0x0216 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0216 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0216 }
            android.content.res.Resources r3 = r9.getResources()     // Catch:{ Exception -> 0x0216 }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ Exception -> 0x0216 }
            r1.append(r0)     // Catch:{ Exception -> 0x0216 }
            r1.append(r4)     // Catch:{ Exception -> 0x0216 }
            r1.append(r11)     // Catch:{ Exception -> 0x0216 }
            r1.append(r2)     // Catch:{ Exception -> 0x0216 }
            java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x0216 }
            android.text.Spanned r11 = android.text.Html.fromHtml(r11)     // Catch:{ Exception -> 0x0216 }
            r10.setText(r11)     // Catch:{ Exception -> 0x0216 }
            return
        L_0x0156:
            android.widget.TextView r11 = r10.bV     // Catch:{ Exception -> 0x0216 }
            r11.setVisibility(r3)     // Catch:{ Exception -> 0x0216 }
            android.widget.TextView r10 = r10.bV     // Catch:{ Exception -> 0x0216 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0216 }
            r11.<init>(r5)     // Catch:{ Exception -> 0x0216 }
            android.content.res.Resources r3 = r9.getResources()     // Catch:{ Exception -> 0x0216 }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ Exception -> 0x0216 }
            r11.append(r0)     // Catch:{ Exception -> 0x0216 }
            r11.append(r4)     // Catch:{ Exception -> 0x0216 }
            java.lang.String r0 = r1.getSeatIdsReturned()     // Catch:{ Exception -> 0x0216 }
            r11.append(r0)     // Catch:{ Exception -> 0x0216 }
            r11.append(r2)     // Catch:{ Exception -> 0x0216 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0216 }
            android.text.Spanned r11 = android.text.Html.fromHtml(r11)     // Catch:{ Exception -> 0x0216 }
            r10.setText(r11)     // Catch:{ Exception -> 0x0216 }
            return
        L_0x0186:
            java.lang.String r0 = r1.getCircleName()     // Catch:{ NotFoundException -> 0x020d }
            if (r0 == 0) goto L_0x01c9
            java.lang.String r0 = r1.getCircleName()     // Catch:{ NotFoundException -> 0x020d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ NotFoundException -> 0x020d }
            if (r0 != 0) goto L_0x01c9
            java.lang.String r0 = r1.getCircleName()     // Catch:{ NotFoundException -> 0x020d }
            java.lang.String r6 = "\\("
            java.lang.String[] r6 = r0.split(r6)     // Catch:{ NotFoundException -> 0x020d }
            if (r6 == 0) goto L_0x01a7
            int r7 = r6.length     // Catch:{ NotFoundException -> 0x020d }
            if (r7 <= 0) goto L_0x01a7
            r0 = r6[r3]     // Catch:{ NotFoundException -> 0x020d }
        L_0x01a7:
            android.widget.TextView r6 = r10.bW     // Catch:{ NotFoundException -> 0x020d }
            r6.setVisibility(r3)     // Catch:{ NotFoundException -> 0x020d }
            android.widget.TextView r6 = r10.bW     // Catch:{ NotFoundException -> 0x020d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NotFoundException -> 0x020d }
            java.lang.String r8 = "<font color= '#494949' size='0.1'>Circle</font>  <font color= '#494949' size='3'><b>"
            r7.<init>(r8)     // Catch:{ NotFoundException -> 0x020d }
            r7.append(r0)     // Catch:{ NotFoundException -> 0x020d }
            java.lang.String r0 = "'s</b></font>"
            r7.append(r0)     // Catch:{ NotFoundException -> 0x020d }
            java.lang.String r0 = r7.toString()     // Catch:{ NotFoundException -> 0x020d }
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)     // Catch:{ NotFoundException -> 0x020d }
            r6.setText(r0)     // Catch:{ NotFoundException -> 0x020d }
            goto L_0x01ce
        L_0x01c9:
            android.widget.TextView r0 = r10.bW     // Catch:{ NotFoundException -> 0x020d }
            r0.setVisibility(r11)     // Catch:{ NotFoundException -> 0x020d }
        L_0x01ce:
            int r0 = r1.getTicketCount()     // Catch:{ NotFoundException -> 0x020d }
            if (r0 <= 0) goto L_0x0207
            android.widget.TextView r11 = r10.bV     // Catch:{ NotFoundException -> 0x020d }
            r11.setVisibility(r3)     // Catch:{ NotFoundException -> 0x020d }
            android.widget.TextView r10 = r10.bV     // Catch:{ NotFoundException -> 0x020d }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ NotFoundException -> 0x020d }
            r11.<init>(r5)     // Catch:{ NotFoundException -> 0x020d }
            android.content.res.Resources r0 = r9.getResources()     // Catch:{ NotFoundException -> 0x020d }
            r3 = 2131959713(0x7f131fa1, float:1.9556074E38)
            java.lang.String r0 = r0.getString(r3)     // Catch:{ NotFoundException -> 0x020d }
            r11.append(r0)     // Catch:{ NotFoundException -> 0x020d }
            r11.append(r4)     // Catch:{ NotFoundException -> 0x020d }
            int r0 = r1.getTicketCount()     // Catch:{ NotFoundException -> 0x020d }
            r11.append(r0)     // Catch:{ NotFoundException -> 0x020d }
            r11.append(r2)     // Catch:{ NotFoundException -> 0x020d }
            java.lang.String r11 = r11.toString()     // Catch:{ NotFoundException -> 0x020d }
            android.text.Spanned r11 = android.text.Html.fromHtml(r11)     // Catch:{ NotFoundException -> 0x020d }
            r10.setText(r11)     // Catch:{ NotFoundException -> 0x020d }
            return
        L_0x0207:
            android.widget.TextView r10 = r10.bV     // Catch:{ NotFoundException -> 0x020d }
            r10.setVisibility(r11)     // Catch:{ NotFoundException -> 0x020d }
            return
        L_0x020d:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()     // Catch:{ Exception -> 0x0216 }
            com.paytm.utility.q.b(r10)     // Catch:{ Exception -> 0x0216 }
        L_0x0215:
            return
        L_0x0216:
            r10 = move-exception
            boolean r11 = com.paytm.utility.b.v
            if (r11 == 0) goto L_0x0222
            java.lang.String r10 = r10.getMessage()
            com.paytm.utility.q.b(r10)
        L_0x0222:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.i(net.one97.paytm.AJROrderSummaryActivityBase$g, net.one97.paytm.common.entity.shopping.CJROrderedCart):void");
    }

    private void j(g gVar, CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart != null) {
            ArrayList<CJROrderSummaryAction> action = cJROrderedCart.getAction();
            final CJROrderSummaryActionList cJROrderSummaryActionList = new CJROrderSummaryActionList();
            if (action != null && action.size() > 0) {
                for (final int i2 = 0; i2 < action.size(); i2++) {
                    if (!(action.get(i2) == null || action.get(i2).getUiControl() == null || !action.get(i2).getUiControl().equalsIgnoreCase("button") || action.get(i2).getActionName() == null || !action.get(i2).getActionName().equalsIgnoreCase("Invoice"))) {
                        cJROrderSummaryActionList.setAction(action);
                        gVar.cs.setVisibility(0);
                        gVar.cs.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                if (cJROrderSummaryActionList.getAction() != null && cJROrderSummaryActionList.getAction().size() > 0) {
                                    AJROrderSummaryActivityBase.this.a(cJROrderSummaryActionList.getAction().get(i2));
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void a(final g gVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("encryptedOrderId") && !TextUtils.isEmpty(jSONObject.getString("encryptedOrderId"))) {
                    StringBuilder sb = new StringBuilder();
                    net.one97.paytm.j.c.a();
                    sb.append(net.one97.paytm.j.c.a("moviesQRImage", (String) null));
                    sb.append("?ticket_key=");
                    sb.append(jSONObject.getString("encryptedOrderId"));
                    sb.append("&size=10");
                    ai.INSTANCE.getImageLoader().get(sb.toString(), new ImageLoader.ImageListener() {
                        public final void onErrorResponse(VolleyError volleyError) {
                            AJROrderSummaryActivityBase.a(AJROrderSummaryActivityBase.this, gVar);
                        }

                        public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                            Bitmap bitmap;
                            if (imageContainer != null && (bitmap = imageContainer.getBitmap()) != null) {
                                gVar.by.setImageBitmap(bitmap);
                                gVar.Q.setVisibility(8);
                            }
                        }
                    });
                }
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private void c(g gVar, CJROrderSummaryMetadataResponse cJROrderSummaryMetadataResponse) {
        final String latitude = cJROrderSummaryMetadataResponse.getLatitude();
        final String longitude = cJROrderSummaryMetadataResponse.getLongitude();
        final String cinema = cJROrderSummaryMetadataResponse.getCinema();
        final String citySearched = cJROrderSummaryMetadataResponse.getCitySearched();
        if (TextUtils.isEmpty(latitude) || TextUtils.isEmpty(longitude) || TextUtils.isEmpty(cinema) || TextUtils.isEmpty(citySearched)) {
            gVar.cm.setVisibility(8);
        } else {
            gVar.cm.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        AJROrderSummaryActivityBase.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format(Locale.ENGLISH, "geo:%1s,%1s?q=%1s,%1s", new Object[]{latitude, longitude, cinema, citySearched}))));
                    } catch (ActivityNotFoundException unused) {
                        AJROrderSummaryActivityBase aJROrderSummaryActivityBase = AJROrderSummaryActivityBase.this;
                        Toast.makeText(aJROrderSummaryActivityBase, aJROrderSummaryActivityBase.getResources().getString(R.string.no_application_to_view_maps_toast_msg), 0).show();
                    } catch (Exception unused2) {
                    }
                }
            });
        }
    }

    private void d(g gVar, CJROrderSummaryMetadataResponse cJROrderSummaryMetadataResponse) {
        try {
            if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getMovie())) {
                gVar.bO.setVisibility(0);
                String movie = cJROrderSummaryMetadataResponse.getMovie();
                this.aT = movie;
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getLanguage())) {
                    movie = movie + " | " + cJROrderSummaryMetadataResponse.getLanguage();
                }
                gVar.bO.setText(movie);
            } else {
                gVar.bO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getShowTime())) {
                String a2 = net.one97.paytm.utils.q.a(cJROrderSummaryMetadataResponse.getShowTime(), "yyyy-MM-dd'T'HH:mm:ss");
                if (!TextUtils.isEmpty(a2)) {
                    String d2 = com.paytm.utility.b.d(a2, "yyyy-MM-dd", "dd");
                    String str = "";
                    if (!TextUtils.isEmpty(d2)) {
                        str = com.paytm.utility.b.b(Integer.parseInt(d2));
                    }
                    String d3 = com.paytm.utility.b.d(a2, "yyyy-MM-dd", "MMMM");
                    if (!TextUtils.isEmpty(d2)) {
                        gVar.bP.setVisibility(0);
                        gVar.bP.setText(d2);
                        if (!TextUtils.isEmpty(d2)) {
                            gVar.bP.setVisibility(0);
                            gVar.bP.setText(d2);
                            gVar.bY.setText(str);
                            gVar.bZ.setText(" ".concat(String.valueOf(d3)));
                        }
                    } else {
                        gVar.bP.setVisibility(8);
                        gVar.bP.setVisibility(8);
                    }
                    String d4 = com.paytm.utility.b.d(a2, "yyyy-MM-dd'T'HH:mm:ss", "h:mm a");
                    if (!TextUtils.isEmpty(d2)) {
                        gVar.bQ.setVisibility(0);
                        gVar.bQ.setText(d4);
                    } else {
                        gVar.bQ.setVisibility(8);
                        gVar.bQ.setVisibility(8);
                    }
                }
            }
            if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getCinema())) {
                gVar.bU.setVisibility(0);
                gVar.bU.setText(cJROrderSummaryMetadataResponse.getCinema());
                return;
            }
            gVar.bU.setVisibility(8);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public CJRHomePageItem a(String str, CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        CJRTrackingInfo cJRTrackingInfo;
        CJRHomePageItem cJRHomePageItem = new CJRHomePageItem();
        if (str != null) {
            try {
                if (!(this.ay == null || (cJRTrackingInfo = net.one97.paytm.j.a.a(this.ay).get(str)) == null)) {
                    cJRHomePageItem.setListPosition(cJRTrackingInfo.getListPosition());
                    cJRHomePageItem.setListName(cJRTrackingInfo.getListName());
                    cJRHomePageItem.setSearchType(cJRTrackingInfo.getSearchType());
                    cJRHomePageItem.setSearchCategory(cJRTrackingInfo.getSearchCategory());
                    cJRHomePageItem.setSearchResultType(cJRTrackingInfo.getSearchResultType());
                    cJRHomePageItem.setSearchTerm(cJRTrackingInfo.getSearchTerm());
                    cJRHomePageItem.setmContainerInstanceID(cJRTrackingInfo.getContainerID());
                    cJRHomePageItem.setListId(cJRTrackingInfo.getListId());
                    net.one97.paytm.j.a.a(getApplicationContext(), cJRHomePageItem, cJRTrackingInfo.getListName(), cJROrderSummaryProductDetail);
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
        return cJRHomePageItem;
    }

    private void a(long j2, long j3) {
        h hVar = this.ax;
        hVar.a("item_id=" + j2 + "_merchant_id" + j3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x0238 A[Catch:{ Exception -> 0x024d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.ArrayList<net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel> r18, java.lang.String r19) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            r0 = 2131368033(0x7f0a1861, float:1.8356005E38)
            android.view.View r0 = r1.findViewById(r0)     // Catch:{ Exception -> 0x025d }
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4     // Catch:{ Exception -> 0x025d }
            if (r4 == 0) goto L_0x025c
            int r0 = r4.getChildCount()     // Catch:{ Exception -> 0x025d }
            if (r0 <= 0) goto L_0x025c
            r5 = 0
            r0 = 0
        L_0x001a:
            int r6 = r4.getChildCount()     // Catch:{ Exception -> 0x025d }
            if (r0 >= r6) goto L_0x025c
            int r6 = r0 + 1
            int r7 = r4.getChildCount()     // Catch:{ Exception -> 0x025d }
            if (r6 != r7) goto L_0x002a
            r7 = 1
            goto L_0x002b
        L_0x002a:
            r7 = 0
        L_0x002b:
            android.view.View r0 = r4.getChildAt(r0)     // Catch:{ Exception -> 0x025d }
            if (r0 == 0) goto L_0x0039
            java.lang.Object r9 = r0.getTag()     // Catch:{ Exception -> 0x024d }
            if (r9 != 0) goto L_0x0039
            goto L_0x0259
        L_0x0039:
            net.one97.paytm.AJROrderSummaryActivityBase$g r9 = new net.one97.paytm.AJROrderSummaryActivityBase$g     // Catch:{ Exception -> 0x024d }
            r9.<init>()     // Catch:{ Exception -> 0x024d }
            r10 = 2131369990(0x7f0a2006, float:1.8359974E38)
            android.view.View r10 = r0.findViewById(r10)     // Catch:{ Exception -> 0x024d }
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10     // Catch:{ Exception -> 0x024d }
            r9.bn = r10     // Catch:{ Exception -> 0x024d }
            r10 = 2131368671(0x7f0a1adf, float:1.8357299E38)
            android.view.View r10 = r0.findViewById(r10)     // Catch:{ Exception -> 0x024d }
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10     // Catch:{ Exception -> 0x024d }
            r9.bo = r10     // Catch:{ Exception -> 0x024d }
            r10 = 2131368632(0x7f0a1ab8, float:1.835722E38)
            android.view.View r10 = r0.findViewById(r10)     // Catch:{ Exception -> 0x024d }
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10     // Catch:{ Exception -> 0x024d }
            r9.bu = r10     // Catch:{ Exception -> 0x024d }
            r10 = 2131368670(0x7f0a1ade, float:1.8357297E38)
            android.view.View r10 = r0.findViewById(r10)     // Catch:{ Exception -> 0x024d }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x024d }
            r9.br = r10     // Catch:{ Exception -> 0x024d }
            r10 = 2131368631(0x7f0a1ab7, float:1.8357217E38)
            android.view.View r10 = r0.findViewById(r10)     // Catch:{ Exception -> 0x024d }
            android.widget.TextView r10 = (android.widget.TextView) r10     // Catch:{ Exception -> 0x024d }
            r9.bs = r10     // Catch:{ Exception -> 0x024d }
            r10 = 2131367343(0x7f0a15af, float:1.8354605E38)
            android.view.View r10 = r0.findViewById(r10)     // Catch:{ Exception -> 0x024d }
            android.widget.RatingBar r10 = (android.widget.RatingBar) r10     // Catch:{ Exception -> 0x024d }
            r9.bv = r10     // Catch:{ Exception -> 0x024d }
            r10 = 2131370030(0x7f0a202e, float:1.8360055E38)
            android.view.View r10 = r0.findViewById(r10)     // Catch:{ Exception -> 0x024d }
            android.widget.ImageView r10 = (android.widget.ImageView) r10     // Catch:{ Exception -> 0x024d }
            r9.bw = r10     // Catch:{ Exception -> 0x024d }
            r10 = 2131369991(0x7f0a2007, float:1.8359976E38)
            android.view.View r10 = r0.findViewById(r10)     // Catch:{ Exception -> 0x024d }
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10     // Catch:{ Exception -> 0x024d }
            r9.bp = r10     // Catch:{ Exception -> 0x024d }
            java.lang.Object r0 = r0.getTag()     // Catch:{ Exception -> 0x024d }
            r10 = r0
            net.one97.paytm.common.entity.shopping.CJROrderedCart r10 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r10     // Catch:{ Exception -> 0x024d }
            if (r2 == 0) goto L_0x0259
            int r0 = r18.size()     // Catch:{ Exception -> 0x024d }
            if (r0 <= 0) goto L_0x0259
            if (r10 == 0) goto L_0x0259
            r11 = 0
        L_0x00a8:
            int r0 = r18.size()     // Catch:{ Exception -> 0x024d }
            if (r11 >= r0) goto L_0x0259
            long r12 = r10.getId()     // Catch:{ Exception -> 0x024d }
            java.lang.Object r0 = r2.get(r11)     // Catch:{ Exception -> 0x024d }
            net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel r0 = (net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel) r0     // Catch:{ Exception -> 0x024d }
            long r14 = r0.getItemId()     // Catch:{ Exception -> 0x024d }
            java.lang.String r0 = "apiResponse"
            r8 = 8
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x014c
            java.lang.Object r12 = r2.get(r11)     // Catch:{ Exception -> 0x024d }
            net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel r12 = (net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel) r12     // Catch:{ Exception -> 0x024d }
            boolean r12 = r12.getIsRated()     // Catch:{ Exception -> 0x024d }
            if (r12 == 0) goto L_0x014c
            if (r10 == 0) goto L_0x00e5
            boolean r0 = r3.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0136 }
            if (r0 == 0) goto L_0x00e5
            java.lang.String r0 = r10.getSellerRatingFromCache()     // Catch:{ Exception -> 0x0136 }
            if (r0 == 0) goto L_0x00e5
            boolean r0 = r10.getIsSellerRatingUpdatedFromCache()     // Catch:{ Exception -> 0x0136 }
            if (r0 == 0) goto L_0x00e5
            goto L_0x0142
        L_0x00e5:
            android.widget.LinearLayout r0 = r9.bo     // Catch:{ Exception -> 0x0136 }
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x0136 }
            android.widget.RelativeLayout r0 = r9.bu     // Catch:{ Exception -> 0x0136 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0136 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r10.getProductDetail()     // Catch:{ Exception -> 0x0136 }
            if (r0 == 0) goto L_0x0142
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r0 = r10.getProductDetail()     // Catch:{ Exception -> 0x0136 }
            java.lang.String r0 = r0.getMerchantName()     // Catch:{ Exception -> 0x0136 }
            if (r0 == 0) goto L_0x0142
            android.widget.TextView r0 = r9.br     // Catch:{ Exception -> 0x0136 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0136 }
            r8.<init>()     // Catch:{ Exception -> 0x0136 }
            android.content.res.Resources r12 = r17.getResources()     // Catch:{ Exception -> 0x0136 }
            r13 = 2131960084(0x7f132114, float:1.9556827E38)
            java.lang.String r12 = r12.getString(r13)     // Catch:{ Exception -> 0x0136 }
            r8.append(r12)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r12 = " "
            r8.append(r12)     // Catch:{ Exception -> 0x0136 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r12 = r10.getProductDetail()     // Catch:{ Exception -> 0x0136 }
            java.lang.String r12 = r12.getMerchantName()     // Catch:{ Exception -> 0x0136 }
            r8.append(r12)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0136 }
            r0.setText(r8)     // Catch:{ Exception -> 0x0136 }
            android.widget.TextView r0 = r9.br     // Catch:{ Exception -> 0x0136 }
            net.one97.paytm.AJROrderSummaryActivityBase$48 r8 = new net.one97.paytm.AJROrderSummaryActivityBase$48     // Catch:{ Exception -> 0x0136 }
            r8.<init>(r10)     // Catch:{ Exception -> 0x0136 }
            r0.setOnClickListener(r8)     // Catch:{ Exception -> 0x0136 }
            goto L_0x0142
        L_0x0136:
            r0 = move-exception
            boolean r8 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x024d }
            if (r8 == 0) goto L_0x0142
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x024d }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x024d }
        L_0x0142:
            android.widget.LinearLayout r0 = r9.bn     // Catch:{ Exception -> 0x024d }
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x024d }
            r1.a((boolean) r7, (net.one97.paytm.AJROrderSummaryActivityBase.g) r9)     // Catch:{ Exception -> 0x024d }
            goto L_0x0248
        L_0x014c:
            long r12 = r10.getId()     // Catch:{ Exception -> 0x024d }
            java.lang.Object r14 = r2.get(r11)     // Catch:{ Exception -> 0x024d }
            net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel r14 = (net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel) r14     // Catch:{ Exception -> 0x024d }
            long r14 = r14.getItemId()     // Catch:{ Exception -> 0x024d }
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x0248
            java.lang.Object r12 = r2.get(r11)     // Catch:{ Exception -> 0x024d }
            net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel r12 = (net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel) r12     // Catch:{ Exception -> 0x024d }
            boolean r12 = r12.getIsRated()     // Catch:{ Exception -> 0x024d }
            if (r12 != 0) goto L_0x0248
            java.lang.Object r12 = r2.get(r11)     // Catch:{ Exception -> 0x024d }
            net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel r12 = (net.one97.paytm.common.entity.SellerRating.CJROrderSummaryRatingModel) r12     // Catch:{ Exception -> 0x024d }
            if (r12 == 0) goto L_0x022c
            android.widget.LinearLayout r13 = r9.bo     // Catch:{ Exception -> 0x0229 }
            r13.setVisibility(r8)     // Catch:{ Exception -> 0x0229 }
            android.widget.RelativeLayout r13 = r9.bu     // Catch:{ Exception -> 0x0229 }
            r13.setVisibility(r5)     // Catch:{ Exception -> 0x0229 }
            android.widget.RelativeLayout r13 = r9.bu     // Catch:{ Exception -> 0x0229 }
            net.one97.paytm.AJROrderSummaryActivityBase$47 r14 = new net.one97.paytm.AJROrderSummaryActivityBase$47     // Catch:{ Exception -> 0x0229 }
            r14.<init>(r12, r10)     // Catch:{ Exception -> 0x0229 }
            r13.setOnClickListener(r14)     // Catch:{ Exception -> 0x0229 }
            if (r10 == 0) goto L_0x01f3
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r13 = r10.getProductDetail()     // Catch:{ Exception -> 0x0229 }
            if (r13 == 0) goto L_0x01f3
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r13 = r10.getProductDetail()     // Catch:{ Exception -> 0x0229 }
            java.lang.String r13 = r13.getMerchantName()     // Catch:{ Exception -> 0x0229 }
            if (r13 == 0) goto L_0x01f3
            boolean r0 = r3.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0229 }
            if (r0 == 0) goto L_0x01d4
            net.one97.paytm.h r0 = r1.ax     // Catch:{ Exception -> 0x0229 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0229 }
            java.lang.String r13 = "item_id= "
            r8.<init>(r13)     // Catch:{ Exception -> 0x0229 }
            long r13 = r10.getId()     // Catch:{ Exception -> 0x0229 }
            r8.append(r13)     // Catch:{ Exception -> 0x0229 }
            java.lang.String r13 = "_merchant_id= "
            r8.append(r13)     // Catch:{ Exception -> 0x0229 }
            long r13 = r10.getMerchantId()     // Catch:{ Exception -> 0x0229 }
            r8.append(r13)     // Catch:{ Exception -> 0x0229 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0229 }
            android.content.Context r0 = r0.f52402a     // Catch:{ Exception -> 0x0229 }
            java.lang.String r13 = "seller_rating_list_"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0229 }
            java.lang.String r8 = r13.concat(r8)     // Catch:{ Exception -> 0x0229 }
            net.one97.paytm.common.utility.c.b(r0, r8)     // Catch:{ Exception -> 0x0229 }
            r10.setIsSellerRatingUpdatedFromCache(r5)     // Catch:{ Exception -> 0x0229 }
            r0 = 0
            r10.setSellerRatingFromCache(r0)     // Catch:{ Exception -> 0x0229 }
        L_0x01d4:
            android.widget.TextView r0 = r9.bs     // Catch:{ Exception -> 0x0229 }
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x0229 }
            android.widget.TextView r0 = r9.bs     // Catch:{ Exception -> 0x0229 }
            r8 = 2131960100(0x7f132124, float:1.955686E38)
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0229 }
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r13 = r10.getProductDetail()     // Catch:{ Exception -> 0x0229 }
            java.lang.String r13 = r13.getMerchantName()     // Catch:{ Exception -> 0x0229 }
            r14[r5] = r13     // Catch:{ Exception -> 0x0229 }
            java.lang.String r8 = r1.getString(r8, r14)     // Catch:{ Exception -> 0x0229 }
            r0.setText(r8)     // Catch:{ Exception -> 0x0229 }
            goto L_0x01f8
        L_0x01f3:
            android.widget.TextView r0 = r9.bs     // Catch:{ Exception -> 0x0229 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0229 }
        L_0x01f8:
            android.widget.RatingBar r0 = r9.bv     // Catch:{ Exception -> 0x0229 }
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x0229 }
            float r0 = r12.getProductDescRating()     // Catch:{ Exception -> 0x0229 }
            float r8 = r12.getProductPackagingRating()     // Catch:{ Exception -> 0x0229 }
            float r12 = r12.getProductDeliveryRating()     // Catch:{ Exception -> 0x0229 }
            float r0 = r0 + r8
            float r0 = r0 + r12
            r8 = 1077936128(0x40400000, float:3.0)
            float r0 = r0 / r8
            java.lang.String r8 = "cache"
            boolean r8 = r3.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x0229 }
            if (r8 == 0) goto L_0x0222
            r12 = 1
            r10.setIsSellerRatingUpdatedFromCache(r12)     // Catch:{ Exception -> 0x0233 }
            java.lang.String r8 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0233 }
            r10.setSellerRatingFromCache(r8)     // Catch:{ Exception -> 0x0233 }
            goto L_0x0223
        L_0x0222:
            r12 = 1
        L_0x0223:
            android.widget.RatingBar r8 = r9.bv     // Catch:{ Exception -> 0x0233 }
            r8.setRating(r0)     // Catch:{ Exception -> 0x0233 }
            goto L_0x023f
        L_0x0229:
            r0 = move-exception
            r12 = 1
            goto L_0x0234
        L_0x022c:
            r12 = 1
            android.widget.RatingBar r0 = r9.bv     // Catch:{ Exception -> 0x0233 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x0233 }
            goto L_0x023f
        L_0x0233:
            r0 = move-exception
        L_0x0234:
            boolean r8 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x024d }
            if (r8 == 0) goto L_0x023f
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x024d }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x024d }
        L_0x023f:
            android.widget.LinearLayout r0 = r9.bn     // Catch:{ Exception -> 0x024d }
            r0.setVisibility(r5)     // Catch:{ Exception -> 0x024d }
            r1.a((boolean) r7, (net.one97.paytm.AJROrderSummaryActivityBase.g) r9)     // Catch:{ Exception -> 0x024d }
            goto L_0x0249
        L_0x0248:
            r12 = 1
        L_0x0249:
            int r11 = r11 + 1
            goto L_0x00a8
        L_0x024d:
            r0 = move-exception
            boolean r7 = com.paytm.utility.b.v     // Catch:{ Exception -> 0x025d }
            if (r7 == 0) goto L_0x0259
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x025d }
            com.paytm.utility.q.b(r0)     // Catch:{ Exception -> 0x025d }
        L_0x0259:
            r0 = r6
            goto L_0x001a
        L_0x025c:
            return
        L_0x025d:
            r0 = move-exception
            boolean r2 = com.paytm.utility.b.v
            if (r2 == 0) goto L_0x0269
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0269:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.a(java.util.ArrayList, java.lang.String):void");
    }

    private void a(boolean z, g gVar) {
        int u = (int) (((double) com.paytm.utility.a.u(this)) * 1.5d);
        if (z) {
            gVar.bw.setVisibility(0);
            gVar.bp.setPadding(0, 0, 0, u);
            return;
        }
        gVar.bw.setVisibility(8);
        gVar.bp.setPadding(0, 0, 0, 0);
    }

    /* access modifiers changed from: protected */
    public final void a(CJROrderSummaryRatingModel cJROrderSummaryRatingModel, CJROrderedCart cJROrderedCart, CJRSellerRatings cJRSellerRatings) {
        AlertDialog.Builder builder;
        if (com.paytm.utility.b.d() >= 11) {
            builder = new AlertDialog.Builder(this, 3);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        View b2 = b(cJROrderSummaryRatingModel, cJROrderedCart, cJRSellerRatings);
        if (b2 != null) {
            builder.setView(b2);
            builder.show();
        }
    }

    private View b(CJROrderSummaryRatingModel cJROrderSummaryRatingModel, CJROrderedCart cJROrderedCart, CJRSellerRatings cJRSellerRatings) {
        try {
            ScrollView scrollView = new ScrollView(this);
            scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setOrientation(1);
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout2.setOrientation(1);
            RelativeLayout relativeLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.seller_rating_name_layout, (ViewGroup) null);
            TextView textView = (TextView) relativeLayout.findViewById(R.id.rating_merchant_name);
            if (cJROrderedCart != null) {
                CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
                if (productDetail != null && !TextUtils.isEmpty(productDetail.getMerchantName())) {
                    textView.setText(productDetail.getMerchantName());
                }
            } else {
                textView.setVisibility(8);
            }
            ((TextView) relativeLayout.findViewById(R.id.rating_visit_store)).setVisibility(8);
            linearLayout2.addView(relativeLayout);
            View view = new View(this);
            view.setBackgroundColor(getResources().getColor(R.color.gray));
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            layoutParams.width = -1;
            layoutParams.height = 1;
            view.setLayoutParams(layoutParams);
            linearLayout2.addView(view);
            if (!(cJROrderedCart.getMerchantAdress() == null || cJROrderedCart.getMerchantAdress().isEmpty() || cJROrderedCart.getMerchantAdress() == null)) {
                LinearLayout linearLayout3 = (LinearLayout) getLayoutInflater().inflate(R.layout.merchant_address_lyt, (ViewGroup) null);
                String str = "";
                try {
                    if (cJROrderedCart.getMerchantAdress().containsKey(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS)) {
                        str = net.one97.paytm.utils.q.a(cJROrderedCart.getMerchantAdress().get(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS));
                    }
                    if (cJROrderedCart.getMerchantAdress().containsKey("state")) {
                        String str2 = cJROrderedCart.getMerchantAdress().get("state");
                        if (cJROrderedCart.getMerchantAdress().containsKey("city")) {
                            String str3 = cJROrderedCart.getMerchantAdress().get("city");
                            if (str2 != null && !str2.equalsIgnoreCase(str3) && !TextUtils.isEmpty(str3)) {
                                str = str + StringUtility.NEW_LINE + net.one97.paytm.utils.q.a(str3);
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            str = str + StringUtility.NEW_LINE + net.one97.paytm.utils.q.a(str2);
                        }
                    }
                    if (cJROrderedCart.getMerchantAdress().containsKey("pin_code") && !TextUtils.isEmpty(cJROrderedCart.getMerchantAdress().get("pin_code"))) {
                        str = str + StringUtility.NEW_LINE + cJROrderedCart.getMerchantAdress().get("pin_code");
                    }
                    TextView textView2 = new TextView(this);
                    textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    textView2.setText(str);
                    textView2.setTextColor(getResources().getColor(R.color.cart_black));
                    textView2.setTextSize(12.0f);
                    linearLayout3.addView(textView2);
                    linearLayout2.addView(linearLayout3);
                } catch (Exception unused) {
                    return null;
                }
            }
            linearLayout.addView(linearLayout2);
            if (!(cJROrderSummaryRatingModel == null && cJRSellerRatings == null)) {
                View view2 = new View(this);
                view2.setBackgroundColor(getResources().getColor(R.color.gray));
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
                layoutParams2.width = -1;
                layoutParams2.height = 1;
                view2.setLayoutParams(layoutParams2);
                linearLayout.addView(view2);
                try {
                    LinearLayout linearLayout4 = (LinearLayout) getLayoutInflater().inflate(R.layout.pdp_sellecr_rating_detail_lyt, (ViewGroup) null);
                    int i2 = R.layout.seller_rating_detail_pdp;
                    if (cJROrderSummaryRatingModel != null) {
                        LinearLayout linearLayout5 = (LinearLayout) linearLayout4.findViewById(R.id.seller_rating_lyt);
                        int i3 = 0;
                        while (i3 < 3) {
                            try {
                                View inflate = getLayoutInflater().inflate(R.layout.seller_rating_detail_pdp, (ViewGroup) null);
                                TextView textView3 = (TextView) inflate.findViewById(R.id.pdp_rating_desc);
                                TextView textView4 = (TextView) inflate.findViewById(R.id.pdp_rating_number);
                                RatingBar ratingBar = (RatingBar) inflate.findViewById(R.id.rating_bar_detail_pdp);
                                ratingBar.setNumStars(5);
                                if (i3 == 0) {
                                    textView3.setText(getResources().getString(R.string.product_as_described_txt));
                                    textView4.setText(String.valueOf(cJROrderSummaryRatingModel.getProductDescRating()));
                                    ratingBar.setRating(cJROrderSummaryRatingModel.getProductDescRating());
                                } else if (i3 == 1) {
                                    textView3.setText(getResources().getString(R.string.packaging_handling_txt));
                                    textView4.setText(String.valueOf(cJROrderSummaryRatingModel.getProductPackagingRating()));
                                    ratingBar.setRating(cJROrderSummaryRatingModel.getProductPackagingRating());
                                } else {
                                    textView3.setText(getResources().getString(R.string.timely_delivery_txt));
                                    textView4.setText(String.valueOf(cJROrderSummaryRatingModel.getProductDeliveryRating()));
                                    ratingBar.setRating(cJROrderSummaryRatingModel.getProductDeliveryRating());
                                }
                                LayerDrawable layerDrawable = (LayerDrawable) ratingBar.getProgressDrawable();
                                layerDrawable.getDrawable(2).setColorFilter(getResources().getColor(R.color.orange_promo_msg), PorterDuff.Mode.SRC_ATOP);
                                layerDrawable.getDrawable(1).setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
                                layerDrawable.getDrawable(0).setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
                                inflate.invalidate();
                                linearLayout5.addView(inflate);
                                i3++;
                            } catch (Exception unused2) {
                                return null;
                            }
                        }
                    } else if (cJRSellerRatings != null) {
                        LinearLayout linearLayout6 = (LinearLayout) linearLayout4.findViewById(R.id.seller_rating_lyt);
                        List<CJRSellerRatingProp> data = cJRSellerRatings.getData();
                        int i4 = 0;
                        while (i4 < data.size()) {
                            CJRSellerRatingProp cJRSellerRatingProp = data.get(i4);
                            try {
                                View inflate2 = getLayoutInflater().inflate(i2, (ViewGroup) null);
                                TextView textView5 = (TextView) inflate2.findViewById(R.id.pdp_rating_desc);
                                TextView textView6 = (TextView) inflate2.findViewById(R.id.pdp_rating_number);
                                RatingBar ratingBar2 = (RatingBar) inflate2.findViewById(R.id.rating_bar_detail_pdp);
                                ratingBar2.setNumStars(5);
                                textView5.setText(cJRSellerRatingProp.getmText());
                                textView5.setTextSize(12.0f);
                                textView6.setText(cJRSellerRatingProp.getmRating());
                                textView6.setTextSize(12.0f);
                                ratingBar2.setRating(Float.parseFloat(cJRSellerRatingProp.getmRating()));
                                LayerDrawable layerDrawable2 = (LayerDrawable) ratingBar2.getProgressDrawable();
                                layerDrawable2.getDrawable(2).setColorFilter(getResources().getColor(R.color.orange_promo_msg), PorterDuff.Mode.SRC_ATOP);
                                layerDrawable2.getDrawable(1).setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
                                layerDrawable2.getDrawable(0).setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
                                inflate2.invalidate();
                                linearLayout6.addView(inflate2);
                                i4++;
                                i2 = R.layout.seller_rating_detail_pdp;
                            } catch (Exception unused3) {
                                return null;
                            }
                        }
                    }
                    linearLayout.addView(linearLayout4);
                } catch (Exception unused4) {
                    return null;
                }
            }
            linearLayout.setPadding(0, 0, 0, 30);
            scrollView.addView(linearLayout);
            return scrollView;
        } catch (Exception unused5) {
            return null;
        }
    }

    private static String m(String str) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.add(5, Integer.parseInt(str.split("\\s")[0]));
            return new SimpleDateFormat("MMMM dd-yyyy  hh:mm a").format(instance.getTime());
        } catch (Exception e2) {
            if (!com.paytm.utility.b.v) {
                return "";
            }
            q.b(e2.getMessage());
            return "";
        }
    }

    private void a(final CJROrderedCart cJROrderedCart, Button button, Button button2, final TextView textView, final boolean z) {
        textView.setText(Html.fromHtml("<u>" + getResources().getString(R.string.order_summary_select_txt) + "</u"));
        this.ah = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.automatic_recharge_duration)));
        this.at = this.ah.get(0);
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJROrderSummaryActivityBase.this.a(textView);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (textView.getText().toString() != null && textView.getText().toString().equalsIgnoreCase(AJROrderSummaryActivityBase.this.getResources().getString(R.string.order_summary_select_txt))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AJROrderSummaryActivityBase.this);
                    builder.setTitle(AJROrderSummaryActivityBase.this.getResources().getString(R.string.automatic_interval_alert_header));
                    builder.setMessage(AJROrderSummaryActivityBase.this.getResources().getString(R.string.automatic_interval_alert_message)).setCancelable(false);
                    builder.setPositiveButton(AJROrderSummaryActivityBase.this.getResources().getString(R.string.order_summary_got_it_txt), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    builder.show();
                } else if (z) {
                    AJROrderSummaryActivityBase.a(AJROrderSummaryActivityBase.this, textView.getText().toString(), cJROrderedCart, "");
                } else {
                    AJROrderSummaryActivityBase.a(AJROrderSummaryActivityBase.this, textView.getText().toString(), cJROrderedCart);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(AJROrderSummaryActivityBase.this, AJRWebViewActivity.class);
                net.one97.paytm.j.c.a();
                intent.putExtra("url", net.one97.paytm.j.c.a("automaticLink", (String) null));
                intent.putExtra("title", AJROrderSummaryActivityBase.this.getResources().getString(R.string.paytm_automatic));
                intent.putExtra("hide_webview_zoom", true);
                AJROrderSummaryActivityBase.this.startActivity(intent);
            }
        });
    }

    private void a(TextView textView, CJROrderedCart cJROrderedCart, String str) {
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText(cJROrderedCart.getStatus());
        }
        b.a aVar = net.one97.paytm.recharge.ordersummary.widget.b.f64553e;
        if (b.a.a(this.J)) {
            b.a aVar2 = net.one97.paytm.recharge.ordersummary.widget.b.f64553e;
            if (b.a.b(this.J)) {
                textView.setText(getResources().getString(R.string.imps_os__cancelled));
            }
        }
        if (g(cJROrderedCart) || "Successful".equalsIgnoreCase(cJROrderedCart.getStatus()) || "BOOKED".equalsIgnoreCase(cJROrderedCart.getStatus())) {
            textView.setBackgroundResource(R.drawable.successful_order_background);
            if (ag()) {
                RoboButton roboButton = (RoboButton) findViewById(R.id.btn_go_to_wifi_dashboard);
                roboButton.setEnabled(true);
                roboButton.setClickable(true);
            }
        } else if (c(this.J) || h(cJROrderedCart)) {
            textView.setBackgroundResource(R.drawable.failed_order_background);
        } else {
            long verticalId = this.J.getOrderedCartList().get(0).getProductDetail().getVerticalId();
            long j2 = 0;
            if (this.J.getOrderedCartList().size() > 1 && this.J.getOrderedCartList().get(1).getProductDetail() != null) {
                j2 = this.J.getOrderedCartList().get(1).getProductDetail().getVerticalId();
            }
            if ((verticalId == 131 || j2 == 131) && cJROrderedCart.getStatus().equalsIgnoreCase("DELIVERED AND GRATIFIED")) {
                textView.setTextSize((float) com.paytm.utility.b.c(3));
            }
            textView.setBackgroundResource(R.drawable.inprogress_order_background);
        }
    }

    private static void a(String str, String str2, TextView textView) {
        if (!str.isEmpty() && !str2.isEmpty()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (str2.length() > str.length()) {
                layoutParams.addRule(0, R.id.price);
                textView.setLayoutParams(layoutParams);
            }
        }
    }

    private void a(TextView textView, String str, String str2) {
        if (!str.equalsIgnoreCase("null")) {
            textView.setText(str);
            if (str2.equalsIgnoreCase("red")) {
                textView.setTextColor(getResources().getColor(R.color.ledger_status_failure));
            }
        }
    }

    private static void a(ImageView imageView, String str, Boolean bool, Boolean bool2) {
        if (!bool.booleanValue() && !bool2.booleanValue()) {
            imageView.setImageResource(R.drawable.status_flow_normal);
        } else if (bool.booleanValue()) {
            imageView.setImageResource(R.drawable.round_grey_button);
        } else if (str == null || bool.booleanValue() || !str.equalsIgnoreCase("red") || !bool2.booleanValue()) {
            if (!bool.booleanValue()) {
                bool2.booleanValue();
            }
            imageView.setImageResource(R.drawable.status_flow_final);
        } else {
            imageView.setImageResource(R.drawable.status_flow_cancel);
        }
    }

    private void a(TextView textView, String str) {
        if (str != null && !str.equalsIgnoreCase("null")) {
            if (!str.equalsIgnoreCase("null")) {
                textView.setText(getResources().getString(R.string.order_summary_est_by_txt) + StringUtility.NEW_LINE + c(str, "statusFlow"));
                return;
            }
            textView.setTextColor(getResources().getColor(R.color.white));
        }
    }

    private void a(final g gVar, CJROrderedCart cJROrderedCart, final TextView textView) {
        boolean z;
        CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        CJROrderSummaryAction tapAction = cJROrderedCart.getTapAction();
        if (TextUtils.isEmpty(cJROrderedCart.getPromoText()) || TextUtils.isEmpty(cJROrderedCart.getPromoText().trim()) || cJROrderedCart.getPromoCode() == null || TextUtils.isEmpty(cJROrderedCart.getPromoCode()) || Q()) {
            gVar.s.setVisibility(8);
            z = false;
        } else {
            gVar.j.setText(cJROrderedCart.getPromoCode());
            gVar.f51626i.setText(cJROrderedCart.getPromoText());
            gVar.s.setVisibility(0);
            z = true;
        }
        if (Q()) {
            gVar.s.setVisibility(8);
        }
        if (productDetail == null || TextUtils.isEmpty(productDetail.getPromoText()) || TextUtils.isEmpty(productDetail.getPromoText().trim())) {
            gVar.r.setVisibility(8);
        } else {
            gVar.k.setText(productDetail.getPromoText());
            gVar.r.setVisibility(0);
            if (!Q()) {
                gVar.bd.setVisibility(0);
            }
            z = true;
        }
        if (tapAction == null && cJROrderedCart.getAction() == null && cJROrderedCart.getTapActions() == null && TextUtils.isEmpty(cJROrderedCart.getTapActionMessage()) && !z) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up, 0);
        }
        if (tapAction == null || TextUtils.isEmpty(tapAction.getMessage())) {
            gVar.l.setVisibility(8);
        } else {
            gVar.l.setText(tapAction.getMessage());
            gVar.l.setVisibility(0);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (gVar.x.getVisibility() == 0) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down, 0);
                    gVar.x.setVisibility(8);
                    return;
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up, 0);
                gVar.x.setVisibility(0);
            }
        });
    }

    private static boolean f(CJROrderedCart cJROrderedCart) {
        CJROrderSummaryProductDetail productDetail;
        if (cJROrderedCart == null || cJROrderedCart.getProductDetail() == null || (productDetail = cJROrderedCart.getProductDetail()) == null || productDetail == null || TextUtils.isEmpty(productDetail.getProductType()) || !productDetail.getProductType().equalsIgnoreCase("Recharge")) {
            return false;
        }
        return true;
    }

    private boolean N() {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary == null || (orderedCartList = cJROrderSummary.getOrderedCartList()) == null || orderedCartList.size() <= 0) {
            return false;
        }
        return f(orderedCartList.get(0));
    }

    /* access modifiers changed from: private */
    public boolean O() {
        CJROrderSummaryProductDetail productDetail;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary == null) {
            return false;
        }
        ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
        if (orderedCartList == null || orderedCartList.size() <= 0 || (productDetail = orderedCartList.get(0).getProductDetail()) == null || TextUtils.isEmpty(productDetail.getProductType()) || productDetail.getProductType().equalsIgnoreCase("Marketplace")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean P() {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummaryProductDetail productDetail;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null && (orderedCartList = cJROrderSummary.getOrderedCartList()) != null && orderedCartList.size() > 0 && (productDetail = orderedCartList.get(0).getProductDetail()) != null && !TextUtils.isEmpty(productDetail.getProductType()) && !TextUtils.isEmpty(productDetail.getVertical()) && productDetail.getProductType().equalsIgnoreCase("Marketplace") && productDetail.getVertical().equalsIgnoreCase("Tickets")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean d() {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummaryProductDetail productDetail;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null && (orderedCartList = cJROrderSummary.getOrderedCartList()) != null && orderedCartList.size() > 0 && (productDetail = orderedCartList.get(0).getProductDetail()) != null && !TextUtils.isEmpty(productDetail.getName()) && !TextUtils.isEmpty(productDetail.getVertical()) && productDetail.getProductType().equalsIgnoreCase("Marketplace") && (productDetail.getVertical().equalsIgnoreCase("Digital Gold") || productDetail.getVertical().equalsIgnoreCase("Digital Gold Buy") || productDetail.getVertical().equalsIgnoreCase("Digital Gold Sell") || productDetail.getVertical().toLowerCase(Locale.getDefault()).contains("gold"))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean Q() {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummaryProductDetail productDetail;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null && (orderedCartList = cJROrderSummary.getOrderedCartList()) != null && orderedCartList.size() > 0 && (productDetail = orderedCartList.get(0).getProductDetail()) != null && !TextUtils.isEmpty(productDetail.getProductType()) && !TextUtils.isEmpty(productDetail.getVertical()) && productDetail.getProductType().equalsIgnoreCase("Marketplace") && productDetail.getVertical().equalsIgnoreCase("Movie Tickets")) {
            return true;
        }
        return false;
    }

    private boolean R() {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummaryProductDetail productDetail;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null && (orderedCartList = cJROrderSummary.getOrderedCartList()) != null && orderedCartList.size() > 0 && (productDetail = orderedCartList.get(0).getProductDetail()) != null && !TextUtils.isEmpty(productDetail.getProductType()) && !TextUtils.isEmpty(productDetail.getVertical()) && productDetail.getProductType().equalsIgnoreCase("Marketplace") && productDetail.getVertical().equalsIgnoreCase("Trains")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean S() {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummaryProductDetail productDetail;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null && (orderedCartList = cJROrderSummary.getOrderedCartList()) != null && orderedCartList.size() > 0 && (productDetail = orderedCartList.get(0).getProductDetail()) != null && !TextUtils.isEmpty(productDetail.getProductType()) && !TextUtils.isEmpty(productDetail.getVertical()) && productDetail.getProductType().equalsIgnoreCase("Marketplace") && productDetail.getVertical().equalsIgnoreCase("Paytm Hotel")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean T() {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummaryProductDetail productDetail;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null && (orderedCartList = cJROrderSummary.getOrderedCartList()) != null && orderedCartList.size() > 0 && (productDetail = orderedCartList.get(0).getProductDetail()) != null && !TextUtils.isEmpty(productDetail.getProductType()) && !TextUtils.isEmpty(productDetail.getVertical()) && productDetail.getProductType().equalsIgnoreCase("Marketplace") && productDetail.getVertical().equalsIgnoreCase("Flights")) {
            return true;
        }
        return false;
    }

    private boolean U() {
        ArrayList<CJROrderedCart> orderedCartList;
        CJROrderSummaryProductDetail productDetail;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null && (orderedCartList = cJROrderSummary.getOrderedCartList()) != null && orderedCartList.size() > 0 && (productDetail = orderedCartList.get(0).getProductDetail()) != null && !TextUtils.isEmpty(productDetail.getProductType()) && !TextUtils.isEmpty(productDetail.getVertical()) && productDetail.getProductType().equalsIgnoreCase("Marketplace") && productDetail.getVertical().equalsIgnoreCase("Movie Tickets")) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:8|9|10|(1:12)(2:13|(1:15))|16|17|(2:21|(2:26|(2:28|(2:30|68)(5:31|32|(3:35|36|(1:38)(2:39|(2:44|(3:46|(1:48)(2:49|(1:51)(2:52|(1:57)(1:56)))|(2:59|66)(2:60|64))(1:65))(1:43)))|34|(0)(0)))(1:67))(1:25))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0063 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086 A[Catch:{ Exception -> 0x00f3 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0089 A[Catch:{ Exception -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c4 A[Catch:{ Exception -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[Catch:{ Exception -> 0x00f3 }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String V() {
        /*
            r8 = this;
            java.lang.String r0 = "PENDING"
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r8.J
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.String r1 = r8.L     // Catch:{ Exception -> 0x00f3 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00f3 }
            if (r1 != 0) goto L_0x00fb
            java.lang.String r1 = r8.L     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r3 = "Payment"
            boolean r1 = r1.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x00f3 }
            if (r1 == 0) goto L_0x00fb
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r8.J     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r3 = r8.aS     // Catch:{ Exception -> 0x0063 }
            java.lang.String r4 = r1.getId()     // Catch:{ Exception -> 0x0063 }
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0063 }
            if (r3 == 0) goto L_0x0029
            goto L_0x0063
        L_0x0029:
            java.lang.String r3 = r1.getId()     // Catch:{ Exception -> 0x0063 }
            r8.aS = r3     // Catch:{ Exception -> 0x0063 }
            boolean r3 = r8.P()     // Catch:{ Exception -> 0x0063 }
            if (r3 == 0) goto L_0x0063
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0063 }
            r3.<init>()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r4 = "bus_payment_type"
            java.lang.String r5 = r1.getPaymentMethodForGA()     // Catch:{ Exception -> 0x0063 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r4 = "bus_summary_payment_successful"
            android.content.Context r5 = r8.getApplicationContext()     // Catch:{ Exception -> 0x0063 }
            net.one97.paytm.j.a.b((java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.Object>) r3, (android.content.Context) r5)     // Catch:{ Exception -> 0x0063 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0063 }
            r3.<init>()     // Catch:{ Exception -> 0x0063 }
            java.lang.String r4 = "bus_order_status"
            java.lang.String r1 = r1.getStatus()     // Catch:{ Exception -> 0x0063 }
            r3.put(r4, r1)     // Catch:{ Exception -> 0x0063 }
            java.lang.String r1 = "bus_summary_order_status"
            android.content.Context r4 = r8.getApplicationContext()     // Catch:{ Exception -> 0x0063 }
            net.one97.paytm.j.a.b((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.Object>) r3, (android.content.Context) r4)     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r1 = r8.J     // Catch:{ Exception -> 0x00f3 }
            java.util.ArrayList r1 = r1.getOrderedCartList()     // Catch:{ Exception -> 0x00f3 }
            if (r1 == 0) goto L_0x00fb
            int r3 = r1.size()     // Catch:{ Exception -> 0x00f3 }
            if (r3 <= 0) goto L_0x00fb
            r3 = 0
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x00f3 }
            net.one97.paytm.common.entity.shopping.CJROrderedCart r1 = (net.one97.paytm.common.entity.shopping.CJROrderedCart) r1     // Catch:{ Exception -> 0x00f3 }
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r8.J     // Catch:{ Exception -> 0x00f3 }
            boolean r4 = b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r4)     // Catch:{ Exception -> 0x00f3 }
            if (r4 == 0) goto L_0x0089
            boolean r4 = g((net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)     // Catch:{ Exception -> 0x00f3 }
            if (r4 == 0) goto L_0x0089
            java.lang.String r0 = "SUCCESS"
            return r0
        L_0x0089:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r8.J     // Catch:{ Exception -> 0x00f3 }
            boolean r4 = c((net.one97.paytm.common.entity.shopping.CJROrderSummary) r4)     // Catch:{ Exception -> 0x00f3 }
            if (r4 != 0) goto L_0x00f0
            boolean r4 = h((net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)     // Catch:{ Exception -> 0x00f3 }
            if (r4 == 0) goto L_0x0098
            goto L_0x00f0
        L_0x0098:
            net.one97.paytm.common.entity.shopping.CJROrderSummary r4 = r8.J     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r5 = r4.getPaymentStatus()     // Catch:{ Exception -> 0x00f3 }
            boolean r5 = r0.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r6 = "PROCESSING"
            r7 = 1
            if (r5 == 0) goto L_0x00a9
        L_0x00a7:
            r4 = 1
            goto L_0x00c2
        L_0x00a9:
            java.lang.String r5 = r4.getPaymentStatus()     // Catch:{ Exception -> 0x00f3 }
            boolean r5 = r6.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x00f3 }
            if (r5 == 0) goto L_0x00b4
            goto L_0x00a7
        L_0x00b4:
            boolean r5 = b((net.one97.paytm.common.entity.shopping.CJROrderSummary) r4)     // Catch:{ Exception -> 0x00f3 }
            if (r5 != 0) goto L_0x00c1
            boolean r4 = c((net.one97.paytm.common.entity.shopping.CJROrderSummary) r4)     // Catch:{ Exception -> 0x00f3 }
            if (r4 != 0) goto L_0x00c1
            goto L_0x00a7
        L_0x00c1:
            r4 = 0
        L_0x00c2:
            if (r4 != 0) goto L_0x00ef
            java.lang.String r4 = r1.getStatus()     // Catch:{ Exception -> 0x00f3 }
            boolean r4 = r0.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x00f3 }
            if (r4 == 0) goto L_0x00cf
            goto L_0x00e8
        L_0x00cf:
            java.lang.String r4 = r1.getStatus()     // Catch:{ Exception -> 0x00f3 }
            boolean r4 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x00f3 }
            if (r4 == 0) goto L_0x00da
            goto L_0x00e8
        L_0x00da:
            boolean r4 = g((net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)     // Catch:{ Exception -> 0x00f3 }
            if (r4 != 0) goto L_0x00e7
            boolean r4 = h((net.one97.paytm.common.entity.shopping.CJROrderedCart) r1)     // Catch:{ Exception -> 0x00f3 }
            if (r4 != 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r7 = 0
        L_0x00e8:
            if (r7 == 0) goto L_0x00eb
            goto L_0x00ef
        L_0x00eb:
            java.lang.String r0 = r1.getStatus()     // Catch:{ Exception -> 0x00f3 }
        L_0x00ef:
            return r0
        L_0x00f0:
            java.lang.String r0 = "FAILED"
            return r0
        L_0x00f3:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x00fb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.V():java.lang.String");
    }

    private String W() {
        ArrayList<CJROrderedCart> orderedCartList;
        if (this.J == null) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(this.L) && this.L.equalsIgnoreCase("Payment") && (orderedCartList = this.J.getOrderedCartList()) != null && orderedCartList.size() > 0) {
                return orderedCartList.get(0).getItemStatus();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return null;
    }

    private static boolean b(CJROrderSummary cJROrderSummary) {
        if (!"SUCCESS".equalsIgnoreCase(cJROrderSummary.getPaymentStatus()) && cJROrderSummary.getOrderStatus() != 2) {
            return false;
        }
        return true;
    }

    private static boolean c(CJROrderSummary cJROrderSummary) {
        int orderStatus;
        if ("FAILED".equalsIgnoreCase(cJROrderSummary.getPaymentStatus()) || (orderStatus = cJROrderSummary.getOrderStatus()) == 4 || orderStatus == 8) {
            return true;
        }
        return false;
    }

    private static boolean g(CJROrderedCart cJROrderedCart) {
        if ("SUCCESS".equalsIgnoreCase(cJROrderedCart.getStatus())) {
            return true;
        }
        String itemStatus = cJROrderedCart.getItemStatus();
        char c2 = 65535;
        if (itemStatus.hashCode() == 55 && itemStatus.equals("7")) {
            c2 = 0;
        }
        if (c2 != 0) {
            return false;
        }
        return true;
    }

    private static boolean h(CJROrderedCart cJROrderedCart) {
        if ("FAILED".equalsIgnoreCase(cJROrderedCart.getStatus()) || TxNotifyData.UPI_STATUS_CANCELLED.equalsIgnoreCase(cJROrderedCart.getStatus())) {
            return true;
        }
        String itemStatus = cJROrderedCart.getItemStatus();
        char c2 = 65535;
        int hashCode = itemStatus.hashCode();
        if (hashCode != 54) {
            if (hashCode != 1575) {
                if (hashCode == 1633 && itemStatus.equals("34")) {
                    c2 = 2;
                }
            } else if (itemStatus.equals("18")) {
                c2 = 1;
            }
        } else if (itemStatus.equals("6")) {
            c2 = 0;
        }
        if (c2 == 0 || c2 == 1 || c2 == 2) {
            return true;
        }
        return false;
    }

    private void X() {
        try {
            String V2 = V();
            if (!TextUtils.isEmpty(V2) && !net.one97.paytm.orders.c.a.a(this.J) && !net.one97.paytm.orders.c.a.b(this.J)) {
                o(V2);
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private void a(TextView textView, TextView textView2, String str, final CJROrderedCart cJROrderedCart) {
        textView.setVisibility(8);
        final CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
        if (productDetail == null) {
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(productDetail.getVertical())) {
            textView2.setVisibility(8);
        } else if (this.P) {
            textView2.setVisibility(8);
        } else if (productDetail.getVertical() == null || TextUtils.isEmpty(productDetail.getVertical())) {
            textView2.setVisibility(8);
        } else {
            if (cJROrderedCart.getIsRepeat()) {
                textView2.setVisibility(0);
                textView2.setText(getResources().getString(R.string.order_summary_repeat_txt));
            } else if (cJROrderedCart.getIsRetry()) {
                textView2.setVisibility(0);
                textView2.setText(getResources().getString(R.string.order_summary_retry_txt));
            } else {
                textView2.setVisibility(8);
            }
            textView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    AJROrderSummaryActivityBase aJROrderSummaryActivityBase = AJROrderSummaryActivityBase.this;
                    aJROrderSummaryActivityBase.a((Context) aJROrderSummaryActivityBase, aJROrderSummaryActivityBase.getResources().getString(R.string.please_wait_progress_msg));
                    if (com.paytm.utility.a.m(AJROrderSummaryActivityBase.this)) {
                        AJROrderSummaryActivityBase.this.b();
                    }
                    String str6 = "";
                    String str7 = null;
                    if (productDetail.getVertical().equalsIgnoreCase("Tickets")) {
                        AJROrderSummaryActivityBase aJROrderSummaryActivityBase2 = AJROrderSummaryActivityBase.this;
                        CJROrderedCart cJROrderedCart = aJROrderSummaryActivityBase2.J.getOrderedCartList().get(0);
                        Map<String, String> rechargeConfiguration = cJROrderedCart.getRechargeConfiguration();
                        Intent b2 = ba.b(aJROrderSummaryActivityBase2);
                        if (rechargeConfiguration != null) {
                            Bundle bundle = new Bundle();
                            String str8 = null;
                            for (String next : rechargeConfiguration.keySet()) {
                                if (next.equalsIgnoreCase("from") && !TextUtils.isEmpty(rechargeConfiguration.get("from"))) {
                                    str7 = rechargeConfiguration.get("from");
                                }
                                if (next.equalsIgnoreCase("to") && !TextUtils.isEmpty(rechargeConfiguration.get("to"))) {
                                    str8 = rechargeConfiguration.get("to");
                                }
                                if (!TextUtils.isEmpty(rechargeConfiguration.get("from")) && !TextUtils.isEmpty(rechargeConfiguration.get("to"))) {
                                    bundle.putString("Source", str7);
                                    bundle.putString("Destination", str8);
                                }
                                if (next.equalsIgnoreCase("travel_date") && !TextUtils.isEmpty(rechargeConfiguration.get("travel_date"))) {
                                    bundle.putString("selected_date", rechargeConfiguration.get("travel_date"));
                                }
                            }
                            if (rechargeConfiguration.get("travel_date") == null && cJROrderedCart != null) {
                                Object metaDataResponse = cJROrderedCart.getMetaDataResponse();
                                com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
                                CJRBusOrderSummaryMetaDataResponse cJRBusOrderSummaryMetaDataResponse = (CJRBusOrderSummaryMetaDataResponse) fVar.a(fVar.a(metaDataResponse), CJRBusOrderSummaryMetaDataResponse.class);
                                if (!(cJRBusOrderSummaryMetaDataResponse == null || cJRBusOrderSummaryMetaDataResponse.getTravelDate() == null)) {
                                    str6 = cJRBusOrderSummaryMetaDataResponse.getTravelDate();
                                }
                                bundle.putString("selected_date", str6);
                            }
                            b2.putExtra("from_bus_retry", true);
                            b2.putExtras(bundle);
                            aJROrderSummaryActivityBase2.startActivity(b2);
                        }
                    } else if (productDetail.getVertical().equalsIgnoreCase("Paytm Hotel")) {
                        net.one97.paytm.hotels2.utils.a.a(AJROrderSummaryActivityBase.this);
                    } else if (productDetail.getVertical().equalsIgnoreCase("Wallet")) {
                        if (cJROrderedCart != null) {
                            AJROrderSummaryActivityBase.this.m();
                            AJROrderSummaryActivityBase.this.v();
                            String valueOf = String.valueOf(productDetail.getId());
                            net.one97.paytm.j.c.a();
                            if (valueOf.equalsIgnoreCase(net.one97.paytm.j.c.a("PaytmGiftVoucherProductId", (String) null))) {
                                net.one97.paytm.addmoney.d.g();
                                Intent a2 = net.one97.paytm.addmoney.d.a(this, "giftVoucher");
                                Map<String, String> rechargeConfiguration2 = cJROrderedCart.getRechargeConfiguration();
                                if (rechargeConfiguration2 != null) {
                                    a2.putExtra("amount", rechargeConfiguration2.get("price"));
                                    a2.putExtra("gv_reciever_name", rechargeConfiguration2.get("name"));
                                    a2.putExtra("gv_reciever_mobile", rechargeConfiguration2.get("targetMobile"));
                                }
                                AJROrderSummaryActivityBase.this.startActivity(a2);
                                AJROrderSummaryActivityBase.this.finish();
                                return;
                            }
                            AJROrderSummaryActivityBase aJROrderSummaryActivityBase3 = AJROrderSummaryActivityBase.this;
                            String d2 = Double.toString(cJROrderedCart.getPrice());
                            if (aJROrderSummaryActivityBase3.D != null) {
                                aJROrderSummaryActivityBase3.D.d(d2);
                            }
                        }
                    } else if (productDetail.getVertical().equalsIgnoreCase("Recharge")) {
                        AJROrderSummaryActivityBase.this.a(cJROrderedCart);
                    } else if (productDetail.getVertical().equalsIgnoreCase("Movie Tickets")) {
                        AJROrderSummaryActivityBase aJROrderSummaryActivityBase4 = AJROrderSummaryActivityBase.this;
                        aJROrderSummaryActivityBase4.startActivity(ar.a((Context) aJROrderSummaryActivityBase4));
                    } else if (productDetail.getVertical().equalsIgnoreCase("Entertainment Events")) {
                        AJROrderSummaryActivityBase aJROrderSummaryActivityBase5 = AJROrderSummaryActivityBase.this;
                        aJROrderSummaryActivityBase5.startActivity(k.a((Context) aJROrderSummaryActivityBase5, "net.one97.paytm.o2o.events.activity.EventsVerticalActivity", (HashMap<String, String>) null));
                    } else if (productDetail.getVertical().equalsIgnoreCase("Flights")) {
                        AJROrderSummaryActivityBase aJROrderSummaryActivityBase6 = AJROrderSummaryActivityBase.this;
                        CJROrderedCart cJROrderedCart2 = aJROrderSummaryActivityBase6.J.getOrderedCartList().get(0);
                        Map<String, String> rechargeConfiguration3 = cJROrderedCart2.getRechargeConfiguration();
                        if (rechargeConfiguration3 != null) {
                            str = rechargeConfiguration3.get("journey_source");
                            str2 = rechargeConfiguration3.get("journey_destination");
                        } else {
                            str2 = null;
                            str = null;
                        }
                        if (cJROrderedCart2 == null || cJROrderedCart2.mMetaDataResponse == null) {
                            str4 = null;
                            str3 = null;
                        } else {
                            com.google.gsonhtcfix.b.g gVar = (com.google.gsonhtcfix.b.g) cJROrderedCart2.mMetaDataResponse;
                            aJROrderSummaryActivityBase6.getApplicationContext();
                            str3 = com.paytm.utility.b.f((String) gVar.get("journey_departure_date"), "yyyy-MM-dd", "dd MMM yy");
                            aJROrderSummaryActivityBase6.getApplicationContext();
                            str4 = com.paytm.utility.b.f((String) gVar.get("journey_return_date"), "yyyy-MM-dd", "dd MMM yy");
                        }
                        String concat = "paytmmp://flightticket?url=paytm.com/flight-ticket&flight_depart_date=".concat(String.valueOf(str3));
                        try {
                            if (!TextUtils.isEmpty(str4)) {
                                concat = concat + "&flight_return_date=" + str4;
                            }
                            Uri.Builder buildUpon = Uri.parse(concat).buildUpon();
                            buildUpon.appendQueryParameter("source_city_name", str);
                            buildUpon.appendQueryParameter("destination_city_name", str2);
                            buildUpon.appendQueryParameter("isRetry", "true");
                            if (!TextUtils.isEmpty(str4)) {
                                buildUpon.appendQueryParameter("flight_trip_type", "round_trip");
                            }
                            str5 = buildUpon.build().toString();
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                            str5 = concat;
                        }
                        h.a aVar = net.one97.paytm.deeplink.h.f50349a;
                        h.a.a(aJROrderSummaryActivityBase6, str5, (Bundle) null);
                    } else if (l.b(productDetail.getVertical())) {
                        AJROrderSummaryActivityBase.this.a(cJROrderedCart);
                    } else if (productDetail.getVertical().equalsIgnoreCase("Add money to Savings Account") || productDetail.getVertical().equalsIgnoreCase("Paytm Payments Bank")) {
                        AJROrderSummaryActivityBase aJROrderSummaryActivityBase7 = AJROrderSummaryActivityBase.this;
                        CJROrderedCart cJROrderedCart3 = cJROrderedCart;
                        if (cJROrderedCart3 != null) {
                            Intent intent = new Intent(aJROrderSummaryActivityBase7, AddMoneyToPPBActivity.class);
                            intent.putExtra("Amount", cJROrderedCart3.getPrice());
                            aJROrderSummaryActivityBase7.startActivity(intent);
                        }
                    } else {
                        AJROrderSummaryActivityBase aJROrderSummaryActivityBase8 = AJROrderSummaryActivityBase.this;
                        CJROrderedCart cJROrderedCart4 = cJROrderedCart;
                        CJROrderSummaryProductDetail productDetail = cJROrderedCart4.getProductDetail();
                        if (productDetail != null) {
                            String valueOf2 = String.valueOf(productDetail.getId());
                            String valueOf3 = String.valueOf(cJROrderedCart4.getQuantity());
                            if (valueOf2 != null && productDetail.getId() == 224826563) {
                                net.one97.paytm.payments.d.a.a((Activity) aJROrderSummaryActivityBase8, "paytmmp://joinprime");
                            } else if (valueOf2 != null && valueOf3 != null) {
                                productDetail.getPrice();
                                HashMap hashMap = new HashMap();
                                hashMap.put("Content-Type", "application/json");
                                HashMap<String, String> a3 = com.paytm.utility.a.a((HashMap<String, String>) hashMap, (Context) aJROrderSummaryActivityBase8);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("action", "update");
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(CLPConstants.PRODUCT_ID, valueOf2);
                                    jSONObject2.put("quantity", valueOf3);
                                    jSONObject.put("object", jSONObject2);
                                } catch (Exception e3) {
                                    q.b(e3.getMessage());
                                }
                                net.one97.paytm.j.c.a();
                                ag.a(aJROrderSummaryActivityBase8.getApplicationContext()).b("sso_token=", str6, true);
                                net.one97.paytm.common.b.d.a(aJROrderSummaryActivityBase8, (net.one97.paytm.j.c.a("cartv2", (String) null) + "/" + t.g(aJROrderSummaryActivityBase8)) + com.paytm.utility.c.a(aJROrderSummaryActivityBase8.getBaseContext(), true), new com.paytm.network.listener.b() {

                                    /* renamed from: a */
                                    final /* synthetic */ int f51818a;

                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.CJROrderBaseActivity.3.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes4.dex
                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.CJROrderBaseActivity.3.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
                                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                    
*/

                                    public final void handleErrorCode(
/*
Method generation error in method: net.one97.paytm.CJROrderBaseActivity.3.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes4.dex
                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.CJROrderBaseActivity.3.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
                                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                    
*/
                                }, a3, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRShoppingCart(), a.c.HOME, a.b.SILENT).a();
                            }
                        }
                    }
                }
            });
        }
    }

    private static boolean d(CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        String vertical;
        if (cJROrderSummaryProductDetail == null || (vertical = cJROrderSummaryProductDetail.getVertical()) == null || !vertical.equalsIgnoreCase("Movie Tickets")) {
            return false;
        }
        return true;
    }

    private static boolean e(CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        String vertical;
        if (cJROrderSummaryProductDetail == null || (vertical = cJROrderSummaryProductDetail.getVertical()) == null || !vertical.equalsIgnoreCase("Trains")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(ArrayList<CJROrderSummaryStatusFlowHistory> arrayList, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, CJROrderedCart cJROrderedCart) {
        ArrayList<CJROrderSummaryStatusFlowHistory> arrayList2 = arrayList;
        TextView textView6 = textView;
        TextView textView7 = textView2;
        TextView textView8 = textView3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        textView6.setVisibility(0);
        textView5.setVisibility(8);
        textView4.setTypeface((Typeface) null, 1);
        if (arrayList.size() < 2) {
            textView7.setVisibility(8);
            textView8.setVisibility(8);
        }
        if (arrayList.size() <= 0 || arrayList2.get(0) == null || TextUtils.isEmpty(arrayList2.get(0).getStatusHistoryMessage())) {
            CJROrderedCart cJROrderedCart2 = cJROrderedCart;
        } else {
            spannableStringBuilder.append(arrayList2.get(0).getStatusHistoryMessage());
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.92f), spannableStringBuilder.length() - arrayList2.get(0).getStatusHistoryMessage().length(), spannableStringBuilder.length(), 0);
            if (!TextUtils.isEmpty(arrayList2.get(0).getStatusHistoryDate())) {
                spannableStringBuilder.append(StringUtility.NEW_LINE);
                spannableStringBuilder.append(Html.fromHtml("<font color=#929292>" + c(arrayList2.get(0).getStatusHistoryDate(), "") + "</font>"));
                spannableStringBuilder.setSpan(new RelativeSizeSpan(0.72f), spannableStringBuilder.length() - c(arrayList2.get(0).getStatusHistoryDate(), "").length(), spannableStringBuilder.length(), 0);
            }
            textView6.setText(spannableStringBuilder);
            a(spannableStringBuilder.toString(), textView6, cJROrderedCart);
        }
        int i2 = 0;
        while (i2 < arrayList.size()) {
            if (i2 > 0) {
                spannableStringBuilder2.append("\n\n");
            }
            if (arrayList.size() > i2 && arrayList2.get(i2) != null && !TextUtils.isEmpty(arrayList2.get(i2).getStatusHistoryMessage())) {
                spannableStringBuilder2.append(arrayList2.get(i2).getStatusHistoryMessage());
                spannableStringBuilder2.setSpan(new RelativeSizeSpan(0.92f), spannableStringBuilder2.length() - arrayList2.get(i2).getStatusHistoryMessage().length(), spannableStringBuilder2.length(), 0);
                if (!TextUtils.isEmpty(arrayList2.get(i2).getStatusHistoryDate())) {
                    spannableStringBuilder2.append(StringUtility.NEW_LINE);
                    spannableStringBuilder2.append(Html.fromHtml("<font color=#929292>" + c(arrayList2.get(i2).getStatusHistoryDate(), "") + "</font>"));
                    spannableStringBuilder2.setSpan(new RelativeSizeSpan(0.72f), spannableStringBuilder2.length() - c(arrayList2.get(i2).getStatusHistoryDate(), "").length(), spannableStringBuilder2.length(), 0);
                }
            }
            i2++;
            CJROrderedCart cJROrderedCart3 = cJROrderedCart;
        }
        if (arrayList.size() > 1) {
            textView8.setVisibility(4);
            textView7.setVisibility(0);
        }
        final TextView textView9 = textView2;
        final TextView textView10 = textView3;
        final TextView textView11 = textView;
        final TextView textView12 = textView5;
        final CJROrderedCart cJROrderedCart4 = cJROrderedCart;
        textView7.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                textView9.setVisibility(4);
                textView10.setVisibility(0);
                textView11.setVisibility(8);
                textView12.setText(spannableStringBuilder2);
                AJROrderSummaryActivityBase.this.a(spannableStringBuilder2.toString(), textView12, cJROrderedCart4);
                textView12.setVisibility(0);
            }
        });
        final TextView textView13 = textView3;
        final TextView textView14 = textView2;
        textView8.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                textView13.setVisibility(4);
                textView14.setVisibility(0);
                textView11.setVisibility(0);
                textView12.setVisibility(8);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str, TextView textView, CJROrderedCart cJROrderedCart) {
        String string = getResources().getString(R.string.order_summary_contact_us);
        int indexOf = str.indexOf(string);
        try {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            Spannable spannable = (Spannable) textView.getText();
            spannable.setSpan(new ExpandedURLSpanNoUnderline(string, cJROrderedCart), indexOf, string.length() + indexOf, 33);
            spannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.paytm_blue)), indexOf, string.length() + indexOf, 33);
        } catch (Exception unused) {
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        if (adapterView instanceof CJRHorizontalListView) {
            CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) ((CJRHorizontalListView) adapterView).getItemAtPosition(i2);
            String uRLType = cJRHomePageItem.getURLType();
            if (uRLType != null) {
                a(uRLType, cJRHomePageItem, i2, uRLType.equalsIgnoreCase("product") ? this.ac.getParentListForItem(ViewHolderFactory.TYPE_ROW, cJRHomePageItem) : null, "summary");
            }
            uRLType.equalsIgnoreCase("product");
        } else if (adapterView instanceof ExpandableHeightListView) {
            CJRHomePageItem cJRHomePageItem2 = (CJRHomePageItem) ((ExpandableHeightListView) adapterView).getItemAtPosition(i2);
            CJRCatalogItem cJRCatalogItem = new CJRCatalogItem();
            cJRCatalogItem.setName(cJRHomePageItem2.getName());
            cJRCatalogItem.setUrl(cJRHomePageItem2.getURL());
            cJRCatalogItem.setImageIconUrl(cJRHomePageItem2.getImageUrl());
            cJRCatalogItem.setURLType(cJRHomePageItem2.getURLType());
            cJRCatalogItem.setImageData(cJRHomePageItem2.getURL());
            cJRCatalogItem.setBrand(cJRHomePageItem2.getBrand());
            a(cJRHomePageItem2.getURLType(), cJRHomePageItem2, i2, (ArrayList<? extends CJRItem>) null, "summary");
        }
    }

    private void n(String str) {
        if (!this.V) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(str).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    boolean unused = AJROrderSummaryActivityBase.this.V = false;
                    AJROrderSummaryActivityBase aJROrderSummaryActivityBase = AJROrderSummaryActivityBase.this;
                    aJROrderSummaryActivityBase.b(aJROrderSummaryActivityBase.G);
                }
            });
            builder.show();
            this.V = true;
        }
    }

    /* access modifiers changed from: private */
    public void b(CJROrderSummaryAction cJROrderSummaryAction) {
        if (TextUtils.isEmpty(cJROrderSummaryAction.getLabel()) || !cJROrderSummaryAction.getLabel().equalsIgnoreCase("Cancel") || !c(cJROrderSummaryAction)) {
            try {
                b();
                boolean z = false;
                if (!(cJROrderSummaryAction == null || cJROrderSummaryAction.getActionName() == null || !cJROrderSummaryAction.getActionName().equalsIgnoreCase("Replace_Item"))) {
                    z = true;
                }
                if (cJROrderSummaryAction.getUrlParams() == null || cJROrderSummaryAction.getUrlParams().getMethod() == null || !cJROrderSummaryAction.getUrlParams().getMethod().equalsIgnoreCase("POST")) {
                    this.N = cJROrderSummaryAction.getLabel();
                    a(cJROrderSummaryAction.getUrlParams().getUrl(), z);
                    return;
                }
                String str = null;
                if (cJROrderSummaryAction.getUrlParams().getBody() != null) {
                    str = cJROrderSummaryAction.getUrlParams().getBody().toString();
                }
                this.N = cJROrderSummaryAction.getLabel();
                a(cJROrderSummaryAction.getUrlParams().getUrl(), str, z);
            } catch (Exception e2) {
                v();
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    private boolean c(CJROrderSummaryAction cJROrderSummaryAction) {
        String str;
        CJROrderSummaryProductDetail productDetail;
        Resources resources;
        Long l2 = null;
        try {
            net.one97.paytm.j.a.a(this.f51398e, net.one97.paytm.recharge.common.utils.ba.i(String.valueOf(this.J.getOrderedCartList().get(0).getProductDetail().getCategoryId())), SDKConstants.AI_CANCEL_TRANSACTION_CLICKED, (String) null);
        } catch (Exception unused) {
        }
        if (!(cJROrderSummaryAction == null || cJROrderSummaryAction.getUrlParams() == null || cJROrderSummaryAction.getUrlParams().getUrl() == null)) {
            if (this.M == null && cJROrderSummaryAction != null) {
                this.M = new net.one97.paytm.recharge.ordersummary.widget.b(this, this.J, cJROrderSummaryAction.getUrlParams().getUrl(), new net.one97.paytm.recharge.common.e.ai() {
                    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
                        AJROrderSummaryActivityBase.this.onApiSuccess(iJRPaytmDataModel);
                    }

                    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
                        AJROrderSummaryActivityBase.this.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                    }
                }, this);
            }
            net.one97.paytm.recharge.ordersummary.widget.b bVar = this.M;
            bVar.f64555b = this.J;
            try {
                bVar.f64556c = cJROrderSummaryAction.getUrlParams().getUrl();
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
            if (this.M.b()) {
                net.one97.paytm.recharge.ordersummary.widget.b bVar2 = this.M;
                double d2 = 0.0d;
                try {
                    CJROrderSummary cJROrderSummary = bVar2.f64555b;
                    if (cJROrderSummary == null) {
                        kotlin.g.b.k.a();
                    }
                    CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
                    kotlin.g.b.k.a((Object) cJROrderedCart, "orderedCart");
                    CJROrderSummaryProductDetail productDetail2 = cJROrderedCart.getProductDetail();
                    kotlin.g.b.k.a((Object) productDetail2, "orderedCart.productDetail");
                    CJRAttributes attributes = productDetail2.getAttributes();
                    kotlin.g.b.k.a((Object) attributes, "orderedCart.productDetail.attributes");
                    str = attributes.getPayTypeDisplayLabel();
                    kotlin.g.b.k.a((Object) str, "orderedCart.productDetai…butes.payTypeDisplayLabel");
                    try {
                        d2 = cJROrderedCart.getSubTotal();
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    str = "";
                }
                Context context = bVar2.f64554a;
                String string = context != null ? context.getString(net.one97.paytm.recharge.R.string.please_note) : null;
                Context context2 = bVar2.f64554a;
                String[] stringArray = (context2 == null || (resources = context2.getResources()) == null) ? null : resources.getStringArray(net.one97.paytm.recharge.R.array.recharge_summary_imps_cancel_messages);
                Context context3 = bVar2.f64554a;
                String string2 = context3 != null ? context3.getString(net.one97.paytm.recharge.R.string.imps_cancel_recharge, new Object[]{str}) : null;
                Context context4 = bVar2.f64554a;
                String string3 = context4 != null ? context4.getString(net.one97.paytm.recharge.R.string.imps_wait_for_confirmation, new Object[]{str}) : null;
                Context context5 = bVar2.f64554a;
                if (context5 != null) {
                    androidx.fragment.app.j supportFragmentManager = ((AppCompatActivity) context5).getSupportFragmentManager();
                    kotlin.g.b.k.a((Object) supportFragmentManager, "(context as AppCompatAct…y).supportFragmentManager");
                    try {
                        CJROrderSummary cJROrderSummary2 = bVar2.f64555b;
                        if (cJROrderSummary2 == null) {
                            kotlin.g.b.k.a();
                        }
                        CJROrderedCart cJROrderedCart2 = cJROrderSummary2.getOrderedCartList().get(0);
                        if (!(cJROrderedCart2 == null || (productDetail = cJROrderedCart2.getProductDetail()) == null)) {
                            l2 = Long.valueOf(productDetail.getCategoryId());
                        }
                        String valueOf = String.valueOf(l2);
                        h.a aVar = net.one97.paytm.recharge.ordersummary.c.h.f64069a;
                        if (string == null) {
                            kotlin.g.b.k.a();
                        }
                        List asList = Arrays.asList((String[]) Arrays.copyOf(stringArray, stringArray.length));
                        kotlin.g.b.k.a((Object) asList, "Arrays.asList(*messageList)");
                        h.a.a(string, string2, string3, asList, bVar2, Double.valueOf(d2), valueOf).show(supportFragmentManager, net.one97.paytm.recharge.ordersummary.c.h.class.getSimpleName());
                    } catch (Exception unused4) {
                    }
                    return true;
                }
                throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            }
        }
        return false;
    }

    private void a(final CJROrderSummaryAction cJROrderSummaryAction, boolean z) {
        try {
            net.one97.paytm.recharge.legacy.catalog.b.c cVar = new net.one97.paytm.recharge.legacy.catalog.b.c(cJROrderSummaryAction);
            Boolean valueOf = Boolean.valueOf(z);
            net.one97.paytm.recharge.legacy.catalog.b.c cVar2 = new net.one97.paytm.recharge.legacy.catalog.b.c();
            if (valueOf.booleanValue()) {
                cVar2.f62804b = cVar.f62803a.getAlert().getHeading();
                cVar2.f62805c = cVar.f62803a.getAlert().getMessage();
                cVar2.f62806d = cVar.f62803a.getAlert().getOkbutton();
                cVar2.f62807e = cVar.f62803a.getAlert().getCancelButton();
            } else {
                cVar2.f62805c = cVar.f62803a.getConfirmation();
            }
            AnonymousClass61 r8 = new View.OnClickListener() {
                public final void onClick(View view) {
                    int id = view.getId();
                    if (id != R.id.dialog_ic_cancel) {
                        if (id == R.id.dialog_ic_ok) {
                            AJROrderSummaryActivityBase.this.b(cJROrderSummaryAction);
                        } else {
                            return;
                        }
                    }
                    AJROrderSummaryActivityBase.this.al.dismiss();
                }
            };
            String str = cVar2.f62804b;
            String str2 = cVar2.f62805c;
            String str3 = cVar2.f62806d;
            String str4 = cVar2.f62807e;
            Dialog dialog = new Dialog(this, 16974130);
            dialog.setCancelable(false);
            dialog.setContentView(net.one97.paytm.recharge.R.layout.dialog_insurance_cancel);
            dialog.setTitle(str);
            TextView textView = (TextView) dialog.findViewById(net.one97.paytm.recharge.R.id.dialog_ic_message);
            if (!net.one97.paytm.recharge.legacy.catalog.b.c.a(str2)) {
                textView.setText(str2);
            }
            if (!net.one97.paytm.recharge.legacy.catalog.b.c.a(str3)) {
                TextView textView2 = (TextView) dialog.findViewById(net.one97.paytm.recharge.R.id.dialog_ic_ok);
                textView2.setVisibility(0);
                textView2.setText(str3);
                textView2.setOnClickListener(r8);
            }
            if (!net.one97.paytm.recharge.legacy.catalog.b.c.a(str4)) {
                TextView textView3 = (TextView) dialog.findViewById(net.one97.paytm.recharge.R.id.dialog_ic_cancel);
                textView3.setVisibility(0);
                textView3.setText(str4);
                textView3.setOnClickListener(r8);
            }
            this.al = dialog;
            this.al.show();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(long j2) {
        try {
            boolean z = false;
            boolean booleanExtra = getIntent().hasExtra("Add_to_paytm_cash") ? getIntent().getBooleanExtra("Add_to_paytm_cash", false) : false;
            if (getIntent().hasExtra(com.business.merchant_payments.common.utility.AppConstants.IS_CANCEL)) {
                z = getIntent().getBooleanExtra(com.business.merchant_payments.common.utility.AppConstants.IS_CANCEL, false);
            }
            Intent intent = new Intent(this, AJROrderSummaryActivityBase.class);
            intent.putExtra("tracking_info", this.ay);
            intent.putExtra("Recharge", this.O);
            intent.putExtra("Add_to_paytm_cash", booleanExtra);
            intent.putExtra(UpiConstants.FROM, this.L);
            intent.putExtra("order_id", Long.toString(j2));
            intent.putExtra("referralSource", this.ao);
            intent.putExtra(com.business.merchant_payments.common.utility.AppConstants.IS_CANCEL, z);
            startActivity(intent);
            finish();
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public final void a(int i2, int i3, IJRDataModel iJRDataModel) {
        CJROrderSummary cJROrderSummary;
        CJROrderedCart cJROrderedCart;
        if (iJRDataModel instanceof CJROrderSummaryActionList) {
            CJROrderSummaryActionList cJROrderSummaryActionList = (CJROrderSummaryActionList) iJRDataModel;
            if (cJROrderSummaryActionList.getAction() != null) {
                CJROrderSummaryAction cJROrderSummaryAction = cJROrderSummaryActionList.getAction().get(i2);
                if (cJROrderSummaryAction == null || cJROrderSummaryAction.getActionName() == null || !cJROrderSummaryAction.getActionName().equalsIgnoreCase("replacement_order_button")) {
                    if (!(cJROrderSummaryAction == null || cJROrderSummaryAction.getActionName() == null || ((!cJROrderSummaryAction.getActionName().equalsIgnoreCase("Return_Item") && !cJROrderSummaryAction.getActionName().equalsIgnoreCase("Replace_Item")) || (cJROrderSummary = this.J) == null || cJROrderSummary.getOrderedCartList() == null || this.J.getOrderedCartList().size() <= i3))) {
                        this.aY = this.J.getOrderedCartList().get(i3);
                    }
                    a(cJROrderSummaryAction);
                    return;
                }
                CJROrderSummary cJROrderSummary2 = this.J;
                if (cJROrderSummary2 != null && cJROrderSummary2.getOrderedCartList() != null && this.J.getOrderedCartList().size() > i3 && (cJROrderedCart = this.J.getOrderedCartList().get(i3)) != null && cJROrderedCart.getChildOrderId() > 0) {
                    c(cJROrderedCart.getChildOrderId());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(CJROrderSummaryAction cJROrderSummaryAction) {
        if (cJROrderSummaryAction.getAlert() != null || !TextUtils.isEmpty(cJROrderSummaryAction.getConfirmation())) {
            a(cJROrderSummaryAction, cJROrderSummaryAction.getAlert() != null);
            return;
        }
        if (cJROrderSummaryAction != null && cJROrderSummaryAction.getActionName() != null && cJROrderSummaryAction.getActionName().equalsIgnoreCase(TransactionType.CANCEL) && P() && cJROrderSummaryAction.getActionName().equalsIgnoreCase("Invoice") && this.L.equalsIgnoreCase("Payment")) {
            Y();
        }
        b(cJROrderSummaryAction);
    }

    private void Y() {
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "bus_summary");
        hashMap.put("event_action", "download_clicked");
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/bus-tickets-summary");
        hashMap.put("vertical_name", "bus");
        hashMap.put("user_id", com.paytm.utility.a.a((Context) this));
        net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this);
    }

    private void o(String str) {
        if (!this.Z) {
            if (str != null && str.equalsIgnoreCase("SUCCESS")) {
                this.Z = true;
            }
            if (this.Z && !isFinishing()) {
                Z();
            }
        }
    }

    private void Z() {
        if (net.one97.paytm.widget.f.a()) {
            aa();
            this.bJ = new f(this, (byte) 0);
            new Timer().schedule(this.bJ, 3000);
        }
    }

    /* access modifiers changed from: private */
    public void aa() {
        f fVar = this.bJ;
        if (fVar != null) {
            fVar.cancel();
            this.bJ = null;
        }
    }

    public void onPause() {
        super.onPause();
        m();
        aa();
        try {
            unregisterReceiver(this.bF);
        } catch (IllegalArgumentException | RuntimeException unused) {
        }
    }

    private static String c(String str, String str2) {
        SimpleDateFormat simpleDateFormat;
        if (str == null || str.trim().length() <= 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = null;
        try {
            date = simpleDateFormat2.parse(str);
        } catch (ParseException e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
        if (!str2.equalsIgnoreCase("statusFlow")) {
            simpleDateFormat = new SimpleDateFormat("MMMM dd-yyyy  hh:mm a");
        } else if (str2.equalsIgnoreCase("Tickets")) {
            simpleDateFormat = new SimpleDateFormat("MMM dd,yy");
        } else if (str2.equalsIgnoreCase("Tickets")) {
            simpleDateFormat = new SimpleDateFormat("dd MMM yy");
        } else {
            simpleDateFormat = new SimpleDateFormat("dd-MMM-yy");
        }
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String format = simpleDateFormat.format(date);
        if (!TextUtils.isEmpty(format)) {
            return !str2.equalsIgnoreCase("statusFlow") ? format.replace("-", ", ") : format;
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0174  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r14 = this;
            super.a()
            java.lang.String r0 = r14.L
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x018a
            java.lang.String r0 = r14.L
            java.lang.String r1 = "Payment"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L_0x018a
            r11 = 1
            r12 = 0
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x007b }
            java.lang.String r0 = "thank_you_page_promotion_banner_v2"
            java.lang.String r0 = net.one97.paytm.j.c.a((java.lang.String) r0, (java.lang.String) r12)     // Catch:{ Exception -> 0x007b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007b }
            r1.<init>()     // Catch:{ Exception -> 0x007b }
            r1.append(r0)     // Catch:{ Exception -> 0x007b }
            java.lang.String r0 = com.paytm.utility.c.a((android.content.Context) r14, (boolean) r11)     // Catch:{ Exception -> 0x007b }
            r1.append(r0)     // Catch:{ Exception -> 0x007b }
            java.lang.String r2 = r1.toString()     // Catch:{ Exception -> 0x007b }
            if (r2 == 0) goto L_0x0077
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x007b }
            if (r0 != 0) goto L_0x0077
            boolean r0 = android.webkit.URLUtil.isValidUrl(r2)     // Catch:{ Exception -> 0x007b }
            if (r0 != 0) goto L_0x0043
            goto L_0x0077
        L_0x0043:
            android.content.Context r0 = r14.getApplicationContext()     // Catch:{ Exception -> 0x007b }
            java.lang.String r1 = "PG page"
            java.lang.String r3 = "Summary Page"
            java.lang.String r7 = net.one97.paytm.utils.l.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x007b }
            java.util.HashMap r4 = com.paytm.utility.a.i()     // Catch:{ Exception -> 0x007b }
            boolean r0 = com.paytm.utility.a.m(r14)     // Catch:{ Exception -> 0x007b }
            if (r0 == 0) goto L_0x0073
            net.one97.paytm.AJROrderSummaryActivityBase$63 r3 = new net.one97.paytm.AJROrderSummaryActivityBase$63     // Catch:{ Exception -> 0x007b }
            r3.<init>()     // Catch:{ Exception -> 0x007b }
            r5 = 0
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.POST     // Catch:{ Exception -> 0x007b }
            net.one97.paytm.common.entity.shopping.CJRHomePageV2 r8 = new net.one97.paytm.common.entity.shopping.CJRHomePageV2     // Catch:{ Exception -> 0x007b }
            r8.<init>()     // Catch:{ Exception -> 0x007b }
            com.paytm.network.a$c r9 = com.paytm.network.a.c.HOME     // Catch:{ Exception -> 0x007b }
            com.paytm.network.a$b r10 = com.paytm.network.a.b.SILENT     // Catch:{ Exception -> 0x007b }
            r1 = r14
            com.paytm.network.a r0 = net.one97.paytm.common.b.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x007b }
            r0.a()     // Catch:{ Exception -> 0x007b }
            goto L_0x007e
        L_0x0073:
            r14.ad()     // Catch:{ Exception -> 0x007b }
            goto L_0x007e
        L_0x0077:
            r14.ad()     // Catch:{ Exception -> 0x007b }
            goto L_0x007e
        L_0x007b:
            r14.ad()
        L_0x007e:
            android.content.Intent r0 = r14.getIntent()
            r13 = 0
            java.lang.String r1 = "is_cancel"
            boolean r0 = r0.getBooleanExtra(r1, r13)
            if (r0 != 0) goto L_0x00fc
            java.lang.String r0 = r14.G
            net.one97.paytm.j.c.a()     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r1 = "leadAPIOnOrderSummary"
            java.lang.String r1 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r12)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r1 = com.paytm.utility.a.c(r14, r1)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r2 = net.one97.paytm.utils.t.g(r14)     // Catch:{ Exception -> 0x00f0 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00f0 }
            if (r3 != 0) goto L_0x00b8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f0 }
            r3.<init>()     // Catch:{ Exception -> 0x00f0 }
            r3.append(r1)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r1 = "&cart_id="
            r3.append(r1)     // Catch:{ Exception -> 0x00f0 }
            r3.append(r2)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x00f0 }
        L_0x00b8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f0 }
            r2.<init>()     // Catch:{ Exception -> 0x00f0 }
            r2.append(r1)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r1 = "&order_id="
            r2.append(r1)     // Catch:{ Exception -> 0x00f0 }
            r2.append(r0)     // Catch:{ Exception -> 0x00f0 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00f0 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x00f0 }
            r0.<init>()     // Catch:{ Exception -> 0x00f0 }
            java.util.HashMap r4 = com.paytm.utility.a.a((java.util.HashMap<java.lang.String, java.lang.String>) r0, (android.content.Context) r14)     // Catch:{ Exception -> 0x00f0 }
            net.one97.paytm.AJROrderSummaryActivityBase$68 r3 = new net.one97.paytm.AJROrderSummaryActivityBase$68     // Catch:{ Exception -> 0x00f0 }
            r3.<init>()     // Catch:{ Exception -> 0x00f0 }
            r5 = 0
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.GET     // Catch:{ Exception -> 0x00f0 }
            r7 = 0
            net.one97.paytm.common.entity.CJRContingency r8 = new net.one97.paytm.common.entity.CJRContingency     // Catch:{ Exception -> 0x00f0 }
            r8.<init>()     // Catch:{ Exception -> 0x00f0 }
            com.paytm.network.a$c r9 = com.paytm.network.a.c.HOME     // Catch:{ Exception -> 0x00f0 }
            com.paytm.network.a$b r10 = com.paytm.network.a.b.SILENT     // Catch:{ Exception -> 0x00f0 }
            r1 = r14
            com.paytm.network.a r0 = net.one97.paytm.common.b.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00f0 }
            r0.a()     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00fc
        L_0x00f0:
            r0 = move-exception
            boolean r1 = com.paytm.utility.b.v
            if (r1 == 0) goto L_0x00fc
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x00fc:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r4 = com.paytm.utility.a.a((java.util.HashMap<java.lang.String, java.lang.String>) r0, (android.content.Context) r14)
            java.lang.String r0 = net.one97.paytm.utils.t.g(r14)
            net.one97.paytm.j.c.a()
            java.lang.String r1 = "cartv2"
            java.lang.String r1 = net.one97.paytm.j.c.a((java.lang.String) r1, (java.lang.String) r12)
            net.one97.paytm.utils.t.b((android.content.Context) r14)
            android.content.Context r2 = r14.getBaseContext()
            java.lang.String r2 = com.paytm.utility.c.a((android.content.Context) r2, (boolean) r13)
            if (r0 == 0) goto L_0x0133
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = "/"
            r3.append(r1)
            r3.append(r0)
            java.lang.String r1 = r3.toString()
        L_0x0133:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            boolean r0 = com.paytm.utility.a.m(r14)
            if (r0 == 0) goto L_0x0174
            com.paytm.network.b r0 = new com.paytm.network.b
            r0.<init>()
            r0.f42877a = r14
            com.paytm.network.a$b r1 = com.paytm.network.a.b.USER_FACING
            r0.n = r1
            r0.f42880d = r2
            java.lang.String r1 = "CJRActionBarBaseActivity."
            r0.o = r1
            com.paytm.network.a$c r1 = com.paytm.network.a.c.HOME
            r0.f42878b = r1
            net.one97.paytm.common.entity.shopping.CJRShoppingCart r1 = new net.one97.paytm.common.entity.shopping.CJRShoppingCart
            r1.<init>()
            r0.f42885i = r1
            r0.j = r14
            r0.l = r11
            com.paytm.network.a$a r1 = com.paytm.network.a.C0715a.GET
            r0.f42879c = r1
            com.paytm.network.a r0 = r0.l()
            r0.a()
            goto L_0x018a
        L_0x0174:
            r5 = 0
            com.paytm.network.a$a r6 = com.paytm.network.a.C0715a.GET
            r7 = 0
            net.one97.paytm.common.entity.shopping.CJRShoppingCart r8 = new net.one97.paytm.common.entity.shopping.CJRShoppingCart
            r8.<init>()
            com.paytm.network.a$c r9 = com.paytm.network.a.c.HOME
            com.paytm.network.a$b r10 = com.paytm.network.a.b.SILENT
            r1 = r14
            r3 = r14
            com.paytm.network.a r0 = net.one97.paytm.common.b.d.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            net.one97.paytm.utils.r.a((com.paytm.network.a) r0, (android.content.Context) r14, (android.content.DialogInterface.OnCancelListener) r14)
        L_0x018a:
            android.content.Intent r0 = r14.getIntent()
            java.lang.String r1 = "extra_home_data"
            boolean r0 = r0.hasExtra(r1)
            java.lang.String r2 = "Deep Linking"
            if (r0 == 0) goto L_0x01f0
            android.content.Intent r0 = r14.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            java.io.Serializable r0 = r0.getSerializable(r1)
            net.one97.paytm.common.entity.CJRItem r0 = (net.one97.paytm.common.entity.CJRItem) r0
            r14.aJ = r0
            net.one97.paytm.common.entity.CJRItem r0 = r14.aJ
            if (r0 == 0) goto L_0x01d8
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r14.aI
            java.lang.String r3 = r0.getSearchType()
            java.lang.String r4 = "search_type"
            r1.put(r4, r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r14.aI
            java.lang.String r3 = r0.getSearchCategory()
            java.lang.String r4 = "search_category"
            r1.put(r4, r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r14.aI
            java.lang.String r3 = r0.getSearchTerm()
            java.lang.String r4 = "search_term"
            r1.put(r4, r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r14.aI
            java.lang.String r0 = r0.getSearchResultType()
            java.lang.String r3 = "search_result_type"
            r1.put(r3, r0)
        L_0x01d8:
            net.one97.paytm.common.entity.CJRItem r0 = r14.aJ
            java.lang.String r0 = r0.getURL()
            r14.I = r0
            r14.L = r2
            java.lang.String r0 = r14.I
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0230
            java.lang.String r0 = r14.I
            r14.e((java.lang.String) r0)
            return
        L_0x01f0:
            android.content.Intent r0 = r14.getIntent()
            if (r0 == 0) goto L_0x022b
            android.content.Intent r0 = r14.getIntent()
            android.net.Uri r0 = r0.getData()
            if (r0 == 0) goto L_0x022b
            android.content.Intent r0 = r14.getIntent()
            android.net.Uri r0 = r0.getData()
            java.lang.String r1 = "url"
            java.lang.String r0 = r0.getQueryParameter(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x022b
            android.content.Intent r0 = r14.getIntent()
            android.net.Uri r0 = r0.getData()
            java.lang.String r0 = r0.getQueryParameter(r1)
            r14.I = r0
            r14.L = r2
            java.lang.String r0 = r14.I
            r14.e((java.lang.String) r0)
            return
        L_0x022b:
            java.lang.String r0 = r14.G
            r14.b((java.lang.String) r0)
        L_0x0230:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.a():void");
    }

    private void ab() {
        com.paytm.utility.d.a.a(new kotlin.g.a.a() {
            public final Object invoke() {
                return AJROrderSummaryActivityBase.this.ah();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x ah() {
        String a2 = new com.google.gsonhtcfix.f().a((Object) this.ac);
        SanitizedResponseModel sanitizedResponse = SFInterface.INSTANCE.getSanitizedResponse((HomeResponse) new com.google.gson.f().a(a2, HomeResponse.class), false);
        final net.one97.paytm.adapter.b bVar = new net.one97.paytm.adapter.b(this, sanitizedResponse.getRvWidgets(), sanitizedResponse.getGaListener());
        this.aA.post(new Runnable() {
            public final void run() {
                AJROrderSummaryActivityBase.this.aA.setAdapter(bVar);
            }
        });
        return null;
    }

    private boolean ac() {
        CJRHomePageV2 cJRHomePageV2 = this.ac;
        return (cJRHomePageV2 == null || cJRHomePageV2.getmPage() == null || this.ac.getmPage().size() <= 0) ? false : true;
    }

    /* access modifiers changed from: private */
    public void ad() {
        this.aE = true;
        this.aB = false;
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList() != null) {
            B();
        }
    }

    private static ArrayList<CJRHomePageLayoutV2> a(CJRHomePageV2 cJRHomePageV2) {
        ArrayList<CJRHomePageDetailV2> arrayList = cJRHomePageV2.getmPage();
        ArrayList<CJRHomePageLayoutV2> arrayList2 = new ArrayList<>();
        Iterator<CJRHomePageDetailV2> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.addAll(it2.next().getHomePageLayoutList());
        }
        return arrayList2;
    }

    /* access modifiers changed from: private */
    public void ae() {
        if (!this.aD) {
            this.aD = true;
            this.aL = (RelativeLayout) findViewById(R.id.order_summary_footer_lyt);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.banner_header_lyt);
            CJRHomePageV2 cJRHomePageV2 = this.ac;
            if (cJRHomePageV2 == null) {
                return;
            }
            if (a(cJRHomePageV2).size() <= 0 || R()) {
                this.aL.setVisibility(0);
                relativeLayout.setVisibility(8);
                return;
            }
            ab();
            this.aL.setVisibility(8);
            relativeLayout.setVisibility(0);
        }
    }

    public final void a(TextView textView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TextView textView2 = new TextView(this);
        int u = com.paytm.utility.a.u(this);
        textView2.setText(getResources().getString(R.string.change_alert_title));
        textView2.setPadding(u, u, u, u);
        textView2.setGravity(17);
        textView2.setTextSize(20.0f);
        textView2.setTextColor(getResources().getColor(R.color.color_33b5e5));
        ListView listView = new ListView(this);
        listView.setChoiceMode(1);
        net.one97.paytm.adapter.d dVar = new net.one97.paytm.adapter.d(this, this.at, this.ah, u);
        listView.setAdapter(dVar);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(dVar) {
            private final /* synthetic */ d f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                AJROrderSummaryActivityBase.this.a(this.f$1, adapterView, view, i2, j);
            }
        });
        builder.setCustomTitle(textView2);
        builder.setCancelable(false);
        builder.setInverseBackgroundForced(true);
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener(textView) {
            private final /* synthetic */ TextView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJROrderSummaryActivityBase.this.a(this.f$1, dialogInterface, i2);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AJROrderSummaryActivityBase.this.a(dialogInterface, i2);
            }
        });
        builder.setView(listView);
        this.ak = builder.create();
        this.an = 0;
        this.ak.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.adapter.d dVar, AdapterView adapterView, View view, int i2, long j2) {
        if (dVar != null) {
            dVar.a((String) dVar.getItem(i2));
        }
        if (this.ak.isShowing()) {
            this.an = i2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(TextView textView, DialogInterface dialogInterface, int i2) {
        String str = this.ah.get(this.an);
        this.at = str;
        textView.setText(Html.fromHtml("<u>" + str + "</u"));
        this.ak.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        this.ak.dismiss();
    }

    public final void a(CJROrderSummarySellarRating cJROrderSummarySellarRating) {
        if (cJROrderSummarySellarRating != null) {
            a(cJROrderSummarySellarRating.getSellarRatingModel(), "cache");
        }
    }

    private void a(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.containsKey("cinema") && map.containsKey("cinemaId")) {
                    com.paytm.b.a.a a2 = ag.a(getApplicationContext());
                    a2.a("movies_cached_cinema_id", map.get("cinemaId"), true);
                    a2.a("movies_cached_cinema_name", map.get("cinema"), true);
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    private static String p(String str) {
        String[] split = str.split(" ");
        String str2 = "";
        for (int i2 = 0; i2 < split.length; i2++) {
            if (i2 == split.length - 1) {
                str2 = str2 + split[i2];
            } else {
                str2 = str2 + split[i2] + "_";
            }
        }
        return str2.toLowerCase();
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.aU != null) {
                this.aU.cancel();
                this.aU.purge();
            }
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    private void af() {
        this.bA = (FrameLayout) findViewById(R.id.set_rem_order_summary_lyt);
        this.bA.setVisibility(0);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.recharge_order_extra_option_set_rem, (ViewGroup) null);
        ((RelativeLayout) inflate.findViewById(R.id.container_layout)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJROrderSummaryActivityBase.this.by.f61441d.a(AJROrderSummaryActivityBase.this.getSupportFragmentManager());
                boolean unused = AJROrderSummaryActivityBase.this.bB = true;
            }
        });
        this.bA.addView(inflate);
    }

    private void a(CJRAutomaticSubscriptionCheckModel cJRAutomaticSubscriptionCheckModel) {
        if (this.bk == null) {
            this.bk = cJRAutomaticSubscriptionCheckModel;
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.auto_subscription_order_summary_lyt);
        if (frameLayout.getVisibility() != 0) {
            frameLayout.setVisibility(0);
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.auto_subscription_order_summary_layout, (ViewGroup) null);
            if (this.bk.getStatus().intValue() == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("user_id", com.paytm.utility.a.a((Context) this));
                hashMap.put("automatic_button_visible_yes_or_no", H5AppHandler.CHECK_VALUE);
                hashMap.put("recharge_utilities_service_type", this.bj.getProductDetail().getAttributes().getService());
                net.one97.paytm.j.a.b("automatic_bill_payment_summary_screen_button_visibility", (Map<String, Object>) hashMap, (Context) this);
                inflate.findViewById(R.id.auto_subscription_status_0_lyt).setVisibility(0);
                inflate.findViewById(R.id.auto_subscription_status_1_lyt).setVisibility(8);
                inflate.findViewById(R.id.automatic_subscription_btn).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (AJROrderSummaryActivityBase.this.J != null) {
                            ArrayList<CJRCategoryMap> categoryMap = AJROrderSummaryActivityBase.this.J.getOrderedCartList().get(0).getProductDetail().getCategoryMap();
                            if (categoryMap == null || categoryMap.size() <= 1) {
                                CJROrderedCart cJROrderedCart = AJROrderSummaryActivityBase.this.J.getOrderedCartList().get(0);
                                HashMap hashMap = new HashMap();
                                hashMap.put("recharge_utilities_autopayment_vertical", cJROrderedCart.getProductDetail().getVertical());
                                hashMap.put("recharge_utilities_autopayment_operator", cJROrderedCart.getProductDetail().getBrandName());
                                hashMap.put("recharge_utilities_autopayment_amount", Double.valueOf(cJROrderedCart.getTotalPrice()));
                                hashMap.put("user_id", com.paytm.utility.a.a(view.getContext()));
                                hashMap.put("recharge_utilities_service_type", cJROrderedCart.getProductDetail().getAttributes().getService());
                                hashMap.put("service_type", hashMap.get("recharge_utilities_service_type"));
                                net.one97.paytm.j.a.b("automatic_payment_summary_screen_automatic_clicked", (Map<String, Object>) hashMap, (Context) AJROrderSummaryActivityBase.this);
                            } else {
                                new HashMap();
                                if ("gas".equalsIgnoreCase(categoryMap.get(1).getName().toLowerCase())) {
                                    new net.one97.paytm.recharge.ordersummary.h.d(AJROrderSummaryActivityBase.this).a("book_cylinder", "make_it_automatic_clicked", "", "", "cylinder_booking", "", "");
                                }
                            }
                        }
                        az azVar = az.f61525a;
                        if (az.c(AJROrderSummaryActivityBase.this)) {
                            az azVar2 = az.f61525a;
                            AJROrderSummaryActivityBase aJROrderSummaryActivityBase = AJROrderSummaryActivityBase.this;
                            az.g(aJROrderSummaryActivityBase, aJROrderSummaryActivityBase.bi);
                            return;
                        }
                        Intent intent = new Intent(AJROrderSummaryActivityBase.this, AJRAutomaticSetupActivity.class);
                        intent.putExtra("recharge_number", AJROrderSummaryActivityBase.this.bi);
                        intent.putExtra(CLPConstants.PRODUCT_ID, String.valueOf(AJROrderSummaryActivityBase.this.bj.getProductDetail().getId()));
                        intent.putExtra("operator_logo", AJROrderSummaryActivityBase.this.bh);
                        intent.putExtra("service_type", AJROrderSummaryActivityBase.this.bj.getProductDetail().getAttributes().getService());
                        AJROrderSummaryActivityBase.this.startActivityForResult(intent, 203);
                    }
                });
                inflate.findViewById(R.id.faq_text_view).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        AJROrderSummaryActivityBase.this.a(view);
                    }
                });
                frameLayout.addView(inflate);
            } else if (this.bk.getStatus().intValue() == 1) {
                inflate.findViewById(R.id.auto_subscription_status_1_lyt).setVisibility(0);
                inflate.findViewById(R.id.auto_subscription_status_0_lyt).setVisibility(8);
                b((TextView) inflate.findViewById(R.id.auto_subscription_my_profile_text));
                frameLayout.addView(inflate);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(R.string.auto_subscription_already_active_text));
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, 17, 33);
                ((TextView) findViewById(R.id.auto_subscription_already_active_text)).setText(spannableStringBuilder);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary != null) {
            CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
            HashMap hashMap = new HashMap();
            hashMap.put("recharge_utilities_autopayment_vertical", cJROrderedCart.getProductDetail().getVertical());
            hashMap.put("recharge_utilities_autopayment_operator", cJROrderedCart.getProductDetail().getBrandName());
            hashMap.put("recharge_utilities_autopayment_amount", Double.valueOf(cJROrderedCart.getTotalPrice()));
            hashMap.put("user_id", com.paytm.utility.a.a(view.getContext()));
            hashMap.put("recharge_utilities_service_type", cJROrderedCart.getProductDetail().getAttributes().getService());
            hashMap.put("service_type", cJROrderedCart.getProductDetail().getAttributes().getService());
            net.one97.paytm.j.a.b("automatic_payment_summary_screen_faq's_clicked", (Map<String, Object>) hashMap, (Context) this);
        }
        startActivity(new Intent(view.getContext(), AJRAutomaticPaymentFAQs.class));
    }

    private void q(String str) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("updated_auto_subscription_url", (String) null);
        String b2 = ag.a(getApplicationContext()).b(net.one97.paytm.common.utility.b.aQ, "", true);
        if ((getApplicationContext() == null || net.one97.paytm.recharge.common.utils.z.a(getApplicationContext())) && !TextUtils.isEmpty(b2)) {
            String str2 = (a2 + "?cust_id=" + b2) + "&rech_num=" + str;
            if (URLUtil.isValidUrl(str2)) {
                HashMap<String, String> a3 = com.paytm.utility.a.a((HashMap<String, String>) new HashMap(), (Context) this);
                String c2 = com.paytm.utility.a.c(this, str2);
                if (com.paytm.utility.a.m(this)) {
                    a((Context) this, getResources().getString(R.string.please_wait_progress_msg));
                    net.one97.paytm.common.b.d.a(this, c2, this, a3, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRAutomaticSubscriptionCheckModel(), a.c.HOME, a.b.SILENT).a();
                }
            }
        }
    }

    private void b(TextView textView) {
        String string = getString(R.string.auto_subscription_my_profile_text);
        textView.setText(R.string.auto_subscription_my_profile_text);
        if (string.contains("My Profile")) {
            int indexOf = string.indexOf("My Profile");
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            Spannable spannable = (Spannable) textView.getText();
            int i2 = 10 + indexOf;
            spannable.setSpan(new ExpandedProfileURLSpanNoUnderline("My Profile"), indexOf, i2, 33);
            spannable.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(getApplicationContext(), R.color.paytm_blue)), indexOf, i2, 33);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.need_help_header_layout) {
            if (!ag()) {
                c(0);
            } else if (!com.paytm.utility.a.m(this)) {
                com.paytm.utility.b.b((Context) this, getString(R.string.no_connection), getString(R.string.no_internet_message));
            } else if (SystemClock.elapsedRealtime() - this.bM >= 1000) {
                this.bM = SystemClock.elapsedRealtime();
                CJROrderedCart cJROrderedCart = this.J.getOrderedCartList().get(0);
                cJROrderedCart.setOrderId(this.J.getId());
                show();
                Bundle bundle = new Bundle();
                bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
                net.one97.paytm.deeplink.d.a((Context) this, bundle, (m) this);
            }
        }
    }

    private boolean ag() {
        CJROrderSummary cJROrderSummary = this.J;
        if (cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || this.J.getOrderedCartList().size() <= 0 || this.J.getOrderedCartList().get(0) == null || this.J.getOrderedCartList().get(0).getRechargeConfiguration() == null || TextUtils.isEmpty(this.J.getOrderedCartList().get(0).getRechargeConfiguration().get("recharge_number_3")) || this.J.getOrderedCartList().get(0).getProductDetail().getVerticalId() != ((long) net.one97.paytm.common.utility.b.aY.intValue())) {
            return false;
        }
        return true;
    }

    public void show() {
        RelativeLayout relativeLayout = this.aw;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    public void dismiss() {
        RelativeLayout relativeLayout = this.aw;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        RelativeLayout f51607a;

        public b() {
        }
    }

    private Bundle b(int i2) {
        Bundle bundle = new Bundle();
        CJROrderedCart cJROrderedCart = this.J.getOrderedCartList().get(i2);
        cJROrderedCart.setOrderId(this.J.getId());
        cJROrderedCart.setCreatedAt(this.J.getCreatedAt());
        bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
        CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
        cJRReplacementReason.setParentIssueId(1000001);
        bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, cJRReplacementReason);
        return bundle;
    }

    class e {

        /* renamed from: a  reason: collision with root package name */
        CheckedTextView f51614a;

        e() {
        }
    }

    class c extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private LayoutInflater f51610b;

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public c(Context context) {
            Context unused = AJROrderSummaryActivityBase.this.f51398e = context;
            this.f51610b = (LayoutInflater) AJROrderSummaryActivityBase.this.f51398e.getSystemService("layout_inflater");
        }

        public final int getCount() {
            return AJROrderSummaryActivityBase.this.af.size();
        }

        public final Object getItem(int i2) {
            return Integer.valueOf(i2);
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            e eVar;
            if (view == null) {
                eVar = new e();
                view2 = this.f51610b.inflate(R.layout.contact_all_reason_single_item, (ViewGroup) null);
                eVar.f51614a = (CheckedTextView) view2.findViewById(R.id.singleItem);
                view2.setTag(eVar);
            } else {
                view2 = view;
                eVar = (e) view.getTag();
            }
            if (!TextUtils.isEmpty((CharSequence) AJROrderSummaryActivityBase.this.af.get(i2))) {
                eVar.f51614a.setText(((String) AJROrderSummaryActivityBase.this.af.get(i2)).trim());
            }
            return view2;
        }
    }

    protected class ExpandedURLSpanNoUnderline extends URLSpan {

        /* renamed from: a  reason: collision with root package name */
        CJROrderedCart f51604a;

        public ExpandedURLSpanNoUnderline(String str, CJROrderedCart cJROrderedCart) {
            super(str);
            this.f51604a = cJROrderedCart;
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }

        public void onClick(View view) {
            String url = getURL();
            if (!TextUtils.isEmpty(url)) {
                if (url.equalsIgnoreCase(AJROrderSummaryActivityBase.this.getResources().getString(R.string.order_summary_what_is_paytm_wallet) + "?")) {
                    net.one97.paytm.j.c.a();
                    if (net.one97.paytm.j.c.a("paytmcashFAQ", (String) null) != null) {
                        Intent intent = new Intent(AJROrderSummaryActivityBase.this, AJRWebViewActivity.class);
                        net.one97.paytm.j.c.a();
                        String a2 = com.paytm.utility.c.a(net.one97.paytm.j.c.a("paytmcashFAQ", (String) null), AJROrderSummaryActivityBase.this.getBaseContext());
                        net.one97.paytm.j.c.a();
                        if (!TextUtils.isEmpty(net.one97.paytm.j.c.a("paytmcashFAQ", (String) null))) {
                            intent.putExtra("url", a2);
                        } else {
                            intent.putExtra("url", "https://pages.paytm.com/help.html#newcash");
                        }
                        intent.putExtra("title", AJROrderSummaryActivityBase.this.getResources().getString(R.string.paytm_wallet));
                        AJROrderSummaryActivityBase.this.startActivity(intent);
                    }
                } else if (url.equalsIgnoreCase(AJROrderSummaryActivityBase.this.getResources().getString(R.string.order_summary_contact_us))) {
                    AJROrderSummaryActivityBase.b(AJROrderSummaryActivityBase.this, this.f51604a);
                }
            } else {
                AJROrderSummaryActivityBase.this.onMailAtPaytmClicked((View) null);
            }
        }
    }

    class d extends AsyncTask<Void, Void, String> {

        /* renamed from: b  reason: collision with root package name */
        private String f51612b;

        /* renamed from: c  reason: collision with root package name */
        private String f51613c;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            try {
                String str2 = this.f51612b;
                String unused = AJROrderSummaryActivityBase.this.l = str2;
                if (str != null && str.equalsIgnoreCase("application/pdf")) {
                    AJROrderSummaryActivityBase aJROrderSummaryActivityBase = AJROrderSummaryActivityBase.this;
                    if (s.a() && !s.c((Activity) aJROrderSummaryActivityBase)) {
                        s.b((Activity) aJROrderSummaryActivityBase);
                    } else if (aJROrderSummaryActivityBase.l != null) {
                        aJROrderSummaryActivityBase.c();
                    }
                } else if (str == null || str.equalsIgnoreCase("application/xml")) {
                    AJROrderSummaryActivityBase.this.m();
                    AJROrderSummaryActivityBase.this.v();
                    com.paytm.utility.b.b((Context) AJROrderSummaryActivityBase.this, AJROrderSummaryActivityBase.this.getString(R.string.error), AJROrderSummaryActivityBase.this.getString(R.string.invoice_dwnld_error));
                } else {
                    AJROrderSummaryActivityBase.this.m();
                    boolean unused2 = AJROrderSummaryActivityBase.this.ad = true;
                    Intent intent = new Intent(AJROrderSummaryActivityBase.this, AJRWebViewActivity.class);
                    intent.putExtra("url", str2);
                    if (!TextUtils.isEmpty(this.f51613c)) {
                        intent.putExtra("title", this.f51613c);
                    } else {
                        intent.putExtra("title", AJROrderSummaryActivityBase.this.N);
                    }
                    intent.putExtra(UpiConstants.FROM, "Order_summary");
                    AJROrderSummaryActivityBase.this.startActivity(intent);
                }
            } catch (Exception unused3) {
            }
        }

        public d(String str, String str2) {
            this.f51613c = str2;
            this.f51612b = str;
        }

        private String a() {
            try {
                if (AJROrderSummaryActivityBase.this.u != null) {
                    AJROrderSummaryActivityBase.this.u.setCancelable(true);
                }
                return ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.f51612b).openConnection())).getContentType();
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
                return null;
            }
        }
    }

    class f extends TimerTask {
        private f() {
        }

        /* synthetic */ f(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, byte b2) {
            this();
        }

        public final void run() {
            AJROrderSummaryActivityBase.this.aa();
            AJROrderSummaryActivityBase.this.runOnUiThread(new Runnable() {
                public final void run() {
                    if (!AJROrderSummaryActivityBase.this.isFinishing()) {
                        net.one97.paytm.widget.f.b(AJROrderSummaryActivityBase.this);
                    }
                }
            });
        }
    }

    public final void e() {
        this.aq.setVisibility(8);
        v();
        m();
        runOnUiThread(new Runnable() {
            public final void run() {
                AJROrderSummaryActivityBase.this.findViewById(R.id.summary_progress_bar).setVisibility(8);
                if (AJROrderSummaryActivityBase.this.J == null) {
                    AJROrderSummaryActivityBase.this.findViewById(R.id.scroll_view).setVisibility(8);
                }
            }
        });
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRActionResponse) {
            a((CJRActionResponse) iJRPaytmDataModel, true);
        }
    }

    private void a(CJRActionResponse cJRActionResponse, boolean z) {
        if (cJRActionResponse.getStatus() == 200 && cJRActionResponse.getMessage() != null && TextUtils.isEmpty(cJRActionResponse.getMessage())) {
            this.bc = true;
            b(this.G);
            m();
            v();
        } else if (cJRActionResponse.getMessage() != null && !TextUtils.isEmpty(cJRActionResponse.getMessage())) {
            m();
            v();
            if (z) {
                b(this.G);
            } else {
                n(cJRActionResponse.getMessage());
            }
        } else if (cJRActionResponse.getActions() != null) {
            ArrayList<CJROrderSummaryAction> actions = cJRActionResponse.getActions();
            if (actions.size() > 0) {
                CJROrderSummaryAction cJROrderSummaryAction = actions.get(0);
                if (cJROrderSummaryAction.getUiControl().equalsIgnoreCase("browser") && cJROrderSummaryAction.getUrlParams() != null && !TextUtils.isEmpty(cJROrderSummaryAction.getUrlParams().getUrl())) {
                    new d(cJROrderSummaryAction.getUrlParams().getUrl(), cJRActionResponse.getTitle()).execute(new Void[0]);
                }
            }
        } else if (!TextUtils.isEmpty(cJRActionResponse.getError())) {
            m();
            v();
            n(cJRActionResponse.getError());
        } else {
            v();
            m();
        }
    }

    class ExpandedProfileURLSpanNoUnderline extends URLSpan {
        public ExpandedProfileURLSpanNoUnderline(String str) {
            super(str);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }

        public void onClick(View view) {
            AJROrderSummaryActivityBase.this.startActivity(new Intent(AJROrderSummaryActivityBase.this, AJRAutomaticSubscriptionListActivity.class));
        }
    }

    private String i(CJROrderedCart cJROrderedCart) {
        String str;
        String statusText = cJROrderedCart.getStatusText();
        if (TextUtils.isEmpty(cJROrderedCart.getName()) || !cJROrderedCart.getName().equalsIgnoreCase(getString(R.string.paytm_gift_voucher))) {
            return statusText;
        }
        String status = cJROrderedCart.getStatus();
        if (cJROrderedCart.getRechargeConfiguration() == null) {
            return statusText;
        }
        if (cJROrderedCart.getRechargeConfiguration().containsKey("name")) {
            str = cJROrderedCart.getRechargeConfiguration().get("name");
        } else {
            str = cJROrderedCart.getRechargeConfiguration().get("targetMobile");
        }
        boolean z = !cJROrderedCart.getRechargeConfiguration().containsKey("targetMobile");
        if (TextUtils.isEmpty(str) || !status.equalsIgnoreCase("SUCCESS")) {
            return statusText;
        }
        if (z) {
            return getString(R.string.gv_purchase_self);
        }
        return getString(R.string.gv_success_sent_to, new Object[]{str});
    }

    public class a extends WebViewClient {
        public a() {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            ProgressBar progressBar = (ProgressBar) AJROrderSummaryActivityBase.this.findViewById(R.id.adworks_progress_bar);
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            super.onPageStarted(webView, str, bitmap);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return true;
            }
            Intent intent = new Intent(AJROrderSummaryActivityBase.this, AJREmbedWebView.class);
            intent.putExtra("url", str);
            intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, "Offer");
            AJROrderSummaryActivityBase.this.startActivity(intent);
            return true;
        }

        public final void onPageFinished(WebView webView, String str) {
            ProgressBar progressBar = (ProgressBar) AJROrderSummaryActivityBase.this.findViewById(R.id.adworks_progress_bar);
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            super.onPageFinished(webView, str);
        }
    }

    private void c(int i2) {
        if (!com.paytm.utility.a.m(this)) {
            com.paytm.utility.b.b((Context) this, getString(R.string.no_connection), getString(R.string.no_internet_message));
        } else {
            new net.one97.paytm.recharge.j(this).getUpdatedCstOrderIssueIntent(this, b(i2), this);
        }
    }

    private long a(Uri uri) {
        boolean z;
        int applicationEnabledSetting = getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
        if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
            b(false);
            z = false;
        } else {
            z = true;
        }
        if (!z || !"mounted".equals(Environment.getExternalStorageState())) {
            m();
            v();
            return 0;
        }
        this.aZ = (DownloadManager) getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        String str = "Invoice_" + this.J.getId();
        if (!(this.J.getOrderedCartList().get(0) == null || this.J.getOrderedCartList().get(0).getProductDetail().getName() == null || !this.J.getOrderedCartList().get(0).getProductDetail().getName().equalsIgnoreCase("Bus Ticket"))) {
            str = "Ticket_" + this.J.getId();
        }
        request.setTitle(str);
        request.setDescription("Downloading...");
        request.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, str + ".pdf");
        request.setNotificationVisibility(1);
        try {
            return this.aZ.enqueue(request);
        } catch (SecurityException e2) {
            q.b(e2.getMessage());
            return 0;
        }
    }

    static /* synthetic */ void a(Cursor cursor) {
        if (cursor != null) {
            try {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ void f(AJROrderSummaryActivityBase aJROrderSummaryActivityBase) {
        aJROrderSummaryActivityBase.aP.startAnimation(AnimationUtils.loadAnimation(aJROrderSummaryActivityBase, R.anim.fade_out));
        aJROrderSummaryActivityBase.aP.setVisibility(8);
    }

    static /* synthetic */ void b(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, int i2) {
        try {
            aJROrderSummaryActivityBase.c(i2);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void k(AJROrderSummaryActivityBase aJROrderSummaryActivityBase) {
        Intent h2 = ba.h(aJROrderSummaryActivityBase);
        h2.putExtra("previousScreen", "bus_order_summary");
        aJROrderSummaryActivityBase.startActivity(h2);
    }

    static /* synthetic */ void a(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, CJRLedger cJRLedger, int i2) {
        aJROrderSummaryActivityBase.a((Context) aJROrderSummaryActivityBase, aJROrderSummaryActivityBase.getResources().getString(R.string.please_wait_progress_msg));
        aJROrderSummaryActivityBase.bI = true;
        CJRButton buttonWithTag = cJRLedger.getTransactionList().get(0).getButtonWithTag(i2);
        cJRLedger.getTransactionList().get(0).getTxnAmount();
        if (buttonWithTag == null) {
            return;
        }
        if (buttonWithTag.getAction().equalsIgnoreCase("Modal")) {
            final Dialog dialog = new Dialog(aJROrderSummaryActivityBase);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.dialog_modal);
            ((RoboTextView) dialog.findViewById(R.id.title)).setText(buttonWithTag.getModalButtonHeader());
            ((RoboTextView) dialog.findViewById(R.id.message)).setText(buttonWithTag.getModalButtonText());
            LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.lyt_btn_container);
            ArrayList<CJRModalButton> modalButtonList = buttonWithTag.getModalButtonList();
            linearLayout.removeAllViews();
            Iterator<CJRModalButton> it2 = modalButtonList.iterator();
            while (it2.hasNext()) {
                final CJRModalButton next = it2.next();
                if (next.getModalActionUrlRequest() == null || next.getModalActionUrlRequest().getOperationType() != "P2P_TRANSFER") {
                    Button button = new Button(aJROrderSummaryActivityBase);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.weight = 1.0f;
                    button.setLayoutParams(layoutParams);
                    button.setText(next.getmModalButtonName());
                    button.setTextSize(2, 16.0f);
                    com.paytm.utility.b.a((TextView) button);
                    button.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            String modalActionUrl = next.getModalActionUrl();
                            next.getModalActionPage();
                            if (modalActionUrl != null) {
                                AJROrderSummaryActivityBase.this.a(modalActionUrl, AJROrderSummaryActivityBase.b(next.getModalActionUrlRequest()));
                            }
                            next.getModalRespAction();
                            dialog.dismiss();
                        }
                    });
                    linearLayout.addView(button);
                }
            }
            dialog.show();
            return;
        }
        aJROrderSummaryActivityBase.a(buttonWithTag.getActionUrl(), a(buttonWithTag.getActionUrlRequest()));
    }

    static /* synthetic */ void a(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, NetworkCustomError networkCustomError) {
        try {
            String alertMessage = networkCustomError.getAlertMessage();
            String alertTitle = networkCustomError.getAlertTitle();
            if (TextUtils.isEmpty(alertTitle) || TextUtils.isEmpty(alertMessage)) {
                alertMessage = aJROrderSummaryActivityBase.getResources().getString(R.string.replacement_fraud_error);
                alertTitle = aJROrderSummaryActivityBase.getResources().getString(R.string.replacement_fraud_error_title);
            }
            com.paytm.utility.b.b((Context) aJROrderSummaryActivityBase, alertTitle, alertMessage);
        } catch (Resources.NotFoundException e2) {
            q.b(e2.getMessage());
        }
    }

    static /* synthetic */ boolean a(CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        if (cJROrderSummaryProductDetail != null) {
            return "Deals".equalsIgnoreCase(cJROrderSummaryProductDetail.getVertical());
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006b, code lost:
        r6 = r13.getProductDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(net.one97.paytm.AJROrderSummaryActivityBase r12, net.one97.paytm.common.entity.shopping.CJROrderedCart r13, java.util.ArrayList r14) {
        /*
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder     // Catch:{ Exception -> 0x01e3 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x01e3 }
            android.app.AlertDialog r0 = r0.create()     // Catch:{ Exception -> 0x01e3 }
            android.view.LayoutInflater r1 = r12.getLayoutInflater()     // Catch:{ Exception -> 0x01e3 }
            r2 = 2131560684(0x7f0d08ec, float:1.8746747E38)
            r3 = 0
            android.view.View r1 = r1.inflate(r2, r3)     // Catch:{ Exception -> 0x01e3 }
            r2 = 2131368686(0x7f0a1aee, float:1.835733E38)
            android.view.View r2 = r1.findViewById(r2)     // Catch:{ Exception -> 0x01e3 }
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2     // Catch:{ Exception -> 0x01e3 }
            r3 = 2131363563(0x7f0a06eb, float:1.8346938E38)
            android.view.View r3 = r1.findViewById(r3)     // Catch:{ Exception -> 0x01e3 }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ Exception -> 0x01e3 }
            if (r13 == 0) goto L_0x0038
            android.content.res.Resources r4 = r12.getResources()     // Catch:{ Exception -> 0x01e3 }
            r5 = 2131961811(0x7f1327d3, float:1.956033E38)
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x01e3 }
            r3.setText(r4)     // Catch:{ Exception -> 0x01e3 }
            goto L_0x0046
        L_0x0038:
            android.content.res.Resources r4 = r12.getResources()     // Catch:{ Exception -> 0x01e3 }
            r5 = 2131963648(0x7f132f00, float:1.9564055E38)
            java.lang.String r4 = r4.getString(r5)     // Catch:{ Exception -> 0x01e3 }
            r3.setText(r4)     // Catch:{ Exception -> 0x01e3 }
        L_0x0046:
            r3 = 1
            java.lang.String r4 = "null"
            if (r13 == 0) goto L_0x0186
            int r5 = r13.getQuantity()     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r6 = r13.getAggregateItemPrice()     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x01e3 }
            android.content.res.Resources r7 = r12.getResources()     // Catch:{ Exception -> 0x01e3 }
            r8 = 2131956541(0x7f13133d, float:1.954964E38)
            java.lang.String r7 = r7.getString(r8)     // Catch:{ Exception -> 0x01e3 }
            android.view.View r6 = r12.b((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x01e3 }
            r2.addView(r6)     // Catch:{ Exception -> 0x01e3 }
            if (r13 == 0) goto L_0x009d
            net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail r6 = r13.getProductDetail()     // Catch:{ Exception -> 0x01e3 }
            if (r6 == 0) goto L_0x009d
            java.lang.String r7 = r6.getProductType()     // Catch:{ Exception -> 0x01e3 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01e3 }
            if (r7 != 0) goto L_0x009d
            java.lang.String r7 = r6.getVertical()     // Catch:{ Exception -> 0x01e3 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01e3 }
            if (r7 != 0) goto L_0x009d
            java.lang.String r7 = r6.getProductType()     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r8 = "Marketplace"
            boolean r7 = r7.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x01e3 }
            if (r7 == 0) goto L_0x009d
            long r6 = r6.getVerticalId()     // Catch:{ Exception -> 0x01e3 }
            r8 = 49
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x009d
            r6 = 1
            goto L_0x009e
        L_0x009d:
            r6 = 0
        L_0x009e:
            r7 = 2131953859(0x7f1308c3, float:1.95442E38)
            if (r6 == 0) goto L_0x010d
            java.lang.String r6 = r13.getShippingCharge()     // Catch:{ Exception -> 0x01e3 }
            if (r6 == 0) goto L_0x00d2
            java.lang.String r6 = r13.getShippingCharge()     // Catch:{ Exception -> 0x01e3 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x01e3 }
            if (r6 != 0) goto L_0x00d2
            java.lang.String r6 = r13.getShippingCharge()     // Catch:{ Exception -> 0x01e3 }
            boolean r6 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x01e3 }
            if (r6 != 0) goto L_0x00d2
            java.lang.String r6 = r13.getShippingCharge()     // Catch:{ Exception -> 0x01e3 }
            android.content.res.Resources r8 = r12.getResources()     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r7 = r8.getString(r7)     // Catch:{ Exception -> 0x01e3 }
            android.view.View r6 = r12.b((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x01e3 }
            r2.addView(r6)     // Catch:{ Exception -> 0x01e3 }
            goto L_0x0161
        L_0x00d2:
            java.lang.String r6 = r13.getConvFee()     // Catch:{ Exception -> 0x01e3 }
            if (r6 == 0) goto L_0x0161
            java.lang.String r6 = r13.getConvFee()     // Catch:{ Exception -> 0x01e3 }
            boolean r6 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x01e3 }
            if (r6 != 0) goto L_0x0161
            java.lang.String r6 = r13.getConvFee()     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r8 = "0"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x01e3 }
            if (r6 != 0) goto L_0x0161
            java.lang.String r6 = r13.getConvFee()     // Catch:{ Exception -> 0x01e3 }
            double r8 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x01e3 }
            double r10 = (double) r5     // Catch:{ Exception -> 0x01e3 }
            double r8 = r8 * r10
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x01e3 }
            android.content.res.Resources r8 = r12.getResources()     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r7 = r8.getString(r7)     // Catch:{ Exception -> 0x01e3 }
            android.view.View r6 = r12.b((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x01e3 }
            r2.addView(r6)     // Catch:{ Exception -> 0x01e3 }
            goto L_0x0161
        L_0x010d:
            java.lang.String r6 = r13.getShippingCharge()     // Catch:{ Exception -> 0x01e3 }
            if (r6 == 0) goto L_0x0131
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x01e3 }
            if (r8 != 0) goto L_0x0131
            boolean r8 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x01e3 }
            if (r8 != 0) goto L_0x0131
            android.content.res.Resources r8 = r12.getResources()     // Catch:{ Exception -> 0x01e3 }
            r9 = 2131963237(0x7f132d65, float:1.9563222E38)
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x01e3 }
            android.view.View r6 = r12.b((java.lang.String) r6, (java.lang.String) r8)     // Catch:{ Exception -> 0x01e3 }
            r2.addView(r6)     // Catch:{ Exception -> 0x01e3 }
        L_0x0131:
            java.lang.String r6 = r13.getConvFee()     // Catch:{ Exception -> 0x01e3 }
            if (r6 == 0) goto L_0x0161
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x01e3 }
            if (r8 != 0) goto L_0x0161
            boolean r6 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x01e3 }
            if (r6 != 0) goto L_0x0161
            java.lang.String r6 = r13.getConvFee()     // Catch:{ Exception -> 0x01e3 }
            double r8 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x01e3 }
            double r10 = (double) r5     // Catch:{ Exception -> 0x01e3 }
            double r8 = r8 * r10
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x01e3 }
            android.content.res.Resources r8 = r12.getResources()     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r7 = r8.getString(r7)     // Catch:{ Exception -> 0x01e3 }
            android.view.View r6 = r12.b((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x01e3 }
            r2.addView(r6)     // Catch:{ Exception -> 0x01e3 }
        L_0x0161:
            double r6 = r13.getDiscountAmount()     // Catch:{ Exception -> 0x01e3 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0187
            double r6 = r13.getDiscountAmount()     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r13 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x01e3 }
            android.content.res.Resources r6 = r12.getResources()     // Catch:{ Exception -> 0x01e3 }
            r7 = 2131954316(0x7f130a8c, float:1.9545128E38)
            java.lang.String r6 = r6.getString(r7)     // Catch:{ Exception -> 0x01e3 }
            android.view.View r13 = r12.b((java.lang.String) r13, (java.lang.String) r6)     // Catch:{ Exception -> 0x01e3 }
            r2.addView(r13)     // Catch:{ Exception -> 0x01e3 }
            goto L_0x0187
        L_0x0186:
            r5 = 1
        L_0x0187:
            if (r14 == 0) goto L_0x01d6
            int r13 = r14.size()     // Catch:{ Exception -> 0x01e3 }
            if (r13 <= 0) goto L_0x01d6
            java.util.Iterator r13 = r14.iterator()     // Catch:{ Exception -> 0x01e3 }
        L_0x0193:
            boolean r14 = r13.hasNext()     // Catch:{ Exception -> 0x01e3 }
            if (r14 == 0) goto L_0x01d6
            java.lang.Object r14 = r13.next()     // Catch:{ Exception -> 0x01e3 }
            net.one97.paytm.common.entity.shopping.CJROtherTaxes r14 = (net.one97.paytm.common.entity.shopping.CJROtherTaxes) r14     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r6 = r14.getValue()     // Catch:{ Exception -> 0x01e3 }
            java.lang.String r14 = r14.getLabel()     // Catch:{ Exception -> 0x01e3 }
            if (r14 == 0) goto L_0x0193
            boolean r7 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x01e3 }
            if (r7 != 0) goto L_0x0193
            boolean r7 = r14.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x01e3 }
            if (r7 != 0) goto L_0x0193
            if (r6 == 0) goto L_0x0193
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x01e3 }
            if (r7 != 0) goto L_0x0193
            boolean r7 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x01e3 }
            if (r7 != 0) goto L_0x0193
            double r6 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x01e3 }
            double r8 = (double) r5     // Catch:{ Exception -> 0x01e3 }
            double r6 = r6 * r8
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x01e3 }
            android.view.View r14 = r12.b((java.lang.String) r6, (java.lang.String) r14)     // Catch:{ Exception -> 0x01e3 }
            r2.addView(r14)     // Catch:{ Exception -> 0x01e3 }
            goto L_0x0193
        L_0x01d6:
            r0.setView(r1)     // Catch:{ Exception -> 0x01e3 }
            r0.setCancelable(r3)     // Catch:{ Exception -> 0x01e3 }
            r0.setCanceledOnTouchOutside(r3)     // Catch:{ Exception -> 0x01e3 }
            r0.show()     // Catch:{ Exception -> 0x01e3 }
            return
        L_0x01e3:
            r12 = move-exception
            java.lang.String r12 = r12.getMessage()
            com.paytm.utility.q.b(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.AJROrderSummaryActivityBase.a(net.one97.paytm.AJROrderSummaryActivityBase, net.one97.paytm.common.entity.shopping.CJROrderedCart, java.util.ArrayList):void");
    }

    static /* synthetic */ void a(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, CJROrderedCart cJROrderedCart) {
        try {
            AlertDialog create = new AlertDialog.Builder(aJROrderSummaryActivityBase).create();
            View inflate = aJROrderSummaryActivityBase.getLayoutInflater().inflate(R.layout.tax_breakdown_layout, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.price_break_up_container);
            TextView textView = (TextView) inflate.findViewById(R.id.container_header);
            if (cJROrderedCart != null) {
                textView.setText(aJROrderSummaryActivityBase.getResources().getString(R.string.price_breakup));
            } else {
                textView.setText(aJROrderSummaryActivityBase.getResources().getString(R.string.tax_breakup));
            }
            if (cJROrderedCart != null) {
                linearLayout.addView(aJROrderSummaryActivityBase.b(String.valueOf(cJROrderedCart.getAggregateItemPrice()), aJROrderSummaryActivityBase.getResources().getString(R.string.price)));
                String convFee = cJROrderedCart.getConvFee();
                if (convFee != null && !TextUtils.isEmpty(convFee) && !convFee.equalsIgnoreCase("null")) {
                    String valueOf = String.valueOf(Double.parseDouble(cJROrderedCart.getConvFee()));
                    linearLayout.addView(aJROrderSummaryActivityBase.b(valueOf, aJROrderSummaryActivityBase.getResources().getString(R.string.convenience_fee) + " " + aJROrderSummaryActivityBase.getResources().getString(R.string.inclusive_of_tax_braces)));
                }
                if (cJROrderedCart.getDiscountAmount() > 0.0d) {
                    linearLayout.addView(aJROrderSummaryActivityBase.b(String.valueOf(cJROrderedCart.getDiscountAmount()), aJROrderSummaryActivityBase.getResources().getString(R.string.discount)));
                }
            }
            create.setView(inflate);
            create.setCancelable(true);
            create.setCanceledOnTouchOutside(true);
            create.show();
        } catch (Exception e2) {
            aJROrderSummaryActivityBase.getLocalClassName();
            q.c(e2.getMessage());
        }
    }

    static /* synthetic */ void a(TextView textView, TextView textView2, TextView textView3) {
        textView.setTypeface((Typeface) null, 0);
        textView2.setTypeface((Typeface) null, 0);
        if (textView3 != null) {
            textView3.setTypeface((Typeface) null, 0);
        }
    }

    static /* synthetic */ boolean b(CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        return cJROrderSummaryProductDetail != null && cJROrderSummaryProductDetail != null && !TextUtils.isEmpty(cJROrderSummaryProductDetail.getProductType()) && !TextUtils.isEmpty(cJROrderSummaryProductDetail.getVertical()) && cJROrderSummaryProductDetail.getProductType().equalsIgnoreCase("Marketplace") && l.b(cJROrderSummaryProductDetail.getVertical());
    }

    static /* synthetic */ boolean c(CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        String valueOf = String.valueOf(cJROrderSummaryProductDetail.getId());
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("PaytmCashProductId", (String) null);
        return !TextUtils.isEmpty(a2) && !TextUtils.isEmpty(valueOf) && a2.equalsIgnoreCase(valueOf);
    }

    static /* synthetic */ void a(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, View view) {
        View inflate = LayoutInflater.from(aJROrderSummaryActivityBase).inflate(R.layout.pfa_description_layout, (ViewGroup) null);
        inflate.setBackground(aJROrderSummaryActivityBase.getResources().getDrawable(R.drawable.more_info_callout_pdp_02));
        net.one97.paytm.j.c.a();
        List<String> y = net.one97.paytm.j.c.y();
        TextView textView = (TextView) inflate.findViewById(R.id.pfa_desc_text_1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.pfa_desc_text_2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.pfa_desc_text_3);
        TextView textView4 = (TextView) inflate.findViewById(R.id.pfa_desc_text_4);
        if (y != null && y.size() > 0) {
            if (y.get(0) != null) {
                textView.setText(y.get(0));
            }
            if (y.get(1) != null) {
                textView2.setText(y.get(1));
            }
            if (y.get(2) != null) {
                textView3.setText(y.get(2));
            }
            if (y.get(3) != null) {
                textView4.setText(y.get(3));
            }
        }
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(view);
    }

    static /* synthetic */ void b(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, CJROrderedCart cJROrderedCart) {
        if (cJROrderedCart != null) {
            CJROrderSummary cJROrderSummary = aJROrderSummaryActivityBase.J;
            if (cJROrderSummary != null) {
                cJROrderedCart.setOrderId(cJROrderSummary.getId());
                Bundle bundle = new Bundle();
                bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
                net.one97.paytm.deeplink.d.a(aJROrderSummaryActivityBase.getApplicationContext(), bundle);
                return;
            }
            return;
        }
        aJROrderSummaryActivityBase.onMailAtPaytmClicked((View) null);
    }

    static /* synthetic */ void b(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary");
            String a2 = com.paytm.utility.a.a((Context) aJROrderSummaryActivityBase);
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("movie_user_id", a2);
            }
            hashMap.put("movie_order_failure_action_name", str);
            if (!(aJROrderSummaryActivityBase.J == null || aJROrderSummaryActivityBase.J.getOrderedCartList() == null || aJROrderSummaryActivityBase.J.getOrderedCartList().size() <= 0 || aJROrderSummaryActivityBase.J.getOrderedCartList().get(0).getMetaDataResponse() == null)) {
                Object metaDataResponse = aJROrderSummaryActivityBase.J.getOrderedCartList().get(0).getMetaDataResponse();
                com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
                CJROrderSummaryMetadataResponse cJROrderSummaryMetadataResponse = (CJROrderSummaryMetadataResponse) fVar.a(fVar.a(metaDataResponse), CJROrderSummaryMetadataResponse.class);
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getCinema())) {
                    hashMap.put("movie_cinema_name", cJROrderSummaryMetadataResponse.getCinema());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getMovie())) {
                    hashMap.put("movie_movie_name", cJROrderSummaryMetadataResponse.getMovie());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getCitySearched())) {
                    hashMap.put("movie_city_name", cJROrderSummaryMetadataResponse.getCitySearched());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getSource())) {
                    hashMap.put("movie_cinema_listing_type", cJROrderSummaryMetadataResponse.getSource());
                }
                if (!TextUtils.isEmpty(cJROrderSummaryMetadataResponse.getShowTime())) {
                    hashMap.put("movie_show_timing_bucket", cJROrderSummaryMetadataResponse.getShowTime());
                }
            }
            net.one97.paytm.j.a.b("movie_order_failure_action_clicked", (Map<String, Object>) hashMap, (Context) aJROrderSummaryActivityBase);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    static /* synthetic */ void a(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, g gVar) {
        gVar.cD.setVisibility(8);
        gVar.cx.setVisibility(8);
        gVar.cE.setPadding(0, 0, 0, 0);
        gVar.cC.setPadding(0, aJROrderSummaryActivityBase.bG / 2, 0, 0);
        LinearLayout linearLayout = gVar.bA;
        int i2 = aJROrderSummaryActivityBase.bG;
        linearLayout.setPadding(i2, i2, i2, 0);
        gVar.cs.setPadding(aJROrderSummaryActivityBase.bG / 2, 0, 0, 0);
    }

    static /* synthetic */ void a(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, String str, CJROrderedCart cJROrderedCart, String str2) {
        try {
            String thumbnail = cJROrderedCart.getProductDetail().getThumbnail();
            Intent intent = new Intent(aJROrderSummaryActivityBase, AJRPaytmAutomaticConfirmActivity.class);
            CJROrderSummaryProductDetail productDetail = cJROrderedCart.getProductDetail();
            if (cJROrderedCart != null) {
                if (!(productDetail == null || productDetail.getVertical() == null)) {
                    if (productDetail.getVertical().equalsIgnoreCase(aJROrderSummaryActivityBase.getResources().getString(R.string.fs_name_recharge))) {
                        if (!TextUtils.isEmpty(cJROrderedCart.getRechargeNumber()) && cJROrderedCart.getRechargeNumber() != null) {
                            intent.putExtra("recharge_number", cJROrderedCart.getRechargeNumber());
                        }
                        if (!TextUtils.isEmpty(cJROrderedCart.getRechargePrice()) && cJROrderedCart.getRechargePrice() != null) {
                            intent.putExtra("price", cJROrderedCart.getRechargePrice());
                        }
                    } else if (productDetail.getVertical().equalsIgnoreCase(aJROrderSummaryActivityBase.getResources().getString(R.string.fs_name_wallet))) {
                        intent.putExtra("price", str2);
                    }
                }
                intent.putExtra(com.business.merchant_payments.common.utility.AppConstants.DURATION, str);
                intent.putExtra("expiryDate", m(str));
                if (!TextUtils.isEmpty(thumbnail)) {
                    intent.putExtra("automatic_operator_url", thumbnail);
                }
                if (cJROrderedCart != null) {
                    intent.putExtra("cart", cJROrderedCart);
                }
                if (!TextUtils.isEmpty(cJROrderedCart.getName())) {
                    intent.putExtra("automatic_name", cJROrderedCart.getName());
                }
            }
            aJROrderSummaryActivityBase.startActivity(intent);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    static /* synthetic */ void a(AJROrderSummaryActivityBase aJROrderSummaryActivityBase, String str, CJROrderedCart cJROrderedCart) {
        AlertDialog.Builder builder = new AlertDialog.Builder(aJROrderSummaryActivityBase);
        View inflate = aJROrderSummaryActivityBase.getLayoutInflater().inflate(R.layout.layout_confirm_wallet_schedule_amount, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.text_title)).setText(aJROrderSummaryActivityBase.getResources().getString(R.string.auto_recharge_alert_header));
        CustomAutoCompleteTextView customAutoCompleteTextView = (CustomAutoCompleteTextView) inflate.findViewById(R.id.txt_new_label);
        if (cJROrderedCart.getRechargePrice() != null) {
            customAutoCompleteTextView.setText(cJROrderedCart.getRechargePrice());
        }
        builder.setView(inflate).setPositiveButton(aJROrderSummaryActivityBase.getResources().getString(R.string.auto_recharge_go_ahead), (DialogInterface.OnClickListener) null).setNegativeButton(aJROrderSummaryActivityBase.getResources().getString(R.string.menu_cancel), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        final AlertDialog alertDialog = create;
        final CustomAutoCompleteTextView customAutoCompleteTextView2 = customAutoCompleteTextView;
        final String str2 = str;
        final CJROrderedCart cJROrderedCart2 = cJROrderedCart;
        create.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                alertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        String obj = customAutoCompleteTextView2.getText().toString();
                        if (obj == null || obj.trim().length() <= 0) {
                            com.paytm.utility.b.b((Context) AJROrderSummaryActivityBase.this, AJROrderSummaryActivityBase.this.getResources().getString(R.string.fav_name_empty_alert_header), AJROrderSummaryActivityBase.this.getResources().getString(R.string.fav_name_empty_alert));
                            return;
                        }
                        AJROrderSummaryActivityBase.a(AJROrderSummaryActivityBase.this, str2, cJROrderedCart2, obj);
                        alertDialog.dismiss();
                    }
                });
                alertDialog.getButton(-2).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
            }
        });
        create.show();
        InputMethodManager inputMethodManager = (InputMethodManager) aJROrderSummaryActivityBase.getSystemService("input_method");
        if (customAutoCompleteTextView != null && customAutoCompleteTextView.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(customAutoCompleteTextView.getWindowToken(), 0);
        }
    }
}
