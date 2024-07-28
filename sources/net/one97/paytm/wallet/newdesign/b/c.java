package net.one97.paytm.wallet.newdesign.b;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.moneytransfer.PPBPrevalidateResponseModel;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse;
import net.one97.paytm.common.entity.p2p.ExtraData;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.WalletPaymentCallbackListener;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.common.entity.wallet.universalp2p.FetchMerchantUserInfoResponse;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2p.theme.DealsEntity;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.p2p.theme.d;
import net.one97.paytm.p2p.theme.f;
import net.one97.paytm.p2p.theme.g;
import net.one97.paytm.p2p.theme.h;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.splitbill.SBMarkAsPaid;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.ReferralCodeResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ae;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.d.e;
import net.one97.paytm.wallet.d.j;
import net.one97.paytm.wallet.d.l;
import net.one97.paytm.wallet.newdesign.c.b;
import net.one97.paytm.wallet.newdesign.universalp2p.a.a;
import net.one97.paytm.wallet.newdesign.universalp2p.c.a;
import net.one97.paytm.wallet.newdesign.universalp2p.c.b;
import net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;
import net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText;
import net.one97.paytm.wallet.utility.i;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class c extends h implements View.OnClickListener, d, h.a, b, net.one97.paytm.wallet.newdesign.c.d {

    /* renamed from: e  reason: collision with root package name */
    private static final String f70737e = c.class.getSimpleName();
    private LottieAnimationView A;
    /* access modifiers changed from: private */
    public Button B;
    /* access modifiers changed from: private */
    public TextView C;
    private TextView D;
    private TextView E;
    /* access modifiers changed from: private */
    public TextView F;
    /* access modifiers changed from: private */
    public TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    /* access modifiers changed from: private */
    public TextView L;
    private TextView M;
    private TextView N;
    private TextView O;
    private ImageView P;
    /* access modifiers changed from: private */
    public RelativeLayout Q;
    /* access modifiers changed from: private */
    public CustomAmountTextInputEditText R;
    /* access modifiers changed from: private */
    public CommentsEditText S;
    /* access modifiers changed from: private */
    public View T;
    /* access modifiers changed from: private */
    public View U;
    /* access modifiers changed from: private */
    public String V;
    private String W;
    /* access modifiers changed from: private */
    public String X;
    /* access modifiers changed from: private */
    public View Y;
    private TextView Z;

    /* renamed from: a  reason: collision with root package name */
    String f70738a;
    private LinearLayout aA;
    private TextView aB;
    private ImageView aC;
    /* access modifiers changed from: private */
    public Button aD;
    private RelativeLayout aE;
    private ImageView aF;
    private ImageView aG;
    private TextView aH;
    private TextView aI;
    private TextView aJ;
    private LottieAnimationView aK;
    /* access modifiers changed from: private */
    public TextView aL;
    private RelativeLayout aM;
    /* access modifiers changed from: private */
    public boolean aN;
    private TextView aO;
    private boolean aP = false;
    /* access modifiers changed from: private */
    public String aQ;
    private g aR;
    private String aS = "wallet";
    /* access modifiers changed from: private */
    public boolean aT = false;
    /* access modifiers changed from: private */
    public boolean aU = false;
    /* access modifiers changed from: private */
    public String aV;
    /* access modifiers changed from: private */
    public String aW;
    /* access modifiers changed from: private */
    public String aX;
    /* access modifiers changed from: private */
    public String aY;
    private int aZ = net.one97.paytm.wallet.utility.g.PAY_METHOD_NOT_CALLED.getValue();
    /* access modifiers changed from: private */
    public String aa;
    /* access modifiers changed from: private */
    public AppCompatActivity ab;
    private RelativeLayout ac;
    private View ad;
    private RelativeLayout ae;
    /* access modifiers changed from: private */
    public CardView af;
    /* access modifiers changed from: private */
    public LinearLayout ag;
    private LinearLayout ah;
    /* access modifiers changed from: private */
    public LinearLayout ai;
    private TextView aj;
    /* access modifiers changed from: private */
    public ImageView ak;
    /* access modifiers changed from: private */
    public boolean al = true;
    /* access modifiers changed from: private */
    public com.paytm.b.a.a am;
    /* access modifiers changed from: private */
    public RecyclerView an;
    private TextView ao;
    /* access modifiers changed from: private */
    public LinearLayout ap;
    /* access modifiers changed from: private */
    public boolean aq = false;
    /* access modifiers changed from: private */
    public Button ar;
    private TextView as;
    /* access modifiers changed from: private */
    public TextView at;
    private LottieAnimationView au;
    private TextView av;
    private Button aw;
    private ImageView ax;
    private LottieAnimationView ay;
    /* access modifiers changed from: private */
    public LottieAnimationView az;

    /* renamed from: b  reason: collision with root package name */
    public boolean f70739b;
    private boolean bA;
    private boolean bB;
    private boolean bC;
    private boolean bD;
    private TextWatcher bE = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.toString().trim().length() > 0 && charSequence.toString().charAt(charSequence.length() - 1) != '.') {
                c.this.at.setVisibility(8);
            }
            if (c.this.aL != null && !c.this.aq) {
                if (charSequence.toString().length() > 0) {
                    c.this.aL.setTextColor(c.this.ab.getResources().getColor(R.color.color_1d252d));
                } else {
                    c.this.aL.setTextColor(c.this.ab.getResources().getColor(R.color.color_8ba6c1));
                }
            }
            if (!c.this.aq) {
                return;
            }
            if (charSequence.toString().length() > 0) {
                c.this.aL.setAlpha(1.0f);
                c.this.R.setAlpha(1.0f);
                return;
            }
            c.this.aL.setAlpha(0.6f);
            c.this.R.setAlpha(0.6f);
        }
    };
    private TextWatcher bF = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.toString().trim().length() > 0 && charSequence.toString().charAt(charSequence.length() - 1) != '.' && !c.this.aq) {
                c.this.S.setTextColor(c.this.ab.getResources().getColor(R.color.color_1d252d));
            }
            if (charSequence.toString().trim().length() == 0 && !c.this.aq) {
                c.this.S.setTextColor(c.this.ab.getResources().getColor(R.color.color_8ba6c1));
            }
            if (!c.this.aq) {
                return;
            }
            if (charSequence.toString().length() > 0) {
                c.this.S.setAlpha(1.0f);
            } else {
                c.this.S.setAlpha(0.6f);
            }
        }
    };
    private BroadcastReceiver bG = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("CLOSE_P2P_SCREEN") && c.this.isAdded() && c.this.ab != null && !c.this.ab.isFinishing()) {
                c.this.ab.onBackPressed();
            }
        }
    };
    private String bH;
    private String bI;
    private String bJ;
    /* access modifiers changed from: private */
    public boolean bK = false;
    private CJRHomePageItem bL;
    private int ba = i.UPI_NOT_CALLED.getValue();
    private List<UpiProfileDefaultBank> bb = new ArrayList();
    private RelativeLayout bc;
    /* access modifiers changed from: private */
    public boolean bd = false;
    /* access modifiers changed from: private */
    public boolean be = false;
    /* access modifiers changed from: private */
    public boolean bf = false;
    private boolean bg = false;
    /* access modifiers changed from: private */
    public boolean bh = false;
    /* access modifiers changed from: private */
    public boolean bi = false;
    private boolean bj = false;
    private RelativeLayout bk;
    private ThemeData bl;
    /* access modifiers changed from: private */
    public String bm = "";
    private ImageView bn;
    private TextView bo;
    private TextView bp;
    private TextView bq;
    private net.one97.paytm.wallet.newdesign.universalp2p.a.a br;
    /* access modifiers changed from: private */
    public net.one97.paytm.wallet.newdesign.universalp2p.c.a bs;
    /* access modifiers changed from: private */
    public net.one97.paytm.wallet.newdesign.universalp2p.c.b bt;
    private b.c bu;
    private b.C1451b bv;
    private b.C1451b bw;
    /* access modifiers changed from: private */
    public b.f bx;
    private net.one97.paytm.wallet.newdesign.universalp2p.b.a by;
    /* access modifiers changed from: private */
    public d bz;

    /* renamed from: c  reason: collision with root package name */
    public e f70740c;

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.wallet.d.h f70741d;

    /* renamed from: f  reason: collision with root package name */
    private EditText f70742f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f70743g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public AutoCompleteTextView f70744h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f70745i = false;
    /* access modifiers changed from: private */
    public net.one97.paytm.p2p.theme.h j;
    /* access modifiers changed from: private */
    public LinearLayout k;
    /* access modifiers changed from: private */
    public com.paytm.utility.h l;
    private boolean m = false;
    private String n;
    private boolean o;
    private LinearLayout p;
    private TextView q;
    private RecyclerView r;
    private RecyclerView s;
    /* access modifiers changed from: private */
    public LinearLayout t;
    private LinearLayout u;
    private LinearLayout v;
    private RelativeLayout w;
    private LinearLayout x;
    private LinearLayout y;
    /* access modifiers changed from: private */
    public ImageView z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.paytm.utility.b.e((Activity) this.ab);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("mobile")) {
                this.m = arguments.getBoolean("contact_picker", false);
                this.V = arguments.getString("mobile");
            }
            if (arguments.containsKey("MODE")) {
                this.aa = arguments.getString("MODE");
            }
            if (arguments.containsKey("PHONE_NUMBER")) {
                this.V = arguments.getString("PHONE_NUMBER");
            }
            if (arguments.containsKey("AMOUNT")) {
                this.W = arguments.getString("AMOUNT");
            }
            if (arguments.containsKey("NAME")) {
                this.X = arguments.getString("NAME");
            }
            if (arguments.containsKey("ssid")) {
                this.aQ = arguments.getString("ssid");
            }
            if (arguments.containsKey("isFromDeeplink")) {
                this.bC = arguments.getBoolean("isFromDeeplink", false);
            }
            if (arguments.containsKey("isFromScan")) {
                this.bD = arguments.getBoolean("isFromScan", false);
            }
            if (arguments.containsKey("SOURCE") && arguments.containsKey("PAYER_ID") && arguments.containsKey("PAYEE_ID")) {
                if ("SPLIT_BILL".equalsIgnoreCase(arguments.getString("SOURCE"))) {
                    this.aU = true;
                }
                this.aV = arguments.getString("PAYER_ID");
                this.aW = arguments.getString("PAYEE_ID");
            }
            if (arguments.containsKey(UpiConstants.IS_GALLERY_SCAN)) {
                this.bA = arguments.getBoolean(UpiConstants.IS_GALLERY_SCAN);
            }
            if (arguments.containsKey(UpiConstants.IS_MID_SCAN)) {
                this.bB = arguments.getBoolean(UpiConstants.IS_MID_SCAN);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        a(getString(net.one97.paytm.wallet.R.string.trans_status), getString(net.one97.paytm.wallet.R.string.error_invalid_payee_info), getString(net.one97.paytm.wallet.R.string.ok), (android.view.View.OnClickListener) new net.one97.paytm.wallet.newdesign.b.c.AnonymousClass58(r10));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x06f2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
            r10 = this;
            java.lang.String r13 = "paymentmode"
            java.lang.String r0 = "extra_home_data"
            java.lang.String r1 = "transaction_mobile_email"
            int r2 = net.one97.paytm.wallet.R.layout.universal_p2p_fragment_revamp
            r3 = 0
            android.view.View r11 = r11.inflate(r2, r12, r3)
            r10.Y = r11
            r11 = 0
            net.one97.paytm.p2p.theme.h r12 = new net.one97.paytm.p2p.theme.h     // Catch:{ Exception -> 0x001a }
            androidx.appcompat.app.AppCompatActivity r2 = r10.ab     // Catch:{ Exception -> 0x001a }
            r12.<init>(r2, r10)     // Catch:{ Exception -> 0x001a }
            r10.j = r12     // Catch:{ Exception -> 0x001a }
            goto L_0x001c
        L_0x001a:
            r10.j = r11
        L_0x001c:
            boolean r12 = r10.m
            if (r12 == 0) goto L_0x0023
            r10.s()
        L_0x0023:
            androidx.appcompat.app.AppCompatActivity r12 = r10.ab
            int r2 = net.one97.paytm.wallet.R.id.paysend_toolbar
            android.view.View r12 = r12.findViewById(r2)
            androidx.appcompat.widget.Toolbar r12 = (androidx.appcompat.widget.Toolbar) r12
            r2 = 8
            r12.setVisibility(r2)
            int r12 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r12 < r2) goto L_0x004a
            android.view.View r12 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.root_layout
            android.view.View r12 = r12.findViewById(r2)
            android.view.ViewGroup r12 = (android.view.ViewGroup) r12
            android.animation.LayoutTransition r12 = r12.getLayoutTransition()
            r2 = 4
            r12.enableTransitionType(r2)
        L_0x004a:
            android.content.Context r12 = net.one97.paytm.upi.g.d()
            net.one97.paytm.upi.h.a r12 = net.one97.paytm.upi.h.a.a(r12, r11)
            net.one97.paytm.upi.registration.b.a.b r12 = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) r12)
            boolean r12 = r12.e()
            r10.be = r12
            android.content.Context r12 = net.one97.paytm.upi.g.d()
            net.one97.paytm.upi.h.a r11 = net.one97.paytm.upi.h.a.a(r12, r11)
            net.one97.paytm.upi.registration.b.a.b r11 = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) r11)
            boolean r11 = r11.f()
            r10.bf = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_name_wrapper
            android.view.View r11 = r11.findViewById(r12)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            r10.bk = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.root_layout
            android.view.View r11 = r11.findViewById(r12)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            r10.bc = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_selected_payment_instrumentation
            android.view.View r11 = r11.findViewById(r12)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.t = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_selected_payment_instrumentation_new
            android.view.View r11 = r11.findViewById(r12)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.u = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_paymet_instrumentations
            android.view.View r11 = r11.findViewById(r12)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.v = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_p2p_expand_lyt_keyboard_hide
            android.view.View r11 = r11.findViewById(r12)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            r10.w = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.wallet_insufficient_loader
            android.view.View r11 = r11.findViewById(r12)
            com.airbnb.lottie.LottieAnimationView r11 = (com.airbnb.lottie.LottieAnimationView) r11
            r10.A = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_balance_low
            android.view.View r11 = r11.findViewById(r12)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.x = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ivProfileImageView
            android.view.View r11 = r11.findViewById(r12)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r10.z = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_rl_loader_wrapper
            android.view.View r11 = r11.findViewById(r12)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            r10.ac = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_loader_lyt
            android.view.View r11 = r11.findViewById(r12)
            r10.ad = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.rv_uni_outer
            android.view.View r11 = r11.findViewById(r12)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            r10.ae = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.cv_uni_expanded_payment_inst
            android.view.View r11 = r11.findViewById(r12)
            androidx.cardview.widget.CardView r11 = (androidx.cardview.widget.CardView) r11
            r10.af = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_pay_wrapper
            android.view.View r11 = r11.findViewById(r12)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.ag = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_paymet_for_add_and_pay
            android.view.View r11 = r11.findViewById(r12)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.p = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_paytm_balance_addpay_new
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.O = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_uni_add_pay_new
            android.view.View r11 = r11.findViewById(r12)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.y = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_uni_expand_payment_inst_wrapper_new
            android.view.View r11 = r11.findViewById(r12)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.ah = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_uni_expand_payment_inst_new
            android.view.View r11 = r11.findViewById(r12)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.ai = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_2p2_btn_proceed_hide_keyboard
            android.view.View r11 = r11.findViewById(r12)
            android.widget.Button r11 = (android.widget.Button) r11
            r10.B = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.ll_theme_animation
            android.view.View r11 = r11.findViewById(r12)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.ap = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_p2p_inst_metadata
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.C = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_p2p_inst_account_old
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.D = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_p2p_inst_metadata_new
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.E = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_p2p_inst_name
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.H = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_p2p_inst_name_new
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.I = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_p2p_inst_account
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.Z = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.tv_uni_receiver_name
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.F = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.tv_uni_mobile_number
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.G = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.tv_low_balance
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.J = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.tv_low_balance_action
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.K = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.tv_uni_add_msg
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.L = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.tv_uni_payment_method
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.M = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.tv_uni_receiver_payment_metadata
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.N = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_p2p_loader_text
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.as = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.tv_uni_p2p_amount_error
            android.view.View r11 = r11.findViewById(r12)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.at = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.uni_p2p_payment_img
            android.view.View r11 = r11.findViewById(r12)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r10.P = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.iv_back_button
            android.view.View r11 = r11.findViewById(r12)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            r10.Q = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.rv_payment_instrumentations
            android.view.View r11 = r11.findViewById(r12)
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            r10.r = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.rv_no_payment_inst
            android.view.View r11 = r11.findViewById(r12)
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            r10.s = r11
            android.view.View r11 = r10.Y
            int r12 = net.one97.paytm.wallet.R.id.et_amount
            android.view.View r11 = r11.findViewById(r12)
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r11 = (net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText) r11
            r10.R = r11
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r11 = r10.R
            android.text.TextWatcher r12 = r10.bE
            r11.addTextChangedListener(r12)
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r11 = r10.R
            java.lang.String r12 = ""
            r11.setPrefix(r12)
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.et_type_message
            android.view.View r11 = r11.findViewById(r2)
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r11 = (net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText) r11
            r10.S = r11
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r11 = r10.S
            android.text.TextWatcher r2 = r10.bF
            r11.addTextChangedListener(r2)
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.v_uni_et_sep_1
            android.view.View r11 = r11.findViewById(r2)
            r10.T = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.v_uni_et_sep_2
            android.view.View r11 = r11.findViewById(r2)
            r10.U = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_wallet_loader_close
            android.view.View r11 = r11.findViewById(r2)
            com.airbnb.lottie.LottieAnimationView r11 = (com.airbnb.lottie.LottieAnimationView) r11
            r10.au = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_2p2_btn_proceed_open_new
            android.view.View r11 = r11.findViewById(r2)
            android.widget.Button r11 = (android.widget.Button) r11
            r10.ar = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.tv_uni_p2p_continue_add_pay_new
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.av = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_2p2_btn_proceed_open_add_pay_new
            android.view.View r11 = r11.findViewById(r2)
            android.widget.Button r11 = (android.widget.Button) r11
            r10.aw = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_p2p_close_add_pay_new
            android.view.View r11 = r11.findViewById(r2)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r10.ax = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_wallet_loader_add_pay
            android.view.View r11 = r11.findViewById(r2)
            com.airbnb.lottie.LottieAnimationView r11 = (com.airbnb.lottie.LottieAnimationView) r11
            r10.ay = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.lav_lottie_loader
            android.view.View r11 = r11.findViewById(r2)
            com.airbnb.lottie.LottieAnimationView r11 = (com.airbnb.lottie.LottieAnimationView) r11
            r10.az = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_pay_low_baln_layout_more_options
            android.view.View r11 = r11.findViewById(r2)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.aA = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_paytm_balance_more_options
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.aB = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.iv_uni_p2p_close_more_options
            android.view.View r11 = r11.findViewById(r2)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r10.aC = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_2p2_btn_proceed_open_more_options
            android.view.View r11 = r11.findViewById(r2)
            android.widget.Button r11 = (android.widget.Button) r11
            r10.aD = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_p2p_money_will_be_sent_from_your
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.q = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.condensed_p2p_themes
            android.view.View r11 = r11.findViewById(r2)
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            r10.k = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.back_button_ttf_icon
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.ao = r11
            androidx.appcompat.app.AppCompatActivity r11 = r10.ab
            android.content.res.AssetManager r11 = r11.getAssets()
            java.lang.String r2 = "font/back_android.ttf"
            android.graphics.Typeface r11 = android.graphics.Typeface.createFromAsset(r11, r2)
            android.widget.TextView r2 = r10.ao
            java.lang.String r4 = "B"
            r2.setText(r4)
            android.widget.TextView r2 = r10.ao
            r2.setTypeface(r11)
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.thumbnail5
            android.view.View r11 = r11.findViewById(r2)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r10.ak = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.tv_selected_payment_inst_new
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.aj = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.wallet_loader_hide_key_board
            android.view.View r11 = r11.findViewById(r2)
            com.airbnb.lottie.LottieAnimationView r11 = (com.airbnb.lottie.LottieAnimationView) r11
            r10.aK = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.iv_pay_wrapper_drop_down
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.aO = r11
            androidx.appcompat.app.AppCompatActivity r11 = r10.ab
            android.content.res.AssetManager r11 = r11.getAssets()
            java.lang.String r2 = "font/drop_down.ttf"
            android.graphics.Typeface r11 = android.graphics.Typeface.createFromAsset(r11, r2)
            android.widget.TextView r2 = r10.aO
            java.lang.String r4 = "v"
            r2.setText(r4)
            android.widget.TextView r2 = r10.aO
            r2.setTypeface(r11)
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.iv_close_ins_no_options
            android.view.View r11 = r11.findViewById(r2)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r10.bn = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_paytm_balance_low_no_options
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.bo = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.tv_low_balance_metadata
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.bp = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.tv_selected_instrument_pay_using
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.bq = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.rl_uni_p2p_lead_kyc_ins_wrapper
            android.view.View r11 = r11.findViewById(r2)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            r10.aE = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.iv_uni_lead_kyc_icon
            android.view.View r11 = r11.findViewById(r2)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r10.aF = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.iv_close_lead_kyc
            android.view.View r11 = r11.findViewById(r2)
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            r10.aG = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.tv_uni_p2p_lead_kyc_h1
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.aH = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.tv_uni_p2p_lead_kyc_h2
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.aI = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.uni_paytm_balance_lead_kyc
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.aJ = r11
            androidx.appcompat.app.AppCompatActivity r11 = r10.ab
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r11 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.a((android.app.Activity) r11)
            r10.bt = r11
            androidx.recyclerview.widget.RecyclerView r11 = r10.r
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.appcompat.app.AppCompatActivity r4 = r10.ab
            r5 = 1
            r2.<init>(r4, r5, r3)
            r11.setLayoutManager(r2)
            androidx.recyclerview.widget.RecyclerView r11 = r10.s
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            androidx.appcompat.app.AppCompatActivity r4 = r10.ab
            r2.<init>(r4, r5, r3)
            r11.setLayoutManager(r2)
            android.widget.RelativeLayout r11 = r10.Q
            r11.setOnClickListener(r10)
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r11 = r10.bt
            java.lang.String r2 = r10.X
            r11.n = r2
            java.lang.String r2 = r10.V
            r11.o = r2
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.rl_uni_protector
            android.view.View r11 = r11.findViewById(r2)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            r10.aM = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.tv_uni_p2p_rs_symbol
            android.view.View r11 = r11.findViewById(r2)
            android.widget.TextView r11 = (android.widget.TextView) r11
            r10.aL = r11
            android.view.View r11 = r10.Y
            int r2 = net.one97.paytm.wallet.R.id.themeRecycleView
            android.view.View r11 = r11.findViewById(r2)
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            r10.an = r11
            java.lang.String r11 = r10.V
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            java.lang.String r2 = " "
            if (r11 != 0) goto L_0x04bb
            android.widget.TextView r11 = r10.G
            if (r11 == 0) goto L_0x04bb
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r6 = net.one97.paytm.wallet.R.string.paytm_wallet_linked_to
            java.lang.String r6 = r10.getString(r6)
            r4.append(r6)
            r4.append(r2)
            java.lang.String r6 = r10.V
            java.lang.String r6 = r6.trim()
            java.lang.String r6 = a((java.lang.String) r6)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r11.setText(r4)
            android.widget.TextView r11 = r10.G
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r6 = net.one97.paytm.wallet.R.string.tb_pay_tm_wallet_linked_to
            java.lang.String r6 = r10.getString(r6)
            r4.append(r6)
            r4.append(r2)
            java.lang.String r6 = r10.V
            java.lang.String r6 = r6.trim()
            java.lang.String r6 = a((java.lang.String) r6)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r11.setContentDescription(r4)
        L_0x04bb:
            androidx.appcompat.app.AppCompatActivity r11 = r10.ab     // Catch:{ Exception -> 0x070d }
            if (r11 == 0) goto L_0x0719
            android.content.Intent r4 = r11.getIntent()     // Catch:{ Exception -> 0x070d }
            if (r4 == 0) goto L_0x0719
            android.content.Intent r4 = r11.getIntent()     // Catch:{ Exception -> 0x070d }
            boolean r4 = r4.hasExtra(r0)     // Catch:{ Exception -> 0x070d }
            if (r4 == 0) goto L_0x0530
            android.content.Intent r11 = r11.getIntent()     // Catch:{ Exception -> 0x070d }
            java.io.Serializable r11 = r11.getSerializableExtra(r0)     // Catch:{ Exception -> 0x070d }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r11 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r11     // Catch:{ Exception -> 0x070d }
            r10.bL = r11     // Catch:{ Exception -> 0x070d }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r11 = r10.bL     // Catch:{ Exception -> 0x070d }
            if (r11 == 0) goto L_0x0719
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r11 = r10.bL     // Catch:{ Exception -> 0x070d }
            java.lang.String r11 = r11.getPushFeatureType()     // Catch:{ Exception -> 0x070d }
            if (r11 == 0) goto L_0x0719
            java.lang.String r12 = "sendmoneymobile"
            boolean r11 = r11.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x070d }
            if (r11 == 0) goto L_0x0719
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r11 = r10.bL     // Catch:{ Exception -> 0x070d }
            java.lang.String r11 = r11.getP2pmobilenumber()     // Catch:{ Exception -> 0x070d }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r12 = r10.bL     // Catch:{ Exception -> 0x070d }
            java.lang.String r12 = r12.getP2pamount()     // Catch:{ Exception -> 0x070d }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r13 = r10.bL     // Catch:{ Exception -> 0x070d }
            java.lang.String r13 = r13.getP2pcomment()     // Catch:{ Exception -> 0x070d }
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x070d }
            if (r0 != 0) goto L_0x0518
            boolean r0 = net.one97.paytm.wallet.utility.a.c((java.lang.String) r11)     // Catch:{ Exception -> 0x070d }
            if (r0 != 0) goto L_0x0513
            boolean r0 = net.one97.paytm.wallet.utility.a.b((java.lang.String) r11)     // Catch:{ Exception -> 0x070d }
            if (r0 == 0) goto L_0x0518
        L_0x0513:
            android.widget.AutoCompleteTextView r0 = r10.f70744h     // Catch:{ Exception -> 0x070d }
            r0.setText(r11)     // Catch:{ Exception -> 0x070d }
        L_0x0518:
            boolean r11 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x070d }
            if (r11 != 0) goto L_0x0523
            android.widget.EditText r11 = r10.f70743g     // Catch:{ Exception -> 0x070d }
            r11.setText(r12)     // Catch:{ Exception -> 0x070d }
        L_0x0523:
            boolean r11 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x070d }
            if (r11 != 0) goto L_0x0719
            android.widget.EditText r11 = r10.f70742f     // Catch:{ Exception -> 0x070d }
            r11.setText(r13)     // Catch:{ Exception -> 0x070d }
            goto L_0x0719
        L_0x0530:
            android.content.Intent r0 = r11.getIntent()     // Catch:{ Exception -> 0x070d }
            boolean r0 = r0.hasExtra(r13)     // Catch:{ Exception -> 0x070d }
            if (r0 == 0) goto L_0x0719
            android.content.Intent r11 = r11.getIntent()     // Catch:{ Exception -> 0x070d }
            java.lang.String r0 = "bill"
            android.os.Bundle r11 = r11.getBundleExtra(r0)     // Catch:{ Exception -> 0x070d }
            java.lang.String r0 = "APP_EVOKE"
            r10.aa = r0     // Catch:{ Exception -> 0x06f2 }
            r10.bK = r5     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r0 = "[^0-9.]"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r4 = "transaction_amount"
            java.lang.String r4 = r11.getString(r4)     // Catch:{ Exception -> 0x06f2 }
            java.util.regex.Matcher r0 = r0.matcher(r4)     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r12 = r0.replaceAll(r12)     // Catch:{ Exception -> 0x06f2 }
            java.text.DecimalFormat r0 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r4 = "#.00"
            r0.<init>(r4)     // Catch:{ Exception -> 0x06f2 }
            double r6 = java.lang.Double.parseDouble(r12)     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r12 = r0.format(r6)     // Catch:{ Exception -> 0x06f2 }
            double r6 = java.lang.Double.parseDouble(r12)     // Catch:{ Exception -> 0x06f2 }
            java.lang.Double r12 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x06f2 }
            double r6 = r12.doubleValue()     // Catch:{ Exception -> 0x06f2 }
            r8 = 4681608360884174848(0x40f86a0000000000, double:100000.0)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x06d7
            double r6 = r12.doubleValue()     // Catch:{ Exception -> 0x06f2 }
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x06d7
            android.widget.TextView r0 = r10.G     // Catch:{ Exception -> 0x06f2 }
            if (r0 == 0) goto L_0x05fb
            java.lang.String r0 = r11.getString(r1)     // Catch:{ Exception -> 0x06f2 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x06f2 }
            if (r0 != 0) goto L_0x05fb
            java.lang.String r0 = r11.getString(r1)     // Catch:{ Exception -> 0x06f2 }
            r10.bI = r0     // Catch:{ Exception -> 0x06f2 }
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            if (r0 == 0) goto L_0x05c2
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            boolean r0 = r0.isFinishing()     // Catch:{ Exception -> 0x06f2 }
            if (r0 != 0) goto L_0x05c2
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            boolean r0 = r0 instanceof net.one97.paytm.wallet.newdesign.activity.P2PActivity     // Catch:{ Exception -> 0x06f2 }
            if (r0 == 0) goto L_0x05c2
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            net.one97.paytm.wallet.newdesign.activity.P2PActivity r0 = (net.one97.paytm.wallet.newdesign.activity.P2PActivity) r0     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r4 = r10.bI     // Catch:{ Exception -> 0x06f2 }
            r0.f70518g = r4     // Catch:{ Exception -> 0x06f2 }
        L_0x05c2:
            java.lang.String r0 = r11.getString(r1)     // Catch:{ Exception -> 0x06f2 }
            r10.V = r0     // Catch:{ Exception -> 0x06f2 }
            android.widget.TextView r0 = r10.G     // Catch:{ Exception -> 0x06f2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x06f2 }
            r1.<init>()     // Catch:{ Exception -> 0x06f2 }
            int r4 = net.one97.paytm.wallet.R.string.paytm_wallet_linked_to     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r4 = r10.getString(r4)     // Catch:{ Exception -> 0x06f2 }
            r1.append(r4)     // Catch:{ Exception -> 0x06f2 }
            r1.append(r2)     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r2 = r10.V     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r2 = a((java.lang.String) r2)     // Catch:{ Exception -> 0x06f2 }
            r1.append(r2)     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x06f2 }
            r0.setText(r1)     // Catch:{ Exception -> 0x06f2 }
            boolean r0 = r10.t()     // Catch:{ Exception -> 0x06f2 }
            if (r0 != 0) goto L_0x0615
            android.widget.TextView r0 = r10.G     // Catch:{ Exception -> 0x06f2 }
            r0.setEnabled(r3)     // Catch:{ Exception -> 0x06f2 }
            goto L_0x0615
        L_0x05fb:
            int r0 = net.one97.paytm.wallet.R.string.trans_status     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x06f2 }
            int r1 = net.one97.paytm.wallet.R.string.msg_invalid_id     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r1 = r10.getString(r1)     // Catch:{ Exception -> 0x06f2 }
            int r2 = net.one97.paytm.wallet.R.string.ok     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r2 = r10.getString(r2)     // Catch:{ Exception -> 0x06f2 }
            net.one97.paytm.wallet.newdesign.b.c$54 r4 = new net.one97.paytm.wallet.newdesign.b.c$54     // Catch:{ Exception -> 0x06f2 }
            r4.<init>()     // Catch:{ Exception -> 0x06f2 }
            r10.a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2, (android.view.View.OnClickListener) r4)     // Catch:{ Exception -> 0x06f2 }
        L_0x0615:
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r0 = r10.R     // Catch:{ Exception -> 0x06f2 }
            if (r0 == 0) goto L_0x067b
            java.lang.String r0 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x06f2 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x06f2 }
            if (r0 != 0) goto L_0x067b
            java.lang.String r0 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x06f2 }
            r10.bH = r0     // Catch:{ Exception -> 0x06f2 }
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            if (r0 == 0) goto L_0x064b
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            boolean r0 = r0.isFinishing()     // Catch:{ Exception -> 0x06f2 }
            if (r0 != 0) goto L_0x064b
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            boolean r0 = r0 instanceof net.one97.paytm.wallet.newdesign.activity.P2PActivity     // Catch:{ Exception -> 0x06f2 }
            if (r0 == 0) goto L_0x064b
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            net.one97.paytm.wallet.newdesign.activity.P2PActivity r0 = (net.one97.paytm.wallet.newdesign.activity.P2PActivity) r0     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r1 = r10.bH     // Catch:{ Exception -> 0x06f2 }
            r0.f70517f = r1     // Catch:{ Exception -> 0x06f2 }
        L_0x064b:
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r0 = r10.R     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x06f2 }
            r0.setText(r12)     // Catch:{ Exception -> 0x06f2 }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r12 = r10.R     // Catch:{ Exception -> 0x06f2 }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r0 = r10.R     // Catch:{ Exception -> 0x06f2 }
            android.text.Editable r0 = r0.getText()     // Catch:{ Exception -> 0x06f2 }
            int r0 = r0.length()     // Catch:{ Exception -> 0x06f2 }
            r12.setSelection(r0)     // Catch:{ Exception -> 0x06f2 }
            r10.aP = r5     // Catch:{ Exception -> 0x06f2 }
            boolean r12 = r10.u()     // Catch:{ Exception -> 0x06f2 }
            if (r12 == 0) goto L_0x0675
            android.os.Bundle r12 = r10.getArguments()     // Catch:{ Exception -> 0x06f2 }
            int r12 = r12.getInt(r13)     // Catch:{ Exception -> 0x06f2 }
            if (r12 != r5) goto L_0x0695
        L_0x0675:
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r12 = r10.R     // Catch:{ Exception -> 0x06f2 }
            r12.setEnabled(r3)     // Catch:{ Exception -> 0x06f2 }
            goto L_0x0695
        L_0x067b:
            int r12 = net.one97.paytm.wallet.R.string.trans_status     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r12 = r10.getString(r12)     // Catch:{ Exception -> 0x06f2 }
            int r13 = net.one97.paytm.wallet.R.string.msg_invalid_value     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r13 = r10.getString(r13)     // Catch:{ Exception -> 0x06f2 }
            int r0 = net.one97.paytm.wallet.R.string.ok     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x06f2 }
            net.one97.paytm.wallet.newdesign.b.c$56 r1 = new net.one97.paytm.wallet.newdesign.b.c$56     // Catch:{ Exception -> 0x06f2 }
            r1.<init>()     // Catch:{ Exception -> 0x06f2 }
            r10.a((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r0, (android.view.View.OnClickListener) r1)     // Catch:{ Exception -> 0x06f2 }
        L_0x0695:
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r12 = r10.S     // Catch:{ Exception -> 0x06f2 }
            if (r12 == 0) goto L_0x0719
            java.lang.String r12 = "transaction_message"
            java.lang.String r11 = r11.getString(r12)     // Catch:{ Exception -> 0x06f2 }
            r10.bJ = r11     // Catch:{ Exception -> 0x06f2 }
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            if (r11 == 0) goto L_0x06c3
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            boolean r11 = r11.isFinishing()     // Catch:{ Exception -> 0x06f2 }
            if (r11 != 0) goto L_0x06c3
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            boolean r11 = r11 instanceof net.one97.paytm.wallet.newdesign.activity.P2PActivity     // Catch:{ Exception -> 0x06f2 }
            if (r11 == 0) goto L_0x06c3
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()     // Catch:{ Exception -> 0x06f2 }
            net.one97.paytm.wallet.newdesign.activity.P2PActivity r11 = (net.one97.paytm.wallet.newdesign.activity.P2PActivity) r11     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r12 = r10.bJ     // Catch:{ Exception -> 0x06f2 }
            r11.f70519h = r12     // Catch:{ Exception -> 0x06f2 }
        L_0x06c3:
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r11 = r10.S     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r12 = r10.bJ     // Catch:{ Exception -> 0x06f2 }
            r11.setText(r12)     // Catch:{ Exception -> 0x06f2 }
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r11 = r10.S     // Catch:{ Exception -> 0x06f2 }
            r11.setSingleLine(r5)     // Catch:{ Exception -> 0x06f2 }
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r11 = r10.S     // Catch:{ Exception -> 0x06f2 }
            android.text.TextUtils$TruncateAt r12 = android.text.TextUtils.TruncateAt.END     // Catch:{ Exception -> 0x06f2 }
            r11.setEllipsize(r12)     // Catch:{ Exception -> 0x06f2 }
            goto L_0x0719
        L_0x06d7:
            int r11 = net.one97.paytm.wallet.R.string.trans_status     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r11 = r10.getString(r11)     // Catch:{ Exception -> 0x06f2 }
            int r12 = net.one97.paytm.wallet.R.string.error_invalid_amount     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r12 = r10.getString(r12)     // Catch:{ Exception -> 0x06f2 }
            int r13 = net.one97.paytm.wallet.R.string.ok     // Catch:{ Exception -> 0x06f2 }
            java.lang.String r13 = r10.getString(r13)     // Catch:{ Exception -> 0x06f2 }
            net.one97.paytm.wallet.newdesign.b.c$57 r0 = new net.one97.paytm.wallet.newdesign.b.c$57     // Catch:{ Exception -> 0x06f2 }
            r0.<init>()     // Catch:{ Exception -> 0x06f2 }
            r10.a((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (android.view.View.OnClickListener) r0)     // Catch:{ Exception -> 0x06f2 }
            goto L_0x0719
        L_0x06f2:
            int r11 = net.one97.paytm.wallet.R.string.trans_status     // Catch:{ Exception -> 0x070d }
            java.lang.String r11 = r10.getString(r11)     // Catch:{ Exception -> 0x070d }
            int r12 = net.one97.paytm.wallet.R.string.error_invalid_payee_info     // Catch:{ Exception -> 0x070d }
            java.lang.String r12 = r10.getString(r12)     // Catch:{ Exception -> 0x070d }
            int r13 = net.one97.paytm.wallet.R.string.ok     // Catch:{ Exception -> 0x070d }
            java.lang.String r13 = r10.getString(r13)     // Catch:{ Exception -> 0x070d }
            net.one97.paytm.wallet.newdesign.b.c$58 r0 = new net.one97.paytm.wallet.newdesign.b.c$58     // Catch:{ Exception -> 0x070d }
            r0.<init>()     // Catch:{ Exception -> 0x070d }
            r10.a((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (android.view.View.OnClickListener) r0)     // Catch:{ Exception -> 0x070d }
            goto L_0x0719
        L_0x070d:
            r11 = move-exception
            boolean r12 = com.paytm.utility.b.v
            if (r12 == 0) goto L_0x0719
            java.lang.String r11 = java.lang.String.valueOf(r11)
            com.paytm.utility.q.d(r11)
        L_0x0719:
            net.one97.paytm.wallet.d.e r11 = r10.f70740c
            if (r11 != 0) goto L_0x0724
            net.one97.paytm.wallet.d.e r11 = new net.one97.paytm.wallet.d.e
            r11.<init>()
            r10.f70740c = r11
        L_0x0724:
            net.one97.paytm.wallet.d.e r11 = r10.f70740c
            java.lang.String r12 = r10.aa
            r11.b((java.lang.String) r12)
            net.one97.paytm.wallet.d.e r11 = r10.f70740c
            androidx.appcompat.app.AppCompatActivity r12 = r10.ab
            net.one97.paytm.wallet.newdesign.b.c$20 r13 = new net.one97.paytm.wallet.newdesign.b.c$20
            r13.<init>()
            java.lang.String r0 = "P2P_TRANSFER"
            r11.a((android.app.Activity) r12, (java.lang.String) r0, (net.one97.paytm.wallet.f.g) r13)
            android.widget.TextView r11 = r10.L
            net.one97.paytm.wallet.newdesign.b.c$34 r12 = new net.one97.paytm.wallet.newdesign.b.c$34
            r12.<init>()
            r11.setOnClickListener(r12)
            android.view.View r11 = r10.Y     // Catch:{ Exception -> 0x0749 }
            r10.c((android.view.View) r11)     // Catch:{ Exception -> 0x0749 }
            goto L_0x0751
        L_0x0749:
            r11 = move-exception
            java.lang.String r11 = java.lang.String.valueOf(r11)
            com.paytm.utility.q.d(r11)
        L_0x0751:
            android.widget.LinearLayout r11 = r10.ah
            net.one97.paytm.wallet.newdesign.b.c$14 r12 = new net.one97.paytm.wallet.newdesign.b.c$14
            r12.<init>()
            r11.setOnClickListener(r12)
            android.widget.RelativeLayout r11 = r10.w
            net.one97.paytm.wallet.newdesign.b.c$15 r12 = new net.one97.paytm.wallet.newdesign.b.c$15
            r12.<init>()
            r11.setOnClickListener(r12)
            android.widget.LinearLayout r11 = r10.ai
            r11.setVisibility(r3)
            net.one97.paytm.wallet.newdesign.universalp2p.c.a r11 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a()
            r10.bs = r11
            android.widget.Button r11 = r10.ar
            net.one97.paytm.wallet.newdesign.b.c$21 r12 = new net.one97.paytm.wallet.newdesign.b.c$21
            r12.<init>()
            r11.setOnClickListener(r12)
            android.widget.Button r11 = r10.B
            net.one97.paytm.wallet.newdesign.b.c$22 r12 = new net.one97.paytm.wallet.newdesign.b.c$22
            r12.<init>()
            r11.setOnClickListener(r12)
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r11 = r10.R
            net.one97.paytm.wallet.newdesign.b.c$8 r12 = new net.one97.paytm.wallet.newdesign.b.c$8
            r12.<init>()
            r11.setOnEditorActionListener(r12)
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r11 = r10.S
            net.one97.paytm.wallet.newdesign.b.c$9 r12 = new net.one97.paytm.wallet.newdesign.b.c$9
            r12.<init>()
            r11.setOnEditorActionListener(r12)
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r11 = r10.R
            net.one97.paytm.wallet.newdesign.b.c$10 r12 = new net.one97.paytm.wallet.newdesign.b.c$10
            r12.<init>()
            r11.setOnFocusChangeListener(r12)
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r11 = r10.S
            net.one97.paytm.wallet.newdesign.b.c$11 r12 = new net.one97.paytm.wallet.newdesign.b.c$11
            r12.<init>()
            r11.setOnFocusChangeListener(r12)
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r11 = r10.R
            net.one97.paytm.wallet.newdesign.b.c$13 r12 = new net.one97.paytm.wallet.newdesign.b.c$13
            r12.<init>()
            r11.setOnEditTextImeBackListener(r12)
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r11 = r10.R
            net.one97.paytm.wallet.newdesign.b.c$33 r12 = new net.one97.paytm.wallet.newdesign.b.c$33
            r12.<init>()
            r11.setOnClickListener(r12)
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r11 = r10.S
            net.one97.paytm.wallet.newdesign.b.c$44 r12 = new net.one97.paytm.wallet.newdesign.b.c$44
            r12.<init>()
            r11.setOnClickListener(r12)
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r11 = r10.S
            net.one97.paytm.wallet.newdesign.b.c$55 r12 = new net.one97.paytm.wallet.newdesign.b.c$55
            r12.<init>()
            r11.setOnEditTextImeBackListener(r12)
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r11 = r10.R
            net.one97.paytm.wallet.newdesign.b.c$63 r12 = new net.one97.paytm.wallet.newdesign.b.c$63
            r12.<init>()
            r11.setOnKeyListener(r12)
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r11 = r10.S
            net.one97.paytm.wallet.newdesign.b.c$64 r12 = new net.one97.paytm.wallet.newdesign.b.c$64
            r12.<init>()
            r11.setOnKeyListener(r12)
            android.widget.LinearLayout r11 = r10.k
            net.one97.paytm.wallet.newdesign.b.c$65 r12 = new net.one97.paytm.wallet.newdesign.b.c$65
            r12.<init>()
            r11.setOnClickListener(r12)
            androidx.appcompat.app.AppCompatActivity r11 = r10.ab
            android.content.Context r11 = r11.getApplicationContext()
            com.paytm.b.a.a r11 = net.one97.paytm.utils.be.a(r11)
            r10.am = r11
            com.paytm.b.a.a r11 = r10.am
            java.lang.String r12 = "firstTimeP2PTheme"
            boolean r11 = r11.b((java.lang.String) r12, (boolean) r5, (boolean) r3)
            r10.al = r11
            android.view.View r11 = r10.Y
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.b.c.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    /* access modifiers changed from: private */
    public void a(final int i2, int i3) {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.ap.getLayoutParams();
                layoutParams.bottomMargin = com.paytm.utility.b.c(i2);
                c.this.ap.setLayoutParams(layoutParams);
            }
        }, (long) i3);
    }

    private void j() {
        this.k.setVisibility(0);
        DealsEntity a2 = this.aR.a();
        if (a2 != null && a2.getGrid_layout() != null && a2.getGrid_layout().size() >= 3) {
            w.a().a(a2.getGrid_layout().get(0).getImageUrl()).a(this.ab.getResources().getDrawable(R.drawable.p2p_circle_placeholder)).a((ImageView) this.Y.findViewById(R.id.thumbnail2), (com.squareup.picasso.e) null);
            w.a().a(a2.getGrid_layout().get(1).getImageUrl()).a(this.ab.getResources().getDrawable(R.drawable.p2p_circle_placeholder)).a((ImageView) this.Y.findViewById(R.id.thumbnail3), (com.squareup.picasso.e) null);
            w.a().a(a2.getGrid_layout().get(2).getImageUrl()).a(this.ab.getResources().getDrawable(R.drawable.p2p_circle_placeholder)).a((ImageView) this.Y.findViewById(R.id.thumbnail4), (com.squareup.picasso.e) null);
            CJRGridProduct cJRGridProduct = new CJRGridProduct();
            cJRGridProduct.setName("Classic");
            cJRGridProduct.setSelected(true);
            cJRGridProduct.setHasBorder(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cJRGridProduct);
            Iterator<CJRGridProduct> it2 = a2.getGrid_layout().iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
            DealsEntity dealsEntity = new DealsEntity();
            dealsEntity.setGrid_layout(arrayList);
            f fVar = new f(dealsEntity.getGrid_layout(), this.ab, this);
            this.an.setLayoutManager(new LinearLayoutManager(this.ab, 0, false));
            this.an.setAdapter(fVar);
            this.ak.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!c.this.f70745i) {
                        c.this.an.setVisibility(0);
                        c.this.k();
                        if (!c.this.aT) {
                            c cVar = c.this;
                            cVar.a("wallet_send_money", "theme_explored", (Context) cVar.ab, "/wallet/pay-send/mobile");
                            boolean unused = c.this.aT = true;
                        }
                    } else if (c.this.an.getVisibility() == 0) {
                        c.j(c.this);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ab, R.anim.zoom_in);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                c.a((View) c.this.ak);
            }
        });
        this.an.startAnimation(loadAnimation);
        this.f70745i = true;
        if (this.bm.equalsIgnoreCase("")) {
            ((ImageView) this.Y.findViewById(R.id.motif_classic)).setVisibility(0);
        } else {
            ((ImageView) this.Y.findViewById(R.id.motif_classic)).setVisibility(4);
        }
        ((RelativeLayout) this.Y.findViewById(R.id.themeHeader)).setVisibility(0);
        ((ImageView) this.Y.findViewById(R.id.thumbnail1)).setVisibility(4);
        ((ImageView) this.Y.findViewById(R.id.thumbnail2)).setVisibility(4);
        ((ImageView) this.Y.findViewById(R.id.thumbnail3)).setVisibility(4);
        ((ImageView) this.Y.findViewById(R.id.thumbnail4)).setVisibility(4);
    }

    public final void a(ThemeData themeData) {
        this.aq = true;
        ((ImageView) this.Y.findViewById(R.id.motif_classic)).setVisibility(4);
        if (!TextUtils.isEmpty(themeData.getBgcolor()) && themeData.getBgcolor().startsWith("#")) {
            ((FrameLayout) this.Y.findViewById(R.id.bottom_layout)).setBackgroundColor(Color.parseColor(themeData.getBgcolor()));
            this.ae.setBackgroundColor(Color.parseColor(themeData.getBgcolor()));
            this.bk.setBackgroundColor(Color.parseColor(themeData.getBgcolor()));
            a(Color.parseColor(themeData.getBgcolor()));
            this.q.setTextColor(Color.parseColor(themeData.getColor()));
        }
        if (!TextUtils.isEmpty(themeData.getColor()) && themeData.getColor().startsWith("#")) {
            this.F.setTextColor(Color.parseColor(themeData.getColor()));
            this.G.setTextColor(Color.parseColor(themeData.getColor()));
            this.L.setTextColor(Color.parseColor(themeData.getColor()));
            this.aL.setTextColor(Color.parseColor(themeData.getColor()));
            this.R.setTextColor(Color.parseColor(themeData.getColor()));
            this.R.setHintTextColor(Color.parseColor(themeData.getColor()));
            this.S.setTextColor(Color.parseColor(themeData.getColor()));
            this.S.setHintTextColor(Color.parseColor(themeData.getColor()));
            if (this.R.getText().toString().isEmpty()) {
                this.R.setAlpha(0.6f);
                this.aL.setAlpha(0.6f);
            }
            if (this.S.getText().toString().isEmpty()) {
                this.S.setAlpha(0.6f);
            }
            this.N.setTextColor(Color.parseColor(themeData.getColor()));
            this.M.setTextColor(Color.parseColor(themeData.getColor()));
            this.T.setBackgroundColor(Color.parseColor(themeData.getColor()));
            this.U.setBackgroundColor(Color.parseColor(themeData.getColor()));
            this.aj.setTextColor(Color.parseColor(themeData.getColor()));
            this.aj.setTypeface(Typeface.DEFAULT_BOLD);
            this.at.setTextColor(Color.parseColor(themeData.getColor()));
            this.ao.setTextColor(Color.parseColor(themeData.getColor()));
            this.aO.setTextColor(Color.parseColor(themeData.getColor()));
        }
        this.bm = themeData.getThemeId();
        this.bl = themeData;
        l();
        if (themeData.getWhiteNavText() == null || !themeData.getWhiteNavText().equalsIgnoreCase("0")) {
            a((EditText) this.R, Color.parseColor("#ffffff"));
            this.R.setCursorVisible(false);
            a((EditText) this.S, Color.parseColor("#ffffff"));
            this.S.setCursorVisible(false);
        } else {
            this.ab.getWindow().getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
            a((EditText) this.R, Color.parseColor("#000000"));
            this.R.setCursorVisible(false);
            a((EditText) this.S, Color.parseColor("#000000"));
            this.S.setCursorVisible(false);
        }
        if (!TextUtils.isEmpty(themeData.getJsonData())) {
            this.f70738a = themeData.getJsonData();
            this.ap.removeAllViews();
            LottieAnimationView lottieAnimationView = new LottieAnimationView(this.ab);
            lottieAnimationView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.ap.addView(lottieAnimationView);
            this.ap.setVisibility(0);
            lottieAnimationView.setAnimationFromJson(this.f70738a, (String) null);
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
            a(210, 0);
        }
        r();
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (c.this.ab != null) {
                    c.this.ab.runOnUiThread(new Runnable() {
                        public final void run() {
                            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(c.this.af, 200);
                        }
                    });
                }
            }
        }, 300);
    }

    private void a(int i2) {
        Window window;
        AppCompatActivity appCompatActivity = this.ab;
        if (appCompatActivity != null && (window = appCompatActivity.getWindow()) != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                if (decorView != null) {
                    decorView.setSystemUiVisibility(0);
                }
                window.setStatusBarColor(i2);
            }
        }
    }

    public final void a() {
        this.aq = false;
        l();
        this.bm = "";
        Resources resources = this.ab.getResources();
        a(resources.getColor(R.color.color_ffffff));
        this.ab.getWindow().getDecorView().setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        ((ImageView) this.Y.findViewById(R.id.motif_classic)).setVisibility(0);
        ((FrameLayout) this.Y.findViewById(R.id.bottom_layout)).setBackgroundColor(resources.getColor(R.color.color_ffffff));
        this.ae.setBackgroundColor(resources.getColor(R.color.color_ffffff));
        this.bk.setBackgroundColor(resources.getColor(R.color.color_ffffff));
        this.F.setTextColor(resources.getColor(R.color.color_222222));
        this.G.setTextColor(resources.getColor(R.color.color_444444));
        this.L.setTextColor(resources.getColor(R.color.color_00b9f5));
        this.R.setTextColor(resources.getColor(R.color.color_1d252d));
        this.R.setHintTextColor(resources.getColor(R.color.color_8ba6c1));
        this.S.setTextColor(resources.getColor(R.color.color_1d252d));
        this.S.setHintTextColor(resources.getColor(R.color.color_8ba6c1));
        this.R.setAlpha(1.0f);
        this.aL.setAlpha(1.0f);
        this.S.setAlpha(1.0f);
        if (this.R.getText().toString().isEmpty()) {
            this.aL.setTextColor(this.ab.getResources().getColor(R.color.color_8ba6c1));
        } else {
            this.aL.setTextColor(this.ab.getResources().getColor(R.color.color_1d252d));
        }
        if (this.S.getText().toString().isEmpty()) {
            this.S.setTextColor(resources.getColor(R.color.color_8ba6c1));
        }
        a((EditText) this.R, resources.getColor(R.color.color_00b9f5));
        this.R.setCursorVisible(false);
        a((EditText) this.S, resources.getColor(R.color.color_00b9f5));
        this.S.setCursorVisible(false);
        this.N.setTextColor(resources.getColor(R.color.color_444444));
        this.M.setTextColor(resources.getColor(R.color.color_00b9f5));
        this.T.setBackgroundColor(resources.getColor(R.color.color_00b9f5));
        this.U.setBackgroundColor(resources.getColor(R.color.color_00b9f5));
        this.aj.setTextColor(resources.getColor(R.color.color_00b9f5));
        this.aj.setTypeface(Typeface.DEFAULT_BOLD);
        this.q.setTextColor(resources.getColor(R.color.color_000000));
        this.at.setTextColor(resources.getColor(R.color.color_fd5c5c));
        this.ao.setTextColor(resources.getColor(R.color.color_000000));
        this.aO.setTextColor(resources.getColor(R.color.color_00b9f5));
        LinearLayout linearLayout = this.ap;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        r();
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                if (c.this.ab != null) {
                    c.this.ab.runOnUiThread(new Runnable() {
                        public final void run() {
                            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(c.this.af, 200);
                        }
                    });
                }
            }
        }, 300);
    }

    private void a(String str, String str2) {
        net.one97.paytm.wallet.newdesign.universalp2p.c.a aVar = this.bs;
        aVar.f71396h = str;
        aVar.f71395g = str2;
        aVar.m = str2;
        aVar.f71391c = a.C1450a.PROCEED_TO_PAY;
        this.bs.f71390b = a.b.WAlLET_SEND_MONEY;
    }

    /* access modifiers changed from: private */
    public void l() {
        LinearLayout linearLayout = this.ag;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            q();
            this.t.setVisibility(0);
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(this.af, 200);
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.b(this.ag, 200);
        }
    }

    public void onStart() {
        super.onStart();
        this.ab.registerReceiver(this.bG, new IntentFilter("CLOSE_P2P_SCREEN"));
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    /* access modifiers changed from: private */
    public void a(ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList) {
        this.bs.f71389a = a.e.SEND_MONEY;
        String trim = this.S.getText().toString().trim();
        r();
        if (TextUtils.isEmpty(trim)) {
            trim = "";
        }
        String Q2 = com.paytm.utility.b.Q(this.R.getText().toString().trim());
        Intent moneyTransferIntent = net.one97.paytm.wallet.communicator.b.a().getMoneyTransferIntent(this.ab);
        moneyTransferIntent.putExtra(UpiConstants.EXTRA_IS_FROM_UNIV_P2P, true);
        moneyTransferIntent.putExtra("amount", Q2);
        moneyTransferIntent.putExtra("uni_p2p_landing_intent_extra_theme", this.bm);
        moneyTransferIntent.putExtra(UpiConstants.EXTRA_PHONE_NUMBER_FROM_P2P, this.V);
        moneyTransferIntent.putExtra(UpiConstants.EXTRA_UPI_P2P_PAYMENT_ROUTE, this.aa);
        if (!TextUtils.isEmpty(this.aQ)) {
            net.one97.paytm.wallet.communicator.b.a().markAsPaid(this.aQ, "QUICK_PAYMENTS", true, this.ab);
        }
        if (!trim.isEmpty()) {
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_COMMENTS_UNIV_P2P, trim);
        }
        moneyTransferIntent.putExtra(UpiConstants.EXTRA_PAYER_VPA, paymentOptionList.getSourcePayment().getVpaId());
        if (paymentOptionList.getDestinationPayment() != null && paymentOptionList.getDestinationPayment().getVpaId() != null) {
            moneyTransferIntent.putExtra("payee_name", this.bt.f());
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER, paymentOptionList.getDestinationPayment().getVpaId());
            this.bs.f71393e = a.d.UPI_TO_PAYTM_UPI;
        } else if (!(paymentOptionList.getDestinationPayment() == null || paymentOptionList.getDestinationPayment().getBankAccountNumber() == null)) {
            moneyTransferIntent.putExtra("payee_name", this.bt.f());
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_IFSC_UNIV_P2P, paymentOptionList.getDestinationPayment().getIfscCode());
            moneyTransferIntent.putExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER, paymentOptionList.getDestinationPayment().getBankAccountNumber());
            this.bs.f71393e = a.d.UPI_TO_PPB;
        }
        if (paymentOptionList.getSourcePayment() != null) {
            moneyTransferIntent.putExtra("image_url", this.bt.e());
        }
        if (this.bK) {
            moneyTransferIntent.putExtra("from_app_evoke", true);
        }
        if (this.aU) {
            moneyTransferIntent.putExtra("is_from_split_bill", true);
            SBMarkAsPaid sBMarkAsPaid = new SBMarkAsPaid();
            sBMarkAsPaid.setPaymentMode("UPI");
            sBMarkAsPaid.setPayeeId(this.aW);
            sBMarkAsPaid.setPayerId(this.aV);
            sBMarkAsPaid.setTotalAmount(Q2);
            moneyTransferIntent.putExtra("split_bill_data", sBMarkAsPaid);
        }
        if (!TextUtils.isEmpty(paymentOptionList.getSourcePayment().getMpinSet()) && paymentOptionList.getSourcePayment().getCredsAllowed() != null) {
            UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
            upiProfileDefaultBank.setVirtualAddress(paymentOptionList.getSourcePayment().getVpaId());
            BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
            ConsolidatePaymentInstrumentationRes.SourcePayment sourcePayment = paymentOptionList.getSourcePayment();
            bankAccount.setMbeba(sourcePayment.getMpinSet());
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < sourcePayment.getCredsAllowed().size()) {
                try {
                    BankAccountDetails.BankAccountCredentials bankAccountCredentials = new BankAccountDetails.BankAccountCredentials();
                    bankAccountCredentials.setCredsAllowedDLength(sourcePayment.getCredsAllowed().get(i2).getCredsAllowedDLength());
                    bankAccountCredentials.setCredsAllowedDType(sourcePayment.getCredsAllowed().get(i2).getCredsAllowedDType());
                    bankAccountCredentials.setCredsAllowedSubType1(sourcePayment.getCredsAllowed().get(i2).getCredsAllowedSubType());
                    bankAccountCredentials.setCredsAllowedType(sourcePayment.getCredsAllowed().get(i2).getCredsAllowedType());
                    bankAccountCredentials.setDLength1(sourcePayment.getCredsAllowed().get(i2).getDLength());
                    arrayList.add(bankAccountCredentials);
                    i2++;
                } catch (Exception e2) {
                    q.b(e2.toString());
                }
            }
            bankAccount.setBankCredsAllowed(arrayList);
            bankAccount.setAccountType(sourcePayment.getAccountType());
            bankAccount.setAccount(sourcePayment.getBankAccountNumber());
            bankAccount.setBankName(sourcePayment.getBankName());
            bankAccount.setCustomerName(sourcePayment.getDisplayName());
            bankAccount.setIfsc(sourcePayment.getIfscCode());
            bankAccount.setAccRefId(sourcePayment.getAccRefId());
            upiProfileDefaultBank.setDebitBank(bankAccount);
            moneyTransferIntent.putExtra("user_upi_details", upiProfileDefaultBank);
        }
        this.bs.a((Context) this.ab);
        startActivityForResult(moneyTransferIntent, 11);
    }

    private void b(final ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList) {
        String str;
        b.a aVar;
        String str2;
        d dVar = this.bz;
        if (dVar != null) {
            dVar.dismissAllowingStateLoss();
        }
        f();
        String str3 = this.V;
        if (!TextUtils.isEmpty(this.X)) {
            str3 = this.X;
        }
        if (paymentOptionList.getDestinationPayment().getPaymentType().equalsIgnoreCase(b.d.UPI.name())) {
            str2 = paymentOptionList.getDestinationPayment().getVpaId();
            aVar = b.a.VPA;
            str = null;
        } else {
            str2 = paymentOptionList.getDestinationPayment().getBankAccountNumber();
            aVar = b.a.ACCOUNT_NUMBER;
            str = paymentOptionList.getDestinationPayment().getIfscCode();
        }
        View inflate = getLayoutInflater().inflate(R.layout.layout_money_transfer_v2_overlay, (ViewGroup) null);
        final com.google.android.material.bottomsheet.a aVar2 = new com.google.android.material.bottomsheet.a(this.ab);
        aVar2.setContentView(inflate);
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        aVar2.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                from.setState(4);
            }
        });
        from.setState(2);
        from.setPeekHeight(com.paytm.utility.b.b((Activity) this.ab) - com.paytm.utility.b.a(50.0f, (Context) this.ab));
        if (!this.ab.isFinishing()) {
            aVar2.show();
        }
        TextView textView = (TextView) inflate.findViewById(R.id.receiverBankLogoName);
        TextView textView2 = (TextView) inflate.findViewById(R.id.senderBankLogoName);
        ((TextView) inflate.findViewById(R.id.amount_tv)).setText(getString(R.string.rupees) + com.paytm.utility.b.Q(this.R.getText().toString()));
        TextView textView3 = (TextView) inflate.findViewById(R.id.name_tv);
        if (!TextUtils.isEmpty(str3)) {
            textView3.setText(str3);
        } else {
            textView3.setVisibility(8);
        }
        TextView textView4 = (TextView) inflate.findViewById(R.id.account_tv);
        if (TextUtils.isEmpty(str2)) {
            textView4.setVisibility(8);
        } else if (aVar == b.a.ACCOUNT_NUMBER) {
            textView4.setText(getString(R.string.upi_acc_no_prefix) + " " + com.paytm.utility.b.R(UpiUtils.maskNumber(str2)));
        } else if (aVar == b.a.AADHAR) {
            textView4.setText(getString(R.string.aadhaar_no) + " " + com.paytm.utility.b.R(UpiUtils.maskNumber(str2)));
        } else if (aVar == b.a.VPA) {
            textView4.setText(String.format(getString(R.string.money_transfer_upi_without_bold), new Object[]{str2}));
        }
        TextView textView5 = (TextView) inflate.findViewById(R.id.ifsc_tv);
        if (!TextUtils.isEmpty(str)) {
            textView5.setText(getString(R.string.ifsc_code) + " " + str);
        } else {
            textView5.setVisibility(8);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.receiver_bank_iv);
        if (!TextUtils.isEmpty(str)) {
            a(imageView, str);
            textView.setText(paymentOptionList.getDestinationPayment().getBankName());
        } else {
            a(imageView, "UPI");
            textView.setText(getString(R.string.bhim_upi));
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.sender_bank_iv);
        String ifscCode = paymentOptionList.getSourcePayment().getIfscCode();
        String bankName = paymentOptionList.getSourcePayment().getBankName();
        String bankName2 = paymentOptionList.getSourcePayment().getBankName();
        String bankAccountNumber = paymentOptionList.getSourcePayment().getBankAccountNumber();
        if (!TextUtils.isEmpty(ifscCode)) {
            a(imageView2, ifscCode);
            textView2.setText(bankName);
        } else {
            a(imageView2, "UPI");
            textView2.setText(getString(R.string.bhim_upi));
        }
        TextView textView6 = (TextView) inflate.findViewById(R.id.source_name_tv);
        if (!TextUtils.isEmpty(bankName)) {
            textView6.setText(bankName);
        } else {
            textView6.setVisibility(8);
        }
        TextView textView7 = (TextView) inflate.findViewById(R.id.source_account_tv);
        if (!TextUtils.isEmpty(bankAccountNumber)) {
            textView7.setText(getString(R.string.upi_acc_no_prefix) + " " + com.paytm.utility.b.R(UpiUtils.maskNumber(bankAccountNumber)));
        } else {
            textView7.setVisibility(8);
        }
        TextView textView8 = (TextView) inflate.findViewById(R.id.source_account_name);
        if (!TextUtils.isEmpty(bankName2)) {
            textView8.setText(bankName2);
        } else {
            textView8.setVisibility(8);
        }
        textView8.setVisibility(8);
        ((ImageView) inflate.findViewById(R.id.close_iv)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aVar2.cancel();
            }
        });
        inflate.findViewById(R.id.btn_confirm_send_money).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aVar2.cancel();
                if (paymentOptionList.getSourcePayment().getPaymentType().equalsIgnoreCase(b.d.UPI.name())) {
                    c.this.a(paymentOptionList);
                } else {
                    c.b(c.this, paymentOptionList);
                }
            }
        });
    }

    private void a(ImageView imageView, String str) {
        Drawable a2 = androidx.core.content.b.a((Context) this.ab, R.drawable.ic_default_bank);
        if (!TextUtils.isEmpty(str)) {
            if (str.toUpperCase().startsWith("ICIC")) {
                a2 = androidx.core.content.b.a((Context) this.ab, R.drawable.icici);
            } else if (str.toUpperCase().startsWith("KOT")) {
                a2 = androidx.core.content.b.a((Context) this.ab, R.drawable.kotak);
            } else if (str.toUpperCase().startsWith("UTI")) {
                a2 = androidx.core.content.b.a((Context) this.ab, R.drawable.axis);
            } else if (str.toUpperCase().startsWith("HDF")) {
                a2 = androidx.core.content.b.a((Context) this.ab, R.drawable.hdfc);
            } else if (str.toUpperCase().startsWith("SBI")) {
                a2 = androidx.core.content.b.a((Context) this.ab, R.drawable.sbi);
            } else if (str.toUpperCase().startsWith("PNB")) {
                a2 = androidx.core.content.b.a((Context) this.ab, R.drawable.pnb);
            } else if (str.toUpperCase().startsWith("UPI")) {
                a2 = androidx.core.content.b.a((Context) this.ab, R.drawable.ic_bhim);
            } else if (str.toUpperCase().startsWith("PYT")) {
                a2 = androidx.core.content.b.a((Context) this.ab, R.drawable.paytm_logo_money_transfer);
            }
        }
        imageView.setImageDrawable(a2);
    }

    private void b(Boolean bool) {
        Resources resources;
        m();
        this.aM.setVisibility(0);
        this.aM.setClickable(true);
        if (bool == null) {
            this.B.setBackgroundColor(this.ab.getResources().getColor(R.color.grid_offer_blue));
            this.B.setClickable(false);
            try {
                net.one97.paytm.common.widgets.a.a(this.aK);
            } catch (Exception unused) {
            }
        } else if (bool.booleanValue()) {
            d dVar = this.bz;
            Context context = dVar.f70834a;
            if (!(context == null || (resources = context.getResources()) == null)) {
                int color = resources.getColor(R.color.grid_offer_blue);
                Button button = dVar.f70836c;
                if (button == null) {
                    k.a("payButton");
                }
                button.setBackgroundColor(color);
            }
            Button button2 = dVar.f70836c;
            if (button2 == null) {
                k.a("payButton");
            }
            button2.setClickable(false);
            try {
                net.one97.paytm.common.widgets.a.a(dVar.f70835b);
            } catch (Exception unused2) {
            }
        } else {
            this.ar.setBackgroundColor(this.ab.getResources().getColor(R.color.grid_offer_blue));
            this.ar.setClickable(false);
            try {
                net.one97.paytm.common.widgets.a.a(this.au);
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            try {
                m();
                this.aM.setVisibility(0);
                this.aM.setClickable(true);
                this.aw.setBackgroundColor(this.ab.getResources().getColor(R.color.grid_offer_blue));
                this.aw.setClickable(false);
                net.one97.paytm.common.widgets.a.a(this.ay);
            } catch (Exception unused) {
            }
        } else {
            this.aM.setVisibility(8);
            this.aM.setClickable(false);
            this.aw.setBackgroundColor(this.ab.getResources().getColor(R.color.color_00b9f5));
            this.aw.setClickable(true);
            net.one97.paytm.common.widgets.a.b(this.ay);
        }
    }

    public final void a(Boolean bool) {
        Resources resources;
        this.aM.setVisibility(8);
        this.aM.setClickable(false);
        if (bool == null) {
            this.B.setBackgroundColor(this.ab.getResources().getColor(R.color.color_00b9f5));
            this.B.setClickable(true);
            try {
                net.one97.paytm.common.widgets.a.b(this.aK);
            } catch (Exception unused) {
            }
        } else if (bool.booleanValue()) {
            d dVar = this.bz;
            Context context = dVar.f70834a;
            if (!(context == null || (resources = context.getResources()) == null)) {
                int color = resources.getColor(R.color.color_00b9f5);
                Button button = dVar.f70836c;
                if (button == null) {
                    k.a("payButton");
                }
                button.setBackgroundColor(color);
            }
            Button button2 = dVar.f70836c;
            if (button2 == null) {
                k.a("payButton");
            }
            button2.setClickable(true);
            try {
                net.one97.paytm.common.widgets.a.b(dVar.f70835b);
            } catch (Exception unused2) {
            }
        } else {
            this.ar.setBackgroundColor(this.ab.getResources().getColor(R.color.color_00b9f5));
            this.ar.setClickable(true);
            try {
                net.one97.paytm.common.widgets.a.b(this.au);
            } catch (Exception unused3) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Activity activity) {
        net.one97.paytm.wallet.newdesign.addbeneficiary.d a2 = net.one97.paytm.wallet.newdesign.addbeneficiary.d.a();
        a2.f70612a = activity;
        if (activity != null && !activity.isFinishing()) {
            try {
                androidx.fragment.app.q a3 = getChildFragmentManager().a();
                a3.a((Fragment) a2, (String) null);
                a3.c();
            } catch (Exception unused) {
            }
        }
    }

    private void m() {
        if (!TextUtils.isEmpty(this.R.getText().toString())) {
            this.R.setEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        this.R.setEnabled(true);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:66:0x01a4=Splitter:B:66:0x01a4, B:113:0x02ec=Splitter:B:113:0x02ec} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(final java.lang.Boolean r9) {
        /*
            r8 = this;
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r0 = r8.R
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0021
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r0 = r8.R
            android.text.Editable r1 = r0.getText()
            java.lang.String r1 = r1.toString()
            int r1 = r1.length()
            r0.setSelection(r1)
        L_0x0021:
            boolean r0 = r8.f70739b
            if (r0 != 0) goto L_0x02fd
            java.lang.String r0 = ""
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r1 = r8.R     // Catch:{ Exception -> 0x02fd }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = com.paytm.utility.b.Q((java.lang.String) r1)     // Catch:{ Exception -> 0x02fd }
            if (r1 == 0) goto L_0x004d
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r0 = r8.R     // Catch:{ Exception -> 0x02fd }
            android.text.Editable r0 = r0.getText()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r0 = com.paytm.utility.b.Q((java.lang.String) r0)     // Catch:{ Exception -> 0x02fd }
        L_0x004d:
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x02fd }
            r2 = 0
            if (r1 != 0) goto L_0x02ec
            int r1 = r0.length()     // Catch:{ Exception -> 0x02fd }
            r3 = 1
            int r1 = r1 - r3
            char r0 = r0.charAt(r1)     // Catch:{ Exception -> 0x02fd }
            r1 = 46
            if (r0 != r1) goto L_0x0064
            goto L_0x02ec
        L_0x0064:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r8.bt     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$f r1 = r8.bx     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$PaymentOptionList r0 = r0.a((net.one97.paytm.wallet.newdesign.universalp2p.c.b.f) r1)     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r1 = r8.R     // Catch:{ Exception -> 0x02fd }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = com.paytm.utility.b.Q((java.lang.String) r1)     // Catch:{ Exception -> 0x02fd }
            if (r0 == 0) goto L_0x008f
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r4 = r0.getSourcePayment()     // Catch:{ Exception -> 0x02fd }
            if (r4 == 0) goto L_0x008f
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r4 = r0.getSourcePayment()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r4 = r4.getPaymentType()     // Catch:{ Exception -> 0x02fd }
            goto L_0x0091
        L_0x008f:
            java.lang.String r4 = "error"
        L_0x0091:
            r8.a((java.lang.String) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r1 = r0.getSourcePayment()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = r1.getPaymentType()     // Catch:{ Exception -> 0x02fd }
            r4 = -1
            int r5 = r1.hashCode()     // Catch:{ Exception -> 0x02fd }
            r6 = -1741862919(0xffffffff982d47f9, float:-2.2396063E-24)
            r7 = 2
            if (r5 == r6) goto L_0x00c6
            r6 = 84238(0x1490e, float:1.18043E-40)
            if (r5 == r6) goto L_0x00bc
            r6 = 2031164(0x1efe3c, float:2.846267E-39)
            if (r5 == r6) goto L_0x00b2
            goto L_0x00cf
        L_0x00b2:
            java.lang.String r5 = "BANK"
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x02fd }
            if (r1 == 0) goto L_0x00cf
            r4 = 0
            goto L_0x00cf
        L_0x00bc:
            java.lang.String r5 = "UPI"
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x02fd }
            if (r1 == 0) goto L_0x00cf
            r4 = 1
            goto L_0x00cf
        L_0x00c6:
            java.lang.String r5 = "WALLET"
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x02fd }
            if (r1 == 0) goto L_0x00cf
            r4 = 2
        L_0x00cf:
            java.lang.String r1 = "Insufficient Balance"
            r5 = 0
            if (r4 == 0) goto L_0x028c
            if (r4 == r3) goto L_0x022c
            if (r4 == r7) goto L_0x00da
            goto L_0x022b
        L_0x00da:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r8.bt     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r1 = r8.R     // Catch:{ Exception -> 0x02fd }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = com.paytm.utility.b.Q((java.lang.String) r1)     // Catch:{ Exception -> 0x02fd }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x02fd }
            if (r4 != 0) goto L_0x0119
            java.lang.String r4 = r0.j()     // Catch:{ Exception -> 0x02fd }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x02fd }
            if (r4 != 0) goto L_0x0119
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ Exception -> 0x02fd }
            double r6 = r1.doubleValue()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r0 = r0.j()     // Catch:{ Exception -> 0x02fd }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ Exception -> 0x02fd }
            double r0 = r0.doubleValue()     // Catch:{ Exception -> 0x02fd }
            int r0 = java.lang.Double.compare(r6, r0)     // Catch:{ Exception -> 0x02fd }
            if (r0 <= 0) goto L_0x0119
            goto L_0x011a
        L_0x0119:
            r3 = 0
        L_0x011a:
            if (r3 == 0) goto L_0x01a4
            androidx.appcompat.app.AppCompatActivity r0 = r8.ab     // Catch:{ Exception -> 0x02fd }
            boolean r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.a((android.content.Context) r0)     // Catch:{ Exception -> 0x02fd }
            if (r0 != 0) goto L_0x01a4
            r8.b((java.lang.Boolean) r9)     // Catch:{ Exception -> 0x01a3 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.WALLET     // Catch:{ Exception -> 0x01a3 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$f r1 = r8.bx     // Catch:{ Exception -> 0x01a3 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = r1.f71419e     // Catch:{ Exception -> 0x01a3 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x01a3 }
            if (r0 == 0) goto L_0x01a3
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r8.bt     // Catch:{ Exception -> 0x01a3 }
            if (r0 == 0) goto L_0x01a3
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r8.bt     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r0 = r0.j()     // Catch:{ Exception -> 0x01a3 }
            if (r0 == 0) goto L_0x01a3
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r0 = r8.R     // Catch:{ Exception -> 0x01a3 }
            android.text.Editable r0 = r0.getText()     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x01a3 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x01a3 }
            if (r0 != 0) goto L_0x01a3
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r8.bt     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r0 = r0.j()     // Catch:{ Exception -> 0x01a3 }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x01a3 }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ Exception -> 0x01a3 }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r1 = r8.R     // Catch:{ Exception -> 0x01a3 }
            android.text.Editable r1 = r1.getText()     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r1 = com.paytm.utility.b.Q((java.lang.String) r1)     // Catch:{ Exception -> 0x01a3 }
            double r1 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x01a3 }
            double r3 = r0.doubleValue()     // Catch:{ Exception -> 0x01a3 }
            int r0 = java.lang.Double.compare(r1, r3)     // Catch:{ Exception -> 0x01a3 }
            if (r0 <= 0) goto L_0x01a3
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r1 = r8.bt     // Catch:{ Exception -> 0x01a3 }
            androidx.appcompat.app.AppCompatActivity r2 = r8.ab     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r3 = r8.V     // Catch:{ Exception -> 0x01a3 }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r0 = r8.R     // Catch:{ Exception -> 0x01a3 }
            android.text.Editable r0 = r0.getText()     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r4 = com.paytm.utility.b.Q((java.lang.String) r0)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r5 = "ADD_MONEY"
            net.one97.paytm.wallet.newdesign.b.c$40 r6 = new net.one97.paytm.wallet.newdesign.b.c$40     // Catch:{ Exception -> 0x01a3 }
            r6.<init>(r9)     // Catch:{ Exception -> 0x01a3 }
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x01a3 }
        L_0x01a3:
            return
        L_0x01a4:
            android.content.Context r0 = r8.getContext()     // Catch:{ Exception -> 0x02fd }
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)     // Catch:{ Exception -> 0x02fd }
            if (r0 == 0) goto L_0x020e
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02fd }
            androidx.appcompat.app.AppCompatActivity r1 = r8.ab     // Catch:{ Exception -> 0x02fd }
            java.lang.String r3 = r8.V     // Catch:{ Exception -> 0x02fd }
            java.lang.String r0 = r0.getContactName(r1, r3)     // Catch:{ Exception -> 0x02fd }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x02fd }
            if (r0 == 0) goto L_0x0207
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02fd }
            androidx.appcompat.app.AppCompatActivity r1 = r8.ab     // Catch:{ Exception -> 0x02fd }
            java.lang.String r3 = "p2pFraudAlertDialogEnable"
            boolean r0 = r0.getBooleanFromGTM(r1, r3, r2)     // Catch:{ Exception -> 0x02fd }
            if (r0 == 0) goto L_0x0207
            net.one97.paytm.wallet.newdesign.b.a r9 = new net.one97.paytm.wallet.newdesign.b.a     // Catch:{ Exception -> 0x02fd }
            r9.<init>()     // Catch:{ Exception -> 0x02fd }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Exception -> 0x02fd }
            r0.<init>()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = "uni_p2p_btm_sheet_mobile_number"
            java.lang.String r2 = r8.V     // Catch:{ Exception -> 0x02fd }
            r0.putString(r1, r2)     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = "uni_p2p_btm_sheet_amount"
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r2 = r8.R     // Catch:{ Exception -> 0x02fd }
            android.text.Editable r2 = r2.getText()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02fd }
            r0.putString(r1, r2)     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = "uni_p2p_btm_sheet_name"
            java.lang.String r2 = r8.X     // Catch:{ Exception -> 0x02fd }
            r0.putString(r1, r2)     // Catch:{ Exception -> 0x02fd }
            r9.setArguments(r0)     // Catch:{ Exception -> 0x02fd }
            java.lang.String r0 = "listener"
            kotlin.g.b.k.c(r8, r0)     // Catch:{ Exception -> 0x02fd }
            r9.f70712a = r8     // Catch:{ Exception -> 0x02fd }
            androidx.fragment.app.j r0 = r8.getFragmentManager()     // Catch:{ Exception -> 0x02fd }
            r9.show((androidx.fragment.app.j) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x02fd }
            return
        L_0x0207:
            r8.b((java.lang.Boolean) r9)     // Catch:{ Exception -> 0x02fd }
            r8.d((java.lang.Boolean) r9)     // Catch:{ Exception -> 0x02fd }
            return
        L_0x020e:
            net.one97.paytm.wallet.communicator.c r9 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x02fd }
            androidx.appcompat.app.AppCompatActivity r0 = r8.ab     // Catch:{ Exception -> 0x02fd }
            android.content.res.Resources r1 = r8.getResources()     // Catch:{ Exception -> 0x02fd }
            int r2 = net.one97.paytm.wallet.R.string.err_enable_network_heading     // Catch:{ Exception -> 0x02fd }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x02fd }
            android.content.res.Resources r2 = r8.getResources()     // Catch:{ Exception -> 0x02fd }
            int r3 = net.one97.paytm.wallet.R.string.no_internet     // Catch:{ Exception -> 0x02fd }
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x02fd }
            r9.showSnackBar(r0, r1, r2, r8)     // Catch:{ Exception -> 0x02fd }
        L_0x022b:
            return
        L_0x022c:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r9 = r8.bt     // Catch:{ Exception -> 0x02fd }
            java.util.List<net.one97.paytm.wallet.newdesign.universalp2p.c.b$c> r9 = r9.r     // Catch:{ Exception -> 0x02fd }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x02fd }
        L_0x0234:
            boolean r3 = r9.hasNext()     // Catch:{ Exception -> 0x02fd }
            if (r3 == 0) goto L_0x0253
            java.lang.Object r3 = r9.next()     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$c r3 = (net.one97.paytm.wallet.newdesign.universalp2p.c.b.c) r3     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r4 = r0.getSourcePayment()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r4 = r4.getBankAccountNumber()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r6 = r3.getPaymentInstrumentAccount()     // Catch:{ Exception -> 0x02fd }
            boolean r4 = r4.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x02fd }
            if (r4 == 0) goto L_0x0234
            goto L_0x0254
        L_0x0253:
            r3 = r5
        L_0x0254:
            if (r3 == 0) goto L_0x0288
            java.lang.String r9 = r3.getAvailBalance()     // Catch:{ Exception -> 0x02fd }
            if (r9 == 0) goto L_0x0288
            java.lang.String r9 = r3.getAvailBalance()     // Catch:{ Exception -> 0x02fd }
            double r3 = java.lang.Double.parseDouble(r9)     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r9 = r8.R     // Catch:{ Exception -> 0x02fd }
            android.text.Editable r9 = r9.getText()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r9 = r9.trim()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r9 = com.paytm.utility.b.Q((java.lang.String) r9)     // Catch:{ Exception -> 0x02fd }
            double r5 = java.lang.Double.parseDouble(r9)     // Catch:{ Exception -> 0x02fd }
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 >= 0) goto L_0x0288
            androidx.appcompat.app.AppCompatActivity r9 = r8.ab     // Catch:{ Exception -> 0x02fd }
            android.widget.Toast r9 = android.widget.Toast.makeText(r9, r1, r2)     // Catch:{ Exception -> 0x02fd }
            r9.show()     // Catch:{ Exception -> 0x02fd }
            return
        L_0x0288:
            r8.b((net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes.PaymentOptionList) r0)     // Catch:{ Exception -> 0x028b }
        L_0x028b:
            return
        L_0x028c:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r9 = r8.bt     // Catch:{ Exception -> 0x02fd }
            java.util.List<net.one97.paytm.wallet.newdesign.universalp2p.c.b$c> r9 = r9.r     // Catch:{ Exception -> 0x02fd }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x02fd }
        L_0x0294:
            boolean r3 = r9.hasNext()     // Catch:{ Exception -> 0x02fd }
            if (r3 == 0) goto L_0x02b3
            java.lang.Object r3 = r9.next()     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b$c r3 = (net.one97.paytm.wallet.newdesign.universalp2p.c.b.c) r3     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$SourcePayment r4 = r0.getSourcePayment()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r4 = r4.getBankAccountNumber()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r6 = r3.getPaymentInstrumentAccount()     // Catch:{ Exception -> 0x02fd }
            boolean r4 = r4.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x02fd }
            if (r4 == 0) goto L_0x0294
            goto L_0x02b4
        L_0x02b3:
            r3 = r5
        L_0x02b4:
            if (r3 == 0) goto L_0x02e8
            java.lang.String r9 = r3.getAvailBalance()     // Catch:{ Exception -> 0x02fd }
            if (r9 == 0) goto L_0x02e8
            java.lang.String r9 = r3.getAvailBalance()     // Catch:{ Exception -> 0x02fd }
            double r3 = java.lang.Double.parseDouble(r9)     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r9 = r8.R     // Catch:{ Exception -> 0x02fd }
            android.text.Editable r9 = r9.getText()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r9 = r9.trim()     // Catch:{ Exception -> 0x02fd }
            java.lang.String r9 = com.paytm.utility.b.Q((java.lang.String) r9)     // Catch:{ Exception -> 0x02fd }
            double r5 = java.lang.Double.parseDouble(r9)     // Catch:{ Exception -> 0x02fd }
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 >= 0) goto L_0x02e8
            androidx.appcompat.app.AppCompatActivity r9 = r8.ab     // Catch:{ Exception -> 0x02fd }
            android.widget.Toast r9 = android.widget.Toast.makeText(r9, r1, r2)     // Catch:{ Exception -> 0x02fd }
            r9.show()     // Catch:{ Exception -> 0x02fd }
            return
        L_0x02e8:
            r8.b((net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes.PaymentOptionList) r0)     // Catch:{ Exception -> 0x02eb }
        L_0x02eb:
            return
        L_0x02ec:
            android.widget.TextView r9 = r8.at     // Catch:{ Exception -> 0x02fd }
            r9.setVisibility(r2)     // Catch:{ Exception -> 0x02fd }
            net.one97.paytm.wallet.newdesign.b.d r9 = r8.bz     // Catch:{ Exception -> 0x02fd }
            if (r9 == 0) goto L_0x02fd
            net.one97.paytm.wallet.newdesign.b.d r9 = r8.bz     // Catch:{ Exception -> 0x02fd }
            r9.a()     // Catch:{ Exception -> 0x02fd }
            r8.f()     // Catch:{ Exception -> 0x02fd }
        L_0x02fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.b.c.c(java.lang.Boolean):void");
    }

    public void onResume() {
        Button button;
        super.onResume();
        if (this.aM.getVisibility() != 0 && u() && getArguments().getInt("paymentmode") != 1) {
            n();
            if (this.bh && this.ag.getVisibility() == 0 && (button = this.ar) != null && this.ai != null && this.be) {
                button.setText(getString(R.string.pay_securely));
                this.ai.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(b.f fVar) {
        if (fVar != null) {
            try {
                if (this.bx != null && !this.bx.f71419e.equals(fVar.f71419e)) {
                    net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
                    b.d dVar = this.bx.f71419e;
                    b.d dVar2 = fVar.f71419e;
                    a2.f71397i = a(dVar) + "_to_" + a(dVar2);
                    a2.j = a.e.PAYMENT_SCREEN;
                    a2.l = a.C1450a.PAYMENT_OPTION_CHANGED;
                    a2.k = a.b.WAlLET_SEND_MONEY;
                    a2.b((Context) this.ab);
                }
            } catch (Exception unused) {
            }
            final b.c c2 = this.bt.c(fVar);
            AppCompatActivity appCompatActivity = this.ab;
            if (appCompatActivity != null && !appCompatActivity.isFinishing() && !isDetached()) {
                if (this.bt.r.size() > 1 || this.f70739b || !this.be) {
                    this.w.setVisibility(0);
                } else {
                    this.w.setVisibility(8);
                }
                if (c2 != null) {
                    this.bq.setVisibility(0);
                    this.D.setVisibility(8);
                    this.Z.setVisibility(8);
                    if (!c2.getPaymentInstrumentationType().equals(b.d.WALLET)) {
                        this.C.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    if (c2.getPaymentInstrumentationMetaData() == null) {
                        this.C.setVisibility(8);
                    } else {
                        this.C.setVisibility(0);
                        this.C.setText(c2.getPaymentInstrumentationMetaData());
                    }
                    if (c2.getPaymentInstrumentationType() != b.d.WALLET) {
                        TextView textView = this.H;
                        StringBuilder sb = new StringBuilder();
                        sb.append(c2.getPaymentInstrumentationName());
                        sb.append("  XX ");
                        String paymentInstrumentAccount = c2.getPaymentInstrumentAccount();
                        sb.append(!TextUtils.isEmpty(paymentInstrumentAccount) ? paymentInstrumentAccount.substring(paymentInstrumentAccount.length() - 4) : null);
                        textView.setText(sb.toString());
                    } else {
                        this.H.setText(c2.getPaymentInstrumentationName());
                    }
                    this.H.setContentDescription(com.paytm.utility.b.Y(c2.getPaymentInstrumentationName()));
                    this.B.setText(this.ab.getString(R.string.pay_securely));
                    this.C.setTextColor(this.ab.getResources().getColor(R.color.color_506d85));
                    int i2 = AnonymousClass62.f70824a[c2.getPaymentInstrumentationType().ordinal()];
                    if (i2 == 2) {
                        this.P.setImageDrawable(this.ab.getResources().getDrawable(R.drawable.uni_p2p_wallet));
                        if (this.aN) {
                            this.G.setVisibility(8);
                        } else {
                            this.G.setVisibility(0);
                            if (!this.f70739b) {
                                TextView textView2 = this.G;
                                textView2.setText(this.ab.getResources().getString(R.string.paytm_wallet_linked_to) + " " + this.V);
                            } else {
                                this.G.setTextSize(2, 15.0f);
                                this.G.setText(this.V);
                            }
                        }
                    } else if (i2 == 3) {
                        if (!TextUtils.isEmpty(c2.getAvailBalance())) {
                            this.C.setText(String.format(this.ab.getString(R.string.uni_p2p_wallet_balance), new Object[]{c2.getAvailBalance()}));
                            this.C.setTextColor(this.ab.getResources().getColor(R.color.color_506d85));
                        } else if (c2.getMpinSet() != null) {
                            this.C.setText(this.ab.getString(R.string.check_balance));
                            if ("Y".equalsIgnoreCase(c2.getMpinSet())) {
                                this.C.setText(this.ab.getString(R.string.check_balance));
                            } else if ("Paytm Payments Bank".equalsIgnoreCase(c2.getPaymentInstrumentationName())) {
                                this.C.setText(this.ab.getString(R.string.check_balance));
                            } else {
                                this.C.setText(this.ab.getString(R.string.set_upi_pin));
                            }
                            this.C.setTextColor(Color.parseColor("#00b9f5"));
                        } else {
                            this.C.setText(this.ab.getString(R.string.check_balance));
                            this.C.setTextColor(Color.parseColor("#00b9f5"));
                        }
                        w.a().a(UpiRequestBuilder.getBankIconUrl(this.ab, c2.getIfscCode())).b(this.ab.getResources().getDrawable(R.drawable.ic_bhim)).a(this.P, (com.squareup.picasso.e) null);
                        if (this.aN) {
                            this.G.setVisibility(8);
                        } else {
                            this.G.setVisibility(0);
                            if (!this.f70739b) {
                                TextView textView3 = this.G;
                                textView3.setText(this.ab.getString(R.string.money_transfer_bank_ac_linked_to) + " " + this.V);
                            } else {
                                this.G.setTextSize(2, 15.0f);
                                this.G.setText(this.V);
                            }
                        }
                    } else if (i2 == 4) {
                        if (!TextUtils.isEmpty(c2.getPaymentInstrumentAccount())) {
                            this.C.setVisibility(0);
                            if (c2.getAvailBalance() != null) {
                                this.C.setText(String.format(this.ab.getString(R.string.uni_p2p_wallet_balance), new Object[]{c2.getAvailBalance()}));
                                this.C.setTextColor(this.ab.getResources().getColor(R.color.color_506d85));
                            } else {
                                this.C.setText(this.ab.getString(R.string.check_balance));
                                this.C.setTextColor(Color.parseColor("#00b9f5"));
                            }
                            if (this.aN) {
                                this.G.setVisibility(8);
                            } else {
                                this.G.setVisibility(0);
                                if (!this.f70739b) {
                                    TextView textView4 = this.G;
                                    textView4.setText(this.ab.getResources().getString(R.string.money_transfer_bank_ac_linked_to) + " " + this.V);
                                } else {
                                    this.G.setTextSize(2, 15.0f);
                                    this.G.setText(this.V);
                                }
                            }
                        }
                        this.P.setImageDrawable(this.ab.getResources().getDrawable(R.drawable.ic_savings_account));
                    }
                    this.C.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (c.this.C.getText().toString().startsWith("Check") || c.this.C.getText().toString().startsWith("Set")) {
                                AppCompatActivity unused = c.this.ab;
                                net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
                                a2.j = a.e.WALLET_PAY;
                                a2.l = a.C1450a.CHECK_BALANCE_CLICKED;
                                a2.k = a.b.WAlLET_SEND_MONEY;
                                a2.b((Context) c.this.ab);
                                if (com.paytm.utility.b.c((Context) c.this.ab)) {
                                    b.c cVar = c2;
                                    if (cVar != null) {
                                        new UPICheckBalanceHelper.UPICheckBalanceBuilder(c.this.ab, new n.c(c2) {
                                            public final void Z_() {
                                                net.one97.paytm.common.widgets.a.a(c.this.az);
                                                c.this.C.setVisibility(8);
                                            }

                                            public final void b() {
                                                net.one97.paytm.common.widgets.a.b(c.this.az);
                                                c.this.C.setVisibility(0);
                                                c.this.C.setTextColor(Color.parseColor("#00b9f5"));
                                            }

                                            public final void a(String str, String str2, String str3) {
                                                if (str2 != null) {
                                                    c.this.C.setText(String.format(c.this.ab.getString(R.string.available_balance), new Object[]{str2}));
                                                    c.this.C.setTextColor(c.this.ab.getResources().getColor(R.color.color_506d85));
                                                    r5.setAvailBalance(str2);
                                                }
                                            }

                                            public final void a(n.b bVar) {
                                                switch (AnonymousClass62.f70825b[bVar.ordinal()]) {
                                                    case 1:
                                                        Toast.makeText(c.this.ab, "Incorrect pin, please try again!", 0).show();
                                                        break;
                                                    case 2:
                                                    case 3:
                                                        Toast.makeText(c.this.ab, "Unable to check balance", 0).show();
                                                        break;
                                                    case 4:
                                                        Toast.makeText(c.this.ab, "Please check your internet connection!", 0).show();
                                                        break;
                                                    case 5:
                                                        Toast.makeText(c.this.ab, "Session timed out, please try again!", 0).show();
                                                        break;
                                                    case 6:
                                                        Toast.makeText(c.this.ab, "Too many, Incorrect attempts!", 0).show();
                                                        break;
                                                }
                                                c.this.C.setVisibility(0);
                                                c.this.C.setTextColor(Color.parseColor("#00b9f5"));
                                            }
                                        }).setDeviceBindingRequestCode(102).setOnActivityResultRecieverAfterDeviceBinding((Activity) c.this.ab).build().getUpiAccountBalance(c.b(cVar));
                                        return;
                                    }
                                    return;
                                }
                                Toast.makeText(c.this.ab, "Please check your internet connection!", 0).show();
                            }
                        }
                    });
                }
            }
            if (!(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null || this.bt.j() == null || this.ab == null)) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a((Context) this.ab, Double.valueOf(Double.parseDouble(this.bt.j())), Double.valueOf(Double.parseDouble(this.bt.j())));
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c);
            }
            this.bx = fVar;
            this.aj.setText(fVar.f71417c);
            net.one97.paytm.wallet.newdesign.universalp2p.a.a aVar = this.br;
            if (aVar != null) {
                aVar.a(this.bx);
            }
        }
    }

    private static String a(b.d dVar) {
        try {
            int i2 = AnonymousClass62.f70824a[dVar.ordinal()];
            if (i2 == 1) {
                return "paytm_bank";
            }
            if (i2 != 2) {
                return i2 != 3 ? "" : "paytm_upi";
            }
            return "paytm_wallet";
        } catch (Exception unused) {
            return "";
        }
    }

    private void c(final View view) {
        y();
        try {
            this.bt.p();
            if (this.bt.a(getFragmentManager())) {
                this.aN = true;
                if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.ab, "mt_revamp_enabled", true)) {
                    net.one97.paytm.wallet.utility.a.a aVar = net.one97.paytm.wallet.utility.a.a.f72261c;
                    if (net.one97.paytm.wallet.utility.a.a.c() != null) {
                        net.one97.paytm.wallet.utility.a.a aVar2 = net.one97.paytm.wallet.utility.a.a.f72261c;
                        net.one97.paytm.wallet.utility.a.a.c().b();
                        net.one97.paytm.wallet.utility.a.a aVar3 = net.one97.paytm.wallet.utility.a.a.f72261c;
                        net.one97.paytm.wallet.utility.a.a.d();
                    }
                    net.one97.paytm.wallet.utility.a.a.f72261c.a(this.ab, this.V, "DEEPLINK_OR_PROFILE", this.aQ, this.X, this.bC, this.bD).observeForever(new z() {
                        public final void onChanged(Object obj) {
                            c.this.a((net.one97.paytm.network.f) obj);
                        }
                    });
                    return;
                }
                this.bt.a(this.ab, (b.e) new b.e() {
                    public final void a(Object obj) {
                        if (c.this.bt == null || c.this.bt.s == null || TextUtils.isEmpty(c.this.bt.s.getMerchantId())) {
                            c.this.bt.q();
                            if (!TextUtils.isEmpty(c.this.bt.o())) {
                                c cVar = c.this;
                                c.a(cVar, view, cVar.bt.o());
                            }
                            boolean unused = c.this.aN = false;
                            boolean unused2 = c.this.bd = true;
                            c.ac(c.this);
                            return;
                        }
                        c.aa(c.this);
                    }

                    public final void a(NetworkCustomError networkCustomError) {
                        boolean unused = c.this.aN = false;
                        c.this.bt.q();
                        if (networkCustomError != null) {
                            try {
                                if (networkCustomError.getErrorType().equals(NetworkCustomError.ErrorType.TimeOutError)) {
                                    boolean unused2 = c.this.bd = false;
                                    c.ac(c.this);
                                } else if ("BT_INV_435".equals(new JSONObject(new String(networkCustomError.getNetworkResponse().data)).optString(CLConstants.FIELD_ERROR_CODE))) {
                                    if (c.this.isAdded() && c.this.ab != null && !c.this.ab.isFinishing()) {
                                        c.this.F.setVisibility(0);
                                        c.this.F.setText(l.a(c.this.V));
                                        c.this.G.setVisibility(0);
                                        boolean z = true;
                                        c.this.G.setText(String.format(c.this.getString(R.string.no_paytm_wallet_linked_txt), new Object[]{l.a(c.this.V)}));
                                        c.this.G.setTextColor(androidx.core.content.b.c(c.this.ab, R.color.color_ffa400));
                                        b bVar = new b();
                                        Bundle bundle = new Bundle();
                                        bundle.putString("uni_p2p_btm_sheet_mobile_number", c.this.V);
                                        if (TextUtils.isEmpty(c.this.getArguments().getString("MODE")) || !c.this.getArguments().getString("MODE").equals("CONTACT")) {
                                            z = false;
                                        }
                                        bundle.putBoolean("uni_p2p_btm_sheet_from_contacts", z);
                                        bVar.setArguments(bundle);
                                        androidx.fragment.app.q a2 = c.this.getFragmentManager().a();
                                        a2.a((Fragment) bVar, (String) null).a((String) null);
                                        a2.c();
                                    }
                                } else if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                                    boolean unused3 = c.this.bd = false;
                                    c.ac(c.this);
                                } else {
                                    net.one97.paytm.wallet.communicator.b.a().handleError(c.this.ab, networkCustomError, c.class.getName(), (Bundle) null, false);
                                }
                            } catch (Exception e2) {
                                q.d(String.valueOf(e2));
                                boolean unused4 = c.this.bd = false;
                                c.ac(c.this);
                            }
                        } else {
                            boolean unused5 = c.this.bd = false;
                            c.ac(c.this);
                        }
                    }
                }, this.V);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        boolean z2;
        String str;
        String str2;
        String pushFeatureType;
        boolean z3;
        net.one97.paytm.network.f fVar2 = fVar;
        CJRHomePageItem cJRHomePageItem = this.bL;
        ExtraData extraData = null;
        boolean z4 = false;
        if (cJRHomePageItem != null) {
            String pushFeatureType2 = cJRHomePageItem.getPushFeatureType();
            if (pushFeatureType2 == null || !pushFeatureType2.equalsIgnoreCase("sendmoneymobile")) {
                str2 = null;
                str = null;
                z3 = false;
            } else {
                str2 = this.bL.getP2pamount();
                str = this.bL.getP2pcomment();
                z2 = !TextUtils.isEmpty(this.bL.getP2mIsAmountEnable()) && (this.bL.getP2mIsAmountEnable().equalsIgnoreCase("1") || this.bL.getP2mIsAmountEnable().equalsIgnoreCase("true"));
                if (!TextUtils.isEmpty(this.bL.getP2mIsCommentEnable()) && (this.bL.getP2mIsCommentEnable().equalsIgnoreCase("1") || this.bL.getP2mIsCommentEnable().equalsIgnoreCase("true"))) {
                    z4 = true;
                }
                String deeplink = this.bL.getDeeplink();
                if (deeplink != null) {
                    try {
                        Uri parse = Uri.parse(deeplink.replace('$', '&'));
                        if (!(parse == null || parse.getQueryParameter("source") == null || !"from_notification".equals(parse.getQueryParameter("source")))) {
                            a(CJRGTMConstants.PUSH_NOTIFICATION, "deep_link_enter_amount_screen_clicked", (Context) this.ab, "/mt_enter amount_from_deeplink");
                        }
                    } catch (Exception unused) {
                    }
                }
                z3 = z4;
                z4 = z2;
            }
            z2 = z4;
            z4 = z3;
        } else if (this.bK) {
            String str3 = this.bH;
            str = this.bJ;
            z2 = false;
            str2 = str3;
        } else {
            str2 = null;
            str = null;
            z2 = false;
        }
        CJRHomePageItem cJRHomePageItem2 = this.bL;
        if (!(cJRHomePageItem2 == null || (pushFeatureType = cJRHomePageItem2.getPushFeatureType()) == null || !pushFeatureType.equalsIgnoreCase("sendmoneymobile"))) {
            extraData = new ExtraData();
            extraData.setCommentEditable(z4);
            extraData.setAmountEditable(z2);
            extraData.setComment(str);
            extraData.setAmount(str2);
            extraData.setGalleryScan(this.bA);
            extraData.setMidScan(this.bB);
        }
        if (fVar2.f55796a == net.one97.paytm.network.h.SUCCESS) {
            if (fVar2.f55797b != null && (fVar2.f55797b instanceof PaymentCombinationAPIResponse)) {
                PaymentCombinationAPIResponse paymentCombinationAPIResponse = (PaymentCombinationAPIResponse) fVar2.f55797b;
                if (paymentCombinationAPIResponse.getCategory() == null || !paymentCombinationAPIResponse.getCategory().equalsIgnoreCase("P2P")) {
                    if ("P2M".equalsIgnoreCase(paymentCombinationAPIResponse.getCategory())) {
                        net.one97.paytm.f.b.a().f50402a.setRequestType("Deeplink");
                        if (paymentCombinationAPIResponse.getMerchantInfo() != null) {
                            ExtraData extraData2 = new ExtraData();
                            if (!TextUtils.isEmpty(str2)) {
                                extraData2.setAmount(str2);
                                extraData2.setAmountEditable(z2);
                            }
                            if (!TextUtils.isEmpty(str)) {
                                extraData2.setComment(str);
                                extraData2.setCommentEditable(z4);
                            }
                            paymentCombinationAPIResponse.setExtraData(extraData2);
                            if (getActivity() != null && !getActivity().isFinishing()) {
                                Intent intent = new Intent(getActivity(), AJRQRActivity.class);
                                intent.putExtra("OPERATION", "contact");
                                intent.putExtra("mobile", this.V);
                                intent.putExtra("is_from_mobile_number", true);
                                intent.putExtra("paysend_result", paymentCombinationAPIResponse);
                                getActivity().startActivityForResult(intent, 1800);
                            }
                        }
                    }
                } else if (!this.bK) {
                    if (extraData != null) {
                        paymentCombinationAPIResponse.setExtraData(extraData);
                    }
                    net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
                    net.one97.paytm.wallet.utility.d.a(this.ab, paymentCombinationAPIResponse, str2, str, e.C0905e.PAY.getType(), this.bA, this.bB, false, this.bC, this.bD);
                    getActivity().finish();
                } else {
                    net.one97.paytm.wallet.utility.d dVar2 = net.one97.paytm.wallet.utility.d.f72319a;
                    net.one97.paytm.wallet.utility.d.a((Activity) this.ab, (IJRDataModel) paymentCombinationAPIResponse, str2, str);
                }
            }
        } else if (fVar2.f55796a == net.one97.paytm.network.h.ERROR && fVar2.f55798c != null) {
            this.bt.q();
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            ae aeVar = ae.f69602a;
            if (ae.a(fVar2.f55798c.f55799a)) {
                ae aeVar2 = ae.f69602a;
                ae.a(this.ab, fVar2.f55798c.f55799a, new NetworkCustomError(), bundle, "generic_api_call_fail");
                return;
            }
            net.one97.paytm.wallet.utility.d dVar3 = net.one97.paytm.wallet.utility.d.f72319a;
            AppCompatActivity appCompatActivity = this.ab;
            net.one97.paytm.wallet.utility.d.a(appCompatActivity, str2, str, com.paytm.utility.b.j((Context) appCompatActivity), com.paytm.utility.b.l((Context) this.ab), this.X, this.V, true, extraData, false, this.bC, this.bD);
        } else if (fVar2.f55796a == net.one97.paytm.network.h.CANCELLED) {
            this.bt.q();
            if (this.bK && getActivity() != null && !getActivity().isFinishing()) {
                getActivity().finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        Intent intent = new Intent(this.ab, AJRQRActivity.class);
        intent.putExtra("OPERATION", "contact");
        intent.putExtra("mobile", this.V);
        Bundle bundle = new Bundle();
        bundle.putString("payee_id", this.aW);
        bundle.putString("payer_id", this.aV);
        bundle.putString("amount", this.W);
        intent.putExtras(bundle);
        intent.putExtra("is_from_mobile_number", true);
        intent.putExtra("paysend_result", this.bt.s);
        this.ab.startActivityForResult(intent, 1800);
    }

    private void p() {
        if (!this.be || !this.bf || !this.bg || this.bt.d() == null) {
            this.bx = this.bt.j;
            if (this.bx == null) {
                this.bx = this.bt.d();
            }
            if (this.bx == null) {
                this.bx = this.bt.c();
            }
            b.f fVar = this.bx;
            if (fVar == null) {
                net.one97.paytm.wallet.newdesign.universalp2p.c.b bVar = this.bt;
                b.f fVar2 = null;
                if (bVar.t.size() > 0) {
                    fVar2 = bVar.t.get(0);
                }
                if (fVar2 == null) {
                    fVar2 = bVar.c();
                }
                this.bx = fVar2;
                return;
            }
            a(fVar);
            return;
        }
        this.bx = this.bt.j;
        if (this.bx == null) {
            this.bx = this.bt.d();
        }
        a(this.bx);
    }

    private void b(boolean z2) {
        AppCompatActivity appCompatActivity;
        int i2;
        if (z2) {
            appCompatActivity = this.ab;
            i2 = R.string.p2p_their;
        } else {
            appCompatActivity = this.ab;
            i2 = R.string.p2p_your;
        }
        String string = appCompatActivity.getString(i2);
        net.one97.paytm.wallet.newdesign.universalp2p.c.b bVar = this.bt;
        String str = null;
        if (!(bVar.s == null || bVar.s.getPaymentOptionList() == null)) {
            for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : bVar.s.getPaymentOptionList()) {
                if (b.d.UPI.name().equals(next.getSourcePayment().getPaymentType()) && TextUtils.isEmpty(str)) {
                    str = next.getDestinationPayment().getDisplayName();
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = bVar.o;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.V;
        }
        this.F.setText(str);
        net.one97.paytm.wallet.communicator.b.a().showP2PSnackBar(this.ab, this.bc, this.ab.getString(R.string.p2p_snack_bar_message, new Object[]{str, string}));
    }

    private void c(boolean z2) {
        if (z2) {
            this.bh = true;
            a(false, this.bf);
        } else if (!this.be) {
            this.bh = true;
            a(false, this.bf);
        } else {
            String str = null;
            View inflate = this.ab.getLayoutInflater().inflate(R.layout.layout_upi_led_bottom_sheet, (ViewGroup) null);
            final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(this.ab);
            aVar.setContentView(inflate);
            final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
            aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    from.setState(4);
                }
            });
            from.setState(2);
            from.setPeekHeight(com.paytm.utility.b.b((Activity) this.ab) - com.paytm.utility.b.a(50.0f, (Context) this.ab));
            if (!this.ab.isFinishing()) {
                aVar.show();
            }
            TextView textView = (TextView) inflate.findViewById(R.id.header);
            TextView textView2 = (TextView) inflate.findViewById(R.id.message);
            TextView textView3 = (TextView) inflate.findViewById(R.id.primary_button);
            TextView textView4 = (TextView) inflate.findViewById(R.id.secondary_button);
            inflate.findViewById(R.id.bottom_message_layout);
            inflate.findViewById(R.id.bottom_message);
            ((ImageView) inflate.findViewById(R.id.close_iv)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    aVar.dismiss();
                    c.this.ab.finish();
                }
            });
            String str2 = TextUtils.isEmpty(this.X) ? this.V : this.X;
            if (net.one97.paytm.wallet.newdesign.universalp2p.c.b.a((Context) this.ab)) {
                str = getString(R.string.payee_dont_have_upi, str2);
            } else if (!this.bt.m()) {
                str = getString(R.string.payee_wallet_not_active, str2);
            }
            textView.setText(str);
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.ab, "pay_invite_receiver_upi_text");
            if (TextUtils.isEmpty(stringFromGTM)) {
                stringFromGTM = getString(R.string.invite_payee_msg);
            }
            textView2.setText(stringFromGTM.replace("%@", str2));
            textView3.setText(getString(R.string.invite_payee));
            textView4.setVisibility(8);
            textView3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    Toast.makeText(c.this.ab, c.this.getString(R.string.fetching_options), 0).show();
                    net.one97.paytm.upi.registration.b.a.b.a.a(c.this.ab.getApplicationContext()).d(new a.C1389a() {
                        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                            ReferralCodeResponse referralCodeResponse = (ReferralCodeResponse) upiBaseDataModel;
                            if (referralCodeResponse.getStatus().equalsIgnoreCase("success")) {
                                c.a(c.this, "", referralCodeResponse.getReferralContent() + StringUtility.NEW_LINE + referralCodeResponse.getReferralUrl());
                            }
                        }

                        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                            Toast.makeText(c.this.ab, net.one97.paytm.upi.R.string.upi_some_went_wrong, 0).show();
                        }
                    }, "");
                }
            });
            aVar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    from.setState(4);
                    c.this.ab.finish();
                }
            });
        }
    }

    private void a(Object... objArr) {
        boolean booleanValue = objArr[0].booleanValue();
        this.v.setVisibility(0);
        if (booleanValue) {
            this.aA.setVisibility(0);
            if (!TextUtils.isEmpty(this.bt.j())) {
                this.aB.setText(this.ab.getString(R.string.wallet_paytm_balance, new Object[]{String.valueOf(this.bt.j())}));
            } else {
                this.aB.setText(this.ab.getString(R.string.wallet_paytm_balance, new Object[]{"---"}));
            }
        } else {
            this.aA.setVisibility(8);
        }
        net.one97.paytm.wallet.newdesign.universalp2p.a.a aVar = new net.one97.paytm.wallet.newdesign.universalp2p.a.a(this.ab, new a.C1449a() {
            public final void a(b.c cVar) {
                b.f b2 = c.this.bt.b(cVar);
                if (b2.f71422h != null && !b2.f71422h.equals(c.this.bx.f71422h)) {
                    c.this.a(b2);
                    if (c.this.ar.getVisibility() == 0) {
                        c.this.l();
                    }
                }
            }

            public final void a(boolean z) {
                if (z) {
                    boolean unused = c.this.bi = true;
                    if (c.this.bf) {
                        if (c.this.aD != null) {
                            c.this.aD.setText(c.this.ab.getString(R.string.p2p_upi_onboarding_reactivate));
                        }
                    } else if (c.this.aD != null) {
                        c.this.aD.setText(c.this.ab.getString(R.string.p2p_upi_onboarding_add_account_pay));
                    }
                } else {
                    boolean unused2 = c.this.bi = false;
                    if (c.this.aD != null) {
                        c.this.aD.setText(c.this.ab.getString(R.string.uni_p2p_btn_proceed_to_pay));
                    }
                }
            }
        }, this.bt.a(objArr), !this.be ? -1 : 0, this.be);
        net.one97.paytm.wallet.newdesign.universalp2p.c.b bVar = this.bt;
        b.f b2 = bVar.b(bVar.a(objArr).get(0));
        if (b2.f71422h != null && !b2.f71422h.equals(this.bx.f71422h)) {
            a(b2);
            this.r.setAdapter(aVar);
        }
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.charAt(i2));
            if (i2 == 4) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void q() {
        this.t.setVisibility(8);
        this.p.setVisibility(8);
        this.v.setVisibility(8);
        this.x.setVisibility(8);
        this.u.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void a(AppCompatActivity appCompatActivity, String str, String str2) {
        net.one97.paytm.wallet.newdesign.addbeneficiary.a a2 = net.one97.paytm.wallet.newdesign.addbeneficiary.a.a();
        a2.a(appCompatActivity, str, str2, com.paytm.utility.b.Q(this.R.getText().toString().trim()), (WalletPaymentCallbackListener) null);
        if (appCompatActivity != null && !appCompatActivity.isFinishing()) {
            try {
                androidx.fragment.app.q a3 = getChildFragmentManager().a();
                a3.a((Fragment) a2, (String) null);
                a3.c();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(EditText editText) {
        editText.requestFocus();
        editText.postDelayed(new Runnable() {
            public final void run() {
                try {
                    ((InputMethodManager) c.this.ab.getSystemService("input_method")).toggleSoftInput(2, 2);
                } catch (Exception e2) {
                    q.d(String.valueOf(e2));
                }
            }
        }, 100);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_back_button) {
            r();
            this.t.setVisibility(0);
            this.ab.onBackPressed();
        } else if (id == R.id.uni_2p2_btn_proceed) {
            String Q2 = com.paytm.utility.b.Q(this.R.getText().toString().trim()) != null ? com.paytm.utility.b.Q(this.R.getText().toString().trim()) : "";
            if (Q2.isEmpty()) {
                a("utility_hide_title", "Please enter an amount to proceed", Payload.RESPONSE_OK, (View.OnClickListener) new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.l.cancel();
                    }
                });
            } else if (Q2.charAt(Q2.length() - 1) == '.') {
                a("utility_hide_title", "Please enter an valid amount to proceed", Payload.RESPONSE_OK, (View.OnClickListener) new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.l.cancel();
                    }
                });
            } else {
                this.by = new net.one97.paytm.wallet.newdesign.universalp2p.b.a();
                Bundle bundle = new Bundle();
                bundle.putSerializable("uni_p2p_btm_sheet_pymt_instmnt", this.bu);
                bundle.putString("uni_p2p_btm_sheet_amount", com.paytm.utility.b.Q(this.R.getText().toString().trim()));
                bundle.putString("uni_p2p_btm_sheet_comments", this.S.getText().toString());
                bundle.putString("uni_p2p_btm_sheet_name", this.X);
                bundle.putString("uni_p2p_btm_sheet_mobile_number", this.V);
                bundle.putString("uni_p2p_btm_sheet_mode", this.aa);
                this.by.setArguments(bundle);
                this.by.show(getActivity().getSupportFragmentManager(), this.by.getTag());
            }
        } else if (id == R.id.img_p2p_contact_picker && t()) {
            s();
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.b.c$62  reason: invalid class name */
    static /* synthetic */ class AnonymousClass62 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f70824a = new int[b.d.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f70825b = new int[n.b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0072 */
        static {
            /*
                net.one97.paytm.common.utility.n$b[] r0 = net.one97.paytm.common.utility.n.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f70825b = r0
                r0 = 1
                int[] r1 = f70825b     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.common.utility.n$b r2 = net.one97.paytm.common.utility.n.b.INCORRECT_MPIN     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f70825b     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.common.utility.n$b r3 = net.one97.paytm.common.utility.n.b.UNABLE_TO_CHECK_BALANCE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f70825b     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.common.utility.n$b r4 = net.one97.paytm.common.utility.n.b.ERROR_UNDEFINED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f70825b     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.common.utility.n$b r5 = net.one97.paytm.common.utility.n.b.NO_NETWORK     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r4 = f70825b     // Catch:{ NoSuchFieldError -> 0x0040 }
                net.one97.paytm.common.utility.n$b r5 = net.one97.paytm.common.utility.n.b.SESSION_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r4 = f70825b     // Catch:{ NoSuchFieldError -> 0x004b }
                net.one97.paytm.common.utility.n$b r5 = net.one97.paytm.common.utility.n.b.INCORRECT_MPIN_TOO_MANY_TIMES     // Catch:{ NoSuchFieldError -> 0x004b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d[] r4 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f70824a = r4
                int[] r4 = f70824a     // Catch:{ NoSuchFieldError -> 0x005e }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.BANK     // Catch:{ NoSuchFieldError -> 0x005e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r0 = f70824a     // Catch:{ NoSuchFieldError -> 0x0068 }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r4 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.WALLET     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = f70824a     // Catch:{ NoSuchFieldError -> 0x0072 }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.UPI     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = f70824a     // Catch:{ NoSuchFieldError -> 0x007c }
                net.one97.paytm.wallet.newdesign.universalp2p.c.b$d r1 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.d.PPB     // Catch:{ NoSuchFieldError -> 0x007c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x007c }
            L_0x007c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.b.c.AnonymousClass62.<clinit>():void");
        }
    }

    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
    }

    private void r() {
        try {
            View currentFocus = this.ab.getCurrentFocus();
            if (currentFocus != null) {
                ((InputMethodManager) this.ab.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
    }

    private void s() {
        try {
            Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
            intent.setType("vnd.android.cursor.dir/phone_v2");
            startActivityForResult(intent, 100);
        } catch (ActivityNotFoundException unused) {
        }
    }

    private void a(String str, String str2, String str3, View.OnClickListener onClickListener) {
        try {
            this.l = new com.paytm.utility.h(this.ab);
            this.l.a(str2);
            this.l.setCancelable(false);
            this.l.setTitle(str);
            this.l.a(-3, str3, onClickListener);
            this.l.show();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f70740c.f();
        this.f70741d.c();
    }

    public void onStop() {
        super.onStop();
        r();
        this.ab.unregisterReceiver(this.bG);
        if (this.ag.getVisibility() == 0) {
            this.ab.getWindow().setSoftInputMode(20);
        } else {
            this.ab.getWindow().setSoftInputMode(51);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00be A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0109 A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r21, int r22, android.content.Intent r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = r23
            java.lang.String r4 = " "
            java.lang.String r5 = "display_name"
            java.lang.String r6 = "data1"
            super.onActivityResult(r21, r22, r23)
            r7 = 0
            r8 = 10
            r9 = -1
            r10 = 1
            r11 = 0
            java.lang.String r12 = ""
            if (r2 != r9) goto L_0x0150
            r13 = 100
            if (r0 != r13) goto L_0x0150
            androidx.appcompat.app.AppCompatActivity r13 = r1.ab
            if (r13 == 0) goto L_0x0150
            if (r3 == 0) goto L_0x0150
            android.net.Uri r15 = r23.getData()
            if (r15 == 0) goto L_0x0150
            androidx.appcompat.app.AppCompatActivity r13 = r1.ab     // Catch:{ all -> 0x0148 }
            android.content.ContentResolver r14 = r13.getContentResolver()     // Catch:{ all -> 0x0148 }
            java.lang.String[] r16 = new java.lang.String[]{r6, r5}     // Catch:{ all -> 0x0148 }
            r17 = 0
            r18 = 0
            r19 = 0
            android.database.Cursor r13 = r14.query(r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0148 }
            if (r13 == 0) goto L_0x012b
            boolean r14 = r13.moveToFirst()     // Catch:{ all -> 0x0146 }
            if (r14 == 0) goto L_0x012b
            int r6 = r13.getColumnIndex(r6)     // Catch:{ all -> 0x0146 }
            int r5 = r13.getColumnIndex(r5)     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = r13.getString(r5)     // Catch:{ all -> 0x0146 }
            java.lang.String r6 = r13.getString(r6)     // Catch:{ all -> 0x0146 }
            androidx.appcompat.app.AppCompatActivity r14 = r1.ab     // Catch:{ all -> 0x0146 }
            if (r14 == 0) goto L_0x011e
            java.lang.String r14 = "-"
            java.lang.String r6 = r6.replace(r14, r12)     // Catch:{ all -> 0x0146 }
            java.lang.String r6 = r6.replace(r4, r12)     // Catch:{ all -> 0x0146 }
            java.lang.String r14 = "("
            java.lang.String r6 = r6.replace(r14, r12)     // Catch:{ all -> 0x0146 }
            java.lang.String r14 = ")"
            java.lang.String r6 = r6.replace(r14, r12)     // Catch:{ all -> 0x0146 }
            if (r6 == 0) goto L_0x00bb
            boolean r14 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0146 }
            if (r14 != 0) goto L_0x00bb
            java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0146 }
            java.lang.String r14 = "\\p{C}"
            java.lang.String r6 = r6.replaceAll(r14, r12)     // Catch:{ all -> 0x0146 }
            androidx.appcompat.app.AppCompatActivity r14 = r1.ab     // Catch:{ all -> 0x0146 }
            int r15 = net.one97.paytm.wallet.R.string.mobile_number_prefix_91     // Catch:{ all -> 0x0146 }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ all -> 0x0146 }
            boolean r14 = r6.startsWith(r14)     // Catch:{ all -> 0x0146 }
            if (r14 == 0) goto L_0x0093
            r14 = 3
            goto L_0x00a4
        L_0x0093:
            androidx.appcompat.app.AppCompatActivity r14 = r1.ab     // Catch:{ all -> 0x0146 }
            int r15 = net.one97.paytm.wallet.R.string.mobile_number_prefix_0     // Catch:{ all -> 0x0146 }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ all -> 0x0146 }
            boolean r14 = r6.startsWith(r14)     // Catch:{ all -> 0x0146 }
            if (r14 == 0) goto L_0x00a3
            r14 = 1
            goto L_0x00a4
        L_0x00a3:
            r14 = 0
        L_0x00a4:
            int r15 = r6.length()     // Catch:{ all -> 0x0146 }
            java.lang.String r6 = r6.substring(r14, r15)     // Catch:{ all -> 0x0146 }
            java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0146 }
            java.lang.String r4 = r6.replaceAll(r4, r12)     // Catch:{ all -> 0x0146 }
            int r6 = r4.length()     // Catch:{ all -> 0x0146 }
            if (r6 != r8) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r4 = r11
        L_0x00bc:
            if (r4 == 0) goto L_0x0109
            java.lang.String r6 = "^([6,7,8,9]{1}+[0-9]{9})$"
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)     // Catch:{ all -> 0x0146 }
            java.util.regex.Matcher r6 = r6.matcher(r4)     // Catch:{ all -> 0x0146 }
            if (r4 == 0) goto L_0x00f3
            boolean r6 = r6.find()     // Catch:{ all -> 0x0146 }
            if (r6 == 0) goto L_0x00f3
            r1.o = r10     // Catch:{ all -> 0x0146 }
            android.widget.AutoCompleteTextView r6 = r1.f70744h     // Catch:{ all -> 0x0146 }
            if (r6 == 0) goto L_0x00db
            android.widget.AutoCompleteTextView r6 = r1.f70744h     // Catch:{ all -> 0x0146 }
            r6.setText(r4)     // Catch:{ all -> 0x0146 }
        L_0x00db:
            android.os.Handler r4 = new android.os.Handler     // Catch:{ all -> 0x0146 }
            r4.<init>()     // Catch:{ all -> 0x0146 }
            net.one97.paytm.wallet.newdesign.b.c$59 r6 = new net.one97.paytm.wallet.newdesign.b.c$59     // Catch:{ all -> 0x0146 }
            r6.<init>()     // Catch:{ all -> 0x0146 }
            r4.post(r6)     // Catch:{ all -> 0x0146 }
            android.widget.EditText r4 = r1.f70743g     // Catch:{ all -> 0x0146 }
            r4.requestFocus()     // Catch:{ all -> 0x0146 }
            android.widget.EditText r4 = r1.f70743g     // Catch:{ all -> 0x0146 }
            r1.a((android.widget.EditText) r4)     // Catch:{ all -> 0x0146 }
            goto L_0x011e
        L_0x00f3:
            androidx.appcompat.app.AppCompatActivity r4 = r1.ab     // Catch:{ all -> 0x0146 }
            androidx.appcompat.app.AppCompatActivity r6 = r1.ab     // Catch:{ all -> 0x0146 }
            int r14 = net.one97.paytm.wallet.R.string.error     // Catch:{ all -> 0x0146 }
            java.lang.String r6 = r6.getString(r14)     // Catch:{ all -> 0x0146 }
            androidx.appcompat.app.AppCompatActivity r14 = r1.ab     // Catch:{ all -> 0x0146 }
            int r15 = net.one97.paytm.wallet.R.string.invalid_mobileno_msg     // Catch:{ all -> 0x0146 }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ all -> 0x0146 }
            com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r6, (java.lang.String) r14)     // Catch:{ all -> 0x0146 }
            goto L_0x011e
        L_0x0109:
            androidx.appcompat.app.AppCompatActivity r4 = r1.ab     // Catch:{ all -> 0x0146 }
            androidx.appcompat.app.AppCompatActivity r6 = r1.ab     // Catch:{ all -> 0x0146 }
            int r14 = net.one97.paytm.wallet.R.string.error     // Catch:{ all -> 0x0146 }
            java.lang.String r6 = r6.getString(r14)     // Catch:{ all -> 0x0146 }
            androidx.appcompat.app.AppCompatActivity r14 = r1.ab     // Catch:{ all -> 0x0146 }
            int r15 = net.one97.paytm.wallet.R.string.invalid_mobileno_msg     // Catch:{ all -> 0x0146 }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ all -> 0x0146 }
            com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r6, (java.lang.String) r14)     // Catch:{ all -> 0x0146 }
        L_0x011e:
            androidx.appcompat.app.AppCompatActivity r4 = r1.ab     // Catch:{ all -> 0x0146 }
            if (r4 == 0) goto L_0x0140
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0146 }
            if (r4 != 0) goto L_0x0140
            r1.n = r5     // Catch:{ all -> 0x0146 }
            goto L_0x0140
        L_0x012b:
            androidx.appcompat.app.AppCompatActivity r4 = r1.ab     // Catch:{ all -> 0x0146 }
            androidx.appcompat.app.AppCompatActivity r5 = r1.ab     // Catch:{ all -> 0x0146 }
            int r6 = net.one97.paytm.wallet.R.string.error     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = r5.getString(r6)     // Catch:{ all -> 0x0146 }
            androidx.appcompat.app.AppCompatActivity r6 = r1.ab     // Catch:{ all -> 0x0146 }
            int r14 = net.one97.paytm.wallet.R.string.invalid_mobileno_msg     // Catch:{ all -> 0x0146 }
            java.lang.String r6 = r6.getString(r14)     // Catch:{ all -> 0x0146 }
            com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x0146 }
        L_0x0140:
            if (r13 == 0) goto L_0x0150
            r13.close()
            goto L_0x0150
        L_0x0146:
            r0 = move-exception
            goto L_0x014a
        L_0x0148:
            r0 = move-exception
            r13 = r11
        L_0x014a:
            if (r13 == 0) goto L_0x014f
            r13.close()
        L_0x014f:
            throw r0
        L_0x0150:
            if (r2 != r9) goto L_0x0219
            r2 = 301(0x12d, float:4.22E-43)
            if (r0 != r2) goto L_0x016f
            androidx.cardview.widget.CardView r2 = r1.af
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x0162
            r1.c((java.lang.Boolean) r11)
            goto L_0x016f
        L_0x0162:
            android.widget.LinearLayout r2 = r1.ag
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x016f
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.c((java.lang.Boolean) r2)
        L_0x016f:
            if (r0 == r8) goto L_0x0175
            r2 = 11
            if (r0 != r2) goto L_0x01a5
        L_0x0175:
            if (r3 == 0) goto L_0x019b
            java.lang.String r2 = "resultdata"
            boolean r2 = r3.hasExtra(r2)
            if (r2 == 0) goto L_0x019b
            java.lang.String r2 = "response title"
            boolean r2 = r3.hasExtra(r2)
            if (r2 == 0) goto L_0x019b
            androidx.appcompat.app.AppCompatActivity r2 = r1.ab
            if (r2 == 0) goto L_0x01a5
            boolean r4 = r2 instanceof net.one97.paytm.wallet.newdesign.activity.P2PActivity
            if (r4 == 0) goto L_0x01a5
            net.one97.paytm.wallet.newdesign.activity.P2PActivity r2 = (net.one97.paytm.wallet.newdesign.activity.P2PActivity) r2
            java.lang.String r4 = r1.bJ
            java.lang.String r5 = r1.bH
            java.lang.String r6 = r1.bI
            r2.a(r3, r4, r5, r6)
            goto L_0x01a5
        L_0x019b:
            androidx.appcompat.app.AppCompatActivity r2 = r1.ab
            r2.setResult(r9)
            androidx.appcompat.app.AppCompatActivity r2 = r1.ab
            r2.finish()
        L_0x01a5:
            r2 = 352(0x160, float:4.93E-43)
            if (r0 != r2) goto L_0x0219
            androidx.appcompat.app.AppCompatActivity r2 = r1.ab
            if (r2 == 0) goto L_0x0219
            android.content.Context r2 = net.one97.paytm.upi.g.d()
            net.one97.paytm.upi.h.a r2 = net.one97.paytm.upi.h.a.a(r2, r11)
            net.one97.paytm.upi.registration.b.a.b r2 = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) r2)
            boolean r2 = r2.e()
            r1.be = r2
            android.content.Context r2 = net.one97.paytm.upi.g.d()
            net.one97.paytm.upi.h.a r2 = net.one97.paytm.upi.h.a.a(r2, r11)
            net.one97.paytm.upi.registration.b.a.b r2 = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) r2)
            boolean r2 = r2.f()
            r1.bf = r2
            android.view.View r2 = r1.Y
            if (r2 == 0) goto L_0x0219
            r1.c((android.view.View) r2)
            r1.bg = r10
            r1.bj = r10
            android.widget.LinearLayout r2 = r1.v
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x0219
            androidx.cardview.widget.CardView r2 = r1.af
            r4 = 200(0xc8, float:2.8E-43)
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.b(r2, r4)
            android.widget.LinearLayout r2 = r1.ag
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(r2, r4)
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r2 = r1.R
            r1.a((android.widget.EditText) r2)
            r20.q()
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r2 = r1.R
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0219
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r2 = r1.R
            android.text.Editable r4 = r2.getText()
            java.lang.String r4 = r4.toString()
            int r4 = r4.length()
            r2.setSelection(r4)
        L_0x0219:
            r2 = 1001(0x3e9, float:1.403E-42)
            if (r0 != r2) goto L_0x0343
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r1.bt
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r0 = r0.s
            if (r0 == 0) goto L_0x024c
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r1.bt
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r0 = r0.s
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$MerchantInfo r0 = r0.getMerchantInfo()
            if (r0 == 0) goto L_0x024c
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r1.bt
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r0 = r0.s
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$MerchantInfo r0 = r0.getMerchantInfo()
            java.lang.String r0 = r0.getMerDispname()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x024c
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r1.bt
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r0 = r0.s
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes$MerchantInfo r0 = r0.getMerchantInfo()
            java.lang.String r0 = r0.getMerDispname()
            goto L_0x024e
        L_0x024c:
            java.lang.String r0 = r1.V
        L_0x024e:
            java.lang.String r2 = r1.V
            java.lang.String r4 = r20.w()
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CommentsEditText r5 = r1.S
            android.text.Editable r5 = r5.getText()
            java.lang.String r5 = r5.toString()
            androidx.appcompat.app.AppCompatActivity r6 = r1.ab
            android.content.Intent r6 = net.one97.paytm.wallet.utility.a.h((android.content.Context) r6)
            java.lang.String r8 = "key_via"
            java.lang.String r11 = "via_qr"
            r6.putExtra(r8, r11)
            java.lang.String r8 = "phone_no"
            r6.putExtra(r8, r2)
            java.lang.String r2 = "extra_data"
            java.lang.String r2 = r3.getStringExtra(r2)
            java.lang.String r3 = "pay_response"
            r6.putExtra(r3, r2)
            java.lang.String r2 = "name"
            r6.putExtra(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r2 = "amount"
            r6.putExtra(r2, r0)
            java.lang.String r0 = java.lang.String.valueOf(r5)
            java.lang.String r2 = "comment"
            r6.putExtra(r2, r0)
            java.lang.String r0 = "paymentMode"
            java.lang.String r2 = "p2m"
            r6.putExtra(r0, r2)
            java.lang.String r0 = "merchant_logo"
            r6.putExtra(r0, r12)
            java.lang.String r0 = "is_offline_pg"
            r6.putExtra(r0, r10)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            java.lang.String r2 = "PPI"
            boolean r0 = r0.equals(r2)
            java.lang.String r2 = "is_wallet_transection"
            r6.putExtra(r2, r0)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            java.lang.String r2 = "PAYTM_DIGITAL_CREDIT"
            boolean r0 = r0.equals(r2)
            java.lang.String r2 = "is_postpaid"
            r6.putExtra(r2, r0)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            java.lang.String r2 = "UPI"
            boolean r0 = r0.equals(r2)
            java.lang.String r2 = "is_upi"
            r6.putExtra(r2, r0)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            java.lang.String r2 = "NET_BANKING_PPBL"
            boolean r0 = r0.equals(r2)
            java.lang.String r2 = "is_ppb_transaction"
            r6.putExtra(r2, r0)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            java.lang.String r2 = "DEBIT_CARD"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 != 0) goto L_0x031b
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            java.lang.String r2 = "CREDIT_CARD"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x031c
        L_0x031b:
            r7 = 1
        L_0x031c:
            java.lang.String r0 = "is_card_transaction"
            r6.putExtra(r0, r7)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            java.lang.String r2 = "NET_BANKING"
            boolean r0 = r0.equalsIgnoreCase(r2)
            java.lang.String r2 = "is_net_banking_transaction"
            r6.putExtra(r2, r0)
            r1.startActivity(r6)
            androidx.appcompat.app.AppCompatActivity r0 = r1.ab
            r0.setResult(r9)
            androidx.appcompat.app.AppCompatActivity r0 = r1.ab
            r0.finish()
        L_0x0343:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.b.c.onActivityResult(int, int, android.content.Intent):void");
    }

    private boolean t() {
        Intent intent;
        AppCompatActivity appCompatActivity = this.ab;
        if (appCompatActivity == null || appCompatActivity.isFinishing() || (intent = this.ab.getIntent()) == null || !intent.hasExtra("bill")) {
            return true;
        }
        Bundle bundleExtra = intent.getBundleExtra("bill");
        if (bundleExtra.getBoolean("isMobile Number Editable")) {
            return bundleExtra.getBoolean("isMobile Number Editable");
        }
        return false;
    }

    private boolean u() {
        Intent intent;
        AppCompatActivity appCompatActivity = this.ab;
        if (appCompatActivity == null || appCompatActivity.isFinishing() || (intent = this.ab.getIntent()) == null || !intent.hasExtra("bill")) {
            return true;
        }
        Bundle bundleExtra = intent.getBundleExtra("bill");
        if (bundleExtra.getBoolean("is Amount Editable")) {
            return bundleExtra.getBoolean("is Amount Editable");
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        b.C1451b bVar = this.bw;
        if (bVar != null && !bVar.isCancelled()) {
            this.bw.cancel(true);
        }
        b.C1451b bVar2 = this.bv;
        if (bVar2 != null && !bVar2.isCancelled()) {
            this.bv.cancel(true);
        }
        this.aZ = net.one97.paytm.wallet.utility.g.PAY_METHOD_NOT_CALLED.getValue();
        this.ba = i.UPI_NOT_CALLED.getValue();
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().q();
        r();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.ab = (AppCompatActivity) activity;
        if (this.f70741d == null) {
            this.f70741d = new net.one97.paytm.wallet.d.h();
        }
        this.f70741d.a(activity, (net.one97.paytm.wallet.f.i) new net.one97.paytm.wallet.f.i() {
            public final void a() {
            }

            public final void a(String str) {
            }

            public final void b() {
            }

            public final void a(IJRDataModel iJRDataModel) {
                String str;
                net.one97.paytm.f.b.a().c();
                if (c.this.bt.s == null || c.this.bt.s.getMerchantInfo() == null || TextUtils.isEmpty(c.this.bt.s.getMerchantInfo().getMerDispname())) {
                    str = c.this.V;
                } else {
                    str = c.this.bt.s.getMerchantInfo().getMerDispname();
                }
                String obj = c.this.S.getText().toString();
                Intent h2 = net.one97.paytm.wallet.utility.a.h((Context) c.this.ab);
                h2.putExtra("key_via", "via_qr");
                h2.putExtra("phone_no", c.this.V);
                h2.putExtra("bundle", iJRDataModel);
                h2.putExtra("name", str);
                h2.putExtra("amount", c.this.R.getText().toString());
                h2.putExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL, String.valueOf(obj));
                h2.putExtra("paymentMode", "p2m");
                h2.putExtra("paymentType", "pay");
                if (iJRDataModel instanceof CJRFastForwardResponse) {
                    h2.putExtra("is_offline_pg", true);
                    h2.putExtra("is_wallet_transection", true);
                    h2.putExtra("prn", ((CJRFastForwardResponse) iJRDataModel).getFastForwardResponseDetail().getPrn());
                }
                c.this.startActivity(h2);
                c.this.ab.setResult(-1);
                j.a().a((Context) c.this.ab);
                RecentDataNetworkManager.uploadRecentPaymentsData(c.this.ab);
                c.this.ab.finish();
            }
        });
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    public void v() {
        net.one97.paytm.f.b.a().a(this.ab, this.X, this.V, false, net.one97.paytm.wallet.utility.h.P2P.getValue(), com.paytm.utility.b.s((Context) getActivity()), com.paytm.utility.b.t((Context) getActivity()));
    }

    private String w() {
        try {
            String obj = this.R.getText().toString();
            if (v.a(obj)) {
                return "0";
            }
            return com.paytm.utility.b.Q(obj);
        } catch (NumberFormatException unused) {
            return "0";
        }
    }

    private void d(Boolean bool) {
        if (this.bt.f71405h) {
            if (!this.bd) {
                x();
                return;
            } else if (this.bt.r != null && this.bt.r.size() == 0) {
                c(this.bt.l());
                a(bool);
                return;
            }
        } else if (net.one97.paytm.wallet.newdesign.universalp2p.c.b.a((Context) this.ab)) {
            Toast.makeText(this.ab, getString(R.string.please_wait_for_pc_response), 0).show();
            a(bool);
            return;
        }
        x();
    }

    private void x() {
        this.bs.f71389a = a.e.WALLET_PAY;
        this.bs.f71393e = a.d.P2P;
        this.bs.f71395g = this.bm;
        this.aX = this.S.getText().toString().trim();
        this.aY = com.paytm.utility.b.Q(this.R.getText().toString().trim());
        String str = this.V;
        if (!TextUtils.isEmpty(this.bt.i())) {
            str = this.bt.i();
        }
        v();
        this.f70740c.a(str, this.aY, this.aX, this.bm);
        this.bs.a((Context) this.ab);
    }

    public final void c() {
        Boolean bool = Boolean.FALSE;
        if (com.paytm.utility.b.c((Context) this.ab)) {
            if (this.af.getVisibility() == 0) {
                bool = null;
            } else if (this.ag.getVisibility() == 0) {
                bool = Boolean.FALSE;
            } else {
                bool = Boolean.TRUE;
            }
            b(bool);
        }
        d(bool);
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, Context context, String str3) {
        try {
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvents(str, str2, (String) null, (String) null, context, str3, this.aS);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    private static void a(EditText editText, int i2) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i3 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable[] drawableArr = {editText.getContext().getResources().getDrawable(i3), editText.getContext().getResources().getDrawable(i3)};
            drawableArr[0].setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            drawableArr[1].setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, drawableArr);
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        this.an.setVisibility(0);
        a((EditText) this.R);
        k();
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, boolean z3) {
        this.bz = new d();
        if (z2 || !this.bh) {
            this.bz.a(this.ab, this, this.bt.a(Boolean.FALSE), this.bt.b(this.bx), this.bt, z2, z3);
        } else {
            this.bz.a(this.ab, this, this.bt.a(Boolean.FALSE), -1, this.bt, z2, z3);
        }
        AppCompatActivity appCompatActivity = this.ab;
        if (appCompatActivity != null && !appCompatActivity.isFinishing()) {
            try {
                androidx.fragment.app.q a2 = getChildFragmentManager().a();
                a2.a((Fragment) this.bz, (String) null);
                a2.c();
            } catch (Exception unused) {
            }
        }
    }

    public final void d() {
        net.one97.paytm.wallet.newdesign.universalp2p.c.b bVar = this.bt;
        if (bVar != null && !this.f70739b) {
            ConsolidatePaymentInstrumentationRes.PaymentOptionList a2 = bVar.a(this.bx);
            net.one97.paytm.wallet.newdesign.universalp2p.c.a a3 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
            a3.j = a.e.WALLET_PAY;
            a3.l = a.C1450a.PAY_USING_OPTION_SELECTED;
            a3.k = a.b.WAlLET_SEND_MONEY;
            a3.f71397i = (a2 == null || a2.getSourcePayment() == null) ? AppConstants.TRANSACTION_STATUS_ERROR : a2.getSourcePayment().getPaymentType();
            a3.b((Context) this.ab);
        }
        c(Boolean.TRUE);
    }

    public final void e() {
        f();
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        this.bh = false;
        q();
        a(this.bx);
        this.t.setVisibility(0);
        a(210, 0);
        net.one97.paytm.wallet.newdesign.universalp2p.utils.a.b(this.ag, 200);
        net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(this.af, 200);
    }

    public final void g() {
        if (!z() && UpiUtils.isInActiveProfileExist(this.ab)) {
            startActivityForResult(UpiUtils.getUpiLandingPageActivityIntent(this.ab), 352);
        }
    }

    public final void h() {
        if (!z()) {
            Intent intent = new Intent(this.ab, UpiSelectBankActivity.class);
            intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, UpiConstants.UPI_ONBOARDING_SELF_DESTROY);
            intent.setFlags(536870912);
            intent.putExtra(UpiConstants.EXTRA_UPI_ONBOARDING_DO_SHOW_FULL_SCREEN, true);
            startActivityForResult(intent, 352);
        }
    }

    public final void i() {
        q();
        this.bh = true;
        AppCompatActivity appCompatActivity = this.ab;
        if (appCompatActivity != null && !appCompatActivity.isFinishing() && !isDetached()) {
            if ((this.bt.r.size() > 1 || this.f70739b || !this.be) && this.bt.r.size() != 0) {
                this.w.setVisibility(0);
            } else {
                this.w.setVisibility(8);
            }
            this.bq.setVisibility(8);
            this.H.setVisibility(0);
            this.H.setText(this.ab.getString(R.string.p2p_upi_onboarding_title));
            this.D.setVisibility(0);
            this.D.setText(this.ab.getString(R.string.p2p_upi_onboarding_subtitle));
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.ab, "offlineUpiPromotionalText");
            if (TextUtils.isEmpty(stringFromGTM)) {
                stringFromGTM = this.ab.getString(R.string.p2p_upi_onboarding_offer);
            }
            this.C.setVisibility(0);
            this.C.setText(stringFromGTM);
            this.C.setTextColor(Color.parseColor("#26d07c"));
            this.P.setImageDrawable(this.ab.getResources().getDrawable(R.drawable.ic_bhim));
            if (this.bf) {
                this.B.setText(this.ab.getString(R.string.p2p_upi_onboarding_reactivate));
            } else {
                this.B.setText(this.ab.getString(R.string.p2p_upi_onboarding_add_account_pay));
            }
        }
        this.t.setVisibility(0);
        a(210, 0);
        net.one97.paytm.wallet.newdesign.universalp2p.utils.a.b(this.ag, 200);
        net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(this.af, 200);
    }

    class a implements ah {
        public final String key() {
            return "circle";
        }

        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final Bitmap transform(Bitmap bitmap) {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
            paint.setAntiAlias(true);
            float f2 = ((float) min) / 2.0f;
            canvas.drawCircle(f2, f2, f2, paint);
            createBitmap.recycle();
            return createBitmap2;
        }
    }

    private boolean z() {
        String Q2 = com.paytm.utility.b.Q(this.R.getText().toString().trim()) != null ? com.paytm.utility.b.Q(this.R.getText().toString().trim()) : "";
        if (!Q2.isEmpty() && Q2.charAt(Q2.length() - 1) != '.') {
            return false;
        }
        this.at.setVisibility(0);
        d dVar = this.bz;
        if (dVar != null && dVar.isVisible() && this.bz.isAdded()) {
            this.bz.a();
            i();
        }
        return true;
    }

    public final void a(b.c cVar) {
        this.bx = this.bt.b(cVar);
        f();
    }

    private void y() {
        net.one97.paytm.upi.g.a(net.one97.paytm.upi.h.a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)).c(new a.C1389a() {
            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                if (upiAvailabilityModel.getResponse() != null && !c.this.be) {
                    boolean unused = c.this.be = upiAvailabilityModel.getResponse().isUpiUser();
                }
            }
        }, "", "");
    }

    static /* synthetic */ void j(c cVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(cVar.ab, R.anim.zoom_out_p2p);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                c.b((View) c.this.ak);
            }

            public final void onAnimationEnd(Animation animation) {
                if (c.this.bm.equalsIgnoreCase("")) {
                    ((ImageView) c.this.Y.findViewById(R.id.motif_classic)).setVisibility(0);
                }
                ((RelativeLayout) c.this.Y.findViewById(R.id.themeHeader)).setVisibility(8);
                ((ImageView) c.this.Y.findViewById(R.id.thumbnail1)).setVisibility(0);
                ((ImageView) c.this.Y.findViewById(R.id.thumbnail2)).setVisibility(0);
                ((ImageView) c.this.Y.findViewById(R.id.thumbnail3)).setVisibility(0);
                ((ImageView) c.this.Y.findViewById(R.id.thumbnail4)).setVisibility(0);
            }
        });
        cVar.an.startAnimation(loadAnimation);
        cVar.f70745i = false;
    }

    static /* synthetic */ void a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", new float[]{0.0f, -180.0f});
        ofFloat.setDuration(200);
        ofFloat.start();
    }

    static /* synthetic */ void b(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", new float[]{-180.0f, 0.0f});
        ofFloat.setDuration(200);
        ofFloat.start();
    }

    static /* synthetic */ void a(c cVar, View view) {
        if (cVar.L.getVisibility() == 8) {
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(view);
        }
    }

    static /* synthetic */ void D(c cVar) {
        try {
            if (cVar.ai != null) {
                cVar.ai.setVisibility(8);
            }
            cVar.ac.setVisibility(0);
            cVar.as.setVisibility(0);
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) cVar.ad.findViewById(R.id.wallet_loader));
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void E(c cVar) {
        try {
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) cVar.ad.findViewById(R.id.wallet_loader));
        } catch (Exception unused) {
        }
        cVar.ac.setVisibility(8);
        cVar.ae.setVisibility(0);
        LinearLayout linearLayout = cVar.ai;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    static /* synthetic */ void F(c cVar) {
        if (!cVar.bt.n()) {
            net.one97.paytm.wallet.newdesign.universalp2p.c.a a2 = net.one97.paytm.wallet.newdesign.universalp2p.c.a.a();
            a2.j = a.e.WALLET_PAY;
            a2.l = a.C1450a.PAY_USING_DROP_DOWN;
            a2.k = a.b.WAlLET_SEND_MONEY;
            a2.b((Context) cVar.ab);
            cVar.r();
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.b(cVar.ag, 200);
            cVar.a(cVar.be, cVar.bf);
        }
    }

    static /* synthetic */ void b(c cVar, final ConsolidatePaymentInstrumentationRes.PaymentOptionList paymentOptionList) {
        String str;
        String str2;
        String str3;
        String str4;
        cVar.bs.f71389a = a.e.SEND_MONEY;
        cVar.aX = cVar.S.getText().toString().trim();
        cVar.r();
        if (TextUtils.isEmpty(cVar.aX)) {
            cVar.aX = "";
        }
        final String Q2 = com.paytm.utility.b.Q(cVar.R.getText().toString().trim());
        if (paymentOptionList.getDestinationPayment() != null) {
            String ifscCode = paymentOptionList.getDestinationPayment().getIfscCode();
            net.one97.paytm.wallet.newdesign.universalp2p.c.b bVar = cVar.bt;
            if (bVar.s == null || bVar.s.getPaymentOptionList() == null) {
                str3 = null;
            } else {
                str3 = null;
                for (ConsolidatePaymentInstrumentationRes.PaymentOptionList next : bVar.s.getPaymentOptionList()) {
                    if (b.d.BANK.name().equals(next.getSourcePayment().getPaymentType()) && TextUtils.isEmpty(str3)) {
                        str3 = next.getDestinationPayment().getDisplayName();
                    }
                }
            }
            if (TextUtils.isEmpty(str3)) {
                str4 = bVar.o;
            } else {
                str4 = str3;
            }
            str = str4;
            str2 = ifscCode;
        } else {
            str2 = "";
            str = str2;
        }
        cVar.b((Boolean) null);
        net.one97.paytm.wallet.communicator.b.a().checkPPBUpdateBalance(cVar.ab, new net.one97.paytm.wallet.newdesign.c.c() {
            public final void a(PPBPrevalidateResponseModel pPBPrevalidateResponseModel) {
                c.this.a((Boolean) null);
                c.this.n();
                if (pPBPrevalidateResponseModel == null || pPBPrevalidateResponseModel.getResponseCode() == null || pPBPrevalidateResponseModel.getResponseCode().intValue() != 1005) {
                    Intent moneyTransferIntent = net.one97.paytm.wallet.communicator.b.a().getMoneyTransferIntent(c.this.ab);
                    moneyTransferIntent.putExtra(UpiConstants.EXTRA_IS_FROM_UNIV_P2P, true);
                    moneyTransferIntent.putExtra("amount", Q2);
                    moneyTransferIntent.putExtra(UpiConstants.EXTRA_PHONE_NUMBER_FROM_P2P, c.this.V);
                    moneyTransferIntent.putExtra(UpiConstants.EXTRA_UPI_P2P_PAYMENT_ROUTE, c.this.aa);
                    if (!TextUtils.isEmpty(c.this.aQ)) {
                        net.one97.paytm.wallet.communicator.b.a().markAsPaid(c.this.aQ, "QUICK_PAYMENTS", true, c.this.ab);
                    }
                    if (!c.this.aX.isEmpty()) {
                        moneyTransferIntent.putExtra(UpiConstants.EXTRA_COMMENTS_UNIV_P2P, c.this.aX);
                    }
                    if (paymentOptionList.getSourcePayment() != null) {
                        moneyTransferIntent.putExtra("key_payer_ppb_account_number", paymentOptionList.getSourcePayment().getBankAccountNumber());
                    }
                    if (c.this.bK) {
                        moneyTransferIntent.putExtra("from_app_evoke", true);
                    }
                    if (c.this.aU) {
                        moneyTransferIntent.putExtra("is_from_split_bill", true);
                        SBMarkAsPaid sBMarkAsPaid = new SBMarkAsPaid();
                        sBMarkAsPaid.setPaymentMode("IMPS");
                        sBMarkAsPaid.setPayeeId(c.this.aW);
                        sBMarkAsPaid.setPayerId(c.this.aV);
                        sBMarkAsPaid.setTotalAmount(Q2);
                        moneyTransferIntent.putExtra("split_bill_data", sBMarkAsPaid);
                    }
                    if (paymentOptionList.getDestinationPayment() != null) {
                        moneyTransferIntent.putExtra(UpiConstants.EXTRA_IFSC_UNIV_P2P, paymentOptionList.getDestinationPayment().getIfscCode());
                        moneyTransferIntent.putExtra("payee_name", c.this.bt.f());
                        moneyTransferIntent.putExtra(UpiConstants.EXTRA_PAYEE_VPA_OR_ACC_NUMBER, paymentOptionList.getDestinationPayment().getBankAccountNumber());
                        moneyTransferIntent.putExtra(UpiConstants.EXTRA_IS_FOR_IMPS_FROM_UNIV_P2P, true);
                        c.this.bs.f71393e = a.d.PPB_TO_PPB;
                        moneyTransferIntent.putExtra("image_url", c.this.bt.e());
                    }
                    c.this.v();
                    c.this.bs.a((Context) c.this.ab);
                    c.this.startActivityForResult(moneyTransferIntent, 10);
                    return;
                }
                net.one97.paytm.wallet.communicator.b.a().showP2PSnackBar(c.this.ab, c.this.bc, pPBPrevalidateResponseModel.getMessage());
                if (c.this.bz != null && c.this.bz.isVisible() && c.this.bz.isAdded()) {
                    c.this.bz.a();
                    c.this.f();
                }
                c.this.R.setText("");
            }

            public final void a() {
                c.this.a((Boolean) null);
                c.this.n();
                net.one97.paytm.wallet.communicator.b.a().showP2PSnackBar(c.this.ab, c.this.bc, "Network Error");
                c.this.R.setText("");
                c cVar = c.this;
                cVar.a((EditText) cVar.R);
            }

            public final void b() {
                c.this.a((Boolean) null);
                c.this.n();
                net.one97.paytm.wallet.utility.a.a((Activity) c.this.ab, (net.one97.paytm.wallet.f.n) new net.one97.paytm.wallet.f.n() {
                    public final void a() {
                        Intent intent = new Intent();
                        intent.putExtra("PHONE_NUMBER", c.this.V);
                        intent.putExtra("NAME", c.this.X);
                        intent.putExtra("MODE", c.this.aa);
                        intent.putExtra("MODE_OF_PAYMENT", "p2p");
                        net.one97.paytm.wallet.utility.a.a(intent, (Activity) c.this.ab);
                    }
                });
            }
        }, Q2, str2, str);
    }

    static /* synthetic */ String Y(c cVar) {
        String str = cVar.V;
        if (!TextUtils.isEmpty(cVar.bt.i())) {
            str = cVar.bt.i();
        }
        String a2 = net.one97.paytm.wallet.utility.a.a(cVar.ab.getApplicationContext(), str);
        if (TextUtils.isEmpty(a2)) {
            a2 = cVar.X;
            if ((TextUtils.isEmpty(a2) || "Receiver".equalsIgnoreCase(a2)) && !TextUtils.isEmpty(cVar.bt.g())) {
                a2 = cVar.bt.g();
                if ((TextUtils.isEmpty(a2) || "Receiver".equalsIgnoreCase(a2)) && !TextUtils.isEmpty(cVar.bt.h())) {
                    a2 = cVar.bt.h();
                }
            }
        }
        if (TextUtils.isEmpty(a2)) {
            return "Receiver";
        }
        return a2;
    }

    static /* synthetic */ void aa(c cVar) {
        cVar.f70739b = true;
        cVar.aN = false;
        if (cVar.bt.s.getMerchantInfo() == null) {
            return;
        }
        if (TextUtils.isEmpty(cVar.bt.s.getMerchantInfo().getMerDispname())) {
            cVar.bt.a((b.e) new b.e() {
                public final void a(Object obj) {
                    FetchMerchantUserInfoResponse.MerchantInfoResp merchantInfoResp = (FetchMerchantUserInfoResponse.MerchantInfoResp) obj;
                    c.this.bt.s.getMerchantInfo().setMerDispname(merchantInfoResp.getMerDispname());
                    c.this.bt.s.getMerchantInfo().setMerBusName(merchantInfoResp.getMerBusName());
                    c.this.bt.s.getMerchantInfo().setMerLogoUrl(merchantInfoResp.getMerLogoUrl());
                    c.this.o();
                }

                public final void a(NetworkCustomError networkCustomError) {
                    if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                        c.this.o();
                        return;
                    }
                    net.one97.paytm.wallet.communicator.b.a().handleError(c.this.ab, networkCustomError, c.class.getName(), (Bundle) null, false);
                }
            }, cVar.V);
        } else {
            cVar.o();
        }
    }

    static /* synthetic */ void a(c cVar, View view, String str) {
        AppCompatActivity appCompatActivity = cVar.ab;
        if (appCompatActivity != null && !appCompatActivity.isFinishing() && !cVar.isDetached()) {
            Snackbar a2 = Snackbar.a(view.findViewById(R.id.top_coordinator), (CharSequence) str, 0);
            Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) a2.b();
            snackbarLayout.setBackgroundColor(cVar.getResources().getColor(R.color.p2p_error_snack_bar_bg));
            snackbarLayout.setAlpha(0.7f);
            ((TextView) snackbarLayout.findViewById(R.id.snackbar_text)).setTextColor(cVar.getResources().getColor(R.color.flight_month_text_color));
            a2.d(cVar.getResources().getColor(R.color.black));
            a2.c();
            a2.a(new Snackbar.a() {
                public final void a(Snackbar snackbar, int i2) {
                    c.this.Q.setVisibility(0);
                }

                public final void a(Snackbar snackbar) {
                    c.this.Q.setVisibility(4);
                }
            });
        }
    }

    static /* synthetic */ void ac(c cVar) {
        TextView textView;
        InputMethodManager inputMethodManager;
        AppCompatActivity appCompatActivity = cVar.ab;
        if (appCompatActivity != null && !appCompatActivity.isFinishing() && !cVar.isDetached()) {
            if (!cVar.al && cVar.R.requestFocus() && (inputMethodManager = (InputMethodManager) cVar.ab.getSystemService("input_method")) != null) {
                inputMethodManager.showSoftInput(cVar.R, 2);
            }
            if (cVar.f70739b) {
                if (!TextUtils.isEmpty(cVar.V)) {
                    cVar.G.setText(a(cVar.V.trim()));
                    String str = cVar.W;
                    if (str != null) {
                        cVar.R.setText(str);
                    }
                    if (cVar.bt.s == null || cVar.bt.s.getMerchantInfo() == null || TextUtils.isEmpty(cVar.bt.s.getMerchantInfo().getMerDispname())) {
                        cVar.F.setText(cVar.V);
                        cVar.F.setBackgroundResource(0);
                        cVar.F.setVisibility(8);
                    } else {
                        cVar.F.setText(cVar.bt.s.getMerchantInfo().getMerDispname());
                        cVar.F.setBackgroundResource(0);
                    }
                    String merLogoUrl = (cVar.bt.s == null || cVar.bt.s.getMerchantInfo() == null || TextUtils.isEmpty(cVar.bt.s.getMerchantInfo().getMerLogoUrl())) ? null : cVar.bt.s.getMerchantInfo().getMerLogoUrl();
                    if (!TextUtils.isEmpty(merLogoUrl)) {
                        cVar.z.setVisibility(0);
                        w.a().a(merLogoUrl).a(R.drawable.merchant_icon).a((com.squareup.picasso.e) new com.squareup.picasso.e() {
                            public final void onSuccess() {
                                if (c.this.getActivity() != null && !c.this.getActivity().isFinishing()) {
                                    c.this.z.setAlpha(0.0f);
                                    w.a().a(c.this.bt.s.getMerchantInfo().getMerLogoUrl()).a((ah) new a(c.this, (byte) 0)).a(c.this.z, (com.squareup.picasso.e) null);
                                    c.this.z.animate().setDuration(600).alpha(1.0f).start();
                                }
                            }

                            public final void onError(Exception exc) {
                                if (c.this.getActivity() != null && !c.this.getActivity().isFinishing()) {
                                    c.this.z.setVisibility(0);
                                    c.this.z.setAlpha(0.0f);
                                    w.a().a(R.drawable.merchant_icon).a(c.this.z, (com.squareup.picasso.e) null);
                                    c.this.z.animate().setDuration(600).alpha(1.0f).start();
                                }
                            }
                        });
                    } else if (cVar.getActivity() != null && !cVar.getActivity().isFinishing()) {
                        cVar.z.setVisibility(0);
                        cVar.z.setAlpha(0.0f);
                        w.a().a(R.drawable.merchant_icon).a(cVar.z, (com.squareup.picasso.e) null);
                        cVar.z.animate().setDuration(600).alpha(1.0f).start();
                    }
                }
            } else if (cVar.V != null) {
                TextView textView2 = cVar.G;
                textView2.setText(cVar.ab.getString(R.string.paytm_wallet_linked_to) + " " + a(cVar.V.trim()));
                String str2 = cVar.W;
                if (str2 != null) {
                    cVar.R.setText(str2);
                }
                String str3 = cVar.X;
                if (str3 == null || str3.isEmpty()) {
                    cVar.F.setText(cVar.V);
                    cVar.F.setBackgroundResource(0);
                    cVar.G.setVisibility(8);
                } else {
                    cVar.F.setText(cVar.X);
                    cVar.F.setBackgroundResource(0);
                }
                if (!TextUtils.isEmpty(cVar.bt.g()) && TextUtils.isEmpty(cVar.X)) {
                    cVar.X = cVar.bt.g();
                    cVar.F.setText(cVar.bt.g());
                    cVar.F.setBackgroundResource(0);
                    cVar.G.setVisibility(0);
                    TextView textView3 = cVar.G;
                    textView3.setText(cVar.ab.getString(R.string.paytm_wallet_linked_to) + " " + a(cVar.V.trim()));
                }
                if (!TextUtils.isEmpty(cVar.bt.h()) && TextUtils.isEmpty(cVar.X)) {
                    cVar.X = cVar.bt.h();
                    cVar.F.setText(cVar.bt.h());
                    cVar.F.setBackgroundResource(0);
                    cVar.G.setVisibility(0);
                    TextView textView4 = cVar.G;
                    textView4.setText(cVar.ab.getString(R.string.paytm_wallet_linked_to) + " " + a(cVar.V.trim()));
                }
                if (!TextUtils.isEmpty(cVar.bt.e())) {
                    cVar.z.setVisibility(0);
                    net.one97.paytm.wallet.newdesign.universalp2p.c.b bVar = cVar.bt;
                    bVar.m = bVar.e();
                    w.a().a(cVar.bt.e()).a((com.squareup.picasso.e) new com.squareup.picasso.e() {
                        public final void onError(Exception exc) {
                        }

                        public final void onSuccess() {
                            if (c.this.getActivity() != null && !c.this.getActivity().isFinishing()) {
                                c.this.z.setAlpha(0.0f);
                                w.a().a(c.this.bt.e()).a((ah) new a(c.this, (byte) 0)).a(c.this.z, (com.squareup.picasso.e) null);
                                c.this.z.animate().setDuration(600).alpha(1.0f).start();
                            }
                        }
                    });
                } else {
                    cVar.z.setVisibility(8);
                }
            }
            if (!cVar.bd || cVar.bt.r == null || cVar.bt.r.size() != 0) {
                cVar.p();
                if (cVar.bd && cVar.bj && cVar.bt.r != null && cVar.bt.r.size() > 0) {
                    for (b.c paymentInstrumentationType : cVar.bt.r) {
                        if (paymentInstrumentationType.getPaymentInstrumentationType() == b.d.UPI) {
                            cVar.a(cVar.bt.a(cVar.bx));
                            return;
                        }
                    }
                }
                if (!cVar.bt.n() || (textView = cVar.aO) == null) {
                    TextView textView5 = cVar.aO;
                    if (textView5 != null) {
                        textView5.setVisibility(0);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (net.one97.paytm.wallet.newdesign.universalp2p.c.b.a((Context) cVar.ab)) {
                    cVar.b(false);
                } else if (!cVar.bt.m()) {
                    cVar.b(true);
                } else {
                    if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(cVar.ab, "shouldShowP2PThemes", false) && g.a((Context) cVar.ab).b() && !cVar.f70739b) {
                        cVar.k.post(new Runnable() {
                            public final void run() {
                                if (c.this.al && c.this.j != null) {
                                    net.one97.paytm.p2p.theme.h ai = c.this.j;
                                    if (!(ai.f57011a != null && ai.f57011a.isShowing())) {
                                        net.one97.paytm.p2p.theme.h ai2 = c.this.j;
                                        LinearLayout aj = c.this.k;
                                        ai2.f57011a.setHeight(-2);
                                        ai2.f57011a.setWidth(-2);
                                        ai2.f57011a.setOutsideTouchable(true);
                                        ai2.f57011a.setTouchable(true);
                                        ai2.f57011a.setFocusable(true);
                                        ai2.f57011a.setBackgroundDrawable(new BitmapDrawable());
                                        ai2.f57011a.setContentView(ai2.f57012b);
                                        int[] iArr = new int[2];
                                        aj.getLocationOnScreen(iArr);
                                        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + aj.getWidth(), iArr[1] + aj.getHeight());
                                        ai2.f57011a.showAtLocation(aj, 0, rect.left - 300, rect.bottom + 10);
                                        c.this.j.f57013c.sendEmptyMessageDelayed(100, 0);
                                        c cVar = c.this;
                                        com.paytm.b.a.a unused = cVar.am = be.a(cVar.ab.getApplicationContext());
                                        c.this.am.a("firstTimeP2PTheme", false, false);
                                    }
                                }
                            }
                        });
                    }
                    if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(cVar.ab, "shouldShowP2PThemes", false)) {
                        cVar.aR = g.a((Context) cVar.ab);
                        if (!cVar.aR.b() || cVar.f70739b) {
                            cVar.an.setVisibility(4);
                            cVar.k.setVisibility(4);
                            cVar.ap.setVisibility(4);
                            return;
                        }
                        cVar.j();
                    }
                }
            } else {
                cVar.w.setVisibility(8);
                cVar.ai.setVisibility(8);
                cVar.c(cVar.bt.l());
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str2);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        cVar.ab.startActivity(Intent.createChooser(intent, "Share via"));
    }

    static /* synthetic */ UpiProfileDefaultBank b(b.c cVar) {
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        BankAccountDetails.BankAccount bankAccount = new BankAccountDetails.BankAccount();
        bankAccount.setAccount(cVar.getPaymentInstrumentAccount());
        bankAccount.setAccountType(cVar.getAccountType());
        bankAccount.setAccRefNumber(cVar.getPaymentInstrumentAccount());
        bankAccount.setAccRefId(cVar.getAccRefId());
        bankAccount.setAeba(cVar.getMpinSet());
        bankAccount.setBankLogoUrl("");
        bankAccount.setBankName(cVar.getPaymentInstrumentationName());
        bankAccount.setCustomerName("");
        bankAccount.setIfsc(cVar.getIfscCode());
        bankAccount.setMbeba(cVar.getMpinSet());
        bankAccount.setMmid("");
        ArrayList arrayList = new ArrayList();
        ArrayList<ConsolidatePaymentInstrumentationRes.BankAccountCredentials> credsAlolowed = cVar.getCredsAlolowed();
        if (credsAlolowed != null && credsAlolowed.size() > 0) {
            for (ConsolidatePaymentInstrumentationRes.BankAccountCredentials next : credsAlolowed) {
                BankAccountDetails.BankAccountCredentials bankAccountCredentials = new BankAccountDetails.BankAccountCredentials();
                bankAccountCredentials.setCredsAllowedDLength(next.getCredsAllowedDLength());
                bankAccountCredentials.setCredsAllowedDType(next.getCredsAllowedDType());
                bankAccountCredentials.setCredsAllowedSubType1(next.getCredsAllowedSubType());
                bankAccountCredentials.setCredsAllowedType(next.getCredsAllowedType());
                arrayList.add(bankAccountCredentials);
            }
        }
        bankAccount.setBankCredsAllowed(arrayList);
        upiProfileDefaultBank.setDebitBank(bankAccount);
        upiProfileDefaultBank.setVirtualAddress(cVar.getVpaId());
        return upiProfileDefaultBank;
    }

    static /* synthetic */ void aq(c cVar) {
        cVar.r();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f70798a = true;

            public final void run() {
                try {
                    c.c(c.this, this.f70798a);
                } catch (Exception unused) {
                }
            }
        }, 100);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00e2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0172 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ee A[Catch:{ Exception -> 0x0349 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0125 A[Catch:{ Exception -> 0x0349 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x018a A[Catch:{ Exception -> 0x0349 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(net.one97.paytm.wallet.newdesign.b.c r9, boolean r10) {
        /*
            java.lang.String r0 = "---"
            java.lang.String r1 = "0.00"
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r2 = r9.bt     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel r2 = r2.f71404g     // Catch:{ Exception -> 0x0349 }
            r9.q()     // Catch:{ Exception -> 0x0349 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 0
            if (r2 == 0) goto L_0x0033
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r5 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.Boolean r5 = r5.a((net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel) r2)     // Catch:{ Exception -> 0x0349 }
            if (r5 != 0) goto L_0x0033
            if (r10 == 0) goto L_0x0033
            androidx.appcompat.app.AppCompatActivity r10 = r9.ab     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r9.X     // Catch:{ Exception -> 0x0349 }
            java.lang.String r1 = r9.V     // Catch:{ Exception -> 0x0349 }
            r9.a((androidx.appcompat.app.AppCompatActivity) r10, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0349 }
            android.widget.LinearLayout r10 = r9.ag     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.b(r10, r3)     // Catch:{ Exception -> 0x0349 }
            android.widget.LinearLayout r10 = r9.t     // Catch:{ Exception -> 0x0349 }
            r10.setVisibility(r4)     // Catch:{ Exception -> 0x0349 }
            androidx.cardview.widget.CardView r9 = r9.af     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(r9, r3)     // Catch:{ Exception -> 0x0349 }
            return
        L_0x0033:
            if (r2 == 0) goto L_0x0052
            boolean r5 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.b((net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel) r2)     // Catch:{ Exception -> 0x0349 }
            if (r5 == 0) goto L_0x0052
            if (r10 == 0) goto L_0x0052
            androidx.appcompat.app.AppCompatActivity r10 = r9.ab     // Catch:{ Exception -> 0x0349 }
            r9.a((android.app.Activity) r10)     // Catch:{ Exception -> 0x0349 }
            android.widget.LinearLayout r10 = r9.ag     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.b(r10, r3)     // Catch:{ Exception -> 0x0349 }
            android.widget.LinearLayout r10 = r9.t     // Catch:{ Exception -> 0x0349 }
            r10.setVisibility(r4)     // Catch:{ Exception -> 0x0349 }
            androidx.cardview.widget.CardView r9 = r9.af     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(r9, r3)     // Catch:{ Exception -> 0x0349 }
            return
        L_0x0052:
            android.widget.LinearLayout r5 = r9.ag     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.b(r5, r3)     // Catch:{ Exception -> 0x0349 }
            androidx.cardview.widget.CardView r3 = r9.af     // Catch:{ Exception -> 0x0349 }
            r5 = 300(0x12c, float:4.2E-43)
            net.one97.paytm.wallet.newdesign.universalp2p.utils.a.a(r3, r5)     // Catch:{ Exception -> 0x0349 }
            java.text.DecimalFormat r3 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0349 }
            java.lang.String r5 = "#.##"
            r3.<init>(r5)     // Catch:{ Exception -> 0x0349 }
            r5 = 8
            r6 = 1
            if (r2 == 0) goto L_0x0190
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r7 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.Boolean r2 = r7.a((net.one97.paytm.common.entity.wallet.universalp2p.WalletLimitsResDataModel) r2)     // Catch:{ Exception -> 0x0349 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0349 }
            if (r2 == 0) goto L_0x0190
            if (r10 == 0) goto L_0x0190
            android.widget.LinearLayout r10 = r9.v     // Catch:{ Exception -> 0x0349 }
            r10.setVisibility(r5)     // Catch:{ Exception -> 0x0349 }
            android.widget.LinearLayout r10 = r9.p     // Catch:{ Exception -> 0x0349 }
            r10.setVisibility(r4)     // Catch:{ Exception -> 0x0349 }
            r10 = 210(0xd2, float:2.94E-43)
            r9.a((int) r10, (int) r4)     // Catch:{ Exception -> 0x0349 }
            android.widget.LinearLayout r10 = r9.y     // Catch:{ Exception -> 0x0349 }
            r10.setVisibility(r4)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.av     // Catch:{ Exception -> 0x00e2 }
            int r1 = net.one97.paytm.wallet.R.string.uni_p2p__continue_to_add_rs     // Catch:{ Exception -> 0x00e2 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00e2 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r5 = r9.bt     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r5 = r5.j()     // Catch:{ Exception -> 0x00e2 }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r7 = r9.R     // Catch:{ Exception -> 0x00e2 }
            android.text.Editable r7 = r7.getText()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r7 = r7.trim()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r7 = com.paytm.utility.b.Q((java.lang.String) r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r5 = net.one97.paytm.wallet.utility.a.a((java.text.DecimalFormat) r3, (java.lang.String) r5, (java.lang.String) r7)     // Catch:{ Exception -> 0x00e2 }
            r2[r4] = r5     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = r9.getString(r1, r2)     // Catch:{ Exception -> 0x00e2 }
            r10.setText(r1)     // Catch:{ Exception -> 0x00e2 }
            android.widget.TextView r10 = r9.av     // Catch:{ Exception -> 0x00e2 }
            int r1 = net.one97.paytm.wallet.R.string.tb_uni_p2p__continue_to_add_rs     // Catch:{ Exception -> 0x00e2 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00e2 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r5 = r9.bt     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r5 = r5.j()     // Catch:{ Exception -> 0x00e2 }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r7 = r9.R     // Catch:{ Exception -> 0x00e2 }
            android.text.Editable r7 = r7.getText()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r7 = r7.trim()     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r7 = com.paytm.utility.b.Q((java.lang.String) r7)     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r5 = net.one97.paytm.wallet.utility.a.a((java.text.DecimalFormat) r3, (java.lang.String) r5, (java.lang.String) r7)     // Catch:{ Exception -> 0x00e2 }
            r2[r4] = r5     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r1 = r9.getString(r1, r2)     // Catch:{ Exception -> 0x00e2 }
            r10.setContentDescription(r1)     // Catch:{ Exception -> 0x00e2 }
        L_0x00e2:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r10 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r10.j()     // Catch:{ Exception -> 0x0349 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0349 }
            if (r10 != 0) goto L_0x0125
            android.widget.TextView r10 = r9.O     // Catch:{ Exception -> 0x0349 }
            androidx.appcompat.app.AppCompatActivity r0 = r9.ab     // Catch:{ Exception -> 0x0349 }
            int r1 = net.one97.paytm.wallet.R.string.wallet_paytm_balance     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r5 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r5 = r5.j()     // Catch:{ Exception -> 0x0349 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0349 }
            r2[r4] = r5     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r0.getString(r1, r2)     // Catch:{ Exception -> 0x0349 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.O     // Catch:{ Exception -> 0x0349 }
            androidx.appcompat.app.AppCompatActivity r0 = r9.ab     // Catch:{ Exception -> 0x0349 }
            int r1 = net.one97.paytm.wallet.R.string.tb_wallet_paytm_balance     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r5 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r5 = r5.j()     // Catch:{ Exception -> 0x0349 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0349 }
            r2[r4] = r5     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r0.getString(r1, r2)     // Catch:{ Exception -> 0x0349 }
            r10.setContentDescription(r0)     // Catch:{ Exception -> 0x0349 }
            goto L_0x0147
        L_0x0125:
            android.widget.TextView r10 = r9.O     // Catch:{ Exception -> 0x0349 }
            androidx.appcompat.app.AppCompatActivity r1 = r9.ab     // Catch:{ Exception -> 0x0349 }
            int r2 = net.one97.paytm.wallet.R.string.wallet_paytm_balance     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            r5[r4] = r0     // Catch:{ Exception -> 0x0349 }
            java.lang.String r1 = r1.getString(r2, r5)     // Catch:{ Exception -> 0x0349 }
            r10.setText(r1)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.O     // Catch:{ Exception -> 0x0349 }
            androidx.appcompat.app.AppCompatActivity r1 = r9.ab     // Catch:{ Exception -> 0x0349 }
            int r2 = net.one97.paytm.wallet.R.string.tb_wallet_paytm_balance     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            r5[r4] = r0     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r1.getString(r2, r5)     // Catch:{ Exception -> 0x0349 }
            r10.setContentDescription(r0)     // Catch:{ Exception -> 0x0349 }
        L_0x0147:
            android.widget.Button r10 = r9.aw     // Catch:{ Exception -> 0x0172 }
            int r0 = net.one97.paytm.wallet.R.string.uni_p2p__add_pay     // Catch:{ Exception -> 0x0172 }
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0172 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r2 = r9.bt     // Catch:{ Exception -> 0x0172 }
            java.lang.String r2 = r2.j()     // Catch:{ Exception -> 0x0172 }
            net.one97.paytm.wallet.newdesign.widget.CustomAmountTextInputEditText r5 = r9.R     // Catch:{ Exception -> 0x0172 }
            android.text.Editable r5 = r5.getText()     // Catch:{ Exception -> 0x0172 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0172 }
            java.lang.String r5 = r5.trim()     // Catch:{ Exception -> 0x0172 }
            java.lang.String r5 = com.paytm.utility.b.Q((java.lang.String) r5)     // Catch:{ Exception -> 0x0172 }
            java.lang.String r2 = net.one97.paytm.wallet.utility.a.a((java.text.DecimalFormat) r3, (java.lang.String) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x0172 }
            r1[r4] = r2     // Catch:{ Exception -> 0x0172 }
            java.lang.String r0 = r9.getString(r0, r1)     // Catch:{ Exception -> 0x0172 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0172 }
        L_0x0172:
            android.widget.Button r10 = r9.aw     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.b.c$42 r0 = new net.one97.paytm.wallet.newdesign.b.c$42     // Catch:{ Exception -> 0x0349 }
            r0.<init>()     // Catch:{ Exception -> 0x0349 }
            r10.setOnClickListener(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.ImageView r10 = r9.ax     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.b.c$43 r0 = new net.one97.paytm.wallet.newdesign.b.c$43     // Catch:{ Exception -> 0x0349 }
            r0.<init>()     // Catch:{ Exception -> 0x0349 }
            r10.setOnClickListener(r0)     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.b.d r10 = r9.bz     // Catch:{ Exception -> 0x0349 }
            if (r10 == 0) goto L_0x0348
            net.one97.paytm.wallet.newdesign.b.d r9 = r9.bz     // Catch:{ Exception -> 0x0349 }
            r9.a()     // Catch:{ Exception -> 0x0349 }
            return
        L_0x0190:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r9.bt     // Catch:{ Exception -> 0x0349 }
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0349 }
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0349 }
            r3[r4] = r7     // Catch:{ Exception -> 0x0349 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r10)     // Catch:{ Exception -> 0x0349 }
            r3[r6] = r7     // Catch:{ Exception -> 0x0349 }
            java.util.List r0 = r0.a((java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0349 }
            int r0 = r0.size()     // Catch:{ Exception -> 0x0349 }
            if (r0 <= 0) goto L_0x01cd
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0349 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0349 }
            r0[r4] = r1     // Catch:{ Exception -> 0x0349 }
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)     // Catch:{ Exception -> 0x0349 }
            r0[r6] = r10     // Catch:{ Exception -> 0x0349 }
            r9.a((java.lang.Object[]) r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.ImageView r10 = r9.aC     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.b.c$45 r0 = new net.one97.paytm.wallet.newdesign.b.c$45     // Catch:{ Exception -> 0x0349 }
            r0.<init>()     // Catch:{ Exception -> 0x0349 }
            r10.setOnClickListener(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.Button r10 = r9.aD     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.b.c$46 r0 = new net.one97.paytm.wallet.newdesign.b.c$46     // Catch:{ Exception -> 0x0349 }
            r0.<init>()     // Catch:{ Exception -> 0x0349 }
            r10.setOnClickListener(r0)     // Catch:{ Exception -> 0x0349 }
            return
        L_0x01cd:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r0 = r9.bt     // Catch:{ Exception -> 0x0349 }
            boolean r0 = r0.l()     // Catch:{ Exception -> 0x0349 }
            if (r0 == 0) goto L_0x01dd
            r9.bh = r6     // Catch:{ Exception -> 0x0349 }
            boolean r10 = r9.bf     // Catch:{ Exception -> 0x0349 }
            r9.a((boolean) r4, (boolean) r10)     // Catch:{ Exception -> 0x0349 }
            return
        L_0x01dd:
            androidx.appcompat.app.AppCompatActivity r0 = r9.ab     // Catch:{ Exception -> 0x0349 }
            boolean r0 = net.one97.paytm.wallet.newdesign.universalp2p.c.b.a((android.content.Context) r0)     // Catch:{ Exception -> 0x0349 }
            if (r0 == 0) goto L_0x0256
            if (r10 == 0) goto L_0x0256
            android.widget.LinearLayout r10 = r9.u     // Catch:{ Exception -> 0x0349 }
            r10.setVisibility(r4)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.aH     // Catch:{ Exception -> 0x0349 }
            androidx.appcompat.app.AppCompatActivity r0 = r9.ab     // Catch:{ Exception -> 0x0349 }
            int r1 = net.one97.paytm.wallet.R.string.uni_get_kyc     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0349 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.aI     // Catch:{ Exception -> 0x0349 }
            androidx.appcompat.app.AppCompatActivity r0 = r9.ab     // Catch:{ Exception -> 0x0349 }
            int r1 = net.one97.paytm.wallet.R.string.uni_kyc_desc     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0349 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.aJ     // Catch:{ Exception -> 0x0349 }
            int r0 = net.one97.paytm.wallet.R.string.wallet_paytm_balance     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r2 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r2 = r2.j()     // Catch:{ Exception -> 0x0349 }
            r1[r4] = r2     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r9.getString(r0, r1)     // Catch:{ Exception -> 0x0349 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.aJ     // Catch:{ Exception -> 0x0349 }
            int r0 = net.one97.paytm.wallet.R.string.tb_wallet_paytm_balance     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r2 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r2 = r2.j()     // Catch:{ Exception -> 0x0349 }
            r1[r4] = r2     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r9.getString(r0, r1)     // Catch:{ Exception -> 0x0349 }
            r10.setContentDescription(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.ImageView r10 = r9.aF     // Catch:{ Exception -> 0x0349 }
            androidx.appcompat.app.AppCompatActivity r0 = r9.ab     // Catch:{ Exception -> 0x0349 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0349 }
            int r1 = net.one97.paytm.wallet.R.drawable.uni_p2p_kyc     // Catch:{ Exception -> 0x0349 }
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r1)     // Catch:{ Exception -> 0x0349 }
            r10.setImageDrawable(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.ImageView r10 = r9.aG     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.b.c$47 r0 = new net.one97.paytm.wallet.newdesign.b.c$47     // Catch:{ Exception -> 0x0349 }
            r0.<init>()     // Catch:{ Exception -> 0x0349 }
            r10.setOnClickListener(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.RelativeLayout r10 = r9.aE     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.b.c$48 r0 = new net.one97.paytm.wallet.newdesign.b.c$48     // Catch:{ Exception -> 0x0349 }
            r0.<init>()     // Catch:{ Exception -> 0x0349 }
            r10.setOnClickListener(r0)     // Catch:{ Exception -> 0x0349 }
            return
        L_0x0256:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r10 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r10.j()     // Catch:{ Exception -> 0x0349 }
            if (r10 == 0) goto L_0x02d7
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r10 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r10.j()     // Catch:{ Exception -> 0x0349 }
            double r2 = java.lang.Double.parseDouble(r10)     // Catch:{ Exception -> 0x0349 }
            r7 = 0
            int r10 = java.lang.Double.compare(r2, r7)     // Catch:{ Exception -> 0x0349 }
            if (r10 <= 0) goto L_0x02d7
            android.widget.LinearLayout r10 = r9.x     // Catch:{ Exception -> 0x0349 }
            r10.setVisibility(r4)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.J     // Catch:{ Exception -> 0x0349 }
            int r0 = net.one97.paytm.wallet.R.string.uni_p2p_get_low_balance     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r2 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r2 = r2.j()     // Catch:{ Exception -> 0x0349 }
            r1[r4] = r2     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r9.getString(r0, r1)     // Catch:{ Exception -> 0x0349 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r10 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r10.f()     // Catch:{ Exception -> 0x0349 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0349 }
            if (r10 == 0) goto L_0x029d
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r10 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r10.i()     // Catch:{ Exception -> 0x0349 }
            goto L_0x02a3
        L_0x029d:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r10 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r10.f()     // Catch:{ Exception -> 0x0349 }
        L_0x02a3:
            android.widget.TextView r0 = r9.bp     // Catch:{ Exception -> 0x0349 }
            int r1 = net.one97.paytm.wallet.R.string.uni_p2p_get_low_balance_metdata     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            r2[r4] = r10     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r9.getString(r1, r2)     // Catch:{ Exception -> 0x0349 }
            r0.setText(r10)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.bo     // Catch:{ Exception -> 0x0349 }
            int r0 = net.one97.paytm.wallet.R.string.wallet_paytm_balance     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r2 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r2 = r2.j()     // Catch:{ Exception -> 0x0349 }
            r1[r4] = r2     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r9.getString(r0, r1)     // Catch:{ Exception -> 0x0349 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.ImageView r10 = r9.bn     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.b.c$49 r0 = new net.one97.paytm.wallet.newdesign.b.c$49     // Catch:{ Exception -> 0x0349 }
            r0.<init>()     // Catch:{ Exception -> 0x0349 }
            r10.setOnClickListener(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r9 = r9.K     // Catch:{ Exception -> 0x0349 }
            r9.setVisibility(r5)     // Catch:{ Exception -> 0x0349 }
            return
        L_0x02d7:
            android.widget.LinearLayout r10 = r9.x     // Catch:{ Exception -> 0x0349 }
            r10.setVisibility(r4)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.J     // Catch:{ Exception -> 0x0349 }
            int r0 = net.one97.paytm.wallet.R.string.uni_p2p_get_low_balance     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            r2[r4] = r1     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r9.getString(r0, r2)     // Catch:{ Exception -> 0x0349 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r10 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r10.f()     // Catch:{ Exception -> 0x0349 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0349 }
            if (r10 == 0) goto L_0x02fe
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r10 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r10.i()     // Catch:{ Exception -> 0x0349 }
            goto L_0x0304
        L_0x02fe:
            net.one97.paytm.wallet.newdesign.universalp2p.c.b r10 = r9.bt     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r10.f()     // Catch:{ Exception -> 0x0349 }
        L_0x0304:
            android.widget.TextView r0 = r9.bp     // Catch:{ Exception -> 0x0349 }
            int r2 = net.one97.paytm.wallet.R.string.uni_p2p_get_low_balance_metdata     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            r3[r4] = r10     // Catch:{ Exception -> 0x0349 }
            java.lang.String r10 = r9.getString(r2, r3)     // Catch:{ Exception -> 0x0349 }
            r0.setText(r10)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.bo     // Catch:{ Exception -> 0x0349 }
            int r0 = net.one97.paytm.wallet.R.string.wallet_paytm_balance     // Catch:{ Exception -> 0x0349 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0349 }
            r2[r4] = r1     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r9.getString(r0, r2)     // Catch:{ Exception -> 0x0349 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.ImageView r10 = r9.bn     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.b.c$50 r0 = new net.one97.paytm.wallet.newdesign.b.c$50     // Catch:{ Exception -> 0x0349 }
            r0.<init>()     // Catch:{ Exception -> 0x0349 }
            r10.setOnClickListener(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.K     // Catch:{ Exception -> 0x0349 }
            r10.setVisibility(r4)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.K     // Catch:{ Exception -> 0x0349 }
            androidx.appcompat.app.AppCompatActivity r0 = r9.ab     // Catch:{ Exception -> 0x0349 }
            int r1 = net.one97.paytm.wallet.R.string.uni_low_balance_goback     // Catch:{ Exception -> 0x0349 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0349 }
            r10.setText(r0)     // Catch:{ Exception -> 0x0349 }
            android.widget.TextView r10 = r9.K     // Catch:{ Exception -> 0x0349 }
            net.one97.paytm.wallet.newdesign.b.c$51 r0 = new net.one97.paytm.wallet.newdesign.b.c$51     // Catch:{ Exception -> 0x0349 }
            r0.<init>()     // Catch:{ Exception -> 0x0349 }
            r10.setOnClickListener(r0)     // Catch:{ Exception -> 0x0349 }
        L_0x0348:
            return
        L_0x0349:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.b.c.c(net.one97.paytm.wallet.newdesign.b.c, boolean):void");
    }

    static /* synthetic */ void ar(c cVar) {
        cVar.aX = cVar.S.getText().toString().trim();
        cVar.aY = com.paytm.utility.b.Q(cVar.R.getText().toString().trim());
        if (!TextUtils.isEmpty(cVar.aY)) {
            String str = cVar.V;
            if (!TextUtils.isEmpty(cVar.bt.i())) {
                str = cVar.bt.i();
            }
            if (com.paytm.utility.b.c((Context) cVar.ab)) {
                cVar.a(true);
            }
            cVar.v();
            if (com.paytm.utility.b.c((Context) cVar.ab)) {
                cVar.f70740c.a(str, cVar.aY, cVar.aX, false);
                return;
            }
            AppCompatActivity appCompatActivity = cVar.ab;
            if (appCompatActivity != null && !appCompatActivity.isFinishing()) {
                AppCompatActivity appCompatActivity2 = cVar.ab;
                com.paytm.utility.b.b((Context) appCompatActivity2, appCompatActivity2.getResources().getString(R.string.no_connection), cVar.ab.getResources().getString(R.string.no_internet));
            }
        }
    }

    static /* synthetic */ void at(c cVar) {
        b.c cVar2;
        b.c cVar3;
        String str = "";
        try {
            if (com.paytm.utility.b.Q(cVar.R.getText().toString().trim()) != null) {
                str = com.paytm.utility.b.Q(cVar.R.getText().toString().trim());
            }
            if (!str.isEmpty()) {
                if (str.charAt(str.length() - 1) != '.') {
                    ConsolidatePaymentInstrumentationRes.PaymentOptionList a2 = cVar.bt.a(cVar.bx);
                    cVar.a(com.paytm.utility.b.Q(cVar.R.getText().toString().trim()), (a2 == null || a2.getSourcePayment() == null) ? "error" : a2.getSourcePayment().getPaymentType());
                    String paymentType = a2.getSourcePayment().getPaymentType();
                    char c2 = 65535;
                    int hashCode = paymentType.hashCode();
                    if (hashCode != 84238) {
                        if (hashCode == 2031164) {
                            if (paymentType.equals(SDKConstants.TYPE_BANK)) {
                                c2 = 0;
                            }
                        }
                    } else if (paymentType.equals("UPI")) {
                        c2 = 1;
                    }
                    if (c2 == 0) {
                        Iterator<b.c> it2 = cVar.bt.r.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                cVar2 = null;
                                break;
                            }
                            cVar2 = it2.next();
                            if (a2.getSourcePayment().getBankAccountNumber().equalsIgnoreCase(cVar2.getPaymentInstrumentAccount())) {
                                break;
                            }
                        }
                        if (cVar2 == null || cVar2.getAvailBalance() == null || Double.parseDouble(cVar2.getAvailBalance()) >= Double.parseDouble(com.paytm.utility.b.Q(cVar.R.getText().toString().trim()))) {
                            cVar.b(a2);
                            return;
                        } else {
                            Toast.makeText(cVar.ab, "Insufficient Balance", 0).show();
                            return;
                        }
                    } else if (c2 == 1) {
                        if (cVar.be) {
                            Iterator<b.c> it3 = cVar.bt.r.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    cVar3 = null;
                                    break;
                                }
                                cVar3 = it3.next();
                                if (a2.getSourcePayment().getBankAccountNumber().equalsIgnoreCase(cVar3.getPaymentInstrumentAccount())) {
                                    break;
                                }
                            }
                            if (cVar3 == null || cVar3.getAvailBalance() == null || Double.parseDouble(cVar3.getAvailBalance()) >= Double.parseDouble(com.paytm.utility.b.Q(cVar.R.getText().toString().trim()))) {
                                cVar.b(a2);
                                return;
                            } else {
                                Toast.makeText(cVar.ab, "Insufficient Balance", 0).show();
                                return;
                            }
                        } else if (cVar.bf) {
                            cVar.g();
                            return;
                        } else {
                            cVar.h();
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            cVar.at.setVisibility(0);
            if (cVar.bz != null && cVar.bz.isVisible() && cVar.bz.isAdded()) {
                cVar.bz.a();
                cVar.f();
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void au(c cVar) {
        try {
            net.one97.paytm.wallet.communicator.b.a().checkDeepLinking(cVar.ab, net.one97.paytm.wallet.communicator.b.a().getUpgradeKycDeeplink("", "kyc", false, false));
        } catch (UnsupportedEncodingException e2) {
            q.d(String.valueOf(e2));
        }
    }
}
