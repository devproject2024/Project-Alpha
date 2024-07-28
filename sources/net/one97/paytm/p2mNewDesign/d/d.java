package net.one97.paytm.p2mNewDesign.d;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sendbird.android.constant.StringSet;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.cashback.posttxn.e;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponse;
import net.one97.paytm.common.entity.paymentsbank.CJRAccountSummary;
import net.one97.paytm.common.entity.postpaid.CJRPPAccount;
import net.one97.paytm.common.entity.postpaid.CJRPPUserProfileKycTnc;
import net.one97.paytm.common.entity.replacement.CJRReplacementReason;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.widgets.a.a;
import net.one97.paytm.common.widgets.c;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.network.g;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;
import net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MyOrdersAPIResponse;
import net.one97.paytm.p2mNewDesign.f.k;
import net.one97.paytm.postpayment.models.CJRObdResponse;
import net.one97.paytm.postpayment.utils.WalletCircularProgressBar;
import net.one97.paytm.splitbill.SBMarkAsPaid;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ShimmerFrameLayout;
import net.one97.paytm.utils.at;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel;
import net.one97.paytm.wallet.d.j;
import net.one97.paytm.wallet.d.k;
import net.one97.paytm.wallet.d.l;
import net.one97.paytm.wallet.f.i;
import net.one97.paytm.wallet.newdesign.activity.PaySendActivityV2;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;
import net.one97.paytm.wallet.rateMerchant.RateMerchantHelper;
import net.one97.paytm.wallet.rateMerchant.b;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends h implements View.OnClickListener, b, a, m {

    /* renamed from: f  reason: collision with root package name */
    private static int f51071f = 5000;

    /* renamed from: g  reason: collision with root package name */
    private static int f51072g = 15;

    /* renamed from: h  reason: collision with root package name */
    private static int f51073h;
    private ImageView A;
    private RelativeLayout B;
    private TextView C;
    private String D;
    private TextView E;
    private RelativeLayout F;
    private RelativeLayout G;
    private RelativeLayout H;
    private Boolean I = Boolean.FALSE;
    private TextView J;
    private LinearLayout K;
    private RelativeLayout L;
    private ImageView M;
    private TextView N;
    private TextView O;
    private TextView P;
    private TextView Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private TextView W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    double f51074a;
    private String aA;
    private String aB = "₹ ";
    private String aC;
    private RelativeLayout aD;
    private RelativeLayout aE;
    private WalletCircularProgressBar aF;
    private c aG = null;
    private boolean aH;
    private boolean aI;
    private String aJ;
    private Double aK;
    private k aL;
    private net.one97.paytm.wallet.j.a aM;
    private boolean aN = false;
    private boolean aO = false;
    private String aP;
    private String aQ;
    private String aR;
    private String aS;
    private TextView aT;
    private String aU;
    private boolean aV;
    private boolean aW;
    private String aX;
    private boolean aY;
    private String aZ;
    private String aa;
    private RelativeLayout ab;
    private TextView ac;
    private boolean ad = true;
    private Handler ae;
    private boolean af = false;
    private Bundle ag = null;
    private TextView ah;
    private boolean ai;
    private double aj;
    private BaseUpiResponse ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao = false;
    private String ap;
    /* access modifiers changed from: private */
    public String aq;
    /* access modifiers changed from: private */
    public String ar;
    private LottieAnimationView as;
    /* access modifiers changed from: private */
    public Activity at;
    private boolean au;
    private RelativeLayout av;
    private RelativeLayout aw;
    private RelativeLayout ax;
    private boolean ay;
    private RelativeLayout az;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.wallet.d.h f51075b;
    private boolean bA;
    private int bB;
    private Handler bC = null;
    private Runnable bD = null;
    private String ba;
    private boolean bb;
    private ViewGroup bc;
    private LinearLayout bd;
    private LinearLayout be;
    /* access modifiers changed from: private */
    public LinearLayout bf;
    private FrameLayout bg;
    private ImageView bh;
    private Runnable bi = new Runnable() {
        public final void run() {
            d.this.C();
        }
    };
    private e bj;
    private boolean bk = false;
    private String bl;
    private String bm;
    private String bn;
    private String bo;
    private String bp;
    private RelativeLayout bq;
    private ShimmerFrameLayout br;
    private boolean bs = false;
    private int bt = 0;
    private int bu = 1000;
    private boolean bv = false;
    private ChatPaymentIntegrationResponseModel bw;
    private String bx;
    private String by;
    /* access modifiers changed from: private */
    public IStaticWidget bz;

    /* renamed from: c  reason: collision with root package name */
    TextView f51076c;

    /* renamed from: d  reason: collision with root package name */
    TextView f51077d;

    /* renamed from: e  reason: collision with root package name */
    String f51078e;

    /* renamed from: i  reason: collision with root package name */
    private String f51079i;
    private String j;
    private IJRDataModel k;
    private String l;
    private boolean m = false;
    private Bundle n;
    private String o;
    private String p;
    private String q;
    private TextView r;
    private int s = 1;
    private boolean t;
    private String u;
    private Dialog v;
    private String w;
    private String x;
    private String y;
    private View z;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C() {
        this.ad = false;
    }

    public static Fragment a(IJRDataModel iJRDataModel, String str, String str2, String str3, boolean z2, String str4, String str5, String str6, String str7, double d2, String str8, String str9, String str10, boolean z3, boolean z4, String str11, String str12, String str13) {
        Bundle bundle = new Bundle();
        IJRDataModel iJRDataModel2 = iJRDataModel;
        bundle.putSerializable("data", iJRDataModel);
        bundle.putString("phone_no", str9);
        String str14 = str;
        bundle.putString("name", str);
        String str15 = str2;
        bundle.putString("amount", str2);
        String str16 = str3;
        bundle.putString(CJRQRScanResultModel.KEY_COMMENT_SMALL, str3);
        boolean z5 = z2;
        bundle.putBoolean("isP2B", z2);
        String str17 = str4;
        bundle.putString(PayUtility.ACCOUNT_NUMBER, str4);
        double d3 = d2;
        bundle.putDouble("txn_fee", d2);
        String str18 = str5;
        bundle.putString("paymentMode", str5);
        String str19 = str6;
        bundle.putString("paymentType", str6);
        String str20 = str7;
        bundle.putString("tagline", str7);
        bundle.putString(PayUtility.BANK_NAME, str10);
        String str21 = str8;
        bundle.putString("key_via", str8);
        bundle.putBoolean("is_upi", z3);
        bundle.putBoolean("is_from_deeplink", z4);
        bundle.putString("ref_id", str11);
        bundle.putString("payee_vpa", str13);
        bundle.putString(UpiConstants.EXTRA_PAYER_VPA, str12);
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d A[Catch:{ Exception -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0090 A[Catch:{ Exception -> 0x00a8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r10, android.widget.TextView r11) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            r2 = 1
            r11.setTypeface(r1, r2)
            android.graphics.Typeface r3 = r11.getTypeface()     // Catch:{ Exception -> 0x00a8 }
            if (r3 == 0) goto L_0x0016
            android.graphics.Typeface r3 = r11.getTypeface()     // Catch:{ Exception -> 0x00a8 }
            if (r3 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r3 = r1
            goto L_0x001c
        L_0x0016:
            java.lang.String r3 = "sans-serif-medium"
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r2)     // Catch:{ Exception -> 0x00a8 }
        L_0x001c:
            android.graphics.Typeface r4 = r11.getTypeface()     // Catch:{ Exception -> 0x00a8 }
            r5 = 0
            if (r4 == 0) goto L_0x0029
            android.graphics.Typeface r4 = r11.getTypeface()     // Catch:{ Exception -> 0x00a8 }
            if (r4 == 0) goto L_0x002f
        L_0x0029:
            java.lang.String r1 = "sans-serif-light"
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r5)     // Catch:{ Exception -> 0x00a8 }
        L_0x002f:
            java.lang.String r4 = ": "
            int r4 = r10.indexOf(r4)     // Catch:{ Exception -> 0x00a8 }
            int r4 = r4 + 10
            int r6 = r10.length()     // Catch:{ Exception -> 0x00a8 }
            if (r4 < r6) goto L_0x0040
            r11.setText(r10)     // Catch:{ Exception -> 0x00a8 }
        L_0x0040:
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x00a8 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a8 }
            r7.<init>()     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r8 = r10.substring(r5, r4)     // Catch:{ Exception -> 0x00a8 }
            r7.append(r8)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r8 = "  "
            r7.append(r8)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00a8 }
            r6[r5] = r7     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r4 = r10.substring(r4)     // Catch:{ Exception -> 0x00a8 }
            r6[r2] = r4     // Catch:{ Exception -> 0x00a8 }
            r4 = r6[r5]     // Catch:{ Exception -> 0x00a8 }
            int r4 = r4.length()     // Catch:{ Exception -> 0x00a8 }
            android.text.SpannableStringBuilder r7 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x00a8 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a8 }
            r8.<init>()     // Catch:{ Exception -> 0x00a8 }
            r9 = r6[r5]     // Catch:{ Exception -> 0x00a8 }
            r8.append(r9)     // Catch:{ Exception -> 0x00a8 }
            r9 = r6[r2]     // Catch:{ Exception -> 0x00a8 }
            r8.append(r9)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00a8 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00a8 }
            com.paytm.utility.CustomTypefaceSpan r8 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x00a8 }
            r8.<init>(r0, r1)     // Catch:{ Exception -> 0x00a8 }
            r1 = 34
            r7.setSpan(r8, r5, r4, r1)     // Catch:{ Exception -> 0x00a8 }
            java.lang.String r8 = "."
            boolean r10 = r10.contains(r8)     // Catch:{ Exception -> 0x00a8 }
            if (r10 == 0) goto L_0x00a5
            com.paytm.utility.CustomTypefaceSpan r10 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x00a8 }
            r10.<init>(r0, r3)     // Catch:{ Exception -> 0x00a8 }
            r0 = r6[r5]     // Catch:{ Exception -> 0x00a8 }
            int r0 = r0.length()     // Catch:{ Exception -> 0x00a8 }
            r2 = r6[r2]     // Catch:{ Exception -> 0x00a8 }
            int r2 = r2.length()     // Catch:{ Exception -> 0x00a8 }
            int r0 = r0 + r2
            r7.setSpan(r10, r4, r0, r1)     // Catch:{ Exception -> 0x00a8 }
        L_0x00a5:
            r11.setText(r7)     // Catch:{ Exception -> 0x00a8 }
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.d.a(java.lang.String, android.widget.TextView):void");
    }

    public static Fragment a(boolean z2, String str, String str2, String str3, String str4, String str5, String str6, boolean z3, double d2, boolean z4, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i2) {
        Bundle bundle = new Bundle();
        d dVar = new d();
        boolean z5 = z2;
        bundle.putBoolean("isMLVEnabledPayment", z2);
        String str14 = str;
        bundle.putString("mlvOrderId", str);
        String str15 = str2;
        bundle.putString("mlvMyOrdersAPIUrl", str2);
        String str16 = str3;
        bundle.putString("mlvMerchantName", str3);
        String str17 = str4;
        bundle.putString("provider", str4);
        bundle.putString("mlvAmount", str11);
        String str18 = str5;
        bundle.putString("phone_no", str5);
        String str19 = str6;
        bundle.putString("name", str6);
        boolean z6 = z3;
        bundle.putBoolean("is_pcf", z3);
        double d3 = d2;
        bundle.putDouble("pcf_amount", d2);
        boolean z7 = z4;
        bundle.putBoolean("is_emi", z4);
        bundle.putString("emi_message", str7);
        bundle.putString(CJRQRScanResultModel.KEY_COMMENT_SMALL, str8);
        bundle.putString("pay_mode", str9);
        bundle.putString("unique_identifier", str10);
        bundle.putString("payee_vpa", str13);
        bundle.putString(UpiConstants.EXTRA_PAYER_VPA, str12);
        bundle.putInt("launchFrom", i2);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.k = (IJRDataModel) arguments.getSerializable("data");
            Activity activity = this.at;
            this.o = arguments.getString("name", activity == null ? "Receiver" : activity.getString(R.string.receiver_name));
            this.q = arguments.getString("amount");
            this.p = arguments.getString(CJRQRScanResultModel.KEY_COMMENT_SMALL);
            this.t = arguments.getBoolean("isP2B");
            this.y = arguments.getString("phone_no");
            this.u = arguments.getString("paymentMode");
            this.f51074a = arguments.getDouble("txn_fee", 0.0d);
            this.D = arguments.getString("key_via");
            this.al = arguments.getBoolean("is_upi");
            this.am = arguments.getBoolean("isFromPassbook");
            this.ao = arguments.getBoolean("is_from_deeplink");
            this.ap = arguments.getString("ref_id");
            this.l = arguments.getString("pay_response");
            this.m = arguments.getBoolean("is_from_mobile_number");
            this.n = arguments.getBundle("sbBundle");
            this.bx = arguments.getString("payee_vpa", (String) null);
            this.bx = arguments.getString(UpiConstants.EXTRA_PAYER_VPA, (String) null);
            this.aN = arguments.getBoolean("is_static_qr_code");
            this.aP = arguments.getString("pay_mode", (String) null);
            this.aQ = arguments.getString("unique_identifier", "");
            this.aR = getArguments().getString("mid");
            this.aS = getArguments().getString("scan_result");
            this.aO = getArguments().getBoolean("is_link_based_payment");
            this.au = arguments.getBoolean("is_postpaid");
            this.ai = arguments.getBoolean("is_ppb_transaction", false);
            this.an = arguments.getBoolean("is_card_transaction", false);
            this.ay = arguments.getBoolean("is_net_banking_transaction", false);
            this.aA = arguments.getString("merchant_logo");
            this.aC = arguments.getString("tran_time");
            this.aV = arguments.getBoolean("is_from_recent", false);
            this.aW = arguments.getBoolean("isAutoFlashTxn", false);
            this.aU = arguments.getString("qrScanTime", "");
            this.aX = arguments.getString("suggestedInstrument", "");
            this.aY = arguments.getBoolean("isSingleAPI", false);
            this.ba = arguments.getString("page_load_time", "");
            this.aZ = arguments.getString("page_load_type", "");
            this.bb = arguments.getBoolean("is_amt_already_present", false);
            this.aI = arguments.getBoolean("is_pcf", false);
            this.aK = Double.valueOf(arguments.getDouble("pcf_amount", 0.0d));
            this.aH = arguments.getBoolean("is_emi", false);
            this.aJ = arguments.getString("emi_message");
            this.bk = arguments.getBoolean("isMLVEnabledPayment", false);
            this.bm = arguments.getString("mlvOrderId");
            this.bo = arguments.getString("mlvAmount");
            this.bp = arguments.getString("provider");
            this.bl = arguments.getString("mlvMyOrdersAPIUrl");
            this.bn = arguments.getString("mlvMerchantName");
            this.bv = arguments.getBoolean("isFromAppEvoke", false);
            this.bB = arguments.getInt("launchFrom", this.bB);
        }
        Application application = this.at.getApplication();
        this.aM = (net.one97.paytm.wallet.j.a) am.a((FragmentActivity) this.at, (al.b) new net.one97.paytm.wallet.j.b(PaymentInstrumentDatabase.f51202a.a(application), application)).a(net.one97.paytm.wallet.j.a.class);
    }

    public void onAttach(Context context) {
        this.at = (Activity) context;
        this.aL = (k) context;
        if (this.f51075b == null) {
            this.f51075b = new net.one97.paytm.wallet.d.h();
        }
        this.f51075b.a(this.at, (i) new i() {
            public final void a() {
            }

            public final void a(String str) {
            }

            public final void b() {
            }

            public final void a(IJRDataModel iJRDataModel) {
                d.this.k();
            }
        });
        super.onAttach(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:133|134) */
    /* JADX WARNING: Can't wrap try/catch for region: R(41:102|103|104|(1:106)(1:107)|108|(2:110|(1:112))|113|(2:117|(1:119)(1:120))|121|(1:123)(2:124|(1:126))|127|128|129|(3:131|132|135)(1:136)|137|138|139|140|141|142|(14:143|144|145|146|147|148|149|150|(2:152|(1:154)(24:155|(6:157|(1:161)|162|(1:164)(1:165)|166|(2:170|(1:174)))(2:175|(20:177|(1:179)|180|186|187|197|(1:199)(1:200)|201|(1:205)|206|(1:208)|209|(3:213|(10:215|(1:217)(1:218)|219|(1:221)|222|(1:224)|225|(1:227)|228|(1:230))|231)|232|(1:236)|237|(3:239|(1:241)(1:242)|243)|244|(1:246)|247))|181|187|197|(0)(0)|201|203|205|206|(0)|209|211|213|(0)|231|232|234|236|237|(0)|244|(0)|247))|182|(1:184)|185|186|187)|197|(0)(0)|201|203|205|206|(0)|209|211|213|(0)|231|232|234|236|237|(0)|244|(0)|247) */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        r9 = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:133:0x07c7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:137:0x07f0 */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0843 A[Catch:{ JSONException -> 0x0a84 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0a06 A[Catch:{ JSONException -> 0x0a84 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0aa8  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0b51  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0b74  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0ba8  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0c9d  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0d2d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r48, android.view.ViewGroup r49, android.os.Bundle r50) {
        /*
            r47 = this;
            r0 = r47
            r1 = r50
            java.lang.String r2 = "TXNDATE"
            java.lang.String r3 = "ORDERID"
            int r4 = net.one97.paytm.wallet.R.layout.p2m_post_payment_fragment
            r5 = 0
            r6 = r48
            r7 = r49
            android.view.View r4 = r6.inflate(r4, r7, r5)
            if (r1 == 0) goto L_0x0021
            android.os.Bundle r6 = r0.ag
            if (r6 != 0) goto L_0x0021
            java.lang.String r6 = "saved_state"
            android.os.Bundle r1 = r1.getBundle(r6)
            r0.ag = r1
        L_0x0021:
            android.os.Bundle r1 = r0.ag
            if (r1 == 0) goto L_0x002d
            java.lang.String r6 = "is_back_shown"
            boolean r1 = r1.getBoolean(r6)
            r0.af = r1
        L_0x002d:
            r1 = 0
            r0.ag = r1
            r0.z = r4
            int r6 = net.one97.paytm.wallet.R.id.tv_prn_label
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.f51076c = r6
            int r6 = net.one97.paytm.wallet.R.id.tv_prn_message
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.f51077d = r6
            int r6 = net.one97.paytm.wallet.R.id.success_animation
            android.view.View r6 = r4.findViewById(r6)
            com.airbnb.lottie.LottieAnimationView r6 = (com.airbnb.lottie.LottieAnimationView) r6
            r0.as = r6
            com.airbnb.lottie.LottieAnimationView r6 = r0.as
            java.lang.String r7 = "payment-success.json"
            r6.setAnimation((java.lang.String) r7)
            com.airbnb.lottie.LottieAnimationView r6 = r0.as
            r8 = -1
            r6.setRepeatCount(r8)
            int r6 = net.one97.paytm.wallet.R.id.ic_payment_status
            android.view.View r6 = r4.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r0.A = r6
            int r6 = net.one97.paytm.wallet.R.id.pb_pending
            android.view.View r6 = r4.findViewById(r6)
            net.one97.paytm.postpayment.utils.WalletCircularProgressBar r6 = (net.one97.paytm.postpayment.utils.WalletCircularProgressBar) r6
            r0.aF = r6
            int r6 = net.one97.paytm.wallet.R.id.logout
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.C = r6
            int r6 = net.one97.paytm.wallet.R.id.split_bill_view
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.F = r6
            int r6 = net.one97.paytm.wallet.R.id.linear_layout_balance
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.B = r6
            int r6 = net.one97.paytm.wallet.R.id.tv_comment
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.ah = r6
            int r6 = net.one97.paytm.wallet.R.id.text_otp
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.E = r6
            int r6 = net.one97.paytm.wallet.R.id.passbook_view
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.G = r6
            int r6 = net.one97.paytm.wallet.R.id.contact_us_view
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.H = r6
            int r6 = net.one97.paytm.wallet.R.id.av_balance_label
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.J = r6
            int r6 = net.one97.paytm.wallet.R.id.updated_balance_value
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.r = r6
            android.widget.TextView r6 = r0.J
            r8 = 4
            r6.setVisibility(r8)
            android.widget.TextView r6 = r0.r
            r6.setVisibility(r8)
            int r6 = net.one97.paytm.wallet.R.id.main_summary_rl
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.az = r6
            int r6 = net.one97.paytm.wallet.R.id.cashback_offers_view
            android.view.View r6 = r4.findViewById(r6)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.bc = r6
            int r6 = net.one97.paytm.wallet.R.id.parent_layout
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.aw = r6
            int r6 = net.one97.paytm.wallet.R.id.repeat_payment_view
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.aD = r6
            android.widget.RelativeLayout r6 = r0.aD
            r8 = 8
            r6.setVisibility(r8)
            int r6 = net.one97.paytm.wallet.R.id.repeat_payment_tv
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.aT = r6
            java.lang.String r6 = r0.o
            r9 = 1
            if (r6 == 0) goto L_0x012b
            android.widget.TextView r6 = r0.aT
            android.app.Activity r10 = r0.at
            int r11 = net.one97.paytm.wallet.R.string.pay_again_merchant
            java.lang.String r10 = r10.getString(r11)
            java.lang.Object[] r11 = new java.lang.Object[r9]
            java.lang.String r12 = r0.o
            r11[r5] = r12
            java.lang.String r10 = java.lang.String.format(r10, r11)
            r6.setText(r10)
        L_0x012b:
            int r6 = net.one97.paytm.wallet.R.id.resend_confirmation_payment
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.aE = r6
            android.widget.RelativeLayout r6 = r0.aE
            r6.setVisibility(r8)
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.tv_status_msg
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.O = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.tv_status_desc
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.U = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.tv_merchant_name
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.T = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.tv_date
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.R = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.tv_amount
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.P = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.tv_amount_fractional
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.Q = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.tv_order_id
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.S = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.tv_pay_mode
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.W = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.rl_merchant_logo
            android.view.View r6 = r6.findViewById(r10)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.L = r6
            android.widget.RelativeLayout r6 = r0.L
            r6.bringToFront()
            android.widget.RelativeLayout r6 = r0.L
            int r10 = net.one97.paytm.wallet.R.id.iv_merchant_logo
            android.view.View r6 = r6.findViewById(r10)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r0.M = r6
            android.view.View r6 = r0.z
            int r10 = net.one97.paytm.wallet.R.id.tv_share
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.N = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.tv_comment
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.V = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.rl_txn_count
            android.view.View r6 = r6.findViewById(r10)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.ab = r6
            android.widget.RelativeLayout r6 = r0.az
            int r10 = net.one97.paytm.wallet.R.id.tv_txn_count
            android.view.View r6 = r6.findViewById(r10)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0.ac = r6
            int r6 = net.one97.paytm.wallet.R.id.main_layout
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.bq = r6
            int r6 = net.one97.paytm.wallet.R.id.mlv_post_payment_shimmer
            android.view.View r6 = r4.findViewById(r6)
            net.one97.paytm.utils.ShimmerFrameLayout r6 = (net.one97.paytm.utils.ShimmerFrameLayout) r6
            r0.br = r6
            int r6 = net.one97.paytm.wallet.R.id.iv_cross
            android.view.View r6 = r4.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r0.bh = r6
            int r6 = net.one97.paytm.wallet.R.id.tv_rupee
            android.view.View r6 = r4.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.String r10 = "₹"
            r6.setText(r10)
            android.widget.ImageView r6 = r0.bh
            r6.setOnClickListener(r0)
            int r6 = net.one97.paytm.wallet.R.id.dynamic_views
            android.view.View r6 = r4.findViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r0.bd = r6
            int r6 = net.one97.paytm.wallet.R.id.wallet_post_txn_cta
            android.view.View r6 = r4.findViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r0.be = r6
            int r6 = net.one97.paytm.wallet.R.id.mlv_layout
            android.view.View r6 = r4.findViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r0.bf = r6
            int r6 = net.one97.paytm.wallet.R.id.ad_fragment_container
            android.view.View r6 = r4.findViewById(r6)
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            r0.bg = r6
            int r6 = net.one97.paytm.wallet.R.id.floating_nav
            android.view.View r6 = r4.findViewById(r6)
            r6.setOnClickListener(r1)
            android.os.Bundle r6 = r47.getArguments()
            r10 = 0
            java.lang.String r11 = "is_offline_pg"
            if (r6 == 0) goto L_0x025b
            android.os.Bundle r6 = r47.getArguments()
            boolean r6 = r6.getBoolean(r11, r5)
            if (r6 != 0) goto L_0x0261
        L_0x025b:
            net.one97.paytm.common.entity.IJRDataModel r6 = r0.k
            boolean r6 = r6 instanceof net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel
            if (r6 == 0) goto L_0x02c3
        L_0x0261:
            android.widget.RelativeLayout r6 = r0.az
            int r12 = net.one97.paytm.wallet.R.id.ic_payment_status
            android.view.View r6 = r6.findViewById(r12)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r0.A = r6
            android.widget.RelativeLayout r6 = r0.az
            int r12 = net.one97.paytm.wallet.R.id.success_animation
            android.view.View r6 = r6.findViewById(r12)
            com.airbnb.lottie.LottieAnimationView r6 = (com.airbnb.lottie.LottieAnimationView) r6
            r0.as = r6
            com.airbnb.lottie.LottieAnimationView r6 = r0.as
            r6.setAnimation((java.lang.String) r7)
            com.airbnb.lottie.LottieAnimationView r6 = r0.as
            r6.loop(r9)
            java.lang.String r6 = r0.p
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x02aa
            android.widget.TextView r6 = r0.V
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r12 = "\" "
            r7.<init>(r12)
            java.lang.String r12 = r0.p
            r7.append(r12)
            java.lang.String r12 = " \""
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            r6.setText(r7)
            android.widget.TextView r6 = r0.V
            r6.setVisibility(r5)
        L_0x02aa:
            android.widget.TextView r6 = r0.N
            r6.setVisibility(r5)
            android.widget.TextView r6 = r0.N
            r6.setOnClickListener(r0)
            android.widget.RelativeLayout r6 = r0.az
            r6.setVisibility(r5)
            int r6 = net.one97.paytm.wallet.R.id.toolbar
            android.view.View r6 = r4.findViewById(r6)
            androidx.core.h.u.g((android.view.View) r6, (float) r10)
            goto L_0x02f8
        L_0x02c3:
            boolean r6 = r0.bk
            if (r6 == 0) goto L_0x02e0
            android.widget.TextView r6 = r0.N
            r6.setVisibility(r5)
            android.widget.TextView r6 = r0.N
            r6.setOnClickListener(r0)
            android.widget.RelativeLayout r6 = r0.az
            r6.setVisibility(r8)
            int r6 = net.one97.paytm.wallet.R.id.toolbar
            android.view.View r6 = r4.findViewById(r6)
            androidx.core.h.u.g((android.view.View) r6, (float) r10)
            goto L_0x02f8
        L_0x02e0:
            android.widget.TextView r6 = r0.N
            r6.setVisibility(r8)
            android.widget.RelativeLayout r6 = r0.az
            r6.setVisibility(r8)
            int r6 = net.one97.paytm.wallet.R.id.toolbar
            android.view.View r6 = r4.findViewById(r6)
            int r7 = com.paytm.utility.b.c((int) r9)
            float r7 = (float) r7
            androidx.core.h.u.g((android.view.View) r6, (float) r7)
        L_0x02f8:
            int r6 = net.one97.paytm.wallet.R.id.add_money_view
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.av = r6
            int r6 = net.one97.paytm.wallet.R.id.wallet_balance_rl
            android.view.View r6 = r4.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r0.ax = r6
            int r6 = net.one97.paytm.wallet.R.id.contact_trust_layout
            android.view.View r6 = r4.findViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r0.K = r6
            android.os.Bundle r6 = r47.getArguments()
            boolean r6 = r6.getBoolean(r11, r5)
            if (r6 == 0) goto L_0x032b
            android.widget.ImageView r6 = r0.A
            r6.setVisibility(r8)
            com.airbnb.lottie.LottieAnimationView r6 = r0.as
            r6.setVisibility(r8)
            goto L_0x033d
        L_0x032b:
            boolean r6 = r0.bk
            if (r6 == 0) goto L_0x033a
            android.widget.ImageView r6 = r0.A
            r6.setVisibility(r8)
            com.airbnb.lottie.LottieAnimationView r6 = r0.as
            r6.setVisibility(r8)
            goto L_0x033d
        L_0x033a:
            r47.g()
        L_0x033d:
            android.widget.TextView r6 = r0.C
            r6.setOnClickListener(r0)
            android.widget.RelativeLayout r6 = r0.G
            r6.setOnClickListener(r0)
            android.widget.RelativeLayout r6 = r0.H
            r6.setOnClickListener(r0)
            android.widget.LinearLayout r6 = r0.K
            r6.setOnClickListener(r0)
            android.widget.RelativeLayout r6 = r0.F
            r6.setOnClickListener(r0)
            android.widget.RelativeLayout r6 = r0.aD
            r6.setOnClickListener(r0)
            android.widget.RelativeLayout r6 = r0.aE
            r6.setOnClickListener(r0)
            android.os.Handler r6 = new android.os.Handler
            r6.<init>()
            r0.ae = r6
            android.os.Handler r6 = r0.ae
            java.lang.Runnable r7 = r0.bi
            r12 = 180000(0x2bf20, double:8.8932E-319)
            r6.postDelayed(r7, r12)
            net.one97.paytm.wallet.communicator.c r6 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r7 = r0.at
            java.lang.String r10 = "p2mNavbarSFUrl"
            java.lang.String r6 = r6.getStringFromGTM(r7, r10)
            android.app.Activity r7 = r0.at
            java.lang.String r6 = com.paytm.utility.b.e((android.content.Context) r7, (java.lang.String) r6)
            net.one97.paytm.widget.g r7 = net.one97.paytm.widget.g.f72427a
            androidx.fragment.app.FragmentActivity r7 = r47.getActivity()
            net.one97.paytm.p2mNewDesign.d.-$$Lambda$d$iDbIrPtf1cSttl6hF0O1yz6ROsQ r10 = new net.one97.paytm.p2mNewDesign.d.-$$Lambda$d$iDbIrPtf1cSttl6hF0O1yz6ROsQ
            r10.<init>()
            net.one97.paytm.widget.g.a((java.lang.String) r6, (androidx.fragment.app.FragmentActivity) r7, (net.one97.paytm.widget.b) r10)
            net.one97.paytm.common.entity.IJRDataModel r6 = r0.k
            boolean r7 = r6 instanceof net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel
            java.lang.String r10 = " "
            java.lang.String r12 = "merchant"
            r13 = 3
            java.lang.String r14 = "hh:mm a, dd MMM yyyy"
            java.lang.String r15 = ""
            if (r7 == 0) goto L_0x03ac
            r0.s = r13
            r0.a((net.one97.paytm.common.entity.IJRDataModel) r6)
            java.lang.String r6 = r0.q
            r0.c(r12, r6)
            goto L_0x066d
        L_0x03ac:
            boolean r7 = r6 instanceof net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse
            if (r7 == 0) goto L_0x03bc
            r0.s = r13
            r0.a((net.one97.paytm.common.entity.IJRDataModel) r6)
            java.lang.String r6 = r0.q
            r0.c(r12, r6)
            goto L_0x066d
        L_0x03bc:
            boolean r7 = r6 instanceof net.one97.paytm.p2mNewDesign.entity.ShowCodePushModel
            if (r7 == 0) goto L_0x065e
            net.one97.paytm.p2mNewDesign.entity.ShowCodePushModel r6 = (net.one97.paytm.p2mNewDesign.entity.ShowCodePushModel) r6
            java.lang.String r7 = r6.getOrderId()
            r0.aq = r7
            java.lang.String r7 = r0.aq
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0407
            java.lang.String r7 = r6.getTxnId()
            r0.f51079i = r7
            java.lang.String r7 = r6.getStatus()
            r0.j = r7
            android.widget.TextView r7 = r0.S
            r7.setVisibility(r5)
            android.widget.TextView r7 = r0.S
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            android.app.Activity r13 = r0.at
            android.content.res.Resources r13 = r13.getResources()
            int r1 = net.one97.paytm.wallet.R.string.order_txn_id
            java.lang.String r1 = r13.getString(r1)
            r12.append(r1)
            r12.append(r10)
            java.lang.String r1 = r0.aq
            r12.append(r1)
            java.lang.String r1 = r12.toString()
            r7.setText(r1)
            goto L_0x040c
        L_0x0407:
            android.widget.TextView r1 = r0.S
            r1.setVisibility(r8)
        L_0x040c:
            java.lang.String r1 = r6.getPaymentMode()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x04da
            java.lang.String r1 = r6.getPaymentMode()
            java.lang.String r7 = "BALANCE"
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0430
            android.app.Activity r1 = r0.at
            android.content.res.Resources r1 = r1.getResources()
            int r7 = net.one97.paytm.wallet.R.string.paytm_wallet
            java.lang.String r1 = r1.getString(r7)
            goto L_0x04af
        L_0x0430:
            java.lang.String r7 = "PAYTM_DIGITAL_CREDIT"
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0445
            android.app.Activity r1 = r0.at
            android.content.res.Resources r1 = r1.getResources()
            int r7 = net.one97.paytm.wallet.R.string.paytm_postpaid
            java.lang.String r1 = r1.getString(r7)
            goto L_0x04af
        L_0x0445:
            java.lang.String r7 = "PPBL"
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x045a
            android.app.Activity r1 = r0.at
            android.content.res.Resources r1 = r1.getResources()
            int r7 = net.one97.paytm.wallet.R.string.paytm_payment_bank
            java.lang.String r1 = r1.getString(r7)
            goto L_0x04af
        L_0x045a:
            java.lang.String r7 = "CREDIT_CARD"
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x046f
            android.app.Activity r1 = r0.at
            android.content.res.Resources r1 = r1.getResources()
            int r7 = net.one97.paytm.wallet.R.string.credit_card
            java.lang.String r1 = r1.getString(r7)
            goto L_0x04af
        L_0x046f:
            java.lang.String r7 = "DEBIT_CARD"
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0484
            android.app.Activity r1 = r0.at
            android.content.res.Resources r1 = r1.getResources()
            int r7 = net.one97.paytm.wallet.R.string.debit_card
            java.lang.String r1 = r1.getString(r7)
            goto L_0x04af
        L_0x0484:
            java.lang.String r7 = "UPI"
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0499
            android.app.Activity r1 = r0.at
            android.content.res.Resources r1 = r1.getResources()
            int r7 = net.one97.paytm.wallet.R.string.upi
            java.lang.String r1 = r1.getString(r7)
            goto L_0x04af
        L_0x0499:
            java.lang.String r7 = "NET_BANKING"
            boolean r1 = r1.equalsIgnoreCase(r7)
            if (r1 == 0) goto L_0x04ae
            android.app.Activity r1 = r0.at
            android.content.res.Resources r1 = r1.getResources()
            int r7 = net.one97.paytm.wallet.R.string.net_banking
            java.lang.String r1 = r1.getString(r7)
            goto L_0x04af
        L_0x04ae:
            r1 = r15
        L_0x04af:
            boolean r7 = android.text.TextUtils.isEmpty(r1)
            if (r7 != 0) goto L_0x04d4
            android.widget.TextView r7 = r0.W
            r7.setVisibility(r5)
            android.widget.TextView r7 = r0.W
            android.app.Activity r12 = r0.at
            android.content.res.Resources r12 = r12.getResources()
            int r13 = net.one97.paytm.wallet.R.string.silent_push_message
            java.lang.String r12 = r12.getString(r13)
            java.lang.Object[] r13 = new java.lang.Object[r9]
            r13[r5] = r1
            java.lang.String r1 = java.lang.String.format(r12, r13)
            r7.setText(r1)
            goto L_0x04df
        L_0x04d4:
            android.widget.TextView r1 = r0.W
            r1.setVisibility(r8)
            goto L_0x04df
        L_0x04da:
            android.widget.TextView r1 = r0.W
            r1.setVisibility(r8)
        L_0x04df:
            java.lang.String r1 = r6.getMerchantLogoUrl()
            r0.aA = r1
            java.lang.String r1 = r0.aA
            r0.b((java.lang.String) r1)
            android.widget.TextView r1 = r0.R
            r1.setVisibility(r5)
            java.lang.String r1 = r6.getTimeStamp()     // Catch:{ NumberFormatException -> 0x0521 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ NumberFormatException -> 0x0521 }
            if (r1 != 0) goto L_0x050f
            java.lang.String r1 = r6.getTimeStamp()     // Catch:{ NumberFormatException -> 0x0521 }
            android.widget.TextView r7 = r0.R     // Catch:{ NumberFormatException -> 0x0521 }
            long r12 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x0521 }
            java.lang.Long r1 = java.lang.Long.valueOf(r12)     // Catch:{ NumberFormatException -> 0x0521 }
            java.lang.String r1 = com.paytm.utility.b.a((java.lang.Long) r1, (java.lang.String) r14)     // Catch:{ NumberFormatException -> 0x0521 }
            r7.setText(r1)     // Catch:{ NumberFormatException -> 0x0521 }
            goto L_0x0522
        L_0x050f:
            android.widget.TextView r1 = r0.R     // Catch:{ NumberFormatException -> 0x0521 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ NumberFormatException -> 0x0521 }
            java.lang.Long r7 = java.lang.Long.valueOf(r12)     // Catch:{ NumberFormatException -> 0x0521 }
            java.lang.String r7 = com.paytm.utility.b.a((java.lang.Long) r7, (java.lang.String) r14)     // Catch:{ NumberFormatException -> 0x0521 }
            r1.setText(r7)     // Catch:{ NumberFormatException -> 0x0521 }
            goto L_0x0522
        L_0x0521:
        L_0x0522:
            java.lang.String r1 = r6.getAmount()
            r0.a((java.lang.String) r1)
            android.widget.TextView r1 = r0.T
            java.lang.String r7 = r6.getMerchantName()
            r1.setText(r7)
            java.lang.String r1 = r6.getStatus()
            java.lang.String r7 = "PENDING"
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x059a
            r0.X = r9
            android.widget.TextView r1 = r0.O
            android.app.Activity r6 = r0.at
            android.content.res.Resources r6 = r6.getResources()
            int r7 = net.one97.paytm.wallet.R.string.payment_pending
            java.lang.String r6 = r6.getString(r7)
            r1.setText(r6)
            android.widget.TextView r1 = r0.O
            android.app.Activity r6 = r0.at
            int r7 = net.one97.paytm.wallet.R.color.color_ffa400
            int r6 = androidx.core.content.b.c(r6, r7)
            r1.setTextColor(r6)
            android.widget.TextView r1 = r0.U
            android.app.Activity r6 = r0.at
            android.content.res.Resources r6 = r6.getResources()
            int r7 = net.one97.paytm.wallet.R.string.payment_pending_desc_msg
            java.lang.String r6 = r6.getString(r7)
            r1.setText(r6)
            android.widget.TextView r1 = r0.U
            android.app.Activity r6 = r0.at
            int r7 = net.one97.paytm.wallet.R.color.color_fdfbd3
            int r6 = androidx.core.content.b.c(r6, r7)
            r1.setBackgroundColor(r6)
            android.widget.TextView r1 = r0.U
            r1.setVisibility(r5)
            android.widget.ImageView r1 = r0.A
            r1.setVisibility(r5)
            com.airbnb.lottie.LottieAnimationView r1 = r0.as
            r1.setVisibility(r8)
            android.widget.ImageView r1 = r0.A
            android.app.Activity r6 = r0.at
            int r7 = net.one97.paytm.wallet.R.drawable.ic_pending_copy
            android.graphics.drawable.Drawable r6 = androidx.core.content.b.a((android.content.Context) r6, (int) r7)
            r1.setBackground(r6)
            goto L_0x066d
        L_0x059a:
            java.lang.String r1 = r6.getStatus()
            java.lang.String r7 = "SUCCESS"
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x060e
            r0.Z = r9
            r0.X = r5
            r0.Y = r5
            java.lang.String r1 = "Payment_success"
            r0.a((java.lang.String) r1, (java.lang.String) r15, (java.lang.String) r15)
            android.widget.TextView r1 = r0.O
            android.app.Activity r7 = r0.at
            android.content.res.Resources r7 = r7.getResources()
            int r12 = net.one97.paytm.wallet.R.string.paid_successfully_to
            java.lang.String r7 = r7.getString(r12)
            r1.setText(r7)
            android.widget.TextView r1 = r0.O
            android.app.Activity r7 = r0.at
            int r12 = net.one97.paytm.wallet.R.color.black
            int r7 = androidx.core.content.b.c(r7, r12)
            r1.setTextColor(r7)
            android.widget.ImageView r1 = r0.A
            r1.setVisibility(r5)
            com.airbnb.lottie.LottieAnimationView r1 = r0.as
            r1.setVisibility(r8)
            net.one97.paytm.p2mNewDesign.f.k r1 = r0.aL
            r1.c()
            android.widget.ImageView r1 = r0.A
            android.app.Activity r7 = r0.at
            int r12 = net.one97.paytm.wallet.R.drawable.payment_done_00048
            android.graphics.drawable.Drawable r7 = androidx.core.content.b.a((android.content.Context) r7, (int) r12)
            r1.setBackground(r7)
            r47.g()
            android.widget.TextView r1 = r0.U
            r1.setVisibility(r8)
            if (r6 == 0) goto L_0x0607
            java.lang.String r1 = r6.getTxnId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0607
            java.lang.String r1 = r6.getTxnId()
            r6 = 0
            r0.b(r1, r6)
        L_0x0607:
            r47.x()
            r47.y()
            goto L_0x066d
        L_0x060e:
            java.lang.String r1 = r6.getStatus()
            java.lang.String r6 = "FAILURE"
            boolean r1 = r1.equalsIgnoreCase(r6)
            if (r1 == 0) goto L_0x066d
            r0.Y = r9
            r0.X = r5
            java.lang.String r1 = "Payment_failed"
            r0.a((java.lang.String) r1, (java.lang.String) r15, (java.lang.String) r15)
            android.widget.ImageView r1 = r0.A
            android.app.Activity r6 = r0.at
            int r7 = net.one97.paytm.wallet.R.drawable.ic_failed_copy
            android.graphics.drawable.Drawable r6 = androidx.core.content.b.a((android.content.Context) r6, (int) r7)
            r1.setBackground(r6)
            android.widget.ImageView r1 = r0.A
            r1.setVisibility(r5)
            com.airbnb.lottie.LottieAnimationView r1 = r0.as
            r1.setVisibility(r8)
            android.widget.TextView r1 = r0.O
            android.app.Activity r6 = r0.at
            android.content.res.Resources r6 = r6.getResources()
            int r7 = net.one97.paytm.wallet.R.string.payment_failed_wallet
            java.lang.String r6 = r6.getString(r7)
            r1.setText(r6)
            android.widget.TextView r1 = r0.O
            android.app.Activity r6 = r0.at
            int r7 = net.one97.paytm.wallet.R.color.color_fd5c5c
            int r6 = androidx.core.content.b.c(r6, r7)
            r1.setTextColor(r6)
            android.widget.TextView r1 = r0.U
            r1.setVisibility(r8)
            goto L_0x066d
        L_0x065e:
            boolean r1 = r6 instanceof net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse
            if (r1 == 0) goto L_0x066d
            r1 = 3
            r0.s = r1
            r0.a((net.one97.paytm.common.entity.IJRDataModel) r6)
            java.lang.String r1 = r0.q
            r0.c(r12, r1)
        L_0x066d:
            java.lang.String r1 = r0.p
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0694
            android.widget.TextView r1 = r0.ah
            r1.setVisibility(r5)
            android.widget.TextView r1 = r0.ah
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "\" "
            r6.<init>(r7)
            java.lang.String r7 = r0.p
            r6.append(r7)
            java.lang.String r7 = " \""
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r1.setText(r6)
        L_0x0694:
            java.lang.String r1 = r0.l
            if (r1 == 0) goto L_0x0a90
            r6 = 3
            r0.s = r6
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0a90 }
            r6.<init>(r1)     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r1 = "RESPMSG"
            java.lang.String r1 = r6.optString(r1)     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r7 = "RESPCODE"
            java.lang.String r7 = r6.optString(r7)     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r12 = r6.optString(r3)     // Catch:{ JSONException -> 0x0a90 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x0a90 }
            if (r12 != 0) goto L_0x06f3
            java.lang.String r12 = "TXNID"
            java.lang.String r12 = r6.optString(r12)     // Catch:{ JSONException -> 0x0a90 }
            r0.f51079i = r12     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r12 = "STATUS"
            java.lang.String r12 = r6.optString(r12)     // Catch:{ JSONException -> 0x0a90 }
            r0.j = r12     // Catch:{ JSONException -> 0x0a90 }
            android.widget.TextView r12 = r0.S     // Catch:{ JSONException -> 0x0a90 }
            r12.setVisibility(r5)     // Catch:{ JSONException -> 0x0a90 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0a90 }
            r12.<init>()     // Catch:{ JSONException -> 0x0a90 }
            android.app.Activity r13 = r0.at     // Catch:{ JSONException -> 0x0a90 }
            android.content.res.Resources r13 = r13.getResources()     // Catch:{ JSONException -> 0x0a90 }
            int r9 = net.one97.paytm.wallet.R.string.order_txn_id     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r9 = r13.getString(r9)     // Catch:{ JSONException -> 0x0a90 }
            r12.append(r9)     // Catch:{ JSONException -> 0x0a90 }
            r12.append(r10)     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r9 = r6.optString(r3)     // Catch:{ JSONException -> 0x0a90 }
            r12.append(r9)     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r9 = r12.toString()     // Catch:{ JSONException -> 0x0a90 }
            android.widget.TextView r12 = r0.S     // Catch:{ JSONException -> 0x0a90 }
            a((java.lang.String) r9, (android.widget.TextView) r12)     // Catch:{ JSONException -> 0x0a90 }
            goto L_0x06f8
        L_0x06f3:
            android.widget.TextView r9 = r0.S     // Catch:{ JSONException -> 0x0a90 }
            r9.setVisibility(r8)     // Catch:{ JSONException -> 0x0a90 }
        L_0x06f8:
            java.lang.String r9 = "MID"
            java.lang.String r9 = r6.optString(r9)     // Catch:{ JSONException -> 0x0a90 }
            r0.ar = r9     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r9 = r6.optString(r3)     // Catch:{ JSONException -> 0x0a90 }
            r0.aq = r9     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r9 = "PAYMENTMODE"
            java.lang.String r12 = "default"
            java.lang.String r17 = r6.optString(r9, r12)     // Catch:{ JSONException -> 0x0a90 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0a90 }
            java.lang.Long r9 = java.lang.Long.valueOf(r12)     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r12 = "PRN"
            java.lang.String r12 = r6.optString(r12)     // Catch:{ JSONException -> 0x0a90 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x0a90 }
            if (r12 != 0) goto L_0x0735
            java.lang.String r12 = "PRN"
            java.lang.String r12 = r6.optString(r12)     // Catch:{ JSONException -> 0x0a90 }
            r0.x = r12     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r12 = r0.x     // Catch:{ JSONException -> 0x0a90 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x0a90 }
            if (r12 != 0) goto L_0x0735
            r47.f()     // Catch:{ JSONException -> 0x0a90 }
        L_0x0735:
            boolean r12 = r0.aH     // Catch:{ JSONException -> 0x0a90 }
            if (r12 == 0) goto L_0x075b
            java.lang.String r12 = r0.aJ     // Catch:{ JSONException -> 0x0a90 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x0a90 }
            if (r12 != 0) goto L_0x075b
            java.lang.String r12 = r0.aJ     // Catch:{ JSONException -> 0x0a90 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x0a90 }
            if (r12 != 0) goto L_0x0756
            android.widget.TextView r12 = r0.W     // Catch:{ JSONException -> 0x0a90 }
            r12.setVisibility(r5)     // Catch:{ JSONException -> 0x0a90 }
            android.widget.TextView r12 = r0.W     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r13 = r0.aJ     // Catch:{ JSONException -> 0x0a90 }
            r12.setText(r13)     // Catch:{ JSONException -> 0x0a90 }
            goto L_0x075b
        L_0x0756:
            android.widget.TextView r12 = r0.W     // Catch:{ JSONException -> 0x0a90 }
            r12.setVisibility(r8)     // Catch:{ JSONException -> 0x0a90 }
        L_0x075b:
            java.lang.String r12 = r0.aA     // Catch:{ JSONException -> 0x0a90 }
            r0.b((java.lang.String) r12)     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r12 = "TXNAMOUNT"
            java.lang.String r12 = r6.optString(r12)     // Catch:{ JSONException -> 0x0a90 }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x0a90 }
            if (r13 != 0) goto L_0x077d
            java.math.BigDecimal r13 = new java.math.BigDecimal     // Catch:{ JSONException -> 0x0a90 }
            r13.<init>(r12)     // Catch:{ JSONException -> 0x0a90 }
            java.math.BigDecimal r12 = r13.stripTrailingZeros()     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r12 = r12.toPlainString()     // Catch:{ JSONException -> 0x0a90 }
            r0.a((java.lang.String) r12)     // Catch:{ JSONException -> 0x0a90 }
            goto L_0x0797
        L_0x077d:
            java.lang.String r13 = r0.q     // Catch:{ JSONException -> 0x0a90 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ JSONException -> 0x0a90 }
            if (r13 != 0) goto L_0x0797
            java.math.BigDecimal r12 = new java.math.BigDecimal     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r13 = r0.q     // Catch:{ JSONException -> 0x0a90 }
            r12.<init>(r13)     // Catch:{ JSONException -> 0x0a90 }
            java.math.BigDecimal r12 = r12.stripTrailingZeros()     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r12 = r12.toPlainString()     // Catch:{ JSONException -> 0x0a90 }
            r0.a((java.lang.String) r12)     // Catch:{ JSONException -> 0x0a90 }
        L_0x0797:
            r22 = r12
            android.widget.TextView r12 = r0.T     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r13 = r0.o     // Catch:{ JSONException -> 0x0a90 }
            r12.setText(r13)     // Catch:{ JSONException -> 0x0a90 }
            android.widget.TextView r12 = r0.R     // Catch:{ JSONException -> 0x0a90 }
            r12.setVisibility(r5)     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r12 = r6.optString(r2)     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            if (r12 != 0) goto L_0x07df
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x07c7 }
            java.lang.String r13 = "yyyy-MM-dd HH:mm:ss"
            r12.<init>(r13)     // Catch:{ Exception -> 0x07c7 }
            java.lang.String r13 = r6.optString(r2)     // Catch:{ Exception -> 0x07c7 }
            java.util.Date r12 = r12.parse(r13)     // Catch:{ Exception -> 0x07c7 }
            long r12 = r12.getTime()     // Catch:{ Exception -> 0x07c7 }
            java.lang.Long r9 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x07c7 }
            goto L_0x07cf
        L_0x07c7:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            java.lang.Long r9 = java.lang.Long.valueOf(r12)     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
        L_0x07cf:
            android.widget.TextView r12 = r0.R     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            java.lang.String r2 = r6.optString(r2)     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            java.lang.String r13 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r2 = com.paytm.utility.b.g(r2, r13, r14)     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            r12.setText(r2)     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            goto L_0x07f0
        L_0x07df:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            java.lang.Long r9 = java.lang.Long.valueOf(r12)     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            android.widget.TextView r2 = r0.R     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            java.lang.String r12 = com.paytm.utility.b.a((java.lang.Long) r9, (java.lang.String) r14)     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
            r2.setText(r12)     // Catch:{ Exception | NumberFormatException -> 0x07f0 }
        L_0x07f0:
            boolean r2 = r0.aY     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r12 = r0.aU     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r13 = r0.aX     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r8 = r0.aP     // Catch:{ JSONException -> 0x0a90 }
            java.lang.String r5 = r0.j     // Catch:{ JSONException -> 0x0a90 }
            r32 = r15
            boolean r15 = r0.aV     // Catch:{ JSONException -> 0x0a89 }
            r33 = r4
            java.lang.String r4 = r0.aZ     // Catch:{ JSONException -> 0x0a8b }
            r34 = r14
            java.lang.String r14 = r0.ba     // Catch:{ JSONException -> 0x0a86 }
            r35 = r10
            boolean r10 = r0.aW     // Catch:{ JSONException -> 0x0a84 }
            r23 = r2
            r24 = r12
            r25 = r13
            r26 = r8
            r27 = r5
            r28 = r15
            r29 = r4
            r30 = r14
            r31 = r10
            java.lang.String r41 = net.one97.paytm.wallet.utility.a.a(r23, r24, r25, r26, r27, r28, r29, r30, r31)     // Catch:{ JSONException -> 0x0a84 }
            net.one97.paytm.wallet.communicator.c r36 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r2 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            r38 = 200(0xc8, float:2.8E-43)
            java.lang.String r39 = ""
            java.lang.String r40 = "NA"
            r42 = 0
            com.paytm.network.a$b r44 = com.paytm.network.a.b.USER_FACING     // Catch:{ JSONException -> 0x0a84 }
            r45 = 0
            com.paytm.network.a$c r46 = com.paytm.network.a.c.PAYMENTS     // Catch:{ JSONException -> 0x0a84 }
            r37 = r2
            r36.pushHawkeyeEvent(r37, r38, r39, r40, r41, r42, r44, r45, r46)     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = r0.j     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r4 = "PENDING"
            boolean r2 = r2.equals(r4)     // Catch:{ JSONException -> 0x0a84 }
            if (r2 != 0) goto L_0x09fd
            java.lang.String r2 = r0.j     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r4 = "TXN_PENDING"
            boolean r2 = r2.equals(r4)     // Catch:{ JSONException -> 0x0a84 }
            if (r2 == 0) goto L_0x084f
            goto L_0x09fd
        L_0x084f:
            java.lang.String r2 = r0.j     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r4 = "TXN_SUCCESS"
            boolean r2 = r2.equals(r4)     // Catch:{ JSONException -> 0x0a84 }
            if (r2 == 0) goto L_0x097f
            r2 = 0
            r0.X = r2     // Catch:{ JSONException -> 0x0a84 }
            r0.Y = r2     // Catch:{ JSONException -> 0x0a84 }
            r1 = 1
            r0.Z = r1     // Catch:{ JSONException -> 0x0a84 }
            android.widget.RelativeLayout r1 = r0.aE     // Catch:{ JSONException -> 0x0a84 }
            r1.setVisibility(r2)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r1 = r0.O     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r2 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ JSONException -> 0x0a84 }
            int r4 = net.one97.paytm.wallet.R.string.paid_successfully_to     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = r2.getString(r4)     // Catch:{ JSONException -> 0x0a84 }
            r1.setText(r2)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r1 = r0.O     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r2 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            int r4 = net.one97.paytm.wallet.R.color.black     // Catch:{ JSONException -> 0x0a84 }
            int r2 = androidx.core.content.b.c(r2, r4)     // Catch:{ JSONException -> 0x0a84 }
            r1.setTextColor(r2)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.ImageView r1 = r0.A     // Catch:{ JSONException -> 0x0a84 }
            r2 = 0
            r1.setVisibility(r2)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r1 = r0.U     // Catch:{ JSONException -> 0x0a84 }
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ JSONException -> 0x0a84 }
            net.one97.paytm.p2mNewDesign.f.k r1 = r0.aL     // Catch:{ JSONException -> 0x0a84 }
            r1.c()     // Catch:{ JSONException -> 0x0a84 }
            android.widget.ImageView r1 = r0.A     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r2 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            int r4 = net.one97.paytm.wallet.R.drawable.payment_done_00048     // Catch:{ JSONException -> 0x0a84 }
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r4)     // Catch:{ JSONException -> 0x0a84 }
            r1.setBackground(r2)     // Catch:{ JSONException -> 0x0a84 }
            r47.g()     // Catch:{ JSONException -> 0x0a84 }
            boolean r1 = r0.aI     // Catch:{ JSONException -> 0x0a84 }
            if (r1 == 0) goto L_0x08d8
            java.lang.Double r1 = r0.aK     // Catch:{ JSONException -> 0x0a84 }
            double r1 = r1.doubleValue()     // Catch:{ JSONException -> 0x0a84 }
            r4 = 0
            int r7 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x08d8
            android.widget.TextView r1 = r0.W     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r2 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            int r4 = net.one97.paytm.wallet.R.string.pcf_charged_message     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = r2.getString(r4)     // Catch:{ JSONException -> 0x0a84 }
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ JSONException -> 0x0a84 }
            java.lang.Double r5 = r0.aK     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ JSONException -> 0x0a84 }
            r7 = 0
            r4[r7] = r5     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ JSONException -> 0x0a84 }
            r1.setText(r2)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r1 = r0.W     // Catch:{ JSONException -> 0x0a84 }
            r1.setVisibility(r7)     // Catch:{ JSONException -> 0x0a84 }
        L_0x08d8:
            r47.h()     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r1 = "success"
            c((java.lang.String) r1)     // Catch:{ JSONException -> 0x0a84 }
            r47.e()     // Catch:{ JSONException -> 0x0a84 }
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ JSONException -> 0x0a84 }
            boolean r1 = r1.f13092h     // Catch:{ JSONException -> 0x0a84 }
            if (r1 == 0) goto L_0x08fb
            java.lang.String r1 = "offline_payments"
            java.lang.String r2 = "post_payment_success_shown"
            java.lang.String r4 = "flow_through_scan_icon"
            android.content.Context r5 = r47.getContext()     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r7 = "home/pay-send/payment-success"
            a(r1, r2, r4, r5, r7)     // Catch:{ JSONException -> 0x0a84 }
            goto L_0x090a
        L_0x08fb:
            java.lang.String r1 = "offline_payments"
            java.lang.String r2 = "post_payment_success_shown"
            java.lang.String r4 = "flow_through_pay_icon"
            android.content.Context r5 = r47.getContext()     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r7 = "home/pay-send/payment-success"
            a(r1, r2, r4, r5, r7)     // Catch:{ JSONException -> 0x0a84 }
        L_0x090a:
            android.os.Bundle r1 = r47.getArguments()     // Catch:{ JSONException -> 0x0a84 }
            r2 = 0
            boolean r1 = r1.getBoolean(r11, r2)     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = r0.q     // Catch:{ JSONException -> 0x0a84 }
            r0.a((boolean) r1, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r1 = "TXNID"
            java.lang.String r1 = r6.optString(r1)     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = r6.optString(r3)     // Catch:{ JSONException -> 0x0a84 }
            r0.b(r1, r2)     // Catch:{ JSONException -> 0x0a84 }
            r47.x()     // Catch:{ JSONException -> 0x0a84 }
            r47.y()     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r1 = "ADDITIONAL_PARAM"
            java.lang.String r1 = r6.optString(r1)     // Catch:{ JSONException -> 0x0a84 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0a84 }
            if (r2 != 0) goto L_0x09fa
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0a84 }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r1 = "merchantInfo"
            org.json.JSONObject r1 = r2.optJSONObject(r1)     // Catch:{ JSONException -> 0x0a84 }
            if (r1 == 0) goto L_0x09fa
            java.lang.String r2 = "mccCode"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ JSONException -> 0x0a84 }
            r0.f51078e = r2     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = "currentTxnCount"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ JSONException -> 0x0a84 }
            r0.aa = r1     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r1 = r0.aa     // Catch:{ JSONException -> 0x0a84 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x0a84 }
            if (r1 != 0) goto L_0x09fa
            java.lang.String r1 = r0.aa     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = "null"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x0a84 }
            if (r1 != 0) goto L_0x09fa
            android.widget.RelativeLayout r1 = r0.ab     // Catch:{ JSONException -> 0x0a84 }
            r2 = 0
            r1.setVisibility(r2)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.RelativeLayout r1 = r0.ab     // Catch:{ JSONException -> 0x0a84 }
            int r2 = net.one97.paytm.wallet.R.id.tv_txn_count     // Catch:{ JSONException -> 0x0a84 }
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = r0.aa     // Catch:{ JSONException -> 0x0a84 }
            r1.setText(r2)     // Catch:{ JSONException -> 0x0a84 }
            goto L_0x09fa
        L_0x097f:
            java.lang.String r2 = r0.j     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r3 = "TXN_FAILURE"
            boolean r2 = r2.equals(r3)     // Catch:{ JSONException -> 0x0a84 }
            if (r2 == 0) goto L_0x09fa
            r2 = 1
            r0.Y = r2     // Catch:{ JSONException -> 0x0a84 }
            r2 = 0
            r0.X = r2     // Catch:{ JSONException -> 0x0a84 }
            com.airbnb.lottie.LottieAnimationView r2 = r0.as     // Catch:{ JSONException -> 0x0a84 }
            r3 = 8
            r2.setVisibility(r3)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.ImageView r2 = r0.A     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r3 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            int r4 = net.one97.paytm.wallet.R.drawable.ic_failed_copy     // Catch:{ JSONException -> 0x0a84 }
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)     // Catch:{ JSONException -> 0x0a84 }
            r2.setBackground(r3)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.ImageView r2 = r0.A     // Catch:{ JSONException -> 0x0a84 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r2 = r0.O     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r3 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ JSONException -> 0x0a84 }
            int r4 = net.one97.paytm.wallet.R.string.payment_failed_wallet     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r3 = r3.getString(r4)     // Catch:{ JSONException -> 0x0a84 }
            r2.setText(r3)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r2 = r0.O     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r3 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            int r4 = net.one97.paytm.wallet.R.color.color_fd5c5c     // Catch:{ JSONException -> 0x0a84 }
            int r3 = androidx.core.content.b.c(r3, r4)     // Catch:{ JSONException -> 0x0a84 }
            r2.setTextColor(r3)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r2 = r0.U     // Catch:{ JSONException -> 0x0a84 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ JSONException -> 0x0a84 }
            boolean r2 = com.paytm.utility.v.a((java.lang.String) r1)     // Catch:{ JSONException -> 0x0a84 }
            if (r2 == 0) goto L_0x09df
            android.app.Activity r1 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ JSONException -> 0x0a84 }
            int r2 = net.one97.paytm.wallet.R.string.msg_post_payment_failed_msg     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ JSONException -> 0x0a84 }
        L_0x09df:
            android.widget.TextView r2 = r0.U     // Catch:{ JSONException -> 0x0a84 }
            r2.setText(r1)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r2 = r0.U     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r3 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            int r4 = net.one97.paytm.wallet.R.color.color_fdfbd3     // Catch:{ JSONException -> 0x0a84 }
            int r3 = androidx.core.content.b.c(r3, r4)     // Catch:{ JSONException -> 0x0a84 }
            r2.setBackgroundColor(r3)     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = "failure"
            c((java.lang.String) r2)     // Catch:{ JSONException -> 0x0a84 }
            r0.e((java.lang.String) r7)     // Catch:{ JSONException -> 0x0a84 }
            goto L_0x0a5c
        L_0x09fa:
            r29 = 0
            goto L_0x0a5e
        L_0x09fd:
            r2 = 1
            r0.X = r2     // Catch:{ JSONException -> 0x0a84 }
            boolean r2 = com.paytm.utility.v.a((java.lang.String) r1)     // Catch:{ JSONException -> 0x0a84 }
            if (r2 == 0) goto L_0x0a12
            android.app.Activity r1 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ JSONException -> 0x0a84 }
            int r2 = net.one97.paytm.wallet.R.string.payment_pending_desc_msg     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ JSONException -> 0x0a84 }
        L_0x0a12:
            android.widget.TextView r2 = r0.U     // Catch:{ JSONException -> 0x0a84 }
            r2.setText(r1)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r2 = r0.U     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r4 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            int r5 = net.one97.paytm.wallet.R.color.color_fdfbd3     // Catch:{ JSONException -> 0x0a84 }
            int r4 = androidx.core.content.b.c(r4, r5)     // Catch:{ JSONException -> 0x0a84 }
            r2.setBackgroundColor(r4)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r2 = r0.U     // Catch:{ JSONException -> 0x0a84 }
            r4 = 0
            r2.setVisibility(r4)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r2 = r0.O     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r4 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ JSONException -> 0x0a84 }
            int r5 = net.one97.paytm.wallet.R.string.payment_pending     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r4 = r4.getString(r5)     // Catch:{ JSONException -> 0x0a84 }
            r2.setText(r4)     // Catch:{ JSONException -> 0x0a84 }
            android.widget.TextView r2 = r0.O     // Catch:{ JSONException -> 0x0a84 }
            android.app.Activity r4 = r0.at     // Catch:{ JSONException -> 0x0a84 }
            int r5 = net.one97.paytm.wallet.R.color.color_ffa400     // Catch:{ JSONException -> 0x0a84 }
            int r4 = androidx.core.content.b.c(r4, r5)     // Catch:{ JSONException -> 0x0a84 }
            r2.setTextColor(r4)     // Catch:{ JSONException -> 0x0a84 }
            com.airbnb.lottie.LottieAnimationView r2 = r0.as     // Catch:{ JSONException -> 0x0a84 }
            r4 = 8
            r2.setVisibility(r4)     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = r6.optString(r3)     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r3 = "MID"
            java.lang.String r3 = r6.optString(r3)     // Catch:{ JSONException -> 0x0a84 }
            r0.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ JSONException -> 0x0a84 }
        L_0x0a5c:
            r29 = r1
        L_0x0a5e:
            net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel r1 = new net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r2 = r0.bx     // Catch:{ JSONException -> 0x0a84 }
            r19 = 0
            java.lang.String r3 = r0.by     // Catch:{ JSONException -> 0x0a84 }
            r21 = 0
            long r23 = r9.longValue()     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r4 = r0.j     // Catch:{ JSONException -> 0x0a84 }
            java.lang.String r5 = r0.aq     // Catch:{ JSONException -> 0x0a84 }
            r27 = 0
            r28 = 0
            r16 = r1
            r18 = r2
            r20 = r3
            r25 = r4
            r26 = r5
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29)     // Catch:{ JSONException -> 0x0a84 }
            r0.bw = r1     // Catch:{ JSONException -> 0x0a84 }
            goto L_0x0a98
        L_0x0a84:
            goto L_0x0a98
        L_0x0a86:
            r35 = r10
            goto L_0x0a98
        L_0x0a89:
            r33 = r4
        L_0x0a8b:
            r35 = r10
            r34 = r14
            goto L_0x0a98
        L_0x0a90:
            r33 = r4
            r35 = r10
            r34 = r14
            r32 = r15
        L_0x0a98:
            android.os.Bundle r1 = r47.getArguments()
            java.lang.String r2 = "backpress_offline_pg"
            boolean r1 = r1.getBoolean(r2)
            r0.bA = r1
            boolean r1 = r0.bA
            if (r1 == 0) goto L_0x0b51
            android.os.Bundle r1 = r47.getArguments()
            java.lang.String r2 = "order_id"
            java.lang.String r1 = r1.getString(r2)
            android.os.Bundle r2 = r47.getArguments()
            java.lang.String r3 = "mid"
            java.lang.String r2 = r2.getString(r3)
            android.widget.TextView r3 = r0.S
            r4 = 0
            r3.setVisibility(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.app.Activity r4 = r0.at
            int r5 = net.one97.paytm.wallet.R.string.order_txn_id
            java.lang.String r4 = r4.getString(r5)
            r3.append(r4)
            r4 = r35
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.widget.TextView r4 = r0.S
            a((java.lang.String) r3, (android.widget.TextView) r4)
            java.lang.String r3 = r0.q
            r0.a((java.lang.String) r3)
            android.widget.TextView r3 = r0.T
            java.lang.String r4 = r0.o
            r3.setText(r4)
            android.widget.TextView r3 = r0.O
            android.app.Activity r4 = r0.at
            int r5 = net.one97.paytm.wallet.R.string.payment_pending
            java.lang.String r4 = r4.getString(r5)
            r3.setText(r4)
            android.widget.TextView r3 = r0.O
            android.app.Activity r4 = r0.at
            int r5 = net.one97.paytm.wallet.R.color.color_ffa400
            int r4 = androidx.core.content.b.c(r4, r5)
            r3.setTextColor(r4)
            android.widget.TextView r3 = r0.U
            android.app.Activity r4 = r0.at
            int r5 = net.one97.paytm.wallet.R.string.payment_pending_desc_msg
            java.lang.String r4 = r4.getString(r5)
            r3.setText(r4)
            android.widget.TextView r3 = r0.U
            android.app.Activity r4 = r0.at
            int r5 = net.one97.paytm.wallet.R.color.color_fdfbd3
            int r4 = androidx.core.content.b.c(r4, r5)
            r3.setBackgroundColor(r4)
            android.widget.TextView r3 = r0.U
            r4 = 0
            r3.setVisibility(r4)
            com.airbnb.lottie.LottieAnimationView r3 = r0.as
            r5 = 8
            r3.setVisibility(r5)
            android.widget.TextView r3 = r0.R
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r6 = r34
            java.lang.String r5 = com.paytm.utility.b.a((java.lang.Long) r5, (java.lang.String) r6)
            r3.setText(r5)
            android.widget.TextView r3 = r0.R
            r3.setVisibility(r4)
            java.lang.String r3 = r0.aA
            r0.b((java.lang.String) r3)
            r0.a((java.lang.String) r1, (java.lang.String) r2)
            goto L_0x0b52
        L_0x0b51:
            r4 = 0
        L_0x0b52:
            android.os.Bundle r1 = r47.getArguments()
            if (r1 == 0) goto L_0x0b69
            android.os.Bundle r1 = r47.getArguments()
            boolean r1 = r1.getBoolean(r11, r4)
            if (r1 != 0) goto L_0x0b69
            android.widget.RelativeLayout r1 = r0.aE
            r2 = 8
            r1.setVisibility(r2)
        L_0x0b69:
            r47.k()
            java.lang.String r1 = r0.w
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0b8b
            android.widget.TextView r1 = r0.f51076c
            r2 = 0
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.f51077d
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.E
            r1.setVisibility(r2)
            android.widget.TextView r1 = r0.E
            java.lang.String r2 = r0.w
            r1.setText(r2)
        L_0x0b8b:
            r33.invalidate()
            boolean r1 = r0.al
            if (r1 == 0) goto L_0x0c5e
            boolean r1 = r0.ao
            if (r1 == 0) goto L_0x0c5e
            android.os.Handler r1 = new android.os.Handler
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r32
            r2.<init>(r3)
            net.one97.paytm.common.entity.IJRDataModel r3 = r0.k
            boolean r4 = r3 instanceof net.one97.paytm.upi.common.upi.BaseUpiResponse
            if (r4 == 0) goto L_0x0c50
            net.one97.paytm.upi.common.upi.BaseUpiResponse r3 = (net.one97.paytm.upi.common.upi.BaseUpiResponse) r3
            r0.ak = r3
            net.one97.paytm.upi.common.upi.BaseUpiResponse r3 = r0.ak
            boolean r3 = r3.isSuccess()
            if (r3 == 0) goto L_0x0bb9
            java.lang.String r3 = "SUCCESS"
            r0.j = r3
            goto L_0x0bbd
        L_0x0bb9:
            java.lang.String r3 = "FAILURE"
            r0.j = r3
        L_0x0bbd:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "txnId="
            r3.<init>(r4)
            net.one97.paytm.upi.common.upi.BaseUpiResponse r4 = r0.ak
            java.lang.String r4 = r4.getSeqNo()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            net.one97.paytm.upi.common.upi.BaseUpiResponse r3 = r0.ak
            java.lang.String r3 = r3.getResponse()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0bf7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "&responseCode="
            r3.<init>(r4)
            net.one97.paytm.upi.common.upi.BaseUpiResponse r4 = r0.ak
            java.lang.String r4 = r4.getResponse()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.append(r3)
        L_0x0bf7:
            net.one97.paytm.upi.common.upi.BaseUpiResponse r3 = r0.ak
            java.lang.String r3 = r3.getBankRRN()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0c1a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "&ApprovalRefNo="
            r3.<init>(r4)
            net.one97.paytm.upi.common.upi.BaseUpiResponse r4 = r0.ak
            java.lang.String r4 = r4.getBankRRN()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.append(r3)
        L_0x0c1a:
            java.lang.String r3 = r0.j
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0c35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "&Status="
            r3.<init>(r4)
            java.lang.String r4 = r0.j
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.append(r3)
        L_0x0c35:
            java.lang.String r3 = r0.ap
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0c50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "&txnRef="
            r3.<init>(r4)
            java.lang.String r4 = r0.ap
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.append(r3)
        L_0x0c50:
            java.lang.String r2 = r2.toString()
            net.one97.paytm.p2mNewDesign.d.d$3 r3 = new net.one97.paytm.p2mNewDesign.d.d$3
            r3.<init>(r2)
            r4 = 2000(0x7d0, double:9.88E-321)
            r1.postDelayed(r3, r4)
        L_0x0c5e:
            boolean r1 = r0.am
            if (r1 != 0) goto L_0x0c99
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            androidx.fragment.app.Fragment r1 = r1.getPostPaymentDealsFragment()
            if (r1 == 0) goto L_0x0c99
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r3 = 123(0x7b, float:1.72E-43)
            java.lang.String r4 = "deal_type"
            r2.putInt(r4, r3)
            r1.setArguments(r2)
            androidx.fragment.app.j r2 = r47.getChildFragmentManager()
            androidx.fragment.app.q r2 = r2.a()
            r3 = 0
            androidx.fragment.app.q r2 = r2.a((int) r3, (int) r3)
            int r3 = net.one97.paytm.wallet.R.id.deals_fragment_container
            java.lang.Class r4 = r1.getClass()
            java.lang.String r4 = r4.getSimpleName()
            androidx.fragment.app.q r1 = r2.b(r3, r1, r4)
            r1.b()
        L_0x0c99:
            boolean r1 = r0.bk
            if (r1 == 0) goto L_0x0cf6
            android.widget.LinearLayout r1 = r0.bd
            r1.removeAllViews()
            android.widget.LinearLayout r1 = r0.bd
            android.widget.LinearLayout r2 = r0.be
            r1.addView(r2)
            android.widget.LinearLayout r1 = r0.bd
            android.widget.LinearLayout r2 = r0.bf
            r1.addView(r2)
            android.widget.LinearLayout r1 = r0.bd
            android.widget.FrameLayout r2 = r0.bg
            r1.addView(r2)
            java.lang.String r1 = r0.bm
            java.lang.String r2 = r0.bl
            java.lang.String r3 = r0.bn
            java.lang.String r4 = r0.bo
            java.lang.String r5 = r0.bp
            net.one97.paytm.p2mNewDesign.g.e$a r6 = net.one97.paytm.p2mNewDesign.g.e.f51282a
            net.one97.paytm.p2mNewDesign.g.e r1 = net.one97.paytm.p2mNewDesign.g.e.a.a(r1, r2, r3, r4, r5)
            androidx.fragment.app.j r2 = r47.getChildFragmentManager()
            if (r2 == 0) goto L_0x0cf0
            androidx.fragment.app.j r2 = r47.getChildFragmentManager()
            androidx.fragment.app.q r2 = r2.a()
            r3 = 0
            androidx.fragment.app.q r2 = r2.a((int) r3, (int) r3)
            android.widget.LinearLayout r4 = r0.bf
            int r4 = r4.getId()
            java.lang.Class r5 = r1.getClass()
            java.lang.String r5 = r5.getSimpleName()
            androidx.fragment.app.q r1 = r2.b(r4, r1, r5)
            r1.c()
            goto L_0x0cf1
        L_0x0cf0:
            r3 = 0
        L_0x0cf1:
            android.widget.RelativeLayout r1 = r0.aE
            r1.setVisibility(r3)
        L_0x0cf6:
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r2 = r0.at
            java.lang.String r3 = "walletAdSlotApiURL"
            java.lang.String r1 = r1.getStringFromGTM(r2, r3)
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r3 = r0.at
            android.widget.FrameLayout r4 = r0.bg
            com.paytm.network.a$c r5 = com.paytm.network.a.c.WALLET
            androidx.fragment.app.Fragment r1 = r2.getSfBannerFragment(r3, r4, r1, r5)
            androidx.fragment.app.FragmentActivity r2 = r47.getActivity()
            androidx.fragment.app.j r2 = r2.getSupportFragmentManager()
            androidx.fragment.app.q r2 = r2.a()
            android.widget.FrameLayout r3 = r0.bg
            int r3 = r3.getId()
            r4 = 0
            r2.b(r3, r1, r4)
            r2.c()
            boolean r1 = r0.bA
            if (r1 != 0) goto L_0x0d30
            r47.z()
        L_0x0d30:
            return r33
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.d.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IStaticWidget iStaticWidget) {
        this.bz = iStaticWidget;
        ((RelativeLayout) this.z.findViewById(R.id.floating_nav)).addView(iStaticWidget.getView());
    }

    /* access modifiers changed from: private */
    public boolean d() {
        return com.paytm.utility.b.a(this.at.getApplicationContext(), net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.at, "app_rating_5_star_time_gap")), net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.at, "app_rating_less_than_5_star_time_gap")), net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.at, "app_rating_not_now_time_gap")));
    }

    private void e() {
        String str = this.ar;
        TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(str)) {
            new RateMerchantHelper(this.at, this, str, new RateMerchantHelper.a() {
                public final void a(MerchantPPReviewData merchantPPReviewData) {
                    if (!d.this.d()) {
                        d.a(d.this, merchantPPReviewData);
                    } else if (d.d(d.this)) {
                        d.this.v();
                    } else {
                        d.a(d.this, merchantPPReviewData);
                    }
                }

                public final void a() {
                    if (d.this.d()) {
                        d.this.v();
                    }
                }
            });
        } else if (d()) {
            v();
        }
    }

    private void f() {
        if (!TextUtils.isEmpty(this.x)) {
            new LinearLayout.LayoutParams(-1, l.a(100)).setMargins(l.a((int) this.at.getResources().getDimension(R.dimen.margin_left_prn)), l.a((int) this.at.getResources().getDimension(R.dimen.margin_top_prn)), l.a((int) this.at.getResources().getDimension(R.dimen.margin_left_prn)), l.a((int) this.at.getResources().getDimension(R.dimen.margin_top_prn)));
            this.f51076c.setVisibility(0);
            this.f51077d.setVisibility(0);
            this.E.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < this.x.length() / 2; i2++) {
                sb.append(this.x.charAt(i2));
            }
            for (int length = this.x.length() / 2; length < this.x.length(); length++) {
                sb2.append(this.x.charAt(length));
            }
            TextView textView = this.E;
            textView.setText(sb.toString() + " " + sb2);
            this.E.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    private void g() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                d.this.B();
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B() {
        if (!this.I.booleanValue()) {
            this.A.setVisibility(8);
            this.as.setVisibility(0);
            this.as.playAnimation();
        }
        Activity activity = this.at;
        if (activity != null) {
            new Handler(activity.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    d.this.A();
                }
            }, 120000);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A() {
        try {
            if (!isDetached() && this.at != null && !this.I.booleanValue()) {
                this.A.setVisibility(0);
                this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.icon_ap_success));
                this.as.setVisibility(8);
                this.as.cancelAnimation();
            }
        } catch (Exception unused) {
        }
    }

    private void h() {
        if (this.m || this.aO || this.bb || this.ao || this.bk) {
            this.aD.setVisibility(8);
        } else if (this.aN) {
            this.aD.setVisibility(0);
        }
    }

    private void b(String str, String str2) {
        if (net.one97.paytm.wallet.communicator.b.a().initializeCashbackJarvisHelper()) {
            this.bj = net.one97.paytm.cashback.posttxn.c.a();
        }
        e eVar = this.bj;
        if (eVar != null && eVar.a(net.one97.paytm.utils.b.a.SCAN_PAY.getId(), 0)) {
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && this.bc != null) {
                this.bj.a((AppCompatActivity) this.at);
                f.a aVar = new f.a();
                if (!TextUtils.isEmpty(str2)) {
                    aVar.f49546b = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    aVar.f49545a = str;
                }
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    aVar.f49550f = null;
                }
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    aVar.f49551g = null;
                }
                if (!TextUtils.isEmpty(this.f51078e)) {
                    aVar.f49552h = this.f51078e;
                }
                this.bj.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) new net.one97.paytm.cashback.posttxn.a() {
                    public final void onAnimationEnd(String str) {
                        if (d.this.bz != null) {
                            d.this.bz.AnimateView(str);
                        }
                    }

                    public final Point getFloatingWidgetPos(String str) {
                        if (d.this.bz != null) {
                            return d.this.bz.getViewPoint(str);
                        }
                        return null;
                    }
                });
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.bC;
        if (handler != null) {
            handler.removeCallbacks(this.bD);
            this.bC = null;
            this.bD = null;
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private void c(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "send_money");
            hashMap.put("new_wallet_successfully_sent_money_amount", str2);
            hashMap.put("wallet_send_money_method_name", str);
            net.one97.paytm.wallet.communicator.b.a().sendCustomEventWithMap("wallet_success_screen_loaded", hashMap, this.at.getApplicationContext());
        } catch (Exception unused) {
        }
    }

    private void a(String str) {
        Double valueOf = Double.valueOf(Double.parseDouble(str));
        if (valueOf.doubleValue() % 1.0d == 0.0d) {
            this.P.setText(d(String.valueOf(valueOf)));
            return;
        }
        String format = new DecimalFormat("#.00").format(Double.parseDouble(str));
        int indexOf = format.indexOf(AppUtility.CENTER_DOT);
        this.P.setText(d(format.substring(0, indexOf)));
        this.Q.setVisibility(0);
        this.Q.setText(format.substring(indexOf));
    }

    private void b(String str) {
        this.L.setVisibility(0);
        this.M.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            try {
                w.a().a(str).a(R.drawable.merchant_icon).b(R.drawable.merchant_icon).a(this.M, (com.squareup.picasso.e) null);
            } catch (Exception unused) {
            }
        } else {
            this.M.setImageDrawable(androidx.core.content.b.a((Context) this.at, R.drawable.merchant_icon));
        }
    }

    private static void c(String str) {
        at.a().a(at.a.Tprocess, System.currentTimeMillis(), str);
        at.a().a(at.a.Tpayment, System.currentTimeMillis(), str);
        at.a().a(System.currentTimeMillis(), str);
        at.f69662a = null;
    }

    private void a(String str, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Confirmation Screen");
            hashMap.put("event_category", net.one97.paytm.common.utility.d.bE);
            hashMap.put("event_action", str);
            hashMap.put("event_label", str3);
            hashMap.put(net.one97.paytm.common.utility.d.cw, str2);
            hashMap.put("user_id", com.paytm.utility.b.n(getContext()));
            hashMap.put(net.one97.paytm.common.utility.d.cv, "offline_payments");
            net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEvents(getContext(), net.one97.paytm.common.utility.d.bE, str, str2, str3, (Object) null, (Object) null, "Confirmation Screen", "offline_payments");
        } catch (Exception unused) {
        }
    }

    private static String d(String str) {
        return new DecimalFormat("##,##,##,##,###").format(new BigDecimal(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0529  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0abe  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0ac3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0368  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(net.one97.paytm.common.entity.IJRDataModel r48) {
        /*
            r47 = this;
            r0 = r47
            r1 = r48
            boolean r2 = r1 instanceof net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel
            java.lang.String r3 = "is_offline_pg"
            r4 = 0
            java.lang.String r6 = "success"
            r7 = 0
            java.lang.String r8 = "hh:mm a, dd MMM yyyy"
            r9 = 1
            r10 = 8
            r11 = 0
            if (r2 == 0) goto L_0x01dd
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel r1 = (net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel) r1
            android.widget.TextView r2 = r0.U
            r2.setVisibility(r10)
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r2 = r1.getResponse()
            if (r2 == 0) goto L_0x0075
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r2 = r1.getResponse()
            java.lang.String r2 = r2.getWalletSystemTxnId()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0075
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r2 = r1.getResponse()
            java.lang.String r2 = r2.getWalletSystemTxnId()
            r0.f51079i = r2
            java.lang.String r2 = r1.getStatus()
            r0.j = r2
            android.widget.TextView r2 = r0.S
            r2.setVisibility(r11)
            android.widget.TextView r2 = r0.S
            android.app.Activity r12 = r0.at
            android.content.res.Resources r12 = r12.getResources()
            int r13 = net.one97.paytm.wallet.R.string.wallet_txn_id
            java.lang.String r12 = r12.getString(r13)
            java.lang.Object[] r13 = new java.lang.Object[r9]
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r14 = r1.getResponse()
            java.lang.String r14 = r14.getWalletSystemTxnId()
            r13[r11] = r14
            java.lang.String r12 = java.lang.String.format(r12, r13)
            r2.setText(r12)
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r2 = r1.getResponse()
            java.lang.String r2 = r2.getWalletSystemTxnId()
            r0.b(r2, r7)
            r47.e()
            goto L_0x007a
        L_0x0075:
            android.widget.TextView r2 = r0.S
            r2.setVisibility(r10)
        L_0x007a:
            java.lang.String r2 = r0.aA
            r0.b((java.lang.String) r2)
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r2 = r1.getResponse()
            if (r2 == 0) goto L_0x009d
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r2 = r1.getResponse()
            java.lang.String r2 = r2.getPccCode()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x009d
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r2 = r1.getResponse()
            java.lang.String r2 = r2.getPccCode()
            r0.w = r2
        L_0x009d:
            android.widget.TextView r2 = r0.R
            r2.setVisibility(r11)
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r2 = r1.getResponse()
            if (r2 == 0) goto L_0x00d0
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r2 = r1.getResponse()
            java.lang.String r2 = r2.getTimestamp()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00d0
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r2 = r1.getResponse()
            java.lang.String r2 = r2.getTimestamp()
            long r12 = java.lang.Long.parseLong(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            android.widget.TextView r7 = r0.R
            java.lang.String r8 = com.paytm.utility.b.a((java.lang.Long) r2, (java.lang.String) r8)
            r7.setText(r8)
            goto L_0x00e1
        L_0x00d0:
            long r12 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            android.widget.TextView r7 = r0.R
            java.lang.String r8 = com.paytm.utility.b.a((java.lang.Long) r2, (java.lang.String) r8)
            r7.setText(r8)
        L_0x00e1:
            android.widget.ImageView r7 = r0.A
            r7.setVisibility(r11)
            com.airbnb.lottie.LottieAnimationView r7 = r0.as
            r7.setVisibility(r10)
            net.one97.paytm.p2mNewDesign.f.k r7 = r0.aL
            r7.c()
            android.widget.ImageView r7 = r0.A
            android.app.Activity r8 = r0.at
            int r10 = net.one97.paytm.wallet.R.drawable.payment_done_00048
            android.graphics.drawable.Drawable r8 = androidx.core.content.b.a((android.content.Context) r8, (int) r10)
            r7.setBackground(r8)
            r47.g()
            android.widget.TextView r7 = r0.T
            java.lang.String r8 = r0.o
            r7.setText(r8)
            boolean r7 = r0.aI
            if (r7 == 0) goto L_0x0135
            java.lang.Double r7 = r0.aK
            double r7 = r7.doubleValue()
            int r10 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x0135
            android.widget.TextView r4 = r0.W
            android.app.Activity r5 = r0.at
            int r7 = net.one97.paytm.wallet.R.string.pcf_charged_message
            java.lang.String r5 = r5.getString(r7)
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.Double r8 = r0.aK
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7[r11] = r8
            java.lang.String r5 = java.lang.String.format(r5, r7)
            r4.setText(r5)
            android.widget.TextView r4 = r0.W
            r4.setVisibility(r11)
        L_0x0135:
            c((java.lang.String) r6)
            r47.h()
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r4 = r1.getResponse()
            java.lang.String r4 = r4.getTxnAmount()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x015a
            java.math.BigDecimal r5 = new java.math.BigDecimal
            r5.<init>(r4)
            java.math.BigDecimal r4 = r5.stripTrailingZeros()
            java.lang.String r4 = r4.toPlainString()
            r0.a((java.lang.String) r4)
            goto L_0x0174
        L_0x015a:
            java.lang.String r5 = r0.q
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0174
            java.math.BigDecimal r4 = new java.math.BigDecimal
            java.lang.String r5 = r0.q
            r4.<init>(r5)
            java.math.BigDecimal r4 = r4.stripTrailingZeros()
            java.lang.String r4 = r4.toPlainString()
            r0.a((java.lang.String) r4)
        L_0x0174:
            r18 = r4
            android.widget.TextView r4 = r0.O
            android.app.Activity r5 = r0.at
            android.content.res.Resources r5 = r5.getResources()
            int r6 = net.one97.paytm.wallet.R.string.paid_successfully_to
            java.lang.String r5 = r5.getString(r6)
            r4.setText(r5)
            android.widget.TextView r4 = r0.O
            android.app.Activity r5 = r0.at
            int r6 = net.one97.paytm.wallet.R.color.black
            int r5 = androidx.core.content.b.c(r5, r6)
            r4.setTextColor(r5)
            android.os.Bundle r4 = r47.getArguments()
            boolean r3 = r4.getBoolean(r3, r11)
            java.lang.String r4 = r0.q
            r0.a((boolean) r3, (java.lang.String) r4)
            net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel r3 = new net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel
            java.lang.String r4 = r1.getType()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x01b0
            java.lang.String r4 = "mode"
            goto L_0x01b4
        L_0x01b0:
            java.lang.String r4 = r1.getType()
        L_0x01b4:
            r13 = r4
            java.lang.String r14 = r0.bx
            r15 = 0
            java.lang.String r4 = r0.by
            r17 = 0
            long r19 = r2.longValue()
            java.lang.String r21 = r1.getStatus()
            r22 = 0
            java.lang.String r1 = r0.f51079i
            r24 = 0
            r25 = 0
            r12 = r3
            r16 = r4
            r23 = r1
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r21, r22, r23, r24, r25)
            r0.bw = r3
            r47.x()
            r47.y()
            return
        L_0x01dd:
            boolean r2 = r1 instanceof net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse
            java.lang.String r12 = "PENDING"
            java.lang.String r13 = " "
            java.lang.String r14 = "flow_through_scan_icon"
            java.lang.String r15 = "flow_through_pay_icon"
            java.lang.String r7 = "home/pay-send/payment-success"
            java.lang.String r4 = "post_payment_success_shown"
            java.lang.String r5 = "offline_payments"
            if (r2 == 0) goto L_0x05ee
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse r1 = (net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse) r1
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r2 = r1.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r19 = r1.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r19 = r19.getResultInfo()
            java.lang.String r9 = r19.getResultMsg()
            long r21 = java.lang.System.currentTimeMillis()
            java.lang.Long r19 = java.lang.Long.valueOf(r21)
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head r21 = r1.getHead()
            java.lang.String r10 = r21.getMid()
            r0.ar = r10
            java.lang.String r10 = r2.getOrderId()
            r0.aq = r10
            java.lang.String r10 = r2.getOrderId()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0262
            java.lang.String r10 = r2.getTxnId()
            r0.f51079i = r10
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r10 = r2.getResultInfo()
            java.lang.String r10 = r10.getResultStatus()
            r0.j = r10
            android.widget.TextView r10 = r0.S
            r10.setVisibility(r11)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            android.app.Activity r11 = r0.at
            android.content.res.Resources r11 = r11.getResources()
            r48 = r9
            int r9 = net.one97.paytm.wallet.R.string.order_txn_id
            java.lang.String r9 = r11.getString(r9)
            r10.append(r9)
            r10.append(r13)
            java.lang.String r9 = r2.getOrderId()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            android.widget.TextView r10 = r0.S
            a((java.lang.String) r9, (android.widget.TextView) r10)
            goto L_0x026b
        L_0x0262:
            r48 = r9
            android.widget.TextView r9 = r0.S
            r10 = 8
            r9.setVisibility(r10)
        L_0x026b:
            java.lang.String r9 = r0.aA
            r0.b((java.lang.String) r9)
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r9 = r1.getFastForwardResponseDetail()
            java.lang.String r9 = r9.getPrn()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x028b
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r9 = r1.getFastForwardResponseDetail()
            java.lang.String r9 = r9.getPrn()
            r0.x = r9
            r47.f()
        L_0x028b:
            android.widget.TextView r9 = r0.R
            r10 = 0
            r9.setVisibility(r10)
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head r9 = r1.getHead()     // Catch:{ NumberFormatException -> 0x02cd }
            java.lang.String r9 = r9.getResponseTimestamp()     // Catch:{ NumberFormatException -> 0x02cd }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ NumberFormatException -> 0x02cd }
            if (r9 != 0) goto L_0x02bb
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head r9 = r1.getHead()     // Catch:{ NumberFormatException -> 0x02cd }
            java.lang.String r9 = r9.getResponseTimestamp()     // Catch:{ NumberFormatException -> 0x02cd }
            long r9 = java.lang.Long.parseLong(r9)     // Catch:{ NumberFormatException -> 0x02cd }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ NumberFormatException -> 0x02cd }
            android.widget.TextView r10 = r0.R     // Catch:{ NumberFormatException -> 0x02b9 }
            java.lang.String r8 = com.paytm.utility.b.a((java.lang.Long) r9, (java.lang.String) r8)     // Catch:{ NumberFormatException -> 0x02b9 }
            r10.setText(r8)     // Catch:{ NumberFormatException -> 0x02b9 }
            goto L_0x02cf
        L_0x02b9:
            goto L_0x02cf
        L_0x02bb:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ NumberFormatException -> 0x02cd }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ NumberFormatException -> 0x02cd }
            android.widget.TextView r10 = r0.R     // Catch:{ NumberFormatException -> 0x02b9 }
            java.lang.String r8 = com.paytm.utility.b.a((java.lang.Long) r9, (java.lang.String) r8)     // Catch:{ NumberFormatException -> 0x02b9 }
            r10.setText(r8)     // Catch:{ NumberFormatException -> 0x02b9 }
            goto L_0x02cf
        L_0x02cd:
            r9 = r19
        L_0x02cf:
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r8 = r1.getFastForwardResponseDetail()
            if (r8 == 0) goto L_0x02ef
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r8 = r1.getFastForwardResponseDetail()
            java.lang.String r8 = r8.getTxnAmount()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x02ef
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r8 = r1.getFastForwardResponseDetail()
            java.lang.String r8 = r8.getTxnAmount()
            r0.a((java.lang.String) r8)
            goto L_0x02fc
        L_0x02ef:
            java.lang.String r8 = r0.q
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x02fc
            java.lang.String r8 = r0.q
            r0.a((java.lang.String) r8)
        L_0x02fc:
            android.widget.TextView r8 = r0.T
            java.lang.String r10 = r0.o
            r8.setText(r10)
            boolean r8 = r0.aY
            java.lang.String r10 = r0.aU
            java.lang.String r11 = r0.aX
            java.lang.String r13 = r0.aP
            r19 = r9
            java.lang.String r9 = r0.j
            r32 = r1
            boolean r1 = r0.aV
            r33 = r15
            java.lang.String r15 = r0.aZ
            r34 = r4
            java.lang.String r4 = r0.ba
            r35 = r5
            boolean r5 = r0.aW
            r23 = r8
            r24 = r10
            r25 = r11
            r26 = r13
            r27 = r9
            r28 = r1
            r29 = r15
            r30 = r4
            r31 = r5
            java.lang.String r41 = net.one97.paytm.wallet.utility.a.a(r23, r24, r25, r26, r27, r28, r29, r30, r31)
            net.one97.paytm.wallet.communicator.c r36 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r1 = r0.at
            r38 = 200(0xc8, float:2.8E-43)
            r42 = 0
            com.paytm.network.a$b r44 = com.paytm.network.a.b.USER_FACING
            r45 = 0
            com.paytm.network.a$c r46 = com.paytm.network.a.c.PAYMENTS
            java.lang.String r39 = ""
            java.lang.String r40 = "NA"
            r37 = r1
            r36.pushHawkeyeEvent(r37, r38, r39, r40, r41, r42, r44, r45, r46)
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r1 = r2.getResultInfo()
            java.lang.String r1 = r1.getResultStatus()
            boolean r1 = r12.equals(r1)
            if (r1 != 0) goto L_0x0529
            java.lang.String r1 = r0.j
            java.lang.String r4 = "TXN_PENDING"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0368
            goto L_0x0529
        L_0x0368:
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r1 = r2.getResultInfo()
            java.lang.String r1 = r1.getResultStatus()
            java.lang.String r4 = "TXN_SUCCESS"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x04a8
            r1 = 1
            r0.Z = r1
            r1 = 0
            r0.X = r1
            r0.Y = r1
            android.widget.TextView r1 = r0.O
            android.app.Activity r4 = r0.at
            android.content.res.Resources r4 = r4.getResources()
            int r5 = net.one97.paytm.wallet.R.string.paid_successfully_to
            java.lang.String r4 = r4.getString(r5)
            r1.setText(r4)
            android.widget.TextView r1 = r0.O
            android.app.Activity r4 = r0.at
            int r5 = net.one97.paytm.wallet.R.color.black
            int r4 = androidx.core.content.b.c(r4, r5)
            r1.setTextColor(r4)
            android.widget.ImageView r1 = r0.A
            r4 = 0
            r1.setVisibility(r4)
            android.widget.RelativeLayout r1 = r0.aE
            r1.setVisibility(r4)
            com.airbnb.lottie.LottieAnimationView r1 = r0.as
            r4 = 8
            r1.setVisibility(r4)
            net.one97.paytm.p2mNewDesign.f.k r1 = r0.aL
            r1.c()
            android.os.Bundle r1 = r0.n
            if (r1 == 0) goto L_0x03be
            java.lang.String r1 = "WALLET"
            r0.f((java.lang.String) r1)
        L_0x03be:
            boolean r1 = r0.aI
            if (r1 == 0) goto L_0x03f0
            java.lang.Double r1 = r0.aK
            double r4 = r1.doubleValue()
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x03f0
            android.widget.TextView r1 = r0.W
            android.app.Activity r4 = r0.at
            int r5 = net.one97.paytm.wallet.R.string.pcf_charged_message
            java.lang.String r4 = r4.getString(r5)
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Double r8 = r0.aK
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r9 = 0
            r5[r9] = r8
            java.lang.String r4 = java.lang.String.format(r4, r5)
            r1.setText(r4)
            android.widget.TextView r1 = r0.W
            r1.setVisibility(r9)
        L_0x03f0:
            c((java.lang.String) r6)
            r47.h()
            android.widget.ImageView r1 = r0.A
            android.app.Activity r4 = r0.at
            int r5 = net.one97.paytm.wallet.R.drawable.payment_done_00048
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r5)
            r1.setBackground(r4)
            r47.g()
            android.widget.TextView r1 = r0.U
            r4 = 8
            r1.setVisibility(r4)
            android.os.Bundle r1 = r47.getArguments()
            r4 = 0
            boolean r1 = r1.getBoolean(r3, r4)
            java.lang.String r3 = r0.q
            r0.a((boolean) r1, (java.lang.String) r3)
            r47.e()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r1 = r1.f13092h
            if (r1 == 0) goto L_0x0432
            android.content.Context r1 = r47.getContext()
            r4 = r34
            r5 = r35
            a(r5, r4, r14, r1, r7)
            goto L_0x043f
        L_0x0432:
            r4 = r34
            r5 = r35
            android.content.Context r1 = r47.getContext()
            r9 = r33
            a(r5, r4, r9, r1, r7)
        L_0x043f:
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r1 = r32.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.MerchantInfo r1 = r1.getMerchantInfo()
            if (r1 == 0) goto L_0x048a
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r1 = r32.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.MerchantInfo r1 = r1.getMerchantInfo()
            java.lang.String r1 = r1.getCurrentTxnCount()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x047c
            android.widget.RelativeLayout r1 = r0.ab
            r3 = 0
            r1.setVisibility(r3)
            android.widget.RelativeLayout r1 = r0.ab
            int r3 = net.one97.paytm.wallet.R.id.tv_txn_count
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.widget.TextView r1 = (android.widget.TextView) r1
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r3 = r32.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.MerchantInfo r3 = r3.getMerchantInfo()
            java.lang.String r3 = r3.getCurrentTxnCount()
            r1.setText(r3)
        L_0x047c:
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r1 = r32.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.MerchantInfo r1 = r1.getMerchantInfo()
            java.lang.String r1 = r1.getMccCode()
            r0.f51078e = r1
        L_0x048a:
            if (r2 == 0) goto L_0x049f
            java.lang.String r1 = r2.getTxnId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x049f
            java.lang.String r1 = r2.getTxnId()
            r10 = 0
            r0.b(r1, r10)
            goto L_0x04a0
        L_0x049f:
            r10 = 0
        L_0x04a0:
            r47.x()
            r47.y()
            goto L_0x0525
        L_0x04a8:
            r10 = 0
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r1 = r2.getResultInfo()
            java.lang.String r1 = r1.getResultStatus()
            java.lang.String r3 = "TXN_FAILURE"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0525
            r1 = 1
            r0.Y = r1
            r1 = 0
            r0.X = r1
            android.widget.ImageView r3 = r0.A
            android.app.Activity r4 = r0.at
            int r5 = net.one97.paytm.wallet.R.drawable.ic_failed_copy
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r5)
            r3.setBackground(r4)
            android.widget.ImageView r3 = r0.A
            r3.setVisibility(r1)
            com.airbnb.lottie.LottieAnimationView r1 = r0.as
            r3 = 8
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.O
            android.app.Activity r3 = r0.at
            android.content.res.Resources r3 = r3.getResources()
            int r4 = net.one97.paytm.wallet.R.string.payment_failed_wallet
            java.lang.String r3 = r3.getString(r4)
            r1.setText(r3)
            android.widget.TextView r1 = r0.O
            android.app.Activity r3 = r0.at
            int r4 = net.one97.paytm.wallet.R.color.color_fd5c5c
            int r3 = androidx.core.content.b.c(r3, r4)
            r1.setTextColor(r3)
            boolean r1 = com.paytm.utility.v.a((java.lang.String) r48)
            if (r1 == 0) goto L_0x0505
            android.widget.TextView r1 = r0.U
            r3 = 8
            r1.setVisibility(r3)
            r7 = r10
            goto L_0x0513
        L_0x0505:
            android.widget.TextView r1 = r0.U
            r3 = 0
            r1.setVisibility(r3)
            android.widget.TextView r1 = r0.U
            r3 = r48
            r1.setText(r3)
            r7 = r3
        L_0x0513:
            java.lang.String r1 = "failure"
            c((java.lang.String) r1)
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r1 = r2.getResultInfo()
            java.lang.String r1 = r1.getResultCode()
            r0.e((java.lang.String) r1)
            goto L_0x05b8
        L_0x0525:
            r46 = r10
            goto L_0x05ba
        L_0x0529:
            r3 = r48
            r9 = r33
            r5 = r35
            r1 = 1
            r0.X = r1
            android.widget.TextView r1 = r0.O
            android.app.Activity r4 = r0.at
            android.content.res.Resources r4 = r4.getResources()
            int r6 = net.one97.paytm.wallet.R.string.payment_pending
            java.lang.String r4 = r4.getString(r6)
            r1.setText(r4)
            android.widget.TextView r1 = r0.O
            android.app.Activity r4 = r0.at
            int r6 = net.one97.paytm.wallet.R.color.color_ffa400
            int r4 = androidx.core.content.b.c(r4, r6)
            r1.setTextColor(r4)
            boolean r1 = com.paytm.utility.v.a((java.lang.String) r3)
            if (r1 == 0) goto L_0x0564
            android.app.Activity r1 = r0.at
            android.content.res.Resources r1 = r1.getResources()
            int r3 = net.one97.paytm.wallet.R.string.payment_pending_desc_msg
            java.lang.String r1 = r1.getString(r3)
            r7 = r1
            goto L_0x0565
        L_0x0564:
            r7 = r3
        L_0x0565:
            android.widget.TextView r1 = r0.U
            r1.setText(r7)
            android.widget.TextView r1 = r0.U
            android.app.Activity r3 = r0.at
            int r4 = net.one97.paytm.wallet.R.color.color_fdfbd3
            int r3 = androidx.core.content.b.c(r3, r4)
            r1.setBackgroundColor(r3)
            android.widget.TextView r1 = r0.U
            r3 = 0
            r1.setVisibility(r3)
            com.airbnb.lottie.LottieAnimationView r1 = r0.as
            r3 = 8
            r1.setVisibility(r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r1 = r1.f13092h
            if (r1 == 0) goto L_0x0598
            android.content.Context r1 = r47.getContext()
            java.lang.String r3 = "post_payment_pending_shown"
            java.lang.String r4 = "home/pay-send/payment-pending"
            a(r5, r3, r14, r1, r4)
            goto L_0x05a3
        L_0x0598:
            android.content.Context r1 = r47.getContext()
            java.lang.String r3 = "post_payment_pending_shown"
            java.lang.String r4 = "home/pay-send/payment-pending"
            a(r5, r3, r9, r1, r4)
        L_0x05a3:
            java.lang.String r1 = r2.getOrderId()
            if (r1 == 0) goto L_0x05b8
            java.lang.String r1 = r2.getOrderId()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head r3 = r32.getHead()
            java.lang.String r3 = r3.getMid()
            r0.a((java.lang.String) r1, (java.lang.String) r3)
        L_0x05b8:
            r46 = r7
        L_0x05ba:
            net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel r1 = new net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel
            java.lang.String r3 = r0.bx
            r36 = 0
            java.lang.String r4 = r0.by
            r38 = 0
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r5 = r32.getFastForwardResponseDetail()
            java.lang.String r39 = r5.getTxnAmount()
            long r40 = r19.longValue()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r2 = r2.getResultInfo()
            java.lang.String r42 = r2.getResultStatus()
            r43 = 0
            java.lang.String r2 = r0.f51079i
            r45 = 0
            java.lang.String r34 = "BALANCE"
            r33 = r1
            r35 = r3
            r37 = r4
            r44 = r2
            r33.<init>(r34, r35, r36, r37, r38, r39, r40, r42, r43, r44, r45, r46)
            r0.bw = r1
            return
        L_0x05ee:
            r9 = r15
            r10 = 0
            boolean r2 = r1 instanceof net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse
            if (r2 == 0) goto L_0x0ae8
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse r1 = (net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse) r1
            android.widget.TextView r2 = r0.U
            r11 = 8
            r2.setVisibility(r11)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            if (r2 == 0) goto L_0x065d
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getORDERID()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x065d
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getORDERID()
            r0.aq = r2
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getSTATUS()
            r0.j = r2
            android.widget.TextView r2 = r0.S
            r11 = 0
            r2.setVisibility(r11)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.app.Activity r11 = r0.at
            android.content.res.Resources r11 = r11.getResources()
            int r15 = net.one97.paytm.wallet.R.string.order_txn_id
            java.lang.String r11 = r11.getString(r15)
            r2.append(r11)
            r2.append(r13)
            java.lang.String r11 = r0.aq
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.widget.TextView r11 = r0.S
            a((java.lang.String) r2, (android.widget.TextView) r11)
            goto L_0x0664
        L_0x065d:
            android.widget.TextView r2 = r0.S
            r11 = 8
            r2.setVisibility(r11)
        L_0x0664:
            java.lang.String r2 = r0.aA
            r0.b((java.lang.String) r2)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            if (r2 == 0) goto L_0x069b
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            if (r2 == 0) goto L_0x069b
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getTXNAMOUNT()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x069b
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getTXNAMOUNT()
            r0.a((java.lang.String) r2)
            goto L_0x06a8
        L_0x069b:
            java.lang.String r2 = r0.q
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x06a8
            java.lang.String r2 = r0.q
            r0.a((java.lang.String) r2)
        L_0x06a8:
            android.widget.TextView r2 = r0.T
            java.lang.String r11 = r0.o
            r2.setText(r11)
            android.widget.TextView r2 = r0.R
            r11 = 0
            r2.setVisibility(r11)
            net.one97.paytm.p2mNewDesign.entity.Head r2 = r1.getHead()
            if (r2 == 0) goto L_0x06e3
            net.one97.paytm.p2mNewDesign.entity.Head r2 = r1.getHead()
            java.lang.String r2 = r2.getResponseTimestamp()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x06e3
            net.one97.paytm.p2mNewDesign.entity.Head r2 = r1.getHead()
            java.lang.String r2 = r2.getResponseTimestamp()
            long r15 = java.lang.Long.parseLong(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r15)
            android.widget.TextView r11 = r0.R
            java.lang.String r2 = com.paytm.utility.b.a((java.lang.Long) r2, (java.lang.String) r8)
            r11.setText(r2)
            goto L_0x06f4
        L_0x06e3:
            android.widget.TextView r2 = r0.R
            long r15 = java.lang.System.currentTimeMillis()
            java.lang.Long r11 = java.lang.Long.valueOf(r15)
            java.lang.String r8 = com.paytm.utility.b.a((java.lang.Long) r11, (java.lang.String) r8)
            r2.setText(r8)
        L_0x06f4:
            boolean r2 = r0.aY
            java.lang.String r8 = r0.aU
            java.lang.String r11 = r0.aX
            java.lang.String r13 = r0.aP
            java.lang.String r15 = r0.j
            boolean r10 = r0.aV
            r19 = r3
            java.lang.String r3 = r0.aZ
            r33 = r9
            java.lang.String r9 = r0.ba
            r34 = r4
            boolean r4 = r0.aW
            r23 = r2
            r24 = r8
            r25 = r11
            r26 = r13
            r27 = r15
            r28 = r10
            r29 = r3
            r30 = r9
            r31 = r4
            java.lang.String r40 = net.one97.paytm.wallet.utility.a.a(r23, r24, r25, r26, r27, r28, r29, r30, r31)
            net.one97.paytm.wallet.communicator.c r35 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r2 = r0.at
            r37 = 200(0xc8, float:2.8E-43)
            r41 = 0
            com.paytm.network.a$b r43 = com.paytm.network.a.b.USER_FACING
            r44 = 0
            com.paytm.network.a$c r45 = com.paytm.network.a.c.PAYMENTS
            java.lang.String r38 = ""
            java.lang.String r39 = "NA"
            r36 = r2
            r35.pushHawkeyeEvent(r36, r37, r38, r39, r40, r41, r43, r44, r45)
            java.lang.String r2 = r0.j
            boolean r2 = r2.equals(r12)
            if (r2 != 0) goto L_0x09f3
            java.lang.String r2 = r0.j
            java.lang.String r3 = "TXN_PENDING"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x074f
            goto L_0x09f3
        L_0x074f:
            java.lang.String r2 = r0.j
            java.lang.String r3 = "TXN_SUCCESS"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0949
            r2 = 0
            r0.X = r2
            r0.Y = r2
            r3 = 1
            r0.Z = r3
            android.widget.RelativeLayout r3 = r0.aE
            r3.setVisibility(r2)
            net.one97.paytm.postpayment.utils.WalletCircularProgressBar r2 = r0.aF
            r3 = 8
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.O
            android.app.Activity r3 = r0.at
            android.content.res.Resources r3 = r3.getResources()
            int r4 = net.one97.paytm.wallet.R.string.paid_successfully_to
            java.lang.String r3 = r3.getString(r4)
            r2.setText(r3)
            android.widget.TextView r2 = r0.O
            android.app.Activity r3 = r0.at
            int r4 = net.one97.paytm.wallet.R.color.black
            int r3 = androidx.core.content.b.c(r3, r4)
            r2.setTextColor(r3)
            android.widget.ImageView r2 = r0.A
            r3 = 0
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.U
            r3 = 8
            r2.setVisibility(r3)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            if (r2 == 0) goto L_0x07b6
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            if (r2 == 0) goto L_0x07b6
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getMID()
            r0.ar = r2
        L_0x07b6:
            net.one97.paytm.p2mNewDesign.f.k r2 = r0.aL
            r2.c()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            if (r2 == 0) goto L_0x07f6
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getPAYMENTMODE()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x07f6
            android.os.Bundle r2 = r0.n
            if (r2 == 0) goto L_0x07f6
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getPAYMENTMODE()
            java.lang.String r3 = "UPI"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x07f1
            java.lang.String r2 = "UPI"
            r0.f((java.lang.String) r2)
            goto L_0x07f6
        L_0x07f1:
            java.lang.String r2 = "IMPS"
            r0.f((java.lang.String) r2)
        L_0x07f6:
            android.widget.ImageView r2 = r0.A
            android.app.Activity r3 = r0.at
            int r4 = net.one97.paytm.wallet.R.drawable.payment_done_00048
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)
            r2.setBackground(r3)
            r47.e()
            r47.g()
            boolean r2 = r0.aH
            if (r2 == 0) goto L_0x0833
            java.lang.String r2 = r0.aJ
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0833
            java.lang.String r2 = r0.aJ
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x082b
            android.widget.TextView r2 = r0.W
            r3 = 0
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.W
            java.lang.String r3 = r0.aJ
            r2.setText(r3)
            goto L_0x0865
        L_0x082b:
            android.widget.TextView r2 = r0.W
            r3 = 8
            r2.setVisibility(r3)
            goto L_0x0865
        L_0x0833:
            boolean r2 = r0.aI
            if (r2 == 0) goto L_0x0865
            java.lang.Double r2 = r0.aK
            double r2 = r2.doubleValue()
            r8 = 0
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x0865
            android.widget.TextView r2 = r0.W
            android.app.Activity r3 = r0.at
            int r4 = net.one97.paytm.wallet.R.string.pcf_charged_message
            java.lang.String r3 = r3.getString(r4)
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Double r8 = r0.aK
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r9 = 0
            r4[r9] = r8
            java.lang.String r3 = java.lang.String.format(r3, r4)
            r2.setText(r3)
            android.widget.TextView r2 = r0.W
            r2.setVisibility(r9)
        L_0x0865:
            c((java.lang.String) r6)
            r47.h()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r2 = r2.f13092h
            if (r2 == 0) goto L_0x087d
            android.content.Context r2 = r47.getContext()
            r3 = r34
            a(r5, r3, r14, r2, r7)
            goto L_0x0888
        L_0x087d:
            r3 = r34
            android.content.Context r2 = r47.getContext()
            r4 = r33
            a(r5, r3, r4, r2, r7)
        L_0x0888:
            if (r1 == 0) goto L_0x08c0
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            if (r2 == 0) goto L_0x08c0
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            if (r2 == 0) goto L_0x08c0
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getADDITIONAL_PARAM()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r3 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r3 = r3.getTxnInfo()
            java.lang.String r3 = r3.getPRN()
            r0.x = r3
            java.lang.String r3 = r0.x
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x08c2
            r47.f()
            goto L_0x08c2
        L_0x08c0:
            java.lang.String r2 = ""
        L_0x08c2:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0916
            java.lang.String r3 = "\\\\"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.replaceAll(r3, r4)
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0916 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0916 }
            java.lang.String r2 = "merchantInfo"
            org.json.JSONObject r2 = r3.optJSONObject(r2)     // Catch:{ Exception -> 0x0916 }
            if (r2 == 0) goto L_0x0916
            java.lang.String r3 = "mccCode"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ Exception -> 0x0916 }
            r0.f51078e = r3     // Catch:{ Exception -> 0x0916 }
            java.lang.String r3 = "currentTxnCount"
            java.lang.String r2 = r2.optString(r3)     // Catch:{ Exception -> 0x0916 }
            r0.aa = r2     // Catch:{ Exception -> 0x0916 }
            java.lang.String r2 = r0.aa     // Catch:{ Exception -> 0x0916 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0916 }
            if (r2 != 0) goto L_0x0916
            java.lang.String r2 = r0.aa     // Catch:{ Exception -> 0x0916 }
            java.lang.String r3 = "null"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0916 }
            if (r2 != 0) goto L_0x0916
            android.widget.RelativeLayout r2 = r0.ab     // Catch:{ Exception -> 0x0916 }
            r3 = 0
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0916 }
            android.widget.RelativeLayout r2 = r0.ab     // Catch:{ Exception -> 0x0916 }
            int r3 = net.one97.paytm.wallet.R.id.tv_txn_count     // Catch:{ Exception -> 0x0916 }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ Exception -> 0x0916 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0916 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x0916 }
            java.lang.String r3 = r0.aa     // Catch:{ Exception -> 0x0916 }
            r2.setText(r3)     // Catch:{ Exception -> 0x0916 }
        L_0x0916:
            android.os.Bundle r2 = r47.getArguments()
            r3 = r19
            r4 = 0
            boolean r2 = r2.getBoolean(r3, r4)
            java.lang.String r3 = r0.q
            r0.a((boolean) r2, (java.lang.String) r3)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getTXNID()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r3 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r3 = r3.getTxnInfo()
            java.lang.String r3 = r3.getORDERID()
            r0.b(r2, r3)
            r47.x()
            r47.y()
            goto L_0x09ef
        L_0x0949:
            java.lang.String r2 = r0.j
            java.lang.String r3 = "TXN_FAILURE"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x09ef
            r2 = 1
            r0.Y = r2
            r2 = 0
            r0.X = r2
            net.one97.paytm.postpayment.utils.WalletCircularProgressBar r3 = r0.aF
            r4 = 8
            r3.setVisibility(r4)
            com.airbnb.lottie.LottieAnimationView r3 = r0.as
            r3.setVisibility(r4)
            android.widget.ImageView r3 = r0.A
            android.app.Activity r4 = r0.at
            int r5 = net.one97.paytm.wallet.R.drawable.ic_failed_copy
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r5)
            r3.setBackground(r4)
            android.widget.ImageView r3 = r0.A
            r3.setVisibility(r2)
            android.widget.TextView r2 = r0.O
            android.app.Activity r3 = r0.at
            android.content.res.Resources r3 = r3.getResources()
            int r4 = net.one97.paytm.wallet.R.string.payment_failed_wallet
            java.lang.String r3 = r3.getString(r4)
            r2.setText(r3)
            android.widget.TextView r2 = r0.O
            android.app.Activity r3 = r0.at
            int r4 = net.one97.paytm.wallet.R.color.color_fd5c5c
            int r3 = androidx.core.content.b.c(r3, r4)
            r2.setTextColor(r3)
            android.widget.TextView r2 = r0.U
            r3 = 0
            r2.setVisibility(r3)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResultInfo r2 = r2.getResultInfo()
            java.lang.String r2 = r2.getResultMsg()
            boolean r2 = com.paytm.utility.v.a((java.lang.String) r2)
            if (r2 == 0) goto L_0x09ba
            android.app.Activity r2 = r0.at
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.wallet.R.string.msg_post_payment_failed_msg
            java.lang.String r2 = r2.getString(r3)
            goto L_0x09c6
        L_0x09ba:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResultInfo r2 = r2.getResultInfo()
            java.lang.String r2 = r2.getResultMsg()
        L_0x09c6:
            r7 = r2
            android.widget.TextView r2 = r0.U
            r2.setText(r7)
            android.widget.TextView r2 = r0.U
            android.app.Activity r3 = r0.at
            int r4 = net.one97.paytm.wallet.R.color.color_fdfbd3
            int r3 = androidx.core.content.b.c(r3, r4)
            r2.setBackgroundColor(r3)
            java.lang.String r2 = "failure"
            c((java.lang.String) r2)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getRESPCODE()
            r0.e((java.lang.String) r2)
            goto L_0x0a7a
        L_0x09ef:
            r21 = 0
            goto L_0x0a7c
        L_0x09f3:
            r2 = 1
            r0.X = r2
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResultInfo r2 = r2.getResultInfo()
            java.lang.String r2 = r2.getResultMsg()
            boolean r2 = com.paytm.utility.v.a((java.lang.String) r2)
            if (r2 == 0) goto L_0x0a15
            android.app.Activity r2 = r0.at
            android.content.res.Resources r2 = r2.getResources()
            int r3 = net.one97.paytm.wallet.R.string.payment_pending_desc_msg
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0a21
        L_0x0a15:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResultInfo r2 = r2.getResultInfo()
            java.lang.String r2 = r2.getResultMsg()
        L_0x0a21:
            r7 = r2
            android.widget.TextView r2 = r0.U
            r2.setText(r7)
            android.widget.TextView r2 = r0.U
            android.app.Activity r3 = r0.at
            int r4 = net.one97.paytm.wallet.R.color.color_fdfbd3
            int r3 = androidx.core.content.b.c(r3, r4)
            r2.setBackgroundColor(r3)
            android.widget.TextView r2 = r0.U
            r3 = 0
            r2.setVisibility(r3)
            android.widget.TextView r2 = r0.O
            android.app.Activity r3 = r0.at
            android.content.res.Resources r3 = r3.getResources()
            int r4 = net.one97.paytm.wallet.R.string.payment_pending
            java.lang.String r3 = r3.getString(r4)
            r2.setText(r3)
            android.widget.TextView r2 = r0.O
            android.app.Activity r3 = r0.at
            int r4 = net.one97.paytm.wallet.R.color.color_ffa400
            int r3 = androidx.core.content.b.c(r3, r4)
            r2.setTextColor(r3)
            com.airbnb.lottie.LottieAnimationView r2 = r0.as
            r3 = 8
            r2.setVisibility(r3)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getORDERID()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r3 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r3 = r3.getTxnInfo()
            java.lang.String r3 = r3.getMID()
            r0.a((java.lang.String) r2, (java.lang.String) r3)
        L_0x0a7a:
            r21 = r7
        L_0x0a7c:
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long.valueOf(r2)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r1 = r1.getTxnInfo()
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0aac }
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0aac }
            java.lang.String r3 = r1.getTXNDATE()     // Catch:{ Exception -> 0x0aac }
            java.util.Date r2 = r2.parse(r3)     // Catch:{ Exception -> 0x0aac }
            java.sql.Timestamp r3 = new java.sql.Timestamp     // Catch:{ Exception -> 0x0aac }
            long r4 = r2.getTime()     // Catch:{ Exception -> 0x0aac }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0aac }
            long r2 = r3.getTime()     // Catch:{ Exception -> 0x0aac }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0aac }
            goto L_0x0ab4
        L_0x0aac:
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
        L_0x0ab4:
            java.lang.String r3 = r1.getPAYMENTMODE()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0ac3
            java.lang.String r3 = r1.getPAYMENTMODE()
            goto L_0x0ac5
        L_0x0ac3:
            java.lang.String r3 = "mode"
        L_0x0ac5:
            r9 = r3
            net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel r3 = new net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel
            java.lang.String r10 = r0.bx
            r11 = 0
            java.lang.String r12 = r0.by
            r13 = 0
            java.lang.String r14 = r1.getTXNAMOUNT()
            long r15 = r2.longValue()
            java.lang.String r17 = r1.getSTATUS()
            java.lang.String r18 = r1.getORDERID()
            r19 = 0
            r20 = 0
            r8 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r21)
            r0.bw = r3
        L_0x0ae8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.d.a(net.one97.paytm.common.entity.IJRDataModel):void");
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2) {
        this.aq = str;
        this.ar = str2;
        d(str, str2);
    }

    /* access modifiers changed from: private */
    public void d(String str, String str2) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            int i2 = f51073h;
            if (i2 <= f51072g) {
                f51073h = i2 + 1;
                this.aF.setVisibility(0);
                LiveData<net.one97.paytm.network.f> a2 = net.one97.paytm.wallet.j.a.a((Context) this.at, str, str2);
                if (a2 != null) {
                    a2.observeForever(new z(str, str2) {
                        private final /* synthetic */ String f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onChanged(Object obj) {
                            d.this.a(this.f$1, this.f$2, (net.one97.paytm.network.f) obj);
                        }
                    });
                    return;
                }
                return;
            }
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                a("offline_payments", "post_payment_pending_shown", "flow_through_scan_icon", getContext(), "home/pay-send/payment-pending");
            } else {
                a("offline_payments", "post_payment_pending_shown", "flow_through_pay_icon", getContext(), "home/pay-send/payment-pending");
            }
            this.aF.setVisibility(8);
            this.A.setVisibility(0);
            this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.ic_pending_copy));
        }
    }

    private void e(String str) {
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
            a("offline_payments", "post_payment_failure_shown", "flow_through_scan_icon", str, getContext(), "home/pay-send/payment-failed");
            return;
        }
        a("offline_payments", "post_payment_failure_shown", "flow_through_pay_icon", str, getContext(), "home/pay-send/payment-failed");
    }

    public void onClick(View view) {
        y<net.one97.paytm.network.f> yVar;
        String str;
        String str2;
        String str3;
        if (view.getId() == R.id.add_money_view) {
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                a("offline_payments", "post_payment_addmoney_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/");
            } else {
                a("offline_payments", "post_payment_addmoney_clicked", "flow_through_pay_icon", getContext(), "home/pay-send/");
            }
        } else if (view.getId() == R.id.contact_us_view) {
            n();
            this.at.finish();
        } else if (view.getId() == R.id.passbook_view) {
            net.one97.paytm.wallet.communicator.b.a().handleDeepLink(getContext(), "paytmmp://cash_wallet?featuretype=cash_ledger", (Bundle) null);
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.al;
            if (z2) {
                str2 = "UPI_p2m_clicked";
                str3 = "passbook_landing_page";
                str = "summary screen - p2m-upi/summary";
            } else if (this.ai || z2) {
                str3 = null;
                str2 = null;
                str = null;
            } else {
                if (this.Z) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/wallet/pay-send/success");
                        hashMap.put("event_category", "wallet_send_money");
                        hashMap.put("event_action", "wallet_p2m_clicked");
                        hashMap.put("vertical_name", "wallet");
                        hashMap.put("event_label", "p2m");
                        hashMap.put("user_id", com.paytm.utility.b.n((Context) this.at));
                        net.one97.paytm.wallet.communicator.b.a().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, this.at);
                    } catch (Exception unused) {
                    }
                }
                str = "summary screen - p2m-wallet/summary";
                str3 = "passbook_landing_page";
                str2 = "wallet_p2m_clicked";
            }
            if (this.Z) {
                arrayList.add("success");
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                    a("offline_payments", "post_payment_viewpassbook_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/");
                } else {
                    a("offline_payments", "post_payment_viewpassbook_clicked", "flow_through_pay_icon", getContext(), "home/pay-send/");
                }
            } else if (this.X) {
                arrayList.add(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING);
            } else {
                arrayList.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            }
            if (!v.a(str)) {
                net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEventsWithMultipleLabel(getContext(), str3, str2, arrayList, (String) null, str, "passbook");
            }
        } else if (view.getId() == R.id.resend_confirmation_payment) {
            if (getArguments().getBoolean("is_offline_pg", false) && this.ad) {
                b(net.one97.paytm.common.utility.d.bO, net.one97.paytm.common.utility.d.by, net.one97.paytm.common.utility.d.ce);
                i();
            } else if ("p2m".equalsIgnoreCase(this.u) && this.ad) {
                b(net.one97.paytm.common.utility.d.bO, net.one97.paytm.common.utility.d.by, net.one97.paytm.common.utility.d.ce);
                o();
                String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.at, "obdCallMerchantUrl");
                HashMap hashMap2 = new HashMap();
                HashMap hashMap3 = new HashMap();
                hashMap2.put("ssotoken", com.paytm.utility.a.q(net.one97.paytm.wallet.communicator.b.a().getContext()));
                net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(stringFromGTM, new CJRObdResponse(), hashMap3, hashMap2, q());
                bVar.e();
                bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM((Context) this.at, "p2mGenericAPITimeOut")));
                if (com.paytm.utility.b.c((Context) this.at)) {
                    yVar = bVar.c();
                } else {
                    yVar = net.one97.paytm.base.d.f49504d.a(this.at, bVar);
                }
                if (yVar != null) {
                    yVar.observeForever(new z() {
                        public final void onChanged(Object obj) {
                            d.this.a((net.one97.paytm.network.f) obj);
                        }
                    });
                }
            } else if (this.bk) {
                b(net.one97.paytm.common.utility.d.bO, net.one97.paytm.common.utility.d.by, net.one97.paytm.common.utility.d.ce);
                i();
            } else {
                b(net.one97.paytm.common.utility.d.bO, net.one97.paytm.common.utility.d.bz, net.one97.paytm.common.utility.d.cf);
                n();
            }
        } else if (view.getId() == R.id.tv_share) {
            l();
        } else if (view.getId() == R.id.logout) {
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                a("offline_payments", "post_payment_logout_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/payment-success");
            } else {
                a("offline_payments", "post_payment_logout_clicked", "flow_through_pay_icon", getContext(), "home/pay-send/payment-success");
            }
            net.one97.paytm.wallet.communicator.b.a().signOut(this.at, false, (NetworkCustomError) null);
            Intent intent = new Intent(this.at, net.one97.paytm.wallet.communicator.b.a().getMainActivityClass());
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            startActivity(intent);
        } else if (view.getId() == R.id.contact_trust_layout) {
            this.at.startActivity(new Intent(this.at, net.one97.paytm.wallet.communicator.b.a().getTrustSealActivity()));
        } else if (view.getId() == R.id.iv_back_button || view.getId() == R.id.iv_cross) {
            if (this.bv) {
                if (getActivity() != null && !getActivity().isFinishing()) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("chat_txn_response", this.bw);
                    getActivity().setResult(-1, intent2);
                    getActivity().finish();
                }
            } else if (getActivity() != null && !getActivity().isFinishing()) {
                if (this.bB == e.C0905e.PAY.getType()) {
                    Intent intent3 = new Intent(getActivity(), PaySendActivityV2.class);
                    intent3.addFlags(603979776);
                    getActivity().startActivity(intent3);
                    getActivity().finish();
                    return;
                }
                Intent intent4 = new Intent(getActivity(), net.one97.paytm.wallet.communicator.b.a().getMainActivityClass());
                intent4.addFlags(67108864);
                startActivity(intent4);
            }
        } else if (view.getId() == R.id.repeat_payment_view) {
            Intent intent5 = new Intent(this.at, AJRQRActivity.class);
            intent5.putExtra("OPERATION", "scan");
            intent5.putExtra("scan_result", this.aS);
            intent5.setFlags(536870912);
            intent5.putExtra("is_from_repeat_payment", true);
            this.at.startActivity(intent5);
            a("offline_payments", "post_payment_repeat_payment_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/payment-success");
        }
    }

    private void i() {
        net.one97.paytm.postpayment.a.a aVar = new net.one97.paytm.postpayment.a.a();
        Bundle bundle = new Bundle();
        bundle.putString(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, this.f51079i);
        bundle.putString("merchant_id", this.ar);
        bundle.putString("order_id", this.aq);
        bundle.putString("mobileNumber", this.y);
        bundle.putString("merchant_name", this.o);
        aVar.setArguments(bundle);
        aVar.show(getFragmentManager(), (String) null);
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
            a("offline_payments", "resend_merchant_notification_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/");
        } else {
            a("offline_payments", "resend_merchant_notification_clicked", "flow_through_pay_icon", getContext(), "home/pay-send/");
        }
    }

    public void onPause() {
        super.onPause();
        w();
    }

    private void j() {
        try {
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.at, "check_user_balance_service");
            if (stringFromGTM == null) {
                return;
            }
            if (URLUtil.isValidUrl(stringFromGTM)) {
                com.paytm.utility.b.e((Context) this.at, stringFromGTM);
                new JSONObject().put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(net.one97.paytm.wallet.communicator.b.a().getContext()));
                hashMap.put("Accept-Encoding", "gzip");
                new StringBuilder("SSO Token :: ").append(com.paytm.utility.a.q(net.one97.paytm.wallet.communicator.b.a().getContext()));
                com.paytm.utility.b.j();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        this.J.setText(this.at.getResources().getString(R.string.fetching_balance));
        this.J.setVisibility(0);
        if (!com.paytm.utility.b.c((Context) this.at)) {
            this.J.setText(this.at.getResources().getString(R.string.connecting_to_internet));
        }
        if (this.au) {
            this.av.setVisibility(8);
            u();
            return;
        }
        boolean z2 = this.al;
        if (z2 || this.an || this.ay) {
            s();
        } else if (this.ai || z2) {
            this.J.setVisibility(8);
        } else {
            j();
        }
    }

    private void l() {
        Activity activity;
        if (Build.VERSION.SDK_INT < 23 || !s.a() || (activity = this.at) == null || activity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", this.at.getResources().getString(R.string.post_payment_share_subject));
                intent.putExtra("android.intent.extra.TEXT", m());
                Bitmap a2 = a((View) this.az);
                ContentResolver contentResolver = this.at.getContentResolver();
                String insertImage = MediaStore.Images.Media.insertImage(contentResolver, a2, getString(R.string.title) + "-" + System.currentTimeMillis(), (String) null);
                if (insertImage != null) {
                    intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                    Intent createChooser = Intent.createChooser(intent, this.at.getResources().getString(R.string.post_payment_share_title));
                    if (createChooser.resolveActivity(this.at.getPackageManager()) != null) {
                        startActivity(createChooser);
                    } else {
                        Toast.makeText(this.at, this.at.getResources().getString(R.string.no_app_found), 1).show();
                    }
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                        a("offline_payments", "post_payment_share_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/payment-share");
                    } else {
                        a("offline_payments", "post_payment_share_clicked", "flow_through_pay_icon", getContext(), "home/pay-send/payment-share");
                    }
                }
            } catch (Exception unused) {
            }
        } else {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 103);
            Activity activity2 = this.at;
            Toast.makeText(activity2, activity2.getResources().getString(R.string.permission_not_granted), 0).show();
        }
    }

    private static Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private String m() {
        int i2 = this.s;
        if (i2 == 1) {
            return net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.at, "GTM_SHARE_BUTTON_TEXT_MESSAGE_P2P");
        }
        if (i2 == 2) {
            return net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.at, "GTM_SHARE_BUTTON_TEXT_MESSAGE_P2B");
        }
        if (i2 != 3) {
            return getString(R.string.post_payment_p2p_message) + " http://m.p-y.tm";
        }
        boolean z2 = this.Z;
        if (z2 || (!this.X && !this.Y && !z2)) {
            return net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.at, "GTM_SHARE_BUTTON_TEXT_MESSAGE_P2M");
        }
        return "";
    }

    private void n() {
        o();
        if (this.al) {
            CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
            cJRReplacementReason.setIssueText("UPI");
            cJRReplacementReason.setId(UpiConstants.CST_UPI_ID);
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, (Serializable) null);
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, cJRReplacementReason);
            net.one97.paytm.wallet.communicator.b.a().openH5(this.at, bundle, this);
            return;
        }
        CJRReplacementReason cJRReplacementReason2 = new CJRReplacementReason();
        cJRReplacementReason2.setIssueText("Wallet");
        cJRReplacementReason2.setId(1000003);
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, cJRReplacementReason2);
        net.one97.paytm.wallet.communicator.b.a().openH5(this.at, bundle2, this);
    }

    private void o() {
        try {
            if (this.v == null) {
                this.v = net.one97.paytm.wallet.utility.a.b(this.at);
            }
            if (this.v != null && !this.v.isShowing()) {
                this.v.show();
            }
        } catch (Exception unused) {
        }
    }

    private void p() {
        try {
            if (this.v != null && this.v.isShowing()) {
                this.v.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    private String q() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("txnId", this.f51079i);
            jSONObject.put("request", jSONObject2);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 103 && s.a(iArr)) {
            l();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.ag = r();
    }

    private Bundle r() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_back_shown", this.af);
        return bundle;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle bundle2 = this.ag;
        if (bundle2 == null) {
            bundle2 = r();
        }
        bundle.putBundle("saved_state", bundle2);
    }

    private void s() {
        if (t()) {
            RelativeLayout relativeLayout = this.av;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.ax;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
        }
    }

    private boolean t() {
        if (getArguments() == null) {
            return false;
        }
        boolean z2 = getArguments().getBoolean("is_offline_pg", false);
        boolean z3 = getArguments().getBoolean("is_wallet_transection", false);
        if (!z2 || z3) {
            return false;
        }
        return true;
    }

    private void a(boolean z2, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", net.one97.paytm.common.utility.d.cr);
            hashMap.put("event_action", net.one97.paytm.common.utility.d.cq);
            hashMap.put(net.one97.paytm.common.utility.d.ct, z2 ? net.one97.paytm.common.utility.d.cj : net.one97.paytm.common.utility.d.ck);
            hashMap.put("user_id", com.paytm.utility.b.n(getContext()));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.common.utility.d.cp);
            hashMap.put(net.one97.paytm.common.utility.d.cv, net.one97.paytm.common.utility.d.cy);
            hashMap.put(net.one97.paytm.common.utility.d.cw, net.one97.paytm.common.utility.d.cl);
            hashMap.put(net.one97.paytm.common.utility.d.cm, net.one97.paytm.common.utility.d.cp);
            hashMap.put(net.one97.paytm.common.utility.d.cn, str);
            hashMap.put(net.one97.paytm.common.utility.d.co, z2 ? net.one97.paytm.common.utility.d.cj : net.one97.paytm.common.utility.d.ck);
            hashMap.put("event_label", str);
            hashMap.put("event_value", str);
            net.one97.paytm.wallet.communicator.b.a().sendCustomEventWithMap(net.one97.paytm.common.utility.d.cu, hashMap, this.at);
        } catch (Exception unused) {
        }
    }

    private void u() {
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.at, "pp_accounts_v3_url");
        if (!TextUtils.isEmpty(stringFromGTM)) {
            Uri.parse(stringFromGTM).buildUpon().appendQueryParameter("fetch_type", "ACCOUNTS").appendQueryParameter("channel", StringSet.Android).appendQueryParameter("version", "2").appendQueryParameter(AppConstants.TAG_SITE_ID, "1").appendQueryParameter(AppConstants.TAG_CHILD_SITE_ID, "1").build();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(net.one97.paytm.wallet.communicator.b.a().getContext()));
        }
    }

    private void b(String str, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", net.one97.paytm.common.utility.d.bF + net.one97.paytm.common.utility.d.cx);
            hashMap.put("event_action", str);
            hashMap.put(net.one97.paytm.common.utility.d.cw, str2);
            hashMap.put("user_id", com.paytm.utility.b.n(getContext()));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, net.one97.paytm.common.utility.d.cx);
            hashMap.put(net.one97.paytm.common.utility.d.cv, net.one97.paytm.common.utility.d.ch);
            if (str3 != null) {
                hashMap.put("event_label", str3);
            }
            net.one97.paytm.wallet.communicator.b.a().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, this.at);
        } catch (Exception unused) {
        }
    }

    public final void a(float f2) {
        com.paytm.utility.b.x(this.at.getApplicationContext(), "is_app_rated");
        net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEvents(this.at.getApplicationContext(), "app_rating", Float.toString(f2), "p2m_screen", (String) null, (String) null, (String) null, "app_rating");
        if (f2 < 5.0f) {
            com.paytm.utility.b.a(this.at.getApplicationContext(), "app_rating_less_than_5_star_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(this.at.getApplicationContext(), "app_rating_5_star_timestamp", 0);
            Float valueOf = Float.valueOf(f2);
            if (!this.at.isFinishing()) {
                ((TextView) this.aG.getView().findViewById(R.id.tv_msg)).setText(this.at.getResources().getString(net.one97.paytm.common.widgets.R.string.feedback_thanks_msg));
                this.aG.getView().findViewById(R.id.tv_sub_msg).setVisibility(8);
                this.aG.getView().findViewById(R.id.iv_close_icon).setVisibility(8);
                ((AppCompatRatingBar) this.aG.getView().findViewById(R.id.ratingBar)).setRating(valueOf.floatValue());
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        d.this.w();
                    }
                }, net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.at, "app_rating_thank_you_expire_time")));
            }
        } else {
            w();
            com.paytm.utility.b.a(this.at.getApplicationContext(), "app_rating_5_star_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(this.at.getApplicationContext(), "app_rating_less_than_5_star_timestamp", 0);
            com.paytm.utility.b.ai(this.at.getApplicationContext());
        }
        com.paytm.utility.b.a(this.at.getApplicationContext(), "app_rating_not_now_timestamp", 0);
    }

    public final void a() {
        com.paytm.utility.b.a(this.at.getApplicationContext(), "app_rating_not_now_timestamp", System.currentTimeMillis());
        com.paytm.utility.b.a(this.at.getApplicationContext(), "app_rating_5_star_timestamp", 0);
        com.paytm.utility.b.a(this.at.getApplicationContext(), "app_rating_less_than_5_star_timestamp", 0);
        net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEvents(this.at.getApplicationContext(), "app_rating", "cross_button_clicked", "p2m_screen", (String) null, (String) null, (String) null, "app_rating");
        w();
    }

    /* access modifiers changed from: private */
    public void v() {
        if (!this.at.isFinishing() && this.aG == null) {
            this.aG = new c();
            this.aG.a((a) this);
            this.aG.show(getActivity().getSupportFragmentManager(), (String) null);
        }
    }

    private static void a(String str, String str2, String str3, Context context, String str4) {
        try {
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvents(context, str, str2, str3, (String) null, str4, "offline_payments");
        } catch (Exception unused) {
        }
    }

    private static void a(String str, String str2, String str3, String str4, Context context, String str5) {
        try {
            net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEvents(context, str, str2, str3, str4, (String) null, str5, "offline_payments");
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void w() {
        try {
            if (this.at != null && !this.at.isFinishing() && this.aG != null && this.aG.isAdded() && this.aG.isVisible()) {
                this.aG.dismissAllowingStateLoss();
            }
        } catch (Exception unused) {
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (this.at != null && !isDetached()) {
            if (iJRPaytmDataModel instanceof CJRAccountSummary) {
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) iJRPaytmDataModel;
                if (cJRAccountSummary != null && cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                    this.aj = cJRAccountSummary.getAccounts().get(0).getEffectiveBalance();
                    this.J.setText(this.at.getResources().getString(R.string.paytm_bank_account_balance));
                    this.B.setVisibility(0);
                    this.r.setVisibility(0);
                    this.r.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + this.aj);
                }
            } else if (iJRPaytmDataModel instanceof CJRMerchantTransactionStatusResponse) {
                CJRMerchantTransactionStatusResponse cJRMerchantTransactionStatusResponse = (CJRMerchantTransactionStatusResponse) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getPRN())) {
                    this.x = cJRMerchantTransactionStatusResponse.getResponse().getPRN();
                    f();
                }
                if (cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equals("TXN_SUCCESS")) {
                    this.aF.setVisibility(8);
                    this.O.setText(this.at.getResources().getString(R.string.paid_successfully_to));
                    this.O.setTextColor(androidx.core.content.b.c(this.at, R.color.black));
                    this.U.setVisibility(8);
                    this.A.setVisibility(0);
                    this.as.setVisibility(8);
                    this.aL.c();
                    if (!(cJRMerchantTransactionStatusResponse.getResponse() == null || TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getPAYMENTMODE()) || this.n == null)) {
                        if (cJRMerchantTransactionStatusResponse.getResponse().getPAYMENTMODE().equals("UPI")) {
                            f("UPI");
                        } else {
                            f("IMPS");
                        }
                    }
                    this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.payment_done_00048));
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                        a("offline_payments", "post_payment_success_shown", "flow_through_scan_icon", getContext(), "home/pay-send/payment-success");
                    } else {
                        a("offline_payments", "post_payment_success_shown", "flow_through_pay_icon", getContext(), "home/pay-send/payment-success");
                    }
                    g();
                    c("success");
                    if (this.aI && this.aK.doubleValue() > 0.0d) {
                        this.W.setText(String.format(this.at.getString(R.string.pcf_charged_message), new Object[]{this.aK.toString()}));
                        this.W.setVisibility(0);
                    }
                    h();
                    if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getTXNID())) {
                        b(cJRMerchantTransactionStatusResponse.getResponse().getTXNID(), (String) null);
                    }
                    x();
                    y();
                } else if (cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equalsIgnoreCase("FAILED") || cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equalsIgnoreCase("TXN_FAILURE")) {
                    this.aF.setVisibility(8);
                    this.A.setVisibility(0);
                    this.as.setVisibility(8);
                    this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.ic_failed));
                    this.O.setText(this.at.getResources().getString(R.string.payment_failed_wallet));
                    this.O.setTextColor(androidx.core.content.b.c(this.at, R.color.color_fd5c5c));
                    this.U.setVisibility(0);
                    this.U.setText(this.at.getResources().getString(R.string.msg_post_payment_failed_msg));
                    this.U.setBackgroundColor(androidx.core.content.b.c(this.at, R.color.color_fdfbd3));
                    c(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                    e(cJRMerchantTransactionStatusResponse.getResponse().getRESPCODE());
                } else {
                    this.aF.setVisibility(0);
                    c(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING);
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            d dVar = d.this;
                            dVar.d(dVar.aq, d.this.ar);
                        }
                    }, (long) f51071f);
                }
            } else if (iJRPaytmDataModel instanceof CJRPPUserProfileKycTnc) {
                CJRPPUserProfileKycTnc cJRPPUserProfileKycTnc = (CJRPPUserProfileKycTnc) iJRPaytmDataModel;
                if (cJRPPUserProfileKycTnc.getAccounts() != null && cJRPPUserProfileKycTnc.getAccounts().length > 0) {
                    CJRPPAccount[] accounts = cJRPPUserProfileKycTnc.getAccounts();
                    int length = accounts.length;
                    int i2 = 0;
                    while (i2 < length) {
                        CJRPPAccount cJRPPAccount = accounts[i2];
                        String applicationStatus = cJRPPAccount.getApplicationStatus();
                        if (TextUtils.isEmpty(applicationStatus) || !applicationStatus.equalsIgnoreCase("APPLICATION_CONFIRMED")) {
                            i2++;
                        } else {
                            if (!(getView() == null || getView().findViewById(R.id.wallet_balance_rl) == null)) {
                                getView().findViewById(R.id.wallet_balance_rl).setVisibility(0);
                            }
                            this.J.setVisibility(0);
                            this.J.setText(this.at.getResources().getString(R.string.updated_postpaid_balance));
                            this.B.setVisibility(0);
                            this.r.setVisibility(0);
                            this.r.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + cJRPPAccount.getAvailableCreditLimit());
                            return;
                        }
                    }
                }
            }
        }
    }

    public void show() {
        o();
    }

    public void dismiss() {
        p();
    }

    private void f(String str) {
        if (!TextUtils.isEmpty(this.n.getString("payee_id")) || !TextUtils.isEmpty(this.n.getString("payer_id"))) {
            SBMarkAsPaid sBMarkAsPaid = new SBMarkAsPaid();
            sBMarkAsPaid.setPaymentMode(str);
            sBMarkAsPaid.setPayeeId(this.n.getString("payee_id"));
            sBMarkAsPaid.setPayerId(this.n.getString("payer_id"));
            sBMarkAsPaid.setTotalAmount(this.n.getString("amount"));
            net.one97.paytm.wallet.splitbill.e.b.a(this.at, sBMarkAsPaid);
        }
    }

    private void x() {
        if (!this.ao && !this.aO) {
            j.a().a((Context) getActivity());
            if (this.m) {
                net.one97.paytm.wallet.d.k.a();
                net.one97.paytm.wallet.d.k.a(this.at, this.o, this.y, this.aA, System.currentTimeMillis(), this.q, "wallet", k.a.NONE);
            }
            RecentDataNetworkManager.uploadRecentPaymentsData(this.at);
        }
    }

    private void y() {
        String str;
        String str2;
        net.one97.paytm.wallet.j.a aVar = this.aM;
        if (aVar != null && (str = this.aP) != null && (str2 = this.aQ) != null) {
            aVar.a(str, str2);
            if (this.aR != null) {
                this.aM.b(com.paytm.utility.b.n((Context) this.at), this.aR);
            }
        }
    }

    public final void a(MyOrdersAPIResponse myOrdersAPIResponse) {
        int i2;
        this.az.setVisibility(0);
        if (!(myOrdersAPIResponse.getPayments() == null || myOrdersAPIResponse.getPayments().get(0) == null)) {
            if (!TextUtils.isEmpty(myOrdersAPIResponse.getPayments().get(0).getMerchantLogoUrl())) {
                b(myOrdersAPIResponse.getPayments().get(0).getMerchantLogoUrl());
            }
            if (!(this.ab == null || this.ac == null)) {
                if (myOrdersAPIResponse.getPayments().get(0).getTxnCount() != null) {
                    this.ab.setVisibility(0);
                    this.ac.setText(myOrdersAPIResponse.getPayments().get(0).getTxnCount().toString());
                } else {
                    this.ab.setVisibility(8);
                }
            }
            this.T.setText(this.bn);
        }
        if (!TextUtils.isEmpty(myOrdersAPIResponse.getSubtotal().toString())) {
            a(myOrdersAPIResponse.getSubtotal().toString());
        }
        if (myOrdersAPIResponse.getOrderStatus().toString().equalsIgnoreCase("2")) {
            if (!(myOrdersAPIResponse.getPayments() == null || myOrdersAPIResponse.getPayments().get(0) == null)) {
                this.f51079i = myOrdersAPIResponse.getPayments().get(0).getTransactionNumber();
                this.aR = myOrdersAPIResponse.getPayments().get(0).getMid();
            }
            this.aq = myOrdersAPIResponse.getId();
            if (this.aI && this.aK.doubleValue() > 0.0d) {
                this.W.setText(String.format(this.at.getString(R.string.pcf_charged_message), new Object[]{String.valueOf(this.aK)}));
                this.W.setVisibility(0);
            }
            h();
            if (this.aH && !TextUtils.isEmpty(this.aJ)) {
                if (!TextUtils.isEmpty(this.aJ)) {
                    this.W.setVisibility(0);
                    this.W.setText(this.aJ);
                } else {
                    this.W.setVisibility(8);
                }
            }
            if (!TextUtils.isEmpty(this.p)) {
                TextView textView = this.V;
                textView.setText("\" " + this.p + " \"");
                this.V.setVisibility(0);
            }
            this.bs = false;
            this.aF.setVisibility(8);
            this.O.setText(this.at.getResources().getString(R.string.paid_successfully_to));
            this.O.setTextColor(androidx.core.content.b.c(this.at, R.color.black));
            this.A.setVisibility(0);
            this.as.setVisibility(8);
            this.aL.c();
            this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.payment_done_00048));
            g();
            this.U.setVisibility(8);
            x();
            y();
            c("success");
        } else if (myOrdersAPIResponse.getOrderStatus().toString().equalsIgnoreCase("4") || myOrdersAPIResponse.getOrderStatus().toString().equalsIgnoreCase("8")) {
            if (!TextUtils.isEmpty(this.p)) {
                TextView textView2 = this.V;
                textView2.setText("\" " + this.p + " \"");
                this.V.setVisibility(0);
            }
            this.bs = false;
            this.aF.setVisibility(8);
            this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.ic_failed_copy));
            this.A.setVisibility(0);
            this.as.setVisibility(8);
            this.O.setText(this.at.getResources().getString(R.string.payment_failed_wallet));
            this.O.setTextColor(androidx.core.content.b.c(this.at, R.color.color_fd5c5c));
            this.U.setVisibility(8);
            this.aE.setVisibility(8);
            c(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            e("MLV_ERROR");
        } else if (myOrdersAPIResponse.getOrderStatus().toString().equalsIgnoreCase("1") || myOrdersAPIResponse.getOrderStatus().toString().equalsIgnoreCase("3") || myOrdersAPIResponse.getOrderStatus().toString().equalsIgnoreCase("5") || myOrdersAPIResponse.getOrderStatus().toString().equalsIgnoreCase("6")) {
            if (!TextUtils.isEmpty(this.p)) {
                TextView textView3 = this.V;
                textView3.setText("\" " + this.p + " \"");
                this.V.setVisibility(0);
            }
            this.bs = true;
            this.O.setText(this.at.getResources().getString(R.string.payment_pending));
            this.O.setTextColor(androidx.core.content.b.c(this.at, R.color.color_ffa400));
            this.U.setText(this.at.getResources().getString(R.string.payment_pending_desc_msg));
            this.U.setBackgroundColor(androidx.core.content.b.c(this.at, R.color.color_fdfbd3));
            this.U.setVisibility(0);
            this.A.setVisibility(0);
            this.as.setVisibility(8);
            this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.ic_pending_copy));
            this.aE.setVisibility(8);
            if (!this.bs || this.bt >= 3) {
                this.aF.setVisibility(8);
            } else {
                this.aF.setVisibility(0);
            }
            c(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING);
            if (!this.bs || (i2 = this.bt) >= 3) {
                this.bs = false;
            } else {
                this.bt = i2 + 1;
                int i3 = this.bt;
                if (i3 == 1) {
                    this.bu = 1000;
                } else if (i3 == 2) {
                    this.bu = H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY;
                } else if (i3 == 3) {
                    this.bu = 4000;
                }
                this.bC = new Handler();
                this.bD = new Runnable() {
                    public final void run() {
                        try {
                            if (d.this.at != null && !d.this.at.isFinishing()) {
                                Fragment c2 = d.this.getChildFragmentManager().c(d.this.bf.getId());
                                if (c2 instanceof net.one97.paytm.p2mNewDesign.g.e) {
                                    ((net.one97.paytm.p2mNewDesign.g.e) c2).a(true);
                                }
                            }
                        } catch (IllegalStateException unused) {
                        }
                    }
                };
                this.bC.postDelayed(this.bD, (long) this.bu);
            }
        }
        if (!TextUtils.isEmpty(myOrdersAPIResponse.getId())) {
            this.S.setVisibility(0);
            a(this.at.getResources().getString(R.string.order_txn_id) + " " + myOrdersAPIResponse.getId(), this.S);
        } else {
            this.S.setVisibility(8);
        }
        this.R.setVisibility(0);
        if (!TextUtils.isEmpty(myOrdersAPIResponse.getCreatedAt())) {
            this.R.setText(g(myOrdersAPIResponse.getCreatedAt()));
        }
    }

    public final void a(g gVar, String str) {
        this.az.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            a(str);
        }
        this.aF.setVisibility(8);
        this.T.setText(this.bn);
        this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.ic_failed_copy));
        this.A.setVisibility(0);
        this.as.setVisibility(8);
        this.O.setText(this.at.getResources().getString(R.string.payment_failed_wallet));
        this.O.setTextColor(androidx.core.content.b.c(this.at, R.color.color_fd5c5c));
        this.U.setVisibility(0);
        if (!TextUtils.isEmpty(gVar.f55801c.getAlertMessage())) {
            this.U.setText(gVar.f55801c.getAlertMessage());
        } else {
            this.U.setText("Network Error, Please try again.");
        }
        this.aE.setVisibility(8);
    }

    public final void b() {
        this.bq.setVisibility(8);
        this.br.setVisibility(0);
        this.br.a();
    }

    public final void c() {
        RelativeLayout relativeLayout = this.bq;
        if (relativeLayout != null && relativeLayout.getVisibility() == 8) {
            this.br.b();
            this.br.setVisibility(8);
            this.bq.setVisibility(0);
        }
    }

    private void z() {
        if (this.bv) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    if (d.this.getActivity() != null && !d.this.getActivity().isFinishing()) {
                        d.k(d.this);
                        d.this.getActivity().setResult(-1);
                        d.this.getActivity().finish();
                    }
                }
            }, 2000);
        }
    }

    private static String g(String str) {
        try {
            return new SimpleDateFormat("dd MMM yyyy, hh:mm a").format(Long.valueOf(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str).getTime() + 19800000));
        } catch (ParseException unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        Activity activity;
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            p();
            if (iJRPaytmDataModel instanceof CJRObdResponse) {
                CJRObdResponse cJRObdResponse = (CJRObdResponse) iJRPaytmDataModel;
                if (cJRObdResponse.getStatusCode() == null || !cJRObdResponse.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                    String format = String.format(this.at.getResources().getString(R.string.could_not_initiate), new Object[]{this.o});
                    new SpannableString(format).setSpan(new ForegroundColorSpan(getResources().getColor(R.color.brownish_grey)), 0, format.length(), 33);
                    return;
                }
                this.ae.removeCallbacks(this.bi);
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR && (activity = this.at) != null && !activity.isFinishing() && isResumed()) {
            p();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, net.one97.paytm.network.f fVar) {
        Long l2;
        final String str3 = str;
        final String str4 = str2;
        net.one97.paytm.network.f fVar2 = fVar;
        if (fVar2.f55796a == net.one97.paytm.network.h.SUCCESS) {
            CJRMerchantTransactionStatusResponse cJRMerchantTransactionStatusResponse = (CJRMerchantTransactionStatusResponse) fVar2.f55797b;
            if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getPRN())) {
                this.x = cJRMerchantTransactionStatusResponse.getResponse().getPRN();
                f();
            }
            if (cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equals("TXN_SUCCESS")) {
                this.aF.setVisibility(8);
                this.O.setText(this.at.getResources().getString(R.string.paid_successfully_to));
                this.O.setTextColor(androidx.core.content.b.c(this.at, R.color.black));
                this.U.setVisibility(8);
                this.A.setVisibility(0);
                this.as.setVisibility(8);
                this.aL.c();
                if (!(cJRMerchantTransactionStatusResponse.getResponse() == null || TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getPAYMENTMODE()) || this.n == null)) {
                    if (cJRMerchantTransactionStatusResponse.getResponse().getPAYMENTMODE().equals("UPI")) {
                        f("UPI");
                    } else {
                        f("IMPS");
                    }
                }
                if (this.aI && this.aK.doubleValue() > 0.0d) {
                    this.W.setText(String.format(this.at.getString(R.string.pcf_charged_message), new Object[]{this.aK.toString()}));
                    this.W.setVisibility(0);
                }
                c("success");
                h();
                this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.payment_done_00048));
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                    a("offline_payments", "post_payment_success_shown", "flow_through_scan_icon", getContext(), "home/pay-send/payment-success");
                } else {
                    a("offline_payments", "post_payment_success_shown", "flow_through_pay_icon", getContext(), "home/pay-send/payment-success");
                }
                g();
                if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getTXNID())) {
                    b(cJRMerchantTransactionStatusResponse.getResponse().getTXNID(), (String) null);
                }
                this.aE.setVisibility(0);
            } else if (cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equalsIgnoreCase("FAILED") || cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equalsIgnoreCase("TXN_FAILURE")) {
                this.aF.setVisibility(8);
                this.A.setVisibility(0);
                this.as.setVisibility(8);
                this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.ic_failed));
                this.O.setText(this.at.getResources().getString(R.string.payment_failed_wallet));
                this.O.setTextColor(androidx.core.content.b.c(this.at, R.color.color_fd5c5c));
                this.U.setVisibility(0);
                if (cJRMerchantTransactionStatusResponse.getResponse().getRESPCODE().equals("334")) {
                    this.U.setText(this.at.getResources().getString(R.string.orderId_is_invalid_msg));
                } else if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getRESPMSG())) {
                    this.U.setText(cJRMerchantTransactionStatusResponse.getResponse().getRESPMSG());
                } else {
                    this.U.setText(this.at.getResources().getString(R.string.msg_post_payment_failed_msg));
                }
                this.U.setBackgroundColor(androidx.core.content.b.c(this.at, R.color.color_fdfbd3));
                c(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                e(cJRMerchantTransactionStatusResponse.getResponse().getRESPCODE());
            } else {
                String txnamount = cJRMerchantTransactionStatusResponse.getResponse().getTXNAMOUNT();
                if (!TextUtils.isEmpty(txnamount)) {
                    txnamount = new BigDecimal(txnamount).stripTrailingZeros().toPlainString();
                } else if (!TextUtils.isEmpty(this.q)) {
                    txnamount = new BigDecimal(this.q).stripTrailingZeros().toPlainString();
                }
                String str5 = txnamount;
                Long.valueOf(System.currentTimeMillis());
                try {
                    l2 = Long.valueOf(new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(cJRMerchantTransactionStatusResponse.getResponse().getTXNDATE()).getTime()).getTime());
                } catch (Exception unused) {
                    l2 = Long.valueOf(System.currentTimeMillis());
                }
                this.bw = new ChatPaymentIntegrationResponseModel(cJRMerchantTransactionStatusResponse.getResponse().getSTATUS(), this.bx, (String) null, this.by, (String) null, str5, l2.longValue(), cJRMerchantTransactionStatusResponse.getResponse().getSTATUS(), cJRMerchantTransactionStatusResponse.getResponse().getORDERID(), cJRMerchantTransactionStatusResponse.getResponse().getTXNID(), (String) null, cJRMerchantTransactionStatusResponse.getResponse().getRESPMSG());
                z();
                if (f51073h > 5) {
                    this.aF.setVisibility(8);
                    this.A.setVisibility(0);
                    this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.pending));
                    c(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING);
                    if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getRESPMSG())) {
                        this.U.setText(cJRMerchantTransactionStatusResponse.getResponse().getRESPMSG());
                        return;
                    }
                    return;
                }
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        d.this.a(str3, str4);
                    }
                }, (long) f51071f);
            }
        } else if (fVar2.f55796a == net.one97.paytm.network.h.ERROR && fVar2.f55798c.f55801c.mErrorType.equals(NetworkCustomError.ErrorType.TimeOutError)) {
            if (f51073h > 5) {
                this.aF.setVisibility(8);
                this.A.setVisibility(0);
                this.A.setBackground(androidx.core.content.b.a((Context) this.at, R.drawable.pending));
                c(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING);
                return;
            }
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    d.this.a(str3, str4);
                }
            }, (long) f51071f);
        }
    }

    static /* synthetic */ boolean d(d dVar) {
        com.paytm.b.a.a a2 = be.a(dVar.at.getApplicationContext());
        int i2 = a2.b("rating", 0, true) == 0 ? 1 : 0;
        a2.a("rating", i2, true);
        return i2 == 0;
    }

    static /* synthetic */ void a(d dVar, MerchantPPReviewData merchantPPReviewData) {
        if (dVar.getChildFragmentManager() != null && dVar.isResumed() && merchantPPReviewData != null) {
            b.a aVar = net.one97.paytm.wallet.rateMerchant.b.f71619a;
            b.a.a(dVar.o, merchantPPReviewData).show(dVar.getChildFragmentManager(), "PostTxnFeedbackFragment");
        }
    }

    static /* synthetic */ void k(d dVar) {
        Intent intent = new Intent("chat-pay-broadcast-receiver-callback");
        intent.putExtra("chat_txn_response", dVar.bw);
        androidx.localbroadcastmanager.a.a.a((Context) dVar.getActivity()).a(intent);
    }
}
