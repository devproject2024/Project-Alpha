package net.one97.paytm.p2mNewDesign.d;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.a.ae;
import kotlin.g.b.aa;
import kotlin.g.b.x;
import kotlin.x;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.replacement.CJRReplacementReason;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;
import net.one97.paytm.postpayment.models.CJRObdResponse;
import net.one97.paytm.postpayment.utils.WalletCircularProgressBar;
import net.one97.paytm.splitbill.SBMarkAsPaid;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel;
import net.one97.paytm.wallet.d.k;
import net.one97.paytm.wallet.newdesign.utils.RecentDataNetworkManager;
import net.one97.paytm.wallet.rateMerchant.b;
import net.one97.paytm.wallet.rateMerchant.entity.MerchantPPReviewData;

public final class e extends net.one97.paytm.base.b implements View.OnClickListener, net.one97.paytm.common.widgets.a.a, net.one97.paytm.m {
    /* access modifiers changed from: private */
    public static int aq;
    public static final a q = new a((byte) 0);
    private String A;
    private String B;
    private boolean C;
    private boolean D;
    private boolean E;
    /* access modifiers changed from: private */
    public boolean F = true;
    private boolean G;
    private boolean H;
    private String I;
    /* access modifiers changed from: private */
    public net.one97.paytm.common.widgets.c J;
    private boolean K;
    private boolean L;
    private String M;
    private double N;
    private net.one97.paytm.wallet.j.a O;
    private boolean P;
    private boolean Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private boolean V;
    private boolean W;
    private String X;
    private boolean Y;
    private String Z;

    /* renamed from: a  reason: collision with root package name */
    public String f51095a;
    private String aa;
    private boolean ab;
    private boolean ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private boolean ah;
    /* access modifiers changed from: private */
    public ChatPaymentIntegrationResponseModel ai;
    private String aj;
    private String ak;
    private boolean al;
    /* access modifiers changed from: private */
    public int am;
    /* access modifiers changed from: private */
    public net.one97.paytm.cashback.posttxn.e an;
    /* access modifiers changed from: private */
    public IStaticWidget ao;
    private final z<net.one97.paytm.network.f> ap = new k(this);
    private HashMap ar;

    /* renamed from: b  reason: collision with root package name */
    String f51096b;

    /* renamed from: c  reason: collision with root package name */
    Handler f51097c;

    /* renamed from: e  reason: collision with root package name */
    public String f51098e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f51099f;

    /* renamed from: g  reason: collision with root package name */
    public String f51100g;

    /* renamed from: h  reason: collision with root package name */
    public net.one97.paytm.p2mNewDesign.f.k f51101h;

    /* renamed from: i  reason: collision with root package name */
    public String f51102i;
    final Runnable j = new s(this);
    public String k;
    public boolean l;
    public int m;
    public int n = 1000;
    public Handler o;
    public Runnable p;
    private String r;
    private IJRDataModel s;
    private String t;
    private boolean u;
    private Bundle v;
    private String w;
    private String x;
    private String y;
    private Dialog z;

    public final View a(int i2) {
        if (this.ar == null) {
            this.ar = new HashMap();
        }
        View view = (View) this.ar.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.ar.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void c() {
        HashMap hashMap = this.ar;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    static final class c extends kotlin.g.b.l implements kotlin.g.a.b<Activity, x> {
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e eVar) {
            super(1);
            this.this$0 = eVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Activity) obj);
            return x.f47997a;
        }

        public final void invoke(Activity activity) {
            kotlin.g.b.k.c(activity, "it");
            net.one97.paytm.common.widgets.c h2 = this.this$0.J;
            if (h2 != null && h2.isAdded() && h2.isVisible()) {
                h2.dismissAllowingStateLoss();
            }
        }
    }

    static final class d<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f51104a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f51105b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f51106c;

        d(e eVar, String str, String str2) {
            this.f51104a = eVar;
            this.f51105b = str;
            this.f51106c = str2;
        }

        /* JADX WARNING: type inference failed for: r6v2, types: [com.paytm.network.model.NetworkCustomError$ErrorType] */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
            r1 = r9.getResponse();
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r9) {
            /*
                r8 = this;
                net.one97.paytm.network.f r9 = (net.one97.paytm.network.f) r9
                java.lang.String r0 = "networkResource"
                kotlin.g.b.k.c(r9, r0)
                net.one97.paytm.network.h r0 = r9.f55796a
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.SUCCESS
                java.lang.String r2 = "pending"
                r3 = 5000(0x1388, double:2.4703E-320)
                r5 = 5
                r6 = 0
                if (r0 != r1) goto L_0x01ab
                com.paytm.network.model.IJRPaytmDataModel r9 = r9.f55797b
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponse r9 = (net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponse) r9
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                if (r9 == 0) goto L_0x0026
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r1 = r9.getResponse()
                if (r1 == 0) goto L_0x0026
                java.lang.String r1 = r1.getPRN()
                goto L_0x0027
            L_0x0026:
                r1 = r6
            L_0x0027:
                r0.d((java.lang.String) r1)
                if (r9 == 0) goto L_0x0037
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r0 = r9.getResponse()
                if (r0 == 0) goto L_0x0037
                java.lang.String r0 = r0.getSTATUS()
                goto L_0x0038
            L_0x0037:
                r0 = r6
            L_0x0038:
                java.lang.String r1 = "TXN_SUCCESS"
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x007b
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r1 = r9.getResponse()
                java.lang.String r2 = "statusResponse.response"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                java.lang.String r1 = r1.getORDERID()
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r3 = r9.getResponse()
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)
                java.lang.String r2 = r3.getTXNID()
                r0.c(r1, r2)
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r9 = r9.getResponse()
                if (r9 == 0) goto L_0x007a
                java.lang.String r9 = r9.getPAYMENTMODE()
                if (r9 == 0) goto L_0x007a
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                java.lang.String r1 = "UPI"
                boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r1)
                if (r9 == 0) goto L_0x0075
                goto L_0x0077
            L_0x0075:
                java.lang.String r1 = "IMPS"
            L_0x0077:
                r0.h((java.lang.String) r1)
            L_0x007a:
                return
            L_0x007b:
                if (r9 == 0) goto L_0x0088
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r0 = r9.getResponse()
                if (r0 == 0) goto L_0x0088
                java.lang.String r0 = r0.getSTATUS()
                goto L_0x0089
            L_0x0088:
                r0 = r6
            L_0x0089:
                r1 = 1
                java.lang.String r7 = "FAILED"
                boolean r0 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r1)
                if (r0 != 0) goto L_0x0155
                if (r9 == 0) goto L_0x009f
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r0 = r9.getResponse()
                if (r0 == 0) goto L_0x009f
                java.lang.String r0 = r0.getSTATUS()
                goto L_0x00a0
            L_0x009f:
                r0 = r6
            L_0x00a0:
                java.lang.String r7 = "TXN_FAILURE"
                boolean r0 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r1)
                if (r0 == 0) goto L_0x00aa
                goto L_0x0155
            L_0x00aa:
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                net.one97.paytm.p2mNewDesign.d.e.a((net.one97.paytm.p2mNewDesign.d.e) r0, (net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponse) r9)
                int r0 = net.one97.paytm.p2mNewDesign.d.e.aq
                if (r0 <= r5) goto L_0x0145
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                android.view.View r0 = r0.getView()
                if (r0 == 0) goto L_0x00cc
                int r1 = net.one97.paytm.wallet.R.id.pb_pending
                android.view.View r0 = r0.findViewById(r1)
                net.one97.paytm.postpayment.utils.WalletCircularProgressBar r0 = (net.one97.paytm.postpayment.utils.WalletCircularProgressBar) r0
                if (r0 == 0) goto L_0x00cc
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r0)
            L_0x00cc:
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                android.view.View r0 = r0.getView()
                if (r0 == 0) goto L_0x00e3
                int r1 = net.one97.paytm.wallet.R.id.ic_payment_status
                android.view.View r0 = r0.findViewById(r1)
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                if (r0 == 0) goto L_0x00e3
                android.view.View r0 = (android.view.View) r0
                net.one97.paytm.wallet.rateMerchant.utils.b.a(r0)
            L_0x00e3:
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                android.view.View r0 = r0.getView()
                if (r0 == 0) goto L_0x0106
                int r1 = net.one97.paytm.wallet.R.id.ic_payment_status
                android.view.View r0 = r0.findViewById(r1)
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                if (r0 == 0) goto L_0x0106
                net.one97.paytm.p2mNewDesign.d.e r1 = r8.f51104a
                android.app.Activity r1 = net.one97.paytm.p2mNewDesign.d.e.c((net.one97.paytm.p2mNewDesign.d.e) r1)
                android.content.Context r1 = (android.content.Context) r1
                int r3 = net.one97.paytm.wallet.R.drawable.pending
                android.graphics.drawable.Drawable r1 = androidx.core.content.b.a((android.content.Context) r1, (int) r3)
                r0.setBackground(r1)
            L_0x0106:
                net.one97.paytm.p2mNewDesign.h.a r0 = net.one97.paytm.p2mNewDesign.h.a.f51295a
                net.one97.paytm.p2mNewDesign.h.a.a((java.lang.String) r2)
                if (r9 == 0) goto L_0x0118
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r0 = r9.getResponse()
                if (r0 == 0) goto L_0x0118
                java.lang.String r0 = r0.getRESPMSG()
                goto L_0x0119
            L_0x0118:
                r0 = r6
            L_0x0119:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0154
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                android.view.View r0 = r0.getView()
                if (r0 == 0) goto L_0x0144
                int r1 = net.one97.paytm.wallet.R.id.tv_status_desc
                android.view.View r0 = r0.findViewById(r1)
                android.widget.TextView r0 = (android.widget.TextView) r0
                if (r0 == 0) goto L_0x0144
                if (r9 == 0) goto L_0x013f
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r9 = r9.getResponse()
                if (r9 == 0) goto L_0x013f
                java.lang.String r6 = r9.getRESPMSG()
            L_0x013f:
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                r0.setText(r6)
            L_0x0144:
                return
            L_0x0145:
                android.os.Handler r9 = new android.os.Handler
                r9.<init>()
                net.one97.paytm.p2mNewDesign.d.e$d$1 r0 = new net.one97.paytm.p2mNewDesign.d.e$d$1
                r0.<init>(r8)
                java.lang.Runnable r0 = (java.lang.Runnable) r0
                r9.postDelayed(r0, r3)
            L_0x0154:
                return
            L_0x0155:
                if (r9 == 0) goto L_0x0162
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r0 = r9.getResponse()
                if (r0 == 0) goto L_0x0162
                java.lang.String r0 = r0.getRESPMSG()
                goto L_0x0163
            L_0x0162:
                r0 = r6
            L_0x0163:
                if (r9 == 0) goto L_0x0170
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r2 = r9.getResponse()
                if (r2 == 0) goto L_0x0170
                java.lang.String r2 = r2.getRESPCODE()
                goto L_0x0171
            L_0x0170:
                r2 = r6
            L_0x0171:
                java.lang.String r3 = "334"
                boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r3)
                if (r2 == 0) goto L_0x0182
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                int r1 = net.one97.paytm.wallet.R.string.orderId_is_invalid_msg
                java.lang.String r0 = r0.getString(r1)
                goto L_0x0199
            L_0x0182:
                r2 = r0
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                if (r2 == 0) goto L_0x018f
                int r2 = r2.length()
                if (r2 != 0) goto L_0x018e
                goto L_0x018f
            L_0x018e:
                r1 = 0
            L_0x018f:
                if (r1 == 0) goto L_0x0199
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                int r1 = net.one97.paytm.wallet.R.string.msg_post_payment_failed_msg
                java.lang.String r0 = r0.getString(r1)
            L_0x0199:
                net.one97.paytm.p2mNewDesign.d.e r1 = r8.f51104a
                if (r9 == 0) goto L_0x01a7
                net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r9 = r9.getResponse()
                if (r9 == 0) goto L_0x01a7
                java.lang.String r6 = r9.getRESPCODE()
            L_0x01a7:
                r1.a((java.lang.String) r6, (java.lang.String) r0)
                return
            L_0x01ab:
                net.one97.paytm.network.h r0 = r9.f55796a
                net.one97.paytm.network.h r1 = net.one97.paytm.network.h.ERROR
                if (r0 != r1) goto L_0x022b
                net.one97.paytm.network.g r9 = r9.f55798c
                if (r9 == 0) goto L_0x01bb
                com.paytm.network.model.NetworkCustomError r9 = r9.f55801c
                if (r9 == 0) goto L_0x01bb
                com.paytm.network.model.NetworkCustomError$ErrorType r6 = r9.mErrorType
            L_0x01bb:
                com.paytm.network.model.NetworkCustomError$ErrorType r9 = com.paytm.network.model.NetworkCustomError.ErrorType.TimeOutError
                if (r6 != r9) goto L_0x022b
                int r9 = net.one97.paytm.p2mNewDesign.d.e.aq
                if (r9 <= r5) goto L_0x021c
                net.one97.paytm.p2mNewDesign.d.e r9 = r8.f51104a
                android.view.View r9 = r9.getView()
                if (r9 == 0) goto L_0x01dc
                int r0 = net.one97.paytm.wallet.R.id.pb_pending
                android.view.View r9 = r9.findViewById(r0)
                net.one97.paytm.postpayment.utils.WalletCircularProgressBar r9 = (net.one97.paytm.postpayment.utils.WalletCircularProgressBar) r9
                if (r9 == 0) goto L_0x01dc
                android.view.View r9 = (android.view.View) r9
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r9)
            L_0x01dc:
                net.one97.paytm.p2mNewDesign.d.e r9 = r8.f51104a
                android.view.View r9 = r9.getView()
                if (r9 == 0) goto L_0x01f3
                int r0 = net.one97.paytm.wallet.R.id.ic_payment_status
                android.view.View r9 = r9.findViewById(r0)
                android.widget.ImageView r9 = (android.widget.ImageView) r9
                if (r9 == 0) goto L_0x01f3
                android.view.View r9 = (android.view.View) r9
                net.one97.paytm.wallet.rateMerchant.utils.b.a(r9)
            L_0x01f3:
                net.one97.paytm.p2mNewDesign.d.e r9 = r8.f51104a
                android.view.View r9 = r9.getView()
                if (r9 == 0) goto L_0x0216
                int r0 = net.one97.paytm.wallet.R.id.ic_payment_status
                android.view.View r9 = r9.findViewById(r0)
                android.widget.ImageView r9 = (android.widget.ImageView) r9
                if (r9 == 0) goto L_0x0216
                net.one97.paytm.p2mNewDesign.d.e r0 = r8.f51104a
                android.app.Activity r0 = net.one97.paytm.p2mNewDesign.d.e.c((net.one97.paytm.p2mNewDesign.d.e) r0)
                android.content.Context r0 = (android.content.Context) r0
                int r1 = net.one97.paytm.wallet.R.drawable.pending
                android.graphics.drawable.Drawable r0 = androidx.core.content.b.a((android.content.Context) r0, (int) r1)
                r9.setBackground(r0)
            L_0x0216:
                net.one97.paytm.p2mNewDesign.h.a r9 = net.one97.paytm.p2mNewDesign.h.a.f51295a
                net.one97.paytm.p2mNewDesign.h.a.a((java.lang.String) r2)
                return
            L_0x021c:
                android.os.Handler r9 = new android.os.Handler
                r9.<init>()
                net.one97.paytm.p2mNewDesign.d.e$d$2 r0 = new net.one97.paytm.p2mNewDesign.d.e$d$2
                r0.<init>(r8)
                java.lang.Runnable r0 = (java.lang.Runnable) r0
                r9.postDelayed(r0, r3)
            L_0x022b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.e.d.onChanged(java.lang.Object):void");
        }
    }

    static final class h extends kotlin.g.b.l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ View $view;
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(e eVar, View view) {
            super(1);
            this.this$0 = eVar;
            this.$view = view;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            kotlin.g.b.k.c(str, "it");
            TextView textView = (TextView) this.$view.findViewById(R.id.repeat_payment_tv);
            kotlin.g.b.k.a((Object) textView, "view.repeat_payment_tv");
            aa aaVar = aa.f47921a;
            String string = this.this$0.getString(R.string.pay_again_merchant);
            kotlin.g.b.k.a((Object) string, "getString(R.string.pay_again_merchant)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
            textView.setText(format);
            TextView textView2 = (TextView) this.$view.findViewById(R.id.tv_merchant_name);
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
    }

    static final class i extends kotlin.g.b.l implements kotlin.g.a.b<Activity, x> {
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(e eVar) {
            super(1);
            this.this$0 = eVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Activity) obj);
            return x.f47997a;
        }

        public final void invoke(Activity activity) {
            kotlin.g.b.k.c(activity, "it");
            this.this$0.J = new net.one97.paytm.common.widgets.c();
            net.one97.paytm.common.widgets.c h2 = this.this$0.J;
            if (h2 != null) {
                h2.a((net.one97.paytm.common.widgets.a.a) this.this$0);
            }
            net.one97.paytm.common.widgets.c h3 = this.this$0.J;
            if (h3 != null) {
                h3.show(this.this$0.getChildFragmentManager(), (String) null);
            }
        }
    }

    static final class j extends kotlin.g.b.l implements kotlin.g.a.b<Activity, x> {
        final /* synthetic */ String $category$inlined;
        final /* synthetic */ String $orderID$inlined;
        final /* synthetic */ String $txnId$inlined;
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(e eVar, String str, String str2, String str3) {
            super(1);
            this.this$0 = eVar;
            this.$txnId$inlined = str;
            this.$orderID$inlined = str2;
            this.$category$inlined = str3;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Activity) obj);
            return x.f47997a;
        }

        public final void invoke(Activity activity) {
            kotlin.g.b.k.c(activity, "activity");
            net.one97.paytm.cashback.posttxn.e g2 = this.this$0.an;
            if (g2 != null) {
                g2.a((AppCompatActivity) activity);
            }
            f.a aVar = new f.a();
            aVar.f49546b = this.$orderID$inlined;
            aVar.f49545a = this.$txnId$inlined;
            aVar.f49552h = this.$category$inlined;
            net.one97.paytm.cashback.posttxn.f a2 = aVar.a();
            net.one97.paytm.cashback.posttxn.e g3 = this.this$0.an;
            if (g3 != null) {
                g3.a(a2, (net.one97.paytm.cashback.posttxn.a) new net.one97.paytm.cashback.posttxn.a(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ j f51113a;

                    {
                        this.f51113a = r1;
                    }

                    public final void onAnimationEnd(String str) {
                        IStaticWidget f2;
                        kotlin.g.b.k.c(str, "s");
                        if (this.f51113a.this$0.ao != null && (f2 = this.f51113a.this$0.ao) != null) {
                            f2.AnimateView(str);
                        }
                    }

                    public final Point getFloatingWidgetPos(String str) {
                        IStaticWidget f2;
                        kotlin.g.b.k.c(str, "s");
                        if (this.f51113a.this$0.ao == null || (f2 = this.f51113a.this$0.ao) == null) {
                            return null;
                        }
                        return f2.getViewPoint(str);
                    }
                });
            }
        }
    }

    static final class k<T> implements z<net.one97.paytm.network.f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f51114a;

        k(e eVar) {
            this.f51114a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.network.f fVar = (net.one97.paytm.network.f) obj;
            if (fVar.f55796a == net.one97.paytm.network.h.SUCCESS) {
                this.f51114a.n();
                IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
                if (iJRPaytmDataModel != null) {
                    e eVar = this.f51114a;
                    kotlin.g.b.k.c(iJRPaytmDataModel, Payload.RESPONSE);
                    if (iJRPaytmDataModel instanceof CJRObdResponse) {
                        CJRObdResponse cJRObdResponse = (CJRObdResponse) iJRPaytmDataModel;
                        if (cJRObdResponse.getStatusCode() == null || !kotlin.m.p.a(cJRObdResponse.getStatusCode(), "SUCCESS", true)) {
                            Context context = eVar.getContext();
                            if (context != null) {
                                aa aaVar = aa.f47921a;
                                String string = eVar.getString(R.string.could_not_initiate);
                                kotlin.g.b.k.a((Object) string, "getString(R.string.could_not_initiate)");
                                String format = String.format(string, Arrays.copyOf(new Object[]{eVar.f51096b}, 1));
                                kotlin.g.b.k.a((Object) format, "java.lang.String.format(format, *args)");
                                new SpannableString(format).setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.brownish_grey)), 0, format.length(), 33);
                                return;
                            }
                            return;
                        }
                        Handler handler = eVar.f51097c;
                        if (handler != null) {
                            handler.removeCallbacks(eVar.j);
                        }
                    }
                }
            } else if (fVar.f55796a == net.one97.paytm.network.h.ERROR) {
                this.f51114a.n();
            }
        }
    }

    static final class l extends kotlin.g.b.l implements kotlin.g.a.b<Activity, x> {
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(e eVar) {
            super(1);
            this.this$0 = eVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Activity) obj);
            return x.f47997a;
        }

        public final void invoke(Activity activity) {
            kotlin.g.b.k.c(activity, "it");
            Intent intent = new Intent();
            intent.putExtra("chat_txn_response", this.this$0.ai);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    static final class m extends kotlin.g.b.l implements kotlin.g.a.b<Activity, x> {
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(e eVar) {
            super(1);
            this.this$0 = eVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Activity) obj);
            return x.f47997a;
        }

        public final void invoke(Activity activity) {
            kotlin.g.b.k.c(activity, "it");
            if (this.this$0.am == e.C0905e.PAY.getType()) {
                net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
                Intent b2 = net.one97.paytm.wallet.utility.d.b(e.c(this.this$0));
                b2.addFlags(603979776);
                activity.startActivity(b2);
                activity.finish();
                return;
            }
            net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
            kotlin.g.b.k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
            Intent intent = new Intent(activity, a2.getMainActivityClass());
            intent.addFlags(67108864);
            activity.startActivity(intent);
        }
    }

    static final class n extends kotlin.g.b.l implements kotlin.g.a.b<Activity, x> {
        public static final n INSTANCE = new n();

        n() {
            super(1);
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Activity) obj);
            return x.f47997a;
        }

        public final void invoke(Activity activity) {
            kotlin.g.b.k.c(activity, "it");
            net.one97.paytm.wallet.communicator.c a2 = net.one97.paytm.wallet.communicator.b.a();
            kotlin.g.b.k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
            activity.startActivity(new Intent(activity, a2.getTrustSealActivity()));
        }
    }

    static final class p<T> implements z<MerchantPPReviewData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f51116a;

        p(e eVar) {
            this.f51116a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            e.a(this.f51116a, (MerchantPPReviewData) obj);
        }
    }

    static final class q extends kotlin.g.b.l implements kotlin.g.a.b<Activity, x> {
        final /* synthetic */ float $rating;
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(e eVar, float f2) {
            super(1);
            this.this$0 = eVar;
            this.$rating = f2;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Activity) obj);
            return x.f47997a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
            r5 = r5.getView();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void invoke(android.app.Activity r5) {
            /*
                r4 = this;
                java.lang.String r0 = "it"
                kotlin.g.b.k.c(r5, r0)
                net.one97.paytm.p2mNewDesign.d.e r5 = r4.this$0
                net.one97.paytm.common.widgets.c r5 = r5.J
                r0 = 0
                if (r5 == 0) goto L_0x001b
                android.view.View r5 = r5.getView()
                if (r5 == 0) goto L_0x001b
                int r1 = net.one97.paytm.wallet.R.id.tv_msg
                android.view.View r5 = r5.findViewById(r1)
                goto L_0x001c
            L_0x001b:
                r5 = r0
            L_0x001c:
                java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
                if (r5 == 0) goto L_0x00cf
                android.widget.TextView r5 = (android.widget.TextView) r5
                net.one97.paytm.p2mNewDesign.d.e r2 = r4.this$0
                int r3 = net.one97.paytm.common.widgets.R.string.feedback_thanks_msg
                java.lang.String r2 = r2.getString(r3)
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r5.setText(r2)
                net.one97.paytm.p2mNewDesign.d.e r5 = r4.this$0
                net.one97.paytm.common.widgets.c r5 = r5.J
                if (r5 == 0) goto L_0x0044
                android.view.View r5 = r5.getView()
                if (r5 == 0) goto L_0x0044
                int r2 = net.one97.paytm.wallet.R.id.tv_sub_msg
                android.view.View r5 = r5.findViewById(r2)
                goto L_0x0045
            L_0x0044:
                r5 = r0
            L_0x0045:
                if (r5 == 0) goto L_0x00c9
                android.widget.TextView r5 = (android.widget.TextView) r5
                android.view.View r5 = (android.view.View) r5
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r5)
                net.one97.paytm.p2mNewDesign.d.e r5 = r4.this$0
                net.one97.paytm.common.widgets.c r5 = r5.J
                if (r5 == 0) goto L_0x0063
                android.view.View r5 = r5.getView()
                if (r5 == 0) goto L_0x0063
                int r1 = net.one97.paytm.wallet.R.id.iv_close_icon
                android.view.View r5 = r5.findViewById(r1)
                goto L_0x0064
            L_0x0063:
                r5 = r0
            L_0x0064:
                if (r5 == 0) goto L_0x00c1
                android.widget.ImageView r5 = (android.widget.ImageView) r5
                android.view.View r5 = (android.view.View) r5
                net.one97.paytm.wallet.rateMerchant.utils.b.b(r5)
                net.one97.paytm.p2mNewDesign.d.e r5 = r4.this$0
                net.one97.paytm.common.widgets.c r5 = r5.J
                if (r5 == 0) goto L_0x0081
                android.view.View r5 = r5.getView()
                if (r5 == 0) goto L_0x0081
                int r0 = net.one97.paytm.wallet.R.id.ratingBar
                android.view.View r0 = r5.findViewById(r0)
            L_0x0081:
                if (r0 == 0) goto L_0x00b9
                androidx.appcompat.widget.AppCompatRatingBar r0 = (androidx.appcompat.widget.AppCompatRatingBar) r0
                float r5 = r4.$rating
                r0.setRating(r5)
                android.os.Handler r5 = new android.os.Handler
                r5.<init>()
                net.one97.paytm.p2mNewDesign.d.e$q$1 r0 = new net.one97.paytm.p2mNewDesign.d.e$q$1
                net.one97.paytm.p2mNewDesign.d.e r1 = r4.this$0
                r0.<init>(r1)
                kotlin.g.a.a r0 = (kotlin.g.a.a) r0
                net.one97.paytm.p2mNewDesign.d.f r1 = new net.one97.paytm.p2mNewDesign.d.f
                r1.<init>(r0)
                java.lang.Runnable r1 = (java.lang.Runnable) r1
                net.one97.paytm.wallet.communicator.c r0 = net.one97.paytm.wallet.communicator.b.a()
                net.one97.paytm.p2mNewDesign.d.e r2 = r4.this$0
                android.app.Activity r2 = net.one97.paytm.p2mNewDesign.d.e.c((net.one97.paytm.p2mNewDesign.d.e) r2)
                android.content.Context r2 = (android.content.Context) r2
                java.lang.String r3 = "app_rating_thank_you_expire_time"
                java.lang.String r0 = r0.getStringFromGTM(r2, r3)
                long r2 = net.one97.paytm.wallet.utility.a.l((java.lang.String) r0)
                r5.postDelayed(r1, r2)
                return
            L_0x00b9:
                kotlin.u r5 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatRatingBar"
                r5.<init>(r0)
                throw r5
            L_0x00c1:
                kotlin.u r5 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type android.widget.ImageView"
                r5.<init>(r0)
                throw r5
            L_0x00c9:
                kotlin.u r5 = new kotlin.u
                r5.<init>(r1)
                throw r5
            L_0x00cf:
                kotlin.u r5 = new kotlin.u
                r5.<init>(r1)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.e.q.invoke(android.app.Activity):void");
        }
    }

    static final class r extends kotlin.g.b.l implements kotlin.g.a.b<Activity, x> {
        final /* synthetic */ long $mills;
        final /* synthetic */ e this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(e eVar, long j) {
            super(1);
            this.this$0 = eVar;
            this.$mills = j;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Activity) obj);
            return x.f47997a;
        }

        public final void invoke(final Activity activity) {
            kotlin.g.b.k.c(activity, "it");
            new Handler(activity.getMainLooper()).postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ r f51117a;

                {
                    this.f51117a = r1;
                }

                public final void run() {
                    LottieAnimationView lottieAnimationView;
                    LottieAnimationView lottieAnimationView2;
                    ImageView imageView;
                    ImageView imageView2;
                    View view = this.f51117a.this$0.getView();
                    if (!(view == null || (imageView2 = (ImageView) view.findViewById(R.id.ic_payment_status)) == null)) {
                        net.one97.paytm.wallet.rateMerchant.utils.b.a(imageView2);
                    }
                    View view2 = this.f51117a.this$0.getView();
                    if (!(view2 == null || (imageView = (ImageView) view2.findViewById(R.id.ic_payment_status)) == null)) {
                        imageView.setBackground(androidx.core.content.b.a((Context) activity, R.drawable.icon_ap_success));
                    }
                    View view3 = this.f51117a.this$0.getView();
                    if (!(view3 == null || (lottieAnimationView2 = (LottieAnimationView) view3.findViewById(R.id.success_animation)) == null)) {
                        net.one97.paytm.wallet.rateMerchant.utils.b.b(lottieAnimationView2);
                    }
                    View view4 = this.f51117a.this$0.getView();
                    if (view4 != null && (lottieAnimationView = (LottieAnimationView) view4.findViewById(R.id.success_animation)) != null) {
                        lottieAnimationView.cancelAnimation();
                    }
                }
            }, this.$mills);
        }
    }

    public static final /* synthetic */ Activity c(e eVar) {
        Activity activity = eVar.f51099f;
        if (activity == null) {
            kotlin.g.b.k.a("mActivity");
        }
        return activity;
    }

    static final class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f51119a;

        s(e eVar) {
            this.f51119a = eVar;
        }

        public final void run() {
            this.f51119a.F = false;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("data");
            if (!(serializable instanceof IJRDataModel)) {
                serializable = null;
            }
            this.s = (IJRDataModel) serializable;
            this.f51096b = arguments.getString("name", getString(R.string.receiver_name));
            this.x = arguments.getString("amount");
            this.w = arguments.getString(CJRQRScanResultModel.KEY_COMMENT_SMALL);
            this.B = arguments.getString("phone_no");
            this.y = arguments.getString("paymentMode");
            this.G = arguments.getBoolean("is_upi");
            this.H = arguments.getBoolean("is_from_deeplink");
            this.t = arguments.getString("pay_response");
            this.u = arguments.getBoolean("is_from_mobile_number");
            this.v = arguments.getBundle("sbBundle");
            this.aj = arguments.getString("payee_vpa", (String) null);
            this.ak = arguments.getString(UpiConstants.EXTRA_PAYER_VPA, (String) null);
            this.P = arguments.getBoolean("is_static_qr_code");
            this.R = arguments.getString("pay_mode", (String) null);
            this.S = arguments.getString("unique_identifier", "");
            this.f51102i = arguments.getString("mid");
            this.T = arguments.getString("scan_result");
            this.Q = arguments.getBoolean("is_link_based_payment");
            this.f51100g = arguments.getString("merchant_logo");
            this.V = arguments.getBoolean("is_from_recent", false);
            this.W = arguments.getBoolean("isAutoFlashTxn", false);
            this.U = arguments.getString("qrScanTime", "");
            this.X = arguments.getString("suggestedInstrument", "");
            this.Y = arguments.getBoolean("isSingleAPI", false);
            this.aa = arguments.getString("page_load_time", "");
            this.Z = arguments.getString("page_load_type", "");
            this.ab = arguments.getBoolean("is_amt_already_present", false);
            this.L = arguments.getBoolean("is_pcf", false);
            this.N = arguments.getDouble("pcf_amount", 0.0d);
            this.K = arguments.getBoolean("is_emi", false);
            this.M = arguments.getString("emi_message");
            this.ac = arguments.getBoolean("isMLVEnabledPayment", false);
            this.ae = arguments.getString("mlvOrderId");
            this.af = arguments.getString("mlvAmount");
            this.ag = arguments.getString("provider");
            this.ad = arguments.getString("mlvMyOrdersAPIUrl");
            this.k = arguments.getString("mlvMerchantName");
            this.ah = arguments.getBoolean("isFromAppEvoke", false);
            this.am = arguments.getInt("launchFrom", this.am);
            this.al = arguments.getBoolean("backpress_offline_pg");
        }
        PaymentInstrumentDatabase.a aVar = PaymentInstrumentDatabase.f51202a;
        Activity activity = this.f51099f;
        if (activity == null) {
            kotlin.g.b.k.a("mActivity");
        }
        Application application = activity.getApplication();
        kotlin.g.b.k.a((Object) application, "mActivity.application");
        PaymentInstrumentDatabase a2 = aVar.a(application);
        ao aoVar = this;
        Activity activity2 = this.f51099f;
        if (activity2 == null) {
            kotlin.g.b.k.a("mActivity");
        }
        Application application2 = activity2.getApplication();
        kotlin.g.b.k.a((Object) application2, "mActivity.application");
        ai a3 = new al(aoVar, (al.b) new net.one97.paytm.wallet.j.b(a2, application2)).a(net.one97.paytm.wallet.j.a.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProvider(this, …entViewModel::class.java)");
        this.O = (net.one97.paytm.wallet.j.a) a3;
    }

    public final void onAttach(Context context) {
        kotlin.g.b.k.c(context, "context");
        super.onAttach(context);
        this.f51099f = (Activity) context;
        this.f51101h = (net.one97.paytm.p2mNewDesign.f.k) context;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x0b71, code lost:
        if (r1.equals(r4) != false) goto L_0x0b7e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:423:0x0b7c, code lost:
        if (r1.equals(r7) != false) goto L_0x0b7e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:424:0x0b7e, code lost:
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:425:0x0b81, code lost:
        if (r1 == null) goto L_0x0b8c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:427:0x0b87, code lost:
        if (r1.length() != 0) goto L_0x0b8a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:428:0x0b8a, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:429:0x0b8c, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:430:0x0b8d, code lost:
        if (r1 == false) goto L_0x0b95;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:431:0x0b8f, code lost:
        r8 = getString(net.one97.paytm.wallet.R.string.payment_pending_desc_msg);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:432:0x0b95, code lost:
        r1 = r2.getBody();
        kotlin.g.b.k.a((java.lang.Object) r1, "ptcResponse.body");
        r1 = r1.getTxnInfo();
        kotlin.g.b.k.a((java.lang.Object) r1, "ptcResponse.body.txnInfo");
        r1 = r1.getORDERID();
        r9 = r2.getBody();
        kotlin.g.b.k.a((java.lang.Object) r9, "ptcResponse.body");
        r9 = r9.getTxnInfo();
        kotlin.g.b.k.a((java.lang.Object) r9, "ptcResponse.body.txnInfo");
        b(r1, r9.getMID(), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:495:0x0d8f, code lost:
        if (r1.equals(r7) != false) goto L_0x0d91;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:496:0x0d91, code lost:
        r3 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:497:0x0d94, code lost:
        if (r3 == null) goto L_0x0d9f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:499:0x0d9a, code lost:
        if (r3.length() != 0) goto L_0x0d9d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:501:0x0d9d, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:502:0x0d9f, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:503:0x0da0, code lost:
        if (r3 == false) goto L_0x0da8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:504:0x0da2, code lost:
        r8 = getString(net.one97.paytm.wallet.R.string.payment_pending_desc_msg);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x0da8, code lost:
        b(r2.optString("ORDERID"), r2.optString("MID"), r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0adc  */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x0c36 A[SYNTHETIC, Splitter:B:444:0x0c36] */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0cfa A[Catch:{ JSONException -> 0x0ded }] */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x0df2  */
    /* JADX WARNING: Removed duplicated region for block: B:526:0x0e32  */
    /* JADX WARNING: Removed duplicated region for block: B:527:0x0e34  */
    /* JADX WARNING: Removed duplicated region for block: B:529:0x0e37  */
    /* JADX WARNING: Removed duplicated region for block: B:551:0x0e9f  */
    /* JADX WARNING: Removed duplicated region for block: B:554:0x0efe  */
    /* JADX WARNING: Removed duplicated region for block: B:557:0x0f1d  */
    /* JADX WARNING: Removed duplicated region for block: B:589:0x100a  */
    /* JADX WARNING: Removed duplicated region for block: B:592:0x1022  */
    /* JADX WARNING: Removed duplicated region for block: B:595:0x1036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r44, android.os.Bundle r45) {
        /*
            r43 = this;
            r0 = r43
            r1 = r44
            java.lang.String r2 = "view"
            kotlin.g.b.k.c(r1, r2)
            super.onViewCreated(r44, r45)
            int r2 = net.one97.paytm.wallet.R.id.tv_rupee
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r3 = "tv_rupee"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.String r3 = "₹"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
            int r2 = net.one97.paytm.wallet.R.id.success_animation
            android.view.View r2 = r1.findViewById(r2)
            com.airbnb.lottie.LottieAnimationView r2 = (com.airbnb.lottie.LottieAnimationView) r2
            java.lang.String r3 = "payment-success.json"
            r2.setAnimation((java.lang.String) r3)
            int r2 = net.one97.paytm.wallet.R.id.success_animation
            android.view.View r2 = r1.findViewById(r2)
            com.airbnb.lottie.LottieAnimationView r2 = (com.airbnb.lottie.LottieAnimationView) r2
            java.lang.String r3 = "view.success_animation"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r4 = -1
            r2.setRepeatCount(r4)
            int r2 = net.one97.paytm.wallet.R.id.repeat_payment_view
            android.view.View r2 = r1.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            java.lang.String r4 = "view.repeat_payment_view"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r2)
            java.lang.String r2 = r0.f51096b
            net.one97.paytm.p2mNewDesign.d.e$h r4 = new net.one97.paytm.p2mNewDesign.d.e$h
            r4.<init>(r0, r1)
            kotlin.g.a.b r4 = (kotlin.g.a.b) r4
            java.lang.String r5 = "callback"
            kotlin.g.b.k.c(r4, r5)
            net.one97.paytm.base.d.b.a(r2, r4)
            int r2 = net.one97.paytm.wallet.R.id.rl_merchant_logo
            android.view.View r2 = r1.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            r2.bringToFront()
            net.one97.paytm.common.entity.IJRDataModel r2 = r0.s
            boolean r2 = r2 instanceof net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel
            if (r2 == 0) goto L_0x0095
            int r2 = net.one97.paytm.wallet.R.id.main_summary_rl
            android.view.View r2 = r1.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            java.lang.String r4 = "view.main_summary_rl"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r2)
            int r2 = net.one97.paytm.wallet.R.id.toolbar
            android.view.View r2 = r1.findViewById(r2)
            r4 = 0
            androidx.core.h.u.g((android.view.View) r2, (float) r4)
            goto L_0x00b6
        L_0x0095:
            boolean r2 = r0.ac
            if (r2 == 0) goto L_0x00b6
            int r2 = net.one97.paytm.wallet.R.id.main_summary_rl
            android.view.View r2 = r1.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            java.lang.String r4 = "view.main_summary_rl"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r2)
            int r2 = net.one97.paytm.wallet.R.id.toolbar
            android.view.View r2 = r1.findViewById(r2)
            r4 = 0
            androidx.core.h.u.g((android.view.View) r2, (float) r4)
        L_0x00b6:
            android.os.Bundle r2 = r43.getArguments()
            if (r2 != 0) goto L_0x00bf
            kotlin.g.b.k.a()
        L_0x00bf:
            r4 = 0
            java.lang.String r5 = "is_offline_pg"
            boolean r2 = r2.getBoolean(r5, r4)
            if (r2 == 0) goto L_0x00ec
            int r2 = net.one97.paytm.wallet.R.id.ic_payment_status
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            java.lang.String r5 = "view.ic_payment_status"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r2)
            int r2 = net.one97.paytm.wallet.R.id.success_animation
            android.view.View r2 = r1.findViewById(r2)
            com.airbnb.lottie.LottieAnimationView r2 = (com.airbnb.lottie.LottieAnimationView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r2)
            goto L_0x0117
        L_0x00ec:
            boolean r2 = r0.ac
            if (r2 == 0) goto L_0x0114
            int r2 = net.one97.paytm.wallet.R.id.ic_payment_status
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            java.lang.String r5 = "view.ic_payment_status"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r2)
            int r2 = net.one97.paytm.wallet.R.id.success_animation
            android.view.View r2 = r1.findViewById(r2)
            com.airbnb.lottie.LottieAnimationView r2 = (com.airbnb.lottie.LottieAnimationView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r2)
            goto L_0x0117
        L_0x0114:
            r43.d()
        L_0x0117:
            int r2 = net.one97.paytm.wallet.R.id.repeat_payment_view
            android.view.View r2 = r1.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            r3 = r0
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r2.setOnClickListener(r3)
            int r2 = net.one97.paytm.wallet.R.id.resend_confirmation_payment
            android.view.View r2 = r1.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            r2.setOnClickListener(r3)
            int r2 = net.one97.paytm.wallet.R.id.split_bill_view
            android.view.View r2 = r1.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            r2.setOnClickListener(r3)
            int r2 = net.one97.paytm.wallet.R.id.passbook_view
            android.view.View r2 = r1.findViewById(r2)
            android.widget.RelativeLayout r2 = (android.widget.RelativeLayout) r2
            r2.setOnClickListener(r3)
            int r2 = net.one97.paytm.wallet.R.id.iv_cross
            android.view.View r2 = r1.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r2.setOnClickListener(r3)
            int r2 = net.one97.paytm.wallet.R.id.tv_share
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r2.setOnClickListener(r3)
            android.os.Handler r2 = new android.os.Handler
            r2.<init>()
            r0.f51097c = r2
            android.os.Handler r2 = r0.f51097c
            if (r2 == 0) goto L_0x016f
            java.lang.Runnable r3 = r0.j
            r5 = 180000(0x2bf20, double:8.8932E-319)
            r2.postDelayed(r3, r5)
        L_0x016f:
            r43.f()
            boolean r2 = r0.K
            if (r2 == 0) goto L_0x01ac
            java.lang.String r2 = r0.M
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x01ac
            android.view.View r2 = r43.getView()
            if (r2 == 0) goto L_0x0195
            int r3 = net.one97.paytm.wallet.R.id.tv_pay_mode
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0195
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r2)
        L_0x0195:
            android.view.View r2 = r43.getView()
            if (r2 == 0) goto L_0x01ac
            int r3 = net.one97.paytm.wallet.R.id.tv_pay_mode
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x01ac
            java.lang.String r3 = r0.M
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.setText(r3)
        L_0x01ac:
            boolean r2 = r0.L
            r3 = 1
            if (r2 == 0) goto L_0x0205
            double r5 = r0.N
            r7 = 0
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0205
            android.view.View r2 = r43.getView()
            if (r2 == 0) goto L_0x01f0
            int r5 = net.one97.paytm.wallet.R.id.tv_pay_mode
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x01f0
            int r5 = net.one97.paytm.wallet.R.string.pcf_charged_message
            java.lang.String r5 = r0.getString(r5)
            java.lang.String r6 = "getString(R.string.pcf_charged_message)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.Object[] r6 = new java.lang.Object[r3]
            double r7 = r0.N
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r6[r4] = r7
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r3)
            java.lang.String r5 = java.lang.String.format(r5, r6)
            java.lang.String r6 = "java.lang.String.format(this, *args)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
        L_0x01f0:
            android.view.View r2 = r43.getView()
            if (r2 == 0) goto L_0x0205
            int r5 = net.one97.paytm.wallet.R.id.tv_pay_mode
            android.view.View r2 = r2.findViewById(r5)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0205
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r2)
        L_0x0205:
            java.lang.String r2 = r0.w
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x024e
            android.view.View r2 = r43.getView()
            if (r2 == 0) goto L_0x0224
            int r5 = net.one97.paytm.wallet.R.id.tv_comment
            android.view.View r2 = r2.findViewById(r5)
            com.paytm.utility.RoboTextView r2 = (com.paytm.utility.RoboTextView) r2
            if (r2 == 0) goto L_0x0224
            android.view.View r2 = (android.view.View) r2
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r2)
        L_0x0224:
            android.view.View r2 = r43.getView()
            if (r2 == 0) goto L_0x024e
            int r5 = net.one97.paytm.wallet.R.id.tv_comment
            android.view.View r2 = r2.findViewById(r5)
            com.paytm.utility.RoboTextView r2 = (com.paytm.utility.RoboTextView) r2
            if (r2 == 0) goto L_0x024e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "\" "
            r5.<init>(r6)
            java.lang.String r6 = r0.w
            r5.append(r6)
            java.lang.String r6 = " \""
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
        L_0x024e:
            net.one97.paytm.common.entity.IJRDataModel r2 = r0.s
            boolean r5 = r2 instanceof net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel
            java.lang.String r6 = "TXN_SUCCESS"
            java.lang.String r7 = "TXN_PENDING"
            java.lang.String r8 = "merchant"
            java.lang.String r9 = "PENDING"
            java.lang.String r10 = "mActivity"
            r11 = 0
            if (r5 == 0) goto L_0x042d
            if (r2 == 0) goto L_0x0425
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel r2 = (net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel) r2
            net.one97.paytm.common.entity.IJRDataModel r2 = (net.one97.paytm.common.entity.IJRDataModel) r2
            boolean r5 = r2 instanceof net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel
            if (r5 == 0) goto L_0x0417
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel r2 = (net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel) r2
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r5 = r2.getResponse()
            java.lang.String r12 = "sendMoneyResponse.response"
            if (r5 == 0) goto L_0x02ec
            java.lang.String r5 = r5.getWalletSystemTxnId()
            if (r5 == 0) goto L_0x02ec
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r5 = r2.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            java.lang.String r5 = r5.getWalletSystemTxnId()
            r0.f51095a = r5
            android.view.View r5 = r43.getView()
            if (r5 == 0) goto L_0x029c
            int r13 = net.one97.paytm.wallet.R.id.tv_order_id
            android.view.View r5 = r5.findViewById(r13)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x029c
            android.view.View r5 = (android.view.View) r5
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r5)
        L_0x029c:
            android.view.View r5 = r43.getView()
            if (r5 == 0) goto L_0x02d8
            int r13 = net.one97.paytm.wallet.R.id.tv_order_id
            android.view.View r5 = r5.findViewById(r13)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x02d8
            int r13 = net.one97.paytm.wallet.R.string.wallet_txn_id
            java.lang.String r13 = r0.getString(r13)
            java.lang.String r14 = "getString(R.string.wallet_txn_id)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            java.lang.Object[] r14 = new java.lang.Object[r3]
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r15 = r2.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r12)
            java.lang.String r15 = r15.getWalletSystemTxnId()
            r14[r4] = r15
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r3)
            java.lang.String r13 = java.lang.String.format(r13, r14)
            java.lang.String r14 = "java.lang.String.format(this, *args)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r5.setText(r13)
        L_0x02d8:
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r5 = r2.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            java.lang.String r5 = r5.getWalletSystemTxnId()
            java.lang.String r13 = r0.r
            r0.a((java.lang.String) r5, (java.lang.String) r11, (java.lang.String) r13)
            r43.j()
            goto L_0x0301
        L_0x02ec:
            android.view.View r5 = r43.getView()
            if (r5 == 0) goto L_0x0301
            int r13 = net.one97.paytm.wallet.R.id.tv_order_id
            android.view.View r5 = r5.findViewById(r13)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0301
            android.view.View r5 = (android.view.View) r5
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r5)
        L_0x0301:
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r5 = r2.getResponse()
            if (r5 == 0) goto L_0x031a
            java.lang.String r5 = r5.getPccCode()
            if (r5 == 0) goto L_0x031a
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r5 = r2.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            java.lang.String r5 = r5.getPccCode()
            r0.A = r5
        L_0x031a:
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r5 = r2.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            java.lang.String r5 = r5.getTimestamp()
            long r20 = r0.g((java.lang.String) r5)
            net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponse r5 = r2.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            java.lang.String r5 = r5.getTxnAmount()
            java.lang.String r5 = r0.f((java.lang.String) r5)
            r0.b((java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.f.k r12 = r0.f51101h
            if (r12 == 0) goto L_0x0342
            r12.c()
        L_0x0342:
            android.view.View r12 = r43.getView()
            if (r12 == 0) goto L_0x0364
            int r13 = net.one97.paytm.wallet.R.id.ic_payment_status
            android.view.View r12 = r12.findViewById(r13)
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x0364
            android.app.Activity r13 = r0.f51099f
            if (r13 != 0) goto L_0x0359
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x0359:
            android.content.Context r13 = (android.content.Context) r13
            int r14 = net.one97.paytm.wallet.R.drawable.payment_done_00048
            android.graphics.drawable.Drawable r13 = androidx.core.content.b.a((android.content.Context) r13, (int) r14)
            r12.setBackground(r13)
        L_0x0364:
            r43.d()
            android.view.View r12 = r43.getView()
            if (r12 == 0) goto L_0x0382
            int r13 = net.one97.paytm.wallet.R.id.tv_status_msg
            android.view.View r12 = r12.findViewById(r13)
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0382
            int r13 = net.one97.paytm.wallet.R.string.paid_successfully_to
            java.lang.String r13 = r0.getString(r13)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r12.setText(r13)
        L_0x0382:
            android.view.View r12 = r43.getView()
            if (r12 == 0) goto L_0x03a4
            int r13 = net.one97.paytm.wallet.R.id.tv_status_msg
            android.view.View r12 = r12.findViewById(r13)
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x03a4
            android.app.Activity r13 = r0.f51099f
            if (r13 != 0) goto L_0x0399
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x0399:
            android.content.Context r13 = (android.content.Context) r13
            int r14 = net.one97.paytm.wallet.R.color.black
            int r13 = androidx.core.content.b.c(r13, r14)
            r12.setTextColor(r13)
        L_0x03a4:
            r43.g()
            r43.h()
            net.one97.paytm.p2mNewDesign.h.a r12 = net.one97.paytm.p2mNewDesign.h.a.f51295a
            java.lang.String r12 = "success"
            net.one97.paytm.p2mNewDesign.h.a.a((java.lang.String) r12)
            r43.e()
            net.one97.paytm.p2mNewDesign.h.a r12 = net.one97.paytm.p2mNewDesign.h.a.f51295a
            android.app.Activity r12 = r0.f51099f
            if (r12 != 0) goto L_0x03be
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x03be:
            android.content.Context r12 = (android.content.Context) r12
            android.os.Bundle r13 = r43.getArguments()
            if (r13 != 0) goto L_0x03c9
            kotlin.g.b.k.a()
        L_0x03c9:
            java.lang.String r14 = "is_offline_pg"
            boolean r13 = r13.getBoolean(r14, r4)
            java.lang.String r14 = r0.x
            net.one97.paytm.p2mNewDesign.h.a.a((android.content.Context) r12, (boolean) r13, (java.lang.String) r14)
            net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel r12 = new net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel
            java.lang.String r13 = r2.getType()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x03e5
            java.lang.String r13 = "mode"
            goto L_0x03e9
        L_0x03e5:
            java.lang.String r13 = r2.getType()
        L_0x03e9:
            r14 = r13
            java.lang.String r13 = "if (TextUtils.isEmpty(se…se sendMoneyResponse.type"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r13)
            java.lang.String r15 = r0.aj
            r16 = 0
            java.lang.String r13 = r0.ak
            r18 = 0
            java.lang.String r2 = r2.getStatus()
            java.lang.String r11 = "sendMoneyResponse.status"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r11)
            r23 = 0
            java.lang.String r11 = r0.f51095a
            r25 = 0
            r26 = 0
            r17 = r13
            r13 = r12
            r19 = r5
            r22 = r2
            r24 = r11
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26)
            r0.ai = r12
        L_0x0417:
            net.one97.paytm.p2mNewDesign.h.a r2 = net.one97.paytm.p2mNewDesign.h.a.f51295a
            android.content.Context r2 = r43.getContext()
            java.lang.String r5 = r0.x
            net.one97.paytm.p2mNewDesign.h.a.a((android.content.Context) r2, (java.lang.String) r8, (java.lang.String) r5)
            r3 = r6
            goto L_0x0c31
        L_0x0425:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.common.entity.wallet.CJRSendMoneyToMerchantResponseModel"
            r1.<init>(r2)
            throw r1
        L_0x042d:
            boolean r5 = r2 instanceof net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse
            if (r5 == 0) goto L_0x0653
            if (r2 == 0) goto L_0x064b
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse r2 = (net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse) r2
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r5 = r2.getFastForwardResponseDetail()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head r11 = r2.getHead()
            java.lang.String r12 = "ffResponse.head"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            java.lang.String r11 = r11.getMid()
            r0.I = r11
            java.lang.String r11 = "fastForwardResponse"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r11)
            java.lang.String r11 = r5.getOrderId()
            r0.f51098e = r11
            java.lang.String r11 = r5.getTxnId()
            r0.f51095a = r11
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r11 = r5.getResultInfo()
            java.lang.String r13 = "fastForwardResponse.resultInfo"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r13)
            java.lang.String r11 = r11.getResultStatus()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r14 = r2.getFastForwardResponseDetail()
            java.lang.String r15 = "ffResponse.fastForwardResponseDetail"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)
            java.lang.String r14 = r14.getTxnAmount()
            java.lang.String r14 = r0.f((java.lang.String) r14)
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head r4 = r2.getHead()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r12)
            java.lang.String r4 = r4.getResponseTimestamp()
            long r23 = r0.g((java.lang.String) r4)
            java.lang.String r4 = r5.getOrderId()
            r0.c((java.lang.String) r4)
            r0.b((java.lang.String) r14)
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r4 = r2.getFastForwardResponseDetail()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r15)
            java.lang.String r4 = r4.getPrn()
            r0.d((java.lang.String) r4)
            boolean r4 = r0.Y
            java.lang.String r3 = r0.U
            java.lang.String r1 = r0.X
            r30 = r8
            java.lang.String r8 = r0.R
            r25 = r12
            boolean r12 = r0.V
            r26 = r13
            java.lang.String r13 = r0.Z
            r27 = r5
            java.lang.String r5 = r0.aa
            r31 = r6
            boolean r6 = r0.W
            r28 = r14
            r14 = r4
            r4 = r15
            r15 = r3
            r16 = r1
            r17 = r8
            r18 = r11
            r19 = r12
            r20 = r13
            r21 = r5
            r22 = r6
            java.lang.String r37 = net.one97.paytm.wallet.utility.a.a(r14, r15, r16, r17, r18, r19, r20, r21, r22)
            net.one97.paytm.wallet.communicator.c r32 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r1 = r0.f51099f
            if (r1 != 0) goto L_0x04da
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x04da:
            r33 = r1
            android.content.Context r33 = (android.content.Context) r33
            r34 = 200(0xc8, float:2.8E-43)
            r38 = 0
            com.paytm.network.a$b r40 = com.paytm.network.a.b.USER_FACING
            r41 = 0
            com.paytm.network.a$c r42 = com.paytm.network.a.c.PAYMENTS
            java.lang.String r35 = ""
            java.lang.String r36 = "NA"
            r32.pushHawkeyeEvent(r33, r34, r35, r36, r37, r38, r40, r41, r42)
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r1 = r2.getFastForwardResponseDetail()
            if (r1 == 0) goto L_0x0500
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r1 = r1.getResultInfo()
            if (r1 == 0) goto L_0x0500
            java.lang.String r1 = r1.getResultMsg()
            goto L_0x0501
        L_0x0500:
            r1 = 0
        L_0x0501:
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r11)
            if (r3 != 0) goto L_0x05d8
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r11)
            if (r3 == 0) goto L_0x050f
            goto L_0x05d8
        L_0x050f:
            r3 = r31
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r3)
            if (r5 == 0) goto L_0x05a3
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r5 = r2.getFastForwardResponseDetail()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            net.one97.paytm.common.entity.offline_pg.MerchantInfo r5 = r5.getMerchantInfo()
            if (r5 == 0) goto L_0x0594
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r5 = r2.getFastForwardResponseDetail()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            net.one97.paytm.common.entity.offline_pg.MerchantInfo r5 = r5.getMerchantInfo()
            java.lang.String r6 = "ffResponse.fastForwardResponseDetail.merchantInfo"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r5 = r5.getCurrentTxnCount()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x057e
            android.view.View r5 = r43.getView()
            if (r5 == 0) goto L_0x0555
            int r6 = net.one97.paytm.wallet.R.id.rl_txn_count
            android.view.View r5 = r5.findViewById(r6)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            if (r5 == 0) goto L_0x0555
            android.view.View r5 = (android.view.View) r5
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r5)
        L_0x0555:
            android.view.View r5 = r43.getView()
            if (r5 == 0) goto L_0x057e
            int r6 = net.one97.paytm.wallet.R.id.tv_txn_count
            android.view.View r5 = r5.findViewById(r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x057e
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r6 = r2.getFastForwardResponseDetail()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            net.one97.paytm.common.entity.offline_pg.MerchantInfo r6 = r6.getMerchantInfo()
            java.lang.String r8 = "ffResponse.fastForwardResponseDetail.merchantInfo"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            java.lang.String r6 = r6.getCurrentTxnCount()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
        L_0x057e:
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponseDetail r2 = r2.getFastForwardResponseDetail()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.common.entity.offline_pg.MerchantInfo r2 = r2.getMerchantInfo()
            java.lang.String r4 = "ffResponse.fastForwardResponseDetail.merchantInfo"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r2 = r2.getMccCode()
            r0.r = r2
        L_0x0594:
            java.lang.String r2 = r0.f51098e
            java.lang.String r4 = r27.getTxnId()
            r0.c(r2, r4)
            java.lang.String r2 = "WALLET"
            r0.h((java.lang.String) r2)
            goto L_0x05d3
        L_0x05a3:
            java.lang.String r2 = "TXN_FAILURE"
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x05d3
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x05b9
            int r2 = r2.length()
            if (r2 != 0) goto L_0x05b7
            goto L_0x05b9
        L_0x05b7:
            r2 = 0
            goto L_0x05ba
        L_0x05b9:
            r2 = 1
        L_0x05ba:
            if (r2 == 0) goto L_0x05c2
            int r1 = net.one97.paytm.wallet.R.string.msg_post_payment_failed_msg
            java.lang.String r1 = r0.getString(r1)
        L_0x05c2:
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r2 = r27.getResultInfo()
            r4 = r26
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.String r2 = r2.getResultCode()
            r0.a((java.lang.String) r2, (java.lang.String) r1)
            goto L_0x05d5
        L_0x05d3:
            r4 = r26
        L_0x05d5:
            r29 = r1
            goto L_0x0608
        L_0x05d8:
            r4 = r26
            r3 = r31
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x05ea
            int r5 = r5.length()
            if (r5 != 0) goto L_0x05e8
            goto L_0x05ea
        L_0x05e8:
            r5 = 0
            goto L_0x05eb
        L_0x05ea:
            r5 = 1
        L_0x05eb:
            if (r5 == 0) goto L_0x05f3
            int r1 = net.one97.paytm.wallet.R.string.payment_pending_desc_msg
            java.lang.String r1 = r0.getString(r1)
        L_0x05f3:
            java.lang.String r5 = r27.getOrderId()
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head r2 = r2.getHead()
            r6 = r25
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.String r2 = r2.getMid()
            r0.b((java.lang.String) r5, (java.lang.String) r2, (java.lang.String) r1)
            goto L_0x05d5
        L_0x0608:
            net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel r1 = new net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel
            java.lang.String r2 = r0.aj
            r19 = 0
            java.lang.String r5 = r0.ak
            r21 = 0
            net.one97.paytm.common.entity.offline_pg.paymethodresponse.ResultInfo r6 = r27.getResultInfo()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            java.lang.String r4 = r6.getResultStatus()
            java.lang.String r6 = "fastForwardResponse.resultInfo.resultStatus"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            r26 = 0
            java.lang.String r6 = r0.f51095a
            r8 = 0
            java.lang.String r17 = "BALANCE"
            r16 = r1
            r18 = r2
            r20 = r5
            r22 = r28
            r25 = r4
            r27 = r6
            r28 = r8
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29)
            r0.ai = r1
            net.one97.paytm.p2mNewDesign.h.a r1 = net.one97.paytm.p2mNewDesign.h.a.f51295a
            android.content.Context r1 = r43.getContext()
            java.lang.String r2 = r0.x
            r4 = r30
            net.one97.paytm.p2mNewDesign.h.a.a((android.content.Context) r1, (java.lang.String) r4, (java.lang.String) r2)
            goto L_0x0c31
        L_0x064b:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.common.entity.offline_pg.paymethodresponse.CJRFastForwardResponse"
            r1.<init>(r2)
            throw r1
        L_0x0653:
            r3 = r6
            r4 = r8
            boolean r1 = r2 instanceof net.one97.paytm.p2mNewDesign.entity.ShowCodePushModel
            if (r1 == 0) goto L_0x0946
            net.one97.paytm.p2mNewDesign.entity.ShowCodePushModel r2 = (net.one97.paytm.p2mNewDesign.entity.ShowCodePushModel) r2
            if (r2 == 0) goto L_0x0662
            java.lang.String r11 = r2.getOrderId()
            goto L_0x0663
        L_0x0662:
            r11 = 0
        L_0x0663:
            r0.f51098e = r11
            if (r2 == 0) goto L_0x066c
            java.lang.String r11 = r2.getTxnId()
            goto L_0x066d
        L_0x066c:
            r11 = 0
        L_0x066d:
            r0.f51095a = r11
            if (r2 == 0) goto L_0x0676
            java.lang.String r11 = r2.getMerchantLogoUrl()
            goto L_0x0677
        L_0x0676:
            r11 = 0
        L_0x0677:
            r0.f51100g = r11
            r43.f()
            java.lang.String r1 = r0.f51098e
            r0.c((java.lang.String) r1)
            if (r2 == 0) goto L_0x0688
            java.lang.String r11 = r2.getTimeStamp()
            goto L_0x0689
        L_0x0688:
            r11 = 0
        L_0x0689:
            r0.g((java.lang.String) r11)
            if (r2 == 0) goto L_0x0693
            java.lang.String r11 = r2.getAmount()
            goto L_0x0694
        L_0x0693:
            r11 = 0
        L_0x0694:
            r0.b((java.lang.String) r11)
            if (r2 == 0) goto L_0x0713
            java.lang.String r1 = r2.paymentMode
            if (r1 == 0) goto L_0x0713
            net.one97.paytm.p2mNewDesign.h.a r4 = net.one97.paytm.p2mNewDesign.h.a.f51295a
            android.app.Activity r4 = r0.f51099f
            if (r4 != 0) goto L_0x06a6
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x06a6:
            java.lang.String r1 = net.one97.paytm.p2mNewDesign.h.a.a((android.app.Activity) r4, (java.lang.String) r1)
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x06fe
            android.view.View r4 = r43.getView()
            if (r4 == 0) goto L_0x06c8
            int r5 = net.one97.paytm.wallet.R.id.tv_pay_mode
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x06c8
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r4)
        L_0x06c8:
            android.view.View r4 = r43.getView()
            if (r4 == 0) goto L_0x0713
            int r5 = net.one97.paytm.wallet.R.id.tv_pay_mode
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0713
            kotlin.g.b.aa r5 = kotlin.g.b.aa.f47921a
            int r5 = net.one97.paytm.wallet.R.string.silent_push_message
            java.lang.String r5 = r0.getString(r5)
            java.lang.String r6 = "getString(R.string.silent_push_message)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r6 = 1
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r11 = 0
            r8[r11] = r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r8, r6)
            java.lang.String r1 = java.lang.String.format(r5, r1)
            java.lang.String r5 = "java.lang.String.format(format, *args)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r4.setText(r1)
            goto L_0x0713
        L_0x06fe:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x0713
            int r4 = net.one97.paytm.wallet.R.id.tv_pay_mode
            android.view.View r1 = r1.findViewById(r4)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0713
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r1)
        L_0x0713:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x0730
            int r4 = net.one97.paytm.wallet.R.id.tv_merchant_name
            android.view.View r1 = r1.findViewById(r4)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0730
            if (r2 == 0) goto L_0x072a
            java.lang.String r11 = r2.getMerchantName()
            goto L_0x072b
        L_0x072a:
            r11 = 0
        L_0x072b:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r11)
        L_0x0730:
            if (r2 == 0) goto L_0x0737
            java.lang.String r11 = r2.getStatus()
            goto L_0x0738
        L_0x0737:
            r11 = 0
        L_0x0738:
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r9)
            if (r1 == 0) goto L_0x081e
            r1 = 1
            r0.C = r1
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x075c
            int r2 = net.one97.paytm.wallet.R.id.tv_status_msg
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x075c
            int r2 = net.one97.paytm.wallet.R.string.payment_pending
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x075c:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x077e
            int r2 = net.one97.paytm.wallet.R.id.tv_status_msg
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x077e
            android.app.Activity r2 = r0.f51099f
            if (r2 != 0) goto L_0x0773
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x0773:
            android.content.Context r2 = (android.content.Context) r2
            int r4 = net.one97.paytm.wallet.R.color.color_ffa400
            int r2 = androidx.core.content.b.c(r2, r4)
            r1.setTextColor(r2)
        L_0x077e:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x0799
            int r2 = net.one97.paytm.wallet.R.id.tv_status_desc
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0799
            int r2 = net.one97.paytm.wallet.R.string.payment_pending_desc_msg
            java.lang.String r2 = r0.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x0799:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x07bb
            int r2 = net.one97.paytm.wallet.R.id.tv_status_desc
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x07bb
            android.app.Activity r2 = r0.f51099f
            if (r2 != 0) goto L_0x07b0
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x07b0:
            android.content.Context r2 = (android.content.Context) r2
            int r4 = net.one97.paytm.wallet.R.color.color_fdfbd3
            int r2 = androidx.core.content.b.c(r2, r4)
            r1.setBackgroundColor(r2)
        L_0x07bb:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x07d0
            int r2 = net.one97.paytm.wallet.R.id.tv_status_desc
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x07d0
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r1)
        L_0x07d0:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x07e5
            int r2 = net.one97.paytm.wallet.R.id.ic_payment_status
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x07e5
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r1)
        L_0x07e5:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x07fa
            int r2 = net.one97.paytm.wallet.R.id.success_animation
            android.view.View r1 = r1.findViewById(r2)
            com.airbnb.lottie.LottieAnimationView r1 = (com.airbnb.lottie.LottieAnimationView) r1
            if (r1 == 0) goto L_0x07fa
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r1)
        L_0x07fa:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x0c31
            int r2 = net.one97.paytm.wallet.R.id.ic_payment_status
            android.view.View r1 = r1.findViewById(r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0c31
            android.app.Activity r2 = r0.f51099f
            if (r2 != 0) goto L_0x0811
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x0811:
            android.content.Context r2 = (android.content.Context) r2
            int r4 = net.one97.paytm.wallet.R.drawable.ic_pending_copy
            android.graphics.drawable.Drawable r2 = androidx.core.content.b.a((android.content.Context) r2, (int) r4)
            r1.setBackground(r2)
            goto L_0x0c31
        L_0x081e:
            if (r2 == 0) goto L_0x0825
            java.lang.String r11 = r2.getStatus()
            goto L_0x0826
        L_0x0825:
            r11 = 0
        L_0x0826:
            java.lang.String r1 = "SUCCESS"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x090d
            r1 = 1
            r0.E = r1
            r1 = 0
            r0.C = r1
            r0.D = r1
            net.one97.paytm.wallet.communicator.c r11 = net.one97.paytm.wallet.communicator.b.a()
            android.content.Context r12 = r43.getContext()
            java.lang.String r13 = net.one97.paytm.common.utility.d.bE
            r17 = 0
            r18 = 0
            java.lang.String r14 = "Payment_success"
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            java.lang.String r19 = "Confirmation Screen"
            java.lang.String r20 = "offline_payments"
            r11.sendNewCustomGTMEvents(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x086c
            int r4 = net.one97.paytm.wallet.R.id.tv_status_msg
            android.view.View r1 = r1.findViewById(r4)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x086c
            int r4 = net.one97.paytm.wallet.R.string.paid_successfully_to
            java.lang.String r4 = r0.getString(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
        L_0x086c:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x088e
            int r4 = net.one97.paytm.wallet.R.id.tv_status_msg
            android.view.View r1 = r1.findViewById(r4)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x088e
            android.app.Activity r4 = r0.f51099f
            if (r4 != 0) goto L_0x0883
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x0883:
            android.content.Context r4 = (android.content.Context) r4
            int r5 = net.one97.paytm.wallet.R.color.black
            int r4 = androidx.core.content.b.c(r4, r5)
            r1.setTextColor(r4)
        L_0x088e:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x08a3
            int r4 = net.one97.paytm.wallet.R.id.ic_payment_status
            android.view.View r1 = r1.findViewById(r4)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x08a3
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r1)
        L_0x08a3:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x08b8
            int r4 = net.one97.paytm.wallet.R.id.success_animation
            android.view.View r1 = r1.findViewById(r4)
            com.airbnb.lottie.LottieAnimationView r1 = (com.airbnb.lottie.LottieAnimationView) r1
            if (r1 == 0) goto L_0x08b8
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r1)
        L_0x08b8:
            net.one97.paytm.p2mNewDesign.f.k r1 = r0.f51101h
            if (r1 == 0) goto L_0x08bf
            r1.c()
        L_0x08bf:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x08e1
            int r4 = net.one97.paytm.wallet.R.id.ic_payment_status
            android.view.View r1 = r1.findViewById(r4)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x08e1
            android.app.Activity r4 = r0.f51099f
            if (r4 != 0) goto L_0x08d6
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x08d6:
            android.content.Context r4 = (android.content.Context) r4
            int r5 = net.one97.paytm.wallet.R.drawable.payment_done_00048
            android.graphics.drawable.Drawable r4 = androidx.core.content.b.a((android.content.Context) r4, (int) r5)
            r1.setBackground(r4)
        L_0x08e1:
            r43.d()
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x08f9
            int r4 = net.one97.paytm.wallet.R.id.tv_status_desc
            android.view.View r1 = r1.findViewById(r4)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x08f9
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.b(r1)
        L_0x08f9:
            java.lang.String r1 = r2.getTxnId()
            if (r1 == 0) goto L_0x0905
            java.lang.String r2 = r0.r
            r4 = 0
            r0.a((java.lang.String) r1, (java.lang.String) r4, (java.lang.String) r2)
        L_0x0905:
            r43.g()
            r43.h()
            goto L_0x0c31
        L_0x090d:
            if (r2 == 0) goto L_0x0914
            java.lang.String r11 = r2.getStatus()
            goto L_0x0915
        L_0x0914:
            r11 = 0
        L_0x0915:
            java.lang.String r1 = "FAILURE"
            r2 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r11, (java.lang.String) r1, (boolean) r2)
            if (r1 == 0) goto L_0x0c31
            int r1 = net.one97.paytm.wallet.R.string.payment_failed_wallet
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = "SHOWCODE_ERROR"
            r0.a((java.lang.String) r2, (java.lang.String) r1)
            net.one97.paytm.wallet.communicator.c r11 = net.one97.paytm.wallet.communicator.b.a()
            android.content.Context r12 = r43.getContext()
            java.lang.String r13 = net.one97.paytm.common.utility.d.bE
            r17 = 0
            r18 = 0
            java.lang.String r14 = "Payment_failed"
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            java.lang.String r19 = "Confirmation Screen"
            java.lang.String r20 = "offline_payments"
            r11.sendNewCustomGTMEvents(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x0c31
        L_0x0946:
            boolean r1 = r2 instanceof net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse
            if (r1 == 0) goto L_0x0c31
            if (r2 == 0) goto L_0x0c29
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse r2 = (net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse) r2
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            java.lang.String r5 = "ptcResponse.body"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r1 = r1.getTxnInfo()
            java.lang.String r6 = "ptcResponse.body.txnInfo"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r1 = r1.getMID()
            r0.I = r1
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r1 = r1.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r1 = r1.getORDERID()
            r0.f51098e = r1
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r1 = r1.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r1 = r1.getSTATUS()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r8 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r8 = r8.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            java.lang.String r8 = r8.getORDERID()
            r0.c((java.lang.String) r8)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r8 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r8 = r8.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            java.lang.String r8 = r8.getTXNAMOUNT()
            r0.b((java.lang.String) r8)
            net.one97.paytm.p2mNewDesign.entity.Head r8 = r2.getHead()
            java.lang.String r11 = "ptcResponse.head"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r11)
            java.lang.String r8 = r8.getResponseTimestamp()
            long r20 = r0.g((java.lang.String) r8)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r8 = r2.getBody()
            if (r8 == 0) goto L_0x09d9
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResultInfo r8 = r8.getResultInfo()
            if (r8 == 0) goto L_0x09d9
            java.lang.String r11 = r8.getResultMsg()
            r8 = r11
            goto L_0x09da
        L_0x09d9:
            r8 = 0
        L_0x09da:
            boolean r11 = r0.Y
            java.lang.String r12 = r0.U
            java.lang.String r13 = r0.X
            java.lang.String r14 = r0.R
            boolean r15 = r0.V
            r30 = r4
            java.lang.String r4 = r0.Z
            r25 = r7
            java.lang.String r7 = r0.aa
            r26 = r9
            boolean r9 = r0.W
            r16 = r15
            r15 = r1
            r17 = r4
            r18 = r7
            r19 = r9
            java.lang.String r36 = net.one97.paytm.wallet.utility.a.a(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            net.one97.paytm.wallet.communicator.c r31 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r4 = r0.f51099f
            if (r4 != 0) goto L_0x0a08
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x0a08:
            r32 = r4
            android.content.Context r32 = (android.content.Context) r32
            r33 = 200(0xc8, float:2.8E-43)
            r37 = 0
            com.paytm.network.a$b r39 = com.paytm.network.a.b.USER_FACING
            r40 = 0
            com.paytm.network.a$c r41 = com.paytm.network.a.c.PAYMENTS
            java.lang.String r34 = ""
            java.lang.String r35 = "NA"
            r31.pushHawkeyeEvent(r32, r33, r34, r35, r36, r37, r39, r40, r41)
            if (r1 != 0) goto L_0x0a20
            goto L_0x0a27
        L_0x0a20:
            int r4 = r1.hashCode()
            switch(r4) {
                case -1882253182: goto L_0x0b74;
                case 35394935: goto L_0x0b69;
                case 1228132078: goto L_0x0a69;
                case 2008727669: goto L_0x0a2d;
                default: goto L_0x0a27;
            }
        L_0x0a27:
            r7 = r25
            r4 = r26
            goto L_0x0bbc
        L_0x0a2d:
            java.lang.String r4 = "TXN_FAILURE"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0a27
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0a43
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0a41
            goto L_0x0a43
        L_0x0a41:
            r1 = 0
            goto L_0x0a44
        L_0x0a43:
            r1 = 1
        L_0x0a44:
            if (r1 == 0) goto L_0x0a4c
            int r1 = net.one97.paytm.wallet.R.string.msg_post_payment_failed_msg
            java.lang.String r8 = r0.getString(r1)
        L_0x0a4c:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r1 = r1.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r1 = r1.getRESPCODE()
            r0.a((java.lang.String) r1, (java.lang.String) r8)
            r24 = r8
            r7 = r25
            r4 = r26
            goto L_0x0bbe
        L_0x0a69:
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0a27
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            if (r1 == 0) goto L_0x0a91
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r1 = r1.getTxnInfo()
            if (r1 == 0) goto L_0x0a91
            java.lang.String r1 = r1.getPAYMENTMODE()
            if (r1 == 0) goto L_0x0a91
            java.lang.String r4 = "UPI"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r4)
            if (r1 == 0) goto L_0x0a8c
            java.lang.String r1 = "UPI"
            goto L_0x0a8e
        L_0x0a8c:
            java.lang.String r1 = "IMPS"
        L_0x0a8e:
            r0.h((java.lang.String) r1)
        L_0x0a91:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            if (r1 == 0) goto L_0x0ad2
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            if (r1 == 0) goto L_0x0aa2
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r11 = r1.getTxnInfo()
            goto L_0x0aa3
        L_0x0aa2:
            r11 = 0
        L_0x0aa3:
            if (r11 == 0) goto L_0x0ad2
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r1 = r1.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r1 = r1.getADDITIONAL_PARAM()
            java.lang.String r4 = "ptcResponse.body.txnInfo.additionaL_PARAM"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r4 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r4 = r4.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r4 = r4.getPRN()
            r0.d((java.lang.String) r4)
            goto L_0x0ad4
        L_0x0ad2:
            java.lang.String r1 = ""
        L_0x0ad4:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L_0x0a27
            kotlin.m.l r4 = new kotlin.m.l
            java.lang.String r7 = "\\\\"
            r4.<init>((java.lang.String) r7)
            java.lang.String r7 = ""
            java.lang.String r1 = r4.replace((java.lang.CharSequence) r1, (java.lang.String) r7)
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0b40 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x0b40 }
            java.lang.String r1 = "merchantInfo"
            org.json.JSONObject r1 = r4.optJSONObject(r1)     // Catch:{ Exception -> 0x0b40 }
            if (r1 == 0) goto L_0x0b40
            java.lang.String r4 = "mccCode"
            java.lang.String r4 = r1.optString(r4)     // Catch:{ Exception -> 0x0b40 }
            r0.r = r4     // Catch:{ Exception -> 0x0b40 }
            java.lang.String r4 = "currentTxnCount"
            java.lang.String r1 = r1.optString(r4)     // Catch:{ Exception -> 0x0b40 }
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x0b40 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0b40 }
            if (r4 != 0) goto L_0x0b40
            java.lang.String r4 = "null"
            r7 = 1
            boolean r4 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r7)     // Catch:{ Exception -> 0x0b40 }
            if (r4 != 0) goto L_0x0b40
            android.view.View r4 = r43.getView()     // Catch:{ Exception -> 0x0b40 }
            if (r4 == 0) goto L_0x0b2b
            int r7 = net.one97.paytm.wallet.R.id.rl_txn_count     // Catch:{ Exception -> 0x0b40 }
            android.view.View r4 = r4.findViewById(r7)     // Catch:{ Exception -> 0x0b40 }
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4     // Catch:{ Exception -> 0x0b40 }
            if (r4 == 0) goto L_0x0b2b
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x0b40 }
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r4)     // Catch:{ Exception -> 0x0b40 }
        L_0x0b2b:
            android.view.View r4 = r43.getView()     // Catch:{ Exception -> 0x0b40 }
            if (r4 == 0) goto L_0x0b40
            int r7 = net.one97.paytm.wallet.R.id.tv_txn_count     // Catch:{ Exception -> 0x0b40 }
            android.view.View r4 = r4.findViewById(r7)     // Catch:{ Exception -> 0x0b40 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x0b40 }
            if (r4 == 0) goto L_0x0b40
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0b40 }
            r4.setText(r1)     // Catch:{ Exception -> 0x0b40 }
        L_0x0b40:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r1 = r1.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r1 = r1.getORDERID()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r4 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r4 = r4.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r4 = r4.getTXNID()
            r0.c(r1, r4)
            goto L_0x0a27
        L_0x0b69:
            r4 = r26
            boolean r1 = r1.equals(r4)
            r7 = r25
            if (r1 == 0) goto L_0x0bbc
            goto L_0x0b7e
        L_0x0b74:
            r7 = r25
            r4 = r26
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x0bbc
        L_0x0b7e:
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0b8c
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0b8a
            goto L_0x0b8c
        L_0x0b8a:
            r1 = 0
            goto L_0x0b8d
        L_0x0b8c:
            r1 = 1
        L_0x0b8d:
            if (r1 == 0) goto L_0x0b95
            int r1 = net.one97.paytm.wallet.R.string.payment_pending_desc_msg
            java.lang.String r8 = r0.getString(r1)
        L_0x0b95:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r1 = r1.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r6)
            java.lang.String r1 = r1.getORDERID()
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r9 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r9 = r9.getTxnInfo()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r6)
            java.lang.String r6 = r9.getMID()
            r0.b((java.lang.String) r1, (java.lang.String) r6, (java.lang.String) r8)
        L_0x0bbc:
            r24 = r8
        L_0x0bbe:
            net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationBody r1 = r2.getBody()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            net.one97.paytm.p2mNewDesign.entity.TxnInfo r1 = r1.getTxnInfo()
            java.lang.String r2 = "txnInfo"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.String r2 = r1.getPAYMENTMODE()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0be0
            java.lang.String r2 = r1.getPAYMENTMODE()
            goto L_0x0be2
        L_0x0be0:
            java.lang.String r2 = "mode"
        L_0x0be2:
            r12 = r2
            net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel r2 = new net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel
            java.lang.String r5 = "mode"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r5)
            java.lang.String r13 = r0.aj
            r14 = 0
            java.lang.String r15 = r0.ak
            r16 = 0
            java.lang.String r5 = r1.getTXNAMOUNT()
            java.lang.String r6 = "txnInfo.txnamount"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r6 = r1.getSTATUS()
            java.lang.String r8 = "txnInfo.status"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            java.lang.String r1 = r1.getORDERID()
            r22 = 0
            r23 = 0
            r11 = r2
            r17 = r5
            r18 = r20
            r20 = r6
            r21 = r1
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24)
            r0.ai = r2
            net.one97.paytm.p2mNewDesign.h.a r1 = net.one97.paytm.p2mNewDesign.h.a.f51295a
            android.content.Context r1 = r43.getContext()
            java.lang.String r2 = r0.x
            r5 = r30
            net.one97.paytm.p2mNewDesign.h.a.a((android.content.Context) r1, (java.lang.String) r5, (java.lang.String) r2)
            goto L_0x0c32
        L_0x0c29:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.entity.CJRProcessTranscationResponse"
            r1.<init>(r2)
            throw r1
        L_0x0c31:
            r4 = r9
        L_0x0c32:
            java.lang.String r1 = r0.t
            if (r1 == 0) goto L_0x0deb
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0deb }
            r2.<init>(r1)     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r1 = "TXNID"
            java.lang.String r1 = r2.optString(r1)     // Catch:{ JSONException -> 0x0deb }
            r0.f51095a = r1     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r1 = "STATUS"
            java.lang.String r1 = r2.optString(r1)     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r5 = "MID"
            java.lang.String r5 = r2.optString(r5)     // Catch:{ JSONException -> 0x0deb }
            r0.I = r5     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r5 = "ORDERID"
            java.lang.String r5 = r2.optString(r5)     // Catch:{ JSONException -> 0x0deb }
            r0.f51098e = r5     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r5 = "RESPCODE"
            java.lang.String r5 = r2.optString(r5)     // Catch:{ JSONException -> 0x0deb }
            net.one97.paytm.p2mNewDesign.h.a r6 = net.one97.paytm.p2mNewDesign.h.a.f51295a     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r6 = "TXNDATE"
            java.lang.String r6 = r2.optString(r6)     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r8 = "yyyy-MM-dd HH:mm:ss"
            long r8 = net.one97.paytm.p2mNewDesign.h.a.a((java.lang.String) r6, (java.lang.String) r8)     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r6 = "TXNAMOUNT"
            java.lang.String r6 = r2.optString(r6)     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r6 = r0.f((java.lang.String) r6)     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r11 = "ORDERID"
            java.lang.String r11 = r2.optString(r11)     // Catch:{ JSONException -> 0x0deb }
            r0.c((java.lang.String) r11)     // Catch:{ JSONException -> 0x0deb }
            r0.b((java.lang.String) r6)     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r11 = java.lang.String.valueOf(r8)     // Catch:{ JSONException -> 0x0deb }
            r0.g((java.lang.String) r11)     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r11 = "PRN"
            java.lang.String r11 = r2.optString(r11)     // Catch:{ JSONException -> 0x0deb }
            r0.d((java.lang.String) r11)     // Catch:{ JSONException -> 0x0deb }
            boolean r11 = r0.Y     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r12 = r0.U     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r13 = r0.X     // Catch:{ JSONException -> 0x0deb }
            java.lang.String r14 = r0.R     // Catch:{ JSONException -> 0x0deb }
            boolean r15 = r0.V     // Catch:{ JSONException -> 0x0deb }
            r25 = r10
            java.lang.String r10 = r0.Z     // Catch:{ JSONException -> 0x0ded }
            r20 = r8
            java.lang.String r8 = r0.aa     // Catch:{ JSONException -> 0x0ded }
            boolean r9 = r0.W     // Catch:{ JSONException -> 0x0ded }
            r16 = r15
            r15 = r1
            r17 = r10
            r18 = r8
            r19 = r9
            java.lang.String r35 = net.one97.paytm.wallet.utility.a.a(r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ JSONException -> 0x0ded }
            net.one97.paytm.wallet.communicator.c r30 = net.one97.paytm.wallet.communicator.b.a()     // Catch:{ JSONException -> 0x0ded }
            android.content.Context r31 = r43.getContext()     // Catch:{ JSONException -> 0x0ded }
            r32 = 200(0xc8, float:2.8E-43)
            java.lang.String r33 = ""
            java.lang.String r34 = "NA"
            r36 = 0
            com.paytm.network.a$b r38 = com.paytm.network.a.b.USER_FACING     // Catch:{ JSONException -> 0x0ded }
            r39 = 0
            com.paytm.network.a$c r40 = com.paytm.network.a.c.PAYMENTS     // Catch:{ JSONException -> 0x0ded }
            r30.pushHawkeyeEvent(r31, r32, r33, r34, r35, r36, r38, r39, r40)     // Catch:{ JSONException -> 0x0ded }
            java.lang.String r8 = "RESPMSG"
            java.lang.String r8 = r2.optString(r8)     // Catch:{ JSONException -> 0x0ded }
            if (r1 != 0) goto L_0x0cd9
        L_0x0cd6:
            r5 = 1
            goto L_0x0db7
        L_0x0cd9:
            int r9 = r1.hashCode()     // Catch:{ JSONException -> 0x0ded }
            switch(r9) {
                case -1882253182: goto L_0x0d8a;
                case 35394935: goto L_0x0d82;
                case 1228132078: goto L_0x0d08;
                case 2008727669: goto L_0x0ce1;
                default: goto L_0x0ce0;
            }     // Catch:{ JSONException -> 0x0ded }
        L_0x0ce0:
            goto L_0x0cd6
        L_0x0ce1:
            java.lang.String r3 = "TXN_FAILURE"
            boolean r3 = r1.equals(r3)     // Catch:{ JSONException -> 0x0ded }
            if (r3 == 0) goto L_0x0cd6
            r3 = r8
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ JSONException -> 0x0ded }
            if (r3 == 0) goto L_0x0cf7
            int r3 = r3.length()     // Catch:{ JSONException -> 0x0ded }
            if (r3 != 0) goto L_0x0cf5
            goto L_0x0cf7
        L_0x0cf5:
            r3 = 0
            goto L_0x0cf8
        L_0x0cf7:
            r3 = 1
        L_0x0cf8:
            if (r3 == 0) goto L_0x0d00
            int r3 = net.one97.paytm.wallet.R.string.msg_post_payment_failed_msg     // Catch:{ JSONException -> 0x0ded }
            java.lang.String r8 = r0.getString(r3)     // Catch:{ JSONException -> 0x0ded }
        L_0x0d00:
            r0.a((java.lang.String) r5, (java.lang.String) r8)     // Catch:{ JSONException -> 0x0ded }
            r24 = r8
            r5 = 1
            goto L_0x0db9
        L_0x0d08:
            boolean r3 = r1.equals(r3)     // Catch:{ JSONException -> 0x0ded }
            if (r3 == 0) goto L_0x0cd6
            java.lang.String r3 = "ADDITIONAL_PARAM"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ JSONException -> 0x0ded }
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ JSONException -> 0x0ded }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0ded }
            if (r4 != 0) goto L_0x0d75
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0ded }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x0ded }
            java.lang.String r3 = "merchantInfo"
            org.json.JSONObject r3 = r4.optJSONObject(r3)     // Catch:{ JSONException -> 0x0ded }
            if (r3 == 0) goto L_0x0d75
            java.lang.String r4 = "mccCode"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ JSONException -> 0x0ded }
            r0.r = r4     // Catch:{ JSONException -> 0x0ded }
            java.lang.String r4 = "currentTxnCount"
            java.lang.String r3 = r3.optString(r4)     // Catch:{ JSONException -> 0x0ded }
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ JSONException -> 0x0ded }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0ded }
            if (r4 != 0) goto L_0x0d75
            java.lang.String r4 = "null"
            r5 = 1
            boolean r4 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r5)     // Catch:{ JSONException -> 0x0de9 }
            if (r4 != 0) goto L_0x0d76
            android.view.View r4 = r43.getView()     // Catch:{ JSONException -> 0x0de9 }
            if (r4 == 0) goto L_0x0d5f
            int r7 = net.one97.paytm.wallet.R.id.rl_txn_count     // Catch:{ JSONException -> 0x0de9 }
            android.view.View r4 = r4.findViewById(r7)     // Catch:{ JSONException -> 0x0de9 }
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4     // Catch:{ JSONException -> 0x0de9 }
            if (r4 == 0) goto L_0x0d5f
            android.view.View r4 = (android.view.View) r4     // Catch:{ JSONException -> 0x0de9 }
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r4)     // Catch:{ JSONException -> 0x0de9 }
        L_0x0d5f:
            android.view.View r4 = r43.getView()     // Catch:{ JSONException -> 0x0de9 }
            if (r4 == 0) goto L_0x0d76
            int r7 = net.one97.paytm.wallet.R.id.tv_txn_count     // Catch:{ JSONException -> 0x0de9 }
            android.view.View r4 = r4.findViewById(r7)     // Catch:{ JSONException -> 0x0de9 }
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ JSONException -> 0x0de9 }
            if (r4 == 0) goto L_0x0d76
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ JSONException -> 0x0de9 }
            r4.setText(r3)     // Catch:{ JSONException -> 0x0de9 }
            goto L_0x0d76
        L_0x0d75:
            r5 = 1
        L_0x0d76:
            java.lang.String r3 = r0.f51098e     // Catch:{ JSONException -> 0x0de9 }
            java.lang.String r4 = "TXNID"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ JSONException -> 0x0de9 }
            r0.c(r3, r4)     // Catch:{ JSONException -> 0x0de9 }
            goto L_0x0db7
        L_0x0d82:
            r5 = 1
            boolean r3 = r1.equals(r4)     // Catch:{ JSONException -> 0x0de9 }
            if (r3 == 0) goto L_0x0db7
            goto L_0x0d91
        L_0x0d8a:
            r5 = 1
            boolean r3 = r1.equals(r7)     // Catch:{ JSONException -> 0x0de9 }
            if (r3 == 0) goto L_0x0db7
        L_0x0d91:
            r3 = r8
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ JSONException -> 0x0de9 }
            if (r3 == 0) goto L_0x0d9f
            int r3 = r3.length()     // Catch:{ JSONException -> 0x0de9 }
            if (r3 != 0) goto L_0x0d9d
            goto L_0x0d9f
        L_0x0d9d:
            r3 = 0
            goto L_0x0da0
        L_0x0d9f:
            r3 = 1
        L_0x0da0:
            if (r3 == 0) goto L_0x0da8
            int r3 = net.one97.paytm.wallet.R.string.payment_pending_desc_msg     // Catch:{ JSONException -> 0x0de9 }
            java.lang.String r8 = r0.getString(r3)     // Catch:{ JSONException -> 0x0de9 }
        L_0x0da8:
            java.lang.String r3 = "ORDERID"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ JSONException -> 0x0de9 }
            java.lang.String r4 = "MID"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ JSONException -> 0x0de9 }
            r0.b((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r8)     // Catch:{ JSONException -> 0x0de9 }
        L_0x0db7:
            r24 = r8
        L_0x0db9:
            net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel r3 = new net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel     // Catch:{ JSONException -> 0x0de9 }
            java.lang.String r4 = "PAYMENTMODE"
            java.lang.String r7 = "default"
            java.lang.String r12 = r2.optString(r4, r7)     // Catch:{ JSONException -> 0x0de9 }
            java.lang.String r2 = "jsonObject.optString(\"PAYMENTMODE\", \"default\")"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0de9 }
            java.lang.String r13 = r0.aj     // Catch:{ JSONException -> 0x0de9 }
            r14 = 0
            java.lang.String r15 = r0.ak     // Catch:{ JSONException -> 0x0de9 }
            r16 = 0
            java.lang.String r2 = "paymentStatus"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)     // Catch:{ JSONException -> 0x0de9 }
            java.lang.String r2 = r0.f51098e     // Catch:{ JSONException -> 0x0de9 }
            r22 = 0
            r23 = 0
            r11 = r3
            r17 = r6
            r18 = r20
            r20 = r1
            r21 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r24)     // Catch:{ JSONException -> 0x0de9 }
            r0.ai = r3     // Catch:{ JSONException -> 0x0de9 }
            goto L_0x0dee
        L_0x0de9:
            goto L_0x0dee
        L_0x0deb:
            r25 = r10
        L_0x0ded:
            r5 = 1
        L_0x0dee:
            boolean r1 = r0.al
            if (r1 == 0) goto L_0x0e25
            android.os.Bundle r1 = r43.getArguments()
            if (r1 != 0) goto L_0x0dfb
            kotlin.g.b.k.a()
        L_0x0dfb:
            java.lang.String r2 = "order_id"
            java.lang.String r1 = r1.getString(r2)
            android.os.Bundle r2 = r43.getArguments()
            if (r2 != 0) goto L_0x0e0a
            kotlin.g.b.k.a()
        L_0x0e0a:
            java.lang.String r3 = "mid"
            java.lang.String r2 = r2.getString(r3)
            r0.c((java.lang.String) r1)
            java.lang.String r3 = r0.x
            r0.b((java.lang.String) r3)
            r3 = 0
            r0.g((java.lang.String) r3)
            int r3 = net.one97.paytm.wallet.R.string.payment_pending_desc_msg
            java.lang.String r3 = r0.getString(r3)
            r0.b((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0e25:
            java.lang.String r1 = r0.A
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0e34
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0e32
            goto L_0x0e34
        L_0x0e32:
            r1 = 0
            goto L_0x0e35
        L_0x0e34:
            r1 = 1
        L_0x0e35:
            if (r1 != 0) goto L_0x0e8d
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x0e4c
            int r2 = net.one97.paytm.wallet.R.id.tv_prn_label
            android.view.View r1 = r1.findViewById(r2)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            if (r1 == 0) goto L_0x0e4c
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r1)
        L_0x0e4c:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x0e61
            int r2 = net.one97.paytm.wallet.R.id.tv_prn_message
            android.view.View r1 = r1.findViewById(r2)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            if (r1 == 0) goto L_0x0e61
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r1)
        L_0x0e61:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x0e76
            int r2 = net.one97.paytm.wallet.R.id.text_otp
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0e76
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r1)
        L_0x0e76:
            android.view.View r1 = r43.getView()
            if (r1 == 0) goto L_0x0e8d
            int r2 = net.one97.paytm.wallet.R.id.text_otp
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0e8d
            java.lang.String r2 = r0.A
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x0e8d:
            r44.invalidate()
            net.one97.paytm.wallet.communicator.c r1 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r2 = "WalletCommManager.getWalletCommunicator()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            androidx.fragment.app.Fragment r1 = r1.getPostPaymentDealsFragment()
            if (r1 == 0) goto L_0x0ecc
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r3 = 123(0x7b, float:1.72E-43)
            java.lang.String r4 = "deal_type"
            r2.putInt(r4, r3)
            r1.setArguments(r2)
            androidx.fragment.app.j r2 = r43.getChildFragmentManager()
            androidx.fragment.app.q r2 = r2.a()
            r3 = 0
            androidx.fragment.app.q r2 = r2.a((int) r3, (int) r3)
            int r3 = net.one97.paytm.wallet.R.id.deals_fragment_container
            java.lang.Class r4 = r1.getClass()
            java.lang.String r4 = r4.getSimpleName()
            androidx.fragment.app.q r1 = r2.b(r3, r1, r4)
            r1.b()
        L_0x0ecc:
            kotlin.g.b.x$e r1 = new kotlin.g.b.x$e
            r1.<init>()
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            android.content.Context r3 = r43.getContext()
            java.lang.String r4 = "p2mNavbarSFUrl"
            java.lang.String r2 = r2.getStringFromGTM(r3, r4)
            r1.element = r2
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            java.lang.String r3 = "WalletCommManager.getWalletCommunicator()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.content.Context r2 = r2.getContext()
            T r3 = r1.element
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r2 = com.paytm.utility.b.e((android.content.Context) r2, (java.lang.String) r3)
            r1.element = r2
            androidx.fragment.app.FragmentActivity r2 = r43.getActivity()
            if (r2 == 0) goto L_0x0f19
            net.one97.paytm.widget.g r3 = net.one97.paytm.widget.g.f72427a
            T r3 = r1.element
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "url"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r4 = "it"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.d.e$g r4 = new net.one97.paytm.p2mNewDesign.d.e$g
            r4.<init>(r0, r1)
            net.one97.paytm.widget.b r4 = (net.one97.paytm.widget.b) r4
            net.one97.paytm.widget.g.a((java.lang.String) r3, (androidx.fragment.app.FragmentActivity) r2, (net.one97.paytm.widget.b) r4)
        L_0x0f19:
            boolean r1 = r0.ac
            if (r1 == 0) goto L_0x100a
            int r1 = net.one97.paytm.wallet.R.id.wallet_post_txn_cta
            r2 = r44
            android.view.View r1 = r2.findViewById(r1)
            int r3 = net.one97.paytm.wallet.R.id.mlv_layout
            android.view.View r3 = r2.findViewById(r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            int r4 = net.one97.paytm.wallet.R.id.ad_fragment_container
            android.view.View r4 = r2.findViewById(r4)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            int r6 = net.one97.paytm.wallet.R.id.dynamic_views
            android.view.View r6 = r2.findViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r6.removeAllViews()
            int r6 = net.one97.paytm.wallet.R.id.dynamic_views
            android.view.View r6 = r2.findViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r6.addView(r1)
            int r1 = net.one97.paytm.wallet.R.id.dynamic_views
            android.view.View r1 = r2.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            android.view.View r3 = (android.view.View) r3
            r1.addView(r3)
            int r1 = net.one97.paytm.wallet.R.id.dynamic_views
            android.view.View r1 = r2.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            android.view.View r4 = (android.view.View) r4
            r1.addView(r4)
            java.lang.String r1 = r0.ae
            java.lang.String r3 = r0.ad
            java.lang.String r4 = r0.k
            java.lang.String r6 = r0.af
            java.lang.String r7 = r0.ag
            r8 = r1
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x0f7d
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0f7b
            goto L_0x0f7d
        L_0x0f7b:
            r8 = 0
            goto L_0x0f7e
        L_0x0f7d:
            r8 = 1
        L_0x0f7e:
            if (r8 != 0) goto L_0x0ff6
            r8 = r3
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x0f8e
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0f8c
            goto L_0x0f8e
        L_0x0f8c:
            r8 = 0
            goto L_0x0f8f
        L_0x0f8e:
            r8 = 1
        L_0x0f8f:
            if (r8 != 0) goto L_0x0ff6
            r8 = r4
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x0f9f
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0f9d
            goto L_0x0f9f
        L_0x0f9d:
            r8 = 0
            goto L_0x0fa0
        L_0x0f9f:
            r8 = 1
        L_0x0fa0:
            if (r8 != 0) goto L_0x0ff6
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x0faf
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0fae
            goto L_0x0faf
        L_0x0fae:
            r5 = 0
        L_0x0faf:
            if (r5 != 0) goto L_0x0ff6
            net.one97.paytm.p2mNewDesign.g.e$a r5 = net.one97.paytm.p2mNewDesign.g.e.f51282a
            net.one97.paytm.p2mNewDesign.g.e r1 = net.one97.paytm.p2mNewDesign.g.e.a.a(r1, r3, r4, r6, r7)
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            androidx.fragment.app.j r3 = r43.getChildFragmentManager()
            androidx.fragment.app.q r3 = r3.a()
            r4 = 0
            androidx.fragment.app.q r3 = r3.a((int) r4, (int) r4)
            android.view.View r4 = r43.getView()
            if (r4 != 0) goto L_0x0fcf
            kotlin.g.b.k.a()
        L_0x0fcf:
            java.lang.String r5 = "view!!"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            int r5 = net.one97.paytm.wallet.R.id.mlv_layout
            android.view.View r4 = r4.findViewById(r5)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            java.lang.String r5 = "view!!.mlv_layout"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            int r4 = r4.getId()
            java.lang.Class r5 = r1.getClass()
            java.lang.String r5 = r5.getSimpleName()
            androidx.fragment.app.q r1 = r3.b(r4, r1, r5)
            r1.c()
        L_0x0ff6:
            int r1 = net.one97.paytm.wallet.R.id.resend_confirmation_payment
            android.view.View r1 = r2.findViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            java.lang.String r3 = "view.resend_confirmation_payment"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            android.view.View r1 = (android.view.View) r1
            net.one97.paytm.wallet.rateMerchant.utils.b.a(r1)
            goto L_0x100c
        L_0x100a:
            r2 = r44
        L_0x100c:
            int r1 = net.one97.paytm.wallet.R.id.ad_fragment_container
            android.view.View r1 = r2.findViewById(r1)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            java.lang.String r2 = "view.ad_fragment_container"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            net.one97.paytm.wallet.communicator.c r2 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r3 = r0.f51099f
            if (r3 != 0) goto L_0x1025
            kotlin.g.b.k.a((java.lang.String) r25)
        L_0x1025:
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r4 = "walletAdSlotApiURL"
            java.lang.String r2 = r2.getStringFromGTM(r3, r4)
            net.one97.paytm.wallet.communicator.c r3 = net.one97.paytm.wallet.communicator.b.a()
            android.app.Activity r4 = r0.f51099f
            if (r4 != 0) goto L_0x1039
            kotlin.g.b.k.a((java.lang.String) r25)
        L_0x1039:
            r5 = r1
            android.view.View r5 = (android.view.View) r5
            com.paytm.network.a$c r6 = com.paytm.network.a.c.WALLET
            androidx.fragment.app.Fragment r2 = r3.getSfBannerFragment(r4, r5, r2, r6)
            androidx.fragment.app.j r3 = r43.getChildFragmentManager()
            androidx.fragment.app.q r3 = r3.a()
            java.lang.String r4 = "childFragmentManager.beginTransaction()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            int r1 = r1.getId()
            r3.b(r1, r2)
            r3.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.e.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.p2m_post_payment_fragment, viewGroup, false);
        if (!this.al) {
            p();
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public final void d(String str) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        RoboTextView roboTextView;
        RoboTextView roboTextView2;
        CharSequence charSequence = str;
        if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
            new LinearLayout.LayoutParams(-1, net.one97.paytm.wallet.d.l.a(100)).setMargins(net.one97.paytm.wallet.d.l.a((int) getResources().getDimension(R.dimen.margin_left_prn)), net.one97.paytm.wallet.d.l.a((int) getResources().getDimension(R.dimen.margin_top_prn)), net.one97.paytm.wallet.d.l.a((int) getResources().getDimension(R.dimen.margin_left_prn)), net.one97.paytm.wallet.d.l.a((int) getResources().getDimension(R.dimen.margin_top_prn)));
            View view = getView();
            if (!(view == null || (roboTextView2 = (RoboTextView) view.findViewById(R.id.tv_prn_label)) == null)) {
                net.one97.paytm.wallet.rateMerchant.utils.b.a(roboTextView2);
            }
            View view2 = getView();
            if (!(view2 == null || (roboTextView = (RoboTextView) view2.findViewById(R.id.tv_prn_message)) == null)) {
                net.one97.paytm.wallet.rateMerchant.utils.b.a(roboTextView);
            }
            View view3 = getView();
            if (!(view3 == null || (textView3 = (TextView) view3.findViewById(R.id.text_otp)) == null)) {
                net.one97.paytm.wallet.rateMerchant.utils.b.a(textView3);
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            int length = str.length() / 2;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(str.charAt(i2));
            }
            int length2 = str.length();
            for (int length3 = str.length() / 2; length3 < length2; length3++) {
                sb2.append(str.charAt(length3));
            }
            View view4 = getView();
            if (!(view4 == null || (textView2 = (TextView) view4.findViewById(R.id.text_otp)) == null)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb);
                sb3.append(' ');
                sb3.append(sb2);
                textView2.setText(sb3.toString());
            }
            View view5 = getView();
            if (view5 != null && (textView = (TextView) view5.findViewById(R.id.text_otp)) != null) {
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            }
        }
    }

    public final void d() {
        new Handler().postDelayed(new b(this), 1000);
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f51103a;

        b(e eVar) {
            this.f51103a = eVar;
        }

        public final void run() {
            LottieAnimationView lottieAnimationView;
            LottieAnimationView lottieAnimationView2;
            ImageView imageView;
            View view = this.f51103a.getView();
            if (!(view == null || (imageView = (ImageView) view.findViewById(R.id.ic_payment_status)) == null)) {
                net.one97.paytm.wallet.rateMerchant.utils.b.b(imageView);
            }
            View view2 = this.f51103a.getView();
            if (!(view2 == null || (lottieAnimationView2 = (LottieAnimationView) view2.findViewById(R.id.success_animation)) == null)) {
                net.one97.paytm.wallet.rateMerchant.utils.b.a(lottieAnimationView2);
            }
            View view3 = this.f51103a.getView();
            if (!(view3 == null || (lottieAnimationView = (LottieAnimationView) view3.findViewById(R.id.success_animation)) == null)) {
                lottieAnimationView.playAnimation();
            }
            this.f51103a.a((kotlin.g.a.b<? super Activity, x>) new r(this.f51103a, 120000));
        }
    }

    public final void e() {
        RelativeLayout relativeLayout;
        View view;
        RelativeLayout relativeLayout2;
        if (this.u || this.Q || this.ab || this.H || this.ac) {
            View view2 = getView();
            if (view2 != null && (relativeLayout = (RelativeLayout) view2.findViewById(R.id.repeat_payment_view)) != null) {
                net.one97.paytm.wallet.rateMerchant.utils.b.b(relativeLayout);
            }
        } else if (this.P && (view = getView()) != null && (relativeLayout2 = (RelativeLayout) view.findViewById(R.id.repeat_payment_view)) != null) {
            net.one97.paytm.wallet.rateMerchant.utils.b.a(relativeLayout2);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        Handler handler = this.o;
        if (handler != null) {
            if (handler != null) {
                handler.removeCallbacks(this.p);
            }
            this.o = null;
            this.p = null;
        }
    }

    public final void b(String str) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        CharSequence charSequence = str;
        if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
            double parseDouble = Double.parseDouble(str);
            if (parseDouble % 1.0d == 0.0d) {
                View view = getView();
                if (view != null && (textView4 = (TextView) view.findViewById(R.id.tv_amount)) != null) {
                    textView4.setText(e(String.valueOf(parseDouble)));
                    return;
                }
                return;
            }
            String format = new DecimalFormat("#.00").format(Double.parseDouble(str));
            kotlin.g.b.k.a((Object) format, "amount");
            int a2 = kotlin.m.p.a((CharSequence) format, AppUtility.CENTER_DOT, 0, false, 6);
            View view2 = getView();
            if (!(view2 == null || (textView3 = (TextView) view2.findViewById(R.id.tv_amount)) == null)) {
                String substring = format.substring(0, a2);
                kotlin.g.b.k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                textView3.setText(e(substring));
            }
            View view3 = getView();
            if (!(view3 == null || (textView2 = (TextView) view3.findViewById(R.id.tv_amount_fractional)) == null)) {
                net.one97.paytm.wallet.rateMerchant.utils.b.a(textView2);
            }
            View view4 = getView();
            if (view4 != null && (textView = (TextView) view4.findViewById(R.id.tv_amount_fractional)) != null) {
                String substring2 = format.substring(a2);
                kotlin.g.b.k.a((Object) substring2, "(this as java.lang.String).substring(startIndex)");
                textView.setText(substring2);
            }
        }
    }

    public final void f() {
        CircularImageView circularImageView;
        CharSequence charSequence = this.f51100g;
        if (!(charSequence == null || charSequence.length() == 0)) {
            com.squareup.picasso.aa b2 = w.a().a(this.f51100g).a(R.drawable.merchant_icon).b(R.drawable.merchant_icon);
            View view = getView();
            b2.a((ImageView) view != null ? (CircularImageView) view.findViewById(R.id.iv_merchant_logo) : null);
            return;
        }
        View view2 = getView();
        if (view2 != null && (circularImageView = (CircularImageView) view2.findViewById(R.id.iv_merchant_logo)) != null) {
            Activity activity = this.f51099f;
            if (activity == null) {
                kotlin.g.b.k.a("mActivity");
            }
            circularImageView.setImageDrawable(androidx.core.content.b.a((Context) activity, R.drawable.merchant_icon));
        }
    }

    private final void j() {
        net.one97.paytm.wallet.j.a aVar = this.O;
        if (aVar == null) {
            kotlin.g.b.k.a("postPaymentFragmentViewModel");
        }
        aVar.f70416a.observe(getViewLifecycleOwner(), new o(this));
        net.one97.paytm.wallet.j.a aVar2 = this.O;
        if (aVar2 == null) {
            kotlin.g.b.k.a("postPaymentFragmentViewModel");
        }
        aVar2.f70417b.observe(getViewLifecycleOwner(), new p(this));
        net.one97.paytm.wallet.j.a aVar3 = this.O;
        if (aVar3 == null) {
            kotlin.g.b.k.a("postPaymentFragmentViewModel");
        }
        aVar3.a(this.I, getContext(), (androidx.lifecycle.q) this);
    }

    private static String e(String str) {
        String format = new DecimalFormat("##,##,##,##,###").format(new BigDecimal(str));
        kotlin.g.b.k.a((Object) format, "formatter.format(parsed)");
        return format;
    }

    private final String f(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
            String plainString = new BigDecimal(str).stripTrailingZeros().toPlainString();
            kotlin.g.b.k.a((Object) plainString, "BigDecimal(amount).strip…ngZeros().toPlainString()");
            return plainString;
        }
        String plainString2 = new BigDecimal(this.x).stripTrailingZeros().toPlainString();
        kotlin.g.b.k.a((Object) plainString2, "BigDecimal(mAmount).stri…ngZeros().toPlainString()");
        return plainString2;
    }

    private final long g(String str) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        try {
            View view = getView();
            if (!(view == null || (textView3 = (TextView) view.findViewById(R.id.tv_date)) == null)) {
                net.one97.paytm.wallet.rateMerchant.utils.b.a(textView3);
            }
            CharSequence charSequence = str;
            if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
                long parseLong = Long.parseLong(str);
                View view2 = getView();
                if (view2 == null || (textView2 = (TextView) view2.findViewById(R.id.tv_date)) == null) {
                    return parseLong;
                }
                textView2.setText(com.paytm.utility.b.a(Long.valueOf(parseLong), "hh:mm a, dd MMM yyyy"));
                return parseLong;
            }
            long currentTimeMillis = System.currentTimeMillis();
            View view3 = getView();
            if (view3 == null || (textView = (TextView) view3.findViewById(R.id.tv_date)) == null) {
                return currentTimeMillis;
            }
            textView.setText(com.paytm.utility.b.a(Long.valueOf(currentTimeMillis), "hh:mm a, dd MMM yyyy"));
            return currentTimeMillis;
        } catch (NumberFormatException unused) {
            return System.currentTimeMillis();
        }
    }

    public final void c(String str) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        CharSequence charSequence = str;
        if (!(charSequence == null || kotlin.m.p.a(charSequence))) {
            View view = getView();
            if (!(view == null || (textView3 = (TextView) view.findViewById(R.id.tv_order_id)) == null)) {
                net.one97.paytm.wallet.rateMerchant.utils.b.a(textView3);
            }
            View view2 = getView();
            if (view2 != null && (textView2 = (TextView) view2.findViewById(R.id.tv_order_id)) != null) {
                net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                net.one97.paytm.p2mNewDesign.h.a.a(getString(R.string.order_txn_id) + " " + str, textView2);
                return;
            }
            return;
        }
        View view3 = getView();
        if (view3 != null && (textView = (TextView) view3.findViewById(R.id.tv_order_id)) != null) {
            net.one97.paytm.wallet.rateMerchant.utils.b.b(textView);
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str, String str2) {
        ImageView imageView;
        ImageView imageView2;
        WalletCircularProgressBar walletCircularProgressBar;
        WalletCircularProgressBar walletCircularProgressBar2;
        CharSequence charSequence = str;
        boolean z2 = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = str2;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                this.f51098e = str;
                this.I = str2;
                if (getActivity() != null) {
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity, "activity!!");
                    if (!activity.isFinishing()) {
                        int i2 = aq;
                        if (i2 <= 15) {
                            aq = i2 + 1;
                            View view = getView();
                            if (!(view == null || (walletCircularProgressBar2 = (WalletCircularProgressBar) view.findViewById(R.id.pb_pending)) == null)) {
                                net.one97.paytm.wallet.rateMerchant.utils.b.a(walletCircularProgressBar2);
                            }
                            if (this.O == null) {
                                kotlin.g.b.k.a("postPaymentFragmentViewModel");
                            }
                            Activity activity2 = this.f51099f;
                            if (activity2 == null) {
                                kotlin.g.b.k.a("mActivity");
                            }
                            LiveData<net.one97.paytm.network.f> a2 = net.one97.paytm.wallet.j.a.a((Context) activity2, str, str2);
                            if (a2 != null) {
                                a2.observeForever(new d(this, str, str2));
                                return;
                            }
                            return;
                        }
                        net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                        net.one97.paytm.p2mNewDesign.h.a.a("offline_payments", "post_payment_pending_shown", getContext(), "home/pay-send/payment-pending");
                        View view2 = getView();
                        if (!(view2 == null || (walletCircularProgressBar = (WalletCircularProgressBar) view2.findViewById(R.id.pb_pending)) == null)) {
                            net.one97.paytm.wallet.rateMerchant.utils.b.b(walletCircularProgressBar);
                        }
                        View view3 = getView();
                        if (!(view3 == null || (imageView2 = (ImageView) view3.findViewById(R.id.ic_payment_status)) == null)) {
                            net.one97.paytm.wallet.rateMerchant.utils.b.a(imageView2);
                        }
                        View view4 = getView();
                        if (view4 != null && (imageView = (ImageView) view4.findViewById(R.id.ic_payment_status)) != null) {
                            Activity activity3 = this.f51099f;
                            if (activity3 == null) {
                                kotlin.g.b.k.a("mActivity");
                            }
                            imageView.setBackground(androidx.core.content.b.a((Context) activity3, R.drawable.ic_pending_copy));
                        }
                    }
                }
            }
        }
    }

    public final void onClick(View view) {
        String str;
        String str2;
        kotlin.g.b.k.c(view, "view");
        if (view.getId() == R.id.passbook_view) {
            net.one97.paytm.wallet.communicator.b.a().handleDeepLink(getContext(), "paytmmp://cash_wallet?featuretype=cash_ledger", (Bundle) null);
            net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
            Activity activity = this.f51099f;
            if (activity == null) {
                kotlin.g.b.k.a("mActivity");
            }
            Context context = activity;
            boolean z2 = this.G;
            boolean z3 = this.E;
            boolean z4 = this.C;
            kotlin.g.b.k.c(context, "context");
            ArrayList arrayList = new ArrayList();
            if (z2) {
                str = "summary screen - p2m-upi/summary";
                str2 = "UPI_p2m_clicked";
            } else {
                if (z3) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/wallet/pay-send/success");
                        hashMap.put("event_category", "wallet_send_money");
                        hashMap.put("event_action", "wallet_p2m_clicked");
                        hashMap.put("vertical_name", "wallet");
                        hashMap.put("event_label", "p2m");
                        String n2 = com.paytm.utility.b.n(context);
                        kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(context)");
                        hashMap.put("user_id", n2);
                        net.one97.paytm.wallet.communicator.b.a().sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, ae.a(hashMap), context);
                    } catch (Exception unused) {
                    }
                }
                str2 = "wallet_p2m_clicked";
                str = "summary screen - p2m-wallet/summary";
            }
            if (z3) {
                arrayList.add("success");
                net.one97.paytm.p2mNewDesign.h.a.a("offline_payments", "post_payment_viewpassbook_clicked", context, "home/pay-send/");
            } else if (z4) {
                arrayList.add(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING);
            } else {
                arrayList.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            }
            if (!v.a(str)) {
                net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEventsWithMultipleLabel(context, "passbook_landing_page", str2, arrayList, (String) null, str, "passbook");
            }
        } else if (view.getId() == R.id.resend_confirmation_payment) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                kotlin.g.b.k.a();
            }
            if (arguments.getBoolean("is_offline_pg", false) && this.F) {
                net.one97.paytm.p2mNewDesign.h.a aVar2 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                Context context2 = getContext();
                String str3 = net.one97.paytm.common.utility.d.bO;
                kotlin.g.b.k.a((Object) str3, "CJRGTMConstants.GTM_EVENT_ACTION_POST_PAYMENT");
                String str4 = net.one97.paytm.common.utility.d.by;
                kotlin.g.b.k.a((Object) str4, "CJRGTMConstants.GTM_USER…ON_RESEND_PAYMENT_CLICKED");
                net.one97.paytm.p2mNewDesign.h.a.a(context2, str3, str4, net.one97.paytm.common.utility.d.ce);
                k();
            } else if (kotlin.m.p.a("p2m", this.y, true) && this.F) {
                net.one97.paytm.p2mNewDesign.h.a aVar3 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                Context context3 = getContext();
                String str5 = net.one97.paytm.common.utility.d.bO;
                kotlin.g.b.k.a((Object) str5, "CJRGTMConstants.GTM_EVENT_ACTION_POST_PAYMENT");
                String str6 = net.one97.paytm.common.utility.d.by;
                kotlin.g.b.k.a((Object) str6, "CJRGTMConstants.GTM_USER…ON_RESEND_PAYMENT_CLICKED");
                net.one97.paytm.p2mNewDesign.h.a.a(context3, str5, str6, net.one97.paytm.common.utility.d.ce);
                Context context4 = getContext();
                if (context4 != null) {
                    m();
                    if (this.O == null) {
                        kotlin.g.b.k.a("postPaymentFragmentViewModel");
                    }
                    LiveData<net.one97.paytm.network.f> a2 = net.one97.paytm.wallet.j.a.a(context4, this.f51095a);
                    if (a2 != null) {
                        a2.observe(this, this.ap);
                    }
                }
            } else if (this.ac) {
                net.one97.paytm.p2mNewDesign.h.a aVar4 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                Context context5 = getContext();
                String str7 = net.one97.paytm.common.utility.d.bO;
                kotlin.g.b.k.a((Object) str7, "CJRGTMConstants.GTM_EVENT_ACTION_POST_PAYMENT");
                String str8 = net.one97.paytm.common.utility.d.by;
                kotlin.g.b.k.a((Object) str8, "CJRGTMConstants.GTM_USER…ON_RESEND_PAYMENT_CLICKED");
                net.one97.paytm.p2mNewDesign.h.a.a(context5, str7, str8, net.one97.paytm.common.utility.d.ce);
                k();
            } else {
                net.one97.paytm.p2mNewDesign.h.a aVar5 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
                Context context6 = getContext();
                String str9 = net.one97.paytm.common.utility.d.bO;
                kotlin.g.b.k.a((Object) str9, "CJRGTMConstants.GTM_EVENT_ACTION_POST_PAYMENT");
                String str10 = net.one97.paytm.common.utility.d.bz;
                kotlin.g.b.k.a((Object) str10, "CJRGTMConstants.GTM_USER…ION_HAVE_AN_ISSUE_CLICKED");
                net.one97.paytm.p2mNewDesign.h.a.a(context6, str9, str10, net.one97.paytm.common.utility.d.cf);
                m();
                if (this.G) {
                    CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
                    cJRReplacementReason.setIssueText("UPI");
                    cJRReplacementReason.setId(UpiConstants.CST_UPI_ID);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, (Serializable) null);
                    bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, cJRReplacementReason);
                    net.one97.paytm.wallet.communicator.c a3 = net.one97.paytm.wallet.communicator.b.a();
                    Activity activity2 = this.f51099f;
                    if (activity2 == null) {
                        kotlin.g.b.k.a("mActivity");
                    }
                    a3.openH5(activity2, bundle, this);
                    return;
                }
                CJRReplacementReason cJRReplacementReason2 = new CJRReplacementReason();
                cJRReplacementReason2.setIssueText("Wallet");
                cJRReplacementReason2.setId(1000003);
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_REASONS, cJRReplacementReason2);
                net.one97.paytm.wallet.communicator.c a4 = net.one97.paytm.wallet.communicator.b.a();
                Activity activity3 = this.f51099f;
                if (activity3 == null) {
                    kotlin.g.b.k.a("mActivity");
                }
                a4.openH5(activity3, bundle2, this);
            }
        } else if (view.getId() == R.id.tv_share) {
            l();
        } else if (view.getId() == R.id.contact_trust_layout) {
            a((kotlin.g.a.b<? super Activity, x>) n.INSTANCE);
        } else if (view.getId() == R.id.iv_cross) {
            if (this.ah) {
                a((kotlin.g.a.b<? super Activity, x>) new l(this));
            } else {
                a((kotlin.g.a.b<? super Activity, x>) new m(this));
            }
        } else if (view.getId() == R.id.repeat_payment_view) {
            net.one97.paytm.p2mNewDesign.h.a aVar6 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
            Activity activity4 = this.f51099f;
            if (activity4 == null) {
                kotlin.g.b.k.a("mActivity");
            }
            String str11 = this.T;
            kotlin.g.b.k.c(activity4, "activity");
            Context context7 = activity4;
            Intent intent = new Intent(context7, AJRQRActivity.class);
            intent.putExtra("OPERATION", "scan");
            intent.putExtra("scan_result", str11);
            intent.setFlags(536870912);
            intent.putExtra("is_from_repeat_payment", true);
            activity4.startActivity(intent);
            net.one97.paytm.p2mNewDesign.h.a.a("offline_payments", "post_payment_repeat_payment_clicked", context7, "home/pay-send/payment-success");
        }
    }

    private final void k() {
        com.google.android.material.bottomsheet.b aVar = new net.one97.paytm.postpayment.a.a();
        Bundle bundle = new Bundle();
        bundle.putString(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, this.f51095a);
        bundle.putString("merchant_id", this.I);
        bundle.putString("order_id", this.f51098e);
        bundle.putString("mobileNumber", this.B);
        bundle.putString("merchant_name", this.f51096b);
        aVar.setArguments(bundle);
        aVar.show(getChildFragmentManager(), (String) null);
        net.one97.paytm.p2mNewDesign.h.a aVar2 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
        net.one97.paytm.p2mNewDesign.h.a.a("offline_payments", "resend_merchant_notification_clicked", getContext(), "home/pay-send/");
    }

    public final void onPause() {
        super.onPause();
        o();
    }

    private void l() {
        RelativeLayout relativeLayout;
        if (Build.VERSION.SDK_INT >= 23) {
            Activity activity = this.f51099f;
            if (activity == null) {
                kotlin.g.b.k.a("mActivity");
            }
            if (activity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 103);
                Activity activity2 = this.f51099f;
                if (activity2 == null) {
                    kotlin.g.b.k.a("mActivity");
                }
                Toast.makeText(activity2, getString(R.string.permission_not_granted), 0).show();
                return;
            }
        }
        View view = getView();
        if (view != null && (relativeLayout = (RelativeLayout) view.findViewById(R.id.main_summary_rl)) != null) {
            net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
            Activity activity3 = this.f51099f;
            if (activity3 == null) {
                kotlin.g.b.k.a("mActivity");
            }
            net.one97.paytm.p2mNewDesign.h.a.a(activity3, (View) relativeLayout);
        }
    }

    public static final class g implements net.one97.paytm.widget.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f51111a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f51112b;

        g(e eVar, x.e eVar2) {
            this.f51111a = eVar;
            this.f51112b = eVar2;
        }

        public final void onReceivedWidget(IStaticWidget iStaticWidget) {
            RelativeLayout relativeLayout;
            kotlin.g.b.k.c(iStaticWidget, "widget");
            this.f51111a.ao = iStaticWidget;
            View view = this.f51111a.getView();
            if (view != null && (relativeLayout = (RelativeLayout) view.findViewById(R.id.floating_nav)) != null) {
                relativeLayout.addView(iStaticWidget.getView());
            }
        }
    }

    private final void a(String str, String str2, String str3) {
        if (net.one97.paytm.wallet.communicator.b.a().initializeCashbackJarvisHelper()) {
            this.an = net.one97.paytm.cashback.posttxn.c.a();
        }
        net.one97.paytm.cashback.posttxn.e eVar = this.an;
        if (eVar != null && eVar.a(net.one97.paytm.utils.b.a.SCAN_PAY.getId(), 0)) {
            CharSequence charSequence = str;
            boolean z2 = true;
            if (charSequence == null || charSequence.length() == 0) {
                CharSequence charSequence2 = str2;
                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                    z2 = false;
                }
                if (z2) {
                    return;
                }
            }
            a((kotlin.g.a.b<? super Activity, kotlin.x>) new j(this, str, str2, str3));
        }
    }

    private final void m() {
        Dialog dialog;
        if (this.z == null) {
            Activity activity = this.f51099f;
            if (activity == null) {
                kotlin.g.b.k.a("mActivity");
            }
            this.z = net.one97.paytm.wallet.utility.a.b(activity);
        }
        Dialog dialog2 = this.z;
        Boolean valueOf = dialog2 != null ? Boolean.valueOf(dialog2.isShowing()) : null;
        if (valueOf == null) {
            kotlin.g.b.k.a();
        }
        if (!valueOf.booleanValue() && (dialog = this.z) != null) {
            dialog.show();
        }
    }

    /* access modifiers changed from: private */
    public final void n() {
        Dialog dialog = this.z;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        kotlin.g.b.k.c(strArr, "permissions");
        kotlin.g.b.k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 103 && com.paytm.utility.s.a(iArr)) {
            l();
        }
    }

    public final void a(float f2) {
        Context b2 = b();
        if (b2 != null) {
            com.paytm.utility.b.x(b2, "is_app_rated");
            net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEvents(b2, "app_rating", String.valueOf(f2), "p2m_screen", (String) null, (String) null, (String) null, "app_rating");
            if (f2 < 5.0f) {
                com.paytm.utility.b.a(b2, "app_rating_less_than_5_star_timestamp", System.currentTimeMillis());
                com.paytm.utility.b.a(b2, "app_rating_5_star_timestamp", 0);
                a((kotlin.g.a.b<? super Activity, kotlin.x>) new q(this, f2));
            } else {
                o();
                com.paytm.utility.b.a(b2, "app_rating_5_star_timestamp", System.currentTimeMillis());
                com.paytm.utility.b.a(b2, "app_rating_less_than_5_star_timestamp", 0);
                com.paytm.utility.b.ai(b2);
            }
            com.paytm.utility.b.a(b2, "app_rating_not_now_timestamp", 0);
        }
    }

    public final void a() {
        Context b2 = b();
        if (b2 != null) {
            com.paytm.utility.b.a(b2, "app_rating_not_now_timestamp", System.currentTimeMillis());
            com.paytm.utility.b.a(b2, "app_rating_5_star_timestamp", 0);
            com.paytm.utility.b.a(b2, "app_rating_less_than_5_star_timestamp", 0);
            net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEvents(b2, "app_rating", "cross_button_clicked", "p2m_screen", (String) null, (String) null, (String) null, "app_rating");
        }
        o();
    }

    /* access modifiers changed from: private */
    public final void o() {
        a((kotlin.g.a.b<? super Activity, kotlin.x>) new c(this));
    }

    public final void show() {
        m();
    }

    public final void dismiss() {
        n();
    }

    /* access modifiers changed from: private */
    public final void h(String str) {
        Bundle bundle = this.v;
        if (bundle == null) {
            return;
        }
        if (!TextUtils.isEmpty(bundle.getString("payee_id")) || !TextUtils.isEmpty(bundle.getString("payer_id"))) {
            SBMarkAsPaid sBMarkAsPaid = new SBMarkAsPaid();
            sBMarkAsPaid.setPaymentMode(str);
            sBMarkAsPaid.setPayeeId(bundle.getString("payee_id"));
            sBMarkAsPaid.setPayerId(bundle.getString("payer_id"));
            sBMarkAsPaid.setTotalAmount(bundle.getString("amount"));
            Activity activity = this.f51099f;
            if (activity == null) {
                kotlin.g.b.k.a("mActivity");
            }
            net.one97.paytm.wallet.splitbill.e.b.a(activity, sBMarkAsPaid);
        }
    }

    public final void g() {
        if (!this.H && !this.Q) {
            net.one97.paytm.wallet.d.j.a().a((Context) getActivity());
            if (this.u) {
                net.one97.paytm.wallet.d.k.a();
                Activity activity = this.f51099f;
                if (activity == null) {
                    kotlin.g.b.k.a("mActivity");
                }
                net.one97.paytm.wallet.d.k.a(activity, this.f51096b, this.B, this.f51100g, System.currentTimeMillis(), this.x, "wallet", k.a.NONE);
            }
            Activity activity2 = this.f51099f;
            if (activity2 == null) {
                kotlin.g.b.k.a("mActivity");
            }
            RecentDataNetworkManager.uploadRecentPaymentsData(activity2);
        }
    }

    public final void h() {
        if (this.R != null && this.S != null) {
            net.one97.paytm.wallet.j.a aVar = this.O;
            if (aVar == null) {
                kotlin.g.b.k.a("postPaymentFragmentViewModel");
            }
            String str = this.R;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            String str2 = this.S;
            if (str2 == null) {
                kotlin.g.b.k.a();
            }
            aVar.a(str, str2);
            String str3 = this.f51102i;
            if (str3 != null) {
                net.one97.paytm.wallet.j.a aVar2 = this.O;
                if (aVar2 == null) {
                    kotlin.g.b.k.a("postPaymentFragmentViewModel");
                }
                Activity activity = this.f51099f;
                if (activity == null) {
                    kotlin.g.b.k.a("mActivity");
                }
                String n2 = com.paytm.utility.b.n((Context) activity);
                kotlin.g.b.k.a((Object) n2, "CJRAppCommonUtility.getUserId(mActivity)");
                aVar2.b(n2, str3);
            }
        }
    }

    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f51110a;

        public f(e eVar) {
            this.f51110a = eVar;
        }

        public final void run() {
            try {
                this.f51110a.a((kotlin.g.a.b<? super Activity, kotlin.x>) new kotlin.g.a.b<Activity, kotlin.x>(this) {
                    final /* synthetic */ f this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Activity) obj);
                        return kotlin.x.f47997a;
                    }

                    public final void invoke(Activity activity) {
                        kotlin.g.b.k.c(activity, "it");
                        androidx.fragment.app.j childFragmentManager = this.this$0.f51110a.getChildFragmentManager();
                        View view = this.this$0.f51110a.getView();
                        if (view == null) {
                            kotlin.g.b.k.a();
                        }
                        kotlin.g.b.k.a((Object) view, "view!!");
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.mlv_layout);
                        kotlin.g.b.k.a((Object) linearLayout, "view!!.mlv_layout");
                        Fragment c2 = childFragmentManager.c(linearLayout.getId());
                        if (c2 instanceof net.one97.paytm.p2mNewDesign.g.e) {
                            ((net.one97.paytm.p2mNewDesign.g.e) c2).a(true);
                        }
                    }
                });
            } catch (IllegalStateException unused) {
            }
        }
    }

    private final void p() {
        if (this.ah) {
            new Handler().postDelayed(new C0925e(this), 2000);
        }
    }

    /* renamed from: net.one97.paytm.p2mNewDesign.d.e$e  reason: collision with other inner class name */
    static final class C0925e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f51109a;

        C0925e(e eVar) {
            this.f51109a = eVar;
        }

        public final void run() {
            this.f51109a.a((kotlin.g.a.b<? super Activity, kotlin.x>) new kotlin.g.a.b<Activity, kotlin.x>(this) {
                final /* synthetic */ C0925e this$0;

                {
                    this.this$0 = r1;
                }

                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Activity) obj);
                    return kotlin.x.f47997a;
                }

                public final void invoke(Activity activity) {
                    kotlin.g.b.k.c(activity, "it");
                    e.j(this.this$0.f51109a);
                    activity.setResult(-1);
                    activity.finish();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public final void c(String str, String str2) {
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        TextView textView2;
        TextView textView3;
        RelativeLayout relativeLayout;
        WalletCircularProgressBar walletCircularProgressBar;
        LottieAnimationView lottieAnimationView;
        this.E = true;
        this.C = false;
        this.D = false;
        View view = getView();
        if (!(view == null || (lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.success_animation)) == null)) {
            net.one97.paytm.wallet.rateMerchant.utils.b.b(lottieAnimationView);
        }
        View view2 = getView();
        if (!(view2 == null || (walletCircularProgressBar = (WalletCircularProgressBar) view2.findViewById(R.id.pb_pending)) == null)) {
            net.one97.paytm.wallet.rateMerchant.utils.b.b(walletCircularProgressBar);
        }
        View view3 = getView();
        if (!(view3 == null || (relativeLayout = (RelativeLayout) view3.findViewById(R.id.resend_confirmation_payment)) == null)) {
            net.one97.paytm.wallet.rateMerchant.utils.b.a(relativeLayout);
        }
        View view4 = getView();
        if (!(view4 == null || (textView3 = (TextView) view4.findViewById(R.id.tv_status_msg)) == null)) {
            textView3.setText(getString(R.string.paid_successfully_to));
        }
        View view5 = getView();
        if (!(view5 == null || (textView2 = (TextView) view5.findViewById(R.id.tv_status_msg)) == null)) {
            Activity activity = this.f51099f;
            if (activity == null) {
                kotlin.g.b.k.a("mActivity");
            }
            textView2.setTextColor(androidx.core.content.b.c(activity, R.color.black));
        }
        View view6 = getView();
        if (!(view6 == null || (imageView2 = (ImageView) view6.findViewById(R.id.ic_payment_status)) == null)) {
            Activity activity2 = this.f51099f;
            if (activity2 == null) {
                kotlin.g.b.k.a("mActivity");
            }
            imageView2.setBackground(androidx.core.content.b.a((Context) activity2, R.drawable.payment_done_00048));
        }
        View view7 = getView();
        if (!(view7 == null || (imageView = (ImageView) view7.findViewById(R.id.ic_payment_status)) == null)) {
            net.one97.paytm.wallet.rateMerchant.utils.b.a(imageView);
        }
        View view8 = getView();
        if (!(view8 == null || (textView = (TextView) view8.findViewById(R.id.tv_status_desc)) == null)) {
            net.one97.paytm.wallet.rateMerchant.utils.b.b(textView);
        }
        d();
        net.one97.paytm.p2mNewDesign.f.k kVar = this.f51101h;
        if (kVar != null) {
            kVar.c();
        }
        j();
        net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
        net.one97.paytm.p2mNewDesign.h.a.a("success");
        e();
        net.one97.paytm.p2mNewDesign.h.a aVar2 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
        Activity activity3 = this.f51099f;
        if (activity3 == null) {
            kotlin.g.b.k.a("mActivity");
        }
        Context context = activity3;
        Bundle arguments = getArguments();
        if (arguments == null) {
            kotlin.g.b.k.a();
        }
        net.one97.paytm.p2mNewDesign.h.a.a(context, arguments.getBoolean("is_offline_pg", false), this.x);
        a(str2, str, this.r);
        g();
        h();
        net.one97.paytm.p2mNewDesign.h.a aVar3 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
        net.one97.paytm.p2mNewDesign.h.a.a("offline_payments", "post_payment_success_shown", getContext(), "home/pay-send/payment-success");
    }

    private final void b(String str, String str2, String str3) {
        LottieAnimationView lottieAnimationView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        this.C = true;
        View view = getView();
        if (!(view == null || (textView5 = (TextView) view.findViewById(R.id.tv_status_msg)) == null)) {
            textView5.setText(getString(R.string.payment_pending));
        }
        View view2 = getView();
        if (!(view2 == null || (textView4 = (TextView) view2.findViewById(R.id.tv_status_msg)) == null)) {
            Activity activity = this.f51099f;
            if (activity == null) {
                kotlin.g.b.k.a("mActivity");
            }
            textView4.setTextColor(androidx.core.content.b.c(activity, R.color.color_ffa400));
        }
        View view3 = getView();
        if (!(view3 == null || (textView3 = (TextView) view3.findViewById(R.id.tv_status_desc)) == null)) {
            textView3.setText(str3);
        }
        View view4 = getView();
        if (!(view4 == null || (textView2 = (TextView) view4.findViewById(R.id.tv_status_desc)) == null)) {
            Activity activity2 = this.f51099f;
            if (activity2 == null) {
                kotlin.g.b.k.a("mActivity");
            }
            textView2.setBackgroundColor(androidx.core.content.b.c(activity2, R.color.color_fdfbd3));
        }
        View view5 = getView();
        if (!(view5 == null || (textView = (TextView) view5.findViewById(R.id.tv_status_desc)) == null)) {
            net.one97.paytm.wallet.rateMerchant.utils.b.a(textView);
        }
        View view6 = getView();
        if (!(view6 == null || (lottieAnimationView = (LottieAnimationView) view6.findViewById(R.id.success_animation)) == null)) {
            net.one97.paytm.wallet.rateMerchant.utils.b.b(lottieAnimationView);
        }
        if (str != null) {
            b(str, str2);
        }
        net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
        net.one97.paytm.p2mNewDesign.h.a.a("offline_payments", "post_payment_pending_shown", getContext(), "home/pay-send/payment-pending");
    }

    public final void a(String str, String str2) {
        TextView textView;
        TextView textView2;
        WalletCircularProgressBar walletCircularProgressBar;
        TextView textView3;
        TextView textView4;
        LottieAnimationView lottieAnimationView;
        ImageView imageView;
        ImageView imageView2;
        this.D = true;
        this.C = false;
        View view = getView();
        if (!(view == null || (imageView2 = (ImageView) view.findViewById(R.id.ic_payment_status)) == null)) {
            Activity activity = this.f51099f;
            if (activity == null) {
                kotlin.g.b.k.a("mActivity");
            }
            imageView2.setBackground(androidx.core.content.b.a((Context) activity, R.drawable.ic_failed_copy));
        }
        View view2 = getView();
        if (!(view2 == null || (imageView = (ImageView) view2.findViewById(R.id.ic_payment_status)) == null)) {
            net.one97.paytm.wallet.rateMerchant.utils.b.a(imageView);
        }
        View view3 = getView();
        if (!(view3 == null || (lottieAnimationView = (LottieAnimationView) view3.findViewById(R.id.success_animation)) == null)) {
            net.one97.paytm.wallet.rateMerchant.utils.b.b(lottieAnimationView);
        }
        View view4 = getView();
        if (!(view4 == null || (textView4 = (TextView) view4.findViewById(R.id.tv_status_msg)) == null)) {
            textView4.setText(getString(R.string.payment_failed_wallet));
        }
        View view5 = getView();
        if (!(view5 == null || (textView3 = (TextView) view5.findViewById(R.id.tv_status_msg)) == null)) {
            Activity activity2 = this.f51099f;
            if (activity2 == null) {
                kotlin.g.b.k.a("mActivity");
            }
            textView3.setTextColor(androidx.core.content.b.c(activity2, R.color.color_fd5c5c));
        }
        View view6 = getView();
        if (!(view6 == null || (walletCircularProgressBar = (WalletCircularProgressBar) view6.findViewById(R.id.pb_pending)) == null)) {
            net.one97.paytm.wallet.rateMerchant.utils.b.b(walletCircularProgressBar);
        }
        if (str2 != null) {
            View view7 = getView();
            if (!(view7 == null || (textView2 = (TextView) view7.findViewById(R.id.tv_status_desc)) == null)) {
                net.one97.paytm.wallet.rateMerchant.utils.b.a(textView2);
            }
            View view8 = getView();
            if (!(view8 == null || (textView = (TextView) view8.findViewById(R.id.tv_status_desc)) == null)) {
                textView.setText(str2);
            }
        }
        net.one97.paytm.p2mNewDesign.h.a aVar = net.one97.paytm.p2mNewDesign.h.a.f51295a;
        net.one97.paytm.p2mNewDesign.h.a.a(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
        net.one97.paytm.p2mNewDesign.h.a aVar2 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
        net.one97.paytm.p2mNewDesign.h.a.a(getContext(), str);
        net.one97.paytm.p2mNewDesign.h.a aVar3 = net.one97.paytm.p2mNewDesign.h.a.f51295a;
        net.one97.paytm.p2mNewDesign.h.a.a("offline_payments", "post_payment_failure_shown", getContext(), "home/pay-send/payment-failed");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class o<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f51115a;

        o(e eVar) {
            this.f51115a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f51115a.a((kotlin.g.a.b<? super Activity, kotlin.x>) new i(this.f51115a));
        }
    }

    public static final /* synthetic */ void a(e eVar, MerchantPPReviewData merchantPPReviewData) {
        if (eVar.isResumed() && merchantPPReviewData != null) {
            b.a aVar = net.one97.paytm.wallet.rateMerchant.b.f71619a;
            b.a.a(eVar.f51096b, merchantPPReviewData).show(eVar.getChildFragmentManager(), "PostTxnFeedbackFragment");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r2 = r18.getResponse();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.p2mNewDesign.d.e r17, net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponse r18) {
        /*
            r0 = r17
            r1 = 0
            if (r18 == 0) goto L_0x0010
            net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r2 = r18.getResponse()
            if (r2 == 0) goto L_0x0010
            java.lang.String r2 = r2.getTXNAMOUNT()
            goto L_0x0011
        L_0x0010:
            r2 = r1
        L_0x0011:
            java.lang.String r9 = r0.f((java.lang.String) r2)
            net.one97.paytm.p2mNewDesign.h.a r2 = net.one97.paytm.p2mNewDesign.h.a.f51295a
            if (r18 == 0) goto L_0x0024
            net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r2 = r18.getResponse()
            if (r2 == 0) goto L_0x0024
            java.lang.String r2 = r2.getTXNDATE()
            goto L_0x0025
        L_0x0024:
            r2 = r1
        L_0x0025:
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
            long r10 = net.one97.paytm.p2mNewDesign.h.a.a((java.lang.String) r2, (java.lang.String) r3)
            net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel r2 = new net.one97.paytm.wallet.chatintegration.ChatPaymentIntegrationResponseModel
            if (r18 != 0) goto L_0x0033
            kotlin.g.b.k.a()
        L_0x0033:
            net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r3 = r18.getResponse()
            java.lang.String r4 = "statusResponse!!.response"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r4 = r3.getSTATUS()
            java.lang.String r3 = "statusResponse!!.response.status"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            java.lang.String r5 = r0.aj
            r6 = 0
            java.lang.String r7 = r0.ak
            r8 = 0
            net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r3 = r18.getResponse()
            java.lang.String r12 = "statusResponse.response"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r12)
            java.lang.String r12 = r3.getSTATUS()
            java.lang.String r3 = "statusResponse.response.status"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r3)
            net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r3 = r18.getResponse()
            if (r3 == 0) goto L_0x006d
            java.lang.String r3 = r3.getORDERID()
            r13 = r3
            goto L_0x006e
        L_0x006d:
            r13 = r1
        L_0x006e:
            net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r3 = r18.getResponse()
            if (r3 == 0) goto L_0x007a
            java.lang.String r3 = r3.getTXNID()
            r14 = r3
            goto L_0x007b
        L_0x007a:
            r14 = r1
        L_0x007b:
            r15 = 0
            net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponseBody r3 = r18.getResponse()
            if (r3 == 0) goto L_0x0086
            java.lang.String r1 = r3.getRESPMSG()
        L_0x0086:
            r16 = r1
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16)
            r0.ai = r2
            r17.p()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.d.e.a(net.one97.paytm.p2mNewDesign.d.e, net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus.CJRMerchantTransactionStatusResponse):void");
    }

    public static final /* synthetic */ void j(e eVar) {
        Intent intent = new Intent("chat-pay-broadcast-receiver-callback");
        intent.putExtra("chat_txn_response", eVar.ai);
        Activity activity = eVar.f51099f;
        if (activity == null) {
            kotlin.g.b.k.a("mActivity");
        }
        androidx.localbroadcastmanager.a.a.a((Context) activity).a(intent);
    }
}
