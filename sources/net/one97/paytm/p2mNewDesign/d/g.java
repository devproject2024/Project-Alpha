package net.one97.paytm.p2mNewDesign.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseDialogFragment;
import com.squareup.picasso.w;
import easypay.manager.Constants;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import kotlin.g.b.k;
import net.one97.paytm.base.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo;
import net.one97.paytm.common.entity.gold.jeweller.CJRGoldInitiate;
import net.one97.paytm.common.entity.gold.jeweller.CJRGoldPortfolio;
import net.one97.paytm.common.entity.offline_pg.CJRPGTransactionParams;
import net.one97.paytm.common.entity.offline_pg.PCFDetails.CJRPCFDetails;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRPayChannel;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.CJRLinkBasePaymentResponse;
import net.one97.paytm.common.entity.wallet.CJRQRInfoResponse;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.CJRWalletConvenienceFee;
import net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes;
import net.one97.paytm.common.widget.CollapsingToolbarLayout;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.jeweller.AJRJewellerSummary;
import net.one97.paytm.n.a;
import net.one97.paytm.n.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.UpiInstrumentInfo;
import net.one97.paytm.p2mNewDesign.activity.NetBankingListActivity;
import net.one97.paytm.p2mNewDesign.d.g;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;
import net.one97.paytm.p2mNewDesign.entity.BankForm;
import net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse;
import net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody;
import net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse;
import net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResultInfo;
import net.one97.paytm.p2mNewDesign.entity.Head;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.entity.RedirectForm;
import net.one97.paytm.p2mNewDesign.entity.RetryInfo;
import net.one97.paytm.p2mNewDesign.entity.TxnInfo;
import net.one97.paytm.p2mNewDesign.entity.UpiProfileDefaultBank;
import net.one97.paytm.p2mNewDesign.entity.mlv.CartItem;
import net.one97.paytm.p2mNewDesign.entity.mlv.ChannelAPIResponse;
import net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails;
import net.one97.paytm.p2mNewDesign.f.i;
import net.one97.paytm.p2mNewDesign.i.a;
import net.one97.paytm.p2mNewDesign.i.c;
import net.one97.paytm.p2mNewDesign.j.d;
import net.one97.paytm.p2mNewDesign.models.BankAccountsV2;
import net.one97.paytm.p2mNewDesign.models.BodyV2;
import net.one97.paytm.p2mNewDesign.models.HeadV2;
import net.one97.paytm.p2mNewDesign.models.MerchantDetailsV2;
import net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2;
import net.one97.paytm.p2mNewDesign.models.PaymentModesV2;
import net.one97.paytm.p2mNewDesign.models.SingleAPIResponseV2;
import net.one97.paytm.p2mNewDesign.models.SubWalletDetailV2;
import net.one97.paytm.p2mNewDesign.models.UPIProfileV2;
import net.one97.paytm.p2mNewDesign.models.UserProfileSarvatraV2;
import net.one97.paytm.p2mNewDesign.models.VpaDetails;
import net.one97.paytm.p2mNewDesign.nativeOTP.AJRNativeOTPActivity;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ShimmerFrameLayout;
import net.one97.paytm.utils.aq;
import net.one97.paytm.utils.at;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRLocationCaptureActivity;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.communicator.a;
import net.one97.paytm.wallet.d.h;
import net.one97.paytm.wallet.d.j;
import net.one97.paytm.wallet.dialog.d;
import net.one97.paytm.wallet.entity.MerchantVerifedStatus;
import net.one97.paytm.wallet.f.m;
import net.one97.paytm.wallet.f.o;
import net.one97.paytm.wallet.i.a.c;
import net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText;
import net.one97.paytm.wallet.newdesign.utils.CustomDialog;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends b implements View.OnClickListener, net.one97.paytm.n.b, net.one97.paytm.p2mNewDesign.f.g, i, aq.a, CustomDialog.OkClickListener, CustomDialog.OnDialogDismissListener {
    private static String H;

    /* renamed from: a  reason: collision with root package name */
    public static final String f51121a = g.class.getSimpleName();
    private static String an = "offline_payments";
    private static String ao = "home/pay-send/post-scan";
    private static boolean as;
    private static boolean at;
    /* access modifiers changed from: private */
    public static DecimalFormat bU = new DecimalFormat("0.00");
    private List<UpiProfileDefaultBank> A = new ArrayList();
    private Toolbar B;
    private int C = net.one97.paytm.wallet.utility.g.PAY_METHOD_NOT_CALLED.getValue();
    private int D = net.one97.paytm.wallet.utility.i.UPI_NOT_CALLED.getValue();
    private int E = net.one97.paytm.jeweller.b.JEWELLER_NOT_CALLED.getValue();
    private CoordinatorLayout F;
    private boolean G;
    private TextWatcher I;
    private List<String> J;
    private NestedScrollView K;
    /* access modifiers changed from: private */
    public EditText L;
    private int M;
    private String N = "₹ ";
    private LinearLayout O;
    private boolean P;
    private String Q;
    private String R;
    private boolean S;
    private boolean T;
    /* access modifiers changed from: private */
    public TextView U;
    private LinearLayout V;
    private LinearLayout W;
    private boolean X;
    /* access modifiers changed from: private */
    public TextView Y;
    private String Z = "FETCH_UPI_HANDLES";
    private double aA;
    private boolean aB;
    /* access modifiers changed from: private */
    public boolean aC = false;
    /* access modifiers changed from: private */
    public boolean aD = false;
    /* access modifiers changed from: private */
    public Bundle aE;
    private d aF;
    /* access modifiers changed from: private */
    public LinearLayout aG;
    private RelativeLayout aH;
    private ImageView aI;
    private MerchantVerifedStatus aJ = MerchantVerifedStatus.MERCHANT_NO_STATUS;
    private long aK;
    private boolean aL;
    private boolean aM = false;
    /* access modifiers changed from: private */
    public boolean aN = false;
    /* access modifiers changed from: private */
    public boolean aO = false;
    /* access modifiers changed from: private */
    public boolean aP = false;
    private boolean aQ;
    /* access modifiers changed from: private */
    public String aR;
    /* access modifiers changed from: private */
    public String aS;
    private c aT;
    private a aU;
    private String aV;
    private boolean aW;
    private LinearLayout aX;
    private TextView aY;
    private Button aZ;
    private boolean aa;
    private RelativeLayout ab;
    /* access modifiers changed from: private */
    public TextView ac;
    /* access modifiers changed from: private */
    public LinearLayout ad;
    private TextView ae;
    private net.one97.paytm.jeweller.a af;
    private boolean ag;
    private AppBarLayout ah;
    private TextView ai;
    private boolean aj;
    private CJRLinkBasePaymentResponse ak;
    private LinearLayout al;
    private ShimmerFrameLayout am;
    private TextView ap;
    /* access modifiers changed from: private */
    public TextInputLayout aq;
    private ImageView ar;
    private final String au = "GOLD_JEWELLER_FLOW";
    private LottieAnimationView av;
    private RelativeLayout aw;
    private boolean ax;
    private boolean ay;
    private boolean az;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51122b = false;
    /* access modifiers changed from: private */
    public boolean bA = false;
    private boolean bB;
    private String bC;
    private String bD;
    /* access modifiers changed from: private */
    public boolean bE = false;
    /* access modifiers changed from: private */
    public boolean bF;
    private net.one97.paytm.n.c bG;
    private boolean bH = true;
    /* access modifiers changed from: private */
    public TextView bI;
    private boolean bJ = false;
    private String bK;
    private boolean bL;
    private boolean bM = true;
    /* access modifiers changed from: private */
    public boolean bN;
    private boolean bO;
    /* access modifiers changed from: private */
    public int bP = H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY;
    /* access modifiers changed from: private */
    public int bQ = e.C0905e.PAY.getType();
    private Runnable bR = new Runnable() {
        public final void run() {
            InputMethodManager inputMethodManager;
            if (g.this.isAdded() && (inputMethodManager = (InputMethodManager) g.this.f51126g.getSystemService("input_method")) != null) {
                if (g.this.L.hasFocus()) {
                    inputMethodManager.showSoftInput(g.this.L, 2);
                }
                if (g.this.k.hasFocus()) {
                    inputMethodManager.showSoftInput(g.this.k, 2);
                }
            }
        }
    };
    private net.one97.paytm.wallet.f.i bS = new net.one97.paytm.wallet.f.i() {
        public final void a(String str) {
        }

        public final void a() {
            g.w();
            g.this.a(Boolean.TRUE);
        }

        public final void b() {
            g.w();
            g.this.a(Boolean.FALSE);
        }

        public final void a(IJRDataModel iJRDataModel) {
            String str;
            String str2;
            net.one97.paytm.f.b.a().c();
            g.w();
            g.this.a(Boolean.FALSE);
            String f2 = g.this.S();
            String mobileNo = g.this.n.getMobileNo();
            String h2 = g.this.ae();
            if (g.this.v != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(g.this.v);
                h2 = sb.toString();
            }
            if (TextUtils.isEmpty(g.this.n.getComment())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(g.this.L.getText());
                str = sb2.toString();
            } else {
                str = g.this.n.getComment();
            }
            Intent h3 = net.one97.paytm.wallet.utility.a.h((Context) g.this.f51125f);
            h3.putExtra("key_via", "via_qr");
            h3.putExtra("phone_no", mobileNo);
            h3.putExtra("bundle", iJRDataModel);
            h3.putExtra("name", f2);
            h3.putExtra("qrScanTime", g.this.bb);
            h3.putExtra("suggested_instrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().C);
            h3.putExtra("used_instrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode());
            h3.putExtra("is_from_recent", g.this.bc);
            h3.putExtra("isAutoFlashTxn", g.this.bF);
            h3.putExtra("suggestedInstrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().C);
            h3.putExtra("isSingleAPI", g.this.bd);
            h3.putExtra("pay_mode_type", g.this.aR);
            h3.putExtra("pay_mode_load_time", g.this.aS);
            h3.putExtra("is_amt_already_present", !TextUtils.isEmpty(g.this.n.getTxnAmount()));
            h3.putExtra("isSingleAPI", g.this.bd);
            h3.putExtra("is_link_based_payment", g.this.aO);
            h3.putExtra("is_from_deeplink", g.this.bE);
            h3.putExtra("launchFrom", g.this.bQ);
            h3.putExtra("is_from_app_evoke", g.this.aD);
            if (!(g.this.n == null || g.this.n.getJson() == null)) {
                h3.putExtra("scan_result", g.this.n.getJson().toString());
            }
            if (!g.this.bf || g.this.bg.doubleValue() <= 0.0d) {
                h3.putExtra("is_pcf", true);
            } else {
                h3.putExtra("is_pcf", true);
                h3.putExtra("pcf_amount", g.this.bg);
            }
            if (g.this.aE != null) {
                g.this.z();
                h3.putExtras(g.this.aE);
            }
            h3.putExtra("is_static_qr_code", g.this.m());
            InstrumentInfo instrumentInfo = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
            if (instrumentInfo != null && !TextUtils.isEmpty(instrumentInfo.getPayMode())) {
                String payMode = instrumentInfo.getPayMode();
                String str3 = null;
                if (payMode.equalsIgnoreCase("UPI")) {
                    str2 = instrumentInfo.getAccountNumber();
                } else if (payMode.equalsIgnoreCase(SDKConstants.DEBIT)) {
                    String paymentDetails = instrumentInfo.getPaymentDetails();
                    if (!TextUtils.isEmpty(paymentDetails) && paymentDetails.contains("||")) {
                        str3 = paymentDetails.split("\\|")[0];
                    }
                    str2 = str3;
                    payMode = "SAVED_DC";
                } else if (payMode.equalsIgnoreCase(SDKConstants.CREDIT)) {
                    String paymentDetails2 = instrumentInfo.getPaymentDetails();
                    if (!TextUtils.isEmpty(paymentDetails2) && paymentDetails2.contains("||")) {
                        str3 = paymentDetails2.split("\\|")[0];
                    }
                    str2 = str3;
                    payMode = "SAVED_CC";
                } else {
                    str2 = instrumentInfo.getPaymentDetails();
                }
                h3.putExtra("pay_mode", payMode);
                h3.putExtra("unique_identifier", str2);
            }
            h3.putExtra("amount", String.valueOf(h2));
            h3.putExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL, String.valueOf(str));
            h3.putExtra("paymentMode", "p2m");
            h3.putExtra("paymentType", "pay");
            h3.putExtra("merchant_logo", g.this.n.getLogoURL());
            if (!TextUtils.isEmpty(g.this.n.getTagLine())) {
                h3.putExtra("tagline", g.this.n.getTagLine());
            }
            if (iJRDataModel instanceof CJRFastForwardResponse) {
                h3.putExtra("is_offline_pg", true);
                h3.putExtra("is_wallet_transection", true);
                h3.putExtra("prn", ((CJRFastForwardResponse) iJRDataModel).getFastForwardResponseDetail().getPrn());
            }
            h3.setFlags(67108864);
            if (!g.this.bE) {
                j.a().a((Context) g.this.getActivity());
            }
            if (g.this.aD) {
                g.this.getActivity().startActivityForResult(h3, 2002);
                return;
            }
            g.this.startActivity(h3);
            g.this.getActivity().setResult(-1);
            g.this.getActivity().finish();
        }
    };
    /* access modifiers changed from: private */
    public com.google.android.gms.location.d bT = new com.google.android.gms.location.d() {
        public final void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            Location a2 = locationResult.a();
            if (a2 != null) {
                String unused = g.this.bn = String.valueOf(a2.getLatitude());
                String unused2 = g.this.bo = String.valueOf(a2.getLongitude());
                net.one97.paytm.f.b.a().f50402a.setLatitude(g.this.bn);
                net.one97.paytm.f.b.a().f50402a.setLongitude(g.this.bo);
            }
            g.this.bp.a(g.this.bT);
        }
    };
    private boolean bV = false;
    private boolean ba;
    /* access modifiers changed from: private */
    public String bb;
    /* access modifiers changed from: private */
    public boolean bc;
    /* access modifiers changed from: private */
    public boolean bd;
    /* access modifiers changed from: private */
    public BigDecimal be;
    /* access modifiers changed from: private */
    public boolean bf;
    /* access modifiers changed from: private */
    public Double bg = Double.valueOf(0.0d);
    /* access modifiers changed from: private */
    public String bh;
    private InstrumentInfo bi;
    /* access modifiers changed from: private */
    public boolean bj;
    /* access modifiers changed from: private */
    public net.one97.paytm.wallet.i.a.c bk;
    private boolean bl;
    private boolean bm;
    /* access modifiers changed from: private */
    public String bn = null;
    /* access modifiers changed from: private */
    public String bo = null;
    /* access modifiers changed from: private */
    public com.google.android.gms.location.b bp;
    private h bq;
    private RelativeLayout br;
    /* access modifiers changed from: private */
    public LinearLayout bs;
    /* access modifiers changed from: private */
    public net.one97.paytm.p2mNewDesign.g.b bt;
    /* access modifiers changed from: private */
    public LinearLayout bu;
    private TextView bv;
    /* access modifiers changed from: private */
    public TextView bw;
    private boolean bx = false;
    /* access modifiers changed from: private */
    public String by;
    /* access modifiers changed from: private */
    public net.one97.paytm.p2mNewDesign.g.a bz;

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.wallet.d.e f51123c;

    /* renamed from: e  reason: collision with root package name */
    public h f51124e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f51125f;

    /* renamed from: g  reason: collision with root package name */
    public Context f51126g;

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.p2mNewDesign.j.b f51127h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f51128i;
    private TextView j;
    /* access modifiers changed from: private */
    public CustomAmountAnimatedEditText k;
    private RelativeLayout l;
    private ImageView m;
    /* access modifiers changed from: private */
    public CJRQRScanResultModel n;
    private m o;
    /* access modifiers changed from: private */
    public String p;
    private String q;
    private String r;
    private CJRPGTransactionParams s;
    private Dialog t;
    /* access modifiers changed from: private */
    public String u;
    /* access modifiers changed from: private */
    public BigDecimal v;
    private List<IJRDataModel> w = new ArrayList();
    private IJRDataModel x;
    private CollapsingToolbarLayout y;
    private ProgressDialog z;

    static /* synthetic */ void w() {
    }

    public final void a() {
    }

    public final void f() {
    }

    public final boolean j() {
        return false;
    }

    public void onDialogDismissed() {
    }

    public static g a(String str, String str2, boolean z2, boolean z3, boolean z4, boolean z5, String str3, boolean z6, String str4, boolean z7, boolean z8) {
        Bundle bundle = new Bundle();
        bundle.putString("data", str);
        bundle.putBoolean("isLinkP2P", false);
        bundle.putBoolean("isStaticQRWithEncryptData", z4);
        bundle.putBoolean("is_from_repeat_payment", z5);
        bundle.putString("qrScanTime", str3);
        bundle.putBoolean("is_from_recent", z6);
        bundle.putBoolean("isAutoFlashTxn", z7);
        bundle.putString("orderId", str4);
        bundle.putBoolean(UpiConstants.IS_GALLERY_SCAN, z8);
        q.d("qrScanResult=".concat(String.valueOf(str)));
        H = str2;
        g gVar = new g();
        gVar.setArguments(bundle);
        as = z2;
        at = z3;
        return gVar;
    }

    public static g a(String str, boolean z2, boolean z3, boolean z4, String str2, boolean z5, String str3, boolean z6) {
        Bundle bundle = new Bundle();
        bundle.putString("upidata", str);
        bundle.putBoolean("isLinkP2P", false);
        bundle.putBoolean("isStaticQRWithEncryptData", z4);
        bundle.putBoolean("is_from_repeat_payment", false);
        bundle.putBoolean("isFromUPIDeepink", true);
        bundle.putString("qrScanTime", str2);
        bundle.putBoolean("is_from_recent", z5);
        bundle.putBoolean("isAutoFlashTxn", z6);
        g gVar = new g();
        bundle.putString("orderId", str3);
        gVar.setArguments(bundle);
        as = z2;
        at = z3;
        return gVar;
    }

    public static g a(String str, CJRHomePageItem cJRHomePageItem, boolean z2, String str2, boolean z3, boolean z4) {
        Bundle bundle = new Bundle();
        bundle.putString("data", str);
        bundle.putString("deeplink_amount", cJRHomePageItem.getP2mamount());
        bundle.putString("deeplink_comment", cJRHomePageItem.getP2mComment());
        bundle.putString("deeplink_comment_enable", cJRHomePageItem.getP2mIsCommentEnable());
        bundle.putString("deeplink_amount_ebable", cJRHomePageItem.getP2mIsAmountEnable());
        bundle.putBoolean("isLinkP2P", false);
        bundle.putBoolean("is_from_recent", z3);
        bundle.putBoolean("isAutoFlashTxn", z4);
        bundle.putString("qrScanTime", str2);
        q.d("qrScanResult=".concat(String.valueOf(str)));
        g gVar = new g();
        gVar.setArguments(bundle);
        as = z2;
        return gVar;
    }

    public static g a(CJRLinkBasePaymentResponse cJRLinkBasePaymentResponse, String str, boolean z2, boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("link_base_payment_data", cJRLinkBasePaymentResponse);
        bundle.putBoolean("isLinkP2P", true);
        bundle.putString("qrScanTime", str);
        bundle.putBoolean("is_from_recent", z2);
        bundle.putBoolean("isAutoFlashTxn", z3);
        g gVar = new g();
        gVar.setArguments(bundle);
        return gVar;
    }

    public static g a(PaymentCombinationAPIResponse paymentCombinationAPIResponse, String str, boolean z2, boolean z3, Bundle bundle, String str2, boolean z4, boolean z5, boolean z6, int i2) {
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("extra_p2m_contact", paymentCombinationAPIResponse);
        bundle2.putString("mobile", str);
        bundle2.putBoolean("is_from_mobile_number", z3);
        bundle2.putBundle("sbBundle", bundle);
        bundle2.putBoolean("isLinkP2P", true);
        bundle2.putString("qrScanTime", str2);
        bundle2.putBoolean("is_from_recent", z4);
        bundle2.putBoolean("isAutoFlashTxn", z5);
        bundle2.putInt("launchFrom", i2);
        bundle2.putBoolean("is_from_app_evoke", z6);
        g gVar = new g();
        gVar.setArguments(bundle2);
        as = z2;
        return gVar;
    }

    public static g a(ConsolidatePaymentInstrumentationRes consolidatePaymentInstrumentationRes, String str, boolean z2, boolean z3, Bundle bundle, String str2, boolean z4, boolean z5) {
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("extra_p2m_contact", consolidatePaymentInstrumentationRes);
        bundle2.putString("mobile", str);
        bundle2.putBoolean("is_from_mobile_number", z3);
        bundle2.putBundle("sbBundle", bundle);
        bundle2.putBoolean("isLinkP2P", true);
        bundle2.putString("qrScanTime", str2);
        bundle2.putBoolean("is_from_recent", z4);
        bundle2.putBoolean("isAutoFlashTxn", z5);
        g gVar = new g();
        gVar.setArguments(bundle2);
        as = z2;
        return gVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        c cVar;
        View inflate = layoutInflater.inflate(R.layout.qr_proceed_to_pay_fragment_v3, viewGroup, false);
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "offline_pg_payment_order");
        this.af = new net.one97.paytm.jeweller.a(getActivity());
        try {
            JSONArray jSONArray = new JSONArray(stringFromGTM);
            this.J = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.J.add(jSONArray.getString(i2));
            }
        } catch (Exception unused) {
        }
        this.bI = (TextView) inflate.findViewById(R.id.tv_description_error);
        this.K = (NestedScrollView) inflate.findViewById(R.id.payments_options_sv);
        this.K.setFocusableInTouchMode(true);
        this.K.setNestedScrollingEnabled(true);
        this.aF = new d(this.f51126g);
        this.aG = (LinearLayout) inflate.findViewById(R.id.ll_top_alert_view);
        LinearLayout linearLayout = this.aG;
        d dVar = this.aF;
        dVar.f13399b = ((LayoutInflater) dVar.f13398a.getSystemService("layout_inflater")).inflate(R.layout.top_alert_view, (ViewGroup) null, false);
        linearLayout.addView(dVar.f13399b);
        this.aG.setVisibility(8);
        this.O = (LinearLayout) inflate.findViewById(R.id.payment_proceed_pay_btn_prefill_amount);
        this.Y = (TextView) this.O.findViewById(R.id.button_text_pay);
        this.O.setOnClickListener(this);
        this.ai = (TextView) inflate.findViewById(R.id.tv_qr_amount_error);
        this.av = (LottieAnimationView) inflate.findViewById(R.id.p2m_button_loader);
        this.aw = (RelativeLayout) inflate.findViewById(R.id.rl_transparent_view);
        this.f51128i = (TextView) inflate.findViewById(R.id.payment_proceed_tag_line);
        this.ar = (ImageView) inflate.findViewById(R.id.back);
        inflate.findViewById(R.id.back).setOnClickListener(this);
        this.j = (TextView) inflate.findViewById(R.id.payment_proceed_user_initials);
        this.l = (RelativeLayout) inflate.findViewById(R.id.merchant_logo_layout);
        this.m = (ImageView) inflate.findViewById(R.id.merchant_logo_niv);
        this.ab = (RelativeLayout) inflate.findViewById(R.id.rel_toolbar_view);
        this.al = (LinearLayout) inflate.findViewById(R.id.payment_options);
        this.B = (Toolbar) inflate.findViewById(R.id.toolbar);
        this.B.setNavigationIcon(R.drawable.p2m_ic_header_back);
        this.aH = (RelativeLayout) inflate.findViewById(R.id.merchant_status_container);
        this.aI = (ImageView) inflate.findViewById(R.id.merchant_veri_non_veri);
        this.ap = (TextView) inflate.findViewById(R.id.payment_title);
        this.br = (RelativeLayout) inflate.findViewById(R.id.lyt_mlv_view);
        this.bs = (LinearLayout) inflate.findViewById(R.id.lyt_mlv_view2);
        this.bu = (LinearLayout) inflate.findViewById(R.id.lyt_mlv_message_container);
        this.bv = (TextView) inflate.findViewById(R.id.tv_mlv_message);
        this.bw = (TextView) inflate.findViewById(R.id.button_text_pay_mlv_message);
        this.bz = new net.one97.paytm.p2mNewDesign.g.a(this.f51126g);
        this.B.setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.a("offline_payments", "post_scan_back_clicked", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", "", g.this.f51126g, "home/pay-send");
                g.this.W();
                g.this.getActivity().finish();
            }
        });
        this.B.setContentInsetStartWithNavigation(2);
        this.ah = (AppBarLayout) inflate.findViewById(R.id.appbar_ll);
        this.y = (CollapsingToolbarLayout) inflate.findViewById(R.id.collapsing_toolbar);
        this.y.setTitle(S());
        this.y.setExpandedTitleMarginEnd(com.paytm.utility.b.a(120.0f, this.f51126g));
        this.F = (CoordinatorLayout) inflate.findViewById(R.id.corrdinate);
        this.ac = (TextView) inflate.findViewById(R.id.payment_gold_comment_lbl);
        getResources().getDimension(R.dimen.dimen_10dp);
        this.L = (EditText) inflate.findViewById(R.id.et_description);
        this.aq = (TextInputLayout) inflate.findViewById(R.id.et_description1);
        this.U = (TextView) inflate.findViewById(R.id.tv_add_description);
        this.U.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.a("offline_payments", "post_scan_description_clicked", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", "", g.this.f51126g, "home/pay-send/post-scan");
                g.this.ad.setVisibility(8);
                g.this.U.setVisibility(8);
                g.this.L.setVisibility(0);
                g.this.aq.setVisibility(0);
                g.this.L.requestFocus();
                g.this.aq.requestFocus();
                g.this.U.setFocusable(true);
                g.this.X();
            }
        });
        this.V = (LinearLayout) inflate.findViewById(R.id.ll_keyboard_open);
        this.ad = (LinearLayout) this.V.findViewById(R.id.rel_gold_popup_bg);
        this.ad.setOnClickListener(this);
        this.ae = (TextView) this.ad.findViewById(R.id.txt_gold_popup_hint);
        this.ae.setText(Html.fromHtml(this.f51126g.getString(R.string.gold_jeweller_popup_text)));
        this.W = (LinearLayout) this.V.findViewById(R.id.ll_uni_expand_payment_inst_new);
        if (K()) {
            net.one97.paytm.jeweller.a.a(this.f51126g, "/digital_gold_offline/pay_screen", "digital_gold_offline", "home_screen_loaded", "gold_balance_available", S(), com.paytm.utility.b.n(this.f51126g));
            net.one97.paytm.jeweller.a.a(this.f51126g, "/digital_gold_offline/pay_screen");
            this.ab.setPadding(E(), 0, 0, 0);
            LinearLayout linearLayout2 = this.W;
            int E2 = E();
            try {
                if (linearLayout2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) linearLayout2.getLayoutParams()).setMargins(0, 0, 0, E2);
                    linearLayout2.requestLayout();
                }
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        }
        final EditText editText = (EditText) inflate.findViewById(R.id.et_description);
        if (!TextUtils.isEmpty(this.p)) {
            editText.setHint(this.p);
        }
        this.k = (CustomAmountAnimatedEditText) inflate.findViewById(R.id.et_amount);
        this.k.setOnClickListener(this);
        this.k.setFocusable(true);
        this.k.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    g.a("offline_payments", "post_scan_amount_clicked", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", "", g.this.f51126g, "home/pay-send/post-scan");
                }
            }
        });
        this.k.setOnEditTextImeBackListener(new CustomAmountAnimatedEditText.d() {
        });
        this.k.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return false;
            }
        });
        this.L.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!TextUtils.isEmpty(g.this.p)) {
                    editText.setHint(g.this.p);
                }
            }
        });
        this.L.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return false;
            }
        });
        this.k.setLongClickable(false);
        this.k.setTextIsSelectable(false);
        CustomAmountAnimatedEditText customAmountAnimatedEditText = this.k;
        if (customAmountAnimatedEditText != null && TextUtils.isEmpty(customAmountAnimatedEditText.getText())) {
            this.n.isPgEnabled();
        }
        if (!this.n.isPgEnabled() && !K()) {
            inflate.findViewById(R.id.et_description).setVisibility(8);
            inflate.findViewById(R.id.et_description1).setVisibility(8);
        }
        net.one97.paytm.f.b.a().a(this.f51125f, S(), this.n.getMobileNo(), false, net.one97.paytm.wallet.utility.h.P2M.getValue(), com.paytm.utility.b.s((Context) getActivity()), com.paytm.utility.b.t((Context) getActivity()));
        net.one97.paytm.wallet.utility.a.d(this.f51125f);
        this.aU = (a) am.a((FragmentActivity) this.f51125f, (al.b) new net.one97.paytm.p2mNewDesign.i.b(this.f51125f.getApplication())).a(a.class);
        if (!"QR_CODE_REQUEST_MONEY".equalsIgnoreCase(this.n.getRequestType())) {
            this.u = this.f51126g.getString(R.string.pay);
            str = "";
        } else if (StringSet.user.equalsIgnoreCase(this.n.getPayeeType())) {
            if (!TextUtils.isEmpty(S())) {
                str = this.f51126g.getString(R.string.send_money_to, new Object[]{S()});
            } else {
                str = this.f51126g.getString(R.string.send_money);
            }
            this.u = this.f51126g.getString(R.string.send);
        } else {
            str = this.f51126g.getString(R.string.you_are_paying);
            this.u = this.f51126g.getString(R.string.pay);
        }
        if (com.paytm.utility.b.r(this.f51126g)) {
            aj();
            if (this.n.isPgEnabled()) {
                b(false);
            } else {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().x = false;
            }
            this.T = false;
            if (com.paytm.utility.b.c(this.f51126g)) {
                if (this.aW && !this.bB) {
                    net.one97.paytm.b.a.e.a();
                    if (net.one97.paytm.b.a.e.f()) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("ssotoken", com.paytm.utility.a.q(this.f51125f));
                        hashMap.put("Content-Type", "application/json");
                        if (com.paytm.utility.b.c((Context) this.f51125f)) {
                            this.bA = true;
                            this.f51127h.b(true);
                        }
                        net.one97.paytm.b.a.e.a();
                        net.one97.paytm.b.a.e.d().removeObservers(this);
                        net.one97.paytm.b.a.e.a().a(this.f51125f, this.bD, this.n.getQrCodeId(), hashMap);
                    }
                }
                as();
            } else {
                net.one97.paytm.b.a.e.a();
                if (!net.one97.paytm.b.a.e.f()) {
                    l();
                }
            }
        } else {
            startActivityForResult(new Intent(this.f51126g, net.one97.paytm.wallet.communicator.b.a().getAuthActivityClass()), 4);
        }
        D();
        Application application = this.f51125f.getApplication();
        PaymentInstrumentDatabase a2 = PaymentInstrumentDatabase.f51202a.a(application);
        String n2 = com.paytm.utility.b.n(this.f51126g);
        String mappingId = this.n.getMappingId();
        if (!TextUtils.isEmpty(mappingId) && !TextUtils.isEmpty(n2)) {
            this.aT = (c) am.a((FragmentActivity) this.f51125f, (al.b) new net.one97.paytm.p2mNewDesign.i.d(a2, application, mappingId, n2)).a(c.class);
        }
        if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.f51125f, "InstrumentCacheEnabledAndroid", false) && (cVar = this.aT) != null) {
            cVar.f51300c.observe(this, new z<net.one97.paytm.p2mNewDesign.db.b.b>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    net.one97.paytm.p2mNewDesign.db.b.b bVar = (net.one97.paytm.p2mNewDesign.db.b.b) obj;
                    if (bVar != null) {
                        net.one97.paytm.p2mNewDesign.models.b c2 = net.one97.paytm.p2mNewDesign.models.b.c();
                        if (c2.f56928b != null) {
                            Long valueOf = Long.valueOf(Calendar.getInstance().getTimeInMillis() - c2.f56928b.longValue());
                            new StringBuilder("Tcache=").append(valueOf);
                            c2.f56927a.setTcache(valueOf);
                        }
                        at.a().a(at.a.Tcached, System.currentTimeMillis(), "");
                        CJRFetchPayMethodResponse cJRFetchPayMethodResponse = (CJRFetchPayMethodResponse) new f().a(bVar.f51238d, CJRFetchPayMethodResponse.class);
                        if (cJRFetchPayMethodResponse.getBody() != null && cJRFetchPayMethodResponse.getBody().getMerchantPayOption() != null) {
                            boolean unused = g.this.aN = true;
                            boolean unused2 = g.this.aP = true;
                            new StringBuilder("Instrument Loaded From Cache ").append(System.currentTimeMillis());
                            g.this.a((IJRPaytmDataModel) cJRFetchPayMethodResponse);
                            if (TextUtils.isEmpty(g.this.aR)) {
                                String unused3 = g.this.aR = "cache";
                                g gVar = g.this;
                                StringBuilder sb = new StringBuilder();
                                sb.append(System.currentTimeMillis());
                                String unused4 = gVar.aS = sb.toString();
                            }
                            new StringBuilder("Instrument Displayed on Screen ").append(System.currentTimeMillis());
                        } else if (!com.paytm.utility.b.c(g.this.f51126g)) {
                            g.this.l();
                        }
                    }
                }
            });
        }
        m mVar = this.o;
        if (mVar != null) {
            mVar.a(str);
        }
        this.I = new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f1, code lost:
                if (kotlin.m.p.a(r13.getPayMode(), net.one97.paytm.nativesdk.Constants.SDKConstants.CREDIT, false) != false) goto L_0x00f3;
             */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x05ef A[Catch:{ Exception -> 0x0790 }] */
            /* JADX WARNING: Removed duplicated region for block: B:179:0x06c0 A[Catch:{ Exception -> 0x0790 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void afterTextChanged(android.text.Editable r20) {
                /*
                    r19 = this;
                    r1 = r19
                    java.lang.String r2 = "DirectPaymentBl.getInsta…().selectedInstrumentInfo"
                    java.lang.String r3 = "DirectPaymentBl.getInstance()"
                    int r4 = r20.length()     // Catch:{ Exception -> 0x0790 }
                    r5 = 8
                    java.lang.String r6 = ""
                    if (r4 <= 0) goto L_0x077d
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    boolean r4 = r4.E     // Catch:{ Exception -> 0x0790 }
                    r7 = 0
                    if (r4 == 0) goto L_0x0020
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    r4.a((java.lang.String) r7)     // Catch:{ Exception -> 0x0790 }
                L_0x0020:
                    java.lang.String r4 = r20.toString()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r8 = "[₹, ]"
                    java.lang.String r4 = r4.replaceAll(r8, r6)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r8 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText r8 = r8.k     // Catch:{ Exception -> 0x0790 }
                    r8.removeTextChangedListener(r1)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r8 = "^\\s+"
                    java.lang.String r4 = r4.replaceAll(r8, r6)     // Catch:{ Exception -> 0x0790 }
                    boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ NumberFormatException -> 0x0063 }
                    if (r8 != 0) goto L_0x0059
                    java.lang.String r8 = "."
                    boolean r8 = r4.contains(r8)     // Catch:{ NumberFormatException -> 0x0063 }
                    if (r8 == 0) goto L_0x0052
                    net.one97.paytm.p2mNewDesign.d.g r8 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ NumberFormatException -> 0x0063 }
                    java.lang.String r6 = r8.h((java.lang.String) r4)     // Catch:{ NumberFormatException -> 0x0063 }
                    goto L_0x006c
                L_0x0052:
                    net.one97.paytm.p2mNewDesign.d.g r8 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ NumberFormatException -> 0x0063 }
                    java.lang.String r6 = net.one97.paytm.p2mNewDesign.d.g.d(r8, r4)     // Catch:{ NumberFormatException -> 0x0063 }
                    goto L_0x006c
                L_0x0059:
                    net.one97.paytm.p2mNewDesign.d.g r8 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ NumberFormatException -> 0x0063 }
                    net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r8 = r8.n     // Catch:{ NumberFormatException -> 0x0063 }
                    r8.setmTxnAmount(r6)     // Catch:{ NumberFormatException -> 0x0063 }
                    goto L_0x006c
                L_0x0063:
                    r0 = move-exception
                    r8 = r0
                    java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0790 }
                    com.paytm.utility.q.d(r8)     // Catch:{ Exception -> 0x0790 }
                L_0x006c:
                    net.one97.paytm.p2mNewDesign.d.g r8 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText r8 = r8.k     // Catch:{ Exception -> 0x0790 }
                    r8.setText(r6)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText r6 = r6.k     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r8 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText r8 = r8.k     // Catch:{ Exception -> 0x0790 }
                    android.text.Editable r8 = r8.getText()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0790 }
                    int r8 = r8.length()     // Catch:{ Exception -> 0x0790 }
                    r6.setSelection(r8)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.j.b r6 = r6.f51127h     // Catch:{ Exception -> 0x0790 }
                    r8 = 1
                    r9 = 0
                    if (r6 == 0) goto L_0x01df
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    boolean r6 = r6.bj     // Catch:{ Exception -> 0x0790 }
                    if (r6 == 0) goto L_0x01df
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.j.b r6 = r6.f51127h     // Catch:{ Exception -> 0x0790 }
                    boolean r10 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0790 }
                    if (r10 != 0) goto L_0x01df
                    double r10 = java.lang.Double.parseDouble(r4)     // Catch:{ Exception -> 0x01df }
                    net.one97.paytm.p2mNewDesign.e.c r6 = r6.f13378f     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r12 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r12 = r12.n     // Catch:{ Exception -> 0x0790 }
                    if (r12 == 0) goto L_0x01df
                    java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r12 = r6.f51255b     // Catch:{ Exception -> 0x0790 }
                    java.util.List r12 = (java.util.List) r12     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r13 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r13 = r13.n     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r13 = r13.getPayMode()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r14 = "DEBIT_CARD"
                    boolean r13 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r14, (boolean) r9)     // Catch:{ Exception -> 0x0790 }
                    if (r13 != 0) goto L_0x00f3
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r13 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r13 = r13.n     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r13 = r13.getPayMode()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r14 = "CREDIT_CARD"
                    boolean r13 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r14, (boolean) r9)     // Catch:{ Exception -> 0x0790 }
                    if (r13 == 0) goto L_0x01c3
                L_0x00f3:
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r13 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r13 = r13.n     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r13 = r13.getCardLastFourDigit()     // Catch:{ Exception -> 0x0790 }
                    if (r13 == 0) goto L_0x017b
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0790 }
                    r13.<init>()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r14 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r14 = r14.n     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r14 = r14.getPayMode()     // Catch:{ Exception -> 0x0790 }
                    r13.append(r14)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r14 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r3)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r14 = r14.n     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r14 = r14.getCardLastFourDigit()     // Catch:{ Exception -> 0x0790 }
                    r13.append(r14)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.e.a r13 = r6.c((java.lang.String) r13)     // Catch:{ Exception -> 0x0790 }
                    java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0790 }
                    r14.<init>()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r15 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r15 = r15.n     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r15 = r15.getPayMode()     // Catch:{ Exception -> 0x0790 }
                    r14.append(r15)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r15 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r3)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r15.n     // Catch:{ Exception -> 0x0790 }
                    kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r3.getCardLastFourDigit()     // Catch:{ Exception -> 0x0790 }
                    r14.append(r2)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r14.toString()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.e.a r2 = r6.c((java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    if (r13 == 0) goto L_0x0173
                    net.one97.paytm.p2mNewDesign.e.a.a r13 = (net.one97.paytm.p2mNewDesign.e.a.a) r13     // Catch:{ Exception -> 0x0790 }
                    r13.a((double) r10)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x01c3
                L_0x0173:
                    if (r2 == 0) goto L_0x01c3
                    net.one97.paytm.p2mNewDesign.e.a.a r2 = (net.one97.paytm.p2mNewDesign.e.a.a) r2     // Catch:{ Exception -> 0x0790 }
                    r2.a((double) r10)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x01c3
                L_0x017b:
                    r2 = r12
                    java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x0790 }
                    java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0790 }
                L_0x0182:
                    boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0790 }
                    if (r3 == 0) goto L_0x01c3
                    java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.e.a r3 = (net.one97.paytm.p2mNewDesign.e.a) r3     // Catch:{ Exception -> 0x0790 }
                    boolean r6 = r3 instanceof net.one97.paytm.p2mNewDesign.e.a.d     // Catch:{ Exception -> 0x0790 }
                    if (r6 == 0) goto L_0x0182
                    net.one97.paytm.p2mNewDesign.e.a.d r3 = (net.one97.paytm.p2mNewDesign.e.a.d) r3     // Catch:{ Exception -> 0x0790 }
                    boolean r6 = r3.f13296d     // Catch:{ Exception -> 0x0790 }
                    if (r6 == 0) goto L_0x0182
                    boolean r6 = r3.f13294a     // Catch:{ Exception -> 0x0790 }
                    if (r6 == 0) goto L_0x0182
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.D()     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0790 }
                    double r13 = r6.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    int r6 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
                    if (r6 <= 0) goto L_0x01b4
                    r3.d()     // Catch:{ Exception -> 0x0790 }
                    goto L_0x0182
                L_0x01b4:
                    r3.d()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    r6.F = r8     // Catch:{ Exception -> 0x0790 }
                    android.widget.RelativeLayout r3 = r3.f13295b     // Catch:{ Exception -> 0x0790 }
                    r3.setVisibility(r9)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x0182
                L_0x01c3:
                    java.lang.Iterable r12 = (java.lang.Iterable) r12     // Catch:{ Exception -> 0x0790 }
                    java.util.Iterator r2 = r12.iterator()     // Catch:{ Exception -> 0x0790 }
                L_0x01c9:
                    boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0790 }
                    if (r3 == 0) goto L_0x01df
                    java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.e.a r3 = (net.one97.paytm.p2mNewDesign.e.a) r3     // Catch:{ Exception -> 0x0790 }
                    boolean r6 = r3 instanceof net.one97.paytm.p2mNewDesign.e.a.a     // Catch:{ Exception -> 0x0790 }
                    if (r6 == 0) goto L_0x01c9
                    net.one97.paytm.p2mNewDesign.e.a.a r3 = (net.one97.paytm.p2mNewDesign.e.a.a) r3     // Catch:{ Exception -> 0x0790 }
                    r3.b((double) r10)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x01c9
                L_0x01df:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r3 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r3 = r3.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r6 = net.one97.paytm.wallet.R.string.pay     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r3 = r3.getString(r6)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String unused = r2.u = r3     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.isGold()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r3 = "BALANCE"
                    if (r2 == 0) goto L_0x021f
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x021f
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getPayMode()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = "Gold"
                    boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x021f
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    r2.g((java.lang.String) r4)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x05e7
                L_0x021f:
                    boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0790 }
                    if (r2 != 0) goto L_0x05c0
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = "#0.00"
                    r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                    r12 = 0
                    java.lang.String r14 = " "
                    if (r2 == 0) goto L_0x03b7
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getPayMode()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x03b7
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.f13087c     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x03b7
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.f13087c     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getTotalBalance()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0790 }
                    if (r2 != 0) goto L_0x03b7
                    java.lang.Double r2 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0790 }
                    double r15 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.f13087c     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getTotalBalance()     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x0790 }
                    double r17 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    int r2 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
                    if (r2 <= 0) goto L_0x03b7
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.f13087c     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.isWalletAPIFAIL()     // Catch:{ Exception -> 0x0790 }
                    if (r2 != 0) goto L_0x03b7
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.f13087c     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.isDummyWalletView()     // Catch:{ Exception -> 0x0790 }
                    if (r2 != 0) goto L_0x03b7
                    java.lang.Double r2 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0790 }
                    double r15 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.f13087c     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getTotalBalance()     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x0790 }
                    double r17 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    double r15 = r15 - r17
                    int r2 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
                    if (r2 <= 0) goto L_0x02bb
                    int r2 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
                    if (r2 >= 0) goto L_0x02bb
                    double r15 = java.lang.Math.ceil(r15)     // Catch:{ Exception -> 0x0790 }
                L_0x02bb:
                    r10 = r15
                    java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0790 }
                    r2.<init>(r6)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.format(r10)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r5.h((java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r5 = r5.n     // Catch:{ Exception -> 0x0790 }
                    if (r5 == 0) goto L_0x0367
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r5 = r5.n     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r5 = r5.getPayMode()     // Catch:{ Exception -> 0x0790 }
                    boolean r5 = r3.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0790 }
                    if (r5 == 0) goto L_0x0367
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    boolean r5 = r5.s(r4)     // Catch:{ Exception -> 0x0790 }
                    if (r5 == 0) goto L_0x0367
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    boolean r5 = r5.E()     // Catch:{ Exception -> 0x0790 }
                    if (r5 == 0) goto L_0x0367
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r2 = r2.H     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0328
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    r2.l((java.lang.String) r4)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r5 = r5.H     // Catch:{ Exception -> 0x0790 }
                    boolean r5 = r5.isChecked()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = com.paytm.utility.b.Q((java.lang.String) r4)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r10 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    com.paytm.utility.b.Q((java.lang.String) r4)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r11 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r11 = r11.H     // Catch:{ Exception -> 0x0790 }
                    boolean r10 = r10.a((boolean) r9, (net.one97.paytm.p2mNewDesign.g.c) r11)     // Catch:{ Exception -> 0x0790 }
                    r2.a((boolean) r5, (java.lang.String) r6, (boolean) r10)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x05e7
                L_0x0328:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.widget.TextView r2 = r2.Y     // Catch:{ Exception -> 0x0790 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0790 }
                    r5.<init>()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r6 = r6.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r10 = net.one97.paytm.wallet.R.string.pay     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.getString(r10)     // Catch:{ Exception -> 0x0790 }
                    r5.append(r6)     // Catch:{ Exception -> 0x0790 }
                    r5.append(r14)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r6 = r6.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r10 = net.one97.paytm.wallet.R.string.rs_symbol     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.getString(r10)     // Catch:{ Exception -> 0x0790 }
                    r5.append(r6)     // Catch:{ Exception -> 0x0790 }
                    r5.append(r14)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x0790 }
                    r5.append(r6)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0790 }
                    r2.setText(r5)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x05e7
                L_0x0367:
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r5 = r5.H     // Catch:{ Exception -> 0x0790 }
                    if (r5 == 0) goto L_0x0398
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    r5.l((java.lang.String) r4)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r6 = r6.H     // Catch:{ Exception -> 0x0790 }
                    boolean r6 = r6.isChecked()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r10 = com.paytm.utility.b.Q((java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r11 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    com.paytm.utility.b.Q((java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r2 = r2.H     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r11.a((boolean) r8, (net.one97.paytm.p2mNewDesign.g.c) r2)     // Catch:{ Exception -> 0x0790 }
                    r5.a((boolean) r6, (java.lang.String) r10, (boolean) r2)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x05e7
                L_0x0398:
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.widget.TextView r5 = r5.Y     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r6 = r6.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r10 = net.one97.paytm.wallet.R.string.add_money_to_pay     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.getString(r10)     // Catch:{ Exception -> 0x0790 }
                    java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0790 }
                    r10[r9] = r2     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = java.lang.String.format(r6, r10)     // Catch:{ Exception -> 0x0790 }
                    r5.setText(r2)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x05e7
                L_0x03b7:
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0552
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getPayMode()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r15 = "GIFT_VOUCHER"
                    boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0552
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.l     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0552
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.l     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getTotalBalance()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0790 }
                    if (r2 != 0) goto L_0x0552
                    java.lang.Double r2 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0790 }
                    double r15 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.l     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getTotalBalance()     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x0790 }
                    double r17 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    int r2 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
                    if (r2 <= 0) goto L_0x0552
                    java.lang.Double r2 = java.lang.Double.valueOf(r4)     // Catch:{ Exception -> 0x0790 }
                    double r14 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.l     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getTotalBalance()     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x0790 }
                    double r16 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    double r14 = r14 - r16
                    int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
                    if (r2 <= 0) goto L_0x042f
                    int r2 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
                    if (r2 >= 0) goto L_0x042f
                    double r14 = java.lang.Math.ceil(r14)     // Catch:{ Exception -> 0x0790 }
                L_0x042f:
                    java.text.DecimalFormat r2 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0790 }
                    r2.<init>(r6)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.format(r14)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r6.h((java.lang.String) r2)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r6 = r6.H     // Catch:{ Exception -> 0x0790 }
                    if (r6 == 0) goto L_0x052a
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r6 = r6.H     // Catch:{ Exception -> 0x0790 }
                    boolean r6 = r6.isChecked()     // Catch:{ Exception -> 0x0790 }
                    if (r6 == 0) goto L_0x052a
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r2 = r2.H     // Catch:{ Exception -> 0x0790 }
                    java.text.DecimalFormat r5 = net.one97.paytm.p2mNewDesign.d.g.bU     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.ae()     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0790 }
                    double r10 = r6.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r2.getRedeemablePercentage()     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0790 }
                    double r14 = r6.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    double r10 = r10 * r14
                    r14 = 4636737291354636288(0x4059000000000000, double:100.0)
                    double r10 = r10 / r14
                    java.lang.String r5 = r5.format(r10)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0790 }
                    double r10 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r2.getTotalAvailableBalance()     // Catch:{ Exception -> 0x0790 }
                    double r14 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x0790 }
                    int r6 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
                    if (r6 <= 0) goto L_0x0497
                    java.lang.String r5 = r2.getTotalAvailableBalance()     // Catch:{ Exception -> 0x0790 }
                L_0x0497:
                    java.text.DecimalFormat r2 = net.one97.paytm.p2mNewDesign.d.g.bU     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.ae()     // Catch:{ Exception -> 0x0790 }
                    double r10 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r6.l     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.getTotalBalance()     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ Exception -> 0x0790 }
                    double r14 = r6.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    double r10 = r10 - r14
                    double r14 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x0790 }
                    double r10 = r10 - r14
                    java.lang.String r2 = r2.format(r10)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r6 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x0790 }
                    double r10 = r6.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    int r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                    if (r6 <= 0) goto L_0x04ef
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.widget.TextView r5 = r5.Y     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r6 = r6.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r10 = net.one97.paytm.wallet.R.string.p2m_gv_buypurchase     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.getString(r10)     // Catch:{ Exception -> 0x0790 }
                    java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0790 }
                    r10[r9] = r2     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = java.lang.String.format(r6, r10)     // Catch:{ Exception -> 0x0790 }
                    r5.setText(r2)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x0523
                L_0x04ef:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.widget.TextView r2 = r2.Y     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r6 = r6.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r10 = net.one97.paytm.wallet.R.string.mlv_pay_button_text_new     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.getString(r10)     // Catch:{ Exception -> 0x0790 }
                    java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0790 }
                    java.text.DecimalFormat r11 = net.one97.paytm.p2mNewDesign.d.g.bU     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r12 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r12 = r12.ae()     // Catch:{ Exception -> 0x0790 }
                    double r12 = java.lang.Double.parseDouble(r12)     // Catch:{ Exception -> 0x0790 }
                    double r14 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x0790 }
                    double r12 = r12 - r14
                    java.lang.String r5 = r11.format(r12)     // Catch:{ Exception -> 0x0790 }
                    r10[r9] = r5     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r5 = java.lang.String.format(r6, r10)     // Catch:{ Exception -> 0x0790 }
                    r2.setText(r5)     // Catch:{ Exception -> 0x0790 }
                L_0x0523:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    r2.l((java.lang.String) r4)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x05e7
                L_0x052a:
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.widget.TextView r6 = r6.Y     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r10 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r10 = r10.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r11 = net.one97.paytm.wallet.R.string.p2m_gv_buypurchase     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r10 = r10.getString(r11)     // Catch:{ Exception -> 0x0790 }
                    java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0790 }
                    r11[r9] = r2     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = java.lang.String.format(r10, r11)     // Catch:{ Exception -> 0x0790 }
                    r6.setText(r2)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.widget.TextView r2 = r2.bw     // Catch:{ Exception -> 0x0790 }
                    r2.setVisibility(r5)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x05e7
                L_0x0552:
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r2 = r2.H     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0582
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    r2.l((java.lang.String) r4)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r5 = r5.H     // Catch:{ Exception -> 0x0790 }
                    boolean r5 = r5.isChecked()     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = com.paytm.utility.b.Q((java.lang.String) r4)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r10 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    com.paytm.utility.b.Q((java.lang.String) r4)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r11 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r11 = r11.H     // Catch:{ Exception -> 0x0790 }
                    boolean r10 = r10.a((boolean) r9, (net.one97.paytm.p2mNewDesign.g.c) r11)     // Catch:{ Exception -> 0x0790 }
                    r2.a((boolean) r5, (java.lang.String) r6, (boolean) r10)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x05e7
                L_0x0582:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.widget.TextView r2 = r2.Y     // Catch:{ Exception -> 0x0790 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0790 }
                    r5.<init>()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r6 = r6.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r10 = net.one97.paytm.wallet.R.string.pay     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.getString(r10)     // Catch:{ Exception -> 0x0790 }
                    r5.append(r6)     // Catch:{ Exception -> 0x0790 }
                    r5.append(r14)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r6 = r6.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r10 = net.one97.paytm.wallet.R.string.rs_symbol     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r6.getString(r10)     // Catch:{ Exception -> 0x0790 }
                    r5.append(r6)     // Catch:{ Exception -> 0x0790 }
                    r5.append(r14)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x0790 }
                    r5.append(r6)     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0790 }
                    r2.setText(r5)     // Catch:{ Exception -> 0x0790 }
                    goto L_0x05e7
                L_0x05c0:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.widget.TextView r2 = r2.Y     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r5 = r5.u     // Catch:{ Exception -> 0x0790 }
                    r2.setText(r5)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.j.b r2 = r2.f51127h     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x05e7
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.j.b r2 = r2.f51127h     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.e.c r2 = r2.f13378f     // Catch:{ Exception -> 0x0790 }
                    r2.h()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g.J(r2)     // Catch:{ Exception -> 0x0790 }
                L_0x05e7:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.j.b r2 = r2.f51127h     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x06b1
                    boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0790 }
                    if (r2 != 0) goto L_0x0632
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0632
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getPayMode()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r3.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0632
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.s(r4)     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0632
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.E()     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0632
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r5 = r5.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r6 = net.one97.paytm.wallet.R.string.insufficient_wallet_balance_p2m_merchant_fail     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r5 = r5.getString(r6)     // Catch:{ Exception -> 0x0790 }
                    r2.a((java.lang.String) r5, (boolean) r9, (boolean) r9)     // Catch:{ Exception -> 0x0790 }
                L_0x0632:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.j.b r2 = r2.f51127h     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r5 = r5.d()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    boolean unused = r6.aN     // Catch:{ Exception -> 0x0790 }
                    r2.b((java.lang.String) r5)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r2 = r2.J     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x066e
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r2 = r2.H     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x066e
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.k((java.lang.String) r4)     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x066e
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    r2.L = r8     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.j.b r2 = r2.f51127h     // Catch:{ Exception -> 0x0790 }
                    r2.c()     // Catch:{ Exception -> 0x0790 }
                    goto L_0x0685
                L_0x066e:
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.L     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0685
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    r2.L = r9     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.j.b r2 = r2.f51127h     // Catch:{ Exception -> 0x0790 }
                    r2.f()     // Catch:{ Exception -> 0x0790 }
                L_0x0685:
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r2 = r2.J     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x06b1
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.g.c r2 = r2.H     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x06b1
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.L     // Catch:{ Exception -> 0x0790 }
                    if (r2 != 0) goto L_0x06b1
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.j.b r2 = r2.f51127h     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r5 = r5.d()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r6 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    boolean unused = r6.aN     // Catch:{ Exception -> 0x0790 }
                    r2.b((java.lang.String) r5)     // Catch:{ Exception -> 0x0790 }
                L_0x06b1:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText r2 = r2.k     // Catch:{ Exception -> 0x0790 }
                    r2.addTextChangedListener(r1)     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0790 }
                    if (r2 != 0) goto L_0x0777
                    double r5 = java.lang.Double.parseDouble(r4)     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r2 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    boolean r5 = r5.bN     // Catch:{ Exception -> 0x0790 }
                    if (r5 == 0) goto L_0x0705
                    double r5 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r10 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    int r10 = r10.bP     // Catch:{ Exception -> 0x0790 }
                    double r10 = (double) r10     // Catch:{ Exception -> 0x0790 }
                    int r5 = java.lang.Double.compare(r5, r10)     // Catch:{ Exception -> 0x0790 }
                    if (r5 != r8) goto L_0x0705
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r3 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r3 = r3.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r4 = net.one97.paytm.wallet.R.string.gallery_max_amount_p2m     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x0790 }
                    java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r5 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    int r5 = r5.bP     // Catch:{ Exception -> 0x0790 }
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0790 }
                    r4[r9] = r5     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ Exception -> 0x0790 }
                    r2.a((boolean) r8, (java.lang.String) r3)     // Catch:{ Exception -> 0x0790 }
                    return
                L_0x0705:
                    double r5 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    java.lang.Double r2 = net.one97.paytm.wallet.utility.j.f72322a     // Catch:{ Exception -> 0x0790 }
                    double r10 = r2.doubleValue()     // Catch:{ Exception -> 0x0790 }
                    int r2 = java.lang.Double.compare(r5, r10)     // Catch:{ Exception -> 0x0790 }
                    if (r2 == r8) goto L_0x071f
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.r(r4)     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0739
                L_0x071f:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.aO     // Catch:{ Exception -> 0x0790 }
                    if (r2 != 0) goto L_0x0739
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r3 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r3 = r3.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r4 = net.one97.paytm.wallet.R.string.max_amount_payable_p2m     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x0790 }
                    r2.a((boolean) r8, (java.lang.String) r3)     // Catch:{ Exception -> 0x0790 }
                    return
                L_0x0739:
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0777
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r2 = r2.getPayMode()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r3.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0777
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.s(r4)     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0777
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0790 }
                    boolean r2 = r2.E()     // Catch:{ Exception -> 0x0790 }
                    if (r2 == 0) goto L_0x0777
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r3 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.content.Context r3 = r3.f51126g     // Catch:{ Exception -> 0x0790 }
                    int r4 = net.one97.paytm.wallet.R.string.insufficient_wallet_balance_p2m_merchant_fail     // Catch:{ Exception -> 0x0790 }
                    java.lang.String r3 = r3.getString(r4)     // Catch:{ Exception -> 0x0790 }
                    r2.a((java.lang.String) r3, (boolean) r9, (boolean) r9)     // Catch:{ Exception -> 0x0790 }
                    return
                L_0x0777:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    r2.a((boolean) r9, (java.lang.String) r7)     // Catch:{ Exception -> 0x0790 }
                    return
                L_0x077d:
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r2 = r2.n     // Catch:{ Exception -> 0x0790 }
                    r2.setmTxnAmount(r6)     // Catch:{ Exception -> 0x0790 }
                    net.one97.paytm.p2mNewDesign.d.g r2 = net.one97.paytm.p2mNewDesign.d.g.this     // Catch:{ Exception -> 0x0790 }
                    android.widget.TextView r2 = r2.ac     // Catch:{ Exception -> 0x0790 }
                    r2.setVisibility(r5)     // Catch:{ Exception -> 0x0790 }
                    return
                L_0x0790:
                    r0 = move-exception
                    r2 = r0
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    r3.append(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.g.AnonymousClass7.afterTextChanged(android.text.Editable):void");
            }
        };
        this.k.addTextChangedListener(this.I);
        if (this.n.isPgEnabled()) {
            this.ap.setText(R.string.p2mtitlemigrated);
        }
        this.aX = (LinearLayout) inflate.findViewById(R.id.inactive_merchant_message_view);
        this.aY = (TextView) inflate.findViewById(R.id.inactive_merchant_message);
        this.aZ = (Button) inflate.findViewById(R.id.inactive_merchant_cta);
        this.aZ.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.a(view);
            }
        });
        String stringFromGTM2 = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f51125f, "galleryScanMaxAmount");
        if (!TextUtils.isEmpty(stringFromGTM2)) {
            this.bP = Integer.parseInt(stringFromGTM2);
        }
        F();
        if (getArguments() != null && !TextUtils.isEmpty(getArguments().getString("data"))) {
            try {
                JSONObject jSONObject = new JSONObject(getArguments().getString("data"));
                String optString = jSONObject.optString(CJRQRScanResultModel.KEY_ORIGIN);
                String optString2 = jSONObject.optString("TXN_AMOUNT");
                if (!TextUtils.isEmpty(optString)) {
                    this.bE = true;
                    RiskExtendedInfo riskExtendedInfo = net.one97.paytm.f.b.a().f50402a;
                    riskExtendedInfo.setMode("deeplink");
                    riskExtendedInfo.setScanType("active");
                    this.U.setVisibility(8);
                    this.L.setVisibility(8);
                    this.aq.setVisibility(8);
                    String string = getArguments().getString("deeplink_amount");
                    String string2 = getArguments().getString("deeplink_comment");
                    String string3 = getArguments().getString("deeplink_amount_ebable");
                    String string4 = getArguments().getString("deeplink_comment_enable");
                    W();
                    if (!this.bH && TextUtils.isEmpty(optString2) && TextUtils.isEmpty(string)) {
                        this.bH = true;
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        this.k.setEnabled(false);
                        this.k.setText("₹ ".concat(String.valueOf(optString2)));
                        this.k.setEnabled(false);
                        this.k.requestFocus();
                    } else if (!TextUtils.isEmpty(string)) {
                        this.k.setEnabled(false);
                        this.k.setText("₹ ".concat(String.valueOf(string)));
                        this.k.setEnabled(false);
                        this.k.requestFocus();
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        this.L.setText(string2);
                        this.U.setVisibility(8);
                        this.L.setEnabled(false);
                    }
                    if (!TextUtils.isEmpty(string3) && ((string3.trim().equalsIgnoreCase("false") || string3.trim().equalsIgnoreCase("0")) && !TextUtils.isEmpty(this.k.getText()))) {
                        this.k.setEnabled(false);
                    }
                    if (!TextUtils.isEmpty(string3)) {
                        if ((string3.trim().equalsIgnoreCase("true") || string3.trim().equalsIgnoreCase("1")) && !TextUtils.isEmpty(this.k.getText())) {
                            this.k.setEnabled(true);
                        }
                    }
                    if (!TextUtils.isEmpty(string4) && string4.trim().equalsIgnoreCase("true")) {
                        this.L.setVisibility(0);
                        this.aq.setVisibility(0);
                    }
                }
            } catch (Exception e3) {
                q.d(String.valueOf(e3));
            }
        }
        try {
            this.ak = (CJRLinkBasePaymentResponse) getArguments().getSerializable("link_base_payment_data");
            if (this.ak != null) {
                if ("FIXED".equalsIgnoreCase(this.ak.linkType)) {
                    RiskExtendedInfo riskExtendedInfo2 = net.one97.paytm.f.b.a().f50402a;
                    riskExtendedInfo2.setMode("deeplink");
                    riskExtendedInfo2.setScanType("active");
                    CustomAmountAnimatedEditText customAmountAnimatedEditText2 = this.k;
                    customAmountAnimatedEditText2.setText("₹ " + this.ak.amount);
                }
                if (!v.a(this.ak.linkDescription)) {
                    inflate.findViewById(R.id.et_description).setVisibility(8);
                    inflate.findViewById(R.id.et_description1).setVisibility(8);
                    this.f51128i.setVisibility(0);
                    this.f51128i.setText(this.ak.linkDescription);
                }
            }
        } catch (Exception e4) {
            q.d(String.valueOf(e4));
        }
        Window window = getActivity().getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(androidx.core.content.b.c(getContext(), R.color.offline_pg_bg_status_color));
            }
        }
        return inflate;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f51126g = context;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (net.one97.paytm.wallet.utility.a.f((Context) this.f51125f) && net.one97.paytm.wallet.utility.a.g((Context) this.f51125f)) {
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.a(100);
            locationRequest.a(0);
            locationRequest.b(0);
            locationRequest.f11341a = 1;
            this.bp = com.google.android.gms.location.f.b(this.f51125f);
            com.google.android.gms.location.b bVar = this.bp;
            if (bVar != null) {
                bVar.a(locationRequest, this.bT, Looper.myLooper());
            }
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        y<net.one97.paytm.network.f> yVar;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("ssotoken", com.paytm.utility.a.q(getActivity()));
            String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "convenience_fee_url");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CJRQRScanResultModel.KEY_MERCHANT_GUID, this.n.getMerchantGUID());
            jSONObject2.put("txnAmount", ae());
            jSONObject.put("request", jSONObject2);
            net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(stringFromGTM, new CJRWalletConvenienceFee(), (Map<String, String>) null, hashMap, jSONObject.toString());
            if (com.paytm.utility.b.c(this.f51126g)) {
                yVar = bVar.c();
            } else {
                yVar = net.one97.paytm.base.d.f49504d.a(this.f51126g, bVar);
            }
            if (yVar != null) {
                yVar.observeForever(new z() {
                    public final void onChanged(Object obj) {
                        g.this.f((net.one97.paytm.network.f) obj);
                    }
                });
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public void onAttach(Activity activity) {
        if (activity != null) {
            this.f51125f = activity;
        }
        if (activity instanceof AJRQRActivity) {
            this.o = (m) activity;
        }
        if (this.f51123c == null) {
            this.f51123c = new net.one97.paytm.wallet.d.e();
        }
        this.f51123c.a(activity, "P2P_TRANSFER", (net.one97.paytm.wallet.f.g) new net.one97.paytm.wallet.f.g() {
            public final void a() {
                g.this.a(Boolean.TRUE);
                g.w();
            }

            public final void b() {
                g.w();
                g.this.a(Boolean.FALSE);
            }

            public final void a(IJRDataModel iJRDataModel) {
                String str;
                g.this.a(Boolean.FALSE);
                g.w();
                String f2 = g.this.S();
                String mobileNo = g.this.n.getMobileNo();
                String h2 = g.this.ae();
                if (TextUtils.isEmpty(g.this.n.getComment())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(g.this.L.getText());
                    str = sb.toString();
                } else {
                    str = g.this.n.getComment();
                }
                Intent h3 = net.one97.paytm.wallet.utility.a.h((Context) g.this.f51125f);
                h3.putExtra("key_via", "via_qr");
                h3.putExtra("phone_no", mobileNo);
                h3.putExtra("bundle", iJRDataModel);
                h3.putExtra("name", f2);
                h3.putExtra("qrScanTime", g.this.bb);
                h3.putExtra("is_from_mobile_number", g.this.aC);
                h3.putExtra("suggested_instrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().C);
                h3.putExtra("used_instrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode());
                h3.putExtra("is_from_recent", g.this.bc);
                h3.putExtra("isAutoFlashTxn", g.this.bF);
                h3.putExtra("suggestedInstrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().C);
                h3.putExtra("isSingleAPI", g.this.bd);
                h3.putExtra("is_link_based_payment", g.this.aO);
                h3.putExtra("pay_mode_type", g.this.aR);
                h3.putExtra("pay_mode_load_time", g.this.aS);
                h3.putExtra("is_amt_already_present", !TextUtils.isEmpty(g.this.n.getTxnAmount()));
                h3.putExtra("is_from_deeplink", g.this.bE);
                h3.putExtra("launchFrom", g.this.bQ);
                h3.putExtra("is_from_app_evoke", g.this.aD);
                h3.putExtra("is_static_qr_code", g.this.m());
                h3.putExtra("pay_mode", "BALANCE");
                h3.putExtra("unique_identifier", "");
                if (!(g.this.n == null || g.this.n.getJson() == null)) {
                    h3.putExtra("scan_result", g.this.n.getJson().toString());
                }
                if (!g.this.bf || g.this.bg.doubleValue() <= 0.0d) {
                    h3.putExtra("is_pcf", true);
                } else {
                    h3.putExtra("is_pcf", true);
                    h3.putExtra("pcf_amount", g.this.bg);
                }
                if (g.this.aE != null) {
                    g.this.z();
                    h3.putExtras(g.this.aE);
                }
                h3.putExtra("amount", String.valueOf(h2));
                h3.putExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL, String.valueOf(str));
                String str2 = StringSet.user.equalsIgnoreCase(g.this.n.getPayeeType()) ? "send" : "pay";
                h3.putExtra("paymentMode", "p2p");
                h3.putExtra("paymentType", str2);
                if (!TextUtils.isEmpty(g.this.n.getTagLine())) {
                    h3.putExtra("tagline", g.this.n.getTagLine());
                }
                h3.setFlags(67108864);
                if (g.this.aD) {
                    g.this.getActivity().startActivityForResult(h3, 2002);
                    return;
                }
                g.this.startActivity(h3);
                g.this.getActivity().setResult(-1);
                g.this.getActivity().finish();
            }
        });
        if (this.f51124e == null) {
            this.f51124e = new h();
            this.f51124e.f70225d = true;
        }
        this.f51124e.a(activity, this.bS);
        super.onAttach(activity);
    }

    public void onDetach() {
        super.onDetach();
    }

    /* access modifiers changed from: private */
    public void z() {
        this.aE.putString("amount", com.paytm.utility.b.Q(this.k.getText().toString().trim()));
    }

    /* access modifiers changed from: private */
    public void A() {
        try {
            View currentFocus = getActivity().getCurrentFocus();
            if (currentFocus != null) {
                ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
    }

    public void onStop() {
        A();
        this.X = true;
        super.onStop();
    }

    private void B() {
        this.M = net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM((Context) getActivity(), "max_paytm_wallet_length");
        if (this.M <= 0) {
            this.M = 6;
        }
        int i2 = this.M;
        if (i2 <= 3) {
            this.M = i2;
        } else if (i2 <= 5) {
            this.M = i2 + 1;
        } else if (i2 <= 7) {
            this.M = i2 + 2;
        } else if (i2 <= 9) {
            this.M = i2 + 3;
        } else if (i2 <= 11) {
            this.M = i2 + 4;
        }
        this.k.setFilters(new CustomAmountAnimatedEditText.a[]{new CustomAmountAnimatedEditText.a(this.M, 2)});
    }

    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().f();
        if (this.n.getExpiryDate() != 0 && this.n.getExpiryDate() < System.currentTimeMillis()) {
            a(this.f51126g.getString(R.string.qr_expired_title), this.f51126g.getString(R.string.qr_expired_message), true);
        }
        if (!TextUtils.isEmpty(this.n.getTxnAmount()) && !f(this.n.getTxnAmount())) {
            a(this.f51126g.getString(R.string.invalid_data), this.f51126g.getString(R.string.qr_invalid_data_message), false);
        }
        if (this.k.getVisibility() == 0 && this.L.getVisibility() == 0) {
            if (this.k.hasFocus() || this.L.hasFocus()) {
                if (!this.n.isPgEnabled() && !K()) {
                    this.W.setVisibility(8);
                }
                getView();
            }
        } else if (this.k.getVisibility() == 0 && this.k.hasFocus() && !this.n.isPgEnabled() && !K()) {
            this.k.post(this.bR);
            this.W.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.bA = true;
            this.f51127h.b(true);
            LiveData<net.one97.paytm.network.f> a2 = a.a(this.f51126g, str, this.n);
            if (a2 != null) {
                a2.observeForever(new z() {
                    public final void onChanged(Object obj) {
                        g.this.e((net.one97.paytm.network.f) obj);
                    }
                });
                return;
            }
            this.bA = false;
            this.f51127h.b(false);
        }
    }

    private static boolean f(String str) {
        return str.matches(".*\\d+.*");
    }

    private void a(String str, String str2, final boolean z2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(str).setMessage(str2).setCancelable(false);
        builder.setPositiveButton(this.f51126g.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (z2 && g.this.getActivity() != null) {
                    g.this.getActivity().finish();
                }
            }
        });
        builder.show();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(15:17|18|19|20|21|(1:23)(1:24)|25|(1:27)(1:28)|29|(1:31)(1:32)|33|(1:35)(1:36)|37|(1:39)(1:40)|41) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x008e */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0094 A[Catch:{ Exception -> 0x03e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b A[Catch:{ Exception -> 0x03e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a2 A[Catch:{ Exception -> 0x03e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a9 A[Catch:{ Exception -> 0x03e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b0 A[Catch:{ Exception -> 0x03e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b7 A[Catch:{ Exception -> 0x03e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00be A[Catch:{ Exception -> 0x03e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5 A[Catch:{ Exception -> 0x03e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc A[Catch:{ Exception -> 0x03e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d3 A[Catch:{ Exception -> 0x03e3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r15) {
        /*
            r14 = this;
            java.lang.String r0 = "pn"
            java.lang.String r1 = "am"
            java.lang.String r2 = "tn"
            java.lang.String r3 = "tr"
            java.lang.String r4 = "mid"
            java.lang.String r5 = "mt_revamp_enabled"
            java.lang.String r6 = "link_base_payment_data"
            java.lang.String r7 = "extra_p2m_contact"
            super.onCreate(r15)
            net.one97.paytm.n.c r15 = new net.one97.paytm.n.c
            r15.<init>((net.one97.paytm.n.b) r14, (androidx.fragment.app.Fragment) r14)
            r14.bG = r15
            android.app.Activity r15 = r14.f51125f
            com.paytm.utility.b.e((android.app.Activity) r15)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r15 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r8 = as
            r15.f13092h = r8
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r15 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r15 = r15.f13092h
            if (r15 == 0) goto L_0x0032
            java.lang.String r15 = "flow_through_scan_icon"
            goto L_0x0034
        L_0x0032:
            java.lang.String r15 = "flow_through_pay_icon"
        L_0x0034:
            r10 = r15
            net.one97.paytm.wallet.communicator.c r15 = net.one97.paytm.wallet.communicator.b.a()
            android.content.Context r12 = r15.getContext()
            boolean r15 = as
            if (r15 == 0) goto L_0x0044
            java.lang.String r15 = "home/scan/post-scan"
            goto L_0x0046
        L_0x0044:
            java.lang.String r15 = "home/pay-send/post-scan"
        L_0x0046:
            r13 = r15
            java.lang.String r8 = "offline_payments"
            java.lang.String r9 = "scan_success_p2m"
            java.lang.String r11 = ""
            a(r8, r9, r10, r11, r12, r13)
            android.os.Bundle r15 = r14.getArguments()
            if (r15 == 0) goto L_0x03f0
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r8 = "orderId"
            r9 = 0
            java.lang.String r15 = r15.getString(r8, r9)     // Catch:{ Exception -> 0x03e3 }
            r14.bD = r15     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r8 = "isFromUPIDeepink"
            r10 = 0
            boolean r15 = r15.getBoolean(r8, r10)     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r8 = ""
            r11 = 1
            if (r15 == 0) goto L_0x0108
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r15 = r14.n     // Catch:{ Exception -> 0x03e3 }
            if (r15 != 0) goto L_0x0390
            java.util.LinkedHashMap r15 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x03e3 }
            r15.<init>()     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r5 = r14.getArguments()     // Catch:{ Exception -> 0x008e }
            java.lang.String r6 = "upidata"
            java.lang.String r5 = r5.getString(r6, r8)     // Catch:{ Exception -> 0x008e }
            r14.bC = r5     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = r14.bC     // Catch:{ Exception -> 0x008e }
            java.util.Map r15 = net.one97.paytm.wallet.utility.a.j((java.lang.String) r5)     // Catch:{ Exception -> 0x008e }
        L_0x008e:
            boolean r5 = r15.containsKey(r4)     // Catch:{ Exception -> 0x03e3 }
            if (r5 == 0) goto L_0x009b
            java.lang.Object r4 = r15.get(r4)     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x03e3 }
            goto L_0x009c
        L_0x009b:
            r4 = r8
        L_0x009c:
            boolean r5 = r15.containsKey(r3)     // Catch:{ Exception -> 0x03e3 }
            if (r5 == 0) goto L_0x00a9
            java.lang.Object r3 = r15.get(r3)     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x03e3 }
            goto L_0x00aa
        L_0x00a9:
            r3 = r8
        L_0x00aa:
            boolean r5 = r15.containsKey(r2)     // Catch:{ Exception -> 0x03e3 }
            if (r5 == 0) goto L_0x00b7
            java.lang.Object r2 = r15.get(r2)     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x03e3 }
            goto L_0x00b8
        L_0x00b7:
            r2 = r8
        L_0x00b8:
            boolean r5 = r15.containsKey(r1)     // Catch:{ Exception -> 0x03e3 }
            if (r5 == 0) goto L_0x00c5
            java.lang.Object r1 = r15.get(r1)     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x03e3 }
            goto L_0x00c6
        L_0x00c5:
            r1 = r8
        L_0x00c6:
            boolean r5 = r15.containsKey(r0)     // Catch:{ Exception -> 0x03e3 }
            if (r5 == 0) goto L_0x00d3
            java.lang.Object r15 = r15.get(r0)     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x03e3 }
            goto L_0x00d4
        L_0x00d3:
            r15 = r8
        L_0x00d4:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = new net.one97.paytm.common.entity.wallet.CJRQRScanResultModel     // Catch:{ Exception -> 0x03e3 }
            r0.<init>()     // Catch:{ Exception -> 0x03e3 }
            r14.n = r0     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r14.n     // Catch:{ Exception -> 0x03e3 }
            r0.setPgEnabled(r11)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r14.n     // Catch:{ Exception -> 0x03e3 }
            r0.setMappingId(r4)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r14.n     // Catch:{ Exception -> 0x03e3 }
            r0.setmTxnAmount(r1)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r14.n     // Catch:{ Exception -> 0x03e3 }
            r0.setMerchantTransId(r3)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r14.n     // Catch:{ Exception -> 0x03e3 }
            r0.setmComment(r2)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r14.n     // Catch:{ Exception -> 0x03e3 }
            r0.setmMerchantName(r15)     // Catch:{ Exception -> 0x03e3 }
            r14.bB = r11     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.f.b r15 = net.one97.paytm.f.b.a()     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r15 = r15.f50402a     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = "Deeplink"
            r15.setRequestType(r0)     // Catch:{ Exception -> 0x03e3 }
            goto L_0x0390
        L_0x0108:
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.io.Serializable r15 = r15.getSerializable(r7)     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = "isLinkP2P"
            if (r15 == 0) goto L_0x0249
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r1 = "launchFrom"
            net.one97.paytm.contacts.utils.e$e r2 = net.one97.paytm.contacts.utils.e.C0905e.PAY     // Catch:{ Exception -> 0x03e3 }
            int r2 = r2.getType()     // Catch:{ Exception -> 0x03e3 }
            int r15 = r15.getInt(r1, r2)     // Catch:{ Exception -> 0x03e3 }
            r14.bQ = r15     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.wallet.communicator.c r15 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x03e3 }
            android.content.Context r1 = r14.f51126g     // Catch:{ Exception -> 0x03e3 }
            boolean r15 = r15.getBooleanFromGTM(r1, r5, r11)     // Catch:{ Exception -> 0x03e3 }
            if (r15 == 0) goto L_0x0196
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.io.Serializable r15 = r15.getSerializable(r7)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse r15 = (net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse) r15     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.p2p.ExtraData r1 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            if (r1 == 0) goto L_0x014b
            net.one97.paytm.common.entity.p2p.ExtraData r1 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            boolean r1 = r1.isAmountEditable()     // Catch:{ Exception -> 0x03e3 }
            goto L_0x014c
        L_0x014b:
            r1 = 1
        L_0x014c:
            r14.bH = r1     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.p2p.ExtraData r1 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            if (r1 == 0) goto L_0x015d
            net.one97.paytm.common.entity.p2p.ExtraData r1 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            boolean r1 = r1.isCommentEditable()     // Catch:{ Exception -> 0x03e3 }
            goto L_0x015e
        L_0x015d:
            r1 = 1
        L_0x015e:
            r14.bM = r1     // Catch:{ Exception -> 0x03e3 }
            boolean r1 = r14.bH     // Catch:{ Exception -> 0x03e3 }
            if (r1 != 0) goto L_0x017a
            net.one97.paytm.common.entity.p2p.ExtraData r1 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            if (r1 == 0) goto L_0x0178
            net.one97.paytm.common.entity.p2p.ExtraData r1 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r1 = r1.getAmount()     // Catch:{ Exception -> 0x03e3 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x03e3 }
            if (r1 == 0) goto L_0x017a
        L_0x0178:
            r14.bH = r11     // Catch:{ Exception -> 0x03e3 }
        L_0x017a:
            boolean r1 = r14.bM     // Catch:{ Exception -> 0x03e3 }
            if (r1 != 0) goto L_0x0194
            net.one97.paytm.common.entity.p2p.ExtraData r1 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            if (r1 == 0) goto L_0x0192
            net.one97.paytm.common.entity.p2p.ExtraData r1 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r1 = r1.getComment()     // Catch:{ Exception -> 0x03e3 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x03e3 }
            if (r1 == 0) goto L_0x0194
        L_0x0192:
            r14.bM = r11     // Catch:{ Exception -> 0x03e3 }
        L_0x0194:
            r1 = r9
            goto L_0x01a2
        L_0x0196:
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.io.Serializable r15 = r15.getSerializable(r7)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes r15 = (net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes) r15     // Catch:{ Exception -> 0x03e3 }
            r1 = r15
            r15 = r9
        L_0x01a2:
            r14.bm = r11     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r2 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r3 = "mobile"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r3 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r4 = "is_from_app_evoke"
            boolean r3 = r3.getBoolean(r4)     // Catch:{ Exception -> 0x03e3 }
            r14.aD = r3     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r3 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r4 = "is_from_mobile_number"
            boolean r3 = r3.getBoolean(r4)     // Catch:{ Exception -> 0x03e3 }
            r14.aC = r3     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r3 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r4 = "sbBundle"
            android.os.Bundle r3 = r3.getBundle(r4)     // Catch:{ Exception -> 0x03e3 }
            r14.aE = r3     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r3 = new net.one97.paytm.common.entity.wallet.CJRQRScanResultModel     // Catch:{ Exception -> 0x03e3 }
            r3.<init>()     // Catch:{ Exception -> 0x03e3 }
            r14.n = r3     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.wallet.communicator.c r3 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x03e3 }
            android.content.Context r4 = r14.f51126g     // Catch:{ Exception -> 0x03e3 }
            boolean r3 = r3.getBooleanFromGTM(r4, r5, r11)     // Catch:{ Exception -> 0x03e3 }
            if (r3 == 0) goto L_0x0205
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r14.n     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.p2p.MerchantInfo r3 = r15.getMerchantInfo()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r3 = r3.getMerchantId()     // Catch:{ Exception -> 0x03e3 }
            r1.setMappingId(r3)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r14.n     // Catch:{ Exception -> 0x03e3 }
            r1.setMerchantTransId(r8)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r14.n     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.p2p.MerchantInfo r3 = r15.getMerchantInfo()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r3 = r3.getMerDispname()     // Catch:{ Exception -> 0x03e3 }
            r1.setmMerchantName(r3)     // Catch:{ Exception -> 0x03e3 }
            goto L_0x020e
        L_0x0205:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r3 = r14.n     // Catch:{ Exception -> 0x03e3 }
            androidx.fragment.app.FragmentActivity r4 = r14.getActivity()     // Catch:{ Exception -> 0x03e3 }
            r3.parseData((net.one97.paytm.common.entity.wallet.universalp2p.ConsolidatePaymentInstrumentationRes) r1, (android.content.Context) r4)     // Catch:{ Exception -> 0x03e3 }
        L_0x020e:
            net.one97.paytm.common.entity.p2p.ExtraData r1 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            if (r1 == 0) goto L_0x022e
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r14.n     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.p2p.ExtraData r3 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r3 = r3.getAmount()     // Catch:{ Exception -> 0x03e3 }
            r1.setmTxnAmount(r3)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r14.n     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.p2p.ExtraData r15 = r15.getExtraData()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r15 = r15.getComment()     // Catch:{ Exception -> 0x03e3 }
            r1.setmComment(r15)     // Catch:{ Exception -> 0x03e3 }
        L_0x022e:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r15 = r14.n     // Catch:{ Exception -> 0x03e3 }
            r15.setmMobileNo(r2)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r15 = r14.n     // Catch:{ Exception -> 0x03e3 }
            r15.setmRequestType(r8)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r15 = r14.n     // Catch:{ Exception -> 0x03e3 }
            r15.setPgEnabled(r11)     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            boolean r15 = r15.getBoolean(r0, r10)     // Catch:{ Exception -> 0x03e3 }
            r14.aM = r15     // Catch:{ Exception -> 0x03e3 }
            goto L_0x0390
        L_0x0249:
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.io.Serializable r15 = r15.getSerializable(r6)     // Catch:{ Exception -> 0x03e3 }
            if (r15 != 0) goto L_0x02ec
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r1 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r2 = "data"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ Exception -> 0x03e3 }
            r15.<init>(r1)     // Catch:{ Exception -> 0x03e3 }
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x03e3 }
            r1.<init>()     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRExtendedInfoData r2 = new net.one97.paytm.common.entity.wallet.CJRExtendedInfoData     // Catch:{ Exception -> 0x03e3 }
            r2.<init>()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r3 = "extendedInfo"
            org.json.JSONObject r3 = r15.optJSONObject(r3)     // Catch:{ Exception -> 0x03e3 }
            if (r3 == 0) goto L_0x0288
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x03e3 }
            java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x03e3 }
            java.lang.Object r1 = r1.a((java.lang.String) r3, r2)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRExtendedInfoData r1 = (net.one97.paytm.common.entity.wallet.CJRExtendedInfoData) r1     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r1 = r1.getMerchantQRTag()     // Catch:{ Exception -> 0x03e3 }
            r14.p = r1     // Catch:{ Exception -> 0x03e3 }
        L_0x0288:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = new net.one97.paytm.common.entity.wallet.CJRQRScanResultModel     // Catch:{ Exception -> 0x03e3 }
            r1.<init>()     // Catch:{ Exception -> 0x03e3 }
            r14.n = r1     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r1 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            boolean r0 = r1.getBoolean(r0, r10)     // Catch:{ Exception -> 0x03e3 }
            r14.aM = r0     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r14.n     // Catch:{ Exception -> 0x03e3 }
            androidx.fragment.app.FragmentActivity r1 = r14.getActivity()     // Catch:{ Exception -> 0x03e3 }
            r0.parseData((org.json.JSONObject) r15, (android.content.Context) r1)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.f.b r15 = net.one97.paytm.f.b.a()     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r15 = r15.f50402a     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r14.n     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = r0.getChannelID()     // Catch:{ Exception -> 0x03e3 }
            r15.setChannelIDV2(r0)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r15 = r14.n     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r15 = r15.getQrCodeId()     // Catch:{ Exception -> 0x03e3 }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x03e3 }
            if (r15 == 0) goto L_0x02ce
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r15 = r14.n     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r14.n     // Catch:{ Exception -> 0x03e3 }
            org.json.JSONObject r0 = r0.getJson()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r1 = "qrCodeId"
            java.lang.String r0 = r0.optString(r1)     // Catch:{ Exception -> 0x03e3 }
            r15.setQrCodeId(r0)     // Catch:{ Exception -> 0x03e3 }
        L_0x02ce:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r15 = r14.n     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r15 = r15.getMerchantStatus()     // Catch:{ Exception -> 0x03e3 }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x03e3 }
            if (r15 != 0) goto L_0x0390
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r15 = r14.n     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r15 = r15.getMerchantStatus()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = "INACTIVE"
            boolean r15 = r15.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x03e3 }
            if (r15 == 0) goto L_0x0390
            r14.aj = r11     // Catch:{ Exception -> 0x03e3 }
            goto L_0x0390
        L_0x02ec:
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.io.Serializable r15 = r15.getSerializable(r6)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRLinkBasePaymentResponse r15 = (net.one97.paytm.common.entity.wallet.CJRLinkBasePaymentResponse) r15     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = new net.one97.paytm.common.entity.wallet.CJRQRScanResultModel     // Catch:{ Exception -> 0x03e3 }
            r1.<init>()     // Catch:{ Exception -> 0x03e3 }
            r14.n = r1     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r14.n     // Catch:{ Exception -> 0x03e3 }
            org.json.JSONObject r2 = r15.getResponseJSON()     // Catch:{ Exception -> 0x03e3 }
            androidx.fragment.app.FragmentActivity r3 = r14.getActivity()     // Catch:{ Exception -> 0x03e3 }
            r1.parseData((org.json.JSONObject) r2, (android.content.Context) r3)     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r1 = r15.imageData     // Catch:{ Exception -> 0x03e3 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x03e3 }
            if (r1 != 0) goto L_0x0319
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r14.n     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r2 = r15.imageData     // Catch:{ Exception -> 0x03e3 }
            r1.setmLogoUrl(r2)     // Catch:{ Exception -> 0x03e3 }
        L_0x0319:
            android.os.Bundle r1 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            boolean r0 = r1.getBoolean(r0, r10)     // Catch:{ Exception -> 0x03e3 }
            r14.aM = r0     // Catch:{ Exception -> 0x03e3 }
            r14.aO = r11     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ Exception -> 0x03e3 }
            android.content.Context r1 = r14.f51126g     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r2 = "isLinkBasedWarningMsgEnable"
            boolean r0 = r0.getBooleanFromGTM(r1, r2, r10)     // Catch:{ Exception -> 0x03e3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03e3 }
            r1.<init>()     // Catch:{ Exception -> 0x03e3 }
            r1.append(r0)     // Catch:{ Exception -> 0x03e3 }
            if (r0 == 0) goto L_0x037c
            net.one97.paytm.common.entity.wallet.CJRWarningMessageContainer r0 = r15.getWarningMessageContainer()     // Catch:{ Exception -> 0x03e3 }
            if (r0 == 0) goto L_0x037c
            net.one97.paytm.common.entity.wallet.CJRWarningMessageContainer r0 = r15.getWarningMessageContainer()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = r0.getWarningMessage()     // Catch:{ Exception -> 0x03e3 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03e3 }
            if (r0 != 0) goto L_0x037c
            net.one97.paytm.common.entity.wallet.CJRWarningMessageContainer r15 = r15.getWarningMessageContainer()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r15 = r15.getWarningMessage()     // Catch:{ Exception -> 0x03e3 }
            r14.A()     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.wallet.c.l r0 = new net.one97.paytm.wallet.c.l     // Catch:{ Exception -> 0x03e3 }
            r0.<init>()     // Catch:{ Exception -> 0x03e3 }
            r0.setCancelable(r10)     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ Exception -> 0x03e3 }
            r1.<init>()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r2 = "warning_msg"
            r1.putString(r2, r15)     // Catch:{ Exception -> 0x03e3 }
            r0.setArguments(r1)     // Catch:{ Exception -> 0x03e3 }
            androidx.fragment.app.FragmentActivity r15 = r14.getActivity()     // Catch:{ Exception -> 0x03e3 }
            androidx.fragment.app.j r15 = r15.getSupportFragmentManager()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r1 = "warning_alert"
            r0.show((androidx.fragment.app.j) r15, (java.lang.String) r1)     // Catch:{ Exception -> 0x03e3 }
        L_0x037c:
            net.one97.paytm.f.b r15 = net.one97.paytm.f.b.a()     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r15 = r15.f50402a     // Catch:{ Exception -> 0x03e3 }
            r15.setChannelIDV2(r8)     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.f.b r15 = net.one97.paytm.f.b.a()     // Catch:{ Exception -> 0x03e3 }
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r15 = r15.f50402a     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = "Linked based"
            r15.setRequestType(r0)     // Catch:{ Exception -> 0x03e3 }
        L_0x0390:
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = "qrScanTime"
            java.lang.String r15 = r15.getString(r0, r8)     // Catch:{ Exception -> 0x03e3 }
            r14.bb = r15     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = "isGalleryScan"
            boolean r15 = r15.getBoolean(r0, r10)     // Catch:{ Exception -> 0x03e3 }
            r14.bN = r15     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = "isStaticQRWithEncryptData"
            boolean r15 = r15.getBoolean(r0, r10)     // Catch:{ Exception -> 0x03e3 }
            r14.aQ = r15     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = "is_from_repeat_payment"
            boolean r15 = r15.getBoolean(r0)     // Catch:{ Exception -> 0x03e3 }
            r14.aW = r15     // Catch:{ Exception -> 0x03e3 }
            boolean r15 = r14.aW     // Catch:{ Exception -> 0x03e3 }
            if (r15 == 0) goto L_0x03ca
            java.lang.String r15 = "repeat_payment"
            r14.aR = r15     // Catch:{ Exception -> 0x03e3 }
            r14.aS = r9     // Catch:{ Exception -> 0x03e3 }
        L_0x03ca:
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = "is_from_recent"
            boolean r15 = r15.getBoolean(r0, r10)     // Catch:{ Exception -> 0x03e3 }
            r14.bc = r15     // Catch:{ Exception -> 0x03e3 }
            android.os.Bundle r15 = r14.getArguments()     // Catch:{ Exception -> 0x03e3 }
            java.lang.String r0 = "isAutoFlashTxn"
            boolean r15 = r15.getBoolean(r0, r10)     // Catch:{ Exception -> 0x03e3 }
            r14.bF = r15     // Catch:{ Exception -> 0x03e3 }
            goto L_0x03ea
        L_0x03e3:
            androidx.fragment.app.FragmentActivity r15 = r14.getActivity()
            r15.onBackPressed()
        L_0x03ea:
            java.lang.String r15 = r14.C()
            r14.aV = r15
        L_0x03f0:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r15 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r15.q()
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r15 = r14.n
            if (r15 == 0) goto L_0x0407
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r15 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r14.n
            boolean r0 = r0.isPgEnabled()
            r15.O = r0
        L_0x0407:
            net.one97.paytm.wallet.communicator.c r15 = net.one97.paytm.wallet.communicator.b.a()
            android.content.Context r0 = r14.f51126g
            boolean r15 = r15.isVscpEnabled(r0)
            r14.bj = r15
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r15 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = r14.bj
            r15.G = r0
            java.text.DecimalFormat r15 = bU
            java.math.RoundingMode r0 = java.math.RoundingMode.HALF_UP
            r15.setRoundingMode(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.g.onCreate(android.os.Bundle):void");
    }

    private String C() {
        Random random = new Random();
        return com.paytm.utility.b.n(this.f51126g) + System.currentTimeMillis() + (random.nextInt(900) + 100);
    }

    private void D() {
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        MerchantDetailsV2 c2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().c();
        if (!TextUtils.isEmpty(this.n.getLogoURL())) {
            try {
                w.a().a(this.n.getLogoURL()).a(R.drawable.merchant_icon).b(R.drawable.merchant_icon).a(this.m, (com.squareup.picasso.e) null);
            } catch (Exception unused) {
            }
        } else if (c2 == null || TextUtils.isEmpty(c2.getMerchantLogo())) {
            this.m.setImageDrawable(androidx.core.content.b.a((Context) this.f51125f, R.drawable.merchant_icon));
        } else {
            try {
                w.a().a(c2.getMerchantLogo()).a(R.drawable.merchant_icon).b(R.drawable.merchant_icon).a(this.m, (com.squareup.picasso.e) null);
            } catch (Exception unused2) {
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ac.setVisibility(0);
            Double valueOf = Double.valueOf(str);
            Double valueOf2 = Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBalance());
            int minimumLimitForPayWithGold = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getmGoldPortfolio().getMinimumLimitForPayWithGold();
            int intValue = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getmGoldPortfolio().getMaximumLimitForPayWithGold().intValue();
            if (valueOf.doubleValue() > valueOf2.doubleValue()) {
                this.ac.setText(R.string.gold_insufficient_balance);
                this.ac.setTextColor(getResources().getColor(R.color.red));
                this.ac.setTag(Boolean.FALSE);
            } else if (valueOf.doubleValue() < ((double) minimumLimitForPayWithGold) || valueOf.doubleValue() > ((double) intValue)) {
                this.ac.setText(this.f51126g.getString(R.string.gold_min_max_error_message, new Object[]{String.valueOf(minimumLimitForPayWithGold), String.valueOf(intValue)}));
                this.ac.setTextColor(getResources().getColor(R.color.red));
                this.ac.setTag(Boolean.FALSE);
            } else {
                String format = String.format("%.4f", new Object[]{Double.valueOf(valueOf.doubleValue() / Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getmGoldPortfolio().getGoldBuyPrice()).doubleValue())});
                String x2 = com.paytm.utility.b.x(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getmGoldPortfolio().getGoldBuyPrice());
                this.ac.setText(Html.fromHtml("=<b>" + format + "</b>g, based on Current Gold Price: Rs." + x2 + "/g"));
                this.ac.setTextColor(getResources().getColor(R.color.color_222222));
                this.ac.setTag(Boolean.TRUE);
                net.one97.paytm.jeweller.a.a(this.f51126g, "/digital_gold_offline/pay_screen", "digital_gold_offline", "amount_entered", str, S(), com.paytm.utility.b.n(this.f51126g));
            }
        }
    }

    private int E() {
        return (int) ((getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
    }

    /* access modifiers changed from: private */
    public String h(String str) {
        String Q2 = com.paytm.utility.b.Q(str);
        if (Q2.equals(AppUtility.CENTER_DOT)) {
            return this.N + AppUtility.CENTER_DOT;
        }
        BigDecimal bigDecimal = new BigDecimal(Q2);
        return new DecimalFormat(this.N + "##,##,##,##,###." + i(Q2), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(bigDecimal);
    }

    private static String i(String str) {
        int length = (str.length() - 1) - str.indexOf(AppUtility.CENTER_DOT);
        String str2 = "";
        int i2 = 0;
        while (i2 < length && i2 < 2) {
            str2 = str2 + "0";
            i2++;
        }
        return str2;
    }

    public void onStart() {
        super.onStart();
        if (((this.L.getVisibility() == 0 && this.L.hasFocus()) || (this.k.getVisibility() == 0 && this.k.hasFocus())) && this.L.getVisibility() == 0) {
            getView();
        }
    }

    private void F() {
        if (TextUtils.isEmpty(this.n.getComment()) && (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().I())) {
            this.L.setVisibility(8);
            this.aq.setVisibility(8);
        } else {
            this.L.setVisibility(0);
            this.aq.setVisibility(0);
            this.U.setVisibility(8);
            this.L.setText(this.n.getComment());
            this.L.setEnabled(TextUtils.isEmpty(this.n.getComment()));
        }
        B();
        if (TextUtils.isEmpty(this.n.getTxnAmount())) {
            this.k.setVisibility(0);
            if (getArguments() != null && getArguments().containsKey("sbBundle")) {
                CustomAmountAnimatedEditText customAmountAnimatedEditText = this.k;
                customAmountAnimatedEditText.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + this.aE.getString("amount"));
                this.k.setEnabled(true);
            }
        } else {
            this.k.setVisibility(0);
            if (f(this.n.getTxnAmount())) {
                CustomAmountAnimatedEditText customAmountAnimatedEditText2 = this.k;
                customAmountAnimatedEditText2.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + " " + this.n.getTxnAmount());
                this.k.setEnabled(false);
                if (this.bm) {
                    this.k.setEnabled(this.bH);
                }
            }
        }
        if (this.bm) {
            this.k.setEnabled(this.bH);
            this.L.setEnabled(this.bM);
        }
        if (this.aD) {
            this.k.setEnabled(this.bH);
        }
        if (TextUtils.isEmpty(S())) {
            this.j.setVisibility(8);
        } else {
            this.y.setTitle(S());
            this.y.setExpandedTitleColor(androidx.core.content.b.c(this.f51126g, R.color.color_222222));
            this.y.setExpandedTitleTextAppearance(R.style.Toolbar_TitleText);
            this.y.setExpandedTitleTypeface(Typeface.DEFAULT_BOLD);
            this.y.setExpandedTitleGravity(48);
            this.y.setExpandedTitleMargin(com.paytm.utility.b.a(21.0f, this.f51126g), com.paytm.utility.b.a(60.0f, this.f51126g), com.paytm.utility.b.a(100.0f, this.f51126g), 0);
        }
        if ("QR_CODE_REQUEST_MONEY".equalsIgnoreCase(this.n.getRequestType())) {
            if (!TextUtils.isEmpty(this.n.getMobileNo())) {
                this.f51128i.setVisibility(0);
                this.f51128i.setText(this.n.getMobileNo());
            } else {
                this.f51128i.setVisibility(8);
            }
        } else if (TextUtils.isEmpty(this.n.getTagLine())) {
            this.f51128i.setVisibility(8);
        } else if (at) {
            this.f51128i.setVisibility(0);
            this.f51128i.setText(this.n.getTagLine());
        } else {
            this.f51128i.setVisibility(8);
        }
        if (!net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.f51125f, "p2mVerifiedMerchantTag", false) || !AppConstants.UPI_QR_CODE.equalsIgnoreCase(this.n.getRequestType())) {
            this.aH.setVisibility(8);
        } else {
            ao();
        }
    }

    public void onClick(View view) {
        boolean z2;
        int id = view.getId();
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().z = true;
        if (id == R.id.payment_proceed_pay_btn_prefill_amount) {
            if (System.currentTimeMillis() - this.aK >= 2000) {
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().L) {
                    a(Boolean.TRUE);
                    al();
                } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null) {
                    a(this.f51126g.getResources().getString(R.string.no_instrument_selected), false, false);
                    this.bl = false;
                } else {
                    this.aK = System.currentTimeMillis();
                    this.bl = true;
                    a(Boolean.TRUE);
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().P = true;
                    W();
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null) {
                        a(Boolean.FALSE);
                        Toast.makeText(this.f51125f, "Please select instrument", 1).show();
                        return;
                    }
                    if (K()) {
                        net.one97.paytm.jeweller.a.a(this.f51126g, "/digital_gold_offline/pay_screen", "digital_gold_offline", Events.Action.PROCEED_CLICKED, (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f() == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null) ? "" : net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplayPrimaryInfo(), S(), com.paytm.utility.b.n(this.f51126g));
                    }
                    if (!Q()) {
                        a(Boolean.FALSE);
                    } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null) {
                        a(Boolean.FALSE);
                        Toast.makeText(this.f51125f, "Please select instrument", 1).show();
                    } else {
                        InstrumentInfo instrumentInfo = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
                        if (!"UPI".equalsIgnoreCase(instrumentInfo.getPayMode()) || !instrumentInfo.isBlocked()) {
                            z2 = false;
                        } else {
                            a(!TextUtils.isEmpty(instrumentInfo.getBlockMessage()) ? instrumentInfo.getBlockMessage() : this.f51126g.getString(R.string.p2m_retry_generic_msg), false, false);
                            c(false);
                            z2 = true;
                        }
                        if (!z2) {
                            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
                                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                                if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
                                    a("0".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A) ? this.f51126g.getResources().getString(R.string.limit_breach_msg) : String.format(this.f51126g.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A}), false, false);
                                    a(Boolean.FALSE);
                                    return;
                                }
                            }
                            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || !"BALANCE".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode()) || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().s(ae()) || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().E()) {
                                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().E) {
                                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.F()) {
                                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a((String) null);
                                    }
                                }
                                if (this.bJ && m() && (this.bL || !this.bK.contentEquals(ae()))) {
                                    this.aV = C();
                                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a((String) null);
                                }
                                if (this.aO && this.bn == null && this.bo == null) {
                                    startActivityForResult(new Intent(this.f51125f, AJRLocationCaptureActivity.class), 6576);
                                } else {
                                    aw();
                                }
                            } else {
                                a(this.f51126g.getString(R.string.insufficient_wallet_balance_p2m_merchant_fail), false, false);
                                a(Boolean.FALSE);
                            }
                        }
                    }
                }
            }
        } else if (id == R.id.qr_header_close_menu) {
        } else {
            if (id == R.id.rel_gold_popup_bg || id == R.id.ll_uni_expand_payment_inst_wrapper_new) {
                this.ag = true;
                if (this.n.isPgEnabled() || K()) {
                    String ae2 = ae();
                    if (TextUtils.isEmpty(ae2) || ae2.equals("0")) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("wallet_error_type", "qr_send_money_error");
                            hashMap.put("wallet_error_text", this.f51126g.getString(R.string.wallet_amount_error));
                            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity(), "wallet_error_displayed", hashMap);
                        } catch (Exception e2) {
                            if (com.paytm.utility.b.v) {
                                q.d(String.valueOf(e2));
                            }
                        }
                        a(true, this.f51126g.getString(R.string.invalid_amount_error));
                        a(Boolean.FALSE);
                    } else if (Double.parseDouble(ae()) < 1.0d) {
                        try {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("wallet_error_type", "qr_send_money_error");
                            hashMap2.put("wallet_error_text", this.f51126g.getString(R.string.transaction_limit_message_min_offline_pg));
                            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity(), "wallet_error_displayed", hashMap2);
                        } catch (Exception e3) {
                            if (com.paytm.utility.b.v) {
                                q.d(String.valueOf(e3));
                            }
                        }
                        if (getActivity() != null && isAdded()) {
                            a(this.f51126g.getString(R.string.transaction_limit_header), this.f51126g.getString(R.string.transaction_limit_message_min_offline_pg), false);
                            a(Boolean.FALSE);
                        }
                    } else {
                        W();
                        this.S = false;
                        if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b(this.f51126g) || K()) {
                            if (M() && this.E == net.one97.paytm.jeweller.b.JEWELLER_NOT_CALLED.getValue()) {
                                N();
                            }
                            if (K()) {
                                boolean K2 = K();
                                if (this.E == net.one97.paytm.jeweller.b.JEWELLER_NOT_CALLED.getValue() && K2) {
                                    N();
                                }
                            }
                            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e() == null) {
                                ac();
                            }
                            if (((this.C != net.one97.paytm.wallet.utility.g.PAY_METHOD_FAIL.getValue() && this.C != net.one97.paytm.wallet.utility.g.PAY_METHOD_NOT_CALLED.getValue()) || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e() != null) && this.D != net.one97.paytm.wallet.utility.i.UPI_NOT_CALLED.getValue()) {
                                if ((K() && this.E == net.one97.paytm.jeweller.b.JEWELLER_NOT_CALLED.getValue()) || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e() == null) {
                                    return;
                                }
                                if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(this.f51126g)) {
                                    ai();
                                } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b(this.f51126g)) {
                                    j(this.f51126g.getString(R.string.only_wallet_accept_user_msg));
                                }
                            }
                        } else {
                            Context context = this.f51126g;
                            Toast.makeText(context, context.getString(R.string.only_wallet_acceptable_msg), 1).show();
                        }
                    }
                }
            } else if (id == R.id.wave_bg) {
                if (this.k.getVisibility() == 0) {
                    this.k.requestFocus();
                }
            } else if (id == R.id.back) {
                W();
                getActivity().finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public void G() {
        CJRQRScanResultModel cJRQRScanResultModel;
        String str;
        this.bf = false;
        this.bg = Double.valueOf(0.0d);
        if (!(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J == null)) {
            net.one97.paytm.p2mNewDesign.g.c cVar = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
            if (cVar == null || !cVar.isChecked()) {
                str = "0";
            } else {
                str = String.valueOf(bU.format((Double.valueOf(ae()).doubleValue() * Double.valueOf(cVar.getRedeemablePercentage()).doubleValue()) / 100.0d));
                if (Double.parseDouble(str) > Double.parseDouble(cVar.getTotalAvailableBalance())) {
                    str = cVar.getTotalAvailableBalance();
                }
            }
            if (!(Double.valueOf(String.valueOf(bU.format(Double.parseDouble(ae()) - Double.parseDouble(str)))).doubleValue() >= 1.0d)) {
                String str2 = "mLoyal".equals(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getMLVInfo().getProvider()) ? "Points" : "Cashback";
                Context context = this.f51126g;
                Toast.makeText(context, context.getString(R.string.mlv_min_amount_more_than_1, new Object[]{str2}), 0).show();
                a(Boolean.FALSE);
                return;
            }
        }
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().I() && TextUtils.isEmpty(this.L.getText().toString().trim())) {
            this.bI.setVisibility(0);
            this.L.requestFocus();
            a(Boolean.FALSE);
        } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("GIFT_VOUCHER")) {
            if (!K() || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("Gold")) {
                if (!this.n.isPgEnabled() || (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("BALANCE"))) {
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c == null || (!TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.getBalance()) && Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.getBalance()).doubleValue() >= Double.valueOf(ae()).doubleValue())) {
                        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                            a("offline_payments", "post_scan_wallet_payment", "flow_through_scan_icon", "", this.f51126g, ao);
                        } else {
                            a("offline_payments", "post_scan_wallet_payment", "flow_through_pay_icon", "", this.f51126g, ao);
                        }
                        this.bG.a((String) null, (String) null);
                        return;
                    }
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                        a("offline_payments", "post_scan_wallet_insufficient_balance_payment", "flow_through_scan_icon", "", this.f51126g, ao);
                    } else {
                        a("offline_payments", "post_scan_wallet_insufficient_balance_payment", "flow_through_pay_icon", "", this.f51126g, ao);
                    }
                    if (Q()) {
                        InstrumentInfo instrumentInfo = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
                        if (instrumentInfo == null || (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d("BALANCE") && this.T && ((net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().w || !"BALANCE".equalsIgnoreCase(instrumentInfo.getPayMode())) && (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().w || !"BALANCE".equalsIgnoreCase(instrumentInfo.getPayMode()) || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().x)))) {
                            Context context2 = this.f51126g;
                            Toast.makeText(context2, this.f51126g.getString(R.string.merchant_doesnt_support_instrunment) + " " + net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplayPrimaryInfo(), 0).show();
                            return;
                        }
                        this.bG.a((String) null, (String) null);
                        return;
                    }
                    a(Boolean.FALSE);
                } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode() == null) {
                    a(Boolean.FALSE);
                } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase("NET_BANKING") && TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplayPrimaryInfo())) {
                    Toast.makeText(this.f51125f, this.f51126g.getString(R.string.please_select_valid_bank), 1).show();
                    a(Boolean.FALSE);
                } else if ("emi".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode()) && (TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplayPrimaryInfo()) || TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPlanId()))) {
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan() == null) {
                        Toast.makeText(this.f51125f, "Please select Bank and EMI plan", 1).show();
                    } else {
                        Toast.makeText(this.f51125f, "Please select a card to proceed", 1).show();
                    }
                    a(Boolean.FALSE);
                } else if ((this.aj || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d("PPI")) && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplayPrimaryInfo() != null && (this.f51126g.getString(R.string.debit_card).equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplayPrimaryInfo()) || this.f51126g.getString(R.string.credit_card).equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplayPrimaryInfo()) || this.f51126g.getString(R.string.upi).equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplayPrimaryInfo()))) {
                    this.ag = true;
                    a(Boolean.FALSE);
                } else {
                    if (!(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBalance() == null || (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("PAYTM_DIGITAL_CREDIT") && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals(SDKConstants.AI_KEY_PPBL) && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("UPI")))) {
                        double parseDouble = Double.parseDouble(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBalance());
                        String trim = this.k.getText().toString().replaceAll("[₹, ]", "").trim();
                        if (!TextUtils.isEmpty(trim)) {
                            Double valueOf = Double.valueOf(trim);
                            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H.isChecked()) {
                                net.one97.paytm.p2mNewDesign.g.c cVar2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
                                String valueOf2 = String.valueOf(bU.format((Double.valueOf(ae()).doubleValue() * Double.valueOf(cVar2.getRedeemablePercentage()).doubleValue()) / 100.0d));
                                if (Double.parseDouble(valueOf2) > Double.parseDouble(cVar2.getTotalAvailableBalance())) {
                                    valueOf2 = cVar2.getTotalAvailableBalance();
                                }
                                if (parseDouble < Double.valueOf(String.valueOf(bU.format(valueOf.doubleValue() - Double.parseDouble(valueOf2)))).doubleValue()) {
                                    if (SDKConstants.AI_KEY_PPBL.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
                                        Context context3 = this.f51126g;
                                        Toast.makeText(context3, context3.getString(R.string.insufficient_balance_payment_bank), 1).show();
                                    } else {
                                        Context context4 = this.f51126g;
                                        Toast.makeText(context4, context4.getString(R.string.insufficient_balance_payment_postpaid), 1).show();
                                    }
                                    a(Boolean.FALSE);
                                    return;
                                }
                            } else if (parseDouble < valueOf.doubleValue()) {
                                if (SDKConstants.AI_KEY_PPBL.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
                                    Context context5 = this.f51126g;
                                    Toast.makeText(context5, context5.getString(R.string.insufficient_balance_payment_bank), 1).show();
                                } else {
                                    Context context6 = this.f51126g;
                                    Toast.makeText(context6, context6.getString(R.string.insufficient_balance_payment_postpaid), 1).show();
                                }
                                a(Boolean.FALSE);
                                return;
                            }
                        }
                    }
                    if (!Q()) {
                        a(Boolean.FALSE);
                    } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null) {
                    } else {
                        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals(SDKConstants.DEBIT)) {
                            A();
                            if (this.f51127h != null) {
                                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                                    a("offline_payments", "post_scan_card_payment", "flow_through_scan_icon", "", this.f51126g, ao);
                                } else {
                                    a("offline_payments", "post_scan_card_payment", "flow_through_pay_icon", "", this.f51126g, ao);
                                }
                                net.one97.paytm.p2mNewDesign.j.b bVar = this.f51127h;
                                if (!"emi".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode()) && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.isEmiTypeCard()) {
                                    bVar.f13378f.a();
                                } else if (bVar.f13374b != null) {
                                    bVar.f13374b.b();
                                }
                            }
                        } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals(SDKConstants.CREDIT)) {
                            A();
                            if (this.f51127h != null) {
                                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                                    a("offline_payments", "post_scan_card_payment", "flow_through_scan_icon", "", this.f51126g, ao);
                                } else {
                                    a("offline_payments", "post_scan_card_payment", "flow_through_pay_icon", "", this.f51126g, ao);
                                }
                                net.one97.paytm.p2mNewDesign.j.b bVar2 = this.f51127h;
                                if (!"emi".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode()) && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.isEmiTypeCard()) {
                                    bVar2.f13378f.a();
                                } else if (bVar2.f13375c != null) {
                                    bVar2.f13375c.b();
                                }
                            }
                        } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals(SDKConstants.AI_KEY_PPBL)) {
                            A();
                            if (this.f51127h != null) {
                                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                                    a("offline_payments", "post_scan_ppbl_payment", "flow_through_scan_icon", "", this.f51126g, ao);
                                } else {
                                    a("offline_payments", "post_scan_ppbl_payment", "flow_through_pay_icon", "", this.f51126g, ao);
                                }
                                this.f51127h.f13378f.a();
                            }
                        } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("PAYTM_DIGITAL_CREDIT") && "true".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPasscodeRequired())) {
                            A();
                            if (this.f51127h != null) {
                                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                                    a("offline_payments", "post_scan_postpaid_payment", "flow_through_scan_icon", "", this.f51126g, ao);
                                } else {
                                    a("offline_payments", "post_scan_postpaid_payment", "flow_through_pay_icon", "", this.f51126g, ao);
                                }
                                this.f51127h.f13378f.a();
                            }
                        } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("UPI")) {
                            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                                a("offline_payments", "post_scan_upi_payment", "flow_through_scan_icon", "", this.f51126g, ao);
                            } else {
                                a("offline_payments", "post_scan_upi_payment", "flow_through_pay_icon", "", this.f51126g, ao);
                            }
                            if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.f51125f, "p2mVerifiedMerchantTag", true) && (cJRQRScanResultModel = this.n) != null && cJRQRScanResultModel.getJson() != null && net.one97.paytm.wallet.utility.a.n(this.n.getJson().toString()) == MerchantVerifedStatus.MERCHANT_UNVERIFED && AppConstants.UPI_QR_CODE.equalsIgnoreCase(this.n.getRequestType())) {
                                net.one97.paytm.wallet.utility.a.a(this.f51125f, (o) new o() {
                                    public final void a() {
                                        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J != null) {
                                            g.this.al();
                                        } else {
                                            g.this.c(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, g.this.ae());
                                        }
                                    }

                                    public final void b() {
                                        g.this.c(false);
                                    }
                                });
                            } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J != null) {
                                al();
                            } else {
                                c(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, ae());
                            }
                        } else if ("UPI_ONBOARDING".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
                            a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "onboardingupiflow");
                            c(false);
                        } else {
                            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("PAYTM_DIGITAL_CREDIT")) {
                                A();
                                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                                    a("offline_payments", "post_scan_postpaid_payment", "flow_through_scan_icon", "", this.f51126g, ao);
                                } else {
                                    a("offline_payments", "post_scan_postpaid_payment", "flow_through_pay_icon", "", this.f51126g, ao);
                                }
                            }
                            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J != null) {
                                al();
                            } else {
                                c(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, ae());
                            }
                        }
                    }
                }
            } else if (this.ac.getTag() == null) {
                a(Boolean.FALSE);
            } else if (((Boolean) this.ac.getTag()).booleanValue()) {
                I();
            } else {
                a(Boolean.FALSE);
            }
        } else if (TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().l.getTotalBalance())) {
        } else {
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J != null) {
                net.one97.paytm.p2mNewDesign.g.c cVar3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
                if (cVar3 != null && cVar3.isChecked()) {
                    String valueOf3 = String.valueOf(bU.format((Double.valueOf(ae()).doubleValue() * Double.valueOf(cVar3.getRedeemablePercentage()).doubleValue()) / 100.0d));
                    if (Double.parseDouble(valueOf3) > Double.parseDouble(cVar3.getTotalAvailableBalance())) {
                        valueOf3 = cVar3.getTotalAvailableBalance();
                    }
                    if (Double.parseDouble(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().l.getTotalBalance()) >= Double.parseDouble(bU.format(Double.valueOf(ae()).doubleValue() - Double.valueOf(valueOf3).doubleValue()))) {
                        al();
                    } else {
                        H();
                    }
                } else if (Double.parseDouble(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().l.getTotalBalance()) >= Double.parseDouble(d())) {
                    al();
                } else {
                    H();
                }
            } else if (Double.parseDouble(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().l.getTotalBalance()) >= Double.parseDouble(d())) {
                c(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, ae());
            } else {
                H();
            }
        }
    }

    private void H() {
        String storeFrontUrl = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getStoreFrontUrl();
        if (TextUtils.isEmpty(storeFrontUrl)) {
            storeFrontUrl = "paytmmp://homepage?url=https://storefront.paytm.com/v2/h/vouchers?src=store&title=Brand%20Vouchers&isMGV=true";
        } else {
            if (!storeFrontUrl.contains(CLPConstants.IS_MGV)) {
                storeFrontUrl = storeFrontUrl + "&isMGV=true";
            }
            if (!storeFrontUrl.contains(CLPConstants.DISCOVERABILITY)) {
                storeFrontUrl = storeFrontUrl + "&discoverability=offline";
            }
        }
        net.one97.paytm.wallet.communicator.b.a().handleDeeplinkByEngine(this.f51125f, storeFrontUrl, (Bundle) null);
        a(Boolean.FALSE);
    }

    private void I() {
        getActivity();
        String J2 = J();
        Map<String, String> a2 = net.one97.paytm.jeweller.a.a(getActivity());
        a2.put("merchant_id", this.n.getMappingId());
        EditText editText = this.L;
        String a3 = net.one97.paytm.jeweller.a.a((editText == null || editText.getVisibility() != 0) ? "" : this.L.getText().toString(), this.k.getText().toString().trim());
        if (a3 != null) {
            if (!com.paytm.utility.b.c((Context) getActivity())) {
                a(Boolean.FALSE);
                com.paytm.utility.b.b((Context) getActivity(), this.f51126g.getResources().getString(R.string.title_connection_problem), this.f51126g.getResources().getString(R.string.msg_connection_problem));
            } else if (!TextUtils.isEmpty(J2)) {
                U();
                new net.one97.paytm.network.b(com.paytm.utility.b.s(getActivity(), J2), new CJRGoldInitiate(), (Map<String, String>) null, a2, a3).c().observeForever(new z() {
                    public final void onChanged(Object obj) {
                        g.this.d((net.one97.paytm.network.f) obj);
                    }
                });
            }
        }
    }

    private String J() {
        return net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "jewellerInitiateTransferURL");
    }

    private boolean K() {
        return this.n.isGold() && L();
    }

    private boolean L() {
        return net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(getActivity(), "gold_jeweller_enable", false);
    }

    private boolean M() {
        return !this.n.isPgEnabled() && K();
    }

    private void N() {
        if (K() || M()) {
            this.ad.setVisibility(8);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, com.paytm.utility.a.q(this.f51126g));
            String P2 = P();
            if (com.paytm.utility.b.c(this.f51126g)) {
                new net.one97.paytm.network.a(P2, new CJRGoldPortfolio(), (Map<String, String>) null, hashMap).c().observeForever(new z() {
                    public final void onChanged(Object obj) {
                        g.this.c((net.one97.paytm.network.f) obj);
                    }
                });
            }
        }
    }

    private void O() {
        if (this.C == net.one97.paytm.wallet.utility.g.PAY_METHOD_NOT_CALLED.getValue() && this.n.isPgEnabled()) {
            return;
        }
        if ((K() || M()) && this.E != net.one97.paytm.jeweller.b.JEWELLER_DISPLAYED.getValue() && this.E == net.one97.paytm.jeweller.b.JEWELLER_SUCCESS.getValue()) {
            this.E = net.one97.paytm.jeweller.b.JEWELLER_DISPLAYED.getValue();
        }
    }

    private String P() {
        String b2 = net.one97.paytm.jeweller.a.b(this.f51126g);
        return b2 + this.n.getMappingId();
    }

    private boolean Q() {
        String str;
        double d2;
        CJRQRScanResultModel cJRQRScanResultModel = this.n;
        if (cJRQRScanResultModel != null && !cJRQRScanResultModel.isPgEnabled()) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("new_wallet_screen_type", "send_money");
                net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity(), "new_wallet_pay_send_clicked", hashMap);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            net.one97.paytm.wallet.utility.a.a((Activity) getActivity());
            a(Boolean.FALSE);
            return false;
        }
        String ae2 = ae();
        if (TextUtils.isEmpty(ae2) || ae2.equals("0")) {
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("wallet_error_type", "qr_send_money_error");
                hashMap2.put("wallet_error_text", this.f51126g.getString(R.string.wallet_amount_error));
                net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity(), "wallet_error_displayed", hashMap2);
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e3));
                }
            }
            a(true, this.f51126g.getString(R.string.invalid_amount_error));
            this.k.clearFocus();
            this.k.requestFocus();
            a(Boolean.FALSE);
            return false;
        }
        if (TextUtils.isEmpty(this.n.getComment())) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.L.getText());
            str = sb.toString();
        } else {
            str = this.n.getComment();
        }
        if (TextUtils.isEmpty(this.p) || !TextUtils.isEmpty(str)) {
            try {
                double parseDouble = Double.parseDouble(ae2);
                if (parseDouble < 1.0d) {
                    try {
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("wallet_error_type", "qr_send_money_error");
                        hashMap3.put("wallet_error_text", this.f51126g.getString(R.string.transaction_limit_message_min_offline_pg));
                        net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity(), "wallet_error_displayed", hashMap3);
                    } catch (Exception e4) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e4));
                        }
                    }
                    if (getActivity() != null) {
                        if (isAdded()) {
                            a(this.f51126g.getString(R.string.transaction_limit_header), this.f51126g.getString(R.string.transaction_limit_message_min_offline_pg), false);
                            a(Boolean.FALSE);
                        }
                    }
                    return false;
                } else if (!this.bN || parseDouble <= ((double) this.bP)) {
                    if (parseDouble > net.one97.paytm.wallet.utility.j.f72322a.doubleValue() && !this.aO) {
                        a(true, this.f51126g.getString(R.string.max_amount_payable_p2m));
                        return false;
                    }
                    IJRDataModel iJRDataModel = this.x;
                    if (iJRDataModel instanceof CJRPayChannel) {
                        CJRPayChannel cJRPayChannel = (CJRPayChannel) iJRDataModel;
                        if ((cJRPayChannel.getPayMethod() != null && cJRPayChannel.getPayMethod().equalsIgnoreCase(SDKConstants.AI_KEY_PPBL)) || cJRPayChannel.getPayMethod().equalsIgnoreCase("PAYTM_DIGITAL_CREDIT")) {
                            if (cJRPayChannel.getChannelMode().equalsIgnoreCase("")) {
                                a(Boolean.FALSE);
                                return false;
                            }
                            double parseDouble2 = Double.parseDouble(ae());
                            if (cJRPayChannel.getPayMethod().equalsIgnoreCase("PAYTM_DIGITAL_CREDIT")) {
                                d2 = Double.parseDouble(cJRPayChannel.getPayChannelOptionDetails().get(0).getBalanceInfo().getAccountBalance().getValue());
                            } else {
                                d2 = Double.parseDouble(cJRPayChannel.getChannelMode());
                            }
                            if (parseDouble2 > d2) {
                                a(Boolean.FALSE);
                                Toast.makeText(getContext(), this.f51126g.getString(R.string.insufficent_payment_bank), 1).show();
                                return false;
                            }
                        }
                    }
                    return true;
                } else {
                    a(true, String.format(this.f51126g.getString(R.string.gallery_max_amount_p2m), new Object[]{Integer.valueOf(this.bP)}));
                    return false;
                }
            } catch (NumberFormatException e5) {
                a("", this.f51126g.getString(R.string.wallet_amount_error), false);
                a(Boolean.FALSE);
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e5));
                }
            }
        } else {
            try {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("wallet_error_type", "qr_send_money_error");
                hashMap4.put("wallet_error_text", String.format(this.f51126g.getString(R.string.wallet_comment_error), new Object[]{this.p}));
                net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity(), "wallet_error_displayed", hashMap4);
            } catch (Exception e6) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e6));
                }
            }
            a("", String.format(this.f51126g.getString(R.string.wallet_comment_error), new Object[]{this.p}), false);
            a(Boolean.FALSE);
            return false;
        }
    }

    private void R() {
        String str;
        if (!Q()) {
            a(Boolean.FALSE);
        } else if (!com.paytm.utility.b.r((Context) getActivity())) {
            a(Boolean.FALSE);
            net.one97.paytm.wallet.utility.a.a((Fragment) this);
        } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J != null) {
            ak();
        } else if (!this.n.isPgEnabled() || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e() == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e().getBody() == null || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e().getBody().getPcfEnabled()) {
            CJRQRScanResultModel cJRQRScanResultModel = this.n;
            if (cJRQRScanResultModel == null || !cJRQRScanResultModel.isOfflinePostConvenience()) {
                Double valueOf = Double.valueOf(ae());
                String mobileNo = this.n.getMobileNo();
                if (TextUtils.isEmpty(this.n.getComment())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.L.getText());
                    str = sb.toString();
                } else {
                    str = this.n.getComment();
                }
                a(valueOf, mobileNo, str);
                return;
            }
            y();
        } else {
            this.by = ae();
            a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode(), net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getChannelCode(), ae());
        }
    }

    /* access modifiers changed from: private */
    public String S() {
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().c() != null && !TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().c().getMerchantDisplayName())) {
            String merchantDisplayName = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().c().getMerchantDisplayName();
            if (merchantDisplayName.length() <= 20) {
                return merchantDisplayName;
            }
            return merchantDisplayName.substring(0, 20) + "..";
        } else if (!"QR_CODE_REQUEST_MONEY".equalsIgnoreCase(this.n.getRequestType()) || TextUtils.isEmpty(this.n.getName())) {
            CJRQRScanResultModel cJRQRScanResultModel = this.n;
            if (cJRQRScanResultModel == null) {
                return "";
            }
            if (!TextUtils.isEmpty(cJRQRScanResultModel.getMerchantName())) {
                if (this.n.getMerchantName().length() <= 20) {
                    return this.n.getMerchantName();
                }
                return this.n.getMerchantName().substring(0, 20) + "..";
            } else if (TextUtils.isEmpty(this.n.getName())) {
                return "";
            } else {
                if (this.n.getName().length() <= 20) {
                    return this.n.getName();
                }
                return this.n.getName().substring(0, 20) + "..";
            }
        } else if (this.n.getName().length() <= 20) {
            return this.n.getName();
        } else {
            return this.n.getName().substring(0, 20) + "..";
        }
    }

    /* access modifiers changed from: private */
    public void a(Double d2, String str, String str2) {
        at.a().f69666c = Long.valueOf(System.currentTimeMillis());
        if (getActivity() == null || getActivity().isFinishing()) {
            a(Boolean.FALSE);
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_send_money_method_name", "qr");
            hashMap.put("wallet_send_money_amount", d2);
            hashMap.put("wallet_send_money_comment", str2);
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(getActivity(), "wallet_send_money_clicked", hashMap);
        } catch (Exception e2) {
            a(Boolean.FALSE);
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
        if ("QR_CODE_REQUEST_MONEY".equalsIgnoreCase(this.n.getRequestType())) {
            a(str, d2.doubleValue(), str2, false);
            return;
        }
        a(str, d2.doubleValue(), str2, true);
    }

    private void a(String str, double d2, String str2, boolean z2) {
        String str3;
        String str4;
        this.f51122b = z2;
        if (!z2) {
            if (TextUtils.isDigitsOnly(str)) {
                str3 = str;
                str4 = null;
            } else {
                str4 = str;
                str3 = null;
            }
            net.one97.paytm.wallet.d.e eVar = this.f51123c;
            if (eVar != null) {
                eVar.a(str4, str3, String.valueOf(d2), str2, this.n);
            } else {
                a(Boolean.FALSE);
            }
        } else if (this.f51124e != null) {
            double d3 = 0.0d;
            if (!this.n.isPgEnabled()) {
                this.s = new CJRPGTransactionParams();
                this.s.setIsPcf(this.bf);
                CJRPGTransactionParams cJRPGTransactionParams = this.s;
                BigDecimal bigDecimal = this.be;
                if (bigDecimal != null) {
                    d3 = bigDecimal.doubleValue();
                }
                cJRPGTransactionParams.setPcfAmount(Double.valueOf(d3));
                this.f51124e.a(this.n, this.s, String.valueOf(d2), str2);
                return;
            }
            this.s = new CJRPGTransactionParams();
            this.s.setAuthMode(this.n.getAuthMode());
            this.s.setChannelId(this.n.getChannelID());
            this.s.setIndustryType(this.n.getIndustryTypeID());
            this.s.setMerchantGUID(this.n.getMerchantGUID());
            this.s.setMid(this.n.getMappingId());
            this.s.setPaymentMode(this.n.getPaymentTypeID());
            this.s.setCurrency(this.n.getCurrency());
            this.s.setTxnAmount(String.valueOf(d2));
            this.s.setQrCodeId(this.n.getQrCodeId());
            this.s.setPosId(this.n.getPosId());
            String merchantTransId = this.n.getMerchantTransId();
            this.s.setIsPcf(this.bf);
            CJRPGTransactionParams cJRPGTransactionParams2 = this.s;
            BigDecimal bigDecimal2 = this.be;
            if (bigDecimal2 != null) {
                d3 = bigDecimal2.doubleValue();
            }
            cJRPGTransactionParams2.setPcfAmount(Double.valueOf(d3));
            if (!TextUtils.isEmpty(merchantTransId)) {
                this.s.setOrderId(merchantTransId);
            } else if (!TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d())) {
                this.s.setOrderId(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d());
            } else {
                this.s.setRefId(this.aV);
            }
            this.s.setAdditionalInfo(T());
            InstrumentInfo instrumentInfo = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
            boolean z3 = false;
            if (instrumentInfo != null && (instrumentInfo.isWalletAPIFAIL() || instrumentInfo.isDummyWalletView())) {
                z3 = true;
            }
            this.s.setBalanceUnavailable(z3);
            CJRLinkBasePaymentResponse cJRLinkBasePaymentResponse = this.ak;
            if (cJRLinkBasePaymentResponse != null) {
                this.s.setLinkDescription(cJRLinkBasePaymentResponse.linkDescription);
            }
            String linkType = this.n.getLinkType();
            if (!TextUtils.isEmpty(linkType)) {
                this.s.setLinkType(linkType);
                this.s.setId(this.n.getId());
            }
            if (net.one97.paytm.wallet.communicator.b.a().getBooleanFromGTM(this.f51125f, "is_wallet_direct_payment_enable", true)) {
                this.f51124e.a(this.s, net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null ? "0" : net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getTotalBalance(), d(), str2);
            } else {
                this.f51124e.a(this.s, str2);
            }
        } else {
            a(Boolean.FALSE);
        }
    }

    private String T() {
        String str;
        if (getArguments().getSerializable("extra_p2m_contact") != null) {
            return "mode:mobile_number";
        }
        StringBuilder sb = new StringBuilder();
        if (this.bB) {
            try {
                for (Map.Entry next : net.one97.paytm.wallet.utility.a.j(this.bC).entrySet()) {
                    if (!"warning_msg".equalsIgnoreCase((String) next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Boolean) || (value instanceof Long) || (value instanceof Integer) || (value instanceof Double)) {
                            if (!TextUtils.isEmpty(sb)) {
                                sb.append("|");
                            }
                            String str2 = (String) next.getKey();
                            if (!TextUtils.isEmpty(str2) && str2.startsWith(AppConstants.MapQrConstants.UPI)) {
                                str2 = str2.substring(str2.indexOf("?") + 1, str2.length());
                            }
                            sb.append(str2 + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON + ((String) next.getValue()));
                        }
                    }
                }
            } catch (Exception unused) {
            }
        } else {
            JSONObject json = this.n.getJson();
            Iterator<String> keys = json.keys();
            while (keys.hasNext()) {
                String next2 = keys.next();
                if (!"warning_msg".equalsIgnoreCase(next2)) {
                    Object opt = json.opt(next2);
                    if ((opt instanceof String) || (opt instanceof Boolean) || (opt instanceof Long) || (opt instanceof Integer) || (opt instanceof Double)) {
                        if (!TextUtils.isEmpty(sb)) {
                            sb.append("|");
                        }
                        sb.append(next2 + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON + json.opt(next2));
                    }
                }
            }
        }
        StringBuilder sb2 = new StringBuilder("|comment:");
        if (TextUtils.isEmpty(this.n.getComment())) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.L.getText());
            str = sb3.toString();
        } else {
            str = this.n.getComment();
        }
        sb2.append(str);
        sb.append(sb2.toString());
        return sb.toString();
    }

    public void onPause() {
        super.onPause();
        A();
    }

    public void setUserVisibleHint(boolean z2) {
        if (!z2) {
            V();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    private void U() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            try {
                if (this.t == null) {
                    this.t = net.one97.paytm.wallet.utility.a.b((Activity) getActivity());
                }
                if (this.t != null && !this.t.isShowing()) {
                    this.t.show();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.d(String.valueOf(e2));
                }
            }
        }
    }

    private void V() {
        try {
            if (this.t != null && this.t.isShowing()) {
                this.t.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    /* access modifiers changed from: private */
    public void W() {
        CustomAmountAnimatedEditText customAmountAnimatedEditText = this.k;
        if (customAmountAnimatedEditText != null && customAmountAnimatedEditText.hasFocus()) {
            this.k.removeCallbacks(this.bR);
        }
        EditText editText = this.L;
        if (editText != null && editText.hasFocus()) {
            this.L.removeCallbacks(this.bR);
        }
        if (getActivity() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            View currentFocus = getActivity().getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void X() {
        if (getActivity() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            View currentFocus = getActivity().getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.showSoftInput(currentFocus, 1);
            }
        }
    }

    private void a(NetworkCustomError networkCustomError) {
        a(Boolean.FALSE);
        V();
        af();
        if (networkCustomError != null && (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
            net.one97.paytm.wallet.communicator.b.a().handleSessionTimeout(getActivity(), networkCustomError, (String) null, (Bundle) null, true);
        } else if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getFullUrl())) {
            if (networkCustomError.getFullUrl().contains(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "pgWalletBalanceURL"))) {
                if (!isAdded()) {
                    return;
                }
                if (networkCustomError != null && (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                    net.one97.paytm.wallet.communicator.b.a().handleError(this.f51125f, networkCustomError, g.class.getName(), (Bundle) null, false);
                } else if (this.bl) {
                    this.bA = false;
                    this.f51127h.b(false);
                } else {
                    CJRQRScanResultModel cJRQRScanResultModel = this.n;
                    if (cJRQRScanResultModel != null && !cJRQRScanResultModel.isPgEnabled()) {
                        Toast.makeText(getContext(), this.f51126g.getResources().getString(R.string.unable_to_fetch_paytm_wallet_p2m), 1).show();
                    }
                    this.T = true;
                    if (this.ay) {
                        this.bA = false;
                        this.f51127h.b(false);
                        InstrumentInfo instrumentInfo = new InstrumentInfo();
                        instrumentInfo.setPayMode("BALANCE");
                        instrumentInfo.setDisplayPrimaryInfo(this.f51126g.getString(R.string.paytm_wallet));
                        instrumentInfo.setDisplaySecondaryInfo(this.f51126g.getString(R.string.available_payable_balance));
                        instrumentInfo.setWalletAPIFAIL(true);
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(this.f51126g, Double.valueOf(Double.NaN), Double.valueOf(Double.NaN));
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.setWalletAPIFAIL(true);
                    }
                }
            } else if (networkCustomError.getFullUrl().contains(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f51126g, "offlinePGFetchPayOptionsv2")) || networkCustomError.getFullUrl().contains(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f51126g, "fetchQRPaymentDetailsv2"))) {
                b(true);
                if (this.bl) {
                    this.bA = false;
                    this.f51127h.b(false);
                    return;
                }
                this.C = net.one97.paytm.wallet.utility.g.PAY_METHOD_FAIL.getValue();
                this.P = true;
                if (isAdded()) {
                    j(this.f51126g.getString(R.string.error_in_fetching_intrument_p2m_v1));
                }
                if (!this.aL) {
                    this.bA = false;
                    this.f51127h.b(false);
                    aq();
                    this.aL = true;
                }
                O();
            } else if (TextUtils.isEmpty(networkCustomError.getFullUrl()) || !networkCustomError.getFullUrl().equals(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW))) {
                Activity activity = this.f51125f;
                if (activity != null && !activity.isFinishing()) {
                    Toast.makeText(this.f51125f, this.f51126g.getString(R.string.network_error_message), 0).show();
                }
            } else {
                this.G = true;
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u() && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().t()) {
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13093i);
                    a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "updateSelection");
                } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().m != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().m.size() > 0 && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d("UPI")) {
                    Z();
                } else if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d("UPI")) {
                    aa();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:141:0x04ad, code lost:
        if (r1 == net.one97.paytm.wallet.utility.j.c.UPI_CREATED_NO_BANK_LINK.getValue()) goto L_0x04af;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0618  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x09b5  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0a07  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0a42  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0a89  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0ae1  */
    /* JADX WARNING: Removed duplicated region for block: B:522:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.network.model.IJRPaytmDataModel r30) {
        /*
            r29 = this;
            r8 = r29
            r0 = r30
            java.lang.String r1 = "value"
            r29.V()
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.wallet.CJRWalletConvenienceFee
            if (r2 == 0) goto L_0x00a0
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r8.a((java.lang.Boolean) r1)
            if (r0 == 0) goto L_0x10ff
            net.one97.paytm.common.entity.wallet.CJRWalletConvenienceFee r0 = (net.one97.paytm.common.entity.wallet.CJRWalletConvenienceFee) r0
            net.one97.paytm.common.entity.wallet.CJRWalletConvenienceFee$ConvenienceFeeResponse r1 = r0.response
            if (r1 == 0) goto L_0x10ff
            net.one97.paytm.common.entity.wallet.CJRWalletConvenienceFee$ConvenienceFeeResponse r1 = r0.response
            java.lang.Double r1 = r1.getTxnAmount()
            double r1 = r1.doubleValue()
            java.math.BigDecimal r1 = java.math.BigDecimal.valueOf(r1)
            net.one97.paytm.common.entity.wallet.CJRWalletConvenienceFee$ConvenienceFeeResponse r2 = r0.response
            java.lang.Double r2 = r2.getConvenienceFee()
            double r2 = r2.doubleValue()
            java.math.BigDecimal r2 = java.math.BigDecimal.valueOf(r2)
            net.one97.paytm.common.entity.wallet.CJRWalletConvenienceFee$ConvenienceFeeResponse r0 = r0.response
            java.lang.Double r0 = r0.getServiceTax()
            double r3 = r0.doubleValue()
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r3)
            java.math.BigDecimal r0 = r2.add(r0)
            java.math.BigDecimal r2 = r1.add(r0)
            r8.v = r2
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r2 = r8.n
            java.lang.String r2 = r2.getComment()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x006d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.widget.EditText r3 = r8.L
            android.text.Editable r3 = r3.getText()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L_0x0073
        L_0x006d:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r2 = r8.n
            java.lang.String r2 = r2.getComment()
        L_0x0073:
            net.one97.paytm.wallet.g.a$a r3 = net.one97.paytm.wallet.g.a.f70365a
            java.lang.String r9 = r1.toString()
            java.lang.String r10 = r0.toString()
            java.math.BigDecimal r0 = r8.v
            java.lang.String r11 = r0.toString()
            android.content.Context r12 = r8.f51126g
            java.lang.String r13 = r29.S()
            net.one97.paytm.p2mNewDesign.d.g$9 r14 = new net.one97.paytm.p2mNewDesign.d.g$9
            r14.<init>(r1, r2)
            net.one97.paytm.wallet.g.a r0 = net.one97.paytm.wallet.g.a.C1418a.a(r9, r10, r11, r12, r13, r14)
            androidx.fragment.app.FragmentActivity r1 = r29.getActivity()
            androidx.fragment.app.j r1 = r1.getSupportFragmentManager()
            java.lang.String r2 = "PCF_BOTTOMSHEET"
            r0.show((androidx.fragment.app.j) r1, (java.lang.String) r2)
            return
        L_0x00a0:
            boolean r2 = r0 instanceof net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse
            java.lang.String r3 = " "
            java.lang.String r4 = "BALANCE"
            r5 = 0
            r7 = 1
            r9 = 0
            if (r2 == 0) goto L_0x0aed
            r29.af()
            r29.V()
            r29.A()
            net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r0 = (net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r0
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.body
            r2 = 0
            if (r1 == 0) goto L_0x015f
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.body
            net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r1 = r1.getMerchantPayOption()
            if (r1 == 0) goto L_0x015f
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r1 = r1.J
            java.lang.String r10 = "InstrumentCacheEnabledAndroid"
            if (r1 != 0) goto L_0x0126
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r11 = r8.f51125f
            boolean r1 = r1.getBooleanFromGTM(r11, r10, r9)
            if (r1 == 0) goto L_0x015f
            net.one97.paytm.p2mNewDesign.i.c r1 = r8.aT
            if (r1 == 0) goto L_0x015f
            boolean r1 = r8.aN
            if (r1 != 0) goto L_0x015f
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r8.n
            java.lang.String r1 = r1.getMerchantTransId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x015f
            boolean r1 = r8.aO
            if (r1 == 0) goto L_0x010e
            boolean r1 = r8.aP
            if (r1 == 0) goto L_0x015f
            net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r1 = a((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r0)
            if (r1 == 0) goto L_0x015f
            net.one97.paytm.p2mNewDesign.i.c r10 = r8.aT
            android.content.Context r11 = r8.f51126g
            java.lang.String r11 = com.paytm.utility.b.n((android.content.Context) r11)
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r12 = r8.n
            java.lang.String r12 = r12.getMappingId()
            r10.a((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r1, (java.lang.String) r11, (java.lang.String) r12)
            goto L_0x015f
        L_0x010e:
            net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r1 = a((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r0)
            if (r1 == 0) goto L_0x015f
            net.one97.paytm.p2mNewDesign.i.c r10 = r8.aT
            android.content.Context r11 = r8.f51126g
            java.lang.String r11 = com.paytm.utility.b.n((android.content.Context) r11)
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r12 = r8.n
            java.lang.String r12 = r12.getMappingId()
            r10.a((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r1, (java.lang.String) r11, (java.lang.String) r12)
            goto L_0x015f
        L_0x0126:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r8.n
            java.lang.String r1 = r1.getMappingId()
            net.one97.paytm.wallet.communicator.c r11 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r12 = r8.f51125f
            boolean r10 = r11.getBooleanFromGTM(r12, r10, r9)
            if (r10 == 0) goto L_0x015f
            net.one97.paytm.p2mNewDesign.i.c r10 = r8.aT
            if (r10 == 0) goto L_0x015f
            boolean r10 = android.text.TextUtils.isEmpty(r1)
            if (r10 != 0) goto L_0x015f
            net.one97.paytm.p2mNewDesign.i.c r10 = r8.aT
            java.lang.String r11 = "mId"
            kotlin.g.b.k.c(r1, r11)
            kotlinx.coroutines.GlobalScope r11 = kotlinx.coroutines.GlobalScope.INSTANCE
            r12 = r11
            kotlinx.coroutines.CoroutineScope r12 = (kotlinx.coroutines.CoroutineScope) r12
            r13 = 0
            r14 = 0
            net.one97.paytm.p2mNewDesign.i.c$e r11 = new net.one97.paytm.p2mNewDesign.i.c$e
            r11.<init>(r10, r1, r2)
            r15 = r11
            kotlin.g.a.m r15 = (kotlin.g.a.m) r15
            r16 = 3
            r17 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r12, r13, r14, r15, r16, r17)
        L_0x015f:
            boolean r1 = r8.bl
            if (r1 == 0) goto L_0x016b
            r8.bA = r9
            net.one97.paytm.p2mNewDesign.j.b r0 = r8.f51127h
            r0.b((boolean) r9)
            return
        L_0x016b:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r1.n
            if (r1 == 0) goto L_0x0195
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r1.n
            java.lang.String r1 = r1.getPayMode()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0195
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r1.n
            java.lang.String r1 = r1.getPayMode()
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto L_0x0195
            r1 = 1
            goto L_0x0196
        L_0x0195:
            r1 = 0
        L_0x0196:
            r8.ba = r1
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r10 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r10.a((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r2)
            java.lang.String r10 = ""
            r1.f13086b = r10
            r1.y = r9
            r1.z = r9
            r1.B = r9
            r1.A = r2
            r1.C = r2
            r1.w = r9
            r1.D = r9
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r10 = r8.n
            java.lang.String r10 = r10.getMappingId()
            r1.f13089e = r10
            r8.ay = r7
            r8.b((boolean) r7)
            net.one97.paytm.b.a.e.a()
            boolean r1 = net.one97.paytm.b.a.e.f()
            if (r1 == 0) goto L_0x01d7
            r8.ay = r7
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r1.x = r9
        L_0x01d7:
            if (r0 != 0) goto L_0x01f9
            r29.ah()
            android.content.Context r0 = r8.f51126g
            int r1 = net.one97.paytm.wallet.R.string.error_in_fetching_intrument_p2m_v1
            java.lang.String r1 = r0.getString(r1)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r7)
            r0.show()
            java.lang.String r0 = "response is null and amount is reset"
            com.paytm.utility.q.d(r0)
            net.one97.paytm.wallet.utility.g r0 = net.one97.paytm.wallet.utility.g.PAY_METHOD_SUCCESS
            int r0 = r0.getValue()
            r8.C = r0
            return
        L_0x01f9:
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            java.lang.String r10 = "response  payview is null and amount is reset"
            if (r1 != 0) goto L_0x021f
            r29.ah()
            android.content.Context r0 = r8.f51126g
            int r1 = net.one97.paytm.wallet.R.string.error_in_fetching_intrument_p2m_v1
            java.lang.String r1 = r0.getString(r1)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r7)
            r0.show()
            net.one97.paytm.wallet.utility.g r0 = net.one97.paytm.wallet.utility.g.PAY_METHOD_SUCCESS
            int r0 = r0.getValue()
            r8.C = r0
            com.paytm.utility.q.d(r10)
            return
        L_0x021f:
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r1 = r1.getMerchantPayOption()
            if (r1 != 0) goto L_0x0247
            r29.ah()
            android.content.Context r0 = r8.f51126g
            int r1 = net.one97.paytm.wallet.R.string.error_in_fetching_intrument_p2m_v1
            java.lang.String r1 = r0.getString(r1)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r7)
            r0.show()
            net.one97.paytm.wallet.utility.g r0 = net.one97.paytm.wallet.utility.g.PAY_METHOD_SUCCESS
            int r0 = r0.getValue()
            r8.C = r0
            com.paytm.utility.q.d(r10)
            return
        L_0x0247:
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.ResultInfoV2 r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x0295
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.ResultInfoV2 r1 = r1.getResultInfo()
            java.lang.String r1 = r1.getResultStatus()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0277
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.ResultInfoV2 r1 = r1.getResultInfo()
            java.lang.String r1 = r1.getResultStatus()
            java.lang.String r11 = "F"
            boolean r1 = r1.equalsIgnoreCase(r11)
            if (r1 == 0) goto L_0x0295
        L_0x0277:
            r29.ah()
            android.content.Context r0 = r8.f51126g
            int r1 = net.one97.paytm.wallet.R.string.error_in_fetching_intrument_p2m_v1
            java.lang.String r1 = r0.getString(r1)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r7)
            r0.show()
            net.one97.paytm.wallet.utility.g r0 = net.one97.paytm.wallet.utility.g.PAY_METHOD_SUCCESS
            int r0 = r0.getValue()
            r8.C = r0
            com.paytm.utility.q.d(r10)
            return
        L_0x0295:
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r10 = r8.f51125f
            java.lang.String r11 = "isP2MGalleryAlertEnabled"
            boolean r1 = r1.getBooleanFromGTM(r10, r11, r7)
            if (r1 == 0) goto L_0x02d9
            boolean r1 = r8.bN
            if (r1 == 0) goto L_0x02d9
            boolean r1 = r8.bO
            if (r1 != 0) goto L_0x02d9
            net.one97.paytm.f.b r1 = net.one97.paytm.f.b.a()
            net.one97.paytm.common.entity.RiskAnalysis.RiskExtendedInfo r1 = r1.f50402a
            boolean r10 = r8.bN
            r1.setGalleryScan(r10)
            android.app.Activity r1 = r8.f51125f
            android.content.Context r1 = r1.getApplicationContext()
            com.paytm.b.a.a r1 = net.one97.paytm.utils.be.a(r1)
            java.lang.String r10 = "show_gallery_alert"
            boolean r1 = r1.b((java.lang.String) r10, (boolean) r7, (boolean) r9)
            if (r1 == 0) goto L_0x02d9
            r8.bO = r7
            android.os.Handler r1 = new android.os.Handler
            r1.<init>()
            net.one97.paytm.p2mNewDesign.d.-$$Lambda$g$0vvuvZOM3SdfhnnQJEkbA0B1hSA r10 = new net.one97.paytm.p2mNewDesign.d.-$$Lambda$g$0vvuvZOM3SdfhnnQJEkbA0B1hSA
            r10.<init>()
            r11 = 1000(0x3e8, double:4.94E-321)
            r1.postDelayed(r10, r11)
        L_0x02d9:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r8.n
            java.lang.String r1 = r1.getMerchantTransId()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x02f2
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r10 = r8.n
            java.lang.String r10 = r10.getMerchantTransId()
            r1.setOrderId(r10)
        L_0x02f2:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r1.a((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r0)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r1 = r1.I()
            r10 = 8
            if (r1 == 0) goto L_0x0328
            android.widget.EditText r1 = r8.L
            r1.setVisibility(r9)
            com.google.android.material.textfield.TextInputLayout r1 = r8.aq
            r1.setVisibility(r9)
            android.widget.TextView r1 = r8.U
            r1.setVisibility(r10)
            com.google.android.material.textfield.TextInputLayout r1 = r8.aq
            r1.setHint(r2)
            android.widget.EditText r1 = r8.L
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r11 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            android.content.Context r12 = r8.f51126g
            java.lang.String r11 = r11.d((android.content.Context) r12)
            r1.setHint(r11)
        L_0x0328:
            android.widget.EditText r1 = r8.L
            net.one97.paytm.p2mNewDesign.d.g$27 r11 = new net.one97.paytm.p2mNewDesign.d.g$27
            r11.<init>()
            r1.addTextChangedListener(r11)
            r29.D()
            r29.F()
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            boolean r1 = r1.getActiveMerchant()
            if (r1 != 0) goto L_0x0402
            android.app.Activity r0 = r8.f51125f
            int r1 = net.one97.paytm.wallet.R.id.payment_detail
            android.view.View r0 = r0.findViewById(r1)
            r0.setVisibility(r10)
            android.widget.TextView r0 = r8.ap
            r0.setVisibility(r10)
            net.one97.paytm.b.a.e.a()
            net.one97.paytm.b.a.d r0 = net.one97.paytm.b.a.e.e()
            if (r0 == 0) goto L_0x03aa
            net.one97.paytm.b.a.e.a()
            net.one97.paytm.b.a.d r0 = net.one97.paytm.b.a.e.e()
            net.one97.paytm.common.entity.wallet.CJRQRInfoResponse r0 = r0.f49486a
            if (r0 == 0) goto L_0x03aa
            net.one97.paytm.b.a.e.a()
            net.one97.paytm.b.a.d r0 = net.one97.paytm.b.a.e.e()
            net.one97.paytm.common.entity.wallet.CJRQRInfoResponse r0 = r0.f49486a
            org.json.JSONObject r0 = r0.getResponse()
            if (r0 == 0) goto L_0x03aa
            net.one97.paytm.b.a.e.a()
            net.one97.paytm.b.a.d r0 = net.one97.paytm.b.a.e.e()
            net.one97.paytm.common.entity.wallet.CJRQRInfoResponse r0 = r0.f49486a
            org.json.JSONObject r0 = r0.getResponse()
            java.lang.String r1 = "tagLine"
            boolean r0 = r0.has(r1)
            if (r0 == 0) goto L_0x03aa
            net.one97.paytm.b.a.e.a()
            net.one97.paytm.b.a.d r0 = net.one97.paytm.b.a.e.e()
            net.one97.paytm.common.entity.wallet.CJRQRInfoResponse r0 = r0.f49486a
            org.json.JSONObject r0 = r0.getResponse()
            java.lang.String r1 = "tagLine"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x03a1 }
            r8.c((java.lang.String) r0)     // Catch:{ JSONException -> 0x03a1 }
            goto L_0x03af
        L_0x03a1:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.paytm.utility.q.d(r0)
            goto L_0x03af
        L_0x03aa:
            android.widget.TextView r0 = r8.f51128i
            r0.setVisibility(r10)
        L_0x03af:
            android.widget.LinearLayout r0 = r8.O
            r0.setVisibility(r10)
            java.lang.String r0 = r29.S()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03dc
            android.widget.TextView r0 = r8.aY
            android.content.Context r1 = r8.f51126g
            android.content.res.Resources r1 = r1.getResources()
            int r2 = net.one97.paytm.wallet.R.string.inactive_merchant_text_suffix
            java.lang.String r1 = r1.getString(r2)
            java.lang.Object[] r2 = new java.lang.Object[r7]
            java.lang.String r3 = r29.S()
            r2[r9] = r3
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.setText(r1)
            goto L_0x03f7
        L_0x03dc:
            android.widget.TextView r0 = r8.aY
            android.content.Context r1 = r8.f51126g
            android.content.res.Resources r1 = r1.getResources()
            int r2 = net.one97.paytm.wallet.R.string.inactive_merchant_text_suffix
            java.lang.String r1 = r1.getString(r2)
            java.lang.Object[] r2 = new java.lang.Object[r7]
            java.lang.String r3 = "This merchant"
            r2[r9] = r3
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.setText(r1)
        L_0x03f7:
            android.widget.LinearLayout r0 = r8.al
            r0.setVisibility(r10)
            android.widget.LinearLayout r0 = r8.aX
            r0.setVisibility(r9)
            return
        L_0x0402:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r1 = r8.n
            boolean r1 = r1.isPgEnabled()
            if (r1 != 0) goto L_0x0441
            net.one97.paytm.b.a.e.a()
            boolean r0 = net.one97.paytm.b.a.e.f()
            if (r0 == 0) goto L_0x0425
            r29.aq()
            net.one97.paytm.p2mNewDesign.j.b r0 = r8.f51127h
            if (r0 == 0) goto L_0x0421
            java.lang.String r1 = r29.ae()
            r0.c((java.lang.String) r1)
        L_0x0421:
            r29.ar()
            return
        L_0x0425:
            boolean r0 = r8.aL
            if (r0 != 0) goto L_0x0440
            r29.aq()
            net.one97.paytm.p2mNewDesign.j.b r0 = r8.f51127h
            if (r0 == 0) goto L_0x0437
            java.lang.String r1 = r29.ae()
            r0.c((java.lang.String) r1)
        L_0x0437:
            r29.ar()
            boolean r0 = r8.aN
            if (r0 != 0) goto L_0x0440
            r8.aL = r7
        L_0x0440:
            return
        L_0x0441:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r1 = r1.s()
            if (r1 != 0) goto L_0x044d
            r8.G = r7
        L_0x044d:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            int r1 = r1.b((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r0)
            net.one97.paytm.wallet.utility.j$c r11 = net.one97.paytm.wallet.utility.j.c.NO_UPI
            int r11 = r11.getValue()
            if (r1 == r11) goto L_0x0465
            net.one97.paytm.wallet.utility.j$c r11 = net.one97.paytm.wallet.utility.j.c.UPI_CREATED_NO_BANK_LINK
            int r11 = r11.getValue()
            if (r1 != r11) goto L_0x04af
        L_0x0465:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r11 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            android.content.Context r12 = r8.f51126g
            int r13 = net.one97.paytm.wallet.R.string.p2p_upi_onboarding_offer
            java.lang.String r13 = r12.getString(r13)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r14 = new net.one97.paytm.p2mNewDesign.entity.InstrumentInfo
            r14.<init>()
            r11.v = r14
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r14 = r11.v
            java.lang.String r15 = "UPI_ONBOARDING"
            r14.setPayMode(r15)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r14 = r11.v
            android.content.res.Resources r15 = r12.getResources()
            int r10 = net.one97.paytm.wallet.R.string.p2m_onboarding_title
            java.lang.String r10 = r15.getString(r10)
            r14.setDisplayPrimaryInfo(r10)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r10 = r11.v
            android.content.res.Resources r12 = r12.getResources()
            int r14 = net.one97.paytm.wallet.R.string.p2m_onboarding_subtitle
            java.lang.String r12 = r12.getString(r14)
            r10.setDisplaySecondaryInfo(r12)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r10 = r11.v
            r10.setmDisplayPrimaryInfo2(r13)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r10 = r11.v
            r10.setUpiOnboardingStatus(r1)
            net.one97.paytm.wallet.utility.j$c r10 = net.one97.paytm.wallet.utility.j.c.UPI_CREATED_NO_BANK_LINK
            int r10 = r10.getValue()
            if (r1 != r10) goto L_0x0536
        L_0x04af:
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r1 = r1.getMerchantPayOption()
            java.util.ArrayList r1 = r1.getPaymentModes()
            if (r1 == 0) goto L_0x0536
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r1 = r1.getMerchantPayOption()
            net.one97.paytm.p2mNewDesign.models.UserProfileSarvatraV2 r1 = r1.getUserProfileSarvatra()
            if (r1 == 0) goto L_0x04dd
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r1 = r1.getMerchantPayOption()
            net.one97.paytm.p2mNewDesign.models.UserProfileSarvatraV2 r1 = r1.getUserProfileSarvatra()
            net.one97.paytm.p2mNewDesign.models.ResponseV2 r1 = r1.getResponse()
            if (r1 != 0) goto L_0x0513
        L_0x04dd:
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r1 = r1.getMerchantPayOption()
            net.one97.paytm.p2mNewDesign.models.UPIProfileV2 r1 = r1.getUpiProfile()
            if (r1 == 0) goto L_0x0536
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r1 = r1.getMerchantPayOption()
            net.one97.paytm.p2mNewDesign.models.UPIProfileV2 r1 = r1.getUpiProfile()
            net.one97.paytm.p2mNewDesign.models.RespDetailsV2 r1 = r1.getRespDetails()
            if (r1 == 0) goto L_0x0536
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r1 = r1.getMerchantPayOption()
            net.one97.paytm.p2mNewDesign.models.UPIProfileV2 r1 = r1.getUpiProfile()
            net.one97.paytm.p2mNewDesign.models.RespDetailsV2 r1 = r1.getRespDetails()
            net.one97.paytm.p2mNewDesign.models.ProfileDetailV2 r1 = r1.getProfileDetail()
            if (r1 == 0) goto L_0x0536
        L_0x0513:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r1 = r1.z()
            if (r1 == 0) goto L_0x0536
            net.one97.paytm.p2mNewDesign.models.BodyV2 r1 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r1 = r1.getMerchantPayOption()
            net.one97.paytm.p2mNewDesign.models.UserProfileSarvatraV2 r1 = r1.getUserProfileSarvatra()
            net.one97.paytm.p2mNewDesign.models.BodyV2 r0 = r0.body
            net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r0 = r0.getMerchantPayOption()
            net.one97.paytm.p2mNewDesign.models.UPIProfileV2 r0 = r0.getUpiProfile()
            r8.a((net.one97.paytm.p2mNewDesign.models.UserProfileSarvatraV2) r1, (net.one97.paytm.p2mNewDesign.models.UPIProfileV2) r0)
        L_0x0536:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            android.content.Context r1 = r8.f51126g
            boolean r10 = r8.aN
            r0.a((android.content.Context) r1, (boolean) r10)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r0 = r0.J
            if (r0 == 0) goto L_0x05d7
            r8.bx = r7
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r0 = r0.J
            java.lang.String r0 = r0.getOfferText()
            if (r0 == 0) goto L_0x056c
            android.widget.LinearLayout r0 = r8.bu
            r0.setVisibility(r9)
            android.widget.TextView r0 = r8.bv
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r1 = r1.J
            java.lang.String r1 = r1.getOfferText()
            r0.setText(r1)
            goto L_0x05b8
        L_0x056c:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r0 = r0.J
            net.one97.paytm.p2mNewDesign.entity.mlv.Cart r0 = r0.getCart()
            if (r0 == 0) goto L_0x05b8
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r0 = r0.J
            net.one97.paytm.p2mNewDesign.entity.mlv.Cart r0 = r0.getCart()
            net.one97.paytm.p2mNewDesign.entity.mlv.MLVInfo r0 = r0.getMLVInfo()
            if (r0 == 0) goto L_0x05b8
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r0 = r0.J
            net.one97.paytm.p2mNewDesign.entity.mlv.Cart r0 = r0.getCart()
            net.one97.paytm.p2mNewDesign.entity.mlv.MLVInfo r0 = r0.getMLVInfo()
            java.lang.String r0 = r0.getPromotionText()
            if (r0 == 0) goto L_0x05b8
            android.widget.LinearLayout r0 = r8.bu
            r0.setVisibility(r9)
            android.widget.TextView r0 = r8.bv
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r1 = r1.J
            net.one97.paytm.p2mNewDesign.entity.mlv.Cart r1 = r1.getCart()
            net.one97.paytm.p2mNewDesign.entity.mlv.MLVInfo r1 = r1.getMLVInfo()
            java.lang.String r1 = r1.getPromotionText()
            r0.setText(r1)
        L_0x05b8:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r0 = r0.J
            net.one97.paytm.p2mNewDesign.entity.mlv.Cart r0 = r0.getCart()
            net.one97.paytm.p2mNewDesign.entity.mlv.MLVInfo r0 = r0.getMLVInfo()
            if (r0 == 0) goto L_0x05d9
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r0 = r0.J
            net.one97.paytm.p2mNewDesign.entity.mlv.Cart r0 = r0.getCart()
            net.one97.paytm.p2mNewDesign.entity.mlv.MLVInfo r0 = r0.getMLVInfo()
            goto L_0x05da
        L_0x05d7:
            r8.bx = r9
        L_0x05d9:
            r0 = r2
        L_0x05da:
            boolean r1 = r8.bx
            if (r1 == 0) goto L_0x0a10
            boolean r1 = r8.aN
            if (r1 != 0) goto L_0x0a10
            if (r0 == 0) goto L_0x0a10
            net.one97.paytm.p2mNewDesign.entity.mlv.AvailableBalance r1 = r0.getAvailableBalance()
            java.lang.String r1 = r1.getValue()
            if (r1 == 0) goto L_0x0a10
            net.one97.paytm.p2mNewDesign.entity.mlv.RedeemPolicy r1 = r0.getRedeemPolicy()
            java.lang.String r1 = r1.getPolicyValue()
            if (r1 == 0) goto L_0x0a10
            net.one97.paytm.p2mNewDesign.entity.mlv.RedeemPolicy r1 = r0.getRedeemPolicy()
            java.lang.String r1 = r1.getPolicyValue()
            if (r1 == 0) goto L_0x0a10
            net.one97.paytm.p2mNewDesign.entity.mlv.RedeemPolicy r1 = r0.getRedeemPolicy()
            java.lang.String r1 = r1.getPolicyValue()
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            double r10 = r1.doubleValue()
            r12 = 4636737291354636288(0x4059000000000000, double:100.0)
            int r1 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x09b5
            net.one97.paytm.p2mNewDesign.g.c r1 = new net.one97.paytm.p2mNewDesign.g.c
            java.lang.String r15 = r29.S()
            net.one97.paytm.p2mNewDesign.entity.mlv.AvailableBalance r10 = r0.getAvailableBalance()
            java.lang.String r10 = r10.getValue()
            java.lang.Double r10 = java.lang.Double.valueOf(r10)
            double r10 = r10.doubleValue()
            double r10 = r10 / r12
            java.lang.String r16 = java.lang.String.valueOf(r10)
            net.one97.paytm.p2mNewDesign.entity.mlv.RedeemPolicy r10 = r0.getRedeemPolicy()
            java.lang.String r17 = r10.getPolicyValue()
            r18 = 1
            net.one97.paytm.p2mNewDesign.entity.mlv.RedeemPolicy r10 = r0.getRedeemPolicy()
            java.lang.String r19 = r10.getPolicyText()
            java.lang.String r20 = r0.getContext()
            java.lang.String r21 = r0.getBonusText()
            java.lang.String r22 = r0.getBonusPointsValue()
            r14 = r1
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            android.widget.LinearLayout r0 = r8.bs
            r0.setVisibility(r9)
            net.one97.paytm.p2mNewDesign.g.b r0 = new net.one97.paytm.p2mNewDesign.g.b
            android.content.Context r10 = r8.f51126g
            r0.<init>(r10)
            r8.bt = r0
            net.one97.paytm.p2mNewDesign.g.b r0 = r8.bt
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r10 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r10 = r10.J
            net.one97.paytm.p2mNewDesign.entity.mlv.Cart r10 = r10.getCart()
            net.one97.paytm.p2mNewDesign.entity.mlv.MLVInfo r10 = r10.getMLVInfo()
            java.lang.String r10 = r10.getProvider()
            net.one97.paytm.p2mNewDesign.g.c r11 = new net.one97.paytm.p2mNewDesign.g.c
            java.lang.String r15 = r29.S()
            java.lang.String r16 = r1.getTotalAvailableBalance()
            java.lang.String r17 = r1.getRedeemablePercentage()
            java.lang.String r19 = r1.getPolicyText()
            java.lang.String r20 = r1.getContext()
            java.lang.String r21 = r1.getBonusText()
            java.lang.String r22 = r1.getBonusPoint()
            r14 = r11
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)
            net.one97.paytm.p2mNewDesign.d.g$14 r14 = new net.one97.paytm.p2mNewDesign.d.g$14
            r14.<init>(r1)
            java.lang.String r1 = "mlvItem"
            kotlin.g.b.k.c(r11, r1)
            java.lang.String r1 = "mlvSelectedListener"
            kotlin.g.b.k.c(r14, r1)
            r0.f51270c = r11
            if (r10 == 0) goto L_0x06ae
            r0.f51271d = r10
        L_0x06ae:
            r0.f51268a = r14
            android.widget.LinearLayout r0 = r8.bs
            net.one97.paytm.p2mNewDesign.g.b r1 = r8.bt
            android.content.Context r10 = r1.f51273f
            android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r10)
            int r11 = net.one97.paytm.wallet.R.layout.mlv_instrument_view2
            android.view.View r10 = r10.inflate(r11, r2)
            java.lang.String r11 = "LayoutInflater.from(cont…v_instrument_view2, null)"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r11)
            r1.f51269b = r10
            android.view.View r10 = r1.f51269b
            java.lang.String r11 = "rootView"
            if (r10 != 0) goto L_0x06d0
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x06d0:
            int r14 = net.one97.paytm.wallet.R.id.iv_mlv_check_uncheck
            android.view.View r10 = r10.findViewById(r14)
            android.widget.CheckBox r10 = (android.widget.CheckBox) r10
            net.one97.paytm.p2mNewDesign.g.b$b r14 = new net.one97.paytm.p2mNewDesign.g.b$b
            r14.<init>(r1)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r10.setOnClickListener(r14)
            android.view.View r10 = r1.f51269b
            if (r10 != 0) goto L_0x06e9
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x06e9:
            int r14 = net.one97.paytm.wallet.R.id.iv_mlv_check_uncheck
            android.view.View r10 = r10.findViewById(r14)
            android.widget.CheckBox r10 = (android.widget.CheckBox) r10
            net.one97.paytm.p2mNewDesign.g.b$c r14 = new net.one97.paytm.p2mNewDesign.g.b$c
            r14.<init>(r1)
            android.widget.CompoundButton$OnCheckedChangeListener r14 = (android.widget.CompoundButton.OnCheckedChangeListener) r14
            r10.setOnCheckedChangeListener(r14)
            android.view.View r10 = r1.f51269b
            if (r10 != 0) goto L_0x0702
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0702:
            int r14 = net.one97.paytm.wallet.R.id.iv_mlv_info
            android.view.View r10 = r10.findViewById(r14)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            net.one97.paytm.p2mNewDesign.g.b$d r14 = new net.one97.paytm.p2mNewDesign.g.b$d
            r14.<init>(r1)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r10.setOnClickListener(r14)
            net.one97.paytm.p2mNewDesign.g.c r10 = r1.f51270c
            if (r10 != 0) goto L_0x071d
            java.lang.String r14 = "mlvItem"
            kotlin.g.b.k.a((java.lang.String) r14)
        L_0x071d:
            if (r10 == 0) goto L_0x0724
            java.lang.String r14 = r10.getTotalAvailableBalance()
            goto L_0x0725
        L_0x0724:
            r14 = r2
        L_0x0725:
            if (r14 == 0) goto L_0x0733
            java.lang.String r14 = r10.getRedeemablePercentage()
            if (r14 == 0) goto L_0x0733
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r14 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r14.H = r10
        L_0x0733:
            java.lang.String r14 = r10.getContext()
            java.lang.String r15 = "USER_ENROLMENT"
            boolean r14 = kotlin.m.p.a((java.lang.String) r15, (java.lang.String) r14, (boolean) r7)
            java.lang.String r15 = "rootView.iv_mlv_check_uncheck"
            java.lang.String r2 = "rootView.tv_merchant_name"
            if (r14 == 0) goto L_0x083a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r10.getBonusText()
            r5.append(r6)
            r5.append(r3)
            android.content.Context r6 = r1.f51273f
            int r12 = net.one97.paytm.wallet.R.string.know_more
            java.lang.String r6 = r6.getString(r12)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            android.content.Context r12 = r1.f51273f
            int r13 = net.one97.paytm.wallet.R.string.know_more
            java.lang.String r12 = r12.getString(r13)
            java.lang.String r13 = "context.getString(R.string.know_more)"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            int r12 = kotlin.m.p.a((java.lang.CharSequence) r6, (java.lang.String) r12, (int) r9, (boolean) r7)
            android.text.SpannableString r13 = new android.text.SpannableString
            r13.<init>(r6)
            net.one97.paytm.p2mNewDesign.g.b$e r6 = new net.one97.paytm.p2mNewDesign.g.b$e
            r6.<init>(r1, r10)
            int r5 = r5.length()
            r10 = 33
            r13.setSpan(r6, r12, r5, r10)
            android.view.View r5 = r1.f51269b
            if (r5 != 0) goto L_0x078f
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x078f:
            int r6 = net.one97.paytm.wallet.R.id.tv_merchant_name
            android.view.View r5 = r5.findViewById(r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r5.setText(r13)
            android.view.View r5 = r1.f51269b
            if (r5 != 0) goto L_0x07a6
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x07a6:
            int r6 = net.one97.paytm.wallet.R.id.tv_merchant_name
            android.view.View r5 = r5.findViewById(r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            android.text.method.MovementMethod r6 = android.text.method.LinkMovementMethod.getInstance()
            r5.setMovementMethod(r6)
            android.view.View r5 = r1.f51269b
            if (r5 != 0) goto L_0x07bf
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x07bf:
            int r6 = net.one97.paytm.wallet.R.id.tv_merchant_name
            android.view.View r5 = r5.findViewById(r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r5.setHighlightColor(r9)
            android.view.View r5 = r1.f51269b
            if (r5 != 0) goto L_0x07d4
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x07d4:
            int r6 = net.one97.paytm.wallet.R.id.tv_merchant_name
            android.view.View r5 = r5.findViewById(r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            r5.setClickable(r7)
            android.view.View r2 = r1.f51269b
            if (r2 != 0) goto L_0x07e9
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x07e9:
            int r5 = net.one97.paytm.wallet.R.id.tv_mlv_amount
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r5 = "rootView.tv_mlv_amount"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r5 = 8
            r2.setVisibility(r5)
            android.view.View r2 = r1.f51269b
            if (r2 != 0) goto L_0x0802
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0802:
            int r6 = net.one97.paytm.wallet.R.id.iv_mlv_info
            android.view.View r2 = r2.findViewById(r6)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            java.lang.String r6 = "rootView.iv_mlv_info"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            r2.setVisibility(r5)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r5 = "DirectPaymentBl.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.g.c r2 = r2.H
            r2.setChecked(r9)
            android.view.View r2 = r1.f51269b
            if (r2 != 0) goto L_0x0827
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0827:
            int r5 = net.one97.paytm.wallet.R.id.iv_mlv_check_uncheck
            android.view.View r2 = r2.findViewById(r5)
            android.widget.CheckBox r2 = (android.widget.CheckBox) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            r2.setChecked(r9)
            r1.a()
            goto L_0x09aa
        L_0x083a:
            java.lang.String r14 = r10.getTotalAvailableBalance()
            if (r14 != 0) goto L_0x0890
            android.view.View r5 = r1.f51269b
            if (r5 != 0) goto L_0x0847
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0847:
            int r6 = net.one97.paytm.wallet.R.id.tv_merchant_name
            android.view.View r5 = r5.findViewById(r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r2)
            android.content.Context r2 = r1.f51273f
            int r6 = net.one97.paytm.wallet.R.string.mlv_merchant_name_2
            r12 = 2
            java.lang.Object[] r12 = new java.lang.Object[r12]
            java.lang.String r10 = r10.getMerchantName()
            r12[r9] = r10
            java.lang.String r10 = r1.f51271d
            java.lang.String r13 = "mLoyal"
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L_0x086c
            java.lang.String r10 = "Points"
            goto L_0x086e
        L_0x086c:
            java.lang.String r10 = "Cashback"
        L_0x086e:
            r12[r7] = r10
            java.lang.String r2 = r2.getString(r6, r12)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5.setText(r2)
            android.view.View r2 = r1.f51269b
            if (r2 != 0) goto L_0x0880
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0880:
            int r5 = net.one97.paytm.wallet.R.id.iv_mlv_check_uncheck
            android.view.View r2 = r2.findViewById(r5)
            android.widget.CheckBox r2 = (android.widget.CheckBox) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            r2.setChecked(r9)
            goto L_0x09aa
        L_0x0890:
            android.view.View r14 = r1.f51269b
            if (r14 != 0) goto L_0x0897
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0897:
            int r12 = net.one97.paytm.wallet.R.id.tv_merchant_name
            android.view.View r12 = r14.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)
            android.content.Context r2 = r1.f51273f
            int r13 = net.one97.paytm.wallet.R.string.mlv_merchant_name_2
            r14 = 2
            java.lang.Object[] r14 = new java.lang.Object[r14]
            java.lang.String r19 = r10.getMerchantName()
            r14[r9] = r19
            java.lang.String r9 = r1.f51271d
            java.lang.String r5 = "mLoyal"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x08bc
            java.lang.String r5 = "Points"
            goto L_0x08be
        L_0x08bc:
            java.lang.String r5 = "Cashback"
        L_0x08be:
            r14[r7] = r5
            java.lang.String r2 = r2.getString(r13, r14)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r12.setText(r2)
            android.view.View r2 = r1.f51269b
            if (r2 != 0) goto L_0x08d0
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x08d0:
            int r5 = net.one97.paytm.wallet.R.id.tv_mlv_amount
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r5 = "rootView.tv_mlv_amount"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            android.content.Context r6 = r1.f51273f
            int r9 = net.one97.paytm.wallet.R.string.mlv_rupee
            java.lang.String r6 = r6.getString(r9)
            r5.append(r6)
            java.lang.String r6 = r10.getTotalAvailableBalance()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
            android.view.View r2 = r1.f51269b
            if (r2 != 0) goto L_0x0904
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0904:
            int r5 = net.one97.paytm.wallet.R.id.iv_mlv_check_uncheck
            android.view.View r2 = r2.findViewById(r5)
            android.widget.CheckBox r2 = (android.widget.CheckBox) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            boolean r5 = r10.isChecked()
            r2.setChecked(r5)
            java.lang.String r2 = r10.getTotalAvailableBalance()
            if (r2 == 0) goto L_0x097e
            double r5 = java.lang.Double.parseDouble(r2)
            r12 = 0
            int r2 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x097e
            r1.f51272e = r7
            android.view.View r2 = r1.f51269b
            if (r2 != 0) goto L_0x092f
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x092f:
            int r5 = net.one97.paytm.wallet.R.id.iv_mlv_check_uncheck
            android.view.View r2 = r2.findViewById(r5)
            android.widget.CheckBox r2 = (android.widget.CheckBox) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            r5 = 0
            r2.setChecked(r5)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r6 = "DirectPaymentBl.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            net.one97.paytm.p2mNewDesign.g.c r2 = r2.H
            r2.setChecked(r5)
            android.view.View r2 = r1.f51269b
            if (r2 != 0) goto L_0x0953
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0953:
            int r5 = net.one97.paytm.wallet.R.id.tv_mlv_amount
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.content.Context r5 = r1.f51273f
            int r6 = net.one97.paytm.wallet.R.color.color_506d85
            int r5 = androidx.core.content.b.c(r5, r6)
            r2.setTextColor(r5)
            android.view.View r2 = r1.f51269b
            if (r2 != 0) goto L_0x096d
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x096d:
            int r5 = net.one97.paytm.wallet.R.id.mlv_container
            android.view.View r2 = r2.findViewById(r5)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            if (r2 == 0) goto L_0x0981
            r5 = 1053609165(0x3ecccccd, float:0.4)
            r2.setAlpha(r5)
            goto L_0x0981
        L_0x097e:
            r2 = 0
            r1.f51272e = r2
        L_0x0981:
            java.lang.String r2 = r10.getRedeemablePercentage()
            if (r2 == 0) goto L_0x09aa
            double r5 = java.lang.Double.parseDouble(r2)
            r9 = 4636737291354636288(0x4059000000000000, double:100.0)
            int r2 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x09aa
            android.view.View r2 = r1.f51269b
            if (r2 != 0) goto L_0x0998
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0998:
            int r5 = net.one97.paytm.wallet.R.id.iv_mlv_info
            android.view.View r2 = r2.findViewById(r5)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            java.lang.String r5 = "rootView.iv_mlv_info"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r5 = 8
            r2.setVisibility(r5)
        L_0x09aa:
            android.view.View r1 = r1.f51269b
            if (r1 != 0) goto L_0x09b1
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x09b1:
            r0.addView(r1)
            goto L_0x09fb
        L_0x09b5:
            net.one97.paytm.p2mNewDesign.g.c r1 = new net.one97.paytm.p2mNewDesign.g.c
            java.lang.String r21 = r29.S()
            net.one97.paytm.p2mNewDesign.entity.mlv.AvailableBalance r2 = r0.getAvailableBalance()
            java.lang.String r2 = r2.getValue()
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            double r5 = r2.doubleValue()
            r9 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r5 = r5 / r9
            java.lang.String r22 = java.lang.String.valueOf(r5)
            net.one97.paytm.p2mNewDesign.entity.mlv.RedeemPolicy r2 = r0.getRedeemPolicy()
            java.lang.String r23 = r2.getPolicyValue()
            r24 = 0
            net.one97.paytm.p2mNewDesign.entity.mlv.RedeemPolicy r2 = r0.getRedeemPolicy()
            java.lang.String r25 = r2.getPolicyText()
            java.lang.String r26 = r0.getContext()
            java.lang.String r27 = r0.getBonusText()
            java.lang.String r28 = r0.getBonusPointsValue()
            r20 = r1
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r0.H = r1
        L_0x09fb:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r8.n
            java.lang.String r0 = r0.getTxnAmount()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0a10
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r8.n
            java.lang.String r0 = r0.getTxnAmount()
            r8.l((java.lang.String) r0)
        L_0x0a10:
            r29.aq()
            r29.ai()
            androidx.fragment.app.FragmentActivity r0 = r29.getActivity()
            java.lang.String r0 = net.one97.paytm.wallet.utility.a.a((android.content.Context) r0)
            r8.q = r0
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRPayChannel r0 = new net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRPayChannel
            android.content.Context r1 = r8.f51126g
            int r2 = net.one97.paytm.wallet.R.string.paytm_wallet
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = r8.q
            r0.<init>(r1, r2)
            r8.x = r0
            r1 = 0
            r8.P = r1
            net.one97.paytm.wallet.utility.g r0 = net.one97.paytm.wallet.utility.g.PAY_METHOD_SUCCESS
            int r0 = r0.getValue()
            r8.C = r0
            r8.aa = r7
            boolean r0 = r8.S
            if (r0 == 0) goto L_0x0a81
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = r0.d((java.lang.String) r4)
            if (r0 == 0) goto L_0x0a53
            net.one97.paytm.n.c r0 = r8.bG
            r1 = 0
            r0.a((java.lang.String) r1, (java.lang.String) r1)
            goto L_0x0a81
        L_0x0a53:
            android.content.Context r0 = r8.f51126g
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = r8.f51126g
            int r4 = net.one97.paytm.wallet.R.string.merchant_doesnt_support_instrunment
            java.lang.String r2 = r2.getString(r4)
            r1.append(r2)
            r1.append(r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            java.lang.String r2 = r2.getDisplayPrimaryInfo()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
        L_0x0a81:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = r0.D
            if (r0 == 0) goto L_0x0ac4
            androidx.fragment.app.FragmentActivity r0 = r29.getActivity()
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L_0x0aec
            com.paytm.utility.h r0 = new com.paytm.utility.h
            androidx.fragment.app.FragmentActivity r1 = r29.getActivity()
            r0.<init>(r1)
            java.lang.String r1 = "utility_hide_title"
            r0.setTitle(r1)
            android.content.Context r1 = r8.f51126g
            android.content.res.Resources r1 = r1.getResources()
            int r2 = net.one97.paytm.wallet.R.string.p2mnoinstrumentpresent
            java.lang.String r1 = r1.getString(r2)
            r0.a(r1)
            r1 = -3
            android.content.Context r2 = r8.f51126g
            int r3 = net.one97.paytm.wallet.R.string.p2mok
            java.lang.String r2 = r2.getString(r3)
            net.one97.paytm.p2mNewDesign.d.g$26 r3 = new net.one97.paytm.p2mNewDesign.d.g$26
            r3.<init>(r0)
            r0.a(r1, r2, r3)
            r0.show()
        L_0x0ac4:
            r29.O()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r0 = r0.J
            if (r0 == 0) goto L_0x0aec
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r0 = r0.H
            if (r0 == 0) goto L_0x0aec
            java.lang.String r0 = r29.ae()
            boolean r0 = r8.k((java.lang.String) r0)
            if (r0 == 0) goto L_0x0aec
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r0.L = r7
            net.one97.paytm.p2mNewDesign.j.b r0 = r8.f51127h
            r0.c()
        L_0x0aec:
            return
        L_0x0aed:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.wallet.CJRCashWallet
            if (r2 == 0) goto L_0x0d4c
            r2 = 0
            r8.bA = r2
            net.one97.paytm.p2mNewDesign.j.b r1 = r8.f51127h
            r1.b((boolean) r2)
            r29.V()
            r29.af()
            boolean r1 = r8.bl
            if (r1 == 0) goto L_0x0b0b
            r8.bA = r2
            net.one97.paytm.p2mNewDesign.j.b r0 = r8.f51127h
            r0.b((boolean) r2)
            return
        L_0x0b0b:
            net.one97.paytm.common.entity.wallet.CJRCashWallet r0 = (net.one97.paytm.common.entity.wallet.CJRCashWallet) r0
            boolean r1 = r8.aL
            if (r1 == 0) goto L_0x0b12
            return
        L_0x0b12:
            net.one97.paytm.common.entity.wallet.CJRCashWalletResponse r1 = r0.getResponse()
            if (r1 == 0) goto L_0x0d4b
            net.one97.paytm.common.entity.wallet.CJRCashWalletResponse r1 = r0.getResponse()
            double r1 = r1.getTotalBalance()
            net.one97.paytm.common.entity.wallet.CJRCashWalletResponse r0 = r0.getResponse()
            java.util.List r0 = r0.getSubWalletDetailList()
            java.util.Iterator r0 = r0.iterator()
            r5 = 0
        L_0x0b2e:
            boolean r9 = r0.hasNext()
            if (r9 == 0) goto L_0x0b59
            java.lang.Object r9 = r0.next()
            net.one97.paytm.common.entity.wallet.CJRSubWallet r9 = (net.one97.paytm.common.entity.wallet.CJRSubWallet) r9
            java.lang.String r10 = r9.getSubWalletName()
            java.lang.String r11 = "GIFT_VOUCHER"
            boolean r10 = r11.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x0b56
            double r10 = r9.getBalance()
            r12 = 0
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x0b2e
            double r9 = r9.getBalance()
            double r5 = r5 + r9
            goto L_0x0b2e
        L_0x0b56:
            r12 = 0
            goto L_0x0b2e
        L_0x0b59:
            r12 = 0
            int r0 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x0b70
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            android.content.Context r9 = r8.f51126g
            java.lang.Double r10 = java.lang.Double.valueOf(r1)
            java.lang.Double r11 = java.lang.Double.valueOf(r5)
            r0.b(r9, r10, r11)
        L_0x0b70:
            double r9 = r1 - r5
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            android.content.Context r11 = r8.f51126g
            java.lang.Double r12 = java.lang.Double.valueOf(r1)
            java.lang.Double r5 = java.lang.Double.valueOf(r5)
            r0.b(r11, r12, r5)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            android.content.Context r5 = r8.f51126g
            java.lang.Double r6 = java.lang.Double.valueOf(r1)
            java.lang.Double r9 = java.lang.Double.valueOf(r9)
            r0.a((android.content.Context) r5, (java.lang.Double) r6, (java.lang.Double) r9)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.f13087c
            r5 = 0
            r0.setWalletAPIFAIL(r5)
            boolean r0 = r8.ay
            if (r0 == 0) goto L_0x0bab
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.f13087c
            r0.setAllPaymodeFetched(r7)
        L_0x0bab:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r8.n
            if (r0 == 0) goto L_0x0bbe
            boolean r0 = r0.isPgEnabled()
            if (r0 != 0) goto L_0x0bbe
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.f13087c
            r0.setAllPaymodeFetched(r7)
        L_0x0bbe:
            java.lang.String r0 = java.lang.Double.toString(r1)
            r8.q = r0
            androidx.fragment.app.FragmentActivity r0 = r29.getActivity()
            net.one97.paytm.wallet.utility.a.a((android.content.Context) r0, (double) r1)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            if (r0 == 0) goto L_0x0cc5
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0cc5
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.f13087c
            if (r0 == 0) goto L_0x0cc5
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.f13087c
            java.lang.String r0 = r0.getBalance()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0cc5
            java.lang.String r0 = r29.ae()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0cb8
            java.lang.String r1 = "0"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0c0f
            goto L_0x0cb8
        L_0x0c0f:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.f13087c
            java.lang.String r0 = r0.getTotalBalance()
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            double r0 = r0.doubleValue()
            java.lang.String r2 = r29.ae()
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            double r4 = r2.doubleValue()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0c86
            java.lang.String r0 = r29.ae()
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            double r0 = r0.doubleValue()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.f13087c
            java.lang.String r2 = r2.getTotalBalance()
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            double r2 = r2.doubleValue()
            double r0 = r0 - r2
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0c60
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0c60
            double r0 = java.lang.Math.ceil(r0)
        L_0x0c60:
            java.text.DecimalFormat r2 = new java.text.DecimalFormat
            java.lang.String r3 = "#0.00"
            r2.<init>(r3)
            java.lang.String r0 = r2.format(r0)
            java.lang.String r0 = r8.h((java.lang.String) r0)
            android.widget.TextView r1 = r8.Y
            android.content.Context r2 = r8.f51126g
            int r3 = net.one97.paytm.wallet.R.string.add_money_to_pay
            java.lang.String r2 = r2.getString(r3)
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r4 = 0
            r3[r4] = r0
            java.lang.String r0 = java.lang.String.format(r2, r3)
            r1.setText(r0)
            goto L_0x0cc5
        L_0x0c86:
            android.widget.TextView r0 = r8.Y
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = r8.f51126g
            int r4 = net.one97.paytm.wallet.R.string.pay
            java.lang.String r2 = r2.getString(r4)
            r1.append(r2)
            r1.append(r3)
            android.content.Context r2 = r8.f51126g
            int r4 = net.one97.paytm.wallet.R.string.rs_symbol
            java.lang.String r2 = r2.getString(r4)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = r29.ae()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            goto L_0x0cc5
        L_0x0cb8:
            android.widget.TextView r0 = r8.Y
            android.content.Context r1 = r8.f51126g
            int r2 = net.one97.paytm.wallet.R.string.pay
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
        L_0x0cc5:
            r1 = 0
            r8.T = r1
            r8.aL = r7
            net.one97.paytm.p2mNewDesign.j.b r0 = r8.f51127h
            if (r0 != 0) goto L_0x0d0f
            net.one97.paytm.p2mNewDesign.j.b r0 = new net.one97.paytm.p2mNewDesign.j.b
            r0.<init>()
            r8.f51127h = r0
            net.one97.paytm.p2mNewDesign.j.b r1 = r8.f51127h
            r1.f13379g = r8
            android.widget.LinearLayout r0 = r8.al
            android.app.Activity r2 = r8.f51125f
            java.lang.String r4 = r29.ae()
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r3 = r8.n
            java.lang.String r5 = r3.getMappingId()
            boolean r6 = r29.K()
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r3 = r8.n
            boolean r7 = r3.isPgEnabled()
            r3 = r29
            android.view.View r1 = r1.a(r2, r3, r4, r5, r6, r7)
            r0.addView(r1)
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r8.n
            boolean r0 = r0.isPgEnabled()
            if (r0 == 0) goto L_0x0d4b
            boolean r0 = r8.ax
            if (r0 != 0) goto L_0x0d4b
            boolean r0 = r8.ay
            if (r0 != 0) goto L_0x0d4b
            r1 = 0
            r8.b((boolean) r1)
            return
        L_0x0d0f:
            android.widget.LinearLayout r0 = r8.al
            r0.removeAllViews()
            android.widget.LinearLayout r0 = r8.al
            net.one97.paytm.p2mNewDesign.j.b r1 = r8.f51127h
            android.app.Activity r2 = r8.f51125f
            java.lang.String r4 = r29.ae()
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r3 = r8.n
            java.lang.String r5 = r3.getMappingId()
            boolean r6 = r29.K()
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r3 = r8.n
            boolean r7 = r3.isPgEnabled()
            r3 = r29
            android.view.View r1 = r1.a(r2, r3, r4, r5, r6, r7)
            r0.addView(r1)
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r8.n
            boolean r0 = r0.isPgEnabled()
            if (r0 == 0) goto L_0x0d4b
            boolean r0 = r8.ax
            if (r0 != 0) goto L_0x0d4b
            boolean r0 = r8.ay
            if (r0 != 0) goto L_0x0d4b
            r1 = 0
            r8.b((boolean) r1)
        L_0x0d4b:
            return
        L_0x0d4c:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.paymentsbank.AccountBalanceModel
            if (r2 == 0) goto L_0x0d74
            r8.G = r7
            net.one97.paytm.common.entity.paymentsbank.AccountBalanceModel r0 = (net.one97.paytm.common.entity.paymentsbank.AccountBalanceModel) r0
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            android.content.Context r2 = r8.f51126g
            double r3 = r0.getEffectiveBalance()
            r1.a((android.content.Context) r2, (double) r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.j
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r1.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0)
            java.lang.String r1 = "updateSelection"
            r8.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0, (java.lang.String) r1)
            return
        L_0x0d74:
            boolean r2 = r0 instanceof net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse
            java.lang.String r3 = "UPI"
            if (r2 == 0) goto L_0x0f11
            r1 = r0
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse r1 = (net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse) r1
            if (r1 != 0) goto L_0x0d80
            return
        L_0x0d80:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.OneClickInfo r2 = r2.getOneClickInfo()
            if (r2 == 0) goto L_0x0dbc
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f
            r2.<init>()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r4 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.OneClickInfo r4 = r4.getOneClickInfo()
            java.lang.String r15 = r2.a((java.lang.Object) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.bi
            if (r2 == 0) goto L_0x0dbc
            net.one97.paytm.wallet.communicator.a r9 = net.one97.paytm.wallet.communicator.b.c()
            android.content.Context r10 = r8.f51126g
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.bi
            java.lang.String r11 = r2.getCardFirstSixDigit()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r8.bi
            java.lang.String r12 = r2.getCardLastFourDigit()
            android.content.Context r2 = r8.f51126g
            java.lang.String r14 = com.paytm.utility.b.n((android.content.Context) r2)
            java.lang.String r13 = ""
            r9.setEnrollmentData(r10, r11, r12, r13, r14, r15)
        L_0x0dbc:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            if (r2 == 0) goto L_0x0e87
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getMID()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0e87
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getORDERID()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0e87
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r0 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.RetryInfo r0 = r0.getRetryInfo()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a((net.one97.paytm.p2mNewDesign.entity.RetryInfo) r0)
            if (r2 == 0) goto L_0x0e43
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getPAYMENTMODE()
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0e43
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r1.E = r7
            androidx.fragment.app.FragmentActivity r1 = r29.getActivity()
            if (r1 == 0) goto L_0x0e42
            androidx.fragment.app.FragmentActivity r1 = r29.getActivity()
            boolean r1 = r1.isFinishing()
            if (r1 != 0) goto L_0x0e42
            net.one97.paytm.p2mNewDesign.d.h r1 = r8.bq
            if (r1 == 0) goto L_0x0e2a
            r1.dismissAllowingStateLoss()
        L_0x0e2a:
            net.one97.paytm.p2mNewDesign.d.h r0 = net.one97.paytm.p2mNewDesign.d.h.a(r0, r8)
            r8.bq = r0
            androidx.fragment.app.j r0 = r29.getChildFragmentManager()
            androidx.fragment.app.q r0 = r0.a()
            net.one97.paytm.p2mNewDesign.d.h r1 = r8.bq
            java.lang.String r2 = "PAYMENT_RETRY_BOTTOMSHEET"
            r0.a((androidx.fragment.app.Fragment) r1, (java.lang.String) r2)
            r0.c()
        L_0x0e42:
            return
        L_0x0e43:
            net.one97.paytm.p2mNewDesign.d.h r0 = r8.bq
            if (r0 == 0) goto L_0x0e4a
            r0.dismissAllowingStateLoss()
        L_0x0e4a:
            net.one97.paytm.wallet.i.a.c r0 = r8.bk
            if (r0 == 0) goto L_0x0e5f
            boolean r0 = r0.isAdded()
            if (r0 == 0) goto L_0x0e5f
            net.one97.paytm.wallet.i.a.c r0 = r8.bk
            net.one97.paytm.p2mNewDesign.d.-$$Lambda$g$tpkYIf6p9CGq9zy6BLgqk5y5tHQ r2 = new net.one97.paytm.p2mNewDesign.d.-$$Lambda$g$tpkYIf6p9CGq9zy6BLgqk5y5tHQ
            r2.<init>(r1)
            r3 = 0
            r0.a((boolean) r3, (net.one97.paytm.wallet.i.a) r2)
        L_0x0e5f:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r0 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r0 = r0.getTxnInfo()
            java.lang.String r0 = r0.getMID()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r2 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r2 = r2.getTxnInfo()
            java.lang.String r2 = r2.getORDERID()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r3 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r3 = r3.getTxnInfo()
            java.lang.String r3 = r3.getTXNAMOUNT()
            r8.a((java.lang.String) r0, (java.lang.String) r2, (java.lang.String) r3, (net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse) r1)
            return
        L_0x0e87:
            java.lang.String r2 = new java.lang.String
            com.paytm.network.model.NetworkResponse r0 = r30.getNetworkResponse()
            byte[] r0 = r0.data
            r2.<init>(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0f10
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r0 = r1.getBody()
            if (r0 == 0) goto L_0x0f10
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r0 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.BankForm r0 = r0.getBankForm()
            if (r0 != 0) goto L_0x0ea9
            goto L_0x0f10
        L_0x0ea9:
            android.content.Context r0 = r8.f51126g
            boolean r0 = net.one97.paytm.wallet.utility.a.i((android.content.Context) r0)
            if (r0 == 0) goto L_0x0ee6
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r0 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.BankForm r0 = r0.getBankForm()
            java.lang.String r0 = r0.getPageType()
            java.lang.String r3 = "direct"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0ee6
            net.one97.paytm.wallet.i.a.c r0 = r8.bk
            if (r0 == 0) goto L_0x0eda
            boolean r0 = r0.isVisible()
            if (r0 == 0) goto L_0x0eda
            net.one97.paytm.wallet.i.a.c r0 = r8.bk
            net.one97.paytm.p2mNewDesign.d.-$$Lambda$g$qHiQVMgAMdwfX9gmc-qOyxYORSI r2 = new net.one97.paytm.p2mNewDesign.d.-$$Lambda$g$qHiQVMgAMdwfX9gmc-qOyxYORSI
            r2.<init>(r1)
            r0.a((boolean) r7, (net.one97.paytm.wallet.i.a) r2)
            return
        L_0x0eda:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r0 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.BankForm r0 = r0.getBankForm()
            r8.a((net.one97.paytm.p2mNewDesign.entity.BankForm) r0)
            return
        L_0x0ee6:
            net.one97.paytm.wallet.i.a.c r0 = r8.bk
            if (r0 == 0) goto L_0x0efb
            boolean r0 = r0.isVisible()
            if (r0 == 0) goto L_0x0efb
            net.one97.paytm.wallet.i.a.c r0 = r8.bk
            net.one97.paytm.p2mNewDesign.d.-$$Lambda$g$1eoMuNf1H0-jLhey4uxlTZAvJ78 r3 = new net.one97.paytm.p2mNewDesign.d.-$$Lambda$g$1eoMuNf1H0-jLhey4uxlTZAvJ78
            r3.<init>(r1, r2)
            r0.a((boolean) r7, (net.one97.paytm.wallet.i.a) r3)
            return
        L_0x0efb:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r1.getBody()
            net.one97.paytm.p2mNewDesign.entity.BankForm r1 = r1.getBankForm()
            net.one97.paytm.p2mNewDesign.entity.RedirectForm r1 = r1.getRedirectForm()
            r8.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0, (net.one97.paytm.p2mNewDesign.entity.RedirectForm) r1)
        L_0x0f10:
            return
        L_0x0f11:
            boolean r2 = r0 instanceof net.one97.paytm.common.entity.offline_pg.PCFDetails.CJRPCFDetails
            if (r2 == 0) goto L_0x10f3
            net.one97.paytm.common.entity.offline_pg.PCFDetails.CJRPCFDetails r0 = (net.one97.paytm.common.entity.offline_pg.PCFDetails.CJRPCFDetails) r0
            net.one97.paytm.p2mNewDesign.models.BodyV2 r2 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.ResultInfoV2 r2 = r2.getResultInfo()
            java.lang.String r2 = r2.getResultStatus()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x106c
            net.one97.paytm.p2mNewDesign.models.BodyV2 r2 = r0.getBody()
            net.one97.paytm.p2mNewDesign.models.ResultInfoV2 r2 = r2.getResultInfo()
            java.lang.String r2 = r2.getResultStatus()
            java.lang.String r5 = "S"
            boolean r2 = r2.equalsIgnoreCase(r5)
            if (r2 == 0) goto L_0x106c
            net.one97.paytm.p2mNewDesign.models.BodyV2 r2 = r0.getBody()
            if (r2 == 0) goto L_0x10f2
            net.one97.paytm.p2mNewDesign.models.BodyV2 r2 = r0.getBody()
            java.lang.Object r2 = r2.getConsultDetails()
            if (r2 == 0) goto L_0x10f2
            com.google.gsonhtcfix.f r2 = new com.google.gsonhtcfix.f
            r2.<init>()
            net.one97.paytm.p2mNewDesign.models.BodyV2 r0 = r0.getBody()
            java.lang.Object r0 = r0.getConsultDetails()
            java.lang.String r0 = r2.a((java.lang.Object) r0)
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x1063 }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r0 = r0.getPayMode()     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r5 = "emi"
            boolean r5 = r0.equalsIgnoreCase(r5)     // Catch:{ JSONException -> 0x1063 }
            if (r5 == 0) goto L_0x0f77
            java.lang.String r0 = "CREDIT_CARD"
        L_0x0f77:
            org.json.JSONObject r0 = r2.getJSONObject(r0)     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r2 = "baseTransactionAmount"
            org.json.JSONObject r2 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r5 = "totalConvenienceCharges"
            org.json.JSONObject r5 = r0.getJSONObject(r5)     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r6 = "totalTransactionAmount"
            org.json.JSONObject r0 = r0.getJSONObject(r6)     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r9 = r2.getString(r1)     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r10 = r5.getString(r1)     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r11 = r0.getString(r1)     // Catch:{ JSONException -> 0x1063 }
            java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch:{ JSONException -> 0x1063 }
            r0.<init>(r11)     // Catch:{ JSONException -> 0x1063 }
            r8.be = r0     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r8.n     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r0 = r0.getComment()     // Catch:{ JSONException -> 0x1063 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x1063 }
            if (r0 == 0) goto L_0x0fbf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x1063 }
            r0.<init>()     // Catch:{ JSONException -> 0x1063 }
            android.widget.EditText r1 = r8.L     // Catch:{ JSONException -> 0x1063 }
            android.text.Editable r1 = r1.getText()     // Catch:{ JSONException -> 0x1063 }
            r0.append(r1)     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x1063 }
            goto L_0x0fc5
        L_0x0fbf:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r8.n     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r0 = r0.getComment()     // Catch:{ JSONException -> 0x1063 }
        L_0x0fc5:
            double r1 = java.lang.Double.parseDouble(r10)     // Catch:{ JSONException -> 0x1063 }
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch:{ JSONException -> 0x1063 }
            double r5 = r1.doubleValue()     // Catch:{ JSONException -> 0x1063 }
            r12 = 0
            int r2 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x1031
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r1.n     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r1 = r1.getPayMode()     // Catch:{ JSONException -> 0x1063 }
            boolean r1 = r1.equalsIgnoreCase(r4)     // Catch:{ JSONException -> 0x1063 }
            if (r1 == 0) goto L_0x0ff5
            java.lang.Double r1 = java.lang.Double.valueOf(r9)     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r2 = r8.n     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r2 = r2.getMobileNo()     // Catch:{ JSONException -> 0x1063 }
            r8.a((java.lang.Double) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ JSONException -> 0x1063 }
            return
        L_0x0ff5:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r0 = r0.getPayMode()     // Catch:{ JSONException -> 0x1063 }
            boolean r0 = r3.equalsIgnoreCase(r0)     // Catch:{ JSONException -> 0x1063 }
            if (r0 == 0) goto L_0x1013
            java.lang.String r0 = r8.by     // Catch:{ JSONException -> 0x1063 }
            if (r0 == 0) goto L_0x1062
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n     // Catch:{ JSONException -> 0x1063 }
            r8.b((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0)     // Catch:{ JSONException -> 0x1063 }
            return
        L_0x1013:
            java.lang.String r0 = r8.by     // Catch:{ JSONException -> 0x1063 }
            if (r0 == 0) goto L_0x1023
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r1 = r8.by     // Catch:{ JSONException -> 0x1063 }
            r8.b((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0, (java.lang.String) r1)     // Catch:{ JSONException -> 0x1063 }
            return
        L_0x1023:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r1 = r29.ae()     // Catch:{ JSONException -> 0x1063 }
            r8.b((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0, (java.lang.String) r1)     // Catch:{ JSONException -> 0x1063 }
            return
        L_0x1031:
            double r2 = r1.doubleValue()     // Catch:{ JSONException -> 0x1063 }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x1062
            r8.bf = r7     // Catch:{ JSONException -> 0x1063 }
            r8.bg = r1     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.wallet.g.a$a r1 = net.one97.paytm.wallet.g.a.f70365a     // Catch:{ JSONException -> 0x1063 }
            android.content.Context r12 = r8.f51126g     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r13 = r29.S()     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.p2mNewDesign.d.g$10 r14 = new net.one97.paytm.p2mNewDesign.d.g$10     // Catch:{ JSONException -> 0x1063 }
            r14.<init>(r9, r0, r11)     // Catch:{ JSONException -> 0x1063 }
            net.one97.paytm.wallet.g.a r0 = net.one97.paytm.wallet.g.a.C1418a.a(r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x1063 }
            androidx.fragment.app.FragmentActivity r1 = r29.getActivity()     // Catch:{ JSONException -> 0x1063 }
            androidx.fragment.app.j r1 = r1.getSupportFragmentManager()     // Catch:{ JSONException -> 0x1063 }
            java.lang.String r2 = "PCF_BOTTOMSHEET"
            r0.show((androidx.fragment.app.j) r1, (java.lang.String) r2)     // Catch:{ JSONException -> 0x1063 }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ JSONException -> 0x1063 }
            r8.a((java.lang.Boolean) r0)     // Catch:{ JSONException -> 0x1063 }
        L_0x1062:
            return
        L_0x1063:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.paytm.utility.q.d(r0)
            return
        L_0x106c:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x10b7
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r8.n
            java.lang.String r0 = r0.getComment()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x109b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.widget.EditText r1 = r8.L
            android.text.Editable r1 = r1.getText()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x10a1
        L_0x109b:
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r0 = r8.n
            java.lang.String r0 = r0.getComment()
        L_0x10a1:
            java.lang.String r1 = r29.ae()
            double r1 = java.lang.Double.parseDouble(r1)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            net.one97.paytm.common.entity.wallet.CJRQRScanResultModel r2 = r8.n
            java.lang.String r2 = r2.getMobileNo()
            r8.a((java.lang.Double) r1, (java.lang.String) r2, (java.lang.String) r0)
            return
        L_0x10b7:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r0 = r0.getPayMode()
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x10d5
            java.lang.String r0 = r8.by
            if (r0 == 0) goto L_0x10f2
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            r8.b((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0)
            return
        L_0x10d5:
            java.lang.String r0 = r8.by
            if (r0 == 0) goto L_0x10e5
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r1 = r8.by
            r8.b((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0, (java.lang.String) r1)
            return
        L_0x10e5:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.n
            java.lang.String r1 = r29.ae()
            r8.b((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r0, (java.lang.String) r1)
        L_0x10f2:
            return
        L_0x10f3:
            r29.af()
            r29.V()
            r29.A()
            r8.b((boolean) r7)
        L_0x10ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.g.a(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(CJRProcessTranscationResponse cJRProcessTranscationResponse) {
        a(cJRProcessTranscationResponse.getBody().getTxnInfo().getMID(), cJRProcessTranscationResponse.getBody().getTxnInfo().getORDERID(), cJRProcessTranscationResponse.getBody().getTxnInfo().getTXNAMOUNT(), cJRProcessTranscationResponse);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRProcessTranscationResponse cJRProcessTranscationResponse) {
        a(cJRProcessTranscationResponse.getBody().getBankForm());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRProcessTranscationResponse cJRProcessTranscationResponse, String str) {
        a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, cJRProcessTranscationResponse.getBody().getBankForm().getRedirectForm());
    }

    /* access modifiers changed from: private */
    public void Y() {
        net.one97.paytm.wallet.dialog.a.a aVar = new net.one97.paytm.wallet.dialog.a.a(this.f51125f, R.style.Theme_ScanFirstTimeDialog, S(), as);
        aVar.setCanceledOnTouchOutside(false);
        aVar.show();
    }

    private void a(BankForm bankForm) {
        String str;
        this.bK = ae();
        HashMap hashMap = new HashMap();
        hashMap.put("TXN_AMOUNT", ae());
        hashMap.put("name", S());
        if (TextUtils.isEmpty(this.n.getComment())) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.L.getText());
            str = sb.toString();
        } else {
            str = this.n.getComment();
        }
        hashMap.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, str);
        hashMap.put("phone_no", this.n.getMobileNo());
        hashMap.put("mid", this.n.getMappingId());
        Intent intent = new Intent(this.f51126g, AJRNativeOTPActivity.class);
        intent.putExtra("bankForm", bankForm);
        intent.putExtra("oneClickInfoForSCP", this.bh);
        intent.putExtra("data", hashMap);
        startActivityForResult(intent, 1001);
    }

    private void Z() {
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().m != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().m.size() > 0) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().m.get(0));
            a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "updateSelection");
        }
    }

    private void aa() {
        if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().r()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    g.this.ab();
                }
            }, 500);
        }
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.DEBIT) != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.DEBIT).size() > 0 && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(SDKConstants.DEBIT)) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.DEBIT).get(0));
                a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "updateSelection");
                ai();
            } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.CREDIT) != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.CREDIT).size() > 0 && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(SDKConstants.CREDIT)) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.CREDIT).get(0));
                a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "updateSelection");
                ai();
            }
        }
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
            ad();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u() != false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ab() {
        /*
            r9 = this;
            net.one97.paytm.wallet.newdesign.utils.CustomDialog.initListener(r9)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = r0.s()
            if (r0 == 0) goto L_0x0017
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = r0.n()
            if (r0 != 0) goto L_0x002a
        L_0x0017:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = r0.t()
            if (r0 == 0) goto L_0x0094
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u()
            if (r0 == 0) goto L_0x0094
        L_0x002a:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.j
            java.lang.String r0 = r0.getBalance()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "Insufficient balance"
            if (r0 == 0) goto L_0x0043
            java.lang.String r1 = "Balance error"
            java.lang.String r0 = "Balance could not be loaded, please try after some time."
        L_0x0040:
            r4 = r0
            r3 = r1
            goto L_0x007e
        L_0x0043:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u()
            if (r0 == 0) goto L_0x005f
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = r0.t()
            if (r0 == 0) goto L_0x005f
            android.content.Context r0 = r9.f51126g
            int r2 = net.one97.paytm.wallet.R.string.insufficient_balance_payment_postpaid
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0040
        L_0x005f:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = r0.n()
            if (r0 == 0) goto L_0x007c
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r0 = r0.s()
            if (r0 == 0) goto L_0x007c
            android.content.Context r0 = r9.f51126g
            int r2 = net.one97.paytm.wallet.R.string.insufficient_balance_payment_bank
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0040
        L_0x007c:
            r0 = 0
            goto L_0x0040
        L_0x007e:
            android.content.Context r2 = r9.f51126g
            r5 = 0
            int r0 = net.one97.paytm.wallet.R.string.try_again_lower_amount
            java.lang.String r6 = r2.getString(r0)
            android.content.Context r0 = r9.f51126g
            int r1 = net.one97.paytm.wallet.R.string.cancel
            java.lang.String r7 = r0.getString(r1)
            r8 = r9
            net.one97.paytm.wallet.newdesign.utils.CustomDialog.showAlert(r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x0094:
            android.content.Context r0 = r9.f51126g
            java.lang.String r1 = "Error"
            java.lang.String r2 = "Merchant doesn't have any other pay methods. Please try again later."
            net.one97.paytm.wallet.newdesign.utils.CustomDialog.showErrorDialog(r0, r1, r2, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.g.ab():void");
    }

    private void j(String str) {
        Toast.makeText(getActivity(), str, 0).show();
    }

    private void ac() {
        if (!this.n.isPgEnabled()) {
            b(true);
            return;
        }
        if (com.paytm.utility.b.c(this.f51126g)) {
            new aq().a(getActivity(), this);
        }
        LiveData<net.one97.paytm.network.f> a2 = a.a((Context) this.f51125f, this.n, ae(), this.bB ? T() : null);
        if (a2 != null) {
            a2.observeForever(new z() {
                public final void onChanged(Object obj) {
                    g.this.b((net.one97.paytm.network.f) obj);
                }
            });
        }
    }

    private void ad() {
        InstrumentInfo instrumentInfo = new InstrumentInfo();
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
            Iterator<PaymentModesV2> it2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                PaymentModesV2 next = it2.next();
                if (next == null || !next.getPaymentMode().equalsIgnoreCase(SDKConstants.DEBIT)) {
                    if (next == null || !next.getPaymentMode().equalsIgnoreCase(SDKConstants.CREDIT)) {
                        if (next == null || !next.getPaymentMode().equalsIgnoreCase("NET_BANKING")) {
                            if (next != null && next.getPaymentMode().equalsIgnoreCase("UPI")) {
                                if (next.isDisabled() == null || !next.isDisabled().getStatus().booleanValue()) {
                                    instrumentInfo.setDisplayPrimaryInfo(this.f51126g.getString(R.string.upi));
                                    instrumentInfo.setPayMode("UPI");
                                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(instrumentInfo);
                                }
                            }
                        } else if (next.isDisabled() == null || !next.isDisabled().getStatus().booleanValue()) {
                        }
                    } else if (next.isDisabled() == null || !next.isDisabled().getStatus().booleanValue()) {
                        instrumentInfo.setDisplayPrimaryInfo(this.f51126g.getString(R.string.credit_card));
                        instrumentInfo.setPayMode(SDKConstants.CREDIT);
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(instrumentInfo);
                    }
                } else if (next.isDisabled() == null || !next.isDisabled().getStatus().booleanValue()) {
                    instrumentInfo.setDisplayPrimaryInfo(this.f51126g.getString(R.string.debit_card));
                    instrumentInfo.setPayMode(SDKConstants.DEBIT);
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(instrumentInfo);
                }
            }
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(false) != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(false).size() > 0) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(false).get(0));
            }
        }
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
            ab();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z2;
        net.one97.paytm.p2mNewDesign.e.a c2;
        String str;
        String str2;
        String str3;
        String str4;
        int i4 = i2;
        int i5 = i3;
        Intent intent2 = intent;
        super.onActivityResult(i2, i3, intent);
        if (i5 == -1) {
            if (i4 == 145 && intent2 != null) {
                if (intent2.getBooleanExtra("isBackToCashier", true)) {
                    RetryInfo retryInfo = (RetryInfo) intent2.getSerializableExtra(GAConstants.ACTION.RETRY);
                    c(false);
                    if (retryInfo != null && !TextUtils.isEmpty(retryInfo.getBlockerMessage())) {
                        this.f51127h.f(retryInfo.getBlockerMessage());
                    }
                } else {
                    RetryInfo retryInfo2 = (RetryInfo) intent2.getSerializableExtra(GAConstants.ACTION.RETRY);
                    if (retryInfo2 == null || TextUtils.isEmpty(retryInfo2.getBlockerMessage())) {
                        this.O.performClick();
                    } else {
                        c(false);
                        this.f51127h.f(retryInfo2.getBlockerMessage());
                    }
                }
            }
            if (i4 != 2) {
                String str5 = "";
                if (i4 == 1001) {
                    a(Boolean.FALSE);
                    A();
                    if (intent2 != null) {
                        boolean booleanExtra = intent2.getBooleanExtra("is_otp_limit_breach", false);
                        String stringExtra = intent2.hasExtra(BaseDialogFragment.ERROR_MESSAGE) ? intent2.getStringExtra(BaseDialogFragment.ERROR_MESSAGE) : null;
                        if (intent2.getBooleanExtra("is_select_another_payment_mode", false)) {
                            this.bJ = true;
                            this.bL = booleanExtra;
                            if (!TextUtils.isEmpty(stringExtra)) {
                                a(stringExtra, false, false);
                                return;
                            }
                            return;
                        }
                    }
                    String S2 = S();
                    String mobileNo = this.n.getMobileNo();
                    String ae2 = ae();
                    if (TextUtils.isEmpty(this.n.getComment())) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.L.getText());
                        str = sb.toString();
                    } else {
                        str = this.n.getComment();
                    }
                    Intent h2 = net.one97.paytm.wallet.utility.a.h((Context) this.f51125f);
                    h2.putExtra("key_via", "via_qr");
                    h2.putExtra("phone_no", mobileNo);
                    if (intent2 != null) {
                        h2.putExtra("pay_response", intent2.getStringExtra("extra_data"));
                    }
                    h2.putExtra("name", S2);
                    h2.putExtra("amount", String.valueOf(ae2));
                    h2.putExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL, String.valueOf(str));
                    h2.putExtra("is_from_mobile_number", this.aC);
                    h2.putExtra("qrScanTime", this.bb);
                    h2.putExtra("suggested_instrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().C);
                    h2.putExtra("used_instrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode());
                    h2.putExtra("is_from_recent", this.bc);
                    h2.putExtra("isAutoFlashTxn", this.bF);
                    h2.putExtra("suggestedInstrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().C);
                    h2.putExtra("isSingleAPI", this.bd);
                    h2.putExtra("is_link_based_payment", this.aO);
                    h2.putExtra("pay_mode_type", this.aR);
                    h2.putExtra("pay_mode_load_time", this.aS);
                    h2.putExtra("is_amt_already_present", !TextUtils.isEmpty(this.n.getTxnAmount()));
                    h2.putExtra("is_from_deeplink", this.bE);
                    h2.putExtra("launchFrom", this.bQ);
                    h2.putExtra("is_from_app_evoke", this.aD);
                    CJRQRScanResultModel cJRQRScanResultModel = this.n;
                    if (!(cJRQRScanResultModel == null || cJRQRScanResultModel.getJson() == null)) {
                        h2.putExtra("scan_result", this.n.getJson().toString());
                    }
                    if (!this.bf || this.bg.doubleValue() <= 0.0d) {
                        h2.putExtra("is_pcf", true);
                    } else {
                        h2.putExtra("is_pcf", true);
                        h2.putExtra("pcf_amount", this.bg);
                    }
                    if (this.aE != null) {
                        z();
                        h2.putExtras(this.aE);
                    }
                    h2.putExtra("is_static_qr_code", m());
                    InstrumentInfo instrumentInfo = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
                    if (instrumentInfo != null && !TextUtils.isEmpty(instrumentInfo.getPayMode())) {
                        String payMode = instrumentInfo.getPayMode();
                        if (payMode.equalsIgnoreCase("UPI")) {
                            str4 = instrumentInfo.getAccountNumber();
                        } else if (payMode.equalsIgnoreCase(SDKConstants.DEBIT)) {
                            String paymentDetails = instrumentInfo.getPaymentDetails();
                            str4 = (TextUtils.isEmpty(paymentDetails) || !paymentDetails.contains("||")) ? null : paymentDetails.split("\\|")[0];
                            payMode = "SAVED_DC";
                        } else if (payMode.equalsIgnoreCase(SDKConstants.CREDIT)) {
                            String paymentDetails2 = instrumentInfo.getPaymentDetails();
                            str4 = (TextUtils.isEmpty(paymentDetails2) || !paymentDetails2.contains("||")) ? null : paymentDetails2.split("\\|")[0];
                            payMode = "SAVED_CC";
                        } else {
                            str4 = instrumentInfo.getPaymentDetails();
                        }
                        h2.putExtra("pay_mode", payMode);
                        h2.putExtra("unique_identifier", str4);
                    }
                    String str6 = StringSet.user.equalsIgnoreCase(this.n.getPayeeType()) ? "send" : "pay";
                    h2.putExtra("paymentMode", "p2m");
                    h2.putExtra("paymentType", str6);
                    if (!TextUtils.isEmpty(this.n.getTagLine())) {
                        h2.putExtra("tagline", this.n.getTagLine());
                    }
                    h2.putExtra("merchant_logo", this.n.getLogoURL());
                    h2.putExtra("is_offline_pg", true);
                    h2.putExtra("is_wallet_transection", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("PPI"));
                    h2.putExtra("is_postpaid", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("PAYTM_DIGITAL_CREDIT"));
                    h2.putExtra("is_upi", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("UPI"));
                    h2.putExtra("is_ppb_transaction", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals(SDKConstants.AI_KEY_PPBL));
                    h2.putExtra("is_card_transaction", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase(SDKConstants.DEBIT) || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT));
                    h2.putExtra("is_net_banking_transaction", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase("NET_BANKING"));
                    if ("emi".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
                        h2.putExtra("is_emi", true);
                        String string = this.f51126g.getResources().getString(R.string.emi_transcation);
                        Object[] objArr = new Object[3];
                        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan() == null) {
                            str2 = d();
                        } else {
                            str2 = net.one97.paytm.wallet.utility.a.a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan().f56921d.doubleValue());
                        }
                        objArr[0] = str2;
                        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan() == null) {
                            str3 = str5;
                        } else {
                            str3 = net.one97.paytm.wallet.utility.a.a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan().f56919b.doubleValue());
                        }
                        objArr[1] = str3;
                        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan() != null) {
                            str5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan().a();
                        }
                        objArr[2] = str5;
                        h2.putExtra("emi_message", String.format(string, objArr));
                    } else {
                        h2.putExtra("is_emi", false);
                    }
                    h2.setFlags(67108864);
                    if (this.aD) {
                        getActivity().startActivityForResult(h2, 2002);
                    } else {
                        startActivity(h2);
                        getActivity().setResult(-1);
                        getActivity().finish();
                    }
                } else if (i4 == 301) {
                    R();
                } else if (i4 == 1002) {
                    this.Q = intent2.getStringExtra("upi_mpin");
                    h hVar = this.bq;
                    if (hVar != null && hVar.isAdded()) {
                        this.bq.dismissAllowingStateLoss();
                    }
                    if (TextUtils.isEmpty(this.Q)) {
                        Toast.makeText(this.f51125f, "Please enter MPIN", 0).show();
                        a(Boolean.FALSE);
                    } else {
                        A();
                        if (this.by != null) {
                            b(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, this.by);
                        } else {
                            b(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, ae());
                        }
                    }
                } else if (i4 == 1000) {
                    if (i5 == -1) {
                        net.one97.paytm.p2mNewDesign.j.b bVar = this.f51127h;
                        net.one97.paytm.p2mNewDesign.e.a c3 = bVar.f13378f.c("NET_BANKING");
                        if (c3 != null) {
                            ((net.one97.paytm.p2mNewDesign.b.c) c3).g();
                        }
                        bVar.a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "updateSelection");
                    }
                } else if (i4 == 1012) {
                    if (i5 == -1 && (c2 = this.f51127h.f13378f.c("emi")) != null) {
                        net.one97.paytm.p2mNewDesign.b.b bVar2 = (net.one97.paytm.p2mNewDesign.b.b) c2;
                        bVar2.f13227a.e(false);
                        if (bVar2.f13228b != null) {
                            net.one97.paytm.p2mNewDesign.j.a aVar = bVar2.f13228b;
                            if (aVar.f13366c == null || (aVar.f13366c != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && TextUtils.isEmpty(aVar.f13366c.getBankCode()) && TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankCode()) && aVar.f13366c.getBankCode().equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankCode()))) {
                                ((TextView) aVar.f13365b.findViewById(R.id.tv_select_emi)).setVisibility(0);
                                if ((net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankCode().equalsIgnoreCase("bajajfn")) && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankCode().equalsIgnoreCase("bajaj") && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankCode().equalsIgnoreCase("BAJAJ FINSERV EMI CARD")) {
                                    if (SDKConstants.DEBIT.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getCardType())) {
                                        str5 = " Debit Card";
                                    } else if (SDKConstants.CREDIT.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getCardType())) {
                                        str5 = " Credit Card";
                                    }
                                }
                                ((TextView) aVar.f13365b.findViewById(R.id.tv_select_bank)).setText(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplaySecondaryInfo() + str5);
                                aVar.f13366c = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
                            } else {
                                aVar.f13367d.removeAllViews();
                                aVar.f13367d.setVisibility(8);
                                aVar.f13366c = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
                                if ((net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankCode().equalsIgnoreCase("bajajfn")) && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankCode().equalsIgnoreCase("bajaj") && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankCode().equalsIgnoreCase("BAJAJ FINSERV EMI CARD")) {
                                    if (SDKConstants.DEBIT.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getCardType())) {
                                        str5 = " Debit Card";
                                    } else if (SDKConstants.CREDIT.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getCardType())) {
                                        str5 = " Credit Card";
                                    }
                                }
                                ((TextView) aVar.f13365b.findViewById(R.id.tv_select_bank)).setText(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplaySecondaryInfo() + str5);
                                ((TextView) aVar.f13365b.findViewById(R.id.tv_select_emi)).setText("Select EMI");
                                ((TextView) aVar.f13365b.findViewById(R.id.tv_select_emi)).setVisibility(0);
                            }
                        }
                    }
                } else if (i4 == 352 || i4 == 144 || i4 == 304) {
                    au();
                } else if (i4 == 1139) {
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                    String virtualAddress = (f2.u == null || f2.u.size() <= 0) ? null : f2.u.get(0).getVirtualAddress();
                    if (!TextUtils.isEmpty(virtualAddress)) {
                        BankVpaCreationActivity.a((Fragment) this, (AccountProviderBody.AccountProvider) intent2.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER), virtualAddress, 304);
                    }
                } else if (i4 == 6576) {
                    if (intent2 != null && intent2.hasExtra("lat") && intent2.hasExtra("lng")) {
                        this.bn = intent2.getStringExtra("lat");
                        this.bo = intent2.getStringExtra("lng");
                        net.one97.paytm.f.b.a().f50402a.setLatitude(this.bn);
                        net.one97.paytm.f.b.a().f50402a.setLongitude(this.bo);
                        aw();
                    }
                } else if (i4 == 36865) {
                    this.bG.a(i4, i5);
                }
            }
        }
        if (i5 == 0) {
            if (i4 == 1001) {
                getActivity().finish();
            } else if (i4 == 1002) {
                c(false);
                h hVar2 = this.bq;
                if (hVar2 != null && hVar2.isAdded()) {
                    h hVar3 = this.bq;
                    hVar3.a(false);
                    hVar3.b(false);
                }
                Toast.makeText(this.f51125f, "Please enter MPIN", 0).show();
            } else if (i4 == 4) {
                getActivity().finish();
            } else if (i4 == 6576) {
                a(Boolean.FALSE);
            } else if (i4 == 36865) {
                g(false);
            }
        }
        if (i4 == 4 && com.paytm.utility.b.r(this.f51126g)) {
            aj();
            if (this.n.isPgEnabled()) {
                z2 = false;
                b(false);
            } else {
                z2 = false;
            }
            this.T = z2;
            if (com.paytm.utility.b.c(this.f51126g)) {
                as();
            } else {
                l();
            }
            RecentDataNetworkManager.initializeRecentPaymentsDownload(this.f51126g);
        }
    }

    /* access modifiers changed from: private */
    public String ae() {
        String str;
        try {
            if (TextUtils.isEmpty(this.n.getTxnAmount())) {
                if (this.k != null) {
                    if (!TextUtils.isEmpty(this.k.getText())) {
                        str = com.paytm.utility.b.Q(this.k.getText().toString().trim());
                    }
                }
                str = "0";
            } else {
                str = this.n.getTxnAmount();
            }
            String d2 = Double.toString(Double.valueOf(str).doubleValue());
            if (v.a(d2) || d2.equalsIgnoreCase("0.0") || d2.equalsIgnoreCase("0.00")) {
                return "0";
            }
            return d2;
        } catch (NumberFormatException unused) {
        }
    }

    public final void b(String str) {
        if (!getActivity().isFinishing()) {
            ProgressDialog progressDialog = this.z;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.z = new ProgressDialog(getContext());
                try {
                    this.z.setProgressStyle(0);
                    this.z.setMessage(str);
                    this.z.setCancelable(false);
                    this.z.setCanceledOnTouchOutside(false);
                    this.z.show();
                } catch (IllegalArgumentException e2) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e2));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private void af() {
        try {
            if (this.z != null && this.z.isShowing()) {
                this.z.dismiss();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public final void a(final net.one97.paytm.network.b bVar) {
        final Context context = getContext();
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.no_connection));
            builder.setMessage(context.getResources().getString(R.string.no_internet));
            builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    if (com.paytm.utility.b.c(context)) {
                        bVar.c();
                        g.this.b(context.getString(R.string.please_wait));
                        return;
                    }
                    g.this.a(bVar);
                }
            });
            builder.show();
        }
    }

    private void ag() {
        CJRQRScanResultModel cJRQRScanResultModel = this.n;
        if (cJRQRScanResultModel == null || TextUtils.isEmpty(cJRQRScanResultModel.getTxnAmount())) {
            this.k.setEnabled(true);
        } else {
            this.k.setEnabled(false);
        }
        if (this.bm) {
            this.k.setEnabled(this.bH);
        }
    }

    private void ah() {
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13086b = "";
        ag();
    }

    private void ai() {
        this.ag = false;
        this.S = false;
        this.k.clearFocus();
        this.L.clearFocus();
        this.aq.clearFocus();
        net.one97.paytm.p2mNewDesign.j.b bVar = this.f51127h;
        if (bVar == null) {
            this.f51127h = new net.one97.paytm.p2mNewDesign.j.b();
            net.one97.paytm.p2mNewDesign.j.b bVar2 = this.f51127h;
            bVar2.f13379g = this;
            this.al.addView(bVar2.a(this.f51125f, this, ae(), this.n.getMappingId(), K()));
            return;
        }
        bVar.b();
    }

    public void onDestroy() {
        super.onDestroy();
        net.one97.paytm.f.b.a().c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x016a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r22, java.lang.String r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            android.widget.TextView r3 = r0.ac
            r4 = 8
            if (r3 == 0) goto L_0x000f
            r3.setVisibility(r4)
        L_0x000f:
            java.lang.String r3 = "updateSelection"
            boolean r3 = r2.equalsIgnoreCase(r3)
            java.lang.String r5 = "Gold"
            java.lang.String r6 = "BALANCE"
            r7 = 1
            r8 = 0
            if (r3 == 0) goto L_0x0483
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            r3.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.f13087c
            if (r3 == 0) goto L_0x004e
            if (r1 == 0) goto L_0x004e
            java.lang.String r3 = r22.getPayMode()
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x004e
            boolean r3 = r0.T
            if (r3 == 0) goto L_0x004e
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.f13087c
            java.lang.String r3 = r3.getBalance()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x004e
            r0.T = r8
        L_0x004e:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r3 = r3.E()
            java.lang.String r9 = "0"
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.String r12 = "#0.00"
            java.lang.String r13 = " "
            r14 = 0
            if (r3 != 0) goto L_0x01d4
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.f13087c
            if (r3 == 0) goto L_0x01d4
            if (r1 == 0) goto L_0x01d4
            java.lang.String r3 = r22.getPayMode()
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x01d4
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.f13087c
            java.lang.String r3 = r3.getTotalBalance()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x01d4
            boolean r3 = r0.T
            if (r3 != 0) goto L_0x01d4
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.f13087c
            java.lang.String r3 = r3.getTotalBalance()
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r16 = r3.doubleValue()
            java.lang.String r3 = r21.ae()
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r18 = r3.doubleValue()
            int r3 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r3 >= 0) goto L_0x01d4
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.f13087c
            boolean r3 = r3.isWalletAPIFAIL()
            if (r3 != 0) goto L_0x01d4
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.f13087c
            boolean r3 = r3.isDummyWalletView()
            if (r3 != 0) goto L_0x01d4
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r3 = r3.H
            if (r3 == 0) goto L_0x018a
            java.lang.String r3 = r21.ae()
            java.lang.String r3 = com.paytm.utility.b.Q((java.lang.String) r3)
            double r16 = java.lang.Double.parseDouble(r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.f13087c
            java.lang.String r3 = r3.getTotalBalance()
            double r18 = java.lang.Double.parseDouble(r3)
            double r16 = r16 - r18
            int r3 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r3 <= 0) goto L_0x00f7
            int r3 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r3 >= 0) goto L_0x00f7
            double r16 = java.lang.Math.ceil(r16)
            r18 = r5
            goto L_0x00ff
        L_0x00f7:
            int r3 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            r18 = r5
            if (r3 >= 0) goto L_0x00ff
            r4 = r14
            goto L_0x0101
        L_0x00ff:
            r4 = r16
        L_0x0101:
            java.text.DecimalFormat r3 = new java.text.DecimalFormat
            r3.<init>(r12)
            java.lang.String r3 = r3.format(r4)
            java.lang.String r3 = r0.h((java.lang.String) r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r4.n
            if (r4 == 0) goto L_0x016a
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r4.n
            java.lang.String r4 = r4.getPayMode()
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x016a
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r5 = r21.ae()
            java.lang.String r5 = com.paytm.utility.b.Q((java.lang.String) r5)
            boolean r4 = r4.s(r5)
            if (r4 == 0) goto L_0x016a
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r4 = r4.E()
            if (r4 == 0) goto L_0x016a
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r3 = r3.H
            boolean r3 = r3.isChecked()
            java.lang.String r4 = r21.ae()
            java.lang.String r4 = com.paytm.utility.b.Q((java.lang.String) r4)
            java.lang.String r5 = r21.ae()
            com.paytm.utility.b.Q((java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r5 = r5.H
            boolean r5 = r0.a((boolean) r8, (net.one97.paytm.p2mNewDesign.g.c) r5)
            r0.a((boolean) r3, (java.lang.String) r4, (boolean) r5)
            goto L_0x0269
        L_0x016a:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r4 = r4.H
            boolean r4 = r4.isChecked()
            java.lang.String r5 = com.paytm.utility.b.Q((java.lang.String) r3)
            com.paytm.utility.b.Q((java.lang.String) r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r3 = r3.H
            boolean r3 = r0.a((boolean) r7, (net.one97.paytm.p2mNewDesign.g.c) r3)
            r0.a((boolean) r4, (java.lang.String) r5, (boolean) r3)
            goto L_0x0269
        L_0x018a:
            r18 = r5
            java.lang.String r3 = r21.ae()
            double r3 = java.lang.Double.parseDouble(r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r5 = r5.f13087c
            java.lang.String r5 = r5.getTotalBalance()
            double r19 = java.lang.Double.parseDouble(r5)
            double r3 = r3 - r19
            int r5 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r5 <= 0) goto L_0x01b0
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x01b0
            double r3 = java.lang.Math.ceil(r3)
        L_0x01b0:
            java.text.DecimalFormat r5 = new java.text.DecimalFormat
            r5.<init>(r12)
            java.lang.String r3 = r5.format(r3)
            java.lang.String r3 = r0.h((java.lang.String) r3)
            android.widget.TextView r4 = r0.Y
            android.content.Context r5 = r0.f51126g
            int r10 = net.one97.paytm.wallet.R.string.add_money_to_pay
            java.lang.String r5 = r5.getString(r10)
            java.lang.Object[] r10 = new java.lang.Object[r7]
            r10[r8] = r3
            java.lang.String r3 = java.lang.String.format(r5, r10)
            r4.setText(r3)
            goto L_0x0269
        L_0x01d4:
            r18 = r5
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.f13087c
            if (r3 == 0) goto L_0x0269
            if (r1 == 0) goto L_0x0269
            java.lang.String r3 = r22.getPayMode()
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0269
            java.lang.String r3 = r21.ae()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r4 = r4.H
            if (r4 == 0) goto L_0x021d
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r3 = r3.H
            boolean r3 = r3.isChecked()
            java.lang.String r4 = r21.ae()
            java.lang.String r4 = com.paytm.utility.b.Q((java.lang.String) r4)
            java.lang.String r5 = r21.ae()
            com.paytm.utility.b.Q((java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r5 = r5.H
            boolean r5 = r0.a((boolean) r8, (net.one97.paytm.p2mNewDesign.g.c) r5)
            r0.a((boolean) r3, (java.lang.String) r4, (boolean) r5)
            goto L_0x0269
        L_0x021d:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x025c
            boolean r3 = r3.equalsIgnoreCase(r9)
            if (r3 == 0) goto L_0x022a
            goto L_0x025c
        L_0x022a:
            android.widget.TextView r3 = r0.Y
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r5 = r0.f51126g
            int r10 = net.one97.paytm.wallet.R.string.pay
            java.lang.String r5 = r5.getString(r10)
            r4.append(r5)
            r4.append(r13)
            android.content.Context r5 = r0.f51126g
            int r10 = net.one97.paytm.wallet.R.string.rs_symbol
            java.lang.String r5 = r5.getString(r10)
            r4.append(r5)
            r4.append(r13)
            java.lang.String r5 = r21.ae()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.setText(r4)
            goto L_0x0269
        L_0x025c:
            android.widget.TextView r3 = r0.Y
            android.content.Context r4 = r0.f51126g
            int r5 = net.one97.paytm.wallet.R.string.pay
            java.lang.String r4 = r4.getString(r5)
            r3.setText(r4)
        L_0x0269:
            if (r1 == 0) goto L_0x0316
            java.lang.String r3 = r22.getPayMode()
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x0316
            java.lang.String r3 = r21.ae()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r4 = r4.H
            if (r4 == 0) goto L_0x02a8
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r3 = r3.H
            boolean r3 = r3.isChecked()
            java.lang.String r4 = r21.ae()
            java.lang.String r4 = com.paytm.utility.b.Q((java.lang.String) r4)
            java.lang.String r5 = r21.ae()
            com.paytm.utility.b.Q((java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r5 = r5.H
            boolean r5 = r0.a((boolean) r8, (net.one97.paytm.p2mNewDesign.g.c) r5)
            r0.a((boolean) r3, (java.lang.String) r4, (boolean) r5)
            goto L_0x02f4
        L_0x02a8:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x02e7
            boolean r3 = r3.equalsIgnoreCase(r9)
            if (r3 == 0) goto L_0x02b5
            goto L_0x02e7
        L_0x02b5:
            android.widget.TextView r3 = r0.Y
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            android.content.Context r5 = r0.f51126g
            int r9 = net.one97.paytm.wallet.R.string.pay
            java.lang.String r5 = r5.getString(r9)
            r4.append(r5)
            r4.append(r13)
            android.content.Context r5 = r0.f51126g
            int r9 = net.one97.paytm.wallet.R.string.rs_symbol
            java.lang.String r5 = r5.getString(r9)
            r4.append(r5)
            r4.append(r13)
            java.lang.String r5 = r21.ae()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.setText(r4)
            goto L_0x02f4
        L_0x02e7:
            android.widget.TextView r3 = r0.Y
            android.content.Context r4 = r0.f51126g
            int r5 = net.one97.paytm.wallet.R.string.pay
            java.lang.String r4 = r4.getString(r5)
            r3.setText(r4)
        L_0x02f4:
            java.lang.String r3 = r22.getPayMode()
            r4 = r18
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0318
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText r3 = r0.k
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = com.paytm.utility.b.Q((java.lang.String) r3)
            r0.g((java.lang.String) r3)
            goto L_0x0318
        L_0x0316:
            r4 = r18
        L_0x0318:
            java.lang.String r3 = r22.getPayMode()
            java.lang.String r5 = "GIFT_VOUCHER"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0484
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.l
            java.lang.String r3 = r3.getTotalBalance()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0484
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.l
            java.lang.String r3 = r3.getTotalBalance()
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r9 = r3.doubleValue()
            java.lang.String r3 = r21.ae()
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r17 = r3.doubleValue()
            int r3 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r3 >= 0) goto L_0x0484
            java.lang.String r3 = r21.ae()
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r9 = r3.doubleValue()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.l
            java.lang.String r3 = r3.getTotalBalance()
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r17 = r3.doubleValue()
            double r9 = r9 - r17
            int r3 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r3 <= 0) goto L_0x0384
            r17 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r3 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r3 >= 0) goto L_0x0384
            double r9 = java.lang.Math.ceil(r9)
        L_0x0384:
            java.text.DecimalFormat r3 = new java.text.DecimalFormat
            r3.<init>(r12)
            java.lang.String r3 = r3.format(r9)
            java.lang.String r3 = r0.h((java.lang.String) r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r5 = r5.H
            if (r5 == 0) goto L_0x0466
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r5 = r5.H
            boolean r5 = r5.isChecked()
            if (r5 == 0) goto L_0x0466
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.g.c r3 = r3.H
            java.text.DecimalFormat r5 = bU
            java.lang.String r9 = r21.ae()
            java.lang.Double r9 = java.lang.Double.valueOf(r9)
            double r9 = r9.doubleValue()
            java.lang.String r11 = r3.getRedeemablePercentage()
            java.lang.Double r11 = java.lang.Double.valueOf(r11)
            double r11 = r11.doubleValue()
            double r9 = r9 * r11
            r11 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r9 = r9 / r11
            java.lang.String r5 = r5.format(r9)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            double r9 = java.lang.Double.parseDouble(r5)
            java.lang.String r11 = r3.getTotalAvailableBalance()
            double r11 = java.lang.Double.parseDouble(r11)
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x03e6
            java.lang.String r5 = r3.getTotalAvailableBalance()
        L_0x03e6:
            java.text.DecimalFormat r3 = bU
            java.lang.String r9 = r21.ae()
            double r9 = java.lang.Double.parseDouble(r9)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r11 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r11 = r11.l
            java.lang.String r11 = r11.getTotalBalance()
            java.lang.Double r11 = java.lang.Double.valueOf(r11)
            double r11 = r11.doubleValue()
            double r9 = r9 - r11
            double r11 = java.lang.Double.parseDouble(r5)
            double r9 = r9 - r11
            java.lang.String r3 = r3.format(r9)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.Double r9 = java.lang.Double.valueOf(r3)
            double r9 = r9.doubleValue()
            int r11 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r11 <= 0) goto L_0x0432
            android.widget.TextView r5 = r0.Y
            android.content.Context r9 = r0.f51126g
            int r10 = net.one97.paytm.wallet.R.string.p2m_gv_buypurchase
            java.lang.String r9 = r9.getString(r10)
            java.lang.Object[] r10 = new java.lang.Object[r7]
            r10[r8] = r3
            java.lang.String r3 = java.lang.String.format(r9, r10)
            r5.setText(r3)
            goto L_0x045a
        L_0x0432:
            android.widget.TextView r3 = r0.Y
            android.content.Context r9 = r0.f51126g
            int r10 = net.one97.paytm.wallet.R.string.mlv_pay_button_text_new
            java.lang.String r9 = r9.getString(r10)
            java.lang.Object[] r10 = new java.lang.Object[r7]
            java.text.DecimalFormat r11 = bU
            java.lang.String r12 = r21.ae()
            double r12 = java.lang.Double.parseDouble(r12)
            double r14 = java.lang.Double.parseDouble(r5)
            double r12 = r12 - r14
            java.lang.String r5 = r11.format(r12)
            r10[r8] = r5
            java.lang.String r5 = java.lang.String.format(r9, r10)
            r3.setText(r5)
        L_0x045a:
            java.lang.String r3 = r21.ae()
            java.lang.String r3 = com.paytm.utility.b.Q((java.lang.String) r3)
            r0.l((java.lang.String) r3)
            goto L_0x0484
        L_0x0466:
            android.widget.TextView r5 = r0.Y
            android.content.Context r9 = r0.f51126g
            int r10 = net.one97.paytm.wallet.R.string.p2m_gv_buypurchase
            java.lang.String r9 = r9.getString(r10)
            java.lang.Object[] r10 = new java.lang.Object[r7]
            r10[r8] = r3
            java.lang.String r3 = java.lang.String.format(r9, r10)
            r5.setText(r3)
            android.widget.TextView r3 = r0.bw
            r5 = 8
            r3.setVisibility(r5)
            goto L_0x0484
        L_0x0483:
            r4 = r5
        L_0x0484:
            java.lang.String r3 = "proceedtoPay"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x05b0
            r21.W()
            if (r1 == 0) goto L_0x04ad
            java.lang.String r3 = r22.getPayMode()
            java.lang.String r5 = "UPI"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x04ad
            net.one97.paytm.common.entity.IJRDataModel r3 = r22.getDataModel()
            if (r3 == 0) goto L_0x04a8
            r21.b((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r22)
            goto L_0x05b0
        L_0x04a8:
            r21.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r22)
            goto L_0x05b0
        L_0x04ad:
            if (r1 == 0) goto L_0x04c6
            java.lang.String r3 = r22.getPayMode()
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x04c6
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r0.a((java.lang.Boolean) r3)
            r21.W()
            r21.R()
            goto L_0x05b0
        L_0x04c6:
            if (r1 == 0) goto L_0x04e7
            java.lang.String r3 = r22.getPayMode()
            java.lang.String r5 = "PPBL"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x04e7
            java.lang.String r3 = r22.getPaymentDetails()
            if (r3 != 0) goto L_0x04e7
            android.content.Context r3 = r0.f51126g
            int r4 = net.one97.paytm.wallet.R.string.passcode_four_digit_msg
            java.lang.String r3 = r3.getString(r4)
            r0.j((java.lang.String) r3)
            goto L_0x05b0
        L_0x04e7:
            if (r1 == 0) goto L_0x050e
            java.lang.String r3 = r22.getPayMode()
            java.lang.String r5 = "PAYTM_DIGITAL_CREDIT"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x050e
            java.lang.String r3 = r22.getPaymentDetails()
            java.lang.String r5 = "|"
            boolean r3 = r3.endsWith(r5)
            if (r3 == 0) goto L_0x050e
            android.content.Context r3 = r0.f51126g
            int r4 = net.one97.paytm.wallet.R.string.passcode_four_digit_msg
            java.lang.String r3 = r3.getString(r4)
            r0.j((java.lang.String) r3)
            goto L_0x05b0
        L_0x050e:
            boolean r3 = r21.K()
            if (r3 == 0) goto L_0x0540
            if (r1 == 0) goto L_0x0540
            java.lang.String r3 = r22.getPayMode()
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0540
            android.widget.TextView r3 = r0.ac
            java.lang.Object r3 = r3.getTag()
            if (r3 == 0) goto L_0x05b0
            android.widget.TextView r3 = r0.ac
            java.lang.Object r3 = r3.getTag()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x05b0
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r0.a((java.lang.Boolean) r3)
            r21.I()
            goto L_0x05b0
        L_0x0540:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r0.a((java.lang.Boolean) r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r3 = r3.D()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelPaymentDetails r4 = r4.J
            if (r4 == 0) goto L_0x0559
            r21.al()
            goto L_0x05b0
        L_0x0559:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r4 = r4.F
            if (r4 == 0) goto L_0x05a3
            java.lang.String r4 = r22.getPayMode()
            java.lang.String r5 = "CREDIT_CARD"
            boolean r4 = r5.equalsIgnoreCase(r4)
            if (r4 != 0) goto L_0x0579
            java.lang.String r4 = r22.getPayMode()
            java.lang.String r5 = "DEBIT_CARD"
            boolean r4 = r5.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x05a3
        L_0x0579:
            boolean r4 = r22.isScpEnrolled()
            if (r4 == 0) goto L_0x059d
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L_0x059d
            java.lang.String r5 = r21.ae()
            double r5 = java.lang.Double.parseDouble(r5)
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r9 = r3.doubleValue()
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 > 0) goto L_0x059d
            r0.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1, (boolean) r7)
            goto L_0x05b0
        L_0x059d:
            if (r4 != 0) goto L_0x05b0
            r0.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1, (boolean) r8)
            goto L_0x05b0
        L_0x05a3:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            java.lang.String r4 = r21.ae()
            r0.c((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r3, (java.lang.String) r4)
        L_0x05b0:
            java.lang.String r3 = "closeSheet"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x05bb
            r21.W()
        L_0x05bb:
            java.lang.String r3 = "focusEditText"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x05cb
            net.one97.paytm.wallet.newdesign.universalp2p.utils.CustomAmountAnimatedEditText r3 = r0.k
            r3.requestFocus()
            r21.X()
        L_0x05cb:
            java.lang.String r3 = "onboardingupiflow"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0649
            boolean r3 = r21.Q()
            if (r3 == 0) goto L_0x0649
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.v
            if (r3 == 0) goto L_0x0649
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.v
            int r3 = r3.getUpiOnboardingStatus()
            net.one97.paytm.wallet.utility.j$c r4 = net.one97.paytm.wallet.utility.j.c.UPI_CREATED_NO_BANK_LINK
            int r4 = r4.getValue()
            if (r3 != r4) goto L_0x05f9
            r3 = 1139(0x473, float:1.596E-42)
            net.one97.paytm.upi.registration.view.AccountProviderActivity.a((androidx.fragment.app.Fragment) r0, (int) r3)
            goto L_0x0649
        L_0x05f9:
            android.content.Context r3 = r0.f51126g
            boolean r3 = net.one97.paytm.upi.util.UpiUtils.isInActiveProfileExist(r3)
            if (r3 == 0) goto L_0x060d
            android.content.Context r3 = r0.f51126g
            android.content.Intent r3 = net.one97.paytm.upi.util.UpiUtils.getUpiLandingPageActivityIntent(r3)
            r4 = 144(0x90, float:2.02E-43)
            r0.startActivityForResult(r3, r4)
            goto L_0x0649
        L_0x060d:
            net.one97.paytm.wallet.communicator.c r3 = net.one97.paytm.wallet.communicator.b.a()
            android.content.Context r12 = r3.getContext()
            boolean r3 = as
            if (r3 == 0) goto L_0x061c
            java.lang.String r3 = "home/scan/post-scan"
            goto L_0x061e
        L_0x061c:
            java.lang.String r3 = "home/pay-send/post-scan"
        L_0x061e:
            r13 = r3
            java.lang.String r8 = "offline_payments"
            java.lang.String r9 = "scan_success_p2m"
            java.lang.String r10 = "upi_p2m_onboarding"
            java.lang.String r11 = ""
            a(r8, r9, r10, r11, r12, r13)
            android.content.Intent r3 = new android.content.Intent
            android.content.Context r4 = r0.f51126g
            java.lang.Class<net.one97.paytm.upi.registration.view.UpiSelectBankActivity> r5 = net.one97.paytm.upi.registration.view.UpiSelectBankActivity.class
            r3.<init>(r4, r5)
            java.lang.String r4 = "redirect_url"
            java.lang.String r5 = "paytmmp://self_destroy"
            r3.putExtra(r4, r5)
            java.lang.String r4 = "show_full_screen"
            r3.putExtra(r4, r7)
            r4 = 536870912(0x20000000, float:1.0842022E-19)
            r3.addFlags(r4)
            r4 = 352(0x160, float:4.93E-43)
            r0.startActivityForResult(r3, r4)
        L_0x0649:
            java.lang.String r3 = "autofetchbalance"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0656
            net.one97.paytm.p2mNewDesign.j.b r3 = r0.f51127h
            r3.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1)
        L_0x0656:
            java.lang.String r3 = "openEMIBankList"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0663
            net.one97.paytm.p2mNewDesign.j.b r3 = r0.f51127h
            r3.a()
        L_0x0663:
            java.lang.String r3 = "openEMIPlanBottomSheet"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0670
            net.one97.paytm.p2mNewDesign.j.b r3 = r0.f51127h
            r3.b((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1)
        L_0x0670:
            java.lang.String r3 = "uncheck"
            boolean r4 = r2.equalsIgnoreCase(r3)
            if (r4 == 0) goto L_0x067d
            net.one97.paytm.p2mNewDesign.j.b r4 = r0.f51127h
            r4.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1, (java.lang.String) r3)
        L_0x067d:
            java.lang.String r3 = "sectionClose"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x068a
            net.one97.paytm.p2mNewDesign.j.b r2 = r0.f51127h
            r2.a((net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r1, (java.lang.String) r3)
        L_0x068a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.g.a(net.one97.paytm.p2mNewDesign.entity.InstrumentInfo, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void b(InstrumentInfo instrumentInfo) {
        boolean z2;
        boolean z3;
        BigDecimal bigDecimal;
        String str;
        BigDecimal bigDecimal2;
        this.R = UpiUtils.getUpiSequenceNo();
        MerchantDetailsV2 c2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().c();
        if (c2 != null) {
            Iterator<PaymentModesV2> it2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b().iterator();
            while (true) {
                z2 = false;
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
                PaymentModesV2 next = it2.next();
                if ("UPI".equals(next.getPaymentMode())) {
                    Iterator<PayChannelOptionsV2> it3 = next.getPayChannelOptions().iterator();
                    z3 = false;
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        PayChannelOptionsV2 next2 = it3.next();
                        if (SDKConstants.UPIPUSHEXPRESS.equalsIgnoreCase(next2.getChannelCode())) {
                            z2 = true;
                            break;
                        } else if ("UPI".equalsIgnoreCase(next2.getChannelCode())) {
                            z3 = true;
                        }
                    }
                }
            }
            if (z2) {
                if (getActivity() != null && !getActivity().isFinishing()) {
                    Intent moneyTransferIntent = net.one97.paytm.wallet.communicator.b.a().getMoneyTransferIntent(getActivity());
                    moneyTransferIntent.putExtra("intent_extra_is_offline_pg", true);
                    moneyTransferIntent.putExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION, UpiConstants.MoneyTransferPaymentOption.UPI);
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H == null || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H.isChecked() || Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H.getRedeemablePercentage()).doubleValue() <= 0.0d) {
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                        if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.F() || (bigDecimal = this.be) == null || bigDecimal.doubleValue() <= 0.0d) {
                            moneyTransferIntent.putExtra("amount", ae());
                        } else {
                            moneyTransferIntent.putExtra("amount", this.be.toString());
                        }
                    } else {
                        net.one97.paytm.p2mNewDesign.g.c cVar = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
                        ae();
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                        if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.F() || (bigDecimal2 = this.be) == null || bigDecimal2.doubleValue() <= 0.0d) {
                            String valueOf = String.valueOf(bU.format((Double.valueOf(ae()).doubleValue() * Double.valueOf(cVar.getRedeemablePercentage()).doubleValue()) / 100.0d));
                            if (Double.parseDouble(valueOf) > Double.parseDouble(cVar.getTotalAvailableBalance())) {
                                valueOf = cVar.getTotalAvailableBalance();
                            }
                            str = bU.format(Double.valueOf(ae()).doubleValue() - Double.valueOf(valueOf).doubleValue());
                        } else {
                            String valueOf2 = String.valueOf(bU.format((this.be.doubleValue() * Double.valueOf(cVar.getRedeemablePercentage()).doubleValue()) / 100.0d));
                            if (Double.parseDouble(valueOf2) > Double.parseDouble(cVar.getTotalAvailableBalance())) {
                                valueOf2 = cVar.getTotalAvailableBalance();
                            }
                            str = bU.format(this.be.doubleValue() - Double.valueOf(valueOf2).doubleValue());
                        }
                        moneyTransferIntent.putExtra("amount", str);
                    }
                    moneyTransferIntent.putExtra("seq_no", this.R);
                    moneyTransferIntent.putExtra("payee_name", c2.getMerchantName());
                    moneyTransferIntent.putExtra("payee_vpa", c2.getMerchantVpa());
                    moneyTransferIntent.putExtra("merchant_code", c2.getMcc());
                    UpiInstrumentInfo upiInstrumentInfo = new UpiInstrumentInfo();
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                    upiInstrumentInfo.setUpiDataModel(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a((UpiProfileDefaultBank) ((UpiInstrumentInfo) instrumentInfo).getUpiDataModel()));
                    moneyTransferIntent.putExtra("user_upi_details", upiInstrumentInfo.getUpiDataModel());
                    startActivityForResult(moneyTransferIntent, 1002);
                }
            } else if (z3) {
                a(instrumentInfo);
            }
        }
    }

    public void onOkClick() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void a(UserProfileSarvatraV2 userProfileSarvatraV2, UPIProfileV2 uPIProfileV2) {
        if ((uPIProfileV2 != null && uPIProfileV2.getRespDetails() != null && uPIProfileV2.getRespDetails().getProfileDetail() != null && uPIProfileV2.getRespDetails().getProfileDetail().getVpaDetails() != null && uPIProfileV2.getRespDetails().getProfileDetail().getVpaDetails().size() > 0) || (userProfileSarvatraV2 != null && userProfileSarvatraV2.getResponse() != null && userProfileSarvatraV2.getResponse().getVpaDetails() != null && userProfileSarvatraV2.getResponse().getVpaDetails().size() > 0)) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.C()) {
                this.A = new ArrayList();
                if (uPIProfileV2 != null) {
                    ArrayList<BankAccountsV2> bankAccounts = uPIProfileV2.getRespDetails().getProfileDetail().getBankAccounts();
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().Q = uPIProfileV2.getRespDetails().getProfileDetail().getVpaDetails().get(0);
                    for (BankAccountsV2 debitBank : bankAccounts) {
                        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                        upiProfileDefaultBank.setDebitBank(debitBank);
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                        upiProfileDefaultBank.setVirtualAddress(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a(uPIProfileV2));
                        upiProfileDefaultBank.setPrimary(true);
                        this.A.add(upiProfileDefaultBank);
                    }
                } else {
                    for (VpaDetails next : userProfileSarvatraV2.getResponse().getVpaDetails()) {
                        UpiProfileDefaultBank upiProfileDefaultBank2 = new UpiProfileDefaultBank();
                        upiProfileDefaultBank2.setDebitBank(next.getDefaultDebit());
                        upiProfileDefaultBank2.setVirtualAddress(next.getName());
                        upiProfileDefaultBank2.setPrimary(next.getPrimary());
                        this.A.add(upiProfileDefaultBank2);
                    }
                }
                if (this.A.size() == 0) {
                    if ((this.aj || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d("PPI")) && this.G && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
                        aa();
                    }
                } else if (!(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e() == null || this.A == null)) {
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(getContext(), this.A);
                }
                if ((this.aj || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d("PPI")) && this.G && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode()) && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d("UPI")) {
                    Z();
                }
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b(this.f51126g)) {
                    j(getString(R.string.only_wallet_accept_user_msg));
                }
            }
        }
    }

    private void aj() {
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        Context context = this.f51126g;
        Double valueOf = Double.valueOf(Double.NaN);
        f2.a(context, valueOf, valueOf);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b(this.f51126g, valueOf, valueOf);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.setDummyWalletView(true);
        CJRFetchPayMethodResponse cJRFetchPayMethodResponse = new CJRFetchPayMethodResponse();
        cJRFetchPayMethodResponse.setBody(new BodyV2());
        cJRFetchPayMethodResponse.setHead(new HeadV2());
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(cJRFetchPayMethodResponse);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c);
        c(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c);
        this.q = Double.toString(Double.NaN);
        net.one97.paytm.wallet.utility.a.a((Context) getActivity(), Double.NaN);
        this.T = false;
        if (this.f51127h == null) {
            this.f51127h = new net.one97.paytm.p2mNewDesign.j.b();
            this.f51127h.f13379g = this;
        }
        this.al.addView(this.f51127h.a(this.f51125f, this, ae(), this.n.getMappingId(), K(), this.n.isPgEnabled()));
        d("BALANCE");
        this.am = (ShimmerFrameLayout) this.al.findViewById(R.id.loader_p2m);
    }

    /* access modifiers changed from: private */
    public boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "0";
        if (str2.equalsIgnoreCase(str)) {
            return false;
        }
        net.one97.paytm.p2mNewDesign.g.c cVar = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
        if (cVar != null && cVar.isChecked()) {
            str2 = String.valueOf(bU.format((Double.valueOf(ae()).doubleValue() * Double.valueOf(cVar.getRedeemablePercentage()).doubleValue()) / 100.0d));
            if (Double.parseDouble(str2) > Double.parseDouble(cVar.getTotalAvailableBalance())) {
                str2 = cVar.getTotalAvailableBalance();
            }
        }
        return Double.valueOf(str).equals(Double.valueOf(str2));
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, String str, boolean z3) {
        String str2;
        net.one97.paytm.p2mNewDesign.g.c cVar = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
        h(z3);
        if (cVar == null || !z2) {
            if (z3 && Double.valueOf(str).doubleValue() > 0.0d) {
                this.Y.setText(String.format(this.f51126g.getString(R.string.add_money_to_pay), new Object[]{str}));
            } else if (Double.valueOf(ae()).doubleValue() == 0.0d) {
                this.Y.setText(this.f51126g.getString(R.string.pay));
            } else {
                this.Y.setText(String.format(this.f51126g.getString(R.string.mlv_pay_button_text_new), new Object[]{ae()}));
            }
            this.bw.setVisibility(8);
        } else if (TextUtils.isEmpty(ae()) || Double.valueOf(ae()).doubleValue() <= 0.0d) {
            this.bw.setVisibility(8);
        } else {
            if ("USER_ENROLMENT".equalsIgnoreCase(cVar.getContext())) {
                String valueOf = String.valueOf(bU.format(Double.parseDouble(cVar.getBonusPoint()) / 100.0d));
                if (TextUtils.isEmpty(valueOf)) {
                    valueOf = "0";
                }
                if (z3) {
                    str2 = String.valueOf(bU.format(Double.parseDouble(str) - Double.parseDouble(valueOf)));
                } else {
                    str2 = String.valueOf(bU.format(Double.parseDouble(ae()) - Double.parseDouble(valueOf)));
                }
            } else {
                String valueOf2 = String.valueOf(bU.format((Double.valueOf(ae()).doubleValue() * Double.valueOf(cVar.getRedeemablePercentage()).doubleValue()) / 100.0d));
                if (Double.parseDouble(valueOf2) > Double.parseDouble(cVar.getTotalAvailableBalance())) {
                    valueOf2 = cVar.getTotalAvailableBalance();
                }
                if (z3) {
                    str2 = String.valueOf(bU.format(Double.parseDouble(str) - Double.parseDouble(valueOf2)));
                } else {
                    str2 = String.valueOf(bU.format(Double.parseDouble(ae()) - Double.parseDouble(valueOf2)));
                }
            }
            if (Double.valueOf(str2).doubleValue() < 0.0d) {
                str2 = "0";
            }
            if (z3 && Double.valueOf(str2).doubleValue() > 0.0d) {
                this.Y.setText(String.format(this.f51126g.getString(R.string.add_money_to_pay), new Object[]{str2}));
            } else if (Double.valueOf(str2).doubleValue() == 0.0d) {
                this.Y.setText(String.format(this.f51126g.getString(R.string.mlv_pay_button_text_new), new Object[]{"0"}));
            } else {
                this.Y.setText(String.format(this.f51126g.getString(R.string.mlv_pay_button_text_new), new Object[]{str2}));
            }
        }
    }

    private void h(boolean z2) {
        if (z2) {
            net.one97.paytm.p2mNewDesign.j.b bVar = this.f51127h;
            if (bVar != null) {
                bVar.f13378f.d();
                this.O.setBackgroundColor(this.f51126g.getResources().getColor(R.color.grid_offer_blue));
                if (this.O.isEnabled()) {
                    Toast.makeText(this.f51125f, "Wallet balance insufficient, Please use some other paymode.", 0).show();
                }
                this.O.setEnabled(false);
            }
        } else if (this.f51127h != null) {
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("BALANCE")) {
                this.f51127h.f13378f.h();
            }
            this.O.setEnabled(true);
            this.O.setBackground(this.f51126g.getResources().getDrawable(R.drawable.rectangle_blue_filled));
        }
    }

    /* access modifiers changed from: private */
    public void l(String str) {
        net.one97.paytm.p2mNewDesign.g.c cVar = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
        if (cVar != null && !TextUtils.isEmpty(str) && Double.valueOf(str).doubleValue() > 0.0d) {
            String valueOf = String.valueOf(bU.format((Double.valueOf(str).doubleValue() * Double.valueOf(cVar.getRedeemablePercentage()).doubleValue()) / 100.0d));
            if (this.bt == null) {
                return;
            }
            if (Double.parseDouble(valueOf) > Double.parseDouble(cVar.getTotalAvailableBalance())) {
                this.bt.a(cVar.getTotalAvailableBalance());
            } else {
                this.bt.a(valueOf);
            }
        }
    }

    /* access modifiers changed from: private */
    public void ak() {
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String totalAvailableBalance;
        ChannelPaymentDetails channelPaymentDetails = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J;
        if (channelPaymentDetails != null && channelPaymentDetails.getCart() != null && channelPaymentDetails.getCart().getCartItems() != null && channelPaymentDetails.getCart().getCartItems().size() >= 0) {
            CartItem cartItem = channelPaymentDetails.getCart().getCartItems().get(0);
            net.one97.paytm.p2mNewDesign.g.c cVar = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
            String str7 = null;
            if (cVar != null) {
                boolean isChecked = cVar.isChecked();
                if ("USER_ENROLMENT".equalsIgnoreCase(cVar.getContext())) {
                    totalAvailableBalance = String.valueOf(bU.format(Double.parseDouble(cVar.getBonusPoint()) / 100.0d));
                    if (TextUtils.isEmpty(totalAvailableBalance)) {
                        totalAvailableBalance = "0";
                    }
                } else {
                    String valueOf = String.valueOf(bU.format((Double.valueOf(ae()).doubleValue() * Double.valueOf(cVar.getRedeemablePercentage()).doubleValue()) / 100.0d));
                    if (Double.valueOf(valueOf).doubleValue() > Double.valueOf(cVar.getTotalAvailableBalance()).doubleValue()) {
                        totalAvailableBalance = cVar.getTotalAvailableBalance();
                    } else {
                        z2 = isChecked;
                        str = valueOf;
                    }
                }
                z2 = isChecked;
                str = totalAvailableBalance;
            } else {
                str = null;
                z2 = false;
            }
            String promocode = (TextUtils.isEmpty(cartItem.getPromocode()) || this.bV) ? null : cartItem.getPromocode();
            String obj = !TextUtils.isEmpty(this.L.getText().toString()) ? this.L.getText().toString() : "";
            String payMode = (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().L || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null) ? null : net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode();
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart() == null) {
                str4 = null;
                str3 = null;
                str2 = null;
            } else {
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getStoreInfo() != null) {
                    str6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getStoreInfo().getKybId();
                    str5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getStoreInfo().getShopId();
                } else {
                    str6 = null;
                    str5 = null;
                }
                if (!TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getPosTransactionRequired())) {
                    str7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getPosTransactionRequired();
                }
                str4 = str6;
                str3 = str5;
                str2 = str7;
            }
            net.one97.paytm.p2mNewDesign.g.d dVar = net.one97.paytm.p2mNewDesign.g.d.f51279a;
            net.one97.paytm.p2mNewDesign.g.d.a(this.f51126g, ae(), String.valueOf(cartItem.getProductId()), String.valueOf(cartItem.getQuantity()), cartItem.getWarehouseId(), promocode, str, z2, payMode, channelPaymentDetails.getCart().getPgMid(), obj, str4, str3, str2, new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    String str;
                    if (iJRPaytmDataModel instanceof ChannelAPIResponse) {
                        ChannelAPIResponse channelAPIResponse = (ChannelAPIResponse) iJRPaytmDataModel;
                        if (channelAPIResponse.getNativeWithdrawDetails() == null || channelAPIResponse.getNativeWithdrawDetails().getTxnToken() == null) {
                            g.this.a(channelAPIResponse);
                            return;
                        }
                        String valueOf = String.valueOf(channelAPIResponse.getTXNAMOUNT());
                        if (!TextUtils.isEmpty(channelAPIResponse.getORDERID())) {
                            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(channelAPIResponse.getORDERID());
                            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().I = channelAPIResponse;
                        }
                        if (TextUtils.isEmpty(valueOf)) {
                            return;
                        }
                        if (g.this.n.isPgEnabled() && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e() != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e().getBody() != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e().getBody().getPcfEnabled()) {
                            String unused = g.this.by = valueOf;
                            g.this.a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode(), net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getChannelCode(), valueOf);
                        } else if (g.this.n == null || !g.this.n.isOfflinePostConvenience()) {
                            g gVar = g.this;
                            Double valueOf2 = Double.valueOf(valueOf);
                            String mobileNo = g.this.n.getMobileNo();
                            if (TextUtils.isEmpty(g.this.n.getComment())) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(g.this.L.getText());
                                str = sb.toString();
                            } else {
                                str = g.this.n.getComment();
                            }
                            gVar.a(valueOf2, mobileNo, str);
                        } else {
                            g.this.y();
                        }
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("key_is_from_fragment", true);
                    if (g.this.a(i2, networkCustomError, bundle, "mlv_api_fail")) {
                        return;
                    }
                    if (!(iJRPaytmDataModel instanceof ChannelAPIResponse) || !"OR_GG_4005".equalsIgnoreCase(((ChannelAPIResponse) iJRPaytmDataModel).getErrorCode())) {
                        g.b(g.this, true);
                    } else {
                        g.b(g.this, false);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void al() {
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String totalAvailableBalance;
        ChannelPaymentDetails channelPaymentDetails = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J;
        if (channelPaymentDetails != null && channelPaymentDetails.getCart() != null && channelPaymentDetails.getCart().getCartItems() != null && channelPaymentDetails.getCart().getCartItems().size() >= 0) {
            CartItem cartItem = channelPaymentDetails.getCart().getCartItems().get(0);
            net.one97.paytm.p2mNewDesign.g.c cVar = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
            String str7 = null;
            if (cVar != null) {
                boolean isChecked = cVar.isChecked();
                if ("USER_ENROLMENT".equalsIgnoreCase(cVar.getContext())) {
                    totalAvailableBalance = String.valueOf(bU.format(Double.parseDouble(cVar.getBonusPoint()) / 100.0d));
                    if (TextUtils.isEmpty(totalAvailableBalance)) {
                        totalAvailableBalance = "0";
                    }
                } else {
                    String valueOf = String.valueOf(bU.format((Double.valueOf(ae()).doubleValue() * Double.valueOf(cVar.getRedeemablePercentage()).doubleValue()) / 100.0d));
                    if (Double.valueOf(valueOf).doubleValue() > Double.valueOf(cVar.getTotalAvailableBalance()).doubleValue()) {
                        totalAvailableBalance = cVar.getTotalAvailableBalance();
                    } else {
                        z2 = isChecked;
                        str = valueOf;
                    }
                }
                z2 = isChecked;
                str = totalAvailableBalance;
            } else {
                str = null;
                z2 = false;
            }
            String promocode = (TextUtils.isEmpty(cartItem.getPromocode()) || this.bV) ? null : cartItem.getPromocode();
            String obj = !TextUtils.isEmpty(this.L.getText().toString()) ? this.L.getText().toString() : "";
            String payMode = (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().L || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null) ? null : net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode();
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart() == null) {
                str4 = null;
                str3 = null;
                str2 = null;
            } else {
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getStoreInfo() != null) {
                    str6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getStoreInfo().getKybId();
                    str5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getStoreInfo().getShopId();
                } else {
                    str6 = null;
                    str5 = null;
                }
                if (!TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getPosTransactionRequired())) {
                    str7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getPosTransactionRequired();
                }
                str4 = str6;
                str3 = str5;
                str2 = str7;
            }
            net.one97.paytm.p2mNewDesign.g.d dVar = net.one97.paytm.p2mNewDesign.g.d.f51279a;
            net.one97.paytm.p2mNewDesign.g.d.a(this.f51126g, ae(), String.valueOf(cartItem.getProductId()), String.valueOf(cartItem.getQuantity()), cartItem.getWarehouseId(), promocode, str, z2, payMode, channelPaymentDetails.getCart().getPgMid(), obj, str4, str3, str2, new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (iJRPaytmDataModel instanceof ChannelAPIResponse) {
                        ChannelAPIResponse channelAPIResponse = (ChannelAPIResponse) iJRPaytmDataModel;
                        if ("OR_GG_4005".equalsIgnoreCase(channelAPIResponse.getErrorCode())) {
                            g.b(g.this, false);
                        } else if (channelAPIResponse.getNativeWithdrawDetails() == null || channelAPIResponse.getNativeWithdrawDetails().getTxnToken() == null) {
                            g.this.a(channelAPIResponse);
                        } else {
                            if (!TextUtils.isEmpty(channelAPIResponse.getORDERID())) {
                                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(channelAPIResponse.getORDERID());
                                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().I = channelAPIResponse;
                            }
                            if (!TextUtils.isEmpty(String.valueOf(channelAPIResponse.getTXNAMOUNT()))) {
                                g.this.c(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, String.valueOf(channelAPIResponse.getTXNAMOUNT()));
                            }
                        }
                    }
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("key_is_from_fragment", true);
                    if (g.this.a(i2, networkCustomError, bundle, "mlv_api_fail")) {
                        return;
                    }
                    if (!(iJRPaytmDataModel instanceof ChannelAPIResponse) || !"OR_GG_4005".equalsIgnoreCase(((ChannelAPIResponse) iJRPaytmDataModel).getErrorCode())) {
                        g.b(g.this, true);
                    } else {
                        g.b(g.this, false);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r8v1, types: [net.one97.paytm.nativesdk.instruments.upipush.pojo.DefaultCredit] */
    /* JADX WARNING: type inference failed for: r8v2, types: [net.one97.paytm.nativesdk.dataSource.models.PaymentRequestModel] */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r8v15 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m(java.lang.String r21) {
        /*
            r20 = this;
            r0 = r20
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r1 = r1.n
            if (r1 == 0) goto L_0x0593
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelAPIResponse r1 = r1.I
            if (r1 == 0) goto L_0x0593
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.mlv.ChannelAPIResponse r1 = r1.I
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            java.lang.String r6 = "NONE"
            java.util.HashMap r3 = r20.am()
            net.one97.paytm.nativesdk.PaytmSDK$Builder r4 = new net.one97.paytm.nativesdk.PaytmSDK$Builder
            android.content.Context r8 = r0.f51126g
            java.lang.String r9 = r1.getMID()
            java.lang.String r10 = r1.getORDERID()
            net.one97.paytm.p2mNewDesign.entity.mlv.NativeWithdrawDetails r1 = r1.getNativeWithdrawDetails()
            java.lang.String r11 = r1.getTxnToken()
            java.lang.Double r1 = java.lang.Double.valueOf(r21)
            double r12 = r1.doubleValue()
            net.one97.paytm.p2mNewDesign.d.g$18 r14 = new net.one97.paytm.p2mNewDesign.d.g$18
            r14.<init>()
            r7 = r4
            r7.<init>(r8, r9, r10, r11, r12, r14)
            net.one97.paytm.nativesdk.Utils.Server r1 = net.one97.paytm.nativesdk.Utils.Server.PRODUCTION
            r4.setServer(r1)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r1 = r1.K
            r4.setNativePlusEnabled(r1)
            r4.setExtraParamsPTC(r3)
            java.lang.String r1 = "WALLET"
            r4.setVerticalName(r1)
            net.one97.paytm.nativesdk.PaytmSDK r1 = r4.build()
            net.one97.paytm.p2mNewDesign.d.g$19 r3 = new net.one97.paytm.p2mNewDesign.d.g$19
            r3.<init>()
            r1.registerOneClickTranscationListener(r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            java.lang.String r3 = r3.getPayMode()
            r4 = -1
            int r5 = r3.hashCode()
            r9 = 3
            java.lang.String r10 = "CREDIT_CARD"
            java.lang.String r11 = "DEBIT_CARD"
            r12 = 1
            r13 = 2
            r14 = 0
            switch(r5) {
                case -410455425: goto L_0x00d3;
                case -250353122: goto L_0x00c9;
                case 68769: goto L_0x00be;
                case 84238: goto L_0x00b4;
                case 2462282: goto L_0x00aa;
                case 378796732: goto L_0x00a0;
                case 1280945827: goto L_0x0098;
                case 1878720662: goto L_0x0090;
                case 2134027076: goto L_0x0086;
                default: goto L_0x0085;
            }
        L_0x0085:
            goto L_0x00dc
        L_0x0086:
            java.lang.String r5 = "NET_BANKING"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00dc
            r4 = 2
            goto L_0x00dc
        L_0x0090:
            boolean r3 = r3.equals(r10)
            if (r3 == 0) goto L_0x00dc
            r4 = 7
            goto L_0x00dc
        L_0x0098:
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L_0x00dc
            r4 = 6
            goto L_0x00dc
        L_0x00a0:
            java.lang.String r5 = "BALANCE"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00dc
            r4 = 1
            goto L_0x00dc
        L_0x00aa:
            java.lang.String r5 = "PPBL"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00dc
            r4 = 4
            goto L_0x00dc
        L_0x00b4:
            java.lang.String r5 = "UPI"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00dc
            r4 = 5
            goto L_0x00dc
        L_0x00be:
            java.lang.String r5 = "EMI"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00dc
            r4 = 8
            goto L_0x00dc
        L_0x00c9:
            java.lang.String r5 = "PAYTM_DIGITAL_CREDIT"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00dc
            r4 = 3
            goto L_0x00dc
        L_0x00d3:
            java.lang.String r5 = "GIFT_VOUCHER"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x00dc
            r4 = 0
        L_0x00dc:
            java.lang.String r3 = "/"
            java.lang.String r5 = "||"
            java.lang.String r15 = "|"
            java.lang.String r7 = "\\|"
            r8 = 0
            switch(r4) {
                case 0: goto L_0x0583;
                case 1: goto L_0x057d;
                case 2: goto L_0x0573;
                case 3: goto L_0x055c;
                case 4: goto L_0x0552;
                case 5: goto L_0x02a9;
                case 6: goto L_0x01ca;
                case 7: goto L_0x01ca;
                case 8: goto L_0x00ea;
                default: goto L_0x00e8;
            }
        L_0x00e8:
            goto L_0x058c
        L_0x00ea:
            java.lang.String r4 = r2.getPaymentDetails()
            java.lang.String r18 = r2.getBankCode()
            if (r18 == 0) goto L_0x0120
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L_0x016d
            boolean r3 = r4.contains(r5)
            if (r3 == 0) goto L_0x016d
            java.lang.String[] r3 = r4.split(r7)
            r3 = r3[r14]
            java.lang.String[] r4 = r4.split(r7)
            r4 = r4[r13]
            java.lang.String r5 = r2.getExpiryDate()
            java.lang.String r7 = r2.getBankCode()
            java.lang.String r9 = r2.getChannelCode()
            r12 = r5
            r13 = r7
            r15 = r9
            r14 = 1
            r7 = r3
            r9 = r8
            r8 = r4
            goto L_0x0172
        L_0x0120:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x016d
            boolean r5 = r4.contains(r15)
            if (r5 == 0) goto L_0x016d
            java.lang.String[] r5 = r4.split(r7)
            r5 = r5[r12]
            java.lang.String[] r12 = r4.split(r7)
            r12 = r12[r13]
            java.lang.String[] r4 = r4.split(r7)
            r4 = r4[r9]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = r4.substring(r14, r13)
            r7.append(r9)
            r7.append(r3)
            r3 = 6
            r9 = 4
            java.lang.String r3 = r4.substring(r9, r3)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r4 = r4.M
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r7 = r7.N
            r13 = r4
            r9 = r5
            r15 = r7
            r7 = r8
            r8 = r12
            r12 = r3
            goto L_0x0172
        L_0x016d:
            r7 = r8
            r9 = r7
            r12 = r9
            r13 = r12
            r15 = r13
        L_0x0172:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r3 = r3.D()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r4.n
            if (r4 == 0) goto L_0x01ab
            double r16 = java.lang.Double.parseDouble(r21)
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r18 = r3.doubleValue()
            int r3 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r3 > 0) goto L_0x01ab
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r3 = r3.F
            if (r3 == 0) goto L_0x01ab
            java.lang.String r3 = r4.getPayMode()
            boolean r3 = r10.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x01ab
            java.lang.String r3 = r4.getPayMode()
            r11.equalsIgnoreCase(r3)
        L_0x01ab:
            net.one97.paytm.nativesdk.dataSource.models.CardRequestModel r16 = new net.one97.paytm.nativesdk.dataSource.models.CardRequestModel
            java.lang.String r4 = r2.getEmiType()
            java.lang.String r2 = r2.getSelectedEMIPlanId()
            r17 = 0
            java.lang.String r18 = "otp"
            r3 = r16
            r5 = r6
            r6 = r9
            r9 = r12
            r10 = r13
            r11 = r15
            r12 = r18
            r13 = r2
            r15 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x02a5
        L_0x01ca:
            java.lang.String r4 = r2.getPaymentDetails()
            java.lang.String r18 = r2.getBankCode()
            if (r18 == 0) goto L_0x0200
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L_0x024d
            boolean r3 = r4.contains(r5)
            if (r3 == 0) goto L_0x024d
            java.lang.String[] r3 = r4.split(r7)
            r3 = r3[r14]
            java.lang.String[] r4 = r4.split(r7)
            r4 = r4[r13]
            java.lang.String r5 = r2.getExpiryDate()
            java.lang.String r7 = r2.getBankCode()
            java.lang.String r9 = r2.getChannelCode()
            r12 = r5
            r13 = r7
            r15 = r9
            r14 = 1
            r7 = r3
            r9 = r8
            r8 = r4
            goto L_0x0252
        L_0x0200:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x024d
            boolean r5 = r4.contains(r15)
            if (r5 == 0) goto L_0x024d
            java.lang.String[] r5 = r4.split(r7)
            r5 = r5[r12]
            java.lang.String[] r12 = r4.split(r7)
            r12 = r12[r13]
            java.lang.String[] r4 = r4.split(r7)
            r4 = r4[r9]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = r4.substring(r14, r13)
            r7.append(r9)
            r7.append(r3)
            r3 = 6
            r9 = 4
            java.lang.String r3 = r4.substring(r9, r3)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r4 = r4.M
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r7 = r7.N
            r13 = r4
            r9 = r5
            r15 = r7
            r7 = r8
            r8 = r12
            r12 = r3
            goto L_0x0252
        L_0x024d:
            r7 = r8
            r9 = r7
            r12 = r9
            r13 = r12
            r15 = r13
        L_0x0252:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r3 = r3.D()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r4.n
            if (r4 == 0) goto L_0x028b
            double r16 = java.lang.Double.parseDouble(r21)
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            double r18 = r3.doubleValue()
            int r3 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r3 > 0) goto L_0x028b
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r3 = r3.F
            if (r3 == 0) goto L_0x028b
            java.lang.String r3 = r4.getPayMode()
            boolean r3 = r10.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x028b
            java.lang.String r3 = r4.getPayMode()
            r11.equalsIgnoreCase(r3)
        L_0x028b:
            net.one97.paytm.nativesdk.dataSource.models.CardRequestModel r16 = new net.one97.paytm.nativesdk.dataSource.models.CardRequestModel
            java.lang.String r4 = r2.getPayMode()
            r2 = 0
            r17 = 0
            java.lang.String r18 = "otp"
            r3 = r16
            r5 = r6
            r6 = r9
            r9 = r12
            r10 = r13
            r11 = r15
            r12 = r18
            r13 = r2
            r15 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x02a5:
            r8 = r16
            goto L_0x058c
        L_0x02a9:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r2 = r2.J()
            if (r2 == 0) goto L_0x03ad
            android.content.Context r2 = r0.f51126g
            java.lang.String r2 = net.one97.paytm.upi.util.UpiUtils.getDeviceId(r2)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            boolean r3 = r3 instanceof net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.UpiInstrumentInfo
            if (r3 == 0) goto L_0x058c
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r3 = r3.n
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.UpiInstrumentInfo r3 = (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.UpiInstrumentInfo) r3
            net.one97.paytm.upi.common.UpiBaseDataModel r3 = r3.getUpiDataModel()
            net.one97.paytm.p2mNewDesign.entity.UpiProfileDefaultBank r3 = (net.one97.paytm.p2mNewDesign.entity.UpiProfileDefaultBank) r3
            net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail r9 = new net.one97.paytm.nativesdk.instruments.upipush.model.VpaBankAccountDetail
            r9.<init>()
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r3.getDebitBank()
            if (r4 == 0) goto L_0x037b
            java.lang.String r4 = r3.getVirtualAddress()
            r9.setName(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r3.getDebitBank()
            java.lang.String r4 = r4.getAccRefId()
            r9.setAccRefId(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r3.getDebitBank()
            java.lang.String r4 = r4.getAccRefId()
            r9.setAccountType(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r3.getDebitBank()
            java.lang.String r4 = r4.getMaskedAccountNumber()
            r9.setMaskedAccountNumber(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r3.getDebitBank()
            java.lang.String r4 = r4.getAccountType()
            r9.setAccountType(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r3.getDebitBank()
            java.lang.String r4 = r4.getBank()
            r9.setBank(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r5 = r3.getDebitBank()
            java.util.ArrayList r5 = r5.getCredsAllowed()
            if (r5 == 0) goto L_0x036d
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r5 = r3.getDebitBank()
            java.util.ArrayList r5 = r5.getCredsAllowed()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x036d
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r5 = r3.getDebitBank()
            java.util.ArrayList r5 = r5.getCredsAllowed()
            java.util.Iterator r5 = r5.iterator()
        L_0x0343:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x036d
            java.lang.Object r7 = r5.next()
            net.one97.paytm.p2mNewDesign.models.CredsAllowedV2 r7 = (net.one97.paytm.p2mNewDesign.models.CredsAllowedV2) r7
            net.one97.paytm.nativesdk.instruments.upipush.model.CredsAllowed r8 = new net.one97.paytm.nativesdk.instruments.upipush.model.CredsAllowed
            java.lang.String r11 = r7.getCredsAllowedDLength()
            java.lang.String r12 = r7.getCredsAllowedDType()
            java.lang.String r13 = r7.getCredsAllowedSubType()
            java.lang.String r14 = r7.getCredsAllowedType()
            java.lang.String r15 = r7.getDLength()
            r10 = r8
            r10.<init>(r11, r12, r13, r14, r15)
            r4.add(r8)
            goto L_0x0343
        L_0x036d:
            r9.setCredsAllowed(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r3 = r3.getDebitBank()
            java.lang.String r3 = r3.getIfsc()
            r9.setIfsc(r3)
        L_0x037b:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.models.VpaDetailsV2 r3 = r3.Q
            net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail r4 = new net.one97.paytm.nativesdk.instruments.upipush.model.VpaAccountDetail
            java.lang.String r5 = r3.getDefaultCreditAccRefId()
            java.lang.String r7 = r3.getDefaultDebitAccRefId()
            java.lang.String r8 = r3.getName()
            java.lang.Boolean r3 = r3.getPrimary()
            boolean r3 = r3.booleanValue()
            r4.<init>(r5, r7, r8, r3)
            r9.setVpaDetail(r4)
            net.one97.paytm.nativesdk.dataSource.models.UPIRequestModel r10 = new net.one97.paytm.nativesdk.dataSource.models.UPIRequestModel
            java.lang.String r4 = r0.Q
            net.one97.paytm.nativesdk.dataSource.utils.PaymentUtility$FlowType r5 = net.one97.paytm.nativesdk.dataSource.utils.PaymentUtility.FlowType.PUSH
            java.lang.String r7 = r0.R
            r3 = r10
            r8 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r8 = r10
            goto L_0x058c
        L_0x03ad:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            boolean r2 = r2 instanceof net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.UpiInstrumentInfo
            if (r2 == 0) goto L_0x058c
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.UpiInstrumentInfo r2 = (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.UpiInstrumentInfo) r2
            net.one97.paytm.upi.common.UpiBaseDataModel r2 = r2.getUpiDataModel()
            net.one97.paytm.p2mNewDesign.entity.UpiProfileDefaultBank r2 = (net.one97.paytm.p2mNewDesign.entity.UpiProfileDefaultBank) r2
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r3 = r2.getDebitBank()
            if (r3 == 0) goto L_0x047f
            net.one97.paytm.nativesdk.instruments.upipush.pojo.DefaultDebit r3 = new net.one97.paytm.nativesdk.instruments.upipush.pojo.DefaultDebit
            r3.<init>()
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getDebitBank()
            java.lang.String r4 = r4.getAccount()
            r3.setAccount(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getDebitBank()
            java.lang.String r4 = r4.getAccountType()
            r3.setAccountType(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getDebitBank()
            java.lang.String r4 = r4.getAccRefNumber()
            r3.setAccRefNumber(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getDebitBank()
            java.lang.String r4 = r4.getAeba()
            r3.setAeba(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getDebitBank()
            java.lang.String r4 = r4.getBank()
            r3.setBank(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r5 = r2.getDebitBank()
            java.util.ArrayList r5 = r5.getCredsAllowed()
            if (r5 == 0) goto L_0x0461
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r5 = r2.getDebitBank()
            java.util.ArrayList r5 = r5.getCredsAllowed()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x0461
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r5 = r2.getDebitBank()
            java.util.ArrayList r5 = r5.getCredsAllowed()
            java.util.Iterator r5 = r5.iterator()
        L_0x0430:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0461
            java.lang.Object r6 = r5.next()
            net.one97.paytm.p2mNewDesign.models.CredsAllowedV2 r6 = (net.one97.paytm.p2mNewDesign.models.CredsAllowedV2) r6
            net.one97.paytm.nativesdk.instruments.upipush.pojo.CredsAllowed_ r7 = new net.one97.paytm.nativesdk.instruments.upipush.pojo.CredsAllowed_
            r7.<init>()
            java.lang.String r9 = r6.getCredsAllowedDLength()
            r7.setCredsAllowedDLength(r9)
            java.lang.String r9 = r6.getCredsAllowedDType()
            r7.setCredsAllowedDType(r9)
            java.lang.String r9 = r6.getCredsAllowedSubType()
            r7.setCredsAllowedSubType(r9)
            java.lang.String r6 = r6.getDLength()
            r7.setDLength(r6)
            r4.add(r7)
            goto L_0x0430
        L_0x0461:
            r3.setCredsAllowed(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getDebitBank()
            java.lang.String r4 = r4.getIfsc()
            r3.setIfsc(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getDebitBank()
            java.lang.Object r4 = r4.getMbeba()
            java.lang.String r4 = r4.toString()
            r3.setMbeba(r4)
            goto L_0x0480
        L_0x047f:
            r3 = r8
        L_0x0480:
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getCreditBank()
            if (r4 == 0) goto L_0x0534
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getCreditBank()
            java.lang.String r4 = r4.getAccount()
            r8.setAccount(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getCreditBank()
            java.lang.String r4 = r4.getAccountType()
            r8.setAccountType(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getCreditBank()
            java.lang.String r4 = r4.getAccRefNumber()
            r8.setAccRefNumber(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getCreditBank()
            java.lang.String r4 = r4.getAeba()
            r8.setAeba(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getCreditBank()
            java.lang.String r4 = r4.getBank()
            r8.setBank(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r5 = r2.getCreditBank()
            java.util.ArrayList r5 = r5.getCredsAllowed()
            if (r5 == 0) goto L_0x0517
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r5 = r2.getCreditBank()
            java.util.ArrayList r5 = r5.getCredsAllowed()
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x0517
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r5 = r2.getCreditBank()
            java.util.ArrayList r5 = r5.getCredsAllowed()
            java.util.Iterator r5 = r5.iterator()
        L_0x04e6:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0517
            java.lang.Object r6 = r5.next()
            net.one97.paytm.p2mNewDesign.models.CredsAllowedV2 r6 = (net.one97.paytm.p2mNewDesign.models.CredsAllowedV2) r6
            net.one97.paytm.nativesdk.instruments.upipush.pojo.CredsAllowed r7 = new net.one97.paytm.nativesdk.instruments.upipush.pojo.CredsAllowed
            r7.<init>()
            java.lang.String r9 = r6.getCredsAllowedDLength()
            r7.setCredsAllowedDLength(r9)
            java.lang.String r9 = r6.getCredsAllowedDType()
            r7.setCredsAllowedDType(r9)
            java.lang.String r9 = r6.getCredsAllowedSubType()
            r7.setCredsAllowedSubType(r9)
            java.lang.String r6 = r6.getDLength()
            r7.setDLength(r6)
            r4.add(r7)
            goto L_0x04e6
        L_0x0517:
            r8.setCredsAllowed(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getCreditBank()
            java.lang.String r4 = r4.getIfsc()
            r8.setIfsc(r4)
            net.one97.paytm.p2mNewDesign.models.BankAccountsV2 r4 = r2.getCreditBank()
            java.lang.Object r4 = r4.getMbeba()
            java.lang.String r4 = r4.toString()
            r8.setMbeba(r4)
        L_0x0534:
            net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaDetail r4 = new net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaDetail
            r4.<init>()
            java.lang.String r5 = r2.getVirtualAddress()
            r4.setName(r5)
            boolean r2 = r2.isPrimary()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4.setPrimary(r2)
            r4.setDefaultDebit(r3)
            r4.setDefaultCredit(r8)
            goto L_0x058c
        L_0x0552:
            net.one97.paytm.nativesdk.dataSource.models.PaytmPaymentsBankModel r8 = new net.one97.paytm.nativesdk.dataSource.models.PaytmPaymentsBankModel
            java.lang.String r2 = r2.getPaymentDetails()
            r8.<init>(r2, r6)
            goto L_0x058c
        L_0x055c:
            java.lang.String r3 = r2.getPaymentDetails()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x056b
            java.lang.String r2 = r2.getPaymentDetails()
            goto L_0x056d
        L_0x056b:
            java.lang.String r2 = ""
        L_0x056d:
            net.one97.paytm.nativesdk.dataSource.models.PaytmDigitalRequestModel r8 = new net.one97.paytm.nativesdk.dataSource.models.PaytmDigitalRequestModel
            r8.<init>(r2, r6)
            goto L_0x058c
        L_0x0573:
            net.one97.paytm.nativesdk.dataSource.models.NetBankingRequestModel r8 = new net.one97.paytm.nativesdk.dataSource.models.NetBankingRequestModel
            java.lang.String r2 = r2.getBankCode()
            r8.<init>(r6, r2)
            goto L_0x058c
        L_0x057d:
            net.one97.paytm.nativesdk.dataSource.models.WalletRequestModel r8 = new net.one97.paytm.nativesdk.dataSource.models.WalletRequestModel
            r8.<init>(r6)
            goto L_0x058c
        L_0x0583:
            java.lang.String r2 = r2.getTempleteId()
            net.one97.paytm.nativesdk.dataSource.models.MGVRequestModel r8 = new net.one97.paytm.nativesdk.dataSource.models.MGVRequestModel
            r8.<init>(r6, r2)
        L_0x058c:
            if (r8 == 0) goto L_0x0593
            android.content.Context r2 = r0.f51126g
            r1.startTransaction(r2, r8)
        L_0x0593:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.g.m(java.lang.String):void");
    }

    private HashMap<String, Object> am() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String linkType = this.n.getLinkType();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(linkType)) {
                jSONObject.put("mercUnqRef", this.n.getId());
            } else {
                jSONObject.put("mercUnqRef", this.n.getQrCodeId());
            }
            jSONObject.put("udf1", this.n.getPosId());
            jSONObject.put("additionalInfo", T());
            if (this.ak != null) {
                jSONObject.put("linkDesc", this.ak.linkDescription);
                jSONObject.put("linkId", this.ak.id);
                jSONObject.put("linkInvoiceId", this.ak.getInvoiceId());
                jSONObject.put(AppConstants.TAG_LINK_NAME, this.ak.linkName);
            }
        } catch (JSONException unused) {
        }
        hashMap.put(Constants.RISK_EXTENDED_INFO, jSONObject);
        return hashMap;
    }

    public final void a(ChannelAPIResponse channelAPIResponse) {
        String str;
        Activity activity;
        String str2;
        Intent h2 = net.one97.paytm.wallet.utility.a.h((Context) this.f51125f);
        h2.putExtra("isMLVEnabledPayment", true);
        h2.putExtra("mlvOrderId", channelAPIResponse.getORDERID());
        h2.putExtra("provider", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getMLVInfo().getProvider());
        h2.putExtra("phone_no", this.n.getMobileNo());
        h2.putExtra("name", S());
        h2.putExtra("mlvMerchantName", S());
        h2.putExtra("mlvAmount", channelAPIResponse.getTXNAMOUNT());
        h2.putExtra("launchFrom", this.bQ);
        h2.putExtra("is_from_app_evoke", this.aD);
        if (!this.bf || this.bg.doubleValue() <= 0.0d) {
            h2.putExtra("is_pcf", true);
        } else {
            h2.putExtra("is_pcf", true);
            h2.putExtra("pcf_amount", this.bg);
        }
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || !"emi".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
            h2.putExtra("is_emi", false);
        } else {
            h2.putExtra("is_emi", true);
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan() != null) {
                h2.putExtra("emi_message", String.format(this.f51126g.getResources().getString(R.string.emi_transcation), new Object[]{channelAPIResponse.getTXNAMOUNT(), bU.format(Double.valueOf(channelAPIResponse.getTXNAMOUNT()).doubleValue() / Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan().a()).doubleValue()), net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan().a()}));
            }
        }
        if (TextUtils.isEmpty(this.n.getComment())) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.L.getText());
            str = sb.toString();
        } else {
            str = this.n.getComment();
        }
        h2.putExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL, str);
        InstrumentInfo instrumentInfo = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
        if (instrumentInfo != null && !TextUtils.isEmpty(instrumentInfo.getPayMode())) {
            h2.putExtra("used_instrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode());
            String payMode = instrumentInfo.getPayMode();
            String str3 = null;
            if (payMode.equalsIgnoreCase("UPI")) {
                str2 = instrumentInfo.getAccountNumber();
            } else if (payMode.equalsIgnoreCase(SDKConstants.DEBIT)) {
                String paymentDetails = instrumentInfo.getPaymentDetails();
                if (!TextUtils.isEmpty(paymentDetails) && paymentDetails.contains("||")) {
                    str3 = paymentDetails.split("\\|")[0];
                }
                str2 = str3;
                payMode = "SAVED_DC";
            } else if (payMode.equalsIgnoreCase(SDKConstants.CREDIT)) {
                String paymentDetails2 = instrumentInfo.getPaymentDetails();
                if (!TextUtils.isEmpty(paymentDetails2) && paymentDetails2.contains("||")) {
                    str3 = paymentDetails2.split("\\|")[0];
                }
                str2 = str3;
                payMode = "SAVED_CC";
            } else {
                str2 = instrumentInfo.getPaymentDetails();
            }
            h2.putExtra("pay_mode", payMode);
            h2.putExtra("unique_identifier", str2);
        }
        h2.putExtra("mlvMyOrdersAPIUrl", "https://cart.paytm.com/v2/myorders/");
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().I != null) {
            h2.putExtra("mlv_channels_checkout_data", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().I);
        }
        if (isAdded() && (activity = this.f51125f) != null && !activity.isFinishing()) {
            if (this.aD) {
                getActivity().startActivityForResult(h2, 2002);
                return;
            }
            startActivity(h2);
            getActivity().finish();
        }
    }

    /* access modifiers changed from: private */
    public boolean a(boolean z2, net.one97.paytm.p2mNewDesign.g.c cVar) {
        String str;
        if (!z2) {
            return false;
        }
        if (!cVar.isChecked()) {
            return z2;
        }
        if ("USER_ENROLMENT".equalsIgnoreCase(cVar.getContext())) {
            str = String.valueOf(bU.format(Double.parseDouble(cVar.getBonusPoint()) / 100.0d));
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
        } else {
            str = String.valueOf(bU.format((Double.valueOf(ae()).doubleValue() * Double.valueOf(cVar.getRedeemablePercentage()).doubleValue()) / 100.0d));
            if (Double.parseDouble(str) > Double.parseDouble(cVar.getTotalAvailableBalance())) {
                str = cVar.getTotalAvailableBalance();
            }
        }
        if (Double.valueOf(str).doubleValue() >= Double.valueOf(com.paytm.utility.b.Q(ae())).doubleValue() - Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.getTotalBalance()).doubleValue()) {
            return false;
        }
        return true;
    }

    private void c(InstrumentInfo instrumentInfo) {
        if (!this.n.isPgEnabled()) {
            this.ac.setVisibility(8);
            if (!K() || this.L.getVisibility() != 8) {
                this.ad.setVisibility(8);
            } else {
                this.ad.setVisibility(0);
            }
            if ((!instrumentInfo.getPayMode().equalsIgnoreCase("UPI") || instrumentInfo.getDisplayPrimaryInfo().equalsIgnoreCase(this.f51126g.getString(R.string.upi))) && !instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.AI_KEY_PPBL) && !instrumentInfo.getPayMode().equalsIgnoreCase("NET_BANKING") && instrumentInfo.getPayMode().equalsIgnoreCase("Gold")) {
                net.one97.paytm.jeweller.a.a(this.f51126g, "/digital_gold_offline/pay_screen", "digital_gold_offline", "payments_option_dropdown_clicked", (String) null, S(), com.paytm.utility.b.n(this.f51126g));
                g(com.paytm.utility.b.Q(this.k.getText().toString().trim()));
                this.ad.setVisibility(8);
            }
        }
    }

    public final void b(boolean z2) {
        if (z2) {
            this.am.b();
            this.am.setVisibility(8);
            return;
        }
        this.am.a();
        this.am.setVisibility(0);
    }

    public final String d() {
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H == null || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H.isChecked()) {
            return ae();
        }
        net.one97.paytm.p2mNewDesign.g.c cVar = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
        String valueOf = String.valueOf(bU.format((Double.valueOf(ae()).doubleValue() * Double.valueOf(cVar.getRedeemablePercentage()).doubleValue()) / 100.0d));
        if (Double.parseDouble(valueOf) > Double.parseDouble(cVar.getTotalAvailableBalance())) {
            valueOf = cVar.getTotalAvailableBalance();
        }
        return String.valueOf(bU.format(Double.parseDouble(ae()) - Double.parseDouble(valueOf)));
    }

    /* access modifiers changed from: private */
    public void c(InstrumentInfo instrumentInfo, String str) {
        CJRQRScanResultModel cJRQRScanResultModel = this.n;
        if (cJRQRScanResultModel != null && cJRQRScanResultModel.isPgEnabled() && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e() != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e().getBody() != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e().getBody().getPcfEnabled()) {
            this.by = str;
            a(instrumentInfo.getPayMode(), net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getChannelCode(), str);
        } else if ("UPI".equalsIgnoreCase(instrumentInfo.getPayMode())) {
            b(instrumentInfo);
        } else {
            b(instrumentInfo, str);
        }
    }

    private void a(final InstrumentInfo instrumentInfo, final boolean z2) {
        try {
            this.bi = (InstrumentInfo) instrumentInfo.clone();
        } catch (CloneNotSupportedException unused) {
        }
        if (z2) {
            an();
        }
        net.one97.paytm.wallet.communicator.b.c().getOneClickInfo(this.f51126g, instrumentInfo.getCardFirstSixDigit(), instrumentInfo.getCardLastFourDigit(), "", com.paytm.utility.b.n(this.f51126g), new a.C1415a() {
            public final void a(String str) {
                String unused = g.this.bh = str;
                g gVar = g.this;
                gVar.b(instrumentInfo, gVar.ae());
            }

            public final void a() {
                String unused = g.this.bh = null;
                if (!z2 || !instrumentInfo.isSavedCard()) {
                    g gVar = g.this;
                    gVar.b(instrumentInfo, gVar.ae());
                    return;
                }
                g.this.a(Boolean.FALSE);
                net.one97.paytm.wallet.i.a.c ad = g.this.bk;
                $$Lambda$g$20$AeX7gCuLTgMPSLorGVPCCcTUpP4 r2 = new net.one97.paytm.wallet.i.a(instrumentInfo) {
                    private final /* synthetic */ InstrumentInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClosing() {
                        g.AnonymousClass20.this.a(this.f$1);
                    }
                };
                k.c(r2, H5Event.TYPE_CALL_BACK);
                View view = ad.f70396a;
                if (view == null) {
                    k.a("rootView");
                }
                View findViewById = view.findViewById(R.id.progress_bar_lyt);
                k.a((Object) findViewById, "rootView.findViewById<Re…t>(R.id.progress_bar_lyt)");
                ((RelativeLayout) findViewById).setVisibility(8);
                View view2 = ad.f70396a;
                if (view2 == null) {
                    k.a("rootView");
                }
                View findViewById2 = view2.findViewById(R.id.tv_processing_state);
                k.a((Object) findViewById2, "rootView.findViewById<Li…R.id.tv_processing_state)");
                ((LinearLayout) findViewById2).setVisibility(8);
                View view3 = ad.f70396a;
                if (view3 == null) {
                    k.a("rootView");
                }
                View findViewById3 = view3.findViewById(R.id.error_lyt);
                k.a((Object) findViewById3, "rootView.findViewById<Re…veLayout>(R.id.error_lyt)");
                ((RelativeLayout) findViewById3).setVisibility(0);
                CharSequence stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(ad.getContext(), SDKConstants.KEY_SCP_PAYMENT_PROCESSING_ERROR);
                if (!TextUtils.isEmpty(stringFromGTM)) {
                    View view4 = ad.f70396a;
                    if (view4 == null) {
                        k.a("rootView");
                    }
                    ((TextView) view4.findViewById(R.id.error_textview)).setText(stringFromGTM);
                }
                View view5 = ad.f70396a;
                if (view5 == null) {
                    k.a("rootView");
                }
                ((Button) view5.findViewById(R.id.error_button)).setOnClickListener(new c.C1422c(ad, r2));
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void a(InstrumentInfo instrumentInfo) {
                net.one97.paytm.p2mNewDesign.j.b E = g.this.f51127h;
                String uniqueId = instrumentInfo.getUniqueId();
                net.one97.paytm.p2mNewDesign.e.c cVar = E.f13378f;
                k.c(uniqueId, "uniqueId");
                for (net.one97.paytm.p2mNewDesign.e.a aVar : cVar.f51255b) {
                    if (aVar.a().equals(uniqueId) && (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.a)) {
                        net.one97.paytm.p2mNewDesign.e.a.a aVar2 = (net.one97.paytm.p2mNewDesign.e.a.a) aVar;
                        aVar2.h();
                        aVar2.f13256a.setVisibility(0);
                        aVar2.f13257b.requestFocus();
                        aVar2.d();
                    }
                }
            }
        });
    }

    private void an() {
        this.bk = new net.one97.paytm.wallet.i.a.c(this);
        this.bk.setCancelable(false);
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        a2.a((Fragment) this.bk, (String) null);
        a2.c();
    }

    public final void b(InstrumentInfo instrumentInfo, String str) {
        at.a().f69666c = Long.valueOf(System.currentTimeMillis());
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J != null) {
            m(str);
            return;
        }
        LiveData<net.one97.paytm.network.f> a2 = net.one97.paytm.p2mNewDesign.i.a.a(this.f51126g, this.n, str, T(), this.ak, this.aV, instrumentInfo, this.Q, this.R, this.bh);
        if (a2 != null) {
            a2.observeForever(new z() {
                public final void onChanged(Object obj) {
                    g.this.a((net.one97.paytm.network.f) obj);
                }
            });
        }
    }

    private void a(String str, String str2, String str3, CJRProcessTranscationResponse cJRProcessTranscationResponse) {
        String str4;
        Activity activity;
        Intent h2 = net.one97.paytm.wallet.utility.a.h((Context) this.f51125f);
        h2.putExtra("key_via", "via_qr");
        h2.putExtra("phone_no", this.n.getMobileNo());
        h2.putExtra("name", S());
        h2.putExtra("amount", str3);
        h2.putExtra("is_from_mobile_number", this.aC);
        h2.putExtra("qrScanTime", this.bb);
        h2.putExtra("suggested_instrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().C);
        h2.putExtra("is_from_recent", this.bc);
        h2.putExtra("isAutoFlashTxn", this.bF);
        h2.putExtra("suggestedInstrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().C);
        h2.putExtra("isSingleAPI", this.bd);
        h2.putExtra("is_link_based_payment", this.aO);
        h2.putExtra("pay_mode_type", this.aR);
        h2.putExtra("pay_mode_load_time", this.aS);
        boolean z2 = true;
        h2.putExtra("is_amt_already_present", !TextUtils.isEmpty(this.n.getTxnAmount()));
        h2.putExtra("is_from_deeplink", this.bE);
        h2.putExtra("launchFrom", this.bQ);
        h2.putExtra("is_from_app_evoke", this.aD);
        CJRQRScanResultModel cJRQRScanResultModel = this.n;
        if (!(cJRQRScanResultModel == null || cJRQRScanResultModel.getJson() == null)) {
            h2.putExtra("scan_result", this.n.getJson().toString());
        }
        h2.putExtra("is_static_qr_code", m());
        InstrumentInfo instrumentInfo = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n;
        if (instrumentInfo != null && !TextUtils.isEmpty(instrumentInfo.getPayMode())) {
            h2.putExtra("used_instrument", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode());
            String payMode = instrumentInfo.getPayMode();
            String str5 = null;
            if (payMode.equalsIgnoreCase("UPI")) {
                str5 = instrumentInfo.getAccountNumber();
                h2.putExtra("payee_vpa", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().c().getMerchantVpa());
                h2.putExtra(UpiConstants.EXTRA_PAYER_VPA, instrumentInfo.getPaymentDetails());
            } else if (payMode.equalsIgnoreCase(SDKConstants.DEBIT)) {
                String paymentDetails = instrumentInfo.getPaymentDetails();
                if (!TextUtils.isEmpty(paymentDetails) && paymentDetails.contains("||")) {
                    str5 = paymentDetails.split("\\|")[0];
                }
                payMode = "SAVED_DC";
            } else if (payMode.equalsIgnoreCase(SDKConstants.CREDIT)) {
                String paymentDetails2 = instrumentInfo.getPaymentDetails();
                if (!TextUtils.isEmpty(paymentDetails2) && paymentDetails2.contains("||")) {
                    str5 = paymentDetails2.split("\\|")[0];
                }
                payMode = "SAVED_CC";
            } else {
                str5 = instrumentInfo.getPaymentDetails();
            }
            h2.putExtra("pay_mode", payMode);
            h2.putExtra("unique_identifier", str5);
        }
        if (!this.bf || this.bg.doubleValue() <= 0.0d) {
            h2.putExtra("is_pcf", true);
        } else {
            h2.putExtra("is_pcf", true);
            h2.putExtra("pcf_amount", this.bg);
        }
        if (this.aE != null) {
            z();
            h2.putExtras(this.aE);
        }
        if (TextUtils.isEmpty(this.n.getComment())) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.L.getText());
            str4 = sb.toString();
        } else {
            str4 = this.n.getComment();
        }
        h2.putExtra(CJRQRScanResultModel.KEY_COMMENT_SMALL, str4);
        h2.putExtra("paymentMode", "p2m");
        h2.putExtra("paymentType", "pay");
        if (!TextUtils.isEmpty(this.n.getTagLine())) {
            h2.putExtra("tagline", this.n.getTagLine());
        }
        h2.putExtra("order_id", str2);
        h2.putExtra("mid", str);
        h2.putExtra("is_offline_pg", true);
        h2.putExtra("merchant_logo", this.n.getLogoURL());
        h2.putExtra("backpress_offline_pg", false);
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null) {
            h2.putExtra("is_postpaid", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("PAYTM_DIGITAL_CREDIT"));
            h2.putExtra("is_upi", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("UPI"));
            h2.putExtra("is_ppb_transaction", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals(SDKConstants.AI_KEY_PPBL));
            if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase(SDKConstants.DEBIT) && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT)) {
                z2 = false;
            }
            h2.putExtra("is_card_transaction", z2);
            h2.putExtra("is_net_banking_transaction", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase("NET_BANKING"));
        }
        h2.setFlags(67108864);
        h2.putExtra("additonal_info", T());
        h2.putExtra("bundle", cJRProcessTranscationResponse);
        if (isAdded() && (activity = this.f51125f) != null && !activity.isFinishing()) {
            if (this.aD) {
                getActivity().startActivityForResult(h2, 2002);
                return;
            }
            startActivity(h2);
            getActivity().finish();
        }
    }

    private CJRRechargePayment a(RedirectForm redirectForm) {
        String str;
        CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
        HashMap hashMap = new HashMap();
        if (redirectForm.getContent() != null) {
            hashMap.putAll((Map) redirectForm.getContent());
        }
        hashMap.put("TXN_AMOUNT", ae());
        hashMap.put("name", S());
        if (TextUtils.isEmpty(this.n.getComment())) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.L.getText());
            str = sb.toString();
        } else {
            str = this.n.getComment();
        }
        hashMap.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, str);
        hashMap.put("phone_no", this.n.getMobileNo());
        cJRRechargePayment.setmPGParams(hashMap);
        cJRRechargePayment.setmMID(this.n.getMappingId());
        cJRRechargePayment.setmOrderId(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d());
        cJRRechargePayment.setmPGUrlToHit(redirectForm.getActionUrl());
        return cJRRechargePayment;
    }

    private void a(InstrumentInfo instrumentInfo, RedirectForm redirectForm) {
        CJRRechargePayment a2 = a(redirectForm);
        Activity activity = this.f51125f;
        if (activity != null && !activity.isFinishing() && !this.f51125f.isDestroyed() && isAdded()) {
            Intent rechargeActivityIntent = net.one97.paytm.wallet.communicator.b.a().getRechargeActivityIntent(this.f51125f);
            boolean z2 = true;
            rechargeActivityIntent.putExtra("intent_extra_is_offline_pg", true);
            rechargeActivityIntent.putExtra(SDKConstants.PAYMENT_INFO, a2);
            rechargeActivityIntent.putExtra("is_postpaid", instrumentInfo.getPayMode().equals("PAYTM_DIGITAL_CREDIT"));
            rechargeActivityIntent.putExtra("is_ppb_transaction", instrumentInfo.getPayMode().equals(SDKConstants.AI_KEY_PPBL));
            rechargeActivityIntent.putExtra("is_upi", instrumentInfo.getPayMode().equals("UPI"));
            if (!instrumentInfo.getPayMode().equals(SDKConstants.DEBIT) && !instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT)) {
                z2 = false;
            }
            rechargeActivityIntent.putExtra("is_card_transaction", z2);
            rechargeActivityIntent.putExtra("is_net_banking_transaction", instrumentInfo.getPayMode().equals("NET_BANKING"));
            rechargeActivityIntent.putExtra("is_from_app_evoke", this.aD);
            if (!TextUtils.isEmpty(instrumentInfo.getCardFirstSixDigit()) && !TextUtils.isEmpty(instrumentInfo.getCardLastFourDigit()) && !TextUtils.isEmpty(instrumentInfo.getExpiryDate()) && !TextUtils.isEmpty(this.bh)) {
                rechargeActivityIntent.putExtra("card_first_six_digit", instrumentInfo.getCardFirstSixDigit());
                rechargeActivityIntent.putExtra("card_last_four_digit", instrumentInfo.getCardLastFourDigit());
                rechargeActivityIntent.putExtra("card_expiry_date", instrumentInfo.getExpiryDate());
                rechargeActivityIntent.putExtra("one_click_info", this.bh);
            }
            startActivityForResult(rechargeActivityIntent, 1001);
            a(Boolean.TRUE);
        }
    }

    /* access modifiers changed from: private */
    public void a(Boolean bool) {
        if (bool.booleanValue()) {
            this.O.setEnabled(false);
            this.Y.setVisibility(8);
            this.bw.setVisibility(8);
            net.one97.paytm.common.widgets.a.a(this.av);
            this.aw.setVisibility(0);
            this.O.setBackgroundColor(this.f51126g.getResources().getColor(R.color.grid_offer_blue));
            return;
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().P = false;
        this.O.setEnabled(true);
        this.Y.setVisibility(0);
        net.one97.paytm.common.widgets.a.b(this.av);
        this.aw.setVisibility(8);
        this.O.setBackground(this.f51126g.getResources().getDrawable(R.drawable.rectangle_blue_filled));
    }

    public final void c(boolean z2) {
        a(Boolean.valueOf(z2));
    }

    public final void a(String str, boolean z2, boolean z3) {
        if (z3) {
            this.K.a(33);
            this.K.a(0, false);
        }
        this.aG.setVisibility(0);
        this.aF.a(str);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                g.this.aG.setVisibility(8);
            }
        }, 5000);
        if (TextUtils.isEmpty(e()) && z2) {
            this.k.requestFocus();
            X();
        }
    }

    public final String e() {
        CJRQRScanResultModel cJRQRScanResultModel = this.n;
        if (cJRQRScanResultModel == null) {
            return null;
        }
        return cJRQRScanResultModel.getTxnAmount();
    }

    public final void d(boolean z2) {
        this.az = z2;
    }

    public final net.one97.paytm.p2mNewDesign.b.a g() {
        return this.f51127h.g();
    }

    public final net.one97.paytm.p2mNewDesign.b.a h() {
        return this.f51127h.h();
    }

    public final void e(boolean z2) {
        CustomAmountAnimatedEditText customAmountAnimatedEditText = this.k;
        if (customAmountAnimatedEditText == null) {
            return;
        }
        if (z2) {
            customAmountAnimatedEditText.setFocusable(true);
            return;
        }
        A();
        this.k.clearFocus();
    }

    public final boolean i() {
        String[] split;
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f51126g, "offlinepg_emi_android_enable_logic");
        if (!(TextUtils.isEmpty(stringFromGTM) || (split = stringFromGTM.split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA)) == null || split.length == 0)) {
            if (!TextUtils.isEmpty(this.n.getQrCodeId()) && !TextUtils.isEmpty(this.n.getTxnAmount()) && split[0].equalsIgnoreCase("1")) {
                return true;
            }
            if (!TextUtils.isEmpty(this.n.getLinkType()) && !TextUtils.isEmpty(this.n.getTxnAmount()) && split.length > 1 && split[1].equalsIgnoreCase("1")) {
                return true;
            }
            if (!TextUtils.isEmpty(this.n.getQrCodeId()) && TextUtils.isEmpty(this.n.getTxnAmount()) && split.length > 2 && split[2].equalsIgnoreCase("1")) {
                return true;
            }
            if (!TextUtils.isEmpty(this.n.getLinkType()) && TextUtils.isEmpty(this.n.getTxnAmount()) && split.length > 3 && split[3].equalsIgnoreCase("1")) {
                return true;
            }
            if (this.bm && !TextUtils.isEmpty(this.n.getTxnAmount()) && split[0].equalsIgnoreCase("1")) {
                return true;
            }
            if (!this.bm || !TextUtils.isEmpty(this.n.getTxnAmount()) || split.length <= 2 || !split[2].equalsIgnoreCase("1")) {
                return false;
            }
            return true;
        }
        return false;
    }

    private void ao() {
        try {
            if (this.n.getJson() != null) {
                JSONObject json = this.n.getJson();
                this.l.setVisibility(0);
                this.aJ = net.one97.paytm.wallet.utility.a.n(json.toString());
                int i2 = AnonymousClass30.f51162a[this.aJ.ordinal()];
                if (i2 == 1) {
                    this.aH.setVisibility(8);
                } else if (i2 == 2) {
                    this.l.setVisibility(0);
                    ap();
                    this.aI.setImageDrawable(this.f51125f.getResources().getDrawable(R.drawable.ic_verified_p2m));
                } else if (i2 == 3) {
                    this.l.setVisibility(0);
                    ap();
                    this.aI.setImageDrawable(this.f51125f.getResources().getDrawable(R.drawable.ic_unverified_p2m));
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: net.one97.paytm.p2mNewDesign.d.g$30  reason: invalid class name */
    static /* synthetic */ class AnonymousClass30 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f51162a = new int[MerchantVerifedStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                net.one97.paytm.wallet.entity.MerchantVerifedStatus[] r0 = net.one97.paytm.wallet.entity.MerchantVerifedStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51162a = r0
                int[] r0 = f51162a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.wallet.entity.MerchantVerifedStatus r1 = net.one97.paytm.wallet.entity.MerchantVerifedStatus.MERCHANT_NO_STATUS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f51162a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.wallet.entity.MerchantVerifedStatus r1 = net.one97.paytm.wallet.entity.MerchantVerifedStatus.MERCHANT_VERIFED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f51162a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.wallet.entity.MerchantVerifedStatus r1 = net.one97.paytm.wallet.entity.MerchantVerifedStatus.MERCHANT_UNVERIFED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.g.AnonymousClass30.<clinit>():void");
        }
    }

    private void ap() {
        this.aH.setVisibility(0);
        this.aH.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.A();
                net.one97.paytm.upi.profile.view.h hVar = new net.one97.paytm.upi.profile.view.h();
                hVar.setCancelable(true);
                hVar.show(g.this.getActivity().getSupportFragmentManager(), "sheet");
            }
        });
    }

    private void aq() {
        double d2;
        double d3;
        if (!this.aN) {
            this.bA = false;
        }
        PaymentModesV2 e2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().e("BALANCE");
        if (e2 == null || e2.getPayChannelOptions() == null || e2.getPayChannelOptions().size() == 0 || e2.getPayChannelOptions().get(0).getBalanceInfo() == null || e2.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance() == null) {
            InstrumentInfo instrumentInfo = new InstrumentInfo();
            instrumentInfo.setPayMode("BALANCE");
            instrumentInfo.setDisplayPrimaryInfo(this.f51126g.getString(R.string.paytm_wallet));
            instrumentInfo.setDisplaySecondaryInfo(this.f51126g.getString(R.string.available_payable_balance));
            instrumentInfo.setWalletAPIFAIL(true);
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(this.f51126g, Double.valueOf(Double.NaN), Double.valueOf(Double.NaN));
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.setWalletAPIFAIL(true);
            return;
        }
        if (e2.getPayChannelOptions().get(0).getBalanceInfo().getSubWalletDetailV2() != null) {
            Iterator<SubWalletDetailV2> it2 = e2.getPayChannelOptions().get(0).getBalanceInfo().getSubWalletDetailV2().iterator();
            d3 = 0.0d;
            d2 = 0.0d;
            while (it2.hasNext()) {
                SubWalletDetailV2 next = it2.next();
                if ("Paytm Wallet".equalsIgnoreCase(next.getDisplayName())) {
                    d2 = n(next.getBalance());
                } else if ("Paytm Gift Voucher".equalsIgnoreCase(next.getDisplayName())) {
                    d3 = n(next.getBalance());
                }
            }
        } else {
            d2 = n(e2.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue());
            d3 = 0.0d;
        }
        double n2 = n(e2.getPayChannelOptions().get(0).getBalanceInfo().getAccountBalance().getValue());
        if (d3 > 0.0d) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b(this.f51126g, Double.valueOf(n2), Double.valueOf(d3));
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().w = true;
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b(this.f51126g, Double.valueOf(n2), Double.valueOf(d3));
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(this.f51126g, Double.valueOf(n2), Double.valueOf(d2));
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.setWalletAPIFAIL(false);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.setAllPaymodeFetched(true);
        this.q = Double.toString(n2);
        net.one97.paytm.wallet.utility.a.a((Context) getActivity(), n2);
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equals("BALANCE") && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c != null && !TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.getBalance())) {
            String ae2 = ae();
            if (TextUtils.isEmpty(ae2) || "0".equalsIgnoreCase(ae2)) {
                this.Y.setText(this.f51126g.getString(R.string.pay));
            } else if (Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.getTotalBalance()).doubleValue() < Double.valueOf(ae()).doubleValue()) {
                double doubleValue = Double.valueOf(ae()).doubleValue() - Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.getTotalBalance()).doubleValue();
                if (doubleValue > 0.0d && doubleValue < 1.0d) {
                    doubleValue = Math.ceil(doubleValue);
                }
                this.Y.setText(String.format(this.f51126g.getString(R.string.add_money_to_pay), new Object[]{h(new DecimalFormat("#0.00").format(doubleValue))}));
            } else {
                this.Y.setText(this.f51126g.getString(R.string.pay) + " " + this.f51126g.getString(R.string.rs_symbol) + " " + ae());
            }
        }
        this.T = false;
    }

    private static double n(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0d;
        }
        return Double.parseDouble(str);
    }

    public final boolean k() {
        return (getFragmentManager() == null || getFragmentManager().c("warning_alert") == null) ? false : true;
    }

    private void ar() {
        net.one97.paytm.p2mNewDesign.j.b bVar = this.f51127h;
        if (bVar == null) {
            this.f51127h = new net.one97.paytm.p2mNewDesign.j.b();
            net.one97.paytm.p2mNewDesign.j.b bVar2 = this.f51127h;
            bVar2.f13379g = this;
            this.al.addView(bVar2.a(this.f51125f, this, ae(), this.n.getMappingId(), K(), this.n.isPgEnabled()));
            if (this.n.isPgEnabled() && !this.ax && !this.ay) {
                b(false);
                return;
            }
            return;
        }
        bVar.b();
        if (this.n.isPgEnabled() && !this.ax && !this.ay) {
            b(false);
        }
    }

    public final void l() {
        final Context context = getContext();
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getResources().getString(R.string.no_connection));
            builder.setMessage(context.getResources().getString(R.string.no_internet));
            builder.setCancelable(false);
            builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    if (com.paytm.utility.b.c(context)) {
                        g.this.v();
                    } else {
                        g.this.l();
                    }
                }
            });
            builder.setNegativeButton(context.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (g.this.f51125f != null && !g.this.f51125f.isFinishing()) {
                        g.this.f51125f.finish();
                    }
                }
            });
            builder.show();
        }
    }

    private void as() {
        net.one97.paytm.b.a.e.a();
        if (!net.one97.paytm.b.a.e.f() || this.aM || this.aQ || this.bB) {
            ax();
        } else {
            ay();
        }
        N();
    }

    /* access modifiers changed from: private */
    public void at() {
        net.one97.paytm.p2mNewDesign.i.c cVar = this.aT;
        if (cVar != null) {
            cVar.f51300c.removeObservers(this);
        }
    }

    public final void c(String str) {
        if (this.f51128i != null && !TextUtils.isEmpty(str)) {
            this.f51128i.setVisibility(0);
            this.f51128i.setText(str);
        }
    }

    private void au() {
        StringBuilder sb;
        String str;
        String str2;
        boolean z2 = true;
        if (!this.n.isPgEnabled()) {
            b(true);
            return;
        }
        boolean z3 = !TextUtils.isEmpty(this.n.getMerchantTransId());
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept-Compression", "gzip");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            com.paytm.utility.b.A((Context) this.f51125f);
            String str3 = com.paytm.utility.b.v((Context) this.f51125f) + System.currentTimeMillis();
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13089e = this.n.getMappingId();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb2.toString());
            jSONObject2.put(StringSet.token, com.paytm.utility.a.q(getContext()));
            jSONObject2.put("tokenType", com.paytm.utility.b.a().toUpperCase());
            jSONObject2.put("version", net.one97.paytm.wallet.communicator.b.a().getVersionName());
            jSONObject2.put("channelId", "APP");
            jSONObject3.put("mid", this.n.getMappingId());
            if (z3) {
                z2 = false;
            }
            jSONObject3.put("generateOrderId", z2);
            jSONObject2.put("requestId", str3);
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13090f = ae();
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13088d = this.n.getMerchantTransId();
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
        } catch (JSONException unused) {
        }
        if (net.one97.paytm.wallet.utility.a.m(this.f51126g)) {
            sb = new StringBuilder();
            sb.append(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f51126g, "offlinePGFetchPayOptionsv2"));
            sb.append("?mid=");
            sb.append(this.n.getMappingId());
            if (z3) {
                str2 = "&orderId=" + this.n.getMerchantTransId();
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append("&device-id=");
            str = UpiUtils.getDeviceId(this.f51126g);
        } else {
            sb = new StringBuilder();
            sb.append(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f51126g, "offlinePGFetchPayOptions"));
            sb.append("?mid=");
            sb.append(this.n.getMappingId());
            if (z3) {
                str = "&orderId=" + this.n.getMerchantTransId();
            } else {
                str = "";
            }
        }
        sb.append(str);
        this.r = sb.toString();
        this.r = com.paytm.utility.b.e((Context) getActivity(), this.r);
        if (com.paytm.utility.b.c(getContext())) {
            new aq().a(getActivity(), this);
            net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(this.r, new CJRFetchPayMethodResponse(), (Map<String, String>) null, hashMap, jSONObject.toString());
            bVar.e();
            bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM((Context) this.f51125f, "payment_instrument_api_timeout")));
            bVar.c().observeForever(new z(jSONObject) {
                private final /* synthetic */ JSONObject f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    g.this.a(this.f$1, (net.one97.paytm.network.f) obj);
                }
            });
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", f51121a);
        hashMap2.put("mid", this.n.getMappingId());
        hashMap2.put("flowName", "requestForFetchMethods");
        net.one97.paytm.wallet.communicator.b.a().pushHawkeyeEvent(this.f51125f, -1, this.r, jSONObject.toString(), "Sorry,no internet connectivity detected.Please reconnect and try again", 0, a.b.USER_FACING, hashMap2, a.c.PAY);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13086b = "";
        l();
    }

    private static CJRFetchPayMethodResponse a(CJRFetchPayMethodResponse cJRFetchPayMethodResponse) {
        try {
            return (CJRFetchPayMethodResponse) net.one97.paytm.wallet.utility.a.a((Object) cJRFetchPayMethodResponse, CJRFetchPayMethodResponse.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean m() {
        CJRQRScanResultModel cJRQRScanResultModel = this.n;
        if (cJRQRScanResultModel != null) {
            return TextUtils.isEmpty(cJRQRScanResultModel.getMerchantTransId());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        y<net.one97.paytm.network.f> yVar;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (str.equalsIgnoreCase("emi")) {
            str2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getEmiType();
            str = SDKConstants.CREDIT;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            jSONObject2.put(SDKConstants.KEY_REQUEST_TIMESTAMP, sb.toString());
            jSONObject2.put(StringSet.token, com.paytm.utility.a.q(this.f51126g));
            jSONObject2.put("tokenType", com.paytm.utility.b.a().toUpperCase());
            jSONObject2.put("version", net.one97.paytm.wallet.communicator.b.a().getVersionName());
            jSONObject2.put("channelId", "APP");
            jSONObject3.put("mid", this.n.getMappingId());
            jSONObject3.put("txnAmount", str3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(SDKConstants.PAY_METHOD, str);
            jSONObject4.put(SDKConstants.INSTRUMENT_ID, str2);
            jSONObject3.put(SDKConstants.PAY_METHODS, new JSONArray().put(jSONObject4));
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
        } catch (JSONException unused) {
        }
        net.one97.paytm.network.b bVar = new net.one97.paytm.network.b(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f51125f, "walletFetchPcfUrl") + "mid=" + this.n.getMappingId(), new CJRPCFDetails(), (Map<String, String>) null, hashMap, jSONObject.toString());
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM((Context) this.f51125f, "checkBalanceAPITimeOut")));
        if (com.paytm.utility.b.c(this.f51126g)) {
            yVar = bVar.c();
        } else {
            yVar = net.one97.paytm.base.d.f49504d.a(this.f51126g, bVar);
        }
        if (yVar != null) {
            yVar.observeForever(new z(bVar) {
                private final /* synthetic */ net.one97.paytm.network.b f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    g.this.a(this.f$1, (net.one97.paytm.network.f) obj);
                }
            });
        }
    }

    public final void n() {
        LinearLayout linearLayout = this.aG;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void o() {
        A();
        net.one97.paytm.wallet.i.a.a aVar = new net.one97.paytm.wallet.i.a.a();
        Context context = this.f51126g;
        if (context != null && !((Activity) context).isFinishing()) {
            try {
                androidx.fragment.app.q a2 = getChildFragmentManager().a();
                a2.a((Fragment) aVar, (String) null);
                a2.c();
            } catch (Exception unused) {
            }
        }
    }

    public final void p() {
        A();
        net.one97.paytm.wallet.i.a.d dVar = new net.one97.paytm.wallet.i.a.d();
        Context context = this.f51126g;
        if (context != null && !((Activity) context).isFinishing()) {
            try {
                androidx.fragment.app.q a2 = getChildFragmentManager().a();
                a2.a((Fragment) dVar, (String) null);
                a2.c();
            } catch (Exception unused) {
            }
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equalsIgnoreCase("callSingleAPI") || str.equalsIgnoreCase("cashWalletAPICall") || str.equalsIgnoreCase("fetchPayOptionCall")) {
            if (com.paytm.utility.b.c(this.f51126g)) {
                v();
            }
        } else if (str.equalsIgnoreCase("fetchVPACall")) {
            au();
        }
    }

    public final boolean a(String str, Bundle bundle, NetworkCustomError networkCustomError) {
        return a(networkCustomError.getStatusCode(), networkCustomError, bundle, str);
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, String str) {
        if (z2) {
            this.ai.setText(str);
            this.ai.setVisibility(0);
            return;
        }
        this.ai.setText((CharSequence) null);
        this.ai.setVisibility(8);
    }

    public final void a(RetryInfo retryInfo) {
        if (retryInfo == null || TextUtils.isEmpty(retryInfo.getBlockerMessage())) {
            this.O.performClick();
            return;
        }
        c(false);
        h hVar = this.bq;
        if (hVar != null) {
            hVar.dismissAllowingStateLoss();
        }
        this.f51127h.f(retryInfo.getBlockerMessage());
    }

    public final void b(RetryInfo retryInfo) {
        c(false);
        h hVar = this.bq;
        if (hVar != null) {
            hVar.dismissAllowingStateLoss();
        }
        if (retryInfo != null && !TextUtils.isEmpty(retryInfo.getBlockerMessage())) {
            this.f51127h.f(retryInfo.getBlockerMessage());
        }
    }

    public final LiveData<net.one97.paytm.network.f> a(Context context, String str) {
        return net.one97.paytm.p2mNewDesign.i.a.a(context, str);
    }

    public final LiveData<net.one97.paytm.network.f> a(String str, Context context, String str2, boolean z2) {
        return net.one97.paytm.p2mNewDesign.i.a.a(str, context, str2, z2);
    }

    public final Activity q() {
        return this.f51125f;
    }

    public final void r() {
        Intent intent = new Intent();
        intent.putExtra("ADD_AND_PAY", false);
        intent.setComponent(new ComponentName(this.f51125f, NetBankingListActivity.class));
        startActivityForResult(intent, 1000);
    }

    public final void d(String str) {
        this.f51127h.d(str);
    }

    public final void s() {
        this.f51127h.f13378f.b();
    }

    public final boolean t() {
        return this.bA;
    }

    public final void f(boolean z2) {
        this.k.clearFocus();
        this.f51127h.f(z2);
    }

    public final void a(boolean z2) {
        c(z2);
    }

    public final void a(net.one97.paytm.network.g gVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_from_fragment", true);
        a("passcode_verification_api", bundle, gVar.f55801c);
    }

    private void av() {
        net.one97.paytm.wallet.dialog.a.b bVar = new net.one97.paytm.wallet.dialog.a.b(this.f51125f, R.style.Theme_ScanFirstTimeDialog, S(), net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode(), new net.one97.paytm.p2mNewDesign.f.c() {
            public final void a() {
                g.this.G();
            }

            public final void b() {
                g.this.c(false);
            }
        });
        bVar.setCanceledOnTouchOutside(false);
        bVar.show();
    }

    private void aw() {
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || !SDKConstants.CREDIT.equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode()) || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().v(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
            G();
        } else {
            av();
        }
    }

    public final void g(boolean z2) {
        this.f51127h.d(z2);
    }

    public final void v() {
        if (!TextUtils.isEmpty(this.n.getQrCodeId())) {
            net.one97.paytm.b.a.e.a();
            if (net.one97.paytm.b.a.e.f()) {
                HashMap hashMap = new HashMap();
                hashMap.put("ssotoken", com.paytm.utility.a.q(this.f51125f));
                hashMap.put("Content-Type", "application/json");
                net.one97.paytm.b.a.e.a();
                if (net.one97.paytm.b.a.e.d() != null) {
                    net.one97.paytm.b.a.e.a();
                    net.one97.paytm.b.a.e.d().removeObservers(this);
                }
                net.one97.paytm.b.a.e.a().a(this.f51125f, this.bD, this.n.getQrCodeId(), hashMap);
                ay();
                N();
                b(this.f51125f.getString(R.string.please_wait));
                return;
            }
        }
        if (!TextUtils.isEmpty(this.n.getMappingId())) {
            ax();
            b(this.f51125f.getString(R.string.please_wait));
            N();
        }
    }

    private void ax() {
        this.bd = false;
        e(com.paytm.utility.b.l((Context) this.f51125f));
        ac();
    }

    private void ay() {
        this.bd = true;
        if (com.paytm.utility.b.c(this.f51126g)) {
            this.bA = true;
            this.f51127h.b(true);
        }
        net.one97.paytm.b.a.e.a();
        net.one97.paytm.b.a.e.d().observe(getViewLifecycleOwner(), new z<net.one97.paytm.p2mNewDesign.models.c<Object>>() {
            /* renamed from: a */
            public final void onChanged(net.one97.paytm.p2mNewDesign.models.c<Object> cVar) {
                SingleAPIResponseV2 singleAPIResponseV2 = (SingleAPIResponseV2) cVar.f56936b;
                if (cVar.f56935a == net.one97.paytm.p2mNewDesign.models.d.SUCCESS) {
                    if (cVar != null && (cVar.f56936b instanceof SingleAPIResponseV2)) {
                        g.a(g.this, singleAPIResponseV2);
                        if (singleAPIResponseV2.getBody() != null && singleAPIResponseV2.getBody().getQrInfo() != null && !g.this.n.isPgEnabled()) {
                            CJRFetchPayMethodResponse cJRFetchPayMethodResponse = new CJRFetchPayMethodResponse();
                            cJRFetchPayMethodResponse.setBody(new BodyV2());
                            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(cJRFetchPayMethodResponse);
                            g gVar = g.this;
                            gVar.e(com.paytm.utility.b.l((Context) gVar.getActivity()));
                            g.this.b(true);
                            CJRQRInfoResponse qrInfo = singleAPIResponseV2.getBody().getQrInfo();
                            if (qrInfo.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                                JSONObject response = qrInfo.getResponse();
                                g.this.c(response.optString(CJRQRScanResultModel.KEY_TAG_LINE));
                                g.a(g.this, response);
                                g.b(g.this, response);
                                if (TextUtils.isEmpty(g.this.aR)) {
                                    String unused = g.this.aR = SDKConstants.KEY_API;
                                    g gVar2 = g.this;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(System.currentTimeMillis());
                                    String unused2 = gVar2.aS = sb.toString();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (singleAPIResponseV2.getBody() == null || singleAPIResponseV2.getBody().getQrInfo() == null || singleAPIResponseV2.getBody().getPaymentOptions() == null) {
                            net.one97.paytm.b.a.e.a();
                            net.one97.paytm.b.a.e.d().removeObserver(new z() {
                                public final void onChanged(Object obj) {
                                    g.AnonymousClass29.this.onChanged((net.one97.paytm.p2mNewDesign.models.c) obj);
                                }
                            });
                            net.one97.paytm.b.a.e.a().c();
                            return;
                        }
                    }
                    if (!(singleAPIResponseV2.getBody() == null || singleAPIResponseV2.getBody().getChannelPaymentDetails() == null || singleAPIResponseV2.getBody().getChannelPaymentDetails().getCart() == null)) {
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J = singleAPIResponseV2.getBody().getChannelPaymentDetails();
                    }
                    if (singleAPIResponseV2.getBody() != null) {
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().K = singleAPIResponseV2.getBody().getPaymentOptions().getNativeJsonRequestSupported();
                    }
                    boolean unused3 = g.this.aN = false;
                    g.this.at();
                    if (singleAPIResponseV2.getBody() == null || singleAPIResponseV2.getBody().getResultInfo() == null || TextUtils.isEmpty(singleAPIResponseV2.getBody().getResultInfo().getResultStatus()) || singleAPIResponseV2.getBody().getResultInfo().getResultStatus().equalsIgnoreCase(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.FEED_SUB_TYPE)) {
                        Toast.makeText(g.this.f51126g, singleAPIResponseV2.getBody().getQrInfo().getStatusMessage(), 0).show();
                        net.one97.paytm.b.a.e.a();
                        net.one97.paytm.b.a.e.d().removeObserver(new z() {
                            public final void onChanged(Object obj) {
                                g.AnonymousClass29.this.onChanged((net.one97.paytm.p2mNewDesign.models.c) obj);
                            }
                        });
                        net.one97.paytm.b.a.e.a().c();
                        return;
                    }
                    CJRQRInfoResponse qrInfo2 = singleAPIResponseV2.getBody().getQrInfo();
                    if (qrInfo2.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                        JSONObject response2 = qrInfo2.getResponse();
                        g.this.c(response2.optString(CJRQRScanResultModel.KEY_TAG_LINE));
                        g.a(g.this, response2);
                        g.b(g.this, response2);
                        CJRFetchPayMethodResponse cJRFetchPayMethodResponse2 = new CJRFetchPayMethodResponse();
                        cJRFetchPayMethodResponse2.setBody(singleAPIResponseV2.getBody().getPaymentOptions());
                        g.this.a((IJRPaytmDataModel) cJRFetchPayMethodResponse2);
                        if (TextUtils.isEmpty(g.this.aR)) {
                            String unused4 = g.this.aR = SDKConstants.KEY_API;
                            g gVar3 = g.this;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(System.currentTimeMillis());
                            String unused5 = gVar3.aS = sb2.toString();
                        }
                        net.one97.paytm.p2mNewDesign.models.b c2 = net.one97.paytm.p2mNewDesign.models.b.c();
                        if (c2.f56928b != null) {
                            Long valueOf = Long.valueOf(Calendar.getInstance().getTimeInMillis() - c2.f56928b.longValue());
                            new StringBuilder("Tbackend=").append(valueOf);
                            c2.f56927a.setTbackend(valueOf);
                        }
                        at.a().a(at.a.Tbackend, System.currentTimeMillis(), "success");
                        new StringBuilder("Instrument Displayed After API Response on Screen ").append(System.currentTimeMillis());
                    }
                } else if (cVar.f56935a == net.one97.paytm.p2mNewDesign.models.d.ERROR) {
                    NetworkCustomError networkCustomError = (NetworkCustomError) cVar.f56937c;
                    if (g.this.getActivity() != null && !g.this.getActivity().isFinishing()) {
                        if (g.this.f51127h != null) {
                            boolean unused6 = g.this.bA = false;
                            g.this.f51127h.b(false);
                        }
                        g.this.b(true);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("key_is_from_fragment", true);
                        g.this.a(networkCustomError.getStatusCode(), networkCustomError, bundle, "callSingleAPI");
                        at.a().a(at.a.Tpayment, System.currentTimeMillis(), ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                        new StringBuilder("Instrument Displayed After API Response on Screen ").append(System.currentTimeMillis());
                    } else {
                        return;
                    }
                }
                net.one97.paytm.b.a.e.a();
                net.one97.paytm.b.a.e.d().removeObserver(new z() {
                    public final void onChanged(Object obj) {
                        g.AnonymousClass29.this.onChanged((net.one97.paytm.p2mNewDesign.models.c) obj);
                    }
                });
                net.one97.paytm.b.a.e.a().c();
            }
        });
    }

    private void a(InstrumentInfo instrumentInfo) {
        String str;
        UpiProfileDefaultBank upiProfileDefaultBank;
        CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
        HashMap hashMap = new HashMap();
        hashMap.put("TXN_AMOUNT", ae());
        hashMap.put("CHANNEL_ID", SDKConstants.WAP);
        hashMap.put("AUTH_MODE", "3D");
        hashMap.put("INDUSTRY_TYPE_ID", SDKConstants.KEY_RETAIL);
        hashMap.put("MID", this.n.getMappingId());
        hashMap.put("REQUEST_TYPE", "OFFLINE");
        hashMap.put("SSO_TOKEN", com.paytm.utility.a.q(getContext()));
        hashMap.put(CJRPGTransactionRequestUtils.TOKEN_TYPE, SDKConstants.SSO);
        hashMap.put("WEBSITE", "retail");
        hashMap.put("ORDER_ID", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d());
        if (getArguments().getSerializable("extra_p2m_contact") == null) {
            hashMap.put(CJRPGTransactionRequestUtils.UDF_1, this.n.getPosId());
            hashMap.put(CJRPGTransactionRequestUtils.MERC_UNQ_REF, this.n.getQrCodeId());
        }
        hashMap.put(CJRPGTransactionRequestUtils.ADDITIONAL_INFO, T());
        hashMap.put("riskExtendedInfo", net.one97.paytm.f.b.a().e());
        hashMap.put("name", S());
        if (TextUtils.isEmpty(this.n.getComment())) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.L.getText());
            str = sb.toString();
        } else {
            str = this.n.getComment();
        }
        hashMap.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, str);
        hashMap.put("phone_no", this.n.getMobileNo());
        hashMap.put("paymentMode", "p2m");
        hashMap.put("paymentType", "pay");
        CJRLinkBasePaymentResponse cJRLinkBasePaymentResponse = this.ak;
        if (cJRLinkBasePaymentResponse != null && !v.a(cJRLinkBasePaymentResponse.linkDescription)) {
            hashMap.put("LINK_DESCRIPTION", this.ak.linkDescription);
        }
        if (!TextUtils.isEmpty(this.n.getTagLine())) {
            hashMap.put("tagline", this.n.getTagLine());
        }
        if (this.n.getLogoURL() != null) {
            hashMap.put("merchant_logo", this.n.getLogoURL());
        }
        String payMode = instrumentInfo.getPayMode();
        char c2 = 65535;
        boolean z2 = true;
        switch (payMode.hashCode()) {
            case -250353122:
                if (payMode.equals("PAYTM_DIGITAL_CREDIT")) {
                    c2 = 4;
                    break;
                }
                break;
            case 84238:
                if (payMode.equals("UPI")) {
                    c2 = 2;
                    break;
                }
                break;
            case 2462282:
                if (payMode.equals(SDKConstants.AI_KEY_PPBL)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1280945827:
                if (payMode.equals(SDKConstants.DEBIT)) {
                    c2 = 0;
                    break;
                }
                break;
            case 1878720662:
                if (payMode.equals(SDKConstants.CREDIT)) {
                    c2 = 1;
                    break;
                }
                break;
            case 2134027076:
                if (payMode.equals("NET_BANKING")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            hashMap.put("PAYMENT_TYPE_ID", instrumentInfo.getPaymentTypeId());
            hashMap.put("PAYMENT_DETAILS", instrumentInfo.getPaymentDetails());
            if (instrumentInfo.getmAdditionalParams() != null) {
                hashMap.put(CJRPGTransactionRequestUtils.STORE_CARD, instrumentInfo.getmAdditionalParams().optString(CJRPGTransactionRequestUtils.STORE_CARD, "0"));
                if (instrumentInfo.getmAdditionalParams().optString("addMoney") != null) {
                    hashMap.put("addMoney", instrumentInfo.getmAdditionalParams().optString("addMoney"));
                }
            }
        } else if (c2 != 1) {
            String str2 = CJRPGTransactionRequestUtils.INVOICE_ID;
            if (c2 == 2) {
                hashMap.put("PAYMENT_TYPE_ID", instrumentInfo.getPaymentTypeId());
                hashMap.put("PAYMENT_DETAILS", instrumentInfo.getPaymentDetails());
                if (!TextUtils.isEmpty(this.Q) && (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n instanceof UpiInstrumentInfo) && (upiProfileDefaultBank = (UpiProfileDefaultBank) ((UpiInstrumentInfo) net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n).getUpiDataModel()) != null && upiProfileDefaultBank.getDebitBank() != null) {
                    hashMap.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, upiProfileDefaultBank.getDebitBank().getAccRefId());
                    hashMap.put(CJRPGTransactionRequestUtils.PAYER_BANK_NAME, upiProfileDefaultBank.getDebitBank().getBank());
                    hashMap.put("MPIN", this.Q);
                    hashMap.put(CJRPGTransactionRequestUtils.UPI_SEQUENCE_NUM, this.R);
                    hashMap.put(CJRPGTransactionRequestUtils.PAYER_CREDS_ALLOWED, upiProfileDefaultBank.getDebitBank().getCredsAsJson());
                    hashMap.put("DEVICE_ID", UpiUtils.getDeviceId(this.f51126g));
                }
                String linkType = this.n.getLinkType();
                if (!TextUtils.isEmpty(linkType)) {
                    if (linkType.equalsIgnoreCase(net.one97.paytm.common.utility.j.FIXED.name()) || linkType.equalsIgnoreCase(net.one97.paytm.common.utility.j.GENERIC.name())) {
                        str2 = CJRPGTransactionRequestUtils.LINK_ID;
                    }
                    hashMap.put(str2, this.n.getId());
                }
                if (!(instrumentInfo.getmAdditionalParams() == null || instrumentInfo.getmAdditionalParams().optString("addMoney") == null)) {
                    hashMap.put("addMoney", instrumentInfo.getmAdditionalParams().optString("addMoney"));
                }
            } else if (c2 == 3) {
                hashMap.put("PAYMENT_TYPE_ID", "NB");
                hashMap.put("PAYMENT_DETAILS", instrumentInfo.getPaymentDetails());
                hashMap.put("BANK_CODE", SDKConstants.AI_KEY_PPBL);
                String linkType2 = this.n.getLinkType();
                if (!TextUtils.isEmpty(linkType2)) {
                    if (linkType2.equalsIgnoreCase(net.one97.paytm.common.utility.j.FIXED.name()) || linkType2.equalsIgnoreCase(net.one97.paytm.common.utility.j.GENERIC.name())) {
                        str2 = CJRPGTransactionRequestUtils.LINK_ID;
                    }
                    hashMap.put(str2, this.n.getId());
                }
                if (!(instrumentInfo.getmAdditionalParams() == null || instrumentInfo.getmAdditionalParams().optString("addMoney") == null)) {
                    hashMap.put("addMoney", instrumentInfo.getmAdditionalParams().optString("addMoney"));
                }
            } else if (c2 == 4) {
                hashMap.put("PAYMENT_TYPE_ID", instrumentInfo.getPayMode());
                hashMap.put("PAYMENT_DETAILS", instrumentInfo.getPaymentDetails());
                String linkType3 = this.n.getLinkType();
                if (!TextUtils.isEmpty(linkType3)) {
                    if (linkType3.equalsIgnoreCase(net.one97.paytm.common.utility.j.FIXED.name()) || linkType3.equalsIgnoreCase(net.one97.paytm.common.utility.j.GENERIC.name())) {
                        str2 = CJRPGTransactionRequestUtils.LINK_ID;
                    }
                    hashMap.put(str2, this.n.getId());
                }
            } else if (c2 == 5) {
                if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h) {
                    a("offline_payments", "post_scan_netbanking_payment", "flow_through_scan_icon", "", this.f51126g, ao);
                } else {
                    a("offline_payments", "post_scan_netbanking_payment", "flow_through_pay_icon", "", this.f51126g, ao);
                }
                hashMap.put("PAYMENT_TYPE_ID", instrumentInfo.getPaymentTypeId());
                hashMap.put("PAYMENT_DETAILS", instrumentInfo.getPaymentDetails());
                hashMap.put("BANK_CODE", instrumentInfo.getBankCode());
                if (!(instrumentInfo.getmAdditionalParams() == null || instrumentInfo.getmAdditionalParams().optString("addMoney") == null)) {
                    hashMap.put("addMoney", instrumentInfo.getmAdditionalParams().optString("addMoney"));
                }
            }
        } else {
            hashMap.put("PAYMENT_TYPE_ID", instrumentInfo.getPaymentTypeId());
            hashMap.put("PAYMENT_DETAILS", instrumentInfo.getPaymentDetails());
            if (instrumentInfo.getmAdditionalParams() != null) {
                hashMap.put(CJRPGTransactionRequestUtils.STORE_CARD, instrumentInfo.getmAdditionalParams().optString(CJRPGTransactionRequestUtils.STORE_CARD, "0"));
                if (instrumentInfo.getmAdditionalParams().optString("addMoney") != null) {
                    hashMap.put("addMoney", instrumentInfo.getmAdditionalParams().optString("addMoney"));
                }
            }
        }
        cJRRechargePayment.setmPGParams(hashMap);
        cJRRechargePayment.setmMID(this.n.getMappingId());
        cJRRechargePayment.setmOrderId(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d());
        String stringFromGTM = net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(getActivity(), "offline_pg_process_transaction_URL");
        cJRRechargePayment.setmPGUrlToHit(com.paytm.utility.b.e((Context) getActivity(), stringFromGTM + "?mid=" + net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13089e + "&orderId=" + net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d()));
        if (getActivity() != null && !getActivity().isFinishing()) {
            Intent rechargeActivityIntent = net.one97.paytm.wallet.communicator.b.a().getRechargeActivityIntent(getActivity());
            rechargeActivityIntent.putExtra("intent_extra_is_offline_pg", true);
            rechargeActivityIntent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
            rechargeActivityIntent.putExtra("is_postpaid", instrumentInfo.getPayMode().equals("PAYTM_DIGITAL_CREDIT"));
            rechargeActivityIntent.putExtra("is_ppb_transaction", instrumentInfo.getPayMode().equals(SDKConstants.AI_KEY_PPBL));
            rechargeActivityIntent.putExtra("is_upi", instrumentInfo.getPayMode().equals("UPI"));
            if (!instrumentInfo.getPayMode().equals(SDKConstants.DEBIT) && !instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT)) {
                z2 = false;
            }
            rechargeActivityIntent.putExtra("is_card_transaction", z2);
            rechargeActivityIntent.putExtra("is_net_banking_transaction", instrumentInfo.getPayMode().equals("NET_BANKING"));
            rechargeActivityIntent.putExtra("is_from_app_evoke", this.aD);
            UpiInstrumentInfo upiInstrumentInfo = new UpiInstrumentInfo();
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            upiInstrumentInfo.setUpiDataModel(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a((UpiProfileDefaultBank) ((UpiInstrumentInfo) instrumentInfo).getUpiDataModel()));
            rechargeActivityIntent.putExtra("user_upi_details", upiInstrumentInfo.getUpiDataModel());
            startActivityForResult(rechargeActivityIntent, 1001);
            a(Boolean.TRUE);
        }
    }

    public final void ae_() {
        a(Boolean.TRUE);
        W();
        R();
    }

    public final void u() {
        net.one97.paytm.n.g gVar;
        net.one97.paytm.n.c cVar = this.bG;
        net.one97.paytm.n.c cVar2 = cVar;
        if (cVar2.f55743a != null) {
            Activity activity = cVar.f55743a;
            if (activity == null) {
                k.a("activity");
            }
            cVar.f55746d = new c.C1041c(cVar, activity, cVar.f55745c);
        } else if (cVar2.f55744b != null) {
            Fragment fragment = cVar.f55744b;
            if (fragment == null) {
                k.a("fragment");
            }
            cVar.f55746d = new c.d(cVar, fragment, cVar.f55745c);
        }
        if (cVar2.f55746d != null) {
            net.one97.paytm.n.a aVar = cVar.f55746d;
            if (aVar == null) {
                k.a("controller");
            }
            net.one97.paytm.n.e eVar = net.one97.paytm.n.e.f55762a;
            if (!net.one97.paytm.n.a.a(net.one97.paytm.n.e.a())) {
                aVar.d();
                return;
            }
            aVar.f55738e = new net.one97.paytm.n.f(new a.d(aVar), aVar.f55737d);
            net.one97.paytm.n.a aVar2 = aVar;
            if (aVar2.f55734a != null) {
                net.one97.paytm.n.f fVar = aVar.f55738e;
                if (fVar != null) {
                    Activity activity2 = aVar.f55734a;
                    if (activity2 == null) {
                        k.a("activity");
                    }
                    fVar.a(activity2);
                    return;
                }
                return;
            }
            if (aVar2.f55735b != null) {
                Fragment fragment2 = aVar.f55735b;
                if (fragment2 == null) {
                    k.a("fragment");
                }
                if (fragment2.isAdded()) {
                    net.one97.paytm.n.f fVar2 = aVar.f55738e;
                    if (fVar2 != null) {
                        Fragment fragment3 = aVar.f55735b;
                        if (fragment3 == null) {
                            k.a("fragment");
                        }
                        fVar2.a(fragment3);
                        return;
                    }
                    return;
                }
            }
            net.one97.paytm.n.f fVar3 = aVar.f55738e;
            if (fVar3 != null && (gVar = fVar3.f55768a) != null) {
                gVar.b();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.b bVar, net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            net.one97.paytm.network.g gVar = fVar.f55798c;
            g.class.getSimpleName();
            q.d(gVar.f55801c.getMessage());
            if (gVar.f55801c.mErrorType == NetworkCustomError.ErrorType.TimeOutError) {
                a(Boolean.FALSE);
                a(bVar);
                return;
            }
            a(Boolean.FALSE);
            V();
            af();
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (!a(fVar.f55798c.f55799a, fVar.f55798c.f55801c, bundle, "pcfail_api")) {
                a(fVar.f55798c.f55801c);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(JSONObject jSONObject, net.one97.paytm.network.f fVar) {
        String str;
        String str2;
        net.one97.paytm.network.f fVar2 = fVar;
        long j2 = 0;
        if (fVar2.f55796a == net.one97.paytm.network.h.SUCCESS) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", f51121a);
            hashMap.put("mid", this.n.getMappingId());
            hashMap.put("flowName", "requestForFetchMethods_response_time");
            if (this.az) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.aA);
                hashMap.put("network_speed", sb.toString());
            }
            net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
            Activity activity = this.f51125f;
            String str3 = this.r;
            String jSONObject2 = jSONObject.toString();
            if (fVar2.f55797b.getNetworkResponse() != null) {
                j2 = fVar2.f55797b.getNetworkResponse().networkTimeMs;
            }
            a2.pushHawkeyeEvent(activity, 200, str3, jSONObject2, "Fetch Instrument received", j2, a.b.USER_FACING, hashMap, a.c.PAY);
            this.ay = true;
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().x = true;
            af();
            V();
            A();
            CJRFetchPayMethodResponse cJRFetchPayMethodResponse = (CJRFetchPayMethodResponse) fVar2.f55797b;
            b(true);
            if (cJRFetchPayMethodResponse == null) {
                ah();
                Context context = this.f51126g;
                Toast.makeText(context, context.getString(R.string.error_in_fetching_intrument_p2m_v1), 1).show();
                q.d("response is null and amount is reset");
                this.C = net.one97.paytm.wallet.utility.g.PAY_METHOD_SUCCESS.getValue();
            } else if (cJRFetchPayMethodResponse.getBody() == null) {
                ah();
                Toast.makeText(getActivity(), this.f51126g.getString(R.string.error_in_fetching_intrument_p2m_v1), 1).show();
                this.C = net.one97.paytm.wallet.utility.g.PAY_METHOD_SUCCESS.getValue();
                q.d("response  payview is null and amount is reset");
            } else if (cJRFetchPayMethodResponse.getBody().getResultInfo() == null || cJRFetchPayMethodResponse.getBody().getResultInfo().getResultStatus().equalsIgnoreCase(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.FEED_SUB_TYPE)) {
                ah();
                Context context2 = this.f51126g;
                Toast.makeText(context2, context2.getString(R.string.error_in_fetching_intrument_p2m_v1), 1).show();
                this.C = net.one97.paytm.wallet.utility.g.PAY_METHOD_SUCCESS.getValue();
                q.d("response  payview is null and amount is reset");
            } else if (cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getPaymentModes() == null) {
            } else {
                if (((cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra() != null && cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra().getResponse() != null) || (cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile() != null && cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile().getRespDetails() != null)) && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().z()) {
                    a(cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra(), cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile());
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUpiProfile(), cJRFetchPayMethodResponse.getBody().getMerchantPayOption().getUserProfileSarvatra());
                    TextView textView = this.Y;
                    CustomAmountAnimatedEditText customAmountAnimatedEditText = this.k;
                    if (customAmountAnimatedEditText == null || TextUtils.isEmpty(customAmountAnimatedEditText.getText().toString())) {
                        str2 = this.f51126g.getString(R.string.pay);
                    } else {
                        str2 = this.f51126g.getString(R.string.pay) + " " + this.k.getText().toString();
                    }
                    textView.setText(str2);
                    net.one97.paytm.p2mNewDesign.j.b bVar = this.f51127h;
                    if (bVar.f13373a != null) {
                        bVar.f13373a.removeAllViews();
                    }
                    this.f51127h.b();
                    this.f51127h.f13378f.e();
                    if (this.f51127h.f13378f.f("UPI")) {
                        this.O.performClick();
                    }
                }
            }
        } else if (fVar2.f55796a == net.one97.paytm.network.h.ERROR) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a((InstrumentInfo) null);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", f51121a);
            hashMap2.put("mid", this.n.getMappingId());
            hashMap2.put("flowName", "requestForFetchMethods_error_time");
            if (this.az) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.aA);
                hashMap2.put("network_speed", sb2.toString());
            }
            net.one97.paytm.wallet.communicator.c a3 = net.one97.paytm.wallet.communicator.b.a();
            Activity activity2 = this.f51125f;
            String str4 = this.r;
            String jSONObject3 = jSONObject.toString();
            if (fVar2.f55798c.f55801c == null) {
                str = "NA";
            } else {
                str = fVar2.f55798c.f55801c.getAlertMessage();
            }
            String str5 = str;
            if (!(fVar2.f55798c.f55801c == null || fVar2.f55798c.f55801c.networkResponse == null)) {
                j2 = fVar2.f55798c.f55801c.networkResponse.networkTimeMs;
            }
            a3.pushHawkeyeEvent(activity2, -1, str4, jSONObject3, str5, j2, a.b.USER_FACING, hashMap2, a.c.PAY);
            this.ax = true;
            this.ay = true;
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().x = false;
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            a(Boolean.FALSE);
            V();
            af();
            if (!a(fVar2.f55798c.f55799a, fVar2.f55798c.f55801c, bundle, "fetchVPACall")) {
                a(fVar2.f55798c.f55801c);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            V();
            a(Boolean.FALSE);
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            V();
            a(Boolean.FALSE);
            net.one97.paytm.wallet.i.a.c cVar = this.bk;
            if (cVar != null && cVar.isAdded()) {
                this.bk.dismissAllowingStateLoss();
            }
            if (fVar.f55798c.f55801c.mErrorType == NetworkCustomError.ErrorType.TimeOutError) {
                String mappingId = this.n.getMappingId();
                String d2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d();
                String d3 = d();
                CJRProcessTranscationResponse cJRProcessTranscationResponse = new CJRProcessTranscationResponse();
                cJRProcessTranscationResponse.setBody(new CJRProcessTranscationBody());
                cJRProcessTranscationResponse.getBody().setTxnInfo(new TxnInfo());
                cJRProcessTranscationResponse.getBody().setResultInfo(new CJRProcessTranscationResultInfo());
                cJRProcessTranscationResponse.setHead(new Head());
                cJRProcessTranscationResponse.getBody().getTxnInfo().setMID(mappingId);
                cJRProcessTranscationResponse.getBody().getTxnInfo().setORDERID(!TextUtils.isEmpty(d2) ? d2 : this.aV);
                cJRProcessTranscationResponse.getBody().getTxnInfo().setSTATUS("PENDING");
                cJRProcessTranscationResponse.getBody().getTxnInfo().setTXNAMOUNT(d3);
                a(d2, mappingId, d3, cJRProcessTranscationResponse);
                return;
            }
            a(Boolean.FALSE);
            V();
            af();
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (!a(fVar.f55798c.f55799a, fVar.f55798c.f55801c, bundle, "ptc_api_call")) {
                a(fVar.f55798c.f55801c);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", f51121a);
            hashMap.put("mid", this.n.getMappingId());
            hashMap.put("flowName", "Offline_Payments");
            if (this.az) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.aA);
                hashMap.put("network_speed", sb.toString());
            }
            this.ay = true;
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().x = true;
            this.aN = false;
            at();
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("screen_name", f51121a);
            hashMap2.put("mid", this.n.getMappingId());
            hashMap2.put("flowName", "Offline_Payments");
            if (this.az) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.aA);
                hashMap2.put("network_speed", sb2.toString());
            }
            this.ax = true;
            this.ay = true;
            a(Boolean.FALSE);
            V();
            af();
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().x = false;
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (!a(fVar.f55798c.f55799a, fVar.f55798c.f55801c, bundle, "fetchPayOptionCall")) {
                a(fVar.f55798c.f55801c);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(net.one97.paytm.network.f fVar) {
        CJRGoldPortfolio cJRGoldPortfolio;
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            if ((fVar.f55797b instanceof CJRGoldPortfolio) && (cJRGoldPortfolio = (CJRGoldPortfolio) fVar.f55797b) != null) {
                this.E = net.one97.paytm.jeweller.b.JEWELLER_SUCCESS.getValue();
                net.one97.paytm.jeweller.a.a(this.f51126g, "/digital_gold_offline/pay_screen", "digital_gold_offline", "gold_balance_strip_clicked", (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f() == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null) ? "" : net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getDisplayPrimaryInfo(), S(), com.paytm.utility.b.n(this.f51126g));
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13091g = S();
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                Context context = this.f51126g;
                if (f2.k == null) {
                    f2.k = new InstrumentInfo();
                    f2.k.setPayMode("Gold");
                    f2.k.setPaymentTypeId("Gold");
                    f2.k.setDisplayPrimaryInfo(context.getString(R.string.paytm_gold_wallet));
                    f2.a(context, cJRGoldPortfolio);
                }
                O();
            }
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            this.E = net.one97.paytm.jeweller.b.JEWELLER_FAIL.getValue();
            net.one97.paytm.network.g gVar = fVar.f55798c;
            int i2 = gVar.f55799a;
            NetworkCustomError networkCustomError = gVar.f55801c;
            if (!this.n.isPgEnabled()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("key_is_from_fragment", true);
                a(Boolean.FALSE);
                V();
                af();
                a(i2, networkCustomError, bundle, "gold_api_failed");
                if (this.C != net.one97.paytm.wallet.utility.g.PAY_METHOD_NOT_CALLED.getValue() && this.C != net.one97.paytm.wallet.utility.g.PAY_METHOD_FAIL.getValue() && this.D != net.one97.paytm.wallet.utility.i.UPI_NOT_CALLED.getValue()) {
                    ai();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            V();
            af();
            a(Boolean.FALSE);
            CJRGoldInitiate cJRGoldInitiate = (CJRGoldInitiate) fVar.f55797b;
            if (!TextUtils.isEmpty(cJRGoldInitiate.getError()) || cJRGoldInitiate.getStatus().intValue() != 200) {
                String error = cJRGoldInitiate.getError();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                if (!TextUtils.isEmpty((CharSequence) null)) {
                    builder.setTitle((CharSequence) null);
                }
                if (!TextUtils.isEmpty(error)) {
                    builder.setMessage(error);
                }
                builder.setCancelable(false);
                builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                    public final void onClick(
/*
Method generation error in method: net.one97.paytm.jeweller.a.2.onClick(android.content.DialogInterface, int):void, dex: classes3.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.jeweller.a.2.onClick(android.content.DialogInterface, int):void, class status: UNLOADED
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
                });
                builder.show();
                return;
            }
            cJRGoldInitiate.setLogoImage(this.n.getLogoURL());
            Intent intent = new Intent(getActivity(), AJRJewellerSummary.class);
            intent.putExtra("intent_gold_initiate", cJRGoldInitiate);
            startActivity(intent);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            a(Boolean.FALSE);
            V();
            af();
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (!a(fVar.f55798c.f55799a, fVar.f55798c.f55801c, bundle, "gold_transcation")) {
                a(fVar.f55798c.f55801c);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            this.aB = true;
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().w = true;
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            this.bA = false;
            this.f51127h.b(false);
            a(Boolean.FALSE);
            V();
            af();
            this.aB = true;
            g.class.getSimpleName();
            q.d(fVar.f55798c.f55801c.getMessage());
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (!a(fVar.f55798c.f55799a, fVar.f55798c.f55801c, bundle, "cashWalletAPICall")) {
                a(fVar.f55798c.f55801c);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(net.one97.paytm.network.f fVar) {
        if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
            a(fVar.f55797b);
        } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
            net.one97.paytm.network.g gVar = fVar.f55798c;
            g.class.getSimpleName();
            q.d(gVar.f55801c.getMessage());
            a(Boolean.FALSE);
            V();
            af();
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_from_fragment", true);
            if (!a(gVar.f55799a, gVar.f55801c, bundle, "make_convience_api_call")) {
                a(gVar.f55801c);
            }
        }
    }

    static /* synthetic */ String d(g gVar, String str) {
        BigDecimal bigDecimal = new BigDecimal(com.paytm.utility.b.Q(str));
        return new DecimalFormat(gVar.N + "##,##,##,##,###", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(bigDecimal);
    }

    static /* synthetic */ void J(g gVar) {
        net.one97.paytm.p2mNewDesign.g.c cVar = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H;
        if (!(gVar.bt == null || cVar == null || cVar.getTotalAvailableBalance() == null)) {
            gVar.bt.a(cVar.getTotalAvailableBalance());
        }
        gVar.bw.setVisibility(8);
    }

    static /* synthetic */ void b(g gVar, boolean z2) {
        Activity activity = gVar.f51125f;
        if (activity != null || !activity.isFinishing()) {
            gVar.bV = z2;
            if (gVar.f51126g != null) {
                gVar.a(Boolean.FALSE);
                net.one97.paytm.wallet.dialog.d dVar = new net.one97.paytm.wallet.dialog.d(gVar.f51126g, net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().J.getCart().getMLVInfo().getProvider(), net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H.getMerchantName(), z2, new d.a() {
                    public final void a(Dialog dialog) {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        g.this.bu.setVisibility(8);
                    }

                    public final void b(Dialog dialog) {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        g.this.bu.setVisibility(8);
                        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || !"BALANCE".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
                            g.this.al();
                        } else {
                            g.this.ak();
                        }
                        g.this.a(Boolean.TRUE);
                    }

                    public final void c(Dialog dialog) {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null || !"BALANCE".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) {
                            g.this.al();
                        } else {
                            g.this.ak();
                        }
                        g.this.a(Boolean.TRUE);
                    }

                    public final void d(Dialog dialog) {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().H.isChecked() && g.this.bt != null) {
                            g.this.bt.a();
                        }
                    }
                });
                dVar.setCanceledOnTouchOutside(false);
                dVar.show();
            }
        }
    }

    static /* synthetic */ void a(g gVar, SingleAPIResponseV2 singleAPIResponseV2) {
        if (singleAPIResponseV2.getBody() != null && singleAPIResponseV2.getBody().getQrInfo() != null) {
            CJRQRInfoResponse qrInfo = singleAPIResponseV2.getBody().getQrInfo();
            if (qrInfo.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                JSONObject response = qrInfo.getResponse();
                if (response.has(CJRQRScanResultModel.KEY_PG_ENABLED)) {
                    try {
                        gVar.n.setPgEnabled(response.getBoolean(CJRQRScanResultModel.KEY_PG_ENABLED));
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().O = response.getBoolean(CJRQRScanResultModel.KEY_PG_ENABLED);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(g gVar, JSONObject jSONObject) {
        String str;
        String txnAmount = gVar.n.getTxnAmount();
        String comment = gVar.n.getComment();
        try {
            gVar.n.parseData(jSONObject, gVar.f51126g);
            str = (String) jSONObject.get("qrCodeId");
            try {
                if (TextUtils.isEmpty(gVar.n.getQrCodeId())) {
                    gVar.n.setQrCodeId(str);
                }
                if (!TextUtils.isEmpty(txnAmount)) {
                    gVar.n.setmTxnAmount(txnAmount);
                }
                if (!TextUtils.isEmpty(comment)) {
                    gVar.n.setmComment(comment);
                }
                jSONObject.put(CJRQRScanResultModel.KEY_QR_CODE_ID, str);
            } catch (JSONException unused) {
            }
        } catch (JSONException unused2) {
            str = null;
        }
        net.one97.paytm.f.b.a().f50402a.setChannelIDV2(gVar.n.getChannelID());
        j.a().a(gVar.f51126g, jSONObject.toString(), str, 1, 2);
    }

    static /* synthetic */ void b(g gVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("TXN_AMOUNT");
            String optString2 = jSONObject.optString(CJRQRScanResultModel.KEY_COMMENT_SMALL);
            if (!TextUtils.isEmpty(optString)) {
                gVar.n.setJson(jSONObject);
                gVar.n.setmTxnAmount(optString);
                if (f(optString)) {
                    CustomAmountAnimatedEditText customAmountAnimatedEditText = gVar.k;
                    customAmountAnimatedEditText.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + " " + optString);
                    gVar.k.setEnabled(false);
                    if (gVar.bm) {
                        gVar.k.setEnabled(gVar.bH);
                    }
                }
            } else {
                try {
                    if (!TextUtils.isEmpty(gVar.n.getTxnAmount()) && f(gVar.n.getTxnAmount())) {
                        JSONObject json = gVar.n.getJson();
                        json.put("TXN_AMOUNT", gVar.n.getTxnAmount());
                        gVar.n.setJson(json);
                        CustomAmountAnimatedEditText customAmountAnimatedEditText2 = gVar.k;
                        customAmountAnimatedEditText2.setText(FilterPriceSliderFragment.RUPEE_SYMBOL + " " + gVar.n.getTxnAmount());
                        gVar.k.setEnabled(false);
                        if (gVar.bm) {
                            gVar.k.setEnabled(gVar.bH);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (!TextUtils.isEmpty(optString2) && TextUtils.isEmpty(gVar.n.getComment())) {
                gVar.n.setJson(jSONObject);
                gVar.L.setVisibility(0);
                gVar.aq.setVisibility(0);
                gVar.U.setVisibility(8);
                gVar.L.setText(optString2);
                gVar.L.setEnabled(false);
            }
        }
    }
}
