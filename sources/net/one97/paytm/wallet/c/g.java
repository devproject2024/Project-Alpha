package net.one97.paytm.wallet.c;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.core.h.u;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.toolbox.NetworkImageView;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import com.sendbird.android.constant.StringSet;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.cashback.posttxn.e;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponse;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.paymentsbank.CJRAccountSummary;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.postpaid.CJRPPAccount;
import net.one97.paytm.common.entity.postpaid.CJRPPUserProfileKycTnc;
import net.one97.paytm.common.entity.replacement.CJRReplacementReason;
import net.one97.paytm.common.entity.showCode.ShowCodePushModel;
import net.one97.paytm.common.entity.wallet.CJRCashWallet;
import net.one97.paytm.common.entity.wallet.CJRIMPSInitiateDataModel;
import net.one97.paytm.common.entity.wallet.CJRNobleInitiative;
import net.one97.paytm.common.entity.wallet.CJRObdResponse;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.CJRSendMoney;
import net.one97.paytm.common.entity.wallet.CJRSendMoneyResponse;
import net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel;
import net.one97.paytm.common.entity.wallet.CJRValidateTransaction;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.common.widgets.DotProgressBar;
import net.one97.paytm.common.widgets.a.a;
import net.one97.paytm.common.widgets.c;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.h;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.hometabs.HomeTabItem;
import net.one97.paytm.m;
import net.one97.paytm.moneytransfer.utils.CircularProgressBar;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;
import net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse;
import net.one97.paytm.p2mNewDesign.f.k;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.splitbill.SBMarkAsPaid;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.ai;
import net.one97.paytm.utils.bf;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.b.b;
import net.one97.paytm.wallet.d.j;
import net.one97.paytm.wallet.d.k;
import net.one97.paytm.wallet.f.i;
import net.one97.paytm.wallet.f.l;
import net.one97.paytm.wallet.newdesign.activity.AJRTrustSeal;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;
import net.one97.paytm.wallet.rateMerchant.RateMerchantHelper;
import net.one97.paytm.wallet.rateMerchant.b;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData;
import net.one97.paytm.wallet.views.CircleImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends h implements View.OnClickListener, b, a, m, b.a<Integer>, l {
    /* access modifiers changed from: private */
    public static int q = 5000;
    private static int r = 15;
    /* access modifiers changed from: private */
    public static int s;
    /* access modifiers changed from: private */
    public Bundle A;
    /* access modifiers changed from: private */
    public String B;
    private String C;
    private String D;
    private String E;
    /* access modifiers changed from: private */
    public TextView F;
    private TextView G;
    private int H = 1;
    /* access modifiers changed from: private */
    public boolean I;
    private TextView J;
    private String K;
    private String L;
    private String M;
    private Dialog N;
    private TextView O;
    private ImageView P;
    private TextView Q;
    private String R;
    /* access modifiers changed from: private */
    public String S;
    private String T;
    private String U;
    /* access modifiers changed from: private */
    public TextView V;
    private TextView W;
    private View X;
    /* access modifiers changed from: private */
    public ImageView Y;
    private CJRNobleInitiative Z;

    /* renamed from: a  reason: collision with root package name */
    double f70015a;
    private RelativeLayout aA;
    private RelativeLayout aB;
    private TextView aC;
    private TextView aD;
    private TextView aE;
    /* access modifiers changed from: private */
    public Boolean aF = Boolean.FALSE;
    /* access modifiers changed from: private */
    public TextView aG;
    /* access modifiers changed from: private */
    public TextView aH;
    private TextView aI;
    private TextView aJ;
    private TextView aK;
    private TextView aL;
    private TextView aM;
    private View aN;
    private View aO;
    private View aP;
    private ImageView aQ;
    private ImageView aR;
    private LinearLayout aS;
    /* access modifiers changed from: private */
    public boolean aT;
    private RelativeLayout aU;
    private ImageView aV;
    private TextView aW;
    /* access modifiers changed from: private */
    public TextView aX;
    private TextView aY;
    private TextView aZ;
    private NetworkImageView aa;
    /* access modifiers changed from: private */
    public RecyclerView ab;
    private Integer ac;
    private RelativeLayout ad;
    private CJRQRScanResultModel ae;
    /* access modifiers changed from: private */
    public RelativeLayout af;
    /* access modifiers changed from: private */
    public RelativeLayout ag;
    /* access modifiers changed from: private */
    public TextView ah;
    private TextView ai;
    /* access modifiers changed from: private */
    public View aj;
    /* access modifiers changed from: private */
    public RelativeLayout ak;
    private TextView al;
    private String am;
    private RelativeLayout an;
    private TextView ao;
    private RelativeLayout ap;
    private RelativeLayout aq;
    private TextView ar;
    private TextView as;
    private TextView at;
    private RelativeLayout au;
    private View av;
    private LinearLayout aw;
    private View ax;
    private DotProgressBar ay;
    private RelativeLayout az;

    /* renamed from: b  reason: collision with root package name */
    ImageView f70016b;
    private TextView bA;
    private TextView bB;
    private TextView bC;
    private String bD;
    private LinearLayout bE;
    private TextView bF;
    private boolean bG;
    private double bH;
    private String bI;
    private BaseUpiResponse bJ;
    private boolean bK;
    /* access modifiers changed from: private */
    public boolean bL;
    private boolean bM;
    private TextView bN;
    private boolean bO;
    private String bP;
    /* access modifiers changed from: private */
    public String bQ;
    private ProgressDialog bR;
    /* access modifiers changed from: private */
    public String bS;
    /* access modifiers changed from: private */
    public LottieAnimationView bT;
    /* access modifiers changed from: private */
    public Activity bU;
    private boolean bV;
    private RelativeLayout bW;
    private RelativeLayout bX;
    private RelativeLayout bY;
    private boolean bZ;
    private TextView ba;
    private TextView bb;
    private TextView bc;
    /* access modifiers changed from: private */
    public TextView bd;
    private TextView be;
    /* access modifiers changed from: private */
    public TextView bf;
    private boolean bg;
    private boolean bh;
    private boolean bi;
    private String bj;
    private RelativeLayout bk;
    private HomeTabItem[] bl;
    private HashMap<String, View> bm = new HashMap<>();
    /* access modifiers changed from: private */
    public boolean bn = true;
    /* access modifiers changed from: private */
    public Handler bo;
    private boolean bp = false;
    private Bundle bq = null;
    private CircleImageView br;
    private RelativeLayout bs;
    private int bt = -1;
    private TextView bu;
    private TextView bv;
    private View bw;
    private TextView bx;
    private TextView by;
    private TextView bz;

    /* renamed from: c  reason: collision with root package name */
    ImageView f70017c;
    private String cA;
    private boolean cB;
    private String cC;
    private boolean cD;
    private String cE;
    private String cF;
    private boolean cG;
    private View.OnClickListener cH = new View.OnClickListener() {
        public final void onClick(View view) {
            if (!view.isSelected()) {
                Object tag = view.getTag();
                if (tag instanceof HomeTabItem) {
                    g.a(g.this, ((HomeTabItem) tag).getUrlType());
                } else {
                    q.c();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public Runnable cI = new Runnable() {
        public final void run() {
            boolean unused = g.this.bn = false;
            String string = (g.this.getActivity() == null || !g.this.isAdded()) ? "" : g.this.getResources().getString(R.string.need_help_p2p);
            StringBuilder sb = new StringBuilder("<span dir=\"ltr\"><font color =\"#00baf2\"><a href=\"");
            sb.append("tel:2125551212");
            sb.append("\">");
            sb.append(string);
            sb.append("</a></font></span>");
        }
    };
    private e ca;
    private RelativeLayout cb;
    private RelativeLayout cc;
    private String cd;
    private String ce = "₹ ";
    private String cf;
    private ViewGroup cg;
    private RelativeLayout ch;
    private RelativeLayout ci;
    private LinearLayout cj;
    /* access modifiers changed from: private */
    public CircularProgressBar ck;
    private c cl = null;
    private String cm;
    private boolean cn;
    /* access modifiers changed from: private */
    public boolean co;
    private String cp;
    /* access modifiers changed from: private */
    public Double cq;
    /* access modifiers changed from: private */
    public k cr;
    private h cs;
    private boolean ct = false;
    private boolean cu = false;
    private String cv;
    private String cw;
    private String cx;
    private String cy;
    private TextView cz;

    /* renamed from: d  reason: collision with root package name */
    TextView f70018d;

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.wallet.d.h f70019e;

    /* renamed from: f  reason: collision with root package name */
    TextView f70020f;

    /* renamed from: g  reason: collision with root package name */
    TextView f70021g;

    /* renamed from: h  reason: collision with root package name */
    TextView f70022h;

    /* renamed from: i  reason: collision with root package name */
    String f70023i;
    public net.one97.paytm.wallet.b.b<Integer> j;
    public Button k;
    public Integer l;
    public LinearLayout m;
    public boolean n = false;
    public int o = 0;
    com.paytm.network.a p;
    private String t;
    private String u;
    private String v;
    private TextView w;
    private IJRDataModel x;
    private String y;
    private boolean z = false;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public final /* synthetic */ void a(Object obj, int i2) {
        Integer num = (Integer) obj;
        this.aj.setVisibility(0);
        this.ac = num;
        this.bt = i2;
        this.k.setVisibility(0);
        this.k.setText(this.bU.getResources().getString(R.string.cart_proceed_to_pay, new Object[]{String.valueOf(num)}));
    }

    public static Fragment a(IJRDataModel iJRDataModel, String str, String str2, String str3, boolean z2, String str4, String str5, String str6, String str7, double d2, String str8, String str9, String str10, boolean z3, boolean z4, String str11) {
        Bundle bundle = new Bundle();
        IJRDataModel iJRDataModel2 = iJRDataModel;
        bundle.putSerializable("data", iJRDataModel);
        bundle.putString("phone_no", str9);
        String str12 = str;
        bundle.putString("name", str);
        String str13 = str2;
        bundle.putString("amount", str2);
        String str14 = str3;
        bundle.putString(CJRQRScanResultModel.KEY_COMMENT_SMALL, str3);
        boolean z5 = z2;
        bundle.putBoolean("isP2B", z2);
        String str15 = str4;
        bundle.putString(PayUtility.ACCOUNT_NUMBER, str4);
        double d3 = d2;
        bundle.putDouble("txn fee", d2);
        String str16 = str5;
        bundle.putString("paymentMode", str5);
        String str17 = str6;
        bundle.putString("paymentType", str6);
        String str18 = str7;
        bundle.putString("tagline", str7);
        bundle.putString(PayUtility.BANK_NAME, str10);
        String str19 = str8;
        bundle.putString("key_via", str8);
        bundle.putBoolean("is_upi", z3);
        bundle.putBoolean("is_deeplinked", z4);
        bundle.putString("ref_id", str11);
        g gVar = new g();
        gVar.setArguments(bundle);
        return gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d A[Catch:{ Exception -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0093 A[Catch:{ Exception -> 0x00ac }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r10, android.widget.TextView r11) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            r2 = 1
            r11.setTypeface(r1, r2)
            android.graphics.Typeface r3 = r11.getTypeface()     // Catch:{ Exception -> 0x00ac }
            if (r3 == 0) goto L_0x0016
            android.graphics.Typeface r3 = r11.getTypeface()     // Catch:{ Exception -> 0x00ac }
            if (r3 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r3 = r1
            goto L_0x001c
        L_0x0016:
            java.lang.String r3 = "sans-serif-medium"
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r2)     // Catch:{ Exception -> 0x00ac }
        L_0x001c:
            android.graphics.Typeface r4 = r11.getTypeface()     // Catch:{ Exception -> 0x00ac }
            r5 = 0
            if (r4 == 0) goto L_0x0029
            android.graphics.Typeface r4 = r11.getTypeface()     // Catch:{ Exception -> 0x00ac }
            if (r4 == 0) goto L_0x002f
        L_0x0029:
            java.lang.String r1 = "sans-serif-light"
            android.graphics.Typeface r1 = android.graphics.Typeface.create(r1, r5)     // Catch:{ Exception -> 0x00ac }
        L_0x002f:
            java.lang.String r4 = ": "
            int r4 = r10.indexOf(r4)     // Catch:{ Exception -> 0x00ac }
            int r4 = r4 + 10
            int r6 = r10.length()     // Catch:{ Exception -> 0x00ac }
            if (r4 < r6) goto L_0x0040
            r11.setText(r10)     // Catch:{ Exception -> 0x00ac }
        L_0x0040:
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x00ac }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ac }
            r7.<init>()     // Catch:{ Exception -> 0x00ac }
            java.lang.String r8 = r10.substring(r5, r4)     // Catch:{ Exception -> 0x00ac }
            r7.append(r8)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r8 = "  "
            r7.append(r8)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00ac }
            r6[r5] = r7     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = r10.substring(r4)     // Catch:{ Exception -> 0x00ac }
            r6[r2] = r4     // Catch:{ Exception -> 0x00ac }
            r4 = r6[r5]     // Catch:{ Exception -> 0x00ac }
            int r4 = r4.length()     // Catch:{ Exception -> 0x00ac }
            r10.length()     // Catch:{ Exception -> 0x00ac }
            android.text.SpannableStringBuilder r7 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x00ac }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ac }
            r8.<init>()     // Catch:{ Exception -> 0x00ac }
            r9 = r6[r5]     // Catch:{ Exception -> 0x00ac }
            r8.append(r9)     // Catch:{ Exception -> 0x00ac }
            r9 = r6[r2]     // Catch:{ Exception -> 0x00ac }
            r8.append(r9)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00ac }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00ac }
            com.paytm.utility.CustomTypefaceSpan r8 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x00ac }
            r8.<init>(r0, r1)     // Catch:{ Exception -> 0x00ac }
            r1 = 34
            r7.setSpan(r8, r5, r4, r1)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r8 = "."
            boolean r10 = r10.contains(r8)     // Catch:{ Exception -> 0x00ac }
            if (r10 == 0) goto L_0x00a8
            com.paytm.utility.CustomTypefaceSpan r10 = new com.paytm.utility.CustomTypefaceSpan     // Catch:{ Exception -> 0x00ac }
            r10.<init>(r0, r3)     // Catch:{ Exception -> 0x00ac }
            r0 = r6[r5]     // Catch:{ Exception -> 0x00ac }
            int r0 = r0.length()     // Catch:{ Exception -> 0x00ac }
            r2 = r6[r2]     // Catch:{ Exception -> 0x00ac }
            int r2 = r2.length()     // Catch:{ Exception -> 0x00ac }
            int r0 = r0 + r2
            r7.setSpan(r10, r4, r0, r1)     // Catch:{ Exception -> 0x00ac }
        L_0x00a8:
            r11.setText(r7)     // Catch:{ Exception -> 0x00ac }
            return
        L_0x00ac:
            r10 = move-exception
            java.lang.String r10 = r10.getMessage()
            com.paytm.utility.q.b(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.c.g.a(java.lang.String, android.widget.TextView):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.x = (IJRDataModel) arguments.getSerializable("data");
            Activity activity = this.bU;
            this.B = arguments.getString("name", activity == null ? "Receiver" : activity.getString(R.string.receiver_name));
            this.D = arguments.getString("amount");
            this.C = arguments.getString(CJRQRScanResultModel.KEY_COMMENT_SMALL);
            this.I = arguments.getBoolean("isP2B");
            this.T = arguments.getString("phone_no");
            this.E = arguments.getString(PayUtility.ACCOUNT_NUMBER);
            this.K = arguments.getString("paymentType");
            this.L = arguments.getString("paymentMode");
            this.f70015a = arguments.getDouble("txn fee", 0.0d);
            this.M = arguments.getString("tagline");
            this.am = arguments.getString("key_via");
            this.U = arguments.getString(PayUtility.BANK_NAME);
            this.bK = arguments.getBoolean("is_upi");
            this.bL = arguments.getBoolean("isFromPassbook");
            this.bO = arguments.getBoolean("is_deeplinked");
            this.bP = arguments.getString("ref_id");
            this.y = arguments.getString("pay_response");
            this.z = arguments.getBoolean("is_from_mobile_number");
            this.A = arguments.getBundle("sbBundle");
            this.ct = arguments.getBoolean("is_static_qr_code");
            this.cv = arguments.getString("pay_mode", (String) null);
            this.cw = arguments.getString("unique_identifier", "");
            this.cx = getArguments().getString("mid");
            this.cy = getArguments().getString("scan_result");
            this.cu = getArguments().getBoolean("is_link_based_payment");
            this.bV = arguments.getBoolean("is_postpaid");
            this.bG = arguments.getBoolean("is_ppb_transaction", false);
            this.bM = arguments.getBoolean("is_card_transaction", false);
            this.bZ = arguments.getBoolean("is_net_banking_transaction", false);
            this.cd = arguments.getString("merchant_logo");
            this.cf = arguments.getString("tran_time");
            this.cm = arguments.getString("additonal_info");
            this.cn = arguments.getBoolean("is_emi", false);
            this.cp = arguments.getString("emi_message");
            this.cB = arguments.getBoolean("is_from_recent", false);
            this.cA = arguments.getString("qrScanTime", "");
            this.cC = arguments.getString("suggestedInstrument", "");
            this.cD = arguments.getBoolean("isSingleAPI", false);
            this.cF = arguments.getString("page_load_time", "");
            this.cE = arguments.getString("page_load_type", "");
            this.cG = arguments.getBoolean("is_amt_already_present", false);
            this.co = arguments.getBoolean("is_pcf", false);
            this.cq = Double.valueOf(arguments.getDouble("pcf_amount", 0.0d));
        }
        this.Z = WalletSharedPrefs.INSTANCE.getNobleResponse(this.bU);
        s = 0;
        net.one97.paytm.j.c.a();
        q = net.one97.paytm.j.c.a("KEY_PENDING_MERCHANT_RESPONSEWAITTIME", 0);
        net.one97.paytm.j.c.a();
        r = net.one97.paytm.j.c.a("KEY_PENDING_MERCHANT_RESPONSECOUNT", 0);
        Application application = this.bU.getApplication();
        this.cs = (h) am.a((FragmentActivity) this.bU, (al.b) new i(PaymentInstrumentDatabase.f51202a.a(application), application)).a(h.class);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.bU = (Activity) context;
        this.cr = (k) context;
        if (this.f70019e == null) {
            this.f70019e = new net.one97.paytm.wallet.d.h();
        }
        this.f70019e.a(this.bU, (i) new i() {
            public final void a(String str) {
            }

            public final void a() {
                g.this.m.setEnabled(true);
            }

            public final void b() {
                g.this.V.setEnabled(true);
                g.this.m.setEnabled(true);
            }

            public final void a(IJRDataModel iJRDataModel) {
                g.this.V.setEnabled(true);
                g.this.m.setEnabled(true);
                g.this.af.setVisibility(8);
                g.this.ag.setVisibility(0);
                g gVar = g.this;
                int unused = gVar.o = gVar.l.intValue();
                TextView g2 = g.this.ah;
                g gVar2 = g.this;
                g2.setText(gVar2.getString(R.string.success_amount, gVar2.l));
                if (g.this.k.getVisibility() == 0) {
                    if (g.this.aj.getVisibility() == 0) {
                        g.this.aj.setVisibility(8);
                    }
                    g.this.k.setVisibility(8);
                }
                boolean unused2 = g.this.n = true;
                g.this.s();
            }
        });
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.aa = (NetworkImageView) view.findViewById(R.id.image_view_noble);
        this.aa.setDefaultImageResId(R.drawable.blanckplaceholder);
        CJRNobleInitiative cJRNobleInitiative = this.Z;
        if (cJRNobleInitiative != null && cJRNobleInitiative.response != null && !TextUtils.isEmpty(this.Z.response.imageUrlSmall)) {
            this.aa.setImageUrl(this.Z.response.imageUrlSmall, ai.INSTANCE.getImageLoader());
        }
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [net.one97.paytm.wallet.b.b$a, android.view.View$OnClickListener, net.one97.paytm.wallet.c.g] */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        Activity activity;
        View inflate = layoutInflater.inflate(R.layout.post_payment_fragment, viewGroup, false);
        if (bundle != null && this.bq == null) {
            this.bq = bundle.getBundle("saved_state");
        }
        Bundle bundle2 = this.bq;
        if (bundle2 != null) {
            this.bp = bundle2.getBoolean("is_back_shown");
        }
        String str2 = null;
        this.bq = null;
        this.f70021g = (TextView) inflate.findViewById(R.id.tv_prn_label);
        this.f70022h = (TextView) inflate.findViewById(R.id.tv_prn_message);
        this.bT = (LottieAnimationView) inflate.findViewById(R.id.top_success_anim_view);
        this.bT.setAnimation("payment-success.json");
        this.bT.loop(true);
        this.f70020f = (TextView) inflate.findViewById(R.id.noble_title);
        this.Y = (ImageView) inflate.findViewById(R.id.top_success_view);
        this.av = inflate.findViewById(R.id.lyt_bottom_tab_bar);
        this.w = (TextView) inflate.findViewById(R.id.text_merchant_name);
        this.at = (TextView) inflate.findViewById(R.id.user_initials);
        this.G = (TextView) inflate.findViewById(R.id.transaction_amount_success);
        this.ck = (CircularProgressBar) inflate.findViewById(R.id.pb_pendingg);
        this.J = (TextView) inflate.findViewById(R.id.add_money_layout);
        this.bX = (RelativeLayout) inflate.findViewById(R.id.parent_layout);
        this.br = (CircleImageView) inflate.findViewById(R.id.img_user);
        this.au = (RelativeLayout) inflate.findViewById(R.id.merchant_logo);
        this.Q = (TextView) inflate.findViewById(R.id.need_help_contact_us);
        this.X = inflate;
        this.f70018d = (TextView) inflate.findViewById(R.id.money_paid_p2b);
        this.O = (TextView) inflate.findViewById(R.id.txt_tagline);
        this.W = (TextView) inflate.findViewById(R.id.time_txn_value_textview);
        this.al = (TextView) inflate.findViewById(R.id.logout);
        this.ap = (RelativeLayout) inflate.findViewById(R.id.passbook_view);
        this.aq = (RelativeLayout) inflate.findViewById(R.id.split_bill_view);
        this.aw = (LinearLayout) inflate.findViewById(R.id.txn_parent);
        this.ar = (TextView) inflate.findViewById(R.id.payment_complete_txn_id);
        this.as = (TextView) inflate.findViewById(R.id.payment_complete_txn_id_lbl);
        this.bB = (TextView) inflate.findViewById(R.id.payment_complete_comment);
        this.af = (RelativeLayout) inflate.findViewById(R.id.contribute_layout);
        this.f70016b = (ImageView) inflate.findViewById(R.id.fragment_show_code_iv_barcode);
        this.f70017c = (ImageView) inflate.findViewById(R.id.iv_back_button);
        this.f70017c.setOnClickListener(this);
        this.ak = (RelativeLayout) inflate.findViewById(R.id.linear_layout_balance);
        this.ag = (RelativeLayout) inflate.findViewById(R.id.contribute_layout_success);
        this.m = (LinearLayout) inflate.findViewById(R.id.parent_layout_bottom);
        this.P = (ImageView) inflate.findViewById(R.id.share_layout);
        this.aa = (NetworkImageView) inflate.findViewById(R.id.image_view_noble);
        this.V = (TextView) inflate.findViewById(R.id.noble_km);
        this.ab = (RecyclerView) inflate.findViewById(R.id.recycler_slabs_test);
        this.k = (Button) inflate.findViewById(R.id.id_proceed_to_pay);
        this.ad = (RelativeLayout) inflate.findViewById(R.id.parent_noble);
        this.ao = (TextView) inflate.findViewById(R.id.text_otp);
        this.ah = (TextView) inflate.findViewById(R.id.noble_success);
        this.ai = (TextView) inflate.findViewById(R.id.noble_desc);
        this.aj = inflate.findViewById(R.id.blank_space);
        this.ax = inflate.findViewById(R.id.blank_space_contact_us);
        this.ay = (DotProgressBar) inflate.findViewById(R.id.dot_progress_bar);
        this.ax.setVisibility(8);
        this.aj.setVisibility(8);
        this.an = (RelativeLayout) inflate.findViewById(R.id.nobel_initiative_layout);
        this.az = (RelativeLayout) inflate.findViewById(R.id.add_money_view);
        this.aA = (RelativeLayout) inflate.findViewById(R.id.passbook_view);
        this.aB = (RelativeLayout) inflate.findViewById(R.id.contact_us_view);
        this.aC = (TextView) inflate.findViewById(R.id.paid_successfully_to);
        this.aE = (TextView) inflate.findViewById(R.id.text_account_number);
        this.aD = (TextView) inflate.findViewById(R.id.text_account_label);
        this.aG = (TextView) inflate.findViewById(R.id.av_balance_label);
        this.F = (TextView) inflate.findViewById(R.id.updated_balance_value);
        this.aH = (TextView) inflate.findViewById(R.id.tv_bank_status);
        this.aP = inflate.findViewById(R.id.payment_complete_txn_id_layout);
        this.aG.setVisibility(4);
        this.F.setVisibility(4);
        this.as.setVisibility(8);
        this.as.setText(this.bU.getString(R.string.wallet_txn_id, new Object[]{""}));
        this.aI = (TextView) inflate.findViewById(R.id.money_sent_to_name_value);
        this.bu = (TextView) inflate.findViewById(R.id.money_sent_to_name_label);
        this.aK = (TextView) inflate.findViewById(R.id.account_no_name_value);
        this.bv = (TextView) inflate.findViewById(R.id.account_no_name_label);
        this.bw = inflate.findViewById(R.id.how_it_works_layout);
        this.bw.setVisibility(8);
        this.aO = inflate.findViewById(R.id.bank_status_layout);
        this.aO.setVisibility(8);
        this.aQ = (ImageView) inflate.findViewById(R.id.image_bank);
        this.aR = (ImageView) inflate.findViewById(R.id.image_bank_acc);
        this.bx = (TextView) inflate.findViewById(R.id.amount_deducted_value);
        this.by = (TextView) inflate.findViewById(R.id.amount_deducted_timestamp);
        this.aJ = (TextView) inflate.findViewById(R.id.your_bank);
        this.bz = (TextView) inflate.findViewById(R.id.bank_deducted_value);
        this.aL = (TextView) inflate.findViewById(R.id.request_accepted);
        this.bA = (TextView) inflate.findViewById(R.id.payment_failed_text_view);
        this.cb = (RelativeLayout) inflate.findViewById(R.id.rl_offline_post_payment_top_layout);
        this.cc = (RelativeLayout) inflate.findViewById(R.id.parent_donate_first);
        this.cg = (ViewGroup) inflate.findViewById(R.id.cashback_offers_view);
        this.ch = (RelativeLayout) inflate.findViewById(R.id.repeat_payment_view);
        this.ch.setVisibility(8);
        this.cz = (TextView) inflate.findViewById(R.id.pass_book_layout);
        if (this.B != null) {
            this.cz.setText("Pay Again at " + this.B);
        }
        this.ci = (RelativeLayout) inflate.findViewById(R.id.resend_confirmation_payment);
        this.aX = (TextView) this.cb.findViewById(R.id.tv_offline_status_msg);
        this.bd = (TextView) this.cb.findViewById(R.id.tv_offline_status_msg_desc);
        this.bc = (TextView) this.cb.findViewById(R.id.tv_merchant_name);
        this.ba = (TextView) this.cb.findViewById(R.id.tv_date);
        this.aY = (TextView) this.cb.findViewById(R.id.tv_amount);
        this.aZ = (TextView) this.cb.findViewById(R.id.tv_amount_fractional);
        this.bb = (TextView) this.cb.findViewById(R.id.tv_order_id);
        this.bf = (TextView) this.cb.findViewById(R.id.tv_pay_mode);
        this.aU = (RelativeLayout) this.cb.findViewById(R.id.rl_merchant_logo);
        this.aU.bringToFront();
        this.aV = (ImageView) this.aU.findViewById(R.id.iv_merchant_logo);
        this.aW = (TextView) this.X.findViewById(R.id.tv_share);
        this.be = (TextView) this.cb.findViewById(R.id.payment_complete_comment);
        this.bk = (RelativeLayout) this.cb.findViewById(R.id.rl_txn_count);
        if ((getArguments() == null || !getArguments().getBoolean("is_offline_pg", false)) && !(this.x instanceof CJRSendMoneyToMerchantResponseModel)) {
            this.aW.setVisibility(8);
            this.P.setVisibility(0);
            this.cb.setVisibility(8);
            this.cc.setVisibility(0);
            inflate.findViewById(R.id.motif_right_imv).setVisibility(8);
            u.g(inflate.findViewById(R.id.toolbar), (float) com.paytm.utility.a.a(1));
        } else {
            this.Y = (ImageView) this.cb.findViewById(R.id.top_success_view);
            this.bT = (LottieAnimationView) this.cb.findViewById(R.id.top_success_anim_view);
            this.bT.setAnimation("payment-success.json");
            this.bT.loop(true);
            if (!TextUtils.isEmpty(this.C)) {
                this.be.setText("\" " + this.C + " \"");
                this.be.setVisibility(0);
            }
            this.aW.setVisibility(0);
            this.aW.setOnClickListener(this);
            this.P.setVisibility(8);
            this.cb.setVisibility(0);
            this.cc.setVisibility(8);
            inflate.findViewById(R.id.motif_right_imv).setVisibility(0);
            u.g(inflate.findViewById(R.id.toolbar), 0.0f);
            inflate.findViewById(R.id.motif_right_imv).setVisibility(0);
        }
        this.bA.setVisibility(8);
        this.bW = (RelativeLayout) inflate.findViewById(R.id.add_money_view);
        this.bY = (RelativeLayout) inflate.findViewById(R.id.wallet_balance_rl);
        this.aM = (TextView) inflate.findViewById(R.id.amount_deducted_text_view);
        this.bF = (TextView) inflate.findViewById(R.id.your_paytm_wallet);
        this.aN = inflate.findViewById(R.id.view_divider_new);
        this.bN = (TextView) inflate.findViewById(R.id.payment_complete_imps_ref_lbl);
        this.aS = (LinearLayout) inflate.findViewById(R.id.contact_trust_layout);
        this.cj = (LinearLayout) inflate.findViewById(R.id.rate_store_layout);
        this.bC = (TextView) inflate.findViewById(R.id.payment_complete_imps_ref_no);
        this.bE = (LinearLayout) inflate.findViewById(R.id.payment_complete_imps_ref_no_lyt);
        if (getArguments().getBoolean("is_offline_pg", false)) {
            this.Y.setVisibility(8);
            this.bT.setVisibility(8);
        } else {
            m();
        }
        this.Q.setText(Html.fromHtml(this.bU.getResources().getString(R.string.need_help_contact_us)));
        this.k.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.al.setOnClickListener(this);
        this.k.setVisibility(8);
        this.az.setOnClickListener(this);
        this.aA.setOnClickListener(this);
        this.aB.setOnClickListener(this);
        this.aS.setOnClickListener(this);
        this.aq.setOnClickListener(this);
        this.ch.setOnClickListener(this);
        this.ci.setOnClickListener(this);
        if (!this.bL) {
            a(inflate);
        }
        this.bo = new Handler();
        this.bo.postDelayed(this.cI, 180000);
        this.br.setVisibility(8);
        this.bs = (RelativeLayout) inflate.findViewById(R.id.lyt_round_corner);
        int t2 = (int) (((float) com.paytm.utility.a.t(this.bU)) * 3.0f);
        this.bs.getLayoutParams().width = t2;
        this.bs.getLayoutParams().height = t2;
        this.br.setBackgroundColor(Color.parseColor("#ededed"));
        if (!TextUtils.isEmpty(this.B) && !TextUtils.isEmpty(this.B.trim()) && (Character.isLetter(this.B.charAt(0)) || Character.isDigit(this.B.charAt(0)))) {
            this.at.setText(this.B.trim().substring(0, 1).toUpperCase());
            this.at.setTextColor(Color.parseColor("#969696"));
            this.at.bringToFront();
        }
        CJRNobleInitiative cJRNobleInitiative = this.Z;
        if (!(cJRNobleInitiative == null || cJRNobleInitiative.response == null)) {
            this.ai.setText(this.Z.response.description);
            if (!TextUtils.isEmpty(this.Z.response.heading)) {
                this.f70020f.setText(this.Z.response.heading);
            }
        }
        this.au.setVisibility(8);
        this.f70018d.setVisibility(4);
        this.aE.setVisibility(8);
        this.aD.setVisibility(8);
        if (this.I) {
            d(CJRPGTransactionRequestUtils.PAYER_BANK_NAME, this.D);
            this.H = 2;
            if (this.f70015a == 0.0d) {
                this.f70018d.setVisibility(4);
            } else {
                this.f70018d.setVisibility(0);
            }
            if (isAdded() && (activity = this.bU) != null) {
                this.f70018d.setText(activity.getResources().getString(R.string.commission, new Object[]{Double.valueOf(this.f70015a)}));
                b(this.D);
                this.aC.setText(this.bU.getString(R.string.transfer_successfully));
                if (!TextUtils.isEmpty(this.E)) {
                    this.aD.setVisibility(0);
                    this.aE.setVisibility(0);
                    this.aE.setText(this.E);
                    this.w.setVisibility(8);
                } else {
                    this.w.setText(this.B);
                }
                IJRDataModel iJRDataModel = this.x;
                if (iJRDataModel instanceof CJRSendMoney) {
                    CJRSendMoneyResponse response = ((CJRSendMoney) iJRDataModel).getResponse();
                    if (response != null && !TextUtils.isEmpty(response.getwalletSysTransactionID())) {
                        CJRSendMoney cJRSendMoney = (CJRSendMoney) this.x;
                        this.t = cJRSendMoney.getResponse().getwalletSysTransactionID();
                        this.bD = cJRSendMoney.getResponse().getBankTransactionId();
                        this.u = cJRSendMoney.getStatusMessage();
                        this.v = cJRSendMoney.getStatus();
                        if (this.bL) {
                            this.f70017c.setVisibility(0);
                            this.ak.setVisibility(8);
                            this.av.setVisibility(8);
                            this.aS.setVisibility(8);
                        }
                        this.as.setText(this.bU.getString(R.string.p2b_wallet_txn_id));
                        this.bN.setText(this.bU.getString(R.string.reference_number_p2b));
                    }
                } else if (iJRDataModel instanceof CJRValidateTransaction) {
                    CJRSendMoneyResponse response2 = ((CJRValidateTransaction) iJRDataModel).getResponse();
                    if (response2 != null && !TextUtils.isEmpty(response2.getwalletSysTransactionID())) {
                        CJRValidateTransaction cJRValidateTransaction = (CJRValidateTransaction) this.x;
                        this.t = cJRValidateTransaction.getResponse().getwalletSysTransactionID();
                        this.bD = cJRValidateTransaction.getResponse().getBankTransactionId();
                        this.u = cJRValidateTransaction.getStatusMessage();
                        this.v = cJRValidateTransaction.getStatus();
                        this.as.setText(this.bU.getString(R.string.p2b_wallet_txn_id));
                        this.bN.setText(this.bU.getString(R.string.reference_number_p2b));
                    }
                } else if (iJRDataModel instanceof CJRIMPSInitiateDataModel) {
                    this.bG = true;
                    CJRIMPSInitiateDataModel cJRIMPSInitiateDataModel = (CJRIMPSInitiateDataModel) iJRDataModel;
                    if (cJRIMPSInitiateDataModel != null && !TextUtils.isEmpty(cJRIMPSInitiateDataModel.getTxn_id())) {
                        this.t = cJRIMPSInitiateDataModel.getTxn_id();
                        this.bD = cJRIMPSInitiateDataModel.getRrn();
                        this.u = cJRIMPSInitiateDataModel.getMessage();
                        this.v = cJRIMPSInitiateDataModel.getmStatus();
                        this.as.setText(this.bU.getString(R.string.transaction_id) + " : ");
                        this.bF.setText(this.bU.getString(R.string.your_saving_account));
                        this.az.setVisibility(8);
                    }
                } else if (iJRDataModel instanceof BaseUpiResponse) {
                    this.bJ = (BaseUpiResponse) iJRDataModel;
                    this.t = this.bJ.getSeqNo();
                    this.bD = this.bJ.getBankRRN();
                    this.u = this.bJ.getMessage();
                    if (this.bJ.isSuccess()) {
                        this.v = "SUCCESS";
                    } else {
                        this.v = "FAILURE";
                    }
                    this.as.setText(this.bU.getResources().getString(R.string.transaction_id) + " : ");
                    this.bF.setText(this.bU.getResources().getString(R.string.your_saving_account));
                    this.az.setVisibility(8);
                    this.aD.setText(this.bU.getResources().getString(R.string.upi_aadhar_number));
                    this.bN.setText(this.bU.getString(R.string.upi_id));
                }
                if (!TextUtils.isEmpty(this.t)) {
                    this.ar.setVisibility(0);
                    this.ar.setText(this.t);
                    this.as.setVisibility(0);
                } else {
                    this.ar.setVisibility(8);
                    this.as.setVisibility(8);
                }
                if (!TextUtils.isEmpty(this.bD)) {
                    this.bC.setText(this.bD);
                    this.bE.setVisibility(0);
                } else {
                    this.bE.setVisibility(4);
                }
                q();
            }
            if (getArguments() != null) {
                str2 = getArguments().getString("p2b_success_message");
                str = getArguments().getString("p2b_pending_message");
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.aL.setText(str2);
            }
            this.aL.setVisibility(0);
            this.ci.setVisibility(8);
            this.aC.setVisibility(8);
            this.w.setVisibility(8);
            this.aD.setVisibility(8);
            this.aE.setVisibility(8);
            this.aM.setVisibility(0);
            this.aM.setText(this.bU.getResources().getString(R.string.amount_deducted_bank_conf_awaited_may_take_3_days_p2b));
            if (!TextUtils.isEmpty(this.E)) {
                this.aK.setVisibility(0);
                this.bv.setVisibility(0);
                this.aK.setText(this.E);
            } else {
                this.aK.setVisibility(8);
                this.bv.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.U)) {
                this.aI.setVisibility(0);
                this.aJ.setVisibility(0);
                this.bu.setVisibility(0);
                this.aI.setText(this.U);
                this.aJ.setText(this.U);
            } else {
                this.aI.setVisibility(8);
                this.aJ.setVisibility(8);
                this.bu.setVisibility(8);
            }
            this.bw.setVisibility(0);
            this.aO.setVisibility(0);
            if (!TextUtils.isEmpty(this.D)) {
                this.bx.setVisibility(0);
                this.bz.setVisibility(0);
                if (!this.bG) {
                    this.bx.setText(this.bU.getString(R.string.amount_deducted_value, new Object[]{this.D}));
                } else {
                    this.bx.setText(this.bU.getString(R.string.amount_deducted_value_sa, new Object[]{this.D}));
                }
                this.bz.setText(this.bU.getString(R.string.amount_received, new Object[]{this.D}));
            } else {
                this.bx.setVisibility(8);
                this.bz.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.W.getText())) {
                this.by.setVisibility(0);
                this.by.setText(this.W.getText());
            } else {
                this.by.setVisibility(8);
            }
            IJRDataModel iJRDataModel2 = this.x;
            if (iJRDataModel2 instanceof CJRSendMoney) {
                if ("PENDING".equalsIgnoreCase(((CJRSendMoney) iJRDataModel2).getStatus())) {
                    this.aM.setText(this.bU.getResources().getString(R.string.amount_deducted_bank_conf_awaited_may_take_3_days_p2b));
                    this.aF = Boolean.TRUE;
                    this.Y.setVisibility(0);
                    this.bT.setVisibility(8);
                    this.Y.setImageDrawable(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.group_3_copy));
                    if (!TextUtils.isEmpty(str)) {
                        this.aL.setText(str);
                    } else {
                        this.aL.setText(this.bU.getResources().getString(R.string.request_pending));
                    }
                    this.aQ.setVisibility(0);
                    this.aQ.setImageDrawable(getResources().getDrawable(R.drawable.ic_bank_waiting));
                    this.aR.setVisibility(0);
                    this.aR.setImageDrawable(getResources().getDrawable(R.drawable.ic_bank_pending));
                } else if ("FAILURE".equalsIgnoreCase(((CJRSendMoney) this.x).getStatus())) {
                    this.aF = Boolean.TRUE;
                    this.Y.setVisibility(0);
                    this.bT.setVisibility(8);
                    this.Y.setImageDrawable(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.ic_failed));
                    this.aM.setText(this.bU.getResources().getString(R.string.amount_deducted_bank_conf_awaited_may_take_24hrs));
                    this.aL.setText(this.bU.getResources().getString(R.string.failure_bank));
                    this.bA.setVisibility(0);
                    this.bA.setText(((CJRSendMoney) this.x).getStatusMessage());
                    this.f70018d.setVisibility(8);
                    this.aO.setVisibility(0);
                    this.aQ.setVisibility(0);
                    this.aQ.setImageDrawable(getResources().getDrawable(R.drawable.ic_bank_waiting));
                    this.aR.setVisibility(0);
                    this.aR.setImageDrawable(getResources().getDrawable(R.drawable.ic_bank_pending));
                    this.bw.setVisibility(8);
                    this.bu.setText(R.string.bank_name_label);
                }
            } else if (iJRDataModel2 instanceof CJRValidateTransaction) {
                if ("PENDING".equalsIgnoreCase(((CJRValidateTransaction) iJRDataModel2).getStatus())) {
                    this.aF = Boolean.TRUE;
                    this.Y.setVisibility(0);
                    this.bT.setVisibility(8);
                    this.Y.setImageDrawable(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.group_3_copy));
                    this.aL.setVisibility(0);
                    if (!TextUtils.isEmpty(str)) {
                        this.aL.setText(str);
                    } else {
                        this.aL.setText(this.bU.getResources().getString(R.string.request_pending));
                    }
                    this.bw.setVisibility(0);
                    this.G.setText(this.bU.getResources().getString(R.string.bank_not_confirmed));
                    this.f70018d.setVisibility(8);
                    this.W.setVisibility(8);
                    this.aC.setVisibility(8);
                    this.w.setVisibility(8);
                    this.aE.setVisibility(8);
                    this.aD.setVisibility(8);
                    this.aB.setVisibility(0);
                    this.ci.setVisibility(8);
                    this.aH.setVisibility(8);
                    this.aM.setVisibility(0);
                    this.aM.setText(this.bU.getResources().getString(R.string.amount_deducted_bank_conf_awaited_may_take_3_days_p2b));
                    this.aQ.setVisibility(0);
                    this.aQ.setImageDrawable(getResources().getDrawable(R.drawable.ic_bank_waiting));
                    this.aR.setVisibility(0);
                    this.aR.setImageDrawable(getResources().getDrawable(R.drawable.ic_bank_pending));
                    this.aO.setVisibility(0);
                } else if ("FAILURE".equalsIgnoreCase(((CJRValidateTransaction) this.x).getStatus())) {
                    this.aF = Boolean.TRUE;
                    this.Y.setVisibility(0);
                    this.bT.setVisibility(8);
                    this.Y.setImageDrawable(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.ic_failed));
                    this.aL.setVisibility(8);
                    this.bw.setVisibility(8);
                    this.bA.setVisibility(0);
                    this.bA.setText(((CJRValidateTransaction) this.x).getStatusMessage());
                    this.G.setText(this.bU.getResources().getString(R.string.failure_bank));
                    this.f70018d.setVisibility(8);
                    this.W.setVisibility(0);
                    this.aC.setVisibility(8);
                    this.w.setVisibility(8);
                    this.aE.setVisibility(8);
                    this.aD.setVisibility(8);
                    this.aB.setVisibility(0);
                    this.ci.setVisibility(8);
                    this.aH.setVisibility(8);
                    this.aM.setVisibility(8);
                    this.aN.setVisibility(8);
                    this.aO.setVisibility(0);
                    this.aP.setVisibility(0);
                    this.bu.setText(R.string.bank_name_label);
                }
            } else if (iJRDataModel2 instanceof CJRIMPSInitiateDataModel) {
                if ("PENDING".equalsIgnoreCase(((CJRIMPSInitiateDataModel) iJRDataModel2).getmStatus())) {
                    this.aF = Boolean.TRUE;
                    this.Y.setVisibility(0);
                    this.bT.setVisibility(8);
                    this.Y.setImageDrawable(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.group_3_copy));
                    this.aL.setVisibility(0);
                    this.aL.setText(this.bU.getResources().getString(R.string.request_pending));
                    this.bw.setVisibility(0);
                    this.G.setText(this.bU.getResources().getString(R.string.bank_not_confirmed));
                    this.f70018d.setVisibility(8);
                    this.W.setVisibility(8);
                    this.aC.setVisibility(8);
                    this.w.setVisibility(8);
                    this.aE.setVisibility(8);
                    this.aD.setVisibility(8);
                    this.aB.setVisibility(0);
                    this.ci.setVisibility(8);
                    this.aH.setVisibility(8);
                    this.aM.setVisibility(0);
                    this.aM.setText(((CJRIMPSInitiateDataModel) this.x).getMessage());
                    this.aQ.setVisibility(0);
                    this.aQ.setImageDrawable(getResources().getDrawable(R.drawable.ic_bank_waiting));
                    this.aO.setVisibility(0);
                    this.aR.setVisibility(0);
                    this.aR.setImageDrawable(getResources().getDrawable(R.drawable.ic_bank_pending));
                } else if ("failed".equalsIgnoreCase(((CJRIMPSInitiateDataModel) this.x).getmStatus()) || "FAILURE".equalsIgnoreCase(((CJRIMPSInitiateDataModel) this.x).getmStatus())) {
                    this.aF = Boolean.TRUE;
                    this.Y.setVisibility(0);
                    this.bT.setVisibility(8);
                    this.Y.setImageDrawable(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.ic_failed));
                    this.aL.setVisibility(8);
                    this.bw.setVisibility(8);
                    this.bA.setVisibility(0);
                    this.bA.setText(((CJRIMPSInitiateDataModel) this.x).getMessage());
                    this.G.setText(getString(R.string.failure_bank));
                    this.f70018d.setVisibility(8);
                    this.W.setVisibility(0);
                    this.aC.setVisibility(8);
                    this.w.setVisibility(8);
                    this.aE.setVisibility(8);
                    this.aD.setVisibility(8);
                    this.aB.setVisibility(0);
                    this.ci.setVisibility(8);
                    this.aH.setVisibility(8);
                    this.aM.setVisibility(8);
                    this.aN.setVisibility(8);
                    this.aO.setVisibility(0);
                    this.aP.setVisibility(0);
                    this.bu.setText(R.string.bank_name_label);
                } else if ("SUCCESS".equalsIgnoreCase(((CJRIMPSInitiateDataModel) this.x).getmStatus())) {
                    this.aM.setVisibility(0);
                    this.aM.setText(((CJRIMPSInitiateDataModel) this.x).getMessage());
                }
            } else if (iJRDataModel2 instanceof BaseUpiResponse) {
                if (!this.bJ.isSuccess() || (!"0".equalsIgnoreCase(this.bJ.getResponse()) && !"92".equalsIgnoreCase(this.bJ.getResponse()))) {
                    this.aF = Boolean.TRUE;
                    this.Y.setVisibility(0);
                    this.bT.setVisibility(8);
                    this.Y.setImageDrawable(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.ic_failed));
                    this.aL.setVisibility(8);
                    this.bw.setVisibility(8);
                    this.bA.setVisibility(0);
                    this.bA.setText(((BaseUpiResponse) this.x).getMessage());
                    this.G.setText(this.bU.getResources().getString(R.string.failure_money_transfer));
                    this.f70018d.setVisibility(8);
                    this.W.setVisibility(0);
                    this.aC.setVisibility(8);
                    this.w.setVisibility(8);
                    this.aE.setVisibility(8);
                    this.aD.setVisibility(8);
                    this.aB.setVisibility(0);
                    this.ci.setVisibility(8);
                    this.aH.setVisibility(8);
                    this.aM.setVisibility(8);
                    this.aN.setVisibility(8);
                    this.aO.setVisibility(0);
                    this.aP.setVisibility(0);
                    this.bu.setText(R.string.bank_name_label);
                } else {
                    this.aM.setVisibility(0);
                    this.aM.setText(((BaseUpiResponse) this.x).getMessage());
                    this.bw.setVisibility(8);
                }
            }
        } else {
            IJRDataModel iJRDataModel3 = this.x;
            if (iJRDataModel3 instanceof CJRSendMoney) {
                this.H = 1;
                this.ci.setVisibility(8);
                CJRSendMoney cJRSendMoney2 = (CJRSendMoney) this.x;
                this.w.setText(this.B);
                this.G.setText(this.bU.getResources().getString(R.string.rupee_symbol) + this.D);
                this.aC.setText(this.bU.getResources().getString(R.string.sent_successfully));
                this.O.setVisibility(4);
                if (!TextUtils.isEmpty(this.B) && !TextUtils.isEmpty(this.B.trim())) {
                    this.at.setText(this.B.trim().substring(0, 1));
                }
                if (!TextUtils.isEmpty(cJRSendMoney2.getResponse().getwalletSysTransactionID())) {
                    this.t = cJRSendMoney2.getResponse().getwalletSysTransactionID();
                    this.u = cJRSendMoney2.getStatusMessage();
                    this.v = cJRSendMoney2.getStatus();
                    this.ar.setVisibility(0);
                    this.ar.setText(this.t);
                    this.as.setVisibility(0);
                } else {
                    this.ar.setVisibility(8);
                    this.as.setVisibility(8);
                }
                if (!this.I && !TextUtils.isEmpty(this.T) && !TextUtils.isEmpty(this.B) && !TextUtils.equals(this.T, this.B)) {
                    this.w.setText(this.B);
                    this.O.setText(this.T);
                    this.O.setVisibility(0);
                } else if (!TextUtils.isEmpty(this.B) || TextUtils.equals(this.T, this.B)) {
                    this.w.setText(this.B);
                } else {
                    this.w.setText(this.T);
                }
                q();
                d("mobile", this.D);
            } else if (iJRDataModel3 instanceof CJRSendMoneyToMerchantResponseModel) {
                this.H = 3;
                this.ci.setVisibility(0);
                a(this.x);
                this.f70018d.setVisibility(4);
                d("merchant", this.D);
                if (this.ct) {
                    this.ch.setVisibility(0);
                }
            } else if (iJRDataModel3 instanceof CJRValidateTransaction) {
                this.H = 1;
                this.ci.setVisibility(8);
                CJRValidateTransaction cJRValidateTransaction2 = (CJRValidateTransaction) this.x;
                this.w.setText(this.B);
                this.G.setText(this.bU.getResources().getString(R.string.rupee_symbol) + this.D);
                this.aC.setText(this.bU.getResources().getString(R.string.sent_successfully));
                if (!TextUtils.isEmpty(this.B)) {
                    this.at.setText(this.B.trim().substring(0, 1));
                }
                if (!TextUtils.isEmpty(cJRValidateTransaction2.getResponse().getwalletSysTransactionID())) {
                    this.t = cJRValidateTransaction2.getResponse().getwalletSysTransactionID();
                    this.u = cJRValidateTransaction2.getStatusMessage();
                    this.v = cJRValidateTransaction2.getStatus();
                    this.ar.setVisibility(0);
                    this.ar.setText(cJRValidateTransaction2.getResponse().getwalletSysTransactionID());
                    this.as.setVisibility(0);
                } else {
                    this.ar.setVisibility(8);
                    this.as.setVisibility(8);
                }
                if (!this.I && !TextUtils.isEmpty(this.T) && !TextUtils.isEmpty(this.B) && !TextUtils.equals(this.T, this.B)) {
                    this.w.setText(this.B);
                    this.O.setText(this.T);
                    this.O.setVisibility(0);
                } else if (!TextUtils.isEmpty(this.B) || TextUtils.equals(this.T, this.B)) {
                    this.w.setText(this.B);
                } else {
                    this.w.setText(this.T);
                }
                q();
                d("mobile", this.D);
            } else if (iJRDataModel3 instanceof CJRFastForwardResponse) {
                this.H = 3;
                a(iJRDataModel3);
                this.f70018d.setVisibility(4);
                d("merchant", this.D);
                if (this.ct) {
                    this.ch.setVisibility(0);
                }
            } else if (iJRDataModel3 instanceof ShowCodePushModel) {
                o();
            } else if (iJRDataModel3 instanceof CJRProcessTranscationResponse) {
                this.H = 3;
                this.ci.setVisibility(0);
                a(this.x);
                this.f70018d.setVisibility(4);
                d("merchant", this.D);
                if (this.ct) {
                    this.ch.setVisibility(0);
                }
            }
        }
        if (!TextUtils.isEmpty(this.C)) {
            this.bB.setVisibility(0);
            this.bB.setText("\" " + this.C + " \"");
        }
        if (!TextUtils.isEmpty(this.M) && !this.I) {
            this.O.setText(this.M);
            this.O.setVisibility(0);
        }
        this.ab.setLayoutManager(new LinearLayoutManager(this.bU, 0, false));
        CJRNobleInitiative cJRNobleInitiative2 = this.Z;
        if (!(cJRNobleInitiative2 == null || cJRNobleInitiative2.response == null || this.Z.response.slab == null || this.Z.response.slab.size() <= 0)) {
            this.j = new net.one97.paytm.wallet.b.b<>(this.Z.response.slab, this);
        }
        this.ab.setAdapter(this.j);
        if (this.y != null) {
            this.H = 3;
            this.f70018d.setVisibility(4);
            if (this.ct) {
                this.ch.setVisibility(0);
            }
            c(this.y);
        }
        if (getArguments().getBoolean("backpress_offline_pg")) {
            c(getArguments().getString("order_id"), getArguments().getString("mid"));
        }
        if (this.z || this.cu || this.cG) {
            this.ch.setVisibility(8);
        }
        if (getArguments() != null && !getArguments().getBoolean("is_offline_pg", false)) {
            this.ci.setVisibility(8);
        }
        s();
        j();
        k();
        inflate.invalidate();
        if (this.bK && this.bO) {
            g();
        }
        if (!this.bL) {
            f();
        }
        return inflate;
    }

    private void f() {
        n nVar = new n();
        Bundle bundle = new Bundle();
        bundle.putInt("deal_type", 123);
        nVar.setArguments(bundle);
        getChildFragmentManager().a().a(0, 0).b(R.id.deals_fragment_container, nVar, n.f70086a).b();
    }

    private void g() {
        Handler handler = new Handler();
        StringBuilder sb = new StringBuilder("");
        IJRDataModel iJRDataModel = this.x;
        if (iJRDataModel instanceof BaseUpiResponse) {
            this.bJ = (BaseUpiResponse) iJRDataModel;
            if (this.bJ.isSuccess()) {
                this.v = "SUCCESS";
            } else {
                this.v = "FAILURE";
            }
            sb.append("txnId=" + this.bJ.getSeqNo());
            if (!TextUtils.isEmpty(this.bJ.getResponse())) {
                sb.append("&responseCode=" + this.bJ.getResponse());
            }
            if (!TextUtils.isEmpty(this.bJ.getBankRRN())) {
                sb.append("&ApprovalRefNo=" + this.bJ.getBankRRN());
            }
            if (!TextUtils.isEmpty(this.v)) {
                sb.append("&Status=" + this.v);
            }
            if (!TextUtils.isEmpty(this.bP)) {
                sb.append("&txnRef=" + this.bP);
            }
        }
        final String sb2 = sb.toString();
        handler.postDelayed(new Runnable() {
            public final void run() {
                Intent intent = new Intent();
                intent.putExtra(Payload.RESPONSE, sb2);
                g.this.bU.setResult(-1, intent);
                g.this.bU.finish();
            }
        }, 2000);
    }

    /* access modifiers changed from: private */
    public boolean h() {
        return com.paytm.utility.b.a(getContext().getApplicationContext(), net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.bU, "app_rating_5_star_time_gap")), net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.bU, "app_rating_less_than_5_star_time_gap")), net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.bU, "app_rating_not_now_time_gap")));
    }

    private void i() {
        String str = this.bS;
        TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(str)) {
            new RateMerchantHelper(getContext(), this, str, new RateMerchantHelper.a() {
                public final void a(MerchantPPReviewData merchantPPReviewData) {
                    if (!g.this.h()) {
                        g.a(g.this, merchantPPReviewData);
                    } else if (g.n(g.this)) {
                        g.this.D();
                    } else {
                        g.a(g.this, merchantPPReviewData);
                    }
                }

                public final void a() {
                    if (g.this.h()) {
                        g.this.D();
                    }
                }
            });
        } else if (h()) {
            D();
        }
    }

    private void j() {
        if (a(this.am) && WalletSharedPrefs.INSTANCE.getNobleResponse(this.bU) != null) {
            this.an.setVisibility(0);
        }
    }

    private boolean a(String str) {
        CJRNobleInitiative cJRNobleInitiative;
        if (str == null || !str.equalsIgnoreCase("via_qr") || (cJRNobleInitiative = this.Z) == null || cJRNobleInitiative.response == null) {
            return false;
        }
        return this.Z.response.merchantQr.equalsIgnoreCase("donate") || this.Z.response.userQr.equalsIgnoreCase("donate");
    }

    private void k() {
        if (TextUtils.isEmpty(this.R)) {
            this.ax.setVisibility(0);
            return;
        }
        this.f70021g.setVisibility(0);
        this.f70022h.setVisibility(0);
        this.ao.setVisibility(0);
        this.ao.setText(this.R);
        this.f70016b.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void l() {
        if (TextUtils.isEmpty(this.S)) {
            this.ax.setVisibility(0);
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, net.one97.paytm.wallet.d.l.a(100));
        layoutParams.setMargins(net.one97.paytm.wallet.d.l.a((int) this.bU.getResources().getDimension(R.dimen.margin_left_prn)), net.one97.paytm.wallet.d.l.a((int) this.bU.getResources().getDimension(R.dimen.margin_top_prn)), net.one97.paytm.wallet.d.l.a((int) this.bU.getResources().getDimension(R.dimen.margin_left_prn)), net.one97.paytm.wallet.d.l.a((int) this.bU.getResources().getDimension(R.dimen.margin_top_prn)));
        this.f70016b.setLayoutParams(layoutParams);
        this.f70016b.getLayoutParams().height = net.one97.paytm.wallet.d.l.a(60);
        this.f70021g.setVisibility(0);
        this.f70022h.setVisibility(0);
        this.ao.setVisibility(0);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < this.S.length() / 2; i2++) {
            sb.append(this.S.charAt(i2));
        }
        for (int length = this.S.length() / 2; length < this.S.length(); length++) {
            sb2.append(this.S.charAt(length));
        }
        TextView textView = this.ao;
        textView.setText(sb.toString() + " " + sb2);
        this.ao.setTypeface(Typeface.DEFAULT_BOLD);
        this.f70016b.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void m() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (!g.this.aF.booleanValue()) {
                    g.this.Y.setVisibility(8);
                    g.this.bT.setVisibility(0);
                    g.this.bT.playAnimation();
                }
                g.s(g.this);
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    public void b(String str, String str2) {
        if (net.one97.paytm.deeplink.e.a()) {
            this.ca = net.one97.paytm.cashback.posttxn.c.a();
        }
        e eVar = this.ca;
        if (eVar != null && eVar.a(net.one97.paytm.utils.b.a.SCAN_PAY.getId(), 0)) {
            if ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && this.cg != null) {
                this.ca.a((AppCompatActivity) this.bU);
                f.a aVar = new f.a();
                aVar.f49545a = str;
                aVar.f49546b = str2;
                this.ca.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) null);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        e eVar = this.ca;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private void c(String str, String str2) {
        this.bb.setVisibility(0);
        a(this.bU.getString(R.string.order_txn_id) + " " + str, this.bb);
        b(this.D);
        this.bc.setText(this.B);
        this.aX.setText(this.bU.getString(R.string.payment_pending));
        this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.color_ffa400));
        this.bd.setText(this.bU.getString(R.string.payment_pending_desc_msg));
        this.bd.setBackgroundColor(androidx.core.content.b.c(this.bU, R.color.color_fdfbd3));
        this.bd.setVisibility(0);
        this.bT.setVisibility(8);
        this.ba.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
        this.ba.setVisibility(0);
        n();
        a(str, str2);
    }

    private void d(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "send_money");
            hashMap.put("new_wallet_successfully_sent_money_amount", str2);
            hashMap.put("wallet_send_money_method_name", str);
            net.one97.paytm.j.a.b("wallet_success_screen_loaded", (Map<String, Object>) hashMap, this.bU.getApplicationContext());
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void b(String str) {
        Double valueOf = Double.valueOf(Double.parseDouble(str));
        if (valueOf.doubleValue() % 1.0d == 0.0d) {
            this.aY.setText(d(String.valueOf(valueOf)));
            return;
        }
        String format = new DecimalFormat("#.00").format(Double.parseDouble(str));
        int indexOf = format.indexOf(AppUtility.CENTER_DOT);
        this.aY.setText(d(format.substring(0, indexOf)));
        this.aZ.setVisibility(0);
        this.aZ.setText(format.substring(indexOf));
    }

    private void e(String str, String str2) {
        this.m.setEnabled(false);
        this.k.setVisibility(8);
        this.aj.setVisibility(8);
        this.V.setEnabled(false);
        JSONObject jSONObject = new JSONObject();
        CJRNobleInitiative cJRNobleInitiative = this.Z;
        if (!(cJRNobleInitiative == null || cJRNobleInitiative.response == null)) {
            try {
                jSONObject.put(CJRQRScanResultModel.KEY_MERCHANT_GUID_READ, this.Z.response.merchantGuid);
                jSONObject.put(CJRQRScanResultModel.KEY_MERCHANT_NAME, this.Z.response.merchantName);
                jSONObject.put("INDUSTRY_TYPE_ID", this.Z.response.industryType);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
        try {
            this.ae = new CJRQRScanResultModel();
            this.ae.parseData(jSONObject, getContext());
        } catch (JSONException e3) {
            q.b(e3.getMessage());
        }
        net.one97.paytm.f.b.a().a(this.bU, this.ae.getMerchantName(), this.ae.getMobileNo(), false, net.one97.paytm.wallet.utility.h.P2M.getValue(), com.paytm.utility.a.g(this.bU), com.paytm.utility.a.h(this.bU));
        this.f70019e.a(this.ae, str, str2);
    }

    private void n() {
        this.aU.setVisibility(0);
        this.aV.setVisibility(0);
        boolean isEmpty = TextUtils.isEmpty(this.cd);
        Integer valueOf = Integer.valueOf(R.drawable.merchant_icon);
        if (!isEmpty) {
            try {
                b.a.C0750a a2 = com.paytm.utility.b.b.a(this.bU);
                a2.f43753a = this.cd;
                b.a.C0750a.a(a2.a((Object) valueOf).b(valueOf), this.aV, (com.paytm.utility.b.b.b) null, 2);
            } catch (Exception unused) {
            }
        } else {
            this.aV.setImageDrawable(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.merchant_icon));
        }
    }

    private void o() {
        this.ci.setVisibility(8);
        ShowCodePushModel showCodePushModel = (ShowCodePushModel) this.x;
        this.bQ = showCodePushModel.getOrderId();
        if (!TextUtils.isEmpty(this.bQ)) {
            this.t = showCodePushModel.getTxnId();
            this.v = showCodePushModel.getStatus();
            this.bb.setVisibility(0);
            TextView textView = this.bb;
            textView.setText(this.bU.getResources().getString(R.string.order_txn_id) + " " + this.bQ);
        } else {
            this.bb.setVisibility(8);
        }
        if (!TextUtils.isEmpty(showCodePushModel.getPaymentMode())) {
            String e2 = e(showCodePushModel.getPaymentMode());
            if (!TextUtils.isEmpty(e2)) {
                this.bf.setVisibility(0);
                this.bf.setText(String.format(this.bU.getResources().getString(R.string.silent_push_message), new Object[]{e2}));
            } else {
                this.bf.setVisibility(8);
            }
        } else {
            this.bf.setVisibility(8);
        }
        this.cd = showCodePushModel.getMerchantLogoUrl();
        n();
        this.ba.setVisibility(0);
        try {
            if (!TextUtils.isEmpty(showCodePushModel.getTimeStamp())) {
                this.ba.setText(com.paytm.utility.b.a(Long.valueOf(Long.parseLong(showCodePushModel.getTimeStamp())), "hh:mm a, dd MMM yyyy"));
            } else {
                this.ba.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
            }
        } catch (NumberFormatException unused) {
        }
        b(showCodePushModel.getAmount());
        this.bc.setText(showCodePushModel.getMerchantName());
        if (showCodePushModel.getStatus().equals("PENDING")) {
            this.bg = true;
            this.aX.setText(this.bU.getResources().getString(R.string.payment_pending));
            this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.color_ffa400));
            this.bd.setText(this.bU.getResources().getString(R.string.payment_pending_desc_msg));
            this.bd.setBackgroundColor(androidx.core.content.b.c(this.bU, R.color.color_fdfbd3));
            this.bd.setVisibility(0);
            this.Y.setVisibility(0);
            this.bT.setVisibility(8);
            this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.ic_pending_copy));
        } else if (showCodePushModel.getStatus().equals("SUCCESS")) {
            this.bi = true;
            this.bg = false;
            this.bh = false;
            a("Payment_success", "", "");
            this.aX.setText(this.bU.getResources().getString(R.string.paid_successfully_to));
            this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.black));
            this.Y.setVisibility(0);
            this.bT.setVisibility(8);
            this.cr.c();
            this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.payment_done_00048));
            m();
            this.bd.setVisibility(8);
            if (showCodePushModel != null && !TextUtils.isEmpty(showCodePushModel.getTxnId())) {
                b(showCodePushModel.getTxnId(), (String) null);
            }
            F();
            G();
        } else if (showCodePushModel.getStatus().equalsIgnoreCase("FAILURE")) {
            this.bh = true;
            this.bg = false;
            a("Payment_failed", "", "");
            this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.ic_failed_copy));
            this.Y.setVisibility(0);
            this.bT.setVisibility(8);
            this.aX.setText(this.bU.getResources().getString(R.string.payment_failed_wallet));
            this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.color_fd5c5c));
            this.bd.setVisibility(8);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(22:1|2|3|(2:5|6)(1:7)|8|(2:10|(1:12))|13|(2:17|(1:19)(1:20))|21|(1:23)(2:24|(1:26))|27|28|29|30|(2:32|33)(1:34)|35|36|(2:38|(1:40)(2:41|(7:43|44|(3:46|47|48)(1:49)|50|(2:54|(1:58))|59|60)(2:61|(4:63|(1:65)|66|75)(1:76))))|67|(1:69)|70|71) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0133 */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x016c A[Catch:{ JSONException -> 0x0341 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02eb A[Catch:{ JSONException -> 0x0341 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(java.lang.String r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r0 = "TXNDATE"
            java.lang.String r2 = "PRN"
            java.lang.String r3 = "MID"
            java.lang.String r4 = "ORDERID"
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0341 }
            r6 = r22
            r5.<init>(r6)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r6 = "RESPMSG"
            java.lang.String r6 = r5.optString(r6)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r7 = r5.optString(r4)     // Catch:{ JSONException -> 0x0341 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r8 = "TXNID"
            r9 = 8
            r10 = 0
            if (r7 != 0) goto L_0x0064
            java.lang.String r7 = r5.optString(r8)     // Catch:{ JSONException -> 0x0341 }
            r1.t = r7     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r7 = "STATUS"
            java.lang.String r7 = r5.optString(r7)     // Catch:{ JSONException -> 0x0341 }
            r1.v = r7     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r7 = r1.bb     // Catch:{ JSONException -> 0x0341 }
            r7.setVisibility(r10)     // Catch:{ JSONException -> 0x0341 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0341 }
            r7.<init>()     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r11 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            android.content.res.Resources r11 = r11.getResources()     // Catch:{ JSONException -> 0x0341 }
            r12 = 2131960102(0x7f132126, float:1.9556863E38)
            java.lang.String r11 = r11.getString(r12)     // Catch:{ JSONException -> 0x0341 }
            r7.append(r11)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r11 = " "
            r7.append(r11)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r11 = r5.optString(r4)     // Catch:{ JSONException -> 0x0341 }
            r7.append(r11)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r11 = r1.bb     // Catch:{ JSONException -> 0x0341 }
            a((java.lang.String) r7, (android.widget.TextView) r11)     // Catch:{ JSONException -> 0x0341 }
            goto L_0x0069
        L_0x0064:
            android.widget.TextView r7 = r1.bb     // Catch:{ JSONException -> 0x0341 }
            r7.setVisibility(r9)     // Catch:{ JSONException -> 0x0341 }
        L_0x0069:
            java.lang.String r7 = r5.optString(r4)     // Catch:{ JSONException -> 0x0341 }
            android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r7 = r5.optString(r3)     // Catch:{ JSONException -> 0x0341 }
            r1.bS = r7     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r7 = r5.optString(r4)     // Catch:{ JSONException -> 0x0341 }
            r1.bQ = r7     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r7 = r5.optString(r2)     // Catch:{ JSONException -> 0x0341 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0341 }
            r11 = 1
            if (r7 != 0) goto L_0x009a
            java.lang.String r2 = r5.optString(r2)     // Catch:{ JSONException -> 0x0341 }
            r1.S = r2     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = r1.S     // Catch:{ JSONException -> 0x0341 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x0341 }
            if (r2 != 0) goto L_0x009a
            r1.aT = r11     // Catch:{ JSONException -> 0x0341 }
            r21.l()     // Catch:{ JSONException -> 0x0341 }
        L_0x009a:
            boolean r2 = r1.cn     // Catch:{ JSONException -> 0x0341 }
            if (r2 == 0) goto L_0x00c0
            java.lang.String r2 = r1.cp     // Catch:{ JSONException -> 0x0341 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x0341 }
            if (r2 != 0) goto L_0x00c0
            java.lang.String r2 = r1.cp     // Catch:{ JSONException -> 0x0341 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x0341 }
            if (r2 != 0) goto L_0x00bb
            android.widget.TextView r2 = r1.bf     // Catch:{ JSONException -> 0x0341 }
            r2.setVisibility(r10)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r2 = r1.bf     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r7 = r1.cp     // Catch:{ JSONException -> 0x0341 }
            r2.setText(r7)     // Catch:{ JSONException -> 0x0341 }
            goto L_0x00c0
        L_0x00bb:
            android.widget.TextView r2 = r1.bf     // Catch:{ JSONException -> 0x0341 }
            r2.setVisibility(r9)     // Catch:{ JSONException -> 0x0341 }
        L_0x00c0:
            r21.n()     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = "TXNAMOUNT"
            java.lang.String r2 = r5.optString(r2)     // Catch:{ JSONException -> 0x0341 }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x0341 }
            if (r7 != 0) goto L_0x00e0
            java.math.BigDecimal r7 = new java.math.BigDecimal     // Catch:{ JSONException -> 0x0341 }
            r7.<init>(r2)     // Catch:{ JSONException -> 0x0341 }
            java.math.BigDecimal r2 = r7.stripTrailingZeros()     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = r2.toPlainString()     // Catch:{ JSONException -> 0x0341 }
            r1.b((java.lang.String) r2)     // Catch:{ JSONException -> 0x0341 }
            goto L_0x00fa
        L_0x00e0:
            java.lang.String r2 = r1.D     // Catch:{ JSONException -> 0x0341 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x0341 }
            if (r2 != 0) goto L_0x00fa
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r7 = r1.D     // Catch:{ JSONException -> 0x0341 }
            r2.<init>(r7)     // Catch:{ JSONException -> 0x0341 }
            java.math.BigDecimal r2 = r2.stripTrailingZeros()     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = r2.toPlainString()     // Catch:{ JSONException -> 0x0341 }
            r1.b((java.lang.String) r2)     // Catch:{ JSONException -> 0x0341 }
        L_0x00fa:
            android.widget.TextView r2 = r1.bc     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r7 = r1.B     // Catch:{ JSONException -> 0x0341 }
            r2.setText(r7)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r2 = r1.ba     // Catch:{ JSONException -> 0x0341 }
            r2.setVisibility(r10)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = r5.optString(r0)     // Catch:{ NumberFormatException -> 0x0133 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ NumberFormatException -> 0x0133 }
            java.lang.String r7 = "hh:mm a, dd MMM yyyy"
            if (r2 != 0) goto L_0x0122
            java.lang.String r0 = r5.optString(r0)     // Catch:{ NumberFormatException -> 0x0133 }
            android.widget.TextView r2 = r1.ba     // Catch:{ NumberFormatException -> 0x0133 }
            java.lang.String r12 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r0 = com.paytm.utility.b.g(r0, r12, r7)     // Catch:{ NumberFormatException -> 0x0133 }
            r2.setText(r0)     // Catch:{ NumberFormatException -> 0x0133 }
            goto L_0x0133
        L_0x0122:
            android.widget.TextView r0 = r1.ba     // Catch:{ NumberFormatException -> 0x0133 }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ NumberFormatException -> 0x0133 }
            java.lang.Long r2 = java.lang.Long.valueOf(r12)     // Catch:{ NumberFormatException -> 0x0133 }
            java.lang.String r2 = com.paytm.utility.b.a((java.lang.Long) r2, (java.lang.String) r7)     // Catch:{ NumberFormatException -> 0x0133 }
            r0.setText(r2)     // Catch:{ NumberFormatException -> 0x0133 }
        L_0x0133:
            r21.n()     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r0 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = ""
            com.paytm.network.a$b r7 = com.paytm.network.a.b.USER_FACING     // Catch:{ JSONException -> 0x0341 }
            boolean r12 = r1.cD     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r13 = r1.cA     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r14 = r1.cC     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r15 = r1.cv     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r9 = r1.v     // Catch:{ JSONException -> 0x0341 }
            boolean r11 = r1.cB     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r10 = r1.cE     // Catch:{ JSONException -> 0x0341 }
            r20 = r3
            java.lang.String r3 = r1.cF     // Catch:{ JSONException -> 0x0341 }
            r16 = r9
            r17 = r11
            r18 = r10
            r19 = r3
            java.lang.String r3 = net.one97.paytm.utils.bf.a(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ JSONException -> 0x0341 }
            com.paytm.network.a$c r9 = com.paytm.network.a.c.PAYMENTS     // Catch:{ JSONException -> 0x0341 }
            net.one97.paytm.utils.bf.a(r0, r2, r7, r3, r9)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r0 = r1.v     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = "PENDING"
            boolean r0 = r0.equals(r2)     // Catch:{ JSONException -> 0x0341 }
            r2 = 2131100234(0x7f06024a, float:1.7812844E38)
            if (r0 != 0) goto L_0x02e0
            java.lang.String r0 = r1.v     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r3 = "TXN_PENDING"
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0341 }
            if (r0 == 0) goto L_0x0178
            goto L_0x02e0
        L_0x0178:
            java.lang.String r0 = r1.v     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r3 = "TXN_SUCCESS"
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0341 }
            if (r0 == 0) goto L_0x026b
            r0 = 0
            r1.bg = r0     // Catch:{ JSONException -> 0x0341 }
            r1.bh = r0     // Catch:{ JSONException -> 0x0341 }
            r2 = 1
            r1.bi = r2     // Catch:{ JSONException -> 0x0341 }
            android.widget.RelativeLayout r2 = r1.ci     // Catch:{ JSONException -> 0x0341 }
            r2.setVisibility(r0)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.aX     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r2 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ JSONException -> 0x0341 }
            r3 = 2131960408(0x7f132258, float:1.9557484E38)
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x0341 }
            r0.setText(r2)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.aX     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r2 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            r3 = 2131099725(0x7f06004d, float:1.7811811E38)
            int r2 = androidx.core.content.b.c(r2, r3)     // Catch:{ JSONException -> 0x0341 }
            r0.setTextColor(r2)     // Catch:{ JSONException -> 0x0341 }
            android.widget.ImageView r0 = r1.Y     // Catch:{ JSONException -> 0x0341 }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.bd     // Catch:{ JSONException -> 0x0341 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ JSONException -> 0x0341 }
            net.one97.paytm.p2mNewDesign.f.k r0 = r1.cr     // Catch:{ JSONException -> 0x0341 }
            r0.c()     // Catch:{ JSONException -> 0x0341 }
            android.widget.ImageView r0 = r1.Y     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r2 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            r3 = 2131233708(0x7f080bac, float:1.8083561E38)
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r3)     // Catch:{ JSONException -> 0x0341 }
            r0.setBackground(r2)     // Catch:{ JSONException -> 0x0341 }
            r21.m()     // Catch:{ JSONException -> 0x0341 }
            r21.i()     // Catch:{ JSONException -> 0x0341 }
            net.one97.paytm.b.a.c r0 = net.one97.paytm.b.a.c.a()     // Catch:{ JSONException -> 0x0341 }
            boolean r0 = r0.f49484d     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = "home/pay-send/payment-success"
            java.lang.String r3 = "post_payment_success_shown"
            java.lang.String r6 = "offline_payments"
            if (r0 == 0) goto L_0x01ed
            java.lang.String r0 = "flow_through_scan_icon"
            android.content.Context r7 = r21.getContext()     // Catch:{ JSONException -> 0x0341 }
            a(r6, r3, r0, r7, r2)     // Catch:{ JSONException -> 0x0341 }
            goto L_0x01f6
        L_0x01ed:
            java.lang.String r0 = "flow_through_pay_icon"
            android.content.Context r7 = r21.getContext()     // Catch:{ JSONException -> 0x0341 }
            a(r6, r3, r0, r7, r2)     // Catch:{ JSONException -> 0x0341 }
        L_0x01f6:
            java.lang.String r0 = "ADDITIONAL_PARAM"
            java.lang.String r0 = r5.optString(r0)     // Catch:{ JSONException -> 0x0341 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0341 }
            if (r2 != 0) goto L_0x0249
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0341 }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r0 = "merchantInfo"
            org.json.JSONObject r0 = r2.optJSONObject(r0)     // Catch:{ JSONException -> 0x0341 }
            if (r0 == 0) goto L_0x0249
            java.lang.String r2 = "mccCode"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ JSONException -> 0x0341 }
            r1.f70023i = r2     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = "currentTxnCount"
            java.lang.String r0 = r0.optString(r2)     // Catch:{ JSONException -> 0x0341 }
            r1.bj = r0     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r0 = r1.bj     // Catch:{ JSONException -> 0x0341 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0341 }
            if (r0 != 0) goto L_0x0249
            java.lang.String r0 = r1.bj     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = "null"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x0341 }
            if (r0 != 0) goto L_0x0249
            android.widget.RelativeLayout r0 = r1.bk     // Catch:{ JSONException -> 0x0341 }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ JSONException -> 0x0341 }
            android.widget.RelativeLayout r0 = r1.bk     // Catch:{ JSONException -> 0x0341 }
            r2 = 2131372511(0x7f0a29df, float:1.8365087E38)
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = r1.bj     // Catch:{ JSONException -> 0x0341 }
            r0.setText(r2)     // Catch:{ JSONException -> 0x0341 }
        L_0x0249:
            android.os.Bundle r0 = r21.getArguments()     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = "is_offline_pg"
            r3 = 0
            boolean r0 = r0.getBoolean(r2, r3)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = r1.D     // Catch:{ JSONException -> 0x0341 }
            r1.a((boolean) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r0 = r5.optString(r8)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r2 = r5.optString(r4)     // Catch:{ JSONException -> 0x0341 }
            r1.b((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0341 }
            r21.F()     // Catch:{ JSONException -> 0x0341 }
            r21.G()     // Catch:{ JSONException -> 0x0341 }
            return
        L_0x026b:
            java.lang.String r0 = r1.v     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r3 = "TXN_FAILURE"
            boolean r0 = r0.equals(r3)     // Catch:{ JSONException -> 0x0341 }
            if (r0 == 0) goto L_0x02df
            r0 = 1
            r1.bh = r0     // Catch:{ JSONException -> 0x0341 }
            r0 = 0
            r1.bg = r0     // Catch:{ JSONException -> 0x0341 }
            com.airbnb.lottie.LottieAnimationView r0 = r1.bT     // Catch:{ JSONException -> 0x0341 }
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ JSONException -> 0x0341 }
            android.widget.ImageView r0 = r1.Y     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r3 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            r4 = 2131232282(0x7f08061a, float:1.8080669E38)
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.a((android.content.Context) r3, (int) r4)     // Catch:{ JSONException -> 0x0341 }
            r0.setBackground(r3)     // Catch:{ JSONException -> 0x0341 }
            android.widget.ImageView r0 = r1.Y     // Catch:{ JSONException -> 0x0341 }
            r3 = 0
            r0.setVisibility(r3)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.aX     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r3 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ JSONException -> 0x0341 }
            r4 = 2131960821(0x7f1323f5, float:1.9558321E38)
            java.lang.String r3 = r3.getString(r4)     // Catch:{ JSONException -> 0x0341 }
            r0.setText(r3)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.aX     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r3 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            r4 = 2131100230(0x7f060246, float:1.7812836E38)
            int r3 = androidx.core.content.b.c(r3, r4)     // Catch:{ JSONException -> 0x0341 }
            r0.setTextColor(r3)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.bd     // Catch:{ JSONException -> 0x0341 }
            r3 = 0
            r0.setVisibility(r3)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.bd     // Catch:{ JSONException -> 0x0341 }
            boolean r3 = com.paytm.utility.v.a((java.lang.String) r6)     // Catch:{ JSONException -> 0x0341 }
            if (r3 == 0) goto L_0x02d1
            android.app.Activity r3 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ JSONException -> 0x0341 }
            r4 = 2131959031(0x7f131cf7, float:1.955469E38)
            java.lang.String r6 = r3.getString(r4)     // Catch:{ JSONException -> 0x0341 }
        L_0x02d1:
            r0.setText(r6)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.bd     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r3 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            int r2 = androidx.core.content.b.c(r3, r2)     // Catch:{ JSONException -> 0x0341 }
            r0.setBackgroundColor(r2)     // Catch:{ JSONException -> 0x0341 }
        L_0x02df:
            return
        L_0x02e0:
            r0 = 1
            r1.bg = r0     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.bd     // Catch:{ JSONException -> 0x0341 }
            boolean r3 = com.paytm.utility.v.a((java.lang.String) r6)     // Catch:{ JSONException -> 0x0341 }
            if (r3 == 0) goto L_0x02f8
            android.app.Activity r3 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ JSONException -> 0x0341 }
            r6 = 2131960861(0x7f13241d, float:1.9558403E38)
            java.lang.String r6 = r3.getString(r6)     // Catch:{ JSONException -> 0x0341 }
        L_0x02f8:
            r0.setText(r6)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.bd     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r3 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            int r2 = androidx.core.content.b.c(r3, r2)     // Catch:{ JSONException -> 0x0341 }
            r0.setBackgroundColor(r2)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.bd     // Catch:{ JSONException -> 0x0341 }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.aX     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r2 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            android.content.res.Resources r2 = r2.getResources()     // Catch:{ JSONException -> 0x0341 }
            r3 = 2131960859(0x7f13241b, float:1.9558399E38)
            java.lang.String r2 = r2.getString(r3)     // Catch:{ JSONException -> 0x0341 }
            r0.setText(r2)     // Catch:{ JSONException -> 0x0341 }
            android.widget.TextView r0 = r1.aX     // Catch:{ JSONException -> 0x0341 }
            android.app.Activity r2 = r1.bU     // Catch:{ JSONException -> 0x0341 }
            r3 = 2131100247(0x7f060257, float:1.781287E38)
            int r2 = androidx.core.content.b.c(r2, r3)     // Catch:{ JSONException -> 0x0341 }
            r0.setTextColor(r2)     // Catch:{ JSONException -> 0x0341 }
            com.airbnb.lottie.LottieAnimationView r0 = r1.bT     // Catch:{ JSONException -> 0x0341 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ JSONException -> 0x0341 }
            java.lang.String r0 = r5.optString(r4)     // Catch:{ JSONException -> 0x0341 }
            r2 = r20
            java.lang.String r2 = r5.optString(r2)     // Catch:{ JSONException -> 0x0341 }
            r1.a((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0341 }
            return
        L_0x0341:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.c.g.c(java.lang.String):void");
    }

    private void a(String str, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Confirmation Screen");
            hashMap.put("event_category", d.bE);
            hashMap.put("event_action", str);
            hashMap.put("event_label", str3);
            hashMap.put(d.cw, str2);
            hashMap.put("user_id", com.paytm.utility.a.a(getContext()));
            hashMap.put(d.cv, "offline_payments");
            net.one97.paytm.j.a.b(getContext(), d.bE, str, str2, str3, "Confirmation Screen", "offline_payments");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private static String d(String str) {
        return new DecimalFormat("##,##,##,##,###").format(new BigDecimal(str));
    }

    private void a(IJRDataModel iJRDataModel) {
        String str;
        IJRDataModel iJRDataModel2 = iJRDataModel;
        if (iJRDataModel2 instanceof CJRSendMoneyToMerchantResponseModel) {
            CJRSendMoneyToMerchantResponseModel cJRSendMoneyToMerchantResponseModel = (CJRSendMoneyToMerchantResponseModel) iJRDataModel2;
            this.bd.setVisibility(8);
            if (cJRSendMoneyToMerchantResponseModel.getResponse() == null || TextUtils.isEmpty(cJRSendMoneyToMerchantResponseModel.getResponse().getWalletSystemTxnId())) {
                this.bb.setVisibility(8);
            } else {
                this.t = cJRSendMoneyToMerchantResponseModel.getResponse().getWalletSystemTxnId();
                this.u = cJRSendMoneyToMerchantResponseModel.getStatusMessage();
                this.v = cJRSendMoneyToMerchantResponseModel.getStatus();
                this.bb.setVisibility(0);
                TextView textView = this.bb;
                textView.setText(this.bU.getResources().getString(R.string.wallet_txn_id) + " " + cJRSendMoneyToMerchantResponseModel.getResponse().getWalletSystemTxnId());
                b(cJRSendMoneyToMerchantResponseModel.getResponse().getWalletSystemTxnId(), (String) null);
                i();
            }
            n();
            TextUtils.isEmpty(cJRSendMoneyToMerchantResponseModel.getOrderId());
            if (cJRSendMoneyToMerchantResponseModel.getResponse() != null && !TextUtils.isEmpty(cJRSendMoneyToMerchantResponseModel.getResponse().getPccCode())) {
                this.R = cJRSendMoneyToMerchantResponseModel.getResponse().getPccCode();
            }
            this.ba.setVisibility(0);
            if (cJRSendMoneyToMerchantResponseModel.getResponse() == null || TextUtils.isEmpty(cJRSendMoneyToMerchantResponseModel.getResponse().getTimestamp())) {
                this.ba.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
            } else {
                this.ba.setText(com.paytm.utility.b.a(Long.valueOf(Long.parseLong(cJRSendMoneyToMerchantResponseModel.getResponse().getTimestamp())), "hh:mm a, dd MMM yyyy"));
            }
            n();
            this.Y.setVisibility(0);
            this.bT.setVisibility(8);
            this.cr.c();
            this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.payment_done_00048));
            m();
            this.bc.setText(this.B);
            String txnAmount = cJRSendMoneyToMerchantResponseModel.getResponse().getTxnAmount();
            if (!TextUtils.isEmpty(txnAmount)) {
                b(new BigDecimal(txnAmount).stripTrailingZeros().toPlainString());
            } else if (!TextUtils.isEmpty(this.D)) {
                b(new BigDecimal(this.D).stripTrailingZeros().toPlainString());
            }
            this.aX.setText(this.bU.getResources().getString(R.string.paid_successfully_to));
            this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.black));
            a(getArguments().getBoolean("is_offline_pg", false), this.D);
            F();
            G();
        } else if (iJRDataModel2 instanceof CJRFastForwardResponse) {
            CJRFastForwardResponse cJRFastForwardResponse = (CJRFastForwardResponse) iJRDataModel2;
            CJRFastForwardResponseDetail fastForwardResponseDetail = cJRFastForwardResponse.getFastForwardResponseDetail();
            String resultMsg = cJRFastForwardResponse.getFastForwardResponseDetail().getResultInfo().getResultMsg();
            this.bS = cJRFastForwardResponse.getHead().getMid();
            this.bQ = fastForwardResponseDetail.getOrderId();
            if (!TextUtils.isEmpty(fastForwardResponseDetail.getOrderId())) {
                this.t = fastForwardResponseDetail.getTxnId();
                this.u = cJRFastForwardResponse.getFastForwardResponseDetail().getResultInfo().getResultMsg();
                this.v = fastForwardResponseDetail.getResultInfo().getResultStatus();
                this.bb.setVisibility(0);
                a(this.bU.getResources().getString(R.string.order_txn_id) + " " + fastForwardResponseDetail.getOrderId(), this.bb);
            } else {
                this.bb.setVisibility(8);
            }
            n();
            TextUtils.isEmpty(fastForwardResponseDetail.getOrderId());
            n();
            if (!TextUtils.isEmpty(cJRFastForwardResponse.getFastForwardResponseDetail().getPrn())) {
                this.aT = true;
                this.S = cJRFastForwardResponse.getFastForwardResponseDetail().getPrn();
                l();
            }
            this.ba.setVisibility(0);
            try {
                if (!TextUtils.isEmpty(cJRFastForwardResponse.getHead().getResponseTimestamp())) {
                    this.ba.setText(com.paytm.utility.b.a(Long.valueOf(Long.parseLong(cJRFastForwardResponse.getHead().getResponseTimestamp())), "hh:mm a, dd MMM yyyy"));
                } else {
                    this.ba.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
                }
            } catch (NumberFormatException unused) {
            }
            b(cJRFastForwardResponse.getFastForwardResponseDetail().getTxnAmount());
            this.bc.setText(this.B);
            String str2 = resultMsg;
            CJRFastForwardResponse cJRFastForwardResponse2 = cJRFastForwardResponse;
            String str3 = "flow_through_pay_icon";
            String str4 = "offline_payments";
            String str5 = "home/pay-send/payment-success";
            bf.a(this.bU, "", a.b.USER_FACING, bf.a(this.cD, this.cA, this.cC, this.cv, this.v, this.cB, this.cE, this.cF), a.c.PAYMENTS);
            if ("PENDING".equals(fastForwardResponseDetail.getResultInfo().getResultStatus()) || "TXN_PENDING".equals(this.v)) {
                String str6 = str2;
                String str7 = str3;
                String str8 = str4;
                this.bg = true;
                this.aX.setText(this.bU.getResources().getString(R.string.payment_pending));
                this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.color_ffa400));
                TextView textView2 = this.bd;
                if (v.a(str6)) {
                    str6 = this.bU.getResources().getString(R.string.payment_pending_desc_msg);
                }
                textView2.setText(str6);
                this.bd.setBackgroundColor(androidx.core.content.b.c(this.bU, R.color.color_fdfbd3));
                this.bd.setVisibility(0);
                this.bT.setVisibility(8);
                if (net.one97.paytm.b.a.c.a().f49484d) {
                    a(str8, "post_payment_pending_shown", "flow_through_scan_icon", getContext(), "home/pay-send/payment-pending");
                } else {
                    a(str8, "post_payment_pending_shown", str7, getContext(), "home/pay-send/payment-pending");
                }
                if (fastForwardResponseDetail.getOrderId() != null) {
                    a(fastForwardResponseDetail.getOrderId(), cJRFastForwardResponse2.getHead().getMid());
                }
            } else if (fastForwardResponseDetail.getResultInfo().getResultStatus().equals("TXN_SUCCESS")) {
                this.bi = true;
                this.bg = false;
                this.bh = false;
                this.aX.setText(this.bU.getResources().getString(R.string.paid_successfully_to));
                this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.black));
                this.Y.setVisibility(0);
                this.ci.setVisibility(0);
                this.bT.setVisibility(8);
                this.cr.c();
                if (this.A != null) {
                    f(SDKConstants.AI_KEY_WALLET);
                }
                if (this.co && this.cq.doubleValue() > 0.0d) {
                    this.bf.setText(String.format(this.bU.getString(R.string.pcf_charged_message), new Object[]{this.cq}));
                    this.bf.setVisibility(0);
                }
                this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.payment_done_00048));
                m();
                this.bd.setVisibility(8);
                a(getArguments().getBoolean("is_offline_pg", false), this.D);
                i();
                if (net.one97.paytm.b.a.c.a().f49484d) {
                    a(str4, "post_payment_success_shown", "flow_through_scan_icon", getContext(), str5);
                } else {
                    a(str4, "post_payment_success_shown", str3, getContext(), str5);
                }
                if (cJRFastForwardResponse2.getFastForwardResponseDetail().getMerchantInfo() != null) {
                    if (!TextUtils.isEmpty(cJRFastForwardResponse2.getFastForwardResponseDetail().getMerchantInfo().getCurrentTxnCount())) {
                        this.bk.setVisibility(0);
                        ((TextView) this.bk.findViewById(R.id.tv_txn_count)).setText(cJRFastForwardResponse2.getFastForwardResponseDetail().getMerchantInfo().getCurrentTxnCount());
                    }
                    this.f70023i = cJRFastForwardResponse2.getFastForwardResponseDetail().getMerchantInfo().getMccCode();
                }
                if (fastForwardResponseDetail != null && !TextUtils.isEmpty(fastForwardResponseDetail.getTxnId())) {
                    b(fastForwardResponseDetail.getTxnId(), (String) null);
                }
                F();
                G();
            } else {
                String str9 = str3;
                String str10 = str4;
                if (fastForwardResponseDetail.getResultInfo().getResultStatus().equals("TXN_FAILURE")) {
                    this.bh = true;
                    this.bg = false;
                    this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.ic_failed_copy));
                    this.Y.setVisibility(0);
                    this.bT.setVisibility(8);
                    this.aX.setText(this.bU.getResources().getString(R.string.payment_failed_wallet));
                    this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.color_fd5c5c));
                    if (v.a(str2)) {
                        this.bd.setVisibility(8);
                    } else {
                        this.bd.setVisibility(0);
                        this.bd.setText(str2);
                    }
                    if (net.one97.paytm.b.a.c.a().f49484d) {
                        a(str10, "post_payment_failure_shown", "flow_through_scan_icon", getContext(), "home/pay-send/payment-failed");
                    } else {
                        a(str10, "post_payment_failure_shown", str9, getContext(), "home/pay-send/payment-failed");
                    }
                }
            }
        } else {
            String str11 = "offline_payments";
            String str12 = "home/pay-send/payment-success";
            String str13 = "flow_through_pay_icon";
            if (iJRDataModel2 instanceof CJRProcessTranscationResponse) {
                CJRProcessTranscationResponse cJRProcessTranscationResponse = (CJRProcessTranscationResponse) iJRDataModel2;
                this.bd.setVisibility(8);
                if (cJRProcessTranscationResponse.getBody() == null || TextUtils.isEmpty(cJRProcessTranscationResponse.getBody().getTxnInfo().getORDERID())) {
                    this.bb.setVisibility(8);
                } else {
                    this.bQ = cJRProcessTranscationResponse.getBody().getTxnInfo().getORDERID();
                    this.v = cJRProcessTranscationResponse.getBody().getTxnInfo().getSTATUS();
                    this.bb.setVisibility(0);
                    a(this.bU.getResources().getString(R.string.order_txn_id) + " " + this.bQ, this.bb);
                }
                n();
                if (cJRProcessTranscationResponse.getBody() != null && cJRProcessTranscationResponse.getBody().getTxnInfo() != null && !TextUtils.isEmpty(cJRProcessTranscationResponse.getBody().getTxnInfo().getTXNAMOUNT())) {
                    b(cJRProcessTranscationResponse.getBody().getTxnInfo().getTXNAMOUNT());
                } else if (!TextUtils.isEmpty(this.D)) {
                    b(cJRProcessTranscationResponse.getBody().getTxnInfo().getTXNAMOUNT());
                }
                this.bc.setText(this.B);
                this.ba.setVisibility(0);
                if (cJRProcessTranscationResponse.getHead() == null || TextUtils.isEmpty(cJRProcessTranscationResponse.getHead().getResponseTimestamp())) {
                    this.ba.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
                } else {
                    this.ba.setText(com.paytm.utility.b.a(Long.valueOf(Long.parseLong(cJRProcessTranscationResponse.getHead().getResponseTimestamp())), "hh:mm a, dd MMM yyyy"));
                }
                n();
                String str14 = "is_offline_pg";
                String str15 = str13;
                String str16 = str12;
                bf.a(this.bU, "", a.b.USER_FACING, bf.a(this.cD, this.cA, this.cC, this.cv, this.v, this.cB, this.cE, this.cF), a.c.PAYMENTS);
                if (this.v.equals("PENDING") || this.v.equals("TXN_PENDING")) {
                    this.bg = true;
                    this.bd.setText(v.a(cJRProcessTranscationResponse.getBody().getResultInfo().getResultMsg()) ? this.bU.getResources().getString(R.string.payment_pending_desc_msg) : cJRProcessTranscationResponse.getBody().getResultInfo().getResultMsg());
                    this.bd.setBackgroundColor(androidx.core.content.b.c(this.bU, R.color.color_fdfbd3));
                    this.bd.setVisibility(0);
                    this.aX.setText(this.bU.getResources().getString(R.string.payment_pending));
                    this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.color_ffa400));
                    this.bT.setVisibility(8);
                    a(cJRProcessTranscationResponse.getBody().getTxnInfo().getORDERID(), cJRProcessTranscationResponse.getBody().getTxnInfo().getMID());
                } else if (this.v.equals("TXN_SUCCESS")) {
                    this.bg = false;
                    this.bh = false;
                    this.bi = true;
                    this.ci.setVisibility(0);
                    this.ck.setVisibility(8);
                    this.aX.setText(this.bU.getResources().getString(R.string.paid_successfully_to));
                    this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.black));
                    this.Y.setVisibility(0);
                    this.bd.setVisibility(8);
                    if (!(cJRProcessTranscationResponse.getBody() == null || cJRProcessTranscationResponse.getBody().getTxnInfo() == null)) {
                        this.bS = cJRProcessTranscationResponse.getBody().getTxnInfo().getMID();
                    }
                    this.cr.c();
                    if (!(cJRProcessTranscationResponse.getBody() == null || TextUtils.isEmpty(cJRProcessTranscationResponse.getBody().getTxnInfo().getPAYMENTMODE()) || this.A == null)) {
                        if (cJRProcessTranscationResponse.getBody().getTxnInfo().getPAYMENTMODE().equals("UPI")) {
                            f("UPI");
                        } else {
                            f("IMPS");
                        }
                    }
                    this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.payment_done_00048));
                    i();
                    m();
                    if (!this.cn || TextUtils.isEmpty(this.cp)) {
                        if (this.co && this.cq.doubleValue() > 0.0d) {
                            this.bf.setText(String.format(this.bU.getString(R.string.pcf_charged_message), new Object[]{this.cq}));
                            this.bf.setVisibility(0);
                        }
                    } else if (!TextUtils.isEmpty(this.cp)) {
                        this.bf.setVisibility(0);
                        this.bf.setText(this.cp);
                    } else {
                        this.bf.setVisibility(8);
                    }
                    if (net.one97.paytm.b.a.c.a().f49484d) {
                        a(str11, "post_payment_success_shown", "flow_through_scan_icon", getContext(), str16);
                    } else {
                        a(str11, "post_payment_success_shown", str15, getContext(), str16);
                    }
                    if (cJRProcessTranscationResponse == null || cJRProcessTranscationResponse.getBody() == null || cJRProcessTranscationResponse.getBody().getTxnInfo() == null) {
                        str = "";
                    } else {
                        str = cJRProcessTranscationResponse.getBody().getTxnInfo().getADDITIONAL_PARAM();
                        this.S = cJRProcessTranscationResponse.getBody().getTxnInfo().getPRN();
                        if (!TextUtils.isEmpty(this.S)) {
                            this.aT = true;
                            l();
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject optJSONObject = new JSONObject(str.replaceAll("\\\\", "")).optJSONObject("merchantInfo");
                            if (optJSONObject != null) {
                                this.f70023i = optJSONObject.optString("mccCode");
                                this.bj = optJSONObject.optString("currentTxnCount");
                                if (!TextUtils.isEmpty(this.bj) && !this.bj.equalsIgnoreCase("null")) {
                                    this.bk.setVisibility(0);
                                    ((TextView) this.bk.findViewById(R.id.tv_txn_count)).setText(this.bj);
                                }
                            }
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                    }
                    a(getArguments().getBoolean(str14, false), this.D);
                    b(cJRProcessTranscationResponse.getBody().getTxnInfo().getBANKTXNID(), cJRProcessTranscationResponse.getBody().getTxnInfo().getORDERID());
                    F();
                    G();
                } else if (this.v.equals("TXN_FAILURE")) {
                    this.bh = true;
                    this.bg = false;
                    this.ck.setVisibility(8);
                    this.bT.setVisibility(8);
                    this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.ic_failed_copy));
                    this.Y.setVisibility(0);
                    this.aX.setText(this.bU.getResources().getString(R.string.payment_failed_wallet));
                    this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.color_fd5c5c));
                    this.bd.setVisibility(0);
                    this.bd.setText(v.a(cJRProcessTranscationResponse.getBody().getResultInfo().getResultMsg()) ? this.bU.getResources().getString(R.string.msg_post_payment_failed_msg) : cJRProcessTranscationResponse.getBody().getResultInfo().getResultMsg());
                    this.bd.setBackgroundColor(androidx.core.content.b.c(this.bU, R.color.color_fdfbd3));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2) {
        this.bQ = str;
        this.bS = str2;
        f(str, str2);
    }

    /* access modifiers changed from: private */
    public void f(final String str, final String str2) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            int i2 = s;
            if (i2 <= r) {
                s = i2 + 1;
                this.ck.setVisibility(0);
                String g2 = g(str, str2);
                net.one97.paytm.j.c.a();
                String e2 = com.paytm.utility.b.e((Context) this.bU, net.one97.paytm.j.c.H());
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = this.bU;
                bVar.f42878b = a.c.PAYMENTS;
                bVar.f42879c = a.C0715a.POST;
                bVar.n = a.b.SILENT;
                bVar.o = "FJRNoblePaymentFragment";
                bVar.f42884h = g2;
                bVar.f42882f = null;
                bVar.f42880d = e2;
                bVar.x = 0;
                int i3 = 5;
                if (s > 5) {
                    i3 = 30;
                }
                bVar.w = net.one97.paytm.wallet.utility.a.a(i3);
                bVar.f42885i = new CJRMerchantTransactionStatusResponse();
                bVar.j = new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        g.this.p();
                        CJRMerchantTransactionStatusResponse cJRMerchantTransactionStatusResponse = (CJRMerchantTransactionStatusResponse) iJRPaytmDataModel;
                        if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getPRN())) {
                            boolean unused = g.this.aT = true;
                            String unused2 = g.this.S = cJRMerchantTransactionStatusResponse.getResponse().getPRN();
                            g.this.l();
                        }
                        if (cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equals("TXN_SUCCESS")) {
                            g.this.ck.setVisibility(8);
                            g.this.aX.setText(g.this.bU.getResources().getString(R.string.paid_successfully_to));
                            g.this.aX.setTextColor(androidx.core.content.b.c(g.this.bU, R.color.black));
                            g.this.bd.setVisibility(8);
                            g.this.Y.setVisibility(0);
                            g.this.bT.setVisibility(8);
                            g.this.cr.c();
                            if (!(cJRMerchantTransactionStatusResponse.getResponse() == null || TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getPAYMENTMODE()) || g.this.A == null)) {
                                if (cJRMerchantTransactionStatusResponse.getResponse().getPAYMENTMODE().equals("UPI")) {
                                    g.this.f("UPI");
                                } else {
                                    g.this.f("IMPS");
                                }
                            }
                            if (g.this.co && g.this.cq.doubleValue() > 0.0d) {
                                g.this.bf.setText(String.format(g.this.bU.getString(R.string.pcf_charged_message), new Object[]{g.this.cq}));
                                g.this.bf.setVisibility(0);
                            }
                            g.this.Y.setBackground(androidx.core.content.b.a((Context) g.this.bU, (int) R.drawable.payment_done_00048));
                            g.this.aH.setVisibility(8);
                            if (net.one97.paytm.b.a.c.a().f49484d) {
                                g.a("offline_payments", "post_payment_success_shown", "flow_through_scan_icon", g.this.getContext(), "home/pay-send/payment-success");
                            } else {
                                g.a("offline_payments", "post_payment_success_shown", "flow_through_pay_icon", g.this.getContext(), "home/pay-send/payment-success");
                            }
                            g.this.m();
                            if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getTXNID())) {
                                g.this.b(cJRMerchantTransactionStatusResponse.getResponse().getTXNID(), (String) null);
                            }
                        } else if (cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equalsIgnoreCase("FAILED") || cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equalsIgnoreCase("TXN_FAILURE")) {
                            g.this.ck.setVisibility(8);
                            g.this.Y.setVisibility(0);
                            g.this.bT.setVisibility(8);
                            g.this.Y.setBackground(androidx.core.content.b.a((Context) g.this.bU, (int) R.drawable.ic_failed));
                            g.this.aX.setText(g.this.bU.getResources().getString(R.string.payment_failed_wallet));
                            g.this.aX.setTextColor(androidx.core.content.b.c(g.this.bU, R.color.color_fd5c5c));
                            g.this.bd.setVisibility(0);
                            if (cJRMerchantTransactionStatusResponse.getResponse().getRESPCODE().equals("334")) {
                                g.this.bd.setText(g.this.bU.getResources().getString(R.string.orderId_is_invalid_msg));
                            } else if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getRESPMSG())) {
                                g.this.bd.setText(cJRMerchantTransactionStatusResponse.getResponse().getRESPMSG());
                            } else {
                                g.this.bd.setText(g.this.bU.getResources().getString(R.string.msg_post_payment_failed_msg));
                            }
                            g.this.bd.setBackgroundColor(androidx.core.content.b.c(g.this.bU, R.color.color_fdfbd3));
                        } else if (g.s > 5) {
                            g.this.ck.setVisibility(8);
                            g.this.Y.setVisibility(0);
                            g.this.Y.setBackground(androidx.core.content.b.a((Context) g.this.bU, (int) R.drawable.pending));
                            if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getRESPMSG())) {
                                g.this.bd.setText(cJRMerchantTransactionStatusResponse.getResponse().getRESPMSG());
                            }
                        } else {
                            new Handler().postDelayed(new Runnable() {
                                public final void run() {
                                    g.this.a(str, str2);
                                }
                            }, (long) g.q);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (!networkCustomError.mErrorType.equals(NetworkCustomError.ErrorType.TimeOutError)) {
                            return;
                        }
                        if (g.s > 5) {
                            g.this.ck.setVisibility(8);
                            g.this.Y.setVisibility(0);
                            g.this.Y.setBackground(androidx.core.content.b.a((Context) g.this.bU, (int) R.drawable.pending));
                            return;
                        }
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                g.this.a(str, str2);
                            }
                        }, (long) g.q);
                    }
                };
                this.p = bVar.l();
                if (com.paytm.utility.a.m(getContext())) {
                    this.p.a();
                    return;
                }
                return;
            }
            if (net.one97.paytm.b.a.c.a().f49484d) {
                a("offline_payments", "post_payment_pending_shown", "flow_through_scan_icon", getContext(), "home/pay-send/payment-pending");
            } else {
                a("offline_payments", "post_payment_pending_shown", "flow_through_pay_icon", getContext(), "home/pay-send/payment-pending");
            }
            this.ck.setVisibility(8);
            this.Y.setVisibility(0);
            this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.ic_pending_copy));
        }
    }

    private String g(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.put("mid", str2);
            jSONObject.put("version", "V1");
            jSONObject.put(SDKConstants.KEY_REQUEST_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("requestId", com.paytm.utility.b.v((Context) this.bU) + System.currentTimeMillis());
            jSONObject.put("clientId", com.paytm.utility.b.k());
            jSONObject.put(StringSet.token, t.b((Context) this.bU));
            jSONObject.put("tokenType", SDKConstants.SSO);
            jSONObject2.put("ORDERID", str);
            jSONObject3.put("head", jSONObject);
            jSONObject3.put("body", jSONObject2);
        } catch (JSONException e2) {
            q.b(e2.getMessage());
        } catch (Exception unused) {
        }
        return jSONObject3.toString();
    }

    /* access modifiers changed from: private */
    public void p() {
        try {
            if (this.bR != null && this.bR.isShowing()) {
                this.bR.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void a(View view) {
        net.one97.paytm.landingpage.hometabs.a.a();
        this.bl = net.one97.paytm.landingpage.hometabs.a.b();
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.parent_layout_bottom);
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        int i2 = 0;
        while (true) {
            HomeTabItem[] homeTabItemArr = this.bl;
            if (i2 < homeTabItemArr.length) {
                HomeTabItem homeTabItem = homeTabItemArr[i2];
                View inflate = this.bU.getLayoutInflater().inflate(R.layout.home_tab_item_layout, (ViewGroup) null, false);
                inflate.setTag(homeTabItem);
                inflate.setOnClickListener(this.cH);
                ((ImageView) inflate.findViewById(R.id.tab_img)).setImageDrawable(homeTabItem.getIcon());
                TextView textView = (TextView) inflate.findViewById(R.id.tab_txt);
                textView.setText(homeTabItem.getText());
                textView.setTextColor(androidx.core.content.b.b(this.bU, homeTabItem.getTextColorResource()));
                this.bm.put(homeTabItem.getUrlType(), inflate);
                inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
                linearLayout.addView(inflate, i2);
                i2++;
            } else {
                net.one97.paytm.utils.l.a((ViewGroup) linearLayout);
                return;
            }
        }
    }

    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        if (view.getId() == R.id.add_money_view) {
            net.one97.paytm.wallet.newdesign.a.a();
            new String[]{"wallet"};
            net.one97.paytm.wallet.newdesign.a.a((Activity) getActivity());
            if (net.one97.paytm.b.a.c.a().f49484d) {
                a("offline_payments", "post_payment_addmoney_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/");
            } else {
                a("offline_payments", "post_payment_addmoney_clicked", "flow_through_pay_icon", getContext(), "home/pay-send/");
            }
        } else if (view.getId() == R.id.contact_us_view) {
            w();
            this.bU.finish();
        } else if (view.getId() == R.id.passbook_view) {
            net.one97.paytm.payments.d.a.a(getContext(), "paytmmp://cash_wallet?featuretype=cash_ledger");
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.bK;
            if (z2) {
                str2 = "UPI_p2m_clicked";
                str3 = "passbook_landing_page";
                str = "summary screen - p2m-upi/summary";
            } else if (this.bG || z2) {
                str3 = null;
                str2 = null;
                str = null;
            } else {
                if (this.bi) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/wallet/pay-send/success");
                        hashMap.put("event_category", "wallet_send_money");
                        hashMap.put("event_action", "wallet_p2m_clicked");
                        hashMap.put("vertical_name", "wallet");
                        hashMap.put("event_label", "p2m");
                        hashMap.put("user_id", com.paytm.utility.a.a((Context) this.bU));
                        net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this.bU);
                    } catch (Exception unused) {
                    }
                }
                str = "summary screen - p2m-wallet/summary";
                str3 = "passbook_landing_page";
                str2 = "wallet_p2m_clicked";
            }
            if (this.bi) {
                arrayList.add("success");
                if (net.one97.paytm.b.a.c.a().f49484d) {
                    a("offline_payments", "post_payment_viewpassbook_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/");
                } else {
                    a("offline_payments", "post_payment_viewpassbook_clicked", "flow_through_pay_icon", getContext(), "home/pay-send/");
                }
            } else if (this.bg) {
                arrayList.add(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING);
            } else {
                arrayList.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            }
            if (!v.a(str)) {
                net.one97.paytm.j.a.a(getContext(), str3, str2, (ArrayList<String>) arrayList, (String) null, str, "passbook");
            }
        } else if (view.getId() == R.id.resend_confirmation_payment) {
            if (getArguments().getBoolean("is_offline_pg", false) && this.bn) {
                b(d.bO, d.by, d.ce);
                o oVar = new o();
                Bundle bundle = new Bundle();
                bundle.putString(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, this.t);
                bundle.putString("merchant_id", this.bS);
                bundle.putString("order_id", this.bQ);
                bundle.putString("mobileNumber", this.T);
                bundle.putString("merchant_name", this.B);
                oVar.setArguments(bundle);
                oVar.show(getFragmentManager(), (String) null);
                if (net.one97.paytm.b.a.c.a().f49484d) {
                    a("offline_payments", "resend_merchant_notification_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/");
                } else {
                    a("offline_payments", "resend_merchant_notification_clicked", "flow_through_pay_icon", getContext(), "home/pay-send/");
                }
            } else if (!"p2m".equalsIgnoreCase(this.L) || !this.bn) {
                b(d.bO, d.bz, d.cf);
                w();
            } else {
                b(d.bO, d.by, d.ce);
                x();
                net.one97.paytm.j.c.a();
                String u2 = net.one97.paytm.j.c.u();
                HashMap hashMap2 = new HashMap();
                HashMap hashMap3 = new HashMap();
                hashMap2.put("ssotoken", t.b((Context) this.bU));
                net.one97.paytm.common.b.d.a(getContext(), u2, new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        g.this.c();
                        if (iJRPaytmDataModel instanceof CJRObdResponse) {
                            CJRObdResponse cJRObdResponse = (CJRObdResponse) iJRPaytmDataModel;
                            if (cJRObdResponse.getStatusCode() == null || !cJRObdResponse.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                                String format = String.format(g.this.bU.getResources().getString(R.string.could_not_initiate), new Object[]{g.this.B});
                                new SpannableString(format).setSpan(new ForegroundColorSpan(g.this.getResources().getColor(R.color.brownish_grey)), 0, format.length(), 33);
                                return;
                            }
                            g.this.bo.removeCallbacks(g.this.cI);
                        }
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        if (g.this.bU != null && !g.this.bU.isFinishing() && g.this.isResumed()) {
                            g.this.c();
                        }
                    }
                }, hashMap2, hashMap3, a.C0715a.POST, y(), new CJRObdResponse(), a.c.PAYMENTS, a.b.SILENT).a();
            }
        } else if (view.getId() == R.id.share_layout || view.getId() == R.id.tv_share) {
            u();
        } else if (view.getId() == R.id.noble_km) {
            m mVar = new m();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("is_money_paid", this.n);
            bundle2.putSerializable("donate_item", this.Z);
            bundle2.putInt("amount_paid", this.o);
            bundle2.putInt("selected_position", this.bt);
            mVar.setArguments(bundle2);
            mVar.show(getActivity().getSupportFragmentManager(), "Dialog");
            mVar.m = this;
        } else if (view.getId() == R.id.id_proceed_to_pay) {
            try {
                this.l = this.ac;
                StringBuilder sb = new StringBuilder();
                sb.append(this.ac);
                e(sb.toString(), "");
            } catch (Exception e2) {
                q.b(e2.getMessage());
                Activity activity = this.bU;
                Toast.makeText(activity, activity.getResources().getString(R.string.unknown_error), 1);
            }
        } else if (view.getId() == R.id.logout) {
            if (net.one97.paytm.b.a.c.a().f49484d) {
                a("offline_payments", "post_payment_logout_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/payment-success");
            } else {
                a("offline_payments", "post_payment_logout_clicked", "flow_through_pay_icon", getContext(), "home/pay-send/payment-success");
            }
            net.one97.paytm.auth.b.b.a(this.bU, false);
            Intent intent = new Intent(this.bU, AJRMainActivity.class);
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            startActivity(intent);
        } else if (view.getId() == R.id.contact_trust_layout) {
            this.bU.startActivity(new Intent(this.bU, AJRTrustSeal.class));
        } else if (view.getId() == R.id.iv_back_button) {
            this.bU.finish();
        } else if (view.getId() == R.id.repeat_payment_view) {
            Intent intent2 = new Intent(this.bU, AJRQRActivity.class);
            intent2.putExtra("OPERATION", "scan");
            intent2.putExtra("scan_result", this.cy);
            intent2.setFlags(536870912);
            intent2.putExtra("is_from_repeat_payment", true);
            this.bU.startActivity(intent2);
            a("offline_payments", "post_payment_repeat_payment_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/payment-success");
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        E();
    }

    private void q() {
        if (!TextUtils.isEmpty(this.cf)) {
            this.W.setText(com.paytm.utility.b.g(this.cf, "yyyy-MM-dd HH:mm:ss", "hh:mm a, dd MMM yyyy"));
        } else {
            this.W.setText(com.paytm.utility.b.a(Long.valueOf(System.currentTimeMillis()), "hh:mm a, dd MMM yyyy"));
        }
    }

    private void r() {
        try {
            net.one97.paytm.j.c.a();
            String x2 = net.one97.paytm.j.c.x();
            if (x2 == null) {
                return;
            }
            if (URLUtil.isValidUrl(x2)) {
                String e2 = com.paytm.utility.b.e((Context) this.bU, x2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request", new JSONObject().put("isDetailInfo", H5Param.DEFAULT_LONG_PRESSO_LOGIN));
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", t.b((Context) this.bU));
                hashMap.put("Accept-Encoding", "gzip");
                new StringBuilder("SSO Token :: ").append(t.b((Context) this.bU));
                com.paytm.utility.a.c();
                if (com.paytm.utility.a.m(this.bU)) {
                    net.one97.paytm.common.b.d.a(getContext(), e2, new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            if (iJRPaytmDataModel instanceof CJRCashWallet) {
                                CJRCashWallet cJRCashWallet = (CJRCashWallet) iJRPaytmDataModel;
                                Double valueOf = Double.valueOf(cJRCashWallet.getResponse().getTotalBalance());
                                if (g.this.I) {
                                    valueOf = Double.valueOf(cJRCashWallet.getResponse().getPaytmWalletBalance());
                                }
                                g.this.aG.setText(g.this.bU.getResources().getString(R.string.updated_wallet_balance));
                                String concat = FilterPriceSliderFragment.RUPEE_SYMBOL.concat(String.valueOf(valueOf));
                                if (!g.this.bL) {
                                    g.this.ak.setVisibility(0);
                                }
                                g.this.F.setVisibility(0);
                                g.this.F.setText(concat);
                            }
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            if (g.this.bU != null && !g.this.bU.isFinishing() && g.this.isResumed()) {
                                g.this.c();
                            }
                        }
                    }, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new CJRCashWallet(), a.c.HOME, a.b.SILENT).a();
                }
            }
        } catch (Exception e3) {
            q.b(e3.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        boolean z2;
        boolean z3;
        this.aG.setText(this.bU.getResources().getString(R.string.fetching_balance));
        this.aG.setVisibility(0);
        if (!com.paytm.utility.a.m(this.bU)) {
            this.aG.setText(this.bU.getResources().getString(R.string.connecting_to_internet));
        }
        if (this.bV) {
            this.bW.setVisibility(8);
            C();
            return;
        }
        boolean z4 = this.bK;
        if (!z4 && !(z2 = this.bM) && !(z3 = this.bZ)) {
            if (z4 || z2 || z3) {
                A();
            } else if (this.bG || z4) {
                if (this.bG) {
                    net.one97.paytm.j.c.a();
                    if (net.one97.paytm.j.c.a("paytmPaymentBankEnabled", false)) {
                        this.bW.setVisibility(8);
                        t();
                        return;
                    }
                }
                this.aG.setVisibility(8);
            } else {
                r();
            }
        }
    }

    private void t() {
        if (com.paytm.utility.a.m(this.bU)) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            net.one97.paytm.payments.b.a.a.a(this.bU, this, a.c.PAY, a.b.USER_FACING, hashMap).a();
        }
    }

    private void u() {
        Activity activity;
        if (!s.a() || (activity = this.bU) == null || activity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.SUBJECT", this.bU.getResources().getString(R.string.post_payment_share_subject));
                intent.putExtra("android.intent.extra.TEXT", v());
                String insertImage = MediaStore.Images.Media.insertImage(this.bU.getContentResolver(), b(this.X), this.bU.getResources().getString(R.string.title), (String) null);
                if (insertImage != null) {
                    intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                    Intent createChooser = Intent.createChooser(intent, this.bU.getResources().getString(R.string.post_payment_share_title));
                    if (createChooser.resolveActivity(this.bU.getPackageManager()) != null) {
                        startActivity(createChooser);
                    } else {
                        Toast.makeText(this.bU, this.bU.getResources().getString(R.string.no_app_found), 1).show();
                    }
                    if (net.one97.paytm.b.a.c.a().f49484d) {
                        a("offline_payments", "post_payment_share_clicked", "flow_through_scan_icon", getContext(), "home/pay-send/payment-share");
                    } else {
                        a("offline_payments", "post_payment_share_clicked", "flow_through_pay_icon", getContext(), "home/pay-send/payment-share");
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        } else {
            s.b(this.bU);
            Activity activity2 = this.bU;
            Toast.makeText(activity2, activity2.getResources().getString(R.string.permission_not_granted), 0).show();
        }
    }

    private static Bitmap b(View view) {
        View findViewById = view.findViewById(R.id.rl_top_layout);
        Bitmap createBitmap = Bitmap.createBitmap(findViewById.getWidth(), findViewById.getHeight(), Bitmap.Config.ARGB_8888);
        findViewById.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private String v() {
        int i2 = this.H;
        if (i2 == 1) {
            net.one97.paytm.j.c.a();
            return net.one97.paytm.j.c.a("GTM_SHARE_BUTTON_TEXT_MESSAGE_P2P", (String) null);
        } else if (i2 == 2) {
            net.one97.paytm.j.c.a();
            return net.one97.paytm.j.c.a("GTM_SHARE_BUTTON_TEXT_MESSAGE_P2B", (String) null);
        } else if (i2 != 3) {
            return getString(R.string.post_payment_p2p_message) + " http://m.p-y.tm";
        } else {
            boolean z2 = this.bi;
            if (!z2 && (this.bg || this.bh || z2)) {
                return "";
            }
            net.one97.paytm.j.c.a();
            return net.one97.paytm.j.c.a("GTM_SHARE_BUTTON_TEXT_MESSAGE_P2M", (String) null);
        }
    }

    private void w() {
        x();
        if (this.bK) {
            CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
            cJRReplacementReason.setIssueText("UPI");
            cJRReplacementReason.setId(UpiConstants.CST_UPI_ID);
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, (Serializable) null);
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, cJRReplacementReason);
            net.one97.paytm.deeplink.d.a((Context) this.bU, bundle, (m) this);
            return;
        }
        CJRReplacementReason cJRReplacementReason2 = new CJRReplacementReason();
        cJRReplacementReason2.setIssueText("Wallet");
        cJRReplacementReason2.setId(1000003);
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, cJRReplacementReason2);
        net.one97.paytm.deeplink.d.a((Context) this.bU, bundle2, (m) this);
    }

    private void x() {
        try {
            if (this.N == null) {
                this.N = net.one97.paytm.wallet.utility.a.b(this.bU);
            }
            if (this.N != null && !this.N.isShowing()) {
                this.N.show();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        try {
            if (this.N != null && this.N.isShowing()) {
                this.N.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private String y() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("txnId", this.t);
            jSONObject.put("request", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            q.b(e2.getMessage());
            return jSONObject.toString();
        } catch (Throwable unused) {
            return jSONObject.toString();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 103 && s.a(iArr)) {
            u();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.bq = z();
    }

    private Bundle z() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_back_shown", this.bp);
        return bundle;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle bundle2 = this.bq;
        if (bundle2 == null) {
            bundle2 = z();
        }
        bundle.putBundle("saved_state", bundle2);
    }

    public final void b() {
        this.aj.setVisibility(8);
        this.bt = -1;
        this.k.setVisibility(4);
    }

    public final void a(int i2) {
        this.af.setVisibility(8);
        this.ag.setVisibility(0);
        this.n = true;
        this.o = i2;
        this.ah.setText(this.bU.getResources().getString(R.string.success_amount, new Object[]{Integer.valueOf(i2)}));
    }

    public final void b(int i2) {
        this.l = Integer.valueOf(i2);
        this.k.setVisibility(8);
        StringBuilder sb = new StringBuilder();
        sb.append(this.l);
        e(sb.toString(), "");
        this.n = true;
        this.o = i2;
    }

    public final void c(final int i2) {
        if (i2 != -1) {
            try {
                this.ab.post(new Runnable() {
                    public final void run() {
                        g.this.ab.findViewHolderForAdapterPosition(i2).itemView.performClick();
                    }
                });
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    private void A() {
        if (B()) {
            RelativeLayout relativeLayout = this.bW;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.bY;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
        }
    }

    private boolean B() {
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
            hashMap.put("event_category", d.cr);
            hashMap.put("event_action", d.cq);
            hashMap.put(d.ct, z2 ? d.cj : d.ck);
            hashMap.put("user_id", com.paytm.utility.a.a(getContext()));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, d.cp);
            hashMap.put(d.cv, d.cy);
            hashMap.put(d.cw, d.cl);
            hashMap.put(d.cm, d.cp);
            hashMap.put(d.cn, str);
            hashMap.put(d.co, z2 ? d.cj : d.ck);
            hashMap.put("event_label", str);
            hashMap.put("event_value", str);
            net.one97.paytm.j.a.b(d.cu, (Map<String, Object>) hashMap, (Context) this.bU);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    private void C() {
        net.one97.paytm.j.c.a();
        String K2 = net.one97.paytm.j.c.K();
        if (!TextUtils.isEmpty(K2)) {
            String uri = Uri.parse(K2).buildUpon().appendQueryParameter("fetch_type", "ACCOUNTS").appendQueryParameter("channel", StringSet.Android).appendQueryParameter("version", "2").appendQueryParameter(AppConstants.TAG_SITE_ID, "1").appendQueryParameter(AppConstants.TAG_CHILD_SITE_ID, "1").build().toString();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.bU));
            net.one97.paytm.common.b.d.a(this.bU, uri, this, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new CJRPPUserProfileKycTnc(), a.c.PAYMENTS, a.b.SILENT).a();
        }
    }

    private void b(String str, String str2, String str3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", d.bF + d.cx);
            hashMap.put("event_action", str);
            hashMap.put(d.cw, str2);
            hashMap.put("user_id", com.paytm.utility.a.a(getContext()));
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, d.cx);
            hashMap.put(d.cv, d.ch);
            if (str3 != null) {
                hashMap.put("event_label", str3);
            }
            net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) this.bU);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public final void a(float f2) {
        com.paytm.utility.b.x(getContext().getApplicationContext(), "is_app_rated");
        net.one97.paytm.j.a.a(getContext().getApplicationContext(), "app_rating", Float.toString(f2), "p2m_screen", (String) null, (String) null, (String) null, "app_rating");
        if (f2 < 5.0f) {
            com.paytm.utility.b.a(getContext().getApplicationContext(), "app_rating_less_than_5_star_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(getContext().getApplicationContext(), "app_rating_5_star_timestamp", 0);
            Float valueOf = Float.valueOf(f2);
            ((TextView) this.cl.getView().findViewById(R.id.tv_msg)).setText(this.bU.getResources().getString(R.string.feedback_thanks_msg));
            this.cl.getView().findViewById(R.id.tv_sub_msg).setVisibility(8);
            this.cl.getView().findViewById(R.id.iv_close_icon).setVisibility(8);
            ((AppCompatRatingBar) this.cl.getView().findViewById(R.id.ratingBar)).setRating(valueOf.floatValue());
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    g.this.E();
                }
            }, net.one97.paytm.wallet.utility.a.l(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.bU, "app_rating_thank_you_expire_time")));
        } else {
            E();
            com.paytm.utility.b.a(getContext().getApplicationContext(), "app_rating_5_star_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(getContext().getApplicationContext(), "app_rating_less_than_5_star_timestamp", 0);
            com.paytm.utility.b.ai(getContext().getApplicationContext());
        }
        com.paytm.utility.b.a(getContext().getApplicationContext(), "app_rating_not_now_timestamp", 0);
    }

    public final void a() {
        com.paytm.utility.b.a(getContext().getApplicationContext(), "app_rating_not_now_timestamp", System.currentTimeMillis());
        com.paytm.utility.b.a(getContext().getApplicationContext(), "app_rating_5_star_timestamp", 0);
        com.paytm.utility.b.a(getContext().getApplicationContext(), "app_rating_less_than_5_star_timestamp", 0);
        net.one97.paytm.j.a.a(getContext().getApplicationContext(), "app_rating", "cross_button_clicked", "p2m_screen", (String) null, (String) null, (String) null, "app_rating");
        E();
    }

    /* access modifiers changed from: private */
    public void D() {
        if (this.cl == null) {
            this.cl = new c();
            this.cl.a((net.one97.paytm.common.widgets.a.a) this);
            this.cl.show(getActivity().getSupportFragmentManager(), (String) null);
        }
    }

    protected static void a(String str, String str2, String str3, Context context, String str4) {
        try {
            net.one97.paytm.j.a.a(context, str, str2, str3, (String) null, str4, "offline_payments");
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void E() {
        try {
            if (this.bU != null && !this.bU.isFinishing() && this.cl != null && this.cl.isAdded() && this.cl.isVisible()) {
                this.cl.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (this.bU != null && !isDetached()) {
            if (iJRPaytmDataModel instanceof CustProductList) {
                CustProductList custProductList = (CustProductList) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(custProductList.getIsaStatus()) && !custProductList.getIsaStatus().equals("NOT_APPLIED") && !custProductList.getIsaStatus().equals("LEAD") && !custProductList.getIsaStatus().equals("FAILED") && !custProductList.getIsaStatus().equals("IN_PROGRESS") && !custProductList.getIsaStatus().equals("INITIATED") && !custProductList.getIsaStatus().equals("PENDING") && custProductList.getIsaStatus().equals("ISSUED")) {
                    this.bI = custProductList.getIsaAccNum();
                    if (com.paytm.utility.a.m(this.bU)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("screen_name", getClass().getSimpleName());
                        Activity activity = this.bU;
                        a.c cVar = a.c.PAY;
                        a.b bVar = a.b.USER_FACING;
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("Authorization".toLowerCase(), t.b((Context) activity));
                        hashMap2.put("Content-Type", "application/json");
                        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
                        net.one97.paytm.j.c.a();
                        String a2 = net.one97.paytm.j.c.a(UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW, (String) null);
                        com.paytm.network.b bVar2 = new com.paytm.network.b();
                        bVar2.f42877a = activity;
                        bVar2.f42879c = a.C0715a.GET;
                        bVar2.f42880d = a2;
                        bVar2.f42882f = hashMap2;
                        bVar2.f42885i = new CJRAccountSummary();
                        bVar2.k = false;
                        bVar2.f42878b = cVar;
                        bVar2.o = (String) hashMap.get("screen_name");
                        bVar2.n = bVar;
                        bVar2.f42877a = activity;
                        bVar2.j = new com.paytm.network.listener.b(this) {

                            /* renamed from: a */
                            final /* synthetic */ com.paytm.network.listener.b f59272a;

                            public final void onApiSuccess(
/*
Method generation error in method: net.one97.paytm.payments.b.a.a.2.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, dex: classes6.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.payments.b.a.a.2.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void, class status: UNLOADED
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
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
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
Method generation error in method: net.one97.paytm.payments.b.a.a.2.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, dex: classes6.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.payments.b.a.a.2.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void, class status: UNLOADED
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
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
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
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            
*/
                        };
                        bVar2.l().a();
                    }
                }
            } else if (iJRPaytmDataModel instanceof CJRAccountSummary) {
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) iJRPaytmDataModel;
                if (cJRAccountSummary != null && cJRAccountSummary.getStatus().equalsIgnoreCase("success")) {
                    this.bH = cJRAccountSummary.getAccounts().get(0).getEffectiveBalance();
                    this.aG.setText(this.bU.getResources().getString(R.string.paytm_bank_account_balance));
                    this.ak.setVisibility(0);
                    this.F.setVisibility(0);
                    this.F.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + this.bH);
                }
            } else if (iJRPaytmDataModel instanceof CJRMerchantTransactionStatusResponse) {
                p();
                CJRMerchantTransactionStatusResponse cJRMerchantTransactionStatusResponse = (CJRMerchantTransactionStatusResponse) iJRPaytmDataModel;
                if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getPRN())) {
                    this.aT = true;
                    this.S = cJRMerchantTransactionStatusResponse.getResponse().getPRN();
                    l();
                }
                if (cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equals("TXN_SUCCESS")) {
                    this.ck.setVisibility(8);
                    this.aX.setText(this.bU.getResources().getString(R.string.paid_successfully_to));
                    this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.black));
                    this.bd.setVisibility(8);
                    this.Y.setVisibility(0);
                    this.bT.setVisibility(8);
                    this.cr.c();
                    if (!(cJRMerchantTransactionStatusResponse.getResponse() == null || TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getPAYMENTMODE()) || this.A == null)) {
                        if (cJRMerchantTransactionStatusResponse.getResponse().getPAYMENTMODE().equals("UPI")) {
                            f("UPI");
                        } else {
                            f("IMPS");
                        }
                    }
                    this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.payment_done_00048));
                    this.aH.setVisibility(8);
                    if (net.one97.paytm.b.a.c.a().f49484d) {
                        a("offline_payments", "post_payment_success_shown", "flow_through_scan_icon", getContext(), "home/pay-send/payment-success");
                    } else {
                        a("offline_payments", "post_payment_success_shown", "flow_through_pay_icon", getContext(), "home/pay-send/payment-success");
                    }
                    m();
                    if (!TextUtils.isEmpty(cJRMerchantTransactionStatusResponse.getResponse().getTXNID())) {
                        b(cJRMerchantTransactionStatusResponse.getResponse().getTXNID(), (String) null);
                    }
                    F();
                    G();
                } else if (cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equalsIgnoreCase("FAILED") || cJRMerchantTransactionStatusResponse.getResponse().getSTATUS().equalsIgnoreCase("TXN_FAILURE")) {
                    this.ck.setVisibility(8);
                    this.Y.setVisibility(0);
                    this.bT.setVisibility(8);
                    this.Y.setBackground(androidx.core.content.b.a((Context) this.bU, (int) R.drawable.ic_failed));
                    this.aX.setText(this.bU.getResources().getString(R.string.payment_failed_wallet));
                    this.aX.setTextColor(androidx.core.content.b.c(this.bU, R.color.color_fd5c5c));
                    this.bd.setVisibility(0);
                    this.bd.setText(this.bU.getResources().getString(R.string.msg_post_payment_failed_msg));
                    this.bd.setBackgroundColor(androidx.core.content.b.c(this.bU, R.color.color_fdfbd3));
                } else {
                    this.ck.setVisibility(0);
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            g gVar = g.this;
                            gVar.f(gVar.bQ, g.this.bS);
                        }
                    }, (long) q);
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
                            this.aG.setVisibility(0);
                            this.aG.setText(this.bU.getResources().getString(R.string.updated_postpaid_balance));
                            this.ak.setVisibility(0);
                            this.F.setVisibility(0);
                            this.F.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + cJRPPAccount.getAvailableCreditLimit());
                            return;
                        }
                    }
                }
            }
        }
    }

    private String e(String str) {
        if (str.equalsIgnoreCase("BALANCE")) {
            return this.bU.getResources().getString(R.string.paytm_balance);
        }
        if (str.equalsIgnoreCase("PAYTM_DIGITAL_CREDIT")) {
            return this.bU.getResources().getString(R.string.paytm_postpaid);
        }
        if (str.equalsIgnoreCase(SDKConstants.AI_KEY_PPBL)) {
            return this.bU.getResources().getString(R.string.paytm_payment_bank);
        }
        if (str.equalsIgnoreCase(SDKConstants.CREDIT)) {
            return this.bU.getResources().getString(R.string.credit_card);
        }
        if (str.equalsIgnoreCase(SDKConstants.DEBIT)) {
            return this.bU.getResources().getString(R.string.debit_card);
        }
        if (str.equalsIgnoreCase("UPI")) {
            return this.bU.getResources().getString(R.string.upi);
        }
        return str.equalsIgnoreCase("NET_BANKING") ? this.bU.getResources().getString(R.string.net_banking) : "";
    }

    public void show() {
        x();
    }

    public void dismiss() {
        c();
    }

    /* access modifiers changed from: private */
    public void f(String str) {
        if (!TextUtils.isEmpty(this.A.getString("payee_id")) || !TextUtils.isEmpty(this.A.getString("payer_id"))) {
            SBMarkAsPaid sBMarkAsPaid = new SBMarkAsPaid();
            sBMarkAsPaid.setPaymentMode(str);
            sBMarkAsPaid.setPayeeId(this.A.getString("payee_id"));
            sBMarkAsPaid.setPayerId(this.A.getString("payer_id"));
            sBMarkAsPaid.setTotalAmount(this.A.getString("amount"));
            net.one97.paytm.wallet.splitbill.e.b.a(this.bU, sBMarkAsPaid);
        }
    }

    private void F() {
        j.a().a((Context) getActivity());
        if (this.z) {
            net.one97.paytm.wallet.d.k.a();
            net.one97.paytm.wallet.d.k.a(this.bU, this.B, this.T, this.cd, System.currentTimeMillis(), this.D, "wallet", k.a.NONE);
        }
        RecentDataNetworkManager.uploadRecentPaymentsData(this.bU);
    }

    private void G() {
        String str;
        String str2;
        h hVar = this.cs;
        if (hVar != null && (str = this.cv) != null && (str2 = this.cw) != null) {
            hVar.a(str, str2);
            if (this.cx != null) {
                this.cs.b(com.paytm.utility.a.a((Context) this.bU), this.cx);
            }
        }
    }

    static /* synthetic */ void a(g gVar, String str) {
        Intent intent = new Intent(gVar.bU, AJRMainActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra("CLEAR_MOBILE_DATA", true);
        if (!str.isEmpty()) {
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, str);
        } else {
            intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        }
        intent.putExtra("started_activity_from_recharge", true);
        gVar.startActivity(intent);
        gVar.bU.finish();
    }

    static /* synthetic */ boolean n(g gVar) {
        com.paytm.b.a.a a2 = ag.a(gVar.bU.getApplicationContext());
        int i2 = a2.b("rating", 0, true) == 0 ? 1 : 0;
        a2.a("rating", i2, true);
        return i2 == 0;
    }

    static /* synthetic */ void a(g gVar, MerchantPPReviewData merchantPPReviewData) {
        if (gVar.getChildFragmentManager() != null && gVar.isResumed() && merchantPPReviewData != null) {
            b.a aVar = net.one97.paytm.wallet.rateMerchant.b.f71619a;
            b.a.a(gVar.B, merchantPPReviewData).show(gVar.getChildFragmentManager(), "PostTxnFeedbackFragment");
        }
    }

    static /* synthetic */ void s(g gVar) {
        Activity activity = gVar.bU;
        if (activity != null) {
            new Handler(activity.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    try {
                        if (!g.this.isDetached() && g.this.bU != null && !g.this.aF.booleanValue()) {
                            g.this.Y.setVisibility(0);
                            g.this.Y.setBackground(androidx.core.content.b.a((Context) g.this.bU, (int) R.drawable.icon_ap_success));
                            g.this.bT.setVisibility(8);
                            g.this.bT.cancelAnimation();
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            }, 120000);
        }
    }
}
